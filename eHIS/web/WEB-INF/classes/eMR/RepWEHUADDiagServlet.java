/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Timestamp;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Hashtable;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import eCommon.XSSRequestWrapper;

public class RepWEHUADDiagServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
    PrintWriter out;
    Properties p;
    String facilityId ;
    String client_ip_address ;
	HttpSession session;
	String sStyle="";

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        try
        {
            this.out = res.getWriter();   
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			session = req.getSession(false);
			sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
            String params = req.getQueryString() ;
            String source = url + params ;

            out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../eMP/js/MPAuditTrialParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
        }
        catch(Exception e)  
		{ 
			//System.out.println(e.getMessage());
			
			e.printStackTrace();
		}
    }



	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        session = req.getSession(false);
        this.facilityId = (String) session.getValue( "facility_id" ) ;
        this.p = (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        try
        {			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			insertAuditLog(req);
        }
        catch(Exception e)
        {
            //out.println(e.toString());
			e.printStackTrace();
        }
    }



	private void insertAuditLog(HttpServletRequest req)
	{
		
		Connection			con		= null;
		Statement			Stmt	= null;
		PreparedStatement	pstmt	= null;
		ResultSet			rset	= null;
		int count = 0;

		try
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);

			String report_id	=  checkForNull(req.getParameter("call_function"));
			String patient_id	=  checkForNull(req.getParameter("PatientId"));
			String encounter_id =  checkForNull(req.getParameter("Encounter_Id"));
			String diag_code	=  checkForNull(req.getParameter("diag_code"));	

			int recordNo		=  Integer.parseInt(checkForNull(req.getParameter("recordNo")));
			String onset_dt		=  checkForNull(req.getParameter("onset_dt"+recordNo));	
			String report_taken_fcy_id	= facilityId;
			String report_taken_user_id = p.getProperty( "login_user" ) ;
			String report_taken_ws_no	= client_ip_address;

			try
			{
				int srl_no = 0;
				String Sql=" select NVL(MAX(SRL_NO),0)+1 from MR_REPORT_TAKEN_AUDIT_LOG where report_id = '"+report_id+"' and facility_id='"+facilityId+"' ";

				Stmt = con.createStatement() ;
				rset = Stmt.executeQuery(Sql) ;

				if( rset !=null )
				{
					while(rset.next())
					{
						srl_no	= rset.getInt(1);
					}
				}

				if (rset != null)  rset.close();
				if (Stmt != null)  Stmt.close();

				StringBuffer sbSql = new StringBuffer();
				sbSql.append(" insert into  MR_REPORT_TAKEN_AUDIT_LOG ");
				sbSql.append("(REPORT_ID, SRL_NO, REPORT_TAKEN_USER_ID, REPORT_TAKEN_WS_NO, REPORT_TAKEN_FCY_ID, REPORT_TAKEN_DATE_TIME, PATIENT_ID, ENCOUNTER_ID, DIAG_CODE,FACILITY_ID) VALUES (?,?,?,?,?,sysdate,?,?,?,?) ");

				if (pstmt != null)  pstmt = null;
				pstmt = con.prepareStatement(sbSql.toString());

				pstmt.setString ( 1, report_id );
				pstmt.setInt	( 2, srl_no );
				pstmt.setString ( 3, report_taken_user_id);
				pstmt.setString	( 4, report_taken_ws_no);
				pstmt.setString	( 5, report_taken_fcy_id);
				pstmt.setString ( 6, patient_id);
				pstmt.setString ( 7, encounter_id );
				pstmt.setString ( 8, diag_code);
				pstmt.setString ( 9, facilityId);

				count = pstmt.executeUpdate();
				if(count > 0)
				{
					con.commit();
					doOnlineReports(report_id,patient_id,encounter_id,diag_code,onset_dt);
					String msg = "";
					Hashtable message = MessageManager.getMessage( con, "MR_NEXT_REPORT" ) ;
					msg = (String) message.get("message") ;
					msg= msg.substring(0,msg.indexOf("<br>")) ;
					out.print("<script>var truthBeTold = window.confirm(\""+msg+"\");</script>");
					out.print("<script>if(!truthBeTold)parent.window.close();</script>");
					if ( message != null ) message.clear();
				}
				else 
				{
					con.rollback();
				}

				if (pstmt != null)  pstmt.close();

			}catch(Exception e1)
			{
				e1.printStackTrace();
				con.rollback() ;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			//out.print(e);
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,req);
		}
	}

	private void doOnlineReports(String report_ID, String patient_ID, String encounter_ID, String diag_Code, String onset_date) throws ServletException, IOException, SQLException
	{
		facilityId	= (String) session.getValue( "facility_id" ) ;
		String sqlString	= "";		
		String reportParamNames	= "";
		String reportParamValues= "";

		try
		{
			if(report_ID.equals("MRBWEHUA"))
			{
				//MRBWEHUA - WEHU - A1 / A2 Function name
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBWEHUA' ";
			}
			else if(report_ID.equals("MRBWEHUD"))
			{
				//MRBWEHUD - WEHU - D1 / D2 Function name
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBWEHUD' ";
			}
			else if(report_ID.equals("MRBCANNT"))
			{
				//MRBCANNT - Cancer Notification / Registry Form 
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id = 'MRBCANNT' ";
			}

			reportParamNames = "p_patient_id,p_encounter_id,p_diag_code,p_facility_id,p_date_of_occurance";
			
			reportParamValues = ""+patient_ID+","+encounter_ID+","+diag_Code+","+facilityId+","+onset_date+"";
			
			StringBuffer htmlFor = new StringBuffer();
			
			htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link> ");
			htmlFor.append("</head><body class	='message'> ");
			htmlFor.append("<script language	= 'JavaScript'> ");
			htmlFor.append("  var dialogHeight	= '25'; ");
			htmlFor.append("  var dialogWidth	= '65'; ");
			htmlFor.append("  var dialogTop		= '58'; ");
			htmlFor.append("  var arguments		=	''; ");
			htmlFor.append("  var getUrl		=	'../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&EncounterId="+encounter_ID+" '; ");
			htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ; ");
			htmlFor.append("retVal = window.showModalDialog(getUrl,arguments,features); ");
			htmlFor.append(" </script> ");
			out.println(htmlFor.toString());
			out.println(" </body></html> ");
		}
		catch ( Exception e )
		{
			//out.println("Encountered error while Processing Online Reports "+e.toString());
			
			e.printStackTrace();
		}
	} 

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
}

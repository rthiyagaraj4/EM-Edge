/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
//import eAM.SPPractitioner.*;
//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;


public class OPSPServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	java.util.Properties p;
	String  pract ;
	String splcode;
	String facilityId;
	/// Added By Ush
	String facilityID="";
	String finalPractList="";
	Connection con;
	String client_ip_address ;
String locale="";

	//String serviceURL;
	//String objectName;
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		//MMS-ME-SCF-0096 vulnerability Issue
		req= new XSSRequestWrapper(req); 
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//MMS-ME-SCF-0096 vulnerability Issue
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		//serviceURL=(String) session.getValue("serviceURL");
 locale= p.getProperty("LOCALE");
		try
		{
			con = ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");

			if ( operation.equals("insert") )   insertOPSP(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
		finally
				{
				    ConnectionManager.returnConnection(con, req);
        		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}*/

	private void insertOPSP(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{

			    PreparedStatement pslPrepStmtdel=null;
			    PreparedStatement stmtdel=null;
			 //   ResultSet rset ;
			String practId="",selectYN="",delInsYN="";
			PreparedStatement pslPrepStmt = null;
			RecordSet	accessRightRecSet	=	null;
			accessRightRecSet	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AXSRightRecSet");
			finalPractList = req.getParameter("finalPractList");
			if(finalPractList == null) finalPractList="";

			out.println("finalPractList "+ finalPractList);
			StringTokenizer mainTkn = new StringTokenizer(finalPractList,"~");
			int maintkns= mainTkn.countTokens();
			for(int main=0;main<maintkns;main++)
			{
				String sub1=mainTkn.nextToken();
				accessRightRecSet.putObject(sub1);
		    }

			splcode=req.getParameter("splty_code");
			facilityID=req.getParameter("facility_id");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

				HashMap tabdata=new HashMap();
				tabdata.put("facility_id",addedFacilityId);
				tabdata.put("speciality_code",splcode);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",added_date);
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("facilityID",facilityID);

				String totCount	=	""+accessRightRecSet.getSize();
					if(totCount.equals("")) totCount="0";

				tabdata.put("totCount", new Integer(totCount) );
				out.println("Count "+ accessRightRecSet.getSize());

			for(int j=0;j<accessRightRecSet.getSize();j++)
			{
				out.println((String)accessRightRecSet.getObject(j));
				tabdata.put(("chk"+j),(String)accessRightRecSet.getObject(j));
			}

				int ilStatus = 0;
				String sql=	" insert into am_pract_specialities( "+
						"  facility_id				"+
						" , practitioner_id		"+
						" , speciality_code		"+
						" , added_by_id			"+
						" , added_date				"+
						" , added_at_ws_no		"+
						" , added_facility_id	"+
						" , modified_by_id		"+
						" , modified_date			"+
						" , modified_at_ws_no	"+
						" , modified_facility_id ) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
				pslPrepStmt = con.prepareStatement(sql);

				String delSql= "delete from am_pract_specialities where facility_id =? and practitioner_id= ? and speciality_code= ? ";
				pslPrepStmtdel = con.prepareStatement(delSql);
				stmtdel = con.prepareStatement(delSql);
				
				String chkYN = "";
               if (Integer.parseInt(totCount) != 0)
				   {
					for(int i=0; i<Integer.parseInt(totCount); i++)
						{
						chkYN = (String)tabdata.get("chk"+i);
						StringTokenizer st =new StringTokenizer(chkYN,"$");
						practId=st.nextToken();
						
						selectYN=st.nextToken();
						delInsYN=st.nextToken();
						if(selectYN.equals("Y") && (delInsYN.equals("N") || delInsYN.equals("Y")))
						{
							stmtdel.setString(1,(String)tabdata.get("facilityID"));
							stmtdel.setString(2,practId);
							stmtdel.setString(3,splcode);
						ilStatus = stmtdel.executeUpdate();
                    //   if(stmtdel!=null) stmtdel.close();//ADDED BY RAJESH 8/11/2004 

						pslPrepStmt.setString(1,(String)tabdata.get("facilityID"));
						pslPrepStmt.setString(2,practId);
						pslPrepStmt.setString(3,splcode);
						pslPrepStmt.setString(4,addedById);
						pslPrepStmt.setString(5,modifiedAtWorkstation);
						pslPrepStmt.setString(6,modifiedFacilityId);
						pslPrepStmt.setString(7,addedById);
						pslPrepStmt.setString(8,modifiedAtWorkstation);
						pslPrepStmt.setString(9,modifiedFacilityId);
						ilStatus = pslPrepStmt.executeUpdate();
                       //   if(pslPrepStmt!=null) pslPrepStmt.close();//ADDED BY RAJESH 8/11/2004 
 
						}
						else if(selectYN.equals("N") && (delInsYN.equals("Y")|| delInsYN.equals("N")))
						{
							pslPrepStmtdel.setString(1,(String)tabdata.get("facilityID"));
							pslPrepStmtdel.setString(2,practId);
							pslPrepStmtdel.setString(3,splcode);
							ilStatus=pslPrepStmtdel.executeUpdate();
						//	 if(pslPrepStmt!=null) pslPrepStmt.close();//ADDED BY RAJESH 8/11/2004 
						}

					}
						if(pslPrepStmt!=null) pslPrepStmt.close();
						if(pslPrepStmtdel!=null) pslPrepStmtdel.close();
				}
				String s20 = "";
				if(ilStatus == 1){
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				s20 = (String)message.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20,"UTF-8" ) + "&err_value=1");
                message.clear();
				}else{
					con.rollback();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=1");
				}

				tabdata.clear();
		/*	InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SPPractitioner");
			SPPractitionerHome sppractitionerHome  = (SPPractitionerHome) PortableRemoteObject.narrow(homeObject ,SPPractitionerHome.class);
			SPPractitionerRemote sppractitionerRemote = sppractitionerHome.create();
			java.util.Hashtable results = sppractitionerRemote.addModifysppractitioner(p,tabdata);

			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;

			String error="" ;
			String error_value = "0" ;
			error = (String) results.get("message") ;
			if(error == null) error="";
			out.println("error"+ error);
                    if ( inserted ) {
                         error_value = "1" ;
                    } else {
                         error = (String) results.get("error") ;
                         if(error == null) error="";
                    }
                  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );

		*/
		 if(stmtdel!=null) stmtdel.close();
		if(pslPrepStmt!=null) pslPrepStmt.close();
	

		}
		catch ( Exception e )
		{

			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( pract+ " "+splcode );
			e.printStackTrace();
		}
	}


}

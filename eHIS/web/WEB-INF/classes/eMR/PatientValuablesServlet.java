/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer; 
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession;
import com.ehis.util.*;

import eCommon.XSSRequestWrapper;

public class PatientValuablesServlet extends HttpServlet {
	
    PrintWriter out;
	Connection con=null;
	Statement stmt=null;
	PreparedStatement preStatement=null;
	PreparedStatement pstmt=null;
    Properties p;
    String patientId = "";
    String encounterId = "";
    String recordedBy = "";
    String recordedTime = "";
    String remarks = "";
    String witnessid = "";
    String facilityId;
    String client_ip_address;
    HttpSession session;
    //SimpleDateFormat dateFormat;
	String returned_yn="";
	String returned_id="";
	String returned_date="";
	String sStyle="";
	String call_function="";
	
	String received_witnessid=""; //Added for this CRF HSA-CRF-0222 [IN:050567]
	//java.util.Date date1_new=null;
	//java.util.Date date2_new=null;
 			
    //boolean inserted		= false;

	String locale = "";
    public PatientValuablesServlet() {
       // dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void init(ServletConfig servletconfig) throws ServletException {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException 
	{
		httpservletrequest.setCharacterEncoding("UTF-8");
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		
			httpservletrequest= new XSSRequestWrapper(httpservletrequest);
			httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
			httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
		
		session = httpservletrequest.getSession(false);
		sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
        facilityId = (String)session.getValue("facility_id");
        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
       	locale = p.getProperty("LOCALE");
		try 
		{
			con = ConnectionManager.getConnection(httpservletrequest);
			con.setAutoCommit(false);
			stmt=con.createStatement();			
			out = httpservletresponse.getWriter();
			returned_yn = httpservletrequest.getParameter("returned");
			if(returned_yn == null) returned_yn = "N";
			returned_id = httpservletrequest.getParameter("returnedby");
			if(returned_id == null) returned_id = "";
			returned_date = httpservletrequest.getParameter("returned_datetime");
			if(returned_date == null) returned_date = "";
			returned_date = DateUtils.convertDate(returned_date,"DMYHM",locale,"en");
			
			call_function = httpservletrequest.getParameter("call_function");
			if(call_function == null) call_function = "";
			//SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			if(!returned_date.equals(""))
			{
				//date1_new = simpledateformat.parse(returned_date);
				//date2_new =new java.sql.Date(date1_new.getTime());
			}
			patientId = httpservletrequest.getParameter("patientId");
			if(patientId == null) patientId = "";

			encounterId = httpservletrequest.getParameter("encounterId");
			if(encounterId == null) encounterId = "";

			recordedBy = httpservletrequest.getParameter("recordedBy");
			if(recordedBy == null) recordedBy = "";

			recordedTime = httpservletrequest.getParameter("recordedTime");
			if(recordedTime == null) recordedTime = "";
			recordedTime = DateUtils.convertDate(recordedTime,"DMYHM",locale,"en");
			
			remarks = httpservletrequest.getParameter("remarks");
			if(remarks == null) remarks = "";

			witnessid = httpservletrequest.getParameter("witnessid");
			if(witnessid == null) witnessid = "";
			 //Added for this CRF HSA-CRF-0222 [IN:050567]
			received_witnessid=httpservletrequest.getParameter("received_witnessid");
			if(received_witnessid==null) received_witnessid="";

			String s = httpservletrequest.getParameter("functions");

			if(call_function.equals("REPRINT_PAT_VAL") || call_function.equals("MR_INTERNAL_REPORTS_REPRINT"))
			{
				patientId = httpservletrequest.getParameter("Pat_id");
				if(patientId == null) patientId = "";

				doOnlineReports(httpservletrequest);
			}
			else
			{
				if(s.equals("insert"))
					insertcomplaint(httpservletrequest);
				if(s.equals("modify"))
					modifycomplaint(httpservletrequest);
			}
			if ( pstmt != null ) pstmt.close();
			if ( preStatement != null ) preStatement.close();
			if ( stmt != null ) stmt.close();

        }
        catch(Exception exception) {
            //out.println(exception.toString());
			
			 exception.printStackTrace();
        }
		finally{
			if ( con != null ) ConnectionManager.returnConnection(con,httpservletrequest);
		}
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
    try 
	  {
            out = httpservletresponse.getWriter();			
            out.println("<html><head><script language=JavaScript src='../../eCommon/js/common.js'><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			doPost(httpservletrequest, httpservletresponse);

       }
        catch(Exception exception) { }
    }

    private void modifycomplaint(HttpServletRequest httpservletrequest) {
        try { 
					
			String s = recordedBy;
            //String s1 = dateFormat.format(new Date());
            String s2 = s;
            //String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;

			//Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			//Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
        
            java.util.HashMap hashmap = new HashMap();
			
			//modified for this CRF HSA-CRF-0222 [IN:050567]
			String sql = "UPDATE pr_patient_valuables SET  RETURNED_YN = ?, RETURNED_BY_ID = ?,  RETURNED_DATE = to_date(?,'dd/mm/yyyy hh24:mi') , VALUABLE_DETAILS = ?, WITNESS_ID = ?,modified_by_id = ?, modified_date=sysdate , modified_facility_id = ?, modified_at_ws_no = ?, RECEIVED_WITNESS_ID=? WHERE  ENCOUNTER_ID = ?";

			//String str2 = "UPDATE pr_patient_valuables SET  RETURNED_YN = '"+returned_yn+"', RETURNED_BY_ID = '"+returned_id+"',  RETURNED_DATE = to_date('"+returned_date+"','dd/mm/yyyy hh24:mi') , VALUABLE_DETAILS = '"+remarks+"', WITNESS_ID = '"+witnessid+"',modified_by_id = '"+s2+"', modified_date=sysdate , modified_facility_id = '"+s5+"', modified_at_ws_no = '"+s7+"' WHERE  ENCOUNTER_ID = '"+encounterId+"'";
			pstmt		=	null;
			pstmt		=	con.prepareStatement(sql);
			pstmt.setString(1,returned_yn);
			pstmt.setString(2,returned_id);
			pstmt.setString(3,returned_date);
			pstmt.setString(4,remarks);
			pstmt.setString(5,witnessid);
			pstmt.setString(6,s2);
			pstmt.setString(7,s5);
			pstmt.setString(8,s7);
			pstmt.setString(9, received_witnessid); //Added for this CRF HSA-CRF-0222 [IN:050567]
			pstmt.setString(10,encounterId);
			

			int insert1 = pstmt.executeUpdate();	
			if ( pstmt != null)
			{
				pstmt.close();
			}
			if ( insert1>0 ){
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				String msg = (String) message.get("message");				
				if ( message != null) message.clear();
				out.println("<script>alert(\""+msg+"\");</script>") ;	
			 doOnlineReports(httpservletrequest);
			out.println("<script>parent.window.close();</script>");
	    }
	    else  {
			con.rollback();
			out.println("<script>alert('Record Not Updated');</script>");
		    //out.println("<script>alert('"+error+"');</script>");
	        out.println("<script>window.close();</script>");
	    }
   	    if ( hashmap != null ) hashmap.clear();
        }
        catch(Exception exception) {
            /* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>"); */
			
			exception.printStackTrace();
        }
    }

    private void insertcomplaint(HttpServletRequest httpservletrequest) {
      try 
	  {
            String s = recordedBy;
            //String s1 = dateFormat.format(new Date());
            String s2 = s;
            //String s3 = s1;
            String s4 = facilityId;
            String s5 = s4;
            String s6 = client_ip_address;
            String s7 = s6;
			
           // java.sql.Date date = java.sql.Date.valueOf(s1);
           // java.sql.Date date1 = java.sql.Date.valueOf(s3);
            java.util.HashMap hashmap = new HashMap();
            //String sp="to_date('"+returned_date+"','dd/mm/yyyy hh24:mi')";
			
			//Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			//Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
			//nodified for this CRF HSA-CRF-0222 [IN:050567]
			String sqlString =	"INSERT INTO pr_patient_valuables (facility_id, encounter_id, PATIENT_ID, VALUABLE_DETAILS, ADDED_BY_ID, WITNESS_ID, ADDED_DATE, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, RETURNED_YN, RETURNED_BY_ID, RETURNED_DATE,RECEIVED_WITNESS_ID) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?)";

			//String str1="INSERT INTO pr_patient_valuables (facility_id, encounter_id, PATIENT_ID, VALUABLE_DETAILS, ADDED_BY_ID, WITNESS_ID, ADDED_DATE, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, RETURNED_YN, RETURNED_BY_ID, RETURNED_DATE) VALUES ('"+facilityId+"','"+encounterId+"','"+patientId+"','"+remarks+"','"+s+"','"+witnessid+"',sysdate,'"+s6+"','"+facilityId+"','"+s2+"',sysdate,'"+s7+"','"+s5+"','"+returned_yn+"','"+returned_id+"',to_date('"+returned_date+"','dd/mm/rrrr hh24:mi'))";

			preStatement		=	null;
			preStatement		=	con.prepareStatement(sqlString);
			preStatement.setString(1, facilityId);
			preStatement.setString(2, encounterId);
			preStatement.setString(3, patientId);
			preStatement.setString(4, remarks);
			preStatement.setString(5, s);
			preStatement.setString(6, witnessid);
			preStatement.setString(7, s6);
			preStatement.setString(8, facilityId);
			preStatement.setString(9, s2);
			preStatement.setString(10, s7);
			preStatement.setString(11, s5);
			preStatement.setString(12, returned_yn);
			preStatement.setString(13, returned_id);
			preStatement.setString(14, returned_date);
			preStatement.setString(15, received_witnessid); //Added for this CRF HSA-CRF-0222 [IN:050567]

			int insert1 = preStatement.executeUpdate();	
			if ( preStatement != null)
			{
				preStatement.close();
			}

			if ( insert1>0 )
			{
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				String msg = (String) message.get("message");				
				if ( message != null) message.clear();
				out.println("<script>alert(\""+msg+"\");</script>") ;	
				doOnlineReports(httpservletrequest);
				out.println("<script>window.close();</script>");
		   }
		   else
		  {
			   con.rollback();
			   out.println("<script>alert('Record Not Updated');</script>");
			   out.println("<script>window.close();</script>");
		  }
			if ( hashmap != null ) hashmap.clear();
        }
        catch(Exception exception) {
			exception.printStackTrace();
        }
    }
	private void doOnlineReports(HttpServletRequest request) throws ServletException, IOException, SQLException
    {
	    String reportParamNames = "";
		String reportParamValues = "";

		if(call_function.equals("REPRINT_PAT_VAL") || call_function.equals("MR_INTERNAL_REPORTS_REPRINT"))
		{
			patientId = request.getParameter("Pat_id");
			if(patientId == null) patientId = "";

			encounterId = request.getParameter("Enc_id");
			if(encounterId == null) encounterId = "";

		}

		reportParamNames = "p_encounter_id,p_facility_id,p_patient_id";
		reportParamValues = ""+encounterId+","+facilityId+","+patientId+"";

		StringBuffer htmlFor =new StringBuffer();
		htmlFor.setLength(0);
		
		String sqlString =" select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MR' AND REPORT_ID = 'MRBPATVL'";		
		

		String p_locn_code="";
		String p_locn_type="";
        htmlFor.append(" <html><head><script language=JavaScript src='../eCommon/js/common.js'></script> <script src='../../eHIS/eCommon/js/showModalDialog.js' language='JavaScript'></script> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link> ");
        htmlFor.append(" </head><body class='message'> ");
        htmlFor.append(" <script language = 'JavaScript'> ");
        htmlFor.append(" var dialogHeight    = '480px'; ");
        htmlFor.append(" var dialogWidth = '780px'; ");
        htmlFor.append(" var dialogTop = 58; ");
        htmlFor.append(" var arguments =   ''; ");
    	// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
        htmlFor.append(" var getUrl='../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=MR_REC_PAT_VAL&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+encounterId+"&dest_locn_type="+p_locn_type+"&dest_locn_code="+p_locn_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patientId+"';");
        htmlFor.append("var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
        //htmlFor.append("retVal = await window.showModalDialog(getUrl,arguments,features); ");
        htmlFor.append("(async () => await window.showModalDialog(getUrl, arguments, features))();");
        htmlFor.append("parent.document.getElementById('dialog_tag').close(); ");
        htmlFor.append("</script>");
        out.println(htmlFor.toString());
		htmlFor.setLength(0);
    } 
}

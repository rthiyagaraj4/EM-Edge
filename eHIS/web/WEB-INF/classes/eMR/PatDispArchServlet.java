package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.URLEncoder;
import com.ehis.util.*;

import webbeans.eCommon.*;

public class PatDispArchServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	String facilityId;
	HttpSession session; 
	Properties p;
	String client_ip_address; 

	boolean inserted		= false; 
	String mode;
	String arch_disp;     
	String action;     
	String selectedPatientIds;  
	String approval_disp_no;  
	String approval_date;  
	String actType; 
	String modifiedById;  
	String locale;  
	String modifiedAtWorkstation;
	String batchID;
    Connection con;


 
                                      
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config); 
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		    req.setCharacterEncoding("UTF-8");
	        res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
		try	{

			session 						= req.getSession(true);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
			this.facilityId = (String) session.getValue( "facility_id" ) ;

			System.err.println("facilityId==>"+facilityId);

			modifiedById	      = p.getProperty( "login_user" ) ;
			locale				  = p.getProperty("LOCALE");
			modifiedAtWorkstation  = client_ip_address ;
            
			arch_disp 	=  checkForNull(req.getParameter("arch_disp"));
			action		=  checkForNull(req.getParameter("action"));
		
			selectedPatientIds		=   checkForNull(req.getParameter("selectedPatientIds"));
			batchID					=   checkForNull(req.getParameter("batchId"));
			approval_disp_no		=   checkForNull(req.getParameter("approval_disp_no"));
			approval_date			=   checkForNull(req.getParameter("approval_date"));
			actType					=   checkForNull(req.getParameter("actType"));


			System.err.println("selectedPatientIds==>"+selectedPatientIds);
			System.err.println("arch_disp==>"+arch_disp);


			if(action.equals("approval")&& !selectedPatientIds.equals(""))
				insertDispArchApproval(req,res);
			else if(action.equals("inActive")&& !selectedPatientIds.equals(""))
				insertInActivePat(req,res);
			else if(action.equals("disposal") && !batchID.equals(""))
				dispArchPatient(req,res);
				

		}catch(Exception e){
			e.printStackTrace();
		}
	} //End of doPost

	 private void  insertDispArchApproval(HttpServletRequest req, HttpServletResponse res){
			String errorMsg	= "";
		  try{
			con = ConnectionManager.getConnection(req);

			CallableStatement genBatchIdCS = con.prepareCall("{call mp_get_disp_batch_id(?,?,?,?,?)}");
            genBatchIdCS.setString(1, facilityId);
            genBatchIdCS.setString(2, modifiedById);
            genBatchIdCS.setString(3, modifiedAtWorkstation);
			genBatchIdCS.registerOutParameter( 4,java.sql.Types.VARCHAR);
            genBatchIdCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
			try{
				genBatchIdCS.execute();
				batchID = checkForNull(genBatchIdCS.getString(4));
				errorMsg = checkForNull(genBatchIdCS.getString(5));
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}finally{
				genBatchIdCS.close();
			}
			if(errorMsg.equals("")){
			
			int result	= 0;
			int executableCount	= 0;
			
			


			String sql	="insert into MP_DISP_PEND_APPROVAL (ARCH_DISP,DISP_BATCH_ID,DISPOSE_PAT_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_FACILITY_ID,LAST_DISCH_DATE,LAST_ENC_SPECIALITY,LAST_ENC_PAT_CLASS,PAT_AGE,PAT_STATUS) values(?,?,?,?,?,sysdate,?,sysdate,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?)";
			PreparedStatement prep =  con.prepareStatement(sql);
			StringTokenizer strTok = null;
			if(!"".equals(selectedPatientIds)){
				strTok = new StringTokenizer(selectedPatientIds,",");
				while(strTok.hasMoreTokens()) {
					String patientId	= strTok.nextToken();
					int i=1;
					prep.setString(i++, arch_disp);
					prep.setString(i++, batchID);
					prep.setString(i++, patientId);
					prep.setString(i++, modifiedById);
					prep.setString(i++, modifiedAtWorkstation);
					prep.setString(i++, modifiedById);
					prep.setString(i++, modifiedAtWorkstation);
					prep.setString(i++, facilityId);
					prep.setString(i++, facilityId);
					prep.setString(i++, checkForNull(req.getParameter("last_disch_date_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("last_enc_specaility_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("last_enc_pat_class_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("pat_age_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("pat_status_"+patientId)));
					prep.addBatch();
					executableCount++;
				}
				if(executableCount>0){
					int[] no = prep.executeBatch();
					result	 = no.length;
				}
				prep.close();
	
			}
			System.err.println("result==>"+result);
			if(result > 0){ 
					con.commit();
					

					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					String error =((String) message.get("message"));
					System.err.println("error==>127==>"+error);
					 out.println("<script> alert(\""+error+"\"); </script>");
				//    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=1" );
					doOnlineReports(selectedPatientIds,"MRDESPAP");
					 out.println("<script>parent.onSuccess();</script>");


			}else{
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));
				System.err.println("error==>133==>"+error);
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=0" );
			}
			}else{
							System.err.println("errorMsg==> 184-->"+errorMsg);
							String error = errorMsg;
							if(errorMsg.equals("BATCH_ID_REACHED_MAX")) {
								java.util.Hashtable message = MessageManager.getMessage(locale, errorMsg, "MR");
								error =((String) message.get("message"));
							}
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=0" );
			}

		}catch ( Exception e ){

			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, req);
		}
	} 
	 private void  insertInActivePat(HttpServletRequest req, HttpServletResponse res){
		  try{
			con = ConnectionManager.getConnection(req);
			int result	= 0;
			int executableCount	= 0;
			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");  //unused variable
			//java.util.Date date = new java.util.Date(); //unused variable
			String patIdsTodelete	= selectedPatientIds.replaceAll(",","','");
			patIdsTodelete			= "'"+patIdsTodelete+"'";
			String sql	="insert into MP_INACTIVE_TEMP_PATIENT (INACTIVE_PAT_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_FACILITY_ID,LAST_DISCH_DATE,LAST_ENC_SPECIALITY,LAST_ENC_PAT_CLASS,PAT_AGE,PAT_STATUS) values(?,?,?,sysdate,?,sysdate,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?)";
			PreparedStatement prep =  con.prepareStatement(sql);
			StringTokenizer strTok = null;
			if(!"".equals(selectedPatientIds)){
				strTok = new StringTokenizer(selectedPatientIds,",");
				while(strTok.hasMoreTokens()) {
					String patientId	= strTok.nextToken();
					int i=1;
					prep.setString(i++, patientId);
					prep.setString(i++, modifiedById);
					prep.setString(i++, modifiedAtWorkstation);
					prep.setString(i++, modifiedById);
					prep.setString(i++, modifiedAtWorkstation);
					prep.setString(i++, facilityId);
					prep.setString(i++, facilityId);
					prep.setString(i++, checkForNull(req.getParameter("last_disch_date_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("last_enc_specaility_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("last_enc_pat_class_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("pat_age_"+patientId)));
					prep.setString(i++, checkForNull(req.getParameter("pat_status_"+patientId)));
					prep.addBatch();
					executableCount++;
				}
				if(executableCount>0){
					int[] no = prep.executeBatch();
					result	 = no.length;
				}
				prep.close();
			}
			System.err.println("result==>"+result);
			if(result > 0){ 
					con.commit();
					String delSql	= "delete from MP_INACTIVE_TEMP_PATIENT where INACTIVE_PAT_ID in("+patIdsTodelete+")";
					prep =  con.prepareStatement(delSql);
					prep.executeUpdate();
					prep.close();
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					String error =((String) message.get("message"));
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=1" );
			}else{
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=0" );
			}
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, req);
		}
	} 
	
	 private void  dispArchPatient(HttpServletRequest req, HttpServletResponse res){
		System.err.println("Here 142");
		System.err.println("batchID 142==>"+batchID);
		  try{
			con = ConnectionManager.getConnection(req);
			String patIdsTodelete	= selectedPatientIds.replaceAll(",","','");
			patIdsTodelete			= "'"+patIdsTodelete+"'";

		
			int delCnt	= 0;
			String dispInsertYN		= "N";
			String disposeDtls		= "";
			if(actType.equals("Apply")){
				dispInsertYN		= "Y";
				disposeDtls = " ,DISP_APPROVAL_NO='"+approval_disp_no+"',DISP_APPROVAL_DATE = to_date('"+approval_date+"','dd/mm/yyyy hh24:mi:ss') ";
			}

			String sql1	="update MP_DISP_PEND_APPROVAL set MODIFIED_BY_ID = '"+modifiedById+"',MODIFIED_AT_WS_NO='"+modifiedAtWorkstation+"',MODIFIED_DATE=sysdate,MODIFIED_FACILITY_ID='"+facilityId+"',DISP_INSERT_YN='"+dispInsertYN+"' "+disposeDtls+" where DISP_BATCH_ID=? and DISPOSE_PAT_ID in("+patIdsTodelete+") ";
			System.err.println("sql1 == >"+sql1);
			PreparedStatement prep1 =  con.prepareStatement(sql1);
			prep1.setString(1,batchID);
			prep1.executeUpdate();
			con.commit();

			String sql	="DELETE FROM MP_DISP_PEND_APPROVAL WHERE DISP_BATCH_ID=? and DISPOSE_PAT_ID in("+patIdsTodelete+") ";
			PreparedStatement prep =  con.prepareStatement(sql);
			prep.setString(1,batchID);
			delCnt = prep.executeUpdate();
			prep.close();
			prep1.close();

			if(delCnt > 0){ 
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					String error =((String) message.get("message"));
					System.err.println("error==>"+error);
				//	out.println("<script>parent.frames(3).document.location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script>");
				    res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=1" );

			}else{
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));
				System.err.println("error==>"+error);
				//out.println("<html><script>parent.frames(3).document.location.href =\"../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "\"</script><body class='message'></html>");
				  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  + "&err_value=0" );
			}

		}catch ( Exception e ){

			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, req);
		}
	} 


private void doOnlineReports(String P_DISPOSE_PAT_ID,String reportID) throws ServletException, IOException, SQLException
    {
		P_DISPOSE_PAT_ID = P_DISPOSE_PAT_ID.replaceAll(",",":");
		System.err.println("doOnlineReports==> called");		
		System.err.println("P_DISPOSE_PAT_ID==> P_DISPOSE_PAT_ID");		
		StringBuffer htmlFor =new StringBuffer();
		String sqlString ="select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'MR' AND REPORT_ID = '"+reportID+"'";
		System.err.println("sqlString==>"+sqlString);
		String reportParamNames = "P_DISPOSE_PAT_ID";
		String reportParamValues = ""+P_DISPOSE_PAT_ID+"";
        htmlFor .append( " <html><head> <link rel='stylesheet' type ='text/css'  href='../eCommon/html/IeStyle.css'></link>");
        htmlFor.append( "</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>") ;
		htmlFor.append("  var dialogHeight    = '25' ;");
		htmlFor.append(" var dialogWidth = '65' ;");
		htmlFor.append( "var dialogTop = 58;") ;
		htmlFor.append( "  var arguments =   ''; ");
		htmlFor.append("  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor .append( "  retVal=window.showModalDialog(getUrl,arguments,features); ");
		htmlFor .append( " </script>" ) ;
		out.println(htmlFor.toString());
		System.err.println(htmlFor.toString());
		htmlFor.setLength(0);

	} 
		 

		private String checkForNull(String inputString) {
			return (inputString==null)	?	""	:	inputString;
		}

		public static String checkForNull(String inputString, String defaultValue) {
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}



} // End of the Class

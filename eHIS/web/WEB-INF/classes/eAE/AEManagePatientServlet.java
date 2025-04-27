/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;  

import javax.naming.*; 
import javax.ejb.*;
import javax.rmi.*;  
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.sql.*; 
import eAE.AEManagePatient.*; 
import eBL.BLReportIdMapper;
import webbeans.eCommon.*;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import eCommon.XSSRequestWrapper;
 
public class AEManagePatientServlet extends HttpServlet implements SingleThreadModel {

	HttpSession		session		=	null;  
	java.io.PrintWriter	out			=	null;
	java.util.Properties	jdbc_props	=	null;
	Connection	con			=	null;
	String  locale				=	""; 
	String sStyle = "";

	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request = new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		session	=	request.getSession(false);
		out		=	response.getWriter() ;
		con = ConnectionManager.getConnection(request);
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";

	   PreparedStatement pstmt		= null;
	   ResultSet  rs				= null;
	  
	   try
       {

		  int count_enc=0;	
		  session						=	request.getSession(false);
		  jdbc_props					=	(Properties)session.getValue("jdbc") ;
 		  locale			            =   jdbc_props.getProperty("LOCALE");
		  //code change for Edge by kaviyarasan
 		 out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
 		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
 		out.println("async function callAEManagePatientServletHTML() { ");
		  String facility  = (String)session.getValue("facility_id");
		  String encounter = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");		  
		  String operation = (request.getParameter("operation_mode")==null)	? "" : request.getParameter("operation_mode");		  
		  if(operation.equals("AssignTreatmentArea")) {
			  pstmt = con.prepareStatement("select count(*) from ae_current_patient where encounter_id='"+encounter+"' and facility_id='"+facility+"'");
				rs = pstmt.executeQuery();
				while(rs!=null && rs.next()) {
				count_enc =rs.getInt(1);
				}if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();	 			
				if (count_enc>0)
				{
				managePatientQueue(request,response);
				}else
				{

					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "AE_CHECKED_OUT", "AE") ;
					String msg = ((String) mesg.get("message"));	
					out.println("src='../../eCommon/js/common.js'><body class='MESSAGE'>"+msg+"</body>");	
					mesg.clear();
				}
			}else if(operation.equals("for_admission")){
				updatePendingForAdmissionDate(request,response);
			}else if(operation.equals("InsertNewOrderColumn")){
				InsertNewOrderColumn(request,response);
				/*Added by lakshmanan for ML-MMOH-CRF-1972 on 12-07-2023*/
			} else if (operation.equals("updateCancelForAdmission")){
				updateCancelForAdmission(con,request,response);
				/*Added by lakshmanan for ML-MMOH-CRF-1972 on 12-07-2023*/
			}
			else
		   {
			managePatientQueue(request,response);
		   }
		  out.println("} callAEManagePatientServletHTML ();</script></body></html>");
		}
	  
        catch(Exception e)
        {
           e.printStackTrace();
        }
		finally {
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
	}
		
	private void managePatientQueue(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
	//	out.println ("<title>Result</title>");
		//out.println ("<body class='MESSAGE'>");

		HashMap htAEManagePatient		=	new java.util.HashMap();

		String  facility_id				=	"";
		String  login_at_ws_no			=	"";
		String  clinic_code				=	"";
		String  queue_status			=	"";
		String  practitioner_id			=	"";
		String  operation_mode			=	"";
		String  pract_for_workDay_check	=	"N";
		String  called_from_ca			=	""; 
		String episode_id ="";
		String episode_visit_num="";
		String bl_install_yn = "";
		String enable_rights_yn="";
		String pract_type1="";
		String sel_triage_yn="";
		String sel_cons_yn="";
		String patient_id="";
		String encounter_id="";
		String queue_date="";
		String brought_dead="";
		String patient_gender="";
		String priority_zone="";
		String min_age_for_lmp="";
		String year_value="";
		String isStartConsultationAppl = "";//Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623
		String isEnableDateTimeAppl = ""; //Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133

		try  {	
			login_at_ws_no				=	jdbc_props.getProperty("client_ip_address");
			facility_id					=	(String)session.getValue("facility_id");
			operation_mode				=	(request.getParameter("operation_mode")==null)	? "" : request.getParameter("operation_mode");
			clinic_code					=	(request.getParameter("clinic_code")==null) ?""	:	request.getParameter("clinic_code"			);
			queue_status					=	(request.getParameter("queue_status")==null) ?"" :	request.getParameter("queue_status"			);
			practitioner_id					=	(request.getParameter("practitioner_id")==null) ?"" :	request.getParameter("practitioner_id"		);
			called_from_ca					=	(request.getParameter("strCA")==null) ? "N" : request.getParameter("strCA");
            bl_install_yn                   = 	(request.getParameter("bl_install_yn")==null) ? "N" : request.getParameter("bl_install_yn");
            brought_dead                   = 	(request.getParameter("brought_dead")==null) ? "N" : request.getParameter("brought_dead");
			pract_for_workDay_check		=	(request.getParameter("pract_for_workDay_check")==null)		?"N":request.getParameter("pract_for_workDay_check"	);
			if(pract_for_workDay_check.equals(""))	pract_for_workDay_check="N";

			episode_id=request.getParameter("episode_id");
			if(episode_id == null) episode_id="";

			episode_visit_num=request.getParameter("episode_visit_num");
			if(episode_visit_num == null) episode_visit_num="";

			enable_rights_yn=request.getParameter("enable_rights_yn")== null ?"":request.getParameter("enable_rights_yn");
			pract_type1=request.getParameter("pract_type1")== null ?"":request.getParameter("pract_type1");
			sel_triage_yn=request.getParameter("sel_triage_yn")== null ?"N":request.getParameter("sel_triage_yn");
			sel_cons_yn=request.getParameter("sel_cons_yn")== null ?"N":request.getParameter("sel_cons_yn");
			patient_id=request.getParameter("patient_id")== null ?"":request.getParameter("patient_id");
			encounter_id=request.getParameter("encounter_id")== null ?"":request.getParameter("encounter_id");
			min_age_for_lmp=request.getParameter("min_age_for_lmp")== null ?"":request.getParameter("min_age_for_lmp");
			year_value=request.getParameter("year_value")== null ?"":request.getParameter("year_value");
			queue_date=request.getParameter("queue_date")== null ?"":request.getParameter("queue_date");
			patient_gender=request.getParameter("gender")== null ?"":request.getParameter("gender");
			priority_zone=request.getParameter("priority_value")== null ?"":request.getParameter("priority_value");
			String selection_mode=request.getParameter("selection_mode")== null ?"":request.getParameter("selection_mode");

			isStartConsultationAppl	= (request.getParameter("isStartConsultationAppl")==null)?"":request.getParameter("isStartConsultationAppl");//Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623

			htAEManagePatient.put ( "login_user_id", (String) session.getValue("login_user"));
			htAEManagePatient.put ( "locale", locale );
			htAEManagePatient.put ( "login_at_ws_no", login_at_ws_no );
			htAEManagePatient.put ( "facility_id", facility_id );
			htAEManagePatient.put ( "bl_install_yn",bl_install_yn);
			htAEManagePatient.put ( "visit_type_code",request.getParameter("visit_type_code")== null ?"":request.getParameter("visit_type_code"));
			htAEManagePatient.put ( "pract_type",request.getParameter("pract_type")== null ?"":request.getParameter("pract_type"));
			htAEManagePatient.put ( "queue_date",request.getParameter("queue_date")== null ?"":request.getParameter("queue_date"));
			htAEManagePatient.put ( "locn_code", clinic_code );
			htAEManagePatient.put ( "locn_type",request.getParameter("clinic_type")== null ?"":request.getParameter("clinic_type"));
			htAEManagePatient.put ( "practitioner_id", practitioner_id );
			htAEManagePatient.put ( "encounter_id",request.getParameter("encounter_id")== null ?"":request.getParameter("encounter_id"));

			/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
			isEnableDateTimeAppl = checkNull(request.getParameter("isEnableDateTimeAppl"));

			htAEManagePatient.put ( "isEnableDateTimeAppl",isEnableDateTimeAppl);
			
			if(("true").equals(isEnableDateTimeAppl))
			{
				htAEManagePatient.put ( "assign_tmt_area_time",checkNull(request.getParameter("assign_tmt_area_time")));
			}else
			{
				htAEManagePatient.put ( "assign_tmt_area_time",request.getParameter("sys_date_time")== null ?"":request.getParameter("sys_date_time"));
			}
			/*End ML-MMOH-CRF-1133*/

			htAEManagePatient.put ( "treatment_area_code",request.getParameter("treatment_area_code")== null ?"":request.getParameter("treatment_area_code"));
			htAEManagePatient.put ( "selection_mode",request.getParameter("selection_mode")== null ?"":request.getParameter("selection_mode"));
			htAEManagePatient.put ( "previous_status",queue_status);
			htAEManagePatient.put ( "prev_tmt_area_code",request.getParameter("prev_tmt_area_code")== null ?"":request.getParameter("prev_tmt_area_code"));
			htAEManagePatient.put ( "patient_id",request.getParameter("patient_id")== null ?"":request.getParameter("patient_id"));
			htAEManagePatient.put ( "priority_value",request.getParameter("priority_value")== null ?"":request.getParameter("priority_value"));
            
			//Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022
			htAEManagePatient.put ( "priority_code",request.getParameter("priority11")== null ?"":request.getParameter("priority11"));

			htAEManagePatient.put ( "bed_bay_no",request.getParameter("bed_bay_no")== null ?"":request.getParameter("bed_bay_no"));

			htAEManagePatient.put ("episode_id",episode_id.trim());
			htAEManagePatient.put ("episode_visit_num",episode_visit_num.trim());

			htAEManagePatient.put ("isStartConsultationAppl", isStartConsultationAppl);//Added by Thamizh selvi on 4th Oct 2017 for ML-MMOH-CRF-0623

			if(operation_mode.equals("AssignTreatmentArea")) {
				htAEManagePatient.put ( "queue_status", "02" ); 
			}
			else if(operation_mode.equals("StartConsultation")) {
			       htAEManagePatient.put ( "queue_status", "04" );
			}

			if(bl_install_yn.equalsIgnoreCase("Y"))
			{
                        //HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");                    
                        htAEManagePatient.put("fin_dtls",(HashMap)session.getAttribute("financial_details"));
            }          

			if(con==null) { 
				con  = ConnectionManager.getConnection(request);
			}
			String practWorkingYN="N";
			if(!practitioner_id.equals("") && pract_for_workDay_check.equals("Y") ) {
				java.util.HashMap practWorkingHash =ifPractitionerWorkingYN( facility_id, clinic_code	, practitioner_id,con);
				practWorkingYN=(String)practWorkingHash.get("practWorkingYN");
				practWorkingHash.clear();
			}
			if(practWorkingYN==null)	practWorkingYN="N";

		        if(practWorkingYN.equals("Y") || practitioner_id.equals("") || pract_for_workDay_check.equals("N") ){
	         		java.util.HashMap results = null;
				boolean inserted = false;
				String error_msg = "";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AEManagePatient",eAE.AEManagePatient.AEManagePatientHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[2];
				argArray[0] = jdbc_props;
				argArray[1] = htAEManagePatient;
				

				Class [] paramArray = new Class[2];
				paramArray[0] = jdbc_props.getClass();
				paramArray[1] = htAEManagePatient.getClass();
		                if(operation_mode.equals("AssignTreatmentArea")) { 
					results = (java.util.HashMap)(busObj.getClass().getMethod("assignTreatmentArea",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				} else if(operation_mode.equals("StartConsultation")) {
					results = (java.util.HashMap)(busObj.getClass().getMethod("startConsultation",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				}
   				inserted			=( ((Boolean) results.get( "status" )).booleanValue() ) ;
				error_msg		    =(String)	results.get("error") ;
				String strBLMessage = "0";
				try {
					strBLMessage = (String) results.get("bl_message");
					if ((strBLMessage == null) || (strBLMessage.equals(" "))) {
						strBLMessage = "0";
					}
				} catch (Exception exceptionBL) {
					exceptionBL.printStackTrace();
					strBLMessage = "0";
				}
				if(inserted) {
							if (bl_install_yn.equals("Y")) {
							
							String billgenlater = (String) results
									.get("billgenlater");

							String billtotalamt = (String) results
									.get("billtotalamt");

							if(billgenlater == null) billgenlater="N";
							if(billtotalamt == null) billtotalamt="N";

							String facilityId  = (String)session.getValue("facility_id");

							String str_bill_prt_format_YN = (String) results.get("bill_prt_format_YN");		
							if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
							System.err.println("str_bill_prt_format_YN:"+str_bill_prt_format_YN);

							if(str_bill_prt_format_YN.equals("Y"))
							{
								try
								{
									String pgm_id = (String) results.get("pgm_id");	
									if(pgm_id == null) pgm_id="";
									System.err.println("pgm_id:"+pgm_id);
									String session_id = (String) results.get("session_id");	
									if(session_id == null) session_id="";
									System.err.println("session_id:"+session_id);
									String pgm_date = (String) results.get("pgm_date");	
									if(pgm_date == null) pgm_date="";
									System.err.println("pgm_date:"+pgm_date);
									String mpi_id_rep = (String) results.get("mpi_id_rep");	
									if(mpi_id_rep == null) mpi_id_rep="";
									System.err.println("mpi_id_rep:"+mpi_id_rep);
									
									
									String reportId="BLRBLPRT";
									

									try{
										/* BLReportIdMapper.getReportId function used in other modules also
										 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
										 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
										 * eMP - PatientRegistrationServlet.java
										 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
										 */
										reportId=BLReportIdMapper.getReportId(con, locale,reportId, facilityId); //Added facilityId By Subha for MMS-DM-CRF-131.1
										System.out.println("AEManagePatientServlet for Report ID "+reportId);
										
									}catch(Exception e)
									{
										e.printStackTrace();
										reportId="BLRBLPRT";
										//System.err.println("Exception in AEManagePatientServlet for reportID "+e);
									}
									
						
									OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
									onlinereportParam.addParameter("p_facility_id",facilityId);
									onlinereportParam.addParameter("p_pgm_date",pgm_date);
									onlinereportParam.addParameter("p_pgm_id",pgm_id);
									onlinereportParam.addParameter("p_Session_id",session_id);
									System.err.println("Online Report onlinereportParam:"+onlinereportParam);
									OnlineReports onlinereports = new OnlineReports();
									onlinereports.add(onlinereportParam);
									System.err.println("Online Report Added:"+onlinereports);
									String strResults =  onlinereports.execute(request,response);
									System.err.println("Online Report Executed");
									System.err.println("strResults:"+strResults);

									onlinereportParam = null;
									onlinereports = null;								
								}
								catch (Exception e)
								{
									System.err.println("Error while submitting Print Job to Report Server:"+e);
								}
							}

							String htmlFor1 = " var enter_yn ; var arr = new Array(); var dialogHeight    = '90vh' ;	 var dialogWidth = '90vw' ;	var dialogTop = '10' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; "
												+" var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="
												+checkNull(request.getParameter("patient_id"))
												+"&episode_type=E"
												+"&episode_id="
												+episode_id
												+"&visit_id="
												+episode_visit_num
												+"&encounter_id="
												+checkNull(request.getParameter("encounter_id"))
												+"&pract_id="
												+practitioner_id
												+"&locn_code="
												+clinic_code
												+"&billgenlater="
												+ billgenlater
												+"&function_id=ASSIGN_PRACTITIONER"
												+"&module_id=AE"
												+"&visit_type_code="
												+ checkNull(request.getParameter("visit_type_code"))
//												+"&blnggrp="
//												+ billing_group
												+"&called_frm=OTH_MOD"
												+"';"
												+ " if('"+billgenlater+"' == 'Y') {  var retVal = await top.window.showModalDialog(getUrl,arguments,features);"
												+"}";
												

							out.println(htmlFor1);
						}
				session.removeAttribute("financial_details");
				if (!(strBLMessage.equals("0"))) {
						out.println("var blErrMsg='"+strBLMessage+"'; blErrMsg=blErrMsg.replace(/<BR>/g,'\\n');alert(blErrMsg);");		
					}
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
                String msg  = ((String) mesg.get("message"));
                out.println("alert('"+msg+"');");
				    mesg.clear();
				

					if(called_from_ca.equals("Y")) 	{
						if(selection_mode.equals("AssignTreatmentArea")){
							if(enable_rights_yn.equals("Y")&&sel_triage_yn.equals("Y")){
								out.println("top.window.document.getElementById('dialog-body').contentWindow.returnValue='"+patient_id+"&"+encounter_id+"&"+queue_date+"&"+brought_dead+"&"+patient_gender+"&"+priority_zone+"&"+min_age_for_lmp+"&"+year_value+"&"+enable_rights_yn+"&"+sel_triage_yn+"&"+sel_cons_yn+"'");
								out.println("top.window.document.getElementById('dialog_tag').close();");
							}else{
								//access rights not enabled
								out.println("top.window.document.getElementById('dialog-body').contentWindow.returnValue='"+practitioner_id+"';");
								out.println("top.window.document.getElementById('dialog_tag').close();");
							}
						}else{
								//from ca page
						out.println("top.window.document.getElementById('dialog-body').contentWindow.returnValue='"+practitioner_id+"';");
						out.println("top.window.document.getElementById('dialog_tag').close();");
						}
					} else {						
							if(enable_rights_yn.equals("Y")&&sel_triage_yn.equals("Y")){
								out.println("top.window.document.getElementById('dialog-body').contentWindow.returnValue='"+patient_id+"&"+encounter_id+"&"+queue_date+"&"+brought_dead+"&"+patient_gender+"&"+priority_zone+"&"+min_age_for_lmp+"&"+year_value+"&"+enable_rights_yn+"&"+sel_triage_yn+"&"+sel_cons_yn+"'");
								out.println("top.window.document.getElementById('dialog_tag').close();");
							}else{
								//access rights not enabled
								out.println("top.window.document.getElementById('dialog_tag').close();");
							}
							
					}
				} // end of if
				else 	{

					StringBuffer sbNew = new StringBuffer();
					String str1="";

					int firstInderr = error_msg.indexOf("<br>");

					if (firstInderr != -1) {
						firstInderr = firstInderr+4;
					}

					int lastInterr = error_msg.indexOf("<br>",firstInderr);

					if (lastInterr != -1) {

							str1 = error_msg.substring(firstInderr, lastInterr);
							sbNew.append(str1);

							int index = error_msg.lastIndexOf("<br>");

							if(index != -1) {
								index = index+4;
								str1 = error_msg.substring(index);
								sbNew.append(" , "+str1);
							}
					}
					else {
							str1 = error_msg.substring(firstInderr);
							sbNew.append(str1);
					}

					
					
					

					out.println("alert('"+sbNew.toString()+"');");
				} // end of else

				results.clear(); 
			}else if(pract_for_workDay_check.equals("Y") && practWorkingYN.equals("N")){
				
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "PRACT_IS_NOT_WORKING", "AE") ;
				String msg = ((String) mesg.get("message"));	
				out.println("alert('"+msg+"');");   
				mesg.clear();

			}
			//out.println("</body>");
			htAEManagePatient.clear(); 
		} // end of try
		catch(Exception e) {
			//out.println("Exception@Serv5: "+e);
			e.printStackTrace();
		} // end of catch
		finally {
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		} // end of finally
    } // end of method assignTreatmentArea

/***** new method added for Check Working Day logic ******/
public HashMap ifPractitionerWorkingYN(String facilityId, String assign_care_locn_code,String attend_practitioner_id ,Connection con)  throws Exception
	{
		String fileCreateSql =  "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";
		String practWorkingYN="N";
		java.util.HashMap hashFILE_NO_EXISTS=new java.util.HashMap();

		CallableStatement fileCreateCS = con.prepareCall(fileCreateSql);
            fileCreateCS.setString(1, facilityId);
            fileCreateCS.setString(2, assign_care_locn_code);
            fileCreateCS.setString(3, attend_practitioner_id);
		fileCreateCS.registerOutParameter( 4,java.sql.Types.VARCHAR);
            fileCreateCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
            
            try{
            fileCreateCS.execute();
				practWorkingYN = fileCreateCS.getString(4);
				if(practWorkingYN==null) practWorkingYN="N";
				hashFILE_NO_EXISTS.put("practWorkingYN",practWorkingYN);
 
				String P_ERR_MSG = fileCreateCS.getString(5);
                if(P_ERR_MSG==null) P_ERR_MSG="";
			    hashFILE_NO_EXISTS.put("P_ERR_MSG",P_ERR_MSG);
		}
            catch(Exception e1) {
				e1.printStackTrace();
			}
            finally{fileCreateCS.close();}
	return hashFILE_NO_EXISTS;
}//end of ifPractitionerWorkingYN
/********************************************/

	/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	private void updatePendingForAdmissionDate(HttpServletRequest req, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		Connection con			= null;
		PreparedStatement pstmt	= null;
		PreparedStatement pstmt2= null;
		PreparedStatement pstmt3= null;
		ResultSet rs = null;
		String assign_clinic_code="";
		String assign_tmt_area_code="";
		String assign_practitioner_id="";
		String assign_bed_no="";
		String service_code="";
		try{
			con = ConnectionManager.getConnection(req);	
			
			String modifiedById				= jdbc_props.getProperty( "login_user" ) ;
			String modifiedAtWorkstation	= jdbc_props.getProperty("client_ip_address") ;
			String encounterId				= checkNull(req.getParameter("encounter_id"));
			String facility_id				= (String)session.getValue("facility_id");
			String patient_id				= checkNull(req.getParameter("patient_id"));
			int result1						= 0;
			int result2						= 0;
			int result3					= 0;
			
			String updateOPPatQueSql = " UPDATE OP_PATIENT_QUEUE SET PENDNG_ADMISSION_DATE_TIME = SYSDATE, modified_by_id='"+modifiedById+"', modified_date = sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+facility_id+"' where facility_id='"+facility_id+"' AND ENCOUNTER_ID = '"+encounterId+"' ";

			String updateAECurrPatSql = " UPDATE AE_CURRENT_PATIENT SET PENDNG_ADMISSION_DATE_TIME = SYSDATE,CANCEL_FOR_ADM_BY = '' , CANCEL_FOR_ADM_REMARKS = '' , CANCEL_FOR_ADM_REASON = '' , CANCEL_ADMISSION_DATE_TIME = '', modified_by_id='"+modifiedById+"', modified_date = sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+facility_id+"' where facility_id='"+facility_id+"' AND ENCOUNTER_ID = '"+encounterId+"' ";
			pstmt	= con.prepareStatement(updateOPPatQueSql);
			result1	= pstmt.executeUpdate();

			if(pstmt!=null)pstmt.close(); //Added for checkstyle
			pstmt	= con.prepareStatement(updateAECurrPatSql);
			result2	= pstmt.executeUpdate();
			
			if(result1 > 0 && result2 > 0)
				con.commit();
			else
				con.rollback();
	
			if(pstmt!=null)pstmt.close();
			
			String fecthData="select LOCN_CODE,TREATMENT_AREA_CODE, PRACTITIONER_ID,AE_BED_NO, SERVICE_CODE  from AE_CURRENT_PATIENT where FACILITY_ID=? and ENCOUNTER_ID=?";
			pstmt2	= con.prepareStatement(fecthData);
			pstmt2.setString(1,facility_id );
			pstmt2.setString(2,encounterId );
			rs=pstmt2.executeQuery();
			
			if (rs!=null && rs.next()) {
				assign_clinic_code=checkNull(rs.getString("LOCN_CODE"));
				assign_tmt_area_code=checkNull(rs.getString("TREATMENT_AREA_CODE"));
				assign_practitioner_id=checkNull(rs.getString("PRACTITIONER_ID"));
				assign_bed_no=checkNull(rs.getString("AE_BED_NO"));
				service_code=checkNull(rs.getString("SERVICE_CODE"));
			}

			String insertAEPatMovLog=" INSERT INTO ae_pat_movement_log (FACILITY_ID , PATIENT_ID , ASSIGN_DATE , ENCOUNTER_ID , ASSIGN_CLINIC_CODE ,ASSIGN_TMT_AREA_CODE , ASSIGN_PRACTITIONER_ID , ASSIGN_BED_NO , SERVICE_CODE , ADDED_BY_ID , ADDED_DATE , ADDED_FACILITY_ID , ADDED_AT_WS_NO , FOR_ADMISSTION_STATUS , FOR_ADMISSTION_DATE_TIME) VALUES (?, ?, SYSDATE, ?, ?,?,?,?,?,?,SYSDATE,?,?,'W',SYSDATE) ";
			pstmt3	= con.prepareStatement(insertAEPatMovLog);
			pstmt3.setString(1,facility_id);
			pstmt3.setString(2,patient_id);
			pstmt3.setString(3,encounterId);
			pstmt3.setString(4,assign_clinic_code);
			pstmt3.setString(5,assign_tmt_area_code);
			pstmt3.setString(6,assign_practitioner_id);
			pstmt3.setString(7,assign_bed_no);
			pstmt3.setString(8,service_code);
			pstmt3.setString(9,modifiedById);
			pstmt3.setString(10,facility_id);
			pstmt3.setString(11,modifiedAtWorkstation);
			result3=pstmt3.executeUpdate(); 
			
			if(result3 > 0)
				con.commit();
			else
				con.rollback();
			
			if(pstmt2!=null)pstmt2.close();
			if(pstmt3!=null)pstmt3.close();
			if(rs!=null)rs.close();
			
			
			if (rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
		}catch (Exception e)
		{
			//out.println("Error in updatePendingForAdmissionDate method in AEManagePatientServlet: "+ e.toString());
			e.printStackTrace();
			try
			{
				con.rollback();
			}catch(Exception e1){}
		}
		finally{
			ConnectionManager.returnConnection(con,req);
		}
	}/*End*/

	/*Added by Thamizh selvi on 18th Apr 2018 against ML-MMOH-CRF-0658 Start*/
	private void InsertNewOrderColumn(HttpServletRequest req, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		Connection con				= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;
		ResultSet rs = null;
		try{
			con = ConnectionManager.getConnection(req);	

			String loginUser				= jdbc_props.getProperty( "login_user" ) ;
			String facilityId				= (String)session.getValue("facility_id");
			int recCnt						= Integer.parseInt(checkNull(req.getParameter("recCnt")));
			int DFCnt						= Integer.parseInt(checkNull(req.getParameter("DFCnt")));
			String field_name				= "";
			String field_desc				= "";
			
			String fetchDataSql = " select field_name, field_desc From AE_CURR_EMERG_PAT_RESULT where facility_id = 'DF' and user_id = '*ALL' and field_order between ? and ? order by Field_order asc ";

			String insertAECurrEmergPatResSql = " INSERT INTO AE_CURR_EMERG_PAT_RESULT ( FACILITY_ID, FIELD_NAME, FIELD_DESC, FIELD_ORDER, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,USER_ID) 	VALUES (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?) ";

			pstmt	=	con.prepareStatement(fetchDataSql);

			pstmt1	=	con.prepareStatement(insertAECurrEmergPatResSql);

			pstmt.setInt(1,recCnt+1);
			pstmt.setInt(2,DFCnt);
			rs = pstmt.executeQuery();
				
			int i = recCnt + 1;

			while (rs!=null && rs.next()){

				field_name = checkNull( rs.getString("field_name") );
				field_desc = checkNull( rs.getString("field_desc") );

				pstmt1.setString(1,facilityId);
				pstmt1.setString(2,field_name);
				pstmt1.setString(3,field_desc);
				pstmt1.setInt(4,i);
				pstmt1.setString(5,loginUser);
				pstmt1.setString(6,loginUser);
				pstmt1.setString(7,facilityId);
				pstmt1.setString(8,loginUser);
				pstmt1.setString(9,loginUser);
				pstmt1.setString(10,facilityId);
				pstmt1.setString(11,loginUser);

				pstmt1.addBatch();

				i++;
			}

			int[] batch_result = pstmt1.executeBatch();
			for (int j=0; j<batch_result.length; ++j )
				con.commit();

			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(rs!=null)rs.close();
				
		}catch (Exception e)
		{
			//out.println("Error in InsertNewOrderColumn method in AEManagePatientServlet: "+ e.toString());
			e.printStackTrace();
			try
			{
				con.rollback();
			}catch(Exception e1){}
		}
		finally{
			ConnectionManager.returnConnection(con,req);
		}
	}/*End*/
	
/* Added by lakshmanan for ML-MMOH-CRF-1973 US007 on 10-07-2023 start*/
	private void updateCancelForAdmission(Connection con , HttpServletRequest req, HttpServletResponse response) throws ServletException, java.io.IOException {
		PreparedStatement pstmt1	= null;
		PreparedStatement pstmt2	= null;
		PreparedStatement pstmt3	= null;
		PreparedStatement pstmt4	= null;
		PreparedStatement pstmt5	= null;
		ResultSet rs= null;
		int result1=0;
		int result2=0;
		int result3=0;
		int result5=0;
		String loggedInUser				= jdbc_props.getProperty( "login_user" ) ;
		String modifiedAtWorkstation	= jdbc_props.getProperty("client_ip_address") ;
		String patient_id				= checkNull(req.getParameter("Patient_Id"));
		String encounter_id				= checkNull(req.getParameter("encounter_id"));
		String referral_id				= checkNull(req.getParameter("referral_id"));
		String ReasonForCancellation	= checkNull(req.getParameter("ReasonForCancellation"));
		String CancelledBy				= checkNull(req.getParameter("CancelledBy1"))!=""?req.getParameter("CancelledBy1"):loggedInUser;
		String cancelForAdmissionRemarks= checkNull(req.getParameter("cancel_for_admission_remarks"));
		String facility_id				= (String)session.getValue("facility_id");
		String forIPAdmissionStatus = "3";
		String assign_clinic_code="";
		String assign_tmt_area_code="";
		String assign_practitioner_id="";
		String assign_bed_no="";
		String service_code="";
		try{
			
						
			String UpdateCancelforAdmissionSql1=" UPDATE AE_CURRENT_PATIENT SET PENDNG_ADMISSION_DATE_TIME=? , CANCEL_ADMISSION_DATE_TIME=sysdate, CANCEL_FOR_ADM_REASON=? , CANCEL_FOR_ADM_REMARKS=? , CANCEL_FOR_ADM_BY=? , modified_by_id=?, modified_date = sysdate, modified_at_ws_no=?, modified_facility_id=? where facility_id=? AND PATIENT_ID = ? AND ENCOUNTER_ID=?";
			
			pstmt1	=	con.prepareStatement(UpdateCancelforAdmissionSql1);
			pstmt1.setDate(1, null);
			pstmt1.setString(2,ReasonForCancellation);
			pstmt1.setString(3,cancelForAdmissionRemarks);
			pstmt1.setString(4,CancelledBy);
			pstmt1.setString(5,loggedInUser);
			pstmt1.setString(6,modifiedAtWorkstation);
			pstmt1.setString(7,facility_id);
			pstmt1.setString(8,facility_id);
			pstmt1.setString(9,patient_id);
			pstmt1.setString(10,encounter_id);
			result1	= pstmt1.executeUpdate();
			
			if(result1 > 0)
				con.commit();
			else
				con.rollback();
			if(pstmt1!=null)pstmt1.close();
			
			
			
			String fecthData="select LOCN_CODE,TREATMENT_AREA_CODE, PRACTITIONER_ID,AE_BED_NO, SERVICE_CODE  from AE_CURRENT_PATIENT where FACILITY_ID=? and ENCOUNTER_ID=?";
			pstmt2	= con.prepareStatement(fecthData);
			pstmt2.setString(1,facility_id );
			pstmt2.setString(2,encounter_id );
			rs=pstmt2.executeQuery();
			
			if (rs!=null && rs.next()) {
				assign_clinic_code=checkNull(rs.getString("LOCN_CODE"));
				assign_tmt_area_code=checkNull(rs.getString("TREATMENT_AREA_CODE"));
				assign_practitioner_id=checkNull(rs.getString("PRACTITIONER_ID"));
				assign_bed_no=checkNull(rs.getString("AE_BED_NO"));
				service_code=checkNull(rs.getString("SERVICE_CODE"));
			}

			String insertAEPatMovLog=" INSERT INTO ae_pat_movement_log (FACILITY_ID , PATIENT_ID , ASSIGN_DATE , ENCOUNTER_ID , ASSIGN_CLINIC_CODE ,ASSIGN_TMT_AREA_CODE , ASSIGN_PRACTITIONER_ID , ASSIGN_BED_NO , SERVICE_CODE , ADDED_BY_ID , ADDED_DATE , ADDED_FACILITY_ID , ADDED_AT_WS_NO , FOR_ADMISSTION_STATUS , FOR_ADMISSTION_DATE_TIME) VALUES (?, ?, SYSDATE, ?, ?,?,?,?,?,?,SYSDATE,?,?,'C',SYSDATE) ";
			pstmt3	= con.prepareStatement(insertAEPatMovLog);
			pstmt3.setString(1,facility_id);
			pstmt3.setString(2,patient_id);
			pstmt3.setString(3,encounter_id);
			pstmt3.setString(4,assign_clinic_code);
			pstmt3.setString(5,assign_tmt_area_code);
			pstmt3.setString(6,assign_practitioner_id);
			pstmt3.setString(7,assign_bed_no);
			pstmt3.setString(8,service_code);
			pstmt3.setString(9,loggedInUser);
			pstmt3.setString(10,facility_id);
			pstmt3.setString(11,modifiedAtWorkstation);
			result2=pstmt3.executeUpdate(); 
			
			if(result2 > 0)
				con.commit();
			else
				con.rollback();
			
			
			if(pstmt2!=null)pstmt2.close();
			if(pstmt3!=null)pstmt3.close();
			if(rs!=null)rs.close();
			
			String UpdateCancelforAdmissionSql2="UPDATE OP_PATIENT_QUEUE SET PENDNG_ADMISSION_DATE_TIME=? , modified_by_id=?, modified_date = sysdate, modified_at_ws_no=?, modified_facility_id=? where facility_id=? AND ENCOUNTER_ID =?";
			pstmt4	=	con.prepareStatement(UpdateCancelforAdmissionSql2);
			pstmt4.setDate(1, null);
			pstmt4.setString(2,loggedInUser);
			pstmt4.setString(3,modifiedAtWorkstation);
			pstmt4.setString(4,facility_id);
			pstmt4.setString(5,facility_id);
			pstmt4.setString(6,encounter_id);
			result3	= pstmt4.executeUpdate();
			
			if(result3 > 0)
				con.commit();
			else
				con.rollback();
			if(pstmt4!=null)pstmt4.close();
		
		if(referral_id!="") {
			String UpdateCancelforAdmissionSql3="UPDATE PR_REFERRAL_REGISTER SET FOR_IP_ADM_STATUS=? , modified_by_id=?, modified_date = sysdate, modified_at_ws_no=?, modified_facility_id=? where REFERRAL_ID=?";
																					
			pstmt5	=	con.prepareStatement(UpdateCancelforAdmissionSql3);
			pstmt5.setString(1,forIPAdmissionStatus);
			pstmt5.setString(2,loggedInUser);
			pstmt5.setString(3,modifiedAtWorkstation);
			pstmt5.setString(4,facility_id);
			pstmt5.setString(5,referral_id);
			result5	= pstmt5.executeUpdate();
			
			if(result5 > 0) {
				con.commit();
			}
			else {
				con.rollback();
			}
			if(pstmt5!=null)pstmt5.close();
		}
			
		}catch(Exception e1){ e1.printStackTrace();}

	}
/* Added by lakshmanan for ML-MMOH-CRF-1973 US007 on 10-07-2023 end*/

public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}
} // end of class AEManagePatientServlet 

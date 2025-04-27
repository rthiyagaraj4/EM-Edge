<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------
?             100            ?													created
22/11/2012	 IN035639		Vijayakumar k										Changes to CA - to display HTML data including result components
19/08/2015	IN054952		Karthi L											ML-BRU-SCF-1588
19/01/2018  IN066218  		PRATHYUSHA P	28/1/2018		Ramesh G			ML-MMOH-CRF-0985.1
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
08/06/2020	IN073001		Ramesh Goli		08/06/2020		Ramesh G			PMG2019-GHL-CRF-0003.2
-------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%	
	System.out.println("2----------------->InvokePatientHistory.jsp");
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN073001 Start.
	String request_num = request.getParameter("request_num") == null ? "" : request.getParameter("request_num");
	String request_line_num = request.getParameter("request_line_num") == null ? "" : request.getParameter("request_line_num");
	String direct_facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
	String updateRDExamViewRequest = request.getParameter("updateRDExamViewRequest") == null ? "N" : request.getParameter("updateRDExamViewRequest");
	String archivalYN = request.getParameter("archivalYN") == null ? "N" : request.getParameter("archivalYN"); //52176
	System.out.println("InvokePatientHistory.jsp-----------updateRDExamViewRequest-------------->"+updateRDExamViewRequest+"<-----");
	System.out.println("InvokePatientHistory.jsp-----------request_num-------------->"+request_num+"<-----");
	System.out.println("InvokePatientHistory.jsp-----------request_line_num-------------->"+request_line_num+"<-----");
	System.out.println("InvokePatientHistory.jsp-----------direct_facility_id-------------->"+direct_facility_id+"<-----");
	//IN073001 End.
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  
	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../js/CAMenu.js' language='javascript'></script>
	<!-- IN073001 Start. -->
	<%if("Y".equals(updateRDExamViewRequest)){ %>
	<script>   
		window.onbeforeunload = function() {updateRDExam('<%=direct_facility_id%>','<%=request_num%>','<%=request_line_num%>','Y');} ;
	</script>
	<%} %>
	<!-- IN073001 End. -->
<html>
<!-- <title><fmt:message key="eCA.IBAHealth.label" bundle="${ca_labels}"/> </title> -->
<%

Connection con = null;
PreparedStatement pstmt=null; 
ResultSet rset =null;

PreparedStatement pstmt1=null;
ResultSet rset1 =null;

PreparedStatement pstmt2=null; 
ResultSet rset2 =null;

String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=? and APPL_USER_PASSWORD=? ";
String strSqlValidResp = "SELECT 1 FROM SM_RESP_FOR_USER WHERE APPL_USER_ID=? AND RESP_ID=? ";
String sql_chartTitle = "select APPL_TASK_DESC from CA_APPL_TASK where option_id = ? ";

PreparedStatement pstmtValidUser = null;
PreparedStatement pstmtValidResp = null;

String client_ip_address = "";
client_ip_address = request.getRemoteAddr();
String jdbc_props = "";
String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String chartTitle = "";

String direct_login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");
String direct_login_pwd = request.getParameter("login_pwd") == null ? "" : request.getParameter("login_pwd");
String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String mode = request.getParameter("mode") == null ? "V" : request.getParameter("mode");
String limit_function_id = request.getParameter("limit_function_id") == null ? "" : request.getParameter("limit_function_id");
//out.println("mode = "+mode);
String window_name = "";
String accession_number = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");
String accession_type = request.getParameter("accession_type") == null ? "" : request.getParameter("accession_type");
String preferred_style="",facility_name="";	
String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
String visit_id = "";
String show_others_unsinged_yn = request.getParameter("show_others_unsinged_yn") == null ? "" : request.getParameter("show_others_unsinged_yn"); // added for ML-BRU-SCF-1588 [IN054952]
String senior_radiologist_yn = request.getParameter("senior_radiologist_yn") == null ? "" : request.getParameter("senior_radiologist_yn"); // added for ML-BRU-SCF-1588 [IN054952]
System.out.println("47. in InvokePatientHistory.jsp => show_others_unsinged_yn > " + show_others_unsinged_yn + " senior_radiologist_yn > " + senior_radiologist_yn);
//Start : Added by Sridhar Reddy On 05/11/2008

String note_type = request.getParameter("note_type") == null ? "" : request.getParameter("note_type");
String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num");
String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

// END : Sridhar Reddy On 05/11/2008
//IN066218 Start.
String che_default_mode=request.getParameter("che_default_mode")==null?"T":request.getParameter("che_default_mode"); 
String calling_from_2T=request.getParameter("calling_from_2T")==null?"N":request.getParameter("calling_from_2T");
String history_type=request.getParameter("history_type")==null?"":request.getParameter("history_type");
String event_class=request.getParameter("event_class")==null?"":request.getParameter("event_class");
String from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
String to_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
String newPrameters="&che_default_mode="+che_default_mode+"&calling_from_2T="+calling_from_2T+"&history_type="+history_type+"&event_class="+event_class+"&from_date="+from_date+"&to_date="+to_date+"&event_item="+event_item;
//IN066218 End.
String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561

//out.println("<script>alert('locale="+locale+"');</script>");
if (encounter_id.equals(""))
{
	if (!patient_id.equals(""))
		mode="V";
	else
	{
		out.println("<script>alert(getMessage('NO_PATIENT_ID','CA'));</script>");
		out.println("<script>window.close();</script>");
	}
}

   
String func_role_id="",practitioner_name="",pract_type="";
String location_code="",location_type="",bed_num="",room_num="",episode_type="",discharge_date="",
visit_adm_date="",episode_Status="",Sex="",Age="",Dob="",security_level="",protection_ind="",patient_class="";

session.putValue("responsibility_id",direct_resp_id);
session.putValue("facility_id",direct_facility_id);
session.putValue("login_user",direct_login_user);
session.putValue("connection_pooling_yn","Y");
Properties p = new Properties() ;
p.setProperty( "login_user",direct_login_user ) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",client_ip_address) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;



/*Enumeration enum1 =  p.propertyNames();
while(enum1.hasMoreElements())
{
	String param_name = (String)enum1.nextElement();
	
}*/

try{

	con =  ConnectionManager.getConnection(request);
	//out.println("strSqlValidUser "+strSqlValidUser);
	pstmtValidUser = con.prepareStatement(strSqlValidUser);
	pstmtValidUser.setString(1,direct_facility_id);
	pstmtValidUser.setString(2,direct_login_user.trim());
	pstmtValidUser.setString(3,direct_login_pwd.trim());
	rset = pstmtValidUser.executeQuery();
	
	if(rset !=null && rset.next()){
		
		preferred_style = rset.getString("preferred_style");
		facility_name = rset.getString("facility_name");
				
		if(facility_name == null || facility_name.equals(""))
            facility_name = "";
		//out.println("preferred_style"+preferred_style);
           if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";
		session.putValue("PREFERRED_STYLE",preferred_style);
		session.putValue("facility_name",facility_name);
		rset.close();
		pstmtValidResp = con.prepareStatement(strSqlValidResp);
		pstmtValidResp.setString(1,direct_login_user);
		pstmtValidResp.setString(2,direct_resp_id);
		rset = pstmtValidResp.executeQuery();
		if(rset !=null && rset.next()){
				
				String sql= "select  func_role_id,practitioner_name, pract_type from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id =? and func_role ='P' ";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,direct_login_user);
				rset=pstmt.executeQuery();
				if(rset !=null && rset.next())
				{
					func_role_id=rset.getString(1);
					if(func_role_id == null) func_role_id="";

					practitioner_name=rset.getString(2);
					if(practitioner_name == null) practitioner_name="";

					pract_type = rset.getString(3);
					if(pract_type == null) pract_type="";

					session.putValue("ca_practitioner_id",func_role_id);
					session.putValue("practitioner_name",practitioner_name);
					session.putValue("practitioner_type",pract_type);
					p.setProperty("clinician_id",func_role_id) ;
					String sql3="";					
					if (mode.equals("R")) 
					{
						//[IN035639] start.
						//sql3="select  A.ASSIGN_CARE_LOCN_CODE locn_code, A.ASSIGN_CARE_LOCN_TYPE locn_type, A.ASSIGN_ROOM_NUM room_num, A.ASSIGN_BED_NUM bed_num, decode(A.patient_class,'OP','O','EM','O','I') episode_type, TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') discharge_date, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') visit_adm_date, decode(A.patient_class,'OP',A.VISIT_STATUS,'EM',A.VISIT_STATUS,A.ADT_STATUS) episode_status, A.patient_class, A.SECURITY_LEVEL, A.PROTECTION_IND, B.SEX, TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY')  dob, GET_AGE(B.DATE_OF_BIRTH) age, A.OP_EPISODE_VISIT_NUM VISIT_ID FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID";
						sql3="select  A.ASSIGN_CARE_LOCN_CODE locn_code, A.ASSIGN_CARE_LOCN_TYPE locn_type, A.ASSIGN_ROOM_NUM room_num, A.ASSIGN_BED_NUM bed_num, decode(A.patient_class,'OP','O','EM','O','I') episode_type, TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') discharge_date, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') visit_adm_date, decode(A.patient_class,'OP',A.VISIT_STATUS,'EM',A.VISIT_STATUS,A.ADT_STATUS) episode_status, A.patient_class, A.SECURITY_LEVEL, A.PROTECTION_IND, B.SEX, TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY')  dob, GET_AGE(B.DATE_OF_BIRTH) age, A.OP_EPISODE_VISIT_NUM VISIT_ID FROM PR_ENCOUNTER A, MP_ALL_PATIENTS_VW B WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID";
						//[IN035639] End.	
					}
					else
					{
						//[IN035639] start.
						//sql3="select   B.SEX, TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY')  dob, GET_AGE(B.DATE_OF_BIRTH) age FROM  MP_PATIENT B WHERE B.PATIENT_ID=? ";
						
						sql3="select   B.SEX, TO_CHAR(B.DATE_OF_BIRTH,'DD/MM/YYYY')  dob, GET_AGE(B.DATE_OF_BIRTH) age FROM  MP_ALL_PATIENTS_VW B WHERE B.PATIENT_ID=? ";
						//[IN035639] End.
					}
					
					pstmt2=con.prepareStatement(sql3);
					if (mode.equals("R")) 
					{
						pstmt2.setString(1,direct_facility_id);
						pstmt2.setString(2,episode_id);
					}
					else
					{
						pstmt2.setString(1,patient_id);
					}
					
					
					rset2 = pstmt2.executeQuery();
					if(rset2.next() && rset2!=null)
					{
						if (mode.equals("R") )
					    {
							location_code=rset2.getString(1)==null?"":rset2.getString(1);
							location_type=rset2.getString(2)==null?"":rset2.getString(2);
							room_num=rset2.getString(3)==null?"":rset2.getString(3);
							bed_num=rset2.getString(4)==null?"":rset2.getString(4);
							episode_type=rset2.getString(5)==null?"":rset2.getString(5);
							discharge_date=rset2.getString(6)==null?"":rset2.getString(6);
							visit_adm_date=rset2.getString(7)==null?"":rset2.getString(7);
							episode_Status=rset2.getString(8)==null?"":rset2.getString(8);
							patient_class=rset2.getString(9)==null?"":rset2.getString(9);
							security_level=rset2.getString(10)==null?"":rset2.getString(10);
							protection_ind=rset2.getString(11)==null?"":rset2.getString(11);
							visit_id=rset2.getString("VISIT_ID")==null?"":rset2.getString("VISIT_ID");
						}
						Dob=rset2.getString("dob")==null?"":rset2.getString("dob");
						Sex=rset2.getString("SEX")==null?"":rset2.getString("SEX");
						Age=rset2.getString("age")==null?"":rset2.getString("age");
					}
					else
					{
						if (mode.equals("R") )
					    {
						  out.println("<script>alert(getMessage('NOT_VALID_ENCTRD','CA'));</script>");
						}
						else
						{
						  out.println("<script>alert(getMessage('NOT_VALID_PATID','CA'));</script>");
						}
						out.println("<script>window.close();</script>");
					}

					String child_window = "N";
					//String resp_id = direct_resp_id;
					//String facility_id = direct_facility_id;
					/*String menuchk ="FALSE";

					String menucheck = " select CA_CHECK_MENU_APPL( ?,?,?,'N','N') from dual";
					pstmt1=con.prepareStatement(menucheck);
					pstmt1.setString(1,resp_id);
					pstmt1.setString(2,facility_id);
					pstmt1.setString(3,relationship_id);
					rset1 = pstmt1.executeQuery();
					if (rset1.next())
						menuchk = rset1.getString(1);

					if (menuchk.equals("FALSE"))
					{
						out.println("<script>alert(getMessage('NO_ONE_TAB_APPL'));</script>");
						out.println("<script>location.href='../../eCommon/jsp/dmenu.jsp'</script>");
					}&*/
					// END OF CHECK FOR APPLICABLE MENUS
					if(patient_id != null || !episode_id.equals(""))
					{
							 
							 child_window = "Y";
					}

					window_name = patient_id+episode_id;

					if(mode.equals("V"))
					{
						episode_id = "";
						encounter_id="";
					}
					

					pstmt = con.prepareStatement(sql_chartTitle);
					pstmt.setString(1,limit_function_id);

					rset = pstmt.executeQuery();
					if(rset.next())
					{
						chartTitle = rset.getString(1);
					}
					if (pstmt!=null) pstmt.close();
					if (rset !=null) rset.close();
					//IN066218 Start.
					//String query_string="patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&child_window="+child_window+"&reln_req_yn=N&relationship_id="+direct_resp_id+"&mode="+mode+"&connection_reqd=Y&PQ=Y&CA=Y&location_code="+location_code+"&location_type="+location_type+"&bed_num="+bed_num+"&room_num="+room_num+"&episode_type="+episode_type+"&discharge_date="+discharge_date+"&visit_adm_date="+visit_adm_date+"&episode_Status="+episode_Status+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&security_level="+security_level+"&protection_ind="+protection_ind+"&patient_class="+patient_class+"&locale="+locale+"&window_name="+window_name+"&from_service_yn=Y&accession_num="+accession_number+"&accession_type="+accession_type+"&limit_function_id="+limit_function_id+"&chartTitle="+chartTitle+"&note_type="+note_type+"&contr_mod_accession_num="+contr_mod_accession_num+"&function_id="+function_id+"&visit_id="+visit_id+"&show_others_unsinged_yn="+show_others_unsinged_yn+"&senior_radiologist_yn="+senior_radiologist_yn; // parameter 'show_others_unsinged_yn','senior_radiologist_yn' added for ML-BRU-SCF-1588 [IN054952]
					//String query_string="patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&child_window="+child_window+"&reln_req_yn=N&relationship_id="+direct_resp_id+"&mode="+mode+"&connection_reqd=Y&PQ=Y&CA=Y&location_code="+location_code+"&location_type="+location_type+"&bed_num="+bed_num+"&room_num="+room_num+"&episode_type="+episode_type+"&discharge_date="+discharge_date+"&visit_adm_date="+visit_adm_date+"&episode_Status="+episode_Status+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&security_level="+security_level+"&protection_ind="+protection_ind+"&patient_class="+patient_class+"&locale="+locale+"&window_name="+window_name+"&from_service_yn=Y&accession_num="+accession_number+"&accession_type="+accession_type+"&limit_function_id="+limit_function_id+"&chartTitle="+chartTitle+"&note_type="+note_type+"&contr_mod_accession_num="+contr_mod_accession_num+"&function_id="+function_id+"&data[0]="+site_name+"&data[1]="+facility_name+"&data[2]="+note_desc+"&visit_id="+visit_id+"&show_others_unsinged_yn="+show_others_unsinged_yn+"&senior_radiologist_yn="+senior_radiologist_yn+newPrameters;//IN068532//IN071561

					String query_string="patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_id="+episode_id+"&child_window="+child_window+"&reln_req_yn=N&relationship_id="+direct_resp_id+"&mode="+mode+"&connection_reqd=Y&PQ=Y&CA=Y&location_code="+location_code+"&location_type="+location_type+"&bed_num="+bed_num+"&room_num="+room_num+"&episode_type="+episode_type+"&discharge_date="+discharge_date+"&visit_adm_date="+visit_adm_date+"&episode_Status="+episode_Status+"&Sex="+Sex+"&Age="+Age+"&Dob="+Dob+"&security_level="+security_level+"&protection_ind="+protection_ind+"&patient_class="+patient_class+"&locale="+locale+"&window_name="+window_name+"&from_service_yn=Y&accession_num="+accession_number+"&accession_type="+accession_type+"&limit_function_id="+limit_function_id+"&chartTitle="+chartTitle+"&note_type="+note_type+"&contr_mod_accession_num="+contr_mod_accession_num+"&function_id="+function_id+"&visit_id="+visit_id+"&show_others_unsinged_yn="+show_others_unsinged_yn+"&senior_radiologist_yn="+senior_radiologist_yn+newPrameters+"&p_review_rad_yn="+p_review_rad_yn+"&archivalYN="+archivalYN;//IN071561
					//IN066218 End.
					//IN073001 Start.
					if("Y".equals(updateRDExamViewRequest)){
					%>
					<frameset frameborder=1 framespacing=0 rows="6%,*" scrolling='auto' id='workArea' onload="updateRDExam('<%=direct_facility_id%>','<%=request_num%>','<%=request_line_num%>','N');" >
					<%}else{
					//  IN073001 End. 
					%>
					<frameset frameborder=1 framespacing=0 rows="6%,*" scrolling='auto' id='workArea' >
					<%}%>
					<!--<frame name='header' src='../../eCommon/jsp/header.jsp?called_from_ca_yn=Y&<%=query_string%>' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' > -->
					<frame name='plineFrame'  frameborder="no" src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Patient_ID=<%=patient_id%>&visit_id=<%=visit_id%>' scrolling='no' noresize></frame>
					<frame name='content' src='../../eCA/jsp/CAMain.jsp?<%=query_string%>' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='yes'>
						</frameset>
			</html>

			<%
					}// E.O.F if cond
					else
					{
						out.println("<script>alert(getMessage('INVALID_CA_USER','CA'));</script>");
						out.println("<script>window.close();</script>");			
					}

				}else{//else of RESP CHECK 
					out.println("<script>alert(getMessage('NO_RESP','CA'));</script>");
					out.println("<script>window.close();</script>");			
				}



				if(rset != null)rset.close();
				if(pstmtValidUser != null)pstmtValidUser.close();
				if(pstmtValidResp != null)pstmtValidResp.close();
			}else{//else of USER CHECK
					out.println("<script>alert(getMessage('INVALID_USER_PWD','CA'));</script>");
					out.println("<script>window.close();</script>");
			}
		}
			catch(Exception e){
				//out.println("Error "+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				if (pstmt!=null) pstmt.close();
				if (rset !=null) rset.close();

				if (pstmt1!=null) pstmt1.close();
				if (rset1 !=null) rset1.close();
				if (pstmt2!=null) pstmt2.close();
				if (rset2 !=null) rset2.close();

				if(con!=null)ConnectionManager.returnConnection(con,request);		
			}
		%>


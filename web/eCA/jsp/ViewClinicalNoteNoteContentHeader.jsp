<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/02/2012	  IN031538		 Menaka V	 In discharge summary note we have put the variable for Admitting doctor
										 but the data is not showing in the report Admitting Doctor and Attending Doctor, both Name should print in discharge summary and all other notes	
15/05/2012	  IN032721		Ramesh G		When we Click on Print Preview the Date is not displayed in the examination date component.	
22/02/2013	  IN036821		Chowminya G		  Reporting Practitioner name not coming in the CA report
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
30/11/2015	  	IN058541/IN057113	Karthi												System does not prompt for PIN in Record Charts Function	
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html> 
<head>
<title><fmt:message key="eCA.Notescontent.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String accession_num=request.getParameter("accession_num");
String function_id= request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
//out.println("<script>alert('function_id ="+function_id+"=');</script>");
String no_modal=request.getParameter("no_modal");
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num"); //[IN032721] 
String sql			="";
String sqltype			="";
Connection con		= null;
ResultSet rs		= null ,rs1 = null;
PreparedStatement stmt		= null,pstmt1 = null;
String note_type_desc ="";
String note_type      ="";
String authorized_by_name	=	"";
String print_date_time	    =	"";
String last_modified_by_name =	"";
String performed_by_name	= "";
String speciality_code	="";
String specialty_name	="";
String event_date_time	= "";
String patient_age	= "";
String patient_name	= "";
String sex	= "";
String facility_name	= "";
String note_header_desc	= "";
String med_service	= "";
String	loggedUser				= "";
String	dis_summ_disclaimer_txt				= "";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String facilityid		= ""; //(String) session.getValue("facility_id");
loggedUser              = (String) session.getValue("login_user");
String patient_class = "";
String location = "";
String speciality = "";
String admission_date = "";
String discharge_date = "";
String attend_pract = "";
String sqlSite = "";
String siteName = "";
String admitting_practitioner="";//IN031538

//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
//ML-MMOH-CRF-0335 - IN057113 - End

 sqltype= "select  (select ia.DISCLIMER_TEXT from CA_DISCLIMER_TEXT_LANG_VW ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE  and ib.NOTE_TYPE=a.note_type and language_id = ?)  DIS_SUMM_DISCLAIMER_TXT,to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time,  AM_GET_DESC.AM_PRACTITIONER(A.authorized_by_id,?,'2') Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,?) from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,AM_GET_DESC.AM_PRACTITIONER(a.last_amended_by_id,?,'1') last_modified_by_name ,(select ib.REPORT_HEADER from ca_note_group_lang_vw ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type and ib.language_id = ? )  note_header_desc,note_type,performed_by_id, AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,'1') performed_by_name, SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') service_name ,sex,get_age(date_of_birth) age,patient_name,a.facility_id facilityID from ca_encntr_note a,mp_patient b where	a.patient_id=b.patient_id and a.accession_num=?"; //IN036821 - performed_by_name to get long Description

	try
	{
		con		= ConnectionManager.getConnection(request);
		sql="SELECT a.note_content,CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc FROM ca_encntr_note a where  a.accession_num=? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,accession_num);
		rs=stmt.executeQuery();
		
		if(rs!=null)
		{
			if(rs.next())
			{
				note_type_desc=rs.getString("note_type_desc");
			}
		}


		    pstmt1	=	con.prepareStatement(sqltype);
			pstmt1.setString	(	1,	locale	);
			pstmt1.setString	(	2,	locale	);
			pstmt1.setString	(	3,	locale	);
			pstmt1.setString	(	4,	locale	);
			pstmt1.setString	(	5,	locale	);
			pstmt1.setString	(	6,	locale	);
			pstmt1.setString	(	7,	locale	);
			pstmt1.setString	(	8,	locale	);
		//	pstmt1.setString	(9,	facilityid	);			
			pstmt1.setString	(9,	accession_num );

			rs1		=	pstmt1.executeQuery();
			if(rs1.next())
			{
				event_date_time         =	rs1.getString("event_date_time");
				authorized_by_name		=	rs1.getString("Authorized_by_name");
				print_date_time			=	rs1.getString("print_date_time");
				last_modified_by_name	=	rs1.getString("last_modified_by_name");
				note_type		        =	rs1.getString("note_type");
				performed_by_name	    =	rs1.getString("performed_by_name");
				patient_age				=	rs1.getString("age");
				sex					    =	rs1.getString("sex");
				facility_name			=	rs1.getString("facility_name");
				note_header_desc		=	rs1.getString("note_header_desc");
				patient_name		    =	rs1.getString("patient_name");
				med_service			    =	rs1.getString("service_name");
				dis_summ_disclaimer_txt	=	rs1.getString("DIS_SUMM_DISCLAIMER_TXT");
				facilityid =  rs1.getString("facilityID");
				
                if(sex.equals("M"))
				sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			    else if (sex.equals("F"))
				sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			    else 
				sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(rs1 !=null) rs1.close();
			if(pstmt1 !=null) pstmt1.close();

			//sql = "select a.patient_class,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,'2') specialty_name, DECODE (a.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, a.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,?,'1'), null ) locn_name, to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,?,'2')  attending_practitioner  from pr_encounter a where a.facility_id = ? and a.ENCOUNTER_ID = ?";//IN031538
			//sql = "select a.patient_class,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,'2') specialty_name, DECODE (a.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, a.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,?,'1'), null ) locn_name, to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner  from pr_encounter a where a.facility_id = ? and a.ENCOUNTER_ID = ?";//IN031538
			sql = "select a.patient_class,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,'2') specialty_name, DECODE (a.patient_class, 'OP', op_get_desc.op_clinic(a.facility_id, a.ASSIGN_CARE_LOCN_CODE,?, '1' ),'EM',op_get_desc.op_clinic (a.facility_id, a.assign_care_locn_code,?,'1'),'IP', ip_get_desc.ip_nursing_unit (a.facility_id, a.assign_care_locn_code,?,'1' ),'DC', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,?,'1'), null ) locn_name, to_char(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.ADMIT_PRACTITIONER_ID,?,1) admitting_practitioner from pr_encounter a where a.facility_id = ? and a.ENCOUNTER_ID = ?";//IN031538
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1,locale);
			stmt.setString(2,locale);
			stmt.setString(3,locale);
			stmt.setString(4,locale);
			stmt.setString(5,locale);
			stmt.setString(6,locale);
			stmt.setString(7,locale);
			stmt.setString(8,facilityid);
			stmt.setString(9,encounter_id);// one more parameter setting is missed by someone - by Dinesh T

			rs = stmt.executeQuery();

			if(rs != null)
			{
				if(rs.next())
				{
					patient_class = rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
					speciality = rs.getString("specialty_name") == null ? "" : rs.getString("specialty_name");
					location = rs.getString("locn_name") == null ? "" : rs.getString("locn_name");
					admission_date = rs.getString("visit_adm_date") == null ? "" : rs.getString("visit_adm_date");
					discharge_date = rs.getString("DISCHARGE_DATE_TIME") == null ? "" : rs.getString("DISCHARGE_DATE_TIME");
					attend_pract = rs.getString("attending_practitioner") == null ? "" : rs.getString("attending_practitioner");
					admitting_practitioner=rs.getString("admitting_practitioner") == null ? "" : rs.getString("admitting_practitioner");//IN031538
				}
			}

			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			sqlSite = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
			stmt	=	con.prepareStatement(sqlSite);
			stmt.setString(1,locale);
			rs		=	stmt.executeQuery();
			if(rs !=null)
			{
				rs.next();
				siteName = rs.getString(1);
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}


	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src='../js/PhysicianNote.js'></script>
<script Language="JavaScript" src='../../eCA/js/ViewClinicalNote.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='heading' id='heading'>
<table border="0" width="100%" cellspacing='0' cellpadding='3' id='tb1' align='center'>
<%
if(no_modal !=null && no_modal.equals("Y")){
%>
<tr>
<td class='COLUMNHEADER' ><b><%=note_type_desc%></b></td><!-- <td class='COLUMNHEADER'  width='25%'></td><td class='COLUMNHEADER'  width='50%'></td> -->
<td class='COLUMNHEADER' align='right' width='15%'><input type="BUTTON" class="BUTTON" name="print" id="print" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="printNotes()">
<%if(!function_id.equals("SPCL_NOTE")){%>
	<input type="button" class='Button' name="open_winodow" id="open_winodow" title='Zoom' value='<fmt:message key="eCA.Zoom.label" bundle="${ca_labels}"/>+' onClick="reSize(this)"></td>
<%}%>
<input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">
</tr>
<%
}else{
%>
<tr>
<td class='white' ><b><%=note_type_desc%></b>
</td>
</tr>
<%
}

%>
</table>
<input type=hidden value='<%=facilityid%>' name='facilityid' ></input>
<input type='hidden' name ='authorized_by_name' value='<%=authorized_by_name%>' >
<input type='hidden' name ='print_date_time' value='<%=print_date_time%>' >
<input type='hidden' name ='last_modified_by_name' value='<%=last_modified_by_name%>' >
<input type="hidden" name ="performed_by_name" value="<%=performed_by_name%>">
<input type='hidden' name ='speciality_code' value='<%=speciality_code%>' >
<input type="hidden" name ="event_date_time"	value="<%=event_date_time%>">
<input type="hidden" name ="note_type"	value="<%=note_type%>">
<input type='hidden' name ='patient_age' value='<%=patient_age%>' >
<input type='hidden' name ='sex' value='<%=sex%>' >
<input type='hidden' name ='specialty_name' value='<%=specialty_name%>' >
<input type='hidden' name ='note_header_desc' value='<%=note_header_desc%>' >
<input type='hidden' name ='patient_name' value="<%=patient_name%>" >

<input type='hidden' name ='med_service' value='<%=med_service%>' >
<input type='hidden' name ='facility_name' value='<%=facility_name%>' >
<input type="hidden" name ="loggedUser"		value="<%=loggedUser%>">
<input type="hidden" name="dis_summ_disclaimer_txt" id="dis_summ_disclaimer_txt"		value="<%=dis_summ_disclaimer_txt%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="speciality" id="speciality" value="<%=speciality%>">
<input type="hidden" name="location_name" id="location_name" value="<%=location%>">
<input type="hidden" name="admission_date" id="admission_date" value="<%=admission_date%>">
<input type="hidden" name="discharge_date" id="discharge_date" value="<%=discharge_date%>">
<input type="hidden" name="attend_pract" id="attend_pract" value="<%=attend_pract%>">
<input type="hidden" name="admitting_practitioner" id="admitting_practitioner" value="<%=admitting_practitioner%>"><!-- IN031538-->
<input type="hidden" name="siteName" id="siteName" value="<%=siteName%>">
<input type="hidden" name="contr_mod_accession_num" id="contr_mod_accession_num" value="<%=contr_mod_accession_num%>">  <!-- [IN032721] -->
<input type="hidden" name="l_conf_pin_req_yn" id="l_conf_pin_req_yn" value="<%= conf_pin_req_yn %>"> <!-- ML-MMOH-CRF-0335 - IN057113 -->
</form>
</body>
</html>

<!--

For testing
update ca_encntr_note
set note_content='<HTML><HEAD><LINK rel='||''''||'stylesheet'||''''||'type='||
''''||'text/css'||''''||' 
'><body><table><tr wrap>For testing in Physican notes<For testing in Physican notesFor testing in Phy
where accession_num='01984'
/-->


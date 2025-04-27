<!DOCTYPE html>
<!--
----------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Description
----------------------------------------------------------------------------------------------------------------------------
?            	100            		?           		created
20/09/2019		IN071404		SIVABAGYAM M		RAMESH G    20/09/2019				Regression-OR/RL-Existing Orders and Attached Images
----------------------------------------------------------------------------------------------------------------------------
 
-->
<%@page import="java.sql.*,eCP.*,eCA.*,eCommon.Common.* ,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
   //This file is saved on 19/11/2005.
   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
   String locale=(String)session.getAttribute("LOCALE");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>
<html>
<head>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<title><fmt:message key="eCP.RecClinicalNotesPrintPreviewView.label" bundle="${cp_labels}"/></title>
	<style>
		ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 8pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script>

var temp_foot ="";
var temp_hdr = "";

function SysPreview()
{
	var OLECMDID = 7;
	var PROMPT =2;

	try
	{
		var oWebBrowser = document.getElementById("WebBrowser1");

		if(oWebBrowser == null)
		{
			var sWebBrowser = '<OBJECT ID = "WebBrowser1" width = 0 height =0 CLASSID ="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"> </OBJECT>';

			document.body.insertAdjacentHTML('beforeend',sWebBrowser);

			oWebBrowser = document.getElementById("WebBrowser1");
		}

		oWebBrowser.ExecWB(OLECMDID,PROMPT);
	}
	catch (e)
	{
		alert("Failed");
	}
}
	function setHeader()
	{
		t = new ActiveXObject("WScript.Shell"); 
						
		temp_hdr=t.RegRead("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header");
		temp_foot=t.RegRead("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer");
						 
		var pat_info1="Preliminary Report";
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header",pat_info1+" &bPage &p of &P" ); 
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer",  pat_info1+"&b&d");
	}

	function theEnd()
	{
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header"," &bPage &p of &P" ); 
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer",  "&u&b&d");
		window.close();
	}

</script>
</head>
<body  onLoad = "setHeader();PrevPreview()" onUnload = "theEnd()" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name = "RecClinicalNotesSectionViewForm">
<center>

<%
	java.sql.Connection			con							=	null;

	java.sql.PreparedStatement	pstmt						=	null;
	java.sql.PreparedStatement	pstPatInfo					=	null;
	java.sql.PreparedStatement	pstmt_sysdate				=	null;
	java.sql.PreparedStatement	pstmt_discharge_time		=	null;
	java.sql.PreparedStatement	pstmt_site_name     		=	null;
	java.sql.PreparedStatement	pstmt_note_header     		=	null;
	java.sql.PreparedStatement	pstmt_event     		    =	null;
	java.sql.PreparedStatement	pstmt_addendum     		    =	null;
	java.sql.PreparedStatement	pstmt_dependency   		    =	null;
	java.sql.PreparedStatement	pstmt_term_set   		    =	null;
	java.sql.PreparedStatement	pstmt_term_code  		    =	null;
	java.sql.PreparedStatement	pstmt_section_content 		=	null;


	java.sql.ResultSet			rsPatInfo			        =	null;
	java.sql.ResultSet			rs							=	null;
	java.sql.ResultSet			rset_sysdate				=	null;
	java.sql.ResultSet			rset_discharge_time			=	null;
	java.sql.ResultSet			rset_site_name				=	null;
	java.sql.ResultSet			rset_note_header			=	null;
	java.sql.ResultSet			rset_event					=	null;
	java.sql.ResultSet			rset_addendum				=	null;
	java.sql.ResultSet			rset_dependency				=	null;
	java.sql.ResultSet			rset_term_set				=	null;
	java.sql.ResultSet			rset_term_code				=	null;
	java.sql.ResultSet			rset_section_content		=	null;
	
	String note_type				=	"",	query_section_details	=	"";
	String sec_hdg_desc			=	"",	child_sec_hdg_desc		=	"";
	String sec_content_type		=	"",	section_content			=	"";
	String editor_title			=	"";
	String child_sec_content_type	=	"";
	String image_linked_yn			=	"",	section_image_content	=	"";
	String preserve_format_yn = "";
	String StrDataAvlFlag	  =	"";
	String mode="";

	String sec_hdg_code =	"",	child_sec_hdg_code	=	"";
	String printDateTime ="";
	String attending_practitioner ="";
	String dischargeDateTime ="";
	String site_name ="";
	String speciality_name ="";
	String facility_name ="";
	String PrtMode = "N";
	String notes_header_desc = "";
	String patient_id = "";
	String patient_name = "";
	String patient_gender = "";
	String patient_age = "";
	String encounter_id = "";
	String episode_type = "";
	String visit_adm_date = "";
	String location_name = "";
	String discharge_summary_text ="";
	
	String strNoteTypeDesc = "";
	String strEventTitleCaption = "";
	String strEventAuthByCaption = "";
	String strEventDateTimeCaption = "";
	String strEventPerfByCaption = "";
	String strPerfPhyName	="";
	String strEventDateTime = "";
	String strMedService = "";
	String login_user_id		=	"";
	String addendumTxt		=	"";
	String strAuthoBy ="";
	String strModifyBy ="";
	String strAddendumFlag = "N";
    String dep_code="";
    String dep_desc="";
	String keys = "";			
	String term_set_id="";
	String term_set_desc="";
	String term_set_desc1="";
	String term_code="";
	String term_code_desc="";
	String flag_ss_ua="";
	String chkVal="";
	String chk_val_hid="";
	int mapSize=0;

	StringTokenizer diagToken = null;
	StringTokenizer chkToken = null;

	login_user_id = (String) session.getValue("login_user");

    //Diagnosis Data Starts now
	
	eCP.PatientAssessmentDiag diagBean = (eCP.PatientAssessmentDiag) session.getAttribute("diagBean");
				
    //Queries start now.

	String strPatInfoQuery = "select short_name patient_name,get_age(date_of_birth) patient_age,DECODE(Sex,'M','Male','F','Female','Unknown') Gender from mp_patient_mast where patient_id = ? "; 

	String strPatEncDtlQry = "select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN (SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=A.FACILITY_ID AND NURSING_UNIT_CODE=A.ASSIGN_CARE_LOCN_CODE ) ELSE (SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=A.FACILITY_ID AND CLINIC_CODE=A.ASSIGN_CARE_LOCN_CODE) END LOCN_DESC FROM PR_ENCOUNTER A WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?";

	String strDischargeTimeQuery="";

	//String strDischargeTimeQuery="select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, 	nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ?";

	String sql_site_name="select site_name from sm_site_param";

	String sql_note_header="select  (select ia.DISCLIMER_TEXT from ca_disclimer_text ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE and ib.NOTE_TYPE=a.note_type) DIS_SUMM_DISCLAIMER_TXT,null REF_LETTER_DISCLAIMER_TXT, (select SHORT_NAME from am_practitioner where practitioner_id=a.authorized_by_id) Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'')  from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,(select practitioner_name from am_practitioner where practitioner_id=a.last_amended_by_id) last_modified_by_name ,(select ib.REPORT_HEADER from ca_note_group ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type)  note_header_desc from ca_encntr_note a where a.facility_id=? and a.accession_num=?";

	String sql_event="select event_type_caption, note_type,note_type_desc, service_code, short_desc service_desc, event_class, security_level, event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, short_name performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption, event_status_caption, decode(event_status,'1','InProgress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified') event_status from ca_encntr_note_vw where facility_id = ? and accession_num = ?";

	String sql_addendum_txt="select ADDENDUM_TEXT, b.PRACTITIONER_NAME, c.RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_note_addendum a, AM_PRACTITIONER b,SM_RESP c where a.FACILITY_ID =? and ACCESSION_NUM=? and a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID";

	String sql_dependency="select short_desc from cp_dependency where dependency_code=?";

	String sql_term_set="select term_set_desc from mr_term_set where term_set_id=?";

	String sql_term_code="select short_desc from mr_term_code where term_code=?";

	//Queries end here.

	try
	{ 
		PrtMode					= "Y";
		patient_id			    = checkForNull((String)request.getParameter("patient_id"));
		attending_practitioner	= checkForNull((String)request.getParameter("practitioner_id"));
		episode_type			= checkForNull((String)request.getParameter("episode_type"));
		encounter_id			= checkForNull((String)request.getParameter("encounter_id"));
		dep_code			    = checkForNull((String)request.getParameter("dep_code"));
		chk_val_hid			    = checkForNull((String)request.getParameter("chk_val_hid"));
		mode			        = checkForNull((String)request.getParameter("mode"));

		String clinician_name	= (String)session.getValue("practitioner_name");
		String resp_name		= (String)session.getValue("resp_name");
		String facility_id		= (String)session.getValue("facility_id");

		String strKey	= patient_id + "~"+encounter_id;
		strKey = strKey.trim();

		sectionBean.getPatientSection(strKey);

		if (episode_type.equals("IP"))
		{
//            strDischargeTimeQuery="select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner from ca_ip_active_episode_vw where facility_id = ? and episode_id = ?";
            strDischargeTimeQuery="SELECT TO_CHAR (admission_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, NVL (TO_CHAR (discharge_date_time, 'dd/mm/yyyy hh24:mi'),'') discharge_date_time, a.facility_id, b.facility_name, c.short_desc specialty_name,(SELECT short_name FROM am_practitioner WHERE practitioner_id = a.cur_physician_id) attending_practitioner FROM ca_ip_active_episode_vw a, sm_facility_param_lang_vw b, am_speciality_lang_vw c WHERE a.facility_id = ? AND a.episode_id = ? AND a.FACILITY_ID=b.facility_id and c.SPECIALITY_CODE = a.SPECIALTY_CODE and b.LANGUAGE_ID =? and c.LANGUAGE_ID = b.LANGUAGE_ID";
		}
		else if(episode_type.equals("OP"))
		{
//			strDischargeTimeQuery="select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, 	nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ?";
			strDischargeTimeQuery="select to_char (adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl (to_char (DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi'),'') DISCHARGE_DATE_TIME, a.facility_id, b.facility_name, c.short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id = a.PHYSICIAN_ID) attending_practitioner     from ca_op_episode_vw a,        sm_facility_param_lang_vw b, am_speciality_lang_vw c where a.facility_id = ? and a.episode_id = ? and a.FACILITY_ID=b.FACILITY_ID and c.SPECIALITY_CODE = a.SPECIALTY_CODE and b.LANGUAGE_ID =? and c.LANGUAGE_ID = b.LANGUAGE_ID";
    	}

		String sys_date_time ="";

		//String url   = HttpUtils.getRequestURL(request).toString();//IN071404
		//url = url.substring(0,url.indexOf("eCP/jsp/"));//IN071404
//		String url   = application.getRealPath("/");//IN071404
		String url					= application.getRealPath("/eCA")+"/";
		String url1 = "";//IN071408
//		url1 = url + "eCA/html/RecClinicalNotesTemplateDispayView.xsl";
//		url =url+"eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
		
		url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
		url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
		
		String accession_num	=	checkForNull( request.getParameter("accession_num"));

		con				=	ConnectionManager.getConnection(request);
		sec_hdg_code	=	checkForNull(	request.getParameter("sec_hdg_code")	);

		try
		{
			pstmt_discharge_time=con.prepareStatement(strDischargeTimeQuery);
			pstmt_discharge_time.setString(1,facility_id);
			pstmt_discharge_time.setString(2,encounter_id);
			pstmt_discharge_time.setString(3,locale);

			rset_discharge_time=pstmt_discharge_time.executeQuery();

			if(rset_discharge_time!=null)
			{
				while(rset_discharge_time.next())
				{
                   dischargeDateTime=checkForNull(rset_discharge_time.getString("DISCHARGE_DATE_TIME"));
                   speciality_name=checkForNull(rset_discharge_time.getString("specialty_name"));
                   facility_name=checkForNull(rset_discharge_time.getString("facility_name"));
                   visit_adm_date=checkForNull(rset_discharge_time.getString("visit_adm_date"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Discharge Date Time"+e1);
		}
		finally
		{
			if(rset_discharge_time!=null) rset_discharge_time.close();
			if(pstmt_discharge_time!=null) pstmt_discharge_time.close();
		}


		try
		{
			pstmt_site_name=con.prepareStatement(sql_site_name);
			rset_site_name=pstmt_site_name.executeQuery();

			if(rset_site_name!=null)
			{
				while(rset_site_name.next())
				{
                   site_name=checkForNull(rset_site_name.getString("site_name"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Site Name"+e1);
		}
		finally
		{
			if(rset_site_name!=null) rset_site_name.close();
			if(pstmt_site_name!=null) pstmt_site_name.close();
		}

		try
		{
			pstmt_note_header=con.prepareStatement(sql_note_header);
			pstmt_note_header.setString(1,facility_id);
			pstmt_note_header.setString(2,accession_num);
			rset_note_header=pstmt_note_header.executeQuery();

			if(rset_note_header!=null)
			{
				while(rset_note_header.next())
				{
                   discharge_summary_text=checkForNull(rset_note_header.getString("DIS_SUMM_DISCLAIMER_TXT"));
                   notes_header_desc=checkForNull(rset_note_header.getString("note_header_desc"));
                   strAuthoBy=checkForNull(rset_note_header.getString("Authorized_by_name"));
                   strModifyBy=checkForNull(rset_note_header.getString("last_modified_by_name"));
                   printDateTime=checkForNull(rset_note_header.getString("print_date_time"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Note Header"+e1);
		}
		finally
		{
			if(rset_note_header!=null) rset_note_header.close();
			if(pstmt_note_header!=null) pstmt_note_header.close();
		}


		try
		{
			pstmt_event=con.prepareStatement(sql_event);
			pstmt_event.setString(1,facility_id);
			pstmt_event.setString(2,accession_num);
			rset_event=pstmt_event.executeQuery();

			if(rset_event!=null)
			{
				while(rset_event.next())
				{
				   strEventTitleCaption=checkForNull(rset_event.getString("event_title_caption"));
				   strEventAuthByCaption=checkForNull(rset_event.getString("event_auth_by_caption"));
				   strEventPerfByCaption=checkForNull(rset_event.getString("event_perf_by_caption"));
				   strEventDateTimeCaption=checkForNull(rset_event.getString("event_date_caption"));
				   strNoteTypeDesc=checkForNull(rset_event.getString("note_type_desc"));
                   strPerfPhyName=checkForNull(rset_event.getString("performed_by_name"));
                   strEventDateTime=checkForNull(rset_event.getString("event_date_time"));
                   strMedService=checkForNull(rset_event.getString("service_desc"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Event"+e1);
		}
		finally
		{
			if(rset_event!=null) rset_event.close();
			if(pstmt_event!=null) pstmt_event.close();
		}

		try
		{
			pstmt_addendum=con.prepareStatement(sql_addendum_txt);
			pstmt_addendum.setString(1,facility_id);
			pstmt_addendum.setString(2,accession_num);
			rset_addendum=pstmt_addendum.executeQuery();

			if(rset_addendum!=null)
			{
				while(rset_addendum.next())
				{
				   addendumTxt=checkForNull(rset_addendum.getString("ADDENDUM_TEXT"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Addendum Text"+e1);
		}
		finally
		{
			if(rset_addendum!=null) rset_addendum.close();
			if(pstmt_addendum!=null) pstmt_addendum.close();
		}

		try
		{
			pstmt_dependency=con.prepareStatement(sql_dependency);
			pstmt_dependency.setString(1,dep_code);
			rset_dependency=pstmt_dependency.executeQuery();

			if(rset_dependency!=null)
			{
				while(rset_dependency.next())
				{
				   dep_desc=checkForNull(rset_dependency.getString("short_desc"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Dependency"+e1);
		}
		finally
		{
			if(rset_dependency!=null) rset_dependency.close();
			if(pstmt_dependency!=null) pstmt_dependency.close();
		}

		//editor_title = "Print Preview";

		try
		{
				pstPatInfo	= con.prepareStatement(strPatInfoQuery);
				pstPatInfo.setString(1,patient_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next() )
				{
					patient_name = checkForNull(rsPatInfo.getString("patient_name"));
					patient_age  = checkForNull(rsPatInfo.getString("patient_age"));
					patient_gender = checkForNull(rsPatInfo.getString("gender"));
				}	
				else
				{
					patient_name ="";
					patient_age ="";
					patient_gender ="";
				}
		}
		catch (Exception ePP)
		{
		//	out.println("Exception@1-->ePP"+ePP);//COMMON-ICN-0181
			ePP.printStackTrace(System.out);
		}
		finally
		{
			if(rsPatInfo != null) rsPatInfo.close();
			if(pstPatInfo != null) pstPatInfo.close();
		}

		try
		{
			pstPatInfo	= con.prepareStatement(strPatEncDtlQry);
			pstPatInfo.setString(1,facility_id);
			pstPatInfo.setString(2,encounter_id);

			rsPatInfo = pstPatInfo.executeQuery();

			if(rsPatInfo.next() )
			{
				location_name = checkForNull(rsPatInfo.getString("LOCN_DESC"));
			}
			else
				visit_adm_date ="";
		}
		catch (Exception ePPA)
		{
			out.println("Exception@2-->ePPA: "+ePPA);
			ePPA.printStackTrace(System.out);
		}
		finally
		{
			if(rsPatInfo != null) rsPatInfo.close();
			if(pstPatInfo != null) pstPatInfo.close();
		}

		if(PrtMode.equals("Y"))
		{
	%>
			<table border='0' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr>
					<td align='left' width='5%' rowspan='2' colspan ="2">
						<img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'>
					</td>
					<td  align=center colspan = "8"><h3><%=site_name%></h3>
					</td>
			</tr>
			<tr >
				<td align=center colspan ="8"><h3><%=facility_name%></h3></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
					<td align=center colspan ="8"><h4><%=notes_header_desc%></h4></td>
			</tr>
			</table>
			<br>
				<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr>
			<td>
			<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>
			<tr>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2" align ="left"><font size='2'>:<%=patient_id%></font></td>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.name.label" bundle="${common_labels}"/></b></td>
					<td nowrap colspan = "2"><font size='2'>:<%=patient_name%></font></td>
			</tr>								
			<tr>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2" align ="left"><font size='2'>:<%=patient_gender%></font></td>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.age.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2" align ="left"><font size='2'>:<%=patient_age%></font></td>
			</tr>
			<tr>
					<td nowrap colspan ="2" align ="left"><font size='2'><b><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2"><font size='2'>:<%=encounter_id%></font></td>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2"><font size='2'>:<%=episode_type.equals("IP")?"InPatient":"OutPatient"%></font></td>
					
			</tr>
			<tr>	
					<td nowrap colspan ="4">&nbsp;</td>
					<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></b></td>
					<td nowrap colspan ="2"><font size='2'>:<%=visit_adm_date%></font></td>
			</tr>
			<tr>
					<td nowrap colspan ="2" align ="left"><font size='2'><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ='2' ><font size='2'>:<%=location_name%></font></td>
					<td nowrap colspan ="2" ><font size='2'><b><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></b></font></td>
					<td nowrap colspan ="2"><font size='2'>: <%=dischargeDateTime%></font></td>
			</tr>
			<tr>
				<td nowrap colspan ="2"><font size='2'><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>
				<td nowrap colspan ='2'><font size='2'>:<%=speciality_name%></font></td>
				<td nowrap colspan ='2'><font size='2'><b><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></b></font></td>
				<td nowrap colspan ="2"><font size='2'>:<%=attending_practitioner%></font></td>
			</tr>
			</td>
		</tr>
		</td>
		</tr>
		</table>
		</table>
		<table border=0 cellspacing=0 width=auto width='100%' style='font-family:Verdana;font-size:9pt'>
			<tr>
				<td width=10% colspan ="2" nowrap><B><%=strEventTitleCaption%></B></td>
				<td width=40% colspan ="2" nowrap>&nbsp;:<%=strNoteTypeDesc%></td>
				<td width=20% colspan ="1" align=right nowrap><b> <fmt:message key="Common.Med/AncService.label" bundle="${common_labels}"/> </B></td>
				<td width=20% colspan ="3" nowrap>&nbsp;:<%=strMedService%></td>
			</tr>
			<tr>
				<td width=10% colspan ="2" nowrap> <B><%=strEventDateTimeCaption%></B></td>
				<td width=40% colspan ="2" nowrap>&nbsp;:<%=strEventDateTime%></td>
				<td width=20% colspan ="1" align=right nowrap><b><%=strEventPerfByCaption%></B></td>
				<td width=20% colspan ="3" nowrap>&nbsp;:<%=strPerfPhyName%></td>
			</tr>
			</table>
			<hr></hr>
<%
		}
		%>
			<table border='0' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana" >
			<%
				note_type=checkForNull(request.getParameter("note_type"));
       
			try
			{						
			webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

//			query_section_details = "select sec_hdg_code, sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, child_sec_hdg_code, child_sec_hdg_desc, child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, image_linked_yn, PRESERVE_FORMAT_YN from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num ";
			query_section_details = "select sec_hdg_code, sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, child_sec_hdg_desc, child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, image_linked_yn, PRESERVE_FORMAT_YN from ca_note_section_view   where note_type = ?  order by note_sec_seq_num, child_seq_num ";

			pstmt		=	con.prepareStatement(query_section_details);
			
			pstmt.setString(1,note_type);
			
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				section_content = "";
				section_image_content = "";
				StrDataAvlFlag	= "N";

				sec_hdg_code			=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc			=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type		=	checkForNull( rs.getString("sec_content_type") );
				child_sec_hdg_desc		=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_hdg_code		=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_content_type	=	checkForNull( rs.getString("child_sec_content_type") );
				preserve_format_yn		=	checkForNull( rs.getString("PRESERVE_FORMAT_YN") );
				sys_date_time			=	rs.getString("sys_date_time");
				image_linked_yn			=	checkForNull(rs.getString("image_linked_yn"));

				try
				{
					/*if( sec_content_type.equals("S") )
					{
						if(child_sec_content_type.equals("T"))
						{
							section_content = checkForNull((String)sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code),"&nbsp;");							
							System.err.println("section_content1=="+section_content);
							if(!(section_content.equals("&nbsp;")))
								section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
							System.err.println("section_content2=="+section_content);
						}
						else
						{
							section_content	= checkForNull((String)sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code),"&nbsp;");
							System.err.println("section_content3=="+section_content);
							section_image_content	= (String) sectionBean.getSectionImageContent(sec_hdg_code,child_sec_hdg_code);
							System.err.println("section_image_content1=="+section_image_content);
						}

						if(!(section_content.equals("&nbsp;")) ||( section_image_content != null && !(section_image_content.equals("") ) ) )
						{
							StrDataAvlFlag	 = "Y";*/
							%>
							<!--<tr>
								<td class='NOTESUBHEADER' style="background-color:#ADADAD;" colspan=3 >
									<font style="FONT-SIZE:13pt;font-weight:bold;"> <u> <i><%=child_sec_hdg_desc%></i> </u></font>
								</td>
							</tr>
							<tr>-->
							<%
						/*}
					}*/
					
					/*if( !(sec_content_type.equals("S")) )
					{
						if(sec_content_type.equals("T"))
						{
							section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
							System.err.println("section_content4=="+section_content);
							if(!(section_content.equals("&nbsp;")))
								section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
							System.err.println("section_content5=="+section_content);
						}
						else
						{
							section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
							System.err.println("section_content6=="+section_content);
							section_image_content = (String) sectionBean.getSectionImageContent(sec_hdg_code,child_sec_hdg_code);
							
							if(section_image_content == null) 
									section_image_content ="";
							System.err.println("section_image_content2=="+section_image_content);
						}
						if(!(section_content.equals("&nbsp;")) ||( section_image_content != null && !(section_image_content.equals("") ) ) )
						{
							StrDataAvlFlag	 = "Y";*/
					%>
						<tr><td colspan="3" style="background-color:#ADADAD;">
									<font style="FONT-SIZE:13pt;font-weight:bold;"><u><%=sec_hdg_desc%></u>
									</font>
								</td>
						</tr><tr> 
							<%
						/*}
					}*/
				//HYUYGJH

					pstmt_section_content=con.prepareStatement("select NOTES_SECTION_CONTENT from ca_encntr_note_section where ACCESSION_NUM = ? and FACILITY_ID = ? and SEC_HDG_CODE = ? and  SUBSEC_HDG_CODE = ?");
					pstmt_section_content.setString(1,accession_num);
					pstmt_section_content.setString(2,facility_id);
					pstmt_section_content.setString(3,sec_hdg_code);
					pstmt_section_content.setString(4,child_sec_hdg_code);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------accession_num----->"+accession_num);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------facility_id----->"+facility_id);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------sec_hdg_code----->"+sec_hdg_code);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------child_sec_hdg_code----->"+child_sec_hdg_code);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------sec_content_type----->"+sec_content_type);
					rset_section_content =	pstmt_section_content.executeQuery();					
					if(rset_section_content!=null)
					{
						while(rset_section_content.next())
						{
							section_content=rset_section_content.getString("NOTES_SECTION_CONTENT");
						}
					}
					
					if(rset_section_content!=null) rset_section_content.close();
					if(pstmt_section_content!=null) pstmt_section_content.close();
					//parse the notes_section_content
					//assign the parsed value to section_content variable
				
					if(!(section_content.equals(""))){
							
						if(sec_content_type.equals("T"))
							section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
						try
						{
							if(!(section_content.equals("&nbsp;")))
							{
								%>
									<td colspan="3" ><font style ="font-family:Verdana"><%=section_content%></font>
								<%
							}
						
							if(image_linked_yn.equals("Y"))
							{
								if(!section_image_content.equals(""))
								{
									if((section_content.equals("&nbsp;")))
									{
										%>
											<td colspan="3" >
										<%
									}
									%>
										<applet name="<%=sec_hdg_code + child_sec_hdg_code%>" code="Drawing.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="660" height="360" align="baseline" >
											<param name="canDraw" value="0">	
											<param name="jpeg_quality" value="50">
											<param name="image" value ="<%=section_image_content%>">
										</applet> 
									<%	
								}
							}
							if (StrDataAvlFlag.equals("Y") )
							{
								%>
									</td></tr>
								<%
							}
							if(addendumTxt!=null && !addendumTxt.equals(""))
							{
									out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+clinician_name+", Responsiblity: "+resp_name+", Date/Time: "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+addendumTxt+"</td></tr></table></td></tr>");

									strAddendumFlag = "Y";
									addendumTxt ="";
							}				
						}
						catch(Exception e)
						{
							//out.println("Exception caught at inter @1.33-->" + e);//COMMON-ICN-0181
							e.printStackTrace(System.err);
						}
					}

				}
				catch(Exception e)
				{
					//out.println("Exception caught at inter @1.34-->" + e);//COMMON-ICN-0181
					e.printStackTrace(System.err);
				}
			} // end of while(rs.next())
			converter=null;
		}
		catch(Exception e)
		{
			out.println("Exception@2 : "+e);
			e.printStackTrace(System.out);
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		try
		{
			String sqlAddendum = "select ADDENDUM_TEXT, b.PRACTITIONER_NAME, c.RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_note_addendum a, AM_PRACTITIONER b,SM_RESP c where a.FACILITY_ID =? and ACCESSION_NUM=? and a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID";
			pstmt = con.prepareStatement(sqlAddendum);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,accession_num);
			rs=pstmt.executeQuery();

			String addendumText = "";
			String practName = "";
			String respName = "";
			String addedDate = "";
			while(rs.next())
			{
				addendumText = rs.getString(1);
				practName = rs.getString(2);
				respName = rs.getString(3);
				addedDate = rs.getString(4);

				if(addendumText == null) 
					 addendumText ="";

				if(practName == null)
						practName = "";

				if(respName == null)
						respName ="";

				if(addedDate == null)
						addedDate = "";

				out.println("<tr><td style=\"font-family:Verdana;font-size:9pt;\" ><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+practName+", Responsiblity: "+respName+", Date/Time: "+addedDate+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+addendumText+"</td></tr></table>				</td></tr>");
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@ from ca_encntr_note_addendum : "+e);//COMMON-ICN-0181
			e.printStackTrace(System.out);
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		
		if(strAddendumFlag.equals("N"))
		{
			if(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code)!=null)
			{
				out.println("<tr><td ><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+clinician_name+", Responsiblity: "+resp_name+", Date/Time: "+sys_date_time+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+replaceSpecialChars(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code))+"</td></tr></table></td></tr>");
			}
		}
%>
</table>
<%
	if(chk_val_hid.equals(""))
	{
%>
<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
<tr>
<td>
<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;:background-color:#ADADAD;font-size:9pt">
<tr>
<td colspan="1" nowrap align ="left" width="20%"><b><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>&nbsp;</b></td>
<td colspan="1" nowrap align ="left"><font size ="2">: <%=dep_desc%></td>
</tr>
</table>
</td>
</tr>
</table>
<%
	}
	else
	{
%>
<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
<tr>
<td>
<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;:background-color:#ADADAD;font-size:9pt">
<tr>
	<td colspan="1" nowrap align ="left" width="20%"><b><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>&nbsp;</b></td>
	<td colspan="1" nowrap align ="left"><font size ="2">: <%=dep_desc%></td>
	</tr>
	<%
		ArrayList diagList = diagBean.getKeySet();		
		chkToken = new StringTokenizer(chk_val_hid,"||");

		try
		{
		while(chkToken.hasMoreTokens())
		{
			chkVal = chkToken.nextToken();

			if(chkVal.equals("Y"))
			{							
				keys = (String) diagList.get(mapSize);
				diagToken = new StringTokenizer(keys,"$");							
				term_set_id = diagToken.nextToken();
				term_code = diagToken.nextToken();
				flag_ss_ua = diagToken.nextToken();

		   		pstmt_term_code=con.prepareStatement(sql_term_code);
                pstmt_term_code.setString(1,term_code);
				rset_term_code=pstmt_term_code.executeQuery();

				if(rset_term_code!=null)
				{
					while(rset_term_code.next())
					{
                       term_code_desc=rset_term_code.getString("short_desc");
					}
				}

				if(rset_term_code!=null) rset_term_code.close();
				if(pstmt_term_code!=null) pstmt_term_code.close();

    			pstmt_term_set=con.prepareStatement(sql_term_set);
				pstmt_term_set.setString(1,term_set_id);
				rset_term_set=pstmt_term_set.executeQuery();


				if(rset_term_set!=null)
				{
					while(rset_term_set.next())
					{
                       term_set_desc=rset_term_set.getString("term_set_desc");
					}
				}

				if(rset_term_set!=null) rset_term_set.close();
				if(pstmt_term_set!=null) pstmt_term_set.close();


				if(term_set_desc1.equals(term_set_desc))
					term_set_desc1="";
				else
					term_set_desc1=term_set_desc;
	%>
	<tr>
 	<td colspan="1" nowrap align ="left" width="20%"><b><%=term_set_desc1%>&nbsp;</b></td>
	<td colspan="1" nowrap align ="left"><font size ="2">: <%=term_code_desc%></td>
	</tr>
    <%
		    term_set_desc1=term_set_desc;
			}
			mapSize++;
		}
		
		%>
	</table>
	</td>
	</tr>
	</table>
		<%
		}
		catch(Exception e1)
		{
			//out.println("Exception in Printing Diagnosis"+e1);//COMMON-ICN-0181
             e1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
				if(rset_term_code!=null) rset_term_code.close();
				if(rset_term_set!=null) rset_term_set.close();

				if(pstmt_term_code!=null) pstmt_term_code.close();
				if(pstmt_term_set!=null) pstmt_term_set.close();

		}
	}
	%>
   <br>
	<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
		<tr>
			<td>
			<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;:background-color:#ADADAD;font-size:9pt">
				<tr>
					<td width='20%'><b><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></b></td>
					<td width='45%' align='left'>:  <font size='2'><%=strAuthoBy%></font></td>
					<td width='15%'><b><fmt:message key="Common.Signature.label" bundle="${common_labels}"/></b></td><td width='20%' align='left'>:&nbsp;</td>
				</tr>
				<tr>
					<td width='20%'><b><fmt:message key="Common.LastModifiedBy.label" bundle="${common_labels}"/></b></td><td width='45%' align='left'>:  <font size='2'><%=strModifyBy%></font></td>
					<td width='15%'><b><fmt:message key="Common.Signature.label" bundle="${common_labels}"/></b></td><td width='20%' align='left'>:  </td>
				</tr>
				<tr>
					<td width='20%'><b><fmt:message key="Common.PrintDateTime.label" bundle="${common_labels}"/></b></td><td width='45%' align='left'> <font size='2'>:  <%=printDateTime%></font></td>
					<td width='15%'><b><fmt:message key="Common.LoggedUser.label" bundle="${common_labels}"/></b></td><td width='20%' align='left'><font size='2'>:  <%=login_user_id%></font></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
<%

		if(PrtMode.equals("Y"))
		{
			%>
				<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;:background-color:#ADADAD">
				<tr>
					<td nowrap colspan ="8" align ="left"><font size ="1"><%=discharge_summary_text%></td>
				<tr>
				</table>
			<%
		}
	} // end of try
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//COMMON-ICN-0181
		e.printStackTrace(System.out);
	} // end of catch(Exception e)
	finally
	{
		if(rs!=null) rs.close();			
		if(rsPatInfo!=null) rsPatInfo.close();
		if(rset_sysdate!=null) rset_sysdate.close();
		if(rset_discharge_time!=null) rset_discharge_time.close();
		if(rset_site_name!=null) rset_site_name.close();
		if(rset_note_header	!=null) rset_note_header.close();
		if(rset_event!=null) rset_event.close();
		if(rset_addendum!=null) rset_addendum.close();
		if(rset_dependency!=null) rset_dependency.close();
		if(rset_term_set!=null) rset_term_set.close();
		if(rset_term_code!=null) rset_term_code.close();

		if(pstmt!=null) pstmt.close();
		if(pstPatInfo!=null) pstPatInfo.close();
		if(pstmt_sysdate!=null) pstmt_sysdate.close();	
		if(pstmt_discharge_time!=null) pstmt_discharge_time.close();
		if(pstmt_site_name!=null) pstmt_site_name.close();
		if(pstmt_note_header!=null) pstmt_note_header.close();
		if(pstmt_event!=null) pstmt_event.close();
		if(pstmt_addendum!=null) pstmt_addendum.close();
		if(pstmt_dependency!=null) pstmt_dependency.close();
		if(pstmt_term_set!=null) pstmt_term_set.close();
		if(pstmt_term_code!=null) pstmt_term_code.close();

		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
</center>
</form>
</body>
<script language='javascript'>
	//changeEditorTitleForPrev("<%=editor_title%>");

	function PrevPreview()
	{
	var i = 0
	var res = confirm('Continue printing?');
	if(res)
	{
		while( i < document.applets.length ) 
		{
			var j = 0 ;
			while ( !document.applets[i].isActive() && j++ <=75000 ) 
				window.status = i;
			i++;
		}

		SysPreview();
	}
	}

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>
<%!
	public String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
	}
%>
<%!
	
	private String replaceSpecialChars(String input)
	{
		StringBuffer temp=new StringBuffer();
		while(input.indexOf("\n")!=-1)
		{	
			int ii=input.indexOf("\n");
			temp.append(input);
			temp.replace(ii,ii+1,"<br>");
			input=temp.toString();
			temp.delete(0,temp.length());
		}
		
		return input;
	}

%>


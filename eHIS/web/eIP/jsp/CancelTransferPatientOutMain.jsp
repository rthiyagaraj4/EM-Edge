<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 		:	13/07/2001
	Module			:	ip
-->
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.Statement,java.sql.ResultSet,java.sql.SQLException" %>
<%
	Connection con		= null;
	Statement statement	= null;
	ResultSet resultSet	= null;	  
	Statement stmt		= null;
	ResultSet rset		= null;
	Statement stmt_opn	= null;
	ResultSet rs_opn	= null;
	String frmeddesc	= "";
	String d_converted	= "";
	String AUTH_DATE_TIME_CONVERTED = "";
	String INFORM_DATE_TIME_CONVERTED = "";
	String facilityId	= (String)session.getValue("facility_id");
	String patientid		=	checkForNull(request.getParameter("patient_id"));
	String eid				=	checkForNull(request.getParameter("encounter_id"));
	long    encounterid		=	Long.parseLong(eid);
    request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");
	try
	{
		con				= ConnectionManager.getConnection(request);
		StringBuffer strBuffer	= new StringBuffer();
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eIP/js/IPPractitionerComponent.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
	function submitMe()
	{
			var fields = new Array();
			fields[0] = document.forms[0].pract_desc;
			fields[1] = document.forms[0].cancel_reason;

			var names = new Array(getLabel("Common.AuthorizingPractitioner.label","Common"),getLabel("Common.ReasonforCancellation.label","common"));
			if(checkFields1( fields, names))
			{
				document.forms[0].cancel.disabled = true;
				document.forms[0].submit();
			}
		
	}

function checkFields1( fields, names)
{
	var errors = "";
	for(var i=0;i<fields.length;i++ ) 
	{
		if(trimCheck1(fields[i].value)) 
		{	}
		else
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(names[i])))+"\n";
	}
	
	if ( errors.length != 0 ) 
	{
		alert(errors) ;
		return false ;
	}
	return true ;
}

function trimCheck1(inString)
{
	var startPos;
	var ch;
	startPos = 0;
	strlength = inString.length;

	for(var i=0;i<=strlength;i++) {
		ch = inString.charAt(startPos);
		if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
			startPos++;
		}
	}
	if(startPos == inString.length) return false;
	else return true;
}

	function focusFirst()
	{
		document.forms[0].cancel_reason.focus();

	}
	function BeforeGetPractitioner(obj,target, aFacilityID)
	{
		if(document.forms[0].pract_desc_hid.value != document.forms[0].pract_desc.value)
		{
			if(document.forms[0].pract_desc.value!= "")
			  getPractitionerLocal(obj,target, aFacilityID)
		}
	}
//Added by kishore on 8/9/2004
	function checkPractTxtVal(obj,target, aFacilityID)
	{
		getPractitionerLocal(obj,target, aFacilityID);
	}
	function getPractitionerLocal(obj,target, aFacilityID)
	{
		var practName_FName="";
		var practName_FValue="";
		var practId_FName="";
		practName_FName=target.name;
		practName_FValue=target.value;
		practId_FName			= document.forms[0].practid.name;
		var nursing_unit_code	= document.forms[0].fr_nursing_code.value;
		var spl_code			= document.forms[0].frsplcode.value;
		var locale				= document.forms[0].locale1.value;
		
		getPractitioner(obj, target, aFacilityID, spl_code,nursing_unit_code,"Q5");

		/*
		
		var sql = " SELECT a.practitioner_id practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+locale+"','1') practitioner_type, AM_GET_DESC.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"','2') primary_specialty,gender,AM_GET_DESC.AM_POSITION(b.position_code,'"+locale+"','1') job_title FROM ip_nursing_unit_for_pract_vw a,am_pract_all_splty_vw b WHERE a.practitioner_id = b.practitioner_id AND a.facility_id = '"+aFacilityID+"' and a.facility_id = b.facility_id AND nursing_unit_code = '"+nursing_unit_code+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (   UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1')) LIKE  UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";

		var sql2 = " SELECT a.practitioner_id practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+locale+"','1') practitioner_type, AM_GET_DESC.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"','2') primary_specialty,gender,AM_GET_DESC.AM_POSITION(b.position_code,'"+locale+"','1') job_title FROM ip_nursing_unit_for_pract_vw a,am_pract_all_splty_vw b WHERE a.practitioner_id = b.practitioner_id AND a.facility_id = '"+aFacilityID+"' and a.facility_id = b.facility_id AND nursing_unit_code = '"+nursing_unit_code+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (   UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) and UPPER (AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1')) LIKE  UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";
				
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	= "<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " practId_FName=\"" + practId_FName + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + spl_code+ "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);	

		*/

	} // End of getPractitioner();

	function checkForValues()
		{
	
		document.forms[0].pract_desc.focus();
		}
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].pract_desc.value=arr[1];	
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].pract_desc.value="";			
	}
}

	</script>
</head>


<body onload='focusFirst()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt=new java.util.Date();
			String d = dateFormat.format( dt ) ;
			String min = String.valueOf(dt.getMinutes()) ;
            if(min.length() == 1)   min = "0"+min ;

			d=d + " "+String.valueOf(dt.getHours())+":"+min;

			if(!(d.equals("") || d == null))
						d_converted = DateUtils.convertDate(d,"DMYHM","en",locale); 	
					
			String admissiondate		= "";
			String admissiontype		= "";
			String frpractitionerid		= "";
			String frpractdesc			= "";
			String frspecialitycode		= "";
			String frspecialitydesc		= "";
			String frnursingunitcode	= "";
			String frnursingunitdesc	= "";
			String frteamid				= "";
			String frservicecode		= "";
			String frservicedesc		= "";
			String transType			= "";
			String transType_Desc		= "";
			String priority				= "";
			String toNursingUnitCode	= "";
			String toNursingUnit_Desc	= "";
			String toServiceCode		= "";
			String toService_Desc		= "";
			String toSubServiceCode		= "";
			String toSubService_Desc	= "";
			String toSplCode			= "";
			String frSplCode			= "";
			String toSplDesc			= "";
			String toPractId			= "";
			String toPractName			= "";
			String toMedTeam			= "";
			String toMedTeam_Desc		= "";
			String to_bed_class_code	= "";
			String to_bed_no			= "";
			String to_room_no			= "";
			String topractdesg			= "";
			String AUTH_DATE_TIME		= "";
			String INFORM_DATE_TIME		= "";
			String INFORMED_TO			= "";
			String INFORMED_NAME		= "";
			String INFORMED_YN			= "";
			String chkValue				= "";
			String TFR_REQ_REF_NO		= "";
			String fr_nursingunit_code	= "";
			String admissiondate_converted = "";
			String tfr_type_code		= "";
			String transfer_type_short_desc	= "";
			
			if(rs_opn!=null)rs_opn.close();
			if(stmt_opn!=null)stmt_opn.close();
	
			if (strBuffer.length() > 0)		
				strBuffer.delete(0, strBuffer.length());

			strBuffer.append("select to_char(a.admission_date_time,'dd/mm/rrrr hh24:MI') admission_date,IP_GET_DESC.IP_ADMISSION_TYPE(a.ADMISSION_TYPE,'"+locale+"','2') admission_short_desc, a.ATTEND_PRACTITIONER_ID practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,'"+locale+"','1') practitioner_name,a.specialty_code, AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"','2') specialty_short_desc,a.bed_class_code ,IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,'"+locale+"','2') bed_class_short_desc, a.nursing_unit_code ,IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,'"+locale+"','2') nursing_unit_short_desc, a.bed_num bed_no, a.room_num room_no ,a.bed_type_code,b.sex gender,get_age(b.date_of_birth) age, a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,'"+locale+"','1') service_short_desc, a.PATIENT_CLASS, a.team_id, AM_GET_DESC.AM_MEDICAL_TEAM(a.facility_id,a.team_id, '"+locale+"','2') team_short_desc from ip_open_encounter a, mp_patient b where a.patient_id=b.patient_id and a.encounter_id =");
			strBuffer.append(encounterid);
			strBuffer.append(" and a.facility_id = '");
			strBuffer.append(facilityId);
			strBuffer.append("' ");
			stmt  = con.createStatement();
			rset  = stmt.executeQuery(strBuffer.toString());
			if(rset.next())
			{
				try
				{
					admissiondate		= checkForNull(rset.getString("admission_date"));
					if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 	
		
					admissiontype		= checkForNull(rset.getString("admission_short_desc"));
					frpractitionerid	= checkForNull(rset.getString("practitioner_id"));
					frpractdesc			= checkForNull(rset.getString("practitioner_name"));
					frspecialitycode	= checkForNull(rset.getString("specialty_code"));
					frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
					frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code"));
					frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc"));
					frservicecode		= checkForNull(rset.getString("service_code"));
					frservicedesc		= checkForNull(rset.getString("service_short_desc"));
				    frmeddesc	= checkForNull(rset.getString("team_short_desc"));
					frteamid	= checkForNull(rset.getString("team_id")); 
				
				}catch(SQLException sqlexp)
				{
					sqlexp.printStackTrace();
				}
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
					 
			/*
			Commented On 5/20/2010 for PE
			if (strBuffer.length() > 0)		
				strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select bed_block_period_max from ip_param where facility_id='");
			strBuffer.append(facilityId);
			strBuffer.append("' ");

			if (medstmt != null)  medstmt = null;
			if (medrs != null)  medrs = null;

			medstmt = con.createStatement();
			medrs = medstmt.executeQuery(strBuffer.toString());
			if((medrs!=null) && (medrs.next()))
			{
			}
			if (medstmt != null)  medstmt.close();
			if (medrs != null)  medrs.close();*/
			/*if (strBuffer.length() > 0)		
				strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select count(*) from ip_transfer_request where tfr_req_status = '3' and encounter_id =");
			strBuffer.append(encounterid);
			strBuffer.append("  and facility_id = '");
			strBuffer.append(facilityId);
			strBuffer.append("' ");
			stmt  = con.createStatement();
			rset  = stmt.executeQuery(strBuffer.toString());
			int nRec=0;
			if(rset.next())
			{
				nRec = rset.getInt(1);

			}

			
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();*/
			//if(nRec>0)
			//{
				if (strBuffer.length() > 0)		
				strBuffer.delete(0, strBuffer.length());
				
				strBuffer.append("select to_char(b.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time,ip_get_desc.IP_ADMISSION_TYPE(b.ADMISSION_TYPE,'"+locale+"',2) admission_short_desc, a.PRIORITY_CODE,a.TFR_REQ_REF_NO, ip_get_desc.IP_TRANSFER_PRIORITY(a.facility_id,a.PRIORITY_CODE,'"+locale+"',2)  PRIORITY_SHORT_DESC,b.nursing_unit_code from_nursing_unit_code,b.SPECIALTY_CODE from_specialty_code,a.REQ_NURSING_UNIT_CODE NURSING_UNIT_CODE, ip_get_desc.IP_NURSING_UNIT(a.facility_id,a.REQ_NURSING_UNIT_CODE,'"+locale+"',2 ) NURSING_UNIT_SHORT_DESC, a.REQ_SERVICE_CODE SERVICE_CODE,am_get_desc.AM_SERVICE(a.REQ_SERVICE_CODE,'"+locale+"',2 ) SERVICE_SHORT_DESC, a.REQ_SPECIALTY_CODE SPECIALTY_CODE, am_get_desc.AM_SPECIALITY(a.REQ_SPECIALTY_CODE,'"+locale+"',2 ) SPECIALTY_SHORT_DESC, a.REQ_PRACTITIONER_ID PRACTITIONER_ID,am_get_desc.AM_PRACTITIONER(a.REQ_PRACTITIONER_ID,'"+locale+"',2)  PRACTITIONER_NAME, '' PRACTITIONER_DESIGNATION,a.TFR_REQ_TYPE, a.TFR_REQ_TYPE TFR_REQ_TYPE_DESC, a.TFR_REQ_REASON , ip_get_desc.IP_TRANSFER_TYPE(a.TFR_REQ_REASON,'"+locale+"',2) TRANSFER_TYPE_SHORT_DESC , a.REQ_SUBSERVICE_CODE SUBSERVICE_CODE,am_get_desc.AM_SUBSERVICE(a.REQ_SERVICE_CODE,a.REQ_SUBSERVICE_CODE,'"+locale+"',2 ) SUBSERVICE_SHORT_DESC, a.REQ_TEAM_ID TEAM_ID,am_get_desc.AM_MEDICAL_TEAM(a.facility_id,a.REQ_TEAM_ID,'"+locale+"',2) TEAM_SHORT_DESC, a.REQ_BED_CLASS_CODE BED_CLASS_CODE,ip_get_desc.ip_bed_class(a.REQ_BED_CLASS_CODE,'"+locale+"',2) bed_class_short_desc, a.REQ_BED_NO BED_NO, a.REQ_ROOM_NO ROOM_NO, a.REQ_BED_TYPE_CODE BED_TYPE_CODE, to_char(a.AUTH_TRF_DATE_TIME,'dd/mm/rrrr hh24:mi') AUTH_DATE_TIME,to_char(a.INFORMED_DATE_TIME,'dd/mm/rrrr hh24:mi') INFORM_DATE_TIME,a.INFORMED_NAME,a.INFORMED_TO,a.INFORMED_YN,a.INFORMED_TO INFORMED_TO_DESC from ip_transfer_request a, ip_open_encounter b  where a.tfr_req_status = '3' and a.facility_id=b.facility_id and a.encounter_id=b.encounter_id and a.encounter_id =");
                strBuffer.append(encounterid);
                strBuffer.append("  and a.facility_id = '");
                strBuffer.append(facilityId);
                strBuffer.append("' ");
				stmt  = con.createStatement();
				rset  = stmt.executeQuery(strBuffer.toString());
				if(rset.next())
				{
					
					try{
					AUTH_DATE_TIME		= checkForNull(rset.getString("AUTH_DATE_TIME"));

					if(!(AUTH_DATE_TIME.equals("") || AUTH_DATE_TIME == null))
						AUTH_DATE_TIME_CONVERTED = DateUtils.convertDate(AUTH_DATE_TIME,"DMYHM","en",locale); 	
				
					admissiondate		= checkForNull(rset.getString("admission_date_time"));

					if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 	
					admissiontype		= checkForNull(rset.getString("admission_short_desc"));
					transType			= checkForNull(rset.getString("TFR_REQ_TYPE"));
					transType_Desc		= checkForNull(rset.getString("TFR_REQ_TYPE_DESC"));
					priority			= checkForNull(rset.getString("PRIORITY_SHORT_DESC")); 
					toNursingUnitCode	= checkForNull(rset.getString("NURSING_UNIT_CODE"));
					toNursingUnit_Desc	= checkForNull(rset.getString("NURSING_UNIT_SHORT_DESC"));
					toServiceCode		= checkForNull(rset.getString("SERVICE_CODE"));
					toService_Desc		= checkForNull(rset.getString("SERVICE_SHORT_DESC"));
					toSubServiceCode	= checkForNull(rset.getString("SUBSERVICE_CODE"));
					toSubService_Desc	= checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
					toSplCode			= checkForNull(rset.getString("SPECIALTY_CODE"));
					toSplDesc			= checkForNull(rset.getString("SPECIALTY_SHORT_DESC"));
					toPractId			= checkForNull(rset.getString("PRACTITIONER_ID"));
					toPractName			= checkForNull(rset.getString("PRACTITIONER_NAME"));
					topractdesg			= checkForNull(rset.getString("PRACTITIONER_DESIGNATION"));
					toMedTeam			= checkForNull(rset.getString("TEAM_ID"));
					toMedTeam_Desc		= checkForNull(rset.getString("TEAM_SHORT_DESC"));
					to_bed_class_code	= checkForNull(rset.getString("bed_class_short_desc"));
					to_bed_no			= checkForNull(rset.getString("BED_NO"));
					to_room_no			= checkForNull(rset.getString("ROOM_NO"));
					INFORM_DATE_TIME	= checkForNull(rset.getString("INFORM_DATE_TIME"));
					if(!(INFORM_DATE_TIME.equals("") || INFORM_DATE_TIME == null))
						INFORM_DATE_TIME_CONVERTED = DateUtils.convertDate(INFORM_DATE_TIME,"DMYHM","en",locale); 	
					INFORMED_NAME		= checkForNull(rset.getString("INFORMED_NAME"));
					INFORMED_TO			= checkForNull(rset.getString("INFORMED_TO_DESC"));
					INFORMED_YN			= checkForNull(rset.getString("INFORMED_YN"));
					TFR_REQ_REF_NO		= checkForNull(rset.getString("TFR_REQ_REF_NO"));
					fr_nursingunit_code = checkForNull(rset.getString("from_nursing_unit_code"));
					frSplCode			= checkForNull(rset.getString("from_specialty_code"));
					/*Thursday, July 15, 2010 added for SRR20056-SCF-4856-IN022698 , column added in query also*/
					tfr_type_code		= checkForNull(rset.getString("TFR_REQ_REASON"));
					transfer_type_short_desc		= checkForNull(rset.getString("TRANSFER_TYPE_SHORT_DESC"));
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}
			//}
			else
			{
				
				if(toNursingUnitCode.equals(""))
					toNursingUnitCode = frnursingunitcode;
				if(toNursingUnit_Desc.equals(""))
					toNursingUnit_Desc = frnursingunitdesc;
				if(toServiceCode.equals(""))
					toServiceCode = frservicecode;
				if(toService_Desc.equals(""))
					toService_Desc = frservicedesc;
				if(toSubServiceCode.equals("")) 	
					toSubServiceCode = "";
				if(toSubService_Desc.equals(""))
					toSubService_Desc = "";
				if(toSplCode.equals(""))
					toSplCode = frspecialitycode;
				if(toSplDesc.equals(""))
					toSplDesc = frspecialitydesc;
				if(toPractId.equals(""))
					toPractId = frpractitionerid;
				if(toPractName.equals(""))
					toPractName = frpractdesc;
				if(toMedTeam.equals(""))			
					toMedTeam = frteamid;
				if(toMedTeam_Desc.equals(""))			
					toMedTeam_Desc = frmeddesc;
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			if(priority.equals(""))
		{
		}
%>
	<form name="CancelTransferPatientOut" id="CancelTransferPatientOut"  method="post" action="../../servlet/eIP.CancelTransferPatientOutServlet" target="Dummy_frame">
	<table border=0 width="100%" cellpadding='3' cellspacing=0>
	<%--<%
		if(install_yn.equals("N"))
		{%>
			<br>
		<%}
	%>--%>
		<tr>
			<td  width="25%" class="label" ><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
			 <td width="25%" class='querydata'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate_converted%></td>
			<td  width="25%" class="label" ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td  width="25%" class='querydata'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiontype%></td> 
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=d%>"> <%=d_converted%> </td>
			<td  class="label" ><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td>
			<td class='querydata'><input type="hidden" name="transfer_type" id="transfer_type"  value="<%=tfr_type_code%>"><%=transfer_type_short_desc%>
			</td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td class='columnheader' colspan=4  width="100%"><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class='querydata'><%=toNursingUnit_Desc%>
				<input type="hidden" name="to_nursing_unit_to_code" id="to_nursing_unit_to_code" value="<%=toNursingUnitCode%>">
				<input type="hidden" name="to_nursing_unit_short_desc" id="to_nursing_unit_short_desc" value="<%=toNursingUnit_Desc%>">
			</td>
			<td  class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='querydata'><%=toService_Desc%>
				<input type="hidden" name="to_service_code" id="to_service_code" value="<%=toServiceCode%>">
				<input type="hidden" name="to_service_desc" id="to_service_desc" value="<%=toService_Desc%>">
			</td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			<td class='querydata'><%=toSubService_Desc%>
				<input type="hidden" name="fr_service_code" id="fr_service_code" value="<%=toSubServiceCode%>">
				<input type="hidden" name="fr_service_desc" id="fr_service_desc" value="<%=toSubService_Desc%>">
			</td>
			<td  class="label" ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><%=to_bed_class_code%>
				<input type="hidden" name="to_bed_class_code" id="to_bed_class_code" value="<%=to_bed_class_code%>" >
				<input type="hidden" name="to_bed_class_short_desc" id="to_bed_class_short_desc" value="<%=to_bed_class_code%>" >
			</td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><input type="hidden" name="to_bed_no" id="to_bed_no" value="<%=to_bed_no%>" > <%=to_bed_no%></td>
			<td  class="label" ><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><input type="hidden" name="fr_room_no" id="fr_room_no" value="<%=to_room_no%>" > <%=to_room_no%> </td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td class='columnheader' colspan=4  width="100%"><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><%=toSplDesc%>
				<input type="hidden" name="to_specialty_code" id="to_specialty_code" value="<%=toSplDesc%>">
				<input type="hidden" name="to_specialty_desc" id="to_specialty_desc" value="<%=toSplCode%>">
			</td>
			<td  class="label" ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='querydata' id="PractDesc"  nowrap><%=toPractName%>
				<input type="hidden" name="to_practitioner_id" id="to_practitioner_id" value="<%=toPractId%>">
				<input type="hidden" name="to_practitioner_name" id="to_practitioner_name" value="<%=toPractName%>">
			</td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>			
			<td  class="label" ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td  class='querydata' id="MedTeamDesc" ><%=toMedTeam_Desc%>
			<input type="hidden" name="to_req_team_id" id="to_req_team_id" value="<%=toMedTeam%>">
			<input type="hidden" name="to_req_team_desc" id="to_req_team_desc" value="<%=toMedTeam_Desc%>">
			</td>
			<td class='label' nowrap ><fmt:message key="eIP.PractitionerDesignation.label" bundle="${ip_labels}"/></td>
			<td  class='querydata' ><%=topractdesg%>
			<input type='hidden' name='practitioner_designation' id='practitioner_designation' value="<%=topractdesg%>">
			</td> 
		<tr>
			<td class='columnheader' colspan=4  width="100%"><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></td>
		</tr>		
		<tr>			
			<td colspan=1 class='label' nowrap ><fmt:message key="eIP.InformedPatientRelatives.label" bundle="${ip_labels}"/></td>
			<%
				if (INFORMED_YN.equals("Y"))
					chkValue = "Checked";
				else chkValue = "";
			%>
			<td class='fields'><input type='checkbox' name='info_pat_relatives' id='info_pat_relatives' <%=chkValue%> disabled><input type="hidden" name="informed_yn" id="informed_yn" value = "<%=INFORMED_YN%>" ></td>
			<td class='label' nowrap ><fmt:message key="Common.InformedDate/Time.label" bundle="${common_labels}"/></td>
			<td  class='querydata' ><%=INFORM_DATE_TIME_CONVERTED%>
			<input type="hidden" name="info_dat_time" id="info_dat_time" value="<%=INFORM_DATE_TIME%>">
			</td> 
		</tr>
				<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>			
			<td  class="label" ><fmt:message key="eIP.InformedTo.label" bundle="${ip_labels}"/></td>
			<%if(INFORMED_TO.equals("01"))
		{%>
			<td  class='querydata' ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></td>
		<%}else if(INFORMED_TO.equals("02")){%>		
			<td  class='querydata' ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></td>
			<%}else if(INFORMED_TO.equals("03")){%>
			<td  class='querydata' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
			<%}else{%>
				<td  class='querydata' >&nbsp;</td>
			<%}%>
			<input type="hidden" name="informed_to" id="informed_to" value="<%=INFORMED_TO%>">
			<td  class="label" ><fmt:message key="eIP.InformedToName.label" bundle="${ip_labels}"/></td>
			<td  class='querydata' ><%=INFORMED_NAME%>
			<input type="hidden" name="informed_to" id="informed_to" value="<%=INFORMED_NAME%>">
			</td>
		</tr>
		<tr>
			<td class='columnheader' colspan=4  width="100%"><fmt:message key="Common.CancellationDetails.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			</td>
			<td class='label' nowrap ><fmt:message key="eIP.DateTimeOfAuthTransfer.label" bundle="${ip_labels}"/></td>
			<td  class='querydata' colspan="3"><%=AUTH_DATE_TIME_CONVERTED%>
			<input type='hidden' name="auth_dat_time" id="auth_dat_time" value="<%=AUTH_DATE_TIME%>">
			</td>
		</tr>
		<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td class="label" ><fmt:message key="Common.AuthorizingPractitioner.label" bundle="${common_labels}"/></td>
			<td class="fields" ><input type='hidden' name='practid' id='practid' value="" readonly><input type='text' name='pract_desc' id='pract_desc' value="" size='35' maxlength='30' onblur="BeforeGetPractitioner(document.forms[0].practid,pract_desc, '<%=facilityId%>');" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button'  onClick="checkPractTxtVal(document.forms[0].practid,document.forms[0].pract_desc,'<%=facilityId%>');"><img src="../../eCommon/images/mandatory.gif"><input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=frpractdesc%>"></td><td class='labal'></td><td class='labal' >&nbsp;</td>
		</tr>
			<tr><td class='labal' colspan=4 height="6"></td></tr>
		<tr>
			<td  class="label" ><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
			<td colspan="3" class='fields'>
				<select name="cancel_reason" id="cancel_reason">
					<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<% //Query changed on 21/06/2004 by Sen
						String reasonQuery = "select contact_reason_code, am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1)contact_reason from am_contact_reason where eff_status = 'E' and cancel_transfer_yn = 'Y' order by 2";
				
						String reason_code =  "";
						String reason_desc =  "";
						
						if (statement != null )	statement = null;
						if (resultSet != null )	resultSet = null;
						
						statement	=	con.createStatement();
						resultSet	=	statement.executeQuery(reasonQuery);
						if (resultSet != null)
						{
							while (resultSet.next())
							{
								reason_code = checkForNull(resultSet.getString("contact_reason_code"));
								reason_desc = checkForNull(resultSet.getString("contact_reason"));
								out.println("<option value = "+reason_code+" >"+reason_desc+"</option>");
							}
						}
					%>
				</select>
				<img id="img_trans_in" src="../../eCommon/images/mandatory.gif">
			</td>
		</tr>
		<tr>
			<td class='labal' >&nbsp;</td><td class='labal' >&nbsp;</td>			<td class='labal' >&nbsp;</td><td><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmCancel.label","common_labels")%>" name="cancel" onClick="submitMe();" ><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortCancel.label","ip_labels")%>" onclick="const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();"></td>
		</tr>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
		<input type="hidden" name="to_bed_type_code" id="to_bed_type_code" value="">
		<input type="hidden" name="fr_team_id" id="fr_team_id" value="">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="fr_nursing_code" id="fr_nursing_code" value="<%=fr_nursingunit_code%>">
		<input type="hidden" name="frsplcode" id="frsplcode" value="<%=frSplCode%>">
		<input type="hidden" name="TFR_REQ_REF_NO" id="TFR_REQ_REF_NO" value="<%=TFR_REQ_REF_NO%>">
		<input type="hidden" name="locale1" id="locale1" value="<%=locale%>">
	</table>
</form>
<%		
	}catch(Exception e){
		e.printStackTrace();
	}
	finally {
		if(statement != null)		statement.close();
		if(resultSet != null)		resultSet.close();
		ConnectionManager.returnConnection(con,request);
	}
	 %>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


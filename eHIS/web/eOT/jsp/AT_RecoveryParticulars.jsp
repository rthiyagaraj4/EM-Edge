<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>

<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function callRecordVitals(){
	var formObj =  parent.parent.AnaesthesiaHdrFrame.RecordAnesthesiaHdrForm;
	 var speciality_code =""; // formObj.speciality_code.value;
	 var discr_msr_id  = formObj.discr_msr_id.value;
	 var patient_id = formObj.patient_id.value;
	 var episode_id = formObj.episode_id.value;
	 var sex = formObj.sex.value;
	 var dob = formObj.dob.value;
	 var encounter_id = formObj.encounter_id.value;
	 var patient_class = formObj.patient_class.value;
	 var episode_type = formObj.episode_type.value;
	 var window_name = patient_id+encounter_id;
	 var url = "../../eCA/jsp/DisDataCharting.jsp?option_id=VITAL_SIGNS1&patient_id="+patient_id+"&visit_id=&episode_id="+episode_id+"&encounter_id="+encounter_id+"&location_code=&location_type=&bed_num=&room_num=&episode_type="+episode_type+"&discharge_date=&visit_adm_date=&episode_Status=&Sex="+sex+"&Age=&Dob="+dob+"&security_level=&protection_ind=&reln_req_yn=N&patient_class="+patient_class+"&PQ=Y&CA=N&relationship_id=&window_name="+window_name+"&child_window=Y&mode=R&module_id=AT&discr_msr_id="+discr_msr_id;
	var retVal;
	var dialogHeight = "60" ;
	var dialogWidth  = "70" ;
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal  = window.open(url, arguments, features);
		
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'RecoveryParticularsForm' >
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>'>
<table border='0' cellpadding=3='3' cellspacing='0' width='100%'>
<tr>
	 <td class='label' align='right' nowrap>
	 <fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/>
	 </td>
     <td align='left' class='fields' nowrap>
		<input type='text' name='start_date' id='start_date'  size='10' readonly > 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('start_date'); "  > <img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='start_time' id='start_time'  size='6' onBlur="checkTimeFormat(this)" maxlength="5">
		<fmt:message key="eOT.FinishDateTime.Label"  bundle="${ot_labels}"/>
		<input type='text' name='finish_date' id='finish_date'  size='10' readonly > 
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('finish_date'); "  > <img src='../../eCommon/images/mandatory.gif'></img>
		<input type='text' name='finsih_time' id='finsih_time'  size='6' onBlur="checkTimeFormat(this)" maxlength="5"> 
	</td>

	<td  class ="fields" width ="25%" nowrap>
	
		<input type='button' class='button' value='<fmt:message key="eOT.RecordVitals.Label" bundle="${ot_labels}"/>' 
		onclick="callRecordVitals();">
	</td>
	
</tr>
</body>
</form>
</html>


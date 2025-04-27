<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
10/01/2018	IN067564		Ramya Maddena		10/09/2018		Ramesh Goli		ML-MMOH-CRF-1186
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,eCommon.Common.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>	
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCA/js/CABallardScore.js' language='javascript'></script>
	<script language='javascript'>
	
	function isNumeric(obj) {
	var numb = '0123456789';
	var inputparam = obj.value;
	var blnVal = isValid(inputparam,numb);
	if(blnVal == false)
	{
	obj.value = '';
	alert(getMessage("CHARACTER_NOT_ALLOWED",'CA')); 
	obj.focus();
	return blnVal;
	}
	else
	{
	return blnVal;
	}
	}

	function isValid(parm,val) {
	if (parm == "") return true;
	for (i=0; i<parm.length; i++) {
	if (val.indexOf(parm.charAt(i),0) == -1) return false;
	}
	return true;
	}
	function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	document.getElementById(str).focus();
	return flg;
}

function populateControl(){
	var date_from  = document.forms[0].date_from.value;
	var date_to  = document.forms[0].date_to.value;
	var patient_id  = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "patient_id=\""+ patient_id +"\" encounter_id=\""+ encounter_id +"\" date_from=\""+ date_from +"\" date_to=\""+ date_to +"\" action='getCount' " ;	
	xmlStr +=" /></root>" ;
 	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "CABallardScoreIntermediate.jsp", false ) ;	
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	var RecordedScoreYN = trimString(responseText);
	
	if(RecordedScoreYN == 'Y'){
		parent.BallardScoreAuditDetailsFrm.location.href='../../eCA/jsp/CABallardScoreAuditDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&date_from='+date_from+'&date_to='+date_to+'&view_history_yn=Y' ;
		//parent.BallardScoreAuditResultFrm.location.href='' ;
		//parent.BallardScoreAuditPrintFrm.document.forms[0].print.disabled = false;
	}else{
		alert("APP-000061 Query Caused no records to be retrieved");
		parent.BallardScoreAuditDetailsFrm.location ="../../eCommon/html/blank.html";
		parent.BallardScoreAuditResultFrm.location ="../../eCommon/html/blank.html"; 
		parent.BallardScoreAuditPrintFrm.document.forms[0].print.disabled = true;
	
	}
}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	 String locale = (String) p.getProperty("LOCALE");
	 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	 String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

String date_from="",date_to="";
	
	if (date_from.equals(""))
	{
		date_to		= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		date_from	= com.ehis.util.DateUtils.minusDate(date_to,"DMYHM",locale,30,"d");
	}
	else
	{
		date_to = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMYHM","en",locale);				
	}	
	
		%>
			<form name="BallardScoreCriteria" id="BallardScoreCriteria">

<table  cellpadding=3 cellspacing=0 width="100%" align=center border=0>
<tr>
			
<td class="label" width='15%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields" width='35%' >
				<input type="text" maxlength=16 size="16" value='<%=date_from%>' name="date_from"  id="date_from" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('date_from');" /> &nbsp;
		
				<input type="text" maxlength=16 size="16" value='<%=date_to%>' name="date_to"  id="date_to" onBlur='chkDateTime(this,"DMYHM","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('date_to');" >  </td>
				<td class="label" id="encid" style="" width='15%'>
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td>
				<input type="text" name="encounter_id" id="encounter_id" value="<%=encounterid%>" maxlength=12 size=13 onKeyPress = 'return allowValidNumber(this,event,12,0)' onblur = 'isNumeric(this)'>
				</td>
				<td>
				<input type="button" class=button name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="populateControl()">&nbsp;
				</td>
		</tr>
		
		</table>
	
		<input type="hidden" name="enc_id" id="enc_id" value="<%=request.getParameter("encounter_id")%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		
		</body>
</html>
<Script>
populateControl();
</Script>


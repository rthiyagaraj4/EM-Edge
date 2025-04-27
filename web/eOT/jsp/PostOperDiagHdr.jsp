<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<HTML>
	<%@ page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">
function assignPostOperDiag(){
	//var formObjHdr =parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var formObjCommon =parent.parent.ObjectCollect;
	//alert(formObjCommon.diagnosis_text);
	var formObj = document.forms[0];
	formObj.diagnosis.value = formObjCommon.diagnosis_text;	
}
function updateDiagText(){
	var formObjCommon =parent.parent.ObjectCollect;
	var formObj = document.forms[0];
	formObjCommon.diagnosis_text=formObj.diagnosis.value;
	formObjCommon.DIAG_MODIFIED_FLAG="OFF";
	//alert(parent.parent.ObjectCollect.diagnosis_text.length);
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<% String disable_flag="";
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	if(surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";
%>
<BODY onLoad="assignPostOperDiag();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = "PostOperDiagHdrForm">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr>
	<td class='label' width="25%" nowrap >
		<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
	</td>
	<td  class='fields' width="25%" >
		<textarea name='diagnosis' rows='5' cols='80'  <%=disable_flag%> onChange='checkLimit(this,500);updateDiagText();' > </textarea>
	</td>
</tr>
<tr>
	<td class='CAGROUPHEADING'> 
		<fmt:message key="Common.ProblemAssessment.label" bundle="${common_labels}"/>
	</td> 
</tr>
</table>
</form>
</body>
</HTML>


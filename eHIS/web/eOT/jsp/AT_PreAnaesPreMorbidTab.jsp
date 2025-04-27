<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<html>
<head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
</head>
<script language="javascript">

function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.RecordAnesthesiaPreMorbidForm;

	var old_objStr = "";
	if(objStr=="PreMorbidDetails")
		old_objStr = "pre_morbid_details";

	var params=frmObj.params.value;
	params=params+"&tab_name1="+old_objStr;
	parent.pre_morbid_details_tab_frame.location.href='../../eOT/jsp/AT_PreAnaesPreMorbidTabFrames.jsp?'+params
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="RecordAnesthesiaPreMorbidForm" id="RecordAnesthesiaPreMorbidForm">
<table id="tab" cellspacing="0" cellpadding=3 border="0" width="100%">
	<ul id="tablist" class="tablist">
		<li class="tablistitem" title='<fmt:message key="eOT.PremorbidDetails.Label" bundle="${ot_labels}"/>'>
			<a onclick="changeTab('PreMorbidDetails');" 
			class="tabclicked" id="PreMorbidDetails">
				<span class="tabSpanclicked" id="PreMorbidDetailsspan">
					<fmt:message key="eOT.PremorbidDetails.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
	</ul>
</table>
	<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
</form>
</body>
</html>
	<script>
	prevTabObj='PreMorbidDetails';
	changeTab('PreMorbidDetails') ;
	</script> 


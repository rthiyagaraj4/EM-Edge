<!DOCTYPE html>
<html>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<!--<script src="../../eCP/js/common.js" language="JavaScript"></script>-->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>-->
<script src="../../eCP/js/ViewCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String index=request.getParameter("index");
	if(index== null) index="1";
%>
<body onLoad="change_common_tab('Diagnosis','ON_LOAD','<%=index%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="OrCommonForm" id="OrCommonForm">
	<table id="tab" cellspacing=0 cellpadding="1" border="0">
	<tr>
		<td id="assessment" 	class="CAFIRSTSELECTHORZ"  onclick="changeColor(this)" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('Assessment','ON_CLICK','<%=index%>')">Assessment</a></td>
		<td id="diagnosis" 	class="CASECONDSELECTHORZ"  onclick="changeColor(this)" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('Diagnosis','ON_CLICK' ,'<%=index%>')">Diagnosis</a></td>
		<td id="variance" 	class="CAFIRSTSELECTHORZ"  onclick="changeColor(this)" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('Variance','ON_CLICK' ,'<%=index%>')">Variance</a></td>
</tr>
</table>
</form>
</body>
</html> 

 


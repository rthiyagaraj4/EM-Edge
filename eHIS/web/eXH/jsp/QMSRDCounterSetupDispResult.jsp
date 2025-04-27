<!DOCTYPE html>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>

<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script> 
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script language="JavaScript">
function initFunc()
{
	
	if((/^APP-XH0001/).test('${param.stMessage}')) // Refreshing the fields only if success
	{
		var requestParams = "requestType=COUNTER_INFO&sectionCode=${param.sectionCode}&studyLocation=${param.studyLocation}&facilityID=${param.facilityID}";
		if("DELETE" == "${param.requestType}") requestParams = "requestType=QUERY";
		parent.frames[1].document.location.href = "../servlet/eXH.QMSRDCounterSetupServlet?" + requestParams;
	}
}

</script>

											   
</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initFunc()">
<form>
<p align="left">																					    
${param.stMessage}
</p>	
</form>
</BODY>															  
</html>																						 		 


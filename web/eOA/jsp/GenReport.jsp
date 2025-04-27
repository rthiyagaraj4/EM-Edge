<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
%>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script>
	

async function Openwin()
{
	var retVal = 	new String();
	var dialogHeight= "13" ;
	var dialogWidth	= "27" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eCommon/jsp/report_options_frameset.jsp?<%=params%>",arguments,features);	
	
	if(retVal == null){}	
	else		
		window.open("../../eCommon/jsp/report_process.jsp?"+retVal,null,'status=no,toolbar=no,menubar=no,location=no');
}

</script>
<html>
<body onLoad='Openwin()' BGCOLOR='#B2B6D7' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

</body>
</html>



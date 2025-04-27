<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"  import="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper "%>
 <html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eOA/js/Validate.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
%>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' >
		<tr>
			<td   align='right' colspan=6 width="100%"> 
			<input type="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="patHistWindow(this,'<%=patient_id%>')">
					<input type = 'button' name='CANCEL' id='CANCEL' value = '<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="patHistWindow(this,'<%=patient_id%>')"  class="BUTTON" ></input>
			</td>
		</tr>
	</table>
</html>


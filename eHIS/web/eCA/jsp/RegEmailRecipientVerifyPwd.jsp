<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<%
Connection con=null;
try{%>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String title=(request.getParameter("title")==null)?"":request.getParameter("title");
String password="";
eCA.RegEmailRecipientBean CA_RegEmailRecipientBean = (eCA.RegEmailRecipientBean)getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
con =	ConnectionManager.getConnection(request);
String appl_user_id=(String)session.getValue( "login_user" ) ;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
password=CA_RegEmailRecipientBean.getCurrUserPwd(con,appl_user_id,locale);
putObjectInBean("CA_RegEmailRecipientBean",CA_RegEmailRecipientBean,session);
%>
<title><%=title%></title>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="RegEmailRecipientVerifyPwd" id="RegEmailRecipientVerifyPwd" action="" method="post" target="dummyFrame">
<table border=0 cellspacing=0 cellpadding='3' width='100%' align="center">
<tr>
	<td class=label><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="password" name="enteredPwd" id="enteredPwd" value="" autocomplete="off"></td><!--41670 autocomplete="off"-->
	<td>&nbsp;</td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
	<td class=label align='right' width='6%'><input type='button' class='button' name='close' id='close' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='chkPwd(enteredPwd)'><input type='button' class='button' name='close' id='close' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick='window.close()'</td>
<input type="hidden" name="actualPwd" id="actualPwd" value="<%=password%>">
</tr>
</table>
</form>
</body>
<%}catch(Exception e){
		
		e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}%>

</html>


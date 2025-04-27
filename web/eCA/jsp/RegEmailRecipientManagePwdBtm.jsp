<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<%    
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con=null;
eCA.RegEmailRecipientBean CA_RegEmailRecipientBean = (eCA.RegEmailRecipientBean)getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
try{
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String mailer_id=request.getParameter("mailer_id")==null?"":request.getParameter("mailer_id");
String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
String srl_no=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
con =	ConnectionManager.getConnection(request);
String password=CA_RegEmailRecipientBean.getNewPassword(mailer_id,mode,con);
String maxEffDate=CA_RegEmailRecipientBean.maxEffDate(mailer_id,con,locale);

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
 --><script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="RegEmailRecipientManagePwdBtm" id="RegEmailRecipientManagePwdBtm" action="" method="post" target="messageFrame">
<table border=0 cellspacing='0' cellpadding='3' width='100%' align="center">
<tr>
	<td class='label' align='left' ><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/>&nbsp;:&nbsp;</td>
	<td class='fields' align='right'><input type="text" name="srl_no" id="srl_no" readonly value="<%=srl_no%>"></td>
	<td>&nbsp;</td>
</tr>
<tr>
<td class='label' align='left' ><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/>&nbsp;:&nbsp;</td>
<td class='fields' align='right'><input type='textbox' id='from_date' name='fromDate' id='fromDate' value='<%=maxEffDate.trim()%>' size='14' maxlength='16' onblur='CheckDateTime(this,"DMYHM","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date')"></img><img src='../../eCommon/images/mandatory.gif'></td>
<td>&nbsp;</td>
</tr>

<tr>
	<td class="label" ><fmt:message key="Common.password.label" bundle="${common_labels}"/>&nbsp;:&nbsp;</td>
	<td class='fields'><input type="password" name="password" id="password" value="<%=password%>" readonly size='8' maxlength='8' autocomplete="off"></td><!--41670 autocomplete="off"-->
	<td>&nbsp;</td>
</tr>
<tr>
	<td class='label' colspan='2'>&nbsp;</td>
	<td class='fields' align='right' width='8%'><input type='button' class='button' name='save' id='save' value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>' onclick="addToList()"></td>
</tr>
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="mailer_id" id="mailer_id" value="<%=mailer_id%>">
<input type="hidden" name="maxEffDate" id="maxEffDate" value="<%=maxEffDate%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
</table>
</form>
</body>
<%}catch(Exception e){
	
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}
putObjectInBean("CA_RegEmailRecipientBean",CA_RegEmailRecipientBean,session);	
%>
</html>


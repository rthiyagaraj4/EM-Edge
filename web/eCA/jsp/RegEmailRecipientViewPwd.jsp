<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,java.text.*,java.util.*,eCA.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,javax.servlet.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head>

 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	eCA.RegEmailRecipientBean CA_RegEmailRecipientBean = (eCA.RegEmailRecipientBean)getObjectFromBean("CA_RegEmailRecipientBean","eCA.RegEmailRecipientBean",session);
	String title=request.getParameter("title")==null?"":request.getParameter("title");
	String mailer_id=request.getParameter("mailer_id")==null?"":request.getParameter("mailer_id");
	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	String password="";
	String from_date="";
	from_date=request.getParameter("from_date");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	if(from_date ==null ||from_date.equals("")){
		from_date		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	}
	Connection con=null;

%>
<title><%=title%></title>
</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="RegEmailRecipientViewPwd" id="RegEmailRecipientViewPwd" action="" method="post" target="messageFrame">
<table border=0 cellspacing='0' cellpadding='3' width='100%' align="center">
<tr><td colspan='3'>&nbsp;</td></tr>
<tr>
	<td class='label' align='right' width="40%" nowrap><b><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></b></td>
	<td class='fields' align='left'>&nbsp;:&nbsp;</td>
	<td class='fields' align='left'><%=from_date%></td>
</tr>
<tr><td colspan='3'>&nbsp;</td></tr>
<tr>
<%
	try{
		if(CA_RegEmailRecipientBean.getPassword()==null || (CA_RegEmailRecipientBean.getPassword()).isEmpty() || (CA_RegEmailRecipientBean.getPassword()).size()==0){
		CA_RegEmailRecipientBean.clearBean();
		con =	ConnectionManager.getConnection(request);
		password=CA_RegEmailRecipientBean.getNewPassword(mailer_id,mode,con);		
		CA_RegEmailRecipientBean.setPassword(new String[]{"1",from_date,null,password});	
		}else{
			String[] pwdval	=(String[])CA_RegEmailRecipientBean.getPassword().get(0);
			password=pwdval[3];
		}
	}catch(Exception e){
		out.println("Exception@1: "+e.toString());
		e.printStackTrace();
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
	
%>
	<td class='label' align='right' width="40%" nowrap><b><fmt:message key="Common.password.label" bundle="${common_labels}"/></b></td>
	<td class='fields' align='left'>&nbsp;:&nbsp;</td>
	<td class='fields' align='left'><%=password%></td>
</tr>
<tr>
	<td class='label' colspan='2'>&nbsp;</td>
	<td class='fields' align='right' width='55%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="window.returnValue='<%=from_date%>';window.close();"></td>
</tr>
<input type="hidden" name="from_date" id="from_date" value="<%=from_date%>">
<tr><td colspan='3'>&nbsp;</td></tr>
</table>
</form>
</body>
</html>
<%putObjectInBean("CA_RegEmailRecipientBean",CA_RegEmailRecipientBean,session);	%>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.Tableforchat.label" bundle="${ca_labels}"/></title>
<%@ page import="javax.naming.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- <link rel="stylesheet" type="text/css" href="../html/IeStyle.css"></link> -->
<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
<script src='../../eCA/js/InstantMessengerChat.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%


	String loginUserId = (String)session.getValue("login_user");//to get the logged in user
	//Context ctx = new InitialContext();
	//HashMap map = (HashMap)ctx.lookup("chat");

%>
<body class='CONTENT'onMouseDown="CodeArrest()"onKeyDown="lockKey()" onscroll="scrollHeader()" >
<script>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
</script>
<form name ="tableForm" >
<div id='divTableNum' style='postion:relative'>
<TABLE cellpadding='3' cellspacing='0' border='0' width='100%'  >
<TR>
	<td ><font color='brown' size='2' style='font-weight:bold' ><fmt:message key="Common.user.label" bundle="${common_labels}"/> : <%=loginUserId%></font></td>
	<td align=right id ="no_of_users"><font color='brown' size='2' style='font-weight:bold' >
	</font></td>
</tr>
</table>
</div>
<div id='divTableHeader' style='postion:relative'> 
<table width ="100%" cellspacing="1" id="TabHead" >
		<tr>
			<td class='COLUMNHEADERCENTER' >
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td class='COLUMNHEADERCENTER'>
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>
			<td class='COLUMNHEADERCENTER'>
				<fmt:message key="Common.Message.label" bundle="${common_labels}"/>
			</td>
		</tr>
</table>
</div>
<table width ="100%" cellspacing="1" id="chattable">
		<tr>
		<td ></td>			
		<td ></td>			
		<td ></td>				
		</tr>
</table>
<input type="hidden" name=hiddenvar1 value=<%=loginUserId%>>
</form>
</body>
</html>


<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DispenseRights.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<TITLE><fmt:message key="ePH.UserProfile.label" bundle="${ph_labels}"/></TITLE>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">


<%
	/* Mandatory checks start*/
	String bean_id		= "DispenseRightsBean" ;
	String bean_name	= "ePH.DispenseRightsBean";
	String user_id		= request.getParameter( "user_id" ) ;
	/* Mandatory checks end*/

	DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	String oldPassWordForUser	= bean.getUserPass(user_id);//commented for GDOH-CRF-0086 [IN:058551]
	String login_user_id = bean.getLoginById();//added for GDOH-CRF-0086 [IN:058551]
	String oldPassWord	= bean.getUserPassForLoginUser();//added for GDOH-CRF-0086 [IN:058551]
	String newPassWord	= bean.getPassWord();

%>
<FORM name="formDispenseRightsUserProf" id="formDispenseRightsUserProf">
	<INPUT TYPE="hidden" name="CURR_PASSWORD" id="CURR_PASSWORD" VALUE="<%= oldPassWord %>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="login_user_id" id="login_user_id" VALUE="<%= login_user_id %>"><%-- added for GDOH-CRF-0086 [IN:058551] --%>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD COLSPAN="2">&nbsp;</TD>
	</TR>

<%

	if (!oldPassWordForUser.equals("") && newPassWord.equals("")) {
%>

	<TR>
		<TD CLASS="label" WIDTH="32%"><fmt:message key="Common.login.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.password.label" bundle="${common_labels}"/>&nbsp;</TD><%-- changed label GDOH-CRF-0086 [IN:058551] --%>
		<TD WIDTH="68%"><INPUT TYPE="password" VALUE="" name="OLD_PASSWORD" id="OLD_PASSWORD" SIZE="20" MAXLENGTH="20" autocomplete="off"></TD> <!--41741 autocomplete="off"-->
	</TR>

<%
	}
%>

	<TR>
		<TD CLASS="label" WIDTH="32%"><fmt:message key="Common.newPassword.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD WIDTH="68%"><INPUT TYPE="password" VALUE="<%= newPassWord %>" NAME="NEW_PASSWORD" SIZE="20" MAXLENGTH="20" autocomplete="off"></TD><!--41741 autocomplete="off"-->
	</TR>				 
	<TR>
		<TD CLASS="label" WIDTH="32%"><fmt:message key="Common.ConfirmPassword.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD WIDTH="68%"><INPUT TYPE="password" VALUE="<%= newPassWord %>" NAME="CONF_PASSWORD" SIZE="20" MAXLENGTH="20" autocomplete="off"></TD>  <!--41741 autocomplete="off"-->
	</TR>
	<TR>
		<TD COLSPAN="2">&nbsp;</TD>
	</TR>
	</TABLE>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD CLASS="WHITE" COLSPAN="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD CLASS="WHITE" WIDTH="50%" align='right'><INPUT TYPE="button" CLASS="button" name="OKBtn" id="OKBtn" VALUE='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="checkPass()">&nbsp;</TD>
		<TD CLASS="WHITE" WIDTH="50%"><INPUT TYPE="button" CLASS="button" name="CancelBtn" id="CancelBtn" VALUE='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="parent.document.getElementById('dialog_tag').close();"></TD>
	</TR>
	</TABLE>
</FORM>
<%
putObjectInBean(bean_id,bean,request);
%>


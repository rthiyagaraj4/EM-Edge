<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
	 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedicationAllStages.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.PINValidation.label" bundle="${ph_labels}"/></title>
</HEAD>
<%
		String bean_id = "DispMedicationBean" ;
		String bean_name = "ePH.DispMedicationBean";
		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		//bean.setLanguageId(locale);
		String user_pin = bean.getApplPassword();
		String user_pwd = bean.getPassword();
	%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">  
<form name="frmDispMedicationAuthorize" id="frmDispMedicationAuthorize">
<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" >
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td  class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;<input type="password" name="user_password" id="user_password" size="40" maxlength="60" value="" autocomplete="off"><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>  <!--41741 autocomplete="off"-->
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;<input type="password" name="user_pin" id="user_pin" size="40" maxlength="60" value="" autocomplete="off"><img src="../../eCommon/images/mandatory.gif" align="center"></img>      <!--41741 autocomplete="off"-->
	</td> 
</tr>
<tr>
	<td class="white" colspan="2"></td>
</tr>
<tr>
	<td  colspan="2">
	<input type="button" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="validateAuthorization('OK')">&nbsp;<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.close();"></td>
</tr>
<tr>
	<td class="white" colspan="2">&nbsp;</td>
</tr>
<tr>
	<td class="white" colspan="2"></td>
</tr>
<!-- <tr>
<td class="white" colspan="2"><label style="font-size:10;color:red"><fmt:message key="ePH.PINisrequiredtoDispenseNarcoticControlledDrugs.label" bundle="${ph_labels}"/></label></td>
</tr> -->
</table>

<input type="hidden" name="orig_user_pwd" id="orig_user_pwd" value="<%=user_pwd%>">
<input type="hidden" name="orig_user_pin" id="orig_user_pin" value="<%=user_pin%>">
</form>
</body>
</html>

<%
//putObjectInBean(bean_id,bean,request);
%>


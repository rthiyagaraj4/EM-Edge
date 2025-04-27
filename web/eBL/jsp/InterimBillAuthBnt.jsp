<!DOCTYPE html>
<!-- 
Sr No           Version             Incident			SCF/CRF                      Developer Name
1               V201218             IN73702        MMS-DM-CRF-0100.1         		Palani Narayanan
-->

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*, eBL.RecordApprovalPatientDataBean" contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale	= (String)session.getAttribute("LOCALE");
	String auth1="N";
	String strdisableBut= "disabled";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/BillingInterimBillScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<form name='AuthFormBtnFrm' id='AuthFormBtnFrm' id='AuthFormBtnFrm'>
		<div style="text-align:right; width:92%; padding:0;">
		<input type="button" class='button' name="auth" id="auth"	id="auth"  disabled	 value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels")%>" onClick='authUser(this);'  >
		</div>
		<input type= hidden name="auth1" id="auth1"  value='<%=auth1%>'>
	</form>
</body>
</html>


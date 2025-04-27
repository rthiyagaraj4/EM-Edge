<!DOCTYPE html>
<!-- 
Sr No           Version             Incident			SCF/CRF                      Developer Name
1               V201218             IN73702        MMS-DM-CRF-0100.1         		Palani Narayanan
-->
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../js/BillingInterimBillScript.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
		String params = request.getQueryString() ;
		
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eBL/jsp/CommonToolBarIntrime.jsp?<%=params %>'  frameborder=0 scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
<iframe name='Billing_InterimBill_Search' id='Billing_InterimBill_Search' 	src='BillingInterimBillSearch.jsp?<%=params %>' frameborder=0 scrolling='no' noresize style='height:15vh;width:100vw'></iframe>
<iframe name='recordApprovalPatientDataDetails' id='recordApprovalPatientDataDetails'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:65vh;width:100vw'></iframe>
<iframe name='interim_Bill_Auth_Bnt' id='interim_Bill_Auth_Bnt'		src='InterimBillAuthBnt.jsp' frameborder=0 noresize scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' scrolling='auto' frameborder=0 noresize style='height:5vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder=0 noresize style='height:5vh;width:100vw'></iframe>

</html>


<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      Name     			Description
--------------------------------------------------------------------------------------------------------------
16-Nov-2013      100           	Karthikeyan.K          created for MMS-CRF-0023
---------------------------------------------------------------------------------------------------------------
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eBL/js/OutpatientPharmacyBillRuleSetup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
%>

   <iframe name='DummyFrame' id='DummyFrame'	src='../../eCommon/html/blank.html'  frameborder=0  style='height:0vh;width:100vw'></iframe>
   <iframe name='DataFrame' id='DataFrame' src='../../eBL/jsp/PkgDefBasePricePartialDeposit.jsp?<%=params%>' frameborder=0  style='height:100vh;width:100vw'></iframe>	  
</HTML>


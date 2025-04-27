<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DrugMaster.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>	
<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
	String url_1 = "../../ePH/jsp/DrugMasterMain.jsp?" ;   
	String params = request.getQueryString() ;
	String source_1 = url_1 + params ;
%>
<iframe name="drugMasterMain" id="drugMasterMain" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source_1%>" style="height:26vh;width:100vw"></iframe>
<iframe name="f_drug_tabs" id="f_drug_tabs" FRAMEBORDER="0" SCROLLING="no" NORESIZE  SRC="../../eCommon/html/blank.html" style="height:4vh;width:100vw"></iframe>
<iframe name="f_tab_detail" id="f_tab_detail" SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:70vh;width:100vw"></iframe>
</HTML>


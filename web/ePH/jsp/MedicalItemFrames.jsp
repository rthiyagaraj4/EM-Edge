<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script language="javascript" src="../js/DrugNameCommonLookup.js"></script>	
<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script language="JavaScript" src="../js/MedicalItem.js"></script>
<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	String url_1 = "../../ePH/jsp/MedicalItemAddModify.jsp?" ;   
	String params = request.getQueryString() ;
	String source_1 = url_1 + params ;
%>
<iframe name="MedicalItemAddModifyFrame" id="MedicalItemAddModifyFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source_1%>" style="height:23%;width:100vw"></iframe><iframe name="f_drug_tabs" id="f_drug_tabs" FRAMEBORDER="0" SCROLLING="no" NORESIZE  SRC="../../eCommon/html/blank.html" style="height:5%;width:100vw"></iframe><iframe name="f_tab_detail" id="f_tab_detail" SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:100vh;width:100vw"></iframe><iframe name="f_tab_add_detail" id="f_tab_add_detail" SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="no" style="height:100vh;width:100vw"></iframe>
</HTML>


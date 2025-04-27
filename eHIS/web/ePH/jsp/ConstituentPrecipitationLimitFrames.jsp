<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String mode			= request.getParameter("mode") ;
String const_from_code			= request.getParameter("const_from_code") ;
String mol_from_code			= request.getParameter("mol_from_code") ;
String const_to_code			= request.getParameter("const_to_code") ;
String mol_to_code			= request.getParameter("mol_to_code") ;
String const_presc_limit_alert			= request.getParameter("const_presc_limit_alert") ;
String func_name			= request.getParameter("func_name") ;
String seq_no			= request.getParameter("seq_no") ;
String alertYN			= request.getParameter("alertYN") ;
	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/ConstituentPrecipitationLimit.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT") )){%>
<iframe name="ConstituentPrecipitationLimitCriteria" id="ConstituentPrecipitationLimitCriteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/ConstituentPrecipitationLimitCriteria.jsp" style="height:15vh;width:100vw"></iframe><iframe name="ConstituentPrecipitationLimitAddmodify" id="ConstituentPrecipitationLimitAddmodify" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/ConstituentPrecipitationLimitAddModify.jsp?mode=<%=mode%>&const_from_code=<%=const_from_code%>&mol_from_code=<%=mol_from_code%>&const_to_code=<%=const_to_code%>&mol_to_code=<%=mol_to_code%>&const_presc_limit_alert=<%=const_presc_limit_alert%>&func_name=<%=func_name%>&seq_no=<%=seq_no%>" style="height:85vh;width:100vw"></iframe>
<%}else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY") )){
	%>
	<iframe name="ConstituentPrecipitationLimitCriteria" id="ConstituentPrecipitationLimitCriteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/ConstituentPrecipitationLimitCriteria.jsp" style="height:15vh;width:100vw"></iframe><iframe name="ConstituentPrecipitationLimitDisplayResult" id="ConstituentPrecipitationLimitDisplayResult" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/ConstituentPrecipitationLimitDisplayResult.jsp?mode=<%=mode%>&const_from_code=<%=const_from_code%>&mol_from_code=<%=mol_from_code%>&const_to_code=<%=const_to_code%>&mol_to_code=<%=mol_to_code%>&const_presc_limit_alert=<%=const_presc_limit_alert%>&func_name=<%=func_name%>&seq_no=<%=seq_no%>&alertYN=<%=alertYN%>" style="height:85vh;width:100vw"></iframe>
	
	<%}
	else{%>
<iframe name="ConstituentPrecipitationLimitCriteriaBlank" id="ConstituentPrecipitationLimitCriteriaBlank" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe><iframe name="ConstituentPrecipitationLimitQuery" id="ConstituentPrecipitationLimitQuery" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/ConstituentPrecipitationLimitQueryCriteria.jsp" style="height:100vh;width:100vw"></iframe>
	<%}%>
</HTML>


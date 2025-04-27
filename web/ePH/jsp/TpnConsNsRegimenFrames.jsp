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
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
 -->	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TpnConsNsRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String function_id	= request.getParameter("function_id") ;
	String mode			= request.getParameter("mode") ;
	String const_generic_code = request.getParameter("const_generic_code") ;
	String const_srl_no = request.getParameter("const_srl_no") ;
	String conc_percent		 = request.getParameter( "conc_percent" ) ;
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT") )){
%>
<iframe name="f_tpn_cons_ns_regimen_top" id="f_tpn_cons_ns_regimen_top" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TpnConsNsRegimenConsDetails.jsp?mode=<%=mode%>&function_id=<%=function_id%>&const_generic_code=<%=const_generic_code%>&const_srl_no=<%=const_srl_no%>" style="height:32vh;width:100vw"></iframe>
<iframe name="f_tpn_cons_ns_regimen_middle" id="f_tpn_cons_ns_regimen_middle" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:50vh;width:100vw"></iframe>
<iframe name="f_tpn_cons_ns_regimen_bottom" id="f_tpn_cons_ns_regimen_bottom" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:18vh;width:100vw"></iframe>
<%
	}else{		
%>
<iframe name="f_tpn_cons_ns_regimen_top" id="f_tpn_cons_ns_regimen_top" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TpnConsNsRegimenConsDetails.jsp?mode=<%=mode%>&function_id=<%=function_id%>&const_generic_code=<%=const_generic_code%>&const_srl_no=<%=const_srl_no%>&conc_percent=<%=conc_percent%>" style="height:32vh;width:100vw"></iframe>
<iframe name="f_tpn_cons_ns_regimen_middle" id="f_tpn_cons_ns_regimen_middle" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../ePH/jsp/TpnConsNsRegimenInvItemDetails.jsp?const_generic_code=<%=const_generic_code%>&const_srl_no=<%=const_srl_no%>&mode=<%=mode%>&conc_percent=<%=conc_percent%>" style="height:50vh;width:100vw"></iframe>
<iframe name="f_tpn_cons_ns_regimen_bottom" id="f_tpn_cons_ns_regimen_bottom" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/TpnConsNsRegimenButtons.jsp?const_generic_code=<%=const_generic_code%>&const_srl_no=<%=const_srl_no%>&mode=<%=mode%>&conc_percent=<%=conc_percent%>" style="height:18vh;width:100vw"></iframe>
<%
	}
%>
</HTML>


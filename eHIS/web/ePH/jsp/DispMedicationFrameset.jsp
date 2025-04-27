<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String bean_id				= "DispMedicationBean" ;
	String bean_name			= "ePH.DispMedicationBean";
	DispMedicationBean bean		= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	String source				= bean.getSource();
	String issue_token_on_regn  = bean.getIssueTokenOnRegnYN();
	String disp_locn_catg		= bean.getDispLocnCatg();
	String function_id			= CommonBean.checkForNull(request.getParameter("function_id"));
	String homepage			= CommonBean.checkForNull(request.getParameter("homepage")); //added for Bru-HIMS-CRF-073.1 [IN:047222]
	
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:7vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationQueryCriteriaFrameSet.jsp?issue_token_on_regn=<%=issue_token_on_regn%>&disp_locn_catg=<%=disp_locn_catg%>&function_id=<%=function_id%>&homepage=<%=homepage%>" style="height:83vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>	

</html>


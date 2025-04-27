<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>

	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="Javascript" src="../../ePH/js/WardAcknowledge.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%


	
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	//Added for mms-kh-crf-0014 start
	String facility_id		= (String) session.getValue( "facility_id" );
	String bean_id		= "WardAcknowledgeBean";
	String bean_name	= "ePH.WardAcknowledgeBean";
	WardAcknowledgeBean bean = (WardAcknowledgeBean)getBeanObject( bean_id,bean_name,request) ;
	String result = bean.checkToProceed(facility_id.trim());
	
	if(result.equals("N")) {
		%>
		<SCRIPT>alert(getMessage("PH_WARD_ACK_NOT_APPLICABLE","PH"));</SCRIPT>
		
		<SCRIPT>window.location.href ='../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%
	}
	else{//Added for mms-kh-crf-0014 end
	
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/WardAcknowledgementFrames.jsp" style="height:80vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:11vh;width:100vw"></iframe>
</html>
<%} %>


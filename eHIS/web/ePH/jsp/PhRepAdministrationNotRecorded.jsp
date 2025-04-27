<!DOCTYPE html>
 <%-- saved on saved on 07.01.2009 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>
<html>                                
<head> 
<%
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	//
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


	
    <script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../ePH/js/PhRepAdministrationNotRecorded.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String called_from	=	request.getParameter("called_from");

		if(called_from!=null){
%>
	<title><fmt:message key="ePH.AdminNotRecorded.label" bundle="${ph_labels}"/></title>
<%	} %>

</head>                               

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
  
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhRepAdministrationNotRecordedCriteria.jsp" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>

</html>


<!DOCTYPE html>
<!--
CRF Reference No     :  ML-MMOH-CRF-1959
Detected Release  No      :  SEPTEMBER 2023 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  1-07-2023
Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
-->
<%@ page import= "java.text.*,java.sql.Types,java.sql.Statement,java.sql.CallableStatement,java.sql.Connection,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page language="java"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script src="../../eCommon/js/dchk.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" ></script>
	<script language='javascript' src="../js/PatientBHT.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString();
	String module_id = request.getParameter("module_id");
	String source = url + params ;
	String url_name = "PatBHTCriteria.jsp?&pageName=ReceiveBHT&module_id="+module_id;
	String status_url_name = "PatBHTStatus.jsp";
%>


	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source %> frameborder='0' scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<iframe scrolling="no" name='BHT_query' id='BHT_query' src=<%=url_name%>  frameborder=0 style='height:25vh;width:100vw'></iframe>
	<iframe scrolling="auto" name='BHT_result' id='BHT_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:60vh;width:100vw'></iframe>
	<iframe scrolling="no" name='BHT_status' id='BHT_status' src=<%=status_url_name%>  frameborder=0 style='height:5vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>


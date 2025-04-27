<!--
CRF Reference No     :  NMC-JD-CRF-102.18
Detected Release  No      :  MARCH 2024 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  13-03-2024
Purpose of the Change   :  As a PAS user I should be able to record external referrals as well as display "Nphies orders" lookup field to select Nphies orders a multi-selection of orders and thus the selected orders will be displayed in referral screen. 
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All Sites    
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

	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/dchk.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" ></script>       
	<script language='javascript' src="../js/PatientBHT.js"></script>
</head>
<title>NPHIES CODE</title>
<%
	String url = "../../eMP/jsp/RecProcedureCriteria.jsp?" ;
	String params = request.getQueryString();
	//String termDesc = request.getParameter("termDesc");
	//String checkedNPHData=request.getParameter("checkedNPHData");
	String source = url + params ;
	//String url_name = "../../eMP/jsp/RecProcedureCriteria.jsp?"+;
%>


<iframe scrolling="no" name='RecProcedure_query' id='RecProcedure_query' src="<%=source%>"  frameborder=0 frameborder='0' style='height:20%;width:100vw'></iframe><iframe scrolling="auto" name='RecProcedure_result' id='RecProcedure_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize  frameborder='0' style='height:80%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:0%;width:100vw'></iframe>
</html>


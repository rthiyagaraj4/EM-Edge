<!DOCTYPE html>
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
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>  
	<script language='javascript' src="../js/PatientBHT.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString();
	String module_id = request.getParameter("module_id");
	String source = url + params ;
	String url_name = "PatBHTCriteria.jsp?&pageName=DeliveryBHT&module_id="+module_id;
	String status_url_name = "PatBHTStatus.jsp";
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source %> frameborder='0' scrolling='no' noresize style='height:5vh;width:100vw'></iframe>
	<iframe scrolling="no" name='BHT_query' id='BHT_query' src=<%=url_name%>  frameborder=0 style='height:20vh;width:100vw'></iframe><iframe scrolling="no" name='BHT_result' id='BHT_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:65vh;width:100vw'></iframe><iframe scrolling="no" name='BHT_status' id='BHT_status' src=<%=status_url_name%>  frameborder=0 style='height:5vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
</html>


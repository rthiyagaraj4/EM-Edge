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
	<script language='javascript' src='../../eDS/js/LabelStickerForFormula.js'></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	  
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String report_id = request.getParameter("report_id");
	String source = url + params ;
	String url_name = "LabelStickerForFormulaQuery.jsp";
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='label_query' id='label_query' src=<%=url_name%>  frameborder=0 style='height:0vh;width:100vw'></iframe>
	<iframe scrolling="auto" name='label_result' id='label_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:92vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
</html>


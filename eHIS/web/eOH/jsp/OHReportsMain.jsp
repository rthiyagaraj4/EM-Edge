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
	<script src="../../eOH/js/OHReports.js" ></script>
	<script src="../../eCommon/js/dchk.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String function_id = request.getParameter("function_id");
	String source = url + params ;
	String url_name = "";

	if(function_id.equals("OH_OHRPERBY_REPORTS")){
		url_name = "Rep_TrmtPerfByDateDentist.jsp";
	}else if(function_id.equals("OH_OHRSTMON_REPORTS")){
		url_name = "Rep_StatsByDentistMonth.jsp";
	}else if(function_id.equals("OH_OHRSCGDT_REPORTS")){
		url_name = "Rep_StatsByClincalGrpDateDentist.jsp";
	}else if(function_id.equals("OH_OHRAUDIT_REPORTS")){
		url_name = "Rep_TreatmentAudit.jsp";
	}else if(function_id.equals("OH_OHREXTLB_REPORTS")){
		url_name = "Rep_OrdersSentToExternalPerfLoc.jsp";
	}
	url_name="../../eOH/jsp/"+url_name+"?"+params;

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_rep' id='f_query_rep' src=<%=url_name%>  frameborder=0 style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
</html>


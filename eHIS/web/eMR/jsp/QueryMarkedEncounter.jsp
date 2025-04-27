<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html> 
<head>
<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../js/MarkEncounter.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;
	String call_function = request.getParameter("function_id");	
/*
	String patientid = request.getParameter("patientId");
	String encounterid=request.getParameter("encounterId");
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");	
*/

%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/MedRecRequestCriteria.jsp?call_function=<%=call_function%>&function_id=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
<iframe scrolling="auto" name='resultframe' id='resultframe' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:55vh;width:100vw'></iframe>	
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:8vh;width:100vw'></iframe>				
<!--  <iframe scrolling="no" name='f_select' id='f_select' src='../../eMR/jsp/MedRecRequestButton.jsp'  noresize frameborder=0> -->


</html>     


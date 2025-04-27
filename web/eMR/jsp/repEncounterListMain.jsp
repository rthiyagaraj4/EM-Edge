<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<script src="../js/MRReports.js"></script>
<script src="../../eCommon/js/common.js"></script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>  
 <iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/repEncounterList.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>


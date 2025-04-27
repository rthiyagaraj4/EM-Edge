<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" session="false" %>
<% request.setCharacterEncoding("UTF-8");  %>
<script>
function reset()
{
	f_query_add_mod.document.Rep2AdmnStat.reset() ;
}

function run() 
{
	var fromdate = f_query_add_mod.document.Rep2AdmnStat.p_fr_date;
	var todate   = f_query_add_mod.document.Rep2AdmnStat.p_to_date ;   
	f_query_add_mod.document.Rep2AdmnStat.p_fr_date.value = fromdate.value ;
	f_query_add_mod.document.Rep2AdmnStat.p_to_date.value = todate.value ;
	if( f_query_add_mod.doDateCheck( f_query_add_mod.document.Rep2AdmnStat.p_fr_date,f_query_add_mod.document.Rep2AdmnStat.p_to_date, messageFrame )  )
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
    f_query_add_mod.document.forms[0].target="messageFrame";
    f_query_add_mod.document.Rep2AdmnStat.submit() ;
}

</script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eIP/jsp/Rep2AdmissionStats.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>


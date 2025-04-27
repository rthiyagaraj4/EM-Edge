<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

<script>
function reset() {
	f_query_add_mod.document.repNumberofOutpatient.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repNumberofOutpatient.p_year);		
	var names = new Array(getLabel("Common.year.label","Common"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		
		f_query_add_mod.document.repNumberofOutpatient.action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.repNumberofOutpatient.target="messageFrame";
		f_query_add_mod.document.repNumberofOutpatient.submit();
	}	
			
				  		
}

</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repNumberofOutpatientform.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>


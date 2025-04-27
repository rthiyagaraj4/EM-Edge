<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<script src='../../eCommon/js/common.js' language="JavaScript"></script>
<script>
function run()
{
	var fields = new Array(f_query_add_mod.document.Patlistgroupbyage.p_year_date);
	var reptype=f_query_add_mod.document.getElementById("p_report_type").value;
	if(reptype=="M")
	{		
		var names  = new Array ( getLabel('Common.month.label','Common'));
		f_query_add_mod.document.Patlistgroupbyage.p_report_id.value="MPPALGRA"
	}
	else
	{
		var names  = new Array ( getLabel('Common.year.label','Common'));
		f_query_add_mod.document.Patlistgroupbyage.p_report_id.value="MPPALGRA"
	}
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
        f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.Patlistgroupbyage.submit() ;
	}
}
function reset()
{
	//f_query_add_mod.document.Patlistgroupbyage.reset() ;
	f_query_add_mod.location.href="../../eMP/jsp/repPatlistgroupbyageform.jsp";
} 
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	String source = url + params ;
	 
%>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eMP/jsp/repPatlistgroupbyageform.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>



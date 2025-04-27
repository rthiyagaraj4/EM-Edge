<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function reset()
{
f_query_add_mod.document.location.reload();
}function run()
{
		if(f_query_add_mod.document.repIPCensusbyMorbidityForm)
		{
			//var fields = new Array(f_query_add_mod.document.forms[0].p_census_date);
			//if (f_query_add_mod.document.forms[0].p_census_date.value=='M')
			//var names = new Array (	escape("Month"))
			//else if (f_query_add_mod.document.forms[0].p_census_date.value=='Y')
			//var names = new Array (	escape("Year"))
		    //var names = new Array (escape("Census Month&Year"))
			var fields = new Array ( f_query_add_mod.document.forms[0].p_fm_Date);
			var reptype=f_query_add_mod.document.getElementById("p_type").value;
		if(reptype=="M")
		{		
			var names  = new Array ( getLabel("Common.month.label","Common")+' '+getLabel("Common.from.label","Common") );
			//f_query_add_mod.document.p_report_id.value="
		}
		else if (reptype=="Y")
		{
			var names  = new Array ( getLabel("Common.year.label","Common")+' '+getLabel("Common.from.label","Common") );
		}
		else
		{
			var names  = new Array ( getLabel("Common.DateFrom.label","Common"));
		}
            //if( f_query_add_mod.CheckString('Diagnosis Code', f_query_add_mod.document.forms[0].p_fm_diag_code,f_query_add_mod.document.forms[0].p_to_diag_code, messageFrame )  )	
			// if( f_query_add_mod.CheckString('Tab List', f_query_add_mod.document.forms[0].p_fm_tab_list,f_query_add_mod.document.forms[0].p_to_tab_list, messageFrame )  )	
			
			if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
				f_query_add_mod.document.forms[0].target="messageFrame";
		     f_query_add_mod.document.repIPCensusbyMorbidityForm.submit() ;
			}
		}
}
</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/repIPCensusbyMorbidityForm.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>


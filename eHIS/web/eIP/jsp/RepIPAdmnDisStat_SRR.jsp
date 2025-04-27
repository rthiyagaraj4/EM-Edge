<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");  %>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script>
function reset() {
	f_query_add_mod.document.RepIPAdmnDisStatform.reset() ;
}

function run() 
{
		var fromdate = f_query_add_mod.document.RepIPAdmnDisStatform.p_fr_date;
		var todate   = f_query_add_mod.document.RepIPAdmnDisStatform.p_to_date ;   

		var fields = new Array(f_query_add_mod.document.RepIPAdmnDisStatform.p_nationality,f_query_add_mod.document.RepIPAdmnDisStatform.p_fr_date, f_query_add_mod.document.RepIPAdmnDisStatform.p_to_date);
		var names = new Array (getLabel('Common.nationality.label','common'),getLabel('Common.periodfrom.label','common'),getLabel('Common.periodto.label','common'))

		f_query_add_mod.document.RepIPAdmnDisStatform.p_fr_date.value = fromdate.value ;
		f_query_add_mod.document.RepIPAdmnDisStatform.p_to_date.value = todate.value ;
		

		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{	
			if( isBefore(f_query_add_mod.document.RepIPAdmnDisStatform.p_fr_date.value,
				f_query_add_mod.document.RepIPAdmnDisStatform.p_to_date.value,"DMY",localeName ) == false )
			{
				//alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				//f_query_add_mod.document.RepIPAdmnDisStatform.p_to_date.select();
				var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error; 
				return;
			}
			f_query_add_mod.document.RepIPAdmnDisStatform.submit() ;
		}
}



</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/RepIPAdmnDisStatform_SRR.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	
<script src="../../eCommon/js/DateUtils.js"></script>

<script>
function reset()
{
	f_query_add_mod.document.RepIpReferral.reset() ;
}

function run() 
{
	var fromdate = f_query_add_mod.document.RepIpReferral.p_fm_admn_date;
	var todate   = f_query_add_mod.document.RepIpReferral.p_to_admn_date ;   
	f_query_add_mod.document.RepIpReferral.p_fm_admn_date.value = fromdate.value ;
	f_query_add_mod.document.RepIpReferral.p_to_admn_date.value = todate.value ;
	//if( f_query_add_mod.doDateCheck( f_query_add_mod.document.RepIpReferral.p_fm_admn_date,f_query_add_mod.document.RepIpReferral.p_to_admn_date, messageFrame )  )
	
	if( f_query_add_mod.doDateCheck('Referral Date', f_query_add_mod.document.RepIpReferral.p_fm_admn_date,f_query_add_mod.document.RepIpReferral.p_to_admn_date)  )
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
        f_query_add_mod.document.forms[0].target="messageFrame";
	    f_query_add_mod.document.RepIpReferral.submit() ;
	
}

function doDateCheck(str,from,to){
	    var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate!='' && todate!='')
		{
			var greg_fromDate = convertDate(fromdate,"DMY",localeName,"en");
			var greg_toDate = convertDate(todate,"DMY",localeName,"en");
			
			if(f_query_add_mod.isBefore(greg_fromDate,greg_toDate,"DMY","en"))
			{
				
				return true;
			}
			else 
			{
				var error=f_query_add_mod.getMessage("REMARKS_MUST_GR_EQUAL","common");
				error=error.replace("$",str);
				error=error.replace("#",str);
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
				return false;
			}
		}
		else
			return true;


}

</script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../jsp/Rep2IPReferral.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>


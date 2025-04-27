<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>		
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>
<script>
function reset() {
	
		 f_query_add_mod.document.getElementById('conv').style.display='none';
		 f_query_add_mod.document.getElementById('conl').style.display='none';
		 f_query_add_mod.document.repPregnancyStatistics.reset() ;		
}

function run() 
{
	var fields = new Array(f_query_add_mod.document.repPregnancyStatistics.p_regis_time_fm,                         f_query_add_mod.document.repPregnancyStatistics.p_regis_time_to,f_query_add_mod.document.repPregnancyStatistics.p_report_id);

    var names = new Array(getLabel('Common.RegistrationDate.label','Common')+" "+getLabel('Common.from.label','Common'), getLabel('Common.RegistrationDate.label','Common')+" "+getLabel('Common.to.label','Common'), getLabel('Common.reportname.label','Common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame)){
			if(doDateChkWithLabel(f_query_add_mod.document.repPregnancyStatistics.p_regis_time_fm, f_query_add_mod.document.repPregnancyStatistics.p_regis_time_to, messageFrame,'DMY',getLabel('Common.RegistrationDate.label','Common')))				
				f_query_add_mod.document.forms[0].submit();
			}	
}
function doDateChkWithLabel(from,to,messageFrame,format,stringLabel) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}
	 if(!f_query_add_mod.isBefore(from,to,format,f_query_add_mod.document.forms[0].p_language_id.value)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;		
		error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +stringLabel);
		error=error.replace("#",stringLabel);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}
</script>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eMP/jsp/repPregnancyStatistics_form.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

</html>


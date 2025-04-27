<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script src='../js/Rep2MasterList.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</script>
<script>



function run()
{
	var fields = new Array( f_query_add_mod.document.Rep2DeathStatistics.p_fm_date,
						f_query_add_mod.document.Rep2DeathStatistics.p_to_date );

	var names = new Array(getLabel("eIP.DeceasedDateFrom.label","IP"), getLabel("eIP.DeceasedDateTo.label","IP"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		// IN018783 Tuesday, February 02, 2010
	if(doDateCheck123(f_query_add_mod.document.Rep2DeathStatistics.p_fm_date,
	    f_query_add_mod.document.Rep2DeathStatistics.p_to_date, messageFrame )  )
	{
		if(f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"),   f_query_add_mod.document.Rep2DeathStatistics.p_fm_code,
		f_query_add_mod.document.Rep2DeathStatistics.p_to_code, messageFrame )  )
		{
		f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		f_query_add_mod.document.forms[0].target="messageFrame"
		f_query_add_mod.document.Rep2DeathStatistics.submit() ;
		}
	}
 }
}
</script>
<%

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/Rep2DeathStatistics.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:20vh;width:100vw'></iframe>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


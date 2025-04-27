<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*" %>
<html>
<head>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script  language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function reset()
	{
		if(parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates)
		{
			parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates.reset() ;
		}
	}
	function run()
	{
		if(parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates)
		{ 
			if(parent.frames[2].frames[1].CheckString( getLabel("Common.PatientSeriesGroup.label","Common"),parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates.p_series_from, parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates.p_series_to, messageFrame )) 	
			{
				if(parent.frames[2].frames[1].CheckString( getLabel("Common.category.label","Common"),parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates.p_from_catcode, parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates.p_to_catcode, messageFrame)) 	
				{
					parent.frames[2].frames[1].document.repDRExcludedPossibleDuplicates.submit();
				}
			}
		}
	}
	</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' scrolling='no' noresize src=<%= source %> style='height:8vh;width:100vw' frameborder="0"></iframe>
	<iframe name='query_criteria' id='query_criteria'  scrolling='no' noresize src='../../eDR/jsp/ExcludedPossibleReportForm.jsp' style='height:83vh;width:100vw' frameborder="0"></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' style='height:9vh;width:100vw' frameborder="0"></iframe>
</html>


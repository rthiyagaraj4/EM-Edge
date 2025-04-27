<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
	<head>
	<title><fmt:message key="eDR.ReportPossibleDuplicates.label" bundle="${dr_labels}"/></title>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function reset()
		{
			if(parent.frames[2].frames[1].document.repDRPossibleDuplicates)
			{
				parent.frames[2].frames[1].document.repDRPossibleDuplicates.reset();
			}
		}
		function run()
		{

			if(parent.frames[2].frames[1].document.repDRPossibleDuplicates)
			{ 
				if(parent.frames[2].frames[1].CheckString( getLabel("Common.PatientSeriesGroup.label","Common"), parent.frames[2].frames[1].document.repDRPossibleDuplicates.p_series_from, parent.frames[2].frames[1].document.repDRPossibleDuplicates.p_series_to, messageFrame))
				{
					parent.frames[2].frames[1].document.repDRPossibleDuplicates.submit();
				}
			}
		}
		function modal_run()
		{
		//	alert('run');
			//alert(frames[1].document.getElementById("").name);
			if(frames[1].document.repDRPossibleDuplicates)
			{ 
				frames[1].document.repDRPossibleDuplicates.submit() ;
			}
		}
	</script>
<html>
<%
	
	request.setCharacterEncoding("UTF-8");
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;

	String modal	= request.getParameter("modal");

	if(modal != null && modal.equals("Y"))
	{
		%>
		<script>
			//alert('coming from modal window');
		</script>

		<iframe name='commontoolbarFrame' id='commontoolbarFrame'  scrolling='no' noresize src=<%= source %> style='height:3vh;width:100vw' frameborder="0"></iframe>
		<iframe name='query_criteria' id='query_criteria'  scrolling='no' noresize src='../../eDR/jsp/PossibleDuplicatesReportForm.jsp?modal=<%=modal%>' style='height:80vh;width:100vw' frameborder="0"></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' style='height:9vh;width:100vw' frameborder="0"></iframe>
		<%
	}
	else if(modal == null)
	{
		%>
	 
			<iframe name='commontoolbarFrame' id='commontoolbarFrame'  scrolling='no' noresize src=<%= source %> style='height:8vh;width:100vw' frameborder="0"></iframe>
			<iframe name='query_criteria' id='query_criteria'  scrolling='no' noresize src='../../eDR/jsp/PossibleDuplicatesReportForm.jsp' style='height:85vh;width:100vw' frameborder="0"></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='auto' style='height:7vh;width:100vw' frameborder="0"></iframe>
		<%
	}
	%>
</html>


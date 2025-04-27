<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
20/03/2019	  IN069952		Prakash C 		20/03/2019		Ramesh G			Chart View search is blank
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String function_from = request.getParameter("function_from") == null ? "" :  request.getParameter("function_from");checkstyle
	String chart_id = request.getParameter("Chart_Id") == null ? "" :  request.getParameter("Chart_Id");
	String dateDefault = request.getParameter("p_start_date_time") == null ? "" :  request.getParameter("p_start_date_time");
	if(!dateDefault.equals(""))
	{	
		StringTokenizer dateToken = null;
		StringTokenizer secondsToken = null;

		dateToken = new StringTokenizer(dateDefault," ");
		String actualDate = dateToken.nextToken();
		String tempDate = dateToken.nextToken();
		secondsToken = new StringTokenizer(tempDate,":");
		String dateHrMin = actualDate + " " +secondsToken.nextToken() + ":" + secondsToken.nextToken();

		dateDefault = dateHrMin;
	}


	String encounter_id = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
	if(encounter_id.equals("")) encounter_id = "0";
	/*String fac_id = (String) session.getAttribute("facility_id");
	String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
	String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String qs = request.getQueryString(); commented for checkstyle */
	String title = "";
	title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels") ;
	
%>
<script>		
		function removeObjectsFromSession(){
			//alert('removeObjectsFromSession....');
				//parent.ChartRecordingIntermediateFrame.location.href="../../eCA/jsp/ChartRecordingRemoveObjects.jsp?"+"<%=request.getQueryString()%>";
		}
</script>
<head>
<title>
<%=title%>
</title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
		<frameset rows='9%,*%,4%' id ='chartRecordingFrameSet' frameborder=1 onUnload='removeObjectsFromSession()' >
			<frame name="ChartRecordingCriteriaFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ViewChartRecordingCriteria.jsp?<%=request.getQueryString()%>&Chart_Id=<%=chart_id%>"></frame>									
								
			<frameset rows='73%,27%' id ='chartRecordingFrameSetInner'  frameborder=0 ><!-- IN069952 added id to avoid script error-->
				<frame name="ChartRecordingGraphFrame" frameborder="0" scrolling="auto"  src="../../eCommon/html/blank.html"></frame>
				<frame name="ChartRecordingListFrame" frameborder="0" scrolling="auto"  src="../../eCommon/html/blank.html"></frame>
			</frameset>		
					
			<frame name="ChartRecordingColorFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ViewChartColorToolBar.jsp" ></frame>		
			
		</frameset>

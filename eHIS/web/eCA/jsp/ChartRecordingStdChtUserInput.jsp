<!DOCTYPE html>




<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ComparisionView.label" bundle="${ca_labels}"/></title>
		<%
			String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
			String patientID	= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String encounterId	 = "";
			if(flowsheetGraph.equals("Y"))
				encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			else
				encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");

			eCA.ChartRecordingAddGroupBean chartingBean = null; //(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

			if(flowsheetGraph.equals("Y"))
			{
				chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patientID+encounterId,"eCA.ChartRecordingAddGroupBean",session);
			}
			else
			{
				chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patientID+encounterId,"eCA.ChartRecordingAddGroupBean",session);
			}


			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			//String locale = (String) p.getProperty("LOCALE");			
			
			String facility_id		= request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
			String chartID			= request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
			String Sex				= request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
			String code				= request.getParameter("code") == null ? "" : request.getParameter("code");
			String allDatesForGraph = request.getParameter("allDatesForGraph") == null ?"" : request.getParameter("allDatesForGraph");
			String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
		
			ArrayList list = new ArrayList();
			HashMap map = new HashMap();
			
			String keyForMap = "";
			String valueFromMap = "";
			String discrMsrDesc = "";
			StringTokenizer strToken = null;
			String sel = "";
			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='stdChartUserInputForm' id='stdChartUserInputForm'>
			<table class='grid' width='100%'>
		
				<tr>
					<td class='CACHARTFOURTHLEVELCOLOR' align='left'><fmt:message key="eCA.ComparisionView.label" bundle="${ca_labels}"/>
					</td>
				</tr>
				<tr>
					<td class='gridData' align='center' >X <fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/> : 
					<select name='xaxisValue' id='xaxisValue' onChange="loadYaxisValue(this)">
						<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
			try
			{
				list = chartingBean.retrieveRecords();
				map = chartingBean.getHashValues();
				
				for(int i=0;i<list.size();i++)
				{
					keyForMap = (String) list.get(i);
					valueFromMap = (String) map.get(keyForMap);
					strToken = new StringTokenizer(valueFromMap,"~");
					discrMsrDesc = strToken.nextToken();
					
					if(keyForMap.equals(code))
						sel = "selected";
					else
						sel = "";

					out.println("<option value='"+keyForMap+"' "+sel+">"+discrMsrDesc+"</option>");
				}	
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
		%>
				</select>
				</td>
			</tr>
			<tr>
				<td class='gridData' align='center' >Y <fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/> : 
				<select name='yaxisValue' id='yaxisValue'>
					<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>												
		<%
			try
			{
				list = chartingBean.retrieveRecords();
				map = chartingBean.getHashValues();
				
				for(int i=0;i<list.size();i++)
				{
					keyForMap = (String) list.get(i);
					valueFromMap = (String) map.get(keyForMap);
					strToken = new StringTokenizer(valueFromMap,"~");
					discrMsrDesc = strToken.nextToken();

					if(!keyForMap.equals(code))
						out.println("<option value='"+keyForMap+"'>"+discrMsrDesc+"</option>");
				}	
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
		%>			
				</select>
				</td>
			</tr>
			<tr>
					<td class='CAGROUPHEADING' align='left'>
						<input type='button' name='graph' id='graph' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>' onclick ='loadStdGraph()'>
					</td>
			</tr>
			</table>
			
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patientID%>'>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
			<input type='hidden' name='encounterId' id='encounterId' value='<%=encounterId%>'>
			<input type='hidden' name='chart_id' id='chart_id' value='<%=chartID%>'>
			<input type='hidden' name='Sex' id='Sex' value='<%=Sex%>'>
			<input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value='<%=allDatesForGraph%>'>
			<input type='hidden' name='splChartType' id='splChartType' value='<%=splChartType%>'>
		</form>
		<%
		if(splChartType.equals("GR"))
		{
	%>
			<div id="GrowthChart" 
				  style="position:absolute;
						 width:200px;
						 height:20px;
						 top:245px;
						 left:0px;
						 background-image:url('../../eCommon/images/Sliding-active.jpg');
						 background-repeat: repeat-x;
						 text-align:center;
						 font-weight:BOLD;
						 color:#FFFFFF;"
				 onclick="showGrowthChart(this)">
				<fmt:message key="eCA.GrowthChart.label" bundle="${ca_labels}"/>				 
			  </div>
	<%
		}
	%>
	</body>
	
</html>


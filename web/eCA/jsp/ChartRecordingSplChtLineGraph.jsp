<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
10/10/2014		IN048766		Ramesh			Fix for WebLogic Linux environments
04/02/2016		IN058139		Ramesh G		INT-CRF-BRU-CIS-005
17/02/2016		IN059226		Raja S			CRF-CA-INT-CRF-BRU-CIS-005-US002/01 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	
	eCA.ChartRecordingAddGroupBean chartingBean = null;

	//(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	if(flowsheetGraph.equals("Y"))
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}
	else
	{
		chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean"+patient_id+encounter_id,"eCA.ChartRecordingAddGroupBean",session);
	}




	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>

<%@page import="java.io.*,java.net.*,java.awt.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,eCA.ChartComponentFormulaBean,java.text.SimpleDateFormat,org.jfree.data.category.DefaultCategoryDataset.*,org.jfree.chart.axis.*,org.jfree.chart.block.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.title.LegendTitle"%>

<html>
	<head>
		<title><fmt:message key="eCA.SpecialGraph.label" bundle="${ca_labels}"/></title>
		<%

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	org.jfree.data.category.DefaultCategoryDataset defaultcategorydataset = new org.jfree.data.category.DefaultCategoryDataset();

	String group = request.getParameter("group") == null ? "0" : request.getParameter("group");
	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");

	int chartWidth = 800;
	int chartHeight = 400;

	if(noOfGroups.equals("1"))
	{
		chartWidth = 975;
		chartHeight = 650;
	}
	else if(noOfGroups.equals("2"))
	{
		chartWidth = 800;
		chartHeight = 330;
	}
	else if(noOfGroups.equals("3"))
	{
		chartWidth = 785;
		chartHeight = 250;
	}
	else if(noOfGroups.equals("4"))
	{
		chartWidth = 785;
		chartHeight = 225;
	}

	String keyForMap = "Group "+group;
	String setForMap = "SetGroup "+group; //IN058139
	String dateForgraph = "";
	String seriesForGraph = "";
	String ValueForgraph = "";
	String datetime		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
	String Values		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Values.label","common_labels");

	ArrayList groupList = new ArrayList();
	ArrayList groupSet = new ArrayList();//IN058139
	StringTokenizer strTok = null;
	int sizeOfList = 0;
	String minValue = ""; //IN058139
	String maxValue = "";//IN058139

	try
	{
		groupList = (ArrayList) chartingBean.returnLists(keyForMap);
		//IN058139 Start.
		groupSet = (ArrayList)chartingBean.returnLists(setForMap);		
		//IN059226 Start.
		String retVal = chartingBean.getMinandMaxValues(groupSet);
		String[]retArr = retVal.split("\\|");
		minValue = retArr[0].trim();
		maxValue = retArr[1].trim();
		//IN059226 End.
		//IN058139 End.
		sizeOfList = groupList.size();

		for(int i=0; i< sizeOfList; i++)
		{
			strTok = new StringTokenizer((String) groupList.get(i),"`");
			while(strTok.hasMoreTokens())
			{
				dateForgraph = strTok.nextToken();
				ValueForgraph = strTok.nextToken();
				seriesForGraph = strTok.nextToken();
				seriesForGraph = java.net.URLDecoder.decode(seriesForGraph);
				defaultcategorydataset.addValue(Double.parseDouble(ValueForgraph),seriesForGraph,dateForgraph);
			}
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}

	JFreeChart jfreechart = ChartFactory.createLineChart(keyForMap, datetime, Values, defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
	CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
	NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
	//IN058139 Start.
	if(!"".equals(minValue)&&!"".equals(maxValue))
		numberaxis.setRange(Integer.parseInt(minValue), Integer.parseInt(maxValue));
	//IN058139 End.
	numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    org.jfree.chart.renderer.category.LineAndShapeRenderer lineandshaperenderer = (org.jfree.chart.renderer.category.LineAndShapeRenderer)categoryplot.getRenderer();

	lineandshaperenderer.setShapesVisible(true);
	lineandshaperenderer.setLinesVisible(true);
	lineandshaperenderer.setDrawOutlines(true);
	lineandshaperenderer.setUseFillPaint(true);
	lineandshaperenderer.setFillPaint(Color.white);
	
	org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
	org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFLiCH");
	

	String graphURL = "";
	String filename = "";
	boolean create = false;

	try
	{
		filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,chartHeight,info,null);
		//IN048766 - start
		//java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);
		java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);
		//IN048766 - end
		if(file.exists())
		{
			out.println("<script>alert('file already exists');</script>");
		}
		else
			create = file.createNewFile();
		if(create)
		{
			org.jfree.chart.ChartUtilities.saveChartAsPNG(file,jfreechart,chartWidth,chartHeight,info);
		}
		org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
		graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
	}
	catch(Exception ee)
	{
		//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
%>

<body onKeyDown="lockKey()">
	<form name='SplChartForm' id='SplChartForm'>
		<table>				
			<tr>
				<td>						
					<center><img  src="<%=graphURL%>" border=0 usemap="#<%=filename%>"/></center>
				</td>
			</tr>				
		</table>
		<input type='hidden' name='filename' id='filename' value='<%=filename%>'>
		<input type='hidden' name='noOfGroups' id='noOfGroups' value='<%=noOfGroups%>'>
	</form>
</body>
<script>
	if(parent.parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.forms[0] != null)
		parent.parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.forms[0].graph.disabled = false;
</script>
</html>


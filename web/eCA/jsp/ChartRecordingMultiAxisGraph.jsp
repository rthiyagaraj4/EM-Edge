<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005
17/02/2016	IN059226		Raja S											CRF-CA-INT-CRF-BRU-CIS-005-US002/01
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.ChartRecordingAddGroupBean chartingBean = null; //(eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

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

<%@page import="java.io.*,java.awt.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.category.LineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,eCA.ChartComponentFormulaBean,java.text.SimpleDateFormat,org.jfree.data.category.DefaultCategoryDataset.*,org.jfree.chart.axis.*,org.jfree.chart.block.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.title.LegendTitle,org.jfree.data.time.Minute,org.jfree.data.time.RegularTimePeriod,org.jfree.data.time.TimeSeries,org.jfree.data.time.TimeSeriesCollection"%>

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
	String group = request.getParameter("group") == null ? "0" : request.getParameter("group");
	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");
	String minValue = "";//IN058139
	String maxValue = "";//IN058139
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

	
	StandardCategoryToolTipGenerator tootltipGenerator = new StandardCategoryToolTipGenerator();

	String keyForMap = "Group "+group;
	String dateForgraph = "";
	String ValueForgraph = "";
	String datetime		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");

	ArrayList groupList = new ArrayList();
	ArrayList tempArrayList = new ArrayList();

	int sizeOfList = 0;
	int tempInt = 0;

	String datesForGrf = "";
	String valuesForGrf = "";
	String allDetailsForGraphs = "";
	String discrMsrDesc = "";
	String datesAndValues = "";
	String legendString = "";
	//String discrUOM = "";
	String tdDatesAndValues = "";
	String graphURL = "";
	String filename = "";
	String discrMsrID = ""; //IN058139
	StringTokenizer strTok = null;
	StringTokenizer detailsForGrf = null;
	StringTokenizer strTokenDatesAndValues = null;
	StringTokenizer strTkTdDatesAndValues = null;

	boolean create = false;

	try
	{
		groupList = (ArrayList) chartingBean.returnLists(keyForMap);
		sizeOfList = groupList.size();
		CategoryAxis xAxis = new CategoryAxis(datetime);
		CategoryPlot plot = new CategoryPlot();
		plot.setOrientation(PlotOrientation.VERTICAL);
		plot.setDomainAxis(xAxis);

		for(int i=0; i< sizeOfList; i++)
		{
			strTok = new StringTokenizer((String) groupList.get(i),"~");
			discrMsrDesc = strTok.nextToken();
			datesAndValues = strTok.nextToken();
			legendString = strTok.nextToken();
			legendString = java.net.URLDecoder.decode(legendString);
			discrMsrID		=	 strTok.nextToken(); //IN058139
			strTokenDatesAndValues = new StringTokenizer(datesAndValues,">");

			while(strTokenDatesAndValues.hasMoreTokens())
			{
				tdDatesAndValues = strTokenDatesAndValues.nextToken();
				strTkTdDatesAndValues = new StringTokenizer(tdDatesAndValues,"^%");
				while(strTkTdDatesAndValues.hasMoreTokens())
				{
					if(tempInt % 2 == 0)
					{
						dateForgraph = strTkTdDatesAndValues.nextToken();
					}
					else
					{
						ValueForgraph = strTkTdDatesAndValues.nextToken();
						if(!ValueForgraph.equals(" "))
						{
							tempArrayList.add(dateForgraph+"`"+ValueForgraph);
						}
					}
					tempInt++;
				}
			}
			org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
			for(int j=0;j<tempArrayList.size();j++)
			{
				allDetailsForGraphs = (String) tempArrayList.get(j);
				detailsForGrf = new StringTokenizer(allDetailsForGraphs,"`");
				datesForGrf = (String) detailsForGrf.nextToken();
				valuesForGrf = (String) detailsForGrf.nextToken();

				dataset.addValue(Double.parseDouble(valuesForGrf),legendString,datesForGrf);

			}
			tempArrayList.clear();
			//IN058139 Start.			
			//IN059226 Starts			
			String retVal = chartingBean.getMinMaxValues(discrMsrID);
			String[]retArr = retVal.split("\\|");
			minValue = retArr[0].trim();
			maxValue = retArr[1].trim();
			//IN059226 Ends
			//IN058139 End.
				org.jfree.chart.axis.NumberAxis yAxis = new org.jfree.chart.axis.NumberAxis(legendString);
				//IN058139 Start.
				if(!"".equals(minValue)&&!"".equals(maxValue))
					yAxis.setRange(Integer.parseInt(minValue), Integer.parseInt(maxValue));
				//IN058139 End.
				plot.setRangeAxis(i, yAxis);
				plot.setRangeAxisLocation(i, org.jfree.chart.axis.AxisLocation.BOTTOM_OR_LEFT);

				plot.setDataset(i, dataset);
				plot.mapDatasetToRangeAxis(i, i);

				org.jfree.chart.renderer.category.LineAndShapeRenderer lineandshaperenderer = new org.jfree.chart.renderer.category.LineAndShapeRenderer();
				lineandshaperenderer.setShapesVisible(true);
				lineandshaperenderer.setLinesVisible(true);
				lineandshaperenderer.setDrawOutlines(true);
				lineandshaperenderer.setUseFillPaint(true);
				lineandshaperenderer.setFillPaint(Color.white);
				lineandshaperenderer.setToolTipGenerator(tootltipGenerator); 
				plot.setRenderer(i, lineandshaperenderer);
	
				yAxis.setLabelPaint(plot.getRenderer(i).getSeriesPaint(i));
				yAxis.setTickLabelPaint(plot.getRenderer(i).getSeriesPaint(i));
				plot.getRenderer(i).setSeriesPaint(0, plot.getRenderer(i).getSeriesPaint(i));
			
		}
		
		org.jfree.chart.JFreeChart chart = new org.jfree.chart.JFreeChart(keyForMap, plot);

		org.jfree.chart.ChartPanel chartpanel = new org.jfree.chart.ChartPanel(chart,false,false,false,true,true);
		chartpanel.setPreferredSize(new Dimension(360, 1500));
		chartpanel.setDisplayToolTips(true);
		

		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFMulCH");

		try
		{
			filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,chartWidth,chartHeight,info,null);
			java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);
			if(file.exists())
			{
				out.println("<script>alert('file already exists');</script>");
			}
			else
				create = file.createNewFile();
			if(create)
			{
				org.jfree.chart.ChartUtilities.saveChartAsPNG(file,chart,chartWidth,chartHeight,info);
			}
			org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
			graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
		}	
		catch(Exception ee)
		{
			
			ee.printStackTrace();
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	
%>

<body onKeyDown="lockKey()">
	<form name='MultiAxisForm' id='MultiAxisForm'>
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
	//alert(parent.parent.viewsFrame.splChtStandardViewFrame.groupNamesAndDetailsFrame.document.forms[0].name);
	//alert(parent.parent.frames[0].name);
</script>
</html>


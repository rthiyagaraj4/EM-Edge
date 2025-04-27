<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
24/07/2020  	IN073071	sivabagyam M 	24/07/2020		Ramesh G		CA-COMMON-VIEW GRAPH																		
--------------------------------------------------------------------------------------------------------------------------------
*/
-->
<%@page import="java.sql.*, java.util.*, webbeans.eCommon.*, java.io.*,java.awt.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,org.jfree.chart.title.LegendTitle" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eCA.ComparisionGraph.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script> 
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String sentFrom = request.getParameter("sentFrom") == null ? "" : request.getParameter("sentFrom");

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	org.jfree.data.xy.XYSeriesCollection xyseriescollection = new org.jfree.data.xy.XYSeriesCollection();
	org.jfree.chart.labels.StandardXYToolTipGenerator standardxytooltipgenerator = new org.jfree.chart.labels.StandardXYToolTipGenerator();
	org.jfree.chart.renderer.xy.XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);

	org.jfree.data.xy.XYSeries xyseriesPatRecDtl = new org.jfree.data.xy.XYSeries("", false, true);

	String graphDesc = "";
	String xAxisElementType = request.getParameter("xAxisElementType") == null ? "" : request.getParameter("xAxisElementType");
	String yAxisElementType = request.getParameter("yAxisElementType") == null ? "" : request.getParameter("yAxisElementType");
	String patientID = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String chartID = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
	String allDatesForGraph = request.getParameter("allDatesForGraph") == null ?"" : request.getParameter("allDatesForGraph");
	StringTokenizer strTokDates = new StringTokenizer(allDatesForGraph,"$$");
	String allDatesForGrf = "";
		
	String legendYAxis	= "";
	String legendXAxis	= "";
	String XAxisUOM		= "";
	String YAxisUOM		= "";
	String XAxisResult	= "";
	String YAxisResult	= "";
	String XAxisdesc	= "";
	String YAxisdesc	= "";
	String sql			= "";
	//ArrayList list		= new ArrayList();

	if(sentFrom.equals("userInput"))
	{
		xAxisElementType = request.getParameter("xAxisVal") == null ? "" : request.getParameter("xAxisVal");
		yAxisElementType = request.getParameter("yAxisVal") == null ? "" : request.getParameter("yAxisVal");
	}

	int count = 0;
	int chartWidth = 10;

	sql = "select a.DISCR_MSR_RESULT_NUM_UOM, a.DISCR_MSR_RESULT_NUM, AM_GET_DESC.AM_DISCR_MSR(b.DISCR_MSR_ID,?,'2') short_desc from ca_encntr_discr_msr a, CA_CHART_SECTION_COMP b,  AM_DISCR_MSR I where a.CHART_ID = ? and a.patient_id = ? and a.TEST_OBSERV_DT_TM = to_date(?,'DD/MM/YYYY HH24:MI') and nvl(ERROR_YN,'N') != 'Y' and b.CHART_ID  =a.CHART_ID   and b.PANEL_ID  =a.DISCR_MSR_PANEL_OR_FORM_ID and b.DISCR_MSR_ID=a.DISCR_MSR_ID  AND I.DISCR_MSR_ID=a.DISCR_MSR_ID and b.DISCR_MSR_ID = ? order by B.PANEL_DISP_ORDER_SEQ,B.DISCR_DISP_ORDER_SEQ";

	Connection con = null;
	PreparedStatement psForXAxisPatDtl = null;
	PreparedStatement psForYAxisPatDtl = null;
	ResultSet resForXAxisPatDtl = null;
	ResultSet resForYAxisPatDtl = null;

	try
	{
		con = ConnectionManager.getConnection(request);
		psForXAxisPatDtl = con.prepareStatement(sql.toString());
		psForYAxisPatDtl = con.prepareStatement(sql.toString());

		while(strTokDates.hasMoreTokens())
		{
			allDatesForGrf = (String) strTokDates.nextToken();
			allDatesForGrf = com.ehis.util.DateUtils.convertDate(allDatesForGrf,"DMYHM", locale,"en");

			psForXAxisPatDtl.setString(1,locale);
			psForXAxisPatDtl.setString(2,chartID);
			psForXAxisPatDtl.setString(3,patientID);
			psForXAxisPatDtl.setString(4,allDatesForGrf);
			psForXAxisPatDtl.setString(5,xAxisElementType);
			resForXAxisPatDtl = psForXAxisPatDtl.executeQuery();

			psForYAxisPatDtl.setString(1,locale);
			psForYAxisPatDtl.setString(2,chartID);
			psForYAxisPatDtl.setString(3,patientID);
			psForYAxisPatDtl.setString(4,allDatesForGrf);
			psForYAxisPatDtl.setString(5,yAxisElementType);
			resForYAxisPatDtl = psForYAxisPatDtl.executeQuery();

			if(resForXAxisPatDtl.next() && resForYAxisPatDtl.next())
			{

				XAxisUOM = resForXAxisPatDtl.getString(1) == null ? "" : resForXAxisPatDtl.getString(1);
				XAxisResult = resForXAxisPatDtl.getString(2) == null ? "" : resForXAxisPatDtl.getString(2);
				XAxisdesc = resForXAxisPatDtl.getString(3) == null ? "" : resForXAxisPatDtl.getString(3);

				YAxisUOM = resForYAxisPatDtl.getString(1) == null ? "" : resForYAxisPatDtl.getString(1);
				YAxisResult = resForYAxisPatDtl.getString(2) == null? "" : resForYAxisPatDtl.getString(2);
				YAxisdesc = resForYAxisPatDtl.getString(3) == null ? "" : resForYAxisPatDtl.getString(3);
				
				if(!XAxisResult.equals("") && !YAxisResult.equals(""))
				{
					xyseriesPatRecDtl.setKey("("+XAxisdesc+","+YAxisdesc+")");
					//xyseriesPatRecDtl.fireSeriesChanged();
					xyseriesPatRecDtl.add(Double.parseDouble(XAxisResult),Double.parseDouble(YAxisResult));
					count++;
				}
				graphDesc = XAxisdesc+"  (Vs)  "+YAxisdesc;

				if(!XAxisUOM.equals(""))
					legendXAxis = XAxisdesc+" (" + XAxisUOM + ")";
				else
					legendXAxis = XAxisdesc;
				if(!YAxisUOM.equals(""))
					legendYAxis = YAxisdesc+" (" + YAxisUOM + ")";
				else
					legendYAxis = YAxisdesc;
			}
			if(resForXAxisPatDtl != null) resForXAxisPatDtl.close();
			if(resForYAxisPatDtl != null) resForYAxisPatDtl.close();
		}
	

		xyseriescollection.addSeries(xyseriesPatRecDtl);
			
		xyseriescollection.setAutoWidth(true);
				
		if(count != 0)
		{
			chartWidth = 800;
		}
		else
		{
			out.println("<script>alert(getMessage('NO_DATA_AVAILABLE','CA'));</script>");
			out.println("<script>parent.parent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;</script>");
			out.println("<script>document.location.href='../../eCommon/html/blank.html';</script>");
		}

		
		if(psForXAxisPatDtl != null) psForXAxisPatDtl.close();
		if(psForYAxisPatDtl != null) psForYAxisPatDtl.close();
	
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

	org.jfree.chart.JFreeChart jfreechart = org.jfree.chart.ChartFactory.createXYLineChart(graphDesc, legendXAxis, legendYAxis, xyseriescollection, org.jfree.chart.plot.PlotOrientation.VERTICAL, false,true,false);

	org.jfree.chart.plot.XYPlot xyplot = jfreechart.getXYPlot();
	xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();	
	xylineandshaperenderer.setToolTipGenerator(standardxytooltipgenerator);
	org.jfree.chart.ChartPanel chartpanel = new org.jfree.chart.ChartPanel(jfreechart,false,false,false,true,true);
    chartpanel.setPreferredSize(new Dimension(360, 1500));
    chartpanel.setDisplayToolTips(true);
    chartpanel.setDomainZoomable(true);
	
	xylineandshaperenderer.setSeriesShapesVisible(0,true);
	
	org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
	org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFStdCH");
	
	String graphURL = "";
	String filename = "";
	boolean create = false;

	try
	{
		filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,650,info,null);
		org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
		graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
	}
	catch(Exception ee)
	{
		//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181		
	}	
%>
	<body onUnload='callOnExit()' onKeyDown="lockKey()">
		<form name='ComparisionForm' id='ComparisionForm'>
			<table>				
				<tr>
					<td>						
						<center><img  src="<%=graphURL%>" border=0 usemap="#<%=filename%>"/></center>
					</td>
				</tr>				
			</table>
<%
		//java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);//IN073071

		java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);//IN073071

		if(file.exists())
		{
			out.println("<script>alert('file already exists');</script>");
		}
		else
			create = file.createNewFile();
		if(create)
		{
			org.jfree.chart.ChartUtilities.saveChartAsPNG(file,jfreechart,chartWidth,600,info);
		}
%>
			<input type='hidden' name='filename' id='filename' value='<%=filename%>'>
		</form>
	</body>
	<script>
		//parent.parent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;
		parent.viewsFrame.stdChtCustomViewFrame.document.forms[0].graph.disabled = false;
	</script>
</html>


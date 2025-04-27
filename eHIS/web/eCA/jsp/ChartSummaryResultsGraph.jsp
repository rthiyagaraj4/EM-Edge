<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005
29/01/2019	IN069608	Ramesh G	29/01/2019		Ramesh G		ML-BRU-SCF-1915
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,eCA.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
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
	Properties p			= (Properties)session.getValue("jdbc");
	String locale			= (String) p.getProperty("LOCALE");
	
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String event_code = request.getParameter("event_code") == null ? "" : request.getParameter("event_code");
	String event_group = request.getParameter("event_group") == null ? "" : request.getParameter("event_group");
	String histRecType = request.getParameter("histRecType") == null ? "" : request.getParameter("histRecType");
	//IN065341 starts
	String RepDb = request.getParameter("RepDb") == null ? "" : request.getParameter("RepDb");
	String clob_data = request.getParameter("clob_data") == null ? "" : request.getParameter("clob_data");
	//IN065341 ends
	//IN058139 Start.
	ChartSummaryResultsBean bean = (ChartSummaryResultsBean)getObjectFromBean("chartSummaryResults","eCA.ChartSummaryResultsBean",session);
	bean.getMaxAndMinValues(event_code); 
	String minValue = bean.getMinValue(); 
	String maxValue = bean.getMaxValue(); 
	//IN058139 End.
	org.jfree.data.category.DefaultCategoryDataset defaultcategorydataset = new org.jfree.data.category.DefaultCategoryDataset();

	int chartWidth = 700;
	int chartHeight = 400;

	String keyForMap = "Group";
	String dateForgraph = "";
	String seriesForGraph = "";
	String ValueForgraph = "";
	String datetime		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
	String Values		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Values.label","common_labels");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sql = new StringBuffer();
	int indVal = 1;

	try
	{
		con = ConnectionManager.getConnection(request);
	//IN065341 starts	
		//sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc from CR_ENCOUNTER_DETAIL a, CR_CLN_EVT_MST_LANG_VW b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");
		//sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc from CR_ENCOUNTER_DETAIL##REPDB## a, CR_CLN_EVT_MST_LANG_VW##REPDB## b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");//commented for IN069608
		sql.append("select a.RESULT_NUM, to_char(a.EVENT_DATE,'dd/mm/yyyy hh24:mi') EVENT_DATE, b.short_desc event_desc,a.event_date event_dt from CR_ENCOUNTER_DETAIL##REPDB## a, CR_CLN_EVT_MST_LANG_VW##REPDB## b where b.LANGUAGE_ID = ? and b.HIST_REC_TYPE = a.HIST_REC_TYPE and b.EVENT_CODE = a.EVENT_CODE and a.HIST_REC_TYPE = ? ");//Modified for IN069608
	//IN065341 ends	
		if(!event_group.equals(""))
			sql.append("and a.EVENT_GROUP = ? ");
	//IN065341 starts	
		//sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id = ? ) where RANK_NO < 3 ) order by EVENT_DATE ");
		//sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id = ? ) where RANK_NO < 3 ) order by EVENT_DATE ");//commented for IN069608
		sql.append("and a.EVENT_CODE = ? and a.PATIENT_ID = ? and nvl(a.STATUS,'`') not in('S','E') and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER##REPDB## where patient_id = ? ) where RANK_NO < 3 ) order by event_dt ");//Modified for IN069608
		String result = sql.toString();
		result=result.replaceAll("##CLOB##",clob_data);
		result=result.replaceAll("##REPDB##",RepDb);
		pstmt = con.prepareStatement(result);
		//pstmt = con.prepareStatement(sql.toString());
	//IN065341 ends	
		pstmt.setString(indVal++,locale);
		pstmt.setString(indVal++,histRecType);
		if(!event_group.equals(""))
			pstmt.setString(indVal++,event_group);
		pstmt.setString(indVal++,event_code);
		pstmt.setString(indVal++,patient_id);
		pstmt.setString(indVal++,patient_id);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			dateForgraph = rs.getString("EVENT_DATE") == null ? "" : rs.getString("EVENT_DATE");
			dateForgraph = com.ehis.util.DateUtils.convertDate(dateForgraph,"DMYHM","en",locale);
			ValueForgraph = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");
			seriesForGraph = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			defaultcategorydataset.addValue(Double.parseDouble(ValueForgraph),seriesForGraph,dateForgraph);
		}
		if(rs!= null) rs.close();
        if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
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

	try
	{
		filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,chartHeight,info,null);
		org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
		graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
	}
	catch(Exception ee)
	{
		
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
	</form>
</body>
</html>
<%putObjectInBean("chartSummaryResults",bean,session); ////IN058139%>


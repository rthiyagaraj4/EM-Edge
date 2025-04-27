<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005-US001
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
	String disMsrId = request.getParameter("disMsrId") == null ? "" : request.getParameter("disMsrId");
	String event_group = request.getParameter("event_group") == null ? "" : request.getParameter("event_group");
	String histRecType = request.getParameter("histRecType") == null ? "" : request.getParameter("histRecType");
	String event_dateTime = request.getParameter("event_dateTime") == null ? "" : request.getParameter("event_dateTime");
	String bean_id="CAVitalSignBean"+patient_id;
    String bean_name="eCA.CAVitalSignBean";
	Map<String,Double> selectedMap =new TreeMap<String,Double>();
	
	CAVitalSignBean bean	= (CAVitalSignBean)getObjectFromBean( bean_id, bean_name , session);
	selectedMap= bean.getSelectedRecords();
	bean.getMaxAndMinValues(disMsrId);
	Map<String,Double> nMap =new TreeMap<String,Double>(Collections.reverseOrder());
	nMap.putAll(selectedMap);
	int chartWidth = 750;
	int chartHeight = 400;
	String xAxisDataType="D";
	String yAxisDataType=""; 
	String xAxisTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels");
	String yAxisTitle = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Values.label","common_labels");
	
	int minValue =bean.getMinValue();
	int maxValue =bean.getMaxValue();
	String disMsrDesc = bean.getDisMsrDesc();
	StringBuffer valuesRangeBuffer = new StringBuffer();
	int i =0;
		
	if(nMap.size()>0){		
		Set set = nMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
			if(i!=0)
				valuesRangeBuffer.append("@");
	        Map.Entry mentry = (Map.Entry)iterator.next();
			valuesRangeBuffer.append(mentry.getKey()+"~"+mentry.getValue()+"~"+disMsrDesc);
			i++;
	    }
		
	}
	if(minValue==0){
		minValue = (int)Math.floor(Collections.min(nMap.values()));		
	}
	if(maxValue==0)
		maxValue = (int)Math.ceil(Collections.max(nMap.values()));
	
	maxValue=(maxValue+50);
	if(chartWidth<(i*30))
		chartWidth =i*30;
	
	if(chartHeight<maxValue)	
		chartHeight = (maxValue+50);
	
%>

	<iframe name="kendoLineChartFrame" id="kendoLineChartFrame" src="Kendo_LineChart.jsp?divID=TESTDIV&chartWidth=<%=chartWidth%>&chartHeight=<%=chartHeight%>&yAxisMin=<%=minValue %>&yAxisMax=<%=maxValue %>&xAxisDataType=<%=xAxisDataType%>&yAxisDataType=<%=yAxisDataType%>&xAxisTitle=<%=xAxisTitle%>&yAxisTitle=<%=yAxisTitle %>&valuesRange=<%=valuesRangeBuffer.toString()%>&legendName=<%=disMsrDesc %>" scrolling="auto" noresize marginheight=0 marginwidth=0 frameborder='0' style='height:100vh;width:100vw'></iframe>
	
</html>


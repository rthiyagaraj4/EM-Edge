<!DOCTYPE html>
<%/* 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       			Edit History    	Name        	Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15/03/2013			IN030469			Ramesh G		Continuous and opportunistic screening for diseases will be performed if the patient fits the criteria. 
														The general practitioner will be alerted if such patients attend the clinic.   								 
01/09/2021			22007				Ramesh G		CIS-CA-Health Risk Assessment Widget
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%@page import="java.util.List,java.util.ArrayList,java.io.*,eCA.*,java.net.*,java.awt.*,java.awt.geom.*,java.text.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.data.time.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,eCA.ChartComponentFormulaBean,java.text.SimpleDateFormat,org.jfree.data.category.DefaultCategoryDataset.*,org.jfree.chart.axis.*,org.jfree.chart.block.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.title.LegendTitle,org.jfree.data.category.*,org.jfree.chart.renderer.category.*,webbeans.eCommon.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id = request.getParameter("bean_id")==null?"":(String)request.getParameter("bean_id");
	DefaultCategoryDataset dataset =(DefaultCategoryDataset)session.getAttribute(bean_id);
    JFreeChart chart = ChartFactory.createBarChart(
		"",       // chart title
		"",               // domain axis label
		"Risk Score(%)",                  // range axis label
		dataset,                  // data
		PlotOrientation.VERTICAL, // orientation
		true,                     // include legend
		true,                     // tooltips?
		false                     // URLs?
    );
		
	ChartPanel chartPanel = new ChartPanel(chart, false);
	
	chart.setBackgroundPaint(Color.white);

	// get a reference to the plot for further customisation...
	CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.black);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.black);
		 
	// make a common vertical axis	
	final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setAutoRangeStickyZero(true);
        rangeAxis.setRange(Double.parseDouble("0"), Double.parseDouble("100"));       
			TickUnits units = new TickUnits();
			units.add(new NumberTickUnit(Double.parseDouble("10")));       
		rangeAxis.setStandardTickUnits(units);

	BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(true);        
		renderer.setMaximumBarWidth(0.05);
		
	GradientPaint gradientpaint0 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(200, 0, 0)); 		
        renderer.setSeriesPaint(0, gradientpaint0);	

	CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
	   
	org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
						
	String graphURL = "";
	String filename = "";
	boolean create = false;
	int chartWidth = 520;
	int chartHeight = 330;

	try{
		filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,chartWidth,chartHeight,info,null);
		//22007 Start.	
		//java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);
		java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);
		//22007 End.
		if(!file.exists())			
			create = file.createNewFile();

		if(create)			
			org.jfree.chart.ChartUtilities.saveChartAsPNG(file,chart,chartWidth,chartHeight,info);		
		
		org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
		
		graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
		
	}catch(Exception ee){
		//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
		
    %>
	
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	
	<table class='grid' cellpadding='3' cellspacing='' border='0' width='100%' height='100%'>
		<tr style="height:20px;">
			<th class='columnHeadercenter' nowrap colspan="2">Probable Diagnoses</th>
		</tr>
		<tr>
			<td>
				<DIV style="height:330px;overflow:none;">
				<center><img  src="<%=graphURL%>" border=0 usemap="#<%=filename%>"/></center>
				<DIV>
			</td>
		</tr>		
	</table>
			
</body>
</html>
	


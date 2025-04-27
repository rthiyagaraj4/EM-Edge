<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
29/03/2012		IN032043		Ramesh G		CA>Chart View>Zoom>graph cannot be viewed or printed.
29/03/2012		IN032065		Ramesh G		The Components whose format is defined as Graph in Define graph Components is not displayed in Chart View.
12/06/2020		IN073152		Durga Natarajan			Graph view function cannot display graph 
---------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.util.*,java.text.*,java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<script language="javascript" src="../../eCA/js/ViewChartRecording.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String chartId = (String)request.getParameter("Chart_Id");
	String fromDate = (String)request.getParameter("FromDate");
	String toDate = (String)request.getParameter("ToDate");
	//String encounterId = (String)request.getParameter("EncounterID");
	String encounterId = request.getParameter("EncounterID")==null?"0":(String)request.getParameter("EncounterID");
	String facilityId = (String)request.getParameter("FacilityID");
	String patientId = (String)request.getParameter("PatientID");
	String fromDate1 =	com.ehis.util.DateUtils.convertDate(fromDate,"DMY", locale,"en");
	String toDate1	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY", locale,"en");
%>
<%@page import="java.util.List,java.util.ArrayList,java.io.*,java.net.*,java.awt.*,java.awt.geom.*,java.text.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.data.time.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,eCA.ChartComponentFormulaBean,java.text.SimpleDateFormat,org.jfree.data.category.DefaultCategoryDataset.*,org.jfree.chart.axis.*,org.jfree.chart.block.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.title.LegendTitle"%>


<body>
<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='ViewChartGraphForm' id='ViewChartGraphForm'>
		<table border="0" cellpadding="0"  cellspacing="0" width="100%">
			<tr style="height:10px;"><td valign="middle" colspan="2">
				<table border="0" bgcolor='white' cellpadding="0"  cellspacing="0" width="100%">
					<tr><td width="80%">&nbsp;</td><td style="padding-right:5px;" align="right" width="10%" id="pGNavegator">&nbsp;</td><td style="padding-left:5px;" align="left" width="10%" id="nGNavegator">&nbsp;</td></tr>
				</table>
			</td></tr>
<%
			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs= null;
			ResultSet rs1= null;
			ArrayList dateArray = new ArrayList();
			ArrayList hoursArray = new ArrayList();
			int displayDays=0;
			int totDates=0;


			
			try{
				int nIndex =1;//common-icn-0180
				con = ConnectionManager.getConnection(request);	
				StringBuffer datequery = new StringBuffer();
				
				datequery.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy') dt FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b ,ca_view_chart_config d ");
				//datequery.append("WHERE b.chart_id = '"+chartId+"' ");//common-icn-0180
				datequery.append("WHERE b.chart_id = ? ");//common-icn-0180
				datequery.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  "); 
				datequery.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I')  ");
				datequery.append("AND a.discr_msr_id = d.discr_msr_id  ");
				datequery.append("AND b.discr_msr_id = d.discr_msr_id  ");
				datequery.append("AND d.FORMAT_TYPE = 'G'  ");
				//datequery.append("AND a.facility_id = '"+facilityId+"'  ");//common-icn-0180
				//datequery.append("AND a.patient_id = '"+patientId+"'  ");//common-icn-0180
				datequery.append("AND a.facility_id = ?  ");//common-icn-0180
				datequery.append("AND a.patient_id = ?  ");//common-icn-0180
				//datequery.append("AND b.encounter_id = '"+encounterId+"'  ");  
				if(!"0".equals(encounterId)){
					//datequery.append("AND b.encounter_id = '"+encounterId+"'  ");  //common-icn-0180
					datequery.append("AND b.encounter_id = ?  "); //common-icn-0180 
				}
				datequery.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+fromDate1+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+toDate1+" 23:59', 'dd/mm/yyyy hh24:mi') ");                                                          
				datequery.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy') asc  ");
				pstmt = con.prepareStatement(datequery.toString());
				//common-icn-0180 starts
				pstmt.setString(nIndex++,chartId);
				pstmt.setString(nIndex++,facilityId);
				pstmt.setString(nIndex++,patientId);
				if(!"0".equals(encounterId)){
				pstmt.setString(nIndex++,encounterId);
				}
				//common-icn-0180 ends
				rs = pstmt.executeQuery();
				while(rs.next()){
					dateArray.add(rs.getString(1));
				}
				if(dateArray.size()>0){

					List<String> rangeDates = new ArrayList<String>();
					String str_date ="27/08/2010";
					String end_date ="02/09/2010";

					DateFormat formatter ; 
					
					formatter = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date  startDate = (java.util.Date)formatter.parse(fromDate1); 
					java.util.Date  endDate = (java.util.Date)formatter.parse(toDate1);
					long interval = 24*1000 * 60 * 60; // 1 hour in millis
					long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
					long curTime = startDate.getTime();
					while (curTime <= endTime) {
						rangeDates.add(formatter.format(new java.util.Date(curTime)));
						curTime += interval;
					}
					
					
					totDates=rangeDates.size();
					displayDays = (String)request.getParameter("Display_Days")==null?0:Integer.parseInt((String)request.getParameter("Display_Days"));
					
					int dDate = displayDays;
					String dStartDate="";
					String dEndDate ="";
					int noOfDays = ((rangeDates.size())-displayDays)>5?(displayDays+5):(rangeDates.size());
					for(;displayDays<noOfDays;displayDays++){						
						String hValue=(String)rangeDates.get(displayDays);
						if(dDate==displayDays){
							dStartDate=hValue;
						}
						if(displayDays==(noOfDays-1)){
							dEndDate=hValue;
						}	
					}					
				
					eCA.CAViewChartBean bean = new eCA.CAViewChartBean();
					HashMap graphData = new HashMap();
					//graphData = (HashMap) bean.getChartData(patientId,facilityId,encounterId,fromDate,toDate,chartId,"G");					
					graphData = (HashMap) bean.getChartData(patientId,facilityId,encounterId,dStartDate+" 0:00",dEndDate+" 23:59",chartId,"G");	
					Set resSet = graphData.keySet();
					
					Iterator iterator = graphData.keySet().iterator();
					StringBuffer charCompIds= new StringBuffer();
					int charCompCount=0;
					while(iterator. hasNext()){ 
						charCompIds.append("'"+iterator.next()+"'");
						charCompCount++;
						if(charCompCount!=(resSet.size())){
							charCompIds.append(",");
						}
					}
				
					
					StringBuffer query = new StringBuffer();
					query.append("Select CVCC.DISCR_MSR_ID,ADM.SHORT_DESC,CVCC.X_AXIS_SCALE,CVCC.Y_AXIS_SCALE,CVCC.MIN_Y_AXIS,CVCC.MAX_Y_AXIS FROM CA_VIEW_CHART_CONFIG CVCC,AM_DISCR_MSR ADM WHERE CVCC.DISCR_MSR_ID =ADM.DISCR_MSR_ID AND CVCC.CHART_ID='");
					query.append(chartId);
					query.append("' AND CVCC.FORMAT_TYPE='G' ORDER BY TO_NUMBER(CVCC.DISP_ORD_SEQ_NUM),ADM.SHORT_DESC");

					//query.append("' AND CVCC.DISCR_MSR_ID IN (");
					//query.append(charCompIds.toString());
					//query.append(") ORDER BY CVCC.DISP_ORD_SEQ_NUM");
					
					pstmt = con.prepareStatement(query.toString());
					rs = pstmt.executeQuery();
					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");		
					DateFormat fyear = new SimpleDateFormat("yyyy");
					DateFormat fmonth = new SimpleDateFormat("MM");
					DateFormat fdate = new SimpleDateFormat("dd");
					DateFormat fHour = new SimpleDateFormat("HH");
					DateFormat fmin = new SimpleDateFormat("mm");
					while(rs.next()){
						int chartWidth = 1000;
						int chartHeight = 160;
						final TimeSeries series1 = new TimeSeries("Date/Time", Minute.class);
						
						
						
						String disMsr_id	= (String)rs.getString(1);
						String disMsr_name	= (String)rs.getString(2);
						String xScal		= (String)rs.getString(3);
						String yScal		= (String)rs.getString(4);
						String yMin			= (String)rs.getString(5);
						String yMax			= (String)rs.getString(6);
						
						ArrayList mainArray = new ArrayList();
						
						
						
						
						//System.out.println(disMsr_id+"<---------------------->"+mainArray.size());
						//5 is a no of Days each page
					//	int noOfDays = (mainArray.size())>5 ? 5 :(mainArray.size());
					    if(graphData.size()>0){
							
							if(graphData.get(disMsr_id)!=null){
								mainArray =(ArrayList)graphData.get(disMsr_id);
							}
							int totRetReco = mainArray.size();
							
							String[] str=new String[totRetReco];
							for(int i=0;i<totRetReco;i++){  
								HashMap fMap = new HashMap();
								fMap = (HashMap)mainArray.get(i);
								
								Iterator fiterator = fMap.keySet().iterator();						
								if(fiterator. hasNext())
									str[i] = (String)fiterator.next();		//Day
								ArrayList subArray = new ArrayList();
								subArray = (ArrayList) fMap.get(str[i]);
								
								for(int j=0;j<subArray.size();j++){
									HashMap sMap = (HashMap)subArray.get(j);
									Iterator siterator = sMap.keySet().iterator();
									String recordDate="";
									String rvalue = "";
									if(siterator. hasNext())
										recordDate= (String)siterator.next();		
									rvalue =(String) sMap.get(recordDate);
									
									java.util.Date dt=df.parse(recordDate);
									series1.add(new Minute(Integer.parseInt(fmin.format(dt)),Integer.parseInt(fHour.format(dt)),Integer.parseInt(fdate.format(dt)),Integer.parseInt(fmonth.format(dt)),Integer.parseInt(fyear.format(dt))),Double.parseDouble(rvalue));
								}
								
							}
						
						}

						
						final TimeSeriesCollection dataset1 = new TimeSeriesCollection();
						dataset1.addSeries(series1);
						
						XYLineAndShapeRenderer shapeRender=new XYLineAndShapeRenderer();
						shapeRender.setShapesFilled(true);
						shapeRender.setSeriesShape(0, new Ellipse2D.Double(-3.0, -3.0, 6.0, 6.0));
						shapeRender.setLinesVisible(true);
						shapeRender.setDrawOutlines(false);
						shapeRender.setToolTipGenerator(
								new StandardXYToolTipGenerator(
										"({1}, {2})",
									new SimpleDateFormat("HH:mm"), new DecimalFormat("###.##")
								)
							);
			
						JFreeChart chart = null;
						JFreeChart chart1 = null;

						// make a common vertical axis for all the sub-plots
						final NumberAxis valueAxis = new NumberAxis("Values");
						valueAxis.setAutoRangeIncludesZero(false);  // override default
						valueAxis.setRange(Double.parseDouble(yMin), Double.parseDouble(yMax));
			
						TickUnits units = new TickUnits();
						units.add(new NumberTickUnit(Double.parseDouble(yScal)));
						valueAxis.setStandardTickUnits(units);

						// make a horizontally combined plot
						final CombinedRangeXYPlot parent = new CombinedRangeXYPlot(valueAxis);
			
			
			
						// Common
						DateFormat chartFormatter = new SimpleDateFormat("dd MMM HH:mm");
			
						
				

						// add subplot 1...
						final XYPlot subplot1 = new XYPlot(dataset1, new DateAxis(""), null,shapeRender);
						subplot1.setDomainCrosshairVisible(true);
						subplot1.setRangeCrosshairVisible(true);
						
						DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
						
						/*for(int k=0;k<str.length;k++){
							//System.out.println(k+"str---------------------->"+str[k]);
							java.util.Date dt1=df1.parse(str[k]);
							
							final Hour hour1 = new Hour(0, new Day(Integer.parseInt(fdate.format(dt1)), Integer.parseInt(fmonth.format(dt1)), Integer.parseInt(fyear.format(dt1))));		
							double millis1 = hour1.getFirstMillisecond();        
							final Marker originalEnd1 = new ValueMarker(millis1);
							originalEnd1.setPaint(Color.darkGray);
							originalEnd1.setStroke(new BasicStroke(1.0f));
							originalEnd1.setLabelAnchor(RectangleAnchor.TOP_LEFT);
							originalEnd1.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
							
							subplot1.addDomainMarker(originalEnd1);
						}*/

						final DateAxis axis = new DateAxis() {
							@SuppressWarnings("unchecked")
							@Override
							protected List refreshTicksHorizontal(Graphics2D g2, Rectangle2D dataArea, RectangleEdge edge) {
							   List ticks = super.refreshTicksHorizontal(g2, dataArea, edge);
							   List ret = new ArrayList();
							   for (Tick tick : (List<Tick>)ticks) {
								  if (tick instanceof DateTick) {
									 DateTick dateTick = (DateTick)tick;
									 ret.add(new DateTick(dateTick.getDate(), dateTick.getText(), dateTick.getTextAnchor(), dateTick.getRotationAnchor(), Math.PI / -5.0));
								  } else {
									 ret.add(tick);
								  }
							   }
							   return ret;
							}
							protected double findMaximumTickLabelHeight(java.util.List ticks, java.awt.Graphics2D g2, java.awt.geom.Rectangle2D drawArea, boolean vertical) {                  
							   return super.findMaximumTickLabelHeight(ticks, g2, drawArea, vertical) * Math.sin(Math.PI / 5.0);
							}                                                     
						 };
						 axis.setVerticalTickLabels(true); 
						 axis.setDateFormatOverride(chartFormatter);
						 
						 axis.setDateFormatOverride(chartFormatter);
						 DateTickUnit unit1 = new DateTickUnit(DateTickUnit.HOUR,Integer.parseInt(xScal	));
						 axis.setTickUnit(unit1);
									
						java.util.Date dtStart=df1.parse(dStartDate);
						java.util.Date dtEnd=df1.parse(dEndDate);
						
						final Hour minhour1 = new Hour(0, new Day(Integer.parseInt(fdate.format(dtStart)), Integer.parseInt(fmonth.format(dtStart)), Integer.parseInt(fyear.format(dtStart))));		
						double minmillis1 = minhour1.getFirstMillisecond(); 
						final Hour maxhour1 = new Hour(24, new Day(Integer.parseInt(fdate.format(dtEnd)), Integer.parseInt(fmonth.format(dtEnd)), Integer.parseInt(fyear.format(dtEnd))));		
						double maxmillis1 = maxhour1.getFirstMillisecond(); 
						axis.setRange(minmillis1, maxmillis1);
		   
						subplot1.setDomainAxis(0, axis);
		   
					String narmallow ="0";
					String narmalHigh = "0";
		   
					StringBuffer query1 = new StringBuffer();
					query1.append("SELECT NUM_REF_LOW,NUM_REF_HIGH FROM AM_DISCR_MSR_REF_RNG_NUM WHERE  DISCR_MSR_ID IN ('");
					query1.append(disMsr_id);
					query1.append("')");
					
					pstmt = con.prepareStatement(query1.toString());
					rs1 = pstmt.executeQuery();
					if(rs1.next()){
						narmallow = rs1.getString(1)==null?"0":(String)rs1.getString(1);
						narmalHigh = rs1.getString(2)==null?"0":(String)rs1.getString(2);
					}
					
					if(!"0".equals(narmallow) && !"0".equals(narmalHigh)){
						final IntervalMarker bol=new IntervalMarker(Double.parseDouble(narmallow),Double.parseDouble(narmalHigh));				
						bol.setPaint(new Color(50, 205, 50));		   
							subplot1.addRangeMarker(bol, Layer.BACKGROUND);	
					}	
						
			
						parent.add(subplot1, 1);
			

						chart = new JFreeChart(disMsr_name, JFreeChart.DEFAULT_TITLE_FONT, parent, true);

			

						org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
						
						String graphURL = "";
						String graphPrintURL="";
						String filename = "";
						String filename1 = "";
						boolean create = false;

						try
						{
							filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,chartWidth,chartHeight,info,null);
							//java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename);//Commented for IN073152
							java.io.File file = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);//IN073152
							System.out.println("ViewChartRecordingGraphPopulation.jsp---file---->"+config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename);
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

							filename1 = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(chart,1000,350,info,null);
						//	java.io.File file1 = new java.io.File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + filename1);//Commented for IN073152
							java.io.File file1 = new java.io.File(config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename1);//IN073152
							System.out.println("ViewChartRecordingGraphPopulation.jsp---file1---->"+config.getServletContext().getRealPath("/")+"/eCA/MediPainter/images/" + filename1);
							if(file1.exists())
							{
								out.println("<script>alert('file already exists');</script>");
							}
							else
								create = file1.createNewFile();
							if(create)
							{
								org.jfree.chart.ChartUtilities.saveChartAsPNG(file1,chart,1000,350,info);
							}
							org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename1,info,false);
							graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
							graphPrintURL=request.getContextPath()+"/eCA/MediPainter/images/"+filename1;
						}
						catch(Exception ee)
						{
							//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
							ee.printStackTrace();
						}	
						
						%>
						
						<tr style='padding-bottom:5px;'>
							<td width='98%'>						
								<center><img  src="<%=graphURL%>" border=0 usemap="#<%=filename%>"/></center>
							</td>
							<td width='2%' valign="top"><A HREF="javascript:openZoom('<%=disMsr_name%>','<%=filename1%>');">Zoom</A>&nbsp;&nbsp;<A HREF="javascript:printGraph('<%=graphPrintURL%>');">Print</A></td>
						</tr>
						<%
						
						
					}
				}//else{
				%>						
					<!--<TR>
						<TD   width='100%'><font size="1">
							<script>
							alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
							</script>
						
						</font></TD>
					</TR> -->
				<%
				//}
			}catch(Exception e){
				//out.println(e.toString());//COMMON-ICN-0181
				 e.printStackTrace();//COMMON-ICN-0181
			}finally{
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}
			%>			
			
		</table>
		<input type="hidden" name="tDisplayDays" id="tDisplayDays" value="<%=displayDays %>"/>
		<input type="hidden" name="tTotalRows" id="tTotalRows" value="<%=totDates %>"/>
		<input type=hidden name='chart_id' id='chart_id' value='<%=chartId%>'>
		<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounterId%>'>
		<input type=hidden name='patient_id' id='patient_id' value='<%=patientId%>'>
		<input type=hidden name='facility_id' id='facility_id' value='<%=facilityId%>'>
		<input type=hidden name='toDateForExt' id='toDateForExt' value='<%=toDate%>'>
		<input type=hidden name='fromDateForExt' id='fromDateForExt' value='<%=fromDate%>'>
	</form>
	<script>
var disDays=parseInt(document.ViewChartGraphForm.tDisplayDays.value);
var totDays=parseInt(document.ViewChartGraphForm.tTotalRows.value);
if(totDays>disDays){
	document.getElementById("nGNavegator").innerHTML="<A href=\"javascript:clickNextforGraph();\">Next</A>";
}else{
	document.getElementById("nGNavegator").innerHTML="&nbsp;";
}
if(disDays>5){
	document.getElementById("pGNavegator").innerHTML="<A href=\"javascript:clickPreviousforGraph();\">Previous</A>";
}else{
	document.getElementById("pGNavegator").innerHTML="&nbsp;";
}
</script>
</body>
</html>


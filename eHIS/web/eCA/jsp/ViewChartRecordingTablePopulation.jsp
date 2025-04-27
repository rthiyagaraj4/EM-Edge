<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
24/10/2013    IN044496       Chowminya     In critical high value, system should be fill colour indicator of critical high value as per configuration.	
28/10/2013    IN044612       Chowminya     (reopen)In critical high value, system should be fill colour indicator of critical high value
02/06/2014	  IN037701		Chowminya			SKR-CRF-0036
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,java.text.*,java.sql.*,webbeans.eCommon.*,com.ehis.persist.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>	
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701
	String locale = (String) p.getProperty("LOCALE");
	String tchartId = (String)request.getParameter("Chart_Id");
	String tfromDate = (String)request.getParameter("FromDate");
	String ttoDate = (String)request.getParameter("ToDate");
	//String tencounterId = (String)request.getParameter("EncounterID");
	String tencounterId = request.getParameter("EncounterID")==null?"0":(String)request.getParameter("EncounterID");
	String tfacilityId = (String)request.getParameter("FacilityID");
	String tpatientId = (String)request.getParameter("PatientID");
	String tfromDate1 =	com.ehis.util.DateUtils.convertDate(tfromDate,"DMY", locale,"en");
	String ttoDate1	=	com.ehis.util.DateUtils.convertDate(ttoDate,"DMY", locale,"en");
String pageStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=pageStyle%>' type='text/css' />
<script language="javascript" src="../../eCA/js/ViewChartRecording.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<style>		
	TD.columnfirstHeader{
	    COLOR: white ;
		background-color:#83AAB4;		
		padding-left:3px;
		font-family: Verdana;
		font-size: 8pt;
		font-weight:bold; 
		text-align:center;
	}
	TD.columnsecondHeader{
	   BACKGROUND-COLOR: #83AAB4;
	   COLOR: white ;
	   FONT-SIZE: 8pt; 
	   text-align:left;
	}	
	TD.columnData{
	   BACKGROUND-COLOR: white;
	   COLOR: black ;
	   FONT-SIZE: 8pt; 
	   text-align:center;
	}
	TD.columnData1{
	   BACKGROUND-COLOR: #FF6666;
	   COLOR: black ;
	   FONT-SIZE: 8pt; 
	   text-align:center;
	}
	TD.columnData2{
	   BACKGROUND-COLOR: #FFFF33;
	   COLOR: black ;
	   FONT-SIZE: 8pt; 
	   text-align:center;
	}
	</style>
</head>
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

<form name="ViewChartListPopulation" id="ViewChartListPopulation">	
<TABLE cellpadding="0"0cellspacing="0" width="100%">
	<tr style="height:10px;" id="noDataRow" style="display:none"><td align="center" valign="top" >There is no Record found.</td></tr>
	<tr style="height:10px;"><td valign="middle">
			<table border="0" bgcolor='white' cellpadding="0"  cellspacing="0" width="100%">
				<tr><td width="80%">&nbsp;</td><td style="padding-right:5px;" align="right" width="10%" id="pNavegator">&nbsp;</td><td style="padding-left:5px;" align="left" width="10%" id="nNavegator">&nbsp;</td></tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>			
		
	<%
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs,rs1= null;
		ArrayList dateArray = new ArrayList();
		ArrayList hoursArray = new ArrayList();
		int displayDays=0;
		int totDates=0;
		try{
				con = ConnectionManager.getConnection(request);	
				StringBuffer query = new StringBuffer();
				
				query.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy') dt FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b ,ca_view_chart_config d ");
				//query.append("WHERE b.chart_id = '"+tchartId+"' ");//common-icn-0180
				query.append("WHERE b.chart_id = ? ");//common-icn-0180
				query.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
				query.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
				query.append("AND a.discr_msr_id = d.discr_msr_id ");
				query.append("AND b.discr_msr_id = d.discr_msr_id "); 
				query.append("AND d.FORMAT_TYPE = 'T' ");
				//query.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
				query.append("AND a.facility_id = ? ");//common-icn-0180
				//query.append("AND a.patient_id = '"+tpatientId+"' ");//common-icn-0180
				query.append("AND a.patient_id = ? ");//common-icn-0180
				//query.append("AND b.encounter_id = '"+tencounterId+"' ");
				if(!"0".equals(tencounterId)){
					//query.append("AND b.encounter_id = '"+tencounterId+"' ");//common-icn-0180
					query.append("AND b.encounter_id = ? ");//common-icn-0180
				}
				//query.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+tfromDate1+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+ttoDate1+" 23:59', 'dd/mm/yyyy hh24:mi')   ");	//common-icn-0180														
				query.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi')   ");//common-icn-0180															
				
				query.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy') asc  ");
				ps = con.prepareStatement(query.toString());
				//common-icn-0180 starts
				ps.setString(1, tchartId);
				ps.setString(2, tfacilityId);
				ps.setString(3, tpatientId);
				ps.setString(4, tencounterId);
				ps.setString(5, tfromDate1);
				ps.setString(6, ttoDate1);
				//common-icn-0180 ends
				rs = ps.executeQuery();
				while(rs.next()){
					dateArray.add(rs.getString(1));
				}
				if(dateArray.size()>0){
				
					totDates=dateArray.size();
					displayDays = (String)request.getParameter("Display_Days")==null?0:Integer.parseInt((String)request.getParameter("Display_Days"));
					
					int dDate = displayDays;
					String dStartDate="";
					String dEndDate ="";
					int noOfDays = ((dateArray.size())-displayDays)>5?(displayDays+5):(dateArray.size());
					%>
					<TABLE cellpadding="1" bgcolor='#404040' cellspacing="1"  style='padding-top:2px;' width="100%">
					<TR>
						<TD rowspan='2' class='columnfirstHeader'  width='10%'>&nbsp;</TD>
					<%
					
					for(;displayDays<noOfDays;displayDays++){
						int colSpan = 0;
						int colWidth = 0;
						String hValue=(String)dateArray.get(displayDays);
						if(dDate==displayDays){
							dStartDate=hValue;
						}
						if(displayDays==(noOfDays-1)){
							dEndDate=hValue;
						}
						StringBuffer query1 = new StringBuffer();
						query1.append("SELECT  count(DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi')) dt ");
						query1.append("FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b, ca_view_chart_config d ");
						//query1.append("WHERE b.chart_id = '"+tchartId+"' ");//common-icn-0180
						query1.append("WHERE b.chart_id = ? ");//common-icn-0180
						query1.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
						query1.append("AND a.discr_msr_id = d.discr_msr_id ");
						query1.append("AND b.discr_msr_id = d.discr_msr_id ");
						query1.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
						query1.append("AND d.FORMAT_TYPE='T' ");
						//query1.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
						query1.append("AND a.facility_id = ? ");//common-icn-0180
						//query1.append("AND a.patient_id = '"+tpatientId+"' ");	//common-icn-0180
						query1.append("AND a.patient_id = ? "); //common-icn-0180	
						//query1.append("AND b.encounter_id = '"+tencounterId+"' ");
						if(!"0".equals(tencounterId)){
							//query1.append("AND b.encounter_id = '"+tencounterId+"' ");//common-icn-0180    
							query1.append("AND b.encounter_id = ? ");  //common-icn-0180  
						}
						//query1.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+hValue+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+hValue+" 23:59', 'dd/mm/yyyy hh24:mi') "); //common-icn-0180
						query1.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");//common-icn-0180
						
						query1.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy hh24:mi') asc  ");
						ps = con.prepareStatement(query1.toString());
						//common-icn-0180 starts
						ps.setString(1, tchartId);
						ps.setString(2, tfacilityId);
						ps.setString(3, tpatientId);
						ps.setString(4, tencounterId);
						ps.setString(5, hValue);
						ps.setString(6, hValue);
						//common-icn-0180 ends
						rs = ps.executeQuery();
						if(rs.next())
							colSpan = rs.getInt(1);
						colWidth=colWidth * colSpan;
					%>
					
						<TD colspan='<%=colSpan%>' class='columnfirstHeader' align='center' style='width:<%=colWidth%>px;'><%=	com.ehis.util.DateUtils.convertDate(hValue,"DMY", "en",locale) %></TD>		
							
					
					<%
					}
					%>
					</TR>
					<%
					StringBuffer query2 = new StringBuffer();
					query2.append("SELECT  DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy hh24:mi') dt ");
					query2.append("FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b, ca_view_chart_config d ");
					//query2.append("WHERE b.chart_id = '"+tchartId+"'  ");//common-icn-0180
					query2.append("WHERE b.chart_id = ?  ");//common-icn-0180
					query2.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
					query2.append("AND a.discr_msr_id = d.discr_msr_id ");
					query2.append("AND b.discr_msr_id = d.discr_msr_id ");
					query2.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
					query2.append("AND d.FORMAT_TYPE='T' ");
					//query2.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
					query2.append("AND a.facility_id = ?");//common-icn-0180
					//query2.append("AND a.patient_id = '"+tpatientId+"' ");//common-icn-0180
					query2.append("AND a.patient_id = ? ");//common-icn-0180
					//query2.append("AND b.encounter_id = '"+tencounterId+"' ");
					if(!"0".equals(tencounterId)){
							//query2.append("AND b.encounter_id = '"+tencounterId+"' ");    
							query2.append("AND b.encounter_id = ? ");//common-icn-0180    
						}
					//query2.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+dStartDate+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+dEndDate+" 23:59', 'dd/mm/yyyy hh24:mi') ");//common-icn-0180  
					query2.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi') ");  //common-icn-0180
					
					query2.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy hh24:mi') asc  ");
					ps = con.prepareStatement(query2.toString());
					//common-icn-0180 starts
					ps.setString(1, tchartId);
					ps.setString(2, tfacilityId);
					ps.setString(3, tpatientId);
					ps.setString(4, tencounterId);
					ps.setString(5, dStartDate);
					ps.setString(6, dEndDate);
					//common-icn-0180 ends
					rs = ps.executeQuery();
					while(rs.next()){
						hoursArray.add(rs.getString(1));
					}
					DateFormat fHour = new SimpleDateFormat("HH:mm");
					DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");	
					%>
					<TR>
					<%
					for(int i=0;i<hoursArray.size();i++){
					java.util.Date dt=df.parse((String)hoursArray.get(i));
					String timeValue=fHour.format(dt);
					%>
					<TD class='columnsecondHeader' align='center' style='width:5px;'><%=timeValue %></TD>
					<%
					
					}
					%>
					</TR>
					<%
					
					ps = con.prepareStatement("SELECT CRIT_LOW_COLOR_CODE,LOW_COLOR_CODE,HIGH_COLOR_CODE,CRIT_HIGH_COLOR_CODE FROM CR_CLIN_EVENT_PARAM");
					rs = ps.executeQuery();
					String critcalLowColor = "style='width:5px;'";
					String lowColor = "style='width:5px;'";
					String NoramalColor = "style='background-color:#32CD32;width:5px;'";
					String highColor = "style='width:5px;'";
					String critcalHighColor = "style='width:5px;'";
					if(rs.next()){
						critcalLowColor = rs.getString(1)==null?"":"style='background-color:"+(String)rs.getString(1)+";width:5px;'";
						lowColor = rs.getString(2)==null?"":"style='background-color:"+(String)rs.getString(2)+";width:5px;'";
						highColor = rs.getString(3)==null?"":"style='background-color:"+(String)rs.getString(3)+";width:5px;'";
						critcalHighColor = rs.getString(4)==null?"":"style='background-color:"+(String)rs.getString(4)+";width:5px;'";
					}
					eCA.CAViewChartBean bean = new eCA.CAViewChartBean();
					Hashtable tableData = new Hashtable();
					tableData = (Hashtable) bean.getTableData(tpatientId,tfacilityId,tencounterId,dStartDate+" 00:00",dEndDate+" 23:59",tchartId,"T");
					Enumeration en=tableData.keys();
					//while(en.hasMoreElements()){
					//	String compId=(String)en.nextElement();
						StringBuffer query5 = new StringBuffer();
						//query5.append("Select DISCR_MSR_ID FROM CA_VIEW_CHART_CONFIG WHERE CHART_ID='"+tchartId+"' AND FORMAT_TYPE='T' ORDER BY DISP_ORD_SEQ_NUM");
						//query5.append("Select CVCC.DISCR_MSR_ID,CVCC.DISP_ORD_SEQ_NUM,ADM.SHORT_DESC FROM CA_VIEW_CHART_CONFIG CVCC,AM_DISCR_MSR ADM WHERE  CVCC.DISCR_MSR_ID=ADM.DISCR_MSR_ID AND CVCC.CHART_ID='"+tchartId+"' AND CVCC.FORMAT_TYPE='T' ORDER BY TO_NUMBER(CVCC.DISP_ORD_SEQ_NUM),ADM.SHORT_DESC");//common-icn-0180
						query5.append("Select CVCC.DISCR_MSR_ID,CVCC.DISP_ORD_SEQ_NUM,ADM.SHORT_DESC FROM CA_VIEW_CHART_CONFIG CVCC,AM_DISCR_MSR ADM WHERE  CVCC.DISCR_MSR_ID=ADM.DISCR_MSR_ID AND CVCC.CHART_ID=? AND CVCC.FORMAT_TYPE='T' ORDER BY TO_NUMBER(CVCC.DISP_ORD_SEQ_NUM),ADM.SHORT_DESC");//common-icn-0180
						
						ps = con.prepareStatement(query5.toString());
						ps.setString(1, tchartId);//common-icn-0180
						rs1 = ps.executeQuery();
				while(rs1.next()){
						String compId=(String)rs1.getString(1);
						StringBuffer query4 = new StringBuffer();
						query4.append("SELECT ADM.SHORT_DESC,ADM.MIN_VALUE,ADMRRN.NUM_CRIT_LOW,ADMRRN.NUM_REF_LOW,ADMRRN.NUM_REF_HIGH,ADMRRN.NUM_CRIT_HIGH,ADM.MAX_VALUE FROM AM_DISCR_MSR ADM,AM_DISCR_MSR_REF_RNG_NUM ADMRRN WHERE  ADMRRN.DISCR_MSR_ID =ADM.DISCR_MSR_ID AND ADM.DISCR_MSR_ID IN ('");
						query4.append(compId);
						query4.append("')");
						ps = con.prepareStatement(query4.toString());				
						rs = ps.executeQuery();
						String compName="";
						Double minValue=0.00;
						Double critLowValue=0.00;
						Double lowValue=0.00;
						Double highValue=0.00;
						Double critHighValue=0.00;
						Double maxValue=0.00;
						if(rs.next()){
							compName=(rs.getString(1))==null?"":((String)rs.getString(1));
							minValue =(rs.getString(2))==null?0.00:Double.parseDouble(((String)rs.getString(2)));
							critLowValue =(rs.getString(3))==null?0.00:Double.parseDouble(((String)rs.getString(3)));
							lowValue  =(rs.getString(4))==null?0.00:Double.parseDouble(((String)rs.getString(4)));
							highValue  =(rs.getString(5))==null?0.00:Double.parseDouble(((String)rs.getString(5)));
							critHighValue  =(rs.getString(6))==null?0.00:Double.parseDouble(((String)rs.getString(6)));
							maxValue  =(rs.getString(7))==null?0.00:Double.parseDouble(((String)rs.getString(7)));
						}					
						Hashtable stable=(Hashtable)tableData.get(compId);
						if(stable!=null){
						%>
						<TR>
						<TD class='columnsecondHeader'  nowrap='true'><%=compName %></TD>
						<%
						for(int j=0;j<hoursArray.size();j++){
							String tdata=((String)stable.get((String)hoursArray.get(j)))==null?"":"0".equals(((String)stable.get((String)hoursArray.get(j))))?"":((String)stable.get((String)hoursArray.get(j)));
							if (!"".equals(tdata)){
								Double dataValue=Double.parseDouble(tdata);							
								if(dataValue<=critLowValue)//(minValue<=dataValue && dataValue<=critLowValue) //removed second condition IN044496//IN044612
								{
									%>
									<TD align='center' class='columnData' <%=critcalLowColor %> ><%=tdata %></TD>
									<%
								}else if(critLowValue<dataValue && dataValue<lowValue){
									%>
									<TD align='center' class='columnData' <%=lowColor %> ><%=tdata %></TD>
									<%
								}else if(lowValue<=dataValue && dataValue<highValue){
									%>
									<TD align='center' class='columnData' <%=NoramalColor %> ><%=tdata %></TD>
									<%
								}else if(highValue<=dataValue && dataValue<critHighValue){
									%>
									<TD align='center' class='columnData' <%=highColor %> ><%=tdata %></TD>
									<%
								}else if(critHighValue<=dataValue)//(critHighValue<=dataValue && dataValue<=maxValue)removed second conditionIN04449IN044612
								{
									%>
									<TD align='center' class='columnData' <%=critcalHighColor %> ><%=tdata %></TD>
									<%
								}else{
									%>
									<TD align='center' class='columnData' style='width:5px;'><%=tdata %></TD>
									<%
								}
							}else{
								%>
								<TD align='center' class='columnData' style='width:5px;'><%=tdata %></TD>
								<%
							}
						}
						%>
						</TR>
						<%
						}
					}
					%>
					<!-- IN037701 Start. -->
						<script>							
							if("CA_SPC"=="<%=p_called_from%>"){
									parent.chartRecordingFrameSet.rows="9%,*,4%";
									parent.chartRecordingFrameSetInner.rows="73%,27%";
									parent.document.getElementsByName("ChartRecordingGraphFrame").scrolling="auto";
									parent.document.getElementsByName("ChartRecordingListFrame").scrolling="auto";
									parent.parent.document.getElementById("FrameID12").style.height="600px";
									parent.parent.document.getElementById("RecID12").style.height="600px";
									document.getElementById("noDataRow").style.display='';
								}
						</script>
					<!-- IN037701 End. -->
					<%
				}else{
					StringBuffer queryT = new StringBuffer();
				
					queryT.append("SELECT DISTINCT TO_CHAR (a.test_observ_dt_tm, 'dd/mm/yyyy') dt FROM ca_encntr_discr_msr a, ca_encntr_chart_draft b ,ca_view_chart_config d ");
					//queryT.append("WHERE b.chart_id = '"+tchartId+"' ");//common-icn-0180
					queryT.append("WHERE b.chart_id = ? ");//common-icn-0180
					queryT.append("AND NVL (a.error_yn, 'N') != 'Y' AND b.facility_id = a.facility_id AND b.encounter_id = a.encounter_id AND a.chart_id = b.chart_id  AND d.chart_id = b.chart_id ");
					queryT.append("AND a.discr_msr_panel_or_form_id = b.panel_id AND a.discr_msr_id = b.discr_msr_id AND a.discr_msr_result_type IN ('N', 'I') ");
					queryT.append("AND a.discr_msr_id = d.discr_msr_id ");
					queryT.append("AND b.discr_msr_id = d.discr_msr_id "); 
					queryT.append("AND d.FORMAT_TYPE = 'G' ");
					//queryT.append("AND a.facility_id = '"+tfacilityId+"' ");//common-icn-0180
					queryT.append("AND a.facility_id = ? ");//common-icn-0180
					//queryT.append("AND a.patient_id = '"+tpatientId+"' ");//common-icn-0180
					queryT.append("AND a.patient_id = ? ");//common-icn-0180
					//query.append("AND b.encounter_id = '"+tencounterId+"' ");
					if(!"0".equals(tencounterId)){
						//queryT.append("AND b.encounter_id = '"+tencounterId+"' ");//common-icn-0180
						queryT.append("AND b.encounter_id = ? ");//common-icn-0180
					}
					//queryT.append("AND a.test_observ_dt_tm BETWEEN TO_DATE ('"+tfromDate1+" 00:00', 'dd/mm/yyyy hh24:mi') AND   TO_DATE ('"+ttoDate1+" 23:59', 'dd/mm/yyyy hh24:mi')   ");//common-icn-0180															
					queryT.append("AND a.test_observ_dt_tm BETWEEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND   TO_DATE (?, 'dd/mm/yyyy hh24:mi')   ");	//common-icn-0180														
					
					queryT.append("ORDER BY TO_DATE(dt,'dd/mm/yyyy') asc  ");
					ps = con.prepareStatement(queryT.toString());
					//common-icn-0180 starts
					ps.setString(1, tchartId);
					ps.setString(2, tfacilityId);
					ps.setString(3, tpatientId);
					ps.setString(4, tencounterId);
					ps.setString(5, tfromDate1);
					ps.setString(6, ttoDate1);
					//common-icn-0180 ends
					rs = ps.executeQuery();
					if(rs.next()){
					}else{
					%>
						<TABLE cellpadding="1"  cellspacing="1"  style='padding-top:2px;' width="100%">
						<TR>
							<TD    width='100%'><font size="1">
								<script>
								//IN037701 Start. 
								//alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
								if("CA_SPC"=="<%=p_called_from%>"){
									parent.chartRecordingFrameSet.rows="60%,*,4%";
									parent.chartRecordingFrameSetInner.rows="10%,*";
									parent.document.getElementsByName("ChartRecordingGraphFrame").scrolling="no";
									parent.document.getElementsByName("ChartRecordingListFrame").scrolling="no";
									parent.parent.document.getElementById("FrameID12").style.height="100px";
									parent.parent.document.getElementById("RecID12").style.height="100px";
									document.getElementById("noDataRow").style.display='';
								}else{
									alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));								
								}
								// IN037701 End. 
								</script>						
							</font></TD>
						</TR>
					<%
					}
				}
		}catch(Exception ee)
		{
			//out.println("Exception in try -2 :"+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}finally{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		}	
	%>	
			</TABLE>
		</td>
	</tr>
	<input type="hidden" name="tDisplayDays" id="tDisplayDays" value="<%=displayDays %>"/>
	<input type="hidden" name="tTotalRows" id="tTotalRows" value="<%=totDates %>"/>
	<input type=hidden name='chart_id' id='chart_id' value='<%=tchartId%>'>
	<input type=hidden name='encounter_id' id='encounter_id' value='<%=tencounterId%>'>
	<input type=hidden name='patient_id' id='patient_id' value='<%=tpatientId%>'>
	<input type=hidden name='facility_id' id='facility_id' value='<%=tfacilityId%>'>
	<input type=hidden name='toDateForExt' id='toDateForExt' value='<%=ttoDate%>'>
	<input type=hidden name='fromDateForExt' id='fromDateForExt' value='<%=tfromDate%>'>
</table>
</form>
<script>
var disDays=parseInt(document.ViewChartListPopulation.tDisplayDays.value);
var totDays=parseInt(document.ViewChartListPopulation.tTotalRows.value);
if(totDays>disDays){
	document.getElementById("nNavegator").innerHTML="<A href=\"javascript:clickNextforList();\">Next</A>";
}else{
	document.getElementById("nNavegator").innerHTML="&nbsp;";
}
if(disDays>5){
	document.getElementById("pNavegator").innerHTML="<A href=\"javascript:clickPreviousforList();\">Previous</A>";
}else{
	document.getElementById("pNavegator").innerHTML="&nbsp;";
}
</script>
</body>
</html>


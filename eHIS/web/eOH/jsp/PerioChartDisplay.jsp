<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String q1_sno = "";
	String q2_sno = "";
	String tooth_str = "";
	String display_tooth_str = "";
	String max_chart_num = "";
 
	int tooth_count = 0;

	String[] tooth_str_arr = null;
	String[] display_tooth_str_arr = null;

	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String chart_num = checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
	String baseline_active_yn = checkForNull(request.getParameter("baseline_active_yn")) ;
	String baseline_closed_yn = checkForNull(request.getParameter("baseline_closed_yn")) ;
	
	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String perio_chart = checkForNull(request.getParameter("perio_chart"));
	String perio_arch = checkForNull(request.getParameter("perio_arch"));
	String oh_chart_level = checkForNull(request.getParameter("oh_chart_level"));
	String added_date = checkForNull(request.getParameter("added_date"));	
	String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id"));	
	String other_facilitychart_yn = checkForNull(request.getParameter("other_facilitychart_yn"));
	String patient_class = checkForNull(request.getParameter("patient_class"));
	if(other_facilitychart_yn.equals("Y")){
			facility_id=other_chart_facility_id;
	
	}

	if(!perio_arch.equals("")){
		if(perio_arch.equals("U")){
			q1_sno = "1";
			q2_sno = "2";
		}
		else if(perio_arch.equals("L")){
			q1_sno = "3";
			q2_sno = "4";
		}
	}

	String remarks = checkForNull(request.getParameter( "remarks" )) ;
	String remarks_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	String remarks_history = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.RemarksHistory.Label","OH");
	
%>

<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOH/js/PerioChart.js"></script>
	<script language="javascript" src="../../eOH/js/HistPerioChart.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{
	con=ConnectionManager.getConnection(request);
	String facility_name = "";
	String chart_code_1 = "";
	String chart_date_start_1 = "";
	String chart_close_date_1 =  "";
	String chart_num_1 = "";
	String chart_desc_1 =  "";
	String chart_status_1 =  "";
	String chart_code =  perio_chart;
	ArrayList comp_details = new ArrayList();
		

	if(chart_num.equals("")){
		//To get the chart_num when the chart is new (there are no records for this chart in the HDR table).Since onclick of record we are not refreshing display page chart_num will be null.
		pstmt = con.prepareStatement("SELECT MAX(CHART_NUM)+1 MAX_CHART_NUM FROM OH_PERIODONTAL_CHART_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? ");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			max_chart_num = checkForNull(rs.getString("MAX_CHART_NUM"),"1");
		}
		chart_num = max_chart_num;
	}

	//To get the No of tooth per Arch
	pstmt = con.prepareStatement("SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND B.QUADRANT_SNO IN (?,?) ORDER BY B.QUADRANT_SNO,A.TOOTH_NO");
	pstmt.setString(1,tooth_numbering_system);
	pstmt.setString(2,q1_sno);
	pstmt.setString(3,q2_sno);
	rs = pstmt.executeQuery();
	while(rs.next()){
		if(tooth_count == 0){
			tooth_str = checkForNull(rs.getString("TOOTH_NO"));
			display_tooth_str = checkForNull(rs.getString("DISPLAY_TOOTH_NO"));
		}
		else{
			tooth_str = tooth_str + "," +checkForNull(rs.getString("TOOTH_NO"));
			display_tooth_str = display_tooth_str + "," +checkForNull(rs.getString("DISPLAY_TOOTH_NO"));
		}
		tooth_count++;
	}

	if(!chart_code.equals("")){
		pstmt = con.prepareStatement("SELECT A.CHART_STATUS, A.CHART_CODE,TO_CHAR(A.CHART_DATE,'DD/MM/YYYY') CHART_DATE_MOD,TO_CHAR (A.CHART_CLOSE_DATE,'DD/MM/YYYY') CHART_CLOSE_DATE ,A.CHART_NUM, (SELECT B.CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR B WHERE B.CHART_CODE = A.CHART_CODE) CHART_DESC,  A.CHART_STATUS FROM OH_PERIODONTAL_CHART_HDR A  WHERE  A.PATIENT_ID = ? AND A.CHART_STATUS IN('PE','CM','CD') and A.chart_code=? and A.CHART_NUM=?ORDER BY A.CHART_DATE DESC ");
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_code);
		pstmt.setString(3,chart_num);
		rs = pstmt.executeQuery();
		while(rs.next()){
			chart_status_1 = checkForNull(rs.getString("CHART_STATUS"));
			chart_code_1 = checkForNull(rs.getString("CHART_CODE"));
			chart_date_start_1=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("CHART_DATE_MOD"),"DMY","en",locale));
			chart_close_date_1=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("CHART_CLOSE_DATE"),"DMY","en",locale));
			chart_num_1 = checkForNull(rs.getString("CHART_NUM"));
			chart_desc_1 = checkForNull(rs.getString("CHART_DESC"));
			chart_status_1 = checkForNull(rs.getString("CHART_STATUS"));
			
		}

		pstmt = con.prepareStatement("SELECT FACILITY_NAME  FROM SM_FACILITY_PARAM WHERE FACILITY_ID = (SELECT OPERATING_FACILITY_ID FROM OH_PERIODONTAL_CHART_HDR  WHERE CHART_NUM = ? AND PATIENT_ID = ?)");
		pstmt.setString(1,chart_num);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();
		while(rs.next()){
			facility_name = rs.getString("FACILITY_NAME");
		}
	}

	if(!perio_chart.equals("")){
		//Added by Sridevi Joshi on 4/29/2010 for PE .. this qry was getting exexcuted 3 times to retrieve components...
		pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			comp_details.add(checkForNull(rs.getString("COMPONENT_CODE")));
			comp_details.add(checkForNull(rs.getString("COMPONENT_SHORT_DESC_USER_DEF")));
			comp_details.add(checkForNull(rs.getString("SURFACES_APPL_YN")));
		}
	}

	
%>
<!-- <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onmouseover="delayRemarkLinkLoadTime()" onload="delayRemarkLinkLoadTime()"> -->
<!-- onmouseover="delayRemarkLinkLoadTime() is removed by Sridevi Joshi on 4/27/2010 for PE....this function was getting called multiple times -->
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="delayRemarkLinkLoadTime()">
	<form name="perioChartDisplayForm" id="perioChartDisplayForm" action="../../servlet/eOH.OHDentalChartServletNew" method="post" target="messageFrame">
		
		<table width="100%" cellpadding =0 cellspacing=0 border = '1'>
		<tr>
		<%
		if((baseline_active_yn.equals("Y")|| baseline_closed_yn.equals("Y") ) || (chart_status_1.equals("CM")|| chart_status_1.equals("PE") || (chart_status_1.equals("CD")))){
		%>
			 <td  id="header_id" width= "100%" align="center" style="background-color:brown" id="tabColor"><font color="white"> <fmt:message key="eOH.BaselineChart.Label" bundle="${oh_labels}"/>  # <%=chart_num%> ,<fmt:message key="eOH.ChartStartDate.Label" bundle="${oh_labels}"/>  <%=chart_date_start_1%>, <fmt:message key="eOH.ClosedDate.Label" bundle="${oh_labels}"/> <%=chart_close_date_1%> ,<fmt:message key="eOH.CreatedAt.Label" bundle="${oh_labels}"/><%=facility_name%></b></font></td>  
	  <%}
		else{
	  %>
			  <td  id="header_id"width= "100%" align="center" style="background-color:brown"><font color="white"> <fmt:message key="eOH.BaselineChart.Label" bundle="${oh_labels}"/>  # ,<fmt:message key="eOH.ChartStartDate.Label" bundle="${oh_labels}"/> , <fmt:message key="eOH.ClosedDate.Label" bundle="${oh_labels}"/> ,<fmt:message key="eOH.CreatedAt.Label" bundle="${oh_labels}"/></b></font></td>    

			<%}%>
			</tr>
		</table>
		<table width="100%" cellpadding =0 cellspacing=0 border = '1'>
			<tr>
			<%
				
					/*pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
					pstmt.setString(1,perio_chart);
					rs = pstmt.executeQuery();*/
					//while(rs.next()){
					for(int x=0;x<comp_details.size();x+=3){
						//if(rs.getString("SURFACES_APPL_YN").equals("N") && !rs.getString("COMPONENT_CODE").equals("MITH")){
						if(((String)comp_details.get(x+2)).equals("N") && !((String)comp_details.get(x)).equals("MITH")){
				%>
							<tr>
								<td width="10%" class="label"><font size='1'><%=(String)comp_details.get(x+1)%></font></td>
				<%
								tooth_str_arr = tooth_str.split(",");
								display_tooth_str_arr = display_tooth_str.split(",");
							if(perio_arch.equals("U")){
								for(int j=0;j<tooth_str_arr.length;j++){
									String td_id = (String)comp_details.get(x) + tooth_str_arr[j] ;
				%>
									<td id="<%=td_id%>" width="2%" align='center'>&nbsp;</td>

				<%
								}
				%>
							</tr>
				<%
						
						}else
						{
							for(int j=tooth_str_arr.length-1;j>=0;--j){
									String td_id = (String)comp_details.get(x) + tooth_str_arr[j] ;
							%>
									<td id="<%=td_id%>" width="2%" align='center'>&nbsp;</td>

							<%
								}
							%>
							</tr>
							<%

						}
					}
				}
			%>
			<tr>
				<td width="10%" style="background-color:white" colspan="17">&nbsp;</td> 
			</tr>
			
			<%
					/*pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
					pstmt.setString(1,perio_chart);
					rs = pstmt.executeQuery();*/
					//while(rs.next()){
					for(int x=0;x<comp_details.size();x+=3){
						//if(checkForNull(rs.getString("SURFACES_APPL_YN")).equals("Y")){
						if(((String)comp_details.get(x+2)).equals("Y")){
				%>
							<tr>
								<td width="10%" class="label"><font size='1'><%=((String)comp_details.get(x+1))%></font></td>
				<%
								tooth_str_arr = tooth_str.split(",");
								display_tooth_str_arr = display_tooth_str.split(",");
								if(perio_arch.equals("U")){
									for(int j=0;j<tooth_str_arr.length;j++){
										String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"B";
				%>
										<td id="<%=td_id%>" width="2%" align='center'>&nbsp;</td>
				<%
									}
				%>
									</tr>
				<%
								}else if(perio_arch.equals("L")){
									for(int j=tooth_str_arr.length-1;j>=0;--j){
										String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"B";
				%>
										<td id="<%=td_id%>" width="2%" align='center'>&nbsp;</td>
				<%
									}
				%>
									</tr>
				<%
								}
					
						}
					}
		// added by yadav on 2/17/2010 for 473
		if(!perio_arch.equals("")){
			%>

			<tr>
				<td class="label" width="10%"><B><fmt:message key="eOH.Buccal.Label" bundle="${oh_labels}"/></B></td>
				<%
					// modified by yadav for 473 on 2/17/2010
					int startNo=0,endNo=0;
					String img_src="";
					if(perio_arch.equals("L")){ startNo=32;endNo=17;}
					else if (perio_arch.equals("U")){startNo=1;endNo=16;}
				

					if (perio_arch.equals("U"))
					for(int j=startNo;j<=endNo;j++){
						{ img_src="../../eOH/images/MXB/MXB"+j+".jpg";
											
				%>
						<td id="<%=j%>" width="5%"><img src="<%=img_src%>" ></td>
				<%
						}
					} if(perio_arch.equals("L")){ 
						for(int m=startNo;m>=endNo;m--)
							{
								img_src="../../eOH/images/MDB/MDB"+m+".jpg";
						%>
						<td id="<%=m%>" width="5%"><img src="<%=img_src%>" ></td>
				<% 
					}
					}
				%>
			</tr>
			
			<tr>
				<td width="10%" style="background-color:white" colspan="17">&nbsp;</td>
			</tr>
			<tr>
				<td width="10%" class="columnHeader"><img src="../../eOH/images/spacer.gif" height="10" width="66"></td>
				
				<%
					tooth_str_arr = tooth_str.split(",");
					if(perio_arch.equals("L"))
					{
				
					if(tooth_str_arr.length >1){
						display_tooth_str_arr = display_tooth_str.split(",");
					
						
						for(int j=tooth_str_arr.length-1;j>=0;--j){

					%>
							<td id="<%=tooth_str_arr[j]%>" class="columnHeader"><%=display_tooth_str_arr[j]%></td>
					<%

						}
					}
					else{
						for(int j=1;j<=16;j++){

					%>
							<td id="<%=j%>" class="columnHeader"></td>
					<%

						}
					}	
					
			}else{		
					if(tooth_str_arr.length >1){
						display_tooth_str_arr = display_tooth_str.split(",");
					
						for(int j=0;j<tooth_str_arr.length;j++){

					%>
							<td id="<%=tooth_str_arr[j]%>" class="columnHeader"><%=display_tooth_str_arr[j]%></td>
					<%

						}
					}
					else{
						for(int j=1;j<=16;j++){

					%>
							<td id="<%=j%>" class="columnHeader"></td>
					<%

						}
					}
					}
					%>
			</tr>
			<tr>
				<td width="10%" style="background-color:white" colspan="17">&nbsp;</td>
			</tr>
			<tr>
				<td class="label" width="10%"><B><fmt:message key="eOH.Lingual.Label" bundle="${oh_labels}"/></B></td>
				<%
				
				// modified by yadav for 473 on 2/17/2010
					int startUNo=0,endUNo=0;
					String img_src1="";
					if(perio_arch.equals("L")){ startUNo=32;endUNo=17;}
					else if (perio_arch.equals("U")){startUNo=1;endUNo=16;}
					
					if(perio_arch.equals("U")){
					for(int j=startUNo;j<=endUNo;j++){
						
						img_src1="../../eOH/images/MXL/MXL"+j+".jpg";
						
									
							
				%>
						<td id="<%=j%>" width="5%"><img src="<%=img_src1%>" ></td>
				<%
					}
					}else if(perio_arch.equals("L")){
							for(int k=startUNo;k>=endUNo;k--){
						
						img_src1="../../eOH/images/MDL/MDL"+k+".jpg";
									
							
				%>
						<td id="<%=k%>" width="5%"><img src="<%=img_src1%>" ></td>
							
				<%
					}
					}
				
				%>
			</tr>
			
			<%
					/*pstmt = con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO");
					pstmt.setString(1,perio_chart);
					rs = pstmt.executeQuery();*/
					//while(rs.next()){
					for(int x=0;x<comp_details.size();x+=3){
						if(((String)comp_details.get(x+2)).equals("Y")){
				%>
							<tr>
								<td width="10%" class="label"><font size='1'><%=((String)comp_details.get(x+1))%></font></td>
				<%
								tooth_str_arr = tooth_str.split(",");
								display_tooth_str_arr = display_tooth_str.split(",");
						if(perio_arch.equals("U"))
						{
								for(int j=0;j<tooth_str_arr.length;j++){
									String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"P";
				%>
									<td id="<%=td_id%>" width="2%" align='center'>&nbsp;</td>
				<%
								}
				%>
							</tr>
				<%
						}else
							{
								for(int j=tooth_str_arr.length-1;j>=0;j--){
								String td_id = ((String)comp_details.get(x)) + tooth_str_arr[j] +"P";
								%>
								<td id="<%=td_id%>" width="2%" align='center'>&nbsp;</td>
								<%
									}
								%>
								</tr>
								<%
								
							}
						}
					}
				
			}

			%>
			
		</table>
		<table width="100%" cellpadding =0 cellspacing=0 border = '0'>
		<!-- Added by yadav for CRF-492 on 1/20/2010 -->
			<tr>
			
			<td class='label'  width="25%" colspan="5" nowrap>
				<div  id="disableId" name='disableId' style="display:none;"><%=remarks_title%></div>

				<div  id="enableId" name='enableId' style="display:none;"><font color="blue"><a onclick="showPerioRemarks('<%=remarks_title%>','<%=locale%>')" style="cursor:pointer"><%=remarks_title%></a></font> </div>					
			</td>
					
			<td class='label' width="25%" colspan="5" nowrap>
				<div  id="enableHistId" name='enableHistId' style="display:none;">
						<font color="blue"><a onclick="showPerioRemarksHistory('<%=remarks_history%>','<%=locale%>')" style="cursor:pointer"><%=remarks_history%></a></font></div>
				<div  id="disableHistId" name='disableHistId' style="display:none;">
						<%=remarks_history%></div>									
			</td>
			<!-- end -->
				<!-- <td class='label' colspan='' align="right">

					<a href="javascript:callPerioSummary('<%=chart_num%>','<%=chart_line_num%>','<%=perio_chart%>','<%=perio_arch%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');"><fmt:message key="eOH.PeriodontalSummary.Label" bundle="${oh_labels}"/>
					</a>
				</td> -->

				<td class='label' colspan='' align="right">
					<div  id="disablePerioLink" name='disablePerioLink' style="display:none;"><fmt:message key="eOH.PeriodontalSummary.Label" bundle="${oh_labels}"/></div>
					<div  id="enablePerioLink" name='enablePerioLink' style="display:none;"><font color="blue"><a onclick="callPerioSummary('<%=chart_num%>','<%=chart_line_num%>','<%=perio_chart%>','<%=perio_arch%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>')" style="cursor:pointer"><fmt:message key="eOH.PeriodontalSummary.Label" bundle="${oh_labels}"/></a></font> </div>	
				</td>
				  <td class='label' colspan='' align="right">
					<img  align='center' src='../../eCA/images/graph.gif'>
					<%
					if(perio_chart.equals("")){
					%>
						<fmt:message key="eCA.Viewgraph.label" bundle="${ca_labels}"/> 				
					<%}else{%>
						<a href="javascript:showGraphDialog('<%=chart_num%>','<%=chart_line_num%>','<%=perio_chart%>','<%=perio_arch%>','<%=tooth_numbering_system%>','<%=permanent_deciduous_flag%>');"><fmt:message key="eCA.Viewgraph.label" bundle="${ca_labels}"/></a> 
					<%}%>

				</td> 
			</tr>
		</table>
		<input type = "hidden" name= "params" value = "<%=request.getQueryString()%>">
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
		<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
		<input type = "hidden" name= "perio_chart" value = "<%=perio_chart%>">
		<input type = "hidden" name= "baseline_active_yn" value = "<%=baseline_active_yn%>">
		<input type = "hidden" name= "baseline_closed_yn" value = "<%=baseline_closed_yn%>">
		<input type = "hidden" name= "oh_chart_level" value = "<%=oh_chart_level%>">
		<input type = "hidden" name= "added_date" value = "<%=added_date%>">
		<input type = "hidden" name= "other_chart_facility_id" value = "<%=other_chart_facility_id%>">
		<input type = "hidden" name= "remarks" value = "<%=remarks%>"> 
		<input type = "hidden" name= "facility_name" value = "<%=facility_name%>"> 
		<input type = "hidden" name= "languageId" value = "<%=locale%>"> 
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>"> 
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>"> 
		<input type = "hidden" name= "chart_code" value = "<%=chart_code%>"> 
	</form>
	<script>
		loadSurfaceValues();
	</script>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>


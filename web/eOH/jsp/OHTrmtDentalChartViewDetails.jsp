<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eOH.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %> 
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
String MaxilaFacialDetails = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.MaxilaFacialDetails.Label","OH");
	String oh_bean_id 		= "OHBillingBean";
	String oh_bean_name 	= "eOH.OHBillingBean";
	OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String gingival_recording_by = "";
	String or_interface_flag = "";
	String status = "";
	String link_lab_flag = "";
	
	String disabled = "";
	String billing_appl_yn = "N";
	String params	= request.getQueryString();
	String tooth_numbering_system	= checkForNull(request.getParameter("tooth_numbering_system"));
	String upper_arch_desc			= checkForNull(request.getParameter("upper_arch_desc"));
	String lower_arch_desc			= checkForNull(request.getParameter("lower_arch_desc"));
	String Q1_id					= checkForNull(request.getParameter("Q1_id"));
	String Q2_id					= checkForNull(request.getParameter("Q2_id"));
	String Q3_id					= checkForNull(request.getParameter("Q3_id"));
	String Q4_id					= checkForNull(request.getParameter("Q4_id"));
	String Q1_desc					= checkForNull(request.getParameter("Q1_desc"));
	String Q2_desc					= checkForNull(request.getParameter("Q2_desc"));
	String Q3_desc					= checkForNull(request.getParameter("Q3_desc"));
	String Q4_desc					= checkForNull(request.getParameter("Q4_desc"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String mixed_dentition_YN        = checkForNull(request.getParameter("mixed_dentition_YN"));
	String date_diff_flag        = checkForNull(request.getParameter("date_diff_flag"));

	String otFlag=checkForNull(request.getParameter("called_from"));
	String called_from=checkForNull(request.getParameter("called_from"));
	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String encounter_id = checkForNull(request.getParameter( "encounter_id" )) ;
	String facility_id = (String)session.getValue("facility_id") ;
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;
	String patient_class = checkForNull(request.getParameter("patient_class"));
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String chart_type = checkForNull(request.getParameter( "chart_type" )) ;
	String header_tab = checkForNull(request.getParameter( "header_tab" )) ;
	String location_type = checkForNull(request.getParameter( "location_type" )) ;
	String location_code = checkForNull(request.getParameter( "location_code" )) ;

	String option_id = checkForNull(request.getParameter("option_id"));
	String sex = checkForNull(request.getParameter("Sex"));
	String dob = checkForNull(request.getParameter("Dob"));
	String bed_num = checkForNull(request.getParameter("bed_num"));
	String room_num = checkForNull(request.getParameter("room_num"));
	String visit_adm_date = checkForNull(request.getParameter("visit_adm_date"));

	//String visit_id = checkForNull(request.getParameter( "visit_id" )) ;
	String source_code = checkForNull(request.getParameter( "location_code" )) ;
	String source_type = checkForNull(request.getParameter( "location_type" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" ));
	if(date_diff_flag.equals("disable")){
		disabled = "disabled";
	}

	boolean billing_installed = oh_bean.isBillingInstalled(facility_id);

	if(billing_installed == true){
		billing_appl_yn = "Y";
	}
	else{
		billing_appl_yn = "N";
	}


	String record_gingival_status_yn_param = checkForNull(request.getParameter( "record_gingival_status_yn_param" )) ;
	// Added by Sharon Crasta on 3/14/2009  for other facility chart CRF#0423
	String other_facilitychart_yn = checkForNull(request.getParameter( "other_facilitychart_yn" )) ;
	String other_chart_facility_id = checkForNull(request.getParameter( "other_chart_facility_id" )) ;
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" ));

	//Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782
	String dflt_mixed_dentition_chart = checkForNull(request.getParameter( "dflt_mixed_dentition_chart" )) ;
	//
	//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
	String dentist_comments = checkForNull(request.getParameter( "dentist_comments" )) ;
	//
	try{
	con = ConnectionManager.getConnection(request);
	// Added by Sharon Crasta on 3/14/2009  for other facility chart CRF#0423
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
	}

	//
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	/*
	pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY,OR_INTERFACE_FLAG FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
	pstmt.setString(1,facility_id);
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		or_interface_flag = checkForNull(rs.getString("OR_INTERFACE_FLAG"));
	}
	*/

	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	if(oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY FROM OH_PARAM");
	}else{//End
		pstmt = con.prepareStatement("SELECT GINGIVAL_RECORDING_BY FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
		pstmt.setString(1,facility_id);
	}
	rs = pstmt.executeQuery();
	while (rs != null && rs.next()){
		gingival_recording_by = checkForNull(rs.getString("GINGIVAL_RECORDING_BY"));
		//or_interface_flag = checkForNull(rs.getString("OR_INTERFACE_FLAG"));
	}

	//written by parul on 160908
	pstmt = con.prepareStatement("SELECT CHART_STATUS FROM OH_RESTORATIVE_CHART_HDR WHERE OPERATING_FACILITY_ID=? AND  PATIENT_ID=?  AND CHART_STATUS='A' ");
	pstmt.setString(1,facility_id);
	pstmt.setString(2,patient_id);
	rs=pstmt.executeQuery();
	while(rs!=null && rs.next()){
			status = checkForNull(rs.getString("CHART_STATUS"));
		}

		  if(status.equals("A")){
			  if (baseline_chart_yn.equals("Y")){
			   link_lab_flag="N";
		     }else{
			  link_lab_flag="Y";
		   }
	   }  
		//
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eOH/js/OHTrmtDentalChartViewDetails.js'></script>
		<script language='javascript' src='../../eOH/js/RecordDiagForTrmt.js'></script>
		<script language='javascript' src='../../eOH/js/OHCommon.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
		<script>
			async function showMaxilaFacialDtl()
				{
					var patient_id = document.forms[0].patient_id.value
					var chart_num = document.forms[0].cur_chart_num.value
					var header_tab = document.forms[0].header_tab.value
					var oh_chart_level = document.forms[0].oh_chart_level.value
				//	var chart_line_num = document.forms[0].chart_line_num.value
				//	alert(patient_id+" "+chart_num+" "+chart_line_num)
				//	title = encodeURIComponent(title);
					
					var retVal = await window.showModalDialog("../../eOH/jsp/MaxilaFacialDetails.jsp?heading=<%=MaxilaFacialDetails%>&patient_id="+patient_id+"&chart_num="+chart_num+"&header_tab="+header_tab+"&oh_chart_level="+oh_chart_level,window,"dialogHeight: 55vh; dialogWidth:75vw; center: yes; help: no; resizable: no; status: no;");
					
				}
		</script>
	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" > 
	<!--Added by Yadav on 10/9/2009 for CRF 707-->
 <script language='javascript' src='../../eOH/js/wz_tooltip.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	<!--end-->
		<form name="trmtViewDetailsForm" id="trmtViewDetailsForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
			
				<tr>
					<td valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1" >
						<tr>
						<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->
							<td><table width="100%" border="0" onMouseOver= 'hideToolTip();'>
								<tr>
									<th align="left"><fmt:message key='eOH.TreatmentsToDo.Label' bundle='${oh_labels}'/></th>
									<!--<th align="right" width="10%"><img name="T_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menu1',this);" <%=disabled%>/></th>-->
									<th align="right" width="10%"><img name="T_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menu1',this);"/></th>
								</tr>
							</table></td>
						</tr>
						<tr>
							<div id="menuExpand2 style='visibility:hidden;display:none'">
								<td id="menu1" style='display:none'>
								</td>
							</div>
						</tr>
						<!-- <tr>
							<div id="menuTasks1 style='visibility:hidden;display:none'">
								<td id="trmt1" style='display:none'>
								</td>
							</div>
						</tr> -->
						<tr>
							<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->
							<td><table width="100%" border="0"  onMouseOver= 'hideToolTip();'>
								<tr>
									<th align="left"><fmt:message key='eOH.TreatmentsDone.Label' bundle='${oh_labels}'/></th>
									<!--<th align="right" width="10%"><img name="T_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menu5',this);" <%=disabled%>/></th>-->
									<th align="right" width="10%"><img name="T_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menu5',this);"/></th>
								</tr>
							</table></td>
						</tr>


						<div id="menuExpand3 style='visibility:hidden;display:none'">
							<td id="menu5" style='display:none'>
							</td>
						</div>
                    </tr>
					 <%
						  //if (permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("N")){
					  %> 
					<tr>
						<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->			<td><table width="100%" border="0"  onMouseOver= 'hideToolTip();'>
								<tr>
									<th align="left" >
									<fmt:message key="Common.Summary.label" bundle="${common_labels}"/></th>
									<th align="right" width="10%"><img name="GS_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuSummary',this);" /></th>
								</tr>
							</table></td>
						</tr>
						 <%
							//}
						%> 
						<tr>
						<div id="menuExpand1 style='visibility:hidden;display:none'">
							<td id="menuSummary" style='display:none'>
							</td>
						</div>
						</tr>
						<tr>
						<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->		<td><table width="100%" border="0" onMouseOver= 'hideToolTip();' >
								<tr>
									<th align="left"><fmt:message key='eOH.BaselineCharts.Label' bundle='${oh_labels}'/></th>
									<!--<th align="right" width="10%"><img name="T_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuBC',this);" <%=disabled%>/></th>-->
									<th align="right" width="10%"><img name="T_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuBC',this);"/></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand4 style='visibility:hidden;display:none'">
							<td id="menuBC" style='display:none'>
							</td>
						</div>
						</tr>
						<!-- added by parul for Enterprise Specific Chart Applicable -->
						<%
                             if (oh_chart_level.equals("F")){							
						%>
								<tr>
						<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->			<td><table width="100%" border="0"  onMouseOver= 'hideToolTip();'>
										<tr>
											<th align="left"><fmt:message key='eOH.OtherFacilityCharts.Label' bundle='${oh_labels}'/></th>
											<th align="right" width="10%"><img name="FC_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuFC',this);" /></th>
										</tr>
									</table></td>
								</tr>
						<%
							}
						%>
								<tr>
								<div id="menuExpand5 style='visibility:hidden;display:none'">
									<td id="menuFC" style='display:none'>
									</td>
								</div>
								</tr>
						<% if(!called_from.equals("OT")){%>
						<tr>
						<!-- Added onMouseOver by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->			<td><table width="100%" border="0"  onMouseOver= 'hideToolTip();'>
								<tr>
									<th align="left"><fmt:message key='eOH.OtherLinks.Label' bundle='${oh_labels}'/></th>
									<!--<th align="right"  width="10%"><img name="OL_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuOL',this);" <%=disabled%>/></th>-->
									<th align="right"  width="10%"><img name="OL_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuOL',this);"/></th>
								</tr>
							</table></td>
						</tr>
						<tr>
						<div id="menuExpand6 style='visibility:hidden;display:none'">
							<td id="menuOL" style='display:none'>
							</td>
						</div>
						</tr>
						<% } %>
						<%
							//if(or_interface_flag.equals("Y")){
						%>
						<!-- <tr>
							<td><table width="100%" border="0" >
								<tr>
									<th align="left"><fmt:message key='eOH.LabRadiology.Label' bundle='${oh_labels}'/></th>
									<th align="right"  width="10%"><img name="OL_arrow" src="../../eOH/images/arrow-down.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuLBRD',this);" <%=disabled%>/></th>
								</tr>
							</table></td>
						</tr> -->
						<%
						 // }
						%>
						<tr>
						<div id="menuExpand6 style='visibility:hidden;display:none'">
							<td id="menuLBRD" style='display:none'>
							</td>
						</div>
						</tr>

					</table></td>
				</tr>
            </table>


			<input type = "hidden" name= "params" value = "<%=params%>">
			<input type = "hidden" name= "locale" value = "<%=locale%>">
			<input type = "hidden" name= "tooth_numbering_system" value = "<%=tooth_numbering_system%>">
			<input type = "hidden" name= "permanent_deciduous_flag" value = "<%=permanent_deciduous_flag%>">
			<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
			<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
			<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
			<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
			<input type = "hidden" name= "location_code" value = "<%=location_code%>">
			<input type = "hidden" name= "location_type" value = "<%=location_type%>">
			<input type = "hidden" name= "episode_id" value = '<%=checkForNull(request.getParameter("episode_id"))%>'>
			<input type = "hidden" name= "episode_type" value = '<%=checkForNull(request.getParameter("episode_type"))%>'>
			<input type = "hidden" name= "visit_id" value = '<%=checkForNull(request.getParameter("visit_id"))%>'> 
			<input type = "hidden" name= "practitioner_id" value = '<%=ca_practitioner_id%>'>

			<input type = "hidden" name= "source_code" value = "<%=source_code%>">
			<input type = "hidden" name= "source_type" value = "<%=source_type%>">
			<input type = "hidden" name= "baseline_chart_yn" value = "<%=baseline_chart_yn%>">

			<input type = "hidden" name= "upper_arch_desc" value = "<%=upper_arch_desc%>">
			<input type = "hidden" name= "lower_arch_desc" value = "<%=lower_arch_desc%>">
			<input type = "hidden" name= "Q1_id" value = "<%=Q1_id%>">
			<input type = "hidden" name= "Q2_id" value = "<%=Q2_id%>">
			<input type = "hidden" name= "Q3_id" value = "<%=Q3_id%>">
			<input type = "hidden" name= "Q4_id" value = "<%=Q4_id%>">
			<input type = "hidden" name= "Q1_desc" value = "<%=Q1_desc%>">
			<input type = "hidden" name= "Q2_desc" value = "<%=Q2_desc%>">
			<input type = "hidden" name= "Q3_desc" value = "<%=Q3_desc%>">
			<input type = "hidden" name= "Q4_desc" value = "<%=Q4_desc%>">
			<input type = "hidden" name= 'mixed_dentition_YN' value=<%=mixed_dentition_YN%> >
			<input type = "hidden" name= 'chart_type' value=<%=chart_type%> >
			<input type = "hidden" name= 'header_tab' value=<%=header_tab%> >
			<input type = "hidden" name= 'chart_num' value='<%=checkForNull(request.getParameter("new_chart_num"))%>' >
			<!--  Commented and Added by Sharon Crasta on 3/18/2009 for other facility chart CRF#0423 -->
			<input type = "hidden" name= 'cur_chart_num' value='<%=checkForNull(request.getParameter("chart_num"))%>' >
			<!--input type = "hidden" name= 'cur_chart_num' value='<%=checkForNull(request.getParameter("cur_chart_num"))%>' >-->
			<!-- -->
			<input type = "hidden" name= 'remarks' value='' >
			<input type="hidden" name="speciality_code" id="speciality_code" value='<%=speciality_code%>' >
			<input type="hidden" name="gingival_recording_by" id="gingival_recording_by" value='<%=gingival_recording_by%>' >
			<input type="hidden" name="record_gingival_status_yn_param" id="record_gingival_status_yn_param" value='<%=record_gingival_status_yn_param%>' >
			 

			<input type = "hidden" name= 'billing_appl_yn' value='<%=billing_appl_yn%>' >
			<input type = "hidden" name= 'or_interface_flag' value='<%=or_interface_flag%>' >
			<input type = "hidden" name= 'link_lab_flag' value="<%=link_lab_flag%>" >
			<!--  Added by Sharon Crasta on 3/14/2009 for other facility chart CRF#0423 -->
            <input type="hidden" name="other_facilitychart_yn" id="other_facilitychart_yn" value='<%=other_facilitychart_yn%>' >
            <input type="hidden" name="other_chart_facility_id" id="other_chart_facility_id" value='<%=other_chart_facility_id%>' >
            <input type="hidden" name="oh_chart_level" id="oh_chart_level" value='<%=oh_chart_level%>' >
			<input type="hidden" name="ord_id0" id="ord_id0" value = '<%=checkForNull(request.getParameter( "order_id" ))%>'>
			<input type = "hidden" name= "order_id" value = '<%=checkForNull(request.getParameter( "order_id" ))%>'>
			<!--Added by Sharon Crasta on 7/6/2009 for IN011768 and IN011782-->
			<input type="hidden" name="dflt_mixed_dentition_chart" id="dflt_mixed_dentition_chart" value="<%=dflt_mixed_dentition_chart%>">

			<input type="hidden" name="dentist_comments" id="dentist_comments" value="<%=dentist_comments%>">
			<input type="hidden" name="otFlag" id="otFlag" value="<%=otFlag%>" >
			<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>" >

			<!-- -->
			<!--Added by Sharon Crasta on 1/20/2010 for SRR20056-CRF-0485(IN010920) -->
			<input type="hidden" name="date_diff_flag" id="date_diff_flag" value="<%=date_diff_flag%>" >
			<!-- -->

			<!-- Parameters for Diagnosis function -->
			<input type = "hidden" name= 'option_id' value='<%=option_id%>' >
			<input type="hidden" name="sex" id="sex" value='<%=sex%>' >
			<input type="hidden" name="dob" id="dob" value='<%=dob%>' >
			<input type="hidden" name="bed_num" id="bed_num" value='<%=bed_num%>' >
			<input type="hidden" name="room_num" id="room_num" value='<%=room_num%>' >
			<input type="hidden" name="visit_adm_date" id="visit_adm_date" value='<%=visit_adm_date%>' >
		</form>

<!-- Added by Sharon Crasta on 1/21/2010 for SRR20056-CRF-0485(IN010920)-->
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue' >
	<table id='tooltiptable' cellpadding="3" cellspacing=0 border='0' width='100%' align='center' >
		<tr id='tooltiprow'>
			<td width='100%' id='menu_table'></td>
			</td>
		</tr>
	</table>
</div> 
<!--End -->

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


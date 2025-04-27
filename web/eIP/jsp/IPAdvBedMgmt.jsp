<!DOCTYPE html>
<!DOCTYPE>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIP.advbedmgmt.transaction.patientsearch.PatientSearchConstants"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*"%>

<%
	/* String sStyle = checkForNull(
			(String) session.getAttribute("PREFERRED_STYLE"),
			"IeStyle.css"); */
	String nursingUnit = request.getParameter("nursingUnit") == null ? ""
			: request.getParameter("nursingUnit");
	// there is a need for the selected nursing unit description as well
	// this needs to be passed to inner page - ipadvbedmgmttooltip.jsp
	String nursingUnitDesc = request.getParameter("nursingUnitDesc");
	if(nursingUnitDesc == null){
		nursingUnitDesc = "";
	}
	String room = request.getParameter("room") == null ? "" : request
			.getParameter("room");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList floorRoomBedList = new ArrayList();
	String facility_id = (String) session.getAttribute("facility_id");
	String user_id = (String) session.getAttribute("login_user");
	
	// code added to get extra request parameters - these are required for
	// patient search related functionality
	String patSrchYN = request.getParameter(PatientSearchConstants.PATIENT_SRCH_REQUEST_PARAM_KEY);
	patSrchYN = CommonBean.checkForNull(patSrchYN);		
	String patSrchPatientId = request.getParameter(PatientSearchConstants.PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY);
	patSrchPatientId = CommonBean.checkForNull(patSrchPatientId);
	String roomNumInSrch = request.getParameter(PatientSearchConstants.PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY);
	roomNumInSrch = CommonBean.checkForNull(roomNumInSrch);
	String bedNumInSrch = request.getParameter(PatientSearchConstants.PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY);
	bedNumInSrch = CommonBean.checkForNull(bedNumInSrch);
		
	String patSrchHighlightStyle = "";
	
%>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="../../eIP/html/JQuery/ToolTip/jquery.cluetip.css" />
<link type="text/css" rel="stylesheet"
	href="../../eIP/html/IPAdvBedMgmtStyle.css" />
<link type="text/css" rel="stylesheet"
	href="../../eIP/html/PopupStyle.css" />
<script type="text/javascript"
	src="../../eIP/html/JQuery/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="../../eIP/html/JQuery/ToolTip/jquery.hoverIntent.js"></script>
<script type="text/javascript"
	src="../../eIP/html/JQuery/ToolTip/jquery.cluetip.js"></script>
<script src="../../eIP/js/IPAdvBedMgmtTrns.js" language="JavaScript"></script>
<script src='../../eIP/js/IPAdvBedMgmtSupplementary.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script type="text/javascript">
			//var isBedBubbleShown = false;
			
			//var refreshInAction = false;

			$(document).ready(function() {
				$('a.jt').cluetip({
					cluetipClass: 'jtip',
					width:676,
					height:8vh9,
					topOffset:'0',
					leftOffset:'0',
					activation:'click',
					positionBy:'auto',
					tracking:false,
					arrows: true,
					dropShadow: false,
					sticky: true,
					mouseOutClose: false,
					onActivate : openBedBubble,
					onHide : afterBedBubbleHide,
					closePosition: 'title',
					closeText: '<img id="tooltipClose" src="../../eIP/html/JQuery/ToolTip/cross.png" alt="close" />'
				});
				$('.assignedBed').mouseover(function(){
					var bedId=$(this).attr('id');
					//alert($(this).attr('id'))
					//alert($("#"+bedId+'Enc').val())
					$('#bedSelectId').val($(this).attr('id'));
					$('#encSelectId').val($("#"+bedId+'Enc').val());
					//alert($(this).attr('id'))
					//$('#log').append('<div>Handler for .mouseover() called.</div>');
					//bedOverId
				});
				$('#floorWrapper').width(document.documentElement.clientWidth)
				$('#floorWrapper').height(document.documentElement.clientHeight)
			});
			window.onresize=function(){
				$('#floorWrapper').width(document.documentElement.clientWidth);
			};
			
			/* function openBedBubble(bedNumber,nursingUnit,patientClass,encounterId,operStnId,
					transAllowed,knownAllergyYN,overdueCnt,dueCount,abnormalResultCnt,
					nursingUnitDesc,roomNumber,roomName){
				// this function launches the bed bubble
				alert('bed bubble');
			} */
			
			function openBedBubble(){
				// this function launches the bed bubble
				//alert('bed bubble');
				//$('a.jt').trigger('showCluetip');
				isBedBubbleShown = true;
			}
			
			function afterBedBubbleHide(){
				isBedBubbleShown = false;
			}
			
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style type="text/css">

/* .bedhighlightinnerdiv{
	display: block;
	border-left: 2px solid #004eff;
	border-right: 2px solid #004eff;
} */

</style>
		
</head>
<%
	HashMap floorLayoutmap = new HashMap();
	String floorWidth = "0";
	String floorHeight = "0";
	String locale = (String) session.getAttribute("LOCALE");
	long beforeAllTime = System.currentTimeMillis();
	long afterConnTime = 0;
	long afterHugeQueryTime = 0;
	long afterAllQueryTime = 0;
	long beforeDataProcTime = 0;
	long afterDataProcTime = 0;
	Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
	String logMessage = null;
	try {
		con = ConnectionManager.getConnection(request);
		afterConnTime = System.currentTimeMillis();
		//session.setAttribute("bl_operational", "N");
		//session.setAttribute("bl_install_yn", "N");
		String bl_operational = checkForNull(
				(String) session.getAttribute("bl_operational"), "N");
		// to get all rooms of nursing unit starts
		stmt = con.createStatement();
		floorRoomBedList = eIP.IPAdvBedMgmtBean
				.getNursingUnitRoomBedTrnsData(con, stmt, rs,
						nursingUnit, facility_id, locale, user_id,
						bl_operational);
		afterHugeQueryTime = System.currentTimeMillis();
		// to get all rooms of nursing unit ends
		floorLayoutmap = eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,
				facility_id, nursingUnit);
		floorWidth = (String) floorLayoutmap.get("floor_width");
		floorHeight = (String) floorLayoutmap.get("floor_height");
		String appl_patient_class = (String) floorLayoutmap
				.get("appl_patient_class");
		HashMap paramOprStnMap = eIP.IPAdvBedMgmtBean
				.getParamOprStnData(con, pstmt, rs, facility_id,
						user_id);
		afterAllQueryTime = System.currentTimeMillis();
		
		
		if(loggerInst != null){
			logMessage = "Nursing unit="+nursingUnit+";beforeAllTime="+beforeAllTime+",afterConnTime="+afterConnTime+",afterHugeQueryTime="+afterHugeQueryTime+",afterAllQueryTime="+afterAllQueryTime;
			loggerInst.debug(logMessage);
		}
		System.out.println("beforeAllTime="+beforeAllTime+",afterConnTime="+afterConnTime+",afterHugeQueryTime="+afterHugeQueryTime+",afterAllQueryTime="+afterAllQueryTime);
		
		String operStnId = (String) paramOprStnMap.get("oper_stn_id");
		String setup_bl_dtls_in_ip_yn = (String) paramOprStnMap
				.get("setup_bl_dtls_in_ip_yn");
		String bl_interfaced_yn = (String) paramOprStnMap
				.get("bl_interfaced_yn");
		String allow_discharge_date = (String) paramOprStnMap
				.get("allow_discharge_date");
		String chk_for_pen_orders_bfr_dis_adv = checkForNull(
				(String) paramOprStnMap
						.get("chk_for_pen_orders_bfr_dis_adv"),
				"N");
		String dis_adv_allow_yn = checkForNull(
				(String) paramOprStnMap.get("dis_adv_allow_yn"), "N");
		String chk_for_pen_orders_bfr_dis = checkForNull(
				(String) paramOprStnMap
						.get("chk_for_pen_orders_bfr_dis"),
				"N");
		String dis_allow_yn = checkForNull(
				(String) paramOprStnMap.get("dis_allow_yn"), "N");
		String max_disch_period_for_dc = (String) paramOprStnMap
				.get("max_disch_period_for_dc");
		String mother_cut_off_age = (String) paramOprStnMap
				.get("mother_cut_off_age");
		String mother_max_age = (String) paramOprStnMap
				.get("mother_max_age");
		String pat_check_in_allowed_yn = (String) paramOprStnMap
				.get("pat_check_in_allowed_yn");

		String disch_reason_mand_yn = (String) paramOprStnMap
				.get("disch_reason_mand_yn");
		String allow_late_discharge_reason = (String) paramOprStnMap
				.get("allow_late_discharge_reason");
		String deactivate_pseudo_bed_yn = (String) paramOprStnMap
				.get("deactivate_pseudo_bed_yn");
		String diag_update_period_max_unit = (String) paramOprStnMap
				.get("diag_update_period_max_unit");
		String dis_date_chk_days_unit = (String) paramOprStnMap
				.get("dis_date_chk_days_unit");
		String dis_date_chk_days = (String) paramOprStnMap
				.get("dis_date_chk_days");
		String bed_block_period_dis = (String) paramOprStnMap
				.get("bed_block_period_dis");
		String discharge_checklist_app_yn = (String) paramOprStnMap
				.get("discharge_checklist_app_yn");
		String refresh_interval = (String) paramOprStnMap
				.get("refresh_interval");
		// this will be set with the room number value obtained from the bean
		String roomNumber = "";
%>
<!--Below code was modified on 08-JAN-2013 against [IN037130] -->
<body onKeyDown="lockKey()">
	<form name='bedLayOutMgmt' id='bedLayOutMgmt' method='post'>
		<div id="floorWrapper" class='floorWrapper'>
			<div class="floor" id="floor"
				style="width:<%=floorWidth%>px; height:<%=floorHeight%>px;">
				<%
					if (floorRoomBedList.size() > 0) {
							beforeDataProcTime = System.currentTimeMillis();
							Iterator iterator = floorRoomBedList.iterator();
							int roomCounter = 0;
							while (iterator.hasNext()) {
								HashMap tempMap = (HashMap) iterator.next();
								roomNumber = (String) tempMap.get("roomNo");
								String roomName = (String) tempMap.get("roomName");
								String room_clr = (String) tempMap.get("room_clr");
								String roomTopPos = (String) tempMap.get("roomTopPos");
								String roomLeftPos = (String) tempMap
										.get("roomLeftPos");
								String roomWidth = (String) tempMap.get("roomWidth");
								String roomHeight = (String) tempMap.get("roomHeight");
								ArrayList roomBedsList = (ArrayList) tempMap
										.get("roomBedsList");
								int roomHeight1 = Integer.parseInt(roomHeight) - 20;
				%>
				<div id="<%=roomNumber %>" class="room"
					style="top:<%=roomTopPos%>px; left:<%=roomLeftPos%>px;width:<%=roomWidth%>px; height:<%=roomHeight%>px;background:<%=room_clr%>">
					<div class='roomheader'>
						<!--<table width='100%'><tr><th>--><%=roomName%><!--</th></tr></table>-->
					</div>
					<div class='roombody' style="height:<%=roomHeight1%>px;">
						<%
							if (roomBedsList != null && roomBedsList.size() > 0) {
											Iterator bedItr = roomBedsList.iterator();
											while (bedItr.hasNext()) {
												HashMap roomBedsMap = (HashMap) bedItr.next();
												//System.out.println("roomBedsMap:"+roomBedsMap.toString());
												String bedNo = (String) roomBedsMap
														.get("bedNo");
												String bedClock = (String) roomBedsMap
														.get("bedClock");
												String bedColorExt = (String) roomBedsMap
														.get("bedColorExt");
												String disc_bill_exists = (String) roomBedsMap
														.get("disc_bill_exists");
												String bedTopPos = (String) roomBedsMap
														.get("bedTopPos");
												String bedLeftPos = (String) roomBedsMap
														.get("bedLeftPos");
												String bedWidth = (String) roomBedsMap
														.get("bedWidth");
												String bedHeight = (String) roomBedsMap
														.get("bedHeight");
												String bedColor = (String) (roomBedsMap
														.get("bedColor") == null ? ""
														: roomBedsMap.get("bedColor"));
												//String bookingType = (String)(roomBedsMap.get("bookingType")==null?"":roomBedsMap.get("bookingType"));
												String bedStatus = (String) (roomBedsMap
														.get("bedStatus") == null ? ""
														: roomBedsMap.get("bedStatus"));
												String bedTextColor = (String) (roomBedsMap
														.get("bedTextColor") == null ? "white"
														: roomBedsMap.get("bedTextColor"));
												String trnsAllowed = (String) (roomBedsMap
														.get("trnsAllowed") == null ? "Y"
														: roomBedsMap.get("trnsAllowed"));
												String gender = (String) (roomBedsMap
														.get("gender") == null ? ""
														: roomBedsMap.get("gender"));
												//System.out.println("bedNo @jsp:"+bedNo);
												//System.out.println("bedClock @jsp:"+bedClock);
												//System.out.println("bedColor @jsp:"+bedColor);
												//System.out.println("bedColorExt @jsp:"+bedColorExt);
												if (bedColorExt.equals("")) {
													bedColorExt = bedColor;
												}
												if (gender.equals("M")) {
													gender = MessageManager.getLabel(locale,
															"Common.male.label", "Common");
												} else if (gender.equals("F")) {
													gender = MessageManager.getLabel(locale,
															"Common.female.label", "Common");
												} else if (gender.equals("U")) {
													gender = MessageManager.getLabel(locale,
															"Common.unknown.label", "Common");
												}
												String pat_age = (String) (roomBedsMap
														.get("pat_age") == null ? ""
														: roomBedsMap.get("pat_age"));
												String patient_id = (String) (roomBedsMap
														.get("patient_id") == null ? ""
														: roomBedsMap.get("patient_id"));
												String patient_name = (String) (roomBedsMap
														.get("patient_name") == null ? ""
														: roomBedsMap.get("patient_name"));
												String KNOWN_ALLERGY_YN = (String) (roomBedsMap
														.get("KNOWN_ALLERGY_YN") == null ? ""
														: roomBedsMap.get("KNOWN_ALLERGY_YN"));
												String overdue_count = (String) (roomBedsMap
														.get("overdue_count"));
												String overdue_time = (String) (roomBedsMap
														.get("overdue_time"));
												String due_count = (String) (roomBedsMap
														.get("due_count"));
												String due_time = (String) (roomBedsMap
														.get("due_time"));
												int abnormal_rslt_count = ((Integer) roomBedsMap
														.get("abnormal_rslt_count")).intValue();
												
												int ost_orders_count=Integer.parseInt((String)(roomBedsMap.get("ost_orders_count")==null?"0":roomBedsMap.get("ost_orders_count")));
												
												//int abnormal_rslt_count=(Integer)roomBedsMap.get("abnormal_rslt_count");
												//System.out.println("AA:"+(Integer)roomBedsMap.get("abnormal_rslt_count"));
												//overdue_count="1";
												//due_count="1";
												//abnormal_rslt_count=1; 
												String practitioner_name = (String) (roomBedsMap
														.get("practitioner_name") == null ? ""
														: roomBedsMap.get("practitioner_name"));
												String admission_date_time = (String) (roomBedsMap
														.get("admission_date_time") == null ? ""
														: roomBedsMap
																.get("admission_date_time"));
												String exp_discharge_date_time = (String) (roomBedsMap
														.get("exp_discharge_date_time") == null ? ""
														: roomBedsMap
																.get("exp_discharge_date_time"));
												String encounter_id = (String) (roomBedsMap
														.get("encounter_id") == null ? ""
														: roomBedsMap.get("encounter_id"));
												String bed_class_short_desc = (String) (roomBedsMap
														.get("bed_class_short_desc") == null ? ""
														: roomBedsMap
																.get("bed_class_short_desc"));
												String bed_type_short_desc = (String) (roomBedsMap
														.get("bed_type_short_desc") == null ? ""
														: roomBedsMap
																.get("bed_type_short_desc"));
												//System.out.println("Data @"+bedNo+":overdue_count:"+overdue_count+":overdue_time:"+overdue_time+":due_count:"+due_count+":due_time:"+due_time+":");
												if (/*(bookingType.equals("T")||bookingType.equals("N")||bookingType.equals("L")||bookingType.equals("B")) &&*/bedStatus
														.equals("B")
														&& (!encounter_id.equals(""))) {
													encounter_id = "";
												}
												
												// code added to high light the bed
												// var to hold the style applied to the bed
												String bedStyle = "top:"+bedTopPos+"px; left:"+bedLeftPos+"px;width:"+bedWidth+"px; height:"+bedHeight+"px;background-color:"+bedColor+";";
												// this is the width and the height that will be set to the 
												// inner div
												String innerDivWidthStr = bedWidth;
												int innerDivWidth = 0;
												try{
													innerDivWidth = Integer.parseInt(innerDivWidthStr);
													innerDivWidth -= 4;
													innerDivWidthStr = innerDivWidth+"";
												}catch(NumberFormatException nex){
													// nothing much can be done
												}
												
												String innerDivHeightStr = bedHeight;
												int innerDivHeight = 0;
												try{
													innerDivHeight = Integer.parseInt(innerDivHeightStr);
													innerDivHeight -= (2*5);
													innerDivHeightStr = innerDivHeight+"";
												}catch(NumberFormatException nex){
													// nothing much can be done
												}
												
												
												String innerDivStyle = "bedinnerdiv";
												String bedStyleClass = "bedWOHighlight";
												String bedToponeClass = "bedtopone";
												String bedToptwoClass = "bedtoptwo";
												String bedTopthreeClass = "bedtopthree";
												String bedTopfourClass = "bedtopfour";
												String bedTopfiveClass = "bedtopfive";
												String bedBottomoneClass = "bedbottomone";
												String bedBottomtwoClass = "bedbottomtwo";
												String bedBottomthreeClass = "bedbottomthree";
												String bedBottomfourClass = "bedbottomfour";
												String bedBottomfiveClass = "bedbottomfive";
												
												boolean highlightNeeded = false;
												// check if patient search parameters are set
												// this implies user has searched for a patient
												// in this case the bed should be highlighted
												if(PatientSearchConstants.PATIENT_SRCH_REQUEST_VALUE.equalsIgnoreCase(patSrchYN) 
																				&& patSrchPatientId.equals(patient_id)){
													highlightNeeded = true;
													//bedStyle += "border:2px #0000DD solid";
													bedStyleClass = "bedWithHighlight";
													
													innerDivStyle = "bedhighlightinnerdiv";
													bedToponeClass = "bedhighlighttopone";
													bedToptwoClass = "bedhighlighttoptwo";
													bedTopthreeClass = "bedhighlighttopthree";
													bedTopfourClass = "bedhighlighttopfour";
													bedTopfiveClass = "bedhighlighttopfive";
													bedBottomoneClass = "bedhighlightbottomone";
													bedBottomtwoClass = "bedhighlightbottomtwo";
													bedBottomthreeClass = "bedhighlightbottomthree";
													bedBottomfourClass = "bedhighlightbottomfour";
													bedBottomfiveClass = "bedhighlightbottomfive";
													
													// code added to set the room num and the bed num values
													// used in patient search functionality
													// this is needed to reset the old selected beds
													if("".equals(roomNumInSrch.trim())){
														roomNumInSrch = roomNumber;
													}
													
													if("".equals(bedNumInSrch.trim())){
														bedNumInSrch = bedNo;
													}
												}
												
												
												
												
						%>
						<div id="<%=roomNumber %><%=bedNo%>" class="<%=bedStyleClass %>"
							style="<%=bedStyle%>">
							<a class="jt"
								rel="../../eIP/jsp/IPAdvBedMgmtToolTip.jsp?bed_no=<%=bedNo%>&nursing_unit=<%=nursingUnit%>&appl_patient_class=<%=appl_patient_class%>&encounter_id=<%=encounter_id%>&operStnId=<%=operStnId%>&trnsAllowed=<%=trnsAllowed%>&KNOWN_ALLERGY_YN=<%=KNOWN_ALLERGY_YN%>&overdue_count=<%=overdue_count%>&due_count=<%=due_count%>&abnormal_rslt_count=<%=abnormal_rslt_count%>&nursing_unit_desc=<%=nursingUnitDesc %>&room_number=<%=roomNumber %>&room_name=<%=roomName %>"\
								title="Manage Bed">
								 <b class="bedtop"
								style='background:<%=room_clr%>'>
									<b id="btopfirst_<%=roomNumber %><%=bedNo%>" class="<%=bedToponeClass%>" style='background:<%=bedColor%>;'></b> 
									<b id="btopsecond_<%=roomNumber %><%=bedNo%>" class="<%=bedToptwoClass%>" style='background:<%=bedColor%>;'></b> 
									<b id="btopthird_<%=roomNumber %><%=bedNo%>" class="<%=bedTopthreeClass%>" style=' background:<%=bedColor%>;'></b>
									<b id="btopfour_<%=roomNumber %><%=bedNo%>" class="<%=bedTopfourClass%>" style=' background:<%=bedColor%>;'></b>
									<b id="btoplast_<%=roomNumber %><%=bedNo%>" class="<%=bedTopfiveClass%>"	style='background:<%=bedColor%>;'></b>
								</b>
								
								<div id="innerDiv_<%=roomNumber %><%=bedNo%>" class="<%=innerDivStyle%>"  style='width:<%=innerDivWidthStr %>px; height:<%=innerDivHeightStr %>px;' >
								
							<div class='bedheader' style='color:<%=bedTextColor%>'><%=bedNo%></div>
							<div class='bedbody' style='color:<%=bedTextColor%>'>
								<div class="bedrowpatid" id='<%=patient_id%>Dummy'>
										&nbsp;<%=patient_id%></div>
								<div class="bedrowpatid">
										&nbsp;<%=patient_name%></div>
									<%
										if (trnsAllowed.equals("N")) {
								%><div class="bedrowpatid">
										&nbsp;<%=encounter_id%>
										<%
											if (!encounter_id.equals("")) {
										%>&nbsp;|&nbsp;<%=gender%>&nbsp;/&nbsp;<%=pat_age%>
										<%
											}
										%>
								</div>
									<%
										} else {
								%><div class="bedrowencid" id='<%=bedNo%>Enc'
										value='<%=encounter_id%>'>
										&nbsp;<%=encounter_id%>&nbsp;<%
											if (!encounter_id.equals("")) {
										%>|&nbsp;<%=gender%>&nbsp;/&nbsp;<%=pat_age%>
										<%
											}
										%>
								</div>
									<%
										}
								%><div class="ipiconrow">
									<div style="float:left;position:relative;">&nbsp;</div>
										<%
											if (KNOWN_ALLERGY_YN.equals("Y")) {
										%><div class="ipicon"
											id='<%=bedNo%>alrgy'
											style="background-image: url('../../eCommon/images/PI_Allergies.gif');"
											onclick='callAllergy(event,"<%=patient_id%>")'></div>
										<%
											} 
										%>
									
										<%
										if (disc_bill_exists.equals("Y")) {
										%><div class="ipicon"
											style="background-image: url('../../eIP/images/BillPrepared.gif');"></div>
										<%
											} 
										%>	
								
										<%
											if (!bedClock.equals("")) {
										%><div class="ipicon"
											style="background-image: url('../../eIP/images/future.gif');"></div>
										<%
											} 																
										%>
										
										<%
											if (Integer.parseInt(overdue_count) > 0) {
										%><div class="ipicon">
											<img src='../../eCommon/images/MedicationOverdue.png'
												title='<%=overdue_time%>' />
										</div>
										<%
											} 
										%>
										<%
											if (Integer.parseInt(due_count) > 0) {
										%><div class="ipicon">
											<img src='../../eCommon/images/MedicationDue.gif'
												onclick='due_medication(event)' title='<%=due_time%>' />
										</div>
										<%
											} 
										%>
										<%
											if (abnormal_rslt_count > 0) {
										%><div class="ipicon">
											<img src='../../eCommon/images/AbnormalResults.png'
												title='Abnormal Results' />
										</div>
										<%
											} 
										%>
										
										<%
											if(ost_orders_count > 0) {
										%><div class="ipicon">
										<img src='../images/PendingOrders.png' title='Outstanding orders'/>
										</div>
										<%
											}
										%>
										
									</div>
								</div>
							
								<%-- <div class='ipbedfutbkg' style='background:<%=bedColorExt%>;'></div> --%>
								<!-- this is for providing vertical space --> 
								<div style='background:<%=bedColorExt%>;height:2px;'></div>
							   </div>
								 <b class="bedbottom" style='background:<%=room_clr%>'>
								 	<b id="bbottomfirst_<%=roomNumber %><%=bedNo%>" class="<%=bedBottomoneClass%>" style='background:<%=bedColorExt%>;'></b>
									<b id="bbottomsecond_<%=roomNumber %><%=bedNo%>" class="<%=bedBottomtwoClass%>" style='background:<%=bedColorExt%>;'></b>
									<b id="bbottomthird_<%=roomNumber %><%=bedNo%>" class="<%=bedBottomthreeClass%>" style='background:<%=bedColorExt%>;'></b>
									<b id="bbottomfour_<%=roomNumber %><%=bedNo%>" class="<%=bedBottomfourClass%>" style='background:<%=bedColorExt%>;'></b>
									<b id="bbottomlast_<%=roomNumber %><%=bedNo%>" class="<%=bedBottomfiveClass%>" style='background:<%=bedColorExt%>;'></b>
								 </b>
								</a>
						</div>
						<%
							}//while loop for roomBedsList ends
										}//if condition roomBedsList ends
						%>
					</div>
				</div>
				<%
					roomCounter++;
							}//while loop for floorRoomBedList ends
							afterDataProcTime = System.currentTimeMillis();
							if(loggerInst != null){
								logMessage = "Nursing unit="+nursingUnit+";beforeDataProcTime="+beforeDataProcTime+";afterDataProcTime="+afterDataProcTime;
								loggerInst.debug(logMessage);
							}
							System.out.println("beforeDataProcTime="+beforeDataProcTime+";afterDataProcTime="+afterDataProcTime);
						}//if condition floorRoomBedList ends
				%>
			</div>
		</div>
		<input type='hidden' name='facility_id' id='facility_id' id='facilityId'
			value='<%=facility_id%>' /> <input type='hidden' name='nursingUnit' id='nursingUnit'
			id='nursingUnitId' value='<%=nursingUnit%>' /> <input type='hidden'
			name='bl_operational' id='bl_operational' id='bl_operational' value='<%=bl_operational%>' />
		<!-- bl operational at facility level-->
		<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn'
			id='setup_bl_dtls_in_ip_yn' value='<%=setup_bl_dtls_in_ip_yn%>' /> <input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' id='bl_interfaced_yn'
			value='<%=bl_interfaced_yn%>' /> <input type='hidden'
			name='allow_discharge_date' id='allow_discharge_date' id='allow_discharge_date'
			value='<%=allow_discharge_date%>' /> <input type='hidden'
			name='chk_for_pen_orders_bfr_dis_adv' id='chk_for_pen_orders_bfr_dis_adv'
			id='chk_for_pen_orders_bfr_dis_adv'
			value='<%=chk_for_pen_orders_bfr_dis_adv%>' /> <input type='hidden'
			name='dis_adv_allow_yn' id='dis_adv_allow_yn' id='dis_adv_allow_yn'
			value='<%=dis_adv_allow_yn%>' /> <input type='hidden'
			name='chk_for_pen_orders_bfr_dis' id='chk_for_pen_orders_bfr_dis' id='chk_for_pen_orders_bfr_dis'
			value='<%=chk_for_pen_orders_bfr_dis%>' /> <input type='hidden'
			name='dis_allow_yn' id='dis_allow_yn' id='dis_allow_yn' value='<%=dis_allow_yn%>' /> <input type='hidden' name='max_disch_period_for_dc' id='max_disch_period_for_dc'
			id='max_disch_period_for_dc' value='<%=max_disch_period_for_dc%>' />
		<input type='hidden' name='mother_cut_off_age' id='mother_cut_off_age' id='mother_cut_off_age'
			value='<%=mother_cut_off_age%>' /> <input type='hidden'
			name='mother_max_age' id='mother_max_age' id='mother_max_age' value='<%=mother_max_age%>' />

		<input type='hidden' name='disch_reason_mand_yn' id='disch_reason_mand_yn'
			id='disch_reason_mand_yn' value='<%=disch_reason_mand_yn%>' /> <input type='hidden' name='allow_late_discharge_reason' id='allow_late_discharge_reason'
			id='allow_late_discharge_reason'
			value='<%=allow_late_discharge_reason%>' /> <input type='hidden'
			name='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn' id='deactivate_pseudo_bed_yn'
			value='<%=deactivate_pseudo_bed_yn%>' /> <input type='hidden'
			name='diag_update_period_max_unit' id='diag_update_period_max_unit' id='diag_update_period_max_unit'
			value='<%=diag_update_period_max_unit%>' /> <input type='hidden'
			name='dis_date_chk_days_unit' id='dis_date_chk_days_unit' id='dis_date_chk_days_unit'
			value='<%=dis_date_chk_days_unit%>' /> <input type='hidden'
			name='dis_date_chk_days' id='dis_date_chk_days' id='dis_date_chk_days'
			value='<%=dis_date_chk_days%>' /> <input type='hidden'
			name='bed_block_period_dis' id='bed_block_period_dis' id='bed_block_period_dis'
			value='<%=bed_block_period_dis%>' /> <input type='hidden'
			name='discharge_checklist_app_yn' id='discharge_checklist_app_yn' id='discharge_checklist_app_yn'
			value='<%=discharge_checklist_app_yn%>' /> <input type='hidden'
			name='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn'
			value='<%=pat_check_in_allowed_yn%>' /> <input type='hidden'
			name='room' id='room' value='<%=room%>' /> <input type='hidden'
			name='bedSelect' id='bedSelect' id='bedSelectId' value='' /> <input type='hidden'
			name='encSelect' id='encSelect' id='encSelectId' value='' /> <input type='hidden'
			name='cluetipOpenYN' id='cluetipOpenYN' id='cluetipOpenYNId' value='N' /> <input type='hidden' name='jsp_name' id='jsp_name' value='' /> <input type='hidden'
			name='modal' id='modal' value=""> <input type='hidden'
			name='win_height' id='win_height' value="34"> <input type='hidden'
			name='win_width' id='win_width' value="50"> <input type='hidden'
			name='dialogTop' id='dialogTop' value="65"> <input type='hidden'
			name='module' id='module' value=""> <input type='hidden'
			name='model_window' id='model_window' value="">
			
			<!--  hidden components  -->
			<input type="hidden" id="<%=PatientSearchConstants.PATIENT_SRCH_REQUEST_PARAM_KEY %>" name="<%=PatientSearchConstants.PATIENT_SRCH_REQUEST_PARAM_KEY %>" value="<%=patSrchYN%>">
			<input type="hidden" id="<%=PatientSearchConstants.PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY %>" name="<%=PatientSearchConstants.PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY %>" value="<%=patSrchPatientId%>">
			<input type="hidden" id="<%=PatientSearchConstants.PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY %>" name="<%=PatientSearchConstants.PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY %>" value="<%=roomNumInSrch%>">
			<input type="hidden" id="<%=PatientSearchConstants.PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY %>" name="<%=PatientSearchConstants.PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY %>" value="<%=bedNumInSrch%>">
			
			
	</form>
	<script>
			
			self.setInterval('checkAndRefreshPage()',(<%=refresh_interval%>*60*1000));
			function checkAndRefreshPage(){
				if(typeof isBedBubbleShown != 'undefined'){
					if(isBedBubbleShown == true){
						return;
					}	
				}
				
				parent.serachFrame.popDynamicValues(true);				
			} 
			
			$(document).ready(function() {
				scrollToSearchedPatient();
		     });
			
		</script>
</body>
<%
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}
%>
</html>
<%!public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? ""
				: inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue
				: inputString);
	}%>


<!DOCTYPE html>
<!DOCTYPE>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@page import="eIP.advbedmgmt.transaction.patientsearch.PatientSearchConstants"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIP.advbedmgmt.common.CommonHelper"%>
<%@page import="eIP.IPAdvBedMgmtConfigBean"%>
<%@page import="eCommon.Common.CommonAdapter"%>
<%@page import="eIP.advbedmgmt.common.model.Patient"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="eIP.advbedmgmt.common.model.Bed"%>
<%@page import="eIP.advbedmgmt.common.model.Room"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.bc.BedDetailsBC"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.request.BasicBedDetailsRequest"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.response.BasicBedDetailsResponse"%>
<%@page import="org.apache.log4j.Logger"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*"%>

<%
	String sStyle = checkForNull(
			(String) session.getAttribute("PREFERRED_STYLE"),
			"IeStyle.css");
	String nursingUnit = request.getParameter("nursingUnit") == null ? ""
			: request.getParameter("nursingUnit");
	// there is a need for the selected nursing unit description as well
	// this needs to be passed to inner page - ipadvbedmgmttooltip.jsp
	String nursingUnitDesc = request.getParameter("nursingUnitDesc");
	if(nursingUnitDesc == null){
		nursingUnitDesc = "";
	}
	String roomN = request.getParameter("room") == null ? "" : request
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
<script src="../../eIP/js/json2.js" language="JavaScript"></script>
<script src="../../eIP/js/IPAdvBedMgmtTrns.js" language="JavaScript"></script>
<script src='../../eIP/js/IPAdvBedMgmtSupplementary.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script type="text/javascript">
			//var isBedBubbleShown = false;

			$(document).ready(function() {
				 $('a.jt').cluetip({
					cluetipClass: 'jtip',
					width:676,
					height:890,
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
				 /*$('.assignedBed').mouseover(function(){
					var bedId=$(this).attr('id');
					//alert($(this).attr('id'))
					//alert($("#"+bedId+'Enc').val())
					$('#bedSelectId').val($(this).attr('id'));
					$('#encSelectId').val($("#"+bedId+'Enc').val());
					//alert($(this).attr('id'))
					//$('#log').append('<div>Handler for .mouseover() called.</div>');
					//bedOverId
				}); */
				
				// call the function which will initiate the bed status
				// rendering
				loadMainPageInSteps();
				
				scrollToSearchedPatient();
				
				$('#floorWrapper').width(document.documentElement.clientWidth)
				$('#floorWrapper').height(document.documentElement.clientHeight)
			});
			window.onresize=function(){
				$('#floorWrapper').width(document.documentElement.clientWidth);
			};
		
			
			function openBedBubble(){
				// this function launches the bed bubble
				//alert('bed bubble');
				//$('a.jt').trigger('showCluetip');
				if(pageLoadInProgress == true){					
					return false;
				}
				
				isBedBubbleShown = true;
				return true;
			}
			
			function afterBedBubbleHide(){
				isBedBubbleShown = false;
			}
			
		</script>


<style type="text/css">
	.hidemaskstyle{
      display:none;
      /* position: fixed; */
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      
      overflow:auto;
	  position:relative;	
	  background:#E2E2E2; 
	}
	
	.showmaskstyle{
	  display:block; 
	  /* display:none; */
      /* position: fixed; */
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      -ms-filter:"progid:DXImageTransform.Microsoft.Alpha(opacity=90)";
      filter:alpha(opacity=90);
      opacity: 0.90;
      background-color: rgba(200,200,200,0.90);
      
	}
	
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
	
	/**
	* Code added for GBM module starts here
	*/
	// code to get the basic bed details
	// for this, initialize request object, get the BC instance through bean lookup
	// call method in BC instance to get response
	BasicBedDetailsRequest basicBedRequest = new BasicBedDetailsRequest();
	basicBedRequest.setFacilityId(facility_id);
	basicBedRequest.setNursingUnitCode(nursingUnit);
	basicBedRequest.setBedNumber(FloorLayoutConstants.BASIC_BED_DETAILS_BED_NUMBER_ESC_SEQ);
	basicBedRequest.setLocale(locale);
	//basicBedRequest.setLoginUser(user_id);
	ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
	BedDetailsBC bcInst = (BedDetailsBC) context.getBean(FloorLayoutConstants.BED_DETAILS_BC_NAME);
	BasicBedDetailsResponse basicBedResponse = bcInst.getBasicBedDetails(basicBedRequest);
	
	List<Room> roomsList = null;
	try {
		con = ConnectionManager.getConnection(request);
		afterConnTime = System.currentTimeMillis();
		//session.setAttribute("bl_operational", "N");
		//session.setAttribute("bl_install_yn", "N");
		String bl_operational = checkForNull(
				(String) session.getAttribute("bl_operational"), "N");
		// to get all rooms of nursing unit starts
		stmt = con.createStatement();
		/**
		* Commented as floorroombedlist will not be used
		*/
		/* floorRoomBedList = eIP.IPAdvBedMgmtBean
				.getNursingUnitRoomBedTrnsData(con, stmt, rs,
						nursingUnit, facility_id, locale, user_id,
						bl_operational); */
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
		
		String room_clr = null;
		/* Map colorCodingmap=IPAdvBedMgmtConfigBean.getBedConfSetupData(con);
		room_clr = (String) colorCodingmap.get("room_clr"); */
		
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

		// code to handle error response as well as empty response
		String errorMessage = null;
		if(!basicBedResponse.isSuccessful()){
			errorMessage = basicBedResponse.getErrorMessage();
			/**
			* TODO
			* Need to show the error message as is - but GUI style
			* is not provided
			*/
		}
		
		roomsList = basicBedResponse.getRooms();
		// there is a need to handle empty room list
		// this only means the nursing unit is not configured
		// need to show an information message to user
		if(roomsList==null || roomsList.isEmpty()){
			/**
			* TODO
			* need to form an information message - but GUI
			* style is not provided
			*/
		}
		
%>

<!--Below code was modified on 08-JAN-2013 against [IN037130] -->
<body onKeyDown="lockKey()">
	<form name='bedLayOutMgmt' id='bedLayOutMgmt' method='post'>
		<div id="floorWrapper" class='floorWrapper'>
			<div class="floor" id="floor"
				style="width:<%=floorWidth%>px; height:<%=floorHeight%>px;">
				
				<%
				int roomLeftPosition = 0;
				int roomTopPosition = 0;
				int roomHeight = 0;
				int roomWidth = 0;
				int adjustedRoomHeight = 0;
				
				String roomName = null;
				
				List<Bed> bedsList = null;
				
				int bedTopPosition = 0;
				int bedLeftPosition = 0;
				int bedHeight = 0;
				int bedWidth= 0;
				String bedNumber = null;
				int adjustedBedWidth = 0;
				int adjustedBedHeight = 0;
				
				String bedStyle = null;
				//String bedStyleClass = "bedWOHighlight";
				// var to store the total bed count
				int totalBedCount = 0;
				
				
				// iterate through the room list and render the room
				for(Room room : roomsList){
					roomLeftPosition = room.getRoomLeftPosition();
					roomTopPosition = room.getRoomTopPosition();
					roomHeight = room.getRoomHeight();
					roomWidth = room.getRoomWidth();
					
					roomName = room.getRoomDesc();
					roomNumber = room.getRoomNumber();
					
					adjustedRoomHeight = roomHeight - 20;
					room_clr = room.getRoomBackgndColor(); 
					
					bedsList = room.getBeds();
					if(bedsList == null){
					%>
						<div id="<%=roomNumber %>" class="room"
								style="top:<%=roomTopPosition%>px; left:<%=roomLeftPosition%>px;width:<%=roomWidth%>px; height:<%=roomHeight%>px;background:#<%=room_clr%>">
								<div class='roomheader'>
									<%=roomName%>
								</div>
								<div class='roombody' style="height:<%=adjustedRoomHeight%>px;">
								</div>
						</div>		
					<%	
						continue;
					}
					
					%>
					<div id="<%=roomNumber %>" class="room"
								style="top:<%=roomTopPosition%>px; left:<%=roomLeftPosition%>px;width:<%=roomWidth%>px; height:<%=roomHeight%>px;background:#<%=room_clr%>">
								<div class='roomheader' style='color:#00242b;background-color: #aac5cc;font-weight:bold;'>
									<%=roomName%>
								</div>
								<div class='roombody' style="height:<%=adjustedRoomHeight%>px;">
					<%
					
					
					Patient patientDetails = null;
					String patientId = null;
					String patientName = null;
					String encounterId = null;
					String gender = null;
					String age = null;
					
					String trnsAllowed = null;
					
					//Added by Ajay Hatwate for MMS-DM-CRF-0210
				    
				    String hide_pat_unauth_pract = "N";
				   	String access_res_pat_yn = "N";
				    
				    pstmt = con.prepareStatement("select (select HIDE_PAT_UNAUTH_PRACT_YN from CA_PARAM_BY_FACILITY where facility_id = ?) hide_pat_unauth_pract_yn, (SELECT a.access_res_pat_yn FROM ca_access_view_restr_patient a WHERE a.practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = ?) AND a.facility_id = ? AND (   (    a.access_from_date IS NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') ) OR (    a.access_from_date IS NOT NULL AND a.access_to_date IS NOT NULL AND TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (a.access_from_date, 'DD/MM/YYYY') AND TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (a.access_to_date, 'DD/MM/YYYY') ) ))access_res_pat_yn from dual ");
				   	pstmt.setString(1, facility_id);
				   	pstmt.setString(2, user_id);
				   	pstmt.setString(3, facility_id);
				   	rs = pstmt.executeQuery();
				   	rs.next();
				   	hide_pat_unauth_pract = checkForNull(rs.getString("hide_pat_unauth_pract_yn"),"N");
				   	access_res_pat_yn = checkForNull(rs.getString("access_res_pat_yn"), "N");
				    //System.out.println(hide_pat_unauth_pract + " : hide_pat_unauth_pract; " +access_res_pat_yn + " : access_res_pat_yn");
				    if(pstmt!=null) pstmt.close();
				    if(rs!=null) rs.close();
				    //End of MMS-DM-CRF-0210
					
					
					// increment the bed count
					totalBedCount += bedsList.size();
					
					for(Bed bedInst : bedsList){
						bedLeftPosition = bedInst.getBedLeftPosition();
						bedTopPosition = bedInst.getBedTopPosition();
						bedHeight = bedInst.getBedHeight();
						bedWidth = bedInst.getBedWidth();
						
						adjustedBedWidth = bedWidth - 4;
						adjustedBedHeight = bedHeight - 10;
					
						bedNumber = bedInst.getBedNumber();
						patientDetails = bedInst.getPatientDetails();
						
						patientId = patientDetails.getPatientId();
						
						if(hide_pat_unauth_pract.equals("Y") && access_res_pat_yn.equals("N")){
							if(pstmt != null) pstmt.close();
							if(rs != null) rs.close();
							String isRestricted = "";
							pstmt = con.prepareStatement("select restrict_reinstate_yn from mp_patient where patient_id = ?");
							pstmt.setString(1, patientId);
							rs = pstmt.executeQuery();
							while(rs!=null && rs.next()){
								isRestricted =  checkForNull(rs.getString("restrict_reinstate_yn"));
							}
							if(isRestricted.equals("N")){
						
						
						patientName = patientDetails.getShortDisplayName();
						encounterId = patientDetails.getEncounterId();
						encounterId = CommonAdapter.checkForNull(encounterId);
						gender = patientDetails.getGender();
						gender = CommonAdapter.checkForNull(gender);
						gender = CommonHelper.getDisplayGender(gender, locale);
						age = patientDetails.getAge();
						age = CommonAdapter.checkForNull(age);
						
						trnsAllowed = bedInst.getTrnsAllowed();
						
						bedStyle = "top:"+bedTopPosition+"px; left:"+bedLeftPosition+"px;width:"+bedWidth+"px; height:"+bedHeight+"px;";
						
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
						
						// check if patient search parameters are set
						// this implies user has searched for a patient
						// in this case the bed should be highlighted
						if(PatientSearchConstants.PATIENT_SRCH_REQUEST_VALUE.equalsIgnoreCase(patSrchYN) 
														&& patSrchPatientId.equals(patientId)){
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
								bedNumInSrch = bedNumber;
							}
						}
						
					%>
					
									<div id="<%=roomNumber %><%=bedNumber%>" class="<%=bedStyleClass %>" style="<%=bedStyle%>">
										<a class="jt"
										rel="../../eIP/jsp/IPAdvBedMgmtToolTip.jsp?bed_no=<%=bedNumber%>&nursing_unit=<%=nursingUnit%>&appl_patient_class=<%=appl_patient_class%>&encounter_id=<%=encounterId%>&operStnId=<%=operStnId%>&nursing_unit_desc=<%=nursingUnitDesc %>&room_number=<%=roomNumber %>&room_name=<%=roomName %>&trnsAllowed=<%=trnsAllowed%>"\																				
										title="Manage Bed">
										 <b class="bedtop" style='background:<%=room_clr%>'>
											<b id="btopfirst_<%=roomNumber %><%=bedNumber%>" class="<%=bedToponeClass%>" style='background:#008000;'></b> 
											<b id="btopsecond_<%=roomNumber %><%=bedNumber%>" class="<%=bedToptwoClass%>" style='background:#008000;'></b> 
											<b id="btopthird_<%=roomNumber %><%=bedNumber%>" class="<%=bedTopthreeClass%>" style='background:#008000;'></b>
											<b id="btopfour_<%=roomNumber %><%=bedNumber%>" class="<%=bedTopfourClass%>" style='background:#008000;'></b>
											<b id="btoplast_<%=roomNumber %><%=bedNumber%>" class="<%=bedTopfiveClass%>" style='background:#008000;'></b>
										</b>
										<div id="innerDiv_<%=roomNumber %><%=bedNumber%>" style='width:<%=adjustedBedWidth %>px; height:<%=adjustedBedHeight %>px;background-color:#008000;border-left: 1px solid #008000;border-right: 1px solid #008000;' >
											<div id="bedHeader" class='bedheader' ><%=bedNumber %></div>
											<div class='bedbody' >
												<!-- Modified by Dharma on 16th Mar 2016-->
												<!--<div class="bedrowpatid" id='' style='color: #000000;'>-->
												<div class="bedrowpatid" id='' >
													&nbsp;<%=patientId %></div>
												<div class="bedrowpatid">
													&nbsp;<%=patientName%></div>
												<div class="bedrowpatid">
													&nbsp;
													<%
														if(!encounterId.trim().equals("")){
													%>
													<%=encounterId%>&nbsp;|&nbsp;
													<%
														}
														if(!gender.trim().equals("")){
													%>
													<%=gender %>&nbsp;/
													<%
														}
														if(!age.trim().equals("")){
													%>
													<%=age %>
													<%
														}
													%>	
												</div>
												
												<div id='iconrow' class="ipiconrow">
													<div style="float:left;position:relative;">&nbsp;</div>
													<div id='kAllergy_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eCommon/images/PI_Allergies.gif');" onclick='callAllergy(event,"<%=patientId%>")'></div>
													<div id='bExists_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eIP/images/BillPrepared.gif');"></div>
													<div id='fbook_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eIP/images/future.gif');"></div>
													
													<div id='aux1_<%=roomNumber %><%=bedNumber%>'></div>
													<%-- <div id='aux2_<%=roomNumber %><%=bedNumber%>'></div>
													<div id='aux3_<%=roomNumber %><%=bedNumber%>'></div> --%>
																										
													<div id='pendorders_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eIP/images/PendingOrders.png');'"></div>
												</div>
												
											</div>
										</div>
										
										<b class="bedbottom" style='background:<%=room_clr%>'>
								 			<b id="bbottomfirst_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomoneClass%>" style='background:#008000;'></b>
											<b id="bbottomsecond_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomtwoClass%>" style='background:#008000;'></b>
											<b id="bbottomthird_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomthreeClass%>" style='background:#008000;'></b>
											<b id="bbottomfour_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomfourClass%>" style='background:#008000;'></b>
											<b id="bbottomlast_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomfiveClass%>" style='background:#008000;'></b>
								 		</b>
										
									   </a>	
										
									</div> 
						
					<%	
					
					//space1 MMS-DM-CRF-0210
						}
						}else{
							
							
							patientName = patientDetails.getShortDisplayName();
							encounterId = patientDetails.getEncounterId();
							encounterId = CommonAdapter.checkForNull(encounterId);
							gender = patientDetails.getGender();
							gender = CommonAdapter.checkForNull(gender);
							gender = CommonHelper.getDisplayGender(gender, locale);
							age = patientDetails.getAge();
							age = CommonAdapter.checkForNull(age);
							
							trnsAllowed = bedInst.getTrnsAllowed();
							bedStyle = "top:"+bedTopPosition+"px; left:"+bedLeftPosition+"px;width:"+bedWidth+"px; height:"+bedHeight+"px;";
							
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
							
							// check if patient search parameters are set
							// this implies user has searched for a patient
							// in this case the bed should be highlighted
							if(PatientSearchConstants.PATIENT_SRCH_REQUEST_VALUE.equalsIgnoreCase(patSrchYN) 
															&& patSrchPatientId.equals(patientId)){
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
									bedNumInSrch = bedNumber;
								}
							}
							
						%>
						
										<div id="<%=roomNumber %><%=bedNumber%>" class="<%=bedStyleClass %>" style="<%=bedStyle%>">
											<a class="jt"
											rel="../../eIP/jsp/IPAdvBedMgmtToolTip.jsp?bed_no=<%=bedNumber%>&nursing_unit=<%=nursingUnit%>&appl_patient_class=<%=appl_patient_class%>&encounter_id=<%=encounterId%>&operStnId=<%=operStnId%>&nursing_unit_desc=<%=nursingUnitDesc %>&room_number=<%=roomNumber %>&room_name=<%=roomName %>&trnsAllowed=<%=trnsAllowed%>"\																				
											title="Manage Bed">
											 <b class="bedtop" style='background:<%=room_clr%>'>
												<b id="btopfirst_<%=roomNumber %><%=bedNumber%>" class="<%=bedToponeClass%>" style='background:#008000;'></b> 
												<b id="btopsecond_<%=roomNumber %><%=bedNumber%>" class="<%=bedToptwoClass%>" style='background:#008000;'></b> 
												<b id="btopthird_<%=roomNumber %><%=bedNumber%>" class="<%=bedTopthreeClass%>" style='background:#008000;'></b>
												<b id="btopfour_<%=roomNumber %><%=bedNumber%>" class="<%=bedTopfourClass%>" style='background:#008000;'></b>
												<b id="btoplast_<%=roomNumber %><%=bedNumber%>" class="<%=bedTopfiveClass%>" style='background:#008000;'></b>
											</b>
											<div id="innerDiv_<%=roomNumber %><%=bedNumber%>" style='width:<%=adjustedBedWidth %>px; height:<%=adjustedBedHeight %>px;background-color:#008000;border-left: 1px solid #008000;border-right: 1px solid #008000;' >
												<div id="bedHeader" class='bedheader' ><%=bedNumber %></div>
												<div class='bedbody' >
													<!-- Modified by Dharma on 16th Mar 2016-->
													<!--<div class="bedrowpatid" id='' style='color: #000000;'>-->
													<div class="bedrowpatid" id='' >
														&nbsp;<%=patientId %></div>
													<div class="bedrowpatid">
														&nbsp;<%=patientName%></div>
													<div class="bedrowpatid">
														&nbsp;
														<%
															if(!encounterId.trim().equals("")){
														%>
														<%=encounterId%>&nbsp;|&nbsp;
														<%
															}
															if(!gender.trim().equals("")){
														%>
														<%=gender %>&nbsp;/
														<%
															}
															if(!age.trim().equals("")){
														%>
														<%=age %>
														<%
															}
														%>	
													</div>
													
													<div id='iconrow' class="ipiconrow">
														<div style="float:left;position:relative;">&nbsp;</div>
														<div id='kAllergy_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eCommon/images/PI_Allergies.gif');" onclick='callAllergy(event,"<%=patientId%>")'></div>
														<div id='bExists_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eIP/images/BillPrepared.gif');"></div>
														<div id='fbook_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eIP/images/future.gif');"></div>
														
														<div id='aux1_<%=roomNumber %><%=bedNumber%>'></div>
														<%-- <div id='aux2_<%=roomNumber %><%=bedNumber%>'></div>
														<div id='aux3_<%=roomNumber %><%=bedNumber%>'></div> --%>
																											
														<div id='pendorders_<%=roomNumber %><%=bedNumber%>' class="ipicon" style="visibility: hidden;background-image: url('../../eIP/images/PendingOrders.png');'"></div>
													</div>
													
												</div>
											</div>
											
											<b class="bedbottom" style='background:<%=room_clr%>'>
									 			<b id="bbottomfirst_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomoneClass%>" style='background:#008000;'></b>
												<b id="bbottomsecond_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomtwoClass%>" style='background:#008000;'></b>
												<b id="bbottomthird_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomthreeClass%>" style='background:#008000;'></b>
												<b id="bbottomfour_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomfourClass%>" style='background:#008000;'></b>
												<b id="bbottomlast_<%=roomNumber %><%=bedNumber%>" class="<%=bedBottomfiveClass%>" style='background:#008000;'></b>
									 		</b>
											
										   </a>	
											
										</div> 
							
						<%
							
							
							
							
						}
					
					
					
					}
					%>
					
					</div>
				</div>	
					<%
				}
				
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
			name='room' id='room' value='<%=roomN%>' /> <input type='hidden'
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
			
			<input type="hidden" id="<%=FloorLayoutConstants.TOTAL_BED_COUNT_COMP_KEY %>" name="<%=FloorLayoutConstants.TOTAL_BED_COUNT_COMP_KEY %>" value="<%=totalBedCount%>">
			
	</form>
	
	<div id="maskdiv" class="hidemaskstyle">
	</div>
	
	
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
			
			/* $(document).ready(function() {
				scrollToSearchedPatient();
		     }); */
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


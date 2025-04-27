<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="eIP.advbedmgmt.transaction.TransactionConstants"%>
<%@page import="eIP.advbedmgmt.transaction.rolebasedaccess.response.Transaction"%>
<%@page import="eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListResourceConstants"%>
<%@page import="eIP.advbedmgmt.common.resourcebundle.BundleManager"%>
<%@page import="eIP.advbedmgmt.transaction.rolebasedaccess.response.TransactionListResponse"%>
<%@page import="eIP.advbedmgmt.transaction.rolebasedaccess.bc.TransactionListBC"%>
<%@page import="eIP.advbedmgmt.transaction.rolebasedaccess.TransactionListConstants"%>
<%@page import="eIP.advbedmgmt.transaction.rolebasedaccess.request.TransactionListRequest"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.response.BedIconSection"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.response.RoomForBedIconSection"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.response.BedIconResponse"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.bc.BedDetailsBC"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.FloorLayoutConstants"%>
<%@page import="eIP.advbedmgmt.transaction.floorlayout.request.BedIconRequest"%>
<%@page import="eIP.advbedmgmt.transaction.patientfinancial.FinancialInfoConstants"%>
<%@page import="eIP.advbedmgmt.transaction.canceladmission.PatientCheckInController"%>
<%@page import="eIP.advbedmgmt.transaction.canceladmission.PatientCheckInStatusResponse"%>
<%@page import="eIP.advbedmgmt.transaction.canceladmission.PatientCheckInStatusRequest"%>
<%@page import="eIP.advbedmgmt.transaction.createbooking.CreateBookingConstants"%>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  <link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtStyle.css"/>
  <Script src="../js/json2.js" language="JavaScript"></Script>
  <title></title>
</head>
<body class="page"> 
<%
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt=null;
	PreparedStatement	pstmt	= null;
	ResultSet rs	= null;
	String facility_id		= (String)session.getAttribute("facility_id");
	String nursing_unit=request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	// get the nursing unit description as well - this is needed for internal processing
	String nursing_unit_desc=request.getParameter("nursing_unit_desc");
	if(nursing_unit_desc == null){
		nursing_unit_desc = "";
	}
	String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String user_id=(String)session.getAttribute("login_user");
	String operStnId=request.getParameter("operStnId")==null?"":request.getParameter("operStnId");
	String trnsAllowed=request.getParameter("trnsAllowed")==null?"":request.getParameter("trnsAllowed");
	String bed_no=request.getParameter("bed_no")==null?"":request.getParameter("bed_no");
	String appl_patient_class=request.getParameter("appl_patient_class")==null?"":request.getParameter("appl_patient_class");
	
	// get the room number and the room name as well - this will be passed from Graphical Bed Management module
	String roomNumber = request.getParameter("room_number");
	if(roomNumber == null){
		roomNumber = "";
	}
	String roomName = request.getParameter("room_name");
	if(roomName == null){
		roomName = "";
	}
	
	
	String patient_id="";
	String patient_name="";
	String practitioner_id="";
	String practitioner_name="";
	String bed_class="";
	String bed_type="";
	String locale				= (String)session.getAttribute("LOCALE");
	String bedNo="";
	String pat_age="";
	String gender="";
	String admissionDateTime="";
	String expDischargeDateTime="";
	String pend_ord_stats="";
	String pat_dtls_unknown="";
	String finalize_yn="";
	// code added for showing bed allocation date time value
	String bed_alloc_date_time = "";
	
	// code added to initialize vars for specialty code and desc
	String specialtyCode = "";
	String specialtyDesc = "";
			
	try{
		con=ConnectionManager.getConnection(request);
		// to get all rooms of nursing unit starts
		//stmt=con.createStatement();
		HashMap ipPatEncData=eIP.IPAdvBedMgmtBean.getPatEncounterData(con,stmt,rs,encounter_id,facility_id,locale,bed_no);
		patient_id=(String)(ipPatEncData.get("patient_id")==null?"":ipPatEncData.get("patient_id"));
		bedNo=(String)(ipPatEncData.get("bedNo")==null?"":ipPatEncData.get("bedNo"));
		bed_class=(String)(ipPatEncData.get("bed_class_short_desc")==null?"":ipPatEncData.get("bed_class_short_desc"));
		bed_type=(String)(ipPatEncData.get("bed_type_short_desc")==null?"":ipPatEncData.get("bed_type_short_desc"));
		patient_name=(String)(ipPatEncData.get("patient_name")==null?"":ipPatEncData.get("patient_name"));
		pat_age=(String)(ipPatEncData.get("pat_age")==null?"":ipPatEncData.get("pat_age"));
		gender=(String)(ipPatEncData.get("gender")==null?"":ipPatEncData.get("gender"));
		pend_ord_stats=(String)(ipPatEncData.get("pend_ord_stats")==null?"N":ipPatEncData.get("pend_ord_stats"));
		pat_dtls_unknown=(String)(ipPatEncData.get("pat_dtls_unknown")==null?"N":ipPatEncData.get("pat_dtls_unknown"));
		finalize_yn=(String)(ipPatEncData.get("finalize_yn")==null?"N":ipPatEncData.get("finalize_yn"));
		practitioner_id=(String)(ipPatEncData.get("practitioner_id")==null?"":ipPatEncData.get("practitioner_id"));		
		practitioner_name=(String)(ipPatEncData.get("practitioner_name")==null?"":ipPatEncData.get("practitioner_name"));		
		admissionDateTime=(String)(ipPatEncData.get("admission_date_time")==null?"":ipPatEncData.get("admission_date_time"));		
		expDischargeDateTime=(String)(ipPatEncData.get("exp_discharge_date_time")==null?"":ipPatEncData.get("exp_discharge_date_time"));
		// get the bed allocation date time value
		bed_alloc_date_time = (String)(ipPatEncData.get("bed_alloc_date_time")==null?"":ipPatEncData.get("bed_alloc_date_time"));
		
		// code added to get specialty code and desc
		specialtyDesc = (String)ipPatEncData.get("specialtyDesc");
		specialtyCode = (String)ipPatEncData.get("specialtyCode");
		
		String retVal="";
		TransactionListResponse transListResponse = null;
		// get the transaction list 
		if(trnsAllowed.equals("Y")){
			//retVal=eIP.IPAdvBedMgmtBean.getIPEncAllowedOperations(con,pstmt,rs,facility_id,encounter_id,nursing_unit,bedNo,patient_id,user_id,operStnId);

			// new code to get the transaction list
			TransactionListRequest transRequest = new TransactionListRequest();
			transRequest.setFacilityId(facility_id);
			transRequest.setEncounterId(encounter_id);
			transRequest.setBedNumber(bed_no);
			transRequest.setLocale(locale);
			transRequest.setLocationCode(nursing_unit);
			transRequest.setLocationType(TransactionListConstants.NU_LOCATION_TYPE);
			transRequest.setNursingUnitCode(nursing_unit);
			transRequest.setPatientId(patient_id);
			
			// get responsibility id from session
			String respId = (String)session.getAttribute("responsibility_id");
			transRequest.setResponsibilityId(respId);
			transRequest.setUserId(user_id);
			
			ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
			TransactionListBC bcInst = (TransactionListBC) context.getBean(TransactionListConstants.BEAN_CLASS_KEY);
			transListResponse = bcInst.getAccessibleTransactions(transRequest);
		}
		if(gender.equals("M")){
			gender=MessageManager.getLabel(locale,"Common.male.label","Common");
		}else if(gender.equals("F")){
			gender=MessageManager.getLabel(locale,"Common.female.label","Common");
		}else if(gender.equals("U")){
			gender=MessageManager.getLabel(locale,"Common.unknown.label","Common");
		}
		
		// code added to get the bed icon section
		// this is similar to the bed icon section part in the main GUI
		// difference is that a particular bed number is passed here
		BedIconRequest bedIconRequest = new BedIconRequest();
		bedIconRequest.setFacilityId(facility_id);
		bedIconRequest.setNursingUnitCode(nursing_unit);
		String blOper = (String) session.getAttribute("bl_operational");
		blOper = CommonBean.checkForNull(blOper,
				FloorLayoutConstants.BILL_OPERATIONAL_DEFAULT_VALUE);
		bedIconRequest.setBlOperational(blOper);
		bedIconRequest.setLangId(locale);
		bedIconRequest.setBedNumber(bed_no);
		
		// get data through BC class
		ApplicationContext context = new ClassPathXmlApplicationContext(
						GBMConstants.SPRING_BEANS_XML_NAME);
		BedDetailsBC bcInst = (BedDetailsBC) context
						.getBean(FloorLayoutConstants.BED_DETAILS_BC_NAME);
		BedIconResponse bedIconResponse = bcInst.getBedIconSectionDetails(bedIconRequest);
		
		String knownAllergyYN="N";
		int futBookCnt = 0;
		int medOverDue = 0;
		int abnormalResCnt = 0;
		int pubResCnt = 0;
		int ordersCnt = 0;
		
		// inspect the icons only when the response is successful
		if(bedIconResponse.isSuccessful()){
			List<RoomForBedIconSection> rooms = bedIconResponse.getRooms();
			// rooms will be filled and will have only one room
			final int ROOM_INDEX = 0;
			RoomForBedIconSection room = rooms.get(ROOM_INDEX);
			List<BedIconSection> beds = room.getBedIcons();
			// bed list also will have only one bed 
			final int BED_INDEX = 0;
			BedIconSection bedIconSection = beds.get(BED_INDEX);
			// allergy
			knownAllergyYN = bedIconSection.getKnownAllergy();
			futBookCnt = bedIconSection.getFutureBookingCount();
			medOverDue = bedIconSection.getMedicationOverDueCount();
			abnormalResCnt = bedIconSection.getAbnormalResultCount();
			pubResCnt = bedIconSection.getPublishedResultCount();
			ordersCnt = bedIconSection.getOrdersCount();
		}
		
		//KNOWN_ALLERGY_YN=request.getParameter("KNOWN_ALLERGY_YN")==null?"N":request.getParameter("KNOWN_ALLERGY_YN");
		//String overdue_count=request.getParameter("overdue_count")==null?"0":request.getParameter("overdue_count");
		//String due_count=request.getParameter("due_count")==null?"0":request.getParameter("due_count");
		//String abnormal_rslt_count=request.getParameter("abnormal_rslt_count")==null?"0":request.getParameter("abnormal_rslt_count");
		
%>
	<div class='box'>
		<div class='patdtls'>
			<div class='Bannerbg'>
				<div class='patphoto'>
					<img src="../../eCommon/jsp/PatPhotoDisplay.jsp?patient_id=<%=patient_id%>" class='patphotoimg'>
					<!--<img src="../../eCommon/images/blank_pat_photo.bmp" width='48' height='40'>
					<img src="../../eCommon/images/blank_pat_photo.bmp" class='patphotoimg'>-->
				</div>
				<div class='patdatadtls'>
					<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;">
						<tr>
							<td colspan="2" class='labeltooltip'><%=bedNo%>| <%=bed_class%> |<%=bed_type%></td>
						</tr>
						<%if(!encounter_id.equals("")){%>
							<tr>
								<td colspan="2" class='labeltooltip' style="word-wrap:break-word;"><%=patient_name%>|<%=pat_age%>|<%=gender%></td>
							</tr>
							<tr>
								<td  class='labeltooltip'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
								<td  class='labeltooltip'>:<%=patient_id%></td>
							</tr>
							<tr>
								<td  class='labeltooltip'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
								<td  class='labeltooltip' align='left'>:<%=encounter_id%></td>
							</tr>
						<%}%>
					</table>
				</div>
			</div>
			<div class='imgsection'>
				<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr>
						<!--<td width="30" height="30" align="center" valign="middle"><img src="../../eIP/images/icon01.png" width="19" height="19" /></td>
						<td width="30" height="30" align="center" valign="middle"><img src="../../eIP/images/icon02.png" width="19" height="19" /></td>
						<td width="30" height="30" align="center" valign="middle"><img src="../../eIP/images/icon03.png" width="19" height="19" /></td>
						<td width="30" height="30" align="center" valign="middle"><img src="../../eIP/images/ixon04.png" width="19" height="19" /></td>
						<td align="left" valign="middle">&nbsp;</td>-->
						<td  valign="center">&nbsp;
							
							<!--   show patient financial icon - this has to be shown always-->
							<img src="../images/Dollar.png" title="Financial Details" onclick="showPatientFinancials('<%=facility_id%>','<%=FinancialInfoConstants.PATIENTID_KEY%>','<%=patient_id%>','<%=FinancialInfoConstants.ENCOUNTERID_KEY%>','<%=encounter_id%>')"/>
							<%
							// below are the alert icons
							if("Y".equals(knownAllergyYN)){
							%>
							<img src="../../eCommon/images/PI_Allergies.gif" onclick='callAllery(event,"<%=patient_id%>")' />
							<%
							}
							%>&nbsp;
							<%
							if(futBookCnt > 0){
							%>
							<img src="../images/future.gif"/>
							<%
							}
							%>&nbsp;
							<%
							String combinedImageURL = "";
							if((medOverDue > 0) && (abnormalResCnt > 0) && (pubResCnt > 0)){
								combinedImageURL = "../images/mod_abresults_pubresults.png";
							}else{
								if((medOverDue > 0) && (abnormalResCnt > 0)){
									combinedImageURL = "../images/mod_abresults.png";
								}else if((medOverDue > 0) && (pubResCnt > 0)){
									combinedImageURL = "../images/mod_pubresults.png";
								}else if((abnormalResCnt > 0) && (pubResCnt > 0)){
									combinedImageURL = "../images/abresults_pubresults.png";
								}else{
									if(medOverDue > 0){
										combinedImageURL = "../images/mod.png";
									}else if(abnormalResCnt > 0){
										combinedImageURL = "../images/abresults.png";
									}else if(pubResCnt > 0){
										combinedImageURL = "../images/pubresults.png";
									}
								}
							}
							
							if(!combinedImageURL.trim().equals("")){
							%>
							<img src="<%=combinedImageURL %>"/>
							<%
							}
							%>
							
							<%
							if(ordersCnt > 0){
							%>
							<img src="../images/PendingOrders.png"/>	
							<%
							}
							%>		
							
						</td>
					  </tr>
				</table>
			</div> 
			<div class='informationbg'>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="informationcontent" >
						<tr>
							<td width='35%' class='labeltooltipdata'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
							<td width='2%'  ><b>:</b></td>
							<td width='63%' class='labeltooltipdata'><%=practitioner_name%></td>
						</tr>
						<tr>
							<td width='35%' class='labeltooltipdata' nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
							<td width='2%' ><b>:</b></td>
							<td width='63%'  class='labeltooltipdata'><%=admissionDateTime%></td>
						</tr>
						<tr>
							<td width='35%' class='labeltooltipdata' nowrap><fmt:message key="eIP.ArrivedDateTime.label" bundle="${ip_labels}"/></td>
							<td width='2%' ><b>:</b></td>
							<td width='63%'  class='labeltooltipdata'><%=bed_alloc_date_time%></td>
						</tr>
						<tr>
							<td width='35%'  class='labeltooltipdata' nowrap><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></td>
							<td width='2%' ><b>:</b></td>
							<td width='63%'  class='labeltooltipdata'><%=expDischargeDateTime%></td>
						</tr>
				</table>		
			</div>
		</div>
		<div class='trnsdiv'>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" >
				<tr>
					<td align="left" valign="top" class="Transactions"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
                <td align="center" valign="top" class="Transactionsmenu">
	<%
		//StringTokenizer tokenizer= new StringTokenizer(retVal,"||");
		String displayFun="";
		String jsFunName="";
		final String MODE = "modal";
		
		
		// error handling
		if(transListResponse == null || !transListResponse.isSuccessful()){
			String errorMessage = null;
			if(transListResponse == null){
				 errorMessage = BundleManager.getInstance().
							getMessageFromResourceBundle(TransactionListResourceConstants.
									DISPLAY_NO_DATA_KEY, TransactionListResourceConstants.
									RBT_RESOURCE_MESSAGE_FILE_PATH);
			}else if(!transListResponse.isSuccessful()){
				errorMessage = transListResponse.getErrorMessage();
			}
			
			%>
			<div>
			 <span style="color:#000000"><%=errorMessage %></span>
			</div>
			
			<%
		}else{
			List<Transaction> transactionList = transListResponse.getTransactionList();
			String functionId = null;
			// list will have data - just render it
			for(Transaction transaction : transactionList){
				functionId = transaction.getFunctionId();
				if(TransactionListConstants.ASSIGN_TREAT_PRACT_FUNC_ID.
						equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.AssignTreatingPractitioner.label","Common");
					jsFunName="assignTreatingPract";
				%>
				<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=practitioner_id%>')"><b><%=displayFun%></b></div>
				<%	
				} else if(TransactionListConstants.CANCEL_ADM_FUNC_ID.equalsIgnoreCase(functionId)){
					
					final String CALL_FROM = "IP";
					final String CALL_FUNCTION = "CancelAdmissionMain.jsp";
					final String JSP_NAME = CALL_FUNCTION;
					final String P_SERVICE_TYPE = "";
					
					final String PATIENT_CHECKIN_ALLOWED_DEFAULT = "N";
					displayFun = MessageManager.getLabel(locale,"Common.CancelAdmission.label","Common");
					PatientCheckInStatusRequest patCheckInStatusRequest = new PatientCheckInStatusRequest();
					patCheckInStatusRequest.setFacilityId(facility_id);
					PatientCheckInController controller = new PatientCheckInController();
					PatientCheckInStatusResponse patCheckInStatusResponse = 
							controller.getPatientCheckInStatus(patCheckInStatusRequest);
					String patCheckInAllowedYN = null;
					if(patCheckInStatusResponse != null){
						patCheckInAllowedYN = patCheckInStatusResponse.getPatientCheckedInStatus();
					}
					if(patCheckInAllowedYN == null || patCheckInAllowedYN.trim().equals("")){
						patCheckInAllowedYN = PATIENT_CHECKIN_ALLOWED_DEFAULT;
					}
					
				%>
					<div class='IPOPRS' onclick="cancelAdmission('<%=nursing_unit%>','<%=encounter_id%>','<%=patient_id%>','<%=practitioner_id %>','<%=CALL_FROM%>','<%=CALL_FUNCTION%>','<%=JSP_NAME%>','<%=gender%>','<%=patCheckInAllowedYN %>','<%=P_SERVICE_TYPE%>','<%=MODE%>')"><b><%=displayFun%></b></div>
				<%	
				}else if(TransactionListConstants.PREP_DISCH_ADV_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"eIP.PrepareDischargeAdvice.label","IP");
					jsFunName="PrepDischrgAdvice";
				%>	
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>')"><b><%=displayFun%></b></div>
				<%	
				}else if(TransactionListConstants.CANC_DISCH_ADV_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.CancelDischargeAdvice.label","Common");
					jsFunName="CancelDischrgAdvice";
				%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>')"><b><%=displayFun%></b></div>	
				<%	
				}else if(TransactionListConstants.DISCH_PATIENT_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.DischargePatient.label","Common");
					jsFunName="DischargePatient";
				%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>')"><b><%=displayFun%></b></div>
				<%	
				}else if(TransactionListConstants.ADM_PATIENT_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = MessageManager.getLabel(locale,"Common.AdmitPatient.label","Common");
					jsFunName="admitPatient";
				%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=appl_patient_class%>','<%=bedNo%>')"><b><%=displayFun%></b></div>
				<%	
				} else if(TransactionListConstants.ASSIGN_BED_FUNC_ID.equalsIgnoreCase(functionId)){
					displayFun = BundleManager.getInstance().getMessageFromResourceBundle(
							TransactionConstants.ASSIGNBED_MARKARRIVAL_BUNDLE_KEY, 
							TransactionConstants.TRANS_LABELS_RES_FILE_PATH);
					final String SHOW_NU_POPUP = "N";
					final String SHOW_SPECIALTY_POPUP = "Y";
				%>
				<%--	<div class='IPOPRS' onclick="assignbed('<%=nursing_unit%>','<%=nursing_unit_desc%>','<%=specialtyCode%>','<%=specialtyDesc%>','<%=SHOW_NU_POPUP%>','<%=SHOW_SPECIALTY_POPUP%>')"><b><%=displayFun%></b></div> --%>
				<%	
				}
			
			}
		%>
		
		<%
		//switch case comparison is only for int in swicth(int), but from java 7 for strings also we can use
		 %>
		<%-- while(tokenizer.hasMoreTokens()){ 
			String token=tokenizer.nextToken();
			displayFun="";
			jsFunName="dummyFun";			
			if(!token.equals("*")){
				if(token.equals("BOOKING")){
					displayFun = MessageManager.getLabel(locale,"Common.CreateBooking.label","Common");
					jsFunName="createBooking";
					final String FUNCTION_ID = "BOOKING";
					final String FUNCTION_NAME = "Create Booking";
					final String FUNCTION_TYPE = "F";
					final String MODULE_ID = "IP";
					final String MENU_ID = "IP";
					final String ACCESS_RIGHTS_MENU_ID = "IP_BOOKING";
					%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=roomNumber %>','<%=roomName %>','<%=bed_no%>','<%=bed_class %>','<%=bed_type %>','<%=nursing_unit%>','<%=nursing_unit_desc %>','<%=FUNCTION_ID %>','<%=FUNCTION_NAME%>','<%=FUNCTION_TYPE%>','<%=MODULE_ID%>','<%=MENU_ID%>','<%=ACCESS_RIGHTS_MENU_ID%>','<%=GBMConstants.GBM_MODULE_IDENTIFIER%>','<%=CreateBookingConstants.CREATE_BOOKING_KEYWORD%>')"><b><%=displayFun%></b></div>
					<%
				}else if(token.equals("ASSIGN_TREAT_PRACT")){
					displayFun = MessageManager.getLabel(locale,"Common.AssignTreatingPractitioner.label","Common");
					jsFunName="assignTreatingPract";
					%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=practitioner_id%>')"><b><%=displayFun%></b></div>
					<%
				}else if(token.equals("CANCEL_ADMN")){
					final String CALL_FROM = "IP";
					final String CALL_FUNCTION = "CancelAdmissionMain.jsp";
					final String JSP_NAME = CALL_FUNCTION;
					final String P_SERVICE_TYPE = "";
					
					final String PATIENT_CHECKIN_ALLOWED_DEFAULT = "N";
					displayFun = MessageManager.getLabel(locale,"Common.CancelAdmission.label","Common");
					PatientCheckInStatusRequest patCheckInStatusRequest = new PatientCheckInStatusRequest();
					patCheckInStatusRequest.setFacilityId(facility_id);
					PatientCheckInController controller = new PatientCheckInController();
					PatientCheckInStatusResponse patCheckInStatusResponse = 
							controller.getPatientCheckInStatus(patCheckInStatusRequest);
					String patCheckInAllowedYN = null;
					if(patCheckInStatusResponse != null){
						patCheckInAllowedYN = patCheckInStatusResponse.getPatientCheckedInStatus();
					}
					if(patCheckInAllowedYN == null || patCheckInAllowedYN.trim().equals("")){
						patCheckInAllowedYN = PATIENT_CHECKIN_ALLOWED_DEFAULT;
					}
					%>
					<div class='IPOPRS' onclick="cancelAdmission('<%=nursing_unit%>','<%=encounter_id%>','<%=patient_id%>','<%=practitioner_id %>','<%=CALL_FROM%>','<%=CALL_FUNCTION%>','<%=JSP_NAME%>','<%=gender%>','<%=patCheckInAllowedYN %>','<%=P_SERVICE_TYPE%>','<%=MODE%>')"><b><%=displayFun%></b></div>
					<%
				}
				/* else if(token.equals("CANCEL_ADMN")){
					displayFun = MessageManager.getLabel(locale,"Common.CancelAdmission.label","Common");
				} */
				else if(token.equals("EXPECTED_DISCHARGE")){
					displayFun = MessageManager.getLabel(locale,"Common.record.label","Common")+" "+MessageManager.getLabel(locale,"eIP.ExpectedDischarge.label","IP");
				}else if(token.equals("PRACTITIONER_TRANSFER")){
					displayFun = MessageManager.getLabel(locale,"Common.practitioner.label","Common")+MessageManager.getLabel(locale,"Common.Transfer.label","Common");
				}else if(token.equals("TRANSFER_PATIENT")){
					displayFun = MessageManager.getLabel(locale,"eIP.PatientTransfer.label","IP");
				}else if(token.equals("REQ_FOR_TFR")){
					displayFun = MessageManager.getLabel(locale,"eIP.RequestTransfer.label","IP");
					%>
					<div class='IPOPRS' onclick="requestForTransfer('<%=facility_id%>','<%=encounter_id%>','<%=patient_id%>','<%=practitioner_id %>','<%=nursing_unit%>','<%=gender%>','<%=bedNo%>','<%=MODE%>')"><b><%=displayFun%></b></div>
					<%
				}else if(token.equals("TFR_PAT_OUT")){
					displayFun = MessageManager.getLabel(locale,"eIP.TransferedOut.label","IP");
				}else if(token.equals("PRE_DIS_ADVICE")){
					displayFun = MessageManager.getLabel(locale,"eIP.PrepareDischargeAdvice.label","IP");
					jsFunName="PrepDischrgAdvice";
					%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>')"><b><%=displayFun%></b></div>
					<%					
				}else if(token.equals("CAN_DIS_ADVICE")){
					displayFun = MessageManager.getLabel(locale,"Common.CancelDischargeAdvice.label","Common");
					jsFunName="CancelDischrgAdvice";
					%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>')"><b><%=displayFun%></b></div>
					<%
				}else if(token.equals("DISCHARGE_CHKLIST")){
					displayFun = MessageManager.getLabel(locale,"eIP.DischargeCheckList.label","IP");
				}else if(token.equals("DISCHARGE_PATIENT")){
					displayFun = MessageManager.getLabel(locale,"Common.DischargePatient.label","Common");
					jsFunName="DischargePatient";
					%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>')"><b><%=displayFun%></b></div>
					<%
				}else if(token.equals("ADMISSION")){
					displayFun = MessageManager.getLabel(locale,"Common.AdmitPatient.label","Common");
					jsFunName="admitPatient";
				%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=appl_patient_class%>','<%=bedNo%>')"><b><%=displayFun%></b></div>
				<%
				}				
			}
		} --%>
		
		<%
		if(!encounter_id.equals("")){%>
			<div class='IPOPRS' onclick="patientChart('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=pend_ord_stats%>','<%=pat_dtls_unknown%>','<%=finalize_yn%>','<%=user_id%>')"><b>Patient Chart</b></div>
		<%}else{
			HashMap retMap=eIP.IPAdvBedMgmtBean.getAssignedBedForAdmission(con,pstmt,rs,facility_id,nursing_unit,bedNo,user_id,operStnId);
			if(retMap!=null){
				patient_id=(String)retMap.get("patient_id");
				encounter_id=(String)retMap.get("encounter_id");
				displayFun = MessageManager.getLabel(locale,"eIP.assignbedmarkpatientarrival.label","IP");
				jsFunName="AssignBedMarkArrival";
				%>
					<div class='IPOPRS' onclick="<%=jsFunName%>('<%=facility_id%>','<%=nursing_unit%>','<%=patient_id%>','<%=encounter_id%>','<%=operStnId%>','<%=user_id%>')"><b><%=displayFun%></b></div>
				<%
			}else{

			}
		  }
		
		}
		%>			
		</td>
            </tr>
		</table>
	</div>
	<div class='Footerbg'></div>
	</div>
  <%  
	}catch(Exception ex){
				ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(con != null)  ConnectionManager.returnConnection(con,request);
	}
  %>
</body>


</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>





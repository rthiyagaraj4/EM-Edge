<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<%@ page  import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eOT.OperationDtlBean,eOT.Common.OTRepository,java.util.ArrayList,eOR.OrderEntryBillingQueryBean,eOT.Common.*,eCommon.Common.CommonBean,,eOT.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
    String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 
	String or_bean_id 				    = "orderentrybean";
    String or_bean_name 			    = "eOR.OrderEntryBean";
%>
<head>
<TITLE>
<fmt:message key="Common.booking.label" bundle="${common_labels}"/>
</TITLE>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type='text/javascript' src='../../eOT/js/BookingPatientSearch.js'></script>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script type='text/javascript' src='../../eOT/js/OTPatientSearch.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->
<script > var lblPreOperDiag=getLabel("eOT.PreOperativeDiagnosis.Label","OT");</script>
<!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->
<script language='javascript'>
var preOperativeDiag_value= getLabel("eOT.PreOperativeDiagnosis.Label","OT");
var remarks_value=getLabel("Common.remarks.label","common");
var preOperDiagArray = ["surgeonType" , "episode_type" , "patient_id" , "SPECIALITY_DESC" , "Source_code" ];
	//Checking Discharge Advice - Rajesh V 10/11/2012
	function callDischargeChk(){
		var dis_encounter_id = document.getElementById("encounter_id").value;
		var dis_pat_class = document.getElementById("episode_type").value;
		var facilityid = document.PreOperHdr.facility_id.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=discharge_check&dis_encounter_id="+dis_encounter_id+"&dis_patient_class="+dis_pat_class+"&dis_facility_id="+facilityid;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		if(retVal>0){
			alert(getMessage("DIS_ADVICE_ALREAD_EXISIT","IP"));
			var formObj = document.PreOperHdr;
			formObj.patient_id.value="";
			formObj.patient_name.value="";
			formObj.sex.value="";
			formObj.date_of_birth.value="";
			formObj.encounter_id.value="";
			formObj.episode_id.value="";
			formObj.visitid.value="";
			clearSource();
		}
	}
	//Checking Discharge Advice - Rajesh V 10/11/2012
	function clearSource(){
		var frmObj=document.forms[0];
		frmObj.Source_code.value='';
		frmObj.sourceDesc.value='';
		frmObj.changed_sourceType.value='';
	}	

	//Modified by lakshmi against jordan migration issue
	function changeSourceType(){
		clearSource();
		patient_class_code=document.forms[0].patient_class_code.value;
		var val=	document.getElementById("episode_type").value;
		var patient_class_code1=patient_class_code.split("$$");
		if(val==""){
			document.getElementById("sourceType").value="";
			//document.getElementById("sourceTypeDesc").value=getLabel("Common.defaultSelect.label","Common");
			document.getElementById("sourceTypeDesc").value =""; //Rameez changed against 39540 on 26-04-2013
			document.getElementById("sourceType").disabled=true;
			document.getElementById("more_img").style.visibility= 'hidden';
	   }
		
	if(val=='DC'||val=='IP'){
		document.getElementById("sourceType").value="W";
		document.getElementById("sourceTypeDesc").value=getLabel("Common.nursingUnit.label","Common");
		document.getElementById("sourceType").disabled=true;
		document.getElementById("more_img").style.visibility= 'visible';//GHL-CRF-0356
		}
		
	if(val=='EM'||val=='OP'){
		document.getElementById("sourceType").value="C";
		document.getElementById("sourceTypeDesc").value=getLabel("Common.clinic.label","Common");
		document.getElementById("sourceType").disabled=true;
		document.getElementById("more_img").style.visibility= 'visible';//GHL-CRF-0356
		}

	if(val=='XT'){
			document.getElementById("sourceType").value="E";
			document.getElementById("sourceTypeDesc").value=getLabel("Common.referral.label","Common");
			document.getElementById("sourceType").disabled=true;
			document.getElementById("more_img").style.visibility= 'hidden';
		}
		document.getElementById("changed_sourceType").value=document.getElementById("sourceType").value;
		document.getElementById("changed_sourceTypeDesc").value=document.getElementById("sourceTypeDesc").value;
	}

	function clearDesc(){
		var formObj = document.forms[0];
		var pat_id=formObj.patient_id.value;
		if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")

		formObj.patient_name.value="";
		formObj.sex.value="";	
		formObj.date_of_birth.value="";
		//Modified by DhanasekarV against CRF_0859 2/12/2010
		formObj.encounter_id.value="";
		formObj.episode_id.value="";
		formObj.visitid.value="";
		clearSource();
	}
	function callLongRefName(){

	}
</script>
</head>

<body onLoad='setInitialValue();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<form name='PreOperHdr' id='PreOperHdr' method='POST' action='../../eOT/jsp/OperationProcedureHdr.jsp'>
  <%@ include file="..//..//eCommon//jsp//Common.jsp"%>
  <% 
	String end_time=checkForNull(request.getParameter("end_time"));
	request.setCharacterEncoding("UTF-8");
	//String surgeryType =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels")+",";
	String male =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+",";
	String female =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+",";
	String unknown =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels")+",";
	String bean_id = "OperationDtlBean";
	String bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);
	chk_bean.clear();
	String mode=CommonRepository.getCommonKeyValue("MODE_INSERT");
	String strBookingDate="",strSurgeonName="",strSurgeonCode="",strStartTime="",strSurgeryType="",strRoomDesc="",strNatureType="",strRoomCode="",strNatureCode="",strSpecialityDesc="",strPrefDate="",strSpecialityCode="",strWaitListNo="",strName="",strWaitListYN="",strAge="",strSex="",strIpBookingYN="",strPatientId="",strFacilityId="",strNursingUnit="",strEncounterId="",strBookingNum="",strHiddenTime="",strEpisodeType="",strOrderId="",strOrderTypeCode="",strEpisodeId="",strPatientClass="",strVisitId="",strReferalSource="",strRefSourceCode="",strAnesthesiaCode="",strPatientPosition="",strPositionCode="",strReferalDesc="", strSpecialityYN="",strPreOperDiag="",strAsstSurgeonCode="", patient_class_code="",PatIDLen="",sourceTypeDesc="";  
String ammendBooking = ""; //ChAiTu
String chkBookingExistDays = ""; //ChAiTu
	String PreOpPreparationDays = "";
	String selSurgeonCode = ""; // 051911
	String anaes_review1 = "A";//Added by sanjay for Anaesthesia Required Checkbox against IN032063
	String performingLocation = "";//Added for CRF 298
	// Added for CRF-21 OverBooking Cases

	String over_booking_case_yn=checkForNull(request.getParameter("over_booking_case_yn"));
	over_booking_case_yn=over_booking_case_yn==null?"N":over_booking_case_yn;
	over_booking_case_yn=over_booking_case_yn.equals("null")?"N":over_booking_case_yn;
	over_booking_case_yn=over_booking_case_yn.equals("")?"N":over_booking_case_yn;
	// CRF-21 Added till here
	strSpecialityYN=checkForNull(request.getParameter("speciality_access"));
	strOrderId=checkForNull(request.getParameter("orderid"));
String selOrderIds = checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
String ammendFlag = checkForNull(request.getParameter("ammendFlag")); // ChAiTu - 186
String selBookingNumber = checkForNull(request.getParameter("selBookingNumber")); // ChAiTu - 186
System.out.println("=======selOrderIds===OperationProcedureHdr.jsp====="+selOrderIds);
System.out.println("=======ammendFlag===OperationProcedureHdr.jsp====="+ammendFlag);
System.out.println("=======selBookingNumber===OperationProcedureHdr.jsp====="+selBookingNumber);
	strBookingNum=checkForNull(request.getParameter("booking_num"));
System.out.println("=======strBookingNum===OperationProcedureHdr.jsp====="+strBookingNum);
	String called_from=checkForNull(request.getParameter("called_from"));
	strBookingDate=checkForNull(request.getParameter("booking_date"));
	strStartTime=checkForNull(request.getParameter("start_time"));
	strHiddenTime=checkForNull(request.getParameter("hidden_time"));
	String disable_flag = (!strOrderId.equals("") )?"disabled":"";
	strRoomDesc=checkForNull(request.getParameter("roomDesc"));
	strRoomCode=checkForNull(request.getParameter("roomCode"));
	strSpecialityDesc=checkForNull(request.getParameter("speciality_desc"));
	strSpecialityCode=checkForNull(request.getParameter("speciality_code"));
	strPatientClass=checkForNull(request.getParameter("episode_type"));
	strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
	selSurgeonCode=checkForNull(request.getParameter("selSurgeonCode"));// 051911
	System.err.println("191 selSurgeonCode=================>"+selSurgeonCode);
	//selSurgeonCode=selSurgeonCode.equals("null")?"":strSurgeonCode; //ML-BRU-SCF-1640 [IN056671]//186
	
	if(selSurgeonCode.equals("null")) selSurgeonCode=strSurgeonCode;
	
	
	strSurgeonCode=strSurgeonCode==null?"":strSurgeonCode;
	strSurgeonCode=strSurgeonCode.equals("null")?"":strSurgeonCode;
	//strSurgeonCode=strSurgeonCode.equals("*ALL")?"":strSurgeonCode; //050456 
	strSurgeonName=checkForNull(request.getParameter("surgeonName"));
	strSurgeonName=strSurgeonName==null?"":strSurgeonName;
	strSurgeonName=strSurgeonName.equals("null")?"":strSurgeonName;
	strSurgeonName=strSurgeonName.equalsIgnoreCase("ALL")?"":strSurgeonName;//186
	strSurgeonName=strSurgeonName.equalsIgnoreCase("ALL")?selSurgeonCode:strSurgeonName;//186
	
	strPatientId=checkForNull(request.getParameter("patient_id"));
	strSurgeryType=checkForNull(request.getParameter("surgeonType"));
	strNatureCode=checkForNull(request.getParameter("natureCode"));
	strNatureType=checkForNull(request.getParameter("natureType"));
	strVisitId=checkForNull(request.getParameter("visitid"));
	strAsstSurgeonCode=checkForNull(request.getParameter("asst_surgeon_code")); //add for asst surgeon
	/*Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063*/
	String strAnesReqYN = "";
	String chkReferalDisable = "";//GHL-CRF-0356
	int strAnesReqYNPending = 0;
	String strSpeciality_temp="",strAnesthetit_temp="",strAnesthesia_temp="",strAnaesthetistCode="",strAnesthetit_temp1="",strAnesthesia_temp1="";
	String strOrderPract= "";
	//Added Against ML-MMOH-CRF-1939-US2...starts
	//String Include_Fpp_yn = "";
	boolean isIncludeFpp = false;
	boolean bill_flag = false;
	//Integer count =0;
    //Added Against ML-MMOH-CRF-1939-US2...ends
System.out.println("228,strSpeciality_temp===="+strSpeciality_temp);
strSpeciality_temp=checkForNull(request.getParameter("SPECIALITY_DESC"));
System.out.println("230,strSpeciality_temp===="+strSpeciality_temp);
if(strSpecialityDesc.length()>0)
	strSpeciality_temp=strSpecialityDesc;
if(strSpecialityCode.length()==0)
{
	strSpecialityCode=checkForNull(request.getParameter("SPECIALITY_CODE"));
}

	strAnesthetit_temp1=checkForNull(request.getParameter("Anaesthetiest2_code"));
	strAnesthetit_temp=checkForNull(request.getParameter("Anaesthetiest1_code"));
	strAnesthesia_temp1=checkForNull(request.getParameter("Anaesthetia1_code"));
	strAnesthesia_temp=checkForNull(request.getParameter("Anaesthetia_code"));
	HttpSession httpSession = request.getSession(false);		
	strFacilityId=""+httpSession.getValue("facility_id"); 	
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String sql="";
try{	
	 con = ConnectionManager.getConnection(request);
	 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	 pstmt=con.prepareStatement(sqlLen);
	 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
		{
			PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
		}
	 if(rs!=null) rs.close();
	 if(pstmt!=null) pstmt.close();
	
	//for getting facilityName
	if(strFacilityId.length()>0){
		// To check if Anesthesia is Enabled at Speciality level
		 String sqlFacilityName="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID = ?";		 
		 pstmt = con.prepareStatement(sqlFacilityName);
		 pstmt.setString(1,strFacilityId);		 
		 rs=pstmt.executeQuery();		 
		 if(rs.next()==true){			 
			 performingLocation=rs.getString(1);			 
		  }
		 if(rs!=null)	rs.close();
		 pstmt.close();
	}
	if(strSpecialityCode.length()>0){
		/*Added by Sanjay for Anaesthesia Required Checkbox agaisnt IN032063 STARTS here*/
		// To check if Anesthesia is Enabled at Speciality level
		 String sqlAnesReq="SELECT NVL(ANAESTHESIA_REVIEW_REQD_YN,'N') FROM OT_SPECIALITIES WHERE SPECIALITY_CODE = ?";		 
		 pstmt = con.prepareStatement(sqlAnesReq);
		 pstmt.setString(1,strSpecialityCode);		 
		 rs=pstmt.executeQuery();		 
		 if(rs.next()==true){			 
			 strAnesReqYN=rs.getString(1);			 
		  }
		 if(rs!=null)	rs.close();
		 pstmt.close();
	}
	
	if (strOrderId.length() > 0){
		// To check whether Anesthesia Review is checked when it was ordered in CA. For Pending Orders screen
		String sqlAnesReq1="SELECT COUNT(*) FROM AT_PENDING_ORDERS WHERE SOURCE_ORDER_ID = ?";		 
		pstmt = con.prepareStatement(sqlAnesReq1);
		pstmt.setString(1,strOrderId);		 
		rs=pstmt.executeQuery();		 
		if(rs.next()==true){
			strAnesReqYNPending=rs.getInt(1);			 
		}
		if(rs!=null)	rs.close();
		pstmt.close();		 
	}
		sql = "select NVL(IPBOOKING_WITH_THEATRE_YN,'N') BOOKING_YN,nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days from ot_param_for_facility where OPERATING_FACILITY_ID=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			 strIpBookingYN=checkForNull(rs.getString("BOOKING_YN"));		 
			 ammendBooking = checkForNull(rs.getString("ammend_bookings"));
			 chkBookingExistDays = checkForNull(rs.getString("chk_bookings_exist_days"));
		}
		System.out.println("===ammendBooking===OperationProcedureHdr.jsp=="+ammendBooking);
		System.out.println("===chkBookingExistDays==OperationProcedureHdr.jsp==="+chkBookingExistDays);
		if(rs!=null)   rs.close();	  
		pstmt.close();

if(strOrderId.length()>0)
{
	sql=OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT1");

    pstmt1 = con.prepareStatement(sql);
	pstmt1.setString(1,strOrderId);
	rs=pstmt1.executeQuery();
	if(rs.next()){
		strFacilityId=checkForNull(rs.getString("PERFORMING_FACILITY_ID1"));
		strOrderTypeCode=checkForNull(rs.getString("ORDER_TYPE_CODE1"));
		if(strSurgeonCode.length()==0)
		{
			strSurgeonCode=checkForNull(rs.getString("PERFORMING_TEAM_SURGEON1"));
		    strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
			/*Added by Suma on march 3 2010 for hadling defaulting of specialty in booking screen when called from CA*/
		    strSpeciality_temp=checkForNull(rs.getString("SPECIALITY_DESC"));	
			/*Added by Suma ends here*/
	    }

		
		if(strSpecialityCode.length()==0) {
			sql="SELECT A.SPECIALITY_CODE SPECIALITY_CODE1 ,B.SHORT_DESC SPECIALITY_DESC1 FROM OT_SPECIALITY_ORDER_TYPES A,AM_SPECIALITY B WHERE ORDER_TYPE_CODE = ? and A.SPECIALITY_CODE=B.SPECIALITY_CODE";
			 pstmt = con.prepareStatement(sql);

			 pstmt.setString(1,strOrderTypeCode);
			 rs1=pstmt.executeQuery();
			 if(rs1.next()==true){
				 strSpecialityCode=rs1.getString("SPECIALITY_CODE1");
				 strSpeciality_temp=rs1.getString("SPECIALITY_DESC1");
			  }
			 if(rs1!=null)	rs1.close();
			 pstmt.close();					 
		}
		
		strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		strNatureType=checkForNull(rs.getString("NATURE_TYPE1"));	
		strEpisodeId=checkForNull(rs.getString("EPISODE_ID1"));
		strPatientClass=checkForNull(rs.getString("PATIENT_CLASS1"));
		strEncounterId=checkForNull(rs.getString("ENCOUNTER_ID1")); 
		strEpisodeType=checkForNull(rs.getString("EPISODE_TYPE1")); 
		strVisitId=checkForNull(rs.getString("VISIT_ID1"));
		strNatureCode= checkForNull(rs.getString("SURGERY_NATURE1"));
		strReferalSource=checkForNull(rs.getString("REF_SOURCE_TYPE1"));
		if(strReferalSource != null && strReferalSource.equals("R"))//GHL-CRF356
		strReferalSource = "E"; //GHL-CRF 356
		strRefSourceCode=checkForNull(rs.getString("REF_SOURCE_CODE1"));
		strAnesthesiaCode=checkForNull(rs.getString("ANAESTHESIA_CODE1")); 
		strAnaesthetistCode=checkForNull(rs.getString("ANAESTHETIST_CODE1")); 
		strPositionCode=checkForNull(rs.getString("PATIENT_POSITION1"));
		strPrefDate=checkForNull(rs.getString("PREF_SURG_DATE1"));
		rs.close();
		pstmt1.close();
	
	//pre-operative Diagnosis
	if(strOrderId.length()>0){
		sql="SELECT ORDER_COMMENT FROM OR_ORDER_COMMENT WHERE ORDER_ID = ? AND ACTION_SEQ_NUM=(SELECT MAX(ACTION_SEQ_NUM) FROM OR_ORDER_COMMENT WHERE ORDER_ID = ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strOrderId);
		pstmt.setString(2,strOrderId);
		rs1=pstmt.executeQuery();
		Clob clob= null;
		while(rs1.next()){
			clob = rs1.getClob("ORDER_COMMENT");
			strPreOperDiag = clob.getSubString(1,(int)clob.length());
		}
		rs1.close();
 		pstmt.close();
	
	}
		if(strPreOperDiag.length()>500)
	    strPreOperDiag=strPreOperDiag.substring(0,500);
//Anesthesia Desc

	if(strAnesthesiaCode.length()>0){
		strAnesthesia_temp=strAnesthesiaCode;
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT2");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strAnesthesiaCode);
		rs1=pstmt.executeQuery();
		if(rs1.next()==true)
  			strAnesthesia_temp1=checkForNull(rs1.getString("short_desc1"));
			rs1.close();
 			pstmt.close();
		}

		//Aneasthetist code
		if(strAnaesthetistCode.length()>0){
			strAnesthetit_temp=strAnaesthetistCode;
			sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT3");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,strFacilityId);
			pstmt.setString(2,strAnaesthetistCode);
			rs1=pstmt.executeQuery();
			if(rs1.next()==true)
			strAnesthetit_temp1=checkForNull(rs1.getString("short_name1"));
			rs1.close();
			pstmt.close();
		}
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT4");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strSurgeonCode);
		rs1=pstmt.executeQuery();
		if(rs1.next()==true)
		  strSurgeonName=checkForNull(rs1.getString("SHORT_NAME1"));
		rs1.close();
		pstmt.close();

	if(strNatureCode.length()>0){
		 sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT5");
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,strNatureCode);
		 rs1=pstmt.executeQuery();
		 if(rs1.next()==true)
		  strSurgeryType=rs1.getString("SHORT_DESC1");
		  rs1.close();
		  pstmt.close();
	 }

	if(strPositionCode.length()>0){
		String sql_position="SELECT SHORT_DESC SHORT_DESC1   FROM OT_POSITION_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(STATUS,'E') = 'E' and POSITION_CODE=?";
		sql=""+sql_position;
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,strPositionCode);
		 rs1=pstmt.executeQuery();
		 if(rs1.next()==true)
		 strPatientPosition=rs1.getString("SHORT_DESC1");
		 rs1.close();
		 pstmt.close();
	 }
	}          
  rs.close();
  pstmt1.close();
}

	//Added by Anitha on 12/6/2010 start
	String PreOpQuery = "select nvl(ORDER_FIELD_VALUE,0) PreOpPrepDays from or_order_field_values where order_id = '"+strOrderId+"' and ORDER_FIELD_MNEMONIC ='PRE_OP_DAYS'";
	pstmt=con.prepareStatement(PreOpQuery);
		 rs=pstmt.executeQuery();
		 while(rs.next() && rs!=null)
		{
		 PreOpPreparationDays   = (rs.getString("PreOpPrepDays")==null)?"":rs.getString("PreOpPrepDays");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	//end
	//try{

		if(strPatientId!=null && !strPatientId.equals("")){
			if(strOrderId.length()==0){ // When called from Direct Booking, get the defaulted sourceType
				sourceTypeDesc=checkForNull(request.getParameter("changed_sourceTypeDesc"));
				strReferalSource=checkForNull(request.getParameter("changed_sourceType"));

			}

		if("IP".equals(strPatientClass) || "DC".equals(strPatientClass) ){
			sql="SELECT 'W',NVL(TO_NURSING_UNIT,  FR_NURSING_UNIT_CODE)   FROM IP_ADT_TRN WHERE PATIENT_ID 	= ? AND   FACILITY_ID = ? AND  TRN_TYPE IN ('A', 'D', 'T') AND   TRN_DATE_TIME = (SELECT MAX(TRN_DATE_TIME) FROM IP_ADT_TRN  WHERE PATIENT_ID = ? AND  FACILITY_ID = ?   AND TRN_TYPE IN ('A', 'D', 'T'))";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,strPatientId);
			pstmt.setString(2,strFacilityId);
			pstmt.setString(3,strPatientId);
			pstmt.setString(4,strFacilityId);
			rs=pstmt.executeQuery();
			if(rs.next())  {

				strReferalSource=checkForNull(rs.getString(1));
				strRefSourceCode=checkForNull(rs.getString(2));
			}
			if(rs!=null)	rs.close();	  
			pstmt.close();
		}
		/* start SKR-SCF-1095 [IN056871]*/
		if("OP".equals(strPatientClass) || "EM".equals(strPatientClass) ){
			sql="SELECT 'C', LOCN_CODE FROM op_patient_queue WHERE patient_id = ? AND facility_id = ? AND queue_status IN ('01', '02', '03','04','07','09','99') AND QUEUE_DATE = (SELECT MAX (QUEUE_DATE) FROM op_patient_queue WHERE patient_id = ? AND facility_id = ? AND queue_status IN ('01', '02', '03','04','07','09','99'))";
			//System.err.println("458,sql==="+sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,strPatientId);
			pstmt.setString(2,strFacilityId);
			pstmt.setString(3,strPatientId);
			pstmt.setString(4,strFacilityId);
			rs=pstmt.executeQuery();
			if(rs.next())  {
				strReferalSource=checkForNull(rs.getString(1));
				strRefSourceCode=checkForNull(rs.getString(2));
				//System.err.println("490,strReferalSource==="+strReferalSource);
				//System.err.println("491,strRefSourceCode==="+strRefSourceCode);
			}
			if(rs!=null)	rs.close();	  
			pstmt.close();
		}
		/* End SKR-SCF-1095 [IN056871]*/
	if( !strReferalSource.equals("") && !strRefSourceCode.equals("") )
	{
		if(strReferalSource.equals("W"))
			sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT7");
		else if(strReferalSource.equals("C")==true)
			sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT8");
		//else if(strReferalSource.equals("R")==true)////CRF- GHL356
		else if(strReferalSource.equals("E")==true)//CRF- GHL356
			//sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT9");
		sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE  LINKED_FACILITY_ID = ? and NVL(EFF_STATUS,'D') = 'E' AND  REFERRAL_CODE =? AND LANGUAGE_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strFacilityId);
		pstmt.setString(2,strRefSourceCode);
		pstmt.setString(3,locale);
		rs=pstmt.executeQuery();
		if( rs.next() )
			strReferalDesc=rs.getString("SHORT_DESC1");
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
	}
	
	strName=checkForNull(request.getParameter("patient_name"));
	strAge=checkForNull(request.getParameter("date_of_birth"));
	strSex=checkForNull(request.getParameter("sex"));
	//strEncounterId=checkForNull(request.getParameter("encounter_id"));
	//strEpisodeId=checkForNull(request.getParameter("episode_id"));  commented by Sathish.K on 03-03-3009 for placing out patient order  From CA  properly(while placing Visiti Financial Details Could not found is coming..encounterid going as null)
	if(strName.length()==0){
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT10");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strPatientId);
		rs=pstmt.executeQuery();
		if(rs.next()){
		 strName=checkForNull(rs.getString("SHORT_NAME1"));
		 strAge=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
		 strSex=checkForNull(rs.getString("SEX1"));
		}
		 if(strSex.equals("M")) 
			strSex=male;
		 else if(strSex.equals("F")) 
			strSex=female;
		 else   
			strSex=unknown;
		if(rs!=null)   rs.close();	  
		pstmt.close();
	if(strOrderId.length()>0){
		sql=""+OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT11");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strPatientId);
		pstmt.setString(2,strFacilityId);	
		pstmt.setString(3,strPatientId);
		pstmt.setString(4,strFacilityId);	
		rs=pstmt.executeQuery();
		if(rs.next()==true){
			strEncounterId=checkForNull(rs.getString("ENCOUNTER_ID1"));
		}
		if(rs!=null) rs.close();
		pstmt.close();
   }
   /* selvin  */
	System.err.println("before,selSurgeonCode===="+selSurgeonCode);
   	if( selSurgeonCode.equals("*ALL") || selSurgeonCode.equals("") ) //selSurgeonCode
	{
		
		sql=" select ORD_PRACT_ID from or_order where order_id= ? ";
		System.err.println("sql 569===="+sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,strOrderId);
		rs=pstmt.executeQuery();
		if( rs.next() ) {
		strOrderPract=rs.getString("ORD_PRACT_ID");
		selSurgeonCode = strOrderPract;
		}
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
	}
	
	System.err.println("After,selSurgeonCode===="+selSurgeonCode);
   

 }
 }  
	//Added Against ML-MMOH-CRF-1939-US2...starts
		
	String bean_id1 = "OTCommonBean";
	String bean_name1 = "eOT.OTCommonBean";
	OTCommonBean ot_bean = (OTCommonBean)mh.getBeanObject( bean_id1, request, bean_name1 );
	
	con = ConnectionManager.getConnection(request);
			
	//Include_Fpp_yn = bean.getIncludeFpp(facility_id);
	//System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
	isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
	//isIncludeFpp=false;
	System.err.println("isIncludeFpp --->"+isIncludeFpp);
			
	//count = bean.getFppIcon();
	bill_flag = ot_bean.getBillFlag(strFacilityId);
	
    //Added Against ML-MMOH-CRF-1939-US2...ends
   }
   catch(Exception ee){  
	   ee.printStackTrace();
	   System.err.println("exception 2 in OperationProcedureHdr.jsp "+ee);
 }finally{
	if(rs!=null) rs.close();
	if(pstmt !=null) pstmt.close();
	   ConnectionManager.returnConnection(con, request);
}
   if(strEpisodeId.length()==0) strEpisodeId=strEncounterId;
   if(strEncounterId.length()==0)strEncounterId=strEpisodeId;
   if(strWaitListNo.length()==0)  
	strWaitListYN="N";
   else	
	strWaitListYN="";
%>
  <table border='0' cellpadding=1  cellspacing='0' width='100%'>
    <tr>
      <td class='label' width='25%' ><fmt:message key="eOT.PerformingLocation.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='PerformingLocation' id='PerformingLocation' size='35' value='<%=checkForNull(performingLocation)%>' disabled></td>
      <td class='label' width='25%' >&nbsp;</td>
      <td class='fields' width='25%' >&nbsp;</td>
    </tr>
    <%
	if(strOrderId.length()==0){
%>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='BOOKING_DATE' id='BOOKING_DATE' size='35' readonly value='<%=strBookingDate%>'></td>
      <td class='label' width='25%' ><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='booking_no' id='booking_no' size='5' value='<%=checkForNull(request.getParameter("start_time"))%>' readonly></td>
    </tr>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='surgeonType' id='surgeonType' size='35'  align='left' 
			value="<%=strSurgeryType%>" onBlur="if(this.value!='')callSurgeryTypeAndValidateCutOffTime('SurgeryType');" >
        <input type='button' class='button' name='quest1' id='quest1' value='?' onClick="callSurgeryTypeAndValidateCutOffTime('SurgeryType')">
        <img src='../../eCommon/images/mandatory.gif'></img></td>
      <td class='label' width='25%' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
    <%if(isIncludeFpp && bill_flag){%> 
	 <td class='fields' width='25%' ><select name='episode_type' id='episode_type' DB_VALUE="<%=strPatientClass%>" onChange='clearPatientDetails();changeSourceType();checkEncId(this); showPreOperDiagLink(); enableProcedudureDtlFields();' <%=disable_flag%> ><!--Added Against ML-MMOH-CRF-1939-US2-->
	<%}else{%>
	<td class='fields' width='25%' ><select name='episode_type' id='episode_type' DB_VALUE="<%=strPatientClass%>" onChange='clearPatientDetails();changeSourceType();checkEncId(this); showPreOperDiagLink();' <%=disable_flag%> >
	<%}%>
        <option value="" selected>
          <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
          </option>
        <% 
				sql = "SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID= ? ORDER BY 1";
				try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,locale);
					rs = pstmt.executeQuery();
					while(rs.next()){
			             patient_class_code=patient_class_code+rs.getString(1)+"$$";
			%>
        <option value='<%=rs.getString(1)%>'><%=rs.getString(2)%></option>
        <%}
				}catch(Exception e){e.printStackTrace();}
				finally{
					try{
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(con!=null)  ConnectionManager.returnConnection(con, request);
					}catch(Exception e){e.printStackTrace();}
				}
			%>
      </select>
        <img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><!-- Checking Discharge Advice - Rajesh V 10/11/2012 --> 
        <!-- Commented the below function calls after fixing the issue--> 
        <!--<input type='text' name='patient_id' id='patient_id'maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)"  align='right'  value="<%=strPatientId%>" onBlur="if(this.value!=''){callPatSearch(); callDischargeChk();} else{clearDesc();} " >
			<input type='button' class='Button'  name='quest2' id='quest2' value='?' onClick='callPatSearch();callDischargeChk();'>-->
        <%if(isIncludeFpp && bill_flag){%> 
	   <input type='text' name='patient_id' id='patient_id'maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onKeyPress="return CheckForSpecChars(event)"  align='right'  value="<%=strPatientId%>" onBlur="if(this.value!=''){callPatSearch();} else{clearDesc();} enableProcedudureDtlFields();" ><!--Added Against ML-MMOH-CRF-1939-US2-->
		<%}else{%>
        <input type='text' name='patient_id' id='patient_id'maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onKeyPress="return CheckForSpecChars(event)"  align='right'  value="<%=strPatientId%>" onBlur="if(this.value!=''){callPatSearch();} else{clearDesc();}" >
		<%}%>
        <input type='button' class='Button'  name='quest2' id='quest2' value='?' onClick='callPatSearch();'>
        
        <!-- Checking Discharge Advice - Rajesh V 10/11/2012 --> 
        <img src='../../eCommon/images/mandatory.gif'></img></td>
      <td class='label' width='25%' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='patient_name' id='patient_name' size='35'  align='right' value='<%=strName%>' readonly></td>
    </tr>
    <tr>
      <td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
      <td class='label' width='25%'><input type='text' name='sex' id='sex' size='35'  align='right' DB_VALUE="<%=strSex%>" value='' readonly></td>
      <td class='label' width='25%' ><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='date_of_birth' id='date_of_birth' size='35'  align='right' value='<%=strAge%>' readonly></td>
    </tr>
    <tr>
      <td class="label" width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
      <td class="fields" width='25%' ><input type='text' class="fields" name='encounter_id' id='encounter_id' size='35' value='<%=strEncounterId%>' disabled>
        
        <!-- Checking Discharge Advice - Rajesh V 11/16/2012 --> 
        <!-- Commented the below function calls after fixing the issue--> 
        <!-- <input type='button' class='button' name='encounterLookUp' id='encounterLookUp' value='?' onClick='callBookingEncounterSearch(); callDischargeChk();' > -->
        
        <input type='button' class='button' name='encounterLookUp' id='encounterLookUp' value='?' onClick='callBookingEncounterSearch();enableProcedudureDtlFields()' ><!--Modified Against ML-MMOH-CRF-1939-US2-->
        
        <!-- Checking Discharge Advice - Rajesh V 11/16/2012 --> 
        <img id="enc_check" src='../../eCommon/images/mandatory.gif' style='position:absolute;visibility:visible'></img></td>
      <td class='label' width='25%' ><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='waitlist_no' id='waitlist_no' size='35'  align='left' value="<%=strRoomDesc%>"
			readonly ></td>
    </tr>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
        
        <input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='35' value="<%=strSpeciality_temp%>" onBlur="if(this.value!='')searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=''; clearSpeciality_Code(this); anesthesiaRequiredYN(); " >
        <input type='button' class='button'  value='?' onClick="searchSpeciality(SPECIALITY_DESC);anesthesiaRequiredYN(SPECIALITY_DESC);" >
        
        <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> 
        <img src='../../eCommon/images/mandatory.gif'></img></td>
      <td class='label' width='25%' ><fmt:message key="Common.PatientPosition.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='Position_desc' id='Position_desc' size='35'  align='right' value ='<%=strPatientPosition%>' onBlur="if(this.value!='')searchposition(Position_desc);">
        <!--name='Source Type'-->
        <input type='button' class='Button'  name='quest5' id='quest5' value='?' onClick="searchposition(Position_desc)">
        <input type='hidden' name='Patient_position' id='Patient_position' value='<%=strPositionCode%>'></td>
    </tr>
    <tr>
      <td class='label' ><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
      <td class='fields' ><input type='text' name='order_id' id='order_id' size='35'  align='left'	value="<%=strSurgeonName%>"
			readonly ></td>
      <td class='label' ><fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/></td>
      <td class='fields' ><input type='text' name='asst_surgeon_name' id='asst_surgeon_name' maxlength='20' size='35' value= "" onBlur="if(this.value!='')searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code);else asst_surgeon_code.value='' ">
        <input type='hidden' name='asst_surgeon_code' id='asst_surgeon_code' maxlength='20' size='20' value= "<%=strAsstSurgeonCode%>" >
        <input type='button' class='button' value='?' name='AssSurButton' id='AssSurButton' onClick="searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code);"></td>
    </tr>
    <tr>
      <td class='label' ><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
      <td colspan="3" class='fields'>
        <input type='hidden' name='sourceType' id='sourceType'  DB_VALUE='<%=strReferalSource%>' value='<%=strReferalSource%>'  >
        <input type='text' name='sourceTypeDesc' id='sourceTypeDesc' size='35'  value="<%=sourceTypeDesc%>" disabled>
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type='text' name='Source_code' id='Source_code' size='45' value='<%=strReferalDesc%>' onBlur="if(this.value!='') searchSourceTypeSelect(Source_code);else callchangeMoreIcon();">
        <input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchSourceTypeSelect(Source_code)">
        <!--GHL-CRF-0356-->
        <!-- <div id='more_img' style='position:absolute;visibility:hidden;'> --> <img id='more_img' src='../../eCommon/images/mandatory.gif'></img><!-- </div> --></td>
    </tr>
    <!-- Below SourceType from Direct OT Booking function -->
    <!--tr>
      <td class='label' width='25%' >&nbsp;</td>
      <td class='fields' width='25%'>&nbsp;</td>
      
      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
     
      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> 
      
    <!--/tr-->
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/></td>
      <td class='label' width='25%' ><input type='text' name='Anaesthetia1_code' id='Anaesthetia1_code' size='20'  value="<%=strAnesthesia_temp1%>" onBlur="if(this.value!='')searchanaesthesia(Anaesthetia1_code)">
        <input type='button' class='button' name='quest4' id='quest4' value='?' onClick="searchanaesthesia(Anaesthetia1_code)">
        
        <!-- Sanjay for showing mandatory symbol when Anesthesia Review Checkbox is Checked against IN032063 --> 
        <img id="anes_check" src='../../eCommon/images/mandatory.gif' style='visibility:hidden'></img></td>
      <td class='label' width='25%' ><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='Anaesthetiest2_code' id='Anaesthetiest2_code' size='20' value="<%=strAnesthetit_temp1%>" onBlur="if(this.value!='')searchAnaesthetist(Anaesthetiest2_code)" >
        <input type='button' class='button' name='quest3' id='quest3' value='?' onClick="searchAnaesthetist(Anaesthetiest2_code)"></td>
    </tr>
    <!-- Added for PMG2014-CRF-0002 [IN:046043]  -->
    
    <tr>
     <% if (strAnesReqYN.equals("Y")) { %>
      <td   class='label' width='25%'><fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%'><!-- <input type='checkbox' name='anaes_review' id='anaes_review' value='' onClick="checkAnesReq();"> -->
        
        <input type='checkbox' name='anaes_review' id='anaes_review' value='' checked></td>
      <%} else { %>
      <td   class='label' width='25%'><fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%'><input type='checkbox' name='anaes_review' id='anaes_review' value='' disabled></td>
      <% } %>
      <td class='fields'>&nbsp;</td>
      <td class='fields' >&nbsp;</td>
        
    </tr>
    <tr> 
      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here	-->
      <td class='fields' width='25%'><input type='hidden' name='REMARKS' id='REMARKS' value="">
        <input type='hidden' name="pre_oper_diag" id="pre_oper_diag" value="<%=strPreOperDiag%>">
        <a  href="javascript:showRemarks(document.forms[0].REMARKS,'1',remarks_value,1300);">&nbsp;
        <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
        </a></td>
      <td class='fields' width='25%' ><%  if(strOrderId.length()>0){ 	%>
        <a  href="javascript:showRemarks1(document.forms[0].pre_oper_diag,'2',preOperativeDiag_value,500);">
        <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/>
        </a></td>
      <td class='fields' width='25%' ><!-- Added for PMG2014-CRF-0002 [IN:046043]  -->
        
        <% }else{%>
        <a  href="javascript:showRemarks1(document.forms[0].pre_oper_diag,'1',preOperativeDiag_value,500);">
        <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/>
        </a></td>
      <!-- Added by MuthuN against CRF - 011  on 2/7/2013 -->
      <td class='fields' width='25%' ><!-- Added for PMG2014-CRF-0002 [IN:046043]  -->
        
        <div id='showPreOperDiagDivAnch' style='display:none'> <a class='gridLink' href="javascript:callPreOPDiagnosis_2();">
          <fmt:message key="eOT.PreOperativeDiagnosisNew.Label" bundle="${ot_labels}"/>
          </a> </div>
        <div id='showPreOperDiagDivLabel' style='display:none'>
          <fmt:message key="eOT.PreOperativeDiagnosisNew.Label" bundle="${ot_labels}"/>
        </div>
        
        <!-- Added by MuthuN against CRF - 011 on 2/7/2013  -->
        
        <%}%></td>
      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> 
    </tr>
    <%
	}else{ // Patient Line fields to be hidden 
		   // this part is for CA
%>
    <input type='hidden' name='BOOKING_DATE' id='BOOKING_DATE' size='10'   value='<%=strBookingDate%>' >
    <input type='hidden' name='episode_type' id='episode_type' DB_VALUE="<%=strPatientClass%>" value="" >
    <input type='hidden' name='patient_id' id='patient_id'   value="<%=strPatientId%>" >
    <!-- Modified by Muthukumar on 1/8/2011 for checking null values in gender  -->
    <input type='hidden' name='sex' id='sex' DB_VALUE="<%=strSex%>" value='' >
    <!--<input type='hidden' name='patient_name' id='patient_name'  value='<%=strName%>' >
		<input type='hidden' name='sex' id='sex' DB_VALUE="<%=strSex%>" value='' >
		--> 
    <!-- Modified by Muthukumar on 1/8/2011 for checking null values in gender -->
    <input type='hidden' name='date_of_birth' id='date_of_birth'  value='<%=strAge%>' >
    <input type='hidden' name='order_id' id='order_id' 	value="<%=strSurgeonName%>"  >
    <input type='hidden' name='encounter_id' id='encounter_id' value="<%=strEncounterId%>">
    <input type='hidden' name='patient_name' id='patient_name'  value="<%=strName%>" >
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='booking_no' id='booking_no' size='5' value='<%=checkForNull(request.getParameter("start_time"))%>' readonly></td>
      <td class='label' width='25%' ><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='surgeonType' id='surgeonType' size='20' 
			value="<%=strSurgeryType%>" readonly >
        <input type='button' class='button' name='quest1' id='quest1' value='?' onClick="callSurgeryTypeAndValidateCutOffTime('SurgeryType')">
        <img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='waitlist_no' id='waitlist_no' size='20'  value="<%=strRoomDesc%>"
			readonly ></td>
      <td class='label' width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
        
        <input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='20' value="<%=strSpeciality_temp%>" onBlur="if(this.value!='')searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value=''; anesthesiaRequiredYN(SPECIALITY_DESC); " disabled>
        <input type='button' class='button'  value='?' onClick="searchSpeciality(SPECIALITY_DESC); anesthesiaRequiredYN(SPECIALITY_DESC);" disabled>
        
        <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> 
        <img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='Anaesthetiest2_code' id='Anaesthetiest2_code' size='20' value="<%=strAnesthetit_temp1%>" disabled>
        <input type='button' class='button' name='quest3' id='quest3' value='?' onClick="searchAnaesthetist(Anaesthetiest2_code)"></td>
      <td class='label' width='25%' ><fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='Anaesthetia1_code' id='Anaesthetia1_code' size='20'   value="<%=strAnesthesia_temp1%>"  disabled>
        <input type='button' class='button' name='quest4' id='quest4' value='?' onClick="searchanaesthesia(Anaesthetia1_code)"></td>
    </tr>
    <!-- Below SourceType is from CA/OR function -->
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' nowrap><select name='sourceType' id='sourceType' DB_VALUE='<%=strReferalSource%>' onChange='clearSources()' >
          <option value=''>
          <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
          </option>
          <option value='W'>
          <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
          </option>
          <option value='C'>
          <fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
          </option>
          <option value='E'>
          <fmt:message key="Common.referral.label" bundle="${common_labels}"/>
          </option>
        </select>
        
        <!--GHL-CRF-0356-->
        
        <%
			if(strReferalSource.equals("E"))
				chkReferalDisable = "";
			else
				chkReferalDisable = "disabled";
%>
        <input type='text' name='Source_code' id='Source_code' size='75' value='<%=strReferalDesc%>' <%=chkReferalDisable%> >
        <input type='button' class='button' name='quest6' id='quest6' value='?' onClick="searchsourcetype(Source_code)" <%=chkReferalDisable%>>
        <div id='more_img' style='position:absolute;visibility:hidden;'><img src='../../eOT/images/more.gif' onMouseOver="Tip(getLongNameRefSrcBkAppt(),CENTERMOUSE,true)" onMouseOut="UnTip()"></img> <img src='../../eCommon/images/mandatory.gif'></img></div>
        <%
			if(!strReferalSource.equals("E"))
			{
%>
        <img src='../../eCommon/images/mandatory.gif'></img>
        <%
			}	
%>
        
        <!--GHL-CRF-0356--></td>
      <td class='label' width='25%' ><fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%' ><input type='hidden' name='asst_surgeon_code' id='asst_surgeon_code' maxlength='15' size='15' value= "<%=strAsstSurgeonCode%>"  >
        <input type='text' name='asst_surgeon_name' id='asst_surgeon_name' maxlength='20' size='20' value= "" onBlur="if(this.value!='')searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code); else asst_surgeon_code.value=''">
        <input type='button' class='button' value='?' name='AssSurButton' id='AssSurButton' onClick="searchAsstSurgeon(asst_surgeon_name,asst_surgeon_code);"></td>
    </tr>
    <tr>
      <td class='label' width='25%' ><fmt:message key="Common.PatientPosition.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%' ><input type='text' name='Position_desc' id='Position_desc' size='20'  value ='<%=strPatientPosition%>' disabled>
        
        <!--name='Source Type'-->
        
        <input type='button' class='Button'  name='quest5' id='quest5' value='?' onClick="searchposition(Position_desc)">
        <input type='hidden' name='Patient_position' id='Patient_position' value='<%=strPositionCode%>'></td>
      <!-- <td class='fields' width='25%' ></td> --> <!-- Commented by Sanjay for Anaesthesia Required Checkbox CRF against IN032063--> 
      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 STARTS here -->
      <% if (strAnesReqYNPending > 0) { %>
      <td   class='label' width='25%'><fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%'><input type='checkbox' name='anaes_review' id='anaes_review' value='' disabled checked></td>
      <%} else { %>
      <td   class='label' width='25%'><fmt:message key="eOT.AnaesthesiaReviewRequired.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%'><input type='checkbox' name='anaes_review' id='anaes_review' value='' disabled></td>
      <% } %>
      <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 ENDS here --> 
    </tr>
    <!-- Added for PMG2014-CRF-0002 [IN:046043]-->
    <tr>
      <td class='fields' width='25%'>&nbsp;</td>
    </tr>
    <tr> 
      <!-- <td class='fields' width='25%' ></td> --> <!-- Commented by Sanjay for Anaesthesia Required Checkbox CRF against IN032063-->
      <td class='fields' width='25%'><input type='hidden' name='REMARKS' id='REMARKS' value="">
        <input type='hidden' name="pre_oper_diag" id="pre_oper_diag" value="<%=strPreOperDiag%>">
        <a  href="javascript:showRemarks(document.forms[0].REMARKS,'1',remarks_value,1300);">
        <fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
        </a></td>
      <td class='fields' width='25%' ><%  if(strOrderId.length()>0){ 	%>
        <a  href="javascript:showRemarks1(document.forms[0].pre_oper_diag,'2',preOperativeDiag_value,500);">
        <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/>
        </a> 
        <!-- Added by MuthuN against CRF - 011  on 2/7/2013 --></td>
      <td class='fields' width='25%' ><!-- Added for PMG2014-CRF-0002 [IN:046043]--> 
        <a class='gridLink' href="javascript:callPreOPDiagnosis_2();">
        <fmt:message key="eOT.PreOperativeDiagnosisNew.Label" bundle="${ot_labels}"/>
        </a> 
        <!-- Added by MuthuN against CRF - 011 on 2/7/2013  -->
        
        <% }else{%>
        <a  href="javascript:showRemarks(document.forms[0].pre_oper_diag,'1',preOperativeDiag_value,500);">
        <fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/>
        </a>
        <%}%></td>
      <td class='fields' width='25%' >&nbsp;</td>
      <td class='fields' width='25%'><!--<input type='button' name='' id='' class='button' value='<fmt:message key="Common.close.label"  bundle="${common_labels}"/>' onClick='closeWindow()'>--> <!-- commented for PMG2014-CRF-0002 [IN:046043]--></td>
    </tr>
    <tr>
      <td class='fields' width='25%' colspan="4">
    </tr>
    <%
	} // End of else for Patient Line Changes
%>
  </table>
  <input type='hidden' name='booking_num' id='booking_num' value="<%=strBookingNum%>">
  <input type='hidden' name='waitlistno' id='waitlistno' value="<%=strWaitListNo%>">
  <input type='hidden' name='booking_date' id='booking_date' value="<%=strBookingDate%>">
  <input type='hidden' name='roomCode' id='roomCode' value="<%=strRoomCode%>">
  <input type='hidden' name='roomDesc' id='roomDesc' value="<%=strRoomDesc%>">
  <input type='hidden' name='surgeonName' id='surgeonName' value="<%=strSurgeonName%>">
  <input type='hidden' name='surgeonCode' id='surgeonCode' value="<%=strSurgeonCode%>">
  <input type='hidden' name='selSurgeonCode' id='selSurgeonCode' value="<%=selSurgeonCode%>">
  <!-- 051911 -->
  <input type='hidden' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value="<%=strSpecialityCode%>">
  <input type='hidden' name='start_time' id='start_time' value="<%=strStartTime%>">
  <input type='hidden' name='hidden_time' id='hidden_time' value="<%=strHiddenTime%>">
  <input type='hidden' name='episode_id' id='episode_id' value="<%=strEpisodeId%>">
  <input type='hidden' name='encounter_id1' id='encounter_id1' value="<%=strEncounterId%>">
  <input type='hidden' name='natureCode' id='natureCode' value="<%=strNatureCode%>">
  <input type='hidden' name='natureType' id='natureType' value="<%=strNatureType%>">
  <input type='hidden' name='nursingUnitCode' id='nursingUnitCode' value="<%=strNursingUnit%>">
  <input type='hidden' name='sourceDesc' id='sourceDesc' value='<%=strRefSourceCode%>'>
  <input type='hidden' name='Anaesthetiest1_code' id='Anaesthetiest1_code' value="<%=strAnesthetit_temp%>">
  <input type='hidden' name='Anaesthetia_code' id='Anaesthetia_code' value="<%=strAnesthesia_temp%>">
  <input type='hidden' name='facility_id' id='facility_id' value='<%=strFacilityId%>'>
  <input type='hidden' name='duration' id='duration' value=''>
  <input type='hidden' name='patient_class' id='patient_class' value=''>
  <input type='hidden' name='orderid' id='orderid' value='<%=strOrderId%>'>
  <input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'>
  <%-- ChAiTu - 186 --%>
  <input type='hidden' name='ammendFlag' id='ammendFlag' id='ammendFlag' value='<%=ammendFlag%>'>
  <%-- ChAiTu - 186 --%>
  <input type='hidden' name='selBookingNumber' id='selBookingNumber' id='selBookingNumber' value='<%=selBookingNumber%>'>
  <%-- ChAiTu - 186 --%>
  <input type='hidden' name='visitid' id='visitid' value='<%=strVisitId%>'>
  <input type='hidden' name='mode' id='mode' value='<%=mode%>'>
  <input type='hidden' name='bean_id' id='bean_id' value="<%=bean_id%>" >
  <input type='hidden' name='bean_name' id='bean_name' value="<%=bean_name%>">
  <input type='hidden' name='pref_date' id='pref_date' value="<%=strPrefDate%>">
  <input type='hidden' name='waitlistyn' id='waitlistyn' value='<%=strWaitListYN%>'>
  <input type='hidden' name='specilaity_collect' id='specilaity_collect' value=''>
  <input type='hidden' name='ip_booking_yn' id='ip_booking_yn' value='<%=strIpBookingYN%>' >
  <input type='hidden' name='over_booking_case_yn' id='over_booking_case_yn' value='<%=over_booking_case_yn%>' >
  <input type='hidden' name='patient_class_code' id='patient_class_code' value='<%=patient_class_code%>' >
  <input type='hidden' name='end_time' id='end_time' value="<%=end_time%>">
  <input type='hidden' name='HLongRefSrcId' id='HLongRefSrcId' value="">
  <!--GHL-CRF-0356-->
  <% 
		if(strOrderId.length()>0){
			out.println("<script language='javascript'>disableButton('"+chkReferalDisable+"');</script><Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>");
		}
%>
  <!--GHL-CRF-0356-->
  <input type='hidden' name='locale' id='locale' value="<%=locale%>">
  <input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
  <input type='hidden' name='changed_sourceType' id='changed_sourceType'  value='<%=strReferalSource%>'  >
  <input type='hidden' name='changed_sourceTypeDesc' id='changed_sourceTypeDesc'  value=''  >
  <input type='hidden' name='called_from' id='called_from'  value='<%=called_from%>'  >
  <input type="hidden" name="or_bean_id" id="or_bean_id" value="<%=or_bean_id%>">
  <input type="hidden" name="or_bean_name" id="or_bean_name" value="<%=or_bean_name%>">
  <input type="hidden" name="ammendBooking" id="ammendBooking" id="ammendBooking" value="<%=ammendBooking%>">
  <%-- ChAiTu --%>
  <input type="hidden" name="PreOpPreparationDays" id="PreOpPreparationDays" value="<%=PreOpPreparationDays%>">
  <!-- Modified by Sanjay for Anaesthesia Required Checkbox CRF against IN032063 -->
  <input type="hidden" name="anaes_review1" id="anaes_review1" value="<%=anaes_review1%>">
  <input type='hidden' name='isIncludeFpp' id='isIncludeFpp' value="<%=isIncludeFpp%>" ><!--Added Against ML-MMOH-CRF-1939-US2-->
</form>
</BODY>
</HTML>


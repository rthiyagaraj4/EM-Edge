<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.Connection,java.util.*,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.CallableStatement,java.sql.Types,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean ,eCommon.Common.*,webbeans.eCommon.*,eOT.*,eOT.Common.*,eOT.Common.OTRepository,java.net.URLDecoder,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% /* request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); */%>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%! public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
	}
%>

<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<STYLE TYPE="text/CSS">

/* This style is used for the horizontal and vertical scroll - SKR-SCF-0847 [IN:044280]  */
div#order_ctlg_tbl {
width: 100%;
height: 100%;
overflow-x: auto;
overflow-y: auto;
position: fixed;
}

#Dis{
	bottom:-10;
	position:absolute;
    color:red;	
	font:italic;
	font-family:'sans';
}

</STYLE>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eOT/html/style.css' type='text/css'/>
<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/jquery-latest.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script>
// Commented Against TH-KW-CRF-0126
/* function submitPrevNext(from, to) 
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to;	
	var frmObj=document.forms[0];
	var locale = frmObj.locale.value;
	//MMS-QH-CRF-0186
	var ammendBooking = $('#ammendBooking').val();
	var ChkExistDays;	
	if(frmObj.chkBookingExistDays.value != '')
	{
		ChkExistDays="+"+" "+frmObj.chkBookingExistDays.value;
	}
	else
	{
		ChkExistDays="+ 0";
	}
	//MMS-QH-CRF-0186
	
	//	var sql="SELECT PATIENT_ID PATIENT_ID1,PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,SHORT_NAME SHORT_NAME1, SEX SEX1, SURGERY_NATURE_DESC SURGERY_TYPE1, SPECIALITY_DESC SPECIALITY_DESC1, TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, ORDER_ID ORDER_ID1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1 FROM OT_PENDING_ORDERS_VW   WHERE PERFORMING_FACILITY_ID = '"+frmObj.facility_id.value+"'";

	// added by rajesh for from/to date thai conversion
		var change_from_date = dateUtils(frmObj.from_date.value,locale); 
		var change_to_date = dateUtils(frmObj.to_date.value,locale);
		if(!callDateCheck(change_from_date,change_to_date)) return;

	if(frmObj.from_date.value!='')
	{
		var sql = " SELECT DISTINCT ";
		if((typeof(frmObj.priority) == 'undefined') || (frmObj.priority.value != null && frmObj.priority.value == ''))
		{
			sql += " A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,'dd/mm/yyyy') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code,B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id ,(SELECT c.short_name FROM am_practitioner_lang_vw c WHERE c.practitioner_id = a.physician_id AND c.language_id ='"+locale+"') ordering_surgeon_name,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = '"+frmObj.facility_id.value+"' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE "+encodeURIComponent(ChkExistDays,"UTF-8")+"  AND c.booking_status != '9' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B  ";
			//KDAH-CRF-0283 [IN:050553] MMS-QH-CRF-186 added on 27-Sept-2015 & IN066057

			sql += "WHERE A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"'";
			sql += "AND  A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"'";
			
			sql += "AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)";//MO-GN-5507
			
		}
		else if(frmObj.priority.value != null && frmObj.priority.value != '')
		{
			sql += " order_field_mnemonic, order_field_value, A.PATIENT_ID PATIENT_ID1,A.ENCOUNTER_ID ENCOUNTER_ID1,A.EPISODE_TYPE EPISODE_TYPE1,A.VISIT_ID VISIT_ID1,A.SPECIALITY_CODE SPECIALITY_CODE1,to_char(A.ORDER_DATE_TIME,'dd/mm/yyyy') ORDER_DATE_TIME1,to_char(A.PREF_SURG_DATE,'dd/mm/yyyy') PREF_SURG_DATE1, (select decode( '"+locale+"' ,'en',nvl(patient_name,patient_name_loc_lang), nvl(patient_name_loc_lang,patient_name)) from mp_patient where patient_id = a.patient_id ) SHORT_NAME1, A.SEX SEX1, A.SURGERY_NATURE_DESC SURGERY_NATURE_DESC1,A.SPECIALITY_DESC SPECIALITY_DESC1, A.TEAM_SURGEON_NAME TEAM_SURGEON_NAME1, A.ORDER_ID ORDER_ID1,A.PERFORMING_TEAM_SURGEON PERFORMING_TEAM_SURGEON1,A.STATUS STATUS1, A.WAITLIST_NUM WAITLIST_NUM1,b.oper_code oper_code, B.SHORT_DESC OPER_DESC1, b.long_desc longdesc, a.physician_id physician_id ,(SELECT COUNT (*) booking_cnt   FROM ot_booking_hdr c  WHERE c.patient_id = a.patient_id AND c.operating_facility_id = '"+frmObj.facility_id.value+"' AND  c.booking_start_time >= SYSDATE AND c.booking_start_time <= SYSDATE "+encodeURIComponent(ChkExistDays,"UTF-8")+"  AND c.booking_status != '9' AND EXISTS ( SELECT 1 AS booking_final FROM ot_queue d  WHERE d.appt_ref_num = c.booking_num  AND (booking_stage < (select stage_code from ot_booking_fin_stages where serial_no=(select max(serial_no) from ot_booking_fin_stages)) OR booking_stage IS NOT NULL)) )as booking_cnt, ot_check_consent(a.order_id) AS consentresult  FROM OT_PENDING_ORDERS_VW A, OT_OPER_MAST_LANG_VW B, or_order_field_values c  WHERE A.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND a.order_id = c.order_id AND  A.PERFORMING_FACILITY_ID ='"+frmObj.facility_id.value+"' "; // KDAH-CRF-0283 [IN:050553]MMS-QH-CRF-186 & IN066057

			sql += "and ORDER_FIELD_MNEMONIC = 'PRIORITY'";
			
			sql += "AND B.ORDER_CATALOG_CODE = (SELECT ORDER_CATALOG_CODE FROM OT_PENDING_ORDER_LINE WHERE ORDER_ID = A.ORDER_ID AND ROWNUM = 1)";//MO-GN-5507
		}

		var where = " ";
		if(frmObj.speciality_code.value!=null && frmObj.speciality_code.value!='')
			where+=escape(" and A.SPECIALITY_CODE ='"+frmObj.speciality_code.value+"'");

		if(frmObj.surgeon_code.value!=null && frmObj.surgeon_code.value!='') // start KDAH-CRF-0283 [IN:050553]
		{
			if(frmObj.customerId.value == 'KDAH')
				where += escape(" and A.physician_id ='"+frmObj.surgeon_code.value+"'");
			else
				where += escape(" and A.PERFORMING_TEAM_SURGEON ='"+frmObj.surgeon_code.value+"'");
		} // end KDAH-CRF-0283 [IN:050553]

		if(frmObj.order_id.value!=null && frmObj.order_id.value!='')
			where+=escape(" and A.ORDER_ID ='"+frmObj.order_id.value+"'");

		if((frmObj.from_date.value!=null && frmObj.from_date.value!='')||(frmObj.to_date.value!=null && frmObj.to_date.value!=''))
			where +=escape(" AND A.PREF_SURG_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')");

		if(frmObj.patient_id.value!=null && frmObj.patient_id.value!='')   
			where+=escape(" and PATIENT_ID ='"+frmObj.patient_id.value+"'");
		else if(frmObj.patient_name.value!=null&&frmObj.patient_name.value!='') 
			where+= escape(" and short_name like '"+frmObj.patient_name.value+"%'");
		 if(frmObj.checkin_booking_flag.value=='CHECK_IN')
			where+= " and  A.STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE ='10' )";

		//if(ammendBooking == 'Y')
			//where += "order by A.PATIENT_ID,pref_surg_date1 ,b.long_desc,a.speciality_desc";
		where += "ORDER BY a.patient_id, pref_surg_date1, a.speciality_desc,b.long_desc"; //added by selvin
		sql+=where;
		alert("sql===>"+sql)
		// start KDAH-CRF-0283 [IN:050553]
		var param='sql='+sql+'&surgeonCode='+frmObj.surgeon_code.value+'&checkin_booking_flag='+frmObj.checkin_booking_flag.value+"&from="+from+"&to="+to+"&speciality_code="+frmObj.speciality_code.value+"&surgeon_code="+frmObj.surgeon_code.value+"&order_id="+frmObj.order_id.value+"&patient_id="+frmObj.patient_id.value+"&patient_name="+frmObj.patient_name.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&called_from="+frmObj.called_from.value; //+"&totalRecCnt="+totalRecCnt; //+"&totalRecCnt="frmObj.totalRecCnt.value; // Added [called_from] against for [IN:057473] 
		if(frmObj.priority != null && frmObj.priority != 'undefined')
			param += "&priorityValue="+frmObj.priority.value;
		param += "&bookingPriorityOrdersYN="+frmObj.bookingPriorityOrdersYN.value
						+"&customerId="+frmObj.customerId.value;
		// end KDAH-CRF-0283 [IN:050553]
		alert("param =>"+param)
		parent.parent.qa_query_result.location.href = '../../eOT/jsp/PendingOrderDtlFrame.jsp?'+param;	
		//End IN024288
	}
	else
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		alert(msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]);
	}
} */
</script>
<head>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script> <!-- KDAH-CRF-0283 [IN:050553] -->
<div id="order_ctlg_tbl"><!--Added for the SCF - SKR-SCF-0847 [IN:044280] -->      
	<%
		String	called_from = checkForNull(request.getParameter("called_from")); // [IN:057473]
	%>
<form name='pendingOrderDtlForm' id='pendingOrderDtlForm' action='' method = 'post'>

<%  
	String strPatientId="",strEncounterId ="",strEpisodeType ="",strPatientName="",strSex="",strSurgeoryType="",strSpecialityDesc="",strSpecialityCode="",strSurgeonName="",
	strSurgeonCode="",strOrderId="",strQuery="",strOperDesc="",operCode="",strPrefDate="",strWaitListNo="",strStatus="",strCheckinFlag="",strOrderStatus="",strPriority="",strOrderDate="",sql="";
	String strMnemonic = "";
	StringBuffer innerSql = new StringBuffer();
	// start KDAH-CRF-0283 [IN:050553]
	String longDescription = ""; 
	String physicianId = "";
	String patientAge = "";
	StringBuffer getAgeSqlBuffer = new StringBuffer(); 
	// end KDAH-CRF-0283 [IN:050553]
	String priorityColValue = "";
	int daysGap = 0;
	StringBuffer strTempBookNo=new StringBuffer();
	Connection conn=null;
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
	String todaysDate = com.ehis.util.DateUtils.getCurrentDate("dd/mm/yyyy", locale);
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement innerPstmt = null;
	//MMS-QH-CRF-0186 start
	PreparedStatement innerPstmtConsent = null;
	StringBuffer ConsentImageQuery=new StringBuffer();
	boolean ConsentNotRecord=false,ConsentRecord=false,ConsentNotRequired=false;
	//newly added by vikash	for 186
	String consentresutlt="";	
	//Added against TH-KW-CRF-0126...starts
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	boolean isInsuranceStatus = false;
    boolean bill_flag = false;	
	String patient_class = "";
	String order_line_no = "";
	ResultSet resultset = null;
	//Added against TH-KW-CRF-0126...ends
	
	ConsentImageQuery.append("	SELECT NVL (ord_consent_reqd_yn, 'N') ord_consent_reqd_yn,					");
	ConsentImageQuery.append("	NVL (num_of_consent_req_bo, 0)												");
	ConsentImageQuery.append("	+ NVL (num_of_consent_req_br, 0) ord_consent_status							");
	ConsentImageQuery.append("	FROM or_order_line a														");
	ConsentImageQuery.append("	WHERE order_id = ?															");
	ConsentImageQuery.append("	AND NVL (num_of_consent_req_bo, 0) + NVL (num_of_consent_req_br, 0) < =		");
	ConsentImageQuery.append("	(SELECT COUNT (*)															");
	ConsentImageQuery.append("	FROM or_consent_ref_dtl b													");
	ConsentImageQuery.append("	WHERE order_id = a.order_id AND order_line_num = a.order_line_num)			");
	//MMS-QH-CRF-0186 End
	
	// start KDAH-CRF-0283 [IN:050553]
	PreparedStatement getAgePstmt = null;
	ResultSet getAgeRs = null;
	// end KDAH-CRF-0283 [IN:050553]
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet innerRs = null;
	//MMS-QH-CRF-0186
	ResultSet innerRsConsent = null;
	int fetchCount=0;
	String visit_id="";
	String episode_id="";
	String from = request.getParameter( "from"  );
	String to = request.getParameter( "to")  ;
	String from_date = request.getParameter( "from_date") ;
	String to_date = request.getParameter( "to_date" );
	String surgeon_code = CommonBean.checkForNull(request.getParameter( "surgeon_code" )) ;
	String order_id = CommonBean.checkForNull(request.getParameter( "order_id" )) ;
	String priorityValue = CommonBean.checkForNull(request.getParameter( "priorityValue" )) ;
	String customerId = CommonBean.checkForNull(request.getParameter( "customerId" )) ;//KDAH-CRF-0283 [IN:050553]
	String bookingPriorityOrdersYN = CommonBean.checkForNull(request.getParameter( "bookingPriorityOrdersYN" )) ;//KDAH-CRF-0283 [IN:050553]
	String speciality_code = CommonBean.checkForNull(request.getParameter( "speciality_code" )) ;
	String patient_id = CommonBean.checkForNull(request.getParameter( "patient_id" )) ;
	String priority = CommonBean.checkForNull(request.getParameter( "priority" )) ;
	String patient_name =CommonBean.checkForNull( request.getParameter( "patient_name" )) ;
	String facilityid=(String)session.getValue("facility_id");
	//MMS-QH-CRF-0186
	String ammendBooking = "";
	String chkBookingExistDays = "";
	String tempStrPatientId = "";
	//MMS-QH-CRF-0186

	int patIdCnt = 0;
	int start = 0 ;
	int end = 0 ;
	int s=0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 10 ;		
	else
		end = Integer.parseInt( to ) ;

	try{
		conn = ConnectionManager.getConnection(request);
		
		//Added Against TH-KW-CRF-0126...starts
		isInsuranceStatus = CommonBean.isSiteSpecific(conn,"OT","OT_BILLING_STATUS");
		System.err.println("isInsuranceStatus --->"+isInsuranceStatus);
				
		CallableStatement cstmt = null;
	    String bl_installed="";
	    String err_text = "";
	    String bl_interface="";
		String params = request.getQueryString();
	    called_from = CommonBean.checkForNull(request.getParameter("called_from"));

		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=conn.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facilityid );
		cstmt.setString(2,facilityid );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
		
		//Added Against TH-KW-CRF-0126...ends 
		
		//MMS-QH-CRF-0186 start
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
		String getValOfAmmendBooking = "select nvl(ammend_bookings, 'N') ammend_bookings, chk_bookings_exist_days from ot_param_for_facility where operating_facility_id =?";
		pstmt = conn.prepareStatement(getValOfAmmendBooking);
		pstmt.setString(1,facilityid);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			ammendBooking = rs.getString("ammend_bookings");
			chkBookingExistDays = rs.getString("chk_bookings_exist_days");
		}
		
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
		//MMS-QH-CRF-0186 end
		innerSql.append("	SELECT order_field_value	");
		innerSql.append("	FROM or_order_field_values	");
		innerSql.append("	WHERE order_id = ? AND order_field_mnemonic = 'PRIORITY'	");
		innerSql.append("	AND UPPER(order_field_value) IN ('PRIORITY-1','PRIORITY-2','PRIORITY-3')"); //Added for IN:045883
		if(priorityValue != null && priorityValue.trim().length() > 0)
			innerSql.append("	and order_field_value = ?	");
		innerPstmt = conn.prepareStatement(innerSql.toString());

		getAgeSqlBuffer.append("	SELECT mp_get_age_ymdh (a.date_of_birth, a.deceased_date) age	");
		getAgeSqlBuffer.append("	FROM mp_patient a	");
		getAgeSqlBuffer.append("	WHERE patient_id = ?		");
		getAgePstmt = conn.prepareStatement(getAgeSqlBuffer.toString());

		sql=OTRepository.getOTKeyValue("SQL_OT_PENDING_DTL_SELECT1");
		pstmt = conn.prepareStatement(sql);
		System.err.println("269, PendingOrderDtl.jsp sql==="+sql);
		rs=pstmt.executeQuery();
		if(rs.next())
			strOrderStatus=rs.getString("ORDER_STATUS_CODE1");
			//System.err.println("281,PendingOrderDtl.jsp strOrderStatus==="+strOrderStatus);
		if(rs!=null)
			rs.close();
		if(pstmt !=null)
			pstmt.close();

		strCheckinFlag=checkForNull(request.getParameter("checkin_booking_flag"));
 		strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
		sql=request.getParameter("sql");
		System.err.println("281,sql==="+sql);
 		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		pstmt1=conn.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PENDING_DTL_SELECT2"));

			if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{

		while(s<=end && rs.next())
		{
		  strPatientId = checkForNull(rs.getString("PATIENT_ID1"));
		  
		  // Added against TH-KW-CRF-0126 Starts
		  strEncounterId = checkForNull(rs.getString("ENCOUNTER_ID1"));
		  strEpisodeType = checkForNull(rs.getString("EPISODE_TYPE1"));
		  strOrderId = checkForNull(rs.getString("ORDER_ID1"));
		 		  
		String sql1="select distinct a.patient_class from pr_encounter a, or_order b where a.patient_id = b.patient_id and a.patient_id=? and a.encounter_id=? and a.encounter_id = b.encounter_id " ;
			pstmt = conn.prepareStatement(sql1) ;
			pstmt.setString(1,strPatientId);
			pstmt.setString(2,strEncounterId);
				
			resultset = pstmt.executeQuery();
			if (resultset!=null && resultset.next()) {
				patient_class=resultset.getString("PATIENT_CLASS");
			}
			 if(patient_class.equals("OP") || patient_class.equals("EM")){
			        episode_id =strEncounterId.substring(0,(strEncounterId.length()-4));  
			        visit_id =strEncounterId.substring(strEncounterId.length()-4);  
				}
			  if(patient_class.equals("IP") || patient_class.equals("DC")){
							episode_id =strEncounterId; 
				} 
				
				
			String insurance_patient_yn = "";
			String insurance_status_desc ="";
			String PatientPayementStatus = "";
			ArrayList InsuranceDescList = new ArrayList();
		    InsuranceDescList=bean.getInsuranceDesc(strPatientId,episode_id,visit_id,strEpisodeType,facilityid,strOrderId);
		   PatientPayementStatus=bean.getPatientPayment(facilityid,"OR",strOrderId,"1");
		
		    System.err.println("InsuranceDescList :"+InsuranceDescList);
		  if(InsuranceDescList!=null && InsuranceDescList.size()>0)
			{
		   insurance_patient_yn = (String)InsuranceDescList.get(3);
		 if(insurance_patient_yn!=null || insurance_patient_yn!="C")
		  insurance_status_desc = (String)InsuranceDescList.get(2);
			}
		  
			// Added against TH-KW-CRF-0126 Ends
			
			if(fetchCount==0)
			{
%>
		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<table width='100%' border='0' align='center' >
		<tr>
		<td width='20%' align='right' class='NONURGENT'>
		<%
		if ( !(start <= 1)) 
		{
		%>
			<a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
			<input type=hidden name='whichPage' id='whichPage' value='prev'>
		<%
			}
		//	if ( !((start+11) > fetchCount ))
				{
		%>
			<a href='javascript:submitPrevNext(<%=(start+11)%>,<%=(end+11)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
			
		<%
		
			}
		%>
		
	</td>
	 </tr>
	</table>

			<table class='grid' border='1' width='100%' cellpadding=3 cellspacing=0>
<tr>
<%
	if(!called_from.equalsIgnoreCase("OT_MENU")) { // [IN:057473]
%>
<%
			if(ammendBooking != null && ammendBooking.equals("Y"))
			{
%>
				<th class='columnHeader' nowrap>
					<input type="checkbox" name="bukngsToSchedule" id="bukngsToSchedule" id="bukngsToSchedule" onclick="disableAll('', 'All');" disabled>
				</th>
				<!--MMS-QH-CRF-0186-->
				<th class="columnHeader" nowrap>
					<fmt:message key="eOT.FutureAppointment.Label" bundle="${ot_labels}"/>
				</th>
				<!--MMS-QH-CRF-0186-->
<%
			}
%>

			<th class='columnHeader' nowrap><fmt:message key="eOT.Consent.Label" bundle="${ot_labels}"/></th>
<%} // [IN:057473]%>
		<%
		if(isInsuranceStatus && bill_flag){ //Added Against TH-KW-CRF-0126
		%>
            <th class='columnHeader' nowrap><fmt:message key="eOT.InsuranceStatus.label" bundle="${ot_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.PatientPayement.label" bundle="${ot_labels}"/></th>
			<%
             }
			%>
			
			<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<th class='columnHeader' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
<%
			} // end KDAH-CRF-0283 [IN:050553]
%>
<%
			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
			<th class='columnHeader' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
<%
			}
%>
			<th class='columnHeader' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></th>
			<th class='columnHeader' nowrap><fmt:message key="eOT.Procedure(s).Label" bundle="${ot_labels}"/></th>
<%
			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
			<th class='columnHeader' nowrap><fmt:message key="Common.Pending.label" bundle="${common_labels}"/> <fmt:message key="Common.days.label" bundle="${common_labels}"/></th>
<%
			}
%>
			<th class='columnHeader' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></th>		
			<th class='columnHeader' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>		
<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<th class='columnHeader' nowrap><fmt:message key="eOT.OrderingSurgeon.label" bundle="${ot_labels}"/></th>
<%
			}
			else
			{
%>
			<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
<%
			}
%>
<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<th class='columnHeader' nowrap><fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></td>
<%
			}
%>
</tr>
<% 
			tempStrPatientId = strPatientId;
		}
			//strPatientId=checkForNull(rs.getString("PATIENT_ID1"));//186
			strPatientName=checkForNull(rs.getString("SHORT_NAME1"));
			strSex=checkForNull(rs.getString("SEX1"));
			//strMnemonic=checkForNull(rs.getString("ORDER_FIELD_MNEMONIC"));
			if(priorityValue != null && priorityValue.trim().length() > 0)
				priorityColValue = checkForNull(rs.getString("order_field_value"));
			strSurgeoryType=checkForNull(rs.getString("SURGERY_NATURE_DESC1"));	
			strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
			strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
			strSurgeonName=checkForNull(rs.getString("TEAM_SURGEON_NAME1"));
			strSurgeonCode=checkForNull(rs.getString("PERFORMING_TEAM_SURGEON1"));
			strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
			strOperDesc=checkForNull(rs.getString("longdesc"));//MMS-QH-CRF-0199
			operCode = checkForNull(rs.getString("oper_code"));			
			strOrderId=checkForNull(rs.getString("ORDER_ID1"));
			strOrderDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORDER_DATE_TIME1"),"DMY","en",locale));			
			strPrefDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREF_SURG_DATE1"),"DMY","en",locale));
			daysGap = com.ehis.util.DateUtils.daysBetween(strOrderDate, todaysDate, "DMY", locale);
			strStatus=checkForNull(rs.getString("STATUS1"));
			longDescription = checkForNull(rs.getString("longdesc")); //KDAH-CRF-0283 [IN:050553]
			//physicianId = checkForNull(rs.getString("physician_id")); //KDAH-CRF-0283 [IN:050553]
			physicianId = checkForNull(rs.getString("ordering_surgeon_name")); //KDAH-CRF-0283 [IN:050553]
			
			if(priorityValue == null || priorityValue.trim().length() == 0)
			{
				innerPstmt.setString(1, strOrderId);
				if(priorityValue != null && priorityValue.trim().length() > 0)
					innerPstmt.setString(2, priorityValue);
				innerRs = innerPstmt.executeQuery();
				priorityColValue = "";
				while(innerRs.next())
					priorityColValue = checkForNull(innerRs.getString("order_field_value"));
			}
			// start KDAH-CRF-0283 [IN:050553]

			getAgePstmt.setString(1, strPatientId);
			getAgeRs = getAgePstmt.executeQuery();
			while(getAgeRs.next())
				patientAge = checkForNull(getAgeRs.getString("age"));
			// end KDAH-CRF-0283 [IN:050553]

			if(tempStrPatientId != null && tempStrPatientId.equals(strPatientId))
				patIdCnt++;
			else
			{
%>
				<input type='hidden' name='patIdCnt<%=tempStrPatientId%>' id='patIdCnt<%=tempStrPatientId%>' id='patIdCnt<%=tempStrPatientId%>' value='<%=patIdCnt%>'>
<%
				patIdCnt = 1;
			}
			tempStrPatientId = strPatientId;
%>

			<input type='hidden' name='xx<%=fetchCount%>' id='xx<%=fetchCount%>' id='xx<%=fetchCount%>' value='<%=strSurgeonName%>'>
			<input type='hidden' name='yy<%=fetchCount%>' id='yy<%=fetchCount%>' id='yy<%=fetchCount%>' value='<%=strSpecialityDesc%>'>
			 <%-- MMS-QH-CRF-0186 --%>
			<input type='hidden' name='speciality_code_<%=fetchCount%>' id='speciality_code_<%=fetchCount%>' id='speciality_code_<%=fetchCount%>' value='<%=strSpecialityCode%>'>
			<input type='hidden' name='selOrderIds_<%=fetchCount%>' id='selOrderIds_<%=fetchCount%>' id='selOrderIds_<%=fetchCount%>' value='<%=strOrderId%>'>
			<input type='hidden' name='operCode_<%=fetchCount%>' id='operCode_<%=fetchCount%>' id='operCode_<%=fetchCount%>' value='<%=operCode%>'>
			<input type='hidden' name='surgeonCode_<%=fetchCount%>' id='surgeonCode_<%=fetchCount%>' id='surgeonCode_<%=fetchCount%>' value='<%=strSurgeonCode%>'>
			<input type='hidden' name='prefDate_<%=fetchCount%>' id='prefDate_<%=fetchCount%>' id='prefDate_<%=fetchCount%>' value='<%=strPrefDate%>'>
			<%-- MMS-QH-CRF-0186 --%>
<%
			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y") && priorityColValue.equalsIgnoreCase("Priority-1")) //052733
				strQuery = (fetchCount%2==0) ? "class='gridDataPriority'" : "class='gridDataPriority'";
			else
				strQuery = (fetchCount%2==0) ? " class = 'gridData' " : " class = 'gridData' ";
%>
			<tr>
<%
			if(!called_from.equalsIgnoreCase("OT_MENU")) {   // [IN:057473]
%>
<%
			if(ammendBooking != null && ammendBooking.equals("Y"))
			{
%>
			<!--MMS-QH-CRF-0186-->
			
				<td <%=strQuery%> nowrap> 
				<%
				if(strStatus.equals(strOrderStatus)==false){
				%>
				<input type="checkbox" name="bukngsToSchedule<%=fetchCount%>" id="bukngsToSchedule<%=fetchCount%>" id="bukngsToSchedule<%=fetchCount%>" value="<%=strPatientId%>" onclick="disableAll('<%=strPatientId%>', '<%=fetchCount%>', '<%=operCode%>');">  <%-- ChAiTu --%>
				<input type="hidden" name="chkBoxSelect<%=fetchCount%>" id="chkBoxSelect<%=fetchCount%>" id="chkBoxSelect<%=fetchCount%>" value='false'> <%-- ChAiTu --%>
				
				<%
				}else{
				patIdCnt--;	//added against 057504
				
				%>
				<!--<input type="checkbox" name="bukngsToSchedule<%=fetchCount%>" id="bukngsToSchedule<%=fetchCount%>" id="bukngsToSchedule<%=fetchCount%>" value="<%=strPatientId%>" onclick="disableAll('<%=strPatientId%>', '<%=fetchCount%>', '<%=operCode%>');" disabled> -->
				<input type="checkbox"  disabled>
				
				<!--<input type="checkbox" name="bukngsToSchedule<%=fetchCount%>" id="bukngsToSchedule<%=fetchCount%>" id="bukngsToSchedule<%=fetchCount%>" value="<%=strPatientId%>" onclick="disableAll('<%=strPatientId%>', '<%=fetchCount%>', '<%=operCode%>');"> -->
				<%
				}
				
				%>
				
				</td>
				<!--MMS-QH-CRF-0186-->
				<!--MMS-QH-CRF-0186 start-->
				
				<%
					int Disp_Image_YN=0;					
					Disp_Image_YN=Integer.parseInt(rs.getString("booking_cnt"));					
					
				if(Disp_Image_YN>0){
				%>										
					
					<!--<td nowrap style="FONT-SIZE: 8pt ;BORDER-STYLE: solid;BORDER-BOTTOM: #CC9966 0px solid;BORDER-LEFT: #CC9966 0px solid;BORDER-RIGHT:#CC9966 0px solid;BORDER-TOP: #CC9966 1px solid;BACKGROUND-COLOR:green"></td>-->
					<td align=='right' width='2%' class='gridDataBookingAvailabel'>&nbsp; </td>
				<%
					}else{
				%>
						<td <%=strQuery%> nowrap>				
				<%
					}
				%>				
				</td>				
				<!--MMS-QH-CRF-0186 end-->
<%
			}
			%>
			<%
			}   // [IN:057473]
			%>
				<!--MMS-QH-CRF-0186 start-->
				<%
				//CRF-186 for consent starts
					ConsentNotRecord=false;ConsentRecord=false;ConsentNotRequired=false;
							consentresutlt=checkForNull(rs.getString("consentresult"));
							// System.err.println("consentresutlt: "+consentresutlt);
							if(consentresutlt!=null && consentresutlt!=""){
								// System.err.println("first If");
								if(consentresutlt.contains("Y") && consentresutlt.contains("PC")){
									// System.err.println("second If");
									ConsentNotRecord=true;
								}else if(consentresutlt.contains("Y") && !consentresutlt.contains("PC")){
								// System.err.println("Third If");
									ConsentRecord=true;
								}else if(consentresutlt.contains("N") && !consentresutlt.contains("Y")){
								// System.err.println("fourth If");
								ConsentNotRequired=true;
							}							
							}else if(consentresutlt.contains("N")){
							// System.err.println("fifth If");
								ConsentNotRequired=true;
							}else{
								// System.err.println("else");
								ConsentRecord=true;
							}
						//CRF-186 for consent ends
				
				%>
			<% if(!called_from.equalsIgnoreCase("OT_MENU")) {%>
				<%
					if(ConsentNotRequired){
					%>
					<td <%=strQuery%> nowrap></td>
					<%
					}else if(ConsentRecord){
					%>
					<td <%=strQuery%> nowrap><img id="img_src_res" src='../../eOT/images/Obtained.PNG'></td>
					<%
					}else if(ConsentNotRecord){
					%>
					<td <%=strQuery%> nowrap><img id="img_src_res" src='../../eOT/images/NotObtained.PNG'></td>
					<%
					}
				%>
				<%}%>
				<!--<td <%=strQuery%> nowrap><img id="img_src_res" src='../../eOT/images/Obtained.PNG'></td>-->
                
   <%if(isInsuranceStatus && bill_flag){ //Added Against TH-KW-CRF-0126
	  
	    if(insurance_patient_yn.equals("I")){
  %>
				 <td <%=strQuery%> nowrap> <%=insurance_status_desc%></td>		
        <%
	    }
       else{
        %>
			   <td <%=strQuery%> nowrap>NA</td>
		<% 
		}	
		%>
		        <td <%=strQuery%> nowrap> <%=PatientPayementStatus%> </td>
    <%		
	}
	%>
				<!--Added Against TH-KW-CRF-0126...ends-->
				<!--MMS-QH-CRF-0186 end-->
			<%
			
			if(strCheckinFlag.equalsIgnoreCase("CHECK_IN") == true)
				out.println("<td "+strQuery+"  width='10%' class='"+strQuery+"'  align='left' OnClick=\"javascript:funMoveNext('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"');\"><font class='gridLink' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'>"+strPatientId+"</font></td>");
			else
			{
				if(strWaitListNo.length()==0)
				{
					if(strStatus.equals(strOrderStatus)==false)
					{
						out.println("<input type='hidden' name='validateMenuDisp' id='validateMenuDisp'"+fetchCount+" id='validateMenuDisp'"+fetchCount+" value='1' >");//186
						out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"displayToolTip1('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"','1',this,'imgArrow"+fetchCount+"');\"  width='10%'  onMouseOver='hidemenu();' nowrap>"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
					}
					else
					{
						out.println("<input type='hidden' name='validateMenuDisp' id='validateMenuDisp'"+fetchCount+" id='validateMenuDisp'"+fetchCount+" value='2' >");//186
						out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"displayToolTip1('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"','2',this,'imgArrow"+fetchCount+"');\"  width='10%'  onMouseOver='hidemenu();' nowrap>"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
					}
				}
				else
				{
					if(strStatus.equals(strOrderStatus)==false)
					{
						out.println("<input type='hidden' name='validateMenuDisp' id='validateMenuDisp'"+fetchCount+" id='validateMenuDisp'"+fetchCount+" value='0' >");//186
						out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"displayToolTip1('"+strOrderId+"','"+strSurgeonCode+"','"+strPrefDate+"','"+fetchCount+"','"+strPatientId+"','0',this,'imgArrow"+fetchCount+"');\"  width='10%'  onMouseOver='hidemenu();' nowrap>"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
					}
					else
					{
%>
						<td <%=strQuery%> nowrap> <%=strPatientId%> </td>
<%
					}
				}
			}
%>
			<td <%=strQuery%> nowrap> <%=strPatientName%> </td>
			<td <%=strQuery%> nowrap> <%=strSex%> </td>

<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<td <%=strQuery%> nowrap> <%=patientAge%> </td>
<%
			}
%>
<%
			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
			<td <%=strQuery%> nowrap> <%=priorityColValue%> </td>
<%
			}
%>
			<td <%=strQuery%> nowrap> <%=strSurgeoryType%> </td>
<%
			pstmt1.setString(1, locale);
			pstmt1.setString(2, strOrderId);
			rs1=pstmt1.executeQuery();
			strTempBookNo.setLength(0);
			strTempBookNo=new StringBuffer();
			strTempBookNo.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels"));
			strTempBookNo.append(",");
			while(rs1.next())
			{
				strTempBookNo.append(rs1.getString(1));
				strTempBookNo.append(",");
			}		
			if(rs1!=null) 
				rs1.close();
%>
			
<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<td <%=strQuery%> OnMouseOver="showOperLongDesc('<%=longDescription%>')"  onmouseout="hideToolTip1()" nowrap >
<%
			}
			else
			{
%>
				<td <%=strQuery%> nowrap >
<%
			}
%>
			
			<%=strOperDesc%></td>
<%
			if(bookingPriorityOrdersYN != null && bookingPriorityOrdersYN.equalsIgnoreCase("Y")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
			<td <%=strQuery%> nowrap>
<%
						if(daysGap > 0)
						{
%>
							<%=daysGap%>
<%
						}
%>
			</td>
<%
			}
%>
			<td <%=strQuery%> nowrap><%=strPrefDate%></td>
			<td <%=strQuery%> nowrap><%=strSpecialityDesc%></td>
<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<td <%=strQuery%> nowrap><%=physicianId%></td>
<%
			}
			else
			{
			if(strSurgeonCode.equals(""))
			{
%>
				<td <%=strQuery%> nowrap><%=all_surgeons%></td>
<%
			}
			else
			{
		//testing selvin
		if(strSurgeonName.equals("")){ 
%>
				<td <%=strQuery%> nowrap><%=all_surgeons%></td>
<%
			}
		else{
%>
			<td <%=strQuery%> nowrap><%=strSurgeonName%></td>
<%
		}
	//testing selvin
	%>
<%
				
			}
			}
%>
<%
			if(customerId != null && customerId.equalsIgnoreCase("KDAH")) // start KDAH-CRF-0283 [IN:050553]
			{
%>
				<td <%=strQuery%> nowrap> 
					<a href='javascript:showPreOperativeComments("<%=strOrderId%>", "Pre-Operative Clinical Comments");'> Pre-operative clinical comments  </a> <!-- KDAH-CRF-0283 [IN:050553] -->
				</td>
<%
			}
%>
			</tr>
			<input type='hidden' name='reason<%=fetchCount%>' id='reason<%=fetchCount%>' value='<%=strTempBookNo%>' > 
<%
			fetchCount++;
			s++;
		}
	}

%>
		<input type='hidden' name='patIdCnt<%=tempStrPatientId%>' id='patIdCnt<%=tempStrPatientId%>' id='patIdCnt<%=tempStrPatientId%>' value='<%=patIdCnt%>'>
<%
		if(fetchCount==0)
			%><script>callNoRecord();</script><%
			
		if ( fetchCount < 10 || (!rs.next()) ) 
		{
%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
<% 
			} 
			else 
			{
%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%
			}

	}catch(Exception ee){
		ee.printStackTrace();
	}finally{
		if(rs!=null) rs.close();
		if(resultset!=null) resultset.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt!=null)pstmt.close();
		ConnectionManager.returnConnection(conn,request);
		strTempBookNo.setLength(0);
	}
%>
 </table>
 <%if(isInsuranceStatus && bill_flag){ //Added Against TH-KW-CRF-0126
	 %>
 <div id="Dis">
 <h4><fmt:message key="eOT.DisclaimerForBillStatus.label" bundle="${ot_labels}"/></h4>
 </div>
 <%
 }
 %>
 </div>

<input type='hidden' name='checkin_booking_flag' id='checkin_booking_flag' value='<%=strCheckinFlag%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='from_date' id='from_date' value="<%=from_date%>">
<input type='hidden' name='to_date' id='to_date' value="<%=to_date%>">
<input type='hidden' name='facility_id' id='facility_id' id="facilityId" value="<%=facilityid%>"><!-- PMG2014-CRF-0024 U-3-->
<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>">
<input type='hidden' name='patient_id' id='patient_id' id="patientId" value="<%=patient_id%>">
<input type='hidden' name='patient_name' id='patient_name' value="<%=patient_name%>">
<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>">
<input type='hidden' name='priority' id='priority' id='priority' value='<%=priority%>'>
<input type='hidden' name='customerId' id='customerId' id='customerId' value='<%=customerId%>'> <!-- KDAH-CRF-0283 [IN:050553] -->
<input type='hidden' name='bookingPriorityOrdersYN' id='bookingPriorityOrdersYN' id='bookingPriorityOrdersYN' value='<%=bookingPriorityOrdersYN%>'> <!-- KDAH-CRF-0283 [IN:050553] -->
<input type="hidden" name="todaysDate" id="todaysDate" id="todaysDate" value="<%=todaysDate%>"> <%-- PMG2014-CRF-0024 --%>
<%-- MMS-QH-CRF-0186 --%>
<input type="hidden" name="totalRecCnt" id="totalRecCnt" id="totalRecCnt" value="<%=fetchCount%>">
<input type="hidden" name="ammendBooking" id="ammendBooking" id="ammendBooking" value="<%=ammendBooking%>">
<input type="hidden" name="chkBookingExistDays" id="chkBookingExistDays" id="chkBookingExistDays" value="<%=chkBookingExistDays%>"> 
<input type="hidden" name="selSpeciality" id="selSpeciality" id="selSpeciality" value=''>
<input type="hidden" name="selOrderId" id="selOrderId" id="selOrderId" value=''>
<input type="hidden" name="NoOfCheckBoxSelected" id="NoOfCheckBoxSelected" id="NoOfCheckBoxSelected" value=''>
<%-- MMS-QH-CRF-0186 --%>
<input type='hidden' name="called_from" id="called_from" value="<%=called_from%>"> <!-- Added against for [IN:057473] -->
</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:30%; visibility:hidden;' bgcolor='blue'>
</div>
 </body>
</html>


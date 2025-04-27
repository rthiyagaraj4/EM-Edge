
<html>             
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eOT.Common.OTRepository" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<title> <fmt:message key="eOT.BookingWindow.Label" bundle="${ot_labels}"/></title>
<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script type='text/javascript' src='../../eOT/js/BookingPatientSearch.js'></script>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script language='javascript'>
	var preOperativeDiag_value= getLabel("eOT.PreOperativeDiagnosis.Label","OT");
	var remarks_value=getLabel("Common.remarks.label","OT");//Modified by Satish
	function showAuditTrails(bookno){
		var dialogHeight 		= "85vh";
		var dialogWidth  		= "50vw";
		var dialogTop   		= "0";
		var dialogLeft   		= "100";
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var	param="booking_no="+bookno;    retVal=window.showModalDialog("../../eOT/jsp/AuditTrailFrame.jsp?"+param,arguments,features);
	}

</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="getLongNameRefSrc();">
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<form name='PreOperHdr' id='PreOperHdr' method='POST' action='../../eOT/jsp/OperationProcedureHdr.jsp'>
<% 
    //Commented convertDate for IN024449 by AnithaJ
	//String strBookingDate=checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY","en",locale));
	String strBookingDate=checkForNull(request.getParameter("booking_date"));
	String strSurgeonName=checkForNull(request.getParameter("surgeonName"));
	String strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
	String strStartTime=checkForNull(request.getParameter("start_time"));
	String strRoomDesc=checkForNull(request.getParameter("roomDesc"));
	String strRoomCode=checkForNull(request.getParameter("roomCode"));
	String strSpecialityDesc=checkForNull(request.getParameter("speciality_desc"));
	String strSpecialityCode=checkForNull(request.getParameter("speciality_code"));
	String strFlag=checkForNull(request.getParameter("transfer"));
	String sql="",strBookingNo="",strEndTime="",strPatientId="",strPatientName="",strSex="",strAge="",strEncounterId="",strAneasthetist="",strAneasthesia="",strPatientPosition="",strSourceType="",strSourceCode="",strSourceDesc="",strRemarks="",strFacilityId="",strPreOperDiag="",order_id="",ordered_date_time="",asst_surgeon_code="",asst_srgn1="",asst_srgn2="",sql_src="",strSrcTypeTemp="";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	sql=OTRepository.getOTKeyValue("SQL_OT_BOOKINGDTLS_SELECT1");
	strFacilityId=checkForNull(request.getParameter("facility_id"));
	strBookingNo=checkForNull(request.getParameter("booking_no"));

	try{
		conn = ConnectionManager.getConnection(request);
		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,strFacilityId);
		pstmt.setString(3,strBookingNo);
		rs=pstmt.executeQuery();

		if(rs.next()){
			if(strBookingNo.length()==0)
				strBookingNo=checkForNull(rs.getString("BOOKING_NUM1"));
			if(strBookingDate.length()==0)
				strBookingDate=checkForNull(rs.getString("BOOKING_DATE1"));
			if(strStartTime.length()==0){
				 strStartTime=checkForNull(rs.getString("BOOKING_START_TIME1"));
				 strEndTime=checkForNull(rs.getString("BOOKING_END_TIME1"));
		}

		 strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		 strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
		 strSex=checkForNull(rs.getString("SEX1"));
		 strAge=checkForNull(rs.getString("DATE_OF_BIRTH1"));
		 strEncounterId=checkForNull(rs.getString("ENCOUNTER_ID1"));
		 strRoomDesc=checkForNull(rs.getString("THEATRE_DESC1"));
		 strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
		 strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
		 strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
		 strAneasthetist=checkForNull(rs.getString("ANAESTHETIST_NAME1"));
		 strAneasthesia=checkForNull(rs.getString("ANAESTHESIA_DESC1"));
		 strPatientPosition=checkForNull(rs.getString("PATIENT_POSITION_DESC1"));
		 strSourceType=checkForNull(rs.getString("SOURCE_TYPE1"));
		 strSrcTypeTemp=checkForNull(rs.getString("SOURCE_TYPE1"));
		 strSourceCode=checkForNull(rs.getString("SOURCE_CODE1"));
		 strRemarks=checkForNull(rs.getString("BOOKING_REMARKS1"));
		 strPreOperDiag=checkForNull(rs.getString("PRE_OPER_DIAG1"));
		}
		rs.close();
		pstmt.close();
	   switch(strSourceType.charAt(0)){
			case 'C' : sql_src=OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT8");
						strSourceType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					   break;

			case 'E' : sql_src=OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT9");
					  strSourceType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
					   break;

			case 'N':
						sql_src=OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT7");
					   strSourceType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
					   break;
			
			default : sql_src=OTRepository.getOTKeyValue("SQL_OT_PROCEDURE_HDR_SELECT7");
					   strSourceType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
					   break;
	  }
	
		  pstmt = conn.prepareStatement(sql_src);
		  if(strSrcTypeTemp.equals("E")){
			  pstmt.setString(1,strSourceCode);
			  pstmt.setString(2,locale);
		  }else{
			  pstmt.setString(1,strFacilityId);
			  pstmt.setString(2,strSourceCode);
			  pstmt.setString(3,locale);
		  }
		  rs=pstmt.executeQuery();
		  if(rs.next()==true)
		  strSourceDesc=rs.getString("SHORT_DESC1");
		  if(strSourceDesc==""){
			  strSourceDesc=strSourceCode;
		  }

		  rs.close();
		  pstmt.close();

		 String SQL_ORDER_ID = "SELECT ORDER_ID FROM OT_BOOKING_HDR WHERE BOOKING_NUM = ?";
		 pstmt = conn.prepareStatement(SQL_ORDER_ID);
		 pstmt.setString(1,strBookingNo);
		 rs=pstmt.executeQuery();
		 order_id = (rs.next()==true)?checkForNull(rs.getString(1)):"";
		 rs.close();
		 pstmt.close();

		 if(!order_id.equals("")){
			String SQL_ORDER_DATE = "SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORDER_DATE_TIME FROM OR_ORDER WHERE ORDER_ID = ?";
			pstmt = conn.prepareStatement(SQL_ORDER_DATE);
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			ordered_date_time = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			rs.close();
			pstmt.close();
		 }

		String SQL_ASST_SURGEON="SELECT ASST_SURGEON_CODE,ASST_SURGEON_CODE_2,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE) ASST_SURGEON_DESC,GET_DESC(?,'AM_PRACTITIONER_LANG_VW','SHORT_NAME','PRACTITIONER_ID',ASST_SURGEON_CODE_2) ASST_SURGEON_DESC2 FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?";

		 pstmt = conn.prepareStatement(SQL_ASST_SURGEON);
		 pstmt.setString(1,locale);
		 pstmt.setString(2,locale);
		 pstmt.setString(3,strFacilityId);
		 pstmt.setString(4,strBookingNo);
 		 rs=pstmt.executeQuery();
		while(rs.next()){
		asst_surgeon_code=checkForNull(rs.getString("ASST_SURGEON_CODE"));
		asst_srgn1=checkForNull(rs.getString("ASST_SURGEON_DESC"));
		asst_srgn2=checkForNull(rs.getString("ASST_SURGEON_DESC2"));
		}

		rs.close();
		pstmt.close();
		
		switch(strSex.charAt(0)){
			case 'F': //strSex="Female";
				strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				break;
			case 'M': //strSex="Male";
				strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				break;
			case 'U': //strSex="Unknown";
				strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				break;
		}

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg From BookingDetail.jsp -->"+e);
	}
	finally{
		try{
			if(rs!=null) rs.close();
			pstmt.close();
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception ee){}
	}

%>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>

<input type='hidden' name='booking_no' id='booking_no' size='3'   value='<%=strBookingNo%>' disabled>
<input type='hidden' name='ordered_date_time' id='ordered_date_time' size='13' value='<%=ordered_date_time%>' disabled>  
<input type='hidden' name='booking_date' id='booking_date' size='8' value='<%=strBookingDate%>' disabled>
<input type='hidden' name='patient_id' id='patient_id' size='20'  align='right'  value="<%=strPatientId%>" disabled>
<input type='hidden' name='patient_name' id='patient_name' size='60'  align='right' value='<%=strPatientName%>' disabled>
<input type='hidden' name='sex' id='sex'  size='8'    value='<%=strSex%>' disabled>
<input type='hidden' name='date_of_birth' id='date_of_birth' size='10'  align='right' value='<%=strAge%>' disabled>
<input type='hidden' name='encounter_id' id='encounter_id' size='10'  align='right' value='<%=strEncounterId%>' disabled>
<input type='hidden' name='surgeon_name' id='surgeon_name' size='20' width="25%" value="<%=strSurgeonName%>" disabled>
<input type='hidden' name='start_time1' id='start_time1' size='3' value='<%=strStartTime%>' disabled>
<input type='hidden' name='end_time' id='end_time' size='3' value='<%=strEndTime%>' disabled>

<tr>	
	<td class='label' width="20%" >
			<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/> 
	</td>
	
	<td width="20%" class='fields'>
			<input type='text' name='waitlist_no' id='waitlist_no' size='20'  width="25%" value="<%=strRoomDesc%>" disabled >
	</td>
	
	<td class='label' width="25%">
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

	<td class='fields' width="25%">	
			<input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='20' value="<%=strSpecialityDesc%>" disabled>
	</td>

</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>&nbsp;1	
	</td>
	<td width="20%" class='fields'>
		<input type='text' name='asstSrgn_desc1' id='asstSrgn_desc1' size='20' value="<%=asst_srgn1%>" disabled>
	</td>
	<td class='label' width="25%">
		<fmt:message key="eOT.AsstSurgeon.Label" bundle="${ot_labels}"/>&nbsp;2	
	</td>
	<td width="20%" class='fields'>
		<input type='text' name='asstSrgn_desc2' id='asstSrgn_desc2' size='20' value="<%=asst_srgn2%>" disabled>
	</td>
</tr>
<tr>
		<td class='label' width="20%">
				<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
		<td width="20%" class='fields'>
				<input type='text' name='Anaesthetiest2_code' id='Anaesthetiest2_code' size='20' value="<%=strAneasthetist%>" disabled>
		</td>
		<td class='label' width="25%">
				<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/> </td>
		<td width="25%" class='fields' colspan='3'>
				<input type='text' name='Anaesthetia1_code' id='Anaesthetia1_code' size='20'  width="25%" value="<%=strAneasthesia%>" disabled>
		</td>
</tr>
<tr>
		<td class='label' width="20%">
				<fmt:message key="Common.PatientPosition.label" bundle="${common_labels}"/></td>
		<td  width="20%" class='fields'>
				<input type='text' name='Position_desc' id='Position_desc' size='20'  align='right' value ='<%=strPatientPosition%>' disabled>
		</td>
		<td class='label' width="25%" >
				<fmt:message key="Common.source.label" bundle="${common_labels}"/> </td>
		<td width="25%" class='fields'>
		<!-- ML-MMOH-CRF-0752.3-US001 -->
				<input type='text' name='Source_code' id='Source_code' size='65' value='<%=strSourceDesc%>' disabled>
				<img id="more_img" src='../../eOT/images/more.gif' onmouseover="Tip(getLongNameRefSrc())" onmouseout="UnTip()" style='position:absolute;visibility:hidden;'></img>
		</td>
</tr>
<tr>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>
		<td width='20%'></td>
		<td width='20%'></td>
		<td width='20%'></td>
		<td  align='right' >
			<input type='hidden' name='REMARKS' id='REMARKS' value="<%=strRemarks%>">
			<input type='hidden' name='pre_oper_diag' id='pre_oper_diag' value="<%=strPreOperDiag%>">
			<a  class='gridLink' href="javascript:showRemarks(document.forms[0].REMARKS,'0',remarks_value);">
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a> &nbsp;&nbsp;&nbsp;
			<% if(strFlag.equals("5")==true)
			{%>
			<a  class='gridLink' href="javascript:showAuditTrails('<%=strBookingNo%>');">
			<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;&nbsp;
			<%}%>
			<a  class='gridLink' href="javascript:showRemarks1(document.forms[0].pre_oper_diag,'0',preOperativeDiag_value);"><fmt:message key="eOT.PreOperativeDiagnosis.Label" bundle="${ot_labels}"/></a>
		</td>
</tr>
</table>
</table>
<input type='hidden' name='flag' id='flag' value="<%=strFlag%>">
<input type='hidden' name='asst_surgeon_code' id='asst_surgeon_code' value="<%=asst_surgeon_code%>">
<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=strSurgeonCode%>">
<input type='hidden' name='start_time' id='start_time' value="<%="01/05/2005 "+strStartTime%>">
<input type='hidden' name='speciality_code' id='speciality_code' value="<%=strSpecialityCode%>">
<input type='hidden' name='room_code' id='room_code' value="<%=strRoomCode%>">
<input type='hidden' name='facilityid' id='facilityid' value="<%=strFacilityId%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='HLongRefSrcId' id='HLongRefSrcId' value="<%=strSourceCode%>">
<input type='hidden' name='strSourceDesc' id='strSourceDesc' value="<%=strSourceDesc%>">
<input type='hidden' name='strSrcTypeTemp' id='strSrcTypeTemp' value="<%=strSrcTypeTemp%>">
<input type='hidden' name='HsrcLongName' id='HsrcLongName' value="">

</form>
</BODY>
</HTML>


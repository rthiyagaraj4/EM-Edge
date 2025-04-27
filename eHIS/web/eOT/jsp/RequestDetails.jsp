<!DOCTYPE html>
<html>             
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<title> <fmt:message key="eOT.BookingWindow.Label" bundle="${ot_labels}"/></title>
<%

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
<script type='text/javascript' src='../../eOT/js/ManageQuery.js'></script>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<% 
	String strBookingDate=checkForNull(request.getParameter("booking_date"));
	String statusDesc = checkForNull(request.getParameter("statusDesc"));
	String strSurgeonName=checkForNull(request.getParameter("surgeonName"));
	String strSurgeonCode=checkForNull(request.getParameter("surgeonCode"));
	String strStartTime=checkForNull(request.getParameter("start_time"));
	String strRoomDesc=checkForNull(request.getParameter("roomDesc"));
	String strOperDesc=checkForNull(request.getParameter("oper_desc"));
	String strRoomCode=checkForNull(request.getParameter("roomCode"));
	String strSpecialityDesc=checkForNull(request.getParameter("speciality_desc"));
	String strSpecialityCode=checkForNull(request.getParameter("speciality_code"));
	String strFlag=checkForNull(request.getParameter("transfer"));
	String sql="",strBookingNo="",strEndTime="",strPatientId="",strPatientName="",strSex="",strAge="",strEncounterId="",strAneasthetist="",strAneasthesia="",strPatientPosition="",strSourceType="",strSourceCode="",strSourceDesc="",strRemarks="",strFacilityId="",strPreOperDiag="",order_id="",ordered_date_time="",asst_surgeon_code="",asst_srgn1="",asst_srgn2="",sql_src="",strSrcTypeTemp="",strOperDescp="",strBkngStatus="";;
	Connection conn = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	sql=OTRepository.getOTKeyValue("SQL_OT_ITEMDTLS_SELECT1");
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
		 strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));//lakshmi
		 System.err.println("strSpecialityDesc="+strSpecialityDesc);
		 strSpecialityCode=checkForNull(rs.getString("SPECIALITY_CODE1"));
		 strAneasthetist=checkForNull(rs.getString("ANAESTHETIST_NAME1"));
		 strAneasthesia=checkForNull(rs.getString("ANAESTHESIA_DESC1"));
		 strPatientPosition=checkForNull(rs.getString("PATIENT_POSITION_DESC1"));
		 strSourceType=checkForNull(rs.getString("SOURCE_TYPE1"));
		 strSrcTypeTemp=checkForNull(rs.getString("SOURCE_TYPE1"));
		 strSourceCode=checkForNull(rs.getString("SOURCE_CODE1"));
		 strRemarks=checkForNull(rs.getString("BOOKING_REMARKS1"));
		 strPreOperDiag=checkForNull(rs.getString("PRE_OPER_DIAG1"));
		 String strOperDes=checkForNull(rs.getString("OPER_CODE1"));
		 strBkngStatus=checkForNull(rs.getString("BOOKING_STATUS1"));
		String sql1="SELECT SHORT_DESC FROM OT_OPER_MAST WHERE OPER_CODE = ?";
		 pstmt1=conn.prepareStatement(sql1);
		 pstmt1.setString(1,strOperDes);
		 rs1=pstmt1.executeQuery();
		  System.err.println("strSpecialityDesc="+rs1);
		if(rs1.next())
				strOperDescp=checkForNull(rs1.getString("SHORT_DESC"));
		}
		rs.close();
		pstmt.close();
		rs1.close();
		pstmt1.close();
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
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>


<tr>	
	<td class='label' width="20%" >
			<fmt:message key="eOT.SurgeonRep.Label" bundle="${ot_labels}"/> 
	</td>
	
	<td width="20%" class='fields'>
			<input type='text' name='surgeon' id='surgeon' size='20'  width="25%" value="<%=strSurgeonName%>" disabled>
	</td>
	
	<td class='label' width="25%">
			<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
<td class='fields' width="25%">	
			<input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='20' value="<%=strSpecialityDesc%>" disabled>
	</td>

</tr>
<tr>
	<td class='label' width="25%">
		<fmt:message key="eOT.Theatre.label" bundle="${ot_labels}"/>
	</td>
	<td width="20%" class='fields'>
		<input type='text' name='theatre' id='theatre' size='20' value="<%=strRoomDesc%>" disabled>
	</td>
	<td class='label' width="25%">
		<fmt:message key="eOT.OperationDescription.Label" bundle="${ot_labels}"/>	
	</td>
	<td width="20%" class='fields'>
		<input type='text' name='oper_desc' id='oper_desc' value="<%=strOperDescp%>" size='20' disabled>
	</td>
</tr>
<tr>
		<td class='label' width="20%">
				<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
		<td width="20%" class='fields'>
				<input type='text' name='Anaesthetist' id='Anaesthetist' size='20' value="<%=strAneasthetist%>" disabled>
		</td>
		<td class='label' width="25%">
				<fmt:message key="eOT.OperationType.label" bundle="${ot_labels}"/> </td>
		<td width="25%" class='fields' colspan='3'>
				<input type='text' name='operationType' id='operationType' size='20'  width="25%"  value="<%=strOperDescp%>" disabled>
		</td>
</tr>
<tr>
		<td class='label' width="20%">
				<fmt:message key="eOT.Status.Label" bundle="${ot_labels}"/></td>
		<td  width="20%" class='fields'>
				<input type='text' name='status' id='status' size='20'  align='right' value='<%=statusDesc%>' disabled>
		</td>
		<td class='label' width="25%" >
				<fmt:message key="Common.source.label" bundle="${common_labels}"/> </td>
		<td width="25%" class='fields'>
		<!-- ML-MMOH-CRF-0752.3-US001 -->
				<input type='text' name='Source_code' id='Source_code' size='36' value='<%=strSourceDesc%>' disabled>
				<img id="more_img" src='../../eOT/images/more.gif' style='position:absolute;visibility:hidden;'></img>
		</td>
</tr>
<tr>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' maalign='center'>
	<tr>
		<td width='20%'></td>
		<td width='20%'></td>
		<td width='20%'></td>

</tr>
</table>
</table>
<input type='hidden' name='booking_no' id='booking_no' value="<%=strBookingNo%>">
</BODY>
</HTML>


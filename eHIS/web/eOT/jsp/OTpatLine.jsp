<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:set var="prefix" value="${'/eCommon/html/'}" /> 
<c:set var="sep" value="${'?'}" /> 
<c:set var="style" value="${prefix}${sessionScope.PREFERRED_STYLE}" /> 
<c:set var="locale" value="${sessionScope.LOCALE}" /> 
<html>
<head>
<link rel='StyleSheet' type='text/css'  href='<c:url value="${style}" />' />
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
</head>
</head>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

    String patient_id = checkForNull(request.getParameter("patient_id")).intern();
    String ordering_facility_id = checkForNull((String)session.getValue("ordering_facility_id"));
	String facility_id = (String) session.getAttribute("facility_id");
	if(ordering_facility_id != null && ordering_facility_id.length() > 0)
	{
		facility_id = ordering_facility_id;
	}
	String booking_no = checkForNull(request.getParameter("booking_no"),checkForNull(request.getParameter("booking_num"))).intern();
	String parent_source_id = checkForNull(request.getParameter("parent_source_id")).intern(); // When invoked from Anaesthesia screens
	String source_order_id = checkForNull(request.getParameter("source_order_id")).intern(); // When invoked from Anaesthesia screens
	String order_id = checkForNull(request.getParameter("order_id"),checkForNull(request.getParameter("orderid"))).intern();
	String oper_num = checkForNull(request.getParameter("oper_num")).intern();
	String oper_date = checkForNull(request.getParameter("theatre_date"),request.getParameter("oper_date"));
	String theatre_desc=checkForNull(request.getParameter("roomDesc"));
	String surgeon_name=checkForNull(request.getParameter("surgeonName"));
	String speciality_desc=checkForNull(request.getParameter("speciality_desc"));
	Connection con = null;
//	Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;
	ResultSet rst = null;
	String empty = "".intern();
	if(parent_source_id!="" ) order_id = parent_source_id;
	if(source_order_id!="" )  	order_id = source_order_id;
	String booked_date="",start_time="",end_time="",encounter_id="",ordered_date_time = "",sql_book_dtls="";
	try{	
		con=ConnectionManager.getConnection(request);

		if( order_id!=empty && order_id!="0" ) {
			String SQL_ORDER_DATE = "SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORDER_DATE_TIME FROM OR_ORDER WHERE ORDER_ID = ?";
			pstmt = con.prepareStatement(SQL_ORDER_DATE);
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			ordered_date_time = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			ordered_date_time =com.ehis.util.DateUtils.convertDate(ordered_date_time,"DMYHM","en",locale); 
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();

			String patient_qry = "SELECT PATIENT_ID,ENCOUNTER_ID, B.SHORT_DESC, C.PRACTITIONER_NAME FROM OT_PENDING_ORDER A, AM_SPECIALITY B, AM_PRACTITIONER C WHERE PERFORMING_FACILITY_ID=? AND ORDER_ID=? AND A.SPECIALITY_CODE = B.SPECIALITY_CODE(+) AND A.PHYSICIAN_ID = C.PRACTITIONER_ID(+)";

			pstmt = con.prepareStatement(patient_qry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,order_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				patient_id = checkForNull(rs.getString(1));
				encounter_id = checkForNull(rs.getString(2));
				surgeon_name = checkForNull(rs.getString(3));
				speciality_desc = checkForNull(rs.getString(4));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(booking_no==empty){
				pstmt = con.prepareStatement("SELECT BOOKING_NUM FROM OT_BOOKING_HDR WHERE ORDER_ID = ? AND OPERATING_FACILITY_ID='"+facility_id+"'");
				pstmt.setString(1,order_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					booking_no = rs.getString("BOOKING_NUM");
				}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	    	}
			
		 }
		 if(rs != null) rs.close(); //SS-007
		 if(pstmt != null) pstmt.close();//SS-007
			if(!booking_no.equals(""))
			{
			 sql_book_dtls="SELECT to_char(BOOKING_DATE,'dd/mm/yyyy') BOOKING_DATE1, to_char(BOOKING_START_TIME,'hh24:mi') BOOKING_START_TIME1, to_char(BOOKING_END_TIME,'hh24:mi') BOOKING_END_TIME1,ENCOUNTER_ID ENCOUNTER_ID1, THEATRE_DESC THEATRE_DESC1, SURGEON_NAME SURGEON_NAME1,SPECIALITY_DESC SPECIALITY_DESC1 FROM  OT_BOOKINGS_VW WHERE LANGUAGE_ID = ? AND OPERATING_FACILITY_ID = ?  AND BOOKING_NUM = ?";
			}else
			{
				if(!oper_num.equals("")){

					
					 sql_book_dtls="SELECT ENCOUNTER_ID ENCOUNTER_ID1,get_desc('"+locale+"','OT_OPER_ROOM_LANG_VW','LONG_DESC','OPER_ROOM_CODE',ot_post_oper_hdr.OPER_ROOM_CODE)  THEATRE_DESC1,GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',ot_post_oper_hdr.SPECIALITY_CODE),GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ot_post_oper_hdr.SURGEON_CODE) SURGEON_NAME1,OPER_NUM  FROM  ot_post_oper_hdr WHERE OPERATING_FACILITY_ID =?  AND  OPER_NUM = ?";
				}else{

					
					sql_book_dtls="SELECT ENCOUNTER_ID ENCOUNTER_ID1,get_desc('"+locale+"','OT_OPER_ROOM_LANG_VW','LONG_DESC','OPER_ROOM_CODE',ot_post_oper_hdr.OPER_ROOM_CODE)  THEATRE_DESC1,GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',ot_post_oper_hdr.SPECIALITY_CODE),GET_DESC('"+locale+"','AM_PRACTITIONER_LANG_VW','PRACTITIONER_NAME','PRACTITIONER_ID',ot_post_oper_hdr.SURGEON_CODE) SURGEON_NAME1,OPER_NUM  FROM  ot_post_oper_hdr WHERE OPERATING_FACILITY_ID =?  AND  ORDER_ID = ?";

				}
			}
  if(!booking_no.equals(""))
		{       
			pstmt = con.prepareStatement(sql_book_dtls);
			
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,booking_no);
		}else
			{
				if(!oper_num.equals("")){
					pstmt = con.prepareStatement(sql_book_dtls);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,oper_num);
				}else{
					pstmt = con.prepareStatement(sql_book_dtls);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,source_order_id);
				}
			}
			rst = pstmt.executeQuery();
			while(rst.next()){
				if(!booking_no.equals(""))
				{
					booked_date=checkForNull(rst.getString(1));
					booked_date =checkForNull(com.ehis.util.DateUtils.convertDate(booked_date,"DMY","en",locale));
					start_time=checkForNull(rst.getString(2));
					end_time=checkForNull(rst.getString(3));
					encounter_id=checkForNull(rst.getString(4));
					theatre_desc=checkForNull(rst.getString(5));
					surgeon_name=checkForNull(rst.getString(7));
					speciality_desc=checkForNull(rst.getString(6));
				}else
				{
					encounter_id=checkForNull(rst.getString(1));
					theatre_desc=checkForNull(rst.getString(2));
					speciality_desc=checkForNull(rst.getString(3));
					surgeon_name=checkForNull(rst.getString(4));
					oper_num=checkForNull(rst.getString(5));
				}
			}
		 if(rst != null) rst.close();
		 if(pstmt != null) pstmt.close();
	 if(oper_num!=empty){
			String oper_date_qry = "SELECT TO_CHAR(OPER_DATE,'DD/MM/YYYY') FROM OT_QUEUE WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
			pstmt = con.prepareStatement(oper_date_qry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				oper_date =   checkForNull(rs.getString(1));
			}
		 }
		 if(rs != null) rs.close();
		 if(pstmt != null) pstmt.close();

	if(oper_num!=empty){
			String sql_theatre_desc="select  GET_DESC('"+locale+"',' ot_oper_room_lang_vw','LONG_DESC','OPER_ROOM_CODE',a.OPER_ROOM_CODE) theatre_desc	from ot_post_oper_hdr a where a.OPERATING_FACILITY_ID='"+facility_id+"' and a.OPER_NUM='"+oper_num+"'	";
			pstmt = con.prepareStatement(sql_theatre_desc);
			rst = pstmt.executeQuery();
			if(rst !=null && rst.next()){
				theatre_desc=checkForNull(rst.getString("theatre_desc"));
			}
	    }
		 if(rst != null) rst.close();
		 if(pstmt != null) pstmt.close();

	if(order_id==empty || order_id=="0"){
			String SQL_ORDER_ID = "SELECT ORDER_ID FROM OT_BOOKING_HDR WHERE BOOKING_NUM = ? AND OPERATING_FACILITY_ID='"+facility_id+"'";
	 		pstmt = con.prepareStatement(SQL_ORDER_ID);
			pstmt.setString(1,booking_no);
			rs=pstmt.executeQuery();
			order_id = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			rs.close();
			pstmt.close();

			String SQL_ORDER_DATE = "SELECT TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') ORDER_DATE_TIME FROM OR_ORDER WHERE ORDER_ID = ?";
			pstmt = con.prepareStatement(SQL_ORDER_DATE);
			pstmt.setString(1,order_id);
			rs=pstmt.executeQuery();
			ordered_date_time = (rs.next()==true)?checkForNull(rs.getString(1)):"";
			ordered_date_time =com.ehis.util.DateUtils.convertDate(ordered_date_time,"DMYHM","en",locale); 
			 if(rs != null) rs.close();
			 if(pstmt != null) pstmt.close();
		}

     }catch(Exception e){
	   System.err .println("Error OTPatLine.jsp : "+e.toString());
	}finally{	
		try{
				//if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();				
				//Modified against SS-007
				if(rs != null) rs.close();
				if(rst != null) rst.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){System.err.println("CMG IN PAT LINE :" +e);}
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
oper_date=com.ehis.util.DateUtils.convertDate(oper_date,"DMY","en",locale); 

%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div id='1'>
<table border="0" cellpadding=3  cellspacing="0" width="100%">
<tbody>
<tr>
 <% if(order_id!=empty){ %>
	<td class='PATIENTLINECOLOR' align="left" title='Order ID/Ordered Date/Time' >
		<font size='1' style="font-weight:bold">[<%=order_id%>,&nbsp;<%=ordered_date_time%>]</font>	
	 </td>
 <%}else{%>
	  <td class='PATIENTLINECOLOR' align="left">&nbsp;</td>
 <%}%>

 <td  class='PATIENTLINECOLOR' align='center' title='Speciality/Surgeon/Theatre'>
	<font size='1' style="font-weight:bold"><%=surgeon_name%>/<%=speciality_desc%>/<%=theatre_desc%></font>
</td>

  <% if(booking_no!=empty){ %>
	<td class='PATIENTLINECOLOR' align="center" title='Booking No/Booking Date/Time'>
		<font size='1' style="font-weight:bold"><%=booking_no%>,&nbsp;<%=booked_date%>&nbsp;&nbsp;<%=start_time+"-"%><%=end_time%>
	</td>
 <%}else{%>
	  <td class='PATIENTLINECOLOR' align="center">&nbsp;</td>
 <%}%>
    
  <% if(oper_num!=empty){ %>
	<td class='PATIENTLINECOLOR' align="right" title='Oper No/Oper Date'>
			<font size='1' style="font-weight:bold"><%=oper_num%>,&nbsp;<%=oper_date%></font>
		</td>	
	</td>
 <%}else{%>
	  <td class='PATIENTLINECOLOR' align="right" >&nbsp;</td>
 <%}%>
 </tr>	
 </div> 
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='oper_date' id='oper_date' value="<%=oper_date%>">
</div>
</tbody>
</table>
</body>
<html>


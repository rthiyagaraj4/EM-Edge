<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<%
	String patient_id = checkForNull(request.getParameter("patient_id")).intern();
	String ordering_facility_id = checkForNull((String)session.getValue("ordering_facility_id"));
	String facility_id = (String) session.getAttribute("facility_id");
	String strOrderFacilityId="";//Added by lakshmi against performing facility change
	//Added by lakshmi against change in performing_facility starts here
	String performing_facility_id = (String)session.getValue("performing_facility");
	if(performing_facility_id!=null && performing_facility_id.length()>0)
		{
		 	facility_id = (String) session.getAttribute("performing_facility");
		}
	if(ordering_facility_id != null && ordering_facility_id.length() > 0)
	{
		facility_id = ordering_facility_id;
	}
	//Added by lakshmi against change in performing_facility ends here
	
	String booking_no = checkForNull(request.getParameter("booking_no"),checkForNull(request.getParameter("booking_num"))).intern();
	String parent_source_id = checkForNull(request.getParameter("parent_source_id")).intern(); // When invoked from Anaesthesia screens
	String source_order_id = checkForNull(request.getParameter("source_order_id")).intern(); // When invoked from Anaesthesia screens
	Connection con = null;
//	Statement stmt	= null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;
	//ResultSet rst = null;
	String empty = "".intern();
	String order_id = checkForNull(request.getParameter("order_id"),checkForNull(request.getParameter("orderid"))).intern();
	//order_id = (order_id==empty)?checkForNull(request.getParameter("orderid")).intern():order_id; 
	if(parent_source_id!="" ) order_id = parent_source_id;
	if(source_order_id!="" ) 	order_id = source_order_id;
	String encounter_id=empty;

	try{	
		con=ConnectionManager.getConnection(request);
		if(order_id!=empty && order_id!="0"){
			if(booking_no==empty){
				pstmt = con.prepareStatement("SELECT BOOKING_NUM FROM OT_BOOKING_HDR WHERE ORDER_ID = ?");
				pstmt.setString(1,order_id);
				rs=pstmt.executeQuery();
				while(rs.next()){
					booking_no = rs.getString("BOOKING_NUM");
				}
				rs.close();
				pstmt.close();
			}
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();
		  String patient_qry = "SELECT PATIENT_ID,ENCOUNTER_ID FROM OT_PENDING_ORDER  WHERE PERFORMING_FACILITY_ID=? AND ORDER_ID=? ";
			pstmt = con.prepareStatement(patient_qry);
			pstmt.setString(1,facility_id);
//			pstmt.setString(2,source_order_id);
			pstmt.setString(2,order_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				patient_id = rs.getString(1);
				encounter_id = checkForNull(rs.getString(2));
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		if(booking_no!=empty){
			String patient_qry = "SELECT PATIENT_ID,ENCOUNTER_ID FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID=? AND BOOKING_NUM=?";
			pstmt = con.prepareStatement(patient_qry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				patient_id =   rs.getString(1);
				encounter_id = checkForNull(rs.getString(2));
				}
			rs.close();
			pstmt.close();
		 }
	}catch(Exception e){
	   System.err.println("Error CommonPatLine.jsp : "+e.toString());
	}finally{	
		try{
			//if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			//Modified against SS-007
			if(rs != null) rs.close(); 
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){System.err.println(e);}
		//if(con!=null) ConnectionManager.returnConnection(con,request);
	}


	String URL="../../eCommon/jsp/pline.jsp?Facility_Id="+facility_id+"&EncounterId="+encounter_id+"&Patient_Id="+patient_id;
	request.getRequestDispatcher(URL).include(request,response);
%>

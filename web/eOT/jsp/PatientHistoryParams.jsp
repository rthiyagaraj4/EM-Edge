
<%@page   import="java.sql.Connection,java.util.*,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eOT.Common.*, eOT.*"%>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

	try {
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String oper_num		= (String) hash.get("oper_num");
		String booking_num	= (String) hash.get("booking_num");
		String order_num	= (String) hash.get("order_num");
		
		String facility_id =(String)session.getAttribute("facility_id");
		String patient_sql="";
		if(booking_num!=null && !(booking_num.equals("")) && !(booking_num.equals("null"))){
			patient_sql="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND BOOKING_NUM = '"+booking_num+"' ";
		}
		else if(oper_num!=null && !(oper_num.equals("")) && !(oper_num.equals("null"))){
			//patient_sql="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND BOOKING_NUM = '"+booking_num+"' ";
			patient_sql="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_NUM = '"+oper_num+"' ";
		}
		if(order_num!=null && !(order_num.equals("")) && !(order_num.equals("null"))){
		patient_sql="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OR_ORDER WHERE ORDERING_FACILITY_ID = '"+facility_id+"' AND ORDER_ID = '"+order_num+"' ";
		}
	
		String 	encounter_id = "";
		String patient_class="";
		conn		= ConnectionManager.getConnection(request);
		pstmt		= conn.prepareStatement(patient_sql) ;
		rs			= pstmt.executeQuery();
		if(rs!=null && rs.next()){
		encounter_id = rs.getString("ENCOUNTER_ID");
		patient_class = rs.getString("PATIENT_CLASS");
		}
		out.println(encounter_id+"::"+patient_class);
					
	}catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
	finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception es){es.printStackTrace();}
}

%>

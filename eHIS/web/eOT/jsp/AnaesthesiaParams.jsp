
<%@page  import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eOT.Common.*, eOT.*,java.util.Hashtable" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

	try {
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String order_id		= (String) hash.get("order_id");
		String function_id		= (String) hash.get("function_id");

		
//		String facility_id =(String)session.getAttribute("facility_id");
		String anaes_sql="";
		
		anaes_sql="SELECT ANAESTHESIA_SERIAL_NUM, PREOP_ASSE_DONE_YN, INTRAOP_DONE_YN, POSTOP_DONE_YN FROM AT_ANAESTHESIA_RECORD_HDR WHERE SOURCE_ORDER_ID= ? ";

		String 	anaesthesia_serial_num="";
		String  preop_asse_done_yn="";
		String  intraop_done_yn="";
		String  postop_done_yn="";
		String source_order_id ="";
		String request_source_type ="";
		String anaesthetist_code = "";

		String pre_oper_flag="AnesthesiaDetails";
		conn			= ConnectionManager.getConnection(request);
		pstmt				= conn.prepareStatement(anaes_sql) ;
		pstmt.setString(1,order_id);
		rs			= pstmt.executeQuery();
		if(rs!=null && rs.next()){
		anaesthesia_serial_num = rs.getString("ANAESTHESIA_SERIAL_NUM");
		if(anaesthesia_serial_num==null) anaesthesia_serial_num="";
		preop_asse_done_yn = rs.getString("PREOP_ASSE_DONE_YN");
		intraop_done_yn = checkForNull(rs.getString("INTRAOP_DONE_YN"),"N");
		postop_done_yn = checkForNull(rs.getString("POSTOP_DONE_YN"),"N");

		}	

		if(anaesthesia_serial_num.equals("") && function_id.equals("09")){
		anaes_sql="SELECT ORDER_ID,SOURCE_ORDER_ID,REQUEST_SOURCE_TYPE, ANAESTHETIST_CODE FROM AT_PENDING_ORDERS WHERE SOURCE_ORDER_ID =? ";
		pstmt	= conn.prepareStatement(anaes_sql) ;
		pstmt.setString(1,order_id);
		rs		= pstmt.executeQuery();
		if(rs!=null && rs.next()){
			order_id = checkForNull(rs.getString("ORDER_ID"));
			source_order_id = checkForNull(rs.getString("SOURCE_ORDER_ID"));
			request_source_type = checkForNull(rs.getString("REQUEST_SOURCE_TYPE"));
			anaesthetist_code = checkForNull(rs.getString("ANAESTHETIST_CODE"));
			pre_oper_flag="PendingOrders";
		}else{
			pre_oper_flag="AnaesthesiaNotApplicable";
		}
		}
		out.println(anaesthesia_serial_num+"::"+preop_asse_done_yn+"::"+intraop_done_yn+"::"+postop_done_yn+"::"+pre_oper_flag+"::"+order_id+"::"+source_order_id+"::"+request_source_type+"::"+anaesthetist_code);
					
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


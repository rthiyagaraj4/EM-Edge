<!DOCTYPE html>
<%
//"java.sql.*, java.util.*, java.io.*, eOT.Common.*, eOT.*"
%>
<%@page  import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.*, eOT.*,java.util.Hashtable" contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String 	booking_num = "";
		String order_id="";
		String oper_num="";
		String scan_sql="";
		String comp="parent.parent.frames[1].frames[1].forms[0].scan_option";
	try {
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String url_desc		= (String) hash.get("url_desc");
		String patient_id		= (String) hash.get("patient_id");
		String facility_id =(String)session.getAttribute("facility_id");

		conn			= ConnectionManager.getConnection(request);
		
		if(url_desc.equals("OTCheckIn")){
			scan_sql="SELECT OPERATING_FACILITY_ID, BOOKING_NUM, ORDER_ID FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND BOOKING_DATE BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59', 'DD/MM/YYYY HH24:MI') AND BOOKING_STATUS IN ('0')";

			pstmt = conn.prepareStatement(scan_sql) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rs			= pstmt.executeQuery();
			while(rs!=null && rs.next()){
			oper_num += rs.getString("BOOKING_NUM")+"#";
			}
			if(oper_num==null) oper_num="";
			
			if(!oper_num.equals(""))
			{
				oper_num +="##"+"scheduled";
			}else{
				//oper_num +=
				scan_sql="SELECT ORDERING_FACILITY_ID, ORDER_ID FROM OR_ORDER WHERE ORDERING_FACILITY_ID = ? AND PATIENT_ID = ? AND ORD_DATE_TIME  BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59', 'DD/MM/YYYY HH24:MI') AND ORDER_STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  ORDER_STATUS_TYPE IN ('10'))";
				pstmt				= conn.prepareStatement(scan_sql) ;
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				rs			= pstmt.executeQuery();
				while(rs!=null && rs.next()){
				oper_num += rs.getString("ORDER_ID")+"#";
				}
				oper_num +="##"+"un_scheduled";

			}
		}
		else if(url_desc.equals("OTCheckInToOR")){
			scan_sql="SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND  OPER_DATE BETWEEN TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY')||' 23:59', 'DD/MM/YYYY HH24:MI') AND OPER_STATUS IN ('40','45')";
			pstmt				= conn.prepareStatement(scan_sql) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			rs			= pstmt.executeQuery();
			while(rs!=null && rs.next()){
			oper_num += rs.getString("OPER_NUM")+"#";
		 }
	  }
			out.println(oper_num);	
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
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</html>


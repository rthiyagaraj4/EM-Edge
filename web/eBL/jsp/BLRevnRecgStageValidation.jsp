
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%!
     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
 	}
%>


<%
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null ;
	ResultSet rs1 = null;
	PreparedStatement pstmt2 = null ;
	ResultSet rs2 = null;
	String calld_frm = request.getParameter("calld_frm"); if(calld_frm==null) calld_frm="";
	String ordercat = request.getParameter("ordercat") == null ? "" :request.getParameter("ordercat") ;
	
	if(calld_frm.equals("getDesc"))
	{
		String long_desc=null;
		String short_desc=null;
	try{
		String sqlqry ="select long_desc,short_desc from OR_ORDER_CATEGORY where order_category='"+ordercat+"'";
		pstmt = con.prepareStatement(sqlqry) ;
		rs = pstmt.executeQuery(sqlqry);
		while(rs.next()){
			long_desc=checkForNull(rs.getString(1));
			short_desc=checkForNull(rs.getString(2));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in getOrder BlRevnRecgStagVal.jsp::"+e);
	}	
	out.println(long_desc+":"+short_desc);
}
if(calld_frm.equals("getOrderType"))
	{
		String long_desc="";
		String orderTypeCode="";
		int count=0;
		String retDesc="";
	try{
		String sql1="select count(*) from or_order_type where ORDER_CATEGORY ='"+ordercat+"'";
		pstmt1 = con.prepareStatement(sql1) ;
		rs1 = pstmt1.executeQuery() ;
					 
		 while(rs1.next()){
			 count=rs1.getInt(1);
		 }
		 
		String sqlqry1 ="select distinct long_desc,ORDER_TYPE_CODE from or_order_type where order_category='"+ordercat+"' and long_desc is not null";
		if(count>1){
			sqlqry1="select '**','**' from dual union "+sqlqry1;
		} 
		pstmt2 = con.prepareStatement(sqlqry1) ;
		rs2 = pstmt2.executeQuery();
		while(rs2.next()){
			
			long_desc=checkForNull(rs2.getString(1));
			orderTypeCode=checkForNull(rs2.getString(2));
			retDesc=retDesc+long_desc+":"+orderTypeCode+"~~";
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in getOrdertyp BlRevnRecgVal.jsp::"+e);
	}
	
	out.println(retDesc);
}
%>

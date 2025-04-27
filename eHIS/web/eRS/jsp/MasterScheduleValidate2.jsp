<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleValidate2.jsp
*	Purpose 		:	To assign the shift to a particular staff according to the selected shift pattern
*	Created By		:	Subbulakshmy. K
*	Created On		:	25-11-2004
*/
%>

<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%  
	String mode= request.getParameter("mode")==null?"":request.getParameter("mode") ;		
	String facility_id= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String shift_pattern_id= request.getParameter("shift_pattern_id")==null?"":request.getParameter("shift_pattern_id") ;	
	String week_no= request.getParameter("week_no")==null?"":request.getParameter("week_no") ;
	String role_type= request.getParameter("role_type")==null?"":request.getParameter("role_type") ;	
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");

	Connection conn 				= null;
	PreparedStatement pstmt 	    = null;
	ResultSet resultSet 			= null;
	ArrayList Shift_Dtl	            = new ArrayList();
	String[] record					= null;
	try {
		 conn = ConnectionManager.getConnection(request);
		String sql_shift_dtl		="SELECT a.day_no, a.shift_code, a.shift_mnemonic, b.shift_indicator, b.productive_flag  FROM rs_shift_pattern_dtl a, am_shift b WHERE a.facility_id = ? and a.shift_pattern_id=? AND a.week_no = ? and a.shift_code=b.shift_code";

		//to get the date range
		pstmt = conn.prepareStatement( sql_shift_dtl);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,shift_pattern_id);
		pstmt.setString(3,week_no);
		resultSet = pstmt.executeQuery() ;
		System.err.println("shift_pattern_id-------|" +shift_pattern_id+ "|------week_no------|" +week_no+ "|---");
		while (resultSet != null && resultSet.next()) {
			record = new String[5];				
			record[0] = resultSet.getString("day_no");
			record[1] = resultSet.getString("shift_code");
			record[2] = resultSet.getString("shift_mnemonic");
			record[3] = resultSet.getString("shift_indicator");
			record[4] = resultSet.getString("productive_flag");
			Shift_Dtl.add(record) ;
		}
		
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		//to add shifts
		if(mode.equals("all"))
			for(int i=0;i<Shift_Dtl.size();i++){
				record = (String[])Shift_Dtl.get(i);
				out.println( "assignallShift(\"" + record[0] + "\",\"" + record[1] + "\",\""+record[2]+ "\",\"" +record[3] + "\",\""+record[4]+"\") ; " ) ;		
			}
		else
			for(int i=0;i<Shift_Dtl.size();i++){
				record = (String[])Shift_Dtl.get(i);
				out.println( "assignShift(\"" + record[0] + "\",\"" + record[1] + "\",\""+record[2]+ "\",\"" + record[3] + "\",\""+record[4]+"\",\""+role_type+ "\",\"" + staff_id + "\",\"" + position_code+ "\");");		
			}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

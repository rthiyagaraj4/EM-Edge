<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleValidate1.jsp
*	Purpose 		:	To list the posotion according to the seceted role type & staff type
*	Created By		:	Subbulakshmy. K
*	Created On		:	25-11-2004
*/
%>

<%@page import="java.util.*,eRS.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%  //System.err.println("entering into validate1jsp");
	String role_type= request.getParameter("role")==null?"":request.getParameter("role");		
	String staff_type= request.getParameter("staff_type")==null?"":request.getParameter("staff_type");
	String facility_id= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String workplace_code= request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id= request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");		

	if(staff_type==null)
		staff_type="";
	Connection conn 				= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	ArrayList Position_List		= new ArrayList();
	ArrayList StaffType_List	= new ArrayList();	
	ArrayList Date_Data			= new ArrayList();	
	String[] record					= null;
	String sql_position				="";
	try {
	    conn = ConnectionManager.getConnection(request);
		if(staff_type.equals("")){
			System.err.println("chking if ondition");
			sql_position	="select position_code, position_desc from am_position where eff_Status = 'E' and role_type=?";
			String sql_stafftype			="select pract_type staff_type, desc_userdef staff_desc from am_pract_type where eff_Status = 'E' and ? = 'P' union select other_staff_type staff_type, short_desc staff_desc from am_other_staff_type where eff_status = 'E' and ? = 'O' order by staff_desc";

			pstmt = conn.prepareStatement( sql_stafftype) ;
			pstmt.setString(1, role_type);
			pstmt.setString(2, role_type);

			resultSet = pstmt.executeQuery() ;
			System.err.println("role_type-->" +role_type);
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "staff_type");
				record[1] = resultSet.getString( "staff_desc");
				StaffType_List.add(record) ;
			}
			if(pstmt!= null)
				pstmt.close();
			if(resultSet!= null)
				resultSet.close();
			//to list staff_type
			for( int i=0 ; i< StaffType_List.size() ; i++ ) {
				System.err.println("executing for loop");
				record = (String[])StaffType_List.get(i);
				out.println( "addStaffType(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;			
			}
		}else{
			sql_position	="select position_code, position_desc from am_position where eff_Status = 'E' and role_type=? and staff_type =?";
		}
		//to get the locantion type
		pstmt = conn.prepareStatement( sql_position);
		pstmt.setString(1,role_type);
		if(!staff_type.equals(""))
			pstmt.setString(2,staff_type);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("position_code");
			record[1] = resultSet.getString("position_desc");
			Position_List.add(record) ;
		}
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		//to list postion
		for( int i=0 ; i< Position_List.size() ; i++ ) {
			record = (String[])Position_List.get(i);
           System.out.println("record ---> "+i+" - "+record[0]+" - "+record[1]);
			out.println( "addPosition(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;			
		}
		//to display date
		if((facility_id!=null)&&(workplace_code!=null)&&(requirement_id!=null)){
			System.err.println("chking if condition whn facid!=null n wp!=null n req!=null");
			String sql_date="select to_char(requirement_date_fm, 'dd/mm/yyyy') frmdate,to_char(requirement_date_to, 'dd/mm/yyyy') todate from rs_workplace_requirement where facility_id=? and workplace_code=? and requirement_id=?";
			//to get the locantion type
			pstmt = conn.prepareStatement( sql_date);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,workplace_code);
			pstmt.setString(3,requirement_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()) {
				record = new String[2];				
				record[0] = resultSet.getString("frmdate");
				record[1] = resultSet.getString("todate");
				Date_Data.add(record) ;
			}
			if(pstmt!= null)
				pstmt.close();
			if(resultSet!= null)
				resultSet.close();
			//to list postion
			for( int i=0 ; i< Date_Data.size() ; i++ ) {
				record = (String[])Date_Data.get(i);
				out.println( "assignDateRange(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;			
			}
		}

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

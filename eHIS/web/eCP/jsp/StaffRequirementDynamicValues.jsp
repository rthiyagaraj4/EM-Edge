<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	18 Jan 2005

--%>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
Connection con = null;
Statement stmt=null;
PreparedStatement pstmt = null;//common-icn-0180
ResultSet rs=null;
String clearAll="";
try
{
	
	String facility_id=request.getParameter("facility_id");
	String workplace_code = request.getParameter("workplace_code");
	String shift_code = request.getParameter("shift_code");
	//String dependency_code = request.getParameter("dependency_code");
	
if(facility_id == null) facility_id="";
if(workplace_code == null) workplace_code="";
if(shift_code == null) shift_code="";


 clearAll = request.getParameter("clearAll");

	if(clearAll == null) clearAll="";
RecordSet	StaffRequirement	=	null;
StaffRequirement	=	(webbeans.eCommon.RecordSet)	session.getAttribute("StaffRequirement");

if(clearAll.equals("clearAll"))
{
StaffRequirement.clearAll();

}
else if(clearAll.equals("notCleared"))
{
	StaffRequirement.clearAll();
	
con = ConnectionManager.getConnection(request);

System.err.println("inside dynamic");

//String sql=" select position_code,'l' db_action from am_position where position_code not in(select position_code from cp_staff_requirement where facility_id='"+facility_id+"' and workplace_code= '"+workplace_code+"' and shift_code= '"+shift_code+"') and role_type='P' and eff_status='E' and position_code in(select position_code from rs_shift_for_position where shift_code= '"+shift_code+"') union all select  a.position_code,'U' db_action from cp_staff_requirement a,am_position b where a.facility_id= '"+facility_id+"' and a.workplace_code= '"+workplace_code+"' and a.shift_code= '"+shift_code+"' and b.position_code=a.position_code and b.role_type='P' order by 1 ";//common-icn-0180
String sql=" select position_code,'l' db_action from am_position where position_code not in(select position_code from cp_staff_requirement where facility_id=? and workplace_code= ? and shift_code= ?) and role_type='P' and eff_status='E' and position_code in(select position_code from rs_shift_for_position where shift_code= ?) union all select  a.position_code,'U' db_action from cp_staff_requirement a,am_position b where a.facility_id=? and a.workplace_code= ? and a.shift_code= ? and b.position_code=a.position_code and b.role_type='P' order by 1 ";//common-icn-0180

 //stmt=con.createStatement();//common-icn-0180
 //common-icn-0180 starts
 pstmt=con.prepareStatement(sql);
 pstmt.setString(1, facility_id);
 pstmt.setString(2, workplace_code);
 pstmt.setString(3, shift_code);
 pstmt.setString(4, shift_code);
 pstmt.setString(5, facility_id);
 pstmt.setString(6, workplace_code);
 pstmt.setString(7, shift_code);
 rs=pstmt.executeQuery();
//common-icn-0180 ends
 //rs=stmt.executeQuery(sql);//common-icn-0180
while(rs.next())
{
StaffRequirement.putObject(rs.getString(1));

}

}
%>

<html>
<head>
</head>
<body CLASS='MESSAGE'>
	<form name=Dynamic_form>
		<input type=hidden name=E value='<%=clearAll%>'>
		<input type=hidden name=R value=''>
		<input type=hidden name=S value=''>
		<input type=hidden name=X value=''>
		<input type=hidden name=Y value=''>
	</form>
</body>
</html>
<%}
catch(Exception e){
	//out.print(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	  if(pstmt!=null) pstmt.close();//common-icn-0180
	ConnectionManager.returnConnection(con,request);

  }
%>


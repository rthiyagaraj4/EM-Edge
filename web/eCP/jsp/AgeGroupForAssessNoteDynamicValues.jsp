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
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Jan 2005

--%>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.

Connection con = null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String clearAll="";
String assess_note_id = "";
String sql = ""; 
try
{
assess_note_id=request.getParameter("assess_note_id") == null ? "":request.getParameter("assess_note_id");
clearAll = request.getParameter("clearAll") == null ? "":request.getParameter("clearAll");
RecordSet	AgeGroupForAssessNote	=	null;
AgeGroupForAssessNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AgeGroupForAssessNote");

if(clearAll.equals("clearAll"))
{
AgeGroupForAssessNote.clearAll();
}
else if(clearAll.equals("notCleared"))
{
AgeGroupForAssessNote.clearAll();

con = ConnectionManager.getConnection(request);
sql  =" select ?, a.age_group_code,a.long_desc, a.min_age, b.durn_desc min_age_durn_unit, a.max_age, c.durn_desc max_age_durn_unit, decode(a.gender,'M','Male','F','Female','U','Unknown') gender,'I' db_action from am_age_group a, am_duration_type b, am_duration_type c where age_group_code not in(select age_group_code from cp_assess_note_age_group where assess_note_id = ?) and eff_status = 'E' and b.durn_type = a.age_unit and c.durn_type = a.age_unit_max union all select ?,a.age_group_code, b.long_desc, b.min_age, c.durn_desc min_age_durn_unit, b.max_age, d.durn_desc max_age_durn_unit, decode(b.gender,'M','Male','F','Female','U','Unknown') gender,'U' db_action from cp_assess_note_age_group a, am_age_group b, am_duration_type c, am_duration_type d  where a.assess_note_id = ? and b.age_group_code = a.age_group_code and c.durn_type = b.age_unit and d.durn_type = b.age_unit_max order by 3 ";

pstmt=con.prepareStatement(sql);

pstmt.setString(1,assess_note_id);
pstmt.setString(2,assess_note_id);
pstmt.setString(3,assess_note_id);
pstmt.setString(4,assess_note_id);
rs=pstmt.executeQuery();
while(rs.next())
{
AgeGroupForAssessNote.putObject(rs.getString("age_group_code"));

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
catch(Exception e){out.print(e);}
  finally
  {
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);

  }
%>


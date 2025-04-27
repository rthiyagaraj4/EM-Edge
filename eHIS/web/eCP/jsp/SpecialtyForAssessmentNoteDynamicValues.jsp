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
*	Created On		:	7 Jan 2005

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
String clearAll = "";
String assess_note_id = "";
String sql = "";
try
{
	
assess_note_id=request.getParameter("assess_note_id") == null ? "":request.getParameter("assess_note_id");
clearAll = request.getParameter("clearAll") == null ? "":request.getParameter("clearAll");

RecordSet	SpecialtyForAssessment	=	null;
SpecialtyForAssessment	=	(webbeans.eCommon.RecordSet)	session.getAttribute("SpecialtyForAssessment");
if(clearAll.equals("clearAll"))
{
SpecialtyForAssessment.clearAll();
}
else if(clearAll.equals("notCleared"))
{
	SpecialtyForAssessment.clearAll();
	con = ConnectionManager.getConnection(request);


sql="select speciality_code,'I' db_action from am_speciality where speciality_code not in (select specialty_code from cp_assess_note_splty where assess_note_id = ?)  union all select a.specialty_code specialty_code,'U' db_action from cp_assess_note_splty a, am_speciality b where a.assess_note_id =? and b.speciality_code = a.specialty_code order by 2";



 pstmt=con.prepareStatement(sql);
 pstmt.setString(1,assess_note_id);
 pstmt.setString(2,assess_note_id);

 rs=pstmt.executeQuery();
while(rs.next())
{
SpecialtyForAssessment.putObject(rs.getString(1));

}

}
%>

<html>
<head>
</head>
<body CLASS='MESSAGE'>
	<form name="Dynamic_form" id="Dynamic_form">
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


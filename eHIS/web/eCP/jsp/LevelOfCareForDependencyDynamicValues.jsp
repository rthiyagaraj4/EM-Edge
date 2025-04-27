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
*	Created On		:	30 Dec 2004

--%>
  <script language="javascript" src="../js/CpMessages.js"></script>  

<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt = null;//common-icn-0180
String clearAll="";
try
{
String level_of_care_code=request.getParameter("level_of_care_code");
if(level_of_care_code == null) level_of_care_code="";

 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	LevelOfCareForDependency	=	null;
LevelOfCareForDependency	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LevelOfCareForDependency");
if(clearAll.equals("clearAll"))
{
LevelOfCareForDependency.clearAll();
}
else if(clearAll.equals("notCleared"))
{
	LevelOfCareForDependency.clearAll();

con = ConnectionManager.getConnection(request);
//String   sql  ="select  dependency_code, 'I' db_action from cp_dependency where dependency_code not in(select dependency_code from cp_loc_for_dependency where level_of_care_code = '"+level_of_care_code+"') and eff_status = 'E' union all select  a.dependency_code,'U' db_action from cp_loc_for_dependency a, cp_dependency b where level_of_care_code = '"+level_of_care_code+"' and b.dependency_code = a.dependency_code order by 2";//common-icn-0180
String   sql  ="select  dependency_code, 'I' db_action from cp_dependency where dependency_code not in(select dependency_code from cp_loc_for_dependency where level_of_care_code = ?) and eff_status = 'E' union all select  a.dependency_code,'U' db_action from cp_loc_for_dependency a, cp_dependency b where level_of_care_code = ? and b.dependency_code = a.dependency_code order by 2";//common-icn-0180

//stmt=con.createStatement();//common-icn-0180
pstmt = con.prepareStatement(sql);//common-icn-0180
pstmt.setString(1, level_of_care_code);//common-icn-0180
pstmt.setString(2, level_of_care_code);//common-icn-0180

 //rs=stmt.executeQuery(sql);//common-icn-0180
 rs=pstmt.executeQuery();//common-icn-0180
while(rs.next())
{
LevelOfCareForDependency.putObject(rs.getString(1));

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
	  if(stmt!=null) stmt.close();
	
	  if(con != null)
			ConnectionManager.returnConnection(con,request);

  }
%>


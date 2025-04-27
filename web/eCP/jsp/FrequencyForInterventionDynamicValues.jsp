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
*	Created By		:	Anuradha.P
*	Created On		:	24 March 2005

--%>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 01/12/2005.
Connection con = null;
PreparedStatement stmt=null;
ResultSet rs=null;
String clearAll="";
try
{
String frequency_code=request.getParameter("frequency_code");
if(frequency_code == null) frequency_code="";

clearAll = request.getParameter("clearAll");
	
if(clearAll == null) clearAll="";

RecordSet	FrequencyForIntervention =	null;
FrequencyForIntervention	=	(webbeans.eCommon.RecordSet)	session.getAttribute("FrequencyForIntervention");

if(clearAll.equals("clearAll"))
{
	FrequencyForIntervention.clearAll();
}
else if(clearAll.equals("notCleared"))
{
FrequencyForIntervention.clearAll();

con = ConnectionManager.getConnection(request);

String sql = "select  intervention_code,'I' db_action from ca_intervention where intervention_code not in( select intervention_code from ca_intervention_freq where freq_code = ?) union all select  a.intervention_code, 'U' db_action from ca_intervention_freq a, ca_intervention b where a.freq_code = ? and b.intervention_code  = a.intervention_code order by 2";

 stmt=con.prepareStatement(sql);
 stmt.setString(1,frequency_code);
 stmt.setString(2,frequency_code);
 rs=stmt.executeQuery();
while(rs.next())
{
FrequencyForIntervention.putObject(rs.getString(1));
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



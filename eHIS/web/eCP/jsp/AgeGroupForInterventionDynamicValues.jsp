<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
PreparedStatement stmt=null;
ResultSet rs=null;
//This file is saved on 18/10/2005.
String clearAll="";
try
{
String age_group_code=request.getParameter("age_group_code");
if(age_group_code == null) age_group_code="";

clearAll = request.getParameter("clearAll");
if(clearAll == null) clearAll="";
RecordSet	 AgeIntervention	=	null;
AgeIntervention	=	(webbeans.eCommon.RecordSet)session.getAttribute("AgeIntervention");
if(clearAll.equals("clearAll"))
{
AgeIntervention.clearAll();
}
else if(clearAll.equals("notCleared"))
{
AgeIntervention.clearAll();

con = ConnectionManager.getConnection(request);
String sql="select  intervention_code, 'I' db_action from ca_intervention where intervention_code not in (select intervention_code from ca_age_grp_for_intervention where age_group_code = ?) and eff_status = 'E' union all select  a.intervention_code, 'U' db_action from ca_age_grp_for_intervention a, ca_intervention b where a.age_group_code = ?  and b.intervention_code  = a.intervention_code order by 2";
stmt=con.prepareStatement(sql);
stmt.setString(1,age_group_code);
stmt.setString(2,age_group_code);
rs=stmt.executeQuery();
while(rs.next())
{
AgeIntervention.putObject(rs.getString(1));
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
	ConnectionManager.returnConnection(con,request);
  }
%>


<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
Connection con = null;
PreparedStatement stmt=null;
ResultSet rs=null;

String clearAll="";

try
{
String position_code=request.getParameter("position_code");
String role_type=request.getParameter("role_type");
String staff_type=request.getParameter("staff_type");

if(position_code == null) position_code="";

if(role_type == null) role_type="";
if(staff_type == null) staff_type="";

clearAll = request.getParameter("clearAll");
	
if(clearAll == null) clearAll="";

RecordSet	PositionForIntervention =	null;
PositionForIntervention	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PositionForIntervention");

if(clearAll.equals("clearAll"))
{
PositionForIntervention.clearAll();
}
else if(clearAll.equals("notCleared"))
{
con = ConnectionManager.getConnection(request);

String sql = "select  intervention_code,'I' db_action from ca_intervention where intervention_code not in( select intervention_code from ca_intervention_for_posn where position_code = ?  and role_type = ?  and staff_type = ?) union all select  a.intervention_code, 'U' db_action from ca_intervention_for_posn a, ca_intervention b where a.position_code = ? and a.role_type = ? and a.staff_type = ? and b.intervention_code  = a.intervention_code order by 2";

stmt=con.prepareStatement(sql);

stmt.setString(1,position_code);
stmt.setString(2,role_type);
stmt.setString(3,staff_type);
stmt.setString(4,position_code);
stmt.setString(5,role_type);
stmt.setString(6,staff_type);

rs=stmt.executeQuery();
while(rs.next())
{
PositionForIntervention.putObject(rs.getString(1));
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
	  
	  if(con != null)
		ConnectionManager.returnConnection(con,request);
  }
%>



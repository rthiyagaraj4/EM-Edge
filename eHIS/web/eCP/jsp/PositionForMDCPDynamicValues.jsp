<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
Statement stmt=null;
PreparedStatement pstmt = null;//common-icn-0180
ResultSet rs=null;
String clearAll="";
String facility_id1="";
String pract_type="";
String   sql  ="";

try
{
	//This file is saved on 18/10/2005.
facility_id1=request.getParameter("facility_id1");
if(facility_id1 == null) facility_id1="";
	pract_type=request.getParameter("pract_type");
if(pract_type == null) pract_type="";

clearAll = request.getParameter("clearAll");

if(clearAll == null) clearAll="";

RecordSet	PositionForMDCP	=	null;
PositionForMDCP	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PositionForMDCP");


if(clearAll.equals("clearAll"))
{
PositionForMDCP.clearAll();
}
else if(clearAll.equals("notCleared"))
{
con = ConnectionManager.getConnection(request);
//sql  ="SELECT  position_code,position_desc,'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = '"+facility_id1+"') AND role_type = 'P' AND ('"+pract_type+"' IS NULL OR staff_type='"+pract_type+"') AND eff_status = 'E' UNION ALL SELECT  a.position_code, b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = '"+facility_id1+"' AND b.position_code = a.position_code AND b.role_type = 'P' AND  ('"+pract_type+"' IS NULL OR staff_type='"+pract_type+"')AND eff_status = 'E' ORDER BY 2";
sql  ="SELECT  position_code,position_desc,'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = ?) AND role_type = 'P' AND (? IS NULL OR staff_type=?) AND eff_status = 'E' UNION ALL SELECT  a.position_code, b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = ? AND b.position_code = a.position_code AND b.role_type = 'P' AND  (? IS NULL OR staff_type=?)AND eff_status = 'E' ORDER BY 2";


//stmt=con.createStatement();//common-icn-0180
//common-icn-0180 starts
pstmt=con.prepareStatement(sql);
pstmt.setString(1, facility_id1);
pstmt.setString(2, pract_type);
pstmt.setString(3, pract_type);
pstmt.setString(4, facility_id1);
pstmt.setString(5, pract_type);
pstmt.setString(6, pract_type);
 //rs=stmt.executeQuery(sql);//common-icn-0180
 rs=pstmt.executeQuery();
//common-icn-0180 ends
while(rs.next())
{
PositionForMDCP.putObject(rs.getString(1));

}

}
%>

<html>
<head>
</head>
<body CLASS='MESSAGE'>
	<form name=Dynamic_form>
		<input type=hidden name='E' id='E' value='<%=clearAll%>'>
		<input type=hidden name='R' id='R' value=''>
		<input type=hidden name='S' id='S' value=''>
		<input type=hidden name='X' id='X' value=''>
		<input type=hidden name='Y' id='Y' value=''>
	</form>
</body>
</html>
<%}
catch(Exception e){out.print(e);}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	  if(pstmt!=null) pstmt.close();//common-icn-0180
	ConnectionManager.returnConnection(con,request);

  }
%>


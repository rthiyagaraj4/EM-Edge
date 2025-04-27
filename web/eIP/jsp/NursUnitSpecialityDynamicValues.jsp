<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String clearAll="";
try
{
String facility_id=(String)session.getValue("facility_id");

String nursing_unit_code=request.getParameter("nursing_unit_code");
if(nursing_unit_code == null) nursing_unit_code = "";

String search_by		= checkForNull(request.getParameter("search_by"));
String search_txt		= checkForNull(request.getParameter("search_txt"));

clearAll = request.getParameter("clearAll");
if(clearAll == null) clearAll="";

String search_criteria	=  "";

if(search_by.equals("ID"))
	search_criteria  = " and upper(speciality_code) like UPPER('"+search_txt+"%') ";
else if(search_by.equals("DESC"))
	search_criteria  = " and upper(short_desc) like UPPER('"+search_txt+"%')  ";


RecordSet	NursUnitSpeciality	=	null;
NursUnitSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("NursUnitSpeciality");

if(clearAll.equals("clearAll"))
{
// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
	
	NursUnitSpeciality.clearAll();
}
else if(clearAll.equals("notCleared"))
{
//This loop will be executed if Select All checkbox is checked...
//The values are removed from RecordSet & all the values from database is added..

	NursUnitSpeciality.clearAll();

	con = ConnectionManager.getConnection(request);
	StringBuffer   sql  =new StringBuffer();
	sql.append(" SELECT A.specialty_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY A, AM_SPECIALITY B ");
	sql.append(" WHERE A.facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
	sql.append(" AND A.specialty_code=b.speciality_code AND B.eff_status='E' ");
	sql.append(search_criteria);
	sql.append(" UNION ");
	sql.append("SELECT speciality_code ");
	sql.append(" FROM AM_SPECIALITY ");
	sql.append(" WHERE speciality_code NOT IN ( SELECT specialty_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY ");
	sql.append(" WHERE facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ) ");
	sql.append(" AND eff_status='E' ");
	sql.append(search_criteria);

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	while(rs.next())
	{
		NursUnitSpeciality.putObject(rs.getString(1));
	}
}
%>
<html>
<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name=Dynamic_form id=Dynamic_form>
		<input type=hidden id='E' name=E value="<%=clearAll%>">
		<input type=hidden id='R' name=R value=''>
		<input type=hidden id='S' name=S value=''>
		<input type=hidden id='X' name=X value=''>
		<input type=hidden id='Y' name=Y value=''>
	</form>
</body>
</html>
<%
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();	
}catch(Exception e){out.print(e);}
finally
{
ConnectionManager.returnConnection(con,request);
}
%>


<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


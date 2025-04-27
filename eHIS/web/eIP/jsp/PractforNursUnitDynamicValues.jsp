<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<% request.setCharacterEncoding("UTF-8");  %>
<%

Connection con = null;
Statement stmt= null;
ResultSet rs= null;

String clearAll="";
try
{
String facility_id=(String)session.getValue("facility_id");
String function_code=request.getParameter("function_code");
if(function_code == null) function_code="";
String Function=request.getParameter("Function");
if(Function == null) Function="";

String search_by    = request.getParameter("search_by") ;
if(search_by == null || search_by.equals("null")) search_by="";

String search_txt   = request.getParameter("search_txt") ;
if(search_txt == null || search_txt.equals("null")) search_txt="";

 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	PractNursRecordSet	=	null;
PractNursRecordSet	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractNursRecordSet");
if(clearAll.equals("clearAll"))
{
	// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
	PractNursRecordSet.clearAll();
}
else if(clearAll.equals("notCleared"))
{
		String search_criteria = "";
		String search_criteria2 = "";
		String search_criteria3 = "";
// This loop will be executed if Select All checkbox is checked...
//The values are removed from RecordSet & all the values from database is added..

		if(search_by != null && !search_by.equals(""))
		{
		  if(search_txt != null && !search_txt.equals(""))
		  {
			if(Function.equals("pract"))
			{
				if(search_by.equals("01"))
				{
				  search_criteria = " and UPPER(NURSING_UNIT_CODE) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(NURSING_UNIT_CODE) like upper('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(b.NURSING_UNIT_CODE) like upper('"+search_txt+"%') ";
				}
				else if(search_by.equals("02"))
				{
				  search_criteria = " and UPPER(NURSING_UNIT_SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
				}
			}
			else if(Function.equals("nurs"))
			{
				if(search_by.equals("01"))
				  search_criteria = " and UPPER(PRACTITIONER_ID) like UPPER('"+search_txt+"%') ";
				else if(search_by.equals("02"))
				  search_criteria = " and UPPER(PRACTITIONER_NAME) like UPPER('"+search_txt+"%') ";
			}
		  }
		}

	PractNursRecordSet.clearAll();

	con = ConnectionManager.getConnection(request);
	StringBuffer sql=new StringBuffer();

	/*if(Function.equals("nurs"))
	{
		sql.append(" select practitioner_id \"code\" from am_pract_for_facility_vw where operating_facility_id='"+facility_id+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') UNION select practitioner_id \"code\" from am_pract_for_facility_vw where operating_facility_id='"+facility_id+"' and 	eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') "); 
	}
	else if(Function.equals("pract"))
	{
		sql.append(" select nursing_unit_code \"code\" from ip_nursing_unit where facility_id='"+facility_id+"' AND eff_status='E' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"') union select a.nursing_unit_code  from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facility_id+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code ");

	}*/

	if(Function.equals("nurs"))
	{

		sql.append("select a.practitioner_id \"code\", a.practitioner_name \"desc\",a.pract_type practype, 'Y',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"' )and a.pract_type = b.pract_type "+search_criteria+" UNION select practitioner_id \"code\", practitioner_name \"desc\",a.pract_type,'N',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and 	a.eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') and a.pract_type = b.pract_type "+search_criteria+" order by 2"); 
	}
	else if(Function.equals("pract"))
	{
		sql.append("select nursing_unit_code \"code\", short_desc \"desc\", 'N' from ip_nursing_unit where facility_id='"+facility_id+"' AND eff_status='E' and locn_type = 'N' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"') "+search_criteria2+" union select a.nursing_unit_code, short_desc,'Y' from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facility_id+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code "+search_criteria3+" order by 2");
	}

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	while(rs.next())
	{
		PractNursRecordSet.putObject(rs.getString(1));
	}
}
%>

<html>
<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name=Dynamic_form id=Dynamic_form>
		<input type=hidden name=E id=E value='<%=clearAll%>'>
		<input type=hidden name=R id=R value=''>
		<input type=hidden name=S id=S value=''>
		<input type=hidden name=X id=X value=''>
		<input type=hidden name=Y id=Y value=''>
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


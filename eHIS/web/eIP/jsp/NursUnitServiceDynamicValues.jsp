<!DOCTYPE html>
<%@ page   contentType="text/html;charset=UTF-8"  language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
RecordSet	NursUnitService	=	null;
RecordSet	NursUnitDeptService	=	null;

try
{
	String facility_id		= (String)session.getValue("facility_id");
	String nursing_unit_code= checkForNull(request.getParameter("nursing_unit_code"));
	String dept_code		= checkForNull(request.getParameter("dept_code"));
	String clearAll			= checkForNull(request.getParameter("clearAll"));
	String search_by		= checkForNull(request.getParameter("search_by"));
	String search_txt		= checkForNull(request.getParameter("search_txt"));
	String search_criteria2	=  "";
	String search_criteria3	=  "";

	NursUnitService	=	(webbeans.eCommon.RecordSet)session.getAttribute("NursUnitService");
	NursUnitDeptService	=	(webbeans.eCommon.RecordSet)session.getAttribute("NursUnitDeptService");

	if(clearAll.equals("clearAll"))
	{
		// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
		NursUnitService.clearAll();
		NursUnitDeptService.clearAll();
	}
	else if(clearAll.equals("notCleared"))
	{
		// This loop will be executed if Select All checkbox is checked...
		//The values are removed from RecordSet & all the values from database is added..
		NursUnitService.clearAll();
		NursUnitDeptService.clearAll();
		if(search_by.equals("")||(search_by == null)) search_by = "00";
		if(search_by != null && !search_by.equals("00"))
		{
			if(search_txt != null && !search_txt.equals(""))
			{
				if(search_by.equals("01"))
				{
					search_criteria2 = " and UPPER(c.SERVICE_CODE) like UPPER('"+search_txt+"%') ";
					search_criteria3 = " and UPPER(b.SERVICE_CODE) like UPPER('"+search_txt+"%') ";
				}
				else if(search_by.equals("02"))
				{	
					search_criteria2 = " and UPPER(c.SHORT_DESC) like UPPER('"+search_txt+"%') ";
					search_criteria3 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
				}
			}
		}

		con = ConnectionManager.getConnection(request);
		StringBuffer   sql  =new StringBuffer();
	/*	sql.append(" SELECT A.service_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE A, AM_FACILITY_SERVICE B, AM_SERVICE C ");
		sql.append(" WHERE A.facility_id= B.OPERATING_FACILITY_ID ");
		sql.append(" AND A.facility_id='"+facility_id+"' ");
		sql.append(" AND A.dept_code = B.dept_code ");
		sql.append(" AND B.dept_code = '"+dept_code+"'");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND A.service_code=b.service_code AND B.eff_status='E' ");
		sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(search_criteria2);
		sql.append(" UNION ");
		sql.append(" SELECT A.service_code ");
		sql.append(" FROM AM_FACILITY_SERVICE A, AM_SERVICE B ");
		sql.append(" WHERE A.service_code = B.service_code and  A.operating_facility_id='"+facility_id+"' ");
		sql.append(" AND A.dept_code = '"+dept_code+"' ");
		sql.append(" AND A.service_code NOT IN ( SELECT service_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE ");
		sql.append(" WHERE facility_id='"+facility_id+"' ");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND dept_code = '"+dept_code+"') ");
		sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(" AND A.eff_status='E' ");
		sql.append(search_criteria3);
		stmt=con.createStatement();*/

		sql.append(" SELECT A.service_code, a.dept_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE A, AM_FACILITY_SERVICE B, AM_SERVICE C ");
		sql.append(" WHERE A.facility_id= B.OPERATING_FACILITY_ID ");
		sql.append(" AND A.dept_code = B.dept_code ");
		sql.append(" AND A.facility_id='"+facility_id+"' ");			
		if(!dept_code.equals(""))
			sql.append(" AND B.dept_code = '"+dept_code+"'");
		sql.append(" AND B.service_code = C.service_code ");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND A.service_code=b.service_code AND B.eff_status='E'");
		sql.append(" AND A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(search_criteria2);
		sql.append(" UNION ");
		sql.append(" SELECT A.service_code, a.dept_code");
		sql.append(" FROM AM_FACILITY_SERVICE A, AM_SERVICE B");
		sql.append(" WHERE A.service_code = B.service_code ");
		if(!dept_code.equals(""))
			sql.append(" AND A.dept_code = '"+dept_code+"'");
		sql.append(" AND A.operating_facility_id='"+facility_id+"' ");
		sql.append(" and A.service_code NOT IN ( SELECT service_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE ");
		sql.append(" WHERE facility_id='"+facility_id+"' ");
		if(!dept_code.equals(""))
			sql.append(" AND dept_code = '"+dept_code+"'");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(" AND A.eff_status='E' ");
		sql.append(search_criteria3);
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql.toString());
		if(rs != null)
		{
			while(rs.next())
			{
				NursUnitService.putObject(checkForNull(rs.getString(1)));
				NursUnitDeptService.putObject(checkForNull(rs.getString(2)));
			}
		}
	}
	%>

	<html>
	<head>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name='Dynamic_form' id='Dynamic_form'>
			<input type=hidden name='ServiceObj' id='ServiceObj' value='<%=clearAll%>'>
		</form>
	</body>
	</html>
	<%
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
	ConnectionManager.returnConnection(con,request);
}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>


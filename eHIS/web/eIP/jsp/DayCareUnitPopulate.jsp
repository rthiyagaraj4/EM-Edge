<!DOCTYPE html>
 <%@ page language="java"  contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*"%>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
Statement stmt = null;
Statement stmt1 = null;
ResultSet rs = null;
ResultSet rs1 = null;
String clearAll="";
try
{

	String search_by		= (request.getParameter("search_by"));
	String search_txt		= (request.getParameter("search_txt"));
	String search_criteria2	=  "";
	String search_criteria3	=  "";

	String facility_id=(String)session.getValue("facility_id");
	String nursing_unit_code=request.getParameter("nursing_unit_code");
	String clinic=request.getParameter("clinic_code");
	String cc=request.getParameter("cc");
	if(nursing_unit_code == null) nursing_unit_code="";
	if(clinic == null) clinic="";
	clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
	RecordSet	DayCareUnitSpeciality	=	null;
	DayCareUnitSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("DayCareUnitSpeciality");
	con = ConnectionManager.getConnection(request);

	if(!clinic.equals(""))
	{
		String sql1 = "SELECT COUNT(*) total FROM IP_NURSING_UNIT_BED WHERE facility_id = '"+facility_id+"' AND nursing_unit_code = '"+nursing_unit_code+"' AND room_no in (SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id = '"+facility_id+"' AND clinic_code = '"+clinic+"' AND resource_class = 'R')";
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery(sql1);
		if(rs1.next())
		{
			String ss = "";
			ss = rs1.getString("total"); 
			 if(!ss.equals("0"))
			{
			 out.println("<script>alert(getMessage('BED_DEFINED_FOR_ROOM','IP'))</script>");
	%>
			<script>
			var chk1 = eval("parent.frames[1].document.forms[0].chk"+<%=cc%>);
			chk1.checked = true

				// code append  for 20414 date:29/mar/10

				eval("parent.frames[1].document.forms[0].removeCode"+<%=cc%>).value="N";
			</script>
	<%		 
			} 
		if(rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
		}
	}  

	if(clearAll.equals("clearAll"))
	{
		// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
		DayCareUnitSpeciality.clearAll();
	}
	else if(clearAll.equals("notCleared"))
	{
		// This loop will be executed if Select All checkbox is checked...
		//The values are removed from RecordSet & all the values from database is added..

	if(search_by.equals("ID")) search_by = "01";
	if(search_by.equals("DESC")) search_by = "02";
	if(search_by.equals("")||(search_by == null)) search_by = "00";

	if(search_by != null && !search_by.equals("00"))
	{
	  if(search_txt != null && !search_txt.equals(""))
	  {
		if(search_by.equals("01"))
		  {
			  search_criteria2 = " and UPPER(b.CLINIC_CODE) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
		  }
		 else if(search_by.equals("02"))
		  {	
			  search_criteria2 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
		  }
	  }
	}

			DayCareUnitSpeciality.clearAll();
			StringBuffer sql = new StringBuffer();
			sql.append("select a.facility_id,a.nursing_unit_code,a.clinic_code,b.clinic_code, b.short_desc from ip_dc_unit_for_nurs_unit a, op_clinic b where a.facility_id  = '"+facility_id+"' and a.nursing_unit_code = '"+nursing_unit_code+"' and  a.facility_id (+) = b.facility_id  and a.clinic_code (+) = b.clinic_code and   b.eff_status = 'E' ");
			sql.append(search_criteria2);
			sql.append(" union select facility_id, null, null ,clinic_code ,  short_desc from op_clinic where facility_id = '"+facility_id+"' and care_locn_type_ind = 'D' and eff_status = 'E'  and clinic_code not in ( select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') ");
			sql.append(search_criteria3);

			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());

			while(rs.next())
			{
				DayCareUnitSpeciality.putObject(rs.getString(4));
			}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
	}
	%>
	<html>
	<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body CLASS='MESSAGE' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
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
	}catch(Exception e){out.print(e);}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>


<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!-- 3-06-08-->
<!--
<%--
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
String appl_patient_class=checkForNull(request.getParameter("appl_patient_class"));

clearAll = request.getParameter("clearAll");
if(clearAll == null) clearAll="";

String search_criteria	=  "";

if(search_by.equals("ID"))
		sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
else if(search_by.equals("DESC"))
		sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");


RecordSet	NursUnitRoom	=	null;
NursUnitRoom	=	(webbeans.eCommon.RecordSet)	session.getAttribute("NursUnitRoom");

if(clearAll.equals("clearAll"))
{
// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
	
	NursUnitRoom.clearAll();
}
else if(clearAll.equals("notCleared"))
{
//This loop will be executed if Select All checkbox is checked...
//The values are removed from RecordSet & all the values from database is added..

	NursUnitRoom.clearAll();

	con = ConnectionManager.getConnection(request);
	StringBuffer   sql  =new StringBuffer();
	if(appl_patient_class.equals("DC"))
			{
				sql.append("select distinct a.practitioner_id room_num, b.short_desc,decode(level_of_care_code, '',(select level_of_care_code from ip_nursing_unit_room where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' and room_no = a.practitioner_id),(select nvl(level_of_care_code,'') from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"')) Level_of_care_code,B.eff_status,( select count(*) from ip_nursing_unit_bed where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' and room_no = a.practitioner_id) no_of_beds   from op_pract_for_Clinic a,am_facility_room b where clinic_code in (select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') and a.resource_class = 'R' and a.practitioner_id  = b.room_num and a.eff_status = 'E' and a.facility_id = '"+facility_id+"' and b.operating_facility_id = '"+facility_id+"' ");
				sql.append(search_criteria);
				}
			else
			{
				sql.append(" Select room_num, short_desc , B.eff_status, 'Y', nvl(no_of_beds,0) no_of_beds,B.Level_of_care_code ");
				sql.append(" from am_facility_room A,");
				sql.append(" IP_NURSING_UNIT_ROOM B ");
				sql.append(" WHERE B.FACILITY_ID='"+facility_id+"' ");
				sql.append(" AND B.NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				sql.append(" AND B.FACILITY_ID=A.OPERATING_FACILITY_ID ");
				sql.append(" AND B.ROOM_NO = A.ROOM_NUM and A.eff_status='E'  ");
				sql.append(search_criteria);
				sql.append(" union ");

				sql.append(" Select room_num, short_desc , 'D', 'N',0 ,Level_of_care_code" );
				sql.append(" from am_facility_room ");
				sql.append(" where operating_facility_id='"+facility_id+"' ");
				sql.append(" and eff_status='E' ");
				sql.append(" and resident_stay_yn='Y' ");
				sql.append(" and room_type in (Select locn_type from am_care_locn_type where care_locn_type_ind in ('R')) ");
				sql.append(" and nursing_unit_code is null ");
				sql.append(" and room_num not  in (Select room_no from ip_nursing_unit_room ");
				sql.append(" where facility_id='"+facility_id+"')  ");
				sql.append(search_criteria);
			}

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	while(rs.next())
	{
		NursUnitRoom.putObject(rs.getString(1));
	}
}
--%>-->
<!--3-06-08-->
<html>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name=Dynamic_form>
		<!--<input type=hidden name=S value='<%--=clearAll--%>'>-->
		<input type=hidden name=S value=''>
		<input type=hidden name=E value=''>
		<input type=hidden name=R value=''>
	</form>
</body>
<script>
</script>
</html>
<!--
<%--
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();	
}catch(Exception e){out.print(e);}
finally
{
ConnectionManager.returnConnection(con,request);
}
--%>
<%--!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
--%>
-->
	


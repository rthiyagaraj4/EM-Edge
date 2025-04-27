<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>
<%
request.setCharacterEncoding("UTF-8");

String otherstaffid=request.getParameter("other_staff_id");
if(otherstaffid ==null) otherstaffid="";
String otherstafftype=request.getParameter("other_staff_type");
if(otherstafftype ==null) otherstafftype="";
String otherstaffname=request.getParameter("other_staff_name");
if(otherstaffname ==null) otherstaffname="";
String shortname=request.getParameter("short_name");
if(shortname ==null) shortname="";
String effstatus=request.getParameter("eff_status");
if(effstatus ==null) effstatus="";
String Position = request.getParameter("Position");
if(Position ==null) Position="";
String empl_status = request.getParameter("empl_status");
if(empl_status ==null) empl_status="";
String all_facilities_yn = request.getParameter("all_facilities_yn");
if(all_facilities_yn ==null) all_facilities_yn="";
String reporting_facility_id = request.getParameter("reporting_facility_id");
if(reporting_facility_id ==null) reporting_facility_id="";

%>

<html>
<head>
<script language='javascript' src='../../eAM/js/OtherStaff.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name='OtherStaff_main_one' id='OtherStaff_main_one' src="../../eAM/jsp/OtherStaffAddModify.jsp?  &other_staff_id=<%=otherstaffid%>&other_staff_type=<%=otherstafftype%>&other_staff_name=<%=otherstaffname%>&short_name=<%=shortname%>&eff_status=<%=effstatus%>&Position=<%=Position%>&empl_status=<%=empl_status%>&all_facilities_yn=<%=all_facilities_yn%>&reporting_facility_id=<%=reporting_facility_id%>&fcall=nocall" frameborder=0 scrolling='no' noresize style='height:30vh;width:98vw'></iframe>
<iframe name='OtherStaff_sub' id='OtherStaff_sub' src="../../eAM/jsp/OtherStaffAddModify.jsp?  &other_staff_id=<%=otherstaffid%>&other_staff_type=<%=otherstafftype%>&other_staff_name=<%=otherstaffname%>&short_name=<%=shortname%>&eff_status=<%=effstatus%>&Position=<%=Position%>&empl_status=<%=empl_status%>&all_facilities_yn=<%=all_facilities_yn%>&reporting_facility_id=<%=reporting_facility_id%>&fcall=call" frameborder=0 scrolling='no' noresize style='height:50vh;width:98vw'></iframe>
<%
%>

</html>



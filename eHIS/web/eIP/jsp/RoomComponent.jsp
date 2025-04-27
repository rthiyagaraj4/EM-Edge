<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	 
	Connection con =null ;
	Statement stmt=null;
	ResultSet rs =null;
	String facilityID=(String)session.getValue("facility_id");
%>
	<select name='room' id='room'><option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
<%	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
//		String sql2 = " Select room_num,SHORT_DESC from am_facility_room where room_type IN (Select locn_type from am_care_locn_type where care_locn_type_ind='N') and resident_stay_yn ='Y' and operating_facility_id='"+facilityID+"' and eff_status='E' order by room_num ";

		String sql2 = " Select room_num, SHORT_DESC from AM_FACILITY_ROOM_LANG_VW where language_id = '"+locale+"' and room_type IN (Select locn_type from AM_CARE_LOCN_TYPE_LANG_VW where language_id = '"+locale+"' and care_locn_type_ind='N' ) and resident_stay_yn ='Y' and operating_facility_id='"+facilityID+"' and eff_status='E' order by room_num ";

		rs = stmt.executeQuery(sql2);

		if( rs != null )
		{
			while( rs.next() )
			{
				String room_num = rs.getString( "room_num" ) ;
				String short_desc = rs.getString( "SHORT_DESC" ) ;
				if(short_desc==null) short_desc="";
				%>
					<OPTION VALUE='<%= room_num %>' ><%= short_desc %>
				<%
			}
		}
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e)
		{
			out.println(e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request); 
		}
%>
              	</select>
            


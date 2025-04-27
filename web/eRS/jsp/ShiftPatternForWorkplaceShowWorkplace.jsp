<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	18-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../js/ShiftPatternForWorkplace.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	String mode	   = request.getParameter("mode")==null?"": request.getParameter("mode");
	String facility_id = (String)session.getAttribute("facility_id");
	String locn_type=request.getParameter( "locn_type" )==null?"": request.getParameter("locn_type");
	String shift_pattern_id=request.getParameter( "shift_pattern_id" )==null?"": request.getParameter("shift_pattern_id");
	if(locn_type.equals("")||(locn_type==null))
		locn_type="";
	if(shift_pattern_id.equals("")||(shift_pattern_id==null))
		shift_pattern_id="";
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Workplace_Data		= new ArrayList();
	String[] record				= null;

	//String sql_workplace="select   a.facility_id, b.locn_type, c.short_desc, a.workplace_code, b.workplace_desc, to_char (b.working_day_start_time, 'HH24:MI') start_time, to_char (b.working_day_end_time, 'HH24:MI') end_time, 'U' db_action, a.eff_status enabled from rs_shift_pattern_for_workplace a, rs_workplace b, am_care_locn_type c where a.facility_id = ? and a.shift_pattern_id = ? and b.facility_id = a.facility_id and b.workplace_code = a.workplace_code and c.locn_type(+) = b.locn_type	union all select   a.facility_id, a.locn_type, b.short_desc, a.workplace_code, a.workplace_desc, to_char (a.working_day_start_time, 'HH24:MI') start_time, to_char (a.working_day_end_time, 'HH24:MI') end_time, 'I' db_action, 'E' enabled from rs_workplace a, am_care_locn_type b where a.facility_id = ? and ((a.locn_type IS NULL) OR a.locn_type = NVL((SELECT LOCN_TYPE FROM RS_SHIFT_PATTERN WHERE SHIFT_PATTERN_ID = ?),A.locn_type)) and a.eff_status = 'E'	 and (a.facility_id, a.workplace_code) not in ( select facility_id, workplace_code from rs_shift_pattern_for_workplace where facility_id = ? and shift_pattern_id = ?) and b.locn_type(+) = a.locn_type order by 2, 3, 5";
	String sql_workplace="select   a.facility_id, b.locn_type, c.short_desc, a.workplace_code, b.workplace_desc, to_char (b.working_day_start_time, 'HH24:MI') start_time, to_char (b.working_day_end_time, 'HH24:MI') end_time, 'U' db_action, a.eff_status enabled from rs_shift_pattern_for_workplace a, rs_workplace_lang_vw b, am_care_locn_type_lang_vw c where a.facility_id = ? and a.shift_pattern_id = ? and b.facility_id = a.facility_id and b.workplace_code = a.workplace_code and b.language_id = ? and c.locn_type(+) = b.locn_type and c.language_id(+) = b.language_id union all select   a.facility_id, a.locn_type, b.short_desc, a.workplace_code, a.workplace_desc, to_char (a.working_day_start_time, 'HH24:MI') start_time, to_char (a.working_day_end_time, 'HH24:MI') end_time, 'I' db_action, 'E' enabled from rs_workplace_lang_vw a, am_care_locn_type_lang_vw b where a.facility_id = ? and ((a.locn_type IS NULL) OR a.locn_type = NVL((SELECT LOCN_TYPE FROM RS_SHIFT_PATTERN WHERE SHIFT_PATTERN_ID = ?),A.locn_type)) and a.eff_status = 'E'  and (a.facility_id, a.workplace_code) not in ( select facility_id, workplace_code from rs_shift_pattern_for_workplace where facility_id = ? and shift_pattern_id = ?) and a.language_id = ? and b.locn_type(+) = a.locn_type and b.language_id(+) = a.language_id order by 2, 3, 5";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the Shift Pattern Details
		pstmt = conn.prepareStatement( sql_workplace);

		pstmt.setString(1,facility_id);
		pstmt.setString(2,shift_pattern_id);
		pstmt.setString(3,locale);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,shift_pattern_id);
		pstmt.setString(6,facility_id);
		pstmt.setString(7,shift_pattern_id);
		pstmt.setString(8,locale);

		resultSet = pstmt.executeQuery();

		while (resultSet != null && resultSet.next()) 
		{
			record = new String[9];				
			record[0] = resultSet.getString("facility_id");
			record[1] = resultSet.getString("locn_type")==null?"":resultSet.getString("locn_type");
			record[2] = resultSet.getString("short_desc")==null?"":resultSet.getString("short_desc");
			record[3] = resultSet.getString("workplace_code")==null?"":resultSet.getString("workplace_code");
			record[4] = resultSet.getString("workplace_desc")==null?"":resultSet.getString("workplace_desc");
			record[5] = resultSet.getString("start_time")==null?"":resultSet.getString("start_time");
			record[6] = resultSet.getString("end_time")==null?"":resultSet.getString("end_time");
			record[7] = resultSet.getString("db_action")==null?"":resultSet.getString("db_action");
			record[8] = resultSet.getString("enabled")==null?"":resultSet.getString("enabled");
			Workplace_Data.add(record) ;
		}
		int totalRecords=Workplace_Data.size();
		if( totalRecords== 0){
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA')); location.href='../../eCommon/html/blank.html' </script>");
			%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
			<%
		}
		else
		{
%>
			<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
			<form name='form_listWorkplace' id='form_listWorkplace' action='../../servlet/eRS.ShiftPatternForWorkplaceServlet' method='POST' target='messageFrame'>
			<table border='1' cellpadding='0' cellspacing='0' align='center' width="90%">
					<tr>
						<th rowspan='2' align='left' width='15%'>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/>&nbsp;</th>
						<th rowspan='2' align='left' width='40%'>&nbsp;<fmt:message key="eRS.Workplace.label" bundle="${rs_labels}"/>&nbsp;</th>
						<th width='30%' colspan='2' >&nbsp;<fmt:message key="eRS.Operating.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.duration.label" bundle="${common_labels}"/>&nbsp;</th>
					<th rowspan='2' align='center' width='15%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/><input type='checkbox' name='selectall' id='selectall' value="" onclick='return click_selectall(form_name);'></th>
					</tr>		
					<tr>
					<th width='15%'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> &nbsp;</th>
					<th width='15%'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</th>
					</tr>
<%
					String locn_type1="";
					for(int i=0; i<Workplace_Data.size();i++){
						record=(String[])Workplace_Data.get(i);
						if(record !=null){
							if(!(locn_type.equalsIgnoreCase(record[2]))){
							locn_type=(record[2]==null?"":record[2]);
								if(locn_type.equals("") )
									locn_type1="General";
								else 
									locn_type1=locn_type;
							}else
								locn_type1="";

								String select="";
								String enable=record[8]==null?"":record[8];

								if((record[7].equals("U"))&&(enable.equals("E")))
									select="checked";
%>
								</tr><tr>
								<input type='hidden' name='locn_type<%=i%>' id='locn_type<%=i%>' value='<%=record[1]%>'>
								<input type='hidden' name='locn_desc<%=i%>' id='locn_desc<%=i%>' value='<%=record[2]%>'>
								<input type='hidden' name='workplace_code<%=i%>' id='workplace_code<%=i%>' value='<%=record[3]%>'>
								<input type='hidden' name='workplace_desc<%=i%>' id='workplace_desc<%=i%>' value='<%=record[4]%>'>
								<input type='hidden' name='start_time<%=i%>' id='start_time<%=i%>' value='<%=record[5]%>'>
								<input type='hidden' name='end_time<%=i%>' id='end_time<%=i%>' value='<%=record[6]%>'>
								<input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=record[7]%>'>
								<td>&nbsp;<%=locn_type1%></td>
								<td>&nbsp;<%=record[4]%></td>
								<td>&nbsp;<%=record[5]%></td>
								<td>&nbsp;<%=record[6]%></td>
								<td>&nbsp;<input type='checkbox' <%=select%> name='select_yn<%=i%>' ></td>
 <%
							}
						}
%>
						</tr></table>
						<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
						<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
						<input type='hidden' name='form_name' id='form_name'  value='form_listWorkplace'>
						<input type='hidden' name='shift_pattern_id' id='shift_pattern_id' value='<%=shift_pattern_id%>'>
						<input type='hidden' name='totalRecords' id='totalRecords' value='<%=Workplace_Data.size()%>'>
						
					</form>
				</body>
<%
			}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(resultSet != null)
			resultSet.close();
		pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>


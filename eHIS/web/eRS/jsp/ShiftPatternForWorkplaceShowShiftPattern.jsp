<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	16-11-2004
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
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
	String mode	  = request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id = (String)session.getAttribute("facility_id");
	String locn_type=request.getParameter( "locn_type" )==null?"":request.getParameter("locn_type");
	String workplace_code=request.getParameter( "workplace_code" )== null?"":request.getParameter("workplace_code");

	int week_count = Integer.parseInt((String)request.getParameter("week_count")==null?"0":(String)request.getParameter("week_count"));
	int totalDays=week_count*7, row_count=0;
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList ShiftPattern_Data		= new ArrayList();
	ArrayList Week_Days		=new ArrayList();
	String[] record				= null;
	String Shift_pattern_id="", classval="";

	String sql_week_days="Select day_no, initcap (substr( day_of_week,1,1) ) day_of_week from sm_day_of_week order by day_no";
	//String sql_shift_pattern="select   a.locn_type, d.short_desc locn_desc, c.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'U' db_action, c.eff_status enabled from rs_shift_pattern_for_workplace c, rs_shift_pattern a, rs_shift_pattern_dtl b, am_care_locn_type d where c.facility_id =? and c.workplace_code = ? and a.facility_id = c.facility_id and a.shift_pattern_id = c.shift_pattern_id and b.facility_id = a.facility_id and b.shift_pattern_id = a.shift_pattern_id and d.locn_type = a.locn_type and b.week_no <= ? union all select   a.locn_type, c.short_desc locn_desc, a.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'I' db_action, 'E' enabled from rs_shift_pattern a,         rs_shift_pattern_dtl b, am_care_locn_type c where a.facility_id = ? and ((a.locn_type is null) or (a.locn_type = nvl((select locn_type from rs_workplace where workplace_code = ?),a.locn_type))) and a.eff_status = 'E' and b.facility_id = a.facility_id and b.week_no <= ? and b.shift_pattern_id = a.shift_pattern_id and (a.facility_id, a.shift_pattern_id) not in ( select facility_id, shift_pattern_id from rs_shift_pattern_for_workplace where facility_id = ? and workplace_code = ?) and c.locn_type(+) = a.locn_type order by locn_type, short_desc, week_no, day_no";
	String sql_shift_pattern="select   a.locn_type, d.short_desc locn_desc, c.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'U' db_action, c.eff_status enabled from rs_shift_pattern_for_workplace c, rs_shift_pattern_lang_vw a, rs_shift_pattern_dtl b, am_care_locn_type_lang_vw d where c.facility_id =? and c.workplace_code = ? and a.facility_id = c.facility_id and a.shift_pattern_id = c.shift_pattern_id and b.facility_id = a.facility_id and b.shift_pattern_id = a.shift_pattern_id and d.locn_type = a.locn_type and b.week_no <= ? and a.language_id = ? and d.language_id = a.language_id union all select   a.locn_type, c.short_desc locn_desc, a.shift_pattern_id, a.short_desc, b.week_no, b.day_no, b.shift_code, b.shift_mnemonic, 'I' db_action, 'E' enabled from rs_shift_pattern_lang_vw a,         rs_shift_pattern_dtl b, am_care_locn_type_lang_vw c where a.facility_id = ? and ((a.locn_type is null) or (a.locn_type = nvl((select locn_type from rs_workplace where workplace_code = ?),a.locn_type))) and a.eff_status = 'E' and b.facility_id = a.facility_id and b.week_no <= ? and b.shift_pattern_id = a.shift_pattern_id and (a.facility_id, a.shift_pattern_id) not in ( select facility_id, shift_pattern_id from rs_shift_pattern_for_workplace where facility_id = ? and workplace_code = ?) and a.language_id = ? and c.locn_type(+) = a.locn_type and c.language_id(+) = a.language_id  order by locn_type, short_desc, week_no, day_no";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the Shift Pattern Details
		pstmt = conn.prepareStatement( sql_shift_pattern);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,String.valueOf(week_count));
		pstmt.setString(4,locale);
		pstmt.setString(5,facility_id);
		pstmt.setString(6,workplace_code);
		pstmt.setString(7,String.valueOf(week_count));
		pstmt.setString(8,facility_id);
		pstmt.setString(9,workplace_code);
		pstmt.setString(10,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[10];				
			record[0] = resultSet.getString("locn_type")==null?"":resultSet.getString("locn_type");
			record[1] = resultSet.getString("locn_desc")==null?"":resultSet.getString("locn_desc");
			record[2] = resultSet.getString("shift_pattern_id")==null?"":resultSet.getString("shift_pattern_id");
			record[3] = resultSet.getString("short_desc")==null?"":resultSet.getString("short_desc");
			record[4] = resultSet.getString("week_no")==null?"":resultSet.getString("week_no");
			record[5] = resultSet.getString("day_no")==null?"":resultSet.getString("day_no");
			record[6] = resultSet.getString("shift_code")==null?"":resultSet.getString("shift_code");
			record[7] = resultSet.getString("shift_mnemonic")==null?"":resultSet.getString("shift_mnemonic");
			record[8] = resultSet.getString("db_action")==null?"":resultSet.getString("db_action");
			record[9] = resultSet.getString("enabled")==null?"":resultSet.getString("enabled");
			ShiftPattern_Data.add(record) ;
		}

		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		//to get the week days legend
		pstmt = conn.prepareStatement( sql_week_days);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("day_no");
			record[1] = resultSet.getString("day_of_week");
			Week_Days.add(record);
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		int totalRecords=ShiftPattern_Data.size();
		if( totalRecords== 0){
			//out.println("<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common")); location.href='../../eCommon/html/blank.html' </script>");
			%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
			<%
		}
		else{
%>
			<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
			<form name='form_listShiftPattern' id='form_listShiftPattern' action='../../servlet/eRS.ShiftPatternForWorkplaceServlet' method='POST' target='messageFrame'>
			<table border='1' cellpadding='0' cellspacing='0' align='center' width="90%">
				
				<tr>
					<th align='center' width='50'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
					<input type='checkbox' name=selectall value="" onclick='return click_selectall(form_name);'></th>
					<th  align='left' width='40%'>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
					<th align='left' width='65'>&nbsp;<fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eRS.Pattern.label" bundle="${rs_labels}"/>&nbsp;</th>
<%
					for(int i=0;i<week_count;i++){
						for(int j=0; j<Week_Days.size();j++){
							record=(String[])Week_Days.get(j);
%>
							<th>&nbsp;<%=record[1]%>&nbsp;</th>
<%
						}
					}
					int j=0,count=0,count1=0;
					String locn_type1="";
					for(int i=0; i<ShiftPattern_Data.size();i++){
						record=(String[])ShiftPattern_Data.get(i);
						if(!(Shift_pattern_id.equals(record[2]))){
							if(!(locn_type1.equalsIgnoreCase(record[1]))){
								locn_type=record[1];
								if(locn_type.equals("") )
									locn_type1="General";
								else 
									locn_type1=locn_type;
							}
							else
								locn_type1="";

							Shift_pattern_id=record[2];
							String select="";
							String enable=record[9]==null?"":record[9];
							if((record[8].equals("U"))&&(enable.equals("E")))
								select="checked";

							if((count1>0)&&(count1<totalDays)){
								while(count1<totalDays){
%>
									<td class='<%=classval%>'>-</td>
<%	
									count1++;
								}
							}	
							count1=0;
							count=0;
							if(row_count %2 == 0)
								classval="QRYEVEN";
							else
								classval="QRYODD";
							row_count++;
%>
							</tr><tr ><td align='center' class='<%=classval%>'>
								<input type='checkbox' <%=select%> name='select_yn<%=j%>' ></td>
								<td class='<%=classval%>'>&nbsp;<%=locn_type1%></td>
								<input type='hidden' name='shift_pattern_id<%=j%>' id='shift_pattern_id<%=j%>' value='<%=Shift_pattern_id%>'>
								<input type='hidden' name='db_action<%=j++%>' id='db_action<%=j++%>' value='<%=record[8]%>'>
								<td class='<%=classval%>'><%=record[3]%></td>
<%
						}
						count=((Integer.parseInt(record[4])-1)*7+(Integer.parseInt(record[5])-1))-count1;
						if(count <0)
							count=count*(-1);
						for(int k=0; k<count;k++){
%>
							<td align='center' class='<%=classval%>'>-</td>
<%
						}
%>
						<td align='center' class='<%=classval%>'><%=record[7]%></td> 
<%
						count1=((Integer.parseInt(record[4])-1)*7+(Integer.parseInt(record[5])));
						locn_type1=record[1];
					}
					if(count1>0){
						while(count1<totalDays){
%>
							<td class='<%=classval%>'>-</td>
<%
							count1++;
						}
						count1=0;
					}
%>
					</tr></table>
					<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
					<input type='hidden' name='form_name' id='form_name'  value='form_listShiftPattern'>
					<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
					<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
					<input type='hidden' name='totalRecords' id='totalRecords' value='<%=j%>'>
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
	}%>
</html>


<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ShiftPatternForWorkplace.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	16-11-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../js/ShiftPatternForWorkplace.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	String facility_id = (String)session.getAttribute("facility_id");
	String shift_pattern_id=request.getParameter("shift_pattern_id")==null?"":request.getParameter("shift_pattern_id");
	int week_count=Integer.parseInt(request.getParameter("week_count"));

	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;

	String[] record				= null;
	ArrayList Shift_Details=new ArrayList();
	ArrayList Week_Days		=new ArrayList();

	String sql_shift_pattern_dtl="select week_no, day_no, shift_mnemonic from rs_shift_pattern_dtl where facility_id=? and shift_pattern_id=? ";
	String sql_week_days="Select day_no, initcap (substr( day_of_week,1,3) ) day_of_week from sm_day_of_week order by day_no";
	conn = ConnectionManager.getConnection(request);
	try {
		//to get work_cycle_basis
		pstmt = conn.prepareStatement( sql_shift_pattern_dtl);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,shift_pattern_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[3];				
			record[0] = resultSet.getString("week_no");
			record[1] = resultSet.getString("day_no");
			record[2] = resultSet.getString("shift_mnemonic");
			Shift_Details.add(record) ;
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

%>
		<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name='formShiftPatternDetails' id='formShiftPatternDetails' target='messageFrame' >
		<table width='98%' cellspacing='0' cellpadding='0' border='0'>
<%
		int l=0;
		String[] record1=null;
		if(!Shift_Details.isEmpty()){
			record1=(String[])Shift_Details.get(l++); 
%>
			<tr><td class='label' align='left' ><b><fmt:message key="eRS.ShiftPatternDetails.label" bundle="${rs_labels}"/> </b></td></tr>
		</table>

		<table width='98%' cellspacing='0' cellpadding='0' border='0'>
			<tr><td colspan=9>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
			<tr><td width='7%'>&nbsp;</td>

<%
			for(int i=0; i<Week_Days.size();i++){
				record=(String[])Week_Days.get(i);
%>
				<td class='label' width='7%' align='left'><b><%=record[1]%></b></td><%}%>			
				<td width='24%'></td></tr>	
					
<%
				for(int i=0; i<week_count;i++){
%>
					<tr><td class='label' width='7%'><b>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Week.label" bundle="${common_labels}"/><%=i+1%></b></td>

<%
					for(int j=0; j<Week_Days.size();j++){
						record=(String[])Week_Days.get(j);

						if((Integer.parseInt(record1[0])==(i+1))&&(Integer.parseInt(record1[1])==(j+1))){
%>
							<td width='7%' align='left'>&nbsp;&nbsp;<%=record1[2]%></td>

<%
							if(l<Shift_Details.size())
								record1=(String[])Shift_Details.get(l++);
						}
						else{
%>
							<td width='7%'></td>
<%
						}
					}
%>
<%
					if(i==(week_count-1)){
%>
						<td><input type='button' class='button' name='listworkplace' id='listworkplace' value='<fmt:message key="eRS.ShowWorkplaces.label"bundle="${rs_labels}"/>'onclick='listWorkplace();'>
<%
					}
					else{
%>
						<td width='24%'>&nbsp;</td>
<%
					}
				}
%>
				</tr>
				<tr><td colspan=10>&nbsp;</td></tr>
<%
			}
			else{
				//out.println("<script>alert(getRsMessage('NO_SHIFT_PATTERN_DTL'));</script>");
				%>
			<script>alert(getMessage("NO_SHIFT_PATTERN_DTL","RS"));</script>
			<%
			}
%>
			</table>
		</form>
		</body>
<%
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>


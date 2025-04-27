<!DOCTYPE html>
<%/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterScheduleWeekByWorkplaceResultHdr.jsp
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	04-12-2004
*/
%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eRS.*,com.ehis.eslp.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!-- <link rel='stylesheet' type='text/css' href='../../eRS/html/RSStylesheet.css'></link>
 --><script language="JavaScript" src="../../eRS/js/MasterSchedule.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<% 
	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
	String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String user_id =request.getParameter("user_id")==null?"":request.getParameter("user_id");
	String function_id = request.getParameter( "function_id")==null?"":request.getParameter("function_id");
	String workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String requirement_id=request.getParameter("requirement_id")==null?"":request.getParameter("requirement_id");
	int week_no =Integer.parseInt(request.getParameter("week_no")==null?"0":request.getParameter("week_no"));
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Week_Days		=new ArrayList();
	String[] record				= null;
	String sql_week_days="Select day_no, initcap (substr( day_of_week,1,3) ) day_of_week from sm_day_of_week order by day_no";

	 conn = ConnectionManager.getConnection(request);
	try {
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
			pstmt.close() ;
		if(resultSet != null)
			resultSet.close() ;
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt != null)
			pstmt.close() ;
		if(resultSet != null)
			resultSet.close() ;
		ConnectionManager.returnConnection(conn,request);

	}
%>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name=formByWorkplaceResultHdr>
		<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
			<tr>
				<td width='15%' class='OPTIMAL'><fmt:message key="eRS.Optimal.label" bundle="${rs_labels}"/></td>
				<td width='15%' class='BELOWOPTIMAL'><fmt:message key="eRS.BelowOptimal.label" bundle="${rs_labels}"/></td>
				<td width='15%' class='ABOVEOPTIMAL'><fmt:message key="eRS.AboveOptimal.label" bundle="${rs_labels}"/></td>
				<td colspan='4'>&nbsp;</td>
				<td width='15%' class='UNPRODUCTIVE'><fmt:message key="eRS.Unproductive.label" bundle="${rs_labels}"/></td>
				<td width='15%' class='ONCALL'><fmt:message key="eRS.Oncall.label" bundle="${rs_labels}"/></td>
				<td width='5%'><input type='button' class='button' name='cancel' id='cancel' value='<fmt:message key="Common.Back.label"  bundle="${common_labels}"/>'onclick='changeweek();'></td>
				<td width='2%'>&nbsp;</td>
			</tr>
			<tr><td colspan='10'>
	 		<table border='1' cellpadding='0' cellspacing='0' align='left' width="100%">			
 			<tr><!-- <td width='5%'>&nbsp;</td> -->
				<td rowspan='2' width='9%' class='master_label' align='left'><fmt:message key="eRS.ShiftPattern.label" bundle="${rs_labels}"/></td>
				<td rowspan='2' width='31%'>&nbsp;</td>
				<td colspan='7' class='master_label' align='center'><b><------------------------------Week <%=week_no%> ------------------------------></b></td>				
			</tr>
			<tr>
<% 
			for(int i=0; i<Week_Days.size();i++){
					String classval="";
					record=(String[])Week_Days.get(i);
					classval="WORKDAY";
%>
					<td class='<%=classval%>' width='7%' align='center'><b>&nbsp;<%=record[1]%></b></td>
<%
			}
%>	
			</tr>		
		</table></td>
		<td width='2%'>&nbsp;</td>
		</tr></table>								
 		<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
		<input type='hidden' name='requirement_id' id='requirement_id' value='<%=requirement_id%>'>
		<input type='hidden' name='week_no' id='week_no' value='<%=week_no%>'>
	</form>
</body>
</html>


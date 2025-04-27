<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Subbulakshmky. k
*	Created On		:	29 Nov 2004
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<html>
<head>
<!-- <script language="javascript" src="../js/RSMessages.js"></script>
<script language='javascript' src='../../eCommon/js/messages.js'></script> -->
<script language="javascript" src="../js/RecordAttendance.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	
	String facility_id = (String)session.getAttribute("facility_id");
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String 	attendane_req_yn		= "y";
	String	duration_to_mark="";

	String sql_param="select ATTENDANCE_FEATURE_REQD_YN, MAX_DURN_TO_MARK_ATTENDANCE, durn_for_allocation_from_sos 	from rs_parameter 	where facility_id in(select facility_id from rs_parameter where facility_id = ?  union select '!!' from dual where not exists (select facility_id from rs_parameter where facility_id = ?))";
	conn = ConnectionManager.getConnection(request);
	try {
		//to get the shift data
		pstmt = conn.prepareStatement( sql_param);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			attendane_req_yn = resultSet.getString("ATTENDANCE_FEATURE_REQD_YN");
			duration_to_mark=resultSet.getString("durn_for_allocation_from_sos");
		}
		if(pstmt != null) pstmt.close() ;
		if(resultSet != null) resultSet.close() ;
		if(attendane_req_yn.equalsIgnoreCase("Y")){
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:8vh;width:100vw'></iframe><iframe name="frameQueryCriteria" id="frameQueryCriteria" src='../../eRS/jsp/RecordAttendanceQueryCriteria.jsp?duration_to_mark=<%=duration_to_mark%>' frameborder=0 scrolling="no" noresize style='height:13vh;width:100vw'></iframe>
		<iframe name="frameQueryResult" id="frameQueryResult" src='../../eCommon/html/blank.html'frameborder=0 scrolling="auto" noresize style='height:70vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder=0 scrolling="auto" noresize style="height:9vh;width:100vw"></iframe>
		
<%	}else
	%>
		<script>alert(getMessage("NO_AXS_FOR_MARK_ATTENDANCE","RS")) </script>
		<%
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt != null) pstmt.close() ;
		if(resultSet != null) resultSet.close() ;
		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>


<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkSchedule.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	17-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="javascript" src="../js/ManageWorkSchedule.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;	

	String p_mode	   = request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
	String facility_id = (String)session.getAttribute("facility_id")==null?"": (String)session.getAttribute("facility_id");
	String user_id = (String)session.getValue("login_user")==null?"": (String)session.getAttribute("login_user");
	String sql_access="SELECT COUNT(*) COUNT FROM	rs_access_rights WHERE appl_user_id = (?) AND facility_id = (?) AND ALLOCATE_YN = 'Y'";
	int access_count=0;
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	conn = ConnectionManager.getConnection(request);
	try {
		//to get the count of access rights
		pstmt = conn.prepareStatement( sql_access);
		pstmt.setString(1,user_id);
		pstmt.setString(2,facility_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			access_count= Integer.parseInt(resultSet.getString("COUNT"));
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		if(access_count>0){
			if(p_mode.equals("CA")){
%>
			<title><fmt:message key="eRS.ManageWorkSchedule.label" bundle="${rs_labels}"/></title>
			</head>
			<frameset rows='0,*,50'>
<%
			}
			else{
%>
			</head>
			<frameset rows='41,*,50'>
<%
			}
%>
		<frame name="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize >
		<frame name='frameManageWorkScheduleCriteria' src='../../eRS/jsp/ManageWorkScheduleCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize>
		<frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder=0 scrolling="auto" noresize>
		</frameset>
<%
		}else
		out.println("<script>alert(getMessage('NO_AXS_FOR_MAN_SCH','RS')); parent.parent.document.location.href='../../eCommon/jsp/home.jsp' </script>");
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally
	{
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
</html>

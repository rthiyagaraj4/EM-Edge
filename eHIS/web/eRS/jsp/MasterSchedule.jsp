<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSchedule.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
*/
%>
<%@page import="java.util.*,eRS.*,java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<html>
<head>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../js/MasterSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//out.println("url----->" +url);
	String params = request.getQueryString() ;
	//out.println("params---->" +params);
	String source = url + params ;	
	//out.println("source---->" +source);
	String facility_id = (String)session.getAttribute("facility_id");
	String user_id = (String)session.getValue("login_user");
	String sql_access="SELECT COUNT(*) COUNT FROM rs_access_rights WHERE appl_user_id = (?) AND facility_id = (?) AND ALLOCATE_YN = 'Y'";
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
		while (resultSet != null && resultSet.next()) 
		{
			access_count= Integer.parseInt(resultSet.getString("COUNT"));
		}
		if(pstmt != null)
			pstmt.close() ;
		if(resultSet != null)
			resultSet.close() ;

		if(access_count>0){
%>
</head>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize  style='height:7vh;width:100vw'></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" src='../../eRS/jsp/MasterScheduleFrameset.jsp' frameborder=0 scrolling="no" noresize style='height:84vh;width:100vw'></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder=0 scrolling="auto" noresize style="height:9vh;width:100vw"></iframe>

<%
		}else
			out.println("<script>alert(getMessage('NO_AXS_FOR_GEN_SCH','RS')); parent.parent.document.location.href='../../eCommon/jsp/home.jsp' </script>");
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
</html>


<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*,java.net.*, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language='javascript' src='../js/BLApproveOSBalance.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String params = request.getQueryString();
	Connection con = null;

	String facility_id = (String) session.getValue("facility_id");
	String usr_id = (String) session.getValue("login_user");

	String errorFlag="";
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	try{
			con	=	ConnectionManager.getConnection(request);
			pstmt =  con.prepareStatement( "Select   nvl(APRV_OS_AMT_MR_REQ_YN,'N') from bl_users_for_credit_auth where operating_facility_id = '"+facility_id+"'  and credit_auth_user_id='"+usr_id+"'");
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				errorFlag=rs.getString(1);	
			}
	}
	catch(Exception e)
	{
		System.err.println("Exception in BLApproveOSBalanceForMedicalRecordRequest"+e);
		e.printStackTrace();
	}
	finally
	{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con);
	}
%>
<%if(errorFlag.equals("Y")){ %>	
  <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no'  style='height:6vh;width:100vw'></iframe>
  <iframe name="interim_main_report" id="interim_main_report" SRC="../../eBL/jsp/BLApproveOSMedRecReqFrame.jsp"	   frameborder=0 noresize scrolling='no' style='height:94vh;width:100vw'></iframe>
  <iframe name="dummyFrame" id="dummyFrame" src='../../eCommon/html/blank.html' frameborder=0 noresize   style='height:0vh;width:100vw'></iframe>
  <iframe name="messageFrame" id="messageFrame" src='../../eCommon/jsp/error.jsp' frameborder=0 noresize  style='height:0vh;width:100vw'></iframe>	
<%}else{ %>
	   <script>
			alert("Logged in User does not have rights to Authorize");
	   </script>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>' frameborder=0 scrolling='no'  style='height:6vh;width:100vw'></iframe>
<%} %>
</HTML>


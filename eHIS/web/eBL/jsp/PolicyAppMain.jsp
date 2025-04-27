<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eBL.* ,eBL.Common.*,eCommon.Common.*" %>
<HTML>
<HEAD>
</HEAD>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
	<script language='javascript' src='../../eBL/js/PolicyApproval.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String params = request.getQueryString();
	String facilityId = (String)session.getAttribute("facility_id");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	boolean siteSpecPolApprv = false;
	try {
		con = ConnectionManager.getConnection(request);
		String polApprvSql = "select NVL(enable_policy_approval_yn,'N') enable_policy_approval_yn from bl_parameters where operating_facility_id = '"+facilityId+"'";
		pstmt = con.prepareStatement(polApprvSql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String enablePolicyApprvl = rs.getString("enable_policy_approval_yn");
			if("Y".equals(enablePolicyApprvl)) {
				siteSpecPolApprv = true;
			}
		}
		rs.close();
		pstmt.close();
		if(!siteSpecPolApprv) {
			out.println("<script>alert(getMessage('BL0843', 'BL'));</script>");
		}
	} catch(Exception ex) {
		System.err.println("Error in PolicyAppMain.jsp: "+ex);
		ex.printStackTrace();
	}

	if(siteSpecPolApprv) { %>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='PolicyAppQueryCriteria' id='PolicyAppQueryCriteria' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:27vh;width:100vw'></iframe>
		<iframe name='PolicyAppQueryResult' id='PolicyAppQueryResult' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:60vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:7vh;width:100vw'></iframe>
	
		<% } else { %>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='PolicyAppQueryCriteria' id='PolicyAppQueryCriteria' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='PolicyAppQueryResult' id='PolicyAppQueryResult' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:25vh;width:0vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:25vh;width:0vw'></iframe>
	
			<% } %>
	
	
</HTML>


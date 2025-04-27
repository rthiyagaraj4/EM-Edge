<!DOCTYPE html>
<html>
<%@ page  import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try{
		
		con = ConnectionManager.getConnection();
		String ext_perm_loc = "";
		String params = request.getQueryString();
		String ext_perform_dtls_reqd_yn = "";
		String task_code = checkForNull(request.getParameter("task_code"));

		pstmt=con.prepareStatement("SELECT EXT_PERM_LOC FROM OH_TASKS WHERE TASK_CODE = ?");
		pstmt.setString(1,task_code);
		rs=pstmt.executeQuery();
		while(rs.next()){
			ext_perm_loc = checkForNull(rs.getString("EXT_PERM_LOC"));
		}

		pstmt=con.prepareStatement("SELECT EXT_PERFORM_DTLS_REQD_YN FROM OH_PARAM");
		//pstmt.setString(1,task_code);
		rs=pstmt.executeQuery();
		while(rs.next()){
			ext_perform_dtls_reqd_yn = checkForNull(rs.getString("EXT_PERFORM_DTLS_REQD_YN"));
		}

		//ext_perform_dtls_reqd_yn = "N";
		params = params+"&ext_perm_loc_param="+ext_perm_loc+"&ext_perform_dtls_reqd_yn="+ext_perform_dtls_reqd_yn;
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <frameset rows='20%,*'>
		<frame name="sendOutAcknowledgeTab" id="sendOutAcknowledgeTab" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHTrmtSendOutAcknowledgeTab.jsp?<%=params%>">
		<%if(ext_perm_loc.equals("Y")){%>
			<frame name='sendOutAcknowledgeDetail' id='sendOutAcknowledgeDetail' src="../../eOH/jsp/OHTrmtSendOut.jsp?<%=params%>" frameborder=0 noresize>
		<% }else{ %>
			<frame name='sendOutAcknowledgeDetail' id='sendOutAcknowledgeDetail' src="../../eOH/jsp/DentalTreatment.jsp?<%=params%>" frameborder=0 noresize>
		<% } %>

</frameset> 

</html>
<%
	}catch(Exception e){
		con.rollback();
		System.err.println("Err Msg from OHTrmtSendOutAckFrame.jsp "+e);
	}
	finally{
		if(rs!=null) rs.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>




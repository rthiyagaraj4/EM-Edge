<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<% 	
	
	
	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	String old_session_user_id	= (String)session.getValue("old_session_user_id");
	session.setAttribute("login_user",old_session_user_id.toUpperCase()) ;
	old_session_user_id=old_session_user_id.toUpperCase();
	String ca_practitioner_id = "";
	try{
		String sql = "SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?";
		connection = ConnectionManager.getConnection(request);	
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,old_session_user_id);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			ca_practitioner_id = resultset.getString("FUNC_ROLE_ID");
		}
		session.setAttribute("ca_practitioner_id",ca_practitioner_id.toUpperCase()) ;
	}catch(Exception e){
		System.err.println("28: Caught Exception in Select Note Type Set Attribute"+e);
	}finally{
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();		
		ConnectionManager.returnConnection(connection,request);
	}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">


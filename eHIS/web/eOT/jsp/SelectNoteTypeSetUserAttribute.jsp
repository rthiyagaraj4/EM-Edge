<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.*, java.text.*,eCommon.XSSRequestWrapper,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<% 	
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	Connection connection  = null;
	PreparedStatement pstmt=null;
	ResultSet resultset =null;
	String slate_user_id	= request.getParameter("slate_user_id");
	slate_user_id=slate_user_id.toUpperCase();
	String old_session_user_id	= (String)session.getValue("login_user");
	session.setAttribute("login_user",slate_user_id.toUpperCase()) ;
	session.setAttribute("old_session_user_id",old_session_user_id) ;
	String ca_practitioner_id = "";
	try{
		String sql = "SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?";
		connection = ConnectionManager.getConnection(request);	
		pstmt=connection.prepareStatement(sql);
		pstmt.setString(1,slate_user_id);
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


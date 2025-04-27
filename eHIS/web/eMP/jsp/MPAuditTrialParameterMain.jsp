<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	Connection con = null;

	PreparedStatement pstmt =null;
	ResultSet rs=null;
	int rec_count=0;
	try 
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("Select COUNT(*) from mp_param");
		rs = pstmt.executeQuery();
		
		rs.next();
		rec_count = Integer.parseInt(rs.getString(1));

		if(rs!=null) rs.close();
		if(pstmt !=null) pstmt.close();
	
	}catch(Exception e) {
		//out.println(e.getMessage());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174169859 on 28-08-2023
		}
	finally 
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	if( rec_count > 0 ) 
	{
	%>
		<html>
		<head>
 			<Script language='javascript' src='../js/MPAuditTrialParameter.js'></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> 
		</head>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='auditTrialFrame' id='auditTrialFrame' src='../../eMP/jsp/MPAuditTrialParameter.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
		</html>
		<%
	}
	else 
	{
		%>
			<html>
				<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
				<Script language="JavaScript">
					//document.location.href="'../../eCommon/jsp/dmenu.jsp";
					alert(getMessage("MP_PARAM_NOT_FOUND","MP"));
					document.location.href='../../eCommon/jsp/dmenu.jsp';
				</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</html>
		<%
	}
%>


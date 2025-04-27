<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement("Select count(*) as count from mp_param");
		rs = pstmt.executeQuery();
		if(rs != null)
		{
			rs.next() ;
			int count = rs.getInt( "count" ) ;

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(count > 0) 
			{
				%>
				<head>
					<script language='javascript' src='../js/TerminalDigit.js'></script>
					
					<script src='../../eCommon/js/common.js' language='javascript'></script>
				</head>
				<%
					String maintain_doc_or_file = "";

				pstmt = con.prepareStatement("SELECT maintain_doc_or_file FROM mp_param");
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					maintain_doc_or_file = rs.getString("maintain_doc_or_file");
					if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 
						maintain_doc_or_file = "";
				}
				if(maintain_doc_or_file.equals("F"))
				{
					String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
					String params = request.getQueryString() ;
					String source = url + params ;
					%>
					<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
						<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:83vh;width:100vw'></iframe>
						<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
					<%
				}
				else
				{
					%>
					<script>
						alert(getMessage("TERM_DIGIT_NOT_APPL","MP"));
						self.location.href='../../eCommon/html/blank.html';
					</script>
					<%
				}
			}
			else 
			{
				%>
				
				<Script language="JavaScript" src="../../eCommon/js/common.js"></Script>
				
				<Script language="JavaScript">
					alert(getMessage("MP_PARAM_NOT_FOUND","MP"));
				    document.location.href='../../eCommon/jsp/dmenu.jsp';
				</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				<%
			}
		}
	}
	catch(Exception e) 
	{ 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174083911 on 24-08-2023
	}
	finally
	{
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</html>


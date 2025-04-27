<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/FMDocumentFolder.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rst	= null;
		
		String maintain_doc_or_file = "";

//		String facility_id	= (String) session.getValue("facility_id");
		String mysql		= "SELECT maintain_doc_or_file FROM mp_param";

		try
		{
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			rst = stmt.executeQuery(mysql);
			if(rst != null && rst.next())
			{
				maintain_doc_or_file = rst.getString("maintain_doc_or_file");
			}
			if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null"))
				maintain_doc_or_file = "";

			if(!(maintain_doc_or_file.equals("D")))
			{
%>
				<SCRIPT>
					alert(getMessage("MP_PARAM_NOT_FOUND","MP"));
					parent.parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp';
				</SCRIPT>
<%			}
		String url		= "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String params	= request.getQueryString();
		String source	= url + params;
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:9%;width:100vw'></iframe>
				<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder='no' scrolling='no'>
				<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder='no' scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
			
<%
		}
		catch(Exception e)
		{
			out.println("Exception se :"+e.toString());
		}
		finally
		{
			if(rst  != null) rst.close();
			if(stmt != null) stmt.close();
			ConnectionManager.returnConnection(conn,request);
		}
%>
</HTML>


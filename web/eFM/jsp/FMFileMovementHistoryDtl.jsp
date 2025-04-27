<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	

	String maintain_doc_or_file = "";

	Connection conn = ConnectionManager.getConnection(request);
	Statement stmt  = null;
	ResultSet rs    = null;
	try
	{
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param");
		if(rs != null && rs.next())
		{
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		}if(rs != null) rs.close();
		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null"))
			maintain_doc_or_file = "";
		
	if(stmt!=null)  stmt.close();
	}catch(Exception e){out.println(e.toString());}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eFM/js/FMRepFileMovement.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
 <head>
<!-- <frameset rows='10%,80%,*' >	-->				
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
	<%if(maintain_doc_or_file.equals("D")){%>
		<iframe name='searchResultFrame' id='searchResultFrame' src='../../eFM/jsp/FMDocMovementHistorySearch.jsp' frameborder=0 scrolling='NO' noresize style='height:83vh;width:100vw'></iframe>
	<%}else if(maintain_doc_or_file.equals("F")){%>
		<iframe name='searchResultFrame' id='searchResultFrame' src='../../eFM/jsp/FMFileMovementHistorySearch.jsp' frameborder=0 scrolling='NO' noresize style='height:83vh;width:100vw'></iframe>
	<%}%>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>
<!-- </frameset> -->


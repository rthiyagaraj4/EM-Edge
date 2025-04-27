<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	21/06/2001
	 Module Name 	   :	FM\File Not returned to mrd
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>




<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
%>
	<script>
		function reset()
		{
			searchFrame.location.reload();
			volumeFrame.document.location.href="../../eCommon/html/blank.html"   ;
			searchResultFrame.document.location.href="../../eCommon/html/blank.html"   ;	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="   ;
		}
	</script>
	<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

	String doc_or_file				= "";
	String patient_id_max_length	= "";
	String file_type_appl_yn		= "";

	try 
	{
		stmt = con.createStatement();
		if(rs!=null)rs.close();
		rs = stmt.executeQuery("SELECT maintain_doc_or_file,patient_id_length, file_type_appl_yn FROM mp_param ");
		if(rs.next()) 
		{
			doc_or_file				= rs.getString("maintain_doc_or_file");
			patient_id_max_length	= rs.getString("patient_id_length");
			file_type_appl_yn		= rs.getString("file_type_appl_yn");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		if(doc_or_file == null || doc_or_file.equals("null")) doc_or_file = "F";
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "Y";
		if(patient_id_max_length == null || patient_id_max_length.equals("null")) patient_id_max_length = "10";
		
	}
	catch(Exception e)
	{
		out.println("Exception in obtaining MP Parameter::"+e);
	}	
	finally
	{			
		ConnectionManager.returnConnection(con,request);
	}
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='/eHIS/common/html/ehis.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eFM/js/QueryFMCurrentFileStatus.js' language='javascript'></script>
 <head>

 <% if (doc_or_file.equals("D")) {   %> 

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='searchFrame' id='searchFrame'       src='../../eFM/jsp/QueryCurrentDocStatus.jsp?doc_or_file=<%=doc_or_file%>'	scrolling='NO' frameborder=0 noresize style='height:10vh;width:100vw'></iframe>
		<iframe name='volumeFrame' id='volumeFrame'       src='../../eCommon/html/blank.html'	scrolling='auto' frameborder=0 noresize style='height:20vh;width:100vw'></iframe>
		<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:65vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:9vh;width:100vw'></iframe>
	

	 <% } else if(doc_or_file.equals("F")){ %>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'      src='<%=source%>' scrolling='NO' frameborder=0  noresize style='height:7vh;width:100vw'></iframe>
		<iframe name='searchFrame' id='searchFrame'       src='../../eFM/jsp/QueryCurrentFileStatus.jsp?patient_id_length=<%=patient_id_max_length%>&file_type_appl_yn=<%=file_type_appl_yn%>'	scrolling='NO' frameborder=0 noresize style='height:15vh;width:100vw'></iframe>
		<iframe name='volumeFrame' id='volumeFrame'       src='../../eCommon/html/blank.html'	scrolling='auto' frameborder=0 noresize style='height:7vh;width:100vw'></iframe>
		<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='NO' noresize style='height:65vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no' frameborder='0' noresize style='height:8vh;width:100vw'></iframe>
	
<% } %>


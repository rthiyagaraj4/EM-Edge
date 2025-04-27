<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------------------		
11/05/2017	IN064233		Raja S			16/05/2017		Ramesh G 		Alpha-CA-image not showing After select image reference
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src ="../../eCA/js/ImageForSection.js"></script> <!-- to call the function callFunction()-->
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>

<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String image_ref = "";
	String sql = "";
	try
	{
			con = ConnectionManager.getConnection(request);
			image_ref = request.getParameter("image_ref") == null ? "" : request.getParameter("image_ref");
			//sql = "select image_url from ca_note_image_list where image_ref='"+image_ref+"'";//common-icn-0180
			sql = "select image_url from ca_note_image_list where image_ref= ?";//common-icn-0180
			ps = con.prepareStatement(sql);
			ps.setString(1,image_ref);//common-icn-0180
			rs = ps.executeQuery();			
			out.println("<script>");
			
			while(rs.next())
			{
				String image_url=rs.getString("image_url");
				out.println("parent.f_query_add_mod.document.ImageForSectionFrm.image_previewer.src='../MediPainter/images/"+image_url+"' ");
				out.println("parent.f_query_add_mod.document.getElementById('refimage').style='display' "); //IN064233
				
			}	
			out.println("</script>");
			if(rs != null) rs.close();
			if(ps != null) ps.close();	

	}
	catch(Exception ee)
	{
		ee.printStackTrace() ;
	}
	finally
	{		
				if(con != null) ConnectionManager.returnConnection(con);
		
	}
%>
 </body>
</html>


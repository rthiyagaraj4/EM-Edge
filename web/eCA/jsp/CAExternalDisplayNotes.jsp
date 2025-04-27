<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.io.*,javax.xml.transform.*,java.awt.image.BufferedImage,javax.imageio.ImageIO,sun.misc.BASE64Decoder" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
%>

<html>
<title></title>
<head> 
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<form name = "CAExtenalDisplayNotes">

<%

	Connection			con				=	null;
	PreparedStatement	pstmt			=	null;
	ResultSet			rset			=	null;
	String				accession_num	=	request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	StringBuffer displaydata = new StringBuffer();

try {
	con = ConnectionManager.getConnection(request);
	String site_name = "";
	String facility_name = "";
	String facility_id 			= (String)session.getAttribute("facility_id");
	
	String sql = "SELECT A.HIST_DATA_NOTES,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name FROM CR_ENCOUNTER_DETAIL_OBJ A WHERE A.ACCESSION_NUM = ? ";

	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, locale);
	pstmt.setString(2, facility_id);
	pstmt.setString(3, locale);
	pstmt.setString(4, accession_num);
	rset = pstmt.executeQuery();
	if(rset.next())
	{
		Clob note=rset.getClob("HIST_DATA_NOTES");
		facility_name			=	rset.getString("facility_name") == null ? "" : rset.getString("facility_name");
		site_name			=	rset.getString("site_name")==null?"":rset.getString("site_name");

		displaydata = new StringBuffer();
		if(note!=null)
		{
			java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
			String line = null;
			while((line=r.readLine()) != null) displaydata.append(line+"\n");
		}
	}
	%>
	<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >
	<tr>
		<td width='20%'  align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>
		<td width='60%' align='center'><h3><%=site_name%></h3></td>
		<td width='20%'  align='center'>&nbsp;</td>
	</tr>
	<tr>
		<td width='20%'  align='center'>&nbsp;</td>
		<td width='60%'  align='center'><h3><%=facility_name%></h3></td>
		<td width='20%'  align='center'>&nbsp;</td>
	</tr>
	</table>
	<%=displaydata.toString()%>
	<%
	}	
	catch(Exception e)
	{			
		e.printStackTrace();
	}
	finally{
		if(con!=null)	ConnectionManager.returnConnection(con,request);
		if(rset!=null)	rset.close();
		if(pstmt!=null) pstmt.close();
	}
%>
</form>
</body>
</html>


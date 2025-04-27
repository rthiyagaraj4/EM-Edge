<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100				?				?				?           created
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya 		Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
----------------------------------------------------------------------------------------------------------------------------------------------------------

*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title>RecClinicalNotesContentView.jsp</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<style>
	/*IN043895 Start.*/
	/*ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }*/
		/* IN049424 Start.*/
			/*ADDRESS	{ 
				FONT-FAMILY: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS" ;
				FONT-SIZE: 10pt ; 
				FONT-STYLE: NORMAL; 
				COLOR: BLACK; 
			}*/
			ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; white-space: break-spaces; }
		/* IN049424 End.*/	
	/*IN043895 End.*/
	</style>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='RecClinicalNotesContentViewForm' id='RecClinicalNotesContentViewForm'>
	<!-- <th>NOTES CONTENT</th> -->
<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	query_notes_detail	=	"";//,		note_type			=	"";

	String	facility_id			=	"",		accession_num		=	"";
	String	notes_content		=	"";
	String	operation_mode		=	"";

	//oracle.sql.CLOB			clob_notes_content	= null;
	java.sql.Clob	clob_notes_content	= null;//Modified by Ambiga.M for 18712 on 2/25/2010  
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	try
	{

		operation_mode	=	(request.getParameter("operation_mode")==null)	? "" :	request.getParameter("operation_mode");

		facility_id		=	(String) session.getValue("facility_id");

		accession_num	=	(request.getParameter("accession_num")==null)	? "" : request.getParameter("accession_num");

%>
	<input type='hidden' name='operation_mode' id='operation_mode' value='<%=operation_mode%>'>
</form>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<%
		con				=	ConnectionManager.getConnection(request);

		query_notes_detail = "select note_content from ca_encntr_note a where /*facility_id = ? and */ accession_num = ?";
		pstmt			=	con.prepareStatement(query_notes_detail);

		//pstmt.setString(1, facility_id);
		pstmt.setString(1, accession_num);

		rs				=	pstmt.executeQuery();

		if(rs.next())
		{
			clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");

			if(clob_notes_content!=null)
			{
				try
				{
					content_reader	= ((java.sql.Clob) clob_notes_content).getCharacterStream();//Modified by Ambiga.M for 18712 on 2/25/2010  
					bf_content_reader = new java.io.BufferedReader(content_reader);

					char[] arr_notes_content = new char[(int)clob_notes_content.length()];


					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

					//out.println("<BR>arr_notes_content : "+arr_notes_content);

					notes_content = new String(arr_notes_content);

					bf_content_reader.close();
				}
				catch(Exception e)
				{
					//out.println("Exception@2-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}

			%>
				<tr>
					<td class='BODYCOLORFILLED'><%=notes_content%></td>
				</tr>
			<%
			} // end of if(clob_notes_content!=null)
		} // end of if(rs.next())
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
	</table>
</body>
</html>


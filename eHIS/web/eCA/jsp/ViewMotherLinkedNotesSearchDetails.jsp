<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/10/2016	Created 		Raja S											MO-CRF-20108[IN058912] 
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>RecClinicalNotesSearchDetails</title>
	
	<style>
		ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
		PRE
		{
			font-size:10pt;			
			font-family: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";
			//BACKGROUND-COLOR: #E2E3F0;
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}	
	</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<form name='RecClinicalNotesSearchDetailsForm' id='RecClinicalNotesSearchDetailsForm'>
<div id="note_content">
<table class='grid' width='100%' align='center'>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	Connection			con			=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs					=	null;

	String	query_notes_detail	=	"";
	String	accession_num			=	"";
	String	notes_content			=	"";

	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	try	
	{
		

		accession_num	=	(request.getParameter("accession_num")==null)	? "" : request.getParameter("accession_num");

		con				=	ConnectionManager.getConnection(request);

		query_notes_detail = "select a.note_content, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc from ca_encntr_note a where a.accession_num = ?";
		pstmt			=	con.prepareStatement(query_notes_detail);

		pstmt.setString(1, locale);
		pstmt.setString(2, accession_num);

		rs				=	pstmt.executeQuery();

		if(rs.next())
		{
			clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");

			if(clob_notes_content!=null)
			{
				try
				{
					content_reader	= clob_notes_content.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(content_reader);

					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

					notes_content = new String(arr_notes_content);
					notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  
					bf_content_reader.close();
				}
				catch(Exception e)
				{
					//out.println("Exception@2-readCLOB : "+e);//COMMON-ICN-0181
                                         e.printStackTrace();//COMMON-ICN-0181
				}
			%>
				 <tr>
					<td class='gridData'> <%=notes_content%></td>
				</tr>
			<%
			} // end of if(clob_notes_content!=null)
		} // end of if(rs.next())
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%> 
	 </table>
	 </div>
	</form>
</body>
</html>


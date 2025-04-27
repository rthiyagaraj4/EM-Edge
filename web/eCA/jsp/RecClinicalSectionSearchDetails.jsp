<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name	Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
22/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)							
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

	<title>RecClinicalSectionSearchDetails</title>
	
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
<form name='RecClinicalSectionSearchDetailsForm' id='RecClinicalSectionSearchDetailsForm'>
<div id="note_content">
<table class='grid' width='100%' align='center'>
<%
	Connection			con			=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs					=	null;

	String	query_notes_detail	=	"";
	String	facility_id					=	"";
	String	accession_num			=	"";
	String	notes_content			=	"";
	String 	subsec_hdg_code			=	"";

	java.sql.Clob			clob_section_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	
	try	
	{
		

		facility_id		=	(request.getParameter("facility_id")==null)		? "" : request.getParameter("facility_id");

		accession_num	=	(request.getParameter("accession_num")==null)	? "" : request.getParameter("accession_num");
		
		subsec_hdg_code	=	(request.getParameter("subsec_hdg_code")==null)	? "" : request.getParameter("subsec_hdg_code");

		con				=	ConnectionManager.getConnection(request);
		
		query_notes_detail = "select NOTES_SEC_CONT_HTML from ca_encntr_note_section where sec_hdg_code = ? and accession_num = ?";
		pstmt			=	con.prepareStatement(query_notes_detail);

		pstmt.setString(1, subsec_hdg_code);
		pstmt.setString(2, accession_num);

		rs				=	pstmt.executeQuery();

		if(rs.next())
		{
			clob_section_content	=	(java.sql.Clob) rs.getObject("NOTES_SEC_CONT_HTML");

			if(clob_section_content!=null)
			{
				try
				{
					content_reader	= clob_section_content.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(content_reader);

					char[] arr_notes_content = new char[(int)clob_section_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_section_content.length());

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
			} // end of if(clob_section_content!=null)
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


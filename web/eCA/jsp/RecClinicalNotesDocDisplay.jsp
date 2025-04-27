<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
String			accession_num			=	"";
String			facility_id				=	"";
String			section_hdg_code		=	"";
String			subsec_hdg_code			=	"";
StringBuffer	buf						=	new StringBuffer();
//the following variable will be used to get the raw section content from the database. if it is not a template, the it would not be converted, otherwise it would be.



//the following variable will be used to convert the XML content coming from the database to HTML through the XMLToHTML convertor if the contenttype is a template.
String			notes_section_content	=	"";
String			qry						=	"";
String			subsec_content_type			=	"";
java.sql.ResultSet		rs = null;
java.sql.Connection		con = null;
java.sql.PreparedStatement pstmt = null;
%>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	//qry = "select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.SUBSEC_HDG_CODE , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where accession_num = ? and facility_id = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and a.sec_hdg_code = ? and a.SUBSEC_HDG_CODE = ?";
	qry="select a.sec_hdg_code , b.content_type sec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.sec_hdg_code,?,'1') sec_hdg_desc , a.SUBSEC_HDG_CODE ,c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content from ca_encntr_note_section a ,ca_section_hdg_LANG_vw c where 	accession_num = ? and 	facility_id = ? and	c.language_id = ? and 	c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and 	a.sec_hdg_code = ? and 	a.SUBSEC_HDG_CODE = ?";
	accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));
	//facility_id = (request.getParameter("facility_id")==null?"":request.getParameter("facility_id"));
	facility_id = (String)session.getValue("facility_id");
	section_hdg_code = (request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code"));
	subsec_hdg_code = (request.getParameter("subsec_hdg_code")==null?"":request.getParameter("subsec_hdg_code"));
	try
	{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry);
		pstmt.setString(1, locale);
		pstmt.setString(2, accession_num);
		pstmt.setString(3, facility_id);
		pstmt.setString(4, locale);
		pstmt.setString(5, section_hdg_code);
		pstmt.setString(6, subsec_hdg_code);
		rs = pstmt.executeQuery();
		buf.append("<link rel=StyleSheet href='../../eCommon/html/" + sStyle + "' type='text/css' />");
		while(rs.next())
		{
			buf.append("&nbsp;&nbsp;&nbsp;");
			buf.append("&nbsp;&nbsp;&nbsp;");
			buf.append("&nbsp;&nbsp;&nbsp;");
			buf.append("<table width='100% '><tr><td class='NOTEHEADER'>");
			buf.append(rs.getString("subsec_hdg_desc"));
			buf.append("</td></tr></table>");
			buf.append("&nbsp;&nbsp;&nbsp;");
			subsec_content_type = rs.getString("subsec_content_type");
			Clob clb = rs.getClob("notes_section_content");
			if(clb.length()>0)
			{
				//java.io.BufferedInputStream r = clb.getAsciiStream();
				BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
				String line="";
				while(line!=null)
				{
					notes_section_content+=line;
					line = d.readLine();					
				}
			}
			if(subsec_content_type.equals("T"))
			{			
				//buf.append("Eureka!!! its a template");
				// IN071335 Changes Start.
				/*
				StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
				url = new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));					
				url.append("html/RecClinicalNotesTemplateSentenceView.xsl");
				notes_section_content = converter.buildHTMLFromXML(notes_section_content,url.toString());
				*/
				String url					= application.getRealPath("/eCA")+"/";
				url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";
				notes_section_content = converter.buildHTMLFromXML(notes_section_content,url); 				
				// IN071335 Changes End.
				buf.append(notes_section_content);
			}
			else
				buf.append(notes_section_content);
		}
	}
	catch(SQLException sqle)
	{
		buf.append("SQL Exception = " + sqle);
		sqle.printStackTrace();
	}
	catch(Exception se)
	{
		buf.append("SQL Exception = " + se);
		se.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();

		if(con!=null)	ConnectionManager.returnConnection(con);
	}
//	buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>");
	
%>
<form>
<%=buf%>
<div id="data" style='display:none;' border='0' width='0'>
<%=buf%>
</div>
</form>
</BODY>
</HTML>
<script>
if(parent.RecClinicalNotesLinkHistNoteAddButtonsFrame != null)
	parent.RecClinicalNotesLinkHistNoteAddButtonsFrame.RecClinicalNotesLinkHistNoteAddButtonsForm.select.disabled=false;
</script>


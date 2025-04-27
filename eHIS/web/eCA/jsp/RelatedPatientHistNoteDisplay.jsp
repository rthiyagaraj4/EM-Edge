<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<title><fmt:message key="Common.details.label" bundle="${common_labels}"/></title>
<%
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;
	
	Clob			clb=null;

	String			accession_num			=	"";
	String			notes_section_content	=	"";
	StringBuffer qry =new StringBuffer(" Select NOTE_CONTENT from CA_ENCNTR_NOTE where ACCESSION_NUM = ? ");

	accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));

	if(!accession_num.equals(""))
	{	
		try
		{

		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry.toString());
		pstmt.setString(1, accession_num);

		rs = pstmt.executeQuery();

		while(rs.next())
		{
			  notes_section_content = "";

			  clb = rs.getClob("NOTE_CONTENT");

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
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception from RelatedPatientHistNoteDisplay.jsp " + e.toString());//COMMON-ICN-0181
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con, request);
		}
	}
	
	out.println(notes_section_content);
	%>

	





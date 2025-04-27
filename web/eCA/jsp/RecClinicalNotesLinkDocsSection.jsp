<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String accession_num="";
String event_desc="";
String facility_id="";
String qry="";
Connection con	 = null;
PreparedStatement stmt = null;
ResultSet rs = null;
int i=0;
%>
<%
accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));
event_desc = (request.getParameter("event_desc")==null?"":request.getParameter("event_desc"));
facility_id	= (String) session.getValue("facility_id");
//qry = "select  distinct(a.sec_hdg_code) , b.content_type sec_content_type , b.sec_hdg_desc  from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where accession_num = ? and facility_id = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE";
qry = "select  distinct(a.sec_hdg_code) , b.content_type sec_content_type , b.sec_hdg_desc from ca_encntr_note_section a ,CA_SECTION_HDG_LANG_VW b ,CA_SECTION_HDG_LANG_VW c where 	accession_num = ? and 	facility_id = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE	and	b.language_id = ? and c.language_id = ?";
%>
<html>
	<head>
		
		<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesPart3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
		<form name="rec_details_section_form" id="rec_details_section_form">
		<center>
			<table width="100%" border=1 cellpadding='3' align='center'>
				<tr><td class='columnheader'><fmt:message key="Common.Section.label" bundle="${common_labels}"/>
				<fmt:message key="Common.for.label" bundle="${common_labels}"/>	 <%=event_desc%> <!-- Section(s) for -->
				</td></tr>
		<%
			String section_content_type="";
			try
			{
			con	= ConnectionManager.getConnection(request);
			stmt	= con.prepareStatement(qry);
			stmt.setString(1, accession_num);
			stmt.setString(2, facility_id);
			stmt.setString(3, locale);
			stmt.setString(4, locale);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				String rowclass="";
				if(i%2==0)
					rowclass = "QRYEVEN";
				else
					rowclass = "QRYODD";
				section_content_type = rs.getString("sec_content_type");
				if(section_content_type.equals("S"))
				{
					out.println("<tr><td class='" + rowclass + "' onclick = javascript:callShowSubSection('" + request.getQueryString() + "','" + rs.getString("SEC_HDG_DESC") + "','" + rs.getString("sec_hdg_code") + "') style=cursor:pointer;><b>" + rs.getString("SEC_HDG_DESC") + "</b></td></tr> ");
				}
				else
				{
					out.println("<tr><td class='" + rowclass + "' onclick = showPreview('" + request.getQueryString() + "','" + rs.getString("sec_hdg_code") + "') style=cursor:pointer;>" + rs.getString("SEC_HDG_DESC") + "</td></tr>");
				}
				i++;
			}
			
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception@345 RecClinicalNotesLinkDocsSection- >" +  e.getMessage());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null)	ConnectionManager.returnConnection(con,request);
			}

		%>
			</table>
		</center>
		</form>
	</body>
</html>


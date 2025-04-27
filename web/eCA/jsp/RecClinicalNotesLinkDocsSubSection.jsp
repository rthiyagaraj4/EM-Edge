<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String					accession_num="";
String					facility_id="";
String					qry="";
String					sectionName="";

String					section_hdg_code="", subsec_hdg_code="";
int i=0;
Connection con	= null;
PreparedStatement stmt = null;
ResultSet rs = null;
%>
<%
accession_num = (request.getParameter("accession_num")==null?"":request.getParameter("accession_num"));
facility_id	= (String) session.getValue("facility_id");
sectionName = (request.getParameter("section_name")==null?"":request.getParameter("section_name"));
section_hdg_code = (request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code"));
//qry = "select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.SUBSEC_HDG_CODE , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where accession_num = ? and facility_id = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and a.sec_hdg_code = ?";
qry = "select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.SUBSEC_HDG_CODE , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content from 	ca_encntr_note_section a ,CA_SECTION_HDG_LANG_VW b ,CA_SECTION_HDG_LANG_VW c where 	accession_num = ? and 	facility_id = ? and 	b.sec_hdg_code=a.sec_hdg_code and 	c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and 	a.sec_hdg_code = ?	and	b.language_id = ? and c.language_id = ?";

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
		<script language="JavaScript">
		function showPreview(accession_num, facility_id, sec_hdg_code, subsec_hdg_code)
		{
/*			alert(accession_num);
			alert(facility_id);
			alert(sec_hdg_code);
			alert(subsec_hdg_code);*/
			parent.RecClinicalNotesLinkDocsDisplayFrame.location.href = "../../eCA/jsp/RecClinicalNotesDocDisplay.jsp?accession_num=" + accession_num + "&facility_id=" + facility_id + "&section_hdg_code=" + sec_hdg_code + "&subsec_hdg_code=" + subsec_hdg_code;
			parent.RecClinicalNotesLinkDocsDisplaySelectFrame.RecClinicalNotesLinkForm.select.disabled=false;
		}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
		<form name="rec_details_section_form" id="rec_details_section_form">
		<center>
			<table width="100%" border=1 cellpadding ='3' align='center'>
			<tr>
				<td class='columnheader'>
					<fmt:message key="eCA.SubSectionsfor.label" bundle="${ca_labels}"/> <%=sectionName%>
				</th>
			</tr>
			<%
			try
			{
				con	= ConnectionManager.getConnection(request);
				stmt	= con.prepareStatement(qry);
				stmt.setString(1, accession_num);
				stmt.setString(2, facility_id);
				stmt.setString(3, section_hdg_code);
				stmt.setString(4, locale);
				stmt.setString(5, locale);
				rs = stmt.executeQuery();
				while(rs.next())
				{
					String rowclass="";
					if(i%2==0)
						rowclass = "QRYEVEN";
					else
						rowclass = "QRYODD";
					subsec_hdg_code = rs.getString("SUBSEC_HDG_CODE");
					out.println("<tr>");

					out.println("<td class='" + rowclass + "' onclick = showPreview('" + accession_num + "','" + facility_id + "','" + section_hdg_code + "','" + subsec_hdg_code + "') style=cursor:pointer;>" + rs.getString("SUBSEC_HDG_DESC") + "</td></tr>");
					i++;
				}
			
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch(SQLException se)
			{
				StringWriter sw = new StringWriter();
				se.printStackTrace(new PrintWriter(sw));
				out.println(sw);
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
			%>
			</table>
		</center>
		</form>
	</body>
</html>


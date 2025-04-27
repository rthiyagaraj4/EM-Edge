<?xml version='1.0' encoding="UTF-8"?>
<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
02/05/2017	IN061907		Krishna Gowtham		02/05/2017	Ramesh G		ML-MMOH-CRF-0559
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="application/xml;charset=UTF-8" language="java" import="org.w3c.dom.*,java.sql.*, webbeans.eCommon.*"%>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView.xsl"?> 
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm" FORM-ID="RecClinicalNotesTemplateForm">
<CSS sStyle="<%=sStyle%>"/>

<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCA/js/SectionTemplate.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/SpeciltyEvents.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/showModalDialog.js'></SCRIPT>

<%
	Connection con	= null;
	PreparedStatement pstmt	= null;	
	ResultSet rs = null;

	String sec_hdg_code	= (request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
	StringBuffer contentXML = new StringBuffer();
	String systemDateTime = ""; 
	String systemDate = ""; 	
	
	try
	{
		con	= ConnectionManager.getConnection(request);				
	
		String query = " Select TEMPLATE_FORMAT, to_char(sysdate, 'dd/mm/yyyy hh24:mi') systemDateTime, to_char(sysdate, 'dd/mm/yyyy') systemDate  from CA_SECTION_HDG where sec_hdg_code = ? ";
		pstmt		=	con.prepareStatement(query);
		
		pstmt.setString	(	1,	sec_hdg_code	);		
		rs			=	pstmt.executeQuery();
		if(rs.next())
		{
			Clob clb = rs.getClob(1);
			systemDateTime = rs.getString("systemDateTime");
			systemDate = rs.getString("systemDate");
			

			if(clb!=null)
			{
				java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
				String line = null;
				while((line=r.readLine()) != null) {
					
			    	contentXML.append(line);
				}
				%>					
					<%=contentXML.toString()%>
				<%
			}			
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception@2: "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
<HIDDEN-FIELD NAME="systemDate99999A" ID="systemDate99999A" VALUE="<%=systemDate%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="systemDateTime99999A" ID="systemDateTime99999A" VALUE="<%=systemDateTime%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="callFromPreview"  ID="callFromPreview" VALUE="Y"></HIDDEN-FIELD><!--IN061907-->
</DOCUMENT>
	


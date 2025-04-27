<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created 
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory  results in a clinical note section template does not display neatly .	
13/05/2016		IN059571	Ramesh G										Problem:Lab & Radiology Results are not transferring to CA screen, from yesterday nigh the background job was running.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="application/xml;charset=UTF-8" import="org.w3c.dom.*,java.sql.*,webbeans.eCommon.*"%>
<?xml version='1.0' encoding="UTF-8"?>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN041284 Start.
	String dispResLinkHYMLYN 		=(request.getParameter("dispResLinkHYMLYN")==null)?"N":(String)request.getParameter("dispResLinkHYMLYN");
	String noteSplCharValidate 		=(request.getParameter("noteSplCharValidate")==null)?"N":(String)request.getParameter("noteSplCharValidate"); //IN059571	
if("Y".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea.xsl"?>
<%
//IN059571 Start. 
}else if("Y".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea_SplVald.xsl"?>
<%
}else if("N".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView.xsl"?>
<%
}else if("N".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView__SplVald.xsl"?>
<%
//IN059571 End.	
} //IN041284 %>
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm">
<CSS sStyle="<%=sStyle%>"/>

<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js'></SCRIPT>
<!--included for 10261 in 07/06/09-->
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/SpeciltyEvents.js'></SCRIPT>

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
<HIDDEN-FIELD NAME="systemDate99999A" VALUE="<%=systemDate%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="systemDateTime99999A" VALUE="<%=systemDateTime%>"></HIDDEN-FIELD>
</DOCUMENT>
	


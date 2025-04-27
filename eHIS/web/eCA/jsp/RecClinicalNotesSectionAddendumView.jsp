<!DOCTYPE html>
<%@page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>

<html>
<head>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<title>RecClinicalNotesSectionView</title>
	
	<%
		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<style>
		ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<table border='0' cellpadding='3' cellspacing='0' width = '100%' align='center'>
<%
	String	sec_content_type			=	"",		section_content		=	"";
	String	sec_hdg_code				=	"",		child_sec_hdg_code	=	"";	
	String  patient_id				    =	"",		encounter_id		=	"";

	
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	// IN071335 Changes Start
	//String url				= HttpUtils.getRequestURL(request).toString();
	//url = url.substring(0,url.indexOf("jsp/"));
	String url					= application.getRealPath("/eCA")+"/";
	// IN071335 Changes End.
	url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";


	try
	{
		sec_hdg_code		=	checkForNull(	request.getParameter("sec_hdg_code")	);
		sec_content_type	=	checkForNull( request.getParameter("sec_content_type") );
		child_sec_hdg_code	=	checkForNull( request.getParameter("child_sec_hdg_code") );
		encounter_id	=	(request.getParameter("encounter_id")==null)		? ""	:	request.getParameter("encounter_id");
		patient_id		=	(request.getParameter("patient_id")==null)		? ""	:	request.getParameter("patient_id");

		String strKey	=	"";

		strKey = patient_id + "~"+ encounter_id;
		strKey = strKey.trim();

		sectionBean.getPatientSection(strKey);
		
		if( !(sec_hdg_code.equals("")) )
		{
			section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
			
			if(sec_content_type.equals("T"))
			{
				if(!(section_content.equals("&nbsp;")))
					section_content=converter.buildHTMLFromXML(section_content,url);
			}
			
			if(!(section_content.equals("&nbsp;")))
			{
				%>
				<tr><td class='BODYCOLORFILLED'><%=section_content%></td></tr>
				<%
			//&nbsp;&nbsp;&nbsp;
			}
		}
	}
	catch(Exception e)
	{
		//out.println("Exception@2 : "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		converter =null;
	}
%>
</table>
</center>
</body>

</html>
<%!
	public String checkForNull(String inputString)
	{
		return ((inputString==null )	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null )inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
	}

%>


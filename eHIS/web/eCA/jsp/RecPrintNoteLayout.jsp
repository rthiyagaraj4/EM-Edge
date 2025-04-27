<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
14/08/2015	IN052376		Ramesh G										MMS-RY-CRF-0012 [IN:052376]
01/09/2015	IN057173		Ramesh G										System does not print main sections and their linked subsections with components.
10/10/2018	IN068669		sivabagyam	 	10/10/2018	     Ramesh G       ARYU-CRF-0026
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
---------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.Date,java.text.SimpleDateFormat,eCommon.XSSRequestWrapper"%>
<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<style type="text/css" media="print">   
	th {
		font-family:Arial;
		color:black;
		background-color:lightgrey;
	}
	thead {
		display:table-header-group;
	}
	tbody {
		display:table-row-group;
	}
	tfoot {
		display:table-footer-group;		
	}

</style>
</head>
<title><%=request.getParameter("title")%></title>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "Print()">
<form>
<%

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id		=	(String)session.getValue("facility_id");
	String 	header_top 			= "";	
	String	logo_hdr_all_pages 	= "";
	String	rpt_hdr_all_pages 	= "";	
	String	footer_bottom 		= ""; 
	String	hdr_ft_yn 			= "";
	String	note_type			= "";
	String	imageLogoHeader 	= "N";
	String 	textLogoHeader 		= "N";
	String 	printhdrindsyn		= "";
	String  note_group_desc		= "";
	String	site_name			= "";
	String	facility_name		= "";
	String	patient_id			= "";
	String	encounter_id			= "";
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40";//IN068669
	int sectionCount			=0;
	int note_print_time_interval	=0;
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;	
	PreparedStatement	pstmt1		=	null;
	ResultSet			rs1			=	null;
	StringBuffer query_section_details = new StringBuffer(); //IN057173
	note_type			=	request.getParameter("note_type")==null		? ""	:	request.getParameter("note_type");
	patient_id			=	request.getParameter("patient_id")==null	? ""	:	request.getParameter("patient_id");
	encounter_id		=	request.getParameter("encounter_id")==null	? ""	:	request.getParameter("encounter_id");
	
	try{	
		con	= ConnectionManager.getConnection(request);
		//pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN  FROM ca_note_param "); commenetd for IN068669
		pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,LOGO_HDR_HEIGHT,LOGO_HDR_WIDTH FROM ca_note_param ");//IN068669
		rs	=	pstmt.executeQuery();
		if(rs.next()){
				logo_hdr_all_pages	= rs.getString("LOGO_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("LOGO_HDR_ALL_PAGE_YN");
				rpt_hdr_all_pages	= rs.getString("RPT_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("RPT_HDR_ALL_PAGE_YN");
				LOGO_HDR_HEIGHT = rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT"); //IN068669
				LOGO_HDR_WIDTH = rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH"); //IN068669
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception e){
			//out.println("Exception@111 - in getting logo and report header: "+e);//COMMON-ICN-0181		
			e.printStackTrace();//COMMON-ICN-0181
	}
		
	try{
		pstmt = con.prepareStatement("select HDR_FT_MARGIN_IN_NOTE_YN from CA_NOTE_PARAM");
		rs = pstmt.executeQuery();
		if(rs.next()){
			hdr_ft_yn =  rs.getString("HDR_FT_MARGIN_IN_NOTE_YN") == null ? "" : rs.getString("HDR_FT_MARGIN_IN_NOTE_YN");
		}
		if(hdr_ft_yn.equals("Y")){
			rs = null;
			pstmt = null;
			pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH ,FT_MARGIN_IN_INCH from CA_NOTE_TYPE where NOTE_TYPE = ? "); //[IN031116] End
			pstmt.setString	(1,note_type );
			rs	=	pstmt.executeQuery();
			if(rs.next()){
				header_top	= rs.getString("HDR_MARGIN_IN_INCH") == null ? "" : rs.getString("HDR_MARGIN_IN_INCH");
				footer_bottom = rs.getString("FT_MARGIN_IN_INCH") == null ? "" : rs.getString("FT_MARGIN_IN_INCH");
			}
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception e){
		//out.println("Exception@111 - in getting header_appl_yn : "+e);//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	try
	{

		pstmt	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
		rs = pstmt.executeQuery();
		if(rs.next()){
			imageLogoHeader="Y";				
		}
		
		pstmt	= con.prepareStatement("SELECT PRINT_LOGO_HEADER_YN,PRINT_TEXT_HDR_YN FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");
		pstmt.setString(1,note_type);
		rs = pstmt.executeQuery();
		if(rs.next()){
			String printLogoHed = rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
			printhdrindsyn		= rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
			String printtextHed = rs.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs.getString("PRINT_TEXT_HDR_YN");
			if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
					textLogoHeader="Y";				
		}
	}catch(Exception eee)
	{
		//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	
	try{
		
		pstmt			=	con.prepareStatement("SELECT A.NOTE_GROUP_DESC NOTEGRDESC FROM CA_NOTE_GROUP A,CA_NOTE_TYPE B WHERE A.NOTE_GROUP=B.NOTE_GROUP_ID AND B.NOTE_TYPE=?");
		pstmt.setString(1, note_type);			
		rs				=	pstmt.executeQuery();
		if(rs.next())
		{
			note_group_desc = rs.getString("NOTEGRDESC");
		}
		
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
		
		//pstmt			=	con.prepareStatement("Select sm_get_desc.sm_facility_param (facility_id, ?, '1') facility_name,(SELECT site_name FROM sm_site_param_lang_vw WHERE language_id = ?) site_name from pr_encounter where ENCOUNTER_ID = ? and patient_id=?");
		pstmt			=	con.prepareStatement("SELECT SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') FACILITY_NAME, (SELECT SITE_NAME FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID=?) SITE_NAME FROM DUAL");
		//pstmt.setString(1, locale);	
		//pstmt.setString(2, locale);
		//pstmt.setString(3, encounter_id);
		//pstmt.setString(4, patient_id);
		pstmt.setString(1, facility_id);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		rs				=	pstmt.executeQuery();
		if(rs.next())
		{
			facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
			site_name			=	rs.getString("site_name")==null?"":rs.getString("site_name");
		}
		
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception eee)
	{
		//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script Language="vbscript">
    Dim WSHShell
    Dim myHeader
    Dim myFooter
    Dim myMarginleft 
    Dim myMarginright 
    Set WSHShell = CreateObject("WScript.Shell")
    REM myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
    REM myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")
    REM myMarginleft = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left") 
    REM myMarginright = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right") 

    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"
	<%
	if(!header_top.equals(""))
	{
	%>
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_top", "<%=header_top%>"
	<%
	} 
	else
	{
	%>
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_top", "0.75"
	<%
	}
	%>
  
	<%
	
	if(!footer_bottom.equals(""))
	{
	%>	
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_bottom", "<%=footer_bottom%>"
	<%
	} 
	else
	{
	%>	
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_bottom", "0.5"
	<%
	}
	
	%>
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>





<style>
	ADDRESS	{		
		FONT-FAMILY: Verdana ;		
		FONT-SIZE: 10pt ; 
		FONT-STYLE: NORMAL; 
		COLOR: BLACK; 
	}
	PRE{
		font-size:10pt;			
		font-family: Verdana;			
		BACKGROUND-COLOR: #FFFFFF;
		BORDER-STYLE: none;
		fontWeight : bold;
		text-align: left;
		white-space: normal;
		word-wrap: break-word;			
	}		
</style>
<%
Hashtable htParameter=new Hashtable();
HashMap<String,String> paramMap = null;
StringBuffer sectionContentUpdatedXML=new StringBuffer();
eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

String	section_content		= "";
String	section_content_rpt	= "";
String	section_content_hdr	= "";
String	section_content_ftr	= "";
String  section_content_dtl	= "";
String	note_header_code	= "";
String	footer_code			= "";
String	report_header_code	= "";
String 	disclaimer_code		= "";
String 	disclaimer_text		= "";
String  url1				= "";
String  url					= "";
String 	section_hdg_code	= "";
String	content_type		= "";
String section_hdg_desc		= "";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;
// IN071335 Changes Start.
//url   = HttpUtils.getRequestURL(request).toString();
//url = url.substring(0,url.indexOf("jsp/"));
url					= application.getRealPath("/eCA")+"/";
// IN071335 Changes End.
//url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
//System.out.println("======262============>"+url1);
url1 = url + "html/RecClinicalPrintNoteLayoutView.xsl";
System.out.println("======264============>"+url1);
String sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.DISCLIMER_CODE from ca_note_type a where  a.NOTE_TYPE=?";

try{
	pstmt	= con.prepareStatement(head_foot_qry);
	pstmt.setString(1,note_type);
	rs = pstmt.executeQuery();

	while(rs.next()){
		note_header_code = rs.getString("NOTE_HEADER_CODE")==null?"":rs.getString("NOTE_HEADER_CODE");
		footer_code = rs.getString("FOOTER_CODE")==null?"":rs.getString("FOOTER_CODE");
		report_header_code 	= rs.getString("REPORT_HEADER_CODE")==null?"":rs.getString("REPORT_HEADER_CODE");
		disclaimer_code		= rs.getString("DISCLIMER_CODE")==null?"":rs.getString("DISCLIMER_CODE");
		System.out.println("--------------note_header_code------------->"+note_header_code);
		System.out.println("--------------footer_code------------->"+footer_code);
		System.out.println("--------------report_header_code------------->"+report_header_code);
	}	
	
}catch(Exception ee){
	//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//common-icn-0181
	ee.printStackTrace();
}finally{
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
}
if(!"".equals(disclaimer_code)){
	try{
		pstmt	= con.prepareStatement("SELECT DISCLIMER_TEXT FROM CA_DISCLIMER_TXT_LANG WHERE LANGUAGE_ID =? AND DISCLIMER_CODE=?");
		pstmt.setString(1,locale);
		pstmt.setString(2,disclaimer_code);
		rs = pstmt.executeQuery();

		while(rs.next()){
			disclaimer_text = rs.getString("DISCLIMER_TEXT")==null?"":rs.getString("DISCLIMER_TEXT");			
		}	
		
	}catch(Exception ee){
		//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//common-icn-0181
		ee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
}
//Report Header Start.
	try{
		pstmt	= con.prepareStatement(sect_template_query);	
		pstmt.setString(1,report_header_code);
		rs = pstmt.executeQuery();
		if(rs.next()){
			clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");
			if(clob_notes_content!=null){
				try{
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
				}catch(Exception e){
					//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
		}
	}catch(Exception eee){
		//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

	StringBuffer section_content_new = new StringBuffer(section_content);
	
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}


	}
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}
	if(!(sectionContentUpdatedXML.toString().equals(""))){								
		section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
	}
//Report Header End.
//Note Header Start
	try{
		section_content = "";
		pstmt	= con.prepareStatement(sect_template_query);
		pstmt.setString(1,note_header_code);
		rs = pstmt.executeQuery();

		if(rs.next()){				
			clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");				

			if(clob_notes_content!=null){
				try{					
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
				}catch(Exception e){
					//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
		}
	}catch(Exception eee){
			//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
			eee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();		
	}
	section_content_new = new StringBuffer(section_content);
	sectionContentUpdatedXML = new StringBuffer();
	
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",note_header_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}				
			
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}

	
	if(!(sectionContentUpdatedXML.toString().equals("")))
	{								
			
		section_content_hdr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

	}

//Note Header End.
//Report Footer Start.
	try{
		section_content = "";
		pstmt	= con.prepareStatement(sect_template_query);
		pstmt.setString(1,footer_code);
		rs = pstmt.executeQuery();

		if(rs.next()){				
			clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");				

			if(clob_notes_content!=null){
				try{					
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
				}catch(Exception e){
					//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
		}
	}catch(Exception eee){
			//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
			eee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();		
	}
	section_content_new = new StringBuffer(section_content);
	sectionContentUpdatedXML = new StringBuffer();
	
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",footer_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}				
			
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}

	
	if(!(sectionContentUpdatedXML.toString().equals("")))
	{								
			
		section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

	}
//Report Footer End.

%>
<%
if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("N")))
{
	if("Y".equals(imageLogoHeader)){
		out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
		out.println("<tr><td colspan='2'>");
		out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
		out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' ></td></tr></table>");
		out.println("</td></tr>");
		
		if("Y".equals(textLogoHeader)){
			out.println("<tr>");	
			out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
			out.println("</tr>");
			out.println("<tr>");	
			out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
			out.println("</tr>");
			out.println("<tr>");	
			out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}else{
		out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
		out.println("<tr>");	
		//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>"); commented for IN068669
		out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
		if("Y".equals(textLogoHeader)){	
			out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");//IN037045
			out.println("<tr>");
			//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
			out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");
			out.println("<tr>");
			//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
			out.println("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");
		}else{
			out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
%>
<table border="0" width="100%"> 
	<thead>
	<% if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("Y"))){ %>
		<tr> 
			<th style="width:100%">
				<%
					if("Y".equals(imageLogoHeader)){
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr><td colspan='2'>");
						out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
						out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' ></td></tr></table>");
						out.println("</td></tr>");
						
						if("Y".equals(textLogoHeader)){
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("</tr>");
						}
						out.println("</table>");
					}else{
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr>");	
						//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>"); commented forIN068669 
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
						if("Y".equals(textLogoHeader)){		
							out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");
							//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
							out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");
							//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
							out.println("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
						}else{
							out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
						}
						out.println("</table>");
					}
				%>
			</th>
		</tr>
	<%
	}
	if(rpt_hdr_all_pages.equals("Y"))
	{
	%>	
		<tr> 
			<th style="width:100%">
				<br>
				<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
					<tr>
					<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_rpt%></font></td></tr>
				</table>
				<br>
			</th> 
		</tr>
	<%} %>
	</thead>
	
	<tbody> 
    	<tr> 
     		<td width="100%">
     			<%if(rpt_hdr_all_pages.equals("N")){%>
     				<table border="0" width="100%"> 
						<thead> 
							<tr> 
								<th style="width:100%">
									<br>
									<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
										<tr>
											<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_rpt%></font></td>
										</tr>
									</table>
									<br>
								</th> 
							</tr>
						</thead> 
					</table>
     			<%}%>
				<br>
				<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center style="padding-bottom:1px">
					<tr>
						<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_hdr%></font>	</td>
					</tr>
				</table>
     			<%
     			try{
					//IN057173 Start.
					query_section_details.append("select sec_hdg_code,1 DOC_EXISTS,");
					query_section_details.append("case when ? = 'en' then replace(sec_hdg_desc,'''','') else ");
					query_section_details.append("replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc");
					query_section_details.append(",sec_content_type,sec_result_linked_rec_type,");
					query_section_details.append("NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
					query_section_details.append("CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN ''");
					query_section_details.append("ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') ");
					query_section_details.append("else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') ");
					query_section_details.append("end end child_sec_hdg_desc ");
					query_section_details.append(",child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN");
					query_section_details.append(",IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN");
					query_section_details.append(",nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type");
					query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE ");  
					query_section_details.append("from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num");

					pstmt		=	con.prepareStatement(query_section_details.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,note_type);
					
     				//pstmt =	con.prepareStatement("SELECT CNS.SEC_HDG_CODE,CSH.CONTENT_TYPE,CSH.SEC_HDG_DESC FROM CA_NOTE_SECTION CNS,CA_SECTION_HDG CSH WHERE CNS.SEC_HDG_CODE=CSH.SEC_HDG_CODE AND CNS.NOTE_TYPE=? ORDER BY CNS.NOTE_SEC_SEQ_NUM");
     				//pstmt.setString(1,note_type);
					//End.
     				rs	=	pstmt.executeQuery();
					String tempSectionHDGCode = "";
     				while(rs.next()){
						sectionCount++;
     					section_hdg_code	= rs.getString("SEC_HDG_CODE") == null ? "" : rs.getString("SEC_HDG_CODE");
						//IN057173 Start.
						//content_type		= rs.getString("CONTENT_TYPE") == null ? "" : rs.getString("CONTENT_TYPE");
     					content_type		= rs.getString("SEC_CONTENT_TYPE") == null ? "" : rs.getString("SEC_CONTENT_TYPE");
						//IN057173 End.
						section_hdg_desc	= rs.getString("SEC_HDG_DESC") == null ? "" : rs.getString("SEC_HDG_DESC");
						//IN057173 Start.
						if("S".equals(content_type)){
							if(!tempSectionHDGCode.equals(section_hdg_code)){
								tempSectionHDGCode = section_hdg_code;
								%>	
     								<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
										<tr>
											<td colspan="3" class='ITEMSELECT' ><font style="font-family:Verdana;FONT-SIZE:9pt;font-weight:bold;"><%=section_hdg_desc%></font>	</td>
										</tr>										
									</table>
								<%
							}
							section_hdg_code	= rs.getString("CHILD_SEC_HDG_CODE") == null ? "" : rs.getString("CHILD_SEC_HDG_CODE");
							content_type		= rs.getString("CHILD_SEC_CONTENT_TYPE") == null ? "" : rs.getString("CHILD_SEC_CONTENT_TYPE");
							section_hdg_desc	= rs.getString("CHILD_SEC_HDG_DESC") == null ? "" : rs.getString("CHILD_SEC_HDG_DESC");
						}
						//IN057173 End
     					if("T".equals(content_type)){
     						
     						try{
     							section_content = "";
     							pstmt1	= con.prepareStatement(sect_template_query);
     							pstmt1.setString(1,section_hdg_code);
     							rs1 = pstmt1.executeQuery();

     							if(rs1.next()){				
     								clob_notes_content			=	(java.sql.Clob) rs1.getObject("TEMPLATE_FORMAT");				

     								if(clob_notes_content!=null){
     									try{					
     										content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
     										bf_content_reader	= new java.io.BufferedReader(content_reader);
     										char[] arr_notes_content = new char[(int)clob_notes_content.length()];
     										bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
     										section_content = new String(arr_notes_content);
     										bf_content_reader.close();
     														
     										if(section_content == null)
     											section_content = "";
     									}catch(Exception e){
     										//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
     										e.printStackTrace();
     									}
     								}
     							}
     						}catch(Exception eee){
     								//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
     								eee.printStackTrace();
     						}finally{
     							if(rs1 != null) rs1.close();
     							if(pstmt1 != null) pstmt1.close();
     						}
     						section_content_new = new StringBuffer(section_content);
     						sectionContentUpdatedXML = new StringBuffer();
     						
     						if (! locale.equals("en") )
     						{
     							if(!section_content_new.toString().equals(""))
     							{
     								paramMap = new HashMap<String,String>();
     								paramMap.put("CURR_SEC_HDG_CODE",section_hdg_code);
     								paramMap.put("LOCALE",locale);						
     								paramMap.put("RANGE_PASER_YN","N");
     								eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
     								section_content_new = tempLangParse.getLangReplacedXML();
     								tempLangParse = null;
     							}
     						}				
     								
     						if(!section_content_new.toString().equals(""))
     						{
     							sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
     						}

     						
     						if(!(sectionContentUpdatedXML.toString().equals("")))
     						{								
     							converter=new webbeans.eCA.XMLtoHTML();							
     							section_content_dtl=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
     							%>	
     								<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
										<tr>
											<td colspan="3" class='ITEMSELECT' ><font style="font-family:Verdana;FONT-SIZE:9pt;font-weight:bold;"><%=section_hdg_desc%></font>	</td>
										</tr>
										<tr>
											<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_dtl%></font>	</td>
										</tr>
									</table>
								<%
     						}
     					}else if("F".equals(content_type)){
							%>	
								<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
									<tr>
										<td colspan="3" class='ITEMSELECT' ><font style="font-family:Verdana;FONT-SIZE:9pt;font-weight:bold;"><%=section_hdg_desc%></font>	</td>
									</tr>
									<tr>
										<td colspan="3" >&nbsp;<br><br><br><br><br><br><br><br></td>
									</tr>
								</table>
							<%
						
						}
     				}
     				if(rs!=null)	rs.close();
     				if(pstmt!=null)	pstmt.close();
					pstmt	=	con.prepareStatement("SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM ");
					rs		=	pstmt.executeQuery();
					if(rs.next()){
						note_print_time_interval			= Integer.parseInt(rs.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)rs.getString("NOTE_PRINT_TIME_INTERVAL"));
					}
					if(rs!=null)	rs.close();
					if(pstmt!=null)	pstmt.close();
     			}catch(Exception e){
     					//out.println("Exception@111 - in getting logo and report header: "+e);//COMMON-ICN-0181
     					e.printStackTrace();//COMMON-ICN-0181
     			}
				finally
				{
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
				if(sectionCount==0){
     			%>
				<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
					<tr>
						<td colspan="3" >&nbsp;<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></td>
					</tr>
				</table>
				<%}%>
     			<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
					<tr>
						<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_ftr%></font>	</td>
					</tr>
				</table>
				<%if(!"".equals(disclaimer_text)){%>
					<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
					<tr>
						<td colspan="3" ><font style ="font-family:Verdana"><%=disclaimer_text%></font>	</td>
					</tr>
				</table>
				<%}%>
     		</td>
     	</tr>
     </tbody>
</table>
<script>
				function Print() 
				{
					//alert("Print 869");
					if (document) {
						var i = 0;
						var confMess ="Continue printing ?";
						if(<%=sectionCount%>==0)
							confMess ="Sections are not linked, Continue printing ?";
						var res = confirm(confMess);
						if(res)  
						{
							while( i < document.applets.length ) 
							{
								var j = 0 ;
								while ( !document.applets[i].isActive() && j++ <=75000 ) 
									window.status = i;
								i++;
							}
							window.print();							
							setTimeout(function() {
							//alert("Print inside if while loop 888");								
							//window.close(); 
							const dialogTag = parent.document.getElementById("dialog_tag");    
							dialogTag.close();  
							}, <%=note_print_time_interval%>);	
						}else{
							//window.close();
							//alert("Print  inside else 895");
							const dialogTag = parent.document.getElementById("dialog_tag");    
							dialogTag.close();
						}
					}
				}
			</script>
</form>
</body>
</html>

<%!
	public String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
	}
%>


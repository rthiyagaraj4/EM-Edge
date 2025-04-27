<% 
/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
19/10/2011    IN029296      Chowminya G     Incident No: IN029296 - <Field patient name in Report Header doesn?t display thai name> 
21/03/2012	  IN031910		Menaka V		In Unauthorized Note the Logo and Report Header is Printed only in First Page of the Note.
05/04/2012	  IN031966		Ramesh G		CA Record Clinical note>Enter details>Print Preview>Continue Printing>OK>The Header and footer spacing is not printed.
10/05/2012	  IN032683	 	Ramesh G	 	Alignment is not retained after recording the addendum.
15/05/2012	  IN032721		Ramesh G		When we Click on Print Preview the Date is not displayed in the examination date component.
26/07/2012	  IN033869		Dinesh T		Print preview is not showing the contents properly, it was showing the data in the 											wrong order
19/09/2012		IN033677		Dinesh T		CRF-Recording and signing the addendum with new free text editor 
22/02/2013	    IN036821	Chowminya G		Reporting Practitioner name not coming in the CA report
25/02/2013		IN037045	Chowminya G		CA Report logo/header alignment
02/05/2013    IN039396		Nijitha S		Alpha-CA-Record Clinical Notes->System is displaying the Special Character in the 'Note Header'       
06/05/2013	    IN039562	Chowminya G	    Age format Changed to Y-M-D	
15/05/2013    	IN038439	NijithaS		Bru-HIMS-CRF-351 
21/05/2013      IN040090    Chowminya G	    Linked Issue: New format age components in local language	
28/05/2013      IN040205    Chowminya G	    Deceased patinet age issue	
03/06/2013		IN040265		Ramesh G		Issue 1: At print preview the addendum details displayed as "Addendum Created by"  instead of "Addendum Recorded by"
												Issue 2: Addendum details  displayed twice.
03/06/2013		IN040266		Ramesh G		Issue 1: Record Clinical Notes->Search Tab->Update->System is displaying the updated text in different font in Print Preview and Print.
												Issue 2: Chart Summary->Lab Results->Note Type text data is displayed in different font.
												Issue 3: OT Surgeon Notes->System is displaying the text in different font in Print Preview and Print.
19/08/2013		IN041827	Akbar			ML-BRU-SCF-0949												
17/10/2013      IN042733    NijithaS		MO-GN-5430												
18/11/2013		IN040981	Vijayakumar 	Alignment is not correct while recording multiple addendums at Print Preview
16/12/2013		IN045646	Chowminya		Speciality name in report header has to be long name
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
02/04/2014	IN048271		Ramesh G		02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format								
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
03/09/2014  IN050584		NijithaS										MO-GN-5454-CA-SL3  
16/03/2015  IN054024		Ramesh G										There is an issue for 1 patient where the Report Header Contents as well as the Note Header 
																			Contents do not display on preview print as well as in the Print out.
05/05/2015	IN053298		Ramesh G	05/05/2015		Akbar S			When we attach an image to the clinical note part of the image is not displayed.
12/05/2015	IN053733		Ramesh G										Bru-HIMS-CRF-024.3
02/05/2016	IN059489		Raja S											Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143
22/08/2018	IN066793		Sharanraj		22/08/2018	Ramesh G		ARYU-SCF-0064
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
04/01/2019      IN067016                Ramya Maddena   	04/01/2019      Ramesh G    	        AMRI-CRF-0370
04/03/2019      IN066807                Ramya Maddena   	04/03/2019      Ramesh G		AMRI-CRF-0340
04/05/2019	IN069484		Ramesh G										AMRI-CRF-0398
10/06/2019     IN070668              sivabagyam	          10/06/2019          Ramesh G		SKR-SCF-1215
28/06/2019  IN066005        Ramya Maddena   01/07/2019  Ramesh G        ML-BRU-CRF-0474 
06/09/2019	IN071335	   	Ramesh G											Common-ICN-0012 
14/10/2019	IN071513		Ramesh G		14/10/2019	Ramesh G		ML-BRU-CRF-0585.1 
21/10/2019	IN071569		Ramesh G									ML-MMOH-SCF-1389
16/12/2019	IN071998 		Nijitha			16/12/2019	Ramesh G		CA-Leap Year-Record Clinical Notes-Preview
05/05/2020	IN071865		SIVABAGYAM M	05/05/2020	RAMESH G		ML-MMOH-CRF-1484
22/06/2020	IN073100		SIVABAGYAM M		22/06/2020		RAMESH G		ML-MMOH-SCF-1541
18/11/2020	7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.Date,java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8"%><!-- IN042733 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	/*IN066793 starts*/
	boolean sitespecific=false;
	String font="";
	Connection conn=null;
	try
	{
		conn	= ConnectionManager.getConnection(request);
		sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
		if(sitespecific)
			font="Segoe UI";
		else
			font="Verdana";
	}
	catch(Exception e)
	{
		out.println("Exception@111 - in getting header_appl_yn : "+e);
		
	}
	finally
	{
		if(conn!=null)	ConnectionManager.returnConnection(conn,request);
	}
	
	
	/*IN066793 ends*/
%>
<html>
<head>
<!-- IN031910 Starts -->
<style type="text/css" media="print">   
	th {
		font-family:Arial;
		color:black;
		//back ground-color:lightgrey; //Commented for IN059489
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
<!-- IN031910 Ends -->
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<title><fmt:message key="eCA.NotesPrintPreviewView.label" bundle="${ca_labels}"/></title>
	
	<!-- IN066793 Starts -->
	<%if(sitespecific)
	{	
	%>
	<style>
			ADDRESS	{ FONT-FAMILY: Segoe UI ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
		PRE
		{
			font-size:10pt;			
			font-family: Segoe UI;
			//BACKGROUND-COLOR: #E2E3F0;
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}
		/* IN054024 End. */
	</style>
	<%
	}
	else
	{	
	%>
		<style>
			ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
		PRE
		{
			font-size:10pt;			
			font-family: Verdana;
			//BACKGROUND-COLOR: #E2E3F0;
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}
		/* IN054024 End. */
	</style>
	<%
	}
	%>
	<!-- IN066793 Ends -->
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script>

var temp_foot ="";
var temp_hdr = "";

function SysPreview()
{
	var OLECMDID = 7;
	var PROMPT =2;
	
	try
	{
		var oWebBrowser = document.getElementById("WebBrowser1");

		if(oWebBrowser == null)
		{
			var sWebBrowser = '<OBJECT ID = "WebBrowser1" width = 0 height =0 CLASSID ="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"> </OBJECT>';

			document.body.insertAdjacentHTML('beforeend',sWebBrowser);

			oWebBrowser = document.getElementById("WebBrowser1");
		}
		
		oWebBrowser.ExecWB(OLECMDID,PROMPT,null,null);
	}
	catch (e)
	{
		alert("Failed");
	}
}
	function setHeader()
	{
		t = new ActiveXObject("WScript.Shell"); 
						
		temp_hdr=t.RegRead("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header");
		temp_foot=t.RegRead("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer");
						 
		var pat_info1="Preliminary Report";
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header",pat_info1+" &bPage &p of &P" ); 
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer",  pat_info1+"&b&d");
	}

	function theEnd()
	{
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header"," &bPage &p of &P" ); 
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer",  "&u&b&d");
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_top", "0.75");//[IN031966]
		t.RegWrite("HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_bottom", "0.5");//[IN031966]
		window.close();
	}

</script>
</head>
<!-- <body  onLoad = "setHeader();PrevPreview()" onUnload = "theEnd()" onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body  onLoad = "PrevPreview()" onUnload = "" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name = "RecClinicalNotesSectionViewForm">
<center>

<%

	java.sql.Connection			con			=	null;
	java.sql.PreparedStatement	pstmt		=	null;
	java.sql.PreparedStatement	pstmt1		=	null;
	java.sql.PreparedStatement	pstmt2		=	null;
	java.sql.PreparedStatement	pstPatInfo	=	null;
	java.sql.ResultSet			rsPatInfo	=	null;
	java.sql.ResultSet			rs			=	null;
	java.sql.ResultSet			rs1			=	null;
	java.sql.ResultSet			rs2			=	null;
	

	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();

	Hashtable htParameter=new Hashtable();

	String	note_type				=	"",	query_section_details	=	"";
	String	sec_hdg_desc			=	"",	child_sec_hdg_desc		=	"";
	String	sec_content_type		=	"",	section_content			=	"";
	String	editor_title			=	"", child_sec_content_type  =   "";
	String  image_linked_yn			=	"",	section_image_content	=	"";
	String  section_image_height	=	"400";  //IN053298
	String  preserve_format_yn		=	"", StrDataAvlFlag			=	"";
	String	sec_hdg_code			=	"",	child_sec_hdg_code		=	"";
	String	printDateTime			=	"", attending_practitioner	=	"",admitting_practitioner= "";
	String attending_practitioner_list = "";//IN066807
	String  dischargeDateTime		=	"", site_name				=	"";
	String  discharge_date_only     =   "";//IN067016
	String  speciality_name			=	"", facility_name			=	"";
	String  strNodesHeaderText		=	"", strDisClaimerText		=	"";
	String  patient_id				=	"", patient_name			=	"";
	String  patient_gender			=	"", patient_age				=	"";
	String	episode_type			=	"",	encounter_id			=	"";
	String  visit_adm_date			=	"",	location_name			=	"";
	
	String  strNoteTypeDesc			=	"", strEventTitleCaption	=	"";
	String  strEventDateTimeCaption	=	"", strEventPerfByCaption	=	"";
	String  strAuthoByCaption		=	"", strPerfPhyName			=	"";
	String  strEventDateTime		=	"", strMedService			=	"";
	String  login_user_id			=	"", strAuthoBy				=	"";
	String  strModifyBy				=	"", strAddendumFlag			=	"N";	
	String  strAddendumText			=	"", strPrevSecHdgCode		=	"";
	String  addendumTxt				=	"",	strPatInfoQuery			=	"";
	String	strPatEncDtlQry			=	"",	clinician_name			=	"";
	String  facility_id				=	"", sys_date_time			=	"";
	String  accession_num			=	"",	url						=	"";
	String  url1					=	"", strEventTitleDesc		=	"";
	String  patient_class			=	"",	strQuery				=	"";
	String  strAuthId				=	"",	strKey					=	"";

	String note_header_code			=	"";
	String footer_code				=	"";
	String report_header_code		=	"";
	String section_content_rpt		=	"";
	String doc_ref_id		=	"";
	String authorized_by		=	"";
	String  authorized_sign			=   "N"; //IN069484
	String last_amended_by		=	"";
	String url2 =  "";
	String sec_hdg_code_out =  "";
	String child_sec_hdg_code_out =  "";
	String output_yn =  "";
	String print_logo_header_yn = "";
	String pract_sign = "";
	String clinician_id = "";
	String contr_mod_accession_num = ""; //[IN032721]
	String contr_oth_accession_num = ""; //IN053733
	String cal_eventdate = "";//IN040090
	//IN040205 - Start
	String deceased_yn = "";
	String deceased_date = "";
	//IN040205 - end
	StringBuffer section_content_new=new StringBuffer();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	//IN031910 Starts
	String logo_hdr_all_pages = "";
	String rpt_hdr_all_pages = "";
	//IN031910 Ends
	String header_top = ""; //[IN031966]
	String footer_bottom = ""; //[IN031966]
	String hdr_ft_yn = "";//[IN031966]
	//[IN032210] Start
	String imageLogoHeader ="N";
	String textLogoHeader ="N";
	String waterMarkFlag = "N"; //IN059489
	String noteCopiedYN = "";//IN068105
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40";//IN068669
	String logo_Site_Facility ="S";//IN066005
	String prev_note_type_desc="";//IN073100
	String display_note_description="";//7605
	//[IN032210] End
	//StringBuffer sbResult			   = new StringBuffer();
	//--[IN029296] - Start
	if(locale.equals("en")){
	strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth,decode(deceased_yn,'Y',deceased_date,sysdate)) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_patient where patient_id = ? "; 
	}
	else
	{
	strPatInfoQuery = "select PATIENT_NAME_LOC_LANG patient_name,get_age(date_of_birth,decode(deceased_yn,'Y',deceased_date,sysdate)) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_patient where patient_id = ? "; 
	}
	//--[IN029296] - End
	//IN031910 Starts
	try
	{	
		con	= ConnectionManager.getConnection(request);
		//pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN FROM ca_note_param ");//IN068669
		pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT,DISP_NOTE_DESC FROM ca_note_param ");//IN068669//7605
		rs	=	pstmt.executeQuery();
		if(rs.next())
		{
			logo_hdr_all_pages	= rs.getString("LOGO_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("LOGO_HDR_ALL_PAGE_YN");
			rpt_hdr_all_pages	= rs.getString("RPT_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("RPT_HDR_ALL_PAGE_YN");
			LOGO_HDR_WIDTH	= rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH");//IN068669
			LOGO_HDR_HEIGHT	= rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT");//IN068669
			display_note_description= rs.getString("DISP_NOTE_DESC") == null ? "" : rs.getString("DISP_NOTE_DESC");//IN068669//7605
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
    }
	catch(Exception e)
	{
		out.println("Exception@111 - in getting logo and report header: "+e);
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);	
	}
	//Dinesh T added to eradicate the unclosed connection exception in the err log
	//IN031910 Ends
	try
	{
		login_user_id			= (String)session.getValue("login_user");
		clinician_name			= (String)session.getValue("practitioner_name");
		clinician_id			= (String)session.getValue("ca_practitioner_id");
		facility_id				= (String)session.getValue("facility_id");

		patient_id				= checkForNull((String)request.getParameter("patient_id"),"&nbsp;");
		episode_type			= checkForNull((String)request.getParameter("episode_type"),"&nbsp;");
		encounter_id			= checkForNull((String)request.getParameter("encounter_id"),"");
		//accession_num			= checkForNull((String)request.getParameter("accession_num"),"&nbsp;");//IN038439
		accession_num			= checkForNull((String)request.getParameter("accession_num"),"");//IN038439
		patient_class			= checkForNull((String)request.getParameter("patient_class"),"&nbsp;");
		note_type				= checkForNull((String)request.getParameter("note_type"),"&nbsp;");
		strMedService			= checkForNull((String)request.getParameter("med_service"),"");
		//strEventTitleDesc		= checkForNull((String)request.getParameter("note_title"),"&nbsp;");//IN039396	
		strEventTitleDesc		= checkForNull((String)request.getParameter("note_title"),"");//IN039396
		//strEventDateTime		= checkForNull((String)request.getParameter("event_date_time"),"&nbsp;");//IN039396	
		strEventDateTime		= checkForNull((String)request.getParameter("event_date_time"),"");//IN039396
		strPerfPhyName			= checkForNull((String)request.getParameter("performed_by_name"),"&nbsp;");
		contr_mod_accession_num = checkForNull((String)request.getParameter("contr_mod_accession_num"),"");   //[IN032721]
		contr_oth_accession_num = checkForNull((String)request.getParameter("contr_oth_accession_num"),"");   //[IN053733]
		noteCopiedYN			= checkForNull((String)request.getParameter("noteCopiedYN"),"N"); //IN068105
//[IN031966] Start		
		try
		{
			con	= ConnectionManager.getConnection(request);			
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
				if(rs.next())
				{
					header_top	= rs.getString("HDR_MARGIN_IN_INCH") == null ? "" : rs.getString("HDR_MARGIN_IN_INCH");
					footer_bottom = rs.getString("FT_MARGIN_IN_INCH") == null ? "" : rs.getString("FT_MARGIN_IN_INCH");
				}
			} //[IN031116]
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();

	    }
	    catch(Exception e)
		{
			out.println("Exception@111 - in getting header_appl_yn : "+e);
			
		}
		finally
		{
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
		//Dinesh T added to eradicate the unclosed connection exception in the err log
%>

	<script Language="vbscript">
    Dim WSHShell    

    Set WSHShell = CreateObject("WScript.Shell") 
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
	//[IN031116] Starts
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
	//[IN031116] Ends
	%>
</script>
<%
//[IN031966] End		
		
				
		if(encounter_id == null || encounter_id.equals("") )
		{
			encounter_id = "0";
			patient_class = "XT";
		}
		
		editor_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels");
		// IN071335 Changes Start.
		//url   = HttpUtils.getRequestURL(request).toString();
		//url = url.substring(0,url.indexOf("jsp/"));
		url					= application.getRealPath("/eCA")+"/";
		// IN071335 Changes End. 
		/*IN066793 starts*/
		if(sitespecific)
			url1 = url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
		else
			url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
		/*IN066793 ends*/
		url2 =url+"html/RecClinicalNotesOutputFormDisplay.xsl";
		/*IN066793 starts*/
		if(sitespecific)
			url =url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
		else
			url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
		/*IN066793 ends*/
		
		con				=	ConnectionManager.getConnection(request);

		// Getting the Site Name
		try
		{
			//strQuery = "SELECT site_name FROM SM_SITE_PARAM";
			strQuery = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
			pstPatInfo	= con.prepareStatement(strQuery);
			pstPatInfo.setString(1, locale);
			rsPatInfo = pstPatInfo.executeQuery();

			if(rsPatInfo != null && rsPatInfo.next())
				site_name = rsPatInfo.getString(1);
			else
				site_name = "";
		}
		catch (Exception ePP1)
		{
			out.println("Exception@147: "+ePP1);
			ePP1.printStackTrace();
		}
		finally
		{
			if(rsPatInfo != null) rsPatInfo.close();
			if(pstPatInfo != null) pstPatInfo.close();
		}


		// Getting the Patient Info

		patient_name	= "";
		patient_age		= "";
		patient_gender	= "";
		visit_adm_date	= "";

	//	if(!patient_class.equals("XT") ) //IN040205 - Commentted
	//	{//IN040205
			try
			{
				pstPatInfo	= con.prepareStatement(strPatInfoQuery);
				pstPatInfo.setString(1,patient_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next() )
				{
					patient_name	= rsPatInfo.getString("patient_name") == null ? "" : rsPatInfo.getString("patient_name");
					patient_age		= rsPatInfo.getString("patient_age") == null ? "" : rsPatInfo.getString("patient_age");
					patient_gender	= rsPatInfo.getString("gender") == null ? "" : rsPatInfo.getString("gender");
					printDateTime	= rsPatInfo.getString("print_date_time") == null ? "" : rsPatInfo.getString("print_date_time");

					if(patient_gender.equals("M") )
						patient_gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(patient_gender.equals("F") )
						patient_gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						patient_gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					
				}	
			}
			catch (Exception ePP6)
			{

				ePP6.printStackTrace();
			}
			finally
			{
				if(rsPatInfo != null) rsPatInfo.close();
				if(pstPatInfo != null) pstPatInfo.close();
			}

		if(!patient_class.equals("XT") ) //Added here - IN040205
		{//IN040205
			try
			{
				//strPatEncDtlQry	=" Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN (SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=A.FACILITY_ID AND NURSING_UNIT_CODE=A.ASSIGN_CARE_LOCN_CODE ) ELSE (SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=A.FACILITY_ID AND CLINIC_CODE=A.ASSIGN_CARE_LOCN_CODE) END LOCN_DESC,(select short_desc from am_service where service_code=a. SERVICE_CODE )  specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ATTEND_PRACTITIONER_ID) attending_practitioner,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME  FROM PR_ENCOUNTER A WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ? ";
				//strPatEncDtlQry	=" Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END LOCN_DESC,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1')    specialty_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME  FROM	PR_ENCOUNTER A 	WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?";//commented for IN067016
				//strPatEncDtlQry	=" Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END LOCN_DESC,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1')    specialty_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1 FROM	PR_ENCOUNTER A 	WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?";
				//IN045646 get_desc for specialty_name changed from 2 to 1//IN067016//commented for IN066807
				strPatEncDtlQry	=" Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END LOCN_DESC,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1')    specialty_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1 FROM	PR_ENCOUNTER A 	WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?";//IN066807
				
				pstPatInfo	= con.prepareStatement(strPatEncDtlQry);
				
				pstPatInfo.setString(1,locale);
				pstPatInfo.setString(2,locale);
				pstPatInfo.setString(3,locale);
				pstPatInfo.setString(4,locale);
				pstPatInfo.setString(5,facility_id);
				pstPatInfo.setString(6,encounter_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next() )
				{
					visit_adm_date			= checkForNull(rsPatInfo.getString("ENC_DATE"),"");
					episode_type			= checkForNull(rsPatInfo.getString("patient_class"),"");
					location_name			= checkForNull(rsPatInfo.getString("LOCN_DESC"),"");
					attending_practitioner	= checkForNull(rsPatInfo.getString("attending_practitioner"),"");
					//---[IN:029839]---start
					admitting_practitioner  = checkForNull(rsPatInfo.getString("admitting_practitioner"),"");
					//---[IN:029839]---end
					speciality_name			= checkForNull(rsPatInfo.getString("specialty_name"),"");
					dischargeDateTime		= checkForNull(rsPatInfo.getString("DISCHARGE_DATE_TIME"),"");
					discharge_date_only		= checkForNull(rsPatInfo.getString("DISCHARGE_DATE_TIME_1"),"");//IN067016
					attending_practitioner_list	=checkForNull(rsPatInfo.getString("attending_pract_list"),"");//IN066807
				}
			
				if(location_name == null)
					location_name ="";
			}
			catch (Exception ePPA)
			{
				out.println("Exception@12: "+ePPA);
				ePPA.printStackTrace();
			}
			finally
			{
				if(rsPatInfo != null) rsPatInfo.close();
				if(pstPatInfo != null) pstPatInfo.close();
			}
		}
//		else
//		{
			// Getting the Facility Name 
			try
			{
				//strQuery = "SELECT FACILITY_NAME,to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from sm_facility_param where facility_id = ?";
				strQuery = "SELECT 	SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name,to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT    a.practitioner_name || CHR (13)|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || b.position_desc  || NVL2 ( b.position_desc, CHR (13), '' )|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)  || credential_id1  || NVL2 (credential_id1, ', ', '') || credential_id2 || NVL2 (credential_id2, ', ', '')|| credential_id3 || NVL2 (   credential_id1|| credential_id2|| credential_id3,CHR (13),'')|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || DEGREE pract_with_pos_cred_deg FROM am_practitioner a, am_position b WHERE a.position_code = b.position_code AND a.practitioner_id = ? ) pract_sign 	from dual";
				pstPatInfo	= con.prepareStatement(strQuery);
				pstPatInfo.setString(1,facility_id);
				pstPatInfo.setString(2,locale);
				pstPatInfo.setString(3,clinician_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next())
				{
					facility_name	=	rsPatInfo.getString("facility_name") == null ? "" : rsPatInfo.getString("facility_name");
					printDateTime	=	rsPatInfo.getString("print_date_time") == null ? "" : rsPatInfo.getString("print_date_time");
					pract_sign		=	rsPatInfo.getString("pract_sign") == null ? "" : rsPatInfo.getString("pract_sign");
				}
				else
				{
					facility_name = "";
					printDateTime =	"";
				}


			}
			catch (Exception ePP2)
			{
				out.println("Exception@147: "+ePP2);
				ePP2.printStackTrace();
			}
			finally
			{
				if(rsPatInfo != null) rsPatInfo.close();
				if(pstPatInfo != null) pstPatInfo.close();
			}
//		}
		//if(!accession_num.equals("&nbsp;"))//IN071865
		if(!accession_num.equals("") && !accession_num.equals("&nbsp;") )//IN071865
		{
			
			try
			{
				//strQuery = "select event_type_caption, note_type, note_type_desc, service_code, short_desc service_desc,  event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, short_name performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption,authorized_by_id from ca_encntr_note_vw where facility_id = ? and accession_num = ? ";
				strQuery = "select a.event_type_caption, a.note_type, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc, a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') service_desc,a.event_date_caption,to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, a.event_perf_by_caption, a.performed_by_id, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,1) performed_by_name, a.event_title_caption, a.event_title_desc, a.event_auth_by_caption,a.authorized_by_id,a.MODIFIED_BY_ID from ca_encntr_note a where facility_id = ? and accession_num = ?";
				pstPatInfo	= con.prepareStatement(strQuery);
				pstPatInfo.setString(1,locale);
				pstPatInfo.setString(2,locale);
				pstPatInfo.setString(3,locale);
				pstPatInfo.setString(4,facility_id);
				pstPatInfo.setString(5,accession_num);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next())
				{
					strNoteTypeDesc			=	checkForNull(rsPatInfo.getString("note_type_desc"),"");
					strEventTitleCaption	=	checkForNull(rsPatInfo.getString("event_title_caption"),"");
					strEventTitleDesc		=	checkForNull(rsPatInfo.getString("event_title_desc"),"");
					strEventDateTimeCaption	=	checkForNull(rsPatInfo.getString("event_date_caption"),"");
					strEventDateTime		=	checkForNull(rsPatInfo.getString("event_date_time"),"");
					strEventPerfByCaption	=	checkForNull(rsPatInfo.getString("event_perf_by_caption"),"");
					strPerfPhyName			=	checkForNull(rsPatInfo.getString("performed_by_name"),"");
					strMedService			=	checkForNull(rsPatInfo.getString("service_desc"),"");
					strAuthoByCaption		=	checkForNull(rsPatInfo.getString("event_auth_by_caption"),"");
					strAuthId				=	checkForNull(rsPatInfo.getString("authorized_by_id"),"");
					strModifyBy				=	checkForNull(rsPatInfo.getString("MODIFIED_BY_ID"),"");
					
					if(!strEventDateTime.equals(""))
					{
						cal_eventdate 						=   com.ehis.util.DateUtils.convertDate(strEventDateTime,"DMYHM","en","en");//IN040090
						strEventDateTime					=	com.ehis.util.DateUtils.convertDate(strEventDateTime,"DMYHM","en",locale);
					}

				}
			}
			catch (Exception ePP4)
			{
				out.println("Exception@147: "+ePP4);
				ePP4.printStackTrace();
			}
			finally
			{
				if(rsPatInfo != null) rsPatInfo.close();
				if(pstPatInfo != null) pstPatInfo.close();
			}
			
			if(strAuthId != null && !strAuthId.equals("") )
			{
				try
				{
					//strQuery = "select short_name from am_practitioner where PRACTITIONER_ID = ?";
					strQuery = "select AM_GET_DESC.AM_PRACTITIONER(?,?,1) short_name from dual";
					pstPatInfo	= con.prepareStatement(strQuery);
					pstPatInfo.setString(1,strAuthId);
					pstPatInfo.setString(2,locale);

					rsPatInfo = pstPatInfo.executeQuery();

					if(rsPatInfo.next())
						strAuthoBy				=	checkForNull(rsPatInfo.getString("short_name"),"");
				}
				catch (Exception ePP4)
				{
					out.println("Exception@147a: "+ePP4);
					ePP4.printStackTrace();
				}
				finally
				{
					if(rsPatInfo != null) rsPatInfo.close();
					if(pstPatInfo != null) pstPatInfo.close();
				}
				//IN069484 Start.
				try{
					pstmt2	= con.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
					pstmt2.setString(1,strAuthId);
					rs2 = pstmt2.executeQuery();
					while(rs2 !=null && rs2.next()){						
						java.sql.Blob img_blob  =  (java.sql.Blob)rs2.getBlob("PRACTITIONER_SIGN");
						byte[] bytes = img_blob.getBytes(1, (int)img_blob.length()); 						
						authorized_sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
						
					}
				}catch(Exception se){
					se.printStackTrace();
				}finally
				{
					if(rs2 != null) rs2.close();
					if(pstmt2 != null) pstmt2.close();
				}
				//IN069484 End.
			}
		}
		else
		{
			try
			{
					
				//strQuery = "select note_type_desc, event_date_caption, event_perf_by_caption, event_title_caption,event_auth_by_caption from ca_note_type  where note_type = ?";
				strQuery = "select note_type_desc, event_date_caption, event_perf_by_caption, event_title_caption,event_auth_by_caption from ca_note_type_lang_vw  where note_type = ? and language_id = ? ";
				pstPatInfo	= con.prepareStatement(strQuery);
				pstPatInfo.setString(1,note_type);
				pstPatInfo.setString(2,locale);
				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next())
				{
					strNoteTypeDesc			=	checkForNull(rsPatInfo.getString("note_type_desc"),"");
					strEventTitleCaption	=	checkForNull(rsPatInfo.getString("event_title_caption"),"");
					strEventDateTimeCaption	=	checkForNull(rsPatInfo.getString("event_date_caption"),"");
					strEventPerfByCaption	=	checkForNull(rsPatInfo.getString("event_perf_by_caption"),"");
					strAuthoByCaption		=	checkForNull(rsPatInfo.getString("event_auth_by_caption"),"");
				}
			}
			catch (Exception ePP5)
			{
				out.println("Exception@147: "+ePP5);
				ePP5.printStackTrace();
			}
			finally
			{
				if(rsPatInfo != null) rsPatInfo.close();
				if(pstPatInfo != null) pstPatInfo.close();
			}
		}
		
		if(strNoteTypeDesc.equals(""))			strNoteTypeDesc				=	"";
		if(strEventTitleCaption.equals(""))		strEventTitleCaption		=	"Note Title";
		if(strEventDateTimeCaption.equals(""))	strEventDateTimeCaption		=	"Date/Time";
		if(strEventPerfByCaption.equals(""))	strEventPerfByCaption		=	"Performed By";
		if(strAuthoByCaption.equals(""))		strAuthoByCaption			=	"Authorized By";

		try
		{
			//strQuery = "select ib.REPORT_HEADER note_header_desc,ic.disclimer_text footer_text from ca_note_group ib, ca_note_type ia,ca_disclimer_text ic where ib.note_group=ia.note_group_id and ia.disclimer_code = ic.disclimer_code(+) and ia.note_type = ?";
			strQuery = "select 	ib.REPORT_HEADER note_header_desc,ic.disclimer_text footer_text, ia.PRINT_LOGO_HEADER_YN from ca_note_group_lang_vw ib, ca_note_type_lang_Vw ia,ca_disclimer_text_lang_Vw ic where 	ib.note_group=ia.note_group_id and 	ia.disclimer_code = ic.disclimer_code(+) and ia.note_type = ? and	ia.language_id = ? and ic.language_id(+) = ? and ib.LANGUAGE_ID= ? ";
			pstPatInfo	= con.prepareStatement(strQuery);
			pstPatInfo.setString(1,note_type);
			pstPatInfo.setString(2,locale);
			pstPatInfo.setString(3,locale);
			pstPatInfo.setString(4,locale);

			rsPatInfo = pstPatInfo.executeQuery();

			if(rsPatInfo.next())
			{
				strNodesHeaderText		= rsPatInfo.getString("note_header_desc");
				strDisClaimerText		= rsPatInfo.getString("footer_text");
				print_logo_header_yn	= rsPatInfo.getString("PRINT_LOGO_HEADER_YN");

				if(strDisClaimerText == null)
					strDisClaimerText = "";

				if(strNodesHeaderText == null)
					strNodesHeaderText = "";
			}
		}
		catch (Exception ePP8)
		{
			out.println("Exception@147: "+ePP8);
			ePP8.printStackTrace();
		}
		finally
		{
			if(rsPatInfo != null) rsPatInfo.close();
			if(pstPatInfo != null) pstPatInfo.close();
		}

		//new doc_ref

		if(!accession_num.equals(""))
			{
					try
					{
						String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,1) AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,1)  LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

						pstmt2	= con.prepareStatement(athorise_by_qry);
						pstmt2.setString(1,locale);
						pstmt2.setString(2,locale);
						pstmt2.setString(3,locale);
						pstmt2.setString(4,locale);
						pstmt2.setString(5,accession_num);
						pstmt2.setString(6,patient_id);
						rs2 = pstmt2.executeQuery();
						
						while(rs2.next())
						{
							authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
							last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
							doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
							//performing_phy_name		=	checkForNull( rs2.getString("performed_by_name") );
							//med_service		=	checkForNull( rs2.getString("service_name") );
							
						}
						
					}
					catch (Exception roro )

					{
						out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());
						roro.printStackTrace();

					}
					finally 
					{
					  if(rs2 != null) rs2.close();
					  if(pstmt2 != null) pstmt2.close();
					}
            }




		//new Doc_ref

		//IN040205 - Start
		
		try{
				//Date newDeceasedDt = null;//IN042733
				//Date new_event_date_time = null;//IN042733		
				pstmt2	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");
				pstmt2.setString(1,patient_id);
				rs2 = pstmt2.executeQuery();

				while(rs2.next())
				{
					deceased_yn			= rs2.getString("deceased_yn") == null ? "" : rs2.getString("deceased_yn");
					deceased_date		= rs2.getString("deceased_date") == null ? "" : rs2.getString("deceased_date");
					deceased_date = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
					//IN042733 Starts //IN050584 Starts
					/*if(!"".equals(deceased_date))
					{
						newDeceasedDt = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(deceased_date);
					}
					if(!"".equals(cal_eventdate))
					{
						new_event_date_time = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(cal_eventdate);
					}
					
					if(("Y".equals(deceased_yn) && null!=new_event_date_time && null!=newDeceasedDt && new_event_date_time.after(newDeceasedDt) )|| ("Y".equals(deceased_yn) && null==new_event_date_time && null!=newDeceasedDt ) )
					{
						cal_eventdate = deceased_date;
					}*/
					//IN042733 Ends
				}
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();

				String eventdate_isAfter_decdate = "";
				//IN071998 Starts
				String newstrEventDateTime ;
				if(!"en".equals(locale)){
					newstrEventDateTime = com.ehis.util.DateUtils.convertDate(strEventDateTime,"DMYHM",locale,"en");
				}else
				{
					newstrEventDateTime = strEventDateTime;
				}
				//IN071998 Ends
				pstmt2	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL");
				//pstmt2.setString(1,strEventDateTime);//IN071998
				pstmt2.setString(1,newstrEventDateTime);//IN071998
				pstmt2.setString(2,deceased_date);
				
				
				
				
				rs2 = pstmt2.executeQuery();
				
				while(rs2.next())
				{
					eventdate_isAfter_decdate = rs2.getString("eventdate_isAfter_decdate");
				}
				
				if("Y".equals(eventdate_isAfter_decdate))
				{
					cal_eventdate = deceased_date;
				}
				//IN050584 Ends
		}
		catch(Exception ee)
		{
			out.println("Exceptionin RecClinicalNotesPrintPreview.jsp @ pstmt2 : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		//IN040205 - End
		






	try{
		//String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?"; //Commented for IN059489 
		String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.WATERMARK_YN from ca_note_type a where  a.NOTE_TYPE=?"; //Added for IN059489
		pstmt1	= con.prepareStatement(head_foot_qry);
		pstmt1.setString(1,note_type);
		rs1 = pstmt1.executeQuery();

		while(rs1.next())
			{
				note_header_code = rs1.getString("NOTE_HEADER_CODE")==null?"":rs1.getString("NOTE_HEADER_CODE");
				footer_code = rs1.getString("FOOTER_CODE")==null?"":rs1.getString("FOOTER_CODE");
				report_header_code = rs1.getString("REPORT_HEADER_CODE")==null?"":rs1.getString("REPORT_HEADER_CODE");
				waterMarkFlag = rs1.getString("WATERMARK_YN") == null ? "" : rs1.getString("WATERMARK_YN"); //IN059489
			}

			
		}
		catch(Exception ee)
		{
			out.println("Exceptionin RecClinicalNotesPrintPreview.jsp : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
		}
		// report header
		if(!report_header_code.equals(""))
		{
			section_content_rpt = checkForNull( (String) sectionBean.getSectionContent(report_header_code,report_header_code), "&nbsp;" );
			
		}

		
		if(!visit_adm_date.equals(""))
		{
			visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
		}
		if(!dischargeDateTime.equals(""))
		{
			dischargeDateTime					=	com.ehis.util.DateUtils.convertDate(dischargeDateTime,"DMYHM","en",locale);
		}
		//IN067016--Starts
		if(!discharge_date_only.equals(""))
		{
			discharge_date_only					=	com.ehis.util.DateUtils.convertDate(discharge_date_only,"DMY","en",locale);
		}
		//IN067016--ends
		
		try
		{
			//--[IN029296] - Start
			if(!patient_name.trim().equals(""))
			{
			htParameter.put("V$PT_NAME",patient_name);
			}
			//--[IN029296] - End
			htParameter.put("V$ATT_PRACT", attending_practitioner);
			htParameter.put("V$ATT_PRACT_LT", attending_practitioner_list);//IN066807
			htParameter.put("V$ADM_PRACT", admitting_practitioner);
			htParameter.put("V$REP_PRACT", strPerfPhyName);//IN036821
			htParameter.put("V$PT_SPLTY", speciality_name);
			htParameter.put("V$PT_LOCN", location_name); 
			htParameter.put("V$ADM_DT", visit_adm_date);
			htParameter.put("V$DIS_DT", dischargeDateTime);
			htParameter.put("V$DIS_DATE", discharge_date_only);//IN067016
			htParameter.put("V$DOC_REF_H", doc_ref_id);
			htParameter.put("V$AGE", patient_age);//IN040205
		}
		catch(Exception textExp)
		{
			
			textExp.printStackTrace();
		}

		section_content_new = new StringBuffer(section_content_rpt);

		if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
		{		
			//***************************** [CRF-118] Start *****************************					
			eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
			HashMap paramHash=new HashMap();
			Hashtable tempParameter=new Hashtable();
			paramHash.put("#p_patient_id#",patient_id);
			paramHash.put("#p_encounter_id#",encounter_id);
			paramHash.put("#p_accNum#",accession_num);
			paramHash.put("#p_locale#",locale);
			paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num);  //[IN032721]
			paramHash.put("#p_eventDate#",cal_eventdate);//IN039562//IN040090
			paramHash.put("#p_facility_id#",facility_id);//IN038439
			
			tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
			if(tempParameter.size()>0){					
			htParameter.putAll(tempParameter);
			}
			//*****************************[CRF-118] Ends *****************************
			sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
		}


			
		if(!(sectionContentUpdatedXML.toString().equals("&nbsp;"))&&(!(sectionContentUpdatedXML.toString().equals(""))))
		{								
			
			section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

		}


		// report hdr ends



		if(!note_header_code.equals(""))
		{
			section_content = checkForNull( (String) sectionBean.getSectionContent(note_header_code,note_header_code), "&nbsp;" );
		}


		
				htParameter=new Hashtable();
				//htParameter.put("V$NT_STATUS", note_status);
			try
			{
				htParameter.put("V$PR_DATE", strEventDateTime);
				htParameter.put("V$NT_TITLE", strEventTitleDesc);
				htParameter.put("V$DOC_REF_NH", doc_ref_id);
				htParameter.put("V$PR_BY_PRACT", strPerfPhyName);
				htParameter.put("V$NT_MEDSRV", strMedService);
			}
			catch(Exception textExp)
			{
				
				textExp.printStackTrace();
			}

				section_content_new = new StringBuffer(section_content);
				sectionContentUpdatedXML = new StringBuffer();
								
				if(!section_content_new.toString().equals("&nbsp;")&&(!(section_content_new.toString().equals(""))))
				{				
					//IN041827 Start
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
				
					paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
					paramHash.put("#p_accNum#",accession_num);
					paramHash.put("#p_locale#",locale);
					paramHash.put("#p_pract_id#",clinician_id);
					tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
					if(tempParameter.size()>0)
					{					
						htParameter.putAll(tempParameter);
					}
					//IN041827 End
					
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}

		
		if(!(sectionContentUpdatedXML.toString().equals("&nbsp;"))&&(!(sectionContentUpdatedXML.toString().equals(""))))
		{						
			section_content=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
		}
		//[IN032210] Start
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
					String printtextHed = rs.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs.getString("PRINT_TEXT_HDR_YN");
					if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
							textLogoHeader="Y";				
				}
			}catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}

		//[IN032210] End
		//IN071513 Starts
		try{
			pstmt = con.prepareStatement("SELECT LOGO_SITE_FACILITY FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=? ");
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				logo_Site_Facility = rs.getString("LOGO_SITE_FACILITY")==null?"S":rs.getString("LOGO_SITE_FACILITY");
			}				
		}catch(Exception e){
			out.println("Exception@1 : "+e);
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		//IN071513 ends
		//IN031910 Starts
		//IN037045 - Start Modification - to have the td with 20,60,20 from 20,80	
		if((print_logo_header_yn.equals("Y")) && (logo_hdr_all_pages.equals("N")))
		{
			//[IN032210] Start
				if("Y".equals(imageLogoHeader)){
					out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
					out.println("<tr><td colspan='2'>");
					out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
					//IN066005 Start
					if(logo_Site_Facility.equals("S")){
					out.println("<img src='../../eCA/jsp/CADisplayImages.jsp'>");
					}else if(logo_Site_Facility.equals("F")){
						out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
					}out.println("</td></tr></table></td></tr>");//IN066005 end
					
					if("Y".equals(textLogoHeader)){
						//IN071513 Start.
						//out.println("<tr>");	
						//out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
						//out.println("</tr>");
						//IN071513 End.
						out.println("<tr>");	
						out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
						out.println("</tr>");
						out.println("<tr>");	
						out.println("<td width='100%' colspan='2' align='center'><h4>"+strNodesHeaderText+"</h4></td>");
						out.println("</tr>");
					}
					out.println("</table>");
				}else{
					out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
					out.println("<tr>");
					//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
					//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
					//IN066005 Starts
                                        if(logo_Site_Facility.equals("S")){					
					out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
					}else if(logo_Site_Facility.equals("F")){
					out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
					}//IN066005 ends
					if("Y".equals(textLogoHeader)){		
						//IN071513 Start.
						//out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
						//out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
						//out.println("<tr>");
						//IN071513 End.
						//out.println("<td width='20%'  align='center'>&nbsp;</td>");
						out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
						out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
						out.println("<tr>");
						//out.println("<td width='20%'  align='center'>&nbsp;</td>");
						out.println("<td width='60%'  align='center'><h4>"+strNodesHeaderText+"</h4></td>");
						out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
					}else{
						out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
						out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
					}
					out.println("</table>");
				}

				//[IN032210] End
			%>
		<!--//[IN032210] Start	<table border='0' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
				<tr>
					<td class="HEADER" align="center" width="5%" id='headerImageID'>		<img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo" width="40" height="40">
					</td>
					<td  align=center colspan = "8"><h3><%=site_name%></h3>
					</td>
				</tr>
				<tr >
					<td width='5%'>&nbsp;</td>
					<td align=center colspan ="8"><h3><%=facility_name%></h3></td>
				</tr>
				<tr>
					<td colspan ="2">&nbsp;</td>
					<td align=center colspan ="8"><h4><%=strNodesHeaderText%></h4></td>
				</tr>
			</table>  //[IN032210] End --> 
			<%
		}
		else if(print_logo_header_yn.equals("N"))
		{ 
			//out.println("<br><br><br><br><br><br><br><br><br>");  //[IN032210]
		}
		%>
		<table border="0" width="100%"> 
			<thead> 
		<%
		//if(print_logo_header_yn.equals("Y"))
		if((print_logo_header_yn.equals("Y")) && (logo_hdr_all_pages.equals("Y")))//IN031910 Ends
		{
	%>
	<!-- IN031910 Starts-->
	<tr> 
		<th style="width:100%">
	<!-- IN031910 Ends -->
		<%
			//[IN032210] Start
				if("Y".equals(imageLogoHeader)){
					out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
					out.println("<tr><td colspan='2'>");
					out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
					//IN066005 Start
					if(logo_Site_Facility.equals("S")){
					out.println("<img src='../../eCA/jsp/CADisplayImages.jsp'>");
					}else if(logo_Site_Facility.equals("F")){
						out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
					}out.println("</td></tr></table></td></tr>");//IN066005 end
					
					if("Y".equals(textLogoHeader)){
						//IN071513 Start.
						//out.println("<tr>");	
						//out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
						//out.println("</tr>");
						//IN071513 End.
						out.println("<tr>");	
						out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
						out.println("</tr>");
						out.println("<tr>");	
						out.println("<td width='100%' colspan='2' align='center'><h4>"+strNodesHeaderText+"</h4></td>");
						out.println("</tr>");
					}
					out.println("</table>");
				}else{
					out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
					out.println("<tr>");
					//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669 comitted for IN066005
					//IN066005 Starts
                                        if(logo_Site_Facility.equals("S")){					
					out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
					}else if(logo_Site_Facility.equals("F")){
					out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
					}//IN066005 ends
					if("Y".equals(textLogoHeader)){	
						//IN071513 Start.
						//out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
						//out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
						//out.println("<tr>");
						//IN071513 End.
						//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
						out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
						out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
						out.println("<tr>");
						//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
						out.println("<td width='60%'  align='center'><h4>"+strNodesHeaderText+"</h4></td>");
						out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
					}else{
						out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
						out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
					}
					out.println("</table>");
				}
				//IN037045 - End Modification - to have the td with 20,60,20 from 20,80	
				//[IN032210] End
		%>
		<!--//[IN032210] Start	<table border='0' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr> -->
				<!--<td align='left' width='5%' rowspan='2' colspan ="2">
					<img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'>
				</td>-->
		<!--		<td class="HEADER" align="center" width="5%" id='headerImageID'>		<img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo" width="40" height="40">
				</td>
				<td  align=center colspan = "8"><h3><%=site_name%></h3>
				</td>
			</tr>
			<tr >
				<td width='5%'>&nbsp;</td>
				<td align=center colspan ="8"><h3><%=facility_name%></h3></td>
			</tr>
			<tr>
				<td colspan ="2">&nbsp;</td>
				<td align=center colspan ="8"><h4><%=strNodesHeaderText%></h4></td>
			</tr>
			</table>
			</th></tr> //[IN032210] End--><!-- IN031910 --> 
	<%
	//IN031910 Starts
			if(rpt_hdr_all_pages.equals("N"))
			{
				%>
				<tr> 
				<!--<th><hr style="color:#000080"/></th> IN032744-->
				</tr>
				<%
			}
		}
		//else
		//{ 
		//	out.println("<br><br><br><br><br><br><br><br><br>"); //[IN032210]
		//}
		if(rpt_hdr_all_pages.equals("Y")  && !"".equals(section_content_rpt)&& !"&nbsp;".equals(section_content_rpt))// IN070668
			{
			//IN031910 Ends
	%>
	<tr> <th style="width:100%"><!-- IN031910 -->
			<br>
				<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD"> \\Commented for IN059489 -->
				<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;"> <!--Changed for IN059489 -->
					
			
		<%

				if(!(section_content_rpt.equals("&nbsp;")))
				{

			section_content_rpt = section_content_rpt.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
				%>
					<%=section_content_rpt%></font>	
				<%
				}
			
		%>
		</table>
		<br>
		<!-- IN031910 Starts -->
		</th> 
		</tr>
		<tr> 
		<!--<th><hr style="color:#000080"/></th> IN032744 --> 
		</tr>
		<%}
		%>
		</thead> 
		<tfoot  id="table_footer">
		<tr> 
		<td width="100%"> 
		<table width="100%" border="0"> 
			<tr> 
				<!--<th><hr style="color:#000080"/></th> IN032744 -->
			</tr> 
			<tr> 
			<th style="width:100%">&nbsp;</th> 
			</tr> 
		</table> 
		</td>
		</tr>
		</tfoot>
		<tbody> 
		<tr> 
		<td width="100%">
		<%
		if(rpt_hdr_all_pages.equals("N")  && !"".equals(section_content_rpt)&& !"&nbsp;".equals(section_content_rpt))// IN070668
		{
			%>
			<table border="0" width="100%"> 
				<thead> 
				<tr> 
					<th style="width:100%">
					<br>
					<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD"> \\Commented for IN059489 -->
					<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;"> <!--Changed for IN059489 -->
					<tr>
						<td colspan="3" ><font style ="font-family:Verdana">
						<%
						if(!(section_content_rpt.equals("&nbsp;")))
						{
							section_content_rpt = section_content_rpt.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
							%>
							<%=section_content_rpt%></font>	
							<%
						}
						%>
						</font></td>
					</tr>
					</table>
					<br>
					</th> 
				</tr> 
				<tr> 
					<!--<th><hr style="color:#000080"/></th> IN032744-->
				</tr>
				</thead> 
			</table>
			<%
		}
		%>
		<!-- IN031910 Ends -->
		<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD"> \\Commented for IN059489 -->
		<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;" > <!--Changed for IN059489 -->
		<%

				if(!(section_content.equals("&nbsp;")))
				{
					section_content = section_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
				%>
					<%=section_content%>
				<%
				}
			//}
		%>
		</table>
			<!--<hr></hr> IN032744-->
			<table border='0' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana" >
			<%

			try
			{						
				//webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

				//query_section_details = "select sec_hdg_code, sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, nvl(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, child_sec_hdg_desc, nvl(child_sec_content_type,sec_content_type) child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, image_linked_yn, PRESERVE_FORMAT_YN from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num ";
				query_section_details = "select sec_hdg_code,case when ? = 'en' then replace(sec_hdg_desc,'''','') else replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc,sec_content_type,sec_result_linked_rec_type,NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN '' ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') end end child_sec_hdg_desc ,nvl(child_sec_content_type,sec_content_type)  child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, IMAGE_LINKED_YN,preserve_format_yn from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num";
				pstmt		=	con.prepareStatement(query_section_details);
				
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,note_type);
				
				rs			=	pstmt.executeQuery();
				
				strKey	=	"";

				strKey = patient_id + "~"+ encounter_id;
				strKey = strKey.trim();
				sectionBean.getPatientSection(strKey);

				while(rs.next())
				{
					section_content = "";
					section_image_content = "";
					section_image_height	= "400";  //IN053298
 					StrDataAvlFlag	= "N";

					sec_hdg_code			=	checkForNull( rs.getString("sec_hdg_code") );
					sec_hdg_desc			=	checkForNull( rs.getString("sec_hdg_desc") );
					sec_content_type		=	checkForNull( rs.getString("sec_content_type") );
					child_sec_hdg_desc		=	checkForNull( rs.getString("child_sec_hdg_desc") );
					child_sec_hdg_code		=	checkForNull( rs.getString("child_sec_hdg_code") );
					child_sec_content_type	=	checkForNull( rs.getString("child_sec_content_type") );
					preserve_format_yn		=	checkForNull( rs.getString("PRESERVE_FORMAT_YN") );
					sys_date_time			=	rs.getString("sys_date_time");
					image_linked_yn			=	checkForNull(rs.getString("image_linked_yn"));

					try
					{
						
						//new
					sec_hdg_code_out =sec_hdg_code+"_out";
					child_sec_hdg_code_out =child_sec_hdg_code+"_out";


					output_yn = sectionBean.getOutputExistYN(sec_hdg_code,child_sec_hdg_code);
					
								
					if(output_yn.equals("Y"))
					{
						section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code_out,child_sec_hdg_code_out), "&nbsp;" );	
					}
					else
					{

						section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
					}


						if(child_sec_content_type.equals("T"))
						{

							if(!(section_content.equals("&nbsp;")))
							{								
								
/*								sbResult.delete(0,sbResult.length());
								sbResult.append(section_content);
								eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,child_sec_hdg_code,locale,sbResult);
								sbResult = tempLangParse.getLangReplacedXML();
								section_content = sbResult.toString();
								tempLangParse = null;

*/								if(output_yn.equals("Y"))
								{

									section_content=converter.buildHTMLFromXML(section_content,url2);

								}
								else
								{
									section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
								}
								section_content = section_content.replaceAll("&lt;","<");
								section_content = section_content.replaceAll("&gt;",">");
								section_content = section_content.replaceAll("&amp;","&");
							}
							
							section_content = section_content.replace("<P>","<ADDRESS><P>"); //IN040265,IN040266
							section_content = section_content.replace("</P>","</P></ADDRESS>"); //IN040265,IN040266
						}
						else
						{
							if(!image_linked_yn.equals("") && image_linked_yn.equals("Y") ){
								section_image_content	= checkForNull((String) sectionBean.getSectionImageContent(sec_hdg_code,child_sec_hdg_code),"");
								section_image_height	= checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"400");
								}
						}

						if(!(section_content.equals("&nbsp;")) ||( section_image_content != null && !(section_image_content.equals("") ) ) )
						{
							StrDataAvlFlag	 = "Y";
							
							if(strPrevSecHdgCode.equals("")|| !strPrevSecHdgCode.equals(sec_hdg_code) )
							{
								%>
								<!--<tr ><td class='NOTESUBHEADER' style="background-color:#ADADAD;hyphens:auto;" colspan=3 align='left'><font style="FONT-SIZE:13pt;font-weight:bold;font-family:Verdana"><u><i><%=sec_hdg_desc%></i></u></font></td></tr><tr> //Commented for IN059489 -->
								<%
								//7605
								if(display_note_description.equals("Y")){
								if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(strNoteTypeDesc)){ //IN073100%>
								<tr ><td class='NOTESUBHEADER' style="hyphens:auto;" colspan=3 align='left'><font style="FONT-SIZE:13pt;font-weight:bold;font-family:Verdana"><u><i><%=strNoteTypeDesc%></i></u></font></td></tr><tr><!--IN071865-->
								<% prev_note_type_desc=strNoteTypeDesc;//IN073100
								}//7605
								}%>
								<tr ><td class='NOTESUBHEADER' style="hyphens:auto;" colspan=3 align='left'><font style="FONT-SIZE:13pt;font-weight:bold;font-family:Verdana"><u><i><%=sec_hdg_desc%></i></u></font></td></tr><tr> <!--Changed for IN059489 -->
								<%
									strPrevSecHdgCode = sec_hdg_code;
							}
							%>

							<tr>
							<!--<td class='NOTESUBHEADER' style="background-color:#ADADAD;hyphens:auto;" colspan=3 > //Commented for IN059489 -->
								<td class='NOTESUBHEADER' style="hyphens:auto;" colspan=3 > <!--Changed for IN059489 -->
									<font style="FONT-SIZE:13pt;font-weight:bold;"> <u> <i><%=child_sec_hdg_desc%></i> </u></font>
								</td>
							</tr>
							<tr>
							<%
								strPrevSecHdgCode = sec_hdg_code;
						}
		
						try
						{
							if(!(section_content.equals("&nbsp;")))
							{
								section_content = section_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
								section_content = section_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
								%>
									<td colspan="3" style="hyphens:auto;"><font style ="font-family:<%=font%>"><%=section_content%></font>	
								<%
							}
						
							if(image_linked_yn.equals("Y"))
							{
								if(!section_image_content.equals(""))
								{
									if((section_content.equals("&nbsp;")))
									{
										%>
											<td colspan="3" style="hyphens:auto;">
										<%
									}
									%>
										<applet name="<%=sec_hdg_code + child_sec_hdg_code%>" code="Drawing.class" codebase="../MediPainter/" archive="medipainterapplet.jar" width="845" height="<%=section_image_height%>" align="baseline" >
											<param name="canDraw" value="0">	
											<param name="jpeg_quality" value="50">
											<param name="image" value ="<%=section_image_content%>">
										</applet> 
									<%	
								}
							}

							if (StrDataAvlFlag.equals("Y") )
							{
								%>
								</td></tr>
								<tr><td>&nbsp;</td></tr>
								<%
							}
								
							//IN033677
							if(!accession_num.equals("&nbsp;"))
							{
								strAddendumText = checkForNull(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code),"");

								strAddendumText = strAddendumText==null?"":strAddendumText;
								if(!strAddendumText.equals("&nbsp;")&& !strAddendumText.equals("")&& !strAddendumText.equals("<ADDRESS>&nbsp;</ADDRESS>"))
							{
									//strAddendumText = replaceSpecialChars(strAddendumText)//IN033677
									//out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumCreatedBy.label","ca_labels")+": "+clinician_name+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+strAddendumText+"</td></tr></table></td></tr>");	//IN040265,IN040266
									//IN040981 starts
									//out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumRecordedBy.label","ca_labels")+": "+clinician_name+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+strAddendumText+"</td></tr></table></td></tr>");   //IN040265,IN040266
									out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumRecordedBy.label","ca_labels")+":</B> "+clinician_name+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;hyphens:auto;\" >"+strAddendumText+"</td></tr><tr><td>&nbsp;</td></tr></table></td></tr>");   //IN040265,IN040266
									//IN040981 ends
										strAddendumFlag = "Y";
										addendumTxt ="";
								}
							}
							//IN033677
						}
						catch(Exception e)
						{
							out.println("Exception caught at inter @1.33-->" + e);
							e.printStackTrace();
						}
				}
				catch(Exception e)
				{
					out.println("Exception caught at inter @1.34-->" + e);
					e.printStackTrace();
				}
				
				if(child_sec_content_type.equals("T"))
					out.println("</center>");
			} 			
		}
		catch(Exception e)
		{
			out.println("Exception@2 : "+e);
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null) pstmt.close();
		}
		try
		{
				//IN033677,starts
				if(!accession_num.equals("&nbsp;"))		
				{
				//String sqlAddendum = "select ADDENDUM_TEXT, b.PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_note_addendum a, AM_PRACTITIONER b where a.FACILITY_ID =? and ACCESSION_NUM=? and a.PRACTITIONER_ID = b.PRACTITIONER_ID order by ADDENDUM_DATE ";
				//String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss'),a.addendum_status from 	ca_encntr_note_addendum a where /*a.FACILITY_ID =? and */ ACCESSION_NUM=? order by ADDENDUM_DATE";//IN033869//IN033677
				//IN071569 Start.
				//String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss'),a.addendum_status from 	ca_encntr_note_addendum a where /*a.FACILITY_ID =? and */ ACCESSION_NUM=? and SEC_HDG_CODE='*AmmendNotes*' and SUBSEC_HDG_CODE='*AmmendNotes*' and addendum_status='S' order by ADDENDUM_DATE";//IN033869//IN033677
				String sqlAddendum = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') PRACTITIONER_NAME, null RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss'),a.addendum_status,ADDENDUM_CLOB,ADDENDUM_STORAGE_TYPE from 	ca_encntr_note_addendum a where  ACCESSION_NUM=? and SEC_HDG_CODE='*AmmendNotes*' and SUBSEC_HDG_CODE='*AmmendNotes*' and addendum_status='S' order by ADDENDUM_DATE";
				//IN071569 End.
				pstmt = con.prepareStatement(sqlAddendum);
				pstmt.setString(1,locale);
				//pstmt.setString(2,facility_id);
				pstmt.setString(2,accession_num);
				rs=pstmt.executeQuery();

				String addendumText = "";
				String practName = "";
				String addedDate = "";
				String addendumStatus = "";
				//String latestAddendumType = "";//IN033869//IN033677
				//String exists = "N";//IN033677
				while(rs.next())
				{
					//IN071569 Start.
					//addendumText = rs.getString(1);
					if("CLOB".equals((String)rs.getString(7)))
						addendumText	= rs.getString(6)==null?"":rs.getString(6);
					else
						addendumText = rs.getString(1);
					//IN071569 End.
					practName = rs.getString(2);
					addedDate = rs.getString(4);
					addendumStatus = rs.getString("addendum_status");//IN033869

					if(addendumText == null) 
						 addendumText ="";

					if(practName == null)
							practName = "";

					if(addedDate == null)
							addedDate = "";

					//IN033677,starts
					//if (!addendumText.equals(""))
						//addendumText = replaceSpecialChars(addendumText);

					//if(addendumStatus.equals("S"))//IN033869,starts
					//{
						//IN040981 starts
						//out.println("<tr><td style=\"font-family:Verdana;font-size:9pt;\" colspan=\"3\"><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumCreatedBy.label","ca_labels")+": "+practName+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+addedDate+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+addendumText+"</td></tr></table>				</td></tr>");
						out.println("<tr><td style=\"font-family:Verdana;font-size:9pt;\" colspan=\"3\"><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumCreatedBy.label","ca_labels")+":</B> "+practName+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+addedDate+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;hyphens:auto;\" >"+addendumText+"</td></tr><tr><td>&nbsp;</td></tr></table>				</td></tr>");
						//IN040981 ends
					//	latestAddendumType = "S";
				//	}					
				//	else if(addendumStatus.equals("R"))
				//	{
					//	out.println("<tr><td style=\"font-family:Verdana;font-size:9pt;\" colspan=\"3\"><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumRecordedBy.label","ca_labels")+": "+practName+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+addedDate+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;hyphens:auto;\" >"+addendumText+"</td></tr></table>				</td></tr>");
					//	latestAddendumType = "R";
				//	}
				//	exists= "Y";
				//IN033677,ends
				}

				String strNodeAddendum = "";
				strNodeAddendum	= checkForNull((String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*"),"");

				//if(!accession_num.equals("&nbsp;") && exists.equals("Y"))//IN033869
			//	{
				if(strNodeAddendum.equals("<ADDRESS>&nbsp;</ADDRESS>"))//IN033677
					strNodeAddendum = "";//IN033677
				if(!strNodeAddendum.equals(""))//IN033869//IN033677
				{
				//	strNodeAddendum = replaceSpecialChars(strNodeAddendum);
				//IN040981 starts	
				//out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumRecordedBy.label","ca_labels")+": "+clinician_name+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+strNodeAddendum+"</td></tr></table></td></tr>");//IN033869
				out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddendumRecordedBy.label","ca_labels")+":</B> "+clinician_name+", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+": "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;hyphens:auto;\" >"+strNodeAddendum+"</td></tr><tr><td>&nbsp;</td></tr></table></td></tr>");//IN033869
				//IN040981 ends
				//strAddendumFlag = "Y";
				//	addendumTxt ="";
				}//IN033869,ends
			}
		}
		catch(Exception e)
		{
			out.println("Exception@ from ca_encntr_note_addendum : "+e);
			e.printStackTrace();
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch (Exception eeee)
	{
		
		eeee.printStackTrace();
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}

	// for note footer
	section_content = "";
	if(!footer_code.equals("") && footer_code != null)
		{
			section_content = checkForNull( (String) sectionBean.getSectionContent(footer_code,footer_code), "&nbsp;" );
			
			if(!printDateTime.equals(""))
				{
					printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
				}
			
			htParameter=new Hashtable();
			try
			{
				htParameter.put("V$DOC_REF_F", doc_ref_id);
				htParameter.put("V$PRN_DTTIME", printDateTime);
				htParameter.put("V$AT_PRACT", authorized_by);
				htParameter.put("V$AT_PRACT_SIGN", authorized_sign); //IN069484
				htParameter.put("V$LT_MODI_USR", last_amended_by);
				htParameter.put("V$LT_PT_P_C_D", pract_sign);
			}
			catch(Exception textExp)
			{
				
				textExp.printStackTrace();
			}
				
			section_content_new = new StringBuffer(section_content);
			//IN038439 Start
			if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
			{		
								
			eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
			HashMap paramHash=new HashMap();
			Hashtable tempParameter=new Hashtable();
			paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
			paramHash.put("#p_accNum#",accession_num);
			paramHash.put("#p_locale#",locale);
			paramHash.put("#p_pract_id#",clinician_id);
			tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				if(tempParameter.size()>0){					
				htParameter.putAll(tempParameter);
			}
			}
			//IN038439 Ends
			sectionContentUpdatedXML = new StringBuffer();
			
			if(section_content_new != null && !section_content_new.toString().equals("&nbsp;")&&(!(section_content_new.toString().equals(""))))
			{					
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}
				
			if(sectionContentUpdatedXML != null && !(sectionContentUpdatedXML.toString().equals("&nbsp;"))&&(!(sectionContentUpdatedXML.toString().equals(""))))
			{					
				section_content=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
			}

		}
		

	
	converter=null;
	// for note footer


%>
</table>
	<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
		
			<!--
			<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;:background-color:#ADADAD;font-size:9pt">
				<tr>
					<td width='20%'><b><%=strAuthoByCaption%></b></td>
					<td width='45%' align='left'>:  <font size='2'><%=strAuthoBy%></font></td>
					<td width='15%'><b><fmt:message key="eCA.Signature.label" bundle="${ca_labels}"/></b></td><td width='20%' align='left'>:&nbsp;</td>
				</tr>
				<tr>
					<td width='20%'><b><fmt:message key="eCA.LastModifiedBy.label" bundle="${ca_labels}"/></b></td><td width='45%' align='left'>:  <font size='2'><%=strModifyBy%></font></td>
					<td width='15%'><b><fmt:message key="eCA.Signature.label" bundle="${ca_labels}"/></b></td><td width='20%' align='left'>:  </td>
				</tr>
				<tr>
					<td width='20%'><b><fmt:message key="eCA.PrintDateTime.label" bundle="${ca_labels}"/></b></td><td width='45%' align='left'> <font size='2'>:  <%=printDateTime%></font></td>
					<td width='15%'><b><fmt:message key="eCA.LoggedUser.label" bundle="${ca_labels}"/></b></td><td width='20%' align='left'><font size='2'>:  <%=login_user_id%></font></td>
				</tr>
			</table> -->
			<%
				if(!(section_content.equals("&nbsp;")))
				{
				section_content = section_content.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
				%>
					<%=section_content%>
				<%
				}
			%>

			
	</table>
	<!--<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;:background-color:#ADADAD"> //Commented for IN059489-->
	<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center style="font-family:Verdana;"> <!--Changed for IN059489 -->
	<tr>
		<td nowrap colspan ="8" align ="left"><font size ="1"><%=strDisClaimerText%></td>
	<tr>
	</table>
	<!-- IN031910 Starts -->
	</td> 
   </tr>
  </tbody> 
</table>
	<!-- IN031910 Ends -->
<!--IN068105 starts-->
<%if("Y".equals(noteCopiedYN)){%>
<table border=0 cellspacing=0 width='100%'>
	<tr>
		<td align='right' >
			<span style="background-color: black;color : white">*COPIED NOTE</span>&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
	</tr>
</table>
<%}%>
<!--IN068105 ends-->

</center>
</form>
</body>
<!--IN059489 Start -->
<%if (waterMarkFlag.equals("Y")){%>
<style>
body{
	background-image : url('../../eCA/images/Draft.jpg');
	background-repeat: no-repeat;
	 background-position: 100 100 50 50;
	}
</style>
<%}%>
<!--IN059489 Ends -->
<script language='javascript'>

	async function PrevPreview()
	{
	var i = 0
	var res = confirm('Continue printing?');
	if(res)
	{
		while( i < document.applets.length ) 
		{
			var j = 0 ;
			while ( !document.applets[i].isActive() && j++ <=75000 ) 
				window.status = i;
			i++;
		}
		await window.print();
		//SysPreview();
	}
	setTimeout(function(){
	    window.close();
	}, 1000);
	
	}

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>
<%!
	public String checkForNull(String inputString)
	{
		return ((inputString==null || inputString.equals(""))	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		
		if(inputString==null || inputString.equals("")||inputString.equals("null"))inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
	}
%>
<%!
	
	private String replaceSpecialChars(String input)
	{
		/*commended on 18/03/2006
			StringBuffer temp=new StringBuffer();
		while(input.indexOf("\n")!=-1)
		{	
			int ii=input.indexOf("\n");
			temp.append(input);
			temp.replace(ii,ii+1,"<br>");
			input=temp.toString();
			temp.delete(0,temp.length());
		}
		
		return input;*/
		/*commended on 10/05/2012 [IN032683]
		if(input.indexOf(" ")!=-1)
			input = input.replaceAll(" ","&nbsp;");

		if(input.indexOf("\n")!=-1)
			input = input.replaceAll("\n","<br>");	 */
		return input;
	}

%>


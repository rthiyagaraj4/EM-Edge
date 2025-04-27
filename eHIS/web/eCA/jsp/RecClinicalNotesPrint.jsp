<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            ?           	created
19/10/2011		IN029296	Chowminya G		Incident No: IN029296 - <Field patient name in Report Header doesn?t display thai name> 
15/12/2011		IN029312	Menaka V		Incident No: IN029312 - <Report is printed either through
											order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. > 
15/02/2012		IN031116	Ramesh G	 	Report header is overlapping the hospital letter heads & deliverable.	
15/03/2012		IN030419	Menaka V	 	Clinical Note Logo Header and Report Header .	
05/04/2012		IN031989	Menaka V	 	When a patient is selected by using patient without encounter search function and when clinical event history is
											accessed the note header is incomplete for all the existing notes for that patient.
15/05/2012		IN032721	Ramesh G		When we Click on Print Preview the Date is not displayed in the examination date component.										 
07/06/2012		IN0331914	Ramesh G		Logo is missing from the header of clinical notes
20/06/2012	  	IN033489	Menaka V		Report header blank in clinical event history.
09/11/2012	  	IN036159	Dinesh T		Patient details are not displayed properly when his encounter id matches with another encounter id in another facility
22/02/2013	    IN036821	Chowminya G		Reporting Practitioner name not coming in the CA report
25/02/2013		IN037045    Chowminya G		CA Report logo/header alignment
03/05/2013		IN038088	Ramesh G		As we select a clinical note to be printed, we will need to close the note first before we are able to print the note.
06/05/2013	    IN039562	Chowminya G	    Age format Changed to Y-M-D	
15/05/2013    	IN038439	NijithaS		Bru-HIMS-CRF-351
21/05/2013      IN040090    Chowminya G	    Linked Issue: New format age components in local language	
28/05/2013      IN040205    Chowminya G	    Deceased patinet age issue	
25/07/2013		IN041924	Ramesh G		IE9 Issue[Note Print]
19/08/2013		IN041827	Akbar			ML-BRU-SCF-0949
17/10/2013      IN042733    NijithaS		MO-GN-5430		
23/10/2013		IN044358	Ramesh G		Header field of matrix component should be display border for separate each column
13/12/2013		IN045446	Chowminya		Inconsistent display Practitioner Name in Report Header when printing medical certificate 
16/12/2013		IN045646	Chowminya		Speciality name in report header has to be long name
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
02/04/2014	IN048271		Ramesh G		02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
03/09/2014  IN050584		NijithaS										MO-GN-5454-CA-SL3  
16/03/2015  IN054024		Ramesh G										There is an issue for 1 patient where the Report Header Contents 									as well as the Note Header  Contents do not display on preview print as well as in the Print out.
21/07/2015  IN056353		Ramesh G		21/07/2015      Akbar S			GHL-SCF-942 : Radilogy report blank page printout
05/02/2016	IN004500		Raja S											GHL-SCF-1000
02/05/2016	IN059489		Raja S											Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
08/01/2018	IN064446		Raja S			08/01/2018		Ramesh G		GHL-CRF-0469
29/05/2018	IN067635		Ramesh G										ML-MMOH-SCF-1001/MMS-MD-SCF-0089/MMS-DM-SCF-0546
22/08/2018	IN066793		Sharanraj		22/08/2018
05/10/2018	IN068396		Raja S			05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
04/01/2019  IN067016        Ramya Maddena	04/01/2019      Ramesh G    	AMRI-CRF-0370
04/03/2019   IN066807                Ramya Maddena          4/03/2019                Ramesh G        AMRI-CRF-0340
04/05/2019	IN069484		Ramesh G										AMRI-CRF-0398
10/06/2019     IN070668              sivabagyam	          10/06/2019          Ramesh G		SKR-SCF-1215
28/06/2019  IN066005        Ramya Maddena   01/07/2019      Ramesh G        ML-BRU-CRF-0474 
06/09/2019	IN071335	   	Ramesh G											Common-ICN-0012
14/10/2019	IN071513		Ramesh G		14/10/2019		Ramesh G		ML-BRU-CRF-0585.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
25/10/2021	24460			Ramesh G		25/10/2021		Ramesh G		ML-MMOH-SCF-1911
13/10/2022	27926			Ramesh Goli										ML-MMOH-CRF-1643
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!-- IN066793 -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.Date,java.text.SimpleDateFormat,java.util.zip.*,java.io.*,"%><!-- IN042733 -->
<%	
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
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
<!--IN064446 Changes starts-->
<script>
function SysPreview()
{
	alert("inside syspreview 93");
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
		alert("111");
		window.close();
	}
	catch (e)
	{
		alert("Failed");
	}
}
</script>
<!--IN064446 changes ends -->
</head>
<title><%=request.getParameter("title")%></title>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad = "Print()" >
<form>
<%

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String header_top = "";
	String display_dis_text_print = "";//IN004500
	//IN030419 Starts
	String logo_hdr_all_pages = "";
	String rpt_hdr_all_pages = "";
	//IN030419 Ends
	String footer_bottom = ""; //[IN031116]
	String hdr_ft_yn = "";//[IN031116]
	String		note_type			=	"";
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	//[IN032210] Start
	String imageLogoHeader ="N";
	String textLogoHeader ="N";
	//[IN032210] End
	boolean restrctPageNo=false; //27926
	note_type			=	request.getParameter("note_type")==null		? ""	:	request.getParameter("note_type");
	String sourceprintl		= request.getParameter("sourceprint")==null?"":request.getParameter("sourceprint"); //IN004500
	//IN059489 Changes starts
	String waterMarkFlag = "N";
	String status = ""; //IN059489
	//IN059489 Changes Ends
	//IN064446 Changes starts
	String[] argsArry = new String[3];
	argsArry[0] =  "";//request.getParameter("data[0]")==null?"":request.getParameter("data[0]");
	argsArry[1] = request.getParameter("data[1]")==null?"":request.getParameter("data[1]");
	argsArry[2] = request.getParameter("data[2]")==null?"":request.getParameter("data[2]");
	String ppFlag = request.getParameter("ppFlag")==null?"N":request.getParameter("ppFlag");
	//IN064446 Changes ends
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40";//IN068669
        String logo_Site_Facility ="S";//IN066005
		//IN030419 Starts
		try
		{	
			con	= ConnectionManager.getConnection(request);
			//pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN FROM ca_note_param ");//IN068669
			pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT  FROM ca_note_param ");//IN068669
			rs	=	pstmt.executeQuery();
			if(rs.next())
			{
				logo_hdr_all_pages	= rs.getString("LOGO_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("LOGO_HDR_ALL_PAGE_YN");
				rpt_hdr_all_pages	= rs.getString("RPT_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("RPT_HDR_ALL_PAGE_YN");
				LOGO_HDR_WIDTH	= rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH");//IN068669
				LOGO_HDR_HEIGHT	= rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT");//IN068669
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			restrctPageNo=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CEH_PRINT_RESTRICT_PAGENO");//27926

	    }
	    catch(Exception e)
		{
			out.println("Exception@111 - in getting logo and report header: "+e);
			
		}
		//IN030419 Ends
		System.out.println("RecClinicalNotesPrint.jsp--------restrctPageNo--------->"+restrctPageNo);
		try
		{
			
			//con	= ConnectionManager.getConnection(request);  \\ Unused Connection
			// [IN031116] Start
			//pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH  from CA_NOTE_TYPE where NOTE_TYPE = ? "); 
			//pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH ,FT_MARGIN_IN_INCH from CA_NOTE_TYPE where NOTE_TYPE = ? "); //[IN031116] End
			//pstmt.setString	(1,note_type );
			//rs	=	pstmt.executeQuery();
			///if(rs.next())
			//{
			//	header_top	= rs.getString("HDR_MARGIN_IN_INCH") == null ? "" : rs.getString("HDR_MARGIN_IN_INCH");
			//	footer_bottom = rs.getString("FT_MARGIN_IN_INCH") == null ? "" : rs.getString("FT_MARGIN_IN_INCH");
			//}
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
		// IN004500 starts
		if(sourceprintl!="" && sourceprintl.equals("CEH"))
		{
			try
			{
				pstmt = con.prepareStatement("select CEH_DISC_TEXT from CA_NOTE_PARAM");
				rs = pstmt.executeQuery();
				if(rs.next()){
					display_dis_text_print =  rs.getString("CEH_DISC_TEXT") == null ? "" : rs.getString("CEH_DISC_TEXT");
				}
			
				if(rs!=null)	rs.close();
				if(pstmt!=null)	pstmt.close();
		    }
		    catch(Exception e)
			{
				out.println("Exception@111 - in getting header_appl_yn : "+e);
			}
		}
		// IN004500 Ends
%>
<!--  <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>  // Commented for  for IN059489-->
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
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
<%
//27926 Start.
if(!restrctPageNo){
%>
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
<%}else{%>	
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "" 
	WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", ""
<%
}
//27926 End.
%>
    
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
	
	//IN066793 starts
	boolean sitespecific=false;
		Connection	 conn=null;
		try
		{
			 conn	= ConnectionManager.getConnection(request);
			sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
		}
		catch(Exception e)
		{
			out.println("Exception@111 - in getting header_appl_yn : "+e);
		}
		finally
		{
			if(conn!=null)	ConnectionManager.returnConnection(conn,request);
		}
		
	//IN066793 ends	
	%>
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<!--IN066793 starts  -->
<% 
if(sitespecific)
{	
%>	
<style>
	ADDRESS	{ 
			FONT-FAMILY: Segoe UI ;
		FONT-SIZE: 10pt ; 
		FONT-STYLE: NORMAL; 
		COLOR: BLACK; 
		}
		/* IN054024 Start. */
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
	ADDRESS	{ 
			FONT-FAMILY: Verdana ;
		FONT-SIZE: 10pt ; 
		FONT-STYLE: NORMAL; 
		COLOR: BLACK; 
		}
		/* IN054024 Start. */
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
//IN066793 starts  
	Hashtable htParameter=new Hashtable();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	//String data				= request.getParameter("data")==null?"":request.getParameter("data");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String accession_num	= request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	
	//out.println("<script>alert('accession_num"+accession_num+"')</script>");
	String discharge_summary_text ="";
	

	if(discharge_summary_text == null)
		discharge_summary_text = "";

	//Connection			con			=	null;
	//PreparedStatement	pstmt		=	null;
	PreparedStatement	pstmt2			=	null;
	//ResultSet			rs			=	null;
	ResultSet			rs2				=	null;

	PreparedStatement	pstDisTxt	=	null;
	ResultSet			rsDisTxt	=	null;

	String	query_notes_detail		=	"";
	String	notes_content			=	"";
	String  notes_content1			=	"";
	String note_group_desc			= ""; //[IN033191]
	String  strDisTextQuery			=   "";
	String  strNoteType				=	"";
	String  printhdrindsyn			=	"";
	String  head_foot_qry			=	"";
	String  sect_template_query		=	"";
	String  athorise_by_qry			=	"";
	String  note_header_code		=	"";
	String  footer_code				=	"";
	String  report_header_code		=	"";
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_hdr		=	"";
	String	section_content_ftr		=	"";
	String  url1					=	"";
	String  url						=	"";
	String  authorized_by_name		=	""; //IN069484
	String  authorized_by_id		=	""; //IN069484
	String  authorized_sign			=   "N"; //IN069484
	String  last_amended_by						=	"";
	String  doc_ref_id						=	"";
	String		patient_id		=	"", note_status 	=	"", note_type_desc 	=	"";
	String		performing_phy_name		=	"", event_date_time 	=	"", attending_practitioner 	=	"", performing_phy_name1		=	"";//IN036821
	String attending_practitioner_list = "";//IN066807
	String admitting_practitioner="";
	String		speciality_name		=	"", Sex 	=	"", visit_adm_date 	=	"";
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String		discharge_date_only = "";//IN067016
	String		patient_class		=	"" ,age	=	"" ,encounter_id = "" ;
	String		login_user_id							=	"";
	String		printDateTime						=	"";
	String		patient_name							=	"";
	String		encounter_id1							=	"";
	String		query_privilege_type	=	"" ;
	String		episode_type	=	"" ;
	String		gender	=	"" ;
	String		called_from	=	"" ;
	String		performed_by_id	=	"" ;
	String		facility_name	=	"" ;
	String		site_name	=	"" ;
	String		pract_sign = "";
	String		pract_sign_qry = "";
	String		clinician_id = "";
	String		appl_task_id = "";
	String      default_pat_name = ""; //--[IN029296]
	HashMap<String,String> paramMap = null;
    String contr_mod_accession_num = ""; //[IN032721]
	String cal_eventdate = "";//IN040090
	//IN040205 - Start
	String deceased_yn = "";
	String deceased_date = "";
	PreparedStatement	pstPatInfo		=	null;
	ResultSet			rsPatInfo		=	null;
	String patient_age = "";
	//IN040205 - end
	int note_print_time_interval	=	0;	//IN041924

		clinician_id			= (String)session.getValue("ca_practitioner_id");
		login_user_id		=	(String)session.getValue("login_user");
		patient_id			=	request.getParameter("patient_id")==null		? ""	:	request.getParameter("patient_id");
		note_status			=	request.getParameter("note_status")==null		? ""	:	request.getParameter("note_status");
		note_type_desc		=	request.getParameter("event_title_desc")==null		? ""	:	request.getParameter("event_title_desc");
		performing_phy_name	=	request.getParameter("performed_by_pract")==null		? ""	:	request.getParameter("performed_by_pract");
		performing_phy_name1	=	request.getParameter("performed_by_pract")==null		? ""	:	request.getParameter("performed_by_pract");//IN036821
		event_date_time		=	request.getParameter("performed_date")==null		? ""	:	request.getParameter("performed_date");
		String strEventDateTime		= checkForNull((String)request.getParameter("event_date_time"),"");//IN042733
		attending_practitioner = request.getParameter("attending_practitioner") == null ? "" : request.getParameter("attending_practitioner");
		attending_practitioner_list = request.getParameter("attending_practitioner_list") == null ? "" : request.getParameter("attending_practitioner_list");//IN066807
		if(attending_practitioner.equals("null"))
			attending_practitioner = "";
		admitting_practitioner = request.getParameter("admitting_practitioner") == null ? "" : request.getParameter("admitting_practitioner");
		if(admitting_practitioner.equals("null"))
			admitting_practitioner = "";
		speciality_name		=	request.getParameter("speciality_name")==null		? ""	:	request.getParameter("speciality_name");
		Sex					=	request.getParameter("Sex")==null		? ""	:	request.getParameter("Sex");
		visit_adm_date		=	request.getParameter("visit_adm_date")==null		? ""	:	request.getParameter("visit_adm_date");
		discharge_date		=	request.getParameter("discharge_date")==null		? ""	:	request.getParameter("discharge_date");
		discharge_date_only	=	request.getParameter("discharge_date")==null		? ""	:	request.getParameter("discharge_date");//IN067016
		med_service			=	request.getParameter("med_service")==null	? ""	:	request.getParameter("med_service");
		location_code		=	request.getParameter("location_code")==null		? ""	:	request.getParameter("location_code");
		patient_class		=	request.getParameter("patient_class")==null		? ""	:	request.getParameter("patient_class");
		printDateTime		=	request.getParameter("printDateTime")==null		? ""	:	request.getParameter("printDateTime");
		note_type			=	request.getParameter("note_type")==null		? ""	:	request.getParameter("note_type");
		patient_name		=	request.getParameter("patient_name")==null		? ""	:	request.getParameter("patient_name");
		//patient_name		=	java.net.URLDecoder.decode(patient_name);
		encounter_id		=	request.getParameter("encounter_id")==null		? ""	:	request.getParameter("encounter_id");
		age					=	request.getParameter("age")==null		? ""	:	request.getParameter("age");
		episode_type		=	request.getParameter("episode_type")==null		? ""	:	request.getParameter("episode_type");
		called_from			=	request.getParameter("called_from")==null		? ""	:	request.getParameter("called_from");
		performed_by_id			=	request.getParameter("performed_by_id")==null		? ""	:	request.getParameter("performed_by_id");
		appl_task_id			=	request.getParameter("appl_task_id")==null		? ""	:	request.getParameter("appl_task_id");
		contr_mod_accession_num = checkForNull((String)request.getParameter("contr_mod_accession_num"),"");   //[IN032721]
		// IN071335 Changes Start.
		//url   = HttpUtils.getRequestURL(request).toString();
		//url = url.substring(0,url.indexOf("jsp/")); 
		url					= application.getRealPath("/eCA")+"/";
		// IN071335 Changes End.
		/*IN066793 starts*/
		
		if(sitespecific)
		{
			System.out.println("ifff");
			url1 = url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
			url =url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
		}
		else
		{
			System.out.println("else");
			url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
			url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
		}
		/*IN066793 ends*/
		cal_eventdate = com.ehis.util.DateUtils.convertDate(strEventDateTime,"DMYHM","en","en");//IN040090//IN050584
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	//strDisTextQuery = "select DISCLIMER_TEXT from CA_DISCLIMER_TEXT A, CA_NOTE_TYPE B where B.DISCLIMER_CODE = A.DISCLIMER_CODE and b.note_type = ?  and a.eff_status ='E'";
	
	// shaiju added for sign on print --sshh

		//if(called_from.equals("printOnSign")){//IN031989
			if(	episode_type.equals("O") )
			{
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN036159
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?"; //IN036159//IN045446 get_desc for performed_by_name changed from 2 to 1//IN045646 get_desc for specialty_name changed from 2 to 1 //comitted for IN067016
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?"; //IN067016//commented for IN066807
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list(a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?  ORDER BY A.VISIT_ADM_DATE_TIME DESC";//IN066807
			}
			else
			{ 
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";//IN036159
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?";//IN036159
				//IN045446 get_desc for performed_by_name changed from 2 to 1 //IN045646 get_desc for specialty_name changed from 2 to 1 //comitted for IN067016
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?";//IN067016//commented for IN066807
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ? ORDER BY A.VISIT_ADM_DATE_TIME DESC";//IN066807
			}
		//}//IN031989

		


	
	// --sshh ends
	
	strDisTextQuery = "select 	CA_GET_DESC.CA_DISCLIMER_TEXT(b.DISCLIMER_CODE,?,'1')DISCLIMER_TEXT,b.NOTE_TYPE_DESC from 	CA_NOTE_TYPE B 	where 	b.note_type = ?  and 	b.eff_status ='E'";

	//query_notes_detail = "select a.note_content, b.note_type_desc,b.note_type,(select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN  from ca_encntr_note a, ca_note_type b where a.note_type = b.note_type and a.facility_id = ? and a.accession_num = ?";
	//query_notes_detail = "select a.note_content, b.note_type_desc,b.note_type,(	select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN, b.PRINT_LOGO_HEADER_YN  from 	ca_encntr_note a, ca_note_type_lang_Vw b where 	a.note_type = b.note_type and 	/*a.facility_id = ? 	and */	a.accession_num = ? 	and	b.language_id = ?"; //Commented for IN059489
	//6484 Start.
	//query_notes_detail = "select a.note_content, b.note_type_desc,b.note_type,(	select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN, b.PRINT_LOGO_HEADER_YN,a.EVENT_STATUS  from 	ca_encntr_note a, ca_note_type_lang_Vw b where 	a.note_type = b.note_type and 	/*a.facility_id = ? 	and */	a.accession_num = ? 	and	b.language_id = ?"; //Modified for IN059489
	query_notes_detail = "select a.note_content,a.compress_note_content_yn,a.compress_note_content, b.note_type_desc,b.note_type,(	select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN, b.PRINT_LOGO_HEADER_YN,a.EVENT_STATUS  from 	ca_encntr_note a, ca_note_type_lang_Vw b where 	a.note_type = b.note_type and 	/*a.facility_id = ? 	and */	a.accession_num = ? 	and	b.language_id = ?"; 
	//6484 End.
	//head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?"; //Commented for IN059489
	head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.WATERMARK_YN from ca_note_type a where  a.NOTE_TYPE=?"; //Modified for IN059489

	sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;

	//athorise_by_qry ="select a.AUTHORIZED_BY_ID ,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;
	//IN069484 Start		
	//athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ?  " ;
	athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_NAME,a.AUTHORIZED_BY_ID AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ?  " ;
	//IN069484 End.
	pract_sign_qry=	"SELECT a.practitioner_name|| CHR (13)|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)|| b.position_desc|| NVL2 (b.position_desc, CHR (13), '' )|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)|| credential_id1 || NVL2 (credential_id1, ', ', '')       || credential_id2 || NVL2 (credential_id2, ', ', '')|| credential_id3 || NVL2 (   credential_id1|| credential_id2|| credential_id3,CHR (13),'')|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || DEGREE pract_with_pos_cred_deg  FROM am_practitioner a, am_position b WHERE a.position_code = b.position_code AND a.practitioner_id = ? ";
	
	//IN040205 - Start
	String strPatInfoQuery = "";
	strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth,decode(deceased_yn,'Y',deceased_date,sysdate)) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_all_patients_vw where patient_id = ? "; 
		
			try
			{
				pstPatInfo	= con.prepareStatement(strPatInfoQuery);
				pstPatInfo.setString    (	1,	patient_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next() )
				{
					patient_age		= rsPatInfo.getString("patient_age") == null ? "" : rsPatInfo.getString("patient_age");
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
	//IN040205 - end
	try
	{
		//con				=	ConnectionManager.getConnection(request);
		
		//shaiju
			
			pstmt	=	con.prepareStatement(pract_sign_qry);
			pstmt.setString	(	1,	clinician_id	);
			rs		=	pstmt.executeQuery();
			if(rs.next())
			{
				pract_sign			=	rs.getString("pract_with_pos_cred_deg") == null ? "" : rs.getString("pract_with_pos_cred_deg");
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
		
		
		//if(called_from.equals("printOnSign")){//IN031989
			pstmt	=	con.prepareStatement(query_privilege_type);
			pstmt.setString	(	1,	locale	);
			pstmt.setString	(	2,	locale	);
			pstmt.setString	(	3,	locale	);
			pstmt.setString	(	4,	locale	);
			pstmt.setString	(	5,	performed_by_id	);
			pstmt.setString	(	6,	locale	);
			pstmt.setString	(	7,	locale	);			
			pstmt.setString	(	8,	locale	);	
			pstmt.setString	(	9,	locale	);			
			pstmt.setString	(	10,	locale	);			
			//pstmt.setString	(	11,	facility_id	);
			pstmt.setString	(	11,	encounter_id);
			pstmt.setString	(	12,	patient_id);//IN036159

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
				med_service			=	rs.getString("service_name")==null?"":rs.getString("service_name");
				discharge_date		=	rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
				discharge_date_only		=	rs.getString("DISCHARGE_DATE_TIME_1")==null?"":rs.getString("DISCHARGE_DATE_TIME_1");//IN067016
				attending_practitioner	=	rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
                		attending_practitioner_list	=	rs.getString("attending_pract_list")==null?"":rs.getString("attending_pract_list");//IN066807
				admitting_practitioner	=	rs.getString("admitting_practitioner")==null?"":rs.getString("admitting_practitioner");
				performing_phy_name	=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
				age				=	rs.getString("AGE")==null?"":rs.getString("AGE");
				gender					=	rs.getString("gender")==null?"":rs.getString("gender");
				//locationDesc			=	rs.getString("location");
				location_code			=	rs.getString("location_code")==null?"":rs.getString("location_code");
				patient_name			=	rs.getString("patient_name")==null?"":rs.getString("patient_name");
				speciality_name			=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
				printDateTime			=	rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
				site_name			=	rs.getString("site_name")==null?"":rs.getString("site_name");
				//performed_by_desc			=	rs.getString("performed_by_desc");
				patient_class =	rs.getString("patient_class")==null?"":rs.getString("patient_class");//IN033489

			
			}

				if(gender.equals("M"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				/*  //24460 Start.				
				else 
						//Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				*/	//24460 End.
			if(discharge_date==null){
				discharge_date="";
			}
			//IN067016--Starts
			if(discharge_date_only==null){
				discharge_date_only="";
			}
			//IN067016--ends
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			//[IN033191] Start
			pstmt			=	con.prepareStatement("SELECT A.NOTE_GROUP_DESC NOTEGRDESC FROM CA_NOTE_GROUP A,CA_NOTE_TYPE B WHERE A.NOTE_GROUP=B.NOTE_GROUP_ID AND B.NOTE_TYPE=?");
			pstmt.setString(1, note_type);			
			rs				=	pstmt.executeQuery();
			if(rs.next())
			{
				note_group_desc = rs.getString("NOTEGRDESC");
			}
			
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			//[IN033191] End
		//}//IN031989
		
		if(patient_class.equals("OP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else if(patient_class.equals("IP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(patient_class.equals("EM"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(patient_class.equals("DC"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		//shaiju
		
		pstDisTxt = con.prepareStatement(strDisTextQuery);
		
		
		pstmt			=	con.prepareStatement(query_notes_detail);
	
	
		//pstmt.setString(1, facility_id);
		pstmt.setString(1, accession_num);
		pstmt.setString(2, locale);

		rs				=	pstmt.executeQuery();
	
		if(rs.next())
		{
			
			//6484 Start.
			strNoteType			=	rs.getString("note_type");
			printhdrindsyn      =   rs.getString("PRINT_LOGO_HEADER_YN");
			note_type_desc = rs.getString("note_type_desc") == null ? "" : rs.getString("note_type_desc");
			status				=	rs.getString("EVENT_STATUS") == null ? "" : rs.getString("EVENT_STATUS");

			if(printhdrindsyn == null)
					printhdrindsyn ="N";
				
			if("Y".equals(rs.getString("compress_note_content_yn")==null?"":(String)rs.getString("compress_note_content_yn"))){
				
				java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_note_content");
				if(note_blob!=null && note_blob.length()>0){
					InputStream ins1 = note_blob.getBinaryStream();
					ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
					int i;
					while((i = ins1.read()) != -1) 
						bytearrayoutputstream.write(i);
					
					byte[] compressed	=bytearrayoutputstream.toByteArray();
					if(compressed.length > 0){
						if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
							GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
							BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

							String line;
							while ((line = bufferedReader.readLine()) != null) {
								notes_content += line;
							}
						}					
					}
				}				
			}else{
			//6484 End.	
				clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");
				

				if(clob_notes_content!=null)
				{
					try
					{
						content_reader	= clob_notes_content.getCharacterStream();
						bf_content_reader = new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						notes_content = new String(arr_notes_content);
						bf_content_reader.close();
					}
					catch(Exception e)
					{
						out.println("Exception@2-readCLOB : "+e);
					}
				}				
			}	
			if(!notes_content.equals(""))
			{
				//IN044358 Start.
				String str="<th style=\"border-style:dashed;font-size:9pt;font-weight:boldl;\"";
				String str1="<td style=\"border-style:dashed;font-size:9pt;text-align:center;font-weight:bold;\"";
				notes_content = notes_content.replaceAll(str,str1);
				String str_ ="<th style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;\"";
				String str1_ ="<td style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;text-align:center;\"";
				notes_content = notes_content.replaceAll(str_,str1_);
				notes_content = notes_content.replaceAll("</th>","</td>");
				notes_content = notes_content.replaceAll("<!--","<!-- ");
				//IN044358 End.
				notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
				notes_content = notes_content.replaceAll("PAGE-BREAK-BEFORE: always;","");           //[IN056353]
				notes_content = notes_content.replaceAll("<HTML><BODY><PRE>","<PRE>");				//IN067635
				notes_content = notes_content.replaceAll("</PRE></BODY></HTML>","</PRE>");			//IN067635
				notes_content = notes_content.replaceAll("line-height: 100%"," ");			//IN068396
				int nIndex = notes_content.indexOf("<BODY onKeyDown='lockKey()'>");
				if(nIndex==-1)
				{
					nIndex = notes_content.indexOf("<BODY>");
				}
				int nIndex1 = notes_content.lastIndexOf("</BODY>");
				
				if(nIndex != -1 && nIndex1 != -1)
					notes_content1 = notes_content.substring(nIndex+6,nIndex1);
				else
					notes_content1 = notes_content;
			}

			pstDisTxt.setString(1,locale);
			pstDisTxt.setString(2,strNoteType);

			try
			{
				rsDisTxt	=	pstDisTxt.executeQuery();

				while(rsDisTxt.next())
				{
					discharge_summary_text = rsDisTxt.getString("DISCLIMER_TEXT") == null ? "" : rsDisTxt.getString("DISCLIMER_TEXT");
				}
				
				/*if(rsDisTxt.next())
					discharge_summary_text = rsDisTxt.getString("DISCLIMER_TEXT") == null ? "" : rsDisTxt.getString("DISCLIMER_TEXT");
				else
					discharge_summary_text =""; */
			}
			catch (Exception eDis)
			{
				out.println("Exception@2-readDisclaimer : "+eDis);
			}
			finally
			{
				if(rsDisTxt != null) rsDisTxt.close();
				if(pstDisTxt != null) pstDisTxt.close();

			}

			//shaiju starts
			
			try{
				//String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
				pstmt2	= con.prepareStatement(head_foot_qry);
				pstmt2.setString(1,note_type);
				rs2 = pstmt2.executeQuery();

				while(rs2.next())
					{
						note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
						footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
						report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
						waterMarkFlag = rs2.getString("WATERMARK_YN") == null ? "" : rs2.getString("WATERMARK_YN"); //IN059489
					}

		
			}
			catch(Exception ee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
		//--[IN029296] - Start
		
			try{
				pstmt2	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");//IN040205
				pstmt2.setString(1,patient_id);
				rs2 = pstmt2.executeQuery();
				//Date newDeceasedDt = null;//IN042733
				//Date new_event_date_time = null;//IN042733	

				while(rs2.next())
				{
					default_pat_name	= rs2.getString("patient_name") == null ? "" : rs2.getString("patient_name");
					//IN040205	- Start
					deceased_yn			= rs2.getString("deceased_yn") == null ? "" : rs2.getString("deceased_yn");
					deceased_date		= rs2.getString("deceased_date") == null ? "" : rs2.getString("deceased_date");
					//IN042733 Starts //IN050584 Starts
					/*if(!"".equals(deceased_date))
					{
						newDeceasedDt = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(deceased_date);
					}
					if(!"".equals(strEventDateTime))
					{
						new_event_date_time = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(strEventDateTime);
					}
					if("Y".equals(deceased_yn) && null!=new_event_date_time && null!=newDeceasedDt && new_event_date_time.after(newDeceasedDt) )
					{
						cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
					}*/
					//IN042733 Ends
					//IN040205	- end
				}
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
					
				String eventdate_isAfter_decdate = "";
				pstmt2	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL");
				pstmt2.setString(1,cal_eventdate);
				pstmt2.setString(2,deceased_date);
				
				rs2 = pstmt2.executeQuery();
				
				while(rs2.next())
				{
					eventdate_isAfter_decdate = rs2.getString("eventdate_isAfter_decdate");
				}
				
				if("Y".equals(eventdate_isAfter_decdate))
				{
					cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
				}
				//IN050584 Ends	
						
			}
			catch(Exception ee)
			{
				out.println("Exceptionin RecClinicalNotesPrint.jsp @ pstmt2 : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
		
		//--[IN029296] - End
		

		// Report Header starts
		try
			{
			
				//String rpt_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);	
				pstmt2.setString(1,report_header_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");

				

				if(clob_notes_content!=null)
				{
				try
					{
					//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			if(!accession_num.equals(""))
			{
					try
					{
						//String athorise_by_qry ="select a.AUTHORIZED_BY_ID ,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

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
							authorized_by_name		=	checkForNull( rs2.getString("AUTHORIZED_BY_NAME") ); //IN069484
							authorized_by_id		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );  //IN069484
							last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
							doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );

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
			encounter_id1 = encounter_id ;
			if(encounter_id.equals("0"))
			{
				encounter_id1 ="";
			}
			
			if(!visit_adm_date.equals(""))
			{
				visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
			}
			
			if(!discharge_date.equals(""))
			{
				discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
			}
			//IN067016--Starts
			if(!discharge_date_only.equals(""))
			{
				discharge_date_only					=	com.ehis.util.DateUtils.convertDate(discharge_date_only,"DMY","en",locale);
			}
			//IN067016--ends



			//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
			htParameter.put("V$ATT_PRACT", attending_practitioner);
			htParameter.put("V$ATT_PRACT_LT", attending_practitioner_list);//IN066807
			htParameter.put("V$ADM_PRACT", admitting_practitioner);
			//IN036821 - Start
			if(!performing_phy_name.equals(""))
			{
				htParameter.put("V$REP_PRACT", performing_phy_name);
			}
			else
			{
				htParameter.put("V$REP_PRACT", performing_phy_name1);
			}	
			//IN036821 - End
			htParameter.put("V$PT_SPLTY", speciality_name);
			//--[IN029296]  - Start
			if(patient_name.trim().equals(""))
			htParameter.put("V$PT_NAME", default_pat_name);
			else
			htParameter.put("V$PT_NAME", patient_name);
			//--[IN029296]  - End
			htParameter.put("V$PT_ID", patient_id);
			htParameter.put("V$SEX", Sex);
			//htParameter.put("V$AGE", age);//IN040205 
			htParameter.put("V$AGE", patient_age);//IN040205
			htParameter.put("V$ENC_ID", encounter_id1);
			htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
			htParameter.put("V$DIS_DT", discharge_date); //discharge_date
			htParameter.put("V$DIS_DATE", discharge_date_only); //discharge_date_only//IN067016
			htParameter.put("V$MED_SERV", med_service);
			htParameter.put("V$DOC_REF_H", doc_ref_id);
			htParameter.put("V$PT_LOCN", location_code); //patient_loc
			htParameter.put("V$PT_CLASS", patient_class);//patient_class
			
			//sectionContentUpdatedXML = new StringBuffer();
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
				//***************************** [CRF-118] Start *****************************					
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
				paramHash.put("#p_patient_id#",patient_id);
				paramHash.put("#p_encounter_id#",encounter_id1);
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

			if(!(sectionContentUpdatedXML.toString().equals("")))
						{								
							section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

						}


			//Report Header Ends


			// notes header
			section_content="";
			try
			{
			
				//String hdr_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);
				pstmt2.setString(1,note_header_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");

				

				if(clob_notes_content!=null)
				{
				try
					{
					//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}

				htParameter=new Hashtable();
				htParameter.put("V$PR_DATE", event_date_time);
				htParameter.put("V$NT_STATUS", note_status);
				htParameter.put("V$NT_TITLE", note_type_desc);
				htParameter.put("V$NT_TYPE", note_type);
				htParameter.put("V$PR_BY_PRACT", performing_phy_name);
				htParameter.put("V$DOC_REF_NH", doc_ref_id);
				htParameter.put("V$NT_MEDSRV", med_service);
				
			section_content_new = new StringBuffer(section_content);
			
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

			if(!(sectionContentUpdatedXML.toString().equals("")))
				{
					section_content_hdr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
				}


			// changes notes footer starts
			section_content= "";

			try
			{
			
				//String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);
				pstmt2.setString(1,footer_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");

				

				if(clob_notes_content!=null)
				{
				try
					{
					//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			//IN069484 Start.
			if(!"".equals(authorized_by_id)){
				try{
					pstmt2	= con.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
					pstmt2.setString(1,authorized_by_id);
					rs2 = pstmt2.executeQuery();
					while(rs2 !=null && rs2.next()){
						java.sql.Blob img_blob  =  (java.sql.Blob)rs2.getBlob("PRACTITIONER_SIGN");
						if(img_blob!=null){ //IN073450
						byte[] bytes = img_blob.getBytes(1, (int)img_blob.length()); 						
						authorized_sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
						} //IN073450
					}
				}catch(Exception se){
					se.printStackTrace();
				}finally
				{
					if(rs2 != null) rs2.close();
					if(pstmt2 != null) pstmt2.close();
				}
			}
			//IN069484 End.
			if(!printDateTime.equals(""))
			{
				printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
			}

			htParameter=new Hashtable();
			htParameter.put("V$CUR_USR", login_user_id);
			htParameter.put("V$AT_PRACT", authorized_by_name); //IN069484
			htParameter.put("V$AT_PRACT_SIGN", authorized_sign); //IN069484
			htParameter.put("V$LT_MODI_USR", last_amended_by);
			htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
			htParameter.put("V$DOC_REF_F", doc_ref_id);
			htParameter.put("V$LT_PT_P_C_D", pract_sign);

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
				if(tempParameter.size()>0)
				{					
					htParameter.putAll(tempParameter);
				}
			}
			//IN038439 Ends
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
			%>
			
			<!-- IN030419 Starts -->
			<%
			//if(printhdrindsyn.equals("Y"))
			//IN037045 - Start Modification - to have the td with 20,60,20 from 20,80
			if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("N")))
			{
			  
				if(!called_from.equals("printOnSign"))
				{ 
				//[IN032210] Start	
					if("Y".equals(imageLogoHeader)){
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr><td colspan='2'>");
						out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
						//IN066005 Start
						if(logo_Site_Facility.equals("S")){
						out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
						}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
						}out.println("</td></tr></table></td></tr>");//IN066005 end
						
						if("Y".equals(textLogoHeader)){
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
						//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
						//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						//IN066005 Starts
						if(logo_Site_Facility.equals("S")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}else if(logo_Site_Facility.equals("F")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}//IN066005 ends
						
						if("Y".equals(textLogoHeader)){				

							out.println("<td width='60%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='60%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");
							out.println("<td width='60%' colspan='2' align='center'>&nbsp;</td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							
							
						}else{
							out.println("<td width='80%' align='center'>&nbsp;</h3></td>");								
							out.println("</tr>");//IN037045
						}
						out.println("</table>");
					}

					//[IN032210] End
				}
				else
				{ 
					//out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' width='5%' id='headerImageID'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'></td><td  align=center><h3>"+site_name+"</h3></td></tr><tr><td>&nbsp;</td><td align=center><h3>"+facility_name+"</h3></td></tr><tr><td width='5%'>&nbsp;</td><td align=center><h4>"+note_type_desc+"</h4></td></tr></table><br>");	  //[IN032210]
					//[IN032210] Start
					if("Y".equals(imageLogoHeader)){
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr><td colspan='2'>");
						out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
						//IN066005 Start
						if(logo_Site_Facility.equals("S")){
						out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
						}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
						}out.println("</td></tr></table></td></tr>");//IN066005 end
						
						if("Y".equals(textLogoHeader)){
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");   //Commented for IN073450
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
						//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
						//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						//IN066005 Starts
						if(logo_Site_Facility.equals("S")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}else if(logo_Site_Facility.equals("F")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}//IN066005 ends
						
						if("Y".equals(textLogoHeader)){
							 out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");   //Commented for IN073450
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

					//[IN032210] End
				}
			}
			else if(printhdrindsyn.equals("N"))
			{ 
				//out.println("<br><br><br><br><br><br><br><br><br>"); //[IN032210]
			}
			%>
			<!-- IN030419 Ends -->
			<table border="0" width="100%"> 
			   <thead> 
				
            <%

			if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("Y")))
			{
				%>
				<tr> 
				 <th style="width:100%">
				<% 
				
					if(!called_from.equals("printOnSign"))
					{


						//[IN032210] Start	
						if("Y".equals(imageLogoHeader)){
							out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							out.println("<tr><td colspan='2'>");
							out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
							//IN066005 Start
							if(logo_Site_Facility.equals("S")){
							out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");	
							}
							out.println("</td></tr></table></td></tr>");//IN066005 end
							
							if("Y".equals(textLogoHeader)){
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
							//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
							//IN066005 Starts
							if(logo_Site_Facility.equals("S")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}//IN066005 ends
							if("Y".equals(textLogoHeader)){
								out.println("<td width='60%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
								out.println("<tr>");	
								out.println("<td width='60%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
								out.println("<tr>");
								out.println("<td width='60%' colspan='2' align='center'>&nbsp;</td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");	
							}else{
								out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
								out.println("</tr>");
							}
							out.println("</table>");
						}

						//[IN032210] End
					}
					else
					{ 

						//out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' width='5%' id='headerImageID'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'></td><td  align=center><h3>"+site_name+"</h3></td></tr><tr><td>&nbsp;</td><td align=center><h3>"+facility_name+"</h3></td></tr><tr><td width='5%'>&nbsp;</td><td align=center><h4>"+note_type_desc+"</h4></td></tr></table><br>"); //[IN032210]
						//[IN032210] Start
						if("Y".equals(imageLogoHeader)){
							out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							out.println("<tr><td colspan='2'>");
							out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
							//IN066005 Start
							if(logo_Site_Facility.equals("S")){
							out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");	
							}out.println("</td></tr></table></td></tr>");//IN066005 end
							
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
							//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>")//IN068669
							//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							//IN066005 Starts
							if(logo_Site_Facility.equals("S")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}//IN066005 ends
							if("Y".equals(textLogoHeader)){		
								 out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");    //Commented for IN073450
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
						//IN037045 - End Modification - to have the td with 20,60,20 from 20,80	
						//[IN032210] End
					}
					
					%>
					</th> 
					</tr> 

					<%
					if(rpt_hdr_all_pages.equals("N"))
					{
						%>
						<tr> 
				 <!--<th><hr style="color:#000080"/></th> IN032744-->
				 </tr>
						<%
					}
				}
				
			//IN030419 Starts
			if(rpt_hdr_all_pages.equals("Y") && !"".equals(section_content_rpt) && !"&nbsp;".equals(section_content_rpt))//IN070668
			{
			//IN030419 Ends
				%>
				
				<tr> 
				 <th style="width:100%">
				 <br>
			<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD"> //Commented for IN059489 -->
				<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;"> <!--Changed for IN059489-->
				<tr>
				<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_rpt%></font></td></tr>
				</table>
				<br>
				</th> 
				</tr>
				<tr> 
				<!-- <th><hr style="color:#000080"/></th> IN032744-->
				 </tr>
			<%} //IN030419
			%>
			
				
			   </thead> 
			   <tfoot  id="table_footer">
    <tr> 
     <td width="100%"> 
      <table width="100%" border="0"> 
        <tr> 
			<!--<th><hr style="color:#000080"/></th> IN032744-->
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
	  

			<%//if((flag)&&facility_id.equals("GN"))//[101]
			//{//[101]
			%>
			<!-- IN029312 Starts-->
			<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr>
			<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_rpt%></font></td></tr>
			</table>
			<br> -->
			<%//}//[101]%>
			<!--IN029312 Ends -->
			
			<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD">
			<tr>
			<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_hdr%></font></td></tr>
			</table> -->

			<!-- shs new 		To	-->
                <script>
					//document.write(a[1]);
				</script>
				<!-- IN030419 Starts -->
				<%
					if(rpt_hdr_all_pages.equals("N") && !"".equals(section_content_rpt) && !"&nbsp;".equals(section_content_rpt))//IN070668 
					{
				%>
						<table border="0" width="100%"> 
						<thead> 
						<tr> 
						<th style="width:100%">
						<br>
						<!--<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;:background-color:#ADADAD"> //Commented for IN059489-->
						<table border='1' cellpadding='0' cellspacing='0' width = '100%' style="font-family:Verdana;">  <!--Changed for IN059489-->
						<tr>
						<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_rpt%></font></td></tr>
						</table>
						<br>
						</th> 
						</tr> 
						<tr> 
						<!--<th><hr style="color:#000080"/></th> IN032744-->
						</tr>
						</thead> 
						</table>
					<%}%>
			   <!-- IN030419 Ends -->
			   <%     notes_content1 = notes_content1.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML-MMOH-SCF-2966
%>
 				<%=notes_content1%>

			<!-- shs new 		from	-->
			<!--IN029312 Starts-->
			<%//if((flag)&&facility_id.equals("GN"))//[101]
			//{//[101]
			if(!"".equals(section_content_ftr) && !"&nbsp;".equals(section_content_ftr)){//IN070668 
			%>
			<table width='100%' border=1 cellpadding=0 cellspacing=0 align=center>
				<tr>
					<td colspan="3" ><font style ="font-family:Verdana"><%=section_content_ftr%></font>
					</td>
				</tr>
			</table>
			<%
			}//IN070668 
			//}//[101]%>
			<!--IN029312 Ends-->

			<!-- shs new 		To	-->

			<script>//document.write(a[2]);</script>

			<%=discharge_summary_text%>
			<%
			
			} 
		 
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		//IN041924 Start.
		pstmt	=	con.prepareStatement("SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM ");
		rs		=	pstmt.executeQuery();
		if(rs.next()){
			note_print_time_interval			= Integer.parseInt(rs.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)rs.getString("NOTE_PRINT_TIME_INTERVAL"));
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
		//IN041924 End.
	}
		catch(Exception e)
	{
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</td> 
   </tr>
  </tbody> 
</table>
<!--IN004500 starts -->
<%if(sourceprintl!="" && sourceprintl.equals("CEH"))
{%>
<table width='100%' border=0 cellpadding=0 cellspacing=0 align=center>
<tr>
	<td colspan="3" ><font style ="font-family:Verdana">&nbsp;</font></td>
</tr>
<tr>
	<td colspan="3" ><font style ="font-family:Verdana"><%=display_dis_text_print%></font></td>
</tr>
</table>
<%}%>
<!--IN004500 ends -->
			<script>
			async function Print() 
				{
					if (document) {
						var i = 0;
						var res =await confirm('Continue printing?');
						if(res)  
						{
							while( i < document.applets.length ) 
							{
								var j = 0 ;
								while ( !document.applets[i].isActive() && j++ <=75000 ) 
									window.status = i;
								i++;
							}
							//Start.
							//window.print();
							//IN064446 Changes starts
							/*
							window.document.close();
							window.focus();
							window.print();
							window.document.close();
							*/
							<%if("Y".equals(ppFlag)){%>
							SysPreview();
							<%}else{%>
							//alert("1909");
							window.document.close();
							window.focus();
							window.print();
							window.document.close();
							<%}%>
							//IN064446 Changes Ends
							if('<%=appl_task_id%>'!='OT_NOTES')
							{
								//window.close();
								//alert("1918");
								setTimeout(function() { window.close(); }, <%=note_print_time_interval %>);
							}							
							return false;
							//End.
							//IN041924 Start.
							//setTimeout(function() { if('<%=appl_task_id%>'!='OT_NOTES'){window.close();} }, 1000);
							//setTimeout(function() { if('<%=appl_task_id%>'!='OT_NOTES'){window.close();} }, <%=note_print_time_interval %>);
							//IN041924 End.
							//[IN038088] Start	
							/*if('<%=appl_task_id%>'!='OT_NOTES')
							{
								window.close();
							}*/
							
						}else{
						//[IN038088]  End
							if('<%=appl_task_id%>'!='OT_NOTES')
							{
								//alert("1937");
								window.close();
								
								/* const dialogTag = parent.parent.document.getElementById("dialog_tag");    
								dialogTag.close();  */
							}
						}
					}
				}
			</script>
</form>
</body>
<!--IN059489 Start -->
<%if (waterMarkFlag.equals("Y") && ("1".equals(status) || "3".equals(status))  ) {%>

<style>
body{
	background-image : url('../../eCA/images/Draft.jpg');
	background-repeat: no-repeat;
	 background-position: 100 100 50 50;
	}
</style>

<%}%>
<!--IN059489 Ends -->
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


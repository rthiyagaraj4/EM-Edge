<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------
?             100            ?           	created
10/10/2011	  IN29171		 DineshT	 	Changes done to show some of the missing records in the thai language
15/10/2011	  IN29171		 MenakaV	 	OR>Existing Order>Result Print Preview webpage.
											In English screen after click print preview, some result disappear.
27/01/2012	  INO30714		Menaka V		THAI screen>View Clinical Event History>View>In the Recorded
											Clinical Note the name is not displayed in THAI
08/02/2012	  IN030996		Menaka V	 	CA>Patient Chart>Clinical event history>When the already recorded details
											are accessed we get Java Lang null pointer exception Script Error. 	
12/09/2012    IN033152      Chowminya G  	Changed 'ext_image_appl_id' to 'Result' in alt 	
17/10/2012    IN029203		Ramesh G		Result reporting > Print preview > Result is not good alignment. 
											It happened in both Thai and English language.		
29/10/2012	  IN029396	
14/12/2012	  IN031684		Ramesh G		Group test name is not showing in from Order management function.	
07/01/2012	  IN032246		Ramesh G 		Result view from Existing Orders, doesn't show the similar format as it's shows on the Print Preview 
											and LIS (View/Print Draft Copy).	
25/02/2013	  IN037045	    Chowminya G		CA Report logo/header alignment
09/04/2013    IN039067      Ramesh G        RD result aligment  
03/06/2013	  ConnProb	 	Ramesh G	    Connection Closed								
07/06/2013    IN037725	    Chowminya G     Age n Gender of the patient is displaying on the same line as the patient ID
11/06/2013    IN039361      Ramesh G        RD result aligment 	
12/06/2013    IN040745		Chowminya G     Resulted Values are not displaying in Result - Laboratory Order Webpage 
11/10/2013	  IN043940		Ramesh G		Place an Order Set for which single order ID to be generated-
											Register-Do Result reporting for Placed Order Set.
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality	
-----------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
-----------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
18/04/2013	IN041256		Ramesh G		18/04/2014		Akbar S			The entered text is displayed with more spacing available for each  line. 
																				Click on print ->Some part of data is trimmed in print out page.
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
01/12/2014	IN052367		ChowminyaG 										Signature not published in Result linked clinical notes
17/12/2014	IN053047		Ramesh G		17/12/2014		Akbar S			In Order Tracking , when user try to print the Radiology report like below , it gets truncated in print out....
20/03/2015	IN054648		Ramesh G		20/03/2015		Akbar S			RESULTED REPORT RANGE COMMENTS ARE DISPLAYING IN OR.NOTE: REPORT RANGE COMMENT SETUP IS <REPORT RANGE COMMENT>
21/07/2015  IN056353		Ramesh G		21/07/2015      Akbar S			GHL-SCF-942 : Radilogy report blank page printout
24/3/2016	IN058811		Raja S			24/03/2016		Ramesh G		MO-CRF-20107 :National ID to be captured in any orderable (ALL 																				Order Categories) is a national requirement.
07/08/2017	IN062473		Raja S			07/08/2017		Ramesh g		SKR-SCF-1144
07/02/2018	IN065970		Vijayakumar K		07/02/2018		RameshGo	ML-BRU-SCF-1611.1 [IN:065970]
14/03/2018	IN066982		Kamalakannan G	14/03/2018		Ramesh G		report practitioner name is not displaying
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
06/01/2020	IN072011		Sivabagyam		06/01/2020		Ramesh G		Common-ICN-0015
21/02/2020	IN072540	SIVABAGYAM M		21/02/2020		RAMESH G		MO-GN-5553
12/05/2020	IN072988	Ramesh Goli			12/05/2020		RAMESH G		OR-PMG2020-TECH-CRF-0005/01-Print Preview Result
06/06/2020	IN071753		Abhishek M		09/06/2020		Ramesh G		SKR-SCF-1298
02/11/2022  35142           Krishna Pranay  03/11/2022  Ramesh G        TH-KW-CRF-0020.6
-----------------------------------------------------------------------------------------------------------------------------------------------------
*/

%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@page import="java.sql.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	%>
<html>
<head><title><fmt:message key="Common.Printing.label" bundle="${common_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
 	<script language="JavaScript" src="../js/ResultOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script Language="vbscript">
		Dim WSHShell
		Dim myHeader
		Dim myFooter
		Dim myMarginleft 
		Dim myMarginright 
		Set WSHShell = CreateObject("WScript.Shell")
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<STYLE>
		PRE.RESULTTEXTAREAEVEN
		{
			font-size: 10pt ;
			/* IN043895 Start*/
			/*Font-Family : Courier New;*/
				/*IN049424 Start.*/			
				/*Font-Family : "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";*/
				FONT-FAMILY: Verdana ;
				/*IN049424 End.*/
			/* IN043895 End.*/
			BACKGROUND-COLOR: #F0F0F2;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			word-break: break-all; /* webkit */
			word-wrap: break-word;
			white-space: pre;
			white-space: -moz-pre-wrap; /* fennec */
			white-space: pre-wrap;
			white-space: pre\9; /* IE7+ */	
			margin:0;
			padding:0;
		}	
		
		PRE.RESULTTEXTAREAODD
		{
			font-size: 10pt ;
			/* IN043895 Start*/
			/*Font-Family : Courier New;*/
				/*IN049424 Start.*/			
				/*Font-Family : "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";*/
				FONT-FAMILY: Verdana ;
				/*IN049424 End.*/
			/* IN043895 End.*/
			BACKGROUND-COLOR: #E2E3F0;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			word-break: break-all; /* webkit */
			word-wrap: break-word;
			white-space: pre;
			white-space: -moz-pre-wrap; /* fennec */
			white-space: pre-wrap;
			white-space: pre\9; /* IE7+ */
			margin:0;
			padding:0;
		}	
		PRE
		{
			font-size: 10pt ;
			/* IN043895 Start*/
			/*Font-Family : Courier New;*/
				/*IN049424 Start.*/			
				/*Font-Family : "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";*/
				FONT-FAMILY: Verdana ;
				/*IN049424 End.*/
			/* IN043895 End.*/
			BACKGROUND-COLOR: #E2E3F0;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			word-break: break-all; /* webkit */
			word-wrap: break-word;
			white-space: pre;
			white-space: -moz-pre-wrap; /* fennec */
			white-space: pre-wrap;
			white-space: pre\9; /* IE7+ */
			margin:0;
			padding:0;
		}	
		
		TD.LABEL1
		{
		  COLOR:#444444;
		  background-color:#FFFFFF;
		  FONT-SIZE: 8pt;
		  TEXT-ALIGN: CENTER;

		}
		/* IN043895 Start*/
			/* IN049424 Start.*/
				/*ADDRESS	{ 
					FONT-FAMILY: "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS" ;
					FONT-SIZE: 10pt ; 
					FONT-STYLE: NORMAL; 
					COLOR: BLACK; 
				}*/
				ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
			/* IN049424 End.*/			
		/* IN043895 End.*/
	</STYLE>

</head>
<body onLoad='' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<Form name='view_order_prn' id='view_order_prn'>
<%
	String mode	   = "1";
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String bean_id1 = "Or_ViewOrder" ; 
	String bean_name1 = "eOR.ViewOrder";
	String orderId = request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");
	String patient_id = request.getParameter("patient_id");
	String ord_cat = request.getParameter("ord_cat");
	String order_status = request.getParameter("order_status");
	String pract_reln_id = request.getParameter("pract_reln_id");
	String screen_width = request.getParameter("screen_width");
	String view_by = request.getParameter("view_by");//IN061961
	String event_code1=request.getParameter("event_code"); //IN061961
	//int detail_text_width=900;//commented for IN061961
	int colswidth = Integer.parseInt(screen_width)/4;
	int colwidth = Integer.parseInt(screen_width)/2;
	colswidth =150;
	colwidth = 400;		
	String facility_id = (String)session.getValue("facility_id");
	String resp_id		= (String)session.getValue("responsibility_id");
	//String toolTipTextArea = "Double Click to Zoom";Commented by Uma on 4/28/2010 for IN020979
	if(resp_id== null)	
		resp_id = "";

	if(order_line_num.equals("") || order_line_num == null)	
		order_line_num = "";

	if (order_status == null) 
		order_status = "";

	String[] allValues = new String[43];
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	allValues		= bean.viewPrintDetails(orderId);
	String order_type_code = bean.checkForNull(allValues[39]);
	ArrayList allValues1 = new ArrayList();
	ViewOrder bean1 = (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean1.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean1.clear() ;
	bean1.setMode(mode) ;
	String result_data[] = (String[])bean1.getAbnormalCondition();	
	String high_str			= result_data[0];
	String low_str			= result_data[1];
	String abn_str			= result_data[2];
	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String location="";
	String patient_details="";				 
	String slClassValue = "", textClassValue= "";	
	String encounterdate = "";
	String sex1 = "";
	//IN042552 Start.
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
	//allValues1		= bean1.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status, pract_reln_id);
	allValues1		= bean1.viewResultDetail(orderId,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status, pract_reln_id,clinician_id,event_code1,view_by);//IN061961
	//IN042552 End.
	TreeMap first_map = null;
	ArrayList 	 panels		= 	bean1.panels ;
	String header_time="";
	TreeMap header_all_times = (TreeMap)bean1.getAllTimes(9,allValues1);	
	Set header_all_times_set = (Set)header_all_times.keySet();
	Iterator header_itr_times = (Iterator)header_all_times_set.iterator() ;			
	header_itr_times = (Iterator)header_all_times_set.iterator() ;
	
	while(header_itr_times.hasNext())
	{
		//Iterate Time values of header
		header_time = (String)header_itr_times.next();
	}
	//INO30714 Starts
	java.util.Properties pr = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) pr.getProperty("LOCALE");
	String		performed_by_id	=	"" ;
	String accession_num			= "";
	String		patient_class		=	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String		encounter_id	=	request.getParameter("encounter_id");
	String		facility_name	=	"" ;
	String		visit_adm_date	=	"" ;
	String		attending_practitioner	=	"" ;
	String		admitting_practitioner	=	"" ;
	String		bed_number	=	"" ;
	String		performing_phy_name	=	"" ;
	String		age	=	"" ;
	String		gender	=	"" ;
	String		patient_name	=	"" ;
	String		speciality_name	=	"" ;
	String		printDateTime	=	"" ;
	String		site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String		query_privilege_type	=	"" ;
	Connection			con			=	null;
	PreparedStatement	pstmt2			=	null;
	ResultSet			rs2				=	null;
	PreparedStatement	pstmt			=	null;
	ResultSet			rs				=	null;
	String  url1					=	"";
	String  url						=	"";
	String footer_code = null;
	String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	//url   = HttpUtils.getRequestURL(request).toString(); //IN072011
	//url = url.substring(0,url.indexOf("jsp/"));	
	url	= application.getRealPath("/eOR")+"/";//ADDED FOR COMMON-ICN-0015
	url = url.substring(0,url.indexOf("eOR/")); //IN072988
	url1 = url + "eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	url =url+"eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String	login_user_id		=	(String)session.getValue("login_user");
	String  sect_template_query		=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String acc_for_notefooter = "";//IN052367
	//IN066982 Changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN066982 changes ends
	HashMap<String,String> paramMap = null;
	
	try
	{
	con	= ConnectionManager.getConnection();
	//sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
	isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER");//IN066982
	if(	episode_type.equals("O") )
			{
				
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
			}
			else
			{ 
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
			}
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
			pstmt.setString	(	11,	facility_id	);
			pstmt.setString	(	12,	encounter_id);

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				patient_class	=	rs.getString("patient_class") == null ? "" : rs.getString("patient_class");
				facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
				med_service			=	rs.getString("service_name")==null?"":rs.getString("service_name");
				discharge_date		=	rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
				admitting_practitioner	=	rs.getString("admitting_practitioner")==null?"":rs.getString("admitting_practitioner");
				bed_number	=	rs.getString("bed_number")==null?"":rs.getString("bed_number");	  //--[IN:029839]--
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


			
			}

				if(gender.equals("M"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				if(discharge_date==null)
				{
					discharge_date="";
				}
				if(patient_class.equals("OP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null)	rs.close();
				if(pstmt!=null)	pstmt.close();
			}
			
	//INO30714 ends
	ArrayList 	 discrete	=	bean1.discrete ;
	String [] print_details = {"","","","","","",""};
    print_details = (String[])bean.getOrderDetails(orderId);
    order_status = print_details[6];
	/*ADDED BY Deepa */
	ArrayList repPractList = new ArrayList();
	String textToolTip = "";
	String repPract = "";
	String repPractName = "";
	String status = "";
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40"; //IN068669
	try
	{
		repPractList = (ArrayList) bean1.getRepPractCnt(orderId,order_line_num,patient_id,resp_id,facility_id,request.getParameter("ord_cat"),order_status,cont_order_ind);
	
		if(repPractList.size() > 0)
		{
			repPract = (String) repPractList.get(0);	
			repPractName = (String) bean1.getRepPractName(repPract, localeName);

			if(repPractList.size() == 1) 
			{
				repPractName = repPractName;
				textToolTip = "";
			}
			else 
			{
				repPractName = repPractName + " * ";
				textToolTip = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.multipleRepPract.label","or_labels");;
			}
		}
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
	/*ADDED BY Deepa */
	
	ArrayList practitionerDetails = new ArrayList();	
	practitionerDetails = bean.getPractitionerDetails(orderId,cont_order_ind,facility_id,request.getParameter("ord_cat"),order_type_code);	
	int timeHeader = 0;

	if (practitionerDetails.size() == 2) 
		timeHeader = 1;

	if(allValues[2] == null  || allValues[2].equals("null") || allValues[2].equals(""))
	{
		allValues[2] = "R";
	}

	if(allValues[2].compareTo("R")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	}
	else if(allValues[2].compareTo("U")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
	}
	else if(allValues[2].compareTo("S")==0)
	{
		allValues[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
	}	

	if(allValues[3] == null) 
		allValues[3] = "";
	
	if(allValues[3].equalsIgnoreCase("M"))
	{
		sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	}
	else if(allValues[3].equalsIgnoreCase("F"))
	{
		sex1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	}
	
	if(allValues[36] == null) 
		allValues[36] = "";

	if(allValues[36].equalsIgnoreCase("C"))
	{
		location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("N"))
	{
		location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	}
	else if(allValues[36].equalsIgnoreCase("R"))
	{
		location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
	}

	//patient_details = allValues[35]+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"/"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+" "+allValues[34]+"/"+sex1;
	//Commentted IN037725
	patient_details = allValues[35]; //IN037725
	//IN068669 STARTS
	try
	{	
		con	= ConnectionManager.getConnection();
		pstmt =	con.prepareStatement("select LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT FROM ca_note_param");
		rs	=	pstmt.executeQuery();
		if(rs.next())
		{
			LOGO_HDR_WIDTH	= rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH");
			LOGO_HDR_HEIGHT	= rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT");
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
    }
	catch(Exception e)
	{
		//out.println("Exception@111 - in getting logo and report header: "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
//IN068669 ENDS
%>

<table cellpadding=3 cellspacing=0 border=0 width="100%">
<tr><td>
<table cellpadding=3 cellspacing=0 border=0 width="100%" class="grid"> <!--Made changes to the table tag content for header center alignment - IN037045  -->
	<tr>
		<tr>
		<!--<td align='left' width='5%' rowspan="4">--><!--IN068669-->
			<td align='left' width='5%' rowspan="5"><!--IN068669-->
			<!-- <img valign='top' src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'  border='0'></img>-->
			<img valign='top' src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width=<%=LOGO_HDR_WIDTH%> height=<%=LOGO_HDR_HEIGHT%> border='0'></img><!-- IN068669 -->
		</td>
		</tr>
		<td  class="label1" width='88%' nowrap align="center"><Font size='3'><B><%=(bean.printSiteName()==null)?"":bean.printSiteName()%></B></Font></td>
		<td class="label1" width=''></td>
	</tr>
	<TR>
		<TD class='label1' width='88%' align="center"><Font size='3'><B><%=(bean1.getFacilityName() == null)? "" : bean1.getFacilityName()%></B></Font></TD>
		<td class="label1" width=''></td>
	</TR>
	<TR>
		<TD class='label1' width='88%' align="center"><Font size='3'><B><%=(allValues[0] == null)? "" : allValues[0]%></B></Font></TD>
		<td class="label1" width=''></td>
	</TR>
	<TR>
		<!--<td class="label1" width='6%' nowrap></td>--><!--IN068669-->
		<!--<td class="label1" width='32%'></td> -->
		<TD class='label1' width='88%' nowrap align="center"><Font size='3'><B><%=(allValues[1] == null)? "" : allValues[1]%>&nbsp;&nbsp;<fmt:message key="eOR.ResultReports.label" bundle="${or_labels}"/></B></Font></TD>
		<td class="label1" width=''></td>
	</TR>

</table>
</TD></TR>
<TR><TD>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align="center">
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[6] == null)? "" : allValues[6]%></B></td>
		<td class='label' nowrap width="25%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[4]==null)?"":allValues[4]%></B></td>
	</tr>
<%
	encounterdate = allValues[12];

	if(encounterdate == null) 
		encounterdate = "";

	if(encounterdate.contains("/"))
	{
		if(encounterdate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(encounterdate,"DMYHMS",localeName))
			{
				encounterdate = com.ehis.util.DateUtils.convertDate(encounterdate,"DMYHMS","en",localeName);
			}
		}
		else if(encounterdate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(encounterdate,"DMYHM",localeName))
			{
				encounterdate = com.ehis.util.DateUtils.convertDate(encounterdate,"DMYHM","en",localeName);
			}
		}
		else if(encounterdate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
		{
			 if(com.ehis.util.DateUtils.validDate(encounterdate,"DMY",localeName))
			{
				encounterdate = com.ehis.util.DateUtils.convertDate(encounterdate,"DMY","en",localeName);
			}
		}
	}
	
	if(header_time == null) 
		header_time = "";

	if(header_time.contains("/"))
	{
		if(header_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(header_time,"DMYHMS",localeName))
			{
				header_time = com.ehis.util.DateUtils.convertDate(header_time,"DMYHMS","en",localeName);
			}
		}
		else if(header_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
		{
			if(com.ehis.util.DateUtils.validDate(header_time,"DMYHM",localeName))
			{
				header_time = com.ehis.util.DateUtils.convertDate(header_time,"DMYHM","en",localeName);
			}
		}
		else if(header_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
		{
			if(com.ehis.util.DateUtils.validDate(header_time,"DMY",localeName))
			{
				header_time = com.ehis.util.DateUtils.convertDate(header_time,"DMY","en",localeName);
			}
		}
	}
%>
	<!-- IN037725  Changed Alignement of elements-->
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='label' wrap width="25%"><B><%=(patient_details== null)? "" : patient_details%></B></td>
		<td class='label' nowrap width="25%"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[12]==null)?"":encounterdate%></B></td>
	</tr>
	
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.age.label" bundle="${common_labels}"/>/<fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[34]==null)?"":allValues[34]%>/<%=(sex1== null)? "" : sex1%></B></td> <!-- IN037725 -->
		<td class='label' nowrap width="25%"><fmt:message key="Common.OrderNo.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(orderId==null)?"":orderId%></B></td>
		
	</tr>
	
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[39]== null)? "" :allValues[39]%></B></td>
		<td class='label' nowrap width="25%"><fmt:message key="eOR.NationalId.label" bundle="${or_labels}"/></td><!-- IN058811 New Label-->
		<td class='label' width="25%"><B><%=(allValues[40]== null)? "" :allValues[40]%></B></td><!-- IN058811 New Label -->
	</tr>
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.no.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[40]== null)? "" :allValues[40]%></B></td>
		<td class='label' nowrap width="25%"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td> <!-- IN058811 changed order-->
		<td class='label' width="25%"><B><%=(allValues[12]==null)?"":encounterdate%></B></td> <!-- IN058811 changed order-->
	</tr>
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.OrderLocation.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=location%>/<%=allValues[38]%></B></td>
		<!-- IN058811 start changed order-->
		<%
	if(allValues[41].equalsIgnoreCase("IBARL"))
	{
%>
		<td class='label' nowrap width="25%"><fmt:message key="eOR.SpecimenCollectedTime.label" bundle="${or_labels}"/></td>
<%
	}
	else
	{
%>
		<td class='label' nowrap width="25%"><fmt:message key="eOR.ReportingDate.label" bundle="${or_labels}"/></td>
<%
	}
%>
		<td class='label' width="25%"><B><%=(header_time==null)?"":header_time%></B></td> 
	<!-- IN058811 Ends changed order-->	
	</tr>
	<tr>
		<td class='label' nowrap width="25%"><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<td class='label' width="25%"><B><%=(allValues[7]== null)? "" :allValues[7]%></B></td>
		<td class='label' nowrap width="25%"><fmt:message key="eOR.ReportingPractitioner.label" bundle="${or_labels}"/></td> <!-- IN058811 changed order-->
		<td class='label' width="25%" title='<%=textToolTip%>'><B><%=repPractName%></B></td><!-- IN058811 changed order--> 

	</tr>
<%
	if(allValues[10] == null) 
		allValues[10] = "";

	ArrayList order_format_dtl = bean1.getOrderFormatDetail( orderId ) ;

	if(order_format_dtl.size()>0)
	{
%>
	<tr>
		<td class="label" colspan="4"><hr color=thickblue height=1></td>
	</tr> 	
	<tr>
		<td  class='label'><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></td>
		<td class='label'  colspan=3 wrap style='<%if(order_format_dtl.size() > 0)out.println("BACKGROUND-COLOR: #637BBD ;");%>'>
<%
	}
%>
	
<table cellpadding=3 cellspacing=0 border=0 align=center width='100%' class='label'>
<%
	int j=0;
	String checked = "";
	
	for(int i=0; i<order_format_dtl.size(); i++)
	{
		String ordr_record[] = (String[])order_format_dtl.get(i);

		if(ordr_record[2] == null) 
			ordr_record[2] = "";

		if(!ordr_record[2].equals(""))
		{
			if(i%1 == 0)
			{
				out.println("<tr>");
				j++;
			}

			if(ordr_record[0].equals("A"))
			{
%>
				<td class="label"  width="36%"><font size=1><%=ordr_record[1]%></td>
<%
				if(ordr_record[2] == null) 
					ordr_record[2] = "";
%>
				<td class="fields" width="64%"><font size=1><B><%=ordr_record[2]%></B></td>
<%
			}
			else if(ordr_record[0].equals("C"))
			{
 				if((ordr_record[2].trim()).equalsIgnoreCase("N") || (ordr_record[2].trim()).equals(""))
					checked = "No";
				else 
					checked = "yes";
%>
				<td class=label   width='36%'><font size=1><%=ordr_record[1]%></td>
<%
				if(ordr_record[2] == null) 
					ordr_record[2] = "";
%>
				<td  width='64%'><font size=1><B><%=checked%></B></td>
<%
			}
			else
			{
%>
				<td class=label  width='36%'><font size=1><%=ordr_record[1]%></td>
<%
				if(ordr_record[2] == null) 
					ordr_record[2] = "";
%>
				<td width='64%' class=label><font size=1><B><%=ordr_record[2]%></B></td>
<%
			}
		}
	}
	
	if(order_format_dtl.size()>0)
	{
%>
		</table>
		</td>
		</tr>	
		<tr>
			<td class="label" colspan="4"><hr color=thickblue height=1></td>
		</tr>
<%
	}

	String max_num = "0";
	String reportingTime = "";
	String max_action_seq_num		= allValues[29];
	
	if(max_action_seq_num == null)
		max_action_seq_num = "";
	else 
		max_action_seq_num = max_action_seq_num.trim();
		
	max_num = max_action_seq_num;
%>
	<tr>
		<td class='label' width="25%" wrap><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>:</td>
		<td class='label' colspan="3" width="75%" wrap><%=bean1.getComments(orderId,max_num)%></td>
	</tr>
<%
	if(allValues[41].equalsIgnoreCase("IBARL"))
	{
		/*Added by Uma on 12/1/2010 for IN025168*/
		reportingTime = (String)allValues[42];
		reportingTime = com.ehis.util.DateUtils.convertDate(reportingTime,"DMYHM","en",localeName);
		/*Ends Here*/
%> 
		<tr>
			<td class='label' width="25%" wrap><fmt:message key="eOR.ReportingTime.label" bundle="${or_labels}"/></td>
			<td class='label' colspan="3" width="75%" wrap><B><%=reportingTime%></B></td>
		</tr>
<%
	}
%>	
</table>
</TD></TR>
<TR><TD>
<%	
	if(allValues1.size() == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
	}
	else 
	{
		first_map = (TreeMap)bean1.traverseList(1,allValues1,first_map);
		TreeMap second_map = (TreeMap)bean1.traverseList(2,allValues1,first_map);
		TreeMap third_map = (TreeMap)bean1.traverseList(9,allValues1,second_map);
		TreeMap all_times = (TreeMap)bean1.getAllTimes(9,allValues1);
		HashMap key_value_map1 = (HashMap)bean1.getKeyValueData1();
		HashMap key_value_map2 = (HashMap)bean1.getKeyValueData2();
		Set all_times_set = (Set)all_times.keySet();
		Iterator itr_times = (Iterator)all_times_set.iterator() ;
		//int panel=0;//commented for checkstyleIN061961
		int header=0;
		String reporting_practitioner = "";
		out.println("<table cellpadding=0 cellspacing=0 border=1 width='100%'>");
		String dup_time="";			
		int i = 1;
		//boolean main_hdr = true;//commeneted for checkstyleIN061961
		String temp_panel_key="";  //[32119]
		for(int K = 0 ; K < panels.size() ; K++)
		{
			// panel Iteration
			String ext_image_obj_id		= "";
			String ext_image_appl_id	= "";
			String hist_rec_type			= "";//IN066982
			String panel_key = (String)panels.get(K);
			TreeMap dscr_map = (TreeMap)third_map.get(panel_key);			
			itr_times = (Iterator)all_times_set.iterator() ;
			
			while(itr_times.hasNext())
			{
				//Iterate Time values of header
				String hdr_time = (String)itr_times.next();
				//boolean hdr_req = true;//commented for checkstyleIN061961
			
				for(int l = 0; l < discrete.size(); l++)
				{ 
					// descr iteration
					//Added by Siva Kumar on 10/9/2003
					String color = "";
					String toolTipText = "";
					reporting_practitioner = "";
					//End of Addition
					if(i % 2 == 0)
					{
						slClassValue = "QRYEVEN";
						textClassValue = "RESULTTEXTAREAEVEN";
					}
					else
					{
						slClassValue = "QRYODD";
						textClassValue = "RESULTTEXTAREAODD";
					}
					String dscr_key =  (String)discrete.get(l);

					if(!dscr_map.containsKey(dscr_key.trim()))
						continue ;
					//Added by Siva Kumar on 10/9/2003
			        TreeMap time_val_map = (TreeMap)dscr_map.get(dscr_key);
								
					Object obj = time_val_map.get(hdr_time);
					
					
					if(obj != null)
					{
						String value_arr[] = (String[]) obj;%>
						<%
							//if (value_arr.length == 33)   Ramesh 
							//IN040745 changed array length from 34 to 35
							//if (value_arr.length == 36) IN064132
							if (value_arr.length == 39)//IN066982 changes 36-37 
							{
								if (value_arr[22] != null && (!(value_arr[22]).equals(""))) 
								{
									if (value_arr[22].equals("*LB_REFLEX_REG*")) 
									{
										color = "LIGHTYELLOW";
										textClassValue = "RESULTTEXTAREAYELLOW";
										toolTipText = "This test is ordered at the time of Registration";
									}
									else if (value_arr[22].equals("*LB_REFLEX_RES*")) 
									{
										color = "TAN";
										textClassValue = "RESULTTEXTAREATAN";
										toolTipText = "This test is ordered at the time of Resulting based on Reflex Test";
									}
									else if (!value_arr[22].equals(request.getParameter("practitioner_id"))) 
									{
										color = "Gray";
										textClassValue = "RESULTTEXTAREAGRAY";
										toolTipText = "ordered by : " + value_arr[22];
									}
								}
								ext_image_obj_id = (value_arr[23]==null)?"":value_arr[23];
								ext_image_appl_id = (value_arr[24]==null)?"":value_arr[24];

								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/
								
								reporting_practitioner  = value_arr[25];
								if(reporting_practitioner == null){ //IN066982
									reporting_practitioner = "";
								} 
								/*commtented for IN066982
								if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									if(!repPract.equals(reporting_practitioner) && !reporting_practitioner.equals(""))
										reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean1.getRepPractName(reporting_practitioner,localeName);
									else
										reporting_practitioner = "";
								}
								else
								{							
									reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :"; 
								}*/
								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/

							hist_rec_type			= (value_arr[26]==null)?"":value_arr[26];//IN066982
									/*IN066982 starts*/
									if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
									{
										resulted_practitioner = (value_arr[35]==null)?"":value_arr[35];
										if(resulted_practitioner != null && !resulted_practitioner.equals(""))
										{
											reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean1.getRepPractName(resulted_practitioner,localeName);
											
										}
									}
									else{
										if(reporting_practitioner != null && !reporting_practitioner.equals(""))
										{
											reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean1.getRepPractName(reporting_practitioner,localeName);
										}
										
									}
									/*IN066982 ends*/
							} 
							//else if (value_arr.length == 35) //IN064132 changes to 34 //IN066982//IN070610
							else if (value_arr.length == 37) //IN064132 changes to 34 //IN066982//IN070610
							{
								//INO30714 Starts
								accession_num			= (value_arr[27]==null)?"":value_arr[27];
								try
								{
									
									//String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
									String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE_DESC=?";
									pstmt2	= con.prepareStatement(head_foot_qry);
									
									//pstmt2.setString(1,"2345");
									pstmt2.setString(1,(String)key_value_map2.get(dscr_key));
									rs2 = pstmt2.executeQuery();

									while(rs2.next())
									{
										//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
										footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
										report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
									}

			
								}
								catch(Exception ee)
								{
								//	out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
									ee.printStackTrace();
								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//if(con!=null) con.close();
								}
								
								try
								{
									sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
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
												//out.println("Exception@1-readCLOB : "+e);/COMMON-ICN-0181
												e.printStackTrace();
											}


										}
									}
								}

								catch(Exception eee)
								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
									eee.printStackTrace();

								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//if(con!=null) con.close();
								}
							if(!accession_num.equals(""))
							{
								ext_image_obj_id		= (value_arr[22]==null)?"":value_arr[22];//IN052367
								try
								{
									String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

									pstmt2	= con.prepareStatement(athorise_by_qry);
									pstmt2.setString(1,locale);
									pstmt2.setString(2,locale);
									pstmt2.setString(3,locale);
									pstmt2.setString(4,locale);
									//IN052367 - Start
									if(accession_num.contains("!"))
										acc_for_notefooter = ext_image_obj_id;
									else
										acc_for_notefooter = accession_num;
										
									pstmt2.setString(5,acc_for_notefooter);
									//pstmt2.setString(5,accession_num);
									//IN052367 - End
									pstmt2.setString(6,patient_id);
									rs2 = pstmt2.executeQuery();
									while(rs2.next())
									{
										//authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
										//last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
										//doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
										//authorized_by		=	rs2.getString("AUTHORIZED_BY_ID") ;
										//last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID");
										//doc_ref_id		=	 rs2.getString("DOC_REF_ID") ;
										authorized_by		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
										last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
										doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996
										
									}
								}
								catch (Exception roro )

								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());//COMMON-ICN-0181
									roro.printStackTrace();

								}
								finally 
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//if(con!=null) con.close();
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



							//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
							htParameter.put("V$ATT_PRACT", attending_practitioner);
							htParameter.put("V$ADM_PRACT", admitting_practitioner);
							htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
							htParameter.put("V$PT_SPLTY", speciality_name);
							//--[IN029296]  - Start
							if(patient_name.trim().equals(""))
								htParameter.put("V$PT_NAME", default_pat_name);
							else
								htParameter.put("V$PT_NAME", patient_name);
							//--[IN029296]  - End
							htParameter.put("V$PT_ID", patient_id);
							htParameter.put("V$SEX", Sex);
							htParameter.put("V$AGE", age);
							htParameter.put("V$ENC_ID", encounter_id1);
							htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
							htParameter.put("V$DIS_DT", discharge_date); //discharge_date
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
								sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
							}

							if(!(sectionContentUpdatedXML.toString().equals("")))
							{								
								section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
								//section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
								
							}
						//Report Header Ends
						
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
										//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
										e.printStackTrace();
									}


								}
							}
						}

						catch(Exception eee)
						{
							//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
							eee.printStackTrace();

						}
						finally
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();
						}

						if(!printDateTime.equals(""))
						{
							printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
						}

						htParameter=new Hashtable();
						htParameter.put("V$CUR_USR", login_user_id);
						htParameter.put("V$AT_PRACT", authorized_by);
						htParameter.put("V$LT_MODI_USR", last_amended_by);
						htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
						htParameter.put("V$DOC_REF_F", doc_ref_id);
						htParameter.put("V$LT_PT_P_C_D", pract_sign);

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
						//Footer Ends
					//INO30714 Ends
					
						if(value_arr.length == 39)
						{
							ext_image_obj_id	= (value_arr[23]==null)?"":value_arr[23];
							ext_image_appl_id	= (value_arr[24]==null)?"":value_arr[24];
						}else if(value_arr.length == 37)//IN070610
						{
							ext_image_obj_id	= (value_arr[22]==null)?"":value_arr[22];
							ext_image_appl_id	= (value_arr[23]==null)?"":value_arr[23];
						}
								

								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/
								reporting_practitioner = value_arr[24]==null?"":value_arr[24];
								/*IN066982 starts*/
								if(reporting_practitioner == null){ //IN066982 changes
									reporting_practitioner = "";
								}
								
								/* commented for IN066982 if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									if(!repPract.equals(reporting_practitioner))
										reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " : "+bean1.getRepPractName(reporting_practitioner,localeName);
									else
										reporting_practitioner = "";
								}
								else
								{
									reporting_practitioner = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :"; 
								} commented for IN066982 */
								/***ADDED BY Deepa on 11/17/2009 at 9:42 AM for IN011473***************/
								hist_rec_type			= (value_arr[25]==null)?"":value_arr[25];
							if(isPracSiteSpecific && "LBIN".equals(hist_rec_type))
							{
								resulted_practitioner = (value_arr[33]==null)?"":value_arr[33];
								if(resulted_practitioner != null && !resulted_practitioner.equals(""))
								{
									reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR>  "+bean1.getRepPractName(resulted_practitioner,localeName);
								}
							}
							else{
								if(reporting_practitioner != null && !reporting_practitioner.equals(""))
								{
									reporting_practitioner = "<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingPractitioner.label","or_labels")+ " :<BR> "+bean1.getRepPractName(reporting_practitioner,localeName);
								}
								
							}
							/*IN066982 ends*/
							}
						
						}
						if (!color.equals(""))
							slClassValue = color;
						//End of Addition
						String disp_hdr_time="";//IN29171

						if(hdr_time == null) 
							hdr_time = "";
						
						if(hdr_time.contains("/"))
						{
							if(hdr_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
							{
								if(com.ehis.util.DateUtils.validDate(hdr_time,"DMYHMS",localeName))
								{
									disp_hdr_time = com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHMS","en",localeName);//IN29171
								}
							}
							else if(hdr_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
							{
								if(com.ehis.util.DateUtils.validDate(hdr_time,"DMYHM",localeName))
								{
									disp_hdr_time = com.ehis.util.DateUtils.convertDate(hdr_time,"DMYHM","en",localeName);//IN29171
								}
							}
							else if(hdr_time.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
							{
								if(com.ehis.util.DateUtils.validDate(hdr_time,"DMY",localeName))
								{
									disp_hdr_time = com.ehis.util.DateUtils.convertDate(hdr_time,"DMY","en",localeName);//IN29171
								}
							}
						} 

						if(obj != null)
						{
							
							String value_arr[] = (String[]) obj;
							
							if(header==0){
								out.println("<tr><td class='columnheader' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","common_labels")+"</td>");
								out.println("<td class='columnheader' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Results.label","or_labels")+"</td>");
								out.println("<td  class='columnheader' >Result Status</td></tr>");
							header++;
							}
							if((!dup_time.equalsIgnoreCase(hdr_time))){
								//out.println("<tr><td colspan=3 class='OR_QRYEVENBORDER'></td></tr>");									
								out.println("<tr><td class='columnheader' wrap>&nbsp;</td>");
								out.println("<td class='columnheader' wrap>"+disp_hdr_time+"</td>");
								dup_time=hdr_time;
								out.println("<td class='columnheader' wrap>&nbsp;</td></tr>");	
							}
							
							String panel_value = (key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key));
							if(!panel_value.equalsIgnoreCase(temp_panel_key)){
								//[IN031684]if(dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's
								//[IN031684]{
									out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><b><font size='2'>"+(key_value_map1.get(panel_key)==null?"":(String)key_value_map1.get(panel_key))+"</font></b></td></tr>"); 
									temp_panel_key = panel_value;
								//[IN031684]}							
							}
							if(dscr_map.size()>1)
							{
								out.println("<tr VALIGN='TOP'><td wrap title = '"+toolTipText+"' class = '"+slClassValue+"'>"+(key_value_map2.get(dscr_key)==null?"&nbsp;":(String)key_value_map2.get(dscr_key))+" <BR> "+reporting_practitioner+" </td>");								
								i++;
							}
							else
							{																	
								out.println("<tr VALIGN='TOP'><td  wrap title = '"+toolTipText+"'  class = '"+slClassValue+"'>"+(key_value_map2.get(dscr_key)==null?"&nbsp;":(String)key_value_map2.get(dscr_key))+"<BR> "+reporting_practitioner+"</td>");
								i++;
							}
							String normalcy_ind = value_arr[4];
							String normalcy_ind_disp = "&nbsp;";
							

							//if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
							//	normalcy_ind_disp = "<FONT COLOR='RED' >Abnormal</FONT>";
							//else
							normalcy_ind 		= value_arr[15];
					
							/*if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
								normalcy_ind_disp = "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"</FONT>";
							else if(normalcy_ind != null)
								normalcy_ind_disp = "<FONT COLOR='RED' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<b></FONT>";*/
							//Commented by Jyothi and added the below logic to fix IN021191

							if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(high_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(low_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(abn_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(crit_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(crit_high_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equalsIgnoreCase(crit_low_str))
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels");
							else if(normalcy_ind != null && normalcy_ind.equals(".")) //Added by Jyothi to fix IN023229
								normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
							else
							{
								if(!(CommonBean.checkForNull(value_arr[11]).trim()).equals("") && !(CommonBean.checkForNull(value_arr[12]).trim()).equals(""))
								{
									if(!(CommonBean.checkForNull(value_arr[5]).trim()).equals(""))
									{
										if(Float.parseFloat(value_arr[5]) > 0)
										{
											if((Float.parseFloat(value_arr[5]) >= Float.parseFloat(value_arr[11])) && (Float.parseFloat(value_arr[5]) <= Float.parseFloat(value_arr[12])))
											{
												normalcy_ind_disp = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
											}
										}
									}
								}
								else
									normalcy_ind_disp = "";
							}
							//End
							String result_str = value_arr[7];
							if(result_str == null) 
								result_str = "";
							
							//IN054648 Start.
							result_str  = result_str.replaceAll("<","&lt;");
							result_str  = result_str.replaceAll(">","&gt;");
							//IN054648 End.

							if(result_str.contains("/"))
							{
								if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}"))
								{
									if(com.ehis.util.DateUtils.validDate(result_str,"DMYHMS",localeName))
									{
										result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMYHMS","en",localeName);
									}
								}
								else if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4} [0-9]{1,2}:[0-9]{1,2}"))
								{
									if(com.ehis.util.DateUtils.validDate(result_str,"DMYHM",localeName))
									{
										result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMYHM","en",localeName);
									}
								}
								else if(result_str.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}"))
								{
									if(com.ehis.util.DateUtils.validDate(result_str,"DMY",localeName))
									{
										result_str = com.ehis.util.DateUtils.convertDate(result_str,"DMY","en",localeName);
									}
								}
							}

							value_arr[7]=result_str;
							//IN040745 changed array length from 34 to 35
							//IN066982 changes array length 35->37 & 33->35 
							if(value_arr.length == 39)
							{
								status = CommonBean.checkForNull(value_arr[31]);
							}
							//else if(value_arr.length == 35)//IN070610
							else if(value_arr.length == 37)//IN070610
							{
								status = CommonBean.checkForNull(value_arr[30]);
							}
							
							out.println("<td title = '"+toolTipText+"' class = '"+slClassValue+"'><font size=1><table width='100%'><tr>");
							out.println("<td>");							
							//IN040745 changed array length from 34 to 35	
							//IN066982 changes array length 35->37 & 33->35 
							//if(value_arr.length == 37){//IN072540
								if(value_arr.length == 39){//IN072540
								if(!(CommonBean.checkForNull(value_arr[33],"").trim()).equals("") && (CommonBean.checkForNull(value_arr[33],"").trim()).equals("Y") && !(CommonBean.checkForNull(value_arr[5],"").trim()).equals("")){
									out.println("<table width='100%'><tr><td>");									
									out.println(CommonBean.checkForNull(value_arr[30]));
									out.println("&nbsp;"+CommonBean.checkForNull(value_arr[5]));			
									if(!CommonBean.checkForNull(value_arr[6]).equals(""))
									{   
									   out.println("&nbsp;"+value_arr[6]);				
									}
									if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
									{									
										out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
									}
									out.println("</td></tr></table>");
								}									
							//}else if(value_arr.length == 35){//IN070610
							}else if(value_arr.length == 37){//IN070610
								if(!(CommonBean.checkForNull(value_arr[32],"").trim()).equals("") && (CommonBean.checkForNull(value_arr[32],"").trim()).equals("Y") && !(CommonBean.checkForNull(value_arr[5],"").trim()).equals("")){
									out.println("<table width='100%'><tr><td>");									
									out.println(CommonBean.checkForNull(value_arr[29]));
									out.println("&nbsp;"+CommonBean.checkForNull(value_arr[5]));			
									if(!CommonBean.checkForNull(value_arr[6]).equals(""))
									{   
									   out.println("&nbsp;"+value_arr[6]);				
									}
									if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
									{									
										out.println("&nbsp;("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")"); 
									}
									out.println("</td></tr></table>");
								}
							}	
							if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("NUM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("TXT") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("HTM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR")){
											
								if(result_str!=null && !result_str.equals(""))
								{
									out.println("<table width='100%'><tr><td>");
									//[IN032246] Start.
										%>
										<PRE CLASS="<%=textClassValue%>"  style="word-wrap:break-word;"><%=CommonBean.checkForNull(result_str)%></PRE>
										<%
										/*if(result_str.length() > 40)
										{
										%>	
										<textarea rows="4" cols="90"  CLASS = "<%=textClassValue%>" READONLY><%=result_str%></textarea>									 
										<%
										}else{
										%>
										<PRE CLASS="<%=textClassValue%>"  style="word-wrap:break-word;"><%=CommonBean.checkForNull(result_str)%></PRE>
										<%
										}*/
									//[IN032246] End.
									out.println("</td></tr></table>");
								}
							}else{
								if(result_str!=null && !result_str.equals(""))
								{
									out.println("<table width='100%'><tr><td>");
									//[IN032246] Start.
										%>
										<PRE CLASS="<%=textClassValue%>"  style="word-wrap:break-word;"><%=CommonBean.checkForNull(result_str)%></PRE>
										<%
										/*if(result_str.length() > 40)
										{
										%>	
										<textarea rows="4" cols="90"  CLASS = "<%=textClassValue%>" READONLY><%=result_str%></textarea>									 
										<%
										}else{
										%>
										<PRE CLASS="<%=textClassValue%>"  style="word-wrap:break-word;"><%=CommonBean.checkForNull(result_str)%></PRE>
										<%
										}	*/	
									//[IN032246] End.
										//IN040745 changed array length from 34 to 35
										//IN066982 changes array length 35->37 & 33->35 
										//if(value_arr.length == 37 && value_arr[31]!=null){//IN072540
										if(value_arr.length == 39 && value_arr[31]!=null){//IN072540
										out.println("<font color=blue>( Normal Value : "+value_arr[31]+" )</font>"); 
										}
										//else if(value_arr.length == 35 && value_arr[30]!=null)//IN070610
										else if(value_arr.length == 37 && value_arr[30]!=null)//IN070610
										{
										out.println("<font color=blue>( Normal Value : "+value_arr[30]+" )</font>");
										}
									out.println("</td></tr></table>");
								}							
							}
								
//================================================================
				/*if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR")){	
					if(value_arr[8] != null && (!(value_arr[8].equals("")))){
							String temp = CommonBean.checkForNull(value_arr[8]);			
							String tempsplit[] = temp.split("\n");							
							int indicate=0;
							int indicator=0;

							for(int n = 0; n < tempsplit.length; n++){
								String tempRow=tempsplit[n];
								if(n>0 && n < (tempsplit.length -1) && indicate==0){
									if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
									{
										indicate=indicate++;
										indicator=n;
									}
								}
								if(!(tempRow.length()>100)){	//[IN029203] Start.									
									%>
									<PRE CLASS="<%=textClassValue%>"  style="word-wrap:break-word;"><%=tempRow%></PRE>
									<%
									//[IN029203] End.
									if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
									out.println("\n");	
								}else{
									StringBuffer br = new StringBuffer(tempRow);
									int k = 0;
									for(int p = 0; p < br.length(); p++)
									{
										if( p == (k+100))
										{
											String st = br.substring(k,p);
											//[IN029203] Start.
											//out.println("<PRE>"+st+"</PRE>");  
											%>
											<PRE CLASS="<%=textClassValue%>" style="word-wrap:break-word;"><%=st%></PRE>
											<%
											//[IN029203] End.
											k += 100;
										}
									}	
									//[IN029203] Start.
									//out.println("<PRE >"+br.substring(k, br.length())+"</PRE>");
									%>
									<PRE CLASS="<%=textClassValue%>" style="word-wrap:break-word;"><%=br.substring(k, br.length())%></PRE>
									<%
									//[IN029203] End.
									if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
										out.println("\n");
								}

							}

					}
				}*/
//============================================================================	
							if((CommonBean.checkForNull(value_arr[20],"").trim()).equals("HTM") || (CommonBean.checkForNull(value_arr[20],"").trim()).equals("STR"))
							{	
								String txt= CommonBean.checkForNull(value_arr[8]);
								if(txt.indexOf("</ADDRESS></table>") != -1)
									txt = txt.replaceAll("</ADDRESS></table>","</ADDRESS>");
								txt = txt.replaceAll("</TD></TR><tr><td>&nbsp;</td></tr></table></BODY></HTML>","");
								txt = txt.replaceAll("<HTML><BODY>","");
								txt = txt.replaceAll("</BODY></HTML>","");	
								txt = txt.replaceAll("<HTML>","");
								txt = txt.replaceAll("</HTML>","");
								txt = txt.replaceAll("<BODY>","");
								txt = txt.replaceAll("</BODY>","");
								txt = txt.replaceAll("<HEAD>","");
								txt = txt.replaceAll("</HEAD>","");
								txt = txt.replaceAll("<TITLE></TITLE>","");
								txt = txt.replaceAll("font-family:Courier New;FONT-SIZE:9pt","font-family:Courier New;FONT-SIZE:8pt");
								txt = txt.replaceAll("<TR><TD colspan=","<TR><TD style='word-wrap:break-word;width:40em;' colspan=");//IN039067
								txt = txt.replaceAll("<TD> ","<TD style='word-wrap:break-word;width:40em;'> "); //IN039067
								txt = txt.replaceAll("<td","<td style='word-wrap:break-word;'  "); 
								txt = txt.replaceAll("LINE-HEIGHT: 100%;","LINE-HEIGHT:");             //[IN056353]
								txt = txt.replaceAll("line-height: 100%;","line-height:");            //[IN056353]
								//txt = txt.replaceAll("100%","550"); //Commented for IN062473
								txt = txt.replaceAll("width='100%'","width='550'"); //Added for IN062473
								txt = txt.replaceAll("PAGE-BREAK-BEFORE: always;","");         //[IN056353]
								out.println("<table width='500'> <tr><td CLASS='"+textClassValue+"' >");
								//[IN032246] Stat.
								//out.println(txt);
								//IN039067 Start
								
								%>
									<%=txt%>
								<%
								
								/*if(txt.indexOf("<TR>") != -1){	
								%>
									<PRE CLASS="<%=textClassValue%>" style="word-wrap:break-word;"><%=txt%></PRE>
								<%
								}else{								
									String tempsplit[] = txt.split("\n");							
									int indicate=0;
									int indicator=0;
									for(int n = 0; n < tempsplit.length; n++){
										String tempRow=tempsplit[n];
										if(n>0 && n < (tempsplit.length -1) && indicate==0){
											if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
											{
												indicate=indicate++;
												indicator=n;
											}
										}
										 //if(!(tempRow.length()>72))//	//[IN029203] Start.	 //[IN039361]
										if(!(tempRow.length()>60)){//[IN039361]								
											%>
											<PRE CLASS="<%=textClassValue%>" style="word-wrap:break-word;"><%=tempRow%></PRE>
											<%
											//[IN029203] End.
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
											out.println("\n");	
										}else{
											StringBuffer br = new StringBuffer(tempRow);
											StringBuffer tempStr = new StringBuffer();
											int k = 0;
											for(int p = 0; p < br.length(); p++)
											{
												//if( p == (k+72))//[IN039361]
												if( p == (k+60))//[IN039361]												
												{
													String st = br.substring(k,p);
													//[IN029203] Start.
													//out.println("<PRE>"+st+"</PRE>");
													tempStr.append(st);
													tempStr.append("\n");
													%>
													
													<!--<PRE CLASS="<%=textClassValue%>" style="word-wrap:break-word;"><%=st%></PRE>-->
													<%
													//[IN029203] End.
													//k += 72; //[IN039361]
													k += 60; //[IN039361]
												}
											}	
											//[IN029203] Start.
											//out.println("<PRE >"+br.substring(k, br.length())+"</PRE>");
											%>											
											<PRE CLASS="<%=textClassValue%>" style="word-wrap:break-word;"><%=tempStr%><%=br.substring(k, br.length())%></PRE>
											<%
											//[IN029203] End.
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
												out.println("\n");
										}
									}
								}*/
								//IN039067 End.
								out.println("</td></tr></table>");								
								//out.println("<table border='2'cellpadding='0' cellspacing='2' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table>");
								out.println("<table border='2'cellpadding='0' cellspacing='2' width='500'><tr><td>");
								%>
									<PRE CLASS="<%=textClassValue%>"  style="word-wrap:break-word;"><%=section_content_ftr%></PRE>
								<%
								//[IN032246] End.
								out.println("</td></tr></table>");
							}else
							{	
						System.out.println("==========ViewPrint.jsp============>"+value_arr[8]+"<========>"+value_arr[21]);
						System.out.println("==========ViewPrint.jsp============>"+value_arr[16]+"<========>"+value_arr[20]);
								//IN053047 Start.
								if(value_arr[8] != null && (!(value_arr[8].equals("")))){
									StringBuffer displayData = new StringBuffer();
									bean1.setClobData(value_arr[8], value_arr[21]);
									String txt =CommonBean.checkForNull(value_arr[8]);
									txt = txt.replaceAll("font-family:Courier New;FONT-SIZE:9pt","font-family:Courier New;FONT-SIZE:8pt");
									txt = txt.replaceAll("PAGE-BREAK-BEFORE: always;","");       //[IN056353]
									txt = txt.replaceAll("LINE-HEIGHT: 100%;","LINE-HEIGHT:");          //[IN056353]
									String tempsplit[] = txt.split("\n");							
									int indicate=0;
									int indicator=0;
									for(int n = 0; n < tempsplit.length; n++){
										String tempRow=tempsplit[n];
										if(n>0 && n < (tempsplit.length -1) && indicate==0){
											if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
											{
												indicate=indicate++;
												indicator=n;
											}
										}
										if(!(tempRow.length()>80)){								
											
											displayData.append("<PRE  style='word-wrap:break-word;'>"+tempRow+"</PRE>");
																						
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
												displayData.append("\n");	
										}else{
											StringBuffer br = new StringBuffer(tempRow);
											StringBuffer tempStr = new StringBuffer();
											int k = 0;
											for(int q = 0; q < br.length(); q++)
											{
												if( q == (k+80))											
												{
													String st = br.substring(k,q);													
													tempStr.append(st);
													tempStr.append("\n");			//IN071753										
													k += 80; 
												}
											}
											displayData.append("<PRE  style='word-wrap:break-word;'>"+tempStr+br.substring(k, br.length())+"</PRE>");
																						
											if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
												displayData.append("\n");
										}
									}
									out.println(displayData);
								}							
								//IN053047 End.
							}
						
							if(value_arr[16] != null)
							{
							%>
								<a class="gridLink" href="javascript:viewResultComment(escape('<%=value_arr[16]%>'))">C</a>
							<%
							}							
						out.println("</td></tr></table>");
						if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
						{ 								
						%>							
							<img src='../../eCA/images/<%=ext_image_appl_id%>.gif' width='16' height='16' border=0 alt='Result'>
						<%
						}
						//IN040745 changed array length from 34 to 35
						//IN066982 changes array length 35->37 & 33->35 
						if(value_arr.length == 39)
						{
							status = CommonBean.checkForNull(value_arr[31]);
						//}else if(value_arr.length == 35)//IN070610
						}else if(value_arr.length == 37)//IN070610
						{
							status = CommonBean.checkForNull(value_arr[30]);
						}
						if(status.equals("P"))
							out.println("<font color='red'>(Preliminary)</font>");
							
						%>
							</td>
						<%
						out.println("<td class = '"+slClassValue+"'>");
						if(!normalcy_ind_disp.equals(""))
							out.println("&nbsp;"+normalcy_ind_disp);
						else
							out.println("&nbsp;");
						out.println("</td>");
					}										
				}
			}
		}		
		out.println("</tr>");
		out.println("</table>");	
		if(con!=null) con.close(); //IN043940 
	}
%>
</TD></TR></TABLE>
<!-- 35142 Start. -->
<input type=hidden id="pkiSiteSpecificYN" name="pkiSiteSpecificYN" id="pkiSiteSpecificYN" value="<%=request.getParameter("pkiSiteSpecificYN")%>"/>
<input type=hidden id="quePkiStatus" name="quePkiStatus" id="quePkiStatus" value="<%=request.getParameter("quePkiStatus")%>"/>
<input type=hidden id="quePkiStatusText" name="quePkiStatusText" id="quePkiStatusText" value="<%=request.getParameter("quePkiStatusText")%>"/>
<input type=hidden id="quePkiId" name="quePkiId" id="quePkiId" value="<%=request.getParameter("quePkiId")%>"/>	
<input type=hidden id="quePkiToken" name="quePkiToken" id="quePkiToken" value="<%=request.getParameter("quePkiToken")%>"/>
<input type=hidden id="quePkiNumber" name="quePkiNumber" id="quePkiNumber" value="<%=request.getParameter("quePkiNumber")%>"/>
<input type=hidden id="quePkiIsueDateTime" name="quePkiIsueDateTime" id="quePkiIsueDateTime" value="<%=request.getParameter("quePkiIsueDateTime")%>"/>
<input type=hidden id="quePkiCallDateTime" name="quePkiCallDateTime" id="quePkiCallDateTime" value="<%=request.getParameter("quePkiCallDateTime")%>"/>	

<input type=hidden id="ordFacilityId" name="ordFacilityId" id="ordFacilityId" value="<%=request.getParameter("ordFacilityId")%>"/>
<input type=hidden id="patientId" name="patientId" id="patientId" value="<%=request.getParameter("patientId")%>"/>
<input type=hidden id="encounterId" name="encounterId" id="encounterId" value="<%=request.getParameter("encounterId")%>"/>
<input type=hidden id="referenceId" name="referenceId" id="referenceId" value="<%=request.getParameter("referenceId")%>"/>
<input type=hidden id="userId" name="userId" id="userId" value="<%=request.getParameter("userId")%>"/>
<!-- 35142 End. -->
</Form>
</body>
</html>
<%
	putObjectInBean(bean_id1,bean1,request);
%>


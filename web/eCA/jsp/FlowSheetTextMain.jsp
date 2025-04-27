<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/01/2012	  INO30714		Menaka V	 THAI screen>View Clinical Event History>View>In the Recorded Clinical
										 Note the name is not displayed in THAI 
01/02/2012	  IN030859		Menaka V	CA>HTML code is displayed if we view the recorded Chief complaints in
										Clinical Events History and Chart Summary.
08/02/2012	  IN030996		Menaka V	 CA>Patient Chart>Clinical event history>When the already recorded details
										 are accessed we get Java Lang null pointer exception Script Error.
20/06/2012	  IN033489		Menaka V		Report header blank in clinical event history.										 
04/10/2012	  IN032555		Dinesh T	Disclaimer text is not displayed
09/01/2012	  IN032246		Ramesh G 	Result view from Existing Orders, doesn?t show the similar format as it?s shows on the Print Preview 
										and LIS (View/Print Draft Copy).
06/05/2013	  IN039562		Chowminya G	Age format Changed to Y-M-D											
15/05/2013    	IN038439	NijithaS		Bru-HIMS-CRF-351											
21/05/2013    IN040090      Chowminya G	Linked Issue: New format age components in local language		
06/09/2013	 IN034512		Karthi L	A print Option existed next to Close Button in Clinical Event History.																	
17/10/2013      IN042733    NijithaS		MO-GN-5430				
16/12/2013	 IN045646	    Chowminya	  Speciality name in report header has to be long name															
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895	Ramesh G	20/2/2014	   	Chowminya			Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424	Ramesh G 	04/06/2014		Akbar S			IN043895 Changes Reverted.
03/09/2014  	IN050584	NijithaS										MO-GN-5454-CA-SL3  
01/12/2014	IN052367	ChowminyaG 										Signature not published in Result linked clinical notes
26/02/2018	 IN065834	Raja S		26/02/2018		Ramesh G			PMG2017-KDAH-CRF-0002
28/06/2018	 IN065341	Prakash C	29/06/2018		Ramesh G		MMS-DM-CRF-0115	
22/08/2018	IN066793	Sharanraj	22/08/2018		Ramesh G		ARYU-SCF-0064
05/10/2018	IN068396	Raja S		05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
04/01/2019	IN067016	Ramya Maddena   04/01/2019		Ramesh G		AMRI-CRF-0370
04/03/2019   	IN066807    Ramya Maddena   4/03/2019       Ramesh G		AMRI-CRF-0340
04/05/2019	IN069484		Ramesh G										AMRI-CRF-0398
06/08/2019	IN071106		Dinesh T		06/08/2019		Ramesh G		ML-MMOH-SCF-1341
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
23/01/2020  IN072266		Durga N			23/01/2020		Ramesh G		BSP-SCF-0084
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
25/10/2021	24460			Ramesh G		25/10/2021		Ramesh G		ML-MMOH-SCF-1911
2/01/2024    52560         Twinkle Shah   5/01/2024      Ramesh Goli         MO-CRF-20201
-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<html>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,java.util.Date,java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8"%><!-- IN042733 -->
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper"%><!--IN065341-->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!--IN065341-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	    
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%String HistRecType = request.getParameter("Histrectype");%>
<head>
	 <%
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/*IN066793 STARTS*/
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
		/*IN066793 ENDS*/
	%>
<%!
//IN071106, starts
private String extractSpecimenNumber(String str, String firstSplitter, String secondSplitter)
{
	if(str!=null && str.length()>0)
		return str.substring(str.indexOf(firstSplitter)+1, str.indexOf(secondSplitter));
	return "";
}
//IN071106, ends
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
  	<script src='../../eCA/js/FlowSheet.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<!-- [IN036972] Start.-->
	<style> 
	PRE
		{
			font-size: 10pt ;
			/*IN043895 Start.*/
			/*Font-Family : Courier New;*/
				/*IN049424 Start.*/
				/*Font-Family : "Charis SIL", "Doulos SIL", Gentium,"Arial Unicode MS";*/
				FONT-FAMILY: Verdana ;
				/*IN049424 End.*/
			/*IN043895 End.*/ 
			BACKGROUND-COLOR: #FFFFFF;
			BORDER-STYLE: none;
			fontWeight : bold;
			text-align: left;
			white-space: normal;
			word-wrap: break-word;			
		}
	</style>
	<!-- [IN036972] End.-->
	
	<!-- IN066793 starts -->
	<%if(sitespecific)
	{	
	%>
	<style>		
				ADDRESS	{ FONT-FAMILY: Segoe UI ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<% 
	}
	else
	{	
	%>
	<style>		
				ADDRESS	{ FONT-FAMILY: Verdana ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<%
	}
	%>			
	<!-- IN066793 ends -->
	<title><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></title>
</head>
<body   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="flowsheet_text" id="flowsheet_text" align='center'>

<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String ContrSysId = request.getParameter("Contrsysid");
	String AccessionNum = request.getParameter("Accessionnum");
	String ContrSysEventCode = request.getParameter("Contrsyseventcode");
	String eventDateTime = "";//IN039562
	String patient_id = request.getParameter("patient_id");//INO30714
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "";
	StringBuffer displaydata = new StringBuffer();
	String hist_data_type="";
	String temp = "";
	String temp1 = "";
    String value = "";
    //String strToken = ""; 			//Checkstyle 4.0 Beta 6	
	String practitioner_name = "";
	PreparedStatement stmt1=null;
	ResultSet rs1=null;
	//INO30714 Starts
	//String facilityId = (String)session.getValue("facility_id");	//Checkstyle 4.0 Beta 6
	String facility_id = (String)session.getValue("facility_id");//IN038439	
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN038439
	String contr_mod_accession_num = "";//IN038439
	contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num"); //IN038439
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 =	null;
	ResultSet rs2 =	null;
	ResultSet res =	null;
	String performed_by_id	=	"" ;
	String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String enc_id	=	request.getParameter("enc_id");
	String fac_id	=	request.getParameter("fac_id");//IN033489
	//IN065341 starts
	//IN065341 starts
	String bean_id = "ca_CentralizedBean" ;
	String bean_name = "eCA.CentralizedBean";
	CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	String RepDb = request.getParameter("RepDb") == null ? "" : request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	//IN065341 ends
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	String attending_practitioner	=	"" ;
	String attending_practitioner_list	=	"" ;//IN066807
	String admitting_practitioner	=	"" ;
	String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	String gender	=	"" ;
	String patient_name	=	"" ;
	String speciality_name	=	"" ;
	String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String  authorized_by_id		=	""; //IN069484
	String  authorized_sign			=   "N"; //IN069484
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String  url1					=	"";
	String  url						=	"";
	String note_acc_num				=   request.getParameter("acc_num");//IN052367
	String footer_code = null;
	String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	// IN071335 Changes Start.
	//url   = HttpUtils.getRequestURL(request).toString();
	//url = url.substring(0,url.indexOf("jsp/"));
	url					= application.getRealPath("/eCA")+"/";
	// IN071335 Changes End.
	/*IN066793 starts*/
	if(sitespecific)
	{	
		url1 = url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
		url =url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
	}
	else
	{
		url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
		url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
	}
	/*IN066793 ends*/
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String	login_user_id		=	(String)session.getValue("login_user");
	String  sect_template_query		=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"",med_service 	=	"", location_code 	=	"";
	String cal_eventdate = "";//IN040090
	String		discharge_date_only = "";//IN067016
	HashMap<String,String> paramMap = null;
	//INO30714 ends
	String l_disclaimer_code = "";//IN032555
	String l_disclaimer_text = "";//IN032555
	// added for IN034512 - Start
	String note_header_desc = "";
	String discharge_summary_text = "";
	String siteName = "";
	PreparedStatement pstmt3 =	null;
	ResultSet rs3 =	null;
	String dis_clin_note_wt_metadata_yn=""; //52560
	// End
	try
	{
		    con = ConnectionManager.getConnection(request);
			//start 52560
		    pstmt3= con.prepareStatement("SELECT NVL(DIS_CLIN_NOTE_WT_METADATA_YN,'N') DIS_CLIN_NOTE_WT_METADATA_YN FROM CA_NOTE_PARAM");	
		    rs3=pstmt3.executeQuery();
		    if(rs3.next())
		    {
		    	dis_clin_note_wt_metadata_yn  = rs3.getString("DIS_CLIN_NOTE_WT_METADATA_YN");
			}
			if(rs3 != null) rs3.close();
			if(pstmt3 != null) pstmt3.close();

			//end 52560
		//IN065341 starts	
			if(clob_data.equals("_CDR")){
				bean.executeCDR(con, patient_id, enc_id, RepDb,"PATIENT_CARE_FLOW_SHEET");
			}
		//IN065341 ends	
			//INO30714 Starts
		try
		{
			if(	episode_type.equals("O") )
			{
				
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN045646 get_desc for specialty_name changed from 2 to 1
				/*query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE##REPDB##(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER##REPDB##(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM##REPDB##(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY##REPDB##(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT site_name FROM  SM_SITE_PARAM_LANG_VW ##REPDB## where language_id = ?) site_name,(select SHORT_NAME from am_practitioner ##REPDB## where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER ##REPDB## A,MP_PATIENT ##REPDB## B WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN065341*///IN067016
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE##REPDB##(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER##REPDB##(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM##REPDB##(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY##REPDB##(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT site_name FROM  SM_SITE_PARAM_LANG_VW ##REPDB## where language_id = ?) site_name,(select SHORT_NAME from am_practitioner ##REPDB## where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER ##REPDB## A,MP_PATIENT ##REPDB## B WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN067016//commented for IN066807
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE##REPDB##(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER##REPDB##(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM##REPDB##(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY##REPDB##(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT site_name FROM  SM_SITE_PARAM_LANG_VW ##REPDB## where language_id = ?) site_name,(select SHORT_NAME from am_practitioner ##REPDB## where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER ##REPDB## A,MP_PATIENT ##REPDB## B WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?   ORDER BY A.VISIT_ADM_DATE_TIME DESC";//IN066807
			}
			else
			{ 
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN045646 get_desc for specialty_name changed from 2 to 1
				/*query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE##REPDB##(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER##REPDB##(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM##REPDB##(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY##REPDB##(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW ##REPDB## where language_id = ?) site_name,(select SHORT_NAME from am_practitioner ##REPDB## where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER ##REPDB## A,MP_PATIENT ##REPDB## B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN065341*///IN067016
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE##REPDB##(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER##REPDB##(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM##REPDB##(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY##REPDB##(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW ##REPDB## where language_id = ?) site_name,(select SHORT_NAME from am_practitioner ##REPDB## where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER ##REPDB## A,MP_PATIENT ##REPDB## B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN067016//commented for IN066807
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC##REPDB##(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE##REPDB##(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER##REPDB##(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM##REPDB##(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY##REPDB##(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW ##REPDB## where language_id = ?) site_name,(select SHORT_NAME from am_practitioner ##REPDB## where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER ##REPDB## A,MP_PATIENT ##REPDB## B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?   ORDER BY A.VISIT_ADM_DATE_TIME DESC ";//IN066807
			}
			query_privilege_type=query_privilege_type.replaceAll("##REPDB##",RepDb);
			pstmt1	=	con.prepareStatement(query_privilege_type);
			
			pstmt1.setString	(	1,	locale	);
			pstmt1.setString	(	2,	locale	);
			pstmt1.setString	(	3,	locale	);
			pstmt1.setString	(	4,	locale	);
			pstmt1.setString	(	5,	performed_by_id	);
			pstmt1.setString	(	6,	locale	);
			pstmt1.setString	(	7,	locale	);			
			pstmt1.setString	(	8,	locale	);			
			pstmt1.setString	(	9,	locale	);			
			pstmt1.setString	(	10,	locale	);			
			//pstmt1.setString	(	11,	facilityId	);
			pstmt1.setString	(	11,	fac_id	);//IN033489
			pstmt1.setString	(	12,	enc_id);

			res		=	pstmt1.executeQuery();
			
			if(res.next())
			{
				patient_class	=	res.getString("patient_class") == null ? "" : res.getString("patient_class");
				facility_name			=	res.getString("facility_name") == null ? "" : res.getString("facility_name");
				visit_adm_date			=	res.getString("visit_adm_date")==null?"":res.getString("visit_adm_date");
				med_service			=	res.getString("service_name")==null?"":res.getString("service_name");
				discharge_date		=	res.getString("DISCHARGE_DATE_TIME")==null?"":res.getString("DISCHARGE_DATE_TIME");
				discharge_date_only		=	res.getString("DISCHARGE_DATE_TIME_1")==null?"":res.getString("DISCHARGE_DATE_TIME_1");//IN067016				
				attending_practitioner	=	res.getString("attending_practitioner")==null?"":res.getString("attending_practitioner");
				attending_practitioner_list	=	res.getString("attending_pract_list")==null?"":res.getString("attending_pract_list");//IN066807
				admitting_practitioner	=	res.getString("admitting_practitioner")==null?"":res.getString("admitting_practitioner");
				bed_number	=	res.getString("bed_number")==null?"":res.getString("bed_number");	  //--[IN:029839]--
				performing_phy_name	=	res.getString("performed_by_name")==null?"":res.getString("performed_by_name");
				age				=	res.getString("AGE")==null?"":res.getString("AGE");
				gender					=	res.getString("gender")==null?"":res.getString("gender");
				//locationDesc			=	res.getString("location");
				location_code			=	res.getString("location_code")==null?"":res.getString("location_code");
				patient_name			=	res.getString("patient_name")==null?"":res.getString("patient_name");
				speciality_name			=	res.getString("specialty_name")==null?"":res.getString("specialty_name");
				printDateTime			=	res.getString("print_date_time")==null?"":res.getString("print_date_time");
				site_name			=	res.getString("site_name")==null?"":res.getString("site_name");
				//performed_by_desc			=	res.getString("performed_by_desc");


			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(res!=null)	res.close();
			if(pstmt1!=null)	pstmt1.close();
		}
		
		if("0".equals(enc_id)){
			try{
				query_privilege_type	=	"SELECT  get_age (b.date_of_birth) age, DECODE (?,'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name)) patient_name, sex gender FROM mp_patient b WHERE  PATIENT_ID=? "; 
				
		
				pstmt1	=	con.prepareStatement(query_privilege_type);						
				pstmt1.setString	(	1,	locale	);
				pstmt1.setString	(	2,	patient_id	);
				rs1		=	pstmt1.executeQuery();
		
				if(rs1.next())
				{							
					age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
					gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");							
					patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
				}

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(rs1!=null)	rs1.close();
				if(pstmt1!=null)	pstmt1.close();
			}
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
		 //IN067016--Starts
				 if(discharge_date_only==null){
				 discharge_date_only="";
					 }
				 //IN067016--ends//
		if(patient_class.equals("OP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else if(patient_class.equals("IP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(patient_class.equals("EM"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(patient_class.equals("DC"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
					
					
		
		
		//IN039562 - Start
		try
		{
			//String event_date_qry ="select to_char(event_date,'dd/mm/yyyy hh24:mi') EVENT_DATE from cr_encounter_detail where CONTR_SYS_ID=? and CONTR_SYS_EVENT_CODE = ? and ACCESSION_NUM = ?";//IN032555
			String event_date_qry ="select to_char(event_date,'dd/mm/yyyy hh24:mi') EVENT_DATE from cr_encounter_detail ##REPDB## where CONTR_SYS_ID=? and CONTR_SYS_EVENT_CODE = ? and ACCESSION_NUM = ?";//IN065341
			event_date_qry=event_date_qry.replaceAll("##REPDB##",RepDb);//IN065341
			pstmt2	= con.prepareStatement(event_date_qry);
			pstmt2.setString(1,ContrSysId);
			pstmt2.setString(2,ContrSysEventCode);
			pstmt2.setString(3,AccessionNum);
			rs2 = pstmt2.executeQuery();
									
			while(rs2.next())
			{
				eventDateTime = rs2.getString("EVENT_DATE")==null?"":rs2.getString("EVENT_DATE");
				cal_eventdate = com.ehis.util.DateUtils.convertDate(eventDateTime,"DMYHM","en","en");//IN040090
				eventDateTime = com.ehis.util.DateUtils.convertDate(eventDateTime,"DMYHM","en",locale);
			}
		}
		catch(Exception ee)
		{
			//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		//IN039562 - End	
		//IN042733 Starts 
		
		try{
			//IN065341 starts
				//pstmt2	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");//IN040205
				String sql2="select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient ##REPDB## where patient_id = ?";
				sql2=sql2.replaceAll("##REPDB##",RepDb);
				pstmt2	= con.prepareStatement(sql2);
			//IN065341 ends	
				pstmt2.setString(1,patient_id);
				rs2 = pstmt2.executeQuery();
				//Date newDeceasedDt = null; checkstyle
				//Date new_event_date_time = null; checkstyle 
				String deceased_yn="";
				String deceased_date = "";
				

				while(rs2.next())
				{
					default_pat_name	= rs2.getString("patient_name") == null ? "" : rs2.getString("patient_name");
					deceased_yn			= rs2.getString("deceased_yn") == null ? "" : rs2.getString("deceased_yn");
					deceased_date		= rs2.getString("deceased_date") == null ? "" : rs2.getString("deceased_date");
					
					//IN050584 Starts
					/*if(!"".equals(deceased_date))
					{
						newDeceasedDt = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(deceased_date);
					}
					
					if(!"".equals(cal_eventdate))
					{
						new_event_date_time = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(cal_eventdate);
					}
					
				
					if("Y".equals(deceased_yn) && null!=new_event_date_time && null!=newDeceasedDt && new_event_date_time.after(newDeceasedDt) )
					{
						cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
					}*/
				}
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
					
				String eventdate_isAfter_decdate = "";
			//IN065341 starts	
				//pstmt2	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL");
				String sql3="SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL ##REPDB##";
				sql3=sql3.replaceAll("##REPDB##",RepDb);
				pstmt2	= con.prepareStatement(sql3);
			//IN065341 ends	
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
			//out.println("Exceptionin FlowSheetTextMain.jsp @ pstmt2 : "+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
		}
		
		//--[IN042733] - End
								try
								{
									//String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";//IN032555
								//IN065341 starts	
									//String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.DISCLIMER_CODE from ca_note_type a where  a.NOTE_TYPE=?";//IN032555
									String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.DISCLIMER_CODE from ca_note_type ##REPDB## a where  a.NOTE_TYPE=?";//IN065341
									head_foot_qry=head_foot_qry.replaceAll("##REPDB##",RepDb);
								//IN065341 ends	
									pstmt2	= con.prepareStatement(head_foot_qry);
									pstmt2.setString(1,ContrSysEventCode);
									rs2 = pstmt2.executeQuery();
									
									while(rs2.next())
									{
										//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
										footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
										report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
										l_disclaimer_code = rs2.getString("DISCLIMER_CODE")==null?"":rs2.getString("DISCLIMER_CODE");//IN032555
									}

			
								}
								catch(Exception ee)
								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//common-icn-0181
									ee.printStackTrace();
								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
								}
								
								try
								{
								//IN065341 starts	
									//sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
									sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG##CLOB## where  SEC_HDG_CODE =? " ;
									sect_template_query=sect_template_query.replaceAll("##CLOB##",clob_data);
								//IN065341 ends	
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
												//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
												e.printStackTrace();
											}


										}
									}
								}

								catch(Exception eee)
								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content 1: "+eee.toString());//COMMON-ICN-0181
									eee.printStackTrace();

								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									
								}
							if(!AccessionNum.equals(""))
							{
								try
								{
								//IN065341 starts	
									//String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;
									String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_NAME,a.AUTHORIZED_BY_ID AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER##REPDB##(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE##REPDB##(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE##CLOB## a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;
									athorise_by_qry=athorise_by_qry.replaceAll("##REPDB##",RepDb);
									athorise_by_qry=athorise_by_qry.replaceAll("##CLOB##",clob_data);
								//IN065341 ends
									pstmt2	= con.prepareStatement(athorise_by_qry);
									pstmt2.setString(1,locale);
									pstmt2.setString(2,locale);
									pstmt2.setString(3,locale);
									pstmt2.setString(4,locale);
									//pstmt2.setString(5,AccessionNum);//IN052367
									pstmt2.setString(5,note_acc_num);//IN052367
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
										authorized_by		=	rs2.getString("AUTHORIZED_NAME")==null?"":rs2.getString("AUTHORIZED_NAME") ;//IN030996
										authorized_by_id		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
										last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
										doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996
										
									}
									// added for IN034512
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									//IN069484 Start.
									if(!"".equals(authorized_by_id)){
										try{
											pstmt2	= con.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
											pstmt2.setString(1,authorized_by_id);
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
									}
									//IN069484 End.
								//IN065341 starts	
									//String strSql = " SELECT  (select ia.DISCLIMER_TEXT from CA_DISCLIMER_TEXT_LANG_VW ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE  and ib.NOTE_TYPE=a.note_type and language_id = ?)  DIS_SUMM_DISCLAIMER_TXT, (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ib, ca_note_type ia WHERE ib.note_group = ia.note_group_id  AND ia.note_type = a.note_type AND ib.language_id =?) note_header_desc FROM ca_encntr_note a WHERE a.accession_num = ?";
									String strSql = " SELECT  (select ia.DISCLIMER_TEXT from CA_DISCLIMER_TEXT_LANG_VW ##REPDB## ia, ca_note_type ##REPDB## ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE  and ib.NOTE_TYPE=a.note_type and language_id = ?)  DIS_SUMM_DISCLAIMER_TXT, (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ##REPDB## ib, ca_note_type ##REPDB## ia WHERE ib.note_group = ia.note_group_id  AND ia.note_type = a.note_type AND ib.language_id =?) note_header_desc FROM ca_encntr_note##CLOB## a WHERE a.accession_num = ?";
									strSql=strSql.replaceAll("##REPDB##",RepDb);
									strSql=strSql.replaceAll("##CLOB##",clob_data);
								//IN065341 ends	
									pstmt3	= con.prepareStatement(strSql);
									pstmt3.setString(1,locale);
									pstmt3.setString(2,locale);
									pstmt3.setString(3,AccessionNum);
									rs3 = pstmt3.executeQuery();
									while(rs3.next()){
										discharge_summary_text		=	rs3.getString("DIS_SUMM_DISCLAIMER_TXT")==null?"":rs3.getString("DIS_SUMM_DISCLAIMER_TXT") ;
										note_header_desc		=	rs3.getString("note_header_desc")==null?"":rs3.getString("note_header_desc") ;
									}
									
									String sqlSite = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
									pstmt1	= con.prepareStatement(sqlSite);
									pstmt1.setString(1,locale);
									rs1		=	pstmt1.executeQuery();
									while(rs1.next()){
										
										siteName = rs1.getString(1)==null?"":rs1.getString(1);
									}
									// End
								}
								catch (Exception roro )

								{
									out.println("Exceptionin RecClinicalNotesSection.jsp getting section content 2: "+roro.toString());
									roro.printStackTrace();

								}
								finally 
								{
									if(rs1 != null) rs1.close(); 		//IN034512
									if(pstmt1 != null) pstmt1.close(); //IN034512
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									if(rs3 != null) rs3.close(); //IN034512
									if(pstmt3 != null) pstmt3.close(); //IN034512
									
								}
							}
							encounter_id1 = enc_id ;
							if(enc_id.equals("0"))
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
							htParameter.put("V$DIS_DATE", discharge_date_only); //discharge_date_only// IN067016
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
								paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num);//IN065834
								paramHash.put("#p_accNum#",AccessionNum);
								paramHash.put("#p_locale#",locale);
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
							paramHash.put("#p_accNum#",AccessionNum);
							paramHash.put("#p_locale#",locale);
							paramHash.put("#p_pract_id#",clinician_id);
							tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
							if(tempParameter.size()>0){					
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
						//Footer Ends
						//INO30714 Ends

						//IN032555, starts
						PreparedStatement l_disclaimPsmt = null;
						ResultSet l_disclaimRs = null;

						try
						{
						//IN065341 starts	
							//String l_disclaimer_query ="SELECT CA_GET_DESC.CA_DISCLIMER_TEXT(?,?,'1') DISCLAIMER_TEXT FROM DUAL";
							String l_disclaimer_query ="SELECT CA_GET_DESC.CA_DISCLIMER_TEXT##REPDB##(?,?,'1') DISCLAIMER_TEXT FROM DUAL##REPDB##";
							l_disclaimer_query=l_disclaimer_query.replaceAll("##REPDB##",RepDb);
						//IN065341 ends		
							l_disclaimPsmt	= con.prepareStatement(l_disclaimer_query);
							l_disclaimPsmt.setString(1,l_disclaimer_code);
							l_disclaimPsmt.setString(2,locale);
							l_disclaimRs = l_disclaimPsmt.executeQuery();
							
							while(l_disclaimRs.next())
							{
								l_disclaimer_text = l_disclaimRs.getString("DISCLAIMER_TEXT")==null?"":l_disclaimRs.getString("DISCLAIMER_TEXT");
							}	
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						finally
						{
							if(l_disclaimRs != null) 
								l_disclaimRs.close();
							if(l_disclaimPsmt != null) 
								l_disclaimPsmt.close();
						}
						//IN032555, ends					
					
			//Below query is added by Archana Dhal on 11/24/2010 related to IN025200.
		//IN065341 starts	
			//String sql1 = " select am_get_desc.am_practitioner(practitioner_id,?,2) practitioner_name from cr_encounter_detail where accession_num=?";
			String sql1 = " select am_get_desc.am_practitioner##REPDB##(practitioner_id,?,2) practitioner_name from cr_encounter_detail##REPDB## where accession_num=?";
			sql1=sql1.replaceAll("##REPDB##",RepDb);
		//IN065341 ends	
			stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1,locale);
			stmt1.setString(2,AccessionNum);
			rs1 = stmt1.executeQuery();
			while(rs1.next())
			 {	
				practitioner_name=rs1.getString("practitioner_name");		   
			  }
			  //IN066453 start
			 StringBuffer dispSpecNo = new StringBuffer();
			 dispSpecNo.append(" ");
			 //IN066453 ends
		//IN065341 starts	
			//sql = " SELECT B.HIST_DATA,A.HIST_DATA_TYPE FROM CR_ENCOUNTER_DETAIL A, CR_ENCOUNTER_DETAIL_TXT B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";
			//sql = " SELECT B.HIST_DATA,A.HIST_DATA_TYPE FROM CR_ENCOUNTER_DETAIL ##REPDB## A, CR_ENCOUNTER_DETAIL_TXT##CLOB## B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";
			//sql = " SELECT B.HIST_DATA,A.HIST_DATA_TYPE,A.HIST_REC_TYPE,A.REQUEST_NUM,A.CATEGORY_NUMBER FROM CR_ENCOUNTER_DETAIL ##REPDB## A, CR_ENCOUNTER_DETAIL_TXT##CLOB## B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";//IN066453 changed select field//IN071106
			//6484 Start.
			//sql = " SELECT B.HIST_DATA,A.HIST_DATA_TYPE,A.HIST_REC_TYPE,A.REQUEST_NUM,A.CATEGORY_NUMBER,A.ACCESSION_NUM FROM CR_ENCOUNTER_DETAIL ##REPDB## A, CR_ENCOUNTER_DETAIL_TXT##CLOB## B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";//IN066453 changed select field//IN071106
			sql = " SELECT B.HIST_DATA,B.COMPRESS_HIST_DATA,B.COMPRESS_HIST_DATA_YN,B.COMMENTS, A.HIST_DATA_TYPE,A.HIST_REC_TYPE,A.REQUEST_NUM,A.CATEGORY_NUMBER,A.ACCESSION_NUM FROM CR_ENCOUNTER_DETAIL ##REPDB## A, CR_ENCOUNTER_DETAIL_TXT##CLOB## B WHERE A.HIST_REC_TYPE = ? AND A.CONTR_SYS_ID = ? AND A.ACCESSION_NUM = ? AND A.CONTR_SYS_EVENT_CODE = ? AND B.HIST_REC_TYPE = A.HIST_REC_TYPE AND B.CONTR_SYS_ID = A.CONTR_SYS_ID  AND B.ACCESSION_NUM = A.ACCESSION_NUM  AND B.CONTR_SYS_EVENT_CODE = A.CONTR_SYS_EVENT_CODE ";
			//6484 End.
			
			sql=sql.replaceAll("##REPDB##",RepDb);
			sql=sql.replaceAll("##CLOB##",clob_data);
//			out.println(sql);
		//IN065341 ends
			stmt = con.prepareStatement(sql);

			stmt.setString(1, HistRecType);
			stmt.setString(2, ContrSysId);
			stmt.setString(3, AccessionNum);
			stmt.setString(4, ContrSysEventCode);
			
			rs = stmt.executeQuery();

			if(rs.next())
			{
				Clob note=rs.getClob("HIST_DATA");
				hist_data_type = rs.getString("HIST_DATA_TYPE");
				//IN066453 starts
				String reqNum = rs.getString("REQUEST_NUM")==null?"":rs.getString("REQUEST_NUM");
				String catNum = rs.getString("CATEGORY_NUMBER")==null?"":rs.getString("CATEGORY_NUMBER");
				String accessionNum = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");//IN071106
				if(rs.getString("HIST_REC_TYPE").equals("LBIN"))
				{
					String[] reqNumArr = new String[2];
					reqNumArr = reqNum.split("#");
					if("LB".equals(ContrSysId)) //IN072266
						accessionNum = extractSpecimenNumber(accessionNum,"#","@");//IN071106
					
					if(accessionNum.length()>0){//IN071106
						dispSpecNo.append("<table cellpadding='0' cellspacing='4' width='100%'><tr><td width='25%' class='LABEL'>");
						dispSpecNo.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+":</td>");
				    	//dispSpecNo.append("<td class='DATA' width='25%' >&nbsp;"+reqNumArr[1]+"</td>");//IN071106
				    	dispSpecNo.append("<td class='DATA' width='25%' >&nbsp;"+accessionNum+"</td>");//IN071106
						dispSpecNo.append("<td width='25%' class='LABEL'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+":</td>");
						dispSpecNo.append("<td class='DATA' width='25%'>&nbsp;"+catNum+"</td>");
						dispSpecNo.append("</tr></table><BR>");
					}

				}
				//IN066453 ends
				displaydata = new StringBuffer();
				//6484 Start.
				if("Y".equals(rs.getString("COMPRESS_HIST_DATA_YN")==null?"N":(String)rs.getString("COMPRESS_HIST_DATA_YN"))){
					
					java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_hist_data");
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
									if(line.indexOf("Onset Date Time")!=-1)
									{
									 temp = line.substring(18,line.length());
									 temp	= com.ehis.util.DateUtils.convertDate(temp,"DMY","en",locale);
									 displaydata.append(line.substring(0,18));
									 displaydata.append(temp);
									 displaydata.append("\n");
									}
									else if(line.indexOf("Reviewed by")!=-1)
									{
										temp1   = line.substring(14,27);
										temp1 = practitioner_name;
										displaydata.append(line.substring(0,14));
										displaydata.append(temp1);
										if(line.indexOf("On")!=-1)
										{
											value = line.substring(31,line.length());
											value	= com.ehis.util.DateUtils.convertDate(value,"DMYHM","en",locale);
											displaydata.append(line.substring(27,31));
											displaydata.append(value);
											displaydata.append("\n");
										}		
									}
									else
									{
										displaydata.append(line);
										displaydata.append("\n");
									}
								}
							}					
						}
					}
					displaydata.append((rs.getString("comments")==null?"":(String)rs.getString("comments")));
				}else{
				//6484 End.	
					if(note!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
						String line = null;
						while((line=r.readLine()) != null)
						{
							//Below condition is added by Archana Dhal on 10/7/2010 related to IN024213.
							if(line.indexOf("Onset Date Time")!=-1)
							{
							 temp = line.substring(18,line.length());
							 temp	= com.ehis.util.DateUtils.convertDate(temp,"DMY","en",locale);
							 displaydata.append(line.substring(0,18));
							 displaydata.append(temp);
							 displaydata.append("\n");
							}
							else if(line.indexOf("Reviewed by")!=-1)
							{
								temp1   = line.substring(14,27);
								temp1 = practitioner_name;
								displaydata.append(line.substring(0,14));
								displaydata.append(temp1);
								if(line.indexOf("On")!=-1)
								{
									value = line.substring(31,line.length());
									value	= com.ehis.util.DateUtils.convertDate(value,"DMYHM","en",locale);
									displaydata.append(line.substring(27,31));
									displaydata.append(value);
									displaydata.append("\n");
								}		
							}
							else
							{
								displaydata.append(line);
								displaydata.append("\n");
							}								
						}
					}
					displaydata.append((rs.getString("comments")==null?"":(String)rs.getString("comments")));
				} //6484
			}
			//if(HistRecType.equals("CLNT") || hist_data_type.equals("HTM"))
			if( hist_data_type.equals("HTM"))
			{
				out.println(dispSpecNo);
				if("N".equals(dis_clin_note_wt_metadata_yn) || ("Y".equals(dis_clin_note_wt_metadata_yn) && !HistRecType.equals("CLNT")))  //52560
				{
				out.println("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>");//IN030859
				} //52560
				out.println("<PRE>"); //[IN036972] 
				//out.println(displaydata.toString());//IN068396
				displaydata = new StringBuffer(displaydata.toString().replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", ""));//ML-MMOH-SCF-2966
				out.println((displaydata.toString()).replaceAll("line-height: 100%"," "));//IN068396
				out.println("</PRE>"); //[IN036972] 
				out.println("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>");//IN030859
				out.println(l_disclaimer_text);//IN032555
			}
			else
			{
				out.println(dispSpecNo);
				//[IN036972] Start.
				//out.println("<br/>&nbsp;&nbsp;&nbsp;&nbsp;<textarea align='ABSMIDDLE' style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows=35 cols=100 readOnly>"+displaydata.toString()+"</textarea>");
				out.println("<br/><table border='5' cellpadding='0' cellspacing='0' width='100%' height='100%'><tr><td style='left-padding:10px;' valign='top'>");
				out.println("<PRE>");
				//out.println(displaydata.toString());
				displaydata = new StringBuffer(displaydata.toString().replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", ""));//ML-MMOH-SCF-2966
				out.println((displaydata.toString()).replaceAll("line-height: 100%"," "));//IN068396
				out.println("</PRE>");
				out.println("</td></tr></table>");
				//[IN036972] End.
			}

		if(rs !=null) rs.close();
		if(stmt != null ) stmt.close();
		if(rs1 != null ) rs1.close();
		if(stmt1 != null ) stmt1.close();

	}catch(Exception e)
	{		//out.println(e);//COMMON-ICN-0181	
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
<!-- added for IN034512 -->
<input type="hidden" name="accession_num" id="accession_num" value='<%=AccessionNum%>'>
<input type="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>
<input type="hidden" name="encounter_id" id="encounter_id" value='<%=enc_id%>'>
<input type="hidden" name="visit_adm_date" id="visit_adm_date" value='<%=visit_adm_date%>'>
<input type="hidden" name="discharge_date" id="discharge_date" value='<%=discharge_date%>'>
<input type="hidden" name="speciality_name" id="speciality_name" value='<%=speciality_name%>'>
<input type="hidden" name="location_code" id="location_code" value='<%=location_code%>'>
<input type="hidden" name="performed_by_pract" id="performed_by_pract" value='<%=performed_by_id%>'>
<input type="hidden" name="performing_phy_name" id="performing_phy_name" value='<%=performing_phy_name%>'>
<input type="hidden" name="event_title_desc" id="event_title_desc" value=''>
<input type="hidden" name="sex" id="sex" value='<%=Sex%>'>
<input type="hidden" name="age" id="age" value='<%=age%>'>
<input type="hidden" name="patient_class" id="patient_class" value='<%=patient_class%>'>
<input type="hidden" name="note_header_desc" id="note_header_desc" value='<%=note_header_desc%>'> 
<input type="hidden" name="event_date_time" id="event_date_time" value='<%=eventDateTime%>'>
<input type="hidden" name="med_service" id="med_service" value='<%=med_service%>'>
<input type="hidden" name="attending_practitioner" id="attending_practitioner" value='<%=attending_practitioner%>'>
<input type="hidden" name="performed_date" id="performed_date" value=''>
<input type="hidden" name="note_status" id="note_status" value=''>
<input type="hidden" name="printDateTime" id="printDateTime" value='<%=printDateTime%>'>
<input type="hidden" name="note_type" id="note_type" value='<%=ContrSysEventCode%>'>
<input type="hidden" name="patient_name" id="patient_name" value='<%=patient_name%>'>
<input type="hidden" name="appl_task_id" id="appl_task_id" value=''>
<input type="hidden" name="admitting_practitioner" id="admitting_practitioner" value='<%=admitting_practitioner%>'>
<input type="hidden" name="episode_type" id="episode_type" value='<%=episode_type%>'>
<input type="hidden" name="discharge_summary_text" id="discharge_summary_text" value='<%=discharge_summary_text%>'>
<input type="hidden" name="siteName" id="siteName" value='<%=siteName%>'>
<input type="hidden" name="facility_name" id="facility_name" value='<%=facility_name%>'>
<input type="hidden" name="dischargeDateTime" id="dischargeDateTime" value='<%=discharge_date%>'>
<input type="hidden" name="authorizedBy" id="authorizedBy" value='<%=authorized_by%>'>
<input type="hidden" name="lastModifiedBy" id="lastModifiedBy" value='<%=last_amended_by%>'>
 <input type="hidden" name="loggedUser" id="loggedUser" value='<%=login_user_id%>'> 
</form>
</body>
</html>


<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
30/01/2012	  INO30714		Menaka V	 THAI screen>View Clinical Event History>View>In the Recorded
										 Clinical Note the name is not displayed in THAI 
08/02/2012	  IN030996		Menaka V	 CA>Patient Chart>Clinical event history>When the already recorded details
										 are accessed we get Java Lang null pointer exception Script Error. 	 
06/05/2013	 IN039562		Chowminya G		Age format Changed to Y-M-D												 
15/05/2013   IN038439		NijithaS		Bru-HIMS-CRF-351											 
21/05/2013   IN040090       Chowminya G	    Linked Issue: New format age components in local language											 
03/06/2013	  EMG   		Chowminya G	  PACS LIVE issue										 
16/12/2013	 IN045646	    Chowminya	  Speciality name in report header has to be long name									 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS									 
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
06/04/2020	IN071865		Sivabagyam M		06/04/2020		Ramesh G		ML-MMOH-CRF-1484
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
---------------------------------------------------------------------------------------------------------
*/ 
%>	

	<!--
		Author	: Arvind Singh Pal
		Purpose : Created For GHL-CRF-0043 
		Date		: 16 November 2009

		-->

<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,eCommon.XSSRequestWrapper"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	Properties p = (Properties) session.getValue("jdbc");
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = (String)session.getValue("facility_id");

	String patientid = request.getParameter("patient_id") == null ? "": request.getParameter("patient_id");
	String fromdate = request.getParameter("from_date") == null ? "": request.getParameter("from_date");	
	String todate = request.getParameter("to_date") == null ? ""	: request.getParameter("to_date");
	
		
	String indno = request.getParameter("indno") == null ? "": request.getParameter("indno");
	
	int includeNotes=0;
	if(!indno.equals(""))
	   includeNotes=Integer.parseInt(indno);
	   
	
	String performed_by_id = request.getParameter("practitioner_id") == null ? ""	: request.getParameter("practitioner_id");
	String pract_type = request.getParameter("pract_type") == null ? "": request.getParameter("pract_type");
	if (pract_type.equals("all"))
		pract_type = "";

	String encounter_id = request.getParameter("encounter") == null ? "": request.getParameter("encounter");	
	
	String appl_task = request.getParameter("appl_task") == null ? ""	: request.getParameter("appl_task");
	String enc_id = request.getParameter("enc_id") == null ? "0": request.getParameter("enc_id");
	String start = request.getParameter("start") == null ? "1"	: request.getParameter("start");
	String end = request.getParameter("end") == null ? "3" : request.getParameter("end");

	String displstart = request.getParameter("displstart") == null ? "1" : request.getParameter("displstart");	
	int startIndex = 0;
	int endIndex = 3;
	int pageNo = Integer.parseInt(displstart);	
		startIndex = Integer.parseInt(start);
		endIndex = Integer.parseInt(end);	

	String encounterIDBeanKey = "";
	if (enc_id.equals(""))
		enc_id = "0";

	String patient_name = "";
	String patient_age = "";
	String gender = "";
	String patient_class = "";
	String admission_date = "";
	String discharge_date = "";
	String locn_desc = "";
	String specialty_name = "";
	String attending_practitioner = "";
	String encounter_id_prev = "";
	

	encounterIDBeanKey = enc_id;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine) getObjectFromBean("manageEmailBean" + patientid + encounterIDBeanKey,"eCA.PatientBannerGroupLine", session);
	//INO30714 Starts
	String facilityId = (String)session.getValue("facility_id");
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN038439
	String contr_mod_accession_num = "";//IN038439
	contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num"); //IN038439
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 =	null;
	ResultSet rs2 =	null;
	ResultSet rs1 =	null;
	//String performed_by_id	=	"" ;
	//String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	//String attending_practitioner	=	"" ;
	String admitting_practitioner	=	"" ;
	String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	//String gender	=	"" ;
	//String patient_name	=	"" ;
	String speciality_name	=	"" ;
	String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String url1					=	"";
	String url						=	"";
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
	String med_service 	=	"", location_code 	=	"";
	HashMap<String,String> paramMap = null;
	
	//INO30714 ends
%>

		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
			type='text/css'></link>
		<script src='../../eCA/js/ViewClinicalDocument.js' language='javascript'
			type="text/javascript"></script>
		<!-- <script src='../../eCA/js/CAOpenExternalApplication.js'
			language='javascript' type="text/javascript"></script> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'
			type="text/javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'
			type="text/javascript"></script>
		

</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="view_form" id="view_form" action=""><script language="javascript" type="text/javascript">
				document.body.style.scrollbarBaseColor='#E2E3F0';
				document.body.style.scrollbarArrowColor='#000080';
				document.body.style.scrollbarDarkShadowColor='#E2E3F0';
				document.body.style.scrollbarFaceColor='#E2E3F0';
				document.body.style.scrollbarHighlightColor='white';
				document.body.style.scrollbarShadowColor='#E2E3F0';
				document.body.style.scrollbar3dlightColor='#E2E3F0';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 
		<%
				Connection con = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt = null;
				PreparedStatement stHist = null;
				ResultSet rs = null,rsEnc= null;
				

				ArrayList keyList = manageEmailBean.returnList2();				

				StringBuffer sql = new StringBuffer();
				String outdata = ""; 
				String enctr_id = "";
				int pageCnt = 0;

				String resp_id = (String) session.getValue("responsibility_id");
				if (resp_id == null)
					resp_id = "";
				String sqlstr = "", conf_access_flag = "";
				String performed_by = "";
				
				int histcount = 0; 	
 	try {
 		con = ConnectionManager.getConnection();
		sqlstr = "SELECT patient_name patient_name, get_age (date_of_birth) patient_age, sex gender FROM mp_patient WHERE patient_id = ? ";
		
		stmt2 = con.prepareStatement(sqlstr);
 		stmt2.setString(1, patientid); 		
 		rs = stmt2.executeQuery();

 		if (rs != null && rs.next()) {
 			patient_name = rs.getString("patient_name")==null?"":rs.getString("patient_name");
			patient_age = rs.getString("patient_age")==null?"":rs.getString("patient_age");
			gender = rs.getString("gender")==null?"":rs.getString("gender");
			if(gender.equals("M") )
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");//INO30714
			else if(gender.equals("F") )
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");//INO30714
			else
				Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");	//INO30714		
 		}
		if(rs != null)rs.close();
		if(stmt2 != null)stmt2.close();

		sqlstr = "SELECT  decode(PATIENT_CLASS,'OP','Outpatient','EM','Emergency','IP','Inpatient','DC','Daycare','XT','External') patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(A.FACILITY_ID,A.ASSIGN_CARE_LOCN_CODE,?,'1')  END LOCN_DESC,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1')    SPECIALTY_NAME,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,1) ATTENDING_PRACTITIONER,NVL(TO_CHAR(DISCHARGE_DATE_TIME ,'DD/MM/YYYY HH24:MI') ,'') DISCHARGE_DATE_TIME  FROM	PR_ENCOUNTER A 	WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?"; //IN045646 get_desc for specialty_name changed from 2 to 1
		stmt2 = con.prepareStatement(sqlstr);		
 		
     sql.append(" select * from ( ");
 		//6484 Start.
		//sql.append("  Select RANK() OVER (ORDER BY event_date DESC) RANK_NO , a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,RESULT_NUM_PREFIX||DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind normalcy_str,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA,a.request_num_seq From cr_encounter_detail a  where a.patient_id = ? ");
		sql.append("  Select RANK() OVER (ORDER BY event_date DESC) RANK_NO , a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,RESULT_NUM_PREFIX||DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind normalcy_str,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA,(SELECT b.compress_hist_data_yn FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn,(SELECT b.compress_hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data,(SELECT b.comments FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) comments,a.request_num_seq From cr_encounter_detail a  where a.patient_id = ? ");
		//6484 End.
		if (!conf_access_flag.equals("A")) 

 		if (!conf_access_flag.equals("A"))
 			sql.append(" and nvl(PROTECTION_IND,'N')!='Z' ");

 		sql.append(" and nvl(a.STATUS,'`') not in('S','E')");

 		if (!fromdate.equals("")) {
 			sql.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
 		}
 		if (!todate.equals("")) {
 			sql.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 ");
 		}

 		if (!appl_task.equals(""))

 			sql.append("AND a.EVENT_CODE IN (SELECT a.NOTE_TYPE FROM CA_NOTE_TYPE a, ca_note_group b WHERE b.NOTE_GROUP = a.NOTE_GROUP_ID AND b.appl_task_id IN ("	+ appl_task + "))");

 		if (!pract_type.equals("") && performed_by_id.equals(""))
 			sql.append("AND a.PERFORMED_BY_ID IN (select b.PRACTITIONER_ID from AM_PRACTITIONER b where b.PRACT_TYPE = ?)");

 		if (!encounter_id.equals(""))
 			sql.append(" and a.ENCOUNTER_ID = ? ");

 		if (!performed_by_id.equals(""))
 			sql.append(" and a.performed_by_id = ? ");
		sql.append(")"); 
		
		if (!indno.equals(""))
 			sql.append(" where RANK_NO <=? ");

		
 		sql.append("order by  hist_rec_type_desc,event_class_desc,nvl(request_num_seq,'0'),event_group_desc ");//IN071865  //Un Commented 
		//sql.append("order by sort_event_date desc, hist_rec_type_desc,event_class_desc,nvl(request_num_seq,'0'),event_group_desc ");//IN071865 //Commented
 		sql.append(" , event_desc, sort_event_date desc ");//removed event date and appended above for IN071865  //Un Commented 
		//sql.append(", event_desc "); //Commented 
		
		

 		outdata = outdata+ "<table class='grid' cellspacing=0 cellpadding=0 width='100%'>"; 	

 		stmt = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,
											  ResultSet.CONCUR_UPDATABLE);
 		int count1 = 0;
		stmt.setString(++count1, locale);
 		stmt.setString(++count1, locale);
 		stmt.setString(++count1, locale);
 		stmt.setString(++count1, locale);
 		stmt.setString(++count1, locale);
 		stmt.setString(++count1, locale);
 		stmt.setString(++count1, patientid);

 		if (!fromdate.equals(""))
 			stmt.setString(++count1,com.ehis.util.DateUtils.convertDate(fromdate,"DMYHM",locale,"en"));

 		if (!todate.equals(""))
 			stmt.setString(++count1, com.ehis.util.DateUtils.convertDate(todate,"DMYHM",locale,"en"));

 		if (!pract_type.equals("") && performed_by_id.equals(""))
 			stmt.setString(++count1, pract_type);

 		if (!encounter_id.equals(""))
 			stmt.setString(++count1, encounter_id);

 		if (!performed_by_id.equals(""))
 			stmt.setString(++count1, performed_by_id);

		if (!indno.equals(""))
 			stmt.setInt(++count1,includeNotes);

 		rs = stmt.executeQuery();

 		String preveventdatetime = "";
 		String prevhisttype = "";
 		String preveventclass = "";
 		String preveventgroupevent = "";
 		String colspanval = "3";
 		String classValue = "", quick_text_image_visible = "";
 		String displayStyle = "gridDataChart";
 		String histdatatype = "";
 		String histrectype = "";
 		String accessionnum = "";
 		String eventdatetime = "";
 		String sortEventDateTime = "";
 		String eventdatetime_th = "";
		String cal_eventdate = "";//IN040090

 		String histtypedesc = "";
 		String eventclassdesc = "";
 		String eventgroupdesc = "";
 		String eventdesc = "";
 		String resultstr = "";
 		String encline = "";
 		String range = "";
 		String extimageapplid = "";
		String extimageobjid = "";//EMG
 		String contr_sys_id = "";
 		String contr_sys_event_code = ""; 		
 		String strStatus = "";
 		String data = "";
 		String pacsimg = "";
 		String sqlHist = "";
 		String curreventgroupevent = ""; 	
		StringBuffer enc_details = null;
 		
 		StringBuffer displaydata = new StringBuffer(); 		
 		StringBuffer toolTip = new StringBuffer();
		java.io.BufferedReader r;
		Clob note;

 		int i = 1, txt_count = 0; 	
 		int quick_text_count = 0; 		

 		sqlHist = "select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=?";
 		stHist = con.prepareStatement(sqlHist);

 		if (rs != null) {
			
			while (rs.next())
				pageCnt++;			
			
			rs.beforeFirst();
			if ( startIndex != 1 ){
				for( int j=1; j<startIndex; i++,j++ )					
					rs.next() ;
			}		
			
 			while (rs.next() && i <= endIndex) 
			{				
				enc_details = new StringBuffer();
					patient_class = "";
					admission_date = "";
					discharge_date = "";
					locn_desc = "";
					specialty_name = "";
					attending_practitioner = "";
					
 					toolTip.setLength(0);
 					txt_count = 0;
 					quick_text_count = 0;
 					data = "";
 					quick_text_count = rs.getInt("QUICK_TEXT_COUNT");
 					if (quick_text_count == 1)
 						quick_text_image_visible = "style='display'";
 					else
 						quick_text_image_visible = "style='display:none'";

 					histdatatype = rs.getString("HIST_DATA_TYPE") == null ? ""	: rs.getString("HIST_DATA_TYPE");

 					histrectype = rs.getString("HIST_REC_TYPE") == null ? ""	: rs.getString("HIST_REC_TYPE");

 					accessionnum = rs.getString("ACCESSION_NUM") == null ? "": rs.getString("ACCESSION_NUM");
 					enctr_id = rs.getString("encounter_ID") == null ? "0": rs.getString("encounter_ID");					
 					eventdatetime = rs.getString("event_date_time") == null ? "": rs.getString("event_date_time");
 					sortEventDateTime = rs.getString("sort_event_date") == null ? "": rs.getString("sort_event_date");
					cal_eventdate 		= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en","en");//IN040090
 					eventdatetime_th    = com.ehis.util.DateUtils.convertDate(eventdatetime, "DMYHM", "en",	locale);

 					histtypedesc = rs.getString("hist_rec_type_desc") == null ? "": rs.getString("hist_rec_type_desc");

 					eventclassdesc = rs.getString("event_class_desc") == null ? ""	: rs.getString("event_class_desc");
 					eventgroupdesc = rs.getString("event_group_desc") == null ? "": rs.getString("event_group_desc");
 					eventdesc = rs.getString("event_desc") == null ? ""	: rs.getString("event_desc");
 					resultstr = rs.getString("RESULT_STR") == null ? ""	: rs.getString("RESULT_STR");

 					encline = rs.getString("encline") == null ? "" : rs	.getString("encline");
 					encline = encline.replace('\'', ' ');
 					range = "";

					extimageapplid = rs.getString("EXT_IMAGE_APPL_ID") == null ? ""	:rs.getString("EXT_IMAGE_APPL_ID");
					extimageobjid = rs.getString("EXT_IMAGE_OBJ_ID") == null ? ""	:rs.getString("EXT_IMAGE_OBJ_ID");//EMG
					performed_by = rs.getString("clinician_short_name") == null ? "": rs.getString("clinician_short_name");

					contr_sys_id = rs.getString("contr_sys_id") == null ? "": rs.getString("contr_sys_id");
					contr_sys_event_code = rs.getString("contr_sys_event_code") == null ? "": rs.getString("contr_sys_event_code");
					//INO30714 Starts
		try
		{
			if(	episode_type.equals("O") )
			{
				
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN045646 get_desc for specialty_name changed from 2 to 1
			}
			else
			{ 
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN045646 get_desc for specialty_name changed from 2 to 1
			}
			
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
			pstmt1.setString	(	11,	facilityId	);
			pstmt1.setString	(	12,	enc_id);
			
			rs1		=	pstmt1.executeQuery();
			
			if(rs1.next())
			{
				patient_class	=	rs1.getString("patient_class") == null ? "" : rs1.getString("patient_class");
				facility_name			=	rs1.getString("facility_name") == null ? "" : rs1.getString("facility_name");
				visit_adm_date			=	rs1.getString("visit_adm_date")==null?"":rs1.getString("visit_adm_date");
				med_service			=	rs1.getString("service_name")==null?"":rs1.getString("service_name");
				discharge_date		=	rs1.getString("DISCHARGE_DATE_TIME")==null?"":rs1.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	rs1.getString("attending_practitioner")==null?"":rs1.getString("attending_practitioner");
				admitting_practitioner	=	rs1.getString("admitting_practitioner")==null?"":rs1.getString("admitting_practitioner");
				bed_number	=	rs1.getString("bed_number")==null?"":rs1.getString("bed_number");	  //--[IN:029839]--
				performing_phy_name	=	rs1.getString("performed_by_name")==null?"":rs1.getString("performed_by_name");
				age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
				gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");
				//locationDesc			=	rs1.getString("location");
				location_code			=	rs1.getString("location_code")==null?"":rs1.getString("location_code");
				patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
				speciality_name			=	rs1.getString("specialty_name")==null?"":rs1.getString("specialty_name");
				printDateTime			=	rs1.getString("print_date_time")==null?"":rs1.getString("print_date_time");
				site_name			=	rs1.getString("site_name")==null?"":rs1.getString("site_name");
				//performed_by_desc			=	rs1.getString("performed_by_desc");


			
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
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
		}
								try
								{
									String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
									pstmt2	= con.prepareStatement(head_foot_qry);
									pstmt2.setString(1,contr_sys_event_code);
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
							if(!accessionnum.equals(""))
							{
								try
								{
									String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

									pstmt2	= con.prepareStatement(athorise_by_qry);
									pstmt2.setString(1,locale);
									pstmt2.setString(2,locale);
									pstmt2.setString(3,locale);
									pstmt2.setString(4,locale);
									pstmt2.setString(5,accessionnum);
									pstmt2.setString(6,patientid);
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
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());//common-icn-0181
									roro.printStackTrace();

								}
								finally 
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									
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
							htParameter.put("V$PT_ID", patientid);
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
								//***************************** [CRF-118] Start *****************************					
								eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
								HashMap paramHash=new HashMap();
								Hashtable tempParameter=new Hashtable();
								paramHash.put("#p_patient_id#",patientid);
								paramHash.put("#p_encounter_id#",encounter_id1);
								paramHash.put("#p_accNum#",accessionnum);
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
							paramHash.put("#p_accNum#",accessionnum);
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
						//Footer Ends
					//INO30714 Ends
					
					//6484 Start.
					displaydata = new StringBuffer();
					
					if("Y".equals(rs.getString("compress_hist_data_yn")==null?"":(String)rs.getString("compress_hist_data_yn"))){
				
						java.sql.Blob img_blob =  (java.sql.Blob)rs.getBlob("compress_hist_data");
						if(img_blob!=null && img_blob.length()>0){
							InputStream ins1 = img_blob.getBinaryStream();
							ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
							int g;
							while((g = ins1.read()) != -1) 
								bytearrayoutputstream.write(g);
							
							byte[] compressed	=bytearrayoutputstream.toByteArray();
							if(compressed.length > 0){
								if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
									GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
									BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

									String line;
									while ((line = bufferedReader.readLine()) != null) {
										displaydata.append(line+"\n");
									}
								}					
							}
						}
					}else{
					//6484 End.
						note=rs.getClob("HIST_DATA");
						
						if(note!=null)
						{
							 r = new java.io.BufferedReader(note.getCharacterStream());
							String line = null;					
							while((line=r.readLine()) != null) displaydata.append(line+"\n");
							
						}
					}
					displaydata.append((rs.getString("comments")==null?"":(String)rs.getString("comments"))); //6484.
				if(histrectype.equals("CLNT") || histdatatype.equals("HTM"))
				{
					//data="<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>";//INO30714
					data=data+""+resultstr+" "+displaydata.toString()+"<hr width='100%' style='background-color:red;height:5px;' / >";//INO30714
					data=data+"<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>";//INO30714
				}
				else
				{
					if(displaydata.length() >0){
					data=resultstr+" "+"<br/><textarea align='ABSLEFT' style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows='10' cols='100' readOnly>"+displaydata.toString()+"</textarea>"+"<hr width='100%'  style='background-color:red;height:5px;' / >";
					}
					else
						data=resultstr+" "+displaydata.toString()+"<hr width='100%' style='background-color:red;height:5px;' / >";		
				}
				

 					strStatus = rs.getString("STATUS");
 					if (strStatus == null)
 						strStatus = "";

 					if (keyList.contains(enctr_id + "`" + histrectype+ "`" + contr_sys_id + "`" + accessionnum+ "`" + contr_sys_event_code))
 						displayStyle = "gridDataSelect";
 					else
 						displayStyle = "gridDataChart";
 					
 				/*	if (!extimageapplid.equals("")) {

 					data ="<img src='../../eCA/images/"+ extimageapplid+ ".gif' onClick=\" getFile('"+ histrectype + "','" + contr_sys_id+ "','" + accessionnum + "','"+ contr_sys_event_code + "','"+ extimageapplid + "')\">&nbsp;"+data;
					}*/
					//Added docul condition for EMG
					if ( (extimageapplid != null && (!extimageapplid.equals("")))) 
					{
						if(!("DOCUL").equals(extimageapplid)) 
						{
							//IN050936 included patient_id
							data ="<img src='../../eCA/images/"+ extimageapplid+ ".gif' alt='Result' onClick=\" getFile('"+ histrectype + "','" + contr_sys_id+ "','" + extimageobjid + "','"+ contr_sys_event_code + "','"+ extimageapplid + "','"+patientid+"')\">&nbsp;"+data;
						}
						else
						{
							//IN050936 included patient_id
							data ="<img src='../../eCA/images/"+ extimageapplid+ ".gif' alt='Result' onClick=\" getFile('"+ histrectype + "','" + contr_sys_id+ "','" + accessionnum + "','"+ contr_sys_event_code + "','"+ extimageapplid + "','"+patientid+"')\">&nbsp;"+data;
						}
											
					}	
 					if (!prevhisttype.equals(histtypedesc)) { 					

 						if (!prevhisttype.equals(""))
 							outdata = outdata + "</table></td></tr>";
 						outdata = outdata+ "<tr><td colspan='"+ colspanval+ "' class=CAHIGHERLEVELCOLOR> " + histtypedesc+ "</td></tr>";			
 					
 						
 					}
 					if (!preveventclass.equals(eventclassdesc)) {
							histcount++;
							if (!preveventclass.equals(""))
 							outdata = outdata + "</table></td></tr>";
							
 						outdata = outdata + "<tr><td colspan='"+ colspanval	+ "' class='CAGROUP'><input type=button name='collapse' id='collapse' value=' - ' onclick=\"collapseExpand(this,'"+ histcount + "');\"><font size=1>"	+ eventclassdesc + "</font></td></tr>";
						//outdata = outdata + "</table></td></tr>";
						outdata = outdata+ "<tr><td><table width='100%' id='tableId"+ histcount + "'>";
						
 						
 					}
				//out.println("<script>alert('"+sortEventDateTime+"')</script>");				

					if(!encounter_id_prev.equals(enctr_id)) {
						
						stmt2.setString(1,locale);
						stmt2.setString(2,locale);
						stmt2.setString(3,locale);
						stmt2.setString(4,locale);
						stmt2.setString(5,facility_id);
						stmt2.setString(6,enctr_id);
						rsEnc = stmt2.executeQuery();
						if(rsEnc != null && rsEnc.next())
						{						
							//patient_class = rsEnc.getString("PATIENT_CLASS")==null?"":rsEnc.getString("PATIENT_CLASS");
							admission_date = rsEnc.getString("ADMISSION_DATE")==null?"":rsEnc.getString("ADMISSION_DATE");
							discharge_date = rsEnc.getString("DISCHARGE_DATE_TIME")==null?"":rsEnc.getString("DISCHARGE_DATE_TIME");
							locn_desc = rsEnc.getString("LOCN_DESC")==null?"":rsEnc.getString("LOCN_DESC");
							specialty_name = rsEnc.getString("SPECIALTY_NAME")==null?"":rsEnc.getString("SPECIALTY_NAME");
							attending_practitioner = rsEnc.getString("ATTENDING_PRACTITIONER")==null?"":rsEnc.getString("ATTENDING_PRACTITIONER");
					
							
							enc_details.append("<tr><td colspan='"+ colspanval+ "'><table width='100%'><tr><td><B>PatientID</td><td>&nbsp;:&nbsp;</B>"+patientid+"</td>");
							enc_details.append("<td><B>Patient Name</td><td>&nbsp;:&nbsp;</B>"+patient_name+"</td></tr>");
							enc_details.append("<tr><td><B>Gender</td><td>&nbsp;:&nbsp;</B>"+Sex+"</td>");//INO30714
							enc_details.append("<td><B>Age</td><td>&nbsp;:&nbsp;</B>"+patient_age+"</td></tr>");
							enc_details.append("<tr><td><B>Encounter ID</td><td>&nbsp;:&nbsp;</B>"+enctr_id+"</td>");
							enc_details.append("<td><B>Encounter Type</td><td>&nbsp;:&nbsp;</B>"+patient_class+"</td></tr>");
							enc_details.append("<tr><td><B>Admission Date</td><td>&nbsp;:&nbsp;</B>"+com.ehis.util.DateUtils.convertDate(admission_date,"DMYHM","en",locale)+"</td>");
							enc_details.append("<td><B>Discharge Date</td><td>&nbsp;:&nbsp;</B>"+com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale)+"</td></tr>");
							enc_details.append("<tr><td><B>Location</td><td>&nbsp;:&nbsp;</B>"+locn_desc+"</td></tr>");				
							enc_details.append("<tr><td><B>Specialty</td><td>&nbsp;:&nbsp;</B>"+specialty_name+"</td>");
							enc_details.append("<td><B>Attending Practitioner</td><td>&nbsp;:&nbsp;</B>"+attending_practitioner+"</td></tr></table></td></tr>");			
							outdata += enc_details.toString();
						}
						
					
					}
			


 					if (!eventgroupdesc.equals(""))
 						curreventgroupevent = "(" + eventgroupdesc+ ")-" + eventdesc;
 					else
 						curreventgroupevent = eventdesc;

 					if (!curreventgroupevent
 							.equals(preveventgroupevent)) {
 						if (!eventgroupdesc.equals("")) {
 							outdata = outdata+ "<tr><td colspan='"+ colspanval+ "' class=CAFOURTHLEVELCOLOR><font size=1> ("+ eventgroupdesc + ")- "+ eventdesc + "</font></td></tr>";
 							
 						} else {
 						outdata = outdata+ "<tr><td colspan='"+ colspanval+ "' class=CAFOURTHLEVELCOLOR><font size=1> "+ eventdesc + "</font></td></tr>";
 							
 						}
 					}

 					if (i % 2 == 0)
 						classValue = "QRYEVEN";
 					else
 						classValue = "QRYODD";

 					outdata = outdata+ "<tr><td class='TD_BROWN'  width='10%' ><font size=1></font></td><td class='TD_BROWN' id='"+ i + "'><font size=1>" + data + " </font>"+ pacsimg + "</td></tr>";		 
					
					
						

					i++; 			
					preveventdatetime = eventdatetime;
					prevhisttype = histtypedesc;
					preveventclass = eventclassdesc;
					preveventgroupevent = curreventgroupevent;
					encounter_id_prev = enctr_id;
		}								
				int mode= (pageCnt/3)*3+(pageCnt%3);				
				if(startIndex > 1 && mode <pageCnt)								
						pageNo++;					
				
				//else if (pageNo == Math.ceil(pageCnt/3) && (pageCnt%3 != 0))
				//{
				//		pageNo++;					
				//}
				start = String.valueOf(startIndex + 3);
				end = String.valueOf(endIndex + 3);
				
				
			
			
				outdata = outdata + "</table></td></tr>";
				outdata = outdata + "</table>";
				outdata = outdata.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML-MMOH-SCF-2966
				out.println(outdata);

 		}
		
 		if (pageCnt == 0) {
 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
 			out.println("</script>");
 		}

 		if (rs != null)
 			rs.close();
 		if (stmt != null)
 			stmt.close();
 		if (stmt2 != null)
 			stmt2.close();
 		if (stHist != null)
 			stHist.close();
 		

 	} catch (Exception e) {
 		
 		e.printStackTrace();
 	} finally {
 		if (con != null)
 			ConnectionManager.returnConnection(con);
 	}
 %>

<input type="hidden" name="pageCnt" id="pageCnt" value='<%=pageCnt%>'> 

<script	type="text/javascript"> 

 function loadPagination()
	{
	var idx_value	= document.getElementById("pageCnt").value;
	//alert("idx_value    :    "+idx_value);
	if (idx_value != "" && idx_value > 0)
		idx_value = Math.ceil(idx_value/3);	
	var fromDateTime ="";
	var toDateTime ="";
	var displend = "";	

	/*if(idx_value > 0)
	{*/
		if (idx_value >= 1)
		{					
			parent.pagination.document.getElementById('tablePrevNext').style.display = "inline";	
			displend = eval(idx_value) ;
			displend = "Page <%=pageNo%> of "+displend
		}
		else{
			displend = "";
		}
		
		parent.pagination.document.getElementById('start').value="<%=start%>";
		parent.pagination.document.getElementById('end').value="<%=end%>";
		parent.pagination.document.getElementById('patientid').value="<%=patientid%>";
		parent.pagination.document.getElementById('fromdate').value="<%=fromdate%>";
		parent.pagination.document.getElementById('todate').value="<%=todate%>";
		parent.pagination.document.getElementById('indno').value="<%=indno%>";
		parent.pagination.document.getElementById('performed_by_id').value="<%=performed_by_id%>";
		parent.pagination.document.getElementById('pract_type').value="<%=pract_type%>";
		parent.pagination.document.getElementById('encounter_id').value="<%=encounter_id%>";
		parent.pagination.document.getElementById('appl_task').value="<%=appl_task%>";
		parent.pagination.document.getElementById('enc_id').value="<%=enc_id%>";	
		parent.pagination.document.getElementById('displstart').value="<%=pageNo%>";	
		parent.pagination.document.getElementById('label_cap').innerText = displend;	
		
		
		if('<%=pageCnt%>'>3){	
			
				if("<%=pageNo%>" == 1)
				{					
					parent.pagination.document.forms[0].nextPage.disabled = false;
					parent.pagination.document.forms[0].prevPage.disabled = true;
					parent.pagination.document.forms[0].firstPage.disabled = true;
					parent.pagination.document.forms[0].lastPage.disabled = false;
				}else if(idx_value == "<%=pageNo%>")
				{			
					parent.pagination.document.forms[0].nextPage.disabled = true;
					parent.pagination.document.forms[0].prevPage.disabled = false;
					parent.pagination.document.forms[0].firstPage.disabled = false;
					parent.pagination.document.forms[0].lastPage.disabled = true;			
				}else{
					parent.pagination.document.forms[0].nextPage.disabled = false;
					parent.pagination.document.forms[0].prevPage.disabled = false;
					parent.pagination.document.forms[0].firstPage.disabled = false;
					parent.pagination.document.forms[0].lastPage.disabled = false;
				}
		}
		else{
				if(idx_value > 0)
				{
					parent.pagination.document.forms[0].nextPage.disabled = true;
					parent.pagination.document.forms[0].prevPage.disabled = true;
					parent.pagination.document.forms[0].firstPage.disabled = true;
					parent.pagination.document.forms[0].lastPage.disabled = true;
				}else{					
					parent.pagination.document.getElementById('tablePrevNext').style.display = "none";					
				}
			}

	//}
	}

loadPagination();
</script>
<input type="hidden" name="totalPage" id="totalPage" value='<%=pageCnt%>'>
</form>
</body>
</html>
<%!
	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
	}
	%>


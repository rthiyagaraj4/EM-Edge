<!--
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name        		Description
--------------------------------------------------------------------------------------------------------------
?           100				?	          		created
09/07/2012  IN033511		Chowminya G			When Login Thai and view existing note ?Print? button disappear
22/02/2013	IN036821		Chowminya G			Reporting Practitioner name not coming in the CA report
25/03/2013	IN038840		Nijitha	S			CRF-CA- CHL-CRF-0011/05- Social History Widget->If the Role is modified after sign note we get script error
08/01/2014	IN045365		Dinesh T			Clinical Notes Access Rights Author But Without Authorization Facility
												I have setup access level for 1 of the notes as Author but without Authorization Facility.
06/05/2015	IN053733		Ramesh G			When a notifiable recorded against a notifiable diagnosis is marked in error, 
												the notification to be de-linked from the parent diagnosis
18/11/2015	IN057113		Karthi L			ML-MMOH-CRF-0335 - IN057113	
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/01/2018	IN064446		Raja S			08/01/2018		Ramesh G		GHL-CRF-0469
22/05/2018	IN067607		Raja S			22/05/2018		Ramesh G		ML-MMOH-CRF-1130.2
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
07/08/2018	IN063818		Raja S			07/08/2018		Ramesh G		MMS-DM-CRF-0102
04/03/2019	IN066806		Ramya Maddena		04/03/2019		Ramesh G		AMRI-CRF-0339
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*, java.util.*,java.text.*, webbeans.eCommon.*, org.json.simple.*,eOR.*,eCA.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
	<title>RecClinicalNotesToolbar</title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String ca_practitioner_id		=	(String)session.getValue("ca_practitioner_id");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>

<script language="javascript" src="../../eCA/js/RecClinicalNotesPart1.js"></script>
<script language="javascript" src="../../eCA/js/RecClinicalNotesPart2.js"></script>
<script language="javascript" src="../../eCA/js/RecClinicalNotesPart3.js"></script>	
<script language="javascript" src="../../eCA/js/RecClinicalNotesFileUpload.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	PreparedStatement	pstmt2	=	null;
	
	ResultSet			rs		=	null, rs1=null,rs2=null;

	String	printDateTime="",			dischargeDateTime="",	authorizedBy="",	event_date_time ="", lastModifiedBy="";
	String	attending_practitioner	=	"",		note_header_desc		=	"";	
	String  admitting_practitioner	=	"";
	String	note_type				=	"",		operations_allowed		=	"";
	String	facility_id				=	"",		accession_num			=	"";
	String	button_name				=	"",		amendment_type			=	"";
	String	privilege_type			=	"",		resp_id					=	"";
	String	performed_by_id			=	"",		function_id				=	"";
	String	encounter_id			=	"",		patient_line			=	"";
	String	facility_name			=	"",		visit_adm_date			=	"";
	String	specialty_name			=	"",		error_docs_exists		=	"";
	String	episode_type			=	"";
	String	patient_name			=	"";
	String	patient_age				=	"";
	String	patient_sex				=	"";
	String	patient_id				=	"";
	String	patientName_Local_Lang	=	null;
	String	loggedUser				=	"";
	String	figer_print_auth_yn		=	"";
	String	query_privilege_type	=	"",		strSql="";
	String	discharge_summary_text="";
	String	performed_by_name 	= "";
	String	locationDesc		= "";
	String	doc_linked_note_yn	= "";
	String	sec_count		= "";
	String	window_close		= "";
	String	oledb_con_string	= "";
	String	sqlSite			= "";
	String	gender			= "";
	String	location_code		= "";
	String	performed_by_desc	= "";
	String	speciality_code		= "";
	String	med_service		= "";
	String	res_encounter_id	= "";
	String	status_display_text	= "";
	String	appl_task_id		= "";
	String	user_privilage_id	= "";
	String	print_privilage		= "";
	String	email_privilage		= "";
	String	note_status		= "";	//--[IN033511]
	String  notifiable_code		= "";		//IN053733
	String dischargedYN	= "Y"; //IN066806
	String  noteGroupYN		= ""; //IN066806
	boolean isModifyDisable 	= false; //IN066806
	JSONObject jsonObj		= new JSONObject(); //IN066806
	/*To include siteName in the header part of the report */
    String orderStatusCodeHdr=""; //68801
	String siteName="";
	
	//ML-MMOH-CRF-0335 - IN057113 - Start
	String conf_pin_req_yn = ""; 
	String bean_id = "Or_ViewOrder" ; 
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;	
	conf_pin_req_yn = bean.isPrintPinValidReq(); //ML-MMOH-CRF-0335 - IN057113
	//ML-MMOH-CRF-0335 - IN057113 - End
	StringTokenizer		stoken			=	null;
	Properties				jdbc_props	=	null;
	ArrayList				arrFunctions	=	new ArrayList();

	note_type				=	checkForNull(request.getParameter("note_type"));
	facility_id				=	checkForNull(request.getParameter("facility_id"));
	accession_num			=	checkForNull(request.getParameter("accession_num"));
	performed_by_id			=	checkForNull(request.getParameter("performed_by_id"));
	operations_allowed		=	checkForNull(request.getParameter("operations_allowed"));
	amendment_type			=	checkForNull(request.getParameter("amendment_type"));
	function_id				=	checkForNull(request.getParameter("function_id"));
	encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	doc_linked_note_yn		=	checkForNull(request.getParameter("doc_linked_note_yn"));
	sec_count				=	checkForNull(request.getParameter("sec_count"));
	error_docs_exists		=	checkForNull(request.getParameter("error_docs_exists"));
	episode_type			=	checkForNull(request.getParameter("episode_type"));
	patient_id				=	checkForNull(request.getParameter("patient_id"));
	window_close			=	checkForNull(request.getParameter("window_close"));
	performed_by_name		=	checkForNull(request.getParameter("performed_by_name"));
	speciality_code		=	checkForNull(request.getParameter("speciality_code"));
	appl_task_id		=	checkForNull(request.getParameter("appl_task_id"));
	note_status		=	checkForNull(request.getParameter("note_status")); //--[IN033511]
	String patientClass = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
	res_encounter_id = request.getParameter("res_encounter_id") == null ? "0" : request.getParameter("res_encounter_id");
	status_display_text = request.getParameter("status_display_text") == null ? "" : request.getParameter("status_display_text");
	//String status_authorized = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");//Check style fix
	//String status_modify = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");//Checkstyle fix
	notifiable_code	= 	checkForNull(request.getParameter("notifiable_code")); //IN053733
	orderStatusCodeHdr = request.getParameter("orderStatusCodeHdr") == null ? "" : request.getParameter("orderStatusCodeHdr");  //68801
	if(encounter_id == null || encounter_id.equals("") )
		encounter_id = "0";

	if(res_encounter_id == null || res_encounter_id.equals("") )
		res_encounter_id = "0";

	loggedUser = (String) session.getValue("login_user");
	oledb_con_string=(String)session.getValue("oledb_con_string");
	
	//sqlSite = "SELECT site_name FROM SM_SITE_PARAM";
	sqlSite = "SELECT 	site_name FROM 	SM_SITE_PARAM_LANG_VW where language_id = ?";
	//IN064446 changes starts
	boolean isPPSiteSpecific = false;
	String printPreviewFlag ="N";
	//IN064446 changes ends
	//IN067607 changes starts
	boolean myHIXSiteFlag = false;
	String myHIXSiteFlg ="N";
	String myHIXNoteType = "";
	//IN067607 changes ends
	//IN063818 changes starts
	boolean isModifyDescSS = false;
	String isModifyDescYN ="N";
	//IN063818 changes ends
    String isPatinetDichargedYN=""; //68801
	//strSql=" select  (select ia.DISCLIMER_TEXT from ca_disclimer_text ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE and ib.NOTE_TYPE=a.note_type) DIS_SUMM_DISCLAIMER_TXT,null REF_LETTER_DISCLAIMER_TXT, (select SHORT_NAME from am_practitioner where practitioner_id=a.authorized_by_id) Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'')  from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,(select practitioner_name from am_practitioner where practitioner_id=a.last_amended_by_id) last_modified_by_name ,(select ib.REPORT_HEADER from ca_note_group ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type)  note_header_desc from ca_encntr_note a where a.facility_id=? and a.accession_num=? ";
	strSql=" select  (select ia.DISCLIMER_TEXT from CA_DISCLIMER_TEXT_LANG_VW ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE  and ib.NOTE_TYPE=a.note_type and language_id = ?)  DIS_SUMM_DISCLAIMER_TXT,to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, null REF_LETTER_DISCLAIMER_TXT, AM_GET_DESC.AM_PRACTITIONER(A.authorized_by_id,?,'2') Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'') from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,AM_GET_DESC.AM_PRACTITIONER(a.last_amended_by_id,?,'1') last_modified_by_name ,performed_by_id, AM_GET_DESC.AM_PRACTITIONER(performed_by_id,?,'1') performed_by_name, (select ib.REPORT_HEADER from ca_note_group_lang_vw ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type and ib.language_id = ? )  note_header_desc,a.patient_id from ca_encntr_note a where 	/* a.facility_id=? and*/ a.accession_num=?";//IN036821
	try
	{
		stoken				=	new java.util.StringTokenizer(operations_allowed,"|");	

		arrFunctions.clear();

		while(stoken.hasMoreTokens())
		{
			button_name	=	(String) stoken.nextToken();
			
			if(!arrFunctions.contains(button_name) )
				arrFunctions.add(button_name);
		}	
	
		con				=	ConnectionManager.getConnection(request);
		facility_id		=	(String)		session.getValue("facility_id");
		jdbc_props		=	(Properties)	session.getValue("jdbc");
		resp_id			=	(String)		session.getValue("responsibility_id");
		
		pstmt2	=	con.prepareStatement(sqlSite);
		pstmt2.setString(1,locale);
		
		rs2		=	pstmt2.executeQuery();

		if(rs2 !=null)
		{
			rs2.next();
			siteName = rs2.getString(1);
		}

		if(rs2 !=null) 
			rs2.close();

		if(pstmt2 !=null) 
			pstmt2.close();

		//IN064446 changes starts
		isPPSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","PRINT_PREVIEW_SIGN_NOTES"); 
		if(isPPSiteSpecific)
			printPreviewFlag="Y";
		//IN064446 changes Ends
		//IN063818 Starts
		ArrayList<String> functionIds = new ArrayList<String>();
		functionIds.add("DIS_MODIFY_AS_UPDATE");
		functionIds.add("DISCHARGE_NOTE_MODIFY_YN"); //IN066806 
		String beanId					= "CAClinicalHistoryBean" ;
		String beanName				= "eCA.CAClinicalHistoryBean";
		CAClinicalHistoryBean bean1	= (CAClinicalHistoryBean)getBeanObject( beanId, beanName , request) ;
		bean1.setSiteSpecific(functionIds,"CA");
		isModifyDescSS = bean1.isSiteSpecific("DIS_MODIFY_AS_UPDATE");
		if(isModifyDescSS)
			isModifyDescYN ="Y";
		//IN063818 End.
		isModifyDisable = bean1.isSiteSpecific("DISCHARGE_NOTE_MODIFY_YN"); //IN066806 
		jsonObj =bean1.getstatusbean(con,patient_id,encounter_id,note_type);//IN066806
		dischargedYN = (String) jsonObj.get("discharged_yn");//IN066806
		noteGroupYN = (String) jsonObj.get("noteGroupYN");//IN066806	
		//IN067607 changes starts
		try
		{
		myHIXSiteFlag = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","SENT_MYHIX"); 
		if(myHIXSiteFlag)
		{
			myHIXSiteFlg="Y";

			String myHIXSql="Select DEFAULT_VALUE MYHIX_NOTE_CODE from XH_STANDARD_CONTROL_SEG where STANDARD_CODE = 'XMLSTD' and SEGMENT_ID in ('DISREGC','ENCREGC') and ELEMENT_ID = 'NOTE_TYPE'";
			pstmt2	=	con.prepareStatement(myHIXSql);
			rs2		=	pstmt2.executeQuery();
			if(rs2 != null)
			{
				while(rs2.next())
				{
					myHIXNoteType = myHIXNoteType+'|'+rs2.getString(1)+'|';
				}
			}	
		}
		}catch(Exception m){
	
			//out.println("Exception@1 : "+m);//COMMON-ICN-0181
			System.err.println("RecClinicalNotesSearchToolbar.jsp,384,message=>"+m.getMessage());
			m.printStackTrace();
		}finally{
			if(rs2 !=null) rs2.close();
			if(pstmt2 !=null) pstmt2.close();
		}
		//IN067607 changes Ends
		
		pstmt	=	con.prepareStatement(strSql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);//IN036821
		//pstmt.setString(5,facility_id);
		pstmt.setString(6,accession_num);
		rs1 = pstmt.executeQuery();

		if(rs1.next())
		{
			patientName_Local_Lang	=	 checkForNull(rs1.getString("PATIENT_NAME_LOC_LANG"));
			printDateTime			= rs1.getString("print_date_time");
			authorizedBy			= checkForNull(rs1.getString("Authorized_by_name"));
			note_header_desc		= rs1.getString("note_header_desc");
			lastModifiedBy			=checkForNull(rs1.getString("LAST_MODIFIED_BY_NAME"));
			discharge_summary_text	= checkForNull(rs1.getString("DIS_SUMM_DISCLAIMER_TXT"));
			event_date_time	= checkForNull(rs1.getString("event_date_time"));
			patient_id= checkForNull(rs1.getString("patient_id"));
			//IN036821 - Start
			if(performed_by_name.equals(""))
				performed_by_name	= checkForNull(rs1.getString("performed_by_name"));	
			//IN036821 - end	
		}	

		if(rs!=null) 
			rs.close();

		if(rs1!=null) 
			rs1.close();

		if(pstmt!=null)	
			pstmt.close();
		if (!encounter_id.equals("0"))
		{	
			//IN045365, starts
			/*if(function_id.equals("")||appl_task_id.equals("PROGRESS_NOTES")){
				query_privilege_type	=	"select privilege_type, get_patient.get_line_detail(?,?,?) patient_line, (select FIGER_PRINT_AUTH_YN from ca_note_param) figer_print_auth_yn from ca_note_type_for_resp where resp_id = ? and note_type = ? ";
			}
			else
			{
			query_privilege_type	=	"select max(privilege_type) privilege_type, get_patient.get_line_detail(?,?,?) patient_line, (select FIGER_PRINT_AUTH_YN from ca_note_param) figer_print_auth_yn from ca_note_type_for_resp where resp_id in (select resp_id from SM_RESP_FOR_USER where APPL_user_id= ? ) and note_type = ? AND privilege_type<=4 GROUP BY get_patient.get_line_detail(?,?,?) ";
			}
			*/
			//IN045365, ends
			query_privilege_type	=	"select privilege_type, get_patient.get_line_detail(?,?,?) patient_line, (select FIGER_PRINT_AUTH_YN from ca_note_param) figer_print_auth_yn from ca_note_type_for_resp where resp_id = ? and note_type = ? ";//IN045365

			pstmt	=	con.prepareStatement(query_privilege_type);

			pstmt.setString	(	1,	facility_id	);
			pstmt.setString	(	2,	encounter_id);
			pstmt.setString	(	3,	locale);
				
			//IN045365, starts
			/*if(function_id.equals("")||appl_task_id.equals("PROGRESS_NOTES"))
			{
				pstmt.setString	(	4,	resp_id		);
				pstmt.setString	(	5,	note_type	);
			}
			else
			{
				pstmt.setString	(	4,	loggedUser );
				pstmt.setString	(	5,	note_type	);
				pstmt.setString	(	6,	facility_id	);
				pstmt.setString	(	7,	encounter_id);
				pstmt.setString	(	8,	locale);
			}*/

			pstmt.setString	(	4,	resp_id		);
			pstmt.setString	(	5,	note_type	);
			//IN045365, ends

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				privilege_type	=	rs.getString("privilege_type");
				patient_line	=	rs.getString("patient_line");
				figer_print_auth_yn = rs.getString("figer_print_auth_yn");
			}
			

			if(pstmt!=null)	
				pstmt.close();
			
			if(rs!=null)
				rs.close();

			if(	episode_type.equals("O") )
			{				
				//query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner,DECODE(SEX,'M','Male','F','Female','U','Unknown') gender,get_age(DOB) AGE,(LOCN_NAME || '/' || NVL(ROOM_NUM,'') || ' '|| NVL(BED_NUM,'') )location,PATIENT_NAME from ca_op_episode_vw where facility_id = ? and episode_id = ? ";
				// by rajan on 29/07/2008query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2')  service_name,AM_GET_DESC.AM_PRACTITIONER(PHYSICIAN_ID,?,'2') attending_practitioner,SEX gender,get_age(DOB) AGE,(OP_GET_DESC.OP_CLINIC(?,LOCN_CODE,?,'1') || '/' || NVL(ROOM_NUM,'') || ' '|| NVL(BED_NUM,'') )location,LOCN_CODE locn_code,PATIENT_NAME,AM_GET_DESC.AM_SPECIALITY(?,?,'2') specialty_name from ca_op_episode_vw where facility_id = ? and episode_id = ?";
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner , ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
			}
			else
			{	
				//speciality_code
				//query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner,DECODE(SEX,'M','Male','F','Female','U','Unknown') gender,get_age(DOB) AGE ,(WARD_SHORT_DESC || '/' || nvl(CUR_ROOM_NUM,'') || '' || nvl(CUR_BED_NUM,'') ) location,patient_name  from ca_ip_active_episode_vw where facility_id = ? and episode_id = ? ";
				//rajan on 29/072008 query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(CUR_PHYSICIAN_ID,?,'2') attending_practitioner,SEX gender,get_age(DOB) AGE ,(IP_GET_DESC.IP_NURSING_UNIT(?,CUR_WARD_CODE,?,'1') || '/' || nvl(CUR_ROOM_NUM,'') || '' || nvl(CUR_BED_NUM,'') ) location,CUR_WARD_CODE locn_code, patient_name ,AM_GET_DESC.AM_SPECIALITY(?,?,'2') specialty_name from ca_ip_active_episode_vw where facility_id = ? and episode_id = ?";
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner , ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
			}

			pstmt	=	con.prepareStatement(query_privilege_type);
			pstmt.setString	(	1,	locale	);
			pstmt.setString	(	2,	locale	);
			pstmt.setString	(	3,	locale	);
			pstmt.setString	(	4,	locale	);
			pstmt.setString	(	5,	locale	);			
			pstmt.setString	(	6,	locale	);			
			pstmt.setString	(	7,	locale	);			
			pstmt.setString	(	8,	facility_id	);
			pstmt.setString	(	9,	encounter_id);

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				facility_name			=	rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date");
				med_service			=	rs.getString("service_name");
				dischargeDateTime		=	rs.getString("DISCHARGE_DATE_TIME");
				attending_practitioner	=	rs.getString("attending_practitioner");
				admitting_practitioner	=	rs.getString("admitting_practitioner");
				patient_age				=	rs.getString("AGE");
				gender					=	rs.getString("gender");
				locationDesc			=	rs.getString("location");
				location_code			=	rs.getString("locn_code");
				patient_name			=	rs.getString("patient_name");
				specialty_name			=	rs.getString("specialty_name");
				//performed_by_desc			=	rs.getString("performed_by_desc");

				if(gender.equals("M"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

			if(dischargeDateTime==null)
			{
				dischargeDateTime="";
			}

			if(pstmt!=null)	
				pstmt.close();
			if(rs!=null)
				rs.close();
		}
		else
		{
			//String strPatInfoQuery = "select short_name patient_name,get_age(date_of_birth) patient_age,DECODE(Sex,'M','Male','F','Female','Unknown') Gender from mp_patient_mast where patient_id = ? "; 
			String strPatInfoQuery = "select short_name patient_name,get_age(date_of_birth) patient_age,Sex Gender from mp_patient_mast where patient_id = ?";
			pstmt	=	con.prepareStatement(strPatInfoQuery);

			pstmt.setString	(	1,	patient_id	);

			rs = pstmt.executeQuery();
	
			if(rs.next() )
			{
				patient_name	= rs.getString("patient_name");
				patient_age		= rs.getString("patient_age");
				//patient_sex		= rs.getString("gender");
				gender			= rs.getString("gender");
				
				if(gender.equals("M"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else 
					patient_sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			}

			if(pstmt!=null)
				pstmt.close();
			
			if(rs!=null)
				rs.close();
		}

		

		//added by Sridhar Reddy on 23/08/2008 
		//Code to Checking for User Privileges to display Print and Email Buttons for Patient Medical Report. 
		
		String privQuery = "select PRIVILAGE_ID from CA_PMR_USER_PRIVILAGES where NOTE_TYPE_ID = ? and PRACTITIONER_ID = ? ";

		pstmt	=	con.prepareStatement(privQuery);
		pstmt.setString(1,note_type);
		pstmt.setString(2,ca_practitioner_id);		
		rs1 = pstmt.executeQuery();
		
		while(rs1.next())
		{			
			user_privilage_id	= checkForNull(rs1.getString("PRIVILAGE_ID"));
			
			if (user_privilage_id.equals("P"))
			{
				print_privilage = user_privilage_id;
			}
			else if (user_privilage_id.equals("E")) 
			{
				email_privilage = user_privilage_id;
			}		
		}

		if(pstmt!=null)
			pstmt.close();

		if(rs1!=null)
			rs1.close();	

		// End Checking for User Privileges.
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		System.err.println("RecClinicalNotesSearchToolbar.jsp,384,message=>"+e.getMessage());
		e.printStackTrace();
	}
	finally
	{		
		if(rs2 !=null) 
			rs2.close();

		if(pstmt2 !=null) 
			pstmt2.close();

		if(pstmt!=null)	
			pstmt.close();

		if(rs!=null) 
			rs.close();

		if(rs1!=null) 
			rs1.close();

		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
	<center>
	<form name="RecClinicalNotesSearchToolbarForm" id="RecClinicalNotesSearchToolbarForm">
	<p align="left">
		<table border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
			<tr>
				<td>
<%		
		
		if (encounter_id.equals(res_encounter_id))
		{
			for(int i=0; i<arrFunctions.size(); i++)
			{
				button_name = (String)arrFunctions.get(i);
				
				if( button_name==null ) 
					button_name = "";
				
				//IN67872, starts
				if( button_name.equals("REJECT") && (eCA._ca_license_rights.getKey()).equals("CACLDC") )
				{
				%>
				<input type="BUTTON" class="BUTTON" name="reject" id="reject" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")%>" onClick="callMeOnReject()" >&nbsp;
				<%
				}
				//IN67872, ends
				if( button_name.equals("FORWARD") && (eCA._ca_license_rights.getKey()).equals("CACLDC") )
				{
if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM"))
{ //68801
%>
					<input type="BUTTON" class="BUTTON" name="forward" id="forward" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")%>" onClick="getForwardTo('Forward')" disabled>&nbsp;

<%}else{ %>
					<input type="BUTTON" class="BUTTON" name="forward" id="forward" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels")%>" onClick="getForwardTo('Forward')" >&nbsp;

<%}
				}

				if(button_name.equals("UPDATE"))
				{
%>
					<input type="BUTTON" class="BUTTON" name="update" id="update" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")%>" onClick="callMeOnUpdate();">&nbsp;
<%
				}

				if(button_name.equals("MODIFY"))
				{
					//IN063818 changes starts
					if(isModifyDescSS){ 
if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM")){ //68801
%>
<input type="BUTTON" class="BUTTON" name="modify" id="modify" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")%>" onClick="callMeOnModify();" disabled>&nbsp;
<%}else{ %>			
<input type="BUTTON" class="BUTTON" name="modify" id="modify" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")%>" onClick="callMeOnModify();">&nbsp;	
					<%}}
					else{
					//IN063818 changes ends
						//IN066806 Starts						
						if(isModifyDisable){	
								if(!((dischargedYN.equals("Y")) && (noteGroupYN.equals("Y"))&& (privilege_type.equals("3")))){
								if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM"))
								{//68801
								%>
								<input type="BUTTON" class="BUTTON" name="modify" id="modify" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" onClick="callMeOnModify();" disabled>&nbsp;
								<%}else{ %>
								 <input type="BUTTON" class="BUTTON" name="modify" id="modify" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" onClick="callMeOnModify();">&nbsp;
								<%}
						}
						}else{
							if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM"))
							{ //68801
						%>
						<input type="BUTTON" class="BUTTON" name="modify" id="modify" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" onClick="callMeOnModify();" disabled>&nbsp;
						<%}else{%>
						<input type="BUTTON" class="BUTTON" name="modify" id="modify" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" onClick="callMeOnModify();">&nbsp;
						<%}
						}
						//IN066806 ends
					}%>					
				<%}

				if(button_name.equals("DELETE"))
				{
%>
					<input type="BUTTON" class="BUTTON" name="delete" id="delete" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%>" onClick="callMeOnDelete();">&nbsp;
<%
				}

				if(button_name.equals("REVIEW"))
				{
%>
					<input type="BUTTON" class="BUTTON" name="review" id="review" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.review.label","common_labels")%>" onClick="callMeOnReview();">&nbsp;
<%
				}

				if(button_name.equals("SIGN"))
				{
%>
					<input type="BUTTON" class="BUTTON" name="sign" id="sign" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sign.label","common_labels")%>"  onClick="callMeOnSign();">&nbsp;
<%
				}

				if(button_name.equals("ERROR"))
				{
					
					if(!appl_task_id.equals("PAT_HISTORY"))
					{
						//IN038840
if("Y".equals(isPatinetDichargedYN) && ("RM".equals(orderStatusCodeHdr) || "RS".equals(orderStatusCodeHdr) || "CD".equals(orderStatusCodeHdr)) && appl_task_id.equals("EXTERNAL_REQ_FORM")){ //68801
%>
<input type="BUTTON" class="BUTTON" name="error" id="error" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels")%>" onClick="callMeOnError()" disabled>&nbsp;
<%}else{ 
%>
<input type="BUTTON" class="BUTTON" name="error" id="error" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels")%>" onClick="callMeOnError()">&nbsp;

<%		}			}
				}

				if(button_name.equals("PRINT"))
				{							
					if(appl_task_id.equals("PAT_MEDICAL_REPORT"))
					{  
						if (print_privilage.equals("P")) 
						{
							//IN064446 changes starts
							if(isPPSiteSpecific)
							{
%>
								<input type="BUTTON" class="BUTTON" name="printpreview" id="printpreview" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Printpreview.label","ca_labels")%>" onClick="printNotes()">&nbsp;
							<%}else{%>
								<input type="BUTTON" class="BUTTON" name="print" id="print" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="printNotes()">&nbsp;

<%							}
							//IN064446 changes ends
						}

					    if (email_privilage.equals("E")) 
						{					
%>
							<input type="BUTTON" class="BUTTON" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Email.label","ca_labels")%>" onClick="emailText()" title='Click to email the events' name='emailBtn'>&nbsp;
<%							
						}
					}
					else
					{  
							//IN064446 changes starts
							if(isPPSiteSpecific)
							{
%>
								<input type="BUTTON" class="BUTTON" name="printpreview" id="printpreview" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Printpreview.label","ca_labels")%>" onClick="printNotes()">&nbsp;
							<%}else{%>
								<input type="BUTTON" class="BUTTON" name="print" id="print" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="printNotes()">&nbsp;

<%							}
							//IN064446 changes ends
					}
				}
				
			}
												
			if(error_docs_exists.equalsIgnoreCase("true") )
			{
%>
				<input type="BUTTON" class="BUTTON" name="view_error" id="view_error" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorDocuments.label","ca_labels")%>" onClick="showErrorDocuments()">&nbsp;&nbsp;
<%
			}
		}
		else if (!(encounter_id.equals(res_encounter_id)) && (note_status.equals("4") || note_status.equals("5"))) //--[IN033511]
		{  
			//IN064446 changes starts
			if(isPPSiteSpecific)
			{
%>
				<input type="BUTTON" class="BUTTON" name="printpreview" id="printpreview" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Printpreview.label","ca_labels")%>" onClick="printNotes()">&nbsp;		
			<%}else{%>

				<input type="BUTTON" class="BUTTON" name="print" id="print" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>" onClick="printNotes()">&nbsp;		
<%			}
			//IN064446 changes ends
		}

		if(!appl_task_id.equals("PROGRESS_NOTES"))
		{
%>
			<input type="BUTTON" class="BUTTON" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="closeWindow()">&nbsp;&nbsp;
<%
		}
%>
				</td>
			</tr>
		</table>
	</p>
	<input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" name="siteName" id="siteName" value="<%=siteName%>">

	<input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">
	<input type="hidden" name="performed_by_id" id="performed_by_id" value="<%=performed_by_id%>">

	<input type="hidden" name="amendment_type" id="amendment_type"			value="<%=amendment_type%>">
	<input type="hidden" name="privilege_type" id="privilege_type"			value="<%=privilege_type%>">
	<input type="hidden" name="forwarded_clinician_id" id="forwarded_clinician_id"	value="">
	<input type="hidden" name="action_comment" id="action_comment"			value="">
	<input type="hidden" name="operation_mode" id="operation_mode"			value="">
	<input type="hidden" name="forward_mode" id="forward_mode"			value="">
	<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=encounter_id%>">
	<input type="hidden" name="episode_type" id="episode_type"	value="<%=episode_type%>">
	<input type="hidden" name="facility_name" id="facility_name"	value="<%=facility_name%>">
	<input type="hidden" name="med_service" id="med_service"	value="<%=med_service%>">
	<input type="hidden" name="visit_adm_date" id="visit_adm_date"	value="<%=visit_adm_date%>">
	<input type="hidden" name="patient_line" id="patient_line"	value="<%=patient_line%>">
	<input type="hidden" name="query_string" id="query_string"	value="<%=request.getQueryString()%>">
	<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
	<input type="hidden" name="patientName_Local_Lang" id="patientName_Local_Lang" value="<%=patientName_Local_Lang%>">
	<input type="hidden" name="loggedUser" id="loggedUser"		value="<%=loggedUser%>">
	<input type="hidden" name="printDateTime" id="printDateTime"		value="<%=printDateTime%>">
	<input type="hidden" name="dischargeDateTime" id="dischargeDateTime"		value="<%=dischargeDateTime%>">
	<input type="hidden" name="authorizedBy" id="authorizedBy"	value="<%=authorizedBy%>">
	<input type="hidden" name="attending_practitioner" id="attending_practitioner"	value="<%=attending_practitioner%>">
	<input type="hidden" name="admitting_practitioner" id="admitting_practitioner"	value="<%=admitting_practitioner%>">
	<input type="hidden" name="lastModifiedBy" id="lastModifiedBy"	value="<%=lastModifiedBy%>">
	<input type="hidden" name="note_header_desc" id="note_header_desc"	value="<%=note_header_desc%>">
	<input type="hidden" name="event_date_time" id="event_date_time"	value="<%=event_date_time%>">
	
	<input type="hidden" name="discharge_summary_text" id="discharge_summary_text" value="<%=discharge_summary_text%>">

	<input type="hidden" name="user_id" id="user_id" value="<%=loggedUser%>">
	<input type="hidden" name ="oledb_con_string" value="<%=oledb_con_string%>" >
	<input type="hidden" name ="figer_print_auth_yn" value="<%=figer_print_auth_yn%>" >

	<input type="hidden" name ="window_close" value="<%=window_close%>" >
	<input type="hidden" name ="performed_by_name" value="<%=performed_by_name%>" >
	<input type="hidden" name ="patient_id" value="<%=patient_id%>" >
	<input type="hidden" name ="patient_name" value="<%=patient_name%>" >
	<input type="hidden" name ="patient_sex" value="<%=patient_sex%>" >
	<input type="hidden" name ="patient_age" value="<%=patient_age%>" >
	<input type="hidden" name ="locationDesc" value="<%=locationDesc%>" >
	<input type="hidden" name ="doc_linked_note_yn" value="<%=doc_linked_note_yn%>" >
	<input type="hidden" name ="sec_count" value="<%=sec_count%>" >
	<input type="hidden" name ="patient_class" value="<%=patientClass%>" >
	<input type="hidden" name ="location_code" value="<%=location_code%>" >
	<input type="hidden" name ="performed_by_desc" value="<%=performed_by_desc%>" >
	<input type="hidden" name ="specialty_name" value="<%=specialty_name%>" >
	<input type="hidden" name ="speciality_code" value="<%=speciality_code%>" >
	<input type="hidden" name ="appl_task_id" value="<%=appl_task_id%>" >
	<input type="hidden" name ="enc_id" value="" >
	<input type="hidden" name ="forwardToFac" value="" >
	<input type=hidden name=notifiable_code id=notifiable_code value='<%=notifiable_code %>'><!-- IN053733 -->
	<input type="hidden" name="l_conf_pin_req_yn" id="l_conf_pin_req_yn" value="<%= conf_pin_req_yn %>"> <!-- ML-MMOH-CRF-0335 - IN057113 -->
	<input type="hidden" name="printPreviewFlag" id="printPreviewFlag" value="<%=printPreviewFlag%>"> <!-- IN064446-->
	<input type="hidden" name="myHIXYN" id="myHIXYN" value="N"/><!--IN067607-->
	<input type="hidden" name="myHIXSiteFlg" id="myHIXSiteFlg" value="<%=myHIXSiteFlg%>"/><!--IN067607-->
	<input type="hidden" name="myHIXNoteType" id="myHIXNoteType" value="<%=myHIXNoteType%>"/><!--IN067607-->
	<input type="hidden" name="isModifyDescYN" id="isModifyDescYN" value="<%=isModifyDescYN%>"/><!--IN067607-->
	</form>
	</center>
	<!-- <OBJECT ID="WebFp" CLASSID="CLSID:CA452A7B-737F-434D-904A-AB06E644C25F" 	CODEBASE="PrintFPCom.CAB#version=1,0,0,0" VIEWASTEXT></OBJECT> -->
</body>
</html>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>


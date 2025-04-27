<%
/* 
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name			DescriptionDescription
--------------------------------------------------------------------------------------------------------------
?             100            ?           								created
09/07/2012    IN035928	    Nijitha								CHL-CRF-0044 - 35928
30/01/2013    EMR1512	    Dinesh T								CHL-CRF-0044 - 35928
18/12/2013    IN042552	    Ramesh G								Bru-HIMS-CRF-391 --- Notes Confidentiality	
04/09/2014    PER0409	    akbar         							Changes suggested by sunil
15/11/2017    IN061896	    Kamalakannan G	15/11/2017		Ramesh G		System should sort notegroups based on practitioner type					
28/06/2018    IN065341	    Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
04/07/2019	  IN072406		sivabagyam	 	04/07/2019      Ramesh G       		ML-MMOH-SCF-1506
18/02/2021    14773	    Nijitha S		18/02/2021      Ramesh G   		    PMG2021-COMN-CRF-0003/PMG2021-COMN-CRF-0003.2
03/03/2021    14906		Nijitha S		03/03/2021      Ramesh G   		    CA-PMG2021-COMN-CRF-0003/02-Clinical Note Widget
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	
 
*/ 
%>
<%@page import="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//[IN035950] Starts
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<%
			String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
			String content_ID = request.getParameter("content_ID");
			String title = request.getParameter("title");
			String sessionStyle = "";
			if(!"".equals(prefStyleSheet)){
			 sessionStyle=prefStyleSheet;
			}
			/*else{
				sStyle=prefStyleSheet;
			}*/
			//[IN035950] Ends
		java.util.Properties p = (java.util.Properties) session
				.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
	%>
	<title><%=title%></title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />
			<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->
		
		

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
	//function showNoteData(accession_num,from,no_modalval,encounter_id,contr_mod_accession_num,notestatus,note_group_desc)//[IN032721]
	async function showNoteData(accession_num,from,no_modalval,encounter_id,contr_mod_accession_num,notestatus,note_group_desc,RepDb,clob_data,patient_id)//IN065341
	{
		var dialogHeight	= "39" ;
		var dialogWidth		= "60" ;
		var status			= "no";
		var scroll			= "yes";
		var dialogTop		= "100";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
		var no_modal=no_modalval;
		var function_id = "";
		var called_function_id="";
		if(from != 'DISCHARGE_SUMMARY')
		{
		var note_group=note_group_desc;
	    var status=notestatus;

	    var statustxt='';
		
		if(status ==  '3')
	    statustxt =  'Unauthorized'
		else if(status ==  '4')
	    statustxt =  'Authorized'
		else if(status ==  '5')
	    statustxt =  'Modified'
		else if(status ==  '5')
	    statustxt =  'In Error' 
		accession_num=accession_num;	
		}
		//var retval = window.showModalDialog('../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN&called_function_id='+called_function_id+'&encounter_id='+encounter_id+'&function_id='+function_id+'&contr_mod_accession_num='+contr_mod_accession_num,arguments,features);
		var retval =await  window.showModalDialog('../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN&called_function_id='+called_function_id+'&encounter_id='+encounter_id+'&function_id='+function_id+'&contr_mod_accession_num='+contr_mod_accession_num+'&RepDb='+RepDb+'&clob_data='+clob_data+'&patient_id='+patient_id,arguments,features);//added RepDb,clob_data for IN065341
	}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='' id='' action="" method="" target="">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	PreparedStatement pstmtcnt = null;
	ResultSet rscnt = null;

	String query_notes_detail = "";
	StringBuffer query_string = new StringBuffer();
	//StringBuffer whereClause = new StringBuffer();	//Checkstyle 4.0 Beta 6

	String function_id = "";
	String classValue = "";
	String facility_id = "";
	String accession_num = "";
	String note_type = "";
	String note_type_desc = "";
	String note_group = "";
	String appl_task_id = "";
	String service_code = "";
	String service_name = "";
	String event_title_desc = "";
	String event_date_time = "";
	String modified_date = "";//24094
	String performed_by_id = "";
	String performed_by_name = "";
	String authorized_by_name = "";
	String status = "";
	String status1 = "";
	String tblrow_id = "";
	String login_user_id = "";
	String clinician_id = "";
	String resp_id = "";
	String operations_allowed = "";
	String amendment_type = "";
	String privilege_type = "";
	String patient_id = "";
	String encounter_id = "";
	String episode_type = "";
	String lower_limit = "";
	String upper_limit = "";
	String from_date_time = "";
	String to_date_time = "";
	String event_status = "";
	String status_display_text = "";
	String filter = "";
	String strModifiedId = "";
	String patient_class = "";
	String other_unsigned_yn = "";
	String doc_linked = "";
	String doc_linked_note_yn = "";
	String med_anc = "";
	String contr_mod_accession_num = "";
	String performed_by = "";
	String ref_no = "";
	String doc_ref_id = "";
	String Encline = "";
	//String oldEncline = ""; //Checkstyle 4.0 Beta 6
	String speciality_code = "";
	String res_encounter_id = "";
	String eventClass="";
	String event_class_desc ="";
	String current_event_class_desc="";	
	String practitioner_type =""; //IN061896
	boolean isClinician=false;//IN067236
	int rowCnt = 0, maxRecordsDisp = 10;
	int startIndex = 0, endIndex = 0;
	int totalRecordCount = 0, colIndex = 0;
	int sec_count = 0;

	patient_id = (request.getParameter("patient_id") == null) ? ""
			: request.getParameter("patient_id");
	//IN065341 starts
	String bean_id = "ca_CentralizedBean" ;
	String bean_name = "eCA.CentralizedBean";
	CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	if(called_from.equals("CDR")){
		encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		patient_class = (request.getParameter("pat_class") == null) ? ""
			: request.getParameter("pat_class");
		facility_id = (request.getParameter("facility_id1") == null) ? ""
			: request.getParameter("facility_id1");	
	}else{//IN065341 ends
	  	encounter_id = request.getParameter("encounter_id") == null? ""
			: request.getParameter("encounter_id");
	       patient_class = (request.getParameter("patient_class") == null) ? ""
			: request.getParameter("patient_class");
		facility_id= (String) session.getValue("facility_id");	
	}//IN065341
	episode_type = (request.getParameter("episode_type") == null) ? ""
			: request.getParameter("episode_type");
	event_status = (request.getParameter("status") == null) ? "0"
			: request.getParameter("status");
	other_unsigned_yn = (request.getParameter("other_unsigned_yn") == null) ? "N"
			: request.getParameter("other_unsigned_yn");
	filter = (request.getParameter("filter") == null) ? "A" : request
			.getParameter("filter");
	function_id = (request.getParameter("function_id") == null) ? ""
			: request.getParameter("function_id");
	from_date_time = (request.getParameter("from_date_time") == null) ? ""
			: request.getParameter("from_date_time");
	to_date_time = (request.getParameter("to_date_time") == null) ? ""
			: request.getParameter("to_date_time");
	lower_limit = (request.getParameter("lower_limit") == null) ? "1"
			: request.getParameter("lower_limit");
	upper_limit = (request.getParameter("upper_limit") == null) ? ("" + maxRecordsDisp)
			: request.getParameter("upper_limit");
	note_type = (request.getParameter("note_type") == null) ? ""
			: request.getParameter("note_type");
	note_group = (request.getParameter("note_group") == null) ? ""
			: request.getParameter("note_group");
	appl_task_id = (request.getParameter("p_appl_task_id") == null) ? ""
			: request.getParameter("p_appl_task_id");
	performed_by = (request.getParameter("performed_by") == null) ? ""
			: request.getParameter("performed_by");
	med_anc = (request.getParameter("med_anc") == null) ? "" : request
			.getParameter("med_anc");
	contr_mod_accession_num = (request
			.getParameter("contr_mod_accession_num") == null) ? ""
			: request.getParameter("contr_mod_accession_num");
	ref_no = (request.getParameter("ref_no") == null) ? "" : request
			.getParameter("ref_no");
	speciality_code = (request.getParameter("speciality_code") == null) ? ""
			: request.getParameter("speciality_code");
	//String option_id = (request.getParameter("option_id") == null) ? "" : request.getParameter("option_id"); //Checkstyle 4.0 Beta 6
	
	query_string.append("patient_id=");
	query_string.append(patient_id);
	query_string.append("&encounter_id=");
	query_string.append(encounter_id);
	query_string.append("&episode_type=");
	query_string.append(episode_type);
	query_string.append("&function_id=");
	query_string.append(function_id);
	query_string.append("&from_date_time=");
	query_string.append(from_date_time);
	query_string.append("&to_date_time=");
	query_string.append(to_date_time);
	query_string.append("&appl_task_id=");
	query_string.append(appl_task_id);
	query_string.append("&patient_class=");
	query_string.append(patient_class);
	query_string.append("&filter=");
	query_string.append(filter);
	query_string.append("&status=");
	query_string.append(event_status);
	query_string.append("&other_unsigned_yn=");
	query_string.append(other_unsigned_yn);
	query_string.append("&med_anc=");
	query_string.append(med_anc);
	query_string.append("&performed_by=");
	query_string.append(performed_by);
	query_string.append("&ref_no=");
	query_string.append(ref_no);
	query_string.append("&speciality_code=");
	query_string.append(speciality_code);

	from_date_time = com.ehis.util.DateUtils.convertDate(
			from_date_time, "DMYHM", locale, "en");
	to_date_time = com.ehis.util.DateUtils.convertDate(to_date_time,
			"DMYHM", locale, "en");

	startIndex = Integer.parseInt(lower_limit);
	endIndex = Integer.parseInt(upper_limit);
    String noofencQry = "select no_enc_display from ca_chart_summ_content ##REPDB## where content_id = ?";//PMG2021-COMN-CRF-0003 14773
	noofencQry=noofencQry.replaceAll("##REPDB##",RepDb);
    String no_enc_display ="";//PMG2021-COMN-CRF-0003 14773
	try {

		con = ConnectionManager.getConnection(request);
		//14773 PMG2021-COMN-CRF-0003 Starts
		pstmt = con.prepareStatement(noofencQry);
		pstmt.setString(1, content_ID);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			no_enc_display = rs.getString("no_enc_display")==null?"":rs.getString("no_enc_display");
		}
		if(null!=pstmt){
		pstmt.close();
		}
		if(null!=rs){
		rs.close();
		}
		//14773 PMG2021-COMN-CRF-0003 Ends
		isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
		login_user_id = (String) session.getValue("login_user");
		//facility_id = (String) session.getValue("facility_id");commented for In065341
		resp_id = (String) session.getValue("responsibility_id");
		clinician_id = (String) session.getValue("ca_practitioner_id");
		practitioner_type = (String) session.getValue("practitioner_type");//IN061896
		
		//query_notes_detail = "select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, b.note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,decode(a.event_class,'PHY$','Physician Notes','CLI$','Clinician Notes','NUR$','Nursing Notes') event_class_desc from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? ";
		//PER0409 - start
		//query_notes_detail = "select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, (select note_type_desc from ca_note_type_lang_vw  where language_id=? and note_type = a.note_type) note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,decode(a.event_class,'PHY$','Physician Notes','CLI$','Clinician Notes','NUR$','Nursing Notes') event_class_desc from 	ca_encntr_note a, ca_note_type b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =? ";
		//query_notes_detail = "select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, (select note_type_desc from ca_note_type_lang_vw ##REPDB## where language_id=? and note_type = a.note_type) note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE ##REPDB##(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp ##REPDB## where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,decode(a.event_class,'PHY$','Physician Notes','CLI$','Clinician Notes','NUR$','Nursing Notes') event_class_desc from 	ca_encntr_note##CLOB## a, ca_note_type ##REPDB## b,pr_encounter ##REPDB## c where CA_GET_APPL_NOTE_OPERN##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and a.encounter_id = c.encounter_id  and a.facility_id = c.facility_id and a.patient_id = ? and 	a.facility_id =? ";//IN065341
		query_notes_detail = "select A.EVENT_CLASS,a.facility_id, a.accession_num, a.note_type, (select note_type_desc from ca_note_type_lang_vw ##REPDB## where language_id=? and note_type = a.note_type) note_type_desc,b.note_group_id, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE ##REPDB##(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp ##REPDB## where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id,decode(a.event_class,'PHY$','Physician Notes','CLI$','Clinician Notes','NUR$','Nursing Notes') event_class_desc, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date1 from 	ca_encntr_note##CLOB## a, ca_note_type ##REPDB## b,pr_encounter ##REPDB## c where CA_GET_APPL_NOTE_OPERN##REPDB##( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and a.encounter_id = c.encounter_id  and a.facility_id = c.facility_id and a.patient_id = ? and 	a.facility_id =? ";//IN065341//24094
		
		//PER0409 - commented below query
		//IN042552 Start.
		//query_notes_detail = query_notes_detail +" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'";
		//IN042552 End.
		
		//EMR1512, starts
		if(!encounter_id.equals(""))
		{
			//query_notes_detail = query_notes_detail + " and a.encounter_id = NVL(?,0) ";//PER0409
			query_notes_detail = query_notes_detail + " and a.encounter_id = ? ";//PER0409
		}
		//EMR1512, ends
		
		//PER0409 - moved from above
		//query_notes_detail = query_notes_detail + " and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'";commented for IN065341
		query_notes_detail = query_notes_detail + " and nvl(ca_view_confidnt_event##REPDB## (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'";//IN065341
		//PER0409 - end
		
		//[IN035916]	Start.
				
			//query_notes_detail = query_notes_detail +"and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  ";
			query_notes_detail = query_notes_detail +"and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP ##REPDB## WHERE APPL_TASK_ID=?)  ";//IN065341
		
		//PER0409 - start
		//[IN035916]	End.
		/*query_notes_detail = query_notes_detail + " and b.language_id = ?  &&APPL_TASK_FILTER and a.event_status NOT IN('9') order by event_class_desc,event_date_time DESC";
		if(!"".equals(appl_task_id) && null!=appl_task_id)
		{
			query_notes_detail = query_notes_detail.replace("&&APPL_TASK_FILTER","and a.event_class=?");
		}
		else
		{
		query_notes_detail = query_notes_detail.replace("&&APPL_TASK_FILTER","");
		}*/
		if(!"".equals(appl_task_id) && null!=appl_task_id)//IN037701 Starts
		{
			query_notes_detail = query_notes_detail + " and a.event_class=? " ;
		}
		//IN061896 start
		//query_notes_detail = query_notes_detail + " and a.event_status NOT IN('9') order by event_class_desc,event_date_time DESC";//kamal commented
		//PER0409 - end
		if("MD".equals(practitioner_type))
		{
			//query_notes_detail	=	query_notes_detail	+	"and a.event_status NOT IN('9') ORDER BY (case when event_class = 'PHY$' then 1 when event_class = 'CLI$' then 2 when event_class = 'NUR$' then 3 else 4 end), event_date_time DESC";//IN67872
			query_notes_detail	=	query_notes_detail	+	"and a.event_status NOT IN('9','8') &&EVENTDATEFILTER ORDER BY (case when event_class = 'PHY$' then 1 when event_class = 'CLI$' then 2 when event_class = 'NUR$' then 3 else 4 end), event_date_time DESC";//IN67872//PMG2021-COMN-CRF-0003
		}
		else if("NS".equals(practitioner_type))
		{
			///query_notes_detail	=	query_notes_detail	+	"and a.event_status NOT IN('9') ORDER BY (case when event_class = 'NUR$' then 1 when event_class = 'CLI$' then 2 when event_class = 'PHY$' then 3 else 4 end), event_date_time DESC";//IN67872
			query_notes_detail	=	query_notes_detail	+	"and a.event_status NOT IN('9','8') &&EVENTDATEFILTER ORDER BY (case when event_class = 'NUR$' then 1 when event_class = 'CLI$' then 2 when event_class = 'PHY$' then 3 else 4 end), event_date_time DESC";//IN67872////PMG2021-COMN-CRF-0003
		}
		else
		{
			//query_notes_detail = query_notes_detail + " and a.event_status NOT IN('9') order by event_class_desc,event_date_time DESC";//IN67872
			query_notes_detail = query_notes_detail + " and a.event_status NOT IN('9','8') &&EVENTDATEFILTER order by event_class_desc,event_date_time DESC";//IN67872//PMG2021-COMN-CRF-0003
		}
		//IN061896 end
		//14773 PMG2021-COMN-CRF-0003 Starts
		if(!"".equals(no_enc_display) && !"0".equals(no_enc_display)){ 
			query_notes_detail = query_notes_detail.replace("&&EVENTDATEFILTER"," AND TO_DATE (a.modified_date, 'dd/mm/yyyy') BETWEEN TO_DATE (nvl(C.DISCHARGE_DATE_TIME,SYSDATE)-?, 'dd/mm/yyyy')  and  TO_DATE (nvl(C.DISCHARGE_DATE_TIME,SYSDATE), 'dd/mm/yyyy')  ");//14906
		}else{
			query_notes_detail = query_notes_detail.replace("&&EVENTDATEFILTER","  ");
		}
		//14773 PMG2021-COMN-CRF-0003 Ends
		//IN065341 starts
		if(called_from.equals("CDR")){
			bean.executeCDR(con,patient_id,encounter_id,RepDb,"CA_ENCNTR_NOTE");
		}
		//pstmt = con.prepareStatement(query_notes_detail.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String result = query_notes_detail.toString();
		result=result.replaceAll("##CLOB##",clob_data);
		result=result.replaceAll("##REPDB##",RepDb);
		pstmt = con.prepareStatement(result,ResultSet.TYPE_SCROLL_INSENSITIVE,	ResultSet.CONCUR_READ_ONLY);
		//IN065341 ends
				
		pstmt.setString(++colIndex, locale);		//PER0409
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, locale);
		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, login_user_id);
		pstmt.setString(++colIndex, other_unsigned_yn);

		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, resp_id);
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, login_user_id);
		pstmt.setString(++colIndex, other_unsigned_yn);
		//	pstmt.setString( ++colIndex,	locale			);
		pstmt.setString(++colIndex, patient_id);

		if (!(appl_task_id.equals("MEDICAL_CERTFICATE"))
				&& !(appl_task_id.equals("MC_CONSULT"))) {
			pstmt.setString(++colIndex, facility_id);
			//EMR1512, starts
			if(!encounter_id.equals(""))
			{
				pstmt.setString(++colIndex, encounter_id);
			}
			//EMR1512, ends
		}
		//PER0409-start
		pstmt.setString(++colIndex, clinician_id);
		pstmt.setString(++colIndex, resp_id);		
		//PER0409-end
		pstmt.setString(++colIndex, "CLINICAL_NOTES");
		//pstmt.setString(++colIndex, locale);//PER0409

		if (!(from_date_time.equals("")))
			pstmt.setString(++colIndex, from_date_time);

		if (!(to_date_time.equals(""))) {
			pstmt.setString(++colIndex, to_date_time);
		}
		if (!(event_status.equals("0"))) {

			pstmt.setString(++colIndex, event_status);
		}
		if (!(contr_mod_accession_num.equals(""))) {

			pstmt.setString(++colIndex, contr_mod_accession_num);
		}
		if ((filter.equals("R"))) {

			pstmt.setString(++colIndex, clinician_id);

		} else if ((filter.equals("S"))) {
			pstmt.setString(++colIndex, clinician_id);

		}

		if (!note_type.equals("")) {

			pstmt.setString(++colIndex, note_type);

		}
	
		if (!performed_by.equals("")) {

			pstmt.setString(++colIndex, performed_by);
		}

		if (!med_anc.equals("")) {

			pstmt.setString(++colIndex, med_anc);
		}
		//pstmt.setString(++colIndex, "CLINICAL_NOTES");
		if(!"".equals(appl_task_id) && null!=appl_task_id)
		{
		pstmt.setString(++colIndex, appl_task_id);
		}
		//14773 PMG2021-COMN-CRF-0003 Starts
		if(!"".equals(no_enc_display) && !"0".equals(no_enc_display)){
			pstmt.setInt(++colIndex, Integer.parseInt(no_enc_display));
		}
		//14773 PMG2021-COMN-CRF-0003 Ends
		rs = pstmt.executeQuery();
		
		if (!(rs.next())) {
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
%>

			<%
			} else {
					rs.last();
					totalRecordCount = rs.getRow();
					rs.beforeFirst();
					
					if (totalRecordCount > maxRecordsDisp) {
		%>
	
	<%
		}
	%>
		<table class='grid' width='100%' id='tb1' align='center'>

		
	<%-- 	<tr>
				<td class='columnheadercenter<%=content_ID%>'></td>
				<td class='columnheadercenter<%=content_ID%>'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
				<td class='columnheadercenter<%=content_ID%>'>Event Class Description</td>
				<td class='columnheadercenter<%=content_ID%>'></td>
				<td class='columnheadercenter<%=content_ID%>'></td>
		</tr> --%>
	<%
		/* if (startIndex > 1)
					rs.absolute((startIndex - 1)); */

				//String countQuerySec = "select count(*) count  from ca_note_section_view where note_type = ? ";
				String countQuerySec = "select count(*) count  from ca_note_section_view##REPDB## where note_type = ? ";//IN065341
				countQuerySec=countQuerySec.replaceAll("##REPDB##",RepDb);//IN065341
				pstmtcnt = con.prepareStatement(countQuerySec);

				while (rs.next()) {
					tblrow_id = "tblrow_id" + (rowCnt);

					rowCnt++;

					if ((rowCnt % 2) == 0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";

					facility_id = rs.getString("facility_id") == null ? ""
							: rs.getString("facility_id");
					accession_num = rs.getString("accession_num") == null ? ""
							: rs.getString("accession_num");
					note_type = rs.getString("note_type") == null ? "" : rs
							.getString("note_type");
					note_type_desc = rs.getString("note_type_desc") == null ? ""
							: rs.getString("note_type_desc");
					service_code = rs.getString("service_code") == null ? ""
							: rs.getString("service_code");
					service_name = rs.getString("service_name") == null ? ""
							: rs.getString("service_name");
					service_name = service_name.replace('\'', ' ');
					event_title_desc = rs.getString("event_title_desc") == null ? "&nbsp;"
							: rs.getString("event_title_desc");
					event_date_time = rs.getString("event_date_time1") == null ? ""
							: rs.getString("event_date_time1");
					modified_date = rs.getString("modified_date1") == null ? ""//24094
							: rs.getString("modified_date1");//24094
						
					performed_by_id = rs.getString("performed_by_id") == null ? ""
							: rs.getString("performed_by_id");
					performed_by_name = rs.getString("performed_by_name") == null ? ""
							: rs.getString("performed_by_name");
					authorized_by_name = rs.getString("authorized_by_name") == null ? ""
							: rs.getString("authorized_by_name");
					doc_ref_id = rs.getString("doc_ref_id") == null ? ""
							: rs.getString("doc_ref_id");
					if (appl_task_id.equals("MEDICAL_CERTFICATE")
							|| appl_task_id.equals("MC_CONSULT")) {
						Encline = rs.getString("Encline") == null ? "" : rs
								.getString("Encline");
					}
					//status						=			rs.getString("status")==null?"&nbsp;":rs.getString("status");
					status1 = rs.getString("status") == null ? "&nbsp;"
							: rs.getString("status");
					operations_allowed = rs.getString("operations_allowed") == null ? ""
							: rs.getString("operations_allowed");
					amendment_type = rs.getString("ammendment_type") == null ? ""
							: rs.getString("ammendment_type");
					privilege_type = rs.getString("privilege_type") == null ? ""
							: rs.getString("privilege_type");
					strModifiedId = rs.getString("modifiedid") == null ? ""
							: rs.getString("modifiedid");
					doc_linked_note_yn = rs.getString("doc_linked_note_yn") == null ? "N"
							: rs.getString("doc_linked_note_yn");
					doc_linked = rs.getString("doc_linked") == null ? "N"
							: rs.getString("doc_linked");
					res_encounter_id = rs.getString("encounter_id") == null ? "0"
							: rs.getString("encounter_id");
					event_date_time = com.ehis.util.DateUtils.convertDate(
							event_date_time, "DMYHM", "en", locale);
					modified_date = com.ehis.util.DateUtils.convertDate(
							modified_date, "DMYHM", "en", locale);//24094
					eventClass = rs.getString("EVENT_CLASS") == null ? "0"
							: rs.getString("EVENT_CLASS");
					
					
					event_class_desc = rs.getString("event_class_desc") == null ? "0"
							:rs.getString("event_class_desc");
					
					if (doc_linked_note_yn.equals("Y")) {
						pstmtcnt.clearParameters();
						pstmtcnt.setString(1, note_type);
						rscnt = pstmtcnt.executeQuery();

						while (rscnt.next()) {
							sec_count = rscnt.getInt("count");
						}

						if (rscnt != null)
							rscnt.close();
					}

					if (status1.equals("1"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.InProgress.label",
										"common_labels");
					else if (status1.equals("2"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Transcribed.label",
										"common_labels");
					else if (status1.equals("3"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Unauthorized.label",
										"common_labels");
					else if (status1.equals("4"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Authorized.label",
										"common_labels");
					else if (status1.equals("5"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.Modified.label",
										"common_labels");
					else if (status1.equals("9"))
						status = com.ehis.util.BundleMessage
								.getBundleMessage(pageContext,
										"Common.InError.label",
										"common_labels");

					String img = "";

					if (doc_linked.equals("Y"))
						img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""
								+ accession_num
								+ "\",\""
								+ note_type
								+ "\")' height='20' title='View Linked File' >";
					else
						img = "&nbsp;";

					if (status1.equals("9")) {
						status_display_text = "<a class='gridLink' href=\"javascript:showNoteStatus('"
								+ accession_num
								+ "',"
								+ tblrow_id
								+ ")\">"
								+ status
								+ "</a>&nbsp;&nbsp;<a class='gridLink' href=\"javascript:showErrorRemarks('"
								+ accession_num
								+ "','"
								+ facility_id
								+ "')\" style='color:red'><b>?</b></a>";
					} else 
					{
						status_display_text = "<a class='gridLink' href=\"javascript:showNoteStatus('"
								+ accession_num
								+ "',"
								+ tblrow_id
								+ ")\">"
								+ status + "</a>";
					}
					
		  		
			%>
				<%if(!current_event_class_desc.trim().equalsIgnoreCase(event_class_desc.trim()))
				{
				
					if(sStyle.equals(prefStyleSheet) ){%>
						<%if(isClinician && eventClass.equals("CLI$")){%><!-- IN067236starts -->						
							<tr><td class='COLUMNHEADERCENTER' colspan="2">Therapist Notes</td><td class='COLUMNHEADERCENTER'></td><td class='COLUMNHEADERCENTER'></td><td class='COLUMNHEADERCENTER'></td></tr><!--24094 starts-->
						<%}else{ %>
									<tr><td class='COLUMNHEADERCENTER' colspan="2"><%=event_class_desc%></td><td class='COLUMNHEADERCENTER'></td><td class='COLUMNHEADERCENTER'></td><td class='COLUMNHEADERCENTER'></td></tr><!--24094 starts-->
						<%} %><!-- IN067236ends -->
						<%
					}else{
					%>
						<%if(isClinician && eventClass.equals("CLI$")){%><!-- IN072406 starts -->	
							<tr><td class='COLUMNHEADERCENTER<%=content_ID%>' colspan="2">Therapist Notes</td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td></tr>	<!-- 24094 -->
						<%}else{%>							
								<tr><td class='COLUMNHEADERCENTER<%=content_ID%>' colspan="2"><%=event_class_desc%></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td><td class='COLUMNHEADERCENTER<%=content_ID%>'></td></tr><!-- 24094 -->	
						<%}%><!-- IN072406 ends -->							
					<%
					}
				current_event_class_desc =event_class_desc;
				}
				%>		
				<tr>
				<td class='gridData' width='50%'><%=note_type_desc%></td>		
			<!--IN065341 STARTS-->
				<!--<TD><img class='gridData' src='../../eCA/images/flow_text.gif' onClick="showNoteData('<%=accession_num %>','<%=appl_task_id%>','','<%=res_encounter_id%>','','<%=status%>','');"/></TD>-->
				<!--24094 starts-->
					<% if(status1.equals("5")){  %>
					 <TD><img style='cursor:pointer;' src='../../eCA/images/modifiedresult.png' alt='<%=modified_date %>'/></TD>
					<%} else {%>
					<td class='gridData'><%=""%></td>
					<% } %>
					<!--24094 ends-->
				<TD><img class='gridData' src='../../eCA/images/flow_text.gif' onClick="showNoteData('<%=accession_num %>','<%=appl_task_id%>','','<%=res_encounter_id%>','','<%=status%>','','<%=RepDb%>','<%=clob_data%>','<%=patient_id%>');"/></TD>
			<!--IN065341 ENDS-->
				<td class='gridData'><%=img%></td>
				<td class='gridData' nowrap><b><%=event_date_time%></td>
				</tr>
		<%	
					}
				}
				if (rscnt != null)
					rscnt.close();
				if (pstmtcnt != null)
					pstmtcnt.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				//out.println("Exception@1 : " + e);//COMMON-ICN-0181
				e.printStackTrace();
			} finally {
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			}
		%>
</table>
	<input type=hidden name=query_string id=query_string value='<%=query_string.toString()%>'>
	<input type=hidden name=new_query_string id=new_query_string value='<%=request.getQueryString()%>'>

	<!-------------hidden fields for fileupload-------------------->
	<input type=hidden name=accession_num id=accession_num value=''>
	<input type=hidden name=function_id id=function_id value=''>
	<input type=hidden name=privilege_type id=privilege_type value=''>
	<input type=hidden name=forwarded_clinician_id id=forwarded_clinician_id value=''>
	<input type=hidden name=action_comment id=action_comment value=''>
	<input type=hidden name=performed_by_id id=performed_by_id value=''>
	<input type=hidden name=operation_mode id=operation_mode value=''>
	<input type=hidden name=doc_linked_note_yn id=doc_linked_note_yn value=''>
	<input type=hidden name=appl_task_id id=appl_task_id value=''>
	<input type="hidden" name="called_from" id="called_from" value=''>
	<!--Added by Ambiga.M for 18712 on 2/24/2010   --> 
	<input type=hidden name=forward_mode id=forward_mode value=''>


<!------------------------------------------------------------>

<br><br>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:12%; visibility:hidden;'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center' >
	<tr><td width='100%' id='t'></td></tr>
	</table>
	</div>	

</form>
</center>
</body>
</html>







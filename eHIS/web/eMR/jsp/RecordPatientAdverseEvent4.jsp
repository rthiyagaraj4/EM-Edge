<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.PreparedStatement,java.sql.ResultSet, webbeans.eCommon.ConnectionManager,com.ehis.eslp.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>

	<head>
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
			<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
			<script language="javascript" src="../../eCommon/js/common.js" ></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
			<script language='javascript' src='../../eCommon/js/messages.js' ></script>
			<!-- <script language='javascript' src='../../eMR/js/eMRmessages.js' ></script> -->
			<script language='javascript' src='../../eCommon/js/common.js' ></script>
			<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
			<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language='javascript' src="../../eMR/js/RecordPatientAdverseEvent.js"></script>
			<script language='javascript' src='../../ePH/js/DrugNameCommonLookup.js'></script>
			<script language="javascript" src="../../eMP/js/PatEncBanner.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>
			function display_records(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date){
				parent.frames[1].document.getElementById('detail'+obj).innerHTML="<a href=\"javascript:display_records1('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black' bgcolor='#FF9933'>-</font></a>";
				/* var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
				var xmlHttp = new XMLHttpRequest()  */
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" status=\""+status+"\" error_status=\""+error_status+"\" onset_date=\""+onset_date+"\"  det='add' steps='6'/></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","AdverseEventType.jsp",false);
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText)
				eval(responseText)
			}
			function display_records1(obj,PatientId,causative_code,adv_event_type_ind_code,adv_event_type_code,reaction_date1,status,error_status,onset_date){
				parent.frames[1].document.getElementById('detail'+obj).innerHTML="<a href=\"javascript:display_records('"+obj+"','"+PatientId+"','"+causative_code+"','"+adv_event_type_ind_code+"','"+adv_event_type_code+"','"+reaction_date1+"','"+status+"','"+error_status+"','"+onset_date+"')\"><font color='black'>+</font></a>";

				//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
				//var xmlHttp = new XMLHttpRequest() 
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH PatientId=\""+PatientId+"\"  adv_event_type_ind_code=\""+adv_event_type_ind_code+"\" adv_event_type_code=\""+adv_event_type_code+"\" causative_code=\""+causative_code+"\"	reaction_date1=\""+reaction_date1+"\"  cnt=\""+obj+"\" det='sub' status=\""+status+"\" error_status=\""+error_status+"\"  onset_date=\""+onset_date+"\"  steps='6'/></root>"
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","AdverseEventType.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				responseText = trimString(responseText);
			
				eval(responseText);
			}
			function callonload(){
				var tot_allr=document.forms[0].rowcolor.value;
				//parent.frames[0].document.forms[0].all.third1.style.display='inline';
				//	parent.frames[0].document.forms[0].all.third1.style.display='visible';
			}
			</script>
	</head>
	<%
	String locale = (String)session.getAttribute("LOCALE");
	Connection con = ConnectionManager.getConnection(request);
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	Statement stmt1 = null;
	String allergen1="",allergen2="",allergen="",adv_event_type="",Certainity="",onset_date="",status="",causative_code="",adv_event_type_ind_code="",adv_event_type_code="",severity_main="",classValue="",classValue1="",adv_event_dtl_srl_no="",reaction_date_prev="",reaction_date1="",causative_substance="",route_of_exposure="",severity_two="",adv_reac_code="",reac_desc="",diagnosis_code="",severity_code="",active_date="",final_reac_code_val="",reaction_site="",onset_date_disply="",reaction_date1_disply="",others_reaction="",adv_event_type_code1="",term_code="",reac_date="",reac_date_disply="",source_of_info="",estimated_duration="",inerror_date="",resolved_date="",since_date="",error_status="",status1="",adv_event_type_ind_code1="",onset_date_disply1="",onset_date1="",status_pass="",cnt_recurring="";
	
	String drug_code	= "";//Added By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155]

		String onset_type="";
		String comments="";
	/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
	Boolean isOthAllergenAppl	= false;
	String advEventSrlNo		= "";
	/*End*/
	StringBuffer where_criteria=new StringBuffer(); 
	String norecord					= checkForNull(request.getParameter("norecord"));
	String rs_mode					= checkForNull(request.getParameter("modeResult"));
	
	String rs_reaction_code	= checkForNull(request.getParameter("reac_code_val"));
	String rs_eventType			= checkForNull(request.getParameter("eventType_val"));
	String rs_allergen_code		= checkForNull(request.getParameter("allergen_val"));
	String rs_status					= checkForNull(request.getParameter("status_val"));
	String rs_load					= checkForNull(request.getParameter("load"));
	String error_remark=""; // added for the incident 33466	Bru-HIMS-CRF-292
	if(rs_status != null && !rs_status.equals("")){
		if(rs_status.equals("L")){
			where_criteria.append("AND  UPPER(a.status) IN('A','E','R')");
		}else{
			where_criteria.append("AND nvl(a.status,'X')=nvl('"+rs_status+"',nvl(a.status,'X'))");
		}
	}

	String internalStr="";
	int rowCount=0;
	int max_record=0;
	try {
			isOthAllergenAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","OTH_ALLERGEN_FREE_TXT");//Added by Thamizh selvi on 22nd Dec 2017 for ML-MMOH-CRF-0751
			String PatientId=request.getParameter("PatientId");
			if(PatientId ==null) PatientId="";
			String Encounter_Id=request.getParameter("Encounter_Id");
			if(Encounter_Id==null) Encounter_Id="";
			%>
			<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad='load_header();' ><!--onscroll='scrollTitle1()-->
				<form name = 'chk_val' id='chk_val'>
					<table cellpadding='0'  border='0' cellspacing='0' width='100%' align='center' >
						<th align='left' nowrap colspan='5'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Assessment.label" bundle="${common_labels}"/></th>
					</table>
					<%
					stmt1=con.createStatement();
					int rowcolor=0,m=0;
					String sql=" ";
					//Modified against TTM-SCF-0107 - The below sql is modified to get the generic desc from mr_allergen_lang_vw/ph_generic_name_lang_vw based on the PH installation ::
					String sPhInstalled_YN = request.getParameter("sPhInstalled_YN"); 
					String sAllergen ="";
					if("Y".equals(sPhInstalled_YN))
						/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
						if(isOthAllergenAppl)
							sAllergen = "( DECODE (a.allergen_code, 'Oth', a.other_allergen, DECODE (a.adv_event_type, 'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id = '"+locale+"'), (SELECT long_desc FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '"+locale+"'))) )";
						else/*End*/
							sAllergen = "(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) ";
					else
						/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
						if(isOthAllergenAppl)
							sAllergen = "( DECODE (a.allergen_code, 'Oth', a.other_allergen, (SELECT long_desc FROM mr_allergen_lang_vw WHERE allergen_code = a.allergen_code AND language_id = '"+locale+"')) )";
						else/*End*/
							sAllergen = "(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"') ";
						
					if(rs_mode==null){
						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"'))) END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy ') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g,mr_allergen b WHERE a.patient_id = '"+PatientId+"' AND  a.status = 'A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date, f.reaction_date";
						
						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start*/
						
						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id  AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type  AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+sAllergen+" END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance,  e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' AND  a.status = 'A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+)  ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date, f.reaction_date";//column error_remarks included for the incident 33466 Bru-HIMS-CRF-292
					 /*Below lines onset_type ,comments added by venkatesh.S against ML-MMOH-CRF-0366 */
						sql="SELECT ( decode( a.allergen_code, 'Oth', 0, (SELECT COUNT (*) FROM pr_allergy_sensitivity WHERE patient_id = a.patient_id AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status NOT LIKE 'A') ) )COUNT,a.onset_type,a.comments,f.adv_reac_code, f.adv_event_srl_no,  f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code, a.adv_event_type_ind, a.adv_event_type,a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+sAllergen+" END  allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,  MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1') adv_event_type_desc ,a.certainty certainty,a.status status, TO_CHAR (a.onset_date, 'dd/mm/yyyy hh24:mi:ss') onset_date,  DECODE (e.adv_event_type,'DA', (SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),   e.causative_substance) causative_substance, DECODE (e.adv_event_type,'DA', (SELECT drug_code FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id = 'en'), e.drug_code ) drug_code, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code , TO_CHAR (a.ACTIVE_DATE ,'dd/mm/yyyy') active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE , f.OTHERS_REACTION ,a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d, pr_adverse_event e,   pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' AND  a.status = 'A'   AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code AND f.adv_reac_code = g.reaction_code (+)  ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code,a.other_allergen, a.onset_date, f.reaction_date";//column error_remarks included for the incident 33466 Bru-HIMS-CRF-292
						//Modified above query against ML-MMOH-CRF-0751 by Thamizh selvi on 2nd Jan 2018  - "COUNT" value '0' for 'Oth' code
						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) End*/
											}else if(rs_mode.equals("result")){

						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type AND ALLERGEN_CODE=a.allergen_code and status NOT LIKE 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'en','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code,a.adv_event_type_ind, a.adv_event_type, a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN (DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='en'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='en'))) END allergen,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'en','1') ADV_EVENT_TYPE_IND_desc,MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'en','1')adv_event_type_desc ,a.certainty certainty,a.status status,TO_CHAR(a.onset_date, 'dd/mm/yyyy')onset_date,  DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='en'),e.causative_substance) causative_substance,e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,To_Char(a.ACTIVE_DATE ,'dd/mm/yyyy')active_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE ,f.OTHERS_REACTION , a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,  pr_adverse_event e,pr_adverse_event_reaction f,am_reaction g,mr_allergen b WHERE a.patient_id = '"+PatientId+"' AND nvl(a.status,'X') =nvl('"+rs_status+"',nvl(a.status,'X')) AND nvl(b.short_desc,'X')=nvl('"+rs_allergen_desc_val+"',nvl(b.short_desc,'X') ) AND NVL(a.ADV_EVENT_TYPE,'X')=nvl('"+rs_eventType+"',NVL(a.ADV_EVENT_TYPE,'X') )AND NVL(g.short_desc,'X')=nvl('"+rs_reaction_desc+"',NVL(g.short_desc,'X') )AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code  AND a.allergen_code = b.allergen_code AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code  AND f.adv_reac_code = g.reaction_code (+) ORDER BY a.ADV_EVENT_TYPE_IND, a.allergen_code, a.onset_date, f.reaction_date";

						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start*/
						//sql="SELECT (SELECT count(*) from pr_allergy_sensitivity  where patient_id=a.patient_id AND ADV_EVENT_TYPE_IND=a.adv_event_type_ind AND ADV_EVENT_TYPE=a.adv_event_type AND ALLERGEN_CODE=a.allergen_code and status not like 'A' )COUNT, f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code,a.adv_event_type_ind, a.adv_event_type, a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+ sAllergen + " END allergen /*NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen*/,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1')adv_event_type_desc ,a.certainty certainty,a.status status,TO_CHAR(a.onset_date, 'dd/mm/yyyy hh24:mi:ss')onset_date,  DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),e.causative_substance) causative_substance,e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,To_Char(a.ACTIVE_DATE ,'dd/mm/yyyy')active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE ,f.OTHERS_REACTION , a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,  pr_adverse_event e,pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' "+where_criteria.toString()+ " AND nvl(a.allergen_code,'X')=nvl('"+rs_allergen_code+"',nvl(a.allergen_code,'X') ) AND NVL(a.ADV_EVENT_TYPE,'X')=nvl('"+rs_eventType+"',NVL(a.ADV_EVENT_TYPE,'X') )AND NVL(g.reaction_code,'X')=nvl('"+rs_reaction_code+"',NVL(g.reaction_code,'X') )AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code  AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code  /*and f.status='A'*/  and  f.adv_reac_code = g.reaction_code (+)  ORDER BY a.onset_date,a.ADV_EVENT_TYPE_IND, a.allergen_code, f.reaction_date ";//column error_remark included for the incident 33466 Bru-HIMS-CRF-292

 
						sql="SELECT (decode( a.allergen_code, 'Oth', 0, (SELECT COUNT (*) FROM pr_allergy_sensitivity WHERE patient_id = a.patient_id AND adv_event_type_ind = a.adv_event_type_ind AND adv_event_type = a.adv_event_type AND allergen_code = a.allergen_code AND status NOT LIKE 'A') ) )COUNT,a.onset_type,a.comments,f.adv_reac_code, f.adv_event_srl_no, f.adv_event_dtl_srl_no,f.adv_event_rxn_srl_no, AM_GET_DESC.AM_REACTION(g.REACTION_CODE,'"+locale+"','1') reac_desc,  TO_CHAR (f.reaction_date, 'dd/mm/yyyy hh24:mi') reaction_date,a.patient_id,a.severity severity1,a.severity severity_code,a.adv_event_type_ind, a.adv_event_type, a.allergen_code,CASE WHEN a.allergen_code IS NOT NULL THEN /*(DECODE (a.adv_event_type,'DA', (SELECT generic_name FROM ph_generic_name_lang_vw WHERE generic_id = a.allergen_code AND language_id='"+locale+"'),(SELECT long_desc FROM mr_allergen_lang_vw  WHERE allergen_code = a.allergen_code AND language_id='"+locale+"')))*/ "+ sAllergen + " END allergen /*NVL((SELECT long_desc FROM mr_allergen  WHERE allergen_code = a.allergen_code),(SELECT generic_name FROM ph_generic_name WHERE generic_id = a.allergen_code)) allergen*/,MR_GET_DESC.mr_adv_event_type(c.ADV_EVENT_TYPE_IND,'"+locale+"','1') ADV_EVENT_TYPE_IND_desc,MR_GET_DESC.mr_adv_event_type(d.ADV_EVENT_TYPE_CODE,'"+locale+"','1')adv_event_type_desc ,a.certainty certainty,a.status status,TO_CHAR(a.onset_date, 'dd/mm/yyyy hh24:mi:ss')onset_date,  DECODE (e.adv_event_type,'DA',(SELECT drug_desc  FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id='"+locale+"'),e.causative_substance) causative_substance,DECODE (e.adv_event_type,'DA', (SELECT drug_code FROM ph_drug_lang_vw WHERE drug_code = e.drug_code AND language_id = 'en'), e.drug_code ) drug_code, e.route_of_exposure route_of_exposure,f.severity  severity_two,e.adv_event_dtl_srl_no, a.diagnosis_code ,To_Char(a.ACTIVE_DATE ,'dd/mm/yyyy')active_date,To_Char(a.resolved_date ,'dd/mm/yyyy')resolved_date,To_Char(a.inerror_date ,'dd/mm/yyyy')inerror_date ,a.REACTION_CODE_VALUES,f.REACTION_SITE ,f.OTHERS_REACTION , a.TERM_SET_ID,e.information_source source_of_info,a.calculated_onset_date_yn estimated_duration,f.status error_status,a.ERROR_REMARK error_remark  FROM pr_allergy_sensitivity a,mr_adv_event_type_ind c,mr_adv_event_type d,  pr_adverse_event e,pr_adverse_event_reaction f,am_reaction g WHERE a.patient_id = '"+PatientId+"' "+where_criteria.toString()+ " AND nvl(a.allergen_code,'X')=nvl('"+rs_allergen_code+"',nvl(a.allergen_code,'X') ) AND NVL(a.ADV_EVENT_TYPE,'X')=nvl('"+rs_eventType+"',NVL(a.ADV_EVENT_TYPE,'X') )AND NVL(g.reaction_code,'X')=nvl('"+rs_reaction_code+"',NVL(g.reaction_code,'X') )AND a.patient_id = e.patient_id AND a.adv_event_type_ind = e.adv_event_type_ind AND a.adv_event_type = e.adv_event_type AND a.allergen_code = e.allergen_code  AND a.adv_event_srl_no = e.adv_event_srl_no AND a.patient_id = f.patient_id AND a.adv_event_type_ind = f.adv_event_type_ind AND a.adv_event_type = f.adv_event_type AND a.allergen_code = f.allergen_code AND e.adv_event_srl_no = f.adv_event_srl_no AND e.adv_event_dtl_srl_no = f.adv_event_dtl_srl_no AND a.adv_event_type_ind = c.adv_event_type_ind AND a.adv_event_type = d.adv_event_type_code  /*and f.status='A'*/  and  f.adv_reac_code = g.reaction_code (+)  ORDER BY a.onset_date,a.ADV_EVENT_TYPE_IND, a.allergen_code, a.other_allergen,f.reaction_date ";//column error_remark included for the incident 33466 Bru-HIMS-CRF-292
						/*Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column end)*/
						//Modified above query against ML-MMOH-CRF-0751 by Thamizh selvi on 2nd Jan 2018  - "COUNT" value '0' for 'Oth' code		
					}
					/*stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					rs 	= stmt.executeQuery(sql.toString());
					rs.last();
					max_record = rs.getRow();
					rs.beforeFirst();*/   

                				
					pstmt=con.prepareStatement(sql.toString());
					rs 	= pstmt.executeQuery();
					if(rs !=null){%>
					<table cellpadding='0'  border='1' cellspacing='0' width='100%'  id='record'><!--Modified by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751-->
											<%
						while(rs.next()){
							classValue = "QRYEVENSMALL";
							causative_code=rs.getString("allergen_code");
							adv_event_type_ind_code=rs.getString("ADV_EVENT_TYPE_IND");
							adv_event_type_code=rs.getString("ADV_EVENT_TYPE");
							allergen=rs.getString("allergen");
							if(allergen ==null) allergen="";
							adv_event_type=rs.getString("adv_event_type_desc");
							Certainity=rs.getString("CERTAINTY");
							onset_date=rs.getString("ONSET_DATE");
							if(onset_date ==null) onset_date="";
							status=rs.getString("STATUS");
							severity_main=rs.getString("severity1");
							if(severity_main==null) severity_main="";
							adv_event_dtl_srl_no=rs.getString("adv_event_dtl_srl_no");
							if(adv_event_dtl_srl_no ==null) adv_event_dtl_srl_no="";
							causative_substance=rs.getString("causative_substance");
							if(causative_substance ==null) causative_substance="";
							/*Below lines added by venkatesh.S against ML-MMOH-CRF-0366 */
							onset_type=rs.getString("onset_type");
								if(onset_type ==null) onset_type="";
								
							comments=rs.getString("comments");
							if(comments ==null) comments="";
							/*end ML-MMOH-CRF-0366 */
							
							/*Added by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751 Start*/
														advEventSrlNo = rs.getString("adv_event_srl_no");
							if(advEventSrlNo == null) advEventSrlNo="";/*End*/
							
										comments=comments.replaceAll("'","`");
									
							
							
							drug_code = (rs.getString("drug_code")==null || rs.getString("drug_code")== "") ? "" : rs.getString("drug_code");//Added By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155]

							

							route_of_exposure=rs.getString("route_of_exposure");
							if(route_of_exposure ==null) route_of_exposure="";
							severity_two=rs.getString("severity_two");
							if(severity_two ==null) severity_two="&nbsp;";
							adv_reac_code=rs.getString("adv_reac_code");
							if(adv_reac_code ==null) adv_reac_code="";
							reaction_date1 =rs.getString("reaction_date");
							if(reaction_date1 ==null) reaction_date1="";
							reac_desc=rs.getString("reac_desc");
							if(reac_desc ==null) reac_desc="";
							term_code=rs.getString("TERM_SET_ID");
							if(term_code ==null) term_code="";
							if(reac_desc ==null) reac_desc="";
							severity_code=rs.getString("severity_code");
							if(severity_code ==null)severity_code="";
							diagnosis_code=rs.getString("diagnosis_code");
							if(diagnosis_code==null)diagnosis_code="";
							active_date=rs.getString("active_date");
							if(active_date ==null) active_date="";
							error_status = rs.getString("error_status");
							if(error_status == null) error_status = "A";
							inerror_date=rs.getString("inerror_date");
							if(inerror_date ==null) inerror_date="";
							resolved_date=rs.getString("resolved_date");
							if(resolved_date ==null) resolved_date="";

							if(status.equals("A"))
							since_date=active_date;
							else if(status.equals("R"))
							since_date=resolved_date;
							else if(status.equals("I"))
							since_date=inerror_date;
							final_reac_code_val=rs.getString("REACTION_CODE_VALUES");
							if(final_reac_code_val ==null || final_reac_code_val.equals("THR")) final_reac_code_val="";
							reaction_site=rs.getString("reaction_site");
							if(reaction_site ==null) reaction_site="&nbsp;";
							others_reaction=rs.getString("OTHERS_REACTION");
							if(others_reaction ==null) others_reaction="";
							cnt_recurring=rs.getString("COUNT");
							estimated_duration = rs.getString("estimated_duration");
							/*Following lines included for the incident 33466 Bru-HIMS-CRF-292*/	
							error_remark=rs.getString("error_remark");
							if(error_remark == null) error_remark="&nbsp;";
							if(rowCount==0){
								internalStr=causative_code+adv_event_type_code+"&&"+allergen+"&&"+onset_date+"&&"+reaction_date1+"&&"+reac_desc+"&&"+severity_two;
							}else{
								internalStr=internalStr+"||"+causative_code+adv_event_type_code+"&&"+allergen+"&&"+onset_date+"&&"+reaction_date1+"&&"+reac_desc+"&&"+severity_two;
							}
							source_of_info = rs.getString("source_of_info");
							if(source_of_info.equals("P")){
								//source_of_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PatientObservation.label","mr_labels");
								source_of_info = "P";
							}
							if(source_of_info.equals("A")){
								//source_of_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AllergyTestResult.label","mr_labels");
								source_of_info = "A";
							}
							if(source_of_info.equals("S")){
								//source_of_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StaffObservation.label","mr_labels");
								source_of_info = "S";
							}
							//										
							if(adv_event_type_ind_code.equals("01")){
								classValue1="MRALLERGY";
							}else if(adv_event_type_ind_code.equals("02"))
							{
							classValue1="MRHYPERII";
							}else if(adv_event_type_ind_code.equals("03")){
								classValue1="MRHEADER";
							}else if(adv_event_type_ind_code.equals("04")){
								classValue1="ORBROWN";
							}
							if(severity_main.equals("U")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}else if(severity_main.equals("M")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
							}else if(severity_main.equals("O")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
							}else if(severity_main.equals("S")){
								severity_main =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
							}
							if(Certainity.equals("D")){
								Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Definitive.label","common_labels");
							}else if(Certainity.equals("P")){
								Certainity =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Probable.label","common_labels");
							}
							status_pass = status;
							if(status.equals("A"))	{
								status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
							}else if(status.equals("R")){
								status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
							}else if(status.equals("E"))	{
								status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
							}
							/*if(route_of_exposure.equals("1")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Ingestion.label","mr_labels");
							}else if(route_of_exposure.equals("2")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Inhalation.label","mr_labels");
							}else if(route_of_exposure.equals("3")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Injection.label","mr_labels");
							}else if(route_of_exposure.equals("4")){
								route_of_exposure =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Tropical.label","mr_labels");
							}*/
							if(severity_two.equals("U")){
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}else if(severity_two.equals("M"))	{
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mild.label","common_labels");
							}else if(severity_two.equals("O")){
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Moderate.label","common_labels");
							}else if(severity_two.equals("S")){
								severity_two =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Severe.label","common_labels");
							}
							onset_date_disply=DateUtils.convertDate(onset_date,"DMYHMS","en",locale);
							reaction_date1_disply=DateUtils.convertDate(reaction_date1,"DMYHM","en",locale);
							reac_date_disply  = DateUtils.convertDate(reac_date,"DMY","en",locale);
							if((!adv_event_type_code.equals(adv_event_type_code1) || !causative_code.equals(allergen1) || !allergen.equals(allergen2) || !status.equals(status1) || !adv_event_type_ind_code.equals(adv_event_type_ind_code1) || !onset_date_disply.equals(onset_date_disply1))){ 
							%>
							<input type='hidden' name="comment<%=m%>" id="comment<%=m%>" value='<%=comments%>'>
							<input type='hidden' name="causative_substanc<%=m%>" id="causative_substanc<%=m%>" value='<%=causative_substance%>'>
								
								 
								<tr id = 'header_part' >
									<th width='4%'><div  id='head1'  class='myClass' nowrap >&nbsp;&nbsp;</div></th>
									<th width='15%'><div  id='head2' class='myClass' nowrap ><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></div></th>
									<th width='15%'><div  id='head3' class='myClass' nowrap ><fmt:message key="eMR.Allergen.label" bundle="${mr_labels}"/></div></th>
									<th width='15%'><div  id='head4' class='myClass' nowrap ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></div></th>
									<!--Following condition included for the incident 33466 Bru-HIMS-CRF-292 -->
									<%if(!status_pass.equals("E")){%>
									<th width='30%' colspan='2'><div  id='head5' class='myClass' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th><%}else{%><th width='2%'><div  id='head5' class='myClass' nowrap ><fmt:message key="Common.status.label" bundle="${common_labels}"/></div></th><!--Added 'colspan' on 3rd Jan 2018 against ML-MMOH-CRF-0751-->
									<th width='15%'><div  id='head6' class='myClass' nowrap ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></div></th><%}%>
								</tr>
								<tr id='first' >
									<!--
									<td  class='<%=classValue1%>' nowrap id='detail<%=m%>'><a href="javascript:onclick=display_records1('<%=m%>','<%=PatientId%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>')">&nbsp;-&nbsp;</a>
									</td>
									-->
									<td  class='<%=classValue1%>' nowrap id='detail<%=m%>' name='detail<%=m%>' width = '3%'>
										<a href="javascript:onclick=display_records1('<%=m%>','<%=PatientId%>','<%=causative_code%>','<%=adv_event_type_ind_code%>','<%=adv_event_type_code%>','<%=reaction_date1%>','<%=status_pass%>','<%=error_status%>','<%=onset_date%>')">&nbsp;-&nbsp;</a>
									</td>
									<td  class='<%=classValue%>' nowrap width= '15%' ><%=adv_event_type%></td>
			<%/*causative_substance variable Added encode() method by Senthil on 21-Nov-2011 [IN:026962]*/%>
									<td   class='<%=classValue%>' nowrap id='header'  width= '15%'>
										<!--Modified By Dharma on Jan 29th 2015 against ML-BRU-SCF-1520 [IN:053155] (drug_code column added) Start-->
										<!--<a href="javascript:onclick=display_header('<%=java.net.URLEncoder.encode(Encounter_Id)%>','<%=java.net.URLEncoder.encode(PatientId)%>','<%=java.net.URLEncoder.encode(causative_code)%>','<%=java.net.URLEncoder.encode(adv_event_type_ind_code)%>','<%=java.net.URLEncoder.encode(adv_event_type_code)%>','<%=java.net.URLEncoder.encode(Certainity)%>','<%=java.net.URLEncoder.encode(severity_main)%>','<%=java.net.URLEncoder.encode(onset_date)%>','<%=java.net.URLEncoder.encode(diagnosis_code)%>','<%=java.net.URLEncoder.encode(severity_code)%>','<%=java.net.URLEncoder.encode(active_date)%>','<%=java.net.URLEncoder.encode(final_reac_code_val)%>','<%=java.net.URLEncoder.encode(causative_substance)%>','<%=java.net.URLEncoder.encode(term_code)%>','<%=java.net.URLEncoder.encode(since_date)%>','<%=java.net.URLEncoder.encode(status_pass)%>','<%=java.net.URLEncoder.encode(source_of_info)%>','<%=java.net.URLEncoder.encode(route_of_exposure)%>','<%=java.net.URLEncoder.encode(estimated_duration)%>','<%=java.net.URLEncoder.encode(resolved_date)%>','<%=java.net.URLEncoder.encode(inerror_date)%>','<%=java.net.URLEncoder.encode(others_reaction)%>')">
										<%=allergen%>-->
                                     <!--Below lines onset_type,comments added by venkatesh.S against ML-MMOH-CRF-0366 -->
									
										<a href="javascript:onclick=display_header('<%=m%>','<%=java.net.URLEncoder.encode(Encounter_Id)%>','<%=java.net.URLEncoder.encode(PatientId)%>','<%=java.net.URLEncoder.encode(causative_code)%>','<%=java.net.URLEncoder.encode(adv_event_type_ind_code)%>','<%=java.net.URLEncoder.encode(adv_event_type_code)%>','<%=java.net.URLEncoder.encode(Certainity)%>','<%=java.net.URLEncoder.encode(severity_main)%>','<%=java.net.URLEncoder.encode(onset_date)%>','<%=java.net.URLEncoder.encode(diagnosis_code)%>','<%=java.net.URLEncoder.encode(severity_code)%>','<%=java.net.URLEncoder.encode(active_date)%>','<%=java.net.URLEncoder.encode(final_reac_code_val)%>','<%=java.net.URLEncoder.encode(term_code)%>','<%=java.net.URLEncoder.encode(since_date)%>','<%=java.net.URLEncoder.encode(status_pass)%>','<%=java.net.URLEncoder.encode(source_of_info)%>','<%=java.net.URLEncoder.encode(route_of_exposure)%>','<%=java.net.URLEncoder.encode(estimated_duration)%>','<%=java.net.URLEncoder.encode(resolved_date)%>','<%=java.net.URLEncoder.encode(inerror_date)%>','<%=java.net.URLEncoder.encode(others_reaction)%>','<%=java.net.URLEncoder.encode(drug_code)%>','<%=java.net.URLEncoder.encode(onset_type)%>','<%=java.net.URLEncoder.encode(cnt_recurring)%>','<%=advEventSrlNo%>','<%=adv_event_dtl_srl_no%>')"><%=allergen%></a><!--Modified by Thamizh selvi on 22nd Dec 2017 against ML-MMOH-CRF-0751--> <!--adv_event_dtl_srl_no Added by Ashwini on 30-Nov-2020 for SKR-SCF-1499-->
                                   
									</td>
									<td  class='<%=classValue%>' nowrap width= '15%'><%=onset_date_disply%><input type = 'image' id='clock'  src='../../eCommon/images/mc_history.gif' <%if(estimated_duration.equals("N")){%> BORDER='0' style='visibility:hidden' <%}%>disabled></td>
									<!--
									<img  id='clock' src='../../eCA/images/mc_history.gif' BORDER='0' style='visibility:hidden'>
									-->
									<%if(!status_pass.equals("E")){//Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751
										if(cnt_recurring.equals("0") ){ %>
											<td  class='<%=classValue%>' colspan='2' nowrap width= '15%'><%=status%></td>
										<%}else{%>
											<td  class='<%=classValue%>' colspan='2' nowrap width= '15%'><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
										<%}
									//following condition included for the incident 33466 Bru-HIMS-CRF-292
									}else if(status_pass.equals("E")){
										/*Added by Thamizh selvi on 3rd Jan 2018 against ML-MMOH-CRF-0751 Start*/
										if(cnt_recurring.equals("0") ){ %>
																					<td  class='<%=classValue%>' nowrap width= '15%'><%=status%></td>
										<%}else{%>
											<td  class='<%=classValue%>' nowrap width= '15%'><%=status%>(<%=cnt_recurring%>)<img src='../../eCommon/images/mandatory.gif' ></img></td>
										<%}%><!--End-->
										<td class='<%=classValue%>' nowrap width= '15%'><%=error_remark%></td>
									<%}%>
								</tr>

								<tr id='third<%=m%>' Style="visibility:visible">
									<th  class='<%=classValue%>' nowrap >&nbsp;</td>
									<th class=<%=classValue%>  nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></th>
									<th class=<%=classValue%>  nowrap><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></th>
									<th class=<%=classValue%>  nowrap><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></th>
									<th class=<%=classValue%> colspan='2' nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></th>
									
								</tr>
								<%if(!error_status.equals("E")){
								%>			
									<tr id='second<%=m%>' Style="visibility:visible" >
										<td  class='<%=classValue%>' nowrap >&nbsp;</td>
										<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
										<% if(adv_reac_code.equals("Oth")) { %>
											<td  class='<%=classValue%>' style = 'text-align:justify;word-break:break-all;' ><%=others_reaction%></td>
										<%} else { %>
											<td  class='<%=classValue%>' style = 'text-align:justify;word-break:break-all;' ><%=reac_desc%></td>
										<%}%>
										<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
										<td  class='<%=classValue%>' colspan='2' style = 'text-align:justify;word-break:break-all;'><%=reaction_site%></td><!--modified for the incident 33466 Bru-HIMS-CRF-292 -->
										

									</tr>
								<%}%>
								<%
							}else{
								if(!error_status.equals("E")){
								%>
										<tr id='third<%=m%>' Style="display:none;visibility:hidden" >
											<td  class='<%=classValue%>' nowrap >&nbsp;</td>
											<td class=<%=classValue%> align=center nowrap><fmt:message key="Common.ReactionDate.label" bundle="${common_labels}"/></td>
											<td class=<%=classValue%> align=center nowrap ><fmt:message key="eMR.reactiondesc.label" bundle="${mr_labels}"/></td>
											<td class=<%=classValue%> align=center nowrap ><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
											<td class=<%=classValue%> colspan='2' align=center nowrap><fmt:message key="eMR.SiteOfReaction.label" bundle="${mr_labels}"/></td>
											
										</tr>
										<tr id='second<%=m%>' Style="visibility:visible" >
											<td  class='<%=classValue%>' nowrap >&nbsp;</td>
											<td  class='<%=classValue%>' nowrap ><%=reaction_date1_disply%></td>
											<% if(adv_reac_code.equals("Oth"))	{ %>
												<td  class='<%=classValue%>' style = 'text-align:justify;word-break:break-all;' ><%=others_reaction%></td>
											<%}else{%>
												<td  class='<%=classValue%>' style = 'text-align:justify;word-break:break-all;' ><%=reac_desc%></td>
											<%}%>
											<td  class='<%=classValue%>' nowrap ><%=severity_two%></td>
											<td  class='<%=classValue%>' colspan='2' style = 'text-align:justify;word-break:break-all;' ><%=reaction_site%></td>
											
										</tr>

								<%
								}
							}
							allergen1=rs.getString("allergen_code");
								allergen2=rs.getString("allergen");
							reaction_date_prev =rs.getString("reaction_date");
							adv_event_type_code1=rs.getString("ADV_EVENT_TYPE");
							status1 = rs.getString("status");
							adv_event_type_ind_code1 = rs.getString("adv_event_type_ind");
							onset_date1 = rs.getString("onset_date");
							onset_date_disply1=DateUtils.convertDate(onset_date1,"DMYHMS","en",locale);
							if(status1.equals("A")){
							status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
							}
							else if(status1.equals("R")){
							status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Resolved.label","common_labels");
							}else if(status1.equals("E")){
							status1 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
							}
							rowcolor ++;
							m++;
							rowCount++;
						}
						if(!(rs_load.equals("load"))){
							if((norecord.equals("noreords"))){
								if(m==0){
								out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
								}
							}
						}
						%></table>
						<div id='allergenLink' style='position:absolute; visibility:hidden;overflow:none'></div>
						<%
					}
					%>
					<input type="hidden" name="detail" id="detail" value="" >
					<input type="hidden" name="rowcolor" id="rowcolor" value="<%=rowcolor%>" >
					<input type="hidden" name="cnt" id="cnt" value="" >
					<input type="hidden" name="flag" id="flag" VALUE="">
					<input type="hidden" name="flag1" id="flag1" VALUE="">
					<input type="hidden" name="modeResult1" id="modeResult1" VALUE="">
					<input type="hidden" name="PatientId" id="PatientId" value="<%=PatientId%>" >
					<input type="hidden" name="Encounter_Id" id="Encounter_Id" value="<%=Encounter_Id%>" >
					<input type="hidden" name="Allergen" id="Allergen" value="<%=allergen%>" >
					<input type="hidden" name="reaction_date" id="reaction_date" value="<%=reaction_date_prev%>" >
					<input type="hidden" name="onset_date" id="onset_date" value="<%=onset_date_disply%>" >
					<input type="hidden" name="reaction_desc" id="reaction_desc" value="<%=reac_desc%>" >
					<input type="hidden" name="internalStr" id="internalStr" value="<%=internalStr%>" >
					<input type="hidden" name="max_record" id="max_record" value="<%=max_record%>" >
					<input type="hidden" name="active_date" id="active_date" value="<%=active_date%>" >
					<input type="hidden" name="adv_event_type_code" id="adv_event_type_code" value="<%=adv_event_type_code%>" >
					<input type="hidden" name="adv_event_type_ind_code" id="adv_event_type_ind_code" value="<%=adv_event_type_ind_code%>" >
					<input type="hidden" name="final_reac_code_val" id="final_reac_code_val" value="<%=final_reac_code_val%>" >
					<input type="hidden" name="causative_substance" id="causative_substance" value="<%=causative_substance%>" >
					<input type="hidden" name="causative_code" id="causative_code" value="<%=causative_code%>" >
					<input type="hidden" name="severity" id="severity" value="<%=severity_two%>" >
					<!--       -->
					<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:5%; visibility:visible;' bgcolor='blue'>
						<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
							<tr>
								<td width='100%' id='t'></td>
							</tr>
						</table>
					</div>
					<!--       -->
				</form>
			</body>
	<%
	} catch(Exception e) {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		e.printStackTrace();
		//out.println("in RecordPatientAdverseEvent4.jsp @ :"+e);
	}
	finally {
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
	%>
</html>
<%!
public static String checkForNull(String inputString){
return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
<!--
<script>
function 	display_header(patient_id,adv_event_type_ind_code,adv_event_type_code,causative_code,adv_event_dtl_srl_no)
{

/*alert("patient_id==="+patient_id)
alert("adv_event_type_ind_code==="+adv_event_type_ind_code)
alert("adv_event_type_code==="+adv_event_type_code)
alert("causative_code==="+causative_code)
alert("adv_event_dtl_srl_no==="+adv_event_dtl_srl_no)*/


parent.PatAlertQueryResult.location.href='PatAlertQueryResult.jsp?patient_id='+patient_id+'&call_from=allergy&ADV_EVENT_TYPE_IND='+adv_event_type_ind_code+'&ADV_EVENT_TYPE='+adv_event_type_code+'&ALLERGEN_CODE='+causative_code+'&ADV_EVENT_SRL_NO='+adv_event_dtl_srl_no; 




}
</script>
-->


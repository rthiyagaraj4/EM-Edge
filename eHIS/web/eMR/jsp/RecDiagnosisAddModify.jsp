<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue %>
<%@ include file="RecDiagnosisGetValidation.jsp"%> 
<html>
<head>
<%	

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");

%>


<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src='../js/RecDiagnosis.js' language='javascript'></script>
<script src='../js/RecDiagnosisMain.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js'  language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language="javascript" src="../../eCA/js/jquery-1.7.2.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
//Maheshwaran K added for TH-KW-CRF-165.1
function callSetDiagCatg(){
	callDiagCateg(parent.RecDiagnosisAddModify.document.getElementById('diagcode'));
}

	function setVal(obj)
	{
		if(obj.checked == true)
			obj.value='Y';
		else
			obj.value='N';
	}

	function setFocus1()
	{
		if(document.forms[0].mode.value != 'modify')
			document.forms[0].code_set.focus();
	}

	
	function _refreshSet(){
		getCodeSet();
		setTermCode1();

	}
	//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	//Start
	function EnableNotifySetup()
	{
		var notify_code=document.forms[0].notification_setup.value;
		var notify_code1 = notify_code.split("&"); 
		var notifiable_code=notify_code1[0];
		var email_yn=notify_code1[1];
		var deft_note_type=notify_code1[2];//Added senthil
			
        var diagprob_code=document.forms[0].diagprob_code.value; 
        var diagprob_desc=document.forms[0].diagprob_desc.value;	
		if(document.forms[0].notification_setup.value!='')
		{ 
			
			if(document.forms[0].notifiable_form_mand_yn.value=="Y"&&document.forms[0].diag_enc_level.value=="N")document.forms[0].notifi_frm_mand_gif.style.visibility='visible';  //Added 24.2
			//if((document.forms[0].notifiable_form_mand_yn.value=="Y"&&diagprob_code!=''&&diagprob_desc!='') || (document.forms[0].notifiable_form_mand_yn.value=="Y"&&document.forms[0].diagprob_code.disabled&&diagprob_desc!='')){ 
			if((diagprob_code!=''&&diagprob_desc!='')||(document.forms[0].diagprob_code.disabled&&diagprob_desc!='')){ 
				document.forms[0].Addnotification.disabled=false;			
			}
			/*else if(document.forms[0].notifiable_form_mand_yn.value=="N"&&diagprob_code==''&&diagprob_desc=='' || document.forms[0].notifiable_form_mand_yn.value=="N"&&diagprob_code!=''&&diagprob_desc!=''){document.forms[0].Addnotification.disabled=false;
			}*//*else{ 
			document.forms[0].Addnotification.disabled=true;
			}*/
			document.forms[0].notifiable_code.value=notifiable_code;
			document.forms[0].email_yn.value=email_yn;
			document.forms[0].deft_note_type.value=deft_note_type; //Added senthil
		}
		else 
		{ 
			document.forms[0].notifi_frm_mand_gif.style.visibility='hidden';   //Added 24.2
			document.forms[0].Addnotification.disabled=true;
			document.forms[0].notifiable_code.value=notifiable_code;
			document.forms[0].email_yn.value=email_yn;
			document.forms[0].deft_note_type.value=deft_note_type; //Added senthil
		}
	}
	//End	
</script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad='setFocus1();callSetDiagCatg();' >
<%
	Connection con				= null;
	//Statement stmt				= null;
	PreparedStatement stmt		= null;
	ResultSet rset				= null;
	ResultSet rs2				= null;
	PreparedStatement stmt2		= null;
	PreparedStatement pstmt		= null;

	ResultSet rsset				= null;
	PreparedStatement prepstmt	= null;

	String check_box_value		= "";
	String significant_yn		= "";
	String srl_no_from_table	= "";
	String diag_code			= "";
	String retVal_auth			= "";

	String Practitioner_Id		= "";	
	String _Practitioner_Id		= "";	
	String scheme				= "";
    String scheme_desc			= "";
	String relationship_id		= "";
	String Locn_Code			="";	
	String Locn_Type			= "";
	String Patient_Id			= "";	
	String Encounter_Id			= "";
	String currentdate			= "";	
	String facilityId           = "";
	String currentdateTime		= "";
	String currentTime			= "";
	String dob					= ""; 
	String age					= "";
	String sex					= ""; 
	String associate_codes		= "";
	String notifiable_yn;
	String term_code			= "";	
	String term_set_id			= "";
	String nature				= "";  	
	String onset_date			= "";
	String onset_encounter_id="";//Mahesh added 06/04/2014
	String status				= "";  	
	String srl_no				= "";     
	String diastgSel_1			= "";
	String diastgSel_2			= "";
	String diastgSel_3			= "";	
	String	severity			= "";	
	String	onset_type			= "";
	String	priority			= "";	
	String	accuracy_code		= "";
	String	remarks				= "";	
	String patient_class		= "";	
	String disimage				= "visibility:hidden";
	String def_status			= ""; 
	String date_status			= "";
	String def_disable			= "";  
	String occur_srl_no			= "";
	String style_def			= "";		
	String mode					= "";
	String stage_code			= "";		
	String episode_type			= "";		
	String visit_adm_date		= "";		
	String modal_yn				= "N";	
	String called_from_ip		= "";	
    String dis_add_associate	= "disabled";
	String diagstagecode		= "";
	String onset_date_converted	= "";
	String status_date_converted= "";
	String cause_of_death_yn	= "N";
	String ext_mand_for_consq	= "";
	String astk_mand_for_dagg	= "";
	String isCalledFromCA		= "N";
	//
	String anatomical_site      = "" ;
	String applicable_side      = "" ;
	String anatomy_select_c     = "";
	String anatomy_select_o     = "";
	String applicable_l			= "";
	String applicable_r			= "";
	String applicable_b			= "";
	String applicable_n			= "";
	String is_oh_install        = "N";
	String diag_class_mand_yn        = "N";
	String restrict_sec_diag_yn        = "N";
	String diagMandVisible        = "";
	String anatomy_select_default = "";
	String diag_class			= "";
	String diag_catg			= "";
	String diag_catg_code			= "";
	String term_set_desc		= "";
	String spl_code				= "";
	int view_cnt				= 0;
	String free_text_applicable_yn = ""; 
	String term_code_short_desc = ""; 
	String restorative_Chart	= checkForNull((String)session.getAttribute("restorative_Chart"));
	
	String called_from_ot = checkForNull(request.getParameter("called_from_ot")); //this line Added for this CRF [PMG2012-CRF-0030]
	//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013
	//Start
	String notifiable_code=checkForNull(request.getParameter("notifiable_code"));
	String notifiable_code_style="";
	
	//End
	String facility_id			= checkForNull((String)session.getValue("facility_id"));

	String practitioner_type	= checkForNull(request.getParameter("practitioner_type"));
	String cause_of_death		= checkForNull(request.getParameter("cause_of_death"));
	String speciality_code		= checkForNull(request.getParameter("speciality_code"));
	String isCurrentEncounter	= checkForNull(request.getParameter("isCurrentEncounter"));
	String old_encounter_id		= checkForNull(request.getParameter("old_encounter_id"));
	String accession_number		= checkForNull(request.getParameter("accession_num"));
	String oh_chart_num			= checkForNull(request.getParameter("oh_chart_num"));	
	String option_id			= checkForNull(request.getParameter("option_id"));
    String _status				= checkForNull(request.getParameter("status"));
	String diagcode				= checkForNull(request.getParameter("diagcode")) ;
	String call_from				= checkForNull(request.getParameter("call_from")) ;//Calling From MDR added on 9/15/2009
	String totalRecords		= checkForNull(request.getParameter("totalRecords")) ;//Calling From MDR added on 9/15/2009
	String function_id		= checkForNull(request.getParameter("function_id")) ;//Added by Suji Keerthi for ML-MMOH-CRF-1605
	String dagger_independent_yn		= "" ;//Added For SRR-CRF-303.1 1/27/2010
	if(practitioner_type.equals(""))	
		practitioner_type		= checkForNull((String)session.getValue("practitioner_type"));

	StringBuffer sql			= new StringBuffer(); 
	String complaint_Desc		= ""; 
	String _complaint_Desc		= ""; 
	String complaint_id			= ""; 
	String _complaint_id		= "";
	boolean	firstTime			= true;
		
	String anatomical_site_code = "";
	String anatomical_short_desc= "";
	String oral_sites_style		= "visibility:hidden";
	String high_risk_code = "";				
	String highRiskDesc = "";				
	ArrayList prio_list=new ArrayList();
	ArrayList enc_stg_list=new ArrayList();
	ArrayList nat_list=new ArrayList();
	String diagnosis_by_long_desc_yn="N";
	String diag_enc_level="N";//Maheshwaran K Modified for the SKR-CRF-0020 as on 17/07/2013
	String curr_encounter_id="";//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
	String email_yn="";
	String email_sel_yn="";
	String default_note_type="",deflt_note_type="";//Added Senthil
	//Added for this Bru-HIMS-CRF-024.2
    String notifiable_form_mand_yn="N"; String notifiable_frm_mand_gif="";
    HashMap ResultParamHashMap = new HashMap();	
	//Added for this CRF Bru-HIMS-CRF-024.2
	String accession_num_work_related="",accession_num_notifiable="",dis_work_related_notifiable="";
	
	//Below line added for this CRF GDOH-CRF-0082
	 String pmb_code="";	 
	 boolean diagnosisPmb=false;
	 String support_diag_code="";
	 int supportdiagCount=0;
	//End GDOH-CRF-0082

	//Added by Ashwini on 29-Jun-2018 for ML-MMOH-CRF-1187
	Boolean isEnlargeDiagFldAppl = false;
	Boolean isMultiDescAppl = false; // added by mujafar for ML-MMOH-CRF-1281
	String includevisibility="visibility:hidden"; // added by mujafar for ML-MMOH-CRF-1281 END

	Boolean termCodeEffStatus = false; //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
	boolean isCoderDiagAppl	= false; //Added By Dharma on 3rd June 2020 against AAKH-CRF-0122.1
	Boolean isEncounterStage= false; //Added by KAMATCHI S for ML-MMOH-CRF-1581
	Boolean isDiagClassMand= false;  //Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
	Boolean isPrepDisDefaultDischargeAppl= false;  //Added by Suji Keerthi for ML-MMOH-CRF-1605
	//Added by Ajay for TH-KW-CRF 165.1
	//Started
	Boolean isDiagCatgMand = false; 
	Boolean isPatClsForDiagCat = false;
	
	String diagCatgForEM = "";
	String diagCatgForDC = "";
	String diagCatgForIP = "";
	String diagCatgForOP = "";
	
	String diagCatgDisabled = "disabled";
	String DiagCatgImgHdn = "hidden";
	//End of CRF TH-KW-CRF 165.1
	
	/* Added by Ajay Hatwate for ML-MMOH-CRF-1741 */
	String mode_modify_curr_enc="";

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String secondary_diag_class = "";
	String linkcheckboxdisp = "none";
	String link_diag_pri_sec_yn = "N";
	String checklinkprisec = "";
	String linked_yn = "";
	
	try
	{
		con = ConnectionManager.getConnection(request);
		//stmt = con.createStatement();
		isEncounterStage	=  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TERM_RECODE_DIAG");//Added by KAMATCHI S for ML-MMOH-CRF-1581
		isDiagClassMand =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DIAG_CLASS_MAND"); //Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
		isPrepDisDefaultDischargeAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"IP","PREPDIS_ADV_ENCSTAGE_DEFAULT"); //Added by Suji Keerthi for ML-MMOH-CRF-1605
		
		isDiagCatgMand  = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MR_DIAG_CATEGORY_MAND");
		patient_class				= checkForNull(request.getParameter("patient_class"));
		isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		/*Below line Added for this CRF Bru-HIMS-CRF-024.2*/
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("notifiable_form_mand_yn","S");		
		
		//Added by Ajay for TH-KW-CRF 165.1
		sqlColumns.put("DIAG_CATG_PR_FOR_DC_YN","S");	
		sqlColumns.put("DIAG_CATG_PR_FOR_EM_YN","S");	
		sqlColumns.put("DIAG_CATG_PR_FOR_IP_YN","S");	
		sqlColumns.put("DIAG_CATG_PR_FOR_OP_YN","S");	
		ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,"","mr_parameter",con);
		notifiable_form_mand_yn = (String) ResultParamHashMap.get("notifiable_form_mand_yn");		
		//End  Bru-HIMS-CRF-024.2		

		diagCatgForDC = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_DC_YN");
		diagCatgForIP = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_IP_YN");
		diagCatgForEM = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_EM_YN");
		diagCatgForOP = (String)ResultParamHashMap.get("DIAG_CATG_PR_FOR_OP_YN");

		
		if(patient_class.equals("IP") && diagCatgForIP.equals("Y")){
			isPatClsForDiagCat = true;
		}else if(patient_class.equals("OP") && diagCatgForOP.equals("Y")){
			isPatClsForDiagCat = true;
		}else if(patient_class.equals("EM") && diagCatgForEM.equals("Y")){
			isPatClsForDiagCat = true;
		}else if(patient_class.equals("DC") && diagCatgForDC.equals("Y")){
			isPatClsForDiagCat = true;
		}

		
		//End of TH-KW-CRF 165.1
		
       /*Below line added for this CRF GDOH-CRF-0082*/		
		diagnosisPmb=CommonBean.isSiteSpecific(con, "MR","DIAG_MAPPED_PMB"); 	
		//End GDOH-CRF-0082	   
		
		//Added by Ashwini on 29-Jun-2018 for ML-MMOH-CRF-1187
		isEnlargeDiagFldAppl = CommonBean.isSiteSpecific(con, "MR","ENLARGE_DIAGNOSIS_FIELD"); 

		termCodeEffStatus =  CommonBean.isSiteSpecific(con,"MR","CHK_TERM_CODE_EFF_STATUS"); //Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645
		isCoderDiagAppl =  CommonBean.isSiteSpecific(con,"MR","MR_CODER_DIAGNOSIS"); //Added By Dharma on 3rd June 2020 against AAKH-CRF-0122.1 
		
		isMultiDescAppl =  CommonBean.isSiteSpecific(con,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
		called_from_ip			= checkForNull(request.getParameter("called_from_ip"));
		visit_adm_date			= checkForNull(request.getParameter("visit_adm_date"));
		occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
		episode_type			= checkForNull(request.getParameter("episode_type"));
		srl_no					= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id			= checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id			= checkForNull(request.getParameter("relationship_id"));
		Locn_Code				= checkForNull(request.getParameter("Locn_Code"));			
		Locn_Type				= checkForNull(request.getParameter("Locn_Type"));
		Patient_Id				= checkForNull(request.getParameter("Patient_Id"));
       
		Encounter_Id			= checkForNull(request.getParameter("Encounter_Id"));
		associate_codes		= checkForNull(request.getParameter("associate_codes"));
		age						= checkForNull(request.getParameter("Age"));	
		dob						= checkForNull(request.getParameter("Dob"));	
		sex						= checkForNull(request.getParameter("Sex"));
		mode					= checkForNull(request.getParameter("mode"));
		if(mode.equals("modify_curr_enc")){
			mode = "modify";
			mode_modify_curr_enc = "modify_curr_enc";
		}
		modal_yn				= checkForNull(request.getParameter("modal_yn"));
		notifiable_yn			= checkForNull(request.getParameter("notifiable_yn"));
		term_set_id				= checkForNull(request.getParameter("term_set_id"));
		term_set_desc			= checkForNull(request.getParameter("term_set_desc"));
		isCalledFromCA			= checkForNull(request.getParameter("isCalledFromCA"));
		String isCleared		= checkForNull(request.getParameter("isCleared"));
		diag_class              = checkForNull(request.getParameter("diag_classification"));
		diag_catg_code              = checkForNull(request.getParameter("diagnosis_category"));
		term_code_short_desc    = checkForNull(request.getParameter("term_code_short_desc"));
		String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget")); //CHL-CRF- 0008 - IN:001472
		/*Below line added for this CRF Bru-HIMS-CRF-024.2*/
	/*	if(notifiable_form_mand_yn.equals("Y")&&"".equals(mode)){
		notifiable_frm_mand_gif = "visibility:visible";
		}else{
		notifiable_frm_mand_gif = "visibility:hidden";
		}		
		out.println("<script>alert('"+notifiable_frm_mand_gif+"');</script>");*/
		//End Bru-HIMS-CRF-024.2
		if(mode.equals("modify") && !diag_catg_code.equals("")){
			diagCatgDisabled = "";
			DiagCatgImgHdn = "";
		}

		/*Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742*/
		String sqllinkyn = " SELECT CASE WHEN MAX (CASE WHEN link_diag_pri_sec_yn = 'Y' THEN 1 ELSE 0 END) = 1 THEN 'Y' ELSE '' END AS linked_yn FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND status != 'E' ";
		
		prepstmt = con.prepareStatement(sqllinkyn);
		prepstmt.setString(1,Patient_Id);
		prepstmt.setString(2,Encounter_Id);
		prepstmt.setString(3,facility_id);

		rsset = prepstmt.executeQuery();

		if(rsset!=null && rsset.next()){
			linked_yn = (rsset.getString("linked_yn")==null || rsset.getString("linked_yn")=="")?"" : rsset.getString("linked_yn");
		}

		if (prepstmt!=null) prepstmt.close();
		if (rsset!=null) rsset.close();
		/*End ML-MMOH-CRF-1742*/
		
		//String getDate = "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual" ;
		//Maheshwaran K added diag_enc_level for the SKR-CRF-0020 as on 17/07/2013
		//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234
		String sqlScheme=" select diagnosis_by_long_desc_yn,diag_code_scheme scheme,restrict_sec_diag_yn,diag_class_mand_yn,diag_enc_level, decode(diag_code_scheme,'1','ICD10','2','ICD9-CM','5','READ') scheme_desc, to_char(trunc(sysdate),'dd/mm/yyyy') db_date,(select PRACTITIONER_NAME from am_practitioner where practitioner_id=?) Recorded_by_pract_name, EXT_MAND_FOR_CONSQ,ASTK_MAND_FOR_DAGG,(select to_char(sysdate,'dd/mm/rrrr hh24:mi')  from dual)sdate,(select install_yn from sm_module where  module_id  ='OH') OH_install, primary_diag_class, secondary_diag_class from MR_PARAMETER ";

		stmt=con.prepareStatement(sqlScheme);
		stmt.setString(1,Practitioner_Id);
		rset	  = stmt.executeQuery();

		if (rset.next())
		{
			currentdateTime	= checkForNull(rset.getString("sdate"));
			currentdate		= currentdateTime.substring(0,10);
			currentTime		= currentdateTime.substring(11);
		
            scheme      = checkForNull(rset.getString("scheme"));
            diag_class_mand_yn = checkForNull(rset.getString("diag_class_mand_yn"));
			restrict_sec_diag_yn = checkForNull(rset.getString("restrict_sec_diag_yn"));//Maheshwaran K added for MMS-DM-CRF-0197.1			
            scheme_desc = checkForNull(rset.getString("scheme_desc"));
			ext_mand_for_consq      = checkForNull(rset.getString("EXT_MAND_FOR_CONSQ"));
            astk_mand_for_dagg = checkForNull(rset.getString("ASTK_MAND_FOR_DAGG"));
			diag_enc_level = checkForNull(rset.getString("diag_enc_level"));//Maheshwaran K added for the SKR-CRF-0020 as on 17/07/2013
			diagnosis_by_long_desc_yn = checkForNull(rset.getString("diagnosis_by_long_desc_yn"));	//Maheshwaran K added diagnosis_by_long_desc_yn for HSA-CRF-0234
			 is_oh_install      = checkForNull(rset.getString("OH_install"));

			 //Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			 primary_diag_class = checkForNull(rset.getString("primary_diag_class"));
			 secondary_diag_class = checkForNull(rset.getString("secondary_diag_class"));
		}
		if ( rset != null ) rset.close();	
		//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
		curr_encounter_id=Encounter_Id;
		/*if(diag_enc_level.equals("Y")){

			if((old_encounter_id!="")&&(!old_encounter_id.equals(Encounter_Id)))
			Encounter_Id=old_encounter_id;
		}*/

		onset_date				= currentdateTime;

		onset_date_converted	=	DateUtils.convertDate(currentdateTime,"DMYHM","en",locale); 
		status_date_converted	=	DateUtils.convertDate(currentdate,"DMY","en",locale); 
		currentdate				=	DateUtils.convertDate(currentdate,"DMY","en",locale); 
		/*Added On 9/23/2009 FOr MDR*/
		

		String sql45	="select list_value,dflt_value_yn,criteria from  mr_term_set_crit_for_pc where  patient_class=? and criteria in ('PRIORITY','ENCOUNTER_STAGE','NATURE') ";	
		
		stmt=con.prepareStatement(sql45);
		stmt.setString(1,patient_class);
		rset = stmt.executeQuery();
		while(rset.next()){	
			if(checkForNull(rset.getString("criteria")).equals("PRIORITY")){
				prio_list.add(checkForNull(rset.getString("list_value")));
				prio_list.add(checkForNull(rset.getString("dflt_value_yn")));
							}else if (checkForNull(rset.getString("criteria")).equals("ENCOUNTER_STAGE")){
				enc_stg_list.add(checkForNull(rset.getString("list_value")));
				enc_stg_list.add(checkForNull(rset.getString("dflt_value_yn")));
			}else if (checkForNull(rset.getString("criteria")).equals("NATURE")){
				nat_list.add(checkForNull(rset.getString("list_value")));
				nat_list.add(checkForNull(rset.getString("dflt_value_yn")));
			}

		}
		

		if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
			mode="";
		}

		//out.println("<script>alert(\"mode :"+mode+"\");</script>");			

		if(isCleared.equals("Y"))
		{
			RecordSet OHDiagLinkConditionOBJ	=	(webbeans.eCommon.RecordSet)	session.getAttribute("OHDiagLinkConditionOBJ");
			if(OHDiagLinkConditionOBJ!=null)
			{
				OHDiagLinkConditionOBJ.clearAll();
				session.removeAttribute("OHDiagLinkConditionOBJ");
			}
		}
	
			
		if(!term_set_id.equals(""))
			disimage = "visibility:visible";
		term_code				= checkForNull(request.getParameter("term_code"));
		String term_code_dsply		= term_code;
		//if(term_code.equals("*OTH"))
			//term_code_dsply		= "";
				
		stage_code				= checkForNull(request.getParameter("stage_code"));
		String f_authorize_yn	= checkForNull(request.getParameter("f_authorize_yn"));

		String term_short_desc  = checkForNull(request.getParameter("term_short_desc"));
		String term_sht_desc  = checkForNull(request.getParameter("term_sht_desc")); // added by mujafar for ML-MMOH-CRF-1281
		String codes = "";			String Aselect ="";			String Pselect ="";
		String Wselect ="";			String pri_N_select ="";	String pri_H_select ="";
		String pri_C_select ="";	String sevr_L_select ="";	String sevr_D_select ="";
		String sevr_S_select ="";	String sevr_E_select ="";	String stus_A_select ="";
		String stus_R_select ="";	String stus_X_select ="";	String stus_E_select ="";

		String type_A_select = "";	String type_C_select = "";	String mandatory_status	=""; 
		String type_N_select = "";	
		String code_ind	="";		String mandatory_disable	=""; String diff_group_id	="";
		String def_select = "";
		String diag_class_code = "";
		String assign_locn_type = "";
		String _anatomical_site_code = "";
		String _anatomical_short_desc = "";
		String code = "";
		String poa_indicator	= "";
		
		
		/*4/29/2009 IN009713*/
		//11/5/2009 added facility_id

		String Splsql = "select specialty_code,assign_care_locn_type from pr_encounter where encounter_id=? AND facility_id=?" ;


		stmt=con.prepareStatement(Splsql);
		stmt.setString(1,Encounter_Id);
		stmt.setString(2,facility_id);
		rset = stmt.executeQuery();

		if(rset.next())
		{
			spl_code = checkForNull(rset.getString("specialty_code"));
			assign_locn_type = checkForNull(rset.getString("assign_care_locn_type"));
		}
		if(rset != null) rset.close();
		if(speciality_code.equals("") || speciality_code.equals("null"))
			speciality_code=spl_code;
			
		if(Locn_Type.equals("") || Locn_Type.equals("null"))
			Locn_Type=assign_locn_type;

		/**/

		if(is_oh_install==null || is_oh_install.equals(""))
			is_oh_install = "N";
		
	//if(modal_yn.equals("Y")) /*5/7/2009 IN010486*/


	if(modal_yn.equals("Y") && _status.equals("Active"))
	{
		dis_add_associate = "disabled";
		
		if(!term_code.equals("*OTH"))
		{
			//Maheshwaran K modified the query for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("select OCCUR_SRL_NO from pr_diagnosis  where patient_id = ? ");
			sql.append(" and TERM_SET_ID=? and TERM_CODE=?  and CURR_STATUS ='A' and curr_encounter_id= ?  ");
			pstmt = con.prepareStatement( sql.toString() ) ;
			pstmt.setString( 1, Patient_Id) ;
			pstmt.setString( 2, term_set_id) ;
			pstmt.setString( 3, term_code) ;
			//Mahesh modified to get the srl no of old enc id 
			if(diag_enc_level.equals("Y"))
				{
				pstmt.setString(4, old_encounter_id) ;
				}
			else
				{	
				pstmt.setString(4, Encounter_Id) ;
				}//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013
			rset = pstmt.executeQuery() ;
			while(rset.next())
			{
				occur_srl_no=checkForNull(rset.getString("OCCUR_SRL_NO"));
			}if (pstmt!=null) pstmt.close();
			 if(rset!=null) rset.close();

		}
		if(!occur_srl_no.equals(""))
			mode="modify";
	}	
	
	if(mode.equals("modify"))
	{
		disimage = "visibility:visible";
		mandatory_status="readonly";
		mandatory_disable	="disabled";
		def_select = "";
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("select a.accession_num,a.patient_id,a.term_set_id,a.term_code,accession_num_work_related,accession_num_notifiable,"); //Modified for this Bru-HIMS-CRF-024.2
		//Maheshwaran k modified the query for the SKR-SCF-0863 [IN:044466]  as on 22/10/2013
		if(term_code.equals("*OTH"))
			{
			sql.append(" a.term_code_short_desc term_short_desc, ");
			}
		else
			{	
			sql.append(" mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') term_short_desc, ");
			}
		if(isMultiDescAppl && term_set_id.equals("ICD10")) // Added by mujafar for ML-MMOH-CRF-1281
		sql.append("a.term_code_short_desc term_sht_desc,");
		sql.append("a.code_indicator,to_char(a.onset_date,'dd/mm/rrrr hh24:mi') onset_date,a.ONSET_ENCOUNTER_ID ,a.curr_severity, ");
		sql.append("a.curr_onset_type,a.curr_facility_id,"); 
		sql.append("a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id,"); sql.append("a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,");
		sql.append("a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status,"); sql.append("to_char(a.curr_status_date,'dd/mm/rrrr') status_date ,nvl(c.diff_group_id,'0') diff_group_id,b.high_risk_code,mr_get_desc.mr_high_risk(b.high_risk_code,'"+locale+"','1') highRiskDesc ");
		//<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->
		sql.append(" , a.anatomical_site , a.applicable_side ,a.diag_class_code,a.anatomical_site_code,AM_GET_DESC.AM_ANATOMICAL_SITE(a.anatomical_site_code,?,'2') anatomical_short_desc,b.dagger_independent_yn,a.poa_indicator poa_indicator");
		//
		sql.append(" from PR_DIAGNOSIS a, MR_TERM_CODE b ,");
		sql.append(" PR_DIFFERENTIAL_DIAGNOSIS c where a.term_code=b.term_code  ");
		sql.append(" and a.term_set_id = b.term_set_id "); 
		sql.append(" and c.term_code(+) = a.term_code ");
		sql.append(" and c.OCCUR_SRL_NO(+) = a.OCCUR_SRL_NO and c.term_set_id(+) = a.term_set_id and ");
		sql.append(" c.patient_id(+) = a.patient_id and ");
		sql.append(" a.patient_id = ? and a.term_set_id = ? and a.term_code = ? "); 
		//if(!term_code.equals("*OTH"))
			sql.append(" and a.occur_srl_no = ?");
		//else
			//sql.append(" and a.term_code_short_desc = ?");
		//sql.append("  and a.curr_status = 'A'");
       
		
		stmt2 = con.prepareStatement(sql.toString());
		
		stmt2.setString(1,locale);
		stmt2.setString(2,Patient_Id);
		stmt2.setString(3,term_set_id);
		stmt2.setString(4,term_code);
		//if(!term_code.equals("*OTH"))
		stmt2.setString(5,occur_srl_no);
		//else
			//stmt2.setString(5,term_code_short_desc);
		rs2 = stmt2.executeQuery();
		

		while(rs2.next())
		{
			status						= checkForNull(rs2.getString("curr_status"));
			Patient_Id				= checkForNull(rs2.getString("patient_id"));
			term_set_id			    = checkForNull(rs2.getString("term_set_id"));
			term_code				= checkForNull(rs2.getString("term_code"));
			term_short_desc		= checkForNull(rs2.getString("term_short_desc")); 
			if(isMultiDescAppl && term_set_id.equals("ICD10")) // added by mujafar for ML-MMOH-CRF-1281
			term_sht_desc		= checkForNull(rs2.getString("term_sht_desc"));
			onset_date				= checkForNull(rs2.getString("onset_date"));
			onset_encounter_id				= checkForNull(rs2.getString("ONSET_ENCOUNTER_ID"));//Mahesh added 06/04/2014
			onset_date_converted	=	DateUtils.convertDate(onset_date,"DMYHM","en",locale); 
			currentTime				= onset_date.substring(11);
			severity					= checkForNull(rs2.getString("curr_severity"));
			onset_type				= checkForNull(rs2.getString("curr_onset_type"));
			curr_encounter_id		= checkForNull(rs2.getString("curr_encounter_id"));
			_Practitioner_Id		= checkForNull(rs2.getString("curr_practitioner_id"));
			relationship_id			= checkForNull(rs2.getString("curr_practitioner_reln_id"));
			/* IN010259 */
			//Locn_Type				= checkForNull(rs2.getString("curr_locn_type"));
			//Locn_Code				= checkForNull(rs2.getString("curr_locn_code"));
			nature						= checkForNull(rs2.getString("curr_nature"));
			priority						= checkForNull(rs2.getString("curr_priority"));
			accuracy_code			= checkForNull(rs2.getString("curr_accuracy_code"));
			remarks					= checkForNull(rs2.getString("curr_remarks"));
			diff_group_id			= checkForNull(rs2.getString("diff_group_id"));
			high_risk_code			= checkForNull(rs2.getString("high_risk_code"));
			highRiskDesc			= checkForNull(rs2.getString("highRiskDesc"));
			status_date_converted		= checkForNull(rs2.getString("status_date"));
			status_date_converted		=	DateUtils.convertDate(status_date_converted,"DMY","en",locale); 
			code_ind							= checkForNull(rs2.getString("code_indicator"));
			anatomical_site					= checkForNull(rs2.getString("anatomical_site"));
			applicable_side					= checkForNull(rs2.getString("applicable_side"));
			diag_class_code				= checkForNull(rs2.getString("diag_class_code"));
			dagger_independent_yn	= checkForNull(rs2.getString("dagger_independent_yn"));
			if(accession_number.equals(""))
				accession_number			= checkForNull(rs2.getString("accession_num"));
			_anatomical_site_code		= checkForNull(rs2.getString("anatomical_site_code"));
			_anatomical_short_desc	= checkForNull(rs2.getString("anatomical_short_desc"));
			
			//Below line Added for this CRF Bru-HIMS-CRF-024.2
			accession_num_work_related = checkForNull(rs2.getString("accession_num_work_related"));
			accession_num_notifiable = checkForNull(rs2.getString("accession_num_notifiable"));
			poa_indicator = checkForNull(rs2.getString("poa_indicator"));
			if(!accession_num_work_related.equals(""))
			dis_work_related_notifiable= "disabled";
			else
			dis_work_related_notifiable= "";
			
		}

		if(code_ind.equals(""))
			dis_add_associate = "disabled";
		else
			dis_add_associate = "";


		if(rs2!=null) rs2.close();
		if(stmt2!=null) stmt2.close();

		
		if(nature.equals("A"))
			Aselect = "selected";
		else if(nature.equals("P"))
			Pselect = "selected";
		else if(nature.equals("W"))
			Wselect = "selected";

		if(priority.equals("N"))
			pri_N_select = "selected";
		else if(priority.equals("H"))
			pri_H_select = "selected";
		else if(priority.equals("C"))
			pri_C_select = "selected";

		if(severity.equals("L"))
			sevr_L_select = "selected";
		else if(severity.equals("D"))
			sevr_D_select = "selected";
		else if(severity.equals("S"))
			sevr_S_select = "selected";
		else if(severity.equals("E"))
			sevr_E_select = "selected";
	
		if(status.equals("A"))
		{	
			stus_A_select = "selected";
			def_status="";
			date_status="readOnly";
			def_disable	="";
		}
		else if(status.equals("R"))
		{
			stus_R_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("X"))
		{
			stus_X_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
		else if(status.equals("E"))
		{
			stus_E_select = "selected";
			def_status="readonly";
			def_disable	="disabled";
		}
	
		if(onset_type.equals("A"))
			type_A_select = "selected";
		else if(onset_type.equals("C"))
			type_C_select = "selected";
		else 
			type_N_select = "selected";

		if(!option_id.equals("OH_REST_CHART_REC"))
		{
		
			if(anatomical_site.equals("O"))
				anatomy_select_o = "selected";
			else if(anatomical_site.equals("C"))
				anatomy_select_c = "selected";
			else
				anatomy_select_default = "selected";


		}
		else
		{
			if(anatomical_site.equals("C"))
				anatomy_select_c = "selected";
			else if(anatomical_site.equals("O"))
				anatomy_select_o = "selected";	
			else
				anatomy_select_default = "selected";			
		}

		
		if(applicable_side.equals("L"))
			applicable_l = "selected";
		else if(applicable_side.equals("R"))
			applicable_r = "selected";
		else if(applicable_side.equals("B"))
			applicable_b = "selected";
		else if(applicable_side.equals("N"))
			applicable_n = "selected";
		
		//For Supprot Diiagnosis.......
		if(sql.length() > 0) sql.delete(0,sql.length());
		int temp=0;
		String supp_term_code=""; String supp_term_desc ="";
		StringBuffer temp_associate_codes = new StringBuffer();
        //Added for this CRF GDOH-CRF-0082		
		StringBuffer temp_supportdiag_codes = new StringBuffer();		
		
		
/*
		sql.append(" select a.supp_term_code ,b.short_desc from PR_SUPPORT_DIAGNOSIS a , ");
		sql.append(" MR_TERM_CODE b where b.term_code = a.supp_term_code and a.patient_id =? and ");
		sql.append(" a.term_code = ? and b.term_set_id = ? and occur_srl_no=? and srl_no=");
		sql.append("(select max(srl_no) from PR_SUPPORT_DIAGNOSIS where patient_id=a.patient_id and "); 
		sql.append(" term_set_id=a.term_set_id and term_code=a.term_code and occur_srl_no=a.occur_srl_no) ");
		

sql.append("  SELECT a.supp_term_code, b.short_desc FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = ? AND a.term_set_id = ? AND b.term_set_id = ? AND a.term_code = ? AND occur_srl_no = ? AND srl_no = (SELECT MAX (srl_no) FROM pr_support_diagnosis WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no) ");
*/
		/*Friday, January 29, 2010 SRR20056-CRF-0303.2 IN015597 */
		sql.append("  SELECT a.supp_term_code, b.short_desc FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = ? AND a.term_set_id = ? AND b.term_set_id = ? AND a.term_code = ? AND occur_srl_no = ?  ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,Patient_Id);
		pstmt.setString(2,term_set_id);
		pstmt.setString(3,term_set_id);
		pstmt.setString(4,term_code);
		pstmt.setString(5,occur_srl_no);
		rset = pstmt.executeQuery();
		      
		temp = 0;
		while(rset.next())
		{
			supp_term_code = checkForNull(rset.getString(1));
			supp_term_desc = checkForNull(rset.getString(2));
			/*Added by Dharma for single quote issue Start for ML-MMOH-CRF-0733*/
			if(!supp_term_desc.equals("")){
				supp_term_desc	= supp_term_desc.replaceAll("\'","");
			}
			/*Added by Dharma for single quote issue End*/				
			if(temp == 0)
				temp_associate_codes.append(supp_term_code + "~" + supp_term_desc);
			else
				temp_associate_codes.append("|" + supp_term_code + "~" + supp_term_desc);	
			temp++;
			
			//Below line added for this CRF GDOH-CRF-0082
			temp_supportdiag_codes.append("'"+supp_term_code+"',"); 
			supportdiagCount++;
		}
	   //Below line added for this CRF GDOH-CRF-0082
		support_diag_code = temp_supportdiag_codes.toString();
		if(!support_diag_code.equals("")){	
			support_diag_code=support_diag_code.substring(0,support_diag_code.length()-1);
		}	
		//End GDOH-CRF-0082
		
		if(associate_codes.equals(""))
			associate_codes = temp_associate_codes.toString();

		
		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		
		/*Below line added for this CRF GDOH-CRF-0082*/	
           if(diagnosisPmb){   
              pmb_code=eMR.MRQueryPMBCode.getPMBCode(con,term_code_dsply);             		  
	       }			
		//End GDOH-CRF-0082
		
	}
	else
	{
		def_disable="";			def_status	="";
		mandatory_status="";	mandatory_disable	="";
		def_select = "selected";

		if(option_id.equals("OH_REST_CHART_REC"))
		{
			anatomy_select_c = "selected";	
			oral_sites_style = "visibility:visible";
		}
		else		
		{
			anatomy_select_o = "selected";
			oral_sites_style = "visibility:hidden";
		}

		if(option_id.equals("OH_REST_CHART_REC"))	
		{
			anatomical_site = "C";
			oral_sites_style= "visibility:visible";
		}
		else
		{
			anatomical_site = "O";
			oral_sites_style= "visibility:hidden";
		}

		
	}

	
	//For  Diagnosis Stage
	//added encounter_id on 3/26/2009 since returning more rows for multiple encounters.
	//11/5/2009 added facility_id

	if(sql.length() > 0) sql.delete(0,sql.length());
	
		sql.append(" Select enc_stage,NOTIFICATION_CODE, cause_of_death_yn, link_diag_pri_sec_yn  from PR_DIAGNOSIS_ENC_DTL where patient_id = ? and TERM_CODE = ? and TERM_SET_ID = ? and encounter_id = ?  and facility_id= ? AND status != 'E'");//Modified on 3rd May 2018 against ML-BRU-SCF-1818
	//sql.append(" Select ip_diag_stage from pr_problem where patient_id = ? and srl_no = ? ");

	pstmt	=	con. prepareStatement(sql.toString());
	pstmt.setString(1,Patient_Id);
	//pstmt.setString(2,srl_no);
	pstmt.setString(2,term_code);
	pstmt.setString(3,term_set_id);
	pstmt.setString(4,Encounter_Id);
	pstmt.setString(5,facility_id);
	rset = pstmt.executeQuery();

	if(rset.next())
	{
		diagstagecode	=	checkForNull(rset.getString("enc_stage"));
		/*Added on 3rd May 2018 against ML-BRU-SCF-1818 Start*/
		if(notifiable_code.equals("") && diag_enc_level.equals("N"))
			notifiable_code	=	checkForNull(rset.getString("NOTIFICATION_CODE"));
		/*End*/
		cause_of_death_yn	=	checkForNull(rset.getString("cause_of_death_yn"));
		link_diag_pri_sec_yn = checkForNull(rset.getString("link_diag_pri_sec_yn")); //Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
 	}
	/*Added on 3rd May 2018 against ML-BRU-SCF-1818 Start*/
	if(notifiable_code.equals(""))
	notifiable_code_style="disabled";
	/*End*/
	if(cause_of_death_yn == null)	cause_of_death_yn = "N";

	String checkDeath = "";
	if(cause_of_death_yn.equals("Y"))
		checkDeath = "checked";
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	if(link_diag_pri_sec_yn == null) link_diag_pri_sec_yn = "N";
	if(link_diag_pri_sec_yn.equals("Y"))
		checklinkprisec = "checked";
	
	if(rset!=null)  rset.close();
	if(pstmt!=null) pstmt.close();

	
	if(!(diagstagecode==null || diagstagecode.equals("")))
		{
			if(diagstagecode.equals("A"))
				diastgSel_1="selected";
			else if(diagstagecode.equals("I"))
				diastgSel_2="selected";
			else if(diagstagecode.equals("D"))
				diastgSel_3="selected";
		}

	
		// Changes modified on 02-03-2012 against Incident Number 26033 by Saanthaakumar
		
		
		
	if(called_from_ip.equals("Y"))
	{

		    if(diagstagecode.equals("A"))
				diastgSel_1="selected";
			else if(diagstagecode.equals("I"))
				diastgSel_2="selected";
			else if(diagstagecode.equals("D"))
				diastgSel_3="selected";
	}
//modified over Incident Number 26033

	
String recode_curr_level	= "";

if(mode.equals("modify")) {

	String view_link = "SELECT Count(*) FROM mr_equivalent_term_code  WHERE term_code = ? and CROSS_REF_TYPE='EQ'";
		
			pstmt = con.prepareStatement( view_link.toString() ) ;
			pstmt.setString( 1, term_code) ;
			rset = pstmt.executeQuery();
			if(rset != null && rset.next())
				view_cnt = rset.getInt(1);
			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();

	
if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text, to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and a.occur_srl_no='"+occur_srl_no+"'");
			if(!term_code.equals("*OTH"))
				sql.append("and a.term_code = ? ");
			else
				sql.append("and a.term_code_short_desc = ? ");
			sql.append("order by a.onset_date desc");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,Encounter_Id);
			pstmt.setString(4,term_set_id);
			if(!term_code.equals("*OTH"))
				pstmt.setString(5,term_code);
			else
				pstmt.setString(5,term_short_desc);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				complaint_Desc		= rset.getString("complaint_text")==null?"":rset.getString("complaint_text");
				complaint_id		= rset.getString("complaint_id")==null?"":rset.getString("complaint_id");
				if(firstTime)
				{
					_complaint_Desc = _complaint_Desc + "" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "" +complaint_id +"";
				}
				else
				{
					_complaint_Desc = _complaint_Desc + ";" +complaint_Desc +"";
					_complaint_id   = _complaint_id + "$" +complaint_id +"";
				}
				firstTime = false;
			}
				
			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();

/*
	1.Added On 2/22/2010 For SRR-CRF-303.2 [IN015597]
	2.Makring of Originals from Recording when recoding was started for a patient.
	3.Retriving the  Curr_Level is at Encounter Level.
*/


			String RECODE_HDR_SQL ="SELECT CURR_LEVEL FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+facility_id+"' AND ENCOUNTER_ID='"+Encounter_Id+"'";
			pstmt = con.prepareStatement(RECODE_HDR_SQL);
			rset	= pstmt.executeQuery();
			while(rset.next()){
				recode_curr_level = checkForNull(rset.getString("CURR_LEVEL"));
			}

			if(rset!=null)  rset.close();
			if(pstmt!=null) pstmt.close();

}



%>
<script>

function decider()
{
	code_indicator = document.forms[0].code_indicator.value;
	
	/*
	if(code_indicator == 'C')
		addAssociateCodes();
	else if(code_indicator == 'D')*/
		addAssociateCodes1();
}


async function addAssociateCodes()
{

	
	code_indicator = document.forms[0].code_indicator.value;
	
	if(code_indicator == 'C')
		code_indicator = 'E';
	else if(code_indicator == 'D')
		code_indicator = 'A';
	
	diag_desc = document.forms[0].diagprob_desc.value;
	p_scheme = '<%=scheme%>';
	var associate_codes = document.forms[0].associate_codes.value;

	diag_code = document.forms[0].diagprob_code.value;
	
	var retVal				= "";
	var dialogHeight		= "18";
	var dialogWidth			= "40" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	var scheme_desc= document.forms[0].scheme_desc.value; 
	var Encounter_Id= document.forms[0].Encounter_Id.value ;
	var p_auth_yn="N";
    var s = document.forms[0].scheme.value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].sex.value;
	var dob = document.forms[0].dob.value;
	
	var arguments			= "" ;
	
	var mode =  document.forms[0].mode.value;

	var qs1 = "code_indicator=" + code_indicator + "&diag_desc=" + diag_desc + "&title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob + "&p_scheme=" +  p_scheme +"&diag_code="+diag_code+"&term_set_id="+scheme_desc+"&associate_codes="+associate_codes+"&mode="+mode;;
	
	//retVal = window.showModalDialog("../../eCA/jsp/AddAssociateCodeFrames.jsp?" + qs1,arguments,features);
	retVal = await window.showModalDialog("../../eMR/jsp/AddAssociateCodeFrames.jsp?" + qs1,arguments,features);

	if(retVal != null)
		document.forms[0].associate_codes.value = retVal;
		
}

async function addAssociateCodes1()
{
	code_indicator = document.forms[0].code_indicator.value;
	if(code_indicator == 'C')
		code_indicator = 'E';
	else if(code_indicator == 'D')
		code_indicator = 'A';
	
	diag_desc = document.forms[0].diagprob_desc.value;
	p_scheme = '<%=scheme%>';
	var associate_codes = document.forms[0].associate_codes.value;
	var associate_codes_modify = document.forms[0].associate_codes_modify.value;

	diag_code = document.forms[0].diagprob_code.value;
	
	var retVal				= "";
	var dialogHeight		= "60vh" ;
	var dialogWidth			= "70vw" ;
	var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	
	var scheme_desc= document.forms[0].scheme_desc.value; 
	var Encounter_Id= document.forms[0].Encounter_Id.value ;
	var p_auth_yn="N";
    var s = document.forms[0].scheme.value;
	var age = document.forms[0].age.value;
	var sex = document.forms[0].sex.value;
	var dob = document.forms[0].dob.value;
	var code_set = document.forms[0].code_set.value;
	
	var mode =  document.forms[0].mode.value; //Added for this CRF GDOH-CRF-0082
		var arguments			= "" ;
		var qs1 = "code_indicator=" + code_indicator + "&title="+scheme_desc+" Code List&p_diag_code="+s+"&p_diag_scheme_desc="+scheme_desc+"&Encounter_Id="+Encounter_Id+"&p_auth_yn="+p_auth_yn+"&cause_indicator=&Age=" + age + "&Sex=" + sex + "&Dob=" + dob + "&p_scheme=" +p_scheme +"&diag_code="+diag_code+"&code_set="+code_set+"&associate_codes="+associate_codes+"&associate_codes_modify="+associate_codes_modify+"&mode="+mode+ "&diag_desc=" + diag_desc;  //Modified by Sangeetha for ML-MMOH-CRF-0733
		
					
		//Above line modified for this CRF GDOH-CRF-0082
		
		//retVal = window.showModalDialog("../../eCA/jsp/AddDaggerCodeFrames.jsp?" + qs1,arguments,features);
		retVal = await top.window.showModalDialog("../../eMR/jsp/AddDaggerCodeFrames.jsp?" + qs1,arguments,features);
		if(retVal != null )
			document.forms[0].associate_codes.value = retVal;
					
//Below line added for this CRF GDOH-CRF-0082  
		//if(retVal!=null){
 if(document.forms[0].diagnosisPmb&&document.forms[0].diagnosisPmb && document.forms[0].diagnosisPmb&&document.forms[0].diagnosisPmb.value=="true"){
	   if(retVal !="" && retVal != null && retVal != undefined){ 
				var supportdiagcode="";
				var ret1=unescape(retVal);					
				var diag_code = ret1.split("|");				
				for(var i=0; i<diag_code.length; i++){
					var temp=diag_code[i].split('~');
					var str1 = new String(temp);			   
					var indx=str1.indexOf(",");			    
					var code=str1.substring(0,indx); 			 
					supportdiagcode+="'"+code+"'"+",";								   
				}
		 if(supportdiagcode!="")supportdiagcode=supportdiagcode.substring(0,supportdiagcode.length-1); 			
            document.forms[0].pmbsupportdiag.value = supportdiagcode; 
            document.forms[0].totsupportdiagCount.value = diag_code.length;            
            PMBValidation();			
		}			
	}
//End GDOH-CRF-0082	
}


function callDesc(Obj)
{
	document.getElementById('view_link').style.visibility='hidden';

	//Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
	var termset_id = document.forms[0].code_set.value;	

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH termset_id=\""+termset_id+"\" action='getFreeTextApplYN' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/MRIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var free_text_applicable_yn	= trimString(responseText);
	//End ML-MMOH-SCF-2123
	
	if(Obj.value == "")
	{ 
	    //Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
	    if(free_text_applicable_yn == 'Y'){      
			document.forms[0].diagprob_desc.disabled = false;
		}else{
			document.forms[0].diagprob_desc.disabled = true;
		}
		//End ML-MMOH-SCF-2123

		document.forms[0].LongDescription.value="";
		document.forms[0].diagprob_desc.value="";
		document.forms[0].Description.value="";	
		document.forms[0].exclamation.style.visibility='hidden';
		//document.forms[0].view_link.style.visibility='hidden';
		document.forms[0].ntf_button.style.visibility='hidden';	document.forms[0].AddAssociateCodes.disabled=true;
		document.forms[0].dagger_independent_yn.value="N";
		document.forms[0].high_risk.style.visibility='hidden'  // Saantha


		if(document.forms[0].isMultiDescAppl.value == "true")
		{ // added by mujafar for ML-MMOH-CRF-1281
			document.getElementById('other_disp1').style.visibility='hidden';
			document.getElementById('other_disp2').style.visibility='hidden';
		
		}
		
		//Below line Added for this CRF Bru-HIMS-CRF-024.2
		var diagprob_code=document.forms[0].diagprob_code.value; 
        var diagprob_desc=document.forms[0].diagprob_desc.value;	   
		if(document.forms[0].notification_setup.value!=''&& document.forms[0].notifiable_form_mand_yn.value=="Y" && diagprob_code==''&& diagprob_desc=='')
		{  
			document.forms[0].Addnotification.disabled=true;
		}
		
		//Below line added for this CRF GDOH-CRF-0082
		if(document.forms[0].diagnosisPmb&&document.forms[0].diagnosisPmb.value=="true"){
			parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='hidden';						
			parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML="";
			document.forms[0].totsupportdiagCount.value="";	
            document.forms[0].pmbsupportdiag.value="";	
		}
		//End GDOH-CRF-0082	
			
	}
	else
		Obj.value = Obj.value.toUpperCase();	

	
	if(makeValidString(Obj)==false)
	return false;

	var sex = document.forms[0].sex.value;
	var dob = document.forms[0].dob.value;

	var mode =  document.forms[0].mode.value;
	var called_from_ip =  document.forms[0].called_from_ip.value;
	var code_set =  document.forms[0].code_set.value;
	var modal_yn = document.forms[0].modal_yn.value;
	
	if(mode=="modify")
	{
		return false;
	}
	//Monday, October 18, 2010  IN024381  -SCF-SRR20056-SCF-5625
//	if(trimCheck(Obj.value)=="")
	if((Obj.value)=="")
	{
		document.forms[0].diagprob_desc.disabled = false;
		document.forms[0].diagprob_desc.focus();
		return false;
	}
	else
	{
		
		document.forms[0].diagprob_desc.disabled = true;
		document.forms[0].diagprob_desc.value = '';
	}

    var pq = document.forms[0].scheme.value;


    var stagecode = document.forms[0].diag_stage.value;
	var isMultiDescAppl = document.forms[0].isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281
    if (pq == 1 || pq == 2)
    {
		 //  var p_diag_code = Obj.value;
		//Monday, October 18, 2010  IN024381  -SCF-SRR20056-SCF-5625
		//var p_diag_code = encodeURIComponent(Obj.value);
//		var p_diag_code = trimString(Obj.value);
		var p_diag_code = Obj.value;
//		Obj.value=p_diag_code;
        var indicator= "";
        if(pq=='2')
            indicator = document.forms[0].cause_ind.value; //chk if the form field is a hidden field or the select box object
        var p_scheme  = <%=scheme%>;
        var sensitive='N';


		var authorizeButton=parent.RecDiagnosisOpernToolbar.document.forms[0].authorizeButton.value;
		if(parent.RecDiagnosisOpernToolbar.document.forms[0].mode)
		parent.RecDiagnosisOpernToolbar.document.forms[0].mode.value='Authorize Mode';
        if(parent.RecDiagnosisOpernToolbar.document.forms[0].authorize!=null)
        {
           if(parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value=="Normal Mode")
                sensitive='Y';
        }

		
        htmlVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMR/jsp/DiagRecodePatProblemVal.jsp'><input type='hidden' name='p_stage_code' id='p_stage_code' value='"+stagecode+"'><input type='hidden' name='p_diag_code' id='p_diag_code' value='"+p_diag_code+"'><input type='hidden' name='p_scheme' id='p_scheme' value='"+p_scheme+"'><input type='hidden' name='p_cause_indicator' id='p_cause_indicator' value='"+indicator+"'><input type='hidden' name='p_sensitive_yn' id='p_sensitive_yn' value='"+sensitive+"'><input type='hidden' name='authorizeButton' id='authorizeButton' value='"+authorizeButton+"'><input type='hidden' name='Sex' id='Sex' value='"+sex+"'><input type='hidden' name='Dob' id='Dob' value='"+dob+"'><input type='hidden' name='code_set' id='code_set' value='"+code_set+"'><input type='hidden' name= 'associate_codes' id= 'associate_codes' value='" + document.forms[0].associate_codes.value + "'><input type='hidden' name='modal_yn' id='modal_yn' value='<%=modal_yn%>'><input type='hidden' name='calledFromDeathReg' id='calledFromDeathReg' value=''><input type='hidden' name='isMultiDescAppl' id='isMultiDescAppl' value='"+isMultiDescAppl+"'></form></body></html>";
		// Modified by mujafar for ML-MMOH-CRF-1281	
		
		if(called_from_ip == "Y" || modal_yn == "Y") /* || '<calledFromDeathReg%>' == "Y" */
		{ 
			  
			parent.messageFrame.document.write(htmlVal);
		    parent.messageFrame.document.form1.submit();
		}
		else
		{
	        top.content.workAreaFrame.support.document.body.insertAdjacentHTML('afterbegin',htmlVal);
		    top.content.workAreaFrame.support.document.form1.submit();
		}
    }
	
}

</script>
<form name='RecDaignosis_form' id='RecDaignosis_form'  action='../../servlet/eMR.RecDiagnosisServlet' method='post' target='messageFrame'>
<font size=1>
<div>
	<table border=0 cellpadding='3' cellspacing='0' width="100%">
	<tr height='1'> 
	<!--<th colspan='10'  style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;' class="COLUMNHEADER"><font='verdana' size=2 ><fmt:message key="eMR.UpdateDiagnosisProfile.label" bundle="${mr_labels}"/></font></th>-->
	<%if(call_from.equals("MAINTAIN_DEATH_REGISTER")){%>
			<td class="COLUMNHEADER" colspan='5' style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='2'><fmt:message key="eMR.CurrentDiagnosisProfile.label" bundle="${mr_labels}"/></font></td>
	<%}else{%>
			<td class="COLUMNHEADER" colspan='5' style='BACKGROUND-COLOR: #ffc5b5;COLOR: black;'><font='verdana' size='2' ><fmt:message key="eMR.UpdateDiagnosisProfile.label" bundle="${mr_labels}"/></font></td>
	<%}%>
	</tr>
	<tr>
		<td class='label' width='12%'><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></td>
	    <td width='18%' class='fields'><select name="code_set" id="code_set" <%if(mode.equals("modify") ||modal_yn.equals("Y"))%><%=mandatory_disable%> onblur='' onChange="getCodeSet('x');/*showTable(this);*/setTimeout('setTermCode1()',100);" onmousewheel='return false;'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
	<%

			if(sql.length() > 0) sql.delete(0,sql.length());
			//sql.append(" select a.term_set_id,(select dflt_term_set_yn from mr_term_set_for_pract_type		 where term_set_id=a.term_set_id and pract_type = ?)dflt_term_set_yn,priority_appl_yn || '=' || nature_appl_yn || '=' || severity_appl_yn || '=' || onset_type_appl_yn || '=' || factors_appl_yn || '=' || notification_appl_yn || '=' || enc_stage_appl_yn term_set_id1, term_set_desc from MR_TERM_SET a where exists (select 1 from MR_TERM_SET_FOR_FACILITY where facility_id = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id = ? and encounter_id = ? ) and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT ib where practitioner_id = ? and ( term_set_id = a.term_set_id or not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id = ? ))) and eff_status = 'E' and diag_spec_yn = 'Y' order by term_set_desc ");
			/*3/5/2009 IN008756 for defaulting practitioner and pract type*/
			//inpatient_appl_yn and daycare_appl_yn is Added for ML-MMOH-CRF-1581 by KAMATCHI S //diagnosis_class_mand_yn Added by Suji Keerthi for ML-MMOH-CRF-1395 US002
			sql.append(" select a.term_set_id,(SELECT b.dflt_term_set_yn FROM mr_term_set_for_pract_type b,am_practitioner c WHERE b.pract_type = ? AND b.term_set_id = a.term_set_id AND c.practitioner_id = ? AND c.pract_type = b.pract_type) default_pract_type,(SELECT b.dflt_term_set_yn FROM mr_term_set_for_pract_type d,  mr_term_set_for_pract b, am_practitioner c WHERE d.term_set_id = b.term_set_id AND d.pract_type = ? AND b.practitioner_id = ?  AND c.practitioner_id = b.practitioner_id AND c.pract_type = d.pract_type AND a.term_set_id = d.term_set_id) default_pract,priority_appl_yn || '=' || nature_appl_yn || '=' || severity_appl_yn || '=' || onset_type_appl_yn || '=' || factors_appl_yn || '=' || notification_appl_yn || '=' || enc_stage_appl_yn || '=' ||inpatient_appl_yn || '=' || daycare_appl_yn || '=' || diagnosis_class_mand_yn term_set_id1 , mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1)term_set_desc ,free_text_applicable_yn from MR_TERM_SET a where exists (select 1 from MR_TERM_SET_FOR_FACILITY where facility_id = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type = ? and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id = ? and encounter_id = ? ) and term_set_id = a.term_set_id) and (exists (select 1 from MR_TERM_SET_FOR_PRACT ib where practitioner_id = ? and  term_set_id = a.term_set_id) or not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id = ? )) and eff_status = 'E' and diag_spec_yn = 'Y' order by term_set_desc ");
			
			pstmt = con.prepareStatement(sql.toString());

            pstmt.setString( 1, practitioner_type);
			pstmt.setString( 2, Practitioner_Id);
			pstmt.setString( 3, practitioner_type);
			pstmt.setString( 4, Practitioner_Id);
			pstmt.setString( 5, facility_id);
			pstmt.setString( 6, practitioner_type);
			pstmt.setString( 7, facility_id);
			pstmt.setString( 8, Encounter_Id);
			pstmt.setString( 9, Practitioner_Id);
			pstmt.setString( 10, Practitioner_Id);
			rset = pstmt.executeQuery();
			

			while(rset.next())
			{
				String desc = checkForNull(rset.getString("term_set_desc"));
				//String dflt_term_set_yn = rset.getString("dflt_term_set_yn");
				String default_pract_type = checkForNull(rset.getString("default_pract_type"));
				String default_pract = checkForNull(rset.getString("default_pract"));
				code = checkForNull(rset.getString("term_set_id"));
				
				String code1 = checkForNull(rset.getString("term_set_id1"));
				free_text_applicable_yn = checkForNull(rset.getString("free_text_applicable_yn"));
				String sel = "";

				if(term_set_id.equals(code))
				{
					out.print("<option value='"+code+"' id='"+code1+"' selected >"+desc+"</option>");
				}
				/*
					If we not use this condition(!mode.equals("modify")) in modify mode it reloading again 2/18/2009 (IN008320 )
				*/
				//else if(dflt_term_set_yn.equals("Y")&&!mode.equals("modify"))
				/*
					3/5/2009 IN008756 for defaulting practitioner and pract type

					Practitioner_type  Practitioner   Default Term-set
					     Y					Y			Y
						 N					Y			Y
						 Y					N			N
						 N					N			N
				*/
				else if(((default_pract_type.equals("Y") && default_pract.equals("Y")) || (default_pract_type.equals("N") && default_pract.equals("Y"))) && !mode.equals("modify"))
				{

					sel="selected";
					out.print("<option value='"+code+"'"+sel+" id='"+code1+"'>"+desc+"</option>");
					
					%>
					<script>
					/*
						This logic for the the DefaultTerSet selected.
					*/
					
					var code="<%=code%>";
					//setTimeout("getCodeSet()",500);  // commented for PE
					setTimeout('_getTableDefaultTermSet(\""+code+"\")',700);
					setTimeout("setTermCode1()",700)			

						</script>
					<%
					
					
					
				}
				else{

						out.print("<option value='"+code+"'"+sel+" id='"+code1+"'>"+desc+"</option>");

				}

			}
			if(rset	!= null)   rset.close();
			if(pstmt  != null)   pstmt.close();		
		
		%>
        </select><img  src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='label' width='20%' ></td>
	<td class='label' width='20%' ></td>
	<%
	if(call_from.equals("MAINTAIN_DEATH_REGISTER")){%>
		<td class='label' width='20%' ></td>
	<%}else{%>
		<td class='button' width='20%' align="right"><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Expand.label","mr_labels")%>' onClick="expandColapseframe('E')" name='expand' id='expand'></input><input type='button'  class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Collapse.label","common_labels")%>' onClick="expandColapseframe('C')" name='collapse'></input></td> 
	<%}%>
</tr>
<tr>
	<table border=0 cellspacing=0 cellpadding = 3 width='100%' style='<%=disimage%>' id='DiagTable'>
	<tr>
		<td class='label' width='12%' ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>
		<td class='fields' width='18%'><input type='textbox'  name='diagprob_code' id='diagprob_code' <%if(mode.equals("modify") || modal_yn.equals("Y"))%><%=mandatory_status%>  size='5' value='<%=term_code_dsply%>'  <%if(!mode.equals("modify")){%>  onblur= 'getDrugIntrValidation();callDesc(this);//getDescription();' <%}%> onchange='checkDiagProbDesc();'></td><!--getDrugIntrValidation() added by kamatchi s -->	<!-- onChange='clear_notify();' <%=term_code%> is removed from in modify mode becoz of it shows browse problem -->	
		<%

		%>
		
		<td class='fields' colspan='3'>

		<!--Added by Ashwini on 29-Jun-2018 for ML-MMOH-CRF-1187-->
		<%if(!isEnlargeDiagFldAppl){%>
		<input type="text"  name="diagprob_desc" id="diagprob_desc" value="<%=term_short_desc%>" size='50'  maxlength = '100'onblur='enableExternal1();checkMaxLimit(this);' onchange='checkDiagProbCode();' onKeyPress="return CheckForSpecChars_freetext(event);" disabled>
		<%}else{%>
		<textarea name="diagprob_desc" rows='3' cols='70' maxlength = '100' onblur='enableExternal1();checkMaxLimit(this);' onchange='checkDiagProbCode();' onKeyPress="return CheckForSpecChars_freetext(event);" disabled><%=term_short_desc%></textarea>
		<%}%>

		<input type='button' class='button' value='?' <%if(mode.equals("modify") ||modal_yn.equals("Y"))%><%=mandatory_disable%> onclick='show_window()' name = 'diagprob_button'><input type="hidden"  name = "Description" value=""><input class="button" type="button" value="!" name = "exclamation" id="exclamation" onclick = "javascript:showLongDescription();" style="visibility:hidden" ><img  src='../../eCommon/images/mandatory.gif'>
		<!--<input class="button" type="button" value="!" name = "exclamation" onclick = "javascript:showLongDescription();" style='' >-->
		<input type="hidden"  name = "LongDescription" value="">
		<input type="button" id='AddAssociateCodes' name="AddAssociateCodes" value = "+" onclick = "/*decider()*/addAssociateCodes1();" title="Supporting Diagnosis" class="button" <%=dis_add_associate%> >	
		<input type="button"  name="ntf_button" id="ntf_button"  value="+"   onClick="callNotifiableNotes('DiagnosisNote')" title="Record Notifiable Form" class='button' id='RecordNotifiableBtn' <%if(!notifiable_yn.equals("Y")){%> style='visibility:hidden' <%}%> >
		<!-- <img name='high_risk' src='../../eCA/images/MI_HighRisk.gif' style='visibility:hidden'> --><!-- Added for this BRU-HIMS-CRF-19.1-->
		<img id='high_risk' src='../../eCommon/images/PI_HighRisk.gif' style='visibility:hidden'><!-- Added for this BRU-HIMS-CRF-19.1-->
		<!--Below line added for this CRF GDOH-CRF-0082-->
		<span name="pmb_diagnosis" id="pmb_diagnosis" style="visibility:hidden;font-size:11px"></span>
		<!--End  GDOH-CRF-0082-->
		</td>
		<%
		if(!isMultiDescAppl)
		{ // if - else added by mujafar for ML-MMOH-CRF-1281
		%>
			<td class='label' width='10%'><b><font  size='1' color='blue'><a  id='manifest_anchor' href='javascript:;' onclick='manifestion()'></a></font></b></td>
		<td class='label' width='10%' align = 'left'><b><font  size='1' color='blue'><a href="javascript:;" onclick="viewLink();"  id='view_link' <%if(view_cnt==0){%>style="visibility:hidden"<%}else{%>style="visibility:visible"<%}%> ><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Link.label" bundle="${common_labels}"/></a></font></b></td>

		<%}
		else
		{
		%>
		
		<td class='label' width='10%' id='other_disp1' name='other_disp1' style ="<%=includevisibility%>" ><fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>s </td>
		<td class='fields' width='15%' id='other_disp2' name='other_disp2' style ="<%=includevisibility%>" >
		<select name='term_oth_desc' id='term_oth_desc' id='term_oth_desc' style='width:100' <%=def_disable%> >
		


		</select><img src= '../../eCommon/images/mandatory.gif'></img></td>

		<%
		}
		%>

	</tr>	

	<tr>		
		<!--<td class='label' width='13%' id='enc_stage_tab_id'  style=''><fmt:message key="eMR.DiagnosisStage.label" bundle="${mr_labels}" /></td>-->
		<td class='label' width='12%' id='enc_stage_tab_id'  style=''><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}" /></td>
		<td class='fields' width='18%' id='enc_stage_tab_id1'  style=''><select name='diag_stage' id='diag_stage'  <%=def_disable%>>

        <!--Below Added by Suji Keerthi for ML-MMOH-CRF-1605-->
		<% if(isPrepDisDefaultDischargeAppl && function_id.equals("PRE_DIS_ADVICE")) 
			{
               if(mode.equals("modify")) {
				   if(diagstagecode.equals("") || diagstagecode==null)
					   {
                           diastgSel_3 ="selected";
                        }
				   %>
						<option value="A" <%=diastgSel_1%>><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>	
						<option value="I" <%=diastgSel_2%>><fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/></option>	
						<option value="D" <%=diastgSel_3%>><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
				<%}else{ 
					   %>
						<option value="A" ><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>	
						<option value="I" ><fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/></option>	
						<option value="D" selected><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>	

			    <%} }
		
		   else { 
				
		%>
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<%	
			for(int ij=0;ij<enc_stg_list.size();ij+=2){
			
				String list_value="";
				String dflt_value_yn = "";
				String list_value1="";
				//String mode1 ="";
				list_value=checkForNull((String) enc_stg_list.get(ij));
				
				dflt_value_yn=checkForNull((String) enc_stg_list.get(ij+1));
				
				if(list_value.equals("ADMISSION"))
				{
					list_value="A";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");

				}
				if(list_value.equals("INTERMEDIATE"))
				{
					list_value="I";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
				}
				if(list_value.equals("DISCHARGE"))
				{
					list_value="D";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
				}


				if(!mode.equals("modify"))
				{
					
						if(dflt_value_yn.equals("Y"))
						{
							out.print("<option value='"+list_value+"' selected />"+list_value1 );

						}
						else
						{
							out.print("<option value='"+list_value+"'  />"+list_value1 );
						}
				}
				
			}
			//if(rset!=null) rset.close();

			String Admission = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
			String Intermediate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Intermediate.label","common_labels");
			String Discharge = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discharge.label","common_labels");
			
			if(mode.equals("modify"))
				{
						
						/*
						out.print("<option value='A' "+diastgSel_1+"  />Admission");
						out.print("<option value='I' "+diastgSel_2+"  />Intermediate");
						out.print("<option value='D' "+diastgSel_3+"  />Discharge");
						*/
						out.print("<option value='A' "+diastgSel_1+"  />"+Admission);
						out.print("<option value='I' "+diastgSel_2+"  />"+Intermediate);
						out.print("<option value='D' "+diastgSel_3+"  />"+Discharge);
						
						
				}
	} //End for else condition
		%>
		</select><img src= '../../eCommon/images/mandatory.gif' id='enc_stage_tab_img'></img></td>

		<td  class="label" width='20%' id='diag_classf_legend'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Classification.label" bundle="${common_labels}"/>
		</td>

		<td  class="fields" width='20%' >
			<select name="diag_classfication"  id='diag_classfication' <%=def_disable%> onChange="callDiagCateg(this);restirctPrimaryDiag(this);">
			   <OPTION value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			
			  
	</select><img src= '../../eCommon/images/mandatory.gif'  style='visibility:hidden' id='diag_class_img'></img>
	<span id="id_diag_class_type"></span>
	<!--Above line  Modified for this CRF AAKH-CRF-0012 [IN:037736] -->
	</td>

		<!--<td class='label' colspan='2' ></td> --> <!-- commented and below code added for ML-MMOH-CRF-1281 -->
		<%
		if(isMultiDescAppl) {
		%>
		<td class='label' width='10%'><b><font  size='1' color='blue'><a  id='manifest_anchor' href='javascript:;' onclick='manifestion()'></a></font></b></td>
		<td class='label' width='10%' align = 'left'><b><font  size='1' color='blue'><a href="javascript:;" onclick="viewLink();"  id='view_link' <%if(view_cnt==0){%>style="visibility:hidden"<%}else{%>style="visibility:visible"<%}%> ><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Link.label" bundle="${common_labels}"/></a></font></b></td>
		<% }else if(isCoderDiagAppl){
		%>
		<td class='label' width="3%"><fmt:message key="eMR.POA.label" bundle="${mr_labels}"/></td>
		<td class='fields' align = 'left' >
			<select name="poa_indicator" id="poa_indicator">
				<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<option value="Y" <%if("Y".equals(poa_indicator)){%>selected<%}%>>Y</option>
				<option value="N" <%if("N".equals(poa_indicator)){%>selected<%}%>>N</option>
				<option value="U" <%if("U".equals(poa_indicator)){%>selected<%}%>>U</option>
				<option value="W" <%if("W".equals(poa_indicator)){%>selected<%}%>>W</option>
				<option value="1" <%if("1".equals(poa_indicator)){%>selected<%}%>>1</option>
			</select>

		</td>
		<%}else{%>
			<td class='label' colspan='2' >
			</td>
		<%}%>


	</tr>
	
	<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
	<%if(isDeceasedDiagClassDeathRegAppl && !primary_diag_class.equals("") && !secondary_diag_class.equals("")){
		if(linked_yn.equals("Y")){
			if(diag_class_code.equals(primary_diag_class) && link_diag_pri_sec_yn.equals("Y")){
				linkcheckboxdisp = "inline";
			}
		}else{
			if(diag_class_code.equals(primary_diag_class)){
				linkcheckboxdisp = "inline";
			}
		}
	%>
		<tr id="linkcheckbox" style="display:<%=linkcheckboxdisp%>">
			<td colspan='2'>
			<td class='fields' width='20%' colspan='2' nowrap>
				<input type='checkbox' name='link_diag_pri_sec_yn' id='link_diag_pri_sec_yn' value='<%=link_diag_pri_sec_yn%>' <%=checklinkprisec%> onClick="linkDiagCodeToPriSecDiagClass(this);">
				<b><fmt:message key="eMR.LinkDiagCodeToPriSecDiagClass.label" bundle="${mr_labels}"/></b>
			</td>
		</tr>
	<%}%>
	<!--End ML-MMOH-CRF-1742-->

		<%//if(isDiagCatgMand && isPatClsForDiagCat){
			if(isDiagCatgMand) {
			%>
		<tr>
		<td class='label' colspan='2'>
			</td>
			<td  class="label" width='20%'><fmt:message key="eMR.DiagnosisCategory.label" bundle="${mr_labels}"/>
			</td>
			<td  class="fields" width='20%'>
			<select name="diag_category" id="diag_category" id = "diag_category1"   >
					<OPTION value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>					
					<%
if(mode.equals("modify")){
	String diagCatSql = "select diag_catg_code, short_desc, eff_status from mr_diag_category where eff_status = 'E' order by DIAG_CATG_CODE";
					pstmt = con.prepareStatement(diagCatSql);
					rset = pstmt.executeQuery();
					while(rset.next()){
						if(diag_catg_code.equals(rset.getString("diag_catg_code"))){
						out.println("<OPTION value = '"+rset.getString("diag_catg_code")+"' selected>"+rset.getString("short_desc")+"</OPION>");
						}else{
							out.println("<OPTION value = '"+rset.getString("diag_catg_code")+"'>"+rset.getString("short_desc")+"</OPION>");
						}
					}
}else{ 					
					String diagCatSql = "select diag_catg_code, short_desc, eff_status from mr_diag_category where eff_status = 'E' order by DIAG_CATG_CODE";
					pstmt = con.prepareStatement(diagCatSql);
					rset = pstmt.executeQuery();
					while(rset.next()){
						out.println("<OPTION value = '"+rset.getString("diag_catg_code")+"'>"+rset.getString("short_desc")+"</OPION>");
					}
}			


					%>
					
					
</select><img src= '../../eCommon/images/mandatory.gif' style='visibility:<%=DiagCatgImgHdn%>' id='diag_catg_img'></img>	
 
			</td>
			<td class='label' colspan='2' >
		 
			</td>
		</tr>
 
		
	<%}%>
	<tr>
		<td colspan=6>
		<table border=0 cellpadding='3' cellspacing='0' width="100%" >
		<tr> 
		<td class = 'label' width='12%'><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></td>
		<td class='fields' width='18%'><textarea type='textarea' name='complaint_desc' value='' readonly ><%=_complaint_Desc%></textarea><input type='hidden' name='complaint_id' id='complaint_id' value='<%=_complaint_id%>'></input><input type='button' name='ComplaintSrch' id='ComplaintSrch' value='?'  OnClick='selectProblem();' class='button' <%=def_disable%> <% if(!mode.equals("modify")){%>disabled<%}%> ></input>
		<!-- Added by jeyachitra for ML-MMOH-CRF 1742 -->
		<input type='hidden' name='aud_complaint_desc' id='aud_complaint_desc' value = '<%=_complaint_Desc%>'/>
		</td>
		<!--//Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013-->

		<!--Added by Sangeetha on 20th Feb 2017 for ML-MMOH-CRF-0547-->
			<% 
			Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TYPES_OF_NOTIFICATION_FORM"); //Added by Sangeetha for ML-MMOH-CRF-0547
			Boolean notifiableLegndChgApplYn =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","NOTIFIABLE_LEGEND_CHG"); //Added by Dharma
			%>			
			<td  class="label" width='20%' >
			<%if(legendChangeAsTypesOfNotiForm){ %>
				<fmt:message key="eMR.TypesofNotification.label" bundle="${mr_labels}"/> 
			<% }else if(notifiableLegndChgApplYn){ %>
				<fmt:message key="eMR.Notifiable.label" bundle="${mr_labels}"/><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
			<%}else{%>	
				<fmt:message key="eMR.WorkRelated.label" bundle="${mr_labels}"/>
			 <% } %>
		   </td>
		   <input type="hidden" name="legendChangeAsTypesOfNotiForm" id="legendChangeAsTypesOfNotiForm" value="<%=legendChangeAsTypesOfNotiForm%>"> 
		   <input type="hidden" name="notifiableLegndChgApplYn" id="notifiableLegndChgApplYn" value="<%=notifiableLegndChgApplYn%>"> 
		<td  class="fields" width='20%' >
			<select name="notification_setup" id="notification_setup" onchange='EnableNotifySetup()' <%=dis_work_related_notifiable%> >
			 <OPTION value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			<%try
				{
			//	String notify_sql="SELECT NOTIFICATION_CODE,SHORT_DESC,EMAIL_APPLICABLE FROM MR_NOTIFICATION_SETUP WHERE EFF_STATUS='E'";
			    String notify_sql="SELECT NOTIFICATION_CODE,SHORT_DESC,EMAIL_APPLICABLE,DEFAULT_NOTE_TYPE FROM MR_NOTIFICATION_SETUP WHERE EFF_STATUS='E'"; //senthil modified
				pstmt = con.prepareStatement(notify_sql);
				rset=pstmt.executeQuery();
				while(rset.next())
					{
					String notify_code=rset.getString("NOTIFICATION_CODE");
					String notify_desc=rset.getString("SHORT_DESC");
					email_yn=rset.getString("EMAIL_APPLICABLE");
					default_note_type=rset.getString("DEFAULT_NOTE_TYPE")==null?"":rset.getString("DEFAULT_NOTE_TYPE");					
					if(notifiable_code.equals(notify_code))
						{
						email_sel_yn=email_yn;
						deflt_note_type=default_note_type; //Added Senthil
						out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"' selected>"+notify_desc+"</option>");
						}
					else{	
					out.println("<option value='"+notify_code+"&"+email_yn+"&"+default_note_type+"'>"+notify_desc+"</option>");	
					}
					}
				if(pstmt!=null) pstmt.close();
				if(rset	!= null)   rset.close();
				}
			catch(Exception e)
				{
				e.printStackTrace();
				}%>
			  
		</select>
		<input type="button"  name="Addnotification" id="Addnotification"  value="+"   onClick="GetSerialNumber();callNotifiableNotes('NotifiableNote')" title="Record Notifiable Form" class='button' id='AddnotificationBtn'  <%=notifiable_code_style%> >
		&nbsp;&nbsp;<img src= '../../eCommon/images/mandatory.gif' style='visibility:hidden' id='notifi_frm_mand_gif'></td>
		<!--Added for this CRF Bru-HIMS-CRF-024.2 -->
		<!--End-->
		<td  class="label" width='20%' ></td>
		</td></table>
		</tr>

	<tr>
	<td colspan=6>
	<table border=0 cellpadding='3' cellspacing='0' width="100%" id='Diag_yn_tab'>
	<tr> 
		<td class="label" width='12%' id='nature_tab_id' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
		<td  id='nature_tab_id1' width='18%' class='fields'><select name='nature' id='nature' <%=def_disable%>>><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<%
			//String sql1	="select list_value,dflt_value_yn from  mr_term_set_crit_for_pc where  patient_class='"+patient_class+"' and criteria='NATURE'";

			
			//rset = stmt.executeQuery(sql1);
			//while(rset.next()){	
				
			for(int ij=0;ij<nat_list.size();ij+=2){
			
				String list_value="";
				String dflt_value_yn = "";
				String list_value1="";
				//String mode1 ="";
				list_value=checkForNull((String) nat_list.get(ij));
				dflt_value_yn=checkForNull((String) nat_list.get(ij+1));
			

				
				if(list_value.equals("ACTUAL"))
				{
					list_value="A";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
				}
				if(list_value.equals("WELLNESS"))
				{
					list_value="W";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
				}
				if(list_value.equals("POTENTIAL"))
				{
					list_value="P";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
				}


				if(!mode.equals("modify"))
				{
					
						if(dflt_value_yn.equals("Y"))
						{
							out.print("<option value='"+list_value+"' selected />"+list_value1 );

						}
						else
						{
							out.print("<option value='"+list_value+"'  />"+list_value1 );
						}
				}
				
			}
					
			//if(rset!=null) rset.close();

			String Actual = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Actual.label","common_labels");
			String Wellness = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wellness.label","common_labels");
			String Potential = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Potential.label","common_labels");
			if(mode.equals("modify"))
				{
						/*
						out.print("<option value='A' "+Aselect+"  />Actual" );
						out.print("<option value='W' "+Wselect+"  />Wellness" );
						out.print("<option value='P' "+Pselect+"  />Potential" );
						*/
						out.print("<option value='A' "+Aselect+"  />"+Actual );
						out.print("<option value='W' "+Wselect+"  />"+Wellness );
						out.print("<option value='P' "+Pselect+"  />"+Potential );

						
				}
			%>
		</select><img   id='nature_img' src='../../eCommon/images/mandatory.gif'></td>


		<td  class="label" width='20%' ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
		
		<td class='fields' width='20%'><select name="accuracy" id="accuracy" onChange='getAccuracy_code();show_diff_link(this);setStatus();' <%=def_disable%>><option value='' >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			

			String sql3	="select a.accuracy_code||'='||a.accuracy_indicator accuracy_code1, a.accuracy_code, a.short_desc,b.DFLT_VALUE_YN from MR_ACCURACY_LANG_VW a , mr_term_set_crit_for_pc b where a.language_id=? and a.eff_status='E' AND a.accuracy_code=b.accuracy_code and b.patient_class=? and b.criteria='ACCURACY' order by a.short_desc";

				stmt=con.prepareStatement(sql3);
				stmt.setString(1,locale);
				stmt.setString(2,patient_class);
				rset = stmt.executeQuery();
			
			while(rset.next())
			{	
				
				String accr_desc = checkForNull(rset.getString("short_desc"));
				String accr_code = checkForNull(rset.getString("accuracy_code1"));
				codes = checkForNull(rset.getString("accuracy_code"));
				String dflt_value_yn=checkForNull(rset.getString("dflt_value_yn"));


				if(accuracy_code.equals(codes))
				{
					out.print("<option value='"+accr_code+"' selected />"+accr_desc );
					if(accr_desc.equals("Provisional")){
							style_def = "[ Differential Group ]";
					}
				}
				else
				{
					style_def = "";
					if(!mode.equals("modify"))
					{
						if(dflt_value_yn.equals("Y"))
							out.print("<option value='"+accr_code+"' selected />"+accr_desc );
						else
							out.print("<option value='"+accr_code+"'/>"+accr_desc );	
					}
					else
						out.print("<option value='"+accr_code+"'/>"+accr_desc );	
						
					
				}
			
			}
			if(rset!=null) rset.close();




		%>
		</select><img  src='../../eCommon/images/mandatory.gif'></td>
		<td class='label'  width='20%' style='' ><b><font  size='1' color='blue'><a href="javascript:;" onclick="diffGroup(document.forms[0].code_set.value)"   id='differential_anchor'><%=style_def%></a></font></b></td>
		
	</tr>
	<tr id='ser_pri_row'>	
		<td class='label' id='severity_tab_id' style=''  width='12%'><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
		<td  id='severity_tab_id1' class='fields' width='18%'><select name="severity" id="severity" <%=def_disable%> >
		<%if(!mode.equals("modify")){%>
		 <option value='D' ><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
		<%}else{%>
			<option value='D' <%=sevr_D_select%> <%=def_select%> ><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
			<%}%>
			<option value='L' <%=sevr_L_select%>><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
            <option value='S' <%=sevr_S_select%>><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
			<option value='E' <%=sevr_E_select%>><fmt:message key="eMR.Extreme.label" bundle="${mr_labels}"/></option>
		</select><img id='sevrity_img' src='../../eCommon/images/mandatory.gif'></td>  
		<td class='label'   id='priority_tab_id' style=''  width='20%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td id='priority_tab_id1' width='20%' class='fields'><select name="priority" id="priority" <%=def_disable%>><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
						<%
				//String sql2	="select list_value,dflt_value_yn from  mr_term_set_crit_for_pc where  patient_class='"+patient_class+"' and criteria='PRIORITY'";

				//rset = stmt.executeQuery(sql2);

			//while(rset.next()){	

			for(int ij=0;ij<prio_list.size();ij+=2){
			
				String list_value="";
				String dflt_value_yn = "";
				String list_value1="";
				//String mode1 ="";
				list_value=checkForNull((String) prio_list.get(ij));
				dflt_value_yn=checkForNull((String) prio_list.get(ij+1));
			

				
					
				if(list_value.equals("NORMAL"))
				{
					list_value="N";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels");
				}
				if(list_value.equals("HIGH"))
				{
					list_value="H";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels");
				}
				if(list_value.equals("CRITICAL"))
				{
					list_value="C";
					list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
				}


				if(!mode.equals("modify"))
				{
					
						if(dflt_value_yn.equals("Y"))
						{
							out.print("<option value='"+list_value+"' selected />"+list_value1 );

						}
						else
						{
							out.print("<option value='"+list_value+"'  />"+list_value1 );
						}
				}
				
			}
			//if(rset!=null) rset.close();

			String Normal = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels"); 
			String High = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels"); 
			String Critical = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels"); 
			
			if(mode.equals("modify"))
				{
						/*
						out.print("<option value='N' "+pri_N_select+"  />Normal");
						out.print("<option value='H' "+pri_H_select+"  />High");
						out.print("<option value='C' "+pri_C_select+"  />Critical" );
						*/
						out.print("<option value='N' "+pri_N_select+"  />"+Normal);
						out.print("<option value='H' "+pri_H_select+"  />"+High);
						out.print("<option value='C' "+pri_C_select+"  />"+Critical);

						
				}
			%>
		</select><img id='priority_img' src='../../eCommon/images/mandatory.gif'></td>
		<td class='label' style='' width='20%' ><b><font size='1' color='blue'><a href="javascript:;" onclick="evidencedby1()" id='evidence_anchor'></a></b></font></td>
	</tr>
	</table> 
	</td>
   </tr>
<tr>
<td colspan=6>
<table border=0 cellpadding='3' cellspacing='0' width="100%" >
	<tr> 
		<td class='label' width='12%' id="onset_type_tabid" style='visibility:visible'><fmt:message key="eMR.OnsetType.label" bundle="${mr_labels}"/></td>
		<td width='18%' id="onset_type_tabid1" class='fields'><select name="type" id="type" <%=def_disable%> ><option value='N' <%=type_N_select%> ><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option><option value='A' <%=type_A_select%> ><fmt:message key="eMR.Acute.label" bundle="${mr_labels}"/></option><option  value='C' <%=type_C_select%> ><fmt:message key="eMR.Chronic.label" bundle="${mr_labels}"/></option></select><!-- <img id='' src='../../eCommon/images/mandatory.gif' id='onset_type_img'> -->
		<input type="hidden"  name="old_onset_type" id="old_onset_type"			value="<%=onset_type%>">
		</td> 
		<td width='20%' class='label' ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td><input type='hidden' name='currentdateTime' id='currentdateTime' value='<%=onset_date_converted%>'></td>
		<td width='20%' class='fields'><input type='text' name='onset_date' id='onset_date' <%=date_status%> <%=def_status%> value='<%=onset_date_converted%>' id='date1' size='18' maxlength='18' Onblur='if(validDateObj(this,"DMYHM","<%=localeName%>")){DateChk(currentdateTime,this);}'><img src="../../eCommon/images/CommonCalendar.gif" <% if(mode.equals("modify"))%><%=mandatory_disable%> onclick="document.forms[0].onset_date.focus();return showCalendar('date1',null,'hh:mm');"/><img src='../../eCommon/images/mandatory.gif'><input type='hidden' name='ServerDate' id='ServerDate' value='<%=onset_date%>'></td>
		<%if(!mode.equals("modify")){%>
		<td class="label" width='20%'><fmt:message key="Common.since.label" bundle="${common_labels}"/><input type="text" name="b_days" id="b_days" <%=date_status%> <%=def_status%> maxlength="2" size="2" value=''  tabIndex='4'  onBlur='CheckForNumber_L(this,onset_date);checkDays(this,onset_date);gotoNext(this)' onKeyPress='return(ChkNumberInput(this,event,0));' >D<input type="text" name="b_months" id="b_months" <%=date_status%> <%=def_status%> maxlength="2" value='' size="2" onKeyPress='return(ChkNumberInput(this,event,0));'  onBlur='CheckForNumber_L(this,onset_date);checkMonth(this,onset_date);gotoNext(this)'   tabIndex='5' >M<input type="text" name="b_age" id="b_age" <%=date_status%> <%=def_status%> maxlength="3" size="3" value=''    onBlur='CheckForNumber_L(this,onset_date);gotoNext(this)' onKeyPress='return(ChkNumberInput(this,event,0));'  tabIndex='6'>Y</td>
		<%}else{%>
		<td class="label" width='20%'>
		<%}%>
	</tr>
</table> 
</td>
</tr>
<tr>
<td colspan=6>
<table border=0 cellpadding='3' cellspacing='0' width="100%">
	<tr> <!--//Maheshwaran K Modified for the SKR-CRF-0020 as on 17/07/2013*/-->
		<td class="label" width='12%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td width='18%' class='fields'><select name="status" id="status" onchange="Image_Enable(this)" <%=def_disable%> <%if(!mode.equals("modify")){%> disabled <%}%> >
			<option value='A' <%=stus_A_select%>><fmt:message key="Common.active.label" bundle="${common_labels}"/></option>
            <option value='R' <%=stus_R_select%>><fmt:message key="Common.Resolved.label" bundle="${common_labels}"/></option>
			<option value='X' <%=stus_X_select%>><fmt:message key="Common.Revoked.label" bundle="${common_labels}"/></option>
			<option value='E' <%=stus_E_select%>><fmt:message key="Common.InError.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class='label' width='20%' ><fmt:message key="Common.Ason.label" bundle="${common_labels}"/></td>
		<td width='20%' class='fields'><input type='text' name='status_date' id='status_date' id='date2' <%=def_status%> <%=date_status%> value='<%=status_date_converted%>' size='10' maxlength='10'  Onblur='if(validDateObj(this,"DMY","<%=localeName%>")) { validate_date1(document.forms[0].onset_date,status_date,currentdate);}' ><img src="../../eCommon/images/CommonCalendar.gif" <%=def_disable%> onclick="document.forms[0].status_date.focus();return showCalendar('date2');"/><img   src='../../eCommon/images/mandatory.gif'></td>
		<td class='label' width='20%'>
			<%if((mode.equals("modify") && isCurrentEncounter.equals("Y")) || (!mode.equals("modify"))){%>
					<fmt:message key="Common.IncludeinCurrentEncounter.label" bundle="${common_labels}"/>
			<%}else{%><%}%>
			<%if((mode.equals("modify") && isCurrentEncounter.equals("Y")) || (!mode.equals("modify"))){%>
					<input type='checkbox' checked 
					<%if(isCurrentEncounter.equals("Y")){}else{%>disabled<%}%> 
					name='inc_encounter' id='inc_encounter' onClick="check_enc();">
			<%}else{%><%}%>
		</td>
	</tr>


</table> 
</td>
</tr>

</table>
</tr>
<!--modified on 08-may 2008 to add Anatomical site & Applicable Side-->
<td colspan=8>
<table border=0 cellpadding='3' cellspacing='0' width="100%" id='AnatomicalSiteTable'>
	<tr>
		<%if(is_oh_install.equals("Y")){%>
		<td class='label' width='16%' ><fmt:message key="Common.AnatomicalSite.label" bundle="${common_labels}"/></td>
		<td width='18%' class='fields'><select name="anatomical_site" id="anatomical_site" onchange='show_diag_link(this);' 
		<%if (mode.equals("modify")){%>disabled<%}%> >
			<option value='' <%=anatomy_select_default%>>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='C' <%=anatomy_select_c%>><fmt:message key="eMR.OralCavity.label" bundle="${mr_labels}"/></option>
            <option  value='O' <%=anatomy_select_o%>><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>
            </select>
		</td>
		<td width='18%' class='fields' id = 'oral_sites' <%--if(!anatomical_site.equals("C") && anatomical_site.equals("O")){--%> style="visibility:hidden" <%--}--%>>
			<select id="anatomical_oral_sites" name = 'anatomical_oral_sites' <%if (mode.equals("modify")){%>disabled<%}%>>
<%
			if(!mode.equals("modify"))
			{
%>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
<%
			}else{
				if(_anatomical_site_code.equals("")){
				%>
				<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>

				<%
				}
				else
				{

					out.print("<option value='"+_anatomical_site_code+"' selected/>"+_anatomical_short_desc );
				}
			}

%>
			</select>
		</td>
		
			<%}else{%>
		<td class='label' width='12%' ></td>
		<td width='18%' class='fields'></td>
		<%}%>
		<%if(option_id.equals("OH_REST_CHART_REC")){ %>
		<td class='label'  width='' style='' ><b><font  size='1' color='blue'><a href="javascript:;" onclick="linkdiagnosis();"   id='link_diagnosis'><%if(!anatomical_site.equals("O") && anatomical_site.equals("C"))%><fmt:message key="eOH.LinkCondition.Label" bundle="${oh_labels}"/></a></font></b></td>
		
		<%}else{%>
		<td class='label'></td>
		<%}%>
		<%if(is_oh_install.equals("Y")){%>
		<td class='label' width='20%' <%if(option_id.equals("OH_REST_CHART_REC") && ! anatomical_site.equals("O")){%>style='visibility:hidden' <%}else if(anatomical_site.equals("C")){%>style='visibility:hidden'<%}else if(anatomical_site.equals("0")){%>style='visibility:visible'<%}else if(anatomical_site.equals("")){%>style='visibility:hidden'<%}%> id='app_label'><fmt:message key="eMR.ApplicableSide.label" bundle="${mr_labels}"/></td>
		<td width='20%' class='fields' <%if(option_id.equals("OH_REST_CHART_REC") && ! anatomical_site.equals("O")){%>style='visibility:hidden' <%}else if(anatomical_site.equals("C")){%>style='visibility:hidden'<%}else if(anatomical_site.equals("0")){%>style=''<%}else if(anatomical_site.equals("")){%>style='visibility:hidden'<%}%>  id='app_select'><select name="applicable_side" id="applicable_side"  <%if(mode.equals("modify")){%>disabled<%}%>><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
			<option value='L' <%=applicable_l%>><fmt:message key="Common.Left.label" bundle="${common_labels}"/></option>
            <option  value='R' <%=applicable_r%>><fmt:message key="Common.Right.label" bundle="${common_labels}"/></option>
			<option value='B' <%=applicable_b%>><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
			<option value='N' <%=applicable_n%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
            </select>
		</td>
		<%}else{%>
		<td class='label' width='12%' ></td>
		<td width='18%' class='fields'></td>
		<%}%>
	</tr>
	
	<!---->
	<!---->

<!--Modified by Himanshu Saxena for ML-MMOH-CRF-1986.1 (UserStory 2) on 25-04-2023 Started--><!-- added onkeypress="return CheckForSpecChars_onlyfive(event);"-->
		<tr>	
		<td class='label' ><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/></td> <!-- modified by mujafar for ML-MMOH-CRF-1270 -->
		<td colspan='4' class='fields'><textarea name="remarks" <%=def_status%> rows="2" cols="80" maxlength='2000'   onBlur="makeValidString(this);checkMaxLimitOfRemark(this);" onkeypress="return CheckForSpecChars_onlyfive(event);" onpaste="return checkspecialandalphanumeric(event);"><%=remarks%></textarea><img  id='remk_image' src='../../eCommon/images/mandatory.gif' style='visibility:hidden' ></img></td>
		<td class='label' ></td>
	</tr>
	</td></table>
	<!---->
</table>

<%	if(scheme.equals("1") ||  scheme.equals("2"))
    {	%>
		<input type="hidden"  name="analysis_code" id="analysis_code"      value="">
		<input type="hidden"  name="cause_indicator" id="cause_indicator"    value="">
		<input type="hidden"  name="diag_code" id="diag_code"			value="<%=diag_code%>">
		<input type="hidden"  name="primary_yn" id="primary_yn"         value="<%=check_box_value%>" >
		<input type="hidden"  name="retVal_auth" id="retVal_auth"		value="<%=retVal_auth%>">
		<input type="hidden"  name="sensitive_yn" id="sensitive_yn"       value="">
		<input type="hidden"  name="significant_yn" id="significant_yn"     value="<%=significant_yn%>" >
		<input type="hidden"  name="srl_no_from_table" id="srl_no_from_table"  value="<%=srl_no_from_table%>" >
		<input type="hidden"  name="tab_list_no" id="tab_list_no"        value="">
		<input type="hidden"  name="term_id" id="term_id"            value="">
<%	}
    else
	{	%>
		<input type="hidden"  name="analysis_code" id="analysis_code"      value="">
		<input type="hidden"  name="cause_indicator" id="cause_indicator"    value="">
		<input type="hidden"  name="diag_code" id="diag_code"			value="<%=diag_code%>">
		<input type="hidden"  name="primary_yn" id="primary_yn"         value="<%=check_box_value%>" >
		<input type="hidden"  name="retVal_auth" id="retVal_auth"		value="<%=retVal_auth%>">
		<input type="hidden"  name="sensitive_yn" id="sensitive_yn"       value="N">
		<input type="hidden"  name="significant_yn" id="significant_yn"     value="<%=check_box_value%>" >
		<input type="hidden"  name="srl_no_from_table" id="srl_no_from_table"  value="<%=srl_no_from_table%>" >
		<input type="hidden"  name="tab_list_no" id="tab_list_no"        value="">
		<input type="hidden"  name="term_id" id="term_id"            value="">
<%	}	%>
    

<!--//Maheshwaran K added for the Incident No :43698(related to SKR-CRF-0020 -29795) as on 24/09/2013-->
<input type="hidden" name = "curr_encounter_id" value ="<%=curr_encounter_id%>">
<input type="hidden" name = "Encounter_Id" value ="<%=Encounter_Id%>">
<input type="hidden" name = "Locn_Code" value ="<%=Locn_Code%>">
<input type="hidden" name = "Locn_Type" value ="<%=Locn_Type%>">
<input type="hidden" name = "Patient_Id" value ="<%=Patient_Id%>">
<input type="hidden" name = "Practitioner_Id" value ="<%=Practitioner_Id%>">
<input type="hidden" name = "accry_code" value ="">
<input type="hidden" name = "accry_code_ind" value ="">
<input type="hidden" name = "as_evidenced_by_hid" value ="">
<input type="hidden" name = "currentdate" value ="<%=currentdate%>">
<input type="hidden" name = "dateTime" value ="<%=onset_date_converted%>">
<input type="hidden" name = "relationship_id" value ="<%=relationship_id%>">
<input type='hidden' name = 'episode_type' value='<%=episode_type%>'>
<input type='hidden' name = 'visit_adm_date' value='<%=visit_adm_date%>'>
<input type='hidden' name = 'ext_mand_for_consq' value='<%=ext_mand_for_consq%>'>
<input type='hidden' name = 'astk_mand_for_dagg' value='<%=astk_mand_for_dagg%>'>
<!--Below line Added for this CRF AAKH-CRF-0012 [IN:037736] -->
<input type='hidden' name = 'diag_class_mand_yn' value='<%=diag_class_mand_yn%>'>

<input type='hidden' name = 'isMultiDescAppl' id = 'isMultiDescAppl' value='<%=isMultiDescAppl%>'>   <!-- added by mujafar for ML-MMOH-CRF-1281 -->
<input type='hidden' name = 'term_sht_desc' id = 'term_sht_desc' value="<%=java.net.URLEncoder.encode(term_sht_desc)%>"> 


<!-- Params for Code Set up...Get papulate from Script file. -->
<input type="hidden" name = "term_set_id" value ="">
<input type="hidden" name = "priority_appl_yn" value ="">
<input type="hidden" name = "nature_appl_yn" value ="">
<input type="hidden" name = "severity_appl_yn" value ="">
<input type="hidden" name = "onset_type_appl_yn" value ="">
<input type="hidden" name = "factors_appl_yn" value ="">
<input type="hidden" name = "notification_appl_yn" value ="">
<input type="hidden" name = "notifiable_yn" value ="<%=notifiable_yn%>">
<input type="hidden" name = "enc_stage_appl_yn" value ="">
<!-- Added by KAMATCHI S for ML-MMOH-CRF-1581 START-->
<input type='hidden' name= "inpatient_appl_yn" value="">
<input type='hidden' name= "daycare_appl_yn" value="">
<!-- Added by KAMATCHI S for ML-MMOH-CRF-1581 END -->
<!-- hidden fields for search -->
<input type="hidden" name ="speciality_code" id ="speciality_code" value ="<%=speciality_code%>">
<input type="hidden" name ="practitioner_type" id ="practitioner_type" value ="<%=practitioner_type%>">
<input type="hidden" name ="dob" id ="dob" value ="<%=dob%>">
<input type="hidden" name ="age" id ="age" value ="<%=age%>">
<input type="hidden" name ="sex" id ="sex" value ="<%=sex%>">
<input type="hidden" name ="facilityId" id="facilityId" value ="<%=facility_id%>">
<input type="hidden" name ="mode" id="mode" value ="<%=mode%>">
<input type='hidden' name='scheme_desc' id='scheme_desc' value='<%=scheme_desc%>'>
<input type="hidden" name="scheme" id="scheme" value="<%=scheme%>">
<input type="hidden" name ="modal_yn" id="modal_yn"  value ="<%=modal_yn%>">
<input type='hidden' name='text5' id='text5' value=''>
<input type='hidden' name='text6' id='text6' value=''>
<input type='hidden' name='onset_date_temp' id='onset_date_temp' value='<%=onset_date%>'>	
<input type='hidden' name='status_date_temp' id='status_date_temp' value='<%=status_date_converted%>'>
<input type='hidden' name='patient_class' id='patient_class' value='<%=patient_class%>'>


<input type='hidden' name='isEncounterStage' id='isEncounterStage' value='<%=isEncounterStage%>'><!-- Added by KAMATCHI S for ML-MMOH-CRF-1581 END -->

<input type='hidden' name='status_srl_no' id='status_srl_no' value='<%=srl_no%>'>
<input type='hidden' name='onset_date1' id='onset_date1' value='<%=onset_date%>'>
<input type='hidden' name='current_date' id='current_date' value='<%=currentdate%>'>
<input type='hidden' name='current_time' id='current_time' value='<%=currentTime%>'>
<input type='hidden' name='called_from_ip' id='called_from_ip' value='<%=called_from_ip%>'>
<input type="hidden"  name="f_authorize_yn" id="f_authorize_yn"  value="<%=f_authorize_yn%>">

<!--  hidden fields requeried to populate external diag -->
<!--Below line modified for this CRF GDOH-CRF-0082-->
<input type='hidden' name='associate_codes' id='associate_codes' value="<%=associate_codes%>">
<input type='hidden' name='associate_codes_modify' id='associate_codes_modify' value="<%=associate_codes%>">
<input type='hidden' name='code_indicator' id='code_indicator' <%if(mode.equals("modify")){ %>value='<%=code_ind%>'<%} else{%> value='' <%}%>>
<input type='hidden' name='diff_group_id_hid' id='diff_group_id_hid' value='<%=diff_group_id%>'>
<input type='hidden' name='occur_srl_no_hid' id='occur_srl_no_hid' value='<%=occur_srl_no%>'>
<%if(!call_from.equals("MAINTAIN_DEATH_REGISTER")){%>
	<input type='hidden' name='expandcollapse' id='expandcollapse' value='C'></input>
<%}%>
<input type='hidden' name='high_risk_code' id='high_risk_code' value='<%=high_risk_code%>'></input>
<input type='hidden' name='curr_encr_flag' id='curr_encr_flag' value=''></input>
<input type='hidden' name='diff_group_vals' id='diff_group_vals' value=''></input>
<input type='hidden' name='expandFlag' id='expandFlag' value='N'></input>
<input type='hidden' name='isCalledFromCA' id='isCalledFromCA' value='<%=isCalledFromCA%>'></input>
<input type='hidden' name='old_encounter_id' id='old_encounter_id' value='<%=old_encounter_id%>'></input>
<input type='hidden' name='onset_encounter_id' id='onset_encounter_id' value='<%=onset_encounter_id%>'></input>
<input type='hidden' name='accession_number' id='accession_number' value='<%=accession_number%>'></input>
<input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'></input>
<input type='hidden' name='oh_chart_num' id='oh_chart_num' value='<%=oh_chart_num%>'></input>
<input type='hidden' name='diagcode' id='diagcode' value='<%=diagcode%>'></input>
<input type='hidden' name='diag_class' id='diag_class' value='<%=diag_class%>'></input>
<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>
<input type='hidden' name='totalRecords' id='totalRecords' value='<%=totalRecords%>'>
<input type='hidden' name='diag_class_code' id='diag_class_code' value='<%=diag_class_code%>'>
<!-- Added On 2/22/2010 for SRR-CRF-303.2[IN015597] -->
<input type='hidden' name='dagger_independent_yn' id='dagger_independent_yn' value='<%=dagger_independent_yn%>'>
<input type='hidden' name='recode_curr_level' id='recode_curr_level' value='<%=recode_curr_level%>'>
<input type='hidden' name='diag_class_type' id='diag_class_type' value=''>
<!-- Added On 12/6/2010 for SRR20056-SCF-5914 [IN:024929] -->
<input type='hidden' name='isCurrentEncounter' id='isCurrentEncounter' value='<%=isCurrentEncounter%>'>
<input type='hidden' name='diag_enc_level' id='diag_enc_level' value='<%=diag_enc_level%>'>
<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'> <!-- CHL-CRF- 0008 - IN:001472 -->

<!--Added below hidden field for this CRF  [PMG2012-CRF-0030]-->
<input type='hidden' name='called_from_ot' id='called_from_ot' value='<%=called_from_ot%>'> 

<!-- Hidden field for the reporting charting(OHT) -->

<input type='hidden' name='_restoreChart' id='_restoreChart' value='<%=restorative_Chart%>'></input>
<input type='hidden' name='is_oh_install' id='is_oh_install' value='<%=is_oh_install%>'></input>
<input type='hidden' name='email_yn' id='email_yn' value='<%=email_sel_yn%>'></input>
<input type='hidden' name='diagnosis_by_long_desc_yn' id='diagnosis_by_long_desc_yn' value='<%=diagnosis_by_long_desc_yn%>'></input><!--//Maheshwaran K added for HSA-CRF-0234-->
<input type='hidden' name='notifiable_code' id='notifiable_code' value='<%=notifiable_code%>'></input><!--Maheshwaran K added for the Bru-HIMS-CRF-024.1 [IN:042219] as on 20/11/2013-->

<input type='hidden' name='deft_note_type' id='deft_note_type' value="<%=deflt_note_type%>"/><!--Added Senthil-->
<!--Added for this CRF Bru-HIMS-CRF-024.2-->
<input type='hidden' name='notifiable_form_mand_yn' id='notifiable_form_mand_yn' value="<%=notifiable_form_mand_yn%>"/> 
<input type='hidden' name='notifiable_note_form' id='notifiable_note_form' value="<%=accession_num_work_related%>"/> 
<input type='hidden' name='accession_num_notifiable' id='accession_num_notifiable' value="<%=accession_num_notifiable%>"/> 
<input type='hidden' name='srl_no_control' id='srl_no_control' value=""/> 
<!--Added for this CRF GDOH-CRF-0082-->
<input type="hidden" name="diagnosisPmb" id="diagnosisPmb" value="<%=diagnosisPmb%>"/> 
<input type="hidden" name="pmbsupportdiag" id="pmbsupportdiag" value="<%=support_diag_code%>"/>
<input type="hidden" name="totsupportdiagCount" id="totsupportdiagCount" value="<%=supportdiagCount%>"/>  
<!-- End Added for this CRF GDOH-CRF-0082-->

<!--Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645-->
<input type='hidden' name='termCodeEffStatus' id='termCodeEffStatus' value='<%=termCodeEffStatus%>'></input>

<!--Added by Ashwini on 21-Sep-2022 for ML-MMOH-SCF-1818-->
<input type='hidden' name='slink_flag' id='slink_flag' value=''></input>

<!-- Below Added by Suji Keerthi for ML-MMOH-CRF-1395 US002-->
<input type='hidden' name= "diagnosis_class_mand_yn" value=""></input>
<input type='hidden' name='isDiagClassMand' id='isDiagClassMand' value='<%=isDiagClassMand%>'></input>
<!-- Ended by Suji Keerthi for ML-MMOH-CRF-1395 US002-->
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'></input>
<input type='hidden' name='restrict_sec_diag_yn' id='restrict_sec_diag_yn' value='<%=restrict_sec_diag_yn%>'></input>

<input type='hidden' name='isPrepDisDefaultDischargeAppl' id='isPrepDisDefaultDischargeAppl' value='<%=isPrepDisDefaultDischargeAppl%>'></input>

<!--//Added by MaheshwaranK on 20 Jan 2022 for TH-KW-CRF-165.1-->
<input type='hidden' name='isDiagCatgMand' id='isDiagCatgMand' value='<%=isDiagCatgMand%>'></input>
<input type='hidden' name='isPatClsForDiagCat' id='isPatClsForDiagCat' value='<%=isPatClsForDiagCat%>'></input>
<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1741 -->
<input type='hidden' name='mode_modify_curr_enc' id='mode_modify_curr_enc' value='<%=mode_modify_curr_enc%>'></input>
<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
<input type='hidden' name='isDeceasedDiagClassDeathRegAppl' id='isDeceasedDiagClassDeathRegAppl' value='<%=isDeceasedDiagClassDeathRegAppl%>'></input>
<input type='hidden' name='primary_diag_class' id='primary_diag_class' value='<%=primary_diag_class%>'></input>
<input type='hidden' name='secondary_diag_class' id='secondary_diag_class' value='<%=secondary_diag_class%>'></input>
<input type='hidden' name='linked_yn' id='linked_yn' value='<%=linked_yn%>'></input>
 
<script>
if(('<%=code_ind%>' == 'C' || '<%=code_ind%>' == 'D' ))
	document.forms[0].AddAssociateCodes.disabled=false;

if(('<%=mode%>' == 'modify' &&  '<%=notifiable_yn%>' == 'Y' ))
		{
			if (parent.RecDiagnosisOpernToolbar.document.forms[0].authorize){
			parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value=getLabel('Common.Normal.label','Common')+''+getLabel('Common.mode.label','Common');
			parent.RecDiagnosisOpernToolbar.document.forms[0].mode.value='Normal Mode';
			}
		}
		else if('<%=mode%>' == 'modify')
		{
			if (parent.RecDiagnosisOpernToolbar.document.forms[0].authorize){
			parent.RecDiagnosisOpernToolbar.document.forms[0].authorize.value= getLabel('Common.Authorize.label','Common')+''+getLabel('Common.mode.label','Common');
			parent.RecDiagnosisOpernToolbar.document.forms[0].mode.value='Authorize Mode';
			}
		}


if('<%=mode%>' == 'modify' && '<%=high_risk_code%>' != "" ){ 
	document.getElementById('high_risk').style.visibility = 'visible';
	document.getElementById('high_risk').title = '<%=highRiskDesc%>' 
}
/*Below line added for this CRF GDOH-CRF-0082*/
if("<%=diagnosisPmb%>"=="true" && '<%=mode%>' == 'modify'){
    //PMBValidation();
	
	if('<%=mode%>' == 'modify' && '<%=pmb_code%>'!="" ){ 
			var pmb=getLabel("eMR.ThisisPMB.label","MR");						
			parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='visible';		
			parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML=pmb;
	}if('<%=mode%>' == 'modify' && '<%=pmb_code%>' == "" ){
		var notpmb=getLabel("eMR.ThisisnotPMB.label","MR");						
		parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').style.visibility='visible';						
		parent.RecDiagnosisAddModify.document.getElementById('pmb_diagnosis').innerHTML=notpmb;
	}if(document.forms[0].totsupportdiagCount&&document.forms[0].totsupportdiagCount.value!=""&&document.forms[0].totsupportdiagCount.value!=0){
    	setTimeout('PMBValidation()',1000);
	}
}
//End GDOH-CRF-0082

</script>
<%
if(stmt  != null)   stmt.close();		

} 
catch(Exception sqle)
{
	sqle.printStackTrace() ;
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

session.removeAttribute("diagnosis_code"); //Added for this CRF GDOH-CRF-0082

%>


<!-- <script>setTimeout("getCodeSet()",300);</script> -->


<script>
getAccuracy_code();
getCodeSet('y');
</script>
<%if(mode.equals("modify") && status.equals("A")) {%>
	<script>setStatus();</script>
<%}%>

<%if((mode.equals("modify") && isCurrentEncounter.equals("Y")) || (!mode.equals("modify"))){%>
	<script>check_enc();</script>
<%}%> 

<%if(!mode.equals("modify")){%>
	<script>//setTimeout("diagClassLoad()",30);</script>
<%}else {%>
	<script>///*Monday, February 01, 2010 IN018664 , called in getCodeSet() of RecDiagnosis.js*/ setTimeout("diagClassModify()",30);</script>
<%}%>

<%if(mode.equals("modify")){%>
	<script>//expandColapseframe('E');
	onload_display();
	</script>
<%}%>

<%if(modal_yn.equals("Y") && !mode.equals("modify")){%>
	<script>setTimeout("getDescription()",300);</script>
<%}%>
</font>
</form>
</body>
</html>


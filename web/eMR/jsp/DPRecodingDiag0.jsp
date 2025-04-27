<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,org.json.simple.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
 
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
 String loginUser		= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale = (String)session.getAttribute("LOCALE"); 

 String EncounterId = request.getParameter("EncounterId");
 String mode = checkForNull(request.getParameter("mode"));
 String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 String Pat_id = checkForNull(request.getParameter("Pat_id"));
 String temp_code = checkForNull(request.getParameter("temp_code"));
 String gender = checkForNull(request.getParameter("gender"));
 String age = checkForNull(request.getParameter("age"));
 String dob = checkForNull(request.getParameter("dob"));
 String spec_code = checkForNull(request.getParameter("spec_code"));
 String Patient_Class = checkForNull(request.getParameter("Patient_Class"));
 //String DRGcal = checkForNull(request.getParameter("DRGcal"));
 String drg_temp = checkForNull(request.getParameter("drg_temp"));
 String stage_no = checkForNull(request.getParameter("stage_no"));
 String stage_l2 = checkForNull(request.getParameter("stage_l2"));
 String sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
 String tot_cnt = checkForNull(request.getParameter("tot_cnt"));
 String cur_Sel=checkForNull(request.getParameter("sel_val"));

String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");

//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
Boolean doctorsDescription = false;
String doctors_description = "";
Boolean isMultiDescAppl = false; // added by mujafar for ML-MMOH-CRF-1281

//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
Boolean dischargeSummary = false;
String accession_num = "";

//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
Boolean isDiagClassLongDescAppl = false;
String diag_class_long_desc = "";

 String recd_count="0";
 int Stage_no = 0;
 int y=0;
 String chk_yn = "";

if(stage_no != "")
   Stage_no = Integer.parseInt(stage_no);



Connection conn = ConnectionManager.getConnection(request);	

 if(mode.equals(""))
	mode="N";
try
 {

	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1		= null;
	//PreparedStatement pstmt2		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	//ResultSet rs2				= null;
	StringBuffer sql1 = new StringBuffer();
	String term_set		= "";
	String term_code	= "";
	String term_desc	= "";
	String record_by	= "";
	String record_date		= "";
	String caused_death		= "";
	String classValue			= "";
	String hd_term_set	    = "";
	String hd_term_code		= "";
	String patient_id			= "";
	String authorize_item	= "";
	String p_episode_type  = "";
	String temp_chk			= "N";
	String free_text_yn		="";
	String dagger_independent_yn	= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String disp_dagger_dep_ind		= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String cross_ref_type				= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String occur_srl_no					= "";// Added For SRR-CRF-303.2 On 1/28/2010
	String associate_codes				= "";// Added For SRR-CRF-303.2 On 1/28/2010

	doctorsDescription =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DOCTOR_DESC"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
	isMultiDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
	/*Added by Ashwini on 22-Jan-2019 for ML-MMOH-CRF-1272*/
	dischargeSummary =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DISCHARGE_SUMMARY");

	isDiagClassLongDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DIAG_CLASS_LONG_DESC"); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

	JSONObject jsonAccssnNo = eMR.MRCommonBean.getAccessionNum(conn,EncounterId,Pat_id);
	accession_num = (String) jsonAccssnNo.get("accession_num");
	/*End ML-MMOH-CRF-1272*/
	boolean toolTip_diagnosis	=   eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS");	//Added by AJay Hatwate for ML-MMOH-CRF-1940
//	String equivalent_term_code = "";
	String recodeStatus = "";
	//int nc_cnt=0;
	String rev_flg="N";


	int i = 0;
	int cnt1 = 0;
	//int auth_cnt = 0;



	if(Patient_Class.equals("IP"))
		p_episode_type="I";
	else if(Patient_Class.equals("EM"))
		p_episode_type="E";
	else if(Patient_Class.equals("DC"))
		p_episode_type="D";
	else if(Patient_Class.equals("OP"))
		p_episode_type="O";

	String  hide_header		="";
	String  hide_dataTable	="";
	String  hide_exp			="";
	String show_eq_tmcd	=	"";
	String show_sprt_diag	=	"";
	String show_remarks	=	"";				
	String Stage_srl_no		=	"";				
	String remarks		=	"";				
	String diag_classification		=	"";		
	String death_reg_seq_no		=	"";	//Added On 9/22/2009 For MDR.




/*Note:Based upon the  allow_recode_diag_yn value(Parameter Setup) 
the perticular part is hiding to Display Only Procedure Part To User*/
	if(allow_recode_diag_yn.equals("Y")){
		hide_header		=	"visible";
		hide_dataTable	=	"visible";
	}else{
		hide_header		=	"hidden";
		hide_dataTable	=	"hidden";
	}
	if(allow_recode_proc_yn.equals("Y")){
		hide_exp			=	"visible";
	}else{
		hide_exp			=	"hidden";
	}


%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
	<script language='javascript' src='../../eMR/js/DPRecoding.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
	function expandDiagnosis()	{
//		parent.RecodeScreen.rows="80%,5%,*";
		parent.RecodeScreen.rows="85%,10%,5%,0%";
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.Proc_icon").innerHTML="<a href='javascript:onclick=expandProcedure()'>+</a><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>";

		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.Diag_icon").innerHTML="<a href='javascript:onclick=collapseDiagnosis()'>-</a><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>";
	}

	function collapseDiagnosis()	{
//		parent.RecodeScreen.rows="40%,40%,*";
		parent.RecodeScreen.rows="48%,48%,4%,0%";
		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.Diag_icon").innerHTML="<a href='javascript:onclick=expandDiagnosis()'>+</a><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>";

	}

	function showDiag()	{
		//if(mode.equals("Y"))
			//parent.frames[2].document.RecodeDiagnosisDiagDetail.diagTable.visiblity='visible';

	}

	function expandRecode(i)	{
		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1"+i).style.visibility='visible';
		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1"+i).style.display='inline';
		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol"+i).innerHTML="<a href='javascript:onclick=collapseRecode("+i+")'>-</a>";
	}

	function collapseRecode(i)		{

		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1"+i).style.visibility='hidden';
		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recode1"+i).style.display='none';
		eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol"+i).innerHTML="<a href='javascript:onclick=expandRecode("+i+")'>+</a>";
	}

	//Added by Ajay Hatwate for ML-MMOH-CRF-1940
	function longDescToolTip(term_code, long_desc) {
	    var tab_data2 = "<div class='tooltip1'> " + term_code + " / " + long_desc + "</div>";
	    return tab_data2;
	}

	</script>

	</head>
	<body onKeyDown='lockKey()' <%if(dischargeSummary){%>onunload="destroyPopUps()"<%}%>>
	<form name="RecodeDiagnosisDiagDetail" id="RecodeDiagnosisDiagDetail" method='post'>
	<!--<form name="RecodeDiagnosisDiagDetail" id="RecodeDiagnosisDiagDetail">-->
	<table id='diagTable' style='visibility:visible;display:inline' border=0 cellpadding='3' cellspacing='0' width="100%"  valign='top' onLoad='showDiag();'>
	<tr>
	<td class='label'><fmt:message key="eMR.show.label" bundle="${mr_labels}"/></td>
	<td class='fields'><select name='show_level' id='show_level' onChange='getLevel(this);' onmousewheel='return false;'><!-- <option >----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option> -->

	<option value='0'>Original</option>
	<%
	if(stage_l2.equals("")) {
		if(Stage_no == 1){%>
			<option value='1' selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
		<%
		}else if(Stage_no == 2){%>
			<option value='1'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
			<option value='2' selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
		<%
		}else if(Stage_no == 3){%>
			<option value='1' selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
			<option value='2'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
			<option value='3' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;3</option>
		<%
		}
	}else if(stage_l2.equals("Y")){%>
		<option value='1'selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
		<option value='2' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
	<%}else{%>
		<option value='1'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
		<option value='2' selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
		<option value='3'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;3</option>

	<%}
	%>
	</select>
	</td>
	<td colspan="6"><input type='button' name='Reject_Diag' id='Reject_Diag' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")%> Diagnosis' class='button'  onclick='Original_Diag();' style="visibility:hidden">&nbsp;<input type='button' name='Reject_Proc' id='Reject_Proc' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")%> Procedure' class='button'  onclick='Original_Proc();' style="visibility:hidden">&nbsp;</td>
	<!-- <td colspan=1 nowrap>
		<a href="javascript:onclick=show_clinic_his()" ><fmt:message key="eMR.ViewClinicalHistory.label" bundle="${common_labels}"/></a>
	</td> -->

	</td>
		<td nowrap onmouseover="hideTooltip()">
			<a href="javascript:onclick=DummyRef()" onclick="displayMenu()"  style="cursor:pointer" ><fmt:message key="eMR.ViewClinicalHistory.label" bundle="${mr_labels}"/></a>&nbsp;&nbsp;
		</td>

	
	<td id='origerrorHistory' style="display:none" nowrap>
			<img src='../../eCommon/images/PI_SuspendedPatient.gif '  style="cursor:pointer;"onclick="show_err_history('ORIG_MRK_ERR')" alt="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.showerrorcodesbypractitioner.label","mr_labels")%>">&nbsp;&nbsp;
	</td>
	</tr>

	<tr>&nbsp;</tr>
	<table style="visibility:<%=hide_dataTable%>"width='100%'  border='1' cellpadding='1' cellspacing='0'>
	<tr style="visibility:<%=hide_header%>"><td colspan='10' class='PANELTOOLBAR' id="Diag_icon"><a href="javascript:onclick=expandDiagnosis()" style="visibility:<%=hide_exp%>">+</a>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td></tr>
		<tr>&nbsp;</tr>
	<tr>
	<th align='center'>&nbsp;</th>
	<th align='center'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
	<th align='center'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
	<th align='center' nowrap><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th align='center' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
	<%if(doctorsDescription){%>
	<th align='center' nowrap><fmt:message key="eMR.DoctorDesc.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</th>
	<%}%>
	<th align='center' ><fmt:message key="Common.Classification.label" bundle="${common_labels}"/></th>
	<!-- 	<th align='center' ><fmt:message key="Common.details.label" bundle="${common_labels}"/></th>Added On 7/2/2009-->	
    <th align='center' ><fmt:message key="eMR.CodedBy.label" bundle="${mr_labels}"/></th> 
	<th align='center' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
	<th align='center' nowrap><fmt:message key="eMR.CausedDeath.label" bundle="${mr_labels}"/></th>
	</tr>


<%
		String  remark_lbl			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
		String  eqvi_code_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
		String spprt_dig_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SupportingDiagnosis.label","common_labels");		
		String diag_clas_lbl		=	"";		
	
		String New_EncounterId=EncounterId;//If allow_recode_diag_yn="Y";
		if(allow_recode_diag_yn.equals("N")){
			New_EncounterId="";
		}

		if(mode.equals("Y")){
					 

			if ( i % 2 == 0 )
				classValue = "gridData" ;
			else
				classValue = "gridData" ;
		
			//sql1.append("SELECT A.PATIENT_ID,A.TERM_SET_ID,A.TERM_CODE, B.SHORT_DESC, am_get_desc.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1') practitioner_name, TO_CHAR (A.RECORDED_DATE_TIME, 'dd/mm/yy hh24:mi') RECORDED_DATE_TIME, 	A.CAUSE_OF_DEATH_YN FROM PR_DIAGNOSIS_ENC_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID = '"+p_facility_id+"' AND A.ENCOUNTER_ID = '"+EncounterId+"' AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE");

			//sql1.append("SELECT a.patient_id, a.term_set_id, a.term_code, b.short_desc,       am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,       TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time, a.cause_of_death_yn FROM pr_diagnosis c,pr_diagnosis_enc_dtl a, mr_term_code b WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code and c.patient_id=a.patient_id and c.term_set_id=a.term_set_id and c.term_code=a.term_code and c.occur_srl_no=a.occur_srl_no AND c.curr_facility_id=a.facility_id and c.curr_encounter_id=a.encounter_id");

			/*Query Was Modified For MDR Modified On 9/22/2009*/
			/*Modified by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364*/
			sql1.append("SELECT a.patient_id, a.term_set_id, a.term_code, b.short_desc,b.free_text_yn,(case when a.term_code = '*OTH' then a.term_code_short_desc else mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') end) term_code_short_desc,a.term_code_short_desc term_code_short_desc1,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date_time, a.cause_of_death,a.death_reg_seq_no,decode(recode_status,'O','Review')recode_status, Stage_srl_no,remarks,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification,decode (c.DIAG_CLASS_TYPE,'PD','1','CM','2','EC','4','CO','3','','5') diag_classification_grp, mr_get_desc.mr_diag_class (a.diag_class_code,'"+locale+"', '1') diag_class_long_desc, b.dagger_independent_yn,b.cross_ref_type,a.occur_srl_no,b.long_desc,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mc WHERE mc.TERM_SET_ID = a.term_set_id AND mc.term_code = a.term_code AND mc.CROSS_REF_TYPE = 'EQ') equiv_count,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct1 WHERE mct1.TERM_SET_ID = a.term_set_id AND mct1.TERM_CODE = a.term_code AND mct1.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct1.CROSS_REF_TYPE='AS' ) dgr_cnt,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct2 WHERE mct2.TERM_SET_ID = a.term_set_id AND Mct2.TERM_CODE = a.term_code AND mct2.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct2.CROSS_REF_TYPE='EC' ) conseq_cnt,DOCTORS_DESCRIPTION FROM  MR_DIAGNOSIS_RECODING_DTL  a, mr_term_code b,MR_DIAG_CLASS c WHERE a.facility_id = '"+p_facility_id+"'  AND a.encounter_id = '"+New_EncounterId+"' and a.recode_status='O' and stage_no='0' and status='A' and a.term_set_id = b.term_set_id AND a.term_code = b.term_code  and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+)  order by diag_classification_grp");
			// modified by mujafar for ML-MMOH-CRF-1281
			//DOCTORS_DESCRIPTION Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
			pstmt = conn.prepareStatement(sql1.toString());
			rs = pstmt.executeQuery();	
			while(rs.next()){
				String long_desc				= "";// Added For Site Enhancement On 3/11/2010
				String display_long_desc	 = "none";// Added For Site Enhancement On 3/11/2010
				String long_desc_params	 = "";// Added For Site Enhancement On 3/11/2010
				int equivalent_term_code_cnt =0;
				int support_diag_cnt				  =0;

				patient_id				= checkForNull(rs.getString("patient_id"));
				term_set				= checkForNull(rs.getString("term_set_id"));
				term_code			= checkForNull(rs.getString("term_code"));
				free_text_yn			= checkForNull(rs.getString("free_text_yn"));
				if(free_text_yn.equals("Y")){
					term_desc		= checkForNull(rs.getString("term_code_short_desc"));
				}else{
					term_desc		= checkForNull(rs.getString("short_desc"));
				}
				
				
				if(isMultiDescAppl && term_set.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				{
				term_desc = checkForNull(rs.getString("term_code_short_desc1"));
				if(term_desc.equals(""))
				term_desc		= checkForNull(rs.getString("SHORT_DESC"));
				}
				
				
				
				record_date			 = checkForNull(rs.getString("recorded_date_time"));
				record_date			 =DateUtils.convertDate(record_date,"DMYHM" ,"en",locale);
				record_by			 = checkForNull(rs.getString("practitioner_name"));
				caused_death		 = checkForNull(rs.getString("cause_of_death"));
				death_reg_seq_no = checkForNull(rs.getString("death_reg_seq_no"));
				recodeStatus			 = checkForNull(rs.getString("recode_status"));
				remarks				 = checkForNull(rs.getString("remarks"));
				Stage_srl_no			 = checkForNull(rs.getString("Stage_srl_no"));
				diag_classification	 = checkForNull(rs.getString("diag_classification"));
				dagger_independent_yn	= checkForNull(rs.getString("dagger_independent_yn"));
				cross_ref_type					= checkForNull(rs.getString("cross_ref_type"));
				occur_srl_no						= checkForNull(rs.getString("occur_srl_no"));
				long_desc							= checkForNull(rs.getString("long_desc"));
				equivalent_term_code_cnt= rs.getInt("equiv_count");

				doctors_description	= checkForNull(rs.getString("doctors_description")); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
				diag_class_long_desc = checkForNull(rs.getString("diag_class_long_desc")); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

//				long_desc							= java.net.URLEncoder.encode(long_desc);
/*
		F.Y.I :Added on 1/28/2010 For SRR-CRF-303.2
		1.When the Term Code is Dagger independent based upon 
			the dagger_independent_yn value the indicator of the term code wiii be visible.
*/
				if(dagger_independent_yn.equals("Y")){
					disp_dagger_dep_ind	=	"display:inline";
				}else{
					disp_dagger_dep_ind	=	"display:none";
				}
				
				if(recodeStatus.equals("Review")){
					recodeStatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//For Original Code;
				}

			//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
			if(isDiagClassLongDescAppl){
				diag_clas_lbl = diag_class_long_desc;
			}else
			{
				if(diag_classification.equals("Principal")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.principal.label","mr_labels");
				}else if(diag_classification.equals("Comorbidity")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.comorbidity.label","mr_labels");
				}else if(diag_classification.equals("External Causes")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.externalcauses.label","mr_labels");
				}else if(diag_classification.equals("Complication")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.complication.label","mr_labels");
				}else if(diag_classification.equals("Others")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.others.label","mr_labels");
				}
			}
			
			//int cnt_icd = 0;
				//String sqlicd="SELECT EQUIVALENT_TERM_CODE FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID != 'ICD10' AND EQUIVALENT_TERM_SET_ID = 'ICD10' AND term_code = '"+term_code+"'";
			
/*For EQUIVALENT_TERM_CODE
				This Query Was merged with main Quey For  PE Tuning
*/
					/*String sqlicd="SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+term_set+"' AND term_code = '"+term_code+"' AND CROSS_REF_TYPE = 'EQ'";
					pstmt1 = conn.prepareStatement(sqlicd);
					rs1	 = pstmt1.executeQuery();	
					while(rs1.next()){
							equivalent_term_code_cnt=rs1.getInt("COUNT");
					}
					if(pstmt1 != null) pstmt1.close();
					if(rs1 != null) rs1.close();*/
/**Ends**/
/*For Support Diagnosis*/
/*
		F.Y.I :Added on 1/28/2010 For SRR-CRF-303.2
		1.Based Upon the code indicator the supporting diagnosis icon will be open.
		2.Before this enhancement if the icon was clicked only the astrik codes are visible for the respective Dagger.
*/
//				String sql_sprt_diag="";
				if(cross_ref_type.equals("D")){ 
//						show_sprt_diag	= "visible";
						associate_codes		= "A";
						support_diag_cnt		=rs.getInt("dgr_cnt");
				}else if(cross_ref_type.equals("C")){
						associate_codes		= "EC";
						support_diag_cnt		=rs.getInt("conseq_cnt");
				}else{
						show_sprt_diag	="hidden";
						associate_codes	="";
				}						

	/*Ends*/

				if(equivalent_term_code_cnt!=0){
					show_eq_tmcd	 ="visible";
				}else{
					show_eq_tmcd		="hidden";
				}
				if(support_diag_cnt!=0){
					show_sprt_diag	="visible";
				}else{
					show_sprt_diag	="hidden";
				}
				if(!remarks.equals("")){
					show_remarks	="visible";
				}else{
					show_remarks		="hidden";
				}
				if(!(term_desc.equals(long_desc))&&!(term_code.equals("*OTH"))){
					display_long_desc ="inline";
					long_desc_params = term_code+","+term_set;
				}
				
				//StringBuffer sql3 = new StringBuffer();
				
				//String recodesql_21 = "select count(*) FROM MR_DIAGNOSIS_RECODING WHERE FACILITY_ID = '"+p_facility_id+"' AND ENCOUNTER_ID = '"+EncounterId+"' AND  STAGE_NO='"+Stage_no+"' AND ORIG_TERM_SET_ID='"+term_set+"' AND ORIG_TERM_CODE='"+term_code+"' and RECODE_STATUS !='NEWCODE'";
				//pstmt = conn.prepareStatement(recodesql_21);
				//rs1	 = pstmt.executeQuery();

				//int mr_diag_count=0;
				String chk_status ="disabled";

				//if(rs1.next()){
					//mr_diag_count=rs1.getInt(1);

				//}


				//if(mr_diag_count > 0)
					//chk_status="disabled";
				//else
					//chk_status="";
				%>

				
										
				<tr id='recode1<%=i%>' >
				<td class='<%=classValue%>'>
					<img src='../../eCommon/images/EqivDiag.gif '  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=term_set%>","<%=term_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"><img src='../../eCommon/images/SuppDiag.gif '  style="cursor:pointer;visibility:<%=show_sprt_diag%>"onclick='recodeSupportDiagnosis("ORIGINAL","<%=associate_codes%>","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=patient_id%>","<%=occur_srl_no%>","<%=cur_Sel%>","<%=Stage_srl_no%>","")' alt="<%=spprt_dig_lbl%>"><img src='../../eCommon/images/RecodeRemarks.gif '  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=Stage_srl_no%>","N","","")' alt="<%=remark_lbl%>"><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
				</td>	<!-- Equalent Term Code,Support Diag&Remarks Images  -->
				<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269--> 
				<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=term_code%>$<%=term_set%>$REVIEW$<%=java.net.URLEncoder.encode(term_desc)%>~' onClick='enableSelect1(<%=i%>,this,document.forms[0].term_code.value)' <%=chk_status%>></td>
				<td class='<%=classValue%>'><%=recodeStatus%></td>
				<td class='<%=classValue%>'><%=term_set%>&nbsp;/&nbsp;<%=term_code%>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td>
				<%if(toolTip_diagnosis){ %>
				<td class="<%=classValue%>" onMouseOver="Tip(longDescToolTip('<%=term_code %>', '<%=long_desc %>'))" onMouseOut="UnTip()"><%=term_desc%></td>
				<%}else{ %>
				<td class='<%=classValue%>'><%=term_desc%></td>
				<%} %>
				<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
				<%if(doctorsDescription){%>
				<td class='<%=classValue%>'>&nbsp;<%=doctors_description%></td>
				<%}%>
				<td class='<%=classValue%>'><%=diag_clas_lbl%>&nbsp;</td><!-- Diag.Classification -->
				<td class='<%=classValue%>' nowrap><%=record_by%></td>
				<td  class='<%=classValue%>' nowrap><%=record_date%></td>				
				<%if(caused_death.equals("C")){
					String title="";
					if(death_reg_seq_no.equals("1")){
						 title="Primary";
					}%>
					<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt='<%=title%>'/></td>
				<%}else if(caused_death.equals("O")){%>
						<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/y-white.gif' alt='Related'/></td>
				<%}else if(caused_death.equals("R")){%>
						<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif' alt='Not Related'/></td>
				<%}else{%>
						<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif'/></td>
				<%}%>				
				</tr>
			
			<%}  // while loop

					
		} // mode check
		int  diag_origerr_cnt=0;
		int  proc_origerr_cnt=0;
		String Diag_Proc_err_cnt_SQL="SELECT (SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"')diag_err_cnt,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"')proc_err_cnt FROM DUAL";
		pstmt = conn.prepareStatement(Diag_Proc_err_cnt_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			diag_origerr_cnt = rs.getInt("diag_err_cnt");
			proc_origerr_cnt = rs.getInt("proc_err_cnt");
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();

		/*String Proc_err_cnt_SQL="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"'";				
		pstmt = conn.prepareStatement(Proc_err_cnt_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
		}
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();*/

	if(diag_origerr_cnt>0 || proc_origerr_cnt>0){%>
		<script>
			document.getElementById("origerrorHistory").style.display="inline";
		</script>
<%}

		if(rs != null)rs.close();
		if(rs1 != null)rs1.close();
		if(pstmt  != null)pstmt.close();
		if(pstmt1  != null)pstmt1.close();
		%>
		</table>

		</table>
		<input type="hidden" name="diag_origerr_cnt" id="diag_origerr_cnt" value="<%=diag_origerr_cnt%>">		
		<input type="hidden" name="proc_origerr_cnt" id="proc_origerr_cnt" value="<%=proc_origerr_cnt%>">

		<input type='hidden' name='term_code' id='term_code' value='<%=term_code%>'>
		<input type='hidden' name='diagprob_code' id='diagprob_code' value='<%=term_code%>'>
		<input type='hidden' name='temp_code' id='temp_code' value='<%=temp_code%>'>
		<input type='hidden' name='sel_item' id='sel_item' value=''>
		<input type='hidden' name='dflt_termset' id='dflt_termset' value='<%=dflt_termset%>'>
		<input type='hidden' name='Pat_id' id='Pat_id' value='<%=Pat_id%>'>
		<input type='hidden' name='gender' id='gender' value='<%=gender%>'>
		<input type='hidden' name='age' id='age' value='<%=age%>'>
		<input type='hidden' name='dob' id='dob' value='<%=dob%>'>
		<input type='hidden' name='spec_code' id='spec_code' value='<%=spec_code%>'>
		<input type='hidden' name='Patient_Class' id='Patient_Class' value='<%=Patient_Class%>'>
		<input type='hidden' name='EncounterId' id='EncounterId' value='<%=EncounterId%>'>
		<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value='<%=loginUser%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=p_facility_id%>'>
		<input type='hidden' name='fieldSeperator' id='fieldSeperator' value='|'>
		<input type='hidden' name='profileID' id='profileID' value='XB'>
		<input type='hidden' name='caused_death' id='caused_death' value='<%=caused_death%>'>
		<input type='hidden' name='code_set' id='code_set' value=''>
		<input type='hidden' name='diagprob_code' id='diagprob_code' value=''>
		<input type='hidden' name='diag_classfication' id='diag_classfication' value=''>
		<input type='hidden' name='accuracy' id='accuracy' value=''>
		<input type='hidden' name='severity' id='severity' value=''>
		<input type='hidden' name='priority' id='priority' value=''>
		<input type='hidden' name='onset_type' id='onset_type' value=''>
		<input type='hidden' name='onset_date' id='onset_date' value=''>
		<input type='hidden' name='status' id='status' value=''>
		<input type='hidden' name='status_date' id='status_date' value=''>
		<input type='hidden' name='applicable_side' id='applicable_side' value=''>
		<input type='hidden' name='remarks' id='remarks' value=''>
		<input type='hidden' name='occur_srl_no' id='occur_srl_no' value=''>
		<input type='hidden' name='recode_status' id='recode_status' value=''>
		<input type='hidden' name='orig_termset' id='orig_termset' value=''>
		<input type='hidden' name='orig_termcode' id='orig_termcode' value=''>
		<input type='hidden' name='checked_yn' id='checked_yn' value='N'>
		<input type='hidden' name='hd_term_set' id='hd_term_set' value='<%=hd_term_set%>'>
		<input type='hidden' name='hd_term_code' id='hd_term_code' value='<%=hd_term_code%>'>
		<input type='hidden' name='drg_temp' id='drg_temp' value='<%=drg_temp%>'>

		<input type='hidden' name='cnt1' id='cnt1' value='<%=cnt1%>'>
		<input type='hidden' name='i' id='i' value='<%=i%>'>
		<input type='hidden' name='termcode_cnt' id='termcode_cnt' value=''>
		<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='<%=bl_install_yn%>'>
		<input type='hidden' name='authorize_item' id='authorize_item' value='<%=authorize_item%>'>
		<input type='hidden' name='procedure_yn' id='procedure_yn' value=''>
		<input type='hidden' name='recal_yn' id='recal_yn' value=''>
		<input type='hidden' name='p_episode_type' id='p_episode_type' value='I'>
		<input type='hidden' name='temp_chk' id='temp_chk' value='<%=temp_chk%>'>
		<input type='hidden' name='stage_l2' id='stage_l2' value='<%=stage_l2%>'>
		<input type='hidden' name='sequenced_yn' id='sequenced_yn' value='<%=sequenced_yn%>'>
		<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">	
		<input type="hidden" name="chk_yn" id="chk_yn" value="<%=chk_yn%>">	
		<input type="hidden" name="y" id="y" value="<%=y%>">	
		<input type="hidden" name="tot_cnt" id="tot_cnt" value="<%=tot_cnt%>">
		<input type="hidden" name="recd_count" id="recd_count" value="<%=recd_count%>">
		<input type="hidden" name="rev_flg" id="rev_flg" value="<%=rev_flg%>">

		<input type="hidden" name="cur_Sel" id="cur_Sel" value="<%=cur_Sel%>">
<!-- 		<input type='hidden' name='show_level' id='show_level' value=''>
 -->		<input type='hidden' name='Stage_no' id='Stage_no' value='<%=Stage_no%>'>
		<input type='hidden' name='stage_no' id='stage_no' value='<%=Stage_no%>'>
		<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value='<%=allow_recode_diag_yn%>'>
		<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn%>'>
		<!--Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272-->
		<input type="hidden" name="dischargeSummary" id="dischargeSummary" value="<%=dischargeSummary%>">
		<input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">


			
		<%

		if(cur_Sel.equals("0")){%>
			 <script>
			document.forms[0].show_level.options.selectedIndex=0;
			</script>
		<%}%>

<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
				<tr><td width='100%' id='t'></td></tr>
			</table>
		</div>	
		</form>
		<%
}catch(Exception e) {
	e.printStackTrace();
 }finally{
		ConnectionManager.returnConnection(conn,request);

 }

	%>
<script language='javascript' src='../../eOT/js/wz_tooltip.js'></script>
</body>
</html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


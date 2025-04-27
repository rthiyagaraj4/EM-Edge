<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,org.json.simple.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%		
 String sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 //String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
 String loginUser			= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale					= (String)session.getAttribute("LOCALE"); 
String practitioner_type= (String)session.getValue("practitioner_type");//Added On 2/26/2010 For SRR-CRF-303.2 [IN05597]
String ca_practitioner_id= (String)session.getValue("ca_practitioner_id");//Added On 2/26/2010 For SRR-CRF-303.2 [IN05597]
 practitioner_type			= checkForNull(practitioner_type);
 ca_practitioner_id		= checkForNull(ca_practitioner_id);
String EncounterId		= request.getParameter("EncounterId");
 String mode					= checkForNull(request.getParameter("mode"));
 //String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 String Pat_id				= checkForNull(request.getParameter("Pat_id"));
 String temp_code			= checkForNull(request.getParameter("temp_code"));
 String gender				= checkForNull(request.getParameter("gender"));
 String age						= checkForNull(request.getParameter("age"));
  String dob					= checkForNull(request.getParameter("dob"));
 String spec_code			= checkForNull(request.getParameter("spec_code"));
 String Patient_Class		= checkForNull(request.getParameter("Patient_Class"));
// String DRGcal = checkForNull(request.getParameter("DRGcal"));
//String drg_temp = checkForNull(request.getParameter("drg_temp"));      
 String stage_no			= checkForNull(request.getParameter("stage_no"));
 String stage_l2				= checkForNull(request.getParameter("stage_l2"));
 //String sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
// String tot_cnt = checkForNull(request.getParameter("tot_cnt"));
 String cur_Sel				=checkForNull(request.getParameter("sel_val"));
String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String drg_yn							= checkForNull((String)session.getAttribute("drg_calculation_yn"),"N");
/* In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300*/
String specialty_code=checkForNull(request.getParameter("specialty_code"));  
String hdr_status ="";

//Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
Boolean doctorsDescription = false;
String doctors_description = "";

//Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272
Boolean dischargeSummary = false;
String accession_num = "";

Boolean isMultiDescAppl = false; // added by mujafar for ML-MMOH-CRF-1281

//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
Boolean isDiagClassLongDescAppl = false;
String diag_class_long_desc = "";

 //String recd_count="0";
 int Stage_no = 0;
 //int y=0;
 String chk_yn = "";

if(stage_no != "")
   Stage_no = Integer.parseInt(stage_no);
 if(mode.equals(""))
	mode="N";
if(cur_Sel.equals("")){
	cur_Sel=stage_no;
}
Connection conn		= null;	
CallableStatement main_cal_pstmt	=	null;
PreparedStatement pstmt			= null;
//PreparedStatement pstmt1		= null;
ResultSet rs					= null;
//ResultSet rs1				= null;


try  {
	conn = ConnectionManager.getConnection(request);		
	//PreparedStatement pstmt2		= null;
	//ResultSet rs2				= null;
	StringBuffer sql1 = new StringBuffer();

	PreparedStatement pstmt3		= null;
	ResultSet rs3				= null;
	
	String classValue	 = "";
	String term_set		= "";
	String term_code	= "";
	String term_desc	= "";
	String coded_by	= "";
	String coded_date		= "";
	String causeDeath		= "";
	String recodeStatus	= "";
	String stg_srl_no		= "";
	//String hd_recodeStatus_disp = "";
	String patient_id			= "";
	String orig_term_set		= "";
	String orig_term_code	= "";
	//String authorize_item = "";
	String p_episode_type = "";
	String temp_chk		   = "N";
//	String equivalent_term_code = "";
	String recodeStatus_desc="";
	String recodeStatus_desc_temp=""; // added by mujafar for ML-MMOH-CRF-1270
	//int nc_cnt=0;
	//String rev_flg="N";
	String group_YN		="";
	String stage_seq_no	="";
	//String tem_str="";
	String stage_no_disp	 ="";
	String confirm_yn		 ="";
	String chk_disable		 ="";
	String Lock_all			 ="";
	String values_fetched	 ="";
	String final_diag_values	 ="";
	String active_diag_codes	 ="";
	String DIAG_CLASS_TYPE="";
	String Prin_diag			 ="";
	String prin_stg_srl_no="";
	String dagger_independent_yn	="";// Added For SRR-CRF-303.2
	String disp_dagger_dep_ind		="";// Added For SRR-CRF-303.2
	String cross_ref_type				="";// Added For SRR-CRF-303.2
	String occur_srl_no					="";// Added For SRR-CRF-303.2
	String trx_no			="";
	int prin_diag_cnt	=0;

	int i = 0;
	int seq_no=0;
	//int cnt1 = 0;
	//int auth_cnt = 0;
	
	doctorsDescription =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DOCTOR_DESC"); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
	boolean toolTip_diagnosis	=   eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS");//Added by AJay Hatwate for ML-MMOH-CRF-1940	
	isMultiDescAppl =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281

	/*Added by Ashwini on 22-Jan-2019 for ML-MMOH-CRF-1272*/
	dischargeSummary =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DISCHARGE_SUMMARY");

	isDiagClassLongDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","DIAG_CLASS_LONG_DESC"); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

	JSONObject jsonAccssnNo = eMR.MRCommonBean.getAccessionNum(conn,EncounterId,Pat_id);
	accession_num = (String) jsonAccssnNo.get("accession_num");
	/*End ML-MMOH-CRF-1272*/

	if(Patient_Class.equals("IP"))
		p_episode_type="I";
	else if(Patient_Class.equals("EM"))
		p_episode_type="E";
	else if(Patient_Class.equals("DC"))
		p_episode_type="D";
	else if(Patient_Class.equals("OP"))
		p_episode_type="O";

//String  hide_header		="";
String  hide_dataTable	="";
String  hide_exp			="";
String New_EncounterId="";
/*Note:Based upon the  allow_recode_diag_yn value(Parameter Setup) 
the perticular part is hiding to Display Only Procedure Part To User*/
	if(allow_recode_diag_yn.equals("Y")){
//		hide_header		=	"visible";
		hide_dataTable	=	"visible";
		New_EncounterId=EncounterId; //If allow_recode_diag_yn="Y"
	}else{
//		hide_header		=	"hidden";
		hide_dataTable	=	"hidden";
		New_EncounterId="";
	}
	if(allow_recode_proc_yn.equals("Y")){
		hide_exp	="visible";
	}else{
		hide_exp	="hidden";
	}
	if(practitioner_type.equals("") && ca_practitioner_id.equals("") ){
		String PRACT_TYPE_SQL ="SELECT PRACT_TYPE,PRACTITIONER_ID FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = (SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = '"+loginUser+"')";
		pstmt=conn.prepareStatement(PRACT_TYPE_SQL);
		rs = pstmt.executeQuery();
		while(rs.next()){
			practitioner_type		= rs.getString("PRACT_TYPE");
			ca_practitioner_id		= rs.getString("PRACTITIONER_ID");
		}
		session.putValue("practitioner_type",practitioner_type);
		session.putValue("ca_practitioner_id",ca_practitioner_id);
	}

				String L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
				String L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
				String L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
				String hdr_level			= checkForNull(request.getParameter("curr_level"));;

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


		function disableButtons(){
//					parent.RecodeScreen.rows="47%,47%,0%,0%";
					var allow_recode_diag_yn	= document.getElementById('allow_recode_diag_yn').value;
					var allow_recode_proc_yn	= document.getElementById("allow_recode_proc_yn").value;
					if(allow_recode_diag_yn=="Y" && allow_recode_proc_yn=="Y"){
						parent.RecodeScreen.rows="48%,48%,4%,0%";
					}else if(allow_recode_diag_yn=="Y"){
						parent.RecodeScreen.rows="95%,0%,5%,0%";
					}else if(allow_recode_proc_yn=="Y"){
						parent.RecodeScreen.rows="10%,85%,5%,0%";
					}
					if(parent.frames[4].document.forms[0].new_code_diag){
						parent.frames[4].document.forms[0].new_code_diag.disabled=true;
						parent.frames[4].document.forms[0].new_code_diag.style.visibility="hidden";
					}

					if(parent.frames[4].document.forms[0].new_code_proc){
						parent.frames[4].document.forms[0].new_code_proc.disabled=true;
						parent.frames[4].document.forms[0].new_code_proc.style.visibility="hidden";
					}

					if(parent.frames[4].document.forms[0].recode){
						parent.frames[4].document.forms[0].recode.disabled=true;
						parent.frames[4].document.forms[0].recode.style.visibility="hidden";
					}

					if(parent.frames[4].document.forms[0].confirm){
						parent.frames[4].document.forms[0].confirm.disabled=true;
						parent.frames[4].document.forms[0].confirm.style.visibility="hidden";
					}

					if(parent.frames[4].document.forms[0].error){
						parent.frames[4].document.forms[0].error.disabled=true;
						parent.frames[4].document.forms[0].error.style.visibility="hidden";
					}

					if(parent.frames[4].document.forms[0].complete){
						parent.frames[4].document.forms[0].complete.disabled=true;
						parent.frames[4].document.forms[0].complete.style.visibility="hidden";
					}
					
		}

		/*function disable_confirmed_Buttons(){               

					var final_diag_values=parent.frames[2].document.forms[0].final_diag_values.value;
					var final_proc_values=parent.frames[3].document.forms[0].final_proc_values.value;

					var out_arr="";

					var DB_Chkdiag_Values="";
					var DB_Chkdiag_srl_no="";
					var DB_Chkproc_Values="";
					var DB_Chkproc_srl_no="";

					var error='';


					if(final_diag_values!=""){
						 out_arr=final_diag_values.split("~");
						for(i=0;i<out_arr.length-1;i++){
							var in_arr=out_arr[i].split("$");
							if(in_arr[3]!='Confirmed'){
								error="Y";
								break;
							}
							
						}
					}
					
					if(final_proc_values!=""){
						out_arr1=final_proc_values.split("~");
						for(ij=0;ij<out_arr1.length-1;ij++){
							var in_arr1=out_arr1[ij].split("$");
							if(in_arr1[3]!='Confirmed'){
								error="Y";
								break;
							}

						}
					}
					
					if(error==""){
						if(parent.frames[4].document.forms[0].recode){
							parent.frames[4].document.forms[0].recode.disabled=true;
						}

						if(parent.frames[4].document.forms[0].confirm){
							parent.frames[4].document.forms[0].confirm.disabled=true;
						}

						if(parent.frames[4].document.forms[0].error){
							parent.frames[4].document.forms[0].error.disabled=true;
						}
					}
		}	*/
		function expandDiagnosis()	{
			/* parent.RecodeScreen.rows="85%,10%,5%,0%"; */
			parent.document.getElementById("DiagProcRecodingPatDetail").style.height="59vh";
			parent.document.getElementById("RecDiagnosisDiag").style.height="63vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="12vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="9vh";
			parent.document.getElementById("DiagProcTrans").style.height="0vh";
			parent.frames[3].document.getElementById("Proc_icon").innerHTML="<a href='javascript:onclick=expandProcedure()'>+</a><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>";
			//parent.frames[3].scrolling="no";
			parent.frames[2].document.getElementById("Diag_icon").innerHTML="<a href='javascript:onclick=collapseDiagnosis()'>-</a><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>";
		}

		function collapseDiagnosis()	{
			/* parent.RecodeScreen.rows="48%,48%,4%,0%"; */
			parent.document.getElementById("DiagProcRecodingPatDetail").style.height="40vh";
			parent.document.getElementById("RecDiagnosisDiag").style.height="44vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="29vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="4vh";
			parent.document.getElementById("DiagProcTrans").style.height="0vh";
			parent.frames[2].document.getElementById("Diag_icon").innerHTML="<a href='javascript:onclick=expandDiagnosis()'>+</a><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>";
				
		}

		function showDiag()	{
			//if(mode.equals("Y"))
				//parent.frames[2].document.RecodeDiagnosisDiagDetail.diagTable.visiblity='visible';
		}


		
	function expandHist(i)	{
	var sel=i;
	var len=eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist"+parseInt(sel)).length;
		
	eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist"+parseInt(sel)).style.visibility='visible';
	eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist"+parseInt(sel)).style.display='inline';
		
	
	eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol"+parseInt(sel)).innerHTML="<a href='javascript:onclick=collapseHist("+parseInt(sel)+")'>-</a>";
	
}

function collapseHist(i)	{

	eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist"+parseInt(i)).style.visibility='hidden';
	eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodehist"+parseInt(i)).style.display='none';
	eval("parent.frames[2].document.RecodeDiagnosisDiagDetail.all.recodeSymbol"+parseInt(i)).innerHTML="<a href='javascript:onclick=expandHist("+parseInt(i)+")'>+</a>";
}
//Added by Ajay Hatwate for ML-MMOH-CRF-1940
function longDescToolTip(term_code, long_desc) {
    var tab_data2 = "<div class='tooltip1'> " + term_code + " / " + long_desc + "</div>";
    return tab_data2;
}
	</script>
	</head>
	<body onKeyDown='lockKey()'; onLoad='document.getElementById("clinical_err_histry").focus();' <%if(dischargeSummary){%>onunload="destroyPopUps()"<%}%>>
	<form name="RecodeDiagnosisDiagDetail" id="RecodeDiagnosisDiagDetail" method='post' >
	<table id='diagTable' style='visibility:visible;display:inline' border=0 cellpadding='1' cellspacing='0' width="100%"  valign='top' onLoad='showDiag();'>
		<tr>
		<td class='label'><fmt:message key="eMR.show.label" bundle="${mr_labels}"/></td>
		<td class='fields'><select name='show_level' id='show_level' onChange='getLevel(this);' onmousewheel='return false;'>

		<option value='0'>Original</option>
		<%
		if(stage_l2.equals(""))   {
			if(Stage_no == 1){%>
				<option value='1' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
			<%
			}else if(Stage_no == 2){%>
				<option value='1'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
				<option value='2' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
			<%
			}else if(Stage_no == 3){%>
				<option value='1' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
				<option value='2'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
				<option value='3' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;3</option>
			<%
			}
		}else if(stage_l2.equals("Y")){%>
				<option value='1'selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
				<option value='2' ><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
		<%}else {%>
				<option value='1'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;1</option>
				<option value='2' selected><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;2</option>
				<option value='3'><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;3</option>

		 <%}
		%>
		</select>
		</td>
		<td colspan="5">
		<input type='button' name='Reject_Diag' id='Reject_Diag' class='button'  onclick='Original_Diag();' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectDiagnosis.label","common_labels")%>'   style="visibility:hidden">
		&nbsp;
		<input type='button' name='Reject_Proc' id='Reject_Proc' class='button'  onclick='Original_Proc();' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectProcedure.label","common_labels")%>'  style="visibility:hidden">&nbsp;
		
		</td>
		<td id='viewClinicalHistory' nowrap style="padding-left: 550px;">
			<a href="javascript:onclick=DummyRef()" id="clinical_err_histry" onclick="displayMenu()"  style="cursor:pointer" ><fmt:message key="eMR.ViewClinicalHistory.label" bundle="${mr_labels}"/></a>&nbsp;&nbsp;
		</td>
		<td colspan="1" id='errorHistory' style="display:none" nowrap>
			<img src='../../eCommon/images/view.gif '  style="cursor:pointer;"onclick="show_err_history('MRK_ERR')" alt="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewErrorHistory.label","mr_labels")%>" >&nbsp;&nbsp;
		</td>
		<td  id='exlucdeCodeHistory' style="display:none" nowrap>			
			<img src='../../eCommon/images/disabled.gif '  style="cursor:pointer;"onclick="show_err_history('EX_CODES')" alt="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.viewexcludedcodes.label","mr_labels")%>">&nbsp;&nbsp;
		</td>
	<td id='origerrorHistory' style="display:none" nowrap>
			<img src='../../eCommon/images/PI_SuspendedPatient.gif '  style="cursor:pointer;"onclick="show_err_history('ORIG_MRK_ERR')" alt="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.showerrorcodesbypractitioner.label","mr_labels")%>">&nbsp;&nbsp;
	</td>

		</tr>

		<table style="visibility:<%=hide_dataTable%>" border=0 width="100%" cellpadding='1' cellspacing='0'>

			<tr><td colspan='14' class='PANELTOOLBAR' id="Diag_icon"><a href="javascript:onclick=expandDiagnosis()"  style="visibility:<%=hide_exp%>">+</a>&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td></tr>
		<tr>&nbsp;</tr>
		<tr>
			<th align='center'>&nbsp;</th>
			<th align='center' >&nbsp;</th><!-- Addedd On 7/2/2009 -->
			<th align='center'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
			<th align='center'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align='center' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<%if(doctorsDescription){%>
			<th align='center' nowrap><fmt:message key="eMR.DoctorDesc.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</th>
			<%}%>
			<th align='center' ><fmt:message key="Common.Classification.label" bundle="${common_labels}"/></th>
			<th align='center' ><fmt:message key="eMR.CodedBy.label" bundle="${mr_labels}"/></th>
			<th align='center' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="eMP.CauseOfDeath.label" bundle="${mp_labels}"/></th> <!--modified by mujafar for ML-MMOH-CRF-1270 -->
		</tr>

		<%
		/*String New_EncounterId=EncounterId; //If allow_recode_diag_yn="Y"; 

			if(allow_recode_diag_yn.equals("N")){
				New_EncounterId="";
			} Note: Commented Code Was Implemented @@ Line:*/
		/*
		Commented On 4/21/2010 for PE Tuning
		String sql3="";
		sql3="select nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN from mr_parameter";
		pstmt = conn.prepareStatement(sql3);
		rs = pstmt.executeQuery();	
		String drg_yn="";
		while(rs.next()){
		drg_yn = checkForNull(rs.getString("DRG_CALCULATION_YN"));
		}*/
			if(mode.equals("Y")){
				if ( i % 2 == 0 )
					classValue = "gridData" ;
				else
					classValue = "gridData" ;
			
				/*String sql_hdr_sts="SELECT CURR_LEVEL,nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"'";

				
				pstmt = conn.prepareStatement(sql_hdr_sts);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					hdr_level=rs.getString("CURR_LEVEL");
					L1_hdr_status=rs.getString("LEVEL1_STATUS");
					L2_hdr_status=rs.getString("LEVEL2_STATUS");
					L3_hdr_status=rs.getString("LEVEL3_STATUS");
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();*/

				


				//if(cur_Sel.equals("1")){

					/// replaced all stage_no by cur_Sel
					//sql1.append("SELECT a.patient_id, a.orig_term_set_id,a.orig_term_code, a.term_set_id, a.term_code, b.short_desc,       am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,       TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time, a.cause_of_death,a.recode_status,decode(a.recode_status,'O','Review','N','NewCode','R','Recoded','F','Recoded')recodeStatus_desc,  STAGE_SRL_NO,stage_seq_no,group_YN,stage_no,confirm_yn FROM MR_DIAGNOSIS_RECODING_DTL a, mr_term_code b WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' and a.stage_no<="+cur_Sel+"  and a.active_YN='Y' AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code order by Stage_srl_no");
				//}else {  /// for level 2 handling

				

				
					//sql1.append("WITH tmp AS ( SELECT patient_id, orig_term_set_id, orig_term_code,term_set_id, term_code, practitioner_id, recorded_date_time, cause_of_death, recode_status,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn, active_yn FROM mr_diagnosis_recoding_dtl WHERE facility_id = '"+p_facility_id+"' AND encounter_id = '"+EncounterId+"' AND stage_no <= "+cur_Sel+") SELECT a.patient_id, a.orig_term_set_id, a.orig_term_code, a.term_set_id, a.term_code, b.short_desc, am_get_desc.am_practitioner(practitioner_id, 'en', '1') practitioner_name, TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time, a.cause_of_death, a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc, stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn FROM tmp a, mr_term_code b  WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code AND recode_status NOT IN('E', 'F') AND active_yn = 'Y' AND (a.term_code, stage_srl_no) NOT IN( SELECT m1.term_code, m1.stage_srl_no        FROM (SELECT * FROM tmp WHERE active_yn = 'Y') m1, (SELECT * FROM tmp WHERE active_yn = 'N') m2 WHERE m1.term_code = m2.term_code      AND m1.stage_srl_no < m2.stage_srl_no) ");

//					sql1.append("WITH tmp AS (SELECT patient_id, orig_term_set_id, orig_term_code,term_set_id, term_code, practitioner_id, recorded_date_time, cause_of_death, recode_status,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn, active_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,diag_class_code,remarks FROM mr_diagnosis_recoding_dtl WHERE facility_id = '"+p_facility_id+"' AND encounter_id = '"+New_EncounterId+"' AND stage_no  <= "+cur_Sel+") SELECT a.patient_id, a.orig_term_set_id, a.orig_term_code, a.term_set_id, a.term_code,b.short_desc,c.DIAG_CLASS_TYPE, am_get_desc.am_practitioner(practitioner_id, 'en', '1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yy hh24:mi') recorded_date_time,a.cause_of_death, a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,a.remarks,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification_code  FROM tmp a, mr_term_code b,MR_DIAG_CLASS c WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+) AND recode_status NOT IN('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN( SELECT m1.stage_srl_no FROM (SELECT term_code, stage_srl_no FROM tmp WHERE active_yn = 'Y') m1, (SELECT term_code, stage_srl_no FROM tmp WHERE active_yn = 'N' or confirm_yn = 'Y') m2 WHERE m1.term_code = m2.term_code AND m1.stage_srl_no < m2.stage_srl_no)");

//					CallableStatement main_cal_pstmt	=	null;
					String out_srl_no="";
					main_cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.GET_ACTIVE_CODES(?, ?, ?, ?, ?,?,?)}");
					main_cal_pstmt.setString( 1, "MR_DIAGNOSIS_RECODING_DTL");//Table Name
					main_cal_pstmt.setString( 2, p_facility_id);//Facility_ID
					main_cal_pstmt.setString( 3, New_EncounterId);//Encounter_ID
					main_cal_pstmt.setString( 4, cur_Sel);//Encounter_ID
					main_cal_pstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					main_cal_pstmt.setString( 6, ",");//Separator
					main_cal_pstmt.setString( 7, "D");//Procedure OT And Non OT Value 
					main_cal_pstmt.execute();
					out_srl_no=main_cal_pstmt.getString(5);


//					StringTokenizer his_out_srl_no	= new StringTokenizer(out_srl_no,",");


					/*Modified by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364*/
					sql1.append("SELECT a.patient_id, a.orig_term_set_id, a.orig_term_code, a.term_set_id, a.term_code,mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') short_desc,a.term_code_short_desc,b.free_text_yn,c.DIAG_CLASS_TYPE,b.dagger_independent_yn,b.cross_ref_type,a.occur_srl_no,b.long_desc,am_get_desc.am_practitioner(practitioner_id, '"+locale+"', '1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date_time,a.cause_of_death,a.death_reg_seq_no,a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,a.remarks,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification,decode (c.DIAG_CLASS_TYPE,'PD','1','CM','2','EC','4','CO','3','','5') diag_classification_grp, mr_get_desc.mr_diag_class (a.diag_class_code,'"+locale+"', '1') diag_class_long_desc, a.support_seq_no,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mc WHERE mc.TERM_SET_ID = a.term_set_id AND mc.term_code = a.term_code AND mc.CROSS_REF_TYPE = 'EQ') equiv_count,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct1 WHERE mct1.TERM_SET_ID = a.term_set_id AND mct1.TERM_CODE = a.term_code AND mct1.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct1.CROSS_REF_TYPE='AS' ) dgr_cnt,(SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct2 WHERE mct2.TERM_SET_ID = a.term_set_id AND Mct2.TERM_CODE = a.term_code AND mct2.EQUIVALENT_TERM_SET_ID = a.term_set_id AND mct2.CROSS_REF_TYPE='EC' ) conseq_cnt,DOCTORS_DESCRIPTION FROM mr_diagnosis_recoding_dtl a,mr_term_code b,MR_DIAG_CLASS c WHERE a.term_set_id = b.term_set_id AND a.term_code = b.term_code and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+) and a.facility_id = '"+p_facility_id+"' AND a.encounter_id = '"+New_EncounterId+"' AND a.stage_no  <= "+cur_Sel+" and a.stage_srl_no in ("+out_srl_no+") and a.status='A' ");//Query Was Modified On 1/28/2010  added DAGGER_INDEPENDENT_YN for SRR-CRF-303.2   
					//DOCTORS_DESCRIPTION Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269


					
					if(cur_Sel.equals("1") && L1_hdr_status.equals("A") || cur_Sel.equals("2") && L2_hdr_status.equals("A") || cur_Sel.equals("3") && L3_hdr_status.equals("A")){
						sql1.append("order by TRX_NO");
					}
				//}
				pstmt = conn.prepareStatement(sql1.toString());
				rs = pstmt.executeQuery();	
				//String inside_grp="N";
				String old_trm_cd="";
				//String old_tmpstr="";
				String diag_level_prc="";
				String srl_no_prc="";
				//String old_class="classValue";
				//String hist_stage_seq_no="";
				//String hist_stage_srl_no="";
				String orig_term_code_old="";
				String Group_seq_no="";

				String grp_trm_cd	 ="";
//				String prin_code="";
				String seq_yn	="";
				String remarks	="";
				String diag_class_code="";
				String show_eq_tmcd	=	"";
				String show_sprt_diag	=	"";
				String show_remarks	=	"";				
	String  remark_lbl			=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisRemarks.label","mr_labels"); // modified by mujafar for ML-MMOH-CRF-1270
				String  eqvi_code_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
				String spprt_dig_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SupportingDiagnosis.label","common_labels");
				String free_text_yn		=	"";// Added On 8/20/2009
				String death_reg_seq_no	=	"";// Added On 9/22/2009 For MDR death_reg_seq_no
				String associate_codes		=	"";//Added On 2/1/2010 ForSRR-CRF-303.2
				String support_seq_no		=	"";//Added On 2/1/2010 ForSRR-CRF-303.2
				String primary_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primary.label","common_labels");
				String related_lbl		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.related.label","mr_labels");
				String notrelated_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.notrelated.label","mr_labels");

				int equivalent_term_code_cnt = 0;
				int support_diag_cnt	=0;

				


		
				while(rs.next()){
					String diag_clas_lbl			=	"";
					String long_desc				= "";// Added For Site Enhancement On 3/11/2010
					String long_desc_params	= "";// Added For Site Enhancement On 3/11/2010
					String display_long_desc	= "none";// Added For Site Enhancement On 3/11/2010
					boolean modify_diag		=true;
					String supprt_diag_view	="E";//Added On 2/1/2010 ForSRR-CRF-303.2
					patient_id		= checkForNull(rs.getString("PATIENT_ID"));
					term_set		= checkForNull(rs.getString("TERM_SET_ID"));
					term_code	= checkForNull(rs.getString("TERM_CODE"));
//					out.println("term_code===>" +term_code)

					term_desc		= checkForNull(rs.getString("SHORT_DESC"));
					//term_desc="test";
					coded_date		= checkForNull(rs.getString("RECORDED_DATE_TIME"));
					coded_date		=DateUtils.convertDate(coded_date,"DMYHM" ,"en",locale);
					coded_by			= checkForNull(rs.getString("practitioner_name"));
					causeDeath		= checkForNull(rs.getString("CAUSE_OF_DEATH"));
					death_reg_seq_no	= checkForNull(rs.getString("death_reg_seq_no"));
					orig_term_set			=checkForNull(rs.getString("orig_term_set_id"));
					orig_term_code		= checkForNull(rs.getString("orig_term_code"));
					recodeStatus				= checkForNull(rs.getString("recode_status"));
					stg_srl_no					= checkForNull(rs.getString("STAGE_SRL_NO"));
					recodeStatus_desc	= checkForNull(rs.getString("recodeStatus_desc"));
					group_YN					= checkForNull(rs.getString("group_YN"));
					stage_seq_no			=checkForNull(rs.getString("stage_seq_no"));
					stage_no_disp			=checkForNull(rs.getString("stage_no"));
					confirm_yn				=checkForNull(rs.getString("confirm_yn"));
					Group_seq_no			=checkForNull(rs.getString("Group_seq_no"));
					seq_yn						=checkForNull(rs.getString("SEQUENCED_YN"));
					DIAG_CLASS_TYPE	=checkForNull(rs.getString("DIAG_CLASS_TYPE"));
					remarks						=checkForNull(rs.getString("remarks"));
					diag_class_code			=checkForNull(rs.getString("diag_classification"));
					dagger_independent_yn	= checkForNull(rs.getString("dagger_independent_yn"));
					cross_ref_type					= checkForNull(rs.getString("cross_ref_type"));
					occur_srl_no						= checkForNull(rs.getString("occur_srl_no"));
					support_seq_no				= checkForNull(rs.getString("support_seq_no"));
					free_text_yn						=checkForNull(rs.getString("free_text_yn"));// Added On 8/20/2009
					trx_no								=checkForNull(rs.getString("trx_no"));// Added On 23/Jan/2009
					long_desc							=checkForNull(rs.getString("long_desc"));// Added On 23/Jan/2009

					doctors_description	= checkForNull(rs.getString("doctors_description")); //Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269
					diag_class_long_desc = checkForNull(rs.getString("diag_class_long_desc")); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364

					equivalent_term_code_cnt=0;
					support_diag_cnt=0;

					equivalent_term_code_cnt=rs.getInt("equiv_count");  // done for PE. count query merged with the main query

					if(cross_ref_type.equals("D")){
						associate_codes		= "A";
						support_diag_cnt=rs.getInt("dgr_cnt");
					}else if(cross_ref_type.equals("C")){
						associate_codes		= "EC";
						support_diag_cnt=rs.getInt("conseq_cnt");
					}else{
						show_sprt_diag	="hidden";
						associate_codes	="";
					}

					

					if(free_text_yn.equals("Y")){
						term_desc = checkForNull(rs.getString("term_code_short_desc"));
					}
					
				if(isMultiDescAppl && term_set.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				{
				term_desc = checkForNull(rs.getString("term_code_short_desc"));
				if(term_desc.equals(""))
				term_desc		= checkForNull(rs.getString("SHORT_DESC"));
				}
				
					
					
					

					if(DIAG_CLASS_TYPE.equals("PD")){
						if(!Prin_diag.equals(term_code)){
							Prin_diag=term_code;
							prin_stg_srl_no=stg_srl_no;
						}
						prin_diag_cnt++;
				}
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
				
			//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
			if(isDiagClassLongDescAppl){
				diag_clas_lbl = diag_class_long_desc;
			}else
			{
				if(diag_class_code.equals("Principal")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.principal.label","mr_labels");
				}else if(diag_class_code.equals("Comorbidity")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.comorbidity.label","mr_labels");
				}else if(diag_class_code.equals("External Causes")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.externalcauses.label","mr_labels");
				}else if(diag_class_code.equals("Complication")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.complication.label","mr_labels");
				}else if(diag_class_code.equals("Others")){
					diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.others.label","mr_labels");
				}
			}
						if(recodeStatus.equals("N")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.newcode.label","mr_labels");//NewCode;
						}else if(recodeStatus.equals("O")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//For Original Code;
						}else if(recodeStatus.equals("R")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.recoded.label","mr_labels");//"Recoded";
						}

//					out.println("stage_no_disp====>" +stage_no_disp);
//					out.println("cur_Sel====>" +cur_Sel);
					if(group_YN.equals("Y")){// added for level 2 handling
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){// added for level 2 handling

							if(!grp_trm_cd.equals(term_code)){
								grp_trm_cd=term_code;
							}else{
								continue;
							}
						}

					}

					

					/*-----------------------*/
					
					/*int int_stg_no=Integer.parseInt(stage_no);
					int int_cur_sel=Integer.parseInt(cur_Sel);

					if(int_stg_no==int_cur_sel){
						if(int_stg_no==1){
							hdr_status=L1_hdr_status;
						}else if(int_stg_no==2){
							if(L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){ // aded 19/jun	
								if(L1_hdr_status.equals("A")){
									L2_hdr_status="A";								
								}
							}
							hdr_status=L2_hdr_status;
						}else if(int_stg_no==3){
							if(L3_hdr_status.equals("P")){ // aded 19/jun	
								if((L1_hdr_status.equals("A") && L2_hdr_status.equals("P")) || L2_hdr_status.equals("A")){
									L3_hdr_status="A";
									
								}
							}
							hdr_status=L3_hdr_status;
						}
							chk_disable="";
							if(hdr_status.equals("C")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
								chk_disable="disabled";
							}
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
								chk_disable="disabled";
							}
							if(hdr_status.equals("S")){
								if(confirm_yn.equals("Y")){
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");
									chk_disable="disabled";
								}else{
									chk_disable="";
								}
							}
							if(hdr_status.equals("R")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");
								chk_disable="";
							}
					}else{
						chk_disable="disabled";
						Lock_all="Y";
						if(int_cur_sel==1){
							hdr_status=L1_hdr_status;
						}else if(int_cur_sel==2){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P")){
									L2_hdr_status="A";
									
							 }
							hdr_status=L2_hdr_status;
						}
						
						if(hdr_status.equals("C")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
						}
						if(hdr_status.equals("A")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
						}
						if(hdr_status.equals("S")){
							if(confirm_yn.equals("Y")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");
							}
						}
						if(hdr_status.equals("R")){
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");
						}
						
					}*/

					/*----------------------*/
					
					if(cur_Sel.equals("1")){
						if(L1_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";

						}
						if(L1_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						hdr_status=L1_hdr_status; //Added on 7/2/2009
					}else if(cur_Sel.equals("2")){
						if(L2_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						if(L2_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						hdr_status=L2_hdr_status; //Added on 7/2/2009
					}else if(cur_Sel.equals("3")){
						if(L3_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						if(L3_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
							chk_disable="disabled";
							modify_diag=false;
							supprt_diag_view	 ="D";
						}
						hdr_status=L3_hdr_status;//Added on 7/1/2009
					}

					/*if(stage_no.equals("1")){  //Added on 7/2/2009
						if(!L2_hdr_status.equals("P") || !L3_hdr_status.equals("P")){				
							chk_disable="disabled";
							Lock_all="Y";
						}
						hdr_status=L1_hdr_status;
					}else if(stage_no.equals("2")){
						if( !L3_hdr_status.equals("P")){				
							chk_disable="disabled";
							Lock_all="Y";
						}
						hdr_status=L2_hdr_status;	
						
					}else if(stage_no.equals("3")){//Commented On 7/1/2009
						hdr_status=L3_hdr_status;
						
					}				
					*/
//					out.println("hdr_status==>" +hdr_status);
//					out.println("modify_diag==>" +modify_diag);

					if(!hdr_status.equals("C") ){
						
						if(!hdr_status.equals("A") ){

							if(confirm_yn.equals("Y")){
								if(Integer.parseInt(cur_Sel)==Integer.parseInt(stage_no_disp)){
									chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
//									recodeStatus_desc="Confirmed";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confirmed";

									
									if(Integer.parseInt(cur_Sel)<Integer.parseInt(stage_no)){
										
										if(cur_Sel.equals("1") && L1_hdr_status.equals("C")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("1")&& L1_hdr_status.equals("A")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("C")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("A")){
											recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";

										}

									}


								}
							}else{
								chk_disable="";
							}
						}
					}
					

					// for auth carryover.
					if(stage_no.equals(cur_Sel)){
//						out.println("stage_no==============>" +stage_no);
						if(stage_no.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P")){
									chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;
							}
							
						}

						if(stage_no.equals("3")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;

							}

							if(L2_hdr_status.equals("A") && L3_hdr_status.equals("P")){
								chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L2_hdr_status;
							}

						}

					}else{
						if(cur_Sel.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable="disabled";
									modify_diag=false;
									supprt_diag_view	 ="D";
									recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;

							}/*Added On 8/18/2009 for J.Mail*/
					}
				}
					//out.println("hdr_status==" +hdr_status);				
					// for auth carryover.
										
/*For EQUIVALENT_TERM_CODE*/
					//String sqlicd="SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+term_set+"' AND term_code = '"+term_code+"' AND CROSS_REF_TYPE = 'EQ'";
					//pstmt1 = conn.prepareStatement(sqlicd);
					//rs1	 = pstmt1.executeQuery();	
					//while(rs1.next()){
							//equivalent_term_code_cnt=rs1.getInt("COUNT");
					//}
					//if(pstmt1 != null) pstmt1.close();
					//if(rs1 != null) rs1.close();
/**Ends**/

/*For Support Diagnosis*/
		//String sql_sprt_diag="";
/*
		F.Y.I :Added on 1/28/2010 For SRR-CRF-303.2
		1.Based Upon the code indicator the supporting diagnosis icon will be open.
		2.Before this enhancement if the icon was clicked only the astrik codes are visible for the respective Dagger.
*/
				/*if(cross_ref_type.equals("D")){ 
//						show_sprt_diag	= "visible";
						associate_codes		= "A";
						sql_sprt_diag			=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE B,MR_TERM_CODE A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE ";
						pstmt1 = conn.prepareStatement(sql_sprt_diag);
						rs1	 = pstmt1.executeQuery();	
						while(rs1.next()){
								support_diag_cnt=rs1.getInt("COUNT");
						}
						if(pstmt1 != null) pstmt1.close();
						if(rs1 != null) rs1.close();

				}else if(cross_ref_type.equals("C")){
						associate_codes		= "EC";
						sql_sprt_diag			=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE B,MR_TERM_CODE A WHERE B.TERM_SET_ID = '"+term_set+"'AND B.TERM_CODE = '"+term_code+"'AND B.EQUIVALENT_TERM_SET_ID = '"+term_set+"' AND A.TERM_SET_ID=B.EQUIVALENT_TERM_SET_ID AND A.TERM_CODE=B.EQUIVALENT_TERM_CODE ";
						pstmt1 = conn.prepareStatement(sql_sprt_diag);
						rs1	 = pstmt1.executeQuery();	
						while(rs1.next()){
								support_diag_cnt=rs1.getInt("COUNT");
						}
						if(pstmt1 != null) pstmt1.close();
						if(rs1 != null) rs1.close();
				}else{
						show_sprt_diag	="hidden";
						associate_codes	="";
				}	
				*/
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

					if(group_YN.equals("X")){
						if(orig_term_code_old.equals("")){
							values_fetched=orig_term_code+","+term_code;
							orig_term_code_old=orig_term_code;
							//classValue="recodeDataY1";

						}else{
							if(orig_term_code_old.equals(orig_term_code)){
								values_fetched=values_fetched+","+term_code;
								//classValue="recodeDataY1";
							}else{
								values_fetched=values_fetched+"~"+orig_term_code+","+term_code;
								orig_term_code_old=orig_term_code;
								//classValue="recodeDataY1";
							}
							
						}
					}
					if(Integer.parseInt(hdr_level)>Integer.parseInt(cur_Sel) || Integer.parseInt(stage_no)>Integer.parseInt(cur_Sel) ){ // added for level 2 handling
						chk_disable="disabled";
						Lock_all="Y";
						supprt_diag_view ="D";
						
					}
//					String tmcode_srl_no=his_out_srl_no.nextToken();
					if(recodeStatus.equals("R")){  // recoded records
//							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.recoded.label","mr_labels");//"Recoded";
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){ // added for level 2 handling
//							recodeStatus_desc="Review";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
							final_diag_values=final_diag_values+i+"$"+term_code+"$"+term_set+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_term_code+"$"+Group_seq_no+"$"+confirm_yn+"$"+support_seq_no+"~";
							active_diag_codes=active_diag_codes+term_set+"$"+term_code+"~";
							
							%>
							<tr>
							<td class='<%=classValue%>'>&nbsp;
							<%if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){%>
								<input type="hidden" name="hdd_trx_no<%=seq_no%>" id="hdd_trx_no<%=seq_no%>" value="<%=trx_no%>">
								<select name='seqdiag<%=seq_no%>' id='seqdiag<%=seq_no%>' disabled onchange="validate_duplicate_diag(this,<%=seq_no%>)">
								</select>
							<%seq_no++;
							}%>
							</td>
							<td class='<%=classValue%>'>
								<img src='../../eCommon/images/EqivDiag.gif'  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=term_set%>","<%=term_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"><img src='../../eCommon/images/SuppDiag.gif'  style="cursor:pointer;visibility:<%=show_sprt_diag%>"onclick='recodeSupportDiagnosis("RECODE","<%=associate_codes%>","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=patient_id%>","<%=occur_srl_no%>","<%=cur_Sel%>","<%=support_seq_no%>","<%=Group_seq_no%>","<%=group_YN%>","<%=trx_no%>","<%=supprt_diag_view%>")' alt="<%=spprt_dig_lbl%>"><img src='../../eCommon/images/RecodeRemarks.gif'  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=stg_srl_no%>","N","","")' alt="<%=remark_lbl%>"><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
							</td>	<!-- Equalent Term Code,Support Diag&Remarks Images  -->
							
							<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
							<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=term_code%>$<%=term_set%>$<%=recodeStatus_desc%>$<%=stg_srl_no%>$<%=recodeStatus%>$<%=stage_no_disp%>$<%=group_YN%>$<%=orig_term_code%>$<%=Group_seq_no%>$<%=free_text_yn%>$<%=java.net.URLEncoder.encode(term_desc)%>~' onClick='enableSelect1(<%=i%>,this,document.forms[0].term_code.value)' <%=chk_disable%> ></td>
							
							
							<%
										if(recodeStatus_desc.equals("Recoded"))
										{ // added by mujafar for ML-MMOH-CRF-1270
												recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
										}
										else
										{
											recodeStatus_desc_temp = recodeStatus_desc;
										}
										%>
							
							
							
							
							<td class='<%=classValue%>'><%=recodeStatus_desc_temp%>
							<input type="hidden" name="Status<%=i%>" id="Status<%=i%>" value="<%=recodeStatus%>"></td>	<!-- Status -->				
							<%if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_diag){%>
							<td class='<%=classValue%>'><%=term_set%>&nbsp;/&nbsp;<a href="javascript:onclick=enableSelect1(<%=i%>,document.forms[0].select_chk1<%=i%>,document.forms[0].term_code.value,'<%=dagger_independent_yn%>','Modify')" ><%=term_code%></a>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->
							<%}else{%>
							<td class='<%=classValue%>'><%=term_set%>&nbsp;/&nbsp;<%=term_code%>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->
							<%}%>
						<!-- Added by Ajay Hatwate for ML-MMOH-CRF-1940 -->
						<%if(toolTip_diagnosis){%> 
							<td class="<%=classValue%>" onMouseOver="Tip(longDescToolTip('<%=term_code %>', '<%=long_desc %>'))" onMouseOut="UnTip()"><%=term_desc%></td>
						<%}else{%>
							<td class='<%=classValue%>'><%=term_desc%></td><!-- Diag.Desc -->
							<%} %>
							<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
							<%if(doctorsDescription){%>
							<td class='<%=classValue%>'>&nbsp;<%=doctors_description%></td>
							<%}%>
							<td class='<%=classValue%>'><%=diag_clas_lbl%>&nbsp;</td><!-- Diag Classification  -->
							<td class='<%=classValue%>'nowrap><%=coded_by%></td>
							<td class='<%=classValue%>'nowrap><%=coded_date%></td>
							<!-- FYI: Added On 9/22/2009 For MDR.  
								1.Based upon the MDR Cause Of Death the Images will be displayed for a diagnosis which is having the death_reg_seq_no=1 that is the Primary.
								2.The same approach is followed for Recoded Codes,History and Original Codes  also.
							-->
							<%if(causeDeath.equals("C")){
							String title="";
							if(death_reg_seq_no.equals("1")){
								 title=primary_lbl;
							}%>
								<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt="<%=title%>"/></td>
							<%}else if(causeDeath.equals("O")){%>
								<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/y-white.gif' alt="<%=related_lbl%>"/></td>
							<%}else if(causeDeath.equals("R")){%>
								<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif' alt="<%=notrelated_lbl%>"/></td>
							<%}else{%>
								<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif'/></td>
							<%}%>
							</tr>
							<%
							}else{

								if(!old_trm_cd.equals(term_code)){
									//out.println("term_code"+ term_code +"diag_level" +diag_level+"group_YN"+group_YN);
									if(group_YN.equals("Y")){  // commented on 3rd june
										classValue="recodeData";
									}else{
										classValue="gridData";
									}	

									//out.println("classValue" + classValue);
									%>
									<tr>
										<td id='recodeSymbol<%=i%>' class='<%=classValue%>'>&nbsp;
										<%if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){%>
											<input type="hidden" name="hdd_trx_no<%=seq_no%>" id="hdd_trx_no<%=seq_no%>" value="<%=trx_no%>">
											<select name='seqdiag<%=seq_no%>' id='seqdiag<%=seq_no%>' disabled onchange="validate_duplicate_diag(this,<%=seq_no%>)">
										</select>
										<%seq_no++;
										}else{
											if(!seq_yn.equals("H")){%>
												<a href="javascript:onclick=expandHist('<%=i%>')">+</a>
										<%  }
										}
										final_diag_values=final_diag_values+i+"$"+term_code+"$"+term_set+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_term_code+"$"+Group_seq_no+"$"+confirm_yn+"$"+support_seq_no+"~";
										active_diag_codes=active_diag_codes+term_set+"$"+term_code+"~";
										
										%>
										</td>
										<td class='<%=classValue%>'>
											<img src='../../eCommon/images/EqivDiag.gif'  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=term_set%>","<%=term_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"><img src='../../eCommon/images/SuppDiag.gif'  style="cursor:pointer;visibility:<%=show_sprt_diag%>"onclick='recodeSupportDiagnosis("RECODE","<%=associate_codes%>","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=patient_id%>","<%=occur_srl_no%>","<%=cur_Sel%>","<%=support_seq_no%>","<%=Group_seq_no%>","<%=group_YN%>","<%=trx_no%>","<%=supprt_diag_view%>")' alt="<%=spprt_dig_lbl%>"><img src='../../eCommon/images/RecodeRemarks.gif'  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=stg_srl_no%>","N","","")' alt="<%=remark_lbl%>"><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
										</td>	<!-- Equalent Term Code,Support Diag&Remarks Images  -->

										<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
										<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=term_code%>$<%=term_set%>$<%=recodeStatus_desc%>$<%=stg_srl_no%>$<%=recodeStatus%>$<%=stage_no_disp%>$<%=group_YN%>$<%=orig_term_code%>$<%=Group_seq_no%>$<%=free_text_yn%>$<%=java.net.URLEncoder.encode(term_desc)%>~'	
										onClick='enableSelect1(<%=i%>,this,document.forms[0].term_code.value)' <%=chk_disable%>></td>
										<%
										if(recodeStatus_desc.equals("Recoded"))
										{ // added by mujafar for ML-MMOH-CRF-1270
												recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
										}
										else
										{
											recodeStatus_desc_temp = recodeStatus_desc;
										}
										%>
										
										
										<td class='<%=classValue%>'><%=recodeStatus_desc_temp%>
										<input type="hidden" name="Status<%=i%>" id="Status<%=i%>" value="<%=recodeStatus%>"></td>	<!-- Status -->	
										<%if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_diag){%>
											<td class='<%=classValue%>' nowrap><%=term_set%>&nbsp;/&nbsp;<a href="javascript:onclick=enableSelect1(<%=i%>,document.forms[0].select_chk1<%=i%>,document.forms[0].term_code.value,'<%=dagger_independent_yn%>','Modify')" ><%=term_code%></a>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->
										<%}else{%>
											<td class='<%=classValue%>' nowrap><%=term_set%>&nbsp;/&nbsp;<%=term_code%>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->
										<%}
										if(toolTip_diagnosis){
										%>
							<td class="<%=classValue%>" onMouseOver="Tip(longDescToolTip('<%=term_code %>', '<%=long_desc %>'))" onMouseOut="UnTip()"><%=term_desc%></td>
										<%}else{ %>
										<td class='<%=classValue%>'><%=term_desc%></td><!-- Diag.Desc -->
										<%} %>
										<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
										<%if(doctorsDescription){%>
										<td class='<%=classValue%>'>&nbsp;<%=doctors_description%></td>
										<%}%>
										<td class='<%=classValue%>'><%=diag_clas_lbl%>&nbsp;</td><!-- Diag Classification  -->
										<td class='<%=classValue%>'nowrap><%=coded_by%></td>
										<td class='<%=classValue%>'nowrap><%=coded_date%></td>
										<!-- Added On 9/22/2009 For MDR -->
										<%if(causeDeath.equals("C")){
											String title="";
											if(death_reg_seq_no.equals("1")){
												 title=primary_lbl;
											}%>
											<td class='<%=classValue%>' >&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt="<%=title%>"/></td>
									<%}else if(causeDeath.equals("O")){%>
											<td class='<%=classValue%>' >&nbsp;<img src='../../eCommon/images/y-white.gif' alt="<%=related_lbl%>"/></td>
									<%}else if(causeDeath.equals("R")){%>
											<td class='<%=classValue%>' >&nbsp;<img src='../../eCommon/images/n-white.gif' alt="<%=notrelated_lbl%>"/></td>
										<%}else{%>
											<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif'/></td>
										<%}%>
										</tr>
										<tr>
										<td colspan=10 align="left" width="100%">
										<tbody id="recodehist<%=i%>" style='visibility:hidden;display:none'>
										<tr><td>
									<%								
									String term_chain="";
									String Srl_chain="";										
									try{
										CallableStatement cal_pstmt	=	null;
										cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.RECODE_NODE(?,?,?,?,?,?,?,?,?)}");
										cal_pstmt.setString( 1, "MR_DIAGNOSIS_RECODING_DTL");//Encounter_ID
										cal_pstmt.setString( 2, p_facility_id);//p_facility_id
										cal_pstmt.setString( 3, EncounterId);//Encounter_ID
										cal_pstmt.setString( 4, term_set);//term_set Added On 8/3/2009
										cal_pstmt.setString( 5, term_code);//Term_Code
										cal_pstmt.setString( 6, cur_Sel);//stage no
										cal_pstmt.setString( 7, stg_srl_no);//term_code_stage_srl_no which will be getting from the main Query
										cal_pstmt.registerOutParameter( 8,java.sql.Types.VARCHAR);
										cal_pstmt.registerOutParameter( 9,java.sql.Types.VARCHAR);
										cal_pstmt.execute();
										term_chain = cal_pstmt.getString(8);
										Srl_chain = cal_pstmt.getString(9);
										cal_pstmt.close();
									}catch ( Exception ex){
										ex.printStackTrace();
									}

									StringTokenizer stk_trm_chn=new StringTokenizer(term_chain,"$");
									StringTokenizer stk_srl_chn=new StringTokenizer(Srl_chain,"$");
									String hist_disp="";							
									

									int ikk=0;
									while(stk_trm_chn.hasMoreTokens()){
										StringTokenizer st_trm=new StringTokenizer(stk_trm_chn.nextToken(),",");
										StringTokenizer st_trm_srl=new StringTokenizer(stk_srl_chn.nextToken(),",");
//										out.println("<table width='100%' cellpadding=0 cellspacing=0 border=1>");
										hist_disp="";

										
										while(st_trm.hasMoreTokens()){
										
										
											String old_diaglevel="";
											int ijk=0;
											
											
											//diag_level_prc= stk_trm_chn.nextToken();
											diag_level_prc= st_trm.nextToken();
											//diag_level_prc=diag_level_prc.substring(0,diag_level_prc.length()-1);
											//srl_no_prc= stk_srl_chn.nextToken();
											srl_no_prc= st_trm_srl.nextToken();
											//srl_no_prc=srl_no_prc.substring(0,srl_no_prc.length()-1);								
											
											
											/*FYI:Query Was changed on 9/22/2009 for MDR to display cause_of_death based*/
											/*Modified by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364*/
											String sql_hist_det="SELECT a.orig_term_set_id,a.orig_term_code, a.term_set_id, a.term_code, mr_get_desc.mr_term_code(a.term_set_id,a.term_code,'"+locale+"','2') short_desc,b.free_text_yn,a.term_code_short_desc,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,TO_CHAR(a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date_time, a.cause_of_death,a.death_reg_seq_no,a.recode_status,decode(a.recode_status,'O','Review','N','Review','R','Review')recodeStatus_desc,  STAGE_SRL_NO,stage_seq_no,group_YN,group_seq_no,decode (c.DIAG_CLASS_TYPE,'PD','Principal','CM','Comorbidity','EC','External Causes','CO','Complication','','Others') diag_classification, mr_get_desc.mr_diag_class (a.diag_class_code,'"+locale+"', '1') diag_class_long_desc FROM MR_DIAGNOSIS_RECODING_DTL a, mr_term_code b,MR_DIAG_CLASS c WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' and a.term_code in("+diag_level_prc+") and stage_srl_no in ("+srl_no_prc+") and a.active_YN='N'  AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code and a.DIAG_CLASS_CODE=c.DIAG_CLASS_CODE (+) order by orig_term_code ,stage_srl_no desc";
											pstmt3 = conn.prepareStatement(sql_hist_det);
											rs3 = pstmt3.executeQuery();	
											String tmp_cd="";
											String his_diag_clas="";
											String recorded_date_time="";
											String free_text_yn1="";
											String short_desc1="";
											String cause_of_death_his=""; //Added On 9/22/2009 for MDR
											String death_reg_seq_no_his="";//Added On 9/22/2009 for MDR


											
											while(rs3.next()){
												String his_diag_clas_lbl="";
												tmp_cd=rs3.getString("term_code");
												his_diag_clas=checkForNull(rs3.getString("diag_classification"));
												diag_class_long_desc = checkForNull(rs3.getString("diag_class_long_desc")); //Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
												recorded_date_time=checkForNull(rs3.getString("recorded_date_time"));
												recorded_date_time=DateUtils.convertDate(recorded_date_time,"DMYHM" ,"en",locale);
												free_text_yn1=checkForNull(rs3.getString("free_text_yn"));
												if(free_text_yn1.equals("Y")){
													short_desc1=checkForNull(rs3.getString("term_code_short_desc"));
												}else{
													short_desc1=checkForNull(rs3.getString("short_desc"));
												}
												
				if(isMultiDescAppl && term_set.equals("ICD10") ) //  added by mujafar for ML-MMOH-CRF-1281
				{
				short_desc1 = checkForNull(rs3.getString("term_code_short_desc"));
				if(short_desc1.equals(""))
				short_desc1		= checkForNull(rs3.getString("SHORT_DESC"));
				}
												
												
												
												cause_of_death_his		=checkForNull(rs3.getString("cause_of_death"));
												death_reg_seq_no_his	=checkForNull(rs3.getString("death_reg_seq_no"));

												int diag_len=diag_level_prc.indexOf(",");

												if(group_YN.equals("X")){
													//out.println("diag_level" +diag_level);
													//out.println("old_diaglevel" +old_diaglevel);
													
													if(diag_len>0){
														if(old_diaglevel.equals("")){
															ijk++;
															//classValue="OAFORCED";
															old_diaglevel=diag_level_prc;
														}

														if(!diag_level_prc.equals(old_diaglevel)){
															ijk++;
															old_diaglevel=diag_level_prc;
															//classValue="OAYELLOW";
														}
														
														if ( ijk % 2 == 0 ){
															//classValue="recodeDataY1";
														}else{
															//classValue="recodeDataY2";
														}
													}

												}
											
											//Added by Ashwini on 14-Oct-2019 for ML-MMOH-CRF-1364
											if(isDiagClassLongDescAppl){
												his_diag_clas_lbl = diag_class_long_desc;
											}
											else
											{
												if(his_diag_clas.equals("Principal")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.principal.label","mr_labels");
												}else if(his_diag_clas.equals("Comorbidity")){
													diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.comorbidity.label","mr_labels");
												}else if(his_diag_clas.equals("External Causes")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.externalcauses.label","mr_labels");
												}else if(his_diag_clas.equals("Complication")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.complication.label","mr_labels");
												}else if(his_diag_clas.equals("Others")){
													his_diag_clas_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.others.label","mr_labels");
												}
											}

												if ( ikk % 2 == 0 ){
													hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap  align='left'>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' nowrap align='left'  ><b>"+checkForNull(rs3.getString("term_set_id"))+"</b>&nbsp;/&nbsp;<b>"+checkForNull(rs3.getString("term_code"))+"</b></td><td class='"+classValue+"' wrap align='left'><b>"+short_desc1+"</b></td>";
													
													/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
													if(doctorsDescription){
													hist_disp=hist_disp+"<td class='"+classValue+"' align='left'>&nbsp;</td>";
													}

													hist_disp=hist_disp+"<td class='"+classValue+"' align='left'><b>"+his_diag_clas_lbl+"</b>&nbsp;</td><td class='"+classValue+"' nowrap  align='left'><b>"+checkForNull(rs3.getString("practitioner_name"))+"</b></td><td  class='"+classValue+"' nowrap align='left' ><b>"+recorded_date_time+"</b></td>";
													/*Added on 9/22/2009 For MDR */
													if(cause_of_death_his.equals("C")){
															String title="";
															if(death_reg_seq_no_his.equals("1")){
																 title=primary_lbl;
															}
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt='"+title+"'/></td></tr>";
													}else if(cause_of_death_his.equals("O")){
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/y-white.gif' alt='"+related_lbl+"'/></td></tr>";
													}else if(cause_of_death_his.equals("R")){
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<b><img src='../../eCommon/images/n-white.gif' alt='"+notrelated_lbl+"'/></b></td></tr>";
													}else{
															hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<b><img src='../../eCommon/images/n-white.gif'/></b></td></tr>";
													}
												}else{
													hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap  align='left'>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' align='left' nowrap>"+checkForNull(rs3.getString("term_set_id"))+" &nbsp;/&nbsp;"+checkForNull(rs3.getString("term_code"))+"</td><td class='"+classValue+"' wrap align='left'>"+short_desc1+"</td>";

													/*Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269*/
													if(doctorsDescription){
													hist_disp=hist_disp+"<td class='"+classValue+"' align='left'>&nbsp;</td>";
													}
													
													hist_disp=hist_disp+"<td class='"+classValue+"' wrap  align='left'>"+his_diag_clas_lbl+"&nbsp;</td><td class='"+classValue+"' nowrap  align='left' >"+checkForNull(rs3.getString("practitioner_name"))+"</td><td  class='"+classValue+"' nowrap  align='left' >"+recorded_date_time+"</td>";
													if(cause_of_death_his.equals("C")){
														String title="";
														if(death_reg_seq_no_his.equals("1")){
															 title=primary_lbl;
														}
														hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt='"+title+"'/></td></tr>";
													}else if(cause_of_death_his.equals("O")){
														hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/y-white.gif' alt='"+related_lbl+"'/></td></tr>";
													}else if(cause_of_death_his.equals("R")){
														hist_disp=hist_disp+"<td class='"+classValue+"'  wrap align='left'>&nbsp;<img src='../../eCommon/images/n-white.gif' alt='"+notrelated_lbl+"'/></td></tr>";
													}else{
														hist_disp=hist_disp+"<td class='"+classValue+"' wrap align='left'>&nbsp;<img src='../../eCommon/images/n-white.gif'/></td></tr>";
													}
												}
											}
											/*Error Record To be Displayed */
										} // inner loop
										ikk++;
										out.println(hist_disp);
//										out.println("</table>");
									}  // outer loop

									%>
											</tbody>
										</td>
									</tr>
									<%
									old_trm_cd=term_code;
									classValue="gridData";
								}
						

						}



					}else{ // only original or new code
						
	
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){  // added for level 2 handling
//							recodeStatus_desc="Review";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
						}

						if(hdr_status.equals("A")){
							chk_disable="disabled";
//							recodeStatus_desc="Authorized";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
						}else if(hdr_status.equals("C")){
							chk_disable="disabled";
//							recodeStatus_desc="Completed";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";

						}
						
			


							%>
						<tr>
						<td class='<%=classValue%>'>&nbsp;
							<%if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){%>
							<input type="hidden" name="hdd_trx_no<%=seq_no%>" value="<%=trx_no%>">
							<select name='seqdiag<%=seq_no%>' disabled onchange="validate_duplicate_diag(this,<%=seq_no%>)">
							</select>
						<%
								seq_no++;
							}
							
						final_diag_values=final_diag_values+i+"$"+term_code+"$"+term_set+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_term_code+"$"+Group_seq_no+"$"+confirm_yn+"$"+support_seq_no+"~";
						active_diag_codes=active_diag_codes+term_set+"$"+term_code+"~";

						
						%>
						</td>
						<td class='<%=classValue%>'>
							<img src='../../eCommon/images/EqivDiag.gif'  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=term_set%>","<%=term_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"><img src='../../eCommon/images/SuppDiag.gif'  style="cursor:pointer;visibility:<%=show_sprt_diag%>"onclick='recodeSupportDiagnosis("RECODE","<%=associate_codes%>","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=patient_id%>","<%=occur_srl_no%>","<%=cur_Sel%>","<%=support_seq_no%>","<%=Group_seq_no%>","<%=group_YN%>","<%=trx_no%>","<%=supprt_diag_view%>")' alt="<%=spprt_dig_lbl%>"><img src='../../eCommon/images/RecodeRemarks.gif'  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=term_set%>","<%=term_code%>","<%=EncounterId%>","<%=stg_srl_no%>","N","","")' alt="<%=remark_lbl%>"><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="cursor:pointer;display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
						</td>	<!-- Equalent Term Code,Support Diag&Remarks Images  -->

						<!--Modified by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
						<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=term_code%>$<%=term_set%>$<%=recodeStatus_desc%>$<%=stg_srl_no%>$<%=recodeStatus%>$<%=stage_no_disp%>$<%=group_YN%>$<%=orig_term_code%>$<%=Group_seq_no%>$<%=free_text_yn%>$<%=java.net.URLEncoder.encode(term_desc)%>~' onClick='enableSelect1(<%=i%>,this,document.forms[0].term_code.value)' <%=chk_disable%> ></td>
						<%
										if(recodeStatus_desc.equals("Recoded"))
										{ // added by mujafar for ML-MMOH-CRF-1270
												recodeStatus_desc_temp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Coded.label","mr_labels");
										}
										else
										{
											recodeStatus_desc_temp = recodeStatus_desc;
										}
										%>
						<td class='<%=classValue%>'><%=recodeStatus_desc_temp%>
						<input type="hidden" name="Status<%=i%>" id="Status<%=i%>" value="<%=recodeStatus%>"></td>
						<%if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_diag){%>
						<td class='<%=classValue%>' nowrap><%=term_set%>&nbsp;/&nbsp;<a href="javascript:onclick=enableSelect1(<%=i%>,document.forms[0].select_chk1<%=i%>,document.forms[0].term_code.value,'<%=dagger_independent_yn%>','Modify')" ><%=term_code%></a>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->
					<%}else{%>
						<td class='<%=classValue%>'><%=term_set%>&nbsp;/&nbsp;<%=term_code%>&nbsp;<img src='../../eCommon/images/mandatory.gif' style='<%=disp_dagger_dep_ind%>'></td><!-- Term Set | Term Code & Dagger Independent Indicator-->
					<%}
						if(toolTip_diagnosis){%><!-- Added by Ajay Hatwate for ML-MMOH-CRF-1940  -->
							<td class="<%=classValue%>" onMouseOver="Tip(longDescToolTip('<%=term_code %>', '<%=long_desc %>'))" onMouseOut="UnTip()"><%=term_desc%></td>
						<%}else{ %>
						<td class='<%=classValue%>'><%=term_desc%></td><!-- Diag.Desc -->
						<%} %>
						<!--Added by Ashwini on 08-Jan-2019 for ML-MMOH-CRF-1269-->
						<%if(doctorsDescription){%>
						<td class='<%=classValue%>'>&nbsp;<%=doctors_description%></td>
						<%}%>
						<td class='<%=classValue%>'><%=diag_clas_lbl%>&nbsp;</td><!-- Diag Classification  -->
						<td class='<%=classValue%>'nowrap><%=coded_by%></td>
						<td class='<%=classValue%>'nowrap><%=coded_date%></td>
						<!-- Added On 9/22/2009 For MDR -->
						<%if(causeDeath.equals("C")){
								String title="";
								if(death_reg_seq_no.equals("1")){
									 title=primary_lbl;
								}%>
								<td class='<%=classValue%>' >&nbsp;<img src='../../eCommon/images/Y-Red.gif' alt="<%=title%>"/></td>
							<%}else if(causeDeath.equals("O")){%>
									<td class='<%=classValue%>' >&nbsp;<img src='../../eCommon/images/y-white.gif' alt='<%=related_lbl%>'/></td>
							<%}else if(causeDeath.equals("R")){%>
									<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif' alt='<%=notrelated_lbl%>'/></td>
							<%}else{%>
									<td class='<%=classValue%>'>&nbsp;<img src='../../eCommon/images/n-white.gif'/></td>
							<%}%>
						</tr>
						<%
						
					}




					


					i++;
				}// while loop
				if(main_cal_pstmt!=null)main_cal_pstmt.close();
				if(rs!=null)rs.close();
			}
		
		%>
		</table>

	</table>

				<input type='hidden' name='Stage_no' id='Stage_no' value='<%=Stage_no%>'>
				<input type='hidden' name='stage_no' id='stage_no' value='<%=Stage_no%>'>
				<input type='hidden' name='EncounterId' id='EncounterId' value='<%=EncounterId%>'>
				<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value='<%=loginUser%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=p_facility_id%>'>
				<input type='hidden' name='Pat_id' id='Pat_id' value='<%=Pat_id%>'>
				<input type='hidden' name='Patient_Class' id='Patient_Class' value='<%=Patient_Class%>'>
				<input type='hidden' name='term_code' id='term_code' value=''>
				<input type='hidden' name='i' id='i' value='<%=i%>'>
				<input type='hidden' name='checked_yn' id='checked_yn' value='N'>
				<input type='hidden' name='temp_chk' id='temp_chk' value='<%=temp_chk%>'>
				<input type='hidden' name='temp_code' id='temp_code' value='<%=temp_code%>'>
				<input type='hidden' name='dflt_termset' id='dflt_termset' value=''>
				<input type='hidden' name='gender' id='gender' value='<%=gender%>'>
				<input type='hidden' name='age' id='age' value='<%=age%>'>
				<input type='hidden' name='dob' id='dob' value='<%=dob%>'>
				<input type='hidden' name='spec_code' id='spec_code' value='<%=spec_code%>'>
				<input type='hidden' name='caused_death' id='caused_death' value=''>
				<input type='hidden' name='hd_term_set' id='hd_term_set' value=''>
				<input type='hidden' name='hd_term_code' id='hd_term_code' value=''>
				<input type="hidden" name="chk_yn" id="chk_yn" value="<%=chk_yn%>">	
				<input type='hidden' name='procedure_yn' id='procedure_yn' value=''>
				<input type='hidden' name='Lock_all' id='Lock_all' value='<%=Lock_all%>'>
				<input type='hidden' name='values_fetched' id='values_fetched' value='<%=values_fetched%>'>
				<input type='hidden' name='final_diag_values' id='final_diag_values' value='<%=final_diag_values%>'>
				<input type='hidden' name='active_diag_codes' id='active_diag_codes' value='<%=active_diag_codes%>'>
				<input type='hidden' name='activity' id='activity' value=''>
				<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value='<%=allow_recode_diag_yn%>'>
				<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn%>'>
				<input type='hidden' name='principal_diag' id='principal_diag' value='<%=Prin_diag%>'>
				<input type='hidden' name='prin_stg_srl_no' id='prin_stg_srl_no' value='<%=prin_stg_srl_no%>'>
				<input type='hidden' name='diag_seq_no' id='diag_seq_no' value='<%=seq_no%>'>
				<input type='hidden' name='modify_temp_code' id='modify_temp_code' value="">
				<input type='hidden' name='hid_free_text_yn' id='hid_free_text_yn' value="">
				<input type='hidden' name='diag_term_set_cnt' id='diag_term_set_cnt' value="0">
				<input type='hidden' name='prin_diag_cnt' id='prin_diag_cnt' value="<%=prin_diag_cnt%>">
				<!-- In Below line speciality added by venkatesh.s on 08-Dec-2015 against HAS-CRF-300 -->
				 <input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>"> 
				 <input type="hidden" name="isMultiDescAppl" id="isMultiDescAppl" value="<%=isMultiDescAppl%>"> <!-- added by mujafar for ML-MMOH-CRF-1281 -->
					   
				

			<%if(Lock_all.equals("Y")){%>
					<script>
						setTimeout('disableButtons()',150);						
//						disableButtons();
					</script>
					
			<%}%>

				<script>
					
					document.forms[0].show_level.options.selectedIndex='<%=cur_Sel%>';
					//setTimeout('disable_confirmed_Buttons()',150);
//					disable_confirmed_Buttons();
				</script>

		
	<%
	if(cur_Sel.equals("0")){%>
		<script>
		document.forms[0].show_level[0].options.selectedIndex=0;
		</script>
	<%}
	
     
String rej_diag="";
String rej_proc="";
int proc_count=0;
int diag_count=0;

String new_diag_btn="";
String new_proc_btn="";

if(!hdr_status.equals("A") && Integer.parseInt(hdr_level)>0){
	if( Integer.parseInt(cur_Sel)>0 && (Integer.parseInt(cur_Sel)==(Integer.parseInt(stage_no)-1))){
		

		/*String diag_count_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
			pstmt = conn.prepareStatement(diag_count_SQL);
			rs = pstmt.executeQuery();	
			while(rs.next()){
				diag_count = rs.getInt("COUNT");
				if(diag_count==0){
					new_diag_btn	="hidden";				
				}else{
					new_diag_btn="visible";
			}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		String proc_count_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
		pstmt = conn.prepareStatement(proc_count_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			proc_count = rs.getInt("COUNT");
			if(proc_count==0){
				new_proc_btn	="hidden";				
			}else{
				new_proc_btn="visible";
		}
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		diag_count=0;
		proc_count=0;
		if(new_diag_btn.equals("visible")){

			String diag_change_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"'";
				pstmt = conn.prepareStatement(diag_change_SQL);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					diag_count = rs.getInt("COUNT");
					if(diag_count==0){
						rej_diag	="Y";				
					}else{
						rej_diag="N";
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		
		if(new_proc_btn.equals("visible")){
			String proc_change_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"'";
				pstmt = conn.prepareStatement(proc_change_SQL);
				rs = pstmt.executeQuery();	
				while(rs.next()){
					proc_count = rs.getInt("COUNT");
					if(proc_count==0){
						rej_proc	="Y";				
					}else{
						rej_proc="N";
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();	
		}*/

		String diag_count_SQL	="SELECT (select COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"')cnt_1,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"')cnt_2,(SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"')cnt_3,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' and stage_no='"+stage_no+"')cnt_4 from dual";
		pstmt = conn.prepareStatement(diag_count_SQL);
		rs = pstmt.executeQuery();	

		if(rs !=null && rs.next()){

			diag_count = rs.getInt("cnt_1");
			if(diag_count==0){
				new_diag_btn	="hidden";				
			}else{
				new_diag_btn="visible";
			}

			proc_count = rs.getInt("cnt_2");
			if(proc_count==0){
				new_proc_btn	="hidden";				
			}else{
				new_proc_btn="visible";
			}

			diag_count=0;
			proc_count=0;
			if(new_diag_btn.equals("visible")){

				diag_count = rs.getInt("cnt_3");
				if(diag_count==0){
					rej_diag	="Y";				
				}else{
					rej_diag="N";
				}	
	
			}

			if(new_proc_btn.equals("visible")){

				proc_count = rs.getInt("cnt_4");
				if(proc_count==0){
					rej_proc	="Y";				
				}else{
					rej_proc="N";
				}
			}
		}

	}
}
if(rs != null) rs.close();
if(pstmt != null) pstmt.close();
if(allow_recode_diag_yn.equals("Y")){
if(rej_diag.equals("Y")){
	%>
	<script>
		document.forms[0].Reject_Diag.style.visibility="visible";
	</script>

	<%
	}
}
if(allow_recode_proc_yn.equals("Y")){
if(rej_proc.equals("Y")){
	%>
	<script>
		document.forms[0].Reject_Proc.style.visibility="visible";
	</script>

	<%
	}
}
//String disp_diagerr_his="";
//String disp_procerr_his="";
int diag_err_cnt=0;
int diag_excodes_cnt=0;
int proc_err_cnt=0;
int proc_excodes_cnt=0;
int diag_origerr_cnt=0;
int proc_origerr_cnt=0;


if(allow_recode_diag_yn.equals("Y")){
	//	String Diagerror_cnt_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
	/*String Diagerror_cnt_SQL	="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_DIAGNOSIS_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ) ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_DIAGNOSIS_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  EX_CODES_COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";
	pstmt = conn.prepareStatement(Diagerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		diag_err_cnt = rs.getInt("ERROR_STATUS_COUNT");
		diag_excodes_cnt = rs.getInt("EX_CODES_COUNT");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	String Diaf_origerr_cnt_SQL="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"'";				
	pstmt = conn.prepareStatement(Diaf_origerr_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		diag_origerr_cnt = rs.getInt("COUNT");
	}

	*/
	String Diagerror_cnt_SQL="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_DIAGNOSIS_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ) DIAG_ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_DIAGNOSIS_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  DIAG_EX_CODES_COUNT, (SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"') DIAG_ORIG_ERR_COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";
	pstmt = conn.prepareStatement(Diagerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	if(rs!=null && rs.next()){
		diag_err_cnt = rs.getInt("DIAG_ERROR_STATUS_COUNT");
		diag_excodes_cnt = rs.getInt("DIAG_EX_CODES_COUNT");
		diag_origerr_cnt = rs.getInt("DIAG_ORIG_ERR_COUNT");
	}



	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
}

if(allow_recode_proc_yn.equals("Y")){

	//	String Procerror_cnt_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE RECODE_STATUS='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ";
	/*String Procerror_cnt_SQL	="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_PROCEDURE_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' ) ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_PROCEDURE_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  EX_CODES_COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";

	pstmt = conn.prepareStatement(Procerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		proc_err_cnt = rs.getInt("ERROR_STATUS_COUNT");
		proc_excodes_cnt = rs.getInt("EX_CODES_COUNT");
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();	


	String Procerror_cnt_SQL="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"'";				

	pstmt = conn.prepareStatement(Procerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		proc_origerr_cnt = rs.getInt("COUNT");
	}
	*/

	String Procerror_cnt_SQL	="SELECT (SELECT COUNT (RECODE_STATUS) FROM MR_PROCEDURE_RECODING_DTL WHERE RECODE_STATUS='E'  AND FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"' ) PROC_ERROR_STATUS_COUNT, (SELECT COUNT (ERROR_DTL) FROM MR_PROCEDURE_RECODING_DTL  WHERE ERROR_DTL = 'X' AND FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' )  PROC_EX_CODES_COUNT,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE ERROR_DTL='E' AND  FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"') PROC_ORIG_ERR_COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+EncounterId+"' AND ROWNUM = 1";
	
	pstmt = conn.prepareStatement(Procerror_cnt_SQL);
	rs = pstmt.executeQuery();	
	while(rs.next()){
		proc_err_cnt = rs.getInt("PROC_ERROR_STATUS_COUNT");
		proc_excodes_cnt = rs.getInt("PROC_EX_CODES_COUNT");
		proc_origerr_cnt = rs.getInt("PROC_ORIG_ERR_COUNT");
	}

	
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();	

}
	if(diag_err_cnt>0 || proc_err_cnt>0){%>
		<script>
			document.getElementById("errorHistory").style.display="inline";
		</script>
<%}
	if(diag_excodes_cnt>0 || proc_excodes_cnt>0){%>
		<script>
			document.getElementById("exlucdeCodeHistory").style.display="inline";
		</script>
<%}
	if(diag_origerr_cnt>0 || proc_origerr_cnt>0){%>
		<script>
			document.getElementById("origerrorHistory").style.display="inline";
		</script>
<%}%>

		<input type="hidden" name="diag_err_cnt" id="diag_err_cnt" value="<%=diag_err_cnt%>">		
		<input type="hidden" name="proc_err_cnt" id="proc_err_cnt" value="<%=proc_err_cnt%>">
		<input type="hidden" name="diag_excodes_cnt" id="diag_excodes_cnt" value="<%=diag_excodes_cnt%>">
		<input type="hidden" name="proc_excodes_cnt" id="proc_excodes_cnt" value="<%=proc_excodes_cnt%>">
		<input type="hidden" name="diag_origerr_cnt" id="diag_origerr_cnt" value="<%=diag_origerr_cnt%>">
		<input type="hidden" name="proc_origerr_cnt" id="proc_origerr_cnt" value="<%=proc_origerr_cnt%>">
		<!--Added by Ashwini on 23-Jan-2019 for ML-MMOH-CRF-1272-->
		<input type="hidden" name="dischargeSummary" id="dischargeSummary" value="<%=dischargeSummary%>">
		<input type="hidden" name="accession_num" id="accession_num" value="<%=accession_num%>">

		<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
			<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
				<tr><td width='100%' id='t'></td></tr>
			</table>
		</div>	 
	</form>
	<%
}catch(Exception e){
	e.printStackTrace();
 }finally{
		if(main_cal_pstmt!=null)main_cal_pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);

 }

	%>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eOT/js/wz_tooltip.js'></script>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


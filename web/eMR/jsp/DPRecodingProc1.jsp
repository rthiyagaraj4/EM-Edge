<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%	
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 //String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
 //String loginUser		= (String) session.getValue( "login_user" );	
 String p_facility_id		= (String) session.getValue( "facility_id" ) ;
 String locale = (String)session.getAttribute("LOCALE"); 

 String EncounterId = request.getParameter("EncounterId");
 String Pat_id = checkForNull(request.getParameter("Pat_id"));
 String mode = checkForNull(request.getParameter("mode"));
 String dflt_termset = checkForNull(request.getParameter("dflt_termset"));
 String temp_proc = checkForNull(request.getParameter("temp_proc"));
 String Patient_Class = checkForNull(request.getParameter("Patient_Class"));
 String stage_no = checkForNull(request.getParameter("stage_no"));  
 String cur_Sel=checkForNull(request.getParameter("sel_val"));

String allow_recode_diag_yn				= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn				= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String allow_ot_proc_recode_yn			= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String drg_yn										= checkForNull((String)session.getAttribute("drg_calculation_yn"),"N");

 //String Pat_id = checkForNull(request.getParameter("Pat_id"));
 //String gender = checkForNull(request.getParameter("gender"));
// String age = checkForNull(request.getParameter("age"));
 //String dob = checkForNull(request.getParameter("dob"));
 //String spec_code = checkForNull(request.getParameter("spec_code"));
 //String DRGcal = checkForNull(request.getParameter("DRGcal"));
 //String drg_temp = checkForNull(request.getParameter("drg_temp"));
// String stage_l2 = checkForNull(request.getParameter("stage_l2"));
 //String sequenced_yn = checkForNull(request.getParameter("sequenced_yn"));
 //String tot_cnt = checkForNull(request.getParameter("tot_cnt"));
 //String recd_count="0";
 int Stage_no = 0;
 //int y=0;
//String chk_yn = "";

if(stage_no != "")
   Stage_no = Integer.parseInt(stage_no);

 if(mode.equals(""))
	mode="N";

if(cur_Sel.equals("")){
	cur_Sel=stage_no;
}

	Connection conn = null;	
	PreparedStatement pstmt			= null;
	PreparedStatement pstmt1		= null;
	PreparedStatement pstmt3		= null;
	CallableStatement main_cal_pstmt	=	null;
	ResultSet rs					= null;
	ResultSet rs1				= null;
	ResultSet rs3				= null;


try  {
	conn = ConnectionManager.getConnection(request);
	StringBuffer sql1 = new StringBuffer();
	String classValue = "";
	//String proc_set = "";
//	String proc_code = "";
//	String proc_desc = "";
	String coded_by = "";
	String coded_date = "";
	String causeDeath = "N";
	String recodeStatus = "";
	String stg_srl_no = "";
	//String hd_recodeStatus_disp = "";
	String patient_id = "";
	//String orig_term_set = "";
	//String orig_term_code = "";
	//String authorize_item = "";
	String p_episode_type = "";
	String temp_chk = "N";
	int equivalent_term_code_cnt = 0;
	//String nc_recodeStatus = "";
	//String nc_term_set = "";
	//String nc_term_code = "";
	//String nc_term_desc = "";
	//String nc_coded_by = "";
	//String nc_coded_date = "";
	//String nc_patient_id = "";
	//String nc_causeDeath = "N";
	String recodeStatus_desc="";
	String recodeStatus_desc_temp=""; // added by mujafar for ML-MMOH-CRF-1270
	//int nc_cnt=0;
	//String rev_flg="N";
	String group_YN="";
	String stage_seq_no="";
	//String tem_str="";
	String stage_no_disp="";
	String confirm_yn="";
	String chk_disable="";
	String Lock_all="";
	String values_fetched="";
	String final_proc_values="";
	String active_proc_codes="";
	String proc_trx_no="";



	int i = 0;
	int seq_no=0;
	//int cnt1 = 0;
	//int auth_cnt = 0;



	if(Patient_Class.equals("IP"))
		p_episode_type="I";
	else if(Patient_Class.equals("EM"))
		p_episode_type="E";
	else if(Patient_Class.equals("DC"))
		p_episode_type="D";
	else if(Patient_Class.equals("OP"))
		p_episode_type="O";

String hide_exp="";
String hide_dataTable="";
String p_proc_filter  ="";
String New_EncounterId="";
String  pat_visit_dt_time="";// Added On 12/11/2009
String  pat_disch_dt_time="";// Added On 12/11/2009


/*Note:Based upon the  allow_recode_diag_yn value(Parameter Setup) 
the perticular part is hiding to Display Only Procedure Part To User*/
	if(allow_recode_proc_yn.equals("Y")){
		hide_dataTable	=	"visible";
		New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y"
	if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
		p_proc_filter ="B";
	}else if(allow_ot_proc_recode_yn.equals("Y")){
		p_proc_filter	="O";
	}else if(allow_non_ot_proc_recode_yn.equals("Y")){
		p_proc_filter	="N";
	}
}else{
		hide_dataTable	=	"hidden";
		New_EncounterId="";
	}
	if(allow_recode_diag_yn.equals("Y")){
		hide_exp	=	"visible";
	}else{
		hide_exp	=	"hidden";
	}

			/******Ends******/


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
//			parent.RecodeScreen.rows="47%,47%,0%,0%";
					var allow_recode_diag_yn	= document.forms[0].all.allow_recode_diag_yn.value;
					var allow_recode_proc_yn	= document.forms[0].all.allow_recode_proc_yn.value;
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
//					alert(final_proc_values)
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


		function expandProcedure(){
//			parent.RecodeScreen.rows="48%,48%,4%,0%";
			/* parent.RecodeScreen.rows="13%,85%,5%,0%"; */
			parent.document.getElementById("DiagProcRecodingPatDetail").style.height="18vh";
			parent.document.getElementById("RecDiagnosisDiag").style.height="22vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="49vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
			parent.document.getElementById("DiagProcTrans").style.height="0vh";
			parent.frames[2].document.getElementById("Diag_icon").innerHTML="<a href='javascript:onclick=expandDiagnosis()'>+</a><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>";
			parent.frames[3].document.getElementById("Proc_icon").innerHTML="<a href='javascript:onclick=collapseProcedure()'>-</a><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>";
		}

		function collapseProcedure(){
//			parent.RecodeScreen.rows="40%,40%,5%";
			/* parent.RecodeScreen.rows="48%,48%,4%,0%"; */
			parent.document.getElementById("DiagProcRecodingPatDetail").style.height="33vh";
			parent.document.getElementById("RecDiagnosisDiag").style.height="37vh";
			parent.document.getElementById("RecDiagnosisProc").style.height="45vh";
			parent.document.getElementById("RecDiagnosisButton").style.height="5vh";
			parent.document.getElementById("DiagProcTrans").style.height="0vh";
			parent.frames[3].document.getElementById("Proc_icon").innerHTML="<a href='javascript:onclick=expandProcedure()'>+</a><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>";

		}

		/*function expandRecode(i){
			//alert("expandRecode "+i);
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.visibility='visible';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.display='inline';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol"+i).innerHTML="<a href='javascript:onclick=collapseRecode("+i+")'>-</a>";
		}

		function collapseRecode(i){
			//alert("collapseRecode "+i);
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.visibility='hidden';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recode1"+i).style.display='none';
			eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol"+i).innerHTML="<a href='javascript:onclick=expandRecode("+i+")'>+</a>";
		}*/
		function expandHist(i)	{
		var sel=i;
//		var len=eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist"+parseInt(sel)).length;
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist"+parseInt(sel)).style.visibility='visible';
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist"+parseInt(sel)).style.display='inline';
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol"+parseInt(sel)).innerHTML="<a href='javascript:onclick=collapseHist("+parseInt(sel)+")'>-</a>";
	}

	function collapseHist(i)	{
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist"+parseInt(i)).style.visibility='hidden';
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodehist"+parseInt(i)).style.display='none';
		eval("parent.frames[3].document.RecodeDiagnosisProcDetail.all.recodeSymbol"+parseInt(i)).innerHTML="<a href='javascript:onclick=expandHist("+parseInt(i)+")'>+</a>";
	}

	</script>
</head>
<body onKeyDown='lockKey()' >
	<form name="RecodeDiagnosisProcDetail" id="RecodeDiagnosisProcDetail" method='post' >

		<table border='0' cellpadding='1' cellspacing='0' width="93%"  valign='top' style="visibility:<%=hide_dataTable%>">
		<tr><td colspan='13' class='PANELTOOLBAR' id="Proc_icon"><a href="javascript:onclick=expandProcedure()" style="visibility:<%=hide_exp%>">+</a>&nbsp;<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td></tr>
		<tr>&nbsp;</tr>

		<tr>
			<th align='center'>&nbsp;</th>
			<th align='center'>&nbsp;</th><!-- Added On 7/2/2009 -->
			<th align='center'><fmt:message key="eMR.Select.label" bundle="${mr_labels}"/></th>
			<th align='center'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			<th align='center'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th><!-- Added On 7/8/2009 -->
			<th align='center' ><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Ext.label" bundle="${common_labels}"/> </th><!-- Added On 7/8/2009 -->
<!-- 			<th align='center'><fmt:message key="Common.details.label" bundle="${common_labels}"/></th></th>  Added 7/2/2009-->			
			<th align='center' nowrap><fmt:message key="eMR.CodedBy.label" bundle="${mr_labels}"/></th>
			<th align='center'><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
			<th align='center'><fmt:message key="eCA.Laterality.label" bundle="${ca_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>

<!-- 			<th align='center' ><fmt:message key="eMR.CausedDeath.label" bundle="${mr_labels}"/></th>
 -->		</tr>
		<%
	 		
			/*String New_EncounterId=EncounterId;//If allow_recode_proc_yn="Y";
			if(allow_recode_proc_yn.equals("N")){
				New_EncounterId="";
			} Note: The Commented Code was Implemented @@133 Line No:*/
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
			
				//sql1.append("SELECT A.PATIENT_ID,A.TERM_SET_ID,A.TERM_CODE, B.SHORT_DESC, am_get_desc.AM_PRACTITIONER(A.PRACTITIONER_ID,'"+locale+"','1') practitioner_name, TO_CHAR (A.RECORDED_DATE_TIME, 'dd/mm/yy hh24:mi') RECORDED_DATE_TIME, 	A.CAUSE_OF_DEATH_YN FROM PR_DIAGNOSIS_ENC_DTL A,MR_TERM_CODE B WHERE A.FACILITY_ID = '"+p_facility_id+"' AND A.ENCOUNTER_ID = '"+EncounterId+"' AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_CODE = B.TERM_CODE");
				String hdr_status ="";
				String L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
				String L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
				String L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
				String hdr_level			= checkForNull(request.getParameter("curr_level"));;
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

//				sql1.append("WITH tmp AS (SELECT patient_id, orig_proc_code_scheme, orig_proc_code,decode(laterality_ind,'L','Left','R','Right','B','Both','N','Not Applicable') laterality_ind ,proc_code_scheme, proc_code, practitioner_id, proc_date, recode_status,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn, active_yn,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,REMARKS  FROM mr_procedure_recoding_dtl WHERE facility_id = '"+p_facility_id+"' AND encounter_id = '"+New_EncounterId+"' AND stage_no  <= "+cur_Sel+") SELECT a.patient_id, a.orig_proc_code_scheme, a.orig_proc_code, a.proc_code_scheme, a.proc_code,b.short_desc, am_get_desc.am_practitioner(practitioner_id, 'en', '1') practitioner_name,TO_CHAR(a.proc_date, 'dd/mm/yy hh24:mi') recorded_date_time,a.recode_status,DECODE(a.recode_status, 'O', 'Review', 'N', 'NewCode', 'R', 'Recoded') recodestatus_desc,stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,a.laterality_ind,nvl(group_seq_no,'0') group_seq_no,SEQUENCED_YN,TRX_NO,a.remarks  FROM tmp a, mr_term_code b WHERE a.proc_code_scheme = b.term_set_id AND a.proc_code = b.term_code AND recode_status NOT IN('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN( SELECT m1.stage_srl_no FROM (SELECT proc_code, stage_srl_no FROM tmp WHERE active_yn = 'Y') m1, (SELECT proc_code, stage_srl_no FROM tmp WHERE active_yn = 'N' or confirm_yn = 'Y') m2 WHERE m1.proc_code = m2.proc_code AND m1.stage_srl_no < m2.stage_srl_no) ");

				//sql1.append("WITH tmp AS (SELECT patient_id, orig_proc_code_scheme, orig_proc_code, decode(laterality_ind,'L','Left','R','Right','B','Both','N','Not Applicable') laterality_ind, proc_code_scheme, proc_code, practitioner_id,proc_date, recode_status, stage_srl_no, stage_seq_no, group_yn,stage_no, confirm_yn, active_yn,NVL (group_seq_no, '0') group_seq_no, sequenced_yn, trx_no  FROM mr_procedure_recoding_dtl  WHERE facility_id = '"+p_facility_id+"'  AND encounter_id = '"+EncounterId+"' AND stage_no <= "+cur_Sel+" )SELECT a.patient_id, a.orig_proc_code_scheme, a.orig_proc_code, a.proc_code_scheme, a.proc_code, b.short_desc,a.active_yn, am_get_desc.am_practitioner (practitioner_id,'en','1') practitioner_name,practitioner_id,TO_CHAR (a.proc_date, 'dd/mm/yy hh24:mi') recorded_date_time,a.recode_status,DECODE (a.recode_status,'O', 'Review','N', 'NewCode','R', 'Recoded') recodestatus_desc,       stage_srl_no, stage_seq_no, group_yn, stage_no, confirm_yn,a.laterality_ind, NVL (group_seq_no, '0') group_seq_no, sequenced_yn,       trx_no FROM tmp a, mr_term_code b WHERE a.proc_code_scheme = b.term_set_id  AND a.proc_code = b.term_code AND recode_status NOT IN ('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN ( SELECT m1.stage_srl_no FROM (SELECT proc_code, stage_srl_no,recode_status             FROM tmp WHERE active_yn = 'Y' order by stage_srl_no) m1 WHERE m1.stage_srl_no < (select max(stage_srl_no) from tmp where proc_code = m1.proc_code and active_yn = 'N' OR confirm_yn = 'Y') AND m1.recode_status !='O') ");
					String out_srl_no="";
					main_cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.GET_ACTIVE_CODES(?, ?, ?, ?, ?,?,?)}");
					main_cal_pstmt.setString( 1, "MR_PROCEDURE_RECODING_DTL");//Table Name
					main_cal_pstmt.setString( 2, p_facility_id);//Facility_ID
					main_cal_pstmt.setString( 3, New_EncounterId);//Encounter_ID
					main_cal_pstmt.setString( 4, cur_Sel);//Encounter_ID
					main_cal_pstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
					main_cal_pstmt.setString( 6, ",");//Separator
					main_cal_pstmt.setString( 7, p_proc_filter);//Procedure OT And Non OT Value 
					main_cal_pstmt.execute();
					out_srl_no=main_cal_pstmt.getString(5);
//					StringTokenizer his_out_srl_no	= new StringTokenizer(out_srl_no,",");
				
					sql1.append("SELECT a.patient_id, a.orig_proc_code_scheme, a.orig_proc_code, a.proc_code_scheme, a.proc_code, mr_get_desc.mr_term_code(a.proc_code_scheme,a.proc_code,'"+locale+"','2') short_desc,b.long_desc,a.active_yn, am_get_desc.am_practitioner (practitioner_id,'"+locale+"','1') practitioner_name,practitioner_id,TO_CHAR (a.proc_date, 'dd/mm/yyyy hh24:mi') recorded_date_time,a.recode_status,DECODE (a.recode_status,'O', 'Review','N', 'NewCode','R', 'Recoded') recodestatus_desc,       a.stage_srl_no, a.stage_seq_no,a. group_yn, a.stage_no, a.confirm_yn,decode(a.laterality_ind,'L','Left','R','Right','B','Both','N','NotApplicable') desc_laterality_ind,laterality_ind, NVL (a.group_seq_no, '0') group_seq_no, a.sequenced_yn,a.remarks,a.trx_no,a.contr_mod_id,to_char(a.proc_checkin_start_date_time,'dd/mm/yyyy hh24:mi')proc_checkin_start_date_time,to_char(a.proc_checkout_end_date_time,'dd/mm/yyyy hh24:mi')proc_checkout_end_date_time,to_char(c.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time,to_char(c.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time,( SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE mct WHERE mct.TERM_SET_ID = a.proc_code_scheme AND mct.term_code = a.proc_code AND mct.CROSS_REF_TYPE = 'EQ')equiv_count,a.ACCESSION_NUM ,a.CODE_EXTN_YN,a.CODE_EXTN_DTL FROM mr_procedure_recoding_dtl a, mr_term_code b,pr_encounter c WHERE a.proc_code_scheme = b.term_set_id  AND a.proc_code = b.term_code AND a.facility_id = '"+p_facility_id+"'  AND a.encounter_id = '"+EncounterId+"' AND a.encounter_id=c.encounter_id AND a.stage_no <= "+cur_Sel+" and a.stage_srl_no in ("+out_srl_no+") " );
					
					//recode_status NOT IN ('E', 'F') AND active_yn = 'Y' AND (stage_srl_no) NOT IN ( SELECT m1.stage_srl_no FROM (SELECT proc_code, stage_srl_no,recode_status             FROM tmp WHERE active_yn = 'Y' order by stage_srl_no) m1 WHERE m1.stage_srl_no < (select max(stage_srl_no) from tmp where proc_code = m1.proc_code and active_yn = 'N' OR confirm_yn = 'Y') AND m1.recode_status !='O') ");

					//WITH tmp AS (SELECT patient_id, orig_proc_code_scheme, orig_proc_code, decode(laterality_ind,'L','Left','R','Right','B','Both','N','Not Applicable') laterality_ind, proc_code_scheme, proc_code, practitioner_id,proc_date, recode_status, stage_srl_no, stage_seq_no, group_yn,stage_no, confirm_yn, active_yn,NVL (group_seq_no, '0') group_seq_no, sequenced_yn, trx_no  FROM mr_procedure_recoding_dtl  WHERE facility_id = '"+p_facility_id+"'  AND encounter_id = '"+EncounterId+"' AND stage_no <= "+cur_Sel+" )
			
					if(cur_Sel.equals("1") && L1_hdr_status.equals("A") || cur_Sel.equals("2") && L2_hdr_status.equals("A") || cur_Sel.equals("3") && L3_hdr_status.equals("A")){
						sql1.append("order by TRX_NO");
					}else{
						sql1.append("order by a.contr_mod_id desc");
					}
					pstmt = conn.prepareStatement(sql1.toString());
					rs = pstmt.executeQuery();	

				String old_trm_cd					="";
				String diag_level_prc				="";
				String srl_no_prc					="";
				String orig_term_code_old	="";
				String  proc_code_scheme	="";
				String  proc_code					="";
				String  proc_desc					="";
				String  orig_proc_code_scheme="";
				String  orig_proc_code			="";
				String  laterality_ind				="";
				String Group_seq_no			="";
				String seq_yn						="";
				String grp_trm_cd					="";
				String remarks						="";
				String contr_mod_id				="";// Added On 7/8/2009
				String show_eq_tmcd			="";
				String show_remarks			="";
				String proc_type					="";// Added On 7/8/2009
				String  accession_num			="";// Added On 7/8/2009
				String  code_extn_yn			="";// Added On 7/8/2009
				String  code_extn_dtl			="";// Added On 7/8/2009
				String show_accesion			="";// Added On 7/8/2009
//				boolean disp_ot=false;// Added On 7/8/2009
				String  db_accession_num		="";// Added On 7/10/2009
				String  db_code_extn_dtl		="";// Added On 7/10/2009
				String  db_laterality_ind		="";// Added On 12/12/2009.
				String  proc_srt_dt_time	="";// Added On 12/12/2009.
				String  proc_end_dt_time		="";// Added On 12/12/2009.
				String  db_proc_srt_dt_time			="";// Added On 12/14/2009.
				String  db_proc_end_dt_time		="";// Added On 12/14/2009.
				String  code_laterality_ind		="";// Added On 12/14/2009.
			String  remark_lbl	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisRemarks.label","mr_labels"); // modified by mujafar for ML-MMOH-CRF-1270
				String  eqvi_code_lbl			=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.EquivalentTermSetCode.label","mr_labels");
				String  order_cat_lbl				=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ordercatalog.label","common_labels");
				while(rs.next()){
					String  latind_lbl			="";
					String long_desc			= "";// Added For Site Enhancement On 3/11/2010
					String long_desc_params	= "";// Added For Site Enhancement On 3/11/2010
					String display_long_desc	= "none";// Added For Site Enhancement On 3/11/2010
					boolean modify_proc	=	true;// Added On 7/8/2009
					patient_id						= checkForNull(rs.getString("patient_id"));
					proc_code_scheme		= checkForNull(rs.getString("proc_code_scheme"));
					proc_code					= checkForNull(rs.getString("proc_code"));
					proc_desc					= checkForNull(rs.getString("SHORT_DESC"));
					coded_date					= checkForNull(rs.getString("recorded_date_time"));
					coded_date					=DateUtils.convertDate(coded_date,"DMYHM" ,"en",locale);
					coded_by						= checkForNull(rs.getString("practitioner_name"));
					orig_proc_code_scheme	=checkForNull(rs.getString("orig_proc_code_scheme"));
					orig_proc_code				= checkForNull(rs.getString("orig_proc_code"));
					recodeStatus						= checkForNull(rs.getString("recode_status"));
					stg_srl_no							= checkForNull(rs.getString("stage_srl_no"));
					recodeStatus_desc			= checkForNull(rs.getString("recodeStatus_desc"));
					group_YN							= checkForNull(rs.getString("group_YN"));
					stage_seq_no					=checkForNull(rs.getString("stage_seq_no"));
					stage_no_disp					=checkForNull(rs.getString("stage_no"));
					confirm_yn						=checkForNull(rs.getString("confirm_yn"));
					laterality_ind						= checkForNull(rs.getString("desc_laterality_ind"));
					code_laterality_ind			= checkForNull(rs.getString("laterality_ind"));
					Group_seq_no					= checkForNull(rs.getString("group_seq_no"));
					seq_yn								=checkForNull(rs.getString("SEQUENCED_YN"));
					remarks							=checkForNull(rs.getString("REMARKS"));
					contr_mod_id					=checkForNull(rs.getString("contr_mod_id"),"XT");//When contr_mod_id  is Empty(Null). XT is The Default Value Of  contr_mod_id. For Tokenizing Purpose. Added On 7/8/2009;
					pat_visit_dt_time				= checkForNull(rs.getString("visit_adm_date_time"));//Added On 12/14/2009 for SRR-CRF-303.1
					pat_disch_dt_time			= checkForNull(rs.getString("discharge_date_time"));//Added On 12/14/2009 for SRR-CRF-303.1
					proc_srt_dt_time				= checkForNull(rs.getString("proc_checkin_start_date_time"));
					proc_srt_dt_time				= DateUtils.convertDate(proc_srt_dt_time,"DMYHM" ,"en",locale);//Date conversion to Thai
					proc_end_dt_time			= checkForNull(rs.getString("proc_checkout_end_date_time"));
					proc_end_dt_time			= DateUtils.convertDate(proc_end_dt_time,"DMYHM" ,"en",locale);//Date conversion to Thai
					proc_trx_no						= checkForNull(rs.getString("trx_no")); // added on 23 Jan 2010
					long_desc							= checkForNull(rs.getString("long_desc")); // added on 23 Jan 2010

					equivalent_term_code_cnt	=	rs.getInt("equiv_count");
					accession_num	= checkForNull(rs.getString("ACCESSION_NUM"));//Default For Tokenizing 
					code_extn_yn	= checkForNull(rs.getString("CODE_EXTN_YN"));
					code_extn_dtl	= checkForNull(rs.getString("CODE_EXTN_DTL"));//Default For Tokenizing


						if(recodeStatus.equals("N")){
							recodeStatus_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.newcode.label","mr_labels");//NewCode;
						}else if(recodeStatus.equals("O")){
							recodeStatus_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//For Original Code;
						}else if(recodeStatus.equals("R")){
							recodeStatus_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.recoded.label","mr_labels");//"Recoded";
						}
						if(laterality_ind.equals("Left")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
						}else if(laterality_ind.equals("Right")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
						}else if(laterality_ind.equals("Both")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
						}else if(laterality_ind.equals("NotApplicable")){
							latind_lbl				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						}
					if(group_YN.equals("Y")){// added for level 2 handling
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){// added for level 2 handling
							if(!grp_trm_cd.equals(proc_code)){
								grp_trm_cd=proc_code;
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
						
					}
					*/

					/*----------------------*/
					if(cur_Sel.equals("1")){
						if(L1_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable				= "disabled";
							modify_proc				= false;
						}
						if(L1_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable				= "disabled";
							modify_proc				= false;
						}
						hdr_status=L1_hdr_status; //Added On 7/1/2009

					}else if(cur_Sel.equals("2")){
						if(L2_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						if(L2_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						hdr_status=L2_hdr_status; //Added On 7/1/2009
					}else if(cur_Sel.equals("3")){
						if(L3_hdr_status.equals("C")){
//							recodeStatus_desc="Completed";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						if(L3_hdr_status.equals("A")){
//							recodeStatus_desc="Authorized";
							recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");
							chk_disable				= "disabled";
							modify_proc				= false;

						}
						hdr_status	= L3_hdr_status; //Added On 7/1/2009
					}

				/*	if(stage_no.equals("1")){
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
						
					}else if(stage_no.equals("3")){
						hdr_status=L3_hdr_status;
						
					}*/

					//out.println("hdr_status" + hdr_status);

					if(!hdr_status.equals("C") ){
						if(!hdr_status.equals("A") ){
							if(confirm_yn.equals("Y")){
								if(Integer.parseInt(cur_Sel)==Integer.parseInt(stage_no_disp)){
									chk_disable			 =	"disabled";
//									recodeStatus_desc="Confirmed";
									recodeStatus_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confirmed";
									modify_proc	 = false;
									if(Integer.parseInt(cur_Sel)<Integer.parseInt(stage_no)){
										if(cur_Sel.equals("1") && L1_hdr_status.equals("C")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("1")&& L1_hdr_status.equals("A")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("C")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Confirmed";
										}else if(cur_Sel.equals("2")&& L2_hdr_status.equals("A")){
											recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Confirmed";
										}
									}
								}
							}else{
								chk_disable	=	"";
							}
						}
					}
					// for auth carryover.
					if(stage_no.equals(cur_Sel)){
						if(stage_no.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P")){
									chk_disable				=	"disabled";
									modify_proc				=	false;
									recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
									hdr_status=L1_hdr_status;
							}
						}
						if(stage_no.equals("3")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable				=	"disabled";
								modify_proc				= false;
								recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
								hdr_status				= L1_hdr_status;

							}

							if(L2_hdr_status.equals("A") && L3_hdr_status.equals("P")){
								chk_disable				= "disabled";
								modify_proc				= false;
								recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
								hdr_status				= L2_hdr_status;

							}

						}
					}else{
						if(cur_Sel.equals("2")){
							if(L1_hdr_status.equals("A") && L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
								chk_disable				= "disabled";
									modify_proc			= false;
								recodeStatus_desc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.confirmed.label","mr_labels");//"Confi
								hdr_status				= L1_hdr_status;

							}
					}
				}/*Added On 8/18/2009 for J.Mail*/
					// for auth carryover.
						//String sqlicd	=	"SELECT COUNT(*) COUNT FROM MR_EQUIVALENT_TERM_CODE WHERE TERM_SET_ID = '"+proc_code_scheme+"' AND term_code = '"+proc_code+"' AND CROSS_REF_TYPE = 'EQ'";
						//pstmt1			= conn.prepareStatement(sqlicd);
						//rs1				= pstmt1.executeQuery();	
						//while(rs1.next()){
								//equivalent_term_code_cnt	=	rs1.getInt("COUNT");
						//}
					//if(pstmt1 != null) pstmt1.close();
					//if(rs1 != null) rs1.close();
	/*Based Upon the Count and Remarks The Respective Images will Visible or Hidden*/
					if(equivalent_term_code_cnt!=0){
						show_eq_tmcd="visible";
					}else{
						show_eq_tmcd="hidden";
					}
					if(!remarks.equals("")){
						show_remarks	="visible";
					}else{
						show_remarks	="hidden";
					}
/***Ends**/
/*To Display the Type of  Procedure is wheather the Procedure is OT OR Non OT  */
			if(contr_mod_id.equals("OT") ){
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");
			}else{
				proc_type	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
			}
/*Ends*/
/*To Display ACCESSION_NUM ,CODE_EXTN_YN, CODE_EXTN_DTL for each Line Items */
		/*String sql_dtl_cols="Select ACCESSION_NUM ,CODE_EXTN_YN, CODE_EXTN_DTL from MR_PROCEDURE_RECODING_DTL where   proc_code = '"+proc_code+"'  and  stage_srl_no ='"+stg_srl_no+"' and encounter_id='"+EncounterId+"' and facility_id='"+p_facility_id+"'";
		pstmt1 = conn.prepareStatement(sql_dtl_cols);
		rs1	 = pstmt1.executeQuery();	
		while(rs1.next()){
			accession_num	= checkForNull(rs1.getString("ACCESSION_NUM"));//Default For Tokenizing 
			code_extn_yn	= checkForNull(rs1.getString("CODE_EXTN_YN"));
			code_extn_dtl	= checkForNull(rs1.getString("CODE_EXTN_DTL"));//Default For Tokenizing
		}
		*/
	if(pstmt1 != null) pstmt1.close();
	if(rs1 != null) rs1.close();
	if(!accession_num.equals("")){
		if(contr_mod_id.equals("OT")){
//			db_accession_num=accession_num.replace("$","||");
			show_accesion	 ="visible";
		}else if(contr_mod_id.equals("RD")){
//			db_accession_num=accession_num.replace("$","||");
			show_accesion	 ="visible";
		}else if(contr_mod_id.equals("OR")){
//			db_accession_num=accession_num.replace("$","||");
			show_accesion	 ="visible";
		}else{
			show_accesion	 ="hidden";
		}
	}else{
		show_accesion	 ="hidden";
		db_accession_num="00";
	}
//	if(code_extn_yn.equals("N")){
		/*if(contr_mod_id.equals("OT")){
			db_code_extn_dtl=code_extn_dtl;
			/*if(code_extn_dtl.equals("01")){
				code_extn_dtl="";			
			}
			disp_ot	= true;
		/*}else{
			db_code_extn_dtl=code_extn_dtl;
			code_extn_dtl	 ="";
			disp_ot		= false;
		}*/
	/*}else{
		db_code_extn_dtl=code_extn_dtl;
		code_extn_dtl	="";
	}*/
	/*F.Y.I
		Passing the values to Recoding screen for defaulting the respective values
	*/
	db_code_extn_dtl		= checkForEmpty(code_extn_dtl,"01");
	db_laterality_ind			= checkForEmpty(code_laterality_ind,"01");
	db_proc_srt_dt_time	= checkForEmpty(proc_srt_dt_time,"01");
	db_proc_end_dt_time	=checkForEmpty(proc_end_dt_time,"01");
	/*db_code_extn_dtl	= code_extn_dtl;
	db_laterality_ind		= laterality_ind;

	if(db_code_extn_dtl.equals("")){
		db_code_extn_dtl	=	"01";
	}
	if(db_laterality_ind.equals("")){
		db_laterality_ind	=	"01";
	}
	if(db_proc_srt_dt_time.equals("")){
		db_proc_srt_dt_time	=	"01";
	}
	if(db_proc_end_dt_time.equals("")){
		db_proc_end_dt_time	=	"01";
	}*/
/***Ends***/
/*To Display Long Desc */
	if(!(proc_desc.equals(long_desc))){
		display_long_desc ="inline";
		long_desc_params =proc_code+","+proc_code_scheme;
	}
/*Ends*/

					if(group_YN.equals("X")){
						if(orig_term_code_old.equals("")){
							values_fetched=orig_proc_code+","+proc_code;
							orig_term_code_old=orig_proc_code;
							//classValue="recodeDataY1";
						}else{
							if(orig_term_code_old.equals(orig_proc_code)){
								values_fetched=values_fetched+","+proc_code;
								//classValue="recodeDataY1";
							}else{
								values_fetched=values_fetched+"~"+orig_proc_code+","+proc_code;
								orig_term_code_old=orig_proc_code;
								//classValue="recodeDataY1";
							}
							
						}

					}

					if(Integer.parseInt(hdr_level)>Integer.parseInt(cur_Sel) || Integer.parseInt(stage_no)>Integer.parseInt(cur_Sel) ){ // added for level 2 handling
						chk_disable="disabled";
						Lock_all="Y";
						
					}
//					String  equvi_lbl=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
//					String tmcode_srl_no=his_out_srl_no.nextToken();
					if(recodeStatus.equals("R")){  // recoded records
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){ // added for level 2 handling
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
							final_proc_values=final_proc_values+i+"$"+proc_code+"$"+proc_code_scheme+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_proc_code+"$"+Group_seq_no+"$"+confirm_yn+"~";

							active_proc_codes=active_proc_codes+proc_code_scheme+"$"+proc_code+"~";
							
							%>
							<tr>
							<td class='<%=classValue%>'>&nbsp;
							<%if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){ %>
								<input type="hidden" name="hdd_trx_no<%=seq_no%>" id="hdd_trx_no<%=seq_no%>" value="<%=proc_trx_no%>">
								<select name='seqproc<%=seq_no%>' id='seqproc<%=seq_no%>' disabled onchange="validate_duplicate_proc(this,<%=seq_no%>)">
								</select>
							<%seq_no++;
								}%>	
							</td>
							<td class='<%=classValue%>'>
								<img src='../../eCommon/images/EqivDiag.gif '  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=proc_code_scheme%>","<%=proc_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"/><img src='../../eCommon/images/RecodeRemarks.gif '  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=proc_code_scheme%>","<%=proc_code%>","<%=EncounterId%>","<%=stg_srl_no%>","Y","","")' alt="<%=remark_lbl%>"/><img src='../../eCommon/images/order_catalog.gif ' style="cursor:pointer;visibility:<%=show_accesion%>"onclick='callDetails("AcessionNum","<%=proc_code_scheme%>","<%=proc_code%>","<%=EncounterId%>","<%=stg_srl_no%>","","<%=accession_num%>","<%=contr_mod_id%>")' alt="<%=order_cat_lbl%>"/><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
							</td>	<!-- Equalent Term Code,Remarks Images & Order Catalog Images  -->


							<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=proc_code%>$<%=proc_code_scheme%>$<%=recodeStatus_desc%>$<%=stg_srl_no%>$<%=recodeStatus%>$<%=stage_no_disp%>$<%=group_YN%>$<%=orig_proc_code%>$<%=Group_seq_no%>$<%=contr_mod_id%>$<%=code_extn_yn%>$<%=db_code_extn_dtl%>$<%=db_laterality_ind%>$<%=db_proc_srt_dt_time%>$<%=db_proc_end_dt_time%>~' onClick='selectProcedure(<%=i%>,this)' <%=chk_disable%> ></td>
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
							<%if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel)  && modify_proc){%>
								<td class='<%=classValue%>'><%=proc_code_scheme%>&nbsp;/&nbsp;<a href="javascript:onclick=selectProcedure(<%=i%>,document.forms[0].select_chk1<%=i%>,document.forms[0].proc_code.value,'ProcModify','<%=code_extn_dtl%>','<%=contr_mod_id%>','<%=laterality_ind%>','<%=pat_visit_dt_time%>','<%=pat_disch_dt_time%>')" ><%=proc_code%></a></td>
							<%}else{%>
							<td class='<%=classValue%>'><%=proc_code_scheme%>&nbsp;/&nbsp;<%=proc_code%></td>
							<%}%>
							<td class='<%=classValue%>' wrap ><%= proc_desc%></td>
							<td class='<%=classValue%>' ><%= proc_type%></td>
							<td class='<%=classValue%>' >&nbsp;<%=code_extn_dtl%></td>
							<td class='<%=classValue%>'nowrap><%=coded_by%></td>
							<td class='<%=classValue%>'nowrap><%=coded_date%></td>
							<td class='<%=classValue%>' nowrap>&nbsp;<%=latind_lbl%></td>
							<td class='<%=classValue%>'nowrap>&nbsp;<%=proc_srt_dt_time%></td>
							<td class='<%=classValue%>'nowrap>&nbsp;<%=proc_end_dt_time%></td>

<!-- 							<td class='<%=classValue%>'><%=causeDeath%></td>
 -->							</tr>
							<%
						}else{

								if(!old_trm_cd.equals(proc_code)){
//									out.println("term_code"+ proc_code +"group_YN"+group_YN);
									if(group_YN.equals("Y")){
										classValue="recodeData";
									}else{
										classValue="gridData";
									}	

									final_proc_values=final_proc_values+i+"$"+proc_code+"$"+proc_code_scheme+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_proc_code+"$"+Group_seq_no+"$"+confirm_yn+"~";
									active_proc_codes=active_proc_codes+proc_code_scheme+"$"+proc_code+"~";
									
									%>
									<tr>
										<td id='recodeSymbol<%=i%>' class='<%=classValue%>'>&nbsp;

										<%if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){%>
											<input type="hidden" name="hdd_trx_no<%=seq_no%>" id="hdd_trx_no<%=seq_no%>" value="<%=proc_trx_no%>">
											<select name='seqproc<%=seq_no%>' id='seqproc<%=seq_no%>' disabled onchange="validate_duplicate_proc(this,<%=seq_no%>)">
											</select>
										<%seq_no++;
											}else{
											if(!seq_yn.equals("H")){%>
												<a href="javascript:onclick=expandHist('<%=i%>')">+</a>
										<%  }
										}%>

									
										</td>
										<td class='<%=classValue%>'>
											<img src='../../eCommon/images/EqivDiag.gif '  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=proc_code_scheme%>","<%=proc_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"/><img src='../../eCommon/images/RecodeRemarks.gif '  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=proc_code_scheme%>","<%=proc_code%>","<%=EncounterId%>","<%=stg_srl_no%>","Y","","")' alt="<%=remark_lbl%>"/><img src='../../eCommon/images/order_catalog.gif '  style="cursor:pointer;visibility:<%=show_accesion%>"onclick='callDetails("AcessionNum","<%=proc_code_scheme%>","<%=proc_code%>","<%=EncounterId%>","<%=stg_srl_no%>","","<%=accession_num%>","<%=contr_mod_id%>")' alt="<%=order_cat_lbl%>"/><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
										</td>	<!-- Equalent Term Code,Remarks Images & Order Catalog  Images -->


										<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=proc_code%>$<%=proc_code_scheme%>$<%=recodeStatus_desc%>$<%=stg_srl_no%>$<%=recodeStatus%>$<%=stage_no_disp%>$<%=group_YN%>$<%=orig_proc_code%>$<%=Group_seq_no%>$<%=contr_mod_id%>$<%=code_extn_yn%>$<%=db_code_extn_dtl%>$<%=db_laterality_ind%>$<%=db_proc_srt_dt_time%>$<%=db_proc_end_dt_time%>~' 	
										onClick='selectProcedure(<%=i%>,this)' <%=chk_disable%>></td>
										
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
										<%if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel)  && modify_proc){%>
											<td class='<%=classValue%>'><%=proc_code_scheme%>&nbsp;/&nbsp;<a href="javascript:onclick=selectProcedure(<%=i%>,document.forms[0].select_chk1<%=i%>,document.forms[0].proc_code.value,'ProcModify','<%=code_extn_dtl%>','<%=contr_mod_id%>','<%=laterality_ind%>','<%=pat_visit_dt_time%>','<%=pat_disch_dt_time%>')" ><%=proc_code%></a></td>
										<%}else{%>
											<td class='<%=classValue%>'><%=proc_code_scheme%>&nbsp;/&nbsp;<%=proc_code%></td>
										<%}%>
										<td class='<%=classValue%>' wrap ><%= proc_desc%></td>
										<td class='<%=classValue%>'  ><%= proc_type%></td>
										<td class='<%=classValue%>' >&nbsp;<%=code_extn_dtl%></td>
										<td class='<%=classValue%>'nowrap><%=coded_by%></td>
										<td class='<%=classValue%>'nowrap><%=coded_date%></td>
										<td class='<%=classValue%>'nowrap>&nbsp;<%=latind_lbl%></td>
										<td class='<%=classValue%>'nowrap>&nbsp;<%=proc_srt_dt_time%></td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->
										<td class='<%=classValue%>'nowrap>&nbsp;<%=proc_end_dt_time%></td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->

<!-- 										<td class='<%=classValue%>'><%=causeDeath%></td>
 -->										</tr>
										 <tr>
										<td colspan=10 align="left" width="100%">
										<tbody id="recodehist<%=i%>" style='visibility:hidden;display:none'>
										<%
											String term_chain="";
											String Srl_chain="";
											try{
												CallableStatement cal_pstmt	=	null;
												cal_pstmt = conn.prepareCall("{call MR_TERM_RECODE.RECODE_NODE(?,?,?,?,?,?,?,?,?)}");
												cal_pstmt.setString( 1, "MR_PROCEDURE_RECODING_DTL");//Table
												cal_pstmt.setString( 2, p_facility_id);//p_facility_id
												cal_pstmt.setString( 3, EncounterId);//Encounter_ID
												cal_pstmt.setString( 4, proc_code_scheme);//proc_code_scheme Added On 8/3/2009
												cal_pstmt.setString( 5, proc_code);//proc_Code
												cal_pstmt.setString( 6, cur_Sel);//stage no
												cal_pstmt.setString( 7, stg_srl_no);//term_code_stage_srl_no which will be getting from the main Query.
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

					/*Outer While:*/	while(stk_trm_chn.hasMoreTokens()){


										StringTokenizer st_trm=new StringTokenizer(stk_trm_chn.nextToken(),",");
										StringTokenizer st_trm_srl=new StringTokenizer(stk_srl_chn.nextToken(),",");
//										out.println("<table width='100%' cellpadding=0 cellspacing=0 border=1>");
										hist_disp="";

										while(st_trm.hasMoreTokens()){

												String old_diaglevel	= "";
												int ijk=0;
												//while(rs1.next()){
													//diag_level_prc= stk_trm_chn.nextToken();
													diag_level_prc	= st_trm.nextToken();
													//diag_level_prc=diag_level_prc.substring(0,diag_level_prc.length()-1);
													//srl_no_prc= stk_srl_chn.nextToken();
													srl_no_prc		= st_trm_srl.nextToken();
													//srl_no_prc=srl_no_prc.substring(0,srl_no_prc.length()-1);	
												

													String sql_hist_det="SELECT a.orig_proc_code_scheme,a.ORIG_PROC_CODE, a.proc_code_scheme, a.PROC_CODE,mr_get_desc.mr_term_code(a.proc_code_scheme,a.proc_code,'"+locale+"','2') short_desc,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"','1') practitioner_name,       TO_CHAR(a.PROC_DATE, 'dd/mm/yyyy hh24:mi') recorded_date_time, a.recode_status,decode(a.recode_status,'O','Review','N','Review','R','Review')recodeStatus_desc,  STAGE_SRL_NO,stage_seq_no,group_YN, decode(a.laterality_ind,'L','Left','R','Right','B','Both','N','NotApplicable') laterality_ind,a.contr_mod_id proc_type FROM MR_PROCEDURE_RECODING_DTL a, mr_term_code b WHERE a.facility_id = '"+p_facility_id+"'   AND a.encounter_id = '"+EncounterId+"' and a.proc_code in("+diag_level_prc+") and stage_srl_no in ("+srl_no_prc+") and a.active_YN='N'  AND a.proc_code_scheme = b.term_set_id AND a.proc_code = b.term_code order by orig_proc_code_scheme ,stage_srl_no desc";

													pstmt3 = conn.prepareStatement(sql_hist_det);
													rs3 = pstmt3.executeQuery();	
													String tmp_cd						= "";
													String proce_type_his			= "";
													String proce_type_lbl			= "";
													String latdind_his					= "";
													String recorded_date_time	="";
													//String proc_st_dt_time_his	 ="21/10/2005 16:19";
													//String proc_end_dt_time_his	 ="21/10/2005 20:19";

													
													while(rs3.next()){
														String latdind_his_lbl	 = "";
														tmp_cd						= rs3.getString("PROC_CODE");
														proce_type_his			= checkForNull(rs3.getString("proc_type"));
														latdind_his				= checkForNull(rs3.getString("laterality_ind"));
														 recorded_date_time	= checkForNull(rs3.getString("recorded_date_time"));
														recorded_date_time		= DateUtils.convertDate(recorded_date_time,"DMYHM" ,"en",locale);

														int diag_len	=diag_level_prc.indexOf(",");
														if(group_YN.equals("X")){
															if(diag_len>0){
																if(old_diaglevel.equals("")){
																	ijk++;
																	old_diaglevel	= diag_level_prc;
																}
																if(!diag_level_prc.equals(old_diaglevel)){
																	ijk++;
																	old_diaglevel	= diag_level_prc;
																}
																if ( ijk % 2 == 0 ){
																}else{
																}
															}

														}
													if(proce_type_his.equals("OT")){
														proce_type_lbl	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.OT.label","mr_labels");
													}else{
														proce_type_lbl	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NonOT.label","mr_labels");
												}
													if(latdind_his.equals("Left")){
														latdind_his_lbl	  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
													}else if(latdind_his.equals("Right")){
														latdind_his_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Right.label","common_labels");
													}else if(latdind_his.equals("Both")){
														latdind_his_lbl	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
													}else if(latdind_his.equals("NotApplicable")){
														latdind_his_lbl	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
													}
														if ( ikk % 2 == 0 ){
															hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' align='left' wrap ><b>"+checkForNull(rs3.getString("proc_code_scheme"))+"</b>&nbsp;/&nbsp;<b>"+checkForNull(rs3.getString("proc_code"))+"</b></td><td class='"+classValue+"' wrap align='left'><b>"+checkForNull(rs3.getString("short_desc"))+"</b></td><td class='"+classValue+"' wrap ><b>"+proce_type_lbl+"</b></td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' nowrap ><b>"+checkForNull(rs3.getString("practitioner_name"))+"</b></td><td  class='"+classValue+"' nowrap ><b>"+recorded_date_time+"</b></td><td class='"+classValue+"' wrap ><b>&nbsp;</b></td><td  class='"+classValue+"' wrap ><b>&nbsp;</b></td><td class='"+classValue+"' wrap ><b>&nbsp;</b></td></tr>";
														}else{
															hist_disp=hist_disp+"<tr><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap>&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap  width='30px'>&nbsp;&nbsp;&nbsp;&nbsp;</td><td class='"+classValue+"' align='left' wrap >"+checkForNull(rs3.getString("proc_code_scheme"))+"&nbsp;/&nbsp;"+checkForNull(rs3.getString("proc_code"))+"</td><td class='"+classValue+"' wrap align='left'>"+checkForNull(rs3.getString("short_desc"))+"</td><td class='"+classValue+"' wrap >"+proce_type_lbl+"</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' nowrap>"+checkForNull(rs3.getString("practitioner_name"))+"</td><td  class='"+classValue+"' nowrap>"+recorded_date_time+"</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td><td class='"+classValue+"' wrap >&nbsp;</td></tr>";
														}
													}
													/*Error Record To be Displayed */
											}// innner loop
											ikk++;
											out.println(hist_disp);
//											out.println("</table>");
										}// outer loop
										%>
											</tbody>
										</td>
									</tr>
									<%
											old_trm_cd=proc_code;
											classValue="gridData";
							}
					}
				}else{ // only original or new code
						
						if(Integer.parseInt(cur_Sel)>Integer.parseInt(stage_no_disp)){  // added for level 2 handling
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.review.label","mr_labels");//"Review";
							if(hdr_status.equals("A")){
								recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Review";
							}
						}

						if(hdr_status.equals("A")){
							chk_disable="disabled";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.authorized.label","mr_labels");//"Authorized";
						}else if(hdr_status.equals("C")){
							chk_disable="disabled";
							recodeStatus_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.completed.label","mr_labels");//"Completed";
						}
							
						final_proc_values=final_proc_values+i+"$"+proc_code+"$"+proc_code_scheme+"$"+recodeStatus_desc+"$"+stg_srl_no+"$"+recodeStatus+"$"+stage_no_disp+"$"+group_YN+"$"+orig_proc_code+"$"+Group_seq_no+"$"+confirm_yn+"~";
						active_proc_codes=active_proc_codes+proc_code_scheme+"$"+proc_code+"~";
					
						%>
						<tr>
						<td class='<%=classValue%>'>&nbsp;
							<%if(hdr_status.equals("A") && Patient_Class.equals("IP") && drg_yn.equals("Y")){%>
								<input type="hidden" name="hdd_trx_no<%=seq_no%>" id="hdd_trx_no<%=seq_no%>" value="<%=proc_trx_no%>">
								<select name='seqproc<%=seq_no%>' id='seqproc<%=seq_no%>' disabled onchange="validate_duplicate_proc(this,<%=seq_no%>)">
								</select>
							<%seq_no++;
							}%>
						</td>
						<td class='<%=classValue%>'>
							<img src='../../eCommon/images/EqivDiag.gif '  style="cursor:pointer;visibility:<%=show_eq_tmcd%>"onclick='callDetails("Eq_Term_cd","<%=proc_code_scheme%>","<%=proc_code%>","","","","","")' alt="<%=eqvi_code_lbl%>"/><img src='../../eCommon/images/RecodeRemarks.gif '  style="cursor:pointer;visibility:<%=show_remarks%>"onclick='callDetails("Remarks","<%=proc_code_scheme%>","<%=proc_code%>","<%=EncounterId%>","<%=stg_srl_no%>","Y","","")' alt="<%=remark_lbl%>"/><img src='../../eCommon/images/order_catalog.gif ' style="cursor:pointer;visibility:<%=show_accesion%>"onclick='callDetails("AcessionNum","<%=proc_code_scheme%>","<%=proc_code%>","<%=EncounterId%>","<%=stg_srl_no%>","","<%=accession_num%>","<%=contr_mod_id%>")' alt="<%=order_cat_lbl%>"/><span nowrap title="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")%>" style="display:<%=display_long_desc%>"><a href="javascript:showLongDescription('<%=long_desc_params%>')"><b>!</b></a></span>
						</td>	<!-- Equalent Term Code,Remarks Images & Order Catalog  Images -->

						<td class='<%=classValue%>'><input type='checkbox' name='select_chk1<%=i%>' id='select_chk1<%=i%>' value='<%=i%>$<%=proc_code%>$<%=proc_code_scheme%>$<%=recodeStatus_desc%>$<%=stg_srl_no%>$<%=recodeStatus%>$<%=stage_no_disp%>$<%=group_YN%>$<%=orig_proc_code%>$<%=Group_seq_no%>$<%=contr_mod_id%>$<%=code_extn_yn%>$<%=db_code_extn_dtl%>$<%=db_laterality_ind%>$<%=db_proc_srt_dt_time%>$<%=db_proc_end_dt_time%>~' onClick='selectProcedure(<%=i%>,this)' <%=chk_disable%> ></td>
						
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
						<%if(Integer.parseInt(stage_no)==Integer.parseInt(cur_Sel) && modify_proc){%>
							<td class='<%=classValue%>'><%=proc_code_scheme%>&nbsp;/&nbsp;<a href="javascript:onclick=selectProcedure(<%=i%>,document.forms[0].select_chk1<%=i%>,document.forms[0].proc_code.value,'ProcModify','<%=code_extn_dtl%>','<%=contr_mod_id%>','<%=laterality_ind%>','<%=pat_visit_dt_time%>','<%=pat_disch_dt_time%>')"><%=proc_code%></a></td>
						<%}else{%>
							<td class='<%=classValue%>'><%=proc_code_scheme%>&nbsp;/&nbsp;<%=proc_code%></td>
						<%}%>
						<td class='<%=classValue%>' wrap ><%= proc_desc%></td>
						<td class='<%=classValue%>' ><%= proc_type%></td>
						<td class='<%=classValue%>' >&nbsp;<%=code_extn_dtl%></td>
						<td class='<%=classValue%>'nowrap><%=coded_by%></td>
						<td class='<%=classValue%>'nowrap><%=coded_date%></td>
						<td class='<%=classValue%>'nowrap>&nbsp;<%=latind_lbl%></td>
						<td class='<%=classValue%>'nowrap>&nbsp;<%=proc_srt_dt_time%></td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->
						<td class='<%=classValue%>'nowrap>&nbsp;<%=proc_end_dt_time%></td><!-- Added On 12/14/2009 for SRR-CRF-303.1 -->

<!-- 					<td class='<%=classValue%>'><%=causeDeath%></td>
 -->						</tr>
						<%
						
					}
					i++;
			}//While Loop
			 if(main_cal_pstmt!=null)main_cal_pstmt.close();
			 if(rs!=null)rs.close();

		}%>		
					</table>
	</table>
		<input type='hidden' name='temp_proc' id='temp_proc' value='<%=temp_proc%>'>
		<input type='hidden' name='temp_chk' id='temp_chk' value='<%=temp_chk%>'>
		<input type='hidden' name='procedure_yn' id='procedure_yn' value=''>
		<input type='hidden' name='proc_code' id='proc_code' value=''>
		<input type='hidden' name='i' id='i' value='<%=i%>'>
		<input type='hidden' name='dflt_termset' id='dflt_termset' value='<%=dflt_termset%>'>
		<input type='hidden' name='stage_no' id='stage_no' value='<%=stage_no%>'>
		<input type='hidden' name='final_proc_values' id='final_proc_values' value='<%=final_proc_values%>'>
		<input type='hidden' name='active_proc_codes' id='active_proc_codes' value='<%=active_proc_codes%>'>
		<input type='hidden' name='Patient_Class' id='Patient_Class' value='<%=Patient_Class%>'>
		<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value='<%=allow_recode_diag_yn%>'>
		<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value='<%=allow_recode_proc_yn%>'>
		<input type='hidden' name='proc_seq_no' id='proc_seq_no' value='<%=seq_no%>'>
		<input type='hidden' name='modify_temp_proc' id='modify_temp_proc' value="">
		<input type='hidden' name='EncounterId' id='EncounterId' value="<%=EncounterId%>">
		<input type='hidden' name='Pat_id' id='Pat_id' value="<%=Pat_id%>">
		<!-- Added On 12/12/2009 for SRR-CRF-303.1 -->
		<input type='hidden' name='pat_visit_dt_time' id='pat_visit_dt_time' value="<%=pat_visit_dt_time%>">
		<input type='hidden' name='pat_disch_dt_time' id='pat_disch_dt_time' value="<%=pat_disch_dt_time%>">
		<input type='hidden' name='proc_term_set_cnt' id='proc_term_set_cnt' value="0">
		

			

			<%if(Lock_all.equals("Y")){%>
					<script>
						setTimeout('disableButtons()',200);		
//									disableButtons();

					</script>
				<%}%>
				<script>
					//setTimeout('disable_confirmed_Buttons()',200);
//					disable_confirmed_Buttons()
				</script>



	</form>
	<%
}catch(Exception e){
	e.printStackTrace();
 }finally{
		 if(main_cal_pstmt!=null)main_cal_pstmt.close();
		 if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);

 }%>

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
	public static String checkForEmpty(String inputString, String defaultValue)
	{
		return(((inputString=="") ) ? defaultValue : inputString);
	}

%>


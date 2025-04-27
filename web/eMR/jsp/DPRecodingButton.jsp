<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%	
Connection conn=null;

try{
 	conn = ConnectionManager.getConnection(request);	
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

 String sStyle				 = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 String loginUser		 = (String)session.getValue("login_user");
 String stage_no		 = request.getParameter("stage_no");
 String Pat_id			 = request.getParameter("Pat_id");
 String EncounterId	 = request.getParameter("EncounterId");
 String pat_class		  = checkForNull(request.getParameter("pat_class"));
 String open_recal_drg	= checkForNull(request.getParameter("open_recal_drg"),"N");
String sel_val				= checkForNull(request.getParameter("sel_val"));
String execute_hdr_qry	= checkForNull(request.getParameter("execute_hdr_qry"),"N");
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
String confirm_appl         = checkForNull(request.getParameter("confirm_appl"));
Boolean isConfirmApplicable = false; // added by mujafar for ML-MMOH-CRF-0878 start
String dis_yn= "";
isConfirmApplicable      = eCommon.Common.CommonBean.isSiteSpecific(conn, "MR", "CONFIRM_IN_RECODE_APPL"); 
confirm_appl  = checkForNull(eMR.MRCommonBean.getConfirmRecode(conn,p_facility_id,loginUser));

	if(isConfirmApplicable && confirm_appl.equals("N"))
			dis_yn="style=\'display:none'"; // added by mujafar for ML-MMOH-CRF-0878 end
		
Boolean isMultiDescAppl = false; 
isMultiDescAppl = eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
String allow_recode_diag_yn				= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn				= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");
String allow_ot_proc_recode_yn			= checkForNull((String)session.getAttribute("allow_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String allow_non_ot_proc_recode_yn	= checkForNull((String)session.getAttribute("allow_non_ot_proc_recode_yn"),"N");//Added On 7/7/2009
String drg_yn										= checkForNull((String)session.getAttribute("drg_calculation_yn"),"N");
String rec_diag_trm_st="";
String rec_proc_trm_st="";
if(sel_val.equals("")){
	sel_val=stage_no;
}
String disable_recal_btn="disabled";
String disable_drg_btn="";
if(open_recal_drg.equals("Y")){
	disable_recal_btn ="";
	disable_drg_btn   ="disabled";
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



	<%
			int proc_cnt = 0;
			int authorize_cnt = 0;
			String authorise_yn = "";
			String pcalss_status= "";
			String hdr_modified_dt= ""; //Added on  2/26/2010 for Concurrent Users.



		String hdr_level ="";
		String hdr_status ="";
		String L1_hdr_status = "";
		String L2_hdr_status = "";
		String L3_hdr_status = "";
		String disp_none="N";


		if(execute_hdr_qry.equals("Y")){
			String sql_hdr_sts="SELECT CURR_LEVEL,nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+p_facility_id+"' AND ENCOUNTER_ID='"+EncounterId+"'";

			pstmt = conn.prepareStatement(sql_hdr_sts);
			rs = pstmt.executeQuery();	
			while(rs.next()){
				hdr_level=rs.getString("CURR_LEVEL");
				L1_hdr_status=rs.getString("LEVEL1_STATUS");
				L2_hdr_status=rs.getString("LEVEL2_STATUS");
				L3_hdr_status=rs.getString("LEVEL3_STATUS");
				hdr_modified_dt=rs.getString("MODIFIED_DATE");
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
		}else{
			L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
			L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
			L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
			hdr_modified_dt		= checkForNull(request.getParameter("hdr_modified_dt_qr"));
			hdr_level		= checkForNull(request.getParameter("curr_level"));
		}
		if(sel_val.equals("1")){
			if(!L2_hdr_status.equals("P") || !L3_hdr_status.equals("P")){		
				disp_none="Y";
			}
			hdr_status=L1_hdr_status;
		}else if(sel_val.equals("2")){
			if(L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){// aded 19/jun	
				if(L1_hdr_status.equals("A")){
					L2_hdr_status="A";
				}
			}
			if( !L3_hdr_status.equals("P")){				
				disp_none="Y";
			}
			hdr_status=L2_hdr_status;
			
		}else if(sel_val.equals("3")){
			if(L3_hdr_status.equals("P")){ // aded 19/jun	
				if((L1_hdr_status.equals("A") && L2_hdr_status.equals("P")) || L2_hdr_status.equals("A")){
					L3_hdr_status="A";
				}
			}
			hdr_status=L3_hdr_status;
			
		}
		
		if(Integer.parseInt(sel_val)< Integer.parseInt(stage_no)){
			disp_none="Y";
		}

		String sql3="SELECT AUTHORIZE_YN FROM MR_RECODE_PRIVI_SETUP_DTL WHERE STAGE_NO='"+stage_no+"' and APPL_USER_ID='"+loginUser+"' and facility_id = '"+p_facility_id+"' ";
		pstmt = conn.prepareStatement(sql3);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			authorise_yn = rs.getString("AUTHORIZE_YN");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();


		if(authorise_yn.equals("")){
			String sql_recode="SELECT ALLOW_AUTHORIZATION_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO='"+stage_no+"'";
		pstmt = conn.prepareStatement(sql_recode);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			authorise_yn = rs.getString("ALLOW_AUTHORIZATION_YN");
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		}
		
		/*sql3="select nvl(DRG_CALCULATION_YN,'N') DRG_CALCULATION_YN from mr_parameter";
		pstmt = conn.prepareStatement(sql3);
		rs = pstmt.executeQuery();	
		String drg_yn="";
		while(rs.next()){
			drg_yn = checkForNull(rs.getString("DRG_CALCULATION_YN"));

		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();*/

		/*if(auth_at_stage.equals("")){

			String sql_recode="SELECT ALLOW_AUTHORIZATION_YN FROM MR_RECODE_PRIVI_SETUP WHERE STAGE_NO='"+stage_no+"'";
			pstmt = conn.prepareStatement(sql_recode);
			rs = pstmt.executeQuery();	
			while(rs.next())
			{
				authorise_yn = rs.getString("ALLOW_AUTHORIZATION_YN");

			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}else{
			if(Integer.parseInt(stage_no)>= Integer.parseInt(auth_at_stage)){
				authorise_yn="Y";
			}else{
				authorise_yn="N";
			}
		}
		*/
		
		/*String  complete_yn="";
		String confirm_yn="";
		String enable_confirm="N";

		String sql_sttuscheck="SELECT CONFIRM_YN from mr_diagnosis_recoding_dtl where facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and active_yn='Y' and stage_no='"+sel_val+"' union SELECT CONFIRM_YN from mr_procedure_recoding_dtl where facility_id='"+p_facility_id+"' and encounter_id='"+EncounterId+"' and active_yn='Y' and stage_no='"+sel_val+"'";

		pstmt = conn.prepareStatement(sql_sttuscheck);
		rs = pstmt.executeQuery();	

		while(rs.next()){
			confirm_yn = rs.getString("CONFIRM_YN");
			if(confirm_yn.equals("N")){
				enable_confirm="Y";
				break;
			}			
		}

		if(enable_confirm.equals("N")){
			if(stage_no.equals("1") && L1_hdr_status.equals("P")){
				enable_confirm="Y";
			}else if(stage_no.equals("2") && L2_hdr_status.equals("P")){
				enable_confirm="Y";
			}else if(stage_no.equals("3") && L3_hdr_status.equals("P")){
				enable_confirm="Y";
			}			
		}

		if(enable_confirm.equals("Y")){
			complete_yn="N";
		}else{
			complete_yn="Y";
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		*/

/*To disable New Procedure Code and New Diagnosis Code Buttons 
the following count queries are used*/	
int diag_count=0;
String new_diag_btn="";
int proc_count=0;
String new_proc_btn="";
String Diag_EncounterID=EncounterId;//If allow_recode_diag_yn="Y";
String Proc_EncounterID=EncounterId;//If allow_recode_diag_yn="Y";

if(allow_recode_diag_yn.equals("N")){
	Diag_EncounterID	=	"";
}

/*
Commented on 4/27/2010 for PE 
String diag_count_SQL	="SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Diag_EncounterID+"' ";

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
	if(pstmt != null) pstmt.close();*/
/*Added On 7/7/2009*/
String CONTR_MOD_ID	="";
if(allow_recode_proc_yn.equals("Y")){
	if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("Y")){
		CONTR_MOD_ID ="";
	}/*else if(allow_ot_proc_recode_yn.equals("Y") && allow_non_ot_proc_recode_yn.equals("N")){
		Proc_EncounterID="";
	}*/else if(allow_ot_proc_recode_yn.equals("Y")){
		CONTR_MOD_ID	=" AND CONTR_MOD_ID='OT' ";
	}else if(allow_non_ot_proc_recode_yn.equals("Y")){
		CONTR_MOD_ID	=" AND nvl(CONTR_MOD_ID,'x')!=nvl('OT','x') ";
	}else{
		Proc_EncounterID="";
	}
}else if(allow_recode_proc_yn.equals("N")){
	Proc_EncounterID	=	"";
}


/*
Commented on 4/27/2010 for PE 
String proc_count_SQL	="SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Proc_EncounterID+"' "+CONTR_MOD_ID+"  ";



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
	if(pstmt != null) pstmt.close();*/
	/*The below query was merging of both quries of which was commented for PE.*/
	String diag_proc_count_SQL	="SELECT (SELECT COUNT(*) COUNT FROM MR_DIAGNOSIS_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Diag_EncounterID+"')DIAG_COUNT,(SELECT COUNT(*) COUNT FROM MR_PROCEDURE_RECODING_DTL WHERE FACILITY_ID='"+p_facility_id+"' AND  ENCOUNTER_ID='"+Proc_EncounterID+"' "+CONTR_MOD_ID+")PROC_COUNT FROM DUAL";
		pstmt = conn.prepareStatement(diag_proc_count_SQL);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			diag_count = rs.getInt("DIAG_COUNT");
			proc_count = rs.getInt("PROC_COUNT");
		}
		
		
		if(diag_count==0){
			new_diag_btn	="hidden";				
		}else{
			new_diag_btn="visible";
		}
		if(proc_count==0){
			new_proc_btn	="hidden";				
		}else{
			new_proc_btn="visible";
		}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	String recodable_ts	="SELECT TERM_SET_ID,TERM_SET_DESC,DIAG_SPEC_YN,PROC_SPEC_YN FROM MR_TERM_SET WHERE RECODERS_APPL_YN='Y'";
	pstmt = conn.prepareStatement(recodable_ts);
	rs = pstmt.executeQuery();

	while(rs.next()){
		
		if(rs.getString("DIAG_SPEC_YN").equals("Y")){
			rec_diag_trm_st	=rs.getString("TERM_SET_ID");				
		}
		if(rs.getString("PROC_SPEC_YN").equals("Y")){
			rec_proc_trm_st	=rs.getString("TERM_SET_ID");				
		}
	}
		
	%>

</head>
<body onKeyDown='lockKey()'  onload="dis_but_dum('<%=sel_val%>')">
<form name='RecodeButton' id='RecodeButton'>
	<%
if(hdr_status.equals("R")){
	hdr_status="S";
}

	if(!sel_val.equals("0")){
		if(disp_none.equals("N")){%>
		
			<table align='right' cellpadding=0 cellspacing=0 border=0>
			<tr>
			
			<%if(!hdr_status.equals("A")){%>

				<%if(hdr_status.equals("P") || hdr_status.equals("S")){%>
					
					<%if(new_diag_btn.equals("visible")){%>
						<td><input type='button' name='new_code_diag' id='new_code_diag' id='newCodeButton' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NewDiagnosis.label","mr_labels")%>' class='button'  onclick='newCode("Diag");' style="visibility:<%=new_diag_btn%>" width='10'>&nbsp;</td>
					<%}%>

					<%if(new_proc_btn.equals("visible")){%>
						<td><input type='button' name='new_code_proc' id='new_code_proc' id='newCodeButton' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.NewProcedure.label","mr_labels")%>' class='button'  onclick='newCode("Proc");'  style="visibility:<%=new_proc_btn%>">&nbsp;</td>
					<%}%>
						
					<td><input type='button' name='recode' id='recode' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")%>' class='button'  onclick='recodeScreen()'>&nbsp;</td> <!-- modified by mujafar for ML-MMOH-CRF-1270 -->
						
					<td><input type='button' name='error' id='error' id='error_button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")%>' class='button'  onclick='markScreen();'>&nbsp;</td>

					<%//if(enable_confirm.equals("Y")){%>
						<td  <%=dis_yn%> ><input type='button' name='confirm' id='confirm' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")%>' class='button'  onclick='confirmScreen();'>&nbsp;</td>
					<%//}%>			
				<%}%>

				

				<%if(!hdr_status.equals("A") && !hdr_status.equals("C")){%>
					<td>
					<input type='button' name='complete' id='complete' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")%>' class='button'  onclick='completeScreen();'>&nbsp;</td>
				<%}
			
					
				if(hdr_status.equals("C") && authorise_yn.equals("Y")){%>
					
						<td><input type='button' name='authorize' id='authorize' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")%>' class='button'  onclick='Click_Authorize();'>&nbsp;<input type='button' name='reject' id='reject'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")%>' class='button'   onclick='rejectScreen();'>&nbsp;</td>
					
				<%}
			}



			if(hdr_status.equals("A") && authorise_yn.equals("Y") ){
					if(pat_class.equals("IP")&& drg_yn.equals("Y")){%>
						<!--td><input type='button' name='sequence' id='sequence' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.Sequence.label","mr_labels")%>' class='button'   onclick=''>&nbsp;</td-->	
						<td><input type='button' name='calDrg' id='calDrg' id='calDRG'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.CalculateDRG.label","mr_labels")%>' class='button'  onclick='recallDRG();' <%=pcalss_status%> <%=disable_recal_btn%>>&nbsp;
						<input type='button' name='seqDrg' id='seqDrg' id='seqImg'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DRG.label","mr_labels")%>' class='button'  onclick="Open_DRG('x')"; <%=pcalss_status%> <%=disable_drg_btn%>> &nbsp;</td>
						<td><input type='button' name='reject' id='reject' id='reject1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectDRG.label","mr_labels")%>' class='button'   onclick='Reject_Drg()' <%=pcalss_status%> >&nbsp;</td>
				<%}else{%>
						<td><input type='button' name='reject' id='reject' id='reject1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")%>' class='button'   onclick='Reject_Drg()' <%=pcalss_status%> >&nbsp;</td>
				<%}
				}%>
			</tr>
			</table>
		<%}
	}%>
	<!-- Added On 10/21/2009 
		   For FreeText Enable Disable Confirm Button GHL 41.
	-->
	<SCRIPT LANGUAGE="JavaScript">
	<!--
		disableDiagProcChkbox('<%=disp_none%>');
	//-->
	</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<input type='hidden' name='Pat_id' id='Pat_id' value="<%=Pat_id%>">
	<input type='hidden' name='EncounterId' id='EncounterId' value="<%=EncounterId%>">
	<input type='hidden' name='proc_cnt' id='proc_cnt' value="<%=proc_cnt%>">
	<input type='hidden' name='authorize_cnt' id='authorize_cnt' value="<%=authorize_cnt%>">
	<input type='hidden' name='stage_no' id='stage_no' value="<%=stage_no%>"> 
	<input type='hidden' name='confirm_appl' id='confirm_appl' value="<%=confirm_appl%>"> <!-- added by mujafar for ML-MMOH-CRF-0878 -->
	
	<!-- <input type='text' name='Complete_YN' id='Complete_YN' value=<%=stage_no%>> -->
	<input type='hidden' name='activity' id='activity' value="">
	<input type='hidden' name='Confirm_Dig_Data' id='Confirm_Dig_Data' value="">
	<input type='hidden' name='Confirm_Proc_Data' id='Confirm_Proc_Data' value="">
	<input type='hidden' name='sel_proc_srl_no' id='sel_proc_srl_no' value="">
	<input type='hidden' name='marked_err_diagvals' id='marked_err_diagvals' value="">
	<input type='hidden' name='sel_srl_no' id='sel_srl_no' value="">
	<input type='hidden' name='sel_status' id='sel_status' value="">
	<input type='hidden' name='grpby_val' id='grpby_val' value="">
	<input type='hidden' name='sel_stages_val' id='sel_stages_val' value="">
	<input type='hidden' name='procedure_yn' id='procedure_yn' value="">
	<input type='hidden' name='Patient_Class' id='Patient_Class' value="<%=pat_class%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=p_facility_id%>">
	<input type='hidden' name='applicationID' id='applicationID' value="TGRP">
	<input type='hidden' name='eventType' id='eventType' value="D01">
	<input type='hidden' name='profileID' id='profileID' value="SRRDRG1">
	<input type='hidden' name='diag_stage_values_cnfrm' id='diag_stage_values_cnfrm' value="">
	<input type='hidden' name='proc_stage_values_cnfrm' id='proc_stage_values_cnfrm' value="">
	<input type='hidden' name='diag_group_values_cnfrm' id='diag_group_values_cnfrm' value="">
	<input type='hidden' name='diag_group_seq_values_cnfrm' id='diag_group_seq_values_cnfrm' value="">
	<input type='hidden' name='proc_group_values_cnfrm' id='proc_group_values_cnfrm' value="">
	<input type='hidden' name='proc_group_seq_values_cnfrm' id='proc_group_seq_values_cnfrm' value="">
	<input type='hidden' name='diag_status_values_cnfrm' id='diag_status_values_cnfrm' value=''>
	<input type='hidden' name='proc_status_values_cnfrm' id='proc_status_values_cnfrm' value=''>

	<input type='hidden' name='diag_new_seq' id='diag_new_seq' value="">
	<input type='hidden' name='proc_new_seq' id='proc_new_seq' value="">
	<input type='hidden' name='allow_recode_diag_yn' id='allow_recode_diag_yn' value="<%=allow_recode_diag_yn%>">
	<input type='hidden' name='allow_recode_proc_yn' id='allow_recode_proc_yn' value="<%=allow_recode_proc_yn%>">
	<input type='hidden' name='principal_diag' id='principal_diag' value=''>
	<input type='hidden' name='prin_stg_srl_no' id='prin_stg_srl_no' value=''>
	<input type='hidden' name='drg_yn' id='drg_yn' value='<%=drg_yn%>'>
	<input type='hidden' name='final_diag_confirm_yn' id='final_diag_confirm_yn' value=''>
	<input type='hidden' name='final_proc_confirm_yn' id='final_proc_confirm_yn' value=''>
	<input type='hidden' name='final_Diag_group_yn' id='final_Diag_group_yn' value=''><!-- Added On 7/2/2009 -->
	<input type='hidden' name='final_Proc_group_yn' id='final_Proc_group_yn' value=''><!--Added On 7/2/2009  -->
	<input type='hidden' name='stage_auth' id='stage_auth' value=''>
<!-- 	<input type='hidden' name='sel_mod_id' id='sel_mod_id' value=''>
	<input type='hidden' name='sel_cod_xtn' id='sel_cod_xtn' value=''>
	<input type='hidden' name='sel_acess_num' id='sel_acess_num' value=''>
	<input type='hidden' name='sel_cod_xtn_dtl' id='sel_cod_xtn_dtl' value=''>
 -->
	<input type='hidden' name='rec_diag_tset' id='rec_diag_tset' value='<%=rec_diag_trm_st%>'>
	<input type='hidden' name='rec_proc_tset' id='rec_proc_tset' value='<%=rec_proc_trm_st%>'>
	<!-- Added On 2/16/2010 for SRR-CRF-303.2(IN015597)  -->
	<input type='hidden' name='group_yn_data' id='group_yn_data' value=''>
	<input type='hidden' name='group_seq_no_data' id='group_seq_no_data' value=''>
	<input type='hidden' name='support_seq_no_data' id='support_seq_no_data' value=''>
	<input type='hidden' name='hdr_modified_dt' id='hdr_modified_dt' value='<%=hdr_modified_dt%>'> 
	<input type='hidden' name='isMultiDescAppl' id='isMultiDescAppl' value='<%=isMultiDescAppl%>'> <!-- added by mujfar for ML-MMOH-CRF-1281 -->
	</form>
</body>
</html>
		<%
}catch(Exception e){
	e.printStackTrace();
 }finally{
		ConnectionManager.returnConnection(conn,request);

 }%>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


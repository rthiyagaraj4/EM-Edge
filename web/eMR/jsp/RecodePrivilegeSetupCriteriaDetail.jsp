<!DOCTYPE html>
<!--
Createted by:Anjaneya Reddy M
Date        :12/19/2008
Module      :eMR
Function    :Record PrivlegeStage Criteria Form

This File was modified For SRR-CRF-303.1CRF  on 12/3/2009
-->
<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*, eCommon.Common.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<% //String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%			
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script language='javascript' src='../../eMR/js/RecodePrivilegeSetup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	Connection con				=   null;   //Added by Sangeetha for ML-MMOH-CRF-0547
	try
	{
	
		//String termChk="";
			con=ConnectionManager.getConnection(request);
			
			Boolean isEncounterStage= false; //Added by KAMATCHI S for ML-MMOH-CRF-1581
			isEncounterStage	=  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TERM_RECODE_DIAG");//Added by KAMATCHI S for ML-MMOH-CRF-1581
			String visibility_check= "none";//Added by KAMATCHI S for ML-MMOH-CRF-1581
			String _update_mode_yn		=	checkForNull(request.getParameter("_update_mode_yn"));
			String _diag_clas_chk		=	"";
			String  _diag_clas_dis		=	"";
			String _accu_chk				=	"";
			String _priorty_chk			=	"";
			String _onset_chk				=	"";
			String _onsetDate_chk		=	"";
			String _appside_chk			=	"";
			String _status_chk			=	"";
			String _status_dis				=	"";
			String _asDate_chk			=	"";
			String _remarks_chk			=	"";
			String proc_remarks_chk	=	"";
			String _sev_chk				=	"";
			String laterality_chk			=	"";
			String code_xtn_chk			=	"";
			String proc_sts_chk			=	"";//Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
			String proc_sts_dis			=	"";//Added On 2/15/2010 for SRR-CRF-303.2 (IN015597)
			String _diag_class_appl_yn			=	"N"; 
			String _accuracy_appl_yn				=	"N"; 
			String _severity_appl_yn				=	"N"; 
			String _priority_appl_yn				=	"N"; 
			String _onset_type_appl_yn			=	"N"; 
			String _onset_date_appl_yn			=	"N"; 
			String _applicable_side_appl_yn	=	"N"; 
			String _status_appl_yn					=	"N"; 
			String _as_on_date_appl_yn			=	"N"; 
			String _remarks_appl_yn				=	"N"; 
			String proc_remarks_appl_yn		=	"N"; 
			String code_xtn_appl_yn				=	"N"; 
			String laterality_appl_yn				=	"N"; 
			String proc_status_appl_yn			=	"N"; //Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
  
			String	enc_stage_yn					="N"; /* HAS-CRF-300 */
			String  chife_compln_yn					="N";/* HAS-CRF-300 */
			String  notify_yn						="N";/* HAS-CRF-300 */
			String	enc_stage_chk					="";/* HAS-CRF-300 */
			String  chife_compln_chk				="";/* HAS-CRF-300 */
			String  notify_chk						="";/* HAS-CRF-300 */

			/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
			String inpatient_appl="";
			String daycare_appl="";
			String inpatient_appl_check="";
			String daycare_appl_check="";
			/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
				
			if(_update_mode_yn.equals("update_db")){
				_diag_class_appl_yn		=	checkForNull(request.getParameter("_diag_class_appl_yn"));
				_accuracy_appl_yn		=	checkForNull(request.getParameter("_accuracy_appl_yn"));
				_severity_appl_yn		=	checkForNull(request.getParameter("_severity_appl_yn"));
				_priority_appl_yn			=	checkForNull(request.getParameter("_priority_appl_yn"));
				_onset_type_appl_yn	=	checkForNull(request.getParameter("_onset_type_appl_yn"));
				_onset_date_appl_yn	=	checkForNull(request.getParameter("_onset_date_appl_yn"));
				_applicable_side_appl_yn	 =	checkForNull(request.getParameter("_applicable_side_appl_yn"));
				_status_appl_yn			=	checkForNull(request.getParameter("_status_appl_yn"));
				_as_on_date_appl_yn	=	checkForNull(request.getParameter("_as_on_date_appl_yn"));
				_remarks_appl_yn		=	checkForNull(request.getParameter("_remarks_appl_yn"));
				proc_remarks_appl_yn	=	checkForNull(request.getParameter("proc_remarks_appl_yn"));
				code_xtn_appl_yn		=	checkForNull(request.getParameter("code_xtn_appl_yn"));
				laterality_appl_yn			=	checkForNull(request.getParameter("laterality_appl_yn"));
				proc_status_appl_yn	=	checkForNull(request.getParameter("proc_status_appl_yn"),"N");
				
				enc_stage_yn		=	checkForNull(request.getParameter("enc_stage_yn"));  /* HAS-CRF-300 */
				chife_compln_yn		=	checkForNull(request.getParameter("chife_compln_yn")); /* HAS-CRF-300 */
				notify_yn			=	checkForNull(request.getParameter("notify_yn")); /* HAS-CRF-300 */

				/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
				inpatient_appl=checkForNull(request.getParameter("inpatient_appl"));
				daycare_appl=checkForNull(request.getParameter("daycare_appl"));
				/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

				
					
					if(_diag_class_appl_yn.equals("Y")){
						_diag_clas_chk="checked";
						_diag_clas_dis="disabled";
					}else{
					   _diag_clas_chk="";
					   _diag_clas_dis="";
					}

					if(_accuracy_appl_yn.equals("Y")){
						_accu_chk="checked";
					}else{
					   _accu_chk="";
					}
					
					if(_severity_appl_yn.equals("Y")){
						_sev_chk="checked";
					}else{
					   _sev_chk="";
					}

					if(_priority_appl_yn.equals("Y")){
						_priorty_chk="checked";
					}else{
					   _priorty_chk="";
					}

					if(_onset_type_appl_yn.equals("Y")){
						_onset_chk="checked";
					}else{
					   _onset_chk="";
					}

					if(_onset_date_appl_yn.equals("Y")){
						_onsetDate_chk="checked";
					}else{
					   _onsetDate_chk="";
					}

					if(_applicable_side_appl_yn.equals("Y")){
						_appside_chk="checked";
					}else{
					   _appside_chk="";
					}

					if(_status_appl_yn.equals("Y")){
						_status_chk="checked";
						_status_dis="disabled"; //Added On 7/2/2009
					}else{
					   _status_chk="";
					   _status_dis="";//Added On 7/2/2009
					}

					if(_as_on_date_appl_yn.equals("Y")){
						_asDate_chk="checked";
					}else{
					   _asDate_chk="";
					}
				/* Below lines added by Venkatesh.S against HAS-CRF-300 */
					   
					   if(enc_stage_yn.equals("Y")){
						enc_stage_chk="checked";
						}else{
					   enc_stage_chk="";}
					   
					   if(chife_compln_yn.equals("Y")){
						chife_compln_chk="checked";
						}else{
					   chife_compln_chk="";}
					   
					    if(notify_yn.equals("Y")){
						notify_chk="checked";
						}else{
					   notify_chk="";}
					
					   
				   /* END HAS-CRF-0300 */
					if(_remarks_appl_yn.equals("Y")){
						_remarks_chk="checked";
					}else{
					   _remarks_chk="";
					}
					if(code_xtn_appl_yn.equals("Y")){
						code_xtn_chk="checked";
					}
					if(laterality_appl_yn.equals("Y")){
						laterality_chk="checked";
					}

					if(proc_remarks_appl_yn.equals("Y")){
						proc_remarks_chk="checked";
					}
					if(proc_status_appl_yn.equals("Y")){
						proc_sts_chk="checked";
						proc_sts_dis="disabled"; //Added On 7/2/2009
					}else{
					   proc_sts_chk="";
					   proc_sts_dis="";//Added On 7/2/2009
					}
					
					//Added by KAMATCHI S for ML-MMOH-CRF-1581 START
					if(isEncounterStage) 
					{
					if(enc_stage_yn.equals("Y"))
					{
					 visibility_check= "inline";
					}
					else
					{
					visibility_check="none";
					}

					if(inpatient_appl.equals("Y"))
						inpatient_appl_check="checked";
					else if(inpatient_appl.equals("N"))
						inpatient_appl_check="";

					if(daycare_appl.equals("Y"))
						daycare_appl_check="checked";
					else if(daycare_appl.equals("N"))
						daycare_appl_check="";
					}
					//Added by KAMATCHI S for ML-MMOH-CRF-1581 END
			}
			
%>
	<body  onKeyDown='lockKey()'  OnMouseDown='CodeArrest()'>
		<form name='PrivilegeCriteriaForm' id='PrivilegeCriteriaForm' action='../../servlet/eMR.RecodePrivilegeSetupServlet' method='post' target="messageFrame" >
<!-- Criteria for Diagnosis  -->
			<table width='100%'  valign=TOP>
				<th align='left'><fmt:message key="eMR.ApplicableRecodingComponent.label" bundle="${mr_labels}"/>&nbsp;(<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>)</th>
			</table>
			<table  width="100%" cellspacing='0' cellpadding='0'>
				<tr>
				   <td class="label" width='20%'><fmt:message key="eMR.DiagnosisClassification.label" bundle="${mr_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="diagnosis_clasifi" id="diagnosis_clasifi" value="<%=_diag_class_appl_yn%>"  <%=_diag_clas_chk%> <%=_diag_clas_dis%>></td>
				   <td class="label" width='10%'><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="accuracy" id="accuracy" value="<%=_accuracy_appl_yn%>" <%=_accu_chk%>></td>
				   <td class="label" width='10%'><fmt:message key="Common.Severity.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="severity" id="severity" value="<%=_severity_appl_yn%>" <%=_sev_chk%>></td>
				</tr>
				<tr>
				   <td class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="priority" id="priority" value="<%=_priority_appl_yn%>" <%=_priorty_chk%>></td>
				   <td class="label"><fmt:message key="eMR.OnsetType.label" bundle="${mr_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="onset_type" id="onset_type" value="<%=_onset_type_appl_yn%>" <%=_onset_chk%>></td>
				   <td class="label"><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="onset_date" id="onset_date" value="<%=_onset_date_appl_yn%>" <%=_onsetDate_chk%>></td>
				</tr>
				<tr>
				   <td class="label"><fmt:message key="eMR.ApplicableSide.label" bundle="${mr_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="applicable_side" id="applicable_side" value="<%=_applicable_side_appl_yn%>" <%=_appside_chk%>></td>
				   <td class="label"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="status" id="status" value="<%=_status_appl_yn%>" <%=_status_chk%> <%=_status_dis%>></td>
				   <td class="label"><fmt:message key="Common.Ason.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="asOn_Date" id="asOn_Date" value="<%=_as_on_date_appl_yn%>" <%=_asDate_chk%>></td>
				  
				   
				</tr>
				<tr>

				   <td class="label"><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/></td> <!-- modified by mujafar for ML-MMOH-CRF-1270 -->
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="remarks" id="remarks" value="<%=_remarks_appl_yn%>" <%=_remarks_chk%>></td>
				   <!--Below lines added by Venkatesh.S against HAS-CRF-300 -->
					<!--Condition is added for ML-MMOH-CRF-1581 BY KAMATCHI S -->
				   <%if(!isEncounterStage){%><td class="label"  nowrap><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}" /></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="enc_stage" id="enc_stage" value="<%=enc_stage_yn%>" <%=enc_stage_chk%>></td><%}%>
				   <td class="label"nowrap><fmt:message key="Common.ChiefComplaint.label" bundle="${common_labels}"/></td>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="chife_compln" id="chife_compln" value="<%=chife_compln_yn%>" <%=chife_compln_chk%>></td>
				</tr>
				<tr> 
				<%
				//Added by Sangeetha for ML-MMOH-CRF-0547
				try{
				con	 =  ConnectionManager.getConnection(request);
				Boolean legendChangeAsTypesOfNotiForm =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","TYPES_OF_NOTIFICATION_FORM"); 
				if(legendChangeAsTypesOfNotiForm){ %>
					<td  class="label" width='20%' ><fmt:message key="eMR.TypesofNotification.label" bundle="${mr_labels}"/> </td>
					<% }
					else{%>
				<td class="label"><fmt:message key="eMR.WorkRelated.label" bundle="${mr_labels}"/></td>
				<% } %>
				   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="notify" id="notify" value="<%=notify_yn%>" <%=notify_chk%>></td>
				   <!--END HAS-CRF-300 -->
				  <% }catch(Exception e)
						{
						e.printStackTrace();
						}
					  finally
						{
								ConnectionManager.returnConnection(con,request);
						}
				%> 
			   <!-- just padding columns -->
			   <td></td>
			   <td></td>
			   <td></td>
			   <td></td>
				</tr>
				<!--Added for ML-MMOH-CRF-1581 BY KAMATCHI S START -->
				<%if(isEncounterStage){%>
				<tr>
				<td class="label" ><fmt:message key="eMR.EncounterStage.label" bundle="${mr_labels}"/></td> 
				<td class='fields'><input type="checkbox" name="enc_stage" id="enc_stage" value="<%=enc_stage_yn%>" <%=enc_stage_chk%> onclick="setValue(this);ecounterStage(this);"></td>
				<td class="label" id="iplbl" style="display:<%=visibility_check%>"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></td> 
				<td class='fields' id='ipchk' style="display:<%=visibility_check%>"><input type="checkbox" name="inpatient_appl" id="inpatient_appl" onclick="setValue(this);"  value="<%=inpatient_appl%>"  <%=inpatient_appl_check%> ></td>
				<td class="label" id="dclbl" style="display:<%=visibility_check%>"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td> 
				<td class='fields' id='dchk' style="display:<%=visibility_check%>"><input type="checkbox" name="daycare_appl" id="daycare_appl" onclick="setValue(this);" value="<%=daycare_appl%>"  <%=daycare_appl_check%>
					onclick="setValue(this);" ></td>
				</tr>
				<% } %>
					<!--Added for ML-MMOH-CRF-1581 BY KAMATCHI S END -->
		</table>
<!-- Criteria for Diagnosis Ends -->

<!-- Criteria for Procedure Modified For SRR-CRF- 303.1 CRF 12/3/2009 -->
		<table width='100%'  valign=top>
			<th align='left'><fmt:message key="eMR.ApplicableRecodingComponent.label" bundle="${mr_labels}"/>&nbsp;(<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>)</th>
		</table>
		<table  width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<td class="label" width='20%'><fmt:message key="eMR.Laterality.label" bundle="${mr_labels}"/></td>
				<td class='fields' ><input type="checkbox" onclick="setValue(this)" name="laterality_yn" id="laterality_yn" value="<%=laterality_appl_yn%>" <%=laterality_chk%>></td>
				<td class="label" width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Ext.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="checkbox" onclick="setValue(this)" name="code_xtn_yn" id="code_xtn_yn" value="<%=code_xtn_appl_yn%>" <%=code_xtn_chk%>></td>
				<td class="label" width='10%'><fmt:message key="eMR.DiagnosisRemarks.label" bundle="${mr_labels}"/></td> <!-- modified by mujafar for ML-MMOH-CRF-1270 -->
				<td class='fields'><input type="checkbox" onclick="setValue(this)" name="proc_remarks_yn" id="proc_remarks_yn" value="<%=proc_remarks_appl_yn%>" <%=proc_remarks_chk%>></td>
			</tr>
			<tr>
			   <td class="label" width='10%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			   <td class='fields'><input type="checkbox" onclick="setValue(this)" name="proc_status_yn" id="proc_status_yn" value="<%=proc_status_appl_yn%>" <%=proc_sts_chk%> <%=proc_sts_dis%>></td>
			   <td></td>
			   <td></td>
			   <td></td>
			   <td></td>
			</tr>
	</table>
	<!-- Criteria for Procedure Ends -->

		<input type='hidden' name='stage_code' id='stage_code' value=''>
		<input type='hidden' name='stage_description' id='stage_description' value=''>
		<input type='hidden' name='srl_no' id='srl_no' value=''>
		<input type='hidden' name='color_ind' id='color_ind' value=''>
		<input type='hidden' name='text_color' id='text_color' value=''>
		<input type='hidden' name='specific_indicator' id='specific_indicator' value=''>
		<input type='hidden' name='cutoff_period' id='cutoff_period' value=''>
		<input type='hidden' name='days_fromVisit' id='days_fromVisit' value=''>
		<input type='hidden' name='allow_auth' id='allow_auth' value=''>  
		<input type='hidden' name='confirm_not_appl' id='confirm_not_appl' value=''> <!-- added by mujafar for ML-MMOH-CRF-0878 -->
		<input type='hidden' name='isConfirmApplicable' id='isConfirmApplicable' VALUE="">
		<input type='hidden' name='action_ifnot_done' id='action_ifnot_done' value=''>
		
		<!-- 	
			Commented for enhancement on Recoding 303.112/3/2009
			<input type='hidden' name='diagnosis_clasifi' id='diagnosis_clasifi' value=''>
			<input type='hidden' name='accuracy' id='accuracy' value=''>
			<input type='hidden' name='severity' id='severity' value=''>
			<input type='hidden' name='priority' id='priority' value=''>
			<input type='hidden' name='onset_type' id='onset_type' value=''>
			<input type='hidden' name='onset_date' id='onset_date' value=''>
			<input type='hidden' name='applicable_side' id='applicable_side' value=''>
			<input type='hidden' name='status' id='status' value=''>
			<input type='hidden' name='asOn_Date' id='asOn_Date' value=''>
			<input type='hidden' name='remarks' id='remarks' value=''>
		 -->	
		<input type='hidden' name='list_auth_users' id='list_auth_users' value=''>
		<input type='hidden' name='_update_mode_yn' id='_update_mode_yn' value='<%=_update_mode_yn%>'>

<%
}
catch(Exception exp)
{
	out.println("Exception-674-"+exp.getMessage());
	exp.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>

		</form>
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


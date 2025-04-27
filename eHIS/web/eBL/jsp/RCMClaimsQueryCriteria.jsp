<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eBL/js/RCMClaims.js' language='javascript'></script>
<script src='../../eBL/js/RCMClaimsStatusChange.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	
	String sql="";
	
	int pat_id_len= 0;
	try
	{
		con	=	ConnectionManager.getConnection(request);
		sql ="select patient_id_length from mp_param";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		if (rs != null && rs.next() )
		{
			pat_id_len = rs.getInt("patient_id_length") ;
		}
%>
<BODY  onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	<FORM method='post' name="search" id="search" id="search" action=""	onsubmit="" >
		<table cellpadding="3" cellspacing=0 width="100%" align="center">

		<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" value="">
				<input type="button" class="button" name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()"  />
			</td>

			<td class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="patient_name" id="patient_name" id="patient_name" readonly size="50" maxlength="100"  onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase(this);" >	
			</td>
		</tr>
		
		<tr>				
			<td class="label"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<select id="episode_type" name="episode_type" id="episode_type" onChange="checkForValue(this);">
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
					<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
					<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
					<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>					
					<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>
				</select>
			</td>
				
			<td class="label">
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="encounter_id" id="encounter_id" id="encounter_id" size = "15" maxlength="12"  onBlur="ChangeUpperCase( this );if(this.value!=''){encounterIDLkup(this);}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type="button" class="button" name="patientidbut" id="patientidbut" value='?' onClick="return encounterIDLkup()"  >
			</td>
			
			<td class="label">
				<fmt:message key="Common.speciality.label" bundle="${common_labels}" />/<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}" />
			</td>
			<td class="fields">
				<input type="text" name='spec_nur_unit_desc' id='spec_nur_unit_desc' id='spec_nur_unit_desc' size="30" maxlength="100" value='' disabled onblur='if(this.value!=""){ SpecNursingUnitLkup(1,spec_nur_unit_desc,spec_nursing_unit_code) } else{ clearCode(spec_nursing_unit_code); }'>
				<input type="hidden" name='spec_nursing_unit_code' id='spec_nursing_unit_code' id='spec_nursing_unit_code' value=''>
				<input type="button" class="button" name="spec_nursing_unit_btn" id="spec_nursing_unit_btn" value='?' disabled onClick="SpecNursingUnitLkup(1,spec_nur_unit_desc,spec_nursing_unit_code);">				
			</td>
		</tr>
		
		<tr>	
			<td class="label">
				<fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="payer_group" id="payer_group" id="payer_group" size="30" maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGrpLkup();} else{ clearCode(payer_grp_code); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="hidden" id="payer_grp_code" name="payer_grp_code" id="payer_grp_code" value="">
				<input type="button" class="button" name="payer_grp_btn" id="payer_grp_btn" value="?" onClick="return payerGrpLkup()"/> 
				<span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
			<td class="label">
				<fmt:message key="Common.Payer.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="payer" id="payer" id="payer" size="30" maxlength="100" onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLkup();} else{ clearCode(payer_code); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="hidden" id="payer_code" name="payer_code" id="payer_code" value="">
				<input type="button" class="button" name="payer_btn" id="payer_btn" value='?' onClick="return payerLkup()"/>
				<span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
			<td class="label">
				<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="policy" id="policy" id="policy" size="30" maxlength="100" onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();} else{ clearCode(policy_type_code); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type="hidden" id="policy_type_code" name="policy_type_code" id="policy_type_code" value="">
				<input type="button" class="button" name="policy_btn" id="policy_btn" value='?' onClick="return policyLookup()"/>
			</td>
		</tr>
		
		<tr>
			<td class="label">
				<fmt:message key="Common.encounter.label" bundle="${common_labels}"/> 
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="enc_frm_date" id="enc_frm_date" id="enc_frm_date" size = "12" maxlength="10" onblur='encFromDateValidation(this, enc_frm_date,enc_to_date);' value="">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('enc_frm_date');"  onKeyPress="return lockbackSpace();">
				<span class='mandHide'><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
			<td class="label">
				<fmt:message key="Common.encounter.label" bundle="${common_labels}"/>
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="enc_to_date" id="enc_to_date" id="enc_to_date" size = "12" maxlength="10" onblur='encToDateValidation(this, enc_frm_date,enc_to_date);' value="">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('enc_to_date');"  onKeyPress="return lockbackSpace();">
				<span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="eBL.DOC_GEN_FROM.label" bundle="${bl_labels}"/> 
			</td>
			<td class="fields">
				<input type="text" name="doc_gen_from" id="doc_gen_from" id="doc_gen_from" size = "12" maxlength="10" onBlur="docFromDateValidation(this, doc_gen_from,doc_gen_to);" value="" disabled>
				<img src="../../eCommon/images/CommonCalendar.gif" id="doc_gen_from_cal" onClick="return showCalendar('doc_gen_from');"  onKeyPress="return lockbackSpace();" disabled>
			</td>
			<td class="label">
				<fmt:message key="eBL.DOC_GEN_TO.label" bundle="${bl_labels}"/> 
			</td>
			<td class="fields">
				<input type="text" name="doc_gen_to" id="doc_gen_to" id="doc_gen_to" size = "12" maxlength="10" onBlur="docToDateValidation(this, doc_gen_from,doc_gen_to);" value="" disabled>
				<img src="../../eCommon/images/CommonCalendar.gif" id="doc_gen_to_cal" onClick="return showCalendar('doc_gen_to');"  onKeyPress="return lockbackSpace();" disabled>
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="eBL.CLAIM_STATUS.label" bundle="${bl_labels}"/></td>
			<td class="fields">
				<select id="claim_status" name="claim_status" id="claim_status" onChange="claimStatusChange(this);">
					<option value="">----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
					<option value="E"><fmt:message key="eBL.RCM_IN_ERROR.label" bundle="${bl_labels}"/></option>
					<option value="D"><fmt:message key="eBL.RCM_DOC_GEN_REVIEW.label" bundle="${bl_labels}"/></option>
					<option value="R"><fmt:message key="eBL.RCM_REV_APPRV.label" bundle="${bl_labels}"/></option>
					<option value="G"><fmt:message key="eBL.RCM_GEN_CLAIM.label" bundle="${bl_labels}"/></option>
					<option value="I"><fmt:message key="eBL.RCM_SUB_TO_INS.label" bundle="${bl_labels}"/></option>
					<option value="F"><fmt:message key="eBL.RCM_INS_FEEDBACK.label" bundle="${bl_labels}"/></option>
					<option value="P"><fmt:message key="eBL.RCM_PROCESS_CLAIM.label" bundle="${bl_labels}"/></option>
				</select>
				<span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>		
			<td class="label">
				<fmt:message key="eBL.CLAIM_NUMBER.label" bundle="${bl_labels}"/> 
			</td>
			<td class="fields">
				<input type="text" name="claim_number" id="claim_number" id="claim_number" size="30" maxlength="50" onBlur="ChangeUpperCase( this );if(this.value!=''){ claimLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" disabled>
				<input type="button" class="button" name="claim_num_but" id="claim_num_but" value='?' onClick="return claimLookup()" disabled /> 
			</td>
			
			<td class="label">
				<fmt:message key="eBL.INS_STATUS.label" bundle="${bl_labels}"/> 
			</td>
			<td class="fields">
				<select id="ins_status" name="ins_status" id="ins_status" disabled>
					<option value="">----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
					<option value="**"><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
					<option value="A"><fmt:message key="Common.Approved.label" bundle="${common_labels}" /></option>
					<option value="R"><fmt:message key="Common.Reject.label" bundle="${common_labels}" /></option>
					<option value="Q"><fmt:message key="Common.query.label" bundle="${common_labels}" /></option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="eBL.INCL_PAST_RECS.label" bundle="${bl_labels}"/></td>
			<td class="fields">
				<input type="checkbox" name="incl_past_recs" id="incl_past_recs" id="incl_past_recs" onClick="enablePastRecDays(this);">
				<input type="textbox" name="past_recs_days" id="past_recs_days" id="past_recs_days" size="5" maxlength="2" disabled onkeypress="return checkAlpha(event)" onblur="checkForNumber(this)">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}" />
			</td>
			<td class="button" colspan="4">
				<input type="button" name="search_btn" id="search_btn" id="search_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" class="button" onClick='validateFormAndQuery();'>
				<input type="button" name="reset_btn" id="reset_btn" id="reset_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.reset.label", "common_labels")%>" class="button" onClick="reloadPage();">
			</td>			
		</tr>

		</table>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>">
	</form>
</body>
<%
	}catch(Exception e){
		System.err.println("Error in RCMClaimsQueryCriteria.jsp->"+e.toString());
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);		
	}		
%>
</html>


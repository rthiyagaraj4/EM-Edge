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
<script src='../../eBL/js/BLFutOrdInsApprTrack.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
System.err.println("In BLFutOrdInsApprTrackQryCriteria.jsp");
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	String locale = (String)session.getAttribute("LOCALE");
	if(locale == null) locale = "en";
	String facility_id = (String)session.getAttribute("facility_id");
	String sql="";
	BLHelper blHelper = null;
	Map orderStatusList = new HashMap<String,String>();
	int pat_id_len= 0;
	Map recApprStatusList = new HashMap();
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
		orderStatusList = (Map) blHelper.getOrderStatusList(con);
		System.err.println(orderStatusList);
		
		recApprStatusList = (Map) BLHelper.getListOfItems(con, "BL", "L_REC_APPROVAL_STATUS", locale);
		
%>
<BODY  onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	<FORM method='post' name="search" id="search" id="search" action=""	onsubmit="" >
		<table cellpadding="3" cellspacing=0 width="100%" align="center">

		<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="patient_id" id="patient_id" id="patient_id" size="30" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" value="">
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
				<select id="episode_type" name="episode_type" id="episode_type">
					<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
					<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
					<option value="O" selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>					
					<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>
				</select>
			</td>
			
			<td class="label">
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="encounter_id" id="encounter_id" id="encounter_id" size = "15" maxlength="12"  onBlur="ChangeUpperCase( this );if(this.value!=''){encounterIDLkup(this);}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type="button" class="button" name="encidbut" id="encidbut" value='?' onClick="return encounterIDLkup()"  >
			</td>						
			
			<td class="label">
				<fmt:message key="Common.speciality.label" bundle="${common_labels}" />
			</td>
			<td class="fields">
				<input type="text" name='spec_nur_unit_desc' id='spec_nur_unit_desc' id='spec_nur_unit_desc' size="30" maxlength="100" value='' onblur='if(this.value!=""){ SpecNursingUnitLkup(1,spec_nur_unit_desc,spec_nursing_unit_code) } else{ clearCode(spec_nursing_unit_code); }'>
				<input type="hidden" name='spec_nursing_unit_code' id='spec_nursing_unit_code' id='spec_nursing_unit_code' value=''>
				<input type="button" class="button" name="spec_nursing_unit_btn" id="spec_nursing_unit_btn" value='?' onClick="SpecNursingUnitLkup(1,spec_nur_unit_desc,spec_nursing_unit_code);">				
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
				<!-- <span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span> -->
			</td>
			<td class="label">
				<fmt:message key="Common.Payer.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="payer" id="payer" id="payer" size="30" maxlength="100" onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLkup();} else{ clearCode(payer_code); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="hidden" id="payer_code" name="payer_code" id="payer_code" value="">
				<input type="button" class="button" name="payer_btn" id="payer_btn" value='?' onClick="return payerLkup()"/>
				<!-- <span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span> -->
			</td>
			
			<td class="label">
				<fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="policy" id="policy" id="policy" size="50" maxlength="100" onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();} else{ clearCode(policy_type_code); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type="button" class="button" name="policy_btn" id="policy_btn" value='?' onClick="return policyLookup()"/>
				<input type="hidden" id="policy_type_code" name="policy_type_code" id="policy_type_code" value="">
			</td>		
		</tr>
		
		<tr>
			<td class="label" align='right'>
				<fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name='billing_group' id='billing_group' id='billing_group' size='50' maxlength='100' value='' onblur="billGrpLkup(billing_group,billingGrpCode,'Y');" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" />
				<input type="button" class="button" name="BGBut" id="BGBut" id="BGBut" value='?' onClick="return billGrpLkup(billing_group,billingGrpCode,'N');" />
				<input type="hidden" name="billingGrpCode" id="billingGrpCode" id="billingGrpCode" value=''>
			</td>
			
			
			<td class="label">
				<fmt:message key="eBL.SERVICE_GROUP.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="service_group" id="service_group" id="service_group" size="30" onBlur="serviceGrpLookUp()" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" value="" />
				<input type="button" class="button" name="SGBut" id="SGBut" id="SGBut" value='?' onClick="return serviceGrpLookUp()"  />
				<input type="hidden" name="serviceGroupCode" id="serviceGroupCode" id="serviceGroupCode" value=''>
			</td>

			<td class="label">
				<fmt:message key="eBL.SERVICE_CLASSIFICATION.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="service_classification" id="service_classification" id="service_classification" value="" size="50" onBlur="serviceClassificationLookUp();" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" />	
				<input type="button" class="button" name="SCBut" id="SCBut" id="SCBut" value='?' onClick="return serviceClassificationLookUp()"  />
				<input type="hidden" name="serviceClassificationCode" id="serviceClassificationCode" id="serviceClassificationCode" value=''>
			</td>			
		</tr>

		<tr>
			<td class="label">
				<fmt:message key="eBL.Order_status.label" bundle="${bl_labels}"/>
			</td>
			<td>
				<select id="order_status" name="order_status" id="order_status" onchange=''>
					<% if(orderStatusList != null){
						Iterator it = orderStatusList.keySet().iterator();%>
						<option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
						<% while(it.hasNext()){
							String key=(String)it.next(); %>  
							<option value='<%=key%>'><%=orderStatusList.get(key) %></option>
					<% }} %>
				</select>			
			</td>
			
			<td class="label">
				<fmt:message key="eBL.Coding_Status.label" bundle="${bl_labels}" />
			</td>
			<td class="fields">
				<select id="coding_status" name="coding_status" id="coding_status" onchange=''>
					<option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
					<option value="*A"><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
					<option value='NW'><fmt:message key="Common.New.label" bundle="${common_labels}"/></option>
					<option value='DQ'><fmt:message key="eBL.Doctor_Query.label" bundle="${bl_labels}"/></option>
					<option value='SQ'><fmt:message key="eBL.Supervisor_Query.label" bundle="${bl_labels}"/></option>
					<option value="HD"><fmt:message key="Common.Hold.label" bundle="${common_labels}" /></option>
					<option value='PC'><fmt:message key="Common.PartiallyCompleted.label" bundle="${common_labels}"/></option>
					<option value='CO'><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
					<option value='SC'><fmt:message key="eBL.Supervisor_Clearance_completed.label" bundle="${bl_labels}"/></option>
				</select>			
			</td>
			
			<td class="label">
				<fmt:message key="eBL.INS_Status.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<select id="insurance_Status" name="insurance_Status" id="insurance_Status" onChange="">
					<% if(recApprStatusList != null){
						Iterator it = recApprStatusList.keySet().iterator();%>
						<option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
						<% while(it.hasNext()){
							String key=(String)it.next(); %>  
							<option value='<%=key%>'><%=recApprStatusList.get(key) %></option>
					<% }} %>
				</select>	
			</td>
		</tr>
		<tr>		
			<td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="enc_frm_date" id="enc_frm_date" id="enc_frm_date" size = "12" maxlength="10" onblur='encFromDateValidation(this, enc_frm_date,enc_to_date);' value="">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('enc_frm_date');"  onKeyPress="return lockbackSpace();">
				<span class='mandHide'><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
			
			<td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/>
				<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="enc_to_date" id="enc_to_date" id="enc_to_date" size = "12" maxlength="10" onblur='compareCurrent_endDates(enc_to_date);encToDateValidation(this, enc_frm_date,enc_to_date);' value="">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('enc_to_date');"  onKeyPress="return lockbackSpace();">
				<span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>	
			<td class="button" colspan="2">
				<input type="button" name="search_btn" id="search_btn" id="search_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" class="button" onClick='validateFormAndQuery();' />
			</td>
		</tr>
		</table>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" id="prevActionID" name="prevActionID" id="prevActionID"	value="">
		<input type="hidden" id="prevEncounterId" name="prevEncounterId" id="prevEncounterId"	value="">
	</form>
</body>
<%
	}catch(Exception e){
		System.err.println("Error in BLFutOrdInsApprTrackQryCriteria.jsp->"+e.toString());
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);		
	}		
%>
</html>


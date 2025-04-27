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
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script language='javascript' src='../../eBL/js/BLEClaim.js'></script>
<script language="javascript" src="../../eBL/js/AutoFillSearchCriteria.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<style>
.reload {
  font-size:28px;
  font-family: verdana;
  text-align: right;
}

.hidden-text-box {
  position: absolute;
  left: -9999px; /* Move the text box outside the viewport */
}

</style>

<script>

$(document).ready(function(){
	var fun_id = document.getElementById("function_id").value;

	fnAutoFillLoadCriteria(fun_id);
	}); 

</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String function_id=request.getParameter("function_id");
	String sql="";
	String sysdtsql = "";
	String sqlDate = "";
	int pat_id_len= 0;
	BLHelper blHelper = null;
	Map insStatusList = null;
try{
	
	con	=	ConnectionManager.getConnection(request);
	insStatusList = (Map) BLHelper.getListOfItems(con, "BL", "L_INS_CLAIM_STATUS", locale);
	sql ="select patient_id_length from mp_param";

	pstmt = con.prepareStatement(sql);
	rs = pstmt.executeQuery();

	if (rs != null && rs.next() )
	{
		pat_id_len = rs.getInt("patient_id_length") ;
	}

	sysdtsql="select to_char(sysdate,'dd/mm/yyyy') from dual ";
		
	pstmt = con.prepareStatement(sysdtsql);
		
	rs = pstmt.executeQuery();
	if (rs != null && rs.next() )
	{
		sqlDate=rs.getString(1);
	}
	
	} catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally 
	{
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	String todaysDate="";
	String daysBeforeDate="";
	int defaultDate = 7 ;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	todaysDate=dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, -(defaultDate-1)); 
	daysBeforeDate=dateFormat.format(cal.getTime());
	
	String validInsUser = checkForNull(request.getParameter("validInsUser"));
	String validFrontUser = checkForNull(request.getParameter("validFrontUser"));
	System.err.println("validInsUser BLEClaimQueryCriteria.jsp " + validInsUser);
	
%>
<BODY onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	<FORM method='post' name="search" id="search" id="search" action="" onsubmit="" >
	
		<table cellpadding='3' cellspacing=0 width="100%" align="center">
			<tr>
			    <td class="label"  ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" name="patient_id"  id="patient_id" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return patientIdLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return patientIdLookup()" tabindex='2' />
				</td>
				<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" name="patient_name"  id="patient_name" readonly   maxlength="100"  onBlur="ChangeUpperCase( this );"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );" >	
				</td>

				<td class="label"  ><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td class="fields" ><select id="epiType" name='episode_type'  >
					<option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>
					<option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
					<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
					<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>
					<option value='R'><fmt:message key="Common.external.label" bundle="${common_labels}" /></option>
					</select>
				</td>

		</tr>
		<tr>
				<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" name="encounter_id"  id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){encounterIDLkup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type='button' class='button' name="encounterIdBut" id="encounterIdBut" value='?' onClick="return encounterIDLkup()"  tabindex='2'>
				</td>

				<td class="label" ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class="fields"><input type="text" name="payer_group"  id="payer_group" maxlength="30"  onBlur="ChangeUpperCase( this ); payerGrpLkup('D');"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="text" id="payer_grp_code" name="payer_grp_code" id="payer_grp_code" value="" class="hidden-text-box">
				<input type='button' class='button' name="payerGroupBut" id="payerGroupBut" value='?' onClick="return payerGrpLkup('L')"  tabindex='2' /> 
				<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>

				<td class="label" ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td class="fields"><input type="text" name="payer"  id="payer" maxlength="30"  onBlur="ChangeUpperCase( this );payerLkup('D');"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type="text" id="payer_code" name="payer_code" id="payer_code" value="" class="hidden-text-box">
				<input type='button' class='button' name="payerBut" id="payerBut" value='?' onClick="return payerLkup('L')"  tabindex='2' />
				</td>

		</tr>
		<tr>
				<td class="label"  ><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td class="fields"><input type="text" name="policy"  id="policy"    maxlength="100"  onBlur="ChangeUpperCase( this ); policyLookup('D');"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type="text" id="policy_type_code" name="policy_type_code" id="policy_type_code" value="" class="hidden-text-box">
				<input type='button' class='button' name="policyBut" id="policyBut" value='?' onClick="return policyLookup('L')"  tabindex='2'/>
				</td>

				<td class="label"><fmt:message key="eBL.approval_doc_ref_no.label" bundle="${bl_labels}"/></td>
				<td class="fields"><input type='text' name='approval_doc_ref_text'  id="approval_doc_ref_text" maxlength="100" onBlur="ChangeUpperCase( this );if(this.value!=''){ approvalDocRefNoLookup(approval_doc_ref_text,approval_doc_ref_no,approval_doc_ref_type_code);}" value="" onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
				<input type='hidden' name='approval_doc_ref_no'  id='approval_doc_ref_no' value=''>
				<input type='hidden' name='approval_doc_ref_type_code'  id='approval_doc_ref_type_code' value=''>
				<input type='button' class='button' name="approvalDocRefNoBut" id="approvalDocRefNoBut" value='?' onClick="return approvalDocRefNoLookup(approval_doc_ref_text,approval_doc_ref_no,approval_doc_ref_type_code)"  tabindex='2'/>
				</td>

				<td class="label"><fmt:message key="eBL.claim_id.label" bundle="${bl_labels}"/></td>
				<td class="fields"><input type='text' name='claim_id'  id="claim_id" maxlength="100" onBlur="ChangeUpperCase( this );if(this.value!=''){ claimIdLookup();}" value="" onKeyPress="return CheckForSpecChars(event);lockbackSpace();">
				<input type='button' class='button' name="claimIdBut" id="claimIdBut" value='?' onClick="return claimIdLookup()"  tabindex='2'/>
				</td>

		</tr>
		<tr>
			<td class='label' ><fmt:message key="eBL.stat_date_frm.label" bundle="${bl_labels}"/></td>
			<td class="fields">
				<input type="text" name="State_dur_from"  id="State_dur_from" size = "12" maxlength="10" onblur='encFromDateValidation(this, State_dur_from,State_dur_to);' value="<%=daysBeforeDate%>">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('State_dur_from');"  onKeyPress="return lockbackSpace();">
				<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
			</td>

			<td class='label' ><fmt:message key="eBL.stat_date_To.label" bundle="${bl_labels}"/></td>			
			<td class="fields">
				<input type="text" name="State_dur_to" id="State_dur_to" size = "12" maxlength="10" onblur='encToDateValidation(this, State_dur_from,State_dur_to);' value="<%=todaysDate%>">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('State_dur_to');"  onKeyPress="return lockbackSpace();">
				<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
			</td>	

			<td class="label" ><fmt:message key="eBL.claims_services_level.label" bundle="${bl_labels}"/></td>
			<td class="fields">
				<select id="claims_services_level" name="claims_services_level" id="claims_services_level" >
				<option value="C"><fmt:message key="eBL.claims.label" bundle="${bl_labels}"/></option>
				<option value="S"><fmt:message key="eBL.services.label" bundle="${bl_labels}"/></option>
				</select>	
			</td>	

		</tr>
		<tr>
			<td class="label" colspan="4">
				<input type="checkbox" name="saveSearchCriteria"  id='saveSearchCriteria' checked/> 
				&nbsp;<fmt:message key="eBL.SetDefaultValue.label"  bundle="${bl_labels}"/>				
			</td>
			<td class="label">
				<fmt:message key="eBL.INS_Status.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<select id="insurance_Status" name="insurance_Status" id="insurance_Status" onChange="">
					<% if(insStatusList != null){
						Iterator it = insStatusList.keySet().iterator();%>
						<option value="**" selected><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
						<% while(it.hasNext()){
							String key=(String)it.next(); %>  
							<option value='<%=key%>'><%=insStatusList.get(key) %></option>
					<% }} %>
				</select>	
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='button' name="search_button" id="search_button" id='search_button'	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" onClick='validateFormAndQuery();'>
			</td>
		</tr>
		</table> 
			
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='facility_id'  id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='function_id'  id='function_id' value='<%=function_id %>'>
		<input type='hidden' name='todaysDate'  id='todaysDate' value='<%=todaysDate%>'>
		<input type='hidden' name='validInsUser' id='validInsUser' value='<%=validInsUser%>'>
		<input type='hidden' name='validFrontUser' id='validFrontUser' value='<%=validFrontUser%>'>
		<input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
	</form>
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




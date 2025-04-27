<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ page import="eBL.Common.BlRepository"%>
 
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
<script language='javascript' src='../../eBL/js/BLZatcaResponse.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	con	=	ConnectionManager.getConnection(request);
	String sql="";
	int pat_id_len= 0;
	Map zatcaStatusList = new HashMap<String,String>();
	
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String params = request.getParameter("params");
	if(params == null) params = "";
	
	try{
		sql ="select patient_id_length from mp_param";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		if (rs != null && rs.next() )
		{
			pat_id_len = rs.getInt("patient_id_length") ;
		}	
	} catch(Exception e) {
		/* out.println(e.toString()); */
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
	
	zatcaStatusList = (Map) BLHelper.getListOfItems(con, "BL", "L_ZATCA_STATUS", locale);
	System.err.println("zatcaStatusList:"+zatcaStatusList);	
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String todaysDate=dateFormat.format(cal.getTime());
%>
<script>


</script>

<BODY onload = "" onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
<FORM method='post' name="report_form" id="report_form" id="report_form" action="" onsubmit="return onSearch()" >
	<table cellpadding='3' cellspacing=0 width="100%" align="center">
		<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td>
				<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()" tabindex='2' />
			</td>
			<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td>
				<input type="text" name="patient_name" id="patient_name" id="patient_name" readonly   maxlength="100"  onBlur="ChangeUpperCase( this );"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );" >	
			</td>
			<td class='label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td>
				<select id="zatcaStatus" name="zatcaStatus" id="zatcaStatus" onchange=''>
					<% if(zatcaStatusList != null){
						Iterator it = zatcaStatusList.keySet().iterator();%>
						<option value=''>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
						<% while(it.hasNext()){
							String key=(String)it.next(); %>  
							<option value='<%=key%>'><%=zatcaStatusList.get(key) %></option>
					<% }} %>
					
				</select>
			</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td><select id="epiType" name='episode_type' id='episode_type' >
				<!--<option value='S'>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>-->				
				<option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>
				<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>				
				<option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
				<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
				<option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}" /></option>
				</select>
			</td>
			
			<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td>
				<input type="text" name="encounter_id" id="encounter_id" id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){enCounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return enCounterIdLookup()"  tabindex='2'>
			</td>
			<td class="label" ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
			<td>
				<input type="text" name="payer_group" id="payer_group" id="payer_group" maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGroupLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()"  tabindex='2' /> 
			</td>			
		</tr>
		<tr>
				<td class="label" ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td>
					<input type="text" name="payer" id="payer" id="payer" maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
					<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup()"  tabindex='2' />
				</td>
				<td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
				</td>
				<td>
					<input type='text' name='Effective_from' id='Effective_from' id="Effective_from" maxlength="10" onBlur="isValidDate(this);" value="<%=todaysDate%>">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">
					<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>
				<td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/>
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
				<td>
					<input type='text' name='Effective_to' id='Effective_to' id="Effective_to" maxlength="10" onBlur="isValidDate(this);" value="<%=todaysDate%>">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');"  onKeyPress="return lockbackSpace();">
					<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>
		</tr>
		<tr>
				<td colspan='4'></td>				
				<td class="label">Active Bill(s)
					<input type='checkbox' checked name='active_bill_YN' id='active_bill_YN' id="active_bill_YN" value = "Y" onClick="check_active_bill();">
				</td>
				<td class='button'>					
					<input type='button' name="resendToZatca" id="resendToZatca" id='resendToZatca' value="Resend to ZATCA" disabled class='button' onClick='resendZatca();'>					
					<input type='button' name="search_button" id="search_button" id='search_button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" class='button' onClick='onSearch();'>
				</td>
		</tr>
	</table>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='params' id='params' id='params' value='<%=params%>'>
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




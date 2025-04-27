<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*, eCommon.Common.*,org.json.simple.*" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<%	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale			= (String)session.getAttribute("LOCALE");
	String facilityId			= (String) session.getValue("facility_id");


%>


<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/coaderstyle.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eMR/js/MRCoderDiagDtls.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	Connection con				= null;
	Statement stmt				= null;
	JSONArray diagClassCodeArr = new JSONArray();
	JSONObject jsonObj	= new JSONObject();
	JSONObject patDemographicEncDtlsObj	= new JSONObject();
	/* Added by Kamatchi S for AAKH-CRF-0153 Start*/
	int visitId = 0;
	int episodeId = 0;
	String episode_id = "";
	String payer = "";
	String policy_no = "";
	String policy_start_date = "" ;
	String policy_end_date = "" ;
	String membership_id = "";
	String insurance = "";
	String startDate = "";
	String endDate = "";
	SimpleDateFormat fmt1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date policyStart = new java.util.Date();  
	java.util.Date policyEnd = new java.util.Date(); 
	/* Added by Kamatchi S for AAKH-CRF-0153 END*/
	try	{
	String patient_id			= checkForNull(request.getParameter("patient_id"));
	String encounter_id			= checkForNull(request.getParameter("encounter_id"));
	
	
	con = ConnectionManager.getConnection(request);
		//out.println(request.getQueryString());
	diagClassCodeArr  = eMR.MRCoaderDiagBean.getDiagClassCodeType(con);
	patDemographicEncDtlsObj  =  eMR.MRCoaderDiagBean.getPatDemographicEncDtls(con,encounter_id,patient_id,facilityId,locale);
	String patient_name				= (String) patDemographicEncDtlsObj.get("patient_name");
	String date_of_birth			= (String) patDemographicEncDtlsObj.get("date_of_birth");
	String nationality_desc			= (String) patDemographicEncDtlsObj.get("nationality_desc");
	String sex						= (String) patDemographicEncDtlsObj.get("sex");
	String location_desc			= (String) patDemographicEncDtlsObj.get("location_desc");
	String visit_adm_date_time		= (String) patDemographicEncDtlsObj.get("visit_adm_date_time");
	String practitioner_name		= (String) patDemographicEncDtlsObj.get("practitioner_name");
	String payer_dtls				= (String) patDemographicEncDtlsObj.get("payer_dtls");
	String apc_no					= (String) patDemographicEncDtlsObj.get("apc_no");
	String patient_class			= (String) patDemographicEncDtlsObj.get("patient_class");
	String visit_type_desc			= (String) patDemographicEncDtlsObj.get("visit_type_desc");
	String status			= (String) patDemographicEncDtlsObj.get("status"); // AAKH-CRF-0172 US011
	/* Added by Kamatchi S for AAKH-CRF-0153 Start*/
	String visit_Id			= checkForNull(request.getParameter("visit_Id"));
	if(!visit_Id.equals("")){
	visitId=Integer.parseInt(visit_Id);  }
	String episode_type			= "";
	if(patient_class.equals("OP")) episode_type =  "O";
	if(patient_class.equals("IP")) episode_type =  "I";
	if(patient_class.equals("DC")) episode_type =  "D";
	if(patient_class.equals("EM")) episode_type =  "E";
	if( episode_type.equals("O") || episode_type.equals("E") ){
	episode_id			= checkForNull(request.getParameter("episode_id_new"));
	}
	else
	{
	episode_id			= checkForNull(request.getParameter("episode_id"));
	}
	if(!episode_id.equals("")){
	episodeId=Integer.parseInt(episode_id);}  
	insurance = eMR.MRCommonBean.getInsurance(con,facilityId,patient_id,episode_id,episode_type);
	if(insurance.equals("X")){
	JSONObject Json	= eMR.MRCommonBean.getInsuranceDetails(con,facilityId,patient_id,episode_type,episodeId,visitId);
	payer = checkForNull((String) Json.get("payer"));
	policy_no = checkForNull((String) Json.get("policy_no"));
	policy_start_date = checkForNull((String) Json.get("policy_start_date"));
	policy_end_date = checkForNull((String) Json.get("policy_end_date")); 
	if(!policy_start_date.equals("")){
	policyStart = fmt1.parse(policy_start_date);
	startDate= formatter.format(policyStart);
	}
	if(!policy_end_date.equals("")){
	policyEnd = fmt1.parse(policy_end_date);
	endDate= formatter.format(policyEnd);
	}
	membership_id = checkForNull((String) Json.get("membership_id"));
	}
	/* Added by Kamatchi S for AAKH-CRF-0153 END*/
		%>
<center>
<form name="coaderDemographicDtls" id="coaderDemographicDtls" >
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><table width="100%" border="0" cellspacing="0" cellpadding="5">
   
      <tr>
        <td colspan="8" class="BOLD"><fmt:message key="Common.patient.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/>  </td>
      </tr>
      <tr>
		 <!--Commented for AAKH-CRF-0153-->
		<!--
        <td ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
        <td class="txtgray" ><%=patient_name%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
        <td class="txtgray" ><%=nationality_desc%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
        <td class="txtgray" ><%=sex%></td>
      </tr>
      <tr>
        <td ><fmt:message key="Common.DateofBirth.label" bundle="${common_labels}"/></td>
        <td class="txtgray"><%=date_of_birth%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="eMR.MRN.label" bundle="${mr_labels}"/></td>
        <td class="txtgray" ><%=patient_id%></td>
        <td >&nbsp;</td>
		-->
        <td ><fmt:message key="Common.Credit.label" bundle="${common_labels}"/></td>
        <td class="txtgray"><%=payer_dtls%></td>
      </tr>
	  <!--Commented for AAKH-CRF-0153-->
      <!--<tr>
        <td colspan="8" >&nbsp;</td>
        </tr>-->
      <tr>
        <td class="BOLD"><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
        <td class="txtgray">&nbsp;</td>
        <td >&nbsp;</td>
        <td class="BOLD"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/> </td>
         <td class="BOLD "><%=patient_class%></td>
	 <!-- Addes against AAKH-CRF-0172 US011-->
        <td class="BOLD" ><fmt:message key="Common.current.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.CodingStatus.label" bundle="${ca_labels}"/></td>
        <td class="BOLD" ><%=status%></td>
        <td class="txtgray">&nbsp;</td>
      </tr>
      <tr>
        <td ><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
        <td class="txtgray" ><%=location_desc%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
        <td class="txtgray" ><%=visit_type_desc%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
        <td class="txtgray" ><%=encounter_id%></td>
      </tr>
      <tr>
        <td ><fmt:message key="eMR.TreatingPractitioner.label" bundle="${mr_labels}"/></td>
        <td class="txtgray"><%=practitioner_name%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="eMR.LicenseNo.label" bundle="${mr_labels}"/></td>
        <td class="txtgray" ><%=apc_no%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
        <td class="txtgray"><%=visit_adm_date_time%></td>
      </tr>
	<!-- Added for AAKH-CRF-0153 by Kamatchi S-->
	<%if(insurance.equals("X")){%>
      <tr>
		<td ><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
        <td class="txtgray" ><%=payer%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
        <td class="txtgray" ><%=policy_no%></td>
        <td >&nbsp;</td>
        <td ><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
        <td class="txtgray" ><%=startDate%></td>
		</tr>
		<tr>
		<td ><fmt:message key="eBL.PolicyEndDate.label" bundle="${bl_labels}"/></td>
        <td class="txtgray" ><%=endDate%></td>
		<td >&nbsp;</td>
		<td ><fmt:message key="eBL.MembershipID.Label" bundle="${bl_labels}"/></td>
        <td class="txtgray" ><%=membership_id%></td>
		<!--<td colspan="8" class="Borderbottom" >&nbsp;</td><!--Commented for AAKH-CRF-0153-->
		</tr>  
		<%}%>    
    </table></td>
  </tr>
</table>
<%for(int inc = 0 ; inc < diagClassCodeArr.size() ; inc++) { 
	jsonObj	= (JSONObject)diagClassCodeArr.get(inc);
	String diagClassCode = (String) jsonObj.get("diagClassCode");						
	String diagClassType = (String) jsonObj.get("diagClassType");
	%>
	<input type='hidden' name='<%=diagClassCode%>' id='<%=diagClassCode%>' value='<%=diagClassType%>' />
<%}%>

<input type='hidden' name="visit_adm_date_time" id="visit_adm_date_time" value="<%=visit_adm_date_time%>" />

</form>
</center>
		
<%	} catch(Exception ex){
		ex.printStackTrace() ;
	} finally {
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

%>
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
</body>
</html>


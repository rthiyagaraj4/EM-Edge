<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.* ,javax.servlet.*,javax.servlet.http.*,webbeans.eCommon.*,org.json.simple.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Properties p = (java.util.Properties) session.getValue("jdbc"); //Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
%>

<html>
<head>  
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<Script language='javascript' src='../js/MPAuditTrialParameter.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<!--Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534-->
<style>
	.container {
		width:1300px;
	}

	.inner_table_site { 
		width:100%; 
		height: 525px;
		overflow-y: auto;
	}
</style>
<!--End GHL-CRF-0534-->

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="audit_trail_param_form" id="audit_trail_param_form" action="../../servlet/eMP.MpAuditTrialParameter" method="post" target="messageFrame">
<center>
<%
	Connection con = null;
	

	String module			="";
	String Hist_Sex			="";
	String Hist_Birth		="";
	String Hist_Legal		="";
	String Hist_Alias		="";
	String Hist_Address		="";
	String Hist_Occ_Empl	="";	
	String Hist_Susp_Reins	="";
	String Hist_Inac_Acti	="";
	String Hist_Rec_Rev		="";
	String ID1_Type		=	"";
	String ID2_Type		=	"";
	String ID3_Type		=	"";
	String ID4_Type		=	"";
	String Nationality_hist_yn	=	"";
	String Alt_id1_hist_yn		=	"";
	String Alt_id2_hist_yn		=	"";
	String Alt_id3_hist_yn		=	"";
	String Alt_id4_hist_yn		=	"";
	int count	=	0;
	String Alt_id1_desc = "";
	String Alt_id2_desc = "";
	String Alt_id3_desc = "";
	String Alt_id4_desc = "";
	String family_hist_link_yn = "";
	String org_memeber_hist_yn = "";
	String pat_cat_hist_yn = "";
	String family_no_link_yn = "";
	String family_org_id_accept_yn = "";
	String nat_id_prompt = "";
	String nat_id_hist_yn = "";
	String birth_place_code_hist_yn = "";
	String disabled_f_n_link = "";
	String disabled_f_org = "";
	String pat_series_yn="";
         //added by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]

	String old_file_no_yn="";
	
	// added by mujafar for ML-MMOH-CRF-0998 start 
	
	String other_alt_no_yn="";
	String mar_status_yn = "";
	String residence_desc_yn="";
	String regn_date_time_yn="";
	String status_desc_yn="";
	String race_yn="";
	String religion_yn= "";
	String ethnicity_yn = "";
	String next_of_kin_hist_yn="";
	String first_notify_hist_yn="";
	
	// added by mujafar for ML-MMOH-CRF-0998 end

	/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
	ArrayList arrayList = new ArrayList(); 
	String contact1_no_yn = "";
	String contact2_no_yn = "";
	/*End GHL-CRF-0534*/
	
	
	try
	{
		con = ConnectionManager.getConnection(request);
                  

		// below code modified by mujafar for ML-MMOH-CRF-0998	
		
		JSONObject jsonAuditParams = new JSONObject();
		
		 jsonAuditParams= eMP.MPCommonBean.getMPAuditTrailDetails(con);
		
		module	= (String) jsonAuditParams.get("module");
		Hist_Sex = (String) jsonAuditParams.get("Hist_Sex");
		pat_series_yn=(String) jsonAuditParams.get("pat_series_yn"); 
		Hist_Birth = (String) jsonAuditParams.get("Hist_Birth");
		Hist_Legal = (String) jsonAuditParams.get("Hist_Legal");
		Hist_Alias = (String) jsonAuditParams.get("Hist_Alias");
		Hist_Address =(String) jsonAuditParams.get("Hist_Address");
		Hist_Occ_Empl =(String) jsonAuditParams.get("Hist_Occ_Empl");
		Hist_Susp_Reins = (String) jsonAuditParams.get("Hist_Susp_Reins");
		Hist_Inac_Acti = (String) jsonAuditParams.get("Hist_Inac_Acti");
		Hist_Rec_Rev = (String) jsonAuditParams.get("Hist_Rec_Rev");
		ID1_Type=(String) jsonAuditParams.get("ID1_Type");
		ID2_Type= (String) jsonAuditParams.get("ID2_Type");
		ID3_Type= (String) jsonAuditParams.get("ID3_Type");
		ID4_Type= (String) jsonAuditParams.get("ID4_Type");
		Nationality_hist_yn	=	(String) jsonAuditParams.get("Nationality_hist_yn");
		Alt_id1_hist_yn		=	(String) jsonAuditParams.get("Alt_id1_hist_yn");
		Alt_id2_hist_yn		=	(String) jsonAuditParams.get("Alt_id2_hist_yn");
		Alt_id3_hist_yn		=	(String) jsonAuditParams.get("Alt_id3_hist_yn");
		Alt_id4_hist_yn		=	(String) jsonAuditParams.get("Alt_id4_hist_yn");
		family_hist_link_yn		=	(String) jsonAuditParams.get("family_hist_link_yn");
		org_memeber_hist_yn		=	(String) jsonAuditParams.get("org_memeber_hist_yn");
		pat_cat_hist_yn		=	(String) jsonAuditParams.get("pat_cat_hist_yn");
		family_no_link_yn		=	(String) jsonAuditParams.get("family_no_link_yn");
		family_org_id_accept_yn		=	(String) jsonAuditParams.get("family_org_id_accept_yn");
		nat_id_hist_yn		=	(String) jsonAuditParams.get("nat_id_hist_yn");
		nat_id_prompt		=	(String) jsonAuditParams.get("nat_id_prompt");		
		birth_place_code_hist_yn	=	(String) jsonAuditParams.get("birth_place_code_hist_yn");
		old_file_no_yn = (String) jsonAuditParams.get("old_file_no_yn");
                   
		Alt_id1_desc	=	(String) jsonAuditParams.get("Alt_id1_desc");
		Alt_id2_desc	=	(String) jsonAuditParams.get("Alt_id2_desc");
		Alt_id3_desc	=	(String) jsonAuditParams.get("Alt_id3_desc");
		Alt_id4_desc	=	(String) jsonAuditParams.get("Alt_id4_desc"); 
		count           = (Integer)  jsonAuditParams.get("count");
		other_alt_no_yn = (String) jsonAuditParams.get("other_alt_no_yn"); 
		mar_status_yn   = (String) jsonAuditParams.get("mar_status_yn"); 
		residence_desc_yn= (String) jsonAuditParams.get("residence_desc_yn");
		regn_date_time_yn = (String) jsonAuditParams.get("regn_date_time_yn");     
		status_desc_yn = (String) jsonAuditParams.get("status_desc_yn");
		race_yn = (String) jsonAuditParams.get("race_yn");
		religion_yn = (String) jsonAuditParams.get("religion_yn");
		ethnicity_yn = (String) jsonAuditParams.get("ethnicity_yn");
		first_notify_hist_yn=(String) jsonAuditParams.get("first_notify_hist_yn");
		next_of_kin_hist_yn = (String) jsonAuditParams.get("next_of_kin_hist_yn");

		/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
		arrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode1",p);
		contact1_no_yn = (String) jsonAuditParams.get("contact1_no_yn");
		contact2_no_yn = (String) jsonAuditParams.get("contact2_no_yn");
		/*End GHL-CRF-0534*/

%>
<%if(family_no_link_yn.equals("Y"))
 disabled_f_n_link="";
 else
 disabled_f_n_link="disabled";
 if(family_org_id_accept_yn.equals("Y"))
 disabled_f_org="";
 else
 disabled_f_org="disabled";%>
 
<BR>
	<!--Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534-->
	<div class="container">
	<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
		<td colspan='4' class='columnheader'><fmt:message key="eMP.AuditTrailParameterSettings.label" bundle="${mp_labels}"/></td>
		<tr> <td colspan='4'>&nbsp;</td> </tr>
	</table>
	<div class="inner_table_site">
	<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
	<!--End GHL-CRF-0534-->
		<tr>
		<td class="label" width="35%"><fmt:message key="eMP.PatientSex.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Sex_yn" id="Sex_yn" value='<%=Hist_Sex%>' <%if(Hist_Sex.equals("Y")) {%> checked <%}%>   ></td>

		<td class="label" width="35%"><fmt:message key="eMP.PatientDateofBirth.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="BirthDate_yn" id="BirthDate_yn" value='<%=Hist_Birth%>' <%if(Hist_Birth.equals("Y")) {%> checked <%}%> ></td>
	   </tr>
	  <tr> <td colspan='4'>&nbsp;</td> </tr>
		<tr>
		<td class="label" width="35%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="LegalName_yn" id="LegalName_yn" value='<%=Hist_Legal%>' <%if(Hist_Legal.equals("Y")) {%> checked <%}%>   ></td>

		<td class="label" width="35%"><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="AliasName_yn" id="AliasName_yn" value='<%=Hist_Alias%>' <%if(Hist_Alias.equals("Y")) {%> checked <%}%> ></td>
	   </tr>

		<tr> <td colspan='4'>&nbsp;</td> </tr>
		<tr>
		<td class="label" width="35%"><fmt:message key="eMP.FamilyLink.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="FamilyLink_yn" id="FamilyLink_yn" value='<%=family_hist_link_yn%>' <%=disabled_f_n_link%> <%if(family_hist_link_yn.equals("Y")) {%> checked <%}%>   ></td>

		<td class="label" width="35%"><fmt:message key="eMP.OrganizationMembership.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Oraganization_mem_yn" id="Oraganization_mem_yn" value='<%=org_memeber_hist_yn%>' <%=disabled_f_org%> <%if(org_memeber_hist_yn.equals("Y")) {%> checked <%}%> ></td>
	   </tr>

		<tr> <td colspan='4'>&nbsp;</td> </tr>
		<tr>
		<td class="label" width="35%"><fmt:message key="Common.Address.label" bundle="${common_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Address_yn" id="Address_yn" value='<%=Hist_Address%>' <%if(Hist_Address.equals("Y")) {%> checked <%}%>   ></td>
		<td class="label" width="35%"><fmt:message key="eMP.OccupationEmployer.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="OcpnEmpl_yn" id="OcpnEmpl_yn" value='<%=Hist_Occ_Empl%>' <%if(Hist_Occ_Empl.equals("Y")) {%> checked <%}%> ></td>
	   </tr>
	   	<tr> <td colspan='4'>&nbsp;</td> </tr>
	   <tr>
		<td  class="label" ><fmt:message key="Common.nextofkin.label" bundle="${common_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='next_of_kin_hist_yn' id='next_of_kin_hist_yn'  value='<%=next_of_kin_hist_yn%>' <%if(next_of_kin_hist_yn.equals("Y")) {%> checked <%}%>  > </td> 
		
		<td   class="label" ><fmt:message key="Common.firsttonotify.label" bundle="${common_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='first_notify_hist_yn' id='first_notify_hist_yn'  value='<%=first_notify_hist_yn%>' <%if(first_notify_hist_yn.equals("Y")) {%> checked <%}%>  > </td> 
</tr>

	   <tr> <td colspan='4'>&nbsp;</td> </tr>
	   <tr> 
	   <td class="label" width="35%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
		<td  width="15%" class="fields"><input type="checkbox" name="Nationality_hist_yn" id="Nationality_hist_yn" value='<%=Nationality_hist_yn%>' <%if (Nationality_hist_yn != null)if(Nationality_hist_yn.equals("Y")) {%> checked <%}%> ></td>
		<td class="label" width="35%"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Category_yn" id="Category_yn" value='<%=pat_cat_hist_yn%>' <%if (Nationality_hist_yn != null)if(pat_cat_hist_yn.equals("Y")) {%> checked <%}%> ></td>
	   </tr>
	   <tr> <td colspan='4'>&nbsp;</td> </tr>
           <tr> 
	   <td class="label" align="left" width="35%"><%=nat_id_prompt%></td>
		<td align="left" width="15%"><input type="checkbox" name="NatId_yn" id="NatId_yn" value='<%=nat_id_hist_yn%>' <%if (Nationality_hist_yn != null)if(nat_id_hist_yn.equals("Y")) {%> checked <%}%> ></td>
		<td class="label" align="left" width="35%"><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
		<td align="left" width="15%"><input type="checkbox" name="BirthPlace_yn" id="BirthPlace_yn" value='<%=birth_place_code_hist_yn%>' <%if (Nationality_hist_yn != null)if(birth_place_code_hist_yn.equals("Y")) {%> checked <%}%> ></td>
	   </tr>
	   <tr><td colspan='4'>&nbsp;</tr>

		<tr>
		<td class="label" width="35%"><fmt:message key="eMP.SuspendReinstatePatient.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="SuspendReinstate_yn" id="SuspendReinstate_yn" value='<%=Hist_Susp_Reins%>' <%if(Hist_Susp_Reins.equals("Y")) {%> checked <%}%>  ></td>

		<td class="label" width="35%"><fmt:message key="eMP.ActivateInactivatePatient.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="InactiveActivate_yn" id="InactiveActivate_yn" value='<%=Hist_Inac_Acti%>' <%if(Hist_Inac_Acti.equals("Y")) {%> checked <%}%> ></td>
	   </tr>
	   <tr> <td colspan='4'>&nbsp;</td> </tr>
		
	
		<tr>
		<td class="label" nowrap width="35%"><fmt:message key="eMP.RecordRevokePatientDeath.label" bundle="${mp_labels}"/></td>
		<td width="15%" colspan='3' class="fields"><input type="checkbox" name="RecordRevoke_yn" id="RecordRevoke_yn" value='<%=Hist_Rec_Rev%>' <%if(Hist_Rec_Rev.equals("Y")) {%> checked <%}%>  ></td>
		</tr>
		<tr> <td colspan='4'>&nbsp;</td> </tr>




		<tr>
		<td class="label" width="35%"><%=Alt_id1_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id1_hist_yn" id="alt_id1_hist_yn" value='<%=Alt_id1_hist_yn%>' <%if(Alt_id1_hist_yn != null)if(Alt_id1_hist_yn.equals("Y")) {%> checked <%}%>  ></td>

		<%
			if(!ID2_Type.equals("")) // equals() added by mujafar for IN:067104
			{
		%>

		<td class="label" width="35%"><%=Alt_id2_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id2_hist_yn" id="alt_id2_hist_yn" value='<%=Alt_id2_hist_yn%>' <%if(Alt_id2_hist_yn != null)if(Alt_id2_hist_yn.equals("Y")) {%> checked <%}%>   ></td>
	   </tr>
		<tr> <td colspan='4'>&nbsp;</td> </tr>

		<%
		}
		if( (count == 3) && (!ID2_Type.equals(""))) // equals() added by mujafar for IN:067104
		{
		%>
		<tr>
		<%
		}
		if(!ID3_Type.equals("")) // equals() added by mujafar for IN:067104
		{

		%>
		<td class="label" nowrap width="35%"><%=Alt_id3_desc%></td>
		<td width="15%"  colspan='3' class="fields"><input type="checkbox" name="alt_id3_hist_yn" id="alt_id3_hist_yn" value='<%=Alt_id3_hist_yn%>' <%if(Alt_id3_hist_yn != null)if(Alt_id3_hist_yn.equals("Y")) {%> checked <%}%>   ></td>
		<%
		}
		if((count == 3) && ( !ID3_Type.equals("")) && (!ID4_Type.equals(""))) // equals() added by mujafar for IN:067104
		{
		%>
		<tr>
		<%
		}
		if(!ID4_Type.equals("")) // equals() added by mujafar for IN:067104
		{

		%>
		<td class="label" width="35%"><%=Alt_id4_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id4_hist_yn" id="alt_id4_hist_yn" value='<%=Alt_id4_hist_yn%>' <%if(Alt_id4_hist_yn != null)if(Alt_id4_hist_yn.equals("Y")) {%> checked <%}%>   ></td>
		
		<%
		}
		if((count ==1) ||(count ==3))
		{

		%>
			<td colspan='2'>&nbsp;</td>
		<%
		}
		%>

		</tr>


		<tr> <td colspan='4'>&nbsp;</td> </tr>



<tr>
<!--modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041] -->

		<td class="label" width="35%"><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td> 
		<td width="15%" class="fields">
		<% if(pat_series_yn.equals("Y")) {%> 
		<input type="checkbox" name="patseries_yn" id="patseries_yn" value='Y' checked></td>
<%} else {%>
<input type="checkbox" name="patseries_yn" id="patseries_yn" value='N'></td>
<%}%>

<td class="label" width="35%"><fmt:message key="Common.OldFileNo.label" bundle="${common_labels}"/></td> 
		<td width="15%" class="fields">
		<% if(old_file_no_yn.equals("Y")) {%> 
		<input type="checkbox" name="oldfileNo_yn" id="oldfileNo_yn" value='Y' checked></td></tr>
<%} else {%>
<input type="checkbox" name="oldfileNo_yn" id="oldfileNo_yn" value='N'></td></tr>
<%}%>
<!-- below code added by mujafar for ML-MMOH-CRF-0998 -->
 	<tr> <td colspan='4'>&nbsp;</td> </tr>
<tr>
<td class="label" width="35%"><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
<td width="15%" class="fields">
<input type="checkbox" name="other_alt_no_yn" id="other_alt_no_yn" value='<%=other_alt_no_yn%>' <%if(other_alt_no_yn != null)if(other_alt_no_yn.equals("Y")) {%> checked <%}%>  ></td>

		<td   class="label" ><fmt:message key="Common.RegistrationDate.label" bundle="${common_labels}"/> <fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
<td width="15%" class='fields'> <input type="checkbox" name='regn_date_time_yn' id='regn_date_time_yn'  value='<%=regn_date_time_yn%>' <%if(regn_date_time_yn.equals("Y")) {%> checked <%}%>  > </td> 




</tr>
 	<tr> <td colspan='4'>&nbsp;</td> </tr>
<tr>
		<td class='label'  width="35%"  ><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='mar_status_yn' id='mar_status_yn'  value='<%=mar_status_yn%>' <%if(mar_status_yn.equals("Y")) {%> checked <%}%>  > </td> 
		
		<td  class="label" width="35%" > <fmt:message key="Common.residency.label" bundle="${common_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='residence_desc_yn' id='residence_desc_yn'  value='<%=residence_desc_yn%>' <%if(residence_desc_yn.equals("Y")) {%> checked <%}%>  > </td> 
</tr>
 	<tr> <td colspan='4'>&nbsp;</td> </tr>
<tr>
		<td class='label'  width="35%"  ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='status_desc_yn' id='status_desc_yn'  value='<%=status_desc_yn%>' <%if(status_desc_yn.equals("Y")) {%> checked <%}%>  > </td> 
		
		<td  class="label" width="35%" > <fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='race_yn' id='race_yn'  value='<%=race_yn%>' <%if(race_yn.equals("Y")) {%> checked <%}%>  > </td> 
</tr>
	 	<tr> <td colspan='4'>&nbsp;</td> </tr>	
<tr>
		<td  class="label" ><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='religion_yn' id='religion_yn'  value='<%=religion_yn%>' <%if(religion_yn.equals("Y")) {%> checked <%}%>  > </td> 
		
		<td   class="label" ><fmt:message key="eMP.ethnicity.label" bundle="${mp_labels}"/></td>
		<td width="15%" class='fields'> <input type="checkbox" name='ethnicity_yn' id='ethnicity_yn'  value='<%=ethnicity_yn%>' <%if(ethnicity_yn.equals("Y")) {%> checked <%}%>  > </td> 
</tr>

<!-- below code added by mujafar for ML-MMOH-CRF-0998 -->

<!--Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534-->
<tr> <td colspan='4'>&nbsp;</td> </tr>

<tr>
		<td  class="label" ><%=(String)arrayList.get(0)%></td>
		<td width="15%" class='fields'> <input type="checkbox" name='contact1_no_yn' id='contact1_no_yn'  value='<%=contact1_no_yn%>' <%if(contact1_no_yn.equals("Y")) {%> checked <%}%>  > </td> 
		
		<td   class="label" ><%=(String)arrayList.get(1)%></td>
		<td width="15%" class='fields'> <input type="checkbox" name='contact2_no_yn' id='contact2_no_yn'  value='<%=contact2_no_yn%>' <%if(contact2_no_yn.equals("Y")) {%> checked <%}%>  > </td> 
</tr>

</table>
</div>
</div>
<!--End GHL-CRF-0534-->

<input type='hidden' name='module_id' id='module_id' value='<%=module%>'> 

</form>
</center>
</body>
</html>

<%
	arrayList.clear(); //Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534
	}
	catch(Exception e) { 
		//out.println(e.getMessage());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174139204 on 28-08-2023
		}
	
	finally 
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


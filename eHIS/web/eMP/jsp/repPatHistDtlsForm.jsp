<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../js/repPatHistDtls.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;

	try{
	String alt_id1_type  = "";
	String alt_id2_type  = "";
	String alt_id3_type  = "";
	String alt_id4_type  = "";
	//String appl_user_name="";
	//String appl_user_id  ="";
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPTHST" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");
	String nat_id_prompt  = "";
	int Patient_Id_Length=0	;
	
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
	
	//added by mujafar for ML-MMOH-CRF-0998 end

	/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
	Properties p = (java.util.Properties) session.getValue("jdbc");
	ArrayList arrayList = new ArrayList(); 
	String contact1_no_yn = "";
	String contact2_no_yn = "";
	/*End GHL-CRF-0534*/

	
%>
<BR>
<body onLoad="Focusing('p_hist_type');" onKeyDown = 'lockKey()'>
<center>
	<form name="repPatHistDtls" id="repPatHistDtls" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table cellpadding='3' cellspacing='0' width='70%' border='0'>
		<tr>
			<td width='30%'>&nbsp;</td>
			<td width='30%'>&nbsp;</td>
			<td width='10%'>&nbsp;</td>
			<td width='30%'>&nbsp;</td>
		</tr>
		<tr>
			<td class="label"  ><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='p_hist_type' id='p_hist_type'>
			<option value=''>----------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------------------
				<%
							con = ConnectionManager.getConnection(request);
							//pstmt = con.prepareStatement("Select PATIENT_ID_LENGTH, sex_hist_yn, birth_date_hist_yn, legal_name_hist_yn, alias_name_hist_yn, address_hist_yn, ocpn_n_empl_hist_yn, suspend_reinstate_hist_yn, inact_act_hist_yn, rec_revoke_death_hist_yn, coded_pseudo_name_hist_yn, contact_no_hist_yn, general_alert_info_hist_yn,  alt_id1_hist_yn, (CASE WHEN alt_id1_type IS NOT NULL THEN (SELECT short_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id1_type) END ) alt_id1_type, alt_id2_hist_yn, (CASE WHEN alt_id2_type IS NOT NULL THEN (SELECT short_desc    FROM mp_alternate_id_type WHERE alt_id_type = alt_id2_type) END) alt_id2_type, alt_id3_hist_yn,(CASE WHEN alt_id3_type IS NOT NULL THEN (SELECT short_desc    FROM mp_alternate_id_type WHERE alt_id_type = alt_id3_type) END) alt_id3_type, alt_id4_hist_yn,(CASE WHEN alt_id4_type IS NOT NULL THEN (SELECT short_desc    FROM mp_alternate_id_type WHERE alt_id_type = alt_id4_type) END) alt_id4_type, nationality_hist_yn,FAMILY_LINK_HIST_YN,ORG_MEMBER_HIST_YN,PAT_CAT_HIST_YN from mp_param_lang_vw where language_id='"+localeName+"'"); 
							pstmt = con.prepareStatement("SELECT PATIENT_ID_LENGTH, sex_hist_yn,OLD_FILE_NO_YN, birth_date_hist_yn, legal_name_hist_yn, alias_name_hist_yn, address_hist_yn, ocpn_n_empl_hist_yn, suspend_reinstate_hist_yn, inact_act_hist_yn, rec_revoke_death_hist_yn, coded_pseudo_name_hist_yn, contact_no_hist_yn, general_alert_info_hist_yn, alt_id1_hist_yn, (CASE WHEN alt_id1_type IS NOT NULL THEN (MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+localeName+"',1)) END) alt_id1_type, alt_id2_hist_yn, (CASE WHEN alt_id2_type IS NOT NULL THEN (MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+localeName+"',1)) END) alt_id2_type, alt_id3_hist_yn, (CASE WHEN alt_id3_type IS NOT NULL THEN (MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+localeName+"',1)) END) alt_id3_type, alt_id4_hist_yn, (CASE WHEN alt_id4_type IS NOT NULL THEN (MP_GET_DESC.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+localeName+"',1)) END) alt_id4_type, nationality_hist_yn,FAMILY_LINK_HIST_YN,ORG_MEMBER_HIST_YN,PAT_CAT_HIST_YN,NAT_ID_HIST_YN, nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT, BIRTH_PLACE_CODE_HIST_YN,other_alt_no_yn,mar_status_yn,residence_desc_yn,regn_date_time_yn,status_desc_yn,race_yn,religion_yn,ethnicity_yn,next_of_kin_hist_yn,first_notify_hist_yn,contact1_no_yn,contact2_no_yn FROM mp_param");  // modified by mujafar for ML-MMOH-CRF-0998
							rs = pstmt.executeQuery();
							if(rs != null){
								while(rs.next()) {
									Patient_Id_Length = rs.getInt("Patient_Id_Length");

									alt_id1_type = rs.getString("alt_id1_type");
									if (alt_id1_type==null) alt_id1_type = "";
									alt_id2_type = rs.getString("alt_id2_type");
									if (alt_id2_type==null) alt_id2_type = "";
									alt_id3_type = rs.getString("alt_id3_type");
									if (alt_id3_type==null) alt_id3_type = "";
									alt_id4_type = rs.getString("alt_id4_type");
									if (alt_id4_type==null) alt_id4_type = "";

									nat_id_prompt = rs.getString("NAT_ID_PROMPT");
									if (nat_id_prompt==null) nat_id_prompt = "";
									
									
									//added by mujafar for ML-MMOH-CRF-0998 start
									
									other_alt_no_yn = rs.getString("other_alt_no_yn");
									if (other_alt_no_yn==null) other_alt_no_yn = "";
									
									mar_status_yn = rs.getString("mar_status_yn");
									if (mar_status_yn==null) mar_status_yn = "";
									
									residence_desc_yn = rs.getString("residence_desc_yn");
									if (residence_desc_yn==null) residence_desc_yn = "";
									
									regn_date_time_yn = rs.getString("regn_date_time_yn");
									if (regn_date_time_yn==null) regn_date_time_yn = "";
									
									status_desc_yn = rs.getString("status_desc_yn");
									if (status_desc_yn==null) status_desc_yn = "";
									
									race_yn = rs.getString("race_yn");
									if (race_yn==null) race_yn = "";
									
									religion_yn = rs.getString("religion_yn");
									if (religion_yn==null) religion_yn = "";
									
									ethnicity_yn = rs.getString("ethnicity_yn");
									if (ethnicity_yn==null) ethnicity_yn = "";
									
									next_of_kin_hist_yn = rs.getString("next_of_kin_hist_yn");
									if (next_of_kin_hist_yn==null) next_of_kin_hist_yn = "";
									
									first_notify_hist_yn = rs.getString("first_notify_hist_yn");
									if (first_notify_hist_yn==null) first_notify_hist_yn = "";
									
									// added by mujafar for ML-MMOH-CRF-0998 end
									
									
									/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
									arrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode1",p);

									contact1_no_yn = rs.getString("contact1_no_yn");
									if (contact1_no_yn==null) contact1_no_yn = "";
									
									contact2_no_yn = rs.getString("contact2_no_yn");
									if (contact2_no_yn==null) contact2_no_yn = "";
									/*End GHL-CRF-0534*/
									
									
									
									
									
									
									
									

									if (rs.getString("sex_hist_yn").equals("Y"))
										{out.println("<Option value=10>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</Option>");}
									if (rs.getString("birth_date_hist_yn").equals("Y"))
										{out.println("<Option value=20>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</Option>");}
									if (rs.getString("legal_name_hist_yn").equals("Y"))
										{out.println("<Option 	value=30>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</Option>");
										out.println("<Option value=35>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientNameLocal.label","mp_labels")+"</Option>");}
									if (rs.getString("alias_name_hist_yn").equals("Y"))
										{out.println("<Option value=40>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AliasName.label","mp_labels")+"</Option>");}				
									if (rs.getString("contact_no_hist_yn").equals("Y"))
										{out.println("<Option value=60>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contactNo.label","common_labels")+"</Option>");}		
									if (rs.getString("suspend_reinstate_hist_yn").equals("Y"))
										{out.println("<Option value=80>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");}
										{out.println("<Option value=90>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reinstated.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");}
									if (rs.getString("inact_act_hist_yn").equals("Y"))
										{out.println("<Option value=100>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");}
										{out.println("<Option value=110>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");}
									if (rs.getString("rec_revoke_death_hist_yn").equals("Y"))
										{out.println("<Option value=120>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");}
										{out.println("<Option value=130>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");}
									if (rs.getString("ocpn_n_empl_hist_yn").equals("Y"))
										{out.println("<Option value=140>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.employerdetails.label","common_labels")+"</Option>");}
									if (rs.getString("address_hist_yn").equals("Y"))
										{out.println("<Option value=150>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.residenceaddress.label","mp_labels")+"</Option>");
										out.println("<Option value=155>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MailingAddress.label","common_labels")+"</Option>");}
									if (rs.getString("alt_id1_hist_yn").equals("Y"))
										{out.println("<Option value=160>"+alt_id1_type);}
									if (rs.getString("alt_id2_hist_yn").equals("Y"))
										{out.println("<Option value=170>"+alt_id2_type);}
									if (rs.getString("alt_id3_hist_yn").equals("Y"))
										{out.println("<Option value=180>"+alt_id3_type);}
									if (rs.getString("alt_id4_hist_yn").equals("Y"))
										{out.println("<Option value=190>"+alt_id4_type);}
									if (rs.getString("nationality_hist_yn").equals("Y"))
										{out.println("<Option value=200>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")+"</Option>");}
									if (rs.getString("FAMILY_LINK_HIST_YN").equals("Y"))
										{out.println("<Option value=220>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FamilyLink.label","mp_labels")+"</Option>");}
									if (rs.getString("ORG_MEMBER_HIST_YN").equals("Y"))
										{out.println("<Option value=230>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OrganizationMembership.label","mp_labels")+"</Option>");}
									if (rs.getString("PAT_CAT_HIST_YN").equals("Y"))
										{out.println("<Option value=210>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels")+"</Option>");}
									if (rs.getString("NAT_ID_HIST_YN").equals("Y"))
										{out.println("<Option value=240>"+nat_id_prompt+"</Option>");}
									if (rs.getString("BIRTH_PLACE_CODE_HIST_YN").equals("Y"))
									{
										out.println("<Option value=250>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")+"</Option>");
									}
									
									if (rs.getString("OLD_FILE_NO_YN").equals("Y"))
									{
										out.println("<Option value=280>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OldFileNo.label","common_labels")+"</Option>");
									}
									
									//added by mujafar for ML-MMOH-CRF-0998 start
									
									if (rs.getString("other_alt_no_yn").equals("Y"))
									{out.println("<Option value='290'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"</Option>");}
								if (rs.getString("mar_status_yn").equals("Y"))
									{out.println("<Option value='300'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.maritalstatus.label","mp_labels")+"</Option>");}
								if (rs.getString("residence_desc_yn").equals("Y"))
									{out.println("<Option value='330'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residency.label","common_labels")+"</Option>");}
								if (rs.getString("regn_date_time_yn").equals("Y"))
									{out.println("<Option value='430'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Registrationdatetime.label","common_labels")+"</Option>");}
								if (rs.getString("status_desc_yn").equals("Y"))
									{out.println("<Option value='350'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</Option>");}
								if (rs.getString("race_yn").equals("Y"))
									{out.println("<Option value='370'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")+"</Option>");}
								if (rs.getString("religion_yn").equals("Y"))
									{out.println("<Option value='390'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels")+"</Option>");}
								if (rs.getString("ethnicity_yn").equals("Y"))
									{out.println("<Option value='410'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ethnicity.label","mp_labels")+"</Option>");}
								if (rs.getString("next_of_kin_hist_yn").equals("Y"))
									{out.println("<Option value='450'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nextofkin.label","common_labels")+"</Option>");}
								if (rs.getString("first_notify_hist_yn").equals("Y"))
									{out.println("<Option value='460'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.firsttonotify.label","common_labels")+"</Option>");}
									
								// added by mujafar for ML-MMOH-CRF-0998 end	

								/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
								if (rs.getString("contact1_no_yn").equals("Y"))
									{out.println("<Option value='480'>"+(String)arrayList.get(0)+"</Option>");}
								if (rs.getString("contact2_no_yn").equals("Y"))
									{out.println("<Option value='500'>"+(String)arrayList.get(1)+"</Option>");}
								/*End GHL-CRF-0534*/
									
								}
										out.println("<option value='260'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+"</option>");
							}
																	
					%>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td class="label"  ><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="p_user_id" id="p_user_id" size="20" maxlength='20' readonly><input type='button' name='usergrp' id='usergrp' value='?' class='button' onclick="usersearchCode(this, 
						p_user_id,'N')">
				</td>
			
				<%
						

					/*	if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();
						pstmt = con.prepareStatement("Select appl_user_name,appl_user_id from sm_appl_user where eff_status='E' order by appl_user_name "); 
						rs = pstmt.executeQuery();
							if(rs != null){
								while(rs.next()) {
									appl_user_id = rs.getString("appl_user_id");
									
									appl_user_name = rs.getString("appl_user_name");
								
									 out.println("<option value='"+appl_user_id+ "' >"+appl_user_name+"</option>");
									
								}
							}	*/					
					%>  
				<!-- </select> -->
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
				<td class="label" ><fmt:message key="eMP.PatientIDFrom.label" bundle="${mp_labels}"/></td>
				<td class='fields'><input type="text" name="p_fr_patient_id" id="p_fr_patient_id" size="20" maxlength=<%=Patient_Id_Length%> onBlur="ChangeUpperCase(this);"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick='PatSearch(p_fr_patient_id)'>
				</td>

				<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_to_patient_id" id="p_to_patient_id" size="20" maxlength=<%=Patient_Id_Length%>  onBlur="ChangeUpperCase(this);"><input type='button' name='patsergrp' id='patsergrp' value='?' class='button' onclick='PatSearch(p_to_patient_id)'>
				</td>
			</tr>
		<tr>
			<td class="label"  ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='p_order_by' id='p_order_by'>
				<option value='3' selected><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></option>
				<option value='2' ><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

		</table>

		<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id%>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%=p_module_id%>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
		<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=p_user_name%>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%=p_resp_id%>">
	</form>
<%
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}catch(Exception e){out.println(e);}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
} %>
</center>
</body>
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


<!DOCTYPE html>
<!-- Last Modified Date Time : 9/27/2005 11:49 AM -->

<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<HEAD>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String alt_id1_type = "";
	String alt_id2_type = "";
	String alt_id3_type = "";
	String alt_id4_type = "";
	String nat_id_prompt  = "";
	
	// Below code added by mujafar for ML-MMOH-CRF-0998 START
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
	
	// Below code added by mujafar for ML-MMOH-CRF-0998 END

	/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
	Properties p = (java.util.Properties) session.getValue("jdbc");
	ArrayList arrayList = new ArrayList(); 
	String contact1_no_yn = "";
	String contact2_no_yn = "";
	/*End GHL-CRF-0534*/
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eMP/js/PatHistSearch.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onLoad="focusField()" onKeyDown = 'lockKey()'>
<form name="PatientHistorySearchForm" id="PatientHistorySearchForm" target="messageFrame">
<table width='100%' align='center' valign='top'>
	<th align='left'> <fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='100%' cellPadding="0" cellSpacing="0"  align='left'>
				<tr>
				<%
					try{
						con = ConnectionManager.getConnection(request);
				String locale=(String)session.getAttribute("LOCALE");

				
				arrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode1",p); //Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534

%>
					<td align='right' width='15%' class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
				<%
					int patlen = 0;
					pstmt = con.prepareStatement("select patient_id_length from mp_param");
					rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()) {
							patlen = rs.getInt("patient_id_length");
						}
					}
				%>
					<td  align="left" width="25%"><input type=text name='Patient_ID' id='Patient_ID' size="20" value = '' onBlur='changeCase(this)' 
					onKeyPress='return CheckForSpecChars(event)'
					maxlength=<%=patlen%>><input type='button' name='pat_id' id='pat_id' value='?' class='button' onclick='PatSearch()'>
					&nbsp;<img src='../images/mandatory.gif'></img></td>
					<td align='right' width='15%' class="label">
					<fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/>&nbsp;</td>
					<td align="left" width="25%"><Select name="History_Type" id="History_Type">
					<Option value=0>&nbsp; -----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;</Option>
					<%
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
                                     //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
					pstmt = con.prepareStatement("SELECT sex_hist_yn,old_file_no_yn,birth_date_hist_yn, legal_name_hist_yn, alias_name_hist_yn, address_hist_yn, ocpn_n_empl_hist_yn, suspend_reinstate_hist_yn, inact_act_hist_yn, rec_revoke_death_hist_yn, coded_pseudo_name_hist_yn, contact_no_hist_yn, general_alert_info_hist_yn, alt_id1_hist_yn, alt_id2_hist_yn, (CASE WHEN alt_id1_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id1_type) END ) alt_id1_type, (CASE WHEN alt_id2_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id2_type) END) alt_id2_type, (CASE WHEN alt_id3_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id3_type) END) alt_id3_type, (CASE WHEN alt_id4_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id4_type) END) alt_id4_type, alt_id3_hist_yn, alt_id4_hist_yn, nationality_hist_yn,FAMILY_LINK_HIST_YN,ORG_MEMBER_HIST_YN,PAT_CAT_HIST_YN,nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT ,NAT_ID_HIST_YN,BIRTH_PLACE_CODE_HIST_YN,PAT_SER_GRP_HIST_YN,other_alt_no_yn,mar_status_yn,residence_desc_yn,regn_date_time_yn,status_desc_yn,race_yn,religion_yn,ethnicity_yn,next_of_kin_hist_yn,first_notify_hist_yn,contact1_no_yn,contact2_no_yn FROM mp_Param_lAng_vw where language_id='"+locale+"'");  // modified by mujafar for ML-MMOH-CRF-0998 END

					rs = pstmt.executeQuery();
						if(rs != null){
							while(rs.next()) {
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
									
									// added by mujafar for ML-MMOH-CRF-0998 start
									
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
									
									// added by mujafar for ML-MMOH-CRF-0998 END

									/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
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
									{	out.println("<Option 	value=30>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</Option>");
										out.println("<Option value=35>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientNameLocal.label","mp_labels")+"</Option>");
										}
									if (rs.getString("alias_name_hist_yn").equals("Y"))
										{out.println("<Option value=40>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AliasName.label","mp_labels")+"</Option>");}				
									if (rs.getString("contact_no_hist_yn").equals("Y"))
										{out.println("<Option value=60>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contactNo.label","common_labels")+"</Option>");}		
									if (rs.getString("suspend_reinstate_hist_yn").equals("Y"))
									{	out.println("<Option value=80>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
										out.println("<Option value=90>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reinstated.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
									}
									if (rs.getString("inact_act_hist_yn").equals("Y"))
									{
										out.println("<Option value=100>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
										out.println("<Option value=110>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
									}
									if (rs.getString("rec_revoke_death_hist_yn").equals("Y"))
									{	out.println("<Option 	value=120>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
										out.println("<Option value=130>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
									}
									if (rs.getString("ocpn_n_empl_hist_yn").equals("Y"))
										{out.println("<Option value=140>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.employerdetails.label","common_labels")+"</Option>");}
									if (rs.getString("address_hist_yn").equals("Y"))
										{
										out.println("<Option value=150>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.residenceaddress.label","mp_labels")+"</Option>");
										out.println("<Option value=155>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MailingAddress.label","common_labels")+"</Option>");
										}
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
										{out.println("<Option value=210>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels")+"</Option>");
                                    if (rs.getString("NAT_ID_HIST_YN").equals("Y"))
										{out.println("<Option value=240>"+nat_id_prompt+"</Option>");}
									if (rs.getString("BIRTH_PLACE_CODE_HIST_YN").equals("Y")) { 				out.println("<Option value=250>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")+"</Option>");
									}
									if (rs.getString("PAT_SER_GRP_HIST_YN").equals("Y")) { 
										out.println("<Option value=270>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+"</Option>");
									}
							}	
                                                                      //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
									if (rs.getString("old_file_no_yn").equals("Y"))
									{out.println("<Option value='280'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OldFileNo.label","common_labels")+"</Option>");}
								
								// added by mujafar for ML-MMOH-CRF-0998 start
								
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
								
								// added by mujafar for ML-MMOH-CRF-0998 END

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
					</Select></td>
					<td align='left' width='5%' class="label"><input type='button' name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onclick='search()'>
					</td>
					<td align='left' width='5%' class="label">&nbsp;&nbsp;<input type='button' name='Clear' id='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clear_frame()'>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { out.println(e.toString());}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
</table>
</form>
</BODY>
</HTML>

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


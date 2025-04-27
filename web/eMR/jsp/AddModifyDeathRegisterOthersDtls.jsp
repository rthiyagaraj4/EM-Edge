<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.StringTokenizer,java.util.HashMap,eCommon.XSSRequestWrapper" %>

<% 


	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;


//	Properties p						= (java.util.Properties) session.getValue( "jdbc" );
	String sStyle						=  checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	//String login_user				= p.getProperty( "login_user" ) ;
	String facilityId					= ((String)session.getValue("facility_id"));
	//String locale						= ((String)session.getAttribute("LOCALE"));

	String patient_id				=	checkForNull(request.getParameter("patient_id"));
	String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
	//String locn_code				=	checkForNull(request.getParameter("Locn_Code"));
	String gender	 					=	checkForNull(request.getParameter("gender"));
	//String dob							=	checkForNull(	request.getParameter("Dob"));
	//String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
	//String episode_id				=	checkForNull(request.getParameter("episode_id"));
	//String attnd_pract_id		=	checkForNull(request.getParameter("practitioner_id"));
	//String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
	//String patient_class			=	checkForNull(request.getParameter("patient_class"));
	//String call_from					=	checkForNull(request.getParameter("call_from"));
	//String episode_type			=	checkForNull(request.getParameter("episode_type"));
	//String mode						=	checkForNull(request.getParameter("mode"));
	String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));
	String	hide_preg_dtls		=	"";
	String	disp_preg_dtls		=	"";
	String	mlc_yn					=	"";
	String	pol_rep_no			=	"";
	String	pol_stn_id			=	"";
	String	pol_id					=	"";
	String	mlc_chk_val			=	"";
	String	death_by_pregnancy_yn			=	"";
	String	gestational_unit		=	"";
	String	gestational_period		=	"";
	//String	pregnancy_value			=	"";
	String	gestnl_blck					=	"";
	String	not_pregnt_chk			=	"";
	String	pregnt_chk					=	"";
	String	dtls_unkn_chk				=	"";
	String	delivered_less_weeks_yn	 =	"";
	String	delivrd_wks	="";
	String	delivrd_wks_chk	="";
	String	remarks				="";
	String mlc_chk_dis		  ="";

	HashMap addl_fields_map = new HashMap();
try{
		conn=ConnectionManager.getConnection(request);
		
		/*Below line(s) added by venkateshs against ML-MMOH-CRF-0354 [IN057191] */
	     boolean siteSpecific		=eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","MLC_TO_MEDICO_LEGAL_CASE"); 
	   /*end ML-MMOH-CRF-0354 [IN057191] */

		String MLC_DTLS_SQL =	"SELECT DEATH_BY_PREGNANCY_YN, MEDICAL_LEGAL_CASE_YN, GESTATIONAL_UNIT, GESTATIONAL_PERIOD,REMARKS, POL_REP_NO, POL_STN_ID, POL_ID,ADDL_FIELD1, ADDL_FIELD2, ADDL_FIELD3, ADDL_FIELD4, ADDL_FIELD5,DELIVERED_LESS_THAN_6_WEEKS_YN  FROM MR_DEATH_REGISTER_HDR WHERE PATIENT_ID =? AND ENCOUNTER_ID =? AND FACILITY_ID =? ";
		pstmt=conn.prepareStatement(MLC_DTLS_SQL);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,encounter_id);
		pstmt.setString(3,facilityId);
		rs=pstmt.executeQuery();
		while(rs.next()){
			mlc_yn			=	checkForNull(rs.getString("MEDICAL_LEGAL_CASE_YN"),"N");
			pol_rep_no	=	checkForNull(rs.getString("POL_REP_NO"));
			pol_stn_id	=	checkForNull(rs.getString("POL_STN_ID"));
			pol_id			=	checkForNull(rs.getString("POL_ID"));
			death_by_pregnancy_yn			=	checkForNull(rs.getString("DEATH_BY_PREGNANCY_YN"));
			gestational_unit			=	checkForNull(rs.getString("GESTATIONAL_UNIT"));
			gestational_period	=	checkForNull(rs.getString("GESTATIONAL_PERIOD"));
			addl_fields_map.put("ADDL_FIELD1",checkForNull(rs.getString("ADDL_FIELD1")));
			addl_fields_map.put("ADDL_FIELD2",checkForNull(rs.getString("ADDL_FIELD2")));
			addl_fields_map.put("ADDL_FIELD3",checkForNull(rs.getString("ADDL_FIELD3")));
			addl_fields_map.put("ADDL_FIELD4",checkForNull(rs.getString("ADDL_FIELD4")));
			addl_fields_map.put("ADDL_FIELD5",checkForNull(rs.getString("ADDL_FIELD5")));
			delivered_less_weeks_yn		=	checkForNull(rs.getString("DELIVERED_LESS_THAN_6_WEEKS_YN"));
			remarks								=	checkForNull(rs.getString("REMARKS"));


		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();

		String unit_of_gest_nb="";
		String min_gestation		  ="";
		String max_gestation		  ="";
		String unit_of_gest_lbl	  ="";


		if(gender.equals("F")){
			String GEST_DTLS_SQL ="SELECT UNIT_OF_GEST_NB, MIN_GESTATION, MAX_GESTATION FROM MP_PARAM";
			pstmt=conn.prepareStatement(GEST_DTLS_SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				unit_of_gest_nb= checkForNull(rs.getString("UNIT_OF_GEST_NB"));
				min_gestation	= checkForNull(rs.getString("MIN_GESTATION"));
				max_gestation	= checkForNull(rs.getString("MAX_GESTATION"));
			}
			if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();

			hide_preg_dtls	="visible";
			disp_preg_dtls	="";

			if(unit_of_gest_nb.equals("W")){
				unit_of_gest_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
			}else if(unit_of_gest_nb.equals("D")){
				unit_of_gest_lbl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");;
			}
		}else{
			hide_preg_dtls	="hidden";
			disp_preg_dtls	="";
		}
		if(mlc_yn.equals("Y")){
			mlc_chk_val="checked";
			mlc_chk_dis="";
		}else{
			mlc_chk_val="";
			mlc_chk_dis="disabled";
		}
		if(death_by_pregnancy_yn.equals("P")){
			 pregnt_chk="checked";
			gestnl_blck="";
			delivrd_wks="";
		}else if(death_by_pregnancy_yn.equals("N")){
			not_pregnt_chk="checked";
			gestnl_blck="";
			delivrd_wks	 ="";
		}else if(death_by_pregnancy_yn.equals("U")){
			dtls_unkn_chk="checked";
			gestnl_blck="";
			delivrd_wks	 ="";
		}else{
			gestnl_blck="";
			delivrd_wks	 ="";
		}
		if(delivered_less_weeks_yn.equals("Y")){
			delivrd_wks_chk="checked";
		}
		String diable_remarks="";
		if(finalize_yn.equals("Y")){
			diable_remarks="readonly";
		}else{
			diable_remarks	 ="";
		}
		String MR_PARAM_ADDLFLDS_SQL="SELECT 'ADDL_FIELD1' FIELD_NAME,ADDL_FIELD1_PROMPT PROMPT, ADDL_FIELD1_LENGTH LENGTH, ADDL_FIELD1_SECTION SECTION FROM   MR_PARAMETER A UNION SELECT 'ADDL_FIELD2' FIELD_NAME,ADDL_FIELD2_PROMPT, ADDL_FIELD2_LENGTH, ADDL_FIELD2_SECTION FROM   MR_PARAMETER B UNION SELECT 'ADDL_FIELD3' FIELD_NAME,ADDL_FIELD3_PROMPT, ADDL_FIELD3_LENGTH, ADDL_FIELD3_SECTION FROM   MR_PARAMETER C UNION SELECT 'ADDL_FIELD4' FIELD_NAME,ADDL_FIELD4_PROMPT, ADDL_FIELD4_LENGTH, ADDL_FIELD4_SECTION FROM MR_PARAMETER D UNION SELECT 'ADDL_FIELD5' FIELD_NAME,ADDL_FIELD5_PROMPT, ADDL_FIELD5_LENGTH, ADDL_FIELD5_SECTION FROM   MR_PARAMETER E ";

%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src="../../eMR/js/DeathRegister.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

	</head>
	<body onload="diableFilelds3()">
		<form name="DR_OtherDtls_Form" id="DR_OtherDtls_Form">
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
					<tr>
						<td colspan="6" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					</tr>
					<tr></tr>
					<tr>
						<td class="label" width='3%' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td class="fields" width='15%' ><textarea name="remarks"  ROWS="2" COLS="50" onBlur="checkMaxLen(this)" <%=diable_remarks%>><%=remarks%></textarea></td>
					</tr>
						<%
							pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
							rs=pstmt.executeQuery();
							int k=0;
							while(rs.next()){
							String section=checkForNull(rs.getString("SECTION"));
							if(section.equals("C")){
								String addl_prompt	= checkForNull(rs.getString("PROMPT"));
//								String addl_length=checkForNull(rs.getString("LENGTH"),"0");
								int maxlength=Integer.parseInt(checkForNull(rs.getString("LENGTH")));
								int size=(maxlength+15);
								String addl_field=checkForNull(rs.getString("FIELD_NAME"));
								String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));
								if(k==0){%>
								<tr>  <%}%>
								<td  class="label" width='5%'   nowrap><%=addl_prompt%></td>
								<td class="fields"><input type="text"  size="<%=size%>" maxlength="<%=maxlength%>" name="<%=addl_field%>" value="<%=addl_field_val%>" onkeypress="return doCheck(event);"/><td></td>
								<%
									k++;
									if(k==1){
									k = 0; %>
									</tr>
							<%	}
							}
						}
				%>
			</table>

			<table width='100%' cellpadding='1' cellspacing='0' border='0' style="visibility:<%=hide_preg_dtls%>;display:<%=disp_preg_dtls%>" >
					<tr>
						<td colspan="12" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="eMR.femalepatientstatus.label" bundle="${mr_labels}"/></td>
					</tr>
					<tr></tr>
 					<tr>
						<td>
						<div style="float:left; width:34%;">
							<table width='100%' cellpadding='1' cellspacing='0' border='0' >
								<tr>
								<td width='1%'  class="fields" ><input type='radio' name="not_pregnant" id="not_pregnant" value='<%=death_by_pregnancy_yn%>' onclick='getVal(this);' <%=not_pregnt_chk%>></td>
								<td width='8%'  class="label" nowrap><fmt:message key="eMR.notpregnant.label" bundle="${mr_labels}"/></td>
								<td width='1%'   class="fields"><input type='radio' name="pregnant" id="pregnant" value='' onclick='getVal(this);showGestation(this);' value='<%=death_by_pregnancy_yn%>' <%=pregnt_chk%>></td>
								<td width='1%'   class="label" nowrap><fmt:message key="Common.Pregnant.label" bundle="${common_labels}"/></td>
								<td width='1%'  class="fields"><input type='radio' name="preg_dtls_unknown" id="preg_dtls_unknown" value='N' onclick='getVal(this);' <%=death_by_pregnancy_yn%> <%=dtls_unkn_chk%>></td>
								<td width='10%'class="label" nowrap><fmt:message key="Common.detailsunknown.label" bundle="${common_labels}"/></td>
							</tr>
						</table>
						</div>
						<div style="float: left;width:60%;">
						<table width='100%' cellpadding='1' cellspacing='0' border='0'>
							<tr>
								<td width='35%'  class="label"  id="gest_age" style="display:<%=gestnl_blck%>" align='left'><fmt:message key="eMR.gestationalage.label" bundle="${mr_labels}"/>&nbsp;<input type='textbox' name="preg_gestational_age" id="preg_gestational_age" id="gest_age_txt" style="display:<%=gestnl_blck%>" value='<%=gestational_period%>' size='3' maxlength='3' onBlur="return validateMinMax(this,'<%=min_gestation%>','<%=max_gestation%>',preg_gestational_age);makeValidString(this);CheckNum(this);return allowValidNumber(this,'event',3,0)" onKeyPress='return allowValidNumber(this,event,3,0)'>&nbsp;<B><%=unit_of_gest_lbl%></B>
								<input type="hidden" name="unit_of_gest_nb_hid" id="unit_of_gest_nb_hid" value="<%=unit_of_gest_nb%>"/>
								</td>
								<td width='65%'  class="label" style="display:inline" <%=delivrd_wks%>" id="dlivr_wks_lbl"><input type='checkbox' name="preg_deliver_wks" id="preg_deliver_wks" id="dlivr_wks_btn" style="display:<%=delivrd_wks%>" value='<%=delivered_less_weeks_yn%>' <%=delivrd_wks_chk%>  onclick='getChkBoxVal(this);'>&nbsp;<fmt:message key="eMR.deliveredlessthan6weeks.label" bundle="${mr_labels}"/>
								</td>	
							</tr>
						</table>
						</div>
						</td>
						<td>
						</td>
					</tr>
					<tr></tr>
			</table>
			<%if(gender.equals("F")){%>
			<table width='100%' cellpadding='1' cellspacing='0' border='0'>
				<%
					pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
					rs=pstmt.executeQuery();
					int j=0;
					while(rs.next()){
					String section=checkForNull(rs.getString("SECTION"));
					if(section.equals("P")){
						String addl_prompt	= checkForNull(rs.getString("PROMPT"));
//						String addl_length=checkForNull(rs.getString("LENGTH"),"0");
						int maxlength=Integer.parseInt(checkForNull(rs.getString("LENGTH")));
						int size=(maxlength+15);
						String addl_field=checkForNull(rs.getString("FIELD_NAME"));
						String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));
						if(j==0){%>
						<tr>  <%}%>
						<td  class="label" width='5%' nowrap><%=addl_prompt%></td>
						<td class="fields" width='13%'><input type="text"  size="<%=size%>" maxlength="<%=maxlength%>" name="<%=addl_field%>" value="<%=addl_field_val%>" onkeypress="return doCheck(event)" /><td></td>
						<%
							j++;
							if(j==1){
							j = 0; %>
							</tr>
					<%	}
					}
				}
		%>
		</table>
	<%}%>
			<table width='100%' cellpadding='1' cellspacing='0' border='0' >
			 <% if (siteSpecific){%>
					<tr> 
						<td colspan="15" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label"  bundle="${common_labels}"/></td>
					</tr>
					<%}else{%>
					<tr> 
						<td colspan="15" class='PANELTOOLBAR' id="Diag_icon"><fmt:message key="Common.mlc.label"  bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label"  bundle="${common_labels}"/></td>
						
					</tr>
					<%}%>
					<tr></tr>
					<tr>
					   
					    <%if(siteSpecific){%>
							<td width='15%' class="label" nowrap><fmt:message key="Common.MedicalLegalCase.label" bundle="${common_labels}"/></td>
						<%}else{%>
						<td width='15%' class="label" nowrap><fmt:message key="Common.mlc.label"  bundle="${common_labels}"/></td>
						<%}%>
						<td width='3%' class="fields"><input type='checkbox' name="mlc" id="mlc" value='<%=mlc_yn%>' <%=mlc_chk_val%> onclick="getChkBoxVal(this);enableMLCDtls(this)"></td>
						<td width='20%' class="label" nowrap><fmt:message key="Common.PoliceReportNo.label"  bundle="${common_labels}"/></td>
						<td width='3%' class="fields"><input type='text' name="mlc_police_rept_no" id="mlc_police_rept_no" maxLength='20' size='25' value="<%=pol_rep_no%>" <%=mlc_chk_dis%> onkeypress="return doCheck(event)"></td>
						<td width='20%' class="label"></td>
						<td width='35%' class="fields"></td>

					</tr>
					<tr>
						<td class="label" nowrap><fmt:message key="Common.station.label"  bundle="${common_labels}"/></td>
						<td class="fields"><input type='text' name="mlc_police_station" id="mlc_police_station" maxLength="20" size="25" value="<%=pol_stn_id%>" <%=mlc_chk_dis%> onkeypress="return doCheck(event)"></td>
						<td class="label" nowrap><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
						<td  class="fields"><input type='text' name="mlc_id" id="mlc_id" maxLength='20' size='25' value="<%=pol_id%>" <%=mlc_chk_dis%> onkeypress="return doCheck(event)"></td>
						<td  class="label"></td>
						<td  class="fields"></td>

					</tr>
				<%
					pstmt=conn.prepareStatement(MR_PARAM_ADDLFLDS_SQL);
					rs=pstmt.executeQuery();
					int i=0;
					while(rs.next()){
					String section=checkForNull(rs.getString("SECTION"));

					if(section.equals("M")){
						String addl_prompt	= checkForNull(rs.getString("PROMPT"));
//						String addl_length		= checkForNull(rs.getString("LENGTH"),"0");
						int maxlength=Integer.parseInt(checkForNull(rs.getString("LENGTH")));
						int size=(maxlength+15);
						String addl_field=checkForNull(rs.getString("FIELD_NAME"));
						String addl_field_val=checkForNull((String)addl_fields_map.get(addl_field));
						if(i==0){%>
						<tr>  <%}%>
						<td  class="label" nowrap><%=addl_prompt%></td>
						<td  class="fields" ><input type="text"  size="<%=size%>" maxlength="<%=maxlength%>" name="<%=addl_field%>" value="<%=addl_field_val%>" onkeypress="return doCheck(event)" />
						<%
							i++;
							if(i ==1){
							i= 0; %>
							</tr>
					<%	}
					}
				}
		%>

		</table>
		<input type="hidden" name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>">
		</form>
	</body>
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);
	}%></html>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


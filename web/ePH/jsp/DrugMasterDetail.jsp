<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>

<%!  public String getCheckStatus(String value)	{
	 if(value.equals("null") || value==null)
		 value ="N";
		 if(value.equals("Y"))
			 return "checked";
		 else
			 return "";
		}

		 public String getCheckValue(String value)	{
		 if(value.equals("") || value==null || value.equals("null"))
			 return "N";
		 else
			 return value;
		}
%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></script>
			<script LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></script>
			<script language="JavaScript" src="../js/PhCommon.js"></script>
			<script language="JavaScript" src="../js/DrugMasterDetail.js"></script>
			<script language="JavaScript" src="../js/DrugMaster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
<%
		String link			=	request.getParameter("link");
		String generic_id	=	request.getParameter("generic_id");
		String bean_id		= "DrugMasterBean" ;
		String bean_name	= "ePH.DrugMasterBean";
		String disabled		=	"";
		String mode			=	"";

		/*** Variable Declarations Start******/
		String	drug_type_1						=	"";
		String	drug_type_2						=	"";
		String	drug_type_3						=	"";
		String drug_type						=	"";
		String trial_drug_yn					=	"N";
		String trial_drug_yn_chk				=	"";
		String drug_schedule					=	"";
		String restricted_drug_yn				=	"N";
		String restricted_drug_yn_chk			=	"";
		String affects_pregnancy_yn				=	"N";
		String medn_admin_dtl_reqd_yn_chk		=	"";
		String medn_admin_dtl_reqd_yn			=	"N";
		String affects_pregnancy_yn_chk			=	"";

		String affects_breast_feeding_yn		=	"N";
		String affects_breast_feeding_yn_chk	=	"";
		String affects_lab_results_yn			=	"N";
		// code added by senthil kumar j on 16/4/2004
		String pat_con_req						=	"N";
		//ended....
		String affects_lab_results_yn_chk		=	"";
		// code added by senthil kumar j on 16/4/2004
		String pat_con_req_chk					=   "";
		//ended....
		String stability_reqd_yn				=	"N";

		String stability_reqd_yn_chk			=	"";
		String stability_hrs					=	"";
		// code added by srijagadeesh on 18/11/2004 
		String tdm_applicable_yn				=	"N";
		String tdm_applicable_yn_chk			=	"";
		String var_order_appl_during_MAR_yn		=	"N";
		String app_for_comprx_yn				=   "N";
		String app_for_comprx_yn_chk			=   "";
		String var_order_appl_during_MAR_yn_chk	=	"";
		String drug_information					=	"";
		String patient_education				=	"";
		String weight_record					=	"";
		String diag_record						=	"";
		String diag_record_1					=	"";
		String diag_record_2					=	"";
		String screen_note						=	"";
		String item_image_filename = "";
		String strEDLCodes = "";
		String strEDLDescriptions="";
		String strEDLRemarks="";
		String fdaCategorySearchCode ="";
		String fdaCategorySearchText ="";
		String categoryGroupCode ="";
		String categoryCode1 ="";
		String categoryCode2 ="";
		String categoryCode3 ="";
		String npb_drug						=	"N";//code added for Bru-HIMS-CRF-070 [IN029935]
		String npb_drug_chk					=	"";// code added for Bru-HIMS-CRF-070 [IN029935]
		String preg_eff						=	"";// added for RUT-CRF-0063 [IN:029601]
		String preg_eff_st					=	"";// added for RUT-CRF-0063 [IN:029601]
		String preg_eff_tt					=	"";// added for RUT-CRF-0063 [IN:029601]
		String warn_req_yn_ft				=	"N";// added for RUT-CRF-0063 [IN:029601]
		String warn_req_yn_st				=	"N";// added for RUT-CRF-0063 [IN:029601]
		String warn_req_yn_tt				=	"N";// added for RUT-CRF-0063 [IN:029601]
		String warn_req_yn_ft_chk			=	"";// added for RUT-CRF-0063 [IN:029601]
		String warn_req_yn_st_chk			=	"";// added for RUT-CRF-0063 [IN:029601]
		String warn_req_yn_tt_chk			=	"";// added for RUT-CRF-0063 [IN:029601]
		String drugEffectMandDisplay = "";
		String patient_stock_required_chk		=	"";//added for ghl-crf-0482
		String patient_stock_required_yn			=	"N";////added for ghl-crf-0482
		String expiry_alert_days            ="";//Added for TH-KW-CRF-0008

		String rest_anti_justform_yn			= "N"; // Added for KDAH-CRF-0610
		String rest_anti_justform_duration		= ""; // Added for KDAH-CRF-0610
		String rest_anti_justform_duration_disabled = "";// Added for KDAH-CRF-0610
		String rest_anti_justform_yn_chk		= "";  // Added for KDAH-CRF-0610
		boolean rest_anti_justform				= false;  // Added for KDAH-CRF-0610

		String sql_fda_pregnancy_category_search_LookUp = "SELECT CATEGORY_GROUP_CODE CODE, CATEGORY_GROUP_DESC DESCRIPTION FROM PH_PREGN_CAT_GROUP_HDR_LANG_VW WHERE  UPPER(CATEGORY_GROUP_CODE) LIKE UPPER(?) AND UPPER(CATEGORY_GROUP_DESC) LIKE UPPER(?)  AND EFF_STATUS='E' AND LANGUAGE_ID = ";
		/*** Variable Declarations End******/

		if(link==null)
					link	=	"";
		if(generic_id==null)
				generic_id	=	"";
		
		DrugMasterBean bean			= (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		ArrayList schedule			=	bean.loadSchedule();
		String drug_class			=	bean.getDrugClass(generic_id);
		mode						=	bean.getMode() ;
		//Added for ghl-crf-0482  start
				 Connection con				= null;
				 con						= ConnectionManager.getConnection(request);
				// added for ghl-crf-0482  end
		try{
			boolean patient_stock_required = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PATIENT_STOCK_REQUIRED");//Added for  GHL-CRF-0482 
					 rest_anti_justform	   = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_REST_ANTI_JUST_FORM");//Added for  KDAH-CRF-0610   

			ArrayList	characteristics	=	bean.getCharacteristics();
	/*out.println("The characteristics size is:"+characteristics.size()+"');</script>");
	for(int l=0; l<characteristics.size(); l++)	{
		out.println("Value"+l+": "+ (String)characteristics.get(l));
	}*/
	//out.println(characteristics.size());
			if(characteristics.size()!= 0 )	{
				drug_type							=	(String)characteristics.get(0);
				drug_schedule						=	(String)characteristics.get(1);
				restricted_drug_yn					=	(String)characteristics.get(2);
				trial_drug_yn						=	(String)characteristics.get(3);
				affects_pregnancy_yn				=	(String)characteristics.get(4);
				affects_breast_feeding_yn			=	(String)characteristics.get(5);
				affects_lab_results_yn				=	(String)characteristics.get(6);
				stability_reqd_yn					=	(String)characteristics.get(7);
				stability_hrs						=	(String)characteristics.get(8);
				pat_con_req							=	(String)characteristics.get(9);
				tdm_applicable_yn					=	(String)characteristics.get(10);
				var_order_appl_during_MAR_yn		=	(String)characteristics.get(11);
				app_for_comprx_yn					=	(String)characteristics.get(12);
				medn_admin_dtl_reqd_yn				=	(String)characteristics.get(13);
				drug_information					=	(String)characteristics.get(14);
				patient_education					=	(String)characteristics.get(15);
				weight_record						=	(String)characteristics.get(16);
				diag_record							=	(String)characteristics.get(17);
				screen_note							=	(String)characteristics.get(18);
				item_image_filename					=	(String)characteristics.get(19)==null?"":(String)characteristics.get(19);
				strEDLCodes							=	(String)characteristics.get(20)==null?"":(String)characteristics.get(20);
				strEDLRemarks						=	(String)characteristics.get(21)==null?"":(String)characteristics.get(21);
				categoryGroupCode					=	(String)characteristics.get(22);
				categoryCode1					    =	(String)characteristics.get(23);
				categoryCode2					    =	(String)characteristics.get(24);
				categoryCode3					    =	(String)characteristics.get(25);
				fdaCategorySearchText			    =	(String)characteristics.get(26);
				npb_drug						    =	(String)characteristics.get(27);// code added for Bru-HIMS-CRF-070 [IN029935]
				preg_eff						    =	(String)characteristics.get(28);//added for RUT-CRF-0063 [IN:029601]
				preg_eff_st						    =	(String)characteristics.get(29);//added for RUT-CRF-0063 [IN:029601]
				preg_eff_tt						    =	(String)characteristics.get(30);//added for RUT-CRF-0063 [IN:029601]
				warn_req_yn_ft						=	(String)characteristics.get(31);//added for RUT-CRF-0063 [IN:029601]
				warn_req_yn_st						=	(String)characteristics.get(32);//added for RUT-CRF-0063 [IN:029601]
				warn_req_yn_tt						=	(String)characteristics.get(33);//added for RUT-CRF-0063 [IN:029601]
				patient_stock_required_yn		=	(String)characteristics.get(34);////added for ghl-crf-0482
				expiry_alert_days                   =	(String)characteristics.get(35)==null?"":(String)characteristics.get(35);//Added for TH-KW-CRF-0008
				rest_anti_justform_yn			    = 	(String)characteristics.get(36);//Added for KDAH-CRF-0610
				rest_anti_justform_duration		    = 	(String)characteristics.get(37)==null?"":(String)characteristics.get(37);//Added for KDAH-CRF-0610
System.err.println("====REST_ANTI_JUSTFORM_YN======================"+rest_anti_justform_yn);
				if(!strEDLCodes.equals("")){
					String strParams[] = strEDLCodes.split(",");
					StringBuffer sbParamQueryParams = new StringBuffer(" WHERE EDL_CODE IN ('");
					for(int i=0;i<strParams.length;i++)
						sbParamQueryParams.append(strParams[i]+"','");
					sbParamQueryParams.replace(sbParamQueryParams.length()-2,sbParamQueryParams.length(),")");
					strEDLDescriptions = bean.getEDLDescriptions(sbParamQueryParams.toString());
					strEDLDescriptions = strEDLDescriptions.substring(1,strEDLDescriptions.length()-1);
				}

				if(drug_type.equals("I"))		
					drug_type_1		=	"Selected";
				else if(drug_type.equals("V"))  
					drug_type_2		=	"Selected";
				else if(drug_type.equals("S"))  
					drug_type_3		=	"Selected";
				if(diag_record.equals("R"))		
					diag_record_1	=	"Selected";
				else if(diag_record.equals("S"))  
					diag_record_2	=	"Selected";

				trial_drug_yn_chk					=	getCheckStatus(trial_drug_yn				);
				restricted_drug_yn_chk				=	getCheckStatus(restricted_drug_yn			);
				affects_pregnancy_yn_chk			=	getCheckStatus(affects_pregnancy_yn			);
				medn_admin_dtl_reqd_yn_chk			=	getCheckStatus(medn_admin_dtl_reqd_yn		);
				affects_breast_feeding_yn_chk		=	getCheckStatus(affects_breast_feeding_yn		);
				affects_lab_results_yn_chk			=	getCheckStatus(affects_lab_results_yn		);
				stability_reqd_yn_chk				=	getCheckStatus(stability_reqd_yn				);
				pat_con_req_chk						=	getCheckStatus(pat_con_req				);
				tdm_applicable_yn_chk				=	getCheckStatus(tdm_applicable_yn			);
				var_order_appl_during_MAR_yn_chk	=	getCheckStatus(var_order_appl_during_MAR_yn			);
				
				app_for_comprx_yn_chk				=	getCheckStatus(app_for_comprx_yn);
				trial_drug_yn						=	getCheckValue(trial_drug_yn );
				restricted_drug_yn					=	getCheckValue(restricted_drug_yn );
				affects_pregnancy_yn				=	getCheckValue(affects_pregnancy_yn );
				affects_breast_feeding_yn			=	getCheckValue(affects_breast_feeding_yn );
				affects_lab_results_yn				=	getCheckValue(affects_lab_results_yn );
				stability_reqd_yn					=	getCheckValue(stability_reqd_yn );
				pat_con_req							= 	getCheckValue(pat_con_req );
				tdm_applicable_yn					=	getCheckValue(tdm_applicable_yn );
				var_order_appl_during_MAR_yn		=	getCheckValue(var_order_appl_during_MAR_yn );
				app_for_comprx_yn					=   getCheckValue(app_for_comprx_yn);
				app_for_comprx_yn_chk				=	getCheckStatus(app_for_comprx_yn);
				npb_drug_chk						=	getCheckStatus(npb_drug);// code added for Bru-HIMS-CRF-070 [IN029935]
				warn_req_yn_ft_chk                  =   getCheckStatus(warn_req_yn_ft);
				warn_req_yn_st_chk                  =   getCheckStatus(warn_req_yn_st);
				warn_req_yn_tt_chk                  =   getCheckStatus(warn_req_yn_tt);
System.err.println("====patient_stock_required_yn======================"+patient_stock_required_yn);
				if(patient_stock_required_yn==null) patient_stock_required_yn="N";
System.err.println("====patient_stock_required_yn INTERNAL HANDLE======================"+patient_stock_required_yn);
patient_stock_required_yn	= getCheckValue(patient_stock_required_yn); //getting Null Pointer Exception
System.err.println("====AFTER patient_stock_required_yn======================"+patient_stock_required_yn);
				patient_stock_required_chk			=   getCheckStatus(patient_stock_required_yn);//added for ghl-crf-0482
System.err.println("====NOT COMING patient_stock_required_yn======================"+patient_stock_required_yn);
System.err.println("====REST_ANTI_JUSTFORM_YN======================"+rest_anti_justform_yn);
				rest_anti_justform_yn			    =   getCheckValue(rest_anti_justform_yn);//added for KDAH-CRF-0610
System.err.println("===rest_anti_justform_yn===============After get Check Value"+rest_anti_justform_yn);
				if(rest_anti_justform_yn!=null && rest_anti_justform_yn.equals("Y")) 
						rest_anti_justform_duration_disabled = "";
				else 
						rest_anti_justform_duration_disabled = "DISABLED"; 
				rest_anti_justform_yn_chk			=	getCheckStatus(rest_anti_justform_yn);//added for KDAH-CRF-0610
			
System.err.println("===rest_anti_justform_yn_chk==============="+rest_anti_justform_yn_chk);

			}
%>
			<body  onKeyDown="lockKey()" topmargin="0" onMouseDown="CodeArrest()" onLoad = "parent.loadPregnancyCategoryValues('<%=categoryGroupCode%>','<%=categoryCode1%>','<%=categoryCode2%>','<%=categoryCode3%>')">
				<form name="drugMasterDetailForm" id="drugMasterDetailForm" >
					<table cellpadding="0" cellspacing="2" width="100%" align="left" border="0">
<%
						if(drug_class!=null &&  drug_class.equals("N")){
							disabled="disabled";
						}
						else{
							disabled="";
						}
%>
						<tr>
							<td class="label" colspan="1" nowrap width='25%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
							<td class="field"nowrap width='20%'>
								<select name="drug_type" id="drug_type"  onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm'); parent.updateschedule(this);" >
									<option value="X">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
									<option value="I" <%=drug_type_1%>><fmt:message key="ePH.InfectionControl.label" bundle="${ph_labels}"/> </option>
									<option value="V"<%=drug_type_2%>><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/> </option>
									<option value="S"<%=drug_type_3%>><fmt:message key="ePH.Poisonous/Scheduled.label" bundle="${ph_labels}"/></option>
								</select>
							</td>
							<td class="label" nowrap nowrap width='25%'><fmt:message key="ePH.AffectsBreastFeeding.label" bundle="${ph_labels}"/></td>
							<td class="field"><input type="checkbox" name="affects_breast_feeding_yn" id="affects_breast_feeding_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=affects_breast_feeding_yn%>" <%=affects_breast_feeding_yn_chk%>></td>
	<%	 if(rest_anti_justform) {  	%>
							<td class="label"><fmt:message key="ePH.RestrictedAntimicrobialsJustificationForm.label" bundle="${ph_labels}"/> </td>  <!-- Added for KDAH-CRF-0610-->
							<td class="field"><input type="checkbox" name="rest_anti_justform_yn" id="rest_anti_justform_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');chkAntiMicrobials(document.drugMasterDetailForm,this);" value="<%=rest_anti_justform_yn%>" <%=rest_anti_justform_yn_chk%>>
							</td>
   <% } else { %>
							<td class="label" colspan='2'>&nbsp;</td>
   <% } %>
						</tr>
						<!-- 	<tr>
									<td align="right" class="label" nowrap>Infection Control Drug</td>
									<td align="left">&nbsp;<input type="checkbox" name="drug_type_1" id="drug_type_1" onclick="parent.assignValue(this);parent.validateDrugType('I');parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" <%=drug_type_1%> <%=disabled%> >
									</td>
							</tr>
							<tr height="3"><td colspan="6" ></td></tr>					<td align="right" class="label">ATTP</td>
									<td align="left">&nbsp;<input type="checkbox" name="drug_type_2" id="drug_type_2" onclick="parent.assignValue(this);parent.validateDrugType('V');parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" <%=drug_type_2%> <%=disabled%> >
									</td>
							</tr>
							<tr height="3"><td colspan="6" ></td></tr>
							<tr>
									<td align="right" class="label">Poisonous/Scheduled</td>
									<td align="left">&nbsp;<input type="checkbox" name="drug_type_3" id="drug_type_3" onclick="parent.assignValue(this);parent.validateDrugType('S');parent.validateSchedule(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" <%=drug_type_3%> <%=disabled%>></td>
							</tr> -->
							<tr>
								<td  class="label"><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></td>
								<td class="field">
									<select name="schedule" id="schedule" onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');parent.updateSchedulinMain(this);" disabled>
									<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
									for(int i=0;i<schedule.size();i++){
										HashMap data = new HashMap();
										data = (HashMap)schedule.get(i);

										if((data.get("schedule_id")).equals(drug_schedule))	{
%>
											<option value="<%=data.get("schedule_id")%>" selected><%=data.get("schedule_desc")%></option>
											<script>parent.schedule_val['<%=data.get("schedule_id")%>']='<%=data.get("disp_auth_reqd_yn")%>'</script>
<%
										}
										else{
%>
											<option value="<%=data.get("schedule_id")%>"><%=data.get("schedule_desc")%></option>
											<script>parent.schedule_val['<%=data.get("schedule_id")%>']='<%=data.get("disp_auth_reqd_yn")%>'</script>
<%
										}
									}
 %>
								</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" id="schedule_man" style="visibility:hidden">
								</td>
								<td class="label" nowrap><fmt:message key="ePH.AffectsLabResults.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="affects_lab_results_yn" id="affects_lab_results_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=affects_lab_results_yn%>" <%=affects_lab_results_yn_chk%>></td>
 
								
			<%		if(rest_anti_justform) {  	%>				
								<!-- Added for KDAH-CRF-0610-->
								<td class="label" nowrap><fmt:message key="ePH.RestrictedAntimicrobialsJustificationFormDuration.label" bundle="${ph_labels}"/> </td>
								<td class="field">
									<input type="text" name="rest_anti_justform_duration" id="rest_anti_justform_duration" value="<%=rest_anti_justform_duration%>" <%=rest_anti_justform_duration_disabled%> onBlur="checkZero(this);" onfocus="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" onKeyPress="return(ChkNumberInput(this,event,0));" maxlength="2" size="2" style="text-align:right"  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="restricted_antimicrobials" 
									<% if(rest_anti_justform_yn!=null && rest_anti_justform_yn.equals("Y")) { %>
										style="visibility:visible">
			<%						} else { %> 
										style="visibility:hidden">
			<%						}	%> 
									<fmt:message key="Common.days.label" bundle="${ph_labels}"/>
							</td>
			<%		} else { %>
							<td class="label" colspan='2'>&nbsp;</td>
			<%		}	%>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.Non-EssentialRestrictedDrug.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="restricted_drug_yn" id="restricted_drug_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" value="<%=restricted_drug_yn%>" <%=restricted_drug_yn_chk%>></td>
								<td class="label" nowrap><fmt:message key="ePH.StabilityApplicable.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="stability_reqd_yn" id="stability_reqd_yn" onclick="parent.assignValue(this);parent.validateStability(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" value="<%=stability_reqd_yn%>" <%=stability_reqd_yn_chk%>></td>
							</tr>
							<tr>
								<td class="label"><fmt:message key="ePH.TrialDrug.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="trial_drug_yn" id="trial_drug_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=trial_drug_yn%>" <%=trial_drug_yn_chk%>>
								</td>
								<td class="label"><fmt:message key="ePH.Stability.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="text" name="stability_hrs" id="stability_hrs" value="<%=stability_hrs%>" onfocus="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" onKeyPress="return(ChkNumberInput(this,event,0));" maxlength="4" size="4" style="text-align:right" disabled ><label class ='label'>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></label><img src="../../eCommon/images/mandatory.gif" align="center" id="stability_man" style="visibility:hidden">&nbsp;</td>
							</tr>
<%
							if(stability_reqd_yn!=null && stability_reqd_yn.equals("Y")){
%>
								<script>document.drugMasterDetailForm.stability_hrs.disabled=false;</script>
<%
							}
%>
							<tr>
								<!-- code added for Bru-HIMS-CRF-070 [IN029935] --Start -->
								<td class="label" nowrap><fmt:message key="ePH.NBPDRUG.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="npb_drug" id="npb_drug" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" value="<%=npb_drug%>" <%=npb_drug_chk%> ></td>	<!-- code added for Bru-HIMS-CRF-070 [IN029935] --End -->
								<td class="label" nowrap><fmt:message key="ePH.PatientCounsellingRequired.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="pat_con_req" id="pat_con_req" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" value="<%=pat_con_req%>" <%=pat_con_req_chk%> ></td>
							</tr>
								<td class="label"><fmt:message key="ePH.AffectsPregnancy.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="affects_pregnancy_yn" id="affects_pregnancy_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');parent.enableFDA(this);" value="<%=affects_pregnancy_yn%>" <%=affects_pregnancy_yn_chk%>></td>
								<td class="label"><fmt:message key="ePH.PregnancyCategoryForDrug.label" bundle="${ph_labels}"/> </td>
								<td class="field"><input type="text" name="fdaSearch" id="fdaSearch" maxlength="60" size="30"  value="<%=fdaCategorySearchText%>" onblur="parent.searchFDA(document.drugMasterDetailForm.fdaSearch);checkCategoryValues(this);" onfocus="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" disabled >
								<input type="button" class="button"
								value="?" name="fdaSearch_lookup" id="fdaSearch_lookup" onClick="parent.searchFDA1(document.drugMasterDetailForm.fdaSearch);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" disabled></td>
								<td class="label" nowrap><fmt:message key="ePH.AlertDrugExpiry.label" bundle="${ph_labels}"/><!-- Added TH-KW-CRF-0008 -->				
								<input type="text" size="3" name="expiry_alert_days" id="expiry_alert_days"  maxlength="3" class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" onfocus="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onchange="parent.updateExpiryDaysMain(this);" value="<%=expiry_alert_days%>"/> &nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
							</tr>
							<tr>
								<td class="label" > <fmt:message key="ePH.FirstTrimester.label" bundle="${ph_labels}"/> 
								<td class="field">
									<select name="fda_FirstTrimester" id="fda_FirstTrimester" width="20"  style="width: 140px"  onChange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" disabled>							    
										<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
									</select>
								</td>
								<td class="label"><fmt:message key="ePH.SecondTrimester.label" bundle="${ph_labels}"/> </td>
								<td class="field" >
									<select name="fda_SecondTrimester" id="fda_SecondTrimester" width="20" style="width: 140px" onChange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" disabled>
										<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
									</select>
								</td>
								<td class="label"><fmt:message key="ePH.ThirdTrimester.label" bundle="${ph_labels}"/> </td>
								<td class="field">
									<select name="fda_ThridTrimester" id="fda_ThridTrimester" width="20" style="width: 140px" onChange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')"  disabled>								 
										<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="label" ><fmt:message key="ePH.WarningRequired.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="warn_reqd_yn_ft" id="warn_reqd_yn_ft" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');drugEffectMand('F', this);" value="<%=warn_req_yn_ft%>" <%=warn_req_yn_ft_chk%>></td>
								<td class="label"><fmt:message key="ePH.WarningRequired.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="warn_reqd_yn_st" id="warn_reqd_yn_st" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');drugEffectMand('S', this);" value="<%=warn_req_yn_st%>" <%=warn_req_yn_st_chk%>></td>
								<td class="label"><fmt:message key="ePH.WarningRequired.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="warn_reqd_yn_tt" id="warn_reqd_yn_tt" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');drugEffectMand('T', this);" value="<%=warn_req_yn_tt%>" <%=warn_req_yn_tt_chk%>></td>
							</tr>
							<tr>
							  <td class="label"><fmt:message key="ePH.DrugEffectToPregnancy.label" bundle="${ph_labels}"/></td>
<%
								if(warn_req_yn_ft.equals("Y"))
									drugEffectMandDisplay = "visibility:visible;";
								else
									drugEffectMandDisplay = "visibility:hidden;";
%>
							  <td  class="field" >
							     <textarea name="DrugEffectToPregnancy" value="" size="200" maxlength="200"  rows='2' cols='25'  onchange = "parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onKeyPress="return checkMaxLimit(this,200);" onblur ="return CheckRemMaxLen(this);" disabled><%=preg_eff%></textarea><img src="../../eCommon/images/mandatory.gif" align="center" id="drugEffectMandF" style="<%=drugEffectMandDisplay%>">
							  </td>
							  <td class="label" nowrap><fmt:message key="ePH.DrugEffectToPregnancy.label" bundle="${ph_labels}"/></td>
<%
								if(warn_req_yn_st.equals("Y"))
									drugEffectMandDisplay = "visibility:visible;";
								else
									drugEffectMandDisplay = "visibility:hidden;";
%>
							  <td class="field">
							     <textarea name="DrugEffectToPregnancyforsecondtrim" value="" size="200" maxlength="200"  rows='2' cols='25'  onchange = "parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onKeyPress="return checkMaxLimit(this,200);" onblur ="return CheckRemMaxLen(this);" disabled><%=preg_eff_st%></textarea><img src="../../eCommon/images/mandatory.gif" align="center" id="drugEffectMandS" style="<%=drugEffectMandDisplay%>">
							  </td>
							  <td class="label" nowrap><fmt:message key="ePH.DrugEffectToPregnancy.label" bundle="${ph_labels}"/></td>
<%
								if(warn_req_yn_tt.equals("Y"))
									drugEffectMandDisplay = "visibility:visible;";
								else
									drugEffectMandDisplay = "visibility:hidden;";
%>
							  <td class="field">
							     <textarea name="DrugEffectToPregnancyforthirdtrim" value="" size="200" maxlength="200"  rows='2' cols='25'  style='width:150px' onchange = "parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onKeyPress="return checkMaxLimit(this,200);" onblur ="return CheckRemMaxLen(this);" disabled><%=preg_eff_tt%></textarea><img src="../../eCommon/images/mandatory.gif" align="center" id="drugEffectMandT" style="<%=drugEffectMandDisplay%>">
							  </td>
							</tr>
							<tr>
								<td class="label"><fmt:message key="ePH.MedAdminDetailRequired.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="medn_admin_dtl_reqd_yn" id="medn_admin_dtl_reqd_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=medn_admin_dtl_reqd_yn%>" <%=medn_admin_dtl_reqd_yn_chk%>></td>
								<td class="label"><fmt:message key="ePH.TDMApplicable.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="tdm_applicable_yn" id="tdm_applicable_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=tdm_applicable_yn%>" <%=tdm_applicable_yn_chk%>></td>
							</tr>
<!-- 							<tr>added for ghl-crf-0482 start  -->
								<%if(patient_stock_required){ %>
								<td class="label" nowrap ><fmt:message key="ePH.PatientStockRequired.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="patient_stock_required" id="patient_stock_required" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=patient_stock_required_yn%>" <%=patient_stock_required_chk%>></td>
								<%}else{ %>
								<td class="label" colspan='2'></td>
								<%} %>
								<!-- added for ghl-crf-0482end -->
								<td class="label" nowrap><fmt:message key="ePH.UsedforExtemporaneouspreparation.label" bundle="${ph_labels}"/></td>
								<td ><input type="checkbox" name="app_for_comprx_yn" id="app_for_comprx_yn"
								onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=app_for_comprx_yn%>" <%=app_for_comprx_yn_chk%>> </td>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.VerbalOrderApplicableduringMAR.label" bundle="${ph_labels}"/></td>
								<td class="field"><input type="checkbox" name="var_order_appl_during_MAR_yn" id="var_order_appl_during_MAR_yn" onclick="parent.assignValue(this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" value="<%=var_order_appl_during_MAR_yn%>" <%=var_order_appl_during_MAR_yn_chk%>></td>
								<td class="label" nowrap id='td_ImageFilename' >
<%
								if(!item_image_filename.equals("")){
%>
									<a href="javascript:parent.showImage('<%=item_image_filename%>');">
<%
								}
%>
								<fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/></a>
								</td>
								<td class="field"><input type="text" name="item_image_filename" id="item_image_filename" maxlength='200' size='35' value='<%=item_image_filename%>' onchange="parent.dispImageFile(drugMasterDetailForm,this);parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')"></td>
							</tr>
							<tr>
								<td class="label" colspan='2'><fmt:message key="ePH.EDLCLASSIFICATION.label" bundle="${ph_labels}"/></td>
								<td class="label"  colspan='2'><fmt:message key="ePH.EDLCLASSIFICATIONREMARKS.label" bundle="${ph_labels}"/></td>
							</tr>
							<tr>
								<td  colspan='2'  class="label"> <textarea name="EDLClassDescriptions" maxlength="500" rows='3' cols='50' onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" readonly><%=strEDLDescriptions%></textarea><input type = "button" class= button name='EDLSearch' id='EDLSearch' value='?' onclick="openEDLLookUpFrame()"></td>
								<td  colspan='2'  class="label"><textarea name="EDLClassRemarks" value="" rows='3' cols='50' onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onkeypress="return parent.chkRstrMaxLength(this)" onblur='parent.validmaxlength(this);'><%=strEDLRemarks%></textarea></td>
							</tr>
							<tr>
								<td class="label" colspan='2'><fmt:message key="ePH.DrugInformation.label" bundle="${ph_labels}"/></td>
								<td class="label"  colspan='2'><fmt:message key="ePH.PatientEducation.label" bundle="${ph_labels}"/></td>
							</tr>
							<tr>
								<td  colspan='2'  class="label"> <textarea name="druginfo_text" value="fg" size="4000" maxlength="4000" rows='3' cols='50' onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onblur='parent.validmaxlength(this);'><%=drug_information%></textarea></td>
								<td  colspan='2'  class="label"><textarea name="patientedu_text" value="" size="4000" maxlength="4000" rows='3' cols='50' onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm')" onblur='parent.validmaxlength(this);'><%=patient_education%></textarea></td>
							</tr>
							<tr height="3"style="display:none" ><td colspan="6" ></td></tr>
							<tr>
								<td class="label" nowrap style="display:none"><fmt:message key="ePH.DiagnosisRecording.label" bundle="${ph_labels}"/></td>
								<td style="display:none">&nbsp;
									<select name="diag_recording" id="diag_recording"  onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm'); parent.updatesceeningnote(this);" >
										<option value="X">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
										<option value="R" <%=diag_record_1%>><fmt:message key="Common.required.label" bundle="${common_labels}"/></option>
										<option value="S"<%=diag_record_2%>><fmt:message key="ePH.RequiredWithScreening.label" bundle="${ph_labels}"/></option>
									</select>
								</td>
								<td class="label" style="display:none"><fmt:message key="ePH.DiagnosisScreeningNote.label" bundle="${ph_labels}"/></td>
								<td  class="field"style="display:none">&nbsp;
									<select name="screen_note" id="screen_note" onchange="parent.updateFormModify('drugMasterMain.document.drugMasterMainForm');" disabled  >
										<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%										String sel="";
										ArrayList screen_notes=bean.loadScreenNotes();
										for(int i=0;i<screen_notes.size();i+=2){
							
											String screen_code=(String)screen_notes.get(i);
											String screen_desc=(String)screen_notes.get(i+1);
											if(screen_note.equals(screen_code))
												sel="selected";
											else
												sel="";
%>
											<option value="<%=screen_code%>"<%=sel%>><%=screen_desc%></option>
<%
										}
%>
									</select>
								</td>
							</tr>
						</table>

						<!-- <input type="hidden" name="drug_type" id="drug_type" value="<%=drug_type%>" > -->
						<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
						<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
						<input type="hidden" name="mode" id="mode" value="<%=mode%>">
						<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
						<input type="hidden" name="EDLClassCodes" id="EDLClassCodes" value="<%=strEDLCodes%>">
						<input type="hidden" name="sql_fda_pregnancy_category_search_LookUp" id="sql_fda_pregnancy_category_search_LookUp"	value="<%=sql_fda_pregnancy_category_search_LookUp%>">
						<input type="hidden" name="fdaCategorySearchCode" id="fdaCategorySearchCode"	value="<%=fdaCategorySearchCode%>">
						<input type="hidden" name="fdaCategorySearchText" id="fdaCategorySearchText"	value="<%=fdaCategorySearchText%>">

					<script>parent.updateCurrentForm("characteristics_tab","f_tab_detail.document.drugMasterDetailForm","drugMasterMain.document.drugMasterMainForm");</script>
					<input type =hidden name="fdaCategoryGroupCode" id="fdaCategoryGroupCode" value =""/>
			</form>
			<script>
				updateLink("characteristics_tab");
				parent.setFocus(document.drugMasterDetailForm)
<%
				if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) )	{
%>
					parent.updateSchedulinMain(document.drugMasterDetailForm.schedule);
<%
				}
%>
			</script>
		</body>
		<style>
textarea {
  resize: none;
}
</style>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>


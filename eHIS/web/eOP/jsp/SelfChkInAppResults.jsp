<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*,webbeans.op.CurrencyFormat,blopin.*,eOR.*,eBL.*,eOR.Common.*,eCommon.Common.*,eCommon.Common.*,eOP.*,org.json.simple.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
String bean_id = "refusalOrdersBean" ;
String bean_name = "eOR.RefusalOrdersBean";
boolean iSPractVisitLoad=false;//added by munisekhar for MMS-QH-CRF-0167 [IN:044923] 
RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;

Orderables.clearObject();
Properties p=(java.util.Properties) session.getValue("jdbc"); //Added for this CRF GDOH-CRF-0129
//Start - Added for GDOH-CRF-149
	session.removeAttribute("str_clinic_code");
	session.removeAttribute("classTypChangeAuthYnPatId");
//End - Added for GDOH-CRF-149
		

%>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOP/js/SelfChkInAppt.js"></script>
    <Script src="../../eOP/js/VisitRegistration1.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con=null;



	try {
		con						=  ConnectionManager.getConnection(request);
			
		String patient_id		= checkForNull(request.getParameter("patientId"));
		String facility_id		=	(String)session.getAttribute("facility_id");
		String locale			= (String) session.getValue( "LOCALE" ) ;
		String userid           = (String) session.getValue("login_user");

		int visit_backdate_days_val=0;
		String visit_back_yn = "";
		

		if(userid == null || userid.equals("null"))
			userid = "";

		String oper_stn_id		= CommonBean.getOperStationId(con,facility_id, userid,"REGISTER_VISIT_YN");
		String or_install_yn	= CommonBean.getModuleInstalledYN(con,facility_id, "OR");
		
		JSONObject opParamDtls = new JSONObject();
		JSONObject followupVisitDtls = new JSONObject();
		opParamDtls				 = eOP.OPCommonBean.getOPParamDtls(con,facility_id);
		String action_on_pract_schedule	= checkForNull((String) opParamDtls.get("action_on_pract_schedule"));
		String assign_q_num_by		= checkForNull((String) opParamDtls.get("assign_q_num_by"));
		String vst_regn_date		= checkForNull((String) opParamDtls.get("vst_regn_date"));
		String vst_regn_date_new		= checkForNull((String) opParamDtls.get("vst_regn_date_new"));
		String override_pract_for_appt_yn		= checkForNull((String) opParamDtls.get("override_pract_for_appt_yn"));
		String override_vtype_on_epsd_yn		= checkForNull((String) opParamDtls.get("override_vtype_on_epsd_yn"));
		String visit_backdate_days		= checkForNull((String) opParamDtls.get("visit_backdate_days"));
		String allowed_date		= checkForNull((String) opParamDtls.get("allowed_date"));
		String vis_det_temp_yn		= checkForNull((String) opParamDtls.get("vis_det_temp_yn"));
		String visit_type_derv_rule		= checkForNull((String) opParamDtls.get("visit_type_derv_rule"));
		
		vst_regn_date	= DateUtils.convertDate(vst_regn_date,"DMYHMS","en",locale);
		if(!( visit_backdate_days ==null || visit_backdate_days.equals("") ))
			visit_backdate_days_val =Integer.parseInt(visit_backdate_days);

		if (visit_backdate_days_val > 0) {
			visit_back_yn = "Y";
		}



		
		JSONArray patApptListArray 			= (JSONArray) eOP.OPCommonBean.getPatientApptDtls(con,locale,facility_id,oper_stn_id,patient_id);
		int patApptListCount					= patApptListArray.size();

		if(patApptListCount > 0){
	 %>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="self_chk_in_appt_frames" id="self_chk_in_appt_frames" method='post' action='../../servlet/eOP.VisitRegistrationServlet' target="messageFrame" >
					<table cellspacing='0' cellpadding='3' align='center' width='100%' border='1' >

						<tr>
							<td width='1%' class="COLUMNHEADERCENTER" align='center'>&nbsp;</td>
							<td width='10%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.apptno.label" bundle="${common_labels}"/>&nbsp;
							</td>
							<td width='15%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.time.label" bundle="${common_labels}"/>&nbsp;
							</td>
							<td width='15%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> - (en)&nbsp;
							</td>
							<td width='15%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;
							</td>
							<td width='15%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.Location.label" bundle="${common_labels}"/>  - (en)&nbsp;
							</td>
							<td width='15%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.Location.label" bundle="${common_labels}"/>  - (ar)&nbsp;
							</td>
							<td width='15%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> - (ar)&nbsp;
							</td>
							<td width='5%' class="COLUMNHEADERCENTER" align='center' nowrap>
								<fmt:message key="Common.Register.label" bundle="${common_labels}"/>&nbsp;
							</td>
						</tr>

						<%

							for(int i = 0 ; i < patApptListCount ; i++) {
								JSONObject patApptList	= (JSONObject)patApptListArray.get(i);
								String appt_ref_no			= (String) patApptList.get("appt_ref_no");
								String patient_name				= (String) patApptList.get("patient_name");
								String patient_name_ar			= (String) patApptList.get("patient_name_ar");
								String clinic_desc				= (String) patApptList.get("clinic_desc");
								String clinic_desc_ar			= (String) patApptList.get("clinic_desc_ar");
								String clinic_code				= (String) patApptList.get("clinic_code");
								String pract_id					= (String) patApptList.get("pract_id");
								String resource_class			= (String) patApptList.get("resource_class");
								String clinic_type				= (String) patApptList.get("clinic_type");
								String appt_date				= (String) patApptList.get("appt_date");
								String from_time				= (String) patApptList.get("from_time");
								String to_time					= (String) patApptList.get("to_time");
								String appt_time				= (String) patApptList.get("appt_time");
								String service_code				= (String) patApptList.get("service_code");
								String visit_adm_type			= (String) patApptList.get("appt_type_code");
								String order_id					= (String) patApptList.get("order_id");
								String order_line_num			= (String) patApptList.get("order_line_num");
								String order_type_code			= (String) patApptList.get("order_type_code");
								String order_catlog_code		= (String) patApptList.get("order_catlog_code");
								String order_catalog_desc		= (String) patApptList.get("order_catalog_desc");
								String ordering_facility_id		= (String) patApptList.get("ordering_facility_id");
								String visit_type_ind		= (String) patApptList.get("visit_type_ind");

								String no_of_fu_visits_allowed	= "0";
								String dur_for_fu_vsts_in_days	= "0";
								String op_episode_id	= "";
								//String last_visit_num	= "";
								String episode_close_days_wo_fu	= "";
								//String visit_date	= "";
								String old_episode_no	= "";
								String episode_close_days_fu	= "";
							//	String episode_id	= "";
								//String last_visit_fu_reqd_yn	= "";
								String last_visit_date	= "";
								String new_op_episode_yn	= "Y";
								String op_episode_visit_num	= "0";

								
								if(!service_code.equals("") ){

									followupVisitDtls				 = eOP.OPCommonBean.getFollowupVisitDtls(con,facility_id,patient_id,service_code,override_vtype_on_epsd_yn,visit_type_ind,clinic_code);
									System.err.println(followupVisitDtls.toString());	
									
									no_of_fu_visits_allowed	= checkForNull((String) followupVisitDtls.get("no_of_fu_visits_allowed"));
									dur_for_fu_vsts_in_days	= checkForNull((String) followupVisitDtls.get("dur_for_fu_vsts_in_days"));
									op_episode_id	= checkForNull((String) followupVisitDtls.get("op_episode_id"));
									//last_visit_num	= checkForNull((String) followupVisitDtls.get("last_visit_num"));
									episode_close_days_wo_fu	= checkForNull((String) followupVisitDtls.get("episode_close_days_wo_fu"));
									old_episode_no	= checkForNull((String) followupVisitDtls.get("old_episode_no"));
									episode_close_days_fu	= checkForNull((String) followupVisitDtls.get("episode_close_days_fu"));
									last_visit_date	= checkForNull((String) followupVisitDtls.get("last_visit_date"));
									new_op_episode_yn	= checkForNull((String) followupVisitDtls.get("new_op_episode_yn"));
									op_episode_visit_num	= checkForNull((String) followupVisitDtls.get("op_episode_visit_num"));
								}

								


						
												
								
								String classValue				= "QRYODD";
								String clinic_type_desc			= ""; 
								if(clinic_type.equals("C"))  { 
									clinic_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
								} else if(clinic_type.equals("E")) {                                                																	clinic_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
								}
								
								int row	= i;
								if(row%2==0){
									classValue					= "QRYEVEN";
								}else{
									classValue					= "QRYODD";
								}
															
							%>
							<tr>
								<td class= '<%=classValue%>' align='left' width='1%' nowrap><a href="javascript:view_appt_dtl('<%=appt_ref_no%>','<%=appt_date%>','<%=clinic_code%>','<%=pract_id%>','<%=from_time%>','<%=to_time%>', '<%=resource_class%>','<%=clinic_type%>')">+</a>
								</td>
								<td width='10%' class= '<%=classValue%>' align='center' nowrap><%=appt_ref_no%></td>
								<td width='15%' class='<%=classValue%>' align='center' nowrap><%=appt_time%></td>
								<td width='15%' class='<%=classValue%>' align='center' ><%=patient_name%></td>
								<td width='15%' class='<%=classValue%>' align='center' nowrap><%=patient_id%></td>
								<td width='15%' class='<%=classValue%>' align='center' ><%=clinic_desc%></td>
								<td width='15%' class='<%=classValue%>' align='center' ><%=clinic_desc_ar%></td>
								<td width='15%' class='<%=classValue%>' align='center' ><%=patient_name_ar%></td>
								<td width='5%' class='<%=classValue%>' align='center' > 

								
								<input type="button" name="submitBtn" id="submitBtn"  value='<fmt:message key="Common.Register.label" bundle="${common_labels}"/>' <%if(service_code.equals("")){%> disabled<%}%> onclick="submitForm('<%=appt_ref_no%>','<%=appt_date%>','<%=clinic_code%>','<%=pract_id%>','<%=from_time%>','<%=to_time%>', '<%=resource_class%>','<%=clinic_type%>','<%=service_code%>','<%=clinic_desc%>','<%=appt_time%>','<%=visit_adm_type%>','<%=order_id%>','<%=order_line_num%>','<%=order_type_code%>','<%=order_catlog_code%>','<%=order_catalog_desc%>','<%=ordering_facility_id%>','<%=no_of_fu_visits_allowed%>','<%=dur_for_fu_vsts_in_days%>','<%=op_episode_id%>','<%=episode_close_days_wo_fu%>','<%=old_episode_no%>','<%=episode_close_days_fu%>','<%=last_visit_date%>','<%=new_op_episode_yn%>','<%=op_episode_visit_num%>')" /></td>

							</tr>
						<%}%>
							
					</table>
<% if (visit_back_yn.equalsIgnoreCase("Y")) { %>
	<input type='hidden' name='AllowedDate' id='AllowedDate' value="<%=allowed_date%>"></input>
	<input type='hidden' name='sysDateSer' id='sysDateSer' value="<%=vst_regn_date%>"></input>
<%}%>
						
			
<input type='hidden' name='vst_regn_date_time' id='vst_regn_date_time' value='<%=vst_regn_date%>' /> 
<input type='hidden' name='vst_regn_date_time_new' id='vst_regn_date_time_new' value='<%=vst_regn_date_new%>' /> 
<input type='hidden' name='vis_det_temp_code' id='vis_det_temp_code' value='' /> 
<input type='hidden' name='assign_care_locn_desc' id='assign_care_locn_desc' value='' /> 
<input type='hidden' name='assign_care_locn_code' id='assign_care_locn_code' value='' /> 
<input type='hidden' name='room_no' id='room_no' value='' /> 
<input type='hidden' name='service_code' id='service_code' value='' /> 
<input type='hidden' name='subservice_code' id='subservice_code' value='' /> 
<input type='hidden' name='isMohbr' id='isMohbr' value='false' /> 
<input type='hidden' name='visit_adm_type' id='visit_adm_type' value='' /> 
<input type='hidden' name='pract_name' id='pract_name' value='' /> 
<input type='hidden' name='attend_practitioner_id' id='attend_practitioner_id' value='' /> 
<input type='hidden' name='appt_practitioner_id' id='appt_practitioner_id' value='' /> 
<input type='hidden' name='prev_pract_name' id='prev_pract_name' value='' /> 
<input type='hidden' name='other_res_type' id='other_res_type' value='' /> 
<input type='hidden' name='other_res_txt' id='other_res_txt' value='' /> 
<input type='hidden' name='other_res_code' id='other_res_code' value='' /> 
<input type='hidden' name='order_cat_txt' id='order_cat_txt' value='' /> 
<input type='hidden' name='order_cat_txt_hidd' id='order_cat_txt_hidd' value='' /> 
<input type='hidden' name='order_cat_code' id='order_cat_code' value='' /> 
<input type='hidden' name='order_category_code' id='order_category_code' value='' /> 
<input type='hidden' name='order_type_code' id='order_type_code' value='' /> 
<input type='hidden' name='ordering_facility_id' id='ordering_facility_id' value='' /> 
<input type='hidden' name='order_id' id='order_id' value='' /> 
<input type='hidden' name='order_line_num' id='order_line_num' value='' /> 
<input type='hidden' name='contact_reason_txt' id='contact_reason_txt' value='' /> 
<input type='hidden' name='contact_reason_txt_hidd' id='contact_reason_txt_hidd' value='' /> 
<input type='hidden' name='contact_reason_code' id='contact_reason_code' value='' /> 
<input type='hidden' name='emergency_details' id='emergency_details' value='' /> 
<input type='hidden' name='billing_group' id='billing_group' value='' /> 
<input type='hidden' name='billing_class' id='billing_class' value='' /> 
<input type='hidden' name='employer_code' id='employer_code' value='' /> 
<input type='hidden' name='cash_set_type1' id='cash_set_type1' value='' /> 
<input type='hidden' name='cash_insmt_ref1' id='cash_insmt_ref1' value='' /> 
<input type='hidden' name='cash_insmt_date1' id='cash_insmt_date1' value='' /> 
<input type='hidden' name='cash_insmt_rmks1' id='cash_insmt_rmks1' value='' /> 
<input type='hidden' name='cust_1' id='cust_1' value='' /> 
<input type='hidden' name='credit_doc_ref1' id='credit_doc_ref1' value='' /> 
<input type='hidden' name='credit_doc_date1' id='credit_doc_date1' value='' /> 
<input type='hidden' name='cust_2' id='cust_2' value='' /> 
<input type='hidden' name='credit_doc_ref2' id='credit_doc_ref2' value='' /> 
<input type='hidden' name='credit_doc_date2' id='credit_doc_date2' value='' /> 
<input type='hidden' name='cust_3' id='cust_3' value='' /> 
<input type='hidden' name='policy_type' id='policy_type' value='' /> 
<input type='hidden' name='policy_no' id='policy_no' value='' /> 
<input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value='' /> 
<input type='hidden' name='non_insur_blng_grp' id='non_insur_blng_grp' value='' /> 
<input type='hidden' name='cash_set_type2' id='cash_set_type2' value='' /> 
<input type='hidden' name='cash_insmt_ref2' id='cash_insmt_ref2' value='' /> 
<input type='hidden' name='cash_insmt_date2' id='cash_insmt_date2' value='' /> 
<input type='hidden' name='cash_insmt_rmks2' id='cash_insmt_rmks2' value='' /> 
<input type='hidden' name='cust_4' id='cust_4' value='' /> 
<input type='hidden' name='credit_doc_ref3' id='credit_doc_ref3' value='' /> 
<input type='hidden' name='credit_doc_date3' id='credit_doc_date3' value='' /> 
<input type='hidden' name='setlmt_ind' id='setlmt_ind' value='' /> 
<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value='' /> 
<input type='hidden' name='billing_mode' id='billing_mode' value='' /> 
<input type='hidden' name='credit_auth_date' id='credit_auth_date' value='' /> 
<input type='hidden' name='app_days' id='app_days' value='' /> 
<input type='hidden' name='app_amount' id='app_amount' value='' /> 
<input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value='' /> 
<input type='hidden' name='annual_income' id='annual_income' value='' /> 
<input type='hidden' name='family_asset' id='family_asset' value='' /> 
<input type='hidden' name='no_of_dependants' id='no_of_dependants' value='' /> 
<input type='hidden' name='resp_for_payment' id='resp_for_payment' value='' /> 
<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value='' /> 
<input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value='' /> 
<input type='hidden' name='eff_frm_date' id='eff_frm_date' value='' /> 
<input type='hidden' name='gl_holder_name' id='gl_holder_name' value='' /> 
<input type='hidden' name='gl_holder_reln' id='gl_holder_reln' value='' /> 
<input type='hidden' name='new_op_episode_yn' id='new_op_episode_yn' value='' /> 
<input type='hidden' name='user_id' id='user_id' value='' /> 
<input type='hidden' name='remarks' id='remarks' value='' /> 
<input type='hidden' name='upd_user_flag' id='upd_user_flag' value='' /> 
<input type='hidden' name='reccnt' id='reccnt' value='' /> 
<input type='hidden' name='pkg_bill_doc_type' id='pkg_bill_doc_type' value='' /> 
<input type='hidden' name='pkg_bill_doc_num' id='pkg_bill_doc_num' value='' /> 
<input type='hidden' name='policy_type_code' id='policy_type_code' value='' /> 
<input type='hidden' name='effective_date' id='effective_date' value='' /> 
<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value='' /> 
<input type='hidden' name='approved_days' id='approved_days' value='' /> 
<input type='hidden' name='base_qty' id='base_qty' value='' /> 
<input type='hidden' name='base_rate' id='base_rate' value='' /> 
<input type='hidden' name='base_charge_amt' id='base_charge_amt' value='' /> 
<input type='hidden' name='gross_charge_amt' id='gross_charge_amt' value='' /> 
<input type='hidden' name='disc_amt' id='disc_amt' value='' /> 
<input type='hidden' name='net_charge_amt' id='net_charge_amt' value='' /> 
<input type='hidden' name='pat_base_qty' id='pat_base_qty' value='' /> 
<input type='hidden' name='pat_base_rate' id='pat_base_rate' value='' /> 
<input type='hidden' name='pat_serv_qty' id='pat_serv_qty' value='' /> 
<input type='hidden' name='pat_base_charge_amt' id='pat_base_charge_amt' value='' /> 
<input type='hidden' name='pat_gross_charge_amt' id='pat_gross_charge_amt' value='' /> 
<input type='hidden' name='pat_disc_amt' id='pat_disc_amt' value='' /> 
<input type='hidden' name='pat_net_charge_amt' id='pat_net_charge_amt' value='' /> 
<input type='hidden' name='cust_base_qty' id='cust_base_qty' value='' /> 
<input type='hidden' name='cust_base_rate' id='cust_base_rate' value='' /> 
<input type='hidden' name='cust_serv_qty' id='cust_serv_qty' value='' /> 
<input type='hidden' name='cust_base_charge_amt' id='cust_base_charge_amt' value='' /> 
<input type='hidden' name='cust_gross_charge_amt' id='cust_gross_charge_amt' value='' /> 
<input type='hidden' name='cust_disc_amt' id='cust_disc_amt' value='' /> 
<input type='hidden' name='cust_net_charge_amt' id='cust_net_charge_amt' value='' /> 
<input type='hidden' name='split_yn' id='split_yn' value='' /> 
<input type='hidden' name='pkg_ins_pat_ind' id='pkg_ins_pat_ind' value='' /> 
<input type='hidden' name='req_pkg_qty' id='req_pkg_qty' value='' /> 
<input type='hidden' name='req_addl_qty' id='req_addl_qty' value='' /> 
<input type='hidden' name='req_std_qty' id='req_std_qty' value='' /> 
<input type='hidden' name='curr_availed' id='curr_availed' value='' /> 
<input type='hidden' name='canadj_alert_ind' id='canadj_alert_ind' value='' /> 
<input type='hidden' name='pkg_serv_code' id='pkg_serv_code' value='' /> 
<input type='hidden' name='visit_charge_stage' id='visit_charge_stage' value='' /> 
<input type='hidden' name='day_type_code' id='day_type_code' value='' /> 
<input type='hidden' name='time_type_code' id='time_type_code' value='' /> 
<input type='hidden' name='disc_perc' id='disc_perc' value='' /> 
<input type='hidden' name='addl_fctr' id='addl_fctr' value='' /> 
<input type='hidden' name='order_catalog_code' id='order_catalog_code' value='' /> 
<input type='hidden' name='order_catalog_desc' id='order_catalog_desc' value='' /> 
<input type='hidden' name='orderId' id='orderId' value='' /> 
<input type='hidden' name='call_from' id='call_from' value='' /> 
<input type='hidden' name='populate_visit_type' id='populate_visit_type' value='' /> 
<input type='hidden' name='sys_date' id='sys_date' value='' /> 
<input type='hidden' name='pkg_sel' id='pkg_sel' value='' /> 
<input type='hidden' name='pkg_bill_type' id='pkg_bill_type' value='' /> 
<input type='hidden' name='pkg_bill_no' id='pkg_bill_no' value='' /> 
<input type='hidden' name='resource_class' id='resource_class' value='' /> 
<input type='hidden' name='res_pract_id' id='res_pract_id' value='' /> 
<input type='hidden' name='cred_start_dt1' id='cred_start_dt1' value='' /> 
<input type='hidden' name='cred_start_dt2' id='cred_start_dt2' value='' /> 
<input type='hidden' name='cred_start_dt3' id='cred_start_dt3' value='' /> 
<input type='hidden' name='entitlement_by_cat_yn' id='entitlement_by_cat_yn' value='' /> 
<input type='hidden' name='isOrderCtlgAmtCalc' id='isOrderCtlgAmtCalc' value='' /> 
<input type='hidden' name='isPractoApptYn' id='isPractoApptYn' value='N' /> 
<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value='' /> 
<input type='hidden' name='exceded_max_walkin' id='exceded_max_walkin' value='' /> 
<input type='hidden' name='no_of_multi_orders' id='no_of_multi_orders' value='' /> 
<input type='hidden' name='override_walkin_yn' id='override_walkin_yn' value='' /> 
<input type='hidden' name='queueNo' id='queueNo' value='' /> 
<input type='hidden' name='waitTime' id='waitTime' value='' /> 
<input type='hidden' name='inv_splty_code' id='inv_splty_code' value='' /> 
<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>' /> 
<input type='hidden' name='override_pract_for_appt' id='override_pract_for_appt' value='<%=override_pract_for_appt_yn%> /> 
<input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value='<%=assign_q_num_by%>' /> 
<input type='hidden' name='bl_patient_id' id='bl_patient_id' value='' /> 
<input type='hidden' name='oa_install_yn' id='oa_install_yn' value='' /> 
<input type='hidden' name='patFlag' id='patFlag' value='' /> 
<input type='hidden' name='sStyle' id='sStyle' value='<%=sStyle%>' /> 
<input type='hidden' name='pat_details' id='pat_details' value='' /> 
<input type='hidden' name='date_of_birth' id='date_of_birth' value='' /> 
<input type='hidden' name='sec_level' id='sec_level' value='' /> 
<input type='hidden' name='protection_ind' id='protection_ind' value='' /> 
<input type='hidden' name='outst_amt' id='outst_amt' value='' /> 
<input type='hidden' name='pract_type' id='pract_type' value='' /> 
<input type='hidden' name='last_visit_date' id='last_visit_date' value='' /> 
<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='' /> 
<input type='hidden' name='no_practitioner_for_appt' id='no_practitioner_for_appt' value='' /> 
<input type='hidden' name='ident_at_checkin' id='ident_at_checkin' value='' /> 
<input type='hidden' name='h_visit_type_ind' id='h_visit_type_ind' value='' /> 
<input type='hidden' name='gen_file_yn' id='gen_file_yn' value='' /> 
<input type='hidden' name='build_episode_rule' id='build_episode_rule' value='S' /> 
<input type='hidden' name='or_install_yn' id='or_install_yn' value='' /> 
<input type='hidden' name='bl_install_yn' id='bl_install_yn' value='N' /> 
<input type='hidden' name='function' id='function' value='' /> 
<input type='hidden' name='function_name' id='function_name' value='' /> 
<input type='hidden' name='Chg_to_Visitor_Grp' id='Chg_to_Visitor_Grp' value='' /> 
<input type='hidden' name='health_card_expired_yn1' id='health_card_expired_yn1' value='' /> 
<input type='hidden' name='bl_success' id='bl_success' value='' /> 
<input type='hidden' name='override_vtype_on_epsd_yn' id='override_vtype_on_epsd_yn' value='<%=override_vtype_on_epsd_yn%>' /> 
<input type='hidden' name='episode_close_days_fu' id='episode_close_days_fu' value='' /> 
<input type='hidden' name='episode_close_days_wo_fu' id='episode_close_days_wo_fu' value='' /> 
<input type='hidden' name='dur_for_fu_vsts_in_days' id='dur_for_fu_vsts_in_days' value='' /> 
<input type='hidden' name='no_of_fu_visits_allowed' id='no_of_fu_visits_allowed' value='' /> 
<input type='hidden' name='ct_patient_id' id='ct_patient_id' value='' /> 
<input type='hidden' name='error' id='error' value='' /> 
<input type='hidden' name='old_op_episode_id' id='old_op_episode_id' value='' /> 
<input type='hidden' name='old_op_episode_visit_num' id='old_op_episode_visit_num' value='' /> 
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>' /> 
<input type='hidden' name='l_encounter_id' id='l_encounter_id' value='' /> 
<input type='hidden' name='new_episode_yn' id='new_episode_yn' value='' /> 
<input type='hidden' name='referral_code' id='referral_code' value='' /> 
<input type='hidden' name='reg_vis_param' id='reg_vis_param' value='' /> 
<input type='hidden' name='facilityId' id='facilityId' value='<%=facility_id%>' /> 
<input type='hidden' name='visit_adm_type_ind' id='visit_adm_type_ind' value='' /> 
<input type='hidden' name='old_episode_no' id='old_episode_no' value='' /> 
<input type='hidden' name='op_episode_id' id='op_episode_id' value='' /> 
<input type='hidden' name='cur_episode_id' id='cur_episode_id' value='' /> 
<input type='hidden' name='op_episode_visit_num' id='op_episode_visit_num' value='' /> 
<input type='hidden' name='register_pat_yn' id='register_pat_yn' value='' /> 
<input type='hidden' name='wait_list_flag' id='wait_list_flag' value='' /> 
<input type='hidden' name='DispAlert' id='DispAlert' value='' /> 
<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='' /> 
<input type='hidden' name='financial_detail_ref_id' id='financial_detail_ref_id' value='' /> 
<input type='hidden' name='org_type' id='org_type' value='' /> 
<input type='hidden' name='room_type' id='room_type' value='' /> 
<input type='hidden' name='rm_no' id='rm_no' value='' /> 
<input type='hidden' name='q_visit_adm_type_ind' id='q_visit_adm_type_ind' value='R' /> 
<input type='hidden' name='q_visit_adm_type' id='q_visit_adm_type' value='' /> 
<input type='hidden' name='change_address' id='change_address' value='' /> 
<input type='hidden' name='concat_address_hidden' id='concat_address_hidden' value='' /> 
<input type='hidden' name='concat_NatIdDetails_hidden' id='concat_NatIdDetails_hidden' value='' /> 
<input type='hidden' name='addr1_type' id='addr1_type' value='' /> 
<input type='hidden' name='addr_line1' id='addr_line1' value='' /> 
<input type='hidden' name='addr_line2' id='addr_line2' value='' /> 
<input type='hidden' name='addr_line3' id='addr_line3' value='' /> 
<input type='hidden' name='addr_line4' id='addr_line4' value='' /> 
<input type='hidden' name='res_town_code' id='res_town_code' value='' /> 
<input type='hidden' name='res_town_desc' id='res_town_desc' value='' /> 
<input type='hidden' name='res_area_code' id='res_area_code' value='' /> 
<input type='hidden' name='res_area_desc' id='res_area_desc' value='' /> 
<input type='hidden' name='postal_code' id='postal_code' value='' /> 
<input type='hidden' name='region_code' id='region_code' value='' /> 
<input type='hidden' name='region_desc' id='region_desc' value='' /> 
<input type='hidden' name='country_code' id='country_code' value='' /> 
<input type='hidden' name='contact1_name' id='contact1_name' value='' /> 
<input type='hidden' name='invalid1_yn' id='invalid1_yn' value='' /> 
<input type='hidden' name='addr2_type' id='addr2_type' value='' /> 
<input type='hidden' name='mail_addr_line1' id='mail_addr_line1' value='' /> 
<input type='hidden' name='mail_addr_line2' id='mail_addr_line2' value='' /> 
<input type='hidden' name='mail_addr_line3' id='mail_addr_line3' value='' /> 
<input type='hidden' name='mail_addr_line4' id='mail_addr_line4' value='' /> 
<input type='hidden' name='mail_res_town_code' id='mail_res_town_code' value='' /> 
<input type='hidden' name='mail_res_town_desc' id='mail_res_town_desc' value='' /> 
<input type='hidden' name='mail_res_area_code' id='mail_res_area_code' value='' /> 
<input type='hidden' name='mail_res_area_desc' id='mail_res_area_desc' value='' /> 
<input type='hidden' name='mail_postal_code' id='mail_postal_code' value='' /> 
<input type='hidden' name='mail_region_code' id='mail_region_code' value='' /> 
<input type='hidden' name='mail_region_desc' id='mail_region_desc' value='' /> 
<input type='hidden' name='mail_country_code' id='mail_country_code' value='' /> 
<input type='hidden' name='r_postal_code1' id='r_postal_code1' value='' /> 
<input type='hidden' name='m_postal_code1' id='m_postal_code1' value='' /> 
<input type='hidden' name='addr3_type' id='addr3_type' value='' /> 
<input type='hidden' name='alt_addr_line1' id='alt_addr_line1' value='' /> 
<input type='hidden' name='alt_addr_line2' id='alt_addr_line2' value='' /> 
<input type='hidden' name='alt_addr_line3' id='alt_addr_line3' value='' /> 
<input type='hidden' name='alt_addr_line4' id='alt_addr_line4' value='' /> 
<input type='hidden' name='alt_town_code' id='alt_town_code' value='' /> 
<input type='hidden' name='alt_town_desc' id='alt_town_desc' value='' /> 
<input type='hidden' name='alt_area_code' id='alt_area_code' value='' /> 
<input type='hidden' name='alt_area_desc' id='alt_area_desc' value='' /> 
<input type='hidden' name='alt_postal_code' id='alt_postal_code' value='' /> 
<input type='hidden' name='alt_postal_code1' id='alt_postal_code1' value='' /> 
<input type='hidden' name='alt_region_code' id='alt_region_code' value='' /> 
<input type='hidden' name='alt_region_desc' id='alt_region_desc' value='' /> 
<input type='hidden' name='alt_country_code' id='alt_country_code' value='' /> 
<input type='hidden' name='alt_country_desc' id='alt_country_desc' value='' /> 
<input type='hidden' name='query_string' id='query_string' value='' /> 
<input type='hidden' name='contact2_name' id='contact2_name' value='' /> 
<input type='hidden' name='invalid2_yn' id='invalid2_yn' value='' /> 
<input type='hidden' name='country_desc' id='country_desc' value='' /> 
<input type='hidden' name='mail_country_desc' id='mail_country_desc' value='' /> 
<input type='hidden' name='bed_num' id='bed_num' value='' /> 
<input type='hidden' name='discharge_date_time' id='discharge_date_time' value='' /> 
<input type='hidden' name='functionId' id='functionId' value='' /> 
<input type='hidden' name='menu_function_id' id='menu_function_id' value='' /> 
<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value='' /> 
<input type='hidden' name='appt_ref_no_2' id='appt_ref_no_2' value='' /> 
<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='' /> 
<input type='hidden' name='clptype' id='clptype' value='' /> 
<input type='hidden' name='order_req' id='order_req' value='' /> 
<input type='hidden' name='help_function_id' id='help_function_id' value='' /> 
<input type='hidden' name='contact1_no' id='contact1_no' value='' /> 
<input type='hidden' name='contact2_no' id='contact2_no' value='' /> 
<input type='hidden' name='email' id='email' value='' /> 
<input type='hidden' name='locationSpeciality' id='locationSpeciality' value='' /> 
<input type='hidden' name='from_reg' id='from_reg' value='' /> 
<input type='hidden' name='new_file_no' id='new_file_no' value='' /> 
<input type='hidden' name='dummy_visit_type' id='dummy_visit_type' value='' /> 
<input type='hidden' name='dummy_locn_code' id='dummy_locn_code' value='' /> 
<input type='hidden' name='dummy_visit_dttime' id='dummy_visit_dttime' value='' /> 
<input type='hidden' name='episodeReqd' id='episodeReqd' value='X' /> 
<input type='hidden' name='bl_enter_yn' id='bl_enter_yn' value='' /> 
<input type='hidden' name='facilityid' id='facilityid' value='' /> 
<input type='hidden' name='invitation_no' id='invitation_no' value='' /> 
<input type='hidden' name='room_no1' id='room_no1' value='' /> 
<input type='hidden' name='frame_ref' id='frame_ref' value='' /> 
<input type='hidden' name='locale' id='locale' value='' /> 
<input type='hidden' name='iSPractVisitLoad' id='iSPractVisitLoad' value='' /> 
<input type='hidden' name='isAllowRegForSameService' id='isAllowRegForSameService' value='false' /> 
<input type='hidden' name='q_appt_time' id='q_appt_time' value='' /> 
<input type='hidden' name='rec_no' id='rec_no' value='' /> 
<input type='hidden' name='visit_for_inpat_yn' id='visit_for_inpat_yn' value='' /> 
<input type='hidden' name='auth_win_reqd_yn' id='auth_win_reqd_yn' value='' /> 
<input type='hidden' name='episode' id='episode' value='' /> 
<input type='hidden' name='record' id='record' value='' /> 
<input type='hidden' name='from_head' id='from_head' value='' /> 
<input type='hidden' name='locn_ind' id='locn_ind' value='' /> 
<input type='hidden' name='waitlist_status' id='waitlist_status' value='' /> 
<input type='hidden' name='p_hosp_main' id='p_hosp_main' value='' /> 
<input type='hidden' name='p_hosp_sub' id='p_hosp_sub' value='' /> 
<input type='hidden' name='p_card_id' id='p_card_id' value='' /> 
<input type='hidden' name='p_expiry_date' id='p_expiry_date' value='' /> 
<input type='hidden' name='p_privl_type_code' id='p_privl_type_code' value='' /> 
<input type='hidden' name='p_all_services' id='p_all_services' value='' /> 
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type='hidden' name='multiple_orders_yn' id='multiple_orders_yn' value='N'>
<input type='hidden' name='accept_dis_inv_no' id='accept_dis_inv_no' value='' /> 
<input type='hidden' name='visit_type_derv_rule' id='visit_type_derv_rule' value='<%=visit_type_derv_rule%>' /> 
<input type='hidden' name='visit_back_yn' id='visit_back_yn' value='' /> 
<input type='hidden' name='vst_type_ind' id='vst_type_ind' value='' /> 
<input type='hidden' name='multi_speciality_yn' id='multi_speciality_yn' value='' /> 
<input type='hidden' name='appt_order' id='appt_order' value='' /> 
<input type='hidden' name='order_count_select' id='order_count_select' value='' /> 
<input type='hidden' name='blng_grp_id' id='blng_grp_id' value='' /> 
<input type='hidden' name='cust_grp_code' id='cust_grp_code' value='' /> 
<input type='hidden' name='cust_code' id='cust_code' value='' /> 
<input type='hidden' name='policy_type_code' id='policy_type_code' value='' /> 
<input type='hidden' name='proceed_visit_regn' id='proceed_visit_regn' value='' /> 
<input type='hidden' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='' /> 
<input type='hidden' name='downtimePatient' id='downtimePatient' value='' /> 
<input type='hidden' name='isForm60Available' id='isForm60Available' value='' /> 
<input type='hidden' name='reg_date_time' id='reg_date_time' value='' /> 
<input type='hidden' name='validationForPanCardAvail' id='validationForPanCardAvail' value='' /> 
<input type='hidden' name='form60_YN' id='form60_YN' value='' /> 
<input type='hidden' name='defFinDtls' id='defFinDtls' value='' /> 
<input type='hidden' name='assign_care_locn_desc_prev' id='assign_care_locn_desc_prev' value='' /> 
<input type='hidden' name='apptrefno' id='apptrefno' value='' /> 
<input type='hidden' name='isRoomMandatoryRegVisit' id='isRoomMandatoryRegVisit' value='' /> 
<input type='hidden' name='is_prac_blocked' id='is_prac_blocked' value='' /> 
<input type='hidden' name='action_on_pract_schedule' id='action_on_pract_schedule' value='<%=action_on_pract_schedule%>' /> 
<input type='hidden' name='assigncare_loctype_ind' id='assigncare_loctype_ind' value='' /> 
<input type='hidden' name='assigncare_locacode' id='assigncare_locacode' value='' /> 
<input type='hidden' name='isReferral' id='isReferral' value='' /> 
<input type='hidden' name='isAlternateAddressAppl' id='isAlternateAddressAppl' value='' /> 
<input type='hidden' name='others_id' id='others_id' value='' />
<input type='hidden' name='self_chkin_appt_yn' id='self_chkin_appt_yn' value='Y' />

		</form>
		</body>
	<%
		}else{%>
			<script>
				fnShowNoRecords();
		</script>
		<%}
	} catch(Exception e){
		e.printStackTrace();
	}
   finally
    {
		ConnectionManager.returnConnection(con,request);
    }
	%>

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


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.util.HashMap,eOT.SetUpParamForFacilityBean" contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String) session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/> 
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script language='javascript' src='../../eOT/js/SetUpParameterForFacility.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
	String facility_id = (String) session.getAttribute("facility_id");
	String bean_id = "SetUpParamForFacilityBean";
	String bean_name = "eOT.SetUpParamForFacilityBean";
	SetUpParamForFacilityBean bean = (SetUpParamForFacilityBean) mh.getBeanObject( bean_id, request, bean_name );
	String empty = "".intern();
	String warn_limit_waitlist_days = empty;
	String warn_unscheduled_cases_only= empty;
	String ipbooking_with_theatre_yn= empty;
	String bkg_fin_alert_for_op= empty;
	String bkg_fin_alert_for_em= empty;
	String pac_review_orderable= empty;
	String allwdSwabCnts = empty; //IN054191
	String no_of_swab_count_reqd= empty;
	String chk_surgeon_doc_cmpl_for_sts= empty;
	String chk_nursing_doc_cmpl_for_sts= empty;
	String chk_intra_doc_cmpl_for_sts= empty;
	String disp_last_antib_preop_yn= empty;
	String slate_login_reqd_yn= empty;
	String auto_schdl_to_nxtday_yn= empty; //Added for ML-MMOH-CRF-1791-US001
	String ot_slate_no_of_days= empty;
	String check_in_backdate_limit_days = empty;
	String bl_interface_flag= empty;
	String ss_dco_type_code= empty;
	String st_doc_type_sli= empty;
	String st_interface_flag= empty;
	String oh_interface_flag= empty;
	String oh_task_catalog= empty;
	String oh_task_catalog_desc= empty;
	String inv_doc_type= empty;
	String st_doc_type_sli_desc = empty;
	String st_doc_type_rti = empty; 
	String st_doc_type_rti_desc = empty;
	String doc_desc = empty;
	String genpac_desc = empty;
	String ss_module_YN = empty;
	String diary_sched_for_surg_reqd_yn = empty;
	String st_module_installed_yn = empty;
	String Oh_module_installed_yn = empty;
	//Commented by rajesh.., bcoz its moved to BillingSetup tab for cr -0224&284
	//	String billing_sub_surfaces_yn= empty;//newly added by rajesh on 12/08
	String booking_cut_off_time_elec_case= empty;//newly added by rajesh on 14/10
	String reason_for_rearrange_seqence= empty;//newly added by rajesh on 14/10
	//Added by Rajesh 5-9-2012
	String ot_image_cssd = empty;
	String ot_image_cssd_hd = empty;
	String instrument_cssd_image = empty;
	String external_link =empty;
	String display_hospital =empty;//Added by MuthuN against CHL-CRF-0020.1 on 11/6/2013
	String default_user_role=empty;//PMG-CRF-003
	String Link_Operation_And_Notes_in_Record_Surgeon_Notes=empty;//PMG-MOD-0005
	String customer_id1="";// Added for IN:41808	
    //Added by Rajesh 5-9-2012
	String booking_priority_orders_yn= empty; //  KDAH-CRF-0283 [IN:050553]
	String chkAmmendBookings = empty; //ChAiTu
	String chkAmmendBookingsDays = empty; //ChAiTu
	String IncludeBlockedSlot = empty; //ML-MMOH-CRF-0337
	String multicheckinallowed_yn= empty;//PMG2016-KDAH-CRF-0001
	String allow_to_update= empty;//PMG2023-MMS-CRF-0002
	
	String	tab_id="OtherDetails";
	String  mode=bean.getMode();
	HashMap map=new HashMap();
	/*GDOH-SCF-0045 [IN:050098] 
		map=(session.getAttribute(tab_id)!=null)?(HashMap)session.getAttribute(tab_id):bean.getQueryDtls(tab_id,facility_id);
	//	map=(session.getAttribute(tab_id)!=null)?bean.getQueryDtls(tab_id,facility_id):bean.getQueryDtls(tab_id,facility_id);

		String session_facility_id=(String) map.get("facility_id");
		if(!facility_id.equals(session_facility_id))
			map=bean.getQueryDtls(tab_id,facility_id);
	*/
	map = bean.getQueryDtls(tab_id, facility_id);//GDOH-SCF-0045 [IN:050098] 
	if( ("UPDATE".equals(mode) || "INSERT".equals(mode)) )
	{
		// map=bean.getQueryDtls(tab_id);
		 warn_limit_waitlist_days = (String) map.get("warn_limit_waitlist_days");
		 warn_unscheduled_cases_only= (String) map.get("warn_unscheduled_cases_only");
		 ipbooking_with_theatre_yn= (String) map.get("ipbooking_with_theatre_yn");
		 bkg_fin_alert_for_op= (String) map.get("bkg_fin_alert_for_op");
		 bkg_fin_alert_for_em= (String) map.get("bkg_fin_alert_for_em");
		 pac_review_orderable= (String) map.get("pac_review_orderable");
		 allwdSwabCnts = (String) map.get("allwdSwabCnts"); //IN054191
		 System.err.println("===allwdSwabCnts===="+allwdSwabCnts);
		 no_of_swab_count_reqd= (String) map.get("no_of_swab_count_reqd");
		 chk_surgeon_doc_cmpl_for_sts= (String) map.get("chk_surgeon_doc_cmpl_for_sts");
		 chk_nursing_doc_cmpl_for_sts= (String) map.get("chk_nursing_doc_cmpl_for_sts");
		 chk_intra_doc_cmpl_for_sts= (String) map.get("chk_intra_doc_cmpl_for_sts");
		 disp_last_antib_preop_yn= (String) map.get("disp_last_antib_preop_yn");
		 slate_login_reqd_yn= (String) map.get("slate_login_reqd_yn");
		 auto_schdl_to_nxtday_yn= (String) map.get("auto_schdl_to_nxtday_yn"); //Added for ML-MMOH-CRF-1791-US001
		 ot_slate_no_of_days=checkForNull( (String) map.get("ot_slate_no_of_days"));
		 check_in_backdate_limit_days=checkForNull( (String) map.get("check_in_backdate_limit_days"));
		 external_link = checkForNull((String) map.get("external_link"));
		 display_hospital = checkForNull((String) map.get("display_hospital"));//Added by MuthuN against CHL-CRF-0020.1 on 11/6/2013
		 default_user_role = checkForNull((String) map.get("default_user_role"));//PMG-CRF-003
		 booking_priority_orders_yn = checkForNull((String) map.get("booking_priority_orders_yn"));//KDAH-CRF-0283 [IN:050553]
		 Link_Operation_And_Notes_in_Record_Surgeon_Notes=checkForNull((String)map.get("Link_Operation_And_Notes_in_Record_Surgeon_Notes"));//PMG-MOD-0005
		 chkAmmendBookings = checkForNull((String) map.get("chkAmmendBookings")); // ChAiTu
		 chkAmmendBookingsDays = checkForNull((String) map.get("chkAmmendBookingsDays")); // ChAiTu
		 IncludeBlockedSlot = checkForNull((String) map.get("IncludeBlockedSlot")); //ML-MMOH-CRF-0337
		 multicheckinallowed_yn = checkForNull((String) map.get("multiCheckInAllowed_YN")); //PMG2016-KDAH-CRF-0001
		 if(ot_slate_no_of_days.equalsIgnoreCase("") ){
			ot_slate_no_of_days="0";
		 }

		//Modified by DhanasekarV against the issue IN024823 
 		 if(check_in_backdate_limit_days.equalsIgnoreCase("") ){
			check_in_backdate_limit_days="0";
		 }

		 bl_interface_flag= (String) map.get("bl_interface_flag");
		 allow_to_update= (String) map.get("allow_to_update"); //Added Against PMG2023-MMS-CRF-0002
		 //cssd_interface_yn= (String) map.get("cssd_interface_yn");
		 ss_dco_type_code= (String) map.get("ss_dco_type_code");
		 st_doc_type_sli= (String) map.get("st_doc_type_sli");
		 //Newly Added on 04/08 for DefaultStoreCode & Desc....

		 st_doc_type_rti= (String) map.get("st_doc_type_rti");
		 //st_doc_type_rti_desc= (String) map.get("st_doc_type_rti_desc"); 
		 st_interface_flag= (String) map.get("st_interface_flag");
		 oh_interface_flag= (String) map.get("oh_interface_flag");
		 oh_task_catalog= (String) map.get("oh_task_catalog");
		 inv_doc_type= (String) map.get("inv_doc_type");
		 genpac_desc= (String) map.get("genpac_desc");
		 //st_doc_type_sli_desc= (String) map.get("st_doc_type_sli_desc");
		 doc_desc= (String) map.get("doc_desc");
		 ss_module_YN= (String) map.get("ss_module_YN");
		 diary_sched_for_surg_reqd_yn= (String) map.get("diary_sched_for_surg_reqd_yn");
		 //Commented by rajesh.., bcoz its moved to BillingSetup tab for cr -0224&284
		 //billing_sub_surfaces_yn= (String) map.get("billing_sub_surfaces_yn");//newly addews by rajesh on 12/08/08
		 booking_cut_off_time_elec_case= (String) map.get("booking_cut_off_time_elec_case");//newly addews by rajesh on 14/10/08
		 reason_for_rearrange_seqence= (String) map.get("reason_for_rearrange_seqence");//newly addews by rajesh on 14/10/08
		 //Added by Rajesh 5-9-2012 
		 ot_image_cssd = (String) map.get("ot_image_cssd");
		 //Added by Rajesh 5-9-2012
	}
	String chk_flags = warn_unscheduled_cases_only+"::"+ipbooking_with_theatre_yn+"::"+chk_surgeon_doc_cmpl_for_sts+"::"+chk_nursing_doc_cmpl_for_sts+"::"+chk_intra_doc_cmpl_for_sts+"::"+disp_last_antib_preop_yn+"::"+bl_interface_flag+"::"+st_interface_flag+"::"+slate_login_reqd_yn+"::"+reason_for_rearrange_seqence+"::"+oh_interface_flag+"::"+oh_task_catalog+"::"+external_link+"::"+display_hospital+"::"+default_user_role+"::"+booking_priority_orders_yn+"::"+Link_Operation_And_Notes_in_Record_Surgeon_Notes+"::"+chkAmmendBookings+"::"+IncludeBlockedSlot+"::"+multicheckinallowed_yn+"::"+auto_schdl_to_nxtday_yn+"::"+allow_to_update;//ML-MMOH-CRF-0337 and PMG2016-KDAH-CRF-0001 and ML-MMOH-CRF-1791 and PMG2023-MMS-CRF-0002
	//+"::"+asa_score+"::"+ccs_score+"::"+nyha_score ;//ML-MMOH-CRF-1952
	String lst_val = bkg_fin_alert_for_op+"@@"+bkg_fin_alert_for_em+"@@"+no_of_swab_count_reqd+"@@"+diary_sched_for_surg_reqd_yn + "@@" + allwdSwabCnts; //IN054191
	Connection con = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt_cat = null;
	ResultSet rst1 = null;
	ResultSet rst1_cat = null;

try{
		String sql_sale="SELECT SY.SHORT_DESC DESCRIPTION,ST.DOC_TYPE_CODE CODE FROM ST_TRN_DOC_TYPE ST,SY_DOC_TYPE_MASTER_LANG_VW SY WHERE ST.DOC_TYPE_CODE='"+st_doc_type_sli+"' AND ST.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND SY.LANGUAGE_ID='"+locale+"' AND ST.FACILITY_ID='"+facility_id+"' AND ST.TRN_TYPE= 'SAL'";
		String sql_req="SELECT B.SHORT_DESC DESCRIPTION,A.DOC_TYPE_CODE CODE FROM ST_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER B WHERE A.FACILITY_ID = '"+facility_id+"'  AND A.DOC_TYPE_CODE='"+st_doc_type_rti+"' AND  A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.TRN_TYPE= 'ISS'";
		String sql_catalog_desc = " SELECT LONG_DESC DESCRIPTION,ORDER_CATALOG_CODE CODE  FROM OR_ORDER_CATALOG WHERE ORDER_CATEGORY = 'OT' and ORDER_CATALOG_CODE='"+oh_task_catalog+"'";
		con = ConnectionManager.getConnection(request);
		pstmt1 = con.prepareStatement(sql_sale) ;
		rst1 = pstmt1.executeQuery();
		while(rst1.next()){
			st_doc_type_sli_desc=checkForNull(rst1.getString(1));
		}

		pstmt_cat = con.prepareStatement(sql_catalog_desc) ;
		rst1_cat = pstmt_cat.executeQuery();
		while(rst1_cat.next()){
			oh_task_catalog_desc=checkForNull(rst1_cat.getString(1));
		}
	if(rst1!=null)rst1.close();
	if(pstmt1 !=null)pstmt1.close();
		pstmt1 = con.prepareStatement(sql_req) ;
		rst1 = pstmt1.executeQuery();
		while(rst1.next()){
			st_doc_type_rti_desc=checkForNull(rst1.getString(1));
		}
		
	}catch(Exception e){
		System.err.println("Err Msg SetupParam4FacilityOtheretails.jsp "+e.getMessage());
	}finally{
		if(rst1!=null)rst1.close();
		if(pstmt1 !=null)pstmt1.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}

try{

		String sql_req="SELECT NVL(OPERATIONAL_YN,'N') INSTALL_YN FROM SM_MODULES_FACILITY WHERE MODULE_ID = 'ST' AND FACILITY_ID = '"+facility_id+"'";
		con = ConnectionManager.getConnection(request);
		pstmt1 = con.prepareStatement(sql_req) ;
		rst1 = pstmt1.executeQuery();
		while(rst1.next()){
			st_module_installed_yn=checkForNull(rst1.getString(1));
		}

		if(rst1!=null)rst1.close();
		if(pstmt1 !=null)pstmt1.close();

		String sql_req_oh="SELECT NVL(OPERATIONAL_YN,'N') INSTALL_YN FROM SM_MODULES_FACILITY WHERE MODULE_ID = 'OH' AND FACILITY_ID = '"+facility_id+"'";
		pstmt1 = con.prepareStatement(sql_req_oh) ;
		rst1 = pstmt1.executeQuery();
		if(rst1.next()){
			Oh_module_installed_yn=checkForNull(rst1.getString(1));			
		}	
	}catch(Exception e){
		System.err.println("Err Msg SetupParam4FacilityOtheretails.jsp "+e.getMessage());
	}finally{
		if(rst1!=null)rst1.close();
		if(pstmt1 !=null)pstmt1.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
//Added by Rajesh 5-9-2012
try{
	String sql_instr_cssd = "SELECT INSTRUMENT_CSSD_IMAGE FROM OT_PARAM where rownum = 1";
	con = ConnectionManager.getConnection(request);
	pstmt1 = con.prepareStatement(sql_instr_cssd) ;
	rst1 = pstmt1.executeQuery();
	while(rst1.next()){
		instrument_cssd_image=checkForNull(rst1.getString(1));			
	}

	if(rst1!=null)rst1.close();
	if(pstmt1 !=null)pstmt1.close();
}
catch(Exception e){
	System.err.println("Err Msg SetupParam4FacilityOtheretails.jsp "+e.getMessage());
}
finally{
	if(rst1!=null)rst1.close();
	if(pstmt1 !=null)pstmt1.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request); 
}
//Added by Rajesh 5-9-2012
%>
<body onLoad = "setChkBoxValues('<%=chk_flags%>');setListBoxValues('<%=lst_val%>');" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- Page formated By yadav -->
<form name="SetUpParameterForFacilityForm" id="SetUpParameterForFacilityForm"  onload='FocusFirstElement();'  target="messageFrame"> 
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
    <tr>
    <td class="BORDER">
<!-- Border test end -->
<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
        <tr>
            <td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.BookingWaitList.Label" bundle="${ot_labels}"/></b>
            </td>
        </tr>

        <tr><td colspan='2'></td></tr>
 
        <tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
                        <td  class="label" width='25%'>
                            <fmt:message key="eOT.WaitlistWarningLimitDays.Label" bundle="${ot_labels}"/>
						</td>
						<td width='20%'>
                            <input type='text' name='warn_limit_waitlist_days' id='warn_limit_waitlist_days' size='2' maxlength='2' value="<%=warn_limit_waitlist_days%>" onkeypress="return checkForSpecChars(event);" onblur="CheckForPositiveNumber(this);" >
		                </td>
					
						<td class="label" width='20%'>
                            <fmt:message key="eOT.WarnForUnscheduledCasesOnly.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						    <input type='checkbox' name='warn_unscheduled_cases_only' id='warn_unscheduled_cases_only' value='<%=warn_unscheduled_cases_only%>' onClick="setChkBoxValue(this);" >
                        </td>
					</tr>
					<tr>
						<td class="label" width='25%'>
                            <fmt:message key="eOT.InitiateIPBooking.Label" bundle="${ot_labels}"/>
						</td>
						<td width='25%'>
                            <input type='checkbox' name='ipbooking_with_theatre_yn' id='ipbooking_with_theatre_yn' value='<%=ipbooking_with_theatre_yn%>' onClick="setChkBoxValue(this);"  >
                       </td>
					 <!--  <td width="25%" class="label">
								<fmt:message key="eOT.DiarySchduleForSurgeonReqd.Label" bundle="${ot_labels}"/>
								<input type='checkbox' name='diary_sched_for_surg_reqd_yn' id='diary_sched_for_surg_reqd_yn' value='<%=diary_sched_for_surg_reqd_yn%>' onClick="setChkBoxValue(this);">
						</td> -->
						<td class="label" width='25%'>
		               <fmt:message key="eOT.DiarySchduleForSurgeonReqd.Label" bundle="${ot_labels}"/> 
					   	</td>
						<td>
	                  	 <select name='diary_sched_for_surg_reqd_yn' id='diary_sched_for_surg_reqd_yn' >
						<option value='Y'>
						<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
						</option>
						<option value='N'>
						<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/></option>
					</select>
	</td>
					   </tr>
					   <tr>
					   <td class="label" width='40%'>
								<fmt:message key="eOT.BookingCut-offTimeforElectiveCases.Label" bundle="${ot_labels}"/>
						</td>
						<td >
								<input type='text' name='booking_cut_off_time_elec_case' id='booking_cut_off_time_elec_case' size='5' maxlength='5' value='<%=booking_cut_off_time_elec_case%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidTime(this)">
						</td>
						 <!-- start KDAH-CRF-0283 [IN:050553] --> 
						<td class="label" width='40%'>
								<fmt:message key="eOT.BookingPriorityPendingOrders.label" bundle="${ot_labels}"/>
						</td>
						<td width='25%'>
                            <input type='checkbox' name='booking_priority_orders_yn' id='booking_priority_orders_yn' value='<%=booking_priority_orders_yn%>' onClick="setChkBoxValue(this);"  >
						 <!-- End KDAH-CRF-0283 [IN:050553] --> 	
                       </td>
						<td colspan=2>&nbsp;</td>
						</tr>

					   <tr>
					    <td class="label" width='40%'><fmt:message key="eOT.AllowMergeOfPendingOrdersIntoExistingBooking.Label" bundle="${ot_labels}"/></td>
						<td width='25%'>
                            <input type='checkbox' name='chkAmmendBookings' id='chkAmmendBookings' id='chkAmmendBookings' value='<%=chkAmmendBookings%>' onClick="setChkBoxValue(this);"  >
                       </td>
						<td class="label" width='40%'><fmt:message key="eOT.TimelimitForExistingBookingSelection.Label" bundle="${ot_labels}"/></td>
						<td >
							<input type='text' name='chkAmmendBookingsDays' id='chkAmmendBookingsDays' id='chkAmmendBookingsDays' size='5' maxlength='3' value='<%=chkAmmendBookingsDays%>' onkeypress="return checkForSpecChars(event);">
						</td>
						<td colspan=2>&nbsp;</td>
						</tr>
						<!-- start ML-MMOH-CRF-0337 --> 
						<tr>
						<td class="label" width='40%'><fmt:message key="eOT.IncludeBlockedSlotinAvailableSlotCount.Label" bundle="${ot_labels}"/></td>
						<td width='25%'>
                            <input type='checkbox' name='IncludeBlockedSlot' id='IncludeBlockedSlot' id='IncludeBlockedSlot' value='<%=IncludeBlockedSlot%>' onClick="setChkBoxValue(this);"  >
                       </td>
						<td colspan=2>&nbsp;</td>
						</tr>
						<!-- start ML-MMOH-CRF-0337 --> 
                </table>
            </td>
        </tr>
	
	<tr>
	    <td class="BORDER">
		<table border='0' cellpadding=3  cellspacing='0' width='100%'>
        <tr>
            <td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.BookingVerification.Label" bundle="${ot_labels}"/></b>
            </td>
        </tr>

        <tr><td colspan='4'></td></tr>
 
        <tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3 cellspacing='0' width='100%'>
                    <tr>
                        <td  class="label">
                            <fmt:message key="eOT.AllowOutpatientswhilefinalizing.Label" bundle="${ot_labels}"/>
						</td>
						<td>
						 <select name='bkg_fin_alert_for_op' id='bkg_fin_alert_for_op'>
							 <option value='S'>
								<fmt:message key="Common.Stop.label" bundle="${common_labels}"/>
							</option>
							 <option value='M'>
								<fmt:message key="Common.Warn.label" bundle="${common_labels}"/>
							</option>
							 <option value='A'>
								<fmt:message key="eOT.Allow.Label" bundle="${ot_labels}"/>
							</option>
							 </select>
                        </td>
					   <td class="label" >
                            <fmt:message key="eOT.AllowEmergPatwhilefinalizing.Label" bundle="${ot_labels}"/>
					    </td>
						<td>
							<select name='bkg_fin_alert_for_em' id='bkg_fin_alert_for_em'>
							 <option value='S'>
								<fmt:message key="Common.Stop.label" bundle="${common_labels}"/>
							 </option>
							 <option value='M'>
								<fmt:message key="Common.Warn.label" bundle="${common_labels}"/>
							 </option>
							 <option value='A'>
								<fmt:message key="eOT.Allow.Label" bundle="${ot_labels}"/>
							 </option>
							 </select>
                        </td>
					</tr>
                </table>
            </td>
        </tr>
		
		<tr><td></td></tr>
		<tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
						<td  class="label" width='20%'> <fmt:message key="eOT.PACReviewOrderable.Label" bundle="${ot_labels}"/> </td>
						<td class="label" width='20%'>
						<input type='text' name='genpac_desc' id='genpac_desc' size='15'  maxlength='10' value="<%=genpac_desc%>"  onBlur="if(this.value!='')callSearchLookUp(pac_review_orderable,genpac_desc,'1');else pac_review_orderable.value='' ">
						<input type='hidden' name='pac_review_orderable' id='pac_review_orderable'  value="<%=pac_review_orderable%>"><input type='button' class='button' value='?' name='btn_genpac' id='btn_genpac' onClick="callSearchLookUp(pac_review_orderable,genpac_desc,'1');" >
		                </td>
						<%-- IN054191 Start --%>
						<td class="label" width="29%"><fmt:message key="eOT.NoOfSwabsRequired.Label" bundle="${ot_labels}"/></td>
						<td>
							<select name='allwdSwabCnts' id='allwdSwabCnts' >
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
							</select><img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<%-- IN054191 end --%>
					</tr>
					<tr>
						<td class="label" width='40%'> <fmt:message key="eOT.ReasonForReArrangeSequenceMandatory.Label" bundle="${ot_labels}"/> </td>
						<td>
							<input type='checkbox' name='reason_for_rearrange_seqence' id='reason_for_rearrange_seqence' value="<%=reason_for_rearrange_seqence%>"  onClick="setChkBoxValue(this);">
						</td>
						<%-- IN054191 Start --%>
						<td class="label" width="20%"> <fmt:message key="eOT.NoofSwabCountsReqdMandatory.Label" bundle="${ot_labels}"/> </td>
						<td>
								<select name='no_of_swab_count_reqd' id='no_of_swab_count_reqd' >
									<!-- Modified against PMG2017-MO-CRF-0001 [IN:063849] -->
										<option value="0">ALL</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<!--<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>-->
									<!-- Modified against PMG2017-MO-CRF-0001 [IN:063849] -->
								</select><img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<%-- IN054191 end --%>
					</tr>
				</table>
			</td>
		</tr>
	
	<tr>
	    <td class="BORDER">
			<table border='0' cellpadding=3  cellspacing='0' width='100%'>
			<tr>
				<td class="COLUMNHEADERCENTER">
               <b>
				<fmt:message key="eOT.DocumentationCompletionStatusCheck.Label" bundle="${ot_labels}"/>
				</b>
				</td>
		</tr>
		<tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
                        <td width="25%" class="label">
						<fmt:message key="eOT.SurgeonDoc.Label" bundle="${ot_labels}"/>
								
                              <input type='checkbox' name='chk_surgeon_doc_cmpl_for_sts' id='chk_surgeon_doc_cmpl_for_sts' value="<%=chk_surgeon_doc_cmpl_for_sts%>"  onClick="setChkBoxValue(this);">
		                </td>
						<td width="25%" class="label">
						<fmt:message key="eOT.NursingDoc.Label" bundle="${ot_labels}"/>
				
						         <input type='checkbox' name='chk_nursing_doc_cmpl_for_sts' id='chk_nursing_doc_cmpl_for_sts' value='<%=chk_nursing_doc_cmpl_for_sts%>' onClick="setChkBoxValue(this);">
						</td>
						<td width="25%" class="label">
						<fmt:message key="eOT.IntraAnaesthesiaDoc.Label" bundle="${ot_labels}"/>
						 <input type='checkbox' name='chk_intra_doc_cmpl_for_sts' id='chk_intra_doc_cmpl_for_sts' value='<%=chk_intra_doc_cmpl_for_sts%>' onClick="setChkBoxValue(this);" >
                       </td>
                    </tr>
                </table>
            </td>
        </tr>
	
	<tr>
	    <td class="BORDER">
			<table border='0' cellpadding=3  cellspacing='0' width='100%'>
			<tr>
				<td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.Slate.Label" bundle="${ot_labels}"/></b>
				</td>
	</tr>
	<tr>
            <td width="100%" class="BORDERX">
                <table border='0' cellpadding=3  cellspacing='0' width='100%'>
                    <tr>
                        <td  class="label" >
						<fmt:message key="eOT.ShowLastAntibioticAdminTime.Label" bundle="${ot_labels}"/>
						</td>
						<td  class='fields'>
						<input type='checkbox' name='disp_last_antib_preop_yn' id='disp_last_antib_preop_yn' value='<%=disp_last_antib_preop_yn%>' onClick="setChkBoxValue(this);">
                       </td>
					   <td  class="label" >
						<fmt:message key="eOT.SlateLoginRequired.Label" bundle="${ot_labels}"/>
						</td>
						<td  class='fields'>
						<input type='checkbox' name='slate_login_reqd_yn' id='slate_login_reqd_yn' value='<%=slate_login_reqd_yn%>' onClick="setChkBoxValue(this);">
                       </td>
			   <!--PMG2016-KDAH-CRF-0001 Starts-->
			   <td class='label'><fmt:message key="eOT.MultiCheckInAllowed.Label" bundle="${ot_labels}"/></td>
			   <td class='fields'>
					   
					   
			   <input type='checkbox' name='multicheckinallowed_yn' id='multicheckinallowed_yn' value="<%=multicheckinallowed_yn%>" onClick="setChkBoxValue(this);">
					   
			   </td>
			   <!-- PMG2016-KDAH-CRF-0001 Ends-->
                    </tr>
					<tr>
				    <td  class="label" >
						<fmt:message key="eOT.IncludeCasesforPast.Label" bundle="${ot_labels}"/>
					<input type='text' name='ot_slate_no_of_days' id='ot_slate_no_of_days' value='<%=ot_slate_no_of_days%>' onkeypress="return checkForSpecChars(event)" size='2' maxlength='2' onblur=>
					<fmt:message key="Common.days.label" bundle="${common_labels}"/>
					</td>
					<td  class="label" ></td>
					<td  class="label" >
						<fmt:message key="eOT.CheckInBackdateLimit.Label" bundle="${ot_labels}"/>
					<input type='text' name='check_in_backdate_limit_days' id='check_in_backdate_limit_days' value='<%=check_in_backdate_limit_days%>' onkeypress="return checkForSpecChars(event)" size='3' maxlength='3' >
					<fmt:message key="Common.days.label" bundle="${common_labels}"/>
					</td>
					<!-- Added by Arthi for ML-MMOH-CRF-1791-US001 on 10-Apr-2023 -->
					<td  class="label" ></td>
					<td class="label" width='25%' nowrap><fmt:message key="eOT.AutoSchdlToNxtDay.Label" bundle="${ot_labels}"/>
					</td>
					<td  class='fields'>
						<input type='checkbox' name='auto_schdl_to_nxtday_yn' id='auto_schdl_to_nxtday_yn' value='<%=auto_schdl_to_nxtday_yn%>' onClick="setChkBoxValue(this);">
                    </td>
					<!-- End ML-MMOH-CRF-1791-US001 -->

                       </tr>
					     <!-- Below line was added by venkatesh.S on 27-Aug-2013 against RUT-CRF-0083.4[IN041509] -->
                        <tr>
						<td  class="label" >
						<fmt:message key="eOT.ExternalLink.Label" bundle="${ot_labels}"/>
						</td>
						<td  class='fields'>
						<input type='checkbox' name='external_link' id='external_link' value='<%=external_link%>' onClick="setChkBoxValue(this);">
                       </td>
					<!-- Added by MuthuN against CHL-CRF-0020.1 on 11/6/2013 --> 
				<%
				//if(customer_id1.equalsIgnoreCase("RTN")){
				%>
					   <td  class="label" >
						<fmt:message key="eOT.DisplayHospitalPersonnel.Label" bundle="${ot_labels}"/>
						</td>
						<td class='fields'>
						<input type='checkbox' name='display_hospital' id='display_hospital' value='<%=display_hospital%>' onClick="setChkBoxValue(this);">
                       </td>
				<%
				//	}
				%>
					<!-- End CHL-CRF-0020.1 on 11/6/2013 --> 
					<!-- PMG-CRF-003 --> 
					</tr>
					 <tr>
					 <td  class="label" >
					<fmt:message key="eOT.DefaultUserRole.Label" bundle="${ot_labels}"/>
					</td>
					<td class='fields'><input type='checkbox' name='default_user_role' id='default_user_role' value='<%=default_user_role%>' onClick="setChkBoxValue(this);">
                       			</td>

					<!--PMG MOD 0005 start-->
					 <td  class="label">

					<fmt:message key="eOT.LinkOperationAndNotesinRecordSurgeonNotes.Label" bundle="${ot_labels}"/>
					</td>
					<td class='fields'><input type='checkbox' name='Link_Operation_And_Notes_in_Record_Surgeon_Notes' id='Link_Operation_And_Notes_in_Record_Surgeon_Notes' value='<%=Link_Operation_And_Notes_in_Record_Surgeon_Notes%>' onClick="setChkBoxValue(this);">
                       			</td>

					</tr>
					<!--PMG MOD 0005 end-->
                </table>
            </td>
     </tr>	
	
	<tr>
	    <td class="BORDER">
			<table border='0' cellpadding=4  cellspacing='0' width='100%'>
			<tr>
				<td class="COLUMNHEADERCENTER">
                <b><fmt:message key="eOT.Interfaces.Label" bundle="${ot_labels}"/></b>
				</td>															
	</tr>
<%if(!"Y".equals(st_module_installed_yn)){%>
	<tr>
            <td width="100%" class="BORDERX">
                <table border='0'  cellspacing='0' width='100%'>
                    <tr>
                        <td  class="label" width='25%'>
								<fmt:message key="eOT.InterfacetoRevenuemanag.Label" bundle="${ot_labels}"/>
						</td>
						<td class="fields" width='25%'>
								<input type='checkbox' name='bl_interface_flag' id='bl_interface_flag' value='<%=bl_interface_flag%>' onClick="setChkBoxValue(this); checkEnaDisBillSetupTab();">
						</td>
						<td  width='25%'></td>
						<td  width='25%'></td>
				</tr>
			</table>
		</td>
	</tr>

	<%}else{%>
	<tr>
            <td width="100%" class="BORDERX">
                <table border='0'  cellspacing='0' width='100%'>
                    <tr>
                        <td  class="label" width='25%'>
								<fmt:message key="eOT.InterfacetoRevenuemanag.Label" bundle="${ot_labels}"/>
						</td>
						<td class="fields" width='25%'>
								<input type='checkbox' name='bl_interface_flag' id='bl_interface_flag' value='<%=bl_interface_flag%>' onClick="setChkBoxValue(this); checkEnaDisBillSetupTab();">
						</td>
					<td class="label" width='25%'>
								<fmt:message key="eOT.InterfacetoInventory.Label" bundle="${ot_labels}"/>
					</td>
					<td class="fields" width='25%'>
					 <input type='checkbox' name='st_interface_flag' id='st_interface_flag' value='<%=st_interface_flag%>' onClick="setChkBoxValue(this);">
					 </table>
					</td>
			</tr>

		<%}%>

		<%if(Oh_module_installed_yn.equals("Y")) {%>
		<tr>
            <td width="100%" class="BORDERX">
			                <table border='0'  cellspacing='0' width='100%'>

                    <tr>
                        <td  class="label" width='25%'>
								<fmt:message key="eOT.interfacetooralhealth.Label" bundle="${ot_labels}"/>
						</td>
						<td class="fields" width='25%'>
								<input type='checkbox' name='oh_interface_flag' id='oh_interface_flag' value='<%=oh_interface_flag%>' onClick="setChkBoxValue(this);">
						</td>
						<td  width='25%'></td>
						<td  width='25%'></td>
						</table>
			</tr>
		<%}%>

<%
	if("Y".equals(st_module_installed_yn)){%>
	<tr>
	 <table border='0'  cellspacing='0' width='100%'>
					<td class="label"  width='25%'>
					 <fmt:message key="eOT.SaleDoctype.Label" bundle="${ot_labels}"/>
					</td>
					<td width='25%'>
					<!-- commented by parul on 6/11/2009 for IN011337   -->
					<!--  <input type='hidden' name='st_doc_type_sli' id='st_doc_type_sli' value='<%=st_doc_type_sli%>'>
					 <input type='text' name='st_doc_type_sli_desc' id='st_doc_type_sli_desc' value='<%=st_doc_type_sli_desc%>' size='10' maxlength='15' onBlur="if(this.value!=null)callSearchLookUp(st_doc_type_sli,st_doc_type_sli_desc,'4'); else sale_doc_type_code.value=''">
					 <input type='button' class ='button'  name='st_doc_sale_btn' id='st_doc_sale_btn' onClick="callSearchLookUp(st_doc_type_sli,st_doc_type_sli_desc,'4');" value="?"  >   -->

					  <input type='text' name='st_doc_type_sli_desc' id='st_doc_type_sli_desc' size='10' maxlength='15' value="<%=st_doc_type_sli_desc%>"onBlur="if(this.value!='')callSearchLookUp(st_doc_type_sli,st_doc_type_sli_desc,'4');else st_doc_type_sli.value=''"><input type='hidden' name='st_doc_type_sli' id='st_doc_type_sli'  value="<%=st_doc_type_sli%>"><input type='button' class='button' value='?' name='st_doc_sale_btn' id='st_doc_sale_btn' onClick="callSearchLookUp(st_doc_type_sli,st_doc_type_sli_desc,'4');" > 
					</td>

					<td class="label" width='25%'>
					 <fmt:message key="eOT.RequestDocType.Label" bundle="${ot_labels}"/>
					 </td>
					 <td width='25%'>
					 <!-- commented by parul on 6/11/2009 for IN011337   -->
					<!--  <input type='hidden' name='st_doc_type_rti' id='st_doc_type_rti' value='<%=st_doc_type_rti%>'>
					 <input type='text' name='st_doc_type_rti_desc' id='st_doc_type_rti_desc' value='<%=st_doc_type_rti_desc%>' size='10' maxlength='15' onBlur="if(this.value!=null)callSearchLookUp(st_doc_type_rti,st_doc_type_rti_desc,'2');	else st_doc_type_rti.value=''" ><input type='button' class ='button'  name='st_doc_req_btn' id='st_doc_req_btn'   value="?" onBlur="callSearchLookUp(st_doc_type_rti,st_doc_type_rti_desc,'2');" > -->
					<input type="text"  name="st_doc_type_rti_desc" id="st_doc_type_rti_desc" size='10' maxlength='15' value="<%=st_doc_type_rti_desc%>"onBlur="if(this.value!='')callSearchLookUp(st_doc_type_rti,st_doc_type_rti_desc,'2');else st_doc_type_rti.value=''"><input type="hidden" name="st_doc_type_rti" id="st_doc_type_rti" value="<%=st_doc_type_rti%>"><input type="button" class="button" name="st_doc_req_btn" id="st_doc_req_btn" value="?" onclick="callSearchLookUp(st_doc_type_rti,st_doc_type_rti_desc,'2');"></td>
</table>

		 </tr>
 <%}%>
</table>
	<%if(Oh_module_installed_yn.equals("Y")) {%>
	<tr>
	    <td class="BORDER"  width='100%'>
			<table border='0' cellpadding=4  cellspacing='0' width='100%'>
			<tr>
				<td class="COLUMNHEADERCENTER" COLSPAN='4' width='25%'>
                <b><fmt:message key="eOT.invokeDentalChart.Label" bundle="${ot_labels}"/></b>
				</td>	
		

	</tr>

	<tr>

						 <td  class="label" width='25%'>
									<fmt:message key="eOT.OralHealthOTprocedure.Label" bundle="${ot_labels}"/>
						  </td>
						  <td class="fields" width='25%'>
						<!-- 	<input type="text"  name="oh_dental_chart" id="oh_dental_chart" size='10' maxlength='15' value=""onBlur=""><input type="hidden" name="oh_dental_chart_code" id="oh_dental_chart_code" value=""><input type="button" class="button" name="oh_dental_chart_lookup" id="oh_dental_chart_lookup" value="?" onclick="">
 -->
							<input type='text' name='oh_task_catalog_desc' id='oh_task_catalog_desc' size='15'  maxlength='10' value="<%=oh_task_catalog_desc%>"  disabled onBlur="if(this.value!='')callSearchLookUp(oh_task_catalog,oh_task_catalog_desc,'5');"><input type='hidden' name='oh_task_catalog' id='oh_task_catalog'  value="<%=oh_task_catalog%>"><input type='button' class='button' value='?' disabled name='oh_dental_chart_lookup' id='oh_dental_chart_lookup' onClick="callSearchLookUp(oh_task_catalog,oh_task_catalog_desc,'5');" > 

						</td>
						<td  width='25%'></td>
						<td  width='25%'></td>
	</tr>
 <%}%>

                </table>
            </td>
        </tr>	
</table>
 <!-- Added by Rajesh -->
 <% if(instrument_cssd_image.equals("Y")){ %>
			<table border='0' cellpadding=4  cellspacing='0' width='100%'>
			<tr>
				<td class="COLUMNHEADERCENTER" COLSPAN='4' width='25%'>
                <b><fmt:message key="eOT.InstrCSSDImg.Label" bundle="${ot_labels}"/></b>
				</td>	
		
 	</tr>
 	<tr>

						 <td  class="label" width='25%'>
									<fmt:message key="eOT.InstrCSSDImgLoc.Label" bundle="${ot_labels}"/>
						  </td>
						  <td class="fields" width='25%'>						
							<input type='text' name='ot_image_cssd' id='ot_image_cssd' size='100'  maxlength='100' value="<%=ot_image_cssd%>" ><input type='hidden' name='ot_image_cssd_hd' id='ot_image_cssd_hd'  value="<%=ot_image_cssd_hd%>"> 

						</td>
						<td  width='25%'></td>
						<td  width='25%'></td>
	</tr>
	</table>
<%} %>
<!-- Added by Rajesh -->

<!-- Added by Gaurav PMG2023-MMS-CRF-0002 -->
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
	<tr>
		<td class="COLUMNHEADERCENTER" >
            <b><fmt:message key="eOT.UpdatingNotesDoc.Label" bundle="${ot_labels}"/></b>
		</td>															
	</tr>
	<tr>
        <td width="100%" class="BORDERX">
            <table border='0'  cellspacing='0' width='100%'>
                <tr>
                    <td  class="label" >
						<fmt:message key="eOT.AllowToUpdateNotes.Label" bundle="${ot_labels}"/>
					</td>
					<td class="fields" >
						<input type='checkbox' name='allow_to_update' id='allow_to_update' value='<%=allow_to_update%>' onClick="setChkBoxValue(this);">
					</td>
					<td  width='25%'></td>
					<td  width='25%'></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Added by Gaurav PMG2023-MMS-CRF-0002 -->
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="tab_id" id="tab_id" value="<%=tab_id%>">
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>' >
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>' >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">				
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">				
<input type='hidden' name='ss_module_YN' id='ss_module_YN' value="<%=ss_module_YN%>">				
<input type='hidden' name='st_module_installed_yn' id='st_module_installed_yn' value="<%=st_module_installed_yn%>">				
<input type='hidden' name='Oh_module_installed_yn' id='Oh_module_installed_yn' value="<%=Oh_module_installed_yn%>">				
 </form>
 </head>
</html>


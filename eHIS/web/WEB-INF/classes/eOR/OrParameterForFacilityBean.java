/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------
Date			Edit History	Name		Rev.Date	Rev.Name		Description
-------------------------------------------------------------------------------------------------------
?             	100            	?          	?			?				created
03/04/2013    	IN035929 		Karthi L	?			?				When user Place in OR/CA, user should not see Service charges. 
26/02/2014		IN047204		Karthi L	07/03/2014	Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
30/01/2015		IN052649		Ramesh G	04/02/2015	Akbar						Previous orders - Default filter to be filtered by All or by specialty 
02/01/2017		IN061888		Karthi L									To record collection all at 1 go
31/10/2017		IN061892		Prakash C	31/10/2017	Ramesh G			ML-MMOH-CRF-0544 [IN:061892]	
20/12/2017		IN066129		Prakash C	20/10/2017	Ramesh G			OR-Parameter for facility 
26/02/2018		IN066119		Raja S		26/02/2018	Ramesh G		ML-MMOH-CRF-1024
25/04/2020		IN071618		Ramesh G	25/04/2020	Ramesh G		PMG2019-MMS-CRF-0004
13/10/2022       37018           Venkat S                                     PMG2021-COMN-CRF-0080-US001
-------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class OrParameterForFacilityBean extends eOR.Common.OrAdapter implements java.io.Serializable {

	String facility = "";
	String consenet_form_source="";
	String consenet_form_prnt = "";
	String refusal_destination="";
	String refusal_source="";
	String referral_destination="";
	String referral_source="";
	String prnt_at_destination= "";
	String prnt_at_source = "";
	String prnt_at_dept = "";
	String oth_loc_print = "";
	String oth_specific_loc_name = "";
	String dischg_pat_prnt = "";
	String dischg_specific_loc_name = "";
	String behind_hrs = "";
	String ahead_hrs = "";
	String reactivate_hrs ="";
	String expired_hrs = "";
	String discontinued_hrs = "";
	String intf_to_billing = "";
	String intf_to_billing_days = "";
	String PRINT_REFU_AT_DEST_LOCN="";
	//String PRINT_REFERRAL_AT_DEST_LOCN="";

	String specimen_behind_hrs = "";
	String specimen_ahead_hrs = "";
	String ext_order_referral_code="";
	/* Added By Uma, For the CRF 640*/
	String BilledButNotReceipted = "";
	String PostedToFolioButNotBilledReceipted = "";
	String MaxAllowedPeriod = "";
	/* Added By Uma, For the SRR20056-CRF 195*/
	String DefRefundOptDiscOrder = "";
	/* Ends here.*/
	String InvokeSetScreenForExtOrders = "";
	String InvokeSetScreenForOPOrders = "";
	String InvokeSetScreenForEMOrders = "";
	String InvokePrintRepForBilling = "";
	String disp_bl_dtl_yn = ""; // added for IN035929
	String dms_ext_link_yn = ""; // added for IN047204
	String OrderingSpecialityCopyPreviousOrder = ""; //added for IN052649
	String DefaultPeriodCopyPreviousOrders = "";  //IN052649
//IN061892  start
	String alrt_time_for_not_reg_lab_spec="";
	public void setAlrtTimeForNotRegLabSpec(String alrt_time_for_not_reg_lab_spec) {
		this.alrt_time_for_not_reg_lab_spec = alrt_time_for_not_reg_lab_spec;
	}
	public String getAlrtTimeForNotRegLabSpec() {
		return alrt_time_for_not_reg_lab_spec;
	}
	//IN061892 end
	String select_all_spec_rec_collect_yn = ""; // ML-MMOH-CRF-0540 [IN061888] - Start
	public String getSelect_all_spec_rec_collect_yn() {
		return select_all_spec_rec_collect_yn;
	}
	public void setSelect_all_spec_rec_collect_yn(String select_all_spec_rec_collect_yn) {
		this.select_all_spec_rec_collect_yn = select_all_spec_rec_collect_yn;
	} // ML-MMOH-CRF-0540 [IN061888] - End
	//IN071618 Start.
	String splitUnbilledOrders ="";
	
	public String getSplitUnbilledOrders() {
		return splitUnbilledOrders;
	}
	public void setSplitUnbilledOrders(String splitUnbilledOrders) {
		this.splitUnbilledOrders = splitUnbilledOrders;
	}
	//IN071618 End.
	//IN043081 Starts
	String limit_catalog_to_loc ="";
	public String getLimit_catalog_to_loc() {
		return limit_catalog_to_loc;
	}
	public void setLimit_catalog_to_loc(String limit_catalog_to_loc) {
		this.limit_catalog_to_loc = limit_catalog_to_loc;
	}
	//IN043081 Ends
	//IN066119 Starts
	String hide_specimentype ="";
	public String getHideSpecimenType() {
		return hide_specimentype;
	}
	public void setHideSpecimenType(String hide_specimentype_val) {
		this.hide_specimentype = hide_specimentype_val;
	}
	
	String hide_reportingprac ="";
	public String getHideReportingPrac() {
		return hide_reportingprac;
	}
	public void setHideReportingPrac(String hide_reportingprac_val) {
		this.hide_reportingprac = hide_reportingprac_val;
	}
	//IN066119 Ends
	// 37018 begin
	String applyOrderingRulesByPractitionerType ="";
	
	public String getApplyOrderingRulesByPractitionerType() {
		return applyOrderingRulesByPractitionerType;
	}
	public void setApplyOrderingRulesByPractitionerType(String applyOrderingRulesByPractitionerType) {
		this.applyOrderingRulesByPractitionerType = applyOrderingRulesByPractitionerType;
	}
	// 37018 end
	StringBuffer traceVals = new StringBuffer();
	public String tempChk = "jj : ";

  
	public void setFacility(String facility){
		this.facility = facility;
	}
	//////////////
	public void  setPRINT_REFU_AT_DEST_LOCN(String PRINT_REFU_AT_DEST_LOCN)
	{
		this.PRINT_REFU_AT_DEST_LOCN = PRINT_REFU_AT_DEST_LOCN;
	}
	//public void  setPRINT_REFERRAL_AT_DEST_LOCN(String PRINT_REFERRAL_AT_DEST_LOCN)
	//{
	//	this.PRINT_REFERRAL_AT_DEST_LOCN = PRINT_REFERRAL_AT_DEST_LOCN;
	//}


	/////////////
	public void setConsentFormPrnt(String consenet_form_prnt){
		this.consenet_form_prnt = consenet_form_prnt;
	}
	public void setConsentFormSource(String consenet_form_source){
	    this.consenet_form_source=consenet_form_source;
	}
	public void setrefusalFormDestination(String refusal_destination){
		this.refusal_destination=refusal_destination;
	}
	public void setrefusalFormsource(String refusal_source){
		this.refusal_source=refusal_source;
	}
	public void setreferralFormDestination(String referral_destination){
		this.referral_destination=referral_destination;
	}
	public void setreferralFormsource(String referral_source){
		this.referral_source=referral_source;
	}	
	public void setPrintAtDestination(String prnt_at_destination){
		this.prnt_at_destination = prnt_at_destination;
	}
	public void setPrintAtSource(String prnt_at_source){
		this.prnt_at_source = prnt_at_source;
	}
	public void setPrintAtDept(String prnt_at_dept){
		this.prnt_at_dept = prnt_at_dept;
	}
	public void setOtherLocPrint(String oth_loc_print){
		this.oth_loc_print = oth_loc_print;
	}
	public void setOtherSpecificLocName(String oth_specific_loc_name){
		this.oth_specific_loc_name = oth_specific_loc_name;
	}
	public void setDischargePatPrint(String dischg_pat_prnt){
		this.dischg_pat_prnt = dischg_pat_prnt;
	}
	public void setDischargeSpecificLocName(String dischg_specific_loc_name){
		this.dischg_specific_loc_name = dischg_specific_loc_name;
	}
	public void setBehindHrs(String behind_hrs){
		this.behind_hrs = behind_hrs;
	}
	public void setAheadHrs(String ahead_hrs){
		this.ahead_hrs = ahead_hrs;
	}
	public void setReactiveHrs(String reactivate_hrs){
		this.reactivate_hrs = reactivate_hrs;
	}
	public void setDiscontinuedHrs(String discontinued_hrs){
		this.discontinued_hrs = discontinued_hrs;
	}
	public void setExpiredHrs(String expired_hrs){
		this.expired_hrs = expired_hrs;
	}
	public void setIntfBilling(String intf_to_billing){
		this.intf_to_billing = intf_to_billing;
	}
	public void setIntfBillingDays(String intf_to_billing_days){
		this.intf_to_billing_days = intf_to_billing_days;
	}
    public void setSpecimenBehindHrs(String specimen_behind_hrs){
		this.specimen_behind_hrs = specimen_behind_hrs;
	}
	public void setSpecimenAheadHrs(String specimen_ahead_hrs){
		this.specimen_ahead_hrs = specimen_ahead_hrs;
	}
	 public void setExtOrdReferralCode(String ext_order_referral_code)
	{
		this.ext_order_referral_code = ext_order_referral_code;
	}
	/*
		Added by Uma, for the CRF 640-OR

		These getter and setter method give information about
		Future Order Billing linking at Facility level
	*/
	public void setBilledButNotReceiptedYn(String BilledButNotReceipted)
	{
		if(BilledButNotReceipted==null||BilledButNotReceipted.equals(""))BilledButNotReceipted="N";
		this.BilledButNotReceipted = BilledButNotReceipted;
	}
	public void setPostedToFolioButNotBilledRcptdYn(String PostedToFolioButNotBilledReceipted)
	{
		if(PostedToFolioButNotBilledReceipted==null||PostedToFolioButNotBilledReceipted.equals(""))PostedToFolioButNotBilledReceipted="N";
		this.PostedToFolioButNotBilledReceipted = PostedToFolioButNotBilledReceipted;
	}
	public String getBilledButNotReceiptedYn()
	{
		return BilledButNotReceipted;		
	}
	public String getPostedToFolioButNotBilledRcptdYn()
	{
		return PostedToFolioButNotBilledReceipted;		
	}
	public void setMaxAllowedPeriod(String MaxAllowedPeriod)
	{
		if(MaxAllowedPeriod==null||MaxAllowedPeriod.equals(""))MaxAllowedPeriod="";
		this.MaxAllowedPeriod = MaxAllowedPeriod;
	}
	public String getMaxAllowedPeriod()
	{
		return MaxAllowedPeriod;		
	}
	/*
		Added by Uma, for the SRR20056 -CRF 195-OR on 10/12/2009	
	*/
	public void setDefRefundOptDiscOrder(String DefRefundOptDiscOrder)
	{
		if(DefRefundOptDiscOrder==null||DefRefundOptDiscOrder.equals(""))DefRefundOptDiscOrder="";
		this.DefRefundOptDiscOrder = DefRefundOptDiscOrder;
	}
	public void setDispBillDetail(String disp_bl_dtl_yn) // added for IN035929 - START
	{
		if(disp_bl_dtl_yn==null||disp_bl_dtl_yn.equals(""))disp_bl_dtl_yn="N";
		this.disp_bl_dtl_yn = disp_bl_dtl_yn;
	}
	public String getDispBillDetail(){
		return disp_bl_dtl_yn;
	}
	// IN035929 - END
	//added for IN047204 - Start
	public void setDispDmsExtLink(String dms_ext_link_yn) 
	{
		this.dms_ext_link_yn = dms_ext_link_yn;
	}
	public String getDispDmsExtLink(){
		return dms_ext_link_yn;
	}
	//added for IN047204 - End
	//IN052649 - Start.
	public void setOrderingSpecialityCopyPreviousOrder(String OrderingSpecialityCopyPreviousOrder) 
	{
		this.OrderingSpecialityCopyPreviousOrder = OrderingSpecialityCopyPreviousOrder;
	}
	public String getOrderingSpecialityCopyPreviousOrder(){
		return OrderingSpecialityCopyPreviousOrder;
	}	
	public void setDefaultPeriodCopyPreviousOrders(String DefaultPeriodCopyPreviousOrders)
	{
		if(DefaultPeriodCopyPreviousOrders==null||DefaultPeriodCopyPreviousOrders.equals(""))DefaultPeriodCopyPreviousOrders="";
		this.DefaultPeriodCopyPreviousOrders = DefaultPeriodCopyPreviousOrders;
	}
	public String getDefaultPeriodCopyPreviousOrders()
	{
		return DefaultPeriodCopyPreviousOrders;		
	}
	//IN052649 - End.
	public String getDefRefundOptDiscOrder()
	{
		return DefRefundOptDiscOrder;		
	}
	/*
		Ends here.
	*/
	//////////////////

		/*
		Added by Arvind Singh Pal for the ICN 	
	*/
	public void setInvokeSetScreenForExtOrders(String InvokeSetScreenForExtOrders)
	{
		if(InvokeSetScreenForExtOrders==null||InvokeSetScreenForExtOrders.equals(""))InvokeSetScreenForExtOrders="";
		this.InvokeSetScreenForExtOrders = InvokeSetScreenForExtOrders;
	}
	public String getInvokeSetScreenForExtOrders()
	{
		return InvokeSetScreenForExtOrders;		
	}

	public void setInvokePrintRepForBilling(String InvokePrintRepForBilling)
	{
		if(InvokePrintRepForBilling==null||InvokePrintRepForBilling.equals(""))InvokePrintRepForBilling="";
		this.InvokePrintRepForBilling = InvokePrintRepForBilling;
	}
	public String getInvokePrintRepForBilling()
	{
		return InvokePrintRepForBilling;		
	}

	public void setInvokeSetScreenForOPOrders(String InvokeSetScreenForOPOrders)
	{
		if(InvokeSetScreenForOPOrders==null||InvokeSetScreenForOPOrders.equals(""))InvokeSetScreenForOPOrders="";
		this.InvokeSetScreenForOPOrders = InvokeSetScreenForOPOrders;
	}
	public String getInvokeSetScreenForOPOrders()
	{
		return InvokeSetScreenForOPOrders;		
	}

	public void setInvokeSetScreenForEMOrders(String InvokeSetScreenForEMOrders)
	{
		if(InvokeSetScreenForEMOrders==null||InvokeSetScreenForEMOrders.equals(""))InvokeSetScreenForEMOrders="";
		this.InvokeSetScreenForEMOrders = InvokeSetScreenForEMOrders;
	}
	public String getInvokeSetScreenForEMOrders()
	{
		return InvokeSetScreenForEMOrders;		
	}

	public String getPRINT_REFU_AT_DEST_LOCN(){
	return PRINT_REFU_AT_DEST_LOCN;
	}
	//public String getPRINT_REFERRAL_AT_DEST_LOCN(){
	//return PRINT_REFERRAL_AT_DEST_LOCN;
	//}
	//////////////////////
	public String getFacility(){
		return facility;
	}
	public String getConsentFormPrnt(){
		return consenet_form_prnt;
	}
	public String getConsentFormSource(){
	    return consenet_form_source;
	}
	public String getrefusalFormDestination(){
		return refusal_destination;
	}
	public String getrefusalFormsource(){
		return refusal_source;
	}
	public String getreferralFormDestination(){
		return referral_destination;
	}
	public String getreferralFormsource(){
		return referral_source;
	}	
	public String getPrintAtDestination(){
		return prnt_at_destination;
	}
	public String getPrintAtSource(){
		return prnt_at_source;
	}
	public String getPrintAtDept(){
		return prnt_at_dept;
	}
	public String getOtherLocPrint(){
		return oth_loc_print;
	}
	public String getOtherSpecificLocName(){
		return oth_specific_loc_name;
	}
	public String getDischargePatPrint(){
		return dischg_pat_prnt;
	}
	public String getDischargeSpecificLocName(){
		return dischg_specific_loc_name;
	}
	public String getBehindHrs(){
		return behind_hrs;
	}
	public String getAheadHrs(){
		return ahead_hrs;
	}
	public String getReactiveHrs(){
		return reactivate_hrs;
	}
	public String getExpiredHrs(){
		return expired_hrs;
	}
	public String getDiscontinuedHrs(){
		return discontinued_hrs;
	}
	public String getIntfBilling(){
		return intf_to_billing;
	}
	public String getIntfBillingDays(){
		return intf_to_billing_days;
	}
	public String getSpecimenBehindHrs(){
		return specimen_behind_hrs;
	}
	public String getSpecimenAheadHrs(){
		return specimen_ahead_hrs;
	}
	public String getExtOrdReferal_code(){
		return ext_order_referral_code;
	}


	public int checkForMode(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		int record = 0;
		try {
			connection = getConnection() ;

			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_SELECT") ) ;
			pstmt.setString(1, facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
					 record = 1;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}


/**
	@return		:	ArrayList
*/

	public ArrayList getOtherLocationPrint (String facility_ids) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINT") ) ;
			pstmt.setString(1,facility_ids);
			pstmt.setString(2,facility_ids);
			resultSet = pstmt.executeQuery() ;
			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "location_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}
/*Added By Siva Kumr for Location Type Enhancements - 28/8/2003*/
	public ArrayList getOtherLocationPrint (String facility_ids,String locType) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINT") ) ;
			//pstmt.setString(1,facility_ids);
			//pstmt.setString(2,facility_ids);
            if (locType != null && locType.equals("C")) {
                pstmt = connection.prepareStatement(
                    OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINTC")) ;
                pstmt.setString(1,facility_ids);
            }
            else if (locType != null && locType.equals("N")) {
                pstmt = connection.prepareStatement(
                    OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINTN")) ;
                pstmt.setString(1,facility_ids);
            }
            else {
                pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINT")) ;
                pstmt.setString(1,facility_ids);
                pstmt.setString(2,facility_ids);
            }

			resultSet = pstmt.executeQuery() ;
			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[3];
				record[0] = resultSet.getString( "location_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;
                record[2] = resultSet.getString("Locn_Type");
                
				OrderCat.add(record) ;
                
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}
/*End of Addition by Siva Kumar - 29/8/2003
///////////////////////////////////////////////////////////////////////////
/**
	@return		:	ArrayList
*/

	public ArrayList getDischgPatientPrint (String facility_ids) throws Exception {

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_DISCHG_PAT_PRINT") ) ;
			pstmt.setString(1, facility_ids);
			resultSet = pstmt.executeQuery() ;

			String[] record=null;

			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "location_code" )  ;
				record[1] = resultSet.getString( "location_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}

//////////////////////////////////////////

	public String[] getValues(String facility_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		//String[] allValues = new String[34]; commented for 35929
		//String[] allValues = new String[35]; // modified for 35929
		//String[] allValues = new String[36]; // commented for IN047204
		//String[] allValues = new String[37]; // modified for IN047204
		//String[] allValues = new String[39]; // modified for IN052649
		//String[] allValues = new String[40]; // modified for ML-MMOH-CRF-0540 [IN061888]
		//String[] allValues = new String[41];//IN061892//Commented for IN066119
		//String[] allValues = new String[43];//modified for IN066119
		//String[] allValues = new String[44];//modified for IN071618
		String[] allValues = new String[45];//modified for 37018
		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_SELECT") ) ;
			pstmt.setString(1, facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				allValues[0] = resultSet.getString("operating_facility_id");
				allValues[1] = resultSet.getString("print_cons_yn");
				allValues[2] = resultSet.getString("print_ord_at_dest_yn");
				allValues[3] = resultSet.getString("print_ord_at_src_yn");
				allValues[4] = resultSet.getString("print_res_at_dept_yn");
				allValues[5] = resultSet.getString("print_res_at_othloc");
				allValues[6] = resultSet.getString("othloc_queue_name");
				allValues[7] = resultSet.getString("print_res_for_disch_pat");
				allValues[8] = resultSet.getString("disch_pat_queue_name");
				allValues[9] = resultSet.getString("single_cont_renew_hrs_behind");
				allValues[10] = resultSet.getString("single_cont_renew_hrs_ahead");
				allValues[11] = resultSet.getString("single_cont_react_hrs_ahead");
				allValues[12] = resultSet.getString("single_cont_exp_grace_hrs");
				allValues[13] = resultSet.getString("single_cont_disc_grace_hrs");
				allValues[14] = resultSet.getString("bl_module_yn");
				allValues[15] = resultSet.getString("no_of_days_ahead_to_bill");
				allValues[16] = resultSet.getString("specimen_collect_hrs_behind");
				allValues[17] = resultSet.getString("specimen_collect_hrs_ahead");
			    allValues[18]=  resultSet.getString("print_cons_at_src_yn");
				allValues[19]=  resultSet.getString("print_refu_at_dest_yn");
				allValues[20]=  resultSet.getString("print_refu_at_src_yn");
				allValues[21]=  resultSet.getString("PRINT_REFU_AT_DEST_LOCN");				
				allValues[22]=  resultSet.getString("print_referral_at_dest_yn");
				allValues[23]=  resultSet.getString("print_referral_at_src_yn");
				allValues[24]=  resultSet.getString("ext_order_referral_code");
				allValues[25]=  resultSet.getString("ext_order_referral_desc");
				allValues[26]=  resultSet.getString("billposted_billed_yn");
				allValues[27]=  resultSet.getString("billed_receipted_yn");
				allValues[28]=  resultSet.getString("max_allowed_future_day_link");
				allValues[29]=  resultSet.getString("def_refund_opt_disc_order");
				allValues[30]=  resultSet.getString("inv_stlmt_scr_ext_ord_yn");
				allValues[31]=  resultSet.getString("print_billing_report_yn");
				allValues[32]=  resultSet.getString("inv_stlmt_scr_op_ord_yn");
				allValues[33]=  resultSet.getString("inv_stlmt_scr_em_ord_yn");
				allValues[34]=  resultSet.getString("disp_bl_dtl_yn"); // added for 35929 by LK
				allValues[35]=  resultSet.getString("LIMIT_CATALOG_TO_LOCN");//IN043081
				allValues[36]=  resultSet.getString("dms_ext_link_yn");//IN047204
				allValues[37]=  resultSet.getString("ord_splty_type_ind");//IN052649
				allValues[38]=  resultSet.getString("copy_prev_ord_duration");//IN052649
				allValues[39]=  resultSet.getString("select_all_spec_rec_collect_yn"); // ML-MMOH-CRF-0540 [IN061888]
				allValues[40]=  resultSet.getString("alrt_time_for_not_reg_lab_spec"); // ML-MMOH-CRF-0544 [IN061892]
				allValues[41]=  resultSet.getString("HIDE_SPECIMENTYPE"); // [IN066119]
				allValues[42]=  resultSet.getString("HIDE_REPORTINGPRAC"); // [IN066119]
				allValues[43]=  resultSet.getString("split_unbilled_order_yn"); // [IN071618]
				allValues[44]=  resultSet.getString("rest_dept_ord_copyprev_yn"); // 37018
				//allValues[24]=  resultSet.getString("PRINT_REFERRAL_AT_DEST_LOCN");
			}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return allValues;
	}

	public String getFacilityName(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String record = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_NAME")) ;
			pstmt.setString(1, facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 record = resultSet.getString("facility_name");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}

	public String checkBillingInstalled() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String record = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN")) ;
			pstmt.setString(1,"BL");
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 record = resultSet.getString("install_yn");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}

	public String checkBillingInstalled(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String record = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN")) ;
			pstmt.setString(1,"BL");
			pstmt.setString(2,facility_id);

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 record = resultSet.getString("operational_yn");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}


	public HashMap insert()
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;

	    try{
		insertData.add(facility);
		insertData.add(consenet_form_prnt	);
		insertData.add(prnt_at_destination	);
		insertData.add(prnt_at_source);
		insertData.add(prnt_at_dept) ;
		insertData.add(oth_loc_print) ;
		insertData.add(oth_specific_loc_name	) ;
		insertData.add(dischg_pat_prnt) ;
		insertData.add(dischg_specific_loc_name	);
		insertData.add(behind_hrs);
		insertData.add(ahead_hrs);
		insertData.add(reactivate_hrs);
		insertData.add(expired_hrs) ;
		insertData.add(discontinued_hrs) ;
		insertData.add(intf_to_billing) ;
		//System.out.println("intf_to_billing="+intf_to_billing);
		insertData.add(intf_to_billing_days	) ;
		insertData.add(login_by_id) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(specimen_behind_hrs) ;
		insertData.add(specimen_ahead_hrs) ;
		//insertData.add(specimen_ahead_hrs) ;
		insertData.add(consenet_form_source);
		insertData.add(refusal_destination);
		insertData.add(refusal_source);	
		insertData.add(PRINT_REFU_AT_DEST_LOCN);
		insertData.add(referral_destination);
		insertData.add(referral_source);
		insertData.add(ext_order_referral_code);
		insertData.add(getPostedToFolioButNotBilledRcptdYn());
		insertData.add(getBilledButNotReceiptedYn());
		insertData.add(getMaxAllowedPeriod());
		insertData.add(getDefRefundOptDiscOrder());
		//insertData.add(PRINT_REFERRAL_AT_DEST_LOCN);
		insertData.add(getInvokeSetScreenForExtOrders());
		insertData.add(getInvokePrintRepForBilling());
		insertData.add(getInvokeSetScreenForOPOrders());
		insertData.add(getInvokeSetScreenForEMOrders());
		insertData.add(disp_bl_dtl_yn); // added for IN035929
		insertData.add(limit_catalog_to_loc);//IN043081
		insertData.add(hide_specimentype);//IN066119
		insertData.add(hide_reportingprac);//IN066119
		insertData.add(dms_ext_link_yn); //IN047204
		insertData.add(getOrderingSpecialityCopyPreviousOrder());//IN052649
		insertData.add(getDefaultPeriodCopyPreviousOrders());//IN052649
		insertData.add(getSelect_all_spec_rec_collect_yn());//ML-MMOH-CRF-0540 [IN061888]
		insertData.add(getAlrtTimeForNotRegLabSpec());//// ML-MMOH-CRF-0544 [IN061892]
		insertData.add(getSplitUnbilledOrders());////IN071618
		insertData.add(getApplyOrderingRulesByPractitionerType());//37018 and qry updated
		sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_INSERT") );

		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		map.put("traceVal", tabData.toString());
		tempChk = tabData.toString();
		//System.err.println("TabData in Param for Facility @@@@@@ " + tabData);
		return getResult(tabData,sqlMap) ;
		}catch(Exception e){
			tempChk += e;
		return null;
		}

		//return map;


	}

public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList modifyData = new ArrayList() ;

		modifyData.add(consenet_form_prnt	);
		modifyData.add(prnt_at_destination	);
		modifyData.add(prnt_at_source);
		modifyData.add(prnt_at_dept) ;
		modifyData.add(oth_loc_print) ;
		modifyData.add(oth_specific_loc_name	) ;
		modifyData.add(dischg_pat_prnt) ;
		modifyData.add(dischg_specific_loc_name	);
		modifyData.add(behind_hrs);
		modifyData.add(ahead_hrs);
		modifyData.add(reactivate_hrs);
		modifyData.add(expired_hrs) ;
		modifyData.add(discontinued_hrs) ;
		modifyData.add(intf_to_billing) ;
		//System.out.println("intf_to_billing="+intf_to_billing);
		modifyData.add(intf_to_billing_days	) ;
		modifyData.add(login_by_id ) ;
		modifyData.add(login_at_ws_no ) ;
		modifyData.add(login_facility_id ) ;
		modifyData.add(specimen_behind_hrs ) ;
		modifyData.add(specimen_ahead_hrs ) ;
		modifyData.add(consenet_form_source);
		modifyData.add(refusal_destination);
		modifyData.add(refusal_source);
		modifyData.add(PRINT_REFU_AT_DEST_LOCN);
		modifyData.add(referral_destination);
		modifyData.add(referral_source);		
		//modifyData.add(PRINT_REFERRAL_AT_DEST_LOCN);
		modifyData.add(ext_order_referral_code);
		modifyData.add(getPostedToFolioButNotBilledRcptdYn());
		modifyData.add(getBilledButNotReceiptedYn());
		modifyData.add(getMaxAllowedPeriod());
		modifyData.add(getDefRefundOptDiscOrder());		
		modifyData.add(getInvokeSetScreenForExtOrders());
		modifyData.add(getInvokePrintRepForBilling());
		modifyData.add(getInvokeSetScreenForOPOrders());
		modifyData.add(getInvokeSetScreenForEMOrders());
		modifyData.add(disp_bl_dtl_yn); // added for IN035929
		modifyData.add(limit_catalog_to_loc);//IN043081
		modifyData.add(hide_specimentype);//IN066119 
		modifyData.add(hide_reportingprac);//IN066119
		modifyData.add(dms_ext_link_yn);//IN047204
		modifyData.add(getOrderingSpecialityCopyPreviousOrder()); //IN052649
		modifyData.add(getDefaultPeriodCopyPreviousOrders());
		modifyData.add(getSelect_all_spec_rec_collect_yn());//ML-MMOH-CRF-0540 [IN061888]
		modifyData.add(getAlrtTimeForNotRegLabSpec());//ML-MMOH-CRF-0544 [IN061892]
		modifyData.add(getSplitUnbilledOrders());// IN071618
		modifyData.add(getApplyOrderingRulesByPractitionerType());//37018
		modifyData.add(facility);

		try{
		    sqlMap.put("ModifySQL",OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_UPDATE") );
		}catch(Exception e){e.printStackTrace();
		}

		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
		map.put("traceVal", tabData.toString());
		//System.err.println("TabData in Param for Facility @@@@@@ " + tabData);
		return getResult(tabData,sqlMap) ;
		//return map;


	}


/**********This Method  Actually Calls the EJB's Method ********************/
private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
		HashMap map  = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;

		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;
			*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    	    Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		    Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlMap.getClass();

			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				// conversions map = remote.insert(tabData, sqlMap ) ;
			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				// conversions map = remote.modify(tabData, sqlMap ) ;
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
			argArray		= null;
			paramArray	= null;

			//String message = (String)map.get("msgid");
			//map.put("message",message);

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
				map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
			}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
				map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
			}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

		  return map;

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	  }

 }//End of Method
public void setAll( Hashtable recordSet ) 
{

	if(recordSet.containsKey("refusal_text"))
	{
			setPRINT_REFU_AT_DEST_LOCN((String)recordSet.get( "refusal_text" ));
	}
		//if(recordSet.containsKey("referral_text")){
		//	setPRINT_REFERRAL_AT_DEST_LOCN((String)recordSet.get( "referral_text" ));
		//}
		if(recordSet.containsKey("facility"))
		{
			setFacility((String)recordSet.get( "facility" ));
		}
		if(recordSet.containsKey("consenet_form_prnt")){
			String tmp_consenet_form_prnt_val = (String)recordSet.get("consenet_form_prnt");
			if( !(tmp_consenet_form_prnt_val.equals("")))
				setConsentFormPrnt("Y") ;
			else
				setConsentFormPrnt("N") ;
		}
		if(recordSet.containsKey("consenet_form_source")){
			String tmp_consenet_form_source_val=(String)recordSet.get("consenet_form_source");
			if(!(tmp_consenet_form_source_val.equals("")))
			setConsentFormSource("Y");
			else
			setConsentFormSource("N");
		}
		if(recordSet.containsKey("refusal_destination")){
			String tmp_refusal_destination_val=(String)recordSet.get("refusal_destination");
			if(!(tmp_refusal_destination_val.equals("")))
			setrefusalFormDestination("Y");
			else
			setrefusalFormDestination("N");
			}
		if(recordSet.containsKey("refusal_source")){
			String tmp_refusal_source_val=(String)recordSet.get(	"refusal_source");
			if(!(tmp_refusal_source_val.equals("")))
			setrefusalFormsource("Y");
			else
			setrefusalFormsource("N");
			}
		if(recordSet.containsKey("referral_destination")){
			String tmp_referral_destination_val=(String)recordSet.get("referral_destination");
			if(!(tmp_referral_destination_val.equals("")))
			setreferralFormDestination("Y");
			else
			setreferralFormDestination("N");
			}
		if(recordSet.containsKey("referral_source")){
			String tmp_referral_source_val=(String)recordSet.get(	"referral_source");			
			if(!(tmp_referral_source_val.equals("")))			
			setreferralFormsource("Y");			
			else			
			setreferralFormsource("N");			
			}
		if(recordSet.containsKey("prnt_at_destination")){
			String tmp_prnt_at_destination_val = (String)recordSet.get("prnt_at_destination");
			if( !(tmp_prnt_at_destination_val.equals("")))
				setPrintAtDestination("Y") ;
			else
				setPrintAtDestination("N") ;
		}
		if(recordSet.containsKey("prnt_at_source")){
			String tmp_prnt_at_source_val = (String)recordSet.get("prnt_at_source");
			if( !(tmp_prnt_at_source_val.equals("")))
				setPrintAtSource("Y") ;
			else
				setPrintAtSource("N") ;
		}
		if(recordSet.containsKey("prnt_at_dept")){
			String tmp_prnt_at_dept_val = (String)recordSet.get("prnt_at_dept");
			if( !(tmp_prnt_at_dept_val.equals("")))
				setPrintAtDept("Y") ;
			else
				setPrintAtDept("N") ;
		}

		if(recordSet.containsKey("oth_loc_print")){
			setOtherLocPrint((String)recordSet.get( "oth_loc_print" ));
		}
		if(recordSet.containsKey("oth_specific_loc_name")){
			setOtherSpecificLocName((String)recordSet.get( "oth_specific_loc_name" ));
		}
		if(recordSet.containsKey("dischg_pat_prnt")){
			setDischargePatPrint((String)recordSet.get( "dischg_pat_prnt" ));
		}
		if(recordSet.containsKey("dischg_specific_loc_name")){
			setDischargeSpecificLocName((String)recordSet.get( "dischg_specific_loc_name" ));
		}

		if(recordSet.containsKey("behind_hrs")){
			setBehindHrs((String)recordSet.get( "behind_hrs" ));
		}
		if(recordSet.containsKey("ahead_hrs")){
			setAheadHrs((String)recordSet.get( "ahead_hrs" ));
		}
		if(recordSet.containsKey("reactivate_hrs")){
			setReactiveHrs((String)recordSet.get( "reactivate_hrs" ));
		}
		if(recordSet.containsKey("expired_hrs")){
			setExpiredHrs((String)recordSet.get( "expired_hrs" ));
		}
		if(recordSet.containsKey("discontinued_hrs")){
			setDiscontinuedHrs((String)recordSet.get( "discontinued_hrs" ));
		}
		if(recordSet.containsKey("intf_to_billing")){
			String tmp_intf_to_billing_val = (String)recordSet.get("intf_to_billing");
			
			//if((tmp_intf_to_billing_val != null) && (tmp_intf_to_billing_val.equals("Y")) )//|| tmp_intf_to_billing_val != null
			if(!(tmp_intf_to_billing_val.equals("")) )//|| tmp_intf_to_billing_val != null
				setIntfBilling("Y") ;
			else
				setIntfBilling("N") ;
		}
		if(recordSet.containsKey("intf_to_billing_days")){
			setIntfBillingDays((String)recordSet.get( "intf_to_billing_days" ));
		}

		if(recordSet.containsKey("specimen_behind_hrs")){
			setSpecimenBehindHrs((String)recordSet.get( "specimen_behind_hrs" ));
		}
		if(recordSet.containsKey("ahead_hrs")){
			setSpecimenAheadHrs((String)recordSet.get( "specimen_ahead_hrs" ));
		}
		if(recordSet.containsKey("ext_order_referral_code")){
			setExtOrdReferralCode((String)recordSet.get( "ext_order_referral_code" ));
		}
		/*Added by Uma on 8/27/2009 for PMG20089 -CRF 640*/
		if(recordSet.containsKey("PostedToFolioButNotBilledReceipted"))
		{
			setPostedToFolioButNotBilledRcptdYn((String)recordSet.get( "PostedToFolioButNotBilledReceipted" ));
		}
		if(recordSet.containsKey("BilledButNotReceipted"))
		{
			setBilledButNotReceiptedYn((String)recordSet.get( "BilledButNotReceipted" ));
		}if(recordSet.containsKey("MaxAllowedPeriod"))
		{
			setMaxAllowedPeriod((String)recordSet.get( "MaxAllowedPeriod" ));
		}
		/*Added by Uma on 10/12/2009 for SRR20056 -CRF 195*/
		if(recordSet.containsKey("DefRefundOptDiscOrder"))
		{
			setDefRefundOptDiscOrder((String)recordSet.get( "DefRefundOptDiscOrder" ));
		}
		
		/*End Here*/

		if(recordSet.containsKey("InvokeSetScreenForExtOrders"))
		{
			setInvokeSetScreenForExtOrders((String)recordSet.get( "InvokeSetScreenForExtOrders" ));
		}
		if(recordSet.containsKey("InvokePrintRepForBilling"))
		{
			setInvokePrintRepForBilling((String)recordSet.get( "InvokePrintRepForBilling" ));
		}
		if(recordSet.containsKey("InvokeSetScreenForOPOrders"))
		{
			setInvokeSetScreenForOPOrders((String)recordSet.get( "InvokeSetScreenForOPOrders" ));
		}
		if(recordSet.containsKey("InvokeSetScreenForEMOrders"))
		{
			setInvokeSetScreenForEMOrders((String)recordSet.get( "InvokeSetScreenForEMOrders" ));
		}
		 // ML-MMOH-CRF-0544 [IN061892] starts
		if(recordSet.containsKey("alrt_time_for_not_reg_lab_spec"))
		{
			setAlrtTimeForNotRegLabSpec((String)recordSet.get( "alrt_time_for_not_reg_lab_spec" ));
		}else
		{
			setAlrtTimeForNotRegLabSpec("60");//IN066129
		}
		// ML-MMOH-CRF-0544 [IN061892] ends
		// IN052649 Start
		if(recordSet.containsKey("OrderingSpecialityCopyPreviousOrder"))
		{
			setOrderingSpecialityCopyPreviousOrder((String)recordSet.get( "OrderingSpecialityCopyPreviousOrder" ));
		}
		if(recordSet.containsKey("DefaultPeriodCopyPreviousOrders"))
		{
			setDefaultPeriodCopyPreviousOrders((String)recordSet.get( "DefaultPeriodCopyPreviousOrders" ));
		}
		// IN052649 End
		// added for IN035929 - START
		if(recordSet.containsKey("disp_bill_info")){
			String tmp_disp_bill_info_val = (String)recordSet.get("disp_bill_info");
			if((tmp_disp_bill_info_val.equals("")) ||tmp_disp_bill_info_val == null )
				setDispBillDetail("N") ;
			else
				setDispBillDetail((String)recordSet.get("disp_bill_info"));
		}
		// IN035929 - END 
		//IN043081 Starts
		if(recordSet.containsKey("limit_catalog_to_loc")){
			String limit_catalog_to_loc = (String)recordSet.get("limit_catalog_to_loc");
			if((limit_catalog_to_loc.equals("")) ||limit_catalog_to_loc == null )
				setLimit_catalog_to_loc("N") ;
			else
				setLimit_catalog_to_loc((String)recordSet.get("limit_catalog_to_loc"));
		}
		//IN043081 Ends
		//IN066119 Starts
				if(recordSet.containsKey("hide_specimentype")){ 
					String hide_specimen_type = (String)recordSet.get("hide_specimentype");
					if((hide_specimen_type.equals("")) ||hide_specimen_type == null )
						setHideSpecimenType("N") ;
					else
						setHideSpecimenType((String)recordSet.get("hide_specimentype"));
				}
				if(recordSet.containsKey("hide_reportingprac")){
					String hide_reporting_prac = (String)recordSet.get("hide_reportingprac");
					if((hide_reporting_prac.equals("")) ||hide_reporting_prac == null )
						setHideReportingPrac("N") ;
					else
						setHideReportingPrac((String)recordSet.get("hide_reportingprac")); 
				}
		//IN066119 Ends
		// 37018 begin
				if(recordSet.containsKey("applyOrderingRulesByPractitionerType")){
					String applyOrderingRulesByPractitioner_Type = (String)recordSet.get("applyOrderingRulesByPractitionerType"); 
					if((applyOrderingRulesByPractitioner_Type.equals("")) ||applyOrderingRulesByPractitioner_Type == null )
						setApplyOrderingRulesByPractitionerType("N") ;
					else
						setApplyOrderingRulesByPractitionerType((String)recordSet.get("applyOrderingRulesByPractitionerType")); 
				}
				// 37018 end
		//IN047204 - Starts
		if(recordSet.containsKey("dms_ext_link_yn")){
			String tmp_dms_ext_link_yn = (String)recordSet.get("dms_ext_link_yn");
			if((tmp_dms_ext_link_yn.equals("")) ||tmp_dms_ext_link_yn == null )
				setDispDmsExtLink("N") ;
			else
				setDispDmsExtLink((String)recordSet.get("dms_ext_link_yn"));
		}
		//IN047204 - End
		if(recordSet.containsKey("select_all_for_rec_collect_yn")) {
			String tmp_select_all_spec_rec_collect_yn = (String)recordSet.get("select_all_for_rec_collect_yn");
			if((tmp_select_all_spec_rec_collect_yn.equals("")) ||tmp_select_all_spec_rec_collect_yn == null ) 
				setSelect_all_spec_rec_collect_yn("N");
			else
				setSelect_all_spec_rec_collect_yn((String)recordSet.get("select_all_for_rec_collect_yn"));
		}
		//IN071618 Start.
		if(recordSet.containsKey("splitUnbilledOrders")) {
			String tmpSplitUnbilledOrders = (String)recordSet.get("splitUnbilledOrders");
			if((tmpSplitUnbilledOrders.equals("")) ||tmpSplitUnbilledOrders == null ) 
				setSplitUnbilledOrders("N");
			else
				setSplitUnbilledOrders((String)recordSet.get("splitUnbilledOrders"));
		}else{
			setSplitUnbilledOrders("N");
		}
		//IN071618 End.
	}

	public ArrayList  getPatientClass(Properties properties) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList PatientClass = new ArrayList();  

		try {

				connection		= ConnectionManager.getConnection(properties) ;
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PATIENT_CLASS_LIST") ) ;
				pstmt.setString(1,language_id);
				resultSet = pstmt.executeQuery() ;

				while( resultSet != null && resultSet.next() ) {
						String[] record = new String[2];
						record[0] = resultSet.getString( "patient_class" )  ;
						record[1] = resultSet.getString( "short_desc" )  ;

					PatientClass.add(record) ;
				}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return PatientClass;
	}
}

// insert into or_param_by_facility(OPERATING_FACILITY_ID,PRINT_CONS_YN,PRINT_ORD_AT_DEST_YN,PRINT_ORD_AT_SRC_YN, PRINT_RES_AT_DEPT_YN,PRINT_RES_AT_OTHLOC ,OTHLOC_QUEUE_NAME, PRINT_RES_FOR_DISCH_PAT , DISCH_PAT_QUEUE_NAME , SINGLE_CONT_RENEW_HRS_BEHIND ,SINGLE_CONT_RENEW_HRS_AHEAD , SINGLE_CONT_REACT_HRS_AHEAD,SINGLE_CONT_EXP_GRACE_HRS, SINGLE_CONT_DISC_GRACE_HRS ,BL_MODULE_YN  ,NO_OF_DAYS_AHEAD_TO_BILL,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO ,ADDED_FACILITY_ID ,MODIFIED_BY_ID,MODIFIED_DATE ,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate?,?,?,sysdate?,?)
//public static String OR_PARAM_FOR_FACILITY_UPDATE = "UPDATE or_param_by_facility set print_cons_yn=(?), print_ord_at_dest_yn=(?), print_ord_at_src_yn=(?), print_res_at_dept_yn=(?), print_res_at_othloc =(?), othloc_queue_name=(?), print_res_for_disch_pat =(?), disch_pat_queue_name =(?), single_cont_renew_hrs_behind =(?), single_cont_renew_hrs_ahead =(?), single_cont_react_hrs_ahead=(?), single_cont_exp_grace_hrs=(?), single_cont_disc_grace_hrs=(?), bl_module_yn=(?), no_of_days_ahead_to_bill=(?), modified_by_id=(?), modified_date=sysdate, modified_at_ws_no=(?), modified_facility_id =(?) where operating_facility_id=(?)";

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        Description
------------------------------------------------------------------------------------------------------------------------
?             	100            		?               created
28/10/2011    	IN029395      	Chowminya G     Incident No: IN029395 - <system default preferred surgery date issue> 
03/01/2012	  	IN028417	  	Menaka V	 	The registered lab samples can be discontinued from CA-OR even though
												the discontinuation reasons are not defined for lab module.
01/12/2013		IN038787		Ramesh G		Bru-HIMS-CRF-358	
-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-----------------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L											An Audit Trail for Additional Information Amendment of Order
06/10/2015		IN055737		Karthi L											IN055737 HSA-CRF-0250.1 - Dispatch Slip
21/10/2015	    IN057196		Ramesh G											Recording Of Consent Form
10/06/2016		IN059086		Karthi L											ML-MMOH-CRF-0493 [IN059086]
26/11/2016		IN062319		Karthi L											ML-MMOH-CRF-0508.1 [IN062319] 
28/03/2017		IN063854		Raja S				28/03/2017		Ramesh G		ML-MMOH-SCF-0693 
22/11/2017		IN061890		Kamalakannan G		24/11/2017		Ramesh G		ML-MMOH-CRF-0542 [IN061890]
05/12/2017		IN065925		Kamalakannan G		05/12/2017		Ramesh G		PMG2017-GHL-CRF-0006
18/04/2018      IN064980        Ramya   18/04/2018       Ramesh G 		  ML-MMOH-CRF-0956[IN064980]
08/10/2018	  IN063719		Kamalakannan 	08/10/2018	Ramesh G		GHL-CRF-0419
25/01/2019    IN068673    DineshT           25/01/2019    Ramesh G      ML-MMOH-CRF-1263
15/08/2020	IN071361	Nijitha S	15/08/2020	Ramesh G	AAKH-CRF-0116
28/02/2022      IN27705         Suji Keerthi.G      28/02/2022      Ramesh G        SKR-CRF-0052   
-----------------------------------------------------------------------------------------------------------------------
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


public class OrParameterBean extends eOR.Common.OrAdapter implements java.io.Serializable {

	String order_category = "";
	String ord_type = "";
	String ord_displayVerticalYN = "";   //IN038787
	String pin_by_ord_type= "";
	String co_sign_rule = "";
	String order_hrs = "";
	String ord_privilege = "X";
	String results_hrs = "";
	String update_order = "";
	String fing_prn_auth_order = "N";
	String fing_prn_auth_result = "N";
	String order_future_hrs_ahead="";
	/* Added By kishore kumar N, For the CRF 640-OR.*/
	String lnkFutureOrCrrEcntYn = "N";
	/* Ends here.*/
	/* Added By Uma, For the CRF 641-OR.*/
	String lnkOrderingYn = "N";
	String lnkOrderAuthorisationYn = "N";
	/* Ends here.*/
	/* Added By Uma on 2/1/2010  For the CRF 804-OR IN016226*/
	String restrictCompNoteYn			= "N";
	/* Ends here.*/

	/* Added By Arvind on 4/19/2010  For the CRF 804-OR */
	String periodtoModifycmptResult			= "";
	String modifycompResultBy24hrsYn			= "N";
	/* Ends here.*/
	String prefSurgDate = "";//--[IN029395]
	String ReasonCodeHoldDisYN = "";//IN028417
	//IN049419 - Start
	String auditForAmendReqdYN 	= "";		
	String amendReasonYN 		= "";	
	String amendReasonMandatYN 	= ""; 
	//IN049419 - End
	String allow_specimen_barcode_search_yn = ""; // IN055737 HSA-CRF-0250.1 
	String recConsetWithOrderYN = ""; //IN057196
	StringBuffer traceVals = new StringBuffer();
	String ord_formt_multi_list_mand_yn = ""; // ML-MMOH-CRF-0508.1 [IN062319] - Start
	String can_option_inactive_ord_yn ="N";//IN065925 
	/*IN061890 Starts*/
	String ord_repl_thro_termset_yn = "N"; 
	String Dis_Select_All_Option_yn ="N";//IN064980
	String restrictAE_Encounters_yn = "N";//IN063719
	//IN071361 Starts
	String time_based_rule_yn = "N";
	public String getTime_based_rule_yn() {
		return time_based_rule_yn;
	}
	public void setTime_based_rule_yn(String time_based_rule_yn) {
		this.time_based_rule_yn = time_based_rule_yn;
	}
	//IN071361 Ends
	String pendAuthIncludeSecSpltyYn ="N";//IN068673
	String def_order_status =""; //IN27705
	public String getOrdReplThroTermsetYN() {
		return ord_repl_thro_termset_yn;
	}
	public void setOrdReplThroTermsetYN(String ord_repl_thro_termset_yn) {
		this.ord_repl_thro_termset_yn = ord_repl_thro_termset_yn;
	}
	
	/*IN061890 Ends*/
	/*IN063719 Starts*/
	public String getrestrictAEEncountersYN() {
		return restrictAE_Encounters_yn;
	}
	public void setrestrictAEncountersYN(String restrictAE_Encounters_yn) {
		this.restrictAE_Encounters_yn = restrictAE_Encounters_yn;
	}
	/*IN063719 Ends*/
    //IN27705 Starts
	public String getDefaultOrderStatus() {
		return def_order_status;
	}
	public void setDefaultOrderStatus(String def_order_status) {
		this.def_order_status = def_order_status;
	}
	//IN27705 Ends

	/*IN065925 Starts*/
	public String getCanOptionInactiveOrdYN() {
		return can_option_inactive_ord_yn;
	}
	public void setCanOptionInactiveOrdYN(String can_option_inactive_ord_yn) {
		this.can_option_inactive_ord_yn = can_option_inactive_ord_yn;
	}
	/*IN065925 Ends*/
	/*[IN064980] Starts */
	public String getDisSelectAllOptionYN() {
		return Dis_Select_All_Option_yn;
	}
	public void setDisSelectAllOptionYN(String Dis_Select_All_Option_yn) {
		this.Dis_Select_All_Option_yn = Dis_Select_All_Option_yn;
	}
	/*[IN064980] Ends*/
	public String getOrdFormtMultiListMandYN() {
		return ord_formt_multi_list_mand_yn;
	}
	public void setOrdFormtMultiListMandYN(
			String ord_formt_multi_list_mand_yn) {
		this.ord_formt_multi_list_mand_yn = ord_formt_multi_list_mand_yn;
	}
	 // ML-MMOH-CRF-0508.1 [IN062319] - End
	//ML-MMOH-CRF-0493 [IN059086] - Start
	String auth_ord_priv_rule_only_yn = "";
	public String getAuth_ord_priv_rule_only_yn() {
		return auth_ord_priv_rule_only_yn;
	}
	public void setAuth_ord_priv_rule_only_yn(String auth_ord_priv_rule_only_yn) {
		this.auth_ord_priv_rule_only_yn = auth_ord_priv_rule_only_yn;
	}
	//ML-MMOH-CRF-0493 [IN059086] - End
	public void setOrderCategory(String order_category){
		this.order_category = order_category;
	}
	public void setOrderType(String ord_type){
		this.ord_type = ord_type;
	}
	//IN038787 Start.
	public void setOrderDisplayVerticalYN(String ord_displayVerticalYN){
		this.ord_displayVerticalYN = ord_displayVerticalYN;
	}
	//IN038787 End.
	public void setPinOrderType(String pin_by_ord_type){
		this.pin_by_ord_type = pin_by_ord_type;
	}
	public void setOrderPrivilege(String ord_privilege){
		this.ord_privilege = ord_privilege;
	}
	public void setCosignRule(String co_sign_rule){
		this.co_sign_rule = co_sign_rule;
	}
	public void setOrderHrs(String order_hrs){
		this.order_hrs = order_hrs;
	}
	public void setResultHrs(String results_hrs){
		this.results_hrs = results_hrs;
	}
	public void setUpdateOrder(String update_order){
		this.update_order = update_order;
	}
	public void setFingerPrintAuthOrder(String auth_order)
	{
		if(auth_order.equals("") || auth_order.equals(" "))
			this.fing_prn_auth_order = "N";
		else
			this.fing_prn_auth_order = auth_order;
	}
	public void setFingerPrintAuthResult(String auth_result)
	{
		if(auth_result.equals("") ||auth_result.equals(" "))
			this.fing_prn_auth_result = "N";
		else
			this.fing_prn_auth_result = auth_result;
	}
	public void setOrderFutureHrsAhead(String order_future_hrs_ahead){
		this.order_future_hrs_ahead=order_future_hrs_ahead;
	}

	/*
		Added by Kishore kumar N, for the CRF 640-OR

		These getter and setter method give information about
		Link future order to the current encounter during
		visit registeration/admission applicable based on the value Y/N.
	*/

	public void setlnkFutureOrCrrEcntYn(String linkedYn)
	{
		this.lnkFutureOrCrrEcntYn = linkedYn;
	}

	public String getLnkFutureOrCrrEcntYn()
	{
		return lnkFutureOrCrrEcntYn;
	}
	//IN028417 - Start
	public void setReasonCodeHoldDisYN(String ReasonCodeHoldDisYN)
	{
		this.ReasonCodeHoldDisYN = ReasonCodeHoldDisYN;
		
	}
	public String getReasonCodeHoldDisYN()
	{
		return ReasonCodeHoldDisYN;
	}
	//IN028417 - End

	/*
		Ends here.
	*/
/*
		Added by Uma, for the CRF 641-OR

		These getter and setter method give information about
		Privilege at enterprise level for Ordering and Authorisation
	*/
	public void setLnkOrderingYn(String OrderingYn)
	{
		if(OrderingYn==null||OrderingYn.equals(""))OrderingYn="N";
		this.lnkOrderingYn = OrderingYn;
	}
	public void setLnkOrderAuthorisationYn(String OrderAuthorisationYn)
	{
		if(OrderAuthorisationYn==null||OrderAuthorisationYn.equals(""))OrderAuthorisationYn="N";
		this.lnkOrderAuthorisationYn = OrderAuthorisationYn;
	}
	/*Added by Uma on 2/1/2010 for CRF 804 IN016226*/
	public void setRestrictCompNoteYn(String restrictCompleteNoteYn)
	{
		if(restrictCompleteNoteYn==null||restrictCompleteNoteYn.equals(""))restrictCompleteNoteYn="N";
		this.restrictCompNoteYn = restrictCompleteNoteYn;
	}
	
	/*Ends Here*/

	/*Added by Arvind on 4/19/2010 for CRF 804 */
	
	public void setPeriodtoModifycmptResult(String periodtoModifycmptResult)
	{
		if(periodtoModifycmptResult==null||periodtoModifycmptResult.equals(""))periodtoModifycmptResult="";
		this.periodtoModifycmptResult = periodtoModifycmptResult;
	}
	public void setModifycompResultBy24hrsYn(String modifycompResultBy24hrsYn)
	{
		if(modifycompResultBy24hrsYn==null||modifycompResultBy24hrsYn.equals(""))modifycompResultBy24hrsYn="N";
		this.modifycompResultBy24hrsYn = modifycompResultBy24hrsYn;
	}
	//--[IN029395] - Start
	public void setPrefSurgDate(String prefSurgDate)
	{
		if(prefSurgDate==null||prefSurgDate.equals(""))prefSurgDate= "0";
		this.prefSurgDate = prefSurgDate;
	}
	//--[IN029395] - End

	/*Ends Here*/
	public String getLnkOrderingYn()
	{
		return lnkOrderingYn;		
	}
	public String getLnkOrderAuthorisationYn()
	{
		return lnkOrderAuthorisationYn;		
	}
	/*Added by Uma on 2/1/2010 for CRF 804 IN016226*/
	public String getRestrictCompNoteYn()
	{
		return restrictCompNoteYn;		
	}
	
	/*
		Ends here.
	*/

	/*Added by Arvind on 4/19/2010 for CRF 804 */
	public String getPeriodtoModifycmptResult()
	{
		return periodtoModifycmptResult;		
	}

	public String getModifycompResultBy24hrsYn()
	{
		return modifycompResultBy24hrsYn;		
	}
	
	/*
		Ends here.
	*/	
	//--[IN029395] - Start
	public String getPrefSurgDate()
	{
		return prefSurgDate;		
	}
	//--[IN029395] - End
	public String getFingerPrintAuthOrder()
	{
		return this.fing_prn_auth_order;
	}
	public String getFingerPrintAuthResult()
	{
		return this.fing_prn_auth_result;
	}

	public String getOrderCategory(){
		return order_category;
	}
	public String getOrderType(){
		return ord_type;
	}
	//IN038787 Start.
	public String getOrderDisplayVerticalYN(){
		return ord_displayVerticalYN;
	}
	//IN038787 End.
	public String getPinOrderType(){
		return pin_by_ord_type;
	}
	public String getOrderPrivilege(){
		return ord_privilege;
	}
	public String getCosignRule(){
		return co_sign_rule;
	}
	public String getOrderHrs(){
		return order_hrs;
	}
	public String getResultHrs(){
		return results_hrs;
	}
	public String getUpdateOrder(){
		return update_order;
	}

	public String getOrderFutureHrsAhead(){
		return   order_future_hrs_ahead;
	}
	// IN049419 - Start
	public String getAuditForAmendReqdYN() {
		return auditForAmendReqdYN;
	}
	public void setAuditForAmendReqdYN(String auditForAmendReqdYN) {
		if(auditForAmendReqdYN==null||auditForAmendReqdYN.equals(""))auditForAmendReqdYN="N";
		this.auditForAmendReqdYN = auditForAmendReqdYN;
	}
	public String getAmendReasonYN() {
		return amendReasonYN;
	}
	public void setAmendReasonYN(String amendReasonYN) {
		if(amendReasonYN==null||amendReasonYN.equals(""))amendReasonYN="N";
		this.amendReasonYN = amendReasonYN;
	}
	public String getAmendReasonMandatYN() {
		return amendReasonMandatYN;
	}
	public void setAmendReasonMandatYN(String amendReasonMandatYN) {
		if(amendReasonMandatYN==null||amendReasonMandatYN.equals(""))amendReasonMandatYN="N";
		this.amendReasonMandatYN = amendReasonMandatYN;
	}
	// IN049419 - End
	//IN055737 HSA-CRF-0250.1 - Start
	public String getAllow_specimen_barcode_search_yn() {
		return allow_specimen_barcode_search_yn;
	}
	public void setAllow_specimen_barcode_search_yn(String allow_specimen_barcode_search_yn) {
		if(allow_specimen_barcode_search_yn ==null || allow_specimen_barcode_search_yn.equals("")) allow_specimen_barcode_search_yn = "N";
		this.allow_specimen_barcode_search_yn = allow_specimen_barcode_search_yn;
	}
	//IN055737 HSA-CRF-0250.1 - End
	// IN057196 Start.	
	public String getRecConsetWithOrderYN() {
		return recConsetWithOrderYN;
	}
	public void setRecConsetWithOrderYN(String recConsetWithOrderYN) {
		if(recConsetWithOrderYN ==null || recConsetWithOrderYN.equals("")) recConsetWithOrderYN = "N";
		this.recConsetWithOrderYN = recConsetWithOrderYN;
	}
	//IN057196 End.
	//IN068673, starts
	private void setPendAuthIncludeSecSpltyYn(String pendAuthIncludeSecSpltyYn) {
		this.pendAuthIncludeSecSpltyYn = pendAuthIncludeSecSpltyYn;
	}
	private String getPendAuthIncludeSecSpltyYn() {
		return this.pendAuthIncludeSecSpltyYn;
	}
	//IN068673, ends
	public int checkForMode() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		int record = 0;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAMETER_SELECT_COUNT") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 record = resultSet.getInt("total");
			}
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}

	public ArrayList getUpdateOrders() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList updateOrders = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAMETER_UPDATE_ORDER_SELECT") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[2];
				record[0] = resultSet.getString("order_status_code");
				record[1] = resultSet.getString("short_desc");
				updateOrders.add(record);
			}
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
		}
		return updateOrders;
	}



	public String[] getValues() throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		//String[] allValues = new String[19]; //for Finger Print option //Chowminya//IN028417
		//String[] allValues = new String[22]; // IN049419
		//IN057196 Start.
		//String[] allValues = new String[23]; // IN055737 HSA-CRF-0250.1
		//String[] allValues = new String[24];  
		//String[] allValues = new String[25];  
		//String[] allValues = new String[26]; //ML-MMOH-CRF-0508.1 [IN062319] 
		//String[] allValues = new String[27];//IN061890 **commented for IN065925**
		//String[] allValues = new String[28];//IN065925
		//String[] allValues = new String[29];//IN064980 **commented for IN063719**
		//String[] allValues = new String[30];// IN063719//IN068673
		//IN057196 End.
		//String[] allValues = new String[31];//IN068673//IN071361
		//String[] allValues = new String[32]; //Commented for IN27705
		String[] allValues = new String[33];//IN27705
		
		//String[] allValues = new String[9];
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAMETER_SELECT") ) ;//Modified --[IN029395]
			//IN038787 Strart. 
			///pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD from  or_param");//IN028417
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN from  or_param");//IN038787 - commented for IN049419
			//IN038787 End.
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN from  or_param");//IN049419 - commented IN055737 HSA-CRF-0250.1 
			//IN057196 Start.
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN from  or_param");//modified for IN055737 HSA-CRF-0250.1 
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN from  or_param");//modified for IN055737 HSA-CRF-0250.1
			//IN057196 End.
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN, AUTH_ORD_PRIV_RULE_ONLY_YN from or_param");//modified for ML-MMOH-CRF-0493 [IN059086]
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN, AUTH_ORD_PRIV_RULE_ONLY_YN, ord_formt_multi_list_mand_yn,ORD_REPL_THRO_TERMSET_YN from or_param");//modified for ML-MMOH-CRF-0508.1 [IN062319] , IN061890 *commented for IN065925* 
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN, AUTH_ORD_PRIV_RULE_ONLY_YN, ord_formt_multi_list_mand_yn,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN from or_param");//Modified for IN065925
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN, AUTH_ORD_PRIV_RULE_ONLY_YN, ord_formt_multi_list_mand_yn,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN from or_param");//Ramya/siva *commented for IN063719**
			//pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN, AUTH_ORD_PRIV_RULE_ONLY_YN, ord_formt_multi_list_mand_yn,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN,ORD_REST_OPEN_AE_OP_ENC_YN from or_param");//IN063719//IN068673
			pstmt = connection.prepareStatement("SELECT  presel_order_category_yn  , presel_order_type_code_yn,pin_ident_by_category_yn , cosign_rule , order_backdate_hrs_behind , order_future_hrs_ahead , result_backdate_hrs_behind , dflt_in_process_ord_stat,fing_prn_auth_order,fing_prn_auth_result, allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN, AUTH_ORD_PRIV_RULE_ONLY_YN, ord_formt_multi_list_mand_yn,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN,ORD_REST_OPEN_AE_OP_ENC_YN, PEND_AUTH_INCL_SEC_SPLTY_YN, pract_type_time_based_yn,DFLT_ORDER_STATUS_YN from or_param");//IN063719//IN068673//IN071361//IN27705
			
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				allValues[0] = resultSet.getString("presel_order_category_yn");
				allValues[1] = resultSet.getString("presel_order_type_code_yn");
				//allValues[2] = resultSet.getString("order_privilege_level");
				allValues[2] = resultSet.getString("pin_ident_by_category_yn");
				allValues[3] = resultSet.getString("cosign_rule");
				allValues[4] = resultSet.getString("order_backdate_hrs_behind");
				allValues[5] = resultSet.getString("order_future_hrs_ahead");
				allValues[6] = resultSet.getString("result_backdate_hrs_behind");
				allValues[7] = resultSet.getString("dflt_in_process_ord_stat");
				allValues[8] = resultSet.getString("fing_prn_auth_order");
				allValues[9] = resultSet.getString("fing_prn_auth_result");
				allValues[10] = resultSet.getString("allow_fut_ord_link_at_enc_yn");
				allValues[11] = resultSet.getString("allow_priv_to_order_yn");
				allValues[12] = resultSet.getString("allow_priv_to_authorise_yn");
				/*Added by Uma on 2/1/2010 for IN016226*/
				allValues[13] = resultSet.getString("restrict_auto_complete_note_yn");
				/*Ends Here*/

				/*Added by Arvind on for CRF 804*/
				allValues[14] = resultSet.getString("period_mod_rslt_completed");
				allValues[15] = resultSet.getString("by_24hrs_yn");
				/*Ends Here*/
				allValues[16] = resultSet.getString("HOLD_DISCONTINUE_REASON_YN");//IN028417
				allValues[17] = resultSet.getString("PREF_SURGERY_DATE_AHEAD");//Chowminya
				allValues[18] = resultSet.getString("CTLOG_DISP_VERTICAL_YN");//IN038787
				allValues[19] = resultSet.getString("ORD_AMNDRSN_REQ_YN");//IN049419
				allValues[20] = resultSet.getString("ORD_AMNDRSN_MANDAT_YN");//IN049419
				allValues[21] = resultSet.getString("ORD_AUDIT_REQ_YN");//IN049419
				allValues[22] = resultSet.getString("DISP_SLIP_BARCOD_SRCH_YN");//IN055737 HSA-CRF-0250.1 
				allValues[23] = resultSet.getString("CNSNT_WITH_ORDER_YN");//IN057196
				allValues[24] = resultSet.getString("AUTH_ORD_PRIV_RULE_ONLY_YN");//ML-MMOH-CRF-0493 [IN059086]
				allValues[25] = resultSet.getString("ord_formt_multi_list_mand_yn"); //ML-MMOH-CRF-0508.1 [IN062319] 
				allValues[26] = resultSet.getString("ORD_REPL_THRO_TERMSET_YN");//IN061890
				allValues[27] = resultSet.getString("CAN_OPTION_INACTIVE_ORD_YN");//IN065925
				allValues[28] = resultSet.getString("DIS_SELECT_ALL_OPTION_YN");//[IN064980]
				allValues[29] = resultSet.getString("ORD_REST_OPEN_AE_OP_ENC_YN");//IN063719
				allValues[30] = resultSet.getString("PEND_AUTH_INCL_SEC_SPLTY_YN");//IN068673
				allValues[31] = resultSet.getString("pract_type_time_based_yn");//IN071361
				allValues[32] = resultSet.getString("DFLT_ORDER_STATUS_YN");//IN27705
			}
		} catch ( Exception e )	{			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return allValues;
	}



	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList insertData = new ArrayList() ;

		insertData.add(order_category);
		insertData.add(ord_type);
		//insertData.add(ord_privilege ) ;
		insertData.add(pin_by_ord_type);
		//insertData.add(co_sign_rule ) ;//intenetionaly commented for futurtrer enhancements
		insertData.add(order_future_hrs_ahead ) ;
		insertData.add(order_hrs ) ;
		insertData.add(results_hrs ) ;
		insertData.add(update_order ) ;
		insertData.add(getLnkFutureOrCrrEcntYn()) ;
		insertData.add(getLnkOrderingYn()) ;
		insertData.add(getLnkOrderAuthorisationYn()) ;	
		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(login_by_id ) ;
		insertData.add(login_at_ws_no ) ;
		insertData.add(login_facility_id ) ;
		insertData.add(fing_prn_auth_order);
		insertData.add(fing_prn_auth_result);
		insertData.add(getRestrictCompNoteYn()) ;
		insertData.add(getPeriodtoModifycmptResult()) ;
		insertData.add(getModifycompResultBy24hrsYn()) ;
		insertData.add(getReasonCodeHoldDisYN()) ; //IN028417
		insertData.add(getPrefSurgDate()) ; //--[IN029395]
		insertData.add(ord_displayVerticalYN);  //IN038787
		////IN049419 - Start
		insertData.add(getAmendReasonYN()) ; 
		insertData.add(getAmendReasonMandatYN()) ;
		insertData.add(getAuditForAmendReqdYN());
		//IN049419 - End
		insertData.add(getAllow_specimen_barcode_search_yn()); //IN055737 HSA-CRF-0250.1 
		insertData.add(getRecConsetWithOrderYN());//IN057196
		insertData.add(getAuth_ord_priv_rule_only_yn());//ML-MMOH-CRF-0493 [IN059086]
		insertData.add(getOrdFormtMultiListMandYN()); //ML-MMOH-CRF-0508.1 [IN062319]  
		insertData.add(getOrdReplThroTermsetYN()); // IN061890
		insertData.add(getCanOptionInactiveOrdYN());//IN065925
		insertData.add(getDisSelectAllOptionYN());//[IN064980]
		insertData.add(getrestrictAEEncountersYN());//[IN063719]
		insertData.add(getPendAuthIncludeSecSpltyYn());//IN068673
		insertData.add(getTime_based_rule_yn());	//IN071361
		insertData.add(getDefaultOrderStatus()); //IN27705
		try{
			//sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_OR_PARAMETER_INSERT") ); Modified --[IN029395]
			//IN038787 Start.
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?)" );//IN028417
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?)" );//IN038787 - commented for IN049419
			//IN038787 End.
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?)" );//IN049419 - commented for IN055737 HSA-CRF-0250.1 
			//IN057196 Start.
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?)" );// modified for IN055737 HSA-CRF-0250.1 
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?)" ); //commented for ML-MMOH-CRF-0493 [IN059086]
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?)" ); // modified for ML-MMOH-CRF-0493 [IN059086]
			//IN063854 Start.
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?)" ); // modified for ML-MMOH-CRF-0508.1 [IN062319] 
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN,ORD_FORMT_MULTI_LIST_MAND_YN,ORD_REPL_THRO_TERMSET_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?,?)" ); //IN061890 //commented for IN065925
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN,ORD_FORMT_MULTI_LIST_MAND_YN,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?,?,?)" ); //Modified forIN065925
			//IN063854 End.
			//IN057196 End.
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN,ORD_FORMT_MULTI_LIST_MAND_YN,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?,?,?,?)" ); //Modified for [IN064980] **commented for IN063719**
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN,ORD_FORMT_MULTI_LIST_MAND_YN,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN,ORD_REST_OPEN_AE_OP_ENC_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?,?,?,?,?)" );//IN063719//IN068673
			//sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN,ORD_FORMT_MULTI_LIST_MAND_YN,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN,ORD_REST_OPEN_AE_OP_ENC_YN,PEND_AUTH_INCL_SEC_SPLTY_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?,?,?,?,?,?)" );//IN063719//IN068673	//IN071361 
			sqlMap.put("InsertSQL","INSERT INTO or_param (module_id, presel_order_category_yn, presel_order_type_code_yn,pin_ident_by_category_yn, cosign_rule,order_future_hrs_ahead,order_backdate_hrs_behind,result_backdate_hrs_behind, dflt_in_process_ord_stat,allow_fut_ord_link_at_enc_yn,allow_priv_to_order_yn,allow_priv_to_authorise_yn,added_by_id,added_date, added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,fing_prn_auth_order,fing_prn_auth_result,restrict_auto_complete_note_yn,period_mod_rslt_completed,by_24hrs_yn,HOLD_DISCONTINUE_REASON_YN,PREF_SURGERY_DATE_AHEAD,CTLOG_DISP_VERTICAL_YN, ORD_AMNDRSN_REQ_YN, ORD_AMNDRSN_MANDAT_YN, ORD_AUDIT_REQ_YN, DISP_SLIP_BARCOD_SRCH_YN,CNSNT_WITH_ORDER_YN,AUTH_ORD_PRIV_RULE_ONLY_YN,ORD_FORMT_MULTI_LIST_MAND_YN,ORD_REPL_THRO_TERMSET_YN,CAN_OPTION_INACTIVE_ORD_YN,DIS_SELECT_ALL_OPTION_YN,ORD_REST_OPEN_AE_OP_ENC_YN,PEND_AUTH_INCL_SEC_SPLTY_YN,pract_type_time_based_yn,DFLT_ORDER_STATUS_YN) values('OR', ?, ?, ?, 'A', ?,?, ?, ?, ?,?,?,?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?,?, ?,?,?,?,?,?,?,?)" );//IN063719//IN068673//IN071361//IN27705
		}catch(Exception e){
			e.printStackTrace();
		}

		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		map.put("traceVal", tabData.toString());
		return getResult(tabData,sqlMap) ;
		//return map;


	}



	public HashMap modify(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		traceVals.append("just entered -- ");

		HashMap sqlMap = new HashMap() ;
		HashMap tabData = new HashMap() ;
		ArrayList modifyData = new ArrayList() ;

		modifyData.add(order_category);
		modifyData.add(ord_type);
		modifyData.add(ord_displayVerticalYN);  //IN038787
		//modifyData.add(ord_privilege);

		modifyData.add(pin_by_ord_type);
		modifyData.add(order_future_hrs_ahead ) ;
		modifyData.add(order_hrs ) ;
		modifyData.add(results_hrs ) ;
		modifyData.add(update_order ) ;		
		modifyData.add(fing_prn_auth_order);
		modifyData.add(fing_prn_auth_result);
		modifyData.add(getLnkFutureOrCrrEcntYn()) ;
		modifyData.add(getLnkOrderingYn()) ;
		modifyData.add(getLnkOrderAuthorisationYn()) ;
		modifyData.add(getRestrictCompNoteYn()) ;	
		modifyData.add(login_by_id ) ;
		modifyData.add(login_at_ws_no ) ;
		modifyData.add(login_facility_id ) ;
		modifyData.add(getPeriodtoModifycmptResult()) ;
		modifyData.add(getModifycompResultBy24hrsYn()) ;
		//modifyData.add(getModifycompResultBy24hrsYn()) ;
		modifyData.add(getReasonCodeHoldDisYN()) ;//IN028417
		modifyData.add(getPrefSurgDate()) ;//--[IN029395]
		//IN049419 - Start
		modifyData.add(getAmendReasonYN()) ; 
		modifyData.add(getAmendReasonMandatYN()) ;
		modifyData.add(getAuditForAmendReqdYN());
		//IN049419 - End
		modifyData.add(getAllow_specimen_barcode_search_yn()); // IN055737 HSA-CRF-0250.1 
		modifyData.add(getRecConsetWithOrderYN());//IN057196
		modifyData.add(getAuth_ord_priv_rule_only_yn());//ML-MMOH-CRF-0493 [IN059086]
		modifyData.add(getOrdFormtMultiListMandYN()); //ML-MMOH-CRF-0508.1 [IN062319]  
		modifyData.add(getOrdReplThroTermsetYN());//IN061890
		modifyData.add(getCanOptionInactiveOrdYN());//IN065925
		modifyData.add(getDisSelectAllOptionYN());//[IN064980]
		modifyData.add(getrestrictAEEncountersYN());//IN063719
		modifyData.add(getPendAuthIncludeSecSpltyYn());//IN068673
		modifyData.add(getTime_based_rule_yn());	//IN071361
		modifyData.add(getDefaultOrderStatus()); //IN27705
		try{
			//sqlMap.put("ModifySQL",OrRepository.getOrKeyValue("SQL_OR_OR_PARAMETER_UPDATE") );Modified --[IN029395]
			//IN038787 Start.
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=? where module_id='OR'" );//IN028417
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=? where module_id='OR'" ); //IN038787 - Commented for IN049419
			//IN038787 End.
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? where module_id='OR'" ); // IN049419 -commented for IN055737 HSA-CRF-0250.1 
			//IN057196 Start.
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? where module_id='OR'" ); // modified for IN055737 HSA-CRF-0250.1
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?  where module_id='OR'" );  // commented for ML-MMOH-CRF-0493 [IN:059086]
			//IN057196 End.
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?  where module_id='OR'" ); // modified for ML-MMOH-CRF-0493 [IN:059086]
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?, ord_formt_multi_list_mand_yn = ?,ORD_REPL_THRO_TERMSET_YN =?  where module_id='OR'" ); //ML-MMOH-CRF-0508.1 [IN062319] ,IN061890,*commenetd for IN065925 
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?, ord_formt_multi_list_mand_yn = ?,ORD_REPL_THRO_TERMSET_YN =?,CAN_OPTION_INACTIVE_ORD_YN=?  where module_id='OR'" );//Modified for IN065925
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?, ord_formt_multi_list_mand_yn = ?,ORD_REPL_THRO_TERMSET_YN =?,CAN_OPTION_INACTIVE_ORD_YN=? ,DIS_SELECT_ALL_OPTION_YN=? where module_id='OR'" );//Modified for [IN064980]**commented for IN063719**
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?, ord_formt_multi_list_mand_yn = ?,ORD_REPL_THRO_TERMSET_YN =?,CAN_OPTION_INACTIVE_ORD_YN=? ,DIS_SELECT_ALL_OPTION_YN=?,ORD_REST_OPEN_AE_OP_ENC_YN=? where module_id='OR'" );//IN063719//IN068673
			//sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?, ord_formt_multi_list_mand_yn = ?,ORD_REPL_THRO_TERMSET_YN =?,CAN_OPTION_INACTIVE_ORD_YN=? ,DIS_SELECT_ALL_OPTION_YN=?,ORD_REST_OPEN_AE_OP_ENC_YN=?, PEND_AUTH_INCL_SEC_SPLTY_YN=? where module_id='OR'" );//IN063719//IN068673//IN071361
			sqlMap.put("ModifySQL","UPDATE or_param set presel_order_category_yn = (?),presel_order_type_code_yn  = (?), ctlog_disp_vertical_yn = (?),pin_ident_by_category_yn = (?),order_future_hrs_ahead=(?) ,cosign_rule = 'A', order_backdate_hrs_behind = (?), result_backdate_hrs_behind = (?), dflt_in_process_ord_stat = (?), fing_prn_auth_order=(?),fing_prn_auth_result=(?), allow_fut_ord_link_at_enc_yn =(?),allow_priv_to_order_yn=(?),allow_priv_to_authorise_yn=(?),restrict_auto_complete_note_yn=?,modified_by_id = (?), modified_date = sysdate, modified_at_ws_no = (?), modified_facility_id = (?) ,period_mod_rslt_completed=?,by_24hrs_yn=?,HOLD_DISCONTINUE_REASON_YN=(?),PREF_SURGERY_DATE_AHEAD=?, ORD_AMNDRSN_REQ_YN = ?, ORD_AMNDRSN_MANDAT_YN = ?, ORD_AUDIT_REQ_YN = ? , DISP_SLIP_BARCOD_SRCH_YN = ? , CNSNT_WITH_ORDER_YN = ?, AUTH_ORD_PRIV_RULE_ONLY_YN =?, ord_formt_multi_list_mand_yn = ?,ORD_REPL_THRO_TERMSET_YN =?,CAN_OPTION_INACTIVE_ORD_YN=? ,DIS_SELECT_ALL_OPTION_YN=?,ORD_REST_OPEN_AE_OP_ENC_YN=?, PEND_AUTH_INCL_SEC_SPLTY_YN=? , pract_type_time_based_yn = ?, DFLT_ORDER_STATUS_YN=? where module_id='OR'" );//IN063719//IN068673//IN071361//IN27705
		}catch(Exception e){
			e.printStackTrace();
		}

		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);
		map.put("traceVal", tabData.toString());
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
			// conversions	map = remote.insert(tabData, sqlMap ) ;
			}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			// conversions	 map = remote.modify(tabData, sqlMap ) ;
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
		
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	  }

 }//End of Method


	public void setAll( Hashtable recordSet ) {

		if(recordSet.containsKey("ord_category")){
			String tmp_ord_cat_val = (String)recordSet.get("ord_category");
			if( !(tmp_ord_cat_val.equals("")))
				setOrderCategory("Y") ;
			else
				setOrderCategory("N") ;
		}
		if(recordSet.containsKey("ord_type")){
			String tmp_ord_type_val = (String)recordSet.get("ord_type");
			if( !(tmp_ord_type_val.equals("")))
				setOrderType("Y") ;
			else
				setOrderType("N") ;
		}
		//IN038787 Start.
		if(recordSet.containsKey("ord_displayVerticalYN")){
			String tmp_ord_displayVerticalYN_val = (String)recordSet.get("ord_displayVerticalYN");
			if( !(tmp_ord_displayVerticalYN_val.equals("")))
				setOrderDisplayVerticalYN("Y") ;
			else
				setOrderDisplayVerticalYN("N") ;
		}
		//IN038787 End.
		if(recordSet.containsKey("ord_privilege")){
			setOrderPrivilege((String)recordSet.get( "ord_privilege" ));
		}
		if(recordSet.containsKey("pin_by_ord_type")){
			String tmp_pin_by_ord_type = (String)recordSet.get("pin_by_ord_type");
			if( !(tmp_pin_by_ord_type.equals("")))
				setPinOrderType("Y") ;
			else
				setPinOrderType("N") ;
		}
		if(recordSet.containsKey("co_sign_rule")){
			setCosignRule((String)recordSet.get( "co_sign_rule" ));
		}
		if(recordSet.containsKey("order_future_hrs_ahead"))
		{
			setOrderFutureHrsAhead((String)recordSet.get( "order_future_hrs_ahead" ));
		}
		if(recordSet.containsKey("order_hrs")){
			setOrderHrs((String)recordSet.get( "order_hrs" ));
		}
		if(recordSet.containsKey("results_hrs")){
			setResultHrs((String)recordSet.get( "results_hrs" ));
		}
		if(recordSet.containsKey("update_order")){
			setUpdateOrder((String)recordSet.get( "update_order" ));
		}
		if(recordSet.containsKey("fing_prn_auth_order")){			
			setFingerPrintAuthOrder((String)recordSet.get( "fing_prn_auth_order" ));
		}if(recordSet.containsKey("fing_prn_auth_result")){
			setFingerPrintAuthResult((String)recordSet.get( "fing_prn_auth_result" ));
		}
		if(recordSet.containsKey("lnkFutureOrCrrEcntYn"))
		{
			setlnkFutureOrCrrEcntYn((String)recordSet.get( "lnkFutureOrCrrEcntYn" ));
		}
		if(recordSet.containsKey("lnkOrderingYn"))
		{
			setLnkOrderingYn((String)recordSet.get("lnkOrderingYn"));
		}
		if(recordSet.containsKey("lnkOrderAuthorisationYn"))
		{
			setLnkOrderAuthorisationYn((String)recordSet.get( "lnkOrderAuthorisationYn" ));
		}
		/*Added by Uma, for the CRF-804-OR IN016226*/
		if(recordSet.containsKey("restrictCompNoteYn"))
		{
			setRestrictCompNoteYn((String)recordSet.get("restrictCompNoteYn"));
		}
		/* Ends Here*/
		
		/*Added by Arvind on 4/19/2010 for the CRF-804 */
		if(recordSet.containsKey("completed_result"))
		{
			setPeriodtoModifycmptResult((String)recordSet.get("completed_result"));
		}
		if(recordSet.containsKey("by24_hrs"))
		{
			setModifycompResultBy24hrsYn((String)recordSet.get("by24_hrs"));
		}
		/* Ends Here*/
		//--[IN029395] - Start
		if(recordSet.containsKey("surgery_ahead_days"))
		{
			setPrefSurgDate((String)recordSet.get("surgery_ahead_days"));
		}
		
		//IN028417-Starts
		if(recordSet.containsKey("ReasonCodeHoldDisYN"))
		{
			setReasonCodeHoldDisYN((String)recordSet.get("ReasonCodeHoldDisYN"));
		}
		
		//IN028417-Ends
		//IN049419 - Start
		if(recordSet.containsKey("amendauditreqdyn")){
			setAuditForAmendReqdYN((String)recordSet.get("amendauditreqdyn"));
		}
		if(recordSet.containsKey("amendreasonyn")){
			setAmendReasonYN((String)recordSet.get("amendreasonyn"));
		}
		if(recordSet.containsKey("amendreasonmandateyn")) {
			setAmendReasonMandatYN((String)recordSet.get("amendreasonmandateyn"));
		}
		// IN049419 - End
		//IN055737 HSA-CRF-0250.1 - Start
		if(recordSet.containsKey("allow_specimen_barcode_search_yn")) {
			setAllow_specimen_barcode_search_yn((String)recordSet.get("allow_specimen_barcode_search_yn"));
		}	
		//IN055737 HSA-CRF-0250.1 - End
		//IN057196 Start.
		if(recordSet.containsKey("recConsetWithOrderYN")) {
			setRecConsetWithOrderYN((String)recordSet.get("recConsetWithOrderYN"));
		}
		//IN057196 End.
		//ML-MMOH-CRF-0493 [IN059086] - Start
		if(recordSet.containsKey("auth_ord_priv_rule_only_yn")){
			String tmp_auth_ord_priv_rule_only_yn = (String)recordSet.get("auth_ord_priv_rule_only_yn");
			if((tmp_auth_ord_priv_rule_only_yn.equals("")) ||tmp_auth_ord_priv_rule_only_yn == null )
				setAuth_ord_priv_rule_only_yn("N") ;
			else
				setAuth_ord_priv_rule_only_yn((String)recordSet.get("auth_ord_priv_rule_only_yn"));
		}
		//ML-MMOH-CRF-0493 [IN059086] - End
		 // ML-MMOH-CRF-0508.1 [IN062319] - Start
		if(recordSet.containsKey("ord_formt_multi_list_mand_yn")){
			String ord_formt_multi_list_mand_yn = (String)recordSet.get("ord_formt_multi_list_mand_yn");
			if((ord_formt_multi_list_mand_yn.equals("")) ||ord_formt_multi_list_mand_yn == null )
				setOrdFormtMultiListMandYN("N") ;
			else
				setOrdFormtMultiListMandYN((String)recordSet.get("ord_formt_multi_list_mand_yn"));
		}
		/*IN061890 Starts*/
		if(recordSet.containsKey("ord_repl_thro_termset_yn")){
			String ord_repl_thro_termset_yn = (String)recordSet.get("ord_repl_thro_termset_yn");
			if((ord_repl_thro_termset_yn.equals("")) ||ord_repl_thro_termset_yn == null )
				setOrdReplThroTermsetYN("N") ;
			else
				setOrdReplThroTermsetYN((String)recordSet.get("ord_repl_thro_termset_yn"));
		}/*IN061890 Ends*/
		/*IN065925 Starts*/
		if(recordSet.containsKey("can_option_inactive_ord_yn")){
			String can_option_inactive_ord_yn = (String)recordSet.get("can_option_inactive_ord_yn");
			if((can_option_inactive_ord_yn.equals("")) ||can_option_inactive_ord_yn == null )
				setCanOptionInactiveOrdYN("N") ;
			else
				setCanOptionInactiveOrdYN((String)recordSet.get("can_option_inactive_ord_yn"));
		}/*IN065925 Ends*/
		// ML-MMOH-CRF-0508.1 [IN062319]  - End
		//[IN064980]-----STARTS
		if(recordSet.containsKey("DIS_SELECT_ALL_OPTION_YN")){
			String Dis_Select_All_Option_yn = (String)recordSet.get("DIS_SELECT_ALL_OPTION_YN");
			if((Dis_Select_All_Option_yn.equals("")) ||Dis_Select_All_Option_yn == null )
				setDisSelectAllOptionYN("N") ;
			else
				setDisSelectAllOptionYN((String)recordSet.get("DIS_SELECT_ALL_OPTION_YN"));
		}
		//[IN064980]-----ENDS
		/*IN063719 Starts*/
		if(recordSet.containsKey("restrictAE_Encounters_yn")){
			String restrictAE_Encounters_yn = (String)recordSet.get("restrictAE_Encounters_yn");
			if((restrictAE_Encounters_yn.equals("")) ||restrictAE_Encounters_yn == null )
				setrestrictAEncountersYN("N") ;
			else
				setrestrictAEncountersYN((String)recordSet.get("restrictAE_Encounters_yn"));
		}/*IN063719 Ends*/
		
		//IN068673, starts
		if(recordSet.containsKey("pendAuthIncludeSecSpltyYn")){
			String pendAuthIncludeSecSpltyYn = (String)recordSet.get("pendAuthIncludeSecSpltyYn");
			if((pendAuthIncludeSecSpltyYn.equals("")) ||pendAuthIncludeSecSpltyYn == null )
				setPendAuthIncludeSecSpltyYn("N") ;
			else
				setPendAuthIncludeSecSpltyYn((String)recordSet.get("pendAuthIncludeSecSpltyYn"));
		}
		//IN068673, ends
		
		
		//IN071361, starts
				if(recordSet.containsKey("time_based_rule_yn")){
					String time_based_rule_yn = (String)recordSet.get("time_based_rule_yn");
					if((time_based_rule_yn.equals("")) ||time_based_rule_yn == null )
						setTime_based_rule_yn("N") ;
					else
						setTime_based_rule_yn((String)recordSet.get("time_based_rule_yn"));
				}
				//IN071361, ends
        //IN27705 Starts
		if(recordSet.containsKey("def_order_status")){
			String def_order_status = (String)recordSet.get("def_order_status");
			if((def_order_status.equals("")) ||def_order_status == null )
				setDefaultOrderStatus("N") ;
			else
				setDefaultOrderStatus((String)recordSet.get("def_order_status"));
		}
		 //IN27705 Ends
	}
}

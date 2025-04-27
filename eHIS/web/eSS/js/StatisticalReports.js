/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var reports=new Array();
reports[""]='../../eCommon/html/blank.html';
reports["SS_ROF_LIST"]='../../eSS/jsp/ROFReportList.jsp?module_id=SS&function_id=SS_ROF_LIST&function_name=ROF List&function_type=R&access=NNNNN';
reports["SS_PACKING_CHECK_LIST"]='../../eSS/jsp/ReportPackingCheckList.jsp?module_id=SS&function_id=SS_PACKING_CHECK_LIST&function_name=Packing Check List&function_type=R&access=NNNNN';
reports["SS_STERILE_LABEL"]='../../eSS/jsp/SterileLabelRun.jsp?module_id=SS&function_id=SS_STERILE_LABEL&function_name=Sterile Label&function_type=R&access=NNNNN';
reports["SS_DISPATCH_LIST"]='../../eSS/jsp/DispatchReportRun.jsp?module_id=SS&function_id=SS_DISPATCH_LIST&function_name=Dispatch List&function_type=R&access=NNNNN';
reports["SS_ACKNOWLEDGEMENT_LIST"]='../../eSS/jsp/AcknowledgementReportRun.jsp?module_id=SS&function_id=SS_ACKNOWLEDGEMENT_LIST&function_name=Acknowledgement List&function_type=R&access=NNNNN';
reports["SS_PACK_LABEL"]='../../eSS/jsp/ReportPackLabel.jsp?module_id=SS&function_id=SS_PACK_LABEL&function_name=Pack Label&function_type=R&access=NNNNN';
reports["SS_AUTOCLAVE_LOAD_LIST"]='../../eSS/jsp/AutoclavingLoadDtlReportList.jsp?module_id=SS&function_id=SS_AUTOCLAVE_LOAD_LIST&function_name=Autoclaving Load Details&function_type=R&access=NNNNN';
reports["SS_AUTOCLAVE_WASH_TEST_LIST"]='../../eSS/jsp/AutoclaveWashUnitTestDtlReportCriteria.jsp?module_id=SS&function_id=SS_AUTOCLAVE_WASH_TEST_LIST&function_name=Autoclave/Wash Unit Test Details&function_type=R&access=NNNNN';
reports["SS_AUTOCLAVE_LOAD_SUMM_LIST"]='../../eSS/jsp/ReportAutoclaveLoadSummary.jsp?module_id=SS&function_id=SS_AUTOCLAVE_LOAD_SUMM_LIST&function_name=Autoclave Load Summary&function_type=R&access=NNNNN';
reports["SS_REQ_ORDER_TRAYS_STATUS_LIST"]='../../eSS/jsp/RequestOrderTraysStatusReportRun.jsp?module_id=SS&function_id=SS_REQ_ORDER_TRAYS_STATUS_LIST&function_name=Request Order Trays Status&function_type=R&access=NNNNN';
reports["SS_REQ_ORD_TRY_STAT_SUMM_LIST"]='../../eSS/jsp/ReportRequestOrderTraysStatusSummary.jsp?module_id=SS&function_id=SS_REQ_ORD_TRY_STAT_SUMM_LIST&function_name=Request Order Trays Status Summary&function_type=R&access=NNNNN';
reports["SS_ROF_PROC_TIMING_LIST"]='../../eSS/jsp/ROFProcessTimingDetailsReportCriteria.jsp?module_id=SS&function_id=SS_ROF_PROC_TIMING_LIST&function_name=ROF Process Timing Details&function_type=R&access=NNNNN';


reports["SS_MONTHLY_SERVICE_STAT_LIST"]='../../eSS/jsp/ReportMonthlyServiceStatistics.jsp?module_id=SS&function_id=SS_MONTHLY_SERVICE_STAT_LIST&function_name=Monthly Service Statistics&function_type=R&access=NNNNN';
reports["SS_MTH_SERV_STAT_BY_STORE_LIST"]='../../eSS/jsp/ReportMonthlyStatByStore.jsp?module_id=SS&function_id=SS_MTH_SERV_STAT_BY_STORE_LIST&function_name=Monthly Service Statistics By Stores&function_type=R&access=NNNNN';
reports["SS_GROUP_MOVE_STAT_LIST"]='../../eSS/jsp/GroupMovementStatisticsReportRun.jsp?module_id=SS&function_id=SS_GROUP_MOVE_STAT_LIST&function_name=Group Movement Statistics&function_type=R&access=NNNNN';
reports["SS_TRAY_USAGE_STAT_LIST"]='../../eSS/jsp/ReportTraysUsageStatistics.jsp?module_id=SS&function_id=SS_TRAY_USAGE_STAT_LIST&function_name=Trays Usage Statistics&function_type=R&access=NNNNN';
reports["SS_AUTOCL_LOAD_FAIL_STAT_LIST"]='../../eSS/jsp/AutoclaveLoadFailureStatisticsReportCriteria.jsp?module_id=SS&function_id=SS_AUTOCL_LOAD_FAIL_STAT_LIST&function_name=Autoclave Load Failure Statistics&function_type=R&access=NNNNN';
reports["SS_TRAY_DISCR_STAT_LIST"]='../../eSS/jsp/TrayDiscrepancyStatisticsReport.jsp?module_id=SS&function_id=SS_TRAY_DISCR_STAT_LIST&function_name=Tray Discrepancy Statistics&function_type=R&access=NNNNN';
reports["SS_MTH_SERV_STAT_BY_GRP_LIST"]='../../eSS/jsp/ReportMonthlyServiceStatisticsByGroups.jsp?module_id=SS&function_id=SS_MTH_SERV_STAT_BY_GRP_LIST&function_name=Monthly Service Statistics By Groups&function_type=R&access=NNNNN';


reports["SS_AGEING_ANALYSIS_LIST"]='../../eSS/jsp/AgeingAnalysisReport.jsp?module_id=SS&function_id=SS_AGEING_ANALYSIS_LIST&function_name=Ageing Analysis&function_type=R&access=NNNNN';
reports["SS_CHARGES_SUMMARY_LIST"]='../../eSS/jsp/ChargesSummaryReport.jsp?module_id=SS&function_id=SS_CHARGES_SUMMARY_LIST&function_name=Charges Summary&function_type=R&access=NNNNN';
reports["SS_DEPT_CHARGES_LIST"]='../../eSS/jsp/DepartmentChargeDetailsReport.jsp?module_id=SS&function_id=SS_DEPT_CHARGES_LIST&function_name=Department Charge Details&function_type=R&access=NNNNN';
reports["SS_EXPIRY_LIST"]='../../eSS/jsp/ExpiryReport.jsp?module_id=SS&function_id=SS_EXPIRY_LIST&function_name=Expiry List&function_type=R&access=NNNNN';
reports["SS_FINALIZED_RETURN_LIST"]='../../eSS/jsp/FinalizedReturnReport.jsp?module_id=SS&function_id=SS_FINALIZED_RETURN_LIST&function_name=Finalized Return List&function_type=R&access=NNNNN';
reports["SS_ISSUE_LIST"]='../../eSS/jsp/IssueReport.jsp?module_id=SS&function_id=SS_ISSUE_LIST&function_name=Issue List&function_type=R&access=NNNNN';
reports["SS_MAST_CODE_LIST"]='../../eSS/jsp/MasterCodeReport.jsp?module_id=SS&function_id=SS_MAST_CODE_LIST&function_name=Master Code List&function_type=R&access=NNNNN';
reports["SS_PATIENT_ITEM_LIST"]='../../eSS/jsp/InstrumentsUsedForPatients.jsp?module_id=SS&function_id=SS_PATIENT_ITEM_LIST&function_name=Instruments used for Patients List&function_type=R&access=NNNNN';
reports["SS_PRINT_COUNT_SHEET"]='../../eSS/jsp/PrintCountSheet.jsp?module_id=SS&function_id=SS_PRINT_COUNT_SHEET&function_name=Print Count Sheet&function_type=R&access=NNNNN';
reports["SS_REQUEST_SUMMARY_LIST"]='../../eSS/jsp/RequestSummaryReport.jsp?module_id=SS&function_id=SS_REQUEST_SUMMARY_LIST&function_name=Request Summary List&function_type=R&access=NNNNN';
reports["SS_RETURN_GRP_SUMMARY_LIST"]='../../eSS/jsp/ReturnGroupSummaryReport.jsp?module_id=SS&function_id=SS_RETURN_GRP_SUMMARY_LIST&function_name=Return Group Summary List&function_type=R&access=NNNNN';
reports["SS_RETURN_ITEM_PATIENT_LIST"]='../../eSS/jsp/ReturnInstrumentsPatientsReport.jsp?module_id=SS&function_id=SS_RETURN_ITEM_PATIENT_LIST&function_name=Return Instruments List(Patient)&function_type=R&access=NNNNN';
reports["SS_RETURN_ITEM_STORE_LIST"]='../../eSS/jsp/ReturnInstrumentsStoreReport.jsp?module_id=SS&function_id=SS_RETURN_ITEM_STORE_LIST&function_name=Return Instruments List(Store)&function_type=R&access=NNNNN';
reports["SS_RETURN_LIST"]='../../eSS/jsp/ReturnReport.jsp?module_id=SS&function_id=SS_RETURN_LIST&function_name=Return List&function_type=R&access=NNNNN';
reports["SS_TRAYS_PRE_DUR_PERIOD_LIST"]='../../eSS/jsp/TraysPreparedDuringPeriodReport.jsp?module_id=SS&function_id=SS_TRAYS_PRE_DUR_PERIOD_LIST&function_name=Trays Prepared During Period&function_type=R&access=NNNNN';
reports["SS_TRAY_DETAILS_LIST"]='../../eSS/jsp/TrayDetailsReport.jsp?module_id=SS&function_id=SS_TRAY_DETAILS_LIST&function_name=Tray Details&function_type=R&access=NNNNN';
reports["SS_TRAY_DISCR_LIST"]='../../eSS/jsp/TrayDiscrepancyReport.jsp?module_id=SS&function_id=SS_TRAY_DISCR_LIST&function_name=Tray Discrepancy List&function_type=R&access=NNNNN';
reports["SS_TRAY_LABEL"]='../../eSS/jsp/TrayLabel.jsp?module_id=SS&function_id=SS_TRAY_LABEL&function_name=Tray Identification Label&function_type=R&access=NNNNN';
reports["SS_TRAY_VALUE_LIST"]='../../eSS/jsp/TrayValueReport.jsp?module_id=SS&function_id=SS_TRAY_VALUE_LIST&function_name=Tray Values&function_type=R&access=NNNNN';
reports["SS_USER_STORE_LIST"]='../../eSS/jsp/UserAccessForStoreReport.jsp?module_id=SS&function_id=SS_USER_STORE_LIST&function_name=User Access for Store List&function_type=R&access=NNNNN';
reports["SS_VARIANCE_REPORT"]='../../eSS/jsp/VarianceReport.jsp?module_id=SS&function_id=SS_VARIANCE_REPORT&function_name=Variance Report&function_type=R&access=NNNNN';
reports["SS_WRITE_OFF_DETAIL_LIST"]='../../eSS/jsp/WriteOffDetailReport.jsp?module_id=SS&function_id=SS_WRITE_OFF_DETAIL_LIST&function_name=Write off List&function_type=R&access=NNNNN';
reports["SS_WRITE_OFF_SUMMARY_LIST"]='../../eSS/jsp/WriteOffSummaryReport.jsp?module_id=SS&function_id=SS_WRITE_OFF_SUMMARY_LIST&function_name=Write off Summary&function_type=R&access=NNNNN';

function loadPage(function_id){
	parent.f_query_add_mod.location.href=reports[function_id];
	displayMessage(parent.messageFrame,"");
}

function reset() {
	//f_query_add_mod.document.forms[0].reset();
	parent.frames[2].frames[1].document.forms[0].function_id.value="";
	parent.frames[2].frames[2].document.location.href='../../eCommon/html/blank.html'
}

function run(){
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
	f_query_add_mod.run();
/*	var formObj=f_query_add_mod.formAutoclaveLoadFailureStat; 
	if (isValidFromToField(formObj.p_fr_cutoff_date, formObj.p_to_cutoff_date, DATE, "Cutoff Date", messageFrame)) 
		if (isValidFromToField(formObj.p_fr_autoclave_unit, formObj.p_to_autoclave_unit, STRING, "Autoclave Unit", messageFrame)) 
			if (isValidFromToField(formObj.p_fr_sterile_type, formObj.p_to_sterile_type, STRING, "Sterilization Type", messageFrame)) 
				if (isValidFromToField(formObj.p_fr_load_no, formObj.p_to_load_no, LONG, "Load No", messageFrame)) 
					formObj.submit();
*/
}

function searchAutoclaveUnit( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAutoclaveLoadFailureStat.SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( getLabel("eSS.AutoclaveUnit.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}

function searchSterileType( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formAutoclaveLoadFailureStat.SQL_SS_STERILIZATION_TYPE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup(getLabel("eSS.SterilizationType.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}

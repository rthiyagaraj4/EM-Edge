var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var language;

function reset() {
	if(f_query_add_mod.MasterCodePages.document.formReportItemAnalysis) {
		f_query_add_mod.MasterCodePages.document.formReportItemAnalysis.reset();
	}
	if(f_query_add_mod.MasterCodePages.document.formReportItemClass) {
		f_query_add_mod.MasterCodePages.document.formReportItemClass.reset();
	} 

	if(f_query_add_mod.MasterCodePages.document.formReportStore) {
		f_query_add_mod.MasterCodePages.document.formReportStore.reset();
	}
	if(f_query_add_mod.MasterCodePages.document.formReportBinLocation) {
		f_query_add_mod.MasterCodePages.document.formReportBinLocation.reset();
	}
	if(f_query_add_mod.MasterCodePages.document.formReportSupplierList) {
		f_query_add_mod.MasterCodePages.document.formReportSupplierList.reset();
	}
	if(f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem) {
		f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem.reset();
	}
	if(f_query_add_mod.MasterCodePages.document.formReportMaterials) {
		f_query_add_mod.MasterCodePages.document.formReportMaterials.reset();
	}					   
	if(f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks) {
		f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks.reset();
	}

}

function loadPage() {
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="1") {
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportItemAnalysis.jsp'
	}
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="2") {
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportItemClass.jsp'
	}

	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="4") {
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportStore.jsp'
	}
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="5") {
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportBinLocation.jsp'
	}
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="7") {
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportSupplier.jsp'
	}
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="3") {
		parent.MasterCodePages.document.location.href='../../eCommon/html/blank.html'
	}
	// Added for Trade Name For Item report.
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="6") {		
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportTradeNameForItem.jsp'
	}
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="8") {
		parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportMaterialsGroup.jsp'
	}
    if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="9") {
	parent.MasterCodePages.document.location.href='../../eMM/jsp/ReportTransactionRemarks.jsp'

	}

}

function run() {
	if(f_query_add_mod.MasterCodePages.document.formReportItemAnalysis) {
		if( CheckString(getLabel("Common.ItemAnalysis.label","Common") , f_query_add_mod.MasterCodePages.document.formReportItemAnalysis.p_from_code,f_query_add_mod.MasterCodePages.document.formReportItemAnalysis.p_to_code, messageFrame )  ) {
			f_query_add_mod.MasterCodePages.document.formReportItemAnalysis.submit();
		}
	}
	if(f_query_add_mod.MasterCodePages.document.formReportItemClass) {
		if( CheckString(getLabel("Common.ItemClass.label","Common"), f_query_add_mod.MasterCodePages.document.formReportItemClass.p_from_code,f_query_add_mod.MasterCodePages.document.formReportItemClass.p_to_code, messageFrame )  ) {
			f_query_add_mod.MasterCodePages.document.formReportItemClass.submit();
		}
	}
	if(f_query_add_mod.MasterCodePages.document.formReportStore) {
		if( CheckString(getLabel("Common.Store.label","Common") , f_query_add_mod.MasterCodePages.document.formReportStore.p_from_code,f_query_add_mod.MasterCodePages.document.formReportStore.p_to_code, messageFrame )  ) {
			if( CheckString(getLabel("Common.department.label","Common") , f_query_add_mod.MasterCodePages.document.formReportStore.p_dept_from_code,f_query_add_mod.MasterCodePages.document.formReportStore.p_dept_to_code, messageFrame )  ) {
				f_query_add_mod.MasterCodePages.document.formReportStore.submit();
			}
		}
	}
	if(f_query_add_mod.MasterCodePages.document.formReportBinLocation) {
		if( CheckString(getLabel("Common.BinLocation.label","Common"), f_query_add_mod.MasterCodePages.document.formReportBinLocation.p_from_code,f_query_add_mod.MasterCodePages.document.formReportBinLocation.p_to_code, messageFrame )  ) {
			f_query_add_mod.MasterCodePages.document.formReportBinLocation.submit();
		}
	}
	if(f_query_add_mod.MasterCodePages.document.formReportSupplierList) {
		if( CheckString(getLabel("Common.SupplierCode.label","Common") , f_query_add_mod.MasterCodePages.document.formReportSupplierList.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportSupplierList.p_to_code, messageFrame )  ) {
			f_query_add_mod.MasterCodePages.document.formReportSupplierList.submit();
		}
	}

	if(f_query_add_mod.MasterCodePages.document.formReportMaterials) {
		if( CheckString(getLabel("eMM.MaterialCode.label","MM") , f_query_add_mod.MasterCodePages.document.formReportMaterials.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportMaterials.p_to_code, messageFrame )  ) {
			f_query_add_mod.MasterCodePages.document.formReportMaterials.submit();
		}
	}
	
	if (f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem) {
		if ( CheckString(getLabel("Common.ItemCode.label","Common") , f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem.p_item_from_code,f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem.p_item_to_code, messageFrame)) {
			if ( CheckString(getLabel("Common.TradeID.label","Common") , f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem.p_trade_from_code,f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem.p_trade_to_code, messageFrame)) {
				f_query_add_mod.MasterCodePages.document.formReportTradeNameForItem.submit();
			}
		}
	}
	if(f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks) {
		if( CheckString(getLabel("Common.TransactionRemarks.label","Common") , f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks.P_FM_trn_remarks_code,f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks.P_TO_trn_remarks_code, messageFrame )  ) {
			f_query_add_mod.MasterCodePages.document.formReportTransactionRemarks.submit();
		}
	}

}	

async function searchCodebinLoc( objCode, objDesc ) {
//	alert("searacH");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_MM_BINLOCATION_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.BinLocation.label","Common") , argumentArray );
		var ret1=unescape(returnedValues);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}
async function searchCodeRemarks(objCode,objDesc) {
//	objCode_value = trimString(objCode.value);
//	objDesc_value = trimString(objDesc.value);

	objCode_value = "";
	objDesc_value = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "module_id" ;
	dataValueArray[1] = "ST";
	dataTypeArray[1] = STRING ;
	dataNameArray[2] = "trn_type" ;
	dataValueArray[2] = "ADJ";
	dataTypeArray[2] = STRING ;

	argumentArray[0] = document.getElementById("SQL_MM_TRN_REMARKS_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "4,5";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.remarks.label","Common") , argumentArray );
		var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		
	} 
}

/*function searchCodeRemarks( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formReportTransactionRemarks.SQL_MM_TRN_REMARKS_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Transaction Remarks", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}*/

async function searchCodeItemAnal( objCode, objDesc ) {
	//alert("item");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_MM_ITEM_ANALYSIS_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup( getLabel("Common.ItemAnalysis.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}

async function searchCodeItemClass( objCode, objDesc ) {
	//alert("search");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_MM_ITEM_CLASS_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label","Common") , argumentArray );
	var ret1=unescape(returnedValues);
//	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}

async function searchCodeStore( objCode, objDesc ) {	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_MM_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;

	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Store.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}

async function searchCodeforDept( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
//	dataNameArray[0]	= "p_language_id" ;
	//dataValueArray[0]	= document.formReportStore.p_language_id.value;
//	dataTypeArray[0]	    = STRING ;
	dataNameArray[0]	= "operating_facility_id" ;
	dataValueArray[0]	= document.formReportStore.p_facility_id.value;
	dataTypeArray[0]	    = STRING ;
	//dataNameArray[2]	= "p_language_id" ;
	//dataValueArray[2]	= document.formReportStore.p_language_id.value;
	//dataTypeArray[2]	    = STRING ;
//	argumentArray[0] = document.getElementById("SQL_MM_DEPARTMENT_LOOKUP").value;
var sql_1="SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'spl','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'spl','2') LIKE UPPER(?) ORDER BY 1";
var sql_2=sql_1.replace(/spl/,document.formReportStore.p_language_id.value);
var sql_3=sql_2.replace(/spl/,document.formReportStore.p_language_id.value);

	//argumentArray[0] = "SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'"+document.formReportStore.p_language_id.value+"','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'"+document.formReportStore.p_language_id.value+"','2') LIKE UPPER(?) ORDER BY 1";
	argumentArray[0] =sql_3;

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.department.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}


/*function searchCodeforDept( objCode, objDesc ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//dataNameArray[0]	= "" ;
	//dataValueArray[0]	= document.formReportStore.p_language_id.value;
	//dataTypeArray[0]	    = STRING ;
	dataNameArray[1]	= "operating_facility_id" ;
	dataValueArray[1]	= document.formReportStore.p_facility_id.value;
	dataTypeArray[1]	    = STRING ;
	//dataNameArray[2]	= "" ;
	//dataValueArray[2]	= document.formReportStore.p_language_id.value;
//	dataTypeArray[2]	    = STRING ;
	var sql_String= "SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code, 'spl' ,'2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?)  AND dept_code LIKE UPPER(?) and  AM_GET_DESC.AM_DEPT(dept_code,'spl','2')  LIKE UPPER(?)  ORDER BY 1";
	var sql_se=sql_String.replace(/spl/, document.formReportStore.p_language_id.value);
	var sql_se1=sql_se.replace(/spl/, document.formReportStore.p_language_id.value);
	alert("sql_se--1-"+sql_se1);
		
//	argumentArray[0] = document.getElementById("SQL_MM_DEPARTMENT_LOOKUP").value;
	//argumentArray[0] = sql_se1;
//	argumentArray[0] = "SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'"+document.formReportStore.p_language_id.value+"','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'"+document.formReportStore.p_language_id.value+"','2') LIKE UPPER(?) ORDER BY 1";

/*	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
argumentArray[0] = "SELECT dept_code code, AM_GET_DESC.AM_DEPT(dept_code,'"+document.formReportStore.p_language_id.value+"','2') description FROM am_facility_dept WHERE  operating_facility_id LIKE( ?) AND dept_code LIKE UPPER(?)  AND  AM_GET_DESC.AM_DEPT(dept_code,'"+document.formReportStore.p_language_id.value+"','2') LIKE UPPER(?) ORDER BY 1";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.department.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = returnedValues[0];
		objDesc.value = returnedValues[1];
	} 
}

*/

async function searchItem(objCode,objDesc) {
	//alert("4");
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_MM_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";

	if(objDesc.readOnly) {
		argumentArray[5] = "";
	}
	else {
		argumentArray[5] = objCode.value;
	}
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") ) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
		objDesc.value = escape(objDesc.value);
	} 
}

async function searchTradeItem(objCode,objDesc) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_AM_TRADE_NAME_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";

	if(objDesc.readOnly) {
		argumentArray[5] = "";
	}
	else {
		argumentArray[5] = objCode.value;
	}
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Trade.label","Common"), argumentArray );
var ret1=unescape(returnedValues);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") ) {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}

async function searchMaterialsBase(objCode,objDesc) {
	
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_AP_MATERAILS_SELECT_LOOKUP").value;
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value;
	
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( "Materials", argumentArray );
	var ret1=unescape(returnedValues);
			 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}


async function searchCodeforSupp( objCode) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	dataNameArray[0]  = "language_id";
	dataValueArray[0]  =document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
//	dataNameArray[0]	= "acc_entity_code" ;
//	dataValueArray[0]	= document.formReportSupplierList.acc_entity_id.value;
//	dataTypeArray[0]	= STRING ;
	argumentArray[0] = document.getElementById("SQL_AP_SUPPLIER_SELECT_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objCode.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Supplier.label","Common"), argumentArray );
	var ret1=unescape(returnedValues);
			 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}




function changeReport() {
	if(document.formReportStore.p_report_type.value==2 && (document.formReportStore.p_order_by.value==3 || document.formReportStore.p_order_by.value==5))
		document.formReportStore.p_report_id.value="MMBSTORS";
	else if(document.formReportStore.p_report_type.value==1 && (document.formReportStore.p_order_by.value==3 || document.formReportStore.p_order_by.value==5))
		document.formReportStore.p_report_id.value="MMBSTORD";
	else if(document.formReportStore.p_report_type.value==1 && (document.formReportStore.p_order_by.value==1 ))
		document.formReportStore.p_report_id.value="MMBSTRSD";
	else if(document.formReportStore.p_report_type.value==2 && (document.formReportStore.p_order_by.value==1 ))
		document.formReportStore.p_report_id.value="MMBSTRSD";
	else
		document.formReportStore.p_report_id.value="MMBSTORD";
}

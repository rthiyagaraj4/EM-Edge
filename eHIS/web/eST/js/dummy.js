 var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj="";

function reset() 
{
	formObj=f_query_add_mod.document.ItemLabelReportCriteria;
	formObj.reset();

//	parent.frames[1].frames[1].document.forms[0].reset();
	
}
function run()
{
	if(f_query_add_mod.document.formPrintCountSheetReportCriteria)
	{  	formObj=f_query_add_mod.document.formPrintCountSheetReportCriteria;
	if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, "Store Code", messageFrame))
	if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, "Item Code", messageFrame)) 
	if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, "Item Class", messageFrame))
	if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING, "Alpha Code", messageFrame)) 
	if (isValidFromToField(formObj.p_fr_unit_cost, formObj.p_to_unit_cost, STRING, "Unit Cost", messageFrame)) 
	if (isValidFromToField(formObj.p_fr_st_val, formObj.p_to_st_val, STRING, "Stock Value", messageFrame))
	formObj.submit();
		}
}

function searchCodeItem( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_ST_ITEM_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup( "Item", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[0];
	} 
}

function report_type()
{
	formObj=f_query_add_mod.document.ItemLabelReportCriteria;
	if ( formObj.grn_radio.value == "by_grn")
	{
		formObj.p_fm_item_code.disabled = "true";
		formObj.p_fm_sr2.disabled = "true";
		formObj.p_to_item_code.disabled = "true";
		formObj.p_to_sr2.disabled = "true";
	}
}


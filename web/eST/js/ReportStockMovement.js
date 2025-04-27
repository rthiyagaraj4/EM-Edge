/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
6/8/2021		TFS-22264			Shazana										MOHE-CRF-0084.1-US015
---------------------------------------------------------------------------------------------------------
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;
var formObj = "";
var flag = true;
var flag2 = false;
var flag3 = true;
var display = true;
var v_p_fr_date1, v_p_fr_date2, v_p_fr_date3, v_p_fr_date4, v_p_to_date1, v_p_to_date2, v_p_to_date3, v_p_to_date4;
var code_value = 0;
function reset() {
	f_query_add_mod.location.reload();
	//formObj=f_query_add_mod.document.formStockMovementReportCriteria;
	/*
	formObj.p_fr_sr.disabled=true;
	formObj.p_fr_st_code.disabled=true;
	formObj.p_to_sr.disabled=true;
	formObj.p_to_st_code.disabled=true;
	flag=true;
	flag2=true;
	display=true;
	//formObj.p_item_sel.disabled=false;
	parent.frames[1].frames[1].document.forms[0].reload();
	 */
}
function CheckForSpecialChars(event) {
	var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-.";
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) {
		return false;
	}  // Not a valid key
	//if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	//	return (event.keyCode -= 32);
	return true;
}
function loadcolumn(obj) {
	formObj = document.forms[0];
	if (obj.value == "STBSTKS1") {
		formObj.p_fr_sr.disabled = true;
		formObj.p_fr_st_code.disabled = true;
		formObj.p_to_sr.disabled = true;
		formObj.p_to_st_code.disabled = true;
	} else {
		formObj.p_fr_sr.disabled = false;
		formObj.p_fr_st_code.disabled = false;
		formObj.p_to_sr.disabled = false;
		formObj.p_to_st_code.disabled = false;
	}
	/*
		if(obj.value != "STBSTKS1") 
			formObj.p_item_sel.disabled=true;
	else
			formObj.p_item_sel.disabled=false;
	
	if((obj.value == "STBSTKS3") || (obj.value == "STBSTKS4")|| (obj.value == "STBSTKS6"))
		  { 
			formObj.p_fr_bin_loc.disabled=false;
			formObj.p_to_bin_loc.disabled=false;
		  }
	else
	{
			formObj.p_fr_bin_loc.disabled=true;
			formObj.p_to_bin_loc.disabled=true;
	} 
	*/
}
async function searchCodeItem(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchCodeStore(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	argumentArray[0] = document.getElementById("SQL_ST_STORE_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
//MOHE-CRF-0084.1-US015
async function searchCodeStore1(obj) {
	var user_name =  document.forms[0].p_user_name.value;  
	var strFacilityParam = document.forms[0].p_strFacilityParam.value;; //MOHE-CRF-0084.1    
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	dataNameArray[0] = "language_id";
	dataValueArray[0] = document.forms[0].p_language_id.value;
	dataTypeArray[0] = STRING;
	dataNameArray[1] = "facility_id";
	dataValueArray[1] = document.forms[0].p_facility_id.value;
	dataTypeArray[1] = STRING;
	if(strFacilityParam=="Y"){//MOHE-CRF-0084.1   start
		argumentArray[0] = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE ?	 	  AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code AND st.store_code IN (SELECT STORE_CODE FROM st_user_access_for_store where user_id = '" +user_name+"' "+ ")  ORDER BY 2";//MOHE-CRF-0084.1
	}
	else if (strFacilityParam=="N"){
		argumentArray[0] = "SELECT     st.store_code code,  mm.short_desc  description     FROM  mm_store_lang_vw      mm, st_store st , st_acc_entity_param  WHERE    mm.eff_status ='E'  AND  language_id  like  ?   AND  mm.facility_id    LIKE ?	 	  AND    UPPER(st.store_code)    LIKE	      UPPER(?)  AND  UPPER(mm.short_desc)   LIKE	    UPPER(?)    AND      mm.store_code=st.store_code  ORDER BY 2";//MOHE-CRF-0084.1
	}//end 
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
async function searchCodeItemClass(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.getElementById("SQL_ST_ITEM_CLASS_LOOKUP_LANG").value + "'" + document.forms[0].p_language_id.value + "'";
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		obj.value = arr[0];
	}
}
async function searchAlphaCode(obj) {
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	argumentArray[0] = document.forms[0].SQL_ST_ALPHA_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = await CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	formObj = f_query_add_mod.document.formStockMovementReportCriteria;
	var s1 = formObj.p_fr_date1.value;
	var s2 = formObj.p_to_date1.value;
	if (s1 == "" && s2 == "") {
		frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_SLOT_VALUE", "ST");
		flag = false;
	}
	if (f_query_add_mod.document.formStockMovementReportCriteria) {
		CheckNumMonth();
		slotVadlidation();
		if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
					}
				}
			}
		}
		flag2 = true;
	}
	if (flag == true && flag2 == true && flag3 == true) {
		formObj.submit();
	}
}
function slotVadlidation() {
	formname = frames[1].document.forms[0];
	v_p_fr_date1 = parseInt(formname.p_fr_date1.value);
	v_p_to_date1 = parseInt(formname.p_to_date1.value);
	v_p_fr_date2 = parseInt(formname.p_fr_date2.value);
	v_p_to_date2 = parseInt(formname.p_to_date2.value);
	v_p_fr_date3 = parseInt(formname.p_fr_date3.value);
	v_p_to_date3 = parseInt(formname.p_to_date3.value);
	v_p_fr_date4 = parseInt(formname.p_fr_date4.value);
	v_p_to_date4 = parseInt(formname.p_to_date4.value);
	var s1 = formObj.p_fr_date1.value;
	var s2 = formObj.p_to_date1.value;
	if (s1 == "" && s2 == "") {
		frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_SLOT_VALUE", "ST");
		flag = false;
	} else {
		if (v_p_fr_date1 > v_p_to_date1) {
			flag = false;
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_SLOT_VALUE", "ST") + "in Slot 1";
		} else {
			if (v_p_fr_date2 > v_p_to_date2) {
				flag = false;
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_SLOT_VALUE", "ST") + "in Slot 2";
			} else {
				if (v_p_fr_date3 > v_p_to_date3) {
					flag = false;
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_SLOT_VALUE", "ST") + "in Slot 3";
				} else {
					if (v_p_fr_date4 > v_p_to_date4) {
						flag = false;
						messageFrame.location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_SLOT_VALUE", "ST") + "in Slot 4";
					} else {
						flag = true;
					}
				}
			}
		}
	}
}
/*function slotFocus()
{
formStockMovementReportCriteria.p_fr_date2.disabled=true;
formStockMovementReportCriteria.p_fr_date3.disabled=true;
formStockMovementReportCriteria.p_fr_date4.disabled=true;
formStockMovementReportCriteria.p_to_date2.disabled=true;
formStockMovementReportCriteria.p_to_date3.disabled=true;
formStockMovementReportCriteria.p_to_date4.disabled=true;
}

*/
function CheckNumMonth() {
	obj = frames[1].document.forms[0];
	formname = frames[1].document.forms[0];
	if (obj.P_EXC_MON.value >= 0 || obj.P_EXC_MON.value <= 12) {
		flag3 = true;
		return true;
	} else {
		flag3 = false;
		frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("INVALID_MONTH");
		alert(flag);
	}
}
/*
function datevalidation1(formname,code_val)
{
	
	code_value=parseInt(code_val);
	
	if(code_value==1)
	{
		x=formname.p_fr_date1.value;
		y=formname.p_to_date1.value;
		v_p_fr_date1=parseInt(formname.p_fr_date1.value);
		v_p_to_date1=parseInt(formname.p_to_date1.value);
	
		if( isNaN(x) ==false && isNaN(y) ==false) 
		{	
		

			if(v_p_fr_date1 < v_p_to_date1)
			{
			formname.p_fr_date2.disabled=false;
			formname.p_fr_date2.focus();
			flag=true;
			}
			else if(v_p_fr_date1 =="" && v_p_to_date1=="")
			{
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
			flag=false;
			}
			else
			{
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
			flag=false;
			}

		}
		else
		{
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_MONTH_VALUE");
		}
	
			code_value=0;
				if(flag==true)
				{
				formname.p_fr_date1.disabled=true;
				formname.p_to_date1.disabled=true;
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
				}

	}
	
}

	
function datevalidation2(formname,code_val)
{
	code_value=parseInt(code_val);

		v_p_fr_date2=parseInt(formname.p_fr_date2.value);
		x2=formname.p_fr_date2.value;

		if(code_value==2 && x2!=="")
		{
			if( isNaN(x2)==false )
			{
				code_value=0;
				if ((v_p_to_date1 < v_p_fr_date2)  || (v_p_fr_date2 < v_p_fr_date1))
				{
					formname.p_to_date2.disabled=false;
					formname.p_to_date2.focus();
					flag=true;
				}
				else
				{
					
					parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
					flag=false;
				}
			}
			else
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_MONTH_VALUE");

			code_value=0;
		}
	
}


function datevalidation3(formname,code_val)
{

	code_value=parseInt(code_val);
	v_p_to_date2=parseInt(formname.p_to_date2.value);
	x3=formname.p_to_date2.value;
			
		if(code_value==3 && x3!="")
		{
			if(isNaN(x3) ==false)
			{
				code_value=0;
				if( (v_p_fr_date2 < v_p_to_date2) && (v_p_to_date1 < v_p_fr_date2) )
				{

				formname.p_fr_date3.disabled=false;
				formname.p_fr_date3.focus();
				flag=true;
				}
				else if ( (v_p_fr_date2 < v_p_fr_date1) && (v_p_to_date2 < v_p_fr_date1) && (v_p_to_date2 > 			v_p_fr_date2) )
				{

				formname.p_fr_date3.disabled=false;
				formname.p_fr_date3.focus();
				flag=true;
				}
				else
				{
					
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
				flag=false;
				}
		}
		else
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_MONTH_VALUE");

				code_value=0;
				if(flag==true)
				{
				formname.p_fr_date2.disabled=true;
				formname.p_to_date2.disabled=true;
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
				}
				
	}
}

function datevalidation4(formname,code_val)
{
	code_value=parseInt(code_val);
	v_p_fr_date3=parseInt(formname.p_fr_date3.value);
	x4=formname.p_fr_date3.value;

		if(code_value==4 && x4!="")
		{
				if( isNaN(x4)==false )
				{
					code_value=0;
					if(v_p_to_date2 < v_p_fr_date3)
					{
					formname.p_to_date3.disabled=false;
					formname.p_to_date3.focus();
					flag=true;
					}
					else if ( v_p_fr_date3 < v_p_fr_date2 )
					{
					formname.p_to_date3.disabled=false;
					formname.p_to_date3.focus();
					flag=true;
					}
					else
					{
					parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
					flag=false;
					}
			}
			else
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
			//alert("Invalid slot value");
			code_value=0;


	}
}

function datevalidation5(formname,code_val)
{
	code_value=parseInt(code_val);
	v_p_to_date3=parseInt(formname.p_to_date3.value);
	x5=formname.p_to_date3.value;

		if(code_value==5 && x5!="")
		{
			if( isNaN(x5)==false )
			{
				code_value=0;
					if( (v_p_fr_date3 < v_p_to_date3) &&(v_p_fr_date3 < v_p_fr_date2)  && (v_p_to_date3 < v_p_fr_date2) )
					{
					formname.p_fr_date4.disabled=false;
					formname.p_fr_date4.focus();
					flag=true;
					}
					else if ( (v_p_fr_date3 > v_p_to_date2) && (v_p_to_date3 > v_p_fr_date3) )
					{
					formname.p_fr_date4.disabled=false;
					formname.p_fr_date4.focus();
					flag=true;
					}
					else
					{
					parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
					flag=false;
					}
			}
			else
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
					code_value=0;

					if(flag==true)
					{
					formname.p_fr_date3.disabled=true;
					formname.p_to_date3.disabled=true;
					parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
					}
		}
}


	function datevalidation6(formname,code_val)
	{
	code_value=parseInt(code_val);
	v_p_fr_date4=parseInt(formname.p_fr_date4.value);
	x6=formname.p_fr_date4.value;

		if(code_value==6 && x6!="")
		{
			if( isNaN(x6)==false )
			{
				code_value=0;
				if( ( v_p_fr_date4 > v_p_to_date3)  || (v_p_fr_date4 < v_p_fr_date3) )
				{
					formname.p_to_date4.disabled=false;
					formname.p_to_date4.select();
					formname.p_to_date4.focus();
				}
				else if(v_p_fr_date3 > v_p_fr_date3)
					{
						parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
						flag=false;
					}
					code_value=0;
		
			}
			else
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_MONTH_VALUE");
				code_value=0;
	}
	}


	
	
	function datevalidation7(formname,code_val)
	{
	code_value=parseInt(code_val);
	v_p_to_date4=parseInt(formname.p_to_date4.value);
	x7=formname.p_to_date4.value;

	if(code_value==7 && x7!="")
	  {
			if(isNaN(x7)==false )
			{
				code_value=0;
				if((v_p_fr_date4 < v_p_to_date4) && (v_p_fr_date4 > v_p_to_date3))
				{
					flag=true;
				}
				else if( (v_p_fr_date4 < v_p_fr_date3) &&  (v_p_to_date4 < v_p_fr_date3) && (v_p_to_date4 > v_p_fr_date4) )
				{
					flag=true;
				}
				else if( (v_p_to_date4 < v_p_fr_date4) )
				{
					flag=false;
				}
				else
				{
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
				flag=false;
				}
			}
			else
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num="+getMessage("INVALID_SLOT_VALUE");
				code_value=0;

				if(flag=true)
				  {
					formname.p_fr_date4.disabled=true;
					formname.p_to_date4.disabled=true;
					parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
				  }
	
	}
				//alert(flag);
	}







/*

function setReportStoreId()
{
   
  if(document.formReportStore.p_report_type.value=="IC")
   {
     document.formStockMovementReportCriteria.p_report_id.value="STBSTKS1" ;
   }else if(document.formStockMovementReportCriteria.p_report_type.value=="BI")
	   {
      document.formStockMovementReportCriteria.p_report_id.value="STBSTKS2" ; 
   }else if(document.formStockMovementReportCriteria.p_report_type.value=="BS")
	   {
      document.formStockMovementReportCriteria.p_report_id.value="STBSTKS3" ; 
   }else if(document.formStockMovementReportCriteria.p_report_type.value=="IB")
	   {
      document.formStockMovementReportCriteria.p_report_id.value="STBSTKS4" ; 
   }else if(document.formStockMovementReportCriteria.p_report_type.value=="SB")
	   {
      document.formStockMovementReportCriteria.p_report_id.value="STBSTKS5" ; 
   }else if(document.formStockMovementReportCriteria.p_report_type.value=="BL")
	   {
      document.formStockMovementReportCriteria.p_report_id.value="STBSTKS6" ; 
   }
}

function setReportItemId()
{
  
  if(document.formReportItem.p_report_type.value=="1")
   {
     document.formReportItem.p_report_id.value="STBITEMS" ;
   }else {
      document.formReportItem.p_report_id.value="STBITMDT" ; 
  }
  }

*/


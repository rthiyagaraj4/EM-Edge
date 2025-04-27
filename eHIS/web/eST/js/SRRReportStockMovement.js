 
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
	if (obj.value == "STBMOVIT") {
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
function searchCodeItem(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.item.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeStore(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchCodeItemClass(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.ItemClass.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function searchAlphaCode(obj) {
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
	returnedValues = CommonLookup(getLabel("Common.AlphaCode.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}
}
function run() {
	formObj = f_query_add_mod.document.formStockMovementReportCriteria;
	
	//if (s1 == "" && s2 == "") {
	//	frames[2].location.href = "../../eCommon/jsp/error.jsp?error_value=0&err_num=" + getMessage("CANNOT_BE_ZERO", "Common")
	//	flag = false;
	//}


	

	if (f_query_add_mod.document.formStockMovementReportCriteria) {
	//	CheckNumMonth();
	//	slotVadlidation();

/*
		var errorPage = "../../eCommon/jsp/error.jsp";
		var arrayObject = new Array(formObj.p_fr_date1 ,formObj.p_to_date1);
		//var arrayObject = new Array(formObj.p_dt_to );
		var names = new Array(getLabel("Common.Slot.label", "Common"),getLabel("Common.Slot.label", "Common"));
		var blankObject = checkSTFields(arrayObject, names, messageFrame, errorPage);
		if (blankObject != true) {
		return;
		}
		*/
		var s1 = formObj.p_fr_date1.value;
		var s5 = formObj.p_to_date1.value;

		var s2 = formObj.p_fr_date2.value;
		var s3 = formObj.p_fr_date3.value;
		var s4 = formObj.p_fr_date4.value;
		var s6 = formObj.p_to_date2.value;
		var s7 = formObj.p_to_date3.value;
		var s8 = formObj.p_to_date4.value;  
		var s9 = formObj.p_fr_st_code.value;  
		var s10 = formObj.P_MOV_CAL.value;  

	 if(s1!="") {
		var flag = ChkDate(formObj.p_fr_date1);
			if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}
	 
	 }


	 
	  if(s2!="") {
	 	var flag = ChkDate(formObj.p_fr_date2);
		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}


	}
	  
	  if(s3!="") {
		var flag = ChkDate(formObj.p_fr_date3);


		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}
	}
	  
	  if(s4!="") {
		var flag = ChkDate(formObj.p_fr_date4);

		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}
	}
	  
	  if(s5!="") {
		var flag = ChkDate(formObj.p_to_date1);

		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}
	}
	  
	  if(s6!="") {
		var flag = ChkDate(formObj.p_to_date2);

		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

	}
	  
	  if(s7!="") {
		var flag = ChkDate(formObj.p_to_date3);

		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}
	}
	  
	  if(s8!="") {
		var flag = ChkDate(formObj.p_to_date4); 

		if (!flag) {

		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+getMessage("INVALID_DATE_FMT", "ST");
			return false;
		}

	}
	  

	 var error = getMessage("CAN_NOT_BE_BLANK", "common");
		error = error.replace("$", getLabel("Common.StoreCodeFrom.label", "Common"));
		if(s10=="3")
         {
						

		if (s9 == "" ) {

		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + error;
			return false;
		}
   }
		


		 var error = getMessage("CAN_NOT_BE_BLANK", "common");
		error = error.replace("$", getLabel("Common.Slot.label", "Common") + 1);
		if (s1 == "" || s5 == "") {
		 messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" + error;
			return false;
		}


		
		if (isValidFromToField(formObj.p_fr_st_code, formObj.p_to_st_code, STRING, getLabel("Common.StoreCode.label", "Common"), messageFrame)) {
			if (isValidFromToField(formObj.p_fm_item_code, formObj.p_to_item_code, STRING, getLabel("Common.ItemCode.label", "Common"), messageFrame)) {
				//if (isValidFromToField(formObj.p_fm_item_class, formObj.p_to_item_class, STRING, getLabel("Common.ItemClass.label", "Common"), messageFrame)) {
					if (isValidFromToField(formObj.p_fr_alp_code, formObj.p_to_alp_code, STRING, getLabel("Common.AlphaCode.label", "Common"), messageFrame)) {
					formObj.submit();
					}
				}
			
		}
		
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

function searchsuppliercode(obj){


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
	argumentArray[0] = document.getElementById("SQL_AP_SUPPLIER_SELECT_LOOKUP").value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	returnedValues = CommonLookup(getLabel("Common.Supplier.label", "Common"), argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		obj.value = returnedValues[0];
	}

}

function loadmovementcalculateby(){
	/**
			* @Name - Priya 
			* @Date - 31/12/2009
			* @Inc# - IN017730
			* @Desc - For Movement calculate, if the selected value is ?Issue (Stock + Non Stock)? the field criteria ?Store Group?  and ?Store Code to? should be inactive
		*/
	if(document.formStockMovementReportCriteria.P_MOV_CAL.value=="3")
   {
		document.formStockMovementReportCriteria.P_STORE_GR.disabled=true;
		document.formStockMovementReportCriteria.p_to_st_code.disabled=true;
		document.formStockMovementReportCriteria.p_to_sr.disabled=true;
		document.getElementById("p_item_store_style").style.visibility = "visible";
		document.formStockMovementReportCriteria.P_STORE_GR.selectedIndex=0;
		document.formStockMovementReportCriteria.p_to_st_code.value="";
   }
   else
	{
       document.formStockMovementReportCriteria.P_STORE_GR.disabled=false;
		document.formStockMovementReportCriteria.p_to_st_code.disabled=false;
		document.formStockMovementReportCriteria.p_to_sr.disabled=false;
		document.getElementById("p_item_store_style").style.visibility = "hidden";



	}
}

/**
* @Name - Priya
* @Date - 31/12/2009
* @Inc# - IN017730
* @Desc - Commented the function clearMultipleForm() as no need to clear the form on change of 'Movement calculate by' 
**/
/*
function clearMultipleForm() {
	if (document.formStockMovementReportCriteria != null){
			var formObject = document.formStockMovementReportCriteria;
			formObject.p_report_id.value="STBMOVIT";
			formObject.P_STORE_GR.value="";
			formObject.p_fr_st_code.value="";
			formObject.p_to_st_code.value="";
			formObject.P_DRUG_NDRUG.value="";
			formObject.p_fm_item_class.value="";
			formObject.p_fm_item_code.value="";
			formObject.p_to_item_code.value="";
			formObject.p_to_item_code.value="";
			formObject.p_fr_alp_code.value="";
			formObject.p_to_alp_code.value="";
			formObject.p_item_anal1_code.value="";
			formObject.p_item_anal2_code.value="";
			formObject.p_item_anal3_code.value="";
			formObject.p_item_anal3_code.value="";
			formObject.P_ANALY.value="";
			formObject.P_SUPPLIER.value="";
			formObject.P_EXC_MON.value="";
			formObject.P_COUNT.value="";
			formObject.P_COUNT_BY.value="";
			formObject.p_report_option.value="";
			formObject.P_ORDER_BY.value="";
			
			formObject.p_fr_date1.value="";
			formObject.p_fr_date2.value="";
			formObject.p_fr_date3.value="";
			formObject.p_fr_date4.value="";
			
			formObject.p_to_date1.value="";
			formObject.p_to_date2.value="";
			formObject.p_to_date3.value="";
			formObject.p_to_date4.value="";


	}
} */

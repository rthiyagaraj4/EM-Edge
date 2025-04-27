/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
14/03/2014    IN041644		Nijitha S		 	Prescription Authorization of Drugs Based on Rules					
18/03/2014    IN047785      Nijitha S			The Order Catalog lookup field defaults to 'All' even though no 'Order Category' and 'Order Type' values selected
18/03/2014    IN047776		Nijitha S			Order Authorization Overrule Setup
---------------------------------------------------------------------------------------------------------------
*/ 
var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;
var g_index			= 0;
var g_record_count;

function create()
{
	f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForAuthorisation.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	
}

function query()
{
	f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForAuthorisationQCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

function reset()
{
	if(f_query_add_mod.document.orderCatalogAuthoriseForm!=undefined){		
		var mode = f_query_add_mod.document.orderCatalogAuthoriseForm.mode.value; 
		if(mode ==1) {
			if(f_query_add_mod.document.orderCatalogAuthoriseForm) {
			
				var totalRows =f_query_add_mod.document.orderCatalogAuthoriseForm.totalRecords.value;
				for(var i=0;i<= totalRows; i++) 
				{
					if(!(typeof(eval("f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_desc"+i)) == 'undefined')) 
					{
						eval("f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_desc"+i).value="";
						var self=eval("f_query_add_mod.document.orderCatalogAuthoriseForm.order_type"+i);
						self.options[0].text="---Select---";
						self.options[0].value="";
						self.value="";
						eval("f_query_add_mod.document.orderCatalogAuthoriseForm.delete_row_check"+i).checked = false;
						eval("f_query_add_mod.document.orderCatalogAuthoriseForm.order_category"+i).selectedIndex=0;
						
					}	
				}			
			}else if(f_query_add_mod.document.forms[0]!=null){
				f_query_add_mod.document.forms[0].reset();
			}else{
				frames[0].location.reload();
				return false;
			}
		} 
		f_query_add_mod.document.forms[0].reset();
	}
	
}

function updatedata(upd_category_code, upd_order_type, upd_order_catalog_code, upd_postmortem_app, upd_postmortem_type, upd_allow_for_deceased,order_category_short_code,order_type_short_code,order_catalog_short_code){
	var MODE_UPDATE = 2;
	if(upd_allow_for_deceased == "Yes"){
		upd_allow_for_deceased = "Y";
	}
	else {
		upd_allow_for_deceased = "N";
	} 
	parent.f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForDeceased.jsp?mode='+MODE_UPDATE+'&upd_category_code='+upd_category_code+'&upd_order_type='+upd_order_type+'&upd_order_catalog_code='+upd_order_catalog_code+"&upd_postmortem_app="+upd_postmortem_app+"&upd_postmortem_type="+upd_postmortem_type+"&upd_allow_for_deceased="+upd_allow_for_deceased+'&order_category_short_code='+order_category_short_code +'&order_type_short_code='+order_type_short_code+'&order_catalog_short_code='+order_catalog_short_code;
}

function apply() {
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var mode = f_query_add_mod.document.orderCatalogAuthoriseForm.mode.value;
	if(mode == 2){
		eval(formApply(f_query_add_mod.document.orderCatalogAuthoriseForm,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		if(result) {
			onSuccess();
			var MODE_UPDATE = 2;
			var function_id = "OR_ORDER_OVERIDE_AUTHORISATION";
			f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForAuthorisationQCriteria.jsp?mode='+MODE_UPDATE+"&function_id="+function_id;
		}
	}
	else {
	if(f_query_add_mod.document.orderCatalogAuthoriseForm.totalRecords.value == 0) {
		var totalRecords = parseInt(f_query_add_mod.document.orderCatalogAuthoriseForm.totalRecords.value) + 1;
		
		f_query_add_mod.document.orderCatalogAuthoriseForm.totalRecords.value = totalRecords;
	}
	var formObj	= f_query_add_mod.document.orderCatalogAuthoriseForm;
	var	arrFields = new Array();
	var	arrNames = new Array();
	var arrPKFieldNames		=	new Array();
	arrFields[0] = "order_category";
	arrFields[1] = "duration_value";
	arrFields[2] = "duration_type";
		
	arrPKFieldNames[0] = "order_category";
	arrPKFieldNames[1] = "order_catalog_desc";
	arrPKFieldNames[2] = "order_type";
	arrPKFieldNames[3] = "duration_value";
	arrPKFieldNames[4] = "duration_type";
		
	arrNames[0] = getLabel("eOR.OrderCategoryCode.label","eOR");
	arrNames[1] = "Duration Value";
	arrNames[2] = "Duration Type";
				
	if(validMandFields(formObj,arrFields,arrNames,arrPKFieldNames)) {	
		eval(formApply(f_query_add_mod.document.orderCatalogAuthoriseForm,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		if(result) {
			onSuccess();
		}
	}
	}
}

function validMandFields(formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage) {
	/**
      * Initialize default values
      */
    if(startIndex==null)        startIndex      =   0;

    if(objMessageFrame==null)   objMessageFrame =   messageFrame;
	else messageFrame = objMessageFrame

    if(errorPage==null)         errorPage       =   "../../eCommon/jsp/MstCodeError.jsp";

    var fields              =   new Array();
    var names               =   new Array();
    var masterCodes         =   new Array();
    var arrPKFields         =   null;

    var notNullIndex        =   0;
    var currRowIndex        =   0;
    var masterIndex         =   0;
    var pkIndex             =   0;
    var uniqueFields        =   "";

    var totalRecords        =   f_query_add_mod.document.orderCatalogAuthoriseForm.totalRecords.value; 
    var totalColumns        =   arrFieldName.length;
    var totalPKColumns      =   arrPKFieldNames.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);
	totalRecords 			=	totalRecords + 1;
	
    /**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
      var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
			current_field   =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
			if(!(typeof(current_field)==="undefined"))
			{
				if( trimString(current_field.value)!="")
				{
						isNotNull       =   true;
						break;
				}
			}
		}
		currRowIndex                =   rowIndex + 1;
		arrPKFields                 =   new Array();
		pkIndex                     =   0;
		for(var i = 0;i<totalPKColumns;i++)
		{
			pk_field            =   eval("formObj."+arrPKFieldNames[i]+rowIndex);
			arrPKFields[pkIndex++]  =   pk_field;
		}
		for( var colIndex=0; colIndex<totalColumns; colIndex++ )
		{
			current_field           =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
			if(!(typeof(current_field)==="undefined")) 
			{
				if( (uniqueFields.indexOf(arrFieldName[colIndex])==-1) && (trimString(current_field.value)=="") )
				{
					fields [ notNullIndex ]     =   current_field;
					names  [ notNullIndex++ ]   =   arrLegends[colIndex]; 
					uniqueFields                +=  current_field.name + " " ;
				}
			}
		}
		    masterCodes [ masterIndex++ ]   =   arrPKFields;			
	}

    /**
      * If there are no values entered, the length will be zero, so alert and return.
      */

    if(masterCodes.length==0)
    {
		var error = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common");
        showErrorMessage(error,objMessageFrame,'','',errorPage);
        formObj.document.parentWindow.FocusFirstElement();
        return false;
    }
    /**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */

	var arrDuplicate        =   returnDuplicateCodes(masterCodes);
	
    /**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      */
	var duplicateCodes      =   arrDuplicate[0];
	
    /**
      * The second index of the array will contain duplicating primary key fields as an Array.
      */
    var duplicateField      =   arrDuplicate[1];

    /**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      */
    var duplicateCodesValue =   arrDuplicate[2];

    if(duplicateCodesValue==null)   duplicateCodesValue = "";
  
    var inputType           =   "text";
    var duplicateValue      =   "";

    /**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      */
    if(duplicateCodes!="" && !(duplicateCodesValue.match("---Select---"))) 
    {
        var duplicateCode       =   "";
        var firstIndex          =   duplicateCodes.indexOf(",");

        if(firstIndex==-1)
        {
            firstIndex          =   duplicateCodes.length;
        }

        var firstDuplicate      =   duplicateCodes.substring(0,firstIndex);
        var startingIndex       =   0;

        for(var i=0; i<duplicateField.length; i++)
        {
            duplicatePKFields   =   duplicateField[i];
			for(var pkIndex=0; pkIndex<duplicatePKFields.length; pkIndex++)
            {
                if( (pkIndex%totalPKColumns) < totalPKColumns )
                {
                    if(!(typeof(current_field)==="undefined")) 
					{
						duplicateCode += duplicatePKFields[pkIndex].value + ":";
					}
				}

                if( (pkIndex%totalPKColumns) == (totalPKColumns-1) )
                {
                    duplicateCode   =   duplicateCode.substring(0,duplicateCode.length-1);
					if(firstDuplicate==duplicateCode)
                    {
                        for(var j=startingIndex; j<=pkIndex; j++)
                        {
                            if( (pkIndex-startingIndex)<=totalPKColumns )
                            {
                                duplicatePKFields[j].className = "DUPLICATE";
                            }
                        }
                        startingIndex   =   pkIndex;
                    }
                    duplicateCode   =   "";
                }
            }
        }

        duplicatePKFields   =   duplicateField[0];

        if( duplicatePKFields[0].type=="select-one" )
        {
            inputType       =   "select-one";
        }

        var error_msg       =   getMessage("DUPLICATE_CODE_EXISTS","Common") + " : " ;

        if( inputType == "text" )
        {
            error_msg       +=  duplicateCodes;
        }
        else if( inputType == "select-one" )
        {
            error_msg       +=  duplicateCodesValue;
        }
        displayErrorMessage(error_msg,objMessageFrame,'',null,errorPage);

        if( inputType != "select-one" )
        {
            duplicatePKFields[0].select();
        }
        duplicatePKFields[0].focus();
        return false;
    }
	
    /**
      * Check for the mandatory fields, if anything is left out.
      * if anything left out, display the error message and return "false"
      * otherwise, return "true" to indicate the operation is success.
      */
	var firstNullObject     =   checkMandatoryFields( fields, names, objMessageFrame,errorPage);

    if(firstNullObject!=null)
    {
        firstNullObject.className = "DUPLICATE";
        firstNullObject.focus();
        return false;
    }
    else
    {
        return true;
    }
}	
/**
  * This function is used to return the duplicating primary key values, primary key fields,
  * and its descriptions in the case of select item.
  * The Syntax:         returnDuplicates( masterCodes )
  *
  * @param masterCodes  (*) -   represents the array of primary key columns ( which is in turn an array )
  *
  * @return arrDuplicate    -   returns an array of three values.
  *             @first      -   represents the duplicating primary key values
  *             @second     -   represents the array of duplicating primary key objects
  *             @third      -   represents the duplicating primary key text description in the display
  *                             in the case of the primary key column is a list item.
  */
        
function returnDuplicateCodes( masterCodes )
{
    var duplicateCodes      =   "";
    var duplicateCodesValue =   "";
    var duplicateField      =   new Array();
    var arrDuplicate        =   new Array();
    var enteredRecords      =   masterCodes.length;
    var dupIndex            =   0;

    var arrCurrPKFields     =   null;
    var arrNextPKFields     =   null;
    var booleanCurrPKFields =	"";
	var booleanNextPKFields =	"";
	/**
      * Check for the duplicate primary key columns / combination exists with the entered records
      */
     OUTERLOOP:
	for(var i=0; i<enteredRecords;  i++)
    {
       	arrCurrPKFields         =   masterCodes[i];
		INNERLOOP:
		for(var j=i+1; j<enteredRecords;  j++)
        {
            var duplicateExists =   true;
		    arrNextPKFields     =   masterCodes[j];
			BREAKLOOP:
			for( var pkIndex=0; pkIndex<arrNextPKFields.length; pkIndex++ )
            {
                booleanCurrPKFields = (arrCurrPKFields[i] == undefined);
				booleanNextPKFields = (arrNextPKFields[j] == undefined);
				if(!booleanCurrPKFields) 
				{
					if(!booleanNextPKFields)
					{	
						if( trimString(arrCurrPKFields[pkIndex].value) != trimString(arrNextPKFields[pkIndex].value) )
						{
							duplicateExists     =   false;
							break;
						}
					}
					else 
					{
						duplicateExists     =   false;
						break BREAKLOOP;
					}
				}
				else
				{
					break INNERLOOP;
				}	
            }

            if( duplicateExists )
            {
                var duplicatePKFields   =   new Array();
                var duplicateCode       =   "";
                for( var pkIndex=0; pkIndex<arrCurrPKFields.length; pkIndex++ )
                {
                    duplicatePKFields[duplicatePKFields.length] =   arrCurrPKFields[pkIndex];
                }
                duplicateField[dupIndex++]  =   duplicatePKFields;
                var duplicateCode       =   "";
                var duplicateCodeValue  =   "";
                for( var pkIndex=0; pkIndex<arrNextPKFields.length; pkIndex++ )
                {
                    duplicatePKFields[duplicatePKFields.length] =   arrNextPKFields[pkIndex];
                    if(arrNextPKFields[pkIndex].type=="select-one")
                    {
                        duplicateCodeValue  +=  arrNextPKFields[pkIndex].options(arrNextPKFields[pkIndex].selectedIndex).text + ":";
                    }
                    else
                    {
                        duplicateCodeValue  +=  arrNextPKFields[pkIndex].value + ":";
                    }
                    duplicateCode           +=  arrNextPKFields[pkIndex].value + ":";
                }
                if(duplicateCode.length>0)
                {
                    duplicateCode       =   duplicateCode.substring(0, duplicateCode.length-1);
                    duplicateCodeValue  =   duplicateCodeValue.substring(0, duplicateCodeValue.length-1);
                }
                duplicateField[dupIndex++]  =   duplicatePKFields;
                if(duplicateCodes.indexOf(duplicateCode)==-1) 
                {
                    duplicateCodes      +=  duplicateCode + ", "; 
                    duplicateCodesValue +=  duplicateCodeValue + ", ";
                }
            }
        }
    }
    if(duplicateCodes.length>0)
    {
        duplicateCodes      =   duplicateCodes.substring(0, duplicateCodes.length-2);
        duplicateCodesValue =   duplicateCodesValue.substring(0, duplicateCodesValue.length-2);
    }

    /**
      * Put the duplicating primary key values, primary key fields and
      * its descriptions in the return array and return it back.
      */
    arrDuplicate[0] =   duplicateCodes;
    arrDuplicate[1] =   duplicateField;
    arrDuplicate[2] =   duplicateCodesValue;

    return arrDuplicate;
}


function assignResult( _result,	_message, _flag ) {
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}

function onSuccess() {
	var mode = f_query_add_mod.document.orderCatalogAuthoriseForm.mode.value;
	

}

function formReload() {
	f_query_add_mod.location.reload();
}

function getOrderTypes(order_category, index)
{
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Or_orderCatalogForDeceasedBean\"";		
	xmlStr += " bean_name=\"eOR.OrderCatalogForDeceasedBean\"";		
	xmlStr += " p_action=\"LOAD_ORDER_TYPES\"";
	xmlStr += " p_order_category=\""+ order_category.value + "\" ";
	xmlStr += " p_language_id=\""+ document.getElementById("language_id").value + "\" ";
	xmlStr += " p_index=\""+index+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") ;
	xmlHttp.open( "POST", "OrderCatalogForDeceasedValidate.jsp", false );
	xmlHttp.send(xmlDoc) ;
	responseText = xmlHttp.responseText ;
	eval(responseText);
	
	g_index = index;
	
	if(eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_code" + index).value == "")
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_code" + index).value = "*ALL";
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_desc" + index).value = "All";
	}

function addOrderTypeList(code,value, rowNum)
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	var index =  0;
	eval("document.forms.orderCatalogAuthoriseForm.order_type" + rowNum + ".add(element)");		
}

function clearOrderTypeList( docObj, l_index ) 
{
	eval("document.forms.orderCatalogAuthoriseForm.order_type"+l_index+".length=0");
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval("document.forms.orderCatalogAuthoriseForm.order_type" + l_index +".add(opt)") ;
} 

async function catalogsearchOnClick(orderCatalogObj,order_category_obj,order_type_obj)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	var sql ="SELECT ORDER_CATALOG_CODE code,SHORT_DESC description FROM or_order_catalog where eff_status='E' and upper(ORDER_CATALOG_CODE) like upper(?) and  upper(SHORT_DESC) like upper(?) and upper(ORDER_CATEGORY) like upper('"+order_category_obj.value+"') ";
	if(order_type_obj.value!='*ALL')
		sql = sql +" and upper(ORDER_TYPE_CODE) like upper('"+order_type_obj.value+"') ";

	sql = sql +"ORDER BY  2";

	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=orderCatalogObj.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;
	retval=await CommonLookup(getLabel("Common.ordercatalog.label","Common"),argumentArray);
	
	var ret1=unescape(retval);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retval !=null && retval != ""){
		orderCatalogObj.value=arr[0];
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_desc" + g_index).value = arr[1];
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_code" + g_index).value = arr[0];
	}
	if(retval =="" && order_type_obj.value!=''){//IN047785
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_code" + g_index).value = "*ALL";
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.order_catalog_desc" + g_index).value = "All";
	}

}
function addRow(index1) {
	var	formObj	= document.orderCatalogAuthoriseForm.table_Id;
	var tableID = formObj.value;
	var table = document.getElementById(tableID);
   	var rowCount = table.rows.length;
	g_record_count = rowCount;
	
	var row = table.insertRow(rowCount);
	order_category  = row.insertCell(0);
	var tempVal0 = table.rows[0].cells[0].innerHTML;
	
	tempVal0 = tempVal0.replaceAll("order_category0","order_category" + index1); // replace name
//	console.log(tempVal0);
	//tempVal0.replace("order_category0","order_category" + index1); // replace id
	tempVal0 = tempVal0.replace("getOrderTypes(order_category" + index1 +",0)","getOrderTypes(order_category" + index1 +"," + index1 + ")");
	order_category.innerHTML = tempVal0;
	//order_category.childNodes[0].selectedIndex = 0;
	var selectOrderCategory = row.querySelector('select[name="order_category' + index1 + '"]');
    if (selectOrderCategory) {
        selectOrderCategory.selectedIndex = 0;
    }
	
	order_type  = row.insertCell(1);
	order_type.innerHTML  = table.rows[0].cells[1].innerHTML.replaceAll("order_type0","order_type" + index1);
	
	order_catalog_desc  = row.insertCell(2);
	var tempVal2 = table.rows[0].cells[2].innerHTML;
	tempVal2 = tempVal2.replace("order_catalog_desc0","order_catalog_desc" + index1);
	tempVal2 = tempVal2.replace("order_catalog_code0","order_catalog_code" + index1);
	tempVal2 = tempVal2.replace("catalogsearchOnClick(order_catalog_desc0,order_category0,order_type0)","catalogsearchOnClick(order_catalog_desc" + index1 + ",order_category"+index1+",order_type"+index1 + ")");
	tempVal2 = tempVal2.replace("onclick=catalogsearchOnClick(order_catalog_desc0,order_category0,order_type0)","onClick=catalogsearchOnClick(order_catalog_desc" + index1 + ",order_category"+index1+",order_type"+index1 + ")");
	tempVal2  = tempVal2.replace("catalogSearch", "catalogSearch" + index1);
	order_catalog_desc.innerHTML = tempVal2;
	//order_catalog_desc.childNodes[0].value = "";
   var inputOrderCatalogDesc = row.querySelector('input[name="order_catalog_desc' + index1 + '"]');
    if (inputOrderCatalogDesc) {
        inputOrderCatalogDesc.value = "";
    }
    
	duration_value  = row.insertCell(3);
	var tempVal3 = table.rows[0].cells[3].innerHTML;
	tempVal3 = tempVal3.replace("duration_value0","duration_value" + index1);
	duration_value.innerHTML  = tempVal3;
	//duration_value.childNodes[0].value = "";
	var inputDurationValue = row.querySelector('input[name="duration_value' + index1 + '"]');
    if (inputDurationValue) {
        inputDurationValue.value = "";
    }
    
	duration_type  = row.insertCell(4);
	var tempVal4 = table.rows[0].cells[4].innerHTML;
	tempVal4 = tempVal4.replace("duration_type0","duration_type" + index1);
	duration_type.innerHTML = tempVal4;
	//duration_type.childNodes[0].value = "";
	 var inputDurationType = row.querySelector('input[name="duration_type' + index1 + '"]');
	    if (inputDurationType) {
	        inputDurationType.value = "";
	    }
	
	delete_row_check = row.insertCell(5);
	delete_row_check.innerHTML  = table.rows[0].cells[5].innerHTML.replace("delete_row_check0","delete_row_check" + index1);
	delete_row_check.align="center";
	delete_row_check.childNodes[0].checked = false;
	
	parent.f_query_add_mod.document.orderCatalogAuthoriseForm.totalRecords.value = index1;
	
	/*var self=eval("document.orderCatalogAuthoriseForm.order_type"+index1);
	self.options[0].text="---Select---";
	self.options[0].value="";
	self.value="";
	eval("document.orderCatalogAuthoriseForm.duration_value"+index1).value="";
	eval("document.orderCatalogAuthoriseForm.duration_type"+index1).value="";*/
	var self = document.orderCatalogAuthoriseForm['order_type' + index1];
	if (self) {
        self.options[0].text = "---Select---";
        self.options[0].value = "";
        self.value = "";
    }
    
    var durationValue = document.orderCatalogAuthoriseForm['duration_value' + index1];
    if (durationValue) {
        durationValue.value = "";
    }
    
    var durationType = document.orderCatalogAuthoriseForm['duration_type' + index1];
    if (durationType) {
        durationType.value = "";
    }
}

function deleteRow()
{
	var	formObj	= document.orderCatalogAuthoriseForm.table_Id;
	var tableID = formObj.value;
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var totalChecked = 0;
	for(var j=0; j<rowCount; j++) 
	{
		var row = table.rows[j];
			//IN047776 Starts
			/*var chkbox = eval("document.orderCatalogAuthoriseForm.delete_row_check"+0);
			if(null != chkbox && true == chkbox.checked) 
			{
				var self=eval("document.orderCatalogAuthoriseForm.order_type"+0); 
				self.options[0].text="---Select---";
				self.options[0].value="";
				self.value="";
				eval("document.orderCatalogAuthoriseForm.duration_value"+0).value=""; 
				eval("document.orderCatalogAuthoriseForm.duration_type"+0).value=""; 
				eval("document.orderCatalogAuthoriseForm.delete_row_check"+0).checked = false; 
				eval("document.orderCatalogAuthoriseForm.order_catalog_desc"+0).value="";
				var self1=eval("document.orderCatalogAuthoriseForm.order_category"+0); 
				self1.options[0].text="---Select---";
				self1.options[0].value="";
				self1.value="";
				totalChecked++;
			}*/
			//IN047776 Ends
		//var chkbox1 = row.cells[5].childNodes[0];
		var chkbox = row.cells[5].querySelector('input[type="checkbox"]');
		if(null != chkbox && true == chkbox.checked) {
			totalChecked++;
		}
	}
	
	if(totalChecked == rowCount) {
	
	}
	if(totalChecked >= 1) 
	{
		var confirm_val= window.confirm(getMessage("DELETE ROWS","OR"));
		if(confirm_val) 
		{
			//IN047776 Starts
			var chkboxMainIndex = eval("document.orderCatalogAuthoriseForm.delete_row_check"+0);
			if(null != chkboxMainIndex && true == chkboxMainIndex.checked) 
			{
				var self=eval("document.orderCatalogAuthoriseForm.order_type"+0); 
				self.options[0].text="---Select---";
				self.options[0].value="";
				self.value="";
				eval("document.orderCatalogAuthoriseForm.duration_value"+0).value=""; 
				eval("document.orderCatalogAuthoriseForm.duration_type"+0).value=""; 
				eval("document.orderCatalogAuthoriseForm.delete_row_check"+0).checked = false; 
				eval("document.orderCatalogAuthoriseForm.order_catalog_desc"+0).value="";
				var self1=eval("document.orderCatalogAuthoriseForm.order_category"+0); 
				self1.options[0].text="---Select---";
				self1.options[0].value="";
				self1.value="";
			} 
			//IN047776 Ends
			for(var i=rowCount-1; i>=1; i--) 
			{
				var row = table.rows[i];
				//var chkbox = row.cells[5].childNodes[0];
				var chkbox = row.cells[5].querySelector('input[type="checkbox"]');
				if(null != chkbox && true == chkbox.checked) 
				{

					table.deleteRow(i);
					//rowCount--;
					//i--;
				}
			}
		}
	}
} 

function deleteRecords(objValue,obj)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Or_orderCatalogForAuthorisationBean\"";		
	xmlStr += " bean_name=\"eOR.OrderCatalogForAuthorisationBean\"";		
	xmlStr += " p_action=\"DELETE_RECORDS\"";

	l_task = "";

	if(obj.checked)
		l_task  = "ADD";
	else
		l_task  = "REMOVE";

	xmlStr += " p_task=\""+ l_task + "\" ";
	xmlStr += " p_delete_records=\""+ objValue + "\" ";
	xmlStr += " p_language_id=\""+ document.getElementById("language_id").value + "\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "OrderCatalogForDeceasedValidate.jsp", false );
	xmlHttp.send(xmlDoc) ;
	responseText = xmlHttp.responseText ;
	eval(responseText);
}
 function chkValue()
{	
	if(eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.allow_for_deceased" + g_index).checked ==true){
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.allow_for_deceased" + g_index).value = "Y";
		parent.f_query_add_mod.document.orderCatalogAuthoriseForm.upd_allow_for_deceased.value = "Y";
		parent.f_query_add_mod.document.orderCatalogAuthoriseForm.deceased_check_yn.value = "Y";
	}
	else { 
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.allow_for_deceased" + g_index).value = "N";
		parent.f_query_add_mod.document.orderCatalogAuthoriseForm.upd_allow_for_deceased.value = "N";
		parent.f_query_add_mod.document.orderCatalogAuthoriseForm.deceased_check_yn.value = "N";		
	}
		
}
function resetRowValue() 
{
	if((eval("document.orderCatalogAuthoriseForm.order_category"+g_index).value) == "") {
		var self=eval("document.orderCatalogAuthoriseForm.order_type"+g_index);
		self.options[0].text="---Select---";
		self.options[0].value="";
		self.value="";
		eval("document.orderCatalogAuthoriseForm.duration_value"+g_index).value="";
		eval("document.orderCatalogAuthoriseForm.duration_type"+g_index).value="";
		eval("document.orderCatalogAuthoriseForm.delete_row_check"+g_index).checked = false;
		eval("document.orderCatalogAuthoriseForm.order_catalog_desc"+g_index).value="";
	}
}

function deleteRowValue(){
	if(eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.delete_row_check" + g_index).checked ==true)
	{
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.delete_row_check" + g_index).value = "Y";
	}
	else
	{ 
		eval("parent.f_query_add_mod.document.orderCatalogAuthoriseForm.delete_row_check" + g_index).value = "N";
	}
		
}
function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/**************functions used for "Auto Close Period"***************************/
function CheckSpecCharsCols(event){
    var strCheck = '123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function checkPositiveNumber(obj) {  
   var obj_value = obj.value;    
   var obj_length = obj_value.length;
	if(obj.value == ""){
		return true;
	}
	if(obj != null ){
		if(obj_value > 0){
			return true;
		}else{
			obj.value= ""
			obj.focus();
			var message  = getMessage('INVALID_POSITIVE_NUMBER','common');
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false;
		}
	}else{
		return true;
	}
}

function updatedata(order_category_desc, order_type_desc, order_catalog_desc, upd_duration_value, upd_duration_type,dur_type_code,upd_category_code,upd_order_type,upd_order_catalog_code){

	//alert(order_catalog_desc);
	var MODE_UPDATE = 2;
	parent.f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForAuthorisation.jsp?mode='+MODE_UPDATE+'&order_category_desc='+order_category_desc+'&order_type_desc='+order_type_desc+'&order_catalog_desc='+order_catalog_desc+'&upd_duration_value='+upd_duration_value+'&upd_duration_type='+upd_duration_type+'&upd_duration_type_code='+dur_type_code+'&upd_category_code='+upd_category_code+'&upd_order_type='+upd_order_type+'&upd_order_catalog_code='+upd_order_catalog_code;
}

function updateDurationValue(obj){
	document.orderCatalogAuthoriseForm.upd_duration_value.value = obj.value;
}

function updateDurationType(obj){
	document.orderCatalogAuthoriseForm.upd_duration_type.value = obj.value;
}
/**************end of functions used for "Auto Close Period"***************************/

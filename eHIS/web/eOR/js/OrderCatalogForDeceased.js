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
07/11/2012		IN036060		Karthi L		avoid to duplicate column select values
15/11/2012		IN036069		Karthi L		delete option for newly added rows
20/11/2012		IN036352		Karthi L		enable to remove first row
26/11/2012		IN036465		Karthi L		Unit test issue
20/12/2013		IN045873		Ramesh G		Bru-HIMS-CRF-348.2- 45197/04
20/12/2013		IN045880		Ramesh G		Bru-HIMS-CRF-348.2- 45197/05
31/12/2013		IN046149		Ramesh G		Bru-HIMS-CRF-348.2- 45197/11
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
	f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForDeceased.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	
}

function query()
{
	f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForDeceasedQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

function reset()
{
	if(f_query_add_mod.document.orderCatalogRuleForm!=undefined){
		var mode = f_query_add_mod.document.orderCatalogRuleForm.mode.value; //IN036465 added 22-11-2012	
		if(mode ==1) { //IN036465 added 22-11-2012
			if(f_query_add_mod.document.orderCatalogRuleForm) {
				var totalRows =f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value;
				/*if(totalRows == 0) commented for 36069
				{
					totalRows = 0;
				}
				else
				{
					totalRows = totalRows -1;
				} */
				for(var i=0;i<= totalRows; i++) 
				{
					if(!(typeof(eval("f_query_add_mod.document.orderCatalogRuleForm.order_catalog_desc"+i)) == 'undefined')) 
					{
						eval("f_query_add_mod.document.orderCatalogRuleForm.order_catalog_desc"+i).value="";
						eval("f_query_add_mod.document.orderCatalogRuleForm.allow_for_deceased"+i).checked=false;
						var self=eval("f_query_add_mod.document.orderCatalogRuleForm.order_type"+i);
						self.options[0].text="---Select---";
						self.options[0].value="";
						self.value="";
						eval("f_query_add_mod.document.orderCatalogRuleForm.postmortem_appl"+i).value="";
						eval("f_query_add_mod.document.orderCatalogRuleForm.postmortem_type"+i).value="";
						eval("f_query_add_mod.document.orderCatalogRuleForm.delete_row_check"+i).checked = false;
						eval("f_query_add_mod.document.orderCatalogRuleForm.order_category"+i).selectedIndex=0;
					}	
				}			
			}else if(f_query_add_mod.document.forms[0]!=null){
				f_query_add_mod.document.forms[0].reset();
			}else{
				frames[0].location.reload();
				return false;
			}
		} //IN036465 added 22-11-2012
		else if(mode == 2){ //IN036465 added 22-11-2012
			if(f_query_add_mod.document.orderCatalogRuleForm.g_allow_orders.value == "Y"){	
				f_query_add_mod.document.orderCatalogRuleForm.upd_allow_for_deceased.value = "Y";
				f_query_add_mod.document.orderCatalogRuleForm.allow_for_deceased0.checked = true; 
			}else{
				f_query_add_mod.document.orderCatalogRuleForm.upd_allow_for_deceased.value = "N";
				f_query_add_mod.document.orderCatalogRuleForm.allow_for_deceased0.checked = false; 
			}
		}
	}else{
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
	var mode = f_query_add_mod.document.orderCatalogRuleForm.mode.value;
	
	
	if(mode == 2){
		//IN045873 Start
		//if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "Both" ||f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value =="B") {
		if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "All" ||f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value =="B") {
		//IN045873 End.	
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value = "B";
		}
		else if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "Post Mortem Request" || f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "R"){
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value  = "R";
		}
		else if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "Post Mortem Record" || f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "Q"){
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value  = "Q";
		}
		else if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "Embalm Registration" || f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value == "E"){
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_app.value  = "E";
		}
		
		if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "Both" || f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "B") {
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value = "B";
			
		}
		else if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "Clinical Post Mortem" ||f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "C"){
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value  = "C";
		}
		else if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "Medico Legal Post Mortem" ||f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "M"){
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value  = "M";
		}
		//IN045873 Start.
		else if(f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "Not Applicable" ||f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value == "NA"){
			f_query_add_mod.document.orderCatalogRuleForm.upd_postmortem_type.value  = "E";
		}
		//IN045873 End.
		eval(formApply(f_query_add_mod.document.orderCatalogRuleForm,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		if(result) {
			onSuccess();
			var MODE_UPDATE = 2;
			var function_id = "OR_ORDER_CATALOG_DECEASED";
			f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogForDeceasedQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id;
		}
	}
	else {
		if(f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value == 0) {
			var totalRecords = parseInt(f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value) + 1;
			
			f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value = totalRecords;
		}
		var formObj	= f_query_add_mod.document.orderCatalogRuleForm;
		var	arrFields = new Array();
		var	arrNames = new Array();
		var arrPKFieldNames		=	new Array();
		arrFields[0] = "order_category";
		arrFields[1] = "postmortem_appl";
		arrFields[2] = "postmortem_type";
			
		arrPKFieldNames[0] = "order_category";
		arrPKFieldNames[1] = "order_catalog_desc";
		arrPKFieldNames[2] = "order_type";
		arrPKFieldNames[3] = "postmortem_appl";
		arrPKFieldNames[4] = "postmortem_type";
			
		arrNames[0] = getLabel("eOR.OrderCategoryCode.label","eOR");
		arrNames[1] = getLabel("eOR.PostMortemAppl.label","eOR");
		arrNames[2] = getLabel("eOR.PostMortemType.label","eOR");
				
		if(validMandFields(formObj,arrFields,arrNames,arrPKFieldNames)) {	
			eval(formApply(f_query_add_mod.document.orderCatalogRuleForm,OR_CONTROLLER));
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
//    else                        objMessageFrame =   null;
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

    var totalRecords        =   f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value; //LK
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
			if(!(typeof(current_field)==="undefined")) //LK
			{
				if( (uniqueFields.indexOf(arrFieldName[colIndex])==-1) && (trimString(current_field.value)=="") )
				{
					fields [ notNullIndex ]     =   current_field;
					names  [ notNullIndex++ ]   =   arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
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
//		showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
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
    if(duplicateCodes!="" && !(duplicateCodesValue.match("---Select---"))) //added && condition for IN036069
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
                    if(!(typeof(current_field)==="undefined")) //LK
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
                if(duplicateCodes.indexOf(duplicateCode)==-1) // next_master_code.value
                {
                    duplicateCodes      +=  duplicateCode + ", "; // next_master_code.value+", ";
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
	var mode = f_query_add_mod.document.orderCatalogRuleForm.mode.value;
	//formReload();  

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
	
	if(eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_code" + index).value == "")
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_code" + index).value = "*ALL";
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_desc" + index).value = "All";
	}

function addOrderTypeList(code,value, rowNum)
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	var index =  0;
	eval("document.forms.orderCatalogRuleForm.order_type" + rowNum + ".add(element)");		
}

function clearOrderTypeList( docObj, l_index ) 
{
	eval("document.forms.orderCatalogRuleForm.order_type"+l_index+".length=0");
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "*ALL" ;
	eval("document.forms.orderCatalogRuleForm.order_type" + l_index +".add(opt)") ;
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
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_desc" + g_index).value = arr[1];
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_code" + g_index).value = arr[0];
	}
	if(retval ==""){
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_code" + g_index).value = "*ALL";
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.order_catalog_desc" + g_index).value = "All";
	}

}

/*function addRow(index1) {
	alert(index1);
	var	formObj	= document.orderCatalogRuleForm.table_Id;
	
	var tableID = formObj.value;
	
	
	var table = document.getElementById(tableID);
   	var rowCount = table.rows.length;
	g_record_count = rowCount;
	var row = table.insertRow(rowCount);
	
	var order_category  = row.insertCell(0);
	var tempVal0 = table.rows[0].cells[0].innerHTML;
	tempVal0 = tempVal0.replace('name="order_category0"','name="order_category"'+ index1 + '"');
	tempVal0 = tempVal0.replace('getOrderTypes(order_category0,0)','getOrderTypes(order_category' + index1 + ',' + index1 + ')');
	order_category.innerHTML = tempVal0;
	if (order_category.childNodes.length > 0 && order_category.childNodes[0].nodeName === 'SELECT') {
	order_category.childNodes[0].selectedIndex = 0;
	}
	
	var order_type  = row.insertCell(1);
	var tempVal1 = table.rows[0].cells[1].innerHTML;
	tempVal1 = tempVal1.replace('name="order_type0"', 'name="order_type"' + index1 + '"');
	order_type.innerHTML  = tempVal1;
	//order_type.childNodes[0].selectedIndex = 0;
	
	
	var order_catalog_desc  = row.insertCell(2);
	var tempVal2 = table.rows[0].cells[2].innerHTML;
	tempVal2 = tempVal2.replace('name="order_catalog_desc0"','name=order_catalog_desc' + index1 + '"');
	tempVal2 = tempVal2.replace('name="order_catalog_code0"', 'name="order_catalog_code' + index1 + '"');
	tempVal2 = tempVal2.replace('catalogsearchOnClick(order_catalog_desc0,order_category0,order_type0)', 'catalogsearchOnClick(order_catalog_desc' + index1 + ',order_category' + index1 + ',order_type' + index1 + ')');
	tempVal2 = tempVal2.replace('onclick=catalogsearchOnClick(order_catalog_desc0,order_category0,order_type0)', 'onClick=catalogsearchOnClick(order_catalog_desc' + index1 + ',order_category' + index1 + ',order_type' + index1 + ')');
	tempVal2 = tempVal2.replace('name="catalogSearch"', 'name="catalogSearch' + index1 + '"');
	order_catalog_desc.innerHTML = tempVal2;
	if (order_catalog_desc.childNodes.length > 0 && order_catalog_desc.childNodes[0].nodeName === 'INPUT') {
	    order_catalog_desc.childNodes[0].value = "";
	}

	var postmortem_appl  = row.insertCell(3);
	var tempVal3 = table.rows[0].cells[3].innerHTML;
	tempVal3 = tempVal3.replace("name=postmortem_appl0/g","name=postmortem_appl" + index1);
	tempVal3 = tempVal3.replace("chagePostmortemType(this,'postmortem_type0')","chagePostmortemType(this,'postmortem_type"+index1+"')"); //IN045880
	postmortem_appl.innerHTML  = tempVal3;
	postmortem_appl.childNodes[0].value = "";
	
	var postmortem_type  = row.insertCell(4);
	var tempVal4 = table.rows[0].cells[4].innerHTML;
	tempVal4 = tempVal4.replace("name=postmortem_type0/g","name=postmortem_type" + index1);
	postmortem_type.innerHTML = tempVal4;
	postmortem_type.childNodes[0].value = "";
	
	var allow_for_deceased  = row.insertCell(5);
	var tempVal5 = table.rows[0].cells[5].innerHTML;
	tempVal5 = tempVal5.replace("name=allow_for_deceased0/g","name=allow_for_deceased" + index1);
	tempVal5 = tempVal5.replace("chkValue('0')","chkValue('"+index1+"')"); 
	allow_for_deceased.innerHTML  = tempVal5;
	allow_for_deceased.align="center";
	/*
	allow_for_deceased.innerHTML  = table.rows[0].cells[5].innerHTML.replace("name=allow_for_deceased0","name=allow_for_deceased" + index1);
	allow_for_deceased.align="center";
	//allow_for_deceased.childNodes[0].checked = false; commented for IN036465
	allow_for_deceased.childNodes[0].checked = true; // modified for IN036465
	*/
	/*var delete_row_check = row.insertCell(6);
	var tempVal6 = table.rows[0].cells[6].innerHTML;
	tempVal6 = tempVal6.replace('name="delete_row_check0"', 'name="delete_row_check' + index1 + '"');
	delete_row_check.innerHTML = tempVal6;
	delete_row_check.setAttribute('align', 'center');
	if (delete_row_check.childNodes.length > 0 && delete_row_check.childNodes[0].nodeName === 'INPUT') {
	    delete_row_check.childNodes[0].checked = false;
	}
	//delete_row_check.childNodes[0].disabled= false;
	
	//parent.f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value = g_record_count + 1; //LK
	//parent.f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value = index1;
	
	//eval("document.orderCatalogRuleForm.order_type"+index1).value="";
	/*var self=eval("document.orderCatalogRuleForm.order_type"+index1);
	self.options[0].text="---Select---";
	self.options[0].value="";
	self.value="";
	eval("document.orderCatalogRuleForm.postmortem_appl"+index1).value="";
	eval("document.orderCatalogRuleForm.postmortem_type"+index1).value="";*/
	/*var self = document.orderCatalogRuleForm["order_type" + index1];
    if (self) {
        self.options[0].text = "---Select---";
        self.options[0].value = "";
        self.value = "";
    }

    var postmortem_appl = document.orderCatalogRuleForm["postmortem_appl" + index1];
    if (postmortem_appl) {
        postmortem_appl.value = "";
    }

    var postmortem_type = document.orderCatalogRuleForm["postmortem_type" + index1];
    if (postmortem_type) {
        postmortem_type.value = "";
    }
} 
*/
function addRow(index1) {

    var formObj = document.orderCatalogRuleForm.table_Id;
    var tableID = formObj.value;
    var table = document.getElementById(tableID);
    var rowCount = table.rows.length;
    g_record_count = rowCount;
    var row = table.insertRow(rowCount);
    
    for (var i = 0; i < table.rows[0].cells.length; i++) {
        var cell = row.insertCell(i);
        cell.setAttribute('align', 'center');
        var tempVal = table.rows[0].cells[i].innerHTML;
        
        
        tempVal = tempVal.replace(/order_category0/g, 'order_category' + index1);
        tempVal = tempVal.replace(/order_type0/g, 'order_type' + index1);
        tempVal = tempVal.replace(/order_catalog_desc0/g, 'order_catalog_desc' + index1);
        tempVal = tempVal.replace(/order_catalog_code0/g, 'order_catalog_code' + index1);
        tempVal = tempVal.replace(/catalogsearchOnClick\(order_catalog_desc0,order_category0,order_type0\)/g, 'catalogsearchOnClick(order_catalog_desc' + index1 + ',order_category' + index1 + ',order_type' + index1 + ')');
        tempVal = tempVal.replace(/onclick=catalogsearchOnClick\(order_catalog_desc0,order_category0,order_type0\)/g, 'onClick=catalogsearchOnClick(order_catalog_desc' + index1 + ',order_category' + index1 + ',order_type' + index1 + ')');
        tempVal = tempVal.replace(/name="catalogSearch"/g, 'name="catalogSearch' + index1 + '"');
        tempVal = tempVal.replace(/postmortem_appl0/g, 'postmortem_appl' + index1);
        tempVal = tempVal.replace(/postmortem_type0/g, 'postmortem_type' + index1);
        tempVal = tempVal.replace(/chagePostmortemType\(this,'postmortem_type0'\)/g, "chagePostmortemType(this,'postmortem_type" + index1 + "')");
        tempVal = tempVal.replace(/name="allow_for_deceased0"/g, 'name="allow_for_deceased' + index1 + '"');
        tempVal = tempVal.replace(/chkValue\('0'\)/g, "chkValue('" + index1 + "')");
        tempVal = tempVal.replace(/name="delete_row_check0"/g, 'name="delete_row_check' + index1 + '"');
        
       
        cell.innerHTML = tempVal;
        
        
        if (cell.childNodes.length > 0) {
            var inputElement = cell.querySelector('input, select');
            if (inputElement) {
                if (inputElement.tagName === 'INPUT') {
                    inputElement.value = '';
                } else if (inputElement.tagName === 'SELECT') {
                    inputElement.selectedIndex = 0;
                }
            }
        }
    }
    
    
    parent.f_query_add_mod.document.orderCatalogRuleForm.totalRecords.value = index1;
}

function deleteRow() {
    var formObj = document.orderCatalogRuleForm.table_Id;
    var tableID = formObj.value;
    var table = document.getElementById(tableID);
    
    var rowCount = table.rows.length;
    var totalChecked = 0;
    
    for (var j = 0; j < rowCount; j++) {
        var row = table.rows[j];
        var chkbox = row.cells[6].querySelector('input[type="checkbox"]');
        
        if (chkbox && chkbox.checked === true) {
            
            var self = parent.f_query_add_mod.orderCatalogRuleForm.order_type0; 
            self.options[0].text = "---Select---";
            self.options[0].value = "";
            self.value = "";
            document.orderCatalogRuleForm.postmortem_appl0.value = "";
            document.orderCatalogRuleForm.postmortem_type0.value = "";
            document.orderCatalogRuleForm.allow_for_deceased0.checked = false;
            document.orderCatalogRuleForm.delete_row_check0.checked = false;
            document.orderCatalogRuleForm.order_catalog_desc0.value = "";
            
            var self1 = document.orderCatalogRuleForm.order_category0; 
            self1.options[0].text = "---Select---";
            self1.options[0].value = "";
            self1.value = "";
            
            totalChecked++;
        }
    }
    
    if (totalChecked === 0) {
    	alert('Please select at least one row to delete.');
        return;
    }
    
    if (totalChecked >= 1) {
        var confirm_val = window.confirm(getMessage("DELETE ROWS", "OR"));
        if (confirm_val) {
            for (var i = rowCount - 1; i >= 0; i--) {
                var row = table.rows[i];
                var chkbox = row.cells[6].querySelector('input[type="checkbox"]');
                if (chkbox && chkbox.checked === true) {
                    table.deleteRow(i);
                }
            }
        }
    }
}
/*
 function deleteRow()
{
	var	formObj	= document.orderCatalogRuleForm.table_Id;
	var tableID = formObj.value;
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var totalChecked = 0;
	var firstRowChecked = 0;
	// modified for IN036352
	for(var j=0; j<rowCount; j++) 
	{
		var row = table.rows[j];
		var chkbox = eval("document.orderCatalogRuleForm.delete_row_check"+0); //IN036362x
		if(null != chkbox && true == chkbox.checked) 
		{
		
			var self=eval("document.orderCatalogRuleForm.order_type"+0); //IN036362 - modified from g_index to 0 - Start
			self.options[0].text="---Select---";
			self.options[0].value="";
			self.value="";
			eval("document.orderCatalogRuleForm.postmortem_appl"+0).value=""; 
			eval("document.orderCatalogRuleForm.postmortem_type"+0).value=""; 
			eval("document.orderCatalogRuleForm.postmortem_type"+0).value=""; 
			eval("document.orderCatalogRuleForm.allow_for_deceased"+0).checked = false; 
			eval("document.orderCatalogRuleForm.delete_row_check"+0).checked = false; 
			eval("document.orderCatalogRuleForm.order_catalog_desc"+0).value="";
			var self1=eval("document.orderCatalogRuleForm.order_category"+0); //IN036362 - modified from g_index to 0 - END
			self1.options[0].text="---Select---";
			self1.options[0].value="";
			self1.value="";
			totalChecked++;
		}
		
		var chkbox1 = row.cells[6].childNodes[0];
		if(null != chkbox1 && true == chkbox1.checked) {
			totalChecked++;
		}
	}
	
	if(totalChecked == rowCount) {
	//	alert(" shouldnot delete ");
	}
	if(totalChecked >= 1) 
	{
		var confirm_val= window.confirm(getMessage("DELETE ROWS","OR"));
		if(confirm_val) 
		{
			for(var i=0; i<rowCount; i++) 
			{
				var row = table.rows[i];
				var chkbox = row.cells[6].childNodes[0];
				if(null != chkbox && true == chkbox.checked) 
				{

					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		}
	}
} 
*/
function deleteRecords(objValue,obj)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " bean_id=\"Or_orderCatalogForDeceasedBean\"";		
	xmlStr += " bean_name=\"eOR.OrderCatalogForDeceasedBean\"";		
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
	eval(responseText)
}

function catalogsearchOnBlur(orderCatalogObj)
{
}

function addRemoveRowClick()
{

}

 function chkValue(gindex)
{	
	if(eval("parent.f_query_add_mod.document.orderCatalogRuleForm.allow_for_deceased" + gindex).checked ==true){
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.allow_for_deceased" + gindex).value = "Y";
		parent.f_query_add_mod.document.orderCatalogRuleForm.upd_allow_for_deceased.value = "Y";
		parent.f_query_add_mod.document.orderCatalogRuleForm.deceased_check_yn.value = "Y";
		
	}
	else { 
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.allow_for_deceased" + gindex).value = "N";
		parent.f_query_add_mod.document.orderCatalogRuleForm.upd_allow_for_deceased.value = "N";
		parent.f_query_add_mod.document.orderCatalogRuleForm.deceased_check_yn.value = "N";		
		
	}
		
}
function resetRowValue() // added for IN036352
{
	if((eval("document.orderCatalogRuleForm.order_category"+g_index).value) == "") {
		var self=eval("document.orderCatalogRuleForm.order_type"+g_index);
		self.options[0].text="---Select---";
		self.options[0].value="";
		self.value="";
		eval("document.orderCatalogRuleForm.postmortem_appl"+g_index).value="";
		eval("document.orderCatalogRuleForm.postmortem_type"+g_index).value="";
		eval("document.orderCatalogRuleForm.postmortem_type"+g_index).value="";
		eval("document.orderCatalogRuleForm.allow_for_deceased"+g_index).checked = false;
		eval("document.orderCatalogRuleForm.delete_row_check"+g_index).checked = false;
		eval("document.orderCatalogRuleForm.order_catalog_desc"+g_index).value="";
	}
}

function deleteRowValue(){
	if(eval("parent.f_query_add_mod.document.orderCatalogRuleForm.delete_row_check" + g_index).checked ==true)
	{
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.delete_row_check" + g_index).value = "Y";
	}
	else
	{ 
		eval("parent.f_query_add_mod.document.orderCatalogRuleForm.delete_row_check" + g_index).value = "N";
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
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function checkPositiveNumber(obj) {  
   var obj_value = obj.value;    // checks for positive number greater than zero
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
//IN045880 Start.
function chagePostmortemType(obj,targetVal){	
	var obj_value = obj.value;
	//IN046149 Start.
	var len =  eval("document.forms[0]."+targetVal+".length") ;
	for(var i=0;i<len;i++)
	{
		eval('document.forms[0].'+targetVal+'.remove(\"'+targetVal+'\")') ;
	}
	/*if(obj_value=='E'){
		eval("document.forms[0]."+targetVal+".value='NA'");
		eval("document.forms[0]."+targetVal+".disabled='true'"); 
		
	}else{
		eval("document.forms[0]."+targetVal+".value=''");
		eval("document.forms[0]."+targetVal+".disabled=''");
	}*/
	if(obj_value=='E'){
		var tp = "Not Applicable" ;
		var opt = eval("document.createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "E" ;
		eval("document.forms[0]."+targetVal+".add(opt)") ;
		
	}else if(obj_value=='B'){
		var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
		var opt = eval("document.createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("document.forms[0]."+targetVal+".add(opt)") ;
		
		var tp1 = "Both" ;
		var opt1 = eval("document.createElement(\"OPTION\")") ;
		opt1.text = tp1 ;
		opt1.value = "B" ;
		eval("document.forms[0]."+targetVal+".add(opt1)") ;
		
		var tp2 = "Clinical Post Mortem" ;
		var opt2 = eval("document.createElement(\"OPTION\")") ;
		opt2.text = tp2 ;
		opt2.value = "C" ;
		eval("document.forms[0]."+targetVal+".add(opt2)") ;
		
		var tp3 = "Medico Legal Post Mortem" ;
		var opt3 = eval("document.createElement(\"OPTION\")") ;
		opt3.text = tp3 ;
		opt3.value = "M" ;
		eval("document.forms[0]."+targetVal+".add(opt3)") ;
		
		var tp4 = "Not Applicable" ;
		var opt4 = eval("document.createElement(\"OPTION\")") ;
		opt4.text = tp4 ;
		opt4.value = "E" ;
		eval("document.forms[0]."+targetVal+".add(opt4)") ;
		
	}else{
		var tp = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---" ;
		var opt = eval("document.createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("document.forms[0]."+targetVal+".add(opt)") ;
		
		var tp1 = "Both" ;
		var opt1 = eval("document.createElement(\"OPTION\")") ;
		opt1.text = tp1 ;
		opt1.value = "B" ;
		eval("document.forms[0]."+targetVal+".add(opt1)") ;
		
		var tp2 = "Clinical Post Mortem" ;
		var opt2 = eval("document.createElement(\"OPTION\")") ;
		opt2.text = tp2 ;
		opt2.value = "C" ;
		eval("document.forms[0]."+targetVal+".add(opt2)") ;
		
		var tp3 = "Medico Legal Post Mortem" ;
		var opt3 = eval("document.createElement(\"OPTION\")") ;
		opt3.text = tp3 ;
		opt3.value = "M" ;
		eval("document.forms[0]."+targetVal+".add(opt3)") ;
	}
	//IN046149 End.	
}
//IN045880 End.
/**************end of functions used for "Auto Close Period"***************************/

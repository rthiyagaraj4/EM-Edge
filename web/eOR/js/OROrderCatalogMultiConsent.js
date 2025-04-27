/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var record;
function populateOrderTypes(OrderCategory)
{
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var modeQuery = "test";
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	xmlStr ="<root><SEARCH " ;
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
	xmlStr += OrderCategory.name+"=\""+ OrderCategory.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OROrderCatalogMultiConsentFillOrderTypes.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&fill=OrderCategory",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);

	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	
	//top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentResultFrame.document.location.href="../../eCommon/html/blank.html";	
	//top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentResultHeaderFrame.document.location.href="../../eCommon/html/blank.html";

	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentResultFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentResultHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	
	
	
	getCancel();
}

function clearOCMultiConsentOrderType( docObj ) 
{
	var len = eval(docObj+".Order_Catalog_MultiConsent.order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".Order_Catalog_MultiConsent.order_type.remove(\"order_type\")") ;
	}
	var tp = "       --- "+getLabel("Common.defaultSelect.label","Common")+" ---       " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".Order_Catalog_MultiConsent.order_type.add(opt)") ;
}

function addorderTypeData2List(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.Order_Catalog_MultiConsent.order_type.add(element);
}

function search()
{
	var recordCheck="";//Added By  Channaveer B for issue number:IN21403
	var	formObj;
	if(record=="yes")
	{		
       formObj=parent.OROrderCatalogMultiConsentCriteriaFrame.document.Order_Catalog_MultiConsent;
       recordCheck="YES";//Added By  Channaveer B for issue number:IN21403
	}
	else
	{
	formObj	= document.Order_Catalog_MultiConsent ;
	recordCheck="NO";//Added By  Channaveer B for issue number:IN21403
	}
	var	fields = new Array ( formObj.order_category,formObj.order_type);
	var	names =	new	Array ("OrderCategory","OrderType");
	var orderCategory = formObj.order_category.value;
	var orderType = formObj.order_type.value;
	var catalogue = formObj.order_catalog.value;
	var radio1 = formObj.definitionSelected.value;
	var bean_id=document.forms[0].bean_id.value;
	var bean_name=document.forms[0].bean_name.value;
	if(radio1=="")
	{
		radio1 = "P";
	}
	if(parent.parent.checkFieldsofMst(fields,names, parent.parent.messageFrame))
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;

		var modeQuery = "search";
	
		xmlStr ="<root><SEARCH " ;
		xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
		xmlStr += "order_category"+"=\""+ orderCategory +"\" " ;
		xmlStr += "order_type"+"=\""+ orderType +"\" " ;
		xmlStr += "order_catalog"+"=\""+ catalogue +"\" " ;
		xmlStr += "definitionSelected"+"=\""+ radio1 +"\" " ;
		xmlStr += "recordCheck"+"=\""+ recordCheck +"\" " ;//Added By  Channaveer B for issue number:IN21403
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OROrderCatalogMultiConsentFillOrderTypes.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&fill=OrderCategory"+"&recordCheck="+recordCheck,false ) ;
		
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );	
	}
	
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eCommon/html/blank.html";	
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eCommon/html/blank.html";
}

function reset() 
{
	f_query_add_mod.OROrderCatalogMultiConsentCriteriaFrame.document.location.href="../../eOR/jsp/OROrderCatalogMultiConsentCriteria.jsp";
	f_query_add_mod.OROrderCatalogMultiConsentResultHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.OROrderCatalogMultiConsentResultFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eCommon/html/blank.html";	
	f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eCommon/html/blank.html";
}

function clearScreen()
{
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentCriteriaFrame.document.location.href="../../eOR/jsp/OROrderCatalogMultiConsentCriteria.jsp";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentResultHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentResultFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eCommon/html/blank.html";	
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function recordsNotFound(docObj)
{
	parent.parent.f_query_add_mod.document.location.href=parent.parent.f_query_add_mod.document.location.href;//This line added by Channaveer B for issue number:IN21403

	//commented by Channaveer B for issue number:IN21403
	/*parent.parent.f_query_add_mod.OROrderCatalogMultiConsentResultFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentResultHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));*/
	
}
function loadResultFrame()
{
	parent.OROrderCatalogMultiConsentResultHeaderFrame.location.href="../../eOR/jsp/OROrderCatalogMultiConsentResultHeader.jsp";
	parent.OROrderCatalogMultiConsentResultFrame.location.href="../../eOR/jsp/OROrderCatalogMultiConsentResult.jsp";
	//parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";commented by Channaveer B for issue number:IN21403
	
}

function loadAddEditDetails(obj,obj1,categoryDesc,orderTypeDesc)
{
	var orderTypeDesc = document.Order_Catalog_MultiConsent_Result.order_type_desc.value; 
	var categoryDesc = document.Order_Catalog_MultiConsent_Result.category_desc.value;
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eOR/jsp/OROrderCatalogMultiConsentAddEdit.jsp?catalog_code="+obj1+"&catalog_desc="+obj+"&categoryDesc="+categoryDesc+"&orderTypeDesc="+orderTypeDesc;
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eOR/jsp/OROrderCatalogMultiConsentAddEditHeader.jsp?categoryDesc="+categoryDesc+"&orderTypeDesc="+orderTypeDesc+"&catalog_desc="+obj+"&catalog_code="+obj1;
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eOR/jsp/OROrderCatalogMultiConsentButtons.jsp?catalog_code="+obj1;
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function getCancel()
{

/*	top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eCommon/html/blank.html";
	top.content.master_pages.f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eCommon/html/blank.html";*/
	parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditHeaderFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eCommon/html/blank.html";
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentButtonFrame.document.location.href="../../eCommon/html/blank.html";

}

function compareFields(fields, tempFields, names, messageFrame,disp_type,error_jsp)
{
	var errors = "" ;
    for( var i=0; i<fields.length; i++ ) 
	{
		if(fields[i].value==tempFields[i].value) 
		{
		}
		else
		{
			if (disp_type=="A")errors +=  "APP-000001 " + names[i] + " cannot have special characters..." + "\n" ;
			else if(disp_type=="M")errors += getMessage("OR_ORDER_CATALOG_MULTICONSENT","OR");
		}
	}
	if ( errors.length != 0 ) 
	{
		var loc_route = error_jsp+"?err_num="+errors;
        if (disp_type=="M")messageFrame.document.location.href=loc_route;
        else if (disp_type=="A")alert(errors);
            return false ;
    }
    return true ;
}

function Record()
{

	var formObj = parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit;
	var total = formObj.totalRecords.value;
	var count = 0;
	var descCount = 0;
	var befRegn = eval(formObj.befRegn.value);
	var befOrder = eval(formObj.befOrder.value);
	var formList = formObj.form_list.value;

	var befRegnCount = 0;
	var befOrderCount = 0;
	var selectCount = 0;
	var myCount=0;
	var myCount1=0;
	for(i = 0 ; i < total ; i++)
	{
		var flds=new Array(eval("formObj.consent_desc"+i));
		var name=new Array("Consent");
		var temp_flds=new Array(eval("formObj.temp_consent_desc"+i));
		var order_regn = new Array(eval("formObj.consent_stage"+i));
		var selectField = eval("formObj.select"+i);
		if(formList=='F' && flds[0].value!="")
		{
			descCount++;
		}
		if(formList=='V' && selectField.checked)
		{
			descCount++;
		}
		if(!selectField.checked && flds[0].value!="")
		{
			count++;
		}
		if(selectField.checked)
		{
			myCount++;
		}
		if(!selectField.checked)
		{
			myCount1++;
		}
		/*if(selectField.checked && flds[0].value=="")
		{
			myCount1++;
		}*/
		if (selectField.checked && flds[0].value!="")
		{	
			selectCount++;
		}
		if(order_regn[0].value=="A")
		{
			befOrderCount++;

		}
		else if(order_regn[0].value=="R")
		{
			befRegnCount++;

		}
		if(!compareFields(flds,temp_flds,name,parent.parent.messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
			flds[0].focus();
			return false
		}
	}
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();
	var startIndex = 0;
	var	result1 = false;
	var result2=false;
	//if(formList=='V')
	//descCount=myCount-selectCount;


	
	if(descCount > 0)
	{	
		if((befRegn==1 && befOrder==0) || (befRegn==0 && befOrder==1))
		{
			arrFieldName[0]			=	"consent_desc";
			arrLegends[0]			=	getLabel("Common.Consent.label","COMMON");

			arrPKFieldNames[0]		=	"consent_desc";
			resetDuplicateClass(formObj, arrPKFieldNames);
			result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,startIndex,parent.parent.messageFrame,"../../eCommon/jsp/MstCodeError.jsp");
		}
		//else if (befRegn==0 && befOrder > 0 && formList=='V') //Modified by Uma on 6/12/2009 for IN011392
		else if (formList=='V') 
		{

			arrFieldName[0]			=	"consent_desc";
			arrFieldName[1]			=	"consent_stage";
			arrLegends[0]			=	getLabel("Common.Consent.label","COMMON");
			arrLegends[1]			=	getLabel("Common.Stage.label","COMMON");

			arrPKFieldNames[0]		=	"consent_desc";

			resetDuplicateClass(formObj, arrPKFieldNames);
			//myCount=myCount-selectCount;
			myCount=descCount;
			result1=validateVariableField( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, parent.parent.messageFrame,"../../eCommon/jsp/MstCodeError.jsp");

		}
		else
		{
			arrFieldName[0]			=	"consent_desc";
			arrFieldName[1]			=	"consent_stage";

			arrLegends[0]			=	getLabel("Common.Consent.label","COMMON");
			arrLegends[1]			=	getLabel("Common.Stage.label","COMMON");

			arrPKFieldNames[0]		=	"consent_desc";
			resetDuplicateClass(formObj, arrPKFieldNames);
			result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,startIndex,parent.parent.messageFrame,"../../eCommon/jsp/MstCodeError.jsp");

		}
	}
	else
	{

		arrFieldName[0]			=	"consent_desc";
		arrLegends[0]			=	"Consent";

		arrPKFieldNames[0]		=	"consent_desc";
		resetDuplicateClass(formObj, arrPKFieldNames);
		result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,startIndex,parent.parent.messageFrame,"../../eCommon/jsp/MstCodeError.jsp");
	}
	
	if(result1)
	{
		var ordercount = eval (parseInt(befRegn) + parseInt(befOrder));




		if(befRegnCount!=befRegn || befOrderCount!=befOrder)
		{	
			if((befRegnCount < befRegn && formList=='F') || (befOrderCount < befOrder && formList == 'F'))
			{
				var errors = "" ;

				//errors =  getMessage("OR_ORDER_CATALOG_MULTICONSENT_MANDATORY","OR");
				errors =  getMessage("OR_ORDER_CATALOG_MULTI_CONSENT_MANDATORY","OR");
				errors =  errors.replace("$",befRegn+" "+"Record For BR"+",");
				errors =  errors.replace("#",befOrder+" "+"Record For BO");
				var loc_route = "../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
				messageFrame.document.location.href=loc_route;
				formObj.consent_desc0.focus();
				return false;
			}
		}
		
		if(count<=descCount && formList=='F')
		{
			eval(formApply(formObj,OR_CONTROLLER));
			var loc_route = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
			parent.parent.messageFrame.document.location.href=loc_route;
			
			if(resultGlobal) 
			{
				onSuccess();
				record="yes";
				search();	
			}
		}
		/*else
		{
			var errors = "" ;

			errors =  getMessage("OR_ORDER_CATALOG_MULTICONSENT_CHECKBOX","OR")
			var loc_route = "../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
			parent.parent.messageFrame.document.location.href=loc_route;
			formObj.consent_desc0.focus();
		}*/
			


		if(descCount>=0 && formList=='V')
		{
			

			var result2=callUncheck(total,formObj);
			if(result2)
			{
				eval(formApply(formObj,OR_CONTROLLER));
				var loc_route = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
				parent.parent.messageFrame.document.location.href=loc_route;
				if(resultGlobal) 
				{
					onSuccess();
					record="yes";
					search();	
				}
			}
		}
		
		
	}
}

function callUncheck(total,formObj)
{
var cnt=0;

	for(i=0;i<total;i++)
	{
		var select=eval("formObj.select"+i);
		if(select.checked)
		{
			cnt++;
		}
	}

	if(cnt==0)
	{
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
		alert(getMessage("ATLEAST_ONE_SELECTED","Common"));
		return false;
	}
	return true;
}


function validateVariableField( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage )
{
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

    var totalRecords        =   formObj.totalRecords.value;
    var totalColumns        =   arrFieldName.length;
    var totalPKColumns      =   arrPKFieldNames.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);
  
    /**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
        var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
            current_field   =   eval("formObj."+arrFieldName[colIndex]+rowIndex);

            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }

        if(isNotNull)
        {
            currRowIndex                =   rowIndex + 1;
            arrPKFields                 =   new Array();
            pkIndex                     =   0;

            for( var colIndex=0; colIndex<totalColumns; colIndex++ )
            {
                current_field           =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
				var selectField=eval("formObj.select"+rowIndex);
                if( (uniqueFields.indexOf(arrFieldName[colIndex])==-1) && selectField.checked && (trimString(current_field.value)=="") )
                {
                    fields [ notNullIndex ]     =   current_field;
                    names  [ notNullIndex++ ]   =   arrLegends[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
                    uniqueFields                +=  current_field.name + " " ;
                }

                if( colIndex < totalPKColumns )
                {
                    pk_field            =   eval("formObj."+arrPKFieldNames[colIndex]+rowIndex);
                    if( current_field.name == pk_field.name )
                    {
                        arrPKFields[pkIndex++]  =   pk_field;
                    }
                }
            }
            masterCodes [ masterIndex++ ]   =   arrPKFields;
        }
    }

    /**
      * If there are no values entered, the length will be zero, so alert and return.
      */


    if(masterCodes.length==0)
    {
			var error = getMessage("ATLEAST_ONE_RECORD_ENTERED","Common")
        showErrorMessage(error,objMessageFrame,'','',errorPage);
//		showErrorMessage( message_ref, message_frame, restore_toolbar, toolbar_frame )
        formObj.document.parentWindow.FocusFirstElement();
        return false;
    }
    /**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */

    var arrDuplicate        =   returnDuplicates(masterCodes);


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
    if(duplicateCodes!="")
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
                    duplicateCode += duplicatePKFields[pkIndex].value + ":";
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
	var firstNullObject     =   checkVariableFields( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage );


    if(firstNullObject!=null)
    {
        firstNullObject.className = "DUPLICATE";
        return false;
    }
    else
    {
        return true;
    }
}
function checkVariableFields( formObj, arrFieldName, arrLegends, arrPKFieldNames, startIndex, objMessageFrame, errorPage )
{
	var startInde=0;
	var totalRecords        =   formObj.totalRecords.value;
    var totalColumns        =   arrFieldName.length;
    var totalPKColumns      =   arrPKFieldNames.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);

  for( var rowIndex=0; rowIndex<totalRecords; rowIndex++ )
  {
        isNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
        var current_field   =   eval("formObj."+arrFieldName[colIndex]+rowIndex);
		var selectField = eval("formObj.select"+rowIndex);

		if(selectField.checked && current_field.value=="")
		{
			isNull=true;
			break;
		}
		}
		if(isNull)
		{
			current_field.className="DUPLICATE";
			current_field.focus();
			return false;
		}
  }
}




function onSuccess()
{
	var formObj = parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit;
	var catalogDesc = formObj.catalog_desc.value;
	var catalogCode = formObj.order_catalog_code.value;
	var categoryDesc = formObj.categoryDesc.value;
	var orderTypeDesc = formObj.orderTypeDesc.value;
	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.location.href="../../eOR/jsp/OROrderCatalogMultiConsentAddEdit.jsp?catalog_code="+catalogCode+"&catalog_desc="+catalogDesc+"&categoryDesc="+categoryDesc+"&orderTypeDesc="+orderTypeDesc;
	
}

async function show_consent_lookup(target,code,tempdesc)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit.localeName.value
	argumentArray[0]=parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit.consent_sql.value;
	argumentArray[0]=argumentArray[0].replace('?',"'"+localeName+"'");
	
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	if(target.value=="?")
	{
		argumentArray[5]= "";
	}
	else
	{
		argumentArray[5]=trimString(target.value);
	}
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("Common.Consent.label","COMMON"),argumentArray);
	var ret1=unescape(retval);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
		tempdesc.value=arr[1];
	}
}

function before_show_consent_lookup(target,code,tempdesc)
{
	 
	var formObj = parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit;
	if(target.value != tempdesc.value) 
	{
		if(target.value!="")
		{
			show_consent_lookup(target,code,tempdesc);
		}
		else
		{
			target.value="";
			code.value="";
			tempdesc.value="";
		}
	}
}

function colorResetCode(obj)
{
	var formObj = parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit;
	var totalRecords = formObj.totalRecords.value;
	var arrPKFieldNames	=	new Array();
	arrPKFieldNames[0]	=	"consent_desc";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}


function addMoreRows()
{
	var formObj = parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit;
	var total = formObj.totalRecords.value;

	var count = parseInt(total) + 5; 

	var catalogDesc = formObj.catalog_desc.value;
	var catalogCode = formObj.order_catalog_code.value;
	var form_list = formObj.form_list.value;
	var befRegn = formObj.befRegn.value;
	var befOrder = formObj.befOrder.value;
	var catalogCode = formObj.order_catalog_code.value;
	var temp = "NR";
	sort(formObj);
 	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.location.href="../../eOR/jsp/OROrderCatalogMultiConsentAddEdit.jsp?change=NR&count="+count+"&temp="+temp+"&form_list="+form_list+"&befRegn="+befRegn+"&befOrder="+befOrder+"&catalog_code="+catalogCode+"&catalogCode="+catalogCode;
	formObj.totalRecords.value = count;
}

function assignResult(res,msg,mod,invCode)
{
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	invalidCode		= invCode ;
}


function panelposition(position,last)
{
	var formObj = parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.document.Order_Catalog_MultiConsent_AddEdit;
	var fir = formObj.first.value;
	var form_list = formObj.form_list.value;
	var befRegn = formObj.befRegn.value;
	var befOrder = formObj.befOrder.value;
	var catalogCode = formObj.order_catalog_code.value;

	if(formObj.first.value != position)
	{
		if(last != 'X')
		last ='';
		var temp=formObj.first.value
		if(temp=='')
		{
			showvis();	
			formObj.first.value = position;
		}
		else
		{
			var pos1=formObj.first.value;
			formObj.first.value='';
			sort(formObj);
		 	parent.parent.f_query_add_mod.OROrderCatalogMultiConsentAddEditFrame.location.href="../../eOR/jsp/OROrderCatalogMultiConsentAddEdit.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&temp="+temp+"&form_list="+form_list+"&befRegn="+befRegn+"&befOrder="+befOrder+"&catalog_code="+catalogCode+"&lastlink="+last+"";
			showvis();
		}
	}
}

function showvis(val)
{
	if(val == 'true')
		document.getElementById("last").style.display='none';
	else
		document.getElementById("last").style.display='block';
}

function sort(frmObj) 
{
    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var arrObj = frmObj.elements;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
	var modeQuery = "sort";
    var xmlStr ="<root><SEARCH ";
	xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;

    for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
        frmObj = frmObjs[frmCount]
        var arrObj = frmObj.elements;

        for(var i=0;i<arrObj.length;i++) {
            var val = "" ;
            if(arrObj[i].type == "checkbox") {
                if(arrObj[i].checked)
                    val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
            else if(arrObj[i].type == "radio") {
                if(arrObj[i].checked) {
                    val = arrObj[i].value;
                    if(arrObj[i].name != null && arrObj[i].name != "")
                        xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
                }
            }
            else if(arrObj[i].type == "select-multiple" ) {
                for(var j=0; j<arrObj[i].options.length; j++)
                {
                    if(arrObj[i].options[j].selected)
                        val+=arrObj[i].options[j].value +"~"
                }
                val= val.substring(0,val.lastIndexOf('~'))
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

            }
            else {
                val = arrObj[i].value;
                if(arrObj[i].name != null && arrObj[i].name != "")
                    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
            }
        }
    }

    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OROrderCatalogMultiConsentFillOrderTypes.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&fill=OrderCategory",false ) ;
    xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return true;
}




/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;

/*************Handle to the Frame 's and the form Object ****************/
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;
var detailDocUpdate		=null;
var formObjDetailUpdate	=null;
var invalidCode			=null;
/*******************************************************************/
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/TickSheetsAddModify.jsp?mode=1&function_id="+function_id;
}
/******************************************************************************/
function query() {
f_query_add_mod.location.href="../../eOR/jsp/TickSheetsQueryCriteria.jsp?function_id="+function_id;
}
/******************************************************************************/
/******************************************************************************/
function allowPositiveNumber() { 
   var key = window.event.keyCode;// allows only numbers to be entered
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
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
			alert(getMessage("ONLY_POSITIVE_NUM",'OR'));
			obj.value= ""
			obj.focus();
			return false;
		}
	}else{
		return true;
	}
}
/******************************************************************************/
function apply() {
//alert("apply");
	if (! checkIsValidForProceed() ) {
		var message  = getMessage("NOT_VALID",'OR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	getHandleDetail();
	getHandleHeader();
	getHandleDetailUpdate();
	var mode = headerDoc.mode;


	if(mode.value == "2") //in Update mode
	{
		applyModify();
		return ;
	}

	var flag		= true ;
	var msgID		= "" ;
	var msgDesc		= "" ;
	var arrIDS		= new Array();
	var size = 0;

	formObjDetail.order_category.value = formObjHeader.order_category.value;

	var fields = new Array ( formObjHeader.order_category);
	var names = new Array ( getLabel("Common.OrderCategory.label","Common"));

	if(!checkFieldsofMst( fields, names, messageFrame)) {
		
	  return false;
	}

	for(i = 0 ; i < 10 ; i++){
		var flds=new Array(eval("formObjDetail.tick_sheet_id"+i));
		var name=new Array(getLabel("Common.identification.label","Common"));
		if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
			
			
			return false
		}
	}

	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
	var arrPKFieldNames		=	new Array();
	var arrFieldName1		=	new Array();
	var arrLegends1			=	new Array();
	var arrPKFieldNames1		=	new Array();
	arrFieldName1[0]		=	"seq_no";
	arrLegends1[0]			=	getLabel("Common.SequenceNo.label","Common");
	arrPKFieldNames1[0]		=	"seq_no";

	arrFieldName[0]			=	"tick_sheet_id";
	arrFieldName[1]			=	"tick_sheet_desc";
	
	arrLegends[0]			=	getLabel("eOR.TickSheetID.label","OR");
	arrLegends[1]			=	getLabel("eOR.TickSheetDescription.label","OR");
	
	arrPKFieldNames[0]		=	"tick_sheet_id";
	

//	var formObj				=	f_query_add_mod.document.formMasterCode ;
	resetDuplicateClass( formObjDetail, arrPKFieldNames );
	resetDuplicateClass( formObjDetail, arrPKFieldNames1 );

	var startIndex="0";
	var objMessageFrame=messageFrame;
	var errorPage="";

	var	result1	=	validateMandatoryFields(eval(formObjDetail),arrFieldName,arrLegends,arrPKFieldNames,startIndex, objMessageFrame, errorPage);
	
	if(result1)
	{
		var result2			=	validateSeqDupno(formObjDetail,arrFieldName1,arrLegends1,arrPKFieldNames1);
		if(result2) { 
		//alert(formApply(formObjDetail,OR_CONTROLLER));
			eval(formApply(formObjDetail,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			if(resultGlobal) {
				onSuccess();
			}else if((invalidCode != "") && (invalidCode != null) && (invalidCode !="null")){
				if(invalidCode.indexOf("s")!= -1) {
					if((invalidCode.indexOf("s:")!= -1)){
						//alert("invalidCode="+invalidCode);
						invalidCode=invalidCode.replace("s:",",");
						invalidCode=invalidCode.replace("s","");
						showDuplicates(formObjDetail,arrPKFieldNames1,invalidCode,"0",messageFrame );}
					else {
						invalidCode=invalidCode.replace("s","");
						showDuplicates(formObjDetail,arrPKFieldNames1,invalidCode,"0",messageFrame );}
				}else {
				//	alert("invalidCode="+invalidCode);
				   showDuplicates(formObjDetail,arrPKFieldNames,invalidCode,"0",messageFrame );}
			}
		}
	}
}

function resetColorCode(obj)
{
	var arrPKFieldNames	=	new Array();
	var formObj			=	f_query_add_mod.f_query_add_mod_detail.document.Tick_Sheets_insert;
	arrPKFieldNames[0]	=	"tick_sheet_id";
	resetDuplicateClass( formObj, arrPKFieldNames, 0, obj );
}


/******************************************************************************/
function onSuccess() {
	
	if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name == "Tick_Sheets_header"){//insert mode
	getHandleDetail();
	getHandleHeader();
	if(flagGlobal == "insert" ){
	
	headerDoc.order_category.selectedIndex = 0;
	headerDoc.order_category.focus();
	formObjDetail.reset();
	}
	}else{//Update Mode
	f_query_add_mod.document.location.href="../../eOR/jsp/TickSheetsAddModify.jsp?"+detailDocUpdate.qry_str.value ;
	}
}
/******************************************************************************/
function reset() {
	if(f_query_add_mod.f_query_add_mod_header !=null){//Add-Mod Mode
		if(f_query_add_mod.f_query_add_mod_header.document.forms[0].name =="Tick_Sheets_update"){//Update mode
		getHandleDetailUpdate();
		formObjDetailUpdate.reset();
		return ;
		}
	getHandleDetail();
	getHandleHeader();
	formObjDetail.reset();
	formObjHeader.reset();
	}else{
	if(f_query_add_mod.document.forms[0]!=null)
	f_query_add_mod.document.forms[0].reset(); //reset in query mode
	else
		{
			frames[0].location.reload();
			return false;
	}
	}

	messageFrame.document.href ='../../eCommon/jsp/MstCodeError.jsp' ;
}

/******************************************************************************/
function assignResult(res,msg,mod,invCode){
	resultGlobal	= res ;
	messageGlobal	= msg ;
	flagGlobal		= mod;
	
	invalidCode		= invCode ;
}
/******************************************************************************/
function applyModify(){
getHandleDetailUpdate();

var fields = new Array ( formObjDetailUpdate.tick_sheet_desc);
var names = new Array ( getLabel("Common.description.label","Common"));					
						
if(checkFieldsofMst( fields, names, messageFrame)) {
		
		eval(formApply(formObjDetailUpdate,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
		if(resultGlobal) {			
			onSuccess();
		}else if (invalidCode != "" && invalidCode != "null")
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal+invalidCode;
		}
	}
}
/**************************************************************************/
function resetLower(){
	getHandleDetail();
	formObjDetail.reset();
}
/*********************Header Handle*****************************/
function getHandleHeader(){
if(f_query_add_mod.f_query_add_mod_header == null)
	 return false;
 headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
 formObjHeader   =headerDoc.Tick_Sheets_header ;
}
/**********************Detail Handle**********************************/
function getHandleDetail(){
 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.Tick_Sheets_insert ;
}
/**********************Detail Handle for Update***************************/
function getHandleDetailUpdate(){
	 if(f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDocUpdate		    =f_query_add_mod.f_query_add_mod_header.document;
 formObjDetailUpdate		=detailDocUpdate.Tick_Sheets_update ;
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	{

				return true;
	}else
	{
			return false;
	}
}
/****************************************************************************/
function validateSeqDupno( formObj, arrFieldName1, arrLegends1, arrPKFieldNames1, startIndex, objMessageFrame, errorPage )
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
    var totalColumns        =   arrFieldName1.length;
    var totalPKColumns      =   arrPKFieldNames1.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);
    //alert("totalRecords : "+totalRecords);
    //alert("totalColumns : "+totalColumns);
    //alert("totalPKColumns : "+totalPKColumns);

    /**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
        var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
            current_field   =   eval("formObj."+arrFieldName1[colIndex]+rowIndex);
			//alert("current_field--"+current_field);
            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }
//        alert("isNotNull : "+isNotNull);
        if(isNotNull)
        {
            currRowIndex                =   rowIndex + 1;
            arrPKFields                 =   new Array();
            pkIndex                     =   0;

            for( var colIndex=0; colIndex<totalColumns; colIndex++ )
            {
                current_field           =   eval("formObj."+arrFieldName1[colIndex]+rowIndex);
                if( (uniqueFields.indexOf(arrFieldName1[colIndex])==-1) && (trimString(current_field.value)=="") )
                {
                    fields [ notNullIndex ]     =   current_field;
                    names  [ notNullIndex++ ]   =   arrLegends1[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
                    uniqueFields                +=  current_field.name + " " ;
                }

                if( colIndex < totalPKColumns )
                {
                    pk_field            =   eval("formObj."+arrPKFieldNames1[colIndex]+rowIndex);
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

    //alert("duplicateCodesValue : "+duplicateCodesValue);
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

        var error_msg       =   getMessage("SEQ_NO_EXISTS","OR") + " : " ;

        if( inputType == "text" )
        {
            error_msg       +=  duplicateCodes;
        }
        
        displayErrorMessage(error_msg,objMessageFrame,'',null,errorPage);
     
        duplicatePKFields[0].focus();
        return false;

		
    }else{ return true;}

    
	
}
//IN072524 Starts
function setFPPYN(obj,index){
	
	if(obj.checked)
	{
		document.getElementById('fpp_yn'+index).value = 'Y';
	}
	else{
		document.getElementById('fpp_yn'+index).value = 'N';
	}
}
//IN072524 Ends
/*********************************************************************/
/**Reference Pattern for Frame's and form Object For Catalog By section

Menu
	|
	TickSheets1.jsp---->TickSheets1.js
		|
		|------MstToolBar
		|
		|------TickSheetsAddModify.jsp
		|		|
		|		|---TickSheetsAddModifyHeader.jsp --------- /TickSheetsAddModifySingle.jsp		=>modify mode
		|		|		Document ---headerDoc				/Document ---detailDocUpdate		=>modify mode
		|		|		FormObect---formObjHeader			/FormObect---formObjDetailUpdate	=>modify mode
		|		|
		|		|---TickSheetsAddModifyDetail.jsp =>insert mode
		|		|		Document ---detailDoc
		|		|		FormObect---formObjDetail
		|
		|------MessageFrame
		|
**/

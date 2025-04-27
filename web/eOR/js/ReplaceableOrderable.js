/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
///////////////// Global Variable declaration ////////////////////////////////
var function_id = "" ;

var headerDoc			= null;
var detailDoc			= null;
var formObjHeader		= null;
var formObjDetail		= null;
var resultGlobal		= false;
var invalidCode			= null;



var result = false;
var message = "" ;
var messageGlobal = "" ;
var flagGlobal = true;
var detailDocUpdate=null;




/////////////////Declaration ends here////////////////////////////////////

/*********************Header Handle*****************************/
function getHandleHeader(){

 if(parent.parent.f_query_add_mod.f_query_add_mod_header == null)
	 return false;
 headerDoc	     =parent.parent.f_query_add_mod.f_query_add_mod_header.document ;
 formObjHeader   =headerDoc.ReplaceableOrderableHeader;
 var order_category_id= document.getElementById("order_catalog_code").value;
 //alert(order_category_id);
}

/**********************Detail Handle**********************************/
function getHandleDetail(){

 if(parent.parent.f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =parent.parent.f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.ReplaceableOrderableDetail ;

}

/*******************************************************************/

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		 return true;
	 else
	  return false;
}


/******************************************************************************/

function create() {
	f_query_add_mod.location.href='../../eOR/jsp/ReplaceableOrderableAddModifyMultiple.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}
/******************************************************************************/
function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ReplaceableOrderableQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}

/******************************************************************************/


function reset(){
	
	var url = f_query_add_mod.location.href;

	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) &&(url.indexOf("blank")!= -1) ){
		return true;
	}

	if(url.indexOf("query") != -1){
		f_query_add_mod.document.forms[0].reset();
		return true;
	}

	if(f_query_add_mod.document.ReplaceableOrderableUpdate != null){
		f_query_add_mod.document.forms[0].reset();
		return true;
	}

	if(url.indexOf(".jsp") != -1){
		f_query_add_mod.f_query_add_mod_header.document.forms[0].reset();
		f_query_add_mod.f_query_add_mod_detail.location.reload();
	}
	
}

/******************************************************************************/


function before_show_order_catalog_window(target,code){
getHandleHeader();
if(formObjHeader!=null){
	if(target.value != document.getElementById("temp_catalog_desc").value) {
		if(target.value!="")
			show_order_catalog_window(target,code);
		else{
		target.value="";
		code.value="";
		document.getElementById("temp_catalog_desc").value= "";
	}
}
}
}

function before_show_order_catalog_repl_window(target,code,i){
getHandleHeader();
if(formObjHeader!=null){
	if(target.value != parent.f_query_add_mod_header.document.getElementById("temp_catalog_desc").value) {
		if(target.value!="")
			show_order_catalog_repl_window(target,code,i);
		else{
		target.value="";
		code.value="";
		document.getElementById("temp_catalog_desc").value= "";
	}
}
}
}


/*************************show_window for Order Catalog*************************/

async function show_order_catalog_window(target,code){
	getHandleHeader();
if(formObjHeader!=null){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = document.getElementById("order_catalog_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray;
	argumentArray[3]   = dataTypeArray;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup( getLabel("Common.ordercatalog.label","Common"), argumentArray );
	 
	 var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "")
	{
	  code.value=arr[0];
	  target.value=arr[1];
	  document.getElementById("temp_catalog_desc").value=arr[1];
    }
	else
	{
      document.getElementById("catalog_desc").value= "";
	}

}

}

/******************************************************************************/

	async function show_order_catalog_repl_window(target,code,i) {
		
    var order_cat_code = 	parent.f_query_add_mod_header.ReplaceableOrderableHeader.order_catalog_code.value;
	if(order_cat_code)
	{
	
  	getHandleDetail();

	if(formObjDetail!=null){

  	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

  	dataNameArray[0] 	= "order_catalog_code_repl" ;		 
 	dataValueArray[0] 	= parent.f_query_add_mod_header.ReplaceableOrderableHeader.order_catalog_code.value;
 	dataTypeArray[0] 	= STRING ;  

  	//dataNameArray[1] 	= "order_catalog_code_repl" ;		 
 	//dataValueArray[1] 	= 	//parent.f_query_add_mod_header.ReplaceableOrderableHeader.order_catalog_code.value;	 
 	//dataTypeArray[1] 	= STRING ;  

 //	argumentArray[0]   = formObjDetail.all.order_catalog_repl_sql.value;
	sql				   =	document.getElementById("order_catalog_repl_sql").value;
	if(sql.indexOf("?")!=-1)
	{
		sql			   =  sql.substring(0,sql.indexOf("?"))+"'"+parent.f_query_add_mod_header.ReplaceableOrderableHeader.order_catalog_code.value+"'"+ sql.substring(sql.indexOf("?")+1);
	}

	argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
 	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
  	retVal =await CommonLookup( getLabel("eOR.ReplaceableOrderCatalog.label","OR"), argumentArray );

  	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "")
	{
	  code.value=arr[0];
	  target.value=arr[1];
    }
	else
	{
		target.value="";
		target.focus();
	}
	}
}

	else
	{
		var message  = getMessage("NEW_ORDER_CATALOG_BLANK","OR");
		parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;         
	}
}


/********************************APPLY Method*************************************/


function apply(){
	
	if (!checkIsValidForProceed()){
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	// local variable of the function 
	var flag1		= true;
	var flag2		= true;
	var flag		= true;
	var msgID		= ""   ;
	var msgDesc		= ""   ;
	var arrIDS		= new Array();
	var arrIDesc	= new Array();
	var size		= 0;
 

if(f_query_add_mod.f_query_add_mod_detail !=null)
{
	if(f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail.mode.value==MODE_INSERT ){
          
			f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail.order_catalog_code.value = f_query_add_mod.f_query_add_mod_header.document.ReplaceableOrderableHeader.order_catalog_code.value;

			var fields = new Array(f_query_add_mod.f_query_add_mod_header.document.ReplaceableOrderableHeader.order_catalog_code);
			var names  = new Array (getLabel("Common.ordercatalog.label","Common"));

				
			if(checkFieldsofMst( fields, names, messageFrame)) {
		

			var arrFieldName		=	new Array();
			var arrLegends			=	new Array();
			var arrPKFieldNames		=	new Array();

			arrFieldName[0]			=	"order_catalog_code_repl_desc";
    		arrLegends[0]			=	"Repl Code ";
			arrPKFieldNames[0]		=	"order_catalog_code_repl_desc";

	resetDuplicateClass(f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail, arrPKFieldNames );

	var	result1	=	validateMandatoryFields(f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail,arrFieldName,arrLegends,arrPKFieldNames);

	if(result1) {
			
// alert("nnn="+f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail.mode.value);
eval(formApply(f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+messageGlobal;
//			alert("resultGlobal="+resultGlobal);
//			alert("invalidCode="+invalidCode);
			if(resultGlobal) {
					onSuccess();
				}else if(invalidCode != "" && invalidCode != "null"){

					if(invalidCode.indexOf(":")!=-1)
					{
						invalidCode=invalidCode.substring(3, invalidCode.length);
					}

					showDuplicates(f_query_add_mod.f_query_add_mod_detail.document.ReplaceableOrderableDetail,arrPKFieldNames,invalidCode,"0",messageFrame );
				} //  end of if
			}   //  end of if(result1)
		}    // end of chk fld
	}    	
	  
	} 
	else 
	{
//		alert("modify");
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}   // end of else

}         //    end of apply

/**********************************************************************************/

function deleterecord(){

  //  alert("in delete");

	if (f_query_add_mod.document.ReplaceableOrderableUpdate !=null){

		if (!checkIsValidForProceed() || mode == '1' ) {
  		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		}              

	var formObj=f_query_add_mod.document.ReplaceableOrderableUpdate;
	var mode = formObj.mode.value ;
//  alert("mode"+mode);
	formObj.mode.value = "0"; //set mode to delete
	//alert("formObj.mode.value="+formObj.elements.length());
	var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
	//alert(" confVal : "+confirm_val);
	if(confirm_val){
	eval(formApply(formObj,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;	
	if(resultGlobal){//	onSuccess();
	create();
	intialiseGlobal();
	}
	}else
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}else
	{	
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

}

/*****************************************************************************/

function resetColorCode(obj)
{
//alert();
	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.f_query_add_mod_detail.document.ReplaceableOrderableDetail;
	arrPKFieldNames[0]	=	"order_catalog_code_repl_desc";
	resetDuplicateClass( formObj, arrPKFieldNames,0, obj );
}


/*****************************************************************************/


function assignResult(_result , _message, _flag, invCode){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;

}


/******************************************************************************/


function onSuccess(){

		formReset ();

}


/******************************************************************************/


function formReset () {

	f_query_add_mod.location.reload();
}


/******************************************************************************/


function intialiseGlobal(){
function_id = "" ;
resultGlobal = false;
messageGlobal = "" ;
flagGlobal = true;
}

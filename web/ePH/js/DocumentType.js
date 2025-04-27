  var function_id = "" ;
var result1 = false ;
var message = "" ;
var flag = "" ;
var bean_id="";
var bean_name="";

function query(){
//alert('Herrrrrr');
		f_query_add_mod.location.href="../../ePH/jsp/DocumentTypeQueryCriteria.jsp?mode="+MODE_MODIFY;
}
function reset() {
var url = f_query_add_mod.location.href;

if ( (url.indexOf("DocumentTypeQueryCriteria")!=-1) ) {
	
		f_query_add_mod.document.query_form.reset();
	}
	url = url.toLowerCase();
	//f_query_add_mod.document.document_type.reset();
	//alert('In Reset');
	if (f_query_add_mod.document.document_type!=undefined)
	{
	
	var mode=f_query_add_mod.document.document_type.mode.value;
	//alert("Mode ="+mode);
	if(f_query_add_mod.document.document_type.mode.value == MODE_INSERT){
		f_query_add_mod.document.document_type.reset();
		var len =f_query_add_mod.document.document_type.TRN_TYPE_CODE.options.length; 
		for(var i=0;i<len;i++) {
			f_query_add_mod.document.document_type.TRN_TYPE_CODE.remove("TRN_TYPE_CODE") ;
		}
		var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
		var opt = document.createElement("OPTION") ;
		opt.text = tp ;
		opt.value = "" ;
		f_query_add_mod.document.document_type.TRN_TYPE_CODE.add(opt);  
		//formReset() ;
		}
	else(f_query_add_mod.document.document_type.mode.value == MODE_MODIFY)
	{
	
		f_query_add_mod.document.document_type.reset();
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		        		return false;
	
	}

	}	
	else
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
	
}

function create(){
	f_query_add_mod.document.location.href="../../ePH/jsp/DocumentTypeAddModify.jsp?mode="+MODE_INSERT;
}

function apply() {
    formObj =   f_query_add_mod.document.document_type;
		
	if (f_query_add_mod.document.document_type!=undefined){
		var mode = formObj.mode.value;
		
		if( mode == MODE_INSERT ) {
			var st= f_query_add_mod.document.document_type.TRN_TYPE_CODE.value ;
			
			/*if(st=='')	{
				var mess=getMessage("PH_ST_DOCUMENT_TYPE","PH");
				 messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+mess;
				return false;
			}*/
			var formObj = f_query_add_mod.document.document_type ;
			var fields = new Array ( formObj.PH_TRN_TYPE ,formObj.TRN_TYPE_CODE);
			var names= new Array (getLabel("ePH.PharmacyTransactionType.label","PH"), getLabel("ePH.STDocumentType.label","PH"));
			
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{
	
				eval( formApply(formObj,PH_CONTROLLER) );
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
				if( result1 ) 	{
					 onSuccess();
				 }
			}
		}
		else if( mode == MODE_MODIFY ){ 		
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;

/*			var st= f_query_add_mod.document.document_type.st_doc_type.value ;
			if(st==''){
				var mess=getMessage("PH_ST_DOCUMENT_TYPE","PH");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ mess;
				return false;
			}
			eval( formApply(formObj,PH_CONTROLLER) );
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result1 ) 	{
				onSuccess();
			 }*/
		}
		if( mode == MODE_DELETE ) {
			eval( formApply( formObj, PH_CONTROLLER ) ) ;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result1 ) {
				f_query_add_mod.location.href="../../eCommon/html/blank.html";
			}
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}


function onSuccess() {
	   f_query_add_mod.document.document_type.reset();
 }

/******************************************************************************/
function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;
}
/***************************************************************************/
function ChkMaxLen(lab,obj,max,mode) {

		if(obj.value.length >= max) {
			alert("APP-SM0045 - " + lab + getLabel("ePH.Cannotexceed.label","PH")+ max  + getLabel("ePH.characters.label","PH") );
			obj.select();
			return false;
		} else return true;
	
}


function DurationValidate(obj){
	if(obj.value!="" && obj!=null)	{
		if(parseInt(document.dispense_rules.max_durn_for_disp.value)<parseInt(obj.value)){
			var message=getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.value="";
			obj.focus();
			}
			else{
			var message="";
			}
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
	}
}
function deleterecord(){
	formObj =   f_query_add_mod.document.document_type;
	if (f_query_add_mod.document.document_type!=undefined){
		if(f_query_add_mod.document.document_type.st_doc_type!=undefined){
			var st= f_query_add_mod.document.document_type.st_doc_type.value ;
			
			if(st==''){
				var mess=getMessage("PH_ST_DOCUMENT_TYPE","PH");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+mess;
				return false;
			}
		
			if (f_query_add_mod.document.document_type.mode.value == MODE_MODIFY) {
		
			f_query_add_mod.document.document_type.mode.value = MODE_DELETE;
			if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))			
			apply();
			else {
				f_query_add_mod.document.document_type.mode.value = MODE_MODIFY;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				}
		
			 }
			else {
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
					return false;
				}
		}//if
		else{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}
	else{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	   	return false;
	}
}

function Modify(obj){
	var ph_trn_typeval=obj.cells[0].innerText;
	var ph_trn_type=obj.cells[1].innerText;
	var st_document_type=obj.cells[2].innerText;
	var st_doc_type=obj.cells[2].innerText;

	document.location.href="../../ePH/jsp/DocumentTypeAddModify.jsp?mode="+MODE_MODIFY+"&ph_trn_type="+ph_trn_type+"&st_document_type="+st_document_type+"&st_doc_type="+st_doc_type+"&ph_trn_typeval="+ph_trn_typeval;
}

//**************************************************************************/
function addToGlobalDrugRelated(str1,str2)	{
	var formObj = document.document_type;		
	var element1 = document.createElement('OPTION') ;		
	element1.value		=  str1 ;		
	element1.text		=  str2 ;		
	formObj.TRN_TYPE_CODE.add(element1);
}
function addToGlobalDrugRelated1(str1,str2)	{
	var formObj = document.document_type;		
	var element1 = document.createElement('OPTION') ;		
	element1.value		=  str1 ;		
	element1.text		=  str2 ;		
	formObj.TRN_TYPE_CODE.add(element1);
}

function addToStockType(ph_trn_type)	{

	//alert(ph_trn_type);
	var formObj = document.document_type;
	formObj.StockTransactionType.value=ph_trn_type;
}

function searchBasedOnCriteria(obj)	{
	var len =document.document_type.TRN_TYPE_CODE.options.length; 
	for(var i=0;i<len;i++) {
		document.document_type.TRN_TYPE_CODE.remove("TRN_TYPE_CODE") ;
	}
	var tp = "             ---"+getLabel("Common.defaultSelect.label","Common")+"---            ";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.document_type.TRN_TYPE_CODE.add(opt);  

	if(obj.value == ""){
		document.forms[0].reset();
		return false;
	}
	var phtrn		= document.document_type.PH_TRN_TYPE.value ;
	str				=	phtrn.substr(0,2);
	st_trn_type		=	"";

	if(str=="RT")
		st_trn_type	=	"SRT";
	else if(str=="DI")
		st_trn_type	=	"SAL";
	else if(str=="PR")
		st_trn_type	=	"MFG";

	document.document_type.StockTransactionType.value	=	st_trn_type;


	if(phtrn==''){
		var mess=getMessage("PH_ST_DOCUMENT_TYPE","PH");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+mess;
		return false;
	}
	

	var ph= document.document_type.PH_TRN_TYPE.value ;
	if(ph==''){
		document.document_type.PH_TRN_TYPE.focus();
		document.document_type.StockTransactionType.value="";
		return;
	
	}
	var bean_id		= document.document_type.bean_id.value ;
	var bean_name	= document.document_type.bean_name.value ;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	
	xmlStr	="<root><SEARCH " ;
	xmlStr += "ph_trn_type=\""+ checkSpl(document.document_type.PH_TRN_TYPE.value) +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "DocumentTypeValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&ph_trn_type="+st_trn_type,false) ;
	xmlHttp.send( xmlDoc ) ;
	//alert(xmlHttp.responseText);
	eval(xmlHttp.responseText) ;
}

function addToGlobalDrugRelated2(str1,str2)	{

	//alert(str1);
	//alert(str2);
	var formObj = document.document_type;
	//alert(formObj);
	var element1 = document.createElement('OPTION') ;	
	//alert(element1);
	element1.value		=  str1 ;		
	//alert('1');
	element1.text		=  str2 ;
	//alert('2');
	formObj.st_doc_type.add(element1);
	//alert('3');	

}

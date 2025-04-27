
 
var function_id = "PH_PREGNANCY_CATEGORY" ;
var result1	= false ;
var message = "" ;
var flag = "" ;
var invalidCode	=  "";
var result = false;

var globalCode="";

function create() {	
	f_query_add_mod.location.href="../../ePH/jsp/PregnancyCategoryAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() 
 {
	f_query_add_mod.location.href="../../ePH/jsp/PregnancyCategoryQueryCriteria.jsp?mode="+MODE_MODIFY;
 }

function apply() {

	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	formObj	=	f_query_add_mod.document.PregnancyCategoryForm;

	var fields = new Array (formObj.cgCode,formObj.cgDesc);
	var names = new Array ("Category Group Code","Category Group Description");

	
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		 mode  =  formObj.mode.value;
	   if (mode == "1")
	   {	
		    if(checkFields()){
				eval(formApply(formObj,PH_CONTROLLER ));

				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			}else{
			 //f_query_add_mod.location.reload();
		      messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
			}
		 if( result1 ) {
			f_query_add_mod.document.PregnancyCategoryForm.reset();
			//f_query_add_mod.document.PregnancyCategoryForm.location.href="../../eCommon/html/blank.html";
	        }
	   }
	   if (mode=="2")
		 {
		   if(checkFields()){
				eval(formApply(formObj,PH_CONTROLLER ));
				if( result1 ) {
				onSuccess(f_query_add_mod.document.PregnancyCategoryForm.cgCode.value);	                
		}
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		   }
		   else
		   {
		   //f_query_add_mod.location.reload();
		   messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
		   }
		   
		
	   }
	}
}





function onSuccess(cgCode) {
	f_query_add_mod.location.href="../../ePH/jsp/PregnancyCategoryAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&cgCode="+cgCode;
    
}
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("pregnancycategoryquery")==-1) )
		return true;
	else
		return false;
}

function assignResult( _result, _message, _flag, _invalidCode ) {
    result1 = _result ;
    message  = _message ;
    flag = _flag ;
    invalidCode = _invalidCode ;
}

function checkCGCode(obj){
	var bean_id		="PregnancyCategory";
	var bean_name	="ePH.PregnancyCategoryBean";	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr += " bean_id=\""+bean_id+"\"";
	xmlStr += " bean_name=\""+bean_name+"\"";
	xmlStr +=" /></root>";

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","PregnancyCategoryValidate.jsp?func_mode=checkCGCode&cgCode="+obj.value,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function showMessage(cgCode){
  alert(getMessage("RECORD_EXISTS","PH"));
  document.PregnancyCategoryForm.cgCode.value = "";
  document.PregnancyCategoryForm.cgCode.focus();
}






function checkCCode(obj,count){
 var formObj ="document.PregnancyCategoryForm.cCode";
 var categoryCode = obj.value;
 var k='';
 var msg="";

 for (i=1;i<=12 ;i++ )
 {  
	 k = eval(formObj+i).value;
	 if ((count != i)&&(categoryCode == k)&&(obj.value != ""))
	 {
       msg = getMessage("RECORD_ALREADY_EXISTS","PH");
	  
	 }
 }
 if (msg != '')
 {
	 alert(msg);
	 obj.focus();
	 obj.value = "";
 }
}

function checkFields(){
 formObj = f_query_add_mod.document.PregnancyCategoryForm;
 var cStats =  "f_query_add_mod.document.PregnancyCategoryForm.cStatus";
 var cDesc =  "f_query_add_mod.document.PregnancyCategoryForm.cDesc";
 var cCode =  "f_query_add_mod.document.PregnancyCategoryForm.cCode";
 var msg = "";



 for (i=1;i<=12 ;i++)
 {
	if((eval(cStats+i).checked)&&((eval(cCode+i).value == '') ||(eval(cDesc+i).value == '')))
	{
		if ((eval(cCode+i).value == '') &&(eval(cDesc+i).value == ''))
		{
			 msg = getMessage('CATEGORY_CODE_AND_DESCRIPTION_CANNOT_BLANK','PH');
		}
		else if ((eval(cDesc+i).value == ''))
		{
			 msg = getMessage('CATEGORY_DESCRIPTION_CANNOT_BLANK','PH');
			  eval(cDesc+i).focus();
		}
		else 
		{
			
			msg =  getMessage('CATEGORY_CODE_CANNOT_BLANK','PH');
			 eval(cCode+i).focus();
		}
       
     }

	  if ((eval(cCode+i).value == '') &&(eval(cDesc+i).value != ''))
	  {
		  msg =  getMessage('CATEGORY_CODE_CANNOT_BLANK','PH');
		   eval(cCode+i).focus();
	
	  }
	  if ((eval(cCode+i).value != '') &&(eval(cDesc+i).value == ''))
	  {
		  msg =  getMessage('CATEGORY_DESCRIPTION_CANNOT_BLANK','PH');
		  	  eval(cDesc+i).focus();
	  }

 }
 if (msg != '')
 {
	 alert(msg);
//f_query_add_mod.document.PregnancyCategoryForm.reset();			
	 return false;
 }
 else
	 return true;
}

function Modify(obj) {
	var category_group_code = obj.cells[0].innerText;	
	parent.f_query_add_mod.location.href="../../ePH/jsp/PregnancyCategoryAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&cgCode="+category_group_code;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("pregnancycategoryquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("pregnancycategoryaddmodify")!=-1) ) {
		if(f_query_add_mod.document.PregnancyCategoryForm.mode.value == MODE_INSERT){
			
			f_query_add_mod.document.PregnancyCategoryForm.reset();
		}
		else {
			f_query_add_mod.document.PregnancyCategoryForm.reset();
		}
	}
}

function pValidmaxlength(obj){
	
	var 	field_label = getLabel("Common.CategoryDescription.label","Common");
	if(!SPCheckMaxLen(field_label,obj,600)){
		obj.select();
		obj.focus();
	}
}

function CodeCheck(obj){
	if(!CheckChars(obj)){
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}

async function showPregnancyRemarks(lmp,gestation,edd,asOnDateValue){
	var dialogHeight	= "33vh" ;
	var dialogWidth		= "48vw" ;
	var dialogTop		= "305" ;
	var dialogLeft		= "325" ;
	var center			= "1" ;
	var status			="no";
	var scroll			="yes";
	var features		= "dialogLeft:" + dialogLeft + ";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + ";scroll "+scroll+"; status: " + status + "; dialogTop :" + dialogTop;
	var arguments		= "" ;
	await window.showModalDialog("../../ePH/jsp/PregnancyRemarks.jsp?lmp="+lmp+"&gestation="+gestation+"&edd="+edd+"&asOnDate="+asOnDateValue,arguments,features);
	
}

function checkMaxLength(obj)
{
	var val = "";
	val = obj.value;	
	if(obj.value.length > 600) {
			var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			msg = msg.replace("$","Description");
			msg = msg.replace("#",600);
			obj.value = val.substring(0,599);
			alert(msg);
	}
}


function allow_nochars()
{
	whichCode = event.keyCode;
	if((whichCode== 35)||(whichCode == 38)||(whichCode== 63)||(whichCode== 94))
	{
	return false;
	}
}

function allow_nochars1(obj){
 textLength = obj.value.length;
 textValue = obj.value;
 
for (i=0;i<textLength;i++ )
{
	textValue = textValue.replace('?',"");
	textValue = textValue.replace('#',"");
	textValue = textValue.replace('&',"");
	textValue = textValue.replace('^',"");
} 
document.PregnancyCategoryForm.cgDesc.value = textValue;
}
function allow_nochars2(obj){
 textLength = obj.value.length;
 textValue = obj.value;
 
for (i=0;i<textLength;i++ )
{
	textValue = textValue.replace('?',"");
	textValue = textValue.replace('#',"");
	textValue = textValue.replace('&',"");
	textValue = textValue.replace('^',"");
} 
obj.value = textValue;
}

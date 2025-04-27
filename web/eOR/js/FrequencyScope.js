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
var result = false;
var message = "" ;
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var detailDocUpdate=null;
var  formObjDetailUpdate=null	;
/////////////////Declaration ends here////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
function create() {

	f_query_add_mod.location.href = '../../eOR/jsp/FrequencyScopeAddModifyMultiple.jsp?mode='+MODE_INSERT;
	}
////////////////////////////////////////////////////////////////////////////////
function query() {
	f_query_add_mod.location.href='../../eOR/jsp/FrequencyScopeQueryCriteria.jsp?function_id=FrequencyScope';
}
///////////////////////////////////////////////////////////////////////////////
/*function beforePost(str)
	{
		alert(str);
	}*/
	////////////
function reset(){
if (! checkIsValidForProceed() ){

	if(f_query_add_mod.document.forms[0])
				f_query_add_mod.document.forms[0].reset();

				return ;
				}

		f_query_add_mod.f_frequency_scope_top.document.form_frequency_scope.reset();
		f_query_add_mod.f_frequency_scope_bottom.location.href='../../eCommon/html/blank.html';
}// function reset end here

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}

/////////////////////////////////////////////////////////////////////////////////


// function for apply the data to the data base and do some mandatory validation at client side also
function apply() {
 
if (! checkIsValidForProceed() )
    {
			message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}
 
	var fields= new Array (f_query_add_mod.f_frequency_scope_top.document.form_frequency_scope.frequency);
	var names= new Array (getLabel("eOR.Frequency.label","OR"));
	if(checkFieldsofMst(fields,names,messageFrame)){
 
	eval(formApply(f_query_add_mod.f_frequency_scope_bottom.document.form_f_detail, OR_CONTROLLER));
//eval(formApply(f_query_add_mod.f_frequency_scope_top.document.form_frequency_scope, OR_CONTROLLER));
//alert(OR_CONTROLLER);

messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
			if(resultGlobal) {
					onSuccess();
							}
	}

}//function apply ends here
function onSuccess()
{
	var mode = f_query_add_mod.f_frequency_scope_top.form_frequency_scope.mode.value;
	formReset();

}


function assignResult(_result, _message, _flag){

	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;

}

function formReset () {
//	f_query_add_mod.f_frequency_scope_bottom.location.reload();
f_query_add_mod.location.href = '../../eOR/jsp/FrequencyScopeAddModifyMultiple.jsp?mode='+MODE_INSERT;
}
function setOrder(freqCode){

	//setLegend(freqCode) ;
	//alert(freqCode.value);
	if(document.form_frequency_scope.frequencyDesc.value=="")
	{
		freqCode.value="";
	}
	
	if(freqCode.value!=""){
	parent.f_frequency_scope_bottom.location.href="../../eOR/jsp/FrequencyScopeAddModifyBottom.jsp?mode=1&frequency="+freqCode.value;
	}else{
	parent.f_frequency_scope_bottom.location.href='../../eCommon/html/blank.html';
	}
}

/*
function setLegend(obj){
if(obj.value==""||obj.value==null){
	document.getElementById("freqLegend").innerHTML="&nbsp;";
}else{
	var bean_id = document.form_frequency_scope.bean_id.value ;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	var xmlStr ="<root><SEARCH " ;
	xmlStr += "freq_code"+"=\""+ obj.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","FrequencyScopeFillLegend.jsp?bean_id="+bean_id, false );
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	//ert(responseText)
	eval( responseText ) ;
	}
}

function fillLegendText(text){

if(text =="")
	document.getElementById("freqLegend").innerHTML="&nbsp;";
else
	//document.getElementById("freqLegend").innerHTML=text;
	document.getElementById("freqLegend").innerHTML="&nbsp;";
}
  */
  /**********************************************/
  function before_showFreqencyWindow(target,code)
{
	
	if(parent.f_frequency_scope_top!=null){
	
		if(parent.f_frequency_scope_top.document.form_frequency_scope.frequencyDesc_temp.value!= parent.f_frequency_scope_top.document.form_frequency_scope.frequencyDesc.value)
		{
			if(parent.f_frequency_scope_top.document.form_frequency_scope.frequencyDesc.value != "")
			 Lookupwindow(target,code);
		}
	}
}

async function showFreqencyWindow(target,code){
		
		if(parent.f_frequency_scope_top!=null){
			if(parent.f_frequency_scope_top.document.form_frequency_scope.frequencyDesc.value == ""){
			await Lookupwindow(target,code);
			}
		}
}
async function Lookupwindow(target,code){
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;		

	argumentArray[0]	= parent.f_frequency_scope_top.document.form_frequency_scope.frequency_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = parent.f_frequency_scope_top.CODE_LINK ;
	argumentArray[7]   = parent.f_frequency_scope_top.CODE_DESC ;
	retVal = await CommonLookup( getLabel("eOR.Frequency.label","OR"), argumentArray );
		var ret1=unescape(retVal);

		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
 	if(retVal != null && retVal != ""){
		target.value = arr[1];
 		code.value =arr[0];
 		
 		setOrder(code)
		parent.f_frequency_scope_top.document.form_frequency_scope.frequencyDesc_temp.value= arr[1];
  	}else{
   		target.value = "";
   		code.value = "" ;
 		parent.f_frequency_scope_top.document.form_frequency_scope.frequencyDesc_temp.value="";

 	}
 

}
  /**********************************************/


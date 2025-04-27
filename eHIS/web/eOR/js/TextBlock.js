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
var val1="";
var val2="";
var val3="";
var val4="";
var detailDocUpdate=null;
var  formObjDetailUpdate=null	;
//////////////////////////////////
function onSuccess()
{			formReset ();
}
///////////////////////////////////
/*function focusCheck(field,formObj1){
			for( i=0;i<field.length;i++){
							if(field[i].value==="")	  {
								formObj1.item(i).focus();
										break;
									}
							}
 return true;
} */
////////////////////////////////////////////////////////////////
function formReset () {
	f_query_add_mod.location.reload();
}
//////////////////////////////////////////
function create() {
f_query_add_mod.location.href = "../../eOR/jsp/TextBlockAddModify.jsp?mode=1&function_id=Text_Block";
}
//////////////////////////////////////////
function query() {
	f_query_add_mod.location.href="../../eOR/jsp/TextBlockQueryCriteria.jsp";
}
///////////////////////////////
function assignResult(_result, _message, _flag){

	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;

}
////////////
// call back function
								   /*
function beforePost(str)
	{
		alert(str);
	}								  */

///////////
function apply() {


 if (! checkIsValidForProceed() )
    {
			var message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}



/////////////////////
//////////////////////
var fields = new Array ( f_query_add_mod.document.forms[0].text_block_id, f_query_add_mod.document.forms[0].text_block);
var names = new Array ( getLabel("Common.identification.label","Common"),getLabel("eCA.TextBlock.label","CA"));

if(f_query_add_mod.document.forms[0].eff_status_disp.checked==true){
			f_query_add_mod.document.forms[0].eff_status.value="E";
			//alert(f_query_add_mod.document.forms[0].eff_status.value);
}else{
		   f_query_add_mod.document.forms[0].eff_status.value="D";
		   //alert(f_query_add_mod.document.forms[0].eff_status.value);
 }

	   var obj=getBlankField(fields, names, messageFrame,"../../eCommon/jsp/MstCodeError.jsp");
//	   alert(obj);
//	   alert("before calling::");


	//	if(obj=!null)
	//obj.focus();


//	if(focusCheck(fields,f_query_add_mod.document.forms[0])&&checkFieldsofMst( fields, names, messageFrame)){

//	if(getBlankField(fields, names, messageFrame,"../../eCommon/jsp/MstCodeError.jsp")){
		if(checkFieldsofMst( fields, names, messageFrame)){
	     var flds=new Array(f_query_add_mod.document.forms[0].text_block_id);
		  var name=new Array(getLabel("Common.identification.label","Common"));
//		  alert("display");
	  if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){




		eval( formApply (f_query_add_mod.document.forms[0] , OR_CONTROLLER ));
//alert(formApply (f_query_add_mod.document.forms[0] , OR_CONTROLLER ));

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
					if(resultGlobal) {
										onSuccess();
					}
}
}
}

////////////////////////////////////////////////

/////////////////////////////////////

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}
/////////////////////////////////


//////////////////////////////////////////
function reset(){


var url =f_query_add_mod.location.href;
	url = url.toLowerCase();
if ( (url.indexOf("queryresult.jsp")!=-1) || (url.indexOf("query")!=-1) ){
				f_query_add_mod.document.forms[0].reset();
				return ;
				}
if(url.indexOf("blank")!=-1)return;

			if(f_query_add_mod.document.forms[0]&&f_query_add_mod.document.forms[0].mode.value=="1"){
							f_query_add_mod.document.forms[0].reset();
				}
				else if(f_query_add_mod.document.forms[0].mode.value=="2"){
	//					alert(" in modify reset ");
							f_query_add_mod.document.forms[0].reset();
				}
}
/////////////////////////////////////////

function before_showDiscreteWindow(target,code){
 if(parent.f_query_add_mod.document.text_block_add_modify.discr_msr_panel_desc_temp.value !=target.value)
	 if(target.value != "")
	 DiscreteLookUp(target,code);
}

function showDiscreteWindow(target,code){
if(target.value == "")
	DiscreteLookUp(target,code);
}

async function DiscreteLookUp(target,code){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;		

	argumentArray[0]	= parent.f_query_add_mod.document.text_block_add_modify.discrete_sql.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = parent.f_query_add_mod.CODE_LINK ;
	argumentArray[7]   = parent.f_query_add_mod.CODE_DESC ;
	retVal = await CommonLookup( getLabel("Common.DiscreteMeasure.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

 	if(retVal != null && retVal != ""){
		target.value = arr[1];
 		code.value =arr[0] ;
		parent.f_query_add_mod.document.text_block_add_modify.discr_msr_panel_desc_temp.value= arr[1];
 	}else{
   		target.value = "";
   		code.value = "" ;
		parent.f_query_add_mod.document.text_block_add_modify.discr_msr_panel_desc_temp.value="";

 	}
}



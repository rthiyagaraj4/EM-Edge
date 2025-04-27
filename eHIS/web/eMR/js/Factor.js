

function create()
{
	f_query_add_mod.location.href="../../eMR/jsp/FactorAddModify.jsp?mode=1";
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eMR/jsp/FactorQueryCriteria.jsp";
}
//*********************************************************************************************************
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1)
		if(f_query_add_mod.document.forms[0])
	      	f_query_add_mod.document.forms[0].reset();
}
//***********************************************************************************************************
function apply()
{

	if (! checkIsValidForProceed() ) {
		message  =getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var	formObj	= f_query_add_mod.document.factor_form;
	var mode = f_query_add_mod.document.factor_form.mode.value;
	
	if(formObj.eff_status.checked==true)
		formObj.eff_status.value="E";
	else
		formObj.eff_status.value="D";

	if(mode==2)
	{
		paramValues="&factor_code="+formObj.factor_code.value+"&long_desc="+formObj.long_desc.value+
		"&short_desc="+formObj.short_desc.value+"&factor_type="+formObj.factor_type.value+
		"&eff_status="+formObj.eff_status.value;
	}

	var	fields = new Array ( formObj.factor_code,formObj.long_desc,formObj.short_desc,formObj.factor_type);
    var	names =	new	Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.type.label","Common"));
    
	  if(f_query_add_mod.checkFieldsofMst(	fields,	names, messageFrame)) 
	  {
		  var flds=new Array(formObj.factor_code);
		  var name=new Array(getLabel("Common.code.label","Common"));
	    if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
			formObj.submit();
	     }
       }
}
//**********************************************************************************************
function checkIsValidForProceed(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
//*******************************************************************************************************
 function onSuccess()
   {
	   var frmObj=f_query_add_mod.document.factor_form;
	    var mode =frmObj.mode.value;
		 	if(mode=="1")
		   		 frmObj.reset()
		   
		   else if(mode=="2")
				f_query_add_mod.location.href='../../eMR/jsp/FactorAddModify.jsp?mode=2'+paramValues;
  }
//*****************************************************************************************************
  function onChangeType(obj)
  {
	  	document.factor_form.factor_type1.value=obj.value;
  }
 
//*************************************************************************************************
function oneffStatusCheck()
{
	var frmObj=	document.factor_form;
	if(frmObj.eff_status.checked==true){
		frmObj.eff_status.value="E";
	}else
		frmObj.eff_status.value="D";
}
//*************************************************************************************************

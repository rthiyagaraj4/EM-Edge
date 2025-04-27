//This file is saved on 18/10/2005.


function create()
{
	f_query_add_mod.location.href="../../eCP/jsp/VarianceCauseAddModify.jsp?mode=1";
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eCP/jsp/VarianceCauseQueryCriteria.jsp";
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
		//alert("inside alert");
	var formObj = f_query_add_mod.document.VarianceCauseform;
        //var messageFrame = parent.frames[1].frames[2]; 
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

	if (! checkIsValidForProceed() ) 
	{
		var message  = getMessage("APPLY_NOT_VALID","CP");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var fields = new Array();
	var names = new Array();
	//alert("eff_status: "+formObj.eff_status.value);
        
	fields[0] = formObj.Code;
	fields[1] = formObj.Desc;
	names[0] = getLabel("eCP.VarianceCode.label","CP");
	names[1] = getLabel("eCP.VarianceDescription.label","CP"); 
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		//alert("done");
           formObj.submit();
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
	   var frmObj=f_query_add_mod.document.VarianceCauseform;
	    var mode =frmObj.mode.value;
		//alert(mode);
		 	if(mode=="1")
		   		 frmObj.reset()
		   
		   else if(mode=="2"){
			   enablestaus(eval("frmObj.eff_status"));
			   var paramValues="&variance_code="+frmObj.Code.value+"&variance_desc="+frmObj.Desc.value+"&eff_status="+frmObj.eff_status.value;
			   //alert(paramValues);
				f_query_add_mod.location.href="../../eCP/jsp/VarianceCauseAddModify.jsp?mode=2"+paramValues;
		   }
  }
//*****************************************************************************************************
 function enablestaus(obj){
	 
	 if(obj.checked==true)
		 obj.value="E";
	 else
		 obj.value="D";
	 	 
 }

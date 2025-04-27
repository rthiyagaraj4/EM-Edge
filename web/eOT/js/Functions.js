/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply()
{	
	var description=getLabel("Common.description.label","common");
	var frm=f_query_add_mod.document.forms[0];
	//alert(frm.name);

	if(frm.name=='query_form' || frm.name=='QueryResult')
{
	//alert('This Operation is not allowed Here');
	//return;
	commontoolbarFrame.location.reload();
}
else
	{
	var fields = new Array (f_query_add_mod.document.forms[0].function_desc_user);
	var names = new Array (description);
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{	
			f_query_add_mod.document.forms[0].submit();
		}
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/FunctionsModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {

	 /*if(f_query_add_mod.document.location.href.indexOf("Functions.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();*/
		if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsModify.jsp") != -1)
		f_query_add_mod.document.forms[0].reset();
		else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsQueryCriteria.jsp") != -1)
		f_query_add_mod.document.forms[0].reset();
		else
		return false;
}

function query()
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true;  //Commented Against GHL-SCF-1519
	//commontoolbarFrame.document.forms[0].reset.disabled=true;

	f_query_add_mod.location.href='../../eOT/jsp/FunctionsQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function checkforchecklistcompl()

{
	if(document.forms[0].check_for_check_list_compl.checked==true)
		document.forms[0].check_for_check_list_compl.value="Y";
	else
		document.forms[0].check_for_check_list_compl.value="N";

}

function allowBarcode()
{
	if(document.forms[0].allow_barcode.checked==true)
		document.forms[0].allow_barcode.value="Y";
	else
		document.forms[0].allow_barcode.value="N";
}

function verificationApplicable()
{
	if(document.forms[0].verification_applicable.checked==true)
		document.forms[0].verification_applicable.value="Y";
	else
		document.forms[0].verification_applicable.value="N";
}

function searchCode(obj,target, tit, sql){

	var locale=document.forms[0].locale.value;
	var sql = "SELECT GET_DESC('"+locale+"','OT_STATUS_LANG_VW','STATUS_DESC','STATUS_CODE',STATUS_CODE) DESCRIPTION, STATUS_CODE CODE FROM OT_STATUS where upper(STATUS_DESC) like upper(?) and upper(STATUS_CODE) like upper(?)order by 1"
	var returnedValues = new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value=returnedValues[1];
		obj.value=returnedValues[0];
	} 
}

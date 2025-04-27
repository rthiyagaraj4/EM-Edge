/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj=null;

function create(){		
	f_query_add_mod.location.href = "../../eSS/jsp/UserAccessForStoreMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
}

function query() {
	f_query_add_mod.location.href="../../eSS/jsp/UserAccessForStoreQueryCriteria.jsp?function_id="+function_id+"&mode="+MODE_MODIFY;
}

function showDetails(store_code){
	parent.StoreDetailsFrame.location.href	=	"../../eSS/jsp/ShowStoreDetails.jsp?store_code="+store_code;
}
function apply()
{

	if(!proceedOnApply())
    {
        messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
        return false;
    }
	var formObj		=	f_query_add_mod.UserForStoreHeaderFrame.document.Search_form;
	var blankObject	=	null;
	var fields		=	new Array(formObj.user_name);
	var fieldNames	=	new Array(getLabel("eSS.UserName.label","SS"));
	var queryString =	"";
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	//commented by Rabbani for Script error on 18/12/2012 
	//var arr_size = f_query_add_mod.UserForStoreListFrame.document.UserAccessForStoreListForm.arr_size.value;
	

	blankObject		=	getBlankField( fields, fieldNames, messageFrame);

	if(blankObject==null) {
	var xmlString = getEnhancedXMLString(f_query_add_mod.UserForStoreListFrame.document.UserAccessForStoreListForm);
	var result = formApply(f_query_add_mod.UserForStoreListFrame.document.UserAccessForStoreListForm,SS_CONTROLLER);
	result = result.replace(/<\/?[^>]+(>|$)|\s+|\r?\n/g, "");
	eval(result);
	messageFrame.location.href = errorPage+"?err_num="+ message+"<br>"+flag;
	
		if( result ) {
			onSuccess();
		}
	}
	else{
		blankObject.focus();
	}
}
  
function proceedOnApply() {
    var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("useraccessforstorequery")==-1) )
        return true;
    else
        return false;
}
function onSuccess(){

	messageFrame.location.href = "../../eCommon/jsp/error.jsp"+"?err_num="+ message;
}

function reset() {
	//f_query_add_mod.location.reload(); //commented by Rabbani for  script error in query mode on 18/12/2012
	
	//Added by Rabbani for  script error in query mode on 18/12/2012 Starts
	if (f_query_add_mod.UserForStoreHeaderFrame != null) {
	   if (f_query_add_mod.UserForStoreListFrame != null) {
		   f_query_add_mod.location.reload();
	     }else{
		  f_query_add_mod.location.href = "../../eSS/jsp/UserAccessForStoreMain.jsp?mode="+MODE_INSERT+"&function_id="+function_id;
		}
	  }
	if (f_query_add_mod.document.query_form != null) {
		f_query_add_mod.document.query_form.reset();
	} //ends
}

function clearDetails() {
	parent.UserForStoreHeaderFrame.location.reload();
	parent.UserForStoreListFrame.location.href="../../eCommon/html/blank.html";

}

function searchDetails(mode) {

	top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var user_id=document.forms[0].user_id.value;
	if(user_id!="") {
	   parent.UserForStoreListFrame.location.href="../../eSS/jsp/UserAccessForStoreDetail.jsp?user_id="+user_id+"&mode="+mode;
	}
	else
	{
		alert(getMessage("USER_CANNOT_BLANK","SS"));
		document.forms[0].user_id.focus();
	}
}

function isCheck(isTrue)
{
	//alert(isTrue);
  if(isTrue=='N')
	  return true 
	else
	  return false
}
function doDisable(isChecked,index,AckReqdForLoanIssueGroup,AckReqdForLoanReturnGroup){
	isChecked=!isChecked;
	//alert(isChecked);
	if (isChecked==true)
	{
		doEnable(isChecked,index,AckReqdForLoanIssueGroup,AckReqdForLoanReturnGroup);
    eval("document.UserAccessForStoreListForm.pre_allowed_yn_"+index+".disabled=isChecked");  
    eval("document.UserAccessForStoreListForm.req_allowed_yn_"+index+".disabled=isChecked");  
    eval("document.UserAccessForStoreListForm.iss_allowed_yn_"+index+".disabled=isChecked");  
	eval("document.UserAccessForStoreListForm.rtg_allowed_yn_"+index+".disabled=isChecked");  
	eval("document.UserAccessForStoreListForm.rti_allowed_yn_"+index+".disabled=isChecked");  
	eval("document.UserAccessForStoreListForm.trd_allowed_yn_"+index+".disabled=isChecked");
	eval("document.UserAccessForStoreListForm.adj_allowed_yn_"+index+".disabled=isChecked");  
	eval("document.UserAccessForStoreListForm.var_allowed_yn_"+index+".disabled=isChecked");  
	eval("document.UserAccessForStoreListForm.rof_allowed_yn_"+index+".disabled=isChecked"); 
//Added By Sakti Sankar on 11/04/2013 CRF#Bru-HIMS-CRF-225 and inc#32071
	eval("document.UserAccessForStoreListForm.rql_allowed_yn_"+index+".disabled=isChecked");
	eval("document.UserAccessForStoreListForm.isl_allowed_yn_"+index+".disabled=isChecked");
	eval("document.UserAccessForStoreListForm.rtl_allowed_yn_"+index+".disabled=isChecked");
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	eval("document.UserAccessForStoreListForm.rqv_allowed_yn_"+index+".disabled=isChecked");
	eval("document.UserAccessForStoreListForm.rqv_ack_allowed_yn_"+index+".disabled=isChecked");
	eval("document.UserAccessForStoreListForm.rtv_allowed_yn_"+index+".disabled=isChecked");
	}	
	else
	{
		doEnable(isChecked,index,AckReqdForLoanIssueGroup,AckReqdForLoanReturnGroup);
	eval("document.UserAccessForStoreListForm.pre_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][0])); 
    eval("document.UserAccessForStoreListForm.req_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][1])); 
    eval("document.UserAccessForStoreListForm.iss_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][2])); 
	eval("document.UserAccessForStoreListForm.rtg_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][3])); 
	eval("document.UserAccessForStoreListForm.rti_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][4])); 
	eval("document.UserAccessForStoreListForm.trd_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][5])); 
	eval("document.UserAccessForStoreListForm.adj_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][6])); 
	eval("document.UserAccessForStoreListForm.var_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][7])); 
	eval("document.UserAccessForStoreListForm.rof_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][8])); 
//Added By Sakti Sankar on 11/04/2013 CRF#Bru-HIMS-CRF-225 and inc#32071
	eval("document.UserAccessForStoreListForm.rql_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][13]));
	eval("document.UserAccessForStoreListForm.isl_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][14])); 
	eval("document.UserAccessForStoreListForm.rtl_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][15]));
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
	eval("document.UserAccessForStoreListForm.rqv_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][16]));
	eval("document.UserAccessForStoreListForm.rqv_ack_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][17]));
	eval("document.UserAccessForStoreListForm.rtv_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][18]));

	}


}

function doEnable(isChecked,index,AckReqdForLoanIssueGroup,AckReqdForLoanReturnGroup){
	
	//isChecked = !isChecked;
	
	if (isChecked==true)
	{
		if(AckReqdForLoanIssueGroup == "true") {
		eval("document.UserAccessForStoreListForm.isl_ack_allowed_yn_"+index+".disabled=isChecked");
		eval("document.UserAccessForStoreListForm.isl_conf_allowed_yn_"+index+".disabled=isChecked");
		}
		if(AckReqdForLoanReturnGroup == "true") {
		eval("document.UserAccessForStoreListForm.rtl_ack_allowed_yn_"+index+".disabled=isChecked");
		}
		
	}else{
	
		if(AckReqdForLoanIssueGroup== "true") {
		eval("document.UserAccessForStoreListForm.isl_ack_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][14]));
		eval("document.UserAccessForStoreListForm.isl_conf_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][14]));
		}
		if(AckReqdForLoanReturnGroup == "true") {
		eval("document.UserAccessForStoreListForm.rtl_ack_allowed_yn_"+index+".disabled="+isCheck(checkArray[index][15]));
		}
		
	}
}
function doEnableForCheck(index){
    eval("document.UserAccessForStoreListForm.check_"+index+".checked=true");  
	doDisable(true,index);
}
async function searchCode( target ) 
{
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	if(target.name=="user_name"){
		argumentArray[0]   = document.forms[0].sql_ss_user_for_store_appl_user.value;
		argumentArray[4]   = "2,3"; 
	}
	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ; 

	if(target.name=="user_name"){
		if(!document.forms[0].user_name.readOnly){
			retVal = await CommonLookup( getLabel("Common.user.label","Common"), argumentArray );
		}
		else{
		retVal="";
		}
	}
	
	if(retVal != null && retVal != "" )  {
		if(retVal.length === 1){
			retVal = retVal[0].split(',');
		}
		target.value = retVal[1] ;
		if(target.name=="user_name")
		{
			document.forms[0].user_id.value=retVal[0];
			document.forms[0].userIdSearch.disabled=true;
			document.forms[0].user_name.readOnly=true;
			searchDetails("MODE_INSERT");
		}
	} 
}

// for maintaing the state of the check boxes
function SubmitLink(from, to) {
	var bean_id = document.UserAccessForStoreListForm.bean_id.value;
	var bean_name = document.UserAccessForStoreListForm.bean_name.value;
	var xmlDom = ""; //new ActiveXObject( "Microsoft.XMLDom" );
	var xmlHttp = new XMLHttpRequest();
	var selectedIndices = "";
	var index = 0;
	var xmlString = "";
	var xmlString = getEnhancedXMLString(document.UserAccessForStoreListForm);
	//xmlDom.loadXML(xmlString);	
	
	xmlDom = new DOMParser().parseFromString(xmlString, "text/xml");
	xmlHttp.open("POST", "../../eSS/jsp/UserAccessForStoreValidate.jsp?validate=TRIAL&bean_id="+bean_id+"&bean_name="+bean_name, false);
	xmlHttp.send(xmlDom);
	responseText=xmlHttp.responseText;
	eval(responseText);
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}

function Modify(obj){
	var user_id=obj.cells[0].innerText;
	var user_name=obj.cells[1].innerText;
	parent.frames[2].f_query_add_mod.location.href="../../eSS/jsp/UserAccessForStoreMain.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&user_name="+user_name+"&user_id="+user_id;

}
 

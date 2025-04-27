/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	var cmf=commontoolbarFrame.document.forms[0];
	//alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	f_query_add_mod.location.href='../../eOT/jsp/FunctionsForStatusFrameInCreateMode.jsp?mode=insert';
}

function apply()
{	
	//var formObj = window.parent.frames[1].frames[1].frames[1].document.forms[0];
	//alert(formObj.name);
    if(typeof parent.content.f_query_add_mod.detail_frame!="undefined" ){
	var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	if(formObj!=null)
	{
	var params = formObj.params.value;
	//alert("params " + params);
	var status_code=formObj.status_code.value;
	var arr = formObj.elements;
	var xmlStr=formXMLString(arr);	
	if(xmlStr!="<root></root>"){
		var action="../../servlet/eOT.FunctionStatusServlet?status_code="+status_code;
		//var arr = formObj.elements;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
	
		var mesg =retVal;

		parent.content.f_query_add_mod.detail_frame.document.location.reload();
		//parent.frames[1].frames[3].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
	else{
		//var mesg = "<B><Font style='font-size:11pt;'>No Changes to Apply...</B></font>";
		var mesg = getMessage("NO_CHANGE_TO_SAVE","Common");
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
	}
	else
	{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	}else
	{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	
	
}

function formXMLString(arrObj){
	var xmlString="<root>";
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" && arrObj[i].getAttribute('db_change')=="Y"){
			   xmlString+="<RECORD_"+arrObj[i].getAttribute('func_id')+" ";
			   xmlString+="func_id=\""+arrObj[i].getAttribute('func_id')+"\""+" ";
			   xmlString+="select_value=\""+arrObj[i].getAttribute('select_yn')+"\""+" />";
		 }
	}
	xmlString+="</root>";
	return xmlString;
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/FunctionsModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
	f_query_add_mod.document.forms[0].reset();  FunctionsForStatusMain
}*/

function reset() {

	 //if(f_query_add_mod.document.location.href.indexOf("FunctionsForStatusMain.jsp") != -1)
	 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsForStatusFrameInCreateMode.jsp") != -1){
	 if(typeof parent.content.f_query_add_mod=="undefined")
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	 }else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsForStatusQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	//alert("commontoolbarFrame document==="+cmf.name);
	/* if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    } */  //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/FunctionsForStatusQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function callDetailForm()
{
	
var frmObj=window.parent.frames[0];
var frm=frmObj.document.forms[0];
var err=getMessage("CAN_NOT_BE_BLANK","Common");
var status_label=getLabel("Common.status.label","Common");
var errMsg=err.split("$");
//"APP-000001 $ cannot be blank.
var status_code=frm.status_description.value;
if(status_code=="" || status_code==null ){
	alert(errMsg[0]+status_label+errMsg[1]);
	return false;

}
var frmObj = window.parent.frames[1];
frmObj.location.href="../../eOT/jsp/FunctionsForStatusDetailForm.jsp?status_code="+status_code;
}

function clearvalues(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}


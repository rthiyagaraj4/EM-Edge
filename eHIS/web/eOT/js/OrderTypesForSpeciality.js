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
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
	  cmf.reset.disabled=false;
    }
	f_query_add_mod.location.href='../../eOT/jsp/OrderTypesForSpecialityFrameInCreateMode.jsp?mode=insert';
}

function apply()
{	
	var messageFrame=parent.content.messageFrame;
	var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	var params = formObj.params.value;
	var speciality_code=formObj.speciality_code.value;
	var arr = formObj.elements;
	var xmlStr=formXMLString(arr);	
	if(xmlStr!="<root></root>"){
		var action="../../servlet/eOT.OrderTypesForSpecialityServlet?speciality_code="+speciality_code;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		var mesg = retVal;
		parent.content.f_query_add_mod.detail_frame.document.location.reload();
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+mesg;		

	}else{
		var mesg= getMessage("NO_CHANGE_TO_SAVE","Common");
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+mesg;
	}
	
	
}

function formXMLString(arrObj){
	var xmlString="<root>";
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" && arrObj[i].getAttribute('db_change')=="Y"){
			   xmlString+="<RECORD_"+i+" ";
			   xmlString+="order_type_code=\""+arrObj[i].getAttribute('order_type_code')+"\""+" ";
			   xmlString+="select_value=\""+arrObj[i].getAttribute('select_yn')+"\""+" />";
		 }
	}
	xmlString+="</root>";
	return xmlString;
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/OrderTypesForSpecialityFrameInCreateMode.jsp?mode=insert';
	else
		 f_query_add_mod.location.href='../../eOT/jsp/OrderTypesForSpecialityFrameInCreateMode.jsp';

}

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OrderTypesForSpecialityFrameInCreateMode.jsp") != -1){
			 if(f_query_add_mod.document.location.href.indexOf("OrderTypesForSpecialityMain.jsp") != -1)
					  return false;
				 else
					 f_query_add_mod.document.location.reload();
  }else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OrderTypesForSpecialityQueryCriteria.jsp") != -1){
   f_query_add_mod.document.forms[0].reset();
}
}
function query()
{
	/* var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  	  //commontoolbarFrame.document.forms[0].reset.disabled=true;

    } */ //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/OrderTypesForSpecialityQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function callDetailForm(){

	var frmObj=window.parent.frames[0];
	var frm=frmObj.document.forms[0];
	var frmObj = window.parent.frames[1];
	var speciality_code=frm.speciality_description.value;
		if(speciality_code!=""){
			var RstfrmObj = window.parent.frames[1];
			RstfrmObj.location.href="../../eOT/jsp/OrderTypesForSpecialityDetailForm.jsp?speciality_code="+speciality_code;
		}else{

			var mesg=getMessage("CANNOT_BE_BLANK","OT").replace('&',getLabel("Common.speciality.label","Common") );
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}
}

function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}

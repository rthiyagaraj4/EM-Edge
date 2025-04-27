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
	f_query_add_mod.location.href='../../eOT/jsp/ReasonsAddModify.jsp?mode=insert';
}

function apply()
{	
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
	
	var fields = new Array (f_query_add_mod.document.forms[0].reason_code,f_query_add_mod.document.forms[0].reason_desc,f_query_add_mod.document.forms[0].status);
	var reasonCode =getLabel("Common.ReasonCode.label","Common");
	var	description =getLabel("Common.description.label","Common");
	var names = new Array (reasonCode,description);	
//	if(f_query_add_mod.checkFieldsofMst(namefields,s,messageFrame)) 
		
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame)) 
		{	
			
			f_query_add_mod.document.forms[0].submit();
			
		}
	}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/ReasonsAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();

}

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ReasonsAddModify.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("Reasons.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
}
else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ReasonsQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}
function query()
{
	f_query_add_mod.location.href='../../eOT/jsp/ReasonsQueryCriteria.jsp';
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function checkMaxLimit1(obj,maxSize) 
 {
  var len  = obj.value;
     if ( len.length > maxSize ){   
		var msg = getMessage("APP-OT0114","OT");
		var msgArray = msg.split("#");
		var lbl_text = getLabel("Common.description.label","Common");
		alert(msgArray[0]+lbl_text+msgArray[1]+" "+maxSize+" "+msgArray[2]); 
    	var revertField = obj.value.slice(0, maxSize);
		obj.value=revertField;
		event.returnValue = false;
        obj.focus();
      } 
 } 

function openDialogWindow(strVal,row_num){
	//alert(row_num);
	var formObj = document.QueryResult;
	var remarks = eval("formObj.remarks_"+row_num).value;
	//alert(remarks);
  //var remarks = escape(obj.value);
	//var remarks = obj.value;
    window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+strVal+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

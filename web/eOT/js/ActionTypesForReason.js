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
	//var source=document.forms[0].source.value;
	f_query_add_mod.location.href='../../eOT/jsp/ActionTypesForReasonFrameInCreateMode.jsp?mode=insert';
}

function apply()
{	

	
		//alert("In apply for Function status");
	//var formObj = parent.frames[1].frames[2].document.forms[0];
	//var formObj=window.parent.frames[1].frames[1].frames[1].document.forms[0];
	if(typeof parent.content.f_query_add_mod.master_frame!="undefined"){
	
	var formObj=parent.content.f_query_add_mod.detail_frame.document.forms[0];
    if(formObj!=null)
	{
	//alert(formObj.name);
	var params = formObj.params.value;
	//alert(params);
	var reason_code=formObj.reason_code.value;
	//alert("reason_code=="+reason_code);
	var arr = formObj.elements;
	var xmlStr=formXMLString(arr);	
	if(xmlStr!="<root></root>"){
		var action="../../servlet/eOT.ActionTypesForReasonServlet?reason_code="+reason_code;
		//var arr = formObj.elements;
		//alert(xmlStr);
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		
	//alert(retVal);
	/*if(retVal== "Completed Successfully")
		var mesg = "<B><Font style='font-size:11pt;'>"+retVal+"</font></B>";
	else
		var mesg = "<B><Font style='font-size:11pt;'>"+retVal+"</font></B>";
		var mesg = "<B><Font style='font-size:11pt;'>"+retVal+"</font></B>";
		window.parent.frames[1].frames[1].frames[1].document.location.reload();
		parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}else{
		var mesg = "<B><Font style='font-size:11pt;'>No Changes to Apply...</B></font>";
		parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}*/
	
	

	   var retVal = xmlHttp.responseText;
		var mesg = retVal;
		parent.content.f_query_add_mod.detail_frame.document.location.reload();
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;

	}else{
		var mesg = getMessage("NO_CHANGE_TO_SAVE","Common");
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
	}
	else
		{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
	else
	{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}

}

function formXMLString(arrObj){
	var xmlString="<root>";
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" && arrObj[i].db_change=="Y"){
			   xmlString+="<RECORD_"+arrObj[i].getAttribute('action_code')+" ";
			   xmlString+="action_code=\""+arrObj[i].getAttribute('action_code')+"\""+" ";
			   xmlString+="select_value=\""+arrObj[i].getAttribute('select_yn')+"\""+" ";
			   xmlString+="update_flag=\""+arrObj[i].getAttribute('update_f')+"\""+" />";
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

/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ActionTypesForReasonFrameInCreateMode.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("ActionTypesForReason.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("ActionTypesForReasonQueryCriteria.jsp") != -1)
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
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;
    } */ 			//Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/ActionTypesForReasonQueryCriteria.jsp';
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
var reason_code=frm.reason_code.value;
var frmObj = window.parent.frames[1];
/*var fields = new Array (frm.reason_code);
var reason_code=getLabel("Common.ReasonCode.label","Common");
var names = new Array(reason_code);
		if(checkFieldsofMst( fields, names, messageFrame)){ 
			frm.document.forms[0].submit();
		} */
if(reason_code=='')
	{
	}else
frmObj.location.href="../../eOT/jsp/ActionTypesForReasonDetailForm.jsp?reason_code="+reason_code;
}

function checkNull(retVal)
{
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}


async function callReasons(obj,target){
	//alert(window.parent.frames[1].name);
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	//var search=getLabel("Common.search.label","Common");
	//var tit="Reason Search" ;
	var tit=getLabel("Common.reason.label","common");
	var locale = document.forms[0].locale.value;
	//var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS  WHERE UPPER(REASON_DESC) LIKE UPPER(?)AND UPPER(REASON_CODE) LIKE UPPER(?) ORDER BY 1";
	var sql="SELECT REASON_DESC DESCRIPTION, REASON_CODE CODE FROM OT_REASONS_LANG_VW  WHERE UPPER(REASON_DESC) LIKE UPPER(?)AND UPPER(REASON_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
        
	}else{
		
		target.value="";
		obj.value="";
	}
 }






async function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}


function validateCheckBox(obj){
	var formObj = document.forms[0];
	formObj.modified_flag.value="false";
	if(obj.checked==true){
			obj.setAttribute('select_yn','Y');
			//obj.select_yn="Y";
	}else{
		   obj.setAttribute('select_yn','N');
	}
	var arrObj = document.forms[0].elements;
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox"){
			if(arrObj[i].value==arrObj[i].select_yn){
			  arrObj[i].db_change="N";
			 	  continue;
			}else{
				formObj.modified_flag.value="true";
				 arrObj[i].db_change="Y";
		    }
		}
	}

}

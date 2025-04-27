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
    }
	f_query_add_mod.location.href='../../eOT/jsp/FunctionsForRoleFrameInCreateMode.jsp?mode=insert';
}
function chkForDuplicates()
{   
	var dtl_frm=window.parent.frames[1].frames[1].frames[1].document.forms[0];
	var dtlFormObj=dtl_frm.document.forms[0];
	var arrObj=dtl_frm.document.forms[0].elements;
	var chkval=dtlFormObj.chkval.value;
	var srl_no_from_DB=dtlFormObj.srl_no_from_DB.value;
	var err_txt="";
	  for(var i=0;i<arrObj.length;i++){
		if(arrObj[i+1].type=="checkbox" && arrObj[i+1].value=="N"){
			if(srl_no_from_DB.indexOf(arrObj[i+1].srl_no)>=0){
				  err_txt=getMessage("SEQ_NO_EXISTS","OR");
			      arrObj[i].focus();
                  arrObj[i].select();
				  window.parent.frames[1].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
				  return false;
      }
}
				
		}//for end
      return true;
}
function apply(){	
	
	if(typeof parent.content.f_query_add_mod.detail_frame!="undefined" ){
	var frm=parent.content.f_query_add_mod.detail_frame.document.forms[0]; //detail Frame
	if(frm!=null)
	{
	
// added by YadavK on 10-09-09  for 14314
	var flag=true;
	var st=frm.start.value;
	for(var i=st;i<=parseInt(frm.rowNo.value-1);++i)
		{
		if(parent.content.f_query_add_mod.detail_frame.document.getElementById("Srl_No"+i).value=="" && parent.content.f_query_add_mod.detail_frame.document.getElementById("chk_select"+i).checked==true)
			{
			flag=false;break;
			}
			else if(parent.content.f_query_add_mod.detail_frame.document.getElementById("Srl_No"+i).value=="" && parent.content.f_query_add_mod.detail_frame.document.getElementById("chk_select"+i).checked==false)
					{flag=true;}
		
		}
		if (flag==true)
		{		
//================= end =================
			var arrobj=frm.elements;
			var params = frm.params.value;
			var role_id=frm.role_id.value;
			var arr = frm.elements;
			var xmlStr=formXMLString(arr);	
				if(xmlStr!="<root></root>"){
					var action="../../servlet/eOT.FunctionForRoleServlet?role_id="+role_id;
					var xmlDoc = "";
					var xmlHttp = new XMLHttpRequest();
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST",action,false);
					xmlHttp.send(xmlDoc);
					var retVal = xmlHttp.responseText;
					parent.content.f_query_add_mod.detail_frame.location.reload();
					parent.content.f_query_add_mod.location.reload();
					var mesg = retVal;
					parent.content.f_query_add_mod.detail_frame.document.location.reload();
					parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				}else{
					var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
					parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
				}
// added by YadavK on 10-09-09  for 14314
		}else
		{
			var seqNo=getLabel("Common.SequenceNo.label","Common");
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var mesg=msgArray[0]+seqNo+msgArray[1];
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}
//================= end =================
}else{
     parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
     }
	}else{
     parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
     }
}


function formXMLString(arrObj){
	var xmlString="<root>";
	for(var i=0;i<arrObj.length;i++){
		/*if(arrObj[i].type=="checkbox" && arrObj[i].db_change=="Y"){
			   xmlString+="<RECORD_"+arrObj[i].func_id+" ";
			   xmlString+="func_id=\""+arrObj[i].func_id+"\""+" ";
			   xmlString+="srl_no=\""+arrObj[i].srl_no+"\""+" ";
			   xmlString+="select_value=\""+arrObj[i].select_yn+"\""+" />";
		 }*/
		if(arrObj[i].type=="checkbox" && arrObj[i].getAttribute('db_change')=="Y"){
			   xmlString+="<RECORD_"+arrObj[i].getAttribute('func_id')+" ";
			   xmlString+="func_id=\""+arrObj[i].getAttribute('func_id')+"\""+" ";
			   xmlString+="srl_no=\""+arrObj[i].srl_no+"\""+" ";
			   xmlString+="select_value=\""+arrObj[i].getAttribute('select_yn')+"\""+" />";
		 }
	}
	xmlString+="</root>";
	return xmlString;
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/FunctionsForRoleMain.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsForRoleFrameInCreateMode.jsp") != -1){
	 if(f_query_add_mod.document.location.href.indexOf("FunctionsForRoleMain.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
 }if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsForRoleQueryCriteria.jsp") != -1)
	{
	 f_query_add_mod.document.forms[0].reset();
	}
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	/* if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;
    } */  //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/FunctionsForRoleQueryCriteria.jsp';
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
var role_id=frm.role_description.value;
var frmObj = window.parent.frames[1];
var role_id_desc=getLabel("Common.Role.label","Common");
var msg = getMessage("CANNOT_BE_BLANK","OT");
if(role_id!='') {
frmObj.location.href="../../eOT/jsp/FunctionsForRoleDetailForm.jsp?role_id="+role_id;
} else {
var msgArray = msg.split("&");
alert(msgArray[0]+role_id_desc+msgArray[1]);
}
}

function clearvalues(){
window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
function validateCheckBox(obj){
	var formObj = document.forms[0];
	var objname=obj.name;
	var id = objname.replace("chk_select","");
	var target = eval("formObj.Srl_No"+id);
	var seq_label = getLabel("Common.SequenceNo.label","Common");
	formObj.modified_flag.value="false";
	if(obj.checked==true){
		//obj.select_yn="Y";	
		obj.setAttribute('select_yn','Y');		
	}else{
	   //obj.select_yn="N";
	   obj.setAttribute('select_yn','N');
	}

	var arrobj1=document.forms[0].elements;
	//

	for(var i=0;i<arrobj1.length-1;i++){
			arrobj1[i+1].srl_no=arrobj1[i].value;
			i++;
	}	
	if(obj.checked==true){
		if(target.value=="" || target.value==null){
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			alert(msgArray[0]+seq_label+msgArray[1]);
			target.select();
			return;
		}else if(target.value<=0){
			//target.location_type_desc=obj.value;
			//This has to be replaced from resource bundle
			var msg = getMessage("VALUE_GREATER_ZERO","OA");
			var msg_arr = msg.split("#");
			alert(msg_arr[0]+seq_label+msg_arr[1]);
			obj.checked = false;
			target.select();
			return;
		}
	}	
	var arrObj = document.forms[0].elements;
	
	for(var i=0;i<arrObj.length;i++){
		if(arrObj[i].type=="checkbox" ){
			if(arrObj[i].value==arrObj[i].getAttribute('select_yn')){
			  //arrObj[i].db_change="N";
			 arrObj[i].setAttribute('db_change','N');
				  continue;
			}else{
				formObj.modified_flag.value="true";
				 //arrObj[i].db_change="Y";	
				arrObj[i].setAttribute('db_change','Y');				 
			}
		}		
	}			
}

function CheckNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.select();
			obj.value="";
            obj.focus();
            return false;
        }
    }
}

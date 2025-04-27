/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var effStatus= new Array();
var selected= new Array();

function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/FunctionsForUserFrameInCreateMode.jsp?mode=insert';
}

function apply()
{	

	
	if(typeof parent.content.f_query_add_mod.detail_frame!="undefined" ){
	var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	if(formObj!=null)
	{
	var params = formObj.params.value;
	var user_id=formObj.user_id.value;
	var arr = formObj.elements;
	var xmlStr=formXMLString(arr);	
	if(xmlStr!="<root></root>"){
		var action="../../servlet/eOT.FunctionForUserServlet?user_id="+user_id;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = xmlHttp.responseText;
		//var mesg = "<B><Font style='font-size:11pt;'>"+retVal+"</font></B>";
		var mesg =retVal;
		parent.content.f_query_add_mod.detail_frame.document.location.href = "../../eOT/jsp/FunctionsForUserDetailForm.jsp?user_id="+user_id;
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;

	}else{
		//var mesg = "<B><Font style='font-size:11pt;'>No Changes to Save...</B></font>";
		var mesg = getMessage("NO_CHANGE_TO_SAVE","Common");
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
	}
	else{
     parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
     }
	}else{
     parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
     }
	
}

function formXMLString(){
	var xmlString="<root>";
	var hash = new Hashtable();
	hash = parent.content.hidden_frame.hash;
	hash_verify = parent.content.hidden_frame.dupChk;
	var formObj  = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	if(hash.size()>0){
		var key = hash.keys();
		var arr=key.toString().split(",");
		for(var i=0;i<arr.length;i++){
			   xmlString+="<RECORD_"+i+" ";
			   var arr1=hash.get(arr[i]).split("@@");
			   var allow_verify = (hash_verify.get(arr[i])!=null)?hash_verify.get(arr[i]):arr1[1];
               xmlString+="func_id=\""+arr1[0]+"\""+" ";
			   xmlString+="allow_verif=\""+allow_verify+"\""+" ";
			  // xmlString+="select_value=\""+arr1[2]+"\""+" ";
			   xmlString+="c_mode=\""+arr1[2]+"\""+" />";
		}
	  }
    
	if(hash.size()==0 && hash_verify.size()>0){
		var key = hash_verify.keys();
		var arr=key.toString().split(",");
		for(var i=0;i<arr.length;i++){
			var obj = eval("formObj.chk_select"+arr[i]);
			if(obj.checked){
				xmlString+="<RECORD_"+i+" ";
				xmlString+="func_id=\""+eval("obj.func_id")+"\""+" ";
				xmlString+="allow_verif=\""+hash_verify.get(arr[i])+"\""+" ";
				xmlString+="c_mode='U' />";
			}
		 }
	  }
	xmlString+="</root>";
	hash.clear();
	hash_verify.clear();
	return xmlString;
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/FunctionsForUserMain.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();
}


function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsForUserFrameInCreateMode.jsp") != -1){
	var hash = new Hashtable();
	hash = parent.content.hidden_frame.hash;
	 hash.clear();

	 if(f_query_add_mod.document.location.href.indexOf("FunctionsForUserMain.jsp") != -1)
	//if(typeof f_query_add_mod=="undefined"){
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("FunctionsForUserQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}


function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;

    }
	f_query_add_mod.location.href='../../eOT/jsp/FunctionsForUserQueryCriteria.jsp';
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
	var user_id= frm.user_id.value;
	var messageFrame= parent.parent.messageFrame;
	var category_value=getLabel("Common.user.label","Common");
	var fields = new Array (frm.user_id);
	var names = new Array (category_value);
	if(checkFieldsofMst( fields, names, messageFrame)) {
		var frmObj = window.parent.frames[1];
		frmObj.location.href="../../eOT/jsp/FunctionsForUserDetailForm.jsp?user_id="+user_id;	
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function validateCheckBox(obj){
	var formObj = document.forms[0];
	var str = obj.name;
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var hash_verif = new Hashtable();
	hash_verif = parent.parent.frames[3].dupChk;
	var index =str.replace("chk_select","");
	if(obj.checked==true){
			if(hash.get(index)==null){
				obj.value="Y";
				hash.put(index,obj.getAttribute("func_id")+"@@"+obj.getAttribute("allow_verif")+"@@I");
			}else
				hash.remove(index);
	}else{			
		if(hash.get(index)==null){
			obj.value="N";
			hash.put(index,obj.getAttribute("func_id")+"@@"+obj.getAttribute("allow_verif")+"@@D");
		}else{
			hash.remove(index);
		}
	}
}


function getCheckBoxValue(key){
	var hash = new Hashtable();
	var hash_obj = new Hashtable();
	hash = parent.parent.frames[3].dupChk;
	hash_obj = parent.parent.frames[3].hash;
	var formObj = document.forms[0];
	var sel = (eval("formObj.allow_verif"+key).checked==true)?"Y":"N";
	if(hash.get(key)==null){
		hash.put(key,sel);
	}else
		hash.remove(key);
}

function callAllowVerificationChkBox(key){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].dupChk;
	var formObj = document.forms[0];
	var chkBoxobj = eval("formObj.allow_verif"+key);
	chkBoxobj.checked = (hash.get(key)=="Y")?true:false;
}

function assignCheckBoxValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	verify_hash = parent.parent.frames[3].dupChk;
	if(hash.get(key)!=null ){
		var val = hash.get(key).split("@@");
		var allow_verify = (verify_hash.get(key)!=null)?verify_hash.get(key):val[1];
		eval("formObj.allow_verif"+key).checked=(allow_verify=="Y")?true:false;
		eval("formObj.chk_select"+key).checked= (val[2]=="I")?true:false
	}
}



  
function previous(){
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var user_id=frm.user_id.value;
	var start = formObj.start.value;
    var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var keys = hash.keys();
	var hash_verify = new Hashtable();
	hash_verify = parent.parent.frames[3].dupChk;
	var verify_keys = hash_verify.keys();
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	document.location.href="../../eOT/jsp/FunctionsForUserDetailForm.jsp?from="+start+"&to="+end+"&user_id="+user_id+"&totalSelected="+keys+"&allowVerify="+verify_keys;
}

function next(){
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var user_id=frm.user_id.value;
	var start = formObj.start.value;
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
    var keys = hash.keys();
	var hash_verify = new Hashtable();
	var hash_verify = parent.parent.frames[3].dupChk;
	var verify_keys = hash_verify.keys();
    formObj.start.value=parseInt(start)+14;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+14;
	end = formObj.end.value;
	document.location.href="../../eOT/jsp/FunctionsForUserDetailForm.jsp?from="+start+"&to="+end+"&user_id="+user_id+"&totalSelected="+keys+"&allowVerify="+verify_keys;
}

/*function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
*/
function clearvalues() {
    // Reset the form
    //document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
    window.location.reload();
}


function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

async function callUser(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.user.label","common");
	
	var sql="SELECT APPL_USER_ID CODE,APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'E') = 'E'  AND UPPER(APPL_USER_ID) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) ORDER BY 2 ";
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
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


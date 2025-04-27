/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create(){
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true){
		cmf.apply.disabled=false;
    }
	f_query_add_mod.location.href='../../eOT/jsp/PractitionerTypesForRoleTypesFrameInCreateMode.jsp?mode=insert';
}

function apply(){	
	//var formObj_hdr = f_query_add_mod.frames[0].document.forms[0]; //header Form (PractitionerTypesForRoleTypes_Form)
	var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
	//if(formObj_hdr!=null){
	 if(typeof parent.content.f_query_add_mod.master_frame!="undefined" ){
		var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0]; //Detail Form
		if(formObj!=null){
		//var params = formObj.params.value;
		var role_type=formObj.role_type.value;
		formObj.totalSelected.value="";
		var xmlStr=formXMLString();	
		if(xmlStr!="<root></root>"){
			var action="../../servlet/eOT.PractitionerTypesForRoleTypesServlet?role_type="+role_type;
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",action,false);
			xmlHttp.send(xmlDoc);
			var retVal = xmlHttp.responseText;
			mesg = retVal;
			parent.content.f_query_add_mod.detail_frame.document.location.reload();
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}else{
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}
		}else
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}else
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function formXMLString(){
	var hash = new Hashtable();
	hash = parent.content.hidden_frame.hash;
	//alert("apply "+hash.toString());
	var key = hash.keys();
	var xmlString="<root>";
	for(var i=0;i<key.length;i++){
			   xmlString+="<RECORD_"+i+" ";
			   var arr= hash.get(key[i])
			   xmlString+="practitioner_type=\""+arr[0]+"\""+" ";
			   xmlString+="select_value=\""+arr[1]+"\""+" />";
		 
	}
	xmlString+="</root>";
	//alert(xmlString);
	hash.clear();
	return xmlString;
}
/*
function reset(){
	f_query_add_mod.document.forms[0].reset();
}
*/


function reset() {

	// if(f_query_add_mod.document.location.href.indexOf("PractitionerTypesForRoleTypesMain.jsp") != -1)
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PractitionerTypesForRoleTypesFrameInCreateMode.jsp") != -1){

	var hash = new Hashtable();
	hash = parent.content.hidden_frame.hash;
	 hash.clear();

	 if(typeof parent.content.f_query_add_mod=="undefined")
		  return false;
	 else
		 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("PractitionerTypesForRoleTypesQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query(){
	var cmf=commontoolbarFrame.document.forms[0];
	////alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
	  //commontoolbarFrame.document.forms[0].reset.disabled=true;

    }
	f_query_add_mod.location.href='../../eOT/jsp/PractitionerTypesForRoleTypesQueryCriteria.jsp';
}

function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}

function callDetailForm(){
	var role_type=document.forms[0].role_type.value;	
	if(role_type!=""){
		var RstfrmObj = window.parent.frames[1];
		RstfrmObj.location.href="../../eOT/jsp/PractitionerTypesForRoleTypesDetailForm.jsp?role_type="+role_type;
	}else{

		var mesg=getMessage("CANNOT_BE_BLANK","OT").replace('&',getLabel("Common.RoleType.label","Common") );
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
}

function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}

function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function validateCheckBox(obj){
	var formObj = document.PractitionerTypesForRoleTypesDetailForm;
	formObj.modified_flag.value="false";
	var arrObj = document.forms[0].elements;
	var hash = new Hashtable();
	var indx = obj.name.replace("chk_select" , "");
	hash = parent.parent.frames[3].hash;
	var record= new Array();
	if(obj.checked==true){
			obj.select_yn="Y";
			record[0]=obj.getAttribute("practitioner_type");
			record[1]="Y";
	}else{
		   obj.select_yn="N";
		   record[0]=obj.getAttribute("practitioner_type");
			record[1]="N";
	}

	if(hash.get(indx)!=null){
		hash.remove(indx);
	}else{
		hash.put(indx,record);
	}

		
}

function previous(){	
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var keys = hash.keys();
	var modified_flag=formObj.modified_flag.value;
	var role_type=frm.role_type.value;
	//alert(role_type);
	
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	
	document.location.href="../../eOT/jsp/PractitionerTypesForRoleTypesDetailForm.jsp?from="+start+"&to="+end+"&role_type="+role_type+"&totalSelected="+keys;
	
		
}

  function next(){
	 var hash = new Hashtable();
     hash = parent.parent.frames[3].hash;
 	 var keys = hash.keys();
     var frm=window.parent.frames[0].document.forms[0];    
	 var formObj = document.forms[0];
	 var modified_flag=formObj.modified_flag.value;
	 var role_type=frm.role_type.value;
	 var start = formObj.start.value;
	 formObj.start.value=parseInt(start)+14;
	 start = formObj.start.value;
	 var end = formObj.end.value;
	 formObj.end.value=parseInt(end)+14;
	 end = formObj.end.value;
     var masterFrame=window.parent.frames[0];
	 var detailFrame=window.parent.frames[1];
	 
     document.location.href="../../eOT/jsp/PractitionerTypesForRoleTypesDetailForm.jsp?from="+start+"&to="+end+"&role_type="+role_type+"&totalSelected="+keys;
	 
}



function assingListItemValue(key){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[1]=="Y")
			eval("formObj.chk_select"+key).checked=true;
		else
			eval("formObj.chk_select"+key).checked=false;
	}
}

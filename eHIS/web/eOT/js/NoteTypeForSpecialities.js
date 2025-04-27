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
	f_query_add_mod.location.href='../../eOT/jsp/NoteTypeForSpecialitiesFrameInCreateMode.jsp?mode=insert';
}

function apply()
{	
	//var formObj_hdr = f_query_add_mod.frames[0].document.forms[0]; //header Form (PractitionerTypesForRoleTypes_Form)
	var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
	if(typeof parent.content.f_query_add_mod.master_frame!="undefined"){
	//var formObj = parent.frames[1].frames[1].frames[1].document.forms[0]; //Detail Form
	//var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	if(typeof parent.content.f_query_add_mod.detail_frame!="undefined" ){
    var formObj = parent.content.f_query_add_mod.detail_frame.document.forms[0];
	if(formObj!=null)
	{
	var params = formObj.params.value;
	var speciality_code=formObj.speciality_code.value;
	var arr = formObj.elements;
	var hash = new Hashtable();
	var hash1 = new Hashtable();
	//hash = parent.frames[1].frames[3].hash;
	hash = parent.content.hidden_frame.hash;
	//hash1 = parent.frames[1].frames[3].dupChk;
	hash1 = parent.content.hidden_frame.dupChk;
	//alert(arr[0].value);
	//var location_type_desc="LOcation ";//getLabel("Common.locationtype.label","common");
	//var fields = new Array ( formObj.location_type_desc);
	//var names = new Array (location_type_desc);
	//var messageFrame = window.parent.parent.messageFrame;
	//if(checkFieldsofMst( fields, names, messageFrame)){
	var xmlStr=formXMLString();	
	//alert("xmlStr "+xmlStr);
	if(xmlStr!="<root></root>"){
		var action="../../servlet/eOT.NoteTypeForSpecialitiesServlet?speciality_code="+speciality_code;
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
	}
	else
		{
		parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	    }
		}else
		{   //var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
			parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		}
	}
	else{
			
            parent.content.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
}
	

function formXMLString(){
	var xmlString="<root>";
	var hash = new Hashtable();
	//hash = parent.frames[1].frames[3].hash;
	hash = parent.content.hidden_frame.hash;
	if(hash.size()>0){
		var key = hash.keys();
		var arr=key.toString().split(",");
		for(var i=0;i<arr.length;i++){
			   xmlString+="<RECORD_"+i+" ";
			   var arr1=hash.get(arr[i]).split("@@");
			   xmlString+="location_type_desc=\""+arr1[0]+"\""+" ";
			   xmlString+="note_type=\""+arr1[1]+"\""+" ";
			    xmlString+="select_value=\""+arr1[2]+"\""+" />";
		}
	}
	xmlString+="</root>";
	hash.clear();
	return xmlString;
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/NoteTypeForSpecialitiesFrameInCreateMode.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}
/*
function reset()
{
	
	f_query_add_mod.document.forms[0].reset();
}
*/


function reset() {
	//hash = parent.frames[1].frames[3].hash;
	hash = parent.content.hidden_frame.hash;
	//var dupChk = parent.frames[1].frames[3].dupChk;
	var dupChk = parent.content.hidden_frame.dupChk;
	hash.clear();
	 //if(f_query_add_mod.document.location.href.indexOf("NoteTypeForSpecialitiesMain.jsp") != -1){
	if(typeof parent.content.f_query_add_mod=="undefined"){
 		hash.clear();
		dupChk.clear();
		  return false;
	 }else{
 		 f_query_add_mod.document.location.reload();
		 	hash.clear();
			dupChk.clear();
	 }
}

function query()
{
	var cmf=commontoolbarFrame.document.forms[0];
	hash = parent.frames[1].frames[3].hash;
	hash.clear();
	//alert("commontoolbarFrame document==="+cmf.name);
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    }
	f_query_add_mod.location.href='../../eOT/jsp/NoteTypeForSpecialitiesQueryCriteria.jsp';
	
}
function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else
		document.forms[0].status.value="D";
}




function callDetailForm(){
//window.parent.parent.frames[3].hash.clear()

hash = parent.parent.frames[3].hash;
dupChk = parent.parent.frames[3].dupChk;
hash.clear();
dupChk.clear();
var frmObj=window.parent.frames[0];
var frm=frmObj.document.forms[0];
var frmObj = window.parent.frames[1];
var speciality_code=frm.speciality_description.value;
	if(speciality_code!=""){
		var RstfrmObj = window.parent.frames[1];
		RstfrmObj.location.href="../../eOT/jsp/NoteTypeForSpecialitiesDetailForm.jsp?speciality_code="+speciality_code;
	}else{

		var mesg=getMessage("CANNOT_BE_BLANK","OT").replace('&',getLabel("Common.speciality.label","Common") );
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
	}
}
/*
function callDetailForm(){

var frmObj=window.parent.frames[0];
var frm=frmObj.document.forms[0];
var speciality_code=frm.speciality_description.value;
//alert("speciality_code=="+speciality_code);
var frmObj = window.parent.frames[1];
if(speciality_code!='')
	frmObj.location.href="../../eOT/jsp/NoteTypeForSpecialitiesDetailForm.jsp?speciality_code="+speciality_code;
}

*/
function clearvalues(){
	document.forms[0].reset();
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}
function clearDtl_Frame(){
	window.parent.frames[1].location.href="../../eCommon/html/blank.html";
}



function valueChanged(obj){
	var formObj = document.forms[0];
	var hash = new Hashtable();
	var hash1 = new Hashtable();
	var indx = obj.name.replace("location_type_desc" , "");
	hash = parent.parent.frames[3].hash;
	hash1 = parent.parent.frames[3].dupChk;
	var id = obj.name.replace("location_type_desc","");
	var target = eval("formObj.chk_select"+id);
	
	if(obj.value!=""){
		target.location_type_desc=obj.value;
	}else{
		target.checked = false;
	}
	if(obj.value!=""){
		target.checked = false;
		isDuplicateRecord(target);
		target.select_yn="N";
		hash.remove(indx);
		hash1.remove(indx);
	}else{
	hash.remove(indx);
	hash1.remove(indx);
	
	}

}


function isDuplicateRecord(obj){
	var formObj = document.forms[0];
	var frmObj=window.parent.parent.frames[1].frames[0].NoteTypeForSpecialityMain_form;
	var splty_code=frmObj.speciality_description.value;
	var id = obj.name.replace("chk_select","");
	var hash = new Hashtable();
	hash = parent.parent.frames[3].dupChk;
// To retrieve all saved location types.
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "splty_code="+splty_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","NoteTypeForSpecialitiesValidation.jsp?func_mode=populateLocType&"+params,false);
	xmlHttp.send(xmlDoc);

	var retVal = trimString(xmlHttp.responseText);
	var retVal_arr = retVal.split("~");
	var keys_arr = hash.keys();
	for(k=0;k<retVal_arr.length-1;k++){
		var retVal_arr1 = retVal_arr[k].split("##");
		if(retVal_arr1[1]==obj.getAttribute('note_type') ){
			if(retVal_arr1[0]==obj.location_type_desc){
			alert(getMessage("RECORD_ALREADY_EXISTS","Common"));
			obj.checked=false;
			eval("formObj.location_type_desc"+id).value="";
			}
		}
	}
}


function isLocationTypeBlank(obj){
	var formObj = document.forms[0];
	var id = obj.name.replace("chk_select","");
	var flg = (eval("formObj.location_type_desc"+id).value=="")?true:false;
	if(flg){ 
		var msg = getMessage("LOCN_TYPE_NOT_BLANK","OR");
		alert(msg);
		obj.checked=false;
		return true;
	}else
		return false;
}

function isDuplicated(obj){
	var formObj = document.forms[0];
	var condition ="";
	var id = obj.name.replace("chk_select","");
	//alert(target);
	var hash = new Hashtable();
	hash = parent.parent.frames[3].dupChk;
	condition = obj.location_type_desc+"@@"+obj.note_type+"@@Y";
	var target=hash.containsValue(condition);
//	alert("Target ---> "+target)
		if(target){
			alert(getMessage("RECORD_ALREADY_EXISTS","Common"));
			obj.checked=false;
			if(eval("formObj.location_type_desc"+id).disabled==false){
			eval("formObj.location_type_desc"+id).value="";
			}
			return true;
		}else
			return false; 
}

function validateCheckBox(obj){
	var formObj = document.forms[0];
	var arrObj = document.forms[0].elements;
	var hash = new Hashtable();
	var hash1 = new Hashtable();
	hash = parent.parent.frames[3].hash;
	hash1 = parent.parent.frames[3].dupChk;
	var indx = obj.name.replace("chk_select" , "");
	if(obj.checked==true && eval("formObj.location_type_desc"+indx).disabled==false){
		if( !( isLocationTypeBlank(obj) || isDuplicated(obj) ) ){
			//obj.select_yn="Y";
			obj.setAttribute('select_yn','Y');
			//key - checkbox_number value=location_type 
		if(hash.get(indx)==null){

			hash.put(indx,obj.location_type_desc+"@@"+obj.getAttribute("note_type")+"@@"+obj.getAttribute("select_yn"));		
			hash1.put(indx,obj.location_type_desc+"@@"+obj.getAttribute("note_type")+"@@"+obj.getAttribute("select_yn"));
		}else{
			hash.remove(indx);
			//hash1.remove(indx);
		}
	  }	
	}else{
		//obj.select_yn="N";

		obj.setAttribute('select_yn','N');
		if(hash.get(indx)==null){
			hash.put(indx,obj.getAttribute("location_type_desc")+"@@"+obj.getAttribute("note_type")+"@@"+obj.getAttribute("select_yn"));	
			hash1.put(indx,obj.getAttribute("location_type_desc")+"@@"+obj.getAttribute("note_type")+"@@"+obj.getAttribute("select_yn"));		
		//hash1.remove(indx);
			
		}else
		{
			hash.remove(indx);
			hash1.remove(indx);
		}
	}

	
	
	}		

function previous(){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var keys = hash.keys();
	var frm=window.parent.frames[0].document.forms[0];
	var formObj = document.forms[0];
	var modified_flag=formObj.modified_flag.value;
	var speciality_code=frm.speciality_description.value;
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	tot=document.forms[0].totalSelected.value;
	document.location.href="../../eOT/jsp/NoteTypeForSpecialitiesDetailForm.jsp?from="+start+"&to="+end+"&speciality_code="+speciality_code+"&totalSelected="+keys;
}

function assingListItemValue(key){
   	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	if(hash.get(key)!=null){
		var val = hash.get(key).split("@@");
		eval("formObj.chk_select"+key).checked= (val[2]=="Y")?true:false
		eval("formObj.location_type_desc"+key).value=val[0];
	}
}

  function next(){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var keys = hash.keys();
	var frm=window.parent.frames[0].document.forms[0];    
	var formObj = document.forms[0];
	var modified_flag=formObj.modified_flag.value;
	var speciality_code=frm.speciality_description.value;
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+14;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+14;
	end = formObj.end.value;
    var masterFrame=window.parent.frames[0];
    var detailFrame=window.parent.frames[1];
	tot=document.forms[0].totalSelected.value;	 
	 document.location.href="../../eOT/jsp/NoteTypeForSpecialitiesDetailForm.jsp?from="+start+"&to="+end+"&speciality_code="+speciality_code+"&totalSelected="+keys;
}



function pushChkBox(indx,val){
		var hash = new Hashtable();
		hash = parent.parent.frames[3].dupChk;
		hash.put(indx,val);
	
}


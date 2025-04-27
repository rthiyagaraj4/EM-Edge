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
	//alert("in create");
	//module_id=OT&function_id=DrugNotification&function_name=Drugs for Notification&function_type=F&access=YYYNN
	commontoolbarFrame.document.forms[0].apply.disabled=false;
	f_query_add_mod.location.href='../../eOT/jsp/DrugNotificationMain.jsp?mode=create';
}

function emptyDtlCanvas(){
	parent.frames[1].location.href="../../eCommon/html/blank.html";
}

function query(){
	//commontoolbarFrame.document.forms[0].apply.disabled=true; //Commented Against GHL-SCF-1519
	//commontoolbarFrame.document.forms[0].reset.disabled=true;
	f_query_add_mod.location.href='../../eOT/jsp/DrugNotificationQueryCriteria.jsp?mode=modify';
}

function reset() {


	var hash =window.hidden_frame.hash;
	  hash.clear();
	 /*if(f_query_add_mod.document.location.href.indexOf("DrugNotification.jsp") != -1)
		  return false;
	 else
		 f_query_add_mod.document.location.reload();*/
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DrugNotificationMain.jsp") != -1){

	 if(f_query_add_mod.document.location.href.indexOf("DrugNotification.jsp") != -1)
		  return false;
	 else
		f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DrugNotificationQueryCriteria.jsp") != -1)
	{
		 f_query_add_mod.document.forms[0].reset();
	}
}

function apply(){
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var action = "../../servlet/eOT.DrugForNotificationServlet";
	//var formObj = document.frames.f_query_add_mod.QryRstFrame.document.forms[0];
	var formObj = f_query_add_mod.QryRstFrame.document.forms[0];
	formObj.totalSelected.value="";

	var xmlStr=formXMLString();
	if(xmlStr!="<root></root>"){
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		f_query_add_mod.QryRstFrame.location.reload();
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+retVal;
	}else{
		var mesg=getMessage("NO_CHANGE_TO_SAVE","Common");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;			
		return;
	}
}

function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
}

function formXMLString(){
	//var formObj = document.frames.f_query_add_mod.QryRstFrame.document.forms[0];
	var formObj = f_query_add_mod.QryRstFrame.document.forms[0];
	var hash =window.hidden_frame.hash;
	var row_count = formObj.row_count.value;
			
    var notify_yn="";
	var table_name="OT_DRUGS_FOR_NOTIFICATION";
	 var header ="";
	var xmlString="<root>";
	//it will return array of key values;
	var size = hash.keys();
	
		for(var j=0;j<size.length;j++){
			
		xmlString+="<DRUG_NOTIFY"+j+1+" ";
		var record = hash.get(size[j]);
		
		xmlString+="def_type=\""+record[0]+"\""+" ";
		xmlString+="drug_code=\""+record[1]+"\""+" ";
		
		xmlString+="notify_yn=\""+record[2]+"\""+" ";
	
		xmlString+="db_action=\""+record[3]+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	}
	  xmlString+="</root>";

  hash.clear();
  return xmlString;
}


/*function enableSelChkbox(obj){
	obj.value = (obj.checked==true)?"Y":"N";
	registerInRecordQueue(obj);
}*/

function registerInRecordQueue(obj){
	var frmObj =parent.parent.hidden_frame;
	var formObj =document.forms[0];
	var hash = new Hashtable();
	hash = frmObj.hash;
	var rec_id = obj.getAttribute("row_id");
	var def_type =formObj.def_type.value;
	//var drug_code= eval("formObj.drug_code"+rec_id).value;
	var drug_code= eval(document.getElementById("drug_code"+rec_id)).value;
	var notify_yn=(obj.checked==true)?"Y":"N";
	var db_action= obj.getAttribute("db_action");
	var record = new Array();
	record[0] = def_type;
	record[1] = drug_code;
	record[2] = notify_yn;
	record[3] = db_action;

	if(hash.get(rec_id)!=null){
		hash.remove(rec_id);

	}else{
		hash.put(rec_id,record);

	}
	
}

function callSearch(){
	var formObj = document.forms[0];
	//alert(formObj.name);
	var def_type = formObj.lstdefinition_type.value;
	var params = formObj.params.value;
	//alert(params);
	//alert(parent.QryRstFrame.name);
	parent.QryRstFrame.location.href='../../eOT/jsp/DrugNotificationQueryResult.jsp?def_type='+def_type;

}

function previous(){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var keys = hash.keys().toString();
	var frmObj = document.forms[0];
    var def_type = frmObj.def_type.value;
	var formObj = document.forms[0];
	var start = formObj.start.value;
	formObj.start.value=start-14;
	var end = formObj.end.value;
	formObj.end.value=end-14;
	start = formObj.start.value;
	end = formObj.end.value;
	document.location.href='../../eOT/jsp/DrugNotificationQueryResult.jsp?from='+start+"&to="+end+'&def_type='+def_type+"&totalSelected="+keys;
		
}

function next(){
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	var keys = hash.keys().toString();
	var frmObj = document.forms[0];
	var def_type = frmObj.def_type.value;
	var formObj = document.forms[0];
	var start = formObj.start.value;
	formObj.start.value=parseInt(start)+14;
	start = formObj.start.value;
	var end = formObj.end.value;
	formObj.end.value=parseInt(end)+14;
	end = formObj.end.value;
	var masterFrame=window.parent.frames[0];
    var detailFrame=window.parent.frames[1];
	document.location.href='../../eOT/jsp/DrugNotificationQueryResult.jsp?from='+start+"&to="+end+'&def_type='+def_type+"&totalSelected="+keys;
}

/*function nxt(){
	// alert("inside");
	 //var frmObj = document.forms[0];
	 //alert(frmObj.name);
	 //var def_type = frmObj.lstdefinition_type.value;
	 var formObj = document.forms[0];
	 var start = formObj.start.value;
	 formObj.start.value=parseInt(start)+14;
	 start = formObj.start.value;
	 var end = formObj.end.value;
	 formObj.end.value=parseInt(end)+14;
	 end = formObj.end.value;
	 var def_type = formObj.def_type.value;
	 var URL = "../../eOT/jsp/DrugNotificationModify.jsp?from="+start+"&to="+end+"&def_type="+def_type;
	// alert(URL);
	parent.f_query_add_mod.document.location.href=URL;
	 //parent.f_query_add_mod.document.location.href=URL;
	//f_query_add_mod.location.href='../../eOT/jsp/DrugNotificationQueryCriteria.jsp?mode=modify';
	}*/


function AssignDefType(str){
	var frmObj = parent.QryCriteriaFrame.document.forms[0];
    frmObj.lstdefinition_type.value=str;
}


function SPCheckPositiveNumber(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
	
		displyBSAandBMI();

    }
    else {
			document.forms[0].bsa.value="";
			document.forms[0].bmi.value="";
			document.forms[0].status_desc.value="";
        if ( obj.value.length > 0 ) {
            //alert(getMessage("VALUE_GREATER_ZERO"));
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));			
            obj.value="";
            obj.focus();
        }
    }
}



function assignListItemValue(key){
//	alert("assignListItemValue")
	var formObj = document.forms[0];
	var hash = new Hashtable();
	hash = parent.parent.frames[3].hash;
	if(hash.get(key)!=null){
		if(hash.get(key)[2]=="Y")
			eval("formObj.notify_pre_anesthesia_yn"+key).checked=true;
		else
			eval("formObj.notify_pre_anesthesia_yn"+key).checked=false;
	}
 }



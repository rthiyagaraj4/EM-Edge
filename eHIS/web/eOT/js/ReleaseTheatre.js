/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset(){
		registerInRecord();

	parent.content.f_query_add_mod.document.forms[0].reset();
}

function apply(){
	//var obj = eval("document.forms[0].chk_release"+i);
//	alert(obj)
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr="<root>";
	var action = "../../servlet/eOT.ReleaseTheatreServlet";
	xmlStr+=formXMLString();
	xmlStr+="</root>";
	//alert("xmlStr===="+xmlStr)
	if(xmlStr.indexOf("<root></root>")!=-1){
		var mesg = getMessage("NO_CHANGE_TO_SAVE","Common");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+mesg;
		return;
	}
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",action,false);
	xmlHttp.send(xmlDoc);
    var retVal = trimString(xmlHttp.responseText);
	parent.content.f_query_add_mod.location.reload();
	var msg  = (retVal=="RECORD_INSERTED")?getMessage(retVal,"SM"):getMessage(retVal,"OT");
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	//return retVal;  
}

function trimString(sInString){
   return sInString.replace(/^\s+|\s+$/g,"");
}

function registerInRecordQueue(indx){
	//registerInRecord(indx);
	var queue = parent.f_query_add_mod.jobQueue;
	var obj = eval("document.forms[0].chk_release"+indx);
	if(obj.checked==true){
		queue.push(indx);
	}else{
		for(var j in queue){
			if(queue[j]==indx) queue.splice(j,1)
			
		}
	}
}

function formXMLString(){
	var frame_obj=parent.content.f_query_add_mod;
	var records = frame_obj.record;
	var queue = frame_obj.jobQueue;
	var formObj = frame_obj.document.forms[0];
	var xmlString="";
	var table_name="";
	var release_yn = "Y";
	for(var j=0;j<queue.length;j++){
		var hash = new Hashtable();
		hash = records[queue[j]-1];
		xmlString+="<RELEASE_THEATRE"+eval(j+1)+" ";
		xmlString+="theatre_code=\""+hash.get("theatre_code")+"\""+"  ";
		xmlString+="block_date=\""+hash.get("block_date")+"\""+"  ";
		xmlString+="from_time=\""+hash.get("from_time")+"\""+"  ";
		xmlString+="to_time=\""+hash.get("to_time")+"\""+"  ";
		xmlString+="release_yn=\""+release_yn+"\""+" "+" />";
		hash=null;
	}
	return xmlString; 


}

/*function openReason(indx){
	var obj= eval('document.forms[0].reason'+indx);
	var heading=getLabel("Common.remarks.label","Common");
	var remarks = encodeURIComponent(obj.value);
	var param='heading='+encodeURIComponent(heading)+'&para='+remarks+'&size=50';
	var retext= window.showModalDialog('../../eOT/jsp/LeftFrameTextArea.jsp?'+param ,window,"dialogHeight: 150px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	if(retext=='undefined'||retext==null)retext=obj.value;
	obj.value=retext;
}*/

function loadDBDtls(str){
	var records = parent.f_query_add_mod.record;
	//alert("loadDBDtls====="+loadDBDtls);
	var arr = str.split("@@");
	var hash = new Hashtable();
	hash.put("theatre_code",arr[0]);
	hash.put("theatre_desc",arr[1]);
	hash.put("block_date",arr[2]);
	hash.put("from_time",arr[3]);
	hash.put("to_time",arr[4]);
	records.push(hash);
	hash=null;
	//alert(parent.frames[1].recordQueue.length);
	//alert(parent.frames[1].record.length);
	//alert(str);
}

function registerInRecord(){
	var queue = parent.content.f_query_add_mod.jobQueue;
	var length=queue.length;
	for(var j in queue){
			//queue.splice(j,1)
			queue.splice(j,length)
	}
}

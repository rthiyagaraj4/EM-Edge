
function reset()
{
	parent.frames[2].location.reload();
}

async function showModalCurEnc(enc,patid,changefunc)
{
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "500px";
	var dialogWidth	= "1200px";
	var dialogTop = "72" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/"+jsp_name+"?encounterId="+enc+"&patientId="+patid,arguments,features);
	if(retVal!=null && retVal!='')
	parent.frames[2].document.location.reload();
}

async function showModalCancelTrf(enc,patid,facilityId,frmNursCode,frmRoomNo,frmBedNo)
{
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH enc=\""+enc+"\" facilityId=\""+facilityId+"\" frmNursCode=\""+frmNursCode+"\" frmRoomNo=\""+frmRoomNo+"\" frmBedNo=\""+frmBedNo+"\" action='validateFrCanclTrf' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var validate	= trimString(responseText);
	
	var splitVal	= validate.split('|');
	var occupiedBed	= splitVal[0];
	var dischAdv	= splitVal[1];
	var patOut		= splitVal[2];
	var effStatus	= splitVal[3]; //Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074

	var error		= "";
	if (occupiedBed != "null" || dischAdv != "null" || patOut != "null" || effStatus != "null")
	{
		if (occupiedBed == "bed_occupied")
		{
			var error1 = getMessage("OCCUPIED_BED","IP");
			error = error + error1 + "\n";
		}
		if (dischAdv == "disch_adv")
		{
			var error2 = getMessage("DIS_ADVICE_ALREAD_EXISIT","IP");
			error = error + error2 + "\n";
		}
		if (patOut == "pat_out_exist")
		{
			var error3 = getMessage("TRF_PAT_OUT_EXIST","IP");
			error = error + error3 + "\n";
		}
		/*Added by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074*/
		if (effStatus == "DisabledBed")
		{
			var error4 = getMessage("BED_DISABLED","AE");
			error = error + error4 + "\n";
		}
		/*End ML-MMOH-CRF-1074*/
		alert(error);
	}
	else
	{
		var srl_no = parent.frames[2].document.getElementById("srlNo").value; 
		var frmServCode = parent.frames[2].document.getElementById("frmServCode").value; 
		var frmBedClsCode = parent.frames[2].document.getElementById("frmBedClsCode").value; 
		var frmBedClsType = parent.frames[2].document.getElementById("frmBedClsType").value; 
		var frmPractId = parent.frames[2].document.getElementById("frmPractId").value; 
		var frmSpecCode = parent.frames[2].document.getElementById("frmSpecCode").value; 
		var frmSubServCode = parent.frames[2].document.getElementById("frmSubServCode").value; 
		var trfType = parent.frames[2].document.getElementById("trfType").value; 

		var frmNursUtCode = parent.frames[2].document.getElementById("frmNursUtCode").value; 
		var toNursUtCode = parent.frames[2].document.getElementById("toNursUtCode").value; 
		var toBedNo = parent.frames[2].document.getElementById("toBedNo").value; 
		var toRoomNo = parent.frames[2].document.getElementById("toRoomNo").value; 
		var frmBedNo = parent.frames[2].document.getElementById("frmBedNo").value; 
		var frmRoomNo = parent.frames[2].document.getElementById("frmRoomNo").value; 
		
		var modifiedDate = parent.frames[2].document.getElementById("modifiedDate").value; 
		var tfrReqRefNo = parent.frames[2].document.getElementById("tfrReqRefNo").value; 

		var retVal	= new String();
		var dialogHeight= "40vh";
		var dialogWidth = "50vw";
		var dialogTop	= "30";
		var center = "1" ;
		var status="no";
		var arguments	= "" ;

		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ;  status:" + status  + "; dialogTop :" + dialogTop ;
		var callurl="../../eIP/jsp/IPCancelTrfDialogFrameSet.jsp?encounterId="+enc+"&patientId="+patid+"&srlNo="+srl_no+"&frmServCode="+frmServCode+"&frmBedClsCode="+frmBedClsCode+"&frmBedClsType="+frmBedClsType+"&frmPractId="+frmPractId+"&frmSpecCode="+frmSpecCode+"&frmSubServCode="+frmSubServCode+"&trfType="+trfType+"&toBedNo="+toBedNo+"&toRoomNo="+toRoomNo+"&frmBedNo="+frmBedNo+"&frmRoomNo="+frmRoomNo+"&frmNursUtCode="+frmNursUtCode+"&toNursUtCode="+toNursUtCode+"&modifiedDate="+modifiedDate+"&tfrReqRefNo="+tfrReqRefNo;
		retVal =await window.showModalDialog(callurl,arguments,features);

		if(retVal!=null){ 
			parent.frames[1].document.location.reload();
			parent.frames[2].location = "../../eCommon/html/blank.html";
		}

	}
}

function closeWin(obj)
{
	//parent.window.close();   
   // dialogTag.close();
	console.log(parent.parent.document);
	console.log(parent.document);
	console.log(document);
	console.log(parent.parent.document.getElementById("dialog_tag"));
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   

}

function CancelTrf(obj)
{
	if(TrimStr(document.forms[0].cancelReason.value)=="")
	{
		var msg = getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace('$',getLabel("Common.ReasonforCancellation.label","Common"))
		alert(msg);
		document.forms[0].cancelReason.focus();
		return false;
	}
	document.CancelTrfDialog.submit();
}

function imposeMaxLength(obj)
{
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	{
		var error = getMessage("REMARKS_CANNOT_EXCEED","common");
		var remarks = getLabel("Common.ReasonforCancellation.label","common");
		error = error.replace("$",remarks);
		error = error.replace("#","100")
		alert(error);
		obj.value=obj.value.substring(0,mlength);
	}
}


function onSuccess()
{  
	
	alert(getMessage("RECORD_INSERTED",'SM'));
	if(parent.document.getElementById("dialog_tag")){
		parent.document.getElementById("dialog_tag").close();
	}
	
	    
}

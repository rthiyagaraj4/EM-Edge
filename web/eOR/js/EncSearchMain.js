/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
17/10/2014    IN051968		Chowminya      									unbilled/unsettled amount for consultation,allowing placing orders in OR 	
21/10/2015    IN057196	    Ramesh G										Recording Of Consent Form
---------------------------------------------------------------------------------------------------------------
*/
//Functions for MedRecRequestResult Page
function RemSelectAll()
{
	if(document.forms[0].chkAll != null)
	{
		document.forms[0].chkAll.checked = false;
		document.forms[0].selectAll_yn.value == "";
	}
}

async function RecodeDiagnosis(encID, PatID)
{
	
	var call_function = "DIAG_RECODE";
	var FacilityId = document.forms[0].FacilityId.value;4/4/2007
	var dialogHeight= "900px" ;
	var dialogWidth = "800px" ;
	var dialogTop 	= "58";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/DiagRecodePatProblemMain.jsp?episode_id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function+"&modal_yn=Y",arguments,features);
}
async function DiagnososTransmissionDtls(encID, PatID)
{	
	var call_function = "TRANSMIT_NOTIFY_REP";
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "900px" ;
	var dialogWidth = "800px" ;
	var dialogTop 	= "59";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function DiagnososConfirmationDtls(encID, PatID)
{	
	var call_function = "CONF_TRANSMIT_NOTIFY_REP";
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "900px" ;
	var dialogWidth = "800px" ;
	var dialogTop 	= "59";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function recordDiagnosis(func, encounterId, patientId, locn_code, Gender, attend_practitioner_id, DOB, locn_type, patientclass)
{ 
	var jsp_name =  "../../eCA/jsp/PatProblemMain.jsp?Context=IP_Q&IP_YN=Y&Clinic_Code="+locn_code+"&Dob="+DOB+"&Sex="+Gender+"&patient_id="+patientId+"&episode_id="+encounterId+"&ip_practitioner_id="+attend_practitioner_id+"&location_code="+locn_code+"&locn_type="+locn_type+"&patient_class="+patientclass;

	var retVal = 	new String();
	var dialogHeight="900px";
	var dialogWidth="800px";
	var dialogTop="65";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog(jsp_name,arguments,features);
}
//IN051968 - Start
function OPQBlValidation(FacilityId,patientId,encounterId,actionOnPendingBill,visitId,patientclass,episode_id)
{
	var episode_type = "O";
	if(patientclass == "EM")
		episode_type = "E";
	var visit_id = parseInt(visitId);
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" facility_id=\""+FacilityId+"\" ";
	xmlStr+=" p_patient_id=\""+patientId+"\"";
	xmlStr+=" p_episode_type=\""+episode_type+"\" ";
	xmlStr+=" p_episode_id=\""+episode_id+"\"";
	xmlStr+=" p_visit_id=\""+visit_id+"\" ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var url = "../../eCA/jsp/CABLValidation.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);	
	var unbilledArr = xmlHttp.responseText.split("|");
	var p_unbilled_amt	= parseInt(unbilledArr[0]);
	var p_unsettled_amt	= parseInt(unbilledArr[1]);	
	var actionOnPendingBillfalg = false;
	if(p_unbilled_amt==0 && p_unsettled_amt==0)
	{
		actionOnPendingBillfalg = true;
	}
	else
	{
		if(actionOnPendingBill=='W')
		{
			if(confirm(getMessage("UNSETTLED_UNBILLED_AMT_WARNING","OP")))
			{
				actionOnPendingBillfalg = true;
			}
			else
			{
				actionOnPendingBillfalg = false;
			}	
		}else
		{
			alert(getMessage("UNSETTLED_UNBILLED_AMT_STOP","OP"));
			actionOnPendingBillfalg = false;
		}
	}

return actionOnPendingBillfalg;
}
//IN051968 - End
//function callWin(patientclass, func, encounterId, patientId, visit_type,p_dep_appl_yn,FacilityId)
//IN057196 Start.
//function callWin(patientclass, func, encounterId, patientId, visit_type,p_dep_appl_yn,FacilityId,visit_id,actionOnPendingBill,episode_id)//IN051968
async function callWin(patientclass, func, encounterId, patientId, visit_type,p_dep_appl_yn,FacilityId,visit_id,actionOnPendingBill,episode_id,cnsnt_with_order_yn)
//IN057196 End
{  
	//IN051968 - Start
	var actionOnPendingBillfalg = false;
	if(actionOnPendingBill=="N" || (patientclass!="OP" && patientclass!="EM")){
		actionOnPendingBillfalg = true;
	}else{
		actionOnPendingBillfalg = OPQBlValidation(FacilityId,patientId,encounterId,actionOnPendingBill,visit_id,patientclass,episode_id);					
	}
	if(actionOnPendingBillfalg)
	{	
	//IN051968 - End
		var AdjustAgainstDeposit = "N";
		var dialogHeight= "95vh";
		var dialogWidth = "90vw";
		var dialogTop	= "72";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal =  	await top.window.showModalDialog("../../eOR/jsp/OpenFunctionWrapper.jsp?patient_class="+patientclass+"&FacilityId="+FacilityId+"&encounter_id="+encounterId+"&invoke_function_id="+func+"&patient_id="+patientId+"&cnsnt_with_order_yn="+cnsnt_with_order_yn,arguments,features);    
	}
}

async function calladdmodifyMark(encounterId,func, pat_id)
{
	var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "900px" ;
	var dialogWidth = "800px" ;
	var dialogTop 	= "77";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = 	await window.showModalDialog("../../eMR/jsp/MarkEncounterFrames.jsp?Encounter_Id="+encounterId+"&FacilityId="+FacilityId+"&patient_id="+pat_id+"&call_from="+func,arguments,features);
}

function chkForSelectAll(start,end)
{
	if(document.forms[0].criteria != null)
	{
		if(document.forms[0].criteria.value != "validate")
		{
			if(document.forms[0].name =='EncSearchResult')
			{
				if(document.forms[0].selectAll_yn != null && document.forms[0].chkAll != null)
				{
					if(document.forms[0].selectAll_yn.value == "YES")
					{
						document.forms[0].chkAll.checked = true;
						selectAll(document.forms[0].chkAll,start,end)
					}
					else if(document.forms[0].selectAll_yn.value == "NO")
					{
						document.forms[0].chkAll.checked = false;
						selectAll(document.forms[0].chkAll,start,end)
					}
				}
			}
		}
	}
}

function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			{
			 	eval("document.forms[0].chk"+i).checked=true;
				chkServices(eval("document.forms[0].chk"+i))
			}
		}
		document.forms[0].selectAll_yn.value = "YES";
	}
	else
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			{
			 	eval("document.forms[0].chk"+i).checked=false;
				chkServices(eval("document.forms[0].chk"+i))
			}
		}
		document.forms[0].selectAll_yn.value = "NO";
	}
}

function submitPrevNext(from, to)
{
	if(document.forms[0].chkAll != null)
	{
		if(document.forms[0].chkAll.checked)
			{
					document.forms[0].chkAll.checked = true;
			}
			else
			{
					document.forms[0].chkAll.checked = false;
			}
	}
	document.forms[0].finalSelect.value=document.forms[0].temp1.value;
    document.forms[0].from.value = from;
    document.forms[0].to.value = to; 
	document.forms[0].target="";
	document.forms[0].action="../../eOR/jsp/EncSearchResult.jsp";
    document.forms[0].submit();
}
 
function chkServices(Obj)
{
	//alert("clear");
	parent.window[1].document.getElementById('search').disabled=false;
//	alert("254");
	if(Obj.checked)
	{
		document.forms[0].selectAll_yn.value = "";
		document.forms[0].temp1.value=document.forms[0].temp1.value+Obj.value+"$"+Obj.name+"$E~"
		document.forms[0].finalSelect.value=document.forms[0].temp1.value;
//		parent.frames[3].document.forms[0].search.disabled = false;
	}
	else
	{		
		document.forms[0].selectAll_yn.value = "";
		document.forms[0].temp1.value=document.forms[0].temp1.value+Obj.value+"$"+Obj.name+"$D~"
		document.forms[0].finalSelect.value=document.forms[0].temp1.value;
//		parent.frames[3].document.forms[0].search.disabled = true;
	}
}

 function closeWin(enc,patid,changefunc,Patient_Class,call_function,bl_install)
{
	//window.parent.returnValue=val
	//window.parent.close()
	showModalCurEnc1(enc,patid,changefunc,Patient_Class,call_function,bl_install);
}

async function showModalCurEnc1(enc,patid,changefunc,Patient_Class,call_function,bl_install_yn)
{
	var jsp_name="CurrentEncounterMain.jsp";
	var win_height = "900px";
	var win_width= "800px";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn.value+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
	if(retVal!=null && retVal!='')

	parent.content.document.location.reload();
}

//MedRecRequestButtons fuctions 
async function showModalCurEnc()
{
	if(parent.content.document.forms[0])
	{
		var sst="";
		var mm=0;
		var conArray=new Array();
		for(var k=0;k<parent.content.document.forms[0].elements.length;k++)
		{
			if(parent.content.document.forms[0].elements[k].type=="checkbox")
			{
				if(parent.content.document.forms[0].elements[k].checked)
				{
					conArray[mm]=parent.content.document.forms[0].elements[k].value;
					mm++;
				}
			}
		}	
		document.frmButton.selitem.value="["+conArray+"]";
		var lp=document.frmButton.selitem.value;

		document.frmButton.PatientId.value=parent.content.document.forms[0].PatientId.value;
		var pid	= document.forms[0].PatientId.value;
		document.frmButton.from.value=parent.content.document.forms[0].from.value;
		var from=document.frmButton.from.value;

		document.frmButton.to.value=parent.content.document.forms[0].to.value;
		var to=document.frmButton.to.value;

		document.frmButton.finalSelect.value=parent.content.document.forms[0].finalSelect.value;
		
		if(parent.content.document.forms[0].chkAll.checked)
		{
			var finalSelect="SELECTALL";
//			var finalSelect=document.frmButton.finalSelect.value;
		}
		else
		{
			var finalSelect=document.frmButton.finalSelect.value;
		}
		var condition=""
		for(var i=0; i < parent.content.document.forms[0].elements.length; i++)
		condition += parent.content.document.forms[0].elements[i].name +"="+escape(parent.content.document.forms[0].elements[i].value)+"&"

		var call_function = "";
		var jsp_name="MedRecRequestRecordMain.jsp";
//		var jsp_name="MedRecRequestRecordMainNew.jsp";
		var retVal = 	new String();
		var dialogHeight= "37.5";
		var dialogWidth	= "50";		
		var dialogTop = "58";
		var center = "" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var bl_install_yn= parent.content.document.forms[0].bl_install.value;
		retVal =await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?condition="+condition+"&selitem="+lp+"&PatientId="+pid+"&from="+from+"&to="+to+"&modal_yn=Y&finalSelect="+finalSelect+"&bl_install_yn="+bl_install_yn,arguments,features);
	
		parent.parent.frames[2].document.forms[0].search.onclick();
	}
	else
	{
		if(parent.frames[1].document.forms[0].PatientId.value == '')
		{
			error  = getMessage("CAN_NOT_BE_BLANK","Common");
			error = error.replace('$', getLabel("Common.patientId.label","Common"));		
			alert(error);
			parent.frames[1].document.forms[0].PatientId.focus();
		}
	}
}

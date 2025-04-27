
function RemSelectAll()
{
	if(document.forms[0].chkAll != null)
	{
		document.forms[0].chkAll.checked = false;
		document.forms[0].selectAll_yn.value == "";
	}
}



async function DiagnososTransmissionDtls(encID, PatID,FacilityId)
{	
	var call_function = "TRANSMIT_NOTIFY_REP";
	//var FacilityId = document.forms[0].FacilityId.value;
	//commented FacilityId for SCR 4943
	var dialogHeight= "90vh";
	var dialogWidth = "90vw";
	var dialogTop	= "250";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal =  await	top.window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function DiagnososConfirmationDtls(encID, PatID ,FacilityId)
{	
	
	var call_function = "CONF_TRANSMIT_NOTIFY_REP";
	//var FacilityId = document.forms[0].FacilityId.value;
	//commented FacilityId for SCR 4943
	var dialogHeight= "25vh";
	var dialogWidth = "65vw";
	var dialogTop	= "250";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/RecodeDiagnosis.jsp?Encounter_Id="+encID+"&FacilityId="+FacilityId+"&PatientId="+PatID+"&call_function="+call_function,arguments,features);
}

async function calladdmodifyMark(encounterId,func, pat_id,FacilityId)
{
	//var FacilityId = document.forms[0].FacilityId.value;
	var dialogHeight= "90vh";
	var dialogWidth = "80vw";
	var dialogTop	= "150";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/MarkEncounterFrames.jsp?Encounter_Id="+encounterId+"&FacilityId="+FacilityId+"&patient_id="+pat_id+"&call_from="+func,arguments,features);
}


function chkForSelectAll(start,end)
{
	if(document.forms[0].criteria != null)
	{
		if(document.forms[0].criteria.value != "validate")
		{
			if(document.forms[0].name =='MedRecRequestResult')
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
//				eval("document.forms[0].chk"+i).disabled=true;

				chkServices(eval("document.forms[0].chk"+i))
//			 	eval("document.forms[0].chk"+i).disabled=true;
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
//				eval("document.forms[0].chk"+i).disabled=false;
				chkServices(eval("document.forms[0].chk"+i))
//			 	eval("document.forms[0].chk"+i).disabled=false;
			}
		}
		document.forms[0].selectAll_yn.value = "NO";
		
	}
}

function submitPrevNext(from, to)
{
	var function_id		= document.getElementById("function_id").value;
	var call_function	= document.getElementById("call_function").value;
	var PatientId		= document.getElementById("PatientId").value;
	var orderBy_ind	= document.getElementById("orderBy_ind").value;
	var lstPatientClass	= document.getElementById("lstPatientClass").value;

	if(function_id=='RECORD_DIAGNOSIS'||call_function=='RECORD_DIAGNOSIS'){															document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;
		document.forms[0].submit();
	}else if(function_id=='MARK_MLC_OSCC'||call_function=='MARK_MLC_OSCC'){
	document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;
		document.forms[0].submit();
	}else if(function_id=='PROCEDURE_RECORDING'||call_function=='PROCEDURE_RECORDING'){
	document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;;;
		document.forms[0].submit();
	}else if(function_id=='MR_REC_PAT_VAL'||call_function=='MR_REC_PAT_VAL'){
	document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;;;
		document.forms[0].submit();
	}else if(function_id=='MR_INTERNAL_REPORTS_REPRINT'||call_function=='MR_INTERNAL_REPORTS_REPRINT'){
		//parent.resultFrame.location.href="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+document.getElementById("PatientId").value+"&call_function="+document.getElementById("call_function").value+"&from="+from+"&to="+to;
		document.forms[0].target="resultFrame";	document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;;;
		document.forms[0].submit();
	}else if(function_id=='QUERY_MARK_MLC_OSCC'||call_function=='QUERY_MARK_MLC_OSCC'){
			document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;;;
			document.forms[0].submit();
		}else if(function_id=='QUERY_MATERNAL_REPORT'||call_function=='QUERY_MATERNAL_REPORT'){
			document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;;;
			document.forms[0].submit();
		}else if(function_id=='MEDICAL_REPORT_REQUEST'||call_function=='MEDICAL_REPORT_REQUEST'){
			var med_report_button=parent.frames[4].document.forms[0].search;
			if (med_report_button){
					med_report_button .disabled = true
			}
			document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_function="+call_function+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;;;
			document.forms[0].submit();		
			}else{
				document.getElementById("from").value = from;
				document.getElementById("to").value = to;
				document.forms[0].target="";
				if(document.getElementById("call_from").value == 'MAIN'){
					document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_from="+document.getElementById("call_from").value+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;
					document.forms[0].submit();
				}
        document.forms[0].action="../../eMR/jsp/MedRecRequestResult.jsp?PatientId="+PatientId+"&call_from="+document.getElementById("call_from").value+"&from="+from+"&to="+to+"&orderBy="+orderBy_ind+"&lstPatientClass="+lstPatientClass;
				document.forms[0].submit();
	}
}
 
function chkServices(Obj){
	
	//parent.frames[3].document.forms[0].search.disabled = false;
	//modified for SCR 4551
	parent.frames[4].document.forms[0].search.disabled = false;
	if(Obj.checked)
	{
		document.forms[0].selectAll_yn.value = "";
		document.forms[0].temp1.value=document.forms[0].temp1.value+Obj.value+"$"+Obj.name+"$E~"
		document.forms[0].finalSelect.value=document.forms[0].temp1.value;
	}
	else
	{		
		document.forms[0].selectAll_yn.value = "";
		document.forms[0].temp1.value=document.forms[0].temp1.value+Obj.value+"$"+Obj.name+"$D~"
		document.forms[0].finalSelect.value=document.forms[0].temp1.value;
	}
//	alert(document.forms[0].temp1.value);
//	alert(document.forms[0].finalSelect.value);
//	alert("in chkServices selectAll_yn : "+document.forms[0].selectAll_yn.value);
}


async function closeWin(enc,patid,changefunc,Patient_Class,call_function)
{
	//window.parent.returnValue=val
	//window.parent.close()
	await showModalCurEnc1(enc,patid,changefunc,Patient_Class,call_function);
}

async function showModalCurEnc1(enc,patid,changefunc,Patient_Class,call_function,bl_install_yn)
{
	
	//var bl_install_yn=document.forms[0].bl_install.value;
	//var call_function = document.forms[0].call_function.value;
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "50vh";
	var dialogWidth = "70vw";
	var dialogTop	= "0vh";
	var center = "1" ;
	var status="no";
var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + ";";
	var arguments	= "" ;
	retVal = await top.window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
	if(retVal!=null && retVal!='')

	parent.content.document.location.reload();
}

async function closeWindowval(enc,patid,changefunc,Patient_Class){
	var bl_install_yn=document.forms[0].bl_install;
	var call_function = document.forms[0].call_function;
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "400px";
	var dialogWidth = "700px";
	var dialogTop	= "10";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+enc+"&bl_instal="+bl_install_yn+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
}

//MedRecRequestButtons fucnions parent.content  parent.content.document.forms[0].PatientId.value
async function showModalCurEnc()
{	

	if(parent.content.document.forms[0])
	{
		var sst="";
		var mm=0;
		var conArray=new Array();//alert(parent.content.document.forms[0].elements.length);
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
		//document.frmButton.PatientId.value=parent.content.document.forms[0].PatientId.value;
		var pid	= document.forms[0].PatientId.value;
		//alert(pid)
		//document.frmButton.from.value=parent.content.document.forms[0].from.value;
		var from=document.frmButton.from.value;

		//document.frmButton.to.value=parent.content.document.forms[0].to.value;
		var to=document.frmButton.to.value;
		
		document.frmButton.finalSelect.value=parent.content.document.forms[0].finalSelect.value;
		
		//if(parent.content.document.forms[0].chkAll.checked)
		//alert(parent.content.document.getElementById("chkAll").checked );
		if(parent.content.document.getElementById("chkAll").checked ==true)
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
		{
			//alert('condition'+condition);
			//alert('elements'+parent.content.document.forms[0].elements[i].name);
			if(parent.content.document.forms[0].elements[i].name != 'finalSelect')
			{
				condition += parent.content.document.forms[0].elements[i].name +"="+escape(parent.content.document.forms[0].elements[i].value)+"&"
			}
		}
		
		var call_function = "";
		var jsp_name="MedRecRequestRecordMain.jsp";
//		var jsp_name="MedRecRequestRecordMainNew.jsp";
		var retVal = 	new String();
		var dialogHeight= "90vh";
		var dialogWidth = "90vw";
		var dialogTop	= "";
		var center = "" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		
		//var bl_install_yn= parent.content.document.forms[0].bl_install;
		//var bl_install_yn= document.forms[0].bl_install.value;
		//retVal = window.showModalDialog("../../eMR/jsp/"+jsp_name+"?condition="+condition+"&selitem="+lp+"&PatientId="+pid+"&from="+from+"&to="+to+"&modal_yn=Y&finalSelect="+finalSelect+"&bl_install_yn="+bl_install_yn,arguments,features);
			//alert('js'+finalSelect);
			//alert("../../eMR/jsp/"+jsp_name+"?condition="+condition+"&selitem="+lp+"&PatientId="+pid+"&from="+from+"&to="+to+"&modal_yn=Y&finalSelect="+finalSelect+"&bl_install_yn=");

		retVal =await top.window.showModalDialog("../../eMR/jsp/"+jsp_name+"?condition="+condition+"&selitem="+lp+"&PatientId="+pid+"&from="+from+"&to="+to+"&modal_yn=Y&finalSelect="+finalSelect+"&bl_install_yn=",arguments,features);

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


async function showPrevDelReports()
{
	if(parent.content.document.forms[0])
	{
		document.frmButton.PatientId.value=parent.content.document.forms[0].PatientId.value;
		var call_function	= "";
		var request_type	= "MR";
		var retVal			= new String();
		var dialogHeight	= "30vh";
		var dialogWidth		= "65vw";
		var dialogTop		= "72";
		var status			= "no";
		var center			= "";
		var arguments		= "";
		var features		= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		retVal =await window.showModalDialog("../../eMR/jsp/ReportRequestQueryResult.jsp?title=PREV_DEL_REPORT&status_to_show=6&request_type=MR&PatientId="+document.forms[0].PatientId.value,arguments,features);
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

function selectAll_S(obj)
	{
		parent.frames[3].document.forms[0].search.disabled = false
	len=document.getElementById("check_box").length;
	if (len!=null){
		if (obj.checked){
			for (i=0;i<len;i++){
				document.getElementById("check_box")[i].checked=true;
			}
		}else{
			for (i=0;i<len;i++){
				if(document.getElementById("check_box")[i].disabled==false)
				{
				document.getElementById("check_box")[i].checked=false;
				}
			}
		}
	}else{
		if (obj.checked){
			document.getElementById("check_box").checked=true;
		}else{
			if(document.getElementById("check_box").disabled ==false)	
			{
			document.getElementById("check_box").checked=false;
			}
		}
	}
}

function react_chkbox(obj,ind)
{//alert(parent.frames[2].document.forms[0].check_box)
	if (obj.checked==false)
	{
	document.getElementById("chkAll").checked=false;
	}
	var flag=true;
	if (obj.checked==false)
	{
	
		
	}
	else
	{
		parent.frames[2].document.forms[0]["chk" + ind].checked == true;
		
		parent.frames[3].document.forms[0].search.disabled = false;
	}
	
}




function enableSelect(obj,i)
{
	//alert(obj.checked);
	if(obj.checked) {
	var stage = parent.frames[1].document.forms[0].stage_no.value;
	var temp_val=obj.value;
		if(temp_val!=''){
			temp_arr=temp_val.split("`");
				
			for( i=0;i<temp_arr.length;i++){
				var in_arr=temp_arr[i].split(",");
				var trm_cd=in_arr[2];
								
				//alert('in_arr'+in_arr);

				if(in_arr=="pending1" && (stage == "2" || stage == "3")){
					//alert("This encounter is pending for Level 1 user.");
					var lvl_check=window.confirm(getMessage("ENC_PEN_L1","MR"));
					
				}else if(in_arr=="pending2" && stage == "3"){
					var lvl_check=window.confirm(getMessage("ENC_PEN_L2","MR"));

				}/*else if(in_arr=="pc_l1" && (stage == "2" || stage == "3")){
					alert("This encounter is partially completed for Level 1 user.");
				}else if(in_arr=="pc_l2" && (stage == "2" || stage == "3")){
					alert("This encounter is partially completed for Level 1 user.");
				}else if(in_arr=="auth_l1" && (stage == "2" || stage == "3")){
					alert("This encounter is authorized for Level 1 user.");
				}else if(in_arr=="auth_l2" && (stage == "2" || stage == "3")){
					alert("This encounter is authorized for Level 1 user.");
				}*/
				if(lvl_check == false)
				{
					obj.checked=false;
				}
				
			}
		}
		
	}
	var k=document.getElementById("sel_cnt").value;
	
	if (obj.checked == true )
	{
		k++;
		document.getElementById("select_but").disabled = false;
			

		//if (i!=1)
			//document.getElementById("temp2").value=document.getElementById("temp2").value+eval("document.getElementById("encid")"+i).value+"$"+eval("document.getElementById("encid")"+i).name+"$"+"~"
		//else
			//document.getElementById("temp2").value=eval("document.getElementById("encid")"+i).value+"$"+eval("document.getElementById("encid")"+i).name+"$"+"~"



		document.getElementById("finalSelect1").value=document.getElementById("temp2").value;
		
		if(i >= 1)
		{
			
		}
	
			
	}
	else
	{
		k--;
		
	}
	document.getElementById("sel_cnt").value = k;
	
}

async function recodeModal(fetchrecord)
{
    var enctemp = "";
	var cnt = document.getElementById("enc_cnt").value;
	var k=0;
	var from =document.getElementById("from").value;
	var to =document.getElementById("to").value;
	
	
	for(var j=1;j<=fetchrecord;j++)
	{
		
		if(eval(document.getElementById("select_chk"+j)))
		{
			if(eval(document.getElementById("select_chk"+j)).checked)
			{
				
				if(k == 0)
				{
					document.getElementById("enc_temp").value="'"+eval(document.getElementById("encid"+j)).value+"'$E"
					document.getElementById("pat_temp").value="'"+eval(document.getElementById("Pid"+j)).value+"'$E"
					document.getElementById("temp2").value=eval(document.getElementById("encid"+j)).value+"$"+eval(document.getElementById("encid"+j)).name+"$"+"~"

				}
				else
				{
				//alert(eval("document.getElementById("select_chk")"+j).value);	
					document.getElementById("enc_temp").value=document.getElementById("enc_temp").value+",'"+eval(document.getElementById("encid"+j)).value+"'$E"
					document.getElementById("pat_temp").value=document.getElementById("pat_temp").value+",'"+eval(document.getElementById("Pid"+j)).value+"'$E"
					document.getElementById("temp2").value=document.getElementById("temp2").value+eval(document.getElementById("encid"+j)).value+"$"+eval(document.getElementById("encid"+j)).name+"$"+"~"

				}

				k++;
			}
							
		}
	}


	
	

	var dialogHeight="41vh";
	var dialogWidth="64vw";
	var dialogTop="72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var enc_val= document.getElementById("temp2").value;
	var enc_temp= document.getElementById("enc_temp").value;
	var pat_temp= document.getElementById("pat_temp").value;
	var finalSelect1= document.getElementById("finalSelect1").value;
	


	retVal= await window.showModalDialog("../../eMR/jsp/DPRecodingFrames.jsp?fetchrecord="+fetchrecord+"&pat_temp="+pat_temp+"&enc_temp="+enc_temp+"&enc_val="+enc_val+"&finalSelect1="+finalSelect1,arguments,features);
	//retVal=window.open("../../eMR/jsp/DPRecodingFrames.jsp?fetchrecord="+fetchrecord+"&pat_temp="+pat_temp+"&enc_temp="+enc_temp+"&enc_val="+enc_val+"&finalSelect1="+finalSelect1,arguments,features);

	document.getElementById("enc_temp").value="";
	document.getElementById("pat_temp").value="";
		if(retVal==undefined){
			var htmlval = "<html><body onKeyDown='lockKey()'><form name='MRvalidate' id='MRvalidate' method='post' action='../../eMR/jsp/DPRecodingValidation.jsp'><input type='hidden' name='mode' id='mode' value='RemoveSessionVals'></input></form></body></html>";
			parent.frames[3].document.body.insertAdjacentHTML('afterbegin',htmlval);
			parent.frames[3].document.MRvalidate.submit();
			parent.frames[3].location.href = "../../eCommon/jsp/error.jsp";



	}



}

function chkPeriod(obj)
{
	//alert(document.forms[0].ip_grace.value);
	//alert(obj.value);
	if(obj.value == 'IP' || obj.value == 'DC')
	{
		if(document.forms[0].stage_no.value == "3")
		{
			if(obj.value == "IP" && document.forms[0].max_level_for_ip_yn.value == "Y"){
					document.forms[0].dischargedatefrom.value=document.forms[0].ip_grace.value;
			}else if(obj.value == "DC" && document.forms[0].max_level_for_dc_yn.value == "Y"){
					document.forms[0].dischargedatefrom.value=document.forms[0].ip_grace.value;
			}
			else{
				document.forms[0].dischargedatefrom.value=document.forms[0].SystemDate_ip.value;
			}
		}else{
			document.forms[0].dischargedatefrom.value=document.forms[0].SystemDate_ip.value;
		}
		//document.forms[0].encDate_img.style.visibility="hidden";
		document.forms[0].discDate_img.style.visibility="visible";
		//document.forms[0].dischargedatefrom.value=document.forms[0].SystemDate_ip.value;
		document.forms[0].dischargedateto.value=document.forms[0].SystemDischarge_display.value;
		//document.forms[0].altidexpdt1.value="";
		//document.forms[0].altidexpdate2.value="";
		document.forms[0].dischargedatefrom.disabled=true;
		document.forms[0].dischargedateto.disabled=true;
		//document.forms[0].altidexpdt1.disabled=true;
		//document.forms[0].altidexpdate2.disabled=true;
		//document.getElementById("enc1").disabled=true;
		//document.getElementById("enc2").disabled=true;
		document.getElementById("d1").disabled=true;
		document.getElementById("d2").disabled=true;



	}
	else if(obj.value == 'OP' || obj.value == 'EM')
	{
		if(document.forms[0].stage_no.value == "3")
		{
			//alert(document.forms[0].lstPatientClass.value);
			if(document.forms[0].lstPatientClass.value == "OP" && document.forms[0].max_level_for_op_yn.value == "Y"){
				document.forms[0].dischargedatefrom.value=document.forms[0].op_grace.value;
			}else if(document.forms[0].lstPatientClass.value == "EM" && document.forms[0].max_level_for_em_yn.value == "Y"){
				document.forms[0].dischargedatefrom.value=document.forms[0].op_grace.value;
			}else{
				document.forms[0].dischargedatefrom.value=document.forms[0].SystemDate_op.value;
			}

		}
		else
		{
			document.forms[0].dischargedatefrom.value=document.forms[0].SystemDate_op.value;
		}
		document.forms[0].discDate_img.style.visibility="visible";
		document.forms[0].dischargedateto.value=document.forms[0].SystemDischarge_display.value;
		document.forms[0].dischargedatefrom.disabled=true;
		document.forms[0].dischargedateto.disabled=true;
		document.getElementById("d1").disabled=true;
		document.getElementById("d2").disabled=true;


		/*document.forms[0].discDate_img.style.visibility="hidden";
		document.forms[0].encDate_img.style.visibility="visible";
		document.forms[0].altidexpdt1.value=document.forms[0].SystemDate_op.value;
		document.forms[0].altidexpdate2.value=document.forms[0].SystemDate.value;
		document.forms[0].dischargedatefrom.value="";
		document.forms[0].dischargedateto.value="";
		document.forms[0].dischargedatefrom.disabled=true;
		document.forms[0].dischargedateto.disabled=true;
		document.forms[0].altidexpdt1.disabled=true;
		document.forms[0].altidexpdate2.disabled=true;
		document.getElementById("enc1").disabled=true;
		document.getElementById("enc2").disabled=true;
		document.getElementById("d1").disabled=true;
		document.getElementById("d2").disabled=true;*/

	}
	else
	{
		document.forms[0].discDate_img.style.visibility="hidden";
		//document.forms[0].encDate_img.style.visibility="hidden";
		//document.forms[0].altidexpdt1.value="";
		//document.forms[0].altidexpdate2.value="";
		document.forms[0].dischargedatefrom.value="";
		document.forms[0].dischargedateto.value="";
		document.forms[0].dischargedatefrom.disabled=true;
		document.forms[0].dischargedateto.disabled=true;
		//document.forms[0].altidexpdt1.disabled=true;
		//document.forms[0].altidexpdate2.disabled=true;
	}

}
function beforeGetLoc(obj1,obj2,obj3){
	
	if(document.forms[0].locn_code.value != "")
			getLocn(obj1,obj2,obj3);
		else
			document.forms[0].Hloc.value = "";


}

async function getLocn(loginuser,fac_id,target)
{
	
   var retVal =    new String();
   var retVal =    new String();
   var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
   var locale="";				
   var spec_code="";				
   var oper_id="";				
   locale=document.forms[0].locale.value; 
   spec_code=document.forms[0].speciality_code.value;
   oper_id=document.forms[0].oper_stn_id.value;
   var patient_class = document.forms[0].lstPatientClass.value;
   tit=getLabel("Common.Location.label",'Common')

	   //argumentArray[0]="SELECT a.clinic_code, a.short_desc FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id = '"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status = 'E' AND a.facility_id = b.facility_id AND a.clinic_code = b.locn_code AND a.clinic_type = b.locn_type AND b.appl_user_id like upper(?) AND b.oper_stn_id like upper(?) AND b.diag_proc_recode_for_op_yn = 'Y' AND a.clinic_type = b.locn_type ";
		if(patient_class == 'OP')
		{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' and level_of_care_ind ='A' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}
				
				if(document.forms[0].call_function.value == 'DIAG_RECODE')
				{
					sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' and DIAG_PROC_RECODE_FOR_OP_YN='Y') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				}
				else
				{
					sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' ) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				}
	 

				sql=sql+"  ORDER BY  2";
		}
		else if (patient_class == 'EM')
		{	
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' and level_of_care_ind = 'E' and care_locn_type_ind = 'C' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}

				if(document.forms[0].call_function.value == 'DIAG_RECODE')
				{
					sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' and DIAG_PROC_RECODE_FOR_OP_YN='Y') and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				}
				else
				{
					sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' ) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";
				}

	 

				sql=sql+"  ORDER BY  2";
		
		}
		else if(patient_class == 'IP')
		{
			sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='IP' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+oper_id+"' and b.appl_user_id='"+loginuser+"'  and diag_proc_recode_for_ip_yn = 'Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";

			//sql="select nursing_unit_code code, short_desc description from ip_nursing_unit_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' ";

				/*if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}*/

				//sql=sql+" AND (facility_id,LOCN_TYPE,nursing_unit_code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' and diag_proc_recode_for_ip_yn = 'Y') 
				
				
				//sql=sql+" and upper(nursing_unit_code) like upper(nvl(?,nursing_unit_code)) and upper(short_desc) like upper(nvl(?,short_desc))";

	 

				sql=sql+"  ORDER BY  2";
		}
		else if(patient_class == 'DC')
		{

			sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='IP' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+oper_id+"' and b.appl_user_id='"+loginuser+"'  and diag_proc_recode_for_ip_yn = 'Y' and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";

			//sql="select a.nursing_unit_code code,a.short_desc description from ip_nursing_unit_lang_vw a, am_os_user_locn_access_vw b where a.language_id='"+locale+"' and a.facility_id='"+fac_id+"' and a.patient_class='DC' and a.facility_id=b.facility_id and a.EFF_STATUS = 'E' and a.nursing_unit_code=b.locn_code and a.locn_type=b.locn_type and b.locn_type = 'N' and b.oper_stn_id='"+oper_id+"' and b.appl_user_id='"+loginuser+"'  and  upper(a.nursing_unit_code) like upper(?) and upper(a.short_desc) like upper(?)";
			sql=sql+"  ORDER BY  2";

		}
		else
		{
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id ='"+fac_id+"' and  language_id='"+locale+"' and eff_status ='E' ";

				if(!spec_code=="")
				{
				sql=sql+" and speciality_code='"+spec_code+"' ";
				}

				sql=sql+" AND (facility_id,CLINIC_TYPE,CLINIC_CODE) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+fac_id+"' and oper_stn_id ='"+oper_id+"' and appl_user_id = '"+loginuser+"' ) and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc))";

	 

				sql=sql+"  ORDER BY  2";


		}
   
  
				
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4]="1,2";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
		
		retVal = await CommonLookup(tit, argumentArray );
		
		if(retVal != null && retVal != "")
		{
			target.value = retVal[1] ;
			document.forms[0].Hloc.value = retVal[0];
		}
		else
			target.value ="";

}

function chkCount()
{
	//if(document.getElementById("sel_cnt").value == 0)
		//document.forms[0].select1.disabled=true;
}



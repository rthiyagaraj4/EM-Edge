/*
Sr No        Version           Incident        SCF/CRF             Developer Name
---------------------------------------------------------------------------------------
1			 V211130			26231		KDAH-SCF-0744-TF		Mohanapriya K
2            V220413            30399       MMS-ME-SCF-0064-TF      Mohanapriya K
3            V220629            32944       MMS-ICN-00131-TF      Mohanapriya K
4								39432		MMS-QF-SCF-0664		    Manivel N
5	     V230228		            MMS-DM-CRF-0209.5	  Namrata Charate
---------------------------------------------------------------------------------------
*/

function create() {
	PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
}

function reset() {
	PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
}

async function apply() {
	var mainfrmObj = PolicyDefinitionMainFrame.encounterSpecPolicyDefnSrchCreteria.frmEncounterHeader;
	var auth = mainfrmObj.auth.value;
	
	var apprvl = mainfrmObj.apprvl.value;
	
	if(apprvl=='Y')
		{
		alert("Changes/Recalculation not allowed Since Episode is having Approved Bills");
		commontoolbarFrame.location.reload();
		return;
		}
	var episodeType = mainfrmObj.episode_type.value;
	var patLbl  = getLabel("Common.patientId.label","common");
	var epsdTypeLbl  = getLabel("Common.EpisodeType.label","common");
	var epsdIdLbl  = getLabel("Common.episodeid.label","common");
	var polLbl = getLabel("eBL.POLICY.label","bl");
	var noOfDays = "No of Days";//getLabel("Common.noofdays.label","common");
	var amtLimit = getLabel("eBL.LimitAmt.label","bl");

	if(episodeType != 'R'){
		var fieldsTop  = new Array (mainfrmObj.patient_id,mainfrmObj.episode_type,mainfrmObj.hdnEpisode_id,mainfrmObj.policyValidation);
		var namesTop = new Array ( patLbl,epsdTypeLbl,epsdIdLbl,polLbl);
	}
	else{
		var fieldsTop  = new Array (mainfrmObj.patient_id,mainfrmObj.episode_type,mainfrmObj.policyValidation);
		var namesTop = new Array ( patLbl,epsdTypeLbl,polLbl);
	}

	//Commented by Rajesh V - To make No of days & Amt Limt as non Mandatory Field
	/*var chkServFrm = PolicyDefinitionMainFrame.PolicyCoverageMain.ServiceCoverageTabDetails
		//alert(chkServFrm)
	if(chkServFrm != undefined){
			var frmServ = PolicyDefinitionMainFrame.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
			if(frmServ.approvedDays.value == 'R'){
				fieldsTop.push(frmServ.noOfDays);
				namesTop.push(noOfDays)
			}
			
			if(frmServ.approvedAmt.value == 'R'){
				fieldsTop.push(frmServ.limitAmt);
				namesTop.push(amtLimit)
			}
	}*/


	var payer = mainfrmObj.payer.value;
	var payerGroup = mainfrmObj.payerGroup.value;
	var policy = mainfrmObj.policy.value;
	
	if(payer == '' || payerGroup == '' || policy == ''){
		mainfrmObj.policyValidation.value = '';
	}
	else{
		mainfrmObj.policyValidation.value = 'Y';
	}


	
	if(checkFieldsofMst( fieldsTop, namesTop, messageFrame)) {

		var validateFrm = PolicyDefinitionMainFrame.PolicyDetailsPage.frmPolicyInclExclCoverage;
		var facilityId = validateFrm.facility_id.value;
		var patId = validateFrm.patientId.value;
		var episodeType = validateFrm.episodeType.value;
		var episodeId = validateFrm.episodeId.value;
		var visitId = validateFrm.visitId.value;
		
		var reqId = checkJobStatusForEncounter(facilityId,
												patId,
												episodeType,
												episodeId,
												visitId);
		if(reqId > 0){
			var dialogHeight= "17" ;
			var dialogWidth	= "37" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			//var modPatientId = document.getElementById("hiddenPatientId").value;
			retVal =await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?closeDisable=Y&reqId="+reqId,arguments,features); 
			if(retVal != 'Y' && retVal != 'F'){
				alert('Cannot save changes, while financial calculation in progress');
				commontoolbarFrame.location.reload();
				commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
				commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
				return;
			}
			alert('Financial Calaculation is completed for the Previous Request, Please Save Again');
			commontoolbarFrame.location.reload();
			commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
			commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
			return;
		}
		if(auth == 'N'){
			alert(getMessage('BL9136','BL'));		
			commontoolbarFrame.location.reload();
			return;
		}
		
			var xmlString=formXMLStringMain(mainfrmObj);
			var updation=formValidation(xmlString,"infoFrame");
			
			var frmObj = PolicyDefinitionMainFrame.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo;
			var mode = 'modify';
			xmlString=formXMLStringMain(frmObj);
			updation=formValidation(xmlString,"serviceCoverage");
			var startDate=frmObj.startDate.value;
			
			frmObj = PolicyDefinitionMainFrame.PolicyCoverageMain.ServiceCoverageTabDetails.frmServiceTabDetails;
			var prevtab = frmObj.prevTab.value;
			xmlString=formXMLStringMain(frmObj);
			updation=formValidation(xmlString,prevtab);

			frmObj = PolicyDefinitionMainFrame.PolicyDetailsPage.document.forms[0];
			var pageInfo = frmObj.pageInfo.value;
			xmlString=formXMLStringMain(frmObj);
			updation=formValidation(xmlString,pageInfo);

			var temp_jsp="../../eBL/jsp/EncounterSpecDeletePersistence.jsp?func_mode=MergeBeans";
			var xmlStr ="<root><SEARCH ";				
			xmlStr +=" /></root>";
			//var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=validatePolicy&payerGroup="+payerCode.value+"&payer="+payer.value+"&policy="+policy.value;					
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=trimString(xmlHttp.responseText);

			mainfrmObj.target='messageFrame';
			mainfrmObj.method="post";
			mainfrmObj.action="../../servlet/eBL.EncounterSpecificDefinitionServlet?mode="+mode+"&startDate="+startDate;
			mainfrmObj.submit();	

	
	}
}

function checkJobStatusForEncounter(facilityId,
		patId,
		episodeType,
		episodeId,
		visitId){
	var reqId = 0;
	//V220413
	$.ajax({
		type:"POST",
		url:"../jsp/PkgSubscriptionValidation.jsp",
		data:"func_mode=checkForInProgress&facilityId="+facilityId+
			  "&patientId="+patId+
			  "&episdoeType="+episodeType+
			  "&episdoeId="+episodeId+
			  "&visitId="+visitId,
		dataType:"text",
		async:false,
		success: function(data){
			reqId = parseInt($.trim(data));
			
		},
		 error: function(data){
			 reqId = 0;
	      }
	});
	return reqId;
}

async function onSuccess(reqId)
{
	if(reqId>0){
		var cnt = 1;
		var status = 'I';				
		status = checkProgress(reqId);
		if(status == 'C'){
			msg=getMessage("RECORD_INSERTED","SM");
			//commontoolbarFrame.location.reload();					
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
			PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
			//commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
			//commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
		}
		else if(status == 'F'){			
			msg='Recalculation Job Failed';							
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
			PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
			//commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
			//commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
		}
		else{
			var intr = setInterval(function chkProg(){
				cnt++;
				status = checkProgress(reqId);
				if(status == 'C'){
					clearInterval(intr);
					msg=getMessage("RECORD_INSERTED","SM");
					//commontoolbarFrame.location.reload();					
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
					PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
					//commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
					//commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
				}
				else if(status == 'F'){
					clearInterval(intr);
					msg='Recalculation Job Failed';							
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
					PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
					//commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
					//commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
				}
				else if(cnt == 5){
					clearInterval(intr);
					var dialogHeight= "14" ;
					var dialogWidth	= "32" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					//var modPatientId = document.getElementById("hiddenPatientId").value;
					retVal =await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?reqId="+reqId,arguments,features);
					msg=getMessage("RECORD_INSERTED","SM");
					//commontoolbarFrame.location.reload();					
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
					PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
					//commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
					//commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
				}
				
				
				
			}, 3000);
		}					
	}
	else{
		msg=getMessage("RECORD_INSERTED","SM");
		//commontoolbarFrame.location.reload();					
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		PolicyDefinitionMainFrame.location.href = "../../eBL/jsp/EncounterSpecPolicyDefnSrchMain.jsp";
		//commontoolbarFrame.document.CommonToolbar_form.create.disabled = true;
		//commontoolbarFrame.document.CommonToolbar_form.query.disabled = true;
	}
	
	
}

function checkProgress(reqId){
	var progress = 'I';
	//V220413
	$.ajax({
		type:"POST",
		url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
		data:"func_mode=getProgressStatus",
		dataType:"text",
		async:false,
		success: function(data){
			progress = $.trim(data);
			
		},
		 error: function(data){
			 progress = 'I';
	      }
	});
	return progress;
}
function defaultEncounter(obj){
	var patId = document.forms[0].patient_id.value;
	var patClass = document.forms[0].episode_type.value;
	var defPat = document.forms[0].defaultPatient.value;
	var facilityId = document.forms[0].facilityId.value;
	//if(document.forms[0].hdnEpisode_id.value < 1){
	if(obj == 'patId'){
		if(patId.length>0 && patClass.length>0){
			if((patId!=defPat)){
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);
				//alert(responseText)
				if(responseText != 'N' && responseText.length>0){
					var retArr = responseText.split(":::");
					document.forms[0].episode_id.value = retArr[0];
					document.forms[0].hdnEpisode_id.value = retArr[0];
					document.forms[0].Effective_from.value = retArr[1];
				}
				else{
					document.forms[0].episode_id.value = '';
					document.forms[0].hdnEpisode_id.value = '';
					document.forms[0].Effective_from.value = '';
				}
			}
		}
	}
	else if(obj == 'epsdType'){
		if(patId.length>0 && patClass.length>0){
			var xmlStr ="<root><SEARCH ";				
			xmlStr +=" /></root>";
			var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=defaultEncounter&pat_id="+patId+"&epsdType="+patClass+"&facility_id="+facilityId;						
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var responseText=trimString(xmlHttp.responseText);
			//alert(responseText)
			if(responseText != 'N' && responseText.length>0){
				var retArr = responseText.split(":::");
				document.forms[0].episode_id.value = retArr[0];
				document.forms[0].hdnEpisode_id.value = retArr[0];
				document.forms[0].Effective_from.value = retArr[1];
			}
			else{
				document.forms[0].episode_id.value = '';
				document.forms[0].hdnEpisode_id.value = '';
				document.forms[0].Effective_from.value = '';
			}
		}
	}
	document.forms[0].defaultPatient.value = 	patId;
	//}
}

async function episodeLookup(obj,code){
	//alert("4");
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	/*if(patient_id.length<1){
		alert("Enter Patient Id");
		return false;
	}*/
	if(episode_type.length<1){
		alert(getMessage('BL9142','BL'));
		return false;
	}
	
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	if((episode_type == 'I') || (episode_type == 'D')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_episode_fin_dtls where patient_id = '"+patient_id+"' and episode_type= '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		
	}
	else if((episode_type == 'O') || (episode_type == 'R') || (episode_type == 'E')){
		if(patient_id == ''){
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}
		else{
			sql = "Select patient_id code,episode_id description from bl_visit_fin_dtls where patient_id = '"+patient_id+"' and episode_type = '"+episode_type+"' and upper(episode_id) like upper(?) and upper(episode_type) like upper(?) order by 2"
		}		
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	//returnedValues = CommonLookup("Legend", argumentArray );
	var encounter_date = document.forms[0].Effective_from.value;
	var retVal = await callOperation(patient_id,episode_type,obj.value,facility_id,encounter_date);
	//alert('retVal->'+retVal);
	if((retVal != null) && (retVal != "") )  {
		var returnedValues = retVal.split("::");
		//alert(returnedValues.length)
		if(returnedValues.length == 4){
			//obj.value = returnedValues[0];
			obj.value = returnedValues[0];
			code.value = returnedValues[0];	
			frm.patient_id.value = returnedValues[1];
			frm.Effective_from.value = returnedValues[2];
		}
		else if(returnedValues.length == 3){
			obj.value = returnedValues[0];
			code.value = returnedValues[0];	
			frm.Effective_from.value = returnedValues[1];
		}

		//alert('frm.patient_id.value->'+frm.patient_id.value);
		if(frm.enteredPatient.value.length<1 || (frm.enteredPatient.value != returnedValues[0])){
			getPatDetails();
		}		
		//alert('frm.patient_id.value->'+frm.patient_id.value);
		//alert('frm.enteredPatient.value->'+frm.enteredPatient.value)
					//alert('frm.enteredEpisode.value->'+frm.enteredEpisode.value)
		if(frm.enteredPatient.value.length>0 && frm.enteredEpisode.value.length>0){
			if(returnedValues.length == 4){
				if(returnedValues[0].length>0 && returnedValues[1].length>0){
					if((frm.enteredPatient.value != returnedValues[1]) || (frm.enteredEpisode.value != returnedValues[0])){
						parent.encounterSpecPolicyDefnDataDetails.document.location.href = 
								'../../eCommon/html/blank.html';
						parent.PolicyCoverageMain.document.location.href =  '../../eCommon/html/blank.html';
						parent.PolicyDetailsTab.document.location.href =  '../../eCommon/html/blank.html';
						parent.PolicyDetailsPage.document.location.href =  '../../eCommon/html/blank.html';
						parent.PolicyDetailsAdd.document.location.href =  '../../eCommon/html/blank.html';
					}
				}
			}
			else if(returnedValues.length == 3){
				if(returnedValues[0].length>0 && returnedValues[1].length>0){
					if((frm.enteredPatient.value != patient_id) || (frm.enteredEpisode.value != returnedValues[0])){
						parent.encounterSpecPolicyDefnDataDetails.document.location.href = 
								'../../eCommon/html/blank.html';
						parent.PolicyCoverageMain.document.location.href =  '../../eCommon/html/blank.html';
						parent.PolicyDetailsTab.document.location.href =  '../../eCommon/html/blank.html';
						parent.PolicyDetailsPage.document.location.href =  '../../eCommon/html/blank.html';
						parent.PolicyDetailsAdd.document.location.href =  '../../eCommon/html/blank.html';
					}
				}
			}
		}
		if(returnedValues.length == 4){
			//alert('returnedValues.length  is 4 '+returnedValues[1] +'-'+ returnedValues[0])
			frm.enteredPatient.value = returnedValues[1];
			frm.enteredEpisode.value = returnedValues[0];
		}
		else if(returnedValues.length == 3){
			//alert(patient_id +'-'+ returnedValues[0])
			frm.enteredPatient.value = patient_id;
			frm.enteredEpisode.value = returnedValues[0];
		}

	}
	else
	{
		obj.value = '';
		code.value = '';		
	} 
}

function getApprvlValue(patient_id,episode_type,episode_id)
{
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=approval_check&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);	

	
	return responseText;
	
}

function getApprvlValueForEpisode(patient_id,episode_type,episode_id,visit_id)
{
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var param="func_mode=approval_check_for_epi&patient_id="+patient_id+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);	

	
	return responseText;
	
}

function showPatientData(){
	var frm = document.forms[0];
	var patient_id = frm.patient_id.value;
	var episode_type = frm.episode_type.value;
	var episode_id = frm.hdnEpisode_id.value;
	var encounter_date = frm.Effective_from.value;
	if(patient_id.length<1){
		alert(getMessage('BL9141','BL'));
		return false;
	}
	if(episode_type.length<1){
		alert(getMessage('BL9142','BL'));
		return false;
	}

	if(episode_type != 'R' && episode_id.length<1){
		alert(getMessage('BL9143','BL'));
		return false;
	}
	
	if(encounter_date.length<1){
		alert(getMessage('BL9144','BL'));
		return false;
	}
	var auth = document.forms[0].auth.value;
	if(auth == 'N'){
		//document.forms[0].add_mod.disabled=false;
	}
	
	var apprvl = getApprvlValue(patient_id,episode_type,episode_id);
    document.forms[0].apprvl.value=apprvl;
	
	// Changes for MMS-QF-SCF-0664 - Starts
    /*
    if(apprvl=='Y')
    	{    	
    	document.forms[0].recalc_charges.disabled = true;
    	alert("Changes/Recalculation not allowed Since Episode is having Approved Bills");
    	}
		
	*/
	// Changes for MMS-QF-SCF-0664 - Ended
	parent.encounterSpecPolicyDefnDataDetails.document.location.href = 
			'../../eBL/jsp/EncounterSpecPolicyDefnDataDetails.jsp?patinetId='+patient_id+'&episodeType='+episode_type+'&episodeId='+episode_id+'&encounter_date='+encounter_date+'&auth='+auth+'&apprvl='+apprvl;
	parent.PolicyCoverageMain.document.location.href =  '../../eCommon/html/blank.html';
	parent.PolicyDetailsTab.document.location.href =  '../../eCommon/html/blank.html';
	parent.PolicyDetailsPage.document.location.href =  '../../eCommon/html/blank.html';
	parent.PolicyDetailsAdd.document.location.href =  '../../eCommon/html/blank.html';

}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.value="";
	obj.focus();
	//obj.select();
	return false;
}

function clearBill(obj){
	var bgCode = 'bg_code_'+obj;
	var bgDesc = 'bg_desc_'+obj;
	document.getElementById(bgCode).value='';
	document.getElementById(bgDesc).value='';
  var siteSpec = $(document).find('#siteSpec').val();
	var pageInfo=document.getElementById('pageInfo').value;

 if(pageInfo=='inclExclCoverage'){	
	var incExCriteria=$('#incExCriteria_'+obj).val();		
 	var epsdEnc=$('#episode_'+obj).val();
 	var incExcInd = document.getElementById('incExInd_'+obj).value;
 	
 	if((epsdEnc=='N' || epsdEnc=='A') && incExCriteria=='P' && incExcInd == 'I'){
 		//alert("enabled");
 	$('#includeHomeMedication'+obj).prop('disabled',false);
 	}
 	else{
 	//	alert("disabled");
 		$('#includeHomeMedication'+obj).prop('disabled',true);
 	}
	var incl=$('#incExCriteria_'+obj).val();
 }
 	
//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
var Site_PreappDur=document.getElementById('Site_PreappDur').value;
	if(pageInfo=='preApproval' && Site_PreappDur=='Y'){
		var criteria = document.getElementById('type_' + obj).value;
		 var preAppDur = document.getElementById('preAppDur_' + obj);
	
		 if (criteria == 'PG' || criteria == 'M' || criteria == 'T') {
		 
		  var code = document.getElementById('bg_code_' + obj);
		  if(code.value!=''){
		 
		  preAppDur.value = '';
		  preAppDur.disabled = false;
		  }
		  else{
			  
			  preAppDur.value = '';
			  preAppDur.disabled = true;  
		  }
		
	}
		 else{
			
			  preAppDur.value = '';
			  preAppDur.disabled = true;
			 
		 }

}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends	
}

function clearClinic(obj){
	var clinicCode = 'clinic_code_'+obj;
	var clinicDesc = 'clinic_desc_'+obj;
	var clinicNurs = 'clinic_'+obj;
	var clinNursVal = document.getElementById(clinicNurs);
	var clinicBut = 'clinic_but_'+obj;
	var specCode = 'spec_code_'+obj;
	var specDesc = 'spec_desc_'+obj;
	document.getElementById(clinicDesc).disabled = false;
	document.getElementById(clinicCode).readonly = false;
	document.getElementById(clinicCode).value='';
	document.getElementById(clinicDesc).value='';
	document.getElementById(clinicBut).disabled = false;
	document.getElementById(specCode).value='';
	document.getElementById(specDesc).value='';
	if(clinNursVal.value == 'A'){
		document.getElementById(clinicDesc).value = 'All Clinic/ Nursing Unit'; //Modified by Rajesh V
		document.getElementById(clinicCode).value = '**';
		document.getElementById(clinicDesc).disabled = true;
		document.getElementById(clinicCode).readonly = true;
		document.getElementById(clinicBut).disabled = true;
	}
}

function clearBillPop(obj){
	var bgCode = 'pop_bg_code_'+obj;
	var bgDesc = 'pop_bg_desc_'+obj;
	document.getElementById(bgCode).value='';
	document.getElementById(bgDesc).value='';
}

function changeEpsdEnc(obj){
	var epsdEnc = document.getElementById('episode_'+obj).value;
	var patClass = document.getElementById('ptClass_'+obj);
	var clinicInd = document.getElementById('clinic_'+obj);
	var pageInfo=document.getElementById('pageInfo').value;
	if(epsdEnc == 'E'){
		patClass.length = 0;
		var opt = document.createElement("option");
		opt.value = 'OP';
		opt.innerText = 'OP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'EM';
		opt.innerText = 'EM';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'XT';
		opt.innerText = 'EX';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;

		opt = document.createElement("option");
		opt.value = 'C';
		opt.innerText = 'Clinic';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	else if(epsdEnc == 'N'){
		patClass.length = 0;
		var opt = document.createElement("option");
		opt.value = 'IP';
		opt.innerText = 'IP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'DC';
		opt.innerText = 'DC';
		patClass.appendChild(opt);


		opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;

		opt = document.createElement("option");
		opt.value = 'N';
		opt.innerText = 'Nursing Unit';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	else if(epsdEnc == 'A'){
		patClass.length = 0;
		var opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;

		opt = document.createElement("option");
		opt.value = 'A';
		opt.innerText = 'All';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	else{
		patClass.length = 0;

		var opt = document.createElement("option");
		opt.value = '';
		opt.innerText = 'Select';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'OP';
		opt.innerText = 'OP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'IP';
		opt.innerText = 'IP';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'DC';
		opt.innerText = 'DC';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'EM';
		opt.innerText = 'EM';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'XT';
		opt.innerText = 'EX';
		patClass.appendChild(opt);

		opt = document.createElement("option");
		opt.value = '**';
		opt.innerText = 'ALL';
		patClass.appendChild(opt);

		clinicInd.length = 0;
		
		opt = document.createElement("option");
		opt.value = '';
		opt.innerText = 'Select';
		clinicInd.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'C';
		opt.innerText = 'Clinic';
		clinicInd.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'N';
		opt.innerText = 'Nursing Unit';
		clinicInd.appendChild(opt);

		opt = document.createElement("option");
		opt.value = 'A';
		opt.innerText = 'All';
		clinicInd.appendChild(opt);

		clearClinic(obj);
	}
	
	var epsdEnc = document.getElementById('episode_'+obj).value;
	var patClass = document.getElementById('ptClass_'+obj);
	var clinicInd = document.getElementById('clinic_'+obj);
	
   if(pageInfo=='inclExclCoverage'){
 	var rowCount=$('#inclRowCount').val();
 	var incExcInd = document.getElementById('incExInd_'+obj).value;
 	
// 	alert("epsdEnc \ "+epsdEnc+'/'+"  incExcInd :: "+incExcInd);
 	
 	
 	
 	if((epsdEnc=='N' || epsdEnc=='A') && (incExcInd == 'I')){
// 		if((epsdEnc=='N' || epsdEnc=='A')){
 	//	alert("enabled");
 	$('#includeHomeMedication'+rowCount).prop('disabled',false);
 	}
 	else{
 	//	alert("disabled");
 		$('#includeHomeMedication'+rowCount).prop('disabled',true);
 		}
 	}
}

function compareDates(startDate,endDate){
	var starr = startDate.value.split("/");
	var enarr = endDate.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	if(startDate.value.length>0 && endDate.value.length>0){
		if(startdt>enddt){
			alert(getMessage('BL1344','BL'));
			endDate.value = '';
		}
	}
}

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
	
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
	}

	return true;
}

function changeInclExclInd(index){
	var pageInfo=document.getElementById('pageInfo').value;
	
	var inclIndChk = document.getElementById('incExChk_'+index);
	var incBasis = document.getElementById('incBasis_'+index);
	var value = document.getElementById('value_'+index);
	var valueChk1 = document.getElementById('valueChk1_'+index);
	var valueChk3 = document.getElementById('valueChk3_'+index);
	var valueChk4 = document.getElementById('valueChk4_'+index);
	var servItemQty = document.getElementById('servItemQty_'+index);
	var amtPerVisit = document.getElementById('amtPerVisit_'+index);
	var amtPerIPDay = document.getElementById('amtPerIPDay_'+index);	
	var noOfDays = document.getElementById('noOfDays_'+index);
	var serviceLmt = document.getElementById('serviceLmt_'+index);
	var amtMode = document.getElementById('AmtMode_'+index);
	var patCopay =  document.getElementById('patCopay_'+index);
	var patLimitAmt =  document.getElementById('patLimitAmt_'+index);

	var inclExcl = document.getElementById('incExInd_'+index);
	
	var siteSpec = $(document).find('#siteSpec').val();		
 	var epsdEnc=$(document).find('#episode_'+index).val();
 	var incExCriteria=$(document).find('#incExCriteria_'+index).val();	
 	var serviceCode=$(document).find('#bg_code_'+index).val();
 	var includeHomeMedicationAllYN=''; 
 	
 //	alert("bef epsdEnc \ incExCriteria"+epsdEnc+'/'+incExCriteria+"includeHomeMedicationAllYN :: "+includeHomeMedicationAllYN+"siteSpec "+siteSpec);
 	
 	if(incExCriteria=='P'){
 		incExCriteria='PKG';
	}	

	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?service_code="+serviceCode+"&type="+incExCriteria,
		async:false,
		dataType:"json",
		success : function(data){
		//	alert("data"+data);
			includeHomeMedicationAllYN=data.includeHomeMedicationAllYN;
		//	alert("includeHomeMedicationAllYN "+includeHomeMedicationAllYN);
		},

	 error: function(data){
		 alert("error:: "+data);
     }
	});

 //	alert("aft epsdEnc \ incExCriteria"+epsdEnc+'/'+incExCriteria+"includeHomeMedicationAllYN :: "+includeHomeMedicationAllYN);

	
	if(inclExcl.value == 'E'){
		inclIndChk.checked = false;
		inclIndChk.disabled = 'disabled';
		
		incBasis.value = '';
		incBasis.disabled = 'disabled';
		
		value.value = '';
		value.disabled = 'disabled';
		
		valueChk1.checked = false;
		valueChk1.disabled = 'disabled';
		
		valueChk3.checked = false;
		valueChk3.disabled = 'disabled';
		
		valueChk4.checked = false;
		valueChk4.disabled = 'disabled';
		
		servItemQty.value = '';
		servItemQty.disabled = 'disabled';
		
		amtPerVisit.value = '';
		amtPerVisit.disabled = 'disabled';
		
		amtPerIPDay.value = '';
		amtPerIPDay.disabled = 'disabled';
		
		noOfDays.value = '';
		noOfDays.disabled = 'disabled';

		patCopay.value='';
		patCopay.disabled = 'disabled';

		patLimitAmt.value='';
		patLimitAmt.disabled = 'disabled';
		
		amtMode.value = 'G';
		amtMode.disabled = 'disabled';
		//serviceLmt.checked = false;
		//serviceLmt.disabled = 'disabled';
		
		if(siteSpec=='true'){
		 if(pageInfo=='inclExclCoverage'){
	 		$('#includeHomeMedication'+index).prop('disabled',true);
	 		$('#includeHomeMedication'+index).prop('checked', false); 
		 }
	 	}
		
		
	}
	else{

		inclIndChk.disabled = false;

		incBasis.disabled = false;

		value.disabled = false;

		valueChk1.disabled = false;

		valueChk3.disabled = false;

		valueChk4.disabled = false;

		servItemQty.disabled = false;

		amtPerVisit.disabled = false;

		amtPerIPDay.disabled = false;

		noOfDays.disabled = false;

		patCopay.disabled = false;

		patLimitAmt.disabled = false;

		amtMode.disabled = false;
		//serviceLmt.disabled = false;
		if(siteSpec=='true'){
		 if(pageInfo=='inclExclCoverage'){
			if (((epsdEnc=='N' || epsdEnc=='A') && incExCriteria=='PKG') && (includeHomeMedicationAllYN=='Y')) {
				$('#includeHomeMedication'+index).prop('disabled',false);
			}
			else{
				$('#includeHomeMedication'+index).prop('disabled',true);
			}
			}
			
	 	}
	}
	
}

function changeInclExclIndPop(index){
	
	var incBasis = document.getElementById('pop_incBasis_'+index);
	var value = document.getElementById('pop_value_'+index);
	var servItemQty = document.getElementById('pop_servItemQty_'+index);
	var amtPerVisit = document.getElementById('pop_amtPerVisit_'+index);
	var amtPerIPDay = document.getElementById('pop_amtPerIPDay_'+index);	
	var noOfDays = document.getElementById('pop_noOfDays_'+index);
	var amtMode = document.getElementById('AmtMode_'+index);
	var patCopay =  document.getElementById('pop_patCopay_'+index);
	var patLimitAmt =  document.getElementById('pop_patLimitAmt_'+index);

	var inclExcl = document.getElementById('pop_incExInd_'+index);
	if(inclExcl.value == 'E'){
		
		incBasis.value = '';
		incBasis.disabled = 'disabled';
		
		value.value = '';
		value.disabled = 'disabled';
		
		servItemQty.value = '';
		servItemQty.disabled = 'disabled';
		
		amtPerVisit.value = '';
		amtPerVisit.disabled = 'disabled';
		
		amtPerIPDay.value = '';
		amtPerIPDay.disabled = 'disabled';
		
		noOfDays.value = '';
		noOfDays.disabled = 'disabled';

		patCopay.value='';
		patCopay.disabled = 'disabled';

		patLimitAmt.value='';
		patLimitAmt.disabled = 'disabled';

		amtMode.value = 'G';
		amtMode.disabled = 'disabled';
	}
	else{

		incBasis.disabled = false;

		value.disabled = false;

		servItemQty.disabled = false;

		amtPerVisit.disabled = false;

		amtPerIPDay.disabled = false;

		noOfDays.disabled = false;

		patCopay.disabled = false;

		patLimitAmt.disabled = false;

		amtMode.disabled = false;
	}
	
}

async function authUser()
{	
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	//var modPatientId = document.getElementById("hiddenPatientId").value;
	retVal =await window.showModalDialog("../../eBL/jsp/PrevilageCardAuthorizeMain.jsp?mode=s",arguments,features); 



	
	if(retVal!=undefined)
	{
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")
			{
				//document.forms[0].add_mod.disabled=true;
				/* Karthik added the below Code to store new successful User Credentials */
				var successfulUser=retVal[3];
				addUserToSession(successfulUser) ;
				/*document.forms[0].recalc_charges.disabled=false;
				document.forms[0].auth.value = 'Y';
				var auth = 'Y';*/
				//Modify
				var frm = document.forms[0];
				var patient_id = frm.patient_id.value;
				var episode_type = frm.episode_type.value;
				var episode_id = frm.hdnEpisode_id.value;
				var encounter_date = frm.Effective_from.value;
				if(patient_id.length<1){
					alert(getMessage('BL9141','BL'));
					return false;
				}
				if(episode_type.length<1){
					alert(getMessage('BL9142','BL'));
					return false;
				}

				if(episode_type != 'R' && episode_id.length<1){
					alert(getMessage('BL9143','BL'));
					return false;
				}
				
				if(encounter_date.length<1){
					alert(getMessage('BL9144','BL'));
					return false;
				}
				frm.recalc_charges.disabled=true;
				frm.add_mod.disabled=true;
				var DataDetDoc = parent.encounterSpecPolicyDefnDataDetails.document;
				var rowClicked = DataDetDoc.forms[0].rowClicked.value;
				parent.encounterSpecPolicyDefnDataDetails.document.location.href = 
						'../../eBL/jsp/EncounterSpecPolicyDefnDataDetails.jsp?patinetId='+patient_id+'&episodeType='+episode_type+'&episodeId='+episode_id+'&encounter_date='+encounter_date+'&reload=Y&rowClicked='+rowClicked;
				parent.PolicyCoverageMain.document.location.href =  '../../eCommon/html/blank.html';
				parent.PolicyDetailsTab.document.location.href =  '../../eCommon/html/blank.html';
				parent.PolicyDetailsPage.document.location.href =  '../../eCommon/html/blank.html';
				parent.PolicyDetailsAdd.document.location.href =  '../../eCommon/html/blank.html';
			}
		}
	}
}

function fnReloadPrevSelected(rowClicked){
	if(document.getElementById('tr_'+rowClicked) != undefined || document.getElementById('tr_'+rowClicked) != 'undefined'){
		document.getElementById('tr_'+rowClicked).click();
	}
}

function checkAlpha(event){
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkForPer(obj){
	if(obj.value>100){
		alert(getMessage('BL9135','BL'));
		obj.value = '';
	}
	
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function checkForNumber(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        return true;
    }
    else {
        if ( obj.value.length > 0 ) {

            alert(getMessage("NUM_ALLOWED", "SM"));
            obj.value = '';
            return false;
        }
    }
}

function checkForSpecChars(event) {
	var strCheck = '1234567890.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false;  
	return true ;
}

function checkForNumberDecimal(obj) {
	var decArr = obj.value.split('.');
	if(decArr.length>2){
		alert(getMessage("NUM_ALLOWED", "SM"));
		obj.value = '';
		return false;
	}
   
	if(decArr.length == 2){
		if(decArr[0].length<1 && decArr[1].length<1){
			alert(getMessage("NUM_ALLOWED", "SM"));
			obj.value = '';
			return false;

		}
		if(decArr[1].length>2){
			alert('Only Two Numbers are allowed beyond Decimal');
			obj.value = '';
			return false;

		}
	}
}

function formXMLStringMain(frmObj)
{
	//alert('formXMLStringMain->'+frmObj);
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		//alert(arrObj.length);
		for(var i=0;i<arrObj.length;i++)
		{
			//alert(arrObj[i].name+'->'+arrObj[i].value);
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"Y" + "\" " ;
				}
				else{
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + "N" + "\" " ;
				}
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	xmlStr +=" /></root>";	
	}
//alert("xmlStr :"+xmlStr);
	return xmlStr;
}

function formValidation(xmlStr,last_link,event)
{	
//	last_link = 'BILL_PRINT_FMT';
//	alert('last_link->'+last_link);
//	alert('event->'+event);
//	alert('xmlStr->'+xmlStr);
	var temp_jsp="EncounterSpecPersistence.jsp?func_mode="+last_link;
	if(event!=null && event == "delete")
		temp_jsp="EncounterSpecPersistence.jsp?func_mode="+last_link+"&event="+event;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert('before');
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	//alert('after');
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true;
}

function fnEnableDisableLimit(type,obj1,obj2){
	if(type =='chk'){
		var chkBox = document.getElementById(obj1);
		var dest = document.getElementById(obj2);

		var destBox1 = document.getElementById('approvedDays');
		var destBox2 = document.getElementById('approvedAmt');
		var noOfDays = document.forms[0].noOfDays;
		var limitAmt = document.forms[0].limitAmt;

		if(chkBox.checked){
			dest.disabled = false;
		}
		else{
			dest.disabled = true;
			dest.value = '';

			destBox1.disabled = true;
			destBox2.disabled = true;
			destBox1.value = '';
			destBox2.value = '';

			noOfDays.disabled = true;
			limitAmt.disabled = true;
			noOfDays.value = '';
			limitAmt.value = '';
		}
	}
	else if(type ='sel'){
		var selBox = document.getElementById(obj1);
		var dest = document.getElementById(obj2);
		
		if(selBox.value == 'R'){
			dest.disabled = false;
		}
		else{
			dest.disabled = true;
			dest.value = '';
		}
		
		if(document.getElementById('approvedDays').value == 'U' && document.getElementById('approvedAmt').value == 'U'){
			alert(getMessage('BL9137','BL'));
			selBox.value='';
		}
	}
}

/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Starts */

function doUserAuthenticationValidationMain(payer,payerGroup,policy,episodeType) {
	var frmObj=document.forms[0];
	var temp_jsp="../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=ENC_SPEC_PLCY&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&episodeType="+episodeType;
	var xmlString=formXMLStringMain(frmObj);
	var updation=formPayerValidation(xmlString,temp_jsp);	
	return updation;
}

function addUserToSession(successfulUser) {
	var frmObj=document.forms[0];
	var temp_jsp="../../eBL/jsp/UserAuthenticationPayerPolicyValidation.jsp?calledFromPage=SAVE_SUCCESSFULLY_LOGGED_IN_USER&successfulUser="+successfulUser;
	var xmlString=formXMLStringMain(frmObj);
	var updation=formPayerValidation(xmlString,temp_jsp);	
	return updation;
}

function formPayerValidation(xmlStr, temp_jsp) {
    var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); // Parse XML string using DOMParser
    
    var xmlHttp = new XMLHttpRequest();
    
    xmlHttp.open("POST", temp_jsp, false); // Synchronous request, but consider switching to asynchronous
    xmlHttp.setRequestHeader("Content-Type", "text/xml"); // Make sure content-type is set for XML requests
    xmlHttp.send(xmlDoc); // Send the XML document
    
    var responseText = xmlHttp.responseText;

    // Check if responseText contains the success string
    if (responseText.indexOf('@@@SUCCESS@@@') === -1) {
        return false; // Failure case
    } else {
        return true;  // Success case
    }
}


/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy - Ends */
//V230228
function loadPolicyDetails(tr1,payer,payerGroup,policy,patientId,startDate,endDate,visitId,acctSeq,priority,policyNo,episodeType,episodeId,rowNo,auth,apprvl,encounterId)
{
	//document.getElementById('tr_1').bgColor  = 'yellow';
	//document.getElementById(tr1).bgColor='yellow'
	
		//alert('policyNo-'+policyNo)
	var frm = parent.encounterSpecPolicyDefnSrchCreteria.document.forms[0];
	
	/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Starts */
	//if(	auth=="N"){
		
	//}
	/* Karthik added the below Function to Authenticated User to check User Credentials to modify Policy  - Ends */
	

	// Changes for MMS-QF-SCF-0664 - Starts
	var apprvl_lcl = getApprvlValueForEpisode(patientId,episodeType,episodeId,visitId);
	//alert("apprvl_lcl:"+apprvl_lcl);
    frm.apprvl.value = apprvl_lcl;
    
    if(apprvl_lcl=='Y')
    {    	
    	frm.recalc_charges.disabled = true;
    	alert("Changes/Recalculation not allowed Since Episode is having Approved Bills");
    }
	
	apprvl = apprvl_lcl;
	// Changes for MMS-QF-SCF-0664 - Ends
	
	var prevClicked = document.forms[0].prevClicked.value;
	var rowClicked = document.forms[0].rowClicked.value;
	var haveAccess = document.forms[0].haveAccess.value;
	
	if(prevClicked == 'Y'){
		if(rowClicked != rowNo){
			var conf;
			if(haveAccess == 'Y' && apprvl == 'N'){
				conf = confirm("If Unsaved, Please Apply before proceeding to the policy. Want to Proceed without Apply?");
			}
			else{
				conf = true;
			}
			//var conf = confirm("If Unsaved, Please Apply before proceeding to the policy. Want to Proceed without Apply?");
			if(conf == true){
				if(apprvl == 'N')
				{
				if(doUserAuthenticationValidationMain(payer,payerGroup,policy,episodeType)==true){
					auth="Y";
					frm.auth.value = 'Y';
					frm.recalc_charges.disabled=false;
					frm.add_mod.disabled=true;
					document.forms[0].haveAccess.value = 'Y';
				}
				else{
					//Newly Added
					/*var dialogHeight= "14" ;
					var dialogWidth	= "22" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					retVal = window.showModalDialog("../../eBL/jsp/PrevilageCardAuthorizeMain.jsp?mode=s",arguments,features); 

					if(retVal!=undefined && retVal.length>0 && retVal[0]=="Y")
					{
						frm.add_mod.disabled=true;

						var successfulUser=retVal[3];
						addUserToSession(successfulUser) ;
						if(doUserAuthenticationValidationMain(payer,payerGroup,policy,episodeType)==true){
							frm.recalc_charges.disabled=false;
							frm.auth.value = 'Y';
							auth = 'Y';
						}
						else{
							auth="N";
							alert("Logged User dont have permission to Modify this Policy");
						}
					}	*/		
					auth="N";
					frm.auth.value = 'N';
					alert("User dont have permission to Modify this Policy");
					frm.recalc_charges.disabled=true;
					frm.add_mod.disabled=false;
					document.forms[0].haveAccess.value = 'N';
				}
		
				}
					else
						{
						auth="N";
						frm.auth.value = 'N';
						//alert("User dont have permission to Modify this Policy");
						frm.recalc_charges.disabled=true;
						frm.add_mod.disabled=true;
						document.forms[0].haveAccess.value = 'N';				
						}
				document.forms[0].rowClicked.value = rowNo;

				document.getElementById('td_'+rowClicked+'_1').className =  "fields";
				document.getElementById('td_'+rowClicked+'_2').className =  "fields";
				document.getElementById('td_'+rowClicked+'_3').className =  "fields";
				document.getElementById('td_'+rowClicked+'_4').className =  "fields";
				document.getElementById('td_'+rowClicked+'_5').className =  "fields";
				document.getElementById('td_'+rowClicked+'_6').className =  "fields";
				document.getElementById('td_'+rowClicked+'_7').className =  "fields";
				document.getElementById('td_'+rowClicked+'_8').className =  "fields";
				document.getElementById('td_'+rowClicked+'_9').className =  "fields";
				document.getElementById('td_'+rowClicked+'_10').className =  "fields";
				document.getElementById('td_'+rowClicked+'_11').className =  "fields";
				document.getElementById('td_'+rowClicked+'_12').className =  "fields";
				document.getElementById('td_'+rowClicked+'_13').className =  "fields";
				document.getElementById('td_'+rowClicked+'_14').className =  "fields";

				document.getElementById('td_'+rowNo+'_1').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_2').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_3').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_4').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_5').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_6').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_7').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_8').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_9').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_10').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_11').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_12').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_13').className =  "YELLOW";
				document.getElementById('td_'+rowNo+'_14').className =  "YELLOW";
				
				frm.payerGroup.value = payerGroup;
				frm.payer.value = payer;
				frm.policy.value = policy;
				
				frm.visitId.value = visitId;
				frm.acctSeq.value = acctSeq;
				frm.priority.value = priority;
				frm.policyNo.value = policyNo;
				frm.episodeType.value = episodeType;
				frm.episodeId.value = episodeId;
				var xmlStr ="<root><SEARCH ";				
				xmlStr +=" /></root>";
				var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=clearBean";					
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST",temp_jsp,false);
				xmlHttp.send(xmlDoc);
				var responseText=trimString(xmlHttp.responseText);
				if( responseText == 'Y'){
					document.forms[0].prevClicked.value = 'Y';
					//parent.document.getElementById('ContainerFrame').rows="23%,18%,38%,5%,10%,6%";
					parent.document.getElementById("encounterSpecPolicyDefnSrchCreteria").style.height="20vh";
					parent.document.getElementById("encounterSpecPolicyDefnDataDetails").style.height="18vh";
					parent.document.getElementById("PolicyCoverageMain").style.height="38vh";
					parent.document.getElementById("PolicyDetailsTab").style.height="7vh";
					parent.document.getElementById("PolicyDetailsPage").style.height="10vh";
					parent.document.getElementById("PolicyDetailsAdd").style.height="7vh";
					
					//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="36%,10%,54%";
					
					parent.PolicyCoverageMain.document.location.href = '../../eBL/jsp/EncounterPolicyCoverageMain.jsp?mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth+'&encounterId='+encounterId;   //V230228
					parent.PolicyDetailsTab.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsTab.jsp';
					parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsInclExcl.jsp?mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
					parent.PolicyDetailsAdd.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsAdd.jsp?auth='+auth;
				}
			}else{
				
			}
		}
		
	}
	else if(prevClicked == 'N'){
		
		if(apprvl == 'N')
		{
		if(doUserAuthenticationValidationMain(payer,payerGroup,policy,episodeType)==true){
			auth="Y";
			frm.auth.value = 'Y';
			frm.recalc_charges.disabled=false;
			frm.add_mod.disabled=true;
			document.forms[0].haveAccess.value = 'Y';
		}
		else{
			//Newly Added
			/*var dialogHeight= "14" ;
			var dialogWidth	= "22" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			retVal = window.showModalDialog("../../eBL/jsp/PrevilageCardAuthorizeMain.jsp?mode=s",arguments,features); 

			if(retVal!=undefined && retVal.length>0 && retVal[0]=="Y")
			{
				frm.add_mod.disabled=true;

				var successfulUser=retVal[3];
				addUserToSession(successfulUser) ;
				if(doUserAuthenticationValidationMain(payer,payerGroup,policy,episodeType)==true){
					frm.recalc_charges.disabled=false;
					frm.auth.value = 'Y';
					auth = 'Y';
				}
				else{
					auth="N";
					alert("Logged User dont have permission to Modify this Policy");
				}
			}	*/		
			auth="N";
			frm.auth.value = 'N';
			alert("User dont have permission to Modify this Policy");
			frm.recalc_charges.disabled=true;
			frm.add_mod.disabled=false;
			document.forms[0].haveAccess.value = 'N';
		}
		}
		else
			{
			auth="N";
			frm.auth.value = 'N';			
			frm.recalc_charges.disabled=true;
			frm.add_mod.disabled=true;
			document.forms[0].haveAccess.value = 'N';
			}
		frm.payerGroup.value = payerGroup;
		frm.payer.value = payer;
		frm.policy.value = policy;
		
		frm.visitId.value = visitId;
		frm.acctSeq.value = acctSeq;
		frm.priority.value = priority;
		frm.policyNo.value = policyNo;
		frm.episodeType.value = episodeType;
		frm.episodeId.value = episodeId;
		
		var xmlStr ="<root><SEARCH ";				
		xmlStr +=" /></root>";
		var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=clearBean";					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);
		document.forms[0].prevClicked.value = 'Y';
		document.forms[0].rowClicked.value = rowNo;

		document.getElementById('td_'+rowNo+'_1').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_2').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_3').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_4').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_5').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_6').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_7').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_8').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_9').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_10').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_11').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_12').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_13').className =  "YELLOW";
		document.getElementById('td_'+rowNo+'_14').className =  "YELLOW";
		
		if( responseText == 'Y'){
			//parent.document.getElementById('ContainerFrame').rows="23%,18%,38%,5%,10%,6%";
			parent.document.getElementById("encounterSpecPolicyDefnSrchCreteria").style.height="20vh";
			parent.document.getElementById("encounterSpecPolicyDefnDataDetails").style.height="18vh";
			parent.document.getElementById("PolicyCoverageMain").style.height="38vh";
			parent.document.getElementById("PolicyDetailsTab").style.height="7vh";
			parent.document.getElementById("PolicyDetailsPage").style.height="10vh";
			parent.document.getElementById("PolicyDetailsAdd").style.height="7vh";
			//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="36%,10%,54%";
			parent.PolicyCoverageMain.document.location.href = '../../eBL/jsp/EncounterPolicyCoverageMain.jsp?mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
				'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth+'&encounterId='+encounterId;  //V230228
				
			
			parent.PolicyDetailsTab.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsTab.jsp';
			parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsInclExcl.jsp?mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
				'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth;
			parent.PolicyDetailsAdd.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsAdd.jsp?auth='+auth;
	
		}
	}
	
}


function callPatValidation(obj)
{
	var frm = document.forms[0];
	var patient_id=obj.value;	
	if(patient_id!=""){
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	var temp_jsp="../../eBL/jsp/EncounterCommonValidation.jsp?func_mode=CHK_PAT_ID&patient_id="+patient_id;					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);		
	if(responseText=="N")
	{
		alert(getMessage("INVALID_PATIENT","MP"));
		obj.select();
		frm.ageY.value = '';
		frm.ageM.value =  '';
		frm.ageD.value =  '';
		frm.gender.value = '';
		frm.patient_name.value =  '';
	}else if(responseText=="Y"){
		getPatDetails();
	}
	
	}
}

function getPatDetails(){
	var frm = document.forms[0]
	var patId = frm.patient_id.value;
	if(patId.length>0){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=get_Pat_Details&patient_id="+patId;
		//var param="func_mode=get_Card_Details&card_id="+retVal[0];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eBL/jsp/EncounterCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);	
		var detArr = responseText.split(':::');
			frm.ageY.value = detArr[0];
			frm.ageM.value =  detArr[1];
			frm.ageD.value =  detArr[2];
			frm.gender.value = detArr[3];
			frm.patient_name.value =  detArr[4];
			//alert('frm.enteredPatient.value'+frm.enteredPatient.value)
			if(frm.enteredPatient.value.length>0){
				if((frm.enteredPatient.value != patId)){
					parent.encounterSpecPolicyDefnDataDetails.document.location.href = 
						'../../eCommon/html/blank.html';
					parent.PolicyCoverageMain.document.location.href =  '../../eCommon/html/blank.html';
					parent.PolicyDetailsTab.document.location.href =  '../../eCommon/html/blank.html';
					parent.PolicyDetailsPage.document.location.href =  '../../eCommon/html/blank.html';
					parent.PolicyDetailsAdd.document.location.href =  '../../eCommon/html/blank.html';
				}
			}

			frm.enteredPatient.value = patId;
	}
	else{
		frm.ageY.value = '';
		frm.ageM.value =  '';
		frm.ageD.value =  '';
		frm.gender.value = '';
		frm.patient_name.value =  '';
	}
}

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

function fnEnableDisableDays(obj,dest1,dest2)
{
	var selBox = document.getElementById(obj);
	var destBox1 = document.getElementById(dest1);
	var destBox2 = document.getElementById(dest2);
	var noOfDays = document.forms[0].noOfDays;
	var limitAmt = document.forms[0].limitAmt;
	if(selBox.value == 'R'){
		destBox1.disabled = false;
		destBox2.disabled = false;
	}
	else{
		destBox1.disabled = true;
		destBox2.disabled = true;
		destBox1.value = '';
		destBox2.value = '';

		noOfDays.disabled = true;
		limitAmt.disabled = true;
		noOfDays.value = '';
		limitAmt.value = '';
	}
}

async function callCommonValidation(sqlSelect,obj,code){
	//alert("8");
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	//alert(sqlSelect);
	switch(sqlSelect){
			
		case 1:
		{
			sql="select description, code  from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Speciality';
			break;
		}
		case 2:
		{
			var cust_code = document.forms[0].payerCode2.value;
			//sql="Select long_name description,cust_code code from ar_customer_lang_vw Where cust_group_code ='"+cust_code+"' and ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_ID  FROM SM_ACC_ENTITY_PARAM_FACL where facility_id ='"+facility_id+"') and language_id = '"+locale+"' and upper(long_name) like upper(?) and upper(cust_code) like upper(?) order by 2";
			/*sql = 	"Select long_name description,cust_code code from ar_customer_lang_vw "+
					"Where Cust_Code In (Select Cust_Code From Bl_Cust_By_Cust_Group "+
					"Where Cust_Group_Code='"+cust_code+"' ) "+
					"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
					"and nvl(patient_flag,'N')  ='Y' "+
					"and nvl(pat_com_flag,'N')='N' "+
					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
					"and upper(language_id) = upper('"+locale+"') and upper(long_name) like upper(?) and upper(cust_code) like upper(?) "+
					"union "+
					"Select Label_Value  Long_Name,Label_Ref Cust_Code From Sm_Function_Legend_Lang "+
					"Where Function_Id= 'BL' And "+
					"upper(language_id) = upper('"+locale+"') "+
					"and label_type='DV' "+
					"and CANVAS_NAME='PAGE_1' "+
					"And Label_Ref='**'";*/
			sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
					"Where Cust_Code In ( SELECT cust_code "+
                    "FROM bl_cust_by_cust_group "+
                    "WHERE cust_group_code = "+
                             "DECODE ('"+cust_code+"', "+
                                     "'**', cust_group_code, '"+ cust_code+
                                    "')) "+
					"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
					"and nvl(patient_flag,'N')  ='Y' "+
					"and nvl(pat_com_flag,'N')='N' "+
					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
					"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

			title = 'Payer';
			break;
		}
		case 3:
		{
			//sql="select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and ACC_ENTITY_CODE IN (SELECT ACC_ENTITY_ID  FROM SM_ACC_ENTITY_PARAM_FACL where facility_id ='"+facility_id+"') and language_id = '"+locale+"' and upper(long_desc) like upper(?) and upper(cust_group_code) like upper(?) order by 2";
			/*sql="select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
				"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
				"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
				"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
				"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') and upper(long_desc) like upper(?) and upper(cust_group_code) like upper(?) order by 2";*/
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";

			title = 'Payer Group';
			break;
		}
		case 4:
		{
			sql="select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') and upper(long_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
			title = 'Policy';
			break;
		}
		case 5:
		{
			sql="Select Description,Code from (Select Long_Desc Description, Age_Group_Code Code  From Bl_Ins_Age_Group where nvl(Status,'E') != 'D' Union Select 'All Age groups','**' From Dual) where  upper(Description) like upper(?) and upper(Code) like upper(?) ";
			title = 'Age Group';
			break;
		}
			
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[1];
		code.value = arr[0];	
	}
else
	{
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
	} 


}

async function callCommonValidationSpec(obj,code,clinicNurs,clinicCode){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var sqlSelect = '';
	var clinicVal = clinicCode.value;
	if(clinicNurs.value == 'C'){
		if(clinicVal != '**'){
			sqlSelect = 1;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else if(clinicNurs.value == 'N'){
		if(clinicVal != '**'){
			sqlSelect = 2;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else{
		sqlSelect = 3;
	}
	//alert(sqlSelect);
	//alert(clinicNurs.value)
	switch(sqlSelect){
			
		case 1:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select speciality_code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' and clinic_code = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Speciality';
			break;
		}

		case 2:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY WHERE  FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}

		case 3:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"'  Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}
					
	}


	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		code.value = arr[0];	
	}
	else
	{
	obj.value = arr[1];
	code.value = arr[0];		
		//obj.value = returnedValues[1];
	} 


}

async function callBGDesc(sqlSelect,drop,obj,code,obj1){
	var pageInfo=document.getElementById('pageInfo').value;
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	//alert(sqlSelect);
	switch(sqlSelect){
		case 1:
		{
			var cn = drop.value;
			//alert(cn);
			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'N'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}	
			else if(cn == 'A'){
				sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic / Nursing Unit';
			}
			
			else
			{
			alert(getMessage('BL00246','BL'));
			obj.value='';
			code.value='';
			return false;
			}

			
			break;
		}
				
		case 2:
		{
			var criteria = drop.value;
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			
			else
			{
			
			alert('Include/Exclude Criteria Cannot Be Blank');
			obj.value='';
			code.value='';
			return false;
			
			}
		
			
			
			break;
		}
			
	}

	//alert(sql)
	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[1];
		code.value = arr[0];	
	}
else
	{
	obj.value = '';
	code.value = '';		
		//obj.value = returnedValues[1];
	} 

	
	var siteSpec=$(document).find('#siteSpec').val();
	var index = $(document).find('#inclRowCount').val();
	
	if(siteSpec){	
		var type=drop.value;
		if(type=='P'){
			type='PKG';
		}
		var serviceCode=code.value;
		var includeHomeMedicationAllYN='';
	
		$.ajax({
			type:'POST',
			url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?service_code="+serviceCode+"&type="+type,
			async:false,
			dataType:"json",
			success : function(data){
			//	alert("data"+data);
				includeHomeMedicationAllYN=data.includeHomeMedicationAllYN;
			//	alert("includeHomeMedicationAllYN "+includeHomeMedicationAllYN);
			},

		 error: function(data){
			 alert("error:: "+data);
	     }
		});

//		if(includeHomeMedicationAllYN =='N'){	
		 if(pageInfo=='inclExclCoverage'){ 	
			var incExCriteria=$('#incExCriteria_'+index).val();		
			var epsdEnc=$('#episode_'+index).val();
		//	alert("epsdEnc \ incExCriteria"+epsdEnc+'/'+incExCriteria);
		 	var incExcInd = document.getElementById('incExInd_'+index).value;

		 //	alert("epsdEnc \ incExCriteria"+epsdEnc+'/'+incExCriteria+"  incExcInd :: "+incExcInd);
		 	
		  	
			if((epsdEnc=='N' || epsdEnc=='A') && incExCriteria=='P' && includeHomeMedicationAllYN =='Y' && (incExcInd == 'I')){
			//	alert("enabled");

				$('#includeHomeMedication'+index).prop('disabled',false);	
				$('#includeHomeMedication'+index).prop('checked', false); 	

				
			}
			else{
				
				//alert("unchecked & disabled");
				$('#includeHomeMedication'+index).prop('checked', false); // unChecks it				
				$('#includeHomeMedication'+index).prop('disabled',true);
			}
			}
	
//		}
//		else{
//			$('#includeHomeMedication'+index).prop('disabled',false);
//		}
	}

//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	if(pageInfo=='preApproval'){
		var Site_PreappDur=document.getElementById('Site_PreappDur').value;
		if(Site_PreappDur =='Y'){
		var rowCount = document.getElementById('inclRowCount').value;
		var preAppDur = document.getElementById('preAppDur_'+obj1);
		 if(criteria == 'PG' || criteria == 'T' || criteria == 'M'){

			   var policyParam = 'calledFrom=preApproval' +
	           '&type=' +criteria+
	           '&service_code=' + code.value;
				//V220413
		     $.ajax({
		            type: "POST",
		            url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
		            data: policyParam,
		            dataType: "json",
		            async: false,
		            success: function(data) {
	           
						if(data.preappDurCapping=='Y')
						{
	                 
							preAppDur.disabled = false;
						}
						else
							{
							preAppDur.disabled = true;
	               }

	           },
	           error: function(data) {
	               alert(data)
	           }
	       });
	       
	      

	   }
		else
		{
		preAppDur.disabled = true;
	}


	}
	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
}

//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
function zeroCheck(obj){
	
	var rowCount = document.getElementById('inclRowCount').value;
	 var preAppDur = document.getElementById('preAppDur_' + rowCount);
	 var varray;
	  
	 // alert(" zeroCheck "+preAppDur);
	 //  var varray=obj.value.length;
	 varray=obj.value/1;
	
	  if(varray>0){
		  
		
		  return true;
	  }
	  else{
		 
		  preAppDur.value='';
		//  alert("in else");
		  
	  }

}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
//Policy Details Add
function addRowNew(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	//alert('Befor Crash')
	if(pageInfo == 'inclExclCoverage'){
		//alert('InclExcl')
		addRow('InclExcl')
	}
	else if(pageInfo == 'preApproval'){
		//alert('PreApproval')
		addRow('PreApproval')
	}
	else if(pageInfo == 'PreApprovalPopup'){
		addRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}


function removeSelectedRow(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	//alert('Befor Crash')
	if(pageInfo == 'inclExclCoverage'){
		//alert('InclExcl')
		removeRow('InclExcl')
	}
	else if(pageInfo == 'preApproval'){
		//alert('PreApproval')
		removeRow('PreApproval')
	}
	else if(pageInfo == 'PreApprovalPopup'){
		removeRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
//Policy Details Add
//Policy Details Add Close
function addRowNewAddClose(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'PreApprovalPopup'){
		addRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
function saveAddClose(){
	var frmObj = parent.PolicyDetailsPage.document.forms[0];
	xmlString=formXMLStringMain(frmObj);
	//alert(xmlString);
	updation=formValidation(xmlString,"popup");
	window.close();	
}
function removeRowNewAddClose(){
	var frm = parent.PolicyDetailsPage.document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'PreApprovalPopup'){
		removeRow('PreApprovalPopup')
	}
	//alert(pageInfo);
}
//Policy Details Add Close

//Policy Details Incl Excl
function checkDateFrom(obj){
	var stdt = parent.PolicyDetailsPage.document.forms[0].startDate.value;
	var endt = parent.PolicyDetailsPage.document.forms[0].endDate.value;
	var startdtarr = stdt.split("/");
	var enddtarr = endt.split("/");
	var objarr = obj.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		return cal_error ("Please enter date in range between "+stdt+" and "+endt,obj);
	}
	
	/*if( startdt!= null && enddt != null ){
		alert('test')
	if(startdt<enddt){
		alert("Start Date cannot be greater than End date");
	}
	}*/
}
function enableDisableLink(indx){
	var chk = 'serviceLmt_'+indx;
	var obj = 'serviceLink_'+indx;
	var serv = "incExCriteria_"+indx;
	var val = document.getElementById(serv).value;
	var chkBox = document.getElementById(chk);
	var link = document.getElementById(obj);
	var blng_code = 'bg_code_'+indx;
	var blng_code_val = document.getElementById(blng_code).value;
	if(chkBox.checked){
		if(!(val == 'BSG' || val=='BSGC' || val=='ESG' || val=='T' || val=='PG')){
			alert(getMessage("BL9134","BL"));
			link.style.visibility = 'hidden';
			chkBox.checked = false;
		}
		else{
			if(blng_code_val.length>0){
				link.style.visibility = 'visible';
			}
			else{
				alert('Enter Billing Service details');
				link.style.visibility = 'hidden';
				chkBox.checked = false;
			}
		}
		
	}else{
		link.style.visibility = 'hidden';
	}
	
}
async function showService(obj){
	var serv = "incExCriteria_"+obj;
	var val = document.getElementById(serv).value;
	/*if(!(val == 'S' || val=='C' || val=='G' || val=='L')){
		alert('Exclusions not available for selected Criteria');
		return false;
	}*/
	var patClass = document.getElementById("ptClass_"+obj).value;
	var blngCode = document.getElementById("bg_code_"+obj).value;
	var payerGroup = document.getElementById('payerGroup').value;
	var payer = document.getElementById('payer').value;
	var policy = document.getElementById('policy').value;
//	var patientId = document.forms[0].patientId.value;
	var mode = document.getElementById('mode').value;
	var startDate = document.getElementById("effFrom_"+obj).value;
	var endDate = document.getElementById("effTo_"+obj).value;
	
	var visitId = document.getElementById('visitId').value;
	var acctSeq = document.getElementById('acctSeq').value;
	var priority = document.getElementById('priority').value;
	var episodeType = document.getElementById('episodeType').value;
	var episodeId = document.getElementById('episodeId').value;
	
	var encEpsd = document.getElementById("episode_"+obj).value;
	var gender = document.getElementById("gender_"+obj).value;
	var ageGroup = document.getElementById("hdn_age_group_"+obj).value;
	var clinicNursInd = document.getElementById("clinic_"+obj).value;
	var clinicNursCode = document.getElementById("clinic_code_"+obj).value;
	var spltyCode = document.getElementById("spec_code_"+obj).value;
	var compressed = document.getElementById("compressed").value; //V220413
	var patientId="";
	if(compressed=='Y'){
		patientId = document.getElementById("encPatientId").value; //V220413
	}else{
		patientId = document.forms[0].patientId.value;
		compressed='N';
	}
//	var encPatId = document.getElementById("encPatientId").value; //V220413
	//alert(val);
	/*
	var dialogUrl       = "../../eBL/jsp/EncounterSpecPreApprovalPopupFrame.jsp?title=Service Limit&rowNumber="+obj+"&criteria="+val+"&patClass="+patClass+"&blngCode="+blngCode+
						"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+"&patientId="+patientId+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
						"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;
	*/
	var dialogUrl       = "../../eBL/jsp/EncounterSpecPreApprovalPopupFrame.jsp?title=Service Limit&rowNumber="+obj+"&criteria="+val+"&patClass="+patClass+"&blngCode="+blngCode+
						"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+"&patientId="+patientId+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
						"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode+"&compressed="+compressed; //V220413
	//pArgumentArray[9] = title;

	//var dialogArguments = pArgumentArray ;
	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";

	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('effTo_'+obj)
	}
	
}

function showCalendarDiagLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('popDiag_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('popDiag_effTo_'+obj)
	}
	
}

function showToolTip(obj){
	var tab_dat  = "<table id='tooltiptable' cellpadding='3' cellspacing=0 border='0' class='contextMenu' width='100%' "+
					"height='100%' align='center'><tr><td class = 'contextMenuItem' nowrap>"+obj+"</td> </tr></table>";
	document.getElementById('menu_table').innerHTML = tab_dat;
	resizeWindow();
}

function hideToolTip(){
  document.getElementById('tooltiplayer').style.visibility = 'hidden';
}

function resizeWindow(){
//alert();
	bodwidth = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	var x =  event.x;
	var y =  event.y;

	x = x + (document.getElementById('tooltiplayer').offsetWidth)
	y = y + (document.getElementById('tooltiplayer').offsetHeight)

	if(x<bodwidth)
		x = event.x
	else
		x = x - (document.getElementById('tooltiplayer').offsetWidth*2)

	if(y<bodheight || event.y<30){
		y = event.y

	}else if(y>bodheight && event.y<100){
		if(event.y>60 && event.y<100){
			y = event.y-20
	}else if(y>bodheight && event.y<200){
		}else if(event.y>100 && event.y<120){
			y = 80
		}else if(event.y>120 && event.y<140){
			y = 100
		}else if(event.y>140 && event.y<160){
			y = 120
		}else if(event.y>160 && event.y<180){
			y = 140
		}else if(event.y>180 && event.y<200){
			y = 160
		}else if(event.y>180 && event.y<200){
			y = 160
		}else{
			y = event.y
		}
	}else if(y<bodheight || event.y>320){
		y = y - (document.getElementById('tooltiplayer').offsetHeight*2)
	}else{
		y = y - (document.getElementById('tooltiplayer').offsetHeight*2)
	}
	if(y<0)
		y=0;
	y+=document.body.scrollTop
	x+=document.body.scrollLeft

		//alert("x:=="+x)
		//alert("y:=="+y)
		//y=18;

	document.getElementById('tooltiplayer').style.posLeft= x
	document.getElementById('tooltiplayer').style.posTop = y
	document.getElementById('tooltiplayer').style.visibility='visible'
}
//Policy Details Incl Excl

//Search Frames
async function callDialog(param){
	var dialogTop			= "10px";//40
	var dialogHeight		= "92vh" ;//10
	var dialogWidth			= "60vw" ;//40
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}
/*Karthik added this method to call user defined lookup page*/
async function callEpisodeDialog(qryParam){
	var retVal				= new String();
	var dialogTop			= "10px";//40
	var dialogHeight		= "72vh" ;//10
	var dialogWidth			= "50vw" ;//40
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	
	var title = "Select Episode";		

	var column_sizes = escape("10%,10%,10%,10%,25%,10%,25%,0%");
	/* AAKH-SCF-0038 - Added CLINIC_DATE_SORT field as Hidden by Karthik to sort based on clinic date descending */
	var column_descriptions = 'PATIENT ID'+','+'EPISODE TYPE'+','+'EPISODE ID'+','+'VISIT ID'+','+'VISIT DATE AND TIME'+','+'CLINIC/WARD'+','+'CLINIC DESC'+','+'CLINIC_DATE_TRUNC';
	var col_show_hide = "&col_show_hide=YYYYYYYN";
	var episode_type=document.frmEncounterHeader.episode_type.value;
	if(episode_type=='R'){
		var col_show_hide = "&col_show_hide=YYNNYNNN";
	}
	var sql="";			
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+col_show_hide+qryParam;
	
	var  retVal=await top.window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=ENC_SPEC_EPISODE_LOOKUP&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		  retVal=unescape(retVal);
		  var arr=retVal.split("^~^");
		  retVal=arr[2]+"::"+arr[0]+"::"+arr[7]+"::";
		  //Format Conversion as :: is Needed instead of ^~^ 
	 }
	return retVal;
}

async function callOperation(patient_id,episode_type,episode_id,facility_id,encounter_date){	
	var column_sizes = escape("40%,30%,30%");                       	  
	var tit = getLabel('Common.patientId.label','Common') + ',' +
				getLabel('Common.episodeid.label','Common') + ',' 
			+ 'Encounter Date' ;
	//alert('fid->'+facility_id)
	var column_descriptions=encodeURIComponent(tit);

	var sqlTemp = '';
/* Karthik commented as the lookup windows are changed */
/*	if(patient_id.length>1){

		var column_sizes = escape("50%,50%");                       	  
		var tit = getLabel('Common.episodeid.label','Common') + ',' 
					+ 'Encounter Date' ;

		var column_descriptions=encodeURIComponent(tit);

		var sqlTemp = '';
		//sqlTemp  = "Select to_char(Episode_Id) Episode_Id,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time  From Bl_Encounter_Payer_Priority Where operating_facility_id = '"+facility_id+"' and Patient_Id = '"+patient_id+"' and episode_type='"+episode_type+"'   ";
		//sqlTemp = "Select  to_char(Episode_Id1) Episode_Id1, to_char(Enc_Regn_Date_Time1) Enc_Regn_Date_Time1 from (Select distinct(to_char(Episode_Id)) Episode_Id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type  From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"' and Patient_Id = '"+patient_id+"' and episode_type='"+episode_type+"'  ";
		sqlTemp = "Select  Episode_Id1 Episode_Id2, Enc_Regn_Date_Time1 Enc_Regn_Date_Time2 from (Select distinct(to_char(Episode_Id)) Episode_Id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type  From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"' and Patient_Id = '"+patient_id+"' and episode_type='"+episode_type+"'  ";
		var sql=escape(sqlTemp);
		
		var title=getLabel("Common.episodeid.label","common");
		
		title=encodeURIComponent(title);
		
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
		+sql+"&search_criteria="+episode_id;
	}
	else{
		var column_sizes = escape("40%,30%,30%");                       	  
		var tit =	getLabel('Common.episodeid.label','Common') + ',' +
					 getLabel('Common.patientId.label','Common') + ',' 
					+ 'Encounter Date' ;

		var column_descriptions=encodeURIComponent(tit);

		var sqlTemp = '';
		sqlTemp = "Select  Episode_Id1 Episode_Id2, patient_id1 patient_id2, Enc_Regn_Date_Time1 Enc_Regn_Date_Time2 from (Select distinct(to_char(Episode_Id)) Episode_Id1,patient_id patient_id1,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time1,operating_facility_id,patient_id,episode_type  From Bl_Encounter_Payer_Priority ) Where operating_facility_id = '"+facility_id+"'  and episode_type='"+episode_type+"'  ";
		//sqlTemp  = "Select to_char(Episode_Id) Episode_Id,patient_id patient_id,to_char(Enc_Regn_Date_Time,'dd/mm/yyyy') Enc_Regn_Date_Time   From Bl_Encounter_Payer_Priority Where operating_facility_id = '"+facility_id+"' and  episode_type='"+episode_type+"'   ";
		var sql=escape(sqlTemp);
		
		var title=getLabel("Common.episodeid.label","common");
		
		title=encodeURIComponent(title);
		
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="
		+sql+"&search_criteria="+episode_id;
	}
*/
	var qryParam='&patient_id='+patient_id+'&episode_type='+episode_type+'&episode_id='+episode_id+'&facility_id='+facility_id+'&encounter_date='+encounter_date;
	retVal=await callEpisodeDialog(qryParam);
	return retVal;
}
//Search Frames

//Search tro Code

async function callBGDescCode(sqlSelect,drop,obj,code,index){
	var pageInfo=document.getElementById('pageInfo').value;
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
//	alert("sqlSelect ::: "+drop.value+"/"+obj.value+"/"+code.value);
	switch(sqlSelect){
		case 1:
		{
			var cn = drop.value;
			//alert(cn);
			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'N'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}
			else if(cn == 'A'){
				sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' description,'**' code From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic / Nursing Unit';
			}
			
			else
				{
				alert(getMessage('BL00246','BL'));
				obj.value='';
				code.value='';
				return false;
				}

			break;
		}
				
		case 2:
		{
			var criteria = drop.value;
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			
			else
				{
				
				alert('Include/Exclude Criteria Cannot Be Blank');
				obj.value='';
				code.value='';
				return false;
				
				}
			
			
			break;
		}
			
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = DESC_CODE;

	/*if(!(sqlSelect == '1' && drop.value == 'A')){
		returnedValues = CommonLookup(title, argumentArray );
	}
	else{
		returnedValues = new Array();
		returnedValues[0] = '**'
		returnedValues[1] = 'All Clinic/ Nursing Unit';
	}*/
	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[1];
		code.value = arr[0];	
	}
	else
	{
		if(sqlSelect == '1' && drop.value == 'A'){
			obj.value = 'All Clinic/ Nursing Unit';
			code.value = '**';	
		}
		else{
			obj.value = '';
			code.value = '';	
		}
			
	} 

	
	var siteSpec=$(document).find('#siteSpec').val();
	var index = document.getElementById('inclRowCount').value;//V220413
	//var index = $(document).find('#inclRowCount').val();
	if(siteSpec){
		
	var type=drop.value;
	if(type=='P'){
		type='PKG';
	}
	var serviceCode=code.value;
	var includeHomeMedicationAllYN='';
		
	$.ajax({
		type:'POST',
		url:"../jsp/PkgDefIncludeHomeMedicationAjax.jsp?service_code="+serviceCode+"&type="+type,
		async:false,
		dataType:"json",
		success : function(data){
		//	alert("data"+data);
			includeHomeMedicationAllYN=data.includeHomeMedicationAllYN;
		//	alert("includeHomeMedicationAllYN "+includeHomeMedicationAllYN);
		},

			 error: function(data){
				 alert("error:: "+data);
		     }
		});

//	if(includeHomeMedicationAllYN =='N'){	
	 if(pageInfo=='inclExclCoverage'){	
		var incExCriteria=$('#incExCriteria_'+index).val();		
	 	var epsdEnc=$('#episode_'+index).val();
//	 	alert("epsdEnc \ incExCriteria"+epsdEnc+'/'+incExCriteria);
	 	var incExcInd = document.getElementById('incExInd_'+index).value;

//	 	alert("epsdEnc \ incExCriteria"+epsdEnc+'/'+incExCriteria+"  incExcInd :: "+incExcInd);

	 	
	 	if((epsdEnc=='N' || epsdEnc=='A') && incExCriteria=='P' && includeHomeMedicationAllYN =='Y'){
	 	//	alert("enabled");
	 	$('#includeHomeMedication'+index).prop('disabled',false);
		$('#includeHomeMedication'+index).prop('checked', false); 	
	 	
	 	}
	 	else{
	 	//	alert("disabled");
	 		$('#includeHomeMedication'+index).prop('disabled',true);
	 		$('#includeHomeMedication'+index).prop('checked', false);
	 	}
	 	}
		
//	}
//	else{
//		$('#includeHomeMedication'+index).prop('disabled',false);
//	}
  }

  
  
  //Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
  
	if(pageInfo=='preApproval'){
		var Site_PreappDur=document.getElementById('Site_PreappDur').value;
		if(Site_PreappDur =='Y'){
		var rowCount = document.getElementById('inclRowCount').value;
		var criteria=document.getElementById('type_'+index).value;
		var preAppDur = document.getElementById('preAppDur_'+index);
		 if(criteria == 'PG' || criteria == 'T' || criteria == 'M'){
				
			   var policyParam = 'calledFrom=preApproval' +
	           '&type=' +criteria+
	           '&service_code=' + code.value;
			
			//V220413
		     $.ajax({
		            type: "POST",
		            url: "../jsp/PkgDefIncludeHomeMedicationAjax.jsp",
		            data: policyParam,
		            dataType: "json",
		            async: false,
		            success: function(data) {
	           
						if(data.preappDurCapping=='Y')
						{
	                 
							preAppDur.disabled = false;
						}
						else
							{
							preAppDur.disabled = true;
	               }

	           },
	           error: function(data) {
	               alert(data)
	           }
	       });
	       
	      

	   }
		else
		{
		preAppDur.disabled = true;
	}


	}
	}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
}

async function callCommonValidationSpecCode(obj,code,clinicNurs,clinicCode){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	var sqlSelect = '';
	var clinicVal = clinicCode.value;
	if(clinicNurs.value == 'C'){
		if(clinicVal != '**'){
			sqlSelect = 1;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else if(clinicNurs.value == 'N'){
		if(clinicVal != '**'){
			sqlSelect = 2;
		}
		else{
			sqlSelect = 3;
		}
		
	}
	else{
		sqlSelect = 3;
	}

	switch(sqlSelect){
			
		case 1:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select speciality_code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' and clinic_code = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
			title = 'Speciality';
			break;
		}

		case 2:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"' "+
				" and speciality_code in (select SPECIALTY_CODE from IP_NURS_UNIT_FOR_SPECIALTY WHERE  FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE = '"+clinicVal+"') "+
				" Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}

		case 3:
		{
			sql="Select description, code from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '"+locale+"'  Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Speciality';
			break;
		}
					
	}

	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[1];
		code.value = arr[0];	
	}
	else
	{
	obj.value = '';
	code.value = '';		
	} 


}

function fnClearCode(obj,index){
	
	obj.value = '';
}

//Lookup for Billing Service Popup
async function callBlngServPopup(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facility_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';

	var criteria = drop.value;
	var parent = document.forms[0].criteria.value;
	var parent_blng_code = document.forms[0].blngCode.value;

	if(parent == 'BSG'){
		if(criteria == 'BSGC'){
			sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE upper(substr(serv_classification_code,1,2)) = upper('"+parent_blng_code+"') and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Classification';
		}
		else if(criteria == 'S'){
			sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(substr(blng_serv_code,1,2)) = upper('"+parent_blng_code+"') and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';							
		}
		else if(criteria == 'M'){
			sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Material Item';
		}
		else if(criteria == 'PG'){
			sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
			title = 'Package Group';
		}
	}
	else if(parent == 'BSGC'){
		if(criteria == 'S'){
			sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(substr(blng_serv_code,1,4)) = upper('"+parent_blng_code+"') and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';							
		}
	}
	else if(parent == 'PG'){
		if(criteria == 'BSG'){
			sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Service Group';
		}
		else if(criteria == 'BSGC'){
			sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Classification';
		}
		else if(criteria == 'S'){
			sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Billing Services';							
		}
		else if(criteria == 'M'){
			sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Material Item';
		}
		else if(criteria == 'T'){
			sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Sale Category';
		}
		else if(criteria == 'ESG'){
			sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Enterprise Service Group';
		}
		else if(criteria == 'ESGL'){
			sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Enterprise Service Group Line';
		}
	}
	else if(parent == 'T'){
		if(criteria == 'M'){
			sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Material Item';
		}
	}
	else if(parent == 'ESG'){
		if(criteria == 'ESGL'){
			sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
			title = 'Enterprise Service Group Line';
		}
	}

	
	/*if(criteria == 'S'){
		sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Services';							
	}
	else if(criteria == 'BSG'){
		sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Service Group';
	}
	else if(criteria == 'BSGC'){
		sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Billing Classification';
	}
	else if(criteria == 'ESG'){
		sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Enterprise Service Group';
	}
	else if(criteria == 'ESGL'){
		sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Enterprise Service Group Line';
	}
	
	else if(criteria == 'PG'){
		sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Package Group';
	}
	else if(criteria == 'M'){
		sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Material Item';
	}
	else if(criteria == 'T'){
		sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
		title = 'Sale Category';
	}*/
	
	//alert('sql->'+sql)
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(sqlSelect == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
	}
	else if(sqlSelect == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
	}
		
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[1];
		code.value = arr[0];	
	}
	else
	{
		obj.value = '';
		code.value = '';		
	} 


}
//Lookup for Billing Service Popup
function disableButtons(){
	parent.parent.commontoolbarFrame.document.getElementById('create').disabled = true;
	parent.parent.commontoolbarFrame.document.getElementById('query').disabled = true;
}

//Across Encounters
async function fnAcrossEncounter(){
	var frm = document.forms[0];
	var payerGroup = frm.payerGroup.value;
	var payer = frm.payer.value;
	var policy = frm.policy.value;
	var episodeType = frm.episodeType.value;
	var encGrpId = frm.encGrpId.value;
	var episodeId = frm.episodeId.value;
	var compressed = frm.compressed.value;//V220413
	var patientId="";
	if(compressed=='Y')
		patientId = frm.encPatientId.value;//V220413
	else{
		patientId = frm.patientId.value;//V220413
		compressed='N';
	}
	var dialogUrl       = "../../eBL/jsp/EncounterSpecAcrossEncounter.jsp?title=Encounter"+
	"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&episodeType="+episodeType+
	"&encGrpId="+encGrpId+"&episodeId"+episodeId+"&patientId="+patientId+"&compressed="+compressed; //V220413

	var dialogFeatures  = "dialogHeight:" + "60vh" + "; dialogWidth:" + "70vw" +" ; scroll=auto; ";

	var returnVal = await top.window.showModalDialog(dialogUrl,null,dialogFeatures);	
	if(returnVal != 'undefined' && returnVal != 'null' && returnVal != undefined && returnVal != null){
			frm.encGrpId.value = returnVal;
	}
}

function fnChangeAcrossGrpId(obj){
	window.returnValue = obj;
	window.close();	
	//toCloseTopShowModal(obj);
}

function resizeFrames(){
	document.getElementById('resizeLink').style.visibility = 'hidden';
	document.getElementById('resizeBtn').style.visibility = 'hidden';
	document.getElementById('resetLink').style.visibility = 'visible';
	document.getElementById('resetBtn').style.visibility = 'visible';
	//parent.document.getElementById('ContainerFrame').rows="23%,18%,0%,5%,48%,6%";
	parent.document.getElementById("encounterSpecPolicyDefnSrchCreteria").style.height="20vh";
	parent.document.getElementById("encounterSpecPolicyDefnDataDetails").style.height="18vh";
	parent.document.getElementById("PolicyCoverageMain").style.height="0vh";
	parent.document.getElementById("PolicyDetailsTab").style.height="7vh";
	parent.document.getElementById("PolicyDetailsPage").style.height="45vh";
	parent.document.getElementById("PolicyDetailsAdd").style.height="8vh";
	/*parent.document.getElementById("encounterSpecPolicyDefnSrchCreteria").style.width="98vw";
	parent.document.getElementById("encounterSpecPolicyDefnDataDetails").style.width="98vw";
	parent.document.getElementById("PolicyCoverageMain").style.width="98vw";
	parent.document.getElementById("PolicyDetailsTab").style.width="98vw";
	parent.document.getElementById("PolicyDetailsPage").style.width="98vw";
	parent.document.getElementById("PolicyDetailsAdd").style.width="98vw";*/
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="100%,0%,0%";	
	parent.frames[2].document.getElementById("SercviceCoverage").style.height="0vh";
	parent.frames[2].document.getElementById("ServicePolicyCoverageTab").style.height="0vh";
	parent.frames[2].document.getElementById("ServiceCoverageTabDetails").style.height="0vh";
	parent.frames[2].document.getElementById("SercviceCoverage").style.width="100vw";
	parent.frames[2].document.getElementById("ServicePolicyCoverageTab").style.width="100vw";
	parent.frames[2].document.getElementById("ServiceCoverageTabDetails").style.width="100vw";
}

function resetFrames(){
	document.getElementById('resizeLink').style.visibility = 'visible';
	document.getElementById('resizeBtn').style.visibility = 'visible';
	document.getElementById('resetLink').style.visibility = 'hidden';
	document.getElementById('resetBtn').style.visibility = 'hidden';
	//parent.document.getElementById('ContainerFrame').rows="23%,18%,38%,5%,10%,6%";
	parent.document.getElementById("encounterSpecPolicyDefnSrchCreteria").style.height="20vh";
	parent.document.getElementById("encounterSpecPolicyDefnDataDetails").style.height="18vh";
	parent.document.getElementById("PolicyCoverageMain").style.height="30vh";
	parent.document.getElementById("PolicyDetailsTab").style.height="7vh";
	parent.document.getElementById("PolicyDetailsPage").style.height="18vh";
	parent.document.getElementById("PolicyDetailsAdd").style.height="7vh";
	/*parent.document.getElementById("encounterSpecPolicyDefnDataDetails").style.width="98vw";
	parent.document.getElementById("PolicyCoverageMain").style.width="98vw";
	parent.document.getElementById("PolicyDetailsTab").style.width="98vw";
	parent.document.getElementById("PolicyDetailsPage").style.width="98vw";
	parent.document.getElementById("PolicyDetailsAdd").style.width="98vw";*/
	//parent.PolicyCoverageMain.document.getElementById('ContainerCoverage').rows="36%,10%,54%";
	parent.frames[2].document.getElementById("SercviceCoverage").style.height="40vh";
	parent.frames[2].document.getElementById("ServicePolicyCoverageTab").style.height="16vh";
	parent.frames[2].document.getElementById("ServiceCoverageTabDetails").style.height="45vh";
	parent.frames[2].document.getElementById("SercviceCoverage").style.width="100vw";
	parent.frames[2].document.getElementById("ServicePolicyCoverageTab").style.width="100vw";
	parent.frames[2].document.getElementById("ServiceCoverageTabDetails").style.width="100vw";
	
	
}

async function fnShowPolicyDetailReport(){	
	var frm = parent.PolicyDetailsPage.document.forms[0];	
	var mode = 'modify';
	var auth='';
	var payerGroup = frm.payerGroup.value;
	var payer = frm.payer.value;
	var policy = frm.policy.value;
	//var patientId = frm.patientId.value;
	var visitId = frm.visitId.value;
	var acctSeq = frm.acctSeq.value;
	var priority = frm.priority.value;
	var episodeType = frm.episodeType.value;		
	var episodeId = frm.episodeId.value;
	var facility_id = frm.facility_id.value;
	var endDate = frm.endDate.value;
	var startDate = frm.startDate.value;
	var pageInfo = frm.pageInfo.value;
	var compressed = frm.compressed.value;
	var patientId="";
	if(compressed=='Y'){
		patientId = frm.encPatientId.value;//V220413
	}else{
		patientId = frm.patientId.value;
		compressed='N';
	}
	
	if(pageInfo == 'inclExclCoverage'){		
		
		getXMLString('inclExclCoverage');
		
/*	var dialogUrl = "../../eBL/jsp/PolicyDetailsData.jsp?"+
		"title=Include Exclude Details"+				
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payergroupCode="+payerGroup+
		"&payerCode="+payer+
		"&policyCode="+policy+
		"&patientId="+patientId+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+
		"&policyNo="+policyNo+
		"&policyEncounter="+policyEncounter+
		"&priorityKey="+priorityKey;
		*/

		auth = frm.auth.value;
		var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Include Exclude Details"+
		"&source=EncounterInclExclLookup"+
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payergroupCode="+payerGroup+
		"&payerCode="+payer+
		"&policyCode="+policy+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+"&patientId="+patientId+"&compressed="+compressed;//V220413

		var dialogFeatures  = "dialogHeight:" + "100vh" + "; dialogWidth:" + "80vw" +" ; scroll=auto; ";
		
		await window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		

		parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsInclExcl.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
		'&patinetId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&facility_id='+facility_id+'&auth='+auth+"&compressed="+compressed;//V220629
	}
	else if(pageInfo == 'preApproval'){		
		
		getXMLString('preApproval');
		
		var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Pre Approval Details"+
		"&source=EncounterPreApprovalLookup"+
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payergroupCode="+payerGroup+
		"&payerCode="+payer+
		"&policyCode="+policy+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+"&patientId="+patientId+"&compressed="+compressed;//V220413
		
		auth = frm.auth.value;
		var dialogFeatures  = "dialogHeight:" + "100vh" + "; dialogWidth:" + "80vw" +" ; scroll=auto; ";
		await window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		
		parent.PolicyDetailsPage.document.location.href = '../../eBL/jsp/EncounterPolicyDetailsPreApproval.jsp?mode='+mode+'&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
		'&patinetId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&facility_id='+facility_id+'&auth='+auth+"&compressed="+compressed;//V220629
	}
	else if(pageInfo == 'PreApprovalPopup'){
		getXMLString('PreApprovalPopup');
		var patClass = frm.patClass.value;
		var encEpsd = frm.encEpsd.value;
		var gender = frm.gender.value;
		var ageGroup = frm.ageGroup.value;
		var clinicNursInd = frm.clinicNursInd.value;
		var clinicNursCode = frm.clinicNursCode.value;
		var spltyCode = frm.spltyCode.value;
		var criteria = frm.criteria.value;
		var blngCode = frm.blngCode.value;
		var rowNumber = frm.rowNumber.value;
		
		var dialogUrl = "../../eBL/jsp/PolicyDataDetailsFrame.jsp?"+
		"title=Service Limit Details"+
		"&source=EncounterServiceLimitLookup"+
		"&startDate="+startDate+
		"&endDate="+endDate+
		"&mode=modify"+
		"&payerGroup="+payerGroup+
		"&payer="+payer+
		"&policy="+policy+
		"&visitId="+visitId+
		"&acctSeq="+acctSeq+
		"&priority="+priority+
		"&episodeType="+episodeType+
		"&episodeId="+episodeId+
		
		"&patClass="+patClass+
		"&encEpsd="+encEpsd+
		"&gender="+gender+
		"&ageGroup="+ageGroup+
		"&clinicNursInd="+clinicNursInd+
		"&clinicNursCode="+clinicNursCode+
		"&spltyCode="+spltyCode+
		"&criteria="+criteria+
		"&blngCode="+blngCode+
		"&rowNumber="+rowNumber+"&patientId="+patientId+"&compressed="+compressed;//V220413
		
		var dialogFeatures  = "dialogHeight:" + "100vh" + "; dialogWidth:" + "80vw" +" ; scroll=auto; ";
		await window.showModalDialog(dialogUrl,'Policy Details',dialogFeatures);		
		parent.PolicyDetailsPage.document.location.href = "../../eBL/jsp/EncounterSpecPreApprovalPopup.jsp?title=Service&rowNumber="+rowNumber+"&criteria="+criteria+"&patClass="+patClass+"&blngCode="+blngCode+
		"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+
		'&patientId='+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
		'&facility_id='+facility_id+
		"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode;

	}
	
}

function fnLoadSelectedCoverage(epsdEnc,patClass,ageGrp,gender,clinicNurs,clinicNursCode,specCode,criteria,billServCode,startDate,funcMode){
	var mode = document.forms[0].mode.value;
	var payerGroup = document.forms[0].payerGroup.value;
	var payer = document.forms[0].payer.value;
	var policy = document.forms[0].policy.value;
	var patientId = document.forms[0].patientId.value;
	var visitId = document.forms[0].visitId.value;
	var acctSeq = document.forms[0].acctSeq.value;
	var priority = document.forms[0].priority.value;
	var episodeType = document.forms[0].episodeType.value;		
	var episodeId = document.forms[0].episodeId.value;
	var facility_id = document.forms[0].facility_id.value;
	var endDate = document.forms[0].endDate.value;
	
	var temp_jsp="../../eBL/jsp/EncounterSpecPersistence.jsp?func_mode="+funcMode+
	'&mode='+mode+
	'&payergroupCode='+payerGroup+
	'&payerCode='+payer+
	'&policyCode='+policy+
	'&patientId='+patientId+
	'&visitId='+visitId+
	'&acctSeq='+acctSeq+
	'&priority='+priority+
	'&episodeType='+episodeType+
	'&episodeId='+episodeId+
	'&facility_id='+facility_id+
	'&epsdEnc='+epsdEnc+
	'&patClass='+patClass+
	'&ageGrp='+ageGrp+
	'&gender='+gender+
	'&clinicNurs='+clinicNurs+
	'&clinicNursCode='+clinicNursCode+
	'&specCode='+specCode+
	'&criteria='+criteria+
	'&billServCode='+billServCode+
	'&startDate='+startDate;
	//alert(temp_jsp)
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	if(responseText == 'No'){
		alert('Record already added');
		return false;
	}else{
		window.close();
	}

}

function fnLoadSelectedCoveragePopup(criteriaPop,billServCodePop,startDatePop){

	var rowNumber = document.forms[0].rowNumber.value;
	var criteria = document.forms[0].criteria.value;
	var startDate = document.forms[0].startDate.value;
	var endDate = document.forms[0].endDate.value;
	var blngCode = document.forms[0].blngCode.value;

	var mode = document.forms[0].mode.value;
	var payerGroup = document.forms[0].payerGroup.value;
	var payer = document.forms[0].payer.value;
	var policy = document.forms[0].policy.value;

	var patClass = document.forms[0].patClass.value;
	var encEpsd = document.forms[0].encEpsd.value;
	var gender = document.forms[0].gender.value;
	var ageGroup = document.forms[0].ageGroup.value;
	var clinicNursInd = document.forms[0].clinicNursInd.value;
	var clinicNursCode = document.forms[0].clinicNursCode.value;
	var patientId = document.forms[0].patientId.value;
	var spltyCode = document.forms[0].spltyCode.value;
	
	var visitId = document.forms[0].visitId.value;
	var acctSeq = document.forms[0].acctSeq.value;
	var priority = document.forms[0].priority.value;
	var episodeType = document.forms[0].episodeType.value;		
	var episodeId = document.forms[0].episodeId.value;
	
	var temp_jsp="../../eBL/jsp/EncounterSpecPersistence.jsp?func_mode="+"preApprovalPopupLookup"+
	'&mode='+mode+
	'&payergroupCode='+payerGroup+
	'&payerCode='+payer+
	'&policyCode='+policy+
	'&patientId='+patientId+
	'&visitId='+visitId+
	'&acctSeq='+acctSeq+
	'&priority='+priority+
	'&episodeType='+episodeType+
	'&episodeId='+episodeId+
	'&epsdEnc='+encEpsd+
	'&patClass='+patClass+
	'&ageGrp='+ageGroup+
	'&gender='+gender+
	'&clinicNurs='+clinicNursInd+
	'&clinicNursCode='+clinicNursCode+
	'&specCode='+spltyCode+
	'&criteria='+criteria+
	'&billServCode='+blngCode+
	'&startDate='+startDate+
	
	'&rowNumber='+rowNumber+
	'&criteriaPop='+criteriaPop+
	'&billServCodePop='+billServCodePop+
	'&startDatePop='+startDatePop;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";				
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);
	if(responseText == 'No'){
		alert('Record already added');
		return false;
	}else{
		window.close();
	}

}

function getXMLString(last_link)	
{
	
	if(last_link == "Outpatient")
	{
		
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"Outpatient");
		
		
		
	}
	else if(last_link == "Inpatient")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"Inpatient");
		
	}
	else if(last_link == "External")
	{  
		var frmObj = eval("parent.ServiceCoverageTabDetails.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		var updation=formValidation(xmlString,"External");
	}
	else if(last_link == "inclExclCoverage")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"inclExclCoverage");	
	}
	
	else if(last_link == "preApproval")
	{
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
			
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"preApproval");	
	}

	else if(last_link == "PreApprovalPopup"){
		var frmObj = eval("parent.PolicyDetailsPage.document.forms[0]");
		
		var xmlString=formXMLStringMain(frmObj);
		//alert(xmlString)
		var updation=formValidation(xmlString,"popup");	
	}

	var excln_form = "";
	
	
	
}

/* Added V181005-Aravindh/AAKH-CRF-0107/Starts */
function unCheckAllLineLvlRefChkBox(obj) {
	
	if(obj == 'hdr') {
		var formObj = parent.parent.PolicyDetailsPage;
		var inclRowCount = formObj.document.getElementById("inclRowCount").value;
		if(!(parent.parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverRefPriceHdr.checked)) {
			for(var i = 1; i<= inclRowCount; i++) {
				formObj.document.getElementById("coverRefPrice_"+i).checked = false;
			}
		}
	} else if(obj == 'line') {
		var formObj = parent.PolicyDetailsPage;
		var inclRowCount = formObj.document.getElementById("inclRowCount").value;
		if(!(parent.PolicyCoverageMain.SercviceCoverage.frmPolicyInfo.coverRefPriceHdr.checked)) {
			for(var i = 1; i<= inclRowCount; i++) {
				formObj.document.getElementById("coverRefPrice_"+i).checked = false;
			}
		}
	}	
}

//NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts -->
var remarks = "";
async function Remarkshow(){	
	var payerGroup=document.getElementById("payerGroup").value;
	var payer=document.getElementById("payer").value;
	var policy=document.getElementById("policy").value;
	var dialogUrl1 = "../../eBL/jsp/BLRemarks.jsp?patview=Y"+"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy;
	var dialogArguments = "";
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	var	returnRemarks =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
}
//NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends -->

// MOHE-CRF-0114 Changes by Manivel N

function chkDiagBasedCopayYN(indx) {
    var chk = 'chkDiagBasedCopayYN_' + indx;
    var obj = 'diagBasedCopayLink_' + indx;
    var serv = "incExCriteria_" + indx;
    var blng_code = 'bg_code_' + indx;
    var val = document.getElementById(serv).value;
    var chkBox = document.getElementById(chk);
    var link = document.getElementById(obj);
    var blng_code_val = document.getElementById(blng_code).value;
    if (chkBox.checked) {
        if (!(val == 'BSG' || val == 'BSGC' || val == 'ESG' || val == 'T' || val == 'PG')) {
            alert(getMessage("BL9134", "BL"));
            link.style.visibility = 'hidden';
            chkBox.checked = false;
        } else {
            if (blng_code_val.length > 0) {
                link.style.visibility = 'visible';
            } else {
                alert('Enter Billing Service details');
                link.style.visibility = 'hidden';
                chkBox.checked = false;
            }
        }

    } else {
        link.style.visibility = 'hidden';
    }	
}

async function openDiagBasedCopay(obj){
	var serv = "incExCriteria_"+obj;
	var val = document.getElementById(serv).value;

	var patClass = document.getElementById("ptClass_"+obj).value;
	var blngCode = document.getElementById("bg_code_"+obj).value;
	var payerGroup = document.getElementById('payerGroup').value;
	var payer = document.getElementById('payer').value;
	var policy = document.getElementById('policy').value;

	var mode = document.getElementById('mode').value;
	var startDate = document.getElementById("effFrom_"+obj).value;
	var endDate = document.getElementById("effTo_"+obj).value;
	
	var visitId = document.getElementById('visitId').value;
	var acctSeq = document.getElementById('acctSeq').value;
	var priority = document.getElementById('priority').value;
	var episodeType = document.getElementById('episodeType').value;
	var episodeId = document.getElementById('episodeId').value;
	
	var encEpsd = document.getElementById("episode_"+obj).value;
	var gender = document.getElementById("gender_"+obj).value;
	var ageGroup = document.getElementById("hdn_age_group_"+obj).value;
	var clinicNursInd = document.getElementById("clinic_"+obj).value;
	var clinicNursCode = document.getElementById("clinic_code_"+obj).value;
	var spltyCode = document.getElementById("spec_code_"+obj).value;
	var compressed = document.getElementById("compressed").value; //V220413
	var patientId="";
	if(compressed=='Y'){
		patientId = document.getElementById("encPatientId").value; //V220413
	}else{
		patientId = document.forms[0].patientId.value;
		compressed='N';
	}

	var rowNumber = document.getElementById("rowNumber" + obj).value;

	var criteriaPop = "";
	var startDatePop = "";

    var temp_jsp = "../../eBL/jsp/EncounterSpecPersistence.jsp?func_mode=" +
        "diagCopayPopupLoad" + '&mode=' +
        mode +
        '&payergroupCode=' +
        payerGroup +
        '&payerCode=' +
        payer +
        '&policyCode=' +
        policy + 
		"&patientId="+patientId+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
        '&epsdEnc=' +
        encEpsd +
        '&patClass=' +
        patClass +
        '&ageGrp=' +
        ageGroup +
        '&gender=' +
        gender +
        '&clinicNurs=' +
        clinicNursInd +
        '&clinicNursCode=' +
        clinicNursCode +
        '&specCode=' +
        spltyCode +
        '&criteria=' +
        val +
        '&billServCode=' +
        blngCode +
        '&startDate=' +
        startDate +
        '&rowNumber=' +
        rowNumber +
        '&criteriaPop=' +
        criteriaPop +
        '&billServCodePop=' +
        blngCode +
        '&startDatePop=' +
        startDatePop +
		'&compressed='+compressed;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    var xmlStr = "<root><SEARCH ";
    xmlStr += " /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    var responseText = trimString(xmlHttp.responseText);

    if (responseText == 'No') {
        alert('Record already added');
        return false;
    } else {
        window.close();
    }	

	var dialogUrl       = "../../eBL/jsp/EncounterSpecDiagCopayPopupFrame.jsp?title=Diagnosis Type&rowNumber="+obj+"&criteria="+val+"&patClass="+patClass+"&blngCode="+blngCode+
						"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&mode="+mode+"&startDate="+startDate+"&endDate="+endDate+"&patientId="+patientId+
						'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&episodeType='+episodeType+'&episodeId='+episodeId+
						"&encEpsd="+encEpsd+"&gender="+gender+"&ageGroup="+ageGroup+"&clinicNursInd="+clinicNursInd+"&clinicNursCode="+clinicNursCode+"&spltyCode="+spltyCode+"&compressed="+compressed; //V220413

	var dialogFeatures  = "dialogHeight:" + "20" + "; dialogWidth:" + "70" +" ; scroll=auto; ";

	var returnVal =await window.showModalDialog(dialogUrl,null,dialogFeatures);	
}

function addRowDiag() {
    var frm = parent.PolicyDetailsDiagCopayPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'DiagCopayPopup') {
        addRow('DiagCopayPopup')
    }
    // alert(pageInfo);
}

function removeRowDiagClose() {
    var frm = parent.PolicyDetailsDiagCopayPage.document.forms[0];
    var pageInfo = frm.pageInfo.value;
    if (pageInfo == 'PreApprovalPopup') {
        removeRow('PreApprovalPopup')
    } else if(pageInfo == 'DiagCopayPopup') {
        removeRow('DiagCopayPopup')
    }
    // alert(pageInfo);
}

function saveDiagCopay(){
    var frmObj = parent.PolicyDetailsDiagCopayPage.document.forms[0];
	var frmValidation = validateDiagCopayForm(frmObj);
	//frmValidation = false;
	if(frmValidation == true){
		xmlString = formXMLStringMain(frmObj);
		// alert(xmlString);
		updation = formValidation(xmlString, "diagpopup");
		window.close();
	}
}

function validateDiagCopayForm(formObj){
	var totRec = formObj.inclRowCount.value;
	
	for(var i=1;i<=totRec;i++){
		var diagType = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_diagType_'+i).value;
		var diagCopay = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_copay_'+i);
		var diagEffFrom = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_effFrom_'+i);
		var diagEffTo = parent.PolicyDetailsDiagCopayPage.document.getElementById('popDiag_effTo_'+i);
		var copaycheck = checkCopayValue(diagCopay);

		if(copaycheck == true){
			var effFrmDateCheck = checkDiagEffDateFrom(diagEffFrom);

			if(effFrmDateCheck == false)
				return false;
			else{
				var PolicyAndDiagDatesCheck = callPolicyAndDiagDatesCheck(diagEffFrom,diagEffTo);

				if(PolicyAndDiagDatesCheck == false)
					return false;
			}
		} else{
			return false;
		}
	}
	return true;
}

function checkCopayValue(obj){
	if(obj.value != ""){
		if(obj.value < 0 || obj.value > 100){
			alert(getMessage("BL00254","BL"));
			obj.value = "";
			obj.focus();
			return false;
		}
	} else {
		alert(getMessage("BL9901","BL"));
			obj.value = "";
			obj.focus();
			return false;
	}
	return true;
}

function checkDiagEffDateFrom(obj){

	if(obj.value == ""){
		alert(getMessage("BL8504","BL"));
		obj.focus();
		return false;
	}

	return true;
}

function callPolicyAndDiagDatesCheck(diagEffFrom,diagEffTo){
	
	var status_chk = checkDateFromDiag(diagEffFrom);
	
	if(status_chk == true)
		status_chk = checkDateFromDiag(diagEffTo);
	
	if(status_chk == true)
		return true;
	else
		return false;
}

function checkDateFromDiag(obj){
	
	var stdt = parent.PolicyDetailsDiagCopayPage.document.getElementById('startDate').value;
	var endt = parent.PolicyDetailsDiagCopayPage.document.getElementById('endDate').value;
	var startdtarr =stdt.split("/");//alert("startdtarr:"+startdtarr);
	var enddtarr = endt.split("/");//alert("enddtarr:"+enddtarr);
	var objarr = obj.value.split("/");//alert("objarr:"+objarr);
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		alert("Please enter date in range "+stdt+" and "+endt);
		obj.value = '';
		obj.focus();
		return false;
	}
	return true;
}


/* V230228 starts */
async function encounterSpecMFDRDtls(){
	
	var frm = parent.parent.parent.frames[1].frames[0].document.forms[0]; 
	var patientId = frm.patient_id.value;
	var episodeType = frm.episode_type.value;
	var episodeId = frm.episode_id.value;
	var encounterDate = frm.Effective_from.value;
	
	var frmObj = document.forms[0];
	
	var encounterId = frmObj.encounterId.value;
	var payerGroup = frmObj.payerGroup.value;
	var payer = frmObj.payer.value;
	var policy = frmObj.policy.value;
	var acctSeq = frmObj.acctSeq.value;
	var visitId = frmObj.visitId.value;
	var priority = frmObj.priority.value;
	var mode = 'modify';
	var qryParam = '&payergroupCode='+payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&acctSeq='+acctSeq+'&patientId='+patientId+'&episodeId='+episodeId+'&episodeType='+episodeType+'&encounterDate='+encounterDate+'&visitId='+visitId+'&encounterId='+encounterId+'&priority='+priority+'&mode='+mode;
	
	var retVal = new String();
	var dialogHeight= "90vh" ;
	var dialogWidth	= "90vw" ;
	var dialogTop = "10px" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop :" + dialogTop +"; status=no";
	var arguments			= "" ;
	var message				= "" ;

	var title = getLabel("eBL.MultiFactorDeductibleRule.label","BL"); 
	
	var param = "title="+title+qryParam;
	
	var retVal=await top.window.showModalDialog("../../eBL/jsp/EncSpecMFDRUpdMain.jsp?"+param,arguments,features); 
	
	
}

function addNewRow(){
	
	var frm = parent.frames[0].document.forms[0];
	var pageInfo = frm.pageInfo.value;
	if(pageInfo == 'ServicesAndItemsCategoryDetails'){  
		addRow('ServicesAndItemsCategoryDetails');
	} 
}

function submitEncSpecMFDRUpdData(){
	var parentDoc = parent.frames[0].document;
	var frmObj = parent.frames[0].document.forms[0];
	
	var episodetype = getLabel("eBL.EpisodeEncounter.label", "bl");  
	var patClass = getLabel("Common.type.label", "common");
	var payerGrpLbl = getLabel("eBL.PAYER_GROUP.label", "bl");
	var payerLbl = getLabel("eBL.PAYER.label", "bl");
	var policyLbl = getLabel("eBL.POLICY_TYPE.label", "bl");
	var clinicCat = getLabel("Common.category1.label", "common");
	var clinicProcUnit = getLabel("eBL.Clinic_Proc_unit.label","bl");
	var serviceDtls = getLabel("eBL.Servicedtls.label", "bl");
	var ref = getLabel("Common.referral.label", "common");
	var patCopay = getLabel("eBL.PatCopay.label", "bl");
	var amtLimit = getLabel("eBL.PatAmtLimit.label", "bl");
	var eff_From = getLabel("eBL.EffFromDate.label", "bl");
	var pageInfo = frmObj.pageInfo.value;			 
	var index = frmObj.rowCount.value;
				
	for(var i = 1; i <= index; i++){
			
		var epsdEnc = parentDoc.getElementById("episode_"+i);
		var pat_Class = parentDoc.getElementById("ptClass_"+i);
		var payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i);
		var payer_desc = parentDoc.getElementById("payer_desc_"+i);
		var policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i);
		var clinic_category = parentDoc.getElementById("clinic_category_"+i);
		var clinic_proc_unit = parentDoc.getElementById("clinic_"+i);
		var service_Dtls = parentDoc.getElementById("service_dtls_desc_"+i);
		var referral = parentDoc.getElementById("referral_"+i);
		var pat_Copay = parentDoc.getElementById("patCopay_"+i);
		var patLimitAmt = parentDoc.getElementById("patLimitAmt_"+i);
		var effFrom = parentDoc.getElementById("effFrom_"+i);
					 
		var fieldsTop = new Array(epsdEnc,pat_Class,
						payer_group_desc, payer_desc,
						policy_type_desc, clinic_category,
						clinic_proc_unit, service_Dtls,
						referral, pat_Copay, patLimitAmt, effFrom);
			
		var namesTop = new Array(episodetype, patClass , payerGrpLbl, payerLbl, policyLbl, clinicCat,
						clinicProcUnit, serviceDtls, ref, patCopay, amtLimit, eff_From);
			
		var msgFrame = parent.parent.messageFrame;
			
		validForm = checkFieldsofMst(fieldsTop, namesTop, msgFrame);
		if(validForm == false){
			return false;
			}	
		} 	
		if(validForm == true)
		{
			var mode = frmObj.mode.value;
			xmlString = formXMLStringMain(frmObj);
			updation = formValidation(xmlString, pageInfo);	
		/*	frmObj.target = 'messageFrame';
			frmObj.method = "post";
			frmObj.action = "../../servlet/eBL.MultiFactorDeductRuleMasterServlet?mode=" + mode;
			frmObj.submit();  */
		}	
		if(updation==true)
			window.close();
		
}


function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
    }
	
	return xmlStr;
}


/*
function formValidation(xmlStr, last_link, event) {
	
	var temp_jsp = "../../eBL/jsp/EncounterSpecPersistence.jsp?func_mode=" + last_link;
    if (event != null && event == "delete")
        temp_jsp = "../../eBL/jsp/EncounterSpecPersistence.jsp?func_mode=" + last_link +
        "&event=" + event;

    var xmlDoc="";
    var xmlHttp = new XMLHttpRequest();
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
    
    var responseText = xmlHttp.responseText;
	eval(responseText);
    return true;
}
*/
async function callCommonValidationMFDR(sqlSelect, obj, code, index){
	
	var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    switch (sqlSelect) {
        case 1:
            {
                sql = "select description, code  from (select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" +
                locale +
                "' Union Select 'All Specialities','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?)  order by 2";
                title = 'Speciality';
                break;
            }
        case 2:
            {
				var payer_group_code = document.getElementById("payer_group_code_"+index).value;
        	//	var cust_code = document.forms[0].payer_group_code.value;
                sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw " +
                "Where Cust_Code In ( SELECT cust_code " +
                "FROM bl_cust_by_cust_group " +
                "WHERE cust_group_code = " +
                "DECODE ('" +
                payer_group_code +
                "', " +
                "'**', cust_group_code, '" +
                payer_group_code +
                "')) " +
                "and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' " +
                "and nvl(pat_com_flag,'N')='N' " +
                "And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
                "and upper(language_id) = upper('" +
                locale +
                "') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

                title = 'Payer';
                break;
            }
        case 3:
            {
                sql = "select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and " +
                "cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                "where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') " +
                "and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                "And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) " +
                " order by 2";

                title = 'Payer Group';
                break;
            }
        case 4:
			{
				var cust_group_code = document.getElementById("payer_group_code_"+index).value;
				var cust_code = document.getElementById("payer_code_"+index).value;
				
				sql="SELECT description,code from ( select a.long_desc description, a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b   where  language_id='"+locale+		  "' AND (b.cust_group_code =  '"+cust_group_code+"' OR b.cust_group_code = '**') AND (b.cust_code = '"+cust_code+"' OR b.cust_code = '**') "+
						" AND a.policy_type_code = b.policy_type_code "+
						" AND a.operating_facility_id = '"+facility_id+"'  AND UPPER (a.language_id) = UPPER ('"+locale+"') "+
						" union  Select 'All Policy','**' From Dual)" +
						" WHERE upper(description) like upper(?) and upper(code) like upper(?) order by 2 ";
				
				title = 'Policy';
                break;
            }
		case 5:
			{
			
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; 
                
				title = 'Package Group';
                break;
            } //V230210

    }
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = '';
        code.value = '';
    }

}

function checkForReferralCategory(ref, clinicCat, ind){
	
	var parentDoc = parent.CategoryDtls.document;
	var epsdEnc = '';
	var payer_group_desc = '';
	var payer_desc = '';
	var policy_type_desc = '';
	var clinic_category = ''; 
	var referral = '';
	var serviceDtls = '';
	var clinic_proc_unit = '';
	var clinic_proc_code = '';
	var clinic_proc_desc = '';
	var inclExclCriteria = '';
	var eff_from = '';
	var eff_to = '';
	var flag = 1;
	
	var epsdEnc1 = parentDoc.getElementById("episode_"+ind).value;
	var payer_group_desc1 = parentDoc.getElementById("payer_group_desc_"+ind).value;
	var payer_desc1 = parentDoc.getElementById("payer_desc_"+ind).value;
	var policy_type_desc1 = parentDoc.getElementById("policy_type_desc_"+ind).value;
	var clinic_Cat1 = parentDoc.getElementById("clinic_category_"+ind).value;
	var ref1 = parentDoc.getElementById("referral_"+ind).value;
	var service_dtls1 = parentDoc.getElementById("service_dtls_desc_"+ind).value;
	var clinic_proc_unit1 = parentDoc.getElementById("clinic_"+ind).value;
	var clinic_proc_code1 = parentDoc.getElementById("clinic_code_"+ind).value;
//	var clinic_proc_desc1 = parentDoc.getElementById("clinic_desc_"+ind).value;
	var eff_from1 = parentDoc.getElementById("effFrom_"+ind).value;
	for(var i = 1; i < ind; i++){
		
		epsdEnc = parentDoc.getElementById("episode_"+i).value;
		payer_group_desc = parentDoc.getElementById("payer_group_desc_"+i).value;
		payer_desc = parentDoc.getElementById("payer_desc_"+i).value;
		policy_type_desc = parentDoc.getElementById("policy_type_desc_"+i).value;	
		serviceDtls = parentDoc.getElementById("service_dtls_desc_"+i).value;
		clinic_category = parentDoc.getElementById("clinic_category_"+i).value;
		referral = parentDoc.getElementById("referral_"+i).value;
		eff_from = parentDoc.getElementById("effFrom_"+i).value;
		eff_to = parentDoc.getElementById("effTo_"+i).value;
		clinic_proc_unit = parentDoc.getElementById("clinic_"+i).value;
		clinic_proc_code = parentDoc.getElementById("clinic_code_"+i).value;
//		clinic_proc_desc = parentDoc.getElementById("clinic_desc_"+i).value;
	
		
		if(epsdEnc == epsdEnc1){	
			if(clinic_proc_unit == clinic_proc_unit1 && clinic_proc_code == clinic_proc_code1 ){
				if(clinic_category == clinicCat.value && referral == ref.value){
					
					if(eff_to != ''){
						if((eff_from1 >= eff_from) && (eff_from1 <= eff_to)){	
							alert(getMessage('BL0980', 'BLEXT'));	
							break;
							//parentDoc.getElementById("referral_"+ind).value = ""
						}
					}else{
						if(eff_from1 == eff_from){	
							alert(getMessage('BL0980', 'BLEXT'));
							break;
							//parentDoc.getElementById("referral_"+ind).value = "";
						}
					}							
				}
			}
		}
	}		
	
}

async function callClinicProcValidation(sqlSelect, drop, obj, code, obj1){
	
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
	var page_info = document.getElementById('pageInfo').value;
	var i = document.forms[0].rowCount.value;
	var clinic_category = document.getElementById("clinic_category_"+i).value;
	var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var validCheck='';
   
    switch (sqlSelect) {
        case 1:
            {
                var cn = drop.value;
                
                if (cn == 'C') {
					sql = "Select description, code from (select a.short_desc description,a.clinic_code code from OP_CLINIC_LANG_VW a, op_clinic b WHERE a.LANGUAGE_ID = '" +
                        locale +
                        "' AND a.FACILITY_ID = '" +
                        facility_id +
						"' AND NVL(a.EFF_STATUS,'D') = 'E' AND a.CARE_LOCN_TYPE_IND = 'C' and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and b.category = '" +
						clinic_category +
						"' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    
					title = 'Clinic';
                } else if (cn == 'P') {
                    sql = "Select description, code from (select a.short_desc description,a.clinic_code code from OP_CLINIC_LANG_VW a, op_clinic b WHERE a.LANGUAGE_ID = '" +
                        locale +
                        "' AND a.FACILITY_ID = '" +
                        facility_id +
						"' AND NVL(a.EFF_STATUS,'D') = 'E' AND a.CARE_LOCN_TYPE_IND = 'E' and a.facility_id = b.facility_id and a.clinic_code = b.clinic_code and b.category = '" +
						clinic_category +
						"' Union Select 'All Procedure Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    
                    title = 'Procedure Unit';
                } else if (cn == 'A') {
                    sql = "Select description, code from (Select 'All Clinic/ Procedure Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic / Procedure Unit';
                }

                break;
            }
    }
	
	argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    if(code.value != ""){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
	}else{ 
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
	}
	argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = await CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
        obj.value = arr[1];
        code.value = arr[0];
    } else {
        obj.value = '';
        code.value = '';
    }
}

function clearClinicProc(obj) {
	
    var clinicCode = 'clinic_code_' + obj;
    var clinicDesc = 'clinic_desc_' + obj;
    var clinicNurs = 'clinic_' + obj;
	var clinNursVal = document.getElementById(clinicNurs);
    var clinicBut = 'clinic_but_' + obj;
	document.getElementById(clinicDesc).disabled = false;
    document.getElementById(clinicCode).readonly = false;
	document.getElementById(clinicCode).value = '';
    document.getElementById(clinicDesc).value = '';
	document.getElementById(clinicBut).disabled = false;
    if (clinNursVal.value == 'A') {
		
        document.getElementById(clinicDesc).value = 'All Clinic/ Procedure Unit'; 
        document.getElementById(clinicCode).value = '**';
		document.getElementById(clinicDesc).disabled = true;
        document.getElementById(clinicCode).readonly = true;
        document.getElementById(clinicBut).disabled = true;
    }
}

function effFromDateValidation(obj, startDt, endDt){
	
	var locale = document.forms[0].locale.value; 
	
	if(obj.value != "") {
		var valid_status = validDateObj(obj,"DMY",locale);  
		if(valid_status == true || valid_status == "true"){
			valid_status = compareCurrent_StartDates(startDt);
			if(valid_status == true || valid_status == "true"){
				valid_status = compareDates(startDt, endDt);
			}
		}	
	}
}

function compareCurrent_StartDates(startDate){
	var starr = startDate.value.split("/");
	var currdt = new Date();
    var startdt = new Date();
	startdt.setFullYear(starr[2], starr[1] - 1, starr[0]);
	if(currdt > startdt){
		alert(getMessage('PH_FROM_DATE_GREATER_EQUAL_CURRENT_DATE', 'PH')); 
        startDate.value = '';
		return false;
	}
}

/*
function fnShowMainTabDetails(){
	
	link = object;
	var last_link = document.forms[0].last_link.value;
	var deduct_Cat = document.forms[0].deduct_Cat.value;
	var result = true;
	
	if (last_link != "") {
		var hdrfrmobj = "";
		var mode = "";
		if(last_link == "ServicesAndItemsCategoryDetails" && parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls != null){	
			hdrfrmobj = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactDedRuleServicesAndItemsCategory;
			mode = parent.DrugDiagnosisCategoryDetailsPage.CategoryDtls.document.frmMultiFactDedRuleServicesAndItemsCategory.mode.value;
			if(hdrfrmobj != null && hdrfrmobj != undefined){
				var xmlString = formXMLStringMain(hdrfrmobj);
				var updation = formValidation(xmlString, last_link);
					//	alert(xmlString);
			}
		} 
	}

	if(result){
		if (link == 'ServicesAndItemsCategoryDetails'){
		
			var frmObj = parent.frames[1].frames[0].document.forms[0];
			var index = parent.frames[1].frames[0].document.forms[0].rowCount.value;
			
			changeMainTabClass(link, parent.MultiFactorDeductRuleTab);
			parent.frames[1].CategoryDtls.location.href = "../../eBL/jsp/BLMFDRServicesAndItemsCatDtls.jsp?mode="
				+ mode;
			document.forms[0].last_link.value = link;
		} 
	}
} */

/* V230228 ends */

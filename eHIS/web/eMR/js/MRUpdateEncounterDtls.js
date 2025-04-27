function reset(){
	criteria.location.href='../../eMR/jsp/MRUpdateEncounterDtlsCriteria.jsp?called_from="MR"';
	result.location.href='../../eCommon/html/blank.html';
	messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
async function getPatID(){					  
	var pat_id=await PatientSearch();
	if( pat_id != null ){						
		parent.frames[1].document.forms[0].patient_id.value = pat_id;
	}
}
function validDateObjLoc(obj){
	var flagVal=true;
	if(obj.name=='encDateFrom'){
		if(obj.value!=''){
			if(validDateObj(obj,'DMY',localeName)){
				if(isBeforeNow(obj.value,"DMY",localeName)){
					return true;
				}else{
					alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
					flagVal=false;					
				}
			}else{
				flagVal=false;				
			}
		}
	}else if(obj.name=='encDateTo'){
		if(obj.value!=''){
			if(validDateObj(obj,'DMY',localeName)){
				if(isBeforeNow(obj.value,"DMY",localeName)){
					return true;
				}else{
					alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
					flagVal=false;
				}
			}else{
				flagVal=false;
			}
		}
	}else if(obj.name=='injury_date'){
		if(obj.value!=''){
			if(validDateObj(obj,'DMY',localeName)){
				if(isBeforeNow(obj.value,"DMY",localeName)){
					return true;					
				}else{
				    var message = getMessage('CANNOT_GREATER','MP');
					message=message.replace("#",getLabel('eMR.Injury.label','mr_labels')+" "+getLabel('Common.date.label','common_labels'));
		            message=message.replace("$",getLabel('Common.SystemDate.label','common_labels'));
					alert(message);
					parent.frames[2].location.href='../../eCommon/jsp/error.jsp';	//Added Senthil		
					flagVal=false;
				}
			}else{
				flagVal=false;
			}
		}
	}else if(obj.name=='trmt_strt_date'){
		if(obj.value!=''){
			if(validDateObj(obj,'DMY',localeName)){
				if(isBeforeNow(obj.value,"DMY",localeName)){
					return true;
				}else{
				   var message = getMessage('CANNOT_GREATER','MP');
					message=message.replace("#",getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels'));
					message=message.replace("$",getLabel('Common.SystemDate.label','common_labels'));
					alert(message); 
					parent.frames[2].location.href='../../eCommon/jsp/error.jsp';	//Added Senthil				
					flagVal=false;
				}
			}else{
				flagVal=false;
			}
		}
	}else if(obj.name=='trmt_end_date'){
		if(obj.value!=''){
			if(validDateObj(obj,'DMY',localeName)){
				return true;
			}else{
				flagVal=false;
			}
		}
	}
	if(!flagVal){
		obj.select();
		obj.focus();
		obj.value='';
	}
}
function SearchResult(){
	parent.result.location.href='../../eCommon/html/blank.html';
	if(document.forms[0].patient_id.value !='' || document.forms[0].encounter_id.value){
		var error="";
		if((document.forms[0].encDateFrom.value!='' && document.forms[0].encDateTo.value!='') && !(isBefore(document.forms[0].encDateFrom.value,document.forms[0].encDateTo.value,"DMY",localeName))){
			var msg1=getMessage("REMARKS_SHOULD_GR_EQUAL","common");
			msg1=msg1.replace("$",getLabel('Common.from.label','common_labels')+" "+getLabel('Common.encounterdate.label','common_labels'));
			msg1=msg1.replace("#",getLabel('Common.to.label','common_labels')+" "+getLabel('Common.encounterdate.label','common_labels'));
			error=msg1;
			alert(error);
		}else{
			var URL="../../eMR/jsp/MRUpdateEncounterDtlsResult.jsp?patient_id="+document.forms[0].patient_id.value+"&encounterID="+document.forms[0].encounter_id.value+"&patient_class="+document.forms[0].patient_class.value+"&encDateFrom="+document.forms[0].encDateFrom.value+"&encDateTo="+document.forms[0].encDateTo.value;
			parent.result.location.href=URL;
		}
	}else{
		alert(getMessage("AE_PAT_ENC_BLANK",'AE'))
	}
}

function ClearFrame(){
	parent.result.location.href='../../eCommon/html/blank.html';
}
async function UpdateEncDtlsModal(patient_id,encounter_id,checkedEncCount,checkedEncIds){
	var dialogHeight= "15vh" ;
    var dialogWidth = "70vw" ;
    var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
    var arguments   = "" ;
	var URL="../../eMR/jsp/MRAddModifyEncounterDtlsModel.jsp?encounterID="+encounter_id+"&patient_id="+patient_id+"&checkedEncCount="+checkedEncCount+"&checkedEncIds="+checkedEncIds;
	var retVal = await window.showModalDialog(URL,arguments,features);
	parent.result.location.reload();
}

function closeWindow(){
	window.close();
}
function updateEncDtls(){
	var error="";
	var flag=true;
	if(document.forms[0].injury_date.value==''){
		 error = getMessage("CAN_NOT_BE_BLANK","Common");
		  error=error.replace("$",getLabel('eMR.Injury.label','mr_labels')+" "+getLabel('Common.date.label','common_labels'));
		flag = false;
	}
	if(document.forms[0].trmt_strt_date.value==''){		
		if(flag){
			error = getMessage("CAN_NOT_BE_BLANK","Common");
			error=error.replace("$",getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels'));
		}else{
			error = error+"<br/>"+getMessage("CAN_NOT_BE_BLANK","Common");
			error=error.replace("$",getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels'));
		}
		flag = false;
	}

	var allEncDetails	= $("#allEncDetails").val();
	var checkedEncCount	= parseInt($("#checkedEncCount").val());
	var checkedEncIds	= $("#checkedEncIds").val();
	
	
	if(checkedEncCount <= 1){


			if((document.forms[0].enc_date.value!='' && document.forms[0].injury_date.value!='')&& !(isAfter(convertDate(document.forms[0].enc_date.value,"DMY","en",localeName),document.forms[0].injury_date.value,"DMY",localeName))){
				var msg1=getMessage("REMARKS_SHOULD_LS_EQUAL","common");
				msg1=msg1.replace("$",getLabel('eMR.Injury.label','mr_labels')+" "+getLabel('Common.date.label','common_labels'));
				msg1=msg1.replace("#",getLabel('Common.encounterdate.label','common_labels'));
				if(error!=""){
					error=error+"<br>"+msg1;
				}else{
					error=msg1;
				}
				flag=false;
			}
			if((document.forms[0].injury_date.value!='' && document.forms[0].trmt_strt_date.value!='')&&!(isBefore(document.forms[0].injury_date.value,document.forms[0].trmt_strt_date.value,"DMY",localeName))){
				var msg1=getMessage("REMARKS_SHOULD_GR_EQUAL","common");
				msg1=msg1.replace("$",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels')));
				msg1=msg1.replace("#",getLabel('eMR.Injury.label','mr_labels') +" "+getLabel('Common.date.label','common_labels')); //Added senthil
				if(error!=""){
					error=error+"<br>"+msg1;
				}else{
					error=msg1;
				}
				flag=false;
			}	
			if((document.forms[0].trmt_strt_date.value!='' &&  document.forms[0].trmt_end_date.value!='')&&!(isBefore(document.forms[0].trmt_strt_date.value,document.forms[0].trmt_end_date.value,"DMY",localeName))){
				var msg1=getMessage("REMARKS_SHOULD_GR_EQUAL","common");
				msg1=msg1.replace("$",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.enddate.label','common_labels')));
				msg1=msg1.replace("#",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels')));
				if(error!=""){
					error=error+"<br>"+msg1;
				}else{
					error=msg1;
				}
				flag=false;
			}
			
	}else{
		allEncDetails	= allEncDetails.slice(0,-2);
		var arrEncDetails	= allEncDetails.split("##");
		$(arrEncDetails).each(function(index,value) {
			var arrIndividualEncDetails	= value.split("||");
			var encID			= arrIndividualEncDetails[0];
			var encDate			= arrIndividualEncDetails[1];

			var injuryDate		= (encID == $( "input[name$='encounterID']" ).val()) ? $( "input[name$='injury_date']" ).val() :  arrIndividualEncDetails[2];
			var trmtStrtDate	= (encID == $( "input[name$='encounterID']" ).val()) ? $( "input[name$='trmt_strt_date']" ).val() :  arrIndividualEncDetails[3];
			var trmtEndDate		= (encID == $( "input[name$='encounterID']" ).val()) ? $( "input[name$='trmt_end_date']" ).val() :  arrIndividualEncDetails[4];


			if((encDate!='' && document.forms[0].injury_date.value!='')&& !(isAfter(convertDate(encDate,"DMY","en",localeName),document.forms[0].injury_date.value,"DMY",localeName))){
				var msg1=getMessage("REMARKS_SHOULD_LS_EQUAL","common");
				msg1=msg1.replace("$",getLabel('eMR.Injury.label','mr_labels')+" "+getLabel('Common.date.label','common_labels'));
				msg1=msg1.replace("#",getLabel('Common.encounterdate.label','common_labels')) +" "+ getLabel('Common.for.label','common_labels') +" <b>" + getLabel('Common.encounterid.label','common_labels') + ": " +encID+"</b>";
				if(error!=""){
					error=error+"<br>"+msg1;
				}else{
					error=msg1;
				}
				flag=false;
			}
			if((injuryDate!='' && document.forms[0].trmt_strt_date.value!='')&&!(isBefore(injuryDate,document.forms[0].trmt_strt_date.value,"DMY",localeName))){
				var msg1=getMessage("REMARKS_SHOULD_GR_EQUAL","common");
				msg1=msg1.replace("$",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels')));
				msg1=msg1.replace("#",getLabel('eMR.Injury.label','mr_labels') +" "+getLabel('Common.date.label','common_labels'))+" "+ getLabel('Common.for.label','common_labels') +" <b>" + getLabel('Common.encounterid.label','common_labels') + ": " +encID+"</b>";
				if(error!=""){
					error=error+"<br>"+msg1;
				}else{
					error=msg1;
				}
				flag=false;
			}	
			if((trmtStrtDate!='' &&  document.forms[0].trmt_end_date.value!='')&&!(isBefore(trmtStrtDate,document.forms[0].trmt_end_date.value,"DMY",localeName))){
				var msg1=getMessage("REMARKS_SHOULD_GR_EQUAL","common");
				msg1=msg1.replace("$",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.enddate.label','common_labels')));
				msg1=msg1.replace("#",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels')))+" "+ getLabel('Common.for.label','common_labels') +" <b>" + getLabel('Common.encounterid.label','common_labels') + ": " +encID+"</b>";
				if(error!=""){
					error=error+"<br>"+msg1;
				}else{
					error=msg1;
				}
				flag=false;
			}
			if(error!=""){
				return false;
			}
		});
	}

	//Added  [IN:051068]	
	 if((document.forms[0].trmt_end_date.value!='')&& !isAfter(getCurrentDate("DMY",localeName),convertDate(document.forms[0].trmt_end_date.value,"DMY",localeName),"DMY",localeName)){ 
		var msg1=getMessage("CANNOT_GREATER","MP");
		msg1=msg1.replace("#",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.enddate.label','common_labels')));
		msg1=msg1.replace("$",getLabel('Common.SystemDate.label','common_labels') ); //Added senthil
		if(error!=""){
			error=error+"<br>"+msg1;
		}else{
			error=msg1;
		}
		flag=false;
	}	
	/*if((document.forms[0].enc_date.value!='' && document.forms[0].trmt_strt_date.value!='')&& !(isAfter(convertDate(document.forms[0].trmt_strt_date.value,"DMY","en",localeName),document.forms[0].enc_date.value,"DMY",localeName))){
		var msg1=getMessage("REMARKS_SHOULD_GR_EQUAL","common");
		msg1=msg1.replace("$",(getLabel('Common.Treatment.label','common_labels')+" "+getLabel('Common.StartDate.label','common_labels')));
		msg1=msg1.replace("#",getLabel('Common.encounterdate.label','common_labels') ); //Added senthil
		if(error!=""){
			error=error+"<br>"+msg1;
		}else{
			error=msg1;
		}
		flag=false;
	}*/
	//End [IN:051068]
	
	
	if(flag){
	  //Added Senthil
	  
	  	var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH  trmt_strt_date=\""+document.forms[0].trmt_strt_date.value+"\"  injury_date=\""+document.forms[0].injury_date.value+"\"  encounterID=\""+document.forms[0].encounterID.value+"\" patient_id=\""+document.forms[0].patientid.value+"\" facility_id=\""+document.forms[0].facility_id.value+"\"  steps='Injury'/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","AdverseEventType.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText); 
		eval(responseText) ; 
		var encounter=document.forms[0].status_flag.value;
		var message=getMessage("OVER_LAP_ENC_ID","MR");
		var msg=message+" <"+encounter+">"; 
		//if(document.forms[0].status_flag.value!="N"&& window.confirm(getMessage("OVER_LAP_ENC_ID","MR") )){ 
		if(document.forms[0].status_flag.value!=""&&document.forms[0].status_flag.value!="N"&&window.confirm(msg)){ 
	    parent.frames[1].document.forms[0].submit();
		}else if(document.forms[0].status_flag.value=="N"){
		parent.frames[1].document.forms[0].submit();
		}else{
		document.forms[0].trmt_strt_date.focus();
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp';	//Added [IN:051068]
		}
	  //End
		
	}else{
		parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
		return false;
	}
}


/*Added by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] Start*/

$(document).on('click', "input[name='encAll']", function() {
    // Check if all "encAll" checkboxes are checked
    if ($("input[name='encAll']").length === $("input[name='encAll']:checked").length) {
        $("input[name='selectAll']").prop("checked", true);
    } else {
        $("input[name='selectAll']").prop("checked", false);
    }
});







$(document).on('click', "input[name='encAll']", function() {
    if ($("input[name='encAll']").length === $("input[name='encAll']:checked").length) {
        $("input[name='selectAll']").prop("checked", true);
    } else {
        $("input[name='selectAll']").prop("checked", false);
    }
});

function fnEnableDisableLink(){
	var linkId	= "";
	var checkedEncIds	= "";
	var checkedEncCount	= 0;

	$("input[name='encAll']").filter(':checked').each(function() {
		var pat_encID	=  $(this).val().split("_");
		var patientId	= pat_encID[0];
		var encounterId	= pat_encID[1];
		checkedEncIds	= checkedEncIds	+ encounterId + ",";
		checkedEncCount++;
	});

	checkedEncIds	= checkedEncIds.slice(0,-1);

	$("input[name='encAll']").filter(':checked').each(function() {
		linkId	= "#href_"+$(this).val();
		var pat_encID	=  $(this).val().split("_");;
		var patientId	= pat_encID[0];
		var encounterId	= pat_encID[1];
		$(linkId).attr('disabled', false);
		$(linkId).attr('href', 'javascript:UpdateEncDtlsModal(\''+patientId+'\',\''+encounterId+'\','+checkedEncCount+',\''+checkedEncIds+'\');');
;
	});

	var checkedLength	= $("input[name='encAll']").filter(':checked').length;
	if(checkedLength > 0 ) {
		$("input[name='encAll']").not(':checked').each(function() {
			linkId	= "#href_"+$(this).val();
			$(linkId).attr('disabled', true);
			$(linkId).removeAttr('href');
		});
	}else{
		$("input[name='encAll']").each(function() {
			linkId	= "#href_"+$(this).val();
			var pat_encID	=  $(this).val().split("_");;
			var patientId	= pat_encID[0];
			var encounterId	= pat_encID[1];
			$(linkId).attr('disabled', false);
			$(linkId).attr('href', 'javascript:UpdateEncDtlsModal(\''+patientId+'\',\''+encounterId+'\',"1",\''+encounterId+'\');');
		});
	}


}

/*Added by Dharma on July 21st 2015 against MMS-QH-CRF-0219 [IN:055276] End*/

/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
23/10/2018	IN067402	Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
--------------------------------------------------------------------------------------------------------------------
*/
function selectTannerStaging(obj,obj1,obj2){	
	if(document.forms[0].isAuditYN.value != 'Y'){//IN067402
		for(var i=1;i<=5;i++){
			if(obj1!=i){
				document.getElementById(obj+i).className="Em_box";

		}else{
			document.getElementById(obj+i).className="Em_box_Select";

			if(obj=='SP'){
				document.forms[0].stageOfPuberty.value=obj1;
			}else{
				document.forms[0].pubicHair.value=obj1;
			}
		}			
	}	
	if(obj2==undefined){
		parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.record.disabled="";
		parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.print.disabled="disabled";		
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
	}
    }//IN067402
}
function apply()
{
	var patientSex=document.forms[0].patientSex.value;
	var stageOfPuberty = parent.TannerStagingFrame.document.TannerStagingForm.stageOfPuberty.value;
	var pubicHair = parent.TannerStagingFrame.document.TannerStagingForm.pubicHair.value;	
	var recordingFlag = false;
	var recordingFlag1 = false;
	var errorMessage ="";
		
	if(patientSex=='M'){
		if(stageOfPuberty!="")
			parent.TannerStagingFrame.document.TannerStagingForm.submit();
		else
			alert(getMessage("TENNER_STAGING_PENIS_PUBIC",'CA'));
	}else{
		if(stageOfPuberty!="")
			recordingFlag = true;
		if(pubicHair!="")
			recordingFlag1 = true;
		
		if(recordingFlag && recordingFlag1)
			parent.TannerStagingFrame.document.TannerStagingForm.submit();
		else if (!recordingFlag && recordingFlag1)
			alert(getMessage("TENNER_STAGING_BREAST",'CA'));
		else if (recordingFlag && !recordingFlag1)
			alert(getMessage("TENNER_STAGING_PUBIC",'CA'));
		else if (!recordingFlag && !recordingFlag1)
			alert(getMessage("TENNER_STAGING_BREAST_PUBIC",'CA'));
	}	
}
function reSet(){
	parent.TannerStagingFrame.location.reload();
}
async function printTannerStaging(){
	var patientSex=document.forms[0].patientSex.value;
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var stageOfPuberty = parent.TannerStagingFrame.document.TannerStagingForm.stageOfPuberty.value;
	var pubicHair = parent.TannerStagingFrame.document.TannerStagingForm.pubicHair.value;
	var recorded_date = document.forms[0].recorded_date.value;
	var url;
	if(patientSex=='M')
		url = "../../eCA/jsp/CATannerStagingMalePrint.jsp?";
	else
		url = "../../eCA/jsp/CATannerStagingFemalePrint.jsp?";
//IN067402 starts	
	//var parameters ='patient_id='+patient_id+'&encounter_id='+encounter_id+'&stageOfPuberty='+stageOfPuberty+'&pubicHair='+pubicHair;
	var parameters ='patient_id='+patient_id+'&encounter_id='+encounter_id+'&stageOfPuberty='+stageOfPuberty+'&pubicHair='+pubicHair+'&isAuditYN=Y'+'&recorded_date='+recorded_date;
//IN067402 ends	
	var dialogTop		= "80" ;	
	var dialogHeight	= "730px" ;
	var dialogWidth		= "1300px" ;
	var status			= "no";
	var arguments		= "" ;
	var features		=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=yes; status:" + status;
	
	var retval = await top.window.showModalDialog(url+parameters,arguments,features);	
}
//IN67402 Start
async function ShowAuditTrail(){

		var patient_id = document.forms[0].patient_id.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var patientSex=document.forms[0].patientSex.value;
		var Age=document.forms[0].Age.value;
		var dialogHeight ='730px' ;
		var dialogWidth = '1300px' ;
		var scroll = 'yes';
		var status = 'no';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';scroll=yes; status:' + status;
		var arguments = "";
		var url = '../../eCA/jsp/CATannerStagingFrameset.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&Sex='+patientSex+'&Age='+Age+'';
		
		var retval = await top.window.showModalDialog(url,arguments,features);	
}

function showResult(pubicHair ,stageOfPuberty,recrd_date){
	var patient_id = document.forms[0].patient_id.value;
	var enc_id = document.forms[0].encounter_id.value;
	var sex = document.forms[0].patient_sex.value;
	
	if(sex=="M"){
		parent.TannerStagingFrame.location.href='../../eCA/jsp/CATannerStagingMale.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+recrd_date+'&sex='+sex+'&pubicHair='+pubicHair+'&stageOfPuberty='+stageOfPuberty+'&recordedScoreYN=Y&isAuditYN=Y' ;
		parent.TannerStagingPrintFrm.location.href='../../eCA/jsp/CATannerStagingAuditTrailPrint.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+recrd_date+'&sex='+sex+'&isAuditYN=Y&isPrintEnableYn=Y' ;
	}else{
		parent.TannerStagingFrame.location.href='../../eCA/jsp/CATannerStagingFemale.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+recrd_date+'&sex='+sex+'&pubicHair='+pubicHair+'&stageOfPuberty='+stageOfPuberty+'&recordedScoreYN=Y&isAuditYN=Y' ;
		parent.TannerStagingPrintFrm.location.href='../../eCA/jsp/CATannerStagingAuditTrailPrint.jsp?patient_id='+patient_id+'&encounter_id='+enc_id+'&Recorded_date='+recrd_date+'&sex='+sex+'&isAuditYN=Y&isPrintEnableYn=Y' ;
	}
}

function displayRecordedDetails(obj,obj1,obj2){	
	
		for(var i=1;i<=5;i++){
			if(obj1!=i){
				document.getElementById(obj+i).className="Em_box";

			}else{
				document.getElementById(obj+i).className="Em_box_Select";
				
					if(obj=='SP'){
						document.forms[0].stageOfPuberty.value=obj1;
					}else{
						document.forms[0].pubicHair.value=obj1;
					}
			}			
		}	
		
			if(obj2==undefined){
				parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.record.disabled="";
				parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.print.disabled="disabled";		
				parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp" ;
			}		
}

function populateResult(){
	
		var date_from  = document.forms[0].from_date.value;
		var date_to  = document.forms[0].to_date.value;
		var encounter_id = document.forms[0].encounter_id.value;
		var patient_id = document.forms[0].patient_id.value;
		var sex = document.forms[0].sex.value;	
	
		parent.TannerStagingDetails.location.href='../../eCA/jsp/CATannerStagingAuditDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&date_from='+date_from+'&date_to='+date_to+'&Sex='+sex+'&view_history_yn=Y'+'&isAuditYN=Y';
		
		parent.TannerStagingFrame.location ="../../eCommon/html/blank.html"; 
		parent.TannerStagingPrintFrm.location ="../../eCommon/html/blank.html"; 
}

function isNumeric(obj) {
		var numb = '0123456789';
		var inputparam = obj.value;
		var blnVal = isValid(inputparam,numb);
		if(blnVal == false)
		{
			obj.value = '';
			alert(getMessage("CHARACTER_NOT_ALLOWED",'CA')); 
			obj.focus();
			return blnVal;
		}
		else{
			return blnVal;
		}
}

function isValid(parm,val) {
	if (parm == "")
		return true;
	for (i=0; i<parm.length; i++) {
	if (val.indexOf(parm.charAt(i),0) == -1)
		return false;
	}
	return true;
}

function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	//document.getElementById(str).focus();
	document.getElementById(str).focus();
	return flg;
}
function chkDateTime(toDate,format,locale)
{
	if(toDate.value != '') 
	{		
		var from_date = document.getElementById("from_date");
		var to_date = document.getElementById("to_date")
		if(validDateObj(toDate,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				chkToDate(from_date,to_date,format,locale);
			}
		}
	}
}
function chkToDate(fromDate,toDate,format,locale)
{	
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			fromDate.select();
			fromDate.focus();
			fromDate.value="";
			return false;
				
		}else
		{ 
		  if( toDate.value != "")
			{
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						toDate.select();
						toDate.focus();
						return false;
					}
				}
				else
				  {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					toDate.select();
					toDate.focus();
					return false;
				  }
			}
		}
	}else
	{		
		if((toDate.value!=""))
		{
		  if(!isBeforeNow(toDate.value, format, locale))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				toDate.select();
				toDate.focus();
				return false;
			}
		}
	}
}
//IN67402 Ends

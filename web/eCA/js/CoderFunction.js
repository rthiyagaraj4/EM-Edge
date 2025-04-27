/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	          Name		               Rev.Date		 Rev.Name		        Description
--------------------------------------------------------------------------------------------------------------
16/03/2022       41064             krishna pranay             16/03/2023     Ramesh Goli              AAKH-CRF-0172

---------------------------------------------------------------------------------------------------------------
*/
function callPatientLookup(){
				
			var pat_id =  PatientSearch();
			if(pat_id != null)	
			document.getElementById("p_patient_id").value = pat_id;
			document.getElementById("p_patient_id").focus();
}

function chkDateTime(obj,format,locale,called_from)
{
	var isDaterange ="";
	if(obj.value != '') 
	{		
		var from_date = document.getElementById("dt_from");
		var to_date = document.getElementById("dt_to");
		
		if(validDateObj(obj,format,locale))
		{			
			if(from_date.value != "" || to_date.value != "")
			{
				ftDateCheck(from_date,to_date,format,locale);
			}
		}
		/*if(called_from =="CODER"){
		    isDaterange = dateRangeValidation(from_date, to_date, locale, '31', 'DMY'); 
			if(!isDaterange){
				msgref =getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
				msgref = msgref.replace('$',31);
				alert(msgref); 
				obj.focus();
				return false;
			}
		}else{
			isDaterange = dateRangeValidation(from_date, to_date, locale, '7', 'DMY');
			if(!isDaterange){
				msgref =getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
				msgref = msgref.replace('$',7);
				alert(msgref);
				obj.focus();
				return false;
			}
		}*/ //Commented for AAKH-SCF-0448
	}
}

function ftDateCheck(from,to,format,locale)
{
	
		if(from.value=="" && to.value=="")
		{
			alert("Period can't be empty");
			return;
		}
		if(!(from.value == "" ))
		{
			if(!isBeforeNow(from.value,format,locale))
			{
			
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				from.select();
				from.focus();
				return false;
				
			}
			else
			{ 
				if(!(to.value == "" ))
				{
				   if(isBeforeNow(to.value,format,locale))

				   {
					   if(isAfter(to.value,from.value, format, locale))
					   {
						   return true;
					   }
					   else
					   {
							alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
							to.select();
							to.focus();
							return false;
					   }
				   }
				   else
				   {
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
						to.select();
						to.focus();
						return false;
				   }
				}
			}
			if(!to.value=="")
			{
			 			 
			}
				
		}
		else
		{
			if((!to.value==""))
			{
				if(!isBeforeNow(to.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					to.select();
					to.focus();
					return false;
				}
			}
		}
}

function ChkMaxLen(lab,obj,max) {
	var val = "";
	val = obj.value;
	if(obj.value.length > max){
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",lab);
		msg = msg.replace("#",max);
		alert(msg);
		return false;
		
	}
}

function chkRemarksLength(obj,maxLeng) { 
	if(obj.value.length > maxLeng) {
		val = obj.value;
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label","Common"));
		msg = msg.replace("#",maxLeng);
		obj.value = val.substring(0,maxLeng);
		return false;
	} 
	else 
		return true;
}

function setCheck(obj,value){
	//alert(obj.checked)
	if(obj.checked ==true){
	
	if(value == 'DQ'){
		document.getElementById("doct_qry").checked=true;
		document.getElementById("sup_qry").checked=false;
	    document.getElementById("hold_qry").checked=false;
	    document.getElementById("par_complete").checked=false;
	    document.getElementById("complete").checked=false;
		//document.getElementById("sup_cl_complete").checked=false;//41064 
		document.coderButtons.status.value ="DQ";
	}
	else if(value == 'SQ'){
		document.getElementById("doct_qry").checked=false;
	    document.getElementById("hold_qry").checked=false;
	    document.getElementById("par_complete").checked=false;
	    document.getElementById("complete").checked=false;
		document.getElementById("sup_qry").checked=true;
	//	document.getElementById("sup_cl_complete").checked=false;//41064 
		document.coderButtons.status.value ="SQ";
		
	}
    else if(value == 'HD'){
		document.getElementById("sup_qry").checked=false;
	    document.getElementById("doct_qry").checked=false;
	    document.getElementById("par_complete").checked=false;
	    document.getElementById("complete").checked=false;
		document.getElementById("hold_qry").checked=true;
	//	document.getElementById("sup_cl_complete").checked=false;//41064 
		document.coderButtons.status.value ="HD";
		
	}
	else if(value == 'PC'){
		document.getElementById("sup_qry").checked=false;
	    document.getElementById("hold_qry").checked=false;
	    document.getElementById("doct_qry").checked=false;
	    document.getElementById("complete").checked=false;
		document.getElementById("par_complete").checked=true;
	//	document.getElementById("sup_cl_complete").checked=false;//41064
		document.coderButtons.status.value ="PC";
	}
	else if(value == 'CO'){
		document.getElementById("sup_qry").checked=false;
	    document.getElementById("hold_qry").checked=false;
	    document.getElementById("par_complete").checked=false;
	    document.getElementById("doct_qry").checked=false;
		document.getElementById("complete").checked=true;
	//	document.getElementById("sup_cl_complete").checked=false;//41064
		document.coderButtons.status.value ="CO";
	}//41064 start
	else if(value == 'SC'){
		document.getElementById("sup_qry").checked=false;
	    document.getElementById("hold_qry").checked=false;
	    document.getElementById("par_complete").checked=false;
	    document.getElementById("doct_qry").checked=false;
		document.getElementById("complete").checked=false;
		document.getElementById("sup_cl_complete").checked=true;
		document.coderButtons.status.value ="SC";
	}//41064 end
	else
		document.coderButtons.status.value ="NW";
  }else {

	   if(value =="HD"){
	    document.getElementById("hold_qry").checked=false;
	    document.coderButtons.status.value ="NW";
	  }else if(value =="DQ"){
			document.getElementById("doct_qry").checked=false;
			document.coderButtons.status.value ="NW";
	  }else if(value =="SQ"){
			document.getElementById("sup_qry").checked=false;
			document.coderButtons.status.value ="NW";
	  }
	  else if(value =="PC"){
			document.getElementById("par_complete").checked=false;
			document.coderButtons.status.value ="NW";
	  }
	  else if(value =="CO"){
			document.getElementById("complete").checked=false;
			document.coderButtons.status.value ="NW";
	  }//41064 start
	  else if(value =="SC"){
			document.getElementById("sup_cl_complete").checked=false;
			document.coderButtons.status.value ="NW";
	  }//41064 end
  }
	


}
function apply() {
	document.coderButtons.submit();
}
function onSuccess(){
	frames[1].location.reload();
}

function showRecords(){
	var patient_class = document.coderFunctionCriteria.p_patient_class.value;
	var encounter_id  = document.coderFunctionCriteria.p_encounter.value;
	var patient_id    = document.coderFunctionCriteria.p_patient_id.value;
	var from_date     = document.coderFunctionCriteria.dt_from.value;
	var to_date       = document.coderFunctionCriteria.dt_to.value;
	var status        = document.coderFunctionCriteria.coding_status.value;
	var visit_list    = document.coderFunctionCriteria.view_list_code.value;
	var locale    = document.coderFunctionCriteria.locale.value;//Added for AAKH-SCF-0448
	var isDaterange   =true;//Added for AAKH-SCF-0448
	         if(from_date == "" && to_date == "")
				{
					alert(getMessage("FROM_TO_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(from_date == "")
				{
					alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(to_date == "")
				{
					alert(getMessage("TO_DATE_NOT_BLANK","CA"));
					return;
				}
//Adding start for  AAKH-SCF-0448
isDaterange = dateRangeValidation(document.getElementById("dt_from"), document.getElementById("dt_to"), locale, '31', 'DMY');
	if(!isDaterange){
				msgref =getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
				msgref = msgref.replace('$',31);
				alert(msgref);
				parent.coderSearchResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
				return false;
			}
//Adding end for AAKH-SCF-0448

	parent.coderSearchResultFrame.location.href = "../../eCA/jsp/CACoderFunctionSearchResult.jsp?patient_class="+patient_class+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&status="+status+"&visit_list="+visit_list; 
}

function callCoderFunction(pat_id,enc_id,pat_calss){

    
    document.CoderSearchResult.patient_id.value =pat_id;
	document.CoderSearchResult.encounter_id.value =enc_id;
	document.CoderSearchResult.patient_class.value =pat_calss;
	
	document.CoderSearchResult.submit();
								
}

function clearAll(){
	parent.coderSearchCriteriaFrame.location.reload();
	parent.coderSearchResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
}


function showPendingQueryRecords(){
	var from_date  =document.pendingDocumentationform.dt_from.value;
	var to_date    =document.pendingDocumentationform.dt_to.value;
	var patient_id =document.pendingDocumentationform.p_patient_id.value;
	var function_id =document.pendingDocumentationform.function_id.value;
	var locale    = document.pendingDocumentationform.locale.value;//Added for AAKH-SCF-0448
    var isDaterange = true;//Added for AAKH-SCF-0448
	     if(from_date == "" && to_date == "")
				{
					alert(getMessage("FROM_TO_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(from_date == "")
				{
					alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(to_date == "")
				{
					alert(getMessage("TO_DATE_NOT_BLANK","CA"));
					return;
				}
				//Adding start for AAKH-SCF-0448
   isDaterange = dateRangeValidation(document.getElementById("dt_from"), document.getElementById("dt_to"), locale, '7', 'DMY');
	if(!isDaterange){
				msgref =getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
				msgref = msgref.replace('$',7);
				alert(msgref);
				parent.queryResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
				return false;
			}
//Adding end for AAKH-SCF-0448


	parent.queryResultFrame.location.href = "../../eCA/jsp/CACoderPendingDocQueryResult.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date+"&to_date="+to_date+"&function_id="+function_id; 

}
function clearValues(){
  parent.queryCriteriaFrame.location.reload();

}

function run(){
	
	var  report_id='BLRCODRRPT';
	var  p_module_id='BL';
	var patient_id = document.getElementById("patient_id").value;
    var encounter_id = document.getElementById("encounter_id").value;
    var patient_class = document.getElementById("patient_class").value;
    var facility = document.getElementById("facility_id").value;
    var locale  = document.getElementById("locale").value;
	var report="";//document.getElementById("report").value;
	var server=document.getElementById("server").value;
	var copies=document.getElementById("copies").value;
	var queue_name=document.getElementById("queue_name").value;
	var  message=document.getElementById("message").value;
	var app_server_ip=document.getElementById("app_server_ip").value;
	var rep_server_key=document.getElementById("rep_server_key").value;
	var report_Server=document.getElementById("report_Server").value;
	var desformat=document.getElementById("desformat").value;
	var report_option=document.getElementById("report_option").value;
	var self_submit=document.getElementById("self_submit").value;
	var destype=document.getElementById("destype").value;
	var userid=document.getElementById("userid").value;
	var login_user=document.getElementById("login_user").value;
	var SessionId=document.getElementById("SessionId").value;//V230406 AAKH-CRF-0172
	if(patient_class=='IP')
		patient_class ='I';
	else if( patient_class=='DC')
		patient_class ='D';
	else if(patient_class=='OP')
		patient_class ='O';
	else if(patient_class=='EM')
		patient_class ='E';


	
		window.open(report_Server+"?"+"server="+server+"+"+"report="+report_id+"+"+"P_SESSION_ID="+SessionId+"+"+"desformat="+desformat+"+"+"destype="+destype+"+"+"recursive_load=no"+"+"+"userid="+userid+"+"+"SELF_SUBMIT="+self_submit+"+"+"REPORT_OPTION="+report_option+"+"+"p_patient_id="+patient_id+"+"+"p_user_name="+login_user+"+"+"p_facility_id="+facility+"+"+"p_encounter_id="+encounter_id+"+"+"p_episode_type="+patient_class+"+"+"language_id="+locale+"+"+"P_REPORT_ID="+report_id+"+"+"P_MODULE_ID=" +p_module_id+ "+" + "P_LANGUAGE_ID="+locale)
//V230406	
}

async function showRemarks(patient_id,encounter_id){
	
	
	
	var dialogHeight	= "10" ;
	var dialogWidth	    = "40";
	var dialogTop	    = "270" ;
	
	var status			= "no";
	var scroll			= "no";
	var features	    = "dialogHeight:" + dialogHeight +"; dialogWidth:" + dialogWidth + "; status: " + status + "; dialogTop :" + dialogTop+ ";scroll "+scroll;
	var arguments	    = "";
	retVal          = await window.showModalDialog("../../eCA/jsp/CACoderPendingDocRemarks.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id,arguments,features);
	


}
function callpatientchart(patChartCalledFrm,patient_id,encounter_id,patient_class){

	   document.pendingQueryResult.patient_id.value =patient_id;
	   document.pendingQueryResult.encounter_id.value =encounter_id;
	   document.pendingQueryResult.patient_class.value =encounter_id;
	   document.pendingQueryResult.patChartCalledFrm.value =patChartCalledFrm;

       var HTMLVal = "<html>";
		HTMLVal += "<form name='wrapperForm' id='wrapperForm' action='../../eCA/jsp/OpenChartWrapper.jsp' method='post'>";
		HTMLVal += "<input type='hidden' name=encounter_id value='" + encounter_id + "'>";
		HTMLVal += "<input type='hidden' name=patient_id value='" + patient_id + "'>";			
		HTMLVal += "<input type='hidden' name=patChartCalledFrm value='" + patChartCalledFrm + "'>";			
		HTMLVal += "<input type='hidden' name=patient_class value='" + patient_class + "'>";			
		HTMLVal += "</form>";			
		HTMLVal += "</html>";
		top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		top.content.messageFrame.document.wrapperForm.submit();
}

function chkSelect(cnt){
	if(eval("document.pendingQueryResult.select_"+cnt).checked ==true)
		 eval("document.pendingQueryResult.select_"+cnt).value = "Y";
	else{
		 eval("document.pendingQueryResult.select_"+cnt).value = "N";
	}
}
function record(){
	//alert(parent.forms[1].location);
	   parent.queryResultFrame.document.pendingQueryResult.submit();      
}
function clearChecked(){
	parent.queryResultFrame.location.reload();
}

function showCoderPendingRecords(){
	
	var patient_id    = document.coderPendingSearch.p_patient_id.value;
	var from_date     = document.coderPendingSearch.dt_from.value;
	var to_date       = document.coderPendingSearch.dt_to.value;
	var locale       = document.coderPendingSearch.locale.value;//Added for AAKH-SCF-0448
    var isDaterange   = true;//Added for AAKH-SCF-0448
	      if(from_date == "" && to_date == "")
				{
					alert(getMessage("FROM_TO_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(from_date == "")
				{
					alert(getMessage("FROM_DATE_NOT_BLANK","CA"));
					return;
				}
				else if(to_date == "")
				{
					alert(getMessage("TO_DATE_NOT_BLANK","CA"));
					return;
				}
//Adding start for AAKH-SCF-0448
isDaterange = dateRangeValidation(document.getElementById("dt_from"), document.getElementById("dt_to"), locale, '31', 'DMY');
	if(!isDaterange){
				msgref =getMessage("INVALID_FROM_DISCHARGE_DATE_DAYS","CA");
				msgref = msgref.replace('$',31);
				alert(msgref);
				parent.coderPendingRcordsResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
				return false;
			}
//Adding end for AAKH-SCF-0448
	

	parent.coderPendingRcordsResultFrame.location.href = "../../eCA/jsp/CACoderPendingRecordsSearchResult.jsp?patient_id="+patient_id+"&from_date="+from_date+"&to_date="+to_date; 
}

function clearsearch(){
	parent.coderPendingRcordsCriteriaFrame.location.reload();
	parent.coderPendingRcordsResultFrame.location.href = "../../eCA/jsp/blank.jsp"; 
}

//Added by Kamatchi S for TH-KW-CRF-0143 Start
function generateCoder(){
	var patient_id = document.coderButtons.patient_id.value;
	var facility_id = document.coderButtons.facility_id.value;
	var episode_id = document.coderButtons.episode_id.value;
	var episode_type = document.coderButtons.episode_type.value;
	var visit_Id = document.coderButtons.visit_Id.value;
	var user_id = document.coderButtons.userid.value;
	var patient_class = document.coderButtons.patient_class.value;
	var encounter_id = document.coderButtons.encounter_id.value;
	var coderClearanceStatus = document.coderButtons.coderClearanceStatus.value;
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?patient_id="+patient_id+"&facility_id="+facility_id+"&CalledFor=ipIndicator&episode_id="+episode_id+"&episode_type="+episode_type;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();		
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send("");
		var resp=xmlHttp.responseText;
		resp = trimString(resp);
		var n = resp.indexOf("~");
		var res = resp.substr(n+1);
		res = res.split("~");
		if(((res[0]=="U" || res[0]=="D") && res[0]!= "I" && (episode_type == "I" || episode_type == "D")) || episode_type == "O" || episode_type == "E"){
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?patient_id="+patient_id+"&facility_id="+facility_id+"&CalledFor=generateCoder&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_Id="+visit_Id+"&user_id="+user_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();		
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send("");
		var resText=xmlHttp.responseText;
		resText = trimString(resText);
		var nFin = resText.indexOf("~");
		var resFin = resText.substr(nFin+1);
		resFin = resFin.split("~");
		if(resFin[0]=="S"){
			alert(getMessage('SM2159','BLEXT'));
		}else{
			alert("Error at server end..");
		}
		enableStatus(resFin[2]);
		}
		else{
			alert(getMessage('BL0955','BLEXT'));
			return false;
		}
}

function cancelCoder(){
	var patient_id = document.coderButtons.patient_id.value;
	var facility_id = document.coderButtons.facility_id.value;
	var episode_id = document.coderButtons.episode_id.value;
	var episode_type = document.coderButtons.episode_type.value;
	var visit_Id = document.coderButtons.visit_Id.value;
	var patient_class = document.coderButtons.patient_class.value; 
	var coderClearanceStatus = document.coderButtons.coderClearanceStatus.value;
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?patient_id="+patient_id+"&facility_id="+facility_id+"&CalledFor=ipIndicator&episode_id="+episode_id+"&episode_type="+episode_type;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();		
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send("");
		var resp=xmlHttp.responseText;
		resp = trimString(resp);
		var n = resp.indexOf("~");
		var res = resp.substr(n+1);
		res = res.split("~");
		if(((res[0]=="I" || res[0]=="D") && res[0]!= "U" &&  (episode_type == "I" || episode_type == "D")) || episode_type == "O" || episode_type == "E"){
	var temp_jsp="../../eBL/jsp/BLCoderFunServiceValidations.jsp?patient_id="+patient_id+"&facility_id="+facility_id+"&CalledFor=cancelCoder&episode_id="+episode_id+"&episode_type="+episode_type+"&visit_Id="+visit_Id+"&patient_class="+patient_class;
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();		
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send("");
		var resText=xmlHttp.responseText;
		resText = trimString(resText);
		var nFin = resText.indexOf("~");
		var resFin = resText.substr(nFin+1);
		resFin = resFin.split("~");
		if(resFin[0]=="S"){
			alert(getMessage('SM2159','BLEXT'));
		}else{
			alert("Error at server end..");
		}
		enableStatus(resFin[2]);
		}
		else{
			alert(getMessage('BL0956','BLEXT'));
      return false;
	}
}

function enableStatus(coderClearanceStatus)
{
var siteSpecServiceCode = document.coderButtons.siteSpecServiceCode.value;
if(siteSpecServiceCode == "true"){
if(coderClearanceStatus == null || coderClearanceStatus == 'N' || coderClearanceStatus == "null")
{
	document.getElementById("Generate").disabled = false;
	document.getElementById("Cancel").disabled = true;
}
else
{
	document.getElementById("Generate").disabled = true;
	document.getElementById("Cancel").disabled = false;
}
}
}
//Added by Kamatchi S for TH-KW-CRF-0143 End

//41064 start
function AuditTrail(patient_id,encounter_id,facility,locale)
{
	var dialogHeight= "40" ;
    var dialogWidth = "70" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" ;
	window.showModalDialog("../../eCA/jsp/CACoderFunctionAudit.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility+"&locale="+locale,arguments,features);

}
//41064 end


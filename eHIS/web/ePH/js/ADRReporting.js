var result = false ;
var message = "" ;
var flag = "" ;
var encounter_id="";

function create(){
	f_query_criteria.location.href="../../ePH/jsp/AdrReportingFrames.jsp?type=create&mode=mode_insert";
	//f_query_criteria.f_adrreport_criteria.location.href="../../ePH/jsp/AdrReportingCriteria.jsp";
	//f_query_criteria.f_adrreport_tabdetail.location.href="../../eCommon/html/blank.html";
}

function query(){
	f_query_criteria.location.href="../../ePH/jsp/AdrReportingFrames.jsp?type=query";
	//f_query_criteria.f_adrreport_criteria.location.href="../../ePH/jsp/AdrReportingQueryCriteria.jsp";
	//f_query_criteria.f_adrreport_tabdetail.location.href="../../eCommon/html/blank.html";
}

//To get Patient Details of Name/Age/sex in a single line
function callPatientLin(patient_id){
	patient_id	= document.formAdrReportingCriteria.patient_id.value;
	bean_id		= document.formAdrReportingCriteria.bean_id.value ;
	bean_name	    = document.formAdrReportingCriteria.bean_name.value ;
		
	if(patient_id==""){
		document.formAdrReportingCriteria.patient_name.value="";
		document.formAdrReportingCriteria.drug_search.disabled=true;
		document.formAdrReportingCriteria.suspected_drug.readOnly=false;
		document.formAdrReportingCriteria.patient_name.readOnly=false;
		document.formAdrReportingCriteria.patient_name.value=document.formAdrReportingCriteria.pname.value;
	}
	else{
		document.formAdrReportingCriteria.patient_name.value="";
		document.formAdrReportingCriteria.drug_search.disabled=false;
		document.formAdrReportingCriteria.suspected_drug.disabled=false;
		document.formAdrReportingCriteria.suspected_drug.readOnly=true;
		document.formAdrReportingCriteria.patient_name.readOnly=true;
		callPatientLin1(patient_id,bean_id, bean_name)	
	}
	if(document.formAdrReportingCriteria.pname.value!="")
		document.formAdrReportingCriteria.patient_name.readOnly=true;
}

function callPatientLin1(patient_id,bean_id, bean_name) {
	//	 patient_id			= document.formAdrReportingCriteria.patient_id.value;
		// bean_id		= document.formAdrReportingCriteria.bean_id.value ;
	//	 bean_name	    = document.formAdrReportingCriteria.bean_name.value ;
	if(patient_id=="" && document.formAdrReportingCriteria.patient_id.readonly==false)
		{
		document.formAdrReportingCriteria.patient_name.value="";	
		}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=CALLPATIENT"+"&patient_id=" + patient_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText) ;
	if(patient_id!="")
	    if (document.formAdrReportingCriteria.patient_name.value === "") {
	        alert(getMessage("PH_NOT_VALID_PATIENT", "PH"));
	           document.formAdrReportingCriteria.patient_name.value = "";
	           document.formAdrReportingCriteria.patient_id.focus();
	    }

}

function callWeight(){
	if(document.formAdrReportingCriteria.patient_id.value=="" && document.formAdrReportingCriteria.suspected_drug.value!=""){
		var drug_name1=document.formAdrReportingCriteria.suspected_drug.value;
		var ethnic_grp=document.formAdrReportingCriteria.ethnic_grp.value
		var patient_name=document.formAdrReportingCriteria.patient_name.value
		parent.f_adrreport_tabdetail.location.href="../../ePH/jsp/AdrReportingTabDetail.jsp?ord_id="+ord_id+"&ord_line="+ord_line+"&ethnic_grp="+ethnic_grp+"&patient_name="+patient_name+"&drug_name1="+drug_name1;
	}
	else{
		var frmObject= document.formAdrReportingCriteria;
		
		var ord_id=frmObject.order_id.value;
		var ord_line=frmObject.order_line_no.value;
		var weight=frmObject.weight.value;
		if(weight =='' && ord_id != "" && ord_line != ""){
			 bean_id		= document.formAdrReportingCriteria.bean_id.value ;
			 bean_name	    = document.formAdrReportingCriteria.bean_name.value ;
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=WEIGHT&ord_id=" + ord_id+"&ord_line="+ord_line, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText) ;
		}
	}
}

async function DrugLookup(){
	var frmObj=  document.formAdrReportingCriteria;

	patient_id= frmObj.patient_id.value;
	if(patient_id!=""){
	   // var url     = "ADRReportingDrugLookUp.jsp?patient_id="+patient_id;
		var url     = "ADRReportingDrugLookUpFrames.jsp?patient_id="+patient_id;
		  
		var dialogTop   = "70";
		var dialogHeight    = "400px" ;
		var dialogWidth = "800px" ;
		var DialogLeft="2"
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no;fullscreen=1;" ;

		var retVal=await window.showModalDialog(url,arguments,features);
		if(retVal!=null ) {

			var order_val  =  retVal.split("::");
		
			frmObj.order_id.value = order_val[0];
			frmObj.order_line_no.value = order_val[1];
			frmObj.drug_code.value=order_val[2];
			frmObj.suspected_drug.value = decodeURIComponent(order_val[3],"UTF-8");

			var ord_id = frmObj.order_id.value;
			var ord_line = frmObj.order_line_no.value;
			var drg_code=frmObj.drug_code.value;
			var susp_drug=	frmObj.suspected_drug.value;
			var ethnic_grp = frmObj.ethnic_grp.value;
			frmObj.patient_id.disabled = true;
			frmObj.patient_search.disabled = true;
			// frmObj.suspected_drug.disabled = true;
			frmObj.drug_search.disabled = true;
			parent.f_adrreport_tabdetail.location.href="../../ePH/jsp/AdrReportingTabDetail.jsp?ord_id="+ord_id+"&ord_line="+ord_line+"&susp_drug="+susp_drug+"&patient_id="+patient_id+"&drg_code="+drg_code+"&ethnic_grp="+ethnic_grp;
			//parent.f_adrreport_button.location.href="../../ePH/jsp/AdrReportingButtons.jsp?ord_id="+ord_id+"&ord_line="+ord_line+"&susp_drug="+susp_drug+"&patient_id="+patient_id;
			callWeight();
		}
	}
 }

function loaddrugdetails(patient_id){
    var search_by  = document.formAdrReportingDruglookupSearch.drug_search_by.options[document.formAdrReportingDruglookupSearch.drug_search_by.selectedIndex].value;
	var search_str =document.formAdrReportingDruglookupSearch.txt_drug_desc.value;
	parent.f_drug_details.location.href="../../ePH/jsp/ADRReportingDrugLookUp.jsp?patient_id="+patient_id+"&search_by="+search_by+"&search_str="+encodeURIComponent(search_str);
}

function selectDrug(order_id,order_line_no,drug_code,drug_name){
	/*window.returnValue=order_id+"::"+order_line_no+"::"+drug_code+"::"+drug_name;
	window.close();*/
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = order_id+"::"+order_line_no+"::"+drug_code+"::"+drug_name;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
}

function Display(obj){
	var drugdetail = document.getElementById('DrugDetail_table');
	var adrreport = document.getElementById('ADRReport_table');
	var adversereaction = document.getElementById('AdverseReaction_table');
	var othermedications = document.getElementById('OtherMedications_table');
	var adr_treatment = document.getElementById('Remarks_table');
	var reports = document.getElementById('Report_table');
	var prescription = document.getElementById('Prescription_table');
	var diagnosis = document.getElementById('Diagnosis_table');
	
	if(obj=='DrugDetail'){
		drugdetail.style='display';
		drugdetail.style.visibility='visible';
		prescription.style='display';
		prescription.style.visibility='visible';
		diagnosis.style='display';
		diagnosis.style.visibility='visible';
		adrreport.style.display='none';
		adrreport.style.visibility='hidden';
		adversereaction.style.display='none';
		adversereaction.style.visibility='hidden';
		othermedications.style.display='none';
		othermedications.style.visibility='hidden';
		adr_treatment.style.display='none';
		adr_treatment.style.visibility='hidden';
		reports.style.display='none';
		reports.style.visibility='hidden';
	}
	else if(obj=='ADRReport'){
		drugdetail.style.display='none';
		drugdetail.style.visibility='hidden';
		prescription.style.display='none';
		prescription.style.visibility='hidden';
		diagnosis.style.display='none';
		diagnosis.style.visibility='hidden';
		adrreport.style='display';
		adrreport.style.visibility='visible';
		adversereaction.style='display';
		adversereaction.style.visibility='visible';
		othermedications.style.display='none';
		othermedications.style.visibility='hidden';
		adr_treatment.style.display='none';
		adr_treatment.style.visibility='hidden';
		reports.style.display='none';
		reports.style.visibility='hidden';
	}
	else if(obj=='OtherMedication'){
		drugdetail.style.display='none';
		drugdetail.style.visibility='hidden';
		prescription.style.display='none';
		prescription.style.visibility='hidden';
		diagnosis.style.display='none';
		diagnosis.style.visibility='hidden';
		adrreport.style.display='none';
		adrreport.style.visibility='hidden';
		adversereaction.style.display='none';
		adversereaction.style.visibility='hidden';
		othermedications.style='display';
		othermedications.style.visibility='visible';
		adr_treatment.style.display='none';
		adr_treatment.style.visibility='hidden';
		reports.style.display='none';
		reports.style.visibility='hidden';
	}
	else if(obj=='Remarks'){
		drugdetail.style.display='none';
		drugdetail.style.visibility='hidden';
		prescription.style.display='none';
		prescription.style.visibility='hidden';
		diagnosis.style.display='none';
		diagnosis.style.visibility='hidden';
		adrreport.style.display='none';
		adrreport.style.visibility='hidden';
		adversereaction.style.display='none';
		adversereaction.style.visibility='hidden';
		othermedications.style.display='none';
		othermedications.style.visibility='hidden';
		adr_treatment.style='display';
		adr_treatment.style.visibility='visible';
		reports.style='display';
		reports.style.visibility='visible';
	}
}

function changeButtonColor(obj,from_name){
	if(from_name=="PH_BUTTONS"){
		cellref = document.getElementById('Tabs_Table').rows[0].cells;
	}
	for(i=0; i<cellref.length; i++){
		if(cellref[i].id!="dummy")
			cellref[i].className = 'CAFIRSTSELECTHORZ';
	}
	obj.className = "CASECONDSELECTHORZ"
	currClass ="CASECONDSELECTHORZ";
}

//Patient Search from common.js
async function callPatientLookup(){
	var formObj = parent.f_adrreport_criteria.document.forms[0];
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.patient_id.value = patient_id;
		formObj.patient_id.focus();
     }
}

function reset(){
	f_query_criteria.location.reload();
	clearremarks("RESET");//code added for HSA-CRF-0005[40601]
		//f_query_criteria.f_adrreport_criteria.location.href="../../ePH/jsp/AdrReportingCriteria.jsp";
		//f_query_criteria.f_adrreport_tabdetail.location.href="../../eCommon/html/blank.html";
}

function Clear(){
	var frmObj= parent.parent.f_query_criteria.f_adrreport_criteria.document.formAdrReportingCriteria
	var ord_id = frmObj.order_id.value;
	var ord_line = frmObj.order_line_no.value;
	var drg_code=frmObj.drug_code.value;
	var susp_drug=	frmObj.suspected_drug.value;
	var patient_id= frmObj.patient_id.value;
	parent.parent.f_query_criteria.f_adrreport_tabdetail.location.href="../../ePH/jsp/AdrReportingTabDetail.jsp?ord_id="+ord_id+"&ord_line="+ord_line+"&susp_drug="+susp_drug+"&patient_id="+patient_id+"&drg_code="+drg_code;
}

async function apply(){
	if(f_query_criteria.f_adrreport_tabdetail == undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false;
	}
	var frmObj =f_query_criteria.f_adrreport_tabdetail.document.getElementById("AdrReportingTab_form");
	if(frmObj == null || frmObj == undefined){
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
		return false;
	}

	var tab_drugCode = frmObj.drug_code.value;
	var frmObj1=f_query_criteria.f_adrreport_criteria.document.getElementById("formAdrReportingCriteria");
	var crit_drugCode = frmObj1.drug_code.value;
	//if(frmObj1.mode.value != ""){ //code added for HSA-CRF-0005[40601] --Start
	if(frmObj1.mode.value == "mode_modify"){ //code changed for HSA-CRF-0005[40601] --Start
		var adrStatus	  =	frmObj1.status.value; 
		var canErrorID	  =	frmObj1.canErrorID.value;
		var canErrorDate  =	frmObj1.canErrorDate.value;
		var canRemarks	  =	frmObj1.canRemarks.value;
		var canReason	  =	frmObj1.canReason.value;
    }//code added for HSA-CRF-0005[40601] --End
	
	//frmObj.ethnic_grp.value=frmObj1.ethnic_grp.value;
	var ethnic_grp =frmObj1.ethnic_grp.value;

	var patient_id= frmObj1.patient_id.value;
	// ADDED for [IN:029645]
	var suspected_drug = frmObj1.suspected_drug.value;
	var fields1  = new Array() ;
	var names1   = new Array() ;
	fields1[0]=frmObj1.patient_id;
	fields1[1]=frmObj1.ethnic_grp;
	fields1[2]=frmObj1.suspected_drug;
	names1[0]= getLabel("Common.patientId.label","common");
	names1[1]=getLabel("Common.EthnicGroup.label","Common"); //"Ethnic Group";
	names1[2]=getLabel("ePH.SuspectedDrug.label","PH");
	if((frmObj1.mode.value != "" && adrStatus=="C") || (frmObj1.mode.value != "" && adrStatus=="E")){//code added for HSA-CRF-0005[40601] --Start
			fields1[3]=frmObj1.canRemarks;
		if(adrStatus=="C")	
			names1[3]= getLabel("Common.cancel.label","common")+" "+ getLabel("ePH.Remarks.label","PH");
		else
            names1[3]=getLabel("ePH.InError.label","PH")+" "+  getLabel("ePH.Remarks.label","PH");	
	
		}//code added for HSA-CRF-0005[40601] --End
	if(f_query_criteria.checkFields( fields1, names1, messageFrame)) { // end
		if(!proceedOnApply()){		
			if(crit_drugCode =='' && tab_drugCode != '')
				frmObj1.drug_code.value = tab_drugCode;
			var fields  = new Array() ;
			var names   = new Array() ;
		//	fields[0]=frmObj1.patient_id;
		//	fields[1]=frmObj1.drug_code;
			fields[0]=frmObj.adrType;
			fields[1]=frmObj.OnsetDate;
			fields[2]=frmObj.timeOnset;
			fields[3]=frmObj.OnsetTime;
			fields[4]=frmObj.ExtentReaction;
			fields[5]=frmObj.DrugRelation;
			fields[6]=frmObj.ReportedBy;
			fields[7]=frmObj.VerifiedBy;
			fields[8]=frmObj.DateTime;
			fields[9]=frmObj1.ethnic_grp;
			fields[10]=frmObj1.suspected_drug;
			if(patient_id!=""){
				fields[11]=frmObj1.drug_code;

			}
			fields[12]=frmObj.adminsterDate;//Added for ADR Admin Date Time is not validating[32828]
			//names[0]="Patient ID";
			//names[1]="Drug Code";
			names[0]=getLabel("ePH.ADR.label","PH")   // "ADR Type";
			names[1]=getLabel("Common.OnsetDateTime.label","Common")  //"Onset DateTime";
			names[2]=getLabel("ePH.DurationtoOnsetReaction.label","PH")  //"Duration to Onset Reaction";
			names[3]=getLabel("ePH.DurationtoOnsetReactionType.label","PH")  //"Duration to Onset Reaction Type";
			names[4]=getLabel("ePH.ExtentofReaction.label","PH")  //"Extent of Reaction";
			names[5]=getLabel("ePH.DrugRelation.label","PH")  //"Drug Relation";
			names[6]=getLabel("Common.ReportedBy.label","Common")  //"Reported By";
			names[7]=getLabel("Common.VerifiedBy.label","Common")   //"Verified By";
			names[8]=getLabel("ePH.PreparedDate/Time.label","PH")   //"Prepared Date/Time";
			names[9]=getLabel("Common.EthnicGroup.label","Common")    //"Ethnic Group";
			names[10]=getLabel("ePH.SuspectedDrug.label","PH")    //"Suspected Drug ";

			if(patient_id!=""){
				names[11]=getLabel("Common.DrugCode.label","Common")  //"Drug Code";
			}
			names[12]=getLabel("ePH.AdminDateTime.label","PH")//Added for ADR Admin Date Time is not validating[32828]
			//checkFieldsofMst

			if(f_query_criteria.checkFields( fields, names, messageFrame)) {
				frmObj.weight.value=frmObj1.weight.value;
				frmObj.ethnic_grp.value=frmObj1.ethnic_grp.value;
				frmObj.SignedBy.value=frmObj1.SignedBy.value; //code added for HSA-CRF-0005[40601] --Start   		
				if(adrStatus==null || adrStatus == undefined || adrStatus ==""){
					if(frmObj.SignedBy.value !="")
						adrStatus = "S";
					else		
						adrStatus = "U"; 
					frmObj.canErrorID.value = "";
					frmObj.canErrorDate.value =""; 
					frmObj.canRemarks.value ="";
					frmObj.canReason.value ="";
				} 
				if( adrStatus =="E" ||  adrStatus =="C"){
					frmObj.canErrorID.value=frmObj1.canErrorID.value;
					frmObj.canErrorDate.value=frmObj1.canErrorDate.value;
					frmObj.canReason.value=frmObj1.canReason.value;				
					frmObj.canRemarks.value=decodeURIComponent(frmObj1.canRemarks.value,"UTF-8");
				}
				//code added for HSA-CRF-0005[40601] -- End	
				var retval = "OK";
				if( frmObj1.mode.value =="mode_modify" && adrStatus =="U" ){//code changed for HSA-CRF-0005[40601]
					if(confirm(getMessage("PH_ADR_VERIFY","PH"))){ 
						var dialogTop   = "125";
						var dialogHeight    = "10" ;
						var dialogWidth = "20" ;
						var DialogLeft="15"
						var arguments   = "" ;
						var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no;fullscreen=1;" ;
						
						retval =  await window.showModalDialog("../../ePH/jsp/AdrSignDetail.jsp?",arguments,features);					    
						
						if(retval == "OK")//code added for HSA-CRF-0005[40601]
							adrStatus = "S";//code added for HSA-CRF-0005[40601] 
					}
				}
				
				frmObj.adrStatus.value = adrStatus;	 //code added for HSA-CRF-0005[40601]   			
				//code added for HSA-CRF-0005[40601] Start
				if( frmObj1.mode.value =="mode_modify"){
					frmObj.mode.value="2";
				}
				//eval( formApply( frmObj,PH_CONTROLLER) ) ;
				if(retval == "OK"  ){	
					eval( formApply( frmObj,PH_CONTROLLER) ) ;
				}
				//code added for HSA-CRF-0005[40601] Ends
				if(result){
					//commontoolbarFrame.location.reload();
					if(retval == 'OK'){
						
						var bean_id = frmObj.bean_id.value;
						var bean_name = frmObj.bean_name.value;
						var patient_id = frmObj1.patient_id.value;
						var xmlDoc="";
						var xmlHttp = new XMLHttpRequest();

						xmlStr ="<root><SEARCH " ;
						xmlStr +=" /></root>" ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id="+bean_id + "&bean_name=" + bean_name +"&validate=ONLINEREPORT"+ "&patient_id=" + patient_id+ "&adr_no=" + flag, false ) ;
						xmlHttp.send( xmlDoc ) ;
						responseText=xmlHttp.responseText ;
						//eval(responseText) ;
					}	
					var homePage = frmObj1.homepage.value; //added for  Bru-HIMS-CRF-073.1 [IN:047222]
					if(homePage=='Y'){  //added for  Bru-HIMS-CRF-073.1 [IN:047222]
						
						parent.menuFrame.document.location.reload();
					}
				
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message+"\n ADR No: <b><label style='font-size:18'>"+flag+"</label></b>";
					//commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?menu_id=PH&module_id=PH&function_id=PH_ADR_REP&function_name=Adverse%20Drug%20Reaction&function_type=F&access=YYYNN&desktopFlag=N"
					f_query_criteria.f_adrreport_criteria.location.href="../../ePH/jsp/AdrReportingCriteria.jsp";
					f_query_criteria.f_adrreport_tabdetail.location.href="../../eCommon/html/blank.html";
					
				}
				else{
					//commontoolbarFrame.location.reload();
					//href = "../../eCommon/jsp/CommonToolbar.jsp?";
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+message;
				}
			}
			/*else{
				//commontoolbarFrame.location.reload();
			} */
		}	
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function proceedOnApply() {
    var url = f_query_criteria.location.href;
	var result;
    url = url.toLowerCase();

	if (url.indexOf("blank.html")!=-1)
		result	= true;
	else
		result	=	false;

	return result;
}

function assignPatientLine(p_name,p_age,p_sex){
	
	document.getElementById('patient_name').value =p_name+" / "+p_age+" / " +p_sex;
}

function assignWeight(weight){
	document.formAdrReportingCriteria.weight.value=weight;
}

function CheckVal(){
	var frmObj			= document.formAdrReportingCriteria;
	var frmObjFacility		= frmObj.ref_facility;
	var frmObjOthFacility	= frmObj.other_facility;
	var objFacVal			= frmObjFacility.value;
	var objOthFacVal		= frmObjOthFacility.value;
	if(objOthFacVal != null && objOthFacVal != "")
	{
		frmObjFacility.value = "";
		objFacVal			= frmObjFacility.value;
	}

	if(objFacVal != null && objFacVal != "")
		frmObj.other_facility.disabled = true;
	else
		frmObj.other_facility.disabled = false;
}

function callCheckMaxLen(obj,noOfChars,Legend){
	var err_num="";
	makeValidString(obj);
	if(trimCheck(obj.value)==""){
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";		
		return false;
	}
	if(obj.value.length > noOfChars){
		var msg="";
		msg="APP-SM0045-"+ Legend + getLabel("ePH.Cannotexceed.label","PH") + noOfChars  + getLabel("ePH.characters.label","PH");
		alert(msg);
			//parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-SM0045 - " + Legend + " cannot exceed " + noOfChars  + " characters" ;
		obj.focus();
	}
	else{		
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		return true;
	}
}

async function searchUserNames( target ){
	var frmObj = document.AdrReportingTab_form;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var sql="SELECT  A.APPL_USER_ID CODE, A.APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER_LANG_VW A, AM_PRACTITIONER_LANG_VW B WHERE A.FUNC_ROLE IS NOT NULL AND A.FUNC_ROLE = 'P' AND A.FUNC_ROLE_ID IS NOT NULL AND A.FUNC_ROLE_ID=B.PRACTITIONER_ID AND B.EFF_STATUS='E' AND A.EFF_STATUS='E' AND A.APPL_USER_ID LIKE UPPER(?) AND UPPER(A.APPL_USER_NAME) LIKE UPPER(?) AND B.LANGUAGE_ID = A.LANGUAGE_ID AND A.LANGUAGE_ID = " ; 
	var language_id=document.AdrReportingTab_form.locale.value;
	argumentArray[0] = sql+"'"+language_id+"'"+" ORDER BY 2";
//	argumentArray[0] = document.getElementById("SQL_PH_DISP_RIGHTS_SELECT1").value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray =await CommonLookup(getLabel("Common.SearchUser.label","Common"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" ){
		frmObj.VerifiedBy.value = arr[1];
	//	formObj.user_code.value = retArray[0]; /* if code need to be returned */
        	frmObj.user_search.disabled=true;
	}
	else{
		target.value = "";
		target.focus();
	}
}

function checkUser(objVal) {
	if (objVal == ""){
		document.AdrReportingTab_form.VerifiedBy.disabled=false;
	}
	else{
		searchUserNames(document.AdrReportingTab_form.VerifiedBy);
	}
}

function loadDetails(obj,patid,orderid,orderline){
	bean_id		= document.AdrReportingTab_form.bean_id.value ;
	bean_name	    = document.AdrReportingTab_form.bean_name.value ;
	var administeredDate=obj.value;
			
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=DOSAGEDETAILS&patient_id="+patid+"&orderId="+orderid+"&orderline="+orderline+"&administeredDate="+administeredDate, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText) ;
}

function displayDosageDetails(data,index){
	if(data == 'null') data = "";
	var frmObj = document.AdrReportingTab_form;
	if(index==0){
		document.getElementById('lbladminBy').innerHTML="<label><B>"+data+"</B></label>";
		frmObj.administeredBy.value=data;
	}
	else if(index==1){
		document.getElementById('lblbatchId').innerHTML="<label><B>"+data+"</B></label>";
		frmObj.batchID.value=data;
	}
	else if(index==2){
		document.getElementById('lblexpiryDate').innerHTML="<label><B>"+convertDate(data,"DMY","en",frmObj.locale.value)+"</B></label>";
		frmObj.expiryDate.value=data;
	}
	else if(index==3){
		document.getElementById('lblmanufacturer').innerHTML="<label><B>"+data+"</B></label>";
		frmObj.manufacturerName.value=data;
	}
}
function validateAdmintime(obj){
	//	var adminDate=obj.value;
	var formObj = document.AdrReportingTab_form;
	if (formObj.startDate.value!="" && formObj.endDate.value!="" && obj.value!=""){
		if(obj.value != ""){
			if(!doDateTimeChk(obj) ){
				alert(getMessage("INVALID_DATE_TIME","PH"));
				obj.value="";
				obj.focus();//Added for ADR Admin Date Time is not validating[32828]
				return false;
			}
		}
 
		if(!ValidateDateTime(obj,formObj.startDate)){
			if(ValidateDateTime(formObj.endDate,obj)){
				alert(getMessage("PH_ADR_ADMIN_START","PH"));
				obj.value="";
				obj.focus();
				return false;
			}
		}
		else{
			alert(getMessage("PH_ADR_ADMIN_END","PH"));
			obj.value="";
			obj.focus();
			return false;

		}
	}
}

function validateDate(){
	var formObj = document.AdrReportingTab_form;
	var locale = formObj.locale.value;
	var date1= new Date();
	var s = date1.getDate() + "/";
	s += (date1.getMonth() + 1) + "/";
	s += date1.getYear() +" ";
	s	+=date1.getHours()+":";
	s +=date1.getMinutes();
	
	
	/* Below code Added for ADR Admin Date Time is not validating[32828] */
	if(formObj.OnsetDate.value != ""){	
		if(!doDateTimeChk(formObj.OnsetDate.value) ){
			alert(getMessage("INVALID_DATE_TIME","PH"));			
			formObj.OnsetDate.focus();
		}
	}
	/* Above code added for Admin Date Time is not validating[32828] */		
	//	formObj.curDate.value=s;
	formObj.curDate.value=convertDate(s,'DMYHM',"en",locale);

	if (formObj.OnsetDate.value!="" && formObj.adminsterDate.value!=""){
		//if(!ValidateDateTime(formObj.OnsetDate,formObj.adminsterDate))
		if(isAfter(formObj.OnsetDate.value,formObj.adminsterDate.value,"DMYHM",locale)){
			if(isAfter(formObj.curDate.value,formObj.OnsetDate.value,"DMYHM",locale)){
				var administeredDate = formObj.adminsterDate.value;
				var onsetDate=formObj.OnsetDate.value;
				bean_id		= document.AdrReportingTab_form.bean_id.value ;
				bean_name	    = document.AdrReportingTab_form.bean_name.value ;
  				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();

				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=ONSETREACTION&administeredDate="+administeredDate+"&onSetDate="+onsetDate, false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText) ;
			}
			else{
				alert(getMessage("PH_ADR_ONSET_SYS","PH"));
				formObj.OnsetDate.value="";
				formObj.OnsetDate.focus();
			}
		}
		else{
			alert(getMessage("PH_ADR_ONSET_ADMIN","PH"));
			formObj.OnsetDate.value="";
			formObj.OnsetDate.focus();
		}
	}
}

function chkexpiryDate(){
	var formObj = document.AdrReportingTab_form;

	var expDate = formObj.expiryDate.value;
	var adminDate = (formObj.adminsterDate.value).substring(0,10);
	var adminArray; var expArray;

	if (expDate!="" && adminDate !=""){
		if(adminDate.length > 0 && expDate.length > 0 ) {
            adminArray = adminDate.split("/");
            expArray = expDate.split("/");
            var admindt = new Date(adminArray[2],adminArray[1]-1,adminArray[0]);
            var expdt = new Date(expArray[2],expArray[1]-1,expArray[0]);
            if(Date.parse(expdt) < Date.parse(admindt)) {
				alert(getMessage("PH_ADR_ADMIN_EXP","PH"));
				formObj.expiryDate.value="";
				formObj.expiryDate.focus();
            }

	    }
	}
}

function setOnsetDate(){
	var formObj = document.AdrReportingTab_form;
	
	var onsetvalue=formObj.timeOnset.value;
	var onsettimetype=formObj.OnsetTime.value;
	var adminsterDate = formObj.adminsterDate.value;
	if(onsettimetype!=""){
		bean_id		= document.AdrReportingTab_form.bean_id.value ;
		bean_name	    = document.AdrReportingTab_form.bean_name.value ;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=ONSETDATE&onsetvalue="+onsetvalue+"&onsettimetype="+onsettimetype+"&adminsterDate="+adminsterDate, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText) ;
		validateDate();
	}	
}
function displayOnsetValue(onsetvalue){

	var formObj = document.AdrReportingTab_form;
	var value=new Array();
	onsetvalue1=trimString(onsetvalue);
	value=onsetvalue1.split("|");
	formObj.timeOnset.value=value[0];
	//formObj.timeOnset.disabled=true;
	clearData(formObj.OnsetTime);
	if(value[1]=='MINUTE' || value[1]=='MINUTES'){
		addData(formObj.OnsetTime,'','--'+getLabel("Common.defaultSelect.label","Common")+'--',0)
		addData(formObj.OnsetTime,'M',getLabel("Common.Minutes.label","Common"),1)
		addData(formObj.OnsetTime,'H',getLabel("Common.hours.label","Common"),0)
		addData(formObj.OnsetTime,'D',getLabel("Common.days.label","Common"),0)
	}
	
	else if(value[1]=='HOUR' || value[1]=='HOURS'){
		addData(formObj.OnsetTime,'','--'+getLabel("Common.defaultSelect.label","Common")+'--',0)
		addData(formObj.OnsetTime,'M',getLabel("Common.Minutes.label","Common"),0)
		addData(formObj.OnsetTime,'H',getLabel("Common.hours.label","Common"),1)
		addData(formObj.OnsetTime,'D',getLabel("Common.days.label","Common"),0)
	}
		
	else if(value[1]=='DAY' || value[1]=='DAYS'){
		addData(formObj.OnsetTime,'','--'+getLabel("Common.defaultSelect.label","Common")+'--',0)
		addData(formObj.OnsetTime,'M',getLabel("Common.Minutes.label","Common"),0)
		addData(formObj.OnsetTime,'H',getLabel("Common.hours.label","Common"),0)
		addData(formObj.OnsetTime,'D',getLabel("Common.days.label","Common"),1)
	}
	//	formObj.OnsetTime.disabled=true;
}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
}

function addData(obj,type,name,flag) {
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.value =	trimString(type);
	opt.text =name ;
	obj.add(opt);
	if(flag==1)
		opt.selected="selected";
}

function displayOnsetDate(value){

	if(value == "null") value = "";
	var formObj = document.AdrReportingTab_form;
	formObj.OnsetDate.value=value;
	//formObj.OnsetDate.disabled=true;
}

function beforePost(xmlStr){
	//alert("In ADDReporting js:"+xmlStr)
}

function assignValue(obj){
	if(obj.checked==true){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
}

function setSignedBy(Signed_By,Date_Time,bean_id,bean_name){
	var SignedBy = Signed_By.value;
	var DateTime = Date_Time.value;
	if(SignedBy!=""){	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();

		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name +"&validate=SETSIGNEDBYVALUES&SignedBy="+SignedBy+"&DateTime="+DateTime, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
	//	eval(responseText) ;
		parent.document.getElementById('dialog-body').contentWindow.returnValue = 'OK'; parent.document.getElementById('dialog_tag').close();
	}
	else{
		msg = getMessage('CAN_NOT_BE_BLANK','Common');
		msg= msg.replace('$',getLabel("ePH.SignedBy.label","PH"));
		alert(msg);
		parent.document.getElementById('dialog-body').contentWindow.returnValue = 'CANCEL';
		return false;
	}
}

async function searchUserNames1( target ){
	
	var frmObj = document.AdrReportingSignedBy;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var sql="SELECT  A.APPL_USER_ID CODE, A.APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER_LANG_VW A, AM_PRACTITIONER_LANG_VW B WHERE A.FUNC_ROLE IS NOT NULL AND A.FUNC_ROLE = 'P' AND A.FUNC_ROLE_ID IS NOT NULL AND A.FUNC_ROLE_ID=B.PRACTITIONER_ID AND B.EFF_STATUS='E' AND A.EFF_STATUS='E' AND A.APPL_USER_ID LIKE UPPER(?) AND UPPER(A.APPL_USER_NAME) LIKE UPPER(?) AND B.LANGUAGE_ID = A.LANGUAGE_ID AND A.LANGUAGE_ID = " ; 
	var language_id=document.AdrReportingSignedBy.locale.value;
	//argumentArray[0] = document.getElementById("SQL_PH_DISP_RIGHTS_SELECT1").value;
	argumentArray[0] = sql+"'"+language_id+"'"+" ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] =frmObj.SignedBy_1.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray =await CommonLookup(getLabel("Common.SearchUser.label","Common"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" ){
		frmObj.SignedBy_1.value = arr[1];
		frmObj.SignedBy.value = arr[0];
	//	formObj.user_code.value = retArray[0]; /* if code need to be returned */
    	//frmObj.user_search.disabled=true;//code commented for HSA-CRF-0005[40601]
	}
	else{
		frmObj.SignedBy_1.focus();
	}
}

function checkUser1(objVal){
	if (objVal == ""){
		document.AdrReportingSignedBy.SignedBy_1.disabled=false;
	}
	else{
		searchUserNames1(document.AdrReportingSignedBy.SignedBy_1);
	}
}

/* function checkUser2(objVal,mode){ //Function commented  for HSA-CRF-0005[40601] -- Start
	if(mode == "1"){
		if (objVal == ""){
			document.formAdrReportingQueryCriteria.ReportedBy.disabled=false;
		}
		else{
			searchUserNames2(document.formAdrReportingQueryCriteria.ReportedBy,mode);
		}
	}
	else if(mode == "2"){
		if (objVal == ""){
			document.formAdrReportingQueryCriteria.SignedBy_1.disabled=false;
		}
		else {
			searchUserNames2(document.formAdrReportingQueryCriteria.SignedBy_1,mode);
		}
	}
}  */ //Function commented  for HSA-CRF-0005[40601] -- End

async function searchUserNames2( target,mode ){
	var frmObj = document.formAdrReportingQueryCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var sql="SELECT  A.APPL_USER_ID CODE, A.APPL_USER_NAME DESCRIPTION FROM SM_APPL_USER_LANG_VW A, AM_PRACTITIONER_LANG_VW B WHERE A.FUNC_ROLE IS NOT NULL AND A.FUNC_ROLE = 'P' AND A.FUNC_ROLE_ID IS NOT NULL AND A.FUNC_ROLE_ID=B.PRACTITIONER_ID AND B.EFF_STATUS='E' AND A.EFF_STATUS='E' AND A.APPL_USER_ID LIKE UPPER(?) AND UPPER(A.APPL_USER_NAME) LIKE UPPER(?) AND B.LANGUAGE_ID = A.LANGUAGE_ID AND A.LANGUAGE_ID = " ; 
	var language_id=document.formAdrReportingQueryCriteria.p_language_id.value;

//	argumentArray[0] = document.getElementById("SQL_PH_DISP_RIGHTS_SELECT1").value;
	argumentArray[0] = sql+"'"+language_id+"'"+" ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;

	retArray = await CommonLookup(getLabel("Common.SearchUser.label","Common"), argumentArray );

	if(retArray != null && retArray != "" ){
        var ret1=unescape(retArray);
		var arr=ret1.split(",");
		if(mode == "1"){
			frmObj.ReportedBy.value = arr[1];
			frmObj.ReportedBy_id.value = arr[0]; //code added for HSA-CRF-0005[40601]  
	        //frmObj.rprtby_search.disabled=true; //code commented  for HSA-CRF-0005[40601] -- 
		}
		else if(mode == "2"){
			frmObj.SignedBy_1.value = arr[1];
			frmObj.SignedBy.value = arr[0];
	      //  frmObj.sgndby_search.disabled=true;//code commented  for HSA-CRF-0005[40601] -- 
		}
	}
	else{
		target.value = "";
		target.focus();
	}
}

function showResult(){
	var formObj = document.formAdrReportingQueryCriteria;
	var adr_reported_date="";
	var adr_reported_date1 ="";
	var patient_id = formObj.patient_id.value;
	var locale = formObj.locale.value;
	var adr_no = formObj.adr_no.value;
	adr_reported_date = formObj.adr_reported_date.value;
	adr_reported_date=convertDate(adr_reported_date,"DMY",locale); 
	adr_reported_date1 = formObj.adr_reported_date1.value;
	adr_reported_date1=convertDate(adr_reported_date1,"DMY",locale); 
	var ReportedBy = formObj.ReportedBy_id.value; //code 'ReportedBy' is replaced by 'ReportedBy_1'  for HSA-CRF-0005[40601] 
	var SignedBy = formObj.SignedBy.value;
	var drug_code = formObj.drug_code.value;		
	if(ReportedBy=="") //code added for HSA-CRF-0005[40601] -- Start 
		ReportedBy = formObj.ReportedBy.value;
	if(SignedBy=="")
		SignedBy = formObj.SignedBy_1.value;
	if(drug_code=="")	
		drug_code = formObj.suspected_drug.value; //code added for HSA-CRF-0005[40601] -- End		
	var type = formObj.type.value;
	var status = formObj.status.value;
 
	var fields = new Array (formObj.adr_reported_date,formObj.adr_reported_date1);
	var names= new Array (getLabel("ePH.ADRReportingFromDate.label","PH"), getLabel("ePH.ADRReportingToDate.label","PH"));
	/* below code added for ADR Admin Date Time is not validating[32828] --Start  */
	var current_date = formObj.current_dat.value;
	if(formObj.adr_reported_date.value != ""){	
		if( !DateCheck(formObj.adr_reported_date,current_date,locale))
			return false;			
	}
	/*code added for ADR Admin Date Time is not validating[32828] --End */
	if(checkFields(fields,names,parent.parent.messageFrame)){
		if(doDateCheck(formObj.adr_reported_date,formObj.adr_reported_date1,parent.parent.messageFrame) )	{//This condition Added for ADR Admin Date Time is not validating[32828]
			parent.f_adrreport_tabdetail.location.href="../../ePH/jsp/AdrReportingQueryResult.jsp?patient_id="+patient_id+"&adr_no="+adr_no+"&adr_reported_date="+adr_reported_date+"&adr_reported_date1="+adr_reported_date1+"&ReportedBy="+ReportedBy+"&SignedBy="+SignedBy+"&drug_code="+drug_code+"&type="+type+"&status="+status;
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
		}				
	}
}

async function DrugLookupQuery(){
	var frmObj=  document.formAdrReportingQueryCriteria;
	if(frmObj.summaryRprt.value == "N" && frmObj.patient_id.value != ""){
		
		patient_id= frmObj.patient_id.value;
		var search_by = frmObj.status.value;
		var url     = "ADRReportingDrugLookUp.jsp?patient_id="+patient_id+"&search_by="+search_by;
		  
		var dialogTop   = "10px";
		var dialogHeight    = "400px" ;
		var dialogWidth = "700px" ;
		var DialogLeft="2px"
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no;fullscreen=1;" ;
	
		var retVal=await window.showModalDialog(url,arguments,features);
		if(retVal!=null ) {
 
			 var order_val  =  retVal.split("::");
		
			 frmObj.order_id.value = order_val[0];
			 frmObj.order_line_no.value = order_val[1];
			 frmObj.drug_code.value=order_val[2];
			 frmObj.p_drug_code.value=order_val[2];
			 frmObj.suspected_drug.value=order_val[3];


			 var ord_id = frmObj.order_id.value;
			 var ord_line = frmObj.order_line_no.value;
			 var drg_code=frmObj.drug_code.value;
			 var susp_drug=	frmObj.suspected_drug.value;
		
			 frmObj.patient_id.disabled = true;
			 frmObj.patient_search.disabled = true;
			// frmObj.suspected_drug.disabled = true;
			 frmObj.drug_search.disabled = true;
		}
	}
	else if((frmObj.summaryRprt.value == "Y" || frmObj.summaryRprt.value == "N") && frmObj.patient_id.value == ""){
		var language_id=document.formAdrReportingQueryCriteria.locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		argumentArray[0]   = document.formAdrReportingQueryCriteria.sql_ph_drug_search_select2.value+"'"+language_id+"'";
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = frmObj.suspected_drug.value ;
		argumentArray[6]   = DESC_LINK ;
		argumentArray[7]   = DESC_CODE ; 
		retVal=await CommonLookup(getLabel("Common.DrugName.label","Common"), argumentArray );
		if(retVal != null && retVal != "" )  {
			
			//var order_val  =  retVal.split(",");
		
//				 frmObj.order_id.value = order_val[0];
//				 frmObj.order_line_no.value = order_val[1];
             var ret1=unescape(retVal);
			 var arr=ret1.split(",");
			 if(arr[1]==undefined) 
				{
		 		arr[0]="";	
		 		arr[1]="";	
				}
			 
			 frmObj.p_drug_code.value=arr[0];
			 frmObj.drug_code.value=arr[0];
			 frmObj.suspected_drug.value=arr[1];
	

//				 var ord_id = frmObj.order_id.value;
//				 var ord_line = frmObj.order_line_no.value;
			 var drg_code=frmObj.drug_code.value;
			 var susp_drug=	frmObj.suspected_drug.value;
		     target.value= susp_drug;
		//	 frmObj.patient_id.disabled = true;
		//	 frmObj.patient_search.disabled = true;
			// frmObj.suspected_drug.disabled = true;
		//	 frmObj.drug_search.disabled = true;


		/*	formObj.drug_name.value = retVal[1] ;
			formObj.drug_code.value = retVal[0];
			
			formObj.drug_name.disabled  = true;
			formObj.drug_name_search.disabled = true;

			formObj.generic_name.value = "";
			formObj.generic_id.value = "";
			
			formObj.generic_name.disabled  = false;
			formObj.generic_name_search.disabled = false;
		*/
		}
	}
 }

function showADR(adr_no,ptnt_id,drugDisc,sgndBy,weight,ord_id,ord_line,drug_code,ethnic_grp,patient_name,facility_id,adrStatus,sign_by_id){ //code 'adrStatus,sign_by_id' added for  HSA-CRF-0005[40601]
	if(adr_no != ""){		
		if(parent.f_adrreport_criteria !=null){	  
			parent.location.href="../../ePH/jsp/AdrReportingFrames.jsp?type=create"+"&adr_no="+adr_no+"&ptnt_id="+ptnt_id+"&drugDisc="+escape(drugDisc)+"&sgndBy="+sgndBy+"&weight="+weight+"&ord_id="+ord_id+"&ord_line="+ord_line+"&drug_code="+drug_code+"&mode=mode_modify&ethnic_grp="+ethnic_grp+"&patient_name="+patient_name+"&facility_id="+facility_id+"&adrStatus="+adrStatus+"&sign_by_id="+sign_by_id;	//facility_id  added for 33963 and code 'adrStatus,sign_by_id' added for  HSA-CRF-0005[40601]						    
		}
		else{
			//parent.f_adrreport_tabdetail_1.location.href="../../ePH/jsp/AdrReportingTabDetail.jsp?type=mode_modify"+"&patient_id="+ptnt_id+"&ord_id="+ord_id+"&ord_line="+ord_line+"&mode=mode_modify"+"&adr_no="+adr_no+"&called_frm=Prescription"+"&patient_name="+patient_name;      
			parent.f_adrreport_tabdetail_1.location.href="../../ePH/jsp/AdrReportingTabDetail.jsp?type=mode_modify"+"&patient_id="+ptnt_id+"&ord_id="+ord_id+"&ord_line="+ord_line+"&mode=mode_modify"+"&adr_no="+adr_no+"&called_frm=Prescription"+"&patient_name="+patient_name+"&facility_id="+facility_id;  //facility_id  added for added for 33963								    

		}	
	}
}

function showReport(adr_no,ptnt_id){
	parent.f_adrreport_criteria.document.formAdrReportingQueryCriteria.p_patient_id.value = ptnt_id;
	parent.f_adrreport_criteria.document.formAdrReportingQueryCriteria.p_adr_no.value = adr_no;
	parent.f_adrreport_criteria.document.formAdrReportingQueryCriteria.action="../../eCommon/jsp/report_options.jsp";
	parent.f_adrreport_criteria.document.formAdrReportingQueryCriteria.submit();
	parent.f_adrreport_tabdetail.location.href="../../eCommon/html/blank.html";
	
}

function disableSign(obj){
	if(obj.value == "S" || obj.value == "E" || obj.value == "A"){ // code 'obj.value == "I"' added for HSA-CRF-0005[40601] 
		//document.formAdrReportingQueryCriteria.SignedBy.value = '';
		document.formAdrReportingQueryCriteria.SignedBy_1.disabled = false; // code 'SignedBy' is replaced by 'SignedBy_1' & 'true' is replaced by 'false' for HSA-CRF-0005[40601]
		document.formAdrReportingQueryCriteria.sgndby_search.disabled = false;// code 'SignedBy' is replaced by 'SignedBy_1' & 'true' is replaced by 'false' for HSA-CRF-0005[40601]
	}
	else{
		document.formAdrReportingQueryCriteria.SignedBy_1.value = '';// code 'SignedBy' is replaced by 'SignedBy_1' for HSA-CRF-0005[40601]
		document.formAdrReportingQueryCriteria.SignedBy_1.disabled = true;// code 'SignedBy' is replaced by 'SignedBy_1' for HSA-CRF-0005[40601]
		document.formAdrReportingQueryCriteria.sgndby_search.disabled = true;
		//document.formAdrReportingQueryCriteria.patient_search.disabled = true;
		//document.formAdrReportingQueryCriteria.drug_search.disabled = true;
		//	document.formAdrReportingQueryCriteria.rprtby_search.disabled = true;
	}
}

function summaryReport(obj){
	if(obj.checked){
		parent.parent.frames[0].document.forms[0].run.disabled = false;
		document.formAdrReportingQueryCriteria.search.disabled = true;
		document.formAdrReportingQueryCriteria.patient_id.value = "";
		document.formAdrReportingQueryCriteria.patient_id.disabled = true;
		document.formAdrReportingQueryCriteria.patient_search.disabled = true;
		document.formAdrReportingQueryCriteria.summaryRprt.value = "Y";
		document.formAdrReportingQueryCriteria.adr_no.value = "";
		document.formAdrReportingQueryCriteria.adr_no.disabled = true;
		document.formAdrReportingQueryCriteria.ReportedBy.disabled = true;
		document.formAdrReportingQueryCriteria.rprtby_search.disabled = true;
		document.formAdrReportingQueryCriteria.status.disabled = true;
		document.formAdrReportingQueryCriteria.drug_search.disabled = false;
	}
	else{
		parent.parent.frames[0].document.forms[0].run.disabled = true;
		document.formAdrReportingQueryCriteria.search.disabled = false;
		document.formAdrReportingQueryCriteria.patient_id.disabled = false;
		document.formAdrReportingQueryCriteria.patient_search.disabled = false;
		document.formAdrReportingQueryCriteria.summaryRprt.value = "N";
		document.formAdrReportingQueryCriteria.adr_no.disabled = false;
		document.formAdrReportingQueryCriteria.ReportedBy.disabled = false;
		document.formAdrReportingQueryCriteria.rprtby_search.disabled = false;
		document.formAdrReportingQueryCriteria.status.disabled = false;
	}
}

function run(){
	f_query_criteria.f_adrreport_criteria.document.formAdrReportingQueryCriteria.action="../../eCommon/jsp/report_options.jsp";
	var frmObject = f_query_criteria.f_adrreport_criteria.formAdrReportingQueryCriteria;
	var fields = new Array (frmObject.adr_reported_date,frmObject.adr_reported_date1);
	var names= new Array (getLabel("ePH.ADRReportingFromDate.label","PH"), getLabel("ePH.ADRReportingToDate.label","PH"));

	if(f_query_criteria.checkFields(fields,names,messageFrame)){
		frmObject.p_report_id.value = "PHADRSUMMARY";
		frmObject.p_date_fm.value = convertDate(frmObject.adr_reported_date.value,'DMY',frmObject.locale.value,'en');
		//frmObject.p_date_fm.value= frmObject.adr_reported_date.value;
		frmObject.p_date_to.value =convertDate(frmObject.adr_reported_date1.value,'DMY',frmObject.locale.value,'en'); 
		//frmObject.p_date_to.value =frmObject.adr_reported_date1.value;
		frmObject.suspected_drug.value = escape(frmObject.suspected_drug.value);
		frmObject.submit();
	}
	reset();	
}

async function callActive(patient_id){
	var function_id		= "";
	var no_of_items		= "";
	var option_type		= "";
	var module_id		= "PH";

	if(module_id=="PH"){   //Used only For Pharmacy Orders
		 function_id	= "PH";
		 no_of_items 	= "3";
		 option_type	= "ACTIVE";
	}
	var query_string	= "patient_id="+patient_id+"&P_function_id="+function_id+"&P_no_of_items="+no_of_items+"&P_option_type="+option_type
	var retVal 			= new String();
	var dialogHeight	= "80vh" ;
	var dialogWidth		= "80vw" ;
	var dialogTop    	= "10";
		
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);

	if(module_id=="PH" && retVal!=null){
		//Call the PH Js Function (internally will call the jsp and set it into the bean), which will be in PH MOdule
		callActiveProblems1(patient_id,encounter_id,retVal); //(in ePH/js/Prescription.js)
	}
}

function callActiveProblems1(patient_id,encounter_id,params) {
	
	var	bean_id			=	"ADRReportBean" ;
	var	bean_name		=	"ePH.ADRReportBean";
	var params			=	params;
	 xmlStr ="<root><SEARCH " ;
	 xmlStr +=" /></root>" ;

	var temp_jsp="AdrReportingValidate.jsp?validate=DIAG_TEXT"+"&params="+params+"&bean_id=" + bean_id + "&bean_name=" + bean_name ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function populatediagnosis(diag_text,i){
	var diag_text_1  = new Array() ;
	if(i==1){
		var diag_text_1=diag_text.split("##");
		document.AdrReportingTab_form.Diagnosis.value=diag_text_1[0];
	}
	else if(i==2){
		var diag_text_1=diag_text.split("##");
		document.AdrReportingTab_form.Diagnosis.value=diag_text_1[0]+"\n"+diag_text_1[1];
	}
	else if(i==3){
		var diag_text_1=diag_text.split("##");
		document.AdrReportingTab_form.Diagnosis.value=diag_text_1[0]+"\n"+diag_text_1[1]+"\n"+diag_text_1[2];
	}
}

async function getQuestionnaireSearch(){
	var retVal;
	var dialogHeight= "75vh" ;
	var dialogWidth	= "75vw" ;
	var dialogTop = "10" ;
	var center = "0" ;														   
	var status="no";
	var scrollbar="vertical"
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+"; horizontal-scroll :no";
	var arguments	= "" ;
	var mode=document.AdrReportingTab_form.mode1.value
	var adr_no=document.AdrReportingTab_form.adr_no.value
	var verified_by=document.AdrReportingTab_form.sgndBy.value;
	var url = "../../ePH/jsp/AdrReportingQuestionnaire.jsp?mode="+mode+"&adr_no="+adr_no+"&verified_by="+verified_by;
	 retVal = await top.window.showModalDialog(url,arguments,features);
	

	if(retVal==true){
		if(verified_by!=null&&verified_by!=""){
			return;
		}else{
	updateQuestionnaire();
		}
	}else if(retVal=='5'){
		cancelQuestionnaire();
	}
}

function modadrresponse(adrcode,num){
	var	bean_id			=	document.adrreportquestionnaire.bean_id.value ;
	var	bean_name		=	document.adrreportquestionnaire.bean_name.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ADRREPORTQUSETION"+"&adrcode="+ adrcode +"&num=" +num, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//eval(responseText) ;
}

function updateQuestionnaire(){
	var	bean_id			=	document.AdrReportingTab_form.bean_id.value ;
	var	bean_name		=	document.AdrReportingTab_form.bean_name.value;
	var	qverifiedby		=	document.AdrReportingTab_form.sgndBy.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ADRREPORTUPDATE"+"&qverifiedby="+qverifiedby, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	parent.document.getElementById('dialog_tag').close();
}

function cancelQuestionnaire(){
	var	bean_id			=	document.AdrReportingTab_form.bean_id.value ;
	var	bean_name		=	document.AdrReportingTab_form.bean_name.value;
	//var	qverifiedby		=	document.AdrReportingTab_form.sgndBy.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&validate=ADRREPORTCANCEL", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	document.AdrReportingTab_form.sysiddrugrlsp.value="";
	document.getElementById('sysidrl').innerHTML="";
	parent.window.close();
}

function setcertainity(cer_code){
	var codes=cer_code.split("~");
	var selLength = document.AdrReportingTab_form.DrugRelation.options.length;
	var selObj = document.AdrReportingTab_form.DrugRelation;
	for(var t=0;t<parseInt(selLength);t++){
		if(selObj.options[t].value == codes[0])	{
			selObj.options[t].selected=true;
			document.getElementById("sysidrl").innerHTML=codes[1];
			document.AdrReportingTab_form.sysiddrugrlsp.value=codes[0];
			break;
		}
	}
}

async function searchallergytype(){
	var frmObj = document.AdrReportingTab_form;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var target			=document.AdrReportingTab_form.allergytype;

	argumentArray[0] = document.AdrReportingTab_form.SQL_PH_ALLERGY_SEARCH.value+"'"+document.AdrReportingTab_form.locale.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray =await CommonLookup(getLabel("Common.SearchUser.label","Common"), argumentArray );
	var str =unescape(retArray);
	var arr = str.split(",");
	if(retArray != null && retArray != "" ){
		frmObj.allergytype.value = arr[1];
		frmObj.allergytypecode.value=arr[0];
		//	formObj.user_code.value = retArray[0]; /* if code need to be returned */
        frmObj.user_search.disabled=true;
	}
	else{
		target.value = "";
		target.focus();
	}
}

function change_val_allergy(obj){
	var frmObj=document.AdrReportingTab_form;
	if(frmObj.adv_event_ind[0].checked==true)
		adv_event_ind=frmObj.adv_event_ind[0].value;
	else if(frmObj.adv_event_ind[1].checked==true)
		adv_event_ind=frmObj.adv_event_ind[1].value;
	else if(frmObj.adv_event_ind[2].checked==true)
		adv_event_ind=frmObj.adv_event_ind[2].value;
	else if(frmObj.adv_event_ind[3].checked==true)
		adv_event_ind=frmObj.adv_event_ind[3].value;
	document.AdrReportingTab_form.hypersensitivity.value=adv_event_ind;
}

function change_val_two(obj){
	var frmObj=document.AdrReportingTab_form;
	if(frmObj.pat_obser[0].checked==true)
		pat_obser=frmObj.pat_obser[0].value;
	else if(frmObj.pat_obser[1].checked==true)
		pat_obser=frmObj.pat_obser[1].value;
	else if(frmObj.pat_obser[2].checked==true)
		pat_obser=frmObj.pat_obser[2].value;
	document.AdrReportingTab_form.sourceOfInfo.value=pat_obser;
}

function change_val(obj){
	var frmObj=document.AdrReportingTab_form;

	if(frmObj.definit[0].checked==true)
		definit=frmObj.definit[0].value;
	else if(frmObj.definit[1].checked==true)
		definit=frmObj.definit[1].value;
	document.AdrReportingTab_form.certanity.value=definit;
}

function change_val_status(obj){
	var frmObj=document.AdrReportingTab_form;

	if(frmObj.active[0].checked==true)
		active=frmObj.active[0].value;
	else if(frmObj.active[1].checked==true)
		active=frmObj.active[1].value;
	else if(frmObj.active[2].checked==true)
		active=frmObj.active[2].value;

	document.AdrReportingTab_form.status_act.value=active;
}

function changeTradeSelectionValue(){
	var frmObj=document.AdrReportingTab_form;	
	frmObj.trade_code.value=frmObj.trade_desc.value;

}

function CheckValue(obj){// this function added for 30917
	if( obj.value == undefined || obj.value =="" || parseFloat(obj.value) ==0 ){	   
		alert(getMessage("PH_NOT_BLANK_ZERO","PH"));
		obj.value ==""
		obj.focus();
	}	
}

function DateCheck(from,to,locale) { // This function added for ADR Admin Date Time is not validating[32828]   
	if(from.value=="" || to=="")
			return false;	
	else{
		if(!isBefore(from.value,to,"DMY",locale)) {				
			from.focus();			
			var errors=getMessage("FROM_DATE_GREATER_SYSDATE","PH") ;					
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}
	}		
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=" ;
    return true;
}
 
function Duplicatecheck(){  /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	var patientId = document.formAdrReportingQueryCriteria.patient_id.value; 
	if( (patientId != null) && (patientId !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId + "\" " ;
		xmlStr+= "chkPatientID=\"false\" " ;			
		xmlStr+= "bean_id=\"" + bean_id + "\" " ;	
		xmlStr+= "bean_name=\"" + bean_name + "\" " ;	
		xmlStr +=" /></root>";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "QueryPatientDrugProfileValidation.jsp?func_mode=Duplicate&bean_id=" + bean_id + "&bean_name=" +bean_name+"&patientId="+patientId, false ) ;	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;		
		eval(responseText);	
	}	
} 

function mergedPatientAlert(main_patientid){ 
	msg = getMessage('PATIENT_MERGED_VALID','MP');
	msg= msg.replace('#',main_patientid);
	alert(msg);
	document.formAdrReportingQueryCriteria.patient_id.value=main_patientid;  
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */
 
 
 async function showRemarks(patient_id,adrno,facility_id,adrstatus){ //code added for HSA-CRF-0005[40601] --Start
    var listBoxStatus = "";
    if(document.formAdrReportingCriteria.status.disabled == true)
		listBoxStatus = "disabled";   
	var dialogHeight= "50vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "240" ;
	var dialogLeft = '700' ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogLeft: " + dialogLeft + "; status: " + status + "; dialogTop :" + dialogTop+" scroll=no; ";
	var arguments	= "" ;
	var adrstatus = document.formAdrReportingCriteria.status.value
	var retVal = await window.showModalDialog("../../ePH/jsp/ADRReportingRemarks.jsp?patient_id="+patient_id+ "&adrno=" + adrno+ "&facility_id=" + facility_id+ "&adrstatus=" + adrstatus+ "&listBoxStatus=" + listBoxStatus,arguments,features); 	
	if(retVal != undefined){
		document.formAdrReportingCriteria.canErrorID.value = retVal[0];  
		document.formAdrReportingCriteria.canErrorDate.value = retVal[1];
		document.formAdrReportingCriteria.canRemarks.value = retVal[2];
		document.formAdrReportingCriteria.canReason.value = retVal[3];
	}
}  
function setADRremarks(canErrorID,canErrorDate,canErrorIDTemp,canRemarks){
	if(canRemarks == undefined){
       canRemarks   = document.ADRReportingRemarksForm.canRemarks.value;
	   canRemarks   = encodeURIComponent(canRemarks,"UTF-8");
	}	
	var canReason   = document.ADRReportingRemarksForm.canReason.value;	 
	var retval= new Array();
	retval[0]=canErrorID;
	retval[1]=canErrorDate;
	retval[2]=canRemarks;
	retval[3]=canReason;
    var	bean_id			= "ADRReportBean" ;
	var	bean_name		= "ePH.ADRReportBean";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;
	xmlStr     += " canRemarks=\""+ canRemarks + "\" "; 
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&canErrorIDTemp=" + canErrorIDTemp+ "&canErrorDate=" + canErrorDate + "&canReason=" + canReason+"&validate=ADRremarks", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;	
	eval(responseText);				
	parent.document.getElementById('dialog-body').contentWindow.returnValue = retval;
	parent.document.getElementById('dialog_tag').close();
	
}
async function showQueryRemarks(adrno,patient_id,adrstatus,facility_id){
 
	var dialogHeight= "80vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "240" ;
	var dialogLeft = '700' ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogLeft: " + dialogLeft + "; status: " + status + "; dialogTop :" + dialogTop+" scroll=no; ";
	var arguments	= "" ;
	var retVal = await window.showModalDialog("../../ePH/jsp/ADRReportingRemarks.jsp?calledfrom=QueryRemarks&patient_id=" + patient_id + "&adrno=" +adrno+ "&adrstatus=" +adrstatus+ "&facility_id=" +facility_id,arguments,features);	
	
}
function captureStatus(adrstatus){  
     if(adrstatus=="C" || adrstatus=="E" ){//code added for HSA-CRF-0005[40601]
		document.getElementById("remarks").style.visibility="visible";	 
		document.getElementById("mandSymbol").style.visibility="visible";
		parent.parent.frames[0].document.forms[0].apply.disabled = false;//code added for HSA-CRF-0005[40601]
	}		
	 else{
		document.getElementById("remarks").style.visibility="hidden";	   	
		document.getElementById("mandSymbol").style.visibility="hidden";	   	
		clearremarks();  
		if(adrstatus!="U")
			parent.parent.frames[0].document.forms[0].apply.disabled = true;
	  }
 } 

 function clearremarks(callfrom){
	var	bean_id			= "ADRReportBean" ;
	var	bean_name		= "ePH.ADRReportBean";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name  +"&validate=ADRClearReason", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;	
	eval(responseText);  
	if(callfrom!='RESET'){
		document.formAdrReportingCriteria.canErrorID.value = "";  
		document.formAdrReportingCriteria.canErrorDate.value = "";
		document.formAdrReportingCriteria.canRemarks.value = "";
		document.formAdrReportingCriteria.canReason.value = "";
	}
}

function assignstatus(adrStatus){
 	var formobj = document.formAdrReportingCriteria;
	var len = formobj.status.options.length;
	if( len == 1){	     
		 formobj.status.disabled = true;
	     document.getElementById("remarks").style.visibility="visible"; 		
	     document.getElementById("mandSymbol").style.visibility="visible"; 		
	}
	else{	     
	     document.getElementById("remarks").style.visibility="hidden"; 
	     document.getElementById("mandSymbol").style.visibility="hidden";            
     } 
 }
 
function CheckRemMaxLen() { 
	var val = "";
	obj = document.ADRReportingRemarksForm.canRemarks;
	val = obj.value;
	if(obj.value.length > 2000) {
		var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
		msg = msg.replace("$",getLabel("Common.remarks.label",'Common'));
		msg = msg.replace("#",2000);		 
		obj.value = val.substring(0,2000);
		alert(msg);  		
		obj.focus();
		return false;
	} 
}

function checkAdrRremarks(obj) {
	obj.value=trimString(obj.value);	
	if(obj.value.length<1){
	alert(getMessage("REMARKS_CANNOT_BLANK","PH"));
	return false;
  }
}
function getremarks(obj){   
    var app_trn_type 	= document.ADRReportingRemarksForm.app_trn_type.value ;	
    var	bean_id			= "ADRReportBean" ;
	var	bean_name		= "ePH.ADRReportBean";	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH " ;	
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "AdrReportingValidate.jsp?bean_id=" + bean_id + "&bean_name=" + bean_name + "&canReason=" + obj.value  +"&validate=ADRCancelReason", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;	
	eval(responseText);	
}
function setRemarks(reason){  
	document.ADRReportingRemarksForm.canRemarks.value= decodeURIComponent(reason,"UTF-8");
}
function checkTxtValue(objVal,mode){
	var txtvalue =objVal.value ;
	if(mode == "1"){
		if (txtvalue == "")
			document.formAdrReportingQueryCriteria.ReportedBy_id.value="";		
		else
			searchUserNames2(document.formAdrReportingQueryCriteria.ReportedBy,mode);		
	}
	else if(mode == "2"){
		if (txtvalue == "")
			document.formAdrReportingQueryCriteria.SignedBy.value="";		
		else 
			searchUserNames2(document.formAdrReportingQueryCriteria.SignedBy_1,mode);		
	}
	else if(mode == "3"){
		if (txtvalue == "")
			document.formAdrReportingQueryCriteria.drug_code.value="";		
		else 
			DrugLookupQuery();		
	}
	
}
function checkSignedByEmpty(obj){
	if(obj.value==""){
		document.AdrReportingSignedBy.SignedBy.value="";
		document.AdrReportingSignedBy.SignedBy_1.value="";
	}
}
//code added for HSA-CRF-0005[40601] --End

function closeAdverseWindow(){
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();
}
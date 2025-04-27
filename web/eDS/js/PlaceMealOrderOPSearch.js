/**
File Name			: PlaceMealORderOPSearch.js
File Description	: This is to search all the Outpatients who 
						1) Books an appointment but yet to visit 
						2) Visit clinic with appointment
						3) Direct Visit without appointment
CRF#				: Bru-HIMS-CRF-230
Author				: Abirami
Date				: Aug-2013
**/

var specialityCode = new Array();
var specialityDesc = new Array();

function hideEMSearchCriteria() {
	document.forms[0].mealOrderFor[0].checked = true;
	var EMElements = document.getElementsByClassName('Row_EMPatient');
	for(var i=0;i<EMElements.length;i++) {
		EMElements[i].style.display='none';
	}		

}

//Function: For loading Speciality:
function loadSpeciality(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="language_Id=en&mode=initialLoad";
	var speciality = new Array();
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	//Getting Speciality List::
	var specList=new Array();
	specList = jsonObjResponse.specList;
   var obj = document.getElementById("speciality");
	while(obj.length > 0){
			obj.remove(0);
		}
      // ML-MMOH-CRF-0597
	 if(specList.length!=1){
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	       for(var itr=0; itr < specList.length;itr++){
			    var Entry = document.createElement("option");
				Entry.value = specList[itr].specCode;
				Entry.text  = specList[itr].specDesc;
				obj.add(Entry);
			   }			   
	 }	  
	 else{
		    for(var itr=0; itr < specList.length;itr++){
			    var Entry = document.createElement("option");
				Entry.value = specList[itr].specCode;
				Entry.text  = specList[itr].specDesc;
				obj.add(Entry);
              }
	   } 
	   // ML-MMOH-CRF-0597
	//Getting location type List::
	var locList=new Array();
	locList = jsonObjResponse.locList;
	
	var obj = document.getElementById("loctype");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(locList!=null)
	{
		for(var itr=0; itr < locList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = locList[itr].LocCode;
				Entry.text  = locList[itr].LocDesc;
				obj.add(Entry);
		}
	}
	
	//Getting mulitifacility value::
	var multifacility = jsonObjResponse.multifacility;
	var obj = document.getElementById("alterfacility");
	var isAlternateBooking=document.getElementById("alternateBooking").value;
	if(multifacility == "Y")
		obj.disabled=false;
	else
		obj.disabled=true;
		
	if(isAlternateBooking=="Y")  obj.disabled=true;
	//Setting Maximum length for Patient field dynamically::
	parent.frames[1].document.forms[0].patientid.maxLength = jsonObjResponse.patientIDLen;
}

//Lookup of PatientID::
async function getPatID()
{					  
	var pat_id= await PatientSearch();
	if( pat_id != null )						
		parent.frames[1].document.forms[0].patientid.value = pat_id ;					
}

//Lookup of PatientID - AE patients
async function getPatID_EM()
{					  
	var pat_id= await PatientSearch();
	if( pat_id != null )						
		parent.frames[1].document.forms[0].patientid_EM.value = pat_id ;					
}

//Function: Hitting PatientSearch Screen:
async function PatientSearch()
{
		var window_styl='O';
        var close_yn='Y';
        var   jsp_name='';
        var win_top= '61';
        var win_height= '90vh';
        var win_width= '80vw';
        var act_yn= 'N';
        var register_button_yn = 'N';
        var func_act='';	
        var dr_function_id='';
		var srr='Y';

        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();
		
        var patient_class='';	
		
    var url     = "../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id+"&patient_class="+patient_class;

	var dialogTop       = "0";
	var dialogHeight    = "90vh" ;
	var dialogWidth = "80vw" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status:no" ;
	var returnval =await top.window.showModalDialog( url, arguments, features ) ;
	return returnval;
}

function searchMealOrder() {
	var isOPOrder=true;
	if(document.forms[0].mealOrderFor[0].checked == true) {
		isOPOrder=true;
	}
	else {
		isOPOrder=false;
	}
	
	if (isOPOrder==true) {searchOPMealOrder();}
	
	else if (isOPOrder==false) {searchEMMealOrder();}
}
//Function : for Searching OPLists: 
function searchOPMealOrder()
{	
	var flag = compareDate(document.forms[0].dateFrom.value,document.forms[0].dateTo.value);

		if(flag== 1){
			var error=getMessage("DS_TODATE_GRTR_OR_EQL_FRMDATE","DS");//"To Date should be greater than or equal to From Date"; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return false;
		}else
		{
			var error=""; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}


	var speciality=getLabel("Common.speciality.label","common");
	var sDate=getLabel("Common.date.label","common");
	var fields = new Array (document.forms[0].speciality, document.forms[0].dateFrom);
	var names = new Array (speciality,sDate);
	
	if(checkFieldsofMst( fields, names, parent.messageFrame)) 
	{	
		parent.frames[1].document.getElementById("hdnHdrSpeciality").value = parent.frames[1].document.getElementById("speciality").value;
		parent.placeMealOrderOPResult.location.href ="../../eDS/jsp/PlaceMealOrderOPResultFrame.jsp";
	}
}

//Function : for Searching OPLists: 
function searchEMMealOrder()
{	/*var flag = compareDate(document.forms[0].dateFrom.value,document.forms[0].dateTo.value);

		if(flag== 1){
			var error=getMessage("DS_TODATE_GRTR_OR_EQL_FRMDATE","DS");//"To Date should be greater than or equal to From Date"; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}else
		{
			var error=""; 
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		}*/


//	var speciality=getLabel("Common.speciality.label","common");
	var sDate=getLabel("Common.date.label","common");
	var location=getLabel("Common.Location.label","common");
	var fields = new Array (document.forms[0].location_EM, document.forms[0].date_EM);
	var names = new Array (location,sDate);
	
	if(checkFieldsofMst( fields, names, parent.messageFrame)) 
	{	
//		parent.frames[1].document.getElementById("hdnHdrSpeciality").value = parent.frames[1].document.getElementById("speciality").value;
		parent.placeMealOrderOPResult.location.href ="../../eDS/jsp/PlaceMealOrderEMResultFrame.jsp";
	}
}

/* This function is to show the search criteria for OP or Emergency Patients based on the selection */

function showSearchCriteria(obj) {
	parent.placeMealOrderOPResult.location.href='../../eCommon/html/blank.html';
	var error=""; 
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	var elementsOP = document.getElementsByClassName('Row_OutPatient');
	var elementsEM = document.getElementsByClassName('Row_EMPatient');
	if(obj.value=='OP') {
		for(var i=0;i<elementsOP.length;i++) {
			//document.getElementById("Row_OutPatient")[i].style.display='block';
			elementsOP[i].style="display";
		}
		for(var i=0;i<elementsEM.length;i++) {
			//document.getElementById("Row_EMPatient")[i].style.display='none';
			elementsEM[i].style.display = 'none';
		}
		resetEMFields();
	}
	else if(obj.value=='EM') {
		for(var i=0;i<elementsOP.length;i++) {
			//document.getElementById("Row_OutPatient")[i].style.display='none';
			elementsOP[i].style.display = 'none';
		}
		for(var i=0;i<elementsEM.length;i++) {
			//document.getElementById("Row_EMPatient")[i].style.display='block';
			elementsEM[i].style="display";
		}
		resetOPFields();
		populateFieldsForAE();
	}
}


//Function: For pre-populating the search criteria fields for AE patients
function populateFieldsForAE(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="language_Id=en&mode=initialLoad";
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	

	//Getting location type List::
	var locList=new Array();
	locList = jsonObjResponse.locList;
	
	var obj = document.getElementById("loctype_EM");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(locList!=null)
	{
		for(var itr=0; itr < locList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = locList[itr].LocCode;
				Entry.text  = locList[itr].LocDesc;
				if(locList[itr].LocCode=='C'){ Entry.selected=true;}
				obj.add(Entry);
		}
	}
	obj.disabled=true;
	
	//Getting Priority Zone List::
	var priorityZoneList=new Array();
	priorityZoneList = jsonObjResponse.priorityZoneList;
	
	var obj = document.getElementById("priorityZone");
	while(obj.length > 0){
			obj.remove(0);
		}
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
	
	if(priorityZoneList!=null)
	{
		for(var itr=0; itr < priorityZoneList.length;itr++){
				var Entry = document.createElement("option");
				Entry.value = priorityZoneList[itr].pZoneCode;
				Entry.text  = priorityZoneList[itr].pZoneDesc;
				obj.add(Entry);
		}
	}	
	//Getting mulitifacility value::
	/*var multifacility = jsonObjResponse.multifacility;
	var obj = document.getElementById("alterfacility");
	var isAlternateBooking=document.getElementById("alternateBooking").value;
	if(multifacility == "Y")
		obj.disabled=false;
	else
		obj.disabled=true;
		
	if(isAlternateBooking=="Y")  obj.disabled=true;*/
	//Setting Maximum length for Patient field dynamically::
	//alert("length"+jsonObjResponse.patientIDLen);
	document.getElementById("patientid_EM").maxLength = jsonObjResponse.patientIDLen;
}

function getTreatmentArea() {
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var facilityId=document.getElementById("facility_id").value;
	var clinicCode=document.getElementById("hdnlocation_EM").value;
	var priorityZone=document.getElementById("priorityZone").value;
	
	var priorityZone=document.all("priorityZone").options[document.all("priorityZone").selectedIndex].text;

	if(priorityZone=="----select----") {priorityZone="";}
	var locCode=document.getElementById("location_EM").value;
	
//	var clinicCode='2S2S';
	var locale=document.getElementById("locale").value;
	var obj = document.getElementById("treatmentArea");
	
	var param="language_Id="+locale+"&facilityId="+facilityId+"&clinicCode="+clinicCode+"&mode=getTreatmentArea&priorityZone="+priorityZone;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceMealOrderOPServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;

	var jsonObjResponse=eval('(' + retVal + ')');
	
	var trmntAreaCodeArr=new Array();
	var trmntAreaDescArr=new Array();
	
	trmntAreaCodeArr= jsonObjResponse.treatmentAreaCode;
	trmntAreaDescArr=jsonObjResponse.treatmentAreaDesc;
	
	while(obj.length > 0){
		obj.remove(0);
	}
	var Entry = document.createElement("OPTION");
	var msg = "----Select----";
	Entry.text = msg;
	Entry.value= "";
	obj.add(Entry);
	if(trmntAreaCodeArr!=null) {
		for(var j=0; j < trmntAreaCodeArr.length; j++){
			var Entry = document.createElement("option");
			Entry.value  = trmntAreaCodeArr[j];
			Entry.text  = trmntAreaDescArr[j];
			obj.add(Entry);
		}
	}
}

function resetEMFields() {
	var sysdate=document.getElementById("systemDate").value;
	
	document.getElementById("location_EM").value="";
	document.getElementById("hdnlocation_EM").value="";
	document.getElementById("date_EM").value=sysdate;
	document.getElementById("treatmentArea").value="";
	document.getElementById("practitioner_name_EM").value="";
	document.getElementById("practitioner_EM").value="";
	document.getElementById("patientid_EM").value="";
	document.getElementById("encounterId_EM").value="";
	document.getElementById("status_EM").value="";
}

function resetOPFields() {
	var sysdate=document.getElementById("systemDate").value;
	
	document.getElementById("speciality").value="";
	document.getElementById("dateFrom").value=sysdate;
	document.getElementById("dateTo").value=sysdate;
	document.getElementById("loctype").value="";
	document.getElementById("location").value="";
	document.getElementById("hdnlocation").value="";
	document.getElementById("resourceType_1").value="";
	document.getElementById("practitioner_name").value="";
	document.getElementById("practitioner").value="";
	
	document.getElementById("resourceType_2").value="";
	document.getElementById("patientid").value="";
	document.getElementById("encounter_id").value="";
	document.getElementById("status").value="";
	document.getElementById("apptno").value="";
	
}

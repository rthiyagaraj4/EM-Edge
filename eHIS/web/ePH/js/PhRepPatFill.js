  //saved on 02.11.2005
function run() {
	//alert("from"+searchFrame.document.formPHRepPatFillCriteria.nunit_from.value);
	//alert("to"+searchFrame.document.formPHRepPatFillCriteria.nunit_to.value);

//alert("val ----"+searchFrame.document.formPHRepPatFillCriteria.p_fill_proc_id.value);
	var fill_proc_id = searchFrame.document.formPHRepPatFillCriteria.p_fill_proc_id.value;
	var p_fill_proc_id1 = searchFrame.document.formPHRepPatFillCriteria.p_fill_proc_id1;
	if(fill_proc_id != ""){
		p_fill_proc_id1.value = fill_proc_id;
	}
	else{
		p_fill_proc_id1.value ="";
	}

	if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="PATLAB") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHPATLIST";
	} 
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-A" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="") {//added for HSA-CRF-0221 [IN:050539] - start
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHSUPPLIST";
	} 
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-A" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="IVD") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHSUPLIVD";
	} 
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-A" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="IVWA") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHSUPLIVWA";
	}
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-A" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="IVPB") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHSUPLIVPB";
	}
	else if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-D" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="") {
		   searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHDISPLIST";
	}
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-D" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="IVD") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHDISPLIVD";
	} 
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-D" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="IVWA") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHDISPLIVWA";
	}
	else  if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-D" && searchFrame.document.formPHRepPatFillCriteria.p_order_type.value=="IVPB") {
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHDISPLIVPB";
	}//added for HSA-CRF-0221 [IN:050539] - End
	else if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="PHRPATMEDLIST") {
		      //alert("ghcghcghcgch");
		searchFrame.document.formPHRepPatFillCriteria.p_report_id.value="PHRPATMEDLIST";
	}
    if(searchFrame.document.formPHRepPatFillCriteria.report_by.value=="SPLIST-D"){
		var fields = new Array(searchFrame.document.formPHRepPatFillCriteria.p_dispensed_date1);
		var names = new Array(getLabel("ePH.DispenseDate.label","PH"));

        if(searchFrame.checkFields( fields, names, messageFrame)){
			searchFrame.document.formPHRepPatFillCriteria.p_dispensed_date.value = convertDate(searchFrame.document.formPHRepPatFillCriteria.p_dispensed_date1.value,'DMY',searchFrame.document.formPHRepPatFillCriteria.p_language_id.value,'en');
			if(searchFrame.document.formPHRepPatFillCriteria.p_from_time.disabled==false ){
				if(isValidFromToField(searchFrame.document.formPHRepPatFillCriteria.p_from_time, searchFrame.document.formPHRepPatFillCriteria.p_to_time))
				{
					searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					searchFrame.document.forms[0].target="messageFrame";
					searchFrame.document.formPHRepPatFillCriteria.submit();
				}
			}
			if(searchFrame.document.formPHRepPatFillCriteria.p_from_time.disabled==true)
			{
				searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				searchFrame.document.forms[0].target="messageFrame";
				searchFrame.document.formPHRepPatFillCriteria.submit();
			}
		}
	}
	else{
		var fields = new Array(searchFrame.document.formPHRepPatFillCriteria.locn_type);   //ML-BRU-SCF-0498 [IN035593]  -- begin
		var names = new Array(getLabel("Common.locationtype.label","Common"));
		if(searchFrame.checkFields( fields, names, messageFrame)){
			//ML-BRU-SCF-0498 [IN035593]  -- end
			searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			searchFrame.document.forms[0].target="messageFrame";
			searchFrame.document.formPHRepPatFillCriteria.submit();
		}
	}
}

function reset() {
	
	var formObj = searchFrame.document.formPHRepPatFillCriteria
	//searchFrame.formPHRepPatFillCriteria.reset(); Commented by Sandhya regarding incident num:25492 on 16/DEC/2010
	searchFrame.location.reload(); //Reloading the page regarding incident num:25492 on 16/DEC/2010

	searchFrame.document.getElementById("disp_date").style.visibility="hidden";
	searchFrame.document.getElementById("disp_time").style.visibility="hidden";
	searchFrame.document.getElementById("p_disp_locn_code").style.visibility="hidden";
	searchFrame.document.getElementById("p_fill_proc_id").style.visibility="hidden";
	searchFrame.document.getElementById("disp_locn_lbl").style.visibility="hidden";
	searchFrame.document.getElementById("disp_by_lbl").style.visibility="hidden";
	searchFrame.document.getElementById("p_dispensed_by").style.visibility="hidden";
	searchFrame.document.getElementById("disp_locn_row").style.visibility="hidden";
	searchFrame.document.getElementById("T1").style.visibility="hidden";
//		searchFrame.document.getElementById("From_Calendar").style.visibility="hidden";
//		searchFrame.document.getElementById("To_Calendar").style.visibility="hidden";
	clearData(formObj.p_fill_proc_id);
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

async function searchNursingUnit(target){

	var formObj = document.frames.formPHRepPatFillCriteria;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

     var report_by = null;
	 if(formObj.report_by.type == "hidden")
		report_by = formObj.report_by.value;
	 else
		report_by= formObj.report_by.options[formObj.report_by.selectedIndex].value;
     
	 if(report_by=="SPLIST-D")
	 {
	var ordering_facility_id = formObj.p_ordering_facility_code.options[formObj.p_ordering_facility_code.selectedIndex].value;
	//alert("ordering_facility_id---->"+ordering_facility_id);
	
	dataNameArray[0]   = "facility_id" ;
	dataValueArray[0]  = ordering_facility_id;
	dataTypeArray[0]   = STRING ;


	  }else{
	dataNameArray[0]   = "facility_id" ;
	dataValueArray[0]  = formObj.p_facility_id.value;
	dataTypeArray[0]   = STRING ;
	  }
	argumentArray[0]   = formObj.SQL_PH_DISP_MEDICATION_SELECT32.value+"'"+formObj.p_language_id.value+"'";
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "2,3";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	var arr=ret1.split(",");
	if(retVal != null && retVal != "" )  {
		if(target.name=="nursing_unit_from") {
			formObj.nunit_from.value = arr[0];
		} else {
			formObj.nunit_to.value = arr[0];
		}
		target.value = arr[1] ;
		//target.disabled = true; commented by sandhya regarding incident num:25492 on 16/DEC/2010
	}
}

function loadPage(obj,sysdate){
	var formObj = document.formPHRepPatFillCriteria;
//	alert(sysdate);
	//alert("obj----->" +obj);	
	if(obj=='SPLIST-D')
	{
			document.getElementById("disp_date").style.visibility="visible";
			document.getElementById("disp_time").style.visibility="visible";
			document.getElementById("p_fill_proc_id").style.visibility="visible";
			document.getElementById("disp_locn_lbl").style.visibility="visible";
			document.getElementById("p_disp_locn_code").style.visibility="visible";
			document.getElementById("disp_by_lbl").style.visibility="visible";
			//document.getElementById("disp_by").style.visibility="visible";
			document.getElementById("T1").style.visibility="visible";
			document.getElementById("disp_locn_row").style.visibility="visible";
			document.getElementById("p_disp_locn_code").value="";
			document.getElementById("p_dispensed_date1").value=sysdate;
			document.getElementById("p_fill_proc_id").value="";
			document.getElementById("p_dispensed_by").value="";
			document.getElementById("p_dispensed_by").style.visibility="visible";
			document.getElementById("p_to_time").disabled=false;
			document.getElementById("p_to_time").value="23:59";
			document.getElementById("p_from_time").value="00:00";
			document.getElementById("p_from_time").disabled=false;
			document.getElementById("p_patient_id_row").style.display="none";
			document.getElementById("patient_id_row").style.display="none";
			document.getElementById("p_patient_id").value="";
			//Add on date 16-03-2009
			document.getElementById("disp_dispensingFacility_row").style.visibility="visible";
			document.getElementById("disp_dispensingFacility").style.visibility="visible";
			document.getElementById("disp_orderingFacility_row").style="display";
			document.getElementById("ordering_facility").style.visibility="visible";
			document.getElementById("p_order_type").style.visibility="visible";//added for HSA-CRF-0221 [IN:050539] 
			document.getElementById("iv_prep_type").style.visibility="visible";//added for HSA-CRF-0221 [IN:050539] 
			document.getElementById("p_order_type").value="";//added for HSA-CRF-0221 [IN:050539] 
			getFillid(document.formPHRepPatFillCriteria.p_dispensed_date1);

		
	}else if( obj=='SPLIST-A' || obj=="")
	{
		document.getElementById("disp_date").style.visibility="hidden";
		document.getElementById("disp_time").style.visibility="hidden";
		document.getElementById("p_disp_locn_code").style.visibility="hidden";
		document.getElementById("p_fill_proc_id").style.visibility="hidden";
		document.getElementById("disp_locn_lbl").style.visibility="hidden";
		document.getElementById("disp_by_lbl").style.visibility="hidden";
		document.getElementById("p_dispensed_by").style.visibility="hidden";
		document.getElementById("disp_locn_row").style.visibility="hidden";
		document.getElementById("T1").style.visibility="hidden";
		document.getElementById("p_patient_id_row").style.display="none";
		document.getElementById("patient_id_row").style.display="none";
		document.getElementById("p_patient_id").value="";
        //Add on date 16-03-2009
        document.getElementById("disp_dispensingFacility_row").style.visibility="hidden";
		document.getElementById("disp_dispensingFacility").style.visibility="hidden";
		document.getElementById("disp_orderingFacility_row").style.display="none";
		document.getElementById("ordering_facility").style.visibility="hidden";
		document.getElementById("p_order_type").style.visibility="visible";//added for HSA-CRF-0221 [IN:050539] 
		document.getElementById("iv_prep_type").style.visibility="visible";//added for HSA-CRF-0221 [IN:050539] 
		document.getElementById("p_order_type").value="";//added for HSA-CRF-0221 [IN:050539] 
		//alert(document.getElementById("patient_id_row").style.visibility);
		clearData(formObj.p_fill_proc_id);

	}else if(obj=='PATLAB')
		{
		document.getElementById("patient_id_row").style="display";
		document.getElementById("p_patient_id_row").style.visibility="hidden";
		document.getElementById("disp_date").style.visibility="hidden";
		document.getElementById("disp_time").style.visibility="hidden";
		document.getElementById("p_disp_locn_code").style.visibility="hidden";
		document.getElementById("p_fill_proc_id").style.visibility="hidden";
		document.getElementById("disp_locn_lbl").style.visibility="hidden";
		document.getElementById("disp_by_lbl").style.visibility="hidden";
		document.getElementById("p_dispensed_by").style.visibility="hidden";
		document.getElementById("disp_locn_row").style.visibility="hidden";
		document.getElementById("T1").style.visibility="hidden";
		//Add on date 16-03-2009
		document.getElementById("disp_dispensingFacility_row").style.visibility="hidden";
		document.getElementById("disp_dispensingFacility").style.visibility="hidden";
		document.getElementById("disp_orderingFacility_row").style.display="none";
		document.getElementById("ordering_facility").style.visibility="hidden";
		document.getElementById("p_order_type").style.visibility="hidden";//added for HSA-CRF-0221 [IN:050539] 
		document.getElementById("iv_prep_type").style.visibility="hidden";//added for HSA-CRF-0221 [IN:050539] 
		document.getElementById("p_order_type").value="";//added for HSA-CRF-0221 [IN:050539] 
		clearData(formObj.p_fill_proc_id);

		}
		
}
function PHrep()    //created on 22/10/09-----
{		
	//alert("medicationlist_flag1");
	var medicationlist_flag2=document.formPHRepPatFillCriteria.medicationlist_flag1
		//alert("medicationlist_flag2---->" +medicationlist_flag2.value);
		if(medicationlist_flag2.value == "Y")
		{	//alert("207");
			document.getElementById("p_patient_id_row").style="display";
		}
}

function clearTime()
{
	var formObj = document.formPHRepPatFillCriteria;
	
	if(formObj.p_fill_proc_id.value != ""){
	document.getElementById("p_to_time").value="";
	document.getElementById("p_from_time").value="";
	formObj.p_from_time.disabled=true;
	formObj.p_to_time.disabled=true;
	}
	else
	{
			formObj.p_from_time.value="00:00";
		formObj.p_to_time.value="23:59";
		formObj.p_from_time.disabled=false;
		formObj.p_to_time.disabled=false;
	}

}

function clearData(obj) {
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) {
		obj.remove("");
	}
	var opt	= document.createElement('OPTION');
	opt.value =	"";
	opt.text = "    --- Select  ---    ";
	obj.add(opt);
}

function getFillid(obj)
{
	var formObj = document.formPHRepPatFillCriteria;
	var disp_date=convertDate(obj.value,'DMY',document.formPHRepPatFillCriteria.p_language_id.value,'en');   


	 bean_id1		= document.formPHRepPatFillCriteria.bean_id.value ;
	 bean_name1	= document.formPHRepPatFillCriteria.bean_name.value ;

	 var xmlDoc="";
	 var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+obj.value+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ReportsValidate.jsp?bean_id=" + bean_id1 + "&bean_name=" + bean_name1 + "&called_from=Disp_Date" + "&disp_date=" + disp_date,false); 


	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval( responseText ) ;
}

function addData(desc,obj)
{
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.text = desc;
	opt.value =	trimString(desc);
	obj.add(opt);
}

function showCalender()
{
	var formObj = document.frames.formPHRepPatFillCriteria;
	if(formObj.p_fill_proc_id.value!="")
	{
		formObj.p_from_time.enabled=true;
		formObj.p_to_time.enabled=true;
	}
}


function clearFillProcList() 
{
	var len =document.formPHRepPatFillCriteria.p_fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		document.formPHRepPatFillCriteria.p_fill_proc_id.remove("fill_proc_id") ;
	}
}



function addSelect()
{   
	var opt	= eval(document.createElement('OPTION'));
	opt.text = "--- Select ---";
	opt.value =	"";
	document.formPHRepPatFillCriteria.p_fill_proc_id.options.add(opt);
}

function chkValidityOfTime(strfromTime){
	
	strfromTimeVal = strfromTime.value;
	strTemp = strfromTimeVal.indexOf(":");
	if(strTemp == -1 || strTemp != 2){
		alert(getCAMessage("INVALID_TIME","PH"));
		strfromTime.select();
		strfromTime.focus();
		return false;
	}
	else
	{
		chkTime(strfromTime);
	}

}

function chkTime(strfromTime){
	
	
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];
	if(strfromTime.value.length !=5)
	{
		alert(getCAMessage("INVALID_TIME","PH"));
				strfromTime.select();
		return false;
	}
	if(hr>23){
		alert(getCAMessage("INVALID_TIME_HOUR","CA"));
		strfromTime.select();
		return false;
	}
	if(min>59){
				alert(getCAMessage("INVALID_TIME_MINUTE","CA"));
		strfromTime.select();
		return false;
	}
//	calculateTime(strfromTime)
}
/*
function calculateTime(strfromTime){
	
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];
	
	if(min>0){
		hr_1 = parseInt(hr,10)+24;		
	}
	else{
		hr_1 = parseInt(hr,10)+23;
	}	

	if(hr_1 >24){
		hr_1 = hr_1-24;
	}
	else if(hr_1 == 24){
		hr_1 = 1;
	}
	else if(hr_1 == 23){
		if(min == 0){
			hr_1 = 23;
		}
		else{
			hr_1 = 0;
		}
	}
	
	if(hr == "01" && min == "00"){
		hr_1 = 12;
	}
	if(hr == "00" && min !="00"){
		hr_1 = 0;
	}

	min_1 = parseInt(min,10)+59;
	
	if(min_1 > 60){
		min_1 = min_1-60;
	}
	else if(min_1 == 60){
		min_1 = 0;
	}

	if(hr_1 >=0 && hr_1 <=9)	
	{
		hr_1 = "0" + hr_1
	}

	if(min_1 >=0 && min_1 <=9){
		min_1 = "0" + min_1;
	}


	finalToTime = hr_1+":"+min_1;
	document.formPHRepPatFillCriteria.p_to_time.value = finalToTime;
	//parent.f_query_add_mod.document.AddModifyChartSetupForm.day_summ_to.value = finalToTime;
}*/

function CheckForNumsAndColon(event){
    var strCheck = '0123456789:';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;	
}


function isValidFromToField(fromObj, toObj){
	var bReturn	= true;
	var stFromValue	=	fromObj.value;
	var stToValue	=	toObj.value;

	if(stFromValue!="" && stToValue!="")
	{
	   var arFromDate	= stFromValue.split(":");
       var arToDate	= stToValue.split(":");
		if( parseInt(arFromDate[0]) > parseInt(arToDate[0]))
		{
			bReturn=false;
		}
	    if ( (!bReturn) ){
		var phMessage	=	"Dispense To Time should be greater than or equal to Dispense From Time."
		alert(phMessage);
		toObj.select();
		toObj.focus();
	}
	return bReturn;
	
	}
}


async function callPatientSearch(target)
{
	//var formobj=document.formPHRepPatFillCriteria;
	var patient_id = await PatientSearch();
 if(patient_id != null && patient_id != "" )  
	 {		
		target.value = patient_id;
		 
	 }
	 chkPatientID(patient_id)
	
		
}
//Created on 29/Sept/2010 For Report issue SRR-RPT-0003 Patient List-Fill List (Patient Label)---By Sandhya
async function callPatientLookup(){
	var formObj = document.formPHRepPatFillCriteria;
	var patient_id = await PatientSearch();
	if(patient_id != null && patient_id != "" )  {
		formObj.p_pat_id.value = patient_id;
		//formObj.p_patient_id.focus();
     }
	 chkPatientID(patient_id);
}
//Add on date 16-03-2009         Dispensing Facility
function fillDispLocation(obj)
{
	var formObj = document.formPHRepPatFillCriteria;
	var disp_facility_code=obj.value;   


	 bean_id1		= document.formPHRepPatFillCriteria.bean_id.value ;
	 bean_name1	= document.formPHRepPatFillCriteria.bean_name.value ;

	 var xmlDoc="";
	 var xmlHttp = new XMLHttpRequest();

	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+obj.value+"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "POST", "ReportsValidate.jsp?bean_id=" + bean_id1 + "&bean_name=" + bean_name1 + "&called_from=Dispense_Facility" + "&disp_facility_code=" + disp_facility_code,false); 


	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval( responseText ) ;

}
//To clear the list
function clearDisp_locnList() 
{
	var len =document.formPHRepPatFillCriteria.p_disp_locn_code.options.length;
	for(var i=0;i<len;i++) {
		document.formPHRepPatFillCriteria.p_disp_locn_code.remove("disp_locn") ;
	}
}
//To add select
function addSelectToDisp_locnList()
{   
	var opt	= eval(document.createElement('OPTION'));
	opt.text = "--- Select ---";
	opt.value =	"";
	document.formPHRepPatFillCriteria.p_disp_locn_code.options.add(opt);
}
//To add code and description
function addDataToDisp_locnList(code,desc,obj)
{
	obj = eval(obj);
	var opt	= eval(document.createElement('OPTION'));
	opt.text = desc;
	opt.value =	code;
	obj.add(opt);
}
//End 
// Code Added for ML-BRU-SCF-0498 [IN035593]  -- begin 
function resetLocation(){
	var formObj = document.formPHRepPatFillCriteria;
	formObj.p_fm_locn_code.value="";
	formObj.p_to_locn_code.value="";
	formObj.location_from.value="";
	formObj.location_to.value="";
	var label = "";
	if(formObj.locn_type.value=='C')  // ML-BRU-SCF-0498 [IN035593] -- begin
		label = getLabel("Common.clinic.label","Common");
	else if(formObj.locn_type.value=='N')
		label = getLabel("Common.nursingUnit.label","Common");
	else
		label = getLabel("Common.Location.label","Common");
	document.getElementById('lbl_locn_from').innerText=label+" "+getLabel("Common.from.label","Common");
}

async function locationLookup(target){
	var formObj = document.formPHRepPatFillCriteria;
	if(formObj==undefined)
		var formObj = searchFrame.document.formPHRepPatFillCriteria;
	var locn_type=formObj.locn_type.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	if (locn_type!=""){
		if (locn_type=="N"){
			argumentArray[0]   = escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT2.value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.nursingUnit.label","Common"), argumentArray );
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(retVal != null && retVal != "" )  {
					
				if(target.name=="location_from")
					formObj.p_fm_locn_code.value=arr[0];
				else
					formObj.p_to_locn_code.value=arr[0];
				target.value = arr[1] ;
			} 
		}else if (locn_type=="C"){
			argumentArray[0]   =  escape(formObj.SQL_PH_PRINT_PRESCRIPTIONS_SELECT1.value)+"'"+formObj.p_language_id.value+"'";
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			argumentArray[4]   = "1,2";
			argumentArray[5]   = target.value ;
			argumentArray[6]   = DESC_LINK ;
			argumentArray[7]   = CODE_DESC ;

			var retVal = await CommonLookup( getLabel("Common.clinic.label","Common"), argumentArray );
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(retVal != null && retVal != "" )  {
			
				if(target.name=="location_from")
					formObj.p_fm_locn_code.value=arr[0];
				else
					formObj.p_to_locn_code.value=arr[0];
				target.value = arr[1] ;
			}
		}
	}else{
		formObj.locn_type.focus()
	}
} 
function chkPatientID(patient_id){
	var formObj=document.formPHRepPatFillCriteria;
	if(patient_id == undefined)
		patient_id = formObj.p_patient_id.value;
	if (patient_id!= "" ){
		formObj.p_patient_id.value = patient_id;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="";
		xmlStr ="<root><SEARCH " ;
		xmlStr+= "bean_id  ='PHReportsBean' " ;
		xmlStr+= "bean_name = 'ePH.PHReportsBean' " ;
		xmlStr		    += " patient_id=\""+ patient_id + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ReportsValidate.jsp?called_from=patientsearch", false ) ;
		xmlHttp.send( xmlDoc ) ;
		eval(xmlHttp.responseText);
	} 
}

function chkpatID(yes_no){
	var frmObj = "";
	formObj=document.formPHRepPatFillCriteria;
	if(yes_no == "N"){
		alert(getMessage("PH_NOT_VALID_PATIENT","PH"));
		formObj.p_patient_id.value="";
		formObj.p_patient_id.focus();
	}
} //  ML-BRU-SCF-0498 [IN035593]  -- end

function Duplicatecheck(patientId){    /* Below code added for ML-BRU-SCF-0621[IN036565] -- Start */ 
	if((patientId.value != null) && (patientId.value !="")){
		var	bean_id			= "QueryPatientDrugProfileBean" ;
		var	bean_name		= "ePH.QueryPatientDrugProfileBean";
		var xmlStr ="<root><SEARCH ";	
		xmlStr+= "patientId=\"" + patientId.value + "\" " ;	
		xmlStr+= "chkPatientID=\"true\" " ;	
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
	var formobj =  document.formPHRepPatFillCriteria;
	if(formobj.p_pat_id.value != undefined && formobj.p_pat_id.value != "")
		formobj.p_pat_id.value=main_patientid;  
	else if(formobj.p_patient_id.value != undefined && formobj.p_patient_id.value != "")
		formobj.p_patient_id.value=main_patientid;   
}/* code added for ML-BRU-SCF-0621[IN036565] -- End */

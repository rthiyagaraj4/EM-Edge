/* New file MealAcknowledgeReportOPAndEM.js created against ML-MMOH-CRF-0413 [IN:057274] */

var allSelected = new Array();
function run()
{
	var frm=f_query_rep.document.forms[0];		
	var servDate=getLabel("eOT.ServingDate.Label","ot");
	var kitchen = getLabel("eOT.Kitchen.Label","ot");		
	var p_facility_id = frm.p_facility_id.value;
	var facility_id = frm.facility_id.value;
	var p_user_name = frm.p_user_name.value;
	var p_module_id = frm.p_module_id.value;
	var p_report_id = frm.p_report_id.value;
	var p_language_id = frm.p_language_id.value;
	var P_KITCHEN_CODE = frm.kitchen.value;
	var converDate = frm.servingDate.value;
	var PARAM1 = frm.servingDate.value;
	var locale = frm.locale.value;
	var locationList = frm.location;
	var p_location_code="";
	var p_patient_id = frm.patientId.value;
	
	if(p_patient_id.length>0 ){
			/*var xmldoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
			var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");*/
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlstr = "<root><SEARCH  /></root>";
			//xmldoc.loadXML(xmlstr);
			  xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
			xmlhttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=checkPatId&fromPatient="+p_patient_id+"&toPatient="+p_patient_id,false);
			xmlhttp.send(xmlDoc);
			var retVal = localTrimString(xmlhttp.responseText);
			var retValArr = retVal.split(":");
			if('Invalid' == retValArr[0]){
				alert("Invalid Patient ID");
			     return false ;
			}
			if('Invalid' == retValArr[1]){
				alert("Invalid  Patient ID");
			     return false ;
			}
	}
	
	var p_setStatus = frm.setStatusForAll.value;	
	var p_repType = frm.repType.value;
	var p_priority_Zone=frm.priorityZone.value;
	var p_treatement_Area=frm.treatmentArea.value;
	var p_speciality=frm.speciality.value;
	var speciality_element= frm.speciality;
	var p_speciality_desc = "";
	
	if(p_speciality!='' && p_speciality!="null" && p_speciality!="undefined"){
		p_speciality_desc = speciality_element.options[speciality_element.selectedIndex].text;
	}
	
	var p_mealOrder_For=frm.mealOrderFor.value;
	var count = 0;
	var allflag=false;
	for (var i = 0; i < locationList.options.length; i++){
		if (locationList.options[i].selected){
			count++;
		if (count == 1) 
		{
			if(locationList.options[i].value == ""){
				p_location_code = frm.document.getElementById("selectedAll").value;
				allflag=true;
			}
			else{
			p_location_code=p_location_code+'\''+locationList.options[i].value+'\'';
			}
		}
		else {
			if(locationList.options[i].value == ""){
				allflag=true;
			}
			p_location_code=p_location_code+',\''+locationList.options[i].value+'\'';
		}
		}
	}	
	if(allflag==true){
		frm.document.getElementById("selectedAll").value="";
	}
	locationList=frm.selectedAll.value;	
	
	//var p_meal_class = frm.mealClass.value;
	var p_meal_type = frm.mealType.value;
	var p_diet_type = frm.dietType.value;

		if(PARAM1.length<1){
			alert(servDate+" cannot be empty");
			return false;
		}

		if(P_KITCHEN_CODE.length<1){
			alert(kitchen+" cannot be empty");
			return false;
		}
	//frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+P_KITCHEN_CODE+"&PARAM1="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&locale="+locale+"&p_speciality="+p_speciality+"&p_location_code="+p_location_code+"&p_priority_Zone="+p_priority_Zone+"&p_treatement_Area="+p_treatement_Area+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&p_patient_id="+p_patient_id+"&p_setStatus="+p_setStatus+"&p_repType="+p_repType+"&p_mealOrder_For="+p_mealOrder_For;//409- US5 & 412-US5
	frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+P_KITCHEN_CODE+"&PARAM1="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&p_language_id="+locale+"&p_speciality="+p_speciality+"&p_location_code="+locationList+"&p_priority_Zone="+p_priority_Zone+"&p_treatement_Area="+p_treatement_Area+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&p_patient_id="+p_patient_id+"&p_setStatus="+p_setStatus+"&p_repType="+p_repType+"&p_mealOrder_For="+p_mealOrder_For+"&p_speciality_desc="+p_speciality_desc;//409- US5 & 412-US5
	frm.submit();
}


function reset() // Modified Against ML-MMOH-CRF-1818-37552...
{   
	//var formObj = parent.content.f_query_rep.MealAcknowledgeReport;
	//formObj.ward.options.length = 0;
	//formObj.reset();
	location.reload();
}

function setFieldToUpperCase(obj)
{
	obj.value = obj.value.toUpperCase();
	return obj;
}

function checkAlpha(event)
{
	var strCheck = '.~!@#$%^&*()+=`{}|[]<>"\'';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) != -1) return false;
	return true ;
}

function onSuccess()
{
	var params = document.forms[0].params.value;
	commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?&'+params;
	at_tab_frame.location.reload();
}

function checkDateValidate(da1)
{
	if(CheckDate(da1)==true)
	{
			var today = new Date();
			var mon = today.getMonth()+1;
			var da = today.getDate()+"/"+mon+"/"+today.getYear();
			if(da1.value!="" && da!="")
			{
				var chkDtVal = chkDt1Dt2(da,da1.value);
				if(!chkDtVal){
					var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArray = msg.split("#");
					var theatre_label = getLabel("eOT.ServingDate.Label","OT");
					var current_label = getLabel("Common.CurrentDate.label","common");
					return false;
				}
			}
		}
}

function checkForSpecCharsforID(event)
{
	    var strCheck = '0123456789/';
	    var whichCode = (window.Event) ? event.which : event.keyCode;
	    key = String.fromCharCode(whichCode);  // Get key value from key code
	    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
}

function isValidDate(obj)
{
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

function cal_error (str_message,obj) 
{
		alert(str_message);
		obj.focus();
		obj.select();
		return null;
}

function getCurrentServerDate(){
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="getCurrentServerDate";	
		
	var xmlStr ="<root></root>";
	var params="mode="+mode;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	var date=jsonObjResponse.CurrentDate;

	$("#servingDate").val(date[0].Server_Date);
	
}
function loadKitchen(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadKitchen_MealTicket";
	var facility_id=$('#facility_id').val();
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var kitchenList=new Array();
	kitchenList = jsonObjResponse.jsonKitchenList;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(kitchenList!=null && kitchenList!="undefined" && kitchenList!=""){
	for (var i = 0; i < kitchenList.length; i++) {
         listItems += "<option value='" + kitchenList[i].KitchenCode + "'>" + kitchenList[i].KitchenDesc + "</option>";
    }
	$("#kitchen").html(listItems);
	}
}


function loadMealClass(){
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadMealClass&facility="+facility_id;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var mealClassList=new Array();
	mealClassList = jsonObjResponse.MealClass;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(mealClassList!=null && mealClassList!="undefined" && mealClassList!=""){
	for (var i = 0; i < mealClassList.length; i++) {
         listItems += "<option value='" + mealClassList[i].Meal_Code + "'>" + mealClassList[i].Meal_Desc + "</option>";
    }
	$("#mealClass").html(listItems);
	
}else{
	$("#mealClass").html(listItems);
}
}
function restrictSpecialChars(event){
		var strCheck = '.~!@#$%^&*()+=`{}|[];:_-,/\\?<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
		return true ;
	}

function loadMealType(){
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	//var mealOrderFor="All";//60117
	var mealOrderFor=$("#mealOrderFor").val();//60117
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadMealType&facility="+facility_id+"&mealOrderFor="+mealOrderFor;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var mealTypeList=new Array();
	mealTypeList = jsonObjResponse.jsonMealTypeList;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(mealTypeList!=null && mealTypeList!="undefined" && mealTypeList!=""){
	for (var i = 0; i < mealTypeList.length; i++) {
         listItems += "<option value='" + mealTypeList[i].MealCode + "'>" + mealTypeList[i].MealDesc + "</option>";
    }
	$("#mealType").html(listItems);
	
}else{
	$("#mealType").html(listItems);
}
}
function loadDietType(){
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mealOrderFor="All";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadDietType&facility="+facility_id+"&mealOrderFor="+mealOrderFor;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var dietTypeList=new Array();
	dietTypeList = jsonObjResponse.jsonDietTypeList;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(dietTypeList!=null && dietTypeList!="undefined" && dietTypeList!=""){
	for (var i = 0; i < dietTypeList.length; i++) {
         listItems += "<option value='" + dietTypeList[i].DietCode + "'>" + dietTypeList[i].DietDesc + "</option>";
    }
	$("#dietType").html(listItems);
	
}else{
	$("#dietType").html(listItems);
}
}


function loadSpecialty(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadSpecialty";
	var facility_id=$('#facility_id').val();
	var kitchenCode=$('#kitchen').val();
	var kitchenTo=$('#kitchen').val();
	var mealOrderFor=$('#mealOrderFor').val();
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	params+="&kitchenCode="+kitchenCode;
	params+="&kitchenCodeTo="+kitchenTo;
	params+="&mealOrderFor="+mealOrderFor;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');	
	
	var SpecialtyList=new Array();
	SpecialtyList = jsonObjResponse.jsonSpecialityList;
	
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(SpecialtyList!=null && SpecialtyList!="undefined" && SpecialtyList!=""){
	for (var i = 0; i < SpecialtyList.length; i++) {
         listItems += "<option value='" + SpecialtyList[i].SpecialityCode + "'>" + SpecialtyList[i].SpecialityDesc + "</option>";
    }
	$("#speciality").html(listItems);
	}else{
	$("#speciality").html(listItems);
	}
}

function loadWards(obj){
	var kitchenCode = obj;	
	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "mode=loadWards&facility="+facility_id+"&kitchenCode="+kitchenCode;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var wardList=new Array();
	wardList = jsonObjResponse.Ward;
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(wardList!=null && wardList!="undefined" && wardList!=""){
	for (var i = 0; i < wardList.length; i++) {
         listItems += "<option value='" + wardList[i].Ward_Code + "'>" + wardList[i].Ward_Desc + "</option>";
    }
	$("#ward").html(listItems);
	
}else{
	$("#ward").html(listItems);
}
}

function loadLocation(){

	var facility_id=$('#facility_id').val();
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var mealOrderFor=$("#mealOrderFor").val();
	var specialityCodes=$("#speciality").val();
	var kithcenCode=$("#kitchen").val();
	var params = "mode=loadLocation&facilityid="+facility_id+"&mealOrderFor="+mealOrderFor+"&specialityCodes="+specialityCodes+"&specialityCodesTo="+specialityCodes+"&kithcenCodeFrom="+kithcenCode+"&kithcenCodeTo="+kithcenCode;
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var locationList=new Array();
	locationList = jsonObjResponse.jsonLocationList;
	//var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	$("#selectedAll").val("");
	var listItems = '';
	if(locationList!=null && locationList!="undefined" && locationList!=""){
		listItems="<option selected='selected' value=''>All</option>";
	for (var i = 0; i < locationList.length; i++) {
         listItems += "<option value='" + locationList[i].LocationCode + "'>" + locationList[i].LocationDesc + "</option>";
    }
	$("#location").html(listItems);	
}else{
	// Added Against ML-MMOH-CRF-1818-37552...starts
	var listItems = '<option selected="selected" value="">-----'+getLabel(
	"eOT.select.Label","eOT")+'-----</option>';
	$("#location").html(listItems);
	// Added Against ML-MMOH-CRF-1818-37552...ends
}
}
function disableEMFields(mealOrderFor) {
		if(mealOrderFor=='OP') {
			document.getElementById("priorityZone").value="";
			document.getElementById("priorityZone").disabled=true;
			document.getElementById("treatmentArea").value="";
			document.getElementById("treatmentArea").disabled=true;
		}
		else {
			document.getElementById("priorityZone").disabled=false;
			document.getElementById("treatmentArea").disabled=false;
		}
	}
function selectAll(selectedAll){
		var selectedValues = $('#location').val();
		var selectedValuesAll="";
		selectedValues=selectedValues.toString();
				
		selectedValuesAll = selectedValues.replace(/,/g, "','");
		selectedValues = "'"+selectedValues.replace(/,/g, "','")+"'";
		//alert("selectedValuesAll-->"+selectedValuesAll);
		$('#selectedAll').val(selectedValuesAll);
		/*var formObj = parent.frames[1].document.forms[0];
		var locationObj = formObj.location;
		if(selectedAll == "All"){
			var k=0;
			for(i=1;i<locationObj.length;i++){
				allSelected[k] = ""+'\''+locationObj.options[i].value+'\'';
				k++;
			}
			document.getElementById("selectedAll").value = allSelected;
		}else
			return;*/
	}
function loadPriorityZone() {
	
				var kitchenFrom=$('#kitchen').val();
				var kitchenTo=$('#kitchen').val();
				var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
				//if(kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
				
				var selectedValues = $('#location').val();
				var selectedValuesAll="";
				if(selectedValues==null){
					selectedValues="";
				}
				
				selectedValues=selectedValues.toString();
				selectedValuesAll = selectedValues.replace(/,/g, "','");
				selectedValues = "'"+selectedValues.replace(/,/g, "','")+"'";

				
				var facility = document.getElementById("facility_id").value;
				var locationList=selectedValuesAll;
				
				var formObj = parent.frames[1].document.forms[0];
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				var priorityZone = formObj.priorityZone;
				
				while(priorityZone.length > 0){
					priorityZone.remove(0);
				}
				var listOption	= document.createElement('option');
				listOption.value = "";
				listOption.text = "----select----";
				priorityZone.add(listOption);		
				$("#selectedAll").val(selectedValuesAll);
				var params = "mode=loadPriorityZone&facility="+facility+"&locationList="+locationList;
			
				xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = xmlHttp.responseText;

				var jsonObjResponse=eval('(' + retVal + ')');		
			
				var PriorityList=new Array();
				PriorityList = jsonObjResponse.jsonPriorityZone;
			
				
				//if(PriorityList!=null && PriorityList!='undefined' && PriorityList!="" && kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
				if(PriorityList!=null && PriorityList!='undefined' && PriorityList!="" ){
			
				for (var i = 0; i < PriorityList.length; i++) {
				 listItems += "<option value='" + PriorityList[i].PriorityZoneCode + "'>" + PriorityList[i].PriorityZoneDesc + "</option>";
				}
				$("#priorityZone").html(listItems);
				//$("#priorityZoneTo").html(listItems);
				}
				else{
				listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
				$("#priorityZone").html(listItems);
				//$("#priorityZone").html(listItems);
				}
				
				/*}else{
				listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
				$("#priorityZone").html(listItems);
				//$("#priorityZone").html(listItems);
					
				}*/
			

	}
	function loadTreatmentArea(){
	var kitchenFrom=$('#kitchen').val();
	var kitchenTo=$('#kitchen').val();
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	//if(kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadTreatmentArea";
	var facility_id=$('#facility_id').val();
	var selectedValues = $('#location').val();
	if(selectedValues==null){
		selectedValues="";
	}
	selectedValues=selectedValues.toString();
	
	selectedValues = selectedValues.replace(/,/g, "','");
	var locationList=selectedValues;
	var priorityZone=$('#priorityZone').val();
	var priorityZoneTo=$('#priorityZone').val();
	
	var xmlStr ="<root></root>";
	var params="mode="+mode;
	params+="&facility="+facility_id;
	params+="&locationList="+locationList;
	params+="&priorityZone="+priorityZone;
	params+="&priorityZoneTo="+priorityZoneTo;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	var jsonObjResponse=eval('(' + retVal + ')');
	var TreatmentAreaList=new Array();
	TreatmentAreaList = jsonObjResponse.jsonTreatmentAreaList;

	//if(TreatmentAreaList!=null && TreatmentAreaList!='undefined' && TreatmentAreaList!="" && kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
	if(TreatmentAreaList!=null && TreatmentAreaList!='undefined' && TreatmentAreaList!=""){
	
	for (var i = 0; i < TreatmentAreaList.length; i++) {
         listItems += "<option value='" + TreatmentAreaList[i].treatment_area_code + "'>" + TreatmentAreaList[i].short_desc + "</option>";
    }
	$("#treatmentArea").html(listItems);
	//$("#treatmentAreaTo").html(listItems);
	
	}else{
	listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	$("#treatmentArea").html(listItems);
	//$("#treatmentAreaTo").html(listItems);
	}
	/*}else{
			listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
			$("#treatmentArea").html(listItems);
			//$("#treatmentAreaTo").html(listItems);				
		}*/
}	

function localTrimString(sInString)
{
	  return sInString.replace(/^\s+|\s+$/g,"");
}

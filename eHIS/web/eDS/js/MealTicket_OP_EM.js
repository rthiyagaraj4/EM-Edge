/* Added this MealTicket_OP_EM.js for MMOH-CRF-407 */
async function run()
{
		var frm=f_query_rep.document.forms[0];
		var servDate=getLabel("Common.date.label","common");//58126
		var kitchenFrom = getLabel("eOT.Kitchen.Label","ot");
		var kitchenTo = getLabel("eOT.Kitchen.Label","ot");
		var frmPatient = frm.patientIdFrom.value;
		var toPatient = frm.patientIdTo.value;
		if(frmPatient.length>0 || toPatient.length>0){
			var xmlHttp = new XMLHttpRequest();
			var xmlstr = "<root><SEARCH  /></root>";
			var xmlDoc = new DOMParser().parseFromString(xmlstr, "text/xml");
			xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?func_mode=checkPatId&fromPatient="+frmPatient+"&toPatient="+toPatient,false);
			xmlHttp.send(xmlDoc);
			var retVal = await localTrimString(xmlHttp.responseText);
			var retValArr = retVal.split(":");
			if('Invalid' == retValArr[0]){
				alert("Invalid From Patient ID");
			     return false ;
			}
			if('Invalid' == retValArr[1]){
				alert("Invalid To Patient ID");
			     return false ;
			}
		}

					var p_facility_id = frm.p_facility_id.value;
					var p_user_name = frm.p_user_name.value;
					var p_module_id = frm.p_module_id.value;
					var p_report_id = frm.p_report_id.value;
					var p_language_id = frm.p_language_id.value;
					var facility_id = frm.facility_id.value;
					var locale = frm.locale.value;
					var datepattrn = frm.datepattrn.value;
					var conDate = "";
					
					var nd_serv_date = frm.servingDate.value;
					var nd_fm_kitchen_code=frm.kitchenFrom.value;
					var nd_to_kitchen_code=frm.kitchenTo.value;
					var nd_fm_specilaity=frm.SpecialtyFrom.value;
					var nd_to_specilaity=frm.SpecialtyTo.value;
					var nd_fm_Pri_zone=frm.priorityZone.value;
					var nd_to_Pri_zone=frm.priorityZoneTo.value;
					var nd_fm_trtment_zone=frm.treatmentAreaFrom.value;
					var nd_to_trtment_zone=frm.treatmentAreaTo.value;
					var nd_fm_meal_type=frm.mealTypeFrom.value;
					var nd_to_meal_type=frm.mealTypeTo.value;
					var nd_fm_diet_type=frm.dietTypeFrom.value;
					var nd_to_diet_type=frm.dietTypeTo.value;
					var nd_fr_pat_id=frm.patientIdFrom.value;
					var nd_to_pat_id=frm.patientIdTo.value;
					var nd_patient_class=frm.mealOrderFor.value;
					var nd_location=frm.selectedAll.value;
					var p_user=frm.p_user.value;
					var customer_id=frm.customer_id.value;
					/*if(customer_id == 'WCH'){
					var p_diet_category=frm.dietCategory.value;//Added aginst CRF-0782
					}
					else{
					p_diet_category ='';
					}*/
					var parameter="&nd_serv_date="+nd_serv_date+"&nd_fm_kitchen_code="+nd_fm_kitchen_code+"&nd_to_kitchen_code="+nd_to_kitchen_code+"&nd_fm_specilaity="+nd_fm_specilaity+"&nd_to_specilaity="+nd_to_specilaity+"&nd_location="+nd_location+"&nd_fm_Pri_zone="+nd_fm_Pri_zone+"&nd_to_Pri_zone="+nd_to_Pri_zone+"&nd_fm_trtment_zone="+nd_fm_trtment_zone+"&nd_to_trtment_zone="+nd_to_trtment_zone+"&nd_fm_meal_type="+nd_fm_meal_type+"&nd_to_meal_type="+nd_to_meal_type+"&nd_fm_diet_type="+nd_fm_diet_type+"&nd_to_diet_type="+nd_to_diet_type+"&nd_fr_pat_id="+nd_fr_pat_id+"&nd_to_pat_id="+nd_to_pat_id+"&nd_patient_class="+nd_patient_class;//Modified Against Crf-0782				
									
					
				if(nd_serv_date.length<1){
					alert(servDate+" cannot be empty");
					return false;
				}

				if(nd_fm_kitchen_code.length<1){
					alert(kitchenFrom+" cannot be empty");
					return false;
				}

				if(nd_to_kitchen_code.length<1){
					alert(kitchenTo+" cannot be empty");
					return false;
				}

	
				frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_user="+encodeURIComponent(p_user)+"&facility_id="+facility_id+
							"&locale="+locale+""+parameter;
							
				frm.submit();
	
}


function reset()
{        // Modified Against ML-MMOH-CRF-1818-37552
	 //var formObj = parent.content.f_query_rep.MealStatisticsOPAndEMReport;
	 
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
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
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
					alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
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
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
}

function chkDt1Dt2(d1,d2)
{
		var d1Arr = d1.split("/");
		var d2Arr = d2.split("/");
		if(parseInt(d2Arr[2])<parseInt(d1Arr[2])){
			return false;
		}
		else if(parseInt(d2Arr[2])==parseInt(d1Arr[2])){
			if(parseInt(d2Arr[1])<parseInt(d1Arr[1])){
					return false;
			}
			else if(parseInt(d2Arr[1])==parseInt(d1Arr[1])){
				if(parseInt(d2Arr[0])<parseInt(d1Arr[0])){
					return false;
				}
				else{
					return true;
				}
			}
			else{
				return true;
			}
		}
		else{
			return true;
		}

}

function localTrimString(sInString)
{
	  return sInString.replace(/^\s+|\s+$/g,"");
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
	$("#kitchenFrom").html(listItems);
	$("#kitchenTo").html(listItems);
	}
}
function loadSpecialty(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadSpecialty";
	var facility_id=$('#facility_id').val();
	var kitchenFrom=$('#kitchenFrom').val();
	var kitchenTo=$('#kitchenTo').val();
	var mealOrderFor=$('#mealOrderFor').val();
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	params+="&kitchenCode="+kitchenFrom;
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
	$("#SpecialtyFrom").html(listItems);
	$("#SpecialtyTo").html(listItems);
	}

}
function disableEMFields(mealOrderFor) {
		if(mealOrderFor=='OP') {
			//$('#priorityZoneFrom').prop('disabled',true);
			$('#priorityZone').prop('disabled',true);
			$('#priorityZoneTo').prop('disabled',true);
			$('#treatmentAreaFrom').prop('disabled',true);
			$('#treatmentAreaTo').prop('disabled',true);
			
			$('#priorityZone').val('');
			$('#priorityZoneTo').val('');
			$('#treatmentAreaFrom').val('');
			$('#treatmentAreaTo').val('');
			
		}
		else {
			//$('#priorityZoneFrom').prop('disabled',false);
			$('#priorityZone').prop('disabled',false);
			$('#priorityZoneTo').prop('disabled',false);
			$('#treatmentAreaFrom').prop('disabled',false);
			$('#treatmentAreaTo').prop('disabled',false);
	
		}
	}

function loadLocation(){

	$("#selectedAll").val("");//For Loacation not getting reseted
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadLocation";
	var facility_id=$('#facility_id').val();
	var kitchenFrom=$('#kitchenFrom').val();
	var kitchenTo=$('#kitchenTo').val();
	var mealOrderFor=$('#mealOrderFor').val();
	var speciality=$('#SpecialtyFrom').val();
	var specialityTo=$('#SpecialtyTo').val();
	
	
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	params+="&kithcenCodeFrom="+kitchenFrom;
	params+="&kithcenCodeTo="+kitchenTo;
	params+="&mealOrderFor="+mealOrderFor;
	params+="&specialityCodes="+speciality;
	params+="&specialityCodesTo="+specialityTo;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	
	var LocationList=new Array();
	LocationList = jsonObjResponse.jsonLocationList;
	
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(LocationList!=null && LocationList!="undefined" && LocationList!="" && kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){

	for (var i = 0; i < LocationList.length; i++) {
         listItems += "<option value='" + LocationList[i].LocationCode + "'>" + LocationList[i].LocationDesc + "</option>";
    }
	$("#location").html(listItems);
	}else{  // Added Against ML-MMOH-CRF-1818-37552...starts
	var listItems = '<option selected="selected" value="">-----'+getLabel(
	"eOT.select.Label","eOT")+'-----</option>';
	$("#location").html(listItems);
	// Added Against ML-MMOH-CRF-1818-37552...starts
	}
	}
	
	function selectAll(selectedAll){
		var formObj = parent.frames[1].document.forms[0];
		var locationObj = formObj.location;
		if(selectedAll == "All"){
			var k=0;
			for(i=1;i<locationObj.length;i++){
				allSelected[k] = ""+'\''+locationObj.options[i].value+'\'';
				k++;
			}
			document.getElementById("selectedAll").value = allSelected;
		}else
			return;
	}
	function getSelectedLocations() {
		var count = 0;
		var formObj = parent.frames[1].document.forms[0];
		var locationObj = formObj.location;
		var selectedLocations="";
		
		for (var i = 0; i < locationObj.options.length; i++){
		  if (locationObj.options[i].selected){
			  count++;
			  if (count == 1) {
				  if(locationObj.options[i].value == "All"){
					  selectedLocations = document.getElementById("selectedAll").value;
				  }else{
					  selectedLocations=selectedLocations+'\''+locationObj.options[i].value+'\'';
				  }
			  }
			  else {
				  selectedLocations=selectedLocations+',\''+locationObj.options[i].value+'\'';
			  }
		  }
		}
		
		if(count==0) {
			var k=0;
			var selectAllArr=new Array();
			for(i=1;i<locationObj.options.length;i++){
				selectAllArr[k] = ""+'\''+locationObj.options[i].value+'\'';
				k++;
			}			
			selectedLocations = selectAllArr;
		}
		return selectedLocations;
	}
	
	
	function getPriorityZone() {
	
				var kitchenFrom=$('#kitchenFrom').val();
				var kitchenTo=$('#kitchenTo').val();
				var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
				if(kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
				
				var selectedValues = $('#location').val();
				var selectedValuesAll="";
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
			
				
				if(PriorityList!=null && PriorityList!='undefined' && PriorityList!="" && kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
			
				for (var i = 0; i < PriorityList.length; i++) {
				 listItems += "<option value='" + PriorityList[i].PriorityZoneCode + "'>" + PriorityList[i].PriorityZoneDesc + "</option>";
				}
				$("#priorityZone").html(listItems);
				$("#priorityZoneTo").html(listItems);
				}
				else{
				listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
				$("#priorityZone").html(listItems);
				$("#priorityZoneTo").html(listItems);
				}
				
				}else{
				listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
				$("#priorityZone").html(listItems);
				$("#priorityZoneTo").html(listItems);
					
				}
			

	}
	
function loadMealType(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadMealType";
	var facility_id=$('#facility_id').val();
	var kitchenFrom=$('#kitchenFrom').val();
	var kitchenTo=$('#kitchenTo').val();
	var mealOrderFor=$('#mealOrderFor').val();
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	params+="&facilityid="+facility_id;
	params+="&kitchenCode="+kitchenFrom;
	params+="&kitchenCodeTo="+kitchenTo;
	params+="&mealOrderFor="+mealOrderFor;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	var MealTypeList=new Array();
	MealTypeList = jsonObjResponse.jsonMealTypeList;
	
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	
	for (var i = 0; i < MealTypeList.length; i++) {
         listItems += "<option value='" + MealTypeList[i].MealCode + "'>" + MealTypeList[i].MealDesc + "</option>";
    }
	$("#mealTypeFrom").html(listItems);
	$("#mealTypeTo").html(listItems);

	
	}
	function loadDietType(){
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadDietType";
	var facility_id=$('#facility_id').val();
	var kitchenFrom=$('#kitchenFrom').val();
	var kitchenTo=$('#kitchenTo').val();
	var mealOrderFor=$('#mealOrderFor').val();
	var xmlStr ="<root></root>";
	
	var params="mode="+mode;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	
	var DietTypeList=new Array();
	DietTypeList = jsonObjResponse.jsonDietTypeList;
	
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	for (var i = 0; i < DietTypeList.length; i++) {
         listItems += "<option value='" + DietTypeList[i].DietCode + "'>" + DietTypeList[i].DietDesc + "</option>";
    }
	$("#dietTypeFrom").html(listItems);
	$("#dietTypeTo").html(listItems);
	
	}
	
	function getTreatmentArea(){
	
	var kitchenFrom=$('#kitchenFrom').val();
	var kitchenTo=$('#kitchenTo').val();
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	if(kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="loadTreatmentArea";
	var facility_id=$('#facility_id').val();
	var selectedValues = $('#location').val();

	selectedValues=selectedValues.toString();
	selectedValues = selectedValues.replace(/,/g, "','");
	var locationList=selectedValues;
	var priorityZone=$('#priorityZone').val();
	var priorityZoneTo=$('#priorityZoneTo').val();
	
	
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

	if(TreatmentAreaList!=null && TreatmentAreaList!='undefined' && TreatmentAreaList!="" && kitchenFrom!=''&& kitchenFrom!=null && kitchenFrom!="undefined" && kitchenTo!=null && kitchenTo!="undefined" && kitchenTo!=''){
	for (var i = 0; i < TreatmentAreaList.length; i++) {
         listItems += "<option value='" + TreatmentAreaList[i].treatment_area_code + "'>" + TreatmentAreaList[i].short_desc + "</option>";
    }
	$("#treatmentAreaFrom").html(listItems);
	$("#treatmentAreaTo").html(listItems);
	
	}else{
	listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	$("#treatmentAreaFrom").html(listItems);
	$("#treatmentAreaTo").html(listItems);
	}
	}else{
			listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
			$("#treatmentAreaFrom").html(listItems);
			$("#treatmentAreaTo").html(listItems);
				
				}
	}
	function getCurrentServerDate(){
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var mode="getCurrentServerDate";
	var facility_id=$('#facility_id').val();
	var selectedValues = $('#location').val();
		
	var xmlStr ="<root></root>";
	var params="mode="+mode;
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.MealTicketServlet?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;
	
	var jsonObjResponse=eval('(' + retVal + ')');
	var date=jsonObjResponse.CurrentDate;
	
	$('#servingDate').val(date[0].Server_Date);
	}
	

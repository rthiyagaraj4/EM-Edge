

	var allSelected = new Array();
	function run() {
		var frm=f_query_rep.document.forms[0];
		//var fields = new Array (frm.servingDate,frm.kitchen);
		var servDate=getLabel("eOT.ServingDate.Label","ot");
		var kitchen = getLabel("eOT.Kitchen.Label","ot");
		//var tab_id = frm.tab_id.value;
		//var names = new Array (servDate,kitchen);
		/*var today = new Date();
		var mon = today.getMonth()+1;
		var da = today.getDate()+"/"+mon+"/"+today.getYear();
		var chkDtVal = chkDt1Dt2(da,frm.servingDate.value);
		if(!chkDtVal){
			var msg = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
			var msgArray = msg.split("#");
			var theatre_label = getLabel("eOT.ServingDate.Label","OT");
			var current_label = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
			return false;
		}*/
		//if(checkFieldsofMst( fields, names, messageFrame))
		//{
				//if(tab_id=='GenerateMealPlanPrint'){
					var p_facility_id = frm.p_facility_id.value;
					var facility_id = frm.facility_id.value;
					var p_user_name = frm.p_user_name.value;
					var p_module_id = frm.p_module_id.value;
					var p_report_id = frm.p_report_id.value;
					var p_language_id = frm.p_language_id.value;
					var P_KITCHEN_CODE = frm.kitchen.value;
					var converDate = frm.servingDate.value;
					var PARAM1 = frm.servingDate.value;
					var datepattrn = frm.datepattrn.value;
					var locale = frm.locale.value;
					var locationList = frm.location;
					var speciality=frm.speciality.value;
					var priorityZone=frm.priorityZone.value;
					var treatmentArea=frm.treatmentArea.value;
					var patientClass=frm.mealOrderFor.value;
					var p_searchfor = frm.SearchFor.value;//ML-MMOH-CRF-0825 - US08
					
					//var p_ward_code = [];
					var p_ward_code="";
					var count = 0;
					for (var i = 0; i < locationList.options.length; i++){
					  if (locationList.options[i].selected){
						  count++;
						  if (count == 1) {
							  if(locationList.options[i].value == "All"){
								  p_ward_code = f_query_rep.document.getElementById("selectedAll").value;
							  }else{
								  p_ward_code=p_ward_code+'\''+locationList.options[i].value+'\'';
							  }
						  }
						  else {
							  p_ward_code=p_ward_code+',\''+locationList.options[i].value+'\'';
						  }
					  }
					}
//					var p_meal_class = frm.mealClass.value;
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
				frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&p_kitchen_code="+P_KITCHEN_CODE+"&P_SERVING_DATE="+PARAM1+"&converDate="+converDate+"&facility_id="+facility_id+"&locale="+locale+"&p_ward_code="+p_ward_code+"&P_PAT_PRIORITY="+priorityZone+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&P_TREATMENT_AREA="+treatmentArea+"&P_SPECIALITY="+speciality+"&P_PATIENT_CLASS="+patientClass+"&P_PATIENT_ID="+"&p_searchfor="+p_searchfor;
				frm.submit();
		//}
	}

// modified by N Munisekhar on 20-May-2013 against [IN039994]
	 function reset(){ // Added Against ML-MMOH-CRF-1818-37552...
	   //var formObj = parent.content.f_query_rep.MealOrderReport;
	   //formObj.location.options.length = 0;
	   //formObj.reset();
	   f_query_rep.location.reload();
	}

	function setFieldToUpperCase(obj) {
		obj.value = obj.value.toUpperCase();
		return obj;
	}

	function checkAlpha(event){
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);
		if (strCheck.indexOf(key) != -1) return false;
		return true ;
	}

	function onSuccess()
	{
		//commontoolbarFrame.location.reload();
		//window.location.reload();
		//messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?0="+"Operation Completed Sucessfully" ;
		var params = document.forms[0].params.value;
		commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?&'+params;
		at_tab_frame.location.reload();

	}

	function checkDateValidate(da1) {

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

	function cal_error (str_message,obj) {
		alert (str_message);
		//obj.focus();
		//obj.select();
		obj.value="";
		return null;
	}

	function chkDt1Dt2(d1,d2){
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
	
	function getSpeciality(){
		var kitchenCode = document.getElementById("kitchen").value;
		var facility = document.getElementById("facility_id").value;
		var formObj = parent.frames[1].document.forms[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=getSpeciality&facility="+facility+"&kitchenCode="+kitchenCode;
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var speciality = formObj.speciality;
		while(speciality.length > 0){
			speciality.remove(0);
		}
		var listOption	= document.createElement('option');
		listOption.value = "";
		listOption.text = "----select----";
		speciality.add(listOption);		
		if(retVal != null && retVal != ""){
			var retValArr = retVal.split("???");
			if(retValArr!=''){
				for(var i=0; i<retValArr.length; i++){
					var specialityCodes = retValArr[i].split(":::");
					var listOption1	= document.createElement('option');
						listOption1.value = specialityCodes[0];
						listOption1.text = specialityCodes[1];
						speciality.add(listOption1);
				}
			}
		}
	}

	function getLocation(){
		var facility = document.getElementById("facility_id").value;
		var speciality = document.getElementById("speciality").value;
		var mealOrderFor=document.getElementById("mealOrderFor").value;
		var specialityCodes="";
		var formObj = parent.frames[1].document.forms[0];
		var specialityObj = formObj.speciality;
		
		if(speciality==""){
			for(var i=0;i<specialityObj.length;i++) {
				var value=document.getElementById('speciality').options[i].value;
				if(value!=""){
					if(specialityCodes!=""){specialityCodes=specialityCodes+",'"+value+"'";}
					else {specialityCodes=specialityCodes+"'"+value+"'";}
				}
			}
			
		}
		else {specialityCodes="'"+speciality+"'";}
		
		if(specialityCodes=="") {
			var locationObj = formObj.location;
			while(locationObj.length > 0){
				locationObj.remove(0);
			} 
			// Added Against ML-MMOH-CRF-1818-37552...starts
			var listOption	= document.createElement('option');
				listOption.text = getLabel("eOT.select.Label","eOT");
				 locationObj.add(listOption);
				 // Added Against ML-MMOH-CRF-1818-37552...ends
		
		}
		
		else{
		
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			var params = "func_mode=getLocation&facility="+facility+"&mealOrderFor="+mealOrderFor+"&specialityCodes="+specialityCodes;
			xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var locationObj = formObj.location;
			while(locationObj.length > 0){
				locationObj.remove(0);
			}
			if(retVal != null && retVal != ""){
				var retValArr = retVal.split("???");
				if(retValArr!=''){
					var listOption	= document.createElement('option');
					listOption.value = "All";
					listOption.text = "All";
					locationObj.add(listOption);
					
					for(var i=0; i<retValArr.length; i++){
						var locationCodes = retValArr[i].split(":::");
						var listOption1	= document.createElement('option');
							listOption1.value = locationCodes[0];
							listOption1.text = locationCodes[1];
							locationObj.add(listOption1);
					}
				}
			}else{
				// Added Against ML-MMOH-CRF-1818-37552...starts
			 var listOption	= document.createElement('option');
				listOption.text = getLabel("eOT.select.Label","eOT");
				 locationObj.add(listOption);
		         // Added Against ML-MMOH-CRF-1818-37552...ends
				 }
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
	
	function getSelectedLocations() {
		var count = 0;
		var formObj = parent.frames[1].document.forms[0];
		var locationObj = formObj.location;
		var selectedLocations="";
		
		for (var i = 0; i < locationObj.options.length; i++){
		  if (locationObj.options[i].selected){
			  count++;
//			  p_ward_code.push(wardList.options[i].value);
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
	
	function getTreatmentArea() {
		var facility = document.getElementById("facility_id").value;
		var locationList=getSelectedLocations();
		var priorityZone = document.getElementById("priorityZone").value;
		
		var formObj = parent.frames[1].document.forms[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var treatmentArea = formObj.treatmentArea;
		
		while(treatmentArea.length > 0){
			treatmentArea.remove(0);
		}
		
		var listOption	= document.createElement('option');
		listOption.value = "";
		listOption.text = "----select----";
		treatmentArea.add(listOption);		
		
		if(locationList!="") {
			var params = "func_mode=getTreatmentArea&facility="+facility+"&locationList="+locationList+"&priorityZone="+priorityZone;
			xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
/*			while(treatmentArea.length > 0){
				treatmentArea.remove(0);
			}*/
			if(retVal != null && retVal != ""){
				var retValArr = retVal.split("???");
				if(retValArr!=''){
					for(var i=0; i<retValArr.length; i++){
						var treatmentAreaCodes = retValArr[i].split(":::");
						var listOption1	= document.createElement('option');
							listOption1.value = treatmentAreaCodes[0];
							listOption1.text = treatmentAreaCodes[1];
							treatmentArea.add(listOption1);
					}
				}
			}
		}
	}
	
	function getPriorityZone() {
		var facility = document.getElementById("facility_id").value;
		var locationList=getSelectedLocations();
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
		
		if(locationList!="") {
			var params = "func_mode=getPriorityZone&facility="+facility+"&locationList="+locationList;
			xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
/*			while(priorityZone.length > 0){
				priorityZone.remove(0);
			}*/
			if(retVal != null && retVal != ""){
				var retValArr = retVal.split("???");
				if(retValArr!=''){
					for(var i=0; i<retValArr.length; i++){
						var priorityZoneCodes = retValArr[i].split(":::");
						var listOption1	= document.createElement('option');
							listOption1.value = priorityZoneCodes[0];
							listOption1.text = priorityZoneCodes[1];
							priorityZone.add(listOption1);
					}
				}
			}
		}
	}
	
	function getMealTypes() {
		var facility = document.getElementById("facility_id").value;
		var mealOrder=document.getElementById("mealOrderFor").value;
		var formObj = parent.frames[1].document.forms[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var mealType = formObj.mealType;
		
		while(mealType.length > 0){
			mealType.remove(0);
		}
		
			var params = "func_mode=getMealType_MealOrder&facility="+facility+"&mealOrder="+mealOrder;
			xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			while(mealType.length > 0){
				mealType.remove(0);
			}
			var listOption	= document.createElement('option');
			listOption.value = "";
			listOption.text = "----select----";
			mealType.add(listOption);
			
			if(retVal != null && retVal != ""){
				var retValArr = retVal.split("???");
				if(retValArr!=''){
					for(var i=0; i<retValArr.length; i++){
						var mealTypeCodes = retValArr[i].split(":::");
						var listOption1	= document.createElement('option');
							listOption1.value = mealTypeCodes[0];
							listOption1.text = mealTypeCodes[1];
							mealType.add(listOption1);
					}
				}
			}
	}	

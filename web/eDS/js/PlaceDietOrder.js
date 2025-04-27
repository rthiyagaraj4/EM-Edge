	var returnRemarks = null;
	var referrToDietcian = null; //Refer to Dietician IN 42110
	var diet_Category = '';
	var ageGroupArr = new Array();
	var ageGroupArr1 = new Array();
	var fecthedDietTypes = new Array();
	var fecthedMealTypes = new Array();
	var fetchedMealTypesWithTime = new Array();//409
	var mealTypesForDisCharge = new Array();
	var delFoodDisList = new Array();
	var delFoodDis = new Array();
	var chkFormValChange = false;
	var closeWindowFlag = false;
	//409
	var excludedMeals={};
	var irregular_meal_flag=false;
	var irregular_meal_code="";
	var Menu_Flag=true;
	//409
	var automatic_excluded_meal_types=new Array();//428
	var Org_dietType="";//MMS-DM-0006
	var modified_dietType ="";
	var DietTypeModified_YN='N';//MMS-DM-0006
	var Full_Day_NBM_YN=false//CRF-410
	var OrigAssignedDietTypes=new Array();
	var exclusionFlag=false;
	var referrToDietcianFlag=false;//428
	var JSONobj={};//ML-MMOH-CRF-0412
	var isMealMenuDisplay =""//KDAH-CRF-0352-US4
	var p1="",p2="",p3="",p4="",p5="",p6="",p7="",p8="",p9="",p10="",p11="",p12="",p13="",p14="",p15="",p16="",p17="";//CRF-410
	function fecthDietType(val)
	{		
		diet_Category = val;
		//KDAH-CRF-0349-US05 Start
		if(diet_Category==undefined || diet_Category=="undefined"){						
			diet_Category = document.getElementById("dietCategory1");
		}
		//KDAH-CRF-0349-US05 End
		
		var patientClass =document.getElementById("patientClass").value; // Added for ML-MMOH-CRF-0820
		var diettype_auto=document.getElementById("diettype_auto").value;//Added Against ML-MMOH-CRF-0674
		var language_Id =document.getElementById("languageId").value;
		var ageGroup = parent.document.getElementById("dateOfBirth").value;

		if(parseInt(ageGroup.length)<11)
			ageGroup=ageGroup+" 00:00";
		var gender =  parent.document.getElementById("gender").value;
		if(gender=="Male")
			gender='M'
		else if(gender=="Female")
			gender='F'
		var ageGroupArray = new Array();
		ageGroupArray	=  ageGroup.split(" ");
		ageGroupArray1	=	ageGroupArray[0].split("/");
		today=new Date();
		//var dob=new Date(ageGroupArray1[2], ageGroupArray1[1], ageGroupArray1[0]);
		var dob=new Date(ageGroupArray1[2], ageGroupArray1[1]-1, ageGroupArray1[0]); //Modified Against ML-MMOH-SCF-1700 TF
		var one_day=1000*60*60*24;

		//Calculate difference btw the two dates, and convert to days
		var days1=Math.floor((dob.getTime()-today.getTime())/(one_day))+1;

		var year=365;
		var month=30;
		var years = parseInt(days1)/parseInt(year)
		days2=parseInt(days1)%parseInt(year)
		var months=Math.round(parseInt(days2)/parseInt(month));
		var days=Math.floor(parseInt(days2)%parseInt(month));

		var maxAge = '';
		var ageUnit = '';

		if( parseInt(Math.abs(years)) > 0){
			maxAge =  parseInt(Math.abs(years));
			ageUnit = 'Y';
		}else if(parseInt(Math.abs(months)) > 0){
			maxAge =  parseInt(Math.abs(months));
			ageUnit = 'M';
		}else if( parseInt(Math.abs(days)) > 0){
			maxAge =  parseInt(Math.abs(days));
			ageUnit = 'D';
		}
		var i=0;
		var parms="";
		var retVal = "";
		var code = 1;

		if(i<1)
		{
			var obj;
			obj = document.getElementById("dietType");
			
			while(obj.length > 0){			
				obj.remove(0);				
			}
			setTimeout("setTimeForDietTypesPop()", 1000);
			var mode = "fetchAgeGroupCode";
			var xmlDoc = "";
			var xmlHttp = new XMLHttpRequest();
			var xmlStr ="<root></root>";
			param="&gender="+gender+"&maxAge="+maxAge+"&ageUnit="+ageUnit+"&mode="+mode;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
			xmlHttp.send(xmlDoc);
			retVal = localTrimString(xmlHttp.responseText);
			ageGroupArr = retVal.split(',');
			
			for(var i=0; i < ageGroupArr.length; i++){
				ageGroupArr1[i] = ageGroupArr[i];
			}
			if(ageGroupArr1 != null)
			{
				var mode = "fecthDietTypes";
				var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root></root>";
				param="&language_Id="+language_Id+"&diet_Category="+diet_Category+"&ageGroupArr="+ageGroupArr1+"&mode="+mode+"&patientClass="+patientClass+"&diettype_auto="+diettype_auto; // Added patient_class for ML-MMOH-CRF-0820,Modified Against ML-MMOH-CRF-0674
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);				
				
			if(retVal != null && trim(retVal).length != 0){				
				fecthedDietTypes = retVal.split(',');
				var Entry = document.createElement("OPTION");
				var msg = "----select----";
				Entry.text = msg;
				Entry.value= "";
				obj.add(Entry);
				for(var j=0; j < fecthedDietTypes.length; j++){
					if(j % 2 == 0){
						var Entry = document.createElement("option");
						var msg = "----select----";
						Entry.text = msg;
						Entry.value= "";
						Entry.value  = trim(fecthedDietTypes[j]);
						Entry.text  = trim(fecthedDietTypes[j+1]);								
						obj.add(Entry);
						}
					}
			}else{			
					var Entry = document.createElement("OPTION");
					var msg = "----select----";
					Entry.text = msg;
					Entry.value= "";
					obj.add(Entry);
			}
			i++
		}
		}
		//Added Against ML-MMOH-CRF-0674 Starts Here
		var str=document.getElementById("dietType").value;
		var auto_flag=document.getElementById("auto_flag").value
	if(str == "" && auto_flag == "true")
	{
		var sel = document.getElementById('dietType');
		var len = sel.options.length;
		if(len <= 3)
			sel.setAttribute('size', len);
		else
			sel.setAttribute('size', 3);
	}
	else if(str != "" &&  auto_flag == "false2")
	{
		var sel = document.getElementById('dietTypes');
		var len = sel.options.length;
		if(len <= 3)
			sel.setAttribute('size', len);
		else
			sel.setAttribute('size', 3);
	}
	//Added Against ML-MMOH-CRF-0674 Ends Here
	}
	async function fecthDietTypes_Attendant(val) // MMS-QH-CRF-0190
	{
		var diettype_auto=document.getElementById("diettype_auto").value;//Added Against ML-MMOH-CRF-0674
		var dietCategory_att = val;
		var language_Id =document.getElementById("languageId").value;
		var obj;
		obj = document.getElementById("attendentDiet");
		while(obj.length > 0){
			obj.remove(0);
		}
		setTimeout("setTimeForDietTypesPop()", 1000);
		var mode = "fecthDietTypes_Attendant";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		param="&language_Id="+language_Id+"&diet_Category="+dietCategory_att+"&mode="+mode+"&diettype_auto="+diettype_auto;//Modified Against ML-MMOH-CRF-0674
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal =await localTrimString(xmlHttp.responseText);
		if(retVal != null && trim(retVal).length != 0){
		fecthedDietTypes = retVal.split(',');
		var Entry = document.createElement("OPTION");
		var msg = "----select----";
		Entry.text = msg;
		Entry.value= "";
		obj.add(Entry);
		for(var j=0; j < fecthedDietTypes.length; j++){
			if(j % 2 == 0){
				var Entry = document.createElement("option");
				var msg = "----select----";
				Entry.text = msg;
				Entry.value= "";
				Entry.value  = trim(fecthedDietTypes[j]);
				Entry.text  = trim(fecthedDietTypes[j+1]);
				obj.add(Entry);
				}
			}
		}else{
			var Entry = document.createElement("OPTION");
			var msg = "----select----";
			Entry.text = msg;
			Entry.value= "";
			obj.add(Entry);
		}
		//Added Against ML-MMOH-CRF-0674 Starts Here
	var str = document.getElementById('attendentDiet').value;
	var auto_flag=document.getElementById("auto_flag").value;
		
	if(str == "" && auto_flag == "true")
	{
	var sel = document.getElementById('attendentDiet');
	var len = sel.options.length;
	if(len <= 3)
	sel.setAttribute('size', len);
	else
	sel.setAttribute('size', 3);
	}
	else if(str != "" && auto_flag == "false2")
	{
	var sel = document.getElementById('attendentDiet');
	var len = sel.options.length;
	if(len <= 3)
	sel.setAttribute('size', len);
	else
	sel.setAttribute('size', 3);			
	}
	//Added Against ML-MMOH-CRF-0674 Ends Here
	}
	
	function getAttendDitypes(){
	var attendObj = document.getElementById("attendentDiet");
	while(attendObj.length > 0){
		attendObj.remove(0);
	}
	var Entry = document.createElement("option");
	var msg = "----select----";
	Entry.text = msg;
	Entry.value= "";
	attendObj.add(Entry);

	for(var j=0; j < fecthedDietTypes.length; j++){
		if(j % 2 == 0){
			var Entry = document.createElement("option");
			Entry.value  = fecthedDietTypes[j];
			Entry.text  = fecthedDietTypes[j+1];
			attendObj.add(Entry);
		}
	}
	}
	function setTimeForDietTypesPop(){}
	async function fecthMealTypeOptions(val)
	{	
		var language_Id =document.getElementById("languageId").value;
		var dType =document.getElementById("dietType").value;
		var mClass = document.getElementById("mealClass").value;
		var kCode =document.getElementById("kitchenCode").value;

		mealTypeObj = document.getElementById("checkMealType");
		dietTypeObj1 = document.getElementById("checkDietType");
		fetchMealTypeOptionsWithTime();
		var mode = "mealTypeList";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		param="&language_Id="+language_Id+"&dType="+dType+"&mClass="+mClass+"&kCode="+kCode+"&diet_Category="+diet_Category+"&ageGroupArr="+ageGroupArr+"&mode="+mode;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		retVal = await localTrimString(xmlHttp.responseText);
		if(trim(retVal) != null && trim(retVal) != "")
			fecthedMealTypes = retVal.split(',');
		else
			fecthedMealTypes.splice(0,fecthedMealTypes.length);
		if(document.getElementById("hdrFlag").value == "Y")
		{
			var encounterId=document.getElementById("encounterId").value;
			var facility = document.getElementById("addedFacilityId").value;
			var xmlStr ="<root><SEARCH";
			xmlStr +=" /></root>";
			var mode = "mealTypeForDischange";
			var paramVal ="&encounterId="+encounterId+"&facility="+document.getElementById("addedFacilityId").value+"&hdrFlag="+document.getElementById("hdrFlag").value+"&mode="+mode+"&profileSL="+document.getElementById("profileSL").value;
			var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+paramVal;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			var retVal= await localTrimString(xmlHttp.responseText);
			if(retVal != null && trim(retVal).length != 0){
				mealTypesForDisCharge = retVal.split(",");
			}
		}
		var tableObj = null;
		var row_ind = 1;
		tableObj = document.getElementById("Able");
		while (tableObj.rows.length > 1) {
			tableObj.deleteRow(1);
		}
			for(var i =0; i < fecthedMealTypes.length; i++){
				if(i % 2 == 0) {//Commented against ML-MMOH-409
				//if(i % 6 == 0) { //Added against ML-MMOH-409
				var selObj = "";
				var checkObj = "";
				var newRow = tableObj.insertRow(row_ind);
				var newCellDesc = newRow.insertCell(newRow.cells.length);
				newCellDesc.className = "label";
				newCellDesc.appendChild(document.createTextNode(trim(fecthedMealTypes[i+1])));
				//ML-MMOH-CRF-409 starts
				var newCell = newRow.insertCell(newRow.cells.length);

				var sel = "<input type='hidden' name='mealTypesforDietTypes' id='mealTypesforDietTypes' value='"+trim(fecthedMealTypes[i])+"'>";

				newCell.innerHTML = sel;

				//ML-MMOH-CRF-409 ENDS
				var newCellCheck = newRow.insertCell(newRow.cells.length);
				var newCellCheck1 = newRow.insertCell(newRow.cells.length);
				var sta = document.getElementById("deitTypesStatus").value;
				var gracePeriodApplicableYN = document.getElementById("gracePeriodApplicableYN").value;
				var gracePeriod = document.getElementById("gracePeriod").value;
				var flag = document.getElementById("flag").value;
				if (sta == "Y") {
					var selObj = "<SELECT name='dietTypesForMeals' id='dietTypesForMeals' onChange='getMeals1(this.value,"+row_ind+")'>";
					if(gracePeriodApplicableYN == "Y" && gracePeriod != null && flag == "Y" && mealTypesForDisCharge == ""){
						checkObj = "<input type='checkbox' name='gracePeriodApplicableYn"+row_ind+"' id='gracePeriodApplicableYn"+row_ind+"' checked=checked value='Y' onclick=\gracePeriodSelect('"+trim(fecthedMealTypes[i])+"','"+dType+"','"+row_ind+"');>";
						if(mealTypeObj.value == undefined)
						 {
							 mealTypeObj.value = "";
						 }
						mealTypeObj.value = mealTypeObj.value + trim(fecthedMealTypes[i]) +"@";
						if(dietTypeObj1.value == undefined)
						{
							dietTypeObj1.value = "";
						}
						dietTypeObj1.value = dietTypeObj1.value + dType +"@";
					}
				} else {
					var selObj = "<SELECT name='dietTypesForMeals' id='dietTypesForMeals' disabled='true'>";
					if(gracePeriodApplicableYN == "Y" && gracePeriod != null && flag == "Y" && mealTypesForDisCharge == ""){
						checkObj = "<input type='checkbox' name='gracePeriodApplicableYn"+row_ind+"' id='gracePeriodApplicableYn"+row_ind+"' checked=checked value='Y' onclick=\gracePeriodSelect('"+trim(fecthedMealTypes[i])+"','"+dType+"','"+row_ind+"');>";
						if(mealTypeObj.value == undefined)
						 {
							 mealTypeObj.value = "";
						 }
						mealTypeObj.value = mealTypeObj.value + trim(fecthedMealTypes[i]) +"@";
						if(dietTypeObj1.value == undefined)
						{
							dietTypeObj1.value = ""; 
						}
						dietTypeObj1.value = dietTypeObj1.value + dType +"@";
					}
				}
				if(mealTypesForDisCharge != "" && mealTypesForDisCharge != null && flag == "Y"){
					checkObj = "<input type='checkbox' name='gracePeriodApplicableYn"+row_ind+"' id='gracePeriodApplicableYn"+row_ind+"' value='Y' onclick=\mealTypeUnChk('"+trim(fecthedMealTypes[i])+"','"+dType+"','"+row_ind+"');>";
				}
				var label="Select";
				selObj += "<OPTION value=''>"+label+"</OPTION>";
				var obj = document.getElementById("dietType").value;
				for (var j=0; j < fecthedDietTypes.length;j++) {
					if(j % 2 == 0){
						if(trim(fecthedDietTypes[j]) == trim(obj)){
							var value = trim(fecthedDietTypes[j]);
							var desc = trim(fecthedDietTypes[j+1]);
							selObj += "<OPTION value='" + value + "' selected>" + desc + "</OPTION>";
						}else{
							var value = trim(fecthedDietTypes[j]);
							var desc = trim(fecthedDietTypes[j+1]);
							selObj += "<OPTION value='" + value + "'>" + desc + "</OPTION>";
						}

					}
				}
				selObj += "</SELECT><img src='../../eCommon/images/mandatory.gif' alt='Cancel Order' />";
				selObj += "<input type='hidden' name='isDietTypesChanged' id='isDietTypesChanged'  value='" +  + "'>";
				newCellCheck.innerHTML = selObj;
				//selObj = "";
				newCellCheck1.innerHTML = checkObj;
				found_flag = false;
				if(mealTypesForDisCharge != null && mealTypesForDisCharge.length > 0 && flag == "Y") {
					for(var j = 0; j < mealTypesForDisCharge.length; j++){
						if(trim(mealTypesForDisCharge[j]) == trim(fecthedMealTypes[i])){
							document.getElementById("gracePeriodApplicableYn"+row_ind).checked = true;
							mealTypeObj.value = mealTypeObj.value + trim(mealTypesForDisCharge[j]) +"@";
							dietTypeObj1.value = dietTypeObj1.value + trim(mealTypesForDisCharge[j+1]) +"@";
						}
					}
				}
				row_ind++;
			}
		}
		if(mealTypesForDisCharge != null && mealTypesForDisCharge != ""){
			getMealsForGarcePeriod(mealTypesForDisCharge);
		}
		if(document.getElementById("hdrFlag").value == "" || document.getElementById("hdrFlag").value != "Y"){
			getMeals();
		}

	}
	function fetchMealTypeOptionsWithTime()
	{
		var language_Id =document.getElementById("languageId").value;
		var dType =document.getElementById("dietType").value;
		var mClass = document.getElementById("mealClass").value;
		var kCode =document.getElementById("kitchenCode").value;
		var mode = "mealTypeListWithTime";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		param="&language_Id="+language_Id+"&dType="+dType+"&mClass="+mClass+"&kCode="+kCode+"&diet_Category="+diet_Category+"&ageGroupArr="+ageGroupArr+"&mode="+mode;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		fetchedMealTypesWithTime = JSON.parse(xmlHttp.responseText);
	}
	var mealTypeObj = null;
	var dietTypeObj1 = null;
	var tempFlag = false;
	function gracePeriodSelect(obj, obj1,row_ind){
		mealTypeObj = document.getElementById("checkMealType");
		dietTypeObj1 = document.getElementById("checkDietType");
		if(obj != null && obj != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked){
			mealTypeObj.value = mealTypeObj.value + obj +"@";
		}else if(obj != null && obj != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked ==  false){
			var temp = obj +"@";
			mealTypeObj.value  = mealTypeObj.value.replace(temp,'');
		}

		if(obj1 != null && obj1 != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked){
			dietTypeObj1.value = dietTypeObj1.value + obj1 +"@";
		}else if(obj1 != null && obj1 != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked == false){
			var temp1 = obj1 +"@";
			dietTypeObj1.value  = dietTypeObj1.value.replace(temp1,'');
		}

		 getMealsGarcePeriod();
	}
	function mealTypeUnChk(obj, obj1,row_ind){
		if(obj != null && obj != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked){
			mealTypeObj.value = mealTypeObj.value + obj +"@";
		}else if(obj != null && obj != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked ==  false){
			var temp = obj +"@";
			mealTypeObj.value  = mealTypeObj.value.replace(temp,'');
		}
		if(obj1 != null && obj1 != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked){
			dietTypeObj1.value = dietTypeObj1.value + obj1 +"@";
		}else if(obj1 != null && obj1 != "" && document.getElementById("gracePeriodApplicableYn"+row_ind).checked == false){
			var temp1 = obj1 +"@";
			dietTypeObj1.value  = dietTypeObj1.value.replace(temp1,'');
		}
		getMealsGarcePeriod()
	}
	function getMealsGarcePeriod(){
		if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
			var language_Id =document.getElementById("languageId").value;
			var _dTypeArr = new Array();
			var _mTypeArr = new Array();
			var count = 0;
			var ctr = 0;
			if(document.getElementById("profileSL").value != ""){
				var h=0;
				var dietTypesForMeals = dietTypeObj1.value;
				var obj = (trimString(dietTypesForMeals).split('@'));
				if(obj != null){
					for(var k=0; k < obj.length; k++){
						if(obj[k] != ""){
							_dTypeArr[h] = obj[k];
						}
						h=h+1;
					}
				}

				var h=0;
				var mealTypesforDietTypes=mealTypeObj.value;
				var obj2 = (trimString(mealTypesforDietTypes)).split('@');
				if(obj2 != null){
					for(var k=0; k < obj2.length; k++){
						ob1[h] = obj2[k];
						if(obj2[k] != ""){
							_mTypeArr[h] = obj2[k];
						}
						h=h+1;
					}
				}

			}
			else{
					var objsFields = new Array();
					var dietTypesForMeals = dietTypeObj1.value;
					var obj = (trimString(dietTypesForMeals).split('@'));
					if(obj != null){
					for (var i = 0; i < obj.length; i++) {
						var flag = false;
						for (var j = 0; j < ob.length; j++) {
							if (obj[i] == ob[j]) {
							if (obj[i] != "") {
									flag = true;
								}
							}
						}
						if (!flag) {
							ob[count++] = obj[i];
						}else{
							ob[count++] = obj[i];
						}
					}
					}

					var h=0;
					var dietTypesForMeals = dietTypeObj1.value;
					var obj = (trimString(dietTypesForMeals)).split('@');
					if(obj != null){
					for(var k=0; k < obj.length; k++){
						if(obj[k] != ""){
							_dTypeArr[h] = obj[k];
						}
						h=h+1;
					}
					}
					var mealTypesforDietTypes=mealTypeObj.value;
					var obj1 = (trimString(mealTypesforDietTypes)).split('@');
					var m=0;
					if(obj1 != null){
					for(var k=0; k < obj1.length; k++){
						ob1[m] = obj1[k].value;
						if(obj1[k] != ""){
							_mTypeArr[m] = obj1[k];
						}
						m=m+1;
					}
					}
				}
					var mode = "DayRefNo";
					if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						var xmlStr ="<root></root>";
						var pArgumentArrayMap = "&dateForMeanu="+document.getElementById("dateForMeanu").value+"&facility="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mealClass="+document.getElementById("mealClass").value+"&mode="+mode;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
						xmlHttp.send(xmlDoc);
						retVal = localTrimString(xmlHttp.responseText);
						var obj = document.getElementById("dayRef");
						if(retVal != null && trim(retVal).length != 0){
							var Entry = document.createElement("option");
							Entry.value  = trim(retVal);
							Entry.text  = trim(retVal);
							obj.add(Entry);
						}
						if (retVal == "0") {
						}else {
							document.getElementById("dayRef").value = trim(retVal);
						}
						getMealContent();
					}
					function getMealContent(){
						var mode = "MealContent";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					param="&locale="+language_Id+"&_mTypeArr="+_mTypeArr+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+_dTypeArr+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMeanu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
					xmlHttp.send(xmlDoc);
					retVal = localTrimString(xmlHttp.responseText);
					//IN:40900
						tableObj3 = document.getElementById("treemenu3");
						while (tableObj3.rows.length > 0) {
							tableObj3.deleteRow(0);
						}

						tableObj4 = document.getElementById("treemenu4");
						while (tableObj4.rows.length > 0) {
							tableObj4.deleteRow(0);
						}

					if(retVal != null && trim(retVal).length != 0){
					menuList = retVal.split(',');
					assignMealItem(menuList);

					}
					}
			}

	}
	//function getMealsForGarcePeriod(disMealType,disDietType){
	var _disDtypeArr = new Array();
	var _disMtypeArr = new Array();
	  function getMealsForGarcePeriod(mealDietList){
		if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
			var language_Id =document.getElementById("languageId").value;
			var count = 0;
			var ctr = 0;
			if(document.getElementById("profileSL").value != ""){
				if(mealDietList != null && mealDietList != ""){
					for(var ml=0,d=0; ml < mealDietList.length; ml++,d=d+2){
						if(mealDietList[d] != "" && mealDietList[d] != null){
							_disMtypeArr[ml] = trim(mealDietList[d]);
							_disDtypeArr[ml] = trim(mealDietList[d+1])

						}
					}
				}

				var mode = "DayRefNo";
				if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					var pArgumentArrayMap = "&dateForMeanu="+document.getElementById("dateForMeanu").value+"&facility="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mealClass="+document.getElementById("mealClass").value+"&mode="+mode;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
					xmlHttp.send(xmlDoc);
					retVal = localTrimString(xmlHttp.responseText);
					var obj = document.getElementById("dayRef");
					if(retVal != null && trim(retVal).length != 0){
						var Entry = document.createElement("option");
						Entry.value  = trim(retVal);
						Entry.text  = trim(retVal);
						obj.add(Entry);
					}
					if (retVal == "0") {
					}else {
						document.getElementById("dayRef").value = trim(retVal);
					}
					getMealContent();
				}
				function getMealContent(){
					var mode = "MealContent";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				param="&locale="+language_Id+"&_mTypeArr="+_disMtypeArr+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+_disDtypeArr+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMeanu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
				xmlHttp.send(xmlDoc);
				retVal = localTrimString(xmlHttp.responseText);
				//IN:40900
					tableObj3 = document.getElementById("treemenu3");
					while (tableObj3.rows.length > 0) {
						tableObj3.deleteRow(0);
					}

					tableObj4 = document.getElementById("treemenu4");
					while (tableObj4.rows.length > 0) {
						tableObj4.deleteRow(0);
					}

				if(retVal != null && trim(retVal).length != 0){
				menuList = retVal.split(',');
				assignMealItem(menuList);
				}
				}
			}
		}
	}
	var ob = new Array();
	var ob1 = new Array();
	var menuList = new Array();
	function getMeals()
	{
		if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
			var language_Id =document.getElementById("languageId").value;
			var _dTypeArr = new Array();
			var _mTypeArr = new Array();
			var count = 0;
			var ctr = 0;
			if(document.getElementById("maxprofileSL").value == "")
			{
				document.getElementById("maxprofileSL").value = document.getElementById("profileSL").value;
			}
			if(document.getElementById("profileSL").value != ""){

				ob[0] = document.getElementById("dietType").value;
				var objsFields = new Array();
				var obj = document.getElementsByName("dietTypesForMeals");
				if(obj != null){
					for (var i = 0; i < obj.length; i++) {
						var flag = false;
						for (var j = 0; j < ob.length; j++) {
							if (obj[i].value == ob[j]) {
								if (obj[i].value != "") {
									flag = true;
								}
							}
						}
						if (!flag) {
							ob[count++] = obj[i].value;
						}else{
							ob[count++] = obj[i].value;
						}
					}
				}
				var h=0;
				var obj = document.getElementsByName("dietTypesForMeals");
				if(obj != null){
					for(var k=0; k < obj.length; k++){
						_dTypeArr[h] = obj[k].value;
						h=h+1;
					}
				}

				var h=0;
				var obj2 = document.getElementsByName("mealTypesforDietTypes")
				if(obj2 != null){
					for(var k=0; k < obj2.length; k++){
						ob1[h] = obj2[k].value;
						_mTypeArr[h] = obj2[k].value;
						h=h+1;
					}
				}

			}
			else{
					var objsFields = new Array();
					var obj = document.getElementsByName("dietTypesForMeals");
					if(obj != null){
					for (var i = 0; i < obj.length; i++) {
						var flag = false;
						for (var j = 0; j < ob.length; j++) {
							if (obj[i].value == ob[j]) {
							if (obj[i].value != "") {
									flag = true;
								}
							}
						}
						if (!flag) {
							ob[count++] = obj[i].value;
						}else{
							ob[count++] = obj[i].value;
						}
					}
					}

					var h=0;
					var obj = document.getElementsByName("dietTypesForMeals");
					if(obj != null){
					for(var k=0; k < obj.length; k++){
						_dTypeArr[h] = obj[k].value;
						h=h+1;
					}
					}
					var obj1=document.getElementsByName("mealTypesforDietTypes");
					var m=0;
					if(obj1 != null){
					for(var k=0; k < obj1.length; k++){
						ob1[m] = obj1[k].value;
						_mTypeArr[m] = obj1[k].value;
						m=m+1;
					}
					}
				}
					var mode = "DayRefNo";
					if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "")
					{
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						var xmlStr ="<root></root>";
						var pArgumentArrayMap = "&dateForMeanu="+document.getElementById("dateForMeanu").value+"&facility="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mealClass="+document.getElementById("mealClass").value+"&mode="+mode;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
						xmlHttp.send(xmlDoc);
						retVal = localTrimString(xmlHttp.responseText);
						var obj = document.getElementById("dayRef");
						if(retVal != null && trim(retVal).length != 0){
							var Entry = document.createElement("option");
							Entry.value  = trim(retVal);
							Entry.text  = trim(retVal);
							obj.add(Entry);
						}
						if (retVal == "0") {
						}else {
							document.getElementById("dayRef").value = trim(retVal);
						}
						getMealContent();
					}
					function getMealContent()
					{
					var mode = "MealContent";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					param="&locale="+language_Id+"&_mTypeArr="+_mTypeArr+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+_dTypeArr+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMeanu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
					xmlHttp.send(xmlDoc);
					retVal = localTrimString(xmlHttp.responseText);
					//IN:40900
						tableObj3 = document.getElementById("treemenu3");
						while (tableObj3.rows.length > 0) {
							tableObj3.deleteRow(0);
						}

						tableObj4 = document.getElementById("treemenu4");
						while (tableObj4.rows.length > 0) {
							tableObj4.deleteRow(0);
						}
					if(retVal != null && trim(retVal).length != 0){
					menuList = retVal.split(',');
					assignMealItem(menuList);
					}
					}
			}else{
				tableObj3 = document.getElementById("treemenu3");
				tableObj4 = document.getElementById("treemenu4");
				var tbodyObj = document.all("dispGTC");

				while (tableObj3.rows.length > 0) {
					tableObj3.deleteRow(0);
				}

				while (tableObj4.rows.length > 0) {
					tableObj4.deleteRow(0);
				}

				if(tbodyObj.rows.length>=1)
					tbodyObj.deleteRow(0);
			}
		}

	async function getMeals1(val,indNo){
		if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "" && document.getElementById("flag").value == "N") {
			var language_Id =document.getElementById("languageId").value;
			var ob = new Array();
			var ob1 = new Array();
			var count = 0;
			ob[0] = document.getElementById("dietType").value;
			var objsFields = new Array();
			var obj = document.getElementsByName("dietTypesForMeals");
			if(obj != null){
				for (var i = 0; i < obj.length; i++) {
					var flag = false;
					for (var j = 0; j < ob.length; j++) {
						if (obj[i].value == ob[j]) {
							if (obj[i].value != "") {
								flag = true;
							}
						}
					}
					if (!flag) {
						ob[count++] = obj[i].value;
					}else{
						ob[count++] = obj[i].value;
					}
				}
			}
			var obj1 = document.getElementsByName("mealTypesforDietTypes");
			var l=0;
			var n=0;
			if(indNo == undefined){
				indNo=0;

			}else{
				indNo=indNo;
			}
			for(var k=0; k < obj1.length; k++){
				ob1[l] = obj1[k].value;
				l=l+1;
			}
			for(var m=0; m <= ob1.length; m++){
				var mt=obj1[indNo];
				if(mt==ob1[m]){
					ob[n]=val;
					break;
				}
				n=n+1;
			}


			var mode = "DayRefNo";
			if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				var pArgumentArrayMap = "&dateForMeanu="+document.getElementById("dateForMeanu").value+"&facility="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mealClass="+document.getElementById("mealClass").value+"&mode="+mode;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
				xmlHttp.send(xmlDoc);
				retVal = await localTrimString(xmlHttp.responseText);
				var obj = document.getElementById("dayRef");
				if(retVal != null){
					var Entry = document.createElement("option");
					Entry.value  = retVal;
					Entry.text  = retVal;
					obj.add(Entry);
				}
				if (retVal == "0") {
				}else {
					document.getElementById("dayRef").value = retVal;
				}
				getMealContent();
			}

			async function getMealContent(){
				var mode = "MealContent";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			param="&locale="+language_Id+"&_mTypeArr="+ob1+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+ob+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMeanu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
			xmlHttp.send(xmlDoc);
			retVal = await localTrimString(xmlHttp.responseText);
			//IN:40900
			tableObj3 = document.getElementById("treemenu3");
			while (tableObj3.rows.length > 0) {
				tableObj3.deleteRow(0);
			}
			tableObj4 = document.getElementById("treemenu4");
			while (tableObj4.rows.length > 0) {
				tableObj4.deleteRow(0);
			}
			if(retVal != null && trim(retVal).length != 0){
				menuList = retVal.split(',');
				assignMealItem(menuList);
			}
			}

		}else{
			var language_Id =document.getElementById("languageId").value;
			var ob = new Array();
			var ob1 = new Array();
			var count = 0;
			ob[0] = document.getElementById("dietType").value;
			var objsFields = new Array();
			//var obj = document.getElementsByName("dietTypesForMeals");
			var disDietType = dietTypeObj1.value;
		    var obj = disDietType.split('@');
			if(obj != null){
				for (var i = 0; i < obj.length; i++) {
					var flag = false;
					for (var j = 0; j < ob.length; j++) {
						if (obj[i] == ob[j]) {
							if (obj[i] != "") {
								flag = true;
							}
						}
					}
					if (!flag) {
						ob[count++] = obj[i];
					}else{
						ob[count++] = obj[i];
					}
				}
			}

			//var obj1 = document.getElementsByName("mealTypesforDietTypes");
			var disMealType = mealTypeObj.value;
			var obj1 = disMealType.split('@');
			var l=0;
			var n=0;
			if(indNo == undefined){
				indNo=0;

			}else{
				indNo=indNo;
			}
			for(var k=0; k < obj1.length; k++){
				ob1[l] = obj1[k];
				l=l+1;
			}


			for(var m=0; m <= ob1.length; m++){
				var mt=obj1[m];
				if(mt==ob1[m]){
					ob[n]=val;
					break;
				}
				n=n+1;
			}
			if(ob != null && ob != ""){
				dietTypeObj1.value = ob;
			}
			var mode = "DayRefNo";
			if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				var pArgumentArrayMap = "&dateForMeanu="+document.getElementById("dateForMeanu").value+"&facility="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mealClass="+document.getElementById("mealClass").value+"&mode="+mode;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
				xmlHttp.send(xmlDoc);
				retVal = await localTrimString(xmlHttp.responseText);
				var obj = document.getElementById("dayRef");
				if(retVal != null){
					var Entry = document.createElement("option");
					Entry.value  = retVal;
					Entry.text  = retVal;
					obj.add(Entry);
				}
				if (retVal == "0") {
				}else {
					document.getElementById("dayRef").value = retVal;
				}
				getMealContent();
			}

			async function getMealContent(){
				var mode = "MealContent";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			param="&locale="+language_Id+"&_mTypeArr="+ob1+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+ob+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMeanu").value+"&dayRef="+document.getElementById("dayRef").value+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
			xmlHttp.send(xmlDoc);
			retVal = await localTrimString(xmlHttp.responseText);
			//IN:40900
			tableObj3 = document.getElementById("treemenu3");
			while (tableObj3.rows.length > 0) {
				tableObj3.deleteRow(0);
			}
			tableObj4 = document.getElementById("treemenu4");
			while (tableObj4.rows.length > 0) {
				tableObj4.deleteRow(0);
			}
			if(retVal != null && trim(retVal).length != 0){
				menuList = retVal.split(',');
				assignMealItem(menuList);
			}
			}


		}
}

var code = false;
var energyUom=null;
function assignMealItem(MealItems)
{
	var MealItemsArray=new Array();
	var k=0;
	for(var i=0;i<(MealItems.length/12);i++) {//Modified Against KDAH-CRF-0352
		MealItemsArray[i]=new Array();
		for(var j=0;j<12;j++,k++) {//Modified Against KDAH-CRF-0352
			MealItemsArray[i][j]=MealItems[k];
		}
	}

    parent.document.getElementById("MealItemsArray").value=MealItemsArray;
	document.getElementById("mealTotalCalorie").value=0;
	var dayRef = document.getElementById("dayRef").value;
	if(MealItems != null){
		var row_ind1=0;
		var index=0;
		var nextIncre = 0;
		var tableObj = null;
		var i = 1;
		var found_flag = false;
		var qryEven = "QRYEVEN";
		var qryOdd = "QRYODD";
		var total = 0;

		tableObj3 = document.getElementById("treemenu3");

		while (tableObj3.rows.length > 0) {
			tableObj3.deleteRow(0);
		}
		var selObj = "";

		count = 0;
		var totalCalori=0;
		var mealTypeIndex=0;

		var temp = new Array();
		temp[0] = "test";

		for(var incre=0,j=0; incre < MealItems.length;)
		{
			if (!code) {
				code = true;
			}
			var classVal = (mealTypeIndex % 2 == 0) ? qryEven : qryOdd;
			for(var k=0; k < temp.length; k++)
			{
				if((MealItems[incre+1]) != temp[j]){
					temp[j+1] = MealItems[incre+1];
					var newRow3 = tableObj3.insertRow(row_ind1);
					var newCellDesc = newRow3.insertCell(newRow3.cells.length);
					newCellDesc.className = "lable";
					newCellDesc.className = classVal;
					newCellDesc.colSpan = "3";//Modified against KDAH-CRF-0352 9 to 3
					newCellDesc.align = "left";
					newCellDesc.setAttribute("border", "0px");
					newCellDesc.style.fontSize ="10pt"
					newCellDesc.style.fontWeight = "700"
					newCellDesc.style.color = "#4E387E"
					newCellDesc.appendChild(document.createTextNode(MealItems[incre+1]));
				
					//Added against KDAH-CRF-0352 Starts Here
					var newCellDesc1 = newRow3.insertCell(newRow3.cells.length);
					newCellDesc1.className = "lable";
					newCellDesc1.className = classVal;
					newCellDesc1.colSpan = "3";
					newCellDesc1.align = "left";
					newCellDesc1.setAttribute("border", "0px");
					newCellDesc1.style.fontSize ="10pt"
					newCellDesc1.style.fontWeight = "700"
					newCellDesc1.style.color = "#4E387E"
					newCellDesc1.appendChild(document.createTextNode("Qty"));
					
					var newCellDesc2 = newRow3.insertCell(newRow3.cells.length);
					newCellDesc2.className = "lable";
					newCellDesc2.className = classVal;
					newCellDesc2.colSpan = "1";
					newCellDesc2.align = "left";
					newCellDesc2.setAttribute("border", "0px");
					newCellDesc2.style.fontSize ="10pt"
					newCellDesc2.style.fontWeight = "700"
					newCellDesc2.style.color = "#4E387E"
					newCellDesc2.appendChild(document.createTextNode("Calorie"));
					//Added against KDAH-CRF-0352 Ends Here						
					
					row_ind1=row_ind1+1;
					j++;
				}
			}
			var cal1=0;
			var falg = false;
			var falg=false;

			var calori = parseInt(MealItems[incre+4])*parseFloat((Math.round((MealItems[incre+7])*Math.pow(10,2))/Math.pow(10,2)));
			if(calori == "NaN")
				calori = 0.0
			if(cal1 == "NaN")
				cal1 = 0.0
			cal1=parseFloat(cal1)+parseFloat(calori);
			servingUom=MealItems[incre+7];

			var newRow4 = tableObj3.insertRow(row_ind1);
			var newCell1 = newRow4.insertCell(newRow4.cells.length);
			var newCell2 = newRow4.insertCell(newRow4.cells.length);
			var newCell3 = newRow4.insertCell(newRow4.cells.length);
			if(trim(MealItems[incre+9]) == "M" ){
				newCell1.style.color = "Brown";
				newCell2.style.color = "Brown";
				newCell3.style.color = "Brown";
			}else if(falg){
				newCell1.style.color = "Red";
				newCell2.style.color = "Red";
				newCell3.style.color = "Red";
			}else{
				newCell1.style.color = "Navy";
				newCell2.style.color = "Navy";
				newCell3.style.color = "Navy";
			}
			var qSUC =  MealItems[incre+3];

			newCell1.className = "label";
			newCell1.className = classVal;
			newCell1.align = "left";
			newCell1.colSpan = "3";
			newCell1.style.fontSize ="8pt"
			newCell1.appendChild(document.createTextNode(qSUC));

			//var qtty = MealItems[incre+4]+ " "+ MealItems[incre+6].toLowerCase();
			var qtty = MealItems[incre+4]+ " "+ MealItems[incre+10].toLowerCase();//Modified Against KDAH-CRF-0352
			
			newCell2.className = "lable";
			newCell2.className = classVal;
			newCell2.align = "left";
			newCell2.style.fontSize ="8pt"
			newCell2.colSpan = "3";
			newCell2.appendChild(document.createTextNode(qtty));

			//var calEUomCode = parseFloat((Math.round(calori*Math.pow(10,2))/Math.pow(10,2)))+" "+MealItems[incre+8].toLowerCase();
			var calEUomCode = parseFloat((Math.round(calori*Math.pow(10,2))/Math.pow(10,2)))+" "+MealItems[incre+11].toLowerCase();//Modified against KDAH-CRF-0352
			newCell3.className = "lable";
			newCell3.className = classVal;
			newCell3.style.fontSize ="8pt"
			newCell3.align = "left";
			newCell3.colSpan = "3";
			newCell3.bold = "bold";
			newCell3.appendChild(document.createTextNode(calEUomCode));
			row_ind1=row_ind1+1;

			if(incre == (MealItems.length)-12){//Modified Against KDAH-CRF-0352
				nextIncre = incre;
			}else{
				nextIncre = incre+12;//Modified Against KDAH-CRF-0352
			}
			var str = getLabel("eDS.Total.Label","DS");
			var msg = str+" :"
			var acli = parseFloat((Math.round(cal1*Math.pow(10,2))/Math.pow(10,2)));
			if(trim(MealItems[incre+9]) != "M" ){
				totalCalori=parseFloat((Math.round(totalCalori*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(cal1*Math.pow(10,2))/Math.pow(10,2)));
				total = total+acli;
			}
			var acliUom = total;
			
			//energyUom = MealItems[incre+8].toLowerCase();
			energyUom = MealItems[incre+11].toLowerCase();//Modified against KDAH-CRF-0352			
			
			if(trim(MealItems[incre]) != trim(MealItems[nextIncre]) || incre == nextIncre){
				var newRow5 = tableObj3.insertRow(row_ind1);
				var newCell1 = newRow5.insertCell(newRow5.cells.length);
				var newCell2 = newRow5.insertCell(newRow5.cells.length);

				newCell1.className = "lable";
				newCell1.className = classVal;
				newCell1.style.fontWeight = "700"
				newCell1.style.fontSize ="8pt"
				newCell1.style.color ="#2B1B17"
				newCell1.align = "left";
				newCell1.colSpan = "6";

				newCell2.className = "lable";
				newCell2.className = classVal;
				newCell2.style.fontSize ="8pt"
				newCell2.style.color ="#2B1B17"
				newCell2.style.fontWeight = "700"
				newCell2.align = "left";
				newCell2.colSpan = "3";
				row_ind1=row_ind1+1;
				newCell1.innerHTML = msg;
				newCell2.innerHTML = acliUom;
				total = 0;
			}
			incre = incre + 12;//Modified Against KDAH-CRF-0352
			mealTypeIndex=mealTypeIndex+1;
		}
		tableObj4 = document.getElementById("treemenu4");
		while (tableObj4.rows.length > 0) {
			tableObj4.deleteRow(0);
		}

		var newRow6 = tableObj4.insertRow(0);
		var newCell1 = newRow6.insertCell(newRow6.cells.length);
		var newCell2 = newRow6.insertCell(newRow6.cells.length);

		newCell1.className = "lable";
		newCell1.className = classVal;
		newCell1.style.color = "#2B1B17";
		newCell1.style.fontSize ="8pt"
		newCell1.style.fontWeight = "700"
		newCell1.align = "left";
		newCell1.colSpan = "6";

		newCell2.className = "lable";
		newCell2.className = classVal;
		newCell2.style.color = "#2B1B17";
		newCell2.style.fontSize ="8pt"
		newCell2.style.fontWeight = "700"
		newCell2.align = "left";
		newCell2.colSpan = "3";

		var str1 = getLabel("eDS.mealTotalCalorie.Label","DS");
		var msg1 = str1+" :";
		var tatalCali = totalCalori;
		newCell1.appendChild(document.createTextNode(msg1));
		newCell2.appendChild(document.createTextNode(tatalCali));

		document.getElementById("mealTotalCalorie").value=totalCalori;
	}
	calGTotalCalorie();
}

function calGTotalCalorie(){
	var mealTotalCalorie=document.getElementById("mealTotalCalorie").value;
	if(mealTotalCalorie=="")
		mealTotalCalorie=0;
	var tbodyObj = document.all("dispGTC");
	if(tbodyObj.rows.length>=1)
		tbodyObj.deleteRow(0);

	var newRow1 = tbodyObj.insertRow(0);
	var labelCel = newRow1.insertCell(newRow1.cells.length);
	var calorieCel = newRow1.insertCell(newRow1.cells.length);

	labelCel.className = "lable";
	labelCel.style.fontWeight = "700";
	labelCel.style.fontSize ="7pt";
	labelCel.style.color ="#2B1B17";
	labelCel.setAttribute("border", "0px");
	labelCel.align = "left";
	labelCel.colSpan = "3";

	calorieCel.className = "lable";
	calorieCel.style.fontWeight = "700";
	calorieCel.style.fontSize ="7pt";
	calorieCel.style.color ="#2B1B17";
	calorieCel.setAttribute("border", "0px");
	calorieCel.align = "left";
	calorieCel.colSpan = "1";

	var msg = getLabel("eDS.calorieGrandTotal.Label","DS");
	labelCel.appendChild(document.createTextNode(msg+" :"));

	if(isNaN(mealTotalCalorie))
		mealTotalCalorie = 0;

	var CGTotal = parseFloat(parseFloat((Math.round(mealTotalCalorie*Math.pow(10,2))/Math.pow(10,2))));
	CGTotal = (Math.round(CGTotal*Math.pow(10,2))/Math.pow(10,2));

	var CGTotalVal = CGTotal+" "+energyUom;
	calorieCel.appendChild(document.createTextNode(CGTotalVal));
}

// Modified against ML-MMOH-CRF-0677 starts
function fecthDietTypeToMealClass(){
	var dietType=document.getElementById("dietType").value;
	var dietCategory=document.getElementById("dietCategory").value;
	var facility_id=document.getElementById("addedFacilityId").value;
	var appl_user_id=document.getElementById("addedById").value;
	var mealClass=document.getElementById("mealClass").value;
	if(dietType!="" && dietCategory!="" && mealClass!="" && facility_id!="" && appl_user_id!="") {
		fecthMealTypeOptions(document.getElementById("dietType").value);
   }else{
		fecthMealTypeOptions(document.getElementById("dietType").value);
	}
	editmenu(mealClass,facility_id,appl_user_id);//ML-MMOH-CRF-066
	if(parent.frames[2].document.getElementById("remarksImg").style.visibility == 'visible')	//Added against MMS-KH-CRF-0029.1
		parent.frames[2].document.getElementById("remarksImg").style.visibility = 'hidden';
}

//Added against ICN 72081 & Added against MMS-KH-CRF-0029.1
function drugAlert()
{
var rem = document.getElementById("remarks_1").value;	
		if(rem=="" || rem=="null")
		{
		var enabledrugfoodYN = document.getElementById("enable_drugfood_YN").value;	
		if(enabledrugfoodYN=="Y")
		{
		drugFoodInteraction();	
		}
		}
}
//Added against ICN 72081 & Added against MMS-KH-CRF-0029.1

//ML-MMOH-CRF-0669 Starts
async function editmenu(mealClass,facility_id,appl_user_id)
{
	var mealClass=document.getElementById("mealClass").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=editmenu&mealClass="+mealClass;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var params1 = "func_mode=PlaceOrderRightsEdit&facility_id="+facility_id+"&appl_user_id="+appl_user_id;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params1,false);
	xmlHttp.send(xmlDoc);
	var retValChk = await trimString(xmlHttp.responseText);
	var accessArray=retValChk.split(",");	
	var edit_meals_yn = accessArray[0];
	
	if(retVal== 'Y' && edit_meals_yn == 'Y'){
		document.getElementById("editMenu_flow_text").disabled = false;
	}
	else if((retVal== 'Y' && edit_meals_yn == 'N') || (retVal== 'N' && edit_meals_yn == 'Y') || (retVal== 'N' && edit_meals_yn == 'N')){
		document.getElementById("editMenu_flow_text").disabled = true;
	}
}
//ML-MMOH-CRF-0669 Ends
// Modified against ML-MMOH-CRF-0677 ends

//added against ML-MMOH-CRF-0677 Starts
async function PlaceOrderRightsEdit()
{
	var facility_id=document.getElementById("addedFacilityId").value;
	var appl_user_id=document.getElementById("addedById").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params1 = "func_mode=PlaceOrderRightsEdit&facility_id="+facility_id+"&appl_user_id="+appl_user_id;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params1,false);
	xmlHttp.send(xmlDoc);
	var retValChk = await trimString(xmlHttp.responseText);
	var accessArray=retValChk.split(",");
	
	var edit_meals_yn = accessArray[0];
	var nutrient_supplement_yn =accessArray[1];
	var food_dislike_yn = accessArray[2];
	var special_food_order_yn =accessArray[3];
	
	if(nutrient_supplement_yn== 'Y'){
		document.getElementById("nutrient_flow_text").disabled = false;
	}
	else{
		document.getElementById("nutrient_flow_text").disabled = true;
	}
	if(food_dislike_yn== 'Y'){
		document.getElementById("foodItem_dislike_flow_text").disabled = false;
	}
	else{
		document.getElementById("foodItem_dislike_flow_text").disabled = true;
	}
	if(special_food_order_yn== 'Y'){
		document.getElementById("splFoodItem_flow_text").disabled = false;
	}
	else{
		document.getElementById("splFoodItem_flow_text").disabled = true;
	}
}
//added against ML-MMOH-CRF-0677 Ends

function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
    return "";
}

function trimString(sInString){
	if(sInString != ""){
		return sInString.replace(/^\s+|\s+$/g,"");
	}
	return "";
}

function localTrimString(sInString) {
	if(sInString != ""){
		return sInString.replace(/[\[\]']+/g,'');
	}
	return "";
}

var submitStatus = false;
function disabledField(){
	if(document.getElementById("dateForMeanu").value!=""){
		document.getElementById("dayRef").disabled=true;
	}else{
		document.getElementById("dayRef").disabled=false;
	}
}

function checkNull(){
	Full_Day_NBM_YN=$("#Full_Day_NBM_YN").is(':checked');
	//Added Against ML-MMOH-CRF-1460 Starts
	var attendantRadio = false;
	//attendantRadio = document.getElementById('attendantRadio').checked;
	attendantRadio = document.getElementById('Suballocator').checked;
	var isMACNBM = document.getElementById("isMACNBM").value;
	//Added Against ML-MMOH-CRF-1460 Ends
	var dietType = document.getElementById("dietType").value;
	if(Full_Day_NBM_YN) FullNBMProcess();
	else if(isMACNBM && attendantRadio && dietType=="") //Added Against ML-MMOH-CRF-1460
	{
		var profileSL = document.getElementById("profileSL").value;
		var result = "apply";
		insertNBMAtt(profileSL,result)
	}
	else{//CRF-410
	if(document.getElementById("dateFrom").value != "" && document.getElementById("fromDateImage").style.visibility == "visible"){
		var locale=document.getElementById("languageId").value;
		var date=new Date();
		var month=date.getMonth();
		var date1=date.getDate();
		var year=date.getYear();
		month+=1;
		if(date1<=9){
			date1="0"+""+date1;
		}
		if(month<=9){
			month="0"+""+month;
		}
		var sysDate=date1+"/"+month+"/"+year;

//		var flag = isBeforeNow(document.getElementById("dateFrom").value,"DMY",locale);
		var frDate = convertDate(document.getElementById("dateFrom").value,'DMY',locale,'en');
		var flag = compareDate(frDate,sysDate);
		if(flag == -1)
		{
			var error="";
			var msg = "App-DS0011 # should be greater than or equals to";
			var msg_key = msg.split("#");
			var f_date = "From Date";
			var t_date = "To Date";
			var s_date = "SysDate";
			//error = error+" "+msg_key[0]+" "+f_date+" "+msg_key[1]+" "+s_date+"<br>"
			error = error + getMessage("DS_FRDAT_GRTREQL_SYSDAT","DS") +"<br>";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return;
		}
	}

	if(document.getElementById("dateTo").value != ""){
		var locale=document.getElementById("languageId").value;
		var date=new Date();
		var month=date.getMonth();
		var date1=date.getDate();
		var year=date.getYear();
		month+=1;
		if(date1<=9){
			date1="0"+""+date1;
		}
		if(month<=9){
			month="0"+""+month;
		}
		var sysDate=date1+"/"+month+"/"+year;

//		var flag = isBeforeNow(document.getElementById("dateFrom").value,"DMY",locale);
		var tDate = convertDate(document.getElementById("dateTo").value,'DMY',locale,'en');
		var flag = compareDate(tDate,sysDate);
		if(flag == -1){
			var error="";
			var msg = "App-DS0011 # should be greater than or equals to";
			var msg_key = msg.split("#");
			var f_date = "From Date";
			var t_date = "To Date";
			var s_date = "SysDate";
			//error = error+" "+msg_key[0]+" "+t_date+" "+msg_key[1]+" "+s_date+"<br>"
			error = error+ getMessage("DS_TODAT_GRTREQL_SYSDAT","DS") +"<br>"
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return;
		}
	}

	if (document.getElementById("from").value != "" && document.getElementById("to").value != "") {
		var languageId=document.getElementById("languageId").value;
//		var flag = isBefore(document.getElementById("to").value, document.getElementById("from").value, "DMY",languageId);
		var flag = compareDates(document.getElementById("from").value,document.getElementById("to").value,'en',"DMYHM");
		if(flag== -1){
			var n_msg = "Nil By Mouth";
			var f_msg = "From Date";
			var t_msg = "To date";
			var msg = "should be greater than"
			//var error = msg+" "+n_msg+" "+f_msg+" "+t_msg;
				var error=getMessage("DS_NBMTODTIM_GRTREQL_FRMDTIM","DS");//"Nil By Mouth To date time should be greater than or equal to Nil By Mouth From date Time";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			return false;
		}else if(document.getElementById("from").value != "" && document.getElementById("to").value != ""){
			var date=new Date();
			var error ="";
			var month=date.getMonth();
			var date1=date.getDate();
			var year=date.getYear();
			var hour=date.getHours();
			var minute=date.getMinutes();
			month+=1;
			if(date1<=9){
				date1="0"+""+date1;
			}
			if(month<=9){
				month="0"+""+month;
			}
			if(hour<=9){
				hour="0"+""+hour;
			}
			if(minute<=9){
				minute="0"+""+minute;
			}
			var sysDate=date1+"/"+month+"/"+year+" "+hour+":"+minute;
			var chkFlag =  compareFromDate(document.getElementById("from").value,sysDate,languageId,"DMYHM");
			if(chkFlag == -1){
				error =getMessage("DS_NBMFRMDTIM_NOTLES_CURDTIM","DS");// "Nil By Mouth From Date Time should not be less than Current Date Time";
				parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}else{

				//427 validation for out of range starts
				var profileFlag=$('#profileFlag').val();
				var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
				var maximum_days_allowed=$('#maximum_days_allowed').val();
				if(restrict_date_inpatients_yn=="Y" && profileFlag=="true"){
				//var flagtemp=grayOutCalendarValidation(document.getElementById("from").value,maximum_days_allowed);
				var flagtemp=grayOutDateTimeCalendarValidation(document.getElementById("from").value,maximum_days_allowed);
				if(flagtemp){
				//nill by mounth from date is within the range
				//now check nill by mounth to date for range
				//flagtemp=grayOutCalendarValidation(document.getElementById("to").value,maximum_days_allowed);
				flagtemp=grayOutDateTimeCalendarValidation(document.getElementById("to").value,maximum_days_allowed);
				if(flagtemp){
					//nill by mounth to date is within the range
					oldOrderChk();
				}else{
					//nill by mounth to date out of range
					if (parent.frames.messageFrame) {
					//Error Message for From Date is out of range
					//<fmt:message key="eOT.nilBYMounth.Label" bundle="${ot_labels}" />
					var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
					fieldName+=" ";
					fieldName+=getLabel("Common.todate.label","common");
					var sysdate=getCurrentDate("DMH",locale);
					var maxdate=addDays(new Date(),maximum_days_allowed);
					var maxToDate=changeDate(maxdate);
					var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
					var msgArray=msg.split("#");
					error="";
					//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
					error+=fieldName;
					error+=msgArray[1];
					error+=sysdate;
					error+=msgArray[2];
					error+=maxToDate;

					parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
					$('#to').focus();
					$('#to').select();

				} else {
					top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				return false;
				}

				}else{
				//nill by mounth from date out of range
				{
				if (parent.frames.messageFrame) {
					//Error Message for From Date is out of range
					//<fmt:message key="eOT.nilBYMounth.Label" bundle="${ot_labels}" />
					var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
					fieldName+=" ";
					fieldName+=getLabel("Common.fromdate.label","common");
					var sysdate=getCurrentDate("DMH",locale);
					var maxdate=addDays(new Date(),maximum_days_allowed);
					var maxToDate=changeDate(maxdate);
					var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
					var msgArray=msg.split("#");
					error="";
					//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
					error+=fieldName;
					error+=msgArray[1];
					error+=sysdate;
					error+=msgArray[2];
					error+=maxToDate;

					parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
					$('#from').focus();
					$('#from').select();
				} else {
					top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				}
				return false;
				}
				}
				}else{
				//427 crf is off
					oldOrderChk();
				}
				//427 validation for out of range ends
				//oldOrderChk(); org
			}
		}else{
			oldOrderChk();
		}
	}else{
		oldOrderChk();
	}
	}//CRF-410 else End
}

function oldOrderChk()
{
	if(document.getElementById("dateFrom").value != "" && document.getElementById("dateTo").value != ""){
		var locale=document.getElementById("languageId").value;
		var date=new Date();
		var month=date.getMonth();
		var date1=date.getDate();
		var year=date.getYear();
		month+=1;
		if(date1<=9){
			date1="0"+""+date1;
		}
		if(month<=9){
			month="0"+""+month;
		}
		var sysDate=date1+"/"+month+"/"+year;

//		var flag = isBeforeNow(document.getElementById("dateFrom").value,"DMY",locale);

		//var flag = compareDate(document.getElementById("dateFrom").value,sysDate);
		var frDate = convertDate(document.getElementById("dateFrom").value,'DMY',locale,'en');
		var flag = compareDate(frDate,sysDate);
		if(flag == -1){
			var error="";
			var msg = "App-DS0011 # should be greater than or equals to";
			var msg_key = msg.split("#");
			var f_date = "From Date";
			var t_date = "To Date";
			var s_date = "SysDate";
			//error = error+" "+msg_key[0]+" "+f_date+" "+msg_key[1]+" "+s_date+"<br>"
			error = error + getMessage("DS_FRDAT_GRTREQL_SYSDAT","DS") +"<br>";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return;
		}

		if(flag){
//			var flagT = isBeforeNow(document.getElementById("dateTo").value,"DMY",locale);
			//var flagT = compareDate(document.getElementById("dateTo").value,sysDate);
			var tDate = convertDate(document.getElementById("dateTo").value,'DMY',locale,'en');
			var flagT = compareDate(tDate,sysDate);
			if(flagT == -1){
				var error="";
				var msg = "App-DS0011 # should be greater than or equals to";
				var msg_key = msg.split("#");
				var f_date = "From Date";
				var t_date = "To Date";
				var s_date = "SysDate";
				//error = error+" "+msg_key[0]+" "+t_date+" "+msg_key[1]+" "+s_date+"<br>"
				error = error+ getMessage("DS_TODAT_GRTREQL_SYSDAT","DS") +"<br>";
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
			}else{
				checkNull1();
			}
		}else{
			checkNull1();
		}
	}else{
		checkNull1();
	}
}

async function checkNull1()
{
	checkDietTypeModified();
	tableObj = document.getElementById("Able");
	var servingDate = $('#servingDate').val();
	var selectedProfile = document.getElementById("selectedProfile").value;
	//ML-MMOH-CRF-0684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
		isMenuType=document.getElementById("isMenuType").value;
	if(isMenuType=="true"){
	var menu_type = document.getElementById("menu_type").value;
	}
	//ML-MMOH-CRF-0684

	var profileFlag=$('#profileFlag').val();//MMOH-CRF-427
	// Refer to Dietician IN 42110
	
	//CRF-410 starts
	if($("#Full_Day_NBM_YN").is(':checked')){
			diet_Category="";
	}else{		
		Full_Day_NBM_YN="N";
	}
	//CRF-410 ends
	
	if(tableObj.rows.length == 1 && (diet_Category != null && diet_Category != "")
			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != ""))
	{
		Menu_Flag=false;//ML-MMOH-CRF-409
		//var error = 	getMessage("DS_MENU_NOT_DEFINED","DS");//Commented against ML-MMOH-CRF-1124
		var error = 	getMessage("DS_MENU_NOT_DEFINED_MC_DT","DS");//ML-MMOH-CRF-1124
		parent.frames.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
		return false;
	}

	var f1 = true;
	var objs = new Array();

	objs[0] = document.getElementById("dateFrom");
	objs[1] = document.getElementById("mealClass");
	objs[2] = document.getElementById("dietType");
	objs[3] = document.getElementById("dietCategory");
	//ML-MMOH-CRF-0427 US3 starts
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();

	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
		objs[4] = document.getElementById("dateTo");
	}
	//ML-MMOH-CRF-0427 US3 ends

	//ML-MMOH-CRF-0684
	if(isMenuType=="true"){
    	objs[5] = document.getElementById("menu_type");//CRF-684
	}
	//ML-MMOH-CRF-0684

	var objsFields = new Array();

		objsFields[0] = "From Date";
    	objsFields[1] = "Meal Class";
    	objsFields[2] = "Diet Type";
    	objsFields[3] = "Diet Category";

	//ML-MMOH-CRF-0427 US3 starts
	//if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){//CRF-412
		objsFields[4]="To Date";
	//Added for ML-MMOH-CRF-0684
	if(isMenuType=="true"){
		objsFields[5]="Menu Type";
	}
	//Added for ML-MMOH-CRF-0684
	//}//CRF-412
	//ML-MMOH-CRF-0427 US3 ends
    if (!checkNulls(objsFields, objs))
    {
        return false;
    }

    var objsFields = new Array();
    var obj = document.getElementsByName("dietTypesForMeals");
    var error = "";
    if(obj != null)
    {
    	for (var i = 0; i < obj.length; i++)
    	{
            if (obj[i].value == "")
            {
                var mesg = getMessage("DS_DIETCYC_NOT_BLANK","DS");//"Diet Cycle can not be blank For Assign Diet Type";
                error = mesg;
                parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
                return false;
            }
        }
    }
	
    if (!code && (diet_Category != null && diet_Category != ""))
    {	
        if (parent.frames.messageFrame) {
        	//var msg =getMessage("DS_MENU_NOT_DEFINED","DS"); //Commented against ML-MMOH-CRF-1124
		var msg =getMessage("DS_MENU_NOT_DEFINED_MC_DT","DS"); //ML-MMOH-CRF-1124
		
		var error=msg;
        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        } else {
            top.content.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
        return false;
    }    

    // Refer to Dietician IN 42110
    if(document.getElementById("dieticianReferral").checked ==  true && (
    		diet_Category == "" || document.getElementById("dateFrom").value == ""
    		|| document.getElementById("mealClass").value == ""
    		|| document.getElementById("dietType").value == ""))
    {
		var dieticianReferral = "Y";
		document.getElementById("dietCatImage").style.visibility = "hidden";
		document.getElementById("fromDateImage").style.visibility = "hidden";
		document.getElementById("MealClassImage").style.visibility = "hidden";
		document.getElementById("dietTypeImage").style.visibility = "hidden";
		var dialogUrl1 = "../../eDS/jsp/ReferToDietcian.jsp?&dieticianReferral="+dieticianReferral;
		var dialogFeatures = "dialogHeight:5;dialogWidth:31;status:no;scroll:no";
		var returnValue =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
		if(returnValue != ""){
			referrToDietcian = returnValue;
			if(referrToDietcian == undefined){
				referrToDietcian = "";
				return false;
			}else{
				referrToDietcian = referrToDietcian;
			}
		}
	}
	else if(document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != ""))
	{
		referrToDietcian = "Y";
	}
	else if(document.getElementById("dieticianReferral").checked ==  true)
		referrToDietcian = "Y";
	else if(document.getElementById("dieticianReferral").checked ==  false)
		referrToDietcian = "";

	// MMS-QH-CRF-0078.1-US003 validation starts 58570
	var GEN_MEALPLAN_FOR_NBM_PAT_YN=$('#GEN_MEALPLAN_FOR_NBM_PAT_YN').val();
	if(GEN_MEALPLAN_FOR_NBM_PAT_YN=="Y"){
	if(document.getElementById("from").value != "" && document.getElementById("to").value == ""){
		var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
		fieldName+=" ";
		fieldName+=getLabel("Common.todate.label","common");
		var message=getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName );

		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
		$('#to').focus();
		$('#to').select();
		return false;

	}else if(document.getElementById("to").value != "" && document.getElementById("from").value == ""){
		var fieldName=getLabel("eOT.nilBYMounth.Label","ot_labels");
		fieldName+=" ";
		fieldName+=getLabel("Common.fromdate.label","common");
		var message=getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName );

		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
		$('#from').focus();
		$('#from').select();
		return false;
	}
	}
	// MMS-QH-CRF-0078.1-US003 validation ends 58570

    if (document.getElementById("dateFrom").value != "" && document.getElementById("dateTo").value != "")
    {
		var locale=document.getElementById("languageId").value;
		// var flag = isAfter(document.getElementById("dateFrom").value, document.getElementById("dateTo").value,"DMY",locale);
		var flag = compareDate(document.getElementById("dateFrom").value, document.getElementById("dateTo").value);
		var flag1=false;
		if (flag==1)
			flag1=true;
        check(flag1);
    }
    else
    {
		var flag = isAfter(document.getElementById("dateFrom").value, document.getElementById("testDate").value,"DMY",locale);
    	if (flag && document.getElementById("dateFrom").value != "" && document.getElementById("dateFrom").value != document.getElementById("testDate").value
    			&& document.getElementById("testDate").value != "" && (diet_Category != null && diet_Category != "")
    			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
    			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
    			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != ""))
    	{
    		var locale=document.getElementById("languageId").value;
    		var flag = isAfter(document.getElementById("dateFrom").value, document.getElementById("testDate").value,"DMY",locale);
		if(checkFullNBMProfileOverLap()){return false;}		//CRF-410
    		submitAll(flag);
    	}
    	else
    	{
    		var obj = document.getElementById("dietTypesForMeals");
    		if(obj != null)
    		{
    			for (var i = 0; i < obj.length; i++)
    			{
                    obj[i].disabled = false;
                }
    		}
    		var fromDate=document.getElementById("dateFrom").value;
    		var dateTo=document.getElementById("dateTo").value;
			var locale=document.getElementById("languageId").value;
			var dateFormate=document.getElementById("datepattrn1").value;
			var flag = document.getElementById("flag").value;
			var dieticianSuccess = false;
			if(flag == "N")
			{
				//var fromDate = convertDate(fromDate,'DMY','en',locale);
				document.getElementById("dateFrom").value=fromDate;
				var fromDate = convertDate(fromDate,'DMY',locale,'en');
				document.getElementById("dateTo").value="";
				var obMeal = new Array();
				var obDiet = new Array();
				var count = 0;
				var countMeal = 0;
				var objMeal = document.getElementsByName("mealTypesforDietTypes");
				if(objMeal != null){
					for (var i = 0; i < objMeal.length; i++) {
						if (objMeal[i].value != "") {
							obMeal[countMeal++] = objMeal[i].value;
						}
					}
				}
				var obj = document.getElementsByName("dietTypesForMeals");
				if(obj != null){
					for (var i = 0; i < obj.length; i++) {
						if (obj[i].value != "") {
							obDiet[count++] = obj[i].value;
						}
					}
					//Added against ML-MMOH-CRF-0968-US001 & CRF-1123 starts here
					if(isMenuType=="true"){
						if (obDiet.indexOf(dType) == -1 && document.getElementById("dieticianReferral").checked !=  true){
						alert(getMessage("DS_DTYPE_DIFF_OBDIET","DS"));
						return false;		
						}
						else{
						submitStatus = true;
						} 
					}
					//Added against ML-MMOH-CRF-0968-US001 & CRF-1123 ends here
				}
				var encounterId=document.getElementById("encounterId").value
				var profileSL=document.getElementById("profileSL").value;
				if(profileSL=="" || profileSL == "0" || profileSL == null )
					profileSL="0";
				var addedById = document.getElementById("addedById").value;
				var addedAtWsNo = document.getElementById("addedAtWsNo").value;
				var addedFacilityId = document.getElementById("addedFacilityId").value;
				//document.getElementById("isNEW").value = true;
				var patientId = document.getElementById("Patient_ID").value;
				var patientClass = document.getElementById("patientClass").value;
				var locationType = document.getElementById("locationType").value;
				var locationCode = document.getElementById("locationCode").value;
				var mClass = document.getElementById("mealClass").value;
				var dType =document.getElementById("dietType").value;
				var from =document.getElementById("from").value;
				var to =document.getElementById("to").value;
				// Refer to Dietician IN 42110
				//var dieticianReferral =document.getElementById("dieticianReferral").checked?'Y':'';
				var dieticianReferral = null;
				if(referrToDietcian == null && document.getElementById("dieticianReferral").checked == true)
					dieticianReferral = "Y"
				else if(referrToDietcian == "Y" || referrToDietcian == "")
				{ 
					dieticianReferral = referrToDietcian;
					dieticianSuccess = true;
				}
				else
					dieticianReferral = "";
				var feedingInstructions =document.getElementById("feedingInstructions").value;
				var prepInstr =document.getElementById("prepInstr").value;
				var feedType =document.getElementById("feedType").value;
				var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
				var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
				//var dietCycleType = document.getElementById("dayRef").value;
				var status = document.getElementById("status").value;
				var atndInstr =document.getElementById("atndInstr1").value;//ML-MMOH-SCF-0735
				var nutrientDeleteFlag =document.getElementById("nutrientDeleteFlag").value;
				if(isMenuType=="true"){
				var menu_type =document.getElementById("menu_type").value;//CRF-684
				}
				//SCF-735
				var pateintRadio="No";
				if(document.getElementById("Suballocator").checked == true){
					pateintRadio= document.getElementById("Suballocator").value; 
				}
				//SCF-735
				var ordersForCancellation = verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile);
				if(checkFullNBMProfileOverLap()){return false;}		//CRF-410 21Dec	
				if(ordersForCancellation.length > 0 && !window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + ordersForCancellation + "Do you wish to continue?")) return false;

				// changes for ML-MMOH-CRF-0428				
				if((document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
				&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
				&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
				&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != "")) || (document.getElementById("dieticianReferral").checked ==  false )){
				if(checkIfAllMealTypesExcluded()) {
				
				if(!$("#Full_Day_NBM_YN").is(':checked')){			
					var message="Atleast one meal should be selected for the Diet Order"
					parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
					return false;
				}
				}				
				}
				checkIrregularMeal();
				
				if(checkFullNBMProfileOverLap()){return false;}	//CRF-410
				//JSONobj={};//ML-MMOH-CRF-412
				// changes for ML-MMOH-CRF-0428 ends here
				JSONobj={};//ML-MMOH-CRF-412
					var mode = "insertMealContents";
					var xmlDoc="" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					var paramTer="&encounterId="+encounterId
					+"&diet_Category="+diet_Category
					+"&addedById="+addedById
					+"&addedFacilityId="+addedFacilityId
					+"&isNEW="+document.getElementById("isNEW").value
					+"&profileSL="+profileSL
					+"&patientId="+patientId
					+"&patientClass="+patientClass
					+"&locationType="+locationType
					+"&locationCode="+locationCode
					+"&addedAtWsNo="+addedAtWsNo
					+"&objMeal="+obMeal
					+"&obDiet="+obDiet
					+"&mClass="+mClass
					+"&dType="+dType
					+"&fromDate="+fromDate
					+"&dateTo="+dateTo
					+"&from="+from
					+"&to="+to
					+"&dieticianReferral="+dieticianReferral
					+"&feedingInstructions="+encodeURIComponent(feedingInstructions)
					+"&prepInstr="+encodeURIComponent(prepInstr)
					+"&feedType="+feedType
					+"&dsDeliveryInstr="+dsDeliveryInstr
					+"&texture_of_diet="+texture_of_diet//ML-MMOH-CRF-412
					//+"&dietCycleType="+dietCycleType
					+"&status="+status
					+"&attdietList="+attdietList
					+"&foodDislikeListArr="+foodDislikeListArr
					+"&delFoodDis="+delFoodDisList
					+"&returnRemarks="+encodeURIComponent((returnRemarks))
					+"&atndInstr="+atndInstr
					+"&nutrientSuppListArr="+nutrientSuppListArr
					+"&nutrientDeleteFlag="+nutrientDeleteFlag
					+"&mealExclusions="+JSON.stringify(excludedMeals)
					+"&irregular_meal_code="+irregular_meal_code
					+"&dietTypeModified_YN="+DietTypeModified_YN
					+"&Full_Day_NBM_YN="+Full_Day_NBM_YN//CRF-410
					+"&menu_type="+menu_type//CRF-684
					+"&mode="+mode;						
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
					xmlHttp.send(xmlDoc);
					retVal = localTrimString(xmlHttp.responseText);
					var arrVal = retVal.split(",");
					var row_ind = 1;
					var tableObj3 = document.getElementById("result_Id");
					while (tableObj3.rows.length > 1)
						tableObj3.deleteRow(1);
				if(arrVal != null && arrVal != "")
				{
					var recordToUpdate = -1;
					recordToUpdate = toLoadDetails(arrVal);
					checkStatus("A~F",document.all("status"));
					document.getElementById("status").value="A~F";
					submitStatus = true;
					chkFormValChange = false;
				}
				else if(dieticianSuccess)
				{
					chkFormValChange = false;//Added against 058678
					//var message = getMessage("DS_OPER_COMPLETE","DS");// "APP-DS0001 Operation Completed Successfully...";
					var message = "APP-DS0001 Operation Completed Successfully...";
					
					//CRF-410 starts
					document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value;
						updateMealMenuDate();			
					if(Full_Day_NBM_YN=="Y"){
						reset();
					}
					//CRF-410 ends
					parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
				}
			//}//Commented against 058678
			if(submitStatus)
			{
				chkFormValChange = false;//Fix for 058678
				var message = getMessage("DS_OPER_COMPLETE","DS"); //"APP-DS0001 Operation Completed Successfully...";
///					document.getElementById("profileSL").value = profileSL;
				document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value;  //AMRI-SCF-0385 [IN:056722]
///					document.getElementById("maxprofileSL").value = profileSL;
						updateMealMenuDate();
						parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
			}
			}
			else
			{
				//  For the Discharge Patients
				var flag = document.getElementById("flag").value;
				//var fromDate = convertDate(fromDate,'DMY','en',locale);
				var fromDate = convertDate(fromDate,'DMY',locale,'en');
				if(fromDate!=""){
					document.getElementById("dateFrom").value=fromDate;
					var dateChk = compareSysDate(fromDate);
					if(dateChk == 1){
		 				var error= getMessage("DS_FMDAT_SYSDAT_GRACPER","DS"); //"From date should be System date for Grace Period Patients";
		 				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		 				return false;
					}else if(dateTo!=""){
						var locale=document.getElementById("languageId").value;
						var dateFormate=document.getElementById("datepattrn1").value;
						var dateTo=document.getElementById("dateTo").value;
						//var dateTo = convertDate(fromDate,'DMY','en',locale);
						var dateTo = convertDate(fromDate,'DMY',locale,'en');
						document.getElementById("dateTo").value=dateTo;
						//PlaceDietOrderForm.submit();
						submitStatus = true;
					}else{
						document.getElementById("dateTo").value="";
						var obMeal = new Array();
						var obDiet = new Array();
						var count = 0;
				        var countMeal = 0;
						var disMealType = mealTypeObj.value;
						var objMeal = disMealType.split('@');

						if(objMeal != null){
				        	for (var i = 0; i < objMeal.length; i++) {
				                if (objMeal[i]!= "") {
				                    obMeal[countMeal++] = objMeal[i];
				                }
				        	}
				        }
				        var disDietType = dietTypeObj1.value;
				        var obj = disDietType.split('@');
				        if(obj != null){
				            for (var i = 0; i < obj.length; i++) {
				                if (obj[i]!= "") {
				                	obDiet[count++] = obj[i];
				                }
				            }
				        }
						var encounterId=document.getElementById("encounterId").value
						var profileSL=document.getElementById("profileSL").value;
						if(profileSL=="" || profileSL == "0" || profileSL == null ){
							profileSL="0";
						}
						var addedById = document.getElementById("addedById").value;
						var addedAtWsNo = document.getElementById("addedAtWsNo").value;
						var addedFacilityId = document.getElementById("addedFacilityId").value;
						//document.getElementById("isNEW").value = true;
						var patientId = document.getElementById("Patient_ID").value;
						var patientClass = document.getElementById("patientClass").value;
						var locationType = document.getElementById("locationType").value;
						var locationCode = document.getElementById("locationCode").value;
						var mClass = document.getElementById("mealClass").value;
						var dType =document.getElementById("dietType").value;
						var from =document.getElementById("from").value;
						var to =document.getElementById("to").value;
						var feedingInstructions =document.getElementById("feedingInstructions").value;
						var prepInstr =document.getElementById("prepInstr").value;
						var feedType =document.getElementById("feedType").value;
						var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
						var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
						//var dietCycleType = document.getElementById("dayRef").value;
						var status = document.getElementById("status").value;
						var atndInstr =document.getElementById("atndInstr1").value;//ML-MMOH-SCF-0735
						var nutrientDeleteFlag =document.getElementById("nutrientDeleteFlag").value;
						if(isMenuType=="true"){
						var menu_type =document.getElementById("menu_type").value;//CRF-684
						}
						//SCF-735
						var pateintRadio="No";
						if(document.getElementById("Suballocator").checked == true){
						 pateintRadio= document.getElementById("Suballocator").value; 
						}
						//SCF-735
						var ordersForCancellation = verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile);
						if(checkFullNBMProfileOverLap()){return false;}		//CRF-410 21Dec	
						if(ordersForCancellation.length > 0 && !window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + ordersForCancellation + "Do you wish to continue?"))
							return false;
						// changes for ML-MMOH-CRF-0428						
						
						if((document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
					&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
					&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
					&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != "")) || (document.getElementById("dieticianReferral").checked ==  false )){
						if(checkIfAllMealTypesExcluded()) {
							var message="Atleast one meal should be selected for the Diet Order "
							parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
							return false;
						}						
			}			
				checkIrregularMeal();
				if(checkFullNBMProfileOverLap()){return false;}	//CRF-410
				JSONobj={};//ML-MMOH-CRF-412
				// changes for ML-MMOH-CRF-0428 ends here
				var mode = "insertMealContents";
				var xmlDoc="" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				var paramTer="&encounterId="+encounterId
				+"&diet_Category="+diet_Category
				+"&addedById="+addedById
				+"&addedFacilityId="+addedFacilityId
				+"&isNEW="+document.getElementById("isNEW").value
				+"&profileSL="+profileSL
				+"&patientId="+patientId
				+"&patientClass="+patientClass
				+"&locationType="+locationType
				+"&locationCode="+locationCode
				+"&addedAtWsNo="+addedAtWsNo
				+"&objMeal="+obMeal
				+"&obDiet="+obDiet
				+"&mClass="+mClass
				+"&dType="+dType
				+"&fromDate="+fromDate
				+"&dateTo="+dateTo
				+"&from="+from
				+"&to="+to
				+"&feedingInstructions="+encodeURIComponent(feedingInstructions)
				+"&prepInstr="+encodeURIComponent(prepInstr)
				+"&feedType="+feedType
				+"&dsDeliveryInstr="+dsDeliveryInstr
				+"&texture_of_diet="+texture_of_diet//ML-MMOH-CRF-412
				//+"&dietCycleType="+dietCycleType
				+"&status="+status
				+"&attdietList="+attdietList
				+"&foodDislikeListArr="+foodDislikeListArr
				+"&delFoodDis="+delFoodDisList
				+"&flag="+flag
				+"&returnRemarks="+encodeURIComponent((returnRemarks))
				+"&atndInstr="+atndInstr
				+"&nutrientSuppListArr="+nutrientSuppListArr
				+"&nutrientDeleteFlag="+nutrientDeleteFlag
				+"&mealExclusions="+JSON.stringify(excludedMeals)
				+"&irregular_meal_code="+irregular_meal_code
				+"&dietTypeModified_YN="+DietTypeModified_YN
				+"&Full_Day_NBM_YN="+Full_Day_NBM_YN//CRF-410
				+"&menu_type="+menu_type//CRF-684
				+"&mode="+mode;
				
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
				xmlHttp.send(xmlDoc);
				retVal = localTrimString(xmlHttp.responseText);
				var arrVal = retVal.split(",");
				var row_ind = 1;
				var tableObj3 = document.getElementById("result_Id");
				while (tableObj3.rows.length > 1)
					tableObj3.deleteRow(1);
				if(arrVal != null)
				{
					var recordToUpdate = -1;
					recordToUpdate = toLoadDetails(arrVal);
					checkStatus("A~F",document.all("status"));
					document.getElementById("status").value="A~F";
					submitStatus = true;
					chkFormValChange = false;
				}
				if(submitStatus){
					var message =  getMessage("DS_OPER_COMPLETE","DS");// "APP-DS0001 Operation Completed Successfully...";
///						document.getElementById("profileSL").value = profileSL;
				document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value //AMRI-SCF-0385 [IN:056722]
///						document.getElementById("maxprofileSL").value = profileSL;
					updateMealMenuDate();
					parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
//							attdietList = new Array(); //IN::39937
				}
					}
				}

			}
    	}
    }
    return true;
}

function check(flag)
{
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	var dieticianSuccess = false;
	var servingDate = $('#servingDate').val();
	var selectedProfile = document.getElementById("selectedProfile").value;
	var dType =document.getElementById("dietType").value;
	if (flag)
	{
        error = "";
        key_value = "";
        var msg = "App-DS0012 # should be lesser than or equals to";
        key = msg;
		var f_date = "From Date";
		key1=key.indexOf()
		var t_date ="To Date" ;
		key1=key.split("#");

		//error = error +" "+ key1[0] +" "+ f_date+" "+key1[1]+" "+t_date+"<br>";
		error = error + getMessage("DS_TODATE_GRTR_FRMDATE","DS") +"<br>";
        if (parent.frames.messageFrame) {
        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        } else {
            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
        return false;
    }

	//MMOH-CRF-427
	if(!flag){
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	//document.getElementById("dateFrom").value, document.getElementById("dateTo").value
	if(restrict_date_inpatients_yn=="Y" && profileFlag=="true"){
	var flagtemp=grayOutCalendarValidation(document.getElementById("dateFrom").value,maximum_days_allowed);
	var locale=document.getElementById("language_Id").value;
	if(flagtemp){
		flagtemp=grayOutCalendarValidation(document.getElementById("dateTo").value,maximum_days_allowed);
		if(!flagtemp){
		if (parent.frames.messageFrame) {
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(new Date(),maximum_days_allowed);
			var maxToDate=changeDate(maxdate);
	
			var fieldName=getLabel("Common.todate.label","common");
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			error="";
			//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;
	        parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	    	$('#dateTo').value = '';
	    	$('#dateTo').focus();
			$('#dateTo').select();
        } else {
            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
		return false;
		}

	}else{
		if (parent.frames.messageFrame) {
			//Error Message for From Date is out of range
			var fieldName=getLabel("Common.fromdate.label","common");
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(new Date(),maximum_days_allowed);
			var maxToDate=changeDate(maxdate);
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			error="";
			//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;

        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        	$('#dateFrom').value = '';
        	$('#dateFrom').focus();
			$('#dateFrom').select();

        } else {
            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
        }
		return false;
	}
	}
	}
	//MMOH-CRF-427
	var flag = isAfter(document.getElementById("dateFrom").value, document.getElementById("testDate").value,"DMY",locale);
    if (flag && document.getElementById("dateFrom").value != document.getElementById("testDate").value && document.getElementById("testDate").value != ""
    	&& (diet_Category != null && diet_Category != "") && (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
    	&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
    	&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != ""))
    {
		var locale=document.getElementById("languageId").value;
		var flag = isAfter(document.getElementById("dateFrom").value, document.getElementById("testDate").value,"DMY",locale);
		if(checkFullNBMProfileOverLap()){return false;}		//CRF-410
		submitAll(flag);
    }
    else if(document.getElementById("flag").value == "N")
    {
		var locale=document.getElementById("languageId").value;
		var dateFormate=document.getElementById("datepattrn1").value;
		var frmDate=document.getElementById("dateFrom").value;
		var fromDate = convertDate(frmDate,'DMY',locale,'en');
		var datTo=document.getElementById("dateTo").value;
		var dateTo = convertDate(datTo,'DMY',locale,'en');
		var obMeal = new Array();
		var obDiet = new Array();
		var count = 0;
        var countMeal = 0;
		var objMeal = document.getElementsByName("mealTypesforDietTypes");
        if(objMeal != null){
        	for (var i = 0; i < objMeal.length; i++) {
                if (objMeal[i].value != "") {
                    obMeal[countMeal++] = objMeal[i].value;
                }
        	}
        }
        var obj = document.getElementsByName("dietTypesForMeals");
        if(obj != null){
		   for (var i = 0; i < obj.length; i++) {
		       if (obj[i].value != "") {
		           	obDiet[count++] = obj[i].value;
		       }
		   }
		   //Added against ML-MMOH-CRF-0968-US001 && CRF-1123 starts here
			if(isMenuType=="true"){ 
				if (obDiet.indexOf(dType) == -1 && document.getElementById("dieticianReferral").checked !=  true){
				alert(getMessage("DS_DTYPE_DIFF_OBDIET","DS"));
				return false;		
				}
				else{
				submitStatus = true;
				} 
			}	
			//Added against ML-MMOH-CRF-0968-US001 && CRF-1123 ends here
        }
		var encounterId=document.getElementById("encounterId").value
		var profileSL=document.getElementById("profileSL").value;
		if(profileSL=="" || profileSL == "0" || profileSL == null )
			profileSL="0";
		else
			profileSL = profileSL;
		var addedById = document.getElementById("addedById").value;
		var addedAtWsNo = document.getElementById("addedAtWsNo").value;
		var addedFacilityId = document.getElementById("addedFacilityId").value;
		//document.getElementById("isNEW").value = true;
		var patientId = document.getElementById("Patient_ID").value;
		var patientClass = document.getElementById("patientClass").value;
		var locationType = document.getElementById("locationType").value;
		var locationCode = document.getElementById("locationCode").value;
		var mClass = document.getElementById("mealClass").value;
		var dType =document.getElementById("dietType").value;
		var from =document.getElementById("from").value;
		var to =document.getElementById("to").value;
		// Refer to Dietician IN 42110
		//var dieticianReferral =document.getElementById("dieticianReferral").checked?'Y':'N';
		var dieticianReferral = null;
		if(referrToDietcian == null && document.getElementById("dieticianReferral").checked == true){
			dieticianReferral = "Y"
		}else if(referrToDietcian == "Y" || referrToDietcian == ""){
			dieticianReferral = referrToDietcian;
			dieticianSuccess = true;
		}else{
			dieticianReferral = "";
		}
		var feedingInstructions =document.getElementById("feedingInstructions").value;
		var prepInstr =document.getElementById("prepInstr").value;
		var feedType =document.getElementById("feedType").value;
		var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
		var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
		var dietCycleType = document.getElementById("dayRef").value;
		var status = document.getElementById("status").value;
		var atndInstr =document.getElementById("atndInstr1").value;//ML-MMOH-SCF-0735
		var nutrientDeleteFlag =document.getElementById("nutrientDeleteFlag").value;
		if(isMenuType=="true"){
			var menu_type = document.getElementById("menu_type").value;//CRF-684
		}//SCF-735
		var pateintRadio="No";
		if(document.getElementById("Suballocator").checked == true){
		 pateintRadio= document.getElementById("Suballocator").value; 
		}
		//SCF-735		

		var ordersForCancellation = verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile);
		if(checkFullNBMProfileOverLap()){return false;}		//CRF-410 21Dec	
		if(ordersForCancellation.length > 0 && !window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + ordersForCancellation + "Do you wish to continue?"))
			return false;

		// Start AMRI-SCF-0385 [IN:056722]
		//if((document.getElementById("isNEW").value != 'false')&& (fromDate != servingDate) && (dateTo != servingDate)){
		//submitStatus = false;
		//else {
		// changes for ML-MMOH-CRF-0428
		/*var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
		if(irregular_enabled=="Y") addAutomaticExclusions();
		var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
		$.each(automatic_excluded_meal_types,function(index,value) {
		msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
		});
		if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") alert(msg_exclusions);*/
		
		if((document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != "")) || (document.getElementById("dieticianReferral").checked ==  false && document.getElementById("Full_Day_NBM_YN").checked ==  false)){//CRF-410
		if(checkIfAllMealTypesExcluded()) {
			var message="Atleast one meal should be selected for the Diet Order "
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
			return false;
		}
		/*if(checkAutoExclusions()) {
			var message="All Meals are automatically excluded for today "
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
			return false;
		}*/
		}
		checkIrregularMeal();
		if(checkFullNBMProfileOverLap()){return false;}	//CRF-410
		JSONobj={};//ML-MMOH-CRF-412
		// changes for ML-MMOH-CRF-0428 ends here
		var mode = "insertMealContents";
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		var paramTer="&encounterId="+encounterId
			+"&diet_Category="+diet_Category
			+"&addedById="+addedById
			+"&addedFacilityId="+addedFacilityId
			+"&isNEW="+document.getElementById("isNEW").value
			+"&profileSL="+profileSL
			+"&patientId="+patientId
			+"&patientClass="+patientClass
			+"&locationType="+locationType
			+"&locationCode="+locationCode
			+"&addedAtWsNo="+addedAtWsNo
			+"&objMeal="+obMeal
			+"&obDiet="+obDiet
			+"&mClass="+mClass
			+"&dType="+dType
			+"&fromDate="+fromDate
			+"&dateTo="+dateTo
			+"&from="+from
			+"&to="+to
			+"&dieticianReferral="+dieticianReferral
			+"&feedingInstructions="+encodeURIComponent(feedingInstructions)
			+"&prepInstr="+encodeURIComponent(prepInstr)
			+"&feedType="+feedType
			+"&dsDeliveryInstr="+dsDeliveryInstr
			+"&texture_of_diet="+texture_of_diet//ML-MMOH-CRF-412
			+"&dietCycleType="+dietCycleType
			+"&status="+status
			+"&attdietList="+attdietList
			+"&foodDislikeListArr="+foodDislikeListArr
			+"&delFoodDis="+delFoodDisList
			+"&returnRemarks="+encodeURIComponent((returnRemarks))
			+"&atndInstr="+atndInstr
			+"&nutrientSuppListArr="+nutrientSuppListArr
			+"&nutrientDeleteFlag="+nutrientDeleteFlag
			+"&mealExclusions="+JSON.stringify(excludedMeals)
			+"&irregular_meal_code="+irregular_meal_code
			+"&dietTypeModified_YN="+DietTypeModified_YN
			+"&Full_Day_NBM_YN="+Full_Day_NBM_YN//CRF-410
			+"&menu_type="+menu_type//CRF-684
			+"&mode="+mode+"&pateintRadio="+pateintRadio;//SCF-735
			
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
		xmlHttp.send(xmlDoc);
		retVal = localTrimString(xmlHttp.responseText);
		var arrVal = retVal.split(",");
		var row_ind = 1;
		var tableObj3 = document.getElementById("result_Id");
		while (tableObj3.rows.length > 1)
			tableObj3.deleteRow(1);
		if(arrVal != null && arrVal != "")
		{
			var recordToUpdate = -1;
			recordToUpdate = toLoadDetails(arrVal);
			checkStatus("A~F",document.all("status"));
			document.getElementById("status").value="A~F";
			submitStatus = true;
			chkFormValChange = false;
		}
		//}// End AMRI-SCF-0385 [IN:056722]
		else if(dieticianSuccess)
		{
			chkFormValChange = false;//Fix for 058678
			var message = getMessage("DS_OPER_COMPLETE","DS");// "APP-DS0001 Operation Completed Successfully...";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
		}
		// Start AMRI-SCF-0385 [IN:056722]
	/*	if((frmDate == servingDate)&&(datTo == servingDate))
		{
			submitStatus = false;
			var message = getMessage("DS_OPER_COMPLETE","DS");
			//document.getElementById("profileSL").value = document.getElementById("maxprofileSL").value;
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
		}*/
		// End AMRI-SCF-0385 [IN:056722]
	
		if(submitStatus)
		{
			var message = getMessage("DS_OPER_COMPLETE","DS"); //"APP-DS0001 Operation Completed Successfully...";
			//JSONobj={};--MUST BE ALWAYS IN COMMENT
			// added for 39937 (1)
			//document.getElementById("profileSL").value = profileSL;
			document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value;//AMRI-SCF-0385 [IN:056722]
			//document.getElementById("maxprofileSL").value = profileSL;
			updateMealMenuDate();
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
			reset();//CRF-410
		}
    }
    else
    {
    	//  For the Discharge Patients
		var flag = document.getElementById("flag").value;
		var locale=document.getElementById("languageId").value;
		var dateFormate=document.getElementById("datepattrn1").value;
		var frmDate=document.getElementById("dateFrom").value;
		var fromDate = convertDate(frmDate,'DMY',locale,'en');
		var datTo=document.getElementById("dateTo").value;
		var dateTo = convertDate(datTo,'DMY',locale,'en');
		var dateFlag = compareDatesForDisPat(fromDate,datTo);
 		if(dateFlag == 1)
 		{
 				//var error="From date and To date should be System date for Grace Period Patients";
 				var error= getMessage("DS_FMTODAT_SYSDAT_GRACPER","DS");
 				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
 				return false;
 		}
 		else if(fromDate!="" && dateTo!="")
		{
			var obMeal = new Array();
			var obDiet = new Array();
			var count = 0;
			var countMeal = 0;
			var disMealType = mealTypeObj.value;
			var objMeal = disMealType.split('@');
			if(objMeal != null){
				for (var i = 0; i < objMeal.length; i++) {
					if (objMeal[i]!= "") {
						obMeal[countMeal++] = objMeal[i];
					}
				}
			}
			var disDietType = dietTypeObj1.value;
			var obj = disDietType.split('@');
			if(obj != null){
				for (var i = 0; i < obj.length; i++) {
					if (obj[i]!= "") {
						obDiet[count++] = obj[i];
					}
				}
			}
			var encounterId=document.getElementById("encounterId").value
			var profileSL=document.getElementById("profileSL").value;
			if(profileSL=="" || profileSL == "0" || profileSL == null ){
				profileSL="0";
			}
			var addedById = document.getElementById("addedById").value;
			var addedAtWsNo = document.getElementById("addedAtWsNo").value;
			var addedFacilityId = document.getElementById("addedFacilityId").value;
			var patientId = document.getElementById("Patient_ID").value;
			var patientClass = document.getElementById("patientClass").value;
			var locationType = document.getElementById("locationType").value;
			var locationCode = document.getElementById("locationCode").value;
			var mClass = document.getElementById("mealClass").value;
			var dType =document.getElementById("dietType").value;
			var from =document.getElementById("from").value;
			var to =document.getElementById("to").value;
			var feedingInstructions =document.getElementById("feedingInstructions").value;
			var prepInstr =document.getElementById("prepInstr").value;
			var feedType =document.getElementById("feedType").value;
			var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
			var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
			var status = document.getElementById("status").value;
			var atndInstr =document.getElementById("atndInstr1").value;//ML-MMOH-SCF-0735
			var nutrientDeleteFlag =document.getElementById("nutrientDeleteFlag").value;
			if(isMenuType=="true"){
			var menu_type = document.getElementById("menu_type").value;//CRF-684
			}
			//SCF-735
			var pateintRadio="No";
			if(document.getElementById("Suballocator").checked == true){
			 pateintRadio= document.getElementById("Suballocator").value; 
			}
			//SCF-735
			var ordersForCancellation = verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile);
			if(checkFullNBMProfileOverLap()){return false;}		//CRF-410 21Dec	
			if(ordersForCancellation.length > 0 && !window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + ordersForCancellation + "Do you wish to continue?"))
				return false;
			// changes for ML-MMOH-CRF-0428
			/*var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
			if(irregular_enabled=="Y") addAutomaticExclusions();
			var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
			$.each(automatic_excluded_meal_types,function(index,value) {
			msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
			});
			if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") alert(msg_exclusions);*/
			
			if((document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != "")) || (document.getElementById("dieticianReferral").checked ==  false )){
			if(checkIfAllMealTypesExcluded()) {
				var message="Atleast one meal should be selected for the Diet Order "
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
				return false;
			}
			/*if(checkAutoExclusions()) {
				var message="All Meals are automatically excluded for today "
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
				return false;
			}*/
			}
			checkIrregularMeal();
			if(checkFullNBMProfileOverLap()){return false;}	//CRF-410

			JSONobj={};//ML-MMOH-CRF-412
			// changes for ML-MMOH-CRF-0428 ends here
			var mode = "insertMealContents";
			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			var paramTer="&encounterId="+encounterId
			+"&diet_Category="+diet_Category
			+"&addedById="+addedById
			+"&addedFacilityId="+addedFacilityId
			+"&isNEW="+document.getElementById("isNEW").value
			+"&profileSL="+profileSL
			+"&patientId="+patientId
			+"&patientClass="+patientClass
			+"&locationType="+locationType
			+"&locationCode="+locationCode
			+"&addedAtWsNo="+addedAtWsNo
			+"&objMeal="+obMeal
			+"&obDiet="+obDiet
			+"&mClass="+mClass
			+"&dType="+dType
			+"&fromDate="+fromDate
			+"&dateTo="+dateTo
			+"&from="+from
			+"&to="+to
			+"&feedingInstructions="+encodeURIComponent(feedingInstructions)
			+"&prepInstr="+encodeURIComponent(prepInstr)
			+"&feedType="+feedType
			+"&dsDeliveryInstr="+dsDeliveryInstr
			+"&texture_of_diet="+texture_of_diet//ML-MMOH-CRF-412
			//+"&dietCycleType="+dietCycleType
			+"&status="+status
			+"&attdietList="+attdietList
			+"&foodDislikeListArr="+foodDislikeListArr
			+"&delFoodDis="+delFoodDisList
			+"&returnRemarks="+encodeURIComponent((returnRemarks))
			+"&atndInstr="+atndInstr
			+"&nutrientSuppListArr="+nutrientSuppListArr
			+"&nutrientDeleteFlag="+nutrientDeleteFlag
			+"&flag="+flag
			+"&mealExclusions="+JSON.stringify(excludedMeals)
			+"&irregular_meal_code="+irregular_meal_code
			+"&dietTypeModified_YN="+DietTypeModified_YN
			+"&Full_Day_NBM_YN="+Full_Day_NBM_YN//CRF-410
			+"&menu_type="+menu_type//CRF-684
			+"&mode="+mode;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
			xmlHttp.send(xmlDoc);
			retVal = localTrimString(xmlHttp.responseText);
			var arrVal = retVal.split(",");
			var row_ind = 1;
			var tableObj3 = document.getElementById("result_Id");
			while (tableObj3.rows.length > 1) {
				tableObj3.deleteRow(1);
			}
			if(arrVal != null)
			{
				var recordToUpdate = -1;
				recordToUpdate = toLoadDetails(arrVal);
				checkStatus("A~F",document.all("status"));
				document.getElementById("status").value="A~F";
				submitStatus = true;
				chkFormValChange = false;
			}
			if(submitStatus)
			{
					var message =  getMessage("DS_OPER_COMPLETE","DS"); //"APP-DS0001 Operation Completed Successfully...";
///			document.getElementById("profileSL").value = profileSL;
				document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value //AMRI-SCF-0385 [IN:056722]
///			document.getElementById("maxprofileSL").value = profileSL;
				updateMealMenuDate();
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
			}
		}
    }
}

function submitAll(flag)
{
	//CRF -0684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	var check;
	var dieticianSuccess = false;
	var disChrFlag = document.getElementById("flag").value;
	var newProfile = false;
	var servingDate = $('#servingDate').val();
	var selectedProfile = document.getElementById("selectedProfile").value;
	var dType =document.getElementById("dietType").value;	
	
	var obMeal = new Array();
	var obDiet = new Array();
	var count = 0;
        var countMeal = 0;
	var objMeal = document.getElementsByName("mealTypesforDietTypes");
        if(objMeal != null){
        	for (var i = 0; i < objMeal.length; i++) {
                if (objMeal[i].value != "") {
                    obMeal[countMeal++] = objMeal[i].value;
                }
        	}
        }
        var obj = document.getElementsByName("dietTypesForMeals");
        if(obj != null){
		   for (var i = 0; i < obj.length; i++) {
		       if (obj[i].value != "") { 
		           	obDiet[count++] = obj[i].value;
				}		  
			}	 
			//Added against ML-MMOH-CRF-0968-US001 && CRF-1123 starts here 
			if(isMenuType=="true"){
				if (obDiet.indexOf(dType) == -1 && document.getElementById("dieticianReferral").checked !=  true){
				alert(getMessage("DS_DTYPE_DIFF_OBDIET","DS"));
				return false;		 
				}
				else{
				submitStatus = true;
				} 
			}
			//Added against ML-MMOH-CRF-0968-US001 && CRF-1123 ends here
        }
		//Added against MMS-KH-CRF-0029.1
		var enabledrugfoodYN = document.getElementById("enable_drugfood_YN").value;	
		if(enabledrugfoodYN=="Y")
		{
			//var Remarks_valid=f3;		
			var rem = encodeURIComponent((returnRemarks));
		if(rem=="" || rem=="null")
		{
			remark_yn = applyFinal(); //Added against MMS-KH-CRF-0029.1
			document.getElementById("remarkDrugAlert").value = remark_yn;
			var remark_alert_yn = document.getElementById("remarkDrugAlert").value;
			if(remark_alert_yn==" N")
				{
					alert(getMessage("DS_REM_NOT_BLANK","DS"));
					document.getElementById('REMARKS').focus();
					return false;
				}
				else if(remark_alert_yn==" Y")
				{
				return false;
				}
			}
			else if((rem!="" || rem!="null"))
			{
			remark_yn = applyFinal(); //Added against MMS-KH-CRF-0029.1
			document.getElementById("remarkDrugAlert").value = remark_yn;
			var remark_alert_yn = document.getElementById("remarkDrugAlert").value;

		if(remark_alert_yn==" Y")
		{
			return false;
		}
		}}
	//Added against MMS-KH-CRF-0029.1
	if(flag)
	{
		var msg = getMessage("DS_NEW_PRF_CREATD","DS"); // "New profile is created, this will be effective from";
		if(document.getElementById("dateTo").value!="")
			check = confirm(msg+" "+document.getElementById("dateFrom").value+" - "+document.getElementById("dateTo").value);
		else
			check = confirm(msg+" "+document.getElementById("dateFrom").value);
		newProfile = true;
	}
	if(check) {
		// changes for ML-MMOH-CRF-0428
		var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
		if(irregular_enabled=="Y") addAutomaticExclusions();
		var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
		$.each(automatic_excluded_meal_types,function(index,value) {
		msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
		});
		if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") 
			alert(msg_exclusions);
			checkIrregularMeal();
			if(checkFullNBMProfileOverLap()){return false;}	//CRF-410

			JSONobj={};//ML-MMOH-CRF-412
		// changes for ML-MMOH-CRF-0428 ends here
	}
	if (check && disChrFlag == "N")
	{
        document.getElementById("isNEW").value = true;
        var objH = document.getElementById("dietTypesForMeals");
        if (objH != null) {
            for (var i = 0; i < objH.length; i++) {
            	objH[i].disabled = false;
            }
        }
		var obj = document.getElementById("dietTypesForMeals");
		if(obj != null){
			for (var i = 0; i < obj.length; i++) {
                obj[i].disabled = false;
            }
		}
		var locale=document.getElementById("languageId").value;
		var dateFormate=document.getElementById("datepattrn1").value;
		var frmDate=document.getElementById("dateFrom").value;
		//var fromDate = convertDate(frmDate,'DMY','en',locale);
		var fromDate = convertDate(frmDate,'DMY',locale,'en');
		//document.getElementById("dateFrom").value=fromDate;
		var datTo=document.getElementById("dateTo").value;
		var dateTo = convertDate(datTo,'DMY',locale,'en');
		//document.getElementById("dateTo").value=dateTo;		
		
		var encounterId=document.getElementById("encounterId").value

		//39937
		var profileSL = "";
		if(newProfile)
			profileSL = document.getElementById("maxprofileSL").value;
		else
			profileSL=document.getElementById("profileSL").value;

		if(profileSL=="" || profileSL == "0" || profileSL == null )
			profileSL="0";
		else
			profileSL = profileSL;
		var addedById = document.getElementById("addedById").value;
		var addedAtWsNo = document.getElementById("addedAtWsNo").value;
		var addedFacilityId = document.getElementById("addedFacilityId").value;
		//document.getElementById("isNEW").value = true;
		var patientId = document.getElementById("Patient_ID").value;
		var patientClass = document.getElementById("patientClass").value;
		var locationType = document.getElementById("locationType").value;
		var locationCode = document.getElementById("locationCode").value;
		var mClass = document.getElementById("mealClass").value;
/* 		var dType =document.getElementById("dietType").value; */
		var from =document.getElementById("from").value;
		var to =document.getElementById("to").value;
		// Refer to Dietician IN 42110
		//var dieticianReferral =document.getElementById("dieticianReferral").checked?'Y':'N';
		var dieticianReferral = null;
		if(referrToDietcian == null && document.getElementById("dieticianReferral").checked == true)
			dieticianReferral = "Y"
		else if(referrToDietcian == "Y" || referrToDietcian == "")
		{
			dieticianReferral = referrToDietcian;
			dieticianSuccess = true;
		}
		else
			dieticianReferral = "";
		var feedingInstructions =document.getElementById("feedingInstructions").value;
		var prepInstr =document.getElementById("prepInstr").value;
		var feedType =document.getElementById("feedType").value;
		var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
		var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
		var dietCycleType = document.getElementById("dayRef").value;
		var status = document.getElementById("status").value;
		var atndInstr =document.getElementById("atndInstr1").value;//ML-MMOH-SCF-0735
		//SCF-735
		var pateintRadio="No";
		if(document.getElementById("Suballocator").checked == true){
		 pateintRadio= document.getElementById("Suballocator").value; 
		}
		//SCF-735
		var nutrientDeleteFlag =document.getElementById("nutrientDeleteFlag").value;
		if(isMenuType=="true"){
	    		var menu_type = document.getElementById("menu_type").value;//CRF-684
		}
		var ordersForCancellation = verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile);
		if(checkFullNBMProfileOverLap()){return false;}		//CRF-410 21Dec	
		if(ordersForCancellation.length > 0 && !window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + ordersForCancellation + "Do you wish to continue?"))
			return false;
		// changes for ML-MMOH-CRF-0428
		/*var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
		if(irregular_enabled=="Y") addAutomaticExclusions();
		var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
		$.each(automatic_excluded_meal_types,function(index,value) {
		msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
		});
		if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") alert(msg_exclusions);*/
		
		if((document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != "")) || (document.getElementById("dieticianReferral").checked ==  false )){
		if(checkIfAllMealTypesExcluded()) {
			var message="Atleast one meal should be selected for the Diet Order "
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
			return false;
		}
		/*if(checkAutoExclusions()) {
			var message="All Meals are automatically excluded for today "
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
			return false;
		}*/
		}
		JSONobj={};//CRF-412
		//checkIrregularMeal();
		var mode = "insertMealContents";
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		var paramTer="&encounterId="+encounterId
			+"&diet_Category="+diet_Category
			+"&addedById="+addedById
			+"&addedFacilityId="+addedFacilityId
			+"&isNEW="+document.getElementById("isNEW").value
			+"&profileSL="+profileSL
			+"&patientId="+patientId
			+"&patientClass="+patientClass
			+"&locationType="+locationType
			+"&locationCode="+locationCode
			+"&addedAtWsNo="+addedAtWsNo
			+"&objMeal="+obMeal
			+"&obDiet="+obDiet
			+"&mClass="+mClass
			+"&dType="+dType
			+"&fromDate="+fromDate
			+"&dateTo="+dateTo
			+"&from="+from
			+"&to="+to
			+"&dieticianReferral="+dieticianReferral
			+"&feedingInstructions="+encodeURIComponent(feedingInstructions)
			+"&prepInstr="+encodeURIComponent(prepInstr)
			+"&feedType="+feedType
			+"&dsDeliveryInstr="+dsDeliveryInstr
			+"&texture_of_diet="+texture_of_diet//ML-MMOH-CRF-412
			+"&dietCycleType="+dietCycleType
			+"&status="+status
			+"&attdietList="+attdietList
			+"&foodDislikeListArr="+foodDislikeListArr
			+"&delFoodDis="+delFoodDisList
			+"&returnRemarks="+encodeURIComponent((returnRemarks))
			+"&atndInstr="+atndInstr
			+"&nutrientSuppListArr="+nutrientSuppListArr
			+"&nutrientDeleteFlag="+nutrientDeleteFlag
			+"&selectedProfile="+selectedProfile
			+"&mealExclusions="+JSON.stringify(excludedMeals)
			+"&irregular_meal_code="+irregular_meal_code
			+"&dietTypeModified_YN="+DietTypeModified_YN
			+"&Full_Day_NBM_YN="+Full_Day_NBM_YN//CRF-410
			+"&mode="+mode 
			+"&menu_type="+menu_type//CRF-684
			
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
		xmlHttp.send(xmlDoc);
		retVal = localTrimString(xmlHttp.responseText);
		var arrVal = retVal.split(",");
		var row_ind = 1;
		var tableObj3 = document.getElementById("result_Id");
		while (tableObj3.rows.length > 1)
			tableObj3.deleteRow(1);
		if(arrVal != null && arrVal != "")
		{
			var recordToUpdate = -1;
			recordToUpdate = toLoadDetails(arrVal);
			checkStatus("A~F",document.all("status"));
			document.getElementById("status").value="A~F";
			submitStatus = true;
			chkFormValChange = false;
			document.getElementById("isNEW").value = false; //43869
		}
		else if(dieticianSuccess)
		{
			var message = getMessage("DS_OPER_COMPLETE","DS");// "APP-DS0001 Operation Completed Successfully...";
			//CRF-410 starts
			document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value;
			//updateMealMenuDate();			
			if(Full_Day_NBM_YN=="Y"){
				reset();
			}
			//CRF-410 ends
			
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
		}
		if(submitStatus)
		{
			
			var message = getMessage("DS_OPER_COMPLETE","DS"); //"APP-DS0001 Operation Completed Successfully...";
			
			document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value //AMRI-SCF-0385 [IN:056722]

			updateMealMenuDate();
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
//			attdietList = new Array(); //IN::39937
		}
    }
    else if (disChrFlag == "Y")
    {
    	//  For the Discharge Patients
    	var datTo;
    	 document.getElementById("isNEW").value = true;
    	 var flag = document.getElementById("flag").value;
    	 var locale=document.getElementById("languageId").value;
 		var dateFormate=document.getElementById("datepattrn1").value;
 		var frmDate=document.getElementById("dateFrom").value;
 		//var fromDate = convertDate(frmDate,'DMY','en',locale);
 		var fromDate = convertDate(frmDate,'DMY',locale,'en');
 		//document.getElementById("dateFrom").value=fromDate;
 		if(document.getElementById("dateTo").value != null && document.getElementById("dateTo").value != ""){
 			datTo=document.getElementById("dateTo").value;
 			//dateTo = convertDate(datTo,'DMY','en',locale);
 			dateTo = convertDate(datTo,'DMY',locale,'en');
 			//document.getElementById("dateTo").value=dateTo;
 		}
 		else
 			datTo = "";

 		var dateFlag = compareDatesForDisPat(fromDate,datTo);
 		if(dateFlag == 1)
		{
 				var error= getMessage("DS_FMTODAT_SYSDAT_GRACPER","DS"); //"From date and To date should be System date for Grace Period Patients";
 				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
 				return false;
 		}
 		else
 		{
 			var obMeal = new Array();
 			var obDiet = new Array();
 			var count = 0;
 			var countMeal = 0;
 			var disMealType = mealTypeObj.value;
 			var objMeal = disMealType.split('@');

 			if(objMeal != null){
 				for (var i = 0; i < objMeal.length; i++) {
 					if (objMeal[i]!= "") {
 						obMeal[countMeal++] = objMeal[i];
 					}
 				}
 			}
 			var disDietType = dietTypeObj1.value;
 			var obj = disDietType.split('@');
 			if(obj != null){
 				for (var i = 0; i < obj.length; i++) {
 					if (obj[i]!= "") {
 						obDiet[count++] = obj[i];
 					}
 				}
 			}
 			var encounterId=document.getElementById("encounterId").value
 			var profileSL=document.getElementById("profileSL").value;

 			//AMRI-SCF-0385 [IN:056722] starts

 			if(newProfile)
 				profileSL = document.getElementById("maxprofileSL").value;
 			else
 				profileSL=document.getElementById("profileSL").value;

 			//AMRI-SCF-0385 [IN:056722] ends

 			if(profileSL=="" || profileSL == "0" || profileSL == null )
 				profileSL="0";

 			var addedById = document.getElementById("addedById").value;
 			var addedAtWsNo = document.getElementById("addedAtWsNo").value;
 			var addedFacilityId = document.getElementById("addedFacilityId").value;
 			//document.getElementById("isNEW").value = true;
 			var patientId = document.getElementById("Patient_ID").value;
 			var patientClass = document.getElementById("patientClass").value;
 			var locationType = document.getElementById("locationType").value;
 			var locationCode = document.getElementById("locationCode").value;
 			var mClass = document.getElementById("mealClass").value;
 			var dType =document.getElementById("dietType").value;
 			var from =document.getElementById("from").value;
 			var to =document.getElementById("to").value;
 			var feedingInstructions =document.getElementById("feedingInstructions").value;
 			var prepInstr =document.getElementById("prepInstr").value;
 			var feedType =document.getElementById("feedType").value;
 			var dsDeliveryInstr =document.getElementById("dsDeliveryInstr").value;
 			var texture_of_diet =document.getElementById("texture_of_diet").value;//ML-MMOH-CRF-412
 			//var dietCycleType = document.getElementById("dayRef").value;
 			var status = document.getElementById("status").value;
 			var atndInstr =document.getElementById("atndInstr1").value;//ML-MMOH-SCF-0735
             		//SCF-735
			var pateintRadio="No";
			if(document.getElementById("Suballocator").checked == true){
			 pateintRadio= document.getElementById("Suballocator").value; 
			}
			//SCF-735
 			var nutrientDeleteFlag =document.getElementById("nutrientDeleteFlag").value;
			if(isMenuType=="true"){
			var menu_type = document.getElementById("menu_type").value;//CRF-684
			}
			var ordersForCancellation = verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile);
			if(checkFullNBMProfileOverLap()){return false;}		//CRF-410 21Dec	
			if(ordersForCancellation.length > 0 && !window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + ordersForCancellation + "Do you wish to continue?"))
				return false;
			// changes for ML-MMOH-CRF-0428
			/*var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
			if(irregular_enabled=="Y") addAutomaticExclusions();
			var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
			$.each(automatic_excluded_meal_types,function(index,value) {
			msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
			});
			if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") alert(msg_exclusions);*/
			
			if((document.getElementById("dieticianReferral").checked ==  true && (diet_Category != null && diet_Category != "")
			&& (document.getElementById("dateFrom").value != null && document.getElementById("dateFrom").value != "")
			&& (document.getElementById("mealClass").value != null && document.getElementById("mealClass").value != "")
			&& (document.getElementById("dietType").value != null && document.getElementById("dietType").value != "")) || (document.getElementById("dieticianReferral").checked ==  false )){
			if(checkIfAllMealTypesExcluded()) {
				var message="Atleast one meal should be selected for the Diet Order "
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
				return false;
			}
			/*if(checkAutoExclusions()) {
				var message="All Meals are automatically excluded for today "
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
				return false;
			}*/
			}
			// changes for ML-MMOH-CRF-0428 ends here			
			
			checkIrregularMeal();
			if(checkFullNBMProfileOverLap()){return false;}	//CRF-410

					JSONobj={};//ML-MMOH-CRF-412ASH
 			var mode = "insertMealContents";
 			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			var paramTer="&encounterId="+encounterId
			+"&diet_Category="+diet_Category
			+"&addedById="+addedById
			+"&addedFacilityId="+addedFacilityId
			+"&isNEW="+document.getElementById("isNEW").value
			+"&profileSL="+profileSL
			+"&patientId="+patientId
			+"&patientClass="+patientClass
			+"&locationType="+locationType
			+"&locationCode="+locationCode
			+"&addedAtWsNo="+addedAtWsNo
			+"&objMeal="+obMeal
			+"&obDiet="+obDiet
			+"&mClass="+mClass
			+"&dType="+dType
			+"&fromDate="+fromDate
			+"&dateTo="+dateTo
			+"&from="+from
			+"&to="+to
			+"&feedingInstructions="+encodeURIComponent(feedingInstructions)
			+"&prepInstr="+encodeURIComponent(prepInstr)
			+"&feedType="+feedType
			+"&dsDeliveryInstr="+dsDeliveryInstr
			+"&texture_of_diet="+texture_of_diet//ML-MMOH-CRF-412
			//+"&dietCycleType="+dietCycleType
			+"&status="+status
			+"&attdietList="+attdietList
			+"&foodDislikeListArr="+foodDislikeListArr
			+"&delFoodDis="+delFoodDisList
			+"&returnRemarks="+encodeURIComponent((returnRemarks))
			+"&flag="+flag
			+"&atndInstr="+atndInstr
			+"&nutrientSuppListArr="+nutrientSuppListArr
			+"&nutrientDeleteFlag="+nutrientDeleteFlag
			+"&mealExclusions="+JSON.stringify(excludedMeals)
			+"&irregular_meal_code="+irregular_meal_code
			+"&dietTypeModified_YN="+DietTypeModified_YN
			+"&Full_Day_NBM_YN="+Full_Day_NBM_YN//CRF-410
			+"&menu_type="+menu_type//CRF-684
			+"&mode="+mode;		
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
			xmlHttp.send(xmlDoc);
			retVal = localTrimString(xmlHttp.responseText);
			var arrVal = retVal.split(",");
			var row_ind = 1;
			var tableObj3 = document.getElementById("result_Id");
			while (tableObj3.rows.length > 1)
				tableObj3.deleteRow(1);
			if(arrVal != null)
			{
				var recordToUpdate = -1;
				recordToUpdate = toLoadDetails(arrVal);
				checkStatus("A~F",document.all("status"));
				document.getElementById("status").value="A~F";
				submitStatus = true;
				chkFormValChange = false;
			}

			if(submitStatus)
			{
 				var message =  getMessage("DS_OPER_COMPLETE","DS");//"APP-DS0001 Operation Completed Successfully...";
				

 				document.getElementById("profileSL").value = document.getElementById("maxActiveprofileSL").value;  //AMRI-SCF-0385 [IN:056722]

///			document.getElementById("maxprofileSL").value = profileSL;
				updateMealMenuDate();
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message
//						attdietList = new Array(); //IN::39937 - new
			}
		}
    }
}

function checkNulls(fieldName, fields) {
	var f1 = true; 	//IN:39937
	var errors = "";
	var key_value = new Array();
	
	if(document.getElementById("dietCatImage").style.visibility == "visible"
		&& document.getElementById("fromDateImage").style.visibility == "visible"
		&& document.getElementById("MealClassImage").style.visibility == "visible"
		&& document.getElementById("dietTypeImage").style.visibility == "visible"
		
		){
	for (j = 0; j < fields.length; j++) {
		if (fields[j].value == "") {
			f1 = false;
			//errors = errors + "APP-SM0073 " + fieldName[j] + " cannot be blank..." + "<br>" ;
		   errors = errors + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName[j] ) + "<br>" ;
		}
	}
	}
	if (parent.frames.messageFrame) {
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errors;
	} else {
		top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errors;
	}
	if (f1 == false) {
		return false;
	} else {
		return true;
	}
}

//Added against 060636 Starts
function checkAttendantNulls(fieldName, fields) {
	var f1 = true;
	var errors = "";
	var key_value = new Array();
	
	for (j = 0; j < fields.length; j++) {
		if (fields[j].value == "") {
			f1 = false;	
		   errors = errors + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",fieldName[j] ) + "<br>" ;
		}
	}	
	if (parent.frames.messageFrame) {
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errors;
	} else {
		top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errors;
	}
	if (f1 == false) {
		return false;
	} else {
		return true;
	}
}
//Added against 060636 ends
function getSysDate(){
	var locale=document.getElementById("languageId").value;
	var profileNo =	document.getElementById("profileSL").value;
	var fromDate=document.getElementById("dateFrom").value;
	var date=new Date();
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getFullYear();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	var sysDate=date1+"/"+month+"/"+year;
	var conDate = convertDate(sysDate,'DMY','en',locale);
	if(conDate!=""){
		if(profileNo == 0 || profileNo > 0){ //Added against ML-MMOH-SCF-1098
			document.getElementById("dateForMeanu").value=conDate
			document.getElementById("dateFrom").value=conDate
			/* Added Against Start ML-MMOH-SCF-1098 */
			var profileFlag=$('#profileFlag').val();
			var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			var maximum_days_allowed=$('#maximum_days_allowed').val();
			if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
			var newtodate=addDays(new Date(),maximum_days_allowed);
			var date1=newtodate.getDate();
			var month=newtodate.getMonth();
			var year=newtodate.getFullYear();
			month+=1;
			if(date1<=9){
				date1="0"+""+date1;
				}
			if(month<=9){
				month="0"+""+month;
				}
			var futureDate=date1 + "/" + month + "/" + year;
			futureDate=convertDate(futureDate,'DMY','en',locale);
			//document.getElementById("dateTo").value = futureDate; // commented by selvin
			}
			/* Added Against End ML-MMOH-SCF-1098 */
		}else{
				if(document.getElementById("dateForMeanu").value == "")
				document.getElementById("dateForMeanu").value=fromDate;
			}
	}
}

function updateMealMenuDate() {
	var fromDate=document.getElementById("dateFrom").value;
	document.getElementById("dateForMeanu").value=fromDate;
}

var modelArr = new Array();

function modelWindow(obj, anchor)
{
	var locale =document.getElementById("languageId").value;
	var flag = true;
	if (document.getElementById("from").value != "" && document.getElementById("to").value != "") {
		var locale=document.getElementById("languageId").value;
		flag = compareDates(document.getElementById("from").value, document.getElementById("to").value,locale,'DMYHM');
		if (flag==-1){
			flag=true;
			dateCheck(flag);
		}else if(flag == 1){
			flag=false;
			dateCheck(flag);
		}else{
			flag=false;
			dateCheck(flag);
		}
	} else{
		dateCheck(false);
	}
}
async function dateCheck(flag)
{
	if(!flag)
	{
		if (document.getElementById("profileSL").value != "" && document.getElementById("flag").value == "N")
		{
			var mealType = document.getElementById("mealClass").value;
	        var ob = new Array();
	        var obMeal = new Array();
	        var count = 0;
	        var countMeal = 0;
	        ob[0] = document.getElementById("dietType").value;
	        var objsFields = new Array();
	        var obj = document.getElementsByName("dietTypesForMeals");
	        if(obj != null)
			{
	            for (var i = 0; i < obj.length; i++)
				{
	                if (obj[i].value != "")
	                  ob[count++] = obj[i].value;
	            }
	        }
	        var objMeal = document.getElementsByName("mealTypesforDietTypes");
	        if(objMeal != null)
	        {
	        	for (var i = 0; i < objMeal.length; i++)
	        	{
	                if (objMeal[i].value != "")
	                    obMeal[countMeal++] = objMeal[i].value;
	        	}
	        }
	        var date="";
	        if(document.getElementById("dateForMeanu").value!="")
	        	date = document.getElementById("dateForMeanu").value;
	        else
	        	date = document.getElementById("dateFrom").value;
	        var dRef = document.getElementById("dayRef").value
	        if(dRef=="")
				dRef="1"
			else
				dRef=dRef;
	        document.getElementById("dayRef").value=dRef;
			//ML-MMOH-CRF-0427 US3 starts
			var profileFlag=$('#profileFlag').val();
			var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			var maximum_days_allowed=$('#maximum_days_allowed').val();
			//ML-MMOH-CRF-0427 US3 ends
	        var val = "&mealType="+mealType
	        +"&dietTypesForMeals="+ob+"&mealTypesforDietTypes="+obMeal
	        +"&mealClass="+document.getElementById("mealClass").value
	        +"&dietType="+document.getElementById("dietType").value
	        +"&kitchenCode="+document.getElementById("kitchenCode").value
	        +"&patientId=" +document.getElementById("Patient_ID").value
	        +"&encounterId="+document.getElementById("encounterId").value
	        +"&patientClass="+document.getElementById("patientClass").value
	        +"&profileSL="+document.getElementById("profileSL").value
	        +"&languageId="+document.getElementById("languageId").value
	        +"&dayRef="+dRef
	        +"&dateFrom.pattern=dd/MM/yyyy&dateFrom=" + document.getElementById("dateFrom").value
			+ "&dateTo.pattern=dd/MM/yyyy&dateTo=" + document.getElementById("dateTo").value
			+ "&to.pattern=dd/MM/yyyy&to=" + document.getElementById("to").value
			+ "&from.pattern=dd/MM/yyyy&from=" + document.getElementById("from").value
			+ "&dateForMeanu.pattern=dd/MM/yyyy&dateForMeanu=" + date
			+"&profileFlag="+profileFlag//ML-MMOH-CRF-0427
			+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn//ML-MMOH-CRF-0427
			+"&maximum_days_allowed="+maximum_days_allowed;//ML-MMOH-CRF-0427
	        // + "&MealItemsArray=" + parent.document.getElementById("MealItemsArray").value;
			//Added against KDAH-CRF-0352 Starts Here
			var isEditMealType="";		
			if(document.getElementById("isEditMealType")!=null)
			isEditMealType=document.getElementById("isEditMealType").value;
			var dialogArguments = "";
			var dialogFeatures ="";
			if(isEditMealType=="true"){
				var dialogTop   = "65";
			    var dialogHeight    = "600px" ; //30.5
			    var dialogWidth = "900px" ;
			    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
			//dialogFeatures = "dialogHeight:" + 70 + "; dialogWidth:" + 70 + "; scroll:no; status:no;"; // AAKH-CRF-0065 & KDAH-CRF-0352
			}			
			else{
				var dialogTop   = "65";
			    var dialogHeight    = "600px" ; //30.5
			    var dialogWidth = "900px" ;
			    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
			//dialogFeatures = "dialogHeight:" + 45 + "; dialogWidth:" + 45 + "; scroll:no; status:no;"; // AAKH-CRF-0065	        
			}
			//Added against KDAH-CRF-0352 Ends Here
			var dialogUrl = "../../eDS/jsp/MealMenuFrames.jsp?"+val;
	        var returnVal =await window.showModalDialog(dialogUrl, dialogArguments,dialogFeatures);
	        getMeals();
		}
		else
		{
			var mealType = document.getElementById("mealClass").value;
		        var ob = new Array();
		        var obMeal = new Array();
		        var count = 0;
		        var countMeal = 0;
		        ob[0] = document.getElementById("dietType").value;
		        var objsFields = new Array();
		        //var obj = document.getElementsByName("dietTypesForMeals");
		        var disDietType = dietTypeObj1.value;
		        var obj = disDietType.split('@');
		        if(obj != null){
		            for (var i = 0; i < obj.length; i++) {
		                if (obj[i] != "") {
		                  ob[count++] = obj[i];
		                }
		            }
		        }
		        var disMealType = mealTypeObj.value;
		        var objMeal = disMealType.split('@');
		        if(objMeal != null){
		        	for (var i = 0; i < objMeal.length; i++) {
		                if (objMeal[i] != "") {
		                    obMeal[countMeal++] = objMeal[i];
		                }
		        	}
		        }
		        var date="";
		        if(document.getElementById("dateForMeanu").value!="")
		        {
		        	date = document.getElementById("dateForMeanu").value;
		        }
		        else
		        {
		        	date = document.getElementById("dateFrom").value;
		        }
		        var dRef = document.getElementById("dayRef").value
		        if(dRef=="")
					dRef="1"
				else
					dRef=dRef;
		        document.getElementById("dayRef").value=dRef;
		        var val = "&mealType="+mealType
		        +"&dietTypesForMeals="+ob+"&mealTypesforDietTypes="+obMeal
		        +"&mealClass="+document.getElementById("mealClass").value
		        +"&dietType="+document.getElementById("dietType").value
		        +"&kitchenCode="+document.getElementById("kitchenCode").value
		        +"&patientId=" +document.getElementById("Patient_ID").value
		        +"&encounterId="+document.getElementById("encounterId").value
		        +"&patientClass="+document.getElementById("patientClass").value
		        +"&profileSL="+document.getElementById("profileSL").value
		        +"&languageId="+document.getElementById("languageId").value
		        +"&dayRef="+dRef
		        +"&dateFrom.pattern=dd/MM/yyyy&dateFrom=" + document.getElementById("dateFrom").value
				+ "&dateTo.pattern=dd/MM/yyyy&dateTo=" + document.getElementById("dateTo").value
				+ "&to.pattern=dd/MM/yyyy&to=" + document.getElementById("to").value
				+ "&from.pattern=dd/MM/yyyy&from=" + document.getElementById("from").value
				+ "&dateForMeanu.pattern=dd/MM/yyyy&dateForMeanu=" + date;
		        + "&MealItemsArray=" + parent.document.getElementById("MealItemsArray").value;

		        var dialogArguments = "";
		        var dialogTop   = "65";
		        var dialogHeight    = "600px" ; //30.5
		        var dialogWidth = "900px" ;
		        var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
			//var dialogFeatures = "dialogHeight:" + 45 + "; dialogWidth:" + 45 + "; scroll:no; status:no;"; // AAKH-CRF-0065
		        var dialogUrl = "../../eDS/jsp/MealMenuFrames.jsp?"+val;
		        var returnVal =await window.showModalDialog(dialogUrl, dialogArguments,dialogFeatures);
		        getMealsGarcePeriod()
			}
	}
	else
		alert(getMessage("DS_TODATE_GRTR_FRMDATE","DS"));//"To Date Should be greater than from Date");
	}

function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");

	var xmlText = xhr.responseText
	return(xhr.responseText);
}
function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			//request = new ActiveXObject("Msxml2.XMLHTTP");
			  request="";
		}catch (othermicrosoft) {
			try {
				//request = new ActiveXObject("Microsoft.XMLHTTP");
				  request ="";
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert(getMessage("DS_SYSERR_XMLHTTPREQ","DS"));
		return;
	}else return request;
}

function isValidDate(obj)
{
	if(obj.value!="")
	{
		//var RE_NUM = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/(20)[0-9]{2}$/;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length!=3) return cal_error ("Invalid date format: '" + str_date + "'.\nFormat accepted is DD/MM/YYYY.",obj);
		if (!arr_date[0]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo day of month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[0])) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[1]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo month value can be found.",obj);
		if (!RE_NUM.exec(arr_date[1])) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed values are unsigned integers.",obj);
		if (!arr_date[2]) return cal_error ("Invalid date format: '" + str_date + "'.\nNo year value can be found.",obj);
		if (arr_date[2].length!=4) return cal_error ("Invalid year value: '" + arr_date[2] + "'.\nAllowed format YYYY.",obj);
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) return cal_error ("Invalid month value: '" + arr_date[1] + "'.\nAllowed range is 01-12.",obj);
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) return cal_error ("Invalid day of month value: '" + arr_date[0] + "'.\nAllowed range is 01-"+dt_numdays.getDate()+".",obj);
		//if(arr_date[2].length==4 && arr_date[2]>=dt_date.getFullYear() ) return cal_error ("Not a valid Year value: '" + arr_date[2] + "'.\nCurrent Year "+dt_date.getFullYear()+" Only Allowed .",obj);
	}
	return true;
}


function checkDates()
{
	var objs = new Array();
	objs[0] = document.getElementById("attendentFromDate");
	objs[1] = document.getElementById("attendentMealClass");
	objs[2] = document.getElementById("attendentDiet");
	objs[3] = document.getElementById("attendentDietCategory"); //52776

	//58902
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	//58902

	var objsFields = new Array();
	objsFields[0] = "From Date";
	objsFields[1] = "Meal Class";
	objsFields[2] = "Diet Type";
	objsFields[3] = "Diet Category"; //52776

	//58902
	//if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){//CRF-412
	objs[4] = document.getElementById("attendentToDate");
	objsFields[4] = "To Date"; //52776
	//}//CRF-412
	//58902

    var locale=document.getElementById("languageId").value;
    //if (!checkNulls(objsFields, objs))//Commented against  060636
    //Added against 060636 Starts
    if (!checkAttendantNulls(objsFields, objs))
    {
        return false;
    }
    if(document.getElementById("attendentToDate").value!="")
    {
		var locale=document.getElementById("languageId").value;

		var flag = compareDate(document.getElementById("attendentFromDate").value,document.getElementById("attendentToDate").value);
		if (flag == 1) {
	        error = "";
	        key_value = "";
	        var mesg = getMessage("DS_TODATE_GRTR_FRMDATE","DS"); //"To Date Should be greater than from Date"
	        key_value = mesg;
	        error = error + key_value + " <br>";
	        if (parent.frames.messageFrame) {
	            parent.frames.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;;
	        } else {
	            top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+error;;
	        }
	        return false;
	    }
		else addAttendent();

    }else{
    	addAttendent();
    }
}


var attROW = 0;
var attROW_temp = 0;//ML-MMOH-CRF-412
var nutrCalTotal1=0;
var attdietList = new Array();
//adding the attendent
function addAttendent()
{
	var mc_defaultcount=document.forms[0].mc_defaultcount.value;//Added Against ML-MMOH-CRF-1005-US2
	if(document.getElementById("attendentFromDate").value != "")
	{
		var locale=document.getElementById("languageId").value;
		var date=new Date();
		var month=date.getMonth();
		var date1=date.getDate();
		var year=date.getYear();
		month+=1;
		if(date1<=9){
			date1="0"+""+date1;
		}
		if(month<=9){
			month="0"+""+month;
		}
		var sysDate=date1+"/"+month+"/"+year;

//		var flag = isBeforeNow(document.getElementById("dateFrom").value,"DMY",locale);
		var flag = compareDate(document.getElementById("attendentFromDate").value,sysDate);
		if(flag == -1){
			var error="";
			/*var msg = "App-DS0011 # should be greater than or equals to";
			var msg_key = msg.split("#");
			var f_date = "From Date";
			var t_date = "To Date";
			var s_date = "SysDate";*/
			//error = error+" "+msg_key[0]+" "+f_date+" "+msg_key[1]+" "+s_date+"<br>"
			error = error+ getMessage("DS_FRDAT_GRTREQL_SYSDAT","DS") +"<br>";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return;
		}
	}

	if(document.getElementById("attendentToDate").value != ""){
		var locale=document.getElementById("languageId").value;
		var date=new Date();
		var month=date.getMonth();
		var date1=date.getDate();
		var year=date.getYear();
		month+=1;
		if(date1<=9){
			date1="0"+""+date1;
		}
		if(month<=9){
			month="0"+""+month;
		}
		var sysDate=date1+"/"+month+"/"+year;

//		var flag = isBeforeNow(document.getElementById("dateFrom").value,"DMY",locale);
		var flag = compareDate(document.getElementById("attendentToDate").value,sysDate);
		if(flag == -1){
			var error="";
			/*var msg = "App-DS0011 # should be greater than or equals to";
			var msg_key = msg.split("#");
			var f_date = "From Date";
			var t_date = "To Date";
			var s_date = "SysDate";*/
			//error = error+" "+msg_key[0]+" "+f_date+" "+msg_key[1]+" "+s_date+"<br>"
			error = error + getMessage("DS_FRDAT_GRTREQL_SYSDAT","DS") +"<br>";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return;
		}
	}

	//Validation for 427 crf starts to check date range is within the set up date
	//ML-MMOH-CRF-0427 starts
			var profileFlag=$('#profileFlag').val();
			var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			var maximum_days_allowed=$('#maximum_days_allowed').val();
			//var selecteddate=$('#attendentFromDate').val();
			var selecteddate=$('#attendentFromDate').val();
			if(profileFlag=="true" && restrict_date_inpatients_yn=="Y")
			{
			var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);

				if(!flag){
					var error="";
					var sysdate=getCurrentDate("DMH",locale);
					var maxdate=addDays(new Date(),maximum_days_allowed);
					var maxToDate=changeDate(maxdate);
					var fieldName=getLabel("Common.fromdate.label","common");
					var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
					var msgArray=msg.split("#");
					error="";
					//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
					error+=fieldName;
					error+=msgArray[1];
					error+=sysdate;
					error+=msgArray[2];
					error+=maxToDate;
						parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
					$('#attendentFromDate').focus();
					$('#attendentFromDate').select();
					return false;
				}
			}

		//To date validation stats
			//ML-MMOH-CRF-0427 starts
			profileFlag=$('#profileFlag').val();
			 restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			 maximum_days_allowed=$('#maximum_days_allowed').val();
			//var selecteddate=$('#attendentFromDate').val();
			 selecteddate=$('#attendentToDate').val();
			if(profileFlag=="true" && restrict_date_inpatients_yn=="Y" && selecteddate!="") //58902
			{
			var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);

			if(!flag){
				var error="";
				var sysdate=getCurrentDate("DMH",locale);
				var maxdate=addDays(new Date(),maximum_days_allowed);
				var maxToDate=changeDate(maxdate);
				var fieldName=getLabel("Common.todate.label","common");
				var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
				error+=fieldName;
				error+=msgArray[1];
				error+=sysdate;
				error+=msgArray[2];
				error+=maxToDate;
	        		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				$('#attendentToDate').focus();
				$('#attendentToDate').select();
				return false;
			}
		}
		//To date validation ends
		//ML-MMOH-CRF-0427 ends
		//Validation for 427 crf ends to check date range is within the set up date

		//ML-MMOH-CRF-412 VALIDATION STARTS
		var attendentFromDate=$('#attendentFromDate').val();
		var attendentToDate=$('#attendentToDate').val();
		var max_count=$('#No_Of_Attendant').val();
		var flag=getAttendantCount(attendentFromDate,attendentToDate,"onclick",max_count);
		if(flag==false){
			return false;
		}		
		//ML-MMOH-CRF-412 VALIDATION ENDS
	var row_ind = 1;
	var tabObj = document.getElementById("attendentListTable");
	var newRow = tabObj.insertRow(row_ind);
    newRow.id = attROW;
    var newCellDate = newRow.insertCell(newRow.cells.length);
    newCellDate.appendChild(document.createTextNode((document.getElementById("attendentFromDate").value + "-" + document.getElementById("attendentToDate").value)));
    var newCellqty = newRow.insertCell(newRow.cells.length);
    newCellqty.appendChild(document.createTextNode(document.getElementById("attendentMealClass").options[document.all("attendentMealClass").selectedIndex].text));
    var newCellfoodType = newRow.insertCell(newRow.cells.length);
    newCellfoodType.appendChild(document.createTextNode(document.getElementById("attendentDiet").options[document.all("attendentDiet").selectedIndex].text));
    var newCell = newRow.insertCell(newRow.cells.length);


    var sub = "";
    sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].formDate' id='attendentDietProfilList[" + (attROW) + "].formDate' value='" + document.getElementById("attendentFromDate").value + "'/>";
    sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].toDate' id='attendentDietProfilList[" + (attROW) + "].toDate' value='" + document.getElementById("attendentToDate").value + "'/>";
    sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].dsDietType' id='attendentDietProfilList[" + (attROW) + "].dsDietType' value='" + document.getElementById("attendentDiet").value + "'/>";
    sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].mealClass' id='attendentDietProfilList[" + (attROW) + "].mealClass' value='" + document.getElementById("attendentMealClass").value + "'/>";
    sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].profileSL' id='attendentDietProfilList[" + (attROW) + "].profileSL' value='0'/>";
    sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].deleteSL' id='attendentDietProfilList[" + (attROW) + "].deleteSL' value='0'/>";
	//IN:39937 - start
	attdSrl = ++attdSrl;
	sub += "<input type='hidden' name='attendentDietProfilList[" + (attROW) + "].attdSL' id='attendentDietProfilList[" + (attROW) + "].attdSL' value='"+attdSrl+"'/>";

    var removeatt = newRow.insertCell(newRow.cells.length);
    newCell.innerHTML = sub;

    /*attdietList[attROW][0] = document.getElementById("attendentDietProfilList[" + attROW + "].formDate").value;
    attdietList[attROW][1] = document.getElementById("attendentDietProfilList[" + attROW + "].toDate").value;
    attdietList[attROW][2] = document.getElementById("attendentDietProfilList[" + attROW + "].dsDietType").value;
    attdietList[attROW][3] = document.getElementById("attendentDietProfilList[" + attROW + "].mealClass").value;
    attdietList[attROW][4] = document.getElementById("attendentDietProfilList[" + attROW + "].profileSL").value;
    attdietList[attROW][5] = document.getElementById("attendentDietProfilList[" + attROW + "].deleteSL").value;*/
	attdietList[attROW] = new Array(7);
	attdietList[attROW][0] = document.getElementById("attendentFromDate").value;
    attdietList[attROW][1] = document.getElementById("attendentToDate").value;

    attdietList[attROW][2] = document.getElementById("attendentDiet").value;
    attdietList[attROW][3] = document.getElementById("attendentMealClass").value;
	attdietList[attROW][4] = '0';
    attdietList[attROW][5] = '0';
	attdietList[attROW][6] = attdSrl;
	//IN:39937 - end
    var att = "";
    removeatt.className = "data";
    att += "<a href='#'  onclick=\"return removeAttendent('" + attROW + "');\"><br> <fmt:message key='eDS.removeAttendent.Label' bundle='${ds_labels}'/></a>";
    removeatt.innerHTML = att;
    attROW++;
	//Modified Against ML-MMOH-CRF-1005-US2 Starts Here
	if(mc_defaultcount==1){
		document.getElementById("attendentFromDate").value="";
		document.getElementById("attendentToDate").value="";
		document.getElementById("attendentMealClass").value=document.getElementById("attendentMealClass").value;	
		document.getElementById("attendentDietCategory").value=""; 
		document.getElementById("attendentDiet").value="";
		//ML-MMOH-SCF-0735 Starts
		document.getElementById("atndInstr1").value=document.getElementById("atndInstr").value;
		//ML-MMOH-SCF-0735 Ends	
		document.getElementById("atndInstr").value=""; //CRF-412
	}else{
		document.getElementById("attendentFromDate").value="";
		document.getElementById("attendentToDate").value="";
		document.getElementById("attendentMealClass").value="";	
		document.getElementById("attendentDietCategory").value=""; 
		document.getElementById("attendentDiet").value="";
		//ML-MMOH-SCF-0735 Starts
		document.getElementById("atndInstr1").value=document.getElementById("atndInstr").value;
		//ML-MMOH-SCF-0735 Ends	
		document.getElementById("atndInstr").value=""; //CRF-412
	}
	//Modified Against ML-MMOH-CRF-1005-US2 Ends Here
	
	//ML-MMOH-SCF-0735
	/*var atndChk = 	document.getElementById("atndInstr").value
	if(atndChk != null && atndChk.length>0)
	{
		document.getElementById("atndInstr").style.visibility = "visible";
		//atndChk = "hidden";
	}*/
	//ML-MMOH-SCF-0735
}

function callBlank() {
}

function removeAttendent(val) {

var max_count=$('#No_Of_Attendant').val();

var fromDate=document.getElementById("attendentDietProfilList[" + val + "].formDate").value;
var toDate=document.getElementById("attendentDietProfilList[" + val + "].toDate").value;

getAttendantCount(fromDate, toDate,"removeAttendent",max_count)
	var cod = document.getElementById(val);
	//IN:39937 - start
	attdietList[attROW] = new Array(7);
	attdietList[attROW][0] = document.getElementById("attendentDietProfilList[" + val + "].formDate").value;
    attdietList[attROW][1] = document.getElementById("attendentDietProfilList[" + val + "].toDate").value;
	attdietList[attROW][2] = "";
    attdietList[attROW][3] = "";
	attdietList[attROW][4] = '0';
    attdietList[attROW][5] = '-1';
	attdietList[attROW][6] = document.getElementById("attendentDietProfilList[" + val + "].attdSL").value;

    attROW++;
	//IN:39937 - end

	if (document.getElementById("attendentDietProfilList[" + val + "].profileSL").value != "0") {

		var from = document.getElementById("attendentDietProfilList[" + val + "].formDate").value;
        var to = document.getElementById("attendentDietProfilList[" + val + "].toDate").value;
        var diet = document.getElementById("attendentDietProfilList[" + val + "].dsDietType").value;
        var meal = document.getElementById("attendentDietProfilList[" + val + "].mealClass").value;
        var profile = document.getElementById("attendentDietProfilList[" + val + "].profileSL").value;
        var dele = document.getElementById("attendentDietProfilList[" + val + "].deleteSL").value;
		var attdSl = document.getElementById("attendentDietProfilList[" + val + "].attdSL").value;	//IN:39937 - attendant Serial

        cod.deleteCell(0);
        cod.deleteCell(0);
        cod.deleteCell(0);
        cod.deleteCell(0);
        cod.deleteCell(0);
        var sub = "";
        sub += "<input type='hidden' name='attendentDietProfilList[" + val + "].formDate' id='attendentDietProfilList[" + val + "].formDate' value='" + from + "'/>";
        sub += "<input type='hidden' name='attendentDietProfilList[" + val + "].toDate' id='attendentDietProfilList[" + val + "].toDate' value='" + to + "'/>";
        sub += "<input type='hidden' name='attendentDietProfilList[" + val + "].dsDietType' id='attendentDietProfilList[" + val + "].dsDietType' value='" + diet + "'/>";
        sub += "<input type='hidden' name='attendentDietProfilList[" + val + "].mealClass' id='attendentDietProfilList[" + val + "].mealClass' value='" + meal + "'/>";
        sub += "<input type='hidden' name='attendentDietProfilList[" + val + "].profileSL' id='attendentDietProfilList[" + val + "].profileSL' value='" + profile + "'/>";
        sub += "<input type='hidden' name='attendentDietProfilList[" + val + "].deleteSL' id='attendentDietProfilList[" + val + "].deleteSL' value='-1'/>";
        var newCell = cod.insertCell(cod.cells.length);
        newCell.innerHTML = sub;
	}else {
        cod.deleteCell(0);
        cod.deleteCell(0);
        cod.deleteCell(0);
        cod.deleteCell(0);
        cod.deleteCell(0);
    }
}

// Sup Nutrint Window
var supplimentArray = new Array();
var returnVal1 = null;
async function spFoodItemsModelWindow(obj,encounterId,patientClass)
{
	var k=0;
	var j=0;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	var encounterId = document.getElementById("encounterId").value;
	var patientClass = document.getElementById("patientClass").value;
	var profileSL= document.getElementById("profileSL").value;

	//ML-MMOH-CRF-0427 US3 starts
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	//ML-MMOH-CRF-0427 US3 ends


	/*var dialogUrl1 = "../../eDS/jsp/SpFoodItems.jsp?&encounterId="+encounterId+"&profileSL="+profileSL+"&patientClass="+patientClass+"&fecthedMealTypes="+fecthedMealTypes+"&flag="+document.getElementById("flag").value+"&check="+document.getElementById("splFlagArr").value
	+"&profileFlag="+profileFlag//ML-MMOH-CRF-0427
	+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn//ML-MMOH-CRF-0427
	+"&maximum_days_allowed="+maximum_days_allowed;//ML-MMOH-CRF-0427
	*/

	//ML-MMOH-CRF-0427 Starts
	var calledFrom="SpecialFoodItem"
	var dialogUrl1 = "../../eDS/jsp/NutrientSpecialFoodFrames.jsp?&encounterId="+encounterId+"&profileSL="+profileSL+"&patientClass="+patientClass+"&fecthedMealTypes="+fecthedMealTypes+"&flag="+document.getElementById("flag").value+"&check="+document.getElementById("splFlagArr").value
	+"&profileFlag="+profileFlag
	+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn//ML-MMOH-CRF-0427
	+"&maximum_days_allowed="+maximum_days_allowed
	+"&calledFrom="+calledFrom
	//+"&Title="+getLabel("eOT.fooditems.Label","ot_labels");
	+"&Title="+getLabel("eDS.SpecialFoodItem.Label","ds_labels");//5th Dec17
	//ML-MMOH-CRF-0427 ends

	var dialogArguments = supplimentArray;
	//var dialogFeatures = "dialogHeight:35;dialogWidth:50;status:no;scroll:no";
	var dialogTop   = "65";
    var dialogHeight    = "600px" ; //30.5
    var dialogWidth = "900px" ;
    var arguments   = "" ;
    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	returnVal1 =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnVal1)
	{
		document.getElementById("splFlagArr").value = "true";
		supplimentArray = returnVal1;
		var tbodyObj = document.all("FoodItems");
		while(tbodyObj.rows.length > 0)
			tbodyObj.deleteRow(0);
		var countRow = tbodyObj.rows.length;
		var row_ind = 0;
		splGTotal=0;
		for (var i = 0; i < supplimentArray.length; i++)
		{
			var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;
			var obj = supplimentArray[i];
			if(obj != null)
			{
				if(obj[6] == "-1")
				{
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					var sub = "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].from' id='specialFooditemsVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].frequency' id='specialFooditemsVOs[" + (row_ind) + "].frequency' value='" + obj[1] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].period' id='specialFooditemsVOs[" + (row_ind) + "].period' value='" + obj[5] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemType' id='specialFooditemsVOs[" + (row_ind) + "].itemType' value='" + obj[2] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].foodItem' id='specialFooditemsVOs[" + (row_ind) + "].foodItem' value='" + obj[3] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].qty' id='specialFooditemsVOs[" + (row_ind) + "].qty' value='" + obj[4] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemSl' id='specialFooditemsVOs[" + (row_ind) + "].itemSl' value='" + obj[6] + "'/>";
					newCellitemType.innerHTML = sub;
					row_ind++;
				}
				else
				{
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;
					k=k+1;
					energyUom=obj[13];
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					if(obj[21] == undefined){
						obj[21] = obj[14];
					}
					energyUom_Desc=obj[21];
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					
					servingUom_Desc=obj[22];//Added Against Nutrient Supplement & Special food item [IN:067653]
					splGTotal=parseFloat((Math.round(splGTotal*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(obj[12]*Math.pow(10,2))/Math.pow(10,2)));
					document.getElementById("splFITotalCalorie").value=parseFloat((Math.round(splGTotal*Math.pow(10,2))/Math.pow(10,2)));
					var codeCell = newRow.insertCell(newRow.cells.length);
					var qtyCell = newRow.insertCell(newRow.cells.length);
					var calorieCell = newRow.insertCell(newRow.cells.length);
					var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;
					codeCell.className = "label";
					codeCell.className = classVal;
					codeCell.style.fontSize ="8pt";
					codeCell.align = "left";
					codeCell.colSpan = "3";
					qtyCell.className = "label";
					qtyCell.className = classVal;
					qtyCell.style.fontSize ="8pt";
					qtyCell.align = "left";
					qtyCell.colSpan = "3";
					calorieCell.className = "label";
					calorieCell.className = classVal;
					calorieCell.style.fontSize ="8pt";
					calorieCell.align = "left";
					calorieCell.colSpan = "3";
					codeCell.appendChild(document.createTextNode(obj[7]));
					qtyCell.appendChild(document.createTextNode(obj[4] +" "+ obj[22].toLowerCase()));//Modified Against Nutrient Supplement & Special food item [IN:067653]
					var cal = parseFloat((Math.round(obj[12]*Math.pow(10,2))/Math.pow(10,2)));
					//var cal1 = cal+" "+obj[13].toLowerCase(); //Commented Against PMG2017-COMN-CRF-0012.1-US001
					var cal1 = cal+" "+obj[21].toLowerCase();//Added Against PMG2017-COMN-CRF-0012.1-US001
					calorieCell.appendChild(document.createTextNode(cal1));
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					var sub = "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].from' id='specialFooditemsVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].frequency' id='specialFooditemsVOs[" + (row_ind) + "].frequency' value='" + obj[1] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].period' id='specialFooditemsVOs[" + (row_ind) + "].period' value='" + obj[5] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemType' id='specialFooditemsVOs[" + (row_ind) + "].itemType' value='" + obj[2] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].foodItem' id='specialFooditemsVOs[" + (row_ind) + "].foodItem' value='" + obj[3] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].qty' id='specialFooditemsVOs[" + (row_ind) + "].qty' value='" + obj[4] + "'/>";
					sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemSl' id='specialFooditemsVOs[" + (row_ind) + "].itemSl' value='" + obj[6] + "'/>";
					newCellitemType.innerHTML = sub;
					row_ind++;
				}
			}
			var j=j+1;
		}
		var l=parseInt(supplimentArray.length)-1;
		for (var i = 0; i < supplimentArray.length; i++)
		{
			var obj = supplimentArray[i];
			var tbodyObj2 = document.all("FoodItems1");
			if(tbodyObj2.rows.length>0)
			tbodyObj2.deleteRow(0);
			var newRow2 = tbodyObj2.insertRow(0);
			if(i == l)
			{
				if(k!=0)
				{
				var splGT = document.getElementById("splFITotalCalorie").value
				var total = getLabel("eDS.Total.Label","DS");
					var labelCel = newRow2.insertCell(newRow2.cells.length);
					var calorieCel = newRow2.insertCell(newRow2.cells.length);
						labelCel.className = "lable";
						labelCel.className = classVal;
						labelCel.style.fontWeight = "700";
						labelCel.style.fontSize ="8pt";
						labelCel.style.color ="#2B1B17";
						labelCel.setAttribute("border", "0px");
						labelCel.align = "left";
						labelCel.colSpan = "3";
						calorieCel.className = "lable";
						calorieCel.className = classVal;
						calorieCel.style.fontWeight = "700";
						calorieCel.style.fontSize ="8pt";
						calorieCel.style.color ="#2B1B17";
						calorieCel.align = "left";
						calorieCel.colSpan = "6";
						labelCel.appendChild(document.createTextNode(total+" :"));
						var splGTVal = parseFloat((Math.round(splGT*Math.pow(10,2))/Math.pow(10,2)));
					//	var splGUom = splGTVal+" "+energyUom.toLowerCase();//Commented Against PMG2017-COMN-CRF-0012.1-US001
						var splGUom = splGTVal+" "+energyUom_Desc.toLowerCase();//Added Against PMG2017-COMN-CRF-0012.1-US001
						calorieCel.appendChild(document.createTextNode(splGUom));
				document.getElementById("splFITotalCalorie").value=parseFloat((Math.round(splGT*Math.pow(10,2))/Math.pow(10,2)));
				}
				else
					document.getElementById("splFITotalCalorie").value=0;
				}
			}
	}
	calGTotalCalorie();
}

//Food Item
var foodDislikeList = new Array();
var countRowValue = 0;
var foodDislikeListArr = new Array();
var itemCodeDel = new Array();
async function foodDislikesModelWindow(obj) {

	//ML-MMOH-CRF-0427 US3 starts
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	//ML-MMOH-CRF-0427  US3 ends



	var dialogUrl1 = "../../eDS/jsp/FoodDislikes.jsp?&profileFlag="+profileFlag
	+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn
	+"&maximum_days_allowed="+maximum_days_allowed
	;
	var dialogArguments = foodDislikeList;
	//var dialogFeatures = "dialogHeight:25;dialogWidth:32;status:no;scroll:no";
	var dialogTop   = "65";
    var dialogHeight    = "600px" ; //30.5
    var dialogWidth = "900px" ;
    var arguments   = "" ;
    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	returnVal1 =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if (returnVal1) {
		foodDislikeList = returnVal1;
		var tbodyObj = document.all("DislikesFoodItems");
		while (tbodyObj.rows.length > 0) {
			tbodyObj.deleteRow(0);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 0;
		delFoodDisList=[];//57407
		for (var i = 0; i < foodDislikeList.length; i++) {
			var obj = foodDislikeList[i];
			if (obj != null) {
				if (obj[2] != "-1") {
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;
					var newCellitemType = newRow.insertCell(newRow.cells.length);

					var sub = "";
					sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemCode' id='foodDislikesList[" + (row_ind) + "].itemCode' value='" + obj[0] + "'/>";
					sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemDesc' id='foodDislikesList[" + (row_ind) + "].itemDesc' value='" + obj[1] + "'/>";
					sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemStatus' id='foodDislikesList[" + (row_ind) + "].itemStatus' value='" + obj[2] + "'/>";
					newCellitemType.innerHTML = sub;
					var newCellDate = newRow.insertCell(newRow.cells.length);
					newCellDate.className = "data";
					newCellDate.appendChild(document.createTextNode(obj[1]));

					foodDislikeListArr[row_ind] = new Array();
					foodDislikeListArr[row_ind][0] = document.getElementById("foodDislikesList[" + (row_ind) + "].itemCode").value;
					foodDislikeListArr[row_ind][1] = document.getElementById("foodDislikesList[" + (row_ind) + "].itemDesc").value;
					foodDislikeListArr[row_ind][2] = document.getElementById("foodDislikesList[" + (row_ind) + "].itemStatus").value;
					row_ind++;
				}else{
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					newCellitemType.className = "data";
					var sub = "";
					sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemCode' id='foodDislikesList[" + (row_ind) + "].itemCode' value='" + obj[0] + "'/>";
					sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemDesc' id='foodDislikesList[" + (row_ind) + "].itemDesc' value='" + obj[1] + "'/>";
					sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemStatus' id='foodDislikesList[" + (row_ind) + "].itemStatus' value='" + obj[2] + "'/>";
					newCellitemType.innerHTML = sub;

					foodDislikeListArr[row_ind] = new Array();
					foodDislikeListArr[row_ind][0] = document.getElementById("foodDislikesList[" + (row_ind) + "].itemCode").value;
					foodDislikeListArr[row_ind][1] = document.getElementById("foodDislikesList[" + (row_ind) + "].itemDesc").value;
					foodDislikeListArr[row_ind][2] = document.getElementById("foodDislikesList[" + (row_ind) + "].itemStatus").value;
					delFoodDisList.push(obj[0]);//57407
					row_ind++;
				}

			}
		}
		//getMeals();
	}
}

function showLookup1() {
	if(document.getElementById("foodDesc").value != ""){
		showLookup();
	}
}
async function showLookup(obj) {
	var locale = document.getElementById("language_Id").value;
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();

	var sql = "SELECT A.FOOD_ITEM_CODE CODE,A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID LIKE '"+locale+"'";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	//argumentArray[6] = DESC_LINK;
	//argumentArray[7] = DESC_CODE;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr =await CommonLookup("Item", argumentArray);
	var str =unescape(retArr);
	var arr = str.split(",");
	if (retArr != null && retArr != "") {
		document.getElementById("foodType").value = arr[0];
		document.getElementById("foodDesc").value = arr[1];
	}
}

function AddFoodDislikeItem() {
	if (document.getElementById("foodType").value == "" || document.getElementById("foodDesc").value =="") {
		var msg = getMessage("DS_ITM_NOT_BLANK","DS");// "Item can not be blank";
		alert(msg);
		return false;
	}
	var row_ind = 1;
	var tabObj = document.getElementById("listContentTable");
	count = foodDislikeList.length;
	var flag = true;
	if (document.getElementById("rowNo").value == "") {
		for (var k = 0; k < count; k++)
		{
			var obj = foodDislikeList[k];
			if(obj != null){
				if(obj[0]==document.getElementById("foodType").value){
				var masg =getMessage("DS_FOODITM_EXIST","DS");//"Food Item is Already Exits";
				alert(masg);
				return false;
				}
			}
		}
		for (var i = 0; i < foodDislikeList.length; i++) {
			var obj = foodDislikeList[i];
			if (obj != null) {
				if (obj[0] == document.getElementById("foodType").value) {
					if (obj[2] == "-1") {
						obj[2] = "1";
						var newRow = tabObj.insertRow(row_ind);
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var sub = "<A  href=\"#\" onclick=\"return fetchFoodDislikesRow('" + i + "');\" >" + obj[1] + "</A>";
						newCellitemType.innerHTML = sub;
						flag = false;
					}else {
						if (obj[2] == "1" || obj[2] == "0") {
							if (obj[1] == document.getElementById("foodDesc").value && obj[0] == document.getElementById("foodType").value) {

								var mssg = "Special Food Items"; //Modified Against PMG2017-COMN-CRF-0012[IN066074]
								var label=mssg;
								var msg = "MESSAGE.OPERATION_FAILURE";
								msg1=msg.split(" ");
								return false;
							}
						}
					}
				}
			}
		}
		if (flag) {
			var newRow = tabObj.insertRow(row_ind);
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var sub = "<A  href=\"#\" onclick=\"return fetchFoodDislikesRow('" + count + "');\" >" + document.getElementById("foodDesc").value + "</A>";
			newCellitemType.innerHTML = sub;
			foodDislikeList[count] = new Array();
			foodDislikeList[count][0] = document.getElementById("foodType").value;
			foodDislikeList[count][1] = document.getElementById("foodDesc").value;
			foodDislikeList[count][2] = "0";
		}
		flag = true;
	}else {
		var supCode = document.getElementById("rowNo").value;
		foodDislikeList[supCode] = new Array();
		foodDislikeList[supCode][0] = document.getElementById("foodType").value;
		foodDislikeList[supCode][1] = document.getElementById("foodDesc").value;
		foodDislikeList[supCode][2] = "0";

		var tbodyObj = document.all("listContentTable");
		while (tbodyObj.rows.length > 1) {
			tbodyObj.deleteRow(1);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 1;
		var obj;
		for (var i = 0; i < foodDislikeList.length; i++) {
			if(foodDislikeList[i] != undefined){
				obj = foodDislikeList[i];
				if (obj != null) {
					if (obj[2] != "-1") {
						var newRow = tbodyObj.insertRow(row_ind);
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + i + "');\" >" + obj[1] + "</A>";
						newCellitemType.innerHTML = sub;
					}
				}
			}
		}
	}
	document.getElementById("rowNo").value = "";
	document.getElementById("foodType").value = "";
	document.getElementById("foodDesc").value="";
}

function getFoodDislikeDtls() {
	window.returnValue = foodDislikeList;
	delFoodDisList.push(delFoodDis)
	window.close();
}

function fetchFoodDislikesRow(val) {
	document.all("foodType").value = foodDislikeList[val][0];
	document.all("foodDesc").value = foodDislikeList[val][1];
	document.all("rowNo").value = val;
	/*var j=0;
	if(foodDislikeList[val][0] != null && foodDislikeList[val][1] != null){
		if(itemCodeDel.length == 0){
			var i =0;
		}
			itemCodeDel[i] = new Array();
			itemCodeDel[i][j] =  foodDislikeList[val][0];
			itemCodeDel[i][j+1] =  foodDislikeList[val][1];
			itemCodeDel[i][j+2] =  "-1";
	}
	i = i + 1;*/
}

function deleteFoodDislikesRow() {
	if (document.getElementById("foodType").value == "" || document.getElementById("foodDesc").value =="") {
		var msg = getMessage("DS_ITM_NOT_BLANK","DS");//"Item can not be blank";
		alert(msg);
		return false;
	}

	var foodType = document.getElementById("foodType").value;
	if(foodType != null){
		delFoodDis.push(foodType);
	}

	if (document.getElementById("rowNo").value != "") {
		var cod = document.getElementById("rowNo").value;
		if (foodDislikeList[cod][2] == "0") {
			foodDislikeList[cod] = null;
		} else {
			foodDislikeList[cod][2] = "-1";
		}
		var tbodyObj = document.all("listContentTable");
		while (tbodyObj.rows.length > 1) {
			tbodyObj.deleteRow(1);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 1;
		for (var i = 0; i < foodDislikeList.length; i++) {
			var obj = foodDislikeList[i];
			if (obj != null) {
				if (obj[2] != "-1") {
					var newRow = tbodyObj.insertRow(row_ind);
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					var sub = "<A href=\"#\" onclick=\"return fetchFoodDislikesRow('" + i + "');\" >" + obj[1] + "</A>";
					newCellitemType.innerHTML = sub;
				}
			}		//var newCellfoodType = newRow.insertCell(newRow.cells.length);
		}
	}
	/*if(itemCodeDel != null && itemCodeDel.length > 0){
		for(var i=0; i < itemCodeDel.length;i++){
			foodDislikeList[i] = new Array();
			foodDislikeList[i][0] = itemCodeDel[i][0];
			foodDislikeList[i][1] = itemCodeDel[i][1];
			foodDislikeList[i][2] = itemCodeDel[i][2];
		}
	}*/

	document.getElementById("rowNo").value = "";
	document.getElementById("foodType").value = "";
	document.getElementById("foodDesc").value = "";

}
function defaultDisabled(){
	document.getElementById("periodBetween").disabled = true;
	document.getElementById("frequency").disabled = true;
	document.getElementById("mand1").style.visibility="hidden";
	document.getElementById("mand2").style.visibility="hidden";
	document.getElementById("mealTypesId").disabled=false;
	document.getElementById("frequencyBasedYn").checked = false
}

async function mealTypeSpFoodItems(obj,fecthedMealTypes)
{
		mealTypeStr1="";
		var mealtype = document.getElementById("mealtype").value;
		document.getElementById("frequencyBasedYn").disabled = true;
		var dialogUrl1 = "../../eDS/jsp/MealTypesForFrequency.jsp?&fecthedMealTypes="+fecthedMealTypes+"&mealtype="+mealtype;
		var dialogArguments = mealTypesArray;
		//var dialogFeatures = "dialogHeight:12;dialogWidth:15;status:no;scroll:no";
		var dialogTop   = "65";
	    var dialogHeight    = "300px" ; //30.5
	    var dialogWidth = "300px" ;
	    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
		returnVal2 =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
		if(returnVal2)
		{
			mealTypeStr1=returnVal2;
			document.getElementById("frequencyBasedYn").disabled = true;
			document.getElementById("periodBetween").disabled = true;
			document.getElementById("frequency").disabled = true;
	}
	else
	{
		if(mealtype == "" || mealtype == "null")
				document.getElementById("frequencyBasedYn").disabled = false;
		else
				document.getElementById("frequencyBasedYn").disabled = true;
			}
		}

//validating Period between in Spl FoodItem window.
function setPeriod(obj)
{
	var flag=true;
	if(parseInt(obj.value)==1)document.getElementById("periodBetween").value="01:00"
		else if(parseInt(obj.value)==0)
		{

		flag=false;
		/*var mes = "Frequency Based";
		var label1 = mes;
		var mes1 ="should be greater than"
		var msg = mes1;
		var error="";
		error=label1+" "+msg+"  0"; */

		error = getMessage("DS_FREQ_GRTR_ZERO","DS");
		alert(error)
		obj.value="";
		obj.select;
		obj.focus();
	}
	return flag;
}

/* FrequencyBased checkbox logic for splFoodItem  */

function freqEnable(val){
	if(document.getElementById("frequencyBasedYn").checked == true){
		document.getElementById("periodBetween").disabled = false;
		document.getElementById("frequencyBasedYn").disabled = false;
		document.getElementById("frequency").disabled = false;
		document.getElementById("mand1").style.visibility="visible";
		document.getElementById("mand2").style.visibility="visible";
		document.getElementById("mealTypesId").disabled=true;

	}else if(document.getElementById("frequencyBasedYn").checked == false){
		document.getElementById("periodBetween").disabled = true;
		document.getElementById("mand1").style.visibility="hidden";
		document.getElementById("mand2").style.visibility="hidden";
		document.getElementById("mealTypesId").disabled=false;
		document.getElementById("frequency").disabled = true;
		document.getElementById("frequency").value = "";
		document.getElementById("periodBetween").value = "";
	}
}

function showLookupForItemType1(obj){
	if (document.getElementById("itemType").value != "") {
		showLookupForItemType();
	}
}
async function showLookupForItemType(obj) {
	if (document.getElementById("itemType").value == "") {
		//alert("Item Type Can Not be Blank");
		alert(getMessage("DS_ITMTYPE_NOT_BLANK","DS"));
		return;
	}
	var locale = document.getElementById("language_Id").value;
	var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();

    //var sql = "SELECT A.FOOD_ITEM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.ITEM_TYPE) LIKE UPPER(?) AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID = '"+locale+"'";
//    var sql = "SELECT A.FOOD_ITEM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID = '"+locale+"'";
    var sql = "SELECT A.FOOD_ITEM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.ITEM_TYPE) LIKE UPPER('"+document.getElementById("itemType").value+"') AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID = '"+locale+"'";

    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr =await CommonLookup("Item", argumentArray);
	var str =unescape(retArr);
	var arr = str.split(",");
	if (retArr != null  && retArr != "") {
		document.getElementById("foodType").value = arr[0];
        document.getElementById("foodDesc").value = arr[1];
        var pArgumentArrayMap = "foodItemCode=" + arr[0];

	}
}

async function showLookup_mealMenuItems(obj) {
	var locale = document.getElementById("language_Id").value;
	var additemType = document.getElementById("additemType").value;//KDAH-CRF-0349-US004
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
   
	//var sql = "SELECT A.FOOD_ITEM_CODE CODE, A.SHORT_DESC DESCRIPTION FROM DS_ITEMS A WHERE A.EFF_STATUS ='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.FOOD_ITEM_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID = '"+locale+"'";
    //KDAH-CRF-0349-US004
	var sql="select FOOD_ITEM_CODE CODE,SHORT_DESC DESCRIPTION from Ds_Items where item_type like '"+additemType+"' and NVL (eff_status, 'E') = 'E' and language_Id = '"+locale+"' and upper(SHORT_DESC) like UPPER(?) and upper(FOOD_ITEM_CODE) like UPPER(?)";
	//Modified against AMS-SCF-0820 (eff_status)

    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	retArr =await CommonLookup("Item", argumentArray);
	var str =unescape(retArr);
	var arr = str.split(",");
	if (retArr != null  && retArr != "") {
		document.getElementById("foodType").value = arr[0];
        document.getElementById("foodDesc").value = arr[1];
        var pArgumentArrayMap = "foodItemCode=" + arr[0];

	}
}
function clearFood() {
	document.all("foodType").value = "";
	document.all("foodDesc").value = "";
}

function checkDigit(){
	obj =  String.fromCharCode(window.event.keyCode);
   	var alphaFilter =/^[0-9]+$/;
   	if (!(alphaFilter.test(obj))) {
   	var num =getMessage("DS_NUM_ONLY_ALLOWED","DS")//"Numbers Only Allowed";
	var error = dwrMessage;
	alert(num)
   	window.event.keyCode = 27;
		}
}

var meal_Type_arr = new Array();
var mealTypesArray = new Array();
var mealTypeStr1;
//var colorieList =new Hashtable();
var foodARR = new Array();
var itemSrlNo = new Array();
var prlSLdel = new Array();

var qty;

var uomCode;
var flagMTs=true;
var emptyFlag=true;

var iCode="";
var Calori=0;
var energyUom="";
var TotalCalorie=0;
var insertFlag=null;
var updFlag=false;
var insFlag=false;
function ValidRecords()
{
	var tableObj = document.getElementById("listContentTable");
	var countRow = tableObj.rows.length;
	//var locale=document.getElementById("languageId").value;
	var row_ind = 1;
	var key_value = "";
		if (document.all("from").value == "") {
			alert(getMessage("DS_FRMDATE_NOT_BLANK","DS"));
			return false;
		}		
		if (document.all("itemType").value == "") {
			alert(getMessage("DS_ITMTYPE_NOT_BLANK","DS"));
			return false;
		}
		if (document.all("foodDesc").value == "" || document.all("foodType").value == "") {
			alert(getMessage("DS_ITM_NOT_BLANK","DS"));
			return false;
		}
		if (document.all("qty").value == "") {
			alert(getMessage("DS_QTY_NOT_BLANK","DS"));
			return false;
		}
		if(document.all("frequencyBasedYn").checked == true){
			if (document.all("frequency").value == "") {
				alert(getMessage("DS_FREQ_NOT_BLANK","DS"));
				return false;
			}
			if (document.all("periodBetween").value == "") {
				alert(getMessage("DS_PERBET_NOT_BLANK","DS"));
				return false;
			}
		}

		//ML-MMOH-CRF-0427 starts
			var profileFlag=$('#profileFlag').val();
			var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			var maximum_days_allowed=$('#maximum_days_allowed').val();
			var selecteddate=$('#from').val();
			//var locale=document.getElementById("languageId").value;
			var locale=$('#languageId').val();
			if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
			var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);

			if(!flag){
				var error="";
				var sysdate=getCurrentDate("DMH",locale);
				var maxdate=addDays(new Date(),maximum_days_allowed);
				var maxToDate=changeDate(maxdate);
				var fieldName=getLabel("Common.fromdate.label","common");
				var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
				error+=fieldName;
				error+=msgArray[1];
				error+=sysdate;
				error+=msgArray[2];
				error+=maxToDate;
	        		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				$('#from').focus();
				$('#from').select();
				return false;
			}else{
				var error="";
				parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}
			}
		//ML-MMOH-CRF-0427 ends

		var freqFlag = checkDateFreq();
		if(freqFlag != true){
			if(document.getElementById("frequency").value != "" && document.getElementById("periodBetween").value != ""){
				alert(getMessage("DS_EXCEED_24HRS","DS"));
				return false;
			}
		}
	if (document.getElementById("rowNo").value == "")
	{
			countRowValue = foodARR.length;
		if (foodARR)
		{
				for (var i = 0; i < foodARR.length; i++) {
					var obj = foodARR[i];
					if (obj != null) {
						if (obj[6] != "-1") {
							if(document.all("frequencyBasedYn").checked == true){
								var fromDate = document.all("from").value;
								var fromDateArr = fromDate.split(" ");
								var dateArr = obj[0].split(" ");

								if (obj[7] == document.all("foodDesc").value && dateArr[0] == fromDateArr[0]) {
									//alert("This Food Item Is Already Exits");
									alert(getMessage("DS_FOODITM_EXIST","DS"));
									return false;
								}
							}else if(document.all("frequencyBasedYn").checked == false){
								var fromDate = document.all("from").value;
								var fromDateArr = fromDate.split(" ");
								var dateArr = obj[0].split(" ");

								if(mealTypeStr1 == undefined){
									//alert(getMessage("DS_MEALTYPE_NOT_BLANK","DS"));//Commented against ML-MMOH-CRF-1060
									alert(getMessage("DS_MEALTYPES_NOT_BLANK","DS"));//Added against ML-MMOH-CRF-1060
										return false;
								}
								var mt_attT=mealTypeStr1.split("*");
								if(mt_attT != null || mt_attT != ""){
									if(mt_attT.length != 0 || mt_attT.length != "" || mt_attT.length != null){
										for(var k=0; k < mt_attT.length; k++){
											mt_attS = mt_attT[k].split("@");
											if(mt_attS[0] != undefined){
												if (obj[7] == document.all("foodDesc").value && dateArr[0] == fromDateArr[0] && obj[18] == mt_attS[0]) {
													alert(getMessage("DS_FOODITM_EXIST","DS"));
													//alert("This Food Item Is Already Exits");
													return false;
												}
											}
										}
									}
								}
							}
						}
					}

				}
			}
		if (document.all("from").value != "" && document.all("itemType").value != "" && document.all("foodType").value != "" && document.all("qty").value != "" && document.all("frequencyBasedYn").checked == false )
		{
				Apply_flag=false;
				sl_flag=false;
				var foodType = document.all("foodType").value;
				var locale =document.getElementById("language_Id").value;
				var mode = "KaloriForMeals";
				var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
				var xmlDoc="" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
				xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		        xmlHttp.setRequestHeader("charset","UTF-8");
				xmlHttp.send(xmlDoc);
				var retValue = localTrimString(xmlHttp.responseText);
				var getSplFoodItemCalori = retValue.split(",");
				var iCode = getSplFoodItemCalori[0];
				var Calori = getSplFoodItemCalori[1];
				var energyUom = getSplFoodItemCalori[2];
				var energyUom_Desc = getSplFoodItemCalori[3];//Added Against PMG2017-COMN-CRF-0012.1-US001
				//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
				var servingUom_Code = getSplFoodItemCalori[4];
				var servingUom_Desc = getSplFoodItemCalori[5];
				//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here

				window.setTimeout(splFoodItemRec1, 1000);
				function splFoodItemRec1(){
					if(flagMTs == false){
						if(mealTypeStr1 == undefined){
							//alert(getMessage("DS_MEALTYPE_NOT_BLANK","DS"));//Commented against ML-MMOH-CRF-1060
							alert(getMessage("DS_MEALTYPES_NOT_BLANK","DS"));//Added against ML-MMOH-CRF-1060
						return false;
						}
					}
					if(mealTypeStr1 == undefined){
					   //alert(getMessage("DS_MEALTYPE_NOT_BLANK","DS"));//Commented against ML-MMOH-CRF-1060
						alert(getMessage("DS_MEALTYPES_NOT_BLANK","DS"));//Added against ML-MMOH-CRF-1060
							return false;
					}
					var mt_att1=mealTypeStr1.split("*");
					if(mt_att1 != null || mt_att1 != ""){
						if(mt_att1.length != 0 || mt_att1.length != "" || mt_att1.length != null){
							for(var k=0; k < mt_att1.length; k++){
								mt_att = mt_att1[k].split("@");
								if(mt_att[1] != undefined){
									var matchVar = mt_att[1].match("#");
									if("#" == matchVar){
										var mt_att2 = mt_att[1].split("#");
										for(var i=1; i < mt_att2.length; i++)
										{
											mt_att[1]=mt_att[1].replace("#"," ")
										}
									}
								}
								if( mt_att1[k] != "" ){


									//foodARR[countRowValue] = new Array();
									foodARR[countRowValue] = [];
									foodARR[countRowValue][0] = document.all("from").value;
									foodARR[countRowValue][1] = "";
									foodARR[countRowValue][2] = document.all("itemType").value;
									foodARR[countRowValue][3] = document.all("foodType").value;
									foodARR[countRowValue][4] = document.all("qty").value;
									foodARR[countRowValue][5] = "0";
									foodARR[countRowValue][6] = "0";
									foodARR[countRowValue][7] = document.all("foodDesc").value;
									foodARR[countRowValue][8] = document.all("itemType").options[document.all("itemType").selectedIndex].text;
									foodARR[countRowValue][9] = document.getElementById("servingUomCode").value;

									foodARR[countRowValue][16] = document.getElementById("frequency").value;
									foodARR[countRowValue][17] = document.getElementById("periodBetween").value;
									foodARR[countRowValue][18] = mt_att[0];
									foodARR[countRowValue][19] = mt_att[1];
									if(document.getElementById("frequencyBasedYn").checked==true){
										foodARR[countRowValue][20] = "Y";

									}else{
										foodARR[countRowValue][20] = "N";

									}
									insFlag = true;
									var newRow = tableObj.insertRow(row_ind);
									newRow.id = countRowValue;
									var newCellitemType = newRow.insertCell(newRow.cells.length);
									var code = document.all("itemType").value + "-" + document.all("foodType").value;
									var sub = "<A href=\"#\" onclick=\"return fetchSpFoodItemRow('" + countRowValue + "');\" >" + foodARR[countRowValue][8] + "</A>";
									newCellitemType.innerHTML = sub;

									var newCellDate = newRow.insertCell(newRow.cells.length);
									newCellDate.appendChild(document.createTextNode(foodARR[countRowValue][0]));

									var newCellfoodType = newRow.insertCell(newRow.cells.length);
									newCellfoodType.appendChild(document.createTextNode(foodARR[countRowValue][7]));

									qty=foodARR[countRowValue][4];
									uomCode=foodARR[countRowValue][9]

									var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
							
									foodARR[countRowValue][13]=energyUom 
									//foodARR[countRowValue][14]=energyUom_Desc //Added Against PMG2017-COMN-CRF-0012.1-US001
									foodARR[countRowValue][21]=energyUom_Desc //Modified Against Nutrient Supplement & Special food item [IN:067653]
									foodARR[countRowValue][22]=servingUom_Desc //Added Against Nutrient Supplement & Special food item [IN:067653]
									TotalCalorie=parseFloat((Math.round(TotalCalorie*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
									foodARR[countRowValue][12]=parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
									foodARR[countRowValue][15]=parseFloat((Math.round(TotalCalorie*Math.pow(10,2))/Math.pow(10,2)));

									var cal1 = parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
							
									//var cal2 = cal1+" "+energyUom//Commenetd Against PMG2017-COMN-CRF-0012.1-US001
									var cal2 = cal1+" "+energyUom_Desc //Added Against PMG2017-COMN-CRF-0012.1-US001
									
									var newCellqty = newRow.insertCell(newRow.cells.length);
									newCellqty.appendChild(document.createTextNode(qty+" "+servingUom_Desc+"("+cal2+")"));//Modified Against Nutrient Supplement & Special food item [IN:067653]

									var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
									newCellMealTypeDesc.appendChild(document.createTextNode(foodARR[countRowValue][19]));

									var newCellFrequency = newRow.insertCell(newRow.cells.length);
									newCellFrequency.appendChild(document.createTextNode(""));

									var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
									newCellPeriodBetween.appendChild(document.createTextNode(""));
									countRowValue++;

								}
							}
						}
					}
					document.all("from").value = "";
					document.all("itemType").value = "";
					document.all("foodDesc").value = "";
					document.all("qty").value = "";
					document.all("foodType").value = "";
					document.getElementById("servingUomCode").value="";
					document.getElementById("frequencyBasedYn").disabled = false
				}
					document.getElementById("rowNo").value = "";
			}
			else
			{
					sl_flag=false;
					Apply_flag=false;
					var foodType = document.all("foodType").value;
					var locale =document.getElementById("language_Id").value;
					var mode = "KaloriForMeals";
					var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
					var xmlDoc="" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
					xmlHttp.send(xmlDoc);
					var retValue = localTrimString(xmlHttp.responseText);
					var getSplFoodItemCalori = retValue.split(",");
					var iCode = getSplFoodItemCalori[0];
					var Calori = getSplFoodItemCalori[1];
					var energyUom = getSplFoodItemCalori[2];
					var energyUom_Desc = getSplFoodItemCalori[3];//Added Against PMG2017-COMN-CRF-0012.1-US001
					//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
					var servingUom_Code = getSplFoodItemCalori[4];
					var servingUom_Desc = getSplFoodItemCalori[5];
					//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here
					
					window.setTimeout(timeOutFunction, 500);
						function timeOutFunction(){
//						foodARR[countRowValue] = new Array();
						foodARR[countRowValue] = [];
						foodARR[countRowValue][0] = document.all("from").value;
						foodARR[countRowValue][2] = document.all("itemType").value;
						foodARR[countRowValue][3] = document.all("foodType").value;
						foodARR[countRowValue][4] = document.all("qty").value;
						foodARR[countRowValue][5] = "0";
						foodARR[countRowValue][6] = "0";
						foodARR[countRowValue][7] = document.all("foodDesc").value;
						foodARR[countRowValue][8] = document.all("itemType").options[document.all("itemType").selectedIndex].text;
						foodARR[countRowValue][9] = document.getElementById("servingUomCode").value;
						foodARR[countRowValue][16] = document.getElementById("frequency").value;
						foodARR[countRowValue][17] = document.getElementById("periodBetween").value;
						foodARR[countRowValue][18] = "";
						foodARR[countRowValue][19] = "";
						document.getElementById("frequencyBasedYn").disabled = false;

						if(document.getElementById("frequencyBasedYn").checked==true){
							foodARR[countRowValue][20] = "Y";
						}else{
							foodARR[countRowValue][20] = "N";
						}
						insFlag = true;
						var newRow = tableObj.insertRow(row_ind);
						newRow.id = countRowValue;
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var code = document.all("itemType").value + "-" + document.all("foodType").value;
						var sub = "<A href=\"#\" onclick=\"return fetchSpFoodItemRow('" + countRowValue + "');\" >" + foodARR[countRowValue][8] + "</A>";
						newCellitemType.innerHTML = sub;
						var newCellDate = newRow.insertCell(newRow.cells.length);
						newCellDate.appendChild(document.createTextNode(foodARR[countRowValue][0]));

						var newCellfoodType = newRow.insertCell(newRow.cells.length);
						newCellfoodType.appendChild(document.createTextNode(foodARR[countRowValue][7]));

						qty=foodARR[countRowValue][4];
						uomCode=foodARR[countRowValue][9]
						var CaloriT=parseFloat((Math.round(qty*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
						foodARR[countRowValue][13]=energyUom 
						//foodARR[countRowValue][14]=energyUom_Desc //Added Against PMG2017-COMN-CRF-0012.1-US001
						foodARR[countRowValue][21]=energyUom_Desc //Modified Against Nutrient Supplement & Special food item [IN:067653]
						foodARR[countRowValue][22]=servingUom_Desc //Added Against Nutrient Supplement & Special food item [IN:067653]
						TotalCalorie=parseFloat((Math.round(TotalCalorie*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));
						foodARR[countRowValue][12]=CaloriT;
						foodARR[countRowValue][15]=TotalCalorie;
						var newCellqty = newRow.insertCell(newRow.cells.length);
						var cal = CaloriT
						//var cal1 = cal+" "+energyUom //Commented Against PMG2017-COMN-CRF-0012.1-US001
						var cal1 = cal+" "+energyUom_Desc //Added Against PMG2017-COMN-CRF-0012.1-US001 
						newCellqty.appendChild(document.createTextNode(qty+" "+servingUom_Desc+"("+cal1+")"));//Modified Against Nutrient Supplement & Special food item [IN:067653]

						var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
						newCellMealTypeDesc.appendChild(document.createTextNode(""));

						var newCellFrequency = newRow.insertCell(newRow.cells.length);
						newCellFrequency.appendChild(document.createTextNode(foodARR[countRowValue][16]));

						var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
						newCellPeriodBetween.appendChild(document.createTextNode(foodARR[countRowValue][17]));
						clearSplFoodItemsFields();
					}
				}
	}
	else
	{
			Apply_flag=false;
			sl_flag=true;
			var supCode = document.getElementById("rowNo").value;
			foodARR[supCode] = [];
			foodARR[supCode][0] = document.all("from").value;
			foodARR[supCode][1] = document.getElementById("frequency").value;
			foodARR[supCode][2] = document.all("itemType").value;
			foodARR[supCode][3] = document.all("foodType").value;
			foodARR[supCode][4] = document.all("qty").value;
			foodARR[supCode][7] = document.all("foodDesc").value;
			foodARR[supCode][8] = document.all("itemType").options[document.all("itemType").selectedIndex].text;
			foodARR[supCode][9] = document.getElementById("servingUomCode").value;
			foodARR[supCode][13] = energyUom;
			//foodARR[supCode][14] = energyUom_Desc;//Added Against PMG2017-COMN-CRF-0012.1-US001
			foodARR[supCode][21] = energyUom_Desc//Modified Against Nutrient Supplement & Special food item [IN:067653]
			foodARR[supCode][18] = document.getElementById("mealTypeDesc").value;
			foodARR[supCode][19] = document.getElementById("mealtype").value;
			document.getElementById("frequencyBasedYn").disabled = false;
			if(document.getElementById("frequencyBasedYn").checked==true){
				foodARR[supCode][20] = "Y";
			}else{
				foodARR[supCode][20] = "N";
			}

			foodARR[supCode][17] = document.getElementById("periodBetween").value;
			if(sl_flag == true){
				getSlNo();
				sl_flag == false;
			}
			updFlag = true;
			document.getElementById("rowNo").value = "";
			var tableObj = document.getElementById('listContentTable');
			while (tableObj.rows.length > 1) {
				tableObj.deleteRow(1);
			}

			for (var i = 0; i < foodARR.length; i++) {
				var obj = foodARR[i];
				if (obj != null) {
						if (obj[6] != "-1") {
							var foodType = trim(obj[3]);
							var locale =document.getElementById('language_Id').value;
							var mode = "KaloriForMeals";
							var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
							var xmlDoc="" ;
							var xmlHttp = new XMLHttpRequest() ;
							var xmlStr ="<root></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
							xmlHttp.send(xmlDoc);
							var retValue = localTrimString(xmlHttp.responseText);
							var getSplFoodItemCalori = retValue.split(",");
							var iCode = getSplFoodItemCalori[0];
							var Calori = getSplFoodItemCalori[1];
							var energyUom = getSplFoodItemCalori[2];
							var energyUom_Desc = getSplFoodItemCalori[3]; //Added Against PMG2017-COMN-CRF-0012.1-US001
							//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
							var servingUom_Code = getSplFoodItemCalori[4];
							var servingUom_Desc = getSplFoodItemCalori[5];
							//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here
							
							if(energyUom != null){
								obj[13] = energyUom
							}
							
							//Added Against PMG2017-COMN-CRF-0012.1-US001 Starts Here
							if(energyUom_Desc != null){
								obj[21] = energyUom_Desc
							}
							//Added Against PMG2017-COMN-CRF-0012.1-US001 Ends Here
							
							//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
							if(servingUom_Desc != null){
								obj[22] = servingUom_Desc
							}
							//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here

							var countRow = tableObj.rows.length;
							var row_ind = 1;
							var newRow = tableObj.insertRow(row_ind);
							var newCellitemType = newRow.insertCell(newRow.cells.length);
							var sub = "<A href=\"#\" onclick=\"return fetchSpFoodItemRow('" + i + "');\" >" + obj[8] + "</A>";
							newCellitemType.innerHTML = sub;

							var newCellDate = newRow.insertCell(newRow.cells.length);
							newCellDate.appendChild(document.createTextNode(obj[0]));
							var newCellfoodType = newRow.insertCell(newRow.cells.length);
							newCellfoodType.appendChild(document.createTextNode(obj[7]));
							var newCellqty = newRow.insertCell(newRow.cells.length);
							obj[12]=parseFloat((Math.round(trim(obj[4])*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)))
							var cal = parseFloat((Math.round(obj[12]*Math.pow(10,2))/Math.pow(10,2)));
						//	var cal1 = cal+" "+obj[13] //Commented Against PMG2017-COMN-CRF-0012.1-US001
							var cal1 = cal+" "+obj[21] //Added Against PMG2017-COMN-CRF-0012.1-US001
							newCellqty.appendChild(document.createTextNode(obj[4]+" "+obj[22]+"("+cal1+")"));//Modified Against Nutrient Supplement & Special food item [IN:067653]
							if(obj[18] != undefined && obj[18]!="null" && obj[18]!=" null"){
								var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
								newCellMealTypeDesc.appendChild(document.createTextNode(obj[18]));
							}else{
								var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
								newCellMealTypeDesc.appendChild(document.createTextNode(""));
							}
							if(obj[1] != undefined && obj[1] != " null" && obj[1] != "null"){
								var newCellFrequency = newRow.insertCell(newRow.cells.length);
								newCellFrequency.appendChild(document.createTextNode(obj[1]));
							}else{
								var newCellFrequency = newRow.insertCell(newRow.cells.length);
								newCellFrequency.appendChild(document.createTextNode(""));
							}
							if(obj[18] == "null"){
								var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
								newCellPeriodBetween.appendChild(document.createTextNode(obj[17]));
							}
							else if(obj[17] != undefined && obj[17] != "null" && obj[17] != " null"){
								var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
								if(trim(obj[17]).indexOf(":") != -1 && obj[18] != " null"){
									newCellPeriodBetween.appendChild(document.createTextNode(""));
								}else {
									newCellPeriodBetween.appendChild(document.createTextNode(obj[17]));
								}

							}else{
								var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
								newCellPeriodBetween.appendChild(document.createTextNode(""));
							}
					}
				}
			}
				clearSplFoodItemsFields();
				document.getElementById("frequencyBasedYn").disabled = false;
				document.getElementById("mealTypesId").disabled = false;
				document.getElementById("frequencyBasedYn").checked = false;
				document.getElementById("mealtype").value = "";
		}
}

function dmyDate(s){
	var A= s.split(/\D+/);
	var D= new Date(A[2]*1,A[1]-1,A[0]*1)
	if(A.length == 5)D.setHours(A[3]*1,A[4]*1);
	return new Date(D);
}
function checkDateFreq(){
	var periodTime = document.all("periodBetween").value;
	var freq = document.all("frequency").value;
	var SDate = document.getElementById("from").value;

	STime = SDate.split(" ");
	STDate = STime[0]+" "+"23:59";
	var m_seconds2 = (dmyDate(SDate).getTime())
	var m_seconds3 = (dmyDate(STDate).getTime())
	var mills=Math.ceil(m_seconds3-m_seconds2);
	var pt=periodTime.split(":");
	var periodTime1 = pt[0];
	var inMins = periodTime1*60;
	var totalMins=parseInt(inMins)+parseInt(pt[1])
	var totalSec = totalMins*60;
	var totalMilliSec = totalSec*1000;
	var totalMillsWithFreq = totalMilliSec*parseInt(freq)
	if(totalMillsWithFreq>mills){
		f10=false;
		return f10=false;
	}else{

		f10=true;
		return f10=true;
	}
	return f10;
}

function verify(timeBox){
	if(timeBox.value != ""){
//	alert(timeBox.value.length)
		if(parseInt(timeBox.value.length)<=parseInt(5))
		{
			if(timeBox.value!=""){
				time=timeBox.value
			    time1=time.split(':')
			    if (!/\d{2}:\d{2}/.test(time)){
					//alert("Invalid Time Formate");
			    	alert(getMessage("DS_INVAL_TIMEFORMAT","DS"));
					timeBox.value='';
					timeBox.focus();
					return false;
			    }
				// Fix for Incident 47807
			    else if (time1[0] >12 || time1[0] <1) {
			    	alert(getMessage("DS_HOUR_INVALID","DS"));
					timeBox.value='';
					timeBox.focus();
				return false;
			    }// Fix for Incident 47807 ends

			    else if (time1[0] >23 || time1[1]>59) {
			    	alert(getMessage("DS_INVAL_TIMEFORMAT","DS"));
			    	timeBox.value='';
			    	timeBox.focus();
			    	return false;
			    }else return true;
			}else{
				timeBox.value='';
				alert(getMessage("DS_INVAL_TIMEFORMAT","DS"));
				timeBox.focus();
				return false;
				}
			}else{
				timeBox.value='';
				alert(getMessage("DS_INVAL_TIMEFORMAT","DS"));
				timeBox.focus();
				return false;
			}
		}
	}

function clearSplFoodItemsFields(){

	document.all("from").value = "";
//	document.all("frequency").value = "";
	document.all("itemType").value = "";
	document.all("foodDesc").value = "";
	document.all("qty").value = "";
//	document.all("vo.to").value = "";
	document.all("rowNo").value = "";
	document.all("foodType").value = "";
	document.getElementById("servingUomCode").value="";
	document.getElementById("frequency").value="";
	document.getElementById("periodBetween").value="";


}

function setSplFoodItemRec(){
	var returnVal1 = new Array();
	var foodArray1 = new Array();
	var profileSl=document.getElementById("profileSL").value
	var tbodyObj = document.all("FoodItems1");
	var row_ind = 0;

	for(var k=0;k<foodARR.length;k++){
		foodArray1 = foodARR[k];
		if(foodArray1 != undefined){	
			if(foodArray1[5] != undefined){
			var newRow = tbodyObj.insertRow(row_ind);
			newRow.id = countRowValue;
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var sub = "";
			if(foodArray1[16] == null||foodArray1[16] == ''||foodArray1[16] == undefined){
				foodArray1[16]="";
			}

			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].from' id='specialFooditemsVOs[" + (row_ind) + "].from' value='" + foodArray1[0] + "'/>";
			//sub += "<input type='hidden' name='vo.specialFooditemsVOs[" + (row_ind) + "].frequency' id='vo.specialFooditemsVOs[" + (row_ind) + "].frequency' value='" + foodArray1[1] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].period' id='specialFooditemsVOs[" + (row_ind) + "].period' value='" + foodArray1[5] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemType' id='specialFooditemsVOs[" + (row_ind) + "].itemType' value='" + foodArray1[2] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].foodItem' id='specialFooditemsVOs[" + (row_ind) + "].foodItem' value='" + foodArray1[3] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].qty' id='specialFooditemsVOs[" + (row_ind) + "].qty' value='" + foodArray1[4] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].frequencyBasedYn' id='specialFooditemsVOs[" + (row_ind) + "].frequencyBasedYn' value='"+foodArray1[20]+"'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].profileSl' id='specialFooditemsVOs[" + (row_ind) + "].profileSl' value='"+profileSl+"'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemSl' id='specialFooditemsVOs[" + (row_ind) + "].itemSl' value='" + foodArray1[6] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].frequency' id='specialFooditemsVOs[" + (row_ind) + "].frequency' value='" + foodArray1[16] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].periodBetween' id='specialFooditemsVOs[" + (row_ind) + "].periodBetween' value='"+foodArray1[17] + "'/>";

			if(foodArray1[18] == ""){
				var mealType="";
				sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].mealType' id='specialFooditemsVOs[" + (row_ind) + "].mealType' value='" + mealType + "'/>";
			}else{
				sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].mealType' id='specialFooditemsVOs[" + (row_ind) + "].mealType' value='" + foodArray1[18] + "'/>";
			}

		newCellitemType.innerHTML = sub;
		row_ind++;
		}
		}
	}
}

var Apply_flag = true;
var sl_flag = false;
var incr=0;

function setRecord(){
	var tbodyObj = document.all("listContentTable");
	var countRow = tbodyObj.rows.length;

	if(countRow == 0){
		//alert("APP-DS0019 Select Atleast One Record")
		alert(getMessage("DS_SEL_RECORD","DS"));
			return false;
	}else{
			setRecord1();
	}
}

function setRecord1(){
	var mode ="insertSplFoodItems";
	for(var i =0; i < foodARR.length; i++){
		if(Apply_flag == false && insFlag){
			if(foodARR[i] == null){
				break;
			}
			var encounterId = document.getElementById("encounterId").value;
			var patientClass = document.getElementById("patientClass").value;
			var facility= document.getElementById("addedFacilityId").value;
			var addedById = document.getElementById("addedById").value;
			var workStationNo = document.getElementById("workStationNo").value;
			var profileSL=document.getElementById("profileSL").value;
			var flag = document.getElementById("flag").value;
			if(profileSL=="" || profileSL == "0" || profileSL == null ){
				profileSL="0";
			}
			var paramType = "&encounterId="+encounterId
							+"&patientClass="+patientClass
							+"&facility="+facility
							+"&addedById="+addedById
							+"&workStationNo="+workStationNo
							+"&profileSL="+profileSL
							+"&flag="+flag
							+"&mode="+mode
							+"&foodARR="+foodARR[i];
			
			var xmlDoc="" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
			xmlHttp.send(xmlDoc);
			var retValue = localTrimString(xmlHttp.responseText);
		}
	}
	if (foodARR.length >0) {
		//alert("APP-DS0001 Operation Completed Successfully...");
		alert(getMessage("DS_OPER_COMPLETE","DS"));
		
	}

	//Added against 60459 Starts
	for(var i=0;i<foodARR.length;i++){
		var obj=foodARR[i];
	try{
	if(obj!="" && obj!=null && obj!="undefined"){
	if(obj[6]=="-1"){				
		var encounterId = document.getElementById("encounterId").value;
		var facility= document.getElementById("addedFacilityId").value;
		var profileSL=document.getElementById("profileSL").value;//Added by vikash against 60459
		var mode = "delSplFoodItemsNew";
		var Item_Type = trim(obj[2]);
		var Item_Code = trim(obj[3]);
		var Meal_Type = trim(obj[20]);
		var Freq_Based="";
		if(Meal_Type=="null" || Meal_Type=="undefined" || Meal_Type==""){
			Freq_Based="Y";
		}else{
			Freq_Based="N";
		}
		
		var paramDel = "&encounterId="+encounterId
				+"&facility="+facility
				+"&itemSrlNo="+itemSrlNo[i]
				+"&profileSL="+profileSL
				+"&Item_Type="+Item_Type
				+"&Item_Code="+Item_Code
				+"&Meal_Type="+Meal_Type
				+"&Freq_Based="+Freq_Based
				+"&mode="+mode;

		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramDel,false);
		xmlHttp.send(xmlDoc);				
			}
		}
		}catch(e){
		}
	}
	//Added by vikash against 60459 Ends
	
	if(itemSrlNo.length != 0 && prlSLList.length != 0 && delFlag){
		for(var i=0; i < itemSrlNo.length; i++ ){
		var encounterId = document.getElementById("encounterId").value;
		var facility= document.getElementById("addedFacilityId").value;
		var profileSL=document.getElementById("profileSL").value;//Added by vikash against 60459
		var mode = "delSplFoodItems";
		var paramDel = "&encounterId="+encounterId
						+"&facility="+facility
						+"&itemSrlNo="+itemSrlNo[i]
						+"&profileSL="+profileSL//Added by vikash against 60459
						+"&mode="+mode;

		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramDel,false);
		xmlHttp.send(xmlDoc);

		}
	}
	if(updFlag){
		for(var j=0; j < foodARR.length; j++){
			var encounterId = document.getElementById("encounterId").value;
			var facility= document.getElementById("addedFacilityId").value;
			var profileSL=document.getElementById("profileSL").value;
			if(profileSL=="" || profileSL == "0" || profileSL == null ){
				profileSL="0";
			}
			var obj = foodARR[j];
			var mode = "updSplFoodItems";
			if(foodARR[j] != null && foodARR[j] != "" && foodARR[j] != undefined){
				var paramUpd = "&encounterId="+encounterId
				+"&facility="+facility
				+"&profileSL="+profileSL
				+"&mode="+mode
				+"&foodARR="+foodARR[j];
				var xmlDoc="" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramUpd,false);
				xmlHttp.send(xmlDoc);
			}
		}
	}

	Apply_flag == true
	if(sl_flag == true){
		getSlNo();
		sl_flag == false;
	}
	getFoodDetailsDtls();
	window.close();
}

var slArr = new Array();
var slArrList = new Array();
var prlSLList = new Array();

function getSlNo(){
		var mode = "srlNO"
		var encounterId = document.getElementById("encounterId").value;
		var facility= document.getElementById("addedFacilityId").value;
		var paramSrlNo = "&encounterId="+encounterId+"&facility="+facility+"&mode="+mode;
		var xmlDoc="" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramSrlNo,false);
		xmlHttp.send(xmlDoc);
		var retSrlNO = localTrimString(xmlHttp.responseText);
		slArrList = retSrlNO.split(",");
		var m =0;
		for(var k=0; k < slArrList.length; k=k+2){
			if(slArrList[k] != null && slArrList[k] != ""){
				slArr[m] = slArrList[k+1];
				prlSLList[m] = slArrList[k];
				m = m+1;
			}
		}

		var i=0;
		for(var k=0; k < foodARR.length; k++){
		//Added by vikash against 60459
		try{
			if(foodARR[k] != null && foodARR[k] != ""){
				if(foodARR[k][6] != "-1"){
					if(slArr[i] != null && slArr[i] != ""){
						foodARR[k][6]=trim(slArr[i]);
					}
				}
				if(foodARR[k][5] != "-1"){
					if(prlSLList[i] != null && prlSLList[i] != ""){
						foodARR[k][5]=trim(prlSLList[i]);
					}
				}
				i = i+1;
			}
		}catch(e){
		
		}
		//Added by vikash against 60459
		}
}

var foodARR1 = new Array();
function getFoodDetailsDtls() {
	top.returnValue = foodARR;
	top.close();
}


function fetchSpFoodItemRow(val) {
	sl_flag=true;
	Apply_flag=false;
	//Added by vikash against 60459
	var i = 0;
	//if(foodARR[val][6] > 0 && foodARR[val][5] > 0){
	if(foodARR[val][6] > 0){

		if(itemSrlNo.length == 0){
			i = 0;
		}
		itemSrlNo[i] = foodARR[val][6];
		prlSLdel[i] = foodARR[val][5];

	}
	//Added by vikash against 60459
	document.all("from").value = trim(foodARR[val][0]);
	document.all("itemType").value = trim(foodARR[val][2]);
	document.all("foodType").value = trim(foodARR[val][3]);
	document.all("foodDesc").value = trim(foodARR[val][7]);
	document.all("qty").value = trim(foodARR[val][4]);
	document.getElementById("mealtype").value = trim(foodARR[val][20]);
	document.getElementById("servingUomCode").value=trim(foodARR[val][9]);
	document.getElementById("frequency").value=trim(checkForNulls(foodARR[val][1]));//Added by vikash against 60459
	document.getElementById("periodBetween").value=trim(foodARR[val][17]);
	document.getElementById("mealTypeDesc").value=trim(foodARR[val][18]);
	document.all("rowNo").value = val;
	document.getElementById("rowNum").value = val;

	if(document.getElementById("frequency").value != null && document.getElementById("periodBetween").value != "" && document.getElementById("frequency").value != "null")
	{
		document.getElementById("frequencyBasedYn").checked=true;
		document.getElementById("frequencyBasedYn").value="Y";
		document.getElementById("frequency").disabled=false;
		document.getElementById("periodBetween").disabled=false;
		document.getElementById("mand1").style.visibility="visible";
		document.getElementById("mand2").style.visibility="visible";
		document.getElementById("mealTypesId").disabled = true
		document.getElementById("frequencyBasedYn").disabled = true
	}
	else
	{
		document.getElementById("frequencyBasedYn").checked=false;
		document.getElementById("frequencyBasedYn").value="N";
		document.getElementById("periodBetween").value="";
		document.getElementById("frequency").disabled=true;
		document.getElementById("frequency").value="";
		document.getElementById("periodBetween").disabled=true;
		document.getElementById("mand1").style.visibility="hidden";
		document.getElementById("mand2").style.visibility="hidden";
		document.getElementById("mealTypesId").disabled = false
		document.getElementById("frequencyBasedYn").disabled = true
	}
	i++;
}

var flagMTs=true;
var emptyFlag=true;
var gRowNo = null;
var delFlag = false;

function deleteSpItemRow()
{
	delFlag = true;
	flagMTs=false;
	sl_flag=true;
	Apply_flag=false;
	mealTypeStr1="";
	var rowNum = document.getElementById("rowNum").value;
	if(rowNum != null && rowNum != "")
	{
		rowNum++;
	}
	if(delFlag,rowNum)
	{
		getSlNoForDel(rowNum);
		sl_flag = false;
	}


	if (document.all("rowNo").value == "") {
		//alert("Please Select Atleast One Record to delete");
		alert(getMessage("DS_SEL_REC_TODEL","DS"));
		return false;
	}

	var tableObj = document.getElementById('listContentTable');
	if(tableObj.rows.length == 2){
		emptyFlag=false;
	}
	while (tableObj.rows.length > 1)
	{
		tableObj.deleteRow(1);
	}

	if (document.all("rowNo").value != "") {
		if (foodARR[document.all("rowNo").value][6] == "0") {
			//foodARR[document.all("rowNo").value] = null;//Commented by vikash against 60459
			//Added by vikash against 60459
			foodARR[document.all("rowNo").value][5] = foodARR[document.all("rowNo").value][6];
			foodARR[document.all("rowNo").value][6] = "-1";
			//Added by vikash against 60459
		} else {
			foodARR[document.all("rowNo").value][5] = foodARR[document.all("rowNo").value][6];
			foodARR[document.all("rowNo").value][6] = "-1";
		}
	}

	for (var i = 0; i < foodARR.length; i++) {
		var obj = foodARR[i];
		if (obj != null) {
			if (obj[6] != "-1") {
				var countRow = tableObj.rows.length;
				var row_ind = 1;
				var newRow = tableObj.insertRow(row_ind);
				var newCellitemType = newRow.insertCell(newRow.cells.length);
				var sub = "<A  href=\"#\" onclick=\"return fetchSpFoodItemRow('" + i + "');\" >" + obj[8] + "</A>";
				newCellitemType.innerHTML = sub;
				var newCellDate = newRow.insertCell(newRow.cells.length);
				newCellDate.appendChild(document.createTextNode(obj[0]));
				var newCellfoodType = newRow.insertCell(newRow.cells.length);
				newCellfoodType.appendChild(document.createTextNode(obj[7]));
				var newCellqty = newRow.insertCell(newRow.cells.length);
				//newCellqty.appendChild(document.createTextNode(obj[4]+" "+obj[9]+"("+obj[12]+" "+obj[13]+")")); //Commented Against PMG2017-COMN-CRF-0012.1-US001
				newCellqty.appendChild(document.createTextNode(obj[4]+" "+obj[22]+"("+obj[12]+" "+obj[21]+")"));//Added Against PMG2017-COMN-CRF-0012.1-US001 and Modified Against Nutrient Supplement & Special food item [IN:067653]

				//if(obj[18] != undefined && obj[19] != undefined){
				if(obj[18] != undefined && obj[18]!="null" && obj[18]!=" null"){
					var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
					newCellMealTypeDesc.appendChild(document.createTextNode(obj[18]));
				}else{
					var newCellMealTypeDesc = newRow.insertCell(newRow.cells.length);
					newCellMealTypeDesc.appendChild(document.createTextNode(""));
				}
				//if(obj[16] != undefined && obj[17] != undefined){
				if(obj[17] != undefined && obj[17] != "null" && obj[1] != undefined && obj[1] != " null" && obj[1] != "null" && obj[17] != " null"){
					var newCellFrequency = newRow.insertCell(newRow.cells.length);
					newCellFrequency.appendChild(document.createTextNode(obj[1]));
					var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
					newCellPeriodBetween.appendChild(document.createTextNode(obj[17]));
				}else{
					var newCellFrequency = newRow.insertCell(newRow.cells.length);
					newCellFrequency.appendChild(document.createTextNode(""));
					var newCellPeriodBetween = newRow.insertCell(newRow.cells.length);
					newCellPeriodBetween.appendChild(document.createTextNode(""));
				}
			}
		}
	}
	document.all("from").value = "";
	document.all("itemType").value = "";
	document.all("foodType").value = "";
	document.all("foodDesc").value = "";
	document.all("qty").value = "";
	document.all("rowNo").value = "";
	document.getElementById("servingUomCode").value="";
	document.getElementById("frequency").value="";
	document.getElementById("periodBetween").value="";
	document.getElementById("mealtype").value = ""; //049898

	if(document.getElementById("frequency").value != "" || document.getElementById("periodBetween").value != ""){
		document.getElementById("frequencyBasedYn").checked=true;
		document.getElementById("frequencyBasedYn").value="Y";
		document.getElementById("frequencyBasedYn").disabled = false;
		document.getElementById("mealTypesId").disabled = false;
	}else{
		document.getElementById("frequencyBasedYn").checked=false;
		document.getElementById("frequencyBasedYn").value="N";
		document.getElementById("frequencyBasedYn").disabled = false;
		document.getElementById("mealTypesId").disabled = false;
	}
}

var mealArray = new Array();
function getMealTypes(fecthedMealTypes,mealtype)
{
	var mealArray = fecthedMealTypes.split(",");
	var tableObj = null;
	var found_flag = false;
	var code = null;
	var mealTypeCode,mealTypeDesc,ServingStartTimeSUP,ServingEndTimeSUP,IrregularStartTimeSUP,IrregularEndTimeSUP,Sys_time,nextServingStartTimeSUP;//Modified Against ML-MMOH-CRF-0825
	tableObj = document.getElementById("AbleM");
	var selObj = "";
	var row_ind = 0;
	//Added Against ML-MMOH-CRF-0825 Starts Here
	var lateIrregularDietOrderSUP = document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_SP").value;
	var today = new Date();
	var hour=today.getHours();
	if(hour<=9){
		hour="0"+""+hour;
	}
	var minute=today.getMinutes();
	if(minute<=9){
		minute="0"+""+minute;
	}
	var Sys_time = hour+":"+minute;
	//Added Against ML-MMOH-CRF-0825-US007
	var facility_id=document.getElementById("facility_Id").value;
	for (var i=0; i < mealArray.length;){
	var sel="";
	if( i % 2 == 0)
	{
		var newRow = tableObj.insertRow(row_ind);
		var newCellDesc = newRow.insertCell(newRow.cells.length);
		newCellDesc.className = "label";
		if(mealArray[i+1] != null && mealArray[i+1] != 'undefined')
		newCellDesc.appendChild(document.createTextNode(mealArray[i+1]));
		sel="<input type='hidden' name='mealType' id='mealType'"+row_ind+" value='"+mealArray[i]+"'>";
		var newCellCBox = newRow.insertCell(newRow.cells.length);
		var mealTypesind="mealType_"+row_ind;
		//Added Against ML-MMOH-CRF-0825-US007
		if(mealArray[i+0] != null && mealArray[i+0] != 'undefined'){
			mealTypeCode = mealArray[i+0];
}
		//Added Against ML-MMOH-CRF-0825-US007
		if(mealArray[i+1] != null && mealArray[i+1] != 'undefined'){
			mealTypeDesc = mealArray[i+1];
		}
		//Added Against ML-MMOH-CRF-0825-US007
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=getSuplMealType&facility_id="+facility_id+"&mealTypeCode="+mealTypeCode;
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);	
		var mealCode_Arr = retVal.split(":::");
		var meal_type_code= mealCode_Arr[0];
		var meal_type_desc= mealCode_Arr[1];
		var ServingStartTimeSUP= mealCode_Arr[2];
		var ServingEndTimeSUP= mealCode_Arr[3];
		var IrregularStartTimeSUP= mealCode_Arr[4];
		var IrregularEndTimeSUP= mealCode_Arr[5];
		var meal_Order= mealCode_Arr[6];
		var nextServingStartTimeSUP= mealCode_Arr[7];
		//Added Against ML-MMOH-CRF-0825-US007

		//Added Against ML-MMOH-CRF-0825 Ends Here
		if(mealTypeDesc != "" && mealTypeDesc != "undefined" && mealTypeDesc != null)
		{
			var mealTypeDescArr = mealTypeDesc.split(" ");
			for(var j=1 ; j <=mealTypeDescArr.length;j++)
			{
				mealTypeDesc = mealTypeDesc.replace(" ","#");
			}
		}
		if(mealTypeDesc != "undefined" && mealTypeDesc != null)
			code = mealArray[i]+"@"+mealTypeDesc;
		
		//Added Against ML-MMOH-CRF-0825 Starts Here
		if(ServingStartTimeSUP=="" && ServingEndTimeSUP=="" && IrregularStartTimeSUP=="" && IrregularEndTimeSUP==""){
			IrregularEndTimeSUP = nextServingStartTimeSUP;
		}
		//Added Against ML-MMOH-CRF-0825 Ends Here
	var checkedYn = "";
	var disabledYn = "";
	if(mealArray[i] != null && mealtype==trim(mealArray[i]))
		checkedYn="checked";
		//Added Against ML-MMOH-CRF-0825 Ends Here
	if((mealtype == "" || mealtype == "null") && (code != null)) {		
		if(lateIrregularDietOrderSUP =="Y" && IrregularEndTimeSUP == "" && ServingEndTimeSUP != "" && ServingEndTimeSUP < Sys_time){
		checkedYn = "";
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" disabled onclick=\"setStatus("+row_ind+",this.value)\" >"
		}else if(lateIrregularDietOrderSUP =="Y" && IrregularEndTimeSUP != "" && IrregularEndTimeSUP < Sys_time ){
		checkedYn = "";
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" disabled onclick=\"setStatus("+row_ind+",this.value)\" >"
		}else{
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" onclick=\"setStatus("+row_ind+",this.value)\" >"
		 }
	} 
	else if(code != null && code != undefined){
		if(lateIrregularDietOrderSUP =="Y" && IrregularEndTimeSUP == "" && ServingEndTimeSUP != "" && ServingEndTimeSUP < Sys_time){
		checkedYn = "";
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" "+"disabled = true onclick=\"setStatus("+row_ind+",this.value)\" >"
		}else if(lateIrregularDietOrderSUP =="Y" && IrregularEndTimeSUP != "" && IrregularEndTimeSUP < Sys_time ){
		checkedYn = "";
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" "+"disabled = true onclick=\"setStatus("+row_ind+",this.value)\" >"
		}else{
			sel+="<input type=\"checkbox\" value=" +code+ " name=" + mealTypesind + " id=" + mealTypesind + " "+checkedYn+" "+"disabled = true onclick=\"setStatus("+row_ind+",this.value)\" >"
		}
	} 
	//Added Against ML-MMOH-CRF-0825 Ends Here
	newCellCBox.innerHTML = sel;
	row_ind++;
	}
	i++;
	}
}

var k=0;
function setStatus(ind,mealTypes){
	chkBox = document.getElementById(("mealType_" + ind));
	if(chkBox != null || chkBox != ""){
		if(chkBox.checked == true){
			mealTypesArray[ind]=mealTypes;
			k++;
		}else{
			mealTypesArray[ind]="";
			k++;
		}
	}
}

var mealTypeStr;

function getMealTypesSpFoodItems() {
		for (var i=0; i < mealTypesArray.length ;i++ )
		{
			if(mealTypesArray[i] == undefined){
				mealTypesArray[i] = "";
			}
		}
	mealTypeStr=mealTypesArray.join("*");
	top.returnValue = mealTypeStr;
	top.close();
}

//For Nutrint Window
var nutrientArr = new Array();
var nutrientSuppListArr = new Array();
//var nutriArray = null;
var returnVal2 = null;
var nutriArr = new Array();
var nutriFlag="N";
var countRowValue = 0;
var iCode="";
var Calori=0;
var energyUom="";
var energyUom_Desc="";//Added Against PMG2017-COMN-CRF-0012.1-US001
var servingUom_Code="";//Added Nutrient Supplement & Special food item [IN:067653]
var servingUom_Desc="";//Added Nutrient Supplement & Special food item [IN:067653]
var CaloriT=0;
async function nuitrientModelWindow(obj) {
	var k=0;
	var j=0;
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	var mealType = document.getElementById("mealClass").value;
	var dietType = document.getElementById("dietType").value;

	//ML-MMOH-CRF-0427 US3 starts
	var profileFlag=$('#profileFlag').val(); 
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	
	/*var dialogUrl1 = "../../eDS/jsp/NutrientApp.jsp?&check="+document.getElementById("nutriFlagArr").value+"&profileFlag="+profileFlag
	+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn
	+"&maximum_days_allowed="+maximum_days_allowed;*/

	var calledFrom="Nutrient";
	var dialogUrl1 = "../../eDS/jsp/NutrientSpecialFoodFrames.jsp?&calledFrom="+calledFrom+"&check="+document.getElementById("nutriFlagArr").value+"&profileFlag="+profileFlag
	+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn
	+"&maximum_days_allowed="+maximum_days_allowed
	+"&Title="+getLabel("eOT.nutriEntSupp.Label","ot_labels");
	//ML-MMOH-CRF-0427 US3 ends
	var dialogArguments = nutrientArr;
	//var dialogFeatures = "dialogHeight:25;dialogWidth:40;status:no;scroll:no";
	var dialogTop   = "65";
    var dialogHeight    = "600px" ; //30.5
    var dialogWidth = "900px" ;
    var arguments   = "" ;
    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	returnVal2 = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if (returnVal2) {
		document.getElementById("nutriFlagArr").value = "true";
		nutrientArr = returnVal2;
		var tbodyObj = document.all("Nutrient");
		while (tbodyObj.rows.length > 0) {
			tbodyObj.deleteRow(0);
		}
			//var keyList = test.keys;
		var countRow = tbodyObj.rows.length;
		var row_ind = 0;
		var selObj="";

		TCaloriT=0;
		dispRecNo=nutrientArr.length;
		for (var i = 0; i < nutrientArr.length; i++) {
			var obj = nutrientArr[i];
			if (obj != null) {
				if (obj[6] == "-1") {
					var newRow = tbodyObj.insertRow(row_ind);
					//newRow.id = countRowValue;
					var newCellitemType = newRow.insertCell(newRow.cells.length);
					var sub = "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].from' id='nutrientSupplementVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
					sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].to' id='nutrientSupplementVOs[" + (row_ind) + "].to' value='" + obj[1] + "'/>";
					sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' id='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' value='" + obj[5] + "'/>";
					sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemType' id='nutrientSupplementVOs[" + (row_ind) + "].itemType' value='" + obj[2] + "'/>";
					sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].foodItem' id='nutrientSupplementVOs[" + (row_ind) + "].foodItem' value='" + obj[3] + "'/>";
					sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].qty' id='nutrientSupplementVOs[" + (row_ind) + "].qty' value='" + obj[4] + "'/>";
					sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemSl' id='nutrientSupplementVOs[" + (row_ind) + "].itemSl' value='" + obj[6] + "'/>";
					newCellitemType.innerHTML = sub;
					var newCellDate = newRow.insertCell(newRow.cells.length);
					row_ind++;
				} else {
					var newRow = tbodyObj.insertRow(row_ind);
					var newCellDate = newRow.insertCell(newRow.cells.length);
					newCellDate.className = "Data";

					TCaloriT=parseFloat((Math.round(TCaloriT*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round((obj[12])*Math.pow(10,2))/Math.pow(10,2)));
					obj[15]=parseFloat((Math.round(TCaloriT*Math.pow(10,2))/Math.pow(10,2)));
					energyUom=obj[13];
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					if(obj[16]==undefined){
						obj[16]=obj[14];
					}
					energyUom_Desc=obj[16];										
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					
					//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
					if(obj[17]==undefined){
						obj[17]=obj[15];
					}
					servingUom_Desc=obj[15];										
					//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here
					k=k+1;
					var newRow = tbodyObj.insertRow(row_ind);
					newRow.id = countRowValue;

					var codeCell = newRow.insertCell(newRow.cells.length);
					var qtyCell = newRow.insertCell(newRow.cells.length);
					var calorieCell = newRow.insertCell(newRow.cells.length);

					var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;

					codeCell.className = "label";
					codeCell.className = classVal;
					codeCell.style.fontSize ="8pt";
					codeCell.align = "left";
					codeCell.colSpan = "3";

					qtyCell.className = "label";
					qtyCell.className = classVal;
					qtyCell.style.fontSize ="8pt";
					qtyCell.align = "left";
					qtyCell.colSpan = "3";

					calorieCell.className = "label";
					calorieCell.className = classVal;
					calorieCell.style.fontSize ="8pt";
					calorieCell.align = "left";
					calorieCell.colSpan = "3";

					nutrCalTotal1=parseFloat((Math.round(nutrCalTotal1*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(nutrientArr[j][12]*Math.pow(10,2))/Math.pow(10,2)))

					document.getElementById("nFITotalCalorie").value=parseFloat((Math.round(nutrCalTotal1*Math.pow(10,2))/Math.pow(10,2)));
					energyUom=nutrientArr[j][13];
					energyUom_Desc=nutrientArr[j][16];//Added Against PMG2017-COMN-CRF-0012.1-US001
					servingUom_Desc=nutrientArr[j][17];//Added Against Nutrient Supplement & Special food item [IN:067653]
				
					//codeCell.appendChild(document.createTextNode(nutrientArr[j][8]));
					codeCell.appendChild(document.createTextNode(nutrientArr[j][7]));
					
					//qtyCell.appendChild(document.createTextNode(nutrientArr[j][9] +" "+ nutrientArr[j][13].toLowerCase())); //Commented Against PMG2017-COMN-CRF-0012.1-US001
					//qtyCell.appendChild(document.createTextNode(nutrientArr[j][9] +" "+ nutrientArr[j][16].toLowerCase()));//Added Against PMG2017-COMN-CRF-0012.1-US001
					qtyCell.appendChild(document.createTextNode(nutrientArr[j][4] +" "+ nutrientArr[j][17].toLowerCase()));//Added Against PMG2017-COMN-CRF-0012.1-US001 & Modified Against Nutrient Supplement & Special food item [IN:067653] 
					var cal = parseFloat((Math.round(nutrientArr[j][12]*Math.pow(10,2))/Math.pow(10,2)))
					//var cal1 = cal+" "+nutrientArr[j][13].toLowerCase() //Commented Against PMG2017-COMN-CRF-0012.1-US001
					var cal1 = cal+" "+nutrientArr[j][16].toLowerCase()
					calorieCell.appendChild(document.createTextNode(cal1));

					document.getElementById("nFITotalCalorie").value=parseFloat((Math.round(TCaloriT*Math.pow(10,2))/Math.pow(10,2)));
					if(obj[6] == "0"){
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var sub = "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].from' id='nutrientSupplementVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].to' id='nutrientSupplementVOs[" + (row_ind) + "].to' value='" + obj[1] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' id='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' value='" + obj[5] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemType' id='nutrientSupplementVOs[" + (row_ind) + "].itemType' value='" + obj[2] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].foodItem' id='nutrientSupplementVOs[" + (row_ind) + "].foodItem' value='" + obj[3] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].qty' id='nutrientSupplementVOs[" + (row_ind) + "].qty' value='" + obj[4] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemSl' id='nutrientSupplementVOs[" + (row_ind) + "].itemSl' value='" + obj[6] + "'/>";
						newCellitemType.innerHTML = sub;
						nutrientSuppListArr[row_ind] = new Array();
						nutrientSuppListArr[row_ind][0] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].from").value;
						nutrientSuppListArr[row_ind][1] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].to").value;
						nutrientSuppListArr[row_ind][2] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].itemType").value;
						nutrientSuppListArr[row_ind][3] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].foodItem").value;
						nutrientSuppListArr[row_ind][4] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].qty").value;
						nutrientSuppListArr[row_ind][5] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].mealTypes").value;
						nutrientSuppListArr[row_ind][6] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].itemSl").value;
					}else if(obj[10] == "M"){
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						var sub = "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].from' id='nutrientSupplementVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].to' id='nutrientSupplementVOs[" + (row_ind) + "].to' value='" + obj[1] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' id='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' value='" + obj[5] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemType' id='nutrientSupplementVOs[" + (row_ind) + "].itemType' value='" + obj[2] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].foodItem' id='nutrientSupplementVOs[" + (row_ind) + "].foodItem' value='" + obj[3] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].qty' id='nutrientSupplementVOs[" + (row_ind) + "].qty' value='" + obj[4] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemSl' id='nutrientSupplementVOs[" + (row_ind) + "].itemSl' value='" + obj[11] + "'/>";
						newCellitemType.innerHTML = sub;

						nutrientSuppListArr[row_ind] = new Array();
						nutrientSuppListArr[row_ind][0] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].from").value;
						nutrientSuppListArr[row_ind][1] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].to").value;
						nutrientSuppListArr[row_ind][2] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].itemType").value;
						nutrientSuppListArr[row_ind][3] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].foodItem").value;
						nutrientSuppListArr[row_ind][4] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].qty").value;
						nutrientSuppListArr[row_ind][5] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].mealTypes").value;
						nutrientSuppListArr[row_ind][6] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].itemSl").value;
					}else{
						var newCellitemType = newRow.insertCell(newRow.cells.length);
						/* var sub = "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].from' id='nutrientSupplementVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].to' id='nutrientSupplementVOs[" + (row_ind) + "].to' value='" + obj[1] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' id='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' value='" + obj[2] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemType' id='nutrientSupplementVOs[" + (row_ind) + "].itemType' value='" + obj[5] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].foodItem' id='nutrientSupplementVOs[" + (row_ind) + "].foodItem' value='" + obj[7] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].qty' id='nutrientSupplementVOs[" + (row_ind) + "].qty' value='" + obj[9] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemSl' id='nutrientSupplementVOs[" + (row_ind) + "].itemSl' value='" + obj[4] + "'/>"; */ //Commented  Against Nutrient Supplement & Special food item [IN:067653]
						//Modified Against Nutrient Supplement & Special food item [IN:067653] Starts Here
						 var sub = "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].from' id='nutrientSupplementVOs[" + (row_ind) + "].from' value='" + obj[0] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].to' id='nutrientSupplementVOs[" + (row_ind) + "].to' value='" + obj[1] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' id='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' value='" + obj[5] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemType' id='nutrientSupplementVOs[" + (row_ind) + "].itemType' value='" + obj[2] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].foodItem' id='nutrientSupplementVOs[" + (row_ind) + "].foodItem' value='" + obj[3] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].qty' id='nutrientSupplementVOs[" + (row_ind) + "].qty' value='" + obj[4] + "'/>";
						sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemSl' id='nutrientSupplementVOs[" + (row_ind) + "].itemSl' value='" + obj[11] + "'/>";
						//Modified Against Nutrient Supplement & Special food item [IN:067653] Ends Here
						newCellitemType.innerHTML = sub;

						nutrientSuppListArr[row_ind] = new Array();
						nutrientSuppListArr[row_ind][0] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].from").value;
						nutrientSuppListArr[row_ind][1] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].to").value;
						nutrientSuppListArr[row_ind][2] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].itemType").value;
						nutrientSuppListArr[row_ind][3] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].foodItem").value;
						nutrientSuppListArr[row_ind][4] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].qty").value;
						nutrientSuppListArr[row_ind][5] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].mealTypes").value;
						nutrientSuppListArr[row_ind][6] = document.getElementById("nutrientSupplementVOs[" + (row_ind) + "].itemSl").value;
					}

					row_ind++;
				}
			}
			j=j+1;
		}
		
			var l=parseInt(nutrientArr.length)-1;
			for (var i = 0; i < nutrientArr.length; i++) {
				var obj = nutrientArr[i];
				var tbodyObj1 = document.all("Nutrient1");
			if(tbodyObj1.rows.length>0)
				tbodyObj1.deleteRow(0)
				var newRow1 = tbodyObj1.insertRow(0);

				if(i == l){
					if(k!=0){
						var GTotal=document.getElementById("nFITotalCalorie").value;

						var labelCel = newRow1.insertCell(newRow1.cells.length);
						var calorieCel = newRow1.insertCell(newRow1.cells.length);

						labelCel.className = "lable";
						labelCel.className = classVal;
						//labelCel.className = "Data";
						labelCel.style.fontWeight = "700";
						labelCel.style.fontSize ="8pt";
						labelCel.style.color ="#2B1B17";
						labelCel.setAttribute("border", "0px");
						labelCel.align = "left";
						labelCel.colSpan = "3";

						calorieCel.className = "lable";
						calorieCel.className = classVal;
						//calorieCel.className = "Data";
						calorieCel.style.fontWeight = "700";
						calorieCel.style.fontSize ="8pt";
						calorieCel.style.color ="#2B1B17";
						calorieCel.align = "left";
						calorieCel.colSpan = "6";
					
						var mesg = getLabel("eDS.Total.Label","DS");
						labelCel.appendChild(document.createTextNode(mesg+" :"));

						
						var gTotalVal = parseFloat((Math.round(GTotal*Math.pow(10,2))/Math.pow(10,2)))
						//var gtotalUom = gTotalVal+" "+energyUom.toLowerCase();//Commented Against PMG2017-COMN-CRF-0012.1-US001
						var gtotalUom = gTotalVal+" "+energyUom_Desc.toLowerCase();//Added Against PMG2017-COMN-CRF-0012.1-US001
						
						calorieCel.appendChild(document.createTextNode(gtotalUom));
					}else{
						document.getElementById("nFITotalCalorie").value = 0;
					}
				}
			}
		}
		calGTotalCalorie();
}

function getRowDtls() {
	window.returnValue = nutriArr;
	nutriFlag="Y";
	window.close();
}

function AddItem() {
	var tableObj = document.getElementById('listContentTable');
	var countRow = tableObj.rows.length;
	var row_ind = 1;
	countRowValue = nutriArr.length;
	var key_value = "";

		if (document.all("from").value == "") {
			var msg =getMessage("DS_FRMDATE_NOT_BLANK","DS"); //"From Date Cannot be Blank";
			key_value = msg;
			alert(key_value);
			return false;
		}
		if (document.all("itemType").value == "") {
			var msg1 =getMessage("DS_ITMTYPE_NOT_BLANK","DS");
			key_value = msg1;
			alert(key_value);
			return false;
		}
		if (document.all("foodType").value == "" || document.all("foodDesc").value == "") {
			var msg2 = getMessage("DS_FOODTYPE_NOT_BLANK","DS");// "Food Type Cannot be Blank";
			key_value = msg2;
			alert(key_value);
			return false;
		}
		if (document.all("qty").value == "") {
			var msg3 = getMessage("DS_QTY_NOT_BLANK","DS");// "Qty. Cannot be Blank";
			key_value = msg3;
			alert(key_value);
			return false;
		}

		var bol;
		if (document.all("from").value != "") {
			var locale=document.getElementById("locale").value;
			var from = document.all("from").value;
			var to = document.all("to").value;
			//var flag = isAfter(from, to, "DMY",locale);
			if(to != ""){
				var flag = compareDate(from,to);
				if (flag == 1) {
			        error = "";
			        key_value = "";
			        var mesg = getMessage("DS_TODATE_GRTR_FRMDATE","DS"); //"To Date Should be greater than from Date"
			        alert(mesg);
			        return false;
			    }
			}


			//ML-MMOH-CRF-0427 starts
			var profileFlag=$('#profileFlag').val();
			var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
			var maximum_days_allowed=$('#maximum_days_allowed').val();
			var selecteddate=$('#from').val();
			if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
			var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);

			if(!flag){
				var error="";
				var sysdate=getCurrentDate("DMH",locale);
				var maxdate=addDays(new Date(),maximum_days_allowed);
				var maxToDate=changeDate(maxdate);

				var fieldName=getLabel("Common.fromdate.label","common");
				var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
				error+=fieldName;
				error+=msgArray[1];
				error+=sysdate;
				error+=msgArray[2];
				error+=maxToDate;

	        		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				$('#from').focus();
				$('#from').select();
				return false;
			}else{
			var error="";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;

			}

			selecteddate=$('#to').val();
			flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);

			if(!flag){
				var error="";
				var sysdate=getCurrentDate("DMH",locale);
				var maxdate=addDays(new Date(),maximum_days_allowed);
				var maxToDate=changeDate(maxdate);

				var fieldName=getLabel("Common.todate.label","common");
				var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
				var msgArray=msg.split("#");
				error="";
				//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
				error+=fieldName;
				error+=msgArray[1];
				error+=sysdate;
				error+=msgArray[2];
				error+=maxToDate;

        			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
				$('#to').focus();
				$('#to').select();
				return false;
			}else{
			var error="";
			parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;

			}
			}
			//ML-MMOH-CRF-0427 ends

			/*if(flag)
			{
				alert("From date should be less than or equal to to date");
				return false;
			}*///else{
				var foodType = document.all("foodType").value;
				var mode = "KaloriForMeals";
				var paramType = "&foodType="+foodType+"&mode="+mode+"&languageId="+locale;
				var xmlDoc="" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramType,false);
				xmlHttp.send(xmlDoc);
				var retValue = localTrimString(xmlHttp.responseText);
				var getNewItemCalori = retValue.split(",");
				for(var i=0; i < getNewItemCalori.length; i++){
					iCode = getNewItemCalori[0];
					Calori = getNewItemCalori[1];
					energyUom = getNewItemCalori[2];
					energyUom_Desc = getNewItemCalori[3];//Added Against PMG2017-COMN-CRF-0012.1-US001	
				//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
					servingUom_Code = getNewItemCalori[4];
					servingUom_Desc = getNewItemCalori[5];
				//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here
				}
				NutrientRec();
				window.setTimeout(NutrientRec, 1000);
			//}
		}
}

/* function fetchRow(val) {
	document.all("from").value = nutriArr[val][0];
	document.all("to").value = nutriArr[val][1];
	document.all("itemType").value = nutriArr[val][2];
	document.all("foodDesc").value = nutriArr[val][7];
	document.all("qty").value = nutriArr[val][4];
	document.all("mealType").value = nutriArr[val][5];
	document.all("rowNo").value = val;
	document.all("foodType").value = nutriArr[val][3];
	document.getElementById("servingUomCode").value=nutriArr[val][9];
} */ //Commented Against Nutrient Supplement & Special food item [IN:067653] 

function deleteRow() {
	if (document.all("rowNo").value == "") {
		var msg = getMessage("DS_SEL_REC_TODEL","DS");//"Please Select Atleats One Record to delete";
		alert(msg);
		return false;

	}
	var tableObj = document.getElementById('listContentTable');
	while (tableObj.rows.length > 1) {
		tableObj.deleteRow(1);
	}
	if (document.all("rowNo").value != "") {
		if (nutriArr[document.all("rowNo").value][6] == "0") {
			nutriArr[document.all("rowNo").value] = null;
		} else {
			nutriArr[document.all("rowNo").value][4] = nutriArr[document.all("rowNo").value][6];
			nutriArr[document.all("rowNo").value][6] = "-1";
		}
	}
	for (var i = 0; i < nutriArr.length; i++) {
		var obj = nutriArr[i];
		if (obj != null) {
			if (obj[6] != "-1") {
				var countRow = tableObj.rows.length;
				var row_ind = 1;
				var newRow = tableObj.insertRow(row_ind);
				//newRow.id = countRowValue;
				var newCellitemType = newRow.insertCell(newRow.cells.length);
				var sub = "<A  href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>";
				newCellitemType.innerHTML = sub;
				var newCellDate = newRow.insertCell(newRow.cells.length);
				newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
				var newCellfoodType = newRow.insertCell(newRow.cells.length);
				newCellfoodType.appendChild(document.createTextNode(obj[7]));
				var newCellqty = newRow.insertCell(newRow.cells.length);
				//newCellqty.appendChild(document.createTextNode(obj[4]+" "+obj[9]+"("+obj[12]+" "+obj[13]+")")); // Commented Against PMG2017-COMN-CRF-0012.1-US001
				newCellqty.appendChild(document.createTextNode(obj[4]+" "+obj[17]+"("+obj[12]+" "+obj[16]+")"));//Added Against PMG2017-COMN-CRF-0012.1-US001 and Modified Against Nutrient Supplement & Special food item [IN:067653] 
			}
		}else{
			
		}

	}

	var displayRecSlNo=0;
	var deleteRecSlNo=0;

	document.getElementById("rowNo").value = "";
	document.all("from").value = "";
	document.all("to").value = "";
	document.all("itemType").value = "";
	document.all("foodType").value = "";
	document.all("foodDesc").value = "";
	document.all("qty").value = "";
	document.all("mealType").value = "";

}

//Calling  Method
var nutSplFoodArr = new Array();
var Diet_Code = "";
function Update(dietCat, mealClas, feedTY, dietType, feedingInstructions, dsdelivary,patientClass, encounterId, profileSL, from, to, nilFromDate, nilToDate,orderID,orOrderType,textureOfDiet,preparatoryInstructions,menu_type)//Added against ML-MMOH-CRF-0684
{//CRF-412
     	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	if(dietCat!="NBM"){//410 if starts
	clearField(false);
	$('#Full_Day_NBM_YN').prop('checked', false);
	$("#Full_Day_NBM_YN").prop('disabled',false);
	irregular_meal_flag=false;
	if (dietCat != null)
	{
		dietCat = trim(dietCat); //IN:39937
		document.getElementById("dietCategory").value = dietCat;
		fecthDietType(dietCat, ''); // MMS-QH-CRF-0190
	}
	if (mealClas != null)
		document.getElementById("mealClass").value = mealClas;
	if (feedTY != null && feedTY != "")
		document.getElementById("feedType").value = feedTY;
	if (dietType != null){
	
	  document.getElementById("dietType").value = dietType;	  
		Org_dietType=dietType;
		var obj=document.getElementById("dietType");
		obj.oldvalue = dietType;
		
		}
	if (dsdelivary != null && dsdelivary != "")
		document.getElementById("dsDeliveryInstr").value = dsdelivary;
	if (nilFromDate != null)
		document.getElementById("from").value = nilFromDate;
	if (nilToDate != null)
		document.getElementById("to").value = nilToDate;
	if (orderID != null)
		 document.getElementById("orderID").value = orderID;
	document.getElementById("isNEW").value = false;
	if(feedingInstructions != null)
		document.getElementById("feedingInstructions").value = feedingInstructions;
	if(from != null)
	{
		document.getElementById("dateFrom").value = from;
		document.getElementById("testDate").value = from;
		var obj=document.getElementById("dateFrom");
		obj.oldvalue = from;
	}
	if(to != null) {
		document.getElementById("dateTo").value = to;
		var obj=document.getElementById("dateTo");
		obj.oldvalue = to;
	}
	if(profileSL != null)
	{
		document.getElementById("profileSL").value = profileSL;
		document.getElementById("selectedProfile").value = profileSL;
	}
	//CRF-412
		/*if(textureOfDiet=="undefined" || textureOfDiet==null){
		document.getElementById("texture_of_diet").value = "";
	}*/
	if(textureOfDiet !=null) {
		document.getElementById("texture_of_diet").value = textureOfDiet;
	}
	if(preparatoryInstructions!=null){
		
		document.getElementById("prepInstr").value = preparatoryInstructions;
		
	}else{
		//document.getElementById("prepInstr").value = "";
	}
	//Added Against ML-MMOH-CRF-0684 Starts Here
	if(isMenuType=="true"){
	if(menu_type !=null && menu_type != ""){	
		document.getElementById("menu_type").value = menu_type;		
	}
	}
	//Added Against ML-MMOH-CRF-0684 Ends Here
	//CRF-412
	var patientID = document.getElementById("Patient_ID").value;
	var dateForMeanu = document.getElementById("dateForMeanu").value;
	if(dateForMeanu == "")
		dateForMeanu = document.getElementById("dateFrom").value
	var locale = document.getElementById("languageId").value;
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "nutrientsAndSplFoodItems";
	var nutriAndSplFood ="&locale="+locale+"&dateForMeanu="+dateForMeanu+"&profileSL="+profileSL+"&encounterId="+encounterId+"&patientID="+patientID+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;
	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+nutriAndSplFood;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	eval(responseText);
	
	//409 starts
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "irregularMealCode";
	var irregularMealCodeParam ="&locale="+locale+"&dateForMeanu="+dateForMeanu+"&profileSL="+profileSL+"&encounterId="+encounterId+"&patientID="+patientID+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;

	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+irregularMealCodeParam;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);

	irregular_meal_code=responseText;

	//409 ends	
	
	// 006 starts
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "checkDietTypeModified";
	var DietTypeModifiedParam ="&locale="+locale+"&dateForMeanu="+dateForMeanu+"&profileSL="+profileSL+"&encounterId="+encounterId+"&patientID="+patientID+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;
	
	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+DietTypeModifiedParam;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	
	DietTypeModified_YN=responseText;	
	//006 ends

	updateMealMenuDate();
	fecthMealTypeOptions(dietType);
	getMeals();
	//updateMealMenuDate();
	enableMandatory();
	}//410 if
	else if(dietCat=="NBM"){
		//enableDisableField();
		clearField(true);
		$('#Full_Day_NBM_YN').prop('checked', true);
		$("#Full_Day_NBM_YN").prop('disabled',true );
		if (nilFromDate != null)
			document.getElementById("from").value = nilFromDate;
		if (nilToDate != null)
			document.getElementById("to").value = nilToDate;
			document.getElementById("profileSL").value = profileSL;
			document.getElementById("selectedProfile").value = profileSL;	
			document.getElementById("dietCatImage").style.visibility = "hidden";
			document.getElementById("fromDateImage").style.visibility = "hidden";
			document.getElementById("MealClassImage").style.visibility = "hidden";
			document.getElementById("dietTypeImage").style.visibility = "hidden";
			document.getElementById("dateToImage").style.visibility = "hidden";	
			if(isMenuType=="true"){
			document.getElementById("MenuImage").style.visibility = "hidden";//CRF-0684
			}
			chkFormValChange=true;//CRF-410 19th Dec		
			
}
}
//Added against 059404
function reloadUpdate(dietCat, mealClas, feedTY, dietType, feedingInstructions, dsdelivary,patientClass, encounterId, profileSL, from, to, nilFromDate, nilToDate,textureOfDiet,preparatoryInstructions,menu_type)
{//CRF-412//CRF-684
			//Update(dietCat, mealClas, feedTY, dietType, feedingInstructions, dsdelivary,patientClass, encounterId, profileSL, from, to, nilFromDate, nilToDate,orderID,orOrderType,textureOfDiet);//CRF-412
			Update(dietCat, mealClas, feedTY, dietType, feedingInstructions, dsdelivary,patientClass, encounterId, profileSL, from, to, nilFromDate, nilToDate,'','',textureOfDiet,preparatoryInstructions,menu_type);//CRF-412 and CRF-0684
			fecthDietTypeToMealClass();
			updatedDietTypes(profileSL, encounterId);
}
//Added against 059404


var nutriSuppArry = new Array();
var spFudArry = new Array();
var attdArry = new Array();
var dietArry = new Array();
var disLikeArry = new Array();
var nutSuppArry = new Array();
var exclusionsArry = new Array();
var attdSrl = "";
function nutrinetSplFoodItems(nutriSpl,splfList,attdfList,dietTList,disLikesList,tempattdSrl,exclusionsList) {
	attROW_temp=0;//CRF-412
	JSONobj={};
	attdSrl = tempattdSrl; //IN:39937
	if(nutriSpl == ""){
		nutriSuppArry.length = 0;
	}else{
		nutriSuppArry = (localTrimString(nutriSpl)).split(",");
	}
	if(splfList == ""){
		spFudArry.length = 0;
	}else{
		spFudArry = (localTrimString(splfList)).split(",");
	}
	if(attdfList == ""){
		attdArry.length = 0;
	}else{
		attdArry = (localTrimString(attdfList)).split(",");
	}
	if(dietTList == 0){
		dietArry.length = 0;
	}else{
		dietArry = (localTrimString(dietTList)).split(",");
	}
	if(disLikesList == 0){
		disLikeArry.length=0;
	}else{
		disLikeArry = (localTrimString(disLikesList)).split(",");
	}
	if(exclusionsList == 0){
		exclusionsArry.length=0;
	}else{
		exclusionsArry = (localTrimString(exclusionsList)).split(",");
	}

	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";

	// Adding Nutrient
	if(nutriSuppArry != null && nutriSuppArry.length > 0){
		//nutrientArr = null;
		//var nutrientArr = new Array();
		supplimentArray = null;
		supplimentArray = new Array();
		var tbodyObj = document.all("Nutrient");
		while (tbodyObj.rows.length > 0) {
			tbodyObj.deleteRow(0);
		}
		var countRow = tbodyObj.rows.length;
		var row_ind = 0;
		var nutrCalTotal=0;
		var nutrCalTotal1=0;//Added Against Nutrient Supplement & Special food item [IN:067653]
		var splFITotalCalorie=0;
		var splFITotalCalorieTotal=0;
		var energyUom = null;
		for (var j=0,itr1=0;j < nutriSuppArry.length;) {
			nutrientArr[itr1] = new Array();
			nutrientArr[itr1][0] = nutriSuppArry[j];
			nutrientArr[itr1][1] = nutriSuppArry[j+1];
			nutrientArr[itr1][2] = nutriSuppArry[j+2];
			nutrientArr[itr1][3] = nutriSuppArry[j+3];
			nutrientArr[itr1][4] = nutriSuppArry[j+4];
			nutrientArr[itr1][5] = nutriSuppArry[j+5];
			nutrientArr[itr1][6] = nutriSuppArry[j+6];
			nutrientArr[itr1][7] = nutriSuppArry[j+7];
			nutrientArr[itr1][8] = nutriSuppArry[j+8];
			nutrientArr[itr1][9] = nutriSuppArry[j+9];
			nutrientArr[itr1][10] = nutriSuppArry[j+10];
			nutrientArr[itr1][11] = nutriSuppArry[j+11];
			//nutrientArr[itr1][12] = parseFloat(nutriSuppArry[j+9])*parseFloat((Math.round((nutriSuppArry[j+12])*Math.pow(10,2))/Math.pow(10,2)));//Commented Against Nutrient Supplement & Special food item [IN:067653] 
			nutrientArr[itr1][12] = parseFloat(nutriSuppArry[j+4])*parseFloat((Math.round((nutriSuppArry[j+12])*Math.pow(10,2))/Math.pow(10,2)));//Added Against Nutrient Supplement & Special food item [IN:067653] 
			nutrientArr[itr1][13] = nutriSuppArry[j+13];
			nutrientArr[itr1][14] = nutriSuppArry[j+14];//Added Against PMG2017-COMN-CRF-0012.1-US001
			nutrientArr[itr1][15] = nutriSuppArry[j+15];//Added Against Nutrient Supplement & Special food item [IN:067653]
			
			var newRow = tbodyObj.insertRow(row_ind);
			newRow.id = countRowValue;			
			var codeCell = newRow.insertCell(newRow.cells.length);
			var qtyCell = newRow.insertCell(newRow.cells.length);
			var calorieCell = newRow.insertCell(newRow.cells.length);

			var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;

			codeCell.className = "label";
			codeCell.className = classVal;
			codeCell.style.fontSize ="8pt";
			codeCell.align = "left";
			codeCell.colSpan = "3";

			qtyCell.className = "label";
			qtyCell.className = classVal;
			qtyCell.style.fontSize ="8pt";
			qtyCell.align = "left";
			qtyCell.colSpan = "3";

			calorieCell.className = "label";
			calorieCell.className = classVal;
			calorieCell.style.fontSize ="8pt";
			calorieCell.align = "left";
			calorieCell.colSpan = "3";

			nutrCalTotal1=parseFloat((Math.round(nutrCalTotal1*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round((nutrientArr[itr1][12])*Math.pow(10,2))/Math.pow(10,2)))
			

			/* var nutrCalTotal12=parseFloat((Math.round(nutrCalTotal1*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round((nutrientArr[itr1][12])*Math.pow(10,2))/Math.pow(10,2)))
			var nutrVal = (Math.round(nutrCalTotal12*Math.pow(10,2))/Math.pow(10,2)); */ //Commented Against Nutrient Supplement & Special food item [IN:067653]
			
			document.getElementById("nFITotalCalorie").value=parseFloat((Math.round(nutrCalTotal1*Math.pow(10,2))/Math.pow(10,2)));
			energyUom=nutrientArr[itr1][13];
			energyUom_Desc=nutrientArr[itr1][14];//Added Against PMG2017-COMN-CRF-0012.1-US001
			servingUom_Desc=nutrientArr[itr1][15];//Added Against Nutrient Supplement & Special food item [IN:067653]
			
			//Commented Against Nutrient Supplement & Special food item [IN:067653] Starts Here
			/* codeCell.appendChild(document.createTextNode(nutrientArr[itr1][8]));
			qtyCell.appendChild(document.createTextNode(nutrientArr[itr1][9] +" "+ nutrientArr[itr1][11].toLowerCase()));
			nutrieCalori = parseFloat((Math.round(nutrientArr[itr1][12]*Math.pow(10,2))/Math.pow(10,2)));
			
			nutrCalTotal1 = nutrieCalori; */ 
			//Commented Against Nutrient Supplement & Special food item [IN:067653] Ends Here
			
			//Modified Against Nutrient Supplement & Special food item [IN:067653] Starts Here
			codeCell.appendChild(document.createTextNode(nutrientArr[itr1][7]));
			qtyCell.appendChild(document.createTextNode(nutrientArr[itr1][4] +" "+ nutrientArr[itr1][15].toLowerCase()));
			//Modified Against Nutrient Supplement & Special food item [IN:067653] Ends Here
			
			//var nutrieCalorie = nutrientArr[itr1][9]+" "+nutrientArr[itr1][13].toLowerCase();//Commented Against PMG2017-COMN-CRF-0012.1-US001
			//var nutrieCalorie = nutrientArr[itr1][9]+" "+nutrientArr[itr1][14].toLowerCase();//Added Against PMG2017-COMN-CRF-0012.1-US001 & Commented Against Nutrient Supplement & Special food item [IN:067653]
			var nutrieCalorie = nutrientArr[itr1][4]+" "+nutrientArr[itr1][14].toLowerCase();//Added Against Nutrient Supplement & Special food item [IN:067653]
			calorieCell.appendChild(document.createTextNode(nutrieCalorie));
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var sub = "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].from' id='nutrientSupplementVOs[" + (row_ind) + "].from' value='" + nutrientArr[itr1][0] + "'/>";
			sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].to' id='nutrientSupplementVOs[" + (row_ind) + "].to' value='" + nutrientArr[itr1][1] + "'/>";
			sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' id='nutrientSupplementVOs[" + (row_ind) + "].mealTypes' value='" + nutrientArr[itr1][5] + "'/>";
			sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemType' id='nutrientSupplementVOs[" + (row_ind) + "].itemType' value='" + nutrientArr[itr1][2] + "'/>";
			sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].foodItem' id='nutrientSupplementVOs[" + (row_ind) + "].foodItem' value='" + nutrientArr[itr1][3] + "'/>";
			sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].qty' id='nutrientSupplementVOs[" + (row_ind) + "].qty' value='" + nutrientArr[itr1][4] + "'/>";
			sub += "<input type='hidden' name='nutrientSupplementVOs[" + (row_ind) + "].itemSl' id='nutrientSupplementVOs[" + (row_ind) + "].itemSl' value='" + nutrientArr[itr1][6] + "'/>";

			newCellitemType.innerHTML = sub;  
			row_ind++;
			//j = j+14;//Commented Against PMG2017-COMN-CRF-0012.1-US001
			j = j+16;//Added Against PMG2017-COMN-CRF-0012.1-US001 and Modified Nutrient Supplement & Special food item [IN:067653]
			itr1++;
		}

		var tbodyObj1 = document.all("Nutrient1");
		// Start 65590
		while (tbodyObj1.rows.length > 0) {
			tbodyObj1.deleteRow(0);
		}
		// End 65590
		if(nutrCalTotal1 !=0 ){

		var newRow1 = tbodyObj1.insertRow(0);
		var labelCel = newRow1.insertCell(newRow1.cells.length);
		var calorieCel = newRow1.insertCell(newRow1.cells.length);

		labelCel.className = "lable";
		labelCel.className = classVal;
		labelCel.style.fontWeight = "700";
		labelCel.style.fontSize ="8pt";
		labelCel.style.color ="#2B1B17";
		labelCel.setAttribute("border", "0px");
		labelCel.align = "left";
		labelCel.colSpan = "3";

		calorieCel.className = "lable";
		calorieCel.className = classVal;
		calorieCel.style.fontWeight = "700";
		calorieCel.style.fontSize ="8pt";
		calorieCel.style.color ="#2B1B17";
		calorieCel.align = "left";
		calorieCel.colSpan = "6";

		var msg1 = getLabel("eDS.Total.Label","DS");
		labelCel.appendChild(document.createTextNode(msg1+" :"));
		var nutrCalTotal1 = parseFloat((Math.round(nutrCalTotal1*Math.pow(10,2))/Math.pow(10,2)))
		//var nutrCalTotal2 = nutrCalTotal1+" "+energyUom.toLowerCase()//Commented Against PMG2017-COMN-CRF-0012.1-US001
		var nutrCalTotal2 = nutrCalTotal1+" "+energyUom_Desc.toLowerCase()//Added Against PMG2017-COMN-CRF-0012.1-US001
		calorieCel.appendChild(document.createTextNode(nutrCalTotal2));
	}
}
	// Adding the Spl Food items
	if(spFudArry != null && spFudArry.length > 0){
		var tbodysup = document.all("FoodItems");
		while (tbodysup.rows.length > 0) {
			tbodysup.deleteRow(0);
		}
		var energyUom = null;
		//var energyUom_Desc = null;//Added Against PMG2017-COMN-CRF-0012.1-US001
		var splFITotalCalorieTotal=0;
		row_ind = 0;
		for (var k=0,iter=0; k < spFudArry.length;) {
			//supplimentArray[k] = new Array();
			supplimentArray[iter] = [];
			supplimentArray[iter][0] = spFudArry[k];
			supplimentArray[iter][1] = spFudArry[k+1];
			supplimentArray[iter][2] = spFudArry[k+4];
			supplimentArray[iter][3] = spFudArry[k+6];
			supplimentArray[iter][4] = spFudArry[k+8];
			supplimentArray[iter][6] = spFudArry[k+3];
			supplimentArray[iter][7] = spFudArry[k+7];
			supplimentArray[iter][8] = spFudArry[k+5];
			supplimentArray[iter][9] = spFudArry[k+10];
			supplimentArray[iter][12] = parseFloat(spFudArry[k+8])*parseFloat((Math.round((spFudArry[k+11])*Math.pow(10,2))/Math.pow(10,2)));
			supplimentArray[iter][14] = spFudArry[k+12];
			supplimentArray[iter][13] = spFudArry[k+12];
			supplimentArray[iter][16] = spFudArry[k+3];
			
			supplimentArray[iter][17] = spFudArry[k+2];
			splFITotalCalorieTotal=parseFloat((Math.round(splFITotalCalorieTotal*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(supplimentArray[iter][12]*Math.pow(10,2))/Math.pow(10,2)));
			document.getElementById("splFITotalCalorie").value=parseFloat((Math.round(splFITotalCalorieTotal*Math.pow(10,2))/Math.pow(10,2)));  
			energyUom=supplimentArray[iter][14];

			supplimentArray[iter][19] = spFudArry[k+13];
			supplimentArray[iter][18] = spFudArry[k+14];
			supplimentArray[iter][20] = spFudArry[k+15];
			supplimentArray[iter][21] = spFudArry[k+17];//Added Against PMG2017-COMN-CRF-0012.1-US001
			energyUom_Desc=supplimentArray[iter][21];//Added Against PMG2017-COMN-CRF-0012.1-US001

			//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
			supplimentArray[iter][22] = spFudArry[k+18];
			servingUom_Desc=supplimentArray[iter][22];
			//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here
			var newRow12 = tbodysup.insertRow(row_ind);

			var codeCel2 = newRow12.insertCell(newRow12.cells.length);
			var qtyCel2 = newRow12.insertCell(newRow12.cells.length);
			var calorieCel2 = newRow12.insertCell(newRow12.cells.length);

			var classVal = (row_ind % 2 == 0) ? qryEven : qryOdd;

			codeCel2.className = "label";
			codeCel2.className = classVal;
			codeCel2.style.fontSize ="8pt";
			codeCel2.align = "left";
			codeCel2.colSpan = "3";

			qtyCel2.className = "label";
			qtyCel2.className = classVal;
			qtyCel2.style.fontSize ="8pt";
			qtyCel2.align = "left";
			qtyCel2.colSpan = "3";

			calorieCel2.className = "label";
			calorieCel2.className = classVal;
			calorieCel2.style.fontSize ="8pt";
			calorieCel2.align = "left";
			calorieCel2.colSpan = "3";

			codeCel2.appendChild(document.createTextNode(supplimentArray[iter][7]));
			qtyCel2.appendChild(document.createTextNode(supplimentArray[iter][4] +" "+ supplimentArray[iter][22].toLowerCase()));//Modified Against Nutrient Supplement & Special food item [IN:067653]
			var supCal = parseFloat((Math.round((supplimentArray[iter][12])*Math.pow(10,2))/Math.pow(10,2)))

			//var supCalVal = supCal+" "+supplimentArray[iter][14].toLowerCase();//Commented Against PMG2017-COMN-CRF-0012.1-US001
			var supCalVal = supCal+" "+supplimentArray[iter][21].toLowerCase();//Added Against PMG2017-COMN-CRF-0012.1-US001
			calorieCel2.appendChild(document.createTextNode(supCalVal));

			var newCellitemType = newRow12.insertCell(newRow12.cells.length);
			var sub = "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].from' id='specialFooditemsVOs[" + (row_ind) + "].from' value='" + supplimentArray[iter][0] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].frequency' id='specialFooditemsVOs[" + (row_ind) + "].frequency' value='" + supplimentArray[iter][1] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].period' id='specialFooditemsVOs[" + (row_ind) + "].period' value='" + supplimentArray[iter][5] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemType' id='specialFooditemsVOs[" + (row_ind) + "].itemType' value='" + supplimentArray[iter][2] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].foodItem' id='specialFooditemsVOs[" + (row_ind) + "].foodItem' value='" + supplimentArray[iter][3] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].qty' id='specialFooditemsVOs[" + (row_ind) + "].qty' value='" + supplimentArray[iter][4] + "'/>";
			sub += "<input type='hidden' name='specialFooditemsVOs[" + (row_ind) + "].itemSl' id='specialFooditemsVOs[" + (row_ind) + "].itemSl' value='" + supplimentArray[iter][6] + "'/>";
			newCellitemType.innerHTML = sub;
			row_ind++;
			//k = k + 17;//Commented Against PMG2017-COMN-CRF-0012.1-US001
			k = k + 19;//Modified Against Nutrient Supplement & Special food item [IN:067653]
			iter++;
		}
		var tbodyObj3 = document.all("FoodItems1");
		while (tbodyObj3.rows.length > 0) {
			tbodyObj3.deleteRow(0);
		}
		if(splFITotalCalorieTotal != 0){
		var newRow3 = tbodyObj3.insertRow(0);
		var labelCel13 = newRow3.insertCell(newRow3.cells.length);
		var calorieCel13 = newRow3.insertCell(newRow3.cells.length);

		labelCel13.className = "lable";
		labelCel13.className = classVal;
		labelCel13.style.fontWeight = "700";
		labelCel13.style.fontSize ="8pt";
		labelCel13.style.color ="#2B1B17";
		labelCel13.setAttribute("border", "0px");
		labelCel13.align = "left";
		labelCel13.colSpan = "3";

		calorieCel13.className = "lable";
		calorieCel13.className = classVal;
		calorieCel13.style.fontWeight = "700";
		calorieCel13.style.fontSize ="8pt";
		calorieCel13.style.color ="#2B1B17";
		calorieCel13.align = "left";
		calorieCel13.colSpan = "6";

		var msg = getLabel("eDS.Total.Label","DS");
		labelCel13.appendChild(document.createTextNode(msg+" :"));
		var splFITotalCalorieTotal = parseFloat((Math.round(splFITotalCalorieTotal*Math.pow(10,2))/Math.pow(10,2)));
		//var splFITotalCalorieTotal1 = splFITotalCalorieTotal+" "+energyUom.toLowerCase();//Commented Against PMG2017-COMN-CRF-0012.1-US001
		var splFITotalCalorieTotal1 = splFITotalCalorieTotal+" "+energyUom_Desc.toLowerCase();//Added Against PMG2017-COMN-CRF-0012.1-US001
		calorieCel13.appendChild(document.createTextNode(splFITotalCalorieTotal1));
		}
		calGTotalCalorie();
	}

	// Adding Attendant
		var tbodyAttendent = document.getElementById("attendentListTable");
		while (tbodyAttendent.rows.length > 1) {
			tbodyAttendent.deleteRow(1);
		}
		if(attdArry != null && attdArry.length > 0){
		var row_ind = 0;
		attdietList = new Array();
		attROW = 0;
		//CRF-406		
		var Attendent_Label_Name=$('#Attendent_Label_Name').val();
		//var removeAttendentLabel="Remove "+Attendent_Label_Name;
		var removeAttendentLabel=getLabel("eDS.removeAttendentPCT.Label","DS");
		removeAttendentLabel=removeAttendentLabel.replace("#",Attendent_Label_Name);
		//CRF-406
		for (var l=0; l < attdArry.length;) {		
			var newRow = tbodyAttendent.insertRow(1);
			newRow.id = l;
			var newCellDate = newRow.insertCell(newRow.cells.length);
			newCellDate.appendChild(document.createTextNode((attdArry[l+5] + "-" + attdArry[l+6])));
			var newCellqty = newRow.insertCell(newRow.cells.length);
			newCellqty.nowrap = true;
			newCellqty.appendChild(document.createTextNode(attdArry[l+4]));
			var newCellfoodType = newRow.insertCell(newRow.cells.length);
			newCellfoodType.appendChild(document.createTextNode(attdArry[l+2]));
			var newCell = newRow.insertCell(newRow.cells.length);
			//ML-MMOH-CRF-412		
			if(attROW_temp==attROW){
			var max_count=$('#No_Of_Attendant').val();
			getAttendantCount(attdArry[l+5],attdArry[l+6],"onload",max_count);
			}
			//ML-MMOH-CRF-412
			var sub = "";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].formDate' id='attendentDietProfilList[" + (l) + "].formDate' value='" + attdArry[l+5] + "'/>";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].toDate' id='attendentDietProfilList[" + (l) + "].toDate' value='" + attdArry[l+6] + "'/>";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].dsDietType' id='attendentDietProfilList[" + (l) + "].dsDietType' value='" + attdArry[l+1] + "'/>";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].mealClass' id='attendentDietProfilList[" + (l) + "].mealClass' value='" + attdArry[l+3] + "'/>";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].profileSL' id='attendentDietProfilList[" + (l) + "].profileSL' value='" + attdArry[l+8] + "'/>";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].deleteSL' id='attendentDietProfilList[" + (l) + "].deleteSL' value='99'/>";
			sub += "<input type='hidden' name='attendentDietProfilList[" + (l) + "].attdSL' id='attendentDietProfilList[" + (l) + "].attdSL' value='" + attdArry[l+0] + "'/>"; //IN::39937
			newCell.innerHTML = sub;
			var removeatt = newRow.insertCell(newRow.cells.length);
			var att = "";
			removeatt.className = "data";
			//CRF-406
			//att += "<a href='#'  onclick=\"return removeAttendent('" + l + "');\"><br> REMOVE ATTENDENT</a>";
			att += "<a href='#'  onclick=\"return removeAttendent('" + l + "');\"><br> "+removeAttendentLabel+"</a>";
			//CRF-406
			removeatt.innerHTML = att;

			//IN:39937 - start - new
			attdietList[attROW] = new Array();
			attdietList[attROW][0] = attdArry[l+5];
			attdietList[attROW][1] = attdArry[l+6];

			attdietList[attROW][2] = attdArry[l+1];
			attdietList[attROW][3] = attdArry[l+3];
			attdietList[attROW][4] = '0';
			attdietList[attROW][5] = '99';
			attdietList[attROW][6] = attdArry[l+0];
			
			attROW++;
			attROW_temp++;//ML-MMOH-CRF-412
			var isMACNBM = document.getElementById("isMACNBM").value;
			if(isMACNBM)	//Added Against ML-MMOH-SCF-1828
			l = l+11;	
			else
			l = l+10;
		}
	}

	// Adding MealTypes for dietTypes
	if(dietArry != null && dietArry.length > 0){
		var obj = document.getElementsByName("mealTypesforDietTypes");
		var mealObj = document.getElementsByName("dietTypesForMeals");
			for (var i = 0; i < obj.length;i++) {
				for(var d = 0; d <dietArry.length-1; d= d+2){
				if (trim(obj[i].value) == trim(dietArry[d+1])) {
					mealObj[i].value = trim(dietArry[d]);
				}
			}
		}
	}

	// adding the Food Dislikes
	if(disLikeArry != null && disLikeArry.length > 0){
		var tbodysup = document.all("DislikesFoodItems");
		while (tbodysup.rows.length > 0) {
			tbodysup.deleteRow(0);
		}

		var countRow = tbodysup.rows.length;
		var row_ind = 0;
		for (var m=0; m < disLikeArry.length;) {
			foodDislikeList[m] = new Array();
			foodDislikeList[m][0] = disLikeArry[m];
			foodDislikeList[m][1] = disLikeArry[m+1];
			foodDislikeList[m][2] = "1";
			var newRow = tbodysup.insertRow(row_ind);
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var sub = "";
			sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemCode' id='foodDislikesList[" + (row_ind) + "].itemCode' value='" + foodDislikeList[m][0] + "'/>";
			sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemDesc' id='foodDislikesList[" + (row_ind) + "].itemDesc' value='" + foodDislikeList[m][1] + "'/>";
			sub += "<input type='hidden' name='foodDislikesList[" + (row_ind) + "].itemStatus' id='foodDislikesList[" + (row_ind) + "].itemStatus' value='" + foodDislikeList[m][2] + "'/>";
			newCellitemType.innerHTML = sub;
			var newCellDate = newRow.insertCell(newRow.cells.length);
			newCellDate.className = "Data";
			newCellDate.appendChild(document.createTextNode(foodDislikeList[m][1]));
			m = m+2;
		}
	}
	// adding the Meal Exclusions
	if(exclusionsArry != null && exclusionsArry.length > 0){
		var tbody_exclusions = document.all("exclusions");
		while (tbody_exclusions.rows.length > 0) {
			tbody_exclusions.deleteRow(0);
		}
		var countRow = tbody_exclusions.rows.length;
		var row_ind = 0;
		for (var m=0,i=0; m < exclusionsArry.length;i++) {
			//excludedMeals[i]= {"excludedDate":exclusionsArry[m],"mealType":exclusionsArry[m+1]};
			var date=$.trim(exclusionsArry[m]);
			var mealTypeCode=$.trim(exclusionsArry[m+2]);
			var mealTypeDesc=localTrimString(exclusionsArry[m+1]);
			if(excludedMeals[date]==null) {
				excludedMeals[date]={};
				//if(excludedMeals[date].indexOf(mealTypeCode)==-1) excludedMeals[date].push(mealTypeCode);
				excludedMeals[date][mealTypeCode]="Y";
			}
			else {
				//if(excludedMeals[date].indexOf(mealTypeCode)==-1) excludedMeals[date].push(mealTypeCode);
				excludedMeals[date][mealTypeCode]="Y";
			}
			var newRow = tbody_exclusions.insertRow(row_ind);
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var newCellDate = newRow.insertCell(newRow.cells.length);
			newCellDate.className = "Data";
			newCellDate.appendChild(document.createTextNode(date));
			var newCellMealType = newRow.insertCell(newRow.cells.length);
			newCellMealType.appendChild(document.createTextNode(mealTypeDesc));
			m = m+3;
		}
	}
}
var arrVal = new Array();
function fecthMealContents()
{
	 //CRF-0684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	var encounterId=document.getElementById("encounterId").value;
	var facility = document.getElementById("addedFacilityId").value;
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "dietOrders";
	var paramVal ="&encounterId="+encounterId+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;
	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+paramVal;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var retVal=localTrimString(xmlHttp.responseText);
	var arrVal = retVal.split(",");	
	var row_ind = 1;
	var servingDate = $('#servingDate').val();
	var tableObj3 = document.getElementById("result_Id");
	var recordToUpdate = -1;

	//MMOH-CRF-427
	var profileFlag=document.getElementById("profileFlag").value;
	var restrict_date_inpatients_yn=document.getElementById("restrict_date_inpatients_yn").value;
	var maximum_days_allowed=document.getElementById("maximum_days_allowed").value;
	var locale=document.getElementById("language_Id").value;
	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){

	var newtodate=addDays(new Date(),maximum_days_allowed);
	var date1=newtodate.getDate();
	var month=newtodate.getMonth();
	var year=newtodate.getFullYear();
	month+=1;
	if(date1<=9){
			date1="0"+""+date1;
		    }
	if(month<=9){
			month="0"+""+month;
		    }
	//var futDate=date.getDate() + "/" + (date.getMonth()+1) + "/" + date.getFullYear();
	var futDate=date1 + "/" + month + "/" + year;
	futDate = convertDate(futDate,'DMY','en',locale);
	document.getElementById("dateTo").value = futDate;
	}
	//MMOH-CRF-427

	while (tableObj3.rows.length > 1)
		tableObj3.deleteRow(1);
	if(arrVal != null)
	{
		recordToUpdate = toLoadDetails(arrVal);
		
		if(recordToUpdate >= 0)
		{
			var tempdietCategory=trim(arrVal[recordToUpdate+0]);//CRF-410
			 if(isMenuType == "true"){ //CRF-0684
				Update(trim(arrVal[recordToUpdate+0]), trim(arrVal[recordToUpdate+1]), trim(arrVal[recordToUpdate+2]), trim(arrVal[recordToUpdate+3]), trim(arrVal[recordToUpdate+4]), trim(arrVal[recordToUpdate+5]), trim(arrVal[recordToUpdate+6]), trim(arrVal[recordToUpdate+7]), trim(arrVal[recordToUpdate+8]), trim(arrVal[recordToUpdate+9]), trim(arrVal[recordToUpdate+10]), trim(arrVal[recordToUpdate+14]), trim(arrVal[recordToUpdate+15]),'','',trim(arrVal[recordToUpdate+24]),trim(arrVal[recordToUpdate+18]),trim(arrVal[recordToUpdate+25]));//CRF-412  and 60675
				fecthDietTypeToMealClass();
	            		updatedDietTypes(trim(arrVal[recordToUpdate+8]), encounterId);
			 }
			 else{
				Update(trim(arrVal[recordToUpdate+0]), trim(arrVal[recordToUpdate+1]), trim(arrVal[recordToUpdate+2]), trim(arrVal[recordToUpdate+3]), trim(arrVal[recordToUpdate+4]), trim(arrVal[recordToUpdate+5]), trim(arrVal[recordToUpdate+6]), trim(arrVal[recordToUpdate+7]), trim(arrVal[recordToUpdate+8]), trim(arrVal[recordToUpdate+9]), trim(arrVal[recordToUpdate+10]), trim(arrVal[recordToUpdate+14]), trim(arrVal[recordToUpdate+15]),'','',trim(arrVal[recordToUpdate+24]),trim(arrVal[recordToUpdate+18])); 
				fecthDietTypeToMealClass();
            			updatedDietTypes(trim(arrVal[recordToUpdate+8]), encounterId);				 
			 }
		}
		else
		{
			document.getElementById("testDate").value = '01/01/1900';
			//document.getElementById("dateForMeanu").value = servingDate;
			document.getElementById("dateForMeanu").value = convertDate(servingDate,'DMY','en',locale);
			//futDate = convertDate(servingDate,'DMY','en',locale);
			//15-Dec CRF-410
			clearField(false);
			
			$('#Full_Day_NBM_YN').prop('checked', false);
			$("#Full_Day_NBM_YN").prop('disabled',false);
			enableMandatory();
			//15-Dec CRF-410
			chkFormValChange=false;//18dec
		}
		chkFormValChange=false;//CRF-410 19th Dec
		checkStatus("A~F",document.all("status"));
		document.getElementById("status").value="A~F";
	}
}

function textAreaLimit(field, maxlen) {
	if (field.value.length > maxlen + 1){
		var strMsg = getMessage("DS_MAXLEN_CHARS","DS");
		var arrMsg = strMsg.split("#");
		alert(arrMsg[0] + maxlen + arrMsg[1]);
	}
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}

function getFoodLookup(obj){
	var val = document.getElementById("foodDesc").value ;
	if( val !="")
		showLookupForItemType(obj);
	else
		document.getElementById("foodType").value="";
}

function getFoodLookup_mealMenuItems(obj){
	var val = document.getElementById("foodDesc").value ;
	if( val !="")
		showLookup_mealMenuItems(obj);
	else
		document.getElementById("foodType").value="";
}

//Modified Against KDAH-CRF-0352 US4 for serve Starts Here
function addNewItem()
{
	if(document.getElementById("getName").innerText=="")
	{
		//getServerMessage("com.iba.ehis.selecttheMenu");
		alert(getMessage("DS_SEL_MENU","DS")); //"Select the Menu"
		return false;
	}
	if(document.getElementById("ItemS").value=="")
	{
		//getServerMessage("com.iba.ehis.entertheFoodItem");
		alert(getMessage("DS_ENT_FOODITM","DS"));  //"Enter the Food Item"
		return false;
	}
	if(document.getElementById("Qty").value=="")
	{
		//getServerMessage("com.iba.ehis.entertheQuantity");
		alert(getMessage("DS_ENT_QTY","DS")); //"Enter the Quantity"
		return false;
	}
	var tableObj = null;
	var i = 1;
	var found_flag = false;
	if(document.getElementById("getName").innerText!="")
	{
//	count;
	var caode = document.getElementById("getName").innerText;
	tableObj = document.getElementById(caode);
	var check = document.all("foodItem"+caode);
	if(check)
	{
		if(check.length)
		{
		for(var i=0; i<check.length;i++)
		{
			if(document.getElementById("foodType").value==check[i].value)
			{
				//getServerMessage("com.iba.ehis.ds.duplicateRecord");
				alert(getMessage("DS_DUP_RECORD","DS")); //"Duplicate Record");
				return false;
			}
		}
		}
		else
		{
			if(document.getElementById("foodType").value==check.value)
			{
				//getServerMessage("com.iba.ehis.ds.duplicateRecord");
				alert(dwrMessage);
				return false;
			}
		}
	}
	var fcode=document.getElementById("foodType").value;
	var locale=document.getElementById("language_Id").value;

	if(locale != "" && fcode != "")
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=getKaloriForItem&locale="+locale+"&foodItemCode="+fcode;
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var retValArr=retVal.split("##");
		var iCode="";
		var Calori=0;
		var energyUomUpper="";
		var energyUom="";
		var servingUomCode = ""; // AAKH-CRF-0065
		//Added Against ICN-#65555 - CRF-0352 Starts here
		var energyUomUpperDesc="";
		var energyUomdesc="";
		var servingUomCodeDesc="";
		//Added Against ICN-#65555 - CRF-0352 Ends here

		iCode=retValArr[0];
		Calori=trimString(retValArr[1]);
		energyUomUpper=retValArr[2];
		servingUomCode = retValArr[4]; // AAKH-CRF-0065
		document.getElementById("itemType").value=retValArr[3];
		//Added Against ICN-#65555 - CRF-0352 Starts here
		 energyUomUpperDesc=retValArr[6];
		 servingUomCodeDesc=retValArr[5];
		//Added Against ICN-#65555 - CRF-0352 Ends here

		 if(energyUomUpper != "")
		 	energyUom = energyUomUpper.toLowerCase();
			
		 //Added Against ICN-#65555 - CRF-0352 Starts here
		 if(energyUomUpperDesc != "")
		 	energyUomdesc = energyUomUpperDesc.toLowerCase();
		//Added Against ICN-#65555 - CRF-0352 Ends here

			var selObj = "";
			var row_ind = 1;
			var newRow = tableObj.insertRow(1); // AAKH-CRF-0065		
			
			var object = document.getElementById("mealTypesforDietTypes").value.split(",");
			var cd=caode.split("-");
				cd=cd[0];
			var j=0;
			for(var i=0; i < object.length;i++)
			{
			if(object[i].replace(" ","")==cd)
			{
					j=i;
					break;
				}
			}
			
			
				//====== updating subtotal   ====
			var iSize=0;			
			iSize=document.getElementById("textlen").value;
			flag=false;
			var sd=null;
			var obj=document.getElementById("itemQty"+count);
			var ward_checkbox_name = newRow.insertCell(newRow.cells.length);

			var updatedMealTypeCnt = parseInt($('#tabSize'+j).val());
		//Added newly against CRF-352 starts here
		sd  = "<table class='ALLTABLESDATA'  width='90%' border='0' cellpadding='2' cellspacing='0' align='center' bordercolor='#9999FF'>";	
		sd  += "<tr>";
		sd  += "<td class='widthSmallpx' align='center' >";
		//Added newly against CRF-352 ends here
		sd +="<input type='checkbox' name='check"+caode+"' id='check"+caode+"' checked='true' id='serveChkUnchk"+j+updatedMealTypeCnt+"' onclick=\"updateCalori("+iSize+","+j+",false,"+Calori+",this,'chk');return changeIT('"+count+"',this)\" >"
		//Added newly against CRF-352 starts here
		sd  += "</td> ";
		sd  += "</tr> ";
		//Added newly against CRF-352 ends here
	
		sd +="<input type='hidden' name='reviewType"+count+"' id='reviewType"+count+"' value='F' >";
		sd +="<input type='hidden' name='mealType"+count+"' id='mealType"+count+"' value='"+caode.split("-")[0]+"' />";
		sd +="<input type='hidden' name='itemType"+count+"' id='itemType"+count+"' value='"+document.getElementById("itemType").value+"' />";
		sd +="<input type='hidden' name='itemCode"+count+"' id='itemCode"+count+"' value='"+fcode+"' />";
		// AAKH-CRF-0065 start
		sd +="<input type='hidden' name='foodItemDesc"+count+"' id='foodItemDesc"+count+"' value='"+document.getElementById('foodDesc').value+"' />";
		sd +="<input type='hidden' name='menuCode"+count+"' id='menuCode"+count+"' value='"+document.getElementById(caode.split("-")[0]).value+"' />";
		sd +="<input type='hidden' name='servingCodeUom"+count+"' id='servingCodeUom"+count+"' value='"+servingUomCode+"' />";
		//Added against ICN-#65555 - CRF-0352
		sd +="<input type='hidden' name='servingCodeUomDesc"+count+"' id='servingCodeUomDesc"+count+"' value='"+servingUomCodeDesc+"' />";
		sd +="<input type='hidden' name='IntQty"+count+"' id='IntQty"+count+"' value='"+document.getElementById("Qty").value+"' />";
		
		sd +="<input type='hidden' name='calorificContPerUom"+count+"' id='calorificContPerUom"+count+"' value='"+Calori+"' />";
		sd +="<input type='hidden' name='mealTypeDesc"+count+"' id='mealTypeDesc"+count+"' value='"+caode.split("-")[1]+"' />";
		sd +="<div id='div"+caode.split("-")[0]+"_"+fcode+"'></div>";
		// AAKH-CRF-0065 end



			$('#tabSize'+j).val(updatedMealTypeCnt + 1);
			 var object = document.getElementById("mealTypesforDietTypes").value.split(",");
			for(var i=0; i < object.length;i++)
			{
				var mealTypeCode=object[i].replace(" ","");
				var dietTypeCode=document.getElementById("dietTypesForMeals").value.split(",")[i];
				if(caode.split("-")[0]==mealTypeCode)
					sd +="<input type='hidden' name='dietType"+count+"' id='dietType"+count+"' value='"+dietTypeCode+"' />";
			}
			 sd +="<input type='hidden' name='mealmenuSL"+count+"' id='mealmenuSL"+count+"' value='0' />"
			 sd +="<input type='hidden' name='methodFlag"+count+"' id='methodFlag"+count+"' value='5' />"
			 sd +="<input type='hidden' name='Qty"+count+"' id='Qty"+count+"' value='' />"
			 var element = document.createElement("input");
		     element.setAttribute("type", "hidden");
		     element.setAttribute("value", fcode);
		     element.setAttribute("name", "foodItem"+caode);
		     element.setAttribute("id", "foodItem"+caode);
		     document.body.appendChild(element);

		     ward_checkbox_name.innerHTML = sd;
		sd += "</table> ";//Added newly against CRF-352	 
		var newCellDesc = newRow.insertCell(newRow.cells.length);			
		if (object)
		{
			for (var i = 0; i < object.length; i++)
			{
					var obj = object[i];
				if (obj != null)
				{
					if (obj[2] != "-1")
					{
						if(obj[1] == document.getElementById("ItemS").value)
						  newCellDesc.style.color="red";
						}
					}
				}
			}
			newCellDesc.className="label";
			var foodDesc = "<div id='div"+caode.split("-")[0]+"_"+fcode+"'>"+document.getElementById('foodDesc').value+"</div>";
			newCellDesc.innerHTML = foodDesc;
			var iSize=0;
			var s=0;
			iSize=document.getElementById("textlen").value;
			
			s=document.getElementById("mealTypelen").value;
			var newCellCheck = newRow.insertCell(newRow.cells.length);
			//var newCal=parseInt(document.getElementById("Qty").value)*parseInt(Calori);
			var newCal=parseInt(document.getElementById("Qty").value)*parseFloat(Calori);
			var selObj = "";
			var flag=true;
		    var chkVal;
		    if(check != null)
			    chkVal = check.length;
		    	selObj +="<input type='text' name='itemQty"+count+"' id='itemQty"+count+"' value='"+document.getElementById("Qty").value+"' size='4' onblur=\"updateCalori("+iSize+","+j+",false,"+Calori+",this,"+flag+");return changeOfQty("+iSize+",'"+caode+"',"+chkVal+");\"/>";
			
			//selObj += servingUomCode;//Commented against ICN-#65555 0352
			selObj += servingUomCodeDesc;//Added against ICN-#65555 0352
			selObj +="(<input type='text' size='4' name='totalCal"+iSize+"' id='totalCal"+iSize+"' value='"+newCal+"' style='background:transparent;border=0' readonly='true' class='label' />     "+energyUomdesc+")";//Modified Against ICN-#65555 0352
			newCellCheck.innerHTML = selObj;
			newCellCheck.className="label";

		
	}

}
	obj=document.getElementById("itemQty"+count);
	document.getElementById("textlen").value=parseInt(iSize)+1;
	updateCalori(count,j,false,Calori,obj,false);
	count++;
	document.getElementById("foodDesc").value = "";
	document.getElementById("Qty").value = "";
	document.getElementById("additemType").value="";
}
 //Modified Against KDAH-CRF-0352 US4 for serve Ends Here

function updateCalori(i,s,itemInDB,c,obj,flag)
{	
	isMealMenuDisplay =document.getElementById("isMealMenuDisplay").value;
	var chkflag="";
	if(isMealMenuDisplay=="true")
		chkflag ="Y";
	else
		chkflag ="N";

	chkUnchkFn(s); // AAKH-CRF-0065 Sp2Us2Us3
	var j=0;
	var t1=0;
	s=parseInt(s);
	var contperUom=0;
	var newCal=0;
	//IN::39962
	var itemQty = "itemQty" + i;
	if(document.getElementById(itemQty).value == "")
	{
		    var key_value =getMessage("DS_ITMQTY_NOT_BLANK","DS"); // "ItemQty Cannot be Blank";
			alert(key_value);
			document.getElementById(itemQty).focus();
			return false;
	}

	if(itemInDB=='true')
		contperUom=document.getElementById("calorificContPerUom"+i).value;
	else
		contperUom=c;

 	var oldCal=document.getElementById("totalCal"+i).value;
	if(s == -1)
			s=parseInt(s)+1;
	else
		s=parseInt(s);

	var oldSubTotal=document.getElementById("subtotal"+s).value;
	if(document.getElementById("totalItemCal").value=="")
	document.getElementById("totalItemCal").value=oldSubTotal;
	if(flag != 'chk')
	{
		newCal = parseFloat(contperUom) * parseInt(obj.value);
		if(document.getElementById("itemCal").value=="")
			document.getElementById("itemCal").value = newCal;
		}

	var newSubTotal=0;
	if(itemInDB !='true')
	{
		if(flag == false)
		oldSubTotal=parseInt(oldSubTotal)+parseInt(newCal);
		else
		{
				t1=parseInt(oldSubTotal)-parseInt(oldCal);
				newSubTotal=parseInt(t1)+parseInt(newCal);
			}
		}
	if(flag=='chk')
	{
		if(obj.checked == false)
			newSubTotal=parseInt(oldSubTotal)-parseInt(oldCal);
		else
		{
			var k= parseInt(i)+1;
			if(s >= 0 && flag == "chk" && obj.checked == true && itemInDB != 'true')
			{
				//updateAllFields();// AAKH-CRF-0065
				newCal=document.getElementById("itemCal").value;
			}
			else
			{
				var temp=document.getElementById("itemQty"+i).value;
				newCal=parseFloat(contperUom)*parseInt(temp);
				t1=parseInt(oldSubTotal)-parseInt(oldCal);
				newSubTotal=parseInt(oldSubTotal)+parseInt(newCal);
			}
		}
	}

	//if(parseInt(oldSubTotal) > parseInt(newCal)){		//Modified for incorrect cal count
	if(document.getElementById("itemQty"+i).value != "" && document.getElementById("IntQty"+i).value != "")
	{
		if(parseInt(document.getElementById("itemQty"+i).value) > parseInt(document.getElementById("IntQty"+i).value))
		{
			t1=parseInt(oldSubTotal)-parseInt(oldCal);
			newSubTotal=parseInt(oldSubTotal)+parseInt(newCal)-parseInt(oldCal);
		}
		//else if(parseInt(oldSubTotal)<parseInt(newCal)){
		else if(parseInt(document.getElementById("itemQty"+i).value) < parseInt(document.getElementById("IntQty"+i).value))
		{
			t1=parseInt(oldSubTotal)-parseInt(oldCal);
			newSubTotal=parseInt(oldSubTotal)-parseInt(oldCal)+parseInt(newCal);
		}
		else if(parseInt(document.getElementById("itemQty"+i).value) == parseInt(document.getElementById("IntQty"+i).value) && flag!='chk')
			newSubTotal=oldSubTotal;
	}
	else
		newSubTotal=oldSubTotal;

	document.getElementById("subtotal"+s).value=newSubTotal;
	//Added for KDAH-CRF-0352-US4 Start
	if(chkflag=="Y" && itemInDB=='true'){
		var collen = document.getElementById("ServingUomColcnt"+i).value;
		var ServingUomArray, totcal,TotServingUomArray;
		for (var j = 0; j < collen; j++)
		{
			if(document.getElementById("ServingUom"+i+j) && parseInt(document.getElementById(itemQty).value) != "0")
			{
				ServingUomArray=document.getElementById("ServingUom"+i+j).value.split(" ");
				TotServingUomArray=document.getElementById("Kcalo_Total"+s+j).value.split(" ");
				if(flag=='chk' && newCal > 0)
				{
					//Added toFixed for Float values
					TotServingUomArray[0]=parseFloat(TotServingUomArray[0])+parseFloat(ServingUomArray[0]);
					document.getElementById("Kcalo_Total"+s+j).value = parseFloat(TotServingUomArray[0].toFixed(2)) + " " + TotServingUomArray[1];
				}
				else if(flag=='chk' && newCal == 0)
				{
					//Incrementing and Decrementing the MealType Total
					if (oldCal == 0 && obj.checked == true)
						TotServingUomArray[0]=parseFloat(TotServingUomArray[0])+parseFloat(ServingUomArray[0]);
					else
						TotServingUomArray[0]=parseFloat(TotServingUomArray[0])-parseFloat(ServingUomArray[0]);
					document.getElementById("Kcalo_Total"+s+j).value = parseFloat(TotServingUomArray[0].toFixed(2)) + " " + TotServingUomArray[1];
				}
				else if (document.getElementById("IntQty"+i).value != document.getElementById("itemQty"+i).value)
				{
					TotServingUomArray[0]=parseFloat(TotServingUomArray[0])-parseFloat(ServingUomArray[0]);
					ServingUomArray[0] = ServingUomArray[0] / parseInt(document.getElementById("IntQty"+i).value);
					var ServingUomCnt = parseInt(document.getElementById("itemQty"+i).value) * ServingUomArray[0];
					document.getElementById("ServingUom"+i+j).value = parseFloat((ServingUomCnt).toFixed(2)) + " " + ServingUomArray[1];
					document.getElementById("Kcalo_Total"+s+j).value = parseFloat((parseFloat(TotServingUomArray[0]) + parseFloat(ServingUomCnt)).toFixed(2)) + " " + TotServingUomArray[1];
				}
			}
		}
	}
	if(parseInt(document.getElementById(itemQty).value) != "0")
		document.getElementById("IntQty"+i).value = document.getElementById("itemQty"+i).value;
	//Added for KDAH-CRF-0352-US4 End

	// AAKH-CRF-0065 start
	if(newCal != 'NaN' && newCal > 0)
		document.getElementById("totalCal"+i).value = newCal;
	else
		document.getElementById("totalCal"+i).value = 0;
	// AAKH-CRF-0065 end
	
	var len=document.getElementById("mealTypelen").value;
	var GrandTotal=0;
	for(j=0;parseInt(j)<parseInt(len);parseInt(j++))
		GrandTotal=parseInt(GrandTotal)+parseInt( document.getElementById("subtotal"+j).value);
	var cal;
	var cal1=document.getElementById("energy").value;
	if(cal1 != "")
		cal=cal1.toLowerCase();
	else
		cal="";

	var tbodyObj = document.all("dispGTClorie");
	if(tbodyObj.rows.length>=1)
		tbodyObj.deleteRow(0);
	var newRow1 = tbodyObj.insertRow(0);
	var labelCel = newRow1.insertCell(newRow1.cells.length);
	labelCel.className = "lable";
	labelCel.style.fontWeight = "700";
	labelCel.style.fontSize ="8pt";
	labelCel.style.color ="blue";
	labelCel.setAttribute("border", "0px");
	labelCel.align = "left";
	labelCel.colSpan = "9";
	//Modified Against KDAH-CRF-0352 Start
	var uom=document.getElementById("energyUomDesc").value;
	var uomLower;
	if(uom != "")
		uomLower = uom.toLowerCase()
		else
		uom=document.getElementById("energy").value;
		if(uom != "")
			uomLower = uom.toLowerCase();
		else	
			uomLower="";
	//Modified Against KDAH-CRF-0352 End
	var calorieGrandTotal=getLabel("eDS.calorieGrandTotal.Label","DS");
	labelCel.appendChild(document.createTextNode(calorieGrandTotal + ":" +GrandTotal+" "+uomLower));
}


function changeOfQty(val,vas,cou)
{
	var obj = document.all("check"+vas);

	if(obj.length){
	if(obj[cou].checked)
	{
		if(document.getElementById("mealmenuSL"+val).value!=0)
		{
			document.getElementById("reviewType"+val).value="F";
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
			{
				document.getElementById("methodFlag"+val).value="6";
			}
			else
			{
				document.getElementById("methodFlag"+val).value="5";
			}
		}
		else
		{
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
			{
				document.getElementById("reviewType"+val).value="F";
				document.getElementById("methodFlag"+val).value="6";
			}
			else
			{
				document.getElementById("reviewType"+val).value="N";
			}
		}

		document.getElementById("itemQty"+val).readOnly=false;
	}
	else
	{
		if(document.getElementById("mealmenuSL"+val).value!=0)
		{
			document.getElementById("reviewType"+val).value="M";
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
			{
				document.getElementById("methodFlag"+val).value="6";
			}
			else
			{
				document.getElementById("methodFlag"+val).value="9";
			}
		}
		//Added by Subhani
		else if(obj[cou].checked == false)
		{
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
			{
				document.getElementById("reviewType"+val).value="F";
				document.getElementById("methodFlag"+val).value="6";
			}
			else
			{
				document.getElementById("reviewType"+val).value="N";
			}
		}
		else
		{
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
			{
				document.getElementById("reviewType"+val).value="M";
				document.getElementById("methodFlag"+val).value="6";
			}
			else
			{
				document.getElementById("reviewType"+val).value="M";
			}
		}
		document.getElementById("itemQty"+val).readOnly=true;
	}
	}
	else
	{
		if(obj.checked)
		{
			if(document.getElementById("mealmenuSL"+val).value!=0)
			{
				document.getElementById("reviewType"+val).value="F";
				if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
				{
					document.getElementById("methodFlag"+val).value="6";
				}
				else
				{
					document.getElementById("methodFlag"+val).value="5";
				}
			}
			else
			{
				if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
				{
					document.getElementById("reviewType"+val).value="F";
					document.getElementById("methodFlag"+val).value="6";
				}
				else
				{
					document.getElementById("reviewType"+val).value="N";
				}
			}

			document.getElementById("itemQty"+val).readOnly=false;
		}
		else
		{
			if(document.getElementById("mealmenuSL"+val).value!=0)
			{
				document.getElementById("reviewType"+val).value="M";
				if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
				{
					document.getElementById("methodFlag"+val).value="6";
				}
				else
				{
					document.getElementById("methodFlag"+val).value="9";
				}
			}
			else
			{
				if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
				{
					document.getElementById("reviewType"+val).value="M";
					document.getElementById("methodFlag"+val).value="6";
				}
				else
				{
					document.getElementById("reviewType"+val).value="M";
				}
			}
			document.getElementById("itemQty"+val).readOnly=true;
		}


	}

}

function showCalForNilByMouth(id, format, showsTime, showsOtherMonths, name) {
	fmt = format;
	{
		calend = format;
		if (showsTime) {
			time = true;
		} else {
			time = false;
		}
		var cal;
		currentDateElement = document.getElementById(id);

		cal = new PopupWindow();
		cal.offsetX = 50;
		cal.offsetY = 50;
		cal.setSize(250, 200);
		cal.autoHide();
		cal.setUrl("../../framework/jsp/Calendar.jsp");
		cal.refresh();
		cal.showPopup(name);
		return false;
	}
}

  function consoleLog(message)
  {
  if(!window.console)console = {log: function(){}};
  console.log(message);
  }

function updateAllFields()
{		
	var formObj = document.forms[0];
	formObj.totalItems.value=count;
	formObj.mode.value="updateMealMenuItemsObject"; // AAKH-CRF-0065
	formObj.method='post';
	formObj.action="../../servlet/eDS.PlaceDietOrderServlet";	
	formObj.submit();
	//Added against MMS-KH-CRF-0029.1 Starts Here		
	var enabledrugfoodYN = document.getElementById("enableDrugYN").value;	
	if(enabledrugfoodYN=="Y")
	{
	for(var i=0;i<=1000000000;i++)
	{
	if(i==1000000000)
	{
	editMenu();
	}
	}}
	//Added against MMS-KH-CRF-0029.1 Ends Here		
	window.close();
}

/* Added and Commented Against Start KDAH-CRF-0349.1 [IN062717]US2 */
function updateAllFieldsAll()
{
	var formObj = document.forms[0];
	formObj.totalItems.value=count;
	document.getElementById("allValue").value = "ALL";
	formObj.mode.value="updateMealMenuItemsObject"; 
	formObj.method='post';
	formObj.action="../../servlet/eDS.PlaceDietOrderServlet"; 
	formObj.submit();
	//Added against MMS-KH-CRF-0029.1 Starts Here		
	var enabledrugfoodYN = document.getElementById("enableDrugYN").value;	
	if(enabledrugfoodYN=="Y")
	{
	for(var i=0;i<=1000000000;i++)
	{
	if(i==1000000000)
	{
	editMenu();
	}
	}}
	//Added against MMS-KH-CRF-0029.1 Ends Here		
	window.close();
} 
/* Added and Commented Against End KDAH-CRF-0349.1 [IN062717]US2 */

function changeIT(val,obj)
{
	var ic = document.getElementById("itemCode"+val).value;
	var it = document.getElementById("mealType"+val).value;
	var va = it+"_"+ic;
	if(obj.checked)
	{
		if(document.getElementById("div"+va) != null)
		document.getElementById("div"+va).style.color="navy";
		if(document.getElementById("mealmenuSL"+val).value!=0)
		{
			document.getElementById("reviewType"+val).value="F";
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
				document.getElementById("methodFlag"+val).value="6";
			else
				document.getElementById("methodFlag"+val).value="5";
		}
		else
		{
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
			{
				document.getElementById("reviewType"+val).value="M";
				document.getElementById("methodFlag"+val).value="6";
			}
			else
				document.getElementById("reviewType"+val).value="N";
		}
		document.getElementById("itemQty"+val).readOnly=false;
	}
	else
	{
	if(document.getElementById("div"+va)!=null) 
	document.getElementById("div"+va).style.color="Brown";
		if(document.getElementById("mealmenuSL"+val).value!=0)
		{
			document.getElementById("reviewType"+val).value="M";
			if(document.getElementById("itemQty"+val).value!=document.getElementById("Qty"+val).value)
				document.getElementById("methodFlag"+val).value = "6";
			else
				document.getElementById("methodFlag"+val).value = "9";
		}
		else
		{
			if(document.getElementById("Qty"+val).value == '')
				document.getElementById("reviewType"+val).value="M";
			else if(parseFloat(document.getElementById("itemQty"+val).value)!=parseFloat(document.getElementById("Qty"+val).value))
			{
				document.getElementById("reviewType"+val).value="F";
				document.getElementById("methodFlag"+val).value="6";
			}
			else
				document.getElementById("reviewType"+val).value="M";
		}
		document.getElementById("itemQty"+val).readOnly=true;
	}
}

function getMenuForDayRef()
{
	var dayRefNo;
	var locale=document.getElementById("languageId").value;

	//ML-MMOH-CRF-0427 starts
	var profileFlag=$('#profileFlag').val();
	var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
	var maximum_days_allowed=$('#maximum_days_allowed').val();
	var selecteddate=$('#dateForMeanu').val();
	if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
	var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);
	if(!flag){

		var error="";
		var sysdate=getCurrentDate("DMH",locale);
		var maxdate=addDays(new Date(),maximum_days_allowed);
		var maxToDate=changeDate(maxdate);

		var fieldName=getLabel("eOT.date.Label","ot_labels");
		var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
		var msgArray=msg.split("#");
		error="";
		//error="Date should be within "+sysdate+" to "+maxToDate+"<br>";
		error+=fieldName;
		error+=msgArray[1];
		error+=sysdate;
		error+=msgArray[2];
		error+=maxToDate;

        	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		$('#dateForMeanu').focus();
		$('#dateForMeanu').select();

		return false;
	}else{
	var error="";
	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
	}
	//ML-MMOH-CRF-0427 ends
	dayRefNo = document.getElementById("dayRef").value
	var mode = "MealContent";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="&locale="+locale+"&_mTypeArr="+ob1+"&mClass="+document.getElementById("mealClass").value+"&_dTypeArr="+ob+"&profileSL="+document.getElementById("profileSL").value+"&encounterId="+document.getElementById("encounterId").value+"&dateForMeanu="+document.getElementById("dateForMeanu").value+"&dayRef="+dayRefNo+"&kitchenCode="+document.getElementById("kitchenCode").value+"&addedFacilityId="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	retVal = localTrimString(xmlHttp.responseText);
	//IN:40900
			tableObj3 = document.getElementById("treemenu3");
			while (tableObj3.rows.length > 0) {
				tableObj3.deleteRow(0);
			}
			tableObj4 = document.getElementById("treemenu4");
			while (tableObj4.rows.length > 0) {
				tableObj4.deleteRow(0);
			}
	if(retVal != null && trim(retVal).length != 0){
		menuList = retVal.split(',');
		assignMealItem(menuList);
	}

}
function callsimbly() {

}
var g=0;
function updatedDietTypes(profileSL,encounterId){
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "updatedDietTypes";
	var upDietType ="&profileSL="+profileSL+"&encounterId="+encounterId+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;
	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+upDietType;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=localTrimString(xmlHttp.responseText);
	var updArray = responseText.split(",");
	// Adding MealTypes for dietTypes
	if(updArray != null && updArray.length > 0){
		var obj = document.getElementsByName("mealTypesforDietTypes");
		var mealObj = document.getElementsByName("dietTypesForMeals");
		OrigAssignedDietTypes=new Array();
		for(var d = 0,i=0; i < mealObj.length; d=d+2,i++){
			if(updArray[d] != null && updArray[d] != "") {
//				Fix for spira incident 47929: included below if condition
				if(obj[i].value==trim(updArray[d])) {
//					obj[i].value = trim(updArray[d]);
					mealObj[i].value = trim(updArray[d+1]);
					OrigAssignedDietTypes.push(trim(updArray[d+1]));
				}
			}
		}
	}
	if(g<1 && document.getElementById("hdrFlag").value == ""){
		setTimeout("getMeals()", 1000);
	g++;
	}
}
function compareDate(date1,date2) {
	var flag="";
    if(date1.length > 0 && date2.length > 0 ) {
			var date1_array = date1.split(" ");
			var date1_temp= date1_array[0];

			var date2_array = date2.split(" ");
			var date2_temp = date2_array[0];

	        var date1array = date1_temp.split("/");
            var date2array = date2_temp.split("/");

			var date1dt = new Date(date1array[2],date1array[1]-1,date1array[0]);
            var date2dt = new Date(date2array[2],date2array[1]-1,date2array[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
			if(Date.parse(date1dt) > Date.parse(date2dt)) {
                flag=1;
            }
			else if(Date.parse(date1dt) == Date.parse(date2dt)) {
				flag=0;
			}
			else flag=-1;

    }
	return flag;
}

function reset(){
	var locationCode=parent.frames[2].document.getElementById("locationCode").value;
	var locationType=parent.frames[2].document.getElementById("locationType").value;
	var patientId=parent.frames[2].document.getElementById("Patient_ID").value;
	var patientClass=parent.frames[2].document.getElementById("patientClass").value;
	var encounterId=parent.frames[2].document.getElementById("encounterId").value;
	var facilityId=parent.frames[2].document.getElementById("addedFacilityId").value;
	var flag = parent.frames[2].document.getElementById("flag").value;

	parent.frames[2].document.location.href="../../eDS/jsp/PlaceDietOrderCUD.jsp?locationCode="+locationCode+"&Patient_ID="+patientId+"&encounterId="+encounterId+"&Facility_Id="+facilityId+"&patientClass="+patientClass+"&locationType="+locationType+"&flag="+flag;
}

// Validating the date and time for NilByMouth
function validateDate(obj,val){
	var date=new Date();
	var error ="";
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	if(hour<=9){
		hour="0"+""+hour;
	}
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysDate=date1+"/"+month+"/"+year+" "+hour+":"+minute;

    if(val.length > 0) {
    	var date_array = val.split(" ");

    	if(date_array.length==1) {
    		val=val+" "+hour+":"+minute;
    		obj.value=val;
    	}
    }
	if(isValidDateTime(val)){
		var flag =  compareFromDate(val,sysDate,'en',"DMYHM");
		if(flag == -1){
			error = getMessage("DS_NBMFRMDTIM_NOTLES_CURDTIM","DS"); //"Nil By Mouth From Date Time should not be less than Current Date Time";
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}else{
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
	}
	else
	{
		document.getElementById("from").value="";
	}

}
function isValidDateTime(obj){
	var flag=true;
	if(obj!=""){
		var str=obj;
		var dateValArr = str.split(' ');
		if (dateValArr[0] =="" || dateValArr[1]=="")
		{
			alert(getMessage('INVALID_DATE_FMT','SM'));
			flag=false;
		}
		else
		{
			if(checkDate1(dateValArr[0])==true && checkTime(dateValArr[1])==true)
			{flag=true;}
			else
			{flag=false;}
		}
	}
	return flag;
}

function compareFromDate(fromdate,todate,locale,format) {
    var fromarray; var toarray;
	var fromdate = convertDate(fromdate,format,locale,locale);
	var todate = convertDate(todate,format,locale,locale);
	var retVal=1;
    if(fromdate.length > 0 && todate.length > 0 ) {
    	var from_date_array = fromdate.split(" ");
		var from_date = from_date_array[0];
		var from_time = from_date_array[1];

		var to_date_array = todate.split(" ");
		var to_date = to_date_array[0];
		var to_time = to_date_array[1];

		var fromdatearray = from_date.split("/");
		var todatearray = to_date.split("/");
		if(format == "DMY") {
			var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0]);
			var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0]);
		}
		else{
			var fromtimearray = from_time.split(":");
			var totimearray = to_time.split(":");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
		}
	//Commented against 058678 starts
        /*
		if(Date.parse(fromdate) < Date.parse(todate)) {
        	retVal=-1;
        }
        else if(Date.parse(todt) == Date.parse(fromdt)) {
        	retVal=0;
        }
	*/
	//Commented against 058678 ends
	//Added Against 058678 starts
		if(fromdate < todate)
			return -1;
		else
			return 1;
	//Added Against 058678 ends
    }
	return retVal;
}

function compareDates(fromdate,todate,locale,format) {
    var fromarray; var toarray;
	var fromdate = convertDate(fromdate,format,locale,locale);
	var todate = convertDate(todate,format,locale,locale);
	var retVal=1;
    if(fromdate.length > 0 && todate.length > 0 ) {
    	var from_date_array = fromdate.split(" ");
		var from_date = from_date_array[0];
		var from_time = from_date_array[1];

		var to_date_array = todate.split(" ");
		var to_date = to_date_array[0];
		var to_time = to_date_array[1];

		var fromdatearray = from_date.split("/");
		var todatearray = to_date.split("/");
		if(format == "DMY") {
			var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0]);
			var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0]);
		}
		else{
			var fromtimearray = from_time.split(":");
			var totimearray = to_time.split(":");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0],fromtimearray[0],fromtimearray[1]);//CRF-410
            		var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0],totimearray[0],totimearray[1]);//CRF-410
		}
        if(Date.parse(todt) < Date.parse(fromdt)) {
        	retVal=-1;
        }else if(Date.parse(todt) == Date.parse(fromdt)) {
        	retVal=0;
        }else{//CRF-410
		retVal=1;
	}
    }
	return retVal;
}

function checkDate1(objval)
{
	var flag=true;
	var RE_NUM =  /^\/?\d+$/;
	var str_date = objval;
	var arr_date = str_date.split('/');
	if (arr_date.length != 3)
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		flag=false;
	}
	else
	{
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
		var alphaFilter =/^[0-9]+$/;
	   	if (!(alphaFilter.test(arr_date[2])))  flag=false;

		if (flag==false){
			alert(getMessage('INVALID_DATE_FMT','SM'));
		}
	}

	return flag;
}
function checkTime(timeBox){
	if(timeBox=="" || timeBox==null || typeof timeBox=='undefined' )
	{
		alert(getMessage('INVALID_DATE_FMT','SM'));
		return false;
	}else
	{
		if(parseInt(timeBox.length)<=parseInt(5))
		{
		   time=timeBox;
		   time1=time.split(':')
		   if (!/\d{2}:\d{2}/.test(time)){
			   alert(getMessage('INVALID_DATE_FMT','SM'));
			   return false;
		   }
		   else if (time1[0] >23 || time1[1]>59) {
			   alert(getMessage('INVALID_DATE_FMT','SM'));
			   return false;
		   }
		   else return true;
		}
	}
}

//var remarks = new Array();
var remarks = "";//Added Against AMRI-SCF-0497
async function Remarks(){	
	var remarkHdr = "";
	if(document.getElementById("remarks").value != "null" &&  document.getElementById("remarks").value != "" && remarks == ""){
		remarkHdr = document.getElementById("remarks").value;
	}
	//Modified Against AMRI-SCF-0497 Starts Here
	if(remarks != null || remarks == undefined){
		if(remarkHdr != ""){
		 remarks = remarkHdr;
		}
		else{
		 remarkHdr = remarks;
		}
	}
	//Modified Against AMRI-SCF-0497 Ends Here
	else{
		remarkHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/Remarks.jsp?&remarkHdr="+encodeURIComponent(remarkHdr);
	var dialogArguments = remarks;//Added Against AMRI-SCF-0497
	//var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	var dialogTop   = "65";
    var dialogHeight    = "200px" ; //30.5
    var dialogWidth = "410px" ;
    var arguments   = "" ;
    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	returnRemarks =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnRemarks != null){
		remarks = returnRemarks;
	}
	//Added Against AMRI-SCF-0497 Starts Here
	if(returnRemarks == undefined){
		returnRemarks = dialogArguments;
	}
	//Added Against AMRI-SCF-0497 Starts Here
}

function geRemarks(val) {
	if(val == ""){
		alert(getMessage("DS_REM_NOT_BLANK","DS")); //"Remarks cannot be blank"
		document.getElementById('REMARKS').focus();
	}else{
		remarks = val;
		document.getElementById('remarks').value = remarks;
		window.returnValue = remarks;
		window.close();
	}

}

function textAreaLimit1(field, maxlen) {
	//if (field.value.length > maxlen + 1) //Commented Against ML-MMOH-CRF-1816
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}
//IN:39962 - To allow only numbers.
function chkifPositive(e, obj){
	var code = "";
	if (e.keyCode)
		 code = e.keyCode;
	else if (e.which)
		  code = e.which;

	if(code == 190)
	{
		var str = obj.value;
		var nPosition =str.indexOf(".");
		if( nPosition >= 0)
			return false;
		else
		    return true;
	}

   if ((code >= 48 && code <= 57) || (code >= 96 && code <= 105) || code == 110)
    return true;
   else if(code == 8 || code == 46 || code == 37 || code == 36 || code == 39 || code == 35) //Allowing Backspace,Delete,Home key:
	return true;
   else
	return false;
}

function compareDatesForDisPat(date1,date2) {
	var flag="";

	var today = new Date();
	var dd = today.getDate();
	if(dd<10){
		dd='0'+dd;
	}
	var mm = today.getMonth()+1;//January is 0!
	if(mm<10){
		mm='0'+mm;
	}
	var yyyy = today.getYear();
	var sysDate = dd+"/"+mm+"/"+yyyy;
    if(date1.length > 0 || date2.length > 0){
		if(Date.parse(date1) > Date.parse(sysDate)){
			 flag=1;
		}else if(Date.parse(date2) > Date.parse(sysDate)){
			 flag=1;
		}
    }
	return flag;
}

function compareSysDate(date1){
var flag="";

	var today = new Date();
	var dd = today.getDate();
	if(dd<10){
		dd='0'+dd;
	}
	var mm = today.getMonth()+1;//January is 0!
	if(mm<10){
		mm='0'+mm;
	}
	var yyyy = today.getYear();
	var sysDate = dd+"/"+mm+"/"+yyyy;
    if(date1.length > 0 ){
		if(Date.parse(date1) > Date.parse(sysDate)){
			 flag=1;
		}
    }
    return flag;
}
function validateToDate(obj,val){

	var error ="";
	var date=new Date();
	var month=date.getMonth();
	var date1=date.getDate();
	var year=date.getYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	month+=1;
	if(date1<=9){
		date1="0"+""+date1;
	}
	if(month<=9){
		month="0"+""+month;
	}
	if(hour<=9){
		hour="0"+""+hour;
	}
	if(minute<=9){
		minute="0"+""+minute;
	}

    if(val.length > 0) {
    	var date_array = val.split(" ");

    	if(date_array.length==1) {
    		val=val+" "+hour+":"+minute;
    		obj.value=val;
    	}
    }

	var fromDate=document.getElementById("from").value;
	if(isValidDateTime(val)){

		//var flag =  compareToDates(val,fromDate,'en',"DMYHM");
		var flag =  compareToDates(fromDate,val,'en',"DMYHM");
		if(flag == -1){
			var error =  getMessage("DS_NBMTODAT_GRTREQL_FRMDAT","DS"); //"Nil By Mouth To date should be greater than or equal to From Date";
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}else{
			parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
	}
	else
	{
		document.getElementById("to").value="";
	}
}
function compareToDates(fromdate,todate,locale,format) {

	 var fromarray; var toarray;
		var fromdate = convertDate(fromdate,format,locale,locale);
		var todate = convertDate(todate,format,locale,locale);
		var retVal=1;
		//IN058331
		if(fromdate.value=="null" || fromdate.value=="" || fromdate.value==undefined){
			fromdate="";
		}
		//IN058331
	    if(fromdate.length > 0 && todate.length > 0 ) {
	    	var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

			var fromdatearray = from_date.split("/");
			var todatearray = to_date.split("/");
			if(format == "DMY") {
				var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
				var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			}
			else{
				var fromtimearray = from_time.split(":");
				var totimearray = to_time.split(":");

				var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
	            var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
			}
	        if(Date.parse(fromdt) < Date.parse(todt)) {
	        	retVal=-1;
	        }
	        else if(Date.parse(todt) > Date.parse(fromdt)){
	        	retVal=1;
	        }
	    }
		return retVal;
}
function getDayRefNo(date) {
	if (document.getElementById("mealClass").value != "" && document.getElementById("dietType").value != "") {
		var mode = "DayRefNo";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		var pArgumentArrayMap = "&dateForMeanu="+date+"&facility="+document.getElementById("addedFacilityId").value+"&dietType="+document.getElementById("dietType").value+"&mealClass="+document.getElementById("mealClass").value+"&mode="+mode;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
		xmlHttp.send(xmlDoc);
		retVal = localTrimString(xmlHttp.responseText);
		var obj = document.getElementById("dayRef");
		if(retVal != null && trim(retVal).length != 0){
			var Entry = document.createElement("option");
			Entry.value  = trim(retVal);
			Entry.text  = trim(retVal);
			obj.add(Entry);
		}
		document.getElementById("dayRef").value = trim(retVal);
	}
}


function getDayRefNoForMealMenu(date,mClass,dType,facility_id) {
	if (mClass!= "" && dType != "") {
		var mode = "DayRefNo";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		var pArgumentArrayMap = "&dateForMeanu="+date+"&facility="+facility_id+"&dietType="+dType+"&mealClass="+mClass+"&mode="+mode;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+pArgumentArrayMap,false);
		xmlHttp.send(xmlDoc);
		retVal = localTrimString(xmlHttp.responseText);
		var obj = document.getElementById("dayRef");
		if(retVal != null && trim(retVal).length != 0){
			var Entry = document.createElement("option");
			Entry.value  = trim(retVal);
			Entry.text  = trim(retVal);
			obj.add(Entry);
		}
		document.getElementById("dayRef").value = trim(retVal);
		document.getElementById("dateForMenu").value = date;
	}
}

function refreshWithNewData(dTypes,mTypes,pSl,Code,enID,dType,mClass,pClass) {
	if(document.getElementById("dayRef").value != null && document.getElementById("dayRef").value != ""){
		var dietTypes = dTypes;
		var mealTypes = mTypes;
		var profileSL = pSl;
		var kitchenCode = Code;
		var encounterId = enID;
		//var menuDate = date;
		var menuDate = document.getElementById("dateForMenu").value
		var dietType = dType;
		var mealClass = mClass;
		var patientClass = pClass;
		var locale = document.getElementById("locale").value;

		//ML-MMOH-CRF-0427 starts
		var profileFlag=document.getElementById("profileFlag").value;
		//var profileFlag=$('#profileFlag').val();
		var restrict_date_inpatients_yn=$('#restrict_date_inpatients_yn').val();
		var maximum_days_allowed=$('#maximum_days_allowed').val();
		var selecteddate=$('#dateForMenu').val();
		if(profileFlag=="true" && restrict_date_inpatients_yn=="Y"){
		var flag=grayOutCalendarValidation(selecteddate,maximum_days_allowed);
		if(!flag){

			var error="";
			var sysdate=getCurrentDate("DMH",locale);
			var maxdate=addDays(new Date(),maximum_days_allowed);
			var maxToDate=changeDate(maxdate);

			var fieldName=getLabel("eOT.menuForDate.Label","ot_labels");
			var msg=getMessage("DS_SHOULD_BE_WITHIN","DS");
			var msgArray=msg.split("#");
			error="";
			error+=fieldName;
			error+=msgArray[1];
			error+=sysdate;
			error+=msgArray[2];
			error+=maxToDate;

        		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			$('#dateForMenu').focus();
			$('#dateForMenu').select();

			return false;
		}else{
		var error="";
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
		}
		//ML-MMOH-CRF-0427 ends
	//Added Against Start KDAH-CRF-0349 [IN062717] US1	
	var patientId = document.getElementById("patientId").value;
	var dateFrom = document.getElementById("dateFrom").value;
	var dateTo = document.getElementById("dateTo").value;
	//Added Against End KDAH-CRF-0349 [IN062717] US1	
	var params = "dietType="+dietType+"&dietTypesForMeals="+dietTypes+"&mealTypesforDietTypes="+mealTypes+"&profileSL="+profileSL+"&kitchenCode="+kitchenCode+"&mealClass="+mealClass+"&patientClass="+patientClass+"&dayRef="+document.getElementById("dayRef").value+"&encounterId="+encounterId+"&dateForMeanu="+menuDate+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn+"&maximum_days_allowed="+maximum_days_allowed+"&profileFlag="+profileFlag+"&dateFrom="+dateFrom+"&dateTo="+dateTo+"&patientId="+patientId;//ML-MMOH-CRF-0427
	//Modified Against KDAH-CRF-0349 [IN062717] US1	
	var reload = document.getElementById('reload');
	reload.href ="../../eDS/jsp/mealMenuItems.jsp?"+params;
	reload.click();
	}
}
function getSlNoForDel(rowNum){
	var mode = "srlNOForDel"
	var encounterId = document.getElementById("encounterId").value;
	var facility= document.getElementById("addedFacilityId").value;
	var itemCode = document.getElementById("foodType").value;
	var profileSL = document.getElementById("profileSL").value;
	var paramSrlNo = "&encounterId="+encounterId+"&facility="+facility+"&itemCode="+itemCode+"&profileSL="+profileSL+"&rowNum="+rowNum+"&mode="+mode;
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramSrlNo,false);
	xmlHttp.send(xmlDoc);
	var retSrlNO = localTrimString(xmlHttp.responseText);
	slArrList = retSrlNO.split(",");
	//var m =0;
	for(var k=0; k < slArrList.length; k=k+2){
		if(slArrList[k] != null && slArrList[k] != ""){
			itemSrlNo.push(slArrList[k+1]);
			prlSLdel.push(slArrList[k]);
			//m = m+1;
		}
	}
}

function NutrientRec(){
	var tableObj = document.getElementById('listContentTable');
	var countRow = tableObj.rows.length;
	var row_ind = 1;
	var selObj="";
	countRowValue = nutriArr.length;
	if(document.getElementById("rowNo").value == ""){
		for (var i = 0; i < nutriArr.length; i++) {
			var obj = nutriArr[i];
			if (obj) {
				if (obj[6] != "-1") {
					if (obj[3] == document.all("foodType").value && obj[5]==document.all("mealType").value) {
						alert(getMessage("DS_FOODITM_EXIST","DS"));
						return false;
					}
				}
			}
		}
		
		if (document.all("from").value != "" && document.all("itemType").value != "" && document.all("foodType").value != "" && document.all("qty").value != "") {
			nutriArr[countRowValue] = new Array();
			nutriArr[countRowValue][0] = document.all("from").value;
			nutriArr[countRowValue][1] = document.all("to").value;
			nutriArr[countRowValue][2] = document.all("itemType").value;
			nutriArr[countRowValue][3] = document.all("foodType").value;
		//	document.getElementById("fICode").value = document.all("foodType").value;
			nutriArr[countRowValue][4] = document.all("qty").value;
			nutriArr[countRowValue][5] = document.all("mealType").value;
			nutriArr[countRowValue][6] = "0";
			nutriArr[countRowValue][7] = document.all("foodDesc").value;
			nutriArr[countRowValue][8] = document.all("itemType").options[document.all("itemType").selectedIndex].text;
			nutriArr[countRowValue][9] = document.getElementById("servingUomCode").value;

			var newRow = tableObj.insertRow(row_ind);
			newRow.id = countRowValue;
			var newCellitemType = newRow.insertCell(newRow.cells.length);
			var code = document.all("itemType").value + "-" + document.all("foodType").value;
		
			var sub = "<A  href=\"#\" onclick=\"return fetchRow('" + countRowValue + "');\" >" + nutriArr[countRowValue][8] + "</A>";
			newCellitemType.innerHTML = sub;
			var newCellDate = newRow.insertCell(newRow.cells.length);
			newCellDate.appendChild(document.createTextNode(nutriArr[countRowValue][0] + "-" + nutriArr[countRowValue][1]));
			var newCellfoodType = newRow.insertCell(newRow.cells.length);
			newCellfoodType.appendChild(document.createTextNode(nutriArr[countRowValue][7]));
			var newCellqty = newRow.insertCell(newRow.cells.length);

			var TCalori=parseFloat((Math.round((nutriArr[countRowValue][4])*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)));

			CaloriT=parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)))+parseFloat((Math.round(TCalori*Math.pow(10,2))/Math.pow(10,2)));
			nutriArr[countRowValue][15]=parseFloat((Math.round(CaloriT*Math.pow(10,2))/Math.pow(10,2)));

			nutriArr[countRowValue][12]=parseFloat((Math.round(TCalori*Math.pow(10,2))/Math.pow(10,2)));
			nutriArr[countRowValue][13]=energyUom; 
			nutriArr[countRowValue][14]=iCode;
			nutriArr[countRowValue][16]=energyUom_Desc;//Added Against PMG2017-COMN-CRF-0012.1-US001
			nutriArr[countRowValue][17]=servingUom_Desc;//Added Against Nutrient Supplement & Special food item [IN:067653]
			
			//newCellqty.innerHTML=nutriArr[countRowValue][4]+" "+nutriArr[countRowValue][9]+"("+TCalori+" "+energyUom+")"//Commented Against PMG2017-COMN-CRF-0012.1-US001
			newCellqty.innerHTML=nutriArr[countRowValue][4]+" "+nutriArr[countRowValue][17]+"("+TCalori+" "+energyUom_Desc+")"//Added Against PMG2017-COMN-CRF-0012.1-US001 and Modified Against Nutrient Supplement & Special food item [IN:067653]
			countRowValue++;
		}
	}else{
		var nutCode = document.getElementById("rowNo").value;
		nutriArr[nutCode][0] = document.all("from").value;
		nutriArr[nutCode][1] = document.all("to").value;
		nutriArr[nutCode][2] = document.all("itemType").value;
		nutriArr[nutCode][3] = document.all("foodType").value;
		nutriArr[nutCode][4] = document.all("qty").value;
		nutriArr[nutCode][5] = document.all("mealType").value;
		nutriArr[nutCode][7] = document.all("foodDesc").value;
		nutriArr[nutCode][8] = document.all("itemType").options[document.all("itemType").selectedIndex].text;
		nutriArr[nutCode][9] = document.getElementById("servingUomCode").value;
		nutriArr[nutCode][10] = "M";
		nutriArr[nutCode][11] = document.getElementById("itemSlNo").value;
		var tableObj = document.getElementById('listContentTable');
		while (tableObj.rows.length > 1) {
			tableObj.deleteRow(1);
		}
		for (var i = 0; i < nutriArr.length; i++) {
			var obj = nutriArr[i];
			if (obj != null) {
				if (obj[6] != "-1" && obj[10] == "M") {
					var countRow = tableObj.rows.length;
					var row_ind = 1;
					var newRow = tableObj.insertRow(row_ind);
					//newRow.id = countRowValue;
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					if(obj[16] == undefined){
						obj[16] = obj[14] ;
					}
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					var newCellitemType = newRow.insertCell(newRow.cells.length);
				
					var sub = "<A  href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>";
					newCellitemType.innerHTML = sub;
					var newCellDate = newRow.insertCell(newRow.cells.length);
					newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
					var newCellfoodType = newRow.insertCell(newRow.cells.length);
					newCellfoodType.appendChild(document.createTextNode(obj[7]));
					var newCellqty = newRow.insertCell(newRow.cells.length);				
					obj[12]=parseFloat((Math.round(obj[4]*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)));
					var cal2 = obj[12];
					//var cal3 = cal2+" "+obj[13] //Commented Against PMG2017-COMN-CRF-0012.1-US001
				
					var cal3 = cal2+" "+obj[16] //Added Against PMG2017-COMN-CRF-0012.1-US001
					
					//Modifed Against Nutrient Supplement & Special food item [IN:067653] Starts Here
					if(obj[17] == undefined){
						obj[17] = obj[15] ;
					}
					newCellqty.innerHTML=obj[4]+" "+obj[17]+"("+cal3+")"
					//Modifed Against Nutrient Supplement & Special food item [IN:067653] Ends Here
				}else{					
					var countRow = tableObj.rows.length;
					var row_ind = 1;
					var newRow = tableObj.insertRow(row_ind);
					//newRow.id = countRowValue;
					var newCellitemType = newRow.insertCell(newRow.cells.length);
				
					var sub = "<A  href=\"#\" onclick=\"return fetchRow('" + i + "');\" >" + obj[8] + "</A>";
					newCellitemType.innerHTML = sub;
					var newCellDate = newRow.insertCell(newRow.cells.length);
					newCellDate.appendChild(document.createTextNode(obj[0] + "-" + obj[1]));
					var newCellfoodType = newRow.insertCell(newRow.cells.length);
					newCellfoodType.appendChild(document.createTextNode(obj[7]));
					var newCellqty = newRow.insertCell(newRow.cells.length);
					obj[12]=parseFloat((Math.round(obj[4]*Math.pow(10,2))/Math.pow(10,2)))*parseFloat((Math.round(Calori*Math.pow(10,2))/Math.pow(10,2)));
					var cal2 = obj[12];
					//var cal3 = cal2+" "+obj[13] //Commented Against PMG2017-COMN-CRF-0012.1-US001
					//Added Against PMG2017-COMN-CRF-0012.1-US001
					if(obj[16] == undefined){
						obj[16] = obj[14] ;
					}
					var cal3 = cal2+" "+obj[16] //Added Against PMG2017-COMN-CRF-0012.1-US001
					
					//Modifed Against Nutrient Supplement & Special food item [IN:067653] Starts Here
					if(obj[17] == undefined){
						obj[17] = obj[15] ;
					}
					newCellqty.innerHTML=obj[4]+" "+obj[17]+"("+cal3+")"
					//Modifed Against Nutrient Supplement & Special food item [IN:067653] Ends Here
				}
			}
		}
	}

	document.getElementById("rowNo").value = "";
	document.all("from").value = "";
	document.all("to").value = "";
	document.all("itemType").value = "";
	document.all("foodType").value = "";
	document.all("foodDesc").value = "";
	document.all("qty").value = "";
	document.all("mealType").value = "";
	document.getElementById("servingUomCode").value="";
}

function fetchRow(val){
	if(nutriArr[val][6] == "0"){
		document.all("from").value = nutriArr[val][0];
		document.all("to").value = nutriArr[val][1];
		document.all("itemType").value = nutriArr[val][2];
		document.all("foodDesc").value = nutriArr[val][7];
		document.all("qty").value = nutriArr[val][4];
		document.all("mealType").value = nutriArr[val][5];
		document.all("rowNo").value = val;
		document.all("foodType").value = nutriArr[val][3];
		document.getElementById("servingUomCode").value=nutriArr[val][9];
	}else{
		document.all("from").value = nutriArr[val][0];
		document.all("to").value = nutriArr[val][1];
		//Modified Against Nutrient Supplement & Special food item [IN:067653] Starts Here
		document.all("itemType").value = trim(nutriArr[val][2]);
		document.all("foodDesc").value = nutriArr[val][7];
		document.all("qty").value = nutriArr[val][4];
		document.all("mealType").value = trim(nutriArr[val][5]);
		document.all("rowNo").value = val;
		document.all("foodType").value = trim(nutriArr[val][3]);
		document.getElementById("servingUomCode").value=nutriArr[val][9];
		document.getElementById("itemSlNo").value = nutriArr[val][11]
		//Modified Against Nutrient Supplement & Special food item [IN:067653] Ends Here
	}
}

//Refer to Dietician IN 42110
function enableMandatory()
{
	//CRF -0684
	var isMenuType="";	
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	chkFormValChange = true;
	if(document.getElementById("dieticianReferral").checked ==  true ||
		document.getElementById("Full_Day_NBM_YN").checked==true//CRF-410
	){
		referrToDietcianFlag=true;//428	
		//CRF-1123
		var dtcatAlaC =document.getElementById("dietCategory").value;
		//if(dtcatAlaC =="ALAC" || dtcatAlaC =="THEU" ){ 	//Commented Against AMS-SCF-0883
		if(dtcatAlaC =="ALAC"){	//Modified Against AMS-SCF-0883 on 10-07-2020
			document.getElementById("dietCategory").value = "";
			diet_Category="";
		}		
		//CRF-1123		
		document.getElementById("dietCatImage").style.visibility = "hidden";
		document.getElementById("fromDateImage").style.visibility = "hidden";
		document.getElementById("MealClassImage").style.visibility = "hidden";
		document.getElementById("dietTypeImage").style.visibility = "hidden";
		document.getElementById("dateToImage").style.visibility = "hidden";//427
		if(isMenuType == "true"){
			document.getElementById("MenuImage").style.visibility = "hidden";//CRF-684
		}
	}
	else
	{		
		referrToDietcianFlag=false;//428
		document.getElementById("dietCatImage").style.visibility = "visible";
		document.getElementById("fromDateImage").style.visibility = "visible";
		document.getElementById("MealClassImage").style.visibility = "visible";
		document.getElementById("dietTypeImage").style.visibility = "visible";
		document.getElementById("dateToImage").style.visibility = "visible";//427
		if(isMenuType == "true"){
			document.getElementById("MenuImage").style.visibility = "visible";//CRF-684
		}
	}
}

//Refer to Dietician IN 42110
function getReferDietcian(val){
	window.returnValue = val;
	window.close();
}

//Refer to Dietician IN 42110
function notToRefer(val){
	var notToRefer = val;
	if(notToRefer == ""){
		referrToDietcian = notToRefer;
	}
	window.close();
}

//Refer to Dietician IN 42110
function getDieticianFlag(){
	var encounterId=document.getElementById("encounterId").value;
	var facility = document.getElementById("addedFacilityId").value;
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "getDieticianFlag";
	var paramVal ="&encounterId="+encounterId+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;
	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+paramVal;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var retVal=localTrimString(xmlHttp.responseText);
	if(retVal != null){
		if(trim(retVal) == "Y"){
			document.getElementById("dieticianReferral").checked = true;

			$("#dieticianReferral_hidden").val("Y");//29dec
		}
		else {
			document.getElementById("dieticianReferral").checked = false;
			$("#dieticianReferral_hidden").val("N");//29dec
		}
	}
}

async function cancelMealOrder(dietCategory, mealClass, feedType, dietType, feedingInstructions, dsDeliveryInstr, patientClass, encounterId, profileSL, dateFrom, dateTo, nilFromDate, nilToDate,Actual_todate)//Modified Against PMG2013-CRF-0009.1-US001
{
	var locale = $('#languageId').val();
	var servingDate = $('#servingDate').val();
	if(dietCategory=="NBM"){
		var database_system_date_time = getCurrentDate("DMY",'en');
		servingDate=database_system_date_time;		
	}
	var confirmWindowContent;
	var validationDateTo;
	var Cancelled_Reason;//Added Against cancelreason issue(PMG2013-CRF-0009.1-US004)
	var activeOrderFlag = "N";
	var Actual_todate = document.getElementById("dateTo").value; //Added Against PMG2013-CRF-0009.1-US001
	if(dateTo != null && dateTo != '')
		validationDateTo = dateTo;
	else
		validationDateTo = "31/12/2999";
	if(isBetween(dateFrom, validationDateTo, servingDate, "DMY", locale) && dietCategory!="NBM")//CRF-410 - Current date Cancel
	{
		//confirmWindowContent = "This order cannot be cancelled as it is active for the current date. Clicking OK to this message will update the To date of the order as " + servingDate + ". Do you wish to continue? "; //Commented Against PMG2013-CRF-0009.1-US002		
		if(dietCategory=="NBM"){
		var database_system_date_time = getCurrentDate("DMYHM",'en');
		servingDate=database_system_date_time;
		}	
		dateTo = servingDate;
		if(dietCategory=="NBM"){
			nilToDate = servingDate;
		}
		activeOrderFlag = "Y";
	//Added Against PMG2013-CRF-0009.1-US002 Starts Here
		await ComplaintReasons();		
		Cancelled_Reason = returnReasons;
		if(returnReasons != null && returnReasons != ""){
			var checkFlag = "Y";			
		}else{
			var checkFlag = "N";
		}		
	}
	else{
		//confirmWindowContent = "Are you sure you wish to cancel this order?";//Commented Against PMG2013-CRF-0009.1-US001
		await ComplaintReasons();
		Cancelled_Reason = returnReasons;//Added Against cancelreason issue(PMG2013-CRF-0009.1-US004)
		if(returnReasons != null && returnReasons != ""){
			var checkFlag = "Y";
		}else{
			var checkFlag = "N";
		}		
	}	
	//if(window.confirm(confirmWindowContent)) //Commented Against PMG2013-CRF-0009.1-US001
	if(checkFlag != "" && checkFlag == "Y")
	//Added Against PMG2013-CRF-0009.1-US002 Ends Here
	{
		var facilityId = document.getElementById("addedFacilityId").value;
		var xmlStr = "<root><SEARCH";
		xmlStr += " /></root>";
		var mode = "cancelMealContents";
		var paramVal = "&facilityId="+facilityId+
								"&patientClass="+patientClass+
								"&encounterId="+encounterId+
								"&profileSL="+profileSL+
								"&dateFrom="+dateFrom+
								"&dateTo="+dateTo+
								"&activeOrderFlag="+activeOrderFlag+
								"&nilFromDate="+nilFromDate+
								"&nilToDate="+nilToDate+
								"&mode="+mode+
								"&Actual_todate="+Actual_todate+
								"&Cancelled_Reason="+Cancelled_Reason;//Added Against PMG2013-CRF-0009.1-US002
		var updateUrl = "../../servlet/eDS.PlaceDietOrderServlet?"+paramVal;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", updateUrl, false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);
			arrVal = new Array();
			var tableObj3 = document.getElementById("result_Id");
			while (tableObj3.rows.length > 1)
				tableObj3.deleteRow(1);
			fecthMealContents();
			getDieticianFlag(); //CRF-410
	}
}

function verifyOrdersForCancellation(encounterId, addedFacilityId, fromDate, dateTo, selectedProfile)
{
	var mode = "verifyOrdersForCancellation";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&fromDate="+fromDate
	+"&dateTo="+dateTo
	+"&selectedProfile="+selectedProfile
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var ordersForCancellation = localTrimString(xmlHttp.responseText);
	return ordersForCancellation;
}

function checkStatus(status, object)
{
	var statusArr = new Array();
	if(status.indexOf("~") != -1)
		statusArr = status.split("~");
	else
		statusArr[0] = status;
	if(object)
	{
		for(var i=0; i<object.length; i++)
		{
			if(status!="")
			{
				//if(object[i].value == status)
				if($.inArray(object[i].value, statusArr) > -1)
				{
					var obj = document.all(object[i].value);
					if(obj)
					{
						if (obj.length > 1)
						{
							for (var j = 0; j < obj.length; j++)
							{
								obj[j].style.display = "inline";
							}
						}
						else
						{
					   if(obj.length == 0 ) // Added for AMRI-SCF-0385 [IN056722]
						{
							if(obj!="" && obj!=null && obj!="undefined" && obj!=undefined)//CRF-410
							obj.style.display = "inline";
						}

						}
					}
				}
				else
				{
					var obj = document.all(object[i].value);
					if (obj)
					{
						if (obj.length > 1)
						{
							for (var k = 0; k < obj.length; k++)
							{
								obj[k].style.display = "none";
							}
						}
						else
						{
							if(obj.length == 0) // Added for AMRI-SCF-0385 [IN056722]
							{
							obj.style.display = "none";
							}
						}
					}
				}
			}
			else
			{
				var obj = document.all(object[i].value);
				if (obj)
				{
					if (obj.length > 1)
					{
						for (var iter = 0; iter < obj.length; iter++)
						{
							obj[iter].style.display = "inline";
						}
					}
					else
					{
						if(obj.length == 0) // Added for AMRI-SCF-0385 [IN056722]
							{
						obj.style.display = "inline";
						}
					}
				}
			}
		}
	}
}

function toLoadDetails(arrVal)
{
	//CRF-0684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	exclusionFlag=false;//CRF-428
	var tableObj3 = document.getElementById("result_Id");
	var recordToUpdate = -1;
	var recordToUpdate_new = -1;//410
	var futurenbmcount=0,futureorder=0;//410
	var activenbmcount=0,activeorder=0;//410
	var row_ind = 1;
	var servingDate = $('#servingDate').val();
	while (tableObj3.rows.length > 1)
		tableObj3.deleteRow(1);
	var dateFrom = '';
	var profileSL="";
	var temp="";//AMRI-SCF-0385 [IN:056722]
	var textureOfDiet="",preparatoryInstructions="";//412
	var actualvaluetoupdate=-1;////CRF-410
	for(var j=0; j < arrVal.length;)
	{
		var newRow = tableObj3.insertRow(row_ind);
		var newCellitemType = newRow.insertCell(newRow.cells.length);
		var cell1=newRow.insertCell(0);
		var cell2=newRow.insertCell(1);
		var cell3=newRow.insertCell(2);
		var cell4=newRow.insertCell(3);
		var cell5=newRow.insertCell(4);
		var tempdietCategory=trim(arrVal[j+0]);//410 5th dec
		//if(tempdietCategory!="NBM"){
		if(trim(arrVal[j+0]) != null && trim(arrVal[j+0]) != ""){
			var dietCategory = trim(arrVal[j+0]);
		}
		if(arrVal[j+1] != null)
			var mealClass =trim(arrVal[j+1]);

		if(arrVal[j+2] == " null")
		{
			arrVal[j+2] ="";
			var feedType = trim(arrVal[j+2]);
		}
		else if(arrVal[j+2] != null)
			var feedType = trim(arrVal[j+2]);

		if(arrVal[j+3] != null)
		var dietType = trim(arrVal[j+3]);
			
			
		if(arrVal[j+4] == " null")
		{
			arrVal[j+4] = "";
			document.getElementById("feedingInstructions").value = trim(arrVal[j+4]);
		}
		else if(arrVal[j+4] != null)
			document.getElementById("feedingInstructions").value = trim(arrVal[j+4]);

		if(arrVal[j+5] == " null")
		{
			arrVal[j+5] = "";
			var dsDeliveryInstr =trim(arrVal[j+5]);
		}
		else if(arrVal[j+5] != null)
			var dsDeliveryInstr = trim(arrVal[j+5]);

		if(arrVal[j+6] != null)
			var patientClass = trim(arrVal[j+6]);

		if(arrVal[j+7] != null)
			var encounterId = trim(arrVal[j+7]);

		if(arrVal[j+8] != null)
			profileSL = trim(arrVal[j+8]);

		if(arrVal[j+9] != null)
			dateFrom = trim(arrVal[j+9]);

		if(dateFrom != null)
			document.getElementById("testDate").value = dateFrom;

		if(arrVal[j+10] == " null")
		{
			arrVal[j+10] = "";
			var dateTo = trim(arrVal[j+10]);
		}
		else if(arrVal[j+10] !=  null)
			var dateTo = trim(arrVal[j+10]);

		if(arrVal[j+12] != null)
			var status = trim(arrVal[j+12]);

		if(arrVal[j+14] == " null")
		{
			arrVal[j+14] = "";
			var nilFromDate =trim(arrVal[j+14]);
		}
		else if(arrVal[j+14] != null)
			var nilFromDate = trim(arrVal[j+14]);

		if(arrVal[j+15] == " null")
		{
			arrVal[j+15] = "";
			var nilToDate =trim(arrVal[j+15]);
		}
		else if(arrVal[j+15] != null)
			var nilToDate = trim(arrVal[j+15]);

		if(arrVal[j+17] != null)
			var orderID =trim(arrVal[j+17]);

		if(arrVal[j+18] == " null")
		{
			arrVal[j+18] = "";
			document.getElementById("prepInstr").value = trim(arrVal[j+18]);
		}
		else if(arrVal[j+18] != null)
			document.getElementById("prepInstr").value = trim(arrVal[j+18]);

		if(arrVal[j+20] != null)
		{
			if(trim(arrVal[j+20]) == "Y")
				document.getElementById("dieticianReferral").checked = true;
			else
				document.getElementById("dieticianReferral").checked = false;
		}

		if(arrVal[j+21] != null)
			document.getElementById("hdrFlag").value = trim(arrVal[j+21]);

		if(arrVal[j+22] != null && arrVal[j+22] != "")
			document.getElementById("remarks").value = trim(arrVal[j+22]);
		else
			document.getElementById("remarks").value = "";
		if(arrVal[j+23] != null && arrVal[j+23] != "")
		document.getElementById("atndInstr").value = trim(arrVal[j+23]);//Commented against ML-MMOH-SCF-0735
		//CRF-412
		
		if(arrVal[j+24] != null && arrVal[j+24] != ""){
			textureOfDiet=trim(arrVal[j+24]);
			//document.getElementById("texture_of_diet").value = textureOfDiet;	
			document.getElementById("texture_of_diet").value = trim(arrVal[j+24]);	
			}			
			
		if(arrVal[j+24] == " null")
		{
			arrVal[j+24] ="";
			var textureOfDiet = trim(arrVal[j+24]);
		}
		else if(arrVal[j+24] != null)
			var textureOfDiet = trim(arrVal[j+24]);			
		
		if(arrVal[j+18]=="null"){
			arrVal[j+18]="";
			preparatoryInstructions=trim(arrVal[j+18]);
		}else if(arrVal[j+18]!=null){
			preparatoryInstructions=trim(arrVal[j+18]);
		}
		
		//Added Against ML-MMOH-CRF-0684 starts Here	
        if(isMenuType=="true"){		
		if(arrVal[j+25] == "null")
		{
			arrVal[j+25] ="";
			var menu_type = trim(arrVal[j+25]);
		}
		else if(arrVal[j+25] != null)
		{
			var menu_type = trim(arrVal[j+25]);
		}
		}
			//Added Against ML-MMOH-CRF-0684 Ends Here
			
		//}//410 ends 5th dec
		/*else if(tempdietCategory=="NBM"){
			var dietCategory = trim(arrVal[j+0]);
			var mealClass =trim(arrVal[j+1]);
			arrVal[j+2] ="";
			var feedType = trim(arrVal[j+2]);
			var dietType = trim(arrVal[j+3]);
			arrVal[j+4] = "";
			document.getElementById("feedingInstructions").value = trim(arrVal[j+4]);
			document.getElementById("feedingInstructions").value = trim(arrVal[j+4]);
			arrVal[j+5] = "";
			var dsDeliveryInstr =trim(arrVal[j+5]);
			var nilFromDate = trim(arrVal[j+14]);
			var nilToDate =trim(arrVal[j+15]);
			profileSL = trim(arrVal[j+8]);
			dateFrom = trim(arrVal[j+9]);
			var dateTo = trim(arrVal[j+10]);
			document.getElementById("testDate").value = dateFrom;
			document.getElementById("hdrFlag").value = trim(arrVal[j+21]);			
			var status = trim(arrVal[j+12]);
		}*/
		//CRF-412
		if(status == "A")
		{
			var feedInstr=document.getElementById("feedingInstructions").value;
			var feedInstr_escaped_string=feedInstr.replace(/[\"]/g, '\\"')
		      .replace(/[\\]/g, '\\\\')
		      .replace(/[\/]/g, '\\/')
		      .replace(/[\b]/g, '\\b')
		      .replace(/[\f]/g, '\\f')
		      .replace(/[\n]/g, '\\n')
		      .replace(/[\r]/g, '\\r')
		      .replace(/[\t]/g, '\\t');
			
			cell1.innerHTML = "";
			cell2.innerHTML = "<a href='#' onclick=\"return Update('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"','','','"+textureOfDiet+"','"+preparatoryInstructions+"','"+menu_type+"');\">"+arrVal[j+3]+"</A>";//CRF-412 and 60675
			
			if(trim(arrVal[j+10]))
				cell3.innerHTML=arrVal[j+9]+"-"+trim(arrVal[j+10]);
			else
				cell3.innerHTML=arrVal[j+9];
			cell4.innerHTML=arrVal[j+11];
			cell5.innerHTML=arrVal[j+19];

			cell1.setAttribute("id","A");
			cell2.setAttribute("id","A");
			cell3.setAttribute("id","A");
			cell4.setAttribute("id","A");
			cell5.setAttribute("id","A");

			cell2.style.color = "Blue";
			cell2.style.fontWeight='bold';
			temp=profileSL;//AMRI-SCF-0385 [IN:056722]
		}
		else if(status == "C")
		{
			cell1.innerHTML = "";
			cell2.innerHTML = arrVal[j+3];
			if(trim(arrVal[j+10]))
				cell3.innerHTML=arrVal[j+9]+"-"+trim(arrVal[j+10]);
			else
				cell3.innerHTML=arrVal[j+9];
			cell4.innerHTML=arrVal[j+11];
			cell5.innerHTML=arrVal[j+19];

			cell1.setAttribute("id","C");
			cell2.setAttribute("id","C");
			cell3.setAttribute("id","C");
			cell4.setAttribute("id","C");
			cell5.setAttribute("id","C");

			cell2.style.color = "GREY";
			cell2.style.fontWeight='bold';
			temp=profileSL;//AMRI-SCF-0385 [IN:056722]
		}
		else if(status == "F")
		{
			var feedInstr=document.getElementById("feedingInstructions").value;

			var feedInstr_escaped_string=feedInstr.replace(/[\"]/g, '\\"')
		      .replace(/[\\]/g, '\\\\')
		      .replace(/[\/]/g, '\\/')
		      .replace(/[\b]/g, '\\b')
		      .replace(/[\f]/g, '\\f')
		      .replace(/[\n]/g, '\\n')
		      .replace(/[\r]/g, '\\r')
		      .replace(/[\t]/g, '\\t');

			if(servingDate != dateTo)
				cell1.innerHTML = "<a href='#' onclick=\"return cancelMealOrder('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"');\">"+"<img src='../../eCommon/images/RRnwd.gif' alt='Cancel Order' />"+"</A>";
			else
				cell1.innerHTML = "";
			//cell2.innerHTML = "<a href='#' onclick=\"return reloadUpdate('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"','"+textureOfDiet+"');\">8138"+arrVal[j+3]+"text-->"+textureOfDiet+"feedType-->"+feedType+"</A>";//CRF-412

			cell2.innerHTML = "<a href='#' onclick=\"return reloadUpdate('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"','"+textureOfDiet+"','"+preparatoryInstructions+"','"+menu_type+"');\">"+arrVal[j+3]+"</A>";//CRF-412
			if(trim(arrVal[j+10]))
				cell3.innerHTML=arrVal[j+9]+"-"+trim(arrVal[j+10]);
			else
				cell3.innerHTML=arrVal[j+9];

			cell4.innerHTML=arrVal[j+11];
			cell5.innerHTML=arrVal[j+19];

			cell1.setAttribute("id","F");
			cell2.setAttribute("id","F");
			cell3.setAttribute("id","F");
			cell4.setAttribute("id","F");
			cell5.setAttribute("id","F");

			cell2.style.color = "GREY";
			cell2.style.fontWeight='bold';
			//recordToUpdate = j;
			//CRF-410 starts
			/*
			if(dietCategory=="NBM"){
			futureorder=1;
			if(recordToUpdate_new==-1){

				++futurenbmcount;
				
				recordToUpdate_new = j-25;//vikash 14-Dec
			}else{
				recordToUpdate_new = recordToUpdate_new-25;
			}
			}else{
				++futureorder;
				futurenbmcount=1;
			}
			*/
			//future order starts 15-Dec
			if(dietCategory=="NBM"){
				
				//futureorder=0;

				if(recordToUpdate_new==-1){
					recordToUpdate_new=j-25;
					++futurenbmcount;
				}else{

					++futurenbmcount;
					recordToUpdate_new=j-(futurenbmcount*25);
					//++futurenbmcount;
				}
				
			}else{
				++futureorder;
				futurenbmcount=0;
				recordToUpdate_new=-1;
			}
			//future order ends 15-Dec
			recordToUpdate = j;
			if(tempdietCategory!="NBM"){
			actualvaluetoupdate=recordToUpdate;
		}
			//CRF-410 ends
			temp=profileSL;//AMRI-SCF-0385 [IN:056722]
		}
		else if(status == "X")
		{
			cell1.innerHTML = "";
			cell2.innerHTML = '<strike>' + arrVal[j+3] + '</strike>';
			if(trim(arrVal[j+10]))
				cell3.innerHTML = '<strike>' + arrVal[j+9]+"-"+trim(arrVal[j+10]) + '</strike>';
			else
				cell3.innerHTML = '<strike>' + arrVal[j+9] + '</strike>';

			cell4.innerHTML = '<strike>' + arrVal[j+11] + '</strike>';
			cell5.innerHTML = '<strike>' + arrVal[j+19] + '</strike>';

			cell1.setAttribute("id","X");
			cell2.setAttribute("id","X");
			cell3.setAttribute("id","X");
			cell4.setAttribute("id","X");
			cell5.setAttribute("id","X");

			cell2.style.color = "GREY";
			cell2.style.fontWeight='bold';

		}
		else if(status == "")
		{
			var feedInstr=document.getElementById("feedingInstructions").value;
			var feedInstr_escaped_string=feedInstr.replace(/[\"]/g, '\\"')
		      .replace(/[\\]/g, '\\\\')
		      .replace(/[\/]/g, '\\/')
		      .replace(/[\b]/g, '\\b')
		      .replace(/[\f]/g, '\\f')
		      .replace(/[\n]/g, '\\n')
		      .replace(/[\r]/g, '\\r')
		      .replace(/[\t]/g, '\\t');

			if(servingDate != dateTo || dietCategory=="NBM")//CRF-410
				cell1.innerHTML = "<a href='#' onclick=\"return cancelMealOrder('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"');\">"+"<img src='../../eCommon/images/RRnwd.gif' alt='Cancel Order' />"+"</A>";
				
			else			
				cell1.innerHTML = "";				
			
			//cell2.innerHTML = "<a href='#' onclick=\"return reloadUpdate('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"','"+textureOfDiet+"');\">8195"+arrVal[j+3]+"text->"+textureOfDiet+"feedType-->"+feedType+"</A>";//Added against 059404 & //CRF-412
			//CRF-410
			/*if(dietCategory=="NBM"){
				 $("#Full_Day_NBM_YN").prop("checked", true);
				 enableDisableField();enableMandatory();				 
			}*/
			cell2.innerHTML = "<a href='#' onclick=\"return reloadUpdate('" + dietCategory + "','"+mealClass+"','"+feedType+"','"+dietType+"','"+feedInstr_escaped_string+"','"+dsDeliveryInstr+"','"+patientClass+"','"+encounterId+"','"+profileSL+"','"+dateFrom+"','"+dateTo+"','"+nilFromDate+"','"+nilToDate+"','"+textureOfDiet+"','"+preparatoryInstructions+"','"+menu_type+"');\">"+arrVal[j+3]+"</A>";//Added against 059404 & //CRF-412
			if(trim(arrVal[j+10]))
				cell3.innerHTML=arrVal[j+9]+"-"+trim(arrVal[j+10]);
			else
				cell3.innerHTML=arrVal[j+9];
			cell4.innerHTML=arrVal[j+11];
			cell5.innerHTML=arrVal[j+19];

			cell1.setAttribute("id","A");
			cell2.setAttribute("id","A");
			cell3.setAttribute("id","A");
			cell4.setAttribute("id","A");
			cell5.setAttribute("id","A");

			cell2.style.color = "Blue";
			cell2.style.fontWeight='bold';
			//recordToUpdate = j;
			/*
			if(dietCategory=="NBM"){
			activeorder=1;

			++activenbmcount;
			if(recordToUpdate_new==-1){
			recordToUpdate_new = j-25;//vikash 14-Dec
			}else{
				recordToUpdate_new = recordToUpdate_new-25;
			}
			
			}else{
				activenbmcount=1;
				++activeorder;
			}
			*/
			//active order starts 15-Dec
			if(dietCategory=="NBM"){
				
				activeorder=0;

				if(recordToUpdate_new==-1){
					recordToUpdate_new=j-25;
					++activenbmcount;
				}else{
					
					//recordToUpdate_new=(activenbmcount*j)-25;
					recordToUpdate_new=j-(activenbmcount*25);
					++activenbmcount;
				}
				
			}else{
				++activeorder;
				activenbmcount=0;
				recordToUpdate_new=-1;
			}
			//active order ends 15-Dec
			
			
			recordToUpdate = j;
			temp=profileSL;//AMRI-SCF-0385 [IN:056722]
			if(tempdietCategory!="NBM"){
			actualvaluetoupdate=recordToUpdate;
		}
		}
		//CRF-410
		/* if(tempdietCategory!="NBM"){
			actualvaluetoupdate=recordToUpdate;
		} */
		//CRF-410
		//j = j + 25;//CRF-412//CRF-684
		j = j + 26;//Added against ML-MMOH-CRF-0684
	}
	document.getElementById("maxprofileSL").value = profileSL;
	/*AMRI-SCF-0385 [IN:056722]  maxActiveprofileSL: maximum profileSL value, considering only the active (non-cancelled) profiles*/
	document.getElementById("maxActiveprofileSL").value = temp;
	//recordToUpdate = toLoadDetails(arrVal);//vikash
	//recordToUpdate="1";
	if(recordToUpdate >= 0)
	{
	//CRF-410
	//var temp_diet_category=trim(arrVal[recordToUpdate+0]);

		//if(temp_diet_category!="NBM"){
        if(isMenuType == "true"){
			Update(trim(arrVal[recordToUpdate+0]), trim(arrVal[recordToUpdate+1]), trim(arrVal[recordToUpdate+2]), trim(arrVal[recordToUpdate+3]), trim(arrVal[recordToUpdate+4]), trim(arrVal[recordToUpdate+5]), trim(arrVal[recordToUpdate+6]), trim(arrVal[recordToUpdate+7]), trim(arrVal[recordToUpdate+8]), trim(arrVal[recordToUpdate+9]), trim(arrVal[recordToUpdate+10]), trim(arrVal[recordToUpdate+14]), trim(arrVal[recordToUpdate+15]),'','',trim(arrVal[recordToUpdate+24]),trim(arrVal[recordToUpdate+18]),trim(arrVal[recordToUpdate+25]));//CRF-412 aand 60675 & CRF-410 & CRF-684
			fecthDietTypeToMealClass();
			updatedDietTypes(trim(arrVal[recordToUpdate+8]), encounterId);
		}
		else {
			Update(trim(arrVal[recordToUpdate+0]), trim(arrVal[recordToUpdate+1]), trim(arrVal[recordToUpdate+2]), trim(arrVal[recordToUpdate+3]), trim(arrVal[recordToUpdate+4]), trim(arrVal[recordToUpdate+5]), trim(arrVal[recordToUpdate+6]), trim(arrVal[recordToUpdate+7]), trim(arrVal[recordToUpdate+8]), trim(arrVal[recordToUpdate+9]), trim(arrVal[recordToUpdate+10]), trim(arrVal[recordToUpdate+14]), trim(arrVal[recordToUpdate+15]),'','',trim(arrVal[recordToUpdate+24]),trim(arrVal[recordToUpdate+18]));//CRF-412 aand 60675 & CRF-410 & CRF-684
			fecthDietTypeToMealClass();
			updatedDietTypes(trim(arrVal[recordToUpdate+8]), encounterId);			
		}
		//}//CRF-410
	}
	//recordToUpdate_new=recordToUpdate-(nbmcount*25);
	//CRF-410
	if(activeorder==1 && activenbmcount==1){
		recordToUpdate=-1;	
	}
	//recordToUpdate=325;
	//return recordToUpdate;	
	
	if(recordToUpdate_new==-1 && (futureorder>0 || activeorder>0)){
		recordToUpdate_new=recordToUpdate;	
	}
	
	if(activeorder==0 && futureorder==0){
		recordToUpdate_new=-1;
	}
//	return recordToUpdate_new;//Vikash 14-Dec
	return actualvaluetoupdate;
	//CRF-410
}

//Function: TO Restrict usage of comma::
function restrictComma(event) {
	var strCheck = ',';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) != -1)
	{
		window.event.keyCode = 27;
		return false;
	}
	return true ;
}

// AAKH-CRF-0065 start
function showHideTab(val)
{
	if($("#showHideTab"+val).is(':visible'))
	{
		$("#showHideArrow"+val).attr("src", '../../eDS/css/arrow-down.png');
		$("#showHideTab"+val).hide();
	}
	else
	{
		$("#showHideArrow"+val).attr("src", '../../eDS/css/arrow-up.png');
		$("#showHideTab"+val).show();
	}
}

// AAKH-CRF-0065 Sp2Us2Us3 start
function chkUnchkAll(selChkboxVal)
{
	var selValTotalSize = $('#tabSize'+selChkboxVal).val();
	if($("#serveChkUnchkAll"+selChkboxVal).is(':checked'))
	{
		for(var i=0; i<selValTotalSize; i++)
		{
			if(!$("#serveChkUnchk"+selChkboxVal+i).is(':checked'))
			{
				$("#serveChkUnchk"+selChkboxVal+i).prop("checked", true);
				$("#serveChkUnchk"+selChkboxVal+i).click();
				$("#serveChkUnchk"+selChkboxVal+i).prop("checked", true);
			}
		}
	}
	else
	{
		for(var i=0; i<selValTotalSize; i++)
		{
			if($("#serveChkUnchk"+selChkboxVal+i).is(':checked'))
			{
				$("#serveChkUnchk"+selChkboxVal+i).prop("checked", false);
				$("#serveChkUnchk"+selChkboxVal+i).click();
				$("#serveChkUnchk"+selChkboxVal+i).prop("checked", false);
			}
		}
	}
	chkUnchkFn(selChkboxVal);
}

function chkUnchkFn(selVal)
{
	var selValTotalSize = $('#tabSize'+selVal).val();
	var chkdCnt = 0;
	for(var i=0; i<selValTotalSize; i++)
	{
		if($("#serveChkUnchk"+selVal+i).is(':checked'))
			chkdCnt++;
	}
	if(chkdCnt == selValTotalSize)
		$("#serveChkUnchkAll"+selVal).prop("checked", true);
	else
		$("#serveChkUnchkAll"+selVal).prop("checked", false);
}
// AAKH-CRF-0065 Sp2Us2Us3 end

function closeWindow()
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=chkSessionVal";
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var attendantRadio = false;
	attendantRadio = document.getElementById('Suballocator').checked;
	var isMACNBM = document.getElementById("isMACNBM").value;
	
	if(isMACNBM && attendantRadio) //Added Against ICN:17117 ML-MMOH-CRF-1460
	{
			closeWindowFlag = true;
			top.close();
		}
		else
	{
	if(chkFormValChange || retVal == 'true')
	{
		if(window.confirm(getMessage("DS_DISCARD_CHANGES","DS")))
		{
			closeWindowFlag = true;
			top.close();
		}
	}
	//CRF-428
	else if(exclusionFlag==true) {
		if(window.confirm("The Changes to Meal Exclusions will not be Saved. Are you sure you wish to continue?"))
		{
			closeWindowFlag = true;
			top.close();
		}
	}
	//CRF-428
	else
		top.close();
}
}
// AAKH-CRF-0065 end

//MMOH-CRF-427

function grayOutCalendar(fieldid,p_maxdate,locale){
		var dt=new Date();
		var c_date=dt.getDate();
		var c_month=dt.getMonth();
		var c_year=dt.getFullYear();
		if(locale=="th"){
			c_year=c_year+543;
		}
		var setdate=new Date(c_year,c_month,c_date);
		var max_date=addDays(setdate,p_maxdate);
		var Full_Day_NBM_Checked=$("#Full_Day_NBM_YN").is(':checked');//CRF-410 - 63000
		$.datepicker.setDefaults($.extend({showMonthAfterYear: false}, $.datepicker.regional[locale]));
		$("#"+fieldid).datepicker({
		dateFormat:'dd/mm/yy',
		minDate:setdate ,
		maxDate:max_date,
		showOn: 'image',
		changeYear:true,
		//410 starts
		//if(fieldid=="from"){
		onSelect: function(datetext){
		if(fieldid=="from" && Full_Day_NBM_Checked){//CRF-410 - 63000
        	var d = new Date(); //for now

		var day=d.getDate();
		day=(day<10)?("0"+day):day;
		var month=d.getMonth();
		//month=(month<10)?("0"+month):month;
		month=month+1;
		month=(month<10)?("0"+month):month;//Jan 2nd - CRF-410
		
		var year=d.getFullYear();
		var currentdate=day+"/"+month+"/"+year;

	        var h = d.getHours();
	        h = (h < 10) ? ("0" + h) : h;

	        var m = d.getMinutes();
	        m = (m < 10) ? ("0" + m) : m;

	        var s = d.getSeconds();
	        s = (s < 10) ? ("0" + s) : s;
		
		if(currentdate==datetext){
			datetext = datetext +" "+h+":"+m;
		}else{
		h="00";
		m="00";
       		datetext = datetext + " " + h + ":" + m;
		}
        	$('#'+fieldid).val(datetext);
		}//inner if
		else if(fieldid=="to" && Full_Day_NBM_Checked){//CRF-410 - 63000
			datetext=datetext+" 23:59";
			$('#'+fieldid).val(datetext);
		}
    },
	onClose: function() {
    //$(this).data('datepicker').inline = false;
	//$('#'+fieldid).datepicker('hide');

	//$("#"+fieldid).datepicker("enable");
	//$("#"+fieldid).datepicker("disable");
	}
	//}//if ends//410 ends
		});
			$('#'+fieldid).focusin(function(){
			$('#'+fieldid).datepicker('widget').css({top: '25%',left: '50%'});
		});
		$('#'+fieldid).datepicker('show');
}

//MMOH-CRF-427
function grayOutCalendarValidation(p_selecteddate,p_maxdate){

	var maxdate=p_maxdate;
	var date = addDays(new Date(), p_maxdate);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var locale=document.getElementById("language_Id").value;
	var selecteddate=p_selecteddate;

	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }
	var futDate=date1 + "/" + month + "/" + year;
	selecteddate = convertDate(selecteddate,'DMY',locale,'en');

	var flag = compareDate(futDate,selecteddate);
	if(flag==-1){
			return false;
		   }
	else{
		var sysdate=getCurrentDate("DMH",'en');
		flag=compareDate(selecteddate,sysdate);
		if(flag==-1){
			return false;
		}else{
		return true;
		}
	}
}

function grayOutDateTimeCalendarValidation(p_selecteddate,p_maxdate){
	var maxdate=p_maxdate;
	var date = addDays(new Date(), p_maxdate);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var hour=date.getHours();
	var minute=date.getMinutes();
	var locale=document.getElementById("language_Id").value;
	var selecteddate=p_selecteddate;

	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }
	var futDate=date1 + "/" + month + "/" + year+" "+hour+":"+minute;
	selecteddate = convertDate(selecteddate,'DMYHM',locale,'en');
	var flag = compareDate(futDate,selecteddate);
	if(flag==-1){
			return false;
		   }
	else{
		var sysdate=getCurrentDate("DMYHM",'en');
		flag=compareDate(selecteddate,sysdate);
		if(flag==-1){
			return false;
		}else{
		return true;
		}
	}
}

function addDays(theDate, days) {
    return new Date(theDate.getTime() + days*24*60*60*1000);

}

function changeDate(date){
	//var date= new Date(theDate.getTime() + days*24*60*60*1000);
	var date1=date.getDate();
	var month=date.getMonth();
	var year=date.getFullYear();
	var locale=document.getElementById("language_Id").value;
	month+=1;
		if(date1<=9){
				date1="0"+""+date1;
			    }
		if(month<=9){
				month="0"+""+month;
			    }
	var futDate=date1 + "/" + month + "/" + year;
	futDate = convertDate(futDate,'DMY','en',locale);
	return futDate;
}

//MMOH-CRF-427
function grayOutCalendarDateTime(fieldid,p_maxdate,locale){
	//410
	Full_Day_NBM_YN=$("#Full_Day_NBM_YN").is(':checked');
	
	if(Full_Day_NBM_YN){
		grayOutCalendar(fieldid,p_maxdate,locale);
	}else{
	//410
	var dt=new Date();
	var c_date=dt.getDate();
	var c_month=dt.getMonth();
	var c_year=dt.getFullYear();
	if(locale=="th"){
	c_year=c_year+543;
	}
	var setdate=new Date(c_year,c_month,c_date);
	var max_date=addDays(setdate,p_maxdate);
	$.datepicker.setDefaults($.extend({showMonthAfterYear: false}, $.datepicker.regional[locale]));
	$.timepicker.setDefaults($.datepicker.regional[locale]);
	$("#"+fieldid).datetimepicker({
	dateFormat:'dd/mm/yy',
	minDate:setdate ,
	maxDate:max_date,
	showOn: 'image',
	//maxDate:100,
	changeYear:true
	});

	$('#'+fieldid).focusin(function(){
    $('#'+fieldid).datepicker('widget').css({top: '25%',left: '50%'});
	});
	$('#'+fieldid).datepicker('show');
	}//else ends 410
}

async function showModalWindow(fieldid,p_maxdate,locale)
{
		var dialogHeight= "5" ;
		var dialogWidth	= "5" ;
		var status = "no";
		//var arguments = "";
		var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
		var  dateValue= await window.showModalDialog('../../eDS/jsp/CommonGrayOutCalendar.jsp?p_maxdate='+p_maxdate+"&locale="+locale);
}

//ML-MMOH-CRF-409 starts
function checkTimeRange(obj1,obj2,obj3){

	var dt=new Date();
	var c_date=dt.getDate();
	var c_month=dt.getMonth();
	var c_year=dt.getFullYear();
	var c_hour=dt.getHours();
	var c_min=dt.getMinutes();

	var dateFrom=obj3;

	var dateFromArr=dateFrom.split("/");
	var f_date=dateFromArr[0];
	var f_month=dateFromArr[1]-1;
	var f_year=dateFromArr[2];

	var s1=obj1.split(":");
	var s2=obj2.split(":");

	var setdate=new Date(f_year,f_month,f_date,c_hour,c_min);

	var start_time=new Date(c_year,c_month,c_date,s1[0],s1[1]);
	var end_time=new Date(c_year,c_month,c_date,s2[0],s2[1]);

	var range  = moment.range(start_time, end_time);

	var flag=range.contains(setdate); // true

	return flag;
}
//ML-MMOH-CRF-409 ENDS
// changes for ML-MMOH-CRF-0428 STARTS
async function openExclusionsWindow(obj) {
	var encounterId = document.getElementById("encounterId").value;
	var patientClass = document.getElementById("patientClass").value;
	var profileSL= document.getElementById("profileSL").value;
	var facilityId=document.getElementById("addedFacilityId").value;
	var restrict_date_inpatients_yn=document.getElementById("restrict_date_inpatients_yn").value;
	var maximum_days_allowed=document.getElementById("maximum_days_allowed").value;
	var order_from_date=document.getElementById("dateFrom").value;
	var order_to_date=document.getElementById("dateTo").value;
	var profileFlag=$('#profileFlag').val();

	var dialogUrl1 = "../../eDS/jsp/MealExclusions.jsp?&encounterId="+encounterId+"&profileSL="+profileSL+"&fetchedMealTypesWithTime="+fetchedMealTypesWithTime+"&restrict_date_inpatients_yn="+restrict_date_inpatients_yn+"&maximum_days_allowed="+maximum_days_allowed+"&order_from_date="+order_from_date+"&order_to_date="+order_to_date;
	var obj={};//CRF-428
	
	obj.mealTypes=fetchedMealTypesWithTime;
	obj.excludedMealTypes= excludedMeals;
	var dialogArguments = obj;
	//var dialogFeatures = "dialogHeight:35;dialogWidth:50;status:no;scroll:no";
	//CRF-428
	//excludedMeals = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	var dialogTop   = "65";
    var dialogHeight    = "600px" ; //30.5
    var dialogWidth = "900px" ;
    var arguments   = "" ;
    var dialogFeatures    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	var test =await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	excludedMeals=test.excludedMealTypes;
	
	if(exclusionFlag==false)exclusionFlag=test.changedFlag;
	updateExclusionsPane();
	/*if (!(JSON.stringify(obj.excludedMealTypes) === JSON.stringify(test))) {
		exclusionFlag=true;
	}*/
	//CRF-428
}
function addAutomaticExclusions() {
	var fromDate=$("#dateFrom").val();
	var today=moment().format("DD/MM/YYYY");
	automatic_excluded_meal_types=new Array();
	if (fromDate==today) {
	 $.each(fetchedMealTypesWithTime,function(index) {
		 	var mealTypeCode=this.Meal_Code;
			var irreg_end_time=this.Irregular_End_Time;
			var next_meal_start_time=this.Next_Meal_Start_Time;
			var endTime=irreg_end_time;
			if (endTime=="") endTime=next_meal_start_time;
			var currentTimeObj=moment();
			var endTimeObj=moment(endTime,'HH:mm');
			var duration = moment.duration(endTimeObj.diff(currentTimeObj));
			var hours = duration.asHours();
			if(hours<0) addMealTypeToExclusion(today,mealTypeCode);
	 });
	}
}
function addMealTypeToExclusion(today,mealTypeCode) {
	if(excludedMeals[today]==null){
		excludedMeals[today]={};
		excludedMeals[today][mealTypeCode]="Y";
		automatic_excluded_meal_types.push(mealTypeCode);
	}
	else  {
		if(excludedMeals[today][mealTypeCode]==null) {
			excludedMeals[today][mealTypeCode]="Y";
			automatic_excluded_meal_types.push(mealTypeCode);
		}
		if(excludedMeals[today][mealTypeCode]=="N") {
			excludedMeals[today][mealTypeCode]="Y";
			automatic_excluded_meal_types.push(mealTypeCode);
		}
	}
}
getMealTypeDesc = function (mealTypeCode) {
	var desc="";
	$.each(fetchedMealTypesWithTime,function(index) {
	if(this.Meal_Code==mealTypeCode){
		desc=this.Short_Desc;
	}
});
return desc;
}
//CRF-428
function checkExclusions(obj) {
	var temp=obj.oldvalue;
	var flag=jQuery.isEmptyObject(excludedMeals);

	if(obj.oldvalue!=null && (obj.oldvalue!=obj.value)) {
		if(flag==false) {
			if(window.confirm("The Changes to Meal Exclusions will be discarded. Are you sure you wish to continue?"))
			{
				obj.oldvalue=obj.value;
				excludedMeals={};
				exclusionFlag=false;
				updateExclusionsPane();
			}
			else obj.value=temp;
		}
		else obj.oldvalue=obj.value;
	}
	else obj.oldvalue=obj.value;
}


function checkExclusions_select(obj) {
	document.getElementById("diettype_auto").value="";//Added Against ML-MMOH-CRF-0674
	var temp=obj.oldvalue;
	var flag=jQuery.isEmptyObject(excludedMeals);

	if(flag==false) {
		if(window.confirm("The Changes to Meal Exclusions will be discarded. Are you sure you wish to continue?"))
		{
			obj.oldvalue=obj.value;
			excludedMeals={};
			exclusionFlag=false;
			updateExclusionsPane();
		}
		else obj.value=temp;
	}
	else obj.oldvalue=obj.value;
}
function updateExclusionsPane() {
	var tbody_exclusions = document.all("exclusions");
	while (tbody_exclusions.rows.length > 0) {
		tbody_exclusions.deleteRow(0);
	}
	var countRow = tbody_exclusions.rows.length;
	var row_ind = 0;

	$.each(excludedMeals,function(key,value) {
		var obj=this;
		var date=key;
		$.each(obj,function(mealTypeCode) {
			if(obj[mealTypeCode]=='Y') {
	var newRow = tbody_exclusions.insertRow(row_ind);
				var newCellitemType = newRow.insertCell(newRow.cells.length);
				var newCellDate = newRow.insertCell(newRow.cells.length);
				newCellDate.className = "Data";
				newCellDate.appendChild(document.createTextNode(date));
				var newCellMealType = newRow.insertCell(newRow.cells.length);
				newCellMealType.appendChild(document.createTextNode(getMealTypeDesc(mealTypeCode)));
			}
		});
	});
}
function checkIfAllMealTypesExcluded() {
	var flag=false;
	var fromDate=document.getElementById("dateFrom").value;
	var toDate=document.getElementById("dateTo").value;

	var fromDate_moment = moment(fromDate,'DD/MM/YYYY');
	var toDate_moment = moment(toDate,'DD/MM/YYYY');
	var diffInDays = parseInt(toDate_moment.diff(fromDate_moment, 'days'))+1;
	var count_excludedMeals=getNumberOfExcludedMeals();
	var maxMealsForOrder=parseInt(diffInDays)*parseInt(fetchedMealTypesWithTime.length);

	if(parseInt(count_excludedMeals)==maxMealsForOrder) flag=true; 

	return flag;
	}
function getNumberOfExcludedMeals() {
	var count=0;
	$.each(excludedMeals,function(key,value) {
		var obj=this;
		$.each(obj,function(iter) {
			if(obj[iter]=='Y') count++;
		});
	});
	return count;
}
function checkAutoExclusions() {
	var today=moment().format("DD/MM/YYYY");
	var flag=false;
	var count=0;
	if(excludedMeals[today]==null)return false;
	else {
		var obj=excludedMeals[today];
		$.each(obj,function(iter) {
			if(obj[iter]=='Y') count++;
		});
	}
	if(parseInt(count)==parseInt(fetchedMealTypesWithTime.length)) flag=true;
	return flag;
}
// changes for ML-MMOH-CRF-0428 ENDS
//ML-MMOH-409

function checkIrregularMeal()
{
	//ML-MMOH-CRF-409 starts
	var IRREGULAR_DIET_ORD_YN=$("#IRREGULAR_DIET_ORD_YN").val();
	if(Menu_Flag==true && IRREGULAR_DIET_ORD_YN=="Y"){
		var objMeal = document.getElementsByName("mealTypesforDietTypes");
		var irregular_meal_name="";
		var dateFrom=$("#dateFrom").val();
		$.each(fetchedMealTypesWithTime,function(index) {
		 	var mealTypeCode=this.Meal_Code;
			var Irregular_End_Time=this.Irregular_End_Time;
			var Irregular_Start_Time=this.Irregular_Start_Time;
			var MealName=this.Short_Desc;
			var checktimeflag=checkTimeRange(Irregular_Start_Time,Irregular_End_Time,dateFrom);
			if(checktimeflag==true){
				irregular_meal_name+=MealName;
				irregular_meal_name+=",";
				irregular_meal_flag=true;
				irregular_meal_code+=mealTypeCode;
				irregular_meal_code+=",";
			}
	 });
		irregular_meal_name=irregular_meal_name.substring(0,irregular_meal_name.length-1);
		irregular_meal_code=irregular_meal_code.substring(0,irregular_meal_code.length-1);
		var IRREGULAR_MEAL_ORD_MESSAGE=trim($("#IRREGULAR_MEAL_ORD_MESSAGE").val());
		var IRREGULAR_MEAL_ORD_MESSAGE=trim($("#IRREGULAR_MEAL_ORD_MESSAGE").val());
		$("#irregular_meal_code").val(irregular_meal_code);

		var deitTypesStatus=$("#deitTypesStatus").val();
			if(IRREGULAR_DIET_ORD_YN=="Y" && IRREGULAR_MEAL_ORD_MESSAGE.length>0 && deitTypesStatus=="Y" && irregular_meal_flag==true){
				var msg=getMessage("DS_IRREGULAR_DIET_ORDER","DS");
				msg=msg.replace("#", dateFrom);
				msg+=""+irregular_meal_name;
				msg+="\n"+IRREGULAR_MEAL_ORD_MESSAGE;
				alert(msg);
			}
	}
}
//ML-MMOH-CRF-409 ENDS

function checkDietTypeModified(){

	if(DietTypeModified_YN=='N'){
	var mealObj = document.getElementsByName("dietTypesForMeals");
	var modified_dietType=$('#dietType').val();	
	if(Org_dietType!=''){
	if(Org_dietType!=modified_dietType){	
	
		DietTypeModified_YN='Y';
	}else{
		DietTypeModified_YN='N';
	}
	if(DietTypeModified_YN!='Y'){
	if(mealObj.length==OrigAssignedDietTypes.length){
	for(var i=0;i<mealObj.length;i++){
		if(mealObj[i].value!=OrigAssignedDietTypes[i]){
		DietTypeModified_YN='Y';
		}
	}
	}else{
		DietTypeModified_YN='Y';
	}
	}
	}
	}
	//Added against ML-MMOH-SCF-1335 Starts Here
	if(DietTypeModified_YN=='Y')
	{		
  		var irregular_enabled=$("#IRREGULAR_DIET_ORD_YN").val();
  		if(irregular_enabled=="Y") addAutomaticExclusions();
  		var msg_exclusions="The following meal(s) have been automatically excluded for the current day: \n";
  		$.each(automatic_excluded_meal_types,function(index,value) {
  		msg_exclusions=msg_exclusions+getMealTypeDesc(value)+"\n";
  		});
  		if(automatic_excluded_meal_types.length>0 && irregular_enabled=="Y") 
  			alert(msg_exclusions);
  			checkIrregularMeal();
  			if(checkFullNBMProfileOverLap())
          {return false;}
  			JSONobj={};
	}
	//Added against ML-MMOH-SCF-1335 Ends Here
}
//ML-MMOH-CRF-412

function getAttendantCount(fromDate, toDate,calledFrom,max_count){	
	var dateArray=[];
	dateArray=getDateRange(fromDate, toDate,'DD/MM/YYYY');
	var error_date="";
	$.each( dateArray, function( key, value ) {
	if(JSONobj[dateArray[key]]==null){
	JSONobj[value]="1";	
	}else{	
		var count=JSONobj[value];
		if(calledFrom=="onload"){
		JSONobj[value]=++count;	
		}else if(calledFrom=="onclick"){
		
			if(count<max_count){
				JSONobj[value]=++count;	
			}else{
				error_date+=dateArray[key];
				error_date+=",";
				//JSONobj[value]=count;	
				JSONobj[value]=++count;	
			}
		}else if(calledFrom=="removeAttendent"){
				JSONobj[value]=--count;	
		}
	}
	});
	if(calledFrom=="onclick" && error_date!=""){
		//Remove the recently added date range starts
		var dateArray=[];
		dateArray=getDateRange(fromDate, toDate,'DD/MM/YYYY');
		//dateArray=error_date.split(",");		
		$.each( dateArray, function( key, value ) {
			var count=JSONobj[value];
			JSONobj[value]=--count;	
		});
		//Remove the recently added date range ends
	
		var msg=getMessage("DS_MAX_ATTENDANT_FOR_DAY","DS");
		var Attendent_Label_Name=$('#Attendent_Label_Name').val();
		
		msg=msg.replace('#',Attendent_Label_Name);
		msg=msg.replace('#',Attendent_Label_Name);
		msg=msg.replace("#",max_count);
		//error_date=error_date.substring(0,error_date.length-1);
		//msg=msg+"\n"+error_date;
		//msg="Attendant cannot be added. You have exceeded the allowed number of attendants "+max_count+" for one or more Diet Date(s)."; 
		//alert(msg);
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		return false;
	}	
}

function getDateRange(fromDate, toDate, dateFormat) {
	var dates = [];
	var fromDate_moment = moment(fromDate,dateFormat);
	
	if(toDate=="" || toDate=="undefined" || toDate=='null'){
		toDate="31/12/2020";//CRF-412
	}
	
	var toDate_moment = moment(toDate,dateFormat);	
	var diff = toDate_moment.diff(fromDate_moment, 'days');
	
	dates.push(fromDate_moment.format(dateFormat));
	for(var i = 0; i < diff; i++) {
		dates.push(fromDate_moment.add(1,'d').format(dateFormat));
	}
	return dates;
};
//ML-MMOH-CRF-412 ENDS

//Added by vikash against 60459
function checkForNulls(retVal){
	if(retVal != null && retVal.length>0)
		return retVal;
	else
		return '';
}

function cal_error (str_message,obj)
{
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
}

//CRF-410-Starts
function enableDisableField(){
	$("#NilByMounth").load(location.href + " #NilByMounth");
     
	var Full_Day_NBM_YN=$("#Full_Day_NBM_YN").is(':checked');
	//setTimeout("enableDisableFieldNew()",600);	
	setTimeout(function () {
	    enableDisableFieldNew();
	}, 1000);

}

function enableDisableFieldNew(){
	//CRF-684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	var formObj =document.forms[0];
	var attendantAge=formObj.attendantAge.value;
	var yearIntValue=formObj.yearIntValue.value;
	var monthIntValue=formObj.monthIntValue.value;
	var dayIntValue=formObj.dayIntValue.value;
	var attendant_Order_Applicable_Yn = formObj.attendant_Order_Applicable_Yn.value;
	//CRF-746
	var Full_Day_NBM_YN=$("#Full_Day_NBM_YN").is(':checked');
	
	if(Full_Day_NBM_YN){
	//410 starts
		//Update(dietCat, mealClas, feedTY, dietType, feedingInstructions, dsdelivary,patientClass, encounterId, profileSL, from, to, nilFromDate, nilToDate,orderID,orOrderType,textureOfDiet,preparatoryInstructions)

		p1=document.getElementById("dietCategory").value;
		//fecthDietType(dietCat, ''); // MMS-QH-CRF-0190
		p2=document.getElementById("mealClass").value;
		p3=document.getElementById("feedType").value;
		p4=document.getElementById("dietType").value;
		p5=document.getElementById("feedingInstructions").value;		
		p6=document.getElementById("dsDeliveryInstr").value;
		p7=document.getElementById("patientClass").value;
		p8=document.getElementById("encounterId").value;
		p9=document.getElementById("profileSL").value;
		p10=document.getElementById("dateFrom").value;
		p11=document.getElementById("dateTo").value;		
		p12=document.getElementById("from").value;				
		p13=document.getElementById("to").value;
		p14=document.getElementById("orderID").value;
		p15="";
		p16=document.getElementById("texture_of_diet").value;
		p17=document.getElementById("prepInstr").value;		
		if(isMenuType == "true"){
		p18=document.getElementById("menu_type").value;	
		}
		//410 ends
	}	
	
	$("#dateFrom").prop('disabled',Full_Day_NBM_YN );
	$("#from").prop('disabled',Full_Day_NBM_YN );
	$("#dietCategory").prop('disabled',Full_Day_NBM_YN );
	$("#dateTo").prop('disabled',Full_Day_NBM_YN );
	$("#to").prop('disabled',Full_Day_NBM_YN );
	$("#mealClass").prop('disabled',Full_Day_NBM_YN );
	$("#dietType").prop('disabled',Full_Day_NBM_YN );
	$("#feedType").prop('disabled',Full_Day_NBM_YN );
	$("#dsDeliveryInstr").prop('disabled',Full_Day_NBM_YN );
	$("#texture_of_diet").prop('disabled',Full_Day_NBM_YN );
	$("#feedingInstructions").prop('disabled',Full_Day_NBM_YN );
	$("#prepInstr").prop('disabled',Full_Day_NBM_YN );
	//CRF-0684
	if(isMenuType == "true"){
		$("#menu_type").prop('disabled',Full_Day_NBM_YN );
	}
	//CRF-0684
	$("#fromdatepickerimg").prop('disabled',Full_Day_NBM_YN);
	$("#todatepickerimg").prop('disabled',Full_Day_NBM_YN);
	$("#dieticianReferral").prop('disabled',Full_Day_NBM_YN);
    //$("#attendantRadio").prop('disabled',Full_Day_NBM_YN);//ML-MMOH-CRF-746
	$('#dieticianReferral').prop('checked', false);//CRF-410
	//ML-MMOH-CRF-746
	
	//Added Against ML-MMOH-CRF-1460 Starts
	var isMACNBM = document.getElementById("isMACNBM").value;	
	if(isMACNBM)
	{
		if(attendant_Order_Applicable_Yn == 'N' ){	
              	document.getElementById('attendantRadio').disabled=true;
			  }else{			
				document.getElementById('attendantRadio').disabled=false;
				 }	
	}
	//Added Against ML-MMOH-CRF-1460 Ends
	else{
	 if(yearIntValue <= 18 ){
		if(Full_Day_NBM_YN == true){//True Check Start
		    document.getElementById('attendantRadio').disabled=true;
		}//True Check End
		else if(Full_Day_NBM_YN == false ){//False Check Start
			if(attendant_Order_Applicable_Yn == 'N' ){	
              			document.getElementById('attendantRadio').disabled=true;
			  }else{			
					document.getElementById('attendantRadio').disabled=false;
				 }		 
		}//False Check End
	 }
	}
	//ML-MMOH-CRF-746
	if(Full_Day_NBM_YN){
		var tableObj = null;
		var row_ind = 1;
		tableObj = document.getElementById("Able");
		while (tableObj.rows.length > 1) {
			tableObj.deleteRow(1);
		}
	}
	$("#dateFrom").val("");
	$("#from").val("");
	$("#dietCategory").val("");
	$("#dateTo").val("");
	$("#to").val("");
	$("#mealClass").val("");
	$("#dietType").val("");
	$("#feedType").val("");
	$("#dsDeliveryInstr").val("");
	$("#texture_of_diet").val("");
	$("#feedingInstructions").val("");
	$("#prepInstr").val("");
	//CRF-0684
	if(isMenuType == "true"){
		$("#menu_type").val("");//CRF-0684
	}
	//CRF-0684
	//CRF-410 ICN 62875-Starts
	if(Full_Day_NBM_YN){
		var p_maxdate=$("#maximum_days_allowed").val();
		var locale=$("#languageId").val();
		var date = addDays(new Date(), p_maxdate);		
		var sysdate=getCurrentDate("DMYHM",locale);
		var date1=date.getDate();
		var month=date.getMonth();
		var year=date.getFullYear();		

		date1=(date1<10)?("0"+date1):date1;
		//var month=d.getMonth();
		month=month+1;
		month=(month<10)?("0"+month):month;	

		//var year=d.getFullYear();
		var currentdate=date1+"/"+month+"/"+year;
		var maxDate=date1+"/"+month+"/"+year+" 23:59";
		$("#from").val(sysdate);
		$("#to").val(maxDate);

		var maxActiveprofileSL=$("#maxActiveprofileSL").val();
		$("#profileSL").val(maxActiveprofileSL);		
	}else{
		fecthDietType(p1, '');
		document.getElementById("testDate").value = p10;
		//CRF-0684
		if(isMenuType == "true"){
		Update(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18);
		}
		else{
		Update(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17);
		}
	}
	//CRF-410 ICN 62875-Ends & //CRF-0684	
}

function clearField(Full_Day_NBM_YN){
	//CRF-0684
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	$("#dateFrom").prop('disabled',Full_Day_NBM_YN );
	$("#from").prop('disabled',Full_Day_NBM_YN );
	$("#dietCategory").prop('disabled',Full_Day_NBM_YN );
	$("#dateTo").prop('disabled',Full_Day_NBM_YN );
	$("#to").prop('disabled',Full_Day_NBM_YN );
	$("#mealClass").prop('disabled',Full_Day_NBM_YN );
	$("#dietType").prop('disabled',Full_Day_NBM_YN );
	$("#feedType").prop('disabled',Full_Day_NBM_YN );
	$("#dsDeliveryInstr").prop('disabled',Full_Day_NBM_YN );
	$("#texture_of_diet").prop('disabled',Full_Day_NBM_YN );
	$("#feedingInstructions").prop('disabled',Full_Day_NBM_YN );
	$("#prepInstr").prop('disabled',Full_Day_NBM_YN );
	//CRF-684
	if(isMenuType =="true"){
		$("#menu_type").prop('disabled',Full_Day_NBM_YN );//CRF-0684
	}
	//CRF-684
	$("#fromdatepickerimg").prop('disabled',Full_Day_NBM_YN);
	$("#todatepickerimg").prop('disabled',Full_Day_NBM_YN);
	$("#dieticianReferral").prop('disabled',Full_Day_NBM_YN);
	//$("#attendantRadio").prop('disabled',Full_Day_NBM_YN);//commented against ML-MMOH-CRF-746
	
	if(Full_Day_NBM_YN){
		var tableObj = null;
		var row_ind = 1;
		tableObj = document.getElementById("Able");
		while (tableObj.rows.length > 1) {
			tableObj.deleteRow(1);
		}
	}

	//KDAH-CRF-0349-US05 Start
	var isDtCat_MlCls="";
	if(document.getElementById("isDtCat_MlCls")!=null)
		isDtCat_MlCls=document.getElementById("isDtCat_MlCls").value;
		//Modified Against ML-MMOH-CRF-1123-US3 Starts Here
	var isAlaCarte="";
	if(document.getElementById("isAlaCarte")!=null)
		isAlaCarte=document.getElementById("isAlaCarte").value;
	if(isDtCat_MlCls=="false" && isAlaCarte=="false"){
	//Modified Against ML-MMOH-CRF-1123-US3 Ends Here
		$("#dietCategory").val("");
	}
	//KDAH-CRF-0349-US05 End
	//$("#dateFrom").val(""); //Commented Against ML-MMOH-SCF-1098
	$("#from").val("");
	//$("#dateTo").val(""); //Commented Against ML-MMOH-SCF-1098
	$("#to").val("");
	//$("#mealClass").val(""); //CRF-673 @06-09-17
	$("#dietType").val("");
	$("#feedType").val("");
	$("#dsDeliveryInstr").val("");
	$("#texture_of_diet").val("");
	$("#feedingInstructions").val("");
	$("#prepInstr").val("");	
    if(isMenuType == "true"){	
	//$("#menu_type").val("");	//CRF-0684
	}
}

function FullNBMProcess(){

	//from and to date of NBM should not be blank
	//get the profile number
	//check if any regular profile available in ds_psd_diet_profile_hdr
	//if available display the error_date
	//check is any nbm profile exist for the given nbm from and to date.
	//if the count is one then update the from and to date of old nbm profile to user entered new date
	//else if count is greater higher to 1 ,then show the date range to ther user and indicate that those profile will be marked as cancel ,Do u want to continue ? if yes then update the status as 'X'  for the old order and insert this new value.
		
	var nbm_from_date=$("#from").val();
	var nbm_to_date=$("#to").val();
	var error="";
	var sysDate=getCurrentDate("DMYHM",'en');
	var languageId = $('#languageId').val();
	var encounterId = $('#encounterId').val();
	var addedFacilityId = $('#addedFacilityId').val();
	var addedAtWsNo = $('#addedAtWsNo').val();
	var addedById = $('#addedById').val();
	
	//Step 1 starts
	if(nbm_from_date=="" || nbm_to_date==""){
		error="";
		if(nbm_from_date=="" && nbm_to_date==""){
			error="Nil By Mouth From Date cannot be blank <br> Nil By Mouth To Date cannot be blank";
		}else if(nbm_from_date==""){
			error="Nil By Mouth From Date cannot be blank";
		}else if(nbm_to_date==""){
			error="Nil By Mouth To Date cannot be blank";
		}
		//parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		return false;
	}
	//Step 1 endss

	var flag = compareDates(document.getElementById("from").value,document.getElementById("to").value,'en',"DMYHM");
	if(flag== -1){
		var n_msg = "Nil By Mouth";
		var f_msg = "From Date";
		var t_msg = "To date";
		var msg = "should be greater than"
		var error=getMessage("DS_NBMTODTIM_GRTREQL_FRMDTIM","DS");//"Nil By Mouth To date time should be greater than or equal to Nil By Mouth From date Time";
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error
		return false;
	}
	var profileSL=$("#profileSL").val();
	var maxprofileSL=$("#maxprofileSL").val();
	profileSL=(profileSL=="")?'0':profileSL;
	maxprofileSL=(maxprofileSL=="")?'0':maxprofileSL;
	//check if any diet profile exist in the given date range starts
	var diet_profile_overlap_flag=checkForDietProfileOverLap(nbm_from_date,nbm_to_date,addedFacilityId,encounterId,profileSL);
	if(diet_profile_overlap_flag=="Y"){
		alert("Diet order is available for the requested date, Please change the Date");
		return false;
	}
		
	//check if any diet profile exist in the given date range ends	
	//	check if NBM profile is over lapping or not starts
	var mode="";
	var result=checkForNBMProfileOverLap(nbm_from_date,nbm_to_date,addedFacilityId,encounterId,profileSL);
	//Added Against ML-MMOH-CRF-1460 Starts
	var isMACNBM = $('#isMACNBM').val();
	if(isMACNBM && attROW>=1)	
	{
		insertNBMAtt(maxprofileSL,result);
	}
	//Added Against ML-MMOH-CRF-1460 Ends
	if(result=="insert"){
		mode="insertFullNBMProfile";
		saveNBMProfile(mode,encounterId,addedFacilityId,addedAtWsNo,addedById,languageId,nbm_from_date,nbm_to_date,profileSL,maxprofileSL);			
	}else if(result=="update"){
		mode="updateNBMProfile";
		saveNBMProfile(mode,encounterId,addedFacilityId,addedAtWsNo,addedById,languageId,nbm_from_date,nbm_to_date,profileSL,maxprofileSL);
	}else{
		mode="insertAndUpdateNBMProfile"
		saveNBMProfile(mode,encounterId,addedFacilityId,addedAtWsNo,addedById,languageId,nbm_from_date,nbm_to_date,profileSL,maxprofileSL);
		return;
	}
	//	check if NBM profile is over lapping or not ends
}

//Added Against ML-MMOH-CRF-1460 Starts
function insertNBMAtt(profileSL,result)	
{
		var attIns = document.getElementById("atndInstr1").value;	//ML-MMOH-SCF-1828
		var encounterId=document.getElementById("encounterId").value;
		var facility = document.getElementById("addedFacilityId").value;
		var dietCategory=document.getElementById("dietCategory").value;
		var addedById=document.getElementById("addedById").value;
		var patientId=document.getElementById("Patient_ID").value;
		var patientClass=document.getElementById("patientClass").value;
		var locationType = document.getElementById("locationType").value;
		var locationCode = document.getElementById("locationCode").value;
		var addedAtWsNo = document.getElementById("addedAtWsNo").value;
		var language_Id =document.getElementById("languageId").value;
		var isMenuType="";	
		var menu_type="";		
	if(document.getElementById("isMenuType")!=null)
		isMenuType=document.getElementById("isMenuType").value;
	if(isMenuType=="true"){
		menu_type = document.getElementById("mac_menu_type").value; //Added Against TFS:32135
	}
		var mode = "insertNBMAttList";
					var xmlDoc="" ;
					var xmlHttp = new XMLHttpRequest() ;
					var xmlStr ="<root></root>";
					var param="&encounterId="+encounterId
					+"&diet_Category="+diet_Category
					+"&addedById="+addedById
					+"&addedFacilityId="+facility
					+"&isNEW="+document.getElementById("isNEW").value
					+"&profileSL="+profileSL
					+"&result="+result
					+"&patientId="+patientId
					+"&patientClass="+patientClass
					+"&language_Id="+language_Id
					+"&locationType="+locationType
					+"&locationCode="+locationCode
					+"&addedAtWsNo="+addedAtWsNo
					+"&attdietList="+attdietList
					+"&attIns="+attIns						
					+"&menu_type="+menu_type						
					+"&mode="+mode;						
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+param,false);
					xmlHttp.send(xmlDoc);
					responseText=trimString(xmlHttp.responseText);
					eval(responseText);
					var message =  getMessage("DS_OPER_COMPLETE","DS");
					parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message;
					isMACNBMUpdate();
					//window.close();
					//fecthMealContents();
}


function isMACNBMUpdate()	
{
	submitStatus = true;
	chkFormValChange = false;
	var isMenuType="";		
	if(document.getElementById("isMenuType")!=null)
	isMenuType=document.getElementById("isMenuType").value;
	var patientID = document.getElementById("Patient_ID").value;
	var encounterId=document.getElementById("encounterId").value;
	var dateForMeanu = document.getElementById("dateForMeanu").value;
	if(dateForMeanu == "")
		dateForMeanu = document.getElementById("dateFrom").value
	var locale = document.getElementById("languageId").value;
	 var profileSL = document.getElementById("profileSL1").value;
	//Added Against ICN:17117 ML-MMOH-CRF-1460
	 Full_Day_NBM_YN=$("#Full_Day_NBM_YN").is(':checked');
	 if(Full_Day_NBM_YN) profileSL = +parseInt(profileSL) + +1;
	 //Added Against ICN:17117 ML-MMOH-CRF-1460
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var mode = "nutrientsAndSplFoodItems";
	var nutriAndSplFood ="&locale="+locale+"&dateForMeanu="+dateForMeanu+"&profileSL="+profileSL+"&encounterId="+encounterId+"&patientID="+patientID+"&facility="+document.getElementById("addedFacilityId").value+"&mode="+mode;
	var temp_jsp="../../servlet/eDS.PlaceDietOrderServlet?"+nutriAndSplFood;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
	eval(responseText);
	updateMealMenuDate();
	//fecthMealTypeOptions(dietType);
	getMeals();
	//updateMealMenuDate();
	enableMandatory();
	var attInsNew = trim(attdArry[attdArry.length-1]);
	if(attInsNew!='' && attInsNew!=null && attInsNew!="null") //Added Against ML-MMOH-SCF-1828
	document.getElementById("atndInstr").value = attInsNew;
	closeWindowFlag = true;	//Added Against ICN:17117 ML-MMOH-CRF-1460
}
//Added Against ML-MMOH-CRF-1460 Ends

function checkForNBMProfileOverLap(fromDate,dateTo,addedFacilityId,encounterId,profileSL){
	var result="insert";
	var mode = "getNBMProfileOverLap";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&fromDate="+fromDate
	+"&dateTo="+dateTo
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	var jsonObjResponse=eval('(' + retVal + ')');
	var NBMOverLapProfileList=new Array();
	NBMOverLapProfileList = jsonObjResponse.NBMOverLapProfileList;
	var count=0;
	var cancel_profile="";
	var cancel_dates="";	
	if(NBMOverLapProfileList!=null && NBMOverLapProfileList!="undefined" && NBMOverLapProfileList!=""){
	$.each( NBMOverLapProfileList, function( key, value ) {
			++count;
			if(NBMOverLapProfileList[key].profile_sl!=profileSL){
				cancel_profile+=NBMOverLapProfileList[key].profile_sl+",";
				cancel_dates+=NBMOverLapProfileList[key].nil_by_mouth_frm+"-"+NBMOverLapProfileList[key].nil_by_mouth_to+"\n";
			}
		});	
		if(count=="1")	{
			result="update";
		}else if(count>1){
			result="cancel";
		}else{
			result="insert";
		}
		if(result=="cancel"){			
		if(window.confirm("Saving the changes will automatically cancel the following existing profile(s) \n" + cancel_dates + "Do you wish to continue?")){
			var retVal=cancelNBMProfile(cancel_profile,encounterId,addedFacilityId);
			if(retVal=="Y"){
				result="update";
			}
		}else{
			result="";
		}			
		//DEC-18 starts
		}else if(result=="update"){			
			var datesarr = new Array();
			datesarr=cancel_dates.split("-");
			var profile=NBMOverLapProfileList[0].profile_sl;
			var dbfromdate=NBMOverLapProfileList[0].nil_by_mouth_frm;
			var dbtodate=NBMOverLapProfileList[0].nil_by_mouth_to;
			var dbfromdate_obj=new Date(dbfromdate);
			var dbtodate_obj=new Date(dbtodate);
			var fromDate_obj=new Date(fromDate);			
			
			var isaftervalue=momentcompare(fromDate,dbfromdate);
			var isBeforevalue=momentcompare(fromDate,dbtodate);
			var isequalvalue=momentcompare(fromDate,dbtodate);		
			
			var isafterflag=(isaftervalue==1)?true:false;
			var isBeforeflag=(isBeforevalue==-1)?true:false;
			var isequalflag=(isequalvalue==0)?true:false;
			if(isafterflag && (isBeforeflag || isequalflag)){			
				result="updateandinsert"
			}			
		}
		//DEC-18 ends
		}
		return result;	
}

function cancelNBMProfile(cancel_profile,encounterId,addedFacilityId){
	cancel_profile=cancel_profile.substring(0,cancel_profile.length-1);
	var mode = "cancelNBMProfile";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&profileSL="+cancel_profile
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	return retVal;	
}

function saveNBMProfile(mode,encounterId,addedFacilityId,addedAtWsNo,addedById,languageId,nbm_from_date,nbm_to_date,profileSL,maxprofileSL){	
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&addedAtWsNo="+addedAtWsNo
	+"&profileSL="+profileSL
	+"&addedById="+addedById
	+"&languageId="+languageId
	+"&from="+nbm_from_date
	+"&to="+nbm_to_date
	+"&maxprofileSL="+maxprofileSL
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;	
	$("#NilByMounth").load(location.href + " #NilByMounth");//Dec21
	chkFormValChange = false;
	var message =  getMessage("DS_OPER_COMPLETE","DS");// "APP-DS0001 Operation Completed Successfully...";
	parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+message	
	fecthMealContents();
	chkFormValChange = false;//CRF-410 ICN 62875	
	
	
	//29 dec starts
	var dieticianReferral_hidden=$("#dieticianReferral_hidden").val();
	if(dieticianReferral_hidden=="Y")
		$('#dieticianReferral').prop('checked', true);//CRF-410
	else
		$('#dieticianReferral').prop('checked', false);//CRF-410
	//29 dec ends

}	
function checkForDietProfileOverLap(nbm_from_date,nbm_to_date,addedFacilityId,encounterId,profileSL){
	var mode="getDietProfileOverLap"
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&profileSL="+profileSL
	+"&from="+nbm_from_date
	+"&to="+nbm_to_date
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	return retVal;	
}

//function checkFullNBMProfileOverLap(fromDate,dateTo,addedFacilityId,encounterId,profileSL){
function checkFullNBMProfileOverLap(){
	var fromDate=$("#dateFrom").val();
	var dateTo=$("#dateTo").val();
	var encounterId=$("#encounterId").val();
	var addedFacilityId=$("#addedFacilityId").val();	
	var result=false;
	var mode = "getNBMProfileOverLap";
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	
	var paramTer="&encounterId="+encounterId
	+"&addedFacilityId="+addedFacilityId
	+"&fromDate="+fromDate
	+"&dateTo="+dateTo
	+"&mode="+mode;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eDS.PlaceDietOrderServlet?"+paramTer,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);
	var retVal = xmlHttp.responseText;	
	var jsonObjResponse=eval('(' + retVal + ')');
	//var jsonObjResponse=eval('(' + retVal + ')');
	var NBMOverLapProfileList=new Array();
	NBMOverLapProfileList = jsonObjResponse.NBMOverLapProfileList;
	var count=0;
	var cancel_profile="";
	var cancel_dates="";	
	if(NBMOverLapProfileList!=null && NBMOverLapProfileList!="undefined" && NBMOverLapProfileList!=""){
	$.each( NBMOverLapProfileList, function( key, value ) {
			++count;
			if(NBMOverLapProfileList[key].profile_sl!=profileSL){
				cancel_profile+=NBMOverLapProfileList[key].profile_sl+",";
				cancel_dates+=NBMOverLapProfileList[key].nil_by_mouth_frm+"-"+NBMOverLapProfileList[key].nil_by_mouth_to+"\n";
			}
		});
		if(count>0){
			result=true;
		}
		if(result==true){
				alert("Patient is in NBM for the requested date, Please change the Date.");			
		}
		}
		return result;	
}	

//CRF-410 ends
// CRF-410 18th Dec
var dates = {
    convert:function(d) {
        return (
            d.constructor === Date ? d :
            d.constructor === Array ? new Date(d[0],d[1],d[2]) :
            d.constructor === Number ? new Date(d) :
            d.constructor === String ? new Date(d) :
            typeof d === "object" ? new Date(d.year,d.month,d.date) :
            NaN
        );
    },
    compare:function(a,b) {
        // Compare two dates (could be of any type supported by the convert
        // function above) and returns:
        //  -1 : if a < b
        //   0 : if a = b
        //   1 : if a > b
        // NaN : if a or b is an illegal date
        // NOTE: The code inside isFinite does an assignment (=).
        return (
            isFinite(a=this.convert(a).valueOf()) &&
            isFinite(b=this.convert(b).valueOf()) ?
            (a>b)-(a<b) :
            NaN
        );
    },
    inRange:function(d,start,end) {
        // Checks if date in d is between dates in start and end.
        // Returns a boolean or NaN:
        //    true  : if d is between start and end (inclusive)
        //    false : if d is before start or after end
        //    NaN   : if one or more of the dates is illegal.
        // NOTE: The code inside isFinite does an assignment (=).
       return (
            isFinite(d=this.convert(d).valueOf()) &&
            isFinite(start=this.convert(start).valueOf()) &&
            isFinite(end=this.convert(end).valueOf()) ?
            start <= d && d <= end :
            NaN
        );
    }
}

function momentcompare(dateTimeA, dateTimeB) {
    var momentA = moment(dateTimeA,"DD/MM/YYYY");
    var momentB = moment(dateTimeB,"DD/MM/YYYY");
    if (momentA > momentB) return 1;
    else if (momentA < momentB) return -1;
    else return 0;
}
// CRF-410 18th Dec

//AMS-CRF-112 Starts Here
async function openDialogWindow(strVal,obj,size,disable_flag)
{
	strVal=encodeURIComponent(strVal);
	var param='heading='+strVal+'&para='+escape(obj.value)+'&size='+size+"&disable_flag="+disable_flag;
	var retext=await window.showModalDialog('../../eDS/jsp/LeftFrameTextArea.jsp?'+param,window,"dialogHeight: 150px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	if(retext=='undefined'|| retext==''|| retext==null)
		retext=obj.value;
	else
		obj.value=retext;
}

async function openDialogWindow1(strVal,obj,dbobj,remarks_size){

	var readOnlyYN = "N";
	var remarks ="";
	var remarks_hid = "";
	remarks = obj.value;
        remarks_hid = obj.value;	
	if(remarks == null || remarks == 'undefined' || remarks == "" || remarks == undefined)
		{
			remarks = dbobj.value;
			remarks_hid = dbobj.value;	
		}	
	remarks = trimString(remarks);
	
	remarks = encodeURIComponent(remarks,"UTF-8");
	title =encodeURIComponent(strVal);
	
	var retVal =await window.showModalDialog("../../eDS/jsp/TextAreaRemarkswithSpecialCharacters.jsp?heading="+title+"&remarks="+remarks+"&readOnlyYN="+readOnlyYN+"&size="+remarks_size,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
	
	if(retVal == "undefined" || retVal == undefined || retVal == "CL_REM")
	   { // This when the user closed the TeaxtArea window with above 'X'
		    obj.value= remarks_hid;
		}
	else{
		obj.value= retVal;
		}
}

//function  additionalInstructionToolTip(arrMsg)
function  additionalInstructionToolTip(arrMsg,dbobj)//Added Against ICN-64406 
   {	
	//Added Against ICN-64406 starts Here
	var remarks ="";
	var remarks_hid = "";
	remarks = arrMsg.value;
	remarks_hid = arrMsg.value;	
	if(remarks == null || remarks == 'undefined' || remarks == "" || remarks == undefined)
	{
		remarks = dbobj.value;
		remarks_hid = dbobj.value;	
	}	
	remarks = trimString(remarks);	  
	//Added Against ICN-64406 Ends Here
   
	var additional_instruction_label=getLabel("eDS.AdditionalInstruction.Label","ds_labels");
	var tab_dat  = "<table id ='tooltiptable1' cellpadding='3' cellspacing=0 border='0' class='BOX' width='100%' height='100%' align='center'>";
	tab_dat     += "<tr>"
	tab_dat     += "<th   nowrap > <B>"+additional_instruction_label+ " </B> </a> </th>"
	tab_dat     += "</tr> ";
	tab_dat     += "<tr>"
	tab_dat     += "<td class='label' > "+remarks.substring(0,75)+ "</a> </td>"
	tab_dat     += "</tr> ";
	tab_dat     += "<tr>"
	tab_dat     += "<td class='label' > "+remarks.substring(75,150)+ "</a> </td>"
	tab_dat     += "</tr> ";
	tab_dat     += "</table> ";
   return tab_dat;
 }
//AMS-CRF-112 Ends Here

//Added Against ML-MMOH-CRF-0672 Starts Here
function losCheck()
{
	var isLos_gt7=document.getElementById("isLos_gt7").value;
	if(isLos_gt7 =="true" && isLos_gt7!="")
	{
		var diffDays=document.getElementById("diffDays").value;
		if(diffDays > 7 && diffDays!="")
		//alert(getMessage("DS_ALA_CARTE_ORDER","DS"));//Commented Against ML-MMOH-CRF-1123-US3
		return false;//CRF-673 @06-09-17
	}
}
//Added Against ML-MMOH-CRF-0672 Ends Here

//Added Against ML-MMOH-CRF-0674 Starts Here
function diettype_Autocomplete()
{
	document.getElementById("diettype_auto").value=""; 
	var selText="";
	var theKeyCode = window.event.keyCode;
	if(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)
	{
		document.getElementById("auto_flag").value="true";
		selText += String.fromCharCode(theKeyCode);
		document.getElementById("diettype_auto").value=selText;
		fecthDietType(document.getElementById("dietCategory").value);
	}
}

function Select()
{
	var auto_flag=document.getElementById("auto_flag").value;
	var myDropDown = document.getElementById("dietType");
	var str = myDropDown.options[myDropDown.selectedIndex].value;
		if(auto_flag == "true" && str!="")
		{	myDropDown.size = 1;
			document.getElementById("auto_flag").value="false2";
			document.getElementById("diettype_auto").value="";
		}
		else if(auto_flag == "true" && str=="")
		{			
			myDropDown.size = 1;  
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietType(document.getElementById("dietCategory").value);
		}
		else if(auto_flag == "false2" && str=="")
		{
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietType(document.getElementById("dietCategory").value);
		}		
}   

function attendentdiettype_Autocomplete()
{
	document.getElementById("diettype_auto").value=""; 
	var selText="";
	var theKeyCode = window.event.keyCode;
	if(theKeyCode != 37 && theKeyCode != 38 && theKeyCode != 39 && theKeyCode != 40 && theKeyCode != 13 && theKeyCode != 8)
	{
		document.getElementById("auto_flag").value="true";
		selText += String.fromCharCode(theKeyCode);
		document.getElementById("diettype_auto").value=selText;
		fecthDietTypes_Attendant(document.getElementById("attendentDietCategory").value);		 
	}
}

function attendentSelect()
{
	var auto_flag=document.getElementById("auto_flag").value;
	var myDropDown = document.getElementById("attendentDiet");
	var str = myDropDown.options[myDropDown.selectedIndex].value;
		if(auto_flag == "true" && str!="")
		{	myDropDown.size = 1;
			document.getElementById("auto_flag").value="false2";
			document.getElementById("diettype_auto").value="";
		}
		else if(auto_flag == "true" && str=="")
		{			
			myDropDown.size = 1;  
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietTypes_Attendant(document.getElementById("attendentDietCategory").value);	 
		}
		else if(auto_flag == "false2" && str=="")
		{
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietTypes_Attendant(document.getElementById("attendentDietCategory").value);	 
		}		
}   
//Added Against ML-MMOH-CRF-0674 Ends Here

//Added Against ML-MMOH-CRF-1005-US3 Starts Here
function expandColorInd()
{
	var formObj=document.forms[0];
	var min_max_val=formObj.min_max_val.value;	
	if(min_max_val=="Y"){
		parent.frames[1].WorkListResultTailForm.querySelector("#moreCriteria1").style.display='';
		formObj.img_src.src="../../eOT/images/gripper1.gif";
		formObj.min_max_val.value="N";
	}else if(min_max_val=="N"){
		parent.frames[1].WorkListResultTailForm.querySelector("#moreCriteria1").style.display='none';
		formObj.img_src.src="../../eOT/images/gripper.gif";
		formObj.min_max_val.value="Y";
	}
}
//Added Against ML-MMOH-CRF-1005-US3 Ends Here

//Added Against PMG2013-CRF-0009.1-US002 Starts Here
var Compreasons = "";
async function ComplaintReasons(){	
	var locale = $('#languageId').val();
	var servingDate = $('#servingDate').val();
	var complaintDesc = $('#complaintDesc').val();
	var complaintCode = $('#complaintCode').val();
	var dateChkFlag = "N";
	var dateFrom = $('#dateFrom').val();
	if(dateFrom <= servingDate){
		dateChkFlag = "Y";
	}
	
	if(complaintCode != "null" && complaintCode != "" && Compreasons == ""){
		Compreasons = complaintCode;
	}
	if(Compreasons = "undefined"){
		Compreasons = complaintCode;
	}
	
	var dialogUrl1 = "../../eDS/jsp/CancellationReason.jsp?&servingDate="+servingDate+"&dateFrom="+dateFrom+"&dateChkFlag="+dateChkFlag;
	var dialogArguments = Compreasons;
	var dialogFeatures = "dialogHeight:200px;dialogWidth:600px;status:no;scroll:yes";
	returnReasons =await window.showModalDialog(dialogUrl1,dialogArguments,dialogFeatures);
	if(returnReasons != null){
		Compreasons = returnReasons;
	}
	if(returnReasons == undefined){
		returnReasons = dialogArguments;
	}
}

function okButton(val){	
	if(val == ""){
		alert(getMessage("DS_REASON_NOT_BLANK","DS")); //"Reason cannot be blank"
		document.getElementById('complaintCode').focus();
	}else{
		Compreasons = val;
		document.getElementById("complaintCode").value = Compreasons;
		window.returnValue = Compreasons;
		window.close();
	}
}
//Added Against PMG2013-CRF-0009.1-US002 Ends Here


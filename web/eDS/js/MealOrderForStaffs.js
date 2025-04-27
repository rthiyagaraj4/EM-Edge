var viewId = "mealOrderTab";

function tabClicked(tabId) {
	viewId = tabId;
	id = viewId;
}

function showCal(id, format, showsTime, showsOtherMonths, name) {
fmt = format;
{
	calend = format;
	/*if (showsTime) {
		time = true;
	} else {
		time = false;
	}*/
	time = false;
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

function getSysDateForMealOrder() {
	var locale = document.getElementById("locale").value;
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1;
	var day = currentTime.getDate();
	var year = currentTime.getFullYear();
	if(month < 10)
		month="0"+month;
	if(day < 10)
		day="0"+day;
	sysDate = day+"/"+month+"/"+year;
	IBADateValidator.convertDateJS(sysDate,'en',locale,"dd/MM/yyyy",callBackSysDate);
	function callBackSysDate(sDate){
		parent.mealOrderFrame.MealOrderForStaffForm.document.getElementById("vo.dsStaffOrdersHdrVO.orderFromDate").value=sDate;

	}
}

//added by N Munisekhar on 24-May-2013 against [IN39925]
function ComparePeriodFromToTime(from,to)
   {
	var frdt = from.value;
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";
 
	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
	
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(!isBefore(greg_frdt,greg_tdt,"DMY","en"))
		{
			getMessage("DS_ORDER_TODATE_GRTR_FRMDATE","OT");
			document.forms[0].mealOrderTo = '';
			document.forms[0].mealOrderTo.focus();
			document.forms[0].mealOrderTo.select();
		}
	}
	changeMealType(); //Added Against ML-MMOH-SCF-1740
}
function Valid_DT(event)
{
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) == -1) return false; 
}
//End of [IN39925]

/* Added Against Start 832-crf */
function searchItemMenu(){
	var f1;
	var error = "";
	var fieldName=new Array("eOT.MealOrderFrom.Label","eOT.MealOrderTo.Label");
	var fields=new Array();
	fields[0] = document.getElementById("mealOrderFrom").value;
	fields[1] = document.getElementById("mealOrderTo").value;

  	var msgArray=new Array();
	var key_value = new Array();
	for (j = 0; j < fields.length; j++) {
		if (fields[j] == "") {
		if (j == 2)
			key_value[j] = getLabel(fieldName[j],"DS");
		else
			key_value[j] = getLabel(fieldName[j],"OT");

		error = error + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",key_value[j])+"<br>";
		f1 = false;
		}
	}
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	if (f1 == false)
		return false;
	else{
		//Below Commented and Added against 832-CRF		 
		//return true;
		var mealOrderFromDate = document.getElementById("mealOrderFrom").value;
		var mealOrderToDate = document.getElementById("mealOrderTo").value;
		parent.details_frame.location.href="../../eDS/jsp/MealOrderCUD.jsp?mealOrderFromDate="+mealOrderFromDate+"&mealOrderToDate="+mealOrderToDate;		
		} 
		//Below Commented and Added against 832-CRF
}
/* Added Against end 832-crf */

async function selectItemsMenu() {
	//CRF-832
	var rowCount1 = document.getElementById("rowCount1").value;
	var params = document.getElementById("params").value;
	//CRF-832
	var mealCategory = document.getElementById("mealCategory").value;
	var facilityId = document.getElementById("facilityId").value;
	var fromDate = document.getElementById("mealOrderFrom").value;
	
	//Added by Gaurav Against ML-MMOH-SCF-2400...starts
		
	var isMenuType =document.getElementById("isMenuType").value;
	var chkYN="";
	if(isMenuType=="true")
		chkYN="Y";
	else	
		chkYN="N";

	if(chkYN=="Y"){
	// Menu Type 
	var menuType = document.getElementById("menuType");
	var menuTypeText = menuType.options[menuType.selectedIndex].text;
	var menuTypeVal = menuType.options[menuType.selectedIndex].value;
	}
	//Diet Type
	var dietType = document.getElementById("DietType");
	var dietTypeText = dietType.options[dietType.selectedIndex].text;
	var dietTypeVal = dietType.options[dietType.selectedIndex].value;
	//Meal Class
	var mealClass = document.getElementById("MealClass");
	var mealClassText = mealClass.options[mealClass.selectedIndex].text;
	var mealClassVal = mealClass.options[mealClass.selectedIndex].value;
	//Meal Type
	var mealType = document.getElementById("MealType");
	var mealTypeText = mealType.options[mealType.selectedIndex].text;
	var mealTypeVal = mealType.options[mealType.selectedIndex].value;
	
	var mealOrderFrom = document.getElementById("mealOrderFrom").value;
	var mealOrderTo = document.getElementById("mealOrderTo").value;
	//Meal Category
	var mealCategory = document.getElementById("mealCategory");
	var mealCategoryText = mealCategory.options[mealCategory.selectedIndex].text;
	var mealCategoryVal = mealCategory.options[mealCategory.selectedIndex].value; 
	//Diet Request Location
	var dietLocation = document.getElementById("dietLocation");
	var dietLocationText = dietLocation.options[dietLocation.selectedIndex].text;
	var dietLocationVal = dietLocation.options[dietLocation.selectedIndex].value; 
	// Practitioner Name
	var practitioner_name = document.getElementById("practitioner_name").value;	
	var practId = document.getElementById("practitioner").value;	

//Added By Gaurav Against ML-MMOH-SCF-2484...starts

	var flag2=""; 
	
	var startdate = "";
	var enddate   = "";
	var str_Date_F  = "";
	var end_Date_F  = "";
	
	for (var i = 0; i < parent.mealOrderArray.length; i++) {
		var vall_Date = "false";
	    var mealRecord = parent.mealOrderArray[i];
		if(chkYN =="Y"){
			startdate = mealRecord[2];
			enddate = mealRecord[3];
		}else{
			startdate = mealRecord[0];
			enddate = mealRecord[1];	
		}
		str_Date_F = mealOrderFrom;
		end_Date_F = mealOrderTo;

		if((str_Date_F >= startdate && str_Date_F <= enddate) || (startdate >= str_Date_F && startdate <= end_Date_F))
		{
			vall_Date = "true";
		}
		//mode ="insert";	
		staff_order_id=""; 
		if(chkYN=="Y"){
			
	    //if( mealRecord[1]==menuTypeVal && mealRecord[2]== mealOrderFrom && mealRecord[3]== mealOrderTo && mealRecord[5]==dietTypeVal && mealRecord[7]==mealClassVal && mealRecord[9]==mealTypeVal && mealRecord[12]==mealCategoryVal && mealRecord[15]==dietLocationVal  && mealRecord[16]==practId) // Added practId against ML-MMOH-SCF-1738
	    if( vall_Date == "true" && mealRecord[1]==menuTypeVal && mealRecord[5]==dietTypeVal && mealRecord[7]==mealClassVal && mealRecord[9]==mealTypeVal && mealRecord[12]==mealCategoryVal && mealRecord[15]==dietLocationVal  && mealRecord[16]==practId) // Added practId against ML-MMOH-SCF-1738
		 { 
			flag2="sameVal";
		 }
		}else{
			
		 if( vall_Date == "true" && mealRecord[3] == dietTypeVal && mealRecord[5] == mealClassVal && mealRecord[7] == mealTypeVal && mealRecord[10] == mealCategoryVal && mealRecord[13] == dietLocationVal&& mealRecord[14] == practId){ //Added practId Against ML-MMOH-SCF-1795
			flag2="sameVal";
		 }	
		}
	  }
	  if(flag2 ==="sameVal"){
		  alert(getMessage("DS_REC_EXISTS","DS"));
		  return;
	  }
	  
	//Added By Gaurav Against ML-MMOH-SCF-2484...ends
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=checkOrderForStaff&menuTypeVal="+menuTypeVal+"&mealOrderFrom="+mealOrderFrom+"&mealOrderTo="+mealOrderTo+"&dietTypeVal="+dietTypeVal+"&mealClassVal="+mealClassVal+"&mealTypeVal="+mealTypeVal+"&meal_Category="+mealCategoryVal+"&dietLocationVal="+dietLocationVal+"&practId="+practId+"&isMenuType="+isMenuType;	
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal2 = trimString(xmlHttp.responseText);
	if(retVal2 < '1'){  
	//Added by Gaurav Against ML-MMOH-SCF-2400...ends
//	MealOrderForStaff.getStatusCheck(mealCategory,fromDate,facilityId,calBackStatus);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getStatusCheck&facility_id="+facilityId+"&meal_Category="+mealCategory+"&from_Date="+fromDate;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retVal_arr = retVal.split("~");
	if(true) {
	//if(retVal_arr.length >0) {
		var dialogHeight = "5";
		var dialogWidth = "20";
		var status = "no";
		var title = "Create New Record";
		var dialogUrl = "../../eDS/jsp/NewRecordYN.jsp?id=" + retVal_arr[0];
		var dialogArguments = "Create New Record";
		var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll=no; status:" + status+";title:"+title;
		var returnVal = new Array();
		returnVal = await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);
		if (returnVal != "0") {
			var recordVal = parent.details_frame.document.getElementById("recordId");
			recordVal.value = returnVal;
			//CRF-832
			mode = "insert";			
			//CRF-832
			selectItemsMenu1();
		} else {
//			   parent.details_frame.location.href = "../../eDS/jsp/MealOrderCUD.jsp";
			resetData();
		}
	}
	}else{
		alert(getMessage("DS_REC_EXISTS","DS"));
	}
}

function selectItemsMenu1() {
	var fields = new Array();
	var names = new Array();
	//Added Against Start 832 crf
	var isMenuType =document.getElementById("isMenuType").value;
	var chkYN="";
	if(isMenuType=="true")
		chkYN="Y";
	else	
		chkYN="N";

	if(chkYN=="Y"){
	// Menu Type 
	var menuType = document.getElementById("menuType");
	var menuTypeText = menuType.options[menuType.selectedIndex].text;
	var menuTypeVal = menuType.options[menuType.selectedIndex].value;
	}
	//Added Against End 832 crf
	//Diet Type
	var dietType = document.getElementById("DietType");
	var dietTypeText = dietType.options[dietType.selectedIndex].text;
	var dietTypeVal = dietType.options[dietType.selectedIndex].value;
	//Meal Class
	var mealClass = document.getElementById("MealClass");
	var mealClassText = mealClass.options[mealClass.selectedIndex].text;
	var mealClassVal = mealClass.options[mealClass.selectedIndex].value;
	//Meal Type
	var mealType = document.getElementById("MealType");
	var mealTypeText = mealType.options[mealType.selectedIndex].text;
	var mealTypeVal = mealType.options[mealType.selectedIndex].value;
	//Added Against Start 832 crf
	var mealOrderFrom = document.getElementById("mealOrderFrom").value;
	var mealOrderTo = document.getElementById("mealOrderTo").value;
	//Meal Category
	var mealCategory = document.getElementById("mealCategory");
	var mealCategoryText = mealCategory.options[mealCategory.selectedIndex].text;
	var mealCategoryVal = mealCategory.options[mealCategory.selectedIndex].value; 
	//Diet Request Location
	var dietLocation = document.getElementById("dietLocation");
	var dietLocationText = dietLocation.options[dietLocation.selectedIndex].text;
	var dietLocationVal = dietLocation.options[dietLocation.selectedIndex].value; 
	// Practitioner Name
	var practitioner_name = document.getElementById("practitioner_name").value;	
	//CRF-832
	var practId = document.getElementById("practitioner").value;	
	var rowValue1 = document.getElementById("rowId").value;
	var last_addedById = document.getElementById("last_addedById").value;	
	var orderedBy = document.getElementById("orderedBy").value;
	var last_modifiedById = document.getElementById("last_modifiedById").value;	
	//var mode=""; 
	mode = document.getElementById("mode").value;
	var staff_order_id = document.getElementById("staff_order_id").value;
	var total_cnt = document.getElementById("total_cnt").value;
	var noOfOrders = document.getElementById("noOfOrders").value;
	//CRF-832

	//Added Against Start 832-CRF
	var fieldCount = 0;
	if(chkYN=="Y"){		
		fields[fieldCount++] = menuTypeVal;
		fields[fieldCount++] = mealCategoryVal;
	//Added Against Start DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
	if(mealCategoryVal=="DOC")
		fields[fieldCount++] = practitioner_name;
		//Added Against End DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
		fields[fieldCount++] = mealOrderFrom;
		fields[fieldCount++] = mealOrderTo;
		fields[fieldCount++] = dietTypeVal;
		fields[fieldCount++] = mealClassVal;
		fields[fieldCount++] = mealTypeVal;
		fields[fieldCount++] = noOfOrders;//MuthuN
	}else{
		fields[fieldCount++] = mealCategoryVal;
	//Added Against Start DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
	if(mealCategoryVal=="DOC")
		fields[fieldCount++] = practitioner_name;	
		//Added Against End DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
		fields[fieldCount++] = mealOrderFrom;
		fields[fieldCount++] = mealOrderTo;
		fields[fieldCount++] = dietTypeVal;
		fields[fieldCount++] = mealClassVal;
		fields[fieldCount++] = mealTypeVal;
		fields[fieldCount++] = noOfOrders;//MuthuN
	}
	var namesCount = 0;
	if(chkYN=="Y"){
		names[namesCount++] = "eDS.MenuType.Label";
		names[namesCount++] = "eDS.MealCategory.Label";
	//Added Against Start DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
	if(mealCategoryVal=="DOC")
	names[namesCount++] = "eDS.practitionerName.Label";
		//Added Against End DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
		names[namesCount++] = "eOT.MealOrderFrom.Label";
		names[namesCount++] = "eOT.MealOrderTo.Label";
		names[namesCount++] = "eOT.DietType.Label";
		names[namesCount++] = "eOT.MealClass.Label";
		names[namesCount++] = "eOT.MealType.Label";
		names[namesCount++] = "eOT.NoOfOrders.Label"; //MuthuN
	}else{
		names[namesCount++] = "eDS.MealCategory.Label";
	//Added Against Start DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
	if(mealCategoryVal=="DOC")
		names[namesCount++] = "eDS.practitionerName.Label";
		//Added Against End DS-Ml-MMOH-CRF-0832-US00402 [IN065739]
		names[namesCount++] = "eOT.MealOrderFrom.Label";
		names[namesCount++] = "eOT.MealOrderTo.Label";
		names[namesCount++] = "eOT.DietType.Label";
		names[namesCount++] = "eOT.MealClass.Label";
		names[namesCount++] = "eOT.MealType.Label";
		names[namesCount++] = "eOT.NoOfOrders.Label"; //MuthuN
	}
	//Added Against End 832-CRF	
	var checkVal = checkNullSelect(fields, names);
	if (checkVal == false) {
		return false;
	} else {
		var flag = 0;
	//Added Against ML-MMOH-CRF-0825 Starts		
	var lateIrregularDietOrderSt = document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_ST").value;
	var current_date = document.getElementById("current_date").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getMealTypeForCatSTF&meal_Category="+mealCategoryVal;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???"); 
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
	for(var i=0; i < retVal_arr.length; i++){
		var mealCode_Arr = retVal_arr[i].split(":::");
		var meal_type_code= mealCode_Arr[0];
		var meal_type_desc= mealCode_Arr[1];
		var ServingStartTime= mealCode_Arr[2];
			if(ServingStartTime==null || ServingStartTime=="null" || ServingStartTime== "undefined"){
				ServingStartTime="";
			}		
		var ServingEndTime= mealCode_Arr[3];
			if(ServingEndTime==null || ServingEndTime=="null" || ServingEndTime== "undefined"){
				ServingEndTime="";
			}
		var IrregularStartTime= mealCode_Arr[4];
			if(IrregularStartTime==null || IrregularStartTime=="null" || IrregularStartTime== "undefined") 
			IrregularStartTime="";
		var IrregularEndTime= mealCode_Arr[5];
			if(IrregularEndTime==null || IrregularEndTime=="null" || IrregularEndTime== "undefined"){
				IrregularEndTime="";
			}
		var MealOrder= mealCode_Arr[6];
		var nextServingStartTime= mealCode_Arr[7];
			if(IrregularEndTime==""){
			IrregularEndTime = nextServingStartTime;
			}
		if(lateIrregularDietOrderSt == "Y" && IrregularStartTime!="" && IrregularEndTime!="" && IrregularStartTime < Sys_time && IrregularEndTime > Sys_time){
				var msg=getMessage("DS_IRREGULAR_DIET_ORDER","DS");
				msg=msg.replace("#", current_date);
				msg+=""+meal_type_desc;
				if(mealTypeVal==meal_type_code)
				alert(msg);
		}
	}
	//Added Against ML-MMOH-CRF-0825 Ends
var rowValue = document.getElementById("rowId");
if (rowValue.value != ""){
	var mealRecord = parent.mealOrderArray[rowValue.value];
	// Modified Against start 832 crf changes
	if(chkYN=="Y"){
	mealRecord[0] = menuTypeText;
	mealRecord[1] = menuTypeVal;	
	mealRecord[2] = mealOrderFrom;	
	mealRecord[3] = mealOrderTo;
	mealRecord[4] = dietTypeText;
	mealRecord[5] = dietTypeVal;
	mealRecord[6] = mealClassText;
	mealRecord[7] = mealClassVal;
	mealRecord[8] = mealTypeText;
	mealRecord[9] = mealTypeVal;
	mealRecord[10] = noOfOrders;
	mealRecord[11] = mealCategoryText;
	mealRecord[12] = mealCategoryVal;
	mealRecord[13] = practitioner_name;
	mealRecord[14] = dietLocationText;
	mealRecord[15] = dietLocationVal;
	mealRecord[16] = practId;
	mealRecord[17] = orderedBy;	
	mealRecord[18] = last_addedById;
	mealRecord[19] = last_modifiedById;
	mealRecord[20] = mode;
	mealRecord[21] = staff_order_id;		
	mealRecord[22] = total_cnt;		
	}else{
	mealRecord[0] = mealOrderFrom;
	mealRecord[1] = mealOrderTo;
	mealRecord[2] = dietTypeText;
	mealRecord[3] = dietTypeVal;
	mealRecord[4] = mealClassText;
	mealRecord[5] = mealClassVal;
	mealRecord[6] = mealTypeText;
	mealRecord[7] = mealTypeVal;
	mealRecord[8] = noOfOrders;
	mealRecord[9] = mealCategoryText;
	mealRecord[10] = mealCategoryVal;
	mealRecord[11] = practitioner_name;
	mealRecord[12] = dietLocationText;
	mealRecord[13] = dietLocationVal;
	mealRecord[14] = practId;
	mealRecord[15] = orderedBy;	
	mealRecord[16] = last_addedById;
	mealRecord[17] = last_modifiedById;
	mealRecord[18] = mode;
	mealRecord[19] = staff_order_id;
	mealRecord[20] = total_cnt;
	}		
// Modified Against End 832 crf changes
	flag = 1;
	displayDetails();
	resetData();	
	rowValue.value = "";			
	}
	var flag2=""; 
	var count = parent.mealOrderArray.length;
	//var count =  parent.details_frame.document.getElementById('rowCount1').value;
	//count++;
	if (flag != 1) {		
	  for (var i = 0; i < parent.mealOrderArray.length; i++) {
	    var mealRecord = parent.mealOrderArray[i];		
		//Modified Against 832-CRF
		mode ="insert";	
		staff_order_id=""; //Added Against Start IN-065835
		if(chkYN=="Y"){
	     if( mealRecord[1]==menuTypeVal && mealRecord[2]== mealOrderFrom && mealRecord[3]== mealOrderTo && mealRecord[5]==dietTypeVal && mealRecord[7]==mealClassVal && mealRecord[9]==mealTypeVal && mealRecord[12]==mealCategoryVal && mealRecord[15]==dietLocationVal  && mealRecord[16]==practId) // Added practId against ML-MMOH-SCF-1738
		 { 
			flag2="sameVal";
		 }
		}else{
		 if(mealRecord[0] == mealOrderFrom && mealRecord[1] == mealOrderTo && mealRecord[3] == dietTypeVal && mealRecord[5] == mealClassVal && mealRecord[7] == mealTypeVal && mealRecord[10] == mealCategoryVal && mealRecord[13] == dietLocationVal&& mealRecord[14] == practId){ //Added practId Against ML-MMOH-SCF-1795
			flag2="sameVal";
		 }	
		}
	  }
	  
	  //Added by Gaurav Against ML-MMOH-SCF-2400...starts
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=checkOrderForStaff&menuTypeVal="+menuTypeVal+"&mealOrderFrom="+mealOrderFrom+"&mealOrderTo="+mealOrderTo+"&dietTypeVal="+dietTypeVal+"&mealClassVal="+mealClassVal+"&mealTypeVal="+mealTypeVal+"&meal_Category="+mealCategoryVal+"&dietLocationVal="+dietLocationVal+"&isMenuType="+isMenuType+"&practId="+practId;	
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
		xmlHttp.send(xmlDoc);
		var retVal2 = trimString(xmlHttp.responseText);
		if(retVal2 >= '1') flag2 = "sameVal";	  
	//Added by Gaurav Against ML-MMOH-SCF-2400...ends   
	  
	  if(flag2 !="sameVal"){
		parent.mealOrderArray[count]=new Array();
		//Modified Against Start 832 crf
		if(chkYN=="Y"){
		parent.mealOrderArray[count][0] = menuTypeText;
		parent.mealOrderArray[count][1] = menuTypeVal;
		parent.mealOrderArray[count][2] = mealOrderFrom;
		parent.mealOrderArray[count][3] = mealOrderTo;
		parent.mealOrderArray[count][4] = dietTypeText;
		parent.mealOrderArray[count][5] = dietTypeVal;
		parent.mealOrderArray[count][6] = mealClassText;
		parent.mealOrderArray[count][7] = mealClassVal;
		parent.mealOrderArray[count][8] = mealTypeText;
		parent.mealOrderArray[count][9] = mealTypeVal;
		parent.mealOrderArray[count][10] = noOfOrders;
		parent.mealOrderArray[count][11] = mealCategoryText;
		parent.mealOrderArray[count][12] = mealCategoryVal;
		parent.mealOrderArray[count][13] = practitioner_name;
		parent.mealOrderArray[count][14] = dietLocationText;
		parent.mealOrderArray[count][15] = dietLocationVal;
		parent.mealOrderArray[count][16] = practId;
		parent.mealOrderArray[count][17] = orderedBy;
		parent.mealOrderArray[count][18] = last_addedById;
		parent.mealOrderArray[count][19] = last_modifiedById;
		parent.mealOrderArray[count][20] = mode;
		parent.mealOrderArray[count][21] = staff_order_id;
		parent.mealOrderArray[count][22] = total_cnt;
		parent.mealOrderArray[count][23] = status;
		parent.mealOrderArray[count][24] = parent.rowVal;
		}else{
		parent.mealOrderArray[count][0] = mealOrderFrom;
		parent.mealOrderArray[count][1] = mealOrderTo;
		parent.mealOrderArray[count][2] = dietTypeText;
		parent.mealOrderArray[count][3] = dietTypeVal;
		parent.mealOrderArray[count][4] = mealClassText;
		parent.mealOrderArray[count][5] = mealClassVal;
		parent.mealOrderArray[count][6] = mealTypeText;
		parent.mealOrderArray[count][7] = mealTypeVal;
		parent.mealOrderArray[count][8] = noOfOrders;
		parent.mealOrderArray[count][9] = mealCategoryText;
		parent.mealOrderArray[count][10] = mealCategoryVal;
		parent.mealOrderArray[count][11] = practitioner_name;
		parent.mealOrderArray[count][12] = dietLocationText;
		parent.mealOrderArray[count][13] = dietLocationVal;
		parent.mealOrderArray[count][14] = practId;
		parent.mealOrderArray[count][15] = orderedBy;
		parent.mealOrderArray[count][16] = last_addedById;			
		parent.mealOrderArray[count][17] = last_modifiedById;
		parent.mealOrderArray[count][18] = mode;
		parent.mealOrderArray[count][19] = staff_order_id;
		parent.mealOrderArray[count][20] = total_cnt;
		parent.mealOrderArray[count][21] = status;
		parent.mealOrderArray[count][22] = parent.rowVal;
		//parent.mealOrderArray[count][15] = i;					
		}
		//Modified Against End 832 crf			
		parent.rowVal = parent.rowVal + 1;			
		//count++;
		parent.details_frame.document.getElementById('rowCount1').value = count + 1;
		displayDetails();
		resetData();
		}
		else {
			alert(getMessage("DS_REC_EXISTS","DS"));
		}
	}
}
}

function displayDetails() {
	var htmlContent = "";
	var qryEven = "QRYEVEN";
	var qryOdd = "QRYODD";
	//Added Against Start 832 crf
	var isMenuType =document.getElementById("isMenuType").value;
	var chkYN="";
	if(isMenuType=="true")
		chkYN="Y";
	else	
		chkYN="N";
	//Added Against End 832 crf
	var tableObj = parent.details_frame.document.getElementById('mealOrderTable');
	while (tableObj.rows.length > 1) {
		tableObj.deleteRow(1);
	}
	index = 1;
	index = parseInt(index);
	for (var i = 0,counter=1; i <parent.mealOrderArray.length; i++,counter++) {
		var mealRecord = parent.mealOrderArray[i];
		//Modified Against Start 832 crf
	if(chkYN=="Y"){
		var menuTypeText=mealRecord[0];
		var menuTypeVal=mealRecord[1];
		var mealOrderFrom=mealRecord[2];
		var mealOrderTo=mealRecord[3];
		var dietTypeText=mealRecord[4];
		var dietTypeVal=mealRecord[5];
		var mealClassText=mealRecord[6];
		var mealClassVal=mealRecord[7];
		var mealTypeText=mealRecord[8];
		var mealTypeVal=mealRecord[9];
		var noOfOrders=mealRecord[10];
		var mealCategoryText=mealRecord[11];
		var mealCategoryVal=mealRecord[12];
		var practitioner_name=mealRecord[13];
		var dietLocationText=mealRecord[14];
		var dietLocationVal=mealRecord[15];
		var practId=mealRecord[16];
		var orderedBy=mealRecord[17];
		var last_addedById=mealRecord[18];
		var last_modifiedById=mealRecord[19];
		var mode=mealRecord[20];
		var staff_order_id=mealRecord[21];
		var total_cnt=mealRecord[22];
		var status=mealRecord[23];			
		var rowId = i;	//var rowId=mealRecord[22];	consider As 20th Param 	
		}else{
		var mealOrderFrom=mealRecord[0];
		var mealOrderTo=mealRecord[1];
		var dietTypeText=mealRecord[2];
		var dietTypeVal=mealRecord[3];
		var mealClassText=mealRecord[4];
		var mealClassVal=mealRecord[5];
		var mealTypeText=mealRecord[6];
		var mealTypeVal=mealRecord[7];
		var noOfOrders=mealRecord[8];
		var mealCategoryText=mealRecord[9];
		var mealCategoryVal=mealRecord[10];
		var practitioner_name=mealRecord[11];
		var dietLocationText=mealRecord[12];
		var dietLocationVal=mealRecord[13];
		var practId=mealRecord[14];
		var orderedBy=mealRecord[15];
		var last_addedById=mealRecord[16];		
		var last_modifiedById=mealRecord[17];
		var mode=mealRecord[18];
		var staff_order_id=mealRecord[19];
		var total_cnt=mealRecord[20];
		var status=mealRecord[21];		
		var rowId = i; // consider As 20th Param mealRecord[20];//var rowId=mealRecord[20];
		}		
		//Modified Against End 832 crf
		var classVal = (i % 2 == 0) ? qryEven : qryOdd;
		var row = tableObj.insertRow(index);
		var col1 = row.insertCell();
		col1.style.fontWeight = "normal";  
		col1.className = classVal;
		//Start CRF-832
		if(chkYN=="Y"){		
		  if(total_cnt > 0 ){
		  var temp = dietTypeText;
		  }else{					
			var temp="<a href=\"javascript:updateRecord1('"+ menuTypeText + "','" + menuTypeVal + "','" + mealOrderFrom + "','" + mealOrderTo + "','" + dietTypeText + "','" + dietTypeVal + "','" + mealClassText + "','" + mealClassVal + "','" + mealTypeText + "','" + mealTypeVal + "','" + noOfOrders + "','" + mealCategoryText + "','" + mealCategoryVal + "','" + practitioner_name + "','" + dietLocationText + "','" + dietLocationVal + "','"+practId+"','"+orderedBy+"','"+last_addedById+"','"+last_modifiedById+"','"+mode+"','"+staff_order_id+"','"+total_cnt+"','" + rowId + "')\">" + dietTypeText;
		  }
		/*Added Against Start IN-065835 */  
		if(practitioner_name=="")
		practitioner_name="&nbsp";
		if(orderedBy=="")
			orderedBy="&nbsp";
		if(last_modifiedById=="")
			last_modifiedById="&nbsp";
		/*Added Against End IN-065835 */  	
		col1.innerHTML = menuTypeText+"<input type='hidden' name='menuType"+counter+"' id='menuType"+counter+"' value='"+menuTypeVal+"'>";
		
		var col2 = row.insertCell();
		col2.style.fontWeight = "normal";  
		col2.className = classVal;
		col2.innerHTML = mealOrderFrom+"<input type='hidden' name='mealOrderFrom"+counter+"' id='mealOrderFrom"+counter+"' value='"+mealOrderFrom+"'>";
		col2.align="left";
		
		var col3 = row.insertCell();
		col3.style.fontWeight = "normal";  
		col3.className = classVal;
		col3.innerHTML = mealOrderTo+"<input type='hidden' name='mealOrderTo"+counter+"' id='mealOrderTo"+counter+"' value='"+mealOrderTo+"'>";
		col3.align="left";
		
		var col4 = row.insertCell();
		col4.style.fontWeight = "normal";  
		col4.className = classVal;
		col4.innerHTML = temp+"<input type='hidden' name='dietTypeValue"+counter+"' id='dietTypeValue"+counter+"' value='"+dietTypeVal+"'>";
		col4.align="left";
		
		var col5 = row.insertCell();
		col5.style.fontWeight = "normal";  
		col5.className = classVal;
		col5.innerHTML = mealClassText+"<input type='hidden' name='mealClassValue"+counter+"' id='mealClassValue"+counter+"' value='"+mealClassVal+"'>";
		col5.align="right";

		var col6 = row.insertCell();
		col6.style.fontWeight = "normal";  
		col6.className = classVal;
		col6.innerHTML = mealTypeText+"<input type='hidden' name='mealTypeValue"+counter+"' id='mealTypeValue"+counter+"' value='"+mealTypeVal+"'>";
		col6.align="right";
		
		var col7 = row.insertCell();
		col7.style.fontWeight = "normal";  
		col7.className = classVal;
		col7.innerHTML = noOfOrders+"<input type='hidden' name='noOfOrders"+counter+"' id='noOfOrders"+counter+"' value='"+noOfOrders+"'>";
		col7.align="right";
		
		var col8 = row.insertCell();
		col8.style.fontWeight = "normal";  
		col8.className = classVal;
		col8.innerHTML = mealCategoryText+"<input type='hidden' name='mealCategory"+counter+"' id='mealCategory"+counter+"' value='"+mealCategoryVal+"'>";
		col8.align="right";

		var col9 = row.insertCell();
		col9.style.fontWeight = "normal";  
		col9.className = classVal;
		//col9.innerHTML = practitioner_name+"<input type='hidden' name='practitioner_name"+counter+"' id='practitioner_name"+counter+"' value='"+practitioner_name+"'>";
		col9.innerHTML = practitioner_name+"<input type='hidden' name='practId"+counter+"' id='practId"+counter+"' value='"+practId+"'>";
		col9.align="right";
		
		var col10 = row.insertCell();
		col10.style.fontWeight = "normal";  
		col10.className = classVal;
		col10.innerHTML = dietLocationText+"<input type='hidden' name='dietLocation"+counter+"' id='dietLocation"+counter+"' value='"+dietLocationVal+"'>";
		col10.align="right"; 
		
		var col11 = row.insertCell();
		col11.style.fontWeight = "normal";  
		col11.className = classVal;
		col11.innerHTML = orderedBy+"<input type='hidden' name='last_addedById"+counter+"' id='last_addedById"+counter+"' value='"+last_addedById+"'><input type='hidden' name='mode"+counter+"' id='mode"+counter+"' value='"+mode+"'>";
		col11.align="right";
		
		var col12 = row.insertCell();
		col12.style.fontWeight = "normal";  
		col12.className = classVal;
		col12.innerHTML = last_modifiedById+"<input type='hidden' name='last_modifiedById"+counter+"' id='last_modifiedById"+counter+"' value='"+last_modifiedById+"'>";
		col12.align="right";
		
		var DELETE= "DELETE";
		var temp1="<a href=\"javascript:deleteRecord('"+staff_order_id+"','"+rowId+"')\">" + DELETE;
		if(total_cnt > 0){
		var temp1= DELETE;	
		}else{
		var temp1="<a href=\"javascript:deleteRecord('"+staff_order_id+"','"+rowId+"')\">" + DELETE;
		}	
			
		var col13 = row.insertCell();
		col13.style.fontWeight = "normal";  
		col13.className = classVal;
		col13.innerHTML = temp1+"<input type='hidden' name='staff_order_id"+counter+"' id='staff_order_id"+counter+"' value='"+staff_order_id+"'>";
		col13.align="right";
		 }else{		 

		 if(total_cnt > 0 ){
		 var temp = dietTypeText;

		 }else{
		var temp="<a href=\"javascript:updateRecord('"+ mealOrderFrom + "','" + mealOrderTo + "','" + dietTypeText + "','" + dietTypeVal + "','" + mealClassText + "','" + mealClassVal + "','" + mealTypeText + "','" + mealTypeVal + "','" + noOfOrders + "','" + mealCategoryText + "','" + mealCategoryVal + "','" + practitioner_name + "','" + dietLocationText + "','" + dietLocationVal + "','"+practId+"','"+orderedBy+"','"+last_addedById+"','"+last_modifiedById+"','"+mode+"','"+staff_order_id+"','"+total_cnt+"','"+rowId+"')\">" + dietTypeText;		
		}
		/*Added Against Start IN-065835 */  
		if(practitioner_name=="")
			practitioner_name="&nbsp";
		if(orderedBy=="")
			orderedBy="&nbsp";
		if(last_modifiedById=="")
			last_modifiedById="&nbsp";
		/*Added Against End IN-065835 */  
		
		//Modified Against Start 832 crf 
		col1.innerHTML = mealOrderFrom+"<input type='hidden' name='mealOrderFrom"+counter+"' id='mealOrderFrom"+counter+"' value='"+mealOrderFrom+"'>";
		
		var col2 = row.insertCell();
		col2.style.fontWeight = "normal";  
		col2.className = classVal;
		col2.innerHTML = mealOrderTo+"<input type='hidden' name='mealOrderTo"+counter+"' id='mealOrderTo"+counter+"' value='"+mealOrderTo+"'>";
		col2.align="left";
		
		var col3 = row.insertCell();
		col3.style.fontWeight = "normal";  
		col3.className = classVal;
		col3.innerHTML = temp+"<input type='hidden' name='dietTypeValue"+counter+"' id='dietTypeValue"+counter+"' value='"+dietTypeVal+"'>";
		col3.align="left";
		
		var col4 = row.insertCell();
		col4.style.fontWeight = "normal";  
		col4.className = classVal;
		col4.innerHTML = mealClassText+"<input type='hidden' name='mealClassValue"+counter+"' id='mealClassValue"+counter+"' value='"+mealClassVal+"'>";
		col4.align="right";
		
		var col5 = row.insertCell();
		col5.style.fontWeight = "normal";  
		col5.className = classVal;
		col5.innerHTML = mealTypeText+"<input type='hidden' name='mealTypeValue"+counter+"' id='mealTypeValue"+counter+"' value='"+mealTypeVal+"'>";
		col5.align="right";
				
		var col6 = row.insertCell();
		col6.style.fontWeight = "normal";  
		col6.className = classVal;
		col6.innerHTML = noOfOrders+"<input type='hidden' name='noOfOrders"+counter+"' id='noOfOrders"+counter+"' value='"+noOfOrders+"'>";
		col6.align="right";
		
		var col7 = row.insertCell();
		col7.style.fontWeight = "normal";  
		col7.className = classVal;
		col7.innerHTML = mealCategoryText+"<input type='hidden' name='mealCategory"+counter+"' id='mealCategory"+counter+"' value='"+mealCategoryVal+"'>";
		col7.align="right";

		var col8 = row.insertCell();
		col8.style.fontWeight = "normal";  
		col8.className = classVal;
		//col8.innerHTML = practitioner_name+"<input type='hidden' name='practitioner_name"+counter+"' id='practitioner_name"+counter+"' value='"+practitioner_name+"'>";
		col8.innerHTML = practitioner_name+"<input type='hidden' name='practId"+counter+"' id='practId"+counter+"' value='"+practId+"'>";
		col8.align="right";
		
		var col9 = row.insertCell();
		col9.style.fontWeight = "normal";  
		col9.className = classVal;
		col9.innerHTML = dietLocationText+"<input type='hidden' name='dietLocation"+counter+"' id='dietLocation"+counter+"' value='"+dietLocationVal+"'>";
		col9.align="right";
		var col10 = row.insertCell();
		col10.style.fontWeight = "normal";  
		col10.className = classVal;
		//col10.innerHTML = orderedBy+"<input type='hidden' name='last_addedById"+counter+"' id='last_addedById"+counter+"' value='"+last_addedById+"'><input type='hidden' name='mode"+counter+"' id='mode"+counter+"' value='"+mode+"'><input type='hidden' name='staff_order_id"+counter+"' id='staff_order_id"+counter+"' value='"+staff_order_id+"'>"; // for testing
		col10.innerHTML = orderedBy+"<input type='hidden' name='last_addedById"+counter+"' id='last_addedById"+counter+"' value='"+last_addedById+"'><input type='hidden' name='mode"+counter+"' id='mode"+counter+"' value='"+mode+"'>";
		col10.align="right";
		// added newly
		
		var col11 = row.insertCell();
		col11.style.fontWeight = "normal";  
		col11.className = classVal;
		col11.innerHTML = last_modifiedById+"<input type='hidden' name='last_modifiedById"+counter+"' id='last_modifiedById"+counter+"' value='"+last_modifiedById+"'>";
		col11.align="right";
		
		var DELETE= "DELETE";
		var temp1="<a href=\"javascript:deleteRecord('"+staff_order_id+"','"+rowId+"')\">" + DELETE;
		
		if(total_cnt > 0){
		var temp1= DELETE;	
		}else{
		var temp1="<a href=\"javascript:deleteRecord('"+staff_order_id+"','"+rowId+"')\">" + DELETE;
		}	
		var col12 = row.insertCell();
		col12.style.fontWeight = "normal";  
		col12.className = classVal;
		col12.innerHTML = temp1+"<input type='hidden' name='staff_order_id"+counter+"' id='staff_order_id"+counter+"' value='"+staff_order_id+"'>";		
		//col11.innerHTML = orderedBy+"<input type='hidden' name='last_addedById"+counter+"' id='last_addedById"+counter+"' value='"+last_addedById+"'><input type='hidden' name='mode"+counter+"' id='mode"+counter+"' value='"+mode+"'><input type='hidden' name='staff_order_id"+counter+"' id='staff_order_id"+counter+"' value='"+staff_order_id+"'>";
		//col11.align="right";
		} 
		//Modified Against End CRF-832
		index++;
	}
}

function onSuccess(){
	if(parent.frames[1].name=='f_query_add_mod') {
		parent.f_query_add_mod.location.reload();
		/* Added Against Start for ML-MMOH-CRF-0730 */
		var error  = "APP-DS0001 Operation Completed Successfully...";
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;	
		/* Added Against End for ML-MMOH-CRF-0730 */
	}
	else f_query_add_mod.location.reload();
}

function resetData() {

	var menuType = document.getElementById("menuType");
	//menuType.value = "";

	var dietType = document.getElementById("DietType");
	dietType.value = "";

	var mealClass = document.getElementById("MealClass");
	mealClass.value = "";

	var mealCategory = document.getElementById("mealCategory");
	//mealCategory.value = "";
	
	var noOfOrders = document.getElementById("noOfOrders");
	noOfOrders.value = "";
	
	var mealType = document.getElementById("MealType");
	mealType.value = "";

	var current_date = document.getElementById("current_date").value;
	
	var mealOrderFrom = document.getElementById("mealOrderFrom");
	mealOrderFrom.value=current_date;
	
	var mealOrderTo = document.getElementById("mealOrderTo");
	mealOrderTo.value=current_date;	
}

function createNewRecord() {
	//var idValue = document.getElementById("recordId").value;
	var idValue=document.NewRecord["recordId"].value	
	/*top.returnValue = idValue;
	top.close();*/
	parent.document.getElementById('dialog-body').contentWindow.returnValue = idValue; 
	parent.document.getElementById('dialog_tag').close();
}

function cancelTransaction() {
	parent.document.getElementById('dialog-body').contentWindow.returnValue = "0"; 
	parent.document.getElementById('dialog_tag').close();
}

function  reset(){
	parent.content.f_query_add_mod.location.href='../../eDS/jsp/MealOrderForStaffsFrame.jsp';
}

function checkNullSelect(fields, names) {
	var f1;
	var error = "";
	var key_value = new Array();
	var msgArray = new Array();
	for (j = 0; j < fields.length; j++) {
		if (fields[j] == "") {
			label=getLabel(names[j],"OT");
			key_value[j] = label;			
			error = error + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",key_value[j])+"<br>";
			f1 = false;
		}
	}
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	if (f1 == false) return false;else return true;
}

function calDietMealStatus() {
	var mealCategory = document.getElementById("mealCategory").value;
	var locale = document.getElementById("locale").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=get_DietType_MealStatus&locale="+locale+"&meal_Category="+mealCategory;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retVal_arr = retVal.split("##");
		if(retVal_arr.length >0) {
			var dietType_code= retVal_arr[0];
			var mealClass_code= retVal_arr[1];
			document.getElementById("DietType").value=dietType_code;
			document.getElementById("MealClass").value=mealClass_code;
	}
}

function chkMealOrders(){
	obj =  String.fromCharCode(window.event.keyCode);
   	var alphaFilter =/^[0-9]+$/;
   	if (!(alphaFilter.test(obj))) {
   	var errorMsg=getMessage("NUMERIC_ENTRY_ONLY","OT");
   	window.event.keyCode = 27;
		}else{
	}
}
	
/*Added Start for ML-MMOH-CRF-0730*/
function chkMealOrdersReceived(){
	obj =  String.fromCharCode(window.event.keyCode);
	var TB = document.getElementById("noOfMealsreceived").value;
	var TextLength = TB.length;
   	var alphaFilter =/^[0-9]+$/;
 	if((48 == event.keyCode) && (0 == TextLength)){
		if(document.forms[0].noOfMealsreceived.value != null || document.forms[0].noOfMealsreceived.value !='')
		{
		document.forms[0].noOfMealsreceived.value='';
		document.forms[0].noOfMealsreceived.focus();
		window.event.keyCode = 27;
		return false;
		}
	}
  	else if (!(alphaFilter.test(obj))) {
			var errorMsg=getMessage("NUMERIC_ENTRY_ONLY","OT");
			window.event.keyCode = 27;
	}else{
	}
}

function chkMealOrdersRejected(){
	obj =  String.fromCharCode(window.event.keyCode);
	var TB1 = document.getElementById("noOfMealsreject").value;
	var TextLength1 = TB1.length;
   	var alphaFilter =/^[0-9]+$/;
 	if((48 == event.keyCode) && (0 == TextLength1)){
		if(document.forms[0].noOfMealsreject.value != null || document.forms[0].noOfMealsreject.value !=''){
		document.forms[0].noOfMealsreject.value='';
		document.forms[0].noOfMealsreject.focus();
		window.event.keyCode = 27;
		return false;
		}
	}
  	else if (!(alphaFilter.test(obj))) {
			var errorMsg=getMessage("NUMERIC_ENTRY_ONLY","OT");
			window.event.keyCode = 27;
	}else{
		Complaint(this);
	}
}

function chkMealOrderServed(){
	obj =  String.fromCharCode(window.event.keyCode);
	var TB2 = document.getElementById("noOfMealsServed").value;
	var TextLength2 = TB2.length;
   	var alphaFilter =/^[0-9]+$/;
 	if((48 == event.keyCode) && (0 == TextLength2)){
		if(document.forms[0].noOfMealsServed.value != 'null' || document.forms[0].noOfMealsServed.value !='')
	  {
		document.forms[0].noOfMealsServed.value='';
		document.forms[0].noOfMealsServed.focus();
		window.event.keyCode = 27;
		return false;
	  }
	}
  	else if (!(alphaFilter.test(obj))) {
			var errorMsg=getMessage("NUMERIC_ENTRY_ONLY","OT");
			window.event.keyCode = 27;
	}else{
	}
}
/*Added End for ML-MMOH-CRF-0730*/

//function updateRecord(dietTypeText, dietTypeVal, mealClassText, mealClassVal, mealTypeText, mealTypeVal, noOfOrders, rowVal) {

function updateRecord(mealOrderFrom, mealOrderTo, dietTypeText, dietTypeVal, mealClassText, mealClassVal, mealTypeText, mealTypeVal, noOfOrders, mealCategoryText, mealCategoryVal, practitioner_name, dietLocationText, dietLocationVal, practId,orderedBy,last_addedById,last_modifiedById,mode,staff_order_id,total_cnt,rowVal) { //CRF-832
	//Diet Type
	var dietType = document.getElementById("DietType");
	dietType.text = dietTypeText;
	dietType.value = dietTypeVal;
	//Meal Class
	//MealOrderResultForm document.forms[0].name 
	var mealClass = document.getElementById("MealClass");				
	 mealClass.text = mealClassText;
	 mealClass.value = mealClassVal;
	//Meal Type
	var mealType = document.getElementById("MealType");
	mealType.text = mealTypeText;
	mealType.value = mealTypeVal;
	var noOfOrdersVal = document.getElementById("noOfOrders");
	noOfOrdersVal.value = noOfOrders;
	//Added Against Start CRF-832
	//Meal Category 
	var mealCategory = document.getElementById("mealCategory");
	mealCategory.text=mealCategoryText;
	mealCategory.value=mealCategoryVal;
	callPractitioner(mealCategory);
	//Practitioner Name
	var practitioner_nameVal = document.getElementById("practitioner_name");
	practitioner_nameVal.value = practitioner_name;
	//Diet Location 
	var dietLocation = document.getElementById("dietLocation");	
	dietLocation.text=dietLocationText;
	dietLocation.value=dietLocationVal;
	//Order Date From 
	var mealOrderFromVal = document.getElementById("mealOrderFrom");
	mealOrderFromVal.Text = mealOrderFrom;
	mealOrderFromVal.value = mealOrderFrom;
	//Order Date To 
	var mealOrderToVal = document.getElementById("mealOrderTo");
	mealOrderToVal.Text = mealOrderTo;
	mealOrderToVal.value = mealOrderTo;
	//Added Against End 832 CRF
	var practitioner = document.getElementById("practitioner");
	practitioner.value = practId;
	
	var orderedBy1 = document.getElementById("orderedBy");
	orderedBy1.value = orderedBy;
	
	var last_addedById1 = document.getElementById("last_addedById");
	last_addedById1.value = last_addedById;
	
	
	var last_modifiedById1 = document.getElementById("last_modifiedById");
	last_modifiedById1.value = last_modifiedById;	
	
	var rowValue = document.getElementById("rowId");
	rowValue.value = rowVal;
		
 	var modeValue = document.getElementById("mode");
	modeValue.value = mode;

	
	var staff_order = document.getElementById("staff_order_id");
	staff_order.value = staff_order_id;
	
	var total_cnt1 = document.getElementById("total_cnt");
	total_cnt1.value = total_cnt;	
	
	changeMealType1(mealTypeText,mealTypeVal); //fixed
}

//Added Against Start CRF-832
function updateRecord1(menuTypeText, menuTypeVal, mealOrderFrom, mealOrderTo, dietTypeText, dietTypeVal, mealClassText, mealClassVal, mealTypeText, mealTypeVal, noOfOrders, mealCategoryText, mealCategoryVal, practitioner_name, dietLocationText, dietLocationVal,practId,orderedBy,last_addedById,last_modifiedById,mode,staff_order_id,total_cnt,rowVal) { //CRF-832
	// Menu Type
	var MenuType = document.getElementById("menuType");
	MenuType.text = menuTypeText;
	MenuType.value = menuTypeVal;
	//Diet Type
	var dietType = document.getElementById("DietType");
	dietType.text = dietTypeText;
	dietType.value = dietTypeVal;
	//Meal Class
	var mealClass = document.getElementById("MealClass");
	mealClass.text = mealClassText;
	mealClass.value = mealClassVal;
	//Meal Type
	var mealType = document.getElementById("MealType");
	mealType.text = mealTypeText;
	mealType.value = mealTypeVal;
	var noOfOrdersVal = document.getElementById("noOfOrders");
	noOfOrdersVal.value = noOfOrders;	
	//Meal Category 
	var mealCategory = document.getElementById("mealCategory");
	mealCategory.text=mealCategoryText;
	mealCategory.value=mealCategoryVal;
	callPractitioner(mealCategory);
	//Practitioner Name
	var practitioner_nameVal = document.getElementById("practitioner_name");
	practitioner_nameVal.value = practitioner_name;
	//Diet Location 
	var dietLocation = document.getElementById("dietLocation");
	dietLocation.text=dietLocationText;
	dietLocation.value=dietLocationVal;
	//Order Date From 
	var mealOrderFromVal = document.getElementById("mealOrderFrom");
	mealOrderFromVal.Text = mealOrderFrom;
	mealOrderFromVal.value = mealOrderFrom;
	//Order Date To 
	var mealOrderToVal = document.getElementById("mealOrderTo");
	mealOrderToVal.Text = mealOrderTo;
	mealOrderToVal.value = mealOrderTo;
	
	var practitioner = document.getElementById("practitioner");
	practitioner.value = practId;
	
	var orderedBy1 = document.getElementById("orderedBy");
	orderedBy1.value = orderedBy;
	
	var last_addedById1 = document.getElementById("last_addedById");
	last_addedById1.value = last_addedById;
	
	var last_modifiedById1 = document.getElementById("last_modifiedById");
	last_modifiedById1.value = last_modifiedById;	
	
	var rowValue = document.getElementById("rowId");
	rowValue.value = rowVal;
	
	var modeValue = document.getElementById("mode");
	modeValue.value = mode;
	
	var staff_order = document.getElementById("staff_order_id");
	staff_order.value = staff_order_id;
	
	var total_cnt1 = document.getElementById("total_cnt");
	total_cnt1.value = total_cnt;
	
	changeMealType1(mealTypeText,mealTypeVal); 
}

//Added Against End 832 CRF
function apply(){ 
	var tabId=parent.content.f_query_add_mod.tab_frame.MealOrderForStaffsTabForm.document.getElementById('viewID').value;
	if(tabId == "mealOrderTab"){
	var tableObj = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealOrderTable');
	var fromDate=parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealOrderFrom').value;
	fromDate = convertDate(fromDate,"DMY", locale, "en"); 
	var toDate=parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById("mealOrderTo").value;
	toDate = convertDate(toDate,"DMY", locale, "en"); 
		if(tableObj.rows.length <= 1){
			var error = getMessage("ATLEAST_ONE_SELECTED","common");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
			return false;
		}

		if (fromDate != "" && toDate != "") {
		var locale=parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('locale').value;
	
		var returnVal =  compareDates(fromDate,toDate,'en',"DMY");
			if(returnVal == -1){
				var error = getMessage("DS_ORDFRMDATE_LESSOREQL_ORDTODATE","DS");
				messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}
			else{
				afterApply();
			}
		}
		else{
			afterApply();
		}
	}

	if(tabId == "mealServedTab"){
		var f_date = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('mealOrderFrom').value;
		f_date = convertDate(f_date,"DMY", locale, "en"); // Date Localization
		var t_date = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('mealOrderTo').value
		t_date = convertDate(t_date,"DMY", locale, "en"); // Date Localization

		if (f_date != "" && t_date != "") {
			var locale=parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('locale').value;
			var returnVal =  compareDates(f_date,t_date,'en',"DMY");
			if(returnVal == -1){
				// TO DO: MESSAGE
				var error = getMessage("DS_ORDFRMDATE_LESSOREQL_ORDTODATE","DS");//"APP-NF0004 Order Date From should be less than or equal to Order Date To ";
				messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			}
			else {
				afterApply();
			}
		}
		else {
			afterApply();
		}
	}
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
		var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
	var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
	}
	else {
	    var fromtimearray = from_time.split(":");
	    var totimearray = to_time.split(":");

	    var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
	    var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
	}
	if(Date.parse(todt) < Date.parse(fromdt)) {
	retVal=-1;
	}
	else if(Date.parse(todt) == Date.parse(fromdt)) {
	retVal=0;
	}
    }
	return retVal;
}

function afterApply() {
   var methodVal = parent.content.f_query_add_mod.details_frame.document.getElementById("method");
   var tabId=parent.content.f_query_add_mod.tab_frame.MealOrderForStaffsTabForm.document.getElementById('viewID').value;
   parent.content.f_query_add_mod.details_frame.document.forms[0].document.getElementById('tabId').value=tabId;
   var isMenuType = parent.content.f_query_add_mod.details_frame.document.forms[0].document.getElementById('isMenuType').value;
   //CRF-0684
   var checkVal;
   if (tabId == "mealOrderTab") {
	//CRF-0684
		var chkYN="";
		if(isMenuType=="true")
			chkYN="Y";
		else	
			chkYN="N";
	//CRF-0684		
		var fields = new Array();
		fields[0] = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealCategory').value;
		fields[1] = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealOrderFrom').value;
		fields[2] = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealOrderTo').value;
		
		//Added against Ml-MMOH-CRF-0678 Starts here //CRF-0684
		if(fields[0] == "DOC"){	
			fields[3]= parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('practitioner_name').value;	
		if(chkYN=="Y")
			fields[4] = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('menuType').value;// Added Against Start 0684-CRF
		}	
		else if(chkYN=="Y")
			fields[3] = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('menuType').value; 
		//Added Against End 0684-CRF 
		//Added against Ml-MMOH-CRF-0678 Ends here
		
		var names = new Array();
		names[0] = "eOT.MealCategory.Label";
		names[1] = "eOT.MealOrderFrom.Label";
		names[2] = "eOT.MealOrderTo.Label";
		
		//Added against Ml-MMOH-CRF-0678 Starts here //CRF-0684
		if(fields[0] == "DOC"){
			names[3] = "eDS.practitionerName.Label";	
		if(chkYN=="Y")
			names[4] = "eDS.MenuType.Label"; //Added Against Start 0684-CRF
		}
		else if(chkYN=="Y")
			names[3] = "eDS.MenuType.Label";
		//Added Against End 0684-CRF
		//Added against Ml-MMOH-CRF-0678 Ends here
		checkVal = checkNull(fields, names);
		}
		if (checkVal == false) {
			return false;
		} else{
 
//			var methodVal = parent.content.f_query_add_mod.details_frame.document.getElementById("method");
			var htmlContent = "";
			var menuOrderVals = "";
		if (tabId == "mealServedTab") {
			var formObj = parent.content.f_query_add_mod.details_frame.document.forms[0];
			formObj.method='post';
			formObj.action="../../servlet/eDS.MealOrderForStaffsServlet";

		if(docMealSerCheckNull()){
			var noOfMealsOrders = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('noOfOrders').value;
			var noOfMealsServed = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('noOfMealsServed').value;
			var totalNoOfMealsServed = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('totalNoOfMealsServed').value;
			/*Added Start for ML-MMOH-CRF-0730*/
			var totalnoOfMealsreceived = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('totalnoOfMealsreceived').value;
			var noOfMealsreceived = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('noOfMealsreceived').value;
			var totalNoOfMealsreject = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('totalNoOfMealsreject').value;
			var noOfMealsreject = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('noOfMealsreject').value;
			var complaintCode = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('complaintCode').value;
			/*Added End for ML-MMOH-CRF-0730*/
 		if( (parseInt(noOfMealsServed) !="" && parseInt(noOfMealsreceived) !="" && parseInt(noOfMealsreject)!="" ) &&(parseInt(noOfMealsOrders) >= parseInt(noOfMealsServed)+parseInt(totalNoOfMealsServed) && parseInt(totalNoOfMealsServed) >= parseInt(totalnoOfMealsreceived)+parseInt(noOfMealsreceived) && parseInt(noOfMealsOrders) >= parseInt(totalNoOfMealsreject)+parseInt(noOfMealsreject))){
			formObj.submit();
		}
	else {
 		//if((parseInt(noOfMealsServed) == null) &&  (parseInt(noOfMealsreceived) == null ) && (parseInt(noOfMealsreject) == null))
 		if((noOfMealsreceived =="") && (noOfMealsreject =="") && (noOfMealsServed==""))
			{
			var error = getMessage("DS_MEALSERVD_NORECEIVE_NOREJECT","DS");
			messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}	
		//if(noOfMealsOrders != "" && noOfMealsServed != ""){ // commented against ML-MMOH-CRF-0730
		else if(noOfMealsOrders != "" && parseInt(noOfMealsOrders)<parseInt(noOfMealsServed)+parseInt(totalNoOfMealsServed)){
			var error="";
						
			error = getMessage("DS_MEALSER_LESSOREQL_MEALSORDR","DS");//"No. of meals served should be less than or equal to No. of Meals ordered";
			messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
		//else if(totalNoOfMealsServed != "" && totalNoOfMealsServed != ""){
		else if(totalNoOfMealsServed != "" && parseInt(totalNoOfMealsServed) < parseInt(totalnoOfMealsreceived)+parseInt(noOfMealsreceived)){
			var error="";
			error = getMessage("DS_MEALSERVD_LESSOREQL_TOTMEALSSRVD","DS");//"No. of meals received should be less than or equal to Total No. of Meals served";
			messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
		else if(noOfMealsOrders != "" && parseInt(noOfMealsOrders)<parseInt(totalNoOfMealsreject)+parseInt(noOfMealsreject)){
			var error="";
			var error = getMessage("DS_NOREJECT_LESSOREQL_NOOFORDS","DS");//No. of meals rejected should be less than or equal to No. of Orders"
			messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
		else{
			//methodVal.value = updateMethod;
			formObj.submit();
			}
		}
			}
		}else{ // Going through mealOrderTab Datas
			var recordVal = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('recordId'); //2nd Value
			var totalRows = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('totalRows');//1st Value
			totalRows.value=parent.content.f_query_add_mod.mealOrderArray.length;
			var mealCatVal = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealCategory');
			var orderFromVal = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealOrderFrom');
			var orderToVal = parent.content.f_query_add_mod.details_frame.MealOrderForm.document.getElementById('mealOrderTo');
			var mealOrderItemsArray=parent.content.f_query_add_mod.MealOrderForStaffsForm.document.getElementById('mealOrderItemsArray');
			mealOrderItemsArray.value=parent.content.f_query_add_mod.mealOrderArray;
			
			var formObj = parent.content.f_query_add_mod.details_frame.document.forms[0];
			formObj.method='post';
			formObj.action="../../servlet/eDS.MealOrderForStaffsServlet";
			formObj.submit();
			}
		}		
}

function checkNull(fields, names) {
	var f1;
	var error = "";
	var msgArray=new Array();
	var key_value = new Array();

	for (j = 0; j < fields.length; j++) {
		if (fields[j] == "") {
			key_value[j] = getLabel(names[j],"OT");			
			error = error + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",key_value[j])+"<br>";
			f1 = false;
		}
	}
	messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	if (f1 == false)
		return false;
	else if(parent.content.f_query_add_mod.mealOrderArray.length > 0)
		return true;
	else return false;
}

function noOfMealOrderReadOnly(){
	document.getElementById("noOfOrders").readOnly="true";
	document.getElementById("totalNoOfMealsServed").readOnly="true";
	/*Added Start for ML-MMOH-CRF-0730*/
	document.getElementById("totalnoOfMealsreceived").readOnly="true";
	document.getElementById("totalNoOfMealsreject").readOnly="true";
	/*Added End for ML-MMOH-CRF-0730*/
}

function updateDetails() {
	//CRF-0684
	var isMenuType =document.getElementById("isMenuType").value;
	var isMealComplaints =document.getElementById("isMealComplaints").value; //Added Against CRF-1125
	var chkYN="";
		if(isMenuType=="true")
			chkYN="Y";
		else	
			chkYN="N";
	//CRF-0684
	//Added Against Start CRF-1125		
	var chkMealComp="N";
		if(isMealComplaints=="true")
			chkMealComp="Y";
	//Added Against End CRF-1125					
	var fromDate = document.getElementById("mealOrderFrom").value;
	var toDate = document.getElementById("mealOrderTo").value;
	var pattern = document.getElementById("datepattern").value;
	var locale = document.getElementById("locale").value;
	//Added against CRF-0419 Starts Here
	var dietLocation=document.getElementById("dietLocation").value;
	//CRF-0684	
	if(chkYN == "Y"){		
		var menuType=document.getElementById("menuType").value;	//Added Against 0684-CRF
	}else{		
		var menuType="";
	}
	//CRF-0684
	//Added against CRF-0419 Ends Here
	fromDate = convertDate(fromDate,"DMY", locale, "en"); // Date Localization 
	toDate = convertDate(toDate,"DMY", locale, "en"); // Date Localization 
	var mealCategory = document.getElementById("mealCategory").value;
	var mealType = document.getElementById("MealType").value;
	var dietType = document.getElementById("DietType").value;
	var facilityId = document.getElementById("facilityId").value;
	//Added Against CRF-0678 starts Here
	var practName="";	
	//Added Against Start 0684-CRF 
	if(mealCategory == "DOC"){
		practName=document.getElementById("practdetail").value;	
	if(chkYN=="Y")
	menuType=document.getElementById("menuType").value;// Added Against Start 0684-CRF
	}
	else if(chkYN=="Y")
		menuType=document.getElementById("menuType").value;
	//Added Against End 0684-CRF
	//Added Against CRF-0678 Ends Here
	if(facilityId != "" && mealCategory != "" && dietType != "" && mealType != "") {
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=update_MealServed_Details&locale="+locale+"&mealCategory="+mealCategory+"&dietType="+dietType+"&mealType="+mealType+"&fromDate="+fromDate+"&toDate="+toDate+"&facilityId="+facilityId+"&dietLocation="+dietLocation+"&practName="+practName+"&menuType="+menuType+"&chkYN="+chkYN+"&chkMealComp="+chkMealComp;//Modified against CRF-0419,CRF-0678 and 0684-CRF and CRF-1125
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);		
		var retVal_arr = retVal.split(",");
		if(retVal_arr[0] != null && retVal_arr[0] != ''){		
	if(retVal_arr.length > 1) {
		for(i=retVal_arr.length-1;i>0;i--) {
			var details_arr = retVal_arr[i-1].split("##");
			var noOfOrders=details_arr[2];
			var noOfMealsServed=details_arr[3];
			/*Added Start for ML-MMOH-CRF-0730*/
			var noOfMealsreceived=details_arr[4];
			var noOfMealsreject=details_arr[5];
			if(chkYN == "Y"){		
				if(chkMealComp == "Y"){		
					if(details_arr[6]==""){
						var complaintCode=details_arr[7]; //Modified Against CRF-684
						var complaintDesc=details_arr[9]; //Modified Against CRF-684
					}else{
							var othcomplaintDesc=details_arr[6]; //Modified Against CRF-684
					}
				}
			}
			//Added Against Start New ICN for Compliant Code Display
			else{
				var complaintCode=details_arr[6];
				var complaintDesc=details_arr[7];
			}
			//Added Against End New ICN for Compliant Code Display
			/*Added End for ML-MMOH-CRF-0730*/
			if(noOfOrders != undefined && noOfOrders!=""){
			document.getElementById("noOfOrders").value=noOfOrders;
			}else{
			document.getElementById("noOfOrders").value=0;
			}
			if(noOfMealsServed != undefined && noOfMealsServed!=""){
			document.getElementById("totalNoOfMealsServed").value=noOfMealsServed;
			}else{ 
			document.getElementById("totalNoOfMealsServed").value=0;
			}
			/*Added Start for ML-MMOH-CRF-0730*/
			if(noOfMealsreceived != undefined && noOfMealsreceived!=""){
			document.getElementById("totalnoOfMealsreceived").value=noOfMealsreceived;}
			else{ document.getElementById("totalnoOfMealsreceived").value=0;
			}
			if (noOfMealsreject != undefined && noOfMealsreject!=""){
			document.getElementById("totalNoOfMealsreject").value=noOfMealsreject;
			}else{
			document.getElementById("totalNoOfMealsreject").value=0;
			}
			if (complaintDesc != undefined && complaintDesc!="" && complaintDesc.length>0){				
			document.getElementById("complaintDesc").value=complaintDesc;
			document.getElementById("complaintCode").value=complaintCode;
			document.getElementById("othersLink").disabled=true; //Added Against CRF-1125
			document.getElementById("othersComp").value="";
			}else if(othcomplaintDesc!= undefined && othcomplaintDesc!="" && othcomplaintDesc.length>0){
			document.getElementById("complaintDesc").value='';
			document.getElementById("complaintCode").value='';
			document.getElementById("othersLink").enabled=true; //Added Against CRF-1125
			document.getElementById("complaintDesc").enabled=true; //Added Against CRF-1125
			document.getElementById("bt").enabled=true; //Added Against CRF-1125
			}
			/*Added End for ML-MMOH-CRF-0730*/
			// Added Against Start CRF-1125
			if(chkMealComp == "Y"){
		 	if(othcomplaintDesc != undefined && othcomplaintDesc!="" && othcomplaintDesc.length>0){
			document.getElementById("othersComp").value=othcomplaintDesc;
			document.getElementById("complaintDesc").disabled=true;
			document.getElementById("bt").disabled=true;
			}else if(complaintDesc != undefined && complaintDesc!="" && complaintDesc.length>0){
			document.getElementById("othersComp").value='';
			document.getElementById("complaintDesc").enabled=true;
			document.getElementById("bt").enabled=true;
			}
			}
			// Added Against Start CRF-1125				
			document.getElementById("recordOrderLineNum").value=details_arr[1];
			document.getElementById("recordId").value=details_arr[0];
			break;
		}
		}
		}
		else {
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			document.getElementById("noOfOrders").value="";
			document.getElementById("totalNoOfMealsServed").value="";
			document.getElementById("noOfMealsServed").value="";
			/*Added Start for ML-MMOH-CRF-0730*/
			document.getElementById("totalnoOfMealsreceived").value="";
			document.getElementById("noOfMealsreceived").value="";
			document.getElementById("totalNoOfMealsreject").value="";
			document.getElementById("noOfMealsreject").value="";
			document.getElementById("complaintDesc").value="";
			if(chkMealComp == "Y")
			document.getElementById("othersComp").value=""; //Added Against ML-MMOH-CRF-1125
			document.getElementById("complaint").style.visibility = "hidden";				
			/*Added End for ML-MMOH-CRF-0730*/
		}
	}
	}

function docMealSerCheckNull() {
	var f1;
	var error = "";
	var fieldName=new Array("eOT.MealOrderFrom.Label","eOT.MealOrderTo.Label","eOT.MealCategory.Label","eOT.DietType.Label","eOT.MealType.Label","eOT.NoOfOrders.Label","eOT.TotalNoOfMealsServed.Label","eOT.NoOfMealsServed.Label","eDS.practitionerName.Label","eDS.TotalNoofmealsreceived.Label","eDS.Noofmealsreceived.Label","eDS.Totalnoofmealsreject.Label","eDS.Noofmealreject.Label");//Added for ML-MMOH-CRF-0730
	//Added against CRF-0419 Ends Here	 
	var fields=new Array();
	fields[0] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('mealOrderFrom').value;
	fields[1] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('mealOrderTo').value;
	fields[2] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('mealCategory').value;
	fields[3] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('DietType').value;
	fields[4] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('MealType').value;
	fields[5] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('noOfOrders').value;
	fields[6] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('totalNoOfMealsServed').value;
	
	// commented for ML-MMOH-CRF-0730
	//Added against ML-MMOH-CRF-0678 Starts here
	if(fields[2] == "DOC")	{
	fields[8] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById('practdetail').value;		
	//Added against ML-MMOH-CRF-0678 Ends here	
	}	
   /* fields[9] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById("noOfMealsServed").value;
	fields[10] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById("noOfMealsServed").value;
	fields[11] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById("noOfMealsServed").value;
	fields[12] = parent.content.f_query_add_mod.details_frame.DocumentMealOrderForm.document.getElementById("noOfMealsServed").value;*/
	var msgArray=new Array();
	var key_value = new Array();
	for (j = 0; j < fields.length; j++) {
		if (fields[j] == "") {
		//Modified against CRF-0419 Starts Here
		if (j == 8)
			key_value[j] = getLabel(fieldName[j],"DS");
		else
			key_value[j] = getLabel(fieldName[j],"OT");
			
		//Modified against CRF-0419 Ends Here
			error = error + getMessage("CAN_NOT_BE_BLANK","Common").replace("$",key_value[j])+"<br>";
			f1 = false;
		}
	}
	messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	if (f1 == false)
		return false;
	else
		return true;
}

//Ml-MMOH-CRF-0678 starts Here
function  callpractdate()
{
	var orderfromdate=document.getElementById("mealOrderFrom").value;
	var ordertodate=document.getElementById("mealOrderTo").value;
	var current_date=document.getElementById("current_date").value; //Added Against ML-MMOH-SCF-1796

	callAjaxFunction(orderfromdate,ordertodate,current_date);
}
function callPractitioner(Category)
{
	var mealCategory = Category.value;
	if(mealCategory == "DOC")
	{
		// Commented below Against CRF-832
		//document.getElementById("practitioner_name").value = '';
		//document.getElementById("practitioner").value = '';
		document.getElementById("practName").style.display = '';
	}
	else
	{
		document.getElementById("practitioner_name").value = '';
		document.getElementById("practitioner").value = '';
		document.getElementById("practName").style.display = 'none';
	}
}

function callPractitioner2(Category)
{
	var mealCategory = Category.value;
	if(mealCategory == "DOC")
	document.getElementById("practName").style.display = '';
	else
	document.getElementById("practName").style.display = 'none';
}


function callAjaxFunction(orderfromdate,ordertodate,current_date){
   var obj = document.forms[0].practdetail;              
    
   // Get the selected option
   var selectedOption = obj.options[obj.selectedIndex]; 
   var selectedValue = selectedOption.value; 
   var selectedText = selectedOption.text; 
   
   if(obj.length>1)
   {
   for(var k=(obj.length)-1;k>0;k--)
   {
   	obj.remove(k);
   }
   }
    	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getPractitionerName&orderfromdate="+orderfromdate+"&ordertodate="+ordertodate+"&current_date="+current_date;	 //Added current_date Against ML-MMOH-SCF-1796
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);		
	var retVal_arr = retVal.split(",");
			
	/* if(retVal_arr.length >1) {
		for(i=retVal_arr.length-1;i>0;i--) {
			var details_arr = retVal_arr[i-1].split("##");
			var noOfOrders=details_arr[0];
			var noOfMealsServed=details_arr[1];		
			
		if(noOfOrders != undefined &&	noOfOrders !="" && noOfMealsServed != undefined &&	noOfMealsServed !="")
		{
			var opt = document.createElement('Option');				
			opt.value = noOfOrders;
			opt.text  = noOfMealsServed;
			obj.add(opt);			
		}				
		}
	} */	//Commented Against ML-MMOH-SCF-1796
	
	//Added Against ML-MMOH-SCF-1796 Starts
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
		var practName_Arr = retVal_arr[i].split("##");
		var practName_code= practName_Arr[0];
		var practName_desc= practName_Arr[1];
		if(practName_desc!=undefined){
			practName_desc = practName_desc.trim();
      // MARWAN -  if the previous selected option in the new menu, keep it selected
			if(practName_code == selectedValue && practName_desc == selectedText){
				listItems = listItems.replace("selected=\"selected\"", "");
				selObj += "<OPTION selected='selected' value='" + practName_code + "'>" + practName_desc + "</OPTION>";
			}
			else 
				selObj += "<OPTION value='" + practName_code + "'>" + practName_desc + "</OPTION>";
		}
	}
	var selectStart = "<select id= 'practdetail' name='practdetail' id='practdetail' onchange='updateDetails();'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select><img src='../../eCommon/images/mandatory.gif'></img>";
	selObj= selObj + selectEnd;
	document.getElementById("practNameDesc").innerHTML = selObj;
	//Added Against ML-MMOH-SCF-1796 Ends
  } 


function callPractSearch1(obj,target,locale, facilityid){ 	
	var spl_code="";
	var resource_type = "";
	var pract_type="";
	var practitioner_id1="";
	var clinic_code = "";	
	getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");	
}

function getPractitioner(obj,target,facility_id,splty,pract_type,clinic_code,practitioner_id,executeQuery){
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	var sql="";
	var sql2="";
	var facilityId = facility_id;	
	if (executeQuery == "Q2"){		
		sql="SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql=sql+"	a.pract_type='"+pract_type+"' AND ";
		}

		sql = sql+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
	
		sql2= "SELECT DISTINCT a.practitioner_id, a.practitioner_name, a.PRACT_TYPE_DESC practitioner_type, a.POSITION_CODE  job_title, a.gender, am_get_desc.am_speciality(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  FROM AM_PRACTITIONER_LANG_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE A.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND ";
		
		if(pract_type!="")
		{
			sql2=sql2+"	a.pract_type='"+pract_type+"' AND ";
		}
		sql2 = sql2+" UPPER(B.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) and UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";
	}
//	var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
//	var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +encodeURIComponent(practName_FName) + "\"";
	xmlStr += " practName_FValue=\"" +encodeURIComponent(practName_FValue)+ "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" +splty+ "\""; // Thursday, February 18, 2010 19335 Venkat S.
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	
	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);

	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
    eval(practSearch(encodeURIComponent(practName_FName),encodeURIComponent(practName_FValue),splty,responseText));	  
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "500px" ;
	var dialogWidth	= "800px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="700px";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName); 
		
	
}

function PractLookupRetVal(retVal,objName)
{ 
	var arr;
	if (retVal != null)
	{
		arr=unescape(retVal).split("~");		
	        document.forms[0].practitioner_name.value=arr[1];
		document.forms[0].practitioner.value=arr[0];		
	}else
	{
		document.forms[0].practitioner_name.value= "";
		document.forms[0].practitioner.value="";	
	}
}

//Ml-MMOH-CRF-0678 Ends Here

/* Added Start for ML-MMOH-CRF-0730 */
function Complaint(status){  
	document.getElementById("complaintDesc").value = '';
	document.getElementById("complaintCode").value = '';	
	updateDetails();
}

function mealsrejectVisiable(){
	var Others = "Others";
	var empty = "empty";
	var link = "";
	if(document.forms[0].noOfMealsrejects.value!=""){			
	document.getElementById("complaint").style.visibility = "visible";
	document.getElementById("complaintDesc").enabled=true;
	document.getElementById("bt").enabled=true;
			
	if(document.getElementById("isMealComplaints").value=="true"){
		if(document.getElementById("othersComp").value!=""){
			document.getElementById("othersLink").style.visibility = "visible";
			document.getElementById("complaintDesc").enabled=true;
			document.getElementById("bt").enabled=true;
			//Others = "Others";
			//empty = "empty";
			link = "<a id='othersLink' name='othersLink' style='visibility:visible'  href='javascript:OtherComplaints();'> "+Others+" </a>"+"<input type=hidden id='othersComp' name='othersComp' id='othersComp' value='"+empty+"'>";
			document.getElementById("othersLink").disabled=false;
		}else if(document.getElementById("complaintDesc").value!=""){			
			link = "<a id='othersLink' name='othersLink' style='visibility:visible'  href='javascript:OtherComplaints();'> "+Others+" </a>"+"<input type=hidden id='othersComp' name='othersComp' id='othersComp' value='"+empty+"'>";
			document.getElementById("othersLink").style.visibility = "visible";
			document.getElementById("othersLink").disabled=true;		
		}else{			
			link = "<a id='othersLink' name='othersLink' style='visibility:visible'  href='javascript:OtherComplaints();'> "+Others+" </a>"+"<input type=hidden id='othersComp' name='othersComp' id='othersComp' value='"+empty+"'>";
			document.getElementById("othersLink").style.visibility = "visible";
			document.getElementById("complaint").style.visibility = "visible";
			document.getElementById("othersLink").disabled=false;		
			document.getElementById("complaintDesc").enabled=true;
			document.getElementById("bt").enabled=true;		
		}
	}
	}else{		
			document.getElementById("complaint").style.visibility = "hidden";	
			document.getElementById("complaintCode").value = '';	
			document.getElementById("complaintDesc").value = '';
			document.getElementById("bt").disabled=false;
			document.getElementById("complaintDesc").disabled=false;
		if(document.getElementById("isMealComplaints").value=="true"){			
			link = "<a id='othersLink' name='othersLink' style='visibility:hidden'  href='javascript:OtherComplaints();'> "+Others+" </a>"+"<input type=hidden id='othersComp' name='othersComp' id='othersComp' value='"+empty+"'>";
			document.getElementById("othersLink").disabled=false;
			document.getElementById("othersLink").style.visibility = "hidden";		
			document.getElementById("othersComp").value="";
		}
	}
}

function complaintsLookup(obj) {
	var formObj = document.forms[0];
	var isMealComplaints = formObj.isMealComplaints.value;//Added Against MMOH-CRF-1125
	var locale = document.getElementById("locale").value;
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT COMPLAINTS.LONG_DESC DESCRIPTION, COMPLAINTS.COMPLAINT_CODE  CODE FROM DS_COMPLAINTS_LANG_VW COMPLAINTS WHERE UPPER(COMPLAINTS.LONG_DESC) LIKE UPPER(?) AND UPPER(COMPLAINTS.COMPLAINT_CODE) LIKE UPPER(?) AND COMPLAINTS.LANGUAGE_ID= '"
			+ locale + "' AND   COMPLAINTS.EFF_STATUS='E'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("complaintDesc").value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title=getLabel("eOT.Complaints.Label","OT");
	returnedValues = CommonLookup(title, argumentArray);
	if((returnedValues != null) && (returnedValues != "")) {
		document.getElementById("complaintDesc").value = returnedValues[1];
		document.getElementById("complaintCode").value = returnedValues[0];
		/*Added Against Start ML-MMOH-CRF-1125 */
		if(isMealComplaints=='true'){
		 document.getElementById("othersLink").disabled=true; 
		} 
		/* Added Against End ML-MMOH-CRF-1125 */
	}else{
		document.getElementById("complaintDesc").value = '';
		document.getElementById("complaintCode").value = '';
		/*Added Against Start MMOH-CRF-1125 */
		if(isMealComplaints=='true'){
			var Others = "Others";
			var empty = "empty";
			var link = "<a id='othersLink' name='othersLink' style='visibility:visible'  href='javascript:OtherComplaints();'> "+Others+" </a>"+"<input type=hidden id='othersComp' name='othersComp' id='othersComp' value='"+empty+"'>";
			document.getElementById("othersLink").disabled=false;
		}
		/*Added Against End MMOH-CRF-1125 */
	}
}
/* Added End for ML-MMOH-CRF-0730 */
//Added Against Ml-MMOH-CRF-0674 starts Here
function fecthDietType()
{
	var diettype_auto=document.getElementById("diettype_auto").value;
	var obj;
	obj = document.getElementById("DietType");
	while(obj.length > 0){
		obj.remove(0);
	}
	//setTimeout("setTimeForDietTypesPop()", 1000);
	var mode = "fecthDietTypes_forstaff";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	param="&mode="+mode+"&diettype_auto="+diettype_auto;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",  "../../servlet/eDS.MealOrderForStaffsServlet?"+param,false);
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
	var str=document.getElementById("DietType").value;
	var auto_flag=document.getElementById("auto_flag").value
	if(str == "" && auto_flag == "true")
	{
	var sel = document.getElementById('DietType');
	var len = sel.options.length;
	if(len <= 5)
		sel.setAttribute('size', len);
	else
		sel.setAttribute('size', 5);
	}
	else if(str != "" && auto_flag == "false2")
	{
	var sel = document.getElementById('DietType');
	var len = sel.options.length;
	if(len <= 5)
		sel.setAttribute('size', len);
	else
		sel.setAttribute('size', 5);
	}
}
	
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
		fecthDietType();			 
	}
}

function Select()
{	
	var auto_flag=document.getElementById("auto_flag").value;	   
	var myDropDown = document.getElementById("DietType");
	var str = myDropDown.options[myDropDown.selectedIndex].value;
		
	if(auto_flag == "true" && str!="")
		{			
			myDropDown.size = 1;  
			document.getElementById("auto_flag").value="false2";
			document.getElementById("diettype_auto").value="";				
		}
		else if(auto_flag == "true" && str=="")
		{			
			myDropDown.size = 1;  
			document.getElementById("auto_flag").value="false";
			document.getElementById("diettype_auto").value="";		
			fecthDietType();				
		}
	else if(auto_flag == "false2" && str=="")
		{				
			myDropDown.size = 1;    
			document.getElementById("diettype_auto").value="";
			document.getElementById("auto_flag").value="false";
			fecthDietType();			 
		}	
}   
//Added Against Ml-MMOH-CRF-0674 Ends Here
function checkDateValidate(da1)
{
var DateVal ="";		
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
			var theatre_label = "";
			var tab_id = viewId;
			if(da1.name=="mealOrderFrom"){
				if(tab_id=="mealOrderTab"){
				theatre_label=getLabel("eOT.MealOrderFrom.Label","OT");
				DateVal = document.getElementById("mealOrderFrom");
				}
			}else if(da1.name=="mealOrderTo")
			{
				theatre_label=getLabel("eOT.MealOrderTo.Label","OT");
				DateVal = document.getElementById("mealOrderTo");
			}					
			var current_label = getLabel("Common.CurrentDate.label","common");
			alert(msgArray[0]+theatre_label+msgArray[1]+current_label+msgArray[2]);
			//$("#"+da1.name).focus();
			//$("#"+da1.name).select();								
			DateVal.focus();
			DateVal.select();
			return false; 
		}
	}
	}
}
function chkDt1Dt2(d1,d2)
{
	var d1Arr = d1.split("/");
	var d2Arr = d2.split("/");
	if(parseInt(d2Arr[2],10)<parseInt(d1Arr[2],10)){ 
		return false;
	}
	else if(parseInt(d2Arr[2],10)==parseInt(d1Arr[2],10)){
		if(parseInt(d2Arr[1],10)<parseInt(d1Arr[1],10)){
				return false;
		}
		else if(parseInt(d2Arr[1],10)==parseInt(d1Arr[1],10)){
			if(parseInt(d2Arr[0],10)<parseInt(d1Arr[0],10)){
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

function deleteRecord(id,rowid){	
		staff_order_id_value = id;
		if(staff_order_id_value!=null && staff_order_id_value.length>0){
			if(!window.confirm(getMessage("DS_DEL_STATUS","DS"))){
			return;
			}
			else{
			var facilityId = document.getElementById("facilityId").value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
			var params = "func_mode=deleteStatus&facility_id="+facilityId+"&staff_order_id="+staff_order_id_value;
			xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);	 
			if(retVal == '1')
				{
				parent.parent.f_query_add_mod.location.href='../../eDS/jsp/MealOrderForStaffsFrame.jsp'; 	
				}	
			}		
		}else{		
				var isMenuType =document.getElementById("isMenuType").value;
				var chkYN="";
				if(isMenuType=="true")
					chkYN="Y";
				else	
					chkYN="N";
					
				rowid = parseInt(rowid);	
				document.getElementById("mealOrderTable").deleteRow(rowid+1);
				parent.mealOrderArray[rowid] = new Array();
				mealOrderArrayTemp = new Array();
				for (var i = 0,j=0; i < parent.mealOrderArray.length; i++){		
				if(chkYN=="Y"){
				if(parent.mealOrderArray[i][2]!=undefined){ // index
					mealOrderArrayTemp[j] = new Array();
					mealOrderArrayTemp[j] = parent.mealOrderArray[i];
					j++; //Added Against IN-065835
				}
				}else{
				if(parent.mealOrderArray[i][0]!=undefined){ // index
					mealOrderArrayTemp[j] = new Array();
					mealOrderArrayTemp[j] = parent.mealOrderArray[i];
					j++; //Added Against IN-065835
						}
					}
				}
				parent.mealOrderArray = mealOrderArrayTemp;				
				displayDetails(); //Added Against IN-065835
		}
		
}

//ML-MMOH-CRF-1006-US3 Starts
function changeMealType()
{	
	/* Added Against Start ML-MOH-CRF-825 */
	var lateIrregularDietOrderStaff ="";
	if(parent.details_frame.document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_ST"))
		lateIrregularDietOrderStaff = parent.details_frame.document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_ST").value;
	var date=new Date();
	var hour=date.getHours();
	if(hour<=9){
		hour="0"+""+hour;
	}
	var minute=date.getMinutes();
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysTime = hour+":"+minute;
	/* Added Against End ML-MOH-CRF-825 */
	var mealType = document.getElementById("MealType");
	//Added Against ML-MMOH-SCF-1740 Starts
	var mealOrderFrom = document.getElementById("mealOrderFrom").value;
	var mealOrderTo = document.getElementById("mealOrderTo").value;
	var currentDate = document.getElementById("current_date").value;
	//Added Against ML-MMOH-SCF-1740 Ends
	var mealCategory = document.getElementById("mealCategory").value;
	var chkMealType = document.getElementById("MealType").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getMealTypeForCatSTF&meal_Category="+mealCategory;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	
	var retVal = trimString(xmlHttp.responseText);	
	const result = retVal.split("???").map(obj => obj.split(":::")[0]).sort().join(",");
	
	const selectElement = document.getElementById("MealType");
	const values = Array.from(selectElement.options) // Convert options to an array
    .map(option => option.value)                // Extract the value of each option
    .slice(1)                                   // Skip the first element
    .sort()                                     // Sort the strings alphabetically
    .join(",");    
	
    // if no change in the select elements no need to re-construct it
    if(result === values){
    	return
    }
	
	var retVal_arr = retVal.split("???");
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
	var mealCode_Arr = retVal_arr[i].split(":::");
	var meal_type_code= mealCode_Arr[0];
	var meal_type_desc= mealCode_Arr[1];
		/* Added Against Start ML-MOH-CRF-825 */
	var ServingStartTime= mealCode_Arr[2];
		if(ServingStartTime==null || ServingStartTime=="null" || ServingStartTime== "undefined"){
			ServingStartTime="";
		}		
	var ServingEndTime= mealCode_Arr[3];
		if(ServingEndTime==null || ServingEndTime=="null" || ServingEndTime== "undefined"){
			ServingEndTime="";
		}
	var IrregularStartTime= mealCode_Arr[4];
		if(IrregularStartTime==null || IrregularStartTime=="null" || IrregularStartTime== "undefined") 
			IrregularStartTime="";
	var IrregularEndTime= mealCode_Arr[5];
		if(IrregularEndTime==null || IrregularEndTime=="null" || IrregularEndTime== "undefined"){
			IrregularEndTime="";
		}
	var MealOrder= mealCode_Arr[6];
	var nextServingStartTime= mealCode_Arr[7];
	var checkAllow = "Y";
		if(ServingStartTime=="" && ServingEndTime=="" && IrregularStartTime=="" && IrregularEndTime==""){
			IrregularEndTime = nextServingStartTime;
		}
		
		if(mealOrderFrom!=currentDate || mealOrderTo!=currentDate) //Added Against ML-MMOH-SCF-1740
		{
			checkAllow = "Y";
		}
		else
		{
		if(lateIrregularDietOrderStaff == "Y" && IrregularEndTime == "" && ServingEndTime != ""){
			if(ServingEndTime > sysTime){
				checkAllow = "Y";
			}else if(ServingEndTime < sysTime){
				checkAllow = "N";
			}
		}
		if(lateIrregularDietOrderStaff=="Y" && IrregularEndTime!=""){
			if(IrregularEndTime > sysTime){
				checkAllow = "Y";
			}else if(IrregularEndTime < sysTime){
				checkAllow = "N";
			}
		}
		}
		/* Added Against End ML-MOH-CRF-825 */
		if(meal_type_desc!=undefined && checkAllow=="Y")
		selObj += "<OPTION value='" + meal_type_code + "'>" + meal_type_desc + "</OPTION>";		
		}
	var selectStart = "<select id= 'MealType' name='MealType' id='MealType'>";
	selectStart = selectStart+listItems;
	selObj = selectStart+selObj;
	var selectEnd = "</select><img src='../../eCommon/images/mandatory.gif'></img>";
	selObj= selObj + selectEnd;
	document.getElementById("MealTypeTD").innerHTML = selObj;
}

function changeMealType_Doc()
{
	var mealCategory = document.getElementById("mealCategory").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	var params = "func_mode=getMealTypeForCat&meal_Category="+mealCategory;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	var listItems = '<option selected="selected" value="">-----'+getLabel("Common.Select.label","common")+'-----</option>';
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
		var mealCode_Arr = retVal_arr[i].split(":::");
		var meal_type_code= mealCode_Arr[0];
		var meal_type_desc= mealCode_Arr[1];
		if(meal_type_desc!=undefined)
		selObj += "<OPTION value='" + meal_type_code + "'>" + meal_type_desc + "</OPTION>";
	}
	var selectStart = "<select id= 'MealType' name='MealType' id='MealType' onchange='updateDetails();'>";
	selectStart = selectStart+listItems;
	selObj = selectStart +selObj;
	var selectEnd = "</select><img src='../../eCommon/images/mandatory.gif'></img>";
	selObj= selObj + selectEnd;
	document.getElementById("MealTypeTD").innerHTML = selObj;
}
//ML-MMOH-CRF-1006-US3 Ends
	
function changeMealType1(obj,obj1)
{
	/* Added Against Start ML-MOH-CRF-825 */
	var lateIrregularDietOrderStaff = document.getElementById("LATE_IRREGULAR_DIET_ORD_FOR_ST").value;
	var date=new Date();
	var hour=date.getHours();
	if(hour<=9){
		hour="0"+""+hour;
	}
	var minute=date.getMinutes();
	if(minute<=9){
		minute="0"+""+minute;
	}
	var sysTime = hour+":"+minute;
	/* Added Against End ML-MOH-CRF-825 */
	document.getElementById("MealTypeTD").value = obj;
	var chk = document.getElementById("MealTypeTD").value;
	var mealCategory = document.getElementById("mealCategory").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	var params = "func_mode=getMealTypeForCatSTF&meal_Category="+mealCategory;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);	
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);	
	var retVal_arr = retVal.split("???");
	var sele = "selected";
	var listItems = "<option selected='"+sele+"' value='"+obj1+"'>"+getLabel("Common.Select.label","common")+ "</option>";
	listItems = listItems +"<option selected='"+sele+"' value='"+obj1+"'>"+chk+"</option>";
	var selObj = "";
	for(var i=0; i < retVal_arr.length; i++){
	var mealCode_Arr = retVal_arr[i].split(":::");
	var meal_type_code= mealCode_Arr[0];
	var meal_type_desc= mealCode_Arr[1];
		/* Added Against Start ML-MOH-CRF-825 */
	var ServingStartTime= mealCode_Arr[2];
		if(ServingStartTime==null || ServingStartTime=="null" || ServingStartTime== "undefined"){
		ServingStartTime="";
		}		
	var ServingEndTime= mealCode_Arr[3];
		if(ServingEndTime==null || ServingEndTime=="null" || ServingEndTime== "undefined"){
		ServingEndTime="";
		}
	var IrregularStartTime= mealCode_Arr[4];
		if(IrregularStartTime==null || IrregularStartTime=="null" || IrregularStartTime== "undefined") 
		IrregularStartTime="";
	var IrregularEndTime= mealCode_Arr[5];
		if(IrregularEndTime==null || IrregularEndTime=="null" || IrregularEndTime== "undefined"){
		IrregularEndTime="";
		}
	var MealOrder= mealCode_Arr[6];
	var nextServingStartTime= mealCode_Arr[7];
	var checkAllow = "Y";
		if(ServingStartTime=="" && ServingEndTime=="" && IrregularStartTime=="" && IrregularEndTime==""){
			IrregularEndTime = nextServingStartTime;
		}
		if(lateIrregularDietOrderStaff == "Y" && IrregularEndTime == "" && ServingEndTime != ""){
			if(ServingEndTime > sysTime){
				checkAllow = "Y";
			}else if(ServingEndTime < sysTime){
				checkAllow = "N";
			}
		}
		if(lateIrregularDietOrderStaff=="Y" && IrregularEndTime!=""){
			if(IrregularEndTime > sysTime){
				checkAllow = "Y";
			}else if(IrregularEndTime < sysTime){
				checkAllow = "N";
			}
		}
		/* Added Against End ML-MOH-CRF-825 */
		if(meal_type_desc!=undefined && meal_type_desc!=chk && checkAllow=="Y"){				
		selObj += "<OPTION value='" + meal_type_code + "'>" + meal_type_desc + "</OPTION>";
		}
	}
	var selectStart = "<select id= 'MealType' name='MealType' id='MealType'>";
	selectStart = selectStart+listItems;	
	selObj = selectStart +selObj;
	var selectEnd = "</select><img src='../../eCommon/images/mandatory.gif'></img>";
	selObj= selObj + selectEnd;
	document.getElementById("MealTypeTD").innerHTML = selObj; 
}

/* Added Against Start MOH-CRF-1125 */
async function OtherComplaints(){
	var others = "";	
	var isDisableChk = document.getElementById("complaintDesc").value; //icn-1125US003
	if(isDisableChk!="" && isDisableChk!=null)
	return;
	var othersCmpHdr = "";
	var index = "0";
	othersCmpHdr = document.getElementById("othersComp").value;
	if(others != "" || others != null || others == undefined){
		if(othersCmpHdr != "")
			 others = othersCmpHdr;
		else
			 othersCmpHdr = others;
	}else
		othersCmpHdr = "";

	var dialogUrl1 = "../../eDS/jsp/OtherComplaints.jsp?&othersCmpHdr="+encodeURIComponent(othersCmpHdr)+"&index="+index;	
	var dialogArguments = others;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnOthersCmp = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnOthersCmp != null){
		others = returnOthersCmp;
		if(others!= ""){
		document.getElementById("othersLink").disabled=false; 
		document.getElementById("complaintDesc").disabled=true;
		document.getElementById("bt").disabled=true;
		}else{
		document.getElementById("othersLink").disabled = false; 
		document.getElementById("complaintDesc").disabled = false;
		document.getElementById("bt").disabled = false;		
		}
	}
	document.getElementById("othersComp").value = others;
	if(returnOthersCmp == undefined || othersCmpHdr ==""){
		document.getElementById("othersLink").enabled=true; 
		document.getElementById("complaintDesc").enabled=true;
		document.getElementById("bt").enabled=true;
		returnOthersCmp = dialogArguments;
	}
}

function getOthersCompliants(val) {
	var others = "";	
	others = val;
	window.returnValue = others;
	window.close();
}

function textAreaLimit1(field, maxlen) {
	//if (field.value.length > maxlen + 1) //Commented Against ML-MMOH-CRF-1816
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}

function enableOthers(){
	var isMealComplaints = document.getElementById("isMealComplaints").value;	
	var isComplaintsEmpty	=  document.getElementById("complaintDesc").value;
	var index="0";
	if(isMealComplaints=='true' && isComplaintsEmpty==""){
		var Others = "Others";
		var empty = "empty";
		var link = "<a id='othersLink"+index+"' name='othersLink"+index+"' style='visibility:visible'  href='javascript:OtherComplaints("+index+");'> "+Others+" </a>"+"<input type=hidden id='othersComp"+index+"' name='othersComp"+index+"' id='othersComp"+index+"' value='"+empty+"'>";
		document.getElementById("othersLink").disabled=false;		
	}	
}
/* Added Against End MOH-CRF-1125 */


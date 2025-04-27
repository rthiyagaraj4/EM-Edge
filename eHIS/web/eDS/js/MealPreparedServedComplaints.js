var viewId = "mealTypeTab";

function tabClicked(tabId) {
	viewId = tabId;
	id = viewId;
}

function getCurrDateTime() {
	var currDate = new Date();
	var date = currDate.getDate();
	var mon = currDate.getMonth();
	var hrNow = currDate.getHours();
	var mnNow = currDate.getMinutes();
	var scNow = currDate.getSeconds();
	mon = mon + 1;
	var year = currDate.getYear();
	if (date < 10)
		date = "0" + date;
	if (mon < 10)
		mon = "0" + mon;
	if (hrNow < 10)
		hrNow = "0" + hrNow;
	if (mnNow < 10)
		mnNow = "0" + mnNow;
	var reqToDate = date + "/" + mon + "/" + year + " " + hrNow + ":" + mnNow;
	;
	return reqToDate;
}

function getMealPlanDetails() {
	var formObj = document.MealAcknowledgementForm;
	var locale = formObj.locale.value;
	var from_date = trimString(formObj.date_mealtype.value);
	var facility_id = formObj.facility_id.value;
	var mealType_code = trimString(formObj.mealType.value);
	var nursingUnit_code = trimString(formObj.nursingUnit.value);
	var param = "facility_id=" + facility_id + "&from_date=" + from_date
			+ "&facility_id=" + facility_id + "&mealType_code=" + mealType_code
			+ "&nursingUnit_code=" + nursingUnit_code;
	var error="";
    if(from_date =="") error=getMessage("DS_DAT_NOT_BLANK","DS");
	if(mealType_code == "") error=error + getMessage("DS_MEALTYPE_NOT_BLANK","DS") + "<br>" ;
	if(nursingUnit_code == "") error= error + getMessage("DS_NURSGUNIT_NOT_BLANK","DS")  + "<br>" ;

	if(error != "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
		return false;
	}

	else parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;

	parent.meal_tab_frame.meal_plan_details_frame.location.href = "../../eDS/jsp/MealPreparedServedComplaints_Details.jsp?"
			+ param;
}

function getFreqBasedDetails() {
	var formObj = document.FreqBasedHeaderForm;
	var locale = formObj.locale.value;
	var date_freqBased = trimString(formObj.date_freqBased.value);
	var facility_id = formObj.facility_id.value;
	var patientId = trimString(formObj.patientId.value);
	var nursingUnit_code = trimString(formObj.nursingUnit.value);
	var param = "facility_id=" + facility_id + "&date_freqBased=" + date_freqBased
			+ "&facility_id=" + facility_id + "&patientId=" + patientId
			+ "&nursingUnit_code=" + nursingUnit_code;
	
	var error="";
	//if(date_freqBased=="") error="APP-SM0073 Date cannot be blank"+ "<br>" ;
	if(date_freqBased=="") error=getMessage("DS_DAT_NOT_BLANK","DS") + "<br>" ;
	if(nursingUnit_code == "") error=error + getMessage("DS_NURSGUNIT_NOT_BLANK","DS") + "<br>" ;
	
	if(error != "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
		return false;
	}
	
	else parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;	

	parent.meal_tab_frame.meal_plan_details_frame.location.href = "../../eDS/jsp/SpclFoodItems_FreqBased_Details.jsp?"
			+ param;
}

function getNonFreqBasedDetails() {
	var formObj = document.NonFreqBasedHeaderForm;
	var locale = formObj.locale.value;
	var date_nonFreqBased = trimString(formObj.date_nonFreqBased.value);
	var facility_id = formObj.facility_id.value;
	var patientId = trimString(formObj.patientId.value);
	var nursingUnit_code = trimString(formObj.nursingUnit.value);
	var param = "facility_id=" + facility_id + "&date_nonFreqBased=" + date_nonFreqBased
			+ "&facility_id=" + facility_id + "&patientId=" + patientId
			+ "&nursingUnit_code=" + nursingUnit_code;
	var error="";
	if(date_nonFreqBased == "") error= getMessage("DS_DAT_NOT_BLANK","DS")+ "<br>" ;
	if(nursingUnit_code == "") error=error +getMessage("DS_NURSGUNIT_NOT_BLANK","DS") + "<br>" ;
	if(error != "") {
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
		return false;
	}
	else 
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;	
	parent.meal_tab_frame.meal_plan_details_frame.location.href = "../../eDS/jsp/SpclFoodItems_NonFreqBased_Details.jsp?"
			+ param;
}

function frequencyRecordsSelect() {
	var formObj = document.FreqBasedHeaderForm;
	var locale = formObj.locale.value;
	var from_date = trimString(formObj.date_freqBased.value);
	var facility_id = formObj.facility_id.value;
	var nursingUnit_code = trimString(formObj.nursingUnit.value);
	var param = "facility_id=" + facility_id + "&from_date=" + from_date
			+ "&facility_id=" + facility_id + "&mealType_code=" + mealType_code
			+ "&nursingUnit_code=" + nursingUnit_code;
	parent.meal_tab_frame.meal_plan_details_frame.location.href = "../../eDS/jsp/SpeclFoodItems_FreqBased_Details.jsp?"
			+ param;
}

function showCalForNonFreq(i, id, format, showsTime, showsOtherMonths, name) {
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

async function complaintsLookup(obj, index) {
	var formObj = document.forms[0];
	var isMealComplaints = formObj.isMealComplaints.value;//Added Against MOH-CRF-1125
	var locale = document.getElementById("locale").value;
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT COMPLAINTS.LONG_DESC DESCRIPTION, COMPLAINTS.COMPLAINT_CODE  CODE FROM DS_COMPLAINTS_LANG_VW COMPLAINTS WHERE UPPER(COMPLAINTS.LONG_DESC) LIKE UPPER(?) AND UPPER(COMPLAINTS.COMPLAINT_CODE) LIKE UPPER(?) AND COMPLAINTS.LANGUAGE_ID= '" + locale + "' AND   COMPLAINTS.EFF_STATUS='E'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("complaintDesc" + index).value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title=getLabel("eOT.Complaints.Label","OT");
	returnedValues = await parent.parent.window.CommonLookup(title, argumentArray);
	var link =""; //Added Against MOH-CRF-1125
	if ((returnedValues != null) && (returnedValues != "")) {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		document.getElementById("complaintDesc" + index).value = returnedValues[1];
		document.getElementById("complaintCode" + index).value = returnedValues[0];
		/*Added Against Start ML-MMOH-CRF-1125 */
		if(isMealComplaints=='true'){
		 document.getElementById("othersLink"+ index).disabled=true; 
		} 
		/* Added Against End ML-MMOH-CRF-1125 */
	}else{
		document.getElementById("complaintDesc" + index).value = '';
		document.getElementById("complaintCode" + index).value = '';
		/*Added Against Start MMOH-CRF-1125 */
		if(isMealComplaints=='true'){
		var Others = "Others";
		var empty = "empty";
		link = "<a id='othersLink"+index+"' name='othersLink"+index+"' style='visibility:visible'  href='javascript:OtherComplaints("+index+");'> "+Others+" </a>"+"<input type=hidden id='othersComp"+index+"' name='othersComp"+index+"' id='othersComp"+index+"' value='"+empty+"'>";
		document.getElementById("othersLink"+index).disabled=false;
		}
		/*Added Against End MMOH-CRF-1125 */

	}
}

function apply() { 
	var tab=parent.content.f_query_add_mod.tab_frame.document.getElementById("viewID").value;
	parent.content.f_query_add_mod.meal_tab_frame.meal_plan_details_frame.document.forms[0].querySelector("#tabName").value=tab;
	if (tab == "mealTypeTab") {
		insertingMealTypeRecords();
	}
	if (tab == "nonFreqBasedTab") {
		insertingNonFreqRecords();
	}
	if (tab == "spFoodItemsTab") {		
		insertingFreqRecords();
	}
	if (tab == "freqBasedTab") {
		insertingFreqRecords();
	}
}

function insertingMealTypeRecords() {
	var formObj_header = parent.content.f_query_add_mod.header_frame.document.forms[0];
	var formObj = parent.content.f_query_add_mod.meal_tab_frame.meal_plan_details_frame.document.forms[0];

	//ML-MMOH-CRF-0687
	var isComplaintCnt = formObj_header.isComplaintCnt.value;
	var isNotification = formObj_header.isNotification.value;	//Added Against ML-MMOH-SCF-1681
	
	var chkYN="";
	if(isComplaintCnt=="true" || isNotification=="true")	//Added Against ML-MMOH-SCF-1681
		chkYN="Y";
	else	
		chkYN="N";
	//ML-MMOH-CRF-0687

	var flag_check = 'true';
	var rowCount = 0;
	var startIndex = 0;
	var endIndex = 0;
	var sysdate=formObj.querySelector("#sysdate").value;
	var locale = formObj.querySelector("#locale").value;
	startIndex = formObj.querySelector("#startIndex").value;
	endIndex = formObj.querySelector("#endIndex").value;
	formObj.querySelector("#totalRecords").value=endIndex;
	var inputDate = formObj_header.querySelector("#date_mealtype").value;
	formObj.querySelector("#date_mealtype").value=inputDate;
	var isMealComplaints = formObj.isMealComplaints.value;	 //Added Against MOH-CRF-1125 
	inputDate = convertDate(inputDate,"DMY", locale, "en"); // Date Localization 	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;	
	var hh = today.getHours();
	var mi = today.getMinutes();

	var yyyy = today.getFullYear();
	if(dd<10){dd='0'+dd}
	if(mm<10){mm='0'+mm}
	
	if(hh<10){hh='0'+hh}
	if(mi<10){mi='0'+mi}
	
	today = dd+'/'+mm+'/'+yyyy+ ' '+hh+':'+mi;
	
	if (endIndex == 0) {
		var error =getMessage("DS_SEL_RECORD","DS"); // "APP-DS0022 Atleast One Record Should Be Selected.";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
	}
	//IN::39965- Validate if atleast one record is updated
	var bValEntered = false;
	for ( var i = startIndex; i <= endIndex; i++) {
		if(formObj.querySelector("#effStatus" + i)) {
			var tmpStatusvalue = formObj.querySelector("#effStatus" + i).value;
			if(tmpStatusvalue != null && tmpStatusvalue != "")
			{
				bValEntered= true;
				break;
			}
		}
	}
	if(!bValEntered)
	{
		var error = getMessage("DS_UPD_REC","DS") ;//"Atleast One Record Should Be updated.";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
		flag_check = 'false';
	}
	
	if (flag_check == 'true') 
	{
		for ( var i = startIndex; i <= endIndex; i++) {
				if(formObj.querySelector("#effStatus" + i)) {
				var singleStatus = formObj.querySelector("#effStatus" + i).value;
				var eventDateTime = formObj.querySelector("#eventDate" + i).value;
				eventDateTime = convertDate(eventDateTime,"DMYHM", locale, "en"); //Date Localization
				
				var complaint_code = formObj.querySelector("#complaintCode"+ i).value;
				var complaint_desc = formObj.querySelector("#complaintDesc"+ i).value;
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Starts Here
				if(isMealComplaints=='true'){
				var othersComp_desc = formObj.querySelector("#othersComp"+ i).value; 
				}
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Ends Here
				var dateValArr = eventDateTime.split(' '); 
				if (dateValArr.length != 2) 
				{
					eventDateTime = '';
					formObj.querySelector("#eventDate" + i).value = '';
				} 
				if(singleStatus != "" && eventDateTime == "")
				{
					var error = getMessage("DS_EVNTDATE_NOT_BLANK","DS"); //" APP-SM0073 Event Date cannot be blank";
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
					flag_check = 'false';
					break;
				}	//IN::39965	-end
				if (eventDateTime != "") {
					var dtArr = (eventDateTime).split(" ");
					var returnVal =  compareDates(eventDateTime,today,locale,"DMYHM");
					if(returnVal == -1) {
						// TO DO: MESSAGE
						var error = getMessage("DS_DATIME_LESSOREQL_CURDATE","DS") ;//"Date Time should be less than or equal to Current Date";
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
						flag_check = 'false';
						break;
					}
					
					if(dtArr[0] == inputDate){
						if (singleStatus == "MJ"){
						//Added Against Start MOH-CRF-1125 
							if(isMealComplaints=='true'){
								if (complaint_code == "" && complaint_desc == "" && othersComp_desc==""){
									var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") 
									messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="		+ error;
									flag_check = 'false';
									break;
								}
							//Added Against End MOH-CRF-1125 	
							}else if(complaint_code == "" && complaint_desc == ""){								
								var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") 
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
									flag_check = 'false';
									break;								
							}
						}
					}else if(inputDate!=""){					
						eventDateTime = "";
						var error = getMessage("DS_ACKDATE_EQL_EVENTDATE","DS");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
						+ error;
						flag_check = 'false';
						break;
					}
				} else {
					if (singleStatus == "MJ") {
						if (complaint_code == "" && complaint_desc == "") {					
							var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
									+ error;
							flag_check = 'false';
							break;
						}
					}
				}
		}
	}
}
	if(flag_check == 'true') {
		submitForm();
		//ML-MMOH-CRF-0687
		if(chkYN=="Y"){		
		error="";
		top.frames[1].location.href=top.frames[1].location.href;
		}
		//ML-MMOH-CRF-0687
	}
}

function insertingFreqRecords(){
	var flag_check = 'true';
	var formObj_header = parent.content.f_query_add_mod.header_frame.document.forms[0];
	var formObj = parent.content.f_query_add_mod.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	var sysdate=formObj.querySelector("#sysdate").value;
	var inputDate = formObj_header.querySelector("#date_freqBased").value;
	formObj.querySelector("#date_freqBased").value=inputDate;
	var locale = formObj.querySelector("#locale").value;	
	inputDate = convertDate(inputDate,"DMY", locale, "en"); // Date Localization
	var isMealComplaints = formObj.isMealComplaints.value;	 //Added Against MOH-CRF-1125 
	//ML-MMOH-CRF-0687
	var isComplaintCnt = formObj_header.isComplaintCnt.value;
	//var isNotification = formObj_header.isNotification.value;	//Added Against ML-MMOH-SCF-1681
	
	var chkYN="";
	//if(isComplaintCnt=="true" || isNotification=="true")	//Added Against ML-MMOH-SCF-1681
	if(isComplaintCnt=="true" )	//Modified Against ML-MMOH-SCF-1987
		chkYN="Y";
	else	
		chkYN="N";
	//ML-MMOH-CRF-0687
	
	var rowCount = 0;
	var startIndex =0;
	var endIndex=0;
//	rowCount = formObj.querySelector("#freqBasedSelectedTable").getElementsByTagName("TR").length - 1;
	startIndex = formObj.querySelector("#startIndex").value;
	endIndex = formObj.querySelector("#endIndex").value;
	formObj.querySelector("#totalRecords").value=endIndex;
	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	
	var hh = today.getHours();
	var mi = today.getMinutes();

	var yyyy = today.getFullYear();
	if(dd<10){dd='0'+dd}
	if(mm<10){mm='0'+mm}
	
	if(hh<10){hh='0'+hh}
	if(mi<10){mi='0'+mi}
	
	today = dd+'/'+mm+'/'+yyyy+ ' '+hh+':'+mi;
	
	if( endIndex == 0){
		var error = getMessage("DS_SEL_RECORD","DS"); //"APP-DS0022 Atleast One Record Should Be Selected."
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
	}
	//IN::39965- Validate if atleast one record is updated
	var bValEntered = false;
	for ( var i = startIndex; i <= endIndex; i++) {
		if(formObj.querySelector("#effStatus" + i)) {
			var tmpStatusvalue = formObj.querySelector("#effStatus" + i).value;
			if(tmpStatusvalue != null && tmpStatusvalue != "")
			{
				bValEntered= true;
				break;
			}
		}
	}
	if(!bValEntered)
	{
		var error = 
			getMessage("DS_UPD_REC","DS")//"Atleast One Record Should Be updated.";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
		flag_check = 'false';
	}	
	if(flag_check == 'true'){
		for ( var i = 1; i <= endIndex; i++) {
			if(formObj.querySelector("#effStatus" + i)) {
				var singleStatus = formObj.querySelector("#effStatus" + i).value;
				var eventDateTime = formObj.querySelector("#eventDate_Freq" + i).value;
				eventDateTime = convertDate(eventDateTime,"DMYHM", locale, "en"); // Date Localization
				var complaint_code = formObj.querySelector("#complaintCode"+ i).value;
				var complaint_desc = formObj.querySelector("#complaintDesc"+ i).value;
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Starts Here
				if(isMealComplaints=='true'){
				var othersComp_desc = formObj.querySelector("#othersComp"+ i).value; 
				}
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Ends Here
				if(complaint_code==null) complaint_code = "";
				if(complaint_desc==null) complaint_desc = "";
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Starts Here
				if(isMealComplaints=='true'){
				if(othersComp_desc==null) othersComp_desc = "";
				}
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Ends Here
		//		CHECK IF THIS FUNCTION IS NEEDED validateForFreqOnApply(eventDateTime.value,i);
				//if(singleStatus.value != "" ){
					if(eventDateTime == ""){
						var error = getMessage("DS_EVNTDATE_NOT_BLANK","DS");//" APP-SM0073 Event Date cannot be blank";
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
						flag_check = 'false';
						break;
					}
					//IN::39965	-start
					var dateValArr = eventDateTime.split(' '); 
					if (dateValArr.length != 2) 
					{
						eventDateTime = '';
						formObj.querySelector("#eventDate_Freq" + i).value = '';
					} 
					//If selecting the status, Validate the eventdate if it is entered 
					if(singleStatus != "" && eventDateTime == "")
					{
						var error = getMessage("DS_EVNTDATE_NOT_BLANK","DS");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
						flag_check = 'false';
						break;
					}
					//IN::39965	-end
					if (eventDateTime != "") {
						var dtArr = (eventDateTime).split(" ");
						var returnVal =  compareDates(eventDateTime,today,locale,"DMYHM");
						if(returnVal == -1) {
							var error = getMessage("DS_DATIME_LESSOREQL_CURDATE","DS");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
							flag_check = 'false';
							break;
						}
						if (dtArr[0] == inputDate) {
							if (singleStatus == "MJ") {
							//Added Against Start MOH-CRF-1125 
							if(isMealComplaints=='true'){
								if (complaint_code == "" && complaint_desc == "" && othersComp_desc==""){
									var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") 
									messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
									flag_check = 'false';
									break;
								}
							//Added Against End MOH-CRF-1125 	
							}else if (complaint_code == "" && complaint_desc == "") {								
								var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS");
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
								flag_check = 'false';
								break;								
								}	
							}
						} else if (inputDate!=""){
							eventDateTime = "";
							formObj.querySelector("#eventDate_Freq" + i).value = '';
							var error =getMessage("DS_ACKDATE_EQL_EVENTDATE","DS");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="
									+ error;
							flag_check = 'false';
							break;
						}

					}
				if(singleStatus == "MJ"){
					//Added Against Start MOH-CRF-1125 
					if(isMealComplaints=='true'){
						if(complaint_code == null) complaint_code="";
						if(complaint_code == "null") complaint_code="";
						if (complaint_code == null || complaint_code == "" && complaint_desc == "" && othersComp_desc==""){
							var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") 
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
							flag_check = 'false';
							break;
						}
					//Added Against End MOH-CRF-1125 	
					}else if(complaint_code == "" || complaint_desc == "" || complaint_code == null || complaint_desc == null){
					var error=getMessage("DS_COMPLAINT_NOT_BLANK","DS");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
					flag_check = 'false';
					break;
					return false;						
					}	
				}
			}
		}
	}
		if(flag_check == 'true'){
			submitForm();
			//ML-MMOH-CRF-0687
			if(chkYN=="Y"){		
			error="";
			top.frames[1].location.href=top.frames[1].location.href;
			}
			//ML-MMOH-CRF-0687
		}
}

function insertingNonFreqRecords(){
	var flag_check = 'true';
	var formObj_header = parent.content.f_query_add_mod.header_frame.document.forms[0];
	var formObj = parent.content.f_query_add_mod.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	var sysdate=formObj.querySelector("#sysdate").value;
	var inputDate = formObj_header.querySelector("#date_nonFreqBased").value;
	formObj.querySelector("#date_nonFreqBased").value=inputDate;
	var locale = formObj.querySelector("#locale").value;	
	inputDate = convertDate(inputDate,"DMY", locale, "en"); // Date Localization 
	var isMealComplaints = formObj.isMealComplaints.value;	 //Added Against MOH-CRF-1125
	var rowCount = 0;
	var startIndex =0;
	var endIndex=0;
	//ML-MMOH-CRF-0687
	var isComplaintCnt = formObj_header.isComplaintCnt.value;
	//var isNotification = formObj_header.isNotification.value;	//Added Against ML-MMOH-SCF-1681
	
	var chkYN="";
	//if(isComplaintCnt=="true" || isNotification=="true")	//Added Against ML-MMOH-SCF-1681
	if(isComplaintCnt=="true")	//Added Against ML-MMOH-SCF-1987
		chkYN="Y";
	else	
		chkYN="N";
	//ML-MMOH-CRF-0687

	startIndex = formObj.querySelector("#startIndex").value;
	endIndex = formObj.querySelector("#endIndex").value;
	formObj.querySelector("#totalRecords").value=endIndex;
	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1;
	
	var hh = today.getHours();
	var mi = today.getMinutes();

	var yyyy = today.getFullYear();
	if(dd<10){dd='0'+dd}
	if(mm<10){mm='0'+mm}
	
	if(hh<10){hh='0'+hh}
	if(mi<10){mi='0'+mi}
	
	today = dd+'/'+mm+'/'+yyyy+ ' '+hh+':'+mi;

	if( endIndex == 0){
		var error = getMessage("DS_SEL_RECORD","DS");//"APP-DS0022 Atleast One Record Should Be Selected."
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
	}
	//IN::39965- Validate if atleast one record is updated
	var bValEntered = false;
	for ( var i = startIndex; i <= endIndex; i++) {
		if(formObj.querySelector("#effStatus" + i)) {
			var tmpStatusvalue = formObj.querySelector("#effStatus" + i).value;
			if(tmpStatusvalue != null && tmpStatusvalue != "")
			{
				bValEntered= true;
				break;
			}
		}
	}
	if(!bValEntered)
	{
		var error = getMessage("DS_UPD_REC","DS");//"Atleast One Record Should Be updated.";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
		flag_check = 'false';
	}
	if(flag_check == 'true'){
		for ( var i = 1; i <= endIndex; i++) {
				if(formObj.querySelector("#effStatus" + i)) {
				var singleStatus = formObj.querySelector("#effStatus" + i).value;
				var eventDateTime = formObj.querySelector("#eventDate_NonFreq" + i).value;
				eventDateTime = convertDate(eventDateTime,"DMYHM", locale, "en"); // Date Localization				
				var complaint_code = formObj.querySelector("#complaintCode"+ i).value;
				var complaint_desc = formObj.querySelector("#complaintDesc"+ i).value;
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Starts Here
				if(isMealComplaints=='true'){
				var othersComp_desc = formObj.querySelector("#othersComp"+ i).value;
				}
				//Added Against Start ML-MMOH-CRF-1125(ICN-68623) Ends Here
				//CHECK IF THIS FUNCTION IS NEEDED validateForFreqOnApply(eventDateTime.value,i);
					if(singleStatus != "" && eventDateTime == ""){
						var error = getMessage("DS_EVNTDATE_NOT_BLANK","DS"); 
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
						flag_check = 'false';
						break;
					}
				
					//IN::39965	-start
					var dateValArr = eventDateTime.split(' '); 
					if (dateValArr.length != 2) 
					{
						eventDateTime = '';
						formObj.querySelector("#eventDate_NonFreq" + i).value = '';
					} 
					//IN::39965	-end
					
					if (eventDateTime != "") {
						var dtArr = (eventDateTime).split(" ");
						var returnVal =  compareDates(eventDateTime,today,locale,"DMYHM");
						if(returnVal == -1) {
							// TO DO: MESSAGE
							var error = getMessage("DS_DATIME_LESSOREQL_CURDATE","DS"); 
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
							flag_check = 'false';
							break;
						}
						if (dtArr[0] == inputDate) {
							if (singleStatus == "MJ") {
							//Added Against Start MOH-CRF-1125 
							if(isMealComplaints=='true'){
								if (complaint_code == "" && complaint_desc == "" && othersComp_desc==""){
									var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") 
									messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="		+ error;
									flag_check = 'false';
									break;
								}
							//Added Against End MOH-CRF-1125 	
							}else if(complaint_code == "" && complaint_desc == "") {	
								var error =getMessage("DS_COMPLAINT_NOT_BLANK","DS");
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
								flag_check = 'false';
								break;									
								}
							}
						} else if (inputDate!=""){
							eventDateTime = "";
							formObj.querySelector("#eventDate_NonFreq" + i).value = '';
							var error = getMessage("DS_ACKDATE_EQL_EVENTDATE","DS"); 
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error;
							flag_check = 'false';
							break;
						}

					}
				if(singleStatus == "MJ"){	
		if(isMealComplaints=="true"){
			 if (complaint_code == "" && complaint_desc == "" && othersComp_desc==""){	
				var error = getMessage("DS_COMPLAINT_NOT_BLANK","DS") //"APP-SM0073 Complaints cannot be blank";
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ error;
				flag_check = 'false';
				return false;
			}
		}else if(complaint_code == "" && complaint_desc == ""){
						var error=getMessage("DS_COMPLAINT_NOT_BLANK","DS");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
						flag_check = 'false';
						break;
						return false;
		}
				}
			}
		}
	}
		if(flag_check == 'true'){
			submitForm();
			//ML-MMOH-CRF-0687
			if(chkYN=="Y"){		
			error="";
			top.frames[1].location.href=top.frames[1].location.href;
			}
			//ML-MMOH-CRF-0687
		}
}

function submitForm(){
	var formObj = parent.content.f_query_add_mod.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	formObj.method='post';
	formObj.action="../../servlet/eDS.MealPreparedServedComplaintsServlet";
	formObj.submit();
}

function submit123(){
	var formObj = document.forms[0];
	var checked=false;
	formObj.action="../../servlet/eDS.RejectedItemsServlet";
	var isMealComplaints = formObj.isMealComplaints.value;  //Added Against ML-MOH-CRF-1125
	for(i=0; i<formObj.elements.length; i++) {
		if(formObj.elements[i].type=="checkbox") {
			if(formObj.elements[i].checked==true) {
				checked=true;
				break;
			}
		}
	}
	var index=document.getElementById("index").value;	
	for(i=1; i<=index; i++) {
		if(document.getElementById("rejectedYn"+i).checked==true) {
		if(isMealComplaints=='true'){		//Added Against Start ML-MOH-CRF-1125
		if(document.getElementById("complaintDesc"+i).value=="" && document.getElementById("othersComp"+i).value==""){
			alert(getMessage("DS_COMPLAINT_NOT_BLANK","DS"));
			return;
			}
		}else{					//Added Against End ML-MOH-CRF-1125
		  if(document.getElementById("complaintDesc"+i).value=="") {
				alert(getMessage("DS_COMPLAINT_NOT_BLANK","DS"));
				return;		  
		  }	
		}
	}
  }	
	window.returnValue=checked;
	formObj.submit();
	window.close();
}

function onSuccess(){
//parent.f_query_add_mod.location.reload();
	var formObj =document.forms[0];
	var params = formObj.params.value;
	f_query_add_mod.location.href="../../eDS/jsp/MealPrepareServeComplaintsMain.jsp";
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

function changeDate_AllPatients() {
	var formObj = parent.parent.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	var formObj_multiRecordSelect = parent.frames[0].document.forms[0];
	var rowCount = 0;
	var tab=parent.parent.tab_frame.document.getElementById("viewID").value;
	var startIndex = formObj.querySelector("#startIndex").value;//Added against Script error
	var endIndex = formObj.querySelector("#endIndex").value;//Added against Script error

	if(tab=="mealTypeTab" && formObj!=null) {//Modified for Script error
		rowCount = formObj.querySelector("#mealSelectedTable").getElementsByTagName("TR").length - 1;
	}
	else if(tab=="freqBasedTab" && formObj!=null) {//Modified for Script error
		rowCount = formObj.querySelector("#freqBasedSelectedTable").getElementsByTagName("tr").length - 1;
	}
	else if(tab=="nonFreqBasedTab" && formObj!=null) {//Modified for Script error
		rowCount = formObj.querySelector("#nonFreqBasedSelectedTable").getElementsByTagName("tr").length - 1;
	}	
	
	var date_multiSelect=formObj_multiRecordSelect.document.getElementById("from").value;
	
	//for (var k = 1; k <= rowCount; k++) { //Commented against Script error
	for (var k = startIndex; k <= endIndex; k++) {
		if(tab=="mealTypeTab") {
			formObj.querySelector("#eventDate"+k).value=date_multiSelect;
		}
		else if(tab=="freqBasedTab") {
			formObj.querySelector("#eventDate_Freq"+k).value=date_multiSelect;
		}
		else if(tab=="nonFreqBasedTab") {
			formObj.querySelector("#eventDate_NonFreq"+k).value=date_multiSelect;
		}		
		
	}
	
	
}

function changeStatus() {
	var formObj = parent.parent.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	var formObj_multiRecordSelect = parent.frames[0].document.forms[0];
	var isMealComplaints =formObj.querySelector("#isMealComplaints").value; //Added Against CRF-1125
	var rowCount = 0;
	var tab=parent.parent.tab_frame.document.getElementById("viewID").value;
	var startIndex = formObj.querySelector("#startIndex").value;//Added by Aravindh agianst Script error
	var endIndex = formObj.querySelector("#endIndex").value;//Added by Aravindh agianst Script error
	if(tab=="mealTypeTab" && formObj!=null) {//Modified against Script error
		rowCount = formObj.querySelector("#mealSelectedTable").getElementsByTagName("TR").length - 1;
	}
	else if(tab=="freqBasedTab" && formObj!=null) {//Modified against Script error
		rowCount = formObj.querySelector("#freqBasedSelectedTable").getElementsByTagName("tr").length - 1;
	}
	else if(tab=="nonFreqBasedTab" && formObj!=null) {//Modified against Script error
		rowCount = formObj.querySelector("#nonFreqBasedSelectedTable").getElementsByTagName("tr").length - 1;
	}
	var status_multiSelect=formObj_multiRecordSelect.document.getElementById("setStatusForAll").value;
	//for (var k = 1; k <= rowCount; k++) { //Commented against Script error
	for (var k = startIndex; k <= endIndex; k++) {//Added against Script error
		var savedStatus = formObj.querySelector("#savedStatus"+k).value;
		//Added Against MOH-CRF-1125 Starts Here
			if(isMealComplaints=='true'){
				var othersComp = formObj.querySelector("#othersComp"+k).value;
			}
		//Added Against MOH-CRF-1125 Ends Here
		if(tab=="mealTypeTab") {
	       	if(status_multiSelect == "MS" || status_multiSelect == "" && savedStatus == "MS") {
	       		formObj.querySelector("#link"+k).style.visibility="visible";
				if(savedStatus == "MS"){
					formObj.querySelector("#link"+k).style.visibility="visible";
				}
			}
	       	else {
				if(savedStatus == "MS") {
					formObj.querySelector("#link"+k).style.visibility="visible";
				}else{
					formObj.querySelector("#link"+k).style.visibility="hidden";
				}
			}
		}
		if(status_multiSelect  == "MJ")
		{
				formObj.querySelector("#cmp"+k).style.visibility = "visible";
				//Added Against ML-MMOH-CRF-681
				formObj.querySelector("#MealReplaceYn"+k).disabled=false;
				formObj.querySelector("#MealReplaceYn"+k).value="N";
				if(isMealComplaints=='true'){ // Added Against CRF-1125
					formObj.querySelector("#othersLink"+k).style.visibility="visible";
					if(formObj.querySelector("#complaintDesc"+k).value!="" && formObj.querySelector("#othersComp"+k).value==""){
							formObj.querySelector("#othersLink"+k).disabled=true;
					}else if(formObj.querySelector("#complaintDesc"+k).value=="" && formObj.querySelector("#othersComp"+k).value!=""){
							formObj.querySelector("#othersLink"+k).disabled=false;
							formObj.querySelector("#complaintDesc"+k).disabled=true;
							formObj.querySelector("#bt"+k).disabled=true;
					}else{
							formObj.querySelector("#othersLink"+k).disabled=false;
							formObj.querySelector("#complaintDesc"+k).disabled=false;
							formObj.querySelector("#bt"+k).disabled=false;
					}	
				}
				//Added Against ML-MMOH-CRF-681
			if(tab=="mealTypeTab") {			
				formObj.querySelector("#link"+k).style.visibility="hidden";			
			}
		}else{	
			if(savedStatus == "MJ"){	
				formObj.querySelector("#cmp"+k).style.visibility = "visible";
				if(isMealComplaints=='true') // Added Against CRF-1125
				formObj.querySelector("#othersLink"+k).style.visibility="visible";
				if(tab=="mealTypeTab") {formObj.querySelector("#link"+k).style.visibility="hidden";}
			}else{		
				formObj.querySelector("#cmp"+k).style.visibility = "hidden";
				if(isMealComplaints=='true'){
					if(othersComp != ""){
						formObj.querySelector("#othersComp"+k).value = "";
						formObj.querySelector("#othersLink"+k).style.visibility="hidden";
					}else{
						formObj.querySelector("#othersLink"+k).style.visibility="hidden";
					}
					formObj.querySelector("#complaintDesc"+k).disabled=false;
					formObj.querySelector("#bt"+k).disabled=false;
				}
				/* if(isMealComplaints=='true') // Added Against CRF-1125
				formObj.querySelector("#othersLink"+k).style.visibility="hidden"; */
				//Added Against ML-MMOH-CRF-681
				formObj.querySelector("#MealReplaceYn"+k).disabled=true;
				formObj.querySelector("#MealReplaceYn"+k).value="N"; 
				//Added Against ML-MMOH-CRF-681
			}
//			To DO:
//			deleteRows2();
		}
		if(savedStatus=="MJ" && tab=="mealTypeTab"){
			formObj.querySelector("#link"+k).style.visibility="hidden";
		}
		
        var effStatus = formObj.querySelector("#effStatus"+k);
        if (savedStatus != null && savedStatus != "") {
			if(status_multiSelect!=""){
            if (savedStatus == "MP") {
                effStatus.value = status_multiSelect;
            } else {
                if (savedStatus == "MR" && status_multiSelect != "MP") {
                    effStatus.value = status_multiSelect;

                } else {
                    if (savedStatus == "MS" && (status_multiSelect != "MP" && status_multiSelect != "MR")) {
                        effStatus.value = status_multiSelect;

                    } else {
                        if (savedStatus == "MJ" && status_multiSelect == "MJ") {
							effStatus.value = status_multiSelect;

                        }else{

							if(savedStatus == "MS" && status_multiSelect != "MJ"){
								effStatus.value = "MS";

							}
							if(savedStatus == "MS" && status_multiSelect == ""){
								effStatus.value = "MS";

							}
						}
                    }
                }
            }}
			else{
				if(savedStatus == "MS" && status_multiSelect == ""){
					effStatus.value = "MS";

				}
			}
        } else {
            effStatus.value = status_multiSelect;

        }
    }
}

function changeSelectForMealType(index, currentState) {
	var formObj = parent.parent.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	var formObj_multiRecordSelect = parent.frames[0].document.forms[0];
	var tab=parent.parent.tab_frame.document.getElementById("viewID").value;
	var effStatus = formObj.querySelector("#effStatus"+index);
	var date;
	var savedStatus = formObj.querySelector("#savedStatus"+index).value;
	var isMealComplaints = formObj.isMealComplaints.value; //Added Against MOH-CRF-1125
	var othersComp = "";
	if(isMealComplaints=='true'){
		othersComp = formObj.querySelector("#othersComp"+index).value; //Added Against MOH-CRF-1125	
	}
	var message = getMessage("DS_CANT_SELECT","DS"); 	
	if(tab=="mealTypeTab"){
	
	date = formObj.querySelector("#eventDate"+index);
	}else if (tab == "freqBasedTab" || tab =="spFoodItemsTab"){
	date = formObj.querySelector("#eventDate_Freq"+index);
	}else if (tab == "nonFreqBasedTab") {
	date = formObj.querySelector("#eventDate_NonFreq"+index);
	}
	if(currentState == "MJ"){
		formObj.querySelector("#cmp"+index).style.visibility="visible";
		if(isMealComplaints=='true'){ //line no formObj.querySelector("#othersComp"+index).value!=""
			if(othersComp!=""){
			//if(document.getElementById("othersComp"+index).value!=""){
				document.getElementById("othersLink"+index).style.visibility="visible";
				document.getElementById("complaintDesc"+index).disabled=true;
				document.getElementById("bt"+index).disabled=true;
		}else{
			formObj.querySelector("#othersLink"+index).style.visibility="hidden";
		}
		}
		formObj.querySelector("#MealReplaceYn"+index).disabled=false;
		formObj.querySelector("#MealReplaceYn"+index).options[0].selected=true;
	}else{
		formObj.querySelector("#cmp"+index).style.visibility="hidden";
		formObj.querySelector("#MealReplaceYn"+index).disabled=true;
		formObj.querySelector("#MealReplaceYn"+index).value="N"; //Added Against ML-MMOH-CRF-681
		if(isMealComplaints=="true"){ // line no formObj.querySelector("#othersComp"+index).value!=""
			if(othersComp!=""){
			//if(document.getElementById("othersComp"+index).value!=""){
				document.getElementById("othersLink"+index).style.visibility="visible";
				document.getElementById("complaintDesc"+index).disabled=true;
				document.getElementById("bt"+index).disabled=true;
			}else{
				formObj.querySelector("#othersLink"+index).style.visibility="visible";
			}
		}
		
	}
	if(currentState == "MS" && tab=="mealTypeTab") {
		formObj.querySelector("#link"+index).style.visibility="visible";
		formObj.querySelector("#cmp"+index).style.visibility="hidden";
	}
	else if(currentState != "MS" && tab=="mealTypeTab"){
		formObj.querySelector("#link"+index).style.visibility="hidden"; 
	}
	if(currentState == "MJ") {
		formObj.querySelector("#cmp"+index).style.visibility="visible";
		if(isMealComplaints=="true"){
			formObj.querySelector("#othersLink"+index).style.visibility="visible";
			if(formObj.querySelector("#complaintDesc"+index).value!="" && formObj.querySelector("#othersComp"+index).value==""){
						formObj.querySelector("#othersLink"+index).disabled=true;
			}else if(formObj.querySelector("#complaintDesc"+index).value=="" && formObj.querySelector("#othersComp"+index).value!=""){
						formObj.querySelector("#othersLink"+index).disabled=false;
						formObj.querySelector("#complaintDesc"+index).disabled=true;
						formObj.querySelector("#bt"+index).disabled=true;
			}else{
						formObj.querySelector("#othersLink"+index).disabled=false;
						formObj.querySelector("#complaintDesc"+index).disabled=false;
						formObj.querySelector("#bt"+index).disabled=false;
			}
		}/* else{
			formObj.querySelector("#othersLink"+index).style.visibility="hidden";
		}  */ //Commented Against ML-MMOH-CRF-1125(ICN-68623)
	}
	else {
		formObj.querySelector("#cmp"+index).style.visibility="hidden";
		if(isMealComplaints=='true'){
		/* 
			if(formObj.querySelector("#complaintDesc"+index).value != ""){	//icn-1125US003
				formObj.querySelector("#othersLink"+index).disabled=true;
			}
			else if(formObj.querySelector("#othersComp"+index).value !=""){
			formObj.querySelector("#othersLink"+index).style.visibility="hidden";
			formObj.querySelector("#complaintDesc"+index).disabled = false;
			formObj.querySelector("#bt"+index).disabled = false;
			}	 */
			if(othersComp!=""){
				formObj.querySelector("#othersLink"+index).style.visibility="hidden";
				if(savedStatus!="MJ"){
					formObj.querySelector("#othersComp"+index).value ="";
				}
			}
			else{
				formObj.querySelector("#othersLink"+index).style.visibility="hidden";
			}
			document.getElementById("complaintDesc"+index).disabled=false;
			document.getElementById("bt"+index).disabled=false;			
		} 
	}

    if (savedStatus != null && savedStatus != "") {
        if (savedStatus == "MR" && currentState == "MP") {
        	if(tab=="mealTypeTab") {
			formObj.querySelector("#link"+index).style.visibility="hidden";
			}
        	alert(getMessage("DS_CANT_SELECT","DS"));
            effStatus.value = savedStatus;
			if(effStatus.value=="MS" && tab=="mealTypeTab") {
				formObj.querySelector("#link"+index).style.visibility="visible";
			}
            return false;
        } else {
            if (savedStatus == "MS" && (currentState == "MP" || currentState == "MR")) {
		
                if(tab=="mealTypeTab") {				
				document.getElementById("link"+index).style.visibility="hidden";}
		
                alert(getMessage("DS_CANT_SELECT","DS"));
                effStatus.value = savedStatus;
				if( effStatus.value=="MS" && tab=="mealTypeTab"){document.getElementById("link"+index).style.visibility="visible";}
                return false;
            } else {
                if (savedStatus == "MJ" && currentState != "MJ") {
                    if (tab=="mealTypeTab"){
					formObj.querySelector("#link"+index).style.visibility="hidden";
					}
					alert(getMessage("DS_CANT_SELECT","DS"));
                    effStatus.value = savedStatus;
				if(effStatus.value=="MS" && tab=="mealTypeTab"){
					formObj.querySelector("#link"+index).style.visibility="visible";
				}
				//Added Against Start ML-MMOH-CRF-683	
				if(effStatus.value=="MJ"){
					formObj.querySelector("#MealReplaceYn"+index).disabled=false;
					formObj.querySelector("#MealReplaceYn"+index).options[0].selected=true;
					if(isMealComplaints=='true'){	
					formObj.querySelector("#othersLink"+index).style.visibility="visible";
					if(formObj.querySelector("#complaintDesc"+index).value!="" && formObj.querySelector("#othersComp"+index).value==""){
						formObj.querySelector("#othersLink"+index).disabled=true;
					}else if(formObj.querySelector("#complaintDesc"+index).value=="" && formObj.querySelector("#othersComp"+index).value!=""){
						formObj.querySelector("#othersLink"+index).disabled=false;
						formObj.querySelector("#complaintDesc"+index).disabled=true;
						formObj.querySelector("#bt"+index).disabled=true;
					}else{
						formObj.querySelector("#othersLink"+index).disabled=false;
						formObj.querySelector("#complaintDesc"+index).disabled=false;
						formObj.querySelector("#bt"+index).disabled=false;
					}
					}
					formObj.querySelector("#cmp"+index).style.visibility="visible";
				}
				//Added Against End ML-MMOH-CRF-683	
                    return false;
                }
            }
        }
		if(currentState=="") {
			alert(message);
			effStatus.value = savedStatus;
			return false
		}
    } else {
		//parent.complaintsFrame.document.getElementById("vo.dsEpsdMealComplaintsVO.dsEpsdMealComplaintsIdVO[" + index + "].eventDate").value=parent.header.document.getElementById("eventDate").value;
        //effStatus.value = currentState;
    }

		if(date.value!=""){
/*			var date = parent.complaintsFrame.document.getElementById("vo.dsEpsdMealComplaintsVO.dsEpsdMealComplaintsIdVO[" + index + "].eventDate");
			parent.frames[1].document.getElementById("eventDate").value=date.value;
			date.value="";*/
		}

		if(savedStatus==effStatus.value){
//			parent.frames[1].document.getElementById("vo.dsEpsdMealComplaintsVO.dsEpsdMealComplaintsIdVO[" + index + "].eventDate").value=parent.frames[1].document.getElementById("eventDate").value;
		}
   }

async function show_FoodItems_ModalWindow(index){
	var linkFlag = false;
	var formObj = parent.frames[1];
	var formObj_header = parent.frames[0].document.forms[0];
	var mealTypeFrameHeaderPath = parent.parent.header_frame;
	var eventDate = document.getElementById("eventDate"+index).value;
	var encounterId = document.getElementById("encounterId"+index).value;
	var patientClass = document.getElementById("patientClass"+index).value;
	var kitchenCode = document.getElementById("kitchenCode"+index).value;
	var patientId = document.getElementById("patientId"+index).value;
	var dietType = document.getElementById("dietType"+index).value;
	var mealClass = document.getElementById("mealClass"+index).value;
	var mealCategory = document.getElementById("mealCategory"+index).value;
	var status = document.getElementById("effStatus"+index).value;
	var complaintCode = document.getElementById("complaintCode"+index).value;
	var complaintDesc = document.getElementById("complaintDesc"+index).value;
	var menuCode = document.getElementById("menuCode"+index).value;
	var mealType = document.getElementById("mealType"+index).value;
	var servingDate = document.getElementById("from_date").value;
	var languageId = document.getElementById("locale").value;
	var sourceCode = mealTypeFrameHeaderPath.document.forms[0].querySelector("#nursingUnit").value;
	var splFoodItemYn=document.getElementById("splFoodItemYn").value;
	var operatingFacilityId=mealTypeFrameHeaderPath.document.forms[0].querySelector("#facility_id").value;
	var isMealComplaints = document.getElementById("isMealComplaints").value;
	var othersComp="";
	if(isMealComplaints=='true')
	othersComp = document.getElementById("othersComp"+index).value; //Added Against MOH-CRF-1125
	var pArgumentArray = new Array();
	var retVal = new String();
	var dialogHeight = "350px";
	var dialogWidth = "1150px"; //Modified Against MOH-CRF-1125
	var status = "no";
	var title= getLabel("eOT.FoodItem.Label","OT");
	loadMethod='1';

	var param="title="+ title +"&method=" + loadMethod + "&rejectedItem=Y" +"&encounterId="+encounterId+"&mealType="+mealType+"&servingDate="+servingDate+"&languageId="+languageId+"&eventDate="+eventDate+"&sourceCode="+sourceCode+"&patientClass="+patientClass+"&kitchenCode="+kitchenCode+"&patientId="+patientId+"&dietType="+dietType+"&menuCode="+menuCode+"&status="+status+"&complaintCode="+complaintCode+"&complaintDesc="+complaintDesc+"&mealClass="+mealClass+"&mealCategory="+mealCategory+"&othersComp="+othersComp+"&isMealComplaints="+isMealComplaints;
	var dialogUrl = "../../eDS/jsp/ModalMessageFrames.jsp?"+param
	var dialogArguments = pArgumentArray;
	var dialogFeatures = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + " ; scroll:yes; status:" + status+"; help:no;scrollbars=1";
	var returnVal= await window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

	if(returnVal==true)
	{
		parent.frames[1].document.getElementById("link"+index).style.fontWeight='bold';
	}else if(returnVal==false){
		parent.frames[1].document.getElementById("link"+index).style.fontWeight='normal';
	}

	function populateRejectedItems(rec){
			var val="";
			var val1="";
			var val2="";
			var val3="";
			for(prop in rec){
				for(prop1 in rec[prop]){
					val=rec[prop][0]
					val1=rec[prop][1]
					val2=rec[prop][2]
					val3=rec[prop][3]
					val4=rec[prop][4]
					if(val != "" || val1 != "" || val2 != "" || val3 != "" || val4 != ""){
						linkFlag = true;
						parent.frames[1].document.getElementById("link"+index).style.fontWeight='700';
					}else{
						linkFlag = false;
						parent.frames[1].document.getElementById("link"+index).style.fontWeight='normal';
					}
				}
			}
			if(linkFlag == true){
			parent.frames[1].document.getElementById("link"+index).style.fontWeight='700';
		}else{
			parent.frames[1].document.getElementById("link"+index).style.fontWeight='normal';
		}
		}
}

function getFoodItem(encounterId, mealType, servingDate, locale, splFoodItemYn, kitchenCode, facilityId){
	// TODO: CHECK IF THIS IS NEEDED

/*	encounterId = trimString(encounterId);
	mealType = trimString(mealType);
	servingDate = trimString(servingDate);
	locale = trimString(locale);
	splFoodItemYn = trimString(splFoodItemYn);
	kitchenCode = trimString(kitchenCode);
	facilityId = trimString(facilityId);

	MealServedDetails.getFoodItem(encounterId, mealType, servingDate, locale, splFoodItemYn, populateFoodItem);
*/}

var chkFlagVal = 0;
function getCellVal(obj,id){
	if(obj.checked == true){
		obj.value="Y";
//		document.getElementById("vo.mealPrepairedRejecetedListVO["+id+"].rejectedYn").value = "Y";
		document.getElementById("complaintDesc"+id).disabled = false;
		document.getElementById("RejectedItemLookup"+id).disabled = false;
		document.getElementById("cal"+id).disabled = false;
		document.getElementById("mandatory"+id).style.visibility = "visible";
		document.getElementById("rejdate"+id).disabled = false;
		//Added Against ML-MMOH-CRF-1125 Starts(ICN-68623) Here
		if(document.getElementById("isMealComplaints").value=='true'){
		document.getElementById("othersLink"+id).disabled = false;
		}
		//Added Against ML-MMOH-CRF-1125(ICN-68623) Ends Here
		var mealServedDate = document.getElementById("eventDate").value;
		document.getElementById("rejdate"+id).value = mealServedDate;
		chkFlagVal = parseInt(chkFlagVal) + 1;
		//Added Against Below condition ML-MOH-CRF-1125
		if(document.getElementById("isMealComplaints").value=='true') 
		document.getElementById("othersLink"+id).style.visibility = "visible";
		var len=document.getElementById("index").value;

		if( chkFlagVal == len ){
			var error;
			chkboxFlag = "N";
			error =getMessage("DS0019","OT");
			parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
			return false;
		}else{
			var error = "";
			chkboxFlag = "Y";
			parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		}
		if(chkboxFlag == 'N'){
			return false;
		}
	}else{	
		obj.value="N";
		document.getElementById("rejectedYn"+id).value = "N";
		document.getElementById("complaintDesc"+id).value = "";
		document.getElementById("complaintCode"+id).value = "";
		document.getElementById("complaintDesc"+id).disabled = true;
		document.getElementById("RejectedItemLookup"+id).disabled = true;
		document.getElementById("cal"+id).disabled = true;
		document.getElementById("rejdate"+id).disabled = true;
		document.getElementById("rejdate"+id).value = "";
		//Added Against ML-MMOH-CRF-1125 Starts(ICN-68623) Here
		if(document.getElementById("isMealComplaints").value=='true'){
		document.getElementById("othersLink"+id).disabled = true;
		document.getElementById("othersComp"+id).value = "";
		}
		//Added Against ML-MMOH-CRF-1125(ICN-68623) Ends Here
		document.getElementById("mandatory"+id).style.visibility = "hidden";
		if(parseInt(chkFlagVal) >= 1){
			chkFlagVal = parseInt(chkFlagVal) - 1;
		}
		if(document.getElementById("isMealComplaints").value=='true') {
			document.getElementById("othersLink"+id).style.visibility = "hidden"; //Added Against ML-MOH-CRF-1125
			document.getElementById("othersComp"+id).value = "";
		}
	}
	var len=document.getElementById("index").value;
	if( chkFlagVal == len ){
		var error;
		chkboxFlag = "N";
		temp=getMessage("DS0019","OT");
		error = temp + "<br>";
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		return false;
	}else{
		var error = "";
		chkboxFlag = "Y";
		parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
	if(chkboxFlag == 'N'){
		return false;
	}
}

async function showComplaintslookup(obj, index) {
	var formObj = document.forms[0];
	var isMealComplaints = formObj.isMealComplaints.value;//Added Against MOH-CRF-1125
	var locale = document.getElementById("locale1").value;
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "SELECT COMPLAINTS.LONG_DESC DESCRIPTION, COMPLAINTS.COMPLAINT_CODE  CODE FROM DS_COMPLAINTS_LANG_VW COMPLAINTS WHERE UPPER(COMPLAINTS.LONG_DESC) LIKE UPPER(?) AND UPPER(COMPLAINTS.COMPLAINT_CODE) LIKE UPPER(?) AND COMPLAINTS.LANGUAGE_ID= '" + locale + "' AND   COMPLAINTS.EFF_STATUS='E'";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("complaintDesc" + index).value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title=getLabel("eOT.Complaints.Label","OT");
	returnedValues = await parent.parent.parent.window.CommonLookup(title, argumentArray);
	
	var link =""; //Added Against MOH-CRF-1125
	if ((returnedValues != null) && (returnedValues != "")) {
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',');
		}
		document.getElementById("complaintDesc" + index).value = returnedValues[1];
		document.getElementById("complaintCode" + index).value = returnedValues[0];
		/*Added Against Start ML-MMOH-CRF-1125 */
		if(isMealComplaints=='true'){
		 document.getElementById("othersLink"+ index).disabled=true; 
		} 
		/* Added Against End ML-MMOH-CRF-1125 */
	} else {
		document.getElementById("complaintDesc" + index).value = '';
		document.getElementById("complaintCode" + index).value = '';
		/*Added Against Start MMOH-CRF-1125 */
		if(isMealComplaints=='true'){
			var Others = "Others";
			var empty = "empty";
			link = "<a id='othersLink"+index+"' name='othersLink"+index+"' style='visibility:visible'  href='javascript:OtherCompReject("+index+");'> "+Others+" </a>"+"<input type=hidden id='othersComp"+index+"' name='othersComp"+index+"' id='othersComp"+index+"' value='"+empty+"'>";
			document.getElementById("othersLink"+index).disabled=false;
		}
		/*Added Against End MMOH-CRF-1125 */
	}
}

function validateDate(val,k){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	val = convertDate(val,"DMYHM", locale, "en");
	var headerPath = parent.parent.header_frame;
	var inputDate;
	var fieldName;
	var tab=parent.parent.tab_frame.document.getElementById("viewID").value;
	if (tab == "mealTypeTab") {inputDate=headerPath.document.getElementById("date_mealtype").value;
	inputDate = convertDate(inputDate,"DMY", locale, "en");
	fieldName="eventDate"+k;}
	else if (tab == "freqBasedTab" || tab =="spFoodItemsTab") {inputDate=headerPath.document.getElementById("date_freqBased").value;
	inputDate = convertDate(inputDate,"DMY", locale, "en");
	fieldName="eventDate_Freq"+k;}
	else if (tab == "nonFreqBasedTab") {inputDate=headerPath.document.getElementById("date_nonFreqBased").value;
	inputDate = convertDate(inputDate,"DMY", locale, "en");
	fieldName="eventDate_NonFreq"+k;}
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
	var sysDate=date1+"/"+month+"/"+year+" "+hour+":"+minute;

	eventDate = val.split(" ");

	var todayDateTime = sysDate+" "+eventDate[1];

	if(isValidDateTime(val)){
		var returnVal =  compareDates(eventDate[0],inputDate,'en',"DMY");
				if(returnVal==0){
					var flag =  compareDates(val,sysDate,'en',"DMYHM");
							if(flag == -1){
								document.getElementById(fieldName).value="";
								var error = getMessage("DS_ACKDATE_LESS_CURDATE","DS");
								alert(error);
								document.getElementById(fieldName).value="";
								parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
							}else{
								var error="";
								parent.parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
							}
					}else if (inputDate!=""){
						document.getElementById(fieldName).value="";
						alert(getMessage("DS_ACKDATE_EQL_EVENTDATE","DS"));
					}
			}
			else
			{
				parent.frames[1].document.getElementById(fieldName).value="";
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
		var alphaFilter =/^[0-9]+$/;   //addede by yadav on 5/12/2010
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

async function patientIdLookup(obj) {
	var formObj = document.forms[0];
	var locale = document.getElementById("locale").value;
	var nursingUnit = document.getElementById("nursingUnit").value;
	var facilityId = document.getElementById("facility_id").value;
	var result = false;
	var message = "";
	var flag = "";
	var function_id = "";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var sql = "select  patient_Name as DESCRIPTION,patient_Id as code from Ip_Open_Encounter_Vw where facility_Id ='"+facilityId+"' and patient_Name like upper(?) and patient_Id like nvl(replace(?,' ',''),patient_Id) and nursing_Unit_Code=nvl(replace('"+nursingUnit+"',' ',''),nursing_Unit_Code)";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("patientId").value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var title = "TITLE";
	returnedValues = await CommonLookup(title, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		if(returnedValues.length === 1)
			returnedValues = returnedValues[0].split(',');
		
		document.getElementById("patientName").value = returnedValues[1];
		document.getElementById("patientId").value = returnedValues[0];
	} else {
		document.getElementById("patientName").value = '';
		document.getElementById("patientId").value = '';
	}
}

function isValidDateTime_AllPatients(obj){
	if(obj.value!=""){
	var str=obj.value;
	var dflag=true;
	var tflag=true;
	var dateValArr = str.split(' ');
	if (dateValArr.length != 2) 
	{
		 alert(getMessage('INVALID_DATE_FMT','SM'));			 
		 obj.focus();
	}
	else
	{
		 dflag=checkDate(dateValArr[0]);
		 tflag=checkTime(dateValArr[1]);
	 if(dflag==true && tflag==true)
		{
		}
		else
		{
		 obj.focus();
		}
	}		
	}
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

function checkDate(objval)
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
	{//flag=false;
	if (!arr_date[0]) flag=false;
	if (!RE_NUM.exec(arr_date[0])) flag=false;
	if (arr_date[0].length!=2) flag=false;
	if (!arr_date[1]) flag=false;
	if (!RE_NUM.exec(arr_date[1])) flag=false;
	if (arr_date[1].length!=2) flag=false;
	if (!arr_date[2]) flag=false;
	if (!RE_NUM.exec(arr_date[2])) flag=false;
	if (arr_date[2].length!=4) flag=false;
	var dt_date = new Date();
	dt_date.setDate(1);

	if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
	dt_date.setMonth(arr_date[1]-1);
	var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
	dt_date.setDate(arr_date[0]);

	//alert(dt_date.getMonth()+ " and  " + (arr_date[1]-1));
			
	if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;
		
	if (flag==false){
			alert(getMessage('INVALID_DATE_FMT','SM'));			 
		}
	}
	return flag;
}

function checkTime(field)
{
	var errorMsg = "";
	// regular expression to match required time format
	re = /^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;
	var flag=true;
	if(field.value != '') {
	if(regs = field.match(re)) {
	if(regs[4]) {
	// 12-hour time format with am/pm
	if(regs[1] < 1 || regs[1] > 12 || regs[1].length!=2) {
		alert(getMessage('INVALID_DATE_FMT','SM'))
		flag=false;
	}
	} else {
	// 24-hour time format
	if(regs[1] > 23  || regs[1].length!=2) {
		alert(getMessage('INVALID_DATE_FMT','SM'));	
		flag=false;
	}
	}
	if(!errorMsg && regs[2] > 59) {
		alert(getMessage('INVALID_DATE_FMT','SM'));	
		flag=false;
	}
	} else {
		alert(getMessage('INVALID_DATE_FMT','SM'));	
		flag=false;
	}
  }
  if(errorMsg != "") {
    alert(errorMsg);
    return false;
  }  
  return flag;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.value="";
	obj.focus();
	return null;
}
function callNoRecord()
{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

function  reset(){
	parent.content.f_query_add_mod.location.href='../../eDS/jsp/MealPrepareServeComplaintsMain.jsp';
}

function val_date(obj)
{
	if(obj.value !='')
	{
		if(doDateTimeChk(obj))
		{
		}
		else
		{
			alert(getMessage("DS_INVAL_DATE_TIME_FORMAT","DS"));
			obj.focus();
		}
	}
}

/* Added Against Start MOH-CRF-1125 */
async function OtherComplaints(index){
	var others = "";
	var isDisableChk = document.getElementById("complaintDesc"+index).value; //ICN-1125US003
	if(isDisableChk!="" && isDisableChk!=null)
	return;
	var othersCmpHdr = "";
	othersCmpHdr = document.getElementById("othersComp"+index).value;
	if(others != "" || others != null || others == undefined){
		if(othersCmpHdr != ""){
			 others = othersCmpHdr;
		}
		else{
			 othersCmpHdr = others;
		}
	}
	else{
		othersCmpHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/OtherComplaints.jsp?&othersCmpHdr="+encodeURIComponent(othersCmpHdr)+"&index="+index;	
	var dialogArguments = others;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnOthersCmp = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnOthersCmp != null){
		others = returnOthersCmp;
		if(others!= ""){
		document.getElementById("othersLink"+index).disabled=false; 
		document.getElementById("complaintDesc"+index).disabled=true;
		document.getElementById("bt"+index).disabled=true;
		}else{
		document.getElementById("othersLink"+index).disabled = false; 
		document.getElementById("complaintDesc"+index).disabled = false;
		document.getElementById("bt"+index).disabled = false;		
		}
	}
	document.getElementById("othersComp"+index).value = others;
	if(returnOthersCmp == undefined || othersCmpHdr ==""){
		document.getElementById("othersLink"+index).enabled=true; 
		document.getElementById("complaintDesc"+index).enabled=true;
		document.getElementById("bt"+index).enabled=true;
		returnOthersCmp = dialogArguments;
	}
}

async function OtherCompReject(index){
	var others = "";
	var isDisableChk = document.getElementById("complaintDesc"+index).value; //ICN-1125US003
	if(isDisableChk!="" && isDisableChk!=null)
	return;
	var othersCmpHdr = "";
	othersCmpHdr = document.getElementById("othersComp"+index).value;
	if(others != "" || others != null || others == undefined){
		if(othersCmpHdr != ""){
			 others = othersCmpHdr;
		}
		else{
			 othersCmpHdr = others;
		}
	}
	else{
		othersCmpHdr = "";
	}
	var dialogUrl1 = "../../eDS/jsp/OtherComplaints.jsp?&othersCmpHdr="+encodeURIComponent(othersCmpHdr)+"&index="+index;	
	var dialogArguments = others;
	var dialogFeatures = "dialogHeight:13;dialogWidth:28;status:no;scroll:yes";
	returnOthersCmp = await window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(returnOthersCmp != null){
		others = returnOthersCmp;
		if(others!= ""){
			document.getElementById("othersLink"+index).disabled=false; 
			document.getElementById("complaintDesc"+index).disabled=true;
			document.getElementById("RejectedItemLookup"+index).disabled=true;
		}else{
			document.getElementById("othersLink"+index).disabled = false; 
			document.getElementById("complaintDesc"+index).disabled = false;
			document.getElementById("RejectedItemLookup"+index).disabled = false;		
		}
	}
	document.getElementById("othersComp"+index).value = others;
	if(returnOthersCmp == undefined || othersCmpHdr ==""){		
		document.getElementById("othersLink"+index).enabled=true; 
		document.getElementById("complaintDesc"+index).enabled=true;
		document.getElementById("RejectedItemLookup"+index).enabled=true;
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

function enableOthers(index) {
	var formObj = parent.parent.meal_tab_frame.meal_plan_details_frame.document.forms[0];
	var effStatus = formObj.querySelector("#effStatus"+index).value;		
	if(document.getElementById("complaintDesc"+index).value==""){
	var isMealComplaints = document.getElementById("isMealComplaints").value;
	if(isMealComplaints=='true'){
		if(effStatus!="" && effStatus=="MJ"){
			var Others = "Others";
			var empty = "empty";		
			var link = "<a id='othersLink"+index+"' name='othersLink"+index+"' style='visibility:visible'  href='javascript:OtherComplaints("+index+");'> "+Others+" </a>"+"<input type=hidden id='othersComp"+index+"' name='othersComp"+index+"' id='othersComp"+index+"' value='"+empty+"'>";
			document.getElementById("othersLink"+index).disabled=false;
		}
	}
	}	
}
/* Added Against End MOH-CRF-1125 */


/**
File Name		: CancelledOrderList.js
CRF#			: PMG2013-CRF-0009.1[IN050329]
Author			: Selvin Manoharan
Date			: Nov-2018
**/

var allSelected = new Array();

function run(){
		var flag =checkNull();
		if(flag==true){
			var formObj = parent.content.f_query_rep.CancelledOrderList;
			var p_module_id = formObj.p_module_id.value;
			var p_report_id = formObj.p_report_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var kitchenCode = formObj.kitchenCode.value;
			var fromDate = formObj.fromDate.value;
			var toDate = formObj.toDate.value;
			var mealClass = formObj.mealClass.value;
			var dietType = formObj.dietType.value;
			var complaintCode = formObj.complaintCode.value;
			var p_patient_id = formObj.patientId.value;	
			
			if(fromDate.length<1 || toDate.length<1){
				alert(getMessage('DS_FROM_TO_DATE_NOT_BLANK','ds'));
			return false;
			}
			
			if(kitchenCode==""){
			alert("Kitchen cannot be blank");
			return false;
			}
			if(!checkTODate())
			return false;
					
			var wardList = formObj.ward;
			var p_ward_code="";
					var count = 0;
					for (var i = 0; i < wardList.options.length; i++){
					  if (wardList.options[i].selected){
						  count++;
						  if (count == 1) {
							  if(wardList.options[i].value == "All"){
								 // p_ward_code = document.getElementById("selectedAll").value;
								  p_ward_code = formObj.selectedAll.value;
							  }else{
								  p_ward_code=p_ward_code+'\''+wardList.options[i].value+'\'';
							  }
						  }
						  else {
							  p_ward_code=p_ward_code+',\''+wardList.options[i].value+'\'';
						  }
					  }
					}	
			
			formObj.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&locale="+locale+"&p_kitchen_code="+kitchenCode+"&p_fm_date="+fromDate+"&p_to_date="+toDate+"&P_WARD="+p_ward_code+"&p_meal_class="+mealClass+"&p_diet_type="+dietType+"&p_can_reason="+complaintCode+"&p_patient_id="+p_patient_id;
			formObj.submit();
		}
	}

	function checkNull(){
		var flag;
		var error="";
		var formObj = parent.content.f_query_rep.CancelledOrderList;
		var fromDate=formObj.fromDate.value;
		var toDate=formObj.toDate.value;
		var from_label=getLabel("Common.Order.label","Common")+" "+getLabel("Common.Cancellation.label","Common")+" "+getLabel("Common.from.label","Common")+" "+getLabel("Common.date.label","Common");
		
		var to_label=getLabel("Common.Order.label","Common")+" "+getLabel("Common.Cancellation.label","Common")+" "+getLabel("Common.to.label","Common")+" "+getLabel("Common.date.label","Common");
		
		if(fromDate=="") {
			flag=false;
			error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",from_label)+"<br>";
		}
		if(toDate=="") {
			flag=false;
			error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",to_label)+"<br>";
		}
		
			messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
		if(flag==false) return false; else return true;
	}

	function reset(){
		location.reload();
	}
	

function checkForSpecCharsforID(event)
   {
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
  }
  
	
async function callSearchScreen()
{
	var patientid = await PatientSearch('','','','','','','Y','','','VIEW');
	if(patientid !=null)
	document.forms[0].patientId.value = patientid;
	document.forms[0].patientId.focus();
}

function getWards(obj)
{
		var wardCode = obj;
		var facility = document.getElementById("facility_id").value;
		var formObj = parent.frames[1].document.forms[0];
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		var params = "func_mode=getWards&facility="+facility+"&wardCode="+wardCode;
		xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var ward = formObj.ward;
		while(ward.length > 0){
			ward.remove(0);
		}
		if(retVal != null && retVal != ""){
			var retValArr = retVal.split("???");
			if(retValArr!=''){
				var listOption	= document.createElement('option');
				listOption.value = "All";
				listOption.text = "All";
				ward.add(listOption);
				
				for(var i=0; i<retValArr.length; i++){
					var wardCode = retValArr[i].split(":::");
					var listOption1	= document.createElement('option');
						listOption1.value = wardCode[0];
						listOption1.text = wardCode[1];
						ward.add(listOption1);
				}
			}
		}else{
			// Added Against ML-MMOH-CRF-1818-37552...starts
			 var listOption	= document.createElement('option');
				listOption.text = getLabel("eOT.select.Label","eOT");
				 ward.add(listOption);
				 // Added Against ML-MMOH-CRF-1818-37552...ends
		}
}

function selectAll(selectedAll)
{
		var formObj = parent.frames[1].document.forms[0];
		var ward = formObj.ward;
		if(selectedAll == "All"){
			var k=0;
			for(i=1;i<ward.length;i++){
				allSelected[k] = ""+'\''+ward.options[i].value+'\'';
				k++;
			}
			document.getElementById("selectedAll").value = allSelected;
		}else
			return;
}

	
async function complaintsLookup(obj) {
	var formObj = document.forms[0];
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
	returnedValues = await CommonLookup(title, argumentArray);
	if((returnedValues != null) && (returnedValues != "")) {
		var ret1=unescape(returnedValues);
	 	arr=ret1.split(",");
		document.getElementById("complaintDesc").value = arr[1];
		document.getElementById("complaintCode").value = arr[0];		
	}else{
		document.getElementById("complaintDesc").value = '';
		document.getElementById("complaintCode").value = '';		
	}
}	


//Date Comparision
function checkTODate()
{
	var formObj=parent.content.f_query_rep.CancelledOrderList;
	var fromDate= formObj.fromDate.value;
	var toDate= formObj.toDate.value;
	var d1Arr = fromDate.split("/");
	var d2Arr = toDate.split("/");
	var errMsg = getMessage('DS_FROMDATE_NOT_GTN_TODATE','ds')
	if(parseInt(d2Arr[2],10)<parseInt(d1Arr[2],10)){
		alert(errMsg);
		return false;
	}
	else if(parseInt(d2Arr[2],10)==parseInt(d1Arr[2],10)){
		if(parseInt(d2Arr[1],10)<parseInt(d1Arr[1],10)){
				alert(errMsg);
				return false;
		}
		else if(parseInt(d2Arr[1],10)==parseInt(d1Arr[1],10)){
			if(parseInt(d2Arr[0],10)<parseInt(d1Arr[0],10)){
				alert(errMsg);
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

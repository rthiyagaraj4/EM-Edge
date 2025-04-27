//Created for ML-MMOH-CRF-0685
var DESC_LINK		= "2"   ;
var DESC_CODE       = "DESC_CODE" ;
function apply()
{
	var obj=document.frames[1].frames[1];
	var facility_id=obj.document.getElementById("facility_id").value;
	var strloggeduser=obj.document.getElementById("strloggeduser").value;
	var strclientip=obj.document.getElementById("strclientip").value;
	var xmlDoc="" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";

	var i=obj.document.getElementById("RejectionListcount").value;
	var acknowledgeArray = new Array();
	var serving_dateArray = new Array();
	var app_noArray = new Array();
	var encounter_idArray = new Array();
	var mealtype_codeArray = new Array();
	var statusArray = new Array();
	var acknowledged_byArray = new Array();
	var acknowledged_date_timeArray = new Array();
	var acknowledgeJSON=new Array();
	var servingdateForJSON=new Array();
	var app_noForJSON=new Array();
	var encounter_idForJSON=new Array();
	var mealtype_codeForJSON=new Array();
	var statusForJSON=new Array();
	var acknowledged_byJSON=new Array();
	var acknowledged_date_timeJSON=new Array();
	var jsonDataObject = new Object();
	for(var j=0;j<i;j++)
	{	
		acknowledgeArray[j]=obj.document.getElementById("acknowledge"+j).value;
		if(obj.document.getElementById("acknowledge"+j).disabled==false) //Common-ICN-0080
		{
		serving_dateArray[j]=obj.document.getElementById("serving_date"+j).value;
		app_noArray[j]=obj.document.getElementById("app_no"+j).value;
		encounter_idArray[j]=obj.document.getElementById("encounter_id"+j).value;
		mealtype_codeArray[j]=obj.document.getElementById("mealtype_code"+j).value;
		statusArray[j]=obj.document.getElementById("status"+j).value;
		acknowledged_byArray[j]=obj.document.getElementById("acknowledged_by"+j).value;
		acknowledged_date_timeArray[j]=obj.document.getElementById("acknowledged_date_time"+j).value;

		acknowledgeJSON.push({acknowledge:obj.document.getElementById("acknowledge"+j).value});
		servingdateForJSON.push({serving_date:obj.document.getElementById("serving_date"+j).value});
		app_noForJSON.push({app_no:obj.document.getElementById("app_no"+j).value});
		encounter_idForJSON.push({encounter_id:obj.document.getElementById("encounter_id"+j).value});
		mealtype_codeForJSON.push({mealtype_code:obj.document.getElementById("mealtype_code"+j).value});
		statusForJSON.push({status:obj.document.getElementById("status"+j).value});
		acknowledged_byJSON.push({acknowledged_by:obj.document.getElementById("acknowledged_by"+j).value});
		acknowledged_date_timeJSON.push({acknowledged_date_time:obj.document.getElementById("acknowledged_date_time"+j).value});

		jsonDataObject.facility_id=facility_id;
		jsonDataObject.strloggeduser=strloggeduser;
		jsonDataObject.strclientip=strclientip;

		jsonDataObject.acknowledgeArray=acknowledgeJSON;
		jsonDataObject.serving_dateArray=servingdateForJSON;
		jsonDataObject.app_noArray=app_noForJSON;
		jsonDataObject.encounter_idArray=encounter_idForJSON;
		jsonDataObject.mealtype_codeArray=mealtype_codeForJSON;
		//jsonDataObject.status=obj.document.getElementById("status"+j).value;
		jsonDataObject.statusArray=statusForJSON;//07-Dec-17
		jsonDataObject.acknowledged_by=obj.document.getElementById("acknowledged_by"+j).value;
		jsonDataObject.acknowledged_date_time=obj.document.getElementById("acknowledged_date_time"+j).value;	

		var jsonData = JSON.stringify(jsonDataObject);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		}

	}
	xmlHttp.open("POST", "../../servlet/eDS.MealRejCompServlet?mode=insertMealRejection"+"&jsonData="+jsonData+"&RejectionListcount="+i,false);	
	xmlHttp.send(xmlDoc);
	var retVal = (xmlHttp.responseText);
	document.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+retVal;
	//Refreshing
	top.frames[1].location.href=top.frames[1].location.href;
	parent.parent.frames[2].frames[1].frames[0].location.reload();	
	//Refreshing
}

function DateChange()
{
	var oncall=parent.query_criteria.document.getElementById("onCall").value;
	//Count 0 - Serving Date Trom and To should be blank
	var locale = parent.query_criteria.document.getElementById("locale").value;
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1
	var day = currentTime.getDate()
	var year = currentTime.getFullYear()
	if(month < 10)
		month="0"+month;
	if(day < 10)
		day="0"+day;
	sysDate = day+"/"+month+"/"+year;

	if(oncall=="onLoad")
	{
		var serving_date=document.getElementById("servingDate").value;	
		var serving_todate=document.getElementById("servingDateTo").value;
		parent.query_criteria.document.getElementById("servingDate").value=serving_date;
		parent.query_criteria.document.getElementById("servingDateTo").value=serving_todate;
		if(serving_date == "" && serving_todate == ""){
			parent.query_criteria.document.getElementById("servingDateTo").value=sysDate;
			parent.query_criteria.document.getElementById("servingDate").value=sysDate;
		}
	}
}

function submitForm() {
	var frm=document.forms[0];
	var servDate = frm.servDate.value;
	var error="";		
	if(servDate == "")
	{		
		error=getMessage("DS_SERVDAT_NOT_BLANK","DS");		    
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.query_result.location.href="../../eCommon/html/blank.html";
		alert(error);			
	}		
	else
	{		
		var flag = compareDate(servDate,frm.currentDate.value);
		if(flag== 1){			
		error=getMessage("DS_SERVDAT_NOT_GRTR_CURDAT","DS");
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.query_result.location.href="../../eCommon/html/blank.html";
		alert(error);			
	}
	else
	{
		var fields = new Array (frm.Patient_Class);
		var PatientClass=getLabel("Common.patientclass.label","common");
		var wardClinic=getLabel("eDS.WardClinic.Label","ds");
		var patient_Class = frm.Patient_Class.value;
		var ward_Clinic_code = frm.wardDesc.value;
		var ward_Clinic_Desc= frm.wardClinicDesc.value;		
		var names = new Array (PatientClass);
	if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
	{	
		parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.query_result.location.href="../../eDS/jsp/DSMealRejectionsQueryResult.jsp?patient_Class="+patient_Class+"&ward_Clinic_code="+ward_Clinic_code+"&ward_Clinic_Desc="+ward_Clinic_Desc+"&serv_Date="+servDate;
	}
	else
		parent.query_result.location.href="../../eCommon/html/blank.html";
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
	obj.focus();
	obj.select();
	return null;
}

function getSysDate(){
	var locale = document.getElementById("locale").value
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1
	var day = currentTime.getDate()
	var year = currentTime.getFullYear()
	if(month < 10)
		month="0"+month;
	if(day < 10)
		day="0"+day;
	sysDate = day+"/"+month+"/"+year;
	document.forms[0].servDate.value = sysDate;
	document.forms[0].currentDate.value = sysDate;
}

function reset(){
	f_query_add_mod.location.href="../../eDS/jsp/DSMealRejectionsQuery.jsp";
}

function getResult(oncall) 
{
	parent.query_criteria.document.getElementById("onCall").value=oncall;
	var servingDate=document.getElementById("servingDate").value;
	var servingDateTo=document.getElementById("servingDateTo").value;
	var Patient_Class=document.getElementById("Patient_Class").value;
	var AcknowledgeStatus=document.getElementById("AcknowledgeStatus").value;	
	var patient_id=document.getElementById("patient_id").value;
	var PatientStatus=document.getElementById("PatientStatus").value;	
	
	//Common-ICN-0080 Starts
	if(AcknowledgeStatus=='Y')
	parent.parent.frames[0].document.forms[0].apply.disabled=true;
	else
	parent.parent.frames[0].document.forms[0].apply.disabled=false;
	//Common-ICN-0080 Ends
	
	var flag="";	
	if(servingDate!="" && servingDateTo!="")
		{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			var params = "func_mode=getDatediff&fromDate="+servingDate+"&toDate="+servingDateTo;
			xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
				if(retVal > 90){
					flag =false;
					alert(getMessage("DS_MEAL_DIFFS_DAYS","DS"));
					//return false;
				}else{
					parent.query_result.location.href="../../eDS/jsp/DSMealRejectionsQueryResult.jsp?oncall="+oncall+"&servingDate="+servingDate+"&servingDateTo="+servingDateTo+"&Patient_Class="+Patient_Class+"&AcknowledgeStatus="+AcknowledgeStatus+"&patient_id="+patient_id+"&PatientStatus="+PatientStatus;				
				}		 
		}else{
			parent.query_result.location.href="../../eDS/jsp/DSMealRejectionsQueryResult.jsp?oncall="+oncall+"&servingDate="+servingDate+"&servingDateTo="+servingDateTo+"&Patient_Class="+Patient_Class+"&AcknowledgeStatus="+AcknowledgeStatus+"&patient_id="+patient_id+"&PatientStatus="+PatientStatus;
		}
}

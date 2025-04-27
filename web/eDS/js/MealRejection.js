// New file MealRejection.js created against ML-MMOH-CRF-0599  
//Lookup of Location::
async function getLocn(loginuser,oper_id,fac_id,objval,target)
{
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	
   locale=document.forms[0].locale.value; 
   tit=getLabel("Common.Location.label",'Common')
 
 if(objval=="N")
   {	 
    
	sql="select nursing_Unit_Code code, short_Desc description from Ip_Nursing_Unit_Lang_Vw   where  eff_Status ='E' and facility_Id='"+fac_id+"' and language_Id ='"+locale+"' and LOCN_TYPE ='"+objval+"' AND UPPER (nursing_unit_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?)";
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("location").value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
        
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");	
		document.forms[0].hdnlocation.value=arr[0]; //Code
		target.value=arr[1]; //Desc
	}
     }	 
 else
    {
	 sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and ";
     sql = sql+"b.oper_stn_id = (SELECT OPER_STN_ID  FROM AM_USER_FOR_OPER_STN A  WHERE FACILITY_ID = b.facility_id AND APPL_USER_ID = b.appl_user_id AND TRUNC (SYSDATE) BETWEEN EFF_DATE_FROM AND NVL (EFF_DATE_TO, TRUNC (SYSDATE))) and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";
	 
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].hdnlocation.value=arr[0]; //Code
		target.value=arr[1]; //Desc
	}
   }
}

async function showLookup(obj){
	var formObj = document.forms[0];
	var locale = formObj.locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.reasonComplaints.Label","ot");
	var sql="select A.COMPLAINT_CODE code,A.long_desc description from DS_COMPLAINTS_LANG_VW A where A.eff_status = 'E' and A.language_id = '"+locale+"' and upper(A.LONG_DESC) like upper(?) and upper(A.COMPLAINT_CODE) like upper(?) order by 2";
    argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.getElementById("reasonDes").value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	var str =unescape(retVal);
	var arr = str.split(",");
		if ((retVal != null) && (retVal != "")) {
		document.getElementById("reasonDes").value = arr[1];
		document.getElementById("reasonCode").value = arr[0];
	} else {
		document.getElementById("reasonDes").value = '';
		document.getElementById("reasonCode").value = '';
	}
}

function run(){
	var flag =checkNull();
	if(!checkTODate())
	return false;
	if(flag==true){
		var formObj=parent.content.f_query_rep.MealRejection;
		var p_module_id = formObj.p_module_id.value;
		var p_facility_id = formObj.p_facility_id.value;
		var p_user_name = formObj.p_user_name.value;
		var p_language_id = formObj.p_language_id.value;
		var facility_id = formObj.facility_id.value;
		var locale = formObj.locale.value;
		var datepattrn = formObj.datepattrn.value;
		var report_id = formObj.report_id.value;
		var fromDate =convertDate(formObj.from.value,"DMY",locale,"en");
		var toDate = convertDate(formObj.to.value,"DMY",locale,"en");
		var p_patient_class = formObj.PatientType.value;
		var p_patient_id = formObj.patientId.value;
		var p_meal_type = formObj.mealType.value;
		var p_diet_type = formObj.dietType.value;
		var p_location_type= formObj.loctype.value;
		var p_location = formObj.hdnlocation.value;
		var p_complaint_code = formObj.reasonCode.value;
		var p_order_by  = formObj.orderBy.value;
		var p_report_id="DSRREGMEAL";
		var p_kitchen_code = formObj.Kitchen.value;
		formObj.action="../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_facility_id="+p_facility_id+"&p_report_id="+p_report_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+"&locale="+locale+"&param1="+fromDate+"&param2="+toDate+"&p_patient_class="+p_patient_class+"&p_patient_id="+p_patient_id+"&p_meal_type="+p_meal_type+"&p_diet_type="+p_diet_type+"&p_location_type="+p_location_type+"&p_location="+p_location+"&p_complaint_code="+p_complaint_code+"&p_order_by="+p_order_by+"&p_kitchen_code="+p_kitchen_code;
		formObj.submit();
	}
}

function reset(){
	var formObj = parent.content.f_query_rep.MealRejection;
	formObj.reset();	
}

function checkTODate(){
	var formObj=parent.content.f_query_rep.MealRejection;
	var fromDate= formObj.from.value;
	var toDate= formObj.to.value;

	var d1Arr = fromDate.split("/");
	var d2Arr = toDate.split("/");
	var errMsg = 'To Date should be Greater than or equal to From Date';
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

function checkForSpecCharsforID(event){
	var strCheck = '0123456789/';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1) return false;
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.MealRejection;
 	var fromDate=formObj.from.value;
 	var from_label=getLabel("Common.from.label","Common");

 	var toDate=formObj.to.value;
 	var to_label=getLabel("Common.to.label","Common");
    	var sysdate=getCurrentDate("DMH",'en');
 	if(fromDate=="") {
 		flag=false;
 		error+= getMessage("DS_FROM_DATE","DS")+"<br>";
 	}
 	if(toDate=="") {
 		flag=false;
 		error+= getMessage("DS_TO_DATE","DS")+"<br>";
 	}
	
   if(fromDate > sysdate){
	   flag=false;
	   alert(getMessage("DS_MEAL_REJ_DATE","DS"));	  
	}
	
	if(toDate > sysdate){
	  flag=false;
	  alert(getMessage("DS_MEAL_REJ_TO_DATE","DS"));	
	}
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getDatediff&fromDate="+fromDate+"&toDate="+toDate;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal > 31){
			flag =false;
			alert(getMessage("DS_MEAL_DIFF_DAYS","DS"));
		}
	 messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	 if(flag==false) return false; else return true;
}
 
async function callSearchScreen(){
	var formObj = document.forms[0];
	var patient_class =formObj.PatientType.value;
	var patientid = await PatientSearch(null,null,null,null,null,null,null,null,null,null,null,patient_class);
	if(patientid !=null)
	document.forms[0].patientId.value = patientid;
	document.forms[0].patientId.focus();
}

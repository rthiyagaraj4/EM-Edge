//Created for ML-MMOH-CRF-0423
var DESC_LINK		= "2"   ;
var DESC_CODE       = "DESC_CODE" ;
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
			parent.query_result.location.href="../../eDS/jsp/DietOrderStatusQueryResult.jsp?patient_Class="+patient_Class+"&ward_Clinic_code="+ward_Clinic_code+"&ward_Clinic_Desc="+ward_Clinic_Desc+"&serv_Date="+servDate;
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
	var currentTime = new Date()
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
	f_query_add_mod.location.href="../../eDS/jsp/DietOrderStatusQuery.jsp";
}

function searchWardClinicSelect(obj)
{
	var formObj=document.forms[0];
	var patient_class=formObj.Patient_Class.value;
	searchwardclinic(obj);
}

async function searchwardclinic(obj)
{	
	var result = false;
	var formObj = document.forms[0];
	var facility_id = formObj.facility_id.value;
	var locale = formObj.locale.value;
	var patient_class=formObj.Patient_Class.value;
	
	if(patient_class=='IP'|| patient_class=='DC'){
		sql="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND PATIENT_CLASS='"+patient_class+"' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;//Modified against INC_63584
	}else if(patient_class=='EM'|| patient_class=='OP'){
	  //Modified against INC_63584
		sql="SELECT CLINIC_CODE CODE, LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW WHERE  LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";
		if(patient_class=='EM')
		sql +=" AND level_of_care_ind = 'E'";
		else
		sql +=" AND  level_of_care_ind = 'A'";
		sql +=" AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(CLINIC_CODE) LIKE UPPER(?)  ORDER BY 1" ;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+getLabel("eDS.WardClinic.Label","ds")+msgArray[1]);
		 return false;
	}
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(getLabel("eDS.WardClinic.Label","ds"),argumentArray );
	
	if((returnedValues != null) && (returnedValues != "") )  {	
		if(returnedValues.length === 1){
			returnedValues = returnedValues[0].split(',') ;
		}
		formObj.HLongRefWdId.value=returnedValues[0];
		formObj.wardDesc.value=returnedValues[0];
		formObj.wardClinic_code.value=returnedValues[1];	
	} 
	else{
		formObj.HLongRefWdId.value="";
		formObj.wardDesc.value="";
		formObj.wardClinic_code.value="";
	}
}

function callclear()
{
	var formObj = document.forms[0];
	formObj.HLongRefWdId.value="";
	formObj.wardDesc.value="";
	formObj.wardClinic_code.value="";
}

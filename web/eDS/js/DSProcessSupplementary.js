function apply()
{
	
	//var formObj=parent.parent.frames[2].frames[2].document.forms[0];//orig
	/*
	var formObj2=parent.parent.frames[2].frames[2];
	
	//working fine 
	*/
	var formObj=parent.parent.frames[2].frames[2].document;
	
	
	var Total_Record=formObj.getElementById("Total_Record").value;
	var StartNum=formObj.getElementById("StartNum").value;
	var EndNum=formObj.getElementById("EndNum").value;
	var sno=formObj.getElementById("sno").value;
	var facility_id=formObj.getElementById("facility_id").value;
	var locale=formObj.getElementById("locale").value;
	var serving_date=formObj.getElementById("serving_date").value;
	
	var processMeals={};
	var processMealsarr=[];

	var modifiedflag=false;
	for(var i=StartNum;i<sno;i++){
		if(formObj.getElementById("o_effStatus_"+i).value!=formObj.getElementById("effStatus_"+i).value 
			|| trim(formObj.getElementById("o_oremarks_"+i).value)!=trim(formObj.getElementById("remarks_"+i).value)
		){
			modifiedflag=true;
		
		processMeals={
			"Encounter_id":formObj.getElementById("Encounter_Id_"+i).value,
			"Remark":formObj.getElementById("remarks_"+i).value,
			"Status":formObj.getElementById("effStatus_"+i).value,
			"Sup_ord":formObj.getElementById("sup_order_"+i).value,
			"item_type":formObj.getElementById("item_type_"+i).value,
			"food_item":formObj.getElementById("food_item_"+i).value,
			"meal_type":formObj.getElementById("meal_type_"+i).value,
			"serving_date":serving_date
		};
		processMealsarr.push(processMeals);
		}
		
		
	}
	
	
	if(!modifiedflag){
		
		msg=getMessage("DS_UPD_REC","DS");
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	return;
	}
	
	var jsonArguments	= {
			'processMealsarr':JSON.stringify(processMealsarr),
			'mode':'UPDATE_SUPPLEMENTARY_MEAL_ORDER',
			'locale':locale,
			'facility_id':facility_id
			
		  };

	$.ajax({  
		 url:'../../servlet/eDS.SupplementaryOrderServlet',  
		 type: 'post',  
		 data: jsonArguments,
		 dataType: 'json'
		 
	 });
	var msg=getMessage("DS_OPER_COMPLETE","DS");
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	
	var patient_id=formObj.getElementById("patient_id").value;
	var nursingUnit_code=formObj.getElementById("nursingUnit_code").value;
	var kitchen_code=formObj.getElementById("kitchen_code").value;
	var supplementary_for_Code=formObj.getElementById("supplementary_for_Code").value;
	var StartNum=formObj.getElementById("StartNum").value;
	var EndNum=formObj.getElementById("EndNum").value;
	var GracePeriod=formObj.getElementById("GracePeriod").value;
	var Attendent_Label_Name=formObj.getElementById("Attendent_Label_Name").value;
	var date=formObj.getElementById("date").value;
	
	var param="patient_id="+patient_id;
	param+="&nursingUnit_code="+nursingUnit_code;
	param+="&kitchen_code="+kitchen_code;
	param+="&supplementary_for_Code="+supplementary_for_Code;
	param+="&start_num="+StartNum;
	param+="&end_num="+EndNum;
	param+="&GracePeriod="+GracePeriod;
	param+="&date="+date;
	param+="&Attendent_Label_Name="+Attendent_Label_Name;

	RecordCriteria.location.href="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp?"+param;
	return false;
}


async function callPatientSearch()
{
	var	window_styl='O';
	var close_yn='Y';
	var jsp_name='';
	var win_top= '61';
	var win_height= '34';
	var win_width= '50';
	var act_yn= 'N';
	var register_button_yn = 'N';
	var func_act='';
	var dr_function_id='';
	var srr='Y';
	window_styl = window_styl.toUpperCase();
	close_yn = close_yn.toUpperCase();
	act_yn = act_yn.toUpperCase();

	var url ="";
	url     ="../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&dr_function_id="+dr_function_id;
	var dialogTop   = "6";
	var dialogHeight    = "700px" ; //30.5
	var dialogWidth = "950px" ;
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	var returnval = await top.window.showModalDialog( url, arguments, features ) ;
	$('#patient_id').val(returnval);
}

function getDetails() {
	var formObj = document.SupplBasedHeaderForm;
	var locale = formObj.locale.value;
	var date = trimString(formObj.date.value);
	var patient_id=trimString(formObj.patient_id.value);
	var facility_id = formObj.facility_id.value;
	var nursingUnit_code = trimString(formObj.nursingUnit.value);
	var kitchen_code=trimString(formObj.kitchen.value);
	var supplementary_for_desc=trimString(formObj.supplementaryfor.value);
	var param = "facility_id="+facility_id+"&date_SupplBased="+date+"&nursingUnit_code="+nursingUnit_code+"&kitchen_code="+kitchen_code+"&patient_id="+patient_id+"&supplementary_for_desc="+supplementary_for_desc;
	var error="";
    if(date =="") error=getMessage("DS_DAT_NOT_BLANK","DS") + "<br>";

	if(nursingUnit_code == "" && kitchen_code == "") error= error + getMessage("DS_KITCHEN_NURSING_UNIT","DS")  + "<br>" ;
 
   	if(error != ""){
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
		return false;
	}

	else parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;

	parent.parent.RecordCriteria.location.href = "../../eDS/jsp/DSProcessSupplementaryOrderBased.jsp?"+ param;
}

getResult	=	function(){
	var locale = $("#locale").val();
	var date = $("#servingDate").val();
	var patient_id=$("#patient_id").val();
	var facility_id = $("#facility_id").val();
	var nursingUnit_code = $("#nursing_Unit").val();
	var kitchen_code=$("#kitchen").val();
	if(kitchen_code=="All"){
		kitchen_code="";
	}
	var supplementary_for_Code=$("#supplementaryfor").val();
	var setStatusForAll=$("#setStatusForAll").val();
	var start_num="1";
	var end_num="14";
	var GracePeriod=$("#Grace_Period").val();
	var Attendent_Label_Name=$("#Attendent_Label_Name").val();
	var error="";
	
	if(date =="") error=getMessage("DS_DAT_NOT_BLANK","DS") + "<br>";
	
	if(nursingUnit_code=="" && kitchen_code==""){
		error= error + getMessage("DS_KITCHEN_NURSING_UNIT","DS")  + "<br>" ;
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
		return false;
	}else{	
	error=error+"";
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
	}
	
	
	var params="MODE=SearchResult";
	params+="&locale="+locale;
	params+="&date="+date;
	params+="&patient_id="+patient_id;
	params+="&facility_id="+facility_id;
	params+="&nursingUnit_code="+nursingUnit_code;
	params+="&kitchen_code="+kitchen_code;
	params+="&supplementary_for_Code="+supplementary_for_Code;
	params+="&start_num="+start_num;
	params+="&end_num="+end_num;
	params+="&GracePeriod="+GracePeriod;
	params+="&Attendent_Label_Name="+Attendent_Label_Name;	

	parent.RecordCriteria.location.href="../../eDS/jsp/DSProcessSupplementaryOrderRecord.jsp?"+params;
	
}

function callNoRecord()
{
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
}

function  reset(){

	location.reload();
	
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
function cal_error (str_message,obj)
{
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
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
function NursingUnitForKithcen(obj){
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
	//$("#selectedAll").val("");	
	var listItems = '';
	listItems = '<option selected="selected" value="">-----select-----</option>';
	if(wardList!=null && wardList!="undefined" && wardList!=""){
		
	for (var i = 0; i < wardList.length; i++) {
         listItems += "<option value='" + wardList[i].Ward_Code + "'>" + wardList[i].Ward_Desc + "</option>";
    }
		$("#nursing_Unit").html(listItems);	
	}else{
			$("#nursing_Unit").html(listItems);
		}
}

function updateStatus(val){

		//var formObj=parent.parent.frames[2].frames[2].document;
		var formObj=parent.frames[2].document;
		var Total_Record=formObj.getElementById("Total_Record").value;
		var StartNum=formObj.getElementById("StartNum").value;
		var EndNum=formObj.getElementById("EndNum").value;
		var sno=formObj.getElementById("sno").value;
		var facility_id=formObj.getElementById("facility_id").value;
		var locale=formObj.getElementById("locale").value;
		var serving_date=formObj.getElementById("serving_date").value;

		for(var i=StartNum;i<sno;i++){
			
			//if(formObj.getElementById("o_effStatus_"+i).value==""){
				formObj.getElementById("effStatus_"+i).value=val;
			//}
			}
}
function textAreaLimit(field, maxlen){
if (field.value.length > maxlen + 1){
		var strMsg = getMessage("DS_MAXLEN_CHARS","DS");
		$("#"+field.id).focus();
		$("#"+field.id).select();
		
		var arrMsg = strMsg.split("#");
		alert(arrMsg[0] + maxlen + arrMsg[1]);
		return;
	}
	if (field.value.length > maxlen)
	field.value = field.value.substring(0, maxlen);
}

function localTrimString(sInString) {
	if(sInString != ""){
		return sInString.replace(/[\[\]']+/g,'');
	}
	return "";
}
function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
    return "";
}

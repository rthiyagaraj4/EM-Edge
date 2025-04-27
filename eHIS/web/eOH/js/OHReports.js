function run(){
	var formObj = f_query_rep.document.OHReportOptionsForm;
	var retVal = true;
	
	var retVal = checkMandatory(formObj);
	if(retVal==true) {
		retVal = CompareFields(formObj);
	}
	if(retVal==true &&formObj.p_report_id.value!='OHRDENST')
	{retVal = CompareDateFields(formObj);}
	else if(retVal==true &&formObj.p_report_id.value=='OHRDENST')
	{
       retVal = monthValidation(formObj);
	}

	if(retVal==true){
		f_query_rep.document.OHReportOptionsForm.submit();
		window.returnValue=true;
		window.close();
	}
	
}

//Code added by sathish for month validation

function monthValidation(formObj) {
	//var msg1=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
	var fromdt=formObj.P_FROM_DATE.value;
	var todt=formObj.P_TO_DATE.value;
	//var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
	var msg = getMessage("APP-OH0002","OH");

	var msgArray = msg.split("#");
	var to_date=getLabel("Common.todate.label","Common");
	var from_date =getLabel("Common.fromdate.label","Common");
	var from_month=getLabel("Common.FromMonth.label","Common");
	var to_month=getLabel("Common.ToMonth.label","Common");
	
    var frm_dt= formObj.P_FROM_DATE.value;

	if ( fromdt.value != undefined)
	{
		fromdt = fromdt.value ;
	}
	else
		fromdt = fromdt;
	
	if ( todt.value != undefined)
	{
		todt = todt.value ;
	}
	else
		todt = todt;

    var arr = new Array();
    var arr1 = new Array();
    arr = fromdt.split("/");
    arr1 = todt.split("/");
    if(arr[0].length == 1)
        var fr=arr[1] + '0' + arr[0];
    else
        var fr=arr[1] + arr[0];

    if(arr1[0].length == 1)
        var to=arr1[1] + '0'+arr1[0];
    else
        var to=arr1[1] + arr1[0];

    if(fr <= to)
        return true;
    else {
		alert(msgArray[0]+from_month+(msgArray[1])+to_month+(msgArray[2]));
		return false;
         }
}


function checkMandatory(formObj){
	/*var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");*/

	var msg = getMessage("APP-OH00094","OH");
	var msgArray = msg.split("##");
	var no_of_mandatory_fields = formObj.no_of_mandatory_fields.value;
	if(formObj.no_of_mandatory_fields!=null){		
		for(i=1;i<=no_of_mandatory_fields;i++){
			var field_names = eval("formObj.mandatory_fm_"+i).value;
			var arr=field_names.split("##");
			obj_name  = arr[0];
			obj_text  = arr[1];
			if(eval("formObj."+obj_name).value ==""){
				alert(msgArray[0]+obj_text+" "+msgArray[1]);
				return false;
			}
		}
	}
	return true;
}

function CompareFields(formObj){
	if(formObj.no_of_comparison_fields!=null){
		var no_of_comparison_fields = formObj.no_of_comparison_fields.value;
		var locale=formObj.locale.value;
		for(i=1;i<=no_of_comparison_fields;i++){
			frm_field_text = eval("formObj.compare_fm_"+i).value;
			arr=frm_field_text.split("##");
			obj_text	= arr[1];
			frm_obj_name  = arr[0];
			to_obj_name = eval("formObj.compare_to_"+i).value;
			fromobj = eval("formObj."+frm_obj_name);
			toobj = eval("formObj."+to_obj_name);
			validate_flag = CheckString(obj_text,fromobj,toobj,messageFrame);
			if(validate_flag ==false)
				return false;
		}
	}
	return true;
}

function CompareDateFields(formObj){
	if(formObj.no_of_compare_date_fields!=null){
		var no_of_compare_date_fields = formObj.no_of_compare_date_fields.value;
		var locale = formObj.locale.value;
		for(i=1;i<=no_of_compare_date_fields;i++){
			frm_field_text = eval("formObj.compare_date_fm_"+i).value;
			arr=frm_field_text.split("##");
			obj_text	= arr[1];

			frm_obj_name  = arr[0];
			to_obj_name = eval("formObj.compare_date_to_"+i).value;

			fromobj = eval("formObj."+frm_obj_name).value;
			fromobj = fromobj+" 00:00";
			toobj = eval("formObj."+to_obj_name).value;
			toobj = toobj+ " 00:00";
			validate_flag = compareDates1(fromobj,toobj,locale,'DMYHM');
			if(validate_flag ==false){
				//alert(getMessage("DATE_COMPARE_FROM_TO"));
				//To Date should not be less than from date
				//var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msg = getMessage("APP-OH0002","OH");
				var msgArray = msg.split("#");
				var to_date=getLabel("Common.todate.label","Common");
				var from_date =getLabel("Common.fromdate.label","Common");

				alert(msgArray[0]+from_date+(msgArray[1])+to_date+(msgArray[2]));
				return false;
			}
		}
	}
	return true;
}

function CaseSlipRun(){
	OHReportOptionsForm.submit();
	window.close();
}

function reset(){
	f_query_rep.document.OHReportOptionsForm.reset();
}




/*function searchCode(obj,target, tit, sql){
	var facility_id=document.forms[0].facility_id.value;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;


	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		obj.value=arr[0];
		target.value=arr[1];
		//target.disabled=true;
	}
	else{
		target.value="";
		obj.value="";
	}
}
*/
function assignGroupBy(obj){
	//alert(obj.name);
	var formObj = f_query_rep.document.OHReportOptionsForm;
	formObj.p_report_id = obj.value;
	formObj.pgm_id		= obj.value;
}
function getTimes(obj){
	var formObj = document.OHReportOptionsForm;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var url="ReportsGetTimeRanges.jsp?time_range_code="+obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	retVal=xmlHttp.responseText;
	//alert(retVal);
	if(retVal!="undefined"){
		var times_arr  = retVal.split("::");	
		// NOTE: times_arr[0] is blank
		for(i=1;i<=10;i++)
			eval("formObj.time"+i).value = times_arr[i];
	}
}

/*
function searchFromOperRoom(obj)
	{
	
	//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var formObj = document.forms[0];
	//formObj.sql_text_3.value;
	
	//var obj1=document.forms[0];
	//sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?)  order by 1" ;

	//var sql= "SELECT SHORT_NAME DESCRIPTION,PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+obj1.facility_id.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	argumentArray[0] = formObj.sql_text_3.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup("From Operation Room", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		formObj.from_oper_room_desc.value=returnedValues[1];
		formObj.param8.value=returnedValues[0];
			//obj.value = returnedValues[1];
	} 
}
function searchToOperRoom(obj)
	{
	
	//alert("enter");
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
var flg="";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var formObj = document.forms[0];
	//formObj.sql_text_3.value;
	
	//var obj1=document.forms[0];
	//sql="SELECT SHORT_DESC DESCRIPTION, OPER_CODE CODE FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E'AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?)  order by 1" ;

	//var sql= "SELECT SHORT_NAME DESCRIPTION,PHYSICIAN_ID CODE FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+obj1.facility_id.value+"' AND PRACT_TYPE IN ('MD','SG') AND NVL(STATUS,'X') <> 'S' AND upper(SHORT_NAME) like upper(?) AND upper(PHYSICIAN_ID) like upper(?) order by 2";

	argumentArray[0] = formObj.sql_text_3.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = CommonLookup("To Operation Room", argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		formObj.to_oper_room_desc.value=returnedValues[1];
		formObj.param9.value=returnedValues[0];
	} 
}

*/
function searchCode(obj,target, tit, sql){
	var facility_id=document.forms[0].facility_id.value;
	//alert(sql);
	
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified by rajesh forlookup issues
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	//alert("enter");
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		//alert("enter"+returnedValues);
		target.value=returnedValues[1];
		obj.value=returnedValues[0];
	} else{
		target.value='';
		obj.value='';
	}
}


function searchSurgeon(obj,target, totarget, tit, sql){

	var facility_id=document.forms[0].facility_id.value;
	//alert(sql);
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	//argumentArray[4] = "1,2"; Modified By Rajesh for Lookup Issue
    argumentArray[4] = "2,1"; 
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	//alert("enter");
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		//alert("enter"+returnedValues);
		target.value=returnedValues[1];
		obj.value=returnedValues[0];
		totarget.value=returnedValues[0];
	}else{
	target.value='';
		obj.value='';
	}
}

function srchCommonCode(obj,target, totarget, tit, sql){
	
	var facility_id=document.forms[0].facility_id.value;
//	var tit = obj.title;
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified By Rajesh for LOokup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value=returnedValues[1];
		obj.value=returnedValues[0];
		totarget.value=returnedValues[0];
	}else{
		target.value='';
		obj.value='';
	}
	
}

// Modified by rajesh for common lookup search for speciality/anaesthetist/surgeon/ward/oper_room

function callCommonLookup(obj){
	var formObj = document.forms[0];
	var tit = obj.title;
	var key = obj.key;
	var param1 = obj.param1;
	var param2 = obj.param2;
	var target = eval("formObj."+param1);
	var totarget = eval("formObj."+param2);
	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = getSqlString(key);
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified By Rajesh for LOokup Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE ;
	
	returnedValues = CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		target.value=returnedValues[0];
		obj.value=returnedValues[1];
		totarget.value=returnedValues[0];
		
	}else{
		target.value='';
		obj.value='';
		totarget.value='';
	}
	
}

function callSurgeryType() {
var surgerytype=document.forms[0].param12.value;
if(surgerytype!=null || surgerytype!=""){
document.forms[0].param19.value=surgerytype;
}
}

function check_all_date_dmy(){
	var formObj = f_query_rep.document.OHReportOptionsForm;
	var locale = formObj.locale.value;
	var obj=formObj.P_PERIODICITY;
	var objFromYr=formObj.P_FROM_YEAR;
	var objToYr=formObj.P_TO_YEAR;
	var objFrom=formObj.P_FROM;
	var objTo=formObj.P_TO;
	var objFDate=formObj.param1;
	var objTDate=formObj.param2;
	var cur_date = getSysDate();
	var date_arr = cur_date.split("/");
	var yer = date_arr[2];
	var mseg = "";
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");		
	var all_msg = "";
/*	if (obj.value==""||obj.value==null){
		all_msg = msgArray[0]+getLabel("eOT.ReportPeriodicity.Label","OT")+msgArray[1]+"<BR>";
		//alert('Report Periodicity cannot be null');
	}*/

	if ((obj.value=='Q') ||(obj.value=='M')||(obj.value=='B')){
		if (objFrom.value==""||objFrom.value==null||objTo.value==""||objTo.value==null)  {
			//mseg ="APP-000001 Period From/To cannot be null";
			if(objFrom.value==""||objFrom.value==null)
				all_msg = all_msg+msgArray[0]+getLabel("Common.periodfrom.label","Common")+msgArray[1]+"<BR>";
			if(objTo.value==""||objTo.value==null)
				all_msg = all_msg+msgArray[0]+getLabel("Common.periodto.label","Common")+msgArray[1]+"<BR>";
		}
	}

	if (obj.value=='A' || obj.value=='Q' || obj.value=='M' || obj.value=='B'){
		if (objFromYr.value==""||objFromYr.value==null||objToYr.value==""||objToYr.value==null){
			//mseg ="APP-000001 Year Field cannot be null";
			all_msg = all_msg+all_msg+msgArray[0]+getLabel("Common.year.label","Common")+msgArray[1]+"<BR>";			
		}

	   if (objFromYr.value!=objToYr.value){
			  //mseg ="APP-000001 From Year and To Year should be the same";
			  all_msg=all_msg+getMessage("APP-OT0119","OT")+"<BR>";
	   }

	   if (objFromYr.value > yer || objToYr.value > yer ){
			//mseg ="APP-000001 From Year and To Year cannot be greater than current year";
			if (objFromYr.value > yer)
			  all_msg=all_msg+getMessage("APP-OT0120","OT")+"<BR>";
			if (objToYr.value > yer)
			  all_msg=all_msg+getMessage("APP-OT0121","OT")+"<BR>";
	   }

		/* commented by Bhavani.As != validation mentioned above will take care. APP-OT0119
	   if (objFromYr.value > objToYr.value)
	   {
			  mseg ="APP-000001 From Year cannot be greater than To Year";
			  window.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+mseg;
		  //alert('From Year cannot be greater than To Year');
		  return false;
	   }
	   */
	}

if (obj.value=='D'){
	if (objFDate.value==""||objFDate.value==null||objTDate.value==""||objTDate.value==null){
		//mseg ="APP-000001 From/To Operation Date Field cannot be null";
		if (objFDate.value=="" || objFDate.value==null)
			all_msg = all_msg+msgArray[0]+getLabel("Common.fromdate.label","Common")+msgArray[1]+"<BR>";

		if (objTDate.value=="" || objTDate.value==null)
			all_msg = all_msg+msgArray[0]+getLabel("Common.todate.label","Common")+msgArray[1]+"<BR>";
	}

        var returnVal2 = compareDates1(objFDate.value,cur_date);
		var date_msg_array = (getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT")).split("#");
		if(returnVal2==false){
			//mseg = "APP-000001 From/To Date should not be greater than current date";
			all_msg = all_msg + date_msg_array[0] +getLabel("Common.fromdate.label","Common")+date_msg_array[1]+getLabel("Common.CurrentDate.label","Common")+date_msg_array[2]+"<BR>";
		}

		returnVal2 ="";
        returnVal2 = compareDates1(objTDate.value,cur_date);
		if(returnVal2==false){
			all_msg = all_msg + date_msg_array[0] +getLabel("Common.todate.label","Common")+date_msg_array[1]+getLabel("Common.CurrentDate.label","Common")+date_msg_array[2]+"<BR>";
		}
		returnVal2 ="";
        returnVal2 = compareDates1(objFDate.value,objTDate.value);
		if(returnVal2==false){
			all_msg = all_msg + date_msg_array[0] +getLabel("Common.fromdate.label","Common")+date_msg_array[1]+getLabel("Common.todate.label","Common")+date_msg_array[2]+"<BR>";
		}
}
	if(all_msg.length>0){
		  window.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+all_msg;
		  return false;
	}
}

function getSysDate(){
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var temp_jsp="ChkInOutRecoveryValidation.jsp?func_mode=getSysDate";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;
		return trimString(responseText);
}

function compareDates1(fromdate,todate) {
	var fromarray; var toarray;
    if(fromdate.length > 0 && todate.length > 0 ) {
			var from_date_array = fromdate.split(" ");
			var from_date = from_date_array[0];
			var from_time = from_date_array[1];

			var to_date_array = todate.split(" ");
			var to_date = to_date_array[0];
			var to_time = to_date_array[1];

            var fromdatearray = from_date.split("/");
            var todatearray = to_date.split("/");

			var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0]);
            var todt = new Date(todatearray[2],todatearray[1],todatearray[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi

			if(Date.parse(fromdt) > Date.parse(todt)) {
                return false;
            }
    }
	return true;
}

function checkDateNotGraterThanSysDate(obj){
   var locale=document.forms[0].locale.value;
	var entered_date = convertDate(obj.value,'DMY',locale,"en");
	var sys_date = new Date();
	var month = sys_date.getMonth();
	var year = sys_date.getFullYear();
	var date = sys_date.getDate();
	if(entered_date != ""){
		if(entered_date.indexOf("/") != -1){
			var enteredDateArray = entered_date.split("/");
			if(enteredDateArray[0].length == 2 && enteredDateArray[1].length == 2 && enteredDateArray[2].length == 4){
				var enteredDateObject = new Date(enteredDateArray[2],(enteredDateArray[1]-1),enteredDateArray[0]);
				var sysDateObject = new Date(year,month,date);
				if(Date.parse(sysDateObject) > Date.parse(enteredDateObject)){
					return true;
				}
				else if(Date.parse(sysDateObject) < Date.parse(enteredDateObject)) {
					alert(getMessage("DATE_NOT_GREATER_SYSDATE",'Common'));
					obj.focus();
					obj.select();
					return false;
				}
			}
			else{
				alert(getMessage("INVALID_DATE_FMT",'SM'));
				obj.focus();
				obj.select();
				return false;
			}
		}
		else{
			alert(getMessage("INVALID_DATE_FMT",'SM'));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true;
}

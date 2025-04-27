/*function isValidDate(obj){
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
}*/

function isValidDateTime(obj){
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

function getSysDate(){
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1
	var day = currentTime.getDate()
	var year = currentTime.getFullYear()
	if(month < 10)
		month="0"+month;
	if(day < 10)
		day="0"+day;
	
	var hours = currentTime.getHours();
	var min = currentTime.getMinutes();
	var currentDate = day+"/"+month+"/"+year+" "+hours+":"+min;
	return currentDate;
}

function reset(){
	//alert( "reset called");
	var currentDate = getSysDate();
	var frm=label_query.document.forms[0];
	
	label_query.document.getElementById("authorizedFromDateTime").value = currentDate;
	label_query.document.getElementById("authorizedToDateTime").value = currentDate;
	label_query.document.getElementById("nursingUnit").value = "";
	label_query.document.getElementById("patientId").value = "";
	frm.reset();
	//alert( "reset end");
}

function getResult(){
	////("getResult called")
	var authorizedFromDateTime = parent.label_query.document.getElementById("authorizedFromDateTime").value;
	var authorizedToDateTime = parent.label_query.document.getElementById("authorizedToDateTime").value;
	var nursingUnit = parent.label_query.document.getElementById("nursingUnit").value;
	var patientId = parent.label_query.document.getElementById("patientId").value;

	if( authorizedFromDateTime.length<1 || authorizedToDateTime.length<1){
		alert(getMessage("DS_AUTHORIZED_DATE_NOT_BLANK","DS"));
		return false;
	}
		if(isBefore(authorizedFromDateTime,authorizedToDateTime,"DMYHM",'en')) {
			parent.label_result.location.href="../../eDS/jsp/LabelStickerForFormulaResult.jsp?authorizedFromDateTime="+authorizedFromDateTime+"&authorizedToDateTime="+authorizedToDateTime+"&nursingUnit="+nursingUnit+"&patientId="+patientId;
		} else { 
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));			
			document.forms[0].startdate1.focus();
			document.forms[0].search.disabled=false;
			parent.messageFrame.document.location.href='../../eCommon/html/blank.html' ;  
	}
}

function PatSearch(){
	var patientid=PatientSearch('','','','','','','','','','VIEW');
	parent.label_query.document.getElementById("patientId").value = unescape(patientid);
	if( parent.label_query.document.getElementById("patientId").value == 'undefined')
	parent.label_query.document.getElementById("patientId").value = '';
	parent.label_query.document.getElementById("patientId").focus();
}

function ViewLabel()
{
	var authorizedFromDateTime = parent.label_query.document.getElementById("authorizedFromDateTime").value;
	var authorizedToDateTime = parent.label_query.document.getElementById("authorizedToDateTime").value;
	var facility_id = parent.label_query.document.getElementById("facility_id").value;
	var module_id = parent.label_query.document.getElementById("module_id").value;
	var user_name = parent.label_query.document.getElementById("user_name").value;
	var report_id = parent.label_query.document.getElementById("view_report_id").value;
	var locale = parent.label_query.document.getElementById("locale").value;
	var OrderID = parent.label_query.document.getElementById("OrderID_param").value;
	//OrderID = OrderID.slice(1);
	var duplicateArray = new Array();
	duplicateArray = OrderID.split(',');
	OrderID = removeDuplicates(duplicateArray);
	OrderID=duplicateArray;
	var frm=parent.label_query.document.LabelFormulaQuery;
	frm.action= "../../eCommon/jsp/report_options.jsp?p_module_id="+module_id+"&p_report_id="+report_id+"&p_facility_id="+facility_id+"&p_user_name="+user_name+"&p_locale="+locale+"&P_OrderID="+OrderID;
	parent.label_query.document.LabelFormulaQuery.submit();
		
} 


function PrintLabel() {
	var message = parent.label_query.document.getElementById("message").value;
	if(message!=null && trimString(message)!=""){
		alert(getMessage("PRINT_ROUTING_NOT_DEFINED","Common"));
		return false;
	}
	
	var authorizedFromDateTime = parent.label_query.document.getElementById("authorizedFromDateTime").value;
	var authorizedToDateTime = parent.label_query.document.getElementById("authorizedToDateTime").value;
	var facility_id = parent.label_query.document.getElementById("facility_id").value;
	var module_id = parent.label_query.document.getElementById("module_id").value;
	var user_name = parent.label_query.document.getElementById("user_name").value;
	var print_report_id = parent.label_query.document.getElementById("print_report_id").value;
	var report_id = parent.label_query.document.getElementById("report_id").value;
	var locale = parent.label_query.document.getElementById("locale").value;
	var OrderID = parent.label_query.document.getElementById("OrderID_param").value;
	var reportServer = parent.label_query.document.getElementById("reportServer").value;
	var server = parent.label_query.document.getElementById("server").value;
	var userid = parent.label_query.document.getElementById("userid").value;
	var desname = parent.label_query.document.getElementById("desname").value;	

	var duplicateArray = new Array();
	duplicateArray = OrderID.split(',');
	OrderID = removeDuplicates(duplicateArray);
	OrderID=duplicateArray;
	var url = reportServer+"?report="+report_id+"+server="+server+"+desformat=printer+destype=printer+desname="+ desname+"+recursive_load=no+copies=1+background=yes+userid="+userid+"+SELF_SUBMIT=YES+REPORT_OPTION=P+P_OrderID="+OrderID+"+P_LANGUAGE_ID=" + locale+"+P_FACILITY_ID="+facility_id+"+P_REPORT_ID="+print_report_id;
	
		if (url != null && OrderID != null) {
			window.open(url, "mywindow", "menubar=1").focus();
		} else if(OrderID == null || OrderID ==""){
			alert("Please select atleast one Patient Details");
		}
	
}

function removeDuplicates(num) {
	var x, len = num.length, out = [], obj = {};

	for (x = 0; x < len; x++) {
		obj[num[x]] = 0;
	}
	for (x in obj) {
		out.push(x);
	}
	return out;
}

function next(){
	var authorizedFromDateTime = parent.label_query.document.getElementById("authorizedFromDateTime").value;
	var authorizedToDateTime = parent.label_query.document.getElementById("authorizedToDateTime").value;
	var nursingUnit = parent.label_query.document.getElementById("nursingUnit").value;
	var patientId = parent.label_query.document.getElementById("patientId").value;
	var start = parent.label_result.document.getElementById("start").value;
	var end = parent.label_result.document.getElementById("end").value;
	var records_to_show = parent.label_result.document.getElementById("records_to_show").value;
	
	var text = "selection made will not be available please print or view the label.";

  if (confirm(text) == true) {
    parent.label_query.document.getElementById("OrderID_param").value = "";
	
	var View_label = parent.label_query.document.getElementById("View_label");
	var Print_label = parent.label_query.document.getElementById("Print_label");
	$(View_label).prop('disabled', true);
	$(Print_label).prop('disabled', true);
	
	
	var URL ="../../eDS/jsp/LabelStickerForFormulaResult.jsp?";
	var param ="from="+(parseInt(start)+parseInt(records_to_show))+"&to="+(parseInt(end)+parseInt(records_to_show))+"&authorizedFromDateTime="+authorizedFromDateTime+"&authorizedToDateTime="+authorizedToDateTime+"&nursingUnit="+nursingUnit+"&patientId="+patientId;
	document.location.href=URL+param;
  }
}

function previous(){
	var authorizedFromDateTime = parent.label_query.document.getElementById("authorizedFromDateTime").value;
	var authorizedToDateTime = parent.label_query.document.getElementById("authorizedToDateTime").value;
	var nursingUnit = parent.label_query.document.getElementById("nursingUnit").value;
	var patientId = parent.label_query.document.getElementById("patientId").value;
	var start = parent.label_result.document.getElementById("start").value;
	var end = parent.label_result.document.getElementById("end").value;
	var records_to_show = parent.label_result.document.getElementById("records_to_show").value;
	
	var text = "selection made will not be available please print or view the label.";
		
  if (confirm(text) == true) {
    parent.label_query.document.getElementById("OrderID_param").value = "";
	
	var View_label = parent.label_query.document.getElementById("View_label");
	var Print_label = parent.label_query.document.getElementById("Print_label");
	$(View_label).prop('disabled', true);
	$(Print_label).prop('disabled', true);
	
	var URL ="../../eDS/jsp/LabelStickerForFormulaResult.jsp?";
	var param ="from="+(parseInt(start)-parseInt(records_to_show))+"&to="+(parseInt(end)-parseInt(records_to_show))+"&authorizedFromDateTime="+authorizedFromDateTime+"&authorizedToDateTime="+authorizedToDateTime+"&nursingUnit="+nursingUnit+"&PatientId="+patientId;
	document.location.href=URL+param;
  }
}

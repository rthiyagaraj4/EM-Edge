
function run(){

	var flag =checkNull();
		if(flag==true){
			chkTime();

		}

}
function Report()
{
var formObj=parent.content.f_query_rep.SpecialFoodRequire;
			var p_module_id = formObj.p_module_id.value;
			var p_report_id = "";
			var p_facility_id = formObj.p_facility_id.value;
			var p_user_name = formObj.p_user_name.value;
			var p_language_id = formObj.p_language_id.value;
			var facility_id = formObj.facility_id.value;
			var locale = formObj.locale.value;
			var datepattrn = formObj.datepattrn.value;
			var report_id = formObj.report_id.value;

			var servingDate = convertDate(formObj.servingDate.value,"DMY",locale,"en");
			var frequencyYn = (formObj.frequencyYn.checked)?"Y":"N";
            var kitchen = formObj.Kitchen.value;
			var servTimeFrom=formObj.servTimeFrom.value;
			var servTimeTo=formObj.servTimeTo.value;
			var wardCodeFrom=formObj.wardCodeFrom.value;
			var wardCodeTo=formObj.wardCodeTo.value;
			var patientId=formObj.patientId.value;
			var rpttype=formObj.rpttype.value;
			if(rpttype=="D")
			{
			p_report_id="DSRSPLFD";
			}else if(rpttype=="K"){
			p_report_id="DSRSPKSU";
			}else if(rpttype=="W"){
			p_report_id="DSRSPWSU";
			}

			formObj.action="../../eCommon/jsp/report_options.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_user_name="+p_user_name+"&facility_id="+facility_id+"&locale="+locale+"&PARAM1="+servingDate+"&p_kitchen_code="+kitchen+"&P_FR_TIME="+servTimeFrom+"&P_TO_TIME="+servTimeTo+"&P_WARD_CODE_FROM="+wardCodeFrom+"&P_WARD_CODE_TO="+wardCodeTo+"&P_PATIENT_ID="+patientId+"&rpttype="+rpttype+"&P_FREQ_YN="+frequencyYn;
			formObj.submit();
			}

function chkTime(){
var formObj=parent.content.f_query_rep.SpecialFoodRequire;
var servTimeFrom= formObj.servTimeFrom.value;
var servTimeTo=formObj.servTimeTo.value;

		if(servTimeFrom != "" && servTimeTo){
		    var startarray=servTimeFrom.split(":");
		    var endarray=servTimeTo.split(":");
			var starttm=new Date(1,1,1,startarray[0],startarray[1],0,0);
			var endtm=new Date(1,1,1,endarray[0],endarray[1],0,0);
			if(Date.parse(starttm) > Date.parse(endtm))
			{
			var flag;
			var err_ch =getMessage("FM_TIME_GR_TO_TIME","Common") ;
			alert(err_ch);
			flag=false;
			}else{
				var error="";
				messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
				Report();
				}

		}
		else{
			Report();
		}
	}

function reset() {
	  var formObj = parent.content.f_query_rep.SpecialFoodRequire;
	  formObj.reset();
	 //location.reload();
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

function checkNull(){
	var flag;
 	var error="";
 	var formObj = parent.content.f_query_rep.SpecialFoodRequire;

 	var kitchen=formObj.Kitchen.value;
 	var kitchen_label=getLabel("eOT.Kitchen.Label","OT");

 	var fromDate=formObj.servingDate.value;
 	var from_label=getLabel("eOT.ServingDate.Label","OT");

 	if(fromDate=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",from_label)+"<br>";
 	}

 	if(kitchen=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",kitchen_label)+"<br>";
 	}
	messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
 }

async function callSearchScreen()
{
	var patientid = await PatientSearch('','','','','','','Y','','','VIEW');
	if(patientid !=null)
	document.forms[0].patientId.value = patientid;
	document.forms[0].patientId.focus();
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
		convertDate(sysDate,'en',locale,"dd/MM/yyyy",callBackSysDate);
		function callBackSysDate(sDate){
			document.getElementById("servingDate").value=sDate;

		}
	}
function startClock() {
	var date = new Date();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	if(hours<10){
	hours="0"+hours;
	}
	if (minutes<10){
		minutes="0"+minutes;
	}
	document.getElementById("servTimeFrom").value = hours+":"+minutes;
	getSysDate();
}

function checkTime(mode){
	if(mode=='fromTime'){
		vaidateFromTime();
	}else if(mode=='toTime'){
		validateToTime();
	}
}
function vaidateFromTime(){
	var time1=document.getElementById("servTimeFrom").value;
	var timeLenght1=time1.length;
	if(timeLenght1==0){
		getNumericFilterUpto2();
	}
	if(timeLenght1==1){
		if(time1.charAt(0)==0 || time1.charAt(0)==1 || time1.charAt(0)==2){
			if(time1.charAt(0)==0 || time1.charAt(0)==1){
				getNumericFilterUpto9();
			}
		if(time1.charAt(0)==2){
			getNumericFilterUpto3();
			}
		}
	}
		if(timeLenght1==3){
			if(time1.charAt(4)<=5){
			getNumericFilterUpto5();
			}
		}
		if(timeLenght1==4){
			if(time1.charAt(4)<=9){
			getNumericFilterUpto9();
			}
		}
		if(timeLenght1==2){
			var limiter = time1.charAt(2);
			if(limiter!=":"){
			getDelimiter();
			}
		}
	}


function validateToTime(){
	var time2=document.getElementById("servTimeTo").value;
	var timeLenght2=time2.length;
	if(timeLenght2==0){
		getNumericFilterUpto2();
	}
	if(timeLenght2==1){
		if(time2.charAt(0)==0 || time2.charAt(0)==1 || time2.charAt(0)==2){
			if(time2.charAt(0)==0 || time2.charAt(0)==1){
				getNumericFilterUpto9();
			}
		if(time2.charAt(0)==2){
			getNumericFilterUpto3();
			}
		}
	}
		if(timeLenght2==3){
			if(time2.charAt(4)<=5){
			getNumericFilterUpto5();
			}
		}
		if(timeLenght2==4){
			if(time2.charAt(4)<=9){
			getNumericFilterUpto9();
			}
		}
		if(timeLenght2==2){
			var limiter = time2.charAt(2);
			if(limiter!=":"){
			getDelimiter();
			}
		}
	}

function getNumericFilterUpto9(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-9]+$/;
		if (!(numericFilter.test(obj))){
			getMinutesMessage();
		}else {
			getClearMessage();
		}
	}

function getNumericFilterUpto5(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-5]+$/;
		if (!(numericFilter.test(obj))){
			getMinutesMessage();
		}else{
		getClearMessage();
		}
	}

function getNumericFilterUpto3(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-3]+$/;
		if (!(numericFilter.test(obj))){
			getHoursMessage();
		}else {
			getClearMessage();
		}
	}
function getNumericFilterUpto2(){
		obj =  String.fromCharCode(window.event.keyCode);
		var numericFilter =/^[0-2]+$/;
		if (!(numericFilter.test(obj))){
		getHoursMessage();
		}else{
		getClearMessage();
		}
	}

function getDelimiter(){
			var obj =  String.fromCharCode(window.event.keyCode);
			var checkDelimiter =/^[:]+$/;
			if (!(checkDelimiter.test(obj))){
				getDelimiterMessage();
			}else{
				getClearMessage();
			}

	}

function getHoursMessage(){
var error="";
var servingTime=getLabel("eOT.servingTime.Label","OT");
error+= getMessage("APP-NF0008","ot").replace("$",servingTime)+"<br>";
 window.event.keyCode = 27;
	}

function getMinutesMessage(){
	  var error="";
      var servingTime=getLabel("eOT.servingTime.Label","OT");
      error+= getMessage("APP-OT0041","ot").replace("$",servingTime)+"<br>";
      window.event.keyCode = 27;
	}

function getClearMessage(){
        var error="";
		parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	}

function getDelimiterMessage(){
      var error="";
      var servingTime=getLabel("eOT.servingTime.Label","OT");
      error+= getMessage("APP-OT0130","ot").replace("$",servingTime)+"<br>";
      window.event.keyCode = 27;
	}


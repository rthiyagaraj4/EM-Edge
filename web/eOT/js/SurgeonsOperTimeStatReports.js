/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function addAll(selobj,arr)    {
	var arrval = '';
	var arrtxt = '';
	var arrtot ='';
	var arrSplit = new Array();
	for (i=0; i<arr.length;i++){
		var element = document.createElement('OPTION'); 
		arrtot = arr[i];
		arrSplit = arrtot.split('-');
		arrval =  arrSplit[0];	
		arrtxt =  arrSplit[1];
		element.text = arrtxt;
		element.value= arrval;
		selobj.add(element);      
	}
}

function removeAll(selobj){
	var len = selobj.length;
	for (var i=len;i>-1;i--){
		selobj.remove(i); 
	}
	var element = document.createElement('OPTION'); 
	element.text =getLabel("Common.defaultSelect.label","common");
	element.value= '';
	selobj.add(element);      
}

function funPeriodicity(){
	var formObj = document.forms[0];
	var obj		= formObj.P_PERIODICITY;
	var objFrom	= formObj.P_FROM;
	var objTo	= formObj.P_TO;
	var locale	= formObj.locale.value;
	var arr = new Array();

	 if(obj.value=='D'){
		formObj.P_FROM_YEAR.value="";
		formObj.P_TO_YEAR.value="";
		formObj.P_FROM.value=getLabel("Common.defaultSelect.label","common");
		formObj.P_TO.value=getLabel("Common.defaultSelect.label","common");   
		formObj.P_FROM.disabled=true;
		formObj.P_TO.disabled=true;
		formObj.P_FROM_YEAR.disabled=true;
		formObj.P_TO_YEAR.disabled=true;
		formObj.param1.disabled=false;
		formObj.param2.disabled=false;
		formObj.param1.value=formObj.p_date.value;
		formObj.param2.value=formObj.p_date.value;
		formObj.img1.src='../../eCommon/images/CommonCalendar.gif';
		formObj.img2.src='../../eCommon/images/CommonCalendar.gif';
		formObj.f_mand.src='../../eCommon/images/mandatory.gif';
		formObj.t_mand.src='../../eCommon/images/mandatory.gif';
/*		arr = new Array("1-JAN","2-FEB","3-MAR","4-APR","5-MAY","6-JUN","7-JUL","8-AUG","9-SEP","10-OCT","11-NOV","12-DEC");
		removeAll(objFrom);
		removeAll(objTo);
		addAll(objFrom,arr);
		addAll(objTo,arr);
	   
	   arr = new Array("1-1","2-2","3-3","4-4","5-5","6-6","7-7","8-8","9-9","10-10","11-11","12-12","13-13","14-14","15-15","16-16","17-17","18-18","19-19","20-20","21-21","22-22","23-23","24-24","25-25","26-26","27-27","28-28","29-29","30-30","31-31");
		document.getElementById("hide").style.visibility='visible'	

		addAll(objFromDate,arr);
		addAll(objToDate,arr);
*/	   
	
	}else{
		formObj.P_FROM_YEAR.value=formObj.year.value;
		formObj.P_TO_YEAR.value=formObj.year.value;
		formObj.P_FROM_YEAR.disabled=false;
		formObj.P_TO_YEAR.disabled=false;
		formObj.param1.disabled=true;
		formObj.param2.disabled=true;
		formObj.param1.value="";
		formObj.param2.value="";
		formObj.img1.src='../../eCommon/images/Blank1.gif';
		formObj.img2.src='../../eCommon/images/Blank1.gif';
		formObj.f_mand.src='../../eCommon/images/Blank1.gif';
		formObj.t_mand.src='../../eCommon/images/Blank1.gif';
	   //document.getElementById("img1").onClick=dummy('param1');
	   //document.getElementById("img2").onClick=dummy('param2');
	}
	if(obj.value=='A')
	{
		removeAll(objFrom);
		removeAll(objTo);
		document.getElementById("hide").style.visibility='hidden';
		document.getElementById("periodto_list_hide").style.visibility='hidden'	;
		formObj.P_FROM.disabled=true;
		formObj.P_TO.disabled=true;

	}
	if(obj.value=='B')
	{
		var fhalf="F-"+getLabel("eOT.FirstHalf.Label","OT");
		var shalf="S-"+getLabel("eOT.SecondHalf.Label","OT");
		arr = new Array(fhalf,shalf);
		formObj.P_FROM.disabled=false;
	   formObj.P_TO.disabled=false;
		document.getElementById("hide").style.visibility='visible'	;
		document.getElementById("periodto_list_hide").style.visibility='visible'	;		
		removeAll(objFrom);
		removeAll(objTo);
		addAll(objFrom,arr);
		addAll(objTo,arr);
	
	}
	if(obj.value=='Q')
	{
		formObj.P_FROM.disabled=false;
	   formObj.P_TO.disabled=false;
		var fquarter="Q1-"+getLabel("eOT.Quarter1.Label","OT");
		var squarter="Q2-"+getLabel("eOT.Quarter2.Label","OT");
		var tquarter="Q3-"+getLabel("eOT.Quarter3.Label","OT");
		var foquarter="Q4-"+getLabel("eOT.Quarter4.Label","OT");
//		arr = new Array("Q1-Quarter 1","Q2-Quarter 2","Q3-Quarter 3","Q4-Quarter 4");
		arr = new Array(fquarter,squarter,tquarter,foquarter);

		document.getElementById("hide").style.visibility='visible'	;
		document.getElementById("periodto_list_hide").style.visibility='visible'	;		
		removeAll(objFrom);
		removeAll(objTo);
		//alert(arr);
		addAll(objFrom,arr);
		addAll(objTo,arr);

	}
	if(obj.value=='M')
	{
		formObj.P_FROM.disabled=false;
	    formObj.P_TO.disabled=false;
		var jan="1-"+getLabel("Common.January.label","Common");
		var feb="2-"+getLabel("Common.February.label","Common");
		var mar="3-"+getLabel("Common.March.label","Common");
		var apr="4-"+getLabel("Common.April.label","Common");
		var may="5-"+getLabel("Common.May.label","Common");
		var jun="6-"+getLabel("Common.June.label","Common");
		var jul="7-"+getLabel("Common.July.label","Common");
		var aug="8-"+getLabel("Common.August.label","Common");
		var sep="9-"+getLabel("Common.September.label","Common");
		var oct="10-"+getLabel("Common.October.label","Common");
		var nov="11-"+getLabel("Common.November.label","Common");
		var dec="12-"+getLabel("Common.December.label","Common");
		document.getElementById("hide").style.visibility='visible'	;
		document.getElementById("periodto_list_hide").style.visibility='visible'	;		
//		arr = new Array("1-JAN","2-FEB","3-MAR","4-APR","5-MAY","6-JUN","7-JUL","8-AUG","9-SEP","10-OCT","11-NOV","12-DEC");
		arr = new Array(jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec);
		removeAll(objFrom);
		removeAll(objTo);
		addAll(objFrom,arr);
		addAll(objTo,arr);
	}
}
function dummy(str){
	return (document.forms[0].P_PERIODICITY.value=="D")?  showCalendar(str):"";
}

function check_from_date(objfo){
	var formObj = document.forms[0];
	var yer = formObj.year.value;
	objFromYear=formObj.P_FROM_YEAR.value;
	if(objFromYear > yer){
		var message=getMessage('INVALID_DATE_FMT','SM');
		//alert('Date From Date is incorrect');
		alert(message);
		//objfo.focus();
		return false;
	}
}


function check_to_date(objfo){
	var formObj = document.forms[0];
	var yer = formObj.year.value;
	objToYear=parseInt(formObj.P_TO_YEAR.value);
	objFromYear=parseInt(formObj.P_FROM_YEAR.value);
	if(objToYear > yer){
		var message=getMessage('INVALID_DATE_FMT','SM');
		//alert('Date From Date is incorrect');
		alert(message);
		//objfo.focus();
		return false;
	}
	if(objFromYear > objToYear ){
		var message=getMessage('INVALID_DATE_FMT','SM');
		//alert('Date From Date is incorrect');
		alert(message);
		//objfo.focus();
		return false;
	}
}


function run(){
	var formObj = f_query_rep.document.OtReportOptionsForm;
	var retVal = checkMandatory(formObj);
	if(retVal==true) {
		retVal = CompareFields(formObj);
	}
	if(retVal==true)
		retVal = CompareDateFields(formObj);
	if(retVal==true){
		f_query_rep.document.OtReportOptionsForm.submit();
		//window.returnValue=true;
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
dialogBody.contentWindow.returnValue = true;
    
const dialogTag = parent.parent.document.getElementById("dialog_tag");    
dialogTag.close();
	}
}

function checkMandatory(formObj){
	var msg = getMessage("CANNOT_BE_BLANK","OT");
	var msgArray = msg.split("&");
	var no_of_mandatory_fields = formObj.no_of_mandatory_fields.value;
	if(formObj.no_of_mandatory_fields!=null){
		
		for(i=1;i<=no_of_mandatory_fields;i++){
			var field_names = eval("formObj.mandatory_fm_"+i).value;
			var arr=field_names.split("##");
			obj_name  = arr[0];
			obj_text  = arr[1];
			//alert("formObj."+obj_name);
			//alert(eval("formObj."+obj_name).value);
			if(eval("formObj."+obj_name).value ==""){
				alert(msgArray[0]+" "+obj_text+" "+msgArray[1]);
				return false;
			}
		}
	}
	return true;
}


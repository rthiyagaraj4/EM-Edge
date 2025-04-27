//Function: Enable the given control if this control type has value :
function enableCtrl(enableField1, enableField2, valField, thisObj)
{
	valField.value = "";
	if(thisObj.value != "")
	{
		document.getElementById(enableField1).disabled = false;
		document.getElementById(enableField2).disabled = false;
	}
	else
	{
		document.getElementById(enableField1).disabled = true; 
		document.getElementById(enableField2).disabled = true; 
	}
}

//Function: TO Restrict the Special Chars::	
function restrictSpecialChars(event){
		//var strCheck = '~!@#$%^&*()+=`{}|[];:_-,?<>"\'';
		var strCheck = '*.~!@#$%^&*()+=`{}|[];:_-,/\\?<>"\'';//61224  - ICN 
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
		return true ;
	}
//058037 starts

//058126 starts
function hasInvalidChars(object,filedname) {
	var val=object.value;
	var textarea=document.getElementById(object.name);	
	var error=" ";	
	var nospecial=/^[^*|\":<>[\]{}`\\()';@&$]+$/;
	var iChars = "!@#$%^&*()+=-[]\\\';/{}|\":<>?";//417
	//var iChars = "!@#$%^&*()+=-[]\';{}|\":<>?";
	var sp_flag=true;
	for (var i = 0; i < val.length; i++) {
    if (iChars.indexOf(val.charAt(i)) != -1) {
		sp_flag=false;
		error="Special characters not allowed in "+filedname;
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
		textarea.select(); 
		textarea.focus(); 
        return sp_flag;
    	}else{
		error="";
		parent.frames.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
}
	return sp_flag;
}
//058037 ends
//058126 ends

//Function: Trim the Spaces::	
function localTrimString(sInString) {
		if(sInString != ""){
			return sInString.replace(/[\[\]']+/g,''); 
		}
		return "";
	}

//Function: Trim the spaces:	
function trim(str) {
	if(str != ""){
		return str.replace(/^\s+|\s+$/g,'');
	}
	return "";
}

//Note: to support indexOf method on IE
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
	var len = this.length >>> 0;

	var from = Number(arguments[1]) || 0;
	from = (from < 0)
		 ? Math.ceil(from)
		 : Math.floor(from);
	if (from < 0)
	  from += len;

	for (; from < len; from++)
	{
	  if (from in this &&
		  this[from] === elt)
		return from;
	}
	return -1;
  };
}

//Note: to support contains method on IE
Array.prototype.contains = function(element) {
	for (i in this) {
	   if (this[i] == element) return true;
   }
   return false;

};

//Function :: Compare with current Date. It returns true if the given date is current or Future Date/ returns false if the given Date is past Date.
function compareWithCurrentDate(sDate) {  
		//Date1:
		
		//var date1 = Date(sDate[2],sDate[1]-1,sDate[0]);
		var date1 = new Date(sDate);
		var date2 = new Date();  
			
		var year1 = date1.getFullYear(); 
		var month1 = date1.getMonth(); 
		
		if(month1 < 10)   month1 = "0" + month1; 
		var day1 = date1.getDate(); 
		if(day1 < 10)   day1 = "0" + day1; 
		var pastDate = "" + year1 + month1 + day1; 

		//Date2:
		
		var year2 = date2.getFullYear();  
		var month2 = date2.getMonth(); 
		 if(month2 < 10)   month2 = "0" + month2;  
		 var day2 = date2.getDate(); 
		 if(day2 < 10)   day2 = "0" + day2; 
		 var currentDate = "" + year2 + month2 + day2;	 
		 
		 if(pastDate < currentDate)   
			return false; 
		 else 
			return true;
	 }
	 
	 
 //Function: Returns false if the given date is not in the Format of 'DD/MM/YYYY'::		 
 //ChkDate method is defined in common.js file
 function isValidDate(Object2){
 	var datefield = Object2;
	if (Object2.value != undefined)
    {
		Object2 = Object2.value;
    }
	else
	{
		Object2 = Object2;
	}


    if (ChkDate(Object2) == false) {
        alert(getMessage("INVALID_DATE_FMT", "SM"));
        if (datefield.value != undefined)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}

function cal_error (str_message,obj) {
		alert (str_message);
		obj.focus();
		obj.select();
		return null;
	}
	
//Function : for checking if it is valid Data and Time:
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


//Function : Compare Date: It ll return true if the date1/fromdate < date2/todate
function compareDate(date1,date2) {
	var flag="";
    if(date1.length > 0 && date2.length > 0 ) {	
			var date1_array = date1.split(" ");
			var date1_temp= date1_array[0];
			var date2_array = date2.split(" ");
			var date2_temp = date2_array[0];
			
	        var date1array = date1_temp.split("/");
            var date2array = date2_temp.split("/");
			var date1dt = new Date(date1array[2],date1array[1],date1array[0]);
            var date2dt = new Date(date2array[2],date2array[1],date2array[0]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
			if(Date.parse(date1dt) > Date.parse(date2dt)) {
                flag=1; 
            }
			else if(Date.parse(date1dt) == Date.parse(date2dt)) {
				flag=0;
			}
			else flag=-1;
			
    } 
	return flag;
}

//Added against MMS-QH-CRF-0079
function checkForNulls(retVal){
	if(retVal != null && retVal.length>0)
		return retVal;
	else
		return '';
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
//Added against MMS-QH-CRF-0079
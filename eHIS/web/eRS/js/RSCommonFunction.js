/*
Different function available :

1.	RsAllowPositiveNumber()				- onKeyPress
2.	RsCheckPositiveNumber(obj)			- onBlur
3.	RsCheckPositiveNumber1(obj)			- onBlur
4.	RsAllowNumber()						- onKeyPress
5.	RsCheckNumber(obj)					- onBlur
6.	RsCheckNumber1(obj)					- onBlur
7.	RsAllowDecimalNumber()
8.	RsAllowDateFormat()					- onKeypress
9.	RsAllowTime()						- onKeyPress
10.	RsCheckTime(obj)					- onBlur
11. allowNonZero(obj)					- on Apply
12.	checkDecimal(obj)
13.	checkDecimal1(obj)
14.	doDateCheckRS(from,to)				- Check Date and give app return 's if(from = to) returns 0 ;
										  if(from > to) returns 1 ; if (from < to) returns -1
15.	doDatetimeCheckAlert(from,to)		- Checks Date and time Passed

16. CheckForSpecCharsWithoutSpaceBlur(obj) - onblur
17. CheckForSpecCharsWithoutSpace(event)   - onkeypress

18. RsIsValidDecimal(obj)  - onblur
*/


//onKeyPress -
function RsAllowPositiveNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}


//onBlur -
function RsCheckPositiveNumber(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;


	if(obj.value == ""){
		return true;
	}


	if(!RsCheckNumber(obj))
		return false;


	if(parseFloat(obj.value) == 0){
			alert(parent.getRsMessage('ONLY_POSITIVE_NUM')); //Here is the Change
			obj.focus();
			return false;
	}


	if(obj != null ){
		if(parseFloat(obj_value) > 0){
			return true;
		}else{
			alert(parent.getRsMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
	}else{
		return true;
	}

/*   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getOrMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }*/
}


 //onBlur -  Plz don't remove the function
function RsCheckPositiveNumber1(obj) {
   var sequence = "123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;



	if(obj.value == ""){
		return true;
	}

	if(!RsCheckNumber1(obj))
		return false;

	if(parseFloat(obj.value) == 0){
			alert(getRsMessage('ONLY_POSITIVE_NUM')); //Here is the Change
			obj.focus();
			return false;
	}

	if(obj != null ){
		if(parseFloat(obj_value) > 0){
			return true;
		}else{
			alert(getRsMessage('ONLY_POSITIVE_NUM')); //Here is the Change
			obj.focus();
			return false;
		}
	}else{
		return true;
	}

/*   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getRsMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }*/
}


//onKeyPress -
function RsAllowNumber() {
   var key = window.event.keyCode;
   if( ! ( ( key>=48 ) && ( key<58 ) ) ) {
       return false;
   }
}


//onBlur -
function RsCheckNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getRsMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }

   return true ;
}

//onBlur -
function RsCheckNumber1(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			alert(getRsMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }

   return true ;
}



function RsAllowDecimalNumber(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 46)) ) {
       return false;
   }

}



function RsAllowDateFormat(){
   var key = window.event.keyCode;
   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
       return false;
   }

}



//onKeyPress -
function RsAllowTime(){
   var key = window.event.keyCode;
   if( ! ((  key>=48 ) && ( key<=58 ) )) {
       return false;
   }

}

//onBlur -
function RsCheckTime(obj) {
   var sequence = "1234567890:";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(parent.getRsMessage('ONLY_POSITIVE_NUM'));
			obj.focus();
			return false;
		}
   }
}


//onBlur -
function RsIsValidDecimal(obj) {

   var sequence = "1234567890.";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {

        if(sequence.indexOf(obj_value.charAt(i))==-1){
			//alert("ONLY_POSITIVE_NUM");
			alert(getRsMessage('INVALID_DECIMAL_NUMBER'));
			obj.focus();
			return false;
		}
   }
}


//on Apply
function allowNonZero(obj){
	var count = 0;
	for(i=0; i<obj.value.length; i++){
		if(obj.value.charAt(i) == "0"){
			count++
		}
	}
	if(count == obj.value.length && count!=0){
	   return false
	}

}


function checkDecimal(obj){

  if(!RsCheckPositiveNumber(obj)){
	  return false;
  }else{
  	    var objVal  = obj.value ;
		if(objVal.indexOf(".") != -1) {
			alert(parent.getRsMessage('DECIMAL_NOT_ALLOWED'));
			obj.focus();
			obj.value = "";
		}
  }
}



function checkDecimal1(obj){ //Don't remove this

  if(!RsCheckPositiveNumber1(obj)){
	  return ;
  }else{
  	    var objVal  = obj.value ;
		if(objVal.indexOf(".") != -1) {
		  	alert(getRsMessage('DECIMAL_NOT_ALLOWED'));
			obj.focus();
			obj.value = "";
		}
  }
}



/**
Check Date and give app return 's
if from = to returns 0
if from > to returns 1
if from < to returns -1
*/
function doDateCheckRS(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  0 ;

   }

} //End of function


//Checks Date and time Passed
function doDatetimeCheckAlert(from,to) {
	var fromarray;
	var toarray;
	var fromDt;
	var fromdate = from;
	var todate = to;
	if(fromdate.length > 0 && todate.length > 0 )
	{
	  	fromDt = fromdate.split(" ");
	  	fromarray = fromDt[0].split("/");

	  	toDt = todate.split(" ");
	  	toarray = toDt[0].split("/");

		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) == Date.parse(fromdt))
		{
			fromTime = fromDt[1];
			toTime   = toDt[1];

			if(toTime < fromTime)
			{
				return true;
			}
		}

		if(Date.parse(todt) < Date.parse(fromdt))
		{
			return true;
		}
		else
		{
			if(Date.parse(todt) >= Date.parse(fromdt))
			return false;
		}

	}
}


//Function to disable all special characters in master codes.
//onKeypress
function CheckForSpecCharsWithoutSpace(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
//	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
//		return (event.keyCode -= 32);
	return true ;
}

//Function to disable all special characters in master codes.
//onBlur
function CheckForSpecCharsWithoutSpaceBlur(obj){

    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
	var values = obj.value
	var lenValue  = values.length

	if(values == "")
		return true;


	for(i=0; i<lenValue; i++){
        if(strCheck.indexOf(values.charAt(i)) == -1){
			alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED'));
			obj.focus();
			obj.select();
			return false;
		}
	}
	return true
}

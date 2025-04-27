/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function ChangeInitCase(obj)
{ 
  var name=obj.value;
  var length= obj.value.length;
  var letter = name.substring(0,length-(length-1));
  var rest = name.substring(1,length);
  letter=letter.toUpperCase();
  rest=rest.toLowerCase();
  var namenow= letter.concat(rest);
  obj.value= namenow;
}


function ChkNumberInput(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}

function putDecimal(Obj,maxvalue,deci)
{
var temp1=Obj.value;
var temp4=Obj.value.length;
var count=parseInt(maxvalue) -parseInt(deci);
if (parseInt(deci) > 0)
{
if(temp1.indexOf('.') <0)
{
	if (temp4 <= parseInt(maxvalue))
	{
		if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
		{
			var temp2=temp1.substring(0,count);
			var temp3=temp2+"."+temp1.substring(count,temp1.length)
			if(temp3.length-1 < parseInt(maxvalue))
			{
				for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
				{
				temp3+="0";
				}
			}
			Obj.value=temp3;
		}
         
		else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
		{
		var temp3=temp1+'.';
		for(var m=0;m<deci;m++)
		temp3+="0";
		Obj.value=temp3;
		
		}
      if (temp1.length == 0 )
	 {
	 		temp3="0.";
			for(var m=0;m<deci;m++)
			temp3+="0";
			Obj.value=temp3;
	 
	 }
   
 
 }

}else{
	var temp5=temp1.indexOf('.');
	var temp7=temp1.substring(0,temp5);
	var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
	var localTemp='';
	var len=parseInt(deci)-parseInt(temp6.length);
	for(var m=0;m<len;m++){
		localTemp+='0';
	}
	Obj.value=temp7+"."+temp6+localTemp;//added so that correct number of zeros appeding after decimal. By Sudhakar for IN017307 on 16/12/2009 and below is commented
	/*if(temp6.length >1){
		Obj.value=temp7+"."+temp6+localTemp;
	 }else{		 
		 Obj.value=temp7+"."+temp6+localTemp;
	 }*/
 }
}
}


/**
  * To change the lower-case to upper-case letters.
  */
function changeToUpper1()
{
	if( (window.event.keyCode >= 97) && (window.event.keyCode <= 122) )	
		return (window.event.keyCode -= 32);
	else
		return true;

}
function changeToUpper(event) {
    event = event || window.event; // Handle IE compatibility
    
    var char = String.fromCharCode(event.which || event.keyCode); // Get the character typed
    
    if (/[a-z]/.test(char)) { // Check if it's a lowercase letter
        var upperChar = char.toUpperCase(); // Convert to uppercase
        
        // Update the input value with the uppercase character
        if (event.target) {
            var start = event.target.selectionStart;
            var end = event.target.selectionEnd;
            event.target.value = event.target.value.substring(0, start) + upperChar + event.target.value.substring(end);
            event.target.setSelectionRange(start + 1, start + 1);
        }
        
        // Prevent the default action of typing the lowercase character
        if (event.preventDefault) {
            event.preventDefault();
        } else {
            event.returnValue = false; // For older IE versions
        }

        return false; // Optionally prevent further propagation
    }

    return true; // Allow default behavior for non-lowercase keys
}





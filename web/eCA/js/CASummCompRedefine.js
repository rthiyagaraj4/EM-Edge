/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
27/11/2012		IN035914		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be		changed and more appealing. Keeping the display of information more clear and visible.Master SetUp for Summary Component.
15/03/2012 		IN038579		Nijitha		CRF-CA-CHL-CRF-0006/05-Redefine summary Component-> System is displaying error message 	even after entering data for User Defined description.
-------------------------------------------------------------------------------------------------------------------------------------
*/
 function apply()
 {
	
    var from = f_query_add_mod.document.forms[0].fm_disp.value;
	var to=f_query_add_mod.document.forms[0].to_disp.value;
	var index=0;//IN038579
	var row_count=f_query_add_mod.document.forms[0].row_count.value;
	var formResultObj = f_query_add_mod.document.forms[0];
	var optionValStr1 = "",optionValStr2 = "",optionValStr5="", listValue1 = "", listName1 = "",listValue4="",listValue5="";
	for (var i=from; i<=to; i++){
        listValue0 = eval("formResultObj.opt_id"+i+".value");
		listName0  = eval("formResultObj.opt_id"+i+".name");
		
		//if(listValue0 == "") listValue0 = "0";IN038579
		listValue1 = eval("formResultObj.shortDesc"+i+".value");
		listName1  = eval("formResultObj.shortDesc"+i+".name");
		//IN038579 Starts
		if(listValue1 == "") 
		{
		listValue1 = "0";
		index++;
		}
		//IN038579 Ends
		
		
		
		listValue4 = eval("formResultObj.isColorPalletteEnabled"+i+".value");
		if(listValue4 == "||") listValue4 = "0"+"||"+"0";
			
		
		listValue5 = eval("formResultObj.isBoldEnabled"+i+".value");
		if(listValue5 == "") listValue5 = "0";
			
		optionValStr5 +=listValue5+"||"+listValue4+"||"+listValue1+"||"+i+"~";
		
	
          optionValStr1 += listName0 +"||"+listValue0+"~";
		  optionValStr2 += listName1 +"||"+listValue1+"~";
	}
   
	//IN038579 Starts
	//f_query_add_mod.document.forms[0].action="../../servlet/eCA.CASummCompRedefineServlet?optionValStr1="+optionValStr1+"&optionValStr2="+optionValStr2+"&optionValStr5="+optionValStr5;
	//f_query_add_mod.document.forms[0].target="messageFrame";
	//f_query_add_mod.document.forms[0].method="post";	
	//f_query_add_mod.document.forms[0].submit();
	if(index >0)
	{	
		var err_msg = getMessage("SUMMARY_NOT_BLANK","CA");
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg+"&error_value=0";
	}
	else
	{
		f_query_add_mod.document.forms[0].action="../../servlet/eCA.CASummCompRedefineServlet?optionValStr1="+optionValStr1+"&optionValStr2="+optionValStr2+"&optionValStr5="+optionValStr5;
		f_query_add_mod.document.forms[0].target="messageFrame";
		f_query_add_mod.document.forms[0].method="post";		
		f_query_add_mod.document.forms[0].submit();
	}
	
	//IN038579 Ends
 }	 
function reset()
{
	f_query_add_mod.location.href='../../eCA/jsp/CASummCompRedefine.jsp?dispMode=';
}

function checkVal(obj)
{	
	/*document.forms[0].dispMode.value = obj;
	document.forms[0].submit();*///IN038579
	//IN038579 Starts
	var formResultObj = document.forms[0];
	var from = document.forms[0].fm_disp.value;
	var to=document.forms[0].to_disp.value;
	var index=0;
	var listValue1 = "";
	for (var i=from; i<=to; i++)
	{
		
		listValue1 = eval("formResultObj.shortDesc"+i+".value");
		
		if(listValue1 == "") 
		{
		listValue1 = "0";
		index++;
		}
	}
	if(index >0)
	{	
		var err_msg = getMessage("SUMMARY_NOT_BLANK","CA");
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg+"&error_value=0";
		
	}
	else
	{
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
	}
	//IN038579 Ends
	
}

function CheckForSpeChar(event)
{
	//var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*  ';//CHL_CRF_006
	var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-/ ';//CHL_CRF_006
  //var whichCode = (window.Event) ? event.which : event.keyCode;//IN035914
  var whichCode = (window.Event)==null ? event.which : event.keyCode;//IN035914
 key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) 
		return false; 

}	

function onSuccess()
{ 
	f_query_add_mod.location.href='../../eCA/jsp/CASummCompRedefine.jsp?dispMode=';
}
//[IN035914] Starts
function copyBackgroundAndFontColor(color) {
	
	var formObj = document.caSummCompRedefine;
	var textColor = 50;
	var bckColor = "";
	var isBoldEnabled = "";
	var formcolor = "";
	var shtDescId = "";
	
	// formcolor = formObj.document.getElementById(color.swatch).value;
	 formcolor = document.getElementById(color.swatch).value;
	// shtDescId = formObj.document.getElementById(color.swatch).name;
	 shtDescId = document.getElementById(color.swatch).name;
	var index_val4 = shtDescId.substring(10);
	var index = parseInt(index_val4);
	if(shtDescId == 'routeColor'+index){
	
		if("000000"==formcolor)
		formcolor="";
		// formObj.document.getElementById('shortDesc' + index).style.color = formcolor;
		document.getElementById('shortDesc' + index).style.color ="#"+formcolor;
		document.getElementById('routeColor'+index).value =formcolor;
		
	}
	
	if(shtDescId=='routebgCol'+index)
	{
	
		document.getElementById('routebgCol'+index).value=formcolor;
		// formObj.document.getElementById('shortDesc' + index).style.backgroundColor = formcolor;
		document.getElementById('shortDesc' + index).style.backgroundColor = "#"+formcolor;
		
	}
	
	textColor = document.getElementById('routeColor'+index).value;
	bckColor = document.getElementById('routebgCol'+index).value;
	isBoldEnabled = document.getElementById('isBoldEnabled'+index).value;
	
	if(isBoldEnabled=="") isBoldEnabled ="0";
	if(bckColor=="") bckColor ="0";
	if(textColor=="") textColor ="0";
	document.getElementById('isColorPalletteEnabled' + index).value = textColor+"||"+bckColor;
}
function increase_brightness(color, percent)
{
    var r = parseInt(color.substr(1, 2), 16), g = parseInt(color.substr(3, 2), 16), b = parseInt(color.substr(5, 2), 16); 
    return  ((0|(1<<8) + r + (256 - r) * percent / 100).toString(16)).substr(1) + ((0|(1<<8) + g + (256 - g) * percent / 100).toString(16)).substr(1) +        ((0|(1<<8) + b + (256 - b) * percent / 100).toString(16)).substr(1); 
}

function CheckForSpeCharInColorPallete(event)
{
	var strCheck='0123456789abcdefABCDEF';//CHL-CRF-006-Nijitha
  var whichCode = (window.Event)==null ? event.which : event.keyCode;
 key = String.fromCharCode(whichCode);  
    if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key

}
function CheckForSpecCharsWithCopyPaste(textObj)
{
	
	var ValidChars = /^[0-9a-zA-Z-_\/ ]*$/; 
// var pasteData = window.clipboardData.getData("Text");  // old code IE to Edge conv start
	    if (window.clipboardData) { // For Internet Explorer
        pasteData = window.clipboardData.getData("Text");
		} else if (event.clipboardData) { // For modern browsers
        pasteData = event.clipboardData.getData('text/plain');
		}
		// end
	pasteData = trimString(pasteData);
	
	if(ValidChars.test(pasteData))
	{
		
		textObj.value = pasteData;
	}
	else 
		return false; 
}
//[IN035914] Ends

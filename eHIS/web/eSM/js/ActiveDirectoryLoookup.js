function closew() {
    parent.window.close();
} 

function CallDescFrame() {
	var search_criteria = document.forms[0].search_criteria.value;
	var search_text = document.forms[0].search_text.value;

	if(search_text == ""){
		search_criteria = 'ALL';
	}

	var retval = callSingleSignOnSearch('SEARCH',search_criteria,search_text);

	var splitretval = retval.split("$!^");
	var retvaljson = splitretval[0];
	var retvalStatusCode = splitretval[1];
	var retvalStatusDesc = splitretval[2];

	var retDataParse = jQuery.parseJSON(retvaljson);
	var retDataCnt = retDataParse.length;

	if(retDataCnt > 0){
		var url = "../../eSM/jsp/ActiveDirectoryResult.jsp?retvaljson="+retvaljson+"&retDataCnt="+retDataCnt;
		parent.lookup_detail.location.href = url;
	}else{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	}	
}

function resetForm(formObj){
	formObj.reset();
	var argArray = window.dialogArguments ;
	document.forms[0].search_text.value = "";
	document.forms[0].search_criteria.options.value = "S" ;
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
}

function lockKey()
{
	whichCode = event.keyCode;
    if(whichCode== 93)
	{
       var error=getMessage("WELCOME","common");
	   alert(error);
	}
	else if(whichCode == 113)
	{
		if(document.forms[0].help_function_id != null)
		{
			if(document.forms[0].help_function_id.value != "")
			{
				var width = 800 ;
				var height = 550 ;
				var left = (window.screen.availWidth-width)/2 ;
				var top  = (window.screen.availHeight-height)/2 ;

				var myBars = 'directories=no,location=no,menubar=no,status=no' ;
				var myOptions = 'width=' + width +', height=' + height +', resizable=no' ;
				var myFeatures = myBars + ', ' + myOptions ;
				var gahsWindow = open( '../../GAHSHelp/?topic='+document.forms[0].help_function_id.value, 'GAHSHelp', myFeatures ) 
				gahsWindow.document.title="GAHS Help"
			}
		}
	}
}

function makeValidString(txtObj)
{	
    var text_value  =   txtObj.value;
	while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!=' ')
            {
                text_value  =   text_value.substring(0,(i+1))+' '+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function Modify(indx){

	var ret=eval("document.getElementById("hd_")"+indx).value;

    top.window.returnValue = ret ;
    top.close() ;
}

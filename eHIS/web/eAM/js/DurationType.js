var result = false;
var message = "" ;
var flag = "" ;


function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply(){
		//alert("enter");

		if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
		var length = f_query_add_mod.duration_type.totalSize.value
			
		var typeCode = "";
		var desc = "";
		var forText = "";
		//alert("length:"+length);
		for(i=0; i<length; i++){
			
			if((eval("f_query_add_mod.duration_type.desc"+i).value == "" && eval("f_query_add_mod.duration_type.forText"+i).value != "") || (eval("f_query_add_mod.duration_type.desc"+i).value != "" && eval("f_query_add_mod.duration_type.forText"+i).value == "") ){
				if(eval("f_query_add_mod.duration_type.desc"+i).value == ""){
					var desc=getLabel("Common.description.label","Common");

					f_query_add_mod.checkField(eval("f_query_add_mod.duration_type.desc"+i) , desc );
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
					return false;
				}
				if(eval("f_query_add_mod.duration_type.forText"+i).value == ""){
					var for_text =getLabel("eAM.ForText.label","AM");
					f_query_add_mod.checkField(eval("f_query_add_mod.duration_type.forText"+i) , for_text );
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
					return false;
				}
		
			}	
			if(eval("f_query_add_mod.duration_type.typeCode"+i).value == ""){
				eval("f_query_add_mod.duration_type.typeCode"+i).value = " ";
			}
			if(eval("f_query_add_mod.duration_type.desc"+i).value == ""){
				eval("f_query_add_mod.duration_type.desc"+i).value = " ";
			}
			if(eval("f_query_add_mod.duration_type.forText"+i).value == ""){
				eval("f_query_add_mod.duration_type.forText"+i).value = " ";
			}

			typeCode += eval("f_query_add_mod.duration_type.typeCode"+i).value+"~";
			desc += eval("f_query_add_mod.duration_type.desc"+i).value+"~";
			forText += eval("f_query_add_mod.duration_type.forText"+i).value+"~";

		}

		typeCode = typeCode.substring(0,typeCode.length-1);
		desc = desc.substring(0,desc.length-1);
		forText = forText.substring(0,forText.length-1);

	
		f_query_add_mod.duration_type.allTypeCode.value = typeCode;
		f_query_add_mod.duration_type.allDesc.value = desc;
		f_query_add_mod.duration_type.allForText.value = forText;
        
		f_query_add_mod.document.forms[0].action="../../servlet/eAM.DurationTypeServlet";
		f_query_add_mod.document.forms[0].submit();
		//alert("end");
	//} 

		
}

function reset()
{
    f_query_add_mod.document.forms[0].reset();
}

function onSuccess()
{
	f_query_add_mod.location.reload();

}

		function CheckForSpecChars1(event){
    var strCheck = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else
	return true ;
}

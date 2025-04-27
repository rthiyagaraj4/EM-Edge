function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/AddModifyDiagnosisCategory.jsp?mode=insert" ;
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eMR/jsp/QueryDiagnosisCategory.jsp";
}

//*********************************************************************************************************
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1)
		if(f_query_add_mod.document.forms[0]){
	      	f_query_add_mod.document.forms[0].reset();
		}
}

 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1)&&(url.indexOf("result")==-1) )
		
	return true;
	else
		return false;
}

function apply()
{
		if (! (checkIsValidForProceed()) )
    {
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
    } 
	var	formObj	= f_query_add_mod.document.diagnocategory_form;
	var mode = f_query_add_mod.document.diagnocategory_form.mode.value;	


	var next_str;
	if(mode=='insert'){
		if(formObj.eff_status.checked==true)
			formObj.eff_status.value="E";
		else
			formObj.eff_status.value="D";
		
	}
	
	
	if(mode=='modify'){
		if(formObj.eff_status.checked==true)
			formObj.eff_status.value="E";
		else
			formObj.eff_status.value="D";
	}

	var	fields = new Array ( formObj.diag_catg_code,formObj.long_desc,formObj.short_desc);
    var	names =	new	Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"));
	
	  if(f_query_add_mod.checkFieldsofMst(	fields,	names, messageFrame)) 
	  {
		  var flds=new Array(formObj.diag_catg_code);
		  var diag_catg_code	= formObj.diag_catg_code.value;
		  var name=new Array(getLabel("Common.code.label","Common")); 

		  if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
				formObj.submit();
	    }
       }
	}
function onSuccess()
   {
	   var	formObj	= f_query_add_mod.document.diagnocategory_form;
	   
	   
	    var mode =formObj.mode.value;
		 	if(mode=="insert"){
		   		 formObj.reset();
		   		if($("input[name='chkdefault']",formObj)!=null){
			   		$("input[name='chkdefault']",formObj).each(function(){
			 		   $(this).attr("disabled",true);
			 	   });
		 		}
				$("#tdDefaultHeader",formObj).hide();
				$("[id^=tdDefaultValues]",formObj).hide();
		 	}
		  /*------------*/
		  else if(mode=="modify"){	
			  f_query_add_mod.location.href='../../eMR/jsp/AddModifyDiagnosisClassification.jsp?mode=modify'+paramValues;
		  }
				 /*------------*/
  }

//*****************************************************************************************************
function ValidString(txtObj)
{
    var text_value  =   txtObj.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    txtObj.value = text_value;

    /*if(text_value.indexOf("&")==(text_value.length-1))
    {
        return false;
    }

    for(var i=0; i<text_value.length; i++)
    {
        if( (text_value.charAt(i)=='&')  || (text_value.charAt(i)=='<') )
        {
            if(text_value.charAt(i+1)!='')
            {
                text_value  =   text_value.substring(0,(i+1))+''+ text_value.substring((i+1),text_value.length);
                i++;
            }
        }
    }*/
    txtObj.value = text_value;
    if(txtObj.value.length>txtObj.maxLength)
    {
        alert(getMessage("EXCEED_MAX_LENGTH", "Sm",null));

        txtObj.select();
        txtObj.focus();
    }
}

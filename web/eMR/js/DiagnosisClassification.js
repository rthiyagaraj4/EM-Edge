function create() {
	f_query_add_mod.location.href = "../../eMR/jsp/AddModifyDiagnosisClassification.jsp?mode=insert" ;
}
//*******************************************************************************************************
function query()
{
	f_query_add_mod.location.href="../../eMR/jsp/QueryDiagnosisClassification.jsp";
}

//*********************************************************************************************************
function reset(){
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1)
		if(f_query_add_mod.document.forms[0]){
	      	f_query_add_mod.document.forms[0].reset();
	       	FnEnableDefaultCheckbox(f_query_add_mod.document.forms[0]);
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
		/*messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;*/
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
    } 
	var	formObj	= f_query_add_mod.document.diagonlosis_form;
	var mode = f_query_add_mod.document.diagonlosis_form.mode.value;	

	//var term_set;
	var next_str;
	if(mode=='insert'){

		var max_record=f_query_add_mod.document.diagonlosis_form.tot_cnt.value;
		for (var i=0;i<max_record;i++ )
		{
			if (f_query_add_mod.document.diagonlosis_form["chk_TermSet_IdDig" + i].checked){
			var term_set = f_query_add_mod.document.diagonlosis_form["term_set" + i].value;

			if(i==0){
				next_str=term_set;
			}else{
				next_str=next_str+"@"+term_set;
			}
			f_query_add_mod.document.diagonlosis_form.final_termSet.value=next_str;
		}
	}
	
	/*--------start append*/
		if(formObj.eff_status.checked==true)
		formObj.eff_status.value="E";
	else
		formObj.eff_status.value="D";
		
	}
	if(mode=='modify'){

		

		var max_record=f_query_add_mod.document.diagonlosis_form.tot_cnt.value;
		var return_value=true;//Added by Maheshwaran K for the SKR-CRF-0020 as on 10/07/2013
		for (var i=0;i<max_record;i++ )
		{
		
				if(eval("f_query_add_mod.document.diagonlosis_form.chk_ModTermSet_IdDig"+i+".checked")==true){
			var term_set = f_query_add_mod.document.diagonlosis_form["originalTermId" + i].value;

			var next_str;
			if(i==0){

				next_str=term_set;
			}else{
				if(next_str==undefined){
					next_str=term_set;
				}
				else{
				next_str=next_str+"@"+term_set;
				}
			}
				f_query_add_mod.document.diagonlosis_form.final_termSet.value=next_str;
				
		}
		paramValues="&diag_class_code="+formObj.diag_class_code.value+"&long_desc="+formObj.long_desc.value+
		"&short_desc="+formObj.short_desc.value+"&diag_class_type="+formObj.diag_class_type.value+
		"&eff_status="+formObj.eff_status.value;
		/*Added by Maheshwaran K for the SKR-CRF-0020 as on 10/07/2013*/
		//Start
		/*return_value= CheckPrinipalDiag_TermSet(eval("f_query_add_mod.document.diagonlosis_form.chk_ModTermSet_IdDig"+i+""),eval("f_query_add_mod.document.diagonlosis_form.default_termset_value"+i+""),eval("f_query_add_mod.document.diagonlosis_form.default_status"),eval("f_query_add_mod.document.diagonlosis_form.diag_class_type"),"apply");
		if(return_value==false)
		break;
		//End*/
		}
	/*--------start append*/
		if(formObj.eff_status.checked==true)
		formObj.eff_status.value="E";
	else
		formObj.eff_status.value="D";
		

	}
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 10/07/2013*/
	//Start	   
	/*if(return_value!=false)
		{
	//End*/	
	var	fields = new Array ( formObj.diag_class_code,formObj.long_desc,formObj.short_desc,formObj.diag_class_type);
    var	names =	new	Array (getLabel("Common.code.label","Common"),getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.Classification.label","Common")+" "+getLabel("Common.type.label","Common"));

	  if(f_query_add_mod.checkFieldsofMst(	fields,	names, messageFrame)) 
	  {
		  var flds=new Array(formObj.diag_class_code);
		  var diag_class_code	= formObj.diag_class_code.value;
		  var name=new Array(getLabel("Common.code.label","Common")); if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
				 
			 if(formObj.diag_class_type.value=='PD'){
				$("#defaulttermset",formObj).val("");
				var termSetIds 	= "";
				$("input[name='chkdefault']",formObj).filter(':checked').each(function(){
					termSetIds	+= $(this).val()+"|#|";
				});
				if(termSetIds!=''){
					termSetIds	=  termSetIds.slice(0,-3);
				}
				$("#defaulttermset",formObj).val(termSetIds);
				var defaulttermset	= 	$("#defaulttermset",formObj).val();
				/*if(defaulttermset!=""){
					$.ajax({  
					      url:'../../eMR/jsp/CheckDefaultTermset.jsp',  
					      type:'post',  
					      data:{'action':'chk_default_termset','defaulttermset':defaulttermset,'mode':mode,'diag_class_code':formObj.diag_class_code.value},
					      dataType: 'json',
					      success: function(data) {
								if(data.isDefaultAlreadyExists == 0){
									formObj.diag_class_type.disabled=false;
									formObj.submit();
								}else{
									message  = getMessage("DFLT_PRINCIPAL_CLASS_TYPE",'MR');
									messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
								}	 
					      },
					      error: function(jqXHR, textStatus, errorThrown) {
					          alert("incoming Text " + jqXHR.responseText);
					      }
					});
					
				}else{
					$("#defaulttermset",formObj).val("");*/
		            formObj.diag_class_type.disabled=false;
					formObj.submit();
				//}
			}else{
				$("#defaulttermset",formObj).val("");
	            formObj.diag_class_type.disabled=false;
				formObj.submit();
			}
			 return false;

	     }
       }
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 10/07/2013*/
	//Start	   
	/*	}
	else
		{
		message  = getMessage("DFLT_PRINCIPAL_CLASS_TYPE",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
		}
	//End*/	
	}
//*****************************************************************************************************
function onSuccess()
   {
	   var	formObj	= f_query_add_mod.document.diagonlosis_form;
	   
	   
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
/*Added by Maheshwaran K for the SKR-CRF-0020 as on 03/05/2012-->
Start*/
/*This function is created to show the default checkbox when the "Principal Diagnosis" was choosen in Classification type
and for other classification type it will hide the default option*/
function ShowDefaultChkBox(diag_class_type_obj) {
	if(diag_class_type_obj.value=='PD')	{
		/*default_chkbox_id_obj.style.display = '';
		default_status_obj.value='Y'
		default_status_obj.checked=true;*/
		$("#tdDefaultHeader").show();
		$("[id^=tdDefaultValues]").show();
	}else{
		$("#tdDefaultHeader").hide();
		$("[id^=tdDefaultValues]").hide();
		/*default_chkbox_id_obj.style.display = 'none';
		default_status_obj.value='N'
		default_status_obj.checked=false;*/
	}		
	
}
//This function is created to validate the Termset ,whether default status already exists for the Termset under Principal Diagnosis Classification
//If it was there then it will no allow for second default ,only one default can used under the Principal Diagnosis Classification
function CheckPrinipalDiag_TermSet(chk_TermSet_IdDig_obj,default_termset_value_obj,default_status_obj,diag_class_type_obj,called_from)
		{
		if(diag_class_type_obj.value=='PD')
			{
			if(default_status_obj.checked==true)
			{
			if(chk_TermSet_IdDig_obj.checked==true)	
				{
				if(default_termset_value_obj.value=='Y')
					{
					if(called_from=="chk")
						{
						message  = getMessage("DFLT_PRINCIPAL_CLASS_TYPE",'MR');
						alert(message);
						}
					chk_TermSet_IdDig_obj.checked=false;
					return false;
					}
				}
			else 	
				{
				if(default_termset_value_obj.value=='Y')
					{
					default_status_obj.disabled="";
					}
				
				}	
			}
		else 
			{
			if(chk_TermSet_IdDig_obj.checked==true)
				{
				if(default_termset_value_obj.value=='Y')
					{
					default_status_obj.disabled=true;
					}
				else 
					{
					default_status_obj.disabled="";
					}
				}
			else 
				{
				if(default_termset_value_obj.value=='Y')
					{
					default_status_obj.disabled="";
					default_status_obj.checked=true;
					}
				}

			}
		}
	}
//This function is created to set the  value for the Default Checkbox
function Default_Check(checkbox_obj)		
	{
	if(checkbox_obj.value=='N')
		{
		checkbox_obj.value='Y';
		checkbox_obj.checked=true;
		}
	else
		{
		checkbox_obj.value='N';
		checkbox_obj.checked=false;
		}
	}	
/*End*/	
function FnSelectOneCheckbox(termsetValue,mode){ 
/*
	$("input[name='chkdefault']").each(function(){
		if(termsetValue!=$(this).val()){
			$(this).attr("checked",false);
		}
	});
*/  

	var	formObj	= document.diagonlosis_form;
	$.ajax({   url:'../../eMR/jsp/CheckDefaultTermset.jsp',  
	      type:'post',  
	      data:{'action':'chk_default_termset','defaulttermset':termsetValue,'mode':mode,'diag_class_code':formObj.diag_class_code.value},
	      dataType: 'json',
	      success: function(data) { 
				if(data.isDefaultAlreadyExists != 0){
					alert(getMessage("DFLT_PRINCIPAL_CLASS_TYPE",'MR'));
					$("input[name='chkdefault']",formObj).filter(':checked').each(function(){
						if($(this).val()==termsetValue){
							$(this).attr("checked",false);
						}
					});
					
				}	 
	      },
	      error: function(jqXHR, textStatus, errorThrown) {
	          alert("incoming Text " + jqXHR.responseText);
	      }
	});
}

function FnEnableDefaultCheckbox(formName){
	var ArrValues	= new Array();
	$("[id=AppTerset]",formName).filter(':checked').each(function(){
		ArrValues.push($(this).val());
	});
	
	$("input[name='chkdefault']",formName).each(function(){
		if(FnInArray($(this).val(),ArrValues)){
			$(this).attr("disabled",false);
		}else{
			$(this).attr("disabled",true);
			$(this).attr("checked",false);
		}
	});
	
	if(formName.diag_class_type.value!='PD'){
		$("#tdDefaultHeader",formName).hide();
		$("[id^=tdDefaultValues]",formName).hide();
	}
	
	
	
}
function FnInArray(needle, haystack) {
    var length = haystack.length;
    for(var i = 0; i < length; i++) {
        if(haystack[i] == needle)
        	return true;
    }
    return false;
}


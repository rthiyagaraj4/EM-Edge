function onSuccess()  
 {
  f_query_add_mod.document.location.reload();
 }
function prefixsuffixcheck()
{
  if(document.MORegistration_form.asso_dtls_reqd_yn.checked==true)
	 {
	  document.MORegistration_form.asso_dtls_reqd_yn.value = "Y";
	  document.MORegistration_form.prefix_facility_id.disabled = false;
	  document.MORegistration_form.suffix_facility_id.disabled = false;	
	  document.MORegistration_form.prefix_year.disabled = false;
	  document.MORegistration_form.suffix_year.disabled = false;

	  if(document.MORegistration_form.prefix_facility_id.checked==true)
		{
			document.MORegistration_form.prefix_facility_id.value = "Y"
			document.MORegistration_form.suffix_facility_id.disabled = true;
		}

	 if(document.MORegistration_form.suffix_facility_id.checked==true)
		{
			document.MORegistration_form.suffix_facility_id.value = "Y"
			document.MORegistration_form.prefix_facility_id.disabled = true;
		}

	 if(document.MORegistration_form.prefix_year.checked==true)
		{
			document.MORegistration_form.prefix_year.value = "Y"
			document.MORegistration_form.suffix_year.disabled = true;
		}

	 if(document.MORegistration_form.suffix_year.checked==true)
		{
			document.MORegistration_form.suffix_year.value = "Y"
			document.MORegistration_form.prefix_year.disabled = true;
		}

	 }
 else	
	 {

	  document.MORegistration_form.asso_dtls_reqd_yn.value = "N";
	  

	  document.MORegistration_form.prefix_facility_id.checked = false;
	  document.MORegistration_form.suffix_facility_id.checked = false;	
	  document.MORegistration_form.prefix_year.checked = false;
	  document.MORegistration_form.suffix_year.checked = false;

	  document.MORegistration_form.prefix_facility_id.value = "N";
	  document.MORegistration_form.suffix_facility_id.value = "N";	
	  document.MORegistration_form.prefix_year.value = "N";
	  document.MORegistration_form.suffix_year.value = "N";

	  document.MORegistration_form.prefix_facility_id.disabled = true;
	  document.MORegistration_form.suffix_facility_id.disabled = true;	
	  document.MORegistration_form.prefix_year.disabled = true;
	  document.MORegistration_form.suffix_year.disabled = true;

	  

	 }

 }
function prefixfacilitycheck()
{
	if(document.MORegistration_form.prefix_facility_id.checked==true)
	{
		document.MORegistration_form.prefix_facility_id.value = "Y"
		document.MORegistration_form.suffix_facility_id.disabled = true;
	}
	else
	{
		document.MORegistration_form.prefix_facility_id.value = "N";
		document.MORegistration_form.prefix_facility_id.checked = false;

		document.MORegistration_form.suffix_facility_id.disabled = false;
	}

}
function suffixfacilitycheck()
{
	
	if(document.MORegistration_form.suffix_facility_id.checked==true)
	{
		document.MORegistration_form.suffix_facility_id.value = "Y"
		document.MORegistration_form.prefix_facility_id.disabled = true;
	}
	else
	{
		document.MORegistration_form.suffix_facility_id.value = "N"
		document.MORegistration_form.prefix_facility_id.disabled = false;
	}

}
function prefixyearcheck()
{
	if(document.MORegistration_form.prefix_year.checked==true)
	{
		document.MORegistration_form.prefix_year.value = "Y"
		document.MORegistration_form.suffix_year.disabled = true;
	}
	else
	{
	  document.MORegistration_form.prefix_year.value = "N"
	  document.MORegistration_form.suffix_year.disabled = false;
	}

}
function suffixyearcheck()
{
	if(document.MORegistration_form.suffix_year.checked==true)
	{
		document.MORegistration_form.suffix_year.value = "Y"
		document.MORegistration_form.prefix_year.disabled = true;
	}
	else
	{
		document.MORegistration_form.suffix_year.value = "N"
		document.MORegistration_form.prefix_year.disabled = false;
	}

}
function ChkPosNum(obj) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
		return true;
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("ONLY_POSITIVE_NUM", "SM"));
            obj.select();
            obj.focus();
			return false;
        }
    }
}
function checkout(obj)
{
	if (document.forms[0].mortuary_start_num.value!="")
	{
	document.MORegistration_form.calculate.value='';
	var prefix_facility_id = "N";
	var suffix_facility_id = "N";
	var prefix_year = "N";
	var suffix_year = "N";
	var start_num =  document.MORegistration_form.mortuary_start_num.value;
	if(document.MORegistration_form.prefix_facility_id!=null)
	prefix_facility_id= document.MORegistration_form.prefix_facility_id.value;
	if(document.MORegistration_form.suffix_facility_id!=null)
	suffix_facility_id= document.MORegistration_form.suffix_facility_id.value;
	if(document.MORegistration_form.prefix_year!=null)
	  prefix_year = document.MORegistration_form.prefix_year.value;
	if(document.MORegistration_form.suffix_year!=null)
		suffix_year = document.MORegistration_form.suffix_year.value;
	var start_num = document.MORegistration_form.mortuary_start_num.value; 


	//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
	var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH prefix_facility_id_yn=\""+prefix_facility_id+"\" suffix_facility_id_yn=\""+suffix_facility_id+"\" prefix_year_yn=\""+prefix_year+"\" suffix_year_yn=\""+suffix_year+"\" start_num=\""+start_num+"\"/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AutopsyNumber.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	document.MORegistration_form.calculate.value = responseText;
	}

	
}
function chkgrt(obj)
{
	var next_num=document.forms[0].mortuary_next_num.value;
    var start_num = document.forms[0].mortuary_start_num.value 

/* if(eval(obj.value)<=start_num)		
	{
	alert(getMessage('MAX_SHOULD_BE_GT_START','MO'));
	document.forms[0].mortuary_max_num.focus();
	document.forms[0].mortuary_max_num.select();
	} */

if(eval(obj.value)<=next_num)		
	{
	
	var error = getMessage('MAX_SHOULD_BE_GT_NEXT','MO');
	error = error.replace('$',getLabel("eMO.MortuaryRegEndNo.label","MO"));
	error = error.replace('#',getLabel("eMO.MortuaryNextRegNo.label","MO"));
	alert(error);

	document.forms[0].mortuary_max_num.focus();
	document.forms[0].mortuary_max_num.select();
	}

	
}
function chkzero(obj)
{
	if(obj.value!=""){
	if(parseInt(obj.value)<=0)
	{
		alert(getMessage('START_NUM_CANT_BE_ZERO','MO'));
		document.MORegistration_form.mortuary_start_num.value="";
		document.MORegistration_form.mortuary_next_num.value="";
		document.MORegistration_form.calculate.value="";
		document.forms[0].mortuary_start_num.focus();
	}
	}
}
function reset() 
  {

   f_query_add_mod.document.location.reload() ;
} 
function apply()
{  
  
			
		var fields = new Array (f_query_add_mod.document.MORegistration_form.mortuary_start_num,f_query_add_mod.document.MORegistration_form.mortuary_max_num);
		var names = new Array (getLabel('eMO.MortuaryRegStartNo.label','MO'),getLabel('eMO.MortuaryRegEndNo.label','MO'));   

		var fields1 = new Array 
		(f_query_add_mod.document.MORegistration_form.mortuary_start_num,f_query_add_mod.document.MORegistration_form.mortuary_next_num,f_query_add_mod.document.MORegistration_form.mortuary_max_num);

	//	var names1 = new Array ("Mortuary Registration Start Number");
		var names1 = new Array (getLabel('eMO.MortuaryRegStartNo.label','MO'),getLabel('eMO.MortuaryNextRegNo.label','MO'),getLabel('eMO.MortuaryRegEndNo.label','MO'));
		var error_page = "../../eCommon/jsp/MstCodeError.jsp";	

		
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
			{
			
			f_query_add_mod.document.MORegistration_form.mortuary_start_num.disabled=false;
		    f_query_add_mod.document.MORegistration_form.mortuary_next_num.disabled=false;

				f_query_add_mod.document.MORegistration_form.submit();
			}
		}
 }

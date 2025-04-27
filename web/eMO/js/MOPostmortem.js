function onSuccess() 
 {
  f_query_add_mod.document.location.reload();
 }

function FocusFirstElement()
 {
	 if(document.PostmortemForm.mode == "insert")
		 document.PostmortemForm.start_num.focus();
	 else
		document.PostmortemForm.end_num.focus();
 }

function prefixsuffixcheck()
 {
  if(document.PostmortemForm.post_associate_details.checked==true)
	 {
	  document.PostmortemForm.post_associate_details.value = "Y";
	  document.PostmortemForm.prefix_facility_id_yn.disabled = false;
	  document.PostmortemForm.suffix_facility_id_yn.disabled = false;	
	  document.PostmortemForm.prefix_year_yn.disabled = false;
	  document.PostmortemForm.suffix_year_yn.disabled = false;

	  if(document.PostmortemForm.prefix_facility_id_yn.checked==true)
		{
			document.PostmortemForm.prefix_facility_id_yn.value = "Y"
			document.PostmortemForm.suffix_facility_id_yn.disabled = true;
		}
		
	 if(document.PostmortemForm.suffix_facility_id_yn.checked==true)
		{
			document.PostmortemForm.suffix_facility_id_yn.value = "Y"
			document.PostmortemForm.prefix_facility_id_yn.disabled = true;
		}

	 if(document.PostmortemForm.prefix_year_yn.checked==true)
		{
			document.PostmortemForm.prefix_year_yn.value = "Y"
			document.PostmortemForm.suffix_year_yn.disabled = true;
		}

	 if(document.PostmortemForm.suffix_year_yn.checked==true)
		{
			document.PostmortemForm.suffix_year_yn.value = "Y"
			document.PostmortemForm.prefix_year_yn.disabled = true;
		}


	 }
 else	
	 {
	  document.PostmortemForm.post_associate_details.value = "N";
	  document.PostmortemForm.prefix_facility_id_yn.disabled = true;
	  document.PostmortemForm.suffix_facility_id_yn.disabled = true;	
	  document.PostmortemForm.prefix_year_yn.disabled = true;
	  document.PostmortemForm.suffix_year_yn.disabled = true;


	  document.PostmortemForm.prefix_facility_id_yn.checked = false;
	  document.PostmortemForm.suffix_facility_id_yn.checked = false;	
	  document.PostmortemForm.prefix_year_yn.checked = false;
	  document.PostmortemForm.suffix_year_yn.checked = false;

	  document.PostmortemForm.prefix_facility_id_yn.value = "N";
	  document.PostmortemForm.suffix_facility_id_yn.value = "N";	
	  document.PostmortemForm.prefix_year_yn.value = "N";
	  document.PostmortemForm.suffix_year_yn.value = "N";

	 }

 }

function prefixfacilitycheck()
{
	if(document.PostmortemForm.prefix_facility_id_yn.checked==true)
	{
		document.PostmortemForm.prefix_facility_id_yn.value = "Y"
		document.PostmortemForm.suffix_facility_id_yn.disabled = true;
	}
	else
	{
	  document.PostmortemForm.prefix_facility_id_yn.value = "N"
	  document.PostmortemForm.suffix_facility_id_yn.disabled = false;
	}

}

function suffixfacilitycheck()
{
	if(document.PostmortemForm.suffix_facility_id_yn.checked==true)
	{
		document.PostmortemForm.suffix_facility_id_yn.value = "Y"
		document.PostmortemForm.prefix_facility_id_yn.disabled = true;
	}
	else
	{
		document.PostmortemForm.suffix_facility_id_yn.value = "N"
		document.PostmortemForm.prefix_facility_id_yn.disabled = false;
	}

}

function prefixyearcheck()
{
	if(document.PostmortemForm.prefix_year_yn.checked==true)
	{
		document.PostmortemForm.prefix_year_yn.value = "Y"
		document.PostmortemForm.suffix_year_yn.disabled = true;
	}
	else
	{
	  document.PostmortemForm.prefix_year_yn.value = "N"
	  document.PostmortemForm.suffix_year_yn.disabled = false;
	}

}

function suffixyearcheck()
{
	if(document.PostmortemForm.suffix_year_yn.checked==true)
	{
		document.PostmortemForm.suffix_year_yn.value = "Y"
		document.PostmortemForm.prefix_year_yn.disabled = true;
	}
	else
	{
		document.PostmortemForm.suffix_year_yn.value = "N"
		document.PostmortemForm.prefix_year_yn.disabled = false;
	}
}

function reset() 
  {

   f_query_add_mod.document.location.reload() ;

   
}

function numcheck(Object)
{
	var startnum = document.PostmortemForm.start_num.value;
	var nextnum = document.PostmortemForm.next_num.value; 
	var endnum = Object.value;

/*	if(eval(endnum)<=startnum)		
	{
	alert(getMessage('MAX_SHOULD_BE_GT_START','MO'));
	Object.focus();
	Object.select();
	} */

	if(eval(nextnum) >= eval(endnum))
	{
		//alert(getMessage('MAX_SHOULD_BE_GT_NEXT','MO'));

		var error = getMessage('MAX_SHOULD_BE_GT_NEXT','MO');
		error = error.replace('$',getLabel("eMO.EndAutopsyNo.label","MO"));
		error = error.replace('#',getLabel("eMO.NextAutopsyNo.label","MO"));
		alert(error);

		Object.focus();
		Object.select();
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
function nextdefault()
{
  if(document.PostmortemForm.start_num.value!="")
	{
  if(document.PostmortemForm.start_num.value!=0)
	{
     document.PostmortemForm.next_num.value = document.PostmortemForm.start_num.value;
	 anumberformat();
	}
 else
	{
	 alert(getMessage('START_NUM_CANT_BE_ZERO','MO'));
	 document.PostmortemForm.start_num.value=""
	 document.PostmortemForm.next_num.value=""
	 document.PostmortemForm.post_number_format.value=""
	 document.PostmortemForm.start_num.focus();
	}
	}
}

function anumberformat()
{  
  
  var prefix_facility_id_yn = "N";
  var suffix_facility_id_yn = "N";
  var prefix_year_yn = "N";
  var suffix_year_yn = "N";

  if(document.PostmortemForm.start_num.value!="")
  {
  if(document.PostmortemForm.prefix_facility_id_yn!=null)
    prefix_facility_id_yn= document.PostmortemForm.prefix_facility_id_yn.value;
  if(document.PostmortemForm.suffix_facility_id_yn!=null)
   suffix_facility_id_yn = document.PostmortemForm.suffix_facility_id_yn.value;
  if(document.PostmortemForm.prefix_year_yn!=null)
	  prefix_year_yn = document.PostmortemForm.prefix_year_yn.value;
  if(document.PostmortemForm.suffix_year_yn!=null)
		suffix_year_yn = document.PostmortemForm.suffix_year_yn.value;
  var start_num = document.PostmortemForm.start_num.value; 

  //var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
  var xmlDoc = ""; 
  var xmlHttp = new XMLHttpRequest()
  xmlStr ="<root><SEARCH prefix_facility_id_yn=\""+prefix_facility_id_yn+"\" suffix_facility_id_yn=\""+suffix_facility_id_yn+"\" prefix_year_yn=\""+prefix_year_yn+"\" suffix_year_yn=\""+suffix_year_yn+"\" start_num=\""+start_num+"\"/></root>"
  xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
  xmlHttp.open("POST","AutopsyNumber.jsp",false)
  xmlHttp.send(xmlDoc)
  responseText=xmlHttp.responseText
  responseText = trimString(responseText)
  document.PostmortemForm.post_number_format.value = responseText;
  }
 }

function apply()
{
  var fields = new Array ( f_query_add_mod.document.PostmortemForm.start_num,
						f_query_add_mod.document.PostmortemForm.next_num,
						f_query_add_mod.document.PostmortemForm.end_num
					    );
	var names = new Array ( getLabel('eMO.StartingAutopsyNo.label','MO'),
						getLabel('eMO.NextAutopsyNo.label','MO'),
						getLabel('eMO.EndAutopsyNo.label','MO')
    				      );

	
	var splField = new Array (f_query_add_mod.document.PostmortemForm.start_num);
	var splFieldName = new Array (getLabel('eMO.StartingAutopsyNo.label','MO'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		if(f_query_add_mod.checkFields( fields, names, messageFrame)) {

f_query_add_mod.document.PostmortemForm.start_num.disabled = false;
  f_query_add_mod.document.PostmortemForm.next_num.disabled = false;
  
f_query_add_mod.document.PostmortemForm.post_associate_details.disabled = false;
f_query_add_mod.document.PostmortemForm.prefix_facility_id_yn.disabled = false;
f_query_add_mod.document.PostmortemForm.suffix_facility_id_yn.disabled = false;
f_query_add_mod.document.PostmortemForm.prefix_year_yn.disabled = false;
f_query_add_mod.document.PostmortemForm.suffix_year_yn.disabled = false;

			f_query_add_mod.document.PostmortemForm.submit();
		}
	}
		return true;
}

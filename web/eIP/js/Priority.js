
 function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyPriority.jsp" ;
  }

 function query()
  {
  	f_query_add_mod.location.href="../../eIP/jsp/PriorityQueryCriteria.jsp";	
  }

 function apply()
 { 
	 f_query_add_mod.document.priority_form.days_hours.disabled = false;
	 f_query_add_mod.document.priority_form.exp_day.disabled = false;
	if(f_query_add_mod.document.priority_form.exp_status.checked)
		f_query_add_mod.document.priority_form.exp_status.value = 'Y'
	else
		f_query_add_mod.document.priority_form.exp_status.value = 'N'

	var fields = new Array();
	fields[0]= f_query_add_mod.document.priority_form.priority_code;

	var chkFields = new Array();
	chkFields[0]= f_query_add_mod.document.priority_form.priority_code;
	chkFields[1]= f_query_add_mod.document.priority_form.long_desc;
	chkFields[2]= f_query_add_mod.document.priority_form.short_desc;

	if(f_query_add_mod.document.priority_form.exp_status.checked == true)
		chkFields[3]= f_query_add_mod.document.priority_form.exp_day;

	var chkNames = new Array ();
	chkNames[0] = getLabel('Common.code.label','common');
	chkNames[1] = getLabel('Common.longdescription.label','common');
	chkNames[2] = getLabel('Common.shortdescription.label','common');

	if(f_query_add_mod.document.priority_form.exp_status.checked == true)
	 {
		chkNames[3] = getLabel('Common.ExpiryPeriod.label','common');
	 }

	var names = new Array (	getLabel('Common.PriorityCode.label','common'));
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame =frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
  
  	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
  	{ 
		if(f_query_add_mod.checkFieldsofMst( chkFields, chkNames, messageFrame)) 
		{
		 if(f_query_add_mod.document.priority_form.exp_status.disabled == true)
			f_query_add_mod.document.priority_form.exp_status.disabled = false;

			f_query_add_mod.document.priority_form.submit();
		 }	
	}

  }

function onSuccess() 
{
	f_query_add_mod.document.location.reload();
}

function reset()
{
  if(f_query_add_mod.document.forms[0].name == "priority_form")
  {
	  if(f_query_add_mod.document.forms[0].mode.value == "insert")
	  {
		f_query_add_mod.document.priority_form.reset();
		f_query_add_mod.document.priority_form.priority_code.focus();
		f_query_add_mod.document.priority_form.exp_day.disabled =true;
		f_query_add_mod.document.priority_form.days_hours.disabled=true;
		f_query_add_mod.document.priority_form.colorTxt.style.background = "white";
		f_query_add_mod.document.priority_form.star.style.visibility = 'hidden';
	  }
	  else
	  {
		f_query_add_mod.document.location.reload();
		
		f_query_add_mod.document.priority_form.exp_day.value = f_query_add_mod.document.priority_form.hid_exp_day.value;
												
		f_query_add_mod.document.priority_form.colorTxt.style.background = f_query_add_mod.document.priority_form.update_color_val.value;

		f_query_add_mod.document.priority_form.color_scheme.value = f_query_add_mod.document.priority_form.update_color_val.value;
		if(f_query_add_mod.document.priority_form.exp_status.checked)
   		f_query_add_mod.document.priority_form.star.style.visibility = 'visible';
		else
		f_query_add_mod.document.priority_form.star.style.visibility = 'hidden';
	  }
  }	
  else
	if(f_query_add_mod.document.forms[0].name == "query_form")
	{
		f_query_add_mod.document.query_form.reset() ; 
	}
}

function change() 
{
	if(priority_form.exp_status.checked)
	{	
		priority_form.exp_status.value = 'Y'
		priority_form.days_hours.disabled = false;
		priority_form.exp_day.disabled = false;
		priority_form.star.style.visibility = 'visible';
	}
	else
	{
		priority_form.exp_status.value = 'N'
		priority_form.days_hours.disabled = true;
		priority_form.exp_day.disabled = true;
		priority_form.star.style.visibility = 'hidden';
		priority_form.days_hours.options[0].selected = true;
		priority_form.exp_day.value = '';
	}
} 

//Moved from addModifyPriority.jsp
function CheckZeroVal(obj) 
{
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{
        return true;
    }
    else 
	{
        if ( obj.value.length > 0 && obj.value==0) 
		{
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

// Added by SRIDHAR R on 27 & 28 APR 2004
// This function will call the PriorityColor.jsp page in a modal window & fetch the Color Code as the retVal..
async function showModal()
{
	var retVal = 	new String();
	var dialogHeight= "1000px" ;
	var dialogTop = "150" ;
	var dialogWidth	= "1200px" ;
	var status = "no";
	var arguments = "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop:" + dialogTop ;
	var retVal = await window.showModalDialog("../../eIP/jsp/PriorityColor.jsp",arguments,features);
	if(retVal != null)
	{
	
		document.forms[0].color_scheme.value = retVal;
		document.forms[0].colorTxt.style.background = retVal;
	}
}

// This function will set the value of ColorCode value as the background of text in the update mode..

function setColor(colorCode,mode)
{
	if(mode == "update" && colorCode != "")
	{
		document.forms[0].colorTxt.style.background = colorCode;
		document.forms[0].color_scheme.value = colorCode;
	}
}

// This function will set the value of Effective Status as "E" if enabled & "D" if Disabled & make other fields Enabled or Disabled depending on eff_stsus value..

function chkStatus(obj)
{
	if(obj.checked == true)
	{
		obj.value = 'E';
		document.forms[0].long_desc.readOnly = false; 
		document.forms[0].short_desc.readOnly = false; 
	}
	else
	{
		obj.value ='D';
		document.forms[0].long_desc.readOnly = true; 
		document.forms[0].short_desc.readOnly = true; 
	}
	
	if(priority_form.exp_status.checked == true)
		priority_form.exp_status.value = 'Y'
	else
		priority_form.exp_status.value = 'N'
}


function disableFields(obj,expStat)
{
	if(document.forms[0].mode.value == 'update')
	{
		if(obj == 'D')
			priority_form.days_hours.disabled = true;
		else
			priority_form.days_hours.disabled = false;

		if(expStat == 'Y')
			priority_form.exp_status.checked = true;
		else
		{
			priority_form.exp_status.checked = false;
			priority_form.days_hours.disabled = true;
		}
	}
}

function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyGenderGroup.jsp" ;
}

/*function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}*/

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryGenderGroup.jsp" ;
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }



function apply()
{
		var messageFrame = frames[2]; 
		if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array ( f_query_add_mod.document.gender_form.gender_group_code );
	var names  =  new Array ( getLabel("Common.code.label","Common"));
//	var messageFrame = parent.frames[1].frames[2]; 


	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){

		var bool=true;
		var min=f_query_add_mod.document.gender_form.min_age.value
		var max=f_query_add_mod.document.gender_form.max_age.value

			var fields = new Array ( f_query_add_mod.document.gender_form.gender_group_code,
							f_query_add_mod.document.gender_form.long_desc,
							f_query_add_mod.document.gender_form.short_desc,
							f_query_add_mod.document.gender_form.min_age,
							f_query_add_mod.document.gender_form.max_age
							);

		var names = new Array ( getLabel("Common.code.label","Common"),
								getLabel("Common.longdescription.label","Common"),
								getLabel("Common.shortdescription.label","Common"),
								getLabel("Common.MinimumAge.label","Common"),
								getLabel("eAM.MaximumAge.label","AM"),
								getLabel("Common.AgeUnit.label","Common"),
								getLabel("Common.AgeUnit.label","Common")
								);
		if(f_query_add_mod.document.gender_form.function_name.value=="modify")
		{
			if(f_query_add_mod.document.gender_form.checked1.value!="checked" )
			{
				fields[5]=f_query_add_mod.document.gender_form.age_unit;
				fields[6]=f_query_add_mod.document.gender_form.age_unit1;
			}

			else
			{
				fields[5]=f_query_add_mod.document.gender_form.age_unit.options[f_query_add_mod.document.gender_form.age_unit.options.selectedIndex]
				fields[6]=f_query_add_mod.document.gender_form.age_unit1.options[f_query_add_mod.document.gender_form.age_unit1.options.selectedIndex]
				 bool=chkage(min,max)
			}
		}

		else
		{
			fields[5]=f_query_add_mod.document.gender_form.age_unit.options[f_query_add_mod.document.gender_form.age_unit.options.selectedIndex]
			fields[6]=f_query_add_mod.document.gender_form.age_unit1.options[f_query_add_mod.document.gender_form.age_unit1.options.selectedIndex]
			 bool=chkage(min,max)
		}


		if(f_query_add_mod.checkFieldsofMst(fields, names,messageFrame))
		{
			if(bool==true)
			{
				f_query_add_mod.document.gender_form.submit();
				var fn_status = f_query_add_mod.document.gender_form.function_name.value ;
				if(fn_status == "insert") {}

			}
		}
	}
}

function onSuccess()
{
	/*if(f_query_add_mod.document.gender_form.function_name.value =="insert")
	{
	f_query_add_mod.document.gender_form.gender_group_code.value	= "" ;
	f_query_add_mod.document.gender_form.short_desc.value	= "" ;
	f_query_add_mod.document.gender_form.long_desc.value		= "" ;
	f_query_add_mod.document.gender_form.gender.options[0].selected	= true ;
	f_query_add_mod.document.gender_form.age_unit.options[0].selected	= true ;
	f_query_add_mod.document.gender_form.min_age.value		= "" ;
	f_query_add_mod.document.gender_form.max_age.value		= "" ;
	f_query_add_mod.document.gender_form.eff_status.checked=true;
	}
	*/
	f_query_add_mod.location.reload();
	
}

function reset()
{

			if(f_query_add_mod.document.forms[0])
				f_query_add_mod.document.location.reload();
			

}

function chkage(min,max)
{
var errors="";
var cond=false;

var au=f_query_add_mod.document.gender_form.age_unit.options[ f_query_add_mod.document.gender_form.age_unit.options.selectedIndex].value
var au1=f_query_add_mod.document.gender_form.age_unit1.options[ f_query_add_mod.document.gender_form.age_unit1.options.selectedIndex].value

if(au=="D")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
	//		errors=errors+ "APP-AM0004  Age range should be between 1 and 90 for Age Unit - Day"
			errors=errors+ getMessage("AM0130","AM");
			cond=false
		}
	}
}

if(au=="M")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0131","AM");
			cond=false
		}
	}
}

if(au=="Y")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0132","AM");
			cond=false
		}
	}
}
if(au=="H")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0135","AM");
			cond=false
		}
	}
}
if(au=="N")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0134","AM");
			cond=false
		}
	}
}
if(au=="S")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0133","AM");
			cond=false
		}
	}
}
if(au1=="D")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
	//		errors=errors+ "APP-AM0004  Age range should be between 1 and 90 for Age Unit - Day"
			errors=errors+ getMessage("AM0130","AM");
			cond=false
		}
	}
}

if(au1=="M")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0131","AM");
			cond=false
		}
	}
}

if(au1=="Y")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<1 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0132","AM");
			cond=false
		}
	}
}
if(au1=="H")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0135","AM");
			cond=false
		}
	}
}
if(au1=="N")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0134","AM");
			cond=false
		}
	}
}
if(au1=="S")
{
	if(!(isNaN(min) || isNaN(max)))
	{
		cond=true;
		min=parseInt(min)
		max=parseInt(max)

		if(min<0 || min>999 || max<1 || max>999)
		{
			errors=errors+ getMessage("AM0133","AM");
			cond=false
		}
	}
}

  
	  if(au!=au1)
	  {
		  var errors="";
		errors= errors + getMessage("AM0136","AM") + "<br>" ;
		bool=false
	  }
	else if(min>=max)
	{
		var errors="";
		errors= errors + getMessage("AM0137","AM") + "<br>" ;
		bool=false
	}

	else
		bool = true;
	 /*  if((au1=='D')&&(au=='D'))
	  {
	if(min>=max)
	{
		var errors="";
		errors= errors + "APP-AM0001   Maximum Age should greater than Minimum Age" + "<br>" ;
		bool=false
	}
	  }
	  if((au1=='M')&&(au=='M'))
	  {
	if(min>=max)
	{
		var errors="";
		errors= errors + "APP-AM0001   Maximum Age should greater than Minimum Age" + "<br>" ;
		bool=false
	}
	  }
	   if((au1=='Y')&&(au=='Y'))
	  {
	if(min>=max)
	{
		var errors="";
		errors= errors + "APP-AM0001   Maximum Age should greater than Minimum Age" + "<br>" ;
		bool=false
	}
	  }
	   if((au1=='H')&&(au=='H'))
	  {
	if(min>=max)
	{
		var errors="";
		errors= errors + "APP-AM0001   Maximum Age should greater than Minimum Age" + "<br>" ;
		bool=false
	}
	  }
	   if((au1=='N')&&(au=='N'))
	  {
	if(min>=max)
	{
		var errors="";
		errors= errors + "APP-AM0001   Maximum Age should greater than Minimum Age" + "<br>" ;
		bool=false
	}
	  }
	   if((au1=='S')&&(au=='S'))
	  {
	if(min>=max)
	{
		var errors="";
		errors= errors + "APP-AM0001   Maximum Age should greater than Minimum Age" + "<br>" ;
		bool=false
	}
	  }
*/
	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
	return bool;
}

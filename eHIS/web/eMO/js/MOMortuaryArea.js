function create() {
	f_query_add_mod.location.href = "../../eMO/jsp/addModifyMortuaryArea.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMO/jsp/MortuaryAreaQueryCriteria.jsp";
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


function checkspecchar()
{

}

function apply() {



	 if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	

	
	f_query_add_mod.document.forms[0].area_code_val.value = f_query_add_mod.document.forms[0].area_code.value;

	f_query_add_mod.document.forms[0].long_desc_val.value	= f_query_add_mod.document.forms[0].long_desc.value;

	f_query_add_mod.document.forms[0].short_desc_val.value	= f_query_add_mod.document.forms[0].short_desc.value;

    f_query_add_mod.document.forms[0].Capacity_val.value	= f_query_add_mod.document.forms[0].Capacity.value;

	f_query_add_mod.document.forms[0].eff_status_val.value		= f_query_add_mod.document.forms[0].eff_status.value;




	var fields = new Array (f_query_add_mod.document.MortuaryArea_form.area_code,
    f_query_add_mod.document.MortuaryArea_form.long_desc,
    f_query_add_mod.document.MortuaryArea_form.short_desc,f_query_add_mod.document.MortuaryArea_form.Capacity);
    
																
	// here write fields which cannot be blank  and add them in "var fields=new array() "
	var names = new Array (getLabel('Common.code.label','Common'),getLabel('Common.longdescription.label','Common'),getLabel('Common.shortdescription.label','Common'),getLabel('eMO.Capacity.label','MO'));
	
	// For special Characters
		
	var fields1 = new Array 
		(f_query_add_mod.document.MortuaryArea_form.area_code,f_query_add_mod.document.MortuaryArea_form.Capacity);

	var names1 = new Array (getLabel('Common.code.label','Common'),getLabel('eMO.Capacity.label','MO'));
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
	

	// for checkFields check ecommon/commom.js
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	 {
		if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
			{
				f_query_add_mod.document.MortuaryArea_form.Area_Type.disabled=false;
				f_query_add_mod.document.MortuaryArea_form.submit();
			}
				
			
	 }





	
}

function onSuccess() 
	
	{


	 if(f_query_add_mod.document.MortuaryArea_form.mode.value=="INSERT")
	 {
		
		f_query_add_mod.document.MortuaryArea_form.area_code.value = "";
		f_query_add_mod.document.MortuaryArea_form.long_desc.value = "";
		f_query_add_mod.document.MortuaryArea_form.short_desc.value = "";
		f_query_add_mod.document.MortuaryArea_form.Capacity.value = "";
		f_query_add_mod.document.MortuaryArea_form.Area_Type.options[2].selected = true;
		f_query_add_mod.document.MortuaryArea_form.eff_status.checked = true;
		f_query_add_mod.document.MortuaryArea_form.area_code.focus();
	 }
	 else
		f_query_add_mod.document.location.reload();
	
}

function reset() {

	if(f_query_add_mod.document.forms[0])
	{	
		f_query_add_mod.document.forms[0].reset() ;

		if(f_query_add_mod.document.forms[0].AREA_TYPE.value=='R')
		{
				f_query_add_mod.document.forms[0].Area_Type.options[1].selected = true;
		}
		else if(f_query_add_mod.document.forms[0].AREA_TYPE.value=='P')
		{
			f_query_add_mod.document.forms[0].Area_Type.options[0].selected = true;
		}
		else if(f_query_add_mod.document.forms[0].AREA_TYPE.value=='S')
		{
		f_query_add_mod.document.forms[0].Area_Type.options[2].selected = true;
		}
		else if(f_query_add_mod.document.forms[0].AREA_TYPE.value=='O')
		{
		f_query_add_mod.document.forms[0].Area_Type.options[3].selected = true;
		}
		else
		{
			f_query_add_mod.document.forms[0].Area_Type.options[2].selected = true;
		}
	}

}


  function checkzero(obj)
{
  capacitycount=document.forms[0].capacitycount.value
  if(obj.value!=""){
  if(CheckForNumber(obj.value))
	  {
  if(eval(obj.value)<=0)
	{
		alert(getMessage('CAPACITY_GREATER_ZERO','MO'));
	document.forms[0].Capacity.focus();
	return false;
	}

	if(eval(obj.value)<capacitycount)
	{
	alert(getMessage('CAPACITY_GREATER_LOCATION','MO'));
	document.forms[0].Capacity.focus();
	}
	
	}else
	  {
      obj.focus()
		  return false;
	  }

  }

}
function setarea(mode)
{
	if(mode=="INSERT")
	document.forms[0].Area_Type.options[2].selected = true;
}
  
  function chkValue(obj)
   {
	  if(obj.checked==true)
       {
		  if(obj.name=='eff_status')
		   {
				obj.checked=true;
				obj.value='E';
           }
		   else
		   {
				obj.checked=true;
				obj.value='Y';
		   }
       }
      else
      {
           if(obj.name=='eff_status')
		   {
				obj.checked=false;
				obj.value='D';
           }
		   else
		   {
				 obj.checked=false;
				 obj.value='N';
		   }
       }

   }



   function changeCase(obj)
   {
		document.forms[0].MortuaryArea_form.value=obj.value.toUpperCase();
	}

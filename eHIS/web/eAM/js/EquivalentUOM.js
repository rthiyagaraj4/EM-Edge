 function create()
  {
		
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyEquivalentUOM.jsp" ;
  }

function query()
  {
  f_query_add_mod.location.href ="../../eAM/jsp/EquivalentUOMQueryCriteria.jsp" ;
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

	//var messageFrame = parent.frames[1].frames[2]; 
	
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array(
				f_query_add_mod.document.EquivalentUOM_form.uom,
	 	     	f_query_add_mod.document.EquivalentUOM_form.Equom,
				f_query_add_mod.document.EquivalentUOM_form.conversion
			      );
	var names = new Array (	getLabel('Common.uom.label','Common')+" "+getLabel('Common.code.label','Common'),
				getLabel('Common.EquivalentUOM.label','Common')+" "+getLabel('Common.code.label','Common'),
				getLabel('Common.ConversionFactor.label','Common'))

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		
		var uomselect = f_query_add_mod.document.EquivalentUOM_form.uom.value;
		var equomselect = f_query_add_mod.document.EquivalentUOM_form.Equom.value;
		if(uomselect == equomselect)
		{
			var msg = f_query_add_mod.getMessage("SAME_UOM_NOT_SEL","AM");
			f_query_add_mod.document.EquivalentUOM_form.Equom.focus();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "+msg
		}
		else
			f_query_add_mod.document.EquivalentUOM_form.submit();
		
	}
   
  }

function onSuccess()
{
	f_query_add_mod.location.reload();
}
function reset()
{
	/*if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } */
    if(f_query_add_mod.document.forms[0].name == "EquivalentUOM_form")
    {
         var function_name=f_query_add_mod.document.EquivalentUOM_form.function1.value;
		 if(function_name=='modify')
		 {
			f_query_add_mod.document.location.reload() ;
			//f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.EquivalentUOM_form.conversion.focus();
		 }
		 else
		 {
			//f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.location.reload() ;
			f_query_add_mod.document.EquivalentUOM_form.uom.focus();
		 }
	}     
    else
         f_query_add_mod.document.location.reload() ;
      //   f_query_add_mod.document.query_form.reset() ;
}
function page_ref(obj){
	var function_name=parent.frames[1].document.forms[0].function_name.value;
	if(function_name=='modify'){
		
			var uom=parent.frames[1].document.forms[0].uom.value;
			parent.frames[1].location.href = "../../eAM/jsp/addModifyEquivalentUOM.jsp?allow_alter=Y&Code="+uom ;

		
	}
}

function deleterecord()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(f_query_add_mod.document.forms[0].function_name.value == 'modify')
	{
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
		{
			f_query_add_mod.document.forms[0].function1.value = 'delete';
			f_query_add_mod.document.forms[0].submit();
			f_query_add_mod.location.href ="../../eCommon/html/blank.html";
		
		}
		else
		   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
	}	
	else
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="
	}
}

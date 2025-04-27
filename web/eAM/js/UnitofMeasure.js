 function create()
  {
		
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyUnitofMeasure.jsp" ;
  }

function query()
  {
  f_query_add_mod.location.href ="../../eAM/jsp/UnitofMeasureQueryCriteria.jsp" ;
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
	var fields = new Array (f_query_add_mod.document.UnitOfMeasure_form.Code);
	
	var names  =  new Array (getLabel('Common.code.label','Common'));
	
	
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  

	var fields = new Array(
				f_query_add_mod.document.UnitOfMeasure_form.Code,
	 	     	f_query_add_mod.document.UnitOfMeasure_form.long_desc,
				f_query_add_mod.document.UnitOfMeasure_form.short_desc				
			    );



	var names = new Array (getLabel('Common.code.label','Common'),
				getLabel('Common.longdescription.label','Common'),
				getLabel('Common.shortdescription.label','Common')
			     )

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		f_query_add_mod.document.UnitOfMeasure_form.purchase  .value=(f_query_add_mod.document.UnitOfMeasure_form.purchaseyn.checked)?"Y":"N";	
		f_query_add_mod.document.UnitOfMeasure_form.sale  .value=(f_query_add_mod.document.UnitOfMeasure_form.saleyn.checked)?"Y":"N";
		f_query_add_mod.document.UnitOfMeasure_form.stock  .value=(f_query_add_mod.document.UnitOfMeasure_form.stockyn.checked)?"Y":"N";
		f_query_add_mod.document.UnitOfMeasure_form.dosage  .value=(f_query_add_mod.document.UnitOfMeasure_form.dosageyn.checked)?"Y":"N";
		f_query_add_mod.document.UnitOfMeasure_form.quantity  .value=(f_query_add_mod.document.UnitOfMeasure_form.quantityyn.checked)?"Y":"N";
		f_query_add_mod.document.UnitOfMeasure_form.strength  .value=(f_query_add_mod.document.UnitOfMeasure_form.strengthyn.checked)?"Y":"N";

		f_query_add_mod.document.UnitOfMeasure_form.submit();
	}
      }
  }

function onSuccess()
 {
f_query_add_mod.location.reload() ;
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
    if(  f_query_add_mod.document.forms[0].name == "UnitOfMeasure_form")
    {
        var function_name=f_query_add_mod.document.UnitOfMeasure_form.function_name.value;
		 if(function_name=='modify')
		 {
			 f_query_add_mod.location.reload() ;
			//f_query_add_mod.document.forms[0].reset() ;
			//f_query_add_mod.document.UnitOfMeasure_form.long_desc.focus();
		 }
		 else
		 {
			f_query_add_mod.document.location.reload() ;
			//f_query_add_mod.document.forms[0].reset() ;
			f_query_add_mod.document.UnitOfMeasure_form.Code.focus();
			f_query_add_mod.document.UnitOfMeasure_form.quantity.disabled=false;
			f_query_add_mod.document.UnitOfMeasure_form.strength.disabled=false;

			//added on 25-11-2003 by dhanasekaran
			f_query_add_mod.document.UnitOfMeasure_form.quantityyn.checked=false;
			f_query_add_mod.document.UnitOfMeasure_form.strengthyn.checked=false;
			f_query_add_mod.document.UnitOfMeasure_form.quantityyn.disabled=false;
			f_query_add_mod.document.UnitOfMeasure_form.strengthyn.disabled=false;
			//end addition
		 }
    }     
    else
         f_query_add_mod.document.location.reload() ;
        // f_query_add_mod.document.query_form.reset() ;
    }


function page_ref(obj){
	var function_name=parent.frames[1].document.forms[0].function_name.value;
	if(function_name=='modify'){
		//if(obj.checked==true){
			var Code=parent.frames[1].document.forms[0].Code.value;
			parent.frames[1].location.href = "../../eAM/jsp/addModifyUnitofMeasure.jsp?allow_alter=Y&Code="+code ;

		//}
	}
}

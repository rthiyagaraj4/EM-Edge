 function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyBlockingType.jsp" ; 
  } 

function query() 
  {
	f_query_add_mod.location.href ="../../eIP/jsp/BlockingTypeQueryCriteria.jsp" ;
  }

function apply()
  {
  if(f_query_add_mod.document.Blocking_Type_Form!=null)
	{
  	var fields = new Array (f_query_add_mod.document.Blocking_Type_Form.blocking_type_code);
  	
  	var names  =  new Array ( getLabel('Common.code.label','common') );
  	
  	//var messageFrame = parent.frames[1].frames[2]; 
  	var messageFrame = frames[2]; 
  	
  	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
  
  	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  
	var fields = new Array(
				f_query_add_mod.document.Blocking_Type_Form.blocking_type_code,
	 	     	        f_query_add_mod.document.Blocking_Type_Form.long_desc,
				f_query_add_mod.document.Blocking_Type_Form.short_desc
			      );

	var names = new Array (	getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common')
			      )

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{     
		if(f_query_add_mod.document.Blocking_Type_Form.bed_block_period_max.value=="")
		{
			f_query_add_mod.document.Blocking_Type_Form.bed_block_period_max_type.value="";
		}

		for(var i=0; i<f_query_add_mod.document.Blocking_Type_Form.length;i++)
		{
			if(f_query_add_mod.document.Blocking_Type_Form.elements[i].disabled == true)
			{
				f_query_add_mod.document.Blocking_Type_Form.elements[i].disabled =false;
			}
		}							

		f_query_add_mod.document.Blocking_Type_Form.submit();
	}
    }
	  }
	  else
	  {
		frames[0].location.reload();
		return false;
	  }
  }

function onSuccess() 
 {
	 if(f_query_add_mod.document.Blocking_Type_Form.function_name.value=="insert"){
	  	 f_query_add_mod.document.Blocking_Type_Form.reset() ;
		 f_query_add_mod.document.Blocking_Type_Form.blocking_type_code.focus() ;
	 }
	 else
		f_query_add_mod.document.location.reload();
 }

function reset() 
{
   if(f_query_add_mod.document.forms[0]!=null)
   {
    if(  f_query_add_mod.document.forms[0].name == "Blocking_Type_Form") 
	{
         f_query_add_mod.document.location.reload();
         f_query_add_mod.document.Blocking_Type_Form.blocking_type_code.focus() ;
    }
    else 
         f_query_add_mod.document.query_form.reset() ;
   }	
}

function callChk(obj,val)
{
	if(val=="D")
		obj.checked=!obj.checked
}

//functions moved from addModifyBlockingType.jsp


function focusTxt()
{
	Blocking_Type_Form.blocking_type_code.focus();
}	

function Validate_Char(event)
{	
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function CheckZeroVal(obj) 
{
	if ( obj.value.length > 0 && obj.value==0) 
	{
	alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
	obj.select();
	obj.focus();
	return false;
	}
}

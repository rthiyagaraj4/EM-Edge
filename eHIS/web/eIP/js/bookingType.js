function create() 
  {
	f_query_add_mod.location.href = "../../eIP/jsp/addModifyBookingType.jsp?function_id="+document.forms[0].function_id.value+" " ; 
  } 

function query() 
  {
	f_query_add_mod.location.href ="../../eIP/jsp/BookingTypeQueryCriteria.jsp?function_id="+document.forms[0].function_id.value+"" ;
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
	if (! (checkIsValidForProceed()))
	{
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else
	{
	
	var fields = new Array (f_query_add_mod.document.Booking_Type_Form.booking_type_code);

	var names  =  new Array ( getLabel('Common.code.label','common') );

	var messageFrame = frames[2]; 

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  

	var fields = new Array(
				f_query_add_mod.document.Booking_Type_Form.booking_type_code,
	   	       		f_query_add_mod.document.Booking_Type_Form.long_desc,
				f_query_add_mod.document.Booking_Type_Form.short_desc,
				f_query_add_mod.document.Booking_Type_Form.bkgn_type_ind
			      );

	var names = new Array (	getLabel('Common.code.label','common'),
				getLabel('Common.longdescription.label','common'),
				getLabel('Common.shortdescription.label','common'),
				getLabel('Common.booking.label','common')+" "+getLabel('Common.INDICATOR.label','common')
			      )

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{     
		f_query_add_mod.document.Booking_Type_Form.submit();
	}
     }
	}
 }

function onSuccess() 
{
	 if(f_query_add_mod.document.Booking_Type_Form.function_name.value=="insert"){
	  	 f_query_add_mod.document.Booking_Type_Form.reset() ;
	    f_query_add_mod.document.Booking_Type_Form.booking_type_code.focus() ;
	 }
	 else
		f_query_add_mod.document.location.reload();
}

function reset() 
 {

    if(  f_query_add_mod.document.forms[0].name == "Booking_Type_Form") 
	{
		     f_query_add_mod.document.location.reload();
			 f_query_add_mod.document.Booking_Type_Form.booking_type_code.focus() ;
        } 
    else 
         f_query_add_mod.document.query_form.reset() ;
 }

function check(obj)
{
		if(obj.checked == true)
			obj.value	="E";
		else
			obj.value = "D";
}
function CheckForSpecCharsCode(event)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

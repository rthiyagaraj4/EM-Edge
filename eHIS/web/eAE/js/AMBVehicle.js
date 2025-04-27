var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var flagChk = false;
var currentTab ="";


/*****************initailisation*************************************/
function intialisation(){
 currentTab ="";
 resultGlobal = false;
 messageGlobal = "" ;
 flagGlobal = true;
 flagChk = false;
}
/*******************************************************************/

function create()
{
	 	intialisation();
	f_query_add_mod.location.href='../../eAE/jsp/AMBVehicleAddModify.jsp?mode=insert';
}

function query()
{
	
		f_query_add_mod.location.href ="../../eAE/jsp/AMBVechileQueryCriteria.jsp" ;
}

function apply()
 {
	 if (! checkIsValidForProceed() ) {

			//var message  = getMessage("NOT_VALID","AE");	
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
			return false ;
		}
	var mode = f_query_add_mod.document.forms[0].mode
	var fields = new Array (f_query_add_mod.document.forms[0].amb_vehicle_type,
							f_query_add_mod.document.forms[0].amb_veh_id,
							f_query_add_mod.document.forms[0].amb_veh_desc,
							f_query_add_mod.document.forms[0].amb_veh_regnno,
							f_query_add_mod.document.forms[0].amb_mileage_uom
													
							);

	var names = new Array (getLabel("eAE.AmbulanceType.label","AE"),getLabel("Common.identification.label","Common"),getLabel("Common.description.label","Common"),getLabel("Common.registrationno.label","Common"),getLabel("eAE.OdometerUnits.label","AE")
														
							);

	if(f_query_add_mod.document.ambvehicle_form != null)
	 {
		if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
		{			
			if(mode != null)
			{
				if(mode.value=='update')
				{
	//				f_query_add_mod.document.forms[0].note_disclaimer_id1.value		= f_query_add_mod.document.forms[0].note_disclaimer_id.value
	//				f_query_add_mod.document.forms[0].note_disclaimer_desc1.value	= f_query_add_mod.document.forms[0].note_disclaimer_desc.value
	//				f_query_add_mod.document.forms[0].disclaimer_text1.value		= f_query_add_mod.document.forms[0].disclaimer_text.value					
				}
			}

			f_query_add_mod.document.ambvehicle_form.submit();
		
		}
	 }
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		
		 
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1) && (url.indexOf("blank")==-1) )
				return true;
		else
				return false;
} 

function onSuccess()
{

	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href="../../eAE/jsp/AMBVehicleAddModify.jsp?mode=insert";
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		//f_query_add_mod.location.href='../../eAE/jsp/AMBVehicleAddModify.jsp?mode=update&amb_veh_id='+f_query_add_mod.document.forms[0].amb_veh_id.value;
		f_query_add_mod.document.location.reload();
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{   if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.location.reload();

}
function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	
//	if(mode == 'update')
	{
		
		if(objCheck.checked== true)
			document.forms[0].eff_status.value='E'
		else
			document.forms[0].eff_status.value='D'
	}
}


function chopText(elem,limit)
	{
		if(elem.value.length>limit){
		elem.value=elem.value.substring(0,limit);
		alert(getMessage("AE_AMB_NOT_MORE_THAN_TWO_THOUSAND","AE"));
		
		}
	}

function showCalendarValidate(str){
	var flg = showCalendar(str,null);
	document.getElementById(str).focus();
    return flg;
}

function fillNext()
{
	var nxtcaseNo	=	document.getElementById("amb_start_case_no").value;
	document.getElementById("amb_next_case_no").value	=	nxtcaseNo;
}

function AMBCheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*-';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
function effDateValidation(obj){
	curdate = document.forms[0].curDate;
	var msg=getMessage("START_DATE_GREATER_SYSDATE",'Common');
	if(doDateCheckAlert(obj,curdate) == false	 ) 
	{
		obj.focus();
		obj.select();
		alert(msg);
	}
}

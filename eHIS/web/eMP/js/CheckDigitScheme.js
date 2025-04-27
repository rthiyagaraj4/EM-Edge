 function create()
  {
	f_query_add_mod.location.href = "../../eMP/jsp/AddModifyCheckDigitScheme.jsp" ;
  }

function query()
  {

  f_query_add_mod.location.href ="../../eMP/jsp/CheckDigitSchemeQueryCriteria.jsp" ;
  }

function apply()
  {

if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	
	var fields = new Array(
				f_query_add_mod.document.CheckDigitScheme_form.scheme_id,
	 	     	        f_query_add_mod.document.CheckDigitScheme_form.scheme_name,
				f_query_add_mod.document.CheckDigitScheme_form.program_name
			      );

	var names = new Array (	getLabel('Common.identification.label','common'),
				getLabel('Common.name.label','common'), getLabel('Common.Function.label','common')
			      )

	//For Restricting Special Characters in Check Digit Scheme code
	var specialCharfields = new Array (f_query_add_mod.document.CheckDigitScheme_form.scheme_id);
	var specialChars = new Array ( getLabel('Common.identification.label','common'));

	if(f_query_add_mod.SpecialCharCheck(specialCharfields,specialChars,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")) 
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			f_query_add_mod.document.CheckDigitScheme_form.submit();
		}
	}
  }

function onSuccess()
 {
	f_query_add_mod.location.reload() ;
 }

function reset()
   {

       f_query_add_mod.document.forms[0].reset() ;
    }

//Added on 2/21/2005

function Change1()
{
	if ( CheckDigitScheme_form.eff_status.checked == true)
		CheckDigitScheme_form.eff_status.value="E";
	else
		CheckDigitScheme_form.eff_status.value="D";
}
function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

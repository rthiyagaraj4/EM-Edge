function reset() 
  {if(f_query_add_mod.document.forms[0]!=null)
     f_query_add_mod.document.location.reload() ;
  }

function create() {

	f_query_add_mod.location.href = "../../eQA/jsp/addModifyQAComplicationsForIndicator.jsp" ;
}



function query()
{
f_query_add_mod.location.href = "../../eQA/jsp/QAComplicationsForIndicatorQueryCriteria.jsp" ;

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

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
 	var fields = new Array  (f_query_add_mod.document.QA_Complications_Indicator.indicator_code,f_query_add_mod.document.QA_Complications_Indicator.complication_code,f_query_add_mod.document.QA_Complications_Indicator.complication_desc);
	var names = new Array ("Indicator ID","Complication Code","Description");
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
  		{
			f_query_add_mod.document.QA_Complications_Indicator.submit();
		}
}
}

function populateDesc()
{
	var indicator_id = 	parent.f_query_add_mod.document.QA_Complications_Indicator.indicator_code.value;
	if(indicator_id!='')
	{
	HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eQA/jsp/QAPopulateIndicatorDesc.jsp'><input type='hidden' name='indicator_id' id='indicator_id' value='"+indicator_id+"'></form></BODY></HTML>";
    parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    if(parent.blankFrame.document.form1!=null)
	parent.blankFrame.document.form1.submit();
	}
	
}
function onSuccess() 
 {
   f_query_add_mod.document.location.reload();
 }






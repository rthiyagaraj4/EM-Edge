function create() {
	f_query_add_mod.location.href = "../../eOP/jsp/addModifyOpMedSum.jsp?type=C" ;
}

function query() {
	f_query_add_mod.location.href ="../../eOP/jsp/OpMedSumQueryCriteria.jsp?function=OpMedSum" ;
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

function apply() {

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array ( f_query_add_mod.document.OpMedSum_form.oplocation,
	 f_query_add_mod.document.OpMedSum_form.opvisit);
	var names = new Array (getLabel("Common.Location.label","Common"),getLabel("Common.visittype.label","Common"));


	if(f_query_add_mod.document.OpMedSum_form.sqlfunc.value=="insert") {
		if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
			if(CheckNumber(f_query_add_mod.document.OpMedSum_form.maxenct) && 
			  CheckNumber(f_query_add_mod.document.OpMedSum_form.pimonths)) {
				f_query_add_mod.document.OpMedSum_form.submit();
				var fn_status = f_query_add_mod.document.OpMedSum_form.sqlfunc.value;
				f_query_add_mod.document.OpMedSum_form.sqlfunc.value="insert";
			}
		}
	}
	else if(f_query_add_mod.document.OpMedSum_form.sqlfunc.value=="modify") {
		if(CheckNumber(f_query_add_mod.document.OpMedSum_form.maxenct) && 
		  CheckNumber(f_query_add_mod.document.OpMedSum_form.pimonths)) {
			f_query_add_mod.document.OpMedSum_form.submit();
			var fn_status = f_query_add_mod.document.OpMedSum_form.sqlfunc.value;
		}
	}
}

function onSuccess() {
	      
	if(f_query_add_mod.document.OpMedSum_form)
	{
		var status=f_query_add_mod.document.OpMedSum_form.sqlfunc.value;
		if(status == "insert" || status == "modify") 
		{
			f_query_add_mod.document.OpMedSum_form.sqlfunc.value="insert";
			if(status == "insert") 
			{
				f_query_add_mod.document.OpMedSum_form.oplocation.value="";
				f_query_add_mod.document.OpMedSum_form.opvisit.value="";
				f_query_add_mod.document.OpMedSum_form.pimonths.value="";
				f_query_add_mod.document.OpMedSum_form.maxenct.value="";
				f_query_add_mod.document.OpMedSum_form.openct.value="O";
				f_query_add_mod.document.OpMedSum_form.chklocation.checked=false;
				f_query_add_mod.document.OpMedSum_form.chklocation.value="N";
				f_query_add_mod.document.OpMedSum_form.opsummary.value="0";
			}
		}
	}
}

function deleterecord()
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	var status = f_query_add_mod.document.OpMedSum_form.sqlfunc.value;
	if(status != "insert") 
	{
		if(confirm(frames[1].getMessage('DELETE_RECORD','COMMON')))
		{
			f_query_add_mod.document.OpMedSum_form.sqlfunc.value="delete";
			f_query_add_mod.document.OpMedSum_form.submit();
			f_query_add_mod.location.href="../../eCommon/html/blank.html";
			return true;
		}
		else
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}

function reset()
{
	/*if(f_query_add_mod.document.forms[0].name == "OpMedSum_form") {
				f_query_add_mod.document.OpMedSum_form.reset() ;
				ClearList(f_query_add_mod.document.forms[0].opvisit);
	}
	else f_query_add_mod.document.query_form.reset() ;*/

	if(f_query_add_mod.location.href.indexOf("OpMedSumQueryResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;

}

function populate(clinic_code) {
	HTMLVal = "<html><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/OpMedSumRepopVisit.jsp?locn_code="+clinic_code+"'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();
}

function CheckNumber(obj) {
	if(obj.value == "")
		return true;
	if(isNaN(obj.value) == false && obj.value >= 0) 
		return true;
	else {
			var error = f_query_add_mod.getMessage('ONLY_POSITIVE_NUM','SM');
  			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+error;
  			obj.select();
  			obj.focus();
  			return false;
  	}
}

function chklocn(obj){
	if(obj.value=="N")
		obj.value="Y";
	else 
		obj.value="N";
}


/********** added on 11/26/2003******************/
function ClearList(object)
{
      
	if (object)
	var length  =object.length;

	var element = f_query_add_mod.document.OpMedSum_form.document.createElement('OPTION');
    element.text= "------"+getLabel("Common.defaultSelect.label","Common")+"------";
    element.value="";
   
    for(i=1;i<length;i++)
	    object.remove(1);
   

}
/**********************************************************/


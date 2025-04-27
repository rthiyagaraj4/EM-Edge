function reset() 
  {  if(f_query_add_mod.document.forms[0]!=null)
     f_query_add_mod.document.location.reload() ;
  }

function create() {
	f_query_add_mod.location.href = "../../eQA/jsp/addModifyDiagProcForIndicator.jsp" ;
}



function query()
{
f_query_add_mod.location.href = "../../eQA/jsp/QADiagProcIndQueryCriteria.jsp" ;

}

function populateValues()
{
	var indicator_id = 	parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.qind_indicator.value;
	var mode = 	parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.mode.value;
	HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='../../eQA/jsp/QAPopulateIndicatorDesc.jsp' target=blankFrame><input type='hidden' name='indicator_id' id='indicator_id' value='"+indicator_id+"'><input type='hidden' name='popclind' id='popclind' value='popclind'><input type='hidden' name='mode' id='mode' value="+mode+"></form></BODY></HTML>";
    parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    if(parent.blankFrame.document.form1!=null)
		parent.blankFrame.document.form1.submit();
	//alert("indicator_id:"+indicator_id);
	//alert("mode:"+mode);
	//document.getElementById("mandatorydiag").style.visibility='hidden';
}

function popScheme()
{

	var diagnosis = parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.diag_proc_ind.value;

	if(diagnosis=="P"||diagnosis=="D"||diagnosis=="O")
	{
	HTMLVal = "<HTML><BODY><form name='form2' id='form2' method='post' action='../../eQA/jsp/QAPopulateSchemeType.jsp' target=blankFrame><input type='hidden' name='diagnosis' id='diagnosis' value='"+diagnosis+"'></form></BODY></HTML>";
		parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
   	if(parent.blankFrame.document.form2!=null)
	parent.blankFrame.document.form2.submit();
//added by Shashi against SCR 3067
		if (diagnosis=="O")
		{
			parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.schema_type.disabled=true;
			parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.Schemetype.src='../../eCommon/images/Blank1.gif';
		}
		else
		{
		    parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.schema_type.disabled=false;
			parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.Schemetype.src='../../eCommon/images/mandatory.gif';
		}
	}else
	{
	parent.f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.schema_type.options[0].selected=true;
	parent.blankFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
	}
  
}
// MODIFIED ON 4-10-2006
function apply()
{
	if(f_query_add_mod.document.getElementById('CLIND_CLASS').value=='S' || f_query_add_mod.document.getElementById('CLIND_CLASS').value=='M' || f_query_add_mod.document.getElementById('CLIND_CLASS').value=='A' || f_query_add_mod.document.getElementById('CLIND_CLASS').value=='N' || f_query_add_mod.document.getElementById('CLIND_CLASS').value=='O')
	{
	var fields = new Array (f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.qind_indicator,
							f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.diagproccode);
		if(f_query_add_mod.document.getElementById('CLIND_CLASS').value=='M')
		var names = new Array ( "Indicator ID","Code");
		else
		var names = new Array ( "Indicator ID","Diag/Procedure Code");

		 if(!(f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.mode.value=="U"))
		{
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

				f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.submit();

		  }
		
		}
	}
	else 
	{
		var fields = new Array (f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.qind_indicator,
							f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.diag_proc_ind,f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.schema_type,f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.diagproccode);
						
	var names = new Array ( "Indicator ID","Diag/Procedure","Scheme Type","Diag/Procedure Code");
	 if(!(f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.mode.value=="U"))
		{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		f_query_add_mod.document.QA_QIND_CLIND_DIAG_PROC.submit();

		  }
		
		}
			

	}

blankFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" ;
}

function onSuccess() 
 {
   f_query_add_mod.document.location.reload();
 }






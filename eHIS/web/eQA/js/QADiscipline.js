function funCheckBox(j)
	{
	   var chkBox=document.forms[0].EFF_STATUS;		
	   if(chkBox.checked){
	      chkBox.value='E';
		  
	    } 
	    else{
             chkBox.value='D';
			 
	    }
	     
	}
function reset() 
   { if(f_query_add_mod.document.forms[0]!=null)
     f_query_add_mod.document.location.reload() ;
  }

function create() {
	f_query_add_mod.location.href = "../../eQA/jsp/addModifyQADiscipline.jsp" ;
}



function query()
{
f_query_add_mod.location.href = "../../eQA/jsp/QADisciplineQueryCriteria.jsp" ;

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
	f_query_add_mod.document.QA_QIND_DISCIPLINE.QIND_DISCIPLINE_DESC.disabled = false;
 	var fields = new Array (f_query_add_mod.document.QA_QIND_DISCIPLINE.QIND_DISCIPLINE_ID,
							f_query_add_mod.document.QA_QIND_DISCIPLINE.QIND_DISCIPLINE_DESC);
	var names = new Array ( "Discipline Code",
												"Description");
  var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
var fields1 = new Array (f_query_add_mod.document.QA_QIND_DISCIPLINE.QIND_DISCIPLINE_ID);
	var names1 = new Array ("Discipline Code");
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
  if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page))
		{
			f_query_add_mod.document.QA_QIND_DISCIPLINE.submit();
		}
      }

}
	

function onSuccess() 
 {
   f_query_add_mod.document.location.reload();
 }





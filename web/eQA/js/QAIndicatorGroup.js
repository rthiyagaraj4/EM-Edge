function reset() 
{
  if(f_query_add_mod.document.forms[0]!=null)
  f_query_add_mod.document.location.reload() ;
}

function create()
{
   f_query_add_mod.location.href = "../../eQA/jsp/addModifyQAIndicatorGroup.jsp" ;
}

function query()
{
	f_query_add_mod.location.href = "../../eQA/jsp/QAIndicatorGroupQueryCriteria.jsp" ;
}

function apply()

{frames[1].document.forms[0].QIND_GROUP_DESC.disabled=false
 	var fields = new Array (f_query_add_mod.document.QA_QIND_GROUP.QIND_GROUP_ID,
							            f_query_add_mod.document.QA_QIND_GROUP.QIND_GROUP_DESC);
	var names = new Array ( "Group Code","Description");

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

			f_query_add_mod.document.QA_QIND_GROUP.submit();

      }

}

function onSuccess() 
{
   f_query_add_mod.document.location.reload();
}

function funCheckBox(j)
{
	var chkBox=document.forms[0].EFF_STATUS;		
	if(chkBox.checked)
	{
		chkBox.value='E';
	} 
    else
	{
        chkBox.value='D';
    }
}

// js functions moved from QAModifyIndicatorsForFacility.jsp

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

	function genYN(obj)
   {
	   if(obj.checked)
		   obj.value="Y"
	   else
		   obj.value="N";
   }

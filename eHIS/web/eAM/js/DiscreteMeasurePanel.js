function create()
{
	frames[1].location.href='../../eCommon/html/blank.html';
	f_query_add_mod.location.href='../../eAM/jsp/DiscreteMeasurePanelAddModify.jsp?mode=insert';
}


function deleterecord()
{
	if(f_query_add_mod.document.forms[0].mode.value == 'update')
	{
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))
		{
			f_query_add_mod.document.forms[0].mode.value = 'delete';
			f_query_add_mod.document.forms[0].submit();
		}
		else
		   messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "

	}
	else if(f_query_add_mod.document.forms[0].mode.value == 'insert')
	{
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='
		return false;
	}
	else{
		f_query_add_mod.location.href='../../eAM/jsp/DiscreteMeasurePanelAddModify.jsp?mode=insert';
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='
		
	}
}



function query()
{
	f_query_add_mod.location.href='../../eAM/jsp/DiscreteMeasurePanelQueryCriteria.jsp';
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
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
   	var fields = new Array (f_query_add_mod.document.forms[0].discr_msr_battery_id,
									f_query_add_mod.document.forms[0].discr_msr_id,
									f_query_add_mod.document.forms[0].order_srl_no
									);
	
						
						var names = new Array ( getLabel("Common.PanelID.label","Common"),
							 getLabel("Common.DiscreteMeasure.label","Common"),
							 getLabel("Common.OrderSrlNo.label","Common")
									);
						
							
						if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
						{		
								
							var fields1 = new Array (f_query_add_mod.document.forms[0].discr_msr_battery_id);
								
							var names1 = new Array ( getLabel("Common.PanelID.label","Common"));
							
								

							f_query_add_mod.document.forms[0].submit();		
					  	}

	}


function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else {
  		if ( obj.value.length > 0 ) 
		{
  			//alert("APP-SM0050 - Only Positive number is allowed");
			alert(getMessage("ONLY_POSITIVE_NUM","SM"));

  			obj.select();
  			obj.focus();
  		}
  	}
}



function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert"){
		f_query_add_mod.location.href='../../eAM/jsp/DiscreteMeasurePanelAddModify.jsp?mode=insert';
	}else {
	 	 f_query_add_mod.location.href='../../eAM/jsp/DiscreteMeasurePanelAddModify.jsp?mode=insert';
	}
         f_query_add_mod_dtl.location.reload();
 //f_query_add_mod.location.reload();

}


function reset()
{
	if(f_query_add_mod.document.forms[0] != null)
		{
			
			if(f_query_add_mod.document.forms[0].name=="DiscreteMeasurePanel_form")
			{
				var mode = f_query_add_mod.document.forms[0].mode.value;
				if(mode=="update")
				{
					f_query_add_mod.document.forms[0].reset();
					return;
				}
				else
				{
					f_query_add_mod.document.forms[0].reset();
					f_query_add_mod.location.href='../../eAM/jsp/DiscreteMeasurePanelAddModify.jsp?mode=insert';
				}
			}
			else
			{
				f_query_add_mod_dtl.location.href="../../eCommon/html/blank.html";	
				f_query_add_mod.location.reload();
				
			}
		}
	else{
			f_query_add_mod_dtl.location.href="../../eCommon/html/blank.html";	
			f_query_add_mod.location.reload();
			
	}
	f_query_add_mod_dtl.location.href="../../eCommon/html/blank.html";	

}

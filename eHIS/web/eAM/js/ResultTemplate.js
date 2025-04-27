function create()
{
	//alert("1");
	f_query_add_mod.location.href='../../eAM/jsp/ResultTemplateAddModify.jsp?mode=insert';
}


function deleterecord()
{
	if(f_query_add_mod.document.ResultTemplate_form.mode.value == 'update')
	{
		f_query_add_mod.document.ResultTemplate_form.mode.value = 'delete';
		f_query_add_mod.document.ResultTemplate_form.submit();
	}
}


function query()
{
	f_query_add_mod.location.href='../../eAM/jsp/ResultTemplateQueryCriteria.jsp';
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

			var fields = new Array (f_query_add_mod.document.ResultTemplate_form.result_template_id,
									f_query_add_mod.document.ResultTemplate_form.result_template_name,
									f_query_add_mod.document.ResultTemplate_form.result_template
									);
					
						var names = new Array ( getLabel("Common.TemplateID.label","Common"),
												getLabel("Common.TemplateName.label","Common"),
												getLabel("Common.ResultTemplate.label","Common")
											   );
	
		var splField = new Array (f_query_add_mod.document.ResultTemplate_form.result_template_id);
		var splFieldName = new Array (getLabel("Common.TemplateID.label","Common"));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
		{
						if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
						{			
							var fields1 = new Array (f_query_add_mod.document.ResultTemplate_form.result_template_id);
							var names1 = new Array ( getLabel("eAM.ResultTemplateID.label","AM"));
								
							f_query_add_mod.document.ResultTemplate_form.submit();		
					  	}

		}
	
	}



function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eAM/jsp/ResultTemplateAddModify.jsp?mode=insert';
	else
         f_query_add_mod.location.reload();

}


function reset()
{
	if(f_query_add_mod.document.forms[0] != null)
		{
			if(f_query_add_mod.document.forms[0].name=="ResultTemplate_form")
			{
				//f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.location.reload();
			}
			else if(f_query_add_mod.document.forms[0].name=="query_form")
			//	f_query_add_mod.document.forms[0].reset();
				f_query_add_mod.document.location.reload();

		}
	//else
			//f_query_add_mod.location.reload();
}







var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
				if(val == 'ResultTemplate')
					parent.frames[1].location.href = '../../eAM/jsp/ResultTemplate.jsp?module_id=AM&function_id=RESULT_TEMPLATE&function_name='+encodeURIComponent(getLabel("Common.ResultTemplate.label","common"))+'&function_type=F&access=YYYNN';
				
			//	if(val == 'DiscreteMeasure')
			//		parent.frames[1].location.href = '../../eAM/jsp/DiscrMeasure.jsp?module_id=AM&function_id=DISCRETE_MEASURE&function_name='+encodeURIComponent(getLabel("Common.DiscreteMeasure.label","common"))+'&function_type=F&access=YYYNN';
			//	if(val == 'DiscreteMeasurePanel')
			//		parent.frames[1].location.href = '../../eAM/jsp/DiscrMeasurePanel.jsp?module_id=AM&function_id=DISCRETE_MEASURE_PANEL&function_name='+encodeURIComponent(getLabel("Common.DiscreteMeasurePanel.label","common"))+'&function_type=F&access=YYNYN';

				if(val == 'DiscreteMeasure')
					parent.frames[1].location.href = '../../eAM/jsp/DiscrMsrCompMain.jsp?module_id=AM&function_id=DISCRETE_MEASURE&function_name='+encodeURIComponent(getLabel("Common.DiscreteMeasure.label","common"))+'&function_type=F&access=YYYNN';
				if(val == 'DiscreteMeasurePanel')
					parent.frames[1].location.href = '../../eAM/jsp/DiscretePanel.jsp?module_id=AM&function_id=DISCRETE_MEASURE_PANEL&function_name='+encodeURIComponent(getLabel("Common.DiscreteMeasurePanel.label","common"))+'&function_type=F&access=YYNYN';
				//if(val == 'NewDiscreteMeasure')
				//	parent.frames[1].location.href = '../../eAM/jsp/DiscrMsrCompMain.jsp?module_id=AM&function_id=NEW_DISCRETE_MEASURE&function_name='+encodeURIComponent(getLabel("Common.DiscreteMeasure.label","common"))+'&function_type=F&access=YYYNN';
				//if(val == 'Discrete Panel')
				//	parent.frames[1].location.href = '../../eAM/jsp/DiscretePanel.jsp?module_id=AM&function_id=NEW_DISCRETE_MEASURE&function_name='+encodeURIComponent(getLabel("Common.DiscreteMeasurePanel.label","common"))+'&function_type=F&access=YYYNN';
		}

//ResultTemplateAddModify
		function setFocusOnFirst()
		{
			if(document.getElementById('mode').value == "insert")
			 document.result_template_id.focus();
		}

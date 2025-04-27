/**
*	Application		:	eCA
*	Purpose 		:	
*	Modified By		:	Deepa Sastry
*	Modified On		:	20 September 2004.
*/ 
/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function scrollTitle() {
    var scrollY = window.pageYOffset || document.documentElement.scrollTop;

    if (scrollY === 0) {
        document.getElementById("divApplTitle").style.position = 'relative';
        document.getElementById("divApplTitle").style.top = 0;
    } else {
        document.getElementById("divApplTitle").style.position = 'relative';
        document.getElementById("divApplTitle").style.top = scrollY + 'px';
    }
}



function selectValues() //function to get the values from combo boxes and text field 
{
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

	var search_val		= 	parent.searchFrame.document.TaskSearchForm.search_criteria.value
	var appl_val		=	parent.searchFrame.document.TaskSearchForm.applicable.value;
	var text_val		=	parent.searchFrame.document.TaskSearchForm.search_text.value;

	parent.dispFrame.document.location.href='../../eCA/jsp/addApplicationTask.jsp?search_val='+search_val+'&appl_val='+appl_val+'&text_val='+text_val;
}

function loadFrames() //if a different item is selected in the list box previous values are cleared
{
	parent.dispFrame.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function apply() 
{
   f_query_add_mod.dispFrame.document.ppln_task_form.action="../../servlet/eCA.ApplicationTaskServlet";
   f_query_add_mod.dispFrame.document.ppln_task_form.submit();
}

function reset()
{
    f_query_add_mod.searchFrame.location.reload();
	f_query_add_mod.dispFrame.location.href='../../eCA/jsp/addApplicationTask.jsp';
}

function onSuccess()
{
}

function perform(ctrlChkBoxObj)
{
	var val ="";
	var app_access_rights_obj ="";

	if(ctrlChkBoxObj.checked==true)
	{
		for(cnt=0; cnt<parent.dispFrame.document.ppln_task_form.count.value; cnt++)
		{
			val = eval("parent.dispFrame.document.ppln_task_form.task_status"+cnt);
			val.checked = true;
			var task_name=eval("document.ppln_task_form.task_name"+cnt+".value");
			//IN061903 start
			//if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE")
			if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE" || task_name == "NOTDONE")
			//IN061903 ends
		    {
			app_access_rights_obj =eval("document.ppln_task_form.app_access_rights"+cnt+"");
			app_access_rights_obj.disabled=false;
			clearColumnList(app_access_rights_obj);
			var element = document.createElement('OPTION') ;			
			element.value =  "ALL" ;
			element.text = getLabel("Common.all.label","Common");	
			app_access_rights_obj.add(element);				
			var element = document.createElement('OPTION') ;
			element.value =  "MO" ;
			element.text = getLabel("eCA.SelfOrder.label","CA");	
			app_access_rights_obj.add(element);		
			var element = document.createElement('OPTION') ;
			element.value =  "MS" ;
			element.text = getLabel("eCA.SelfSpltyOrders.label","CA");	
			app_access_rights_obj.add(element);								
		  }
		}
	}
	else
	{
		for(cnt=0; cnt<parent.dispFrame.document.ppln_task_form.count.value; cnt++)
		{
			val = eval("parent.dispFrame.document.ppln_task_form.task_status"+cnt);
			val.checked = false;
			var task_name=eval("document.ppln_task_form.task_name"+cnt+".value");
			//IN061903 start
			//if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE")
			if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE" || task_name == "NOTDONE")
			//IN061903 ends
		    {
               app_access_rights_obj = eval("document.ppln_task_form.app_access_rights"+cnt+"");
			   clearColumnList(app_access_rights_obj);
			   var element = document.createElement('OPTION') ;			
			   element.value =  "NA" ;
			   element.text = getLabel("Common.notapplicable.label","Common");	
			   app_access_rights_obj.add(element);		
			   app_access_rights_obj.disabled=true;
		    }
		}
	}
}

function clearColumnList(obj)
{	
	var len = obj.options.length ;
	for(var i=0;i<len;i++)
	{
		obj.remove('atc_class_l2_code') ;
	}
	
}
//function to uncheck the 'Applicable' check box if any of the check boxes is unchecked and to check it if all the check boxes are checked
function chkunchk(objCheck,i)
{
	var index = 0;
	var app_access_rights_obj="";
	var disable1="";
    var task_name=eval("document.ppln_task_form.task_name"+i+".value");
	
	if(!objCheck.checked)
	{
		
		document.ppln_task_form.ctrlChkBox.checked=false
		//IN061903 start
		//if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE")
		if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE" || task_name == "NOTDONE")	
		//IN061903 Ends
		{
			app_access_rights_obj	= eval("document.ppln_task_form.app_access_rights"+i+"");
			clearColumnList(app_access_rights_obj);
			var element = document.createElement('OPTION') ;			
			element.value =  "NA" ;
			element.text = getLabel("Common.notapplicable.label","Common");	
			app_access_rights_obj.add(element);		
			app_access_rights_obj.disabled=true;
		}
	}
	else
	{
		for(cnt=0; cnt<parent.dispFrame.document.ppln_task_form.count.value; cnt++)
		{
			val = eval("parent.dispFrame.document.ppln_task_form.task_status"+cnt);
			if(val.checked == true) index++;
		}
		//IN061903 start
		//if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE")
		if(task_name == "AMEND_ORDER" || task_name == "CANCEL_ORDER" || task_name == "HOLD" || task_name == "DISCONTINUE" || task_name == "NOTDONE")
		//IN061903 Ends
		{
			app_access_rights_obj =eval("document.ppln_task_form.app_access_rights"+i+"");
			app_access_rights_obj.disabled=false;
			clearColumnList(app_access_rights_obj);
			var element = document.createElement('OPTION') ;			
			element.value =  "ALL" ;
			element.text = getLabel("Common.all.label","Common");	
			app_access_rights_obj.add(element);				
			var element = document.createElement('OPTION') ;
			element.value =  "MO" ;
			element.text = getLabel("eCA.SelfOrder.label","CA");	
			app_access_rights_obj.add(element);		
			var element = document.createElement('OPTION') ;
			element.value =  "MS" ;
			element.text = getLabel("eCA.SelfSpltyOrders.label","CA");	
			app_access_rights_obj.add(element);								
		}
		if(index == cnt)
			document.ppln_task_form.ctrlChkBox.checked=true
	}	
}


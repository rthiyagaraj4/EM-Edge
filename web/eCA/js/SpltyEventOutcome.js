function create()
	{
	
		f_query_add_mod.location.href='../../eCA/jsp/SpltyEventOutcomeAddModify.jsp?mode=insert';
	}	



function query()
	{
		f_query_add_mod.location.href = "../../eCA/jsp/SpltyEventOutcomeQuery.jsp";
	}



function reset()
	{
		
		if(parent.master_pages.f_query_add_mod.location.href.indexOf("SpltyEventOutcomeQuery.jsp") != -1)
			{
				parent.master_pages.f_query_add_mod.document.forms[0].reset();
			}
		else if(parent.master_pages.f_query_add_mod.location.href.indexOf("SpltyEventOutcomeQueryResult.jsp") != -1)
			{
			}
		else if(parent.master_pages.f_query_add_mod.location.href.indexOf("SpltyEventOutcomeQuery.jsp") == -1)
			{
				 create();
			}
	
	}


function setModuleId(obj)
{
 
  document.secForNoteTypeValuesForm.module_id.value= obj.value;
  document.secForNoteTypeValuesForm.splty_event.value = "";
  document.secForNoteTypeValuesForm.event_id.value = "";
  parent.spltyEventsSearchFrame.location.href = "../../eCommon/html/blank.html";
  parent.spltyeventFrame.location.href = "../../eCommon/html/blank.html";
  
}


function showSearchResults()
{

	if(document.secForNoteTypeValuesForm!=null)
	{
		var fields = new Array(document.secForNoteTypeValuesForm.module_name,document.secForNoteTypeValuesForm.splty_event);
		var names = new Array (getLabel("Common.Module.label",'common'),getLabel("eCA.SpecialityEvent.label",'ca'));
		
		if(checkFieldsofMst(fields, names, parent.parent.messageFrame))
			{
				var module_id = document.secForNoteTypeValuesForm.module_id.value;
				var event_id = document.secForNoteTypeValuesForm.event_id.value;
				
				parent.spltyEventsSearchFrame.location.href = '../../eCA/jsp/SpltyEventSearch.jsp?module_id='+module_id+'&event_id='+event_id+'&flag=0&loadFirst=Yes' ;
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp'
								
			}
	}
	
	else
	{
				
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}
}

function getspltyEvent()
{
	var target			= document.secForNoteTypeValuesForm.splty_event;
	var serviceVal		= document.secForNoteTypeValuesForm.splty_event.value;
	var retVal			=  new String();
	var title			= getLabel("eCA.SpecialityEvent.label",'ca');
	var module_id		= document.secForNoteTypeValuesForm.module_id.value;
	
	var sql="SELECT SPLTY_EVENT_CODE code,SPLTY_EVENT_DESC  description FROM CA_SPLTY_EVENT WHERE eff_status='E' and upper(SPLTY_EVENT_CODE) like upper(?) and upper(SPLTY_EVENT_DESC) like upper(?) and UPPER(module_id)='"+module_id+"'";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		document.secForNoteTypeValuesForm.event_id.value = retArray[0];
		document.secForNoteTypeValuesForm.splty_event.value = retArray[1];
	}
	else
	{
		document.secForNoteTypeValuesForm.splty_event.value = "";
		document.secForNoteTypeValuesForm.event_id.value = "";
	}
	setTimeout("reloadFrames()",50);
}

function reloadFrames()
{
	parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SpltyEventOutcomeRemoveRecord.jsp'><input type='hidden' name='called_from' id='called_from' value='reloadFrames'></form></html>");
	parent.removeRecFrame.document.remRecForm.submit();
}


function loadEvents()
{

if(document.SpltyEventSearchForm!=null)
	{
	
	var fields = new Array(document.SpltyEventSearchForm.searchText);
    var names = new Array (getLabel("eCA.SectionStartsWith.label",'ca'));
	
		if(checkFieldsofMst(fields, names, parent.parent.messageFrame))
		{
			var searchText = document.SpltyEventSearchForm.searchText.value;
			parent.spltyEventsSearchFrame.location.href = '../../eCA/jsp/SpltyEventSearch.jsp?searchText='+encodeURIComponent(searchText)+'&flag=1&loadFirst=Yes&module_id='+document.SpltyEventSearchForm.module_id.value;
		}

	}
	else
	{
		
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		return false;
	}
}

function loadPrevNextRecs(varName)
{
	var start = document.SpltyEventSearchForm.from.value;
	var end = document.SpltyEventSearchForm.to.value;
	var searchText = document.SpltyEventSearchForm.searchText.value; 
	if(searchText == undefined) searchText = '';
	var mode = document.SpltyEventSearchForm.mode.value;
	var flag = document.SpltyEventSearchForm.flag.value;
	var totalCount = document.SpltyEventSearchForm.totalCount.value;
	var countForNext = document.SpltyEventSearchForm.countForNext.value;

	var tempRowIds = "";
	var tempString = "";
	var tempParseInt = 0;

	if(varName == 'prev')
	{
		start = parseInt(start,10) - 5;
		end = parseInt(end,10) - 5;
		tempParseInt = parseInt(countForNext,10)-1
	}
	else if(varName == 'next')
	{
		start = parseInt(start,10) + 5;
		end = parseInt(end,10) + 5;
		tempParseInt = parseInt(countForNext,10)+1
	}

	for(var t=parseInt(start,10);t<parseInt(end,10);t++)
	{
		tempString = parent.parent.rowIDSectionForNoteType[t];

		if(t < totalCount)
		{
			if(tempString.indexOf("+") != -1)
			{
				for(var x=0;x<tempString.length;x++)
				{
					tempString = tempString.replace("+","^");
				}
			}
			tempRowIds = "'"+tempString+ "'," + tempRowIds;
		}
	} 

	parent.spltyEventsSearchFrame.location.href = '../../eCA/jsp/SpltyEventSearch.jsp?&flag='+flag+'&start='+start+'&end='+end+'&searchText='+encodeURIComponent(searchText)+'&mode='+mode+'&tempRowIds='+tempRowIds+'&flagTemp=temp&totalCount='+totalCount+'&countForNext='+tempParseInt;
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function loadEventPage(obj,splty_event_code,splty_event_desc,tempSeq,outcome_type)

{
 	var numberOfRecs = "";
	if(parent.spltyeventFrame.document.spltyeventForm != null)
		{
			numberOfRecs = parent.spltyeventFrame.document.spltyeventForm.countOfRows.value;
		}
	var seachText = document.SpltyEventSearchForm.searchText.value;
	if(obj.checked == true)
		{
		
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SpltyEventOutcomeRemoveRecord.jsp'><input type='hidden' name='splty_event_code' id='splty_event_code' value='"+splty_event_code+"'><input type='hidden' name='splty_event_desc' id='splty_event_desc' value='"+splty_event_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'><input type='hidden' name='outcome_type' id='outcome_type' value='"+outcome_type+"'></form></html>");
			parent.removeRecFrame.document.remRecForm.submit();
		}
}

function scrollTitleTop()
{
	var x = document.body.scrollTop;
	var tr = document.getElementById("trcoll");
	var positionTop = 2;
	if(x == 2)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 15);
			tr[i].style.posTop = positionTop;			
		}
	}
	else
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x;			
		}
	}
}

function removeRecord(obj,splty_event_code,index)
{
	var seachText =  parent.spltyEventsSearchFrame.document.SpltyEventSearchForm.searchText.value;
		
	if(obj.checked != true)
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SpltyEventOutcomeRemoveRecord.jsp'><input type='hidden' name='splty_event_code' id='splty_event_code' value='"+splty_event_code+"'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='index' id='index' value='"+index+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
}

function apply()
{
	if(f_query_add_mod.eventSearchFrame !=null)
	{
		if(f_query_add_mod.eventSearchFrame.document.secForNoteTypeValuesForm !=null&&f_query_add_mod.spltyeventFrame.document.spltyeventForm !=null)
		{
			var module_id =f_query_add_mod.eventSearchFrame.document.secForNoteTypeValuesForm.module_id.value;
			var event_id =f_query_add_mod.eventSearchFrame.document.secForNoteTypeValuesForm.event_id.value;
			f_query_add_mod.spltyeventFrame.document.spltyeventForm.module_id.value= module_id;
			f_query_add_mod.spltyeventFrame.document.spltyeventForm.event_id.value= event_id;
			f_query_add_mod.spltyeventFrame.document.spltyeventForm.submit();
		}

		else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	}
	else
	{
	 messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

function onSuccess()
{
	create();
}

function setValueCE(obj)
{

 if(obj.checked)
	{
	obj.value='Y';
	}
else
	{
	obj.value='N';
	}
		
}

function getspltyEvent1(obj)
{
	
	if(obj.value!="")
	{
		getspltyEvent();
	}
	else
	{
		document.secForNoteTypeValuesForm.splty_event.value = "";
		document.secForNoteTypeValuesForm.event_id.value = "";
	}

}


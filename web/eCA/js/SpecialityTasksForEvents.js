function create()
	{
	
		f_query_add_mod.location.href='../../eCA/jsp/SpecialityTasksForEventsMain.jsp?mode=insert';
	}	



function query()
	{
		
	   f_query_add_mod.location.href='../../eCA/jsp/SpecialityTasksForEventsQueryCriteria.jsp';
	}


function apply()
{
	if(f_query_add_mod.headerFrame !=null)
	{
	if(f_query_add_mod.headerFrame.document.specialityTasksForEeventForm !=null&&f_query_add_mod.tasksFrame.document.specialityTasksForEeventSelectForm !=null)
	{
	//var noteType = f_query_add_mod.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type;

	var seq_num = f_query_add_mod.tasksFrame.document.specialityTasksForEeventSelectForm.seq_num;

	//f_query_add_mod.tasksFrame.document.specialityTasksForEeventSelectForm.note_type.value = noteType.value;

	var count = f_query_add_mod.tasksFrame.document.specialityTasksForEeventSelectForm.countOfRows.value;
	var chief_comp="";
	var seq_num = "";	
	var conc_string = "";	
	var sec_code = "";
	var dummyRow = "";
	var dummySeqNum = "";
	var finalString = "";

	for(var i=0; i<count; i++)
	{
		dummyRow = eval("f_query_add_mod.tasksFrame.document.getElementById("numRows")"+i);
		sec_code = dummyRow.cells[0].innerText;
		//alert("sec_code======"+sec_code);
		//chief_comp = dummyRow.cells[1].innerText;
		dummySeqNum = eval("f_query_add_mod.tasksFrame.document.getElementById("seq_num_text")"+i);
		seq_num = dummyRow.cells[1].innerText;
		dummySeqNum.value = seq_num;
		//alert("dummySeqNum======"+dummySeqNum.value);
	}	
	f_query_add_mod.tasksFrame.document.specialityTasksForEeventSelectForm.submit();
	if(count == 0)
	{
		f_query_add_mod.tasksFrame.document.specialityTasksForEeventSelectForm.submit();
	}
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

function reset()
	{
			if(f_query_add_mod.headerFrame.document.specialityTasksForEeventForm!=null)
			f_query_add_mod.headerFrame.document.specialityTasksForEeventForm.reset();
		    f_query_add_mod.location.href='../../eCA/jsp/SpecialityTasksForEventsMain.jsp?mode=insert';	
	}

function getspltyEvent()
{
	var target			= document.specialityTasksForEeventForm.splty_event;
	var serviceVal		= document.specialityTasksForEeventForm.splty_event.value;
	var retVal			=  new String();
	var title			= getLabel("eCA.SpecialityEvent.label",'ca');
	//var module_id		= document.specialityTasksForEeventForm.module.value;
	
	//alert(module_id);
	var sql="SELECT SPLTY_EVENT_CODE code,SPLTY_EVENT_DESC  description FROM CA_SPLTY_EVENT WHERE eff_status='E' and upper(SPLTY_EVENT_CODE) like upper(?) and upper(SPLTY_EVENT_DESC) like upper(?) ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "2,1";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")
	{
		//parent.frames[1].document.forms[0].service_desc.value = retArray[1];
		document.specialityTasksForEeventForm.event_id.value = retArray[0];
		document.specialityTasksForEeventForm.splty_event.value = retArray[1];
		//parent.frames[1].document.forms[0].chkprevservice.value = retArray[1];
	}
	else
	{
		parent.frames[1].document.forms[0].splty_event.value = "";
		parent.frames[1].document.forms[0].event_id.value = "";
	}
	setTimeout("reloadFrames()",50);
	//parent.frames[1].document.forms[0].service_desc_search.disabled=false;
	//parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}

function loadtasks()
{
	var module = parent.headerFrame.document.specialityTasksForEeventForm.module.value;
	//alert("module#######"+module);
	var code = parent.headerFrame.document.specialityTasksForEeventForm.code.value;
	var event_id = parent.headerFrame.document.specialityTasksForEeventForm.event_id.value;
	var no_of_trans = parent.headerFrame.document.specialityTasksForEeventForm.no_of_trans.value;
	if(document.spltyTaskForEventSearchForm!=null)
	{

		//alert(document.spltyTaskForEventSearchForm.searchText.value);
	var fields = new Array(document.spltyTaskForEventSearchForm.searchText);

    var names = new Array (getLabel("eCA.SpecialtyTaskStartsWith.label",'ca'));
	
	if(checkFieldsofMst(fields, names, parent.parent.messageFrame))
	{
		//document.secForNoteTypeSearchSectionsForm.submit();
		var searchText = document.spltyTaskForEventSearchForm.searchText.value;
		parent.addTasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSearchAddTasks.jsp?searchText='
		+encodeURIComponent(searchText)+'&module='+module+'&code='+code+'&event_id='+event_id+'&no_of_trans='+no_of_trans+'&flag=1&loadFirst=Yes';
		
	}
	}
	
	else
	{
		//alert("here2");
	
		
		//parent.removeRecFrame.location.href ='../../eCommon/html/blank.html';	
		
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		
		return false;
	}
	
}

function loadTasksPage(obj,splty_task_code,splty_task_desc,tempSeq)
{
	var module = parent.headerFrame.document.specialityTasksForEeventForm.module.value;
	//alert("loadTasksPage##################");
	var code = parent.headerFrame.document.specialityTasksForEeventForm.code.value;
	var event_id = parent.headerFrame.document.specialityTasksForEeventForm.event_id.value;
	var no_of_trans = parent.headerFrame.document.specialityTasksForEeventForm.no_of_trans.value;
	
	var numberOfRecs = "";
	if(parent.tasksFrame.document.specialityTasksForEeventSelectForm != null)
	{
		numberOfRecs = parent.tasksFrame.document.specialityTasksForEeventSelectForm.countOfRows.value;
	}
	var seachText = parent.addTasksFrame.document.spltyTaskForEventSearchForm.searchText.value;
	if(obj.checked == true)
	{
		  // alert("splty_task_code======"+splty_task_code+"splty_task_desc======="+splty_task_desc+"numberOfRecs========"+numberOfRecs);
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SpecialityTasksForEeventRemoveRecord.jsp'><input type='hidden' name='splty_task_code' id='splty_task_code' value='"+splty_task_code+"'><input type='hidden' name='splty_task_desc' id='splty_task_desc' value='"+splty_task_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'><input type='hidden' name='module' id='module' value='"+module+"'><input type='hidden' name='code' id='code' value='"+code+"'><input type='hidden' name='event_id' id='event_id' value='"+event_id+"'><input type='hidden' name='no_of_trans' id='no_of_trans' value='"+no_of_trans+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
	else
	{
		//alert("tempSeq --"+tempSeq);
		//removeRecord(obj,sec_heading_code)
	}
}


function removeRecord(obj,splty_task_code,index)
{

	var module = parent.headerFrame.document.specialityTasksForEeventForm.module.value;
	//alert("module#######$$$$$$$$$$$$$$$$$"+module);
	var code = parent.headerFrame.document.specialityTasksForEeventForm.code.value;
	var event_id = parent.headerFrame.document.specialityTasksForEeventForm.event_id.value;
	var no_of_trans = parent.headerFrame.document.specialityTasksForEeventForm.no_of_trans.value;
	var seachText = parent.addTasksFrame.document.spltyTaskForEventSearchForm.searchTextHidden.value;
	//alert("splty_task_code============############"+splty_task_code );
	if(obj.checked != true)
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SpecialityTasksForEeventRemoveRecord.jsp'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='splty_task_code' id='splty_task_code' value='"+splty_task_code+"'><input type='hidden' name='index' id='index' value='"+index+"'><input type='hidden' name='module' id='module' value='"+module+"'><input type='hidden' name='code' id='code' value='"+code+"'><input type='hidden' name='event_id' id='event_id' value='"+event_id+"'><input type='hidden' name='no_of_trans' id='no_of_trans' value='"+no_of_trans+"'></form></html>");

		parent.removeRecFrame.document.remRecForm.submit();
	}
}

function addRecord(obj,sec_heading_code,sec_heading_desc,srlNo,index)
{
	
		//var seachText = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.searchText.value;
	var chiefComp = "";
	var flag=parent.sectionsFrame.document.secForNoteTypeSectionsForm.flag.value;
	var count=parent.sectionsFrame.document.secForNoteTypeSectionsForm.count.value;
	
	
	if(obj.checked == true)
	{
			if(count >=1)
			{
				alert(getMessage('CHIEF_COMPL_NOT_ALLOWED','CA'));
				obj.checked=false;
				return false;
			}
			else
			{
				if (flag=="false")
				{
					alert(getMessage('CHIEF_COMPL_NOT_ALLOWED','CA'));
					obj.checked=false;
					return false;
				}
				else 
				{
					chiefComp = "Y";
					parent.sectionsFrame.document.secForNoteTypeSectionsForm.flag.value=false;
				}
			}
	}
	else
	{
		
		
		parent.sectionsFrame.document.secForNoteTypeSectionsForm.flag.value=true;
		parent.sectionsFrame.document.secForNoteTypeSectionsForm.count.value=0;
		chiefComp = "N";
	}
		//alert("chiefComp"+chiefComp);
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SectionForNoteTypeRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='srlNo' id='srlNo' value='"+srlNo+"'><input type='hidden' name='called_from' id='called_from' value='addPage'><input type='hidden' name='chiefComp' id='chiefComp' value='"+chiefComp+"'><input type='hidden' name='index' id='index' value='"+index+"'></form></html>");
		
		parent.removeRecFrame.document.remRecForm.submit();
		
}

function reloadFrames()
{
	//alert("ReloadFrames########################");
	parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SpecialityTasksForEeventRemoveRecord.jsp'><input type='hidden' name='called_from' id='called_from' value='reloadFrames'></form></html>");
	parent.removeRecFrame.document.remRecForm.submit();
}

function addSeqNum(obj,sec_hdg_code,chief_comp,sec_heading_desc)
{
	var seq_num = obj.value;
	if(obj.value != "")
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SectionForNoteTypeRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_hdg_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='onBlurFunc'><input type='hidden' name='seq_num' id='seq_num' value='"+seq_num+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
}


function scrollTitle()
{
	var x = document.body.scrollTop;
	var tr = document.getElementById("trcoll");
	var positionTop = 0;
	if(x == 3)
	{
		for(var i=0;i<tr.length;i++)
		{
			tr[i].style.position = 'relative';
			if(i != 0)
				positionTop += (tr[i - 1].offsetHeight - 10);
			tr[i].style.posTop = positionTop;			
		}		
	}
	else
	{
		for(var i=0;i<tr.length-1;i++)
		{
			tr[i].style.position = 'relative';
			tr[i].style.posTop = x;			
		}
		tr[2].style.posTop = parseInt(x) - 2;
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

function changeColor(cnt,srlNo)
{	
	var count = document.specialityTasksForEeventSelectForm.countOfRows.value;
	var classValue = "";
	if((parseInt(count)) % 2 == 0)
		classValue = "QRYEVEN";
	else
		classValue = "QRYODD";
	
	if(document.specialityTasksForEeventSelectForm.firstPos.value == "")
	{
		var temp = document.getElementById('numRows'+cnt);
		var temp1 = temp.cells.length;
		if(document.specialityTasksForEeventSelectForm.firstPos.value == "")
		{
			for(var i=0;i<temp1;i++)
			{
				temp.cells[i].className = 'FIRSTSELECTED';
			}
		}
		document.getElementById("extraRow").style.display = "inline";
		if(document.getElementById("extraRow").style.display == "inline")
		{
			for(var j=0;j<(document.getElementById("extraRow").cells.length);j++)
			{
				document.getElementById("extraRow").cells[j].className = classValue;
			}
		}
		document.specialityTasksForEeventSelectForm.firstPos.value = srlNo;
	}
	else
	{	
		
		reloadSecFrame(cnt,srlNo);
	}
}

function reloadSecFrame(cnt,srlNo)
{
	if(document.specialityTasksForEeventSelectForm.firstPos.value != "")
	{
		var module = document.specialityTasksForEeventSelectForm.module.value;
		//alert("module$$$$$$$$$$$$$$$"+module);
		var code = document.specialityTasksForEeventSelectForm.code.value;
	    var event_id = document.specialityTasksForEeventSelectForm.event_id.value;
	    var no_of_trans =document.specialityTasksForEeventSelectForm.no_of_trans.value;
	    var seachText =parent.addTasksFrame.document.spltyTaskForEventSearchForm.searchTextHidden.value;
		
		document.specialityTasksForEeventSelectForm.secPos.value = srlNo;

		var firstPos = document.specialityTasksForEeventSelectForm.firstPos.value;
		var secPos = document.specialityTasksForEeventSelectForm.secPos.value;
		var noOfRows = document.specialityTasksForEeventSelectForm.countOfRows.value;		
		parent.tasksFrame.location.href = "../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?firstPosition="+document.specialityTasksForEeventSelectForm.firstPos.value+"&secondPosition="+document.specialityTasksForEeventSelectForm.secPos.value+"&mode=modify&noOfRows="+noOfRows+"&module="+module+"&code="+code+"&event_id="+event_id+"&no_of_trans="+no_of_trans;		
	}
}

function loadPrevNextRecs(varName)
{
	var start = document.spltyTaskForEventSearchForm.from.value;
	var end = document.spltyTaskForEventSearchForm.to.value;
	var searchText = document.spltyTaskForEventSearchForm.searchTextHidden.value;
	if(searchText == undefined) searchText = '';
	var mode = document.spltyTaskForEventSearchForm.mode.value;
	var flag = document.spltyTaskForEventSearchForm.flag.value;
	//var note_type = document.secForNoteTypeSearchSectionsForm.note_type.value;
	var totalCount = document.spltyTaskForEventSearchForm.totalCount.value;
	var countForNext = document.spltyTaskForEventSearchForm.countForNext.value;

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

	parent.addTasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSearchAddTasks.jsp?flag='+flag+'&start='+start+'&end='+end+'&searchText='+encodeURIComponent(searchText)+'&mode='+mode+'&tempRowIds='+tempRowIds+'&flagTemp=temp&totalCount='+totalCount+'&countForNext='+tempParseInt;
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

function loadFrames()
{
	
	var module = document.specialityTasksForEeventForm.module.value;
	//alert("module"+module);
	var code = document.specialityTasksForEeventForm.code.value;
	var event_id = document.specialityTasksForEeventForm.event_id.value;
	var no_of_trans = document.specialityTasksForEeventForm.no_of_trans.value;

	if(event_id !="")
	{
		parent.tasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSelection.jsp?module='+module+'&code='+code+'&event_id='+event_id+'&no_of_trans='+no_of_trans+'&flag=0&loadFirst=Yes';	//
		
		parent.addTasksFrame.location.href = '../../eCA/jsp/SpecialityTasksForEventsSearchAddTasks.jsp?module='+module+'&code='+code+'&event_id='+event_id+'&no_of_trans='+no_of_trans+'&flag=0&loadFirst=Yes';

		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp'
	
	}

	else
	{

			var fields = new Array(document.specialityTasksForEeventForm.module,document.specialityTasksForEeventForm.event_id);

			 var names = new Array (getLabel("Common.Module.label","Common"),getLabel("eCA.SpecialityEvent.label","CA"));
	
			checkFieldsofMst(fields, names, parent.parent.messageFrame);
	
	}
	
}

function onSuccess()
{
	create();
}

function numOnly()
  {
     if(((event.keyCode>=48)&&(event.keyCode<=57)))
     {
        event.keyCode=event.keyCode;
     }
     
     else
     {
       event.keyCode=0;
      
     }
  }


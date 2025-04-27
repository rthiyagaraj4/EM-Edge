var currClass;
//var child = null;
function showCalendarValidate(str)
{
	var flg = showCalendar(str,null,'hh:mm');
	eval("document."+str+".focus();");
	return flg;
}
function CheckDateTime(objText)
{
	if(objText.value !='')
	{
		if(!doDateTimeChk(objText))
		{
			alert(getMessage("INVALID_DATE_FMT","common"));
			objText.select();
			return false
		}
		else
		{
			var dateArray=objText.value.split(" ");
			var timeArray=dateArray[0].split("/");
			if(timeArray[1]==0)
			{
				alert(getMessage("INVALID_DATE_FMT","COMMON"));
				objText.select();
				return false
			}
		}
	}
}

function fromDateChecknew(from,format,locale)
{
	if(from.value !="")
	{
		if(isBeforeNow(from.value, format,locale))
				return true;
			else
			{
				if( from.name == "fromDate")
				{
					alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
					document.forms[0].fromDate.value = getCurrentDate("DMYHM",locale);
					return false;
				}
			}
	}
}

function toDateChecknew(from,to,format,locale)
{
	if(from.value !="" && to.value !="")
	{
		if(!isBefore(from.value, to.value, format, locale))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			to.select();
			to.focus();
			return false;
		}
	
	}
}

/*function ValidateDateTimeOfPeriod(Objfrom,objTo)
{
	if(objTo.value !="" && Objfrom.value != "")
	{
		if(!ValidateDateTime(Objfrom,objTo)) 
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			objTo.select();
			return false
		}
	}
}*/
function ValidateDateTimeOfPeriodoFSearch(Objfrom,objTo)
{
	if(objTo.value !="" && Objfrom.value != "")
	{
		if(!ValidateDateTime(Objfrom,objTo)) 
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			objTo.select();
			return false
		}
		else
		return true	
	}
}
function getTask(obj)
{
	var htmlVal = "";
	var sql = "";
	var task = document.patTaskCriteriaForm.task.value;

	//var locale = document.patTaskCriteriaForm.locale.value;

	if(obj.name=='taskDesc')
	{
	
		htmlVal = "<html><form name='tempForm' id='tempForm' action='../../eCA/jsp/PatTaskListIntermediate.jsp' method='post'><input type='hidden' name='task' id='task' value='"+task+"'><input type='hidden' name='taskDesc' id='taskDesc' value='"+obj.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='task'></form></html>";
		parent.blankFrame.document.write(htmlVal);
		parent.blankFrame.document.tempForm.submit();
	}
	else
	{
		var serviceVal   ="";
		var search_desc	= "";
		var target = document.patTaskCriteriaForm.taskDesc;
		var task = document.patTaskCriteriaForm.task.value;
		if(task=="")
		{
			task  = "%"
		}
		else
		{
			task  = task + "%"
		}
		//sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION WHERE  upper(INTERVENTION_CODE) like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' and upper(INTERVENTION_TYPE) like upper('"+task+"') ORDER BY SHORT_DESC ";

		sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE  INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' and upper(INTERVENTION_TYPE) like upper('"+task+"')  AND LANGUAGE_ID = '"+locale+"' ORDER BY SHORT_DESC "; 

		target.value='';
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
		retArray = CommonLookup( getLabel("eCA.Task.label","CA"), argArray );
		if(retArray.length != 0)
		{
			document.patTaskCriteriaForm.taskDesc.value=retArray[1];
			document.patTaskCriteriaForm.taskCode.value=retArray[0];
		}
	}
}
function validateLocation(objSelect)
{
	var obj = document.forms[0].locationCode; 
	objSelect.disabled = true;
	obj.disabled = true;
	var indexI = 1
	var size=	document.forms[0].locationCode.options.length
	for(var index = 0 ; index < size ;index++)
	{
		obj.remove(indexI)
	}

	if(objSelect.value=='C')
	{
		var arrayTilde;  
		var objHidden = document.forms[0].selectValueForClinic.value
		var arrayPipe;

		if(objHidden.length != 0)
		{
			arrayTilde = objHidden.split("~");
			var index=0;
			var indexI=0;

			while(index < arrayTilde.length)
			{
			
				arrayPipe = arrayTilde[index].split("||");
				var element = document.createElement("OPTION");
					element.text  = arrayPipe[1]
					element.value=arrayPipe[0]
					obj.add(element)
					index++;
			}
		}
	}
	else
	{
		var arrayTilde;  
		var objHidden = document.forms[0].selectValueForNursing.value
		var arrayPipe;

		if(objHidden.length != 0)
		{
			arrayTilde = objHidden.split("~");
			
			var index=0;
			var indexI=0;

			while(index < arrayTilde.length)
			{
				arrayPipe = arrayTilde[index].split("||");
				
				var element = document.createElement("OPTION");
					element.text  = arrayPipe[1]
					element.value=arrayPipe[0]
					obj.add(element)
					index++;
			}
		}

	}

	obj.disabled = false;
	objSelect.disabled = false;
}

function resetTask()
{
	document.patTaskCriteriaForm.taskDesc.value=''
	document.patTaskCriteriaForm.taskCode.value=''
}
function getPatientId()
{
	var pat_id =  PatientSearch();
	if(pat_id != undefined)	
	{
		document.patTaskCriteriaForm.PatientId.value=pat_id
		document.patTaskCriteriaForm.PatientId.focus()
	}
}
function populateList(objSelect)
{	
	var selectName = objSelect.name;
	switch(selectName)
	{
		case 'dateTime' :    populateGroupByDateTime(objSelect);
									break;
		case 'patientDetail' :populateGroupByPatient(objSelect);
									break;
		default				 :	break;


	}

}
function populateGroupByPatient(obj)
{
	var objDateTime = document.patTaskCriteriaForm.dateTime;
	var objTask = document.patTaskCriteriaForm.taskSelect;
	var patientId = document.patTaskCriteriaForm.PatientId;
	clearList(objTask)
	//if(patientId.value=='')
//	{
		if(obj.value != '')
		{
			
			for(var index = 1 ; index < obj.options.length;index++)
			{
				if(index != obj.selectedIndex)
					{
						var element = document.createElement("OPTION");
						element.text  = obj.options(index).text
						element.value=obj.options(index).value
						objTask.add(element);
					}
			}
		}
	//}
}
function populateGroupByDateTime(objSelect)
{
	
	var objPatient =  document.patTaskCriteriaForm.patientDetail;
	clearList(objPatient)
	var objTask = document.patTaskCriteriaForm.taskSelect;
	clearList(objTask)
	var patientId = document.patTaskCriteriaForm.PatientId;
	
	if(patientId.value=='')
	{
		if(objSelect.value !='')
		{
		
			if(objSelect.value=='9')
			{
				var element = document.createElement("OPTION");
				element.text  = getLabel('Common.date.label','Common');//'Date'	
				element.value='6'
				objPatient.add(element);
				var element = document.createElement("OPTION");
				element.text  = getLabel('eCA.TaskType.label','CA');//'Task Type'	
				element.value='3'
				objPatient.add(element);
					
			}
			else if(objSelect.value=='6')
			{
				var element = document.createElement("OPTION");
				element.text  = getLabel('Common.PatientDetails.label','Common'); // 'Patient Details'
				element.value='9'
				objPatient.add(element);
				var element = document.createElement("OPTION");
				element.text  = getLabel('eCA.TaskType.label','CA');//'Task Type'	
				element.value='3'
				objPatient.add(element);
			}
			else
			{
				var element = document.createElement("OPTION");
				element.text  = getLabel('Common.date.label','Common');// 'Date'	
				element.value='6'
				objPatient.add(element);
				var element = document.createElement("OPTION");
				element.text  = getLabel('Common.PatientDetails.label','Common');//'Patient Details'
				element.value='9'
				objPatient.add(element);
			}
		}
		
	}
	else
	{
		if(objSelect.value !=''){ 
		for(var index=1; index < objSelect.options.length;index++)
		{
				var element = document.createElement("OPTION");
				if(index != objSelect.selectedIndex)
				{
					element.text = objSelect.options[index].text;
					element.value = objSelect.options[index].value;
					objPatient.add(element)
				}
		}
		}
	}
}
function clearList(obj)
{
	
	var indexI=1;
	for(var index = 0; index <= obj.options.length;index++)
	{
		obj.remove(indexI);
	}
}
function clearTaskCriteria()
{
//	document.patTaskCriteriaForm.reset();
	parent.patTaskListResultFrame.location.href='../../eCommon/html/blank.html';
	parent.patTaskListStatusFrame.location.href='../../eCommon/html/blank.html';
}
function SearchTaskCriteria(flagString)
{
	var fields = null, 	names = null;
	document.patTaskCriteriaForm.search.disabled = true;
	var fromDate = document.patTaskCriteriaForm.fromDate.value;
	var toDate = document.patTaskCriteriaForm.toDate.value;
	var patient_id = document.patTaskCriteriaForm.PatientId.value;
	var encounter_id = document.patTaskCriteriaForm.encounterId.value;
	var encounter = document.patTaskCriteriaForm.encounterId ;		

		fields = new Array(document.getElementById("fromDate"),document.getElementById("toDate"));
		names = new Array(getLabel("Common.fromdate.label","COMMON"),
		getLabel("Common.todate.label","COMMON"));	

	if(flagString=="criteria")	
	{
		document.patTaskCriteriaForm.sortSelection.value = '';			
	}
	if(checkFieldsofMst( fields, names, top.content.messageFrame))
	{
		if(patient_id == "" && encounter_id=="")
		{
			var locationCode = document.patTaskCriteriaForm.locationCode
			if(locationCode.value=="")
			{
				top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('LOCN_PATIENT_ENCTR_BLANK',"CA");
					document.patTaskCriteriaForm.search.disabled = false;
					return false
			}
		}


		if(ValidateDateTimeOfPeriodoFSearch(document.getElementById("fromDate"),document.getElementById("toDate")))
		{	
			top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			document.patTaskCriteriaForm.target = 'patTaskListResultFrame';
			if(!document.patTaskCriteriaForm.checkIntervention.checked && !document.patTaskCriteriaForm.checkAdminMedication.checked && !document.patTaskCriteriaForm.checkSpecimen.checked && !document.patTaskCriteriaForm.checkResult.checked)
			{
				alert(getMessage("MIN_ONE_TASK_SEL_REQ","CA"));
				document.patTaskCriteriaForm.search.disabled = false;
			}
			else	
			{
				if(document.patTaskCriteriaForm.checkIntervention.checked)
					document.patTaskCriteriaForm.checkIntervention.value='Y'

				if (document.patTaskCriteriaForm.checkAdminMedication.checked)
					document.patTaskCriteriaForm.checkAdminMedication.value='Y'		
				
				if(document.patTaskCriteriaForm.checkSpecimen.checked)
					document.patTaskCriteriaForm.checkSpecimen.value='Y'
				
				if(document.patTaskCriteriaForm.checkResult.checked)
					document.patTaskCriteriaForm.checkResult.value='Y'
				
				var dateTime = document.patTaskCriteriaForm.dateTime.value
				var taskSelect	= document.patTaskCriteriaForm.taskSelect
				var patientDetail = document.patTaskCriteriaForm.patientDetail.value
				document.patTaskCriteriaForm.submit();
			}
		}		
	}
	else
		document.patTaskCriteriaForm.search.disabled = false;
}

function scrollTitle()
{
  var x = document.body.scrollTop;
  if(x == 0)
	  {
	   document.getElementById("divTitleTable").style.position = 'relative';
	   document.getElementById("divTitleTable").style.posTop  = 0;
	 }
  else
	 {
		document.getElementById("divTitleTable").style.position = 'relative';
		document.getElementById("divTitleTable").style.posTop  = x-2;
	 }

}
function collapseAll(objLink,index)
{

	var trRow = document.getElementById("trRowIdHeader"+index);
	var noOfHeaders = document.patTaskListResultForm.noOfHeaders.value;
	var noOfRow;
	if(noOfHeaders ==0)
	{
			noOfRow = document.patTaskListResultForm.noOfRow.value;
	}
	else
	{
		var noOfRows = eval("document.patTaskListResultForm.noOfRows"+parseInt(index));
		noOfRow = noOfRows.value
	}

	if(objLink.innerText=='-')
	{
		for(var indexJ = 0 ;indexJ < parseInt(noOfRow);indexJ++)
		{
			var trRowId = document.getElementById("trRowId"+index+indexJ)
			trRowId.style.display='none'
		}
		objLink.innerText='+'
		//alert(trRow.cells.length)
		//trRow.cells((trRow.cells.length-1)).colSpan+=1
			trRow.cells[trRow.cells.length - 1].colSpan += 1;
	}
	else
	{
		for(var indexJ = 0 ;indexJ < parseInt(noOfRow);indexJ++)
		{
			var trRowId = document.getElementById("trRowId"+index+""+indexJ)
			trRowId.style='display'
		}
		objLink.innerText= '-'
	}
}
function collapseMainHeader(objLink,index)
{
	var noOfMainHeader = document.patTaskListResultForm.noOfMainHeader.value;
	var noOfSubHeader ;
	var noOfRows;
	noOfSubHeader = eval("document.patTaskListResultForm.noOfSubHeaders"+index);

	if(noOfSubHeader == undefined)
	{
		noOfSubHeader = document.patTaskListResultForm.noOfSubHeader.value;
	}
	if(objLink.innerText=='-')	
	{
		var trMainHeader = document.getElementById("mainRowHeader"+index)
		if(parseInt(noOfSubHeader.value) == 1)
		{

			for(var indexI=0; indexI < parseInt(noOfSubHeader.value);indexI++)
			{
				var subRowId=document.getElementById("subRowHeader"+index+indexI)	
				if(subRowId.cells(1).innerText != '+')
				{
					noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI)
					if(noOfRows == undefined)
					{
						noOfRows=document.patTaskListResultForm.noOfRow
					}
		
					for(var indexJ = 0 ;indexJ < parseInt(noOfRows.value);indexJ++)
					{
						var trRowId = document.getElementById("rowId"+index+indexI+indexJ)
						trRowId.style.display='none'	
					}	
				}
				subRowId.style.display='none'	
			}
			
			
			
		}
		else
		{
			
			{	
				for(var indexI=0; indexI < parseInt(noOfSubHeader.value);indexI++)
				{
					noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI)
					var subRowId=document.getElementById("subRowHeader"+index+indexI)	
						
					for(var indexJ = 0 ;indexJ < parseInt(noOfRows.value);indexJ++)
					{
						var trRowId = document.getElementById("rowId"+index+indexI+indexJ)
						trRowId.style.display='none'		
					}	
					
					subRowId.style.display='none'	
					
				}
			}

			
		}
		trMainHeader.cells[(trMainHeader.cells.length-1)].colSpan+=1
		objLink.innerText='+'
		
	}
	else
	{
		if(parseInt(noOfSubHeader.value) == 1)
		{

			for(var indexI=0; indexI < parseInt(noOfSubHeader.value);indexI++)
			{
				noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI)
				
				if(noOfRows == undefined)
				{
					noOfRows=document.patTaskListResultForm.noOfRow
				}
				for(var indexJ = 0 ;indexJ < parseInt(noOfRows.value);indexJ++)
				{
					var trRowId = document.getElementById("rowId"+index+indexI+indexJ)
					trRowId.style='display';		
				}	
				var subRowId=document.getElementById("subRowHeader"+index+indexI)
				subRowId.style='display';
				var linkSub = document.getElementById("linkSub"+index+indexI)
				linkSub.innerText="-"
			}
				
		}
		else
		{
			for(var indexI=0; indexI < parseInt(noOfSubHeader.value);indexI++)
			{
				noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI)
				
				for(var indexJ = 0 ;indexJ < parseInt(noOfRows.value);indexJ++)
				{
					var trRowId = document.getElementById("rowId"+index+indexI+indexJ)
					trRowId.style='display';		
				}	
				var subRowId=document.getElementById("subRowHeader"+index+indexI)	
				subRowId.style='display';	
				var linkSub = document.getElementById("linkSub"+index+indexI)
				linkSub.innerText="-"

			}
			
		}
		objLink.innerText='-'
	}
}
function collapseSubHeader(objLink,indexI,index)
{

	if(objLink.innerText=='-')
	{
		
		var noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI)
			for(var indexJ = 0; indexJ < parseInt(noOfRows.value);indexJ++)	
			{
				var trRowId = document.getElementById("rowId"+index+indexI+indexJ)
				trRowId.style.display='none'
			}
		objLink.innerText='+'
	}
	else
	{
		var noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI)
			for(var indexJ = 0; indexJ < parseInt(noOfRows.value);indexJ++)	
			{
				var trRowId = document.getElementById("rowId"+index+indexI+indexJ)
				trRowId.style='display';
			}
		objLink.innerText='-'
	}
}
function collapseAllRows(objLink,indexI,indexJ,indexK)
{
	if(objLink.innerText=="-")
	{
		
		var noOfRows= eval("document.patTaskListResultForm.noOfRows"+indexI+indexJ+indexK);

		for(var index = 0;index < parseInt(noOfRows.value);index++)
		{
					var trRowId=document.getElementById("rowId"+indexI+indexJ+indexK+index)
					trRowId.style.display='none'	
		}
		objLink.innerText='+'
	}
	else
	{
		var noOfRows= eval("document.patTaskListResultForm.noOfRows"+indexI+indexJ+indexK);

		for(var index = 0;index < parseInt(noOfRows.value);index++)
		{
					var trRowId=document.getElementById("rowId"+indexI+indexJ+indexK+index)
					trRowId.style='display';	
		}
		objLink.innerText='-'
	}
}
function collapseAllSubRows(objLink,index,indexI)
{
	
	if(objLink.innerText == '-')
	{
		objLink.innerText='+'
		var lastRows = eval("document.patTaskListResultForm.lastHeader"+index+indexI)

		for(var ii=0;ii < parseInt(lastRows.value);ii++)
		{

			var noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI+ii);

			for(var indexJ = 0 ;indexJ < parseInt(noOfRows.value);indexJ++)
			{
				var trRowId=document.getElementById("rowId"+index+indexI+ii+indexJ)
				trRowId.style.display='none'	
			}
			var subRowId =  document.getElementById("lastRow"+index+indexI+ii)
			subRowId.style.display='none'	
		}
	}
	else
	{
		var lastRows = eval("document.patTaskListResultForm.lastHeader"+index+indexI)
		for(var ii=0;ii < parseInt(lastRows.value);ii++)
		{
			var noOfRows = eval("document.patTaskListResultForm.noOfRows"+index+indexI+ii);
			for(var indexJ = 0 ;indexJ < parseInt(noOfRows.value);indexJ++)
			{
				var trRowId=document.getElementById("rowId"+index+indexI+ii+indexJ)
				trRowId.style='display';	
			}
			var subRowId =  document.getElementById("lastRow"+index+indexI+ii)
			subRowId.style='display';	
			var objLinkText =  document.getElementById("lastLink"+index+indexI+ii)
			objLinkText.innerText='-'
		}
	
		objLink.innerText='-'
	}
}
function collapseAllMainRows(objLink,index)
{
	var subHeader = eval("document.patTaskListResultForm.subHeader"+index);
	
	
	if(objLink.innerText=='-')
	{
		var mainRow = document.getElementById("mainRow"+index)
		for(var indexI=0;indexI < parseInt(subHeader.value);indexI++)
		{
			var lastRow = eval("document.patTaskListResultForm.lastHeader"+index+indexI);
			
			for(var indexJ=0;indexJ < parseInt(lastRow.value);indexJ++)
			{
				var noOfRows =  eval("document.patTaskListResultForm.noOfRows"+index+indexI+indexJ);
				for(var indexK=0;indexK < parseInt(noOfRows.value);indexK++)
				{
					
					var trRowId = document.getElementById("rowId"+index+indexI+indexJ+indexK);
						trRowId.style.display='none'
				}
			var subRowTr = document.getElementById("lastRow"+index+indexI+indexJ);
			subRowTr.style.display='none'

			}
			var lastRowTr = document.getElementById("subRow"+index+indexI);
			lastRowTr.style.display='none'
		}
		objLink.innerText='+'
		mainRow.cells((mainRow.cells.length-1)).colSpan+=1
	}
	else
	{
		for(var indexI=0;indexI < parseInt(subHeader.value);indexI++)
		{
			var lastRow = eval("document.patTaskListResultForm.lastHeader"+index+indexI);
			for(var indexJ=0;indexJ < parseInt(lastRow.value);indexJ++)
			{
				var noOfRows =  eval("document.patTaskListResultForm.noOfRows"+index+indexI+indexJ);
				for(var indexK=0;indexK < parseInt(noOfRows.value);indexK++)
				{
					var trRowId = document.getElementById("rowId"+index+indexI+indexJ+indexK);
						trRowId.style='display';
				}
				var subRowTr = document.getElementById("lastRow"+index+indexI+indexJ);
				subRowTr.style='display';
				var lastLink = document.getElementById("lastLink"+index+indexI+indexJ)
				lastLink.innerText='-'
			}
			var lastRowTr = document.getElementById("subRow"+index+indexI);
			lastRowTr.style='display';
			var subLink = document.getElementById("subLink"+index+indexI)
			subLink.innerText='-'
		}
		objLink.innerText='-'
	}

}
function sortRecord(sortText,objLink)
{
	
	if(parent.patTaskListCriteriaFrame != null)
	{

	var objHidden = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.sortOrder.value;
	var sortSelection="";
	if(objHidden =='')
	{
		if(objHidden != '')
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.sortOrder.value='desc'
		}
		else
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.sortOrder.value='asc'
		}
	}
	else
	{
		if(objHidden == 'asc')
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.sortOrder.value='desc'
		}
		else
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.sortOrder.value='asc'
		}
	}
	switch(sortText)
	{
		case 'Date':sortSelection='6'
						break;
		case 'TaskType':sortSelection='3'
						break;
		case 'Task':sortSelection='5'
						break;
		case 'Priority':sortSelection='11'
						break;
		case 'PatientDetails':sortSelection='9'
						break;
		case 'Status':sortSelection='12'
						break;
		default : break;
	}
	var task =""
//parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.task.value;
	var taskCode ="";
	//	parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskCode.value;
	var shift =""
	//	parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.shift.value;
	var priority = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.priority.value;
	var fromDate = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.fromDate.value;
	var toDate = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.toDate.value;
	var fields = new Array(parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.fromDate,parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.toDate);
	var names= new Array(getLabel("Common.fromdate.label","COMMON"),getLabel("Common.todate.label","COMMON"))

	var PatientId = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.PatientId.value;
	var encounterId=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.encounterId.value;
	var locationCode =parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationCode.value;
	var status =parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.status.value;
	var dateTime = 	parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.dateTime.value;
	var patientDetail=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientDetail.value;
	var taskSelect=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskSelect.value;
	var sortOrder=parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.sortOrder.value;
	var facility_id =parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.facility_id.value;
	var checkSpecimen = ""
	var checkIntervention = ""
	var checkAdminMedication = ""
	var checkResult = ""

	if(parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.checkSpecimen.checked==true)
		checkSpecimen = 'Y'
	else
		checkSpecimen = ''
	if(parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.checkIntervention.checked==true)
		checkIntervention='Y'
	else
	checkIntervention=''
	if(parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.checkAdminMedication.checked==true)
		checkAdminMedication='Y'
		else
		checkAdminMedication=''
	if(parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.checkResult.checked==true)
		checkResult='Y'
	else
		checkResult=''

	if(checkFieldsofMst( fields, names, top.content.messageFrame))
	{
		if(ValidateDateTimeOfPeriodoFSearch(parent.patTaskListCriteriaFrame.document.getElementById("fromDate"),parent.patTaskListCriteriaFrame.document.getElementById("toDate")))
		{	

			var patientFlag = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value
			if(patientFlag == '')
			{
				if(parent.document.getElementById("patTaskListFrameSet").rows=='21%,0%,0%,*,0%,5%' )
				{
					
					top.content.workAreaFrame.patTaskListResultFrame1.location.href = '../../eCA/jsp/PatTaskListResult.jsp?task='+task+'&taskCode='+taskCode+'&shift='+shift+'&priority='+priority+'&fromDate='+fromDate+'&toDate='+toDate+'&PatientId='+PatientId+'&encounterId='+encounterId+'&locationCode='+locationCode+'&status='+status+'&dateTime='+dateTime+'&patientDetail='+patientDetail+'&taskSelect='+taskSelect+'&sortOrder='+sortOrder+'&facility_id='+facility_id+'&sortSelection='+sortSelection+'&flagString=load&checkResult='+checkResult+'&checkAdminMedication='+checkAdminMedication+'&checkIntervention='+checkIntervention+'&checkSpecimen='+checkSpecimen+'&stage='+parent.patTaskListCriteriaFrame.document.forms[0].stage.value

				}
				else
				{

					top.content.workAreaFrame.patTaskListResultFrame.location.href = '../../eCA/jsp/PatTaskListResult.jsp?task='+task+'&taskCode='+taskCode+'&shift='+shift+'&priority='+priority+'&fromDate='+fromDate+'&toDate='+toDate+'&PatientId='+PatientId+'&encounterId='+encounterId+'&locationCode='+locationCode+'&status='+status+'&dateTime='+dateTime+'&patientDetail='+patientDetail+'&taskSelect='+taskSelect+'&sortOrder='+sortOrder+'&facility_id='+facility_id+'&sortSelection='+sortSelection+'&flagString=load&checkResult='+checkResult+'&checkAdminMedication='+checkAdminMedication+'&checkIntervention='+checkIntervention+'&checkSpecimen='+checkSpecimen+'&stage='+parent.patTaskListCriteriaFrame.document.forms[0].stage.value

				}
			}
			else
			{
				if(parent.document.getElementById("patTaskListFrameSet").rows=='17%,0%,0%,*,0%,5%' )
				{
					
					top.content.workAreaFrame.patTaskListResultFrame1.location.href = '../../eCA/jsp/PatTaskListResult.jsp?task='+task+'&taskCode='+taskCode+'&shift='+shift+'&priority='+priority+'&fromDate='+fromDate+'&toDate='+toDate+'&PatientId='+PatientId+'&encounterId='+encounterId+'&locationCode='+locationCode+'&status='+status+'&dateTime='+dateTime+'&patientDetail='+patientDetail+'&taskSelect='+taskSelect+'&sortOrder='+sortOrder+'&facility_id='+facility_id+'&sortSelection='+sortSelection+'&flagString=load&checkResult='+checkResult+'&checkAdminMedication='+checkAdminMedication+'&checkIntervention='+checkIntervention+'&checkSpecimen='+checkSpecimen+'&stage='+parent.patTaskListCriteriaFrame.document.forms[0].stage.value

					
				}
				else
				{
	
					top.content.workAreaFrame.patTaskListResultFrame.location.href = '../../eCA/jsp/PatTaskListResult.jsp?task='+task+'&taskCode='+taskCode+'&shift='+shift+'&priority='+priority+'&fromDate='+fromDate+'&toDate='+toDate+'&PatientId='+PatientId+'&encounterId='+encounterId+'&locationCode='+locationCode+'&status='+status+'&dateTime='+dateTime+'&patientDetail='+patientDetail+'&taskSelect='+taskSelect+'&sortOrder='+sortOrder+'&facility_id='+facility_id+'&sortSelection='+sortSelection+'&flagString=load&checkResult='+checkResult+'&checkAdminMedication='+checkAdminMedication+'&checkIntervention='+checkIntervention+'&checkSpecimen='+checkSpecimen+'&stage='+parent.patTaskListCriteriaFrame.document.forms[0].stage.value
				}
			}
		}
		
	}
	}
	
}
function populateListForDateTime(objSelect)
{
	var element = document.createElement("OPTION");
		element.text  = 'Date'	
		element.value='6'
		objSelect.add(element)
	var element = document.createElement("OPTION");
		element.text  = 'Task Type'	
		element.value='3'
		objSelect.add(element);
}
function displayToolTip(event,index)
{
	var obj1=document.getElementById("tooltiplayer"+index);
/*	var count = document.patTaskListResultForm.count.value
	for(var indexI =0 ;indexI < parseInt(count);indexI++)
		{
			if(index != indexI)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexI);
					obj.style.visibility='hidden'
			}
		}*/
	if(obj1 != null)
	{

			buildTable(index)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}
}
function callMouseOver(obj)
{

		currClass = obj.className ;
		obj.className = 'CAMENU';

}
function callOnMouseOut(obj)
{
	
		obj.className = currClass;
}
function buildTable(index)
{
	var p='P'
	var N='N'
	var status = eval("document.forms[0].status"+index);
	var adminStatus = eval("document.forms[0].adminStatus"+index);
	if(adminStatus.value=='D' || adminStatus.value == 'O')
	{
		 if(status.value=='Pending')
		{
			performTask(index)
		}
	}
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTask("+index+",\""+p+"\")' ><font color='blue'>Performed</font></a></td>";
			
			tab_dat     += "</tr>";
				tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTask(\""+index+"\",\""+N+"\")'><font color='blue'> Not Performed</font></a></td>";
			tab_dat     += "</tr>";
			tab_dat     += "</table>";
			var td = eval("document.getElementById("t")"+index);
			td.innerHTML = tab_dat;
			*/
}
function hideToolTip(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		td.style.visibility = 'hidden'
	}
}
async function performTask(index)
{
	hideToolTip(index)
	var rowId = document.getElementById("rowId"+index);

	var dateTime =  eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index);;
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	var dialogTop		=	"200" ;
	var dialogHeight= "20vh" ;
    var dialogWidth = "50vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
		SearchTaskCriteriaForPerform()

}
function getPractitioner()
{
		
		var pract_type=document.patTaskListPerformForm.pract_type.value;
		var serviceVal   ="";
		var search_desc	= "";
		var target = document.patTaskListPerformForm.practitonerName;

		var locale = document.patTaskListPerformForm.locale.value;

		//sql = "SELECT practitioner_id code,practitioner_name description FROM am_practitioner WHERE  upper(practitioner_id) like upper(?)  and upper(practitioner_name) like upper(?) AND EFF_STATUS='E' and PRACT_TYPE ='"+pract_type+"' ORDER BY 2 ";

		sql = "SELECT practitioner_id code,practitioner_name description FROM am_practitioner_LANG_VW WHERE  practitioner_id like upper(?)  and upper(practitioner_name) like upper(?) AND EFF_STATUS='E' and PRACT_TYPE ='"+pract_type+"' AND LANGUAGE_ID = '"+locale+"' ORDER BY 2 ";

		target.value='';
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
		retArray = CommonLookup( 'Practitioner', argArray );
		if(retArray.length != 0)
		{
			 document.patTaskListPerformForm.practitonerName.value=retArray[1];
			 document.patTaskListPerformForm.practitonerId.value=retArray[0];
		}

}

function getPractitionerDiscreteMeasure()
{
		var pract_type=document.patTaskListDiscreteForm.pract_type.value;
		var serviceVal   ="";
		var search_desc	= "";
		var target = document.patTaskListDiscreteForm.practitonerName;

		var locale = document.patTaskListDiscreteForm.locale.value;

		//sql = "SELECT practitioner_id code,practitioner_name description FROM am_practitioner WHERE  upper(practitioner_id) like upper(?)  and upper(practitioner_name) like upper(?) AND EFF_STATUS='E' and PRACT_TYPE ='"+pract_type+"' ORDER BY 2 ";

		sql = "SELECT practitioner_id code,practitioner_name description FROM am_practitioner_LANG_VW WHERE  practitioner_id like upper(?)  and upper(practitioner_name) like upper(?) AND EFF_STATUS='E' and PRACT_TYPE ='" +pract_type+ "' AND LANGUAGE_ID = '"+locale+"' ORDER BY 2 ";

		target.value='';
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
		retArray = CommonLookup( 'Practitioner', argArray );
		if(retArray.length != 0)
		{
			 document.patTaskListDiscreteForm.practitonerName.value=retArray[1];
			 document.patTaskListDiscreteForm.practitonerId.value=retArray[0];
		}

}

function recording()
{
		var dateTime = document.patTaskListPerformForm.dateTime
		var practitonerName= document.patTaskListPerformForm.practitonerName
		var remarks= document.patTaskListPerformForm.remarks
		var status	= document.patTaskListPerformForm.status

		if(status.value !='N')
		{
			if(dateTime.value=='')
			{
				alert(getMessage("DATE_TIME_NOT_BLANK","CA"));
				dateTime.select();
				return false
			}
			if(practitonerName.value=="")
			{
				alert(getMessage("PERFORMED_NOT_BLANK","CA"));
				practitonerName.select();
				return false
			}
			if(remarks.value=="")
			{
				var msg = getMessage("CAN_NOT_BE_BLANK","common");
				msg = msg.replace('$', 'Remarks');
				alert(msg);
				remarks.select();
				return false
			}
		}
		else
		{
			if(practitonerName.value=="")
			{
				alert(getMessage("PERFORMED_NOT_BLANK","CA"));
				practitonerName.select();
				return false
			}
			if(remarks.value=="")
			{
				alert(getMessage("REASON_NOT_BLANK","CA"));
				remarks.select();
				return false
			}
		}
		document.patTaskListPerformForm.submit();
		window.close();
		

}
function checkForCurrentDate()
{
		var currDate = document.forms[0].sysdate.value
		var fromDate1 = document.forms[0].dateTime.value

	if(fromDate1 !="")
	{
		fromDate = fromDate1.split(" ");
	
		var retVal = checkDt(fromDate[0]);
		
	 if( retVal)
		{
		  
		  var splitdate =fromDate[0].split("/")
		  var splitdate1 =currDate.split("/")
		   var from_date  =new Date(eval(splitdate[2]), eval(splitdate[1])-1, eval(splitdate[0]))
		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]))
			if(Date.parse(to_date) < Date.parse(from_date))
			{
					alert(getMessage("DATE_TIME_GREATER_SYSDATE","CA"))	;		
					document.patTaskListPerformForm.dateTime.select();
					return false		   
			}
			else
				return true;
		}
		else
		{
			return true;
		}
	}

}
function cancel()
{
	window.close()
}
function displayToolTip1(event,index,detail)
{
	var obj1=document.getElementById("tooltiplayer"+index);
	var count = document.patTaskListResultForm.count.value
/*	for(var indexI =0 ;indexI < parseInt(count);indexI++)
	{
		if(index != indexI)
		{
			var obj = eval("document.getElementById("tooltiplayer")"+indexI);
				obj.style.visibility='hidden'
		}
	}*/
	if(obj1 != null)
	{
		buildTable1(index,detail)
	/*	bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
		var x 	  = event.x;
		var y 	  = event.y;
		x 	  = x + (obj1.offsetWidth)
		y 	  = y + (obj1.offsetHeight)
		if(x<bodwidth)
			x = event.x 
		else
			x = x - (obj1.offsetWidth*2)
		if(y<bodheight)
			y = event.y
		else
			y = y - (obj1.offsetHeight*2)			
		y+=document.body.scrollTop
		x+=document.body.scrollLeft
		obj1.style.posLeft= x
		obj1.style.posTop = y
		obj1.style.visibility='visible' */
	}
}
function buildTable1(index,detail)
{
	var p='P'
	var N='N'
	var status = eval("document.forms[0].status"+index+".value");
	if(status != 'Not Performed')
	{
		performTask1(index,p,detail)	
	}
	else
	{
			performTask1(index,N,detail)
	}
}
async function performTask1(index,Status,detail)
{
	hideToolTip(index)
	var rowId = document.getElementById("rowId"+index);

	var dateTime =eval("document.forms[0].scheduleDate"+index+".value");;
	
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index);;
	
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);

	var dialogTop		=	"200" ;
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&detail='+detail;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()


}
function displayToolTipForPopulation(event,index,indexI,noOfRows)
{
	var obj1=document.getElementById("tooltiplayer"+index);
	var count = document.patTaskListResultForm.count.value
/*	for(var indexJ =0 ;indexJ < parseInt(count);indexJ++)
		{
			if(index != indexJ)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexJ);
					obj.style.visibility='hidden'
			}
		}*/
	if(obj1 != null)
	{

			buildTablePopulation(index,indexI,noOfRows)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}
}
function buildTablePopulation(index,indexI,noOfRows)
{
	var p='P'
	var N='N'
var status = eval("document.forms[0].status"+index);
var adminStatus = eval("document.forms[0].adminStatus"+index);
	if(adminStatus.value=='D' || adminStatus.value == 'O')
	{
		 if(status.value=='Pending')
		{
		 	performTaskPopulation(index,indexI,noOfRows)
		}
	}

/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskPopulation("+index+",\""+p+"\","+indexI+","+noOfRows+")'> <font color='blue'>Performed</font></a></td>";
			
			tab_dat     += "</tr>";
				tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskPopulation("+index+",\""+N+"\","+indexI+","+noOfRows+")'><font color='blue'> Not Performed</font></a></td>";
			tab_dat     += "</tr>";
			tab_dat     += "</table>";
			var td = eval("document.getElementById("t")"+index);
			td.innerHTML = tab_dat;*/
}
function hideToolTipPopulation(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		td.style.visibility = 'hidden'
	}
}
async function performTaskPopulation(index,indexI,noOfRows)
{
	hideToolTipPopulation(index)
	var rowId = document.getElementById("trRowId"+indexI+noOfRows);

	var dateTime =eval("document.forms[0].scheduleDate"+index);
	var taskType =   eval("document.forms[0].taskCode"+index);

	var task =  eval("document.forms[0].taskType"+index);

	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);

	var patientId = eval("document.forms[0].patientId"+index);;

	
	var remarks = eval("document.forms[0].remarks"+index);

	var performedId  = eval("document.forms[0].performedId"+index);
	
	var dialogTop		=	"200" ;
		var dialogHeight= "20" ;
    var dialogWidth = "50" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime.value+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()

}
function displayToolTipForPopulation1(event,index,indexI,noOfRows)
{
	var obj1=document.getElementById("tooltiplayer"+index);
	var count = document.patTaskListResultForm.count.value
/*	for(var indexJ =0 ;indexJ < parseInt(count);indexJ++)
		{
			if(index != indexJ)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexJ);
					obj.style.visibility='hidden'
			}
		}*/
	if(obj1 != null)
	{

			buildTablePopulation1(index,indexI,noOfRows)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}
}
function buildTablePopulation1(index,indexI,noOfRows)
{
	var p='P'
	var N='N'
	var detail='Details'
	
	var status = eval("document.forms[0].status"+index+".value");
	
	if(status != 'Not Performed')
	{
		performTaskPopulation1(index,p,detail,indexI,noOfRows);
	}
	else
	{
			performTaskPopulation1(index,N,detail,indexI,noOfRows);
	}
}
function hideToolTipPopulation1(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		td.style.visibility = 'hidden'
	}
}
async function performTaskPopulation1(index,Status,detail,indexI,noOfRows)
{
	hideToolTipPopulation(index)
	var rowId = document.getElementById("trRowId"+indexI+noOfRows);
	
	var dateTime =eval("document.forms[0].scheduleDate"+index)
	var taskType =   eval("document.forms[0].taskCode"+index);

	var task =  eval("document.forms[0].taskType"+index);

	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);

	var patientId = eval("document.forms[0].patientId"+index);;

	
	var remarks = eval("document.forms[0].remarks"+index);

	var performedId  = eval("document.forms[0].performedId"+index);
	
	var dialogTop		=	"200" ;
	var dialogHeight= "24vh" ;
    var dialogWidth = "33vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime.value+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&detail='+detail;
	var retVal=await top.window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()


}
function displayToolTipForPopulationCriteria(event,index,indexK,indexI,noOfRows)
{
	var obj1=document.getElementById("tooltiplayer"+index);
/*	var count = document.patTaskListResultForm.count.value
	for(var indexJ =0 ;indexJ < parseInt(count);indexJ++)
		{
			if(index != indexJ)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexJ);
					obj.style.visibility='hidden'
			}
		}*/
	if(obj1 != null)
	{

			buildTablePopulationCriteria(index,indexK,indexI,noOfRows)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}
}
function buildTablePopulationCriteria(index,indexK,indexI,noOfRows)
{
	var p='P'
	var N='N'
	var status = eval("document.forms[0].status"+index);
	var adminStatus = eval("document.forms[0].adminStatus"+index);
	if(adminStatus.value=='D' || adminStatus.value == 'O')
	{
		 if(status.value=='Pending')
		{
			performTaskPopulationCriteria(index,indexK,indexI,noOfRows)
		}
	}
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskPopulationCriteria("+index+",\""+p+"\","+indexK+","+indexI+","+noOfRows+")'> <font color='blue'>Performed</font></a></td>";
			
			tab_dat     += "</tr>";
				tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskPopulationCriteria("+index+",\""+N+"\","+indexK+","+indexI+","+noOfRows+")'><font color='blue'> Not Performed</font></a></td>";
			tab_dat     += "</tr>";
			tab_dat     += "</table>";
			var td = eval("document.getElementById("t")"+index);
			td.innerHTML = tab_dat;*/
}
function hideToolTipPopulationCriteria(index)
{
	var td= parent.patTaskListResultFrame.patTaskListResultForm.document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		//td.style.visibility = 'hidden'
	}
}
async function performTaskPopulationCriteria(index,indexK,indexI,noOfRows)
{
	hideToolTipPopulationCriteria(index)
	var rowId = document.getElementById("rowId"+indexK+indexI+noOfRows);

	var dateTime =eval("document.forms[0].scheduleDate"+index)
	var taskType =   eval("document.forms[0].taskCode"+index);

	var task =  eval("document.forms[0].taskType"+index);

	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);

	var patientId = eval("document.forms[0].patientId"+index);;

	
	var remarks = eval("document.forms[0].remarks"+index);

	var performedId  = eval("document.forms[0].performedId"+index);
	
	var dialogTop		=	"200" ;
		var dialogHeight= "20" ;
    var dialogWidth = "50" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime.value+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()



}
function displayToolTipForPopulationCriteria1(event,index,indexK,indexI,noOfRows)
{

	var obj1=document.getElementById("tooltiplayer"+index);
	var count = document.patTaskListResultForm.count.value
/*	for(var indexJ =0 ;indexJ < parseInt(count);indexJ++)
		{
			if(index != indexJ)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexJ);
					obj.style.visibility='hidden'
			}
		}*/
	if(obj1 != null)
	{

			buildTablePopulationCriteria1(index,indexK,indexI,noOfRows)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}
}
function buildTablePopulationCriteria1(index,indexK,indexI,noOfRows)
{
	var p='P'
	var N='N'
	var detail='Details'

	var status = eval("document.forms[0].status"+index+".value");
	
	if(status != 'Not Performed')
	{
		performTaskPopulationCriteria1(index,p,detail,indexK,indexI,noOfRows)
	}
	else
	{
			performTaskPopulationCriteria1(index,N,detail,indexK,indexI,noOfRows)
	}
	
	var td = document.getElementById("t"+index);

}
function hideToolTipPopulationCriteria1(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		//td.style.visibility = 'hidden'
	}
}
async function performTaskPopulationCriteria1(index,Status,detail,indexK,indexI,noOfRows)
{
	hideToolTipPopulationCriteria1(index)
	var rowId = document.getElementById("rowId"+indexK+indexI+noOfRows);
	
	var dateTime =eval("document.forms[0].scheduleDate"+index)
	var taskType =   eval("document.forms[0].taskCode"+index);

	var task =  eval("document.forms[0].taskType"+index);

	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);

	var patientId = eval("document.forms[0].patientId"+index);;

	
	var remarks = eval("document.forms[0].remarks"+index);

	var performedId  = eval("document.forms[0].performedId"+index);
	
	var dialogTop		=	"200" ;
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime.value+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&detail='+detail;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()

}
// Result
function displayToolTipForPopulationResult(event,index,indexK,indexI,temp,noOfRows)
{
	var obj1=document.getElementById("tooltiplayer"+index);
	var count = document.patTaskListResultForm.count.value
/*	for(var indexJ =0 ;indexJ < parseInt(count);indexJ++)
		{
			if(index != indexJ)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexJ);
					obj.style.visibility='hidden'
			}
		}*/
	if(obj1 != null)
	{

			buildTablePopulationResult(index,indexK,indexI,temp,noOfRows)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}
}
function buildTablePopulationResult(index,indexK,indexI,temp,noOfRows)
{
	var p='P'
	var N='N'
	var status = eval("document.forms[0].status"+index);
	var adminStatus = eval("document.forms[0].adminStatus"+index);
	if(adminStatus.value=='D' || adminStatus.value == 'O')
	{
		 if(status.value=='Pending')
		{
			performTaskPopulationResult(index,indexK,indexI,temp,noOfRows)
		}
	}
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskPopulationResult("+index+",\""+p+"\","+indexK+","+indexI+","+temp+","+noOfRows+")'> <font color='blue'>Performed</font></a></td>";
			
			tab_dat     += "</tr>";
				tab_dat     += "<tr>";
			tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskPopulationResult("+index+",\""+N+"\","+indexK+","+indexI+","+temp+","+noOfRows+")'><font color='blue'> Not Performed</font></a></td>";
			tab_dat     += "</tr>";
			tab_dat     += "</table>";
			var td = eval("document.getElementById("t")"+index);
			td.innerHTML = tab_dat;*/
}
function hideToolTipPopulationResult(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		td.style.visibility = 'hidden'
	}
}
async function performTaskPopulationResult(index,indexK,indexI,temp,noOfRows)
{
	hideToolTipPopulationResult(index)
	
	var rowId = document.getElementById("rowId"+indexK+indexI+temp+noOfRows);
	
	var dateTime =eval("document.forms[0].scheduleDate"+index)
	var taskType =   eval("document.forms[0].taskCode"+index);

	var task =  eval("document.forms[0].taskType"+index);

	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);

	var patientId = eval("document.forms[0].patientId"+index);;

	
	var remarks = eval("document.forms[0].remarks"+index);

	var performedId  = eval("document.forms[0].performedId"+index);
	
	var dialogTop		=	"200" ;
	var dialogHeight= "20" ;
    var dialogWidth = "50" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime.value+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()

}
//Result1
function displayToolTipForPopulationResult1(event,index,indexK,indexI,temp,noOfRows)
{

	var obj1=document.getElementById("tooltiplayer"+index);
	var count = document.patTaskListResultForm.count.value
/*	for(var indexJ =0 ;indexJ < parseInt(count);indexJ++)
		{
			if(index != indexJ)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexJ);
					obj.style.visibility='hidden'
			}
		}
*/
	if(obj1 != null)
	{

			buildTablePopulationResult1(index,indexK,indexI,temp,noOfRows)
	/*		bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' 
		*/
	}
}
function buildTablePopulationResult1(index,indexK,indexI,temp,noOfRows)
{
	var p='P'
	var N='N'
	var detail='Details'
	
	var status = eval("document.forms[0].status"+index+".value");
	
	if(status != 'Not Performed')
	{
		performTaskPopulationResult1(index,p,detail,indexK,indexI,temp,noOfRows);
	}
	else
	{
			performTaskPopulationResult1(index,N,detail,indexK,indexI,temp,noOfRows)
	}
	
}
function hideToolTipPopulationResult1(index)
{

	var td= document.getElementById("tooltiplayer"+index)
	if(td != null)
	{
		td.style.visibility = 'hidden'
	}
}
async function performTaskPopulationResult1(index,Status,detail,indexK,indexI,temp,noOfRows)
{
	hideToolTipPopulationCriteria1(index)
	var rowId = document.getElementById("rowId"+indexK+indexI+temp+noOfRows);
	
	var dateTime =eval("document.forms[0].scheduleDate"+index)
	var taskType =   eval("document.forms[0].taskCode"+index);

	var task =  eval("document.forms[0].taskType"+index);

	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);

	var patientId = eval("document.forms[0].patientId"+index);;

	
	var remarks = eval("document.forms[0].remarks"+index);

	var performedId  = eval("document.forms[0].performedId"+index);
	
	var dialogTop		=	"200" ;
	var dialogHeight= "14" ;
    var dialogWidth = "30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListPerformFrameSet.jsp?dateTime='+dateTime.value+'&taskType='+taskType.value+'&task='+task.value+'&patientId='+patientId.value+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&detail='+detail;
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()

}
//Adhoc
async function recordAdhoc()
{
	var patientId = document.patTaskCriteriaForm.PatientId.value
	var encounterId = document.patTaskCriteriaForm.encounterId.value
	var priority= document.patTaskCriteriaForm.priority.value
		if(priority=='')
		{
				priority='R'
		}
	var dialogTop		=	"150" ;
	var dialogHeight= "21";
    var dialogWidth = "38" ;  //35
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListAdhocInterventionFrameSet.jsp?patientId='+patientId+'&encounterId='+encounterId+'&priority='+priority;
	var retVal=await window.showModalDialog(action_url,arguments,features);	
	SearchTaskCriteria("criteria")

}
function getTaskforCriteria(obj)
{
	var htmlVal = "";
	var sql = "";
	
	var task = document.patTaskListAdhocForm.taskType.value;

	var locale = document.patTaskListAdhocForm.locale.value;

	//alert(locale);

	if(obj.name=='taskDesc')
	{
		htmlVal = "<html><form name='tempForm' id='tempForm' action='../../eCA/jsp/PatTaskListIntermediate.jsp' method='post'><input type='hidden' name='task' id='task' value='"+task+"'><input type='hidden' name='taskDesc' id='taskDesc' value='"+obj.value+"'><input type='hidden' name='calledFrom' id='calledFrom' value='task1'></form></html>";
		parent.blankFrame.document.write(htmlVal);
		parent.blankFrame.document.tempForm.submit();
	}
	else
	{
		
		var serviceVal   ="";
		var search_desc	= "";
		var target = document.patTaskListAdhocForm.taskDesc;
		var task = document.patTaskListAdhocForm.taskType.value;
		
		if(task=="")
		{
			task  = "%"
		}
		else
		{
			task  = task  
		}
		//alert(task);
		
		//sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION WHERE  upper(INTERVENTION_CODE) like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' and upper(INTERVENTION_TYPE) like upper('"+task+"') ORDER BY SHORT_DESC ";

		if (task=="%")
		{
		sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE  INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' AND  LANGUAGE_ID = '"+locale+"'  ORDER BY SHORT_DESC "; 
		}
		else {
		sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE  INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' AND  LANGUAGE_ID = '"+locale+"' and upper(INTERVENTION_TYPE) like upper('"+task+"') ORDER BY SHORT_DESC "; 
		}	
	
		target.value='';
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		var title=getLabel("eCA.Task.label","CA")
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = CommonLookup( title, argArray );
		if(retArray.length != 0)
		{
			document.patTaskListAdhocForm.taskDesc.value=retArray[1];
			document.patTaskListAdhocForm.taskCode.value=retArray[0];
		}
	}
}
function getPractitionerCriteria()
{
		var pract_type=document.patTaskListAdhocForm.pract_type.value;
		var serviceVal   ="";
		var search_desc	= "";
		var target = document.patTaskListAdhocForm.practitonerName;

		var locale = document.patTaskListAdhocForm.locale.value;

		//sql = "SELECT practitioner_id code,practitioner_name description FROM am_practitioner WHERE  upper(practitioner_id) like upper(?)  and upper(practitioner_name) like upper(?) AND EFF_STATUS='E' and PRACT_TYPE ='"+pract_type+"' ORDER BY 2 ";

		sql = "SELECT practitioner_id code,practitioner_name description FROM am_practitioner_LANG_VW WHERE  practitioner_id like upper(?)  and upper(practitioner_name) like upper(?) AND EFF_STATUS='E' and PRACT_TYPE ='"+pract_type+"' AND LANGUAGE_ID = '"+locale+"' ORDER BY 2 ";

		target.value='';
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
		retArray = CommonLookup( 'Practitioner', argArray );
		if(retArray.length != 0)
		{
			 document.patTaskListAdhocForm.practitonerName.value=retArray[1];
			 document.patTaskListAdhocForm.practitonerId.value=retArray[0];
		}

}
function recordingAdhoc()
{
		var dateTime = document.patTaskListAdhocForm.dateTime
		var practitonerName= document.patTaskListAdhocForm.practitonerName
		var remarks= document.patTaskListAdhocForm.remarks
		var taskType = document.patTaskListAdhocForm.taskType
		var taskDesc = document.patTaskListAdhocForm.taskDesc
		if(taskType.value=='')
			{
				alert(getMessage("TASK_NOT_BLANK","CA"));
				taskType.focus();
				return false
			}
		if(taskDesc.value=='')
			{
				alert(getMessage("TASK_TYPE_NOT_BLANK","CA"));
				//taskDesc.select();
				return false
			}
		if(dateTime.value=='')
			{
				alert(getMessage("DATE_TIME_NOT_BLANK","CA"));
				dateTime.select();
				return false
			}
			if(practitonerName.value=="")
			{
				alert(getMessage("PERFORMED_NOT_BLANK","CA"));
				practitonerName.select();
				return false
			}
			if(remarks.value=="")
			{
				var msg = getMessage("CAN_NOT_BE_BLANK","common");
				msg = msg.replace('$', 'Remarks');
				alert(msg);
				remarks.select();
				return false
			}
			document.patTaskListAdhocForm.method='post';
			document.patTaskListAdhocForm.action='../../servlet/eCA.PatTaskListAdhocServlet';	
			document.patTaskListAdhocForm.submit()
			

}	
function checkForPatient(objText,flag)
{
	 	 
	if(objText.value != '')
	{
		
		var htmlVal = "<html><form name='tempForm' id='tempForm' action='../../eCA/jsp/PatTaskListSortIntermediate.jsp' method='post'><input type='hidden' name='patientId' id='patientId' value='"+objText.value+"'><input type='hidden' name='flag' id='flag' value='"+flag+"'></form></html>";
		parent.patTaskListStatusFrame.document.write(htmlVal);
		parent.patTaskListStatusFrame.document.tempForm.submit();
		if(parent.document.getElementById("patTaskListFrameSet").rows != '21%,0%,0%,*,0%,5%')
		document.patTaskCriteriaForm.patientFlag.value='true'
	}
	else
	{
		document.patTaskCriteriaForm.patientFlag.value=''
		document.patTaskCriteriaForm.adhocIntervention.disabled=true;
	}
}

function SearchTaskCriteriaForPerform()
{
	if(parent.patTaskListCriteriaFrame != null)
	{
			
	var patientFlag = parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.patientFlag.value
		//alert(patientFlag);
	parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.flagString1.value='true'
	
	if(patientFlag !='')
	{
		if(parent.document.getElementById("patTaskListFrameSet").rows == '17%,0%,0%,*,0%,5%')
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.target='patTaskListResultFrame1'
		}
		else
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.target='patTaskListResultFrame'
	
		}
	}
	else
	{
		if(parent.document.getElementById("patTaskListFrameSet").rows == '21%,0%,0%,*,0%,5%')
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.target='patTaskListResultFrame1'
		}
		else
		{
			parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.target='patTaskListResultFrame'
	
		}
	}
	
	parent.patTaskListResultFrame.location.href='../../eCommon/html/blank.html';
	setTimeout("SearchTaskCriteria1('flagString')",500);
	//parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.action='../../eCA/jsp/PatTaskListResult.jsp'
	//parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.method='post'
	//parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.submit()
	//SearchTaskCriteria1("criteria");

	}

	
}
function checkTheLength(objTextArea)
{
	if(objTextArea.value.length != 0)
	{
		if(objTextArea.value.length > 400)
			return false
		else
			return true
	}
}
function displayToolTipForEvents(e,index,resultType,resultId)
{
	
	
	var resultDescription = "";
	var jsp = "";
	var orderCategory = eval("document.forms[0].taskCategory"+index);
	if(orderCategory.value=='I')
	{
		if(resultType=='CH')
		{
				resultDescription = "Chart"
				jsp = "ChartRecording.jsp"
		}
		else if(resultType=='DA' || resultType=='DP')
		{
				resultDescription = " Discrete Measure Atomic"
				jsp = "PatTaskListDiscrMeasureAtomicFrameSet.jsp"
		}
		else if (resultType=='NT')
		{
				resultDescription = "Note Type"
				jsp = "PatTaskListNoteType.jsp"
		}
		else if (resultType=='PR')
		{
				resultDescription = "Procedure"
				jsp = "PatTaskListProcedure.jsp"
		}
		else if(resultType=='OR')
		{	
				resultDescription = "Place Order"
				jsp = "EnterOrder.jsp"
		}
		else
		{
			resultDescription = "Result Matrix"
			jsp = "PatTaskListResultMatrix.jsp"
		}
	}
	else if(orderCategory.value=='M')
	{
			resultDescription = "Admin Medication"
		jsp="MedicationAdministrationFTDrugDtls.jsp"

	}
	else if(orderCategory.value=='O')
	{
				resultDescription = "Result Entry"
				jsp="ResultEntry.jsp"
	}
	else if(orderCategory.value=='S')
	{
			resultDescription = "Specimen's Order"
			jsp="SpecimenOrder.jsp"
	}

	var obj1=document.getElementById("tooltiplayer"+index);
/*	var count = document.patTaskListResultForm.count.value
	for(var indexI =0 ;indexI < parseInt(count);indexI++)
	{
			if(index != indexI)
			{
				var obj = eval("document.getElementById("tooltiplayer")"+indexI);
					obj.style.visibility='hidden'
			}
	}*/
	if(obj1 != null)
	{

			buildTableForEvents(index,resultDescription,resultId,jsp,resultType)
		/*	bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' */
	}	

}

function buildTableForEvents(index,resultDescription,resultId,jsp,resultType)
{
	var p='P'
	performTaskForEvents(index,p,resultId,jsp,resultType)
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskForEvents("+index+",\""+p+"\",\""+resultId+"\",\""+jsp+"\",\""+resultType+"\")' ><font color='blue'>"+resultDescription+"</font></a></td>";
	tab_dat     += "</tr>";
	tab_dat     += "</table>";
	var td = eval("document.getElementById("t")"+index);
	td.innerHTML = tab_dat;
	*/
}
async function performTaskForEvents(index,Status,resultId,jsp,resultType)
{

	var rowId = document.getElementById("rowId"+index);hideToolTipPopulationCriteria(index)
	var dateTime = eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patient_id = eval("document.forms[0].patientId"+index+".value");;
	var scheduledDate= eval("document.forms[0].scheduleDate"+index);
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	var orderId =  eval("document.forms[0].orderId"+index);

	var orderNum =  eval("document.forms[0].orderNum"+index);
	var patId =patient_id.split(" ") 
	var OrderId = eval("document.forms[0].orderId"+index+".value")
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	var dialogTop		=	"200" ;
	var dialogHeight= "18	" ;
    var dialogWidth = "30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		
	
	var encounter_id = eval("document.forms[0].encounterId"+index+".value")
	var facility_id  = eval("document.forms[0].facilityId"+index+".value")
	
	if(orderCategory.value=='I')
	{
		if(resultType=='OR' ||resultType=='CH' )
		{
			 dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		 if(encounter_id != "")
			{
					 if(resultType=='OR')
					var action_url		=	'../../eOR/jsp/'+jsp+'?p_task_code='+taskType.value+'&patient_id='+patient_id+'&p_task_srl_no='+taskSrlNo.value+'&function_from=CP&p_start_date_time='+trimString(dateTime)+'&p_order_catalog_code='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			 else
				var action_url		=	'../../eCA/jsp/'+jsp+'?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+dateTime+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&taskCode='+taskType.value+'&task_srl_no='+taskSrlNo.value;
			}
		}
		else
		{

			if(resultType=='DA' || resultType=='DP')
			{
			
				 if(resultType=='DA')
				{
				 dialogTop		=	"200" ;	
					dialogHeight= "21" ;
				  dialogWidth = "50" ;
					 status			=	"no";
				 arguments		=	"" ;
				}
			else
				{
				dialogTop		=	"100" ;
				 dialogHeight= "30" ;
				 dialogWidth = "50" ;
				status			=	"no";
				 arguments		=	"" ;
				}
				 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;	
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patient_id+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
			else
			{
					
					dialogTop		=	"200" ;
					dialogHeight= "18	" ;
					dialogWidth = "30" ;
					status			=	"no";
					arguments		=	"" ;
					 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patient_id+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
		}
	}
	else if(orderCategory.value=='M')
	{
	
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patient_id+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId;
	}
	else if(orderCategory.value=='O')
	{
			dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url	='../../eOR/jsp/'+jsp+'?colval1=CP&orderId='+OrderId+'&report_srl_no='+taskSrlNo.value+'&patient_id='+patient_id+'&order_category='+orderCategory.value
	}
	else if(orderCategory.value=='S')
	{
			
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eOR/jsp/'+jsp+'?p_function_from=CP&p_patient_id='+patient_id+'&p_encounter_id='+encounter_id+'&p_order_id='+OrderId+'&p_start_date_time='+dateTime;
	}
	var retVal=await window.showModalDialog(action_url,arguments,features);	
	//var retVal=window.open(action_url,arguments,features);	
	
	SearchTaskCriteriaForPerform()

	
}

//
function displayToolTipForEventsPopulation(e,index,indexK,noOfRows,resultType,resultId)
{
	
	var resultDescription = "";
	var jsp = "";
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	
	if(orderCategory.value=='I')
	{
		if(resultType=='CH')
		{
				resultDescription = "Chart"
				jsp = "ChartRecording.jsp"
		}
		else if(resultType=='DA' || resultType=='DP')
		{
				resultDescription = " Discrete Measure Atomic"
				jsp = "PatTaskListDiscrMeasureAtomicFrameSet.jsp"
		}
		else if (resultType=='NT')
		{
				resultDescription = "Note Type"
				jsp = "RecClinicalNotesModal.jsp"
		}
		else if (resultType=='PR')
		{
				resultDescription = "Procedure"
				jsp = "PatTaskListProcedure.jsp"
		}
		else if(resultType=='OR')
		{	
				resultDescription = "Place Order"
				jsp = "EnterOrder.jsp"
		}
		else
		{
			resultDescription = "Result Matrix"
			jsp = "PatTaskListResultMatrix.jsp"
		}
	}
	else if(orderCategory.value=='M')
	{
					resultDescription = "Admin Medication"
		jsp="MedicationAdministrationFTDrugDtls.jsp"

	}
	else if(orderCategory.value=='O')
	{
				resultDescription = "Result Entry"
				jsp="ResultEntry.jsp"
	}
	else if(orderCategory.value=='S')
	{
			resultDescription = "Specimen's Order"
			jsp="SpecimenOrder.jsp"
	}


	var obj1=document.getElementById("tooltiplayer"+index);
	var obj1=document.getElementById("tooltiplayer"+index);
/*	var count = document.patTaskListResultForm.count.value;
	for(var indexI =0 ;indexI < parseInt(count);indexI++)
	{
		if(index != indexI)
		{
			var obj = eval("document.getElementById("tooltiplayer")"+indexI);
				obj.style.visibility='hidden'
		}
	}
*/
	if(obj1 != null)
	{

			buildTableForEventsPopulation(index,indexK,noOfRows,resultDescription,resultId,jsp,resultType)
	/*		bodwidth  = document.body.offsetWidth
			bodheight = document.body.offsetHeight
			var x 	  = event.x;
			var y 	  = event.y;
			x 	  = x + (obj1.offsetWidth)
			y 	  = y + (obj1.offsetHeight)
			if(x<bodwidth)
			x = event.x 
			else
			x = x - (obj1.offsetWidth*2)
			if(y<bodheight)
			y = event.y
			else
			y = y - (obj1.offsetHeight*2)
				
			y+=document.body.scrollTop
			x+=document.body.scrollLeft
			obj1.style.posLeft= x
			obj1.style.posTop = y
			obj1.style.visibility='visible' 
			*/
	}	

}

function buildTableForEventsPopulation(index,indexK,noOfRows,resultDescription,resultId,jsp,resultType)
{
	var p='P'
performTaskForEventsPopulation(index,indexK,noOfRows,p,resultId,jsp,resultType)
/*	var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
	tab_dat     += "<tr>";
	tab_dat     += "<td class = 'CAMENULAYER' nowrap OnMouseOver='callMouseOver(this)' OnMouseOut='callOnMouseOut(this)'><a href='javascript:' OnClick='performTaskForEventsPopulation("+index+","+indexK+","+noOfRows+",\""+p+"\",\""+resultId+"\",\""+jsp+"\",\""+resultType+"\")' ><font color='blue'>"+resultDescription+"</font></a></td>";
	tab_dat     += "</tr>";
	tab_dat     += "</table>";
	var td = eval("document.getElementById("t")"+index);
	td.innerHTML = tab_dat;
	*/
}
async function performTaskForEventsPopulation(index,indexK,noOfRows,Status,resultId,jsp,resultType)
{
hideToolTipPopulationCriteria(index)
	var rowId =  document.getElementById("trRowId"+indexK+noOfRows);
	var dateTime =  eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index+".value");;
	
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	var dialogTop		=	"200" ;
	var dialogHeight= "18	" ;
    var dialogWidth = "30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var encounter_id = eval("document.forms[0].encounterId"+index+".value")
	var facility_id  = eval("document.forms[0].facilityId"+index+".value")
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	var OrderId = eval("document.forms[0].orderId"+index+".value")
	var scheduleDate = eval("document.forms[0].scheduleDate"+index+".value")
		
if(orderCategory.value=='I')
{
		if(resultType=='OR' ||resultType=='CH' )
		{
			 dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		 if(encounter_id != "")
			{
					 if(resultType=='OR')
					var action_url		=	'../../eOR/jsp/'+jsp+'?p_task_code='+taskType.value+'&patient_id='+patientId+'&p_task_srl_no='+taskSrlNo.value+'&function_from=CP&p_start_date_time='+trimString(dateTime)+'&p_order_catalog_code='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			 else
				var action_url		=	'../../eCA/jsp/'+jsp+'?patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&taskCode='+taskType.value+'&task_srl_no='+taskSrlNo.value;
			}
		}
		else if(resultType=='NT')
		{
			   dialogTop = "94";
			  dialogHeight = "445";
			  dialogWidth = "790";
			 features = "top="+dialogTop+",height="+dialogHeight+",width="+dialogWidth+",status=no,left=0";

			 var action_url ="../../eCA/jsp/RecClinicalNotesModal.jsp?title=Task List Notes&note_type="+resultId+"&patient_id="+patientId+"&function_id=SPCL_NOTE&episode_id="+encounter_id+"&encounter_id="+encounter_id+"&patient_class=IP&facility_id="+facility_id;
			// var action_url ="../../eCA/jsp/RecClinicalNotes.jsp?title=Task List Notes&appl_task_id=&note_type="+resultId+"&patient_id="+patientId+"&episode_id="+encounter_id+"&patient_class="++"&function_id="++"&event_class="++"&accession_num="++"&window_close="++"&ot_speciality_code="+ot_s+"&hide_header="++"&tab_yn="++"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+;
		}
		else
		{
			if(resultType=='DA' || resultType=='DP')
			{

				 if(resultType=='DA')
				{
				 dialogTop		=	"200" ;	
					dialogHeight= "21" ;
				  dialogWidth = "50" ;
					 status			=	"no";
				 arguments		=	"" ;
				}
			else
				{
				dialogTop		=	"100" ;
				 dialogHeight= "30" ;
				 dialogWidth = "50" ;
				status			=	"no";
				 arguments		=	"" ;
				}
			 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
			else
			{
				dialogTop		=	"200" ;
					dialogHeight= "18	" ;
					dialogWidth = "30" ;
					status			=	"no";
					arguments		=	"" ;
					 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
		}
	}
	else if(orderCategory.value=='M')
	{
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId;
	}
	else if(orderCategory.value=='O')
	{
			dialogTop		=	"140" ;
			 dialogHeight= "550" ;
			 dialogWidth = "1020" ;
			 dialogLeft = "0" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"Height=" + dialogHeight + "; Width=" + dialogWidth + "; Top=" + dialogTop + "; Left=" + dialogLeft + ";scroll=no; status:" + status;
		var action_url	='../../eOR/jsp/'+jsp+'?colval1=CP&orderId='+OrderId+'&report_srl_no='+taskSrlNo.value+'&patient_id='+patientId+'&order_category='+orderCategory.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+document.getElementById("patient_class").value+ '&TLchild_order_index=1&TLchild_reporting_date='+scheduleDate;
	}
	else if(orderCategory.value=='S')
	{
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eOR/jsp/'+jsp+'?p_function_from=CP&p_patient_id='+patientId+'&p_encounter_id='+encounter_id+'&p_order_id='+OrderId+'&p_start_date_time='+dateTime;
	}

	if(resultType=='NT')
	{
		var window_obj = null;
		window_obj =	window.open(action_url,arguments,features);
		if(window_obj != null)
		{
			window_obj.focus();
		}
	}
	else if(orderCategory.value=='O')
	{
		//child =	window.open(action_url,arguments,features);
		parent.patTaskListResultFrame.newWindow(action_url,arguments,features);
	}
	else
	{
		var retVal=await window.showModalDialog(action_url,arguments,features);	
	}
	//var retVal=window.open(action_url,arguments,features);		
	if(orderCategory.value !='O')
	{
		SearchTaskCriteriaForPerform()
	}
	
}

/*function loadpage()
{
	if (child != null)
	{
		if(child.closed == false)
		{
			child.focus();
			window.onblur = loadpage;
			//parent.window.onfocus = loadpage();
			//loadpage();
		}
	} 
}*/
//
function displayToolTipForEventsPopulationCriteria(e,index,indexK,indexJ,noOfRows,resultType,resultId)
{
	var resultDescription = "";
	var jsp = "";
var orderCategory =  eval("document.forms[0].taskCategory"+index);
if(orderCategory.value=='I')
	{
		if(resultType=='CH')
		{
				resultDescription = "Chart"
				jsp = "ChartRecording.jsp"
		}
		else if(resultType=='DA' || resultType=='DP')
		{
				resultDescription = " Discrete Measure Atomic"
				jsp = "PatTaskListDiscrMeasureAtomicFrameSet.jsp"
		}
		else if (resultType=='NT')
		{
				resultDescription = "Note Type"
				jsp = "PatTaskListNoteType.jsp"
		}
		else if (resultType=='PR')
		{
				resultDescription = "Procedure"
				jsp = "PatTaskListProcedure.jsp"
		}
		else if(resultType=='OR')
		{	
				resultDescription = "Place Order"
				jsp = "EnterOrder.jsp"
		}
		else
		{
			resultDescription = "Result Matrix"
			jsp = "PatTaskListResultMatrix.jsp"
		}
	}
	else if(orderCategory.value=='M')
	{
		jsp="MedicationAdministrationFTDrugDtls.jsp"
		resultDescription = "Admin Medication"

	}
	else if(orderCategory.value=='O')
	{
				resultDescription = "Result Entry"
				jsp="ResultEntry.jsp"
	}
	else if(orderCategory.value=='S')
	{
			resultDescription = "Specimen's Order"
			jsp="SpecimenOrder.jsp"
	}
	var obj1=document.getElementById("tooltiplayer"+index);
	if(obj1 != null)
	{

			buildTableForEventsPopulationCriteria(index,indexK,indexJ,noOfRows,resultDescription,resultId,jsp,resultType)
	}	

}

function buildTableForEventsPopulationCriteria(index,indexK,indexJ,noOfRows,resultDescription,resultId,jsp,resultType)
{
	var p='P'
	performTaskForEventsPopulationCriteria(index,indexK,indexJ,noOfRows,p,resultId,jsp,resultType)
}
async function performTaskForEventsPopulationCriteria(index,indexK,indexJ,noOfRows,Status,resultId,jsp,resultType)
{
	
	hideToolTipPopulationCriteria(index)
	var rowId =  document.getElementById("rowId"+indexK+indexJ+noOfRows);
	var dateTime =  eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index+".value");;
	
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);

	var dialogTop		=	"200" ;
	var dialogHeight= "18	" ;
    var dialogWidth = "30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var encounter_id = eval("document.forms[0].encounterId"+index+".value");
	var patient_class = eval("document.forms[0].patientClass"+index+".value");
	var facility_id  = eval("document.forms[0].facilityId"+index+".value")
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	var OrderId = eval("document.forms[0].orderId"+index+".value")
	if(orderCategory.value=='I')
{
		if(resultType=='OR' ||resultType=='CH' )
		{
			 dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		 if(encounter_id != "")
			{
			
					 if(resultType=='OR')
						var action_url		=	'../../eOR/jsp/'+jsp+'?p_task_code='+taskType.value+'&patient_id='+patientId+'&p_task_srl_no='+taskSrlNo.value+'&function_from=CP&p_start_date_time='+trimString(dateTime)+'&p_order_catalog_code='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+patient_class+'&facility_id='+facility_id;
			 else
				 var action_url		=	'../../eCA/jsp/'+jsp+'?patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+patient_class+'&facility_id='+facility_id+'&taskCode='+taskType.value+'&task_srl_no='+taskSrlNo.value;
			}
		}
		else
		{
			
			if(resultType=='DA' || resultType=='DP')
			{
				

				 if(resultType=='DA')
				{
				 dialogTop		=	"200" ;	
					dialogHeight= "21" ;
				  dialogWidth = "50" ;
					 status			=	"no";
				 arguments		=	"" ;
				}
			else
				{
				dialogTop		=	"100" ;
				 dialogHeight= "30" ;
				 dialogWidth = "50" ;
				status			=	"no";
				 arguments		=	"" ;
				}	
				 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+patient_class+'&facility_id='+facility_id;
		
			}
			else
			{
				
					dialogTop		=	"200" ;
					dialogHeight= "18	" ;
					dialogWidth = "30" ;
					status			=	"no";
					arguments		=	"" ;
					 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+patient_class+'&facility_id='+facility_id;
			}
		}
	}
	else if(orderCategory.value=='M')
	{
		
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+patient_class+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId;
	}
	else if(orderCategory.value=='O')
	{
		
			dialogTop		=	"140" ;
			 dialogHeight= "550" ;
			 dialogWidth = "1020" ;
			 dialogLeft = "0" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"Height=" + dialogHeight + "; Width=" + dialogWidth + "; Top=" + dialogTop + "; Left=" + dialogLeft + ";scroll=no; status:" + status;
		 
		var action_url	='../../eOR/jsp/'+jsp+'?colval1=CP&orderId='+OrderId+'&report_srl_no='+taskSrlNo.value+'&patient_id='+patientId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&patient_class='+patient_class+'&facility_id='+facility_id+'&order_category='+orderCategory.value
	}
	else if(orderCategory.value=='S')
	{
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eOR/jsp/'+jsp+'?p_function_from=CP&p_patient_id='+patientId+'&p_encounter_id='+encounter_id+'&p_order_id='+OrderId+'&p_start_date_time='+dateTime;
	}
	if(orderCategory.value=='O')
	{
		parent.patTaskListResultFrame.newWindow(action_url,arguments,features);
	}
	else
		var retVal=await window.showModalDialog(action_url,arguments,features);
	
	if(orderCategory.value !='O')
	{
		SearchTaskCriteriaForPerform()
	}
	
}
//

function displayToolTipForEventsPopulationResult(e,index,indexK,indexJ,indexN,noOfRows,resultType,resultId)
{
	var resultDescription = "";
	var jsp = "";
	var orderCategory =  eval("document.forms[0].taskCategory"+index);

	if(orderCategory.value=='I')
	{
		if(resultType=='CH')
		{
				resultDescription = "Chart"
				jsp = "ChartRecording.jsp"
		}
		else if(resultType=='DA' || resultType=='DP')
		{
				resultDescription = " Discrete Measure Atomic"
				jsp = "PatTaskListDiscrMeasureAtomicFrameSet.jsp"
		}
		else if (resultType=='NT')
		{
				resultDescription = "Note Type"
				jsp = "PatTaskListNoteType.jsp"
		}
		else if (resultType=='PR')
		{
				resultDescription = "Procedure"
				jsp = "PatTaskListProcedure.jsp"
		}
		else if(resultType=='OR')
		{	
				resultDescription = "Place Order"
				jsp = "EnterOrder.jsp"
		}
		else
		{
			resultDescription = "Result Matrix"
			jsp = "PatTaskListResultMatrix.jsp"
		}
	}
	else if(orderCategory.value=='M')
	{
		jsp="MedicationAdministrationFTDrugDtls.jsp"
				resultDescription = "Admin Medication"

	}
	else if(orderCategory.value=='O')
	{
				resultDescription = "Result Entry"
				jsp="ResultEntry.jsp"
	}
	else if(orderCategory.value=='S')
	{
			resultDescription = "Specimen's Order"
			jsp="SpecimenOrder.jsp"
	}

	var obj1=document.getElementById("tooltiplayer"+index);
	if(obj1 != null)
	{

			buildTableForEventsPopulationResult(index,indexK,indexJ,indexN,noOfRows,resultDescription,resultId,jsp,resultType)
	}	

}

function buildTableForEventsPopulationResult(index,indexK,indexJ,indexN,noOfRows,resultDescription,resultId,jsp,resultType)
{
	var p='P'
	performTaskForEventsPopulationResult(index,indexK,indexJ,indexN,noOfRows,p,resultId,jsp,resultType)
}
async function performTaskForEventsPopulationResult(index,indexK,indexJ,indexN,noOfRows,Status,resultId,jsp,resultType)
{
	
	hideToolTipPopulationCriteria(index)
	var rowId =  document.getElementById("rowId"+indexK+indexJ+indexN+noOfRows);
	var dateTime = eval("document.forms[0].scheduleDate"+index+".value")
	var taskType =   eval("document.forms[0].taskCode"+index);
	var task =  eval("document.forms[0].taskType"+index);
	var taskSrlNo =  eval("document.forms[0].taskSrlNo"+index);
	var patientId = eval("document.forms[0].patientId"+index+".value");;
	
	var remarks = eval("document.forms[0].remarks"+index);
	var performedId  = eval("document.forms[0].performedId"+index);
	var orderCategory =  eval("document.forms[0].taskCategory"+index);
	var OrderId = eval("document.forms[0].orderId"+index+".value")
	var dialogTop		=	"200" ;
	var dialogHeight= "18	" ;
    var dialogWidth = "30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var encounter_id = eval("document.forms[0].encounterId"+index+".value")
var facility_id  = eval("document.forms[0].facilityId"+index+".value")
var orderCategory =  eval("document.forms[0].taskCategory"+index);
if(orderCategory.value=='I')
{
		if(resultType=='OR' ||resultType=='CH' )
		{
			 dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		 if(encounter_id != "")
			{
					 if(resultType=='OR')
					var action_url		=	'../../eOR/jsp/'+jsp+'?p_task_code='+taskType.value+'&patient_id='+patientId+'&p_task_srl_no='+taskSrlNo.value+'&function_from=CP&p_start_date_time='+trimString(dateTime)+'&p_order_catalog_code='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			 else
				var action_url		=	'../../eCA/jsp/'+jsp+'?patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&taskCode='+taskType.value+'&task_srl_no='+taskSrlNo.value;
			}
		}
		else
		{
			if(resultType=='DA' || resultType=='DP')
			{
			 if(resultType=='DA')
				{
				 dialogTop		=	"200" ;	
					dialogHeight= "21" ;
				  dialogWidth = "50" ;
					 status			=	"no";
				 arguments		=	"" ;
				}
			else
				{
				dialogTop		=	"100" ;
				 dialogHeight= "30" ;
				 dialogWidth = "50" ;
				status			=	"no";
				 arguments		=	"" ;
				}
	 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
			else
			{
				dialogTop		=	"200" ;
					dialogHeight= "18	" ;
					dialogWidth = "30" ;
					status			=	"no";
					arguments		=	"" ;
					 features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
				var action_url		=	'../../eCA/jsp/'+jsp+'?taskType='+taskType.value+'&patient_id='+patientId+'&status='+Status+'&taskSrlNo='+taskSrlNo.value+'&remarks='+remarks.value+'&performedId='+performedId.value+'&function_from=CP&p_start_date_time='+dateTime+'&p_order_catlog_code='+taskType.value+'&resultType='+resultType+'&Chart_Id='+resultId+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
			}
		}
	}
	else if(orderCategory.value=='M')
	{
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../ePH/jsp/'+jsp+'?&patient_id='+patientId+'&function_from=CP&p_start_date_time='+dateTime+'&p_ord_drug_code='+taskType.value+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id+'&p_dosage_seq_no='+taskSrlNo.value+'&order_id='+OrderId;
	}
	else if(orderCategory.value=='O')
	{
			dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url	='../../eOR/jsp/'+jsp+'?colval1=CP&orderId='+OrderId+'&report_srl_no='+taskSrlNo.value+'&patient_id='+patientId+'&order_category='+orderCategory.value
	}
	else if(orderCategory.value=='S')
	{
		dialogTop		=	"100" ;
			 dialogHeight= "30" ;
			 dialogWidth = "50" ;
			status			=	"no";
			 arguments		=	"" ;
		  features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
		var action_url		=	'../../eOR/jsp/'+jsp+'?p_function_from=CP&p_patient_id='+patientId+'&p_encounter_id='+encounter_id+'&p_order_id='+OrderId+'&p_start_date_time='+dateTime;
	}
	//var retVal=window.showModalDialog(action_url,arguments,features);		
	var retVal=await window.showModalDialog(action_url,arguments,features);		
	SearchTaskCriteriaForPerform()
	
	
}
function updateCheckValue(objCheck)
{
	if(objCheck.name=='checkIntervention')
	{
			if(objCheck.checked==true)
			{
				objCheck.value='Y'
				document.forms[0].stage.disabled = false
			}
			else
			{
				objCheck.value='N'
				document.forms[0].stage.options[0].selected = true
				document.forms[0].checkAdminMedication.disabled = false
				document.forms[0].checkResult.disabled = false
				document.forms[0].checkSpecimen.disabled = false
					document.forms[0].checkAdminMedication.checked = true
				document.forms[0].checkResult.checked = true
				document.forms[0].checkSpecimen.checked = true
				document.forms[0].stage.disabled = true
			}
	}
	else if(objCheck.name=='checkAdminMedication')
	{
			if(objCheck.checked==true)
			{
				objCheck.value='Y'
				document.forms[0].stage.disabled = true
			}
			else
			{
				objCheck.value='N'
				if(document.forms[0].checkSpecimen.checked != true && document.forms[0].checkResult.checked != true)
				document.forms[0].stage.disabled = false
			}

	}
	else if(objCheck.name=='checkSpecimen')
	{	
			if(objCheck.checked==true)
			{
				objCheck.value='Y'
				document.forms[0].stage.disabled = true
			}
			else
			{
				objCheck.value='N'
			if(document.forms[0].checkAdminMedication.checked != true && document.forms[0].checkResult.checked != true)
				document.forms[0].stage.disabled = false
			}

	}
	else if(objCheck.name=='checkResult')
	{
			if(objCheck.checked==true)
			{
				objCheck.value='Y'
				document.forms[0].stage.disabled = true
			}
			else
			{
				objCheck.value='N'
				if(document.forms[0].checkAdminMedication.checked != true && document.forms[0].checkSpecimen.checked != true)
				document.forms[0].stage.disabled = false
			}

	}


}
function loadPerform(objRadio)
{
	var status = ""	
	var queryString = document.PatTaskListPerformTopForm.queryString.value
	if(objRadio=='P')
	{	
		status = 'P'
	}
	else
	{
		status = 'N'
	}
	parent.patTaskListPerformFrame.location.href='../../eCA/jsp/PatTaskListPerform.jsp?'+queryString+'&status='+status

}
function loadPerformForAtomic(objRadio)
{
	var status = ""	
	var queryString = document.PatTaskListPerformTopForm.queryString.value
	if(objRadio=='P')
	{	
		status = 'P'
	}
	else
	{
		status = 'N'
	}

	parent.patTaskListDiscreteFrame.location.href='../../eCA/jsp/PatTaskListDiscreteMeasureAtomic.jsp?'+queryString+'&status='+status
}
function evalCheckBox(objCheck,objHidden)
{
	if(objCheck.checked==true)
		objCheck.value='Y'
}	
function checkDateForDetail(objDate)
{
	if(objDate.value != '')
	{
		var retVal= checkDt(objDate.value)
		if(retVal== false)
		{
			alert(getMessage("INVALID_DATE_FMT",'COMMON'));
			objDate.select();
		}
		else
		{
			var dateArray = objDate.value.split("/")
				if(dateArray[1] == 0)
				{
							alert(getMessage("INVALID_DATE_FMT",'COMMON'));
								objDate.select();
				}
		}
	}
}
function showCalendarValidateForDate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function chkValidityOfTime(strfromTime)
{
	if(strfromTime.value != '')
	{
		strfromTimeVal = strfromTime.value;
		strTemp = strfromTimeVal.indexOf(":");
		if(strTemp == -1 || strTemp != 2){
			alert(getMessage("INVALID_TIME_FMT","CA"));
			strfromTime.select();
			return false;
		}
		else
		{
			checkTimeForDetail(strfromTime);
		}
	}
}
function checkTimeForDetail(strfromTime)
{
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];
	if(strfromTime.value.length !=5)
	{
		alert(getMessage("INVALID_TIME_FMT","CA"));
				strfromTime.select();
		return false;
	}
	if(hr>23){
		alert(getMessage("INVALID_TIME_HOUR","CA"));
		strfromTime.select();
		return false;
	}
	if(min>59){
				alert(getMessage("INVALID_TIME_MINUTE","CA"));
		strfromTime.select();
		return false;
	}
	return true;
}
function recordingForDiscrete()
{
		var dateTime = document.patTaskListDiscreteForm.dateTime
		var practitonerName= document.patTaskListDiscreteForm.practitonerName
		var remarks= document.patTaskListDiscreteForm.remarks
		var status	= document.patTaskListDiscreteForm.status

		if(status.value !='N')
		{
			if(dateTime.value=='')
			{
				alert(getMessage("DATE_TIME_NOT_BLANK","CA"));
				dateTime.select();
				return false
			}
			if(practitonerName.value=="")
			{
				alert(getMessage("PERFORMED_NOT_BLANK","CA"));
				practitonerName.select();
				return false
			}
			if(remarks.value=="")
			{
				var msg = getMessage("CAN_NOT_BE_BLANK","common");
				msg = msg.replace('$', 'Remarks');
				alert(msg);
				remarks.select();
				return false
			}
		}
		else
		{
			if(practitonerName.value=="")
			{
				alert(getMessage("PERFORMED_NOT_BLANK","CA"));
				practitonerName.select();
				return false
			}
			if(remarks.value=="")
			{
				alert(getMessage("REASON_NOT_BLANK","CA"));
				remarks.select();
				return false
			}
		}
		var count = document.forms[0].count;
		
		
		if(count != null)
		{
			for(var index = 0; index < count.value ;index++)
			{
				var mandatory = eval("document.forms[0].mandatory"+index);
				
				//alert('mandatorvalue'+mandatory.value);
				
				if(mandatory != null)
				{
					if(mandatory.value=='Y')
					{
						
						var comp = eval("document.forms[0].selectListText"+index+".value");
						
						//alert("insidecomp"+comp);
						//var selectText = eval("document.forms[0].selectListText"+index);
						//alert("if part selectText"+selectText.value);
						if(comp=='')	
						{
							
							var discr_msr_id = eval("document.forms[0].discr_msr_id"+index);
							var msg=getMessage('CAN_NOT_BE_BLANK','Common');
							msg =msg.replace('$',discr_msr_id.value);
							alert(msg);
							//alert("APP-CA0001 "+discr_msr_id.value+ " Cannot be Blank ...");
							//selectText.focus();
							return false;
						}
					}
					
				}
				else
				{
					break;
				}
			}
		}
		
		
	document.forms[0].submit();	

}
function recordingForNotPerform()
{
			var dateTime = document.forms[0].dateTime
		var practitonerName= document.forms[0].practitonerName
		var remarks= document.forms[0].remarks
		var status	= document.forms[0].status

			if(practitonerName.value=="")
			{
				alert(getMessage("PERFORMED_NOT_BLANK","CA"));
				practitonerName.select();
				return false
			}
			if(remarks.value=="")
			{
				alert(getMessage("REASON_NOT_BLANK","CA"));
				remarks.select();
				return false
			}
		document.forms[0].submit();

}
function setValueforText(objSelect,index)
{
	
	
	var selectText = eval("document.forms[0].selectListText"+index);
	
	if(objSelect.selectedIndex != 0)
	{
			if(selectText != null)
			{
				
				
				selectText.value=objSelect.options[objSelect.selectedIndex].text;
			
			}
	}
}
function resetStage(objSelect)
{
	if(objSelect.value != '')
	{
		document.forms[0].checkAdminMedication.checked = false
		document.forms[0].checkAdminMedication.disabled = true
		document.forms[0].checkSpecimen.checked = false
		document.forms[0].checkSpecimen.disabled = true
		document.forms[0].checkResult.checked = false
		document.forms[0].checkResult.disabled = true
	}
	else
	{
		document.forms[0].checkResult.disabled = false
		document.forms[0].checkSpecimen.disabled = false
		document.forms[0].checkAdminMedication.disabled = false
	}
}
async function showGuideLine(taskCode)
{
	var dialogTop		=	"120" ;
	var dialogHeight= "90vh" ;
    var dialogWidth = "80vw" ;
	var status		= "no";
	var arguments	=	"" ;
	var features	=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/PatTaskListGuideline.jsp?intervention_code=' + taskCode;
	var retVal=await window.showModalDialog(action_url,arguments,features);
}


function setText(obj,index1)
{
	if(obj !=null)
	{
				var comp=eval("document.forms[0].selectListText"+index1);
				comp.value=obj.value;
	}
}

function SearchTaskCriteria1(flagString)
{
	var fields = null, 	names = null;
	var formObj=parent.frames[0].document.patTaskCriteriaForm;
	formObj.search.disabled = true;
	var fromDate = formObj.fromDate.value;
	var toDate = formObj.toDate.value;
	var patient_id =formObj.PatientId.value;
	var encounter_id = formObj.encounterId.value;
	var encounter = formObj.encounterId ;		
//alert("fromDate"+fromDate);
//alert("toDate"+toDate);
//alert("patient_id"+patient_id);
//alert("encounter_id"+encounter_id);
//alert("encounter"+encounter);

		fields = new Array(parent.frames[0].document.getElementById("fromDate"),parent.frames[0].document.getElementById("toDate"));
		names = new Array(getLabel("Common.fromdate.label","COMMON"),
		getLabel("Common.todate.label","COMMON"));	

	if(flagString=="criteria")	
	{
		formObj.sortSelection.value = '';			
	}
	if(checkFieldsofMst( fields, names, top.content.messageFrame))
	{
		if(patient_id == "" && encounter_id=="")
		{
			var locationCode = formObj.locationCode
			if(locationCode.value=="")
			{
				top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('LOCN_PATIENT_ENCTR_BLANK',"CA");
					formObj.search.disabled = false;
					return false
			}
		}


		if(ValidateDateTimeOfPeriodoFSearch(parent.frames[0].document.getElementById("fromDate"),parent.frames[0].document.getElementById("toDate")))
		{	
			top.content.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
			formObj.target = 'patTaskListResultFrame';
			if(!formObj.checkIntervention.checked && !formObj.checkAdminMedication.checked && !formObj.checkSpecimen.checked && !formObj.checkResult.checked)
			{
				alert(getMessage("MIN_ONE_TASK_SEL_REQ","CA"));
				formObj.search.disabled = false;
			}
			else	
			{
				if(formObj.checkIntervention.checked)
					formObj.checkIntervention.value='Y'

				if (formObj.checkAdminMedication.checked)
					formObj.checkAdminMedication.value='Y'		
				
				if(formObj.checkSpecimen.checked)
					formObj.checkSpecimen.value='Y'
				
				if(formObj.checkResult.checked)
					formObj.checkResult.value='Y'
				
				var dateTime = formObj.dateTime.value
				var taskSelect	= formObj.taskSelect
				var patientDetail =formObj.patientDetail.value
				/*alert("dateTime"+dateTime);
				alert("taskSelect"+taskSelect);
				alert("patientDetail"+patientDetail);*/
				//setTimeout("dummy();",1000);
				//alert();
				formObj.submit();
			}
		}		
	}
	else
		formObj.search.disabled = false;
}
function dummy(){
 }


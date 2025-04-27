function create()
{
	f_query_add_mod.location.href = '../../eAE/jsp/AMBResEquForVehicleMain.jsp';
}

function loadFrames()
{
	

	var note_type		=	parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type.value;

	fields = new Array(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type);
	names = new Array("Ambulance");

	if(checkFields( fields, names, parent.parent.messageFrame))
	{
		parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).disabled = true;
		parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(1).disabled = true;
		parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type.disabled = true;
		if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
			parent.addSectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleSearchAddSections.jsp?note_type='+note_type+'&flag=0&loadFirst=Yes';
		else
			parent.addSectionsFrame.location.href = '../../eAE/jsp/AMBEquipmentForVehicleSearchAddSections.jsp?note_type='+note_type+'&flag=0&loadFirst=Yes';

		parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	}
}

function loadSections()
{
	var searchText = document.secForNoteTypeSearchSectionsForm.searchText.value;
	var restype		= document.secForNoteTypeSearchSectionsForm.amb_res_type.value;
	if(searchText == undefined) searchText = '';

	if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
		parent.addSectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleSearchAddSections.jsp?searchText='+searchText+'&flag=1&loadFirst=Yes'+'&amb_res_type='+restype;
	else
		parent.addSectionsFrame.location.href = '../../eAE/jsp/AMBEquipmentForVehicleSearchAddSections.jsp?searchText='+searchText+'&flag=1&loadFirst=Yes'+'&amb_res_type='+restype;
}

function removeRecord(obj,sec_heading_code,index,strResource,strPosition)
{
	
	var seachText = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.searchText.value;
	var start = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.from.value;
	var end = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.to.value;


	if(obj.checked != true)
	{
		if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
		{
			
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBResEquForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='index' id='index' value='"+index+"'><input type='hidden' name='currResource' id='currResource' value='"+strResource+"'><input type='hidden' name='posDesc' id='posDesc' value='"+strPosition+"'><input type='hidden' name='start' id='start' value='"+start+"'><input type='hidden' name='end' id='end' value='"+end+"'></form></html>");
			parent.removeRecFrame.document.remRecForm.submit();
		}
		else
		{
					
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBEquipmentForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='index' id='index' value='"+index+"'><input type='hidden' name='start' id='start' value='"+start+"'><input type='hidden' name='end' id='end' value='"+end+"'></form></html>");
			parent.removeRecFrame.document.remRecForm.submit();

		}
	}
}

function addRecord(obj,sec_heading_code,sec_heading_desc,srlNo,index,strResource,strPosition)
{
	var chiefComp = "";
	var flag=parent.sectionsFrame.document.secForNoteTypeSectionsForm.flag.value;
	var count=parent.sectionsFrame.document.secForNoteTypeSectionsForm.count.value;

	if(obj.checked == true)
	{
			if(count >=1)
			{
			alert(getMessage("RESOUCE_NOT_ALLOWED","AE"));	
			obj.checked=false;
			return false;
			}
			else
			{
				if (flag=="false")
			{
				alert(getMessage("RESOUCE_NOT_ALLOWED","AE"));	
				obj.checked=false;
				return false;
			}
		else {
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
	sec_heading_desc=sec_heading_desc.replace("'","$$$");
		if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
		{
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBResEquForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='srlNo' id='srlNo' value='"+srlNo+"'><input type='hidden' name='called_from' id='called_from' value='addPage'><input type='hidden' name='chiefComp' id='chiefComp' value='"+chiefComp+"'><input type='hidden' name='index' id='index' value='"+index+"'><input type='hidden' name='restype' id='restype' value='"+strResource+"'><input type='hidden' name='posDesc' id='posDesc' value='"+strPosition+"'></form></html>");
			
		
			parent.removeRecFrame.document.remRecForm.submit();
		}
		else
		{
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBEquipmentForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='srlNo' id='srlNo' value='"+srlNo+"'><input type='hidden' name='called_from' id='called_from' value='addPage'><input type='hidden' name='chiefComp' id='chiefComp' value='"+chiefComp+"'><input type='hidden' name='index' id='index' value='"+index+"'><input type='hidden' name='restype' id='restype' value='"+strResource+"'><input type='hidden' name='posDesc' id='posDesc' value='"+strPosition+"'></form></html>");
		
			parent.removeRecFrame.document.remRecForm.submit();

		}
}

function loadSectionsPage(obj,sec_heading_code,sec_heading_desc,chief_comp,tempSeq,strResrc,strPosition)
{
	var numberOfRecs = "";
	if(parent.sectionsFrame.document.secForNoteTypeSectionsForm != null)
	{
		numberOfRecs = parent.sectionsFrame.document.secForNoteTypeSectionsForm.countOfRows.value;
	}
	var seachText = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.searchText.value;
	
	sec_heading_desc=sec_heading_desc.replace("'","$$$");

	if(obj.checked == true)
	{
		if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
		{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBResEquForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'><input type='hidden' name='restype' id='restype' value='"+strResrc+"'><input type='hidden' name='posDesc' id='posDesc' value='"+strPosition+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
		}
		else
		{
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBEquipmentForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'><input type='hidden' name='restype' id='restype' value='"+strResrc+"'></form></html>");
			parent.removeRecFrame.document.remRecForm.submit();
		}
	}
	else
	{
		//alert("tempSeq --"+tempSeq);
		//removeRecord(obj,sec_heading_code)
	}
}

function reloadFrames()
{
	if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBResEquForVehicleRemoveRecord.jsp'><input type='hidden' name='called_from' id='called_from' value='reloadFrames'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
	else
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBEquipmentForVehicleRemoveRecord.jsp'><input type='hidden' name='called_from' id='called_from' value='reloadFrames'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();

	}
}

function checkIsValidForProceed()
{
		 var url = f_query_add_mod.location.href;
		 if(f_query_add_mod.addSectionsFrame)
		 var url1=f_query_add_mod.addSectionsFrame.location.href;
		url = url.toLowerCase();
		if(url1==undefined)
		url1='blank';		
		url1 = url1.toLowerCase();
		
		if ( (url.indexOf("blank")==-1) && (url1.indexOf("blank")==-1) )
				return true;
		else
				return false;
} 


function apply()
{ 

if (! checkIsValidForProceed() ) {
         messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
         return false;			
			
		}
	var noteType = f_query_add_mod.noteTypeValuesFrame.document.secForNoteTypeValuesForm.note_type;
	var seq_num = f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.seq_num;

	f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.note_type.value = noteType.value;

	var count = f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.countOfRows.value;
	var chief_comp = "";
	var seq_num = "";	
	var conc_string = "";	
	var sec_code = "";
	var dummyRow = "";
	var dummySeqNum = "";
	var finalString = "";

	for(var i=0; i<count; i++)
	{
		dummyRow = eval("f_query_add_mod.sectionsFrame.document.getElementById('numRows')" + i);
        sec_code = dummyRow.cells[0].innerText;
		chief_comp = dummyRow.cells[1].innerText;
		dummySeqNum = eval("f_query_add_mod.sectionsFrame.document.getElementById('seq_num_text')"+i);
		seq_num = dummyRow.cells[2].innerText;
		dummySeqNum.value = seq_num;
		chief_comp = eval("f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.chief_complaint"+i);
		
		if(f_query_add_mod.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
		{
			if(chief_comp.checked == true)
			{
				eval("f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.chief_complaint"+i).value = "Y";
			}
			else
			{
				eval("f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.chief_complaint"+i).value = "N";
			}
		}
	}	
	f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.submit();
	if(count == 0)
	{
		f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.submit();
	}
}

function onSuccess()
{
	create();
}

function addSeqNum(obj,sec_hdg_code,chief_comp,sec_heading_desc)
{
	var seq_num = obj.value;
	if(obj.value != "")
	{
		if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
		{
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBResEquForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_hdg_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='onBlurFunc'><input type='hidden' name='seq_num' id='seq_num' value='"+seq_num+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'></form></html>");
			parent.removeRecFrame.document.remRecForm.submit();
		}
		else
		{
			parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eAE/jsp/AMBEquipmentForVehicleRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_hdg_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='onBlurFunc'><input type='hidden' name='seq_num' id='seq_num' value='"+seq_num+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'></form></html>");
			parent.removeRecFrame.document.remRecForm.submit();
		}
	}
}

function query()
{
	f_query_add_mod.location.href = "../../eAE/jsp/AMBResEquForVehicleQuery.jsp";
}

function reset()
{
	/*if(f_query_add_mod.location.href.indexOf("AMBResEquForVehicleQuery.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
	else if(f_query_add_mod.location.href.indexOf("AMBResEquForVehicleQueryResult.jsp") != -1)
	{
	}
	else*/ if(f_query_add_mod.location.href.indexOf("AMBResEquForVehicleMain.jsp") > -1)
	{
		
		 create();
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
	var count = document.secForNoteTypeSectionsForm.countOfRows.value;
	var classValue = "";
	if((parseInt(count)) % 2 == 0)
		classValue = "QRYEVEN";
	else
		classValue = "QRYODD";
	
	if(document.secForNoteTypeSectionsForm.firstPos.value == "")
	{
		var temp = eval("document.getElementById('numRows')"+cnt);
		var temp1 = temp.cells.length;
		if(document.secForNoteTypeSectionsForm.firstPos.value == "")
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
		document.secForNoteTypeSectionsForm.firstPos.value = srlNo;
	}
	else
	{		
		reloadSecFrame(cnt,srlNo);
	}
}

function reloadSecFrame(cnt,srlNo)
{
	if(document.secForNoteTypeSectionsForm.firstPos.value != "")
	{
		
		document.secForNoteTypeSectionsForm.secPos.value = srlNo;

		var firstPos = document.secForNoteTypeSectionsForm.firstPos.value;
		var secPos = document.secForNoteTypeSectionsForm.secPos.value;
		var noOfRows = document.secForNoteTypeSectionsForm.countOfRows.value;		

		if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
			parent.sectionsFrame.location.href = "../../eAE/jsp/AMBResEquForVehicleAMB.jsp?firstPosition="+document.secForNoteTypeSectionsForm.firstPos.value+"&secondPosition="+document.secForNoteTypeSectionsForm.secPos.value+"&mode=modify&noOfRows="+noOfRows;		
		else
			parent.sectionsFrame.location.href = "../../eAE/jsp/AMBEquipmentForVehicleAMB.jsp?firstPosition="+document.secForNoteTypeSectionsForm.firstPos.value+"&secondPosition="+document.secForNoteTypeSectionsForm.secPos.value+"&mode=modify&noOfRows="+noOfRows;		
	}
}

function loadPrevNextRecs(varName)
{
	var start = document.secForNoteTypeSearchSectionsForm.from.value;
	var end = document.secForNoteTypeSearchSectionsForm.to.value;
	var searchText = document.secForNoteTypeSearchSectionsForm.searchTextHidden.value;
	if(searchText == undefined) searchText = '';
	var mode = document.secForNoteTypeSearchSectionsForm.mode.value;
	var flag = document.secForNoteTypeSearchSectionsForm.flag.value;
	var note_type = document.secForNoteTypeSearchSectionsForm.note_type.value;
	var totalCount = document.secForNoteTypeSearchSectionsForm.totalCount.value;
	var countForNext = document.secForNoteTypeSearchSectionsForm.countForNext.value;
	var restype		= document.secForNoteTypeSearchSectionsForm.amb_res_type.value;


	var tempRowIds = "";
	var tempString = "";
	var tempParseInt = 0;

	if(varName == 'prev')
	{
		start = parseInt(start) - 9;
		end = parseInt(end) - 9;
	//	tempParseInt = parseInt(countForNext,10)-1
	}
	else if(varName == 'next')
	{
		start = parseInt(start) + 9;
		end = parseInt(end) + 9;
	//	tempParseInt = parseInt(countForNext,10)+1
	}

	/*for(var t=parseInt(start,10);t<parseInt(end,10);t++)
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
	}*/
	if(parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).checked)
	
		parent.addSectionsFrame.location.href = '../../eAE/jsp/AMBResEquForVehicleSearchAddSections.jsp?note_type='+note_type+'&flag='+flag+'&from='+start+'&to='+end+'&searchText='+searchText+'&mode='+mode+'&tempRowIds='+tempRowIds+'&flagTemp=temp&totalCount='+totalCount+'&countForNext='+tempParseInt+"&amb_res_type="+restype;
		
		
		
	else
		parent.addSectionsFrame.location.href = '../../eAE/jsp/AMBEquipmentForVehicleSearchAddSections.jsp?note_type='+note_type+'&flag='+flag+'&from='+start+'&to='+end+'&searchText='+searchText+'&mode='+mode+'&tempRowIds='+tempRowIds+'&flagTemp=temp&totalCount='+totalCount+'&countForNext='+tempParseInt+"&amb_res_type="+restype;


	parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}

function clearbotFrames()
{
	parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(0).disabled = true;
	parent.noteTypeValuesFrame.document.secForNoteTypeValuesForm.amb_res_equip(1).disabled = true;

	if(parent.sectionsFrame.location.href.indexOf("AMBResEquForVehicleAMB.jsp") != -1 || parent.sectionsFrame.location.href.indexOf("AMBEquipmentForVehicleAMB.jsp") != -1)
	{
		parent.addSectionsFrame.location.href = '../../eCommon/html/blank.html';
		parent.sectionsFrame.location.href = '../../eCommon/html/blank.html';
		parent.parent.f_query_add_mod.location.href = '../../eAE/jsp/AMBResEquForVehicleMain.jsp';
	}
/*
	if(parent.parent.f_query_add_mod.forms[0].search.disabled)
	{
		parent.addSectionsFrame.location.href = '../../eCommon/html/blank.html';
		parent.sectionsFrame.location.href = '../../eCommon/html/blank.html';
		parent.parent.f_query_add_mod.location.href = '../../eAE/jsp/AMBResEquForVehicleMain.jsp';
	}
	*/
}


function create()
{
	f_query_add_mod.location.href = '../../eCA/jsp/SectionForNoteTypeMain.jsp';
}

function loadFrames()
{
	
	var note_type = document.secForNoteTypeValuesForm.note_type.value;
	if(note_type !="")
	{
		parent.addSectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp?note_type='+note_type+'&flag=0&loadFirst=Yes';
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp'
	
	}

	else
	{
			var erroMsg=getMessage("CAN_NOT_BE_BLANK",'COMMON');
			erroMsg=erroMsg.replace('$',getLabel("eCA.NoteTypes.label","CA"));
			if(erroMsg!="")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
				return false;
			}
	}
	
}

function loadSections()
{
	
	if(document.secForNoteTypeSearchSectionsForm!=null)
	{
	var fields = new Array(document.secForNoteTypeSearchSectionsForm.searchText);

    var names = new Array (getLabel("eCA.SectionStartsWith.label",'ca'));
	
	if(checkFieldsofMst(fields, names, parent.parent.messageFrame))
	{
		//document.secForNoteTypeSearchSectionsForm.submit();
		var searchText = document.secForNoteTypeSearchSectionsForm.searchText.value;
		var noteType = document.secForNoteTypeSearchSectionsForm.note_type.value;
		
		parent.addSectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp?searchText='
		+encodeURIComponent(searchText)+'&flag=1&loadFirst=Yes&note_type='+noteType;
		
	}
	else			
		parent.addSectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp';	
	}
	
	else
	{
		//alert("here2");
	
		
		//parent.removeRecFrame.location.href ='../../eCommon/html/blank.html';	
		
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		
		return false;
	}
	
	
	
	
}

function removeRecord(obj,sec_heading_code,index)
{
	var note_type = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.note_type.value;
	var seachText = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.searchText.value;
	if(obj.checked != true)
	{
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SectionForNoteTypeRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='called_from' id='called_from' value='sectionsPage'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='index' id='index' value='"+index+"'><input type='hidden' name='note_type' id='note_type' value='"+note_type+"'></form></html>");
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






function loadSectionsPage(obj,sec_heading_code,sec_heading_desc,chief_comp,tempSeq)
{
	var numberOfRecs = "";
	if(parent.sectionsFrame.document.secForNoteTypeSectionsForm != null)
	{
		numberOfRecs = parent.sectionsFrame.document.secForNoteTypeSectionsForm.countOfRows.value;
	}
	var seachText = parent.addSectionsFrame.document.secForNoteTypeSearchSectionsForm.searchText.value;
	if(obj.checked == true)
	{
		
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SectionForNoteTypeRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='addSearch'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
	}
	else
	{		
		parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SectionForNoteTypeRemoveRecord.jsp'><input type='hidden' name='sec_heading_code' id='sec_heading_code' value='"+sec_heading_code+"'><input type='hidden' name='sec_heading_desc' id='sec_heading_desc' value='"+sec_heading_desc+"'><input type='hidden' name='called_from' id='called_from' value='removeReco'><input type='hidden' name='seachText' id='seachText' value='"+seachText+"'><input type='hidden' name='chief_comp' id='chief_comp' value='"+chief_comp+"'><input type='hidden' name='noOfRows' id='noOfRows' value='"+numberOfRecs+"'></form></html>");
		parent.removeRecFrame.document.remRecForm.submit();
		
	}
}

function reloadFrames()
{
	parent.removeRecFrame.document.write("<html><form name='remRecForm' id='remRecForm' action='../../eCA/jsp/SectionForNoteTypeRemoveRecord.jsp'><input type='hidden' name='called_from' id='called_from' value='reloadFrames'></form></html>");
	parent.removeRecFrame.document.remRecForm.submit();
}

function apply()
{
	if(f_query_add_mod.noteTypeValuesFrame !=null)
	{
	if(f_query_add_mod.noteTypeValuesFrame.document.secForNoteTypeValuesForm !=null&&f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm !=null)
	{
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

	//alert("noteType   :   "+noteType+"   count   :  "+count);
	for(var i=0; i<count; i++)
	{
		dummyRow = eval(f_query_add_mod.sectionsFrame.document.getElementById("numRows"+i));
		sec_code = dummyRow.cells[0].innerText;
		chief_comp = dummyRow.cells[1].innerText;
		dummySeqNum = eval(f_query_add_mod.sectionsFrame.document.getElementById("seq_num_text"+i));
		seq_num = dummyRow.cells[2].innerText;
		dummySeqNum.value = seq_num;
		chief_comp = eval("f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.chief_complaint"+i);
		if(chief_comp.checked == true)
		{
			eval("f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.chief_complaint"+i).value = "Y";
		}
		else
		{
			eval("f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.chief_complaint"+i).value = "N";
		}
	}	
	f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.submit();
	if(count == 0)
	{
		f_query_add_mod.sectionsFrame.document.secForNoteTypeSectionsForm.submit();
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

function onSuccess()
{
	create();
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

function query()
{
	f_query_add_mod.location.href = "../../eCA/jsp/SectionForNoteTypeQuery.jsp";
}

function reset()
{
	if(f_query_add_mod.location.href.indexOf("SectionForNoteTypeQuery.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
	else if(f_query_add_mod.location.href.indexOf("SectionForNoteTypeQueryResult.jsp") != -1)
	{
	}
	else if(f_query_add_mod.location.href.indexOf("SectionForNoteTypeQuery.jsp") == -1)
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
		classValue = "gridNumericData";//Modified by Arvind @ 19-12-08
	else
		classValue = "gridNumericData";
	
	if(document.secForNoteTypeSectionsForm.firstPos.value == "")
	{
		
		var temp = eval(document.getElementById("numRows"+cnt));
		//var temp = document.getElementById("numRows"+cnt);
		var temp1 = temp.cells.length;
		if(document.secForNoteTypeSectionsForm.firstPos.value == "")
		{
			
			for(var i=0;i<temp1;i++)
			{
				temp.cells[i].className = 'FIRSTSELECTED';
				temp.cells[i].align= i == 3 ? "left" : "center";
				//temp.cells[i].align="left";
			}
			
		}
		document.getElementById("extraRow").style.display = "";
		if(document.getElementById("extraRow").style.display == "")
		{
			for(var j=0;j<(document.getElementById("extraRow").cells.length);j++)
			{
				document.getElementById("extraRow").cells[j].className = classValue;
				
			}
		}
		document.secForNoteTypeSectionsForm.firstPos.value = srlNo;
	}
	else
	{	reloadSecFrame(cnt,srlNo);
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
		parent.sectionsFrame.location.href = "../../eCA/jsp/SectionForNoteTypeSections.jsp?firstPosition="+document.secForNoteTypeSectionsForm.firstPos.value+"&secondPosition="+document.secForNoteTypeSectionsForm.secPos.value+"&mode=modify&noOfRows="+noOfRows;		
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

	parent.addSectionsFrame.location.href = '../../eCA/jsp/SectionForNoteTypeSearchAddSections.jsp?note_type='+note_type+'&flag='+flag+'&start='+start+'&end='+end+'&searchText='+encodeURIComponent(searchText)+'&mode='+mode+'&tempRowIds='+tempRowIds+'&flagTemp=temp&totalCount='+totalCount+'&countForNext='+tempParseInt;
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}

async function callnotetype()
{
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var sql = "SELECT note_type code,note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) ORDER BY  note_type_desc";
	var title = getLabel("Common.NoteType.label","Common");
	var target = document.secForNoteTypeValuesForm.note_type;
	target.value = "";
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

	retArray = await CommonLookup( title, argArray );
		
	if(retArray != null && retArray !="")	
	{
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}

		
			document.secForNoteTypeValuesForm.note_type_txt.value = arr[1];
			document.secForNoteTypeValuesForm.note_type.value = arr[0];
	}
	else
	{
			document.secForNoteTypeValuesForm.note_type_txt.value = '';
			document.secForNoteTypeValuesForm.note_type.value = '';
	}

	setTimeout("reloadFrames()",50);
}


function resetValues()
{
	parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp'
	
}
function setValue()
{
	document.secForNoteTypeValuesForm.flag.value='false'
}

function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false
		return true
}

function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) {
		return false;  //Not a valid key
   }
}	

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1)
	{
		return false;
	}		  // Not a valid key
	return true ;
}

async function getNoteCode(objCode)
{
	//alert("objCode"+objCode.value);
	
	if(objCode.name=='note_type_txt')
	{
		note_type(objCode)
	}

	if(objCode.name == "notetype_srch")
	{
		
		if(document.secForNoteTypeValuesForm.flag.value=='false')
			return false
		else
			
			await callnotetype()
	}
			
}
 function note_type(objCode)
{
	var note = objCode.value;
	//alert("487 note"+note);
	if(note == '')
	{
		document.secForNoteTypeValuesForm.flag.value='true'
		return false
	}
	else
	{
		//alert("here11");
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	

		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='../../eCA/jsp/SectionForNoteTypeIntermediate.jsp'><input type=hidden name='note' id='note' value='"+note+"'></form></body></html>";	
		//parent.BlankFrame.document.write(HtmlVal);
		parent.BlankFrame.document.body.innerHTML ='';
		parent.BlankFrame.document.body.insertAdjacentHTML("afterbegin",HtmlVal);
		
		parent.BlankFrame.document.tempform.action='../../eCA/jsp/SectionForNoteTypeIntermediate.jsp'
		parent.BlankFrame.document.tempform.submit();
		
	}
	setTimeout("reloadFrames()",50);
}

async function callnotetype1(sql,title,target)
{
	//alert("inside funtion");
	
	var serviceVal   ="";
	var search_desc	= "";
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
	retArray = await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;
	

	//alert("retArray"+retArray);

}

 


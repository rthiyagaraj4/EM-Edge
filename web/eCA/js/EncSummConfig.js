//Created by Sethuraman for encounter Summary requirements
var rowIDArray = new Array();

/*
 * Functions called from EncSummConfigHdr.jsp
 */

/*
Function Name : create()
Description :  Used for Loading the Function
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/EncSummConfigMain.jsp?mode=insert';
}


function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/EncSummConfigQueryCriteria.jsp';
}


/*
Function Name : apply()
	Description : HTML Object  Values of the file EncSummConfigGroupAddedList.jsp values are Posted to EncSummConfigServlet.java file
*/
function apply()
{

	if(f_query_add_mod.DetailsFrame!=null)
	{
		if(f_query_add_mod.HeaderFrame.document.HeaderForm !=null && f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm != null)
		{
			var summary_code = f_query_add_mod.HeaderFrame.document.HeaderForm.summary.value;
			var finalString = "";
			var index = 0;
			if(summary_code !="")
			{				
				var arrayLength = f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.array_length.value;			
				
				for( index= 1 ; index<= parseInt(arrayLength);index++)
				{					
					var seq_num = eval ("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.seq_num"+index);
					var sequenceNumber = seq_num.value;
					if(seq_num.value == "")
					{
						var error = getMessage("SEQUENCE_NOT_ZERO",'CA');
						seq_num.focus();
						messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&error_value=0";
						return false;
					}
					var tdrow_id = eval ("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.getElementById("tdrow_id")"+index);
					var groupCode = eval("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.GroupCode"+index);
					var groupType = eval("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.GroupType"+index);
					if(finalString == "")
					{
						finalString =  tdrow_id.cells[0].innerText + "||" + sequenceNumber + "||"+ groupCode.value+ "||"+ groupType.value;
					}
					else
					{
						finalString = finalString + "~"+tdrow_id.cells[0].innerText+ "||" + sequenceNumber + "||"+ groupCode.value+ "||"+ groupType.value;
					}					
				}
				f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.finalString.value = finalString;
				f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.summaryCode.value = summary_code;
				f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.method = "post";
				f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.action ="../../servlet/eCA.EncSummConfigGroupServlet";
				f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.target ="messageFrame";
				f_query_add_mod.DetailsFrame.DetailsFrameTop.document.GroupAddedfrm.submit();
			}
			else
			{
				var errorMsg=getMessage("SEQUENCE_NOT_ZERO",'CA');
				if(errorMsg!="")
				{
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0";
					f_query_add_mod.HeaderFrame.document.HeaderForm.summary.focus();
					return false;
				}
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

function getSummaryCode(objCode)
{
	if(objCode.name=='summaryCode')
	{
		summary(objCode);
	}

	if(objCode.name == "summarySearch")
	{		
		if(document.forms[0].flag.value=='false')
			return false;
		else
			callSummaryLookup();
	}
}


function summary(objCode)
{
	var summary_code = objCode.value;
	if(summary_code == '')
	{
		document.forms[0].flag.value ='true';
		return false;
	}
	else
	{		
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>" +
        		"<body onKeyDown='lockKey()'>" +
        		"<form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/EncSummConfigIntermediate.jsp'>" +
        			"<input type='hidden' name='summary_code' id='summary_code' value='"+summary_code+"'>" +
        			"<input type='hidden' name='detailsFrameSrc' id='detailsFrameSrc' value='../../eCA/jsp/EncSummConfigFrameSet.jsp'>" +
        			"<input type=hidden name='selFunVal' id='selFunVal' value='MainSection'>" +
        		"</form></body></html>";
		
       parent.frames[1].document.write(HTMLVal);
	   parent.frames[1].document.tempform1.submit(); 

    }
}

function callFunction(sql,title,target)
{
    var argArray		= new Array();
    var namesArray		= new Array();
    var valuesArray		= new Array();
    var datatypesArray	= new Array();

    argArray[0] = sql;
    argArray[1] = namesArray;
    argArray[2] = valuesArray;
    argArray[3] = datatypesArray;
    argArray[4] = "1,2";
    argArray[5] = target.value;
    argArray[6] = DESC_LINK;
    argArray[7] = CODE_DESC;
    retArray = CommonLookup( title, argArray );
    return retArray;
}

function resetValues()
{
   parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}

function setValue()
{
	document.forms[0].flag.value='false';
}

/*
Function Name :  fetchRecords()
Description : 
*/
function fetchRecords()
{
	var summary_code = document.HeaderForm.summary.value;
	if(summary_code !="")
	{
	 	parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameMiddle.location.href='../../eCA/jsp/EncSummConfigGroupSearchCriteria.jsp';
	 	parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameTop.location.href='../../eCA/jsp/EncSummConfigGroupAddedList.jsp?summaryCode='+summary_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameBottom.location.href='../../eCommon/html/blank.html';
	}
	else
	{
		var erroMsg=getMessage("SUMMARY_NOT_BLANK",'CA');
		if(erroMsg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
			//document.HeaderForm.summary.focus();
			return false;
		}
	}
}

/*
 * Functions called from EncSummConfigGroupSearchCriteria.jsp
 */

function GroupSearchCriteria()
{
	var summaryCode = "";
	var groupFlag = "";
	var groupType = "";	
	var search_txt = "";
	
	parent.parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?';
	if(parent.parent.frames[1].frames[1].document.forms[0] != null)
	{
		summaryCode = parent.parent.HeaderFrame.document.HeaderForm.summary.value;
		groupFlag = 0;		
		groupType = document.GroupSearchfrm.es_group_type.value;	
		search_txt = document.GroupSearchfrm.searchtext.value;		
		
		search_txt = parent.parent.frames[1].frames[1].document.forms[0].searchtext.value;
		parent.DetailsFrameBottom.location.href='../../eCA/jsp/EncSummConfigGroupAddList.jsp?groupFlag='+groupFlag+'&groupType='+groupType+'&searchText='+search_txt+"&loadFirst=Yes&summaryCode="+summaryCode;
		
		/*
		if(parent.parent.frames[1].frames[1].document.forms[0].searchtext.value != "")
		{			
			search_txt = parent.parent.frames[1].frames[1].document.forms[0].searchtext.value;
			parent.DetailsFrameBottom.location.href='../../eCA/jsp/EncSummConfigGroupList.jsp?groupFlag='+groupFlag+'&groupType='+groupType+'&searchText='+search_txt+"&loadFirst=Yes&summary_code="+summary_code;
		}
		else
		{
			var erroMsg=getMessage("SEARCH_TEXT_BLANK",'Common');
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+erroMsg+'&err_value=0';
			return false;
		}
		*/
	}
}

/*
 * Functions called from EncSummConfigGroupList.jsp
 */
function prevNextRecs(stringValue)
{
	var start = document.GroupAddForm.from.value;
	var end = document.GroupAddForm.to.value;
	var groupFlag = document.GroupAddForm.groupFlag.value;
	var groupType = document.GroupAddForm.groupType.value;
	var searchText = document.GroupAddForm.searchText.value;	
	var hiddenFieldRemoveRow = document.GroupAddForm.hiddenFieldRemoveRow.value;
	var count = document.GroupAddForm.totalCount.value;
	var summaryCode = document.GroupAddForm.summaryCode.value;
	
	var tempRowIds = "";
	var tempString = "";
	
	if(stringValue == 'prev')
	{
		start = parseInt(start,10) - 5;
		end = parseInt(end,10) - 5;
	}
	else if(stringValue == 'next')
	{		
		start = parseInt(start,10) + 5;
		end = parseInt(end,10) + 5;
	}
	
	for(var t=parseInt(start,10);t<parseInt(end,10);t++)
	{
		tempString = parent.parent.rowIDCompForEncSummConfigGroup[t];

		if(t < count)
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
	parent.DetailsFrameBottom.location.href='../../eCA/jsp/EncSummConfigGroupAddList.jsp?'+
		'groupFlag='+groupFlag+'&groupType='+groupType+'&searchText='+searchText+'&summaryCode='+summaryCode+
		'&start='+start+'&end='+end+'&tempRowIds='+tempRowIds+'&hiddenFieldRemoveRow='+hiddenFieldRemoveRow+'&totalCount='+count;
}

/*
Function Name :  stringConCatenate(objIndex,objRowId)
Description :	The Function is Used For ConCatenation of Text Fields Values and TD Data
@param objIndex  Index of the Dynamically Created HTML Object
@param objRow  is the  ID for the Table Row  Dynamically Created 
*/
function stringConCatenate(objIndex,objRowId)
{
	var rowid = objRowId;
	var trTextData = rowid.cells[2].innerText;
	var finalString = ""; // variables USed to Concatenate Code ,Text Field Values and Also Description
	var select_yn = eval("document.GroupAddForm.select_yn"+objIndex);
	var remove_value = 	document.getElementById('tblrow_id'+objIndex);
	var arrayLength = 0;
	if(parent.DetailsFrameTop.document.GroupAddedfrm!=null)
	{
		arrayLength = parent.DetailsFrameTop.document.GroupAddedfrm.array_length.value;
	}
	var index = 0;
	var checkCode = "", checkCodeValue = "", codeValue = "";
	var summaryCode = parent.parent.HeaderFrame.document.HeaderForm.summary.value;
	var groupType = "", groupTypeValue = ""; 
	var groupCode = "";  

	if(select_yn.checked==true)
	{
		//alert(" Added value: "+remove_value.cells[0].innerText);
		parent.DetailsFrameTop.document.GroupAddedfrm.add_value.value = remove_value.cells[0].innerText;
		for( index=1;index<=parseInt(arrayLength);index++)
		{			
			var seq_num = eval ("parent.DetailsFrameTop.document.GroupAddedfrm.seq_num"+index);
			var sequenceNumber = seq_num.value;
			if(sequenceNumber == "")
			{
				sequenceNumber = "null";
			}
			var tdrow_id = eval ("parent.DetailsFrameTop.document.getElementById("tdrow_id")"+index);
			groupCode = eval ("parent.DetailsFrameTop.document.GroupAddedfrm.GroupCode"+index);
			groupType = eval ("parent.DetailsFrameTop.document.GroupAddedfrm.GroupType"+index);	
			checkCode = eval ("document.getElementById("tblrow_id")"+objIndex);
			checkCodeValue = checkCode.cells[0].innerText;
			codeValue = groupCode.value;
			groupTypeValue = groupType.value;
			if(checkCodeValue == codeValue)
			{			
				return false;
			}
			if(finalString == "")
			{				
				finalString =  escape(tdrow_id.cells[0].innerText) + "||" + sequenceNumber + "||" + groupCode.value + "||" +groupTypeValue;
			}
			else
			{
				finalString = finalString + "~"+escape(tdrow_id.cells[0].innerText) + "||" + sequenceNumber + "||" + groupCode.value + "||" +groupTypeValue;
			}	
		}
		finalString = finalString + "~" +escape(trTextData) + "||" + "null" + "||" + rowid.cells[0].innerText+ "||" + rowid.cells[4].innerText;			
		parent.parent.HeaderFrame.document.HeaderForm.finalString.value =  finalString;		
	}
	else
	{
		finalString = "";
		for( index= 1 ; index<= parseInt(arrayLength);index++)
		{
			var seq_num = eval ("parent.DetailsFrameTop.document.GroupAddedfrm.seq_num"+index);
			var sequenceNumber = seq_num.value;
			if(sequenceNumber == "")
			{
				sequenceNumber = "null";
			}
			var tdrow_id = eval ("parent.DetailsFrameTop.document.getElementById("tdrow_id")"+index);
			groupCode = eval ("parent.DetailsFrameTop.document.GroupAddedfrm.GroupCode"+index);	
			groupType = eval ("parent.DetailsFrameTop.document.GroupAddedfrm.GroupType"+index);
			var stringRowId = new String();
			var stringTdRowId= new String();
			stringRowId = rowid.cells[1].innerText;
			stringTdRowId = tdrow_id.cells[0].innerText;
			groupTypeValue = groupType.value;
			
			if(groupCode.value  != remove_value.cells[0].innerText)
			{
				if(finalString == "")
				{
					finalString = escape(stringTdRowId) + "||" + sequenceNumber + "||" + groupCode.value + "||" +groupTypeValue;
				}
				else
				{
					finalString = finalString + "~"+escape(stringTdRowId) + "||" + sequenceNumber + "||" + groupCode.value + "||" +groupTypeValue;
				}
			}	
		}
		parent.parent.HeaderFrame.document.HeaderForm.finalString.value =  finalString;
	}
	
	parent.DetailsFrameTop.document.GroupAddedfrm.finalString.value = finalString;	
	parent.DetailsFrameTop.document.GroupAddedfrm.remove_value.value = remove_value.cells[0].innerText;	
	parent.DetailsFrameTop.document.GroupAddedfrm.summaryCode.value = parent.parent.HeaderFrame.document.HeaderForm.summary.value;	
	parent.DetailsFrameTop.document.GroupAddedfrm.operation.value ='addRows';	
	parent.DetailsFrameTop.document.GroupAddedfrm.submit();	
}



/*
Function Name : secRefresh(obj)
Description : The Function is Used For Reloading the Frames 
@param obj is the Object itself
*/
function secRefresh(obj)
{
	parent.DetailsFrame.location.href='../../eCA/jsp/EncSummConfigFrameSet.jsp';
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	parent.HeaderFrame.document.HeaderForm.finalString.value="";
}


/*
Function name :   reset()
Description : The Function is Used For Refreshing the Function
*/
function reset()
{
	if(f_query_add_mod.location.href.indexOf("EncSummConfigQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}	
	else if(f_query_add_mod.location.href.indexOf("EncSummConfigQueryCriteria.jsp") == -1)
	{	
		create();	
	}	
}


/*
Function name :   onSuccess
Description : Function  is Invoked automatically when Records are Submitted to the DataBase 
*/
function onSuccess() 
{
	f_query_add_mod.HeaderFrame.document.HeaderForm.reset();
	f_query_add_mod.DetailsFrame.location.href='../../eCA/jsp/EncSummConfigFrameSet.jsp';
}
function minOccur2(obj)
{
	var val=obj.value;
	var pos=val.indexOf('-');
	
	if(pos>0)
	{
		alert(getMessage("INVALID_NUMBER_FORMAT",'common'));
		obj.focus();
		obj.select();
	}
}

/*
   Function Name : checkSequence(objSequence)
	Description :		The Function is Used For Validating Non Zero Entries
   @param objSequence  is Text Object Itself
  */
function checkSequence(objSequence)
{
	var errorMessage ="";
	if(objSequence.value <= 0 || objSequence.value =="-")
	{
		errorMessage= getMessage("SEQUENCE_NOT_ZERO",'CA');
		alert(errorMessage);
		objSequence.value='';
		//objSequence.focus()
		return false;
	}
}



/*
  * Function Name : scrollTitle()
  *Description : The Function is Used For Preventing the Headings in a Table Not to Scroll
  */
function scrollTitle()
{
	var scrollXY = document.body.scrollTop;
	if(scrollXY == 0)
	{
		document.getElementById("divDataTitle").style.position = 'static';
		document.getElementById("divDataTitle").style.posTop  = 0;
	}
	else
	{
		document.getElementById("divDataTitle").style.position = 'relative';
		document.getElementById("divDataTitle").style.posTop  = scrollXY;
	}
}


/*
	Function Name :  removeRow(objIndex)
	Description :  The Function is Used For ConCatenation  and Splitting  a String of Text Fields Values and TD Data and also based upon the  status of the CheckBox
    @param objIndex  Index of the Dynamically Created HTML Object
  */
function removeRow(objIndex)
{
	var arrayLength = document.GroupAddedfrm.array_length.value;
	
	var sequenceNumber = ""; // String used for Concatenating Text Fields Values
	var finalString = "";
	var checkboxSelectYN = eval("document.GroupAddedfrm.select_yn"+objIndex);
	if(checkboxSelectYN.checked == true)
	{
			return false;
	}
	else
	{
		for(var index = 1; index <= parseInt(arrayLength) ; index++)
		{
			var check = eval("document.GroupAddedfrm.select_yn"+index);
			if(check.checked==true)
			{
				var textSequenceValue = eval("document.GroupAddedfrm.seq_num"+index);
				sequenceNumber = textSequenceValue.value;
                
				if(sequenceNumber == "")
				{
					sequenceNumber = "null";
				}
				 
				var groupCode = eval("document.GroupAddedfrm.GroupCode"+index);
				var groupType = "", groupTypeValue = ""; 
				groupType = eval ("document.GroupAddedfrm.GroupType"+index);				
				groupTypeValue = groupType.value;
				
				var tdrow_id = document.getElementById('tdrow_id'+index);
				var tempString = tdrow_id.cells[0].innerText;
				if(finalString == "")
				{
					finalString = escape(tempString) + "||"+sequenceNumber  + "||" + groupCode.value + "||" +groupTypeValue; 
				}
				else
				{
					finalString = finalString +"~" + escape(tempString) + "||"+sequenceNumber + "||" + groupCode.value + "||" +groupTypeValue; 
				}                      
			}
		}
		if(parent.DetailsFrameBottom.document.GroupAddForm != null)
		{
			if(parent.DetailsFrameBottom.document.GroupAddForm.sequence != null)
			{
				var key = eval("document.GroupAddedfrm.GroupCode"+objIndex);
				parent.DetailsFrameBottom.document.GroupAddForm.hiddenFieldRemoveRow.value = key.value;
			
				arrayLength = parent.DetailsFrameBottom.document.GroupAddForm.sequence.value;
				
				for(index=1;index <= arrayLength ;index++)
				{
					var tblrow_id = eval("parent.DetailsFrameBottom.document.getElementById("tblrow_id")"+index);
					if(tblrow_id != null)
					{
						if(tblrow_id.cells[0].innerText == key.value)
						{
							var select_yn = eval("parent.DetailsFrameBottom.document.GroupAddForm.select_yn"+index);									
							document.GroupAddedfrm.remove_value.value = key.value;	
							select_yn.checked = false;
						}
					}
				}				
			}
		}
		
		parent.parent.HeaderFrame.document.HeaderForm.finalString.value = finalString;
		document.GroupAddedfrm.finalString.value = finalString;
		document.GroupAddedfrm.remove_value.value = document.GroupAddedfrm.remove_value.value;            

		document.GroupAddedfrm.summaryCode.value = parent.parent.HeaderFrame.document.HeaderForm.summary.value;				
		document.GroupAddedfrm.operation.value ='addRows';			
		document.GroupAddedfrm.action="EncSummConfigGroupAddedList.jsp";			
		document.GroupAddedfrm.target="DetailsFrameTop";			
        parent.parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";			
		document.GroupAddedfrm.submit();
	}
}






function callSummaryLookup()
{
	var target = document.HeaderForm.summary;
	target.value = "";
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title = getLabel("Common.Summary.label","Common");
	var sql = "SELECT es_summ_code code, es_summ_desc description, es_summ_title FROM cr_es_summ_hdr " +
			"WHERE es_summ_status='E' and upper(es_summ_code) like upper(?) and  upper(es_summ_desc) like upper(?) ORDER BY(es_summ_desc) ";
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
		document.HeaderForm.summaryCode.value = retArray[1];
		document.HeaderForm.summary.value = retArray[0];
	}
	else
	{
		document.HeaderForm.summary.value = '';
		document.HeaderForm.summaryCode.value = '';
	}

	secRefresh(target);
}

function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode;
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false;
		return true;
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}









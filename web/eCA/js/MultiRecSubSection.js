var rowIDArray = new Array();

function SearchCriteria()
{
	parent.parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?';
	if(parent.parent.frames[1].frames[1].document.forms[0] != null)
	{
		var section_code = parent.parent.HeaderFrame.document.HeaderForm.section.value;
		if(parent.parent.frames[1].frames[1].document.forms[0].searchtext.value != "")
		{
				var search_txt = parent.parent.frames[1].frames[1].document.forms[0].searchtext.value;
				parent.DetailsFrameBottom.location.href='../../eCA/jsp/MultiRecSubSectionDtl.jsp?searchtext='+search_txt+"&loadFirst=Yes&section_code="+section_code;
		}
		else
		{
			var erroMsg=getMessage("SEARCH_TEXT_BLANK",'Common');
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+erroMsg+'&err_value=0';
			return false;
		}
	}
}

/*
   Function Name : checkSequence(objSequence)
	Description :		The Function is Used For Validating Non Zero Entries
   @param objSequence  is Text Object Itself
  */
function checkSequence(objSequence)
{
	var errorMessage =""
	 if(objSequence.value <= 0 || objSequence.value =="-")
			{
				errorMessage= getMessage("SEQUENCE_NOT_ZERO",'CA');
				alert(errorMessage);
				objSequence.value=''
				//objSequence.focus()
				return false
			}
}


/*
    Function Name :  stringConCatenate(objIndex,objRowId)
	Description :	The Function is Used For ConCatenation of Text Fields Values and TD Data
   @param objIndex  Index of the Dynamically Created HTML Object
    @param objRow  is the  ID for the Table Row  Dynamically Created 
 */
function stringConCatenate(objIndex,objRowId)
{
	var rowid = objRowId
	var trTextData =rowid.cells[1].innerText
	var finalString = "" // variables USed to Concatenate Code ,Text Field Values and Also Description
	var select_yn = eval("document.MultiRecSubSectionDtlForm.select_yn"+objIndex);
	var remove_value = document.getElementById('tblrow_id' + objIndex);
	var arrayLength = 0;
		if(parent.DetailsFrameTop.document.MultiRecResultfrm!=null)
		{
			arrayLength = parent.DetailsFrameTop.document.MultiRecResultfrm.array_length.value
		}
	var index = 0
	var checkCode 
	var section_code = parent.parent.HeaderFrame.document.HeaderForm.section.value
	if(select_yn.checked==true)
	{
		parent.DetailsFrameTop.document.MultiRecResultfrm.add_value.value = remove_value.cells[0].innerText
		for( index= 1 ; index<= parseInt(arrayLength);index++)
		{
			var seq_num = eval ("parent.DetailsFrameTop.document.MultiRecResultfrm.seq_num"+index)
			var sequenceNumber = seq_num.value
			if(sequenceNumber == "")
			{
				sequenceNumber = "null"
			}
			var tdrow_id = parent.DetailsFrameTop.document.getElementById('tdrow_id' + index);
			var code = eval ("parent.DetailsFrameTop.document.MultiRecResultfrm.subSectionCode"+index)	
			checkCode = document.getElementById('tblrow_id' + objIndex)
			if(checkCode.cells[0].innerText == code.value)
			{
				return false
			}
			if(finalString == "")
			{
				finalString =  escape(tdrow_id.cells[0].innerText) + "||" + sequenceNumber + "||" + code.value
			}
			else
			{
				finalString = finalString + "~"+escape(tdrow_id.cells[0].innerText) + "||" + sequenceNumber + "||" + code.value
			}	
		}
	finalString = finalString + "~" +escape(trTextData) + "||" + "null" + "||" + rowid.cells[0].innerText
	parent.parent.HeaderFrame.document.HeaderForm.finalString.value =  finalString
	}
	else
	{
		finalString = ""
		for( index= 1 ; index<= parseInt(arrayLength);index++)
		{
			var seq_num = eval ("parent.DetailsFrameTop.document.MultiRecResultfrm.seq_num"+index)
			var sequenceNumber = seq_num.value
			if(sequenceNumber == "")
			{
				sequenceNumber = "null"
			}
			var tdrow_id = eval("parent.DetailsFrameTop.document.getElementById('tdrow_id" + index + "')");
			var code = eval ("parent.DetailsFrameTop.document.MultiRecResultfrm.subSectionCode"+index)	
			var stringRowId = new String()
			var stringTdRowId= new String();
			stringRowId = rowid.cells[1].innerText
			stringTdRowId = tdrow_id.cells[0].innerText 				
			if(code.value  != remove_value.cells[0].innerText)
			{
				if(finalString == "")
				{
					finalString = escape(stringTdRowId) + "||" + sequenceNumber + "||" + code.value
				}
				else
				{
					finalString = finalString + "~"+escape(stringTdRowId) + "||" + sequenceNumber + "||" + code.value
				}
			}	
		}
	parent.parent.HeaderFrame.document.HeaderForm.finalString.value =  finalString
	}
	parent.DetailsFrameTop.document.MultiRecResultfrm.finalString.value = finalString
	parent.DetailsFrameTop.document.MultiRecResultfrm.remove_value.value =remove_value.cells[0].innerText
	parent.DetailsFrameTop.document.MultiRecResultfrm.section_code.value = parent.parent.HeaderFrame.document.HeaderForm.section.value
	parent.DetailsFrameTop.document.MultiRecResultfrm.operation.value ='split'
	parent.DetailsFrameTop.document.MultiRecResultfrm.submit();
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
	var arrayLength = document.MultiRecResultfrm.array_length.value
	
	var sequenceNumber = "" // String used for Concatenating Text Fields Values
	var finalString = ""
	var checkboxSelectYN = eval("document.MultiRecResultfrm.select_yn"+objIndex)
		if(checkboxSelectYN.checked == true)
		{
				return false
		}
		else
		{
			for(var index = 1; index <= parseInt(arrayLength) ; index++)
			{
				var check = eval("document.MultiRecResultfrm.select_yn"+index)
				if(check.checked==true)
				{
						var textSequenceValue = eval("document.MultiRecResultfrm.seq_num"+index)
						sequenceNumber =textSequenceValue.value
                        
						if(sequenceNumber == "")
						{
							sequenceNumber = "null"
						}
						 
						var sectionCode = eval("document.MultiRecResultfrm.subSectionCode"+index)
						var tdrow_id = document.getElementById('tblrow_id'+index)
						var tempString  	= tdrow_id.cells[0].innerText
						if(finalString == "")
						{
							finalString =escape(tempString) + "||"+sequenceNumber  + "||" + sectionCode.value 
						}
						else
						{
							finalString =finalString +"~" + escape(tempString) + "||"+sequenceNumber + "||" + sectionCode.value 
						}
                          
				}
			}
			if(parent.DetailsFrameBottom.document.MultiRecSubSectionDtlForm != null)
			{
				if(parent.DetailsFrameBottom.document.MultiRecSubSectionDtlForm.sequence != null)
					{
							var key = eval("document.MultiRecResultfrm.subSectionCode"+objIndex)
							parent.DetailsFrameBottom.document.MultiRecSubSectionDtlForm.hiddenFieldRemoveRow.value = key.value;
						
							arrayLength = parent.DetailsFrameBottom.document.MultiRecSubSectionDtlForm.sequence.value
							{
								for(index=1;index <= arrayLength ;index++)
								{
									var tblrow_id = eval("parent.DetailsFrameBottom.document.getElementById('tblrow_id')"+index)
									if(tblrow_id != null)
									{
										if(tblrow_id.cells[0].innerText == key.value)
											{
												var select_yn = eval("parent.DetailsFrameBottom.document.MultiRecSubSectionDtlForm.select_yn"+index)
													
												document.MultiRecResultfrm.remove_value.value = key.value	

												select_yn.checked = false
											}
									}
								}								
							}
					}
			}
			
			parent.parent.HeaderFrame.document.HeaderForm.finalString.value = finalString
			document.MultiRecResultfrm.finalString.value = finalString
			document.MultiRecResultfrm.remove_value.value =document.MultiRecResultfrm.remove_value.value
            

			document.MultiRecResultfrm.section_code.value = parent.parent.HeaderFrame.document.HeaderForm.section.value
				
			document.MultiRecResultfrm.operation.value ='split'
			
			document.MultiRecResultfrm.action="MultiRecSubSectionList.jsp";
			
			document.MultiRecResultfrm.target="DetailsFrameTop";
			
	        parent.parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp";
			
			document.MultiRecResultfrm.submit();
		}
}


/*
   Function Name : create()
   Description :  Used for Loading the Function
  */
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/MultiRecSubSectionMain.jsp';
}


function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/SubSectionQueryCriteria.jsp';
}


/*
  Function Name : apply()
	Description : HTML Object  Values of the file MultiRecSubSectionDtl.jsp values are Posted to SubSectionServlet.java file
  */
function apply()
{

if(f_query_add_mod.DetailsFrame!=null)
{
if(f_query_add_mod.HeaderFrame.document.HeaderForm
!=null&& f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm !=null)
	{
var section_code =f_query_add_mod.HeaderFrame.document.HeaderForm.section.value;
var finalString = "";
var index = 0
if(section_code !="")
	{
		
		var arrayLength = f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.array_length.value			
		
		for( index= 1 ; index<= parseInt(arrayLength);index++)
		{
			
			var seq_num = eval ("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.seq_num"+index)
			var sequenceNumber = seq_num.value
			if(seq_num.value == "")
			{
				var error = getMessage("SEQUENCE_NOT_ZERO",'CA');
				seq_num.focus()
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&error_value=0";
				return false;
			}
			var tdrow_id = eval("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.getElementById('tdrow_id" + index + "')");
			var sectionCode = eval("f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.subSectionCode"+index);
			if(finalString == "")
			{
				//finalString =  escape(tdrow_id.cells[0].innerText) + "||" + sequenceNumber + "||"+ sectionCode.value
				finalString =  tdrow_id.cells[0].innerText + "||" + sequenceNumber + "||"+ sectionCode.value
			}
			else
			{
				//finalString = finalString + "~"+escape(tdrow_id.cells[0].innerText) + "||" + sequenceNumber + "||"+ sectionCode.value
				finalString = finalString + "~"+tdrow_id.cells[0].innerText+ "||" + sequenceNumber + "||"+ sectionCode.value
			}
		}
		
		f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.finalString.value = finalString
		f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.section_code.value = section_code
		f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.method="post";
		f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.action ="../../servlet/eCA.SubSectionServlet";
		f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.target ="messageFrame";
		f_query_add_mod.DetailsFrame.DetailsFrameTop.document.MultiRecResultfrm.submit();
	}
	else
	{
		var errorMsg=getMessage("SEQUENCE_NOT_ZERO",'CA');
		if(errorMsg!="")
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=0";
			f_query_add_mod.HeaderFrame.document.HeaderForm.section.focus();
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


/*
  Function Name :  fetchRecords()
 Description : The Function is Used For populating Values in the Select Box
 */
function fetchRecords()
{
	var section_code = document.HeaderForm.section.value;
	if(section_code !="")
	{
		 	parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameMiddle.location.href='../../eCA/jsp/MultiRecSubSectionSearchCriteria.jsp'
		  parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameTop.location.href='../../eCA/jsp/MultiRecSubSectionList.jsp?section_code='+section_code
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
//	 		parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameBottom.location.href='../../eCA/jsp/MultiRecSubSectionDtl.jsp?section_code='+section_code+'&loadFirst=Yes'
	 		parent.parent.f_query_add_mod.DetailsFrame.DetailsFrameBottom.location.href='../../eCommon/html/blank.html';

	}
	else
	{
			var erroMsg=getMessage("SECTION_NOT_BLANK",'CA');
			if(erroMsg!="")
			{
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+erroMsg+"&err_value=0";
				//document.HeaderForm.section.focus();
				return false;
			}
	}
}


/*
  Function Name : secRefresh(obj)
  Description : The Function is Used For Reloading the Frames 
  @param obj is the Object itself
*/
function secRefresh(obj)
{
		parent.DetailsFrame.location.href='../../eCA/jsp/MultiRecSubSectionFrameSet.jsp';
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		parent.HeaderFrame.document.HeaderForm.finalString.value=""
}
/*
 Function name :   reset()
Description : The Function is Used For Refreshing the Function

*/


function reset()
{
	//f_query_add_mod.location.reload();

	if(f_query_add_mod.location.href.indexOf("SubSectionQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
	else if(f_query_add_mod.location.href.indexOf("QuerySubSection.jsp") != -1)
	{
	}
	else if(f_query_add_mod.location.href.indexOf("SubSectionQueryCriteria.jsp") == -1){
		//f_query_add_mod.document.forms[0].reset();
		 create();
		//return false;
	}
	 //if(f_query_add_mod.document.HeaderForm != null )
		 //create();
 
	 //messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
}


/*
 Function name :   onSuccess
Description : Function  is Invoked automatically when Records are Submitted to the DataBase 
*/
function onSuccess() 
{
  	f_query_add_mod.HeaderFrame.document.HeaderForm.reset();
	f_query_add_mod.DetailsFrame.location.href='../../eCA/jsp/MultiRecSubSectionFrameSet.jsp';
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


function prevNextRecs(stringValue)
{
	var start = document.MultiRecSubSectionDtlForm.from.value;
	var end = document.MultiRecSubSectionDtlForm.to.value;
	var sectionCode = document.MultiRecSubSectionDtlForm.sectionCode.value;
	var searchText = document.MultiRecSubSectionDtlForm.searchText.value;
	var rwIdIndex = document.MultiRecSubSectionDtlForm.rwIdIndex.value;
	var hiddenFieldRemoveRow = document.MultiRecSubSectionDtlForm.hiddenFieldRemoveRow.value;
	var count = document.MultiRecSubSectionDtlForm.count.value;
	var fromRowId = "";
	var toRowId = "";
	var tempRowIds = "";
	var tempString = "";

	if(stringValue == 'prev')
	{
		start = parseInt(start,10) - 7;
		end = parseInt(end,10) - 7;
	}
	else if(stringValue == 'next')
	{
		start = parseInt(start,10) + 7;
		end = parseInt(end,10) + 7;
	}

	for(var t=parseInt(start,10);t<parseInt(end,10);t++)
	{
		tempString = parent.parent.rowIDArraySubSecMain[t];

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

	parent.DetailsFrameBottom.location.href='../../eCA/jsp/MultiRecSubSectionDtl.jsp?section_code='+sectionCode+'&searchtext='+searchText+'&start='+start+'&end='+end+'&tempRowIds='+tempRowIds+'&hiddenFieldRemoveRow='+hiddenFieldRemoveRow+'&totalCount='+count;
}
async function callMainSectionLookup()
{
	var target = document.HeaderForm.section;
	target.value = "";
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= getLabel("eCA.MainSection.label","CA");
	var sql="SELECT sec_hdg_code code, sec_hdg_desc description, sec_hdr_meta_desc FROM ca_section_hdg  WHERE eff_status='E' AND content_type='S' and upper(sec_hdg_code) like upper(?) and  upper(sec_hdg_desc) like upper(?)   ORDER BY(sec_hdg_desc) ";
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


	retArray =await CommonLookup( title, argArray );
	var ret1=unescape(retArray);
 	arr=ret1.split(",");
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}

	if(retArray != null && retArray !="")
	{
		document.HeaderForm.sectionCode.value = arr[1];
		document.HeaderForm.section.value = arr[0];
	}
	else
	{
		document.HeaderForm.section.value = '';
		document.HeaderForm.sectionCode.value = '';
	}

	secRefresh(target);
}

function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false
		return true
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


async function resetValues()
{
	
  parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}
function setValue()
{
	document.forms[0].flag.value='false';
}

function getMultiSubSectionCode(objCode)
{
	if(objCode.name=='sectionCode')
	{
		section(objCode)
	}

	if(objCode.name == "section_search")
	{		
		if(document.forms[0].flag.value=='false')
			return false
		else

			callMainSectionLookup()
	}

}


 function section(objCode)
{
	var section_code = objCode.value;
	if(section_code == '')
	{
		document.forms[0].flag.value ='true';
		return false
	}
	else
	{
		
		parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/MultiRecSubSectionIntermediate.jsp'><input type='hidden' name='section_code' id='section_code' value='"+section_code+"'><input type=hidden name='selFunVal' id='selFunVal' value='MainSection'></form></body></html>";
		
       parent.frames[1].document.write(HTMLVal);
	   parent.frames[1].document.tempform1.submit(); 

    }
}

                function callFunction(sql,title,target)
                 {
					 //alert("on blur"+target.value);
	                 //alert("title"+title);
	                 //alert("sql"+sql);

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




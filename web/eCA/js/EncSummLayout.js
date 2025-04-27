//Created by Sethuraman for encounter Summary requirements
var rowIDArray = new Array();

/*
 * Functions called from EncSummLayoutHdr.jsp
 */

/*
Function Name : create()
Description :  Used for Loading the Function
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/EncSummLayoutMain.jsp?mode=insert';
}


function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/EncSummLayoutMain.jsp?mode=insert';
}


/*
Function Name : apply()
	Description : HTML Object  Values of the file EncSummConfigGroupAddedList.jsp values are Posted to EncSummConfigServlet.java file
*/
function apply()
{
	if(f_query_add_mod.DetailsFrame!=null)
	{
		var summary_code = f_query_add_mod.HeaderFrame.document.HeaderForm.summary.value;
		var finalString = "";
		var index = 0;	
		var headerOrientValue = 0;
		var colorIndicateValue = 0;
		var tblCellColFillValue = 0;
		var tblCellBorFillValue = 0;
		var signatureFlagValue = 0;
		var signPosValue = 0;
		
		var signature1FlagValue = 0;
		var signature1PractValue = 0;
		var signature1SpltyFlagValue = 0;
		
		var signature2FlagValue = 0;
		var signature2PractValue = 0;
		var signature2SpltyFlagValue = 0;
		
		var signature3FlagValue = 0;
		var signature3PractValue = 0;
		var signature3SpltyFlagValue = 0;
		
		var headerOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.orientation");
		var headerRadios = headerOrient;

		var headerOrientValue = 0;
		var headerHtml = "";
		
		if(summary_code !="")
		{	
			
			// Header Orientation value
			headerOrientValue = getHeaderOrient();			
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenHeaderOrient.value = headerOrientValue;
			
			// Color Indicate value
			//Table Cell Color Fill value
			var colorIndicatefield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_colors_indicate");			
			if (colorIndicatefield.checked == true)
			{
				colorIndicateValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenColorIndicate.value = colorIndicateValue;
			
			//Table Cell Color Fill value
			var tblCellColFillfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_tab_cell_color");			
			if (tblCellColFillfield.checked == true)
			{
				tblCellColFillValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenTblCellColFill.value = tblCellColFillValue;
			
			//Table Cell Border Fill value
			var tblCellBorFillfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_tbl_cell_bborder_fill");			
			if (tblCellBorFillfield.checked == true)
			{
				tblCellBorFillValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenTblCellBorFill.value = tblCellBorFillValue;
			
			//Signature Flag value
			var signatureFlagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_flag");			
			if (signatureFlagfield.checked == true)
			{
				signatureFlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSignFlag.value = signatureFlagValue;
			
			//Signature Position value
			var es_footer_sign_posn = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_posn");
			
			var signPosRadios = es_footer_sign_posn;
			for(var i = 0; i < signPosRadios.length; i++){
			    if(signPosRadios[i].checked){
			    	signPosValue = signPosRadios[i].value;
			    }
			}	
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSignPosn.value = signPosValue;
			
			//Signature 1 Flag value
			var signature1Flagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_flag");			
			if (signature1Flagfield.checked == true)
			{
				signature1FlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign1Flag.value = signature1FlagValue;
			
			// Signature 1 label
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign1Lbl.value = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_label.value; 
			
			// Signature Practitioner Type
			signature1PractValue = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_practid.value;
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign1Pract.value = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_practid.value;
			
			//Signature 1 Specialty Flag value
			var signature1SpltyFlagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_splty");			
			if (signature1SpltyFlagfield.checked == true)
			{
				signature1SpltyFlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign1Splty.value = signature1SpltyFlagValue;
			
			//Signature 2 Flag value
			var signature2Flagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_flag");			
			if (signature2Flagfield.checked == true)
			{
				signature2FlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign2Flag.value = signature2FlagValue;
			
			// Signature 2 label
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign2Lbl.value = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_label.value; 
			
			// Signature 2 Practitioner Type
			signature2PractValue = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_practid.value;
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign2Pract.value = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_practid.value;
			
			//Signature 2 Specialty Flag value
			var signature2SpltyFlagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_splty");			
			if (signature2SpltyFlagfield.checked == true)
			{
				signature2SpltyFlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign2Splty.value = signature2SpltyFlagValue;
			
			//Signature 3 Flag value
			var signature3Flagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_flag");			
			if (signature3Flagfield.checked == true)
			{
				signature3FlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign3Flag.value = signature3FlagValue;
			
			// Signature 3 label
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign3Lbl.value = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_label.value; 
			
			// Signature 3 Practitioner Type
			signature3PractValue = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_practid.value;
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign3Pract.value = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_practid.value;
			
			//Signature 3 Specialty Flag value
			var signature3SpltyFlagfield = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_splty");			
			if (signature3SpltyFlagfield.checked == true)
			{
				signature3SpltyFlagValue = 1;
			}
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.hiddenFooterSign3Splty.value = signature3SpltyFlagValue;
			
			var arrayLength = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.fieldsCount.value;
			
			for( index= 0 ; index< parseInt(arrayLength);index++)
			{	
				var fieldId = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_id"+index);
				var fieldHiddenFlag = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_hidden_flag"+index);
				var fieldflag = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_flag"+index);
				var fieldOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_orient"+index);
				var fieldLbl = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_lbl"+index);	
				
				var fieldLblvalue = "";
				
				var radios = fieldOrient;
				var flagValue = 0;
				var orientValue = 0;
				for(var i = 0; i < radios.length; i++){
				    if(radios[i].checked){
				    	orientValue = radios[i].value;
				    }
				}	
				
				if (fieldflag.checked == true)
				{
					flagValue = 1;
				}
				
				if ((fieldLbl.value == null) || (fieldLbl.value == ""))
				{
					fieldLblvalue = null;
				}
				else
				{
					fieldLblvalue = fieldLbl.value;
				}
				
				if(finalString == "")
				{
					finalString =  fieldId.value + "||" + fieldHiddenFlag.value + "||" + flagValue + "||"+ orientValue + "||"+ fieldLblvalue;
				}
				else
				{
					finalString = finalString + "~"+fieldId.value +"||" + fieldHiddenFlag.value + "||" + flagValue + "||"+ orientValue + "||"+ fieldLblvalue;
				}
			}
			
		
			for(var i = 0; i < headerRadios.length; i++){
			    if(headerRadios[i].checked){
			    	headerOrientValue = headerRadios[i].value;
			    }
			}	
			
			if (headerOrientValue == 0)		
				headerHtml = getVerticalHeader(1);
			else
				headerHtml = getHorizontalHeader(1);
			
			var footerHtml = "";	
			
			footerHtml = getFooterHtml(1);
			
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.headerValue.value = headerHtml;
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.footerValue.value = footerHtml;
			
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.fieldsValue.value = finalString;
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_summ_code.value = summary_code;
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.method = "post";
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.action ="../../servlet/eCA.EncSummLayoutServlet";
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.target ="messageFrame";
			f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.submit();
			
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
        			"<input type='hidden' name='detailsFrameSrc' id='detailsFrameSrc' value='../../eCommon/html/blank.html'>" +
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
		parent.parent.f_query_add_mod.DetailsFrame.location.href='../../eCA/jsp/EncSummLayoutConfig.jsp?mode=insert&summaryCode='+summary_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";		
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
	parent.DetailsFrame.location.href='../../eCA/jsp/EncSummLayoutFrameSet.jsp';
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	parent.HeaderFrame.document.HeaderForm.finalString.value="";
}


/*
Function name :   reset()
Description : The Function is Used For Refreshing the Function
*/
function reset()
{
	if(f_query_add_mod.location.href.indexOf("EncSummLayoutHdr.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}	
	else if(f_query_add_mod.location.href.indexOf("EncSummLayoutHdr.jsp") == -1)
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
	var summaryCode = f_query_add_mod.HeaderFrame.document.HeaderForm.summary.value;
	var summaryDesc = f_query_add_mod.HeaderFrame.document.HeaderForm.summaryCode.value;
	
	//f_query_add_mod.HeaderFrame.document.HeaderForm.reset();
	f_query_add_mod.HeaderFrame.location.href='../../eCA/jsp/EncSummLayoutHdr.jsp?mode=insert&summaryCode='+summaryCode+'&summaryDesc='+summaryDesc;
	f_query_add_mod.DetailsFrame.location.href='../../eCA/jsp/EncSummLayoutConfig.jsp?mode=insert&summaryCode='+summaryCode;
	//f_query_add_mod.DetailsFrame.location.href='../../eCommon/html/blank.html';
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
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*: ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function setSignatureFields(signNum, obj){
	
	if (signNum == 0)
	{	
		var radios = document.SummLayoutConfigForm.es_footer_sign_posn;

		for (var i=0, iLen=radios.length; i<iLen; i++) {
		  radios[i].disabled = true;
		} 
		
		//document.getElementById("es_footer_sign_posn").disabled = true;
		
		document.SummLayoutConfigForm.es_footer_sign_1_flag.disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_2_flag.disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_3_flag.disabled = true;

		document.SummLayoutConfigForm.es_footer_sign_1_label.disabled = true;
		document.getElementById("es_footer_sign_1_practid").disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_1_splty.disabled = true;
		
		document.SummLayoutConfigForm.es_footer_sign_2_label.disabled = true;
		document.getElementById("es_footer_sign_2_practid").disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_2_splty.disabled = true;
		
		document.SummLayoutConfigForm.es_footer_sign_3_label.disabled = true;
		document.getElementById("es_footer_sign_3_practid").disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_3_splty.disabled = true;
		
		if (obj.checked == true){
			for (var i=0, iLen=radios.length; i<iLen; i++) {
				  radios[i].disabled = false;
				} 
			//document.getElementById("es_footer_sign_posn").disabled = false;			
			document.SummLayoutConfigForm.es_footer_sign_1_flag.disabled = false;			
			document.SummLayoutConfigForm.es_footer_sign_2_flag.disabled = false;
			document.SummLayoutConfigForm.es_footer_sign_3_flag.disabled = false;		
			
			if (document.SummLayoutConfigForm.es_footer_sign_1_flag.checked == true){				
				document.SummLayoutConfigForm.es_footer_sign_1_label.disabled = false;
				document.getElementById("es_footer_sign_1_practid").disabled = false;
				document.SummLayoutConfigForm.es_footer_sign_1_splty.disabled = false;
			}
			
			if (document.SummLayoutConfigForm.es_footer_sign_2_flag.checked == true){				
				document.SummLayoutConfigForm.es_footer_sign_2_label.disabled = false;
				document.getElementById("es_footer_sign_2_practid").disabled = false;
				document.SummLayoutConfigForm.es_footer_sign_2_splty.disabled = false;
			}
			
			if (document.SummLayoutConfigForm.es_footer_sign_3_flag.checked == true){				
				document.SummLayoutConfigForm.es_footer_sign_3_label.disabled = false;
				document.getElementById("es_footer_sign_3_practid").disabled = false;
				document.SummLayoutConfigForm.es_footer_sign_3_splty.disabled = false;
			}
				
		}
	}
	if (signNum == 1)
	{
		document.SummLayoutConfigForm.es_footer_sign_1_label.disabled = true;
		document.getElementById("es_footer_sign_1_practid").disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_1_splty.disabled = true;
		if (obj.checked == true){
			document.SummLayoutConfigForm.es_footer_sign_1_label.disabled = false;
			document.getElementById("es_footer_sign_1_practid").disabled = false;
			document.SummLayoutConfigForm.es_footer_sign_1_splty.disabled = false;
		}
	}
	if (signNum == 2)
	{
		document.SummLayoutConfigForm.es_footer_sign_2_label.disabled = true;
		document.getElementById("es_footer_sign_2_practid").disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_2_splty.disabled = true;
		if (obj.checked == true){
			document.SummLayoutConfigForm.es_footer_sign_2_label.disabled = false;
			document.getElementById("es_footer_sign_2_practid").disabled = false;
			document.SummLayoutConfigForm.es_footer_sign_2_splty.disabled = false;
		}
	}
	if (signNum == 3)
	{
		document.SummLayoutConfigForm.es_footer_sign_3_label.disabled = true;
		document.getElementById("es_footer_sign_3_practid").disabled = true;
		document.SummLayoutConfigForm.es_footer_sign_3_splty.disabled = true;
		if (obj.checked == true){
			document.SummLayoutConfigForm.es_footer_sign_3_label.disabled = false;
			document.getElementById("es_footer_sign_3_practid").disabled = false;
			document.SummLayoutConfigForm.es_footer_sign_3_splty.disabled = false;
		}
	}
}

function setHeadFootFields(fieldNum){

	var fieldflag = eval("document.SummLayoutConfigForm.es_field_flag"+fieldNum);
	var fieldOrient = eval("document.SummLayoutConfigForm.es_field_orient"+fieldNum);
	var fieldLbl = eval("document.SummLayoutConfigForm.es_field_lbl"+fieldNum);	
	var fieldType = eval("document.SummLayoutConfigForm.es_field_type"+fieldNum);	
	
	var radios = fieldOrient;
	
	for (var i=0, iLen=radios.length; i<iLen; i++) {
	  radios[i].disabled = true;
	} 
	
	fieldLbl.disabled =  true;
	
	if (fieldflag.checked == true){		
		for (var i=0, iLen=radios.length; i<iLen; i++) {
			if (!(fieldType.value == "P")){
			  radios[i].disabled = false;
			}
		}
		
		fieldLbl.disabled = false;		
	}
}

function getHeaderOrient(){
	
	var headerOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.orientation");
	var headerRadios = headerOrient;

	var headerOrientValue = 0;
	
	for(var i = 0; i < headerRadios.length; i++){
	    if(headerRadios[i].checked){
	    	headerOrientValue = headerRadios[i].value;
	    }
	}	
	
	return headerOrientValue;
	
	
}

function showHeaderHtml(){
	
	var headerOrient = eval("document.SummLayoutConfigForm.orientation");
	var summary_code = document.SummLayoutConfigForm.es_summ_code.value;
	var headerRadios = headerOrient;

	var headerOrientValue = 0;
	var headerHtml = "";
	
	var fieldChangeFlag = false;
	
	for(var i = 0; i < headerRadios.length; i++){
	    if(headerRadios[i].checked){
	    	headerOrientValue = headerRadios[i].value;
	    }
	}	
	
	if (headerOrientValue == 0)		
		headerHtml = getVerticalHeader(0);
	else
		headerHtml = getHorizontalHeader(0);
	
	/*	
	document.SummLayoutConfigForm.headerValue.value = headerHtml;
	document.SummLayoutConfigForm.footerValue.value = "update";
	
	document.SummLayoutConfigForm.mode.value = "update";
	document.SummLayoutConfigForm.es_summ_code.value = summary_code;
	document.SummLayoutConfigForm.method = "post";
	document.SummLayoutConfigForm.action ="../../servlet/eCA.EncSummLayoutServlet";
	document.SummLayoutConfigForm.target ="messageFrame";
	document.SummLayoutConfigForm.submit();
	*/
	fieldChangeFlag = getFormElements();
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.changeFlag.value = fieldChangeFlag;
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.headerValue.value = headerHtml;
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.footerValue.value = "update";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.mode.value = "update";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.es_summ_code.value = summary_code;
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.method = "post";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.action ="../../servlet/eCA.EncSummLayoutServlet";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.target ="messageFrame";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.submit();

	//headerHtml = encodeURIComponent(headerHtml);
	
	/*
	var dialogHeight= "400px" ;
	var dialogWidth	= "1050px" ;
	var dialogTop	= "100";
	var dialogLeft	= "100";
	var arguments	= "" ;
	var modalfeatures	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no;help:no; location:no ";
	
	var ret = window.showModalDialog("../../eCA/jsp/EncSummPageHeader.jsp?summCode="+summary_code,arguments,modalfeatures);
	*/
	//parent.parent.f_query_add_mod.DetailsFrame.location.href='../../eCA/jsp/EncSummLayoutConfig.jsp?mode=insert&summaryCode='+summary_code;
}

function getVerticalHeader(applyFlag){
	var htmlHeader = "";
	var index = 0;
	var headerTrFlag = false;
	var facilityTrFlag = false;
	var contact1TrFlag = false;
	var contact2TrFlag = false;
	var faxEmailTrFlag = false;
	var patientTrFlag = false;
	
	var encounterTrFlag = false;
	
	var addressHeadFlag = false;
	
	var genderTrFlag = false;
	var dobTrFlag = false;
	
	var orderFlag = false;
	var orderTrFlag = false;
	var orderCount = 0;
	
	var arrayLength = 0;
	var fieldId = "";
	var fieldflag = "";
	var fieldOrient = "";
	var fieldLbl = "";	
	var colorIndicatefieldflag = "";
	
	// Main Table
	//htmlHeader = "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'>"; 
	//htmlHeader = htmlHeader + "<thead>";	
	
	if (applyFlag == 0 ){
		arrayLength = document.SummLayoutConfigForm.fieldsCount.value;
	}
	else
	{
		arrayLength = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.fieldsCount.value;
	}
	
	for( index= 0 ; index< parseInt(arrayLength);index++)
	{	
		if (applyFlag == 0 ){
			fieldId 	= eval("document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		else
		{
			fieldId 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		
		var radios = fieldOrient;
		var orientValue = 0;
		
		if (fieldflag.checked == true)
		{
			for(var i = 0; i < radios.length; i++){
			    if(radios[i].checked){
			    	orientValue = radios[i].value;
			    }
			}			
			
			if (orientValue == 0)
			{
				if (fieldId.value == "ES_FACILITY_ADD"){
					addressHeadFlag = true;
				}
			}
		}
	}

	for( index= 0 ; index< parseInt(arrayLength);index++)
	{	

		if (applyFlag == 0 ){
			fieldId 	= eval("document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		else
		{
			fieldId 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		
		
		var radios = fieldOrient;
		var orientValue = 0;
		
		if (fieldflag.checked == true)
		{
			for(var i = 0; i < radios.length; i++){
			    if(radios[i].checked){
			    	orientValue = radios[i].value;
			    }
			}			
			
			if (orientValue == 0)
			{				
				//Header Table row
				if ((fieldId.value == "ES_FACILITY_LOGO") || (fieldId.value == "ES_FACILITY_NAME") || (fieldId.value == "ES_FACILITY_ADD") || (fieldId.value == "ES_FACILITY_CONTACT1") || 
						(fieldId.value == "ES_FACILITY_CONTACT2") || (fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4") ||
						(fieldId.value == "ES_FACILITY_FAX") || (fieldId.value == "ES_FACILITY_EMAIL") || (fieldId.value == "ES_FACILITY_WEB") ||
						(fieldId.value == "ES_PATIENT_NAME") || (fieldId.value == "ES_PATIENT_GENDER") || 
						(fieldId.value == "ES_PATIENT_DOB") || (fieldId.value == "ES_PATIENT_AGE") || (fieldId.value == "ES_PATIENT_BLOODGRP")||
						(fieldId.value == "ES_PATIENT_ID") || (fieldId.value == "ES_ENCOUNTER_ID") || (fieldId.value == "ES_ENCOUNTER_DATE") || 
						(fieldId.value == "ES_ENCOUNTER_SPEC") || (fieldId.value == "ES_ENCOUNTER_PRACTID") || (fieldId.value == "ES_ENCOUNTER_PAYER")) 
				{					
					if (!(headerTrFlag)){
						htmlHeader = htmlHeader + "<tr><th>";
						htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'>";
						htmlHeader = htmlHeader + "<tbody>";
						htmlHeader = htmlHeader + "<tr>";
						headerTrFlag = true;
					}
				}
				
				//Facility Details Table
				if ((fieldId.value == "ES_FACILITY_LOGO") || (fieldId.value == "ES_FACILITY_NAME") || (fieldId.value == "ES_FACILITY_ADD") || (fieldId.value == "ES_FACILITY_CONTACT1") || 
						(fieldId.value == "ES_FACILITY_CONTACT2") || (fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4") ||
						(fieldId.value == "ES_FACILITY_FAX") || (fieldId.value == "ES_FACILITY_EMAIL") || (fieldId.value == "ES_FACILITY_WEB") ) 
				{
					
					if (!(facilityTrFlag)) {						
						htmlHeader = htmlHeader + "<td style='border-bottom:2px solid green' valign='top'>";							
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>";
						htmlHeader = htmlHeader + "	<tbody>";
						facilityTrFlag = true;
					}
				}
				
				if (fieldId.value == "ES_FACILITY_LOGO"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td>";							
					htmlHeader = htmlHeader + "<table border='0' cellpadding='1' cellspacing='1' style='width: 300px'>";
					htmlHeader = htmlHeader + "	<tbody>";
					htmlHeader = htmlHeader + "	<tr>";
					htmlHeader = htmlHeader + "	<td align='center'>";											
					htmlHeader = htmlHeader + "	<img src='../../eCA/images/facilityImageName' title='Logo' width='100px' height='100px'>";
					htmlHeader = htmlHeader + "	</td>";									
					htmlHeader = htmlHeader + "	</tr>";
					htmlHeader = htmlHeader + "	</tbody>";
					htmlHeader = htmlHeader + "</table>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					
				}
				
				if (fieldId.value == "ES_FACILITY_NAME"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='center'>";							
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							"facilityName</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";						
				}
				
				if (fieldId.value == "ES_FACILITY_ADD"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='center'>";							
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							"address</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";						
				}
				
				// Contact 1 & Contact 2 row
				/* -------------
				if ((fieldId.value == "ES_FACILITY_CONTACT1") || (fieldId.value == "ES_FACILITY_CONTACT2")){
					if (!(contact1TrFlag)){
						contact1TrFlag = true;
						htmlHeader = htmlHeader + "<tr>";
						htmlHeader = htmlHeader + "<td valign='top'>";
					}							
				}
				*/
				
				
				if (fieldId.value == "ES_FACILITY_CONTACT1"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"telephone1</span></span></strong></span>";
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
				}
				if (fieldId.value == "ES_FACILITY_CONTACT2"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
							""+fieldLbl.value+"telephone2</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					contact1TrFlag = false;
				}
				
				
				/* -----------------
				if (!(fieldId.value == "ES_FACILITY_CONTACT1") && (contact1TrFlag)){
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					contact1TrFlag = false;
				}
				*/
				// Contact 3 & Contact 4 row	
				/* ----------------
				if ((fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4")){
					if (!(contact2TrFlag)){
						contact2TrFlag = true;
						htmlHeader = htmlHeader + "<tr>";
						htmlHeader = htmlHeader + "<td valign='top'>";
					}
				}
				*/
								
				if (fieldId.value == "ES_FACILITY_CONTACT3"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"telephone3</span></span></strong></span>";	
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
				}
				if (fieldId.value == "ES_FACILITY_CONTACT4"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
							""+fieldLbl.value+"telephone4</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					contact2TrFlag = false;
				}
				
				if (fieldId.value == "ES_FACILITY_FAX"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"fax</span></span></strong></span>";	
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
				}
				if (fieldId.value == "ES_FACILITY_EMAIL"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
							""+fieldLbl.value+"emailId</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					faxEmailTrFlag = false;
				}
				
				
				if (!(fieldId.value == "ES_FACILITY_LOGO") && !(fieldId.value == "ES_FACILITY_NAME") && !(fieldId.value == "ES_FACILITY_ADD") && !(fieldId.value == "ES_FACILITY_CONTACT1") &&  
						!(fieldId.value == "ES_FACILITY_CONTACT2") && !(fieldId.value == "ES_FACILITY_CONTACT3") && !(fieldId.value == "ES_FACILITY_CONTACT4") &&
						!(fieldId.value == "ES_FACILITY_FAX") && !(fieldId.value == "ES_FACILITY_EMAIL") && !(fieldId.value == "ES_FACILITY_WEB")) 
				{
					if (facilityTrFlag) {																	
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>	";
						htmlHeader = htmlHeader + "</td>";	
						facilityTrFlag = false;
					}
				}
				
				
				// Patient details Table 
				if ((fieldId.value == "ES_PATIENT_NAME") || (fieldId.value == "ES_PATIENT_GENDER") || 
						(fieldId.value == "ES_PATIENT_DOB") || (fieldId.value == "ES_PATIENT_AGE") || (fieldId.value == "ES_PATIENT_BLOODGRP")||
						(fieldId.value == "ES_ENCOUNTER_PRACTID") || (fieldId.value == "ES_ENCOUNTER_PAYER")) 
				{
					if (!(patientTrFlag)) {						
						htmlHeader = htmlHeader + "<td style='border-bottom:2px solid green' valign='top'>";							
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='3' cellspacing='3' style='width: 360px'>";
						htmlHeader = htmlHeader + "	<tbody>";
						patientTrFlag = true;
					}
				}
				if (fieldId.value == "ES_PATIENT_NAME"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td align='left' colspan='2'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>patientName</span></span>";
					htmlHeader = htmlHeader + "</td>";									
					htmlHeader = htmlHeader + "</tr>";
				}
				
				if (((fieldId.value == "ES_PATIENT_GENDER") || (fieldId.value == "ES_PATIENT_BLOODGRP")) && !(genderTrFlag)){
					genderTrFlag = true;
					htmlHeader = htmlHeader + "<tr>";					
					htmlHeader = htmlHeader + "<td align='left' valign='top'>";
					htmlHeader = htmlHeader + "<table border='0' cellpadding='0' cellspacing='0' style='width: 360px'>";
					htmlHeader = htmlHeader + "<tbody>";
					htmlHeader = htmlHeader + "<tr>";
				}
				
				if (fieldId.value == "ES_PATIENT_GENDER"){
					htmlHeader = htmlHeader + "<td align='left'  valign='top'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>gender</span></span>";
					htmlHeader = htmlHeader + "</td>";	
				}				
				if (fieldId.value == "ES_PATIENT_BLOODGRP"){
					htmlHeader = htmlHeader + "<td align='left'  valign='top'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
									""+fieldLbl.value+" </span></span></strong></span>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>bloodGroup</span></span>";
					htmlHeader = htmlHeader + "</td>";	
				}
				
				if (!(fieldId.value == "ES_PATIENT_GENDER") &&  (genderTrFlag)){
					
					htmlHeader = htmlHeader + "</tr>";					
					htmlHeader = htmlHeader + "</tbody>";					
					htmlHeader = htmlHeader + "</table>";					
					htmlHeader = htmlHeader + "</td>";					
					htmlHeader = htmlHeader + "</tr>";									
					genderTrFlag = false;
					
				}
				
				if (((fieldId.value == "ES_PATIENT_DOB") || (fieldId.value == "ES_PATIENT_AGE")) && !(dobTrFlag)){
					dobTrFlag = true;
					htmlHeader = htmlHeader + "<tr>";	
					htmlHeader = htmlHeader + "<td align='left'  valign='top'>";
					htmlHeader = htmlHeader + "<table border='0' cellpadding='0' cellspacing='0' style='width: 360px'>";
					htmlHeader = htmlHeader + "<tbody>";
					htmlHeader = htmlHeader + "<tr>";
				}
				
				if (fieldId.value == "ES_PATIENT_DOB"){
					htmlHeader = htmlHeader + "<td align='left'  valign='top'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+" </span></span></strong></span>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>dateOfBirth</span></span>";
					htmlHeader = htmlHeader + "</td>";	
				}				
				if (fieldId.value == "ES_PATIENT_AGE"){
					htmlHeader = htmlHeader + "<td align='left'  valign='top'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"</span></span></strong></span>";					
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>ageInYears Years </span></span>";
					htmlHeader = htmlHeader + "</td>";	
				}
				
				if (!(fieldId.value == "ES_PATIENT_DOB") &&  (dobTrFlag)){
					htmlHeader = htmlHeader + "</tr>";
					htmlHeader = htmlHeader + "</tbody>";					
					htmlHeader = htmlHeader + "</table>";					
					htmlHeader = htmlHeader + "</td>";					
					htmlHeader = htmlHeader + "</tr>";		
					dobTrFlag = false;
				}
				
				if (fieldId.value == "ES_ENCOUNTER_PRACTID"){
					htmlHeader = htmlHeader + "<tr>";	
					htmlHeader = htmlHeader + "<td align='left' colspan='2'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"  </span></span></strong></span>";					
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>practitionerName</span></span>";
					htmlHeader = htmlHeader + "</td>";	
					htmlHeader = htmlHeader + "</tr>";
				}	
				
				if (fieldId.value == "ES_ENCOUNTER_PAYER"){
					htmlHeader = htmlHeader + "<tr>";	
					htmlHeader = htmlHeader + "<td align='left' colspan='2'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"  </span></span></strong></span>";					
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>payerName</span></span>";
					htmlHeader = htmlHeader + "</td>";	
					htmlHeader = htmlHeader + "</tr>";
				}		
				
				
				if (!(fieldId.value == "ES_PATIENT_NAME") && !(fieldId.value == "ES_PATIENT_GENDER") && !(fieldId.value == "ES_PATIENT_BLOODGRP") &&
						!(fieldId.value == "ES_PATIENT_DOB") && !(fieldId.value == "ES_PATIENT_AGE") && !(fieldId.value == "ES_ENCOUNTER_PRACTID") &&
						!(fieldId.value == "ES_ENCOUNTER_PAYER")) 
				{
					//Patient Details Table
					if (patientTrFlag) {						
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>	";
						htmlHeader = htmlHeader + "</td>";	
						patientTrFlag = false;
					}
				}
					
				// Encounter details Table 
				if ((fieldId.value == "ES_PATIENT_ID") || (fieldId.value == "ES_ENCOUNTER_ID") || 
						(fieldId.value == "ES_ENCOUNTER_DATE") || (fieldId.value == "ES_ENCOUNTER_SPEC") || (fieldId.value == "ES_ENCOUNTER_LOC"))
				{
					if (!(encounterTrFlag)) {						
						htmlHeader = htmlHeader + "<td style='border-bottom:2px solid green' valign='top'>";	
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<table align='right' border='0' cellpadding='3' cellspacing='3' style='width: 300px'>";
						htmlHeader = htmlHeader + "	<tbody>";
						encounterTrFlag = true;
					}
				}
				
				if (fieldId.value == "ES_PATIENT_ID"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>patientid</span></span>";
					htmlHeader = htmlHeader + "</td>";									
					htmlHeader = htmlHeader + "</tr>";
				}
				
				if (fieldId.value == "ES_ENCOUNTER_ID"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>encounterid</span></span>";
					htmlHeader = htmlHeader + "</td>";									
					htmlHeader = htmlHeader + "</tr>";
				}
				
				if (fieldId.value == "ES_ENCOUNTER_DATE"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>visitDateTime</span></span>";
					htmlHeader = htmlHeader + "</td>";									
					htmlHeader = htmlHeader + "</tr>";
				}
				
				if (fieldId.value == "ES_ENCOUNTER_SPEC"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>specialtyName</span></span>";
					htmlHeader = htmlHeader + "</td>";									
					htmlHeader = htmlHeader + "</tr>";
				}
				
				if (fieldId.value == "ES_ENCOUNTER_LOC"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td align='left'>";
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>locationName</span></span>";
					htmlHeader = htmlHeader + "</td>";									
					htmlHeader = htmlHeader + "</tr>";
				}
				
				if (!(fieldId.value == "ES_PATIENT_ID") && !(fieldId.value == "ES_ENCOUNTER_ID") && 
						!(fieldId.value == "ES_ENCOUNTER_DATE") &&  !(fieldId.value == "ES_ENCOUNTER_SPEC")	&&  
						!(fieldId.value == "ES_ENCOUNTER_LOC")) // && !(fieldId.value == "ES_ENCOUNTER_PRACTID")
				{
					//Encounter Details Table
					if (encounterTrFlag) {						
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>	";
						htmlHeader = htmlHeader + "</td>";	
						encounterTrFlag = false;
					}
				}	
				if (!(fieldId.value == "ES_FACILITY_LOGO") && !(fieldId.value == "ES_FACILITY_NAME") && !(fieldId.value == "ES_FACILITY_ADD") && !(fieldId.value == "ES_FACILITY_CONTACT1") &&  
						!(fieldId.value == "ES_FACILITY_CONTACT2") && !(fieldId.value == "ES_FACILITY_CONTACT3") && !(fieldId.value == "ES_FACILITY_CONTACT4") &&
						!(fieldId.value == "ES_FACILITY_FAX") && !(fieldId.value == "ES_FACILITY_EMAIL") && !(fieldId.value == "ES_FACILITY_WEB") &&
						!(fieldId.value == "ES_PATIENT_NAME") && !(fieldId.value == "ES_PATIENT_GENDER") && !(fieldId.value == "ES_PATIENT_BLOODGRP") && 
						!(fieldId.value == "ES_PATIENT_DOB") && !(fieldId.value == "ES_PATIENT_AGE") && !(fieldId.value == "ES_ENCOUNTER_PRACTID") &&
						!(fieldId.value == "ES_ENCOUNTER_PAYER") && 
						!(fieldId.value == "ES_PATIENT_ID") && !(fieldId.value == "ES_ENCOUNTER_ID") && !(fieldId.value == "ES_ENCOUNTER_DATE") && 
						!(fieldId.value == "ES_ENCOUNTER_SPEC") && !(fieldId.value == "ES_ENCOUNTER_LOC")) 
				{
					if (headerTrFlag){
						htmlHeader = htmlHeader + "</tr>";
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>";		
						htmlHeader = htmlHeader + "</th></tr>";
						headerTrFlag = false;
					}
				}
				//Header Table row
				if ((fieldId.value == "ES_SPECIMEN_NO") || (fieldId.value == "ES_SPECIMEN_TYPE") || (fieldId.value == "ES_ORDER_NO") || 
						(fieldId.value == "ES_ORDER_DATE") || (fieldId.value == "ES_COLLECTED_DATE") || (fieldId.value == "ES_REGISTERED_DATE") || 
						(fieldId.value == "ES_AUTH_BY") || (fieldId.value == "ES_AUTH_DATE") || (fieldId.value == "ES_PRINTED_DATE")) 
				{					
					if (!(orderFlag)){
						htmlHeader = htmlHeader + "<tr><th>";
						htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='3' cellspacing='3' style='border-bottom:1px solid green'>";
						htmlHeader = htmlHeader + "<tbody>";						
						orderFlag = true;
					}
					if (!(orderTrFlag)){
						htmlHeader = htmlHeader + "<tr>";
						orderTrFlag = true;
					} 
					orderCount = orderCount + 1;
				}
				
				if ((fieldId.value == "ES_SPECIMEN_NO") || (fieldId.value == "ES_SPECIMEN_TYPE") || (fieldId.value == "ES_ORDER_NO") || 
						(fieldId.value == "ES_ORDER_DATE") || (fieldId.value == "ES_COLLECTED_DATE") || (fieldId.value == "ES_REGISTERED_DATE") || 
						(fieldId.value == "ES_AUTH_BY") || (fieldId.value == "ES_AUTH_DATE") || (fieldId.value == "ES_PRINTED_DATE")) 
				{	
					if (orderCount%3 == 1){
						htmlHeader = htmlHeader + "<td valign='left' align='left' width='340px'>";
					}
					if (orderCount%3 == 2){
						htmlHeader = htmlHeader + "<td valign='left' align='left' width='360px'>";
					}
					if (orderCount%3 == 0){
						htmlHeader = htmlHeader + "<td valign='left' align='left' width='300px'>";
					}
					
					if (fieldId.value == "ES_SPECIMEN_NO"){
						
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specimenNo</span></span>";
						htmlHeader = htmlHeader + "</td>";						
					}
					
					if (fieldId.value == "ES_SPECIMEN_TYPE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specimenType</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}
					
					if (fieldId.value == "ES_ORDER_NO"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>orderNo</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_ORDER_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>orderDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_COLLECTED_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>collectedDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_REGISTERED_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>registeredDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_AUTH_BY"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>authorisedBy</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_AUTH_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>authorisedDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_PRINTED_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>printedDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
						
					}	
					if ((orderCount%3 == 0) && (orderTrFlag)){
						htmlHeader = htmlHeader + "</tr>";
						orderTrFlag = false;
					} 
				}				
			}
		}		
	}	
	//Encounter Details Table
	if (encounterTrFlag) {						
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>	";
		htmlHeader = htmlHeader + "</td>";	
		encounterTrFlag = false;
	}
	if (headerTrFlag){
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";		
		htmlHeader = htmlHeader + "</th></tr>";
		headerTrFlag = false;
	}
	if (orderFlag){
		if (orderTrFlag){
			htmlHeader = htmlHeader + "</tr>";
			orderTrFlag = false;
		}
		
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";		
		htmlHeader = htmlHeader + "</th></tr>";
		orderFlag = false;
	}
	
	htmlHeader = htmlHeader + "<tr><th>";					
	htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'> ";
	htmlHeader = htmlHeader + "<tbody>";
	htmlHeader = htmlHeader + " <tr>";
	htmlHeader = htmlHeader + " <td align='center'>";		
	htmlHeader = htmlHeader + " <span style='font-family: verdana, geneva, sans-serif; color: red; font-size: 14pt; font-weight: bold;'>v_summ_desc </span>	";
	htmlHeader = htmlHeader + " </td>";
	htmlHeader = htmlHeader + " </tr>";
	htmlHeader = htmlHeader + " </tbody>";
	htmlHeader = htmlHeader + "</table>";
	htmlHeader = htmlHeader + "</th></tr>";

	if (applyFlag == 0 ){
		colorIndicatefieldflag = eval("document.SummLayoutConfigForm.es_colors_indicate");
	}
	else
	{
		colorIndicatefieldflag = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_colors_indicate");
	}
	
	
	if (colorIndicatefieldflag.checked == true)
	{
		htmlHeader = htmlHeader + "<tr><th>"; 
		htmlHeader = htmlHeader + "<table align='right' border='0' cellpadding='1' cellspacing='1' style='width: 540px'>";
		htmlHeader = htmlHeader + "<tbody>";					
		htmlHeader = htmlHeader + "	<tr>";
		htmlHeader = htmlHeader + "<td width='340px' valign='center'><span style='color: #808080'><span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>Colors Indicate:&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "<td width='200px' valign='center'>";
		htmlHeader = htmlHeader + "<table align='right' border='0' cellpadding='1' cellspacing='1' style='width: 200px'>";
		htmlHeader = htmlHeader + "<tbody>";
		htmlHeader = htmlHeader + "<tr>";
		htmlHeader = htmlHeader + "<td  width='65px' valign='bottom'><span style='color: #808080'><span style='font-size: 12pt'><span style='font-family: verdana, geneva, sans-serif'>&nbsp;&nbsp;&nbsp;Optimal&nbsp;&nbsp;&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "<td  width='65px' valign='bottom'><span style='color: #808080'><span style='font-size: 12pt'><span style='font-family: verdana, geneva, sans-serif'>&nbsp;&nbsp;&nbsp;Borderline&nbsp;&nbsp;&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "<td  width='65px' valign='bottom'><span style='color: #808080'><span style='font-size: 12pt'><span style='font-family: verdana, geneva, sans-serif'>&nbsp;&nbsp;&nbsp;Abnormal&nbsp;&nbsp;&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "<tr>";
		htmlHeader = htmlHeader + "<td width='65px' style='border-top:3px solid green' valign='top'>&nbsp;</td>";
		htmlHeader = htmlHeader + "<td width='65px' style='border-top:3px solid yellow' valign='top'>&nbsp;</td>";
		htmlHeader = htmlHeader + "<td width='65px' style='border-top:3px solid red' valign='top'>&nbsp;</td>";
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";
		htmlHeader = htmlHeader + "</td>";
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";			
		htmlHeader = htmlHeader + "</th></tr>"; 
	}
	
	//htmlHeader = htmlHeader + "</thead>";
	//htmlHeader = htmlHeader + "</table>";
		
	return htmlHeader;
}

function getHorizontalHeader(applyFlag){
	var htmlHeader = "";
	var index = 0;
	var headerTrFlag = false;
	var facilityTrFlag = false;
	var facilityAddFlag = false;
	
	var patientFlag = false;
	var patientTrFlag = false;
	
	var patientCount = 0;
	
	var contact1TrFlag = false;
	var contact3TrFlag = false;
	var faxTrFlag = false;

	var encounterTrFlag = false;
	var genderTrFlag = false;
	var dobTrFlag = false;
	
	var orderFlag = false;
	var orderTrFlag = false;
	var orderCount = 0;
	
	var arrayLength = 0;
	var fieldId = "";
	var fieldflag = "";
	var fieldOrient = "";
	var fieldLbl = "";	
	var colorIndicatefieldflag = "";
	
	var tdWidth = "";
	
	// Main Table
	//htmlHeader = "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'>"; 
	//htmlHeader = htmlHeader + "<thead>";	
	
	if (applyFlag == 0 ){
		arrayLength = document.SummLayoutConfigForm.fieldsCount.value;
	}
	else
	{
		arrayLength = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.fieldsCount.value;
	}
	
	for( index= 0 ; index< parseInt(arrayLength);index++)
	{	
		if (applyFlag == 0 ){
			fieldId 	= eval("document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		else
		{
			fieldId 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		
		var radios = fieldOrient;
		var orientValue = 0;
		
		if (fieldflag.checked == true)
		{
			for(var i = 0; i < radios.length; i++){
			    if(radios[i].checked){
			    	orientValue = radios[i].value;
			    }
			}			
			
			if (orientValue == 0)
			{
				if (fieldId.value == "ES_FACILITY_ADD"){
					addressHeadFlag = true;
				}
			}
		}
	}

	for( index= 0 ; index< parseInt(arrayLength);index++)
	{	

		if (applyFlag == 0 ){
			fieldId 	= eval("document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		else
		{
			fieldId 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		
		
		var radios = fieldOrient;
		var orientValue = 0;
		
		if (fieldflag.checked == true)
		{
			for(var i = 0; i < radios.length; i++){
			    if(radios[i].checked){
			    	orientValue = radios[i].value;
			    }
			}			
			
			if (orientValue == 0)
			{				
				//Header Table row
				if ((fieldId.value == "ES_FACILITY_LOGO") || (fieldId.value == "ES_FACILITY_NAME") || (fieldId.value == "ES_FACILITY_ADD") || (fieldId.value == "ES_FACILITY_CONTACT1") || 
						(fieldId.value == "ES_FACILITY_CONTACT2") || (fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4") ||
						(fieldId.value == "ES_FACILITY_FAX") || (fieldId.value == "ES_FACILITY_EMAIL") || (fieldId.value == "ES_FACILITY_WEB")) 
				{					
					if (!(headerTrFlag)){
						htmlHeader = htmlHeader + "<tr><th>";
						htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'>";
						htmlHeader = htmlHeader + "<tbody>";
						htmlHeader = htmlHeader + "<tr>";
						headerTrFlag = true;
					}
				}
				
				//Facility Details Table
				if ((fieldId.value == "ES_FACILITY_LOGO")) 
				{
					
					if (!(facilityTrFlag)) {						
						htmlHeader = htmlHeader + "<td style='border-bottom:2px solid green' width='40%' valign='top'>";							
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 360px'>";
						htmlHeader = htmlHeader + "	<tbody>";
						facilityTrFlag = true;
					}
				}
				
				if (fieldId.value == "ES_FACILITY_LOGO"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td>";							
					htmlHeader = htmlHeader + "<table border='0' cellpadding='1' cellspacing='1' style='width: 300px'>";
					htmlHeader = htmlHeader + "	<tbody>";
					htmlHeader = htmlHeader + "	<tr>";
					htmlHeader = htmlHeader + "	<td align='center'>";											
					htmlHeader = htmlHeader + "	<img src='../../eCA/images/facilityImageName' title='Logo' width='100px' height='100px'>";
					htmlHeader = htmlHeader + "	</td>";									
					htmlHeader = htmlHeader + "	</tr>";
					htmlHeader = htmlHeader + "	</tbody>";
					htmlHeader = htmlHeader + "</table>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					
				}		
				
				if (!(fieldId.value == "ES_FACILITY_LOGO")) 
				{
					if (facilityTrFlag) {
						htmlHeader = htmlHeader + "</tbody>";							
						htmlHeader = htmlHeader + "</table>";
						htmlHeader = htmlHeader + "</td>";
						facilityTrFlag = false;
					}
				}
				if ((fieldId.value == "ES_FACILITY_NAME") || (fieldId.value == "ES_FACILITY_ADD") || (fieldId.value == "ES_FACILITY_CONTACT1") || 
						(fieldId.value == "ES_FACILITY_CONTACT2") || (fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4") ||
						(fieldId.value == "ES_FACILITY_FAX") || (fieldId.value == "ES_FACILITY_EMAIL") || (fieldId.value == "ES_FACILITY_WEB"))
				{
					if (!(facilityAddFlag)){
						htmlHeader = htmlHeader + "<td style='border-bottom:2px solid green' width='60%' valign='top'>";							
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 540px'>";
						htmlHeader = htmlHeader + "	<tbody>";
						facilityAddFlag = true;
					}
				}
				if (fieldId.value == "ES_FACILITY_NAME"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";							
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							"facilityName</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";						
				}
				
				if (fieldId.value == "ES_FACILITY_ADD"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";							
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							"address</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";						
				}	
				
				if (fieldId.value == "ES_FACILITY_CONTACT1"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"telephone1 &nbsp;&nbsp;&nbsp;</span></span></strong></span>";
					contact1TrFlag = true;
				}				
				if (fieldId.value == "ES_FACILITY_CONTACT2"){	
					if (!(contact1TrFlag)){
						htmlHeader = htmlHeader + "<tr>";
						htmlHeader = htmlHeader + "<td valign='top' align='right'>";
					}
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
							""+fieldLbl.value+"telephone2</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					contact1TrFlag = false;
				}
				
				
				if (!(fieldId.value == "ES_FACILITY_CONTACT1") && !(fieldId.value == "ES_FACILITY_CONTACT2")){
					if (contact1TrFlag){
						htmlHeader = htmlHeader + "</td>";
						htmlHeader = htmlHeader + "</tr>";
						contact1TrFlag = false;
					}
				}
				
				if (fieldId.value == "ES_FACILITY_CONTACT3"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"telephone3 &nbsp;&nbsp;&nbsp;</span></span></strong></span>";	
					contact3TrFlag = true;
					//htmlHeader = htmlHeader + "</td>";
					//htmlHeader = htmlHeader + "</tr>";
				}
				if (fieldId.value == "ES_FACILITY_CONTACT4"){	
					if (!(contact3TrFlag)){
						htmlHeader = htmlHeader + "<tr>";
						htmlHeader = htmlHeader + "<td valign='top' align='right'>";
					}
					htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
							""+fieldLbl.value+"telephone4</span></span></strong></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					contact3TrFlag = false;
				}
				if (!(fieldId.value == "ES_FACILITY_CONTACT3") && !(fieldId.value == "ES_FACILITY_CONTACT4")){
					if (contact3TrFlag){
						htmlHeader = htmlHeader + "</td>";
						htmlHeader = htmlHeader + "</tr>";
						contact3TrFlag = false;
					}
				}
				
				if (fieldId.value == "ES_FACILITY_FAX"){	
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";
					htmlHeader = htmlHeader + "<span style='font-size: 9pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
							""+fieldLbl.value+"fax &nbsp;&nbsp;&nbsp;</span></span></strong></span>";
					faxTrFlag = true;
					//htmlHeader = htmlHeader + "</td>";
					//htmlHeader = htmlHeader + "</tr>";
				}
				if (fieldId.value == "ES_FACILITY_EMAIL"){	
					if (!(faxTrFlag)){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";
					}
					htmlHeader = htmlHeader + "<span style='font-size: 9pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
							""+fieldLbl.value+"</span></span></strong></span>";		
					htmlHeader = htmlHeader + "<span style='font-size: 9pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: #0000FF'>" +
					"emailId</span></span></strong></span>";		
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";
					faxTrFlag = false;
				}
				if (!(fieldId.value == "ES_FACILITY_FAX") && !(fieldId.value == "ES_FACILITY_EMAIL")){
					if (faxTrFlag){
						htmlHeader = htmlHeader + "</td>";
						htmlHeader = htmlHeader + "</tr>";
						faxTrFlag = false;
					}
				}
				if (fieldId.value == "ES_FACILITY_WEB"){
					htmlHeader = htmlHeader + "<tr>";
					htmlHeader = htmlHeader + "<td valign='top' align='right'>";		
					htmlHeader = htmlHeader + "<span style='font-size: 9pt'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
					""+fieldLbl.value+"</span></span></strong></span>";	
					htmlHeader = htmlHeader + "<span style='font-size: 9pt'><span style='color: #ff0000'><strong><span style='font-family: verdana, geneva, sans-serif'>" +
							"website</span></strong></span></span>";								
					htmlHeader = htmlHeader + "</td>";
					htmlHeader = htmlHeader + "</tr>";						
				}	
				
				
				if (!(fieldId.value == "ES_FACILITY_NAME") && !(fieldId.value == "ES_FACILITY_ADD") && !(fieldId.value == "ES_FACILITY_CONTACT1") &&  
						!(fieldId.value == "ES_FACILITY_CONTACT2") && !(fieldId.value == "ES_FACILITY_CONTACT3") && !(fieldId.value == "ES_FACILITY_CONTACT4") &&
						!(fieldId.value == "ES_FACILITY_FAX") && !(fieldId.value == "ES_FACILITY_EMAIL") && !(fieldId.value == "ES_FACILITY_WEB")) 
				{
					if (facilityAddFlag) {																	
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>	";
						htmlHeader = htmlHeader + "</td>";	
						facilityAddFlag = false;
					}
				}
				
				if (!(fieldId.value == "ES_FACILITY_LOGO") && !(fieldId.value == "ES_FACILITY_NAME") && !(fieldId.value == "ES_FACILITY_ADD") && 
						!(fieldId.value == "ES_FACILITY_CONTACT1") && !(fieldId.value == "ES_FACILITY_CONTACT2") && !(fieldId.value == "ES_FACILITY_CONTACT3") && 
						!(fieldId.value == "ES_FACILITY_CONTACT4") && !(fieldId.value == "ES_FACILITY_FAX") && !(fieldId.value == "ES_FACILITY_EMAIL") && 
						!(fieldId.value == "ES_FACILITY_WEB")) 
				{
					if (headerTrFlag){						
						htmlHeader = htmlHeader + "</tr>";
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>";
						htmlHeader = htmlHeader + "</th></tr>";
						headerTrFlag = false;
					}
				}

				// Patient details Table 
				if ((fieldId.value == "ES_PATIENT_NAME") || (fieldId.value == "ES_PATIENT_GENDER") || (fieldId.value == "ES_PATIENT_BLOODGRP") ||
						(fieldId.value == "ES_PATIENT_DOB") || (fieldId.value == "ES_PATIENT_AGE")  || (fieldId.value == "ES_ENCOUNTER_PRACTID") ||
						(fieldId.value == "ES_ENCOUNTER_PAYER") ||
						(fieldId.value == "ES_PATIENT_ID") || (fieldId.value == "ES_ENCOUNTER_ID") || (fieldId.value == "ES_ENCOUNTER_DATE") || 
						(fieldId.value == "ES_ENCOUNTER_SPEC") || (fieldId.value == "ES_ENCOUNTER_LOC") ) 
				{
					if (!(patientFlag)) {						
						htmlHeader = htmlHeader + "<tr><th>";
						htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='1' cellspacing='1' style='border-bottom:1px solid green' style='width: 900px'>";
						htmlHeader = htmlHeader + "<tbody>";
						patientFlag = true;						
					}
					if (!(patientTrFlag)){
						htmlHeader = htmlHeader + "<tr>";					
						patientTrFlag = true;
					}
					patientCount = patientCount + 1;
					
				}
				if ((fieldId.value == "ES_PATIENT_NAME") || (fieldId.value == "ES_PATIENT_GENDER") || (fieldId.value == "ES_PATIENT_BLOODGRP") ||
						(fieldId.value == "ES_PATIENT_DOB") || (fieldId.value == "ES_PATIENT_AGE")  || (fieldId.value == "ES_ENCOUNTER_PRACTID") ||
						(fieldId.value == "ES_ENCOUNTER_PAYER") ||
						(fieldId.value == "ES_PATIENT_ID") || (fieldId.value == "ES_ENCOUNTER_ID") || (fieldId.value == "ES_ENCOUNTER_DATE") || 
						(fieldId.value == "ES_ENCOUNTER_SPEC") || (fieldId.value == "ES_ENCOUNTER_LOC") )  
				{	
					if (fieldId.value == "ES_ENCOUNTER_PRACTID"){
						tdWidth = "width='320px'";
					}
					else if (fieldId.value == "ES_ENCOUNTER_PAYER")
					{
						tdWidth = "width='300px'";
					}	
					else 
					{
						tdWidth = "width='280px'";
					}
					if (patientCount%3 == 1){						
						htmlHeader = htmlHeader + "<td valign='left' align='left' "+tdWidth+">";
					}
					if (patientCount%3 == 2){						
						htmlHeader = htmlHeader + "<td valign='left' align='left' "+tdWidth+">";
					}
					if (patientCount%3 == 0){
						htmlHeader = htmlHeader + "<td valign='left' align='left' "+tdWidth+">";
					}				
				
					if (fieldId.value == "ES_PATIENT_NAME"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>patientName</span></span>";
						htmlHeader = htmlHeader + "</td>";									
					}
					
					if (fieldId.value == "ES_PATIENT_GENDER"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>gender</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}		
					
					if (fieldId.value == "ES_PATIENT_BLOODGRP"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
										""+fieldLbl.value+" </span></span></strong></span>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>bloodGroup</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}
					
					if (fieldId.value == "ES_PATIENT_DOB"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+" </span></span></strong></span>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>dateOfBirth</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}	
					
					if (fieldId.value == "ES_PATIENT_AGE"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"</span></span></strong></span>";					
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>ageInYears Years </span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}
					
					if (fieldId.value == "ES_ENCOUNTER_PRACTID"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"  </span></span></strong></span>";					
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>practitionerName</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}
					
					if (fieldId.value == "ES_ENCOUNTER_PAYER"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"  </span></span></strong></span>";					
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>payerName</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}	
					
					if (fieldId.value == "ES_PATIENT_ID"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>patientid</span></span>";
						htmlHeader = htmlHeader + "</td>";									
					}
					
					if (fieldId.value == "ES_ENCOUNTER_ID"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>encounterid</span></span>";
						htmlHeader = htmlHeader + "</td>";									
					}
					
					if (fieldId.value == "ES_ENCOUNTER_DATE"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>visitDateTime</span></span>";
						htmlHeader = htmlHeader + "</td>";									
					}
					
					if (fieldId.value == "ES_ENCOUNTER_SPEC"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specialtyName</span></span>";
						htmlHeader = htmlHeader + "</td>";									
					}
					
					if (fieldId.value == "ES_ENCOUNTER_LOC"){
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>locationName</span></span>";
						htmlHeader = htmlHeader + "</td>";									
					}
					
					if ((patientCount%3 == 0) && (patientTrFlag)){
						htmlHeader = htmlHeader + "</tr>";
						patientTrFlag = false;
					} 
				}				
				
				if (!(fieldId.value == "ES_PATIENT_NAME") && !(fieldId.value == "ES_PATIENT_GENDER") && !(fieldId.value == "ES_PATIENT_BLOODGRP") &&
						!(fieldId.value == "ES_PATIENT_DOB") && !(fieldId.value == "ES_PATIENT_AGE") && !(fieldId.value == "ES_ENCOUNTER_PRACTID") &&
						!(fieldId.value == "ES_ENCOUNTER_PAYER") && 
						!(fieldId.value == "ES_PATIENT_ID") && !(fieldId.value == "ES_ENCOUNTER_ID") && !(fieldId.value == "ES_ENCOUNTER_DATE") && 
						!(fieldId.value == "ES_ENCOUNTER_SPEC") && !(fieldId.value == "ES_ENCOUNTER_LOC") ) 
				{
					if (patientFlag){
						if (patientTrFlag){
							htmlHeader = htmlHeader + "</tr>";
							patientTrFlag = false;
						}
						
						htmlHeader = htmlHeader + "</tbody>";
						htmlHeader = htmlHeader + "</table>";		
						htmlHeader = htmlHeader + "</th></tr>";
						patientFlag = false;
					}
				}
				//Header Table row
				if ((fieldId.value == "ES_SPECIMEN_NO") || (fieldId.value == "ES_SPECIMEN_TYPE") || (fieldId.value == "ES_ORDER_NO") || 
						(fieldId.value == "ES_ORDER_DATE") || (fieldId.value == "ES_COLLECTED_DATE") || (fieldId.value == "ES_REGISTERED_DATE") || 
						(fieldId.value == "ES_AUTH_BY") || (fieldId.value == "ES_AUTH_DATE") || (fieldId.value == "ES_PRINTED_DATE")) 
				{					
					if (!(orderFlag)){
						htmlHeader = htmlHeader + "<tr><th>";
						htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='1' cellspacing='1' style='border-bottom:1px solid green' style='width: 900px'>";
						htmlHeader = htmlHeader + "<tbody>";						
						orderFlag = true;
					}
					if (!(orderTrFlag)){
						htmlHeader = htmlHeader + "<tr>";
						orderTrFlag = true;
					} 
					orderCount = orderCount + 1;
				}
				
				if ((fieldId.value == "ES_SPECIMEN_NO") || (fieldId.value == "ES_SPECIMEN_TYPE") || (fieldId.value == "ES_ORDER_NO") || 
						(fieldId.value == "ES_ORDER_DATE") || (fieldId.value == "ES_COLLECTED_DATE") || (fieldId.value == "ES_REGISTERED_DATE") || 
						(fieldId.value == "ES_AUTH_BY") || (fieldId.value == "ES_AUTH_DATE") || (fieldId.value == "ES_PRINTED_DATE")) 
				{	
					if (orderCount%3 == 1){
						htmlHeader = htmlHeader + "<td valign='left' align='left' width='300px'>";
					}
					if (orderCount%3 == 2){
						htmlHeader = htmlHeader + "<td valign='left' align='left' width='300px'>";
					}
					if (orderCount%3 == 0){
						htmlHeader = htmlHeader + "<td valign='left' align='left' width='300px'>";
					}
					
					if (fieldId.value == "ES_SPECIMEN_NO"){
						
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specimenNo</span></span>";
						htmlHeader = htmlHeader + "</td>";						
					}
					
					if (fieldId.value == "ES_SPECIMEN_TYPE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specimenType</span></span>";
						htmlHeader = htmlHeader + "</td>";	
					}
					
					if (fieldId.value == "ES_ORDER_NO"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>orderNo</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_ORDER_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>orderDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_COLLECTED_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>collectedDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_REGISTERED_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>registeredDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_AUTH_BY"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>authorisedBy</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_AUTH_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>authorisedDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
					}
					
					if (fieldId.value == "ES_PRINTED_DATE"){
						//htmlHeader = htmlHeader + "<td valign='center'>";
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlHeader = htmlHeader + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>printedDate</span></span>";
						htmlHeader = htmlHeader + "</td>";
						
					}	
					if ((orderCount%3 == 0) && (orderTrFlag)){
						htmlHeader = htmlHeader + "</tr>";
						orderTrFlag = false;
					} 
				}								
			}
		}		
	}	
	//Encounter Details Table

	if (contact1TrFlag){
		htmlHeader = htmlHeader + "</td>";
		htmlHeader = htmlHeader + "</tr>";
		contact1TrFlag = false;
	}
	if (contact3TrFlag){
		htmlHeader = htmlHeader + "</td>";
		htmlHeader = htmlHeader + "</tr>";
		contact3TrFlag = false;
	}
	if (faxTrFlag){
		htmlHeader = htmlHeader + "</td>";
		htmlHeader = htmlHeader + "</tr>";
		faxTrFlag = false;
	}

	if (facilityAddFlag) {								
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>	";
		htmlHeader = htmlHeader + "</td>";	
		facilityAddFlag = false;
	}
	if (headerTrFlag){
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";		
		htmlHeader = htmlHeader + "</th></tr>";
		headerTrFlag = false;
	}
	if (patientFlag){
		if (patientTrFlag){
			htmlHeader = htmlHeader + "</tr>";
			patientTrFlag = false;
		}
		
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";		
		htmlHeader = htmlHeader + "</th></tr>";
		patientFlag = false;
	}
	if (orderFlag){
		if (orderTrFlag){
			htmlHeader = htmlHeader + "</tr>";
			orderTrFlag = false;
		}
		
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";		
		htmlHeader = htmlHeader + "</th></tr>";
		orderFlag = false;
	}
	
	htmlHeader = htmlHeader + "<tr><th>";					
	htmlHeader = htmlHeader + "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'> ";
	htmlHeader = htmlHeader + "<tbody>";
	htmlHeader = htmlHeader + " <tr>";
	htmlHeader = htmlHeader + " <td align='center'>";		
	htmlHeader = htmlHeader + " <span style='font-family: verdana, geneva, sans-serif; color: red; font-size: 14pt; font-weight: bold;'>v_summ_desc </span>	";
	htmlHeader = htmlHeader + " </td>";
	htmlHeader = htmlHeader + " </tr>";
	htmlHeader = htmlHeader + " </tbody>";
	htmlHeader = htmlHeader + "</table>";
	htmlHeader = htmlHeader + "</th></tr>";

	if (applyFlag == 0 ){
		colorIndicatefieldflag = eval("document.SummLayoutConfigForm.es_colors_indicate");
	}
	else
	{
		colorIndicatefieldflag = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_colors_indicate");
	}
	
	
	if (colorIndicatefieldflag.checked == true)
	{
		htmlHeader = htmlHeader + "<tr><th>"; 
		htmlHeader = htmlHeader + "<table align='right' border='0' cellpadding='1' cellspacing='1' style='width: 540px'>";
		htmlHeader = htmlHeader + "<tbody>";					
		htmlHeader = htmlHeader + "	<tr>";
		htmlHeader = htmlHeader + "<td width='340px' valign='center'><span style='color: #808080'><span style='font-size: 11pt'><span style='font-family: verdana, geneva, sans-serif'>Colors Indicate:&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "<td width='200px' valign='center'>";
		htmlHeader = htmlHeader + "<table align='right' border='0' cellpadding='1' cellspacing='1' style='width: 200px'>";
		htmlHeader = htmlHeader + "<tbody>";
		htmlHeader = htmlHeader + "<tr>";
		htmlHeader = htmlHeader + "<td  width='65px' valign='bottom'><span style='color: #808080'><span style='font-size: 12pt'><span style='font-family: verdana, geneva, sans-serif'>&nbsp;&nbsp;&nbsp;Optimal&nbsp;&nbsp;&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "<td  width='65px' valign='bottom'><span style='color: #808080'><span style='font-size: 12pt'><span style='font-family: verdana, geneva, sans-serif'>&nbsp;&nbsp;&nbsp;Borderline&nbsp;&nbsp;&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "<td  width='65px' valign='bottom'><span style='color: #808080'><span style='font-size: 12pt'><span style='font-family: verdana, geneva, sans-serif'>&nbsp;&nbsp;&nbsp;Abnormal&nbsp;&nbsp;&nbsp;</span></span></span></td>";
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "<tr>";
		htmlHeader = htmlHeader + "<td width='65px' style='border-top:3px solid green' valign='top'>&nbsp;</td>";
		htmlHeader = htmlHeader + "<td width='65px' style='border-top:3px solid yellow' valign='top'>&nbsp;</td>";
		htmlHeader = htmlHeader + "<td width='65px' style='border-top:3px solid red' valign='top'>&nbsp;</td>";
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";
		htmlHeader = htmlHeader + "</td>";
		htmlHeader = htmlHeader + "</tr>";
		htmlHeader = htmlHeader + "</tbody>";
		htmlHeader = htmlHeader + "</table>";			
		htmlHeader = htmlHeader + "</th></tr>"; 
	}
	
	//htmlHeader = htmlHeader + "</thead>";
	//htmlHeader = htmlHeader + "</table>";
		
	return htmlHeader;
}

function showFooterHtml(){
	
	var fieldChangeFlag = false;
	var summary_code = document.SummLayoutConfigForm.es_summ_code.value;
	
	var footerHtml = "";	
	
	footerHtml = getFooterHtml(0);	

	fieldChangeFlag = getFormElements();
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.changeFlag.value = fieldChangeFlag;	
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.headerValue.value = "update";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.footerValue.value = footerHtml;
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.mode.value = "update";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.es_summ_code.value = summary_code;
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.method = "post";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.action ="../../servlet/eCA.EncSummLayoutServlet";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.target ="messageFrame";
	parent.parent.f_query_add_mod.BlankFrame.document.SummLayoutBlankForm.submit();	
	
	//parent.parent.f_query_add_mod.DetailsFrame.location.href='../../eCA/jsp/EncSummLayoutConfig.jsp?mode=insert&summaryCode='+summary_code;	
	
}

function getFooterHtml(applyFlag){
	var htmlFooter = "";
	var htmlOrderFooter = "";
	var htmlfacilityFooter = "";
	var index = 0;
	var facilityFlag = false;
	var facilityTrFlag = false;
	var facilityCount = 0;
	
	var orderFlag = false;
	var orderTrFlag = false;
	var orderCount = 0;
	
	var arrayLength = 0;
	var fieldId = "";
	var fieldflag = "";
	var fieldOrient = "";
	var fieldLbl = "";	
	
	var footer_sign_flag_field = "", footer_sign_1_flag_field = "", footer_sign_2_flag_field = "", footer_sign_3_flag_field = "";
	var footer_sign_1_Label_field = "", footer_sign_2_Label_field = "", footer_sign_3_Label_field = "";
	var footer_sign_1_splty_field = "", footer_sign_2_splty_field = "", footer_sign_3_splty_field = "";
	var footer_sign_posn_field = "";
	
	var footer_sign_flag = 0, footer_sign_posn = 0; 
	var footer_sign_1_label = "", footer_sign_2_label = "", footer_sign_3_label = ""; 
	var footer_sign_1_flag = 0, footer_sign_1_practid = 0, footer_sign_1_splty = 0;
	var footer_sign_2_flag = 0, footer_sign_2_practid = 0, footer_sign_2_splty = 0;
	var footer_sign_3_flag = 0, footer_sign_3_practid = 0, footer_sign_3_splty = 0;

	// Signature table
	if (applyFlag == 0 ){
		footer_sign_flag_field = eval(document.SummLayoutConfigForm.es_footer_sign_flag);
		footer_sign_posn_field = eval(document.SummLayoutConfigForm.es_footer_sign_posn);
		
		footer_sign_1_flag_field = eval(document.SummLayoutConfigForm.es_footer_sign_1_flag);
		footer_sign_1_Label_field = eval(document.SummLayoutConfigForm.es_footer_sign_1_label);
		footer_sign_1_practid =  document.SummLayoutConfigForm.es_footer_sign_1_practid.value;
		footer_sign_1_splty_field = eval(document.SummLayoutConfigForm.es_footer_sign_1_splty);
		if (footer_sign_1_splty_field.checked == true)
		{
			footer_sign_1_splty = 1;
		}
		
		footer_sign_2_flag_field = eval(document.SummLayoutConfigForm.es_footer_sign_2_flag);
		footer_sign_2_Label_field = eval(document.SummLayoutConfigForm.es_footer_sign_2_label);
		footer_sign_2_practid =  document.SummLayoutConfigForm.es_footer_sign_2_practid.value;
		footer_sign_2_splty_field = eval(document.SummLayoutConfigForm.es_footer_sign_2_splty);
		if (footer_sign_2_splty_field.checked == true)
		{
			footer_sign_2_splty = 1;
		}
		
		footer_sign_3_flag_field = eval(document.SummLayoutConfigForm.es_footer_sign_3_flag);
		footer_sign_3_Label_field = eval(document.SummLayoutConfigForm.es_footer_sign_3_label);
		footer_sign_3_practid =  document.SummLayoutConfigForm.es_footer_sign_3_practid.value;
		footer_sign_3_splty_field = eval(document.SummLayoutConfigForm.es_footer_sign_3_splty);
		if (footer_sign_3_splty_field.checked == true)
		{
			footer_sign_3_splty = 1;
		}
	}
	else
	{
		footer_sign_flag_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_flag);
		footer_sign_posn_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_posn);
		
		footer_sign_1_flag_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_flag);
		footer_sign_1_Label_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_label);
		footer_sign_1_practid =  f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_practid.value;
		footer_sign_1_splty_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_1_splty);
		if (footer_sign_1_splty_field.checked == true)
		{
			footer_sign_1_splty = 1;
		}
		
		footer_sign_2_flag_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_flag);
		footer_sign_2_Label_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_label);
		footer_sign_2_practid =  f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_practid.value;
		footer_sign_2_splty_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_2_splty);
		if (footer_sign_2_splty_field.checked == true)
		{
			footer_sign_2_splty = 1;
		}
		
		footer_sign_3_flag_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_flag);
		footer_sign_3_Label_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_label);
		footer_sign_3_practid =  f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_practid.value;
		footer_sign_3_splty_field = eval(f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_footer_sign_3_splty);
		if (footer_sign_3_splty_field.checked == true)
		{
			footer_sign_3_splty = 1;
		}
	}
	
	if (footer_sign_flag_field.checked == true)
	{
		var signRadios = footer_sign_posn_field;
		var signOrientValue = 0;
		
		for(var i = 0; i < signRadios.length; i++){
		    if(signRadios[i].checked){
		    	signOrientValue = signRadios[i].value;
		    }
		}	
		
		if (signOrientValue == 0) {
			if ((footer_sign_1_flag_field.checked == true) || (footer_sign_2_flag_field.checked == true) || (footer_sign_3_flag_field.checked == true))
			{
				htmlFooter = "<table  class='breakSignTable' align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'>"; 
				htmlFooter = htmlFooter + "<tbody>";	
				htmlFooter = htmlFooter + "<tr>";
				htmlFooter = htmlFooter + "<hr style='color:#0101DF'/>";									
				htmlFooter = htmlFooter + "</tr>";	
				htmlFooter = htmlFooter + "<tr>";
				if (footer_sign_1_flag_field.checked == true){
					
					htmlFooter = htmlFooter + "<td valign='left' align='left' width='300px'>";
					htmlFooter = htmlFooter + "<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>";
					htmlFooter = htmlFooter + "<tbody>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'>";
					htmlFooter = htmlFooter + "<u><span style='font-size: 12px'><strong>";
					htmlFooter = htmlFooter + "<span style='color: #808080'><span style='font-family: verdana, geneva, sans-serif'>"+footer_sign_1_Label_field.value+"</span></span>";
					htmlFooter = htmlFooter + "</strong></span></u>";
					htmlFooter = htmlFooter + "</td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'><br></td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'><br></td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'>";
					htmlFooter = htmlFooter + "<span style='font-size: 12px'><strong><span style='color: #808080'>";
					if (footer_sign_1_practid == 1){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>attendPractName &nbsp;&nbsp;(&nbsp; attendPractDegree &nbsp;)</span>";
					}
					if (footer_sign_1_practid == 2){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>admitPractName &nbsp;&nbsp;(&nbsp; admitPractDegree &nbsp;)</span>";
					}
					if (footer_sign_1_practid == 3){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>authPractName &nbsp;&nbsp;(&nbsp; authPractDegree &nbsp;)</span>";
					}
					htmlFooter = htmlFooter + "</span></strong></span>";
					htmlFooter = htmlFooter + "</td>";									
					htmlFooter = htmlFooter + "</tr>";

					if (footer_sign_1_splty == 1){							
						htmlFooter = htmlFooter + "<tr>";
						htmlFooter = htmlFooter + "<td class='label'>";
						htmlFooter = htmlFooter + "<span style='font-size: 12px'><strong><span style='color: #808080'>";
						if (footer_sign_1_practid == 1){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>attendPractSplty &nbsp;</span>";
						}
						if (footer_sign_1_practid == 2){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>admitPractSplty &nbsp;</span>";
						}
						if (footer_sign_1_practid == 3){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>authPractSplty &nbsp;</span>";
						}
						
						htmlFooter = htmlFooter + "</span></strong></span>";
						htmlFooter = htmlFooter + "</td>";									
						htmlFooter = htmlFooter + "</tr>";
					}
					htmlFooter = htmlFooter + "</tbody>";
					htmlFooter = htmlFooter + "</table>";
					htmlFooter = htmlFooter + "</td>";
					
				}
				
				if (footer_sign_2_flag_field.checked == true){					
					htmlFooter = htmlFooter + "<td valign='left' align='left' width='300px'>";
					htmlFooter = htmlFooter + "<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>";
					htmlFooter = htmlFooter + "<tbody>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'>";
					htmlFooter = htmlFooter + "<u><span style='font-size: 12px'><strong>";
					htmlFooter = htmlFooter + "<span style='color: #808080'><span style='font-family: verdana, geneva, sans-serif'>"+footer_sign_2_Label_field.value+"</span></span>";
					htmlFooter = htmlFooter + "</strong></span></u>";
					htmlFooter = htmlFooter + "</td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'><br></td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'><br></td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'>";
					htmlFooter = htmlFooter + "<span style='font-size: 12px'><strong><span style='color: #808080'>";
					if (footer_sign_2_practid == 1){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>attendPractName &nbsp;&nbsp;(&nbsp; attendPractDegree &nbsp;)</span>";
					}
					if (footer_sign_2_practid == 2){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>admitPractName &nbsp;&nbsp;(&nbsp; admitPractDegree &nbsp;)</span>";
					}
					if (footer_sign_2_practid == 3){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>authPractName &nbsp;&nbsp;(&nbsp; authPractDegree &nbsp;)</span>";
					}
					htmlFooter = htmlFooter + "</span></strong></span>";
					htmlFooter = htmlFooter + "</td>";									
					htmlFooter = htmlFooter + "</tr>";
					if (footer_sign_2_splty == 1){							
						htmlFooter = htmlFooter + "<tr>";
						htmlFooter = htmlFooter + "<td class='label'>";
						htmlFooter = htmlFooter + "<span style='font-size: 12px'><strong><span style='color: #808080'>";
						
						if (footer_sign_2_practid == 1){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>attendPractSplty &nbsp;</span>";
						}
						if (footer_sign_2_practid == 2){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>admitPractSplty &nbsp;</span>";
						}
						if (footer_sign_2_practid == 3){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>authPractSplty &nbsp;</span>";
						}
						
						htmlFooter = htmlFooter + "</span></strong></span>";
						htmlFooter = htmlFooter + "</td>";									
						htmlFooter = htmlFooter + "</tr>";
					}
					htmlFooter = htmlFooter + "</tbody>";
					htmlFooter = htmlFooter + "</table>";
					htmlFooter = htmlFooter + "</td>";
					
				}

				if (footer_sign_3_flag_field.checked == true){
					
					htmlFooter = htmlFooter + "<td valign='left' align='left' width='300px'>";
					htmlFooter = htmlFooter + "<table align='left' border='0' cellpadding='1' cellspacing='1' style='width: 340px'>";
					htmlFooter = htmlFooter + "<tbody>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'>";
					htmlFooter = htmlFooter + "<u><span style='font-size: 12px'><strong>";
					htmlFooter = htmlFooter + "<span style='color: #808080'><span style='font-family: verdana, geneva, sans-serif'>"+footer_sign_3_Label_field.value+"</span></span>";
					htmlFooter = htmlFooter + "</strong></span></u>";
					htmlFooter = htmlFooter + "</td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'><br></td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'><br></td>";									
					htmlFooter = htmlFooter + "</tr>";
					htmlFooter = htmlFooter + "<tr>";
					htmlFooter = htmlFooter + "<td class='label'>";
					htmlFooter = htmlFooter + "<span style='font-size: 12px'><strong><span style='color: #808080'>";
					if (footer_sign_3_practid == 1){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>attendPractName &nbsp;&nbsp;(&nbsp; attendPractDegree &nbsp;)</span>";
					}
					if (footer_sign_3_practid == 2){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>admitPractName &nbsp;&nbsp;(&nbsp; admitPractDegree &nbsp;)</span>";
					}
					if (footer_sign_3_practid == 3){
						htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>authPractName &nbsp;&nbsp;(&nbsp; authPractDegree &nbsp;)</span>";
					}
					htmlFooter = htmlFooter + "</span></strong></span>";
					htmlFooter = htmlFooter + "</td>";									
					htmlFooter = htmlFooter + "</tr>";
					if (footer_sign_3_splty == 1){							
						htmlFooter = htmlFooter + "<tr>";
						htmlFooter = htmlFooter + "<td class='label'>";
						htmlFooter = htmlFooter + "<span style='font-size: 12px'><strong><span style='color: #808080'>";
						
						if (footer_sign_3_practid == 1){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>attendPractSplty &nbsp;</span>";
						}
						if (footer_sign_3_practid == 2){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>admitPractSplty &nbsp;</span>";
						}
						if (footer_sign_3_practid == 3){
							htmlFooter = htmlFooter + "<span style='font-family: verdana, geneva, sans-serif'>authPractSplty &nbsp;</span>";
						}
						
						htmlFooter = htmlFooter + "</span></strong></span>";
						htmlFooter = htmlFooter + "</td>";									
						htmlFooter = htmlFooter + "</tr>";
					}
					htmlFooter = htmlFooter + "</tbody>";
					htmlFooter = htmlFooter + "</table>";
					htmlFooter = htmlFooter + "</td>";
					
				}	
				htmlFooter = htmlFooter + "</tr>";
				htmlFooter = htmlFooter + "</tbody>";
				htmlFooter = htmlFooter + "</table>";
			}
		}

	}
	
	// Main Table
	htmlFooter = htmlFooter + "<table align='center' border='0' cellpadding='0' cellspacing='0' style='width: 900px'>"; 
	
	if (applyFlag == 0 ){
		arrayLength = document.SummLayoutConfigForm.fieldsCount.value;
	}
	else
	{
		arrayLength = f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.fieldsCount.value;
	}
	
	for( index= 0 ; index< parseInt(arrayLength);index++)
	{	
		if (applyFlag == 0 ){
			fieldId 	= eval("document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		else
		{
			fieldId 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_id"+index);
			fieldflag 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_flag"+index);
			fieldOrient = eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_orient"+index);
			fieldLbl 	= eval("f_query_add_mod.DetailsFrame.document.SummLayoutConfigForm.es_field_lbl"+index);	
		}
		
		
		var radios = fieldOrient;
		var orientValue = 0;
		
		if (fieldflag.checked == true)
		{
			for(var i = 0; i < radios.length; i++){
			    if(radios[i].checked){
			    	orientValue = radios[i].value;
			    }
			}			
			
			if (orientValue == 1)
			{				
				
				//Header Table row
				if ((fieldId.value == "ES_SPECIMEN_NO") || (fieldId.value == "ES_SPECIMEN_TYPE") || (fieldId.value == "ES_ORDER_NO") || 
						(fieldId.value == "ES_ORDER_DATE") || (fieldId.value == "ES_COLLECTED_DATE") || (fieldId.value == "ES_REGISTERED_DATE") || 
						(fieldId.value == "ES_AUTH_BY") || (fieldId.value == "ES_AUTH_DATE") || (fieldId.value == "ES_PRINTED_DATE")) 
				{					
					if (!(orderFlag)){
						htmlOrderFooter = htmlOrderFooter + "<tr><th>";
						htmlOrderFooter = htmlOrderFooter + "<table align='center' border='0' cellpadding='1' cellspacing='1'>";
						htmlOrderFooter = htmlOrderFooter + "<tbody>";		
						htmlOrderFooter = htmlOrderFooter + "<tr><hr style='color:#000080'/></tr>";
						orderFlag = true;
					}
					if (!(orderTrFlag)){						 
						htmlOrderFooter = htmlOrderFooter + "<tr>";
						orderTrFlag = true;
					} 
					orderCount = orderCount + 1;
				}
				
				if ((fieldId.value == "ES_SPECIMEN_NO") || (fieldId.value == "ES_SPECIMEN_TYPE") || (fieldId.value == "ES_ORDER_NO") || 
						(fieldId.value == "ES_ORDER_DATE") || (fieldId.value == "ES_COLLECTED_DATE") || (fieldId.value == "ES_REGISTERED_DATE") || 
						(fieldId.value == "ES_AUTH_BY") || (fieldId.value == "ES_AUTH_DATE") || (fieldId.value == "ES_PRINTED_DATE")) 
				{	
					if (orderCount%3 == 1){
						htmlOrderFooter = htmlOrderFooter + "<td valign='left' align='left' width='340px'>";
					}
					if (orderCount%3 == 2){
						htmlOrderFooter = htmlOrderFooter + "<td valign='left' align='left' width='360px'>";
					}
					if (orderCount%3 == 0){
						htmlOrderFooter = htmlOrderFooter + "<td valign='left' align='left' width='300px'>";
					}
					
					if (fieldId.value == "ES_SPECIMEN_NO"){
						
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specimenNo</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";						
					}
					
					if (fieldId.value == "ES_SPECIMEN_TYPE"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>specimenType</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";	
					}
					
					if (fieldId.value == "ES_ORDER_NO"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>orderNo</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
					}
					
					if (fieldId.value == "ES_ORDER_DATE"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>orderDate</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
					}
					
					if (fieldId.value == "ES_COLLECTED_DATE"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>collectedDate</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
					}
					
					if (fieldId.value == "ES_REGISTERED_DATE"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>registeredDate</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
					}
					
					if (fieldId.value == "ES_AUTH_BY"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>authorisedBy</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
					}
					
					if (fieldId.value == "ES_AUTH_DATE"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>authorisedDate</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
					}
					
					if (fieldId.value == "ES_PRINTED_DATE"){
						//htmlOrderFooter = htmlOrderFooter + "<td valign='center'>";
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
											""+fieldLbl.value+" </span></span></strong></span>";	
						htmlOrderFooter = htmlOrderFooter + "<span style='font-size: 10pt'><span style='font-family: verdana, geneva, sans-serif'>printedDate</span></span>";
						htmlOrderFooter = htmlOrderFooter + "</td>";
						
					}	
					if ((orderCount%3 == 0) && (orderTrFlag)){
						htmlOrderFooter = htmlOrderFooter + "</tr>";
						orderTrFlag = false;
					} 
				}
				
				if (!(fieldId.value == "ES_SPECIMEN_NO") && !(fieldId.value == "ES_SPECIMEN_TYPE") && !(fieldId.value == "ES_ORDER_NO") && 
						!(fieldId.value == "ES_ORDER_DATE") && !(fieldId.value == "ES_COLLECTED_DATE") && !(fieldId.value == "ES_REGISTERED_DATE") && 
						!(fieldId.value == "ES_AUTH_BY") && !(fieldId.value == "ES_AUTH_DATE") && !(fieldId.value == "ES_PRINTED_DATE")) 
				{
					if (orderFlag){
						htmlOrderFooter = htmlOrderFooter + "</tbody>";
						htmlOrderFooter = htmlOrderFooter + "</table>";		
						htmlOrderFooter = htmlOrderFooter + "</th></tr>";
						orderFlag = false;
					}
				}				

				//Header Table row
				if ((fieldId.value == "ES_FACILITY_ADD") || (fieldId.value == "ES_FACILITY_CONTACT1") || 
						(fieldId.value == "ES_FACILITY_CONTACT2") || (fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4") ||
						(fieldId.value == "ES_FACILITY_FAX") || (fieldId.value == "ES_FACILITY_EMAIL") || (fieldId.value == "ES_FACILITY_WEB")) 
				{					
					if (!(facilityFlag)){
						htmlfacilityFooter = htmlfacilityFooter + "<tr><th>";
						htmlfacilityFooter = htmlfacilityFooter + "<table align='center' border='0' cellpadding='1' cellspacing='1' style='width: 900px'>";
						htmlfacilityFooter = htmlfacilityFooter + "<tbody>";
						htmlfacilityFooter = htmlfacilityFooter + "<tr><hr style='color:#000080'/></tr>"; 
						facilityFlag = true;
					}
					if (!(facilityTrFlag)){						
						htmlfacilityFooter = htmlfacilityFooter + "<tr>";
						facilityTrFlag = true;
					} 
					facilityCount = facilityCount + 1;
				}
				
				//Facility Details Table
				if ((fieldId.value == "ES_FACILITY_ADD") || (fieldId.value == "ES_FACILITY_CONTACT1") || 
						(fieldId.value == "ES_FACILITY_CONTACT2") || (fieldId.value == "ES_FACILITY_CONTACT3") || (fieldId.value == "ES_FACILITY_CONTACT4") ||
						(fieldId.value == "ES_FACILITY_FAX") || (fieldId.value == "ES_FACILITY_EMAIL") || (fieldId.value == "ES_FACILITY_WEB") ) 
				{
					if (facilityCount%3 == 1){
						htmlfacilityFooter = htmlfacilityFooter + "<td valign='left' align='left' width='340px'>";
					}
					if (facilityCount%3 == 2){
						htmlfacilityFooter = htmlfacilityFooter + "<td valign='left' align='left' width='360px'>";
					}
					if (facilityCount%3 == 0){
						htmlfacilityFooter = htmlfacilityFooter + "<td valign='left' align='left' width='300px'>";
					}					
								
				
					if (fieldId.value == "ES_FACILITY_ADD"){
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 10px'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								"address</span></span></strong></span>";								
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					
					if (fieldId.value == "ES_FACILITY_CONTACT1"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"telephone1</span></span></strong></span>";
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					if (fieldId.value == "ES_FACILITY_CONTACT2"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
								""+fieldLbl.value+"telephone2</span></span></strong></span>";								
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
									
					if (fieldId.value == "ES_FACILITY_CONTACT3"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"telephone3</span></span></strong></span>";	
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					if (fieldId.value == "ES_FACILITY_CONTACT4"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
								""+fieldLbl.value+"telephone4</span></span></strong></span>";								
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					
					if (fieldId.value == "ES_FACILITY_FAX"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><strong><span style='color: XYZ808080'><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"fax</span></span></strong></span>";	
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					if (fieldId.value == "ES_FACILITY_EMAIL"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><strong><span style='font-family: verdana, geneva, sans-serif'><span style='color: XYZ808080'>" +
								""+fieldLbl.value+"emailId</span></span></strong></span>";								
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					if (fieldId.value == "ES_FACILITY_WEB"){	
						htmlfacilityFooter = htmlfacilityFooter + "<span style='font-size: 11px'><span style='color: #ff0000'><strong><span style='font-family: verdana, geneva, sans-serif'>" +
								""+fieldLbl.value+"website</span></strong></span></span>";								
						htmlfacilityFooter = htmlfacilityFooter + "</td>";
					}
					
					if ((facilityCount%3 == 0) && (facilityTrFlag)){
						htmlfacilityFooter = htmlfacilityFooter + "</tr>";
						facilityTrFlag = false;
					} 
				}
				
				if (!(fieldId.value == "ES_FACILITY_ADD") && !(fieldId.value == "ES_FACILITY_CONTACT1") &&  
						!(fieldId.value == "ES_FACILITY_CONTACT2") && !(fieldId.value == "ES_FACILITY_CONTACT3") && !(fieldId.value == "ES_FACILITY_CONTACT4") &&
						!(fieldId.value == "ES_FACILITY_FAX") && !(fieldId.value == "ES_FACILITY_EMAIL") && !(fieldId.value == "ES_FACILITY_WEB")) 
				{
					if (facilityFlag) {																	
						htmlfacilityFooter = htmlfacilityFooter + "</tbody>";
						htmlfacilityFooter = htmlfacilityFooter + "</table>	";
						facilityFlag = false;
					}
				}
				
			}
		}		
	}	
	if (orderFlag){
		if (orderTrFlag){
			htmlOrderFooter = htmlOrderFooter + "</tr>";
			orderTrFlag = false;
		}
		
		htmlOrderFooter = htmlOrderFooter + "</tbody>";
		htmlOrderFooter = htmlOrderFooter + "</table>";		
		htmlOrderFooter = htmlOrderFooter + "</th></tr>";
		orderFlag = false;
	}	
	
	if (facilityFlag){
		if (facilityTrFlag){
			htmlfacilityFooter = htmlfacilityFooter + "</tr>";
			facilityTrFlag = false;
		}
		
		htmlfacilityFooter = htmlfacilityFooter + "</tbody>";
		htmlfacilityFooter = htmlfacilityFooter + "</table>";		
		htmlfacilityFooter = htmlfacilityFooter + "</th></tr>";
		facilityFlag = false;
	}	
	
	htmlFooter = htmlFooter + htmlOrderFooter;
	htmlFooter = htmlFooter + htmlfacilityFooter;
	htmlFooter = htmlFooter + "</table>";
		
	return htmlFooter;
}

function getFormElements(){
	var changeFlag = false;
	
	var elements = document.SummLayoutConfigForm.elements;
	for (var i=0; i<elements.length; i++){
	   if (elements[i].type == "text"){
		   if (elements[i].value != elements[i].defaultValue){
			   changeFlag = true;
		   }
	   }
	   if (elements[i].type == "checkbox"){
		   if (elements[i].checked != elements[i].defaultChecked){
			   changeFlag = true;
		   }
	   }
	   if (elements[i].type == "radio"){
		   if (elements[i].checked != elements[i].defaultChecked){
			   changeFlag = true;
		   }
	   }
	   /*
	   if (elements[i].type == "select-one"){
		   if (!elements[i].options[elements[i].selectedIndex].defaultSelected){
			   changeFlag = true;
		   }
	   }
	   */
	}
	
	return changeFlag;
}


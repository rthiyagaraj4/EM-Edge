function apply()
{ 
	if((result_frame.document.forms[0] == null))
	{
//		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=APP-002413 No Changes to Save...";
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=" + getMessage("NO_CHANGE_TO_SAVE","common");
		return;
	}
	else
	{
	if((result_frame.length > 0) || (result_frame.document.forms[0].name == 'DTLinkEncounterResultForm'))
	{
		if(result_frame.document.forms[0].name == 'DTLinkEncounterResultForm')
		{
			if(result_frame.document.forms[0].action_code.value == 'D')
			{
				result_frame.document.forms[0].action	= "../../servlet/eFM.DTLinkEncounterDocTypeServlet";
				result_frame.document.forms[0].post		= "POST";
				result_frame.document.forms[0].target	= "messageFrame";
				result_frame.document.forms[0].submit();
			}
			else
			{
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
		else if(result_frame.length > 0)
		{
			if(result_frame.select_doc_frame.document.forms[0] != null) 
			{
				result_frame.document.forms[0].action	= "../../servlet/eFM.DTLinkEncounterDocTypeServlet";
				result_frame.document.forms[0].post		= "POST";
				result_frame.document.forms[0].target	= "messageFrame";
				result_frame.document.forms[0].submit();
			}
			else
			{
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
		else
		{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
		}
	}
	else
	{
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}
}
function reset()
{
	criteria_frame.document.location.reload();
	tab_frame.document.location.href="../../eCommon/html/blank.html";
	result_frame.document.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}
function onSuccess()
{
	frames[1].document.location.reload();
	frames[2].document.location.href='../../eCommon/html/blank.html';
	frames[3].document.location.href='../../eCommon/html/blank.html';
}
/////////********** JS Files of DTLinkEncounterDocumentsList.jsp ***********************/////////////
function removeThisItem(check, count)
{
	if (!check.checked)
	{
		var maintain_doc_or_file	=	document.forms[0].maintain_doc_or_file.value;
		var volume_no	=	"";
		var fs_location	=	"";
		if (maintain_doc_or_file!="D")
		{
			volume_no		=	"document.forms[0].volume_no"+count;
			volume_no		=	eval(volume_no).value;
		}
		else 
		{
			fs_location		=	"document.forms[0].fs_location"+count;
			fs_location		=	eval(fs_location).value;
		}
		var document_no		=	"document.forms[0].document_no"+count;
		var doc_type_code	=	"document.forms[0].doc_type_code"+count;
		var doc_type_desc	=	"document.forms[0].doc_type_desc"+count;
			document_no		=	eval(document_no).value;
			doc_type_code	=	eval(doc_type_code).value;
			doc_type_desc	=	eval(doc_type_desc).value;
		var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/DTLinkEncounterVolumeDocTypeValidations.jsp' method='POST'><input type='Hidden' name='volume_no' id='volume_no' value = '"+volume_no+"'><input type='Hidden' name='document_no' id='document_no' value = '"+document_no+"'><input type='Hidden' name='doc_type_code' id='doc_type_code' value = '"+doc_type_code+"'><input type='Hidden' name='doc_type_desc' id='doc_type_desc' value = '"+doc_type_desc+"'><input type='Hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value = '"+maintain_doc_or_file+"'><input type='Hidden' name='fs_location' id='fs_location' value = '"+fs_location+"'><input type='Hidden' name='operation' id='operation' value = 'RemoveElement'></form></body></html>";
		parent.parent.messageFrame.document.write(HTMLValue);
		parent.parent.messageFrame.document.Dummy_Form.submit();
	}
}
/////////********** End of JS Files of DTLinkEncounterDocumentsList.jsp ***************/////////////
			/////////////////////////////////////////////////////////////////
/////////**********  JS Files of DTLinkEncounterVolumeDocTabs.jsp ***************/////////////
function objClick(objName)
{
	if (objName=="first_tab")
	{
		prevTabObj='second_tab';
		parent.criteria_frame.getResults();
	}
	else
	{
		prevTabObj='first_tab';
	}
}
/////////********** End of JS Files of DTLinkEncounterVolumeDocTabs.jsp ***************/////////////
			////////////////////////////////////////////////////////////////
/////////********** JS Files of DTLinkEncounterVolumeDocTypeCriteria.jsp ***************/////////////
function clearPage()
{
	parent.tab_frame.document.location.href			=	"../../eCommon/html/blank.html";
	parent.result_frame.document.location.href		=	"../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href		=	"../../eCommon/jsp/error.jsp";

	parent.criteria_frame.document.forms[0].search.disabled		= false;
	parent.criteria_frame.document.forms[0].patient_id.disabled = false;
	parent.criteria_frame.document.forms[0].pat_search.disabled = false;
	
	parent.criteria_frame.document.forms[0].action_code.disabled = false;
}
/////////******* End of JS Files of DTLinkEncounterVolumeDocTypeCriteria.jsp ***********///////////
			////////////////////////////////////////////////////////////////////
/////////******* JS Files of DTLinkEncounterVolumeDocumentsAdd.jsp ***********///////////
function checkForDocNumber(doc_no)
{
	if ((document.forms[0].check_flag.value != "N") && (doc_no==""))
	{
		document.getElementById("doc_type").innerHTML			= "&nbsp;";
		document.forms[0].add_button.disabled	= true;
	}
}
function docNumberLookup(document_no)
{
	if(document.forms[0].check_flag.value != "N")
	{
		var doc_or_file  = parent.parent.frames[1].document.forms[0].maintain_doc_or_file.value;
		if (doc_or_file=="D")
		{
		var doc_folder  = parent.parent.frames[1].document.forms[0].doc_folder_id.value;
		}else
		{

		}
		var title		= encodeURIComponent(getLabel("Common.documentno.label","common"));
		var argArray	= new Array();	
		var selectArray	= new Array();	
		var headArray	= new Array();	
		var searchArray	= new Array();	
		var arr			= new Array();	
		if (doc_or_file=="D")
		{
		var sql			= "SELECT a.doc_no, a.doc_type_code, a.doc_type_name FROM fm_doc_type a,fm_doc_type_in_folder b where a.eff_status = 'E' and a.doc_type_code=b.doc_type_code and doc_folder_id='"+doc_folder+"' ";
		}
		else
		{
		var sql			= "SELECT a.doc_no, a.doc_type_code, a.doc_type_name FROM fm_doc_type a where a.eff_status = 'E' ORDER BY a.doc_no ";
		}

		selectArray[0]	= "doc_no";	
		selectArray[1]	= "doc_type_code";	
		selectArray[2]	= "doc_type_name";	

		headArray[0]	= getLabel("Common.documentno.label","common");
		headArray[1]	= getLabel("Common.documenttype.label","common")+ " " +getLabel("Common.code.label","common");//"Document Type Code";
		headArray[2]	= getLabel("Common.documenttype.label","common")+ " "+ getLabel("Common.name.label","common");//Document Type Name";

		argArray[0]		= document_no; // To get Search Criteria.
		argArray[1]		= sql; // SQL to be executed.
		argArray[2]		= selectArray;	// Column names to be used for getting data. 
		argArray[3]		= headArray;	// Column Titles
		argArray[4]		= "doc_no";	 // To give Link

		var retVal		= CommonDocumentLookup(title, argArray);
		if(retVal != null && retVal != "" )
		{
			var ret1	=	unescape(retVal);
			arr=ret1.split("$$");
			document.forms[0].document_no.value		=	arr[0];
			document.forms[0].doc_type_code.value	=	arr[1];
			document.forms[0].doc_type_desc.value	=	arr[2];
			document.getElementById("doc_type").innerText			=	arr[2];
			document.forms[0].add_button.disabled	=	false;
		}
		else
		{
			document.forms[0].document_no.value		=	"";
			document.forms[0].doc_type_code.value	=	"";
			document.forms[0].doc_type_desc.value	=	"";
			document.getElementById("doc_type").innerHTML			=	"&nbsp;";
			document.forms[0].add_button.disabled	=	true;
			document.forms[0].check_flag.value		=	"Y";
		} 
		document.forms[0].check_flag.value = "Y";	
	}
}
function AddRecords()
{
	var encounter_id	=	document.forms[0].encounter_id.value;
	var volume_no		=	document.forms[0].volume_no.value;
	var document_no		=	document.forms[0].document_no.value;
	var doc_type_code	=	document.forms[0].doc_type_code.value;
	var doc_type_desc	=	document.forms[0].doc_type_desc.value;
	var operation		=	document.forms[0].operation.value;
	var doc_details		=	document.forms[0].doc_details.value;
	var doc_date		=	document.forms[0].document_date.value;
	if (doc_date != "")
	{
		doc_date=convertDate(doc_date,"DMY",localeName,"en");
	}

	var file_no			=	document.forms[0].file_no.value;
	var fs_location		=	"";
	var maintain_doc_or_file	=	document.forms[0].maintain_doc_or_file.value;
	if (maintain_doc_or_file=="D")
	{
		var fs_location		=	document.forms[0].fs_location.value;
		if (fs_location=="")
		{
//			alert("APP-000001 File Storage Location cannot be blank...");
			alert(getMessage("FILE_STORAGE_NOT_BLANK","FM"));
			document.forms[0].fs_location.focus();
			return;
		}
	}
	var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/DTLinkEncounterVolumeDocTypeValidations.jsp' method='POST'><input type='Hidden' name='volume_no' id='volume_no' value = '"+volume_no+"'><input type='Hidden' name='file_no' id='file_no' value = '"+file_no+"'><input type='Hidden' name='document_no' id='document_no' value = '"+document_no+"'><input type='Hidden' name='doc_type_code' id='doc_type_code' value = '"+doc_type_code+"'><input type='Hidden' name='doc_type_desc' id='doc_type_desc' value = '"+doc_type_desc+"'><input type='Hidden' name='operation' id='operation' value = '"+operation+"'><input type='Hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value = '"+maintain_doc_or_file+"'><input type='Hidden' name='encounter_id' id='encounter_id' value = '"+encounter_id+"'><input type='Hidden' name='fs_location' id='fs_location' value = '"+fs_location+"'><input type='Hidden' name='doc_details' id='doc_details' value = '"+doc_details+"'><input type='Hidden' name='doc_date' id='doc_date' value = '"+doc_date+"'></form></body></html>";
	parent.parent.messageFrame.document.write(HTMLValue);
	parent.parent.messageFrame.document.Dummy_Form.submit();
}
function getValidDocumentType(doc_number)
{
	if (doc_number != "")
	{
		// To check whether the document number is retrieved  using Barcode Reader or not
		if (document.forms[0].check_flag.value != "N") 
		{
			var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='DummyForm' id='DummyForm' action='../../eFM/jsp/DTLinkEncounterVolumeDocTypeValidations.jsp' method='POST'><input type='Hidden' name='document_no' id='document_no' value = '"+doc_number+"'><input type='Hidden' name='operation' id='operation' value = 'GetDocumentType'></form></body></html>";
			
			parent.parent.messageFrame.document.bodywrite(HTMLValue);
			parent.parent.messageFrame.document.DummyForm.submit();
			
		}
	}
	else
		document.getElementById("doc_type").innerHTML="&nbsp;";
}
function getBarCodeValue(evnt, val)
{
	if (evnt.keyCode==13)
	{
		docNumberLookup(val)
		document.forms[0].check_flag.value = "N";
		return false;
	}
	else
	{
		document.forms[0].check_flag.value = "Y";	
		return true;
	}
}
function checkLength(charlen)
{
	if (charlen.value.length > 200)
	{
		//alert("APP-FM0099 - Description cannot exceed 200 characters");
        var errmsg=getMessage("REMARKS_CANNOT_EXCEED","common" );
		errmsg=errmsg.replace('$',getLabel("Common.description.label","common"));
		errmsg=errmsg.replace('#',200);
		alert(errmsg);
		DTLinkEncounterAddForm.doc_details.focus();
	}
	
}
/////////******* End of JS Files of DTLinkEncounterVolumeDocumentsAdd.jsp ***********///////////
			//////////////////////////////////////////////////////////////////
/////////******* JS Files of DTLinkEncounterVolumeDocTypeResult.jsp ***********///////////
function getDocuments(encounter, volume_no, count)
{
	selectTab('second_tab');
	var patient_id		=	"";
	var encounter_date	=	"document.forms[0].encounter_date"+count;
	encounter_date		=	eval(encounter_date).value;
	if (document.forms[0].patient_period_specific.value=="D")
	{
		patient_id		=	"document.forms[0].patient_id"+count;
		patient_id		=	eval(patient_id).value;
		document.forms[0].patient_id.value			= patient_id;
	}
	document.forms[0].volume_no.value			= volume_no;
	document.forms[0].encounter_id.value		= encounter;
	document.forms[0].encounter_date_time.value	= encounter_date;
	document.forms[0].method					= "POST";
	document.forms[0].action					= "../../eFM/jsp/DTLinkEncounterDocumentsFrames.jsp";
	document.forms[0].submit();
}
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

//var validDictionary	= new ActiveXObject("Scripting.Dictionary"); 
var validDictionary={};
function getRelatedRecords(checkBox)
{
	var validcheck		=	document.forms[0].valid_values.value;
	var valid_val		=	"";
	var hiddenValidArray= new Array();
	hiddenValidArray	= validcheck.split(",");
	var validLen		= Math.abs(hiddenValidArray.length) ;

	for (j=0; j<validLen; j++)
	{
		valid_val	=	hiddenValidArray[j];
		if (!validDictionary.Exists(valid_val))
		validDictionary.add(valid_val, valid_val);
	}

	if (checkBox.checked)
	{
		valid_val	=	checkBox.value;
		if (!validDictionary.Exists(valid_val))
				validDictionary.add(valid_val, valid_val);
	}
	else
	{
		valid_val	=	checkBox.value;
		if (validDictionary.Exists(valid_val))
				validDictionary.Remove(valid_val);
	}
	
	document.forms[0].valid_values.value = ((validDictionary.Keys()).toArray()).toString();
}
/////////******* End of JS Files of DTLinkEncounterVolumeDocTypeResult.jsp ***********///////////
			///////////////////////////////////////////////////////////////////
/////////******* End of JS Files of DTLinkEncounterVolumeDocTypeCriteria.jsp ***********///////////
function DateCompare(from,to,messageFrame,getVal) 
{
	var getValue = getVal;
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			alert(getMessage("TO_DATE_LESSER_FROM_DATE","FM"));
			to.select();
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			return true;
		}
	}
	return true;
}

function docFolderSearch(facility_id)
{
	var target			= document.forms[0].doc_folder_desc;
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	sql = "SELECT doc_folder_id code, doc_folder_name description FROM fm_doc_folder WHERE upper(facility_id) like upper(?) and eff_status = 'E' AND upper(doc_folder_id) like upper(?) AND upper(doc_folder_name) like upper(?) "

	var title=getLabel("eFM.DocumentFolder.label","FM");
	dataNameArray[0]	= "facility_id" ;
	dataValueArray[0]	= facility_id;
	dataTypeArray[0]	= STRING ;
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2, 3";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( title, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1	=	unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].doc_folder_id.value	=	arr[0];
		document.forms[0].doc_folder_desc.value	=	arr[1];
		populateDynamicValues(arr[0]);
	}
	else
	{
		document.forms[0].doc_folder_id.value	=	"";
		document.forms[0].doc_folder_desc.value	=	"";
		document.getElementById("patient").innerHTML			=	"&nbsp;";
		document.getElementById("patient_detail").innerHTML	=	"&nbsp;";
		document.getElementById("period").innerHTML			=	"&nbsp;";
		document.getElementById("period_detail").innerHTML	=	"&nbsp;";
	} 
} // End of getUser().

function populateDynamicValues(doc_folder_id)
{
	if (doc_folder_id!="")
	{
		var HTMLValue	=	"<html><head></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' action='../../eFM/jsp/DTLinkEncounterVolumeDocTypeValidations.jsp' method='POST' ><input type='hidden' name='doc_folder_id' id='doc_folder_id' value='"+doc_folder_id+"'><input type='Hidden' name='operation' id='operation' value = 'DocumentFolder'></form></body></html>";
		parent.messageFrame.document.bodywrite(HTMLValue);
		parent.messageFrame.document.dummy_form.submit();
	}
}

function clearAllPage()
{
	parent.tab_frame.document.location.href				=	"../../eCommon/html/blank.html";
	parent.result_frame.document.location.href			=	"../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href			=	"../../eCommon/jsp/error.jsp";

	parent.criteria_frame.document.forms[0].search.disabled			= false;
	parent.criteria_frame.document.forms[0].doc_folder_desc.disabled= false;
	
}
/////////******* End of JS Files of DTLinkEncounterVolumeDocTypeCriteria.jsp ***********///////////


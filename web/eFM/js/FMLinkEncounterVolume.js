function apply()
{
	if((result_frame.document.FMLinkEncounterResultForm == null)||(result_frame.document.FMLinkEncounterResultForm.valid_values.value == ""))
	{
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+ getMessage("NO_CHANGE_TO_SAVE","common");
		return;
	}
	else
	{
		var action_code			= result_frame.document.FMLinkEncounterResultForm.action_code.value;
		var valid_values		= result_frame.document.FMLinkEncounterResultForm.valid_values.value;
		var patient_id			= result_frame.document.FMLinkEncounterResultForm.patient_id.value;
		var file_no				= result_frame.document.FMLinkEncounterResultForm.file_no.value;
		var file_type_code		= result_frame.document.FMLinkEncounterResultForm.patient_file_type.value;
		var file_type_appl_yn	= result_frame.document.FMLinkEncounterResultForm.file_type_appl_yn.value;

		var mainToken	=	new Array()
		var innerToken	=	new Array()
		var volumeToken	=	new Array()

		var mainCount	=	0;
		var innerCount	=	0;
		
		mainToken		=	valid_values.split(",");	
		mainCount		=	Math.abs(mainToken.length);

		for(i=0; i<mainCount; i++)
		{
			if(mainToken[i] != "")
			{
				innerToken	=	mainToken[i].split("||");	
				if(innerToken[4] != "") 
				{
					volumeToken	=	innerToken[4].split("^^");
					if (volumeToken[1] == "") 
					{
						//alert("APP-000001 File Volume cannot be blank...");
						errors1 = getMessage("CAN_NOT_BE_BLANK","common");
						errors1=errors1.replace('$',getLabel("eFM.FileVolume.label","FM"));
						alert(errors1);
						messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num=";
						return;
					}
				}
			}
		}
		var HTMLValue = "<html><body onKeyDown = 'lockKey()'></body><form name='dummy_form' id='dummy_form' action='../../servlet/eFM.FMLinkEncounterVolumeServlet?action_code="+action_code+"' method='POST' target='messageFrame'><input type='Hidden' name='valid_values' id='valid_values' value='"+valid_values+"'><input type='Hidden' name='action_code' id='action_code' value='"+action_code+"'><input type='Hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='Hidden' name='file_no' id='file_no' value='"+file_no+"'><input type='Hidden' name='file_type_code' id='file_type_code' value='"+file_type_code+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='"+file_type_appl_yn+"'></form></html>"
		messageFrame.document.write(HTMLValue);
		messageFrame.document.dummy_form.submit();
	}
}
function reset()
{
	criteria_frame.document.location.reload();
	patient_line_frame.document.location.href="../../eCommon/html/blank.html";
	result_frame.document.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}
function onSuccess()
{
	frames[1].document.location.reload();
	frames[2].document.location.href='../../eCommon/html/blank.html';
	frames[3].document.location.href='../../eCommon/html/blank.html';
}
///////////******** JS Files of FMLinkEncounterVolumeCriteria.jap *****************/////////////
function clearPage()
{
	parent.patient_line_frame.document.location.href	= "../../eCommon/html/blank.html";
	parent.result_frame.document.location.href			= "../../eCommon/html/blank.html";
	parent.messageFrame.document.location.href			= "../../eCommon/jsp/error.jsp";

	parent.criteria_frame.document.forms[0].search.disabled		= false;
	parent.criteria_frame.document.forms[0].patient_id.disabled = false;
	parent.criteria_frame.document.forms[0].pat_search.disabled = false;
	
	/*if (document.forms[0].file_type_appl_yn.value=="N")
		parent.criteria_frame.document.forms[0].file_no.disabled	= false;
	else if (document.forms[0].file_type_appl_yn.value=="Y")
		parent.criteria_frame.document.forms[0].file_type.disabled	= false;*/
	
	parent.criteria_frame.document.forms[0].action_code.disabled = false;
}

function getResults()
{
	var maintain_doc_or_file	= document.forms[0].maintain_doc_or_file.value;
	if (maintain_doc_or_file == "D")
	{
		if (document.forms[0].doc_folder_id.value == "")
		{
		//	alert("APP-000001 Document Folder cannot be blank...");
			var errormsg =getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("eFM.DocumentFolder.label","FM"));
			alert(errormsg);
			document.forms[0].doc_folder_desc.focus();
			return;
		}
		else if (document.forms[0].doc_type_id.value == "")
		{
			alert(getMessage("DOC_CAN_NOT_BE_BLANK","FM"));
			document.forms[0].doc_type_id.focus();
			return;
		}
		else if (document.forms[0].action_code.value == "")
		{
//			alert("APP-000001 Action cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.action.label","common"));
			alert(errormsg);
			document.forms[0].doc_type_id.focus();
			return;
		}
	}
	else
	{
		var patient_id		= document.forms[0].patient_id.value;
		var action_code		= document.forms[0].action_code.value;
		var file_no		= document.forms[0].file_no.value;
			
		if(document.forms[0].file_type_appl_yn.value == "Y")
		{
			var file_type	= document.forms[0].patient_file_type.value;
		}
		
		if(patient_id == "") 
		{
//			alert("APP-000001 Patient ID cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.patientId.label","common"));
			alert(errormsg);
			document.forms[0].patient_id.focus();
			return;
		}

		if((file_type == "") && (document.forms[0].file_type_appl_yn.value == "Y"))
		{
			//alert("APP-000001 File Type cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.filetype.label","common"));
			alert(errormsg);
			//document.forms[0].file_type.focus();
			return;
		}
		else if((document.forms[0].file_type_appl_yn.value == "N") && (file_no == "" ))
		{
			//alert("APP-000001 File No cannot be blank...");
			alert(getMessage("FILE_CAN_NOT_BE_BLANK","FM"));
			document.forms[0].file_no.focus();
			return;
		}
		else if(action_code == "")
		{
			//alert("APP-000001 Action cannot be blank...");
			var errormsg=getMessage("CAN_NOT_BE_BLANK","common");
			errormsg=errormsg.replace('$',getLabel("Common.action.label","common"));
			alert(errormsg);
			document.forms[0].action_code.focus();
			return;
		}

		var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
		parent.result_frame.document.location.href="../../eFM/jsp/FMLinkEncounterVolumeResult.jsp?patient_id="+patient_id+"&file_no="+file_no+"&file_type="+file_type+"&action_code="+action_code+"&searchYN=Y&file_type_appl_yn="+file_type_appl_yn;
		document.forms[0].search.disabled = true;
	}
}
/////////************ End of JS Files of FMLinkEncounterVolumeCriteria.jap *********/////////////
				///////////////////////////////////////////////////////////
///////////*********** JS Files of FMLinkEncounterVolumeResult.jap ******************////////////
var validDictionary = new Map();
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}

function getCheckedValues(checkBox, volume) {
    var validcheck = document.forms[0].valid_values.value;
    var valid_val = "";
    var hiddenValidArray = validcheck.split(",");
    var validLen = hiddenValidArray.length;

    // Create a Map to store valid values
    var validDictionary = new Map();

    // Populate the Map with existing valid values
    for (var j = 0; j < validLen; j++) {
        valid_val = hiddenValidArray[j];
        validDictionary.set(valid_val, valid_val);  // Add value to Map
    }

    // Handle the checked state of the checkbox
    valid_val = checkBox.value + "^^" + volume.value;

    if (checkBox.checked) {
        validDictionary.set(valid_val, valid_val); // Add to Map
    } else {
        validDictionary.delete(valid_val); // Remove from Map
    }

    // Update the valid_values input field with the Map keys as a string
    document.forms[0].valid_values.value = Array.from(validDictionary.keys()).toString();
}
function getSelectedValues(selectBox, checkBox) {
    var validcheck = document.forms[0].valid_values.value;
    var valid_val = "";
    var hiddenValidArray = validcheck.split(",");
    var validLen = hiddenValidArray.length;

    // Create a Map to store valid values
    var validDictionary = new Map();

    // Populate the Map with existing valid values
    for (var j = 0; j < validLen; j++) {
        valid_val = hiddenValidArray[j];
        validDictionary.set(valid_val, valid_val);  // Add value to Map
    }

    // Handle the checkbox checked state
    if (checkBox.checked) {
        valid_val = checkBox.value + "^^" + "";

        if (validDictionary.has(valid_val)) {
            validDictionary.delete(valid_val); // Remove if it already exists
        }

        // Now add the updated value with the selectBox value
        valid_val = checkBox.value + "^^" + selectBox.value;
        validDictionary.set(valid_val, valid_val); // Add the new value to Map

        // Handle the processing of valid values in the Map
        var valid_values = Array.from(validDictionary.keys()).toString();
        var mainToken = valid_values.split(",");
        var mainCount = mainToken.length;

        for (var i = 0; i < mainCount; i++) {
            if (mainToken[i] !== "") {
                var innerToken = mainToken[i].split("||");
                if (innerToken[4] !== "") {
                    var volumeToken = innerToken[4].split("^^");
                    if (volumeToken[1] !== "") {
                        valid_val = checkBox.value + "^^" + volumeToken[1];
                        if (validDictionary.has(valid_val)) {
                            validDictionary.delete(valid_val); // Remove if exists
                        }
                        valid_val = checkBox.value + "^^" + selectBox.value;
                        validDictionary.set(valid_val, valid_val); // Add updated value to Map
                    }
                }
            }
        }
    }

    // Update the valid_values input field with the Map keys as a string
    document.forms[0].valid_values.value = Array.from(validDictionary.keys()).toString();
}


///////////******** End of JS Files of FMLinkEncounterVolumeResult.jap *********/////////////

function getDocuments(encounter, volume_no, count)
{
	if ( parent.frames[2].document.DocumentTabs )
	{
		parent.frames[2].document.DocumentTabs.second_tab.className='tabClicked';
		parent.frames[2].document.DocumentTabs.second_tabspan.className='tabSpanclicked';
		parent.frames[2].document.DocumentTabs.first_tab.className='tabA';
		parent.frames[2].document.DocumentTabs.first_tabspan.className='tabAspan';
	}
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

async function showAuditTrail(){
	     
    var retVal =    new String();
    var dialogHeight= "500px" ;
    var dialogWidth = "800px" ;
    var status = "no";
    
	var patient_id		= parent.criteria_frame.document.forms[0].patient_id.value;
	var file_type_appl_yn	= parent.criteria_frame.document.forms[0].file_type_appl_yn.value;
	var file_no	= "";
	var file_type = "";

	if(file_type_appl_yn == "N") {
		file_no		= parent.criteria_frame.document.forms[0].file_no.value;
	}
	if(file_type_appl_yn == "Y") {
		file_type	= parent.criteria_frame.document.forms[0].patient_file_type.value;
	}

	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
    retVal = await window.showModalDialog("../../eFM/jsp/FMEncFileVolumeAuditFrame.jsp?patient_id="+patient_id+"&file_no="+file_no+"&file_type="+file_type+"&file_type_appl_yn="+file_type_appl_yn+"&showPline=N",arguments,features);
	
}


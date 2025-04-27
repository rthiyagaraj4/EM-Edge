function create()
{
	f_query_add_mod.location.href="../../eFM/jsp/FMDocumentFolderAddMod.jsp?operation=create";
}
function apply()
{
	var fields;
	var names;
	var chk_fields;
	var chk_names;

	if(f_query_add_mod.document.DocumentFolder_Form.eff_status.checked == true)
		f_query_add_mod.document.DocumentFolder_Form.eff_status.value = 'E';
	else if(f_query_add_mod.document.DocumentFolder_Form.eff_status.checked == false)
		f_query_add_mod.document.DocumentFolder_Form.eff_status.value = 'D';

	if(f_query_add_mod.document.DocumentFolder_Form.doc_folder_type.value != '')
	{
		if(f_query_add_mod.document.DocumentFolder_Form.doc_folder_type.value =='P')
		{
			fields = new Array (f_query_add_mod.document.DocumentFolder_Form.doc_folder_id,f_query_add_mod.document.DocumentFolder_Form.doc_folder_name,f_query_add_mod.document.DocumentFolder_Form.patient_id);
			names  = new Array (getLabel("Common.identification.label","common"), getLabel("Common.name.label","common"), getLabel("Common.patientId.label","common"));
		}
		else if(f_query_add_mod.document.DocumentFolder_Form.doc_folder_type.value =='D')
		{
			fields = new Array (f_query_add_mod.document.DocumentFolder_Form.doc_folder_id,f_query_add_mod.document.DocumentFolder_Form.doc_folder_name,f_query_add_mod.document.DocumentFolder_Form.from,f_query_add_mod.document.DocumentFolder_Form.to);
			names  = new Array (getLabel("Common.identification.label","common"), getLabel("Common.name.label","common"), getLabel("Common.periodfrom.label","common"),getLabel("Common.periodto.label","common"));
		}
	}
	else if(f_query_add_mod.document.DocumentFolder_Form.doc_folder_type.value == '')
	{
		fields = new Array (f_query_add_mod.document.DocumentFolder_Form.doc_folder_id,f_query_add_mod.document.DocumentFolder_Form.doc_folder_name,f_query_add_mod.document.DocumentFolder_Form.doc_folder_type);
		names  = new Array (getLabel("Common.identification.label","common") , getLabel("Common.name.label","common"), getLabel("Common.type.label","common"));
	}
	if(checkFields(fields,names,messageFrame))
	{
		if(f_query_add_mod.document.DocumentFolder_Form.doc_folder_type.value =='P')
		{
			chk_fields = new Array (f_query_add_mod.document.DocumentFolder_Form.patient_id);
			chk_names  = new Array (getLabel("Common.patientId.label","common"));
		}
		else if(f_query_add_mod.document.DocumentFolder_Form.doc_folder_type.value =='D')
		{
			chk_fields = new Array (f_query_add_mod.document.DocumentFolder_Form.from,f_query_add_mod.document.DocumentFolder_Form.to);
			chk_names  = new Array (getLabel("Common.periodfrom.label","common"), getLabel("Common.periodto.label","common"));
		}
		if(checkFields(chk_fields,chk_names,messageFrame))
		{
			DTchkValidPatID();
		}
	}
}
function DTchkValidPatID()
{
	var doc_folder_type = f_query_add_mod.document.forms[0].doc_folder_type.value;
	if(doc_folder_type == 'P')
	{
		var patient_id	= f_query_add_mod.document.forms[0].patient_id.value;
		var facility_id	= f_query_add_mod.document.forms[0].facility_id.value;
		var HTMLValue = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><FORM name='DummyForm' id='DummyForm' action='../../eFM/jsp/DTValidatePatientID.jsp' method='post'><INPUT type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='doc_folder_type' id='doc_folder_type' value='"+doc_folder_type+"'></FORM></BODY></HTML>";
	}
	else if(doc_folder_type == 'D')
	{
		var from	= f_query_add_mod.document.forms[0].from.value;
		var to		= f_query_add_mod.document.forms[0].to.value;

		var HTMLValue = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'><FORM name='DummyForm' id='DummyForm' action='../../eFM/jsp/DTValidatePatientID.jsp' method='post'><INPUT type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='doc_folder_type' id='doc_folder_type' value='"+doc_folder_type+"'></FORM></BODY></HTML>";
	}

	messageFrame.document.write(HTMLValue);
	messageFrame.document.DummyForm.submit();
}
async function patientSearch()
{
	var patient_id	=	await PatientSearch('','','','','','','Y','','','OTHER');
	
	if(patient_id != null)
	{
		document.DocumentFolder_Form.patient_id.value=patient_id;
		document.DocumentFolder_Form.patient_id.focus();
	}
}

function query()
{
	f_query_add_mod.location.href="../../eFM/jsp/FMDocumentFolderQueryCriteria.jsp";
}
function reset()
{
	if(f_query_add_mod.document.forms[0].name == 'DocumentFolder_Form')
	{
		f_query_add_mod.location.reload();
	}
	else if(f_query_add_mod.document.forms[0].name == 'query_form')
	{
		f_query_add_mod.location.reload();
	}
}
function onSuccess()
{
	f_query_add_mod.location.reload();
}
/* On Page Load Focusing the curser */
function curser_focus()
{
	document.DocumentFolder_Form.doc_folder_id.focus();
}


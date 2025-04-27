function fetchResultPage()
{
	var patient_id        = document.forms[0].patient_id.value;
	var encounter_id      = document.forms[0].encounter_id.value;
	var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
	var fields = new Array(document.forms[0].patient_id);
	var names  = new Array(getLabel('Common.patientId.label','common'));
	if(checkFields(fields,names,parent.messageFrame))
	{
		parent.QFMFEDResultFrame.location.href="../../eFM/jsp/QueryFMFileEncounterDetailsResult.jsp?file_type_appl_yn="+file_type_appl_yn+"&encounter_id="+encounter_id+"&patient_id="+patient_id;
		parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
}
function clearPage()
{
	//if(document.getElementById("tab").style.visibility == 'visible') <!--Below commented by Mano Aganist ML-MMOH-SCF-0761 -->
		//document.getElementById("tab").style.visibility = 'hidden'; <!--Below commented by Mano Aganist ML-MMOH-SCF-0761 -->
	parent.QFMFEDResultFrame.location.href = '../../eCommon/html/blank.html';
	parent.messageFrame.location.href      = '../../eCommon/jsp/error.jsp';
}
function reset()
{
	QFMFEDSearchFrame.location.reload();
	QFMFEDResultFrame.location.href = '../../eCommon/html/blank.html';
	messageFrame.location.href      = '../../eCommon/jsp/error.jsp';
}

async function patientSearch()
	{
				var patient_id	= await PatientSearch('','','','','','','Y','','','OTHER');
				if(patient_id != null)
				{
					document.forms[0].patient_id.value = patient_id;
					document.forms[0].patient_id.focus();
					if(document.forms[0].encounter_id.disabled == true)
						document.forms[0].encounter_id.disabled = false;
					if(document.forms[0].encounter_id_search.disabled == true)
						document.forms[0].encounter_id_search.disabled = false;
				}
	}
function clearEnctr()
{
				var patient_id = document.forms[0].patient_id.value;
				document.forms[0].encounter_id.value = '';
				if(patient_id != '')
				{
					if(document.forms[0].encounter_id.disabled == true)
						document.forms[0].encounter_id.disabled = false;
					if(document.forms[0].encounter_id_search.disabled == true)
						document.forms[0].encounter_id_search.disabled = false;
				}
				else
				{
					document.forms[0].encounter_id.disabled = true;
					document.forms[0].encounter_id_search.disabled = true;
				}
}
async function callSearchScreen(val)
	{
				if(val == 'E')
				{
					var retVal = new String();
					var dialogHeight = "80vh" ;//23.4
					var dialogWidth  = "70vw" ;//40
					var dialogTop    = "0px";//65
					var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
					var arguments;
					var file_no;
					var file_type;
					var patient_id = document.forms[0].patient_id.value;
					retVal = await window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?called_from=file_encounter&file_no="+file_no+"&file_type="+file_type+"&patient_id="+patient_id,arguments,features);
					if(retVal != null)
					{
						retVal = retVal.split("|");
						document.forms[0].encounter_id.value = retVal[0];
					}
				}
	}

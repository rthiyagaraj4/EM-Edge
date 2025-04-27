function submitPrevNext(fromRecordNumber, toRecordNumber)
{
    document.forms[0].previousRecord.value = fromRecordNumber;
    document.forms[0].nextRecord.value = toRecordNumber; 
    document.forms[0].submit();
}		
function searchResult(volume_no, file_no, patientid)
{
	
	var doc_or_file			= '';
	if(parent.searchFrame.document.forms[0].doc_or_file)
	{
	doc_or_file				= parent.searchFrame.document.forms[0].doc_or_file.value;
	}
	var criteria		    = file_no;
	var facility			= parent.searchFrame.document.forms[0].facility.value;
	var currStatDesc		= parent.searchFrame.document.forms[0].currStatDesc.value;
	var currIdDesc			= parent.searchFrame.document.forms[0].currIdDesc.value;
	var Curr_locn_desc		= parent.searchFrame.document.forms[0].Curr_locn_desc.value;
	var	validFile			= parent.searchFrame.document.forms[0].validFile.value;
	var appointmentDays		= parent.searchFrame.document.forms[0].appointmentDays.value;
	var bookingDays			= parent.searchFrame.document.forms[0].bookingDays.value;
	var file_type_appl_yn	= parent.searchFrame.document.forms[0].file_type_appl_yn.value;

	if(doc_or_file == 'D')
	{		parent.frames[3].document.location.href='../../eFM/jsp/QueryFMCurrentDocStatusResult.jsp?&criteria=' + criteria + '&facility=' + facility + '&patientid=' +  patientid +
	 '&facility='+facility+'&volume_no='+ volume_no+'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc +
	 '&appointmentDays=' + appointmentDays+'&bookingDays='+bookingDays;
	}
	else
	{	
		if(volume_no == '')
		{
		parent.frames[3].document.location.href='../../eCommon/html/blank.html';
		}
		else
		{
		parent.frames[3].document.location.href='../../eFM/jsp/QueryFMCurrentFileStatusResult.jsp?&criteria=' + criteria + '&facility=' + facility + '&patientid=' +  patientid +
	 '&facility='+facility+'&volume_no='+ volume_no+'&currStatDesc=' + currStatDesc +'&currIdDesc=' + currIdDesc+'&Curr_locn_desc=' + Curr_locn_desc +
	 '&appointmentDays=' + appointmentDays+'&bookingDays='+bookingDays;
		}
	}
	
}
function focusing()
{
	document.forms[0].patient_id.focus();		
}


function callPatientSearch()
{
	var pat_id =  PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null)
	{
		listDocsCriteria.patient_id.value = pat_id;
		listDocsCriteria.patient_id.focus();
		
	}
}
 function callSearchScreen(val){
        if(val=='E')
        {
            var retVal =    new String();
            var dialogHeight = "23.4" ;
            var dialogWidth  = "40" ;
            var dialogTop    = "65";
            var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
            var arguments   = "" ;			
			var file_no = "";
			var file_type = ""; 	
	
			var volume_no = "";
			var patient_id = document.listDocsCriteria.patient_id.value
            
			retVal = window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?file_no="+file_no+"&file_type="+file_type+"&patient_id="+patient_id,arguments,features);

            if(retVal != null)
            {
                retVal = retVal.split("|");
                document.listDocsCriteria.encounter_id.value = retVal[0];
                document.listDocsCriteria.encounter_id.focus();
				generateDynamicValues(patient_id,retVal[0]);
            }
        }
    }
function validSplchars1(obj)
	{	
		var val = obj.value.toUpperCase();			
		obj.value = val;	
		var fields=new Array();
		var names=new Array();
		fields[0]=obj;
		names[0]=getLabel('Common.encounterid.label','common');
		if(SpecialCharCheck( fields, names,'',"A",''))
			return true;
		else
		{
			obj.select();
			obj.focus();
			return false;
		}
}

function generateDynamicValues(patientId,encounter_id)
{	
	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dummy_form' id='dummy_form' method='post' action=\"../../eFM/jsp/QueryListDocumentsTemp.jsp?patient_id="+patientId+"&encounter_id="+encounter_id+" \"> </form></body></html>";
	parent.frames[3].document.write(HTMLVal);
	parent.frames[3].document.dummy_form.submit();

}
function searchData()
{
	var encounter_id = document.listDocsCriteria.encounter_id.value;
	var patient_id = document.listDocsCriteria.patient_id.value;
	var doc_folder_id = document.listDocsCriteria.doc_folder_id.value;
	var search_by = document.listDocsCriteria.search_by.value;

	var fields = new Array();
	var names = new Array();
	fields[fields.length] = listDocsCriteria.patient_id;
	names[names.length] = getLabel('Common.patientId.label','common');
	fields[fields.length] = listDocsCriteria.encounter_id;
	names[names.length] = getLabel('Common.patientId.label','common');
	fields[fields.length] = listDocsCriteria.search_by;
	names[names.length] = getLabel('Common.searchby.label','common');

	listDocsCriteria.search_button.disabled=true;

	if(parent.frames[1].checkFields( fields, names, parent.messageFrame)) 
	{
		parent.frames[2].location.href = "../../eFM/jsp/QueryListDocumentsDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&doc_folder_id="+doc_folder_id+"&search_by="+search_by;
		listDocsCriteria.search_button.disabled	=	true;
	}
	else
	{
		
		parent.frames[2].location.href = '../../eCommon/html/blank.html';
		listDocsCriteria.search_button.disabled	=	false;
	}
}
function reset()
{
	searchFrame.document.forms[0].search_button.disabled = false;
	searchFrame.document.location.reload();
	resultFrame.document.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}


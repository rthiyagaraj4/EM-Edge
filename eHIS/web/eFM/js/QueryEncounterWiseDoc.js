function submitPrevNext(fromRecordNumber, toRecordNumber)
{
    document.forms[0].previousRecord.value = fromRecordNumber;
    document.forms[0].nextRecord.value = toRecordNumber; 
    document.forms[0].submit();
}

function callPatientSearch()
{
	var pat_id =  PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null)
	{
		encounterDocsCriteria.patient_id.value = pat_id;
		encounterDocsCriteria.patient_id.focus();		
	}
}
 async function callSearchScreen(val){
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
			var patient_id = document.encounterDocsCriteria.patient_id.value
            
			retVal =await window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?file_no="+file_no+"&file_type="+file_type+"&patient_id="+patient_id,arguments,features);

            if(retVal != null)
            {
                retVal = retVal.split("|");
                document.encounterDocsCriteria.encounter_id.value = retVal[0];
                document.encounterDocsCriteria.encounter_id.focus();
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

function searchData()
{
	var encounter_id = document.encounterDocsCriteria.encounter_id.value;
	var patient_id = document.encounterDocsCriteria.patient_id.value;
	var fields = new Array();
	var names = new Array();
	fields[fields.length] = encounterDocsCriteria.patient_id;
	names[names.length] = getLabel('Common.patientId.label','common');
//	fields[fields.length] = encounterDocsCriteria.encounter_id;
//	names[names.length] = "Encounter ID";

	encounterDocsCriteria.search_button.disabled=true;

	if(parent.frames[1].checkFields( fields, names, parent.messageFrame)) 
	{
		parent.frames[2].location.href = "../../eFM/jsp/QueryEncounterWiseDocDetails.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id;
		encounterDocsCriteria.search_button.disabled	=	true;
	}
	else
	{
		
		parent.frames[2].location.href = '../../eCommon/html/blank.html';
		encounterDocsCriteria.search_button.disabled	=	false;
	}
}

function reset()
{
	searchFrame.document.forms[0].search_button.disabled = false;
	searchFrame.document.location.reload();
	resultFrame.document.location.href="../../eCommon/html/blank.html";
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
}

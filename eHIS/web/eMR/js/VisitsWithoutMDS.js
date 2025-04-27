
function clear_list(obj){
	while(obj.options.length > 0){
		obj.remove(obj.options[0]);
	}
}
function clearScreen()
{
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	parent.frames[2].location.href="../../eCommon/html/blank.html";
}

function submitPage()
{
	if((document.forms[0].frm_encounter_date.value == '')&&(document.forms[0].to_encounter_date.value == ''))
	{
		var obj=getMessage('CAN_NOT_BE_BLANK','Common')
		obj=obj.replace("$",getLabel("Common.encounterdate.label","common_labels"))
		alert(obj);
		document.forms[0].frm_encounter_date.focus();
		parent.frames[2].location.href="../../eCommon/html/blank.html";
		parent.frames[3].location.href= "../../eCommon/jsp/error.jsp";

	}
	else
	{
	var facility_id=document.forms[0].facility_id.value;
	var encounter_id=document.forms[0].encounter_id.value;
	var patient_id=document.forms[0].PatientId.value;
	var enc_type=document.forms[0].enc_type.value;
	var loc_type=document.forms[0].location_sel.value;
	var frm_encounter_date=convertDate(document.forms[0].frm_encounter_date.value,'DMY',localeName,'en');
	var to_encounter_date=convertDate(document.forms[0].to_encounter_date.value,'DMY',localeName,'en');
	var	min_dataset=document.forms[0].min_dataset_type.value;
	
	

		parent.frames[2].location.href="../../eMR/jsp/vwVisitWithoutMDSResult.jsp?p_facility_id="+facility_id+"&p_encounter_id="+encounter_id+"&p_patient_id="+patient_id+"&p_patient_class="+enc_type+"&p_locn_type="+loc_type+"&p_fr_vst_date="+frm_encounter_date+"&p_to_vst_date="+to_encounter_date+"&min_dataset="+min_dataset;
	}
}

function reset()
{
	parent.frames[2].document.location.reload();
}



async function callSearchScreen()
{
	var patientid= await PatientSearch('','','','','','','Y','','','VIEW');
	
		if(patientid !=null)
		document.forms[0].PatientId.value = patientid; 
		document.forms[0].PatientId.focus();
	
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO',"IP"));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

function selLocation(obj)
{
	

	clear_list(document.forms[0].location_sel); 

	optSel	= document.createElement("OPTION");
	optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
	optSel.value= '';
	document.forms[0].location_sel.add(optSel);
	var enc_type_val = obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "enc_type="+enc_type_val;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","vwVisitWithoutMDSLocation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	
	if(retVal.length>1){
		var retVal_arr = retVal.split("~");
		for(var i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			var element 	= document.createElement('OPTION') ;
			element.value 	= code_desc_arr[0];
			element.text 	= code_desc_arr[1] ;
			document.forms[0].location_sel.add(element);
		}
	}
	parent.frames[2].location.href="../../eCommon/html/blank.html";
	parent.frames[3].location.href= "../../eCommon/jsp/error.jsp";
	
	
}

function ComparePeriodFromToTime(from,to)
{
	var frdt = from.value;
	var tdt = to.value;

	if(frdt !='' && tdt !='' )
	{
		if(validDate(frdt,"DMY","en") && validDate(tdt,"DMY","en"))
		{
			var fromDt	= convertDate(frdt,"DMY",localeName,"en");
			var toDt	= convertDate(tdt,"DMY",localeName,"en");

			if(!isBefore(fromDt,toDt,'DMY',localeName))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.focus();
			}
		}
	}
}

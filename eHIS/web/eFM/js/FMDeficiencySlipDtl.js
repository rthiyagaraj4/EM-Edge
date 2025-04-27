async function callPatientSearch()
{
	var pat_id =  await PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null)
	ManualEntry_form.patientid.value = pat_id;
	ManualEntry_form.patientid.focus();
}


function CheckPatientExists(ObjVal)
{	
	if(ObjVal != "") {
		var facility = ManualEntry_form.p_facility_id.value;
		var file_type_yn = ManualEntry_form.file_type_yn.value;
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckPatientExists.jsp?Patient="+ObjVal+"&Facility="+facility+"&file_type_yn="+file_type_yn+" \"> </form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.forms[0].submit();
	}	else {
				if(document.forms[0].fileno) {
					removeitems(document.forms[0].fileno);
					removeitems(document.forms[0].volumeno);	
				}
			}
}	

function CheckFileExists(ObjVal)
{
	if(ObjVal != "")
	{
		var facility = ManualEntry_form.p_facility_id.value;
		var patient_id = document.forms[0].patientid.value; 
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckFileExists.jsp?FileNo="+ObjVal+"&patient_id="+patient_id+"&Facility="+facility+" \"> </form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.forms[0].submit();
	}else{
removeitems(document.forms[0].volumeno);	
	}
}
//specific to deficiency slip-----starts
function disbutt(obj)
{
 if (obj.value!="")
		document.forms[0].encounter_id.disabled=false;
 else
		document.forms[0].encounter_id.disabled=true;
}

function CheckNumVal(obj)
{
	if (parseInt(obj.value) <= 0)
	{
		alert(getMessage('IP_VAL_NOT_LESS_ZERO','IP'));
		obj.select();
	}
	else
	{
		CheckNum(obj);
	}
}

async function searchCode(obj,target)
{
		var retVal = 	new String();
		var dialogHeight	= "85vh" ;
		var dialogWidth	= "55vw" ;
		var dialogTop		= "10" ;
		var features		= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var fileno    ="";
		var called_from=document.forms[0].called_from.value;
		if(document.forms[0].fileno !=undefined)
	  {
        fileno=document.forms[0].fileno.value;
	  }
		var patientid = document.forms[0].patientid.value;
		var volume_no="";
		if(document.forms[0].volumeno)
	  {
	volume_no=document.forms[0].volumeno.value;
	}
		
		var file_type_appl_yn=document.forms[0].file_type_yn.value;
					
		var file_type = "";		
		retVal =await window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?file_no="+fileno+"&file_type="+file_type+"&called_from="+called_from+"&patient_id="+patientid+"&volume_no="+volume_no+"&file_type_appl_yn="+file_type_appl_yn,arguments,features);
		if(retVal !=null)
			target.value = retVal;
			target.focus();
}

//specific to deficiency slip-----ends	

 function reset()
 {
	searchResultFrame.document.location.reload();
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';

 }

function run()
{ 	

	var fields = new Array();
	var names = new Array();
	
	fields[fields.length] = searchResultFrame.document.forms[0].patientid;
	fields[fields.length] = searchResultFrame.document.forms[0].p_encounter_id;				

	names[names.length] = getLabel('Common.patientId.label','common');
	names[names.length] = getLabel('Common.encounterid.label','common');
	
	if(searchResultFrame.document.forms[0].fileno) {
		fields[fields.length] = searchResultFrame.document.forms[0].fileno;	
		if (searchResultFrame.document.forms[0].file_type_yn.value == "N") {			
			names[names.length] = getLabel("Common.fileno.label","common");						
		} else {			
			names[names.length] = getLabel('Common.filetype.label','common'); 					
		} 	
	} 				
							
	if(checkFields( fields, names, messageFrame)) 
	{
		searchResultFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    	searchResultFrame.document.forms[0].target="messageFrame"; 
		searchResultFrame.document.forms[0].submit();
	}
		 
}

function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}


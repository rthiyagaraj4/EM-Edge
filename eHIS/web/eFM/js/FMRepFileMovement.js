async function callPatientSearch()
{
	var pat_id =  await PatientSearch('','','','','','','Y','','','OTHER');

	if(pat_id != null)
	ManualEntry_form.patientid.value = pat_id;
}


function CheckPatientExists(ObjVal)
{	
if(ObjVal != "")
	{
		var facility = ManualEntry_form.p_facility_id.value;
		var file_type_yn = ManualEntry_form.file_type_yn.value;
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckPatientExists.jsp?Patient="+ObjVal+"&Facility="+facility+"&file_type_yn="+file_type_yn+" \"> </form></body></html>";
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.forms[0].submit();
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
		var dialogHeight	= "10" ;
		var dialogWidth	= "43" ;
		var dialogTop		= "95" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var fileno    =  document.forms[0].fileno.value;
		var patientid = document.forms[0].patientid.value;
		var file_type = "";		
		retVal = await window.showModalDialog("../../eFM/jsp/IPEncounterDisplayFrame.jsp?file_no="+fileno+"&file_type="+file_type+"&patient_id="+patientid,arguments,features);
		if(retVal !=null)
			target.value = retVal;
			target.focus();
}

//specific to deficiency slip-----ends

function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
								
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						//if(Date.parse(todt) > Date.parse(fromdt)) 
					//	if(isBefore(fromdate,todate,"DMY",localeName))
					//	{
							if( Date.parse(todt) > Date.parse(fromdt) )
							{
							var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
								}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}

 function doDateCheckto(from,today) { //args objects 1st is this object & second is the date object
 if(today.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}
    
function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						//if(Date.parse(todt) < Date.parse(fromdt))
						if(!isBefore(fromdate,todate,"DMY",localeName))
						{
							//var msg ="APP-FM0041 Date Entered should be lesser than System Date"
							var msg = getMessage("DATE_LESS_SYS_DATE","FM");
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				}
			return true;
	 }
	 return true;
}




 function reset()
 {
	searchResultFrame.document.location.reload(); 
/*	searchResultFrame.document.location.href="../../eFM/jsp/searchResultFrame.jsp"; 
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; */
 }

 function run()
 {
	
			
				if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
							searchResultFrame.document.forms[0].p_from_date)&& 
				CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
						  searchResultFrame.document.forms[0].today.value)&&
				CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
							searchResultFrame.document.forms[0].today.value))
				{
				var fields = new Array();
				fields[fields.length] = searchResultFrame.document.forms[0].patientid;
				fields[fields.length] = searchResultFrame.document.forms[0].fileno;

				if (searchResultFrame.document.forms[0].file_type_yn.value == "N") 
				{
					var names = new Array();
					names[names.length] = getLabel('Common.patientId.label','common');
					names[names.length] = getLabel("Common.fileno.label","common");
				}
				else
				{
					var names = new Array();
					names[names.length] = getLabel('Common.patientId.label','common');
					names[names.length] = getLabel('Common.filetype.label','common');
				}
				if(checkFields( fields, names, messageFrame)) {
				searchResultFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				searchResultFrame.document.forms[0].target="messageFrame";
				searchResultFrame.document.forms[0].submit(); 
					}
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


/* This function will submit to the getCreateFileComponent.jsp file for populating the file type. A parameter field4 is passed with the value 'create' for this purpose  */	


function  getCreateFileComponentValues_dummy()
{
if(parent.frames[1].document != null){
			getCreateFileComponentValues();
		}else{
			setTimeout("getCreateFileComponentValues_dummy()",05);
		}
}





function getCreateFileComponentValues()
{
	
	if(document.forms[0].fs_locn_code)
	var val1 = document.forms[0].fs_locn_code.value;
	else
	var val1 = '';
	if(document.forms[0].facility_id)
	var val2 = document.forms[0].facility_id.value;
	else
	var val2 = '';
	if(document.forms[0].recCnt)
	var val3 = document.forms[0].recCnt.value;
	else
	var val3 = '';
	if(document.forms[0].p_called_from)
	var val4 = document.forms[0].p_called_from.value;
	else
	var val4 = '';
	if(document.forms[0].install_yn)
	var val5 = document.forms[0].install_yn.value;
	else
	var val5 = '';
	if(document.forms[0].p_location_code)
	var location_code = document.forms[0].p_location_code.value;
	else
	var location_code = '';
	if (document.forms[0].file_type_appl_yn)
	var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
	else
	var file_type_appl_yn ='';
	if(document.getElementById("mr_section")!=null)
	document.getElementById("mr_section").innerHTML = '';

	var p_encounter_id = document.forms[0].p_encounter_id.value;
	var p_patient_class = document.forms[0].p_patient_class.value;
	var p_encounter_date_time = document.forms[0].p_encounter_date_time.value;

 var HTMLVal = "<form name='dum_form' id='dum_form' method='post' action='../../eMP/jsp/GetCreateFileComponentValues.jsp'>"+
								" <input type='hidden' name='field1' id='field1' value=\""+val1+"\">"+
								" <input type='hidden' name='field2' id='field2' value=\""+val2+"\">"+
								" <input type='hidden' name='field3' id='field3' value=\""+val3+"\">"+
								" <input type='hidden' name='called_from' id='called_from' value=\""+val4+"\">"+
								" <input type='hidden' name='install_yn' id='install_yn' value=\""+val5+"\">"+
								" <input type='hidden' name='Location_Code' id='Location_Code' value=\""+location_code+"\">"+
								" <input type='hidden' name='field4' id='field4' value='create'>"+
								" <input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value=\""+file_type_appl_yn+"\">"+
								" <input type='hidden' name='p_encounter_id' id='p_encounter_id' value=\""+p_encounter_id+"\">"+
								" <input type='hidden' name='p_patient_class' id='p_patient_class' value=\""+p_patient_class+"\">"+
								" <input type='hidden' name='p_encounter_date_time' id='p_encounter_date_time' value=\""+p_encounter_date_time+"\">"+
								" </form>";

	
	if(parent.frames[1].document != null)
  parent.frames[1].document.write(HTMLVal);
	//	parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	if(parent.frames[1].document.dum_form !=null && parent.frames[1].document.dum_form!=undefined)
	{
	parent.frames[1].document.dum_form.submit();  
	}
	
		
	  
  /** var create='create';
  
   var xmlHttp = new XMLHttpRequest();
				xmlHttp.open("POST","../../eMP/jsp/GetCreateFileComponentValues.jsp?field1="+val1+"&field2="+val2+"&field3="+val3+
					"&called_from="+val4+"&install_yn="+val5+"&Location_Code="+location_code+
					"&field4="+create+"&file_type_appl_yn="+file_type_appl_yn+"&p_encounter_id="+p_encounter_id+
					"&p_patient_class="+p_patient_class+
					"&p_encounter_date_time="+p_encounter_date_time,false);
			    	xmlHttp.send(null);		
			//	responseText=trimString(xmlHttp.responseText);

 /*  var create='create';
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " field1=\"" +val1 + "\"";
	xmlStr += " field2=\"" + val2 + "\"";
	xmlStr += " field3=\"" +val3+ "\"";
	xmlStr += " called_from=\"" +val4+ "\"";
	
	xmlStr += " install_yn' value=\"" +val5+ "\"";
	xmlStr += " Location_Code=\"" + location_code + "\"";
	xmlStr += " field4=\"" +create+ "\"";
	xmlStr += " file_type_appl_yn=\"" +file_type_appl_yn+ "\"";
	xmlStr += " p_encounter_id=\"" +p_encounter_id+ "\"";
	xmlStr += " p_patient_class=\"" + p_patient_class + "\"";
	mlStr += "  p_encounter_date_time=\"" +p_encounter_date_time+ "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eMP/jsp/GetCreateFileComponentValues.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	 */



}
/* This function will submit to the getCreateFileComponent.jsp file for creating the file by calling procedure. A parameter field4 is passed with the value 'submit' for this purpose  */	
function doSubmit()
{
	if (document.forms[0].fs_locn_code)
	{
		var temp = document.forms[0].fs_locn_code.value;
		if(temp=='')
			{var msg = self.getMessage("CAN_NOT_BE_BLANK","Common");
			  msg = msg.replace('$', getLabel("Common.FileStorageLocation.label","Common"));
			  alert(msg);			
		return;}
	}
	if (document.forms[0].file_type)
	{
		var temp = document.forms[0].file_type.value;
		if(temp=='')
			{ var msg = self.getMessage("CAN_NOT_BE_BLANK","Common");
			  msg = msg.replace('$', getLabel("Common.filetype.label","Common"));
			  alert(msg);	
		return;}
	}

	if (document.forms[0].facility_id)
		var p_facility_id = document.forms[0].facility_id.value;
	else 
		var p_facility_id = '';	
	
	if (document.forms[0].p_patient_id)
		var p_patient_id = document.forms[0].p_patient_id.value;
	else
		var p_patient_id = '';
	
	if (document.forms[0].p_single_or_multi_files_ind)
		var p_single_or_multi_files_ind = document.forms[0].p_single_or_multi_files_ind.value;
	else
		var p_single_or_multi_files_ind = '';
	
	if(document.forms[0].p_separate_file_no_yn)
		var p_separate_file_no_yn = document.forms[0].p_separate_file_no_yn.value;
	else
		var p_separate_file_no_yn  = '';
	
	if(document.forms[0].p_location_code)
		var p_location_code = document.forms[0].p_location_code.value;
	else
		var p_location_code = '';
	
	if (document.forms[0].p_pat_ser_grp_code)
		var p_pat_ser_grp_code = document.forms[0].p_pat_ser_grp_code.value;
	else
		var p_pat_ser_grp_code = '';
	
	if(document.forms[0].p_mr_section_type)
		var p_mr_section_type = document.forms[0].p_mr_section_type.value;
	else
		var p_mr_section_type = '';
	
	if(document.forms[0].p_mr_section_code)
		var p_mr_section_code = document.forms[0].p_mr_section_code.value;
	else
		var p_mr_section_code = '';
	
	if(document.forms[0].fs_locn_code)
		var p_fs_location_code = document.forms[0].fs_locn_code.value;
	else
		var p_fs_location_code = '';
	
	if(document.forms[0].file_type)
		var p_file_type_code = document.forms[0].file_type.value;
	else
		var p_file_type_code = '';

	if(document.getElementById("old_file_no"))
		var p_old_file_no = document.forms[0].old_file_no.value;
	else
		var p_old_file_no = '';
	
	if(document.forms[0].p_called_from)
		var p_called_from = document.forms[0].p_called_from.value;
	else
		var p_called_from = '';
	
	if (document.forms[0].file_type_appl_yn)
		var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
	else
		var file_type_appl_yn = '';

	var p_encounter_id = document.forms[0].p_encounter_id.value;
	var p_patient_class = document.forms[0].p_patient_class.value;
	var p_encounter_date_time = document.forms[0].p_encounter_date_time.value;
	var multi_files_in_same_fs_locn_yn = document.forms[0].multi_files_in_same_fs_locn_yn.value;
	
	//Added by Sangeetha for GDOH-CRF-0103
	if(document.getElementById("alt_file_no"))	
		var p_alt_file_no = document.forms[0].alt_file_no.value;
	else
		var p_alt_file_no = '';


		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eMP/jsp/GetCreateFileComponentValues.jsp'>"+
		" <input type='hidden' name='p_facility_id' id='p_facility_id' value=\""+p_facility_id+"\">"+
		" <input type='hidden' name='p_patient_id' id='p_patient_id' value=\""+p_patient_id+"\">"+
		" <input type='hidden' name='p_single_or_multi_files_ind' id='p_single_or_multi_files_ind' value=\""+p_single_or_multi_files_ind+"\">"+
		" <input type='hidden' name='p_separate_file_no_yn' id='p_separate_file_no_yn' value=\""+p_separate_file_no_yn+"\">"+
		" <input type='hidden' name='p_location_code' id='p_location_code' value=\""+p_location_code+"\">"+
		" <input type='hidden' name='p_pat_ser_grp_code' id='p_pat_ser_grp_code' value=\""+p_pat_ser_grp_code+"\">"+
		" <input type='hidden' name='p_mr_section_type' id='p_mr_section_type' value=\""+p_mr_section_type+"\">"+
		" <input type='hidden' name='p_mr_section_code' id='p_mr_section_code' value=\""+p_mr_section_code+"\">"+
		" <input type='hidden' name='p_fs_location_code' id='p_fs_location_code' value=\""+p_fs_location_code+"\">"+
		" <input type='hidden' name='p_file_type_code' id='p_file_type_code' value=\""+p_file_type_code+"\">"+
		" <input type='hidden' name='p_old_file_no' id='p_old_file_no' value=\""+p_old_file_no+"\">"+
		" <input type='hidden' name='p_called_from' id='p_called_from' value=\""+p_called_from+"\">"+
		" <input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value=\""+file_type_appl_yn+"\">"+
		" <input type='hidden' name='multi_files_in_same_fs_locn_yn' id='multi_files_in_same_fs_locn_yn' value=\""+multi_files_in_same_fs_locn_yn+"\">"+
		" <input type='hidden' name='field4' id='field4' value='submit'>"+
		" <input type='hidden' name='p_encounter_id' id='p_encounter_id' value=\""+p_encounter_id+"\">"+
		" <input type='hidden' name='p_patient_class' id='p_patient_class' value=\""+p_patient_class+"\">"+
		" <input type='hidden' name='p_encounter_date_time' id='p_encounter_date_time' value=\""+p_encounter_date_time+"\">"+
		" <input type='hidden' name='p_alt_file_no' id='p_alt_file_no' value=\""+p_alt_file_no+"\">"+       // Added by Sangeetha for GDOH-CRF-0103
		" </form></body></html>";

		parent.frames[1].document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
		
//		if (parent.frames[1].document.dum_form){
//			
//		}
		setTimeout(function() {
		    parent.frames[1].document.dum_form.submit();
		}, 1000);
		
		// parent.frames[1].document.dum_form.submit();
		// parent.parent.document.getElementById("dialog_tag").close(); 
		
}

/* Function for closing the window */	
function doClose()
{
	self.window.returnValue ='';
	self.window.close();
}

function doReturn()  {
	var retVal = "";
	if(document.getElementById("file_no"))    retVal = document.getElementById("file_no").value;
	if(document.getElementById("error_value"))    retVal +="`"+ document.getElementById("error_value").value
	else    retVal+="`"

	window.returnValue = retVal ;
	window.close();
}


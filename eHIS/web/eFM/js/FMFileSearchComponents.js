function populateDynamicValues(patientID)
{

	var volumeno_name			= document.forms[0].volumeno_name.value;
	var frame_name				= document.forms[0].frame_name.value;
	var form_name					= document.forms[0].form_name.value;
	var messageframe_name	= document.forms[0].messageframe_name.value;
	var patientid_name			= document.forms[0].patientid_name.value;
	var fileno_name				= document.forms[0].fileno_name.value;
	var filetype_name				= document.forms[0].filetype_name.value === "" ? 'file_type_code' : document.forms[0].filetype_name.value;
	var volume_no_appl_yn		= document.forms[0].volume_no_appl_yn.value;
	var file_type_function			= document.forms[0].file_type_function.value;
	var file_no_function			= document.forms[0].file_no_function.value;
	var patline_yn					= document.forms[0].patline_yn.value;
	var patline_ID					= document.forms[0].patline_ID.value;
	var facilityID						= document.forms[0].facilityID.value;
	var function_name				= document.forms[0].function_name.value;
	var file_type_appl_yn			= document.forms[0].file_type_appl_yn.value;
	var fs_location			= document.forms[0].fs_location.value;
	var file_mandatory_yn			= document.forms[0].file_mandatory_yn.value;
	var fs_location_code			="";
	var file_mov_flag			= document.forms[0].file_mov_flag.value;
	var fs_req_location ="";
	var dflt_flag="true" ;

	if(document.forms[0].fs_req_location)
	{
		fs_req_location= document.forms[0].fs_req_location.value;
	
	}
	
	if(form_name=="fm_req_criteria")
	{
	if(parent.frames[1].document.forms[0].req_location)
	fs_req_location= parent.frames[1].document.forms[0].req_location.value;
	 if(patientID!="") 
		{
	 if(parent.frames[3].document.forms[0])
	 //parent.frames[3].document.forms[0].Add.focus();
	 /*Above line commented and below line Added for this SCF AAKH-SCF-0066 [IN:040728] */  
	 if(file_type_appl_yn=="N"){
     parent.frames[3].document.forms[0].Add.click();
	 }else{
	 parent.frames[3].document.forms[0].Add.focus();
	 }
		}
	  }
	if(form_name=="FMCancelRequestCriteria_form")
	{
	if(parent.frames[1].document.forms[0].fslocation)
		{
	var fslocn=parent.frames[1].document.forms[0].fslocation.value;
	var fs_locn_code="";
	var fsarray;
	if(fslocn!="")
		{
          fsarray=fslocn.split("!");
          fs_locn_code=fsarray[0];
		}
	fs_req_location=fs_locn_code;
	}
if(patientID!="")
		{
parent.frames[2].document.forms[0].add.focus();
	}
	}
		
	if(form_name=="FileIsuueTab")
	{
	if(parent.frames[1].document.forms[0].issuetype)
	fs_req_location= parent.frames[1].document.forms[0].issuetype.value;
if(patientID!="")
		{
  parent.frames[2].document.forms[0].okbutton.focus();
	}
	
	//if(document.forms[0].fs_locn_name)
	//fs_req_location= document.forms[0].fs_locn_name.value;
	}
	if(form_name=="ManualEntry_form")
	{
	if(document.forms[0].Req_locn_code)
	fs_req_location= document.forms[0].Req_locn_code.value;
	
	if(document.forms[0].form_name.value == "ManualEntry_form")
		{
			if(document.forms[0].currfilelocn)
			document.forms[0].currfilelocn.value='';
				if(document.forms[0].filestat)
			document.forms[0].filestat.value='';
			if(document.forms[0].remarks)
			document.forms[0].remarks.value='';
			if(document.getElementById("patline"))
			document.getElementById("patline").innerText ="";
		}
	
	
	}
	
	if(form_name=="FMTransferFileCriteria_form")
	{
	if(parent.frames[1].document.forms[0].fromfslocn)
	fs_req_location=parent.frames[1].document.forms[0].fromfslocn.value;
	
	if(patientID!="")
		{
  // parent.frames[3].document.forms[0].add.focus(); 
  /*Above line commented and below line Added for this SCF AAKH-SCF-0066 [IN:040728] */  
  //parent.frames[3].document.forms[0].add.click();
  if(file_type_appl_yn=="N"){
     parent.frames[3].document.forms[0].add.click();
	 }else{
	 parent.frames[3].document.forms[0].add.focus();
	 }
  
  
	}
	
	}
	if(form_name=="FMConfirmRcptCriteria_form")
	{
	if(parent.frames[1].document.forms[0].fslocation)
	{
	var fslocn=parent.frames[1].document.forms[0].fslocation.value;
	var fs_locn_code="";
	var fsarray;
	if(fslocn!="")
		{
          fsarray=fslocn.split("!");
          fs_locn_code=fsarray[0];
		}
	fs_req_location=fs_locn_code;
	}
	
	if(patientID!="")
		{ 
 
  parent.frames[2].document.forms[0].add.click();
	}
	
	}
	if(form_name=="FMReceiveFileMRDSearch")
	{
	if(parent.frames[1].document.forms[0].p_curr_fs_loc)
	 fs_req_location=parent.frames[1].document.forms[0].p_curr_fs_loc.value;
  if(patientID!="")
		{
  if(parent.frames[2].document.forms[0].Add)
   parent.frames[2].document.forms[0].Add.focus();
	}
	
	}
	
	if(form_name=="FMChFileRetDateCriteriaForm")
	{
	if(document.forms[0].p_curr_fs_loc)
   fs_req_location=document.forms[0].p_curr_fs_loc.value;
	}
	if(form_name=="FMChngStrLocnCriteriaForm")
	{
	if(document.forms[0].fs_locn_code)
   fs_req_location=document.forms[0].fs_locn_code.value;
	if(patientID!="")
		{
if(document.forms[0].search_dtl)
 document.forms[0].search_dtl.focus();
			
	}
	}
	if(form_name=="fm_lost_found_criteria")
	{
	if(document.forms[0].f_curr_fs_locn)
	 fs_req_location=document.forms[0].f_curr_fs_locn.value;
	}
	if(form_name=="FileDeficiencyMonitoring_header")
	{
	if(document.forms[0].cuurfslocn)
	 fs_req_location=document.forms[0].cuurfslocn.value;
	}
	if(form_name=="FMReturnToMRDCriteriaForm")
	{
	 fs_req_location=document.forms[0].fs_req_location.value;
	if(patientID!="")
		{
  if(document.forms[0].add_button)
   document.forms[0].add_button.focus();
	}
	}
	if(form_name=="ConfirmPullingListForm")
	{
	 fs_req_location=document.forms[0].fs_locn_code.value;
	if(patientID!="")
		{
if(document.forms[0].Add)
 document.forms[0].Add.focus();
}
	}
	
	
	
	if(patientID != "")
	{
		if(document.forms[0].chk_flag.value != "N")
		{
			var patient_file_type = document.forms[0].patient_file_type.value;
			var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form' id='Dummy_Form' action='../../eFM/jsp/FMFileSearchComponent.jsp' method='POST'><input type='Hidden' name='patientID' id='patientID' value = '"+patientID+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value = '"+file_type_appl_yn+"'><input type='Hidden' name='frame_name' id='frame_name' value = '"+frame_name+"'><input type='Hidden' name='form_name' id='form_name' value = '"+form_name+"'><input type='Hidden' name='messageframe_name' id='messageframe_name' value = '"+messageframe_name+"'><input type='Hidden' name='patientid_name' id='patientid_name' value = '"+patientid_name+"'><input type='Hidden' name='operation' id='operation' value = 'FILE_VOLUME'><input type='Hidden' name='fileno_name' id='fileno_name' value = '"+fileno_name+"'><input type='Hidden' name='filetype_name' id='filetype_name' value = '"+filetype_name+"'><input type='Hidden' name='volumeno_name' id='volumeno_name' value = '"+volumeno_name+"'><input type='Hidden' name='volume_no_appl_yn' id='volume_no_appl_yn' value='"+volume_no_appl_yn+"'><input type='Hidden' name='file_no_function' id='file_no_function' value='"+file_no_function+"'><input type='Hidden' name='file_type_function' id='file_type_function' value='"+file_type_function+"'><input type='Hidden' name='patline_yn' id='patline_yn' value = '"+patline_yn+"' ><input type='Hidden' name='patline_ID' id='patline_ID' value = '"+patline_ID+"' ><input type='Hidden' name='patient_file_type' id='patient_file_type' value='"+patient_file_type+"'><input type='Hidden' name='function_name' id='function_name' value = '"+function_name+"'><input type='Hidden' name='facilityID' id='facilityID' value = '"+facilityID+"' ><input type='Hidden' name='fs_location' id='fs_location' value = '"+fs_location+"' ><input type='Hidden' name='file_mov_flag' id='file_mov_flag' value = '"+file_mov_flag+"' ><input type='Hidden' name='fs_req_location' id='fs_req_location' value = '"+fs_req_location+"'><input type='Hidden' name='dflt_flag' id='dflt_flag' value = '"+dflt_flag+"'><input type='hidden' name='file_mandatory_yn' id='file_mandatory_yn' value = '"+file_mandatory_yn+"'></form></body></html>";

		//eval(messageframe_name).document.body.insertAdjacentHTML('afterbegin',HTMLValue);
			eval(messageframe_name).document.write(HTMLValue);
			eval(messageframe_name).document.Dummy_Form.submit();
			
			/* below line Added for this SCF AAKH-SCF-0066 [IN:040728] */
           if(form_name=="FMTransferFileCriteria_form" && file_type_appl_yn=="N")
          {
          setTimeout("parent.frames[3].document.forms[0].add.click();",500) 
           }if(form_name=="fm_req_criteria" && file_type_appl_yn=="N"){
		   setTimeout("parent.frames[3].document.forms[0].Add.click();",500)
		  }
		  //if(form_name=="FMReturnToMRDCriteriaForm"){  
		   //setTimeout("document.forms[0].add_button.click();",500)
		 // }
			
			
			}else document.forms[0].chk_flag.value = "";

			/* below line Added for this SCF RUT-SCF-0353 [IN:046538] */
			if(document.forms[0].Add && fs_req_location!=""  && form_name=="fm_lost_found_criteria"){ 
				 setTimeout("document.forms[0].Add.click();",500) 
			}
			/*46538 End*/
	}
	else
	{
		document.forms[0].patient_file_type.value		= "";
		document.forms[0].patient_file_type_desc.value	= "";
	
		if(file_type_appl_yn == "N")
		{
		  if(form_name=="fm_req_criteria")
	    {
	document.getElementById("FileNo").innerHTML = "<input type='Text' name='p_file_no' id='p_file_no' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);getPatIDVolume(this.value);file_no_function' maxLength='20' size='20'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
	  }else if(form_name=="FMChngStrLocnCriteriaForm"){
		
		document.getElementById("FileNo").innerHTML = "<input type='Text' name='file_no' id='file_no' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);getPatIDVolume(this.value);file_no_function' maxLength='20' size='20'>";
	  }else{
		var fileNoTxt	= "<input type='Text' name='file_no' id='file_no' value='' onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this);getPatIDVolume(this.value);file_no_function' maxLength='20' size='20'> ";
		if(file_mandatory_yn	  == "Y"){
			fileNoTxt	+= "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
		}
	   document.getElementById("FileNo").innerHTML = fileNoTxt;
	  }
		}
		else if(file_type_appl_yn == "Y")
		{

		  if(form_name=="FMConfirmRcptCriteria_form" || form_name=="FMCancelRequestCriteria_form" ||  form_name=="FileDeficiencyMonitoring_header" || form_name=="FMLinkEncounterQueryForm" || form_name=="FMCreateFileVolumeSearchForm") {

			var fileTypeTxt	= "<input type='Text' name='file_type_code' id='file_type_code' value='' onBlur='file_type_function' readonly>";
			if(file_mandatory_yn	  == "Y"){
				fileTypeTxt += "<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
			}
			
			document.getElementById("FileType").innerHTML = fileTypeTxt;
		  }else{

			document.getElementById("FileType").innerHTML = "<input type='Text' name='filetype_name' id='filetype_name' value='' onBlur='file_type_function' readonly>";
		  }
		
		}

		if(volume_no_appl_yn == "Y")
		{
			var frame_name1		= document.forms[0].frame_name1.value;
			if(frame_name=="parent.frames[1].FMConfirmPullingListCriteriaFrame")
			{
                 frame_name="parent.frames[0]";
			}
			if(frame_name1 == 'parent')
			
			{//This is for call having one layer of frame
			
				var selectBox   =
				eval(frame_name+".document."+form_name+"."+volumeno_name);
				var seletLen	=	Math.abs(selectBox.length);
				for (i=0; i<seletLen; i++)
					selectBox.remove(0);
				var selectOption	=  eval(frame_name).document.createElement("OPTION");		
				selectOption.value	=	"";
				selectOption.text	=	"-" +getLabel('Common.defaultSelect.label','common')+ "-";
				selectBox.add(selectOption);
			}
			else
			{//This is for call having two layer of frames

				var selectBox   =
				eval(frame_name1+".document."+form_name+"."+volumeno_name);
				var seletLen	=	Math.abs(selectBox.length);
				for (i=0; i<seletLen; i++)
					selectBox.remove(0);
				var selectOption	=  eval(frame_name1).document.createElement("OPTION");		
				selectOption.value	=	"";
				selectOption.text	=	"-" +getLabel('Common.defaultSelect.label','common')+ "-";
				selectBox.add(selectOption);
			}
		}
		if(patline_yn == "Y")
		{
			eval(frame_name+".document"+patline_ID).innerHTML="&nbsp;";
		}
	}
}
function populateFileVolume(patientID,fileNo,FileType)
{
	
   var volumeno_name			= document.forms[0].volumeno_name.value;
	var frame_name				= document.forms[0].frame_name.value;
	var form_name				= document.forms[0].form_name.value;
	var messageframe_name		= document.forms[0].messageframe_name.value;
	var patientid_name			= document.forms[0].patientid_name.value;
	var fileno_name				= document.forms[0].fileno_name.value;
	var filetype_name			= document.forms[0].filetype_name.value;
	var volume_no_appl_yn		= document.forms[0].volume_no_appl_yn.value;
	var file_type_function		= document.forms[0].file_type_function.value;
	var file_no_function		= document.forms[0].file_no_function.value;
	var patline_yn				= document.forms[0].patline_yn.value;
	var patline_ID				= document.forms[0].patline_ID.value;
	var facilityID				= document.forms[0].facilityID.value;
	var function_name			= document.forms[0].function_name.value;
	var file_type_appl_yn		= document.forms[0].file_type_appl_yn.value;
	var fs_req_location ="";
	if(document.forms[0].fs_req_location)
	{
		fs_req_location= document.forms[0].fs_req_location.value;
	}
	var patient_file_type	=	document.forms[0].patient_file_type.value;
	var file_mov_flag	=	document.forms[0].file_mov_flag.value;
	
	
	if(	FileType=="" && form_name!="FMChFileRetDateCriteriaForm")
	{
     if(parent.frames[2].document.forms[0] !=null)
		{
	 if(parent.frames[2].document.forms[0].currfilelocn)
	 parent.frames[2].document.forms[0].currfilelocn.value="";
     if(parent.frames[2].document.forms[0].filestat)
	 parent.frames[2].document.forms[0].filestat.value="";
		if(parent.frames[2].document.forms[0].remarks)
			{
		parent.frames[2].document.forms[0].remarks.readOnly=true;
		parent.frames[2].document.forms[0].remarks.value = "";
			}
		}
	}
	var fileTypeno="";
	if (file_type_appl_yn == "Y")
	{
		var fileType =	FileType;	
	  fileTypeno=FileType;
	}
	if (file_type_appl_yn == "N")
	{
  if(document.forms[0].file_no)
  fileTypeno=document.forms[0].file_no.value;
 if(document.forms[0].p_file_no)
  fileTypeno=document.forms[0].p_file_no.value;
	}

	if(fileTypeno !="" || fileNo!="")
	{
   
   
   var HTMLValue = "<html><body onKeyDown = 'lockKey()'><form name='Dummy_Form1' id='Dummy_Form1' action='../../eFM/jsp/FMFileSearchComponent.jsp' method='POST'><input type='Hidden' name='patientID' id='patientID' value = '"+patientID+"'><input type='Hidden' name='fileNo' id='fileNo' value = '"+fileNo+"'><input type='Hidden' name='fileType' id='fileType' value = '"+fileType+"'><input type='Hidden' name='operation' id='operation' value = 'FILE_VOLUME'><input type='Hidden' name='frame_name' id='frame_name' value = '"+frame_name+"'><input type='Hidden' name='form_name' id='form_name' value = '"+form_name+"'><input type='Hidden' name='messageframe_name' id='messageframe_name' value = '"+messageframe_name+"'><input type='Hidden' name='patientid_name' id='patientid_name' value = '"+patientid_name+"'><input type='Hidden' name='fileno_name' id='fileno_name' value = '"+fileno_name+"'><input type='Hidden' name='filetype_name' id='filetype_name' value = '"+filetype_name+"'><input type='Hidden' name='volumeno_name' id='volumeno_name' value = '"+volumeno_name+"'><input type='Hidden' name='volume_no_appl_yn' id='volume_no_appl_yn' value='"+volume_no_appl_yn+"'><input type='Hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='"+file_type_appl_yn+"'><input type='Hidden' name='file_no_function' id='file_no_function' value='"+file_no_function+"'><input type='Hidden' name='file_type_function' id='file_type_function' value='"+file_type_function+"'><input type='Hidden' name='patient_file_type' id='patient_file_type' value='"+patient_file_type+"'><input type='Hidden' name='facilityID' id='facilityID' value = '"+facilityID+"' ><input type='Hidden' name='file_mov_flag' id='file_mov_flag' value = '"+file_mov_flag+"' ><input type='Hidden' name='fs_req_location' id='fs_req_location' value = '"+fs_req_location+"' ></form></body></html>";
	eval(messageframe_name).document.write(HTMLValue);
	eval(messageframe_name).document.Dummy_Form1.submit();
	}else{
 	
	
	
	if(document.forms[0].volume_no)
		{
	    removeitems(document.forms[0].volume_no);
		
		}

	 if(document.forms[0].volume_no)
		{
	  var selectBox		= document.forms[0].volume_no;
	  var selectOption	=document.createElement("OPTION");
	  selectOption.value	=	"";
	  selectOption.text	=	"-----"+getLabel('Common.defaultSelect.label','common')+"-----";
	 selectBox.add(selectOption);
		}


/*	if(document.getElementById("volno"))
		{
		document.getElementById("volno").innerHTML="<select name=volume_no ><option value=''>-----"+getLabel("Common.defaultSelect.label","common")+"-----</select>";
		
		}  */
		
	}
	/*if(form_name=='ManualEntry_form')
	{
		CheckPatientExists(patientID);
	}*/

}
//////************* the function setValues is called on change of "File Type" *************/////////






function setValues(objectValue)
{
	document.forms[0].patient_file_type.value		= objectValue;
//	document.forms[0].patient_file_type_desc.value	= objectValue;


}
//////////////********************* end of setValues function ***********************//////////////

function 	clearval(patient_id) {
 
   var function_name				= document.forms[0].function_name.value;
  
   if (patient_id.value==" ")
	{
	removeitems(document.forms[0].file_type);	
		
		if(function_name=='FileDeficiencyMonitoring')
		{
		FileDeficiencyMonitoring_header.encounter_id.disabled	=	true;
		FileDeficiencyMonitoring_header.encounter_id_search.disabled	=	true;
		}

		if (document.forms[0].file_type_code)
		{
			document.forms[0].file_type_code.value		= "";
		}
		if (document.forms[0].file_type_code)
		{
			document.forms[0].file_type_code.value		= "";
		}
		else
		if (document.forms[0].file_type)
		{
			document.forms[0].file_type.value		= "";
		}
		if (document.forms[0].file_no)
		{
			document.forms[0].file_no.value	= "";
		}
		if (document.forms[0].encounter_id)
		{
			document.forms[0].encounter_id.value= "";
		}	
		//document.forms[0].volume_no.value		= "";
		document.forms[0].patient_file_type_desc.value	= "";
		document.forms[0].patient_file_type.value	= "";
		if(document.getElementById("volno"))
		document.getElementById("volno").innerHTML="<select name=volume_no ><option value=''>-----"+getLabel("Common.defaultSelect.label","common")+"-----</select>";

		if(document.forms[0].form_name.value == "ManualEntry_form")
		{
			document.forms[0].currfilelocn.value='';
			//document.forms[0].filestat.value='';
			//document.forms[0].remarks.value='';
			//document.getElementById("patline").innerText ="";
		}
	}
	else
	{
		if(document.forms[0].chk_flag1.value != "Y")
		{
			populateDynamicValues(patient_id.value);
		}
	}
	document.forms[0].chk_flag1.value = "N"
}	

function Clearencou(obj)
{
    if (document.forms[0].encounter_id)
		{
			document.forms[0].encounter_id.value= "";
		}	

}
function removeitems(obj)
{
	var len=obj.length;
	var i=0;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}
async function callSearchScreen(){
	var patientid=await PatientSearch('','','','','','','Y','','','OTHER');
	if(patientid !=null)
	document.forms[0].patient_id.value = patientid;
	 document.forms[0].patient_id.focus();
}

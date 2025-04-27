function apply() {
	var to_proceed;
	var p_rec_count=0;
	if(transfer_criteria.document.forms[0] != null) {
		maintain_doc_or_file = transfer_criteria.document.forms[0].p_maintain_doc_or_file.value;
		if(maintain_doc_or_file == 'F') {
			if(parent.frames[2].frames[4].document.forms[0]) {
				var totalrecs = parent.frames[2].frames[4].document.forms[0].count.value;
				var confirmyn;
				var filelist ="";
				var volumelist ="";
				for(i = 1;i <= totalrecs;i++) {
					if(eval("parent.frames[2].frames[4].document.forms[0].confirm"+i+".disabled") == false) {
						bool =	eval("parent.frames[2].frames[4].document.forms[0].confirm"+i+".checked");
						if(bool == true) {
							p_rec_count++;
						}
					}}
				if(p_rec_count>0){
					to_proceed = true;
				}
				else {
					to_proceed = false;
				}	
				if(to_proceed == true) {	
					for(var cnt=1;cnt <= totalrecs;cnt++) {
						confirmyn = eval("parent.frames[2].frames[4].document.forms[0].confirm"+cnt+".checked");
						if(confirmyn == true) {
							if(filelist.length == 0) {
								filelist = eval("parent.frames[2].frames[4].document.forms[0].file"+cnt+".value");
								
								if(eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value");
								
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].volume"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value");
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tolocns"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value");					
								
																	
								//Added for this CRF HSA-CRF-0306.1	
                                if(eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value");
									
                              	if(eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value");
									
								if(eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value");	
								//End HSA-CRF-0306.1
								if(eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value") !="")
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value");
						      else
							 filelist += "|"+null;
							
							}
							else {
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].file"+cnt+".value");
								
								if(eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value");
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].volume"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value");
													
								if(eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
									else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value");
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tolocns"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value");
										
							//Added for this CRF HSA-CRF-0306.1	
                                if(eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value");
									
                              	if(eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value");
									
								if(eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value");
                                 									
								//End HSA-CRF-0306.1
                            							
							if(eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value") !="")
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value");
							else
							 filelist += "|"+null;
							}
						}
										
					}
									
					
					parent.frames[2].frames[4].document.forms[0].FileList.value = filelist;
					parent.frames[2].frames[4].document.forms[0].FromLocnCode.value = parent.frames[2].frames[1].document.forms[0].fromfslocn.value;
					parent.frames[2].frames[4].document.forms[0].TransferUserId.value = parent.frames[2].frames[1].document.forms[0].transferredby.value;
					parent.frames[2].frames[4].document.forms[0].iss_remarks.value = parent.frames[2].frames[1].document.forms[0].p_remarks.value;
					parent.frames[2].frames[4].document.forms[0].resultPage_file_trans_mode.value = parent.frames[2].frames[1].document.forms[0].Hiddenfile_transport_mode.value;
					parent.frames[2].frames[4].document.forms[0].resultPage_carried_by_name.value = parent.frames[2].frames[1].document.forms[0].Hiddencarried_by_name.value;
						
					var fields = new Array ( parent.frames[2].frames[1].document.forms[0].transferredby  );
					var names = new Array ( getLabel("Common.TransferredBy.label","Common") );
					if(parent.frames[2].frames[1].checkFields( fields, names, parent.frames[1].messageFrame) && filelist != "") {
						parent.frames[2].frames[4].document.forms[0].submit();
					}
				}
				else if(to_proceed == false) {
					var	messag = getMessage("NO_FILE_FOR_TRANSFER","FM");
					parent.frames[2].frames[5].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
				}
			}
			else {
				// below code add for 19597date:Friday, February 26, 2010

				var	messag = getMessage("NO_FILE_FOR_TRANSFER","FM");
					parent.frames[2].frames[5].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
			}
		}
		else if(maintain_doc_or_file == 'D') {
			if(parent.frames[2].frames[4].document.forms[0]) {
				var totalrecs = parent.frames[2].frames[4].document.forms[0].count.value;
				var confirmyn;
				var filelist ="";
				var docfolderlist ="";
				var doctypelist ="";
				var volumelist ="";
				for(i = 1;i <= totalrecs;i++) {
					if(eval("parent.frames[2].frames[4].document.forms[0].confirm"+i+".disabled") == false) {
						bool =	eval("parent.frames[2].frames[4].document.forms[0].confirm"+i+".checked");
						if(bool == true) {
							p_rec_count++;
						}
					}
				}
				if(p_rec_count>0) {
					to_proceed = true;
				}
				else {
					to_proceed = false;
				}	
				if(to_proceed == true) {	
					for(var cnt=1;cnt <= totalrecs;cnt++) {
						confirmyn = eval("parent.frames[2].frames[4].document.forms[0].confirm"+cnt+".checked");
						if(confirmyn == true) { 
							if(filelist.length == 0) {
								filelist = eval("parent.frames[2].frames[4].document.forms[0].file"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value");
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].volume"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value");
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tolocns"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value");
							
								
								//Added for this CRF HSA-CRF-0306.1	
                                if(eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value");
									
                              	if(eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value");
									
								if(eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value");
									
								if(eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value");	
								//End HSA-CRF-0306.1

									if(eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value") !="")
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value");
							}
							else {
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].file"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].filetype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[1].frames[4].document.forms[0].filetype"+cnt+".value");

								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].volume"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].docfolder"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].doctype"+cnt+".value");
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tolocns"+cnt+".value");
								
								if(eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].tonarration"+cnt+".value");
								
								
								
								//Added for this CRF HSA-CRF-0306.1	
                                if(eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patientClass"+cnt+".value");
									
                              	if(eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].assigncarecode"+cnt+".value");
									
								if(eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].dischargedatetime"+cnt+".value");
								if(eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value") == "")
									filelist += "|THISISSPACE";
								else
									filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].patient_id"+cnt+".value");	
								//End HSA-CRF-0306.1

								if(eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value") !="")
								filelist += "|"+eval("parent.frames[2].frames[4].document.forms[0].trans_to"+cnt+".value");
							}
						}
					}
					parent.frames[2].frames[4].document.forms[0].FileList.value = filelist;
					parent.frames[2].frames[4].document.forms[0].FromLocnCode.value = parent.frames[2].frames[1].document.forms[0].fromfslocn.value;
					parent.frames[2].frames[4].document.forms[0].TransferUserId.value = parent.frames[2].frames[1].document.forms[0].transferredby.value;
					parent.frames[2].frames[4].document.forms[0].iss_remarks.value = parent.frames[2].frames[1].document.forms[0].p_remarks.value;
					parent.frames[2].frames[4].document.forms[0].resultPage_file_trans_mode.value = parent.frames[2].frames[1].document.forms[0].Hiddenfile_transport_mode.value;
					parent.frames[2].frames[4].document.forms[0].resultPage_carried_by_name.value = parent.frames[2].frames[1].document.forms[0].Hiddencarried_by_name.value;
					
					var fields = new Array ( parent.frames[2].frames[1].document.forms[0].transferredby  );
					var names = new Array ( getLabel("Common.TransferredBy.label","Common") );
					if(parent.frames[2].frames[1].checkFields( fields, names, parent.frames[1].messageFrame) && filelist != "") {
						parent.frames[2].frames[4].document.forms[0].submit();
					}
				}
				else if(to_proceed == false) {
					var	messag = getMessage("NO_DOC_SELECT_TRANSFER","FM");
					parent.frames[2].frames[5].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
				}
			}
			else {
			// below code add for 19597date:Friday, February 26, 2010

				var	messag = getMessage("NO_FILE_FOR_TRANSFER","FM");
				parent.frames[2].frames[5].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
			}
		}
	}
	else {	
		// below code add for 19597date:Friday, February 26, 2010

		var	messag = getMessage("NO_FILE_FOR_TRANSFER","FM");
		parent.frames[2].frames[5].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;

	}
}//End of Function
function ShowAllFiles() {
	var Obj1 = parent.frames[1].document.forms[0]
	var Obj2 = parent.frames[2].document.forms[0]
	var Obj3 = parent.frames[3].document.forms[0]
	
	var fromlocn	= "";
	var tolocns		= "";
	var tolocndesc	= "";
	var errors		= "";
	var tonarration = "";
	var trans_from  = Obj1.returning_code.value;
	var trans_to    = Obj2.returning_code.value;
	
	var file_type_appl_yn	 = document.forms[0].file_type_appl_yn.value;
	var maintain_doc_or_file = document.forms[0].p_maintain_doc_or_file.value;
	
	if(Obj1.fromfslocn.selectedIndex != 0)
		fromlocn	= Obj1.fromfslocn.options[Obj1.fromfslocn.selectedIndex].value;
	if(Obj2.tofslocn.selectedIndex != 0) {
		tolocns		= Obj2.tofslocn.options[Obj2.tofslocn.selectedIndex].value;
		tolocndesc	= Obj2.tofslocn.options[Obj2.tofslocn.selectedIndex].text;
	}
	if(Obj2.narration.selectedIndex != 0)
		tonarration	= Obj2.narration.options[Obj2.narration.selectedIndex].value;
	if(fromlocn == "")
	{
//		errors = "APP-000001 From FS Location cannot be blank...<br>"
		errors = getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
		var err1= getLabel("Common.from.label","common")+ " " + getLabel("eFM.FSLocation.label","FM");
		errors=erros.replace('$',err1);

	}
	if(tolocns == "")
	{
//		errors += "APP-000001 To FS Location cannot be blank..."
		errors += getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
		errors=errors.replace('$',getLabel("eFM.ToFSLocation.label","FM"));
		
	}

	if(fromlocn == "" || tolocns == "") {
		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		if(parent.frames[1].document.forms[0].FS_LOCN_ID.disable==false)
		parent.frames[1].document.forms[0].FS_LOCN_ID.focus();
	}
	else if(fromlocn == tolocns) {
		var err = getMessage("FROM_TO_LOCNS_ARE_SAME","FM");
		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
		parent.frames[2].document.forms[0].tofslocn.focus();
	}
	else {	
		Obj2.tofslocn.disabled   = true;
		Obj2.narration.disabled  = true;
		Obj2.FS_LOCN_ID.disabled = true;
		
		var auto_rec_ward_yn = document.forms[0].auto_rec_ward_yn.value;
		var auto_rec_clinic_yn = document.forms[0].auto_rec_clinic_yn.value;
		var auto_rec_pract_yn = document.forms[0].auto_rec_pract_yn.value;
		var auto_rec_dept_yn = document.forms[0].auto_rec_dept_yn.value;
		if(maintain_doc_or_file == 'D') {
			parent.frames[4].location.href = "../../eFM/jsp/DTTransferFileResult.jsp?FromLocn="+fromlocn+"&trans_from="+trans_from+"&trans_to="+trans_to+"&ToLocn="+tolocns+"&ToLocnDesc="+encodeURIComponent(tolocndesc)+"&ToNarration="+tonarration+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&auto_rec_dept_yn="+auto_rec_dept_yn;
		}
		else if(maintain_doc_or_file == 'F')
			parent.frames[4].location.href = "../../eFM/jsp/FMTransferFileResult.jsp?file_type_appl_yn="+file_type_appl_yn+"&FromLocn="+fromlocn+"&trans_from="+trans_from+"&trans_to="+trans_to+"&ToLocn="+tolocns+"&ToLocnDesc="+encodeURIComponent(tolocndesc)+"&ToNarration="+tonarration+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&auto_rec_dept_yn="+auto_rec_dept_yn;

		parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp";
	}
}
function AddFiles() {	
	var Obj1 = parent.frames[1].document.forms[0]
	
	var Obj2 = parent.frames[2].document.forms[0]
	var Obj3 = parent.frames[3].document.forms[0]
	var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;
	
	if(maintain_doc_or_file == 'F') {
		var filenum     = "";
		var filetype    = "";
		var fromlocn    = "";
		var tolocns     = "";
		var tolocndesc  = "";
		var errors      = "";
		var filelistval = "";
		var patientlistval = "";
		var volumelistval = "";
		var tonarration = "";
		var trans_from	= Obj1.returning_code.value;
		var trans_to	= Obj2.returning_code.value;
        var p_stored_val="";
		var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
		var patient_id        = document.forms[0].patient_id.value;

		var volume_no         = document.forms[0].volume_no.value;
     
	     p_stored_val=parent.frames[3].document.forms[0].p_stored_val.value;
		if(file_type_appl_yn == 'N')
			filenum = Obj3.file_no.value;
		else if(file_type_appl_yn == 'Y')
		{
		filetype = Obj3.patient_file_type.value;
		filenum = Obj3.file_no.value;
			}
		
		if(patient_id=="")
		{
          

		}else
		{
          if(file_type_appl_yn == 'Y')
		   p_stored_val=p_stored_val+"/"+patient_id+"`"+filenum+"`"+volume_no;
		  	 }
		
		if(p_stored_val=="")
		{
      parent.frames[3].document.forms[0].p_stored_val.value="";
				}else{
     parent.frames[3].document.forms[0].p_stored_val.value =p_stored_val;
		}
		
		
		if(Obj1.fromfslocn.selectedIndex != 0)
			fromlocn	= Obj1.fromfslocn.options[Obj1.fromfslocn.selectedIndex].value;
		if(Obj2.tofslocn.selectedIndex != 0) {
			tolocns		= Obj2.tofslocn.options[Obj2.tofslocn.selectedIndex].value;
			tolocndesc	= Obj2.tofslocn.options[Obj2.tofslocn.selectedIndex].text;
		}
		if(Obj2.narration.selectedIndex != 0)
			tonarration	= Obj2.narration.options[Obj2.narration.selectedIndex].value;
		if(file_type_appl_yn == 'N')
			filenum = Obj3.file_no.value;
		else if(file_type_appl_yn == 'Y')
			filetype = Obj3.patient_file_type.value;
	
		if(fromlocn == "")
		{
		//	errors = "APP-000001 From FS Location cannot be blank...<br>"
			errors = getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			var err1= getLabel("Common.from.label","common")+ " " + getLabel("eFM.FSLocation.label","FM");
			errors=erros.replace('$',err1);
		}
		if(tolocns == "")
		{
		//	errors += "APP-000001 To FS Location cannot be blank...<br>"
			errors += getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors=errors.replace('$',getLabel("eFM.FSLocation.label","FM"));
		}
		
		if(patient_id == "")
		{
				//errors += "APP-000001 Patient ID cannot be blank...<br>"
				errors += getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
				errors=errors.replace('$',getLabel("Common.patientId.label","common"));
		}
		else {
			patientlistval = Obj3.patientlistvals.value;
			if(patientlistval == "") {
				Obj3.patientlistvals.value = "'"+patient_id+"'";
			}
			else {
				patientlistval += ",'"+patient_id+"'";
				Obj3.patientlistvals.value = patientlistval;
			}
		}
		if(filenum == "" && file_type_appl_yn == 'N')
		{
//				errors += "APP-000001 File No cannot be blank...<br>"
				errors += getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
				errors=errors.replace('$',getLabel("Common.fileno.label","common"));

		}
		else {
			filelistval = Obj3.filelistvals.value;
			if(filelistval == "") {
				Obj3.filelistvals.value = "'"+filenum+"'";
			}
			else {												   
				filelistval += ",'"+filenum+"'";
				Obj3.filelistvals.value = filelistval;
			}
		}
		if(filetype == "" && file_type_appl_yn == 'Y')
		{
//				errors += "APP-000001 File Type cannot be blank..."
				errors += getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
				errors=errors.replace('$',getLabel("Common.filetype.label","common"));
		}
		else {
			filelistval = Obj3.filelistvals.value;
			if(filelistval == "") {
				Obj3.filelistvals.value = "'"+filetype+"'";
			}
			else {
				filelistval += ",'"+filetype+"'";
				Obj3.filelistvals.value = filelistval;
			}
		}
		if(volume_no != "") {
			volumelistval = Obj3.volumelistvals.value;
			if(volumelistval == "") {
				Obj3.volumelistvals.value = "'"+volume_no+"'";
			}
			else {
				volumelistval += ",'"+volume_no+"'";
				Obj3.volumelistvals.value = volumelistval;
			}
		}
		if((file_type_appl_yn == 'N') && (fromlocn == "" || tolocns == "" || filenum == "")) {
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		}
		else if( (file_type_appl_yn == 'Y') && (fromlocn == "" || tolocns == "" || filetype == "")) {
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		}
		else if(fromlocn == tolocns) {
			var err = getMessage("FROM_TO_LOCNS_ARE_SAME","FM");
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			parent.frames[2].document.forms[0].tofslocn.focus();
		}
		else {
			Obj2.tofslocn.disabled=true;
			Obj2.narration.disabled=true;
			Obj2.FS_LOCN_ID.disabled=true;

			var auto_rec_ward_yn = document.forms[0].auto_rec_ward_yn.value;
			var auto_rec_clinic_yn = document.forms[0].auto_rec_clinic_yn.value;
			var auto_rec_pract_yn = document.forms[0].auto_rec_pract_yn.value;
			var auto_rec_dept_yn = document.forms[0].auto_rec_dept_yn.value;
			/*if(file_type_appl_yn == 'N')
				Obj3.file_no.disabled=true;
			else if(file_type_appl_yn == 'Y')
				Obj3.file_type_code.disabled=true;*/

			if(file_type_appl_yn == 'N') {
				parent.frames[4].location.href = "../../eFM/jsp/FMTransferFileResult.jsp?file_type_appl_yn="+file_type_appl_yn+"&FromLocn="+fromlocn+"&ToLocn="+tolocns+"&ToLocnDesc="+encodeURIComponent(tolocndesc)+"&patient_id="+Obj3.patientlistvals.value+"&trans_from="+trans_from+"&trans_to="+trans_to+"&FileNo="+Obj3.filelistvals.value+"&volume_no="+Obj3.volumelistvals.value+"&ToNarration="+tonarration+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&patient_id1="+patient_id+"&filenum="+filenum+"&volume_no1="+volume_no+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&auto_rec_dept_yn="+auto_rec_dept_yn;
			}
			else if(file_type_appl_yn == 'Y') {
				parent.frames[4].location.href = "../../eFM/jsp/FMTransferFileResult.jsp?file_type_appl_yn="+file_type_appl_yn+"&FromLocn="+fromlocn+"&ToLocn="+tolocns+"&ToLocnDesc="+encodeURIComponent(tolocndesc)+"&trans_from="+trans_from+"&trans_to="+trans_to+"&patient_id="+Obj3.patientlistvals.value+"&file_type_code="+Obj3.filelistvals.value+"&volume_no="+Obj3.volumelistvals.value+"&ToNarration="+tonarration+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&filenum="+filenum+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&patient_id1="+patient_id+"&filetype="+filetype+"&volume_no1="+volume_no+"&p_stored_val="+p_stored_val+"&auto_rec_dept_yn="+auto_rec_dept_yn;
				//document.location.reload();
			}
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp";
		}
	}
	else if(maintain_doc_or_file == 'D') {
		var doctype		= "";	
		var fromlocn    = "";
		var tolocns     = "";
		var tolocndesc  = "";
		var errors      = "";
		var documentfolderlistvals	= "";
		var documenttypelistvals	= "";
		var filelistval				= "";
		var tonarration = "";
		var trans_from	= Obj1.returning_code.value;
		var trans_to	= Obj2.returning_code.value;
		var doc_folder_id    = document.forms[0].doc_folder_id.value;
		var doc_type_code    = document.forms[0].doc_type_code.value;
		var filenum			 = document.forms[0].file_no.value;
		
		if(Obj1.fromfslocn.selectedIndex != 0)
			fromlocn	= Obj1.fromfslocn.options[Obj1.fromfslocn.selectedIndex].value;
		if(Obj2.tofslocn.selectedIndex != 0) {
			tolocns		= Obj2.tofslocn.options[Obj2.tofslocn.selectedIndex].value;
			tolocndesc	= Obj2.tofslocn.options[Obj2.tofslocn.selectedIndex].text;
		}
		if(Obj2.narration.selectedIndex != 0)
			tonarration	= Obj2.narration.options[Obj2.narration.selectedIndex].value;
		
		doctype = Obj3.doc_type_code.value;

		if(fromlocn == "")
		{
		//	errors = "APP-000001 From FS Location cannot be blank...<br>"
			errors = getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors=errors.replace('$',getLabel("eFM.ToFSLocation.label","FM"));

		}
		if(tolocns == "")
		{
		//	errors += "APP-000001 To FS Location cannot be blank...<br>"
			errors += getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors=errors.replace('$',getLabel("eFM.ToFSLocation.label","FM"));

		}

		if(doc_folder_id == "")
		{
				//errors += "APP-000001 Document Folder cannot be blank..."
			errors = getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors=errors.replace('$',getLabel("eFM.DocumentFolder.label","FM"));

		}
		else {
			documentfolderlistvals = Obj3.documentfolderlistvals.value;
			if(documentfolderlistvals == "") {
				Obj3.documentfolderlistvals.value = "'"+doc_folder_id+"'";
			}
			else {
				documentfolderlistvals += ",'"+doc_folder_id+"'";
				Obj3.documentfolderlistvals.value = documentfolderlistvals;
			}
		}
		if(doc_type_code == "")
		{
		//		errors += "APP-000001 Document Type cannot be blank..."
			errors = getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors=errors.replace('$',getLabel("eFM.DocumentFolderType.label","FM"));

		}
		else {
			documenttypelistvals = Obj3.documenttypelistvals.value;
			if(documenttypelistvals == "") {
				Obj3.documenttypelistvals.value = "'"+doc_type_code+"'";
			}
			else {
				documenttypelistvals += ",'"+doc_type_code+"'";
				Obj3.documenttypelistvals.value = documenttypelistvals;
			}
		}
		filelistval = Obj3.filelistvals.value;
		if(filelistval == "") {
			Obj3.filelistvals.value = "'"+filenum+"'";
		}
		else {
			filelistval += ",'"+filenum+"'";
			Obj3.filelistvals.value = filelistval;
		}
		if((fromlocn == "" || tolocns == "" || doc_folder_id == "" || doc_type_code == "")) {
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		}
		else if(fromlocn == tolocns) {
			var err = getMessage("FROM_TO_LOCNS_ARE_SAME","FM");
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
			parent.frames[2].document.forms[0].tofslocn.focus();
		}
		else {
			Obj2.tofslocn.disabled=true;
			Obj2.narration.disabled=true;
			Obj2.FS_LOCN_ID.disabled=true;

			var auto_rec_ward_yn = document.forms[0].auto_rec_ward_yn.value;
			var auto_rec_clinic_yn = document.forms[0].auto_rec_clinic_yn.value;
			var auto_rec_pract_yn = document.forms[0].auto_rec_pract_yn.value;
            var auto_rec_dept_yn = document.forms[0].auto_rec_dept_yn.value;
			parent.frames[4].location.href = "../../eFM/jsp/DTTransferFileResult.jsp?FromLocn="+fromlocn+"&ToLocn="+tolocns+"&ToLocnDesc="+tolocndesc+"&trans_from="+trans_from+"&trans_to="+trans_to+"&doc_folder_id=" +Obj3.documentfolderlistvals.value+"&doc_type_code="+Obj3.documenttypelistvals.value+"&FileNo="+Obj3.filelistvals.value+"&ToNarration="+tonarration+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&auto_rec_dept_yn="+auto_rec_dept_yn;
					
			parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp";
		}
	}
}
function ClearData() {
	var maintain_doc_or_file = document.forms[0].p_maintain_doc_or_file.value;

	parent.frames[3].document.forms[0].volumelistvals.value="";
	parent.frames[3].document.forms[0].patientlistvals.value="";
	 parent.frames[3].document.forms[0].p_stored_val.value="";
	parent.frames[3].document.forms[0].filelistvals.value="";
	if(maintain_doc_or_file == 'D')
		document.getElementById("hdr_tab1").style.visibility = 'hidden';
	else if(maintain_doc_or_file == 'F')
		document.getElementById("hdr_tab").style.visibility = 'hidden';

	parent.frames[4].location.href = "../../eCommon/html/blank.html";
}
function setDisabled(ObjVal) {

	if(ObjVal != "") {
		parent.frames[1].document.forms[0].FS_LOCN_ID.disabled = true;
		parent.frames[1].document.forms[0].fromfslocn.disabled = true;
		parent.frames[2].location.href = "../../eFM/jsp/FMTransferFileTo.jsp?From_locn_code="+ObjVal;
	}
}
////*************** JS Files of FMTransferFileFrom.jsp ************************//
function chk_focus() {
	var obj  = document.forms[0].returning_desc.value;
	var obj1 = parent.frames[2].document.forms[0].returning_desc.value;
	
	if(obj != '' && obj1 != '') {
		parent.frames[2].document.forms[0].returning_desc.focus();
	}
}
function chk_val() {
	var Obj = document.forms[0].fromfslocn.value;
	var identity = document.forms[0].FS_LOCN_ID.value;
	if(Obj == '') {
		document.forms[0].returning_desc.value='';
		document.forms[0].returning_code.value='';
		document.forms[0].returning_desc.disabled=true;
		document.forms[0].ret_button.disabled=true;
	}
	else if(identity!="D") {
		document.forms[0].returning_desc.disabled=false;
		document.forms[0].ret_button.disabled=false;
	}
}
function PopulateFromData(objval) {


	if(objval != '') {
		if (objval == "C")
			parent.frames[1].document.getElementById("returning").innerText = getLabel("Common.clinic.label","common");
		else if (objval == "N")
			parent.frames[1].document.getElementById("returning").innerText = getLabel("Common.nursingUnit.label","common");
		else if (objval == "Y")
			parent.frames[1].document.getElementById("returning").innerText = getLabel("Common.DaycareUnit.label","common");
		else if (objval == "E")
			parent.frames[1].document.getElementById("returning").innerText = getLabel("Common.ProcedureUnit.label","common");
		else if (objval == "T")
			parent.frames[1].document.getElementById("returning").innerText = getLabel("Common.practitioner.label","common");
         else if (objval == "D")
		 parent.frames[1].document.getElementById("returning").innerText = getLabel("Common.TransferFrom.label","common");
		
	
		if (objval == "D")
		parent.frames[1].document.getElementById("mandat1").style.visibility = 'Hidden';
		else
        parent.frames[1].document.getElementById("mandat1").style.visibility= 'Visible';
		
		var userSecurity		= document.forms[0].userSecurity.value;
		var Dflt_Archive_Locn	= document.forms[0].Dflt_Archive_Locn.value;
		var Dflt_Lost_Locn		= document.forms[0].Dflt_Lost_Locn.value;
		var accessAll			= document.forms[0].accessAll.value;

		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMTransFileFromPopFSLocn.jsp?locn_code="+objval+"&accessAll="+accessAll+"&userSecurity="+userSecurity+"&Dflt_archive_fs_locn_code="+Dflt_Archive_Locn+"&Dflt_lost_fs_locn_code="+Dflt_Lost_Locn+"'></form></body></html>" ;
			parent.frames[5].document.write(HTMLVal) ;

		parent.frames[5].document.GetLocIdentity.submit() ;
	}
	else {
		parent.frames[1].FMTransferFileFrom_form.document.getElementById("returning").innerText = getLabel("Common.TransferFrom.label","Common");
		var len = parent.frames[1].FMTransferFileFrom_form.fromfslocn.length;
		for (var i=0; i<=len; i++) {
			parent.frames[1].FMTransferFileFrom_form.document.forms[0].fromfslocn.remove("fromfslocn");
		}
		var opt	= parent.frames[1].FMTransferFileFrom_form.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "----------- "+ getLabel("Common.defaultSelect.label","common") +" ------------";
		parent.frames[1].FMTransferFileFrom_form.document.forms[0].fromfslocn.add(opt);
	}
}
async function getValidRecords(returning_desc) {
	var	fs_locn_id	= document.forms[0].FS_LOCN_ID.value;	
	if ((fs_locn_id == "C") || (fs_locn_id == "N") || (fs_locn_id == "E") || (fs_locn_id == "Y")) {
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code.value;
		var fromfslocn		= document.forms[0].fromfslocn.value;
		var facility_id		= document.forms[0].facility_id.value;

		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;

		if ((fs_locn_id == "C")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title		= getLabel("Common.clinic.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= fromfslocn;
			dataTypeArray[1]	= STRING ;

		}
		else if ((fs_locn_id == "Y")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'D' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.DaycareUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= fromfslocn;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_locn_id == "E")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'E' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ";
			
			window_title	=getLabel("Common.ProcedureUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= fromfslocn;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_locn_id == "N")) {
			sql	=	"Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and fs_locn_code like ? and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.nursingUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
		
			dataNameArray[1]	= "fs_locn_code" ;
			dataValueArray[1]	= fromfslocn;
			dataTypeArray[1]	= STRING ;
		
		}
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "3, 4";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		
		retVal = await CommonLookup( window_title, argumentArray );
		
		if(retVal != null && retVal != "" ) {
			var ret1	=	unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].returning_code.value		=	arr[0];
			document.forms[0].returning_desc.value		=	arr[1];
		//	document.forms[0].returning_desc.disabled	= "true";
		//	document.forms[0].ret_button.disabled		= "true";
		}
		else {
			document.forms[0].returning_desc.value	=	"";
			document.forms[0].returning_code.value	=	"";
		} 
	}
	if (fs_locn_id == "T") {
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code;
		getPractitioner(code, target);
	//	document.forms[0].returning_desc.disabled	= "true";
		//document.forms[0].ret_button.disabled		= "true";
	}
}
function getPractitioner(obj, target) {

	var practName_FName="";
	var practName_FValue="";

	practName_FName=target.name;
	practName_FValue=target.value;

	var facility_id		= document.forms[0].facility_id.value;
	getPractitioner_common(obj,target,"",facility_id,"Q2");
	//var sql = "SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  OR  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";
	// latest var sql = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";

	//var sql2 = "SELECT a.Practitioner_id practitioner_id, a.Practitioner_name practitioner_name,d.desc_sysdef practitioner_type,e.short_desc primary_specialty,DECODE(b.gender,'M','Male','F','Female','U','Unknown') gender, DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant', 'RG', 'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC', 'Sr. Consultant', 'SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' ) job_title FROM am_pract_for_facility_vw a, am_practitioner b, am_pract_type d,  am_speciality e WHERE a.operating_facility_id='"+facility_id+"' AND a.practitioner_id = b.practitioner_id AND  b.primary_speciality_code = e.speciality_code AND  b.pract_type = d.pract_type AND b.pract_type LIKE (?)  AND b.primary_speciality_code LIKE UPPER(?) AND (UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))  AND  UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))) AND  b.gender LIKE (?) AND (b.JOB_TITLE LIKE (?) OR b.JOB_TITLE IS NULL)";
	// latest var sql2 = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/

} // End of getPractitioner.
function searchUser(target,fac_id) {
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit=getLabel("Common.user.label","common");

	sql="Select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+fac_id+"` ";
	search_code="APPL_USER_ID";
	search_desc= "APPL_USER_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();

	if (!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		document.forms[0].transferredbyname.value=arr[0];
		document.forms[0].transferredby.value=arr[1];
	}
}
async function GetShowRemarks() {
	 var ua = window.navigator.userAgent
      var msie = ua.indexOf ( "MSIE " )
	  if ( msie > 0 )     
				var brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
    
	var dialogHeight	= "28vh" ;
	var dialogWidth		= "37vw" ;
	if(brow_ver_no > '6'){
			dialogHeight	= "7.4" ;
			dialogWidth		= "28.5" ;
	  }
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	var arguments		= "" ;
	var tempobj			= document.forms[0].p_remarks;
	var curr_remarks	= tempobj.value;
	var retVal			= await window.showModalDialog('../../eFM/jsp/FMShowRemarks.jsp?title=Transfer Remarks&curr_remarks='+encodeURIComponent(curr_remarks),arguments,features);

	if (!(retVal == null)) {
		tempobj.value	= unescape(retVal);
	}
}
function GetModeOfTransport() {
		var dialogHeight	= "8.5" ;
		var dialogWidth		= "20" ;
		var dialogTop		= "185" ;
		var dialogLeft		= "250" ;
		var center			= "0" ;
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
		var arguments		= "" ;
		var tempobjTransportMode	= document.forms[0].Hiddenfile_transport_mode;
		var tempobjCariedBy			= document.forms[0].Hiddencarried_by_name;
		var curr_file_transport_mode  = tempobjTransportMode.value;
		var curr_carried_by_name  = tempobjCariedBy.value;
		var title1 = getLabel("Common.ModeOfTransport.label","common");
		
		retVal				= window.showModalDialog( '../../eFM/jsp/FMIssueFileModelWindow.jsp?title='+title1+' &file_transport_mode='+escape(curr_file_transport_mode)+'&carried_by_name='+escape(curr_carried_by_name), arguments, features );
	
		var arr=new Array();

	if (!(retVal == null)) {
		var retVal=unescape(retVal);
		arr=retVal.split("::");

		 tempobjTransportMode.value	= arr[0];
		 tempobjCariedBy.value			=arr[1];
		
		document.forms[0].Hiddenfile_transport_mode.value=arr[0];
		document.forms[0].Hiddencarried_by_name.value=arr[1];
				
		}
}
///***************** End of JS Files of FMTransferFileFrom.jsp **********************//
					///////////////////////////////////////////
///********* Common JS File of FMTransferFileFrom.jsp AND FMTransferFileTo.jsp***************//

function PractLookupRetVal(retVal,objName) {

	var arr;
	if (retVal != null) {
		arr=retVal.split("~");
		document.forms[0].returning_code.value=arr[0];
		document.forms[0].returning_desc.value=arr[1];			
	}
	else {
		document.forms[0].returning_code.value="";
		document.forms[0].returning_desc.value="";			
	}
} 
///********* End of Common JS File of FMTransferFileFrom.jsp AND FMTransferFileTo.jsp ************//
			///////////////////////////////////////////////////////////
///***************** JS Files of FMTransferFileTo.jsp *********************************//
function chkToVal() {
	var Obj = document.forms[0].tofslocn.value;
	var fs_locn_id	= document.forms[0].FS_LOCN_ID.value;	
	if(Obj == '' || fs_locn_id=="D") {
		document.forms[0].returning_desc.value='';
		document.forms[0].returning_code.value='';
		document.forms[0].returning_desc.disabled=true;
		document.forms[0].ret_button.disabled=true;
  if(fs_locn_id=="D")
		{
  displayToCriteria();
		}	
  } else {
		document.forms[0].returning_desc.disabled=false;
		document.forms[0].ret_button.disabled=false;
		document.forms[0].returning_desc.value='';
		document.forms[0].returning_code.value='';
	}
}
function PopulateToData(ObjVal) {
	var dflt_Archive_Locn	= parent.frames[1].document.forms[0].Dflt_Archive_Locn.value;
	var dflt_Lost_Locn		= parent.frames[1].document.forms[0].Dflt_Lost_Locn.value;

	var from_locn			= parent.frames[1].FMTransferFileFrom_form.fromfslocn.value;
	var returning_desc		= parent.frames[1].FMTransferFileFrom_form.returning_desc.value;
	var from_fs_locn_id    = parent.frames[1].FMTransferFileFrom_form.FS_LOCN_ID.value;
	if(ObjVal != '') {
		if (ObjVal == "C")
			parent.frames[2].document.getElementById("returning").innerText = getLabel("Common.clinic.label","common");
		else if (ObjVal == "N")
			parent.frames[2].document.getElementById("returning").innerText = getLabel("Common.nursingUnit.label","common");
		else if (ObjVal == "Y")
			parent.frames[2].document.getElementById("returning").innerText =getLabel("Common.DaycareUnit.label","common");
		else if (ObjVal == "E")
			parent.frames[2].document.getElementById("returning").innerText = getLabel("Common.ProcedureUnit.label","common");
		else if (ObjVal == "T")
			parent.frames[2].document.getElementById("returning").innerText = getLabel("Common.practitioner.label","common");
       else if (ObjVal == "D")
			parent.frames[2].document.getElementById("returning").innerText = getLabel("Common.TransferTo.label","common");
		// code added for 21384

			if (ObjVal == "D")
		parent.frames[2].document.getElementById("mandat1").style.visibility = 'Hidden';
		else
        parent.frames[2].document.getElementById("mandat1").style.visibility= 'Visible';
		
		parent.frames[2].document.getElementById("returning_code").value="";
		parent.frames[2].document.getElementById("returning_desc").value="";


		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMTransFileToPopFSLocn.jsp?Dflt_Archive_Locn="+dflt_Archive_Locn+"&Dflt_Lost_Locn="+dflt_Lost_Locn+"&From_locn_code="+from_locn+"&returning_desc="+returning_desc+"&from_fs_locn_id="+from_fs_locn_id+"&locn_code="+ObjVal+"'></form></body></html>" ;
	
		parent.frames[5].document.write(HTMLVal);
		parent.frames[5].document.GetLocIdentity.submit();
	}
	else {
		parent.frames[2].FMTransferFileTo_form.document.getElementById("returning").innerText = getLabel("Common.TransferTo.label","common");
		// code added for 21384

		parent.frames[2].FMTransferFileTo_form.document.getElementById("returning_code").value="";
		parent.frames[2].FMTransferFileTo_form.document.getElementById("returning_desc").value="";

		var len = parent.frames[2].FMTransferFileTo_form.document.forms[0].tofslocn.length;
		for (var i=0; i<=len; i++) 
		{
			parent.frames[2].FMTransferFileTo_form.document.forms[0].tofslocn.remove("tofslocn");
		}
		var opt	= parent.frames[2].FMTransferFileTo_form.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "----- "+ getLabel("Common.defaultSelect.label","common")+" -----";
		parent.frames[2].FMTransferFileTo_form.document.forms[0].tofslocn.add(opt);
	}
}
async function getToValidRecords(returning_desc) {
	var	fs_locn_id	= document.forms[0].FS_LOCN_ID.value;	
	if ((fs_locn_id == "C") || (fs_locn_id == "N") || (fs_locn_id == "E") || (fs_locn_id == "Y")) {
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code.value;
		var tofslocn		= document.forms[0].tofslocn.value;
		var facility_id		= document.forms[0].facility_id.value;	
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;

		if ((fs_locn_id == "C")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.clinic.label","common")
;
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= tofslocn;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_locn_id == "Y")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'D' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.DaycareUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= tofslocn;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_locn_id == "E")) {
			sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.ProcedureUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
			
			dataNameArray[1]	= "mr_location_code" ;
			dataValueArray[1]	= tofslocn;
			dataTypeArray[1]	= STRING ;
		
		}
		else if ((fs_locn_id == "N")) {
			sql	=	"Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and fs_locn_code like ? and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
			
			window_title	=	getLabel("Common.nursingUnit.label","common");
			
			dataNameArray[0]	= "facility_id" ;
			dataValueArray[0]	= facility_id;
			dataTypeArray[0]	= STRING ;
		
			dataNameArray[1]	= "fs_locn_code" ;
			dataValueArray[1]	= tofslocn;
			dataTypeArray[1]	= STRING ;
		}
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "3, 4";
		argumentArray[5] = target.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		
		retVal = await CommonLookup( window_title, argumentArray );
		
		if(retVal != null && retVal != "" ) {
			var ret1	=	unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].returning_code.value	=	arr[0];
			document.forms[0].returning_desc.value	=	arr[1];
			displayToCriteria()
		}
		else {
			document.forms[0].returning_desc.value	=	"";
			document.forms[0].returning_code.value	=	"";
		} 
	}
	if (fs_locn_id == "T") {
		var target			= document.forms[0].returning_desc;
		var code			= document.forms[0].returning_code;
		getToPractitioner(code, target);
		displayToCriteria()
	}
	document.forms[0].returning_desc.focus();
}
function getToPractitioner(obj, target) {
	var practName_FName="";
	var practName_FValue="";
	var facility_id		= document.forms[0].facility_id.value;

	practName_FName=target.name;
	practName_FValue=target.value;
	getPractitioner_common(obj,target,"",facility_id,"Q2");

	// latest var sql = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
	// latest var sql2 = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
	/*var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);	*/
} // End of getToPractitioner.
function displayToCriteria() {
	var ObjVal = document.forms[0].tofslocn.value;
	var fs_locn_id = document.forms[0].FS_LOCN_ID.value;
	var fs_locn_id_from = parent.frames[1].document.forms[0].FS_LOCN_ID.value;
	parent.frames[4].location.href='../../eCommon/html/blank.html';
	parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num=';

	if(ObjVal == "")
		parent.frames[3].location.href = "../../eCommon/html/blank.html"
	else if(parent.frames[1].document.forms[0].transferredby.value == "") {
		parent.frames[2].document.forms[0].tofslocn.value = "";
//		var msg ="APP-000001 Transferred By cannot be blank..."
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("Common.TransferredBy.label","Common"));
		parent.frames[5].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		parent.frames[1].document.forms[0].transferredby.focus();
		parent.frames[1].document.forms[0].transferredby.select();
	}
	
	
    if(fs_locn_id_from=="D"  && fs_locn_id!="D")
	{
    var fields = new Array (document.forms[0].returning_desc);
	var names = new Array (getLabel("Common.TransferTo.label","common"));
	} 
   else if(fs_locn_id_from !="D"  && fs_locn_id=="D")
	{
     var fields   = new Array (parent.frames[1].document.forms[0].returning_desc);
	var names = new Array (getLabel("Common.TransferFrom.label","Common"));
	} else if(fs_locn_id_from !="D"  && fs_locn_id !="D")
	{
	var fields = new Array (parent.frames[1].document.forms[0].returning_desc,document.forms[0].returning_desc);
	var names = new Array (getLabel("Common.TransferFrom.label","Common"), getLabel("Common.TransferTo.label","common"));
	}else{
        var fields="";
        var names="";
	}
	
	
	if(fs_locn_id=="D")
	{
     	var auto_rec_ward_yn	= parent.frames[1].document.forms[0].auto_rec_ward_yn.value;
		var auto_rec_clinic_yn	= parent.frames[1].document.forms[0].auto_rec_clinic_yn.value;
		var auto_rec_pract_yn	= parent.frames[1].document.forms[0].auto_rec_pract_yn.value;
		var auto_rec_dept_yn  = parent.frames[1].document.forms[0].auto_rec_dept_yn.value;
			parent.frames[3].location.href = "../../eFM/jsp/FMTransferFileCriteria.jsp?ToLocnCode="+ObjVal+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&auto_rec_dept_yn="+auto_rec_dept_yn;
	
	}
else if(checkFields(fields, names, parent.messageFrame)) {
		var auto_rec_ward_yn	= parent.frames[1].document.forms[0].auto_rec_ward_yn.value;
		var auto_rec_clinic_yn	= parent.frames[1].document.forms[0].auto_rec_clinic_yn.value;
		var auto_rec_pract_yn	= parent.frames[1].document.forms[0].auto_rec_pract_yn.value;
		var auto_rec_dept_yn  = parent.frames[1].document.forms[0].auto_rec_dept_yn.value; 
		parent.frames[3].location.href = "../../eFM/jsp/FMTransferFileCriteria.jsp?ToLocnCode="+ObjVal+"&auto_rec_ward_yn="+auto_rec_ward_yn+"&auto_rec_clinic_yn="+auto_rec_clinic_yn+"&auto_rec_pract_yn="+auto_rec_pract_yn+"&auto_rec_dept_yn="+auto_rec_dept_yn;
	}
}
///***************** End of JS Files of FMTransferFileTo.jsp **************************//
function onSuccess() {
	parent.frames[2].frames[1].location.reload();
	parent.frames[2].frames[2].location.href="../../eFM/jsp/FMTransferFileTo.jsp" ;
	parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[4].location.href = "../../eCommon/html/blank.html";
}
function reset() {
	parent.frames[2].frames[1].location.reload();
	//parent.frames[2].frames[2].location.reload();
	parent.frames[2].frames[2].location.href="../../eFM/jsp/FMTransferFileTo.jsp" ;
	parent.frames[2].frames[3].location.href = "../../eCommon/html/blank.html";
	parent.frames[2].frames[4].location.href = "../../eCommon/html/blank.html";
}

//Ragha
//these functions are added for on click events of encounter_id and patient_id in DTTransferFileResult.jsp
function changeCursor(obj) 
{
	obj.style.cursor = "hand" ;
}

function callPatDetails(Patient_ID) 
{
	var dialogHeight	= "28" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "84" ;
	var dialogLeft		= "55" ;
	var center			= "0" ;
	var status			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
	var arguments		= "" ;
	retVal				= window.showModalDialog( "../../eMP/jsp/ViewPatDetailsMain.jsp?Patient_ID="+escape(Patient_ID), arguments, features );
}

function showEncounter(enc,patid,fileno,Patient_Class)
{
	var call_function = "VIEW_ENCOUNTER_DTLS";
	var jsp_name="FMCurrentEncounterMain.jsp";
	var win_height = "30.8";
	var win_width= "50";
	var retVal = 	new String();
	var dialogHeight= win_height ;
	var dialogWidth	= win_width ;
	var dialogTop = "58" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&fileNo="+fileno+"&Patient_Class="+Patient_Class,arguments,features);
}
//Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17 - START
function validatePatientId(obj) 
{
	var patId = obj.value;
	if(parent.content !=null) {
		f = parent.content.frames[1];
	}else {
		f = parent.frames[1];
	}
	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatId' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		if(responseText!=""){
			var msg = getMessage("INVALID_PATIENT","MP");
			alert(msg);
			obj.value="";
			obj.focus();
		}
	}
}
function validSplchars(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Patient ID";									
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
	
		obj.value = "";
		obj.focus();
		return false;
	}
}
function showLookUp(val)
{
    if(val == 'P')
    {
		var patientid=PatientSearch('','','','','','','Y','','','OTHER');
		if(patientid != null)
		document.getElementById("patient_id").value = patientid;
    }
}
function fetchCurrFsLocn(obj)
{
	var patId				= obj.value;
	var lang_id				= document.getElementById("lang_id").value;
	var Curr_FS_Locn		= "";
	var curr_fs_locn_id		= "";
	var curr_fs_result		= "";
	var other_locn_identity = "";
	var DisplayData			= "";
	var jsonArguments	= {
							'patientId':patId,
							'LangId':lang_id,
							'action':'fetchCurrFsLocn'
						 };
	if(patId!=""){ 
		$.ajax({  
			 url:'../../eFM/jsp/FMintermediate.jsp',  
			 type:'post',  
			 data:jsonArguments,
			 dataType: 'json',
			 success: function(data) {
				 var rowCnt	 = 0;
				 if(data!=null){
					if(data.rowCnt > 0){
						var storedRecordList	= eval(data.results);
						var identity			= "";
						$.each(storedRecordList,function(index,value){
							Curr_FS_Locn	   =  value.Curr_FS_Locn;
							curr_fs_locn_id	   =  value.curr_fs_locn_id;
							other_locn_identity=  value.other_locn_identity;
							if( curr_fs_locn_id==other_locn_identity)
							{  
							}
							else{
							curr_fs_locn_id=other_locn_identity;
							}
						  if(!curr_fs_locn_id == "")
						  {
								if(curr_fs_locn_id == 'D')  
								identity = getLabel('Common.department.label','common_labels');
								else if(curr_fs_locn_id == 'C')  
								identity = getLabel('Common.clinic.label','common_labels');
								else if(curr_fs_locn_id == 'N')  
								identity = getLabel('Common.nursingUnit.label','common_labels');
								else if(curr_fs_locn_id == 'T')  
								identity = getLabel('Common.practitioner.label','common_labels');
								else if(curr_fs_locn_id == 'X')  
								identity = getLabel('Common.external.label','common_labels');
								else if(curr_fs_locn_id == 'E')  
								identity = getLabel('Common.ProcedureUnit.label','common_labels');
								else if(curr_fs_locn_id == 'Y')  
								identity = getLabel('Common.DaycareUnit.label','common_labels');
							}
							curr_fs_result   = Curr_FS_Locn + "(" + identity + ")";
							DisplayData += curr_fs_result+", ";
						});
						DisplayData = DisplayData.slice(0,-2);
						$("#FS_Locn_display",parent.frames[2].document).html(DisplayData);
					 }
					 else{
						 var msg = getMessage("PATIENT_FILE_NOT_EXIST","FM");
						 alert(msg);
						 obj.value = "";
						 $("#FS_Locn_display",parent.frames[2].document).html("");
					 }
				 } 			
			 },
			 error: function(jqXHR, textStatus, errorThrown) {
					alert(errorThrown)
			 }
		});
	}else{
		$("#FS_Locn_display",parent.frames[2].document).html("");
	}
}
//Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17 - END


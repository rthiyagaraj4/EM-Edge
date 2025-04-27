function apply()
{
	var to_proceed = true;
	var errors     = "";
	if(parent.frames[2].frames[3].document.forms[0])
	{
		if(parent.frames[2].frames[3].document.forms[0].p_new_status.value.length==0)
		{
			var fields = new Array ( parent.frames[2].frames[3].document.forms[0].p_new_status);
			var names = new Array ( getLabel("eFM.NewStatusoftheFile.label","FM"));	
			for( var i=0; i<fields.length; i++ ) 
			{
				if(trimCheck(fields[i].value)) 
				{
					fields[i].value = trimString(fields[i].value);
				}
				else
				{
			//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
					errors = errors + getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
					errors= errors.replace('$',names[i]);
				}
			}
		}
		else if(parent.frames[2].frames[3].document.forms[0].p_new_status.value=='O' || parent.frames[2].frames[3].document.forms[0].p_new_status.value=='L' || parent.frames[2].frames[3].document.forms[0].p_new_status.value=='A')
		{
			var fields = new Array ( parent.frames[2].frames[3].document.forms[0].p_new_status, parent.frames[2].frames[3].document.forms[0].p_fs_location1);
			var names = new Array ( getLabel("eFM.NewStatusoftheFile.label","FM"), getLabel('eFM.NewFSLocation.label','FM'));	

			for(var i=0; i<fields.length; i++) 
			{
				if(trimCheck(fields[i].value)) 
				{
					fields[i].value = trimString(fields[i].value);
				}
				else 
				{
				//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
					errors = errors + getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
					errors= errors.replace('$',names[i]);
				}
			}
		}
		else if (parent.frames[2].frames[3].document.forms[0].p_new_status.value =='O' || parent.frames[2].frames[3].document.forms[0].p_new_status.value =='F'|| parent.frames[2].frames[3].document.forms[0].p_new_status.value =='R')
		{
			if(parent.frames[2].frames[3].document.forms[0].fs_locn_idty.value =='D')
			{
				var fields = new Array ( parent.frames[2].frames[3].document.forms[0].p_new_status,parent.frames[2].frames[3].document.forms[0].p_fs_location);
				var names = new Array (getLabel("eFM.NewStatusoftheFile.label","FM"), getLabel('eFM.NewFSLocation.label','FM'));	
			}
			else
			{
				var fields = new Array (parent.frames[2].frames[3].document.forms[0].p_new_status,parent.frames[2].frames[3].document.forms[0].locn_desc);
				var names = new Array (getLabel("eFM.NewStatusoftheFile.label","FM"), getLabel('eFM.NewFSLocation.label','FM'));	
			}
			for(var i=0; i<fields.length; i++) 
			{
				if(trimCheck(fields[i].value)) 
				{
					fields[i].value = trimString(fields[i].value);
				}
				else
				{
				//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
					errors = errors + getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
					errors= errors.replace('$',names[i]);
				}
			}
		}
		if(errors.length != 0) 
		{
			parent.frames[2].frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				to_proceed = false;
				return false ;
		}
		if(to_proceed == true)
		{
			if(parent.frames[2].frames[3].document.forms[0].p_new_status.value=="NA")
			{
				
				parent.frames[2].frames[3].document.forms[0].NevertoArchive.value="NA";
			}
			else
			{
				parent.frames[2].frames[3].document.forms[0].NevertoArchive.value="";
			}
			if(parent.frames[2].frames[3].document.forms[0].p_new_status.value!="NA")
			{
			parent.frames[2].frames[3].document.forms[0].p_store_new_status.value = parent.frames[2].frames[3].document.forms[0].p_new_status.value;
			}
			else
			{
			parent.frames[2].frames[3].document.forms[0].p_store_new_status.value = parent.frames[2].frames[3].document.forms[0].p_curr_status.value;
			}

			if(parent.frames[2].frames[3].document.forms[0].p_new_status.value =='F'|| parent.frames[2].frames[3].document.forms[0].p_new_status.value =='R')
			{
				parent.frames[2].frames[3].document.forms[0].p_store_fs_location.value = parent.frames[2].frames[3].document.forms[0].p_fs_location.value;
				parent.frames[2].frames[3].document.forms[0].src_locn_code.value = parent.frames[2].frames[3].document.forms[0].locn_code.value;
			}
			else
			{
				parent.frames[2].frames[3].document.forms[0].p_store_fs_location.value = parent.frames[2].frames[3].document.forms[0].p_fs_location1.value;
			}
			parent.frames[2].frames[3].document.forms[0].p_store_updated_by.value = parent.frames[2].frames[3].document.forms[0].p_updated_by.value;
			parent.frames[2].frames[3].document.forms[0].appl_user_id.value = parent.frames[2].frames[1].document.forms[0].appl_user_id.value;
			
			if(CheckMaxLen(getLabel("Common.remarks.label","common") , parent.frames[2].frames[3].document.forms[0].p_remarks,100,parent.frames[2].frames[4]))
			{
				
			if(parent.frames[2].frames[3].document.forms[0].p_new_status.value=="A" && parent.frames[2].frames[3].document.forms[0].archive_yn.value=="N")
			{
			if(confirm(getMessage('FILE_ALREADY_ARCHIVED','FM')))
			{
			parent.frames[2].frames[3].document.forms[0].submit();
			}
			else
			{
			parent.frames[2].messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_num=';
			} 
			}else
				{
									
				parent.frames[2].frames[3].document.forms[0].submit();
				
				}
			}
		}
	}
	else
	{
		parent.frames[2].messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_num=';
	}
}
function addFiles()
{
	var to_proceed = true;
	var p_curr_location	= parent.frames[1].document.forms[0].f_curr_fs_locn.value; 
	var maintain_doc_or_file = document.forms[0].p_maintain_doc_or_file.value;
	if(maintain_doc_or_file == 'F')
	{
		var file_type_appl_yn = parent.frames[1].document.forms[0].file_type_appl_yn.value;
		if(file_type_appl_yn == 'N')
		{
			var fields = new Array (parent.frames[1].document.forms[0].f_curr_fs_locn,parent.frames[1].document.forms[0].patient_id,parent.frames[1].document.forms[0].file_no);
			var names = new Array ( getLabel("eFM.FSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"));	
		}
		else if(file_type_appl_yn == 'Y')
		{
			var fields = new Array ( parent.frames[1].document.forms[0].f_curr_fs_locn,parent.frames[1].document.forms[0].patient_id,parent.frames[1].document.forms[0].patient_file_type);
			var names = new Array (getLabel("eFM.FSLocation.label","FM"), getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"));		
		}
		var errors = "";
		for( var i=0; i<fields.length; i++ ) 
		{
			if(trimCheck(fields[i].value)) 
			{
				fields[i].value = trimString(fields[i].value);
			}
			else
			{
			//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors = errors + getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
				errors= errors.replace('$',names[i]);
			}
		}
		if (errors.length != 0) 
		{
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		if (to_proceed == true)
		{
			
			var p_file_no = parent.frames[1].document.forms[0].file_no.value;
					
			if(file_type_appl_yn == 'Y')
				var file_type_code = parent.frames[1].document.forms[0].patient_file_type.value;

			var p_pat_file_no	= parent.frames[1].document.forms[0].patient_id.value;
			var volume_no		= parent.frames[1].document.forms[0].volume_no.value;
			var appl_user_name  = document.forms[0].appl_user_name.value;

			if(file_type_appl_yn == 'N')
			{
				if(p_file_no.length > 0)
				{
					HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMLostFoundCheckFileExists.jsp'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='maintain_doc_or_file' id='maintain_doc_or_file' type='hidden' value='"+maintain_doc_or_file+"'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_file_no+"'><input name='p_curr_location' id='p_curr_location' type='hidden' value='"+p_curr_location+"'><input name='patient_id' id='patient_id' type='hidden' value='"+p_pat_file_no+"'><input name='volume_no' id='volume_no' type='hidden' value='"+volume_no+"'><input name='appl_user_name' id='appl_user_name' type='hidden' value='"+appl_user_name+"'></form></BODY></HTML>";
					parent.frames[4].document.write(HTMLVal);
					parent.frames[4].document.form1.submit();
				}
			}
			else if(file_type_appl_yn == 'Y')
			{
				if(file_type_code.length>0)
				{
					HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMLostFoundCheckFileExists.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_file_no+"'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='maintain_doc_or_file' id='maintain_doc_or_file' type='hidden' value='"+maintain_doc_or_file+"'><input name='p_patient_file_type_code' id='p_patient_file_type_code' type='hidden' value='"+file_type_code+"'><input name='p_curr_location' id='p_curr_location' type='hidden' value='"+p_curr_location+"'><input name='patient_id' id='patient_id' type='hidden' value='"+p_pat_file_no+"'><input name='volume_no' id='volume_no' type='hidden' value='"+volume_no+"'><input name='appl_user_name' id='appl_user_name' type='hidden' value='"+appl_user_name+"'></form></BODY></HTML>"; 
					parent.frames[4].document.write(HTMLVal);
					parent.frames[4].document.form1.submit();
				}
			}
		}
	}
	else if(maintain_doc_or_file == 'D')
	{
		var fields = new Array(		parent.frames[1].document.forms[0].f_curr_fs_locn,parent.frames[1].document.forms[0].doc_folder_id,parent.frames[1].document.forms[0].doc_type_code);
		var names  = new Array (getLabel("eFM.FSLocation.label","FM"), getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"));		
		var errors = "";
		for( var i=0; i<fields.length; i++) 
		{
			if(trimCheck(fields[i].value))
			{
				fields[i].value = trimString(fields[i].value);
			}
			else	
			{	
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors = errors + getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
				errors= errors.replace('$',names[i]);
			}
		}
		if ( errors.length != 0 ) 
		{
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		if (to_proceed==true)
		{
			var p_file_no     = parent.frames[1].document.forms[0].file_no.value;
			var patient_id    = parent.frames[1].document.forms[0].patient_id.value;
			var doc_folder_id = parent.frames[1].document.forms[0].doc_folder_id.value;
			var doc_type_code = parent.frames[1].document.forms[0].doc_type_code.value;
			var appl_user_name  = document.forms[0].appl_user_name.value;
					
			if(doc_folder_id.length > 0)
			{
				HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMLostFoundCheckFileExists.jsp'><input name='maintain_doc_or_file' id='maintain_doc_or_file' type='hidden' value='"+maintain_doc_or_file+"'><input name='p_doc_file_no' id='p_doc_file_no' type='hidden' value='"+p_file_no+"'><input name='doc_folder_id' id='doc_folder_id' type='hidden' value='"+doc_folder_id+"'><input name='doc_type_code' id='doc_type_code' type='hidden' value='"+doc_type_code+"'><input name='p_curr_location' id='p_curr_location' type='hidden' value='"+p_curr_location+"'><input name='patient_id' id='patient_id' type='hidden' value='"+patient_id+"'><input name='appl_user_name' id='appl_user_name' type='hidden' value='"+appl_user_name+"'></form></BODY></HTML>";
				parent.frames[4].document.write(HTMLVal);
				parent.frames[4].document.form1.submit();
			}
		}
	}
}
/*function checkPatientExists(obj)
{
	obj.value           = obj.value.toUpperCase();
	var p_curr_location = parent.frames[1].document.forms[0].f_curr_fs_locn.value;
	var to_proceed = true;
	var fields = new Array ( parent.frames[1].document.forms[0].f_curr_fs_locn);
	var names  = new Array ( "Current FS Location");	
	var errors = "";
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else	//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	}
	if ( errors.length != 0 ) 
	{
		parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[1].document.forms[0].f_curr_fs_locn.focus();
		to_proceed = false;
		return false ;
	}
	if (to_proceed == true)
	{
		var p_pat_file_no = obj.value.toUpperCase();
		if (p_pat_file_no.length>0)
		{
			HTMLVal = "<html><BODY><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMLostFoundCheckPatientExists.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_curr_location' id='p_curr_location' type='hidden' value='"+p_curr_location+"'></form></BODY></HTML>";
			parent.frames[4].document.write(HTMLVal);
			parent.frames[4].document.form1.submit();
		}
	}
}*/
function checkFileExists(obj) 
{
	obj.value = obj.value.toUpperCase();
	var p_curr_location = parent.frames[1].document.forms[0].f_curr_fs_locn.value;
	var to_proceed = true;
	var fields = new Array ( parent.frames[1].document.forms[0].f_curr_fs_locn);
	var names  = new Array ( getLabel("eFM.FSLocation.label","FM"));	
	var errors = "";
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else 
		{
		//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors = errors + getMessage("CAN_NOT_BE_BLANK","common")+ "<br>";
			errors= errors.replace('$',names[i]);
		}
	}
	if(errors.length != 0) 
	{
	parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		parent.frames[1].document.forms[0].f_curr_fs_locn.focus();
		to_proceed = false;
		return false ;
	}
	if (to_proceed == true)
	{
		var p_pat_file_no = obj.value.toUpperCase();
		if (p_pat_file_no.length>0)
		{
			HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMLostFoundCheckFileExists.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_curr_location' id='p_curr_location' type='hidden' value='"+p_curr_location+"'></form></BODY></HTML>";
			parent.frames[4].document.write(HTMLVal);
			parent.frames[4].document.form1.submit();
		}
	}
}
function populateFSLocation(obj)
{
	var p_new_status = obj.value;
	

	if(parent.frames[3].document.forms[0].p_new_status.value!="NA")
	{

	var sel          = parent.frames[3].document.forms[0].p_fs_location1;
	while(sel.options.length>1)
	{
		sel.remove(1);
	}
	if (p_new_status.length>0)
	{
		HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></head><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form2' id='form2' method='post' action='../../eFM/jsp/FMPopulateFSLocation.jsp'><input name='p_new_status' id='p_new_status' type='hidden' value='"+p_new_status+"'></form></BODY></HTML>";
		parent.frames[4].document.write(HTMLVal);
		parent.frames[4].document.form2.submit();
	}
	else
	{
		parent.frames[3].document.forms[0].p_fs_location1.value    = '';
		parent.frames[3].document.forms[0].p_fs_location1.disabled = false;	
	}

	}else
	{
		var sel          = parent.frames[3].document.forms[0].p_fs_location1;
		while(sel.options.length>1)
		{
			sel.remove(1);
		}

		var p_curr_location	= parent.frames[1].document.forms[0].f_curr_fs_locn.value; 

		var selIndex=parent.frames[1].document.forms[0].f_curr_fs_locn.options.selectedIndex;

		var desc = parent.frames[1].document.forms[0].f_curr_fs_locn.options[selIndex].text; 
	
		var opt	= parent.frames[3].document.createElement('OPTION');
		opt.value =	p_curr_location;
		opt.text = desc;
		parent.frames[3].document.forms[0].p_fs_location1.add(opt);
		parent.frames[3].document.forms[0].p_fs_location1.options[1].selected = true;

	}
}
function callChangeStatus(getVal,file_type_code,volumeNo,appl_user_name)
{
	var file_type_appl_yn = document.forms[0].file_type_appl_yn.value;
	parent.frames[3].document.location.href="../../eFM/jsp/FMLostFoundChangeStatus.jsp?p_patient_file_no="+getVal+"&p_patient_file_type="+file_type_code+"&file_type_appl_yn="+file_type_appl_yn+"&volume_no="+volumeNo+"&appl_user_name="+appl_user_name;
}
function DTcallChangeStatus(getVal,doc_type_code,doc_folder_id,appl_user_name)
{
	parent.frames[3].document.location.href="../../eFM/jsp/DTLostFoundChangeStatus.jsp?p_doc_file_no="+getVal+"&doc_type_code="+doc_type_code+"&doc_folder_id="+doc_folder_id+"&appl_user_name="+appl_user_name;
}

prev=0;
k=0;
function changeRowColor(obj,n)
{
	var i= obj.name;
	i=parseInt(i);
	for( k=0;k<n;k++)
		document.getElementById("tb1").rows(prev).cells(k).style.backgroundColor=obj.style.backgroundColor;
	for( k=0;k<n;k++)
		document.getElementById("tb1").rows(i-1).cells(k).style.backgroundColor="#B2B6D7" ;
	prev = i-1;
}

function PopulateData(objval) 
{
	if(objval != '') 
	{
		parent.frames[3].document.forms[0].locn_code.value = '';
		parent.frames[3].document.forms[0].locn_desc.value = '';
		if(objval == 'D')
		{
			if(parent.frames[3].document.forms[0].locn_desc.disabled == false)
				parent.frames[3].document.forms[0].locn_desc.disabled = true;
			if(parent.frames[3].document.forms[0].locn_button.disabled == false)
				parent.frames[3].document.forms[0].locn_button.disabled = true;
		}
		else
		{
			if(parent.frames[3].document.forms[0].locn_desc.disabled == true)
				parent.frames[3].document.forms[0].locn_desc.disabled = false;
			if(parent.frames[3].document.forms[0].locn_button.disabled == true)
				parent.frames[3].document.forms[0].locn_button.disabled = false;
		}
		
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='fm_change_status_lost_found' id='fm_change_status_lost_found' method='post' action='../../eFM/jsp/FMChangeFilePopup.jsp?locn_code="+objval+"'></form></body></html>" ;
		parent.frames[4].document.write(HTMLVal) ;
		parent.frames[4].document.fm_change_status_lost_found.submit() ;
	}
	else 
	{
		var len = parent.frames[3].fm_change_status_lost_found.p_fs_location.length;
		for (var i=0; i<=len; i++) 
		{
			parent.frames[3].fm_change_status_lost_found.p_fs_location.remove("p_fs_location");
		}
		var opt	= parent.frames[3].fm_change_status_lost_found.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "------ "+getLabel("Common.defaultSelect.label","common")+" ------";
		parent.frames[3].fm_change_status_lost_found.p_fs_location.add(opt);

		parent.frames[3].document.forms[0].locn_code.value = '';
		parent.frames[3].document.forms[0].locn_desc.value = '';
		if(parent.frames[3].document.forms[0].locn_desc.disabled == false)
			parent.frames[3].document.forms[0].locn_desc.disabled = true;
		if(parent.frames[3].document.forms[0].locn_button.disabled == false)
			parent.frames[3].document.forms[0].locn_button.disabled = true;
	}
}
////************  JS files of FMLostFoundSearch.jsp  *******************/////

	function Clearval()
	{ 
		var maintain_doc_or_file = document.forms[0].maintain_doc_or_file.value;
		if(maintain_doc_or_file == 'F')
			parent.search_criteria.document.getElementById("hdr_tab").style.visibility = 'hidden';
		else if(maintain_doc_or_file == 'D')
			parent.search_criteria.document.getElementById("hdr_tab1").style.visibility = 'hidden';
		parent.record_lost_found_frame.location.href='../../eCommon/html/blank.html';
		parent.change_file_status.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
	function changeToUpper(obj)
	{
		obj.value = obj.value.toUpperCase();
	}
	
	function searchCode(target,facilityid)
	{
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		tit=getLabel("Common.user.label","common");
		sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
		search_code="APPL_USER_ID";
		search_desc= "APPL_USER_NAME";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
		
		var arr=new Array();
		if (!(retVal == null))
		{
			var retVal=unescape(retVal);
			arr=retVal.split("::");
			document.forms[0].appl_user_id1.value=arr[0];
			document.forms[0].appl_user_id.value=arr[1];
		}
	}
////************End of JS files of FMLostFoundSearch.jsp ****************/////

////************ JS files of FMLostFoundFMLostFoundChangeStatus.jsp.jsp        ****************/////
async function getValidRecords(locn_desc)
{
	var	p_fs_location	= document.forms[0].p_fs_location.value;
    if(p_fs_location != '')
	{
		var	fs_locn_id	= document.forms[0].fs_locn_idty.value;	
		if ((fs_locn_id == "C") || (fs_locn_id == "N") || (fs_locn_id == "Y") || (fs_locn_id == "E"))
		{
			var target			= document.forms[0].locn_desc;
			var code			= document.forms[0].locn_code.value;
			var p_fs_location1	= document.forms[0].p_fs_location1.value;
			var facility_id		= document.forms[0].p_facility_id.value;	
			var retVal			= new String();
			var argumentArray	= new Array() ;
			var dataNameArray	= new Array() ;
			var dataValueArray	= new Array() ;
			var dataTypeArray	= new Array() ;

			if ((fs_locn_id == "C"))
			{
				sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
				
				window_title	=	getLabel("Common.clinic.label","common");
				
				dataNameArray[0]	= "facility_id" ;
				dataValueArray[0]	= facility_id;
				dataTypeArray[0]	= STRING ;
				
				dataNameArray[1]	= "mr_location_code" ;
				dataValueArray[1]	= p_fs_location;
				dataTypeArray[1]	= STRING ;

			}
			else if ((fs_locn_id == "Y"))
			{
				sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'D' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
				
				window_title	=	getLabel("Common.DaycareUnit.label","common");
				
				dataNameArray[0]	= "facility_id" ;
				dataValueArray[0]	= facility_id;
				dataTypeArray[0]	= STRING ;
				
				dataNameArray[1]	= "mr_location_code" ;
				dataValueArray[1]	= p_fs_location;
				dataTypeArray[1]	= STRING ;

			}
			else if ((fs_locn_id == "E"))
			{
				sql	=	"Select clinic_code code, long_desc description from op_clinic_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and mr_location_code like ? and  care_locn_type_ind = 'E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
				
				window_title	=	getLabel("Common.ProcedureUnit.label","common");
				
				dataNameArray[0]	= "facility_id" ;
				dataValueArray[0]	= facility_id;
				dataTypeArray[0]	= STRING ;
				
				dataNameArray[1]	= "mr_location_code" ;
				dataValueArray[1]	= p_fs_location;
				dataTypeArray[1]	= STRING ;

			}
			else if ((fs_locn_id == "N"))
			{
				sql	=	"Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where eff_status='E' and facility_id like ? and language_id='"+localeName+"' and fs_locn_code like ? and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
				
				window_title	=	getLabel("Common.nursingUnit.label","common");
				
				dataNameArray[0]	= "facility_id" ;
				dataValueArray[0]	= facility_id;
				dataTypeArray[0]	= STRING ;
			
				dataNameArray[1]	= "fs_locn_code" ;
				dataValueArray[1]	= p_fs_location;
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
			
			if(retVal != null && retVal != "" )
			{
				var ret1	=	unescape(retVal);
				arr=ret1.split(",");
				document.forms[0].locn_code.value		=	arr[0];
				document.forms[0].locn_desc.value		=	arr[1];
			}
			else
			{
				document.forms[0].locn_desc.value	=	"";
				document.forms[0].locn_code.value	=	"";
			} 
		}
		if (fs_locn_id == "T")
		{
			var target			= document.forms[0].locn_desc;
			var code			= document.forms[0].locn_code;
			getPractitioner(code, target);
		}
	}
}
function getPractitioner(obj, target)
{
	var practName_FName="";
	var practName_FValue="";

	practName_FName=target.name;
	practName_FValue=target.value;

	var facility_id		= document.forms[0].p_facility_id.value;

	getPractitioner_common(obj,target,"",facility_id,"Q2");

	//latest var sql = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";

	//latest var sql2 = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
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
function PractLookupRetVal(retVal,objName)
{

	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.forms[0].locn_code.value=arr[0];
		document.forms[0].locn_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].locn_code.value="";
		document.forms[0].locn_desc.value="";			
	}

} // End of PractL
function showIdentity(obj)
{
	if((obj.value=="F") || (obj.value=="R"))
	{
		document.getElementById("td2").style.display="none";
		document.getElementById("td1").style.display="inline";
		document.getElementById("td1").style.visibility="visible";		
	}
	else 
	{
 		 document.getElementById("td1").style.display    = "none";
		 document.getElementById("td2").style.display    = "inline";
		 document.getElementById("td2").style.visibility = "visible";
	}
if(obj.value=="")
	{
      document.getElementById("td1").style.display    = "inline";
	  document.getElementById("td2").style.display    = "none";
	
	document.forms[0].fs_locn_idty.value="";
	document.forms[0].p_fs_location.value="";
	document.forms[0].locn_desc.value="";
	document.forms[0].locn_desc.disabled=true;
	document.forms[0].locn_button.disabled=true;
	removeitems(document.forms[0].p_fs_location);
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

async function  searchUpdatedByCode(target1,facilityid) 
	{
	var target			= document.forms[0].updated_by_name;
	
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	tit = getLabel("Common.user.label","common");
	//sql = "Select APPL_USER_ID code, APPL_USER_NAME description from SM_FACILITY_FOR_USER_VW where upper(facility_id) like upper(?) and upper(APPL_USER_ID) like upper(?) and upper(APPL_USER_NAME) like upper(?)"

   //Below code was modified by N Munisekhar on 23-Jan-2013 against SKR-SCF-0761 [IN:037419] 
	sql= "select a.appl_user_id code, b.appl_user_name description from SM_FACILITY_FOR_USER a, sm_appl_user_lang_vw  b where a.appl_user_id = b.appl_user_id and language_id = '"+localeName+"' and a.facility_id = '"+facilityid+"' and upper(a.APPL_USER_ID) like upper(?) and upper(b.APPL_USER_NAME) like upper(?) and b.eff_status = 'E' ";
	// end of SKR-SCF-0761 [IN:037419] 

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] =  DESC_LINK;
	argumentArray[7] = DESC_CODE ;
	
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ) {
		var ret1	=	unescape(retVal);
		arr=ret1.split(",");
		  document.forms[0].updated_by_name.value = arr[1];
			document.forms[0].p_updated_by.value    = arr[0];
		}
		else
		{
			document.forms[0].updated_by_name.value = "";
			document.forms[0].p_updated_by.value    = "";
		 //  Cls();
	}
} // End of getUser().



async function searchUpdatedByCode1(target,facilityid)
{
		var retVal      = new String();
		var dialogHeight= "28";
		var dialogWidth	= "43";
		var status      = "no";
		var arguments	= "" ;
		var sql         = "";
		var search_code = "";
		var search_desc = "";
		var tit = "";
		
		tit = getLabel("Common.user.label","common");
		sql = "select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
		search_code="APPL_USER_ID";
		search_desc= "APPL_USER_NAME";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr = new Array();

		if (!(retVal == null))
		{
			var retVal = unescape(retVal);
		    arr=retVal.split("::");

		    document.forms[0].updated_by_name.value = arr[0];
			document.forms[0].p_updated_by.value    = arr[1];
		}
		else
		{
			document.forms[0].updated_by_name.value = "";
			document.forms[0].p_updated_by.value    = "";
		}
	}
	function ChkValue(Objval)
	{
		//if(Objval == '')
		//{
			document.forms[0].locn_code.value = "";
			document.forms[0].locn_desc.value = "";		
		//}
	}
////************ End of JS files of FMLostFoundFMLostFoundChangeStatus.jsp.jsp ****************/////
function onSuccess()
{
	parent.parent.frames[2].frames[1].location.reload();
	parent.parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html';
	parent.parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html';
}
function reset()
{
	//parent.parent.frames[1].frames[1].location.href='../../eFM/jsp/FMLostFoundSearch.jsp';
	parent.frames[2].frames[1].location.reload();
	parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[3].location.href='../../eCommon/html/blank.html';
}

function showEncounter(enc,patid,Patient_Class)
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
	retVal = window.showModalDialog("../../eFM/jsp/"+jsp_name+"?encounterId="+enc+"&call_function="+call_function+"&patientId="+patid+"&Patient_Class="+Patient_Class,arguments,features);
}

 function  clearvalues(obj)
 {
parent.frames[1].document.forms[0].patient_id.value="";
parent.frames[1].document.forms[0].patient_id.onblur();


 }


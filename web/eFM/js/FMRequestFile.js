/*
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Request of File
*/




function checkPatientExists(obj)
{
	
	
	var conc_remarks = "";
	if (parent.frames[4].document.forms[0]  ) {
		if (parent.frames[4].document.forms[0].p_total_select) {
			var num_sel_recs = parent.frames[4].document.forms[0].p_total_select.value;
			for (var i=1; i<=num_sel_recs; i++) {
				var tempobj		= eval('parent.frames[4].document.forms[0].rem_recnum_'+i);
				var tempobj1	= eval('parent.frames[4].document.forms[0].p_file_no'+i);
				var tempobj2	= eval('parent.frames[4].document.forms[0].p_file_required_on'+i);

				tempobj1 = tempobj1.value;
				tempobj2 = tempobj2.value;
				tempobj1 = tempobj1.substring(0, tempobj1.indexOf('`'));
				if (tempobj) {
					 tempobj = escape(tempobj.value) ;
				/*	if (conc_remarks == "")
						conc_remarks += tempobj1 + '`' + tempobj + '`' + tempobj2;
					else
						conc_remarks += '~' + tempobj1 + '`' + tempobj + '`' + tempobj2;
*/
					if (conc_remarks == "")
					{
						//conc_remarks += tempobj1 + tempobj2 + '`' + tempobj + '`' + tempobj3Temp;
						conc_remarks += tempobj1 +  '`' ;
						if (tempobj == '') 
							conc_remarks += '#';
						else
							conc_remarks += tempobj;
						conc_remarks += '`' ;
						if (tempobj2 == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj2;
					}
					else
					{
						//conc_remarks += '~' + tempobj1 + tempobj2 + '`' + tempobj + '`' + tempobj3Temp;
						conc_remarks += '~' + tempobj1 + '`' ;
						if (tempobj == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj;
						conc_remarks += '`' ;
						if (tempobj2 == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj2;
					}

				}
			}
		}
	}

	var p_pat_file_no = obj.value;
	if (p_pat_file_no.length!=0)
	{

	obj.value = obj.value.toUpperCase();

	var to_proceed = true;

	var fields = new Array ( parent.frames[1].document.forms[0].req_location);
	//var names = new Array ( "File Storage Location");
	var names = new Array ( getLabel("eFM.FSLocation.label","FM"));

	var errors = "";

	for( var i=0; i<fields.length; i++ )
	{
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			var errors1=getMessage("CAN_NOT_BE_BLANK","common");
			errors1 = errors1.replace("$",names[i]);
			errors = errors + errors1 + "<br>";
		}
	}
	if ( errors.length != 0 )
	{
	parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}

if (to_proceed==true)
{
	var p_enter_fcy ="";
		var p_req_fs_locn = parent.frames[1].document.forms[0].req_location.value;

	if (parent.frames[2].document.forms[0].logged_fcy.value=='E')
	{
		p_enter_fcy = parent.frames[2].document.forms[0].enter_fcy.value;
	}

    	var p_pat_file_no = parent.frames[3].document.forms[0].p_patient_id.value;
		var facility_id = parent.frames[3].document.forms[0].facilityid.value; 
		var file_type_appl_yn = parent.frames[3].document.forms[0].file_type_appl_yn.value; 

		HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMCheckPatientExists.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='conc_remarks' id='conc_remarks' type='hidden' value="+conc_remarks+"><input name='p_enter_fcy' id='p_enter_fcy' type='hidden' value='"+p_enter_fcy+"'>><input name='p_req_fs_locn' id='p_req_fs_locn' type='hidden' value='"+p_req_fs_locn+"'><input name='facility_id' id='facility_id' type='hidden' value='"+facility_id+"'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'></form></BODY></HTML>";

		parent.frames[6].document.write(HTMLVal);
		parent.frames[6].document.form1.submit();
		}
	}
}

//var added_volumes = new ActiveXObject("Scripting.Dictionary");
var added_volumes = {};

function addFiles()
{
	//alert(parent.frames[2].document.getElementById("patientid1").name);
	
  var conc_remarks = "";
	if(parent.frames[4].document.forms[0]) 
	{
		if(parent.frames[4].document.forms[0].p_total_select) 
		{
			var num_sel_recs = parent.frames[4].document.forms[0].p_total_select.value;
			for(var i=1; i<=num_sel_recs; i++) 
			{
				var tempobj		= eval('parent.frames[4].document.forms[0].rem_recnum_'+i);
				var tempobj1	= eval('parent.frames[4].document.forms[0].p_file_no'+i);
				var tempobj2	= eval('parent.frames[4].document.forms[0].p_volume_no'+i);
				var tempobj3	= eval('parent.frames[4].document.forms[0].p_file_required_on'+i);

				tempobj1 = tempobj1.value;
				tempobj1 = tempobj1.substring(0, tempobj1.indexOf('`'));
				tempobj2 = tempobj2.value;
				tempobj3 = tempobj3.value;
			
				var remTemp = '';
				
				if(tempobj)
				{
					 //tempobj = escape(tempobj.value) ;
					 tempobj = tempobj.value;
					if (conc_remarks == "")
					{
						//conc_remarks += tempobj1 + tempobj2 + '`' + tempobj + '`' + tempobj3Temp;
						conc_remarks += tempobj1 + tempobj2 + '`' ;
						if (tempobj == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj;
						conc_remarks += '`' ;
						if (tempobj3 == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj3;
					}
					else
					{
						//conc_remarks += '~' + tempobj1 + tempobj2 + '`' + tempobj + '`' + tempobj3Temp;
						conc_remarks += '~' + tempobj1 + tempobj2 + '`' ;
						if (tempobj == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj;
						conc_remarks += '`' ;
						if (tempobj3 == '') 
							conc_remarks += '#'
						else
							conc_remarks += tempobj3;
					}
				}
			}
		}
	}
	
	var maintain_doc_or_file = parent.frames[3].document.forms[0].maintain_doc_or_file.value;
	if(maintain_doc_or_file == "D")
	{
		if(parent.frames[3].document.forms[0].doctype_appl_yn)
		{
			var doctype_appl_yn = parent.frames[3].document.forms[0].doctype_appl_yn.value;
		}
		else 
		{
			var doctype_appl_yn = "";
		}
		var p_patient_id	= parent.frames[3].document.forms[0].p_patient_id.value;
		var p_pat_file_no	= parent.frames[3].document.forms[0].p_file_no.value;
		var p_req_fs_locn   = parent.frames[1].document.forms[0].req_location.value;
		var p_old_string    = parent.frames[3].document.forms[0].p_select_values.value;
		var file_type		= parent.frames[3].document.forms[0].patient_file_type.value;
		var volume_no		= "";
		var added_val		= parent.frames[3].document.forms[0].added_values.value;
		var added_volume_no = parent.frames[3].document.forms[0].added_volumes.value;
		var invalid_volumes = parent.frames[3].document.forms[0].invalid_volumes.value;
		var file_type_appl_yn = parent.frames[3].document.forms[0].file_type_appl_yn.value;
		if(added_volume_no=="")
			//added_volumes.RemoveAll();
		added_volumes={};
		var added_volume = "";
		var p_enter_fcy = "";
		if (parent.frames[2].document.forms[0].logged_fcy.value=='E')
		{
			p_enter_fcy = parent.frames[2].document.forms[0].enter_fcy.value;
		}
		var doc_or_file		= parent.frames[3].document.forms[0].doc_or_file.value;		
		var doc_folder_id	= parent.frames[3].document.forms[0].doc_folder_id.value;
		var FS_LOCN_ID		= parent.frames[1].document.forms[0].FS_LOCN_ID.value;
		if (parent.frames[2].document.forms[0].logged_fcy.value=='E')
		{
			var fields = new Array ( parent.frames[1].document.forms[0].req_location,parent.frames[2].document.forms[0].enter_fcy,parent.frames[1].document.forms[0].req_name);
			var names = new Array ( getLabel("eFM.FSLocation.label","FM"),getLabel("Common.enterprisefacility.label","common"), getLabel("Common.name.label","common"));
		}
		else
		{
			var fields = new Array ( parent.frames[1].document.forms[0].req_location,parent.frames[1].document.forms[0].req_name);
			var names = new Array ( getLabel("eFM.FSLocation.label","FM"),getLabel("Common.name.label","common"));
		}
		
		if (FS_LOCN_ID != "D")
		{
			fields[fields.length]	=	parent.frames[1].document.forms[0].requesting;
			if (FS_LOCN_ID == "C")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.clinic.label","common");
			else if (FS_LOCN_ID == "N")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.nursingUnit.label","common");
			else if (FS_LOCN_ID == "T")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.practitioner.label","common");
			else if (FS_LOCN_ID == "Y")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+  getLabel("Common.DaycareUnit.label","common");
			else if (FS_LOCN_ID == "E")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.ProcedureUnit.label","common");
			else if (FS_LOCN_ID == "")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM");
		}

		fields[fields.length]	=	parent.frames[1].document.forms[0].req_narration;
		names[names.length]		=	getLabel("eFM.ReasonForBorrowing.label","FM");
		//names[names.length]		=	"Reason for Borrowing";

//		fields[fields.length]	=	parent.frames[3].document.forms[0].doc_folder_id;
//		names[names.length]		=	"Document Folder";
		
		
		var errors = "";

		for( var i=0; i<fields.length; i++ )
		{
			if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
			}
			else	
			{
				var err1=getMessage("CAN_NOT_BE_BLANK","common");
				err1=err1.replace("$",names[i]);
				errors = errors +err1  + "<br>";
				//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;

			}
		}
		
		
	if (doc_folder_id=="" && p_patient_id=="")
	{
	//errors = errors + "APP-FM0115  Document Folder or Patient ID has to be selected..." + "<br>" ;
	errors = errors + getMessage("DOC_FOL_OR_PAT_ID_TO_BE_SEL","FM")+ "<br>" ;
	}	
		if ( errors.length != 0 )
		{
			parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMCheckFileExists.jsp' ><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_patient_id' id='p_patient_id' type='hidden' value='"+p_patient_id+"'><input name='p_req_fs_locn' id='p_req_fs_locn' type='hidden' value='"+p_req_fs_locn+"'><input name='conc_remarks' id='conc_remarks' type='hidden' value="+conc_remarks+"><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='file_type' id='file_type' type='hidden' value='"+file_type+"'><input name='volume_no' id='volume_no' type='hidden' value='"+volume_no+"'><input name='added_values' id='added_values' type='hidden' value='"+added_val+"'><input name='added_volume' id='added_volume' type='hidden' value='"+escape(added_volume)+"'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='p_enter_fcy' id='p_enter_fcy' type='hidden' value='"+p_enter_fcy+"'><input name='doc_or_file' id='doc_or_file' type='hidden' value='"+doc_or_file+"'><input name='doctype_appl_yn' id='doctype_appl_yn' type='hidden' value='"+doctype_appl_yn+"'></form></BODY></HTML>";

		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.form1.submit();
		
	}
	else if(maintain_doc_or_file == "F")
	{
		var FS_LOCN_ID=parent.frames[1].document.forms[0].FS_LOCN_ID.value;
		if (parent.frames[2].document.forms[0].logged_fcy.value=='E')
		{
			
			var fields = new Array (parent.frames[1].document.forms[0].req_location,parent.frames[2].document.forms[0].enter_fcy,parent.frames[1].document.forms[0].req_name);
			var names = new Array (getLabel("eFM.FSLocation.label","FM"), getLabel("Common.enterprisefacility.label","common"), getLabel("Common.name.label","common"));
		}
		else
		{
			if(parent.frames[1].document.forms[0].req_name!=undefined){
			var fields = new Array ( parent.frames[1].document.forms[0].req_location);
			var names = new Array ( getLabel("eFM.FSLocation.label","FM"));
			}else{
     var fields = new Array ( parent.frames[1].document.forms[0].req_location,parent.frames[1].document.forms[0].req_name);
			var names = new Array ( getLabel("eFM.FSLocation.label","FM"), getLabel("Common.name.label","common"));

			}
		}

	
		
		if(FS_LOCN_ID != "D")
		{
			if(parent.frames[1].document.forms[0].requesting!=undefined)
			{
			fields[fields.length]	=	parent.frames[1].document.forms[0].requesting;
			if (FS_LOCN_ID == "C")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.clinic.label","common");
			else if (FS_LOCN_ID == "N")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.nursingUnit.label","common");
			else if (FS_LOCN_ID == "T")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.practitioner.label","common");
			else if (FS_LOCN_ID == "Y")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+  getLabel("Common.DaycareUnit.label","common");
			else if (FS_LOCN_ID == "E")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.ProcedureUnit.label","common");
			else if (FS_LOCN_ID == "")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM");
			}
		}

		if(parent.frames[1].document.forms[0].req_narration!=undefined)
			{
		fields[fields.length]	=	parent.frames[1].document.forms[0].req_narration;
		//names[names.length]		=	"Reason for Borrowing";
		names[names.length]		=	getLabel("eFM.ReasonForBorrowing.label","FM");
			}
		if(parent.frames[3].document.forms[0].p_patient_id!=undefined){
		fields[fields.length]	=	parent.frames[3].document.forms[0].p_patient_id;
		names[names.length]		=	getLabel("Common.patientId.label","common");
		}
		
		if (parent.frames[3].document.forms[0].file_type_appl_yn.value == "Y")
		{ 
			if(parent.frames[3].document.forms[0].patient_file_type!=undefined){
			fields[fields.length]	=	parent.frames[3].document.forms[0].patient_file_type;
			names[names.length]		=	getLabel("Common.filetype.label","common");
			}
		}
		else if (parent.frames[3].document.forms[0].file_type_appl_yn.value == "N")
		{
			if(parent.frames[3].document.forms[0].p_file_no!=undefined){
			fields[fields.length]	=	parent.frames[3].document.forms[0].p_file_no;
			names[names.length]		=	getLabel("Common.fileno.label","common");
			}
		}
		var errors = "";
		
		for( var i=0; i<fields.length; i++ )
		{ 
			if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
			}
			else	
			{
				var temp=getMessage("CAN_NOT_BE_BLANK","common");
				temp=temp.replace("$",names[i]);
				errors = errors + temp + "<br>" ;
				//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			}
		}
		
		if ( errors.length != 0 )
		{
			parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		var p_old_string  = parent.frames[3].document.forms[0].p_select_values.value;
		var p_req_fs_locn = parent.frames[1].document.forms[0].req_location.value;
		
		var fileno_name			= document.forms[0].fileno_name.value;
		var filetype_name		= document.forms[0].filetype_name.value;
		var file_no_function	= document.forms[0].file_no_function.value;
		var file_type_function	= document.forms[0].file_type_function.value;
		var frame_name			= document.forms[0].frame_name.value;
		var form_name			= document.forms[0].form_name.value;
		var volumeno_name		= document.forms[0].volumeno_name.value;
	 	
		if(parent.frames[3].document.forms[0].p_file_no)
		if (parent.frames[3].document.forms[0].p_file_no.value.length>0)
		{
			
			var p_pat_file_no = parent.frames[3].document.forms[0].p_file_no.value;
			var file_type = parent.frames[3].document.forms[0].patient_file_type.value;
			var volume_no = parent.frames[3].document.forms[0].volume_no.value;
			var added_val = parent.frames[3].document.forms[0].added_values.value;
			var added_volume_no = parent.frames[3].document.forms[0].added_volumes.value;
			var invalid_volumes = parent.frames[3].document.forms[0].invalid_volumes.value;
			var file_type_appl_yn = parent.frames[3].document.forms[0].file_type_appl_yn.value;
			if (added_volume_no=="")
				added_volumes.RemoveAll();
			var added_volume = "";
			if (volume_no != "")
			{
				added_volume = "'"+volume_no+"'";
				//if (!added_volumes.Exists(added_volume)) cmt by vjn for EDGE testing
					if (!added_volumes.hasOwnProperty(added_volume))
					//added_volumes.add(added_volume, added_volume);
				added_volumes[added_volume]= added_volume;
				if (added_volumes.hasOwnProperty(invalid_volumes))
					//added_volumes.remove(invalid_volumes);
				delete added_volumes[invalid_volumes];
				//added_volume= ((added_volumes.Keys()).toArray()).toString();
				added_volume = 	Object.keys(added_volumes).toString();
				parent.frames[3].document.forms[0].added_volumes.value = "Y";
			}
			var p_enter_fcy = "";
			if (parent.frames[2].document.forms[0].logged_fcy.value=='E')
			{
				p_enter_fcy = parent.frames[2].document.forms[0].enter_fcy.value;
			}
				
			HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMCheckFileExists.jsp' ><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='p_req_fs_locn' id='p_req_fs_locn' type='hidden' value='"+p_req_fs_locn+"'><input name='conc_remarks' id='conc_remarks' type='hidden' value='"+conc_remarks+"'><input name='p_old_string' id='p_old_string' type='hidden' value='"+p_old_string+"'><input name='file_type' id='file_type' type='hidden' value='"+file_type+"'><input name='volume_no' id='volume_no' type='hidden' value='"+volume_no+"'><input name='added_values' id='added_values' type='hidden' value='"+added_val+"'><input name='added_volume' id='added_volume' type='hidden' value='"+escape(added_volume)+"'><input name='file_type_appl_yn' id='file_type_appl_yn' type='hidden' value='"+file_type_appl_yn+"'><input name='p_enter_fcy' id='p_enter_fcy' type='hidden' value='"+p_enter_fcy+"'><input name='fileno_name' id='fileno_name' type='hidden' value='"+fileno_name+"'><input name='filetype_name' id='filetype_name' type='hidden' value='"+filetype_name+"'><input name='file_no_function' id='file_no_function' type='hidden' value='"+file_no_function+"'><input name='file_type_function' id='file_type_function' type='hidden' value='"+file_type_function+"'><input name='frame_name' id='frame_name' type='hidden' value='"+frame_name+"'><input name='form_name' id='form_name' type='hidden' value='"+form_name+"'><input name='volumeno_name' id='volumeno_name' type='hidden' value='"+volumeno_name+"'></form></BODY></HTML>";

			parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.document.form1.submit();
		}
		else
		{
			var p_pat_file_no = parent.frames[3].document.forms[0].p_patient_id.value;

			HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMCheckPatientExists.jsp'><input name='p_patient_file_no' id='p_patient_file_no' type='hidden' value='"+p_pat_file_no+"'><input name='fileno_name' id='fileno_name' type='hidden' value='"+fileno_name+"'><input name='filetype_name' id='filetype_name' type='hidden' value='"+filetype_name+"'><input name='file_no_function' id='file_no_function' type='hidden' value='"+file_no_function+"'><input name='file_type_function' id='file_type_function' type='hidden' value='"+file_type_function+"'><input name='frame_name' id='frame_name' type='hidden' value='"+frame_name+"'><input name='form_name' id='form_name' type='hidden' value='"+form_name+"'><input name='volumeno_name' id='volumeno_name' type='hidden' value='"+volumeno_name+"'></form></BODY></HTML>";

			parent.frames[6].document.write(HTMLVal);
			parent.frames[6].document.form1.submit();
		}
	
		if(parent.frames[3].document.forms[0].p_file_no)
		{
		if(parent.frames[3].document.forms[0].p_file_no.value.length==0 && parent.frames[3].document.forms[0].p_patient_id.value.length==0)
		{
			var errors = getMessage('ENTER_PATIENT_FILENO','FM');
			parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		}
		}else{
   if(parent.frames[3].document.forms[0].p_patient_id.value.length==0)
		{
			var errors = getMessage('ENTER_PATIENT_FILENO','FM');
			parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		}

		}
	
	}

}

function callDeselect()
{
	var p_count = parent.frames[4].document.forms[0].p_total_select.value;
	var p_deselect_file_no = parent.frames[3].document.forms[0].p_deselect_files.value;
	var p_select_file_no = parent.frames[3].document.forms[0].p_select_files.value;

	for (var i=1;i<=p_count;i++ )
	{
		if (eval("parent.frames[4].document.forms[0].req_select"+i+".checked")==false)
		{
			if (p_deselect_file_no==null)
			{
				p_deselect_file_no = '';
			}
				p_deselect_file_no = p_deselect_file_no + '|' + eval("parent.frames[4].document.forms[0].p_file_no"+i+".value");
		}
		else
		{
			if (p_select_file_no==null)
			{
				p_select_file_no = '';
			}
				p_select_file_no = p_select_file_no + '|' + eval("parent.frames[4].document.forms[0].p_file_no"+i+".value");
		}
	}

	parent.frames[3].document.forms[0].p_select_files.value = p_select_file_no ;
	parent.frames[3].document.forms[0].p_deselect_files.value = p_deselect_file_no ;

	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMRequestSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value="+p_select_file_no+"><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"></form></BODY></HTML>";

	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.form1.submit();

	parent.frames[5].document.location.href='../../eFM/jsp/FMRequestDeselectFrame.jsp';

	HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form2' id='form2' method='post' action='../../eFM/jsp/FMRequestDeSelectedFiles.jsp'><input name='p_new_string' id='p_new_string' type='hidden' value='"+p_deselect_file_no+"'></form></BODY></HTML>";

	parent.frames[6].document.write(HTMLVal);
	parent.frames[6].document.form2.submit();
}

function callSelect()
{
	var p_deselect_file_no ;
	var p_select_file_no = parent.frames[3].document.forms[0].p_select_files.value;
	var p_deselect_count = parent.frames[6].document.forms[0].p_deselect_count.value;

	for(var i=0;i<p_deselect_count;i++)
	{
		if (eval("parent.frames[6].document.forms[0].req_deselect"+i+".checked")==true)
		{
			if (p_select_file_no==null)
			{
				p_select_file_no = '';
			}
				p_select_file_no = p_select_file_no + '|' + eval("parent.frames[6].document.forms[0].p_file_no"+i+".value");
		}
		else
		{
			if (p_deselect_file_no==null)
			{
				p_deselect_file_no = '';
			}
				p_deselect_file_no = p_deselect_file_no + '|' + eval("parent.frames[6].document.forms[0].p_file_no"+i+".value");
		}
	}

	parent.frames[3].document.forms[0].p_select_files.value = p_select_file_no ;
	parent.frames[3].document.forms[0].p_deselect_files.value = p_deselect_file_no ;

	HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMRequestSelectedFiles.jsp'><input name='p_select_files' id='p_select_files' type='hidden' value="+p_select_file_no+"><input name='p_deselect_files' id='p_deselect_files' type='hidden' value="+p_deselect_file_no+"></form></BODY></HTML>";

	parent.frames[4].document.write(HTMLVal);
	parent.frames[4].document.form1.submit();

	parent.frames[5].document.location.href='../../eFM/jsp/FMRequestDeselectFrame.jsp';

	HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form2' id='form2' method='post' action='../../eFM/jsp/FMRequestDeSelectedFiles.jsp'><input name='p_new_string' id='p_new_string' type='hidden' value='"+p_deselect_file_no+"'></form></BODY></HTML>";

	parent.frames[6].document.write(HTMLVal);
	parent.frames[6].document.form2.submit();
}

function apply()
{
	var p_file_no = "";
	var p_doc_folder_id = "";
	var p_doc_type_code = "";
	var p_rem_recnum = "";
	var p_patient_id = "";
	var p_volume_no = "";
	var file_type_code = "";
	var p_req_select;
	var p_total_cnt = "";
	var doc_or_file = "";
	var p_file_required_on = "";

	
	if(parent.frames[2].frames[3].document.forms[0].print_req_slip.checked==true)
	{
	parent.frames[2].frames[1].document.forms[0].print_req_slip.value='Y'
	}else{
    parent.frames[2].frames[1].document.forms[0].print_req_slip.value='N'
	}
	
	if(parent.frames[2].frames[1].document.forms[0])
	{
	doc_or_file = parent.frames[2].frames[1].document.forms[0].doc_or_file.value;	
	}
	if(parent.frames[2].frames[4].document.forms[0])
	{
	p_total_cnt = parent.frames[2].frames[4].document.forms[0].p_total_select.value;	
	parent.frames[2].frames[1].document.forms[0].tot_count.value=p_total_cnt;	
	}

	var to_proceed = true;
	var FS_LOCN_ID=parent.frames[2].frames[1].document.forms[0].FS_LOCN_ID.value;
	
	if (parent.frames[2].frames[2].document.forms[0].logged_fcy.value=='E')
	{
		var fields = new Array ( parent.frames[2].frames[1].document.forms[0].req_location, parent.frames[2].frames[2].document.forms[0].enter_fcy,parent.frames[2].frames[1].document.forms[0].req_name);
		var names = new Array (getLabel("eFM.FSLocation.label","FM"), getLabel("Common.enterprisefacility.label","common"), getLabel("Common.name.label","common"));
	}
	else
	{
		var fields = new Array ( parent.frames[2].frames[1].document.forms[0].req_location, parent.frames[2].frames[1].document.forms[0].req_name);
		var names = new Array (getLabel("eFM.FSLocation.label","FM"), getLabel("Common.name.label","common"));
	}
	if(FS_LOCN_ID != "D")
	{
		if (FS_LOCN_ID != "")
		{		
			fields[fields.length]	=	parent.frames[2].frames[1].document.forms[0].requesting;
			if (FS_LOCN_ID == "C")
				names[names.length]		=	getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.clinic.label","common");
			else if (FS_LOCN_ID == "N")
				names[names.length]		= getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.nursingUnit.label","common");
			else if (FS_LOCN_ID == "T")
				names[names.length]		= getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.practitioner.label","common");
			else if (FS_LOCN_ID == "Y")
				names[names.length]		= getLabel("eFM.Requesting.label","FM")+" "+  getLabel("Common.DaycareUnit.label","common");
			else if (FS_LOCN_ID == "E")
				names[names.length]		= getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.ProcedureUnit.label","common");
		}
	}	
	fields[fields.length]	=	parent.frames[2].frames[1].document.forms[0].req_narration;
	names[names.length]		=	getLabel("eFM.ReasonForBorrowing.label","FM");
	
	if(parent.frames[2].frames[1].document.forms[0].req_narration.options[parent.frames[2].frames[1].document.forms[0].req_narration.selectedIndex].text.toLowerCase()=="others"){
	fields[fields.length]	=	parent.frames[2].frames[1].document.forms[0].reason;
	names[names.length]		=	getLabel("Common.remarks.label","common");
	} 
	var errors = "";
	
	for( var i=0; i<fields.length; i++ )
	{
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{
		errors=errors + getMessage("CAN_NOT_BE_BLANK","common");
		errors=errors.replace("$",names[i]);
		errors=errors+"<br>";
		}//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	}
	if ( errors.length != 0 )
	{
		parent.frames[2].frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}

 if (to_proceed == true)
 {
	if (p_total_cnt.length  > 0)
	 {

	for(var counter=1;counter<=p_total_cnt;counter++)
	{
		p_req_select =
		eval("parent.frames[2].frames[4].document.forms[0].req_select"+counter+".checked");
		if (p_req_select==true)
		{
			if(p_file_no.length==0)
			{
				p_file_no = eval("parent.frames[2].frames[4].document.forms[0].p_file_no"+counter+".value");
				p_volume_no = eval("parent.frames[2].frames[4].document.forms[0].p_volume_no"+counter+".value");
				file_type_code = eval("parent.frames[2].frames[4].document.forms[0].file_type"+counter+".value");
				p_patient_id = eval("parent.frames[2].frames[4].document.forms[0].p_patient_id"+counter+".value");
				p_file_required_on = eval("parent.frames[2].frames[4].document.forms[0].p_file_required_on"+counter+".value");
				if (p_file_required_on == '')
				{
					p_file_required_on = '#';
				}
				if(doc_or_file == 'D')
				{
				p_doc_folder_id = eval("parent.frames[2].frames[4].document.forms[0].p_doc_folder_id"+counter+".value");
				p_doc_type_code = eval("parent.frames[2].frames[4].document.forms[0].p_doc_type_code"+counter+".value");
				}
			}
			else
			{
				p_file_no = p_file_no + "," + eval("parent.frames[2].frames[4].document.forms[0].p_file_no"+counter+".value");
				p_volume_no = p_volume_no + "|" + eval("parent.frames[2].frames[4].document.forms[0].p_volume_no"+counter+".value");
				file_type_code = file_type_code + "|" + eval("parent.frames[2].frames[4].document.forms[0].file_type"+counter+".value");
										
				p_patient_id = p_patient_id + "|" + eval("parent.frames[2].frames[4].document.forms[0].p_patient_id"+counter+".value");
				p_file_required_on = p_file_required_on + "|" ;
				var p_file_required_onT = eval("parent.frames[2].frames[4].document.forms[0].p_file_required_on"+counter+".value");
				if (p_file_required_onT == '')
				{
					p_file_required_on = p_file_required_on + "#" ;
				}
				else
					p_file_required_on = p_file_required_on + p_file_required_onT;
				if(doc_or_file == 'D')
				{
				p_doc_folder_id = p_doc_folder_id + "," + eval("parent.frames[2].frames[4].document.forms[0].p_doc_folder_id"+counter+".value");
				p_doc_type_code = p_doc_type_code + "," + eval("parent.frames[2].frames[4].document.forms[0].p_doc_type_code"+counter+".value");
				}
			}

			if (p_rem_recnum.length==0)
			{
				if (eval("parent.frames[2].frames[4].document.forms[0].rem_recnum_"+counter+".value") != "") {
					p_rem_recnum = eval("parent.frames[2].frames[4].document.forms[0].rem_recnum_"+counter+".value");
				}
				else {
//					p_rem_recnum = p_rem_recnum + "¡" + ':|:';
					p_rem_recnum =  '#';
				}
			}
			else {
				if (eval("parent.frames[2].frames[4].document.forms[0].rem_recnum_"+counter+".value") != "") {
					p_rem_recnum = p_rem_recnum + "~" + eval("parent.frames[2].frames[4].document.forms[0].rem_recnum_"+counter+".value");
					//p_rem_recnum = p_rem_recnum + "¡" + eval("parent.frames[2].frames[4].document.forms[0].rem_recnum_"+counter+".value");
				}
				else {
					p_rem_recnum = p_rem_recnum + "~" + '#';
					//p_rem_recnum = p_rem_recnum + "¡" + '#';
				}
			}
		}
	}
	
	parent.frames[2].frames[1].document.forms[0].p_file_nos.value = p_file_no;
	if(doc_or_file == 'D')
	{
	parent.frames[2].frames[1].document.forms[0].p_doc_folder_id.value = p_doc_folder_id;
	parent.frames[2].frames[1].document.forms[0].p_doc_type_code.value = p_doc_type_code;
	}
	parent.frames[2].frames[1].document.forms[0].p_volume_nos.value = p_volume_no;
	parent.frames[2].frames[1].document.forms[0].p_rem_recnum.value = p_rem_recnum;
	parent.frames[2].frames[1].document.forms[0].p_req_facility.value = parent.frames[2].frames[1].document.forms[0].p_req_facility.value;
	parent.frames[2].frames[1].document.forms[0].p_req_location.value = parent.frames[2].frames[1].document.forms[0].req_location.value;
	parent.frames[2].frames[1].document.forms[0].p_req_name.value = parent.frames[2].frames[1].document.forms[0].req_name.value;
	parent.frames[2].frames[1].document.forms[0].p_patient_id.value = p_patient_id;
	parent.frames[2].frames[1].document.forms[0].p_file_type_code.value = file_type_code;
	if (parent.frames[2].frames[2].document.forms[0].logged_fcy.value=='E')
	{
		parent.frames[2].frames[1].document.forms[0].p_req_to_facility.value = parent.frames[2].frames[2].document.forms[0].enter_fcy.value;
	}
	else
	 {
		parent.frames[2].frames[1].document.forms[0].p_req_to_facility.value = parent.frames[2].frames[1].document.forms[0].p_req_facility.value;
	 }
	parent.frames[2].frames[1].document.forms[0].p_req_narration.value = parent.frames[2].frames[1].document.forms[0].req_narration.value;
	parent.frames[2].frames[1].document.forms[0].p_file_required_on.value = p_file_required_on ; 
	
	if(doc_or_file == 'D')
	{
	parent.frames[2].frames[1].document.forms[0].p_doc_folder_id.value = p_doc_folder_id;	
	parent.frames[2].frames[1].document.forms[0].p_doc_type_code.value = p_doc_type_code;
	}

	if (p_file_no.length>0)
	{
		parent.frames[2].frames[1].document.forms[0].submit();
		parent.parent.frames[2].frames[1].location.reload();
		parent.parent.frames[2].frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L&reset_mode=disabled';
		parent.parent.frames[2].frames[3].location.reload();
		parent.parent.frames[2].frames[4].location.href='../../eCommon/html/blank.html';

/*		parent.parent.frames[2].frames[1].location.href='../../eFM/jsp/FMRequestFileDetails.jsp';
		parent.parent.frames[2].frames[2].location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L&reset_mode=disabled';
		parent.parent.frames[2].frames[3].location.href='../../eFM/jsp/FMRequestFileSearch.jsp';
		parent.parent.frames[2].frames[4].location.href='../../eFM/jsp/FMRequestSelectedFiles.jsp'; */
	}
	else
	 {
		var errors = "";
		if(doc_or_file =='D')
			{
				errors=getMessage("NO_DOC_FOR_REQUEST","FM");
			}
			else
			{
				errors=getMessage("NO_FILE_FOR_REQUEST","FM");
			}		
		parent.frames[2].frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		}
	 }
	 else
	 {
		var errors = "";
		if(doc_or_file =='D')
			{
				errors=getMessage("NO_DOC_FOR_REQUEST","FM");
			}
			else
			{
				errors=getMessage("NO_FILE_FOR_REQUEST","FM");
			}
		parent.frames[2].frames[6].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
	 }
 }
}

function reset()
{
	parent.parent.frames[2].frames[1].location.reload();
	parent.parent.frames[2].frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L&reset_mode=disabled';
	parent.parent.frames[2].frames[3].location.reload();
	parent.parent.frames[2].frames[4].location.href='../../eCommon/html/blank.html';
}

function onSuccess()
{

}

function PopulateIdentity(obj)
{
	parent.frames[1].document.forms[0].requesting.value			= "";
	parent.frames[1].document.forms[0].requesting_code.value	= "";
	if (obj.value.length>0)
	{
		var fs_locn_code = parent.frames[1].document.forms[0].FS_LOCN_ID.value;		
		parent.frames[2].document.forms[0].logged_fcy.disabled=false;
		var storage_location =obj.value;
		var p_access_all =document.forms[0].p_access_all.value			
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMRequestFileLocnIdentity.jsp?storage_location="+storage_location+"&fs_locn_code="+fs_locn_code+"&p_access_all="+p_access_all+"'></form></body></html>" ;

		parent.frames[6].document.write(HTMLVal) ;
		parent.frames[6].document.GetLocIdentity.submit() ;
	}
	else
	{
		parent.frames[2].document.forms[0].logged_fcy.disabled=true;
		parent.frames[1].document.forms[0].req_narration.value='';
	    parent.frames[1].document.forms[0].requesting_btn.disabled=true;
	   parent.frames[1].document.forms[0].requesting.value="";
	//parent.frames[1].document.getElementById("location_identity").innerText='';
	}
parent.frames[3].document.forms[0].p_patient_id.value="";
parent.frames[3].document.forms[0].p_patient_id.onblur();

}

function PopulateData(objval) {
	
 if(objval != '') {
		var p_user_security_yn =document.forms[0].p_user_security_yn.value
		var p_access_all =document.forms[0].p_access_all.value			
		document.getElementById("id1").innerHTML='';
		document.forms[0].requesting.value = "";
		document.forms[0].requesting.disabled=true;
		document.forms[0].requesting_btn.disabled=true;
		if (objval=="D")
			document.getElementById("mandatory1").style.visibility = 'Hidden';
		else
			document.getElementById("mandatory1").style.visibility = 'Visible';
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='GetLocIdentity' id='GetLocIdentity' method='post' action='../../eFM/jsp/FMReqPopFSLocation.jsp?locn_code="+objval+"&p_user_security_yn="+p_user_security_yn+"&p_access_all="+p_access_all+"'></form></body></html>" ;

		parent.frames[6].document.write(HTMLVal) ;
		parent.frames[6].document.GetLocIdentity.submit() ;
	}
	else {
		var len = parent.frames[1].request_file_details.document.forms[0].req_location.length;
		parent.frames[1].document.forms[0].requesting_btn.disabled=true;
		parent.frames[1].document.forms[0].requesting.value="";
		for (var i=0; i<=len; i++) {
		parent.frames[1].request_file_details.document.forms[0].req_location.remove("req_location");
		}
		var opt	= parent.frames[1].request_file_details.document.createElement('OPTION');
		opt.value =	"";
		opt.text = "-----"+ getLabel("Common.defaultSelect.label","common")+"-----";
		parent.frames[1].request_file_details.document.forms[0].req_location.add(opt);
	}
}
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

function Clearval()
	{
		document.getElementById("hdr_tab").style.visibility = 'Hidden';
		file_type_appl_yn = parent.frames[3].document.forms[0].file_type_appl_yn.value;
		parent.frames[3].document.forms[0].added_volumes.value = "";
		parent.frames[3].document.forms[0].added_values.value = "";
		if (parent.frames[4].document.forms[0]  ) {
		
		if (parent.frames[4].document.forms[0].p_total_select) {
			var num_sel_recs = parent.frames[4].document.forms[0].p_total_select.value;
			for (var i=1; i<=num_sel_recs; i++) {
				eval('parent.frames[4].document.forms[0].rem_recnum_'+i).value="";
				 eval('parent.frames[4].document.forms[0].p_file_no'+i).value="";	
				 if (file_type_appl_yn == "Y")
					 eval('parent.frames[4].document.forms[0].file_type'+i).value="";	
			 eval('parent.frames[4].document.forms[0].p_volume_no'+i).value="";	
				
			}
		}
		}

		
		document.forms[0].p_select_values.value='';
		document.forms[0].p_deselect_values.value='';
		document.forms[0].p_patient_file_no.value='';
		document.forms[0].p_valtype.value='';
		
		document.forms[0].p_load_select.value='';
		document.forms[0].p_load_deselect.value='';
		document.forms[0].p_total_records.value='';
		document.forms[0].p_select_files.value='';

		document.forms[0].p_deselect_files.value='';
		document.forms[0].p_total_select.value='';
		parent.frames[3].document.forms[0].p_total_select.value="";
		
		file_type_appl_yn = parent.frames[3].document.forms[0].file_type_appl_yn.value;
		
		if (parent.frames[4].document.forms[0])
		{
		if (parent.frames[4].document.forms[0].p_select_values)
		{ parent.frames[4].document.forms[0].p_select_values.value = "";}
		if (parent.frames[4].document.forms[0].p_total_select)
		{ parent.frames[4].document.forms[0].p_total_select.value = "";}
		parent.frames[4].document.forms[0].reset();		
		parent.frames[4].location.href = "../../eCommon/html/blank.html";
		}
		parent.frames[6].location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}

function getPatientIDRecords(e,ObjVal)
	{
		var flag = document.forms[0].flag.value;		
		if(flag == ''){			
			document.forms[0].flag.value='Y';
			checkPatientExists(ObjVal);			
		}else if( flag=='Y'){		
		checkPatientExists(ObjVal);
			document.forms[0].flag.value='';
		}
	}

function log_ent_fcy(getVal)
	{
		var p_chosen_fcy = document.forms[0].logged_fcy.value;

		if (document.forms[0].logged_fcy.value =='L')
		{
			parent.frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy='+getVal+'&p_chosen_fcy='+p_chosen_fcy;	
		}
		else if (document.forms[0].logged_fcy.value =='E')
		{			parent.frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=Y&selected_fcy='+getVal+'&p_chosen_fcy='+p_chosen_fcy;
	
		}
	}

function getExternalFiles(facility)
	{
		doc_or_file = document.forms[0].doc_or_file.value;		
		parent.search_criteria.location.href="../../eFM/jsp/FMRequestFileSearch.jsp?external_facility="+facility+"&doc_or_file="+doc_or_file;
	}

async function searchCode(target,facilityid) {
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
		retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr=new Array();

		if (!(retVal == null)) {
			var retVal=unescape(retVal);
		    arr=retVal.split("::");

		    document.forms[0].req_name1.value=arr[0];
			document.forms[0].req_name.value=arr[1];
		}
		else
		{
			document.forms[0].req_name1.value="";
			document.forms[0].req_name.value="";
		}
	}
	function chksearch_id() //Call search_id function if the description field is not empty
	{
		if(document.forms[0].requesting.value=="") {}
		else { 			
			if(document.forms[0].FS_LOCN_ID.value=="T")			{callPractSearch(document.forms[0].requesting_btn,document.forms[0].requesting);}
			else if((document.forms[0].FS_LOCN_ID.value=="C")||(document.forms[0].FS_LOCN_ID.value=="N")){
			search_id(document.forms[0].requesting_btn,document.forms[0].requesting); 
			}
			}
	}
	async function search_id(obj,target)//common lookup function
	{
				var retVal =    new String();               
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var facility_id = document.forms[0].p_req_facility.value;
				var sql = "";
                var tit="";	
				var code = document.forms[0].FS_LOCN_ID.value;
				var req_location = document.forms[0].req_location.value;
					if(code=="C")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.clinic.label","common");
				else if(code=="N")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.nursingUnit.label","common");
				else if(code=="Y")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+  getLabel("Common.DaycareUnit.label","common");
				else if(code=="E")
	              	tit=getLabel("eFM.Requesting.label","FM")+" "+ getLabel("Common.ProcedureUnit.label","common");
				
				if (code=="T")
					callPractSearch(obj, target);
				else if(code=='C')
                sql="Select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and mr_location_code = '"+req_location+"' and eff_status='E' and CARE_LOCN_TYPE_IND='C' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";				
				else if (code=='N')
				sql="Select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where facility_id = '"+facility_id+"' and language_id='"+localeName+"' and fs_locn_code = '"+req_location+"' and eff_status='E' and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?) ";
				else if(code=='E')
                sql="Select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and mr_location_code = '"+req_location+"' and eff_status='E' and CARE_LOCN_TYPE_IND='E' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ";
				else if(code=='Y')
                sql="Select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and mr_location_code = '"+req_location+"' and  eff_status='E' and CARE_LOCN_TYPE_IND='D' and upper(clinic_code) like upper(?) and upper(short_desc) like upper(?) ";
				if (code!="T")
				{
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );				
				if(retVal != null && retVal != "" )
                {					
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					document.forms[0].requesting.value=arr[1];					
					document.forms[0].requesting_code.value=arr[0];
				}
				else{
					document.forms[0].requesting.value="";					
					document.forms[0].requesting_code.value="";
				}
			}
	}

function PractLookupRetVal(retVal,objName) //Part of callPractSearch function.
	{
		var arr;
		if (retVal != null)
		{
			arr=retVal.split("~");				
			document.forms[0].requesting.value=arr[1];
			document.forms[0].requesting_code.value=arr[0];					
		}	
	}
function callPractSearch(obj, target)
{
	var practName_FName="";
	var practName_FValue="";

	practName_FName=target.name;
	practName_FValue=target.value;

	var facility_id = parent.frames[3].document.forms[0].facilityid.value;

	getPractitioner_common(obj,target,"",facility_id,"Q2");

	//latest var sql = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   OR UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  ) ";
	//latest  var sql2 = "SELECT  a.Practitioner_id practitioner_id  ,b.Practitioner_name practitioner_name  ,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+localeName+"','1') practitioner_type  ,AM_GET_DESC.AM_SPECIALITY(b.primary_speciality_code,'"+localeName+"','2') primary_specialty  ,b.gender gender  ,b.POSITION_CODE job_title  FROM  am_pract_for_facility a  , am_practitioner_lang_vw b WHERE a.facility_id= '"+facility_id+"'   AND a.practitioner_id = b.practitioner_id   and b.language_id = '"+localeName+"'  AND b.pract_type LIKE (?)   AND b.primary_speciality_code LIKE UPPER(?)   AND   (  UPPER(b.practitioner_id) LIKE UPPER(NVL(?,b.practitioner_id))   AND UPPER(b.practitioner_name) LIKE UPPER(NVL(?,b.practitioner_name))  )   AND b.gender LIKE (?)   AND   (  b.JOB_TITLE LIKE (?)   OR b.JOB_TITLE IS  NULL  )";
	
/*	var xmlDoc="";
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
// To be called by the GeneralPractitionerSearch to set Practitioner.

async function GetRemarks(recnum) {
	  

	  var ua = window.navigator.userAgent
      var msie = ua.indexOf ( "MSIE " )
      var brow_ver_no;
	  if ( msie > 0 )     
				brow_ver_no=parseInt (ua.substring (msie+5, ua.indexOf (".", msie )));
    
	var dialogHeight	= "36vh" ;
	var dialogWidth		= "35vw" ;
	if(brow_ver_no > '6'){
			dialogHeight	= "30vh" ;
			dialogWidth		= "35vw" ;
	  }
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		var arguments		= "" ;
		var tempobj			= eval('parent.frames[4].document.forms[0].rem_recnum_'+recnum);
		var curr_remarks	= tempobj.value;
		var title=encodeURIComponent(getLabel('eFM.RequestRemarks.label','FM'));
		
		var retVal			=await window.showModalDialog('../../eFM/jsp/FMShowRemarks.jsp?title='+title+'&funct=req'+'&curr_remarks='+encodeURIComponent(curr_remarks),arguments,features);
		if (!(retVal == null)) {
			//tempobj.value	= unescape(retVal);
				
			tempobj.value	= retVal;
			}	
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

function checkDateAlert(from,to)
{
	/*if (!doDateCheckAlert(from,to))
	{
		alert(getMessage("DATE_GT_EQ_SYS_DATE",'FM'));
		to.focus();
	}*/
	var from1=from.value;
	if(validDateObj(to,"DMYHM",localeName))
	{
	if(localeName != "en")
	from1=convertDate(from1,"DMYHM","en",localeName);

	var to1=to.value;

	if(to1 != "")
	{
		/*if(!isBefore(from1,to1,"DMY", localeName))
		{
		  alert(getMessage("DATE_GT_EQ_SYS_DATE",'FM'));
		  to.focus();
		}*/
		if(!isAfterNow(to1,"DMYHM", localeName))
		{
		  alert(getMessage("DATE_GT_EQ_SYS_DATE",'FM'));
		  to.focus();
		 to.value="";
		}
	}
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

/* Below methods added by Venkatesh.s against ML-MMOH-CRF-0393 */
function checkMaxLen(obj){
    if (obj.value.length>100){
      var error = getMessage("REMARKS_CANNOT_EXCEED",'Common'); 
      error = error.replace("$",getLabel("Common.remarks.label","Common"));
      error = error.replace("#","100");
      alert(error)
	  obj.focus(); 
		}
	}
	
function enableReason(obj){

if (obj.options[obj.selectedIndex].text.toLowerCase()=='others') 
  {
  
   document.getElementById("remark_visible").style.visibility='visible'
   document.request_file_details.reason.style.visibility='visible'
   document.request_file_details.mandatory.style.visibility='visible'
   document.request_file_details.reason.value="";
   
  }else{
    document.getElementById("remark_visible").style.visibility='hidden' 
	document.request_file_details.reason.style.visibility='hidden'
	document.request_file_details.mandatory.style.visibility='hidden'
	 
  }
}	 

function checkMaxLimit(obj, maxSize, keycode) {
			if (keycode == 96 || keycode == 126 ||  keycode == 39 ||
				keycode == 34 || obj.value.length >= maxSize) return false;
			else return true;
		}
		/*end ML-MMOH-CRF-0393 */


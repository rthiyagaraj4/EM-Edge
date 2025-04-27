//this function is used to get the correct frame reference 
//use messageFrameReference whenever u want to refer the message frame

// Added by Sridhar Reddy on 22/12/2008
var prevObjID;
var prevImgObj;
//end

var window_id = "";

function getMessageFrame()
{
	if(top.content!=null){
		return top.content.messageFrame;
	}else{
		return top.messageframe;
	}
}
var messageFrameReference = getMessageFrame();

function checkFilevalue(obj)
{
	return false;
	//if(call_from != "window" )
	//messageFrameReference.focus();
}
function checkFilevalueMouseClick() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) {
		try
		{
          return false;
		}
		catch (error) 
		{
			//alert("Caught: " + error.message);
		}
	}
}


function clearFileName(tagId, called_from)
{

	if(called_from == undefined || called_from == ''){
		top.RecClinicalNotesFileUploadFrame.document.getElementById("uploadFile_div").innerHTML=top.RecClinicalNotesFileUploadFrame.document.getElementById("uploadFile_div").innerHTML;
		//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.fileupload.outerText = "";

		top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.uploadremarks.value="";
		top.RecClinicalNotesFileUploadToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record_sec.disabled = false;
	}
	else
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.getElementById("uploadFile_div").innerHTML=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.getElementById("uploadFile_div").innerHTML;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.uploadremarks.value=""
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.btnUploadFile.disabled = false;
/*		parent.RecClinicalNotesSectionFrame.document.getElementById("uploadFile_div").innerHTML=parent.RecClinicalNotesSectionFrame.document.getElementById("uploadFile_div").innerHTML;
		parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.uploadremarks.value="";*/
	}
}

function ViewNotesFile()
{
	
	var operation_mode =  top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value;	

	var filename	= top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.fileupload.value;
	
	var accession_num = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.accession_num.value;
	var note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_type.value;

	if(operation_mode == "Update" || operation_mode == "UpdateRecord" || operation_mode == "UpdateSign")
	{
		if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.changefile.checked	== false || filename==""){

			openDocWindow(accession_num,note_type)
		}
		else if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.changefile.checked	== true && filename !="")
		{
			window.open(filename,'Document',"height=570,width=790,top=0,left=0,resizable=yes");
		}
		else
			checkForMandatoryFileUploadFields();
	}
	else
	{
		if(checkForMandatoryFileUploadFields()==true)
		{
			parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.previewMode.value="Y"
			var filesplit = filename.split("\\");
			var length = filesplit.length;
			parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.image_name.value = filesplit[length-1];		
			parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadServlet';
			parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.submit();
		}
	}
}

function RecordNotesFile()
{
	var operation_mode =  top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value;

	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.previewMode.value='';
	

	var toolbarframe = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm;

	assignHiddenValues();
	

//	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;

	if(operation_mode==("Update") || operation_mode==("UpdateRecord"))
	{
		if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.change_file_ref.value == "Y")
		{
			if(checkForMandatoryFileUploadFields() == true)
			{
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "UpdateRecord";
				toolbarframe.record.disabled = true;
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();
			}
		}
		else if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.change_file_ref.value == "N")
		{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "UpdateRecord";
			toolbarframe.record.disabled = true;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();
		}
	}
	else if(operation_mode == "" || operation_mode==("Record"))
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time.disabled = true;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "Record";
		toolbarframe.record.disabled = true;
		toolbarframe.sign.disabled = true;
		toolbarframe.btnUploadFile.disabled = true;

		checkAndRecord("NOTES_HEADER","Record");		
		//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();
	}

}

function SignNotesFile()
{
	var operation_mode =  top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.previewMode.value='';
	var toolbarframe = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm;
	
	
	if(operation_mode == "UpdateRecord")
		operation_mode = "UpdateSign";

	assignHiddenValues();
	var confirm_flag = "";
	
	if(operation_mode =="Update" || operation_mode =="UpdateSign")
	{
		
		if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.change_file_ref.value == "Y")
		{
			if(checkForMandatoryFileUploadFields() == true)
			{
				
				confirm_flag = confirm(getMessage("CONF_SIGN",'CA'));
				if(confirm_flag)
				{
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "UpdateSign";
				toolbarframe.sign.disabled = true;
				toolbarframe.record.disabled = true;
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.submit();
				}
					
			}
		}
	else	if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.change_file_ref.value == "N")
		{
				confirm_flag = confirm(getMessage("CONF_SIGN",'CA'));
				if(confirm_flag)
				{
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "UpdateSign";
				toolbarframe.sign.disabled = true;
				toolbarframe.record.disabled = true;
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.submit();
				}
		}		
	}
	else
	{
		if(checkForMandatoryFileUploadFields() == true)
		{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "Sign";
			var accession_num =  top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value

			confirm_flag = confirm(getMessage("CONF_SIGN",'CA'));
			if(confirm_flag)
			{

				toolbarframe.sign.disabled = true;
				toolbarframe.record.disabled = true;	
				toolbarframe.btnUploadFile.disabled = true;	
				if (accession_num == "")
				{
					checkAndRecord("NOTES_HEADER","Sign");	
				}else{
					RecordNotesFileSection1('Sign');
				}
			}
		}
	}
}

function assignHiddenValues()
{
	
	var headerObj = "";
	
	if(parent.RecClinicalNotesHeaderFrame!=null)
		headerObj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	else
	headerObj = top.window.opener.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;

	var FileUploadObj = "";	
	if(top.content!=null)
	FileUploadObj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm;
	else
	FileUploadObj= top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm;

	FileUploadObj.patient_id.value				 = 	headerObj.patient_id.value
	FileUploadObj.patient_class.value			 = 	headerObj.patient_class.value
	FileUploadObj.encounter_id.value			 = 	headerObj.encounter_id.value
	FileUploadObj.visit_adm_date.value			 = 	headerObj.visit_adm_date.value
	FileUploadObj.sys_date_time.value			= 	headerObj.sys_date_time.value
	FileUploadObj.operation_mode.value			= 	headerObj.operation_mode.value
	FileUploadObj.amendment_type.value			= 	headerObj.amendment_type.value
	FileUploadObj.accession_num.value			= 	headerObj.accession_num.value
	FileUploadObj.event_class.value				= 	headerObj.event_class.value
	FileUploadObj.privilege_type.value			= 	headerObj.privilege_type.value
	FileUploadObj.note_type_desc.value		 = 	headerObj.note_type_desc.value
	FileUploadObj.event_type_caption.value = 	headerObj.event_type_caption.value
	FileUploadObj.note_type_security_level.value			 = 	headerObj.note_type_security_level.value
	FileUploadObj.event_date_caption.value = 	headerObj.event_date_caption.value
	FileUploadObj.event_perf_by_caption.value = 	headerObj.event_perf_by_caption.value
	FileUploadObj.event_title_caption.value		  = 	headerObj.event_title_caption.value
	FileUploadObj.event_auth_by_caption.value = 	headerObj.event_auth_by_caption.value
	FileUploadObj.event_status_caption.value	  = 	headerObj.event_status_caption.value
	FileUploadObj.function_id.value				 = 	headerObj.function_id.value
	FileUploadObj.appl_task_id.value			 = 	headerObj.appl_task_id.value

	FileUploadObj.event_date_time.value		 = 	headerObj.event_date_time.value
	FileUploadObj.sys_date_time.value		 = 	headerObj.sys_date_time.value
//	FileUploadObj.note_header_desc.value		 = 	headerObj.note_header_desc.value
//	FileUploadObj.discharge_summary_text.value		 = 	headerObj.discharge_summary_text.value
		if(headerObj.note_group!=null)
			FileUploadObj.note_group.value		 = 	headerObj.note_group.value
	FileUploadObj.performed_by_id.value		 = 	headerObj.performed_by_id.value
	FileUploadObj.event_title_desc.value		 = 	headerObj.event_title_desc.value
	FileUploadObj.note_type.value		 = 	headerObj.note_type.value
	FileUploadObj.service_code.value		 = 	headerObj.service_code.value
	//alert(headerObj.service_code.value)
	FileUploadObj.performed_by_id.value		 = 	headerObj.performed_by_id.value
	FileUploadObj.contr_mod_accession_num.value		 = 	headerObj.contr_mod_accession_num.value


//	FileUploadObj.service_code.value = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.options[parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.selectedIndex].text;
	//FileUploadObj.performed_by_id.value = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id.options[parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code.selectedIndex].text;


}

function checkMaxLimitnew(obj,maxSize) 
{
	  if ( obj.value.length >= maxSize )
       {
			var error = getMessage("OBJ_CANNOT_EXCEED","Common");
			error = error.replace("$",maxSize);
			alert(error);
			obj.focus();
			return false;
       }
}

function checkForMandatoryFileUploadFields()
{
	var fields;
	var names;
	var operation_mode =  top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value;
	
	var fileupload			= top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.fileupload;

	if(operation_mode !="update")
	{
		var	hdr_event_date_time				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time;		
		var	hdr_performed_by_id				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id;		
		var	hdr_service_code				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code;		
		var	hdr_note_type					=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type;
		
		fields		=	new Array ( hdr_note_type, hdr_service_code, hdr_event_date_time, hdr_performed_by_id) ;
		names		=	new Array (getLabel("Common.NoteType.label","COMMON"), getLabel("Common.Med/AncService.label","COMMON"), getLabel("Common.datetime.label","COMMON"), getLabel("Common.Performed.label","COMMON"));
	}
	/*else if(operation_mode =="update" )
	{
		fields		=	new Array ( fileupload) ;
		names		=	new Array ( getLabel("eCA.FileUpload.label","CA"));
	}*/

	if(!(checkFields(fields,names,messageFrameReference)))
		return false;
	else 
		return true;
}

function checkFields_FUP( fields, names, messageFrame) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		//else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
		else 
		   {	 errors = errors + getMessage("CAN_NOT_BE_BLANK","Common") + "<br>" ;
		         errors=errors.replace('$',names[i]);
		   }
			
	}
	if ( errors.length != 0 ) 
	{
		messageFrame.document.location.href="../../eCA/jsp/CAError.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}

function viewNotes()
{
}

function openDocWindow(accession_num,note_type)
{
	
	//window.open("../../eCA/jsp/RecClinicalNotesFileUploadShowDocMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
	
	//window.open("../../eCA/jsp/RecClinicalNotesMultiFileList.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height=570,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");	
	var screenHeight=screen.height; //39647
	var screenWidth=screen.width; //39647
	window.open("../../eCA/jsp/RecClinicalNotesMultiFileListMain.jsp?accession_num="+accession_num+"&note_type="+note_type,'Document',"height="+screenHeight+",width="+screenWidth+",top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes,addressbar=no");
}
function trColourChange(id){
		
		var totalRecornds=document.forms[0].totalRecords.value;
		for(var i=0;i<totalRecornds;i++){
			document.getElementById( 'TRI'+i ).className='';
		}
		document.getElementById( 'TRI'+id ).className='gridDataSelect';
}
function ShowFileRef(obj)
{
	var frame_ref = "";
	
	if(top.content!=null)
		frame_ref  = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame;
	else
		frame_ref  = top.RecClinicalNotesFileUploadFrame;

	if(obj.checked == true)
	{
		frame_ref.document.getElementById("file_id").style.display = "inline";
		frame_ref.document.getElementById("fileref").innerText = "New File Reference";
		frame_ref.document.RecClinicalNotesFileUploadForm.change_file_ref.value = "Y";
	}
	else
	{
		frame_ref.document.getElementById("file_id").style.display = "none";
		frame_ref.document.RecClinicalNotesFileUploadForm.change_file_ref.value = "N";
	}
}

function callMeOnFileDelete()
{
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "Delete";	
	
	var confirm_flag = confirm(getMessage("DELETE_NOTE","CA"));
	if(confirm_flag==true)
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.submit();
	}
}


function displayToolTip(facility_id,note_type,accession_num,performed_by_id,operations_allowed,amendment_type,privilege_type,service_code,authorized_by_name,strModifiedId,doc_linked_note_yn,patient_id,encounter_id,episode_type,function_id,from_date_time,to_date_time,appl_task_id,note_group,patient_class,tooltipCol,imgObj)
{
	//alert(tooltipCol.id);
	//hideToolTip();
	var frame_ref = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].doc_linked_note_yn.value = "Y";

	callMouseOverOnTD(tooltipCol,imgObj);
		buildTable(facility_id,note_type,accession_num,performed_by_id,operations_allowed,amendment_type,privilege_type,service_code,authorized_by_name,strModifiedId,doc_linked_note_yn,patient_id,encounter_id,episode_type,function_id,from_date_time,to_date_time,appl_task_id,note_group,patient_class);
		
		var tooltipCol1 = tooltipCol.id;

		var wdth =  document.getElementById(tooltipCol1).offsetWidth;
 		var hght1 = document.getElementById(tooltipCol1).offsetHeight;	
		
		var wdth1 = getPos(tooltipCol).x +wdth;
		var hght = getPos(tooltipCol).y ;

		bodwidth  = document.body.offsetWidth;
		bodheight = document.body.offsetHeight;
	
		var z = bodwidth- (event.x + wdth);		
		
		var x 	  = event.x;
		var y 	  = event.y;
	
		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);

		if(x<bodwidth){
			x= wdth1;			
		}else{			
			x = getPos(tooltipCol).x;
		}
		if(y<bodheight){			
			y = hght;
			
		}else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}
	
		document.getElementById("tooltiplayer").style.posLeft= x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible';
}

function buildTable(facility_id,note_type,accession_num,performed_by_id,operations_allowed,amendment_type,privilege_type,service_code,authorized_by_name,strModifiedId,doc_linked_note_yn,patient_id,encounter_id,episode_type,function_id,from_date_time,to_date_time,appl_task_id,note_group,patient_class)
{
	var frame_ref = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame;
	var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center' >"
	var colval = new Array(" Delete "," Sign "," Record ");
	var call_func = "";

	var operations = operations_allowed.split("|");
	//	alert(operations.length)
	operations[operations.length] = "VIEW DOCUMENT";
	for( var i=0; i<operations.length; i++ )
	{
		//alert(operations[i])

		if(operations[i] != "VIEW" && operations[i] != "MODIFY" && operations[i] != "PRINT")
		{

		if (operations[i] == "UPDATE")
		{
			call_func="callMeOnFileUpdate('"+facility_id+"','"+note_type+"','"+accession_num+"','"+performed_by_id+"','"+operations_allowed+"','"+amendment_type+"','"+privilege_type+"','"+service_code+"','"+authorized_by_name+"','"+strModifiedId+"','"+doc_linked_note_yn+"','"+patient_id+"','"+encounter_id+"','"+episode_type+"','"+function_id+"','"+escape(from_date_time)+"','"+escape(to_date_time)+"','"+appl_task_id+"','"+note_group+"','"+patient_class+"')";

		}
		else if(operations[i] == "DELETE")
		{
			call_func = "callMeOnFileUpdateDelete('"+accession_num+"')";
		}
		else if(operations[i] == "SIGN")
		{
			call_func = "callMeOnFileSign('"+accession_num+"','"+performed_by_id+"','"+privilege_type+"','"+function_id+"','"+note_type+"','CALLED_FROM_TOOLTIP');"
		}
		else if(operations[i] == "ERROR") 
		{
			call_func = "callMeOnFileError('"+accession_num+"','"+function_id+"','"+note_type+"');"
		}
		else if(operations[i] == "FORWARD")
		{
			call_func = "getFileForwardTo('Forward','"+note_type+"','"+accession_num+"','"+function_id+"')";
		}
		else if(operations[i] == "VIEW DOCUMENT")
		{
			call_func = "openDocWindow('"+accession_num+"','"+note_type+"')";
		}

		tab_dat     += "<tr>";
		tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this)'><a class= 'contextMenuLink' href='javascript:dummy()' onClick="+call_func+">&nbsp"+operations[i]+"&nbsp</a></td>";
		tab_dat     += "</tr>";
	}
	}
	tab_dat     += "</table>";
	frame_ref.document.getElementById("t").innerHTML =  tab_dat;
}

function hideToolTip(obj,imgObj)
{
	if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.getElementById("tooltiplayer") != null)
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.getElementById("tooltiplayer").style.visibility = 'hidden';

		obj.className = 'gridDataBlue';
		document.getElementById(imgObj).src = "../../eCommon/images/inactiveArrow.gif";
	}	 	  
}

//Added by Sridhar Reddy on 21/12/2008
function callMouseOverOnTD(obj,imgObj){
		
	 if (prevObjID != null && prevObjID != obj.id)
	 {			 
		document.getElementById(prevObjID).className = 'gridDataBlue';
		document.getElementById(prevImgObj).src = "../../eCommon/images/inactiveArrow.gif";			 
	 }		 
	obj.className = 'selectedTDData';
	document.getElementById(imgObj).src = "../../eCommon/images/activeArrow.gif";
	prevObjID = obj.id;
	prevImgObj = imgObj;		
}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
        if(targetElement.x && targetElement.y) {
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                //alert("Could not find any reference for coordinate positioning.");
            }
        }
        return coords;
    } catch(error) {
        //alert(error.msg);
        return coords;
    }
}
//End


function callMouseOver(obj)	{
	currClass = obj.className ;
	obj.className = 'selectedcontextMenuItem';
}

function callOnMouseOut(obj){
	obj.className = 'contextMenuItem';
}
function dummy1(facility_id)
{
	//alert(facility_id)
}

function dummy()
{
	
}

function callMeOnFileUpdate(facility_id,note_type,accession_num,performed_by_id,operations_allowed,amendment_type,privilege_type,service_code,authorized_by_name,strModifiedId,doc_linked_note_yn,patient_id,encounter_id,episode_type,function_id,from_date_time,to_date_time,appl_task_id,note_group,patient_class)
{
	var query_string = "";
	query_string = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].query_string.value;
	//alert("inside js"+ patient_id)
	var operation_mode	=	"Update";
	top.content.workAreaFrame.location.href = "../../eCA/jsp/RecClinicalNotes.jsp?query_string="+query_string+"&operation_mode="+operation_mode+"&note_type="+note_type+"&accession_num="+accession_num+"&performed_by_id="+performed_by_id+"&amendment_type="+amendment_type+"&privilege_type="+privilege_type+"&service_code="+service_code+"&authorized_by_name="+authorized_by_name+"&doc_linked_note_yn="+doc_linked_note_yn+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_type="+episode_type+"&function_id="+function_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&appl_task_id="+appl_task_id+"&note_group="+note_group+"&patient_class="+patient_class;
}


function callMeOnFileSign(accession_num,performed_by_id,privilege_type,function_id,note_type,called_from)
{
	var forwarded_clinician_id	=	"";
	var action_comment			=	"";
	if(privilege_type=="2")
	{
		var returnArray	=	getFileForwardTo("SignOnModify",note_type);
		if(returnArray==null)
		{
			return false;
		}
		forwarded_clinician_id	=	returnArray[0];
		action_comment			=	returnArray[1];
		//alert('forwarded_clinician_id  : '+forwarded_clinician_id );
	}
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].forwarded_clinician_id.value	=	forwarded_clinician_id;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action_comment.value			=	action_comment;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].accession_num.value			=	accession_num;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].performed_by_id.value			=	performed_by_id;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].privilege_type.value			=	privilege_type;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].function_id.value			=	function_id;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].operation_mode.value			=	"SignOnModify";		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].called_from.value			=	called_from;		

	/*	if(function_id=="SPCL_NOTE"  || function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM")
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].target	=	messageFrameReference.name;
	else
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	top.frames[1].name;
*/
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].target	=	messageFrameReference.name;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].method	=	'POST';
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';

	var alert_msg = "";
	if(privilege_type=="2")
	{
		alert_msg =  getMessage("CONF_FWD",'CA');
	}
	else
	{
		alert_msg = getMessage("CONF_SIGN",'CA');
	}

	var confirm_flag = confirm(alert_msg);
	if(confirm_flag==true)
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].submit();
		
	}
}

function callMeOnFileUpdateDelete(accession_num)
{
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].accession_num.value			=	accession_num;		
	//alert(accession_num);	
	var confirm_flag = confirm(getMessage("DELETE_NOTE","CA"));
	if(confirm_flag==true)
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].operation_mode.value			=	"Delete";			
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].target	=	messageFrameReference.name;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].method	=	'POST';
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesFileUploadServlet';
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].submit();
	}
}

function callMeOnFileError(accession_num,function_id,note_type)
{
top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].focus();
	var returnArray = getFileForwardTo('MarkAsError',note_type,accession_num,function_id);
	if(returnArray==null)
	{
		return false;
	}

	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].operation_mode.value			=	"MakeAsError";		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].accession_num.value			=	accession_num;		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action_comment.value			=	returnArray[0];		


/*	if( function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM")
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
	else
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	top.frames[1].name;
*/
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].target	=	messageFrameReference.name;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].method	=	'POST';
	
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.RecClinicalNotesSearchResultForm.called_from.value	=	'CALLED_FROM_TOOLTIP';
		var confirm_flag = confirm(getMessage("CONF_MARKERROR",'CA'));
		if(confirm_flag==true)
		{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].submit();
		}
}

function getFileForwardTo(operation_mode,note_type,accession_num,function_id)
{

	var query_string	=	"";

	if(operation_mode!="MarkAsError")
	{
		if(note_type == null)
			return false;
		query_string	=	"&note_type="+note_type;
	}
	
	var returnArray		=	new Array();
		/*Commented by Archana on 2/17/2010 at 4:30 PM for IN19323*/
	//var dialogHeight	=	"12" ;
	//var dialogWidth		=	"25" ;
	/*added by Archana on 2/17/2010 at 4:30 PM for IN19323*/
		/*
			changed the size of dialogHeight and dialogWidth.
		*/
	var dialogHeight	=	"15" ;
	var dialogWidth		=	"30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesForward.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//returnArray		=	window.open(action_url,arguments,features);
	action_url			+=	"?operation_mode="+operation_mode+query_string;
	returnArray			=	window.showModalDialog(action_url,arguments,features);
	if (returnArray != null)
	{
		if(operation_mode=="Forward")
		{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].forwarded_clinician_id.value	=	returnArray[0];
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action_comment.value			=	returnArray[1];
			// Added by Ambiga.M for 18712 on 2/24/2010 
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].forward_mode.value			=	returnArray[2];
			// Added by Ambiga.M ends here
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].operation_mode.value			=	"Forward";		
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].accession_num.value			=	accession_num;		
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].target	=	messageFrameReference.name;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].method	=	'POST';
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';
			var confirm_flag = confirm(getMessage("CONF_FWD",'CA'));
			if(confirm_flag==true)
			{
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchResultFrame.document.forms[0].submit();
			}
		}
		else if(operation_mode=="SignOnModify" )
		{
			return returnArray;
		}
		else
			return returnArray;
	}
	else
	{
		returnArray = null;
	}
}

// modification starts from here when a file is attached for along with the sections

function RecordClinicalNotesFileUpload(obj)
{
		var accession_num = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value;
		var note_type = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;
		var patient_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		var encounter_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		var contr_mod_accession_num = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.contr_mod_accession_num.value;
		window_id = window.open("../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?accession_num="+accession_num+"&note_type="+note_type+"&call_from=window&patient_id="+patient_id+"&encounter_id="+encounter_id+"&contr_mod_accession_num="+contr_mod_accession_num,'Document1',"height=550,width=850,top=80,left=130,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");	
		//window_id = window.showModalDialog("../../eCA/jsp/RecClinicalNotesFileUploadMain.jsp?accession_num="+accession_num+"&note_type="+note_type+"&call_from=window&patient_id="+patient_id+"&encounter_id="+encounter_id,'Document1',"height=350,width=550,top=140,left=160,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");	
}

function RecordNotesFileSection1(operation_mode)
{
	assignHiddenValues();	
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.content.messageFrame.name;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = operation_mode;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.method = 'post';
	if (operation_mode == "Record")
	{		
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadSectionsServlet';
	}else if (operation_mode == "Sign")
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadServlet';
	}
	//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.noterecord_sec.disabled = true;
	//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.btnUploadFile.disabled = true;

	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();	
	
}

function RecordNotesFileSection()
{

assignHiddenValues();	
var fileupload = "";
fileupload = top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.fileupload;
var hdr_note_type = top.opener.top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type;
var hdr_event_date_time = top.opener.top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time;
var hdr_performed_by_id = top.opener.top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id;
var hdr_service_code = top.opener.top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code;


//var name		=	new Array ("File Reference");
//var field     	=	new Array(fileupload) 

var field		=	new Array ( hdr_note_type, hdr_service_code, hdr_event_date_time, hdr_performed_by_id, fileupload) ;
var name		=	new Array (getLabel("Common.NoteType.label","COMMON"), getLabel("Common.Med/AncService.label","COMMON"), getLabel("Common.datetime.label","COMMON"), getLabel("Common.Performed.label","COMMON") , getLabel("eCA.FileUpload.label","CA"));

var call_mode = top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.call_mode.value
top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.previewMode.value='';

	if(top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.change_file_ref.value == "N" && call_mode!="")
	{
			// alert("RecordNotesFileSection() I");
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.messageframe.name;
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "Record";
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadSectionsServlet';
			top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById("noterecord_sec").disabled = true
			top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById("btnUploadFile").disabled = true
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();
	}
	else
	{
		//alert("RecordNotesFileSection() M");
		/*if((checkFields(field,name,top.messageframe)))
		{*/
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.messageframe.name;
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value = "Record";
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadSectionsServlet';
			top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById("noterecord_sec").disabled = true
			top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById("btnUploadFile").disabled = true
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();
		//}
	}
}

function ViewNotesFileSection()
{
	var filename	= top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.fileupload.value;
	var call_mode	= top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.call_mode.value;
	var note_type	= top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.note_type.value;
	var accession_num	= top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.accession_num.value;
	
	if(call_mode == "update")
	{	
		if(top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.changefile.checked	== true && filename !="")
		{
			
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.previewMode.value="Y"
			var filesplit = filename.split("\\");
			var length = filesplit.length;
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.image_name.value = filesplit[length-1];
			
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadServlet';
		
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();	
			//window.open(filename,'Document',"height=570,width=790,top=0,left=0,resizable=yes");
		}
		else
		{
			openDocWindow(accession_num,note_type)
		}
	}
	else
	{
		
		top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.previewMode.value="Y"
		//alert("@@ filename="+filename);
		var filesplit = filename.split("\\");
		var length = filesplit.length;
		top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.image_name.value = filesplit[length-1];		
		top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesFileUploadServlet';
		top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();	
		//window.open(filename,'Document',"height=570,width=790,top=0,left=0,resizable=yes");
	}	
}

function checkFileExtn(obj,called_from)
	{
		
		var filename = "";
		var fileExtns = "";
		var extn = "";
		obj.disabled = true;

		if (called_from == undefined || called_from == "")
		{
			filename = top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.fileupload.value;
			fileExtns = top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.fileExtn.value;
			extn = filename.substring(filename.lastIndexOf(".")+1, filename.length);
		}else{
			filename = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.getElementById("fileupload").value;
			fileExtns = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.getElementById("fileExtn").value;
			extn = filename.substring(filename.lastIndexOf(".")+1, filename.length);
		}
		

		if(obj.name == "btnUploadFile")
		{
			if (filename != '')
			{	
				if(fileExtns != undefined && fileExtns!= null && fileExtns != '' && fileExtns.indexOf(extn.toUpperCase()) != -1)
				{
					
					doFileUpload(called_from);
				}
				else
				{				
					alert(getMessage("INVALID_FILE_EXTN", "CA"));
					obj.disabled = false;
				}
			}
			else
			{
				var msg = getMessage("CAN_NOT_BE_BLANK", "COMMON");
				msg = msg.replace("$" , getLabel("eCA.FileReference.label", "ca"));
				alert(msg);
				obj.disabled = false;
			}	
		}
		else if(obj.name == "record_sec")
		{
			checkAndRecord();					
		}	
		//obj.disabled = false;
	}

	function doFileUpload(called_from)
	{
		if (called_from == undefined || called_from == "")
		{
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.messageframe.name;
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.method = 'post';
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesMultiUploadServlet';
			top.RecClinicalNotesFileUploadToolbarFrame.document.getElementById("btnUploadFile").disabled = true;
			top.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();		
		}else{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.target = top.content.messageFrame.name;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.method = 'post';
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.action = '../../servlet/eCA.RecClinicalNotesMultiUploadServlet';
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.btnUploadFile.disabled = true;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.RecClinicalNotesFileUploadForm.submit();	
		}
	}
		
		

	function reLoadFrames(result,called_from)
	{
		var msg = "";
		if (result == 'FILELIMITEXCEED')
		{
			msg = getMessage("FILE_LIMIT_EXCEED",'CA');
		}
		else if (result == 'FILESIZEEXCEED')
		{
			msg = getMessage("FILE_SIZE_EXCEED",'CA'); 
		}
		else if (result == 'DUPLICATEFILE')
		{
			msg = getMessage("DUPLICATE_FILE",'CA');  
		}
		else if (result == 'NOTEALREADYSIGNED')
		{
			msg = getMessage("FILE_UPLOAD_ON_SIGN",'CA');  
			
		}

		if (msg != "")
		{
			alert(msg);
		}	
		
		if (called_from == undefined || called_from == "")
		{
			top.RecClinicalNotesFileUploadFrame.document.location.reload();
			top.RecClinicalNotesFileUploadListFrame.document.location.reload();
			top.RecClinicalNotesFileUploadToolbarFrame.document.location.reload();
			top.messageframe.document.location.href= '../../eCommon/jsp/MstCodeError.jsp';
		}else{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadFrame.document.location.reload();
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.RecClinicalNotesFileUploadListFrame.document.location.reload();


			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.location.reload();
				
/*			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.btnUploadFile.disabled = false;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = false;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = false;*/
			top.content.messageFrame.document.location.href= '../../eCommon/jsp/MstCodeError.jsp';
		}
		
	}

	function displayFile(fileName)
	{ 
		//IN054801 Start.
		//window.open("../../eCA/jsp/RecClinicalNotesDispDocMian.jsp?fileName="+fileName,'BeanDocument',"height=590,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");
		var win_width		= (parseInt(screen.availWidth)-10);	 //IN054801
		window.open("../../eCA/jsp/RecClinicalNotesDispDocMian.jsp?fileName="+fileName,'BeanDocument',"height=590,width="+win_width+",top=80,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes");//IN054801
		//IN054801 End.

		/*var action_url		= "../../eCA/jsp/RecClinicalNotesDispDocMian.jsp?fileName="+fileName;
		var features = "height=590,width=790,top=0,left=0,resizable=yes,directories=no,location=no,menubar=no,status=no,scrollbars=yes";
		window.open(action_url,null,features);	*/
	}

	function showDBDoc(accsNum, noteType, file_seq_no)
	{
		top.RecClinicalNotesShowFileFrame.document.location.href= "../../eCA/jsp/RecClinicalNotesDispDocMian.jsp?accession_num="+escape(accsNum)+"&note_type="+noteType+"&file_seq_no="+file_seq_no;

		//top.RecClinicalNotesShowFileFrame.document.location.href= "../../eCA/jsp/RecClinicalNotesDispDocMian.jsp?accession_num="+accsNum+"&note_type="+noteType+"&file_seq_no="+file_seq_no;
	}

	function delteFile(obj, fileName,called_from)
	{
		if (fileName != undefined && fileName != "")
		{
			var flag = confirm(getMessage("CONFIRM_FILE_DELETE",'CA'));
			
			if(flag)
			{
				var CallFrom = "REMOVEDOC";
				xmlStr ="<root><SEARCH ";
				xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
				xmlStr += "fileName=\""+ fileName +"\" " ;
				xmlStr += "CALLED_FROM=\""+ called_from +"\" " ;
				xmlStr +=" /></root>" ;		
				var xmlHttp = new XMLHttpRequest() ;
				var xmlDoc = "" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "RecClinicalNotesMultiFileUploadvalidate.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				eval(responseText);
			}
			else
			{
				obj.checked = true;
			}
		}
	}

	function checkAndRecord(called_from,operation_mode)
	{
		if (called_from==undefined)
		{
			called_from = "";
		}
		if (operation_mode==undefined)
		{
			operation_mode = "";
		}
		var CallFrom = "CHECKANDRECORD";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr += "CALLED_FROM=\""+ called_from +"\" " ;
		xmlStr += "operation_mode=\""+ operation_mode +"\" " ;
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RecClinicalNotesMultiFileUploadvalidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}

	function clearBean()
	{
		var CallFrom = "CLEARBEAN";
		xmlStr ="<root><SEARCH ";
		xmlStr += "CallFrom=\""+ CallFrom +"\" " ;
		xmlStr +=" /></root>" ;		
		var xmlHttp = new XMLHttpRequest() ;
		var xmlDoc = "" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RecClinicalNotesMultiFileUploadvalidate.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}

	function disableBtns(obj,called_from)
	{		
		if (called_from == undefined || called_from == "")
		{
			top.RecClinicalNotesFileUploadToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record_sec.disabled = true;
		}else{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.record.disabled = true;
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesFileUploadToolbarForm.sign.disabled = true;
		
		}
		
	}


// ends here

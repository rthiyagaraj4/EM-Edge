/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
17/12/2012  IN035950      	Nijitha        	CHL Hospital suggested that the presentation of the Clinician desktop be changed and
											more appealing. Keeping the display of information more clear and visible.
21/12/2012	IN030465		Ramesh G		Triggers an alert upon documentation of a Notifiable Disease.
27/02/2013	IN038176		DineshT		Privilege level setup with sign is not working
15/03/2013  IN038493		Nijitha S	CRF-CA- CHL-CRF-0011/04- Social History Widget->While Modifying a image Linked Section we get script error
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		 Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory  results in a clinical note section template does not display neatly .
02/06/2014	  IN037701		 Nijitha										SKR-CRF-0036
26/11/2014	IN050580		Nijitha			MO-CRF-20080
15/12/2014	IN052359		Rames G		15/12/2014		Akbar S			The defined defaulted value does not auto populated when new row is added in grid component.
																		Refer to attached screen shots.
05/05/2015	IN053298		Ramesh G	05/05/2015		Akbar S			When we attach an image to the clinical note part of the image is not displayed.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var field_array = new Array();
var SameSection = false;

function WriteToFile(sText)
{
	var fso = new ActiveXObject("Scripting.FileSystemObject");
	var s = fso.OpenTextFile("C:\\test.txt", 8,true);
	s.WriteLine(sText);
	s.Close();
}

function checkMaxLimitAddendum(obj,maxSize)
{
	var val	 = obj.value;
	var valLength	 = val.length;
	if (parseInt(valLength)  >= parseInt(maxSize))
	{
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$",'Addendum');
		msg = msg.replace("#",maxSize);
		alert(msg);
		obj.focus();
		return false;
	}
	return true;
}

function setCurFormVal()
{
	var selMed =document.forms[0].serv_disp.value;
	document.forms[0].med_service.value = selMed;
}

function swapHeaderValues()
{
	var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;

	Obj.prev_sec_hdg_code.value				= Obj.curr_sec_hdg_code.value;
	Obj.prev_sec_content_type.value			= Obj.curr_sec_content_type.value;
	Obj.prev_child_sec_hdg_code.value		= Obj.curr_child_sec_hdg_code.value;
	Obj.prev_child_sec_content_type.value	= Obj.curr_child_sec_content_type.value;
	Obj.prev_image_linked_yn.value			= Obj.image_linked_yn.value;
	Obj.prev_image_edited_yn.value			= Obj.image_edited_yn.value;
}

//this function is used to get the correct frame reference
//use messageFrameReference whenever u want to refer the message frame

function getMessageFrame()
{
	if(top.content!=null)
		return top.content.messageFrame;
	else
		return top.messageframe;
}

var messageFrameReference = getMessageFrame();

//Function for the file name RecClinicalNotes.jsp-start
function clearMessageFrame()
{
		//IN037701 Starts
		//messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
		if(undefined != messageFrameReference && null!=messageFrameReference.location)
			messageFrameReference.location.href = '../../eCommon/jsp/error.jsp';
		else
			top.messageframe.location.href = '../../eCommon/jsp/error.jsp';
		//IN037701 Ends
}

function callRecClinicalNotesMain()
{
	var query_string = "";

	if(top.content.workAreaFrame.RecClinicalNotesFrame!=null && top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame!=null  && top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm!=null )
	{
		var patient_id		=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_id.value
		var patient_class	=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_class.value
		var encounter_id	=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.encounter_id.value
		var event_class		=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.event_class.value
		var function_id		=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.function_id.value
		var appl_task_id	=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.appl_task_id.value
		var from_date_time	=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.from_date_time.value
		var to_date_time	=	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.to_date_time.value

		query_string = "patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&event_class="+event_class+"&function_id="+function_id+"&appl_task_id="+appl_task_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time;
		top.content.workAreaFrame.location.href ='../../eCA/jsp/RecClinicalNotes.jsp?'+query_string;
		messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
	}
	else
	{
		//alert("in Else "+document.RecClinicalNotesTabForm.query_string.value);
		query_string = document.RecClinicalNotesTabForm.query_string.value;
		var patient_class =document.RecClinicalNotesTabForm.patient_class.value;
		parent.RecClinicalNotesFrame.location.href = '../../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string+"&patient_class="+patient_class;
		messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
	}
}

function callRecClinicalNotesSearch()
{
	var query_string = "";

if(top.content.workAreaFrame.RecClinicalNotesFrame!=null && top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame!=null && top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm!=null)
	{

		var patient_id =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_id.value
		var patient_class =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.patient_class.value
		var encounter_id =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.encounter_id.value
		var event_class =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.event_class.value
		var function_id =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.function_id.value
		var appl_task_id =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.appl_task_id.value
		var from_date_time =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.from_date_time.value
		var to_date_time =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.to_date_time.value
		var note_type =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_type.value
		var note_group =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.note_group.value
		var operation_mode =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.operation_mode.value
		var p_called_from_widget =top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesFileUploadForm.p_called_from_widget.value;//CIS-CA-1490
		//query_string = "patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&event_class="+event_class+"&function_id="+function_id+"&appl_task_id="+appl_task_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time;//CIS-CA-1490
		query_string = "patient_id="+patient_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&event_class="+event_class+"&function_id="+function_id+"&appl_task_id="+appl_task_id+"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&p_called_from_widget="+p_called_from_widget;//CIS-CA-1490
			if(operation_mode == "update")
		query_string+="&note_type="+note_type+"&note_group="+note_group;
	}
	else
		query_string = document.RecClinicalNotesTabForm.query_string.value;

	parent.RecClinicalNotesFrame.location.href = '../../eCA/jsp/RecClinicalNotesSearchResultMain.jsp?'+query_string;
	messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
}

function changeUnsignedValue(obj)
{
	if(obj.checked == true)	{ top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchCriteriaFrame.document.forms[0].other_unsigned_yn.value = "Y"
	}
	else{	  				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSrchCriteriaFrame.document.forms[0].other_unsigned_yn.value = "N"
	}
}

function checkCannedTextExists()
{
	if( parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm==null ) return false;
//	var note_type			=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;
	if(note_type=="") return false;
	var service_code		=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code;
//	var sec_hdg_code		=	parent.RecClinicalNotesSecControlFrame.document.forms[0].curr_sec_hdg_code.value;
//	var sec_content_type	=	parent.RecClinicalNotesSecControlFrame.document.forms[0].curr_sec_content_type.value;
//	var child_sec_hdg_code	=	parent.RecClinicalNotesSecControlFrame.document.forms[0].curr_child_sec_hdg_code.value;

	if(sec_content_type=="S")
		sec_hdg_code		=	child_sec_hdg_code;

	var action_url		=	getRelativeURL('/eCA/jsp/RecClinicalNotesCheckCannedText.jsp');

	var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='RecClinicalNotesCannedTextForm' id='RecClinicalNotesCannedTextForm' method='get' action='"+action_url+"'>"+
	"<input type='hidden' name='service_code' id='service_code' value='"+service_code.value+"'>"+
	"<input type='hidden' name='note_type' id='note_type' value='"+note_type+"'>"+
	"<input type='hidden' name='sec_hdg_code' id='sec_hdg_code' value='"+sec_hdg_code+"'>"+
	"</form></body></html>";
	messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	messageFrameReference.document.RecClinicalNotesCannedTextForm.submit();
}

function callNoteSectionRoutine()
{

	var toolbarURL = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href;

	toolbarURL = toolbarURL.indexOf("RecClinicalNotesFileUploadToolbar.jsp");

	if (toolbarURL > 0 )
	{
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href='../../eCA/jsp/RecClinicalNotesToolbar.jsp';
	}

	setTimeout("callNoteSectionRoutine1()",500);

}


function callNoteSectionRoutine1()
{
	var ObjHeader	= document.RecClinicalNotesHeaderForm;

	ObjHeader.performed_by_phy_name.value		= "";
	ObjHeader.performed_by_id.value				= "";
	ObjHeader.serv_disp.value				= "";
	ObjHeader.service_code.value				= "";
	var note_type		=	ObjHeader.note_type;
	var episode_type		=	ObjHeader.episode_type;
	var patient_id			=	ObjHeader.patient_id;
	var patient_class		=	ObjHeader.patient_class;
	var encounter_id		=	ObjHeader.encounter_id;
	var appl_task_id		=	ObjHeader.appl_task_id;
	var def_serv_code		=   ObjHeader.defa_speciality_code;
	var visit_adm_date		=	ObjHeader.visit_adm_date;
	var module_id		=	ObjHeader.module_id;
	var filter_by		=	ObjHeader.filter_by;
	var ql_flag		=	ObjHeader.ql_flag;
	var medanc_serv_ql		=	ObjHeader.medanc_serv_ql;
	var performed_by_ql		=	ObjHeader.performed_by_ql;
	//var doc_linked_note_yn		=	ObjHeader.doc_linked_note_yn;
	var facility_id		=	ObjHeader.sel_facility_id;

	//ObjHeader.hideHeaderButton.disabled			= false;

	if(ObjHeader.note_type.value=='')
	{

		ObjHeader.hideHeaderButton.disabled			= true;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.location.href='../../eCommon/html/blank.html';
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.location.href='../../eCA/jsp/RecClinicalNotesToolbar.jsp?function_id='+ObjHeader.function_id.value;
	}
	else
	{
		ObjHeader.hideHeaderButton.disabled			= false;
	}

	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecClinicalNotesFrame.EditorTitleFrame.location.href='../../eCommon/html/blank.html';

	expandSectionFrames();



	ObjHeader.note_type_desc.value = note_type.options(note_type.selectedIndex).text;



	if(checkIsNull(note_type))
	{
		if(ObjHeader.called_from.value!='OH_TREATMENT'){
			ObjHeader.note_group.disabled = false;
			ObjHeader.note_group.value = "";
			return false;
		}
	}
	/*if(ql_flag=="Y")
	{
		ObjHeader.note_type.disabled=false;
	}
	else
	{
		ObjHeader.note_type.disabled=true;
	} */


	ObjHeader.performed_by_id.disabled = false;
	parent.RecClinicalNotesSecDetailsFrame.location.href = '../../eCommon/html/blank.html';

	var action_url		=	getRelativeURL('/eCA/jsp/RecClinicalNotesSecRoutine.jsp');
	var accession_num			=	document.RecClinicalNotesHeaderForm.accession_num;

	if (parent.RecClinicalNotesSecControlFrame != null)
	{
		if(parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.accession_num != null)
		{
			var ctrl_accession_num		=	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.accession_num;
			ctrl_accession_num.value	=	"";
		}

		accession_num.value			=	"";
	}


	var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='RecClinicalNotesSecRoutineForm' id='RecClinicalNotesSecRoutineForm' method='get' action='"+action_url+"'>"+
	"<input type='hidden' name='note_type' id='note_type' value='"+note_type.value+"'>"+
	"<input type='hidden' name='episode_type' id='episode_type' value='"+episode_type.value+"'>"+
	"<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id.value+"'>"+
	"<input type='hidden' name='patient_class' id='patient_class' value='"+patient_class.value+"'>"+
	"<input type='hidden' name='encounter_id' id='encounter_id' value='"+encounter_id.value+"'>"+
	"<input type='hidden' name='visit_adm_date' id='visit_adm_date' value='"+visit_adm_date.value+"'>"+
	"<input type='hidden' name='appl_task_id' id='appl_task_id' value='"+appl_task_id.value+"'>"+
	"<input type='hidden' name='defa_speciality_code' id='defa_speciality_code' value='"+def_serv_code.value+"'>"+
	"<input type='hidden' name='module_id' id='module_id' value='"+module_id.value+"'>"+
	"<input type='hidden' name='ql_flag' id='ql_flag' value='"+ql_flag.value+"'>"+
	"<input type='hidden' name='medanc_serv_ql' id='medanc_serv_ql' value='"+medanc_serv_ql.value+"'>"+
	"<input type='hidden' name='performed_by_ql' id='performed_by_ql' value='"+performed_by_ql.value+"'>"+
	"</form></body></html>";

	messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	messageFrameReference.document.RecClinicalNotesSecRoutineForm.submit();
	document.RecClinicalNotesHeaderForm.event_title_desc.focus();
	ObjHeader.ql_flag.value="";
}

function showSectionDetails(tblrow_id, sec_hdg_code,child_sec_hdg_code,sec_hdg_desc,child_sec_hdg_desc,currr_image_linked_yn,result_link_yn,operation_mode,content_type,chief_complaint_sec_yn,result_link_type,main_section_type,expandCounter,subsecctr,selection_type)
{
	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.selection_type.value = selection_type ;
	if (main_section_type == "S" && expandCounter > 0  && subsecctr == undefined )
	{

		expandCollapse(expandCounter,sec_hdg_code);
		return;
	}
	//IN055628 Start.
	if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)
	{
		var inputs = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementsByTagName("IFRAME");
		var len=inputs.length;
		for(var i=0;i<len;i++){
			var input = inputs[i];
			var iframeObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById('"+input.id+"').contentWindow.document.body");
			var hiddenObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.forms[0]."+input.name);

			hiddenObj.value	= iframeObj.innerHTML;
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<p>&nbsp;</p>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<P>&nbsp;</P>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<address>&nbsp;</address>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<ADDRESS>&nbsp;</ADDRESS>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace('<PRE>', '<HTML><BODY><PRE>');
			hiddenObj.value	= (hiddenObj.value).replace('</PRE>', '</PRE></BODY></HTML>');
		}
	}
	//IN055628 End.
	parent.frameSetIdHeader.rows='6.5%,86.5%,10%';
	parent.frameSetIdMessage.rows='0%,*%';
	//parent.RecClinicalNotesToolbarFrame.document.getElementById("process_msg").style.display = "inline";
	//parent.RecClinicalNotesSectionFrame.document.getElementById("tbl_section").style.display = "none";
	//parent.RecClinicalNotesSectionFrame.document.getElementById("notes_view").disabled = true;
//	callProcessControlDialog1();

	var editor_title	= "";
	var mode			= "";
	var content_temp	= "";

	content_temp = content_type;

	if(result_link_type != "")
		content_temp = "R";

	if(child_sec_hdg_desc =="")
		editor_title	=	sec_hdg_desc
	else
		editor_title	= child_sec_hdg_desc +" \ "+ sec_hdg_desc

	compressHeaderFrames();
	if(sec_hdg_code == "*AmmendNotes*")
		mode = sec_hdg_code;
	else
		mode = "SectionAmmend";
	if(operation_mode == "ModifyAddendum")
	{
		//parent.frameSetIdAddendum.rows="6%,42%,52%";		[IN032681]
		parent.frameSetIdAddendum.rows="6%,42%,6%,46%";
		//parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.cols="105";


		document.getElementById("notes_view").style.color = 'BLUE';

		setButtonsforOperations(operation_mode,true);

		assignSectionAddendum(sec_hdg_code, child_sec_hdg_code, editor_title, operation_mode,mode,'');
		return;

	}

	setSectionBasedButtons(content_temp,chief_complaint_sec_yn,operation_mode);
	//IN037701 Starts
	if(undefined != top.content && top.content!=null)
		top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	else
		top.messageframe.location.href = '../../eCommon/jsp/error.jsp';
	//IN037701 Ends
	assignSectionDetails(sec_hdg_code,child_sec_hdg_code,editor_title,currr_image_linked_yn,operation_mode,result_link_yn,result_link_type,content_type)
	expandSectionFrames();
}


function assignSectionDetails(curr_sec_hdg_code,curr_child_sec_hdg_code,editor_title,currr_image_linked_yn,operation_mode,result_link_yn,result_link_type,content_type)
{
//alert("curr_sec_hdg_code  :  "+curr_sec_hdg_code+"**   curr_child_sec_hdg_code  :   "+curr_child_sec_hdg_code+"**  editor_title  :  "+editor_title+"**  currr_image_linked_yn  : "+currr_image_linked_yn+"**operation_mode  : "+operation_mode+"**  result_link_yn   :  "+result_link_yn+"**  result_link_type   :  "+result_link_type+"**  content_type  : "+content_type);

var patient_id						="";
var encounter_id					="";
var episode_type					="";
var accession_num					="";
var patient_class					="";
var module_id					="";

var section_image_content			="";
var section_content					="";
var template_mode					="";
var prev_image_linked_yn			="";
//var section_content					="";
var image_edited_yn					="";
var section_image_content			="";
var prev_sec_hdg_code				="";
var prev_child_sec_hdg_code			="";
var prev_image_linked_yn	 		="";
var note_type			 			="";
var note_type_desc			 		="";
var note_status			 			="";
var event_date_time			 		="";
var performing_phy_name			 	="";
var image_hidden_name				="";
var image_hidden_obj				="";
var appl_task_id					="";
var error_msg					="";
var clear_values = "";
var dispResLinkHYMLYN ="N"; //IN041284

var section_content					= parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.section_content;

var contr_mod_accession_num = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.contr_mod_accession_num.value;  //[IN032874]
//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;[IN035950]
//IN035950 Starts
if(undefined !=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame)//IN037701
{
var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
}
else
{
	var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
}
//IN035950 Ends

//var sec_obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm;Nijitha
if(operation_mode !="Preview" )
{
	setButtonsforOperations(operation_mode,true,'',result_link_yn,content_type);
	//setTimeout("setButtonsforOperations('"+operation_mode+"',true)",500);
}
//IN041284 Start.
else{
	if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)
	{
		var inputs = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementsByTagName("IFRAME");
		var len=inputs.length;
		for(var i=0;i<len;i++){
			var input = inputs[i];
			var iframeObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById('"+input.id+"').contentWindow.document.body");
			var hiddenObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.forms[0]."+input.name);

			hiddenObj.value	= iframeObj.innerHTML;
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<p>&nbsp;</p>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<P>&nbsp;</P>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<address>&nbsp;</address>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<ADDRESS>&nbsp;</ADDRESS>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace('<PRE>', '<HTML><BODY><PRE>');
			hiddenObj.value	= (hiddenObj.value).replace('</PRE>', '</PRE></BODY></HTML>');
		}
	}
}
//IN041284 End.
expandSectionFrames();
patient_id					=		Obj.patient_id.value;
prev_sec_hdg_code			=		Obj.prev_sec_hdg_code.value;
prev_child_sec_hdg_code		=		Obj.prev_child_sec_hdg_code.value;
prev_image_linked_yn		=		Obj.prev_image_linked_yn.value;
note_type					=		Obj.note_type.value;
//note_status					=		Obj.event_status.value;
note_type_desc				=		Obj.note_type_desc.value;
performing_phy_name			=		Obj.performing_phy_name.value;
event_date_time				=		Obj.event_date_time.value;
episode_type				=		Obj.episode_type.value;
accession_num				=		Obj.accession_num.value;
patient_class				=		Obj.patient_class.value;
encounter_id				=		Obj.encounter_id.value;
Sex							=		Obj.Sex.value;
Dob							=		Obj.Dob.value;
module_id					=		Obj.module_id.value;
appl_task_id				=		Obj.appl_task_id.value;
selection_type				=		Obj.selection_type.value;
dispResLinkHYMLYN			=		Obj.dispResLinkHYMLYN.value; //IN041284


messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
if(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame !=null)
{
	if(!recordTemplateDetails())
	{
		bool = confirm(getMessage("TEMP_MANDATORY",'CA'));

		if(bool)
		{
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='';
			// Newly Added by selvin for Incident 27228 on 16 june 2011
			if(template_mode!=null && template_mode.value=="Insert")
			template_mode.value	=	"RemoveTemplate";
			clear_values = "clearTemplateValues"
			expandSectionFrames();
			messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
		}
		else{
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='<b>'+getLabel("eCA.ClickForRecAndSign.label","CA")+'</b>'; // Newly Added by selvin for Incident 27228 on 16 june 2011
			if(operation_mode=='ModifySection')
			{
				setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,true);
				parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML =''; // Newly Added by selvin for Incident 27228 on 16 june 2011
			}
			else
			{
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].notesView,true);
			}
			parent.frameSetIdMessage.rows='*%,0%';
			return false;
		}
	}
}

if(prev_image_linked_yn == 'Y' && parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame != null)
{
	//Modified By Sridhar Reddy on 13/05/2010 to restrict blank note record
	if (trimString(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerText) != "")
	{
	section_content.value = removeHyperLink (parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0);
	}else{
		if (operation_mode == "sectionView")
		{
			alert(getMessage("EMPTY_CONTENT",'CA'));
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].notesView,true);
			//Newly added  by Name :Selvin M  Date :16 june 2011 INCIDENT NO: 27228 Changes:newly added Starts
					parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='<b>Click on "Notes View" for "Record" & "SIGN" buttons</b>';
			//Ends
			parent.frameSetIdMessage.rows='*%,0%';
			return false;
		}
	}
}
else if(parent.RecClinicalNotesSecDetailsFrame.RTEditor0!=null)
{
	//Modified By Sridhar Reddy on 13/05/2010 to restrict blank note record
	if (trimString(parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.innerText) != "")
	{
		section_content.value = removeHyperLink (parent.RecClinicalNotesSecDetailsFrame.RTEditor0);
	}else{
		if (operation_mode == "sectionView")
		{
			alert(getMessage("EMPTY_CONTENT",'CA'));
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].notesView,true);
			//Newly added  by Name :Selvin M  Date :16 june 2011 INCIDENT NO: 27228 Changes:newly added Starts
					parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='<b>Click on "Notes View" for "Record" & "SIGN" buttons</b>';
			//Ends
			parent.frameSetIdMessage.rows='*%,0%';
			return false;
		}
	}

}

if(prev_image_linked_yn == 'Y' && parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame != null)
{
	image_edited_yn = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].IsChanged();
	//image_edited_yn = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.getElementById("drawing").IsChanged();

	if(Obj.avl_image_selected.value == 'true')
			image_edited_yn = true;

	if(image_edited_yn == true)
	{
		image_edited_yn = "Y";
		//section_image_content = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.getElementById("drawing").GetImage("JPEG");
		section_image_content = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].GetImage("JPEG");
		image_hidden_name = "img_"+prev_sec_hdg_code+"_"+prev_child_sec_hdg_code;
		//IN038493 Start.
		//image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		var objFrame= eval("top.content.workAreaFrame.RecClinicalNotesFrame");
		if(objFrame!=undefined){
			image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		}else{
			image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		}
		//IN038493 End.
		image_hidden_obj.value = section_image_content;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].section_image_content.value = section_image_content;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].section_image_height.value =parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].height; //IN053298
	}
}




// assigning the current section values as its preveious values in the header form...


if(operation_mode!="Preview")
{
	Obj.prev_sec_hdg_code.value			=		curr_sec_hdg_code;
	Obj.prev_child_sec_hdg_code.value	=		curr_child_sec_hdg_code;
	Obj.prev_image_linked_yn.value		=		currr_image_linked_yn;
	Obj.prev_sec_result_link_type.value	=		result_link_type;
	Obj.prev_sec_type.value				=		content_type;
}

var url = "";
var pars = "";
var no_of_rows = "";
no_of_rows = Obj.no_of_rows.value;

if(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame != null)
{
//		var returnVals = buildXMLParams();
		url = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
		//[IN032874] Start
		//pars ='curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&section_content='+'&editor_title='+encodeURIComponent(editor_title,"UTF-8")+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&no_of_rows='+no_of_rows+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob+'&module_id='+module_id+'&appl_task_id='+appl_task_id+"&clear_values="+clear_values;
		pars ='curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&section_content='+'&editor_title='+encodeURIComponent(editor_title,"UTF-8")+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&no_of_rows='+no_of_rows+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob+'&module_id='+module_id+'&appl_task_id='+appl_task_id+"&clear_values="+clear_values+'&contr_mod_accession_num='+contr_mod_accession_num;
		pars=pars+"&dispResLinkHYMLYN="+dispResLinkHYMLYN; //IN041284
		//[IN032874] End
//		pars+="&"+returnVals;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.target = "RecClinicalNotesSecTempControlFrame";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = url+pars;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();

}
else
{
		url = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
		//[IN032874] Start
		//pars ='curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&editor_title='+encodeURIComponent(editor_title,"UTF-8")+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&no_of_rows='+no_of_rows+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob+'&module_id='+module_id+'&appl_task_id='+appl_task_id+'&selection_type='+selection_type;
			//+'&note_status='+note_status+'&note_type_desc='+note_type_desc+'&performing_phy_name='+performing_phy_name+'&event_date_time='+event_date_time;
		pars ='curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&editor_title='+encodeURIComponent(editor_title,"UTF-8")+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&no_of_rows='+no_of_rows+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob+'&module_id='+module_id+'&appl_task_id='+appl_task_id+'&selection_type='+selection_type+'&contr_mod_accession_num='+contr_mod_accession_num;
		pars=pars+"&dispResLinkHYMLYN="+dispResLinkHYMLYN; //IN041284
		//[IN032874] END
		parent.RecClinicalNotesSecControlFrame.document.forms[0].target =	parent.RecClinicalNotesSecControlFrame.name;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].action	=	url+pars;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].method	=	'post';
		parent.RecClinicalNotesSecControlFrame.document.forms[0].submit();


}
/*
var myAjax = new Ajax.Updater(
								{success: 'placeholder'},
								url,
								{
								method: 'post',
								parameters: pars,
								onSuccess: callsuccess,
								onFailure: reportError,
								evalScripts: true
								});


*/


	if(operation_mode != "Preview")
	{
		if(result_link_yn == "Y")
			setTimeout("showLinkDocuments('"+curr_sec_hdg_code+"','"+content_type+"', '"+curr_child_sec_hdg_code+"', '"+content_type+"','"+result_link_type+"','"+currr_image_linked_yn+"')",1000);
	}
	//parent.parent.RecClinicalNotesSecTempControlFrame.document.getElementById("link_doc").disabled = 'false';

}

// Added By Sridhar Reddy on 23/03/2010 to fix incident IN019975
function removeHyperLink (obj)
{
	var content_val = "";
	if(obj.document.body.innerHTML != null)
	{
		len = obj.document.links.length;
		for(i=0;i<len;i++)
		{
			obj.document.links[i].href='#';
			obj.document.links[i].style.textdecoration='none';
			obj.document.links[i].style.color='#000000';
			obj.document.links[i].style.cursor='normal';
		}
		content_val   =	obj.document.body.innerHTML;
	}else{
		content_val   =	obj.document.body.innerHTML;
	}

	return content_val;

}
//End

function reportError(request)
{
	 alert(getMessage("AJAX_ERROR","CA"));
}

function callsuccess(originalRequest)
{
	parent.RecClinicalNotesSecDetailsFrame.document.write(originalRequest.responseText);
    outputText(originalRequest.responseText);
}

function outputText(text1)
{
	var url = "../../eCA/jsp/Temp1.jsp";
	var pars ='text1='+encodeURIComponent(text1);
	var myAjax = new Ajax.Updater(
								{success: 'placeholder'},
								url,
								{
								method: 'post',
								parameters: pars,
								onFailure: reportError,
								evalScripts: true
								});

}

function disablebuttons(result_link_yn)
{
/*
	if(result_link_yn == "Y")
		parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc.disabled = false;
	else
		parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc.disabled = true;
*/
}

function showlink()
{
	//alert();
}

function buildXMLParams()
{
	var Obj = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.forms[0];
	var len = Obj.elements.length;

	var XMLString	= "";
	var built		= "Y";

	for(var i = 0;i<len; i++)
	{
		built = "Y";

		if(Obj.elements(i).type == "checkbox" || Obj.elements(i).type == "radio")
		{
			if(Obj.elements(i).checked)
				built ="Y";
			else
				built ="N";
		}

		if(built == "Y")
		{
			if(XMLString == "")
			{
				XMLString = Obj.elements(i).name;
				XMLString +="="+Obj.elements(i).value;
			}
			else
			{
				XMLString +="&"+ Obj.elements(i).name;
				XMLString +="="+Obj.elements(i).value;
			}
		}
	}

	return XMLString;
}


function showLinkDocuments(sec_hdg_code, sec_content_type, child_sec_hdg_code, child_sec_content_type, result_linked_rec_type,image_linked_yn)
{

	 //alert("showLinkDocuments")
	//  alert("sec_hdg_code..in showLinkDocuments...."+sec_hdg_code+"....child_sec_hdg_code.."+child_sec_hdg_code);

	var episode_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.episode_type.value;
	var encounter_id	 = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
	var patient_id	 = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
	var sex	 = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value;
	var Dob	 = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Dob.value;
	var appl_task_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.appl_task_id.value;
	var selection_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.selection_type.value;
	var operation_mode = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode.value;
	var accession_num = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.accession_num.value;
	var note_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;


	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"40" ;
	var dialogWidth		=	"60" ;
	var status			=	"no";
	var arguments		=	"" ;
	var sql				=	"";
	var search_code		=	"";
	var search_desc		=	"";
	var title			=	"";
	var param			=	"";
	var action_url		=   "";
	var features		=	"";
	if(appl_task_id=="PAT_MEDICAL_REPORT"&& selection_type=="M")
	{
		action_url		=	'../../eCA/jsp/RecClinicalNotesLinkMultiHistMain.jsp';
		features		=	"dialogHeight:41; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	}
	else
	{
		action_url		=	'../../eCA/jsp/RecClinicalNotesLinkHistMain.jsp';
		features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	}
//	action_url		=	'../../eCA/jsp/RecClinicalNotesLinkHistMain.jsp';
//	action_url		=	'../../eCA/jsp/RecClinicalNotesLinkMultiHistMain.jsp';

	action_url			+=	"?result_linked_rec_type="+result_linked_rec_type+"&episode_type="+episode_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&sex="+sex+"&Dob="+Dob+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code+"&operation_mode="+operation_mode+"&accession_num="+accession_num+"&note_type="+note_type;


 	if(image_linked_yn=='Y')
		var url = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.location.href;
	else
		var	url	=	parent.RecClinicalNotesSecDetailsFrame.location.href;

	if( (url.indexOf('/eCA/jsp/RTEditor.jsp')!=-1) )
	{
		if(image_linked_yn=='Y')
			parent.RecClinicalNotesSecDetailsFrame.frames[0].RTEditor0.focus();
		//else
			//parent.RecClinicalNotesSecDetailsFrame.RTEditor0.focus();
	}

	retVal				=	window.showModalDialog(action_url,arguments,features);


	if(appl_task_id=="PAT_MEDICAL_REPORT"&& selection_type=="M")
	{


		if(retVal!='Y')
		{
			var mode ="removeAll";

			var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' type='text/css' /></HEAD><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY onKeyDown='lockKey()' CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='../../eCA/jsp/RecClinicalNotesLinkMultiHistIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode="+mode+"'></form></BODY></HTML>";
			//	+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code +"&histdatatype="+histdatatype+"&Histrectype="+histrectype+"&Contrsysid="+contr_sys_id+"&Contrsyseventcode="+contr_sys_event_code+"&Accessionnum="+encodeURIComponent(accessionnum,"UTF-8")+"&result_disp="+result_disp+"&hist_rec_type_desc="+hist_rec_type_desc+"&event_date_time="+event_date_time+"&mode="+mode+"
			//top.content.messageFrame.document.write(HTMLVal);
			top.content.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			top.content.messageFrame.document.forms[0].submit();
			top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';

		}


		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_sec_hdg_code.value= sec_hdg_code;
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_child_sec_hdg_code.value= child_sec_hdg_code;
		//alert('sec_codes.1..'+parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_sec_hdg_code.value);
		//alert('sec_codes.2..'+parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_child_sec_hdg_code.value);

		assignSectionDetails("","","","","sectionView");
	}
	else
	{

	if (retVal != null)
	{
		if( (url.indexOf('/eCA/jsp/RTEditor.jsp')==-1) )
		{
			swapHeaderValues();
			assignSectionDetails(sec_hdg_code,sec_content_type,child_sec_hdg_code, child_sec_content_type, result_linked_rec_type,'sectionEdit',doc_exists);
		}
		else
		{
			if(image_linked_yn=='Y')
				var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.createTextRange();
			else
				var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.createTextRange();

			var section_content	=	txtRange.text;

			if(section_content.length>0)
			{
				if(result_linked_rec_type=='CLNT'||result_linked_rec_type=='MEDN'||result_linked_rec_type=='ALGY'||result_linked_rec_type=='DIAG' || result_linked_rec_type == 'PTCR' || result_linked_rec_type == 'LBIN' || result_linked_rec_type == 'LBRP'|| result_linked_rec_type == 'RDIN' || result_linked_rec_type == 'RDRP' || result_linked_rec_type == 'SUNT' || result_linked_rec_type == 'TRET' )
					retVal	= "<br>"+retVal;
			}

			if(result_linked_rec_type!="" && result_linked_rec_type!=null)

					//=='CLNT')||result_linked_rec_type=='MEDN'||result_linked_rec_type=='ALGY'||result_linked_rec_type=='DIAG' || result_linked_rec_type == 'PTCR' || result_linked_rec_type == 'LBIN' || result_linked_rec_type == 'LBRP'|| result_linked_rec_type == 'RDIN' || result_linked_rec_type == 'RDRP' || result_linked_rec_type == 'SUNT' || result_linked_rec_type == 'TRET' || result_linked_rec_type == 'FDOC' )
			{
				if(image_linked_yn=='Y')
					parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",(retVal));
				else
					parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",(retVal));
			}
			else
			{
				if(image_linked_yn=='Y')
					parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand("paste","",retVal );
				else
					parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("paste","",retVal );
			}
		}
	}
	}

//	parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc.disabled = false;
}

function setEditorRequiredYN(editor_title)
{
	var editor_reqd_yn	=	parent.parent.RecClinicalNotesTabsFrame.document.forms[0].editor_reqd_yn.value;
	parent.RecClinicalNotesSecControlFrame.document.forms[0].editor_reqd_yn.value = editor_reqd_yn;

	if(editor_reqd_yn=="Y")
		editor_title	=	editor_title;
	else
		editor_title	=	editor_title;

	parent.RecClinicalNotesSecControlFrame.document.forms[0].editor_title.value = editor_title;
}
function expandCollapse(cnt, sec_hdg_code)
{
	var anchor = eval("document.getElementById("no_of_sub_sections_")" + sec_hdg_code + "_anchor.innerText");
	var no_of_subsections = parseInt(eval("document.RecClinicalNotesSectionForm.no_of_sub_sections_" + sec_hdg_code + ".value"));

	if(no_of_subsections >0)
	{
		if(anchor == "-")
		{
			if(no_of_subsections >0)
			{
				for(i = (parseInt(cnt) ); i < (parseInt(cnt) + parseInt(no_of_subsections)) ;i++)
				{
					var tblrow_obj = eval("document.getElementById("tblrow_id")" + i);
					tblrow_obj.style.display = 'none';
				}
			}

			eval("document.getElementById("no_of_sub_sections_")" + sec_hdg_code + "_anchor.innerText = '+'");
		}
		else
		{
			if(no_of_subsections >0)
			{
				for(i = (parseInt(cnt) ); i < (parseInt(cnt) + parseInt(no_of_subsections)) ;i++)
				{
					var tblrow_obj = eval("document.getElementById("tblrow_id")" + i);
					tblrow_obj.style.display = 'inline';
				}
			}

			eval("document.getElementById("no_of_sub_sections_")" + sec_hdg_code + "_anchor.innerText = '-'");
		}
	}
}

function showNotes(tblrow_id,operation_mode,ObjName)
{
	clearMessageFrame();
	setButtonsforOperations(operation_mode,true);
	setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].chief_complaints,false);
	setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].canned_text,false);
	setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc,false);
//	parent.frameSetIdHeader.rows='28%,62%,10%';
	compressHeaderFrames();
	//callProcessControlDialog1();

	parent.frameSetIdHeader.rows='6.5%,86.5%,10%';
	parent.frameSetIdMessage.rows='0%,*%';
	//parent.RecClinicalNotesToolbarFrame.document.getElementById("process_msg").style.display = "inline";
	//parent.RecClinicalNotesSectionFrame.document.getElementById("tbl_section").style.display = "none";


//	callProcessControlDialog();

	if(operation_mode == "ModifyAddendum")
	{
		//parent.frameSetIdAddendum.rows="6%,94%,0%";    [IN032681]
		parent.frameSetIdAddendum.rows="6%,42%,6%,46%";
		if (operation_mode == "ModifyAddendum")
		{
			if(ObjName == "" )
				assignSectionAddendum('', '', '', operation_mode,'sectionView','');
			else
				assignSectionAddendum('', '', '', operation_mode,'Preview','');
		}
	}
	else
	{
		assignSectionDetails("","","","","sectionView");
	}

expandSectionFrames();

}

function checkIsNull(obj)
{

	if((obj!=null) || (obj!=undefined))
	{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
	}
}

function checkForMandatoryFields()
{
	var fields;
	var names;

	var	hdr_event_date_time				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time;
	var	hdr_performed_by_id				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.performed_by_id;
	var	hdr_service_code				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.service_code;
	//var	hdr_serv_disp				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.serv_disp;
	var	hdr_note_type					=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type;

	//fields		=	new Array ( hdr_note_type, hdr_service_code, hdr_event_date_time, hdr_performed_by_id,hdr_serv_disp ) ;
	//names		=	new Array (getLabel("Common.NoteType.label","Common"),getLabel("Common.Med/AncService.label","COMMON"),getLabel("Common.datetime.label","Common"),getLabel("Common.Performed.label","COMMON"),getLabel("Common.Med/AncService.label","COMMON"));

	fields		=	new Array ( hdr_note_type, hdr_service_code, hdr_event_date_time, hdr_performed_by_id) ;
	names		=	new Array (getLabel("Common.NoteType.label","Common"),getLabel("Common.Med/AncService.label","COMMON"),getLabel("Common.datetime.label","Common"),getLabel("Common.Performed.label","COMMON"));

	//if(!(checkFieldsofMst(fields,names,messageFrameReference))) //commented by Arvind For ICN 18674 on 2/15/2010
	if(!(checkFields(fields,names,messageFrameReference)))
		return false;
	else
		return true;
}

function disableButtons(booleanFlag,operation_mode)
{
/*
	if( (operation_mode=="ModifyAddendum") || (operation_mode=="ModifySection") )
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled	=	booleanFlag;
	}
	else
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled	=	booleanFlag;

		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc.disabled	=	booleanFlag;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record.disabled	=	booleanFlag;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.cancel.disabled	=	booleanFlag;

		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.btn_Print.disabled	=	booleanFlag;

		if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("fileupload_btn")!=null || top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("fileupload_btn") != undefined)
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("fileupload_btn").disabled	=	booleanFlag;

	//		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.clearBean.disabled	=	booleanFlag;

	}
*/
}
function showCancelButton(flag)
{
	/*
		if(flag)
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.cancel.style.display="inline";
		else
			top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.cancel.style.display="none";
	*/
}

function RecordClinicalNotes(objButton)
{
	var retVal = true;

	if(retVal)
	{
		//alert("here");

		//parent.RecClinicalNotesToolbarFrame.document.forms[0].sign.disabled = true;
		//setToolBarButtons(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.canned_text,false);IN035950
		//setToolBarButtons(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.chief_complaints,false);IN035950

		//IN035950 Starts
		if(undefined!=top.content && null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame)//IN037701
		{
		setToolBarButtons(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.canned_text,false);
		setToolBarButtons(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.chief_complaints,false);
		}
		else
		{
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.canned_text,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.chief_complaints,false);

		}
		//IN035950 Ends

		var operation_mode = parent.RecClinicalNotesHeaderFrame.document.forms[0].operation_mode.value;

		var Obj = parent.RecClinicalNotesHeaderFrame.document.forms[0].operation_mode;

		if( (operation_mode == "Update"  || operation_mode == "UpdateRecord") )
		{
			if(objButton.name=="sign")
				Obj.value = "Sign";
			else if(objButton.name=="record")
				Obj.value = "UpdateRecord";
			//temp chk

			if(!(checkForMandatoryFields()))
			{
				expandHeaderFrames(operation_mode);
				return false;
			}

			//temp
		}
		else
		{

			if(operation_mode == null || operation_mode == "" || operation_mode == "Record" )
			{
				if(objButton.name=="sign")
					Obj.value = "Sign";
				else if(objButton.name=="record")
					Obj.value ="Record";
			}

			//alert('chek='+checkForMandatoryFields);
			if(!(checkForMandatoryFields()))
			{
				expandHeaderFrames(operation_mode);
				return false;
			}
		}

		if(operation_mode=="ModifyAddendum")
		{
			//if (trimString(parent.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerText) != "")  //[IN033869]
			if (trimString(parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerText) != "") //[IN033869]
			{
				//if( checkMaxLimitAddendum_new(removeHyperLink (parent.RecClinicalNotesRTEditorFrame.RTEditor0),4000) )  //[IN033869]
				if( checkMaxLimitAddendum_new(removeHyperLink (parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0),4000) )
					if(objButton.name=="sign"){
						var confirm_flag = confirm(getMessage("CONF_ADDENDUM",'CA'));

						if(confirm_flag==true)
						{
							assignSectionAddendum('', '', '', 'ModifyAddendum','','SignAddendum');
						}
					}else if(objButton.name=="record"){
						assignSectionAddendum('', '', '', 'ModifyAddendum','','RecordAddendum');
					}
				else
				{
					alert("CA-APP005 Addendum text should not exceed 4000 chars");
					return false;
				}
			}else{
				alert("CA-APP004 Addendum text should not be blank");
				return false;
			}

/* [IN:033677]			var confirm_flag = confirm(getMessage("CONF_ADDENDUM",'CA'));

			if(confirm_flag==true)
			{ */

/*
				var vAddEndumVal = parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.value;

				if(vAddEndumVal == null || vAddEndumVal == "")
				{
					alert("CA-APP004 Addendum text should not be blank");
//					disableButtons(false,operation_mode);
					return false;

				}
*/
//[IN032064]	Start
		/*	if (parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm != undefined)
				{
					if( checkMaxLimitAddendum(parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum,4000) )
						assignSectionAddendum('', '', '', 'ModifyAddendum','','RecordAddendum');
					else
					{
						alert("CA-APP005 Addendum text should not exceed 4000 chars");
	//					disableButtons(false,operation_mode);
						return false;
					}
				}*/
/* [IN:033677]				if (trimString(parent.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerText) != "")
				{
					if( checkMaxLimitAddendum_new(removeHyperLink (parent.RecClinicalNotesRTEditorFrame.RTEditor0),4000) )
						assignSectionAddendum('', '', '', 'ModifyAddendum','','RecordAddendum');
					else
					{
						alert("CA-APP005 Addendum text should not exceed 4000 chars");
						return false;
					}
				}else{
					alert("CA-APP004 Addendum text should not be blank");
					return false;
				}
//[IN032064]	End
			}  */
//			else
//				disableButtons(false,operation_mode);
		}
		else
		{
			var hdr_privilege_type				=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.privilege_type;

			if(objButton.name=="sign")
			{

				if(hdr_privilege_type.value=="2")  //uncommented by shaiju
				{
					//Added By Sridhar Reddy On 03/02/2011 to Fix IN:026290
					var returnArray = getForwardTo(operation_mode);
					//End

					if(returnArray==null )
						return false;

					parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.forwarded_clinician_id.value = returnArray[0];
					parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.action_comment.value = returnArray[1];
					parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.forwardToFac.value = returnArray[3];//IN038176

//					parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.forwarded_clinician_id.value = returnArray[0];
//					parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.action_comment.value			= returnArray[1];
				}

			}

			var confirm_flag = "";
			if(objButton.name=="sign")
			{
				if(Obj.value == "Sign" || Obj.value == "UpdateRecord")
//				if(objButton.value=='  SIGN  ')
				{
					if(hdr_privilege_type.value=="2")
						confirm_flag = confirm(getMessage("CONF_FWD",'CA'));
						//confirm_flag = confirm(getMessage("","CA"));
					else
						confirm_flag = confirm(getMessage("CONF_SIGN",'CA'));
						//confirm_flag = confirm(getMessage("","CA"));
				}
				else
					confirm_flag = confirm(getMessage("CONF_MODIFY",'CA'));
					//confirm_flag = confirm(getMessage("","CA"));


				if(confirm_flag==true)
				{
					if(Obj.value == "Sign" ||  Obj.value == "UpdateRecord")
//					if(objButton.value=='  SIGN  ')
					{
						var oledb_con_string = document.forms[0].oledb_con_string.value;

						if(parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.figer_print_auth_yn.value=="Y")
						{
							if(!verifyTheFinger(oledb_con_string))
							{
								return false;
							}
						}
					}
					//-------------------------

					if(operation_mode=="ModifySection")
					{
						//IN041284 Start.
						if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)
						{
							var inputs = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementsByTagName("IFRAME");
							var len=inputs.length;
							for(var i=0;i<len;i++){
								var input = inputs[i];
								var iframeObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById('"+input.id+"').contentWindow.document.body");
								var hiddenObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.forms[0]."+input.name);

								hiddenObj.value	= iframeObj.innerHTML;
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<p>&nbsp;</p>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<P>&nbsp;</P>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<address>&nbsp;</address>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<ADDRESS>&nbsp;</ADDRESS>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace('<PRE>', '<HTML><BODY><PRE>');
								hiddenObj.value	= (hiddenObj.value).replace('</PRE>', '</PRE></BODY></HTML>');
							}
						}
						//IN041284 End.
						if(!assignSectionDetails('','','','','ModifySection'))
							return;
					}
					else
					{
						if(!assignSectionDetails('','','','','Sign'))
							return;
					}
				}
				else
				{
					Obj.value = operation_mode;
				}
			}
			else
			{
				if(operation_mode=="ModifySection")
				{
					//IN041284 Start.
						if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)
						{
							var inputs = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementsByTagName("IFRAME");
							var len=inputs.length;
							for(var i=0;i<len;i++){
								var input = inputs[i];
								var iframeObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById('"+input.id+"').contentWindow.document.body");
								var hiddenObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.forms[0]."+input.name);

								hiddenObj.value	= iframeObj.innerHTML;
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<p>&nbsp;</p>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<P>&nbsp;</P>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<address>&nbsp;</address>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<ADDRESS>&nbsp;</ADDRESS>', 'g'), '');
								hiddenObj.value	= (hiddenObj.value).replace('<PRE>', '<HTML><BODY><PRE>');
								hiddenObj.value	= (hiddenObj.value).replace('</PRE>', '</PRE></BODY></HTML>');
							}
						}
						//IN041284 End.
					if(!assignSectionDetails(sec_hdg_code,sec_content_type,child_sec_hdg_code,child_sec_content_type,'','ModifySection'))
						return;
				}
				else
				{

					if(!assignSectionDetails('','','','','Record'))
						return;
				}
			}
		}

	}

}

function changeRowColor(obj,n,hdrCnt,checkBoxName)
{
	//IN037701 Starts
	var p_called_from = "";
	if(document.getElementById("p_called_from"))
		p_called_from = document.getElementById("p_called_from").value;
	//var rowCnt = document.getElementById("tb1").rows.length;
	if(undefined != document.getElementById("tb1") && undefined != document.getElementById("tb1").rows)//IN050580
	{
		rowCnt = document.getElementById("tb1").rows.length;
	}
	else
	{
		rowCnt = document.getElementById("tb1").rows.length;
	}
	//IN037701 Ends
	rowCnt = parseInt(rowCnt) - parseInt(hdrCnt);

	if(((obj.id).indexOf('tblrow_id'))!= -1)
		rowCnt = rowCnt - 1;//IN037701
	else
		hdrCnt = 1;

	//alert('rowCnt'+rowCnt);
	var prev=0;
	var i=0;
	var className="";
	for(i=hdrCnt;i<=rowCnt;i++)
	{
		/** Modified by kishore kumar N on 05/12/2008 for CRF 0387
			modified the classvalue to gridData/selectedRow.
		**/
		if ( i % 2 == 0 )
			classValue = "gridData" ;
		else
			classValue = "gridData" ;
		if(checkBoxName!="")
		{
			var isChecked = false;
			isChecked = eval("document.forms[0]."+checkBoxName+(i-1)+".checked");
			if(isChecked) classValue = 'selectedRow';
			else if ( i % 2 == 0 )
				classValue = "gridData" ;
			else if ( i % 2 == 1 )
				classValue = "gridData" ;
		}
		if(((obj.id).indexOf('tblrow_id'))!= -1)
		{
			if(hdrCnt==2)
			{
				if(isChecked) classValue = 'selectedRow';
				else if ( (i+1) % 2 == 0 )
					classValue = "gridData" ;
				else if ( (i+1) % 2 == 1 )
					classValue = "gridData" ;
				/** ends here**/
			}
		}
		for(j=0;j<n;j++)
		{
			if(!"CA_SPC" == p_called_from)//IN037701
			{
				if(document.getElementById("tb1").rows(i).id!='one' && document.getElementById("tb1").rows(i).id!='idddd')
				{
					if(document.getElementById("tb1").rows(i).cells(j).className != "POPULATED_SECTION")
						document.getElementById("tb1").rows(i).cells(j).className=classValue;
				}
			}//IN037701
		}
	}
	for(i=0;i<n;i++)
		obj.cells(i).className="selectedRow";
	//	obj.cells(i).className="ITEMSELECT";
	//obj.cells(0).style.color = 'WHITE';
}
function showErrorDocuments()
{
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"80" ;
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesViewErrorDocs.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:no;";
	var operation_mode	=	document.forms[0].operation_mode.value;
	var function_id		=	document.forms[0].function_id.value;
	var query_string	=	document.forms[0].query_string.value;
	action_url			+=	"?status=9&operation_mode="+operation_mode+"&function_id="+function_id;
	action_url			+=	"&"+query_string;
	retVal				=	window.showModalDialog(action_url,arguments,features);

}

//called from section template where a long text field is linked with a result type other then clinical note
function showLinkDocumentsFromTemplate(result_linked_rec_type,textarea_name)
{
	//alert("sec_result_linked_rec_type in showLinkDocs : "+result_linked_rec_type);
	var textArea	 = eval("document.forms[0]."+textarea_name);
	var encounter_id = "";
	var dob = "";
	var Sex = "";
	if(parent.parent.RecClinicalNotesHeaderFrame != null)
	{
		encounter_id	 = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		dob	 = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Dob.value;
		Sex	 = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value;
	}
	var patient_id	 = "";
	if(document.forms[0].patient_id != null)
		patient_id	 = document.forms[0].patient_id.value;
	if(encounter_id == "")
	{
		if(document.forms[0].encounter_id != null)
			encounter_id	 = document.forms[0].encounter_id.value;
	}
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"40" ; //30
	var dialogWidth		=	"60" ;//80
	var status			=	"no";
	var arguments		=	"" ;
	//var action_url		=	'../../eCA/jsp/RecClinicalNotesLinkDocsMain.jsp';
	//commented by rajan on 1/8/2005
	var action_url		=	'../../eCA/jsp/RecClinicalNotesLinkHistMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?result_linked_rec_type="+result_linked_rec_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&return_format=TEXT"+"&Dob="+dob+"&sex="+Sex;
	retVal				=	window.showModalDialog(action_url,arguments,features);
	if (retVal != null)
	{
		if (textArea.value != "")
		{
			textArea.value=textArea.value+"\n"+retVal;
		}else{
			textArea.value=retVal;
		}
		textArea.focus();
	}

}
//IN041284 Start.
//called from section template where a HTML text field is linked with a result type other then clinical note
function showLinkDocumentsHTMLFromTemplate(result_linked_rec_type,textarea_name)
{
	var textArea	 = eval("document.getElementById('IFRAME"+textarea_name+"').contentWindow.document.body");
	var textArea1	 = eval("document.getElementById('IFRAME"+textarea_name+"').contentWindow.document");
	var encounter_id = "";
	var dob = "";
	var Sex = "";
	if(parent.parent.RecClinicalNotesHeaderFrame != null)
	{
		encounter_id	 = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		dob	 = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Dob.value;
		Sex	 = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.Sex.value;
	}
	var patient_id	 = "";
	if(document.forms[0].patient_id != null)
		patient_id	 = document.forms[0].patient_id.value;
	if(encounter_id == "")
	{
		if(document.forms[0].encounter_id != null)
			encounter_id	 = document.forms[0].encounter_id.value;
	}
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"40" ;
	var dialogWidth		=	"60" ;
	var status			=	"no";
	var arguments		=	"" ;

	var action_url		=	'../../eCA/jsp/RecClinicalNotesLinkHistMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?result_linked_rec_type="+result_linked_rec_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&return_format=HTML"+"&Dob="+dob+"&sex="+Sex;
	retVal				=	window.showModalDialog(action_url,arguments,features);
  	if (retVal != null)
	{
		if (textArea.innerHTML != ""){
			textArea.innerHTML=textArea.innerHTML+"\n"+retVal;
			textArea.style.fontFamily = "verdana";
			textArea.style.fontSize = "10PT";
			textArea.style.lineHeight="15px";		//IN055628
		}else{
			textArea.innerHTML=retVal;
			textArea.style.fontFamily = "verdana";
			textArea.style.fontSize = "10PT";
			textArea.style.lineHeight="15px";		//IN055628
		}
		textArea.focus();
	}

}
//IN041284 End.
function compressHeaderFrames()
{
	var note_type_desc = "";
	parent.frameSetIdHeader.rows='6.5%,83.5%,10%'; //6.5%,86.5%,10%
	//parent.RecClinicalNotesSectionFrame.scrolling="no";
	if(parent.RecClinicalNotesHeaderFrame!=null)
	{
		if (parent.RecClinicalNotesHeaderFrame.document.forms[0].operation_mode.value == "")
		{
			var index = parent.RecClinicalNotesHeaderFrame.document.forms[0].note_type.selectedIndex;
			note_type_desc = parent.RecClinicalNotesHeaderFrame.document.forms[0].note_type.options[index].text;
		}else{
			note_type_desc = parent.RecClinicalNotesHeaderFrame.document.forms[0].note_type_desc.value;
		}



		//parent.RecClinicalNotesHeaderFrame.document.getElementById("headerTitle").innerText = parent.RecClinicalNotesHeaderFrame.document.forms[0].note_type_desc.value;
		parent.RecClinicalNotesHeaderFrame.document.getElementById("headerTitle").innerText = note_type_desc;
		parent.RecClinicalNotesHeaderFrame.document.getElementById("detailTable").style.display="none";
		parent.RecClinicalNotesHeaderFrame.document.getElementById("headerLineTable").style.display="inline";
	}
}
function expandSectionFrames()
{
	if (parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm != null )
	{
		var synchFlag  = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.synchFlag.value;

		//alert("synchFlag    "+synchFlag);
			//	if(parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm != null)
			//		synchFlag = parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.synchFlag.value;
		if(synchFlag == "0")
		{
			parent.frameSetIdSection.cols='30%,70%,0%';
			//parent.RecClinicalNotesSectionFrame.scrolling="auto";
			if(parent.RecClinicalNotesSecDetailsFrame.frameSetIDPainterEditor != null)
			{
				if(parent.RecClinicalNotesSecDetailsFrame.frameSetIDPainterEditor.cols == "50%,50%")
				{
					parent.RecClinicalNotesSecDetailsFrame.frameSetIDPainterEditor.cols = "100%,0%";
					if(parent.EditorTitleFrame != null)
						parent.EditorTitleFrame.document.RecClinicalNotesEditorTitleForm.button1.onclick();
				}
			}
			if(parent.RecClinicalNotesSectionFrame.document.getElementById("tb1") != null)
			{
				parent.RecClinicalNotesSectionFrame.document.getElementById("tb1").style.display="inline";
				parent.RecClinicalNotesSectionFrame.document.getElementById("tbl_section").style.display="inline";
				parent.RecClinicalNotesSectionFrame.document.getElementById("sectionLineTable").style.display="none";
				if(parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm!=null)
				{
//					parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.cols="75";    [INo32064]
				}
			}
		}
	}
}
function expandHeaderFrames(operation_mode)
{

	if (operation_mode == "Update" || operation_mode == "ModifySection" || operation_mode == "ModifyAddendum")
	{
		parent.frameSetIdHeader.rows='20%,70%,10%';
	}else{
		parent.frameSetIdHeader.rows='27%,63%,10%';

	}
	parent.RecClinicalNotesSectionFrame.scrolling="auto";
	parent.RecClinicalNotesHeaderFrame.document.getElementById("detailTable").style.display="inline";
	parent.RecClinicalNotesHeaderFrame.document.getElementById("headerLineTable").style.display="none";
}
function getRelativeURL(targetURL)
{
    var url = "";

	url = messageFrameReference.location.href;
    /*if(top.messageframe!=null)
        url = top.messageFrame.location.href;
    else
        url = top.content.messageFrame.location.href;*/

    var action_url = targetURL;
    if(url.indexOf("/servlet")!=-1) {
        action_url = ".."+targetURL;
    }
    else {
        action_url = "../.."+targetURL;
    }
    return action_url;
}

//fingure printing stuff
function verifyTheFinger(obj)
{
	var result;

	s1 = new String(document.forms[0].user_id.value);
	try
	{
	document.WebFp.DatabaseType=0
	document.WebFp.ConnectionType=1
	document.WebFp.ConnectionString = obj;
	//"Provider=OraOLEDB.Oracle.1;Password=medicom;Persist Security Info=True;User ID=medicom;Data Source=ghdm"
	document.WebFp.SecurityLevel=5
	document.WebFp.UserTableName="SM_APPL_USER"
	document.WebFp.FingerTableName="SM_APPL_USER_BIO"
	document.WebFp.AccountCodeField="APPL_USER_ID"
	document.WebFp.AccountCodeFieldType = 1
	document.WebFp.AccountCode = document.forms[0].user_id.value;
	//alert("Acc "+document.WebFp.AccountCode )
	result = document.WebFp.Verify();
	//result = document.WebFp.Enroll();
	//alert(result);
	if(result)
	{   alert(getMessage("VERIFY_OK","CA"));

		//alert("Enrollment Successful");
		//location.href = "regist.htm";
		return(true);
	}
	else
	{
		alert(document.WebFp.ErrorString);
		//location.href = "regist.htm";
		return(false);
	}
	}
	catch(e)
	{
	alert(e.message);
	return(false);
	}
}



//Functions for the file name RecClinicalNotesPTEditor.jsp-start


function callMeOnLoad()
{

	var image_linked_yn = parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.image_linked_yn.value;
	if(image_linked_yn == 'Y')
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.designMode = "On";
	else
		parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.designMode = "On";
	setTimeout("return setHTML()",300);


}

function setHTML()
{
	var image_linked_yn = parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.image_linked_yn.value;
	if(image_linked_yn == 'Y')
	{
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerHTML = document.getElementById("plainmsg").innerHTML;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.focus();
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand("formatBlock","", "Address");
	}
	else
	{
		parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.innerHTML = document.getElementById("plainmsg").innerHTML;
		parent.RecClinicalNotesSecDetailsFrame.RTEditor0.focus();
		parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("formatBlock","", "Address");
	}
}

//Functions for the file name RecClinicalNotesPTEditor.jsp-end


//Functions for the file name RecClinicalNotesLinkDocsDisplaySelect.jsp-start

var i=1;
function addToDiv()
{
	if(parent.RecClinicalNotesLinkDocsPreviewFrame.document.getElementById("data")!=null)
	{
		var prevDivHTML =parent.RecClinicalNotesLinkDocsPreviewFrame.document.getElementById("data").innerHTML;
		var finalDiv = 	parent.RecClinicalNotesLinkDocsFinalFrame.document.getElementById("finalDiv").innerHTML;
		finalDiv +=  prevDivHTML;
		parent.RecClinicalNotesLinkDocsFinalFrame.document.getElementById("finalDiv").innerHTML = finalDiv;
		parent.RecClinicalNotesLinkDocsAdditionFrame.RecClinicalNotesLinkForm.select.disabled = false;
		if(i>1)
		parent.RecClinicalNotesLinkDocsFinalFrame.document.getElementById("finalDiv").scrollIntoView(false);
		i++;
	}
	else
	 alert(getMessage("ENSURE_SELECTION","CA"));

}


//Functions for the file name RecClinicalNotesLinkDocsDisplaySelect.jsp-end


//Functions for the file name RecClinicalNotesLinkDocsDisplayApprove.jsp-start

	function clearFormApprove()
{
	parent.RecClinicalNotesLinkDocsFinalFrame.document.getElementById("finalDiv").innerHTML =  "";
	document.forms[0].select.disabled = true;
}
function returnDataApprove()
{
	var returnValue = parent.RecClinicalNotesLinkDocsFinalFrame.document.getElementById("finalDiv").innerHTML;


	if(returnValue=='')
		alert(getMessage("SELECT_PLEASE","CA"));

	else
	{

		parent.window.returnValue = returnValue;
		parent.window.close();
	}
}

//Functions for the file name RecClinicalNotesLinkDocsDisplayApprove.jsp-end

//Functions for the file name RecClinicalNotesSearchResult.jsp-start

function showNoteStatus(accession_num, tblrow_id)
{
	if("NA" != tblrow_id)//IN050580
		changeRowColor(tblrow_id,9,1,"");
	var retArray		=	new Array();
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"40" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesSearchMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url			+=	"?accession_num="+accession_num+"&operation_mode=ViewNoteStatus";
	retArray			=	window.showModalDialog(action_url,arguments,features);
}
//Functions for the file name RecClinicalNotesSearchResult.jsp-end


//Functions for the file name RecClinicalNotesStatusResult.jsp-start

function showNoteStatusDetails(accession_num, action_date_time, action_type, tblrow_id)
{

	changeRowColor(tblrow_id,4,1,"");
	parent.RecClinicalNotesStatusDetailsFrame.location.href = "../../eCA/jsp/RecClinicalNotesStatusDetails.jsp?accession_num="+accession_num+"&action_date_time="+action_date_time+"&action_type="+action_type;
}

//Functions for the file name RecClinicalNotesStatusResult.jsp-end


   function  assignValue(desc1,code,tabid,index)
   {

			var index_to_add=document.RecClinicalNotesTemplateForm.index.value;
			//alert("index_to_add==="+index_to_add);
		    //alert("desc1"+desc1+"code"	+code+"tabid"+tabid);


			var tableId ="MYGRID";
			var grid_component_ids = eval("document.RecClinicalNotesTemplateForm.grid_component_ids_" + tableId + ".value");
			var component_wise_details = grid_component_ids.split("~");
			var grid_name = component_wise_details[0];
			var calender_named = false;
			//alert("grid_name==="+grid_name );
			if(grid_name == tabid)
	       {

		    for(j=1;j<component_wise_details.length;j++)
		    {

				//alert("1111111111");
				 var component_coll = eval("document.all." + component_wise_details[j]);
				   calender_named = false;
				 if(component_wise_details[j].indexOf("list_box_component_of_") != -1)
					{
				   // for(k=0;k<component_coll.length;k++)
			     // {
					// component_coll[k].name
					//alert("222222222222"+component_coll[k].name);
   			        component_coll[index_to_add-1].value= desc1;
				 //}

			}
		    }
		   }

   }

//Function for the file name TemplateGridPreview.jsp-start
function addNewRow(tableId, index_to_add)
{


	var table_obj = eval("document.all." + tableId);

	if(table_obj != null)
	{
		var rowId = table_obj.insertRow(index_to_add+1);

		for(i=0;i<table_obj.rows[2].cells.length;i++)
		{
			rowId.insertCell();
			rowId.cells[rowId.cells.length-1].colSpan = table_obj.rows[2].cells[rowId.cells.length-1].colSpan;
			rowId.cells[rowId.cells.length-1].align = table_obj.rows[2].cells[rowId.cells.length-1].align;
			rowId.cells[rowId.cells.length-1].innerHTML = table_obj.rows[2].cells[rowId.cells.length-1].innerHTML;
			//rowId.cells(rowId.cells.length-1).innerHTML = trimToUnique(table_obj.rows(2).cells(rowId.cells.length-1).innerHTML);
			//			alert('aftr..'+rowId.cells(rowId.cells.length-1).innerHTML);

		}
	}
	var grid_component_ids = eval("document.RecClinicalNotesTemplateForm.grid_component_ids_" + tableId + ".value");
	//alert("grid_component_ids..."+grid_component_ids);
	//grid_component_ids=grid_component_ids+"~"+
	var first_component_name = "";
	//var first_min_max_component_name = "";
	var calender_named = false;
	var min_max_named = false;
	changeRowIds(tableId);
	var component_wise_details = grid_component_ids.split("~");
	var default_values = eval("document.RecClinicalNotesTemplateForm.default_values_list_" + tableId + ".value");
	var component_default_values = default_values.split("|");
	var grid_name = component_wise_details[0];

	if(grid_name == tableId)
	{

		for(j=1;j<component_wise_details.length;j++)
		{
			calender_named = false;

			var component_coll = eval("document.all." + component_wise_details[j]);
			//var component_min_max_coll = eval("document.getElementById("min_max")" + component_wise_details[j]);
			var name_index = 0;
			var array_index = 0;
			var array_index1 = 0;
			var array_index2 = 0;
			var def_value =  component_default_values[j-1];
			for(k=0;k<component_coll.length;k++)
			{

				if(k==0)
				{
					first_component_name = component_coll[k].name;

				}
				else if(first_component_name != null)
				{

				//	eval("document.getElementById("min_max")" +first_component_name).name="min_max"+first_component_name+ (9999 + name_index);

					component_coll[k].name = first_component_name+ (9999 + name_index);

					if(index_to_add == (k+1))
					{
						if(component_coll[k].type == "checkbox")
							component_coll[k].checked = (def_value=="true"?true:false);
						else
							component_coll[k].value = def_value;
					}

					if(component_wise_details[j].indexOf("list_box_component_of_") != -1 && array_index2 == 0)
					{

						//alert("first_component_name.."+first_component_name);
						//var lookup_button = eval("document.all." + first_component_name + "_searchButton" );
						//alert("lookup_button.."+lookup_button);
						//var list_box_hidden_field = eval("document.all." + first_component_name + "_desc" );

						//list_box_hidden_field.name = first_component_name+(9999 + name_index)+ "_desc";

						var index_name1 = (component_wise_details[j].substr("list_box_component_of_".length));
						//alert("index_name1.."+index_name1);

						var lookup_component = eval("document.getElementById("lookup_component_of_")" + index_name1);

							//alert("index_name1.."+lookup_component.length);
							if(lookup_component != null )
						 {
								//alert("first_component_name.."+first_component_name);

								for(var calender_counter = 0;calender_counter < lookup_component.length ; calender_counter++)
							  {

								if(lookup_component[calender_counter].value == first_component_name || lookup_component[calender_counter].value.indexOf("(") != -1 )
								{
									lookup_component[calender_counter].value = (first_component_name + "(" + array_index1++ + ")");
									 //alert("lookup.."+lookup_component[calender_counter].value);
								}
							}

						 }

							  array_index2++;

							}

					if(component_wise_details[j].indexOf("date_time_numeric_component_of_") != -1 )
					{
						//alert("date comp.."+component_wise_details[j]);
						var index_name = (component_wise_details[j].substr("date_time_numeric_component_of_".length));


						var calender_component_of_date_time_numeric = eval("document.getElementById("calender_component_of_")" + index_name);


						if(calender_component_of_date_time_numeric != null && !calender_named)
						{
							calender_named = true;

							for(var calender_counter = 0;calender_counter < calender_component_of_date_time_numeric.length ; calender_counter++)
							{
								if(calender_component_of_date_time_numeric[calender_counter].value == first_component_name || calender_component_of_date_time_numeric[calender_counter].value.indexOf("(") != -1 )
								{
									calender_component_of_date_time_numeric[calender_counter].value = (first_component_name + "(" + array_index++ + ")");
								}
							}
						}
					}

					name_index++;
				}
			}
		}
		callMeForStandardLinking_New(index_to_add); //IN052359
	}
}
// removeRow function is used to remove a row from the grid component. after removing a row all the remaining components have to be names appropriately so as to make all the components function normally. the same applies to the above function also.
function trimToUnique(innerText)
{
 var innerTextNew = innerText.substring(0,innerText.lastIndexOf(">"))+"1>";
 return innerTextNew;
}

function removeRow(tableId, index_to_delete)
{

	var no_of_checked = 0;
	var table_obj = eval("document.all." + tableId);
	table_obj.deleteRow(index_to_delete+1);
	changeRowIds(tableId);
	var grid_component_ids = eval("document.RecClinicalNotesTemplateForm.grid_component_ids_" + tableId + ".value");

	var first_component_name = "";
	var calender_named = false;
	var component_wise_details = grid_component_ids.split("~");
	var grid_name = component_wise_details[0];
	if(grid_name == tableId)
	{
		for(var j=1;j<component_wise_details.length;j++)
		{
			//alert("component ID=" + component_wise_details[j]);
			var component_coll = eval("document.all." + component_wise_details[j]);
			//alert(component_wise_details[j] + "=" + component_coll.length);
			var name_index = 0;
			var array_index = 0;
			var array_index1=0;
			var array_index2 = 0;
			for(var k=0;k<component_coll.length;k++)
			{
				if(k==0)
					first_component_name = component_coll[k].name;
				else if(first_component_name != null)
				{
					component_coll[k].name = first_component_name+(9999 + name_index) ;
					if(component_wise_details[j].indexOf("list_box_component_of_") != -1 && array_index2 == 0 )
					{
						// IN052359 Start.
						//var list_box_hidden_field = eval("document.all." + first_component_name + "_desc" );
						//list_box_hidden_field.name = first_component_name+(9999 + name_index)+ "_desc";

						if(eval("document.all." + first_component_name + "_desc" )!=undefined){
							var list_box_hidden_field = eval("document.all." + first_component_name + "_desc" );
							list_box_hidden_field.name = first_component_name+(9999 + name_index)+ "_desc";
						};
						//IN052359 End.
						var index_name1 = (component_wise_details[j].substr("list_box_component_of_".length));
						//alert("index_name1.."+index_name1);

						var lookup_component = eval("document.getElementById("lookup_component_of_")" + index_name1);


							if(lookup_component != null )
						 {
								for(var calender_counter = 0;calender_counter < lookup_component.length ; calender_counter++)
							   {

								if(lookup_component[calender_counter].value == first_component_name || lookup_component[calender_counter].value.indexOf("(") != -1 )
								{
									lookup_component[calender_counter].value = (first_component_name + "(" + array_index1++ + ")");

								}
							}

						 }

							  array_index2++;
						//alert(list_box_hidden_field.name);
					}
					//alert(component_wise_details[j]);
					if(component_wise_details[j].indexOf("date_time_numeric_component_of_") != -1 )
					{
						var index_name = (component_wise_details[j].substr("date_time_numeric_component_of_".length));
						//alert(index_name);
						var calender_component_of_date_time_numeric = eval("document.getElementById("calender_component_of_")" + index_name);
						//alert(calender_component_of_date_time_numeric.length );
						if(calender_component_of_date_time_numeric != null && !calender_named)
						{
							//alert(calender_component_of_date_time_numeric.length);
							calender_named = true;
							for(var calender_counter=0;calender_counter<calender_component_of_date_time_numeric.length;calender_counter++)
							{
								//if(calender_counter != 0)
								{
									//alert(calender_component_of_date_time_numeric[calender_counter].value);
									if(calender_component_of_date_time_numeric[calender_counter].value == first_component_name || calender_component_of_date_time_numeric[calender_counter].value.indexOf("(") != -1 )
									{
										calender_component_of_date_time_numeric[calender_counter].value = (first_component_name + "(" + array_index++ + ")");
									}
									//alert(calender_component_of_date_time_numeric[calender_counter].value);
								}
								//alert("=" + calender_component_of_date_time_numeric[calender_counter].value + "=");
							}
						}
					}
					name_index++;
				}
			}
		}
	}
}
function changeRowIds(tableId)
{
	var anchor_delete_this_row = eval("document.getElementById("anchor_delete_this_row")" + tableId);

	for(i=0;i<anchor_delete_this_row.length;i++)
	{
		anchor_delete_this_row[i].href="javaScript:removeRow('" + tableId + "'," + (i+1) + ");";
		if(i > 0)
			anchor_delete_this_row[i].style.display = 'inline';
	}
	var anchor_adding_row_below = eval("document.getElementById("anchor_adding_row_below")" + tableId);

	for(i=0;i<anchor_adding_row_below.length;i++)
		anchor_adding_row_below[i].href="javaScript:addNewRow('" + tableId + "'," + (i+2) + ");";
}

function showNEWXSL()
{
	var sec_hdg_code = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.sec_hdg_code;
	var child_sec_hdg_code = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.curr_child_sec_hdg_code;
	var action_url = "../../eCA/others/NEWXSL1.jsp";
	var param_list = "?sec_hdg_code=" + sec_hdg_code.value + "&child_sec_hdg_code=" + child_sec_hdg_code.value;
	var features		=	"dialogHeight:30; dialogWidth:80; dialogTop:80; scroll=no; status:no";
	window.showModalDialog(action_url + param_list, "",features);
}
function showProcessingTable(flag)
{
	var processingTable;
	var tb1;
	var Obj;

	if (parent.RecClinicalNotesSectionFrame != null)
		Obj = parent.RecClinicalNotesSectionFrame;
	else
		Obj = parent.parent.RecClinicalNotesSectionFrame;

	processingTable = Obj.document.getElementById("processingTable");
	tb1 = Obj.document.getElementById("tb1");

	if(processingTable != null && tb1 != null)
	{
		if(flag == true)
		{
			parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.synchFlag.value ="1";
			tb1.style.display = "none";
			processingTable.style.display = "inline";
		}
		else
		{
			parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.synchFlag.value ="0";
			processingTable.style.display = "none";
			tb1.style.display = "inline";
		}
	}
}

function compressSectionFramesForTemplate()
{
		parent.frameSetIdSection.cols='0%,*%,0%';
}

function showTemplateToolbar(sec_content_type)
{
	if (sec_content_type != "R")
		parent.RecClinicalNotesToolbarFrame.document.getElementById("link_doc").style.display = 'none';
	else
		parent.RecClinicalNotesToolbarFrame.document.getElementById("link_doc").style.display = 'inline';

	parent.RecClinicalNotesToolbarFrame.document.getElementById("Temp2").style.display = "inline";
	parent.RecClinicalNotesToolbarFrame.document.getElementById("Temp1").style.visible = "none";
}

function ResetTemplateToolbar()
{
	parent.RecClinicalNotesToolbarFrame.document.getElementById("Temp2").style.display = "inline";
	parent.RecClinicalNotesToolbarFrame.document.getElementById("Temp1").style.visible = "none";
	expandSectionFrames();
}


function settingsForMandatoryFieldsNotEntered()
{
	var mode = "sectionTemplate";
//	disableButtons(false,mode);

	//IN038493 Starts
	//setToolBarButtons(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc,false);
	if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm)
	{
		setToolBarButtons(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc,false);
	}
	else
	{
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc,false);
	}
	//IN038493 Ends
	//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc.disabled	=	true;
	showProcessingTable(false);

	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.synchFlag.value = "0";

//	if(parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm != null)
//		parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.synchFlag.value = "0";

	return;
}

function showSectionView()
{
//	var CurSec = parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.populated_section_tblrowID.value;
//	alert(CurSec);

	//var TempMode = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.template_rec_mode.value;

	if(!assignSectionDetails('','','','','','sectionView'))
		return;

//	document.getElementById("notes_view").style.color = 'WHITE';
//	changeRowColor(CurSec,1,0,"");

}

function setBlankFile()
{
	parent.RecClinicalNotesSecDetailsFrame.location.href = "../../eCommon/html/blank.html";
}

function recordTemplateDetailsFrmTempCtrl()
{
	if(recordTemplateDetails())
	{
		var patient_id			=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.target = "RecClinicalNotesSecTempControlFrame";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesTemplateCtrl.jsp?patient_id="+patient_id;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
		return true;
	}
	else
	{
		/*var bool;
		bool = confirm("APP-CA156 Mandatory Values are not entered,\nThis Operation will clear the current modification in this Template");
		if(!bool){
			setBlankFile();
			expandSectionFrames();
			messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
			*/
			return false;
		//}
	}
}

function callMeForGridCompStandardLinking(index_to_add)
{
	if(parent.parent.RecClinicalNotesHeaderFrame != null)
	{
		var patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		var encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		if(patient_id != "")
		{
			var grid_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names.value;

			var grid_std_values = "";
			var grid_std_component_information = "";
			var grid_name_temp = grid_names.split("|");

			if(grid_names != "")
				{
					for(var i=0;i<grid_name_temp.length;i++)
					{
						var grid_obj = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all." + grid_name_temp[0]);
						var final_rows_string = (grid_obj.rows.length-2);

						grid_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i]+".value");

						var split_grid_vals = grid_std_values.split("~")
						var final_str	="";
						for(var j = 0;j<split_grid_vals.length;j++)
							{
								var rowwise_split = split_grid_vals[j].split("|");
								var col_length = rowwise_split.length;
								var  gridwise_comp = eval("document.all."+rowwise_split[3]);
								var new_grid_name = gridwise_comp[1].name;
								var grid_length = gridwise_comp.length;

								if(final_str =="")
									final_str = rowwise_split[0]+"|"+rowwise_split[1]+"|"+rowwise_split[2]+"|"+rowwise_split[3];
								else
									final_str+= "~"+ rowwise_split[0]+"|"+rowwise_split[1]+"|"+rowwise_split[2]+"|"+rowwise_split[3];

							}

					}
				}
		}
		var action_url = '../../eCA/jsp/RecClinicalNotesStdCompLinking.jsp?std_component_information=' + escape(final_str) + "&patient_id=" + patient_id+"&encounter_id="+encounter_id+"&flag=addrow"+"&rowId="+grid_length;
		messageFrameReference.document.location = action_url;
	}

}

function sectionRefReset()
{
	var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	Obj.prev_sec_hdg_code.value			=	"";
	Obj.prev_child_sec_hdg_code.value	=	"";
	Obj.prev_image_linked_yn.value		=	"";
}

function setToolBarButtons(Obj,flag)
{

	if(Obj)
	{
		if(flag)
			Obj.style.display = "inline";
		else
			Obj.style.display = "none";
	}
}

function setSectionBasedButtons(content_type,chief_complaint_sec_yn,oper_mode)
{

	/*if(content_type=="F")
	{
	 parent.RecClinicalNotesToolbarFrame.document.forms[0].digitalNote.style.display = "inline" ;
	}
	else
	{
		parent.RecClinicalNotesToolbarFrame.document.forms[0].digitalNote.style.display = "none" ;
	} */
	if(content_type == "F" || content_type == "R")
	{
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].canned_text,true);

		if (content_type  == "R")
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc,true);
		else
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc,false);

		if(chief_complaint_sec_yn == "Y")
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].chief_complaints,true);
		else
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].chief_complaints,false);
	}
	else
	{
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].chief_complaints,false);
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].canned_text,false);
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].link_doc,false);
	}


	if(oper_mode == "ModifySection"){
		if(parent.RecClinicalNotesToolbarFrame.document.forms[0] && parent.RecClinicalNotesToolbarFrame.document.forms[0].record)
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);
		if(parent.RecClinicalNotesToolbarFrame.document.forms[0] && parent.RecClinicalNotesToolbarFrame.document.forms[0].sign)
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,true);
	}

	if(oper_mode == "ModifyAddendum")
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,true);

	setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].btn_Print,true);
}

function setButtonsforOperations(operation_mode,flag,callingFrom,result_link_yn,content_type)
{
   //Below if condition are added by Archana Dhal on 4/28/2010 for IN020883.
   if(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm != null)
	{
	   if (content_type == "F" || content_type == "R")
	   {
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].canned_text,true);
	   }
	   else
	   {
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].canned_text,false);
	   }
		if(operation_mode!="Preview")
		{
		if(operation_mode != "ModifyAddendum" &&  operation_mode != "ModifySection" &&  operation_mode != "sectionView" &&  operation_mode != "Record" &&  operation_mode != "Sign" )
		{
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.btn_Print,true);

			if (callingFrom == "fromRoutine"){
				setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView,false);
				setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.btn_Print,false);
			}else{

				if (parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView != null)
				{
					setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView,true);
				}
			}
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record,false);
			//IN035950 St
			//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = false;

				if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame)
				{
					if(null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView"))
						top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = false;
				}
				else
				{
					if(null!=parent.RecClinicalNotesToolbarFrame.document.getElementById("notesView"))
						parent.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = false;
				}

			//IN035950 End
			//parent.frameSetIdHeader.rows='6.5%,86.5%,10%';
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").style.display = "inline";
			//parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='<b>Click on "Notes View" for "Record" & "SIGN" buttons</b>';

			var transcription_yn = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.transcription_yn.value;
			var function_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.function_id.value;

			//alert('transcription_yn...'+transcription_yn);
			if((transcription_yn=='Y')&&(function_id!='TASK_LIST'))
			{
				setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.req_transcription,true);
			}
			else
			{
				setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.req_transcription,false);
			}
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='<b>'+getLabel("eCA.ClickForRecAndSign.label","CA")+'</b>';
			//}


		}else if(operation_mode == "ModifyAddendum")
		{
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign,true);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc,false);
			//setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView,false);
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='';
		}else if(operation_mode == "sectionView")
		{
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign,true);
	//		parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled = false;
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record,true);
	//		parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record.disabled = false;
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView,false);
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='';
		}else if (operation_mode == "ModifySection")
		{
			if(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm && parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record)
				setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record,false);
		}else{
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign,true);
		//	parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled = false;
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record,false);
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView,false);
			parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='';
		   //IN035950 Strt	//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = true;
		   if(operation_mode != ""){
				if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame)
				{
				top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = true;
				}
				else
				{
					parent.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = true;
				}
			}
			//IN035950 End
			if(operation_mode == "Record")
			{
				parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled = true;
			}if(operation_mode == "Sign")
			{
				parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled = true;
				parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record.disabled = true;
			}
		}
	}else {

		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign,true);
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.record,true);
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.notesView,false);
		parent.RecClinicalNotesToolbarFrame.document.getElementById("display_view").innerHTML ='';
	}

	if (result_link_yn == "Y" && operation_mode != "ModifyAddendum")
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc,true);
	else
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.link_doc,false);


/*	if (doc_linked_note_yn == "Y")
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.fileupload_btn,true);
	else
		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.fileupload_btn,false);	*/

		setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.btn_Print,true);
 }
}



function callConditionLookup()
{

	var note_type		= document.forms[0].sel_note_type.value;
	//var note_type		= document.forms[0].note_type.value;

	var loggedUser		= document.forms[0].loggedUser.value;
	var search_val		= document.forms[0].performed_by_phy_name.value;
	var retVal			=  ""; //new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var sql= "";
	var title			= getLabel('Common.Performed.label','COMMON')+getLabel('Common.by.label','COMMON');
	var locale =document.forms[0].locale.value;
//	var sql="select practitioner_id phys_prov_id, replace(short_name,``,``) phys_prov_name from am_practitioner where EFF_STATUS=`E` and practitioner_id in (select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = `"+note_type+ "` and b.privilege_type in (`2`,`3`,`4`) and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id)  ";

/*	if (target == "PR")
	{
		sql="select practitioner_id phys_prov_id, replace(short_name,``,``) phys_prov_name from am_practitioner_lang_vw where EFF_STATUS=`E` and language_id =`"+locale+"` and practitioner_id in ( select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = `"+note_type+ "` and b.privilege_type in (`2`,`3`,`4`) and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id and a.appl_user_id NOT IN (`"+loggedUser+"`))";
	}else{
		sql="select practitioner_id phys_prov_id, replace(short_name,``,``) phys_prov_name from am_practitioner_lang_vw where EFF_STATUS=`E` and language_id =`"+locale+"` and practitioner_id in ( select a.func_role_id from sm_appl_user a, ca_note_type_for_resp b, sm_resp_for_user c where b.note_type = `"+note_type+ "` and b.privilege_type in (`2`,`3`,`4`) and c.resp_id = b.resp_id and a.appl_user_id = c.appl_user_id)";
	}
	alert(sql); */
	search_code="PRACTITIONER_ID";
	search_desc="SHORT_NAME";
	retVal=window.showModalDialog("../../eCA/jsp/RecClinicalNotesPerformedByMain.jsp?title="+encodeURIComponent(title,"UTF-8")+"&note_type="+note_type+"&dispDescFirst=dispDescFirst&search_val="+search_val,arguments,features);

	if (retVal != null )
	{
		document.forms[0].performed_by_phy_name.value=unescape(retVal[1]);
		document.forms[0].performing_phy_name.value=unescape(retVal[1]);
		document.forms[0].performed_by_id.value=unescape(retVal[0]);
	}else{
		document.forms[0].performed_by_phy_name.value="";
		document.forms[0].performing_phy_name.value="";
		document.forms[0].performed_by_id.value="";
	}
}

function callConditionLookupServ(serv_spec)
{
	var facility_id		= document.forms[0].sel_facility_id.value;
	var note_type		= document.forms[0].sel_note_type.value;
	var ser_spc_yn		= document.forms[0].serv_facl_spec_yn.value;
	var operation_mode	= document.forms[0].operation_mode.value;
	var serv_disp	= document.forms[0].serv_disp.value;

	if(operation_mode == "Update" || operation_mode == "ModifySection" || operation_mode == "ModifyAddendum" )
		 note_type		= document.forms[0].note_type.value;
	else
		 note_type		= document.forms[0].sel_note_type.value;

	var retVal			=  ""; //new String();
	var dialogTop		= "60";
	var dialogHeight	= "30" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.Med/AncService.label","COMMON");

	retVal=window.showModalDialog("../../eCA/jsp/RecClinicalNotesMedServiceMain.jsp?title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&ser_spc_yn="+ser_spc_yn+"&note_type="+note_type+"&search_val="+serv_disp,arguments,features);

	if (retVal != null )
	{
		document.forms[0].serv_disp.value=unescape(retVal[1]);
		document.forms[0].service_code.value=unescape(retVal[0]);
	}else{
		document.forms[0].serv_disp.value="";
		document.forms[0].service_code.value="";
	}
}
function PreviewRecordClinicalNotes(obj)
{
	//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.RecClinicalNotesToolbarForm.sign.disabled	=	booleanFlag;

	var mode = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode.value
	//top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = true;
	//IN035950 Start
	if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame)
	{
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = true;
	}
	else
	{
		parent.RecClinicalNotesToolbarFrame.document.getElementById("notesView").disabled = true;
	}
	//IN035950 End
	//IN041284 Start.
	if(null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame)
	{
		var inputs = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementsByTagName("IFRAME");
		var len=inputs.length;
		for(var i=0;i<len;i++){
			var input = inputs[i];
			var iframeObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById('"+input.id+"').contentWindow.document.body");
			var hiddenObj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.forms[0]."+input.name);

			hiddenObj.value	= iframeObj.innerHTML;
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<p>&nbsp;</p>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<P>&nbsp;</P>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<address>&nbsp;</address>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace(new RegExp('<ADDRESS>&nbsp;</ADDRESS>', 'g'), '');
			hiddenObj.value	= (hiddenObj.value).replace('<PRE>', '<HTML><BODY><PRE>');
			hiddenObj.value	= (hiddenObj.value).replace('</PRE>', '</PRE></BODY></HTML>');
		}
	}
	//IN041284 End.
	showNotes('','','');
}

function fnDisplaySplty(Obj)
{
	var filter = Obj.value;
	if (filter != null && filter != "" && filter == "S")
	{
		document.getElementById('td_splty').colspan='1';
		document.getElementById('td_lbl_splty').style.display='inline';
		document.RecClinicalNotesHeaderForm.speciality_list.style.display="inline";
		//document.RecClinicalNotesHeaderForm.img_mandatory.style.display="inline";
	}else {
		document.getElementById('td_lbl_splty').style.display='none';
		document.RecClinicalNotesHeaderForm.speciality_list.style.display="none";
		//document.RecClinicalNotesHeaderForm.img_mandatory.style.display="none";
		document.getElementById('td_splty').colspan='2';
	}
	document.RecClinicalNotesHeaderForm.speciality_list.value = "";
	document.RecClinicalNotesHeaderForm.note_group.disabled = false;
	document.RecClinicalNotesHeaderForm.note_group.value = "";
	document.RecClinicalNotesHeaderForm.serv_disp.value = "";
	document.RecClinicalNotesHeaderForm.performed_by_phy_name.value = "";
	document.RecClinicalNotesHeaderForm.performed_by_id.value = "";
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.location.href='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecClinicalNotesFrame.EditorTitleFrame.location.href='../../eCommon/html/blank.html';

}

function populateNoteType(obj)
{
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.location.href='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.location.href='../../eCommon/html/blank.html';
	top.content.workAreaFrame.RecClinicalNotesFrame.EditorTitleFrame.location.href='../../eCommon/html/blank.html';
	var formObj = document.RecClinicalNotesHeaderForm;

	/*if (obj.value == "S" && formObj.speciality_list.value == "")
	{
		clearNoteTypeValues('document','note_type');
		clearNoteTypeValues('document','note_group');
		alert(getMessage("SELECT_SPECIALITY",'CA'));
		return;
	}	*/
	var localeName=formObj.locale.value;
	var c_note_type=formObj.c_note_type.value;
	var appl_task_id=formObj.appl_task_id.value;
	var patient_class=formObj.patient_class.value;
	var called_from=formObj.called_from.value;
	var note_group_req=formObj.note_group_req.value;
	var p_event_class_widget		= formObj.p_event_class_widget.value;//IN037701
	var validate = "";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += obj.name+"=\""+ obj.value +"\" " ;
	xmlStr += "c_note_type=\""+ c_note_type +"\" " ;
	xmlStr += "appl_task_id=\""+ appl_task_id +"\" " ;
	xmlStr += "patient_class=\""+ patient_class +"\" " ;
	xmlStr += "called_from=\""+ called_from +"\" " ;
	xmlStr += "note_group_req=\""+ note_group_req +"\" " ;
	xmlStr += "p_event_class_widget=\""+ p_event_class_widget +"\" " ;//IN037701
	if (obj.value == "S")
	{
		var speciality_list = formObj.speciality_list.value;
		xmlStr += "speciality_list=\""+ speciality_list +"\" " ;
	}
	validate = "note_list";
	 xmlStr +=" /></root>" ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	flag='';
	xmlHttp.open( "POST", "RecClinicalNotesValidate.jsp?validate="+validate+"&flag="+flag+"&localeName="+localeName, false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}

function addNoteTypeList(code,value,selected) {
	var element = document.createElement('OPTION') ;
	var c_note_type=document.RecClinicalNotesHeaderForm.c_note_type.value;

	element.value =  code ;
	element.text = value ;

	if (c_note_type == element.value)
	{
		element.selected = selected;
	}
	document.RecClinicalNotesHeaderForm.note_type.add(element);
}
function addNoteGroupList(code,value,selected) {
	var element = document.createElement('OPTION') ;
//	var c_note_group=document.RecClinicalNotesHeaderForm.c_note_group.value;

	element.value =  code ;
	element.text = value ;

	if(selected=="true")
	{
		element.selected = selected;
	}
	/*if (c_note_group == element.value)
	{
		element.selected = selected;
	} */

	document.RecClinicalNotesHeaderForm.note_group.add(element);
	if(selected=="true"){
		document.RecClinicalNotesHeaderForm.note_group.disabled = true;
	}

}
function clearNoteTypeValues(docObj,compName)
{
	var len = eval(docObj+".RecClinicalNotesHeaderForm."+compName+".options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".RecClinicalNotesHeaderForm."+compName+".remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.defaultSelect.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = "    ---------- "+tp+"----------    " ;
	opt.value = "" ;
	eval(docObj+".RecClinicalNotesHeaderForm."+compName+".add(opt)") ;
}
// Added By Sridhar Reddy V on 14/08/2008
// Modified By Sridhar Reddy On 10/07/2009 to fix incident IN011840.
//called from section template to check Maxlength of a long text field.
function chkMaxLenForLongTest(textarea_name,prompt,maxLen)
{
	if (maxLen == undefined || maxLen == null || maxLen == "")
	{
		maxLen = 10000;
	}
	if (textarea_name == "")
	{
	}
	var textArea	 = eval("document.forms[0]."+textarea_name);
	var val	 = textArea.value;
	var valLength	 = val.length;
	if (parseInt(valLength)  > maxLen)
	{
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$",prompt);
		msg = msg.replace("#",maxLen);
		alert(msg);
		textArea.focus();
		return false;
	}
}
//End  chkMaxLenForLongTest Added By Sridhar Reddy V
//IN041284 Start.
//called from section template to check Maxlength of a long text field.
function chkMaxLenForHTMLLongTest(htmlarea_name,prompt,maxLen)
{
	if (maxLen == undefined || maxLen == null || maxLen == "")
	{
		maxLen = 10000;
	}
	if (htmlarea_name == "")
	{
	}
	var htmlArea	 = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.getElementById('"+htmlarea_name+"').contentWindow.document.body");
	var val	 = htmlArea.innerHTML;
	var valLength	 = val.length;
	if (parseInt(valLength)  > maxLen)
	{
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$",prompt);
		msg = msg.replace("#",maxLen);
		alert(msg);
		htmlArea.focus();
		return false;
	}
}
//End  chkMaxLenForHTMLLongTest Added By Sridhar Reddy V
//IN041284 End.
//Start  callProcessControlDialog Added By Sridhar Reddy V
function callProcessControlDialog(){
	var dialogHeight	=	"10" ;
	var dialogWidth		=	"20" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var returnArray			=	window.showModalDialog(action_url,arguments,features);
}
function callProcessControlDialog1(){
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesProcessControlMsg.jsp';
	var features		=	"modal =yes,height=15,width=300,top=200,left=400,resizable=no,status=no,location=no,scrollbars=no";
	window.open(action_url,arguments,features);

}
//End  callProcessControlDialog Added By Sridhar Reddy V
async function callPrintOnSign(print_notes_yn,accession_num,note_type,patient_id,facility_id,encounter_id,event_date_time,patient_class,performed_by_id,episode_type,note_type_desc)
{
	var println_yn = false;
	var title =note_type_desc;

	if(print_notes_yn=="D")
	{
		println_yn =true;

	}
	else if(print_notes_yn=="C")
	{
		var msg = getMessage("PRINT_CONFIRM","COMMON");
		msg = msg.replace("#",getLabel("Common.notes.label","COMMON"));
		println_yn = confirm(msg);

		//println_yn = confirm("Do You Want to print the notes...?");
	}
	else
	{
		println_yn= false;
	}
	if(println_yn)
	{
			/*var header = "";
			header = "<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >";
			header +="<tr><td align='left' width='5%' rowspan='2'><img valign='top' src='../../eCommon/images/Entilogo.jpg' border='0'></td><td  align=center><h3>"+facility_id+"</h3></td></tr>";
			header +="<tr><td align=center><h3>"+facility_id+"</h3></td></tr>";
			//header +="<tr><td align=center><h3>"+document.forms[0].facility_name.value+"</h3></td></tr>";
			header +="<tr><td>&nbsp;</td><td align=center><h4>"+title+"</h4></td></tr></table>";
			header +="<br>"; */
		//data[0] = header;
		var retVal		= 	new String();
		var dialogTop	=	"60";
		var dialogHeight=	"34" ;
		var dialogWidth	=	"50" ;
		var features	=	"dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=yes" ;

		//
		var arguments = "";
		retVal = await window.showModalDialog("../../eCA/jsp/RecClinicalNotesPrint.jsp?accession_num="+accession_num+"&title="+encodeURIComponent(title,"UTF-8")+"&facility_id="+facility_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&performed_by_id="+performed_by_id+"&event_title_desc="+title+"&patient_class="+patient_class+"&note_type_desc="+title+"&event_date_time="+event_date_time+"&performed_date="+event_date_time+"&note_status="+"&note_type="+note_type+"&episode_type="+episode_type+"&called_from=printOnSign",arguments,features);
	}
}

//Added by Sridhar Reddy on 26/12/2008 for BSP30453-CRF-0064-0069 changes
function loadFirstSectionDetails(tblrow_id, sec_hdg_code,child_sec_hdg_code,sec_hdg_desc,child_sec_hdg_desc,currr_image_linked_yn,result_link_yn,operation_mode,content_type,chief_complaint_sec_yn,result_link_type,main_section_type,expandCounter,subsecctr,selection_type)
{

	var editor_title = "";
	if(child_sec_hdg_desc =="")
		editor_title	=	sec_hdg_desc
	else
		editor_title	= child_sec_hdg_desc +" \ "+ sec_hdg_desc

	 parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.selection_type.value = selection_type ;


	assignSectionDetails(sec_hdg_code,child_sec_hdg_code,editor_title,currr_image_linked_yn,operation_mode,result_link_yn,result_link_type,content_type)
	expandHeaderFrames(operation_mode)
//	parent.frameSetIdHeader.rows='6.5%,86.5%,10%';
//	compressHeaderFrames();
/*

	var content_temp = content_type;

	if(result_link_type != "")
		content_temp = "R";

	var patient_id						="";
	var encounter_id					="";
	var episode_type					="";
	var accession_num					="";
	var patient_class					="";
	var module_id					="";

	var section_image_content			="";
	var section_content					="";
	var template_mode					="";
	var prev_image_linked_yn			="";
	var image_edited_yn					="";
	var section_image_content			="";
	var prev_sec_hdg_code				="";
	var prev_child_sec_hdg_code			="";
	var prev_image_linked_yn	 		="";
	var note_type			 			="";
	var note_type_desc			 		="";
	var note_status			 			="";
	var event_date_time			 		="";
	var performing_phy_name			 	="";
	var image_hidden_name				="";
	var image_hidden_obj				="";
	var appl_task_id					="";
	var editor_title					="";

	if(child_sec_hdg_desc =="")
		editor_title	=	sec_hdg_desc
	else
		editor_title	= child_sec_hdg_desc +" \ "+ sec_hdg_desc

parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.selection_type.value = selection_type ;

var section_content					= parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.section_content;

var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;

var sec_obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm;

//expandSectionFrames();
patient_id					=		Obj.patient_id.value;
prev_sec_hdg_code			=		Obj.prev_sec_hdg_code.value;
prev_child_sec_hdg_code		=		Obj.prev_child_sec_hdg_code.value;
prev_image_linked_yn		=		Obj.prev_image_linked_yn.value;
note_type					=		Obj.note_type.value;
note_type_desc				=		Obj.note_type_desc.value;
performing_phy_name			=		Obj.performing_phy_name.value;
event_date_time				=		Obj.event_date_time.value;
episode_type				=		Obj.episode_type.value;
accession_num				=		Obj.accession_num.value;
patient_class				=		Obj.patient_class.value;
encounter_id				=		Obj.encounter_id.value;
Sex							=		Obj.Sex.value;
Dob							=		Obj.Dob.value;
module_id					=		Obj.module_id.value;
appl_task_id				=		Obj.appl_task_id.value;
selection_type				=		Obj.selection_type.value;


if(operation_mode!="Preview")
{
	Obj.prev_sec_hdg_code.value			=		curr_sec_hdg_code;
	Obj.prev_child_sec_hdg_code.value	=		curr_child_sec_hdg_code;
	Obj.prev_image_linked_yn.value		=		currr_image_linked_yn;
	Obj.prev_sec_result_link_type.value	=		result_link_type;
	Obj.prev_sec_type.value				=		content_type;
}


var url = "";
var pars = "";
var no_of_rows = "";
no_of_rows = Obj.no_of_rows.value;

		url = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
		pars ='curr_sec_hdg_code='+sec_hdg_code+'&curr_child_sec_hdg_code='+child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&editor_title='+editor_title+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&no_of_rows='+no_of_rows+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob+'&module_id='+module_id+'&appl_task_id='+appl_task_id+'&selection_type='+selection_type;


		parent.RecClinicalNotesSecControlFrame.document.forms[0].target =	parent.RecClinicalNotesSecControlFrame.name;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].action	=	url+pars;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].method	=	'post';
		parent.RecClinicalNotesSecControlFrame.document.forms[0].submit();


	if(operation_mode != "Preview")
	{
		if(result_link_yn == "Y")
			setTimeout("showLinkDocuments('"+sec_hdg_code+"','"+content_type+"', '"+child_sec_hdg_code+"', '"+content_type+"','"+result_link_type+"','"+currr_image_linked_yn+"')",1000);
	}

	setTimeout("setSectionBasedButtons('"+content_temp+"','"+chief_complaint_sec_yn+"','"+operation_mode+"')",1000);;
	if(operation_mode!="Preview")
	{
		setTimeout("setButtonsforOperations('"+operation_mode+"',true)",1000);
	}
*/
}
//end

function restrictBackSpace(obj)
{
	whichCode = event.keyCode;
    if (whichCode == 8)
	{
		event.cancelBubble = true;
		event.returnValue = false;
		return false;
	}
}
//[IN032064] Start
function checkMaxLimitAddendum_new(obj,maxSize)
{
	obj = obj.replace("</ADDRESS>","");
	var valLength	 = obj.length;
	if (parseInt(valLength)  >= parseInt(maxSize))
	{
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$",'Addendum');
		msg = msg.replace("#",maxSize);
		alert(msg);
		//obj.focus();
		setEditorFocus();
		return false;
	}
	return true;
}
//[IN032064] End
//[IN030465] Start
//IN044085 Start.
//function sendEmailNF(accession_num,patient_id)
function sendEmailNF(accession_num,patient_id,report_id)
//IN044085 End.
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += "accession_num=\""+ accession_num +"\" " ;
	xmlStr += "patient_id=\""+ patient_id +"\" " ;
	xmlStr += "module_id=\"CA\" " ;
	xmlStr += "report_id=\""+ report_id +"\" " ;
	xmlStr += "mailToType=\"R\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "EMailNotifiableIntermediate.jsp", false ) ;
	xmlHttp.send(xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
//[IN030465] End.


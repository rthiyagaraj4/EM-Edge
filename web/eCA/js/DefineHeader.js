function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/DefineHeaderAddModify.jsp?mode=insert';
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeQueryCriteria.jsp';
}


function apply()
{
	/*var fields = new Array (
							f_query_add_mod.document.forms[0].note_type,
							f_query_add_mod.document.forms[0].note_type_desc,
							f_query_add_mod.document.forms[0].note_group_id,
							f_query_add_mod.document.forms[0].event_class,
							f_query_add_mod.document.forms[0].publish_level,
							f_query_add_mod.document.forms[0].ammendment_type
							);

	var names = new Array (
							f_query_add_mod.getLabel("Common.code.label",'common'),
							f_query_add_mod.getLabel("Common.description.label",'common'),
							f_query_add_mod.getLabel("eCA.NoteGroup.label",'CA'),
							f_query_add_mod.getLabel("Common.Class.label",'common'),
							f_query_add_mod.getLabel("eCA.PublishLevel.label",'CA'),
							f_query_add_mod.getLabel("eCA.AmendmentType.label",'CA')
							);
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{			
		var license_rights		=	f_query_add_mod.document.forms[0].license_rights.value;
		var created_notes		=	f_query_add_mod.document.forms[0].created_notes.value;
		var created_tot_notes	=   f_query_add_mod.document.forms[0].created_tot_notes.value;
		var event_class			=	f_query_add_mod.document.forms[0].event_class;
		var mode				=	f_query_add_mod.document.forms[0].mode.value;

		if(license_rights=="BASIC")
		{
			if(created_notes.indexOf(event_class.value)!=-1 && (mode=="insert")){
				var msg = getMessage("MORE_THAN_ONE_NOT_ALLOWED","CA");
				event_class.focus();
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
			if(eval(created_tot_notes)>=4 )
				{
					var msg = getMessage("MORE_THAN_FOUR_NOT_ALLOWED","CA");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
			}
		}
		
		if(license_rights=="MINI")
		{
			var created_ip_notes=f_query_add_mod.document.forms[0].created_ip_notes.value;
			var created_op_notes=f_query_add_mod.document.forms[0].created_op_notes.value;
			var ip_checked=f_query_add_mod.document.forms[0].inpatient_yn;
			var op_checked=f_query_add_mod.document.forms[0].outpatient_yn;
			var status_check=f_query_add_mod.document.forms[0].status_check.value;

			if(mode=="insert")
			{
				if(eval(created_ip_notes)>=2 && ip_checked.checked)
				{
					var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
				else if(eval(created_op_notes)>=2  && op_checked.checked)
				{
					var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
				else if(eval(created_notes)>=4 )
				{
					var msg = getMessage("MORE_THAN_FOUR_NOT_ALLOWED","CA");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
			}
			else if(mode=="update")
			{
				if(((status_check=='I' || status_check=='N') && op_checked.checked) && eval(created_op_notes)>=2)
				{
					var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
				else if(((status_check=='O' || status_check=='N') && ip_checked.checked) && eval(created_ip_notes)>=2)
				{
					var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
			}

			if(mode != null)
		{
			if(mode.value=='update')
			{
				f_query_add_mod.document.forms[0].note_groupid_update.value= f_query_add_mod.document.forms[0].note_group_id.value

			}
		}
			/*if(eval(created_notes)>=2 && (mode=="insert")){
				var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED");
				
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
		}
		var fields1 = new Array (f_query_add_mod.document.forms[0].note_type);
		var names1 = new Array (f_query_add_mod.getLabel("Common.code.label",'common'));
		
		if(!(f_query_add_mod.document.forms[0].inpatient_yn.checked))
			f_query_add_mod.document.forms[0].inpatient_yn.value = 'N' ;
		else
			f_query_add_mod.document.forms[0].inpatient_yn.value = 'Y' ;


		if(!(f_query_add_mod.document.forms[0].outpatient_yn.checked))
			f_query_add_mod.document.forms[0].outpatient_yn.value = 'N' ;
		else
			f_query_add_mod.document.forms[0].outpatient_yn.value = 'Y' ;


		if(!(f_query_add_mod.document.forms[0].serv_facl_spec_yn.checked))
			f_query_add_mod.document.forms[0].serv_facl_spec_yn.value = 'N' ;
		else
			f_query_add_mod.document.forms[0].serv_facl_spec_yn.value = 'Y' ;

		if(!(f_query_add_mod.document.forms[0].doc_link_note.checked))
			f_query_add_mod.document.forms[0].doc_link_note.value = 'N' ;
		else
			f_query_add_mod.document.forms[0].doc_link_note.value = 'Y' ;

		if(!(f_query_add_mod.document.forms[0].serv_facl_spec_yn.checked))
			f_query_add_mod.document.forms[0].serv_facl_spec_yn.value = 'D' ;
		
		if(f_query_add_mod.document.forms[0].DC.checked==true)
		{
			f_query_add_mod.document.forms[0].DC.value = 'Y' ;
		}
		else
		{
			f_query_add_mod.document.forms[0].DC.value = 'N' ;
		}
				if(f_query_add_mod.document.forms[0].EM.checked==true)
		{
			f_query_add_mod.document.forms[0].EM.value = 'Y' ;
		}
		else
		{
			f_query_add_mod.document.forms[0].EM.value = 'N' ;
		}
		

		if(f_query_add_mod.document.forms[0].patient.checked==true)
		{
			
			f_query_add_mod.document.forms[0].patient.value = 'Y' ;
		}
		else
		{
			
			f_query_add_mod.document.forms[0].patient.value = 'N' ;
		}


		if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
		{
			f_query_add_mod.document.forms[0].submit();		

		}
		if(document.NoteHeader_form.eff_status.checked == true)
			document.NoteHeader_form.eff_status.value = "E";
		else
			document.NoteHeader_form.eff_status.value = "D";
	}*/

}

// Added on 12/11/2002 -- To delete an record	
function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"){
			//commontoolbarFrame.location.reload();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
			}
			else{
				if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
				{
					f_query_add_mod.document.NoteType_form.mode.value='delete';
					f_query_add_mod.document.NoteType_form.submit();     
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
} 	


function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	       f_query_add_mod.location.reload();
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	
if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
}

		

function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}



function setFocusOnFirst()
	{
	  if(document.forms[0].mode.value == "insert")
		 document.forms[0].note_type.focus();

	}



function doClose()
{
	window.close();
}

function openNoteHeaderEditor(obj)
{
	if(obj.value != '') 
	{
		var header_type = document.NoteHeader_form.header_type.value;
		var mode = document.NoteHeader_form.mode.value;
		var header_id = document.NoteHeader_form.header_id.value;
		var long_desc = document.NoteHeader_form.long_desc.value;
		var short_desc = document.NoteHeader_form.short_desc.value;
		var eff_status = document.NoteHeader_form.eff_status.value;

		var htmlText = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form action='../../eCA/jsp/DefineHeaderEditorFrameSet.jsp' method='post' name='editor_form' id='editor_form'>";
  		 	htmlText +="<input type='hidden' name='header_type' id='header_type' value=\""+header_type+"\">";
  		 	htmlText +="<input type='hidden' name='mode' id='mode' value=\""+mode+"\">";
  		 	htmlText +="<input type='hidden' name='header_id' id='header_id' value=\""+header_id+"\">";
  		 	htmlText +="<input type='hidden' name='long_desc' id='long_desc' value=\""+long_desc+"\">";
  		 	htmlText +="<input type='hidden' name='short_desc' id='short_desc' value=\""+short_desc+"\">";
  		 	htmlText +="<input type='hidden' name='eff_status' id='eff_status' value=\""+eff_status+"\">";
			htmlText +="</form></body></html>";
 			parent.f_query_add_mod.document.body.insertAdjacentHTML('afterbegin',htmlText);
			parent.f_query_add_mod.document.editor_form.submit();
	}
}

function clearInfo(obj)
{
	if(obj.value != '')
	{
		document.NoteHeader_form.header.disabled = false;
	}
	else
		document.NoteHeader_form.header.disabled = true;
}

function setPreviewTemplate(obj){
	if(obj!=null && obj!=""){
 		var new_value = "~"+obj+"`";     
  	    parent.editor.RTEditor0.document.body.focus();
		parent.editor.RTEditor0.document.clear();
  		var object_result = parent.editor.RTEditor0.document.execCommand("paste","",new_value);
 		if(!object_result)
			alert(getMessage("TRY_AFTER","OR"))
	}
 }
 function storeEditor()
 {
	
 }


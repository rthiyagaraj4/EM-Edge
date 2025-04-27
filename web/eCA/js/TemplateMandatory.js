function checkRemoveTemplate(check)
{
	var confirmFlag;
	if(check=="Y")
		confirmFlag = true;
	else
		confirmFlag = confirm(getMessage("TEMP_MANDATORY",'CA'));

	if(confirmFlag)
	{
		template_mode		=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.template_mode;
		
		var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	
		var prev_sec_hdg_code_val		= Obj.curr_sec_hdg_code.value;
		var prev_sec_content_type_val	= Obj.curr_sec_content_type.value;
		var prev_child_sec_hdg_code_val	= Obj.curr_child_sec_hdg_code.value;
		var prev_child_sec_content_type_val = Obj.curr_child_sec_content_type.value;
		var note_type						= Obj.note_type.value;

		if(template_mode!=null && template_mode.value=="Insert")
			template_mode.value	=	"RemoveTemplate";
	
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?prev_sec_hdg_code="+prev_sec_hdg_code_val+"&prev_sec_content_type="+prev_sec_content_type_val+"&prev_child_sec_hdg_code="+prev_child_sec_hdg_code_val+"&prev_child_sec_content_type="+prev_child_sec_content_type_val+"&mode=sectionCancelView&note_type="+note_type;
		//parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
	}
		/*		
			else 
			{
				parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.reset();
			}
	
		}
		*/
}


function recordTemplateDetails()
{
	//calling the function for calculating the values for formula component if any 
	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.callForLoadingFormulaResults();
	//-------------------------------------------------------------
	if(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields != null)
	{
		var mandatory_fields	=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields.value;
		var mandatory_names		=	escape(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_names.value);
		mandatory_names=unescape(mandatory_names);
		var	list_item_fields	=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.list_item_fields.value;
		//alert(mandatory_fields);
		//alert(mandatory_names);
		var	fields		=	new	Array();
		var	names		=	new	Array();
		if(mandatory_fields.length>0)
		{
			var arr_mandatory_fields	=	mandatory_fields.split("|");
			var arr_mandatory_names		=	mandatory_names.split("|");

			for(var i=0; i<arr_mandatory_fields.length; i++)
			{
				//alert("arr_mandatory_fields["+i+"] : "+arr_mandatory_names[i]);
				fields[i]	=	eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]);
				names[i]	=	arr_mandatory_names[i];
			}

			if(checkFields(fields,names,messageFrameReference)==false)
			{
				settingsForMandatoryFieldsNotEntered();
				return false;
			}
		}
		//added on 1/5/2004 to take care of the mandatory fields from the paragraph
		//taking into mind that maximum of 20 paragraphs r there in the template	
		if(!checkGridMatrix())
		{
			var temp_error = getMessage("MANDATORY_FOR_GC","CA");
			messageFrameReference.document.location.href="../../eCA/jsp/CAError.jsp?err_num=" + temp_error;
			settingsForMandatoryFieldsNotEntered();
			return false;
		}
		for(var k=0;k<20;k++)
		{
			var str = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields_para"+k);
			if(str!=null)
			{
				if(str.value!="")
				{
					var arr = str.value.split("~");
					var paraCompNames = arr[0]; //comp name and srl no (can be many saparated by |)
					var suffixToBeAttached = arr[1];//para name and para count (will be only one)
					if(paraCompNames.length>0)
					{
						var arr_mandatory_fields	=	paraCompNames.split("|");
						for(var i=0; i<arr_mandatory_fields.length; i++)
						{
							if(arr_mandatory_fields[i] != "")				
							fields[i]	=	eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]+suffixToBeAttached);
							//alert(fields[i].value);
						}

						if(checkParaFields(fields,names,messageFrameReference)==false)
						{
							settingsForMandatoryFieldsNotEntered();
							return false;

						}
					}
				}
			}
			else
			{
				break;
			}
		}
		//added for template containing the disbled components
/*		
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.target = "RecClinicalNotesSecTempControlFrame";
		//alert('submitting from recordTemplateDetails');
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesTemplateCtrl.jsp";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
		*/
	}
//	ResetTemplateToolbar();
	return true;
}

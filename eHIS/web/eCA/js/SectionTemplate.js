/*
--------------------------------------------------------------------------------------------------------------
Date       	 Edit History    Name        		Description				
--------------------------------------------------------------------------------------------------------------
?            100             ?           		created
20/08/2013   IN040006		 Akbar				MMS-SCF-0016
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
29/06/2016	IN059630		Krishna	Gowtham								   		GHL-CRF-0401	
31/03/2017	IN061907		Krishna Gowtham J	26/02/2017		Ramesh G		ML-MMOH-CRF-0559		
08/05/2017	IN064034		Dinesh T										ML-MMOH-CRF-0557_UT3
---------------------------------------------------------------------------------------------------------
*/
var messageFrameReference = parent.parent.messageFrame;
function Record(operation_mode) 
{
	if(parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.hist_def_yn.checked == true)
	{
		if(parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.hist_rec_type_hidden.value == "")
		{
			//alert(f_query_add_mod.getMessage("LINK_HIST_VAL_BLANK","CA"));
			var msg=getMessage("LINK_HIST_VAL_BLANK","CA");
		    alert(msg);
			return true;
		}
	}
	else
	{ 	
		var msg="";
		if(parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.disabled==true)
		{
			parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.disabled=false;
		}
	    var operation	=	parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.operation;
		var section=parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section;
	//	alert("@@@ in record(),section.value="+section.value);
		var item_type=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.item_type;
		var row_position=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.row_position;
		var column_position=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.column_position;
		var column_span=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.column_span;
		var component=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.component_prompt;
	
		var title_text=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.title_text;
		var title_text_code=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.title_text_code;
		var includeyn=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.includeyn.value;
		var srl_no = parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.srl_no.value;
		var unit = parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formulaResultUnits;
		var comp_id = parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.component;
		
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.section.value=section.value;   
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.hitem_type.value=parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.item_type.value;   
		
		if(operation.value=="modify")
		{
			parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.disabled=true;
			if(operation_mode=="Delete")
				operation.value		=	"Delete";		
		}	
		
		if(item_type.value=="C")
		{
			if(parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.includeDates.checked==true && parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formulaResultType.value=="N")
			{
			
	         var fields= new Array (section,item_type,comp_id,component,row_position,column_position,column_span,unit);
			//var names= new Array ("Section", "Item Type","Component", "Row Position","Column Position","Column Span","Units");
			var names= new Array (getLabel("Common.Section.label","COMMON"),
							getLabel("Common.Itemtype.label","COMMON"),
								getLabel("Common.Component.label","COMMON"),
								getLabel("Common.Prompt.label","COMMON"),
								getLabel("Common.RowPosition.label","COMMON"),
								 getLabel("Common.ColumnPosition.label","COMMON"),
								getLabel("Common.ColumnSpan.label","COMMON"),
								getLabel("Common.Units.label","COMMON")
						    );
							
			}
			else
			{
				
			var fields= new Array (section,item_type,comp_id,component,row_position,column_position,column_span);
	//var names= new Array ("Section", "Item Type","Component", "Row Position","Column Position","Column Span","Units");
			var names= new Array (
								getLabel("Common.Section.label","COMMON"),
								getLabel("Common.Itemtype.label","COMMON"),
								getLabel("Common.Component.label","COMMON"),
								getLabel("Common.Prompt.label","COMMON"),
								getLabel("Common.RowPosition.label","COMMON"),
								getLabel("Common.ColumnPosition.label","COMMON"),
								getLabel("Common.ColumnSpan.label","COMMON")
								);
			}
	
		}
		else if(item_type.value=="T")
		{
			var fields= new Array (section,item_type,title_text_code,row_position,column_position,column_span);
			var names= new Array (getLabel("Common.Section.label","COMMON"),getLabel("Common.Itemtype.label","COMMON"), getLabel("Common.TitleText.label","COMMON"),getLabel("Common.RowPosition.label","COMMON") ,getLabel("Common.ColumnPosition.label","COMMON"),getLabel("Common.ColumnSpan.label","COMMON"),getLabel("Common.Units.label","COMMON"));
	//		var names= new Array (getLabel("eCA.Section.label","CA"),
	//							getLabel("Common.Itemtype.label","COMMON"),
	//							getLabel("eCA.TitleText.label","CA"),
	//							getLabel("eCA.RowPosition.label","CA"),
	//							getLabel("Common.ColumnPosition.label","COMMON"),
	//							getLabel("Common.ColumnSpan.label","COMMON"),
	//							);
		}
		//alert(parent.frames[1].document.forms[0].hitem_type.value);	
		if(parent.CASectionTemplateListFrame.checkFieldsofMst(fields,names,messageFrameReference ) )
		{
			if((parseInt(column_position.value)==2) && (parseInt(column_span.value)>2))
			{
				
				//alert(getMessage("COLSPAN_MORE_2"));
				msg=getMessage("MORE_COL_SPAN_NOT_ALLOWED","CA");
				messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				column_span.focus();
				column_span.select();
				return true;
			}
			if((parseInt(column_position.value)==3) && (parseInt(column_span.value)>1))
			{	
				//alert(getMessage("COLSPAN_MORE_1"));
				 msg=getMessage("MORE_COL_SPAN_NOT_ALLOWED","CA");
				messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				column_span.focus();
				column_span.select();
				return true;
			}
			parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.target = messageFrameReference.name;
			
			
			
	        //messageFrameReference.location.href="../../eCommon/html/blank.html";
	
	    /*if(document.CASectionTemplateDetailForm.formulaResultUnits.includeDates.checked==true && document.CASectionTemplateDetailForm.formulaResultUnits.value=="")
			
			{
	           
			   msg="Units can not be blank";
			   messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
			else 
			{ */
		
			if(chkValue(parent.parent.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.column_position) && chkValue(parent.parent.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.column_span) )
			{
					parent.parent.f_query_add_mod.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.submit()
			/*
				var action_url = "../../eCA/jsp/CASectionTemplateDetailCheck.jsp";
				var HTMLVal			=	"<html><body><form name='dummy8' id='dummy8' method='POST' action='"+action_url+"' >"+
								"<input type='hidden' name='component' id='component' value='"+comp_id.value+"'>"+
								"<input type='hidden' name='srl_no' id='srl_no' value='"+srl_no+"'>"+
								"<input type='hidden' name='section' id='section' value='"+section.value+"'>"+
								"<input type='hidden' name='includeyn' id='includeyn' value='"+includeyn+"'>"+
				       			"</form></body></html >";
			    //alert('component'+component.value+'srl_no'+srl_no+'section'+section.value+'includeyn'+includeyn);
				//alert("HTMLVal	"+HTMLVal);
				messageFrameReference.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			
				messageFrameReference.document.dummy8.submit();
				//parent.CASectionTemplateToolbarFrame.location.href="CASectionTemplateToolbar.jsp";
			*/
			}
			//}
		}
		parent.CASectionTemplateToolbarFrame.location.href="CASectionTemplateToolbar.jsp";        
	}
}
async function showSectionTemplate()
{
	var title			= getLabel("eCA.PreviewTemplate.label","CA");
	var section=parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.value;
	
	if(section=="")
	{
		var msg=getMessage("SECTION_NOT_BLANK","CA");
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}
	var retVal			=	"";
	var dialogHeight	=	"90vh";// 37.5 //updated by Arvind @ 09-12-08
	var dialogWidth	=	"90vw";//80
	var dialogTop		=	"";//170
	var status			=	"no";
	var arguments		=	"" ;

	//var action_url		=	'../../eCA/jsp/NewRecClinicalNotesTemplateMain.jsp';
	var action_url		=	'../../eCA/jsp/CASectionTemplateMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?title="+encodeURIComponent(title,"UTF-8")+"&sec_hdg_code="+section+"&operation_mode=TemplateView";
	//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	retVal			=	await top.window.showModalDialog(action_url,arguments,features);
	
	
}

function callComponentLookup(calledFrom)
{
	var comp_id			=	document.CAComponentLookUpCriteriaForm.comp_id;
	var comp_prompt		=	document.CAComponentLookUpCriteriaForm.comp_prompt;
	var comp_type		=	document.CAComponentLookUpCriteriaForm.comp_type;
	
	if((comp_id.value != null && comp_id.value != "" )|| comp_prompt.value != null && (comp_prompt.value !=""))
	{
	var	action_url		=	"../../eCA/jsp/CAComponentLookUp.jsp";
	var HTMLVal			=	"<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='CompLookupInputForm' id='CompLookupInputForm' method='POST' action='"+action_url+"'>"+
							"<input type='hidden' name='comp_id' id='comp_id' value='"+comp_id.value+"'>"+
							"<input type='hidden' name='comp_prompt' id='comp_prompt' value='"+comp_prompt.value+"'>"+
							"<input type='hidden' name='comp_type' id='comp_type' value='"+comp_type.value+"'>"+
							"<input type='hidden' name='calledFrom' id='calledFrom' value='"+calledFrom+"'>"+
							"</form></body></html>";

	parent.CAComponentFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.CAComponentFrame.document.CompLookupInputForm.submit();
	}
	else 
		{
			var erroMsg=getMessage("CAN_NOT_BE_BLANK",'Common');
			var msg = getLabel("Common.ComponentID.label","COMMON");
			msg += "/";
			msg += getLabel("Common.ComponentPrompt.label","COMMON");
			erroMsg = erroMsg.replace( "$" , msg);
			alert(erroMsg);
			return false;
	
		}
		
}

function reset() 
{
	/*for(i=0;i<top.content.frames.length;i++)
	{
		if(top.content.frames(i).frames.length>0)
		{
			alert(top.content.frames(i).name);
			for(j=0;j<top.content.frames(i).frames.length;j++)
			{
				if(top.content.frames(i).frames(j).frames.length>0)
				{
					alert(top.content.frames(i).frames(j).name);
					for(k=0;k<top.content.frames(i).frames(j).length;k++)
						alert(top.content.frames(i).frames(j).frames(k).name);
				}	
			}
		}	
	}	*/
	f_query_add_mod.CASectionTemplateHeaderFrame.document.location.href="../../eCA/jsp/CASectionTemplateHeader.jsp";
	f_query_add_mod.CASectionTemplateListFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.CASectionTemplatePreviewFrame.document.location.href="../../eCommon/html/blank.html";
	f_query_add_mod.CASectionTemplateDetailFrame.document.location.href="../../eCommon/html/blank.html";	
	f_query_add_mod.CASectionTemplateToolbarFrame.document.location.href="../../eCommon/html/blank.html";	
}
//function called from on click of the formula definition button.
async function callOnFormulaDefinition()
{
	var includeDates					= (parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.includeDates.checked?"Y":"N");
	var formulaResultType	= parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formulaResultType.value;
	var formulaResultUnits	= parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formulaResultUnits.value;
	var component	= parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.component.value;
	var section=parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.value;
	if(section=="")
	{
		var msg=getMessage("SECTION_NOT_BLANK","CA");
		messageFrameReference.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}
	var retVal			=	"";
	var dialogHeight	=	"90vh";
	var dialogWidth		=	"60vw";
	var dialogTop		=	"0vh";
	var status			=	"no";
	var arguments		=	parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formula_definition.value ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateFormulaMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?sec_hdg_code="+section + "&formulaResultType=" + formulaResultType + "&includeDates=" + includeDates +  "&comp_id="+component + "&formulaResultUnits=" + formulaResultUnits;

	//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	//document.forms[0].component.focus();
	retVal = await top.window.showModalDialog(action_url,arguments,features);	
	if(retVal!=null)
	{
		if(retVal.indexOf("||") == -1)
		{
			parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formula_definition.value = retVal;
		}
		else
		{
			var temp = retVal.split("||");
			parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formula_definition.value = temp[0];
			parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.formulaResultUnits.value = temp[1];
		}
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.component_type.value = "A";
	}
}
function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*%~!$%^&(){}[]?/.,;:|>=+- ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function chekForQuotes(obj)
{
	if(obj.value != null && obj.value != '' && obj.value != undefined)
	{
		if(obj.value.indexOf("'") != -1 || obj.value.indexOf('"') != -1)
		{
			var error = getMessage("INVALID_VALUE","COMMON");
			error = error.replace('#','Character');
			alert(error);
			obj.focus();
			return false;
		}
	}
}

//Function for the file CAComponentLookUp.jsp-start

function closewjj(obj1,obj2,obj3,obj4)
{
	while(obj2.indexOf("+")!=-1)
	{
		obj2	=	obj2.replace("+"," ");
	}
	var obj =new Array();
	obj[0]=obj1;
	obj[1]=obj2;
	obj[2]=obj3;
	obj[3]=obj4;
	parent.window.returnValue=obj;
	
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	
}

//Function for the file CAComponentLookUp.jsp-end


//Function for the file CASectionTemplateHeader.jsp-start

function callList(obj)
{
	
	var section=obj.value;
	if(section !="") 
	{
		parent.CASectionTemplateListFrame.location.href="CASectionTemplateList.jsp?section="+section;
		parent.CASectionTemplatePreviewFrame.location.href="CASectionTemplatePreview.jsp";
		parent.CASectionTemplateDetailFrame.location.href="CASectionTemplateDetail.jsp?section="+section;
		parent.CASectionTemplateToolbarFrame.location.href = "CASectionTemplateToolbar.jsp?section="+section;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else
	{
		parent.CASectionTemplateListFrame.location.href="../../eCommon/html/blank.html";
		parent.CASectionTemplatePreviewFrame.location.href="../../eCommon/html/blank.html";
		parent.CASectionTemplateDetailFrame.location.href="../../eCommon/html/blank.html";
		parent.CASectionTemplateToolbarFrame.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}	
}

//IN061907 start
//function sendtoDetail ( item_type ,title_id,title_text,comp_id, prompt_id, row_pos_no, column_pos_no, no_of_col_span, prompt_display_loc, srl_no,comp_type ,age_group_code,hist_rec_type, acceptOption, list_selection, list_presentation, num_prefix_required_yn, hint_id, formula_result_type, formula_includes_date_yn, formula_result_unit,includeyn,link_to_std_value_yn,dflt_from_hist_appl_yn,old_hist_time_frame_unit,old_hist_time_frame_val,event_code,prompt_text,text_allign_yn)// text_allign_yn added for GHL-CRF-0401
function sendtoDetail ( item_type ,title_id,title_text,comp_id, prompt_id, row_pos_no, column_pos_no, no_of_col_span, prompt_display_loc, srl_no,comp_type ,age_group_code,hist_rec_type, acceptOption, list_selection, list_presentation, num_prefix_required_yn, hint_id, formula_result_type, formula_includes_date_yn, formula_result_unit,includeyn,link_to_std_value_yn,dflt_from_hist_appl_yn,old_hist_time_frame_unit,old_hist_time_frame_val,event_code,prompt_text,text_allign_yn, auto_result_yn)
//IN061907 ends
{
	var previous_comp_type = parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.component_type.value;
	if(previous_comp_type=="L" || previous_comp_type=="C")
	{
		var check =confirm(getMessage("CLEAR_ASS_FIELDS_CONF",'CA'));
		if(!check)
		{
			return;
		}
	}
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.disabled=true;
	var sectionCode= parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.value;
	//IN061907 start
	//parent.CASectionTemplateDetailFrame.location.href="../../eCA/jsp/CASectionTemplateDetail.jsp?item_type="+escape(item_type)+"&title_id="+title_id+"&comp_id="+comp_id+"&prompt_id="+prompt_id+"&row_pos_no="+row_pos_no+"&column_pos_no="+column_pos_no+"&no_of_col_span="+no_of_col_span+"&prompt_display_loc="+prompt_display_loc+"&srl_no="+srl_no+"&comp_type="+comp_type+"&operation=modify&section="+sectionCode+"&age_group_code="+age_group_code+"&hist_rec_type="+hist_rec_type + "&acceptOption=" + acceptOption + "&list_selection=" + list_selection + "&list_presentation=" + list_presentation + "&hint_id="+hint_id+ "&num_prefix_required_yn=" + num_prefix_required_yn + "&formula_result_type=" + formula_result_type + "&formula_includes_date_yn=" + formula_includes_date_yn + "&formula_result_unit=" + formula_result_unit+"&includeyn="+includeyn+"&link_to_std_value_yn="+link_to_std_value_yn+"&dflt_from_hist_appl_yn="+dflt_from_hist_appl_yn+"&old_hist_time_frame_unit="+old_hist_time_frame_unit+"&old_hist_time_frame_val="+old_hist_time_frame_val+"&event_code="+event_code+"&text_allign_yn="+text_allign_yn+"&comp_desc="+prompt_text; //added text_allign_yn for GHL-CRF-0401
	parent.CASectionTemplateDetailFrame.location.href="../../eCA/jsp/CASectionTemplateDetail.jsp?item_type="+escape(item_type)+"&title_id="+title_id+"&comp_id="+comp_id+"&prompt_id="+prompt_id+"&row_pos_no="+row_pos_no+"&column_pos_no="+column_pos_no+"&no_of_col_span="+no_of_col_span+"&prompt_display_loc="+prompt_display_loc+"&srl_no="+srl_no+"&comp_type="+comp_type+"&operation=modify&section="+sectionCode+"&age_group_code="+age_group_code+"&hist_rec_type="+hist_rec_type + "&acceptOption=" + acceptOption + "&list_selection=" + list_selection + "&list_presentation=" + list_presentation + "&hint_id="+hint_id+ "&num_prefix_required_yn=" + num_prefix_required_yn + "&formula_result_type=" + formula_result_type + "&formula_includes_date_yn=" + formula_includes_date_yn + "&formula_result_unit=" + formula_result_unit+"&includeyn="+includeyn+"&link_to_std_value_yn="+link_to_std_value_yn+"&dflt_from_hist_appl_yn="+dflt_from_hist_appl_yn+"&old_hist_time_frame_unit="+old_hist_time_frame_unit+"&old_hist_time_frame_val="+old_hist_time_frame_val+"&event_code="+event_code+"&text_allign_yn="+text_allign_yn+"&comp_desc="+prompt_text+"&auto_result_yn="+auto_result_yn;
	//IN061907 ends
	parent.CASectionTemplateToolbarFrame.location.href="../../eCA/jsp/CASectionTemplateToolbar.jsp?item_type="+escape(item_type)+"&title_id="+title_id+"&comp_id="+comp_id+"&prompt_id="+prompt_id+"&prompt_display_loc="+prompt_display_loc+"&srl_no="+srl_no+"&comp_type="+comp_type+"&operation=modify&section="+sectionCode+"&age_group_code="+age_group_code+"&hist_rec_type="+hist_rec_type + "&acceptOption=" + acceptOption + "&list_selection=" + list_selection + "&list_presentation=" + list_presentation +"&num_prefix_required_yn=" + num_prefix_required_yn + "&formula_result_type=" + formula_result_type + "&formula_includes_date_yn=" + formula_includes_date_yn + "&formula_result_unit=" +formula_result_unit+"&includeyn="+includeyn+"&link_to_std_value_yn="+link_to_std_value_yn+"&dflt_from_hist_appl_yn="+dflt_from_hist_appl_yn+"&old_hist_time_frame_unit="+old_hist_time_frame_unit+"&old_hist_time_frame_val="+old_hist_time_frame_val+"&event_code="+event_code+"&comp_desc="+prompt_text;
	
}

async function PopUpShiftRow(obj)
{
	var section			=	parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.value;
	var retVal			=	"";
	var dialogHeight	=	"200px";
	var dialogWidth  	=	"250px";
	var dialogTop		=	"200";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateShiftRows.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?curr_row_num="+obj+"&operation_mode=ShiftRow";
	//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	retVal			=	await window.showModalDialog(action_url,arguments,features);
	
	if(retVal != null)
	{
		var retArr = retVal.split('~');
		var shift_row_num	= retArr[0];
		var curr_row_num	= retArr[1];
		var mode			= retArr[2];
		self.location.href="../../eCA/jsp/CASectionTemplateList.jsp?operation_mode=ShiftRow&shift_row_num="+shift_row_num+"&curr_row_num="+curr_row_num+"&section="+section+"&mode="+mode;
	}
}

//Function for the file CASectionTemplateList.jsp-end


//Function for the file CASectionTemplateDetail.jsp-start

function ClearAgeGroup(obj)
{
	if(obj.value=="")
	{
			document.CASectionTemplateDetailForm.age_group_code.value="";
	}
}
function checkRecord(obj)
{
	if(obj.value!="")
	{
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='CASectionTemplateCondSearch.jsp'><input type=hidden name='conditionid' id='conditionid' value='"+obj.value+"'> </form></body></html>";
			messageFrame.document.write(HTMLVal);
			messageFrame.document.tempForm.submit();
	}
	
}

function allowValidNumber2(fld, e, maxInt, deci)
{
	var fldvalue = fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;

	if(whichCode == 45)
	{
		return false
	}

	var strCheck = '123456789';

	if(maxInt > 1 && fldvalue.length > 0)
		strCheck = '0123456789';
    
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;
    
	var key = String.fromCharCode(whichCode);
	if (strCheck.indexOf(key) == -1)
		return false;
	else
		return true;
}

function checkForMinus(obj)
{
	if(parseInt(obj.value,10) == 0)
	{ 
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","COMMON"))
		//alert("APP-CA00034 Negative values are not allowed");
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
function checkCriteria(calledFrom)
{
	var desc=document.CAComponentLookUpCriteriaForm.comp_id.value;	
	var description=trimString(desc);	
	if(description.length>0)		
		callComponentLookup(calledFrom);
}
async function callComponent()
{
	var action_url='../../eCA/jsp/CAComponentLookUpMain.jsp';
	var target		= document.forms[0].component;	
	var retVal	=	"";//= 	new String();
	var dialogHeight= "90vh" ; //updated by Arvind @ 09-12-08
	var dialogWidth	= "45vw" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	var template_type=document.CASectionTemplateDetailForm.template_type.value;
	if((template_type == null)|| (template_type == "") || (template_type == "B")){
		retVal = await window.showModalDialog("../../eCA/jsp/CAComponentLookUpMain.jsp?desc_val="+target.value,arguments,features);	
		//retVal = window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	}else{
		
		/******************************/
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		if(template_type=="H"){
			
			argumentArray[0]		 = "select field_mnemonic code, field_mnemonic_desc description FROM CA_MNEMONIC WHERE eff_Status = 'E' and field_mnemonic_type IN('NHL', 'NHD') and upper(field_mnemonic) like upper(?) and upper(field_mnemonic_desc) like upper(?) order by 2 " ;

		}else if(template_type == "F"){

		argumentArray[0]		 =  "select field_mnemonic code, field_mnemonic_desc description FROM CA_MNEMONIC WHERE eff_Status = 'E' and field_mnemonic_type IN('FL','FD') and upper(field_mnemonic) like upper(?) and upper(field_mnemonic_desc) like upper(?) order by 2";

		}if(template_type == "R"){

		argumentArray[0]		 =  "select field_mnemonic code, field_mnemonic_desc description FROM CA_MNEMONIC WHERE eff_Status = 'E' and field_mnemonic_type IN('RHL','RHD') and  upper(field_mnemonic) like upper(?) and  upper(field_mnemonic_desc) like upper(?) order by 2";

		}

		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		//argumentArray[5]   = document.CASectionTemplateDetailForm.component.value ;
		argumentArray[5]   = "";
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal =await CommonLookup(getLabel("Common.Component.label","Common"),argumentArray );
		/******************************/
	}
	if(retVal!=null && retVal[1]!=undefined)
	{
		document.CASectionTemplateDetailForm.component.value=retVal[0];
		document.CASectionTemplateDetailForm.comp_desc.value=retVal[1];
     //   document.CASectionTemplateDetailForm.component.readOnly=true;
		
		if((template_type==null) || (template_type=="") || (template_type=="B")){

       if(retVal[2] == "Check Box" || retVal[2] == "Date" ||  retVal[2] == "Date/Time" ||  retVal[2] == "Decimal Numeric" ||  retVal[2] == "Long Text" ||  retVal[2] == "Integer Numeric" ||  retVal[2] == "List" ||  retVal[2] == "Short Text" || retVal[2] == "Time")
		{
			
var len1=document.forms[0].acceptOption.options.length;

for(i=0;i<len1;i++)
{
	var len2=document.forms[0].acceptOption.options.length;
    if(document.forms[0].acceptOption.options[i].value!="R" && len2 <3  )
	{
	    var opt= document.createElement('OPTION');				
		opt.text='Required'
		opt.value='R';
		document.getElementById("acceptOption").add(opt);
	}
}
			//if(document.getElementById("acceptOption").value !='R')
			//document.forms[0].acceptOption.add(opt);
			//document.getElementById("acceptOption").add(opt);
		
		//var lBox=document.forms[0].acceptOption; 
		//lBox.remove(lBox.options[0]);
		//alert(document.forms[0].acceptOption.length);
		//var len=parseInt(document.forms[0].acceptOption.length);
		//alert(len);
		/*if(len>3);
			{
			  alert("huhjk");
			 lBox.remove(lBox.options[1]);
			}*/
			
			//document.getElementById("acceptOption").value="R";
			//document.getElementById("listcheck").value="List";
			document.getElementById("tablist").style.display = "none";

		}
		else if(retVal[2] == "Embedded Component" || retVal[2] == "Formula" ||  retVal[2] == "Grid Component" ||  retVal[2] == "Matrix Component" ||  retVal[2] == "Summary Component")
		{


		var i=0;
		var len=document.forms[0].acceptOption.options.length;
		var lBox=document.forms[0].acceptOption; 
		lBox.remove(lBox.options[0]);
	 
		 while(i<= len){
			 lBox.remove(lBox.options[i]);
			 i+=1;
		}

		/*var opt=document.createElement('OPTION');
		 opt.value='';
		 opt.text='  --Select-- ';
		 lBox.add(opt);*/
		var opt1=document.createElement('OPTION');
		 opt1.value='O';
		 opt1.text='Optional';
		 lBox.add(opt1);
		 var opt2=document.createElement('OPTION');
		 opt2.value='D';
		 opt2.text='Display Only';
		 lBox.add(opt2);	


			//alert(document.getElementById("acceptOption").value);
		//	document.getElementById("acceptOption").value="O";
		//	document.getElementById("acceptOption").value="D";
			//var indexVal = 
			//document.getElementById("acceptOption").options.remove('R');
			//document.getElementById("listcheck").value="List";
			//alert("2:" +document.getElementById("acceptOption").value);
			document.getElementById("tablist").style.display = "none";
	}
		
		else
		{
			
        document.getElementById("acceptOption").value="O";
		}



		if(retVal[3] == 'Y')
		{
			
			parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.prefixRequired.checked = true;
			parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.prefixRequired.value='Y';
		}
		//GHL-CRF-0401[IN059630] - Start
		if(retVal[2]=="Long Text" || retVal[2]=="Short Text")
		{
			document.getElementById("comp_rslt_disp_next_line_id").style= "display";
			document.getElementById("comp_disp_next_yn_id").style= "display";
		}
		else
		{
			document.getElementById("comp_rslt_disp_next_line_id").style.display = "none";
			document.getElementById("comp_disp_next_yn_id").style.display = "none";
			document.getElementById("textAllignYN").value='N';
			document.getElementById("comp_disp_next_yn").value='N';
			document.getElementById("comp_disp_next_yn").checked=false;

		}
		//GHL-CRF-0401[IN059630] - End
		if(retVal[2]=="Long Text" || retVal[2]=="Embedded Component" || retVal[2] == "Grid Component" || retVal[2] == "Matrix Component" || retVal[2] == "Multi-List Component")
		{	
			
			document.CASectionTemplateDetailForm.column_span.value="3";
			document.CASectionTemplateDetailForm.column_position.value="1";
			document.CASectionTemplateDetailForm.column_span.readOnly=true;
			document.CASectionTemplateDetailForm.column_position.readOnly=true;
			if(retVal[2]=="Embedded Component" || retVal[2] == "Grid Component" || retVal[2] == "Matrix Component" || retVal[2] == "Multi-List Component")
			{
				if(retVal[2]=="Matrix Component")
					document.CASectionTemplateDetailForm.component_type.value = "X";
				else if(retVal[2] == "Grid Component")
					document.CASectionTemplateDetailForm.component_type.value = "R";
				else if(retVal[2] == "Multi-List Component")
					document.CASectionTemplateDetailForm.component_type.value = "M";					
				else if(retVal[2] == "Embedded Component")
					document.CASectionTemplateDetailForm.component_type.value = "P";					
				document.CASectionTemplateDetailForm.hist_rec_type.disabled = true;
				document.getElementById("presentationCriteriaTR").style.display = "none";
				document.getElementById("tablist").style.display = "none";

			}
			else
				document.CASectionTemplateDetailForm.hist_rec_type.disabled = false;
		}		
		else
		{
			if(retVal[2]=='List Item')
			{
				parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.style.display = "none";
				document.getElementById("tablist").style= "display";
				//document.getElementById("linkHistoryBtn").style.display = "none";
				document.getElementById("histDefYNTR").style.display = "none";
				document.getElementById("presentationCriteriaTR").style= "display";
				document.getElementById("numericPrefixTR").style.display = "none";
				
			}
			else if(retVal[2] == 'Integer Numeric' || retVal[2] == 'Decimal Numeric')
			{
				document.getElementById("presentationCriteriaTR").style.display = "none";
				//document.getElementById("numericPrefixTR").style= "display";
				document.getElementById("numericPrefixTR").style = "display";
				//document.getElementById("histDefYNTR").style= "display";
				document.getElementById("histDefYNTR").style = "display";
				//document.getElementById("linkHistoryBtn").style= "display";
				document.getElementById("tablist").style= "display"; //none to inline
				parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.style= "display";

				if(retVal[2] == 'Integer Numeric')
				{
					document.CASectionTemplateDetailForm.component_type.value = "I";
				}
				else if(retVal[2] == 'Decimal Numeric')
				{
					document.CASectionTemplateDetailForm.component_type.value = "N";
				}
			}
			else if(retVal[2] == 'Date' || retVal[2] == 'Date/Time' || retVal[2] == 'Short Text')
			{
				document.getElementById("tablist").style.display = "none";

				//document.getElementById("histDefYNTR").style= "display";
				//document.getElementById("linkHistoryBtn").style= "display";
				if(retVal[2] == 'Date')
				{
					document.CASectionTemplateDetailForm.component_type.value = "D";
				}
				else if(retVal[2] == 'Date/Time')
				{
					document.CASectionTemplateDetailForm.component_type.value = "E";
				}
				else if(retVal[2] == 'Short Text')
				{	
					document.CASectionTemplateDetailForm.component_type.value = "H";
					document.getElementById("presentationCriteriaTR").style.display = "none";
					document.getElementById("numericPrefixTR").style.display = "none";
					//document.getElementById("linkHistoryBtn").style= "display";
					//document.getElementById("histDefYNTR").style= "display";
					document.getElementById("histDefYNTR").style = "display";
					document.getElementById("tablist").style= "display";
					parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.style= "display";
					
				}
			}
			else if(retVal[2] == 'Yes/No')
			{
				parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linking.style= "display";
			}
			else
			{
				document.getElementById("presentationCriteriaTR").style.display = "none";
				document.getElementById("numericPrefixTR").style.display = "none";
				document.getElementById("tablist").style.display = "none";

			}

			document.CASectionTemplateDetailForm.column_span.value="";
			document.CASectionTemplateDetailForm.column_span.readOnly=false;
			document.CASectionTemplateDetailForm.column_position.value="";
			document.CASectionTemplateDetailForm.column_position.readOnly=false;
			document.CASectionTemplateDetailForm.hist_rec_type.disabled = true;
		}
		if(retVal[2]=="Formula")
		{	
			//document.getElementById("linkHistoryBtn").style.display = "none";
			parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.style.display = "none";
			parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.formulaDefinitionBtn.style = 'display';
			document.getElementById("histDefYNTR").style.display = "none";
			document.getElementById("formulaResultTypeTR").style = 'display';
			document.getElementById("formulaTypeTR").style = 'display';
			document.getElementById("tablist").style= "display"; 
			//callOnFormulaDefinition();
		}
		else
		{
			//document.CASectionTemplateDetailForm.formulaDefinitionBtn.style.display='none';
			parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.formulaDefinitionBtn.style.display='none';
			document.getElementById("formulaResultTypeTR").style.display='none';
			document.getElementById("formulaTypeTR").style.display='none';		
		}
	}
	}else{
		
		document.CASectionTemplateDetailForm.component.value="";
		document.CASectionTemplateDetailForm.comp_desc.value="";
	}
}
function callMandatory(obj)
{
	
	var element;
	var acceptOption = document.CASectionTemplateDetailForm.acceptOption;
	//for(index1=0;index1<acceptOption.options.length;index1++)
	while(acceptOption.options.length != 0)
		acceptOption.remove(0);
	if(obj.value=="C")	
	{
		
		document.CASectionTemplateDetailForm.includeyn.checked=false;
		document.CASectionTemplateDetailForm.includeyn.value='N';
		document.CASectionTemplateDetailForm.includeyn.style.visibility='visible';
		document.getElementById("wid").style = 'display';
		
		document.CASectionTemplateDetailForm.mand1.style.visibility='hidden';
		document.CASectionTemplateDetailForm.mand2.style.visibility='visible';

		document.CASectionTemplateDetailForm.mandatory.style.visibility='visible';

		document.CASectionTemplateDetailForm.title_text.disabled=true;
		document.CASectionTemplateDetailForm.component.disabled=false;
		document.CASectionTemplateDetailForm.title_text.value="";
		document.CASectionTemplateDetailForm.search.disabled=false;
		document.CASectionTemplateDetailForm.searchCondition.disabled=false;
		document.CASectionTemplateDetailForm.disp_position.remove(1); 
		document.CASectionTemplateDetailForm.disp_position.selectedIndex=0;
		document.CASectionTemplateDetailForm.age_group_code_desc.disabled = false;	
		document.CASectionTemplateDetailForm.title_diag.disabled = true;
		document.CASectionTemplateDetailForm.component_promptdiag_srch.disabled = false;
		document.CASectionTemplateDetailForm.hintMessagediag_srch.disabled = false;
		element = document.createElement("OPTION");
		element.text = "Optional";
		element.value = "O";
		acceptOption.add(element);
		element = document.createElement("OPTION");
		element.text = "Required";
		element.value = "R";
		acceptOption.add(element);


	}
	else if(obj.value=="T")	
	{
		
		document.CASectionTemplateDetailForm.includeyn.checked=false;
		document.CASectionTemplateDetailForm.includeyn.value='N';
		document.CASectionTemplateDetailForm.includeyn.style.visibility='hidden';
		document.getElementById("wid").style.display='none';

		
		document.CASectionTemplateDetailForm.mand2.style.visibility='hidden';

		document.CASectionTemplateDetailForm.mandatory.style.visibility='hidden';
		document.CASectionTemplateDetailForm.mand1.style.visibility='visible';
		document.CASectionTemplateDetailForm.title_text.disabled=false;
		document.CASectionTemplateDetailForm.component.disabled=true;
		document.CASectionTemplateDetailForm.age_group_code_desc.disabled = true;
		document.CASectionTemplateDetailForm.age_group_code_desc.value = "";
		document.CASectionTemplateDetailForm.search.disabled=true;
		document.CASectionTemplateDetailForm.searchCondition.disabled=true;
		document.CASectionTemplateDetailForm.component.value="";
		document.CASectionTemplateDetailForm.component_prompt.value="";
		document.CASectionTemplateDetailForm.column_span.value="";
		document.CASectionTemplateDetailForm.column_position.value="";
		document.CASectionTemplateDetailForm.column_span.readOnly=false;
		document.CASectionTemplateDetailForm.column_position.readOnly=false;
		document.CASectionTemplateDetailForm.title_diag.disabled = false;
		document.CASectionTemplateDetailForm.component_promptdiag_srch.disabled = true;
		document.CASectionTemplateDetailForm.hintMessagediag_srch.disabled = true;
		var opt=document.createElement('OPTION'); 
		opt.text	=	"Center"; 
		opt.value	=	"C"; 
		document.CASectionTemplateDetailForm.disp_position.add(opt); 
		parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.formulaDefinitionBtn.style.display='none';
		document.CASectionTemplateDetailForm.hist_rec_type.disabled = true;
		element = document.createElement("OPTION");
		element.text = "Display Only";
		element.value = "D";
		acceptOption.add(element);
	}
}
function chkValue(obj)
{
	var msg="";

	if(obj.value!="")
	{
		var obj1 = parseInt(obj.value);

		if(obj1<1 || obj1>3)
		{
			if(obj.name=="column_span")
			{
				msg = getMessage("MORE_COL_SPAN_NOT_ALLOWED","CA");
				//msg=getMessage("COLSPAN_BTW_1_3");
				//alert('Msg'+msg);
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				//top.frames[1].frames[1].frames[2].href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
			else if(obj.name=="column_position")
			{
				msg = getMessage("MORE_COL_VALUE_NOT_ALLOWED","CA");
				//msg=getMessage("COLPOS_BTW_1_3");
				//alert('Msg2'+msg);
//				alert(msg);
				parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			
				//top.frames[1].frames[1].frames[2].href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
			obj.focus();
			obj.select();
			return false;
			
		}
		else
		{
			
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			//top.frames[1].frames[1].frames[2].href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return true;
		}
	}

}

function callforPrompt(obj)
{
	if(document.CASectionTemplateDetailForm.operation.value!="modify")
	{
		document.CASectionTemplateDetailForm.column_span.value="";
		document.CASectionTemplateDetailForm.column_position.value="";
	}
	document.CASectionTemplateDetailForm.component_prompt.value="";
	document.CASectionTemplateDetailForm.column_span.readOnly=false;
	
	if(obj.value!="")
	{
		obj.value=obj.value.toUpperCase();
		comp_id = obj.value;
		var template_type=document.CASectionTemplateDetailForm.template_type.value
		var HTMLVal = "<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body  onKeyDown='lockKey()'><form name='DummySectionTemplate' id='DummySectionTemplate' method='post' action='../../eCA/jsp/CAGetComponentPrompt.jsp'><input type='hidden' name='comp_id' id='comp_id' value='"+comp_id+"'><input type='hidden' name='template_type' id='template_type' value='"+template_type+"'></form></body></html>";
		parent.Dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.Dummy_frame.document.DummySectionTemplate.submit();
	}else
	{
		//top.messageframe.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		parent.parent.messageFrame.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function Getclear()
{
	if(document.forms[0].operation.value=="modify")	
	{
		document.forms[0].title_text.value="";
		document.forms[0].component.value="";
		document.forms[0].component_prompt.value="";
		document.forms[0].row_position.value="";
		document.forms[0].column_position.value="";
		document.forms[0].column_span.value="";
		document.forms[0].disp_position.value="L";
	}
	else
		parent.CASectionTemplateDetailFrame.location.href='../../eCA/jsp/CASectionTemplateDetail.jsp';
		parent.CASectionTemplateToolbarFrame.location.href = '../../eCA/jsp/CASectionTemplateToolbar.jsp';
}
function getCancel()
{
	var section_code 		= parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.value;
	parent.CASectionTemplateHeaderFrame.document.CASectionTemplateHeaderForm.section.disabled=false;
	parent.CASectionTemplateDetailFrame.location.href="CASectionTemplateDetail.jsp?section="+section_code;
	parent.CASectionTemplatePreviewFrame.location.href="CASectionTemplatePreview.jsp";
	parent.CASectionTemplateToolbarFrame.location.href="CASectionTemplateToolbar.jsp";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
async function callOnLinking(section_hdg_code,comp_id,comp_type,comp_prompt,srlNo)
{
	var retVal			=	"";
	var dialogHeight	=	"80vh";
	var dialogWidth		=	"50vw";
	var dialogTop		=	"0vh";
	var status			=	"no";
	var arguments		= "" ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateLinkingCompSelScrMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url	+=	"?comp_id=" + comp_id + "&comp_type=" + comp_type + "&section_hdg_code=" + section_hdg_code + "&comp_prompt=" + escape(comp_prompt) + "&srl_no=" + srlNo;
	retVal = await top.window.showModalDialog(action_url,arguments,features);
	if(retVal=="OK"){}
}
/*function callConditionLookup()
{	
	//var target			= document.forms[0].age_group_code_desc;	
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "";
	var search_desc		= "";
	var title			= getLabel("Common.ApplicableAgeGroup.label","COMMON");
	var sql="SELECT AGE_GROUP_CODE,SHORT_DESC FROM AM_AGE_GROUP where EFF_STATUS=`E` ";
	search_code="AGE_GROUP_CODE";
	search_desc="short_desc";
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.CASectionTemplateDetailForm.age_group_code_desc.value=arr[0];
		document.CASectionTemplateDetailForm.age_group_code.value=arr[1];
		//document.forms[0].age_group_code_desc.focus();
	}	else	
	{
		document.CASectionTemplateDetailForm.age_group_code_desc.value="";
		document.CASectionTemplateDetailForm.age_group_code.value="";
		//target.focus();
	}
}*/
async function callAgeGroups(obj)
{
	if(obj.name=='age_group_code_desc')
		{
			var target  = document.forms[0].age_group_code_desc;
		
			if((target.value) == "null" || (target.value ==""))
			{
				 return false;			
			}
			else
			{
				await callConditionLookup();
			}
		}
		else if(obj.name=='searchCondition')
		{		
			callConditionLookup();
		}
}
async function callConditionLookup()
{
		var target		= document.forms[0].age_group_code_desc;
		var retVal		=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth = "40" ;
		var features	= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title		= getLabel("Common.ApplicableAgeGroup.label","COMMON");
		var sql="SELECT age_group_code code,short_desc description FROM AM_AGE_GROUP  where EFF_STATUS='E' and upper(short_desc) like upper(?) and upper(age_group_code) like upper(?)" ;
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;		
		retArray = await CommonLookup(title,argArray);
		if(retArray != null && retArray !="")
		{
			var ret1=unescape(retArray);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
				document.CASectionTemplateDetailForm.age_group_code_desc.value=arr[1];
				document.CASectionTemplateDetailForm.age_group_code.value=arr[0];				
		}
		else
		{
				document.CASectionTemplateDetailForm.age_group_code_desc.value="";
				document.CASectionTemplateDetailForm.age_group_code.value="";
		}
		
		
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

//showpopulateSections
async function showpopulateSections(sectionObject)
{
	if(sectionObject.name=='sect_name')
	{
		var target  = document.forms[0].sect_name;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			await populateSections();
		}
	}
	else if(sectionObject.name=='section_button')
	{
			await populateSections();
	}
	
}


//populateSections
async function populateSections()
{
	
	var target = document.forms[0].sect_name;	
	var title = getLabel("Common.Section.label","COMMON");
	var sql = "select sec_hdg_code CODE, sec_hdg_desc || ' - ' || NVL(sec_hdr_meta_desc,'') description from ca_section_hdg where eff_status='E' and content_type ='T' and modifiable_yn='Y' and upper(sec_hdg_desc) like upper(?) and sec_hdg_code like upper(?) ";

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "2,1";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = await CommonLookup( title, argArray );
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")	
	{
		document.forms[0].sect_name.value = arr[1];
		document.forms[0].section.value = arr[0];
		callList(document.forms[0].section); 
	}
	else
	{
		document.forms[0].sect_name.value = arr[1];
		document.forms[0].section.value = arr[0];
	}
}

//Function for the file CASectionTemplateDetail.jsp-end


//Function for the file CASectionTemplateCondSearch.jsp-start


async function callfunction()
{
	var target			=parent.frames[1].frames[3].document.forms[0].age_group_code_desc;
	var serviceVal   = parent.frames[1].frames[3].document.forms[0].age_group_code_desc.value;
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= getLabel("eCA.ConditionalCode.label","CA");

	var sql="SELECT AGE_GROUP_CODE code, SHORT_DESC description FROM AM_AGE_GROUP where EFF_STATUS='E'   and upper(short_desc) like upper(?) and upper(AGE_GROUP_CODE) like upper(?) ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "2,1";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = await CommonLookup( title, argArray );
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray !="")	{
		parent.frames[1].frames[3].document.forms[0].age_group_code_desc.value = arr[1];
		parent.frames[1].frames[3].document.forms[0].age_group_code.value = arr[0];
	}else{
		parent.frames[1].frames[3].document.forms[0].age_group_code_desc.value = arr[1];
		parent.frames[1].frames[3].document.forms[0].age_group_code.value = arr[0];
	}
	parent.frames[1].frames[3].document.forms[0].searchCondition.disabled=false;
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}


//Function for the file CASectionTemplateCondSearch.jsp-end



//Function for the file CASectionTemplateShiftRows.jsp-end

function CloseWin()
{

	 
	const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
function subForm(obj)
{
	var obj_val = obj.name;
	var shift_val = document.forms[0].shift_by.value;
	var curr_val  = document.forms[0].curr_value.value;
	if(shift_val !="")
	{
		//window.returnValue=shift_val+"~"+curr_val+"~"+obj_val;				
		//window.close();
		
		
		let dialogBody = parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue =shift_val+"~"+curr_val+"~"+obj_val;
    
    const dialogTag = parent.document.getElementById("dialog_tag");    
    dialogTag.close();  
	}
	else
	{
		//var msg = getCommonMessage('SHOULD_NOT_BE_BLANK');
		//alert(msg);
		var msg=getMessage("ROW_CANNON_BLANK","CA");
		alert(msg);
		document.forms[0].shift_by.focus();
	}
}
function allow_Valid_Number(numberObj, eventObj, maxInt, numberType, numDecimals)
{
	if(numDecimals == null)	numDecimals	=	numberType;
	var count=numberObj.value.length;
	var whichCode = (window.Event) ? eventObj.which : eventObj.keyCode;
	if (parseInt(numberType) == 4)//For Minus and 0-9 Only
	{
		var strCheck = '123456789';
	}
	var fldvalue=numberObj.value;
	var whichCode = (window.Event) ? eventObj.which : eventObj.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;
	var fldValue	=	numberObj.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;
	if(dotIndex!=-1)
		if( fldLength > (dotIndex+numDecimals) ) return false;
	key = String.fromCharCode(whichCode);  // Get key value from key code			
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
} // end of function allow_Valid_Number(numberObj, eventObj, maxInt, numberType)

//Function for the file CASectionTemplateShiftRows.jsp-end


//Function for the file CASectionTemplateFormulaConstruction.jsp-start

var HTMLtext, remVal, j;

	function loadDefault(){
		parent.templateFormulaConstructionFrame.location.href ='../../eCA/jsp/CASectionTemplateFormulaConstruction.jsp?temp=Y';
	}

	function displayValues(){
		
			if (parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i !=0){
				document.getElementById("rese").disabled			= false;
				document.getElementById("remov").disabled			= false;
				document.getElementById("replaceOpt").disabled	= false;
				document.getElementById("replaceRigOpt").disabled = false;
				document.getElementById("replaceRigOpt").checked  = true;
				document.getElementById("replaceLefOpt").disabled = false;
				document.getElementById("validat").disabled		= false;
//				document.getElementById("ok1").disabled			= false;
			}
			HTMLtext='';	

			for(j=1;j<=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;j++){
				var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[j];
				var spli=arrVal.split('|');
				var val=spli[1];
				if (val.indexOf('$')!= -1){
					val=val.replace('$$$','');
					vv=val.split('!');
					val=vv[0];
					//var v=val.length;
				}
				HTMLtext=HTMLtext+" <input type=text id=text"+j+" name="+parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[j]+" id="+parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[j]+" value="+val + " onClick='selectValue(this);' onBlur='catchValue(this);' readonly size="+val.length+">";
			}
			document.getElementById("f").insertAdjacentHTML("BeforeEnd",HTMLtext);
			var o=eval(document.getElementById('text'+parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii));
			if(!o){
				var o=eval(document.getElementById('text'+parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i));
			}
			if(o){
				o.select();
				o.style.background = 'yellow' ;  // c
				o.style.color = 'black' ;      // c
			}
			else return false;
	} 

	function catchValue(obj){
		remVal=obj.name;
		rem=obj.id;
		objplace=obj;
		obj.style.background = 'yellow' ;  // c
		obj.style.color = 'black' ;      // c
	}
	function checkDecimal(obj){}

	function selectValue(obj){
		document.getElementById(rem).style.background="white"; // c
		document.getElementById(rem).style.color="black";      // c 
		obj.style.background="yellow"; // c
		obj.style.color="black";      // c

//		obj.select();
	}

	function onOperation(intvalue){ 
			if (intvalue == '.'){
				var value=document.getElementById("intVal").value;
				var split=value.split('.');
				var nos=split.length;
					if (nos>1){ return false; }
			}
		//document.getElementById("intVal").insertAdjacentText("beforeend",intvalue);
			let elements = document.getElementById('intVal');

			if (elements) {	     
			    elements.innerText += intvalue;  // Append the value
			    elements.value += intvalue;	   
			}
			
	}
	function isOperator(val)
	{
		if(val=='+' || val=='-' || val=='/' || val=='*' || val=='(' || val==')')
			return true;
		return false;
	}
	
	function callOnOk()
	{
		document.forms[0].formulaDefinition.value='';
		var flag=false;
		for(k=1;k<=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;k++)
		{
			var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k];
			var spli=arrVal.split('|');
			var val=spli[1];
			if(!isOperator(val))
			{
				if(flag)
				{  
					alert(getMessage("EXP_INVALID","CA"));
					return;
				}
				flag=true;
			}
			else
			{
				flag=false;
			}
			document.forms[0].formulaDefinition.value=document.forms[0].formulaDefinition.value+val+"~";			
		}
		document.forms[0].defContent.value = document.forms[0].formulaDefinition.value;
		document.forms[0].calledFrom.value = 'OK';
		document.forms[0].submit();		
	}

	function callOnValidate()
	{
		//alert('calling');
		document.forms[0].formulaDefinition.value='';
		var flag=false;
		var arrVal="";
		var spli="";
		var val="";
		for(k=1;k<=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;k++)
		{
			arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k];
			spli=arrVal.split('|');
			val=spli[1];
			if(!isOperator(val))
			{
				if(flag)
				{
					alert(getMessage("EXP_INVALID","CA"));
					return;
				}
				flag=true;
			}
			else
			{
				flag=false;
			}
			val=val+" ";
			document.forms[0].formulaDefinition.value=document.forms[0].formulaDefinition.value+val
		}
		document.forms[0].defContent.value = document.forms[0].formulaDefinition.value;
		document.forms[0].calledFrom.value = 'VALIDATE';
		document.forms[0].submit();
	}
	
	function clearVal(){
		document.forms[0].finVal.value='';
	}

	function newTextInt(obj){
		
		if(obj.value == null || obj.value==''){
			//alert('in if'+top.opener.top.content.name);
			//if(f_query_add_mod != null)
			//var msg = f_query_add_mod.getCAMessage("CA_SEC_FORMULA_VAL");
			//else
			var msg = top.templateFormulaConstructionFrame.getMessage("CA_SEC_FORMULA_VAL","CA");
			alert(msg);
			return false;
		}
		if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked)){
				alert(getMessage("SELECT_ANY_VALUE","CA"));
				
		}else
		{
			if(document.getElementById("replaceOpt").checked)
			{
				var spli=remVal.split('|');
				var index=spli[0];
				var ope=spli[1];
				var value=index+"|"+obj.value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
		}else if(document.getElementById("replaceRigOpt").checked)
		{
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var ope=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.value;
				for(k=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;index<k;k--){
					var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
				}
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
		}else if(document.getElementById("replaceLefOpt").checked){
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var val=spli[1];
				var insVal=index+"|"+obj.value;
				for(k=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;index<k;k--)
				{
					var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
				}
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
		}else{
				/*parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var value=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+"|"+obj.value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i]=value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i; //
				 */		
			parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
			var value=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+"|"+obj.value;
			parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i]=value;
			parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;
			}
//		parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i; //
		loadDefault();
	  }
	}

	function newTextOpe(obj){
		if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked)){
			alert(getMessage("SELECT_ANY_VALUE","CA"));
		}else{
			if(document.getElementById("replaceOpt").checked){
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var value=index+"|"+obj.name;
				objplace.name=value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
			}else if(document.getElementById("replaceRigOpt").checked){
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.name;
				for(k=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;index<k;k--){
					var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
				}
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
			}else if(document.getElementById("replaceLefOpt").checked){
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var insVal=index+"|"+obj.name;
				for(k=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;index<k;k--){
					var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
				}
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
			}else{
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var insVa=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+"|"+obj.name;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i]=insVa;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i; //
			}
//		parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i; //
		loadDefault();
	  }
	}

	 function newTextVal(obj2){
		if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked)){
			alert(getMessage("SELECT_ANY_VALUE","CA"));
		}else{
			if(document.getElementById("replaceOpt").checked){
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var value=index+"|"+obj2;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=value;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
			}else if(document.getElementById("replaceRigOpt").checked){
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj2;
				for(k=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;index<k;k--){
					var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
				}
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
			}else if(document.getElementById("replaceLefOpt").checked){
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var insVal=index+"|"+obj2;
				for(k=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;index<k;k--){
					var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
				}
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[index]=insVal;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=index; //
			}else{
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+1;
				obj2=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i+"|"+obj2;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i]=obj2;
				parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i; //
			}
//			parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.ii=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i; //
			loadDefault();
		}
	}

	function removeValue(){
		if(!remVal){
			parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i-1;
		}else{
			var spli=remVal.split('|');
			var index=spli[0];
			var ope=spli[1];
			for(j=1;j<=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;j++){
				if (index==j){
					for(k=j;k<parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i;k++){
						var arrVal=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k+1];
						var spli=arrVal.split('|');
						var val=spli[1];
						var value=k+'|'+val;
						parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.a[k]=value; 
					}
					break;
				}
			}
			parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i-1;
		}
		loadDefault();
	}

	function onReset(){
		retVal=confirm(getMessage("DELETE_FORMULA_YN","CA"));
		if (retVal==true){
		  parent.document.getElementById('templateFormulaComponentListFrame').contentWindow.i=0;
		  parent.parent.templateFormulaConstructionFrame.location.href='../../eCA/jsp/CASectionTemplateFormulaConstruction.jsp';
		}else{
			return false;
		}
	}

	function radioCheck(obj){
		if(obj.disabled){
			obj.checked=false;
		}else{
			obj.checked=true;
		}	
	}

	function callClose(){	
		window.close(); 
	}
	function changeFormulaType(obj)
	{
		       
       
		if(obj.value == 'D')
		{
		  	if(window.confirm(getMessage("CLEAR","CA")))
		    
			{
				document.CASectionTemplateDetailForm.formula_definition.value="";

			document.CASectionTemplateDetailForm.includeDates.checked = true;
			document.CASectionTemplateDetailForm.includeDates_hiddenfield.value = 'Y';//IN064034
			document.CASectionTemplateDetailForm.includeDates.disabled = true;
			document.getElementById("formulaResultUnitTR").style.display = "none";
			}
			else
				obj.value='N';
		}
		else
		{
            if(window.confirm(getMessage("CLEAR","CA")))
		    
			{
			document.CASectionTemplateDetailForm.formula_definition.value="";
 
			document.CASectionTemplateDetailForm.includeDates.checked = false;
			document.CASectionTemplateDetailForm.includeDates_hiddenfield.value = 'N';//IN064034
			document.CASectionTemplateDetailForm.includeDates.disabled = false;
			}
			else
				obj.value='D';
		}
	}
	function changeSecondComponent(obj)
	{
		if(obj.value == '***CONSTANT***')		
			document.getElementById("constantTR").style= "display";
		else
			document.getElementById("constantTR").style.display = "none";

	}
	function formulaDateCheck(obj,str)
	{
		
		if(obj.checked)
		{
			var msg= parent.parent.f_query_add_mod.getMessage("CLEAR","CA");
		    if(str != 'P' && window.confirm(msg) )
			{
				msg='';
				document.CASectionTemplateDetailForm.formula_definition.value="";
				document.CASectionTemplateDetailForm.includeDates_hiddenfield.value = 'Y';
	 		    document.CASectionTemplateDetailForm.formulaResultUnits.value="Hours";
			    document.getElementById("mand").style = 'display';
			}
		    else
			{
            if(str != 'P')
		    obj.checked= false;	
			}
			
		}
		else
		{ 
			var msg= parent.parent.f_query_add_mod.getMessage("CLEAR","CA");
			if(str != 'P' && window.confirm(msg) )
			{
			document.CASectionTemplateDetailForm.formula_definition.value="";
			document.CASectionTemplateDetailForm.includeDates_hiddenfield.value = 'N';
            document.CASectionTemplateDetailForm.formulaResultUnits.value="";
            document.getElementById("mand").style.display='none';
			}
			else
            {
				if(str != 'P')
				obj.checked = true;
			}
	         
		}

      //  alert(document.CASectionTemplateDetailForm.formula_definition.value);
        
		
		if(document.CASectionTemplateDetailForm.formulaResultType.value == 'N' && obj.checked)
			document.getElementById("formulaResultUnitTR").style= "display";
		else
			document.getElementById("formulaResultUnitTR").style.display = "none";

		
		
	}
	function changeSelectionSelect(obj)
	{
		
		if(obj.value == 'M')
		{
			
			document.getElementById("selectionSelect").disabled = false;
			document.getElementById("acceptOption").disabled = true;
			document.getElementById("acceptOption").value = 'O';
			

			if(document.getElementById("listcheck").value = "List")
            			{
			document.getElementById("column_position").value = "1";
			document.getElementById("column_position").readOnly= true;
			document.getElementById("column_span").value= "3" ;
			document.getElementById("column_span").readOnly= true ;
			
						}


		}
		else
		{
			document.getElementById("selectionSelect").disabled = true;
			document.getElementById("selectionSelect").value = 'S';
			document.getElementById("acceptOption").disabled = false;

		}
		

	}
//Function for the file CASectionTemplateFormulaConstruction.jsp-end

function setIncludeyn(obj)
{
	if(obj.checked == false)
	{
		
   document.CASectionTemplateDetailForm.includeyn.value='N';
	}
	else
	{
     document.CASectionTemplateDetailForm.includeyn.value='Y';
	}

}

// added by DeepaS on 29/08/05 for Linking History Values

//GHL-CRF-0401[IN059630] - Start
function enableResultDispNextLine(obj)
{
	if(obj.checked == false)
	{
		document.CASectionTemplateDetailForm.textAllignYN.value='N';
	}
	else
	{
		document.CASectionTemplateDetailForm.textAllignYN.value='Y';
	}

}
//GHL-CRF-0401[IN059630] - End
async function callOnLinkHistory()
{
	
	var old_hist_time_frame_val =  parent.CASectionTemplateDetailFrame.document.forms[0].old_hist_time_frame_val.value;
	var old_hist_time_frame_unit = parent.CASectionTemplateDetailFrame.document.forms[0].old_hist_time_frame_unit.value;
	var hist_rec_type = parent.CASectionTemplateDetailFrame.document.forms[0].hist_rec_type_hidden.value;
	var event_code = parent.CASectionTemplateDetailFrame.document.forms[0].event_code.value;
	var event_code_type = parent.CASectionTemplateDetailFrame.document.forms[0].event_code_type.value;
	var comp_id = parent.CASectionTemplateDetailFrame.document.forms[0].component_id.value;
	
	var retVal			=	"";
	var dialogHeight	=	"90vh";
	var dialogWidth		=	"56vw";
	var dialogTop		=	"0vh";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	"../../eCA/jsp/CASectionTemplateLinkHistoryDetails.jsp?old_hist_time_frame_val="+old_hist_time_frame_val+"&old_hist_time_frame_unit="+old_hist_time_frame_unit+"&event_code="+event_code+"&event_code_type="+event_code_type+"&hist_rec_type="+hist_rec_type+"&component_id="+comp_id;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	retVal			=	await window.showModalDialog(action_url,arguments,features);
	if(retVal != null)
	{
		var hist_val = retVal.split("~");
		parent.CASectionTemplateDetailFrame.document.forms[0].old_hist_time_frame_unit.value =  hist_val[3];
		parent.CASectionTemplateDetailFrame.document.forms[0].old_hist_time_frame_val.value = hist_val[4];
		parent.CASectionTemplateDetailFrame.document.forms[0].hist_rec_type_hidden.value = hist_val[0];
		parent.CASectionTemplateDetailFrame.document.forms[0].event_code_type.value = hist_val[2];
		parent.CASectionTemplateDetailFrame.document.forms[0].event_code.value = hist_val[1];
	}
	if(retVal == "")
	{
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.hist_def_yn.checked = false;
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.dflt_from_hist_appl_yn.value = "N";
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.disabled = true;
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.old_hist_time_frame_unit.value = "";
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.old_hist_time_frame_val.value = "";
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.hist_rec_type_hidden.value = "";
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.event_code.value = "";
		parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.event_code_type.value = "";
	}

}

function callOnClose(time_frame_value,event_code,event_code_type,hist_rec_type,time_frame_unit)
{
	var hist_val = hist_rec_type+"~"+event_code+"~"+event_code_type+"~"+time_frame_unit+"~"+time_frame_value;
	window.close();
	window.returnValue = hist_val;
}

function callOnOKBtn()
{
	var time_frame_unit = document.CASectionTemplateLinkHistoryForm.linkHistoryResult.value;
	var time_frame_value = document.CASectionTemplateLinkHistoryForm.time_frame_value.value;
	var hist_rec_type = document.CASectionTemplateLinkHistoryForm.histRecTypeHidden.value;
	var event_code = document.CASectionTemplateLinkHistoryForm.clinEventLookUpCodeHidden.value;
	var event_code_type = document.CASectionTemplateLinkHistoryForm.clinEventLookUptypeHidden.value;
	//alert("event_code_type"+event_code_type);

	var hist_val = "";

	if(hist_rec_type != "")
	{
		if(event_code == "")
		{
			
			alert(getMessage("CLIN_EVENT_BLANK","CA"));
			return;
		}
	}

	if(hist_rec_type != "" && event_code != "")
	{
		if(time_frame_value == "")
		{			
			alert(getMessage("TIME_FRAME_VAL_BLANK","CA"));
			return;
		}
		if(time_frame_unit == "")
		{
			
			alert(getMessage("TIME_FRAME_UNIT_BLANK","CA"));
			return;
		}
	}	

	if(time_frame_unit !="")
	{
		hist_val = hist_rec_type+"~"+event_code+"~"+event_code_type+"~"+time_frame_unit+"~"+time_frame_value;
	}
	window.close();
	window.returnValue = hist_val;
}

function enableHistBtn(obj)
{
	if(obj.checked == true){
	parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.disabled = false;
	document.CASectionTemplateDetailForm.dflt_from_hist_appl_yn.value = "Y";
	}
	else
	{
		if(document.CASectionTemplateDetailForm.hist_rec_type_hidden.value != "")
		{
			var confirm_msg = window.confirm(parent.parent.f_query_add_mod.getMessage("CLEAR_HIST_VALS","CA"));
			if(confirm_msg)
			{
				parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.disabled = true;
				document.CASectionTemplateDetailForm.dflt_from_hist_appl_yn.value = "N";
				document.CASectionTemplateDetailForm.hist_rec_type_hidden.value = '';
				document.CASectionTemplateDetailForm.event_code.value = '';
				document.CASectionTemplateDetailForm.old_hist_time_frame_val.value = '';
				document.CASectionTemplateDetailForm.old_hist_time_frame_unit.value = '';			
			}
			else
			{
				obj.checked = true;
			}
		}
		else
		{
			parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.disabled = true;
			document.CASectionTemplateDetailForm.dflt_from_hist_appl_yn.value = "N";
		}
	}
}


function openClinEventWindow(objCode)
{
	if(objCode.name=='clinEventLookUpTxt')
	{
		if((objCode.value) == "null" || (objCode.value ==""))
		{
				return false;			
		}
		else
		{
			openClinEventWin();
		}
	}
	else if(objCode.name=='clinEventLookUpBtn')
	{
		openClinEventWin();
	}
}

async function openClinEventWin()
{
	var hist_rec_type = document.CASectionTemplateLinkHistoryForm.histRecTypeHidden.value;
	var locale=document.CASectionTemplateLinkHistoryForm.locale.value;	
	var retVal			=  new String();	
	var target=document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.value;	//alert(target);
	var dialogHeight ='72vh' ;
	var dialogWidth = '45vw' ;
	var dialogTop	= '0vh';
	var dialogLeft = '0vw' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+";status=no";
	var arguments		= "" ;
	var search_desc		= "";
	var search_code		= "";
	var code_type		= "";
	var title			= getLabel("eCA.ClinicalEvents.label","CA");
	
	//IN040006 - Start commenetd and included next line
	//var sql = "SELECT a.SHORT_DESC, EVENT_CODE, EVENT_CODE_TYPE FROM CR_CLN_EVT_MST_LANG_VW a,AM_DISCR_MSR s where a.HIST_REC_TYPE=`"+hist_rec_type+"`AND nvl(a.STATUS,`E`)=`E` and a.language_id = `"+locale+"` and a.EVENT_CODE=s.DISCR_MSR_ID and s.RESULT_TYPE in (`I`,`N`,`E`,`D`,`L`,`C`,`T`,`H`) ";
	var sql = "SELECT a.SHORT_DESC, a.EVENT_CODE, a.EVENT_CODE_TYPE FROM ca_event_hist_rec_vw a where a.HIST_REC_TYPE=`"+hist_rec_type+"` AND  a.language_id = `"+locale+"` ";
	//IN040006 - End
	
	search_code="a.EVENT_CODE";
	search_desc="a.SHORT_DESC";
	code_type="a.EVENT_CODE_TYPE";
	var event_array = new Array();
	retVal = await top.window.showModalDialog("../../eCA/jsp/SectionTemplateEventSearch.jsp?SQL="+sql+"&search_code="+search_code+"&text_Val="+target+"&search_desc="+search_desc+"&code_type="+code_type+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);	
	if(retVal != null)
	{
		retVal = unescape(retVal);
		event_array = retVal.split("::");
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.value = event_array[1];
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpCodeHidden.value = event_array[0];
		document.CASectionTemplateLinkHistoryForm.clinEventLookUptypeHidden.value = event_array[2];
	}
	else
	{
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.value = "";
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpCodeHidden.value = "";
	}
}

function setHiddenVal(obj)
{
	if(obj.value!= '')
	{
		document.CASectionTemplateLinkHistoryForm.histRecTypeHidden.value = obj.value;
		//document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.readOnly = false;
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.value = "";
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpCodeHidden.value = "";
		document.CASectionTemplateLinkHistoryForm.time_frame_value.value = '';
		document.CASectionTemplateLinkHistoryForm.linkHistoryResult.value = '';
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpBtn.disabled = false;
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.readOnly = false;
		document.CASectionTemplateLinkHistoryForm.mand_img.style= "display";
	}
	else
	{
		document.CASectionTemplateLinkHistoryForm.histRecTypeHidden.value = '';
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.value = '';
		document.CASectionTemplateLinkHistoryForm.time_frame_value.value = '';
		document.CASectionTemplateLinkHistoryForm.linkHistoryResult.value = '';
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpTxt.readOnly = true;
		document.CASectionTemplateLinkHistoryForm.clinEventLookUpBtn.disabled = true;
		document.CASectionTemplateLinkHistoryForm.mand_img.style.display = "none";
	}
}

function defaultTimeVal(obj)
{
	if(obj.value != "")
	{
		if(document.CASectionTemplateLinkHistoryForm.time_frame_value.value == "" && document.CASectionTemplateLinkHistoryForm.linkHistoryResult.value == "L")
		{
			document.CASectionTemplateLinkHistoryForm.time_frame_value.value = "1";
		}
	}
}

function checkForZero(obj)
{
	if(obj.value != "")
	{
		if(obj.value == "0")
		{
			alert(f_query_add_mod.getMessage("TIME_FRAME_VAL_BLANK","CA"));
			//alert(f_query_add_mod.getMessage("TIME_FRAME_VAL_ZERO"));
			obj.value = "";
			obj.focus();
			return;
		}
	}
}

function CheckForPromptSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*!#$%^&()+,./:<>?{}[]`~@| ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function chopText(elem,limit)
{
	if(elem.value.length>limit)
	{
		elem.value=elem.value.substring(0,limit);
		var msg = getMessage("ONLY_MAX_CHARS","CA");
		msg =msg.replace('$$','100');
		alert(msg);
		//alert('You  are not allowed to enter more than 100 characters');
	}
}

function templateCalendarValidate(str,chkYN)
{ 
	var obj_name = "";
	if(str.indexOf("(") != -1)
		obj_name = str.substring(0, str.indexOf("("));
	else
		obj_name = str;	
	if(eval(document.getElementById(obj_name).length) == null)
		str = obj_name;
	var flg = "";
	if(chkYN == "N"){
		flg = showCalendar(str);
	}else if(chkYN == "Y"){
		flg = showCalendar(str,null,'hh:mm');
	}
	eval(document.getElementById(str).focus());
	return flg;
}


function callCheckDateTime(dateTimeObj)
{
	if(checkIsNull(dateTimeObj)) 
	{
		//messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
		return false;
	}

	if(doDateTimeChk(dateTimeObj)==false)
	{
		parent.messageframe.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		dateTimeObj.select();
		dateTimeObj.focus();
		return false;
	}
	else
	{
		parent.messageframe.location.href = "../../eCA/jsp/CAError.jsp";
	}
}


function callCheckTime(timeObj)
{
	if(checkIsNull(timeObj)) 
	{
		//messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
		return false;
	}

	if(chkTime(timeObj.value)==false)
	{
		var msg = getMessage("INVALID_TIME_FMT","CA");
		parent.messageframe.location.href = "../../eCA/jsp/CAError.jsp?err_num="+msg;
		timeObj.select();
		timeObj.focus();
		return false;
	}
	else
	{
		parent.messageframe.location.href = "../../eCA/jsp/CAError.jsp";
	}
}


function checkValidRange(numObj, grid_min_max_id)
{	
	if(CheckNum(numObj)==false)
		return false;
	if(checkIsNull(numObj))
		return false;
	var min_max_obj;
	var	min_max_value	=	"",	min_num_value	=	0,	max_num_value	=	0;
	var min_max_array	=	new Array();	
	min_max_obj	=	eval("document.RecClinicalNotesTemplateForm.min_max" + numObj.name);
	if(grid_min_max_id != null)
	{		
		var temp_obj = eval(document.getElementById('grid_min_max_id'));		
		if(temp_obj.length == null)
			min_max_value	=	temp_obj.value;
		else
			min_max_value	=	temp_obj(0).value;
	}
	else
	{	
		min_max_value	=	min_max_obj.value;
	}
	min_max_array	=	min_max_value.split("|");
	min_num_value	=	min_max_array[0];
	max_num_value	=	min_max_array[1];		
	entered_value	=	numObj.value;
	if(entered_value=="") entered_value = "0";
	//alert("entered_value : "+entered_value);	
	//alert("min_num_value : "+min_num_value);	
	//alert("max_num_value : "+max_num_value);	
	if(parseFloat(max_num_value)==0) return false;

	if( parseFloat(entered_value)<parseFloat(min_num_value) || parseFloat(entered_value)>parseFloat(max_num_value) )
	{
		var msg = getMessage("MIN_MAX_VALUE_RANGE ","CA");
		 msg =msg.replace('(1)',min_num_value);
		 msg =msg.replace('(2)',max_num_value);
		 alert(msg);

		//alert("APP-0001 Entered value should be between "+min_num_value+" and "+max_num_value);
		numObj.select();
		numObj.focus();
		return false;
	}
}


function CheckMaximumLength(comp_prompt,comp_id,max_length,messageFrame)
{
	messageFrame = messageFrameReference;
	comp_prompt	=	comp_prompt.replace("+"," ");
	if(max_length==0) return false;
	
	if(!(CheckMaxLen(comp_prompt,comp_id,max_length,messageFrame)))
	{
		comp_id.select();
		comp_id.focus();
		return false;
	}
}


function callMeForStandardLinking()
{
	if(parent.parent.RecClinicalNotesHeaderFrame != null)
	{
		var patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		var encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		if(patient_id != "")
		{
			/* added  on 5/10/05 for matrix component for linking the standard components */

				var matrix_std_values = "";
				var matrix_std_component_information = "";
				
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names!=null)
			{
				var matrix_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names.value;
	
				var matrix_std_values = "";
				var matrix_std_component_information = "";
				var matrix_name_temp = matrix_names.split("|");

				if(matrix_names != "")
				{
					for(var i=0;i<matrix_name_temp.length;i++)
					{
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_std_component_information_"+matrix_name_temp[i])!=null)
						{
							matrix_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_std_component_information_"+matrix_name_temp[i] + ".value");

							if(matrix_std_component_information == "")
								matrix_std_component_information = matrix_std_values;
							else
								matrix_std_component_information += "~"+matrix_std_values;
						}
					}
				}
			}
			// ends here
			
			// added on 06/10/05 for Grid Component for linking the standard cmponent

			var grid_std_values = "";
			var grid_std_component_information = "";
			
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names!=null)
			{
			var grid_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names.value;

			var grid_name_temp = grid_names.split("|");
			
			if(grid_names != "")
				{
					for(var i=0;i<grid_name_temp.length;i++)
					{
							
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i])!=null)
						{
							grid_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i]+".value");
							
							if(grid_std_component_information == "")
								grid_std_component_information = grid_std_values;
							else
								grid_std_component_information += "~"+grid_std_values;
						}
					}
				}
			}
			// ends here

			var std_component_information = document.RecClinicalNotesTemplateForm.std_component_information.value;

			if(std_component_information != ""){
				if(matrix_std_component_information!="")
					std_component_information += "~"+ matrix_std_component_information ;
				if(grid_std_component_information!="")
					std_component_information += "~" + grid_std_component_information;
				else
						std_component_information += grid_std_component_information;
			}
			else{
				std_component_information = matrix_std_component_information;

				if(matrix_std_component_information!="" && grid_std_component_information!="")
					std_component_information += "~" +grid_std_component_information;
				else
					std_component_information += grid_std_component_information;
			}

			var action_url = '../../eCA/jsp/RecClinicalNotesStdCompLinking.jsp?std_component_information=' + escape(std_component_information) + "&patient_id=" + patient_id+"&encounter_id="+encounter_id;	
			messageFrameReference.document.location = action_url;
		}
	}
}


function checkIsNull(obj)
{
	if(trimCheck(obj.value)=='')
		return true;
	else
		return false;
}
async function callTitleText()
{
	var section_code = parent.frames[0].document.forms[0].section.value;
	
	var action_url='../../eCA/jsp/CASectionTemplateMessageFrame.jsp';
	var retVal	=	"";
	var dialogHeight= "30" ; //Updated by Arvind @ 09-12-08
	var dialogWidth	= "40" ;
	var title = getLabel("Common.TITLE.label","COMMON");
	var arguments	= "Message" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal = await window.showModalDialog("../../eCA/jsp/CASectionTemplateMessageFrame.jsp?label_type=T&title="+encodeURIComponent(title,"UTF-8")+"&section_code="+section_code,arguments,features);
	if(retVal!=null)
	{
		document.CASectionTemplateDetailForm.title_text_code.value=retVal[0];
		document.CASectionTemplateDetailForm.title_text.value=retVal[1];
	}
}
async function callDialogPrompt()
{
	var comp_id = document.forms[0].component.value;
	var comp_desc = document.forms[0].comp_desc.value;

	if(comp_id=="")
		return false
	else
	{
	
		var title			= getLabel("Common.Prompt.label","Common");
		var comp_id = document.forms[0].component.value;
		var action_url='../../eCA/jsp/CASectionTemplateMessageFrame.jsp';
		var retVal	=	"";
		var dialogHeight= "500px" ; //Updated by Arvind @ 09-12-08
		var dialogWidth	= "700px" ;
		var arguments	= "Message" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
		retVal = await window.showModalDialog("../../eCA/jsp/CASectionTemplateMessageFrame.jsp?title="+encodeURIComponent(title,"UTF-8")+"&label_type=P&comp_id="+comp_id+"&comp_desc="+comp_desc,arguments,features);	
		if(retVal!=null)
		{
			document.CASectionTemplateDetailForm.component_prompt.value=retVal[0];
			document.CASectionTemplateDetailForm.component_promptdiag.value=retVal[1];
		}
	}
}


async function callDialogHint()
{
	var comp_id = document.forms[0].component.value;
	var comp_desc = document.forms[0].comp_desc.value;

	var title			= getLabel("eCA.HintMessage.label","CA");
	/*if(comp_id=="")
	{
		var msg=getMessage("SECTION_NOT_BLANK","CA");
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}*/
	if(comp_id=="")
		return false
	else
	{
		var action_url='../../eCA/jsp/CASectionTemplateMessageFrame.jsp';
		var retVal	=	"";
		var dialogHeight= "90vh" ;//updated by Arvind @ 09-12-08
		var dialogWidth	= "70vw" ;
		var arguments	= "Message" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
		retVal = await window.showModalDialog("../../eCA/jsp/CASectionTemplateMessageFrame.jsp?title="+encodeURIComponent(title,"UTF-8")+"&label_type=H&comp_id="+comp_id+"&comp_desc="+comp_desc,arguments,features);	
		if(retVal!=null)
		{
			document.CASectionTemplateDetailForm.hintMessage.value=retVal[0];
			document.CASectionTemplateDetailForm.hintMessagediag.value=retVal[1];
		}
	}
}
function closewPromthnt(obj1,obj2)
	  {
		var obj =new Array();
		obj2 = obj2.replace("~","'");
		obj[0]=obj1;
		obj[1]=obj2;
		let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = obj;
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	  }
//IN061907 start
function callDiagnosis(hist_rec_type)
{
	if(hist_rec_type.value == "DIAG")
	{
		document.getElementById("result_auto_fill").style = 'display';

	}
	else
	{
		document.getElementById("result_auto_fill").style.display = 'none';


	
	}
}

function enableAutoResult(obj)
{
	if(obj.checked == false)
	{
		document.CASectionTemplateDetailForm.autoResultYN.value='N';
	}
	else
	{
		document.CASectionTemplateDetailForm.autoResultYN.value='Y';
	}

}

function callOnLoadDiagResult()
{
	if(document.forms[0].hist_rec_type.value=="DIAG")
	{
		document.getElementById("result_auto_fill").style = 'display';

	}
	else
	{
		document.getElementById("result_auto_fill").style.display = 'none';

	}
}
//IN061907 ends


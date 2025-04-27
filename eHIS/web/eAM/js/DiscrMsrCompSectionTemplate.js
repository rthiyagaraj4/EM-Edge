function Record(operation_mode) 
{
	var msg="";
	if(parent.frames[0].document.forms[0].section.disabled==true)
	{	
		parent.frames[0].document.forms[0].section.disabled=false;
	}
    var operation	=	document.forms[0].operation;
	var section=parent.frames[0].document.forms[0].section;
	var item_type=document.forms[0].item_type;
	var row_position=document.forms[0].row_position;
	var column_position=document.forms[0].column_position;
	var column_span=document.forms[0].column_span;
	var component=document.forms[0].component;
	var title_text=document.forms[0].title_text;
	parent.frames[3].document.forms[0].section.value=section.value;   
	parent.frames[3].document.forms[0].hitem_type.value=parent.frames[3].document.forms[0].item_type.value;   
	if(operation.value=="modify")
	{
		parent.frames[0].document.forms[0].section.disabled=true;
		if(operation_mode=="Delete")
			operation.value		=	"Delete";		
	}
	var f=parent.parent.frames[2];
//	var f=top.messageframe;
	if(item_type.value=="C")
	{
		var fields= new Array (section,item_type,component,row_position,column_position,column_span);
		var names= new Array (getLabel("Common.Section.label","Common"),
							 getLabel("Common.Itemtype.label","Common"),
							 getLabel("Common.Component.label","Common"),
							 getLabel("Common.RowPosition.label","Common"),
							 getLabel("Common.ColumnPosition.label","Common"),
							 getLabel("Common.ColumnSpan.label","Common")
								);
	}
	else if(item_type.value=="T")
	{
		var fields= new Array (section,item_type,title_text,row_position,column_position,column_span);
		var names= new Array (getLabel("Common.Section.label","Common"),
							 getLabel("Common.Itemtype.label","Common"),
							 getLabel("Common.TitleText.label","Common"),
							 getLabel("Common.RowPosition.label","AM"),
							 getLabel("Common.ColumnPosition.label","Common"),
							 getLabel("Common.ColumnSpan.label","Common")
								);
	}
	//alert(parent.frames[1].document.forms[0].hitem_type.value);	

	if(parent.frames[1].checkFieldsofMst(fields,names,parent.parent.frames[2] ) )
	{
		if((parseInt(column_position.value)==2) && (parseInt(column_span.value)>2))
		{
			//alert(getMessage("COLSPAN_MORE_2"));
			msg=getMessage("COLSPAN_MORE_2","AM");
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			column_span.focus();
			column_span.select();
			return true;
		}
		if((parseInt(column_position.value)==3) && (parseInt(column_span.value)>1))
		{	
			//alert(getMessage("COLSPAN_MORE_1"));
			 msg=getMessage("COLSPAN_MORE_1","AM");
			parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			column_span.focus();
			column_span.select();
			return true;
		}
		document.forms[0].target=parent.parent.messageFrame.name;
		document.forms[0].submit();
	}
}
function showSectionTemplate()
{
	
	var section=parent.frames[0].document.forms[0].section.value;
	if(section=="")
	{
		//alert(getMessage("SECTION_BLANK"));
		var msg=getMessage("SECTION_BLANK","AM");
		parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}
	var retVal			=	"";
	var dialogHeight	=	"400px";
	var dialogWidth		=	"700px";
	var dialogTop		=	"10px";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesTemplateMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?sec_hdg_code="+section+"&operation_mode=TemplateView";
	//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	retVal			=	window.showModalDialog(action_url,arguments,features);
	
}

function callComponentLookup(calledFrom)
{
	var comp_id			=	document.CAComponentLookUpCriteriaForm.comp_id;
	var comp_prompt		=	document.CAComponentLookUpCriteriaForm.comp_prompt;
	var comp_type		=	document.CAComponentLookUpCriteriaForm.comp_type;

	var	action_url		=	"../../eAM/jsp/DiscrMsrCompLookupResult.jsp";
	var HTMLVal			=	"<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='CompLookupInputForm' id='CompLookupInputForm' method='POST' action='"+action_url+"'>"+
							"<input type='hidden' name='comp_id' id='comp_id' value='"+comp_id.value+"'>"+
							"<input type='hidden' name='comp_prompt' id='comp_prompt' value='"+comp_prompt.value+"'>"+
							"<input type='hidden' name='comp_type' id='comp_type' value='"+comp_type.value+"'>"+
							"<input type='hidden' name='calledFrom' id='calledFrom' value='"+calledFrom+"'>"+
							"</form></body></html>";

	parent.CAComponentFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.CAComponentFrame.document.CompLookupInputForm.submit();
/*
	document.CAComponentLookUpCriteriaForm.action	=	"../../eCA/jsp/CAComponentLookUp.jsp";
	document.CAComponentLookUpCriteriaForm.target	=	parent.CAComponentFrame.name;
	document.CAComponentLookUpCriteriaForm.method	=	"POST";
	document.CAComponentLookUpCriteriaForm.submit();
*/
}


function reset() {
	top.frames[1].frames[1].frames[1].frames[0].location.href="../../eCA/jsp/CASectionTemplateHeader.jsp";
	top.frames[1].frames[1].frames[1].frames[1].location.href="../../eCommon/html/blank.html";
	top.frames[1].frames[1].frames[1].frames[2].location.href="../../eCommon/html/blank.html";
	top.frames[1].frames[1].frames[1].frames[3].location.href="../../eCommon/html/blank.html";
//	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";

//	alert()
	//frames[0].name);
//	alert(top.frames[1].frames[1].frames[2].name)
//	top.frames[1].frames[1].frames[1].frames[0].document.forms[0].reset();
//	top.frames[1].frames[1].frames[1].frames[1].document.forms[0].reset();
//	CASectionTemplateDetailFrame.forms[0].reset();
//	CASectionTemplateHeaderFrame.forms[0].reset();

}
//function called from on click of the formula definition button.
async function callOnFormulaDefinition()
{
	//var clipBoardVal=document.forms[0].formulaDefinitionBtn.createTextRange();
	//clipBoardVal.select();
	//clipBoardVal.execCommand("copy","","");

	var section=parent.frames[0].document.forms[0].section.value;
	if(section=="")
	{
		var msg=getMessage("SECTION_BLANK","AM");
		parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return true;
	}
	var retVal			=	"";
	var dialogHeight	=	"400px";
	var dialogWidth		=	"700px";
	var dialogTop		=	"10px";
	var status			=	"no";
	var arguments		=	parent.CASectionTemplateDetailFrame.document.forms[0].formula_definition.value ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateFormulaMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?sec_hdg_code="+section;

	//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	//document.forms[0].component.focus();
	retVal = await window.showModalDialog(action_url,arguments,features);
	if(retVal!=null)
	{
		parent.CASectionTemplateDetailFrame.document.forms[0].formula_definition.value = retVal;
		parent.CASectionTemplateDetailFrame.document.forms[0].component_type.value = "F";
	}
}
function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*%~!#$%^&(){}[]?/.,;:|<>=+- ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}



//Function for the file CAComponentLookUp.jsp-start

function closewjj(obj1,obj2,obj3)
{
	while(obj2.indexOf("+")!=-1)
	{
		obj2	=	obj2.replace("+"," ");
	}
	var obj =new Array();
	obj[0]=obj1;
	obj[1]=obj2;
	obj[2]=obj3;
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = obj;
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
		parent.frames[1].location.href="CASectionTemplateList.jsp?section="+section;
		parent.frames[2].location.href="CASectionTemplatePreview.jsp";
		parent.frames[3].location.href="CASectionTemplateDetail.jsp";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else
	{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		parent.frames[2].location.href="../../eCommon/html/blank.html";
		parent.frames[3].location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}	
}

//Function for the file CASectionTemplateHeader.jsp-end


//Function for the file CASectionTemplateList.jsp-start

function sendtoDetail ( item_type ,title_value, comp_id, comp_prompt, row_pos_no, column_pos_no, no_of_col_span, prompt_display_loc, srl_no,comp_type ,age_group_code,hist_rec_type)
{
	//alert(1);
	//comp_prompt=comp_prompt.replace("+"," ");
	//alert("title_value : "+title_value);
	//title_value = document.forms[0].temp_title_value.value;
	/*********************************************************
	//Checking the bean status before opening the page for modification  
	**********************************************************/
	var previous_comp_type = parent.CASectionTemplateDetailFrame.document.CASectionTemplateDetailForm.component_type.value;
	if(previous_comp_type=="L" || previous_comp_type=="C")
	{
		var check =confirm("This Operation will clear all the fields associations done \n Do u want to continue?");
		if(!check)
		{
			return;
		}
	}
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	parent.frames[0].document.forms[0].section.disabled=true;
	var sectionCode= parent.frames[0].document.forms[0].section.value;
	parent.frames[3].location.href="../../eCA/jsp/CASectionTemplateDetail.jsp?item_type="+escape(item_type)+"&title_value="+escape(title_value)+"&comp_id="+comp_id+"&comp_prompt="+escape(comp_prompt)+"&row_pos_no="+row_pos_no+"&column_pos_no="+column_pos_no+"&no_of_col_span="+no_of_col_span+"&prompt_display_loc="+prompt_display_loc+"&srl_no="+srl_no+"&comp_type="+comp_type+"&operation=modify&section="+sectionCode+"&age_group_code="+age_group_code+"&hist_rec_type="+hist_rec_type;
	
}
function PopUpShiftRow(obj)
{
	var section			=	parent.frames[0].document.forms[0].section.value;
	var retVal			=	"";
	var dialogHeight	=	"400px";
	var dialogWidth		=	"700px";
	var dialogTop		=	"10px";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateShiftRows.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url			+=	"?curr_row_num="+obj+"&operation_mode=ShiftRow";
	//window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	retVal			=	window.showModalDialog(action_url,arguments,features);
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


function checkRecord(obj){
	if(obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body class=MESSAGE onKeyDown = 'lockKey()'><form name='tempForm' id='tempForm' method='post' action='CASectionTemplateCondSearch.jsp'><input type=hidden name='conditionid' id='conditionid' value='"+obj.value+"'> </form></body></html>"
					top.frames[1].frames[1].frames[2].document.write(HTMLVal);
					top.frames[1].frames[1].frames[2].document.tempForm.submit();
	}
}
function checkForMinus(obj)
{
	if(obj.value.indexOf("-")!=-1)
	{
		//alert("APP-CA00034 Negative values are not allowed");
		alert(getMessage("AM0155","AM"));
		obj.focus();
		obj.select();
		return false;
	}
	return true;
}
async function callComponent()
{
	var action_url='../../eCA/jsp/CAComponentLookUpMain.jsp';
	var retVal	=	"";//= 	new String();
	var dialogHeight= '85%' ;
	var dialogWidth	= '95%' ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal = await window.showModalDialog("../../eCA/jsp/CAComponentLookUpMain.jsp?",arguments,features);	
	//retVal = window.open(action_url,null,"height=400,width=790,top=170,left=0,status=NO,toolbar=no,menubar=no,location=no");
	if(retVal!=null)
	{
		document.forms[0].component.value=retVal[0];
		document.forms[0].component_prompt.value=retVal[1];				
		if(retVal[2]=="Long Text" || retVal[2]=="Embedded Component" || retVal[2] == "Grid Component" || retVal[2] == "Matrix Component")
		{			
			document.forms[0].column_span.value="3";
			document.forms[0].column_position.value="1";
			document.forms[0].column_span.readOnly=true;
			document.forms[0].column_position.readOnly=true;
			if(retVal[2]=="Embedded Component" || retVal[2] == "Grid Component" || retVal[2] == "Matrix Component")
			{
				if(retVal[2]=="Matrix Component")
					document.forms[0].component_type.value = "X";
				else if(retVal[2] == "Grid Component")
					document.forms[0].component_type.value = "R";
				document.forms[0].hist_rec_type.disabled = true;
			}
			else
				document.forms[0].hist_rec_type.disabled = false;
		}		
		else
		{
			document.forms[0].column_span.value="";
			document.forms[0].column_span.readOnly=false;
			document.forms[0].column_position.value="";
			document.forms[0].column_position.readOnly=false;
			document.forms[0].hist_rec_type.disabled = true;
		}
		if(retVal[2]=="Formula")
		{
			document.forms[0].formulaDefinitionBtn.style.display='inline';
			callOnFormulaDefinition();
		}
		else
		{
			document.forms[0].formulaDefinitionBtn.style.display='none';
		}
	}
}
function callMandatory(obj)
{
	//parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeMstCodeError.jsp?err_num=";
	if(obj.value=="C")	{
		document.forms[0].mand1.style.visibility='hidden';
		document.forms[0].mand2.style.visibility='visible';
		document.forms[0].title_text.disabled=true;
		document.forms[0].component.disabled=false;
		document.forms[0].title_text.value="";
		document.forms[0].search.disabled=false;
		document.forms[0].searchCondition.disabled=false;
		//document.forms[0].disp_position.remove(2); 
		document.forms[0].disp_position.remove(1); 
		document.forms[0].disp_position.selectedIndex=0;
		document.forms[0].age_group_code_desc.disabled = false;
	}
	else if(obj.value=="T")	{
		document.forms[0].mand2.style.visibility='hidden';
		document.forms[0].mand1.style.visibility='visible';
		document.forms[0].title_text.disabled=false;
		document.forms[0].component.disabled=true;
		document.forms[0].age_group_code_desc.disabled = true;
		document.forms[0].age_group_code_desc.value = "";
		document.forms[0].search.disabled=true;
		document.forms[0].searchCondition.disabled=true;
		document.forms[0].component.value="";
		document.forms[0].component_prompt.value="";
		document.forms[0].column_span.value="";
		document.forms[0].column_position.value="";
		document.forms[0].column_span.readOnly=false;
		document.forms[0].column_position.readOnly=false;
		var opt=document.createElement('OPTION'); 
		opt.text	=	"Center"; 
		opt.value	=	"C"; 
		document.forms[0].disp_position.add(opt); 
		document.forms[0].formulaDefinitionBtn.style.display='none';
		document.forms[0].hist_rec_type.disabled = true;
	}
  
}
function chkValue(obj)
{
	var msg="";
	//top.messageframe.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	if(obj.value!="")
	{
		var obj1 = parseInt(obj.value);
		if(obj1<1 || obj1>3)
		{
			if(obj.name=="column_span")
			{
				//alert(getMessage("COLSPAN_BTW_1_3"));
				msg=getMessage("COLSPAN_BTW_1_3","AM");
				//top.messageframe.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				top.frames[1].frames[1].frames[2].href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
			else if(obj.name=="column_position")
			{
				//alert(getMessage("COLPOS_BTW_1_3"));
				msg=getMessage("COLPOS_BTW_1_3","AM");
				//top.messageframe.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
				top.frames[1].frames[1].frames[2].href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			}
			obj.focus();
			obj.select();
		}
		else
		{
			//top.messageframe.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			top.frames[1].frames[1].frames[2].href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
	}

}

function callforPrompt(obj)
{
	if(document.forms[0].operation.value!="modify")
	{
		document.forms[0].column_span.value="";
		document.forms[0].column_position.value="";
	}
	document.forms[0].component_prompt.value="";
	document.forms[0].column_span.readOnly=false;
	if(obj.value!="")
	{
		obj.value=obj.value.toUpperCase();
		comp_id = obj.value;
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='DummySectionTemplate' id='DummySectionTemplate' method='post' action='../../eCA/jsp/CAGetComponentPrompt.jsp'><input type='hidden' name='comp_id' id='comp_id' value='"+comp_id+"'></form></body></html>";
		parent.Dummy_frame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.Dummy_frame.document.DummySectionTemplate.submit();
	}else
	{
		//top.messageframe.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		top.content.master_pages.messageFrame.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
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
		parent.frames[1].location.href='../../eCA/jsp/CASectionTemplateDetail.jsp';
}
function getCancel()
{
	parent.frames[0].document.forms[0].section.disabled=false;
	//parent.frames[1].location.href='../../eCA/jsp/CASectionTemplateDetail.jsp';
	//parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	//parent.location.href='../../eCommon/html/blank.html';
	parent.frames[3].location.href="CASectionTemplateDetail.jsp";
	parent.frames[2].location.href="CASectionTemplatePreview.jsp";
	parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
async function callOnLinking(section_hdg_code,comp_id,comp_type,comp_prompt,srlNo)
{
	var retVal			=	"";
	var dialogHeight	=	"400px";
	var dialogWidth		=	"700px";
	var dialogTop		=	"10px";
	var status			=	"no";
	var arguments		= "" ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateLinkingCompSelScrMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	action_url	+=	"?comp_id=" + comp_id + "&comp_type=" + comp_type + "&section_hdg_code=" + section_hdg_code + "&comp_prompt=" + escape(comp_prompt) + "&srl_no=" + srlNo;
	retVal = await window.showModalDialog(action_url,arguments,features);
	if(retVal=="OK"){}
}
function callConditionLookup()
{
	//var target			= document.forms[0].age_group_code_desc;
	var retVal			=  new String();
	var dialogTop		= "40px";
	var dialogHeight	= "400px" ;
	var dialogWidth		= "700px" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= encodeURIComponent(getLabel("Common.ApplicableAgeGroup.label","Common"));
	var sql="SELECT AGE_GROUP_CODE,SHORT_DESC FROM AM_AGE_GROUP where EFF_STATUS=`E` ";
	search_code="AGE_GROUP_CODE";
	search_desc="short_desc";
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.forms[0].age_group_code_desc.value=arr[0];
		document.forms[0].age_group_code.value=arr[1];
		//document.forms[0].age_group_code_desc.focus();
	}	else	
	{
		document.forms[0].age_group_code_desc.value="";
		document.forms[0].age_group_code.value="";
		//target.focus();
	}
}


//Function for the file CASectionTemplateDetail.jsp-end


//Function for the file CASectionTemplateCondSearch.jsp-start

async function callfunction()
{
	var target			=parent.frames[1].frames[3].document.forms[0].age_group_code_desc;
	var serviceVal   = parent.frames[1].frames[3].document.forms[0].age_group_code_desc.value;
	var retVal			=  new String();
	var dialogTop	= "10px";
	var dialogHeight	= "400px" ;
	var dialogWidth= "700px" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var title			= encodeURIComponent(getLabel("eAM.ConditionalCode.label","AM"));

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
	if(retArray != null && retArray !="")	{
		parent.frames[1].frames[3].document.forms[0].age_group_code_desc.value = retArray[1];
		parent.frames[1].frames[3].document.forms[0].age_group_code.value = retArray[0];
	}else{
		parent.frames[1].frames[3].document.forms[0].age_group_code_desc.value = "";
		parent.frames[1].frames[3].document.forms[0].age_group_code.value = "";
	}
	parent.frames[1].frames[3].document.forms[0].searchCondition.disabled=false;
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}


//Function for the file CASectionTemplateCondSearch.jsp-end



//Function for the file CASectionTemplateShiftRows.jsp-end

function CloseWin()
{
	window.close();
}
function subForm(obj)
{
	var obj_val = obj.name;
	var shift_val = document.forms[0].shift_by.value;
	var curr_val  = document.forms[0].curr_value.value;
	if(shift_val !="")
	{
		window.returnValue=shift_val+"~"+curr_val+"~"+obj_val;				
		window.close();
	}
	else
	{
		//var msg = getCommonMessage('SHOULD_NOT_BE_BLANK');
		//alert(msg);
		//alert("APP-000001 Row Position cannot be blank...");
		var msg1 = getMessage('CAN_NOT_BE_BLANK','Common');
		msg1 = msg1.replace('$',getLabel("Common.RowPosition.label","Common"));
		alert(msg1);
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
		parent.parent.templateFormulaConstructionFrame.location.href ='../../eCA/jsp/CASectionTemplateFormulaConstruction.jsp?temp=Y';
	}

	function displayValues(){
		
			if (parent.parent.templateFormulaComponentListFrame.i !=0){
				document.getElementById('rese').disabled			= false;
				document.getElementById('remov').disabled			= false;
				document.getElementById('replaceOpt').disabled	= false;
				document.getElementById('replaceRigOpt').disabled = false;
				document.getElementById('replaceRigOpt').checked  = true;
				document.getElementById('replaceLefOpt').disabled = false;
				document.getElementById('validat').disabled		= false;
//				document.getElementById('ok1').disabled			= false;
			}
			HTMLtext='';	

			for(j=1;j<=parent.parent.templateFormulaComponentListFrame.i;j++){
				var arrVal=parent.parent.templateFormulaComponentListFrame.a[j];
				var spli=arrVal.split('|');
				var val=spli[1];
				if (val.indexOf('$')!= -1){
					val=val.replace('$$$','');
					vv=val.split('!');
					val=vv[0];
					//var v=val.length;
				}
				HTMLtext=HTMLtext+" <input type=text id=text"+j+" name="+parent.parent.templateFormulaComponentListFrame.a[j]+" id="+parent.parent.templateFormulaComponentListFrame.a[j]+" value="+val + " onClick='selectValue(this);' onBlur='catchValue(this);' readonly size="+val.length+">";
			}
			document.getElementById('f').insertAdjacentHTML("BeforeEnd",HTMLtext);
			var o=eval(document.getElementById('text')+parent.parent.templateFormulaComponentListFrame.ii);
			if(!o){
				var o=eval(document.getElementById('text')+parent.parent.templateFormulaComponentListFrame.i);
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
		//alert('to check :'+rem);
		var a = document.getElementById(rem).style.background = "white"; // c
    var a = document.getElementById(rem).style.color = "black";      // c 
		obj.style.background="yellow"; // c
		obj.style.color="black";      // c
//		obj.select();
	}

	function onOperation(intvalue){ 
			if (intvalue == '.'){
				var value=document.getElementById('intVal').value;
				var split=value.split('.');
				var nos=split.length;
					if (nos>1){ return false; }
			}
		document.forms[0].finVal.insertAdjacentText("BeforeEnd",intvalue);				
	
	}
	function isOperator(val)
	{
		if(val=='+' || val=='-' || val=='/' || val=='*' || val=='(' || val==')')
			return true;
		return false;
	}
	
	function callOnOk(){
		document.forms[0].formulaDefinition.value='';
		var flag=false;
		for(k=1;k<=parent.parent.templateFormulaComponentListFrame.i;k++)
		{
			var arrVal=parent.parent.templateFormulaComponentListFrame.a[k];
			var spli=arrVal.split('|');
			var val=spli[1];
			if(!isOperator(val))
			{
				if(flag)
				{
					//alert("APP-00023 Expression is Invalid");
					alert(getMessage("AM0128","AM"));

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

	function callOnValidate(){
		document.forms[0].formulaDefinition.value='';
		var flag=false;
		var arrVal="";
		var spli="";
		var val="";
		for(k=1;k<=parent.parent.templateFormulaComponentListFrame.i;k++)
		{
			arrVal=parent.parent.templateFormulaComponentListFrame.a[k];
			spli=arrVal.split('|');
			val=spli[1];
			if(!isOperator(val))
			{
				if(flag)
				{
					//alert("APP-00023 Expression is Invalid");
					alert(getMessage("AM0128","AM"));

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
			var msg = getMessage("CA_SEC_FORMULA_VAL","CA");
			alert(msg);
			return false;
		}
		if(!remVal &&( document.getElementById('replaceOpt').checked || document.getElementById('replaceRigOpt').checked || document.getElementById('replaceLefOpt').checked)){
				//alert('Select Any Value');
				alert(getMessage("AM0113","AM"));

		}else
		{
			if(document.getElementById('replaceOpt').checked)
			{
				var spli=remVal.split('|');
				var index=spli[0];
				var ope=spli[1];
				var value=index+"|"+obj.value;
				parent.parent.templateFormulaComponentListFrame.a[index]=value;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
		}else if(document.getElementById('replaceRigOpt').checked)
		{
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var ope=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.value;
				for(k=parent.parent.templateFormulaComponentListFrame.i;index<k;k--){
					var arrVal=parent.parent.templateFormulaComponentListFrame.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.templateFormulaComponentListFrame.a[k]=value; 
				}
				parent.parent.templateFormulaComponentListFrame.a[index]=insVal;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
		}else if(document.getElementById('replaceLefOpt').checked){
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var val=spli[1];
				var insVal=index+"|"+obj.value;
				for(k=parent.parent.templateFormulaComponentListFrame.i;index<k;k--)
				{
					var arrVal=parent.parent.templateFormulaComponentListFrame.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.templateFormulaComponentListFrame.a[k]=value; 
				}
				parent.parent.templateFormulaComponentListFrame.a[index]=insVal;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
		}else{
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var value=parent.parent.templateFormulaComponentListFrame.i+"|"+obj.value;
				parent.parent.templateFormulaComponentListFrame.a[parent.parent.templateFormulaComponentListFrame.i]=value;
				parent.parent.templateFormulaComponentListFrame.ii=parent.parent.templateFormulaComponentListFrame.i; //
		}
//		parent.parent.templateFormulaComponentListFrame.ii=parent.parent.templateFormulaComponentListFrame.i; //
		loadDefault();
	  }
	}

	function newTextOpe(obj){
		if(!remVal &&( document.getElementById('replaceOpt').checked || document.getElementById('replaceRigOpt').checked || document.getElementById('replaceLefOpt').checked)){
			//alert('Select Any Value');
			alert(getMessage("AM0113","AM"));
		}else{
			if(document.getElementById('replaceOpt').checked){
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var value=index+"|"+obj.name;
				objplace.name=value;
				parent.parent.templateFormulaComponentListFrame.a[index]=value;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
			}else if(document.getElementById('replaceRigOpt').checked){
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.name;
				for(k=parent.parent.templateFormulaComponentListFrame.i;index<k;k--){
					var arrVal=parent.parent.templateFormulaComponentListFrame.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.templateFormulaComponentListFrame.a[k]=value; 
				}
				parent.parent.templateFormulaComponentListFrame.a[index]=insVal;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
			}else if(document.getElementById('replaceLefOpt').checked){
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var insVal=index+"|"+obj.name;
				for(k=parent.parent.templateFormulaComponentListFrame.i;index<k;k--){
					var arrVal=parent.parent.templateFormulaComponentListFrame.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.templateFormulaComponentListFrame.a[k]=value; 
				}
				parent.parent.templateFormulaComponentListFrame.a[index]=insVal;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
			}else{
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var insVa=parent.parent.templateFormulaComponentListFrame.i+"|"+obj.name;
				parent.parent.templateFormulaComponentListFrame.a[parent.parent.templateFormulaComponentListFrame.i]=insVa;
				parent.parent.templateFormulaComponentListFrame.ii=parent.parent.templateFormulaComponentListFrame.i; //
			}
//		parent.parent.templateFormulaComponentListFrame.ii=parent.parent.templateFormulaComponentListFrame.i; //
		loadDefault();
	  }
	}

	 function newTextVal(obj2){
		if(!remVal &&( document.getElementById('replaceOpt').checked || document.getElementById('replaceRigOpt').checked || document.getElementById('replaceLefOpt').checked)){
			//alert('Select Any Value');
			alert(getMessage("AM0113","AM"));
		}else{
			if(document.getElementById('replaceOpt').checked){
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var value=index+"|"+obj2;
				parent.parent.templateFormulaComponentListFrame.a[index]=value;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
			}else if(document.getElementById('replaceRigOpt').checked){
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj2;
				for(k=parent.parent.templateFormulaComponentListFrame.i;index<k;k--){
					var arrVal=parent.parent.templateFormulaComponentListFrame.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.templateFormulaComponentListFrame.a[k]=value; 
				}
				parent.parent.templateFormulaComponentListFrame.a[index]=insVal;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
			}else if(document.getElementById('replaceLefOpt').checked){
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var insVal=index+"|"+obj2;
				for(k=parent.parent.templateFormulaComponentListFrame.i;index<k;k--){
					var arrVal=parent.parent.templateFormulaComponentListFrame.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.templateFormulaComponentListFrame.a[k]=value; 
				}
				parent.parent.templateFormulaComponentListFrame.a[index]=insVal;
				parent.parent.templateFormulaComponentListFrame.ii=index; //
			}else{
				parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i+1;
				obj2=parent.parent.templateFormulaComponentListFrame.i+"|"+obj2;
				parent.parent.templateFormulaComponentListFrame.a[parent.parent.templateFormulaComponentListFrame.i]=obj2;
				parent.parent.templateFormulaComponentListFrame.ii=parent.parent.templateFormulaComponentListFrame.i; //
			}
//			parent.parent.templateFormulaComponentListFrame.ii=parent.parent.templateFormulaComponentListFrame.i; //
			loadDefault();
		}
	}

	function removeValue(){
		if(!remVal){
			parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i-1;
		}else{
			var spli=remVal.split('|');
			var index=spli[0];
			var ope=spli[1];
			for(j=1;j<=parent.parent.templateFormulaComponentListFrame.i;j++){
				if (index==j){
					for(k=j;k<parent.parent.templateFormulaComponentListFrame.i;k++){
						var arrVal=parent.parent.templateFormulaComponentListFrame.a[k+1];
						var spli=arrVal.split('|');
						var val=spli[1];
						var value=k+'|'+val;
						parent.parent.templateFormulaComponentListFrame.a[k]=value; 
					}
					break;
				}
			}
			parent.parent.templateFormulaComponentListFrame.i=parent.parent.templateFormulaComponentListFrame.i-1;
		}
		loadDefault();
	}

	function onReset(){
		//retVal=confirm("Do You Want to Delete Entire Formula");
		retVal=confirm(getMessage("AM0112","AM"));
		if (retVal==true){
		  parent.parent.templateFormulaComponentListFrame.i=0;
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

//Function for the file CASectionTemplateFormulaConstruction.jsp-end




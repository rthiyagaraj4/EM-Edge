/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
//Global Variables
var function_id = "";
var message = "";
function create() 
{
	f_query_add_mod.location.href = "../../eOR/jsp/TemplateMain.jsp?mode=1&function_id="+function_id;
	isCreate = "Y";
}

function selectTemplateType()
{
	var selectObj = document.getElementsByTagName("SELECT").item(0);
	var selIndex = document.templateTypeForm.templateTypeSelect.selectedIndex;
	var selOptionValue = selectObj.options(document.templateTypeForm.templateTypeSelect.selectedIndex).text;
	if(selOptionValue == "Title")
	{
		parent.parent.templateAssociateFrame.templateTypeSelectedFrame.location.href="../../eOR/jsp/TemplateTitleText.jsp";
	}
	else
	{
		parent.parent.templateAssociateFrame.templateTypeSelectedFrame.location.href="../../eOR/jsp/TemplateDiscreteMeasure.jsp";	
	}
}

function clearAll()
{
	parent.parent.parent.templateDescriptionFrame.document.templateDescriptionForm.templateID.value = "";
	parent.parent.parent.templateDescriptionFrame.document.templateDescriptionForm.templateName.value = "";

	parent.parent.templateAssociateFrame.templateAddModifyFrame.document.templateAddModifyForm.templatePrompt.value = "";
	parent.parent.templateAssociateFrame.templateAddModifyFrame.document.templateAddModifyForm.templateRowPosition.value = "";
	parent.parent.templateAssociateFrame.templateAddModifyFrame.document.templateAddModifyForm.templateColumnPosition.value = "";
	parent.parent.templateAssociateFrame.templateAddModifyFrame.document.templateAddModifyForm.templateColumnSpan.value = "";

	if(checkIsValidForClear())
	{
		parent.parent.templateAssociateFrame.templateTypeSelectedFrame.document.templateTitleTextForm.templateTitleText.value = "";
	}
	else
	{
		parent.parent.templateAssociateFrame.templateTypeSelectedFrame.document.templateDiscreteMeasureForm.templateDiscreteMeasure.value = "";
	}
}

function reset()
{
	f_query_add_mod.location.href = "../../eOR/jsp/TemplateMain.jsp?mode=1&function_id="+function_id;
}

function apply()
{
	alert("Applied...");
}

function query()
{
}

function deleterecord()
{
}
function checkIsValidForClear()
{
	 var url = parent.parent.templateAssociateFrame.templateTypeSelectedFrame.location.href;
	 url = url.toLowerCase();
	 if( url.indexOf("titletext.jsp") != -1 )
		{
			return true;
		}
	 else
		{
 		 	return false;
		}
}

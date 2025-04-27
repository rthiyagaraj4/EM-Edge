/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function ButtonOnSelectStart()
{
	window.event.returnValue = false;
}

function ButtonOnDragStart()
{
	window.event.returnValue = false;
}

function ButtonOnMouseDown(divObj)
{
	var id = divObj.id.substring(11,divObj.id.length);
	ButtonPushButton(id);
}

function ButtonOnMouseUp(divObj)
{
	var id = divObj.id.substring(11,divObj.id.length);
	ButtonReleaseButton(id);
}

function ButtonOnMouseOut(divObj)
{
	var id = divObj.id.substring(11,divObj.id.length);
	ButtonReleaseButton(id);
}

function ButtonOnMouseOver(divObj)
{
	var id = divObj.id.substring(11,divObj.id.length);
	ButtonReleaseButton(id);
	divObj.className = "ButtonMouseOver";
}

function ButtonPushButton(id)
{
	/*document.all["PAD1_PREFIX_" + id].width = 3;
	document.all["PAD1_PREFIX_" + id].height = 3;
	document.all["PAD2_PREFIX_" + id].width = 1;
	document.all["PAD2_PREFIX_" + id].height = 1;
	document.all["BUTTON_DIV_" + id].className = "ButtonPressed";*/
	
	document.getElementById("PAD1_PREFIX_" + id).style.width = 3;
	document.getElementById("PAD1_PREFIX_" + id).style.height = 3;
	document.getElementById("PAD2_PREFIX_" + id).style.width = 1;
	document.getElementById("PAD2_PREFIX_" + id).style.height = 1;
	document.getElementById("BUTTON_DIV_" + id).className = "ButtonPressed";
}

function ButtonReleaseButton(id)
{
	/*document.all["PAD1_PREFIX_" + id].width = 2;
	document.all["PAD1_PREFIX_" + id].height = 2;
	document.all["PAD2_PREFIX_" + id].width = 2;
	document.all["PAD2_PREFIX_" + id].height = 2;
	document.all["BUTTON_DIV_" + id].className = "ButtonNormal";*/
	
	document.getElementById("PAD1_PREFIX_" + id).style.width = 2;
	document.getElementById("PAD1_PREFIX_" + id).style.height = 2;
	document.getElementById("PAD2_PREFIX_" + id).style.width = 2;
	document.getElementById("PAD2_PREFIX_" + id).style.height = 2;
	document.getElementById("BUTTON_DIV_" + id).className = "ButtonNormal";
}

function ButtonOnClick(divObj)
{
	var id = divObj.id.substring(11,divObj.id.length);
}

function ButtonOnDblClick(divObj)
{
	ButtonOnClick(divObj);
}

function  EditorGetHTML(editorObjName)
{
	EditorCleanHTML(editorObjName);

	var  obj;
	
	if(editorObjName!=undefined)
	{
		obj = eval("self.RTEditor"+editorObjName).document.body;
	}
	else
	{
		obj = self.RTEditor0.document.body;
	}
	
	return obj.innerHTML;
}

function  EditorSetHTML(html,editorObjName)
{
	if(editorObjName!=undefined)
	{

		eval("self.RTEditor"+editorObjName).document.body.insertAdjacentHTML("AfterBegin",html);
		changeFormatMode(editorObjName);
	}
	else
	{

		self.RTEditor0.document.body.insertAdjacentHTML("AfterBegin",html);
		changeFormatMode();
	}	
}

function EditorOnCut(id,editorObjName)
{
	EditorFormat(id, "cut",null,editorObjName);
}

function EditorOnCopy(id,editorObjName)
{
	var copiedTxt;
	
	if(editorObjName!=undefined)
	{
		obj = eval("self.RTEditor"+editorObjName);		
		copiedTxt = obj.document.selection.createRange();
		copiedTxt.execCommand("Copy");
	}
	else
	{	
		copiedTxt = self.RTEditor0.document.selection.createRange();
		copiedTxt.execCommand("Copy");
	}
}

function EditorOnPaste(id,editorObjName)
{
	if(editorObjName!=undefined)
	{
		obj= eval("self.RTEditor"+editorObjName); 
		obj.document.body.focus();
		obj.document.execCommand("paste");		
	}
	else
	{
		self.RTEditor0.document.body.focus();
		self.RTEditor0.document.execCommand("paste");
	}
}

function EditorOnBold(id,editorObjName)
{
	EditorFormat(id, "bold",null,editorObjName);
}

function EditorOnItalic(id,editorObjName)
{
	EditorFormat(id, "italic",null,editorObjName);
}

function EditorOnUnderline(id,editorObjName)
{
	EditorFormat(id, "underline",null,editorObjName);
}

function EditorOnUndo(id,editorObjName)
{
	EditorFormat(id, "Undo",null,editorObjName);
}

function EditorOnRedo(id,editorObjName)
{
	EditorFormat(id, "Redo",null,editorObjName);
}

function EditorOnClear(id,editorObjName)
{
	EditorFormat(id, "Clear",null,editorObjName);
}

async function EditorOnForegroundColor(id,editorObjName)
{
	var dialogHeight = '10';
	var dialogWidth = '30';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:no;';
	var color = '';
	color = await window.showModalDialog('../../eCommon/html/ColorTable.html',arguments,features);
	if (color) 
	{
		EditorFormat(id, "forecolor", color,editorObjName);
	}
	else 
	{
		setEditorFocus(editorObjName);
	}
}

async function EditorOnBackgroundColor(id,editorObjName)
{
	var dialogHeight = '10';
	var dialogWidth = '30';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:no;';
	var color = '';
	color = await window.showModalDialog('../../eCommon/html/ColorTable.html',arguments,features);
	if (color) {
		EditorFormat(id, "backcolor", color,editorObjName);
	}
	else {
		setEditorFocus(editorObjName);
	}
}

function EditorOnAlignLeft(id,editorObjName)
{
	EditorFormat(id, "justifyleft",null,editorObjName);
}

function EditorOnCenter(id,editorObjName)
{
	EditorFormat(id, "justifycenter",null,editorObjName);
}

function EditorOnAlignRight(id,editorObjName)
{
	EditorFormat(id, "justifyright",null,editorObjName);
}

function EditorOnNumberedList(id,editorObjName)
{
	EditorFormat(id, "insertOrderedList",null,editorObjName);
}

function EditorOnBullettedList(id,editorObjName)
{
	EditorFormat(id, "insertUnorderedList",null,editorObjName);
}

function EditorOnDecreaseIndent(id,editorObjName)
{
	EditorFormat(id, "outdent",null,editorObjName);
}

function EditorOnIncreaseIndent(id,editorObjName)
{
	EditorFormat(id, "indent",null,editorObjName);
}



function EditorOnFont(id, select,editorObjName)
{
	EditorFormat(id, "fontname", select[select.selectedIndex].value,editorObjName);
	select.selectedIndex = 0;
	setEditorFocus(editorObjName);
}

function EditorOnSize(id, select,editorObjName)
{
	EditorFormat(id, "fontsize", select[select.selectedIndex].value,editorObjName);
	select.selectedIndex = 0;
	setEditorFocus(editorObjName);
}



function EditorCleanHTML(editorObjName)
{
	var fonts;
	
	if(editorObjName!=undefined)
	{
		obj = eval("self.RTEditor"+editorObjName);
		fonts = obj.document.body.all.tags("FONT");
	}
	else
	{
		fonts = self.RTEditor0.document.body.all.tags("FONT");		
	}
	for (var i = fonts.length - 1; i >= 0; i--) {
		var font = fonts[i];
		if (font.style.backgroundColor == "#ffffff") {
		font.outerHTML = font.innerHTML;
		}
	}
}

function EditorGetElement(tagName, start)
{
	while (start && start.tagName != tagName) {
		start = start.parentElement;
	}
	return start;
}

//function clearEditorContent(editorObjName)
function clearEditorContent(editorObjName,readOnly)
{
    var html = "";
    
    if(editorObjName!=undefined)
    {
    	obj = eval("RTEditor"+editorObjName);
    	obj.document.open;
    	obj.document.write(html);
    	obj.document.close();
    	if(readOnly != 'Y')
    		obj.document.body.contentEditable = "TRUE";
    }
    else
    {	
	    RTEditor0.document.open();
	    RTEditor0.document.write(html);
	    RTEditor0.document.close();
	    if(readOnly == 'Y')
	    	RTEditor0.document.designMode = "ON";
    }
}

function callInstantiateEditor(obj,editorObjName,readOnly)
{	
	if(editorObjName!=undefined)
	{
		instantiateEditor(editorObjName,readOnly);
		setTimeout(function(){EditorSetHTML(obj.value,editorObjName)},100);
		//setTimeout(function(){changeFormatMode(editorObjName)},200);
	}
	else
	{
		instantiateEditor(null,readOnly);
		setTimeout(function(){EditorSetHTML(obj.value)},100);
		//setTimeout("changeFormatMode()",200);
	}
}

function instantiateEditor(editorObjName,readOnly)
{	
    var obj;
    var html = "";
    
    if(editorObjName!=undefined)
    {    	 
        html +="<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>";
        html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";
        html +="<body  style=\"font:10pt arial\">";    
        html +="</body>";
    	obj = eval("document.RTEditor"+editorObjName);
    }
    else
    {    	
        html +="<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>";
        html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";
        html +="<body onKeyDown =\"lockKey()\" style=\"font:10pt arial\">";    
        html +="</body>";
    	obj = RTEditor0;  	
    }
    
    obj.document.open();
    obj.document.write(html);
    obj.document.close();

    if(editorObjName!=undefined)
    {
    	if(readOnly != 'Y')
    	obj.document.body.contentEditable = "TRUE";
    }
    else
    {
    	if(readOnly == 'Y')
    	obj.document.designMode = "ON";
    }
}

function changeFormatMode(editorObjName)
{
	//document.getElementById("format_mode").value = "Address";
	//EditorOnParagraph("0",formatObj,editorObjName);

	if(editorObjName != undefined)
	{
		formatObj = document.getElementById("format_mode"+editorObjName);
	}
	else
	{
		formatObj = document.getElementById("format_mode");
	}
	formatObj.value = "Address";

    EditorOnParagraph("0",formatObj,editorObjName);
	//setEditorFocus(editorObjName);
}

function EditorOnParagraph(id, select,editorObjName)
{
	if(editorObjName == undefined)
	{
		setEditorFocus(editorObjName);
	}
	
	EditorFormat(id, "formatBlock", select[select.selectedIndex].value,editorObjName);
	select.selectedIndex = 0;
}

function EditorFormat(id, what, opt, editorObjName)
{
	if (opt == "removeFormat") {
		what = opt;
		opt = null;
	}

	if (opt == null) 
	{
		if(what != "Clear")
		{
			if(editorObjName!=undefined)
			{		
				obj = eval("self.RTEditor"+editorObjName);	
				obj.document.execCommand(what);
			}
			else
			{
				self.RTEditor0.document.execCommand(what);				
			}			
		}
		else 
		{
			var txtRange;
			var html = "";
			if(editorObjName!=undefined)
			{
				obj = eval("self.RTEditor"+editorObjName)
				txtRange = obj.document.body.createTextRange();
				html +="<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>";
				html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>"
				html +="<body style=\"font:10pt arial\" >";	
				html +="</body>";
			}
			else
			{
				txtRange = self.RTEditor0.document.body.createTextRange();
				html +="<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>";
				html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>"
				html +="<body  onKeyDown =\"lockKey()\" style=\"font:10pt arial\" >";	
				html +="</body>";
			}
			if (txtRange != null)
				txtRange.execCommand('Delete');
						
			EditorSetHTML(html,editorObjName);
		}
	}
	else 
	{
		if(editorObjName!=undefined)
		{
			eval("self.RTEditor"+editorObjName).document.execCommand(what, "", opt);
		}
		else
		{
			self.RTEditor0.document.execCommand(what, "", opt);
		}		
	}
}

function setEditorFocus(editorObjName)
{
	if(navigator.appVersion.indexOf("MSIE 6.")!=-1)
	{
	    if(editorObjName!=undefined)
	    {
	    	eval("document.RTEditor"+editorObjName).focus();
	    }
	    else
	    {
	    	RTEditor0.focus();
	    }
	}
	else
	{
		if(editorObjName!=undefined)
		{
			eval("document.RTEditor"+editorObjName).focus();	
		}
		else
		{
			self.RTEditor0.focus();		
		}
	}
}

function editorOnSave(catalog_code)
{
	saveCurrentContent(catalog_code);
}


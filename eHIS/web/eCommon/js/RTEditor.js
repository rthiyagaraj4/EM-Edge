/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
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
	document.all["PAD1_PREFIX_" + id].width = 3;
	document.all["PAD1_PREFIX_" + id].height = 3;
	document.all["PAD2_PREFIX_" + id].width = 1;
	document.all["PAD2_PREFIX_" + id].height = 1;
	document.all["BUTTON_DIV_" + id].className = "ButtonPressed";
}

function ButtonReleaseButton(id)
{
	document.all["PAD1_PREFIX_" + id].width = 2;
	document.all["PAD1_PREFIX_" + id].height = 2;
	document.all["PAD2_PREFIX_" + id].width = 2;
	document.all["PAD2_PREFIX_" + id].height = 2;
	document.all["BUTTON_DIV_" + id].className = "ButtonNormal";
}

function ButtonOnClick(divObj)
{
	var id = divObj.id.substring(11,divObj.id.length);
}

function ButtonOnDblClick(divObj)
{
	ButtonOnClick(divObj);
}

function  EditorGetHTML()
{
	EditorCleanHTML();
	return self.RTEditor0.document.body.innerHTML;
}

function  EditorSetHTML(html)
{
	if(html==null)
	{
		html	=	document.getElementById("plainmsg").innerHTML;
		if( (document.getElementById("plainmsg").innerText!="") && (navigator.appVersion.indexOf("MSIE 6.")==-1) )
		{
			html	+=	"<BR>";
		}
	}
	self.RTEditor0.document.body.insertAdjacentHTML("AfterBegin",html);
	changeFormatMode();
}

function EditorOnCut(id)
{
	EditorFormat(id, "cut");
}

function EditorOnCopy(id)
{
	EditorFormat(id, "copy");
}

function EditorOnPaste(id)
{
	EditorFormat(id, "paste");
}

function EditorOnBold(id)
{
	EditorFormat(id, "bold");
}

function EditorOnItalic(id)
{
	EditorFormat(id, "italic");
}

function EditorOnUnderline(id)
{
	EditorFormat(id, "underline");
}

function EditorOnUndo(id)
{
	EditorFormat(id, "Undo");
}

function EditorOnRedo(id)
{
	EditorFormat(id, "Redo");
}

function EditorOnClear(id)
{
	EditorFormat(id, "clear");
}

async function EditorOnForegroundColor(id)
{
	var dialogHeight = '40vh';
	var dialogWidth = '55vw';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:no;';
	var color = '';
	color =await top.window.showModalDialog('../../eCommon/html/ColorTable.html',arguments,features);
	if (color) 
	{
		EditorFormat(id, "forecolor", color);
	}
	else 
	{
		setEditorFocus();
	}
}

async function EditorOnBackgroundColor(id)
{
	var dialogHeight = '40vh';
	var dialogWidth = '55vw';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:no;';
	var color = '';
	color =await top.window.showModalDialog('../../eCommon/html/ColorTable.html',arguments,features);
	if (color) {
		EditorFormat(id, "backcolor", color);
	}
	else {
		setEditorFocus();
	}
}

function EditorOnAlignLeft(id)
{
	EditorFormat(id, "justifyleft");
}

function EditorOnCenter(id)
{
	EditorFormat(id, "justifycenter");
}

function EditorOnAlignRight(id)
{
	EditorFormat(id, "justifyright");
}

function EditorOnNumberedList(id)
{
	EditorFormat(id, "insertOrderedList");
}

function EditorOnBullettedList(id)
{
	EditorFormat(id, "insertUnorderedList");
}

function EditorOnDecreaseIndent(id)
{
	EditorFormat(id, "outdent");
}

function EditorOnIncreaseIndent(id)
{
	EditorFormat(id, "indent");
}

function EditorOnParagraph(id, select)
{
	EditorFormat(id, "formatBlock", select[select.selectedIndex].value);
	select.selectedIndex = 0;
	//setEditorFocus();
}

function EditorOnFont(id, select)
{
	EditorFormat(id, "fontname", select[select.selectedIndex].value);
	select.selectedIndex = 0;
	setEditorFocus();
}

function EditorOnSize(id, select)
{
	EditorFormat(id, "fontsize", select[select.selectedIndex].value);
	select.selectedIndex = 0;
	setEditorFocus();
}

function EditorFormat(id, what, opt)
{
//	alert("Inside Editor Format : id : "+id+" what : "+what+" opt : "+opt);
	if (opt == "removeFormat") {
		what = opt;
		opt = null;
	}
	if (opt == null) 
	{
		if(what != "clear")
		{
		self.RTEditor0.document.execCommand(what);
		}
		else 
		{
		/*var txtRange = self.RTEditor0.document.body.createTextRange();
		if (txtRange != null)
			txtRange.execCommand('Delete');*/
			var txtRange = self.RTEditor0;
			if(txtRange.document.body.innerText.length > 0)
				{
				txtRange.document.body.innerText = "" ;
				}
			if (txtRange.document.body.children.length > 0) {
		        // Remove all children
		        while (txtRange.document.body.firstChild) {
		        	txtRange.document.body.removeChild(txtRange.document.body.firstChild);
		        }
		    } 
		/*var html = "";
		html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>"
		html +="<body  onKeyDown =\"lockKey()\" style=\"font:10pt arial\" >";
		html +="<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>";
		html +="</body>";*/
			var html = "";
			html += "<style type='text/css'>ADDRESS { FONT-FAMILY: Arial; FONT-SIZE: 10pt; font-style: NORMAL; COLOR: BLACK; }</style>";
			html += "<body id='editor' contenteditable='true' onkeydown='lockKey(); handleKeyDown(event); handleBackspace(event);' style='font: 10pt arial;'>";
			html += "<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>";
			html += "</body>";

		EditorSetHTML(html);
		}
	}
	else 
	{
		self.RTEditor0.document.execCommand(what, "", opt);
	}
}

function EditorCleanHTML()
{
	var fonts = self.RTEditor0.document.getElementsByTagName("FONT");
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

function instantiateEditor()
{
   /* var html = "";
    html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";
    html +="<body id='editor' contenteditable='true' onKeyDown ='lockKey(); handleKeyDown(event);' style=\"font:10pt arial\">";
    html +="<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>";
    html +="</body>";*/
	var html = "";
	html += "<style type='text/css'>ADDRESS { FONT-FAMILY: Arial; FONT-SIZE: 10pt; font-style: NORMAL; COLOR: BLACK; }</style>";
	html += "<body id='editor' contenteditable='true' onkeydown='lockKey(); handleKeyDown(event); if (event.key === 'Backspace') {handleBackspace(event);}' style='font: 10pt arial;'>";
	html += "<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><SCRIPT language='javascript' src='../../eCommon/js/RTEditor.js'></SCRIPT>";
	html += "</body>";

    RTEditor0.document.open();
    RTEditor0.document.write(html);
    RTEditor0.document.close();
    RTEditor0.document.designMode = "ON";
}

function callInstantiateEditor() 
{
    instantiateEditor();
    setTimeout("EditorSetHTML();",100);
	setTimeout("changeFormatMode();",200);
}

function changeFormatMode()
{
    document.getElementById("format_mode").value = "Address";
    EditorOnParagraph("0",document.getElementById("format_mode"));
	setEditorFocus();
}

function setEditorFocus()
{
	if(navigator.appVersion.indexOf("MSIE 6.")!=-1)
	{
	    RTEditor0.focus();
	}
	else
	{
		if(self.RTEditor0!=undefined)
			self.RTEditor0.focus();
	}
}
//Below Function is Added for Edge Conversion By Arun.M
function handleKeyDown1(event) {
    // Handle the Enter key
    if (event.key === 'Enter') {
        event.preventDefault(); // Prevent default behavior of inserting a new block element
        
        // Insert a line break
        const selection = window.getSelection();
        const range = selection.getRangeAt(0);
        const br = document.createElement('br');
        
        // Insert the <br> tag to create a new line
        range.deleteContents();
        range.insertNode(br);
        
        // Move the cursor to the new line after the <br>
        range.setStartAfter(br);
        range.setEndAfter(br);
        selection.removeAllRanges();
        selection.addRange(range);
    }
}
/*function handleKeyDown(event) {
    // Handle the Enter key
    if (event.key === 'Enter') {
        event.preventDefault(); // Prevent default behavior of inserting a new block element
        
        // Insert a line break
        const selection = window.getSelection();
        const range = selection.getRangeAt(0);
        const br = document.createElement('br');
        
        // Insert the <br> tag to create a new line
        range.deleteContents();
        range.insertNode(br);
        
        // Move the cursor to the new line after the <br>
        range.setStartAfter(br);
        range.setEndAfter(br);
        selection.removeAllRanges();
        selection.addRange(range);
    }
}*/
/*function handleKeyDown(event) {
    const selection = window.getSelection();
    const range = selection.getRangeAt(0);
    
    // Handle the Enter key
    if (event.key === 'Enter') {
        event.preventDefault(); // Prevent default behavior of inserting a new block element

        const br = document.createElement('br');
        
        // Insert the <br> tag to create a new line
        range.deleteContents();
        range.insertNode(br);
        
        // Move the cursor to the new line after the <br>
        range.setStartAfter(br);
        range.setEndAfter(br);
        selection.removeAllRanges();
        selection.addRange(range);
    }
    
    // Handle the Backspace key
    else if (event.key === 'Backspace') {
        const selectedText = selection.toString();
        
        // If there's selected content, delete it
        if (selectedText.length > 0) {
            event.preventDefault();  // Prevent the default Backspace behavior (deleting content directly)
            range.deleteContents();  // Delete the selected content
        }
        
        // If nothing is selected, check if the cursor is at the start of a block
        else {
            const currentNode = range.startContainer;

            // If the current node is a block element (like a paragraph or div), we can prevent Backspace from collapsing content
            if (currentNode.nodeType === Node.ELEMENT_NODE && currentNode.nodeName === "P" && currentNode.textContent.trim() === "") {
                event.preventDefault();  // Prevent Backspace from collapsing empty block elements
                currentNode.remove();  // Remove empty block element
            }
        }
    }
}
*/


function handleKeyDown(event) {
    const selection = window.getSelection();
    const range = selection.getRangeAt(0);
    
    // Handle the Enter key
    if (event.key === 'Enter') {
        event.preventDefault(); // Prevent default behavior of inserting a new block element

        const br = document.createElement('br');
        
        // Insert the <br> tag to create a new line
        range.deleteContents();
        range.insertNode(br);
        
        // Move the cursor to the new line after the <br>
        range.setStartAfter(br);
        range.setEndAfter(br);
        selection.removeAllRanges();
        selection.addRange(range);
    }

    // Handle the Backspace key
    else if (event.key === 'Backspace') {
        const selectedText = selection.toString();
        
        // If there's selected content, delete it
        if (selectedText.length > 0) {
            event.preventDefault();  // Prevent the default Backspace behavior (deleting content directly)
            range.deleteContents();  // Delete the selected content
        }
        else {
            const currentNode = range.startContainer;

            // If the cursor is at the start of an empty block (like an empty <p> or <div>), we delete it
            if (currentNode.nodeType === Node.ELEMENT_NODE && currentNode.nodeName === "P" && currentNode.textContent.trim() === "") {
                event.preventDefault();  // Prevent the default Backspace behavior (deleting the last character)
                currentNode.remove();  // Remove the empty block element
            }
            else {
                // In the case of normal backspace, ensure that the backspace deletes the previous character or node.
                const prevNode = range.startContainer.previousSibling;

                // If the previous node is a text node, delete the last character
                if (prevNode && prevNode.nodeType === Node.TEXT_NODE && prevNode.textContent.length > 0) {
                    prevNode.textContent = prevNode.textContent.slice(0, -1);
                }
                // If the previous node is an element (e.g., <span>), delete the whole element
                else if (prevNode && prevNode.nodeType === Node.ELEMENT_NODE) {
                    prevNode.remove();
                }
                else {
                    event.preventDefault(); // Prevent the default action if no node to delete
                }
            }
        }
    }
}



function handleBackspace(event) {
    const selection = window.getSelection();
    const range = selection.getRangeAt(0);

    // Get the current node at the cursor position
    const currentNode = range.startContainer;

    // If the cursor is at the start of a text node, delete the last character
    if (currentNode.nodeType === Node.TEXT_NODE) {
        const textContent = currentNode.textContent;
        
        if (textContent.length > 0) {
            // Prevent the default Backspace behavior (which would remove the character)
            event.preventDefault();
            
            // Remove the last character
            currentNode.textContent = textContent.slice(0, -1);
        }
    }
    // If the cursor is inside an element node, and the element has a previous sibling, remove the previous sibling
    else if (currentNode.nodeType === Node.ELEMENT_NODE) {
        const prevNode = currentNode.previousSibling;
        
        if (prevNode && prevNode.nodeType === Node.TEXT_NODE && prevNode.textContent.length > 0) {
            // Prevent the default Backspace behavior
            event.preventDefault();
            
            // Remove the last character from the previous text node
            prevNode.textContent = prevNode.textContent.slice(0, -1);
        } else if (prevNode && prevNode.nodeType === Node.ELEMENT_NODE) {
            // If the previous sibling is an element, remove the element
            event.preventDefault();
            prevNode.remove();
        }
    }
}


/*
-------------------------------------------------------------------------------------------------------
Date        	 Edit History       Name         Description
-------------------------------------------------------------------------------------------------------
?              		100              ?            created
21/05/2013		 IN030708			Nijitha S	Bru-HIMS-CRF-221
09/06/2013		 IN040341			Nijitha S    CRF-CA-Bru-HIMS-CRF-221/05-Record Clinical Notes->System is inserting the Symbols in wrong position 
11/06/2013       IN040594 			Nijitha S    CRF-CA-Bru-HIMS-CRF-221/09-Record Clinical Notes->Symbol Table screen is disappears	
24/03/2023	39946			Srinivas NT 		ML-MMOH-SCF-2261
11/08-2023      48833       Srinivas N T
-------------------------------------------------------------------------------------------------------
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
		//html	=	document.getElementById("plainmsg").innerText;//48833--
		html	=	document.getElementById("plainmsg").innerHTML;
		if( (document.getElementById("plainmsg").innerText!="") && (navigator.appVersion.indexOf("MSIE 6.")==-1) )
		{
			html	+=	"<BR>";
		}
	}
	self.RTEditor0.contentDocument.body.insertAdjacentHTML("afterbegin",html);
	//self.RTEditor0.document.body.insertAdjacentHTML("AfterBegin",html);
	//The below construct was added by Dinesh T on 2010-03-22
	
	if(html!=null)
	{
		len = self.RTEditor0.contentDocument.links.length;
//		len = self.RTEditor0.document.links.length;
		for(i=0;i<len;i++)
		{
		//self.RTEditor0.document.links[i].href='#';
			self.RTEditor0.contentDocument.links[i].href='#';
		}
	}
	changeFormatMode();
}

function EditorOnCut(id)
{
	EditorFormat(id, "cut");
}

async function EditorOnCopy(id)
{
	//EditorFormat(id, "copy");//uncommented for edge
	//CopiedTxt =self.RTEditor0.contentDocument.createRange();
	//CopiedTxt =self.RTEditor0.document.selection.createRange();
    //CopiedTxt.execCommand("Copy");
	const selectedText = self.RTEditor0.contentDocument.getSelection().toString();
    await navigator.clipboard.writeText(selectedText);
}   

async function EditorOnPaste(id)
{
	//await EditorFormat(id, "paste");//uncommented for EDGE	
	//self.RTEditor0.contentDocument.body.focus();
//	self.RTEditor0.document.body.focus();
	//self.RTEditor0.contentDocument.execCommand("paste","",clipboardData.getData("Text") );
	//self.RTEditor0.document.execCommand("paste","",clipboardData.getData("Text") );
	//self.RTEditor0.contentDocument.execCommand("paste");
//	self.RTEditor0.document.execCommand("paste");
	
	//const editor = self.RTEditor0;
    var selectedText = await navigator.clipboard.readText();
        const selection = self.RTEditor0.contentDocument.getSelection();
        if (!selection.rangeCount) return;
        selection.deleteFromDocument();
        selection.getRangeAt(0).insertNode(self.RTEditor0.contentDocument.createTextNode(selectedText));
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
	var dialogWidth = '24vw';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:no;';
	var color = '';
	color = await top.window.showModalDialog('../html/ColorTable.html',arguments,features);
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
	var dialogWidth = '24vw';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:no;';
	var color = '';
	color = await top.window.showModalDialog('../html/ColorTable.html',arguments,features);
	if (color) {
		EditorFormat(id, "backcolor", color);
	}
	else {
		setEditorFocus();
	}
}
//IN030708 Start.

function EditorInsetSymbol(sym){
	//IN040341 Starts
	window.clipboardData.setData('text','');//[IN040594]
	self.RTEditor0.contentDocument.body.focus();
	self.RTEditor0.contentDocument.execCommand("paste","",sym );
/*	self.RTEditor0.document.body.focus();
	self.RTEditor0.document.execCommand("paste","",sym );
*/	/*var text =(self.RTEditor0.document.body.innerHTML);	
	var out_val=text+"<ADDRESS>"+sym+"</ADDRESS>";
	self.RTEditor0.document.body.innerHTML=out_val*/
	//IN040341 Ends

}
function EditorOnSymbol(id)
{	
	//var note_type = parent.parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_type.value;
	//var note_group = parent.parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_group.value;
	var note_type = "";
	var note_group = "";
	if(parent.RecClinicalNotesHeaderFrame!=undefined){
		note_type = parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_type.value;
		note_group = parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_group.value;
	}else{
		note_type = parent.parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_type.value;
		note_group = parent.parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_group.value;
	}
	var dialogHeight = '10';
	var dialogWidth = '25';
	var arguments = '';
	var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status:no;center:yes;scrolling:yes;';
		
	var finalString	= "note_type="+note_type+"&note_group="+note_group;
    
	window.open("../jsp/DisplaySymbols.jsp?"+finalString, "newwin", "height=290,width=500,top=50,left=350,toolbar=no,scrollbars=no,menubar=no");
	
}
//IN030708 End.
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
	if (opt == "removeFormat") {
		what = opt;
		opt = null;
	}
	if (opt == null) 
	{
		if(what != "clear")
		{
			
			//alert('before...'+self.RTEditor0.document.body.innerHTML); //document.body.innerHTML
			var bool=self.RTEditor0.contentDocument.execCommand(what);
//			var bool=self.RTEditor0.document.execCommand(what);
			//alert('after...'+self.RTEditor0.document.body.innerHTML);
			//var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.createTextRange();
				//alert('after 123....'+txtRange.htmlText);
				//alert('after 456....'+txtRange.innerHTML);
		
		}
		else 
		{
		
		var txtRange = self.RTEditor0.contentDocument;//.createTextRange();
//		var txtRange = self.RTEditor0.document.body.createTextRange();
		if (txtRange != null)
			txtRange.execCommand('selectAll', false, null);
			txtRange.execCommand('delete', false, null);
		var html = "";
		html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>"
		html +="<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>";
		html +="<script src='../../eCommon/js/common.js' language='javascript'></script>";
		html +="<body  onKeyDown='lockKey()' style=\"font:10pt arial\" >";
		html +="</body>";
		EditorSetHTML(html);
		}
	}
	else 
	{  
		self.RTEditor0.contentDocument.execCommand(what, "", opt);
		//self.RTEditor0.document.execCommand(what, "", opt);
	}
}

function EditorCleanHTML()
{
	var fonts = self.RTEditor0.contentDocument.document.getElementsByTagName("FONT");
//	var fonts = self.RTEditor0.document.body.all.tags("FONT");
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
    var html = "";
    html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";
	html +="<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>";
	html +="<script src='../../eCommon/js/common.js' language='javascript'></script>";
    html +="<body onKeyDown='' style=\"font:10pt arial\">";
    html +="</body>";
    self.RTEditor0.contentDocument.open();
    self.RTEditor0.contentDocument.write(html);
    self.RTEditor0.contentDocument.close();
    self.RTEditor0.contentDocument.designMode = "ON";
    /*RTEditor0.document.open();
    RTEditor0.document.write(html);
    RTEditor0.document.close();
    RTEditor0.document.designMode = "ON";*/
    
}

async function callInstantiateEditor() 
{
   await instantiateEditor();
	//var text=self.RTEditor0.document.body.innerHTML;
	//alert(text);
    setTimeout("EditorSetHTML();",100);
	setTimeout("changeFormatMode();",200);  //commented for ML-MMOH-SCF-2261 //Un commented.  In future also don't commented this Line. It will impacted User enter data in Editor between line gap is more.
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


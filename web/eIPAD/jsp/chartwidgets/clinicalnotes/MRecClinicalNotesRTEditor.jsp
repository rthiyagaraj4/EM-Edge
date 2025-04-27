<!DOCTYPE html>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.Locale"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value= "${pageContext.request.contextPath}"/>

<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	String section_content = "";	
	String curr_sec_hdg_code = (request.getParameter("section_code") == null) ? "" : request.getParameter("section_code");
	String curr_child_sec_hdg_code = (request.getParameter("child_section_code") == null) ? "" : request.getParameter("child_section_code");
	String addum="";
    addum = (request.getParameter("addum") == null) ? "" : request.getParameter("addum");
    
    
    
    
	try
	{ 
		
		if(addum.equals("addumMode")){
			
			
			section_content = (String) sectionBean.getAddendumText ( curr_sec_hdg_code,curr_child_sec_hdg_code );

			if(section_content == null || section_content.equals("") )
				section_content			="";
			
			section_content			=	java.net.URLDecoder.decode(section_content,"UTF-8");
			
			
		}else{
			
			if(!curr_sec_hdg_code.equals("") && !curr_child_sec_hdg_code.equals(""))
			{
				section_content = (String) sectionBean.getSectionContent ( curr_sec_hdg_code,curr_child_sec_hdg_code );

				if(section_content == null || section_content.equals("") )
					section_content			="";
				
				section_content			=	java.net.URLDecoder.decode(section_content,"UTF-8");
				
			}	
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

%>

<link rel="stylesheet" href="${path}/eIPAD/css/lib/spectrum.css" />
<script src="${path}/eIPAD/js/lib/spectrum.js"></script>

<script>



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
	var e = document.getElementById("RTEditor0");
	e.contentWindow.document.body.insertAdjacentHTML("AfterBegin",html);
	//self.RTEditor0.document.body.insertAdjacentHTML("AfterBegin",html);
	
	if(html!=null)
	{
		//len = self.RTEditor0.document.links.length;
		len = e.contentWindow.document.links.length;
		for(i=0;i<len;i++)
		{
		//self.RTEditor0.document.links[i].href='#';
		e.contentWindow.document.links[i].href='#';
		}
	}
	changeFormatMode();
}

	

function EditorOnCut(id)
{	
	EditorFormat(id, "cut");
}

function EditorOnCopy(id)
{
	
	var e = document.getElementById("RTEditor0");
	
	if(document.getSelection) {		
		CopiedTxt = e.contentWindow.document.getSelection();
	}
	else
	{
		CopiedTxt =self.RTEditor0.document.selection.createRange();
	}	
	
    var bool=e.contentWindow.document.execCommand("copy");			
}   

function EditorOnPaste(id)
{
	var e = document.getElementById("RTEditor0");	
	e.contentWindow.document.body.focus();
	//e.contentWindow.document.execCommand("paste");  
	 var bool=e.contentWindow.document.execCommand("paste");			
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

$(window).resize(function(){

var height=($("#bodySectionWrapper").height()-$("#EDITOR_BOTTOM_TOOLBAR").height())-10;
$("#divRTEditor").height(height);
});

$( document ).ready(function() {

$(window).resize();


var doc = document.getElementById('RTEditor0').contentWindow.document;
doc.open();
var s='<%=section_content%>'; 
doc.write(s);
doc.close();

 

var color = '';
$("#foreColor").spectrum({
    //color: "#ECC",
    color: "#000",
    showInput: false,
    className: "full-spectrum",
    showInitial: true,
    showPalette: true,
    showSelectionPalette: false,
    maxSelectionSize: 10,
    preferredFormat: "hex",
    localStorageKey: "spectrum.demo",
    move: function (color) {
        
    },
    show: function () {    
    },
    beforeShow: function () {
    
    },
    hide: function () {
    
    },
    change: function(color) {
    	var id = $("#img_tpaint");
		color=color.toHexString();
		if (color) {
			EditorFormat(id, "forecolor", color);
		}
		else {
			setEditorFocus();
		}
    },
    palette: [
        ["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)",
        "rgb(204, 204, 204)", "rgb(217, 217, 217)","rgb(255, 255, 255)"],
        ["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
        "rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"], 
        ["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)", 
        "rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)", 
        "rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)", 
        "rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)", 
        "rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)", 
        "rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
        "rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
        "rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
        "rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)", 
        "rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
    ]
});	

});



function EditorInsetSymbol(sym){
	//IN040341 Starts
	window.clipboardData.setData('text','');//[IN040594]
	self.RTEditor0.document.body.focus();
	self.RTEditor0.document.execCommand("paste","",sym );
	
}

$( document ).ready(function() {
	
   
	var color = '';
$("#backColor").spectrum({
    //color: "#ECC",
    color: "#FFF",
    showInput: false,
    className: "full-spectrum",
    showInitial: true,
    showPalette: true,
    showSelectionPalette: false,
    maxSelectionSize: 10,
    preferredFormat: "hex",
    localStorageKey: "spectrum.demo",
    move: function (color) {
        
    },
    show: function () {    
    },
    beforeShow: function () {
    
    },
    hide: function () {    
    },
    change: function(color) {
		color=color.toHexString();
		var id = $("#img_parea");
		if (color) {
			EditorFormat(id, "backcolor", color);
		}
		else {
			setEditorFocus();
		}
    },
    palette: [
        ["rgb(0, 0, 0)", "rgb(67, 67, 67)", "rgb(102, 102, 102)",
        "rgb(204, 204, 204)", "rgb(217, 217, 217)","rgb(255, 255, 255)"],
        ["rgb(152, 0, 0)", "rgb(255, 0, 0)", "rgb(255, 153, 0)", "rgb(255, 255, 0)", "rgb(0, 255, 0)",
        "rgb(0, 255, 255)", "rgb(74, 134, 232)", "rgb(0, 0, 255)", "rgb(153, 0, 255)", "rgb(255, 0, 255)"], 
        ["rgb(230, 184, 175)", "rgb(244, 204, 204)", "rgb(252, 229, 205)", "rgb(255, 242, 204)", "rgb(217, 234, 211)", 
        "rgb(208, 224, 227)", "rgb(201, 218, 248)", "rgb(207, 226, 243)", "rgb(217, 210, 233)", "rgb(234, 209, 220)", 
        "rgb(221, 126, 107)", "rgb(234, 153, 153)", "rgb(249, 203, 156)", "rgb(255, 229, 153)", "rgb(182, 215, 168)", 
        "rgb(162, 196, 201)", "rgb(164, 194, 244)", "rgb(159, 197, 232)", "rgb(180, 167, 214)", "rgb(213, 166, 189)", 
        "rgb(204, 65, 37)", "rgb(224, 102, 102)", "rgb(246, 178, 107)", "rgb(255, 217, 102)", "rgb(147, 196, 125)", 
        "rgb(118, 165, 175)", "rgb(109, 158, 235)", "rgb(111, 168, 220)", "rgb(142, 124, 195)", "rgb(194, 123, 160)",
        "rgb(166, 28, 0)", "rgb(204, 0, 0)", "rgb(230, 145, 56)", "rgb(241, 194, 50)", "rgb(106, 168, 79)",
        "rgb(69, 129, 142)", "rgb(60, 120, 216)", "rgb(61, 133, 198)", "rgb(103, 78, 167)", "rgb(166, 77, 121)",
        "rgb(91, 15, 0)", "rgb(102, 0, 0)", "rgb(120, 63, 4)", "rgb(127, 96, 0)", "rgb(39, 78, 19)", 
        "rgb(12, 52, 61)", "rgb(28, 69, 135)", "rgb(7, 55, 99)", "rgb(32, 18, 77)", "rgb(76, 17, 48)"]
    ]
});	
var heads = $("#RTEditor0").contents().find("head");
$("<style type='text/css'>div{display:inline-block} </style>").appendTo(heads[0]); 
});


function EditorOnSymbol(id)
{	

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
	document.activeElement.blur();
	EditorFormat(id, "formatBlock", select[select.selectedIndex].value);
	select.selectedIndex = 0;
	
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

function EditorCleanHTML()
{
	var fonts = self.RTEditor0.document.body.all.tags("FONT");
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
	
	var rtEditorText = $("#CN_RTE_Content").val();	
	var html = "";
    html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";


    html +="<body onKeyDown='' style=\"font:10pt arial\">";
    html +=rtEditorText;
    html +="</body>";
    
	var e = document.getElementById("RTEditor0");
	if(e != null) {	
		 $("#RTEditor0").contents().find("body").append( "<div id='myScrollContainer' style='width:100%;height:90%;overflow:scroll;display: inline-block;'><div id = 'editableDiv'style='width:inherit;height:inherit;'></div><div>" );
		$("#RTEditor0").contents().find("body").find("#editableDiv").attr('contenteditable','true');
		$("#RTEditor0").contents().find("body").find("#editableDiv").on("click",update);
	}
}

$(function() { //saravanan
  $('#BUTTON_DIV_21').on('click', function() {  	
    $("#cannedTextPop").show();

  });

  $('.close').on('click', function() {
    deselect($('#contact'));
    return false;
  });
});

function callInstantiateEditor() 
{
	
    instantiateEditor();
	
	setTimeout(function(){EditorSetHTML()}, 100, "Javascript");
	setTimeout(function(){changeFormatMode()}, 200, "Javascript");
}
	 
function EditorFormat(id, what, opt)
{
	
	var e = document.getElementById("RTEditor0");
	if (opt == "removeFormat") {
		what = opt;
		opt = null;
	}
	
	if (opt == null) 
	{
		if(what != "clear")
		{
			if(e != null) {				
			} 
			
			var bool=e.contentWindow.document.execCommand(what);		
		}		
		else 
		{		
			e.contentWindow.document.body.innerText="";				
			var html = "";
			
			html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>"			
			html +="<body  onKeyDown='lockKey()' style=\"font:10pt arial\" >";
			html +="</body>";
			
			EditorSetHTML(html);
		}
	}
	else 
	{		
		e.contentWindow.document.execCommand(what, "", opt);	
	}
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
		var e = document.getElementById("RTEditor0");
		if(e != null) {		
			e.contentWindow.focus();
	}	
			
	}
}
callInstantiateEditor();

</SCRIPT>

<style type='text/css'>
	ADDRESS{FONT-FAMILY:Verdana;FONT-SIZE: 9pt ;font-style: NORMAL;COLOR: BLACK;}
	.full-spectrum .sp-palette {
	max-width: 200px;
	}
	.RTEToolBar
	{
		width: 40px;
		text-align:center;
	}
	.RTEToolBarColor
	{
		width: 66px;
	}
	.Image
	{			
		vertical-align: middle;
	}
	.Toolbar
	{
		background-color:#f4f4f4;
		margin:6px;
/*		height:45px;*/
		
	}
	.editorcon
	{
		display: inline-block;height:44px
	}
</style>
<body  class='CONTENT' style="overflow-y:hidden" onLoad="callInstantiateEditor()">
   <!--  onKeyDown="lockKey()">  onLoad="callInstantiateEditor()" -->    
   <div>               
      <div id="EDITOR_BOTTOM_TOOLBAR" class="Toolbar">
         <div cellpadding="0" cellspacing="0" border="0" height="100%">
            <div style="display: inline-block;">
               <span id="EDITOR_PARAGRAPH" >
                  <select name="format_mode" id="format_mode" class="List" style="height: 30px;" onchange="EditorOnParagraph('0', this)">
                     <option class="Heading">Paragraph</option>
                     <option value="Address">Normal</option>
                     <option value="H1">Heading 1 &lt;H1&gt;</option>
                     <option value="H2">Heading 2 &lt;H2&gt;</option>
                     <option value="H3">Heading 3 &lt;H3&gt;</option>
                     <option value="H4">Heading 4 &lt;H4&gt;</option>
                     <option value="H5">Heading 5 &lt;H5&gt;</option>
                     <option value="H6">Heading 6 &lt;H6&gt;</option>
                     <option value="ADDR">Address &lt;ADDR&gt;</option>
                     <option value="PRE">Formatted &lt;PRE&gt;</option>
                  </select>
               </span>
            </div>
            <div style="display: inline-block;">
               <select class="List" style="height: 30px;"  onchange="EditorOnFont('0', this)">
                  <option class="Heading">Font</option>
                  <option value="Arial">Arial</option>
                  <option value="Arial Black">Arial Black</option>
                  <option value="Arial Narrow">Arial Narrow</option>
                  <option value="Comic Sans MS">Comic Sans MS</option>
                  <option value="Courier New">Courier New</option>
                  <option value="Garamond">Garamond</option>
                  <option value="Sans Serif">Sans Serif</option>
                  <option value="System">System</option>
                  <option value="Times New Roman">Times New Roman</option>
                  <option value="Verdana">Verdana</option>
                  <option value="Wingdings">Wingdings</option>
               </select>
            </div>
            <div style="display: inline-block;">
               <select class="List" style="height: 30px;"  onchange="EditorOnSize('0', this)">
                  <option class="Heading">Size</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
               </select>
            </div>
          <!--
               <div class="editorcon">
                  <div id="BUTTON_DIV_1" class="ButtonNormal RTEToolBar">
				  <img src="${path}/eIPAD/images/cut.gif" id='img_cut' onClick='EditorOnCut(this)' title='Cut' class='Image' >
                     
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_2" class="ButtonNormal RTEToolBar">
				  <img src="${path}/eIPAD/images/copy.gif" id='img_copy' onClick='EditorOnCopy(this)' title='Copy' class='Image'>                 
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_3" class="ButtonNormal RTEToolBar">
                     <img src="${path}/eIPAD/images/paste.gif" id='img_paste' onClick='EditorOnPaste(this)' title='Paste' class='Image'>					 
                  </div>
               </div>
               -->
               <div class="editorcon">
                  <div id="BUTTON_DIV_4" class="ButtonNormal RTEToolBar">
				  <img src="${path}/eIPAD/images/ic_format_bold_black_18dp.png" id='img_bold' onClick='EditorOnBold(this)' title='Bold' class='Image'>
                   
                  </div>
               </div>
			   
               <div class="editorcon">			   
                  <div id="BUTTON_DIV_5" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_italic_black_18dp.png" id='img_italic' onClick='EditorOnItalic(this)' title='Italic' class='Image'>
				  
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_6" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_underlined_black_18dp.png" id='img_uline' onClick='EditorOnUnderline(this)' title='Underline' class='Image'>
                  
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_7" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_undo_black_18dp.png" id='img_undo' onClick='EditorOnUndo(this)' title='Undo' class='Image'>
				  
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_8" class="ButtonNormal RTEToolBar"  >
					<img src="${path}/eIPAD/images/ic_format_redo_black_18dp.png" id='img_redo' onClick='EditorOnRedo(this)' title='Redo' class='Image'>
                  
                  </div>
               </div>
               <div  class="editorcon">
                  <div id="BUTTON_DIV_9" class="ButtonNormal RTEToolBarColor"  >
					<img src="${path}/eIPAD/images/ic_format_color_text_black_18dp.png" id='img_tpaint'  title='Foreground Color' class='Image'>
					<input type='text' style="width:2px;display:none"  id="foreColor"/>
                    
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_10" class="ButtonNormal RTEToolBarColor"  >
				  <img src="${path}/eIPAD/images/ic_format_color_fill_black_18dp.png" id='img_parea' title='Background Color' class='Image'>
				  <input type='text' style="width:2px;display:none"  id="backColor"/>                  
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_11" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_align_left_black_18dp.png" id='img_aleft' onClick='EditorOnAlignLeft(this)' title='Align Left' class='Image'>
                   
                  </div>
               </div>
			   
               <div class="editorcon">
                  <div id="BUTTON_DIV_12" class="ButtonNormal RTEToolBar">
					<img src="${path}/eIPAD/images/ic_format_align_center_black_18dp.png" id='img_center' onClick='EditorOnCenter(this)' title='Align Center' class='Image'>
                     
                  </div>
               </div>
			   
               <div class="editorcon">
                  <div id="BUTTON_DIV_13" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_align_right_black_18dp.png" id='img_aright' onClick='EditorOnAlignRight(this)' title='Align Right' class='Image'>
                    
                  </div>
               </div>
              
               <div class="editorcon">
                  <div id="BUTTON_DIV_14" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_list_numbered_black_18dp.png" id='img_nlist' onClick='EditorOnNumberedList(this)' title="Numbered List" class='Image'>
              
                  </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_15" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_list_bulleted_black_18dp.png" id='img_blist' onClick='EditorOnBullettedList(this)' title="Bulletted List" class='Image'>
                     
                  </div>
               </div>
			   
			   <div class="editorcon">
                  <div id="BUTTON_DIV_17" class="ButtonNormal RTEToolBar"  >
				  <img src="${path}/eIPAD/images/ic_format_indent_increase_black_18dp.png" id='img_iright' onClick='EditorOnIncreaseIndent(this)' title="Increase Indent" class='Image'>
                    
                  </div>
               </div>
			   
               <div class="editorcon">
                  <div id="BUTTON_DIV_16" class="ButtonNormal RTEToolBar"  >
					<img src="${path}/eIPAD/images/ic_format_indent_decrease_black_18dp.png" id='img_ileft' onClick='EditorOnDecreaseIndent(this)' title="Decrease Indent" class='Image'>
                  
                  </div>
               </div>
			   
               <!--
                  <div class="editorcon">
                  <div id="BUTTON_DIV_18" class="ButtonNormal RTEToolBar"  >
					<img src="${path}/eIPAD/images/clear.gif" id='img_clear' onClick='EditorOnClear(this)' title="Clear Page" class='Image'>
                  </div>
               </div>			  
				  
                <div class="editorcon">
                  <div id="BUTTON_DIV_19" class="ButtonNormal RTEToolBar"  >
					<img id="PAD1_PREFIX_19" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="${path}/eIPAD/images/Symbol.png" id='img_symbol' onClick='EditorOnSymbol(this)' title="Symbols" class='Image'>
                   </div>
               </div>
               <div class="editorcon">
                  <div id="BUTTON_DIV_20" class="ButtonNormal RTEToolBar"  >                  
                  	<img src="${path}/eIPAD/images/out1.png" id='img_spell2' onMouseOver="img_spell2.src=overImage1.src;" onMouseOut="img_spell2.src=staticImage1.src;" onMouseDown="img_spell2.src=downImage1.src;" onClick="rapidSpell.ayt_spellCheck('RTEditor0');document.getElementById('RTEditor0_D').style.overflowX = 'hidden';" title="Spell Check Inline" class='Image'>					
                   </div>
				</div> -->
				
	      	<div class="editorcon">
                  <div id="BUTTON_DIV_21" class="ButtonNormal RTEToolBar"  >
			  <img src="${path}/eIPAD/images/ic_format_canned_black_18dp.png" id='img_iright' onClick='loadTabTextTypes()' title="Increase Indent" class='Image'>
                  </div>
               </div> 
                  
         </div>
      </div>
   </div>
   
   
    <div id="divRTEditor" style="background-color:#fff;position:relative;overflow:hidden">
        <iframe   id="RTEditor0"  width=100% height=100% style="margin-top: 20px;border:none;position:absolute"><%=section_content%></iframe>
    </div>
   
	<input type="hidden" name="CN_RTE_Content" id="CN_RTE_Content" id="CN_RTE_Content" value='<%=section_content%>' /> 
   
   
   <FORM name='RTEditorForm' id='RTEditorForm'>
      <div id=plainmsg style="HEIGHT:0px; Width:0Px; LEFT: 0px; POSITION: absolute; TOP: 0px; VISIBILITY: hidden"></div>
   </FORM>
  
</body>


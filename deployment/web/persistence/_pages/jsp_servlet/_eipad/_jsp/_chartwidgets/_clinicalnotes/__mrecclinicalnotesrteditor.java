package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.Locale;
import java.util.Locale;
import java.util.ResourceBundle;

public final class __mrecclinicalnotesrteditor extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTEditor.jsp", 1709118015256L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/lib/spectrum.css\" />\n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/js/lib/spectrum.js\"></script>\n\n<script>\n\n\n\nfunction ButtonOnSelectStart()\n{\n\t\n\twindow.event.returnValue = false;\n}\n\nfunction ButtonOnDragStart()\n{\n\twindow.event.returnValue = false;\n}\n\nfunction ButtonOnMouseDown(divObj)\n{\n\tvar id = divObj.id.substring(11,divObj.id.length);\n\tButtonPushButton(id);\n}\n\nfunction ButtonOnMouseUp(divObj)\n{\n\tvar id = divObj.id.substring(11,divObj.id.length);\n\tButtonReleaseButton(id);\n}\n\nfunction ButtonOnMouseOut(divObj)\n{\n\tvar id = divObj.id.substring(11,divObj.id.length);\n\tButtonReleaseButton(id);\n}\n\nfunction ButtonOnMouseOver(divObj)\n{\n\tvar id = divObj.id.substring(11,divObj.id.length);\n\tButtonReleaseButton(id);\n\tdivObj.className = \"ButtonMouseOver\";\n}\n\nfunction ButtonPushButton(id)\n{\n\tdocument.all[\"PAD1_PREFIX_\" + id].width = 3;\n\tdocument.all[\"PAD1_PREFIX_\" + id].height = 3;\n\tdocument.all[\"PAD2_PREFIX_\" + id].width = 1;\n\tdocument.all[\"PAD2_PREFIX_\" + id].height = 1;\n\tdocument.all[\"BUTTON_DIV_\" + id].className = \"ButtonPressed\";\n}\n\nfunction ButtonReleaseButton(id)\n{\n\tdocument.all[\"PAD1_PREFIX_\" + id].width = 2;\n\tdocument.all[\"PAD1_PREFIX_\" + id].height = 2;\n\tdocument.all[\"PAD2_PREFIX_\" + id].width = 2;\n\tdocument.all[\"PAD2_PREFIX_\" + id].height = 2;\n\tdocument.all[\"BUTTON_DIV_\" + id].className = \"ButtonNormal\";\n}\n\nfunction ButtonOnClick(divObj)\n{\n\tvar id = divObj.id.substring(11,divObj.id.length);\n}\n\nfunction ButtonOnDblClick(divObj)\n{\n\tButtonOnClick(divObj);\n}\n\nfunction  EditorGetHTML()\n{\n\tEditorCleanHTML();\n\treturn self.RTEditor0.document.body.innerHTML;\n}\n\nfunction  EditorSetHTML(html)\n{\t\n\tif(html==null)\n\t{\t\t\n\t\thtml\t=\tdocument.getElementById(\"plainmsg\").innerHTML;\n\t\t\n\t\tif( (document.getElementById(\"plainmsg\").innerText!=\"\") && (navigator.appVersion.indexOf(\"MSIE 6.\")==-1) )\n\t\t{\n\t\t\thtml\t+=\t\"<BR>\";\n\t\t}\n\t}\n\tvar e = document.getElementById(\"RTEditor0\");\n\te.contentWindow.document.body.insertAdjacentHTML(\"AfterBegin\",html);\n\t//self.RTEditor0.document.body.insertAdjacentHTML(\"AfterBegin\",html);\n\t\n\tif(html!=null)\n\t{\n\t\t//len = self.RTEditor0.document.links.length;\n\t\tlen = e.contentWindow.document.links.length;\n\t\tfor(i=0;i<len;i++)\n\t\t{\n\t\t//self.RTEditor0.document.links[i].href=\'#\';\n\t\te.contentWindow.document.links[i].href=\'#\';\n\t\t}\n\t}\n\tchangeFormatMode();\n}\n\n\t\n\nfunction EditorOnCut(id)\n{\t\n\tEditorFormat(id, \"cut\");\n}\n\nfunction EditorOnCopy(id)\n{\n\t\n\tvar e = document.getElementById(\"RTEditor0\");\n\t\n\tif(document.getSelection) {\t\t\n\t\tCopiedTxt = e.contentWindow.document.getSelection();\n\t}\n\telse\n\t{\n\t\tCopiedTxt =self.RTEditor0.document.selection.createRange();\n\t}\t\n\t\n    var bool=e.contentWindow.document.execCommand(\"copy\");\t\t\t\n}   \n\nfunction EditorOnPaste(id)\n{\n\tvar e = document.getElementById(\"RTEditor0\");\t\n\te.contentWindow.document.body.focus();\n\t//e.contentWindow.document.execCommand(\"paste\");  \n\t var bool=e.contentWindow.document.execCommand(\"paste\");\t\t\t\n}\n\nfunction EditorOnBold(id)\n{\n\tEditorFormat(id, \"bold\");\n}\n\nfunction EditorOnItalic(id)\n{\n\tEditorFormat(id, \"italic\");\n}\n\nfunction EditorOnUnderline(id)\n{\n\tEditorFormat(id, \"underline\");\n}\n\nfunction EditorOnUndo(id)\n{\n\tEditorFormat(id, \"Undo\");\n}\n\nfunction EditorOnRedo(id)\n{\n\tEditorFormat(id, \"Redo\");\n}\n\nfunction EditorOnClear(id)\n{\n\tEditorFormat(id, \"clear\");\n}\n\n$(window).resize(function(){\n\nvar height=($(\"#bodySectionWrapper\").height()-$(\"#EDITOR_BOTTOM_TOOLBAR\").height())-10;\n$(\"#divRTEditor\").height(height);\n});\n\n$( document ).ready(function() {\n\n$(window).resize();\n\n\nvar doc = document.getElementById(\'RTEditor0\').contentWindow.document;\ndoc.open();\nvar s=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\'; \ndoc.write(s);\ndoc.close();\n\n \n\nvar color = \'\';\n$(\"#foreColor\").spectrum({\n    //color: \"#ECC\",\n    color: \"#000\",\n    showInput: false,\n    className: \"full-spectrum\",\n    showInitial: true,\n    showPalette: true,\n    showSelectionPalette: false,\n    maxSelectionSize: 10,\n    preferredFormat: \"hex\",\n    localStorageKey: \"spectrum.demo\",\n    move: function (color) {\n        \n    },\n    show: function () {    \n    },\n    beforeShow: function () {\n    \n    },\n    hide: function () {\n    \n    },\n    change: function(color) {\n    \tvar id = $(\"#img_tpaint\");\n\t\tcolor=color.toHexString();\n\t\tif (color) {\n\t\t\tEditorFormat(id, \"forecolor\", color);\n\t\t}\n\t\telse {\n\t\t\tsetEditorFocus();\n\t\t}\n    },\n    palette: [\n        [\"rgb(0, 0, 0)\", \"rgb(67, 67, 67)\", \"rgb(102, 102, 102)\",\n        \"rgb(204, 204, 204)\", \"rgb(217, 217, 217)\",\"rgb(255, 255, 255)\"],\n        [\"rgb(152, 0, 0)\", \"rgb(255, 0, 0)\", \"rgb(255, 153, 0)\", \"rgb(255, 255, 0)\", \"rgb(0, 255, 0)\",\n        \"rgb(0, 255, 255)\", \"rgb(74, 134, 232)\", \"rgb(0, 0, 255)\", \"rgb(153, 0, 255)\", \"rgb(255, 0, 255)\"], \n        [\"rgb(230, 184, 175)\", \"rgb(244, 204, 204)\", \"rgb(252, 229, 205)\", \"rgb(255, 242, 204)\", \"rgb(217, 234, 211)\", \n        \"rgb(208, 224, 227)\", \"rgb(201, 218, 248)\", \"rgb(207, 226, 243)\", \"rgb(217, 210, 233)\", \"rgb(234, 209, 220)\", \n        \"rgb(221, 126, 107)\", \"rgb(234, 153, 153)\", \"rgb(249, 203, 156)\", \"rgb(255, 229, 153)\", \"rgb(182, 215, 168)\", \n        \"rgb(162, 196, 201)\", \"rgb(164, 194, 244)\", \"rgb(159, 197, 232)\", \"rgb(180, 167, 214)\", \"rgb(213, 166, 189)\", \n        \"rgb(204, 65, 37)\", \"rgb(224, 102, 102)\", \"rgb(246, 178, 107)\", \"rgb(255, 217, 102)\", \"rgb(147, 196, 125)\", \n        \"rgb(118, 165, 175)\", \"rgb(109, 158, 235)\", \"rgb(111, 168, 220)\", \"rgb(142, 124, 195)\", \"rgb(194, 123, 160)\",\n        \"rgb(166, 28, 0)\", \"rgb(204, 0, 0)\", \"rgb(230, 145, 56)\", \"rgb(241, 194, 50)\", \"rgb(106, 168, 79)\",\n        \"rgb(69, 129, 142)\", \"rgb(60, 120, 216)\", \"rgb(61, 133, 198)\", \"rgb(103, 78, 167)\", \"rgb(166, 77, 121)\",\n        \"rgb(91, 15, 0)\", \"rgb(102, 0, 0)\", \"rgb(120, 63, 4)\", \"rgb(127, 96, 0)\", \"rgb(39, 78, 19)\", \n        \"rgb(12, 52, 61)\", \"rgb(28, 69, 135)\", \"rgb(7, 55, 99)\", \"rgb(32, 18, 77)\", \"rgb(76, 17, 48)\"]\n    ]\n});\t\n\n});\n\n\n\nfunction EditorInsetSymbol(sym){\n\t//IN040341 Starts\n\twindow.clipboardData.setData(\'text\',\'\');//[IN040594]\n\tself.RTEditor0.document.body.focus();\n\tself.RTEditor0.document.execCommand(\"paste\",\"\",sym );\n\t\n}\n\n$( document ).ready(function() {\n\t\n   \n\tvar color = \'\';\n$(\"#backColor\").spectrum({\n    //color: \"#ECC\",\n    color: \"#FFF\",\n    showInput: false,\n    className: \"full-spectrum\",\n    showInitial: true,\n    showPalette: true,\n    showSelectionPalette: false,\n    maxSelectionSize: 10,\n    preferredFormat: \"hex\",\n    localStorageKey: \"spectrum.demo\",\n    move: function (color) {\n        \n    },\n    show: function () {    \n    },\n    beforeShow: function () {\n    \n    },\n    hide: function () {    \n    },\n    change: function(color) {\n\t\tcolor=color.toHexString();\n\t\tvar id = $(\"#img_parea\");\n\t\tif (color) {\n\t\t\tEditorFormat(id, \"backcolor\", color);\n\t\t}\n\t\telse {\n\t\t\tsetEditorFocus();\n\t\t}\n    },\n    palette: [\n        [\"rgb(0, 0, 0)\", \"rgb(67, 67, 67)\", \"rgb(102, 102, 102)\",\n        \"rgb(204, 204, 204)\", \"rgb(217, 217, 217)\",\"rgb(255, 255, 255)\"],\n        [\"rgb(152, 0, 0)\", \"rgb(255, 0, 0)\", \"rgb(255, 153, 0)\", \"rgb(255, 255, 0)\", \"rgb(0, 255, 0)\",\n        \"rgb(0, 255, 255)\", \"rgb(74, 134, 232)\", \"rgb(0, 0, 255)\", \"rgb(153, 0, 255)\", \"rgb(255, 0, 255)\"], \n        [\"rgb(230, 184, 175)\", \"rgb(244, 204, 204)\", \"rgb(252, 229, 205)\", \"rgb(255, 242, 204)\", \"rgb(217, 234, 211)\", \n        \"rgb(208, 224, 227)\", \"rgb(201, 218, 248)\", \"rgb(207, 226, 243)\", \"rgb(217, 210, 233)\", \"rgb(234, 209, 220)\", \n        \"rgb(221, 126, 107)\", \"rgb(234, 153, 153)\", \"rgb(249, 203, 156)\", \"rgb(255, 229, 153)\", \"rgb(182, 215, 168)\", \n        \"rgb(162, 196, 201)\", \"rgb(164, 194, 244)\", \"rgb(159, 197, 232)\", \"rgb(180, 167, 214)\", \"rgb(213, 166, 189)\", \n        \"rgb(204, 65, 37)\", \"rgb(224, 102, 102)\", \"rgb(246, 178, 107)\", \"rgb(255, 217, 102)\", \"rgb(147, 196, 125)\", \n        \"rgb(118, 165, 175)\", \"rgb(109, 158, 235)\", \"rgb(111, 168, 220)\", \"rgb(142, 124, 195)\", \"rgb(194, 123, 160)\",\n        \"rgb(166, 28, 0)\", \"rgb(204, 0, 0)\", \"rgb(230, 145, 56)\", \"rgb(241, 194, 50)\", \"rgb(106, 168, 79)\",\n        \"rgb(69, 129, 142)\", \"rgb(60, 120, 216)\", \"rgb(61, 133, 198)\", \"rgb(103, 78, 167)\", \"rgb(166, 77, 121)\",\n        \"rgb(91, 15, 0)\", \"rgb(102, 0, 0)\", \"rgb(120, 63, 4)\", \"rgb(127, 96, 0)\", \"rgb(39, 78, 19)\", \n        \"rgb(12, 52, 61)\", \"rgb(28, 69, 135)\", \"rgb(7, 55, 99)\", \"rgb(32, 18, 77)\", \"rgb(76, 17, 48)\"]\n    ]\n});\t\nvar heads = $(\"#RTEditor0\").contents().find(\"head\");\n$(\"<style type=\'text/css\'>div{display:inline-block} </style>\").appendTo(heads[0]); \n});\n\n\nfunction EditorOnSymbol(id)\n{\t\n\n\tvar note_type = \"\";\n\tvar note_group = \"\";\n\tif(parent.RecClinicalNotesHeaderFrame!=undefined){\n\t\tnote_type = parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_type.value;\n\t\tnote_group = parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_group.value;\n\t}else{\n\t\tnote_type = parent.parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_type.value;\n\t\tnote_group = parent.parent.RecClinicalNotesHeaderFrame.RecClinicalNotesHeaderForm.note_group.value;\n\t}\n\tvar dialogHeight = \'10\';\n\tvar dialogWidth = \'25\';\n\tvar arguments = \'\';\n\tvar features = \'dialogHeight:\'+dialogHeight+\'; dialogWidth:\'+dialogWidth+\'; status:no;center:yes;scrolling:yes;\';\n\t\t\n\tvar finalString\t= \"note_type=\"+note_type+\"&note_group=\"+note_group;\n    \n\twindow.open(\"../jsp/DisplaySymbols.jsp?\"+finalString, \"newwin\", \"height=290,width=500,top=50,left=350,toolbar=no,scrollbars=no,menubar=no\");\n\t\n}\n//IN030708 End.\nfunction EditorOnAlignLeft(id)\n{\n\tEditorFormat(id, \"justifyleft\");\n}\n\nfunction EditorOnCenter(id)\n{\n\tEditorFormat(id, \"justifycenter\");\t\n}\n\nfunction EditorOnAlignRight(id)\n{\n\tEditorFormat(id, \"justifyright\");\n}\n\nfunction EditorOnNumberedList(id)\n{\n\tEditorFormat(id, \"insertOrderedList\");\n}\n\nfunction EditorOnBullettedList(id)\n{\n\tEditorFormat(id, \"insertUnorderedList\");\n}\n\nfunction EditorOnDecreaseIndent(id)\n{\n\tEditorFormat(id, \"outdent\");\n}\n\nfunction EditorOnIncreaseIndent(id)\n{\n\tEditorFormat(id, \"indent\");\n}\n\nfunction EditorOnParagraph(id, select)\n{\t\n\tdocument.activeElement.blur();\n\tEditorFormat(id, \"formatBlock\", select[select.selectedIndex].value);\n\tselect.selectedIndex = 0;\n\t\n}\n\nfunction EditorOnFont(id, select)\n{\n\tEditorFormat(id, \"fontname\", select[select.selectedIndex].value);\n\tselect.selectedIndex = 0;\n\tsetEditorFocus();\n}\n\nfunction EditorOnSize(id, select)\n{\n\tEditorFormat(id, \"fontsize\", select[select.selectedIndex].value);\n\tselect.selectedIndex = 0;\n\tsetEditorFocus();\n}\n\nfunction EditorCleanHTML()\n{\n\tvar fonts = self.RTEditor0.document.body.all.tags(\"FONT\");\n\tfor (var i = fonts.length - 1; i >= 0; i--) {\n\t\tvar font = fonts[i];\n\t\tif (font.style.backgroundColor == \"#ffffff\") {\n\t\tfont.outerHTML = font.innerHTML;\n\t\t}\n\t}\n}\n\nfunction EditorGetElement(tagName, start)\n{\n\twhile (start && start.tagName != tagName) {\n\t\tstart = start.parentElement;\n\t}\n\treturn start;\n}\n\nfunction instantiateEditor()\n{\n\t\n\tvar rtEditorText = $(\"#CN_RTE_Content\").val();\t\n\tvar html = \"\";\n    html +=\"<style type=\'text/css\'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>\";\n\n\n    html +=\"<body onKeyDown=\'\' style=\\\"font:10pt arial\\\">\";\n    html +=rtEditorText;\n    html +=\"</body>\";\n    \n\tvar e = document.getElementById(\"RTEditor0\");\n\tif(e != null) {\t\n\t\t $(\"#RTEditor0\").contents().find(\"body\").append( \"<div id=\'myScrollContainer\' style=\'width:100%;height:90%;overflow:scroll;display: inline-block;\'><div id = \'editableDiv\'style=\'width:inherit;height:inherit;\'></div><div>\" );\n\t\t$(\"#RTEditor0\").contents().find(\"body\").find(\"#editableDiv\").attr(\'contenteditable\',\'true\');\n\t\t$(\"#RTEditor0\").contents().find(\"body\").find(\"#editableDiv\").on(\"click\",update);\n\t}\n}\n\n$(function() { //saravanan\n  $(\'#BUTTON_DIV_21\').on(\'click\', function() {  \t\n    $(\"#cannedTextPop\").show();\n\n  });\n\n  $(\'.close\').on(\'click\', function() {\n    deselect($(\'#contact\'));\n    return false;\n  });\n});\n\nfunction callInstantiateEditor() \n{\n\t\n    instantiateEditor();\n\t\n\tsetTimeout(function(){EditorSetHTML()}, 100, \"Javascript\");\n\tsetTimeout(function(){changeFormatMode()}, 200, \"Javascript\");\n}\n\t \nfunction EditorFormat(id, what, opt)\n{\n\t\n\tvar e = document.getElementById(\"RTEditor0\");\n\tif (opt == \"removeFormat\") {\n\t\twhat = opt;\n\t\topt = null;\n\t}\n\t\n\tif (opt == null) \n\t{\n\t\tif(what != \"clear\")\n\t\t{\n\t\t\tif(e != null) {\t\t\t\t\n\t\t\t} \n\t\t\t\n\t\t\tvar bool=e.contentWindow.document.execCommand(what);\t\t\n\t\t}\t\t\n\t\telse \n\t\t{\t\t\n\t\t\te.contentWindow.document.body.innerText=\"\";\t\t\t\t\n\t\t\tvar html = \"\";\n\t\t\t\n\t\t\thtml +=\"<style type=\'text/css\'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>\"\t\t\t\n\t\t\thtml +=\"<body  onKeyDown=\'lockKey()\' style=\\\"font:10pt arial\\\" >\";\n\t\t\thtml +=\"</body>\";\n\t\t\t\n\t\t\tEditorSetHTML(html);\n\t\t}\n\t}\n\telse \n\t{\t\t\n\t\te.contentWindow.document.execCommand(what, \"\", opt);\t\n\t}\n}\n\nfunction changeFormatMode()\n{\t\n    document.getElementById(\"format_mode\").value = \"Address\";\n    EditorOnParagraph(\"0\",document.getElementById(\"format_mode\"));\n    setEditorFocus();\n}\n\nfunction setEditorFocus()\n{\n\tif(navigator.appVersion.indexOf(\"MSIE 6.\")!=-1)\n\t{\n\t    RTEditor0.focus();\n\t}\n\telse\n\t{\n\t\tvar e = document.getElementById(\"RTEditor0\");\n\t\tif(e != null) {\t\t\n\t\t\te.contentWindow.focus();\n\t}\t\n\t\t\t\n\t}\n}\ncallInstantiateEditor();\n\n</SCRIPT>\n\n<style type=\'text/css\'>\n\tADDRESS{FONT-FAMILY:Verdana;FONT-SIZE: 9pt ;font-style: NORMAL;COLOR: BLACK;}\n\t.full-spectrum .sp-palette {\n\tmax-width: 200px;\n\t}\n\t.RTEToolBar\n\t{\n\t\twidth: 40px;\n\t\ttext-align:center;\n\t}\n\t.RTEToolBarColor\n\t{\n\t\twidth: 66px;\n\t}\n\t.Image\n\t{\t\t\t\n\t\tvertical-align: middle;\n\t}\n\t.Toolbar\n\t{\n\t\tbackground-color:#f4f4f4;\n\t\tmargin:6px;\n/*\t\theight:45px;*/\n\t\t\n\t}\n\t.editorcon\n\t{\n\t\tdisplay: inline-block;height:44px\n\t}\n</style>\n<body  class=\'CONTENT\' style=\"overflow-y:hidden\" onLoad=\"callInstantiateEditor()\">\n   <!--  onKeyDown=\"lockKey()\">  onLoad=\"callInstantiateEditor()\" -->    \n   <div>               \n      <div id=\"EDITOR_BOTTOM_TOOLBAR\" class=\"Toolbar\">\n         <div cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">\n            <div style=\"display: inline-block;\">\n               <span id=\"EDITOR_PARAGRAPH\" >\n                  <select name=\"format_mode\" id=\"format_mode\" class=\"List\" style=\"height: 30px;\" onchange=\"EditorOnParagraph(\'0\', this)\">\n                     <option class=\"Heading\">Paragraph</option>\n                     <option value=\"Address\">Normal</option>\n                     <option value=\"H1\">Heading 1 &lt;H1&gt;</option>\n                     <option value=\"H2\">Heading 2 &lt;H2&gt;</option>\n                     ";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="<option value=\"H3\">Heading 3 &lt;H3&gt;</option>\n                     <option value=\"H4\">Heading 4 &lt;H4&gt;</option>\n                     <option value=\"H5\">Heading 5 &lt;H5&gt;</option>\n                     <option value=\"H6\">Heading 6 &lt;H6&gt;</option>\n                     <option value=\"ADDR\">Address &lt;ADDR&gt;</option>\n                     <option value=\"PRE\">Formatted &lt;PRE&gt;</option>\n                  </select>\n               </span>\n            </div>\n            <div style=\"display: inline-block;\">\n               <select class=\"List\" style=\"height: 30px;\"  onchange=\"EditorOnFont(\'0\', this)\">\n                  <option class=\"Heading\">Font</option>\n                  <option value=\"Arial\">Arial</option>\n                  <option value=\"Arial Black\">Arial Black</option>\n                  <option value=\"Arial Narrow\">Arial Narrow</option>\n                  <option value=\"Comic Sans MS\">Comic Sans MS</option>\n                  <option value=\"Courier New\">Courier New</option>\n                  <option value=\"Garamond\">Garamond</option>\n                  <option value=\"Sans Serif\">Sans Serif</option>\n                  <option value=\"System\">System</option>\n                  <option value=\"Times New Roman\">Times New Roman</option>\n                  <option value=\"Verdana\">Verdana</option>\n                  <option value=\"Wingdings\">Wingdings</option>\n               </select>\n            </div>\n            <div style=\"display: inline-block;\">\n               <select class=\"List\" style=\"height: 30px;\"  onchange=\"EditorOnSize(\'0\', this)\">\n                  <option class=\"Heading\">Size</option>\n                  <option value=\"1\">1</option>\n                  <option value=\"2\">2</option>\n                  <option value=\"3\">3</option>\n                  <option value=\"4\">4</option>\n                  <option value=\"5\">5</option>\n                  <option value=\"6\">6</option>\n                  <option value=\"7\">7</option>\n               </select>\n            </div>\n          <!--\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_1\" class=\"ButtonNormal RTEToolBar\">\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/cut.gif\" id=\'img_cut\' onClick=\'EditorOnCut(this)\' title=\'Cut\' class=\'Image\' >\n                     \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_2\" class=\"ButtonNormal RTEToolBar\">\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/copy.gif\" id=\'img_copy\' onClick=\'EditorOnCopy(this)\' title=\'Copy\' class=\'Image\'>                 \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_3\" class=\"ButtonNormal RTEToolBar\">\n                     <img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/paste.gif\" id=\'img_paste\' onClick=\'EditorOnPaste(this)\' title=\'Paste\' class=\'Image\'>\t\t\t\t\t \n                  </div>\n               </div>\n               -->\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_4\" class=\"ButtonNormal RTEToolBar\">\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/ic_format_bold_black_18dp.png\" id=\'img_bold\' onClick=\'EditorOnBold(this)\' title=\'Bold\' class=\'Image\'>\n                   \n                  </div>\n               </div>\n\t\t\t   \n               <div class=\"editorcon\">\t\t\t   \n                  <div id=\"BUTTON_DIV_5\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/images/ic_format_italic_black_18dp.png\" id=\'img_italic\' onClick=\'EditorOnItalic(this)\' title=\'Italic\' class=\'Image\'>\n\t\t\t\t  \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_6\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/images/ic_format_underlined_black_18dp.png\" id=\'img_uline\' onClick=\'EditorOnUnderline(this)\' title=\'Underline\' class=\'Image\'>\n                  \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_7\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/ic_format_undo_black_18dp.png\" id=\'img_undo\' onClick=\'EditorOnUndo(this)\' title=\'Undo\' class=\'Image\'>\n\t\t\t\t  \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_8\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/ic_format_redo_black_18dp.png\" id=\'img_redo\' onClick=\'EditorOnRedo(this)\' title=\'Redo\' class=\'Image\'>\n                  \n                  </div>\n               </div>\n               <div  class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_9\" class=\"ButtonNormal RTEToolBarColor\"  >\n\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/ic_format_color_text_black_18dp.png\" id=\'img_tpaint\'  title=\'Foreground Color\' class=\'Image\'>\n\t\t\t\t\t<input type=\'text\' style=\"width:2px;display:none\"  id=\"foreColor\"/>\n                    \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_10\" class=\"ButtonNormal RTEToolBarColor\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/ic_format_color_fill_black_18dp.png\" id=\'img_parea\' title=\'Background Color\' class=\'Image\'>\n\t\t\t\t  <input type=\'text\' style=\"width:2px;display:none\"  id=\"backColor\"/>                  \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_11\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/images/ic_format_align_left_black_18dp.png\" id=\'img_aleft\' onClick=\'EditorOnAlignLeft(this)\' title=\'Align Left\' class=\'Image\'>\n                   \n                  </div>\n               </div>\n\t\t\t   \n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_12\" class=\"ButtonNormal RTEToolBar\">\n\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/eIPAD/images/ic_format_align_center_black_18dp.png\" id=\'img_center\' onClick=\'EditorOnCenter(this)\' title=\'Align Center\' class=\'Image\'>\n                     \n                  </div>\n               </div>\n\t\t\t   \n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_13\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/ic_format_align_right_black_18dp.png\" id=\'img_aright\' onClick=\'EditorOnAlignRight(this)\' title=\'Align Right\' class=\'Image\'>\n                    \n                  </div>\n               </div>\n              \n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_14\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/ic_format_list_numbered_black_18dp.png\" id=\'img_nlist\' onClick=\'EditorOnNumberedList(this)\' title=\"Numbered List\" class=\'Image\'>\n              \n                  </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_15\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/ic_format_list_bulleted_black_18dp.png\" id=\'img_blist\' onClick=\'EditorOnBullettedList(this)\' title=\"Bulletted List\" class=\'Image\'>\n                     \n                  </div>\n               </div>\n\t\t\t   \n\t\t\t   <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_17\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t  <img src=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/ic_format_indent_increase_black_18dp.png\" id=\'img_iright\' onClick=\'EditorOnIncreaseIndent(this)\' title=\"Increase Indent\" class=\'Image\'>\n                    \n                  </div>\n               </div>\n\t\t\t   \n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_16\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/ic_format_indent_decrease_black_18dp.png\" id=\'img_ileft\' onClick=\'EditorOnDecreaseIndent(this)\' title=\"Decrease Indent\" class=\'Image\'>\n                  \n                  </div>\n               </div>\n\t\t\t   \n               <!--\n                  <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_18\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/clear.gif\" id=\'img_clear\' onClick=\'EditorOnClear(this)\' title=\"Clear Page\" class=\'Image\'>\n                  </div>\n               </div>\t\t\t  \n\t\t\t\t  \n                <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_19\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t\t\t<img id=\"PAD1_PREFIX_19\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/eIPAD/images/Symbol.png\" id=\'img_symbol\' onClick=\'EditorOnSymbol(this)\' title=\"Symbols\" class=\'Image\'>\n                   </div>\n               </div>\n               <div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_20\" class=\"ButtonNormal RTEToolBar\"  >                  \n                  \t<img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/out1.png\" id=\'img_spell2\' onMouseOver=\"img_spell2.src=overImage1.src;\" onMouseOut=\"img_spell2.src=staticImage1.src;\" onMouseDown=\"img_spell2.src=downImage1.src;\" onClick=\"rapidSpell.ayt_spellCheck(\'RTEditor0\');document.getElementById(\'RTEditor0_D\').style.overflowX = \'hidden\';\" title=\"Spell Check Inline\" class=\'Image\'>\t\t\t\t\t\n                   </div>\n\t\t\t\t</div> -->\n\t\t\t\t\n\t      \t<div class=\"editorcon\">\n                  <div id=\"BUTTON_DIV_21\" class=\"ButtonNormal RTEToolBar\"  >\n\t\t\t  <img src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eIPAD/images/ic_format_canned_black_18dp.png\" id=\'img_iright\' onClick=\'loadTabTextTypes()\' title=\"Increase Indent\" class=\'Image\'>\n                  </div>\n               </div> \n                  \n         </div>\n      </div>\n   </div>\n   \n   \n    <div id=\"divRTEditor\" style=\"background-color:#fff;position:relative;overflow:hidden\">\n        <iframe   id=\"RTEditor0\"  width=100% height=100% style=\"margin-top: 20px;border:none;position:absolute\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</iframe>\n    </div>\n   \n\t<input type=\"hidden\" name=\"CN_RTE_Content\" id=\"CN_RTE_Content\" id=\"CN_RTE_Content\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' /> \n   \n   \n   <FORM name=\'RTEditorForm\' id=\'RTEditorForm\'>\n      <div id=plainmsg style=\"HEIGHT:0px; Width:0Px; LEFT: 0px; POSITION: absolute; TOP: 0px; VISIBILITY: hidden\"></div>\n   </FORM>\n  \n</body>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);

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


            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}

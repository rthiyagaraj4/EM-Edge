package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.w3c.dom.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __rteditor extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/RTEditor.jsp", 1740026113102L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\t\n13/09/2012    IN029712\t    Akbar        BRU-hims-CRF-001 - Spell check CRF\n21/09/2012\t  IN035323\t\tRamesh G\t Bru-HIMS-CRF-001 /02- Add Button not displayed\t\n---------------------------------------------------------------------------------------------------------------\n-->\n<!--Spell Checker Start-->\n<!-- page contentType=\"text/html;charset=UTF-8\" %> -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!--<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\"> -->\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \n   \"http://www.w3.org/TR/html4/loose.dtd\">\n<!--Spell Checker End-->\n<HTML>\n<HEAD>\n\n    <TITLE>Clinician Access - Rich Text Editor</TITLE>\n    <META content=\"text/html; charset=UTF-8\" http-equiv=Content-Type>\n    <META content=\"MSHTML 5.00.2920.0\" name=GENERATOR>\n    <LINK href=\"../html/RTEditorStyle.css\" rel=stylesheet type=\"text/css\"></LINK>\n\t<SCRIPT language=\"javascript\" src=\"../../eCommon/js/RTEditor.js\"></SCRIPT>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<!--Spell Checker Start-->\n\t<script type=\"text/javascript\" src=\"RapidSpell-DIALOG.js\"></script>\n\t<script type=\"text/javascript\" src=\"RapidSpell-AYT.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<!--Spell Checker End-->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<SCRIPT>\n//Spell Checker Start.\nrapidSpell.dialog_popupURL =  \" RapidSpellCheckerPopUp.jsp\";\nrapidSpell.ayt_helperURL = \"a.rapidspellweb?t=a\";\nrapidSpell.setParameterValue(\'default\', \'DictFile\', \'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\');  //IN035323\nrapidSpell.setParameterValue(\'default\', \'UserDictionaryFile\', \'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\');\nrapidSpell.setParameterValue(\'default\', \'IgnoreXML\', true);\n //IN035323 Start.\nstaticImage1 = new Image();\n\tstaticImage1.src = \"../../eCA/images/out1.png\";\noverImage1 = new Image();\n\toverImage1.src = \"../../eCA/images/over1.png\";\ndownImage1 = new Image();\n\tdownImage1.src = \"../../eCA/images/down1.png\";\n //IN035323 End.\nfunction RSCustomInterface(rtbElementName){\n\tthis.rtbName = rtbElementName;this.getText = getText;this.setText = setText;\n\tfunction getText(){\n\t\t\t return document.getElementById(this.rtbName).contentWindow.document.body.innerHTML;\n\t\t\t}\n\tfunction setText(text){ \n\t\t\t\tdocument.getElementById(this.rtbName).contentWindow.document.body.innerHTML = text;\n\t\t\t}\n}\n\n//Spell Checker End.\n</SCRIPT>\n</HEAD>\n<body style=\"overflow-y:hidden\" onLoad=\"callInstantiateEditor()\" onKeyDown = \'lockKey()\'>\n    <left>\n    <table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" width=\"70%\" height=\"100%\">\n    <tr>\n        <td id=\"EDITOR_TOP_TOOLBAR\" class=\"Toolbar\">\n            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">\n            <tr>\n                <td>\n                    <div class=\"Space\"></div>\n                </td>\n                <td>\n                    <div class=\"Swatch\"></div>\n                </td>\n                <td>\n                    <span id=\"EDITOR_PARAGRAPH\" style=\"display\">\n                    <select name=\"format_mode\" id=\"format_mode\" class=\"List\" onchange=\"EditorOnParagraph(\'0\', this)\">\n                    <option class=\"Heading\">Paragraph</option>\n                    <option value=\"Address\">Normal</option><!-- Normal -->\n                    <option value=\"Heading 1\">Heading 1 &lt;H1&gt;</option>\n                    <option value=\"Heading 2\">Heading 2 &lt;H2&gt;</option>\n                    <option value=\"Heading 3\">Heading 3 &lt;H3&gt;</option>\n                    <option value=\"Heading 4\">Heading 4 &lt;H4&gt;</option>\n                    <option value=\"Heading 5\">Heading 5 &lt;H5&gt;</option>\n                    <option value=\"Heading 6\">Heading 6 &lt;H6&gt;</option>\n                    <option value=\"Normal\">Address &lt;ADDR&gt;</option>\n                    <option value=\"Formatted\">Formatted &lt;PRE&gt;</option>\n                    </select>\n                    </span>\n                </td>\n                <td>\n                    <select class=\"List\" onchange=\"EditorOnFont(\'0\', this)\">\n                    <option class=\"Heading\">Font</option>\n                    <option value=\"Arial\">Arial</option>\n                    <option value=\"Arial Black\">Arial Black</option>\n                    <option value=\"Arial Narrow\">Arial Narrow</option>\n                    <option value=\"Comic Sans MS\">Comic Sans MS</option>\n                    <option value=\"Courier New\">Courier New</option>\n                    <option value=\"Garamond\">Garamond</option>\n                    <option value=\"Sans Serif\">Sans Serif</option>\n                    <option value=\"System\">System</option>\n                    <option value=\"Times New Roman\">Times New Roman</option>\n                    <option value=\"Verdana\">Verdana</option>\n                    <option value=\"Wingdings\">Wingdings</option>\n                    </select>\n                </td>\n                <td>\n                    <select class=\"List\" onchange=\"EditorOnSize(\'0\', this)\">\n                    <option class=\"Heading\">Size</option>\n                    <option value=\"1\">1</option>\n                    <option value=\"2\">2</option>\n                    <option value=\"3\">3</option>\n                    <option value=\"4\">4</option>\n                    <option value=\"5\">5</option>\n                    <option value=\"6\">6</option>\n                    <option value=\"7\">7</option>\n                    </select>\n                </td>\n                <td>\n                    <div class=\"Divider\"></div>\n                </td>\n                <td class=\"Text\">&nbsp;\n                </td>\n            </tr>\n            </table>\n        </td>\n    </tr>\n    <tr>\n        <td id=\"EDITOR_BOTTOM_TOOLBAR\" class=\"Toolbar\">\n            <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">\n            <tr>\n                <td>\n                    <div class=\"Space\"></div>\n                </td>\n                <td>\n                    <div class=\"Swatch\"></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_1\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_1\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/cut.gif\" id=\'img_cut\' onClick=\'EditorOnCut(this)\' title=\'Cut\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_1\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_2\" class=\"ButtonNormal\"  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_2\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/copy.gif\" id=\'img_copy\' onClick=\'EditorOnCopy(this)\' title=\'Copy\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_2\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_3\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_3\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/paste.gif\" id=\'img_paste\' onClick=\'EditorOnPaste(this)\' title=\'Paste\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_3\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div class=\"Divider\"></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_4\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_4\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/bold.gif\" id=\'img_bold\' onClick=\'EditorOnBold(this)\' title=\'Bold\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_4\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_5\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_5\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/italic.gif\" id=\'img_italic\' onClick=\'EditorOnItalic(this)\' title=\'Italic\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_5\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_6\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_6\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/uline.gif\" id=\'img_uline\' onClick=\'EditorOnUnderline(this)\' title=\'Underline\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_6\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div class=\"Divider\"></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_7\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_7\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/undo.gif\" id=\'img_undo\' onClick=\'EditorOnUndo(this)\' title=\'Undo\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_7\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_8\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_8\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/redo.gif\" id=\'img_redo\' onClick=\'EditorOnRedo(this)\' title=\'Redo\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_8\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div class=\"Divider\"></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_9\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_9\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/tpaint.gif\" id=\'img_tpaint\' onClick=\'EditorOnForegroundColor(this)\' title=\'Foreground Color\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_9\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_10\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_10\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/parea.gif\" id=\'img_parea\' onClick=\'EditorOnBackgroundColor(this)\' title=\'Background Color\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_10\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div class=\"Divider\"></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_11\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_11\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/aleft.gif\" id=\'img_aleft\' onClick=\'EditorOnAlignLeft(this)\' title=\'Align Left\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_11\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_12\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_12\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/center.gif\" id=\'img_center\' onClick=\'EditorOnCenter(this)\' title=\'Align Center\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_12\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div id=\"BUTTON_DIV_13\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" >\n                    <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_13\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/aright.gif\" id=\'img_aright\' onClick=\'EditorOnAlignRight(this)\' title=\'Align Right\' class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_13\" width=2 height=2></td></tr></table></div>\n                </td>\n                <td>\n                    <div class=\"Divider\"></div>\n                </td>\n                <td id=\"EDITOR_LIST_AND_INDENT_1\" style=\"display:inline\">\n                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">\n                    <tr>\n                    <td>\n                        <div id=\"BUTTON_DIV_14\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n                        <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_14\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/nlist.gif\" id=\'img_nlist\' onClick=\'EditorOnNumberedList(this)\' title=\"Numbered List\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_14\" width=2 height=2></td></tr></table></div>\n                    </td>\n                    <td>\n                        <div id=\"BUTTON_DIV_15\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n                        <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_15\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/blist.gif\" id=\'img_blist\' onClick=\'EditorOnBullettedList(this)\' title=\"Bulletted List\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_15\" width=2 height=2></td></tr></table></div>\n                    </td>\n                    <td>\n                        <div class=\"Divider\"></div>\n                    </td>\n                    <td>\n                        <div id=\"BUTTON_DIV_16\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >\n                        <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_16\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/ileft.gif\" id=\'img_ileft\' onClick=\'EditorOnDecreaseIndent(this)\' title=\"Decrease Indent\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_16\" width=2 height=2></td></tr></table></div>\n                    </td>\n                    <td>\n                        <div id=\"BUTTON_DIV_17\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >\n                        <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_17\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/iright.gif\" id=\'img_iright\' onClick=\'EditorOnIncreaseIndent(this)\' title=\"Increase Indent\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_17\" width=2 height=2></td></tr></table></div>\n                    </td>\n                    <td>\n                        <div class=\"Divider\"></div>\n                    </td>\n                    <td>\n                        <div id=\"BUTTON_DIV_18\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n                        <table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_18\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../images/clear.gif\" id=\'img_clear\' onClick=\'EditorOnClear(this)\' title=\"Clear Page\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_18\" width=2 height=2></td></tr></table></div>\n                    </td>\n\t\t\t\t\t<!--Spell Checker Start-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div class=\"Divider\"></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--  IN035323 Start. -->\n\t\t\t\t\t\t<!--  \n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div id=\"BUTTON_DIV_20\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_20\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCA/images/out1.png\" id=\'img_symbol\' onClick=\"rapidSpell.dialog_spellCheck(true, \'RTEditor0\');\" title=\"Spell Check Popup\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_20\" width=2 height=2></td></tr></table></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t-->\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div id=\"BUTTON_DIV_20\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_20\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCA/images/out1.png\" id=\'img_spell1\' onMouseOver=\"img_spell1.src=overImage1.src;\" onMouseOut=\"img_spell1.src=staticImage1.src;\" onMouseDown=\"img_spell1.src=downImage1.src;\" onClick=\"rapidSpell.dialog_spellCheck(true, \'RTEditor0\');\" title=\"Spell Check Popup\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_20\" width=2 height=2></td></tr></table></div>\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t<!--  IN035323 End. -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div class=\"Divider\"></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!--  IN035323 Start. -->\n\t\t\t\t\t\t<!--\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div id=\"BUTTON_DIV_21\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_21\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCA/images/out1.png\" id=\'img_symbol\' onClick=\"rapidSpell.ayt_spellCheck(\'RTEditor0\');document.getElementById(\'RTEditor0_D\').style.overflowX = \'hidden\';\" title=\"Spell Check Inline\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_21\" width=2 height=2></td></tr></table></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t-->\n\t\t\t\t\t\t<!--  IN035323 End. -->\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<div id=\"BUTTON_DIV_21\" class=\"ButtonNormal\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\t\t\t\t\t\t\t<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_21\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCA/images/out1.png\" id=\'img_spell2\' onMouseOver=\"img_spell2.src=overImage1.src;\" onMouseOut=\"img_spell2.src=staticImage1.src;\" onMouseDown=\"img_spell2.src=downImage1.src;\" onClick=\"rapidSpell.ayt_spellCheck(\'RTEditor0\');document.getElementById(\'RTEditor0_D\').style.overflowX = \'hidden\';\" title=\"Spell Check Inline\" class=\'Image\'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_21\" width=2 height=2></td></tr></table></div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<!--Spell Checker End-->\n                    </tr>\n                    </table>\n                </td>\n            </tr>\n            </table>\n        </td>\n    </tr>\n    <tr>\n        <td>\n            <iframe id=\"RTEditor0\" name=\"RTEditor0\"  style=\"width:98vw;height:77vh\">\n            </iframe>\n        </td>\n    </tr>\n    </table>\n\n<FORM name=\'RTEditorForm\' id=\'RTEditorForm\'>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n<DIV id=plainmsg style=\"HEIGHT:0px; Width:0Px; LEFT: 0px; POSITION: absolute; TOP: 0px; VISIBILITY: hidden\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</DIV>\n</FORM>\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

    String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";
	//Spell Checker Start
	String spellCheckType="";
	//IN035323 Start.
	String backSlash = "\\";
	String frontSlash = "/";
	String dictFilePath = "";	
	//IN035323 End.
	
	//User Dictionary Path
	String 	userid	=	(String)session.getValue("login_user");
	//String dictFileName = "~/userdictionaries/";
	String dictFileName = "~/eCA/userdictionaries/";
	String userDictionary = userid+"-dictionary.txt";
	dictFileName = dictFileName + userDictionary;
	//IN035323 Start.
	String dictPath = session.getServletContext().getRealPath(dictFileName);
	dictFilePath = dictPath.replace(backSlash, frontSlash);	

	//Medical Dictionary Path
	String medDictFilePath = "";
	String medDictPath = session.getServletContext().getRealPath("~/eCA/Dictionaries/DICT-EN-G-UK+US.dict");
	medDictFilePath = medDictPath.replace(backSlash, frontSlash);
    
	//IN035323 End.
	
	Connection			con					=	null;
	PreparedStatement	pstmt				=	null;
	ResultSet			rs					=	null;
	
	try
	{
		
		con	= ConnectionManager.getConnection(request);
		String query1 = " SELECT SPELL_CHK_DEF_OPT SPELLCHECKTYPE FROM CA_NOTE_PARAM WHERE SPELL_CHK_REQ_YN = 'Y'  ";
		pstmt		=	con.prepareStatement(query1);
		rs			=	pstmt.executeQuery();
		if(rs.next())
		{
			spellCheckType		= rs.getString("SPELLCHECKTYPE");
			
		}
		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();
	
	}catch(Exception e){
		e.printStackTrace();
		
		out.println("Exception@2: "+e);
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);


	}
	//Spell Checker End

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( medDictFilePath));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( dictFileName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block24Bytes, _wl_block24);
 if("P".equals(spellCheckType)){
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block27Bytes, _wl_block27);
}else if("I".equals(spellCheckType)){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(button_events));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);

	request.setCharacterEncoding("UTF-8");	
    String RTEText  =   "";

    RTEText         =   request.getParameter("RTEText");

	if(RTEText == null || RTEText.equals("null")) 
		RTEText = "";
    
	RTEText         =   java.net.URLDecoder.decode(RTEText,"UTF-8");

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(RTEText));
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

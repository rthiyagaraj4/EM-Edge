<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created	
---------------------------------------------------------------------------------------------------------------
-->
<!--Spell Checker Start-->
<!-- page contentType="text/html;charset=UTF-8" %> -->
<%@ page contentType="text/html;charset=UTF-8" import="org.w3c.dom.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<!--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> -->

<%@ taglib uri="/WEB-INF/tld/RapidSpellWeb.tld" prefix="RapidSpellWeb" %>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd"> -->
<!--Spell Checker End-->
<HTML>
<HEAD>
    <TITLE>Clinician Access - Rich Text Editor</TITLE>
    <META content="text/html; charset=UTF-8" http-equiv=Content-Type>
    <META content="MSHTML 5.00.2920.0" name=GENERATOR>
    <LINK href="../../eCommon/html/RTEditorStyle.css" rel=stylesheet type="text/css"></LINK>
	<SCRIPT language="javascript" src="../../eOR/js/RTEditor.js"></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
    String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";
String readOnly = request.getParameter("readOnly")==null?"":request.getParameter("readOnly");
String disableToolbar = "";
if(!"Y".equals(readOnly))
{
	disableToolbar = "disabled";
}
%>
</HEAD>
<!--<body style="overflow-y:hidden" onLoad="callInstantiateEditor()" onKeyDown = 'lockKey()'>-->
<body onKeyDown = 'lockKey()'>
    <center>
    <table cellpadding="0" cellspacing="0" border="1" width="100%" >
    <tr>
        <td id="EDITOR_TOP_TOOLBAR" class="Toolbar">
            <table cellpadding="0" cellspacing="0" border="0" height="100%">
            <tr>
                <td>
                    <div class="Space"></div>
                </td>
                <td>
                    <div class="Swatch"></div>
                </td>
                <td>
                    <span id="EDITOR_PARAGRAPH" style="display:inline" <%=disableToolbar%>>
                    <select name="format_mode" id="format_mode" class="List" onchange="EditorOnParagraph('0', this)">
                    <option class="Heading">Paragraph</option>
                    <option value="Address">Normal</option><!-- Normal -->
                    <option value="Heading 1">Heading 1 &lt;H1&gt;</option>
                    <option value="Heading 2">Heading 2 &lt;H2&gt;</option>
                    <option value="Heading 3">Heading 3 &lt;H3&gt;</option>
                    <option value="Heading 4">Heading 4 &lt;H4&gt;</option>
                    <option value="Heading 5">Heading 5 &lt;H5&gt;</option>
                    <option value="Heading 6">Heading 6 &lt;H6&gt;</option>
                    <option value="Normal">Address &lt;ADDR&gt;</option>
                    <option value="Formatted">Formatted &lt;PRE&gt;</option>
                    </select>
                    </span>
                </td>
                <td>
                    <select class="List" onchange="EditorOnFont('0', this)" <%=disableToolbar%>>
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
                </td>
                <td>
                    <select class="List" onchange="EditorOnSize('0', this)" <%=disableToolbar%>>
                    <option class="Heading">Size</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    </select>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td class="Text">&nbsp;
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td id="EDITOR_BOTTOM_TOOLBAR" class="Toolbar">
            <table cellpadding="0" cellspacing="0" border="0" height="100%">
            <tr>
                <td>
                    <div class="Space"></div>
                </td>
                <td>
                    <div class="Swatch"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_1" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_1" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/cut.gif" id='img_cut' onClick='EditorOnCut(this)' title='Cut' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_1" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_2" class="ButtonNormal"  <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_2" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/copy.gif" id='img_copy' onClick='EditorOnCopy(this)' title='Copy' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_2" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_3" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_3" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/paste.gif" id='img_paste' onClick='EditorOnPaste(this)' title='Paste' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_3" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_4" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_4" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/bold.gif" id='img_bold' onClick='EditorOnBold(this)' title='Bold' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_4" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_5" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_5" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/italic.gif" id='img_italic' onClick='EditorOnItalic(this)' title='Italic' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_5" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_6" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_6" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/uline.gif" id='img_uline' onClick='EditorOnUnderline(this)' title='Underline' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_6" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_7" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_7" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/undo.gif" id='img_undo' onClick='EditorOnUndo(this)' title='Undo' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_7" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_8" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_8" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/redo.gif" id='img_redo' onClick='EditorOnRedo(this)' title='Redo' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_8" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_9" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_9" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/tpaint.gif" id='img_tpaint' onClick='EditorOnForegroundColor(this)' title='Foreground Color' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_9" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_10" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_10" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/parea.gif" id='img_parea' onClick='EditorOnBackgroundColor(this)' title='Background Color' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_10" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_11" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_11" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/aleft.gif" id='img_aleft' onClick='EditorOnAlignLeft(this)' title='Align Left' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_11" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_12" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_12" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/center.gif" id='img_center' onClick='EditorOnCenter(this)' title='Align Center' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_12" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_13" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_13" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/aright.gif" id='img_aright' onClick='EditorOnAlignRight(this)' title='Align Right' class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_13" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td id="EDITOR_LIST_AND_INDENT_1" style="display:inline">
                    <table cellpadding="0" cellspacing="0" border="0" height="100%">
                    <tr>
                    <td>
                        <div id="BUTTON_DIV_14" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_14" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/nlist.gif" id='img_nlist' onClick='EditorOnNumberedList(this)' title="Numbered List" class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_14" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_15" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_15" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/blist.gif" id='img_blist' onClick='EditorOnBullettedList(this)' title="Bulletted List" class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_15" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div class="Divider"></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_16" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_16" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/ileft.gif" id='img_ileft' onClick='EditorOnDecreaseIndent(this)' title="Decrease Indent" class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_16" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_17" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_17" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/iright.gif" id='img_iright' onClick='EditorOnIncreaseIndent(this)' title="Increase Indent" class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_17" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div class="Divider"></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_18" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_18" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/clear.gif" id='img_clear' onClick='EditorOnClear(this)' title="Clear Page" class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_18" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_19" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_19" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eOR/images/Save.png" id='img_save' onClick='editorOnSave(this)' title="Save" class='Image' <%=disableToolbar%>></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_19" width=2 height=2></td></tr></table></div>
                    </td>										
                    </tr>
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <iframe id="RTEditor0" name='RTEditor0' width="80vw" height="80vh">
            </iframe>      
        </td>        
    </tr>
    </table>
   
<FORM name='RTEditorForm' id='RTEditorForm'>
<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String RTEText  =   "";

    RTEText         =   request.getParameter("RTEText");

    if(RTEText == null || RTEText.equals("null")) 
		RTEText = "";
    
	RTEText         =   java.net.URLDecoder.decode(RTEText,"UTF-8");

%>
<DIV id=plainmsg style="HEIGHT:0px; Width:0Px; LEFT: 0px; POSITION: absolute; TOP: 0px; VISIBILITY: hidden"><%=RTEText%></DIV>
</FORM>
</body>
</HTML>


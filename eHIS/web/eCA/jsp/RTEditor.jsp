<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
14/08/2012	  IN034340		Dinesh T	 For retaining the copy paste content format from MS Document	
13/09/2012    IN029712	    Akbar        BRU-hims-CRF-001 - Spell check CRF
21/09/2012	  IN035323		Ramesh G	 Bru-HIMS-CRF-001 /02- Add Button not displayed	
21/05/2013	  IN030708			Nijitha S	Bru-HIMS-CRF-221	
29/05/2013	  IN040353		Ramesh G	 CRF-CA-Bru-HIMS-CRF-221/06-Text Block->System is displaying Script Error on clicking 'Symbols' icon
---------------------------------------------------------------------------------------------------------------
-->
<!--Spell Checker Start-->
<!-- page contentType="text/html;charset=UTF-8" %> -->
<%@ page contentType="text/html;charset=UTF-8" import="org.w3c.dom.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<!--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"> -->

<%@ taglib uri="/WEB-INF/tld/RapidSpellWeb.tld" prefix="RapidSpellWeb" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
<!--Spell Checker End-->
<HTML>
<HEAD>
    <TITLE>Clinician Access - Rich Text Editor</TITLE>
    <META content="text/html; charset=UTF-8" http-equiv=Content-Type>
    <META content="MSHTML 5.00.2920.0" name=GENERATOR>
    <LINK href="../../eCommon/html/RTEditorStyle.css" rel=stylesheet type="text/css"></LINK>    
	<SCRIPT language="javascript" src="../../eCA/js/RTEditor.js"></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<!--Spell Checker Start-->
	<script type="text/javascript" src="RapidSpell-DIALOG.js"></script>
	<script type="text/javascript" src="RapidSpell-AYT.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!--Spell Checker End-->
<%
    String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";

	String editor_param= request.getParameter("editor_param")==null?"":request.getParameter("editor_param");
	String call_from= request.getParameter("call_from")==null?"":request.getParameter("call_from");
	
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
		
		//out.println("Exception@2: "+e);//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);


	}
	//Spell Checker End.

%>
<SCRIPT>
function compressSectionFrames()
{	
	
	if(parent.parent.RecClinicalNotesSecDetailsFrame.location.href.indexOf("/blank.html")==-1)
	{			
		parent.parent.frameSetIdSection.cols='4%,96%,0%';
		
		parent.parent.RecClinicalNotesSectionFrame.document.getElementById("tb1").style.display="none";
		parent.parent.RecClinicalNotesSectionFrame.document.getElementById("tbl_section").style.display="none";
		parent.parent.RecClinicalNotesSectionFrame.document.getElementById("sectionLineTable").style.display="inline";
		//checking in case of Addendum -----increasing the width of the textarea
		if(parent.parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm!=null)
		{
			parent.parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.cols="105";
		}
	}
}
function fnEnableLinks(){	
		//[IN033180]if ("<%=call_from%>" != 'Clinical_Event' )
	    if ("<%=call_from%>" != 'Clinical_Event' && "<%=call_from%>" != 'Text_Block') //[IN033180]
	    {	    
			if ("<%=editor_param%>" == 'R')
			{
					parent.frameSetIdMessage.rows='*%,0%'			
			}else if ("<%=editor_param%>" == 'A')		//[IN033869]
			{
					parent.parent.frameSetIdMessage.rows='*%,0%'			
			}else{
				parent.parent.frameSetIdMessage.rows='*%,0%'
				compressSectionFrames();
			}
			//
		}
		//RTEditor0.document.body.contentEditable = "True";
		RTEditor0.contentDocument.body.contentEditable = "True";
	}
//Spell Checker Start.
rapidSpell.dialog_popupURL =  "RapidSpellCheckerPopUp.jsp";
rapidSpell.ayt_helperURL = "a.rapidspellweb?t=a";
rapidSpell.setParameterValue('default', 'DictFile', '<%= medDictFilePath%>');  //IN035323
rapidSpell.setParameterValue('default', 'UserDictionaryFile', '<%= dictFileName%>');
rapidSpell.setParameterValue('default', 'IgnoreXML', true);
 //IN035323 Start.
staticImage1 = new Image();
	staticImage1.src = "../../eCA/images/out1.png";
overImage1 = new Image();
	overImage1.src = "../../eCA/images/over1.png";
downImage1 = new Image();
	downImage1.src = "../../eCA/images/down1.png";
 //IN035323 End.
function RSCustomInterface(rtbElementName){
	this.rtbName = rtbElementName;this.getText = getText;this.setText = setText;
	function getText(){
			 return document.getElementById(this.rtbName).contentWindow.document.body.innerHTML;
			}
	function setText(text){ 
				document.getElementById(this.rtbName).contentWindow.document.body.innerHTML = text;
			}
}

//Spell Checker End.
</SCRIPT>
</HEAD>
<body style="overflow-y:hidden" onLoad="callInstantiateEditor()" onKeyDown="lockKey()">
    <center>
    <table cellpadding="0" cellspacing="0" border="1" width="100%" height="100%" name='RTEditorTable' id='RTEditorTable' style="height:95vh">
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
                    <span id="EDITOR_PARAGRAPH" style="display">
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
                    <select class="List" onchange="EditorOnFont('0', this)">
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
                    <select class="List" onchange="EditorOnSize('0', this)">
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
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_1" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/cut.gif" id='img_cut' onClick='EditorOnCut(this)' title='Cut' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_1" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_2" class="ButtonNormal"  <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_2" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/copy.gif" id='img_copy' onClick='EditorOnCopy(this)' title='Copy' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_2" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_3" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_3" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/paste.gif" id='img_paste' onClick='EditorOnPaste(this)' title='Paste' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_3" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_4" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_4" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/bold.gif" id='img_bold' onClick='EditorOnBold(this)' title='Bold' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_4" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_5" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_5" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/italic.gif" id='img_italic' onClick='EditorOnItalic(this)' title='Italic' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_5" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_6" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_6" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/uline.gif" id='img_uline' onClick='EditorOnUnderline(this)' title='Underline' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_6" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_7" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_7" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/undo.gif" id='img_undo' onClick='EditorOnUndo(this)' title='Undo' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_7" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_8" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_8" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/redo.gif" id='img_redo' onClick='EditorOnRedo(this)' title='Redo' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_8" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_9" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_9" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/tpaint.gif" id='img_tpaint' onClick='EditorOnForegroundColor(this)' title='Foreground Color' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_9" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_10" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_10" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/parea.gif" id='img_parea' onClick='EditorOnBackgroundColor(this)' title='Background Color' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_10" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_11" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_11" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/aleft.gif" id='img_aleft' onClick='EditorOnAlignLeft(this)' title='Align Left' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_11" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_12" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_12" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/center.gif" id='img_center' onClick='EditorOnCenter(this)' title='Align Center' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_12" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div id="BUTTON_DIV_13" class="ButtonNormal" <%=button_events%> >
                    <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_13" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/aright.gif" id='img_aright' onClick='EditorOnAlignRight(this)' title='Align Right' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_13" width=2 height=2></td></tr></table></div>
                </td>
                <td>
                    <div class="Divider"></div>
                </td>
                <td id="EDITOR_LIST_AND_INDENT_1" style="display">
                    <table cellpadding="0" cellspacing="0" border="0" height="100%">
                    <tr>
                    <td>
                        <div id="BUTTON_DIV_14" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_14" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/nlist.gif" id='img_nlist' onClick='EditorOnNumberedList(this)' title="Numbered List" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_14" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_15" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_15" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/blist.gif" id='img_blist' onClick='EditorOnBullettedList(this)' title="Bulletted List" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_15" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div class="Divider"></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_16" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_16" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/ileft.gif" id='img_ileft' onClick='EditorOnDecreaseIndent(this)' title="Decrease Indent" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_16" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_17" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_17" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/iright.gif" id='img_iright' onClick='EditorOnIncreaseIndent(this)' title="Increase Indent" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_17" width=2 height=2></td></tr></table></div>
                    </td>
                    <td>
                        <div class="Divider"></div>
                    </td>
                    <td>
                        <div id="BUTTON_DIV_18" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_18" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/clear.gif" id='img_clear' onClick='EditorOnClear(this)' title="Clear Page" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_18" width=2 height=2></td></tr></table></div>
                    </td>
					<!-- IN030708 Start. -->
					<%if(!"Text_Block".equals(call_from)){%><!-- IN040353-->
					<td>
                        <div id="BUTTON_DIV_19" class="ButtonNormal" <%=button_events%> >
                        <table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_19" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCommon/images/Symbol.png" id='img_symbol' onClick='EditorOnSymbol(this)' title="Symbols" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_19" width=2 height=2></td></tr></table></div>
						
                    </td>
					<% } %> <!-- IN040353-->
					<!-- IN030708 End. -->
					<!--Spell Checker Start-->
					<% if("P".equals(spellCheckType)){%>
						<td>
							<div class="Divider"></div>
						</td>
						<!--  IN035323 Start. -->
						<!--  
						<td>
							<div id="BUTTON_DIV_20" class="ButtonNormal" <%=button_events%> >
							<table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_20" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCA/images/out1.png" id='img_symbol' onClick="rapidSpell.dialog_spellCheck(true, 'RTEditor0');" title="Spell Check Popup" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_20" width=2 height=2></td></tr></table></div>
						</td>
						-->
						<td>
							<div id="BUTTON_DIV_20" class="ButtonNormal" <%=button_events%> >
							<table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_20" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCA/images/out1.png" id='img_spell1' onMouseOver="img_spell1.src=overImage1.src;" onMouseOut="img_spell1.src=staticImage1.src;" onMouseDown="img_spell1.src=downImage1.src;" onClick="rapidSpell.dialog_spellCheck(true, 'RTEditor0');" title="Spell Check Popup" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_20" width=2 height=2></td></tr></table></div>
						</td>	
						<!--  IN035323 End. -->
					<%}else if("I".equals(spellCheckType)){%>
						<td>
							<div class="Divider"></div>
						</td>
						<!--  IN035323 Start. -->
						<!--
						<td>
							<div id="BUTTON_DIV_21" class="ButtonNormal" <%=button_events%> >
							<table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_21" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCA/images/out1.png" id='img_symbol' onClick="rapidSpell.ayt_spellCheck('RTEditor0');document.getElementById('RTEditor0_D').style.overflowX = 'hidden';" title="Spell Check Inline" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_21" width=2 height=2></td></tr></table></div>
						</td>
						-->
						<!--  IN035323 End. -->
						<td>
							<div id="BUTTON_DIV_21" class="ButtonNormal" <%=button_events%> >
							<table cellpadding=0 cellspacing=0 border=0 width="100%"><tr><td><img id="PAD1_PREFIX_21" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src="../../eCA/images/out1.png" id='img_spell2' onMouseOver="img_spell2.src=overImage1.src;" onMouseOut="img_spell2.src=staticImage1.src;" onMouseDown="img_spell2.src=downImage1.src;" onClick="rapidSpell.ayt_spellCheck('RTEditor0');document.getElementById('RTEditor0_D').style.overflowX = 'hidden';" title="Spell Check Inline" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id="PAD2_PREFIX_21" width=2 height=2></td></tr></table></div>
						</td>
					<%}%>
					<!--Spell Checker End-->
                    </tr>
                    </table>
                </td>
            </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td>
            <iframe id="RTEditor0" width="100%" height="100%">
            </iframe>
        </td>
    </tr>
    </table>

<FORM name='RTEditorForm' id='RTEditorForm'>
<%
	//request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String RTEText  =   "";
	if ("Text_Block".equals(call_from)) //[IN033180]
	{
		RTEText         =   session.getAttribute("TEXTBLOCK_CONTENT")==null? "" :(String)session.getAttribute("TEXTBLOCK_CONTENT");
		
	}else{
		RTEText         =   request.getParameter("RTEText");
	}
	if(RTEText == null || RTEText.equals("null")) 
		RTEText = "";
    
	RTEText         =   java.net.URLDecoder.decode(RTEText,"UTF-8");
	RTEText = RTEText.replace("#DQ#","\"");//IN034340 
%>

<DIV id=plainmsg style="HEIGHT:0px; Width:0Px; LEFT: 0px; POSITION: absolute; TOP: 0px; VISIBILITY: hidden"><%=RTEText%></DIV>
<%
	out.println("<script>");	
	out.println("setTimeout('fnEnableLinks()',1500)");	
	out.println("</script>");  		
%>
</FORM>
</BODY>
</HTML>



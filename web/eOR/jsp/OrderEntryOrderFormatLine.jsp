<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	 created
25/08/2011    IN026010      Chowminya G      Incident No: IN026010 - <Orderformat Screen - Date time field - calendar action js error> 
08/09/2011    IN000767      Chowminya G      Incident No: IN000767 - <Orderformat header Screen - radio button validation error> 
05/09/2012	  IN034813		vijayakumar k	 Incident No: IN034813 (SKR-SCF-610)-  system display script error in calendar
01/10/2012    IN035189      Dinesh T		Thai Date conversions problem in normal and amend mode
27/09/2013	  IN043095		Nijitha S		CRF-OT-Bru-HIMS-CRF-004.2/02- Booking Priority field in not displayed for "System defined" order entry format item		
19/09/2013	  IN034497		Chowminya		Multi presentation Multi selection alignment issue
14/11/2013    IN044959		Chowminya		 OT Duration blank after recent changes, renamed old_field_mnemonic to field_mnemonic
21/11/2013	  IN045005		Chowminya		 [Reopen]LMP Date validation issue
04/12/2013	  IN045352		Nijitha S		CRF-OR-Bru-HIMS-CRF-004.3/03-Dependency is not working when option is defaulted
11/12/2013  IN045512		Nijithas	    The dependent field option is not displayed in View Order Format
12/12/2013  IN045522		Nijithas		Regression-Alpha-OT-Script error when placing multiple OT orders
15/01/2014	  IN045798		Chowminya		The Original alignment of the Order format Items are getting changed in the Order format screen
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
21/02/2014    IN000000     Chowminya      Akbar			21/02/2014			Clinical event item link with order format not working for LB n RD(results)	 
18/03/2014	  IN047739     Chowminya							            SS-CRF-20038 - incorrect data while amending an RD Order 
20/03/2014	  IN047938	   Nijitha S										ML-BRU-SCF-1285
15/04/2014	  IN048553	   Chowminya										Script Error is displaying in order format window 		
05/06/2014    IN049124 	   Chowminya										PH-Orderformat - Drug remarks	
01/08/2014	  IN049133	   Chowminya										CRF:Disallow user to enter the future date in the LMP date field
19/08/2014    IN050610     Chowminya										CRF Link 2:dependency date validation differed in Order format 
10/10/2016    IN060565     Karthi L                                         ML-MMOH-SCF-0412
29/11/2016	  IN062319	   Karthi L											ML-MMOH-CRF-0508.1 [IN062319] 
01/08/2018		IN64543			Dinesh T		01/08/2018	Ramesh G		ML-MMOH-CRF-0776
04/02/2018	IN069657		DineshT				04/02/2018	Dinesh T		System defined component in Radiology Orders Order Format item is selected, Accept option is required. But , mandatory symbol is not displaying in Order Format Screen in place Order.
24/05/2019	 IN070534		Prakash C			24/05/2019	Ramesh G        BSP-SCF-0068
28/04/2020	  IN072511		Durga				28/04/2020	Ramesh G				MO-GN-5552
-----------------------------------------------------------------------------------------------------------------
-->

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<jsp:useBean id="beanFormatObj" scope="page" class="eOR.OrderEntryFormatBean"/>

<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	
	/* Initialize Function specific start */
	//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);
	beanFormatObj.setLanguageId(localeName);
	OrderEntryBean bean	  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
    bean.setLanguageId(localeName);
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	String chk_mand		= bean.checkForNull(request.getParameter("chk_mand"),"");
%>
<%!
//IN64543, starts
private ArrayList<String> editorFormation(String catalog_code,PageContext pageContext,String order_category)
{
	String button_events = "onselectstart=\"ButtonOnSelectStart()\" ondragstart=\"ButtonOnDragStart()\" onmousedown=\"ButtonOnMouseDown(this)\"  onmouseup=\"ButtonOnMouseUp(this)\" onmouseout=\"ButtonOnMouseOut(this)\" onmouseover=\"ButtonOnMouseOver(this)\" onclick=\"ButtonOnClick(this)\" ondblclick=\"ButtonOnDblClick(this)\" ";
	StringBuilder sb = new StringBuilder();
	StringBuilder waitForCompleteLoadIndiv = new StringBuilder();
	ArrayList<String> lst = new ArrayList<String>();	
	
	
	sb.append("<tr><td colspan=\"6\">");
	sb.append("<table width='100%'>");		
	sb.append("<tr>");
	sb.append("<td id = \"commentsInstrnTab"+catalog_code+"\"  style=\"cursor:pointer\" name = \"commentsInstrnTab"+catalog_code+"\" class=\"CLICKED\" width=\"25%\" onclick=\"loadEditorContent('CMTS',\'"+catalog_code+"\',this)\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+"</td>");
	sb.append("<td id = \"prepInstrnTab"+catalog_code+"\"  style=\"cursor:pointer\" name = \"prepInstrnTab"+catalog_code+"\" class=\"NORMAL\" width=\"25%\" onclick=\"loadEditorContent('PREPS',\'"+catalog_code+"\',this)\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PreparatoryInstruction.label","or_labels")+"</td>");
	sb.append("<td id = \"deptInstrnTab"+catalog_code+"\"  style=\"cursor:pointer\" name = \"deptInstrnTab"+catalog_code+"\" class=\"NORMAL\" width=\"25%\" onclick=\"loadEditorContent('DEPT',\'"+catalog_code+"\',this)\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentInstruction.label","or_labels")+"</td>");
	sb.append("<td id = \"patInstrnTab"+catalog_code+"\"  style=\"cursor:pointer\" name = \"patInstrnTab"+catalog_code+"\" class=\"NORMAL\" width=\"25%\" onclick=\"loadEditorContent('PATIENT',\'"+catalog_code+"\',this);\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PatientInstruction.label","or_labels")+"</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</td></tr>");
	sb.append("<tr><td colspan=\"6\">");
	sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" width=\"100%\" >");
	sb.append("<tr>");
	sb.append("<td  id=\"EDITOR_TOP_TOOLBAR"+catalog_code+"\" class=\"Toolbar\">");
	sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">");
 	sb.append("<tr>");
    sb.append("<td>");
    sb.append("<div class=\"Space\"></div>");
    sb.append("</td>");
    sb.append("<td>");
    sb.append("<div class=\"Swatch\"></div>");
    sb.append("</td>");
    sb.append("<td>");
    sb.append("<span id=\"EDITOR_PARAGRAPH\" style=\"display:inline\">");
    sb.append("<select name=\"format_mode"+catalog_code+"\" id=\"format_mode"+catalog_code+"\" class=\"List\" onchange=\"EditorOnParagraph('0', this,'"+catalog_code+"')\">");
    sb.append("<option class=\"Heading\">Paragraph</option>");
    sb.append("<option value=\"Address\">Normal</option>");
    sb.append("<option value=\"Heading 1\">Heading 1 &lt;H1&gt;</option>");
    sb.append("<option value=\"Heading 2\">Heading 2 &lt;H2&gt;</option>");
    sb.append("<option value=\"Heading 3\">Heading 3 &lt;H3&gt;</option>");
    sb.append("<option value=\"Heading 4\">Heading 4 &lt;H4&gt;</option>");
    sb.append("<option value=\"Heading 5\">Heading 5 &lt;H5&gt;</option>");
    sb.append("<option value=\"Heading 6\">Heading 6 &lt;H6&gt;</option>");
    sb.append("<option value=\"Normal\">Address &lt;ADDR&gt;</option>");
    sb.append("<option value=\"Formatted\">Formatted &lt;PRE&gt;</option>");
    sb.append("</select>");
    sb.append("</span>");
    sb.append("</td>");
    sb.append("<td>");
    sb.append("<select name=\"font"+catalog_code+"\" id=\"font"+catalog_code+"\" class=\"List\" onchange=\"EditorOnFont('0', this,'"+catalog_code+"')\">");
    sb.append("<option class=\"Heading\">Font</option>");
    sb.append("<option value=\"Arial\">Arial</option>");
    sb.append("<option value=\"Arial Black\">Arial Black</option>");
    sb.append("<option value=\"Arial Narrow\">Arial Narrow</option>");
    sb.append("<option value=\"Comic Sans MS\">Comic Sans MS</option>");
    sb.append("<option value=\"Courier New\">Courier New</option>");
    sb.append("<option value=\"Garamond\">Garamond</option>");
    sb.append("<option value=\"Sans Serif\">Sans Serif</option>");
    sb.append("<option value=\"System\">System</option>");
    sb.append("<option value=\"Times New Roman\">Times New Roman</option>");
    sb.append("<option value=\"Verdana\">Verdana</option>");
    sb.append("<option value=\"Wingdings\">Wingdings</option>");
    sb.append("</select>");
   	sb.append("</td>");
   	sb.append("<td>");
    sb.append("<select name=\"size"+catalog_code+"\" id=\"size"+catalog_code+"\" class=\"List\" onchange=\"EditorOnSize('0', this,'"+catalog_code+"')\">");
    sb.append("<option class=\"Heading\">Size</option>");
    sb.append("<option value=\"1\">1</option>");
    sb.append("<option value=\"2\">2</option>");
    sb.append("<option value=\"3\">3</option>");
    sb.append("<option value=\"4\">4</option>");
    sb.append("<option value=\"5\">5</option>");
    sb.append("<option value=\"6\">6</option>");
    sb.append("<option value=\"7\">7</option>");
    sb.append("</select>");
    sb.append("</td>");
    sb.append("<td>");
    sb.append("<div class=\"Divider\"></div>");
    sb.append("</td>");
    sb.append("<td class=\"Text\">&nbsp;");
    sb.append("</td>");
   	sb.append("</tr>");
   	sb.append("</table>");
  	sb.append("</td>");
	sb.append("</tr>");
	sb.append("<tr>");
	sb.append("<td id=\"EDITOR_BOTTOM_TOOLBAR\" class=\"Toolbar\">");
	sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">");
	sb.append("<tr>");
	sb.append("<td>");
	sb.append("<div class=\"Space\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Swatch\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_1"+catalog_code+"\" class=\"ButtonNormal\" "+button_events +">");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_1"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/cut.gif\" id='img_cut' onClick='EditorOnCut(this,\""+catalog_code+"\")' title='Cut' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_1"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_2"+catalog_code+"\" class=\"ButtonNormal\" "+ button_events+">");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_2"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/copy.gif\" id='img_copy' onClick='EditorOnCopy(this,\""+catalog_code+"\")' title='Copy' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_2"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_3"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+ ">");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_3"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/paste.gif\" id='img_paste' onClick='EditorOnPaste(this,\""+catalog_code+"\")' title='Paste' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_3"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_4"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_4"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/bold.gif\" id='img_bold' onClick='EditorOnBold(this,\""+catalog_code+"\")' title='Bold' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_4"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_5"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_5"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/italic.gif\" id='img_italic' onClick='EditorOnItalic(this,\""+catalog_code+"\")' title='Italic' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_5"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_6"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_6"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/uline.gif\" id='img_uline' onClick='EditorOnUnderline(this,\""+catalog_code+"\")' title='Underline' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_6"+catalog_code+"\"width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_7"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_7"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/undo.gif\" id='img_undo' onClick='EditorOnUndo(this,\""+catalog_code+"\")' title='Undo' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_7"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_8"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+">");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_8"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/redo.gif\" id='img_redo' onClick='EditorOnRedo(this,\""+catalog_code+"\")' title='Redo' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_8"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_9"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_9"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/tpaint.gif\" id='img_tpaint"+catalog_code+"\' onClick='EditorOnForegroundColor(this,\""+catalog_code+"\")' title='Foreground Color' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_9"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_10"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_10"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/parea.gif\" id='img_parea"+catalog_code+"\' onClick='EditorOnBackgroundColor(this,\""+catalog_code+"\")' title='Background Color' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_10"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_11"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_11"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/aleft.gif\" id='img_aleft' onClick='EditorOnAlignLeft(this,\""+catalog_code+"\")' title='Align Left' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_11"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_12"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+">");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_12"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/center.gif\" id='img_center' onClick='EditorOnCenter(this,\""+catalog_code+"\")' title='Align Center' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_12"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_13"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_13"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/aright.gif\" id='img_aright' onClick='EditorOnAlignRight(this,\""+catalog_code+"\")' title='Align Right' class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_13"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td id=\"EDITOR_LIST_AND_INDENT_1\" style=\"display:inline\">");
	sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" height=\"100%\">");
	sb.append("<tr>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_14"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_14"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/nlist.gif\" id='img_nlist' onClick='EditorOnNumberedList(this,\""+catalog_code+"\")' title=\"Numbered List\" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_14"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_15"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_15"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/blist.gif\" id='img_blist' onClick='EditorOnBullettedList(this,\""+catalog_code+"\")' title=\"Bulletted List\" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_15"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_16"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_16"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/ileft.gif\" id='img_ileft' onClick='EditorOnDecreaseIndent(this,\""+catalog_code+"\")' title=\"Decrease Indent\" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_16"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_17"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_17"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/iright.gif\" id='img_iright' onClick='EditorOnIncreaseIndent(this,\""+catalog_code+"\")' title=\"Increase Indent\" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_17"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div class=\"Divider\"></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_18"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_18"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eCommon/images/clear.gif\" id='img_clear"+catalog_code+"\' onClick='EditorOnClear(this,\""+catalog_code+"\")' title=\"Clear Page\" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_18"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("<td>");
	sb.append("<div id=\"BUTTON_DIV_19"+catalog_code+"\" class=\"ButtonNormal\" "+button_events+" >");
	sb.append("<table cellpadding=0 cellspacing=0 border=0 width=\"100%\"><tr><td><img id=\"PAD1_PREFIX_19"+catalog_code+"\" width=2 height=2></td><td ></td><td ></td></tr><tr><td></td><td><img src=\"../../eOR/images/Save.png\" id='img_save' onClick='editorOnSave(\""+catalog_code+"\")' title=\"Save\" class='Image'></td><td></td></tr><tr><td></td><td></td><td><img id=\"PAD2_PREFIX_19"+catalog_code+"\" width=2 height=2></td></tr></table></div>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("<tr>");
	sb.append("<td>");
	//sb.append("<iframe id=\"RTEditor"+catalog_code+"\" name=\"RTEditor"+catalog_code+"\" width=\"100%\" height=\"100%\" onblur=\"saveCurrentContent('"+catalog_code+"')\">");
	sb.append("<iframe id=\"RTEditor"+catalog_code+"\" name=\"RTEditor"+catalog_code+"\" width=\"100%\" height=\"100%\" >");
	sb.append("</iframe>");
	sb.append("</td>");
	sb.append("</tr>");
	sb.append("</table>");
	sb.append("</td></tr>");	
	sb.append("<tr><td colspan='6'>&nbsp;</td></tr>");
	sb.append("<tr><td class=\"fields\" colspan='4' id=\"saveMsg"+catalog_code+"\" align='left'></td></tr>");
	//sb.append("<td colspan='2' align='left'><a style='cursor:pointer'><img src=\"../../eCommon/images/enabled.gif\" title=\"OK\" onclick=\"saveCurrentContent('"+catalog_code+"')\"></img></a></td></tr>");
	sb.append("<tr><td colspan='6'>&nbsp;</td></tr>");
	sb.append("<input type='hidden' name='currSelectedTab"+catalog_code+"' id='currSelectedTab"+catalog_code+"' value = 'commentsInstrnTab"+catalog_code+"'>");
	sb.append("<input type='hidden' name='prevSelectedTab"+catalog_code+"' id='prevSelectedTab"+catalog_code+"' value = 'commentsInstrnTab"+catalog_code+"'>");
	sb.append("<input type='hidden' name='order_category"+catalog_code+"' id='order_category"+catalog_code+"' value = '"+order_category+"'>");
	

	waitForCompleteLoadIndiv.append("loadEditorContent('CMTS','"+catalog_code+"');");
	lst.add(sb.toString());
	lst.add(waitForCompleteLoadIndiv.toString());
	return lst;
}
//IN64543, ends
%>

<html>
    <head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
 		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
        <script language="javascript" src="../../eOR/js/RTEditor.js"></script><!--IN64543-->
        <script language='javascript' src='../../eCommon/js/common.js'></script>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
		<script language="Javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
		<script language='javascript' src='../../eOR/js/OrderEntry1.js' ></script>
		<script language='javascript' src='../../eOR/js/OrderEntryPreview.js' ></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryDecisionSupport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- For common lookup for the patient details-->
	

		<title><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></title>
			
    </head>
	<style>
textarea {
  resize: none;
}
</style>
    <body onUnload="removeAll()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" <%if(chk_mand.equals("RECORD"))  { %> onLoad="ClickClose()" <% }%> >
    <form name="OrderFormatForm" id="OrderFormatForm" method="post" >
    <table border="0" cellpadding="3" cellspacing="0" width="90%" align="center">
    <tr><td>
    <%!
		String order_catalog_code_arr[] 	= null;
		String order_type_arr[] 			= null;
		String priority_arr[] 				= null;
		String contr_msr_panel_id_arr[]		= null;
		String contr_msr_mod_id_arr[]		= null;
		String order_category_arr[] 		= null;
		String format_id_arr[]				= null;
		String pat_sex_yn_arr[]  			= null;
		String catalog_desc_arr[]			= null;
		String performing_facility_id_arr[] = null;
		String order_id[]					= null;
		String order_line_num[]				= null;
		//IN64543, starts
		/*String amend_line_comments[]		= null;
		String amend_line_preps[]			= null;
		String amend_line_pat_instrn[]		= null;
		String amend_line_dept_instrn[]		= null;*/
		//IN64543, ends
		String appt_time_arr[]				= null;
		String start_date_time_arr[]				= null;
		String instrn_content_type[]				= null;//IN64543
		Object patprepsinstrn   = "IS";
		Object prepsinstrn  = "PR";
		Object prepsdeptinstrn = "DR";
		String anatomyCode = "";
		String fixField = "";
		String tissueField = "";
		//int tr = 0;
		StringBuilder  sbTemplateDummy		= new StringBuilder("");
    %>
    <%
        String close_yn						= "N";
        ArrayList arrSeqNo					= new ArrayList();
		//int tr = 0;

        try
        {	
			
        	/*
			String care_set_catalog_code = bean.checkForNull(request.getParameter("care_set_catalog_code"),"");
	        String row_value				= bean.checkForNull(request.getParameter("row_value"),"");
            String ph_list_vals				= bean.checkForNull(request.getParameter("ph_list_vals"),"");
			*/
			Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
            // Remove the above one not used as of now...for Hdr...
            String called_from				= "";//bean.checkForNull(request.getParameter("called_from"),"");
			//String function_name			= bean.checkForNull(request.getParameter("function_name"),"");
		//contr_msr_panel_id' 	String pat_instrn_age_sex_yn	= "";//bean.checkForNull(request.getParameter("pat_instrn_age_sex_yn"),"");
			//String start_date_time[]=null;
            String catalog_code 			= "";//bean.checkForNull(request.getParameter("catalog_code"),"");
            String order_type_code			= "";// bean.checkForNull(request.getParameter("order_type_code"),"");
            String priority					= "";// bean.checkForNull(request.getParameter("priority"),"");
            String contr_msr_panel_id		= "";//bean.checkForNull(request.getParameter("contr_msr_panel_id"),"");
			String contr_msr_mod_id			= "";
            String order_category			= "";//bean.checkForNull(request.getParameter("order_category"),"");
            String format_id 				= "";//bean.checkForNull(request.getParameter("format_id"),"");
            //String catalog_desc 			= "";//bean.checkForNull(request.getParameter("catalog_desc"),"");
            String amend_order_id			= "", amend_order_line_num	= "";
			String sex						= bean.checkForNull(request.getParameter("sex"),"");
			String dob						= bean.checkForNull(request.getParameter("dob"),"");
			if(sex.equals(""))
				sex					     = bean.checkForNull(bean.getSex(),"");
			if(dob.equals(""))
				dob					     = bean.checkForNull(bean.getDob(),"");
			String multi_last_record		= "";
			
			//String p_catalog_code			= bean.checkForNull(request.getParameter("p_catalog_code"),"");
			//String p_form_code				= bean.checkForNull(request.getParameter("p_form_code"),"");
			//String p_route_code				= bean.checkForNull(request.getParameter("p_route_code"),"");
			String records[]				= null;
			//String format_id_yn				= bean.checkForNull(request.getParameter("format_id_yn"),"N");
			int total_rows          		= Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
			//String order_format_line_onload		     = bean.checkForNull(request.getParameter("order_format_line_onload"),"");//IN045512
			order_catalog_code_arr			= new String [total_rows];
			order_type_arr					= new String [total_rows];
			priority_arr					= new String [total_rows];
			contr_msr_panel_id_arr			= new String [total_rows];
			contr_msr_mod_id_arr			= new String [total_rows];
			order_category_arr				= new String [total_rows];
			format_id_arr					= new String [total_rows];
			pat_sex_yn_arr					= new String [total_rows];
			catalog_desc_arr				= new String [total_rows];
			performing_facility_id_arr		= new String [total_rows];
			order_id 						= new String [total_rows];
			order_line_num 					= new String [total_rows];
			//IN64543, starts
			/*amend_line_comments 			= new String [total_rows];
			amend_line_preps 				= new String [total_rows];
			amend_line_pat_instrn 			= new String [total_rows];
			amend_line_dept_instrn 			= new String [total_rows];*/
			//IN64543, ends
			appt_time_arr					= new String [total_rows];
			start_date_time_arr             = new String [total_rows];
			instrn_content_type             = new String [total_rows];//IN64543
				
			for(int i=0;i<total_rows;i++)
			{
	          	order_catalog_code_arr[i]	= bean.checkForNull(request.getParameter("catalog_code"+i),"");
				order_type_arr[i]	 		= bean.checkForNull(request.getParameter("order_type_code"+i),"");
				priority_arr[i]				= bean.checkForNull(request.getParameter("priority"+i),"");
				contr_msr_panel_id_arr[i]	= bean.checkForNull(request.getParameter("contr_msr_panel_id"+i),"");
				contr_msr_mod_id_arr[i]		= bean.checkForNull(request.getParameter("contr_msr_mod_id"+i),"");
				order_category_arr[i]	 	= bean.checkForNull(request.getParameter("order_category"+i),"");
				format_id_arr[i]			= bean.checkForNull(request.getParameter("format_id"+i),"");
				pat_sex_yn_arr[i]			= bean.checkForNull(request.getParameter("pat_instrn_age_sex_yn"+i),"");
				catalog_desc_arr[i]			= bean.checkForNull(request.getParameter("catalog_desc"+i),"");
				performing_facility_id_arr[i]= bean.checkForNull(request.getParameter("performing_facility_id"+i),"");
				order_id[i]					= bean.checkForNull(request.getParameter("order_id"+i),"");
				order_line_num[i]			= bean.checkForNull(request.getParameter("order_line_num"+i),"");
    				//IN64543, starts
				/*amend_line_comments[i]		= bean.checkForNull(request.getParameter("amend_line_comments"+i),"");
				amend_line_preps[i]			= bean.checkForNull(request.getParameter("amend_line_preps"+i),"");
				amend_line_pat_instrn[i]	= bean.checkForNull(request.getParameter("amend_line_pat_instrn"+i),"");
				amend_line_dept_instrn[i]	= bean.checkForNull(request.getParameter("amend_line_dept_instrn"+i),"");*/
				//IN64543, ends
				appt_time_arr[i]			= bean.checkForNull(request.getParameter("appt_time"+i),"");
				start_date_time_arr[i]			= bean.checkForNull(request.getParameter("start_date_time"+i),"");
				instrn_content_type[i]			= bean.checkForNull(request.getParameter("instrn_content_type"+i),"");//IN64543
			}
            String patient_id				= bean.getPatientId();
          	//  Get the patient_id 	 (For the current patient)
            //orderEntryRecordBean.getPatient(patient_id);
            StringBuffer  sbTemplate		= new StringBuffer("");
            Hashtable template				= null;
			Hashtable new_template			= null;
			//Hashtable dependencyMainTemplate= null;
			//Hashtable dependencyTemplate	= null;
            boolean exists					= false;
            if(!format_id.equals("")) amend_order_id = "";   // If Format Id is there, make the order_id as empty
            String field_mnemonic			= "";
            int seq_num						= 0 , max_dependency_row = 0 , new_seq_num = 0;
			int old_seq_num					= 0;
			//String old_field_mnemonic		="";//commented for checkstyle
			String performing_facility_id	= "";
			String login_facility_id		= bean.getLoginFacilityId();
			sex								= bean.getSex();
			String lab_install_yn				="N"; //bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N");
			String bt_install_yn="";
			String ot_install_yn="";
			String rd_install_yn="";
			ArrayList OrderFormatList			=	null;		 
			
           /* String label_text				= "";
            String accept_option			= "";
     	    String dflt_value				= "";
			String field_type				= "";
			String min_num_value			= "";
			String max_num_value			= "";
			String field_values				= "";
			*/
		//	String sql 						= "";
			String mode						= "";
			String order_type_short_desc 	= "";
			String ind_catalog_code			= "", ind_row_value			= "";
			String specimen_def_yn			= "N";
			String labmodule="";
			String called_from_fn		= bean.getCalledFromFunction();//IN045798
			String max_list_seq[] = null;//IN047739   
			String max_seq ="";//IN047739
			
			
			//int 	count						= 0;
			//int dependency_seq_num			= 0;
			//String[] dependencyRecords		= null;
			//ArrayList OrderDependencyFormat	= new ArrayList();
 			//arrSeqNo							= (java.util.ArrayList)	orderEntryRecordBean.getOrderFormats("LINE_LEVEL", "0");
			//if(arrSeqNo==null || arrSeqNo.size()==0) // If it is already there in the bean
            //{
           		for(int i=0;i<total_rows;i++)
            	{
					catalog_code			= order_catalog_code_arr[i];
					order_type_code			= order_type_arr[i];
 					priority				= priority_arr[i];
					contr_msr_panel_id		= bean.checkForNull(contr_msr_panel_id_arr[i],"");
					contr_msr_mod_id		= bean.checkForNull(contr_msr_mod_id_arr[i],"");
					performing_facility_id  = bean.checkForNull(performing_facility_id_arr[i],"");
					order_category			= order_category_arr[i];
					format_id				= bean.checkForNull(format_id_arr[i],"");
					amend_order_id			= bean.checkForNull(order_id[i],"");
					amend_order_line_num    = bean.checkForNull(order_line_num[i],"");
     	 	      	//ind_row_value			= (ind_catalog_code+"_"+row_value);
     	 	      	ind_row_value			= (catalog_code+"_0");
					ind_catalog_code		= catalog_code;
					if(order_category.equalsIgnoreCase("LB"))
					{
						if(bt_install_yn.equals(""))
						{
							bt_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("LB"),"N");					
						}
					}					
					else if(order_category.equalsIgnoreCase("OT"))
					{
						if(ot_install_yn.equals(""))
						{
							ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N");
						}
					}
					else if(order_category.equalsIgnoreCase("RD"))
					{
						if(rd_install_yn.equals(""))
						{
							rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
						}
					}
				
					labmodule=bean.checkForNull((String)bean.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id),"");
					if(labmodule.equalsIgnoreCase("IBARL"))
					{
						lab_install_yn="Y";
					}
					else
					{
						lab_install_yn="N";
					}
					
			    	arrSeqNo				= (ArrayList)	orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
 				 if(arrSeqNo==null || arrSeqNo.size()==0) // If it is already there in the bean
            	 {
            			arrSeqNo				= new ArrayList();
            			ArrayList OrderFormat 	= new ArrayList();
						OrderFormat				= bean.getOrderFormat(format_id,order_category,amend_order_id,called_from,amend_order_line_num,priority,sex,dob,login_facility_id,catalog_code,order_type_code,patient_id);
						
						if(OrderFormat!=null && OrderFormat.size()==0 && !amend_order_id.equals("") && !amend_order_line_num.equals(""))
            			{ // In Amend Mode, check for the order_id whether records are there, otherwise make the order_id null and check for the format_id
	            			amend_order_id      = ""; amend_order_line_num="";// Commented for IN043099
							OrderFormat			= bean.getOrderFormat(format_id,order_category,amend_order_id,called_from,amend_order_line_num,priority,sex,dob,login_facility_id,catalog_code,order_type_code,patient_id);
            			}
						
                  		for(int k=0; k<OrderFormat.size(); k++)
						{
					 		records = (String[])OrderFormat.get(k);
							seq_num 		 =   (Integer.parseInt(bean.checkForNull(records[1],"0")));
							
							// seq_num will start with 0
							if(old_seq_num!=0 && seq_num==old_seq_num ) {	//used for Amend Orders
   								new_seq_num--;		// reduce the new_seq_num
								arrSeqNo.remove( String.valueOf(new_seq_num));		//remove the arraylist
								//field_mnemonic	 = old_field_mnemonic;//Commented for IN043099
							}
							else 
								field_mnemonic	 = bean.checkForNull(records[0],"0");
							
					
 							template			 = beanQueryObj.buildHashTable(properties, new_seq_num, patient_id, amend_order_id, format_id, order_type_code, order_type_short_desc ,field_mnemonic,  records);
							//IN050610 - Start			
 							if(old_seq_num!=0 && seq_num==old_seq_num ) 
 							{
 								template.put("oth_dependency_yn", bean.checkForNull(records[11],"N"));
 								template.put("dependency_yn","N");
 							}
 							//IN050610 - End
	 					if(!amend_order_id.equals("") && !amend_order_line_num.equals("") && bean.checkForNull((String)template.get("single_or_multi"),"").equals("M") &&  bean.checkForNull((String)template.get("field_type"),"").equals("C")) { // From Amend Order, call a method which will set and return if any
							 checkReplaceAmend(bean, orderEntryRecordBean, ind_catalog_code ,ind_row_value,  field_mnemonic, template);

						} else {    // For Orders and even for Amend without multi values
								orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
 								arrSeqNo.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
								new_seq_num++; //increment the seq_num
 								exists = true;
								mode   = "INSERT";
								specimen_def_yn = "Y" ; // To default the specimen if the Lab is installed and first time...
 							}
   							// If it is an MultiSelect, then the system internally will take the list item values and paint it as an checkbox instead of list item
   							//IN045798 - start included if else condition to handle amend order screen for multi select comp
							//IN047739 - modified - Start
							 ArrayList seq_data					= new ArrayList();
							 String flgg = "Y";
							 if(new_seq_num > (Integer.parseInt(bean.checkForNull(max_seq,"0")))){
									seq_data = beanQueryObj.getMaxlistseq(amend_order_id,field_mnemonic);
									max_list_seq = (String[])seq_data.get(0);
									if(max_list_seq[0].equals("1")){ 
										max_seq = max_list_seq[1];
										flgg = "N";}}
							//null handled when called from OP	IN048553	
   							if(called_from_fn== null || !called_from_fn.equals("AMEND_ORDER") || flgg.equals("Y")){
  							if(bean.checkForNull(records[12],"S").equals("M") && bean.checkForNull(records[5],"").equals("L")) {
							// Query population used in the list item.
							    OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,bean.checkForNull((String)template.get("discr_msr_id"),""),performing_facility_id,login_facility_id,sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);
   								//for(int l=0;l<OrderFormatList.size();l++){
   								for(int l=0;l<OrderFormatList.size();l++){
									records			= (String[])OrderFormatList.get(l);
 									if(l==OrderFormatList.size()-1) // that means it is a last record
									{
										multi_last_record = "Y";
										// Last record (for grouping multi select)
									}
									else
									{ 
										multi_last_record = "N";
										// Not a last record (for grouping multi select)
									}
										new_template    = beanQueryObj.buildMultiHashTable( new_seq_num,records[0], records[1], multi_last_record, template);
										orderEntryRecordBean.setOrderFormats(ind_catalog_code, 	(ind_catalog_code+new_seq_num),new_template);
	 									arrSeqNo.add( String.valueOf(new_seq_num));// new Integer(new_seq_num));
										new_seq_num++;  
								}
							
 							} // End of Multi Select
  						}else{
							if(bean.checkForNull(records[12],"S").equals("M") && (bean.checkForNull(records[5],"").equals("L")||bean.checkForNull(records[5],"").equals("C")) && flgg.equals("N")) 
							{	
								/*if(new_seq_num > (Integer.parseInt(bean.checkForNull(max_list_seq,"0")))){
									max_list_seq = beanQueryObj.getMaxlistseq(field_mnemonic);}*/
								if(String.valueOf(new_seq_num).equals(max_seq))
								{
									multi_last_record = "Y";
									template.put("dflt_value"	, bean.checkForNull(multi_last_record+"@@"+records[5],"")+"@@"+records[0]);
								}
								
							}
						}
					//IN047739 - modified - end	
  					//IN045798 - end	
 							// TO PAINT THE ROWS, depending upon the Dependency 
							if(bean.checkForNull((String)template.get("dependency_yn"),"N").equals("Y")) {
 								//max_dependency_row = beanQueryObj.getSeqNo(properties, format_id ,seq_num, bean.checkForNull(records[0],"N")); //format_id ,seq_num,field_mnemonic
								if(template!=null){
 									max_dependency_row = Integer.parseInt(bean.checkForNull((String) template.get("max_dependency_row"),"0"));
									field_mnemonic = bean.checkForNull((String) template.get("field_mnemonic"),"");
 								}
 							} // End of records[11] //dependency_yn
							else 
								max_dependency_row	= 0;
 							for(int t=0;t<max_dependency_row;t++){
								template		 = beanQueryObj.buildDummyHashTable(seq_num,order_type_code, order_type_short_desc, field_mnemonic );

								orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+new_seq_num),template);
 								arrSeqNo.add(String.valueOf(new_seq_num));//new Integer(new_seq_num));
								
								 old_seq_num = seq_num;//IN043099
 								 new_seq_num++;
								
							} // End of for seq_num
 							/*if(bean.checkForNull(records[11],"N").equals("Y")){ 
								OrderDependencyFormat = beanQueryObj.getDependencyValues(properties, format_id, seq_num, records[0], "");
								dependencyMainTemplate= new java.util.Hashtable();	
								for(int l=0; l<OrderDependencyFormat.size(); l++)
								{
									dependencyRecords	  = (String[])OrderDependencyFormat.get(l);
 									dependency_seq_num 	  = (Integer.parseInt(bean.checkForNull(dependencyRecords[1],"0")));
									dependencyTemplate	  = new java.util.Hashtable();	
									dependencyTemplate.put("field_mnemonic_value", dependencyRecords[0]);
									dependencyTemplate.put("value_seq_num", new Integer(dependency_seq_num));
									dependencyTemplate.put("field_mnemonic_value1", dependencyRecords[2]);
									dependencyTemplate.put("field_value_type", dependencyRecords[3]);
									dependencyTemplate.put("field_mnemonic_action", dependencyRecords[4]);
									dependencyTemplate.put("field_action_msg", dependencyRecords[5]);
									dependencyTemplate.put("oth_mnemonic_yn", dependencyRecords[6]);
									dependencyMainTemplate.put("dependency"+l,dependencyTemplate);
 								} // End of for OrderDependencyFormat	
								template.put("dependency", dependencyMainTemplate);
   							 } // End of dependency_yn
							*/
  							if(exists) {

		    					orderEntryRecordBean.setOrderFormats(ind_catalog_code, ind_row_value, arrSeqNo);
 							} // End of if exists
					    }    // End of k
				
		      		}  // End of if arrSeqNo
		      	} //End of  for
     		//}
     		//if(exists)
		    //{
 			//	orderEntryRecordBean.setOrderFormats("LINE_LEVEL", "0",arrSeqNo);
		    //}
			//else
	    	//{
			//	exists		= true;
			//	close_yn 	= "Y";
	    	//	mode		= "EXISTS";
	    	//}
	    	//if(exists)
	    	//{
	    	   try
				{
					//sbTemplate	=	buildTemplate(bean, orderEntryRecordBean, beanQueryObj, out, request, session, specimen_def_yn,pageContext,localeName,beanFormatObj); //Implict object session is passed to get the properties in the method -- commented for //ML-MOH-CRF-0508.1 [IN062319] 
					sbTemplate	=	buildTemplate(bean, orderEntryRecordBean, beanQueryObj, out, request, session, specimen_def_yn,pageContext,localeName,beanFormatObj, bean_id, bean_name); // modified for ML-MOH-CRF-0508.1 [IN062319]
					//Call the Bean Method passing the Necessary parametes to build the template
					//sbTemplate  =  buildTemplate(format_id,catalog_code,row_value,order_category);
					
					if(sbTemplate!=null)
					{
						out.println(sbTemplate.toString());
												
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	    //	}
 	  %>
  	    </td></tr></table>
  	    <input type="hidden" name="format_id" id="format_id" value="<%=format_id%>">
		<input type="hidden" name="chk_mand" id="chk_mand" value="<%=chk_mand%>">
  	    <input type="hidden" name="patient_id" id="patient_id" value="<%=bean.getPatientId()%>">
  	    <input type="hidden" name="mode" id="mode" value="<%=mode%>">
  	    <input type="hidden" name="mandatory_check" id="mandatory_check" value="N">
  	    <input type="hidden" name="close_yn" id="close_yn" value="<%=close_yn%>">
  	    <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
  	    <input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>"><!-- IN034813-->
		<input type="hidden" name="frm_unld_multichk_yn" id="frm_unld_multichk_yn" value="Y"> <!-- ML-MMOH-CRF-0208.1 -->
		<!--<input type="hidden" name="order_format_line_onload" id="order_format_line_onload" value=""> IN045512 -->
		<!-- <input type="hidden" name="ord_formt_multi_chk_nonmandate_yn" id="ord_formt_multi_chk_nonmandate_yn" value="N">-->
		<%
		if(sbTemplate!=null)
		{
			out.println("<script>");
			out.println(sbTemplateDummy.toString());
			out.println("</script>");									
		}	
		%>
  	</form>
    </body>
</html>
		<!-- IN045352 Starts
					<script>
						var count = document.OrderFormatForm.count.value;//IN045522		
						var formObj= document.OrderFormatForm;//IN045522
						if(document.OrderFormatForm.order_format_line_onload.value=="Y")
						{//IN045512
							for(var n =0;n<count;n++)//IN045522
							{//IN045522
								if(null!=eval("formObj.validationClause_new"+n))
								{
									//IN045522 Starts
									var validationClause_new =  eval("formObj.validationClause_new"+n+".value");
									var name_key_new =  eval("formObj.name_key_new"+n+".value");	
									eval("checkDependency(document.OrderFormatForm."+name_key_new+","+validationClause_new+")");
									//IN045522 Ends
								}
								
								
							}//IN045522
							document.OrderFormatForm.order_format_line_onload.value="N";
						}
					</script>
					<!-- IN045352 Ends  -->
<%
     } catch(Exception e){
			e.printStackTrace();
     }
%>
 <%!
	//private java.lang.StringBuffer buildTemplate(eOR.OrderEntryBean bean,eOR.Common.OrderEntryRecordBean orderEntryRecordBean, eOR.OrderEntryQueryBean beanQueryObj, javax.servlet.jsp.JspWriter out, HttpServletRequest request,  HttpSession session, String specimen_def_yn ,PageContext pageContext,String localeName,eOR.OrderEntryFormatBean beanFormatObj) throws Exception -- commented for //ML-MOH-CRF-0508.1 [IN062319]
	private java.lang.StringBuffer buildTemplate(eOR.OrderEntryBean bean,eOR.Common.OrderEntryRecordBean orderEntryRecordBean, eOR.OrderEntryQueryBean beanQueryObj, javax.servlet.jsp.JspWriter out, HttpServletRequest request,  HttpSession session, String specimen_def_yn ,PageContext pageContext,String localeName,eOR.OrderEntryFormatBean beanFormatObj, String bean_id, String bean_name) throws Exception // modified for //ML-MOH-CRF-0508.1 [IN062319]
	{
 		int tr=0;
		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		StringBuffer	sbTemplate		= new StringBuffer();
		Hashtable		template		= new Hashtable();
 		ArrayList		arrSeqNo		= new ArrayList();
		//String 		ph_list_vals		= bean.checkForNull(request.getParameter("ph_list_vals"),"");
		String 		called_from			= "LINE_LEVEL";//bean.checkForNull(request.getParameter("called_from"),"");
		String 	function_name			= bean.checkForNull(request.getParameter("function_name"),"");
		String p_catalog_code			= bean.checkForNull(request.getParameter("p_catalog_code"),"");
		String p_form_code				= bean.checkForNull(request.getParameter("p_form_code"),"");
		String p_route_code				= bean.checkForNull(request.getParameter("p_route_code"),"");
 		String 			format_id 		= "";//bean.checkForNull(request.getParameter("format_id"),"");
		String 			catalog_code 	= "";//bean.checkForNull(request.getParameter("catalog_code"),"");
	//	String 			row_value		= "";//bean.checkForNull(request.getParameter("row_value"),"");
		String		order_category		= "";//bean.checkForNull(request.getParameter("order_category"),"");
		String 		contr_msr_panel_id	= "";//bean.checkForNull(request.getParameter("contr_msr_panel_id"),"");
		String      contr_msr_mod_id	= "";//String 		priority			= ""; 
		String	   name_key				= "";
		String 		format_id_yn		= bean.checkForNull(request.getParameter("format_id_yn"),"N");
		String		sys_date			= bean.checkForNull(request.getParameter("sys_date"),"");
		String	sys_date_time			= sys_date; //DATE WITH TIME
		String 	p_function_from			= bean.checkForNull(request.getParameter("function_from"),""); // ML-MMOH-CRF-0508.1
		String amd_ord_dflt_value 		= ""; // ML-MMOH-CRF-0508.1
	
		//String validationClause_new="";//IN045352
		if(!sys_date.equals("")) // remove the time
					sys_date			= sys_date.substring(0,10);

					sys_date=com.ehis.util.DateUtils.convertDate(sys_date,"DMY","en",localeName);

		int 		total_rows          = Integer.parseInt(bean.checkForNull(request.getParameter("total_rows"),"0"));
		String login_facility_id		= bean.getLoginFacilityId();
		String sex						= bean.getSex();
		String dob						= bean.getDob();

		int 		seq_num				= 0 , new_seq_num	    = 0;
		int			max_dependency_row	= 0;
		String 		field_mnemonic		= "",  label_text 		= "";
		String 		accept_option		= "",  dflt_value 		= "";
//		String		dflt_value_display	= "";
		String 		field_type			= "",  min_num_value 	= "";
		String 		max_num_value		= "";
		String      help_text           = "", discr_msr_id		= "",dependency_yn = "";
		String      check_box_multi_val = "", multi_last_record = "N";
		String      checked				= "";
		int			max_allowed_length	= 0, row_count			= 0;
		int 		display_length		= 0;
		String 		display_only_prop	= "";
		String 		disabled_prop		= "";
		String 		readOnlyClause		= "";
		String 		mandatory_gif		= "", display_dependency		= ""; 
		String 		mandatory_fields	= "";
		String 		transplant_fields	= "";
		//StringBuffer mandatory_fields	= new StringBuffer();
		String 		mandatory_names 	= "";
		//StringBuffer mandatory_names	= new StringBuffer();
		//String 		list_item_fields	= "";
		StringBuffer list_item_fields=new StringBuffer();
		String 		validationClause	= "";
		String  parent_field_mnemonic	= "", group_field_mnemonic		= "";
		//int 		num_digit_dec		= 2;
		String 		field_validation	= "";	//checked				= "";
		//String		field_mnemonic_fields= "", 
		StringBuffer	field_mnemonic_fields=new StringBuffer();
		StringBuffer	lb_install_fields=new StringBuffer();
		//String      label_text_value		= "";
		StringBuffer label_text_value=new StringBuffer();
		String 		field_values		= "", 	ind_catalog_code		= "";
		String		order_type_code		= "";	// 	old_order_type_code		= "";
		String      field_mnemonic_action= "",   field_action_msg		= "" , field_value_type="";
		String	    single_or_multi		 = "";
 
		String		catalog_desc		= "",   performing_facility_id 	= "";
		//String 		order_type_short_desc = ""; 
		String		ind_row_value		= "";
		String 		lab_install_yn		= "N", bt_install_yn			= "N";
		String		ot_install_yn		= "N", rd_install_yn			= "N"; 
		String order_category_desc  	= "";
		int 		age_in_days			= 0;
		String		sex_yn				= "", 	preps_instrn			= "";
		String 		preps_dept_instrn 	= "",   pat_preps_instrn		= "";
		String 		comment				= "",   old_order_category		= "";
		String 		amend_order_id		= "",   amend_order_line_num	= "";
		String		appt_time			= "";   //old_field_mnemonic		= "";//commented for checkstyle
		String      start_date_time="";
 		String		dateText			= "";
		String		oper_side_appl_yn	= "N",  class_value				= "LABEL";
		String      applicability="";
		String		mother_patient_id	= "",	mother_patient_name		= "";
		String      dynamic_pat_button	= "",   dynamic_diag_button     = "";
		String 		default_value 		= ""; //IN045798
		// For Pharmacy Related
		//StringTokenizer stPhListVals	= null;
		//String 		ph_list_val			= "";
		//String 		ph_list_desc 		= "";  
		// Till Here
		String l_instrn_content_type = "";//IN64543
		String l_showHidInstrn = "";//IN64543
		String records[]				= null;
		String patient_id				= bean.getPatientId();
		String labmodule="";
		String discr_msr_uom="";
		String display_transplant = "";
		String sql_or_order_entry_nm_mother_pat_details_select = eOR.Common.OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_NM_MOTHER_PAT_DETAILS_SELECT");
		
		String mother_patient_records[] = null;
		ArrayList	motherPatientDetails= new ArrayList();
		int group_field_mnemonic_count	= 0;
		int transplant_pat_yn_exists =0;
		String transplant_checked = "";
		HashMap instructionsMap = new HashMap();
		int anatomyCount = 0;
		int tissueCount = 0;
		int fixativeCount = 0;
		int old_seq_num_paint=0;
		String appendCodeDesc = "";//IN043095
		String temp_field_mnemonic = ""; //IN034497
		String oth_dependency_yn = "N";//IN049133
		String ord_formt_multi_chk_nonmandate_yn = bean.getMultiSelectListItemMandatYN(); // ML-MMOH-CRF-0508.1 [IN062319] 
		ArrayList multiListCompList = null; // ML-MMOH-CRF-0508.1 [IN062319] 
		ArrayList completeMultiCheckCompList = null; // ML-MMOH-CRF-0508.1 [IN062319] 
		Map multiListCompMap = null; // ML-MMOH-CRF-0508.1 [IN062319] 
		//String prev_field_mnemonic = ""; // ML-MMOH-CRF-0508.1 [IN062319]		
		Map selMultiSelectedMap = new HashMap(); // ML-MMOH-CRF-0508.1 [IN062319] 
		List selecteCompList = new ArrayList();	// ML-MMOH-CRF-0508.1 [IN062319] 
		sbTemplateDummy = new StringBuilder();
		//String dummy = "";//IN64543	//checkstyle	
		StringBuilder waitForCompleteLoadIndivi = new StringBuilder();//IN64543
 		try
		{
		//	int count = 0;
			ind_catalog_code			= "";
			//lab_install_yn				=""; //bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N");

			sbTemplate.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"CENTER\">");
		//	try
		//	{
				//ind_row_value			=	(ind_catalog_code+"_"+row_value);
		//		arrSeqNo				=	(java.util.ArrayList) orderEntryRecordBean.getOrderFormats("LINE_LEVEL", "0");
		//	}
		//	catch(Exception e)
		//	{
		//		out.println("Exception Prop : "+e);
		//	}
		//	if(arrSeqNo!=null && arrSeqNo.size() > 0)
		//	{
				if("Y".equals(ord_formt_multi_chk_nonmandate_yn)){ // ML-MMOH-CRF-0508.1 [IN062319]  - Start
					multiListCompMap = new HashMap(); 
					completeMultiCheckCompList = new ArrayList(); 
				}	// ML-MMOH-CRF-0508.1 [IN062319]  End
				for(int i=0;i< total_rows;i++)
				{
					tr = 0;
                   	catalog_code			= order_catalog_code_arr[i];
					order_type_code			= order_type_arr[i];
					//priority				= priority_arr[i];
					contr_msr_panel_id		= bean.checkForNull(contr_msr_panel_id_arr[i],"");
					contr_msr_mod_id		= bean.checkForNull(contr_msr_mod_id_arr[i],"");
					order_category			= bean.checkForNull(order_category_arr[i],"");
					format_id				= bean.checkForNull(format_id_arr[i],"");
					catalog_desc			= bean.checkForNull(catalog_desc_arr[i],"");
					performing_facility_id  = bean.checkForNull(performing_facility_id_arr[i],"");
					amend_order_id			= bean.checkForNull(order_id[i],"");
					amend_order_line_num    = bean.checkForNull(order_line_num[i],"");
					appt_time				= bean.checkForNull(appt_time_arr[i],"");
					start_date_time				=bean.checkForNull((String)start_date_time_arr[i],"");
					l_instrn_content_type =bean.checkForNull((String)instrn_content_type[i],"T");//IN64543
					if(order_category.equalsIgnoreCase("LB"))
					{
						bt_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("BT"),"N");
					}
					else if(order_category.equalsIgnoreCase("OT"))
					{
						ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N");
					}else if(order_category.equalsIgnoreCase("RD"))
					{
						rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
					}
				//labmodule=(String)bean.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id);
					//if(order_category.equalsIgnoreCase("LB"))
					//{
						labmodule=bean.checkForNull((String)bean.getmoduleRL(catalog_code,order_category,order_type_code,login_facility_id),"");
						if(labmodule.equalsIgnoreCase("IBARL"))
						{
							lab_install_yn="Y";
						}
						else
						{
							lab_install_yn="N";
						}
					//}
					if(!format_id_yn.equals("Y"))
					{
						//IN64543, starts
						/*comment		        = bean.checkForNull(amend_line_comments[i],"");
						preps_instrn		= bean.checkForNull(amend_line_preps[i],"");
						preps_dept_instrn 	= bean.checkForNull(amend_line_dept_instrn[i],"");
						pat_preps_instrn	= bean.checkForNull(amend_line_pat_instrn[i],"");*/
						comment = bean.getAmendComments(order_id[i],order_line_num[i]);
						preps_instrn			= bean.getAmendPreps(order_id[i],order_line_num[i]);
						preps_dept_instrn		= bean.getAmendDepts(order_id[i],order_line_num[i]);
						pat_preps_instrn 		= bean.checkForNull(bean.getAmendPatientInstrn(order_id[i],order_line_num[i]),"");						
						//IN64543, ends
					}
					
		 	      	ind_catalog_code		= catalog_code;
     	 	      	ind_row_value			= (ind_catalog_code+"_0");
					//ind_row_value			= (ind_catalog_code+"_"+row_value);
					if(!order_category.equals(old_order_category) && function_name.equals("ORDER_SET") )
					{
						order_category_desc = bean.checkForNull(beanQueryObj.getOrderCategoryDesc(properties, order_category), "");
             			sbTemplate.append("<tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\">"+order_category_desc+"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");
					}
					sbTemplate.append("<tr><td class=\"PATIENTLINECOLOROTHLANG\"   width=\"15%\" colspan=\"6\">"+catalog_desc+"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");
					arrSeqNo				= (ArrayList) orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value);
					
					group_field_mnemonic_count = 0;
					group_field_mnemonic	   = "";
					boolean anatomy_val = false;
					if(arrSeqNo!=null && arrSeqNo.size() > 0)
					{
						int format_size = 0;
						if("Y".equals(ord_formt_multi_chk_nonmandate_yn)){ // ML-MMOH-CRF-0508.1 [IN062319]  - Start
							multiListCompList = new ArrayList(); 
						} // ML-MOH-CRF-0508.1 [IN062319] - End		
						for(int k=0;k<arrSeqNo.size();k++)	// Main Loop
				 		{
 				    		new_seq_num			=  Integer.parseInt((String)arrSeqNo.get(k)); // ((Integer)arrSeqNo.get(k)).intValue();
							if(k==0 || old_seq_num_paint!=new_seq_num)//IN043099
							{//IN043099
  							try
				    		{
								old_seq_num_paint = new_seq_num;
				 				template	=	(Hashtable) orderEntryRecordBean.getOrderFormats ( ind_catalog_code, (ind_catalog_code+new_seq_num) );
								
  				    		}
				    		catch(Exception e)
				    		{
								e.printStackTrace();
				    		}
				    		try
				    		{
 								field_mnemonic		= bean.checkForNull((String) template.get("field_mnemonic"),"");
 								discr_msr_uom		= bean.checkForNull((String)template.get("discr_msr_uom"),"");
  								seq_num				= Integer.parseInt(bean.checkForNull((String) template.get("seq_num"),"0"));
								
  								accept_option		= bean.checkForNull((String) template.get("accept_option"),"");//IN069657
  								if (order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD")){
									applicability            = bean.checkForNull(bean.getapplicability(catalog_code),"");
								
									if(applicability.equals("N"))
									{
										label_text="";
										accept_option = "O";//IN069657
									}
									else
									{
										label_text			= bean.checkForNull((String) template.get("label_text"),"");
									}
								}
								else
								{
 									label_text			= bean.checkForNull((String) template.get("label_text"),"");
								}
 							
								//accept_option		= bean.checkForNull((String) template.get("accept_option"),"");//IN069657, moved to top of this try
								dflt_value			= bean.checkForNull((String) template.get("dflt_value"),"");
								field_type			= bean.checkForNull((String) template.get("field_type"),"");
								min_num_value		= bean.checkForNull((String) template.get("min_num_value"),"");
								max_num_value		= bean.checkForNull((String) template.get("max_num_value"),"");
								order_type_code		= bean.checkForNull((String) template.get("order_type_code")); // Header_level
								//order_type_short_desc= bean.checkForNull((String) template.get("order_type_short_desc")); // Header_level
								help_text           = bean.checkForNull((String) template.get("help_text"));
								discr_msr_id        = bean.checkForNull((String) template.get("discr_msr_id"));
								dependency_yn       = bean.checkForNull((String) template.get("dependency_yn"));
 								max_dependency_row	= Integer.parseInt(bean.checkForNull((String) template.get("max_dependency_row"),"0"));
								
								parent_field_mnemonic=bean.checkForNull((String) template.get("parent_field_mnemonic"));
								field_action_msg	 = bean.checkForNull((String) template.get("field_action_msg"));
								field_mnemonic_action	 = bean.checkForNull((String) template.get("field_mnemonic_action"));
 								single_or_multi			 = bean.checkForNull((String) template.get("single_or_multi"));
 								field_value_type			 = bean.checkForNull((String) template.get("field_value_type"));
 								default_value 		= bean.checkForNull((String) template.get("default_value"));//IN045798
 								oth_dependency_yn = bean.checkForNull((String) template.get("oth_dependency_yn"),"N");//IN049133
  					
								if(field_mnemonic.equals("")) {
									display_dependency = "display:none";
 								} else
									display_dependency = "display:";
 
								dateText				= "";
								//old_field_mnemonic		= bean.checkForNull(field_mnemonic);//IN043099								//IN043099  Ends

								// Check If Lab is installed or not.
								// To make mandatory or not if lab is installed and for specimen type
  								//if(order_category.equals("LB") && field_mnemonic.equals("SPECIMEN_TYPE") && //lab_install_yn.equalsIgnoreCase("Y") && amend_order_id.equals("") && //amend_order_line_num.equals("") )
								//{
									//accept_option   = bean.getSpecimenMandYn(catalog_code);
								//}
								if(order_category.equals("RD") && field_mnemonic.equals("EXAM_SIDE_APPL") && rd_install_yn.equalsIgnoreCase("Y"))
								{
								 	accept_option   = beanQueryObj.getExamSideApplMandYn(properties, catalog_code);
   								}
								if(order_category.equals("LB") && field_mnemonic.equals("BLOOD_PRODUCT_PROCESS") && lab_install_yn.equalsIgnoreCase("Y"))
								{
								 	String BloodProductProcessYn = (String)beanQueryObj.getBloodProductProcessYn(properties, catalog_code);
									if(BloodProductProcessYn.equalsIgnoreCase("N"))
									{
										accept_option   =  "D";	
									} 
									
   								}
								dynamic_pat_button	= "";
								dynamic_diag_button	= "";
					   		}
					 		catch(Exception e)
					   		{
								e.printStackTrace();

					   		}
   							if(group_field_mnemonic_count==0 && single_or_multi.equals("M") && field_type.equals("L")){  // Presentation Multi and CheckBox
								//group_field_mnemonic_count++;//Commentted IN034497
								//More than 1, then paint heading //IN034497
// 								if("Y".equals(isNonMadateMultSelect) && "R".equals(accept_option)){
// 									mandatory_gif		=  "<img src='../../eCommon/images/mandatory.gif'></img>"; // added by LK
// 								} else {
// 									mandatory_gif		=  "";
// 								}
								if(!(temp_field_mnemonic).equals(field_mnemonic)) {
									 
									if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option)){  // ML-MMOH-CRF-0508.1 [IN062319] - Start
										multiListCompList = new ArrayList();
									}	
									if("N".equals(ord_formt_multi_chk_nonmandate_yn)){
										sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\" >"+label_text+"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>"); // commented for ML-MMOH-CRF-0508.1 [IN062319]
 									} //else {
// 										if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option)){  // ML-MMOH-CRF-0508.1 [IN062319] - Start
// 											multiListCompList = new ArrayList();
// 											mandatory_gif		=  "<img src='../../eCommon/images/mandatory.gif'></img>"; 	
// 										sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\" >"+label_text+" &nbsp;"+ mandatory_gif +"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");	
// 										} else {
// 											mandatory_gif		=  "";
// 											sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\" >"+label_text+"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");
// 										}  // ML-MMOH-CRF-0508.1 [IN062319]  - End
// 									}
								}

								if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option)){  // ML-MMOH-CRF-0508.1 [IN062319] - Start
									//multiListCompList = new ArrayList();
									mandatory_gif		=  "<img src='../../eCommon/images/mandatory.gif'></img>"; 	
									sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\" >"+label_text+" &nbsp;"+ mandatory_gif +"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");	
 								} else if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "O".equals(accept_option)){
									mandatory_gif		=  "";
  									sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"EMERGENT\"   width=\"15%\" colspan=\"6\" >"+label_text+"</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>"); 
  								}
								temp_field_mnemonic = field_mnemonic;//IN034497
									tr=1;
																		
									//label_text="";
  							}  
							// If it is already there put the respective values
							field_values			= bean.checkForNull((String) template.get("field_values"	));
							if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option) && single_or_multi.equals("M") && !"".equals(field_values) && ("AMEND_ORDER".equalsIgnoreCase(p_function_from) || "COPY_ORDER".equalsIgnoreCase(p_function_from))){  // ML-MMOH-CRF-0508.1 [IN062319] - Start
								amd_ord_dflt_value = field_values;
							}  // ML-MMOH-CRF-0508.1 [IN062319] - End
							//IN045798 included default_value condition
   							if(single_or_multi.equals("M") && ((dflt_value.indexOf("@@")!=-1) || (!default_value.equals("")))) 
   							{  // When nothing is there in the bean
   							//IN045798 - Start
   								if((default_value.indexOf("@@")!=-1))
									dflt_value 			= default_value; 
								else if ((dflt_value.indexOf("@@")!=-1))
									default_value = dflt_value;
   							//IN045798 - End	
								multi_last_record		= bean.checkForNull(dflt_value.substring(0, 	dflt_value.indexOf("@@")),"");
 								check_box_multi_val		= bean.checkForNull(dflt_value.substring(dflt_value.lastIndexOf("@@")+2, dflt_value.length()),""); //remove the @@ and take the value 
 								dflt_value				= bean.checkForNull(dflt_value.substring(dflt_value.indexOf("@@")+2, dflt_value.lastIndexOf("@@")),"");   
 							} else {
								check_box_multi_val		= "";
								multi_last_record		= "N";
							}

   							if(field_values==null || field_values.equals("")) {
				   				field_values		= "";
							} else {
  						   			dflt_value 			= field_values;
							}		
								

       						//if(!appt_time.equals("") && ot_install_yn.equals("Y") && old_field_mnemonic.equals("OPER_DURN")) // For Oper_durn field mnemonic 
       						if(!appt_time.equals("") && ot_install_yn.equals("Y") && field_mnemonic.equals("OPER_DURN")) //IN044959
								dflt_value			= appt_time;
  							name_key				= (parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num);
  							// If the Field Mnemonic is "OPER_SIDE_APPL" , Query from the table
							//if(order_category.equals("OT") && ot_install_yn.equals("Y") && old_field_mnemonic.equals("OPER_SIDE_APPL")) // For OPER_SIDE_APPL field mnemonic
							if(order_category.equals("OT") && ot_install_yn.equals("Y") && field_mnemonic.equals("OPER_SIDE_APPL")) //IN044959
								oper_side_appl_yn = bean.getOTApplRightLeft(catalog_code);
											
 //sbTemplate.append("field_values"+field_values+"dflt_value"+dflt_value);
							
							// Paint the Page here
 							if(accept_option.equals("D"))
							{
								display_only_prop	= "readOnly";
								disabled_prop		= "disabled";
								readOnlyClause		= "class=\"READONLY\" ";
								readOnlyClause		= "";
								class_value			= "ORDISABLED";  // Color for the disabled items
 							}
							else
							{
								display_only_prop	= "";
								disabled_prop		= "";
								readOnlyClause		= "";
								class_value			= "LABEL"; 
							}
							/*if(order_category.equals("LB"))
							{Commented by Uma on 9/24/2009 for MF-CRF-0115*/
								
								if(field_mnemonic.equals("PATIENT_DIAGNOSIS"))
								{
									dynamic_diag_button = "<input type=\"button\" class=\"button\" name =\"PATIENT_DIAG_BTN"+name_key+"\" "+disabled_prop+" value=\"?\" onClick=\"return showDiagnosis('"+(name_key)+"' ,this, 'PATIENT_DIAGNOSIS');\">";

								}
							/*}Commented by Uma on 9/24/2009 for MF-CRF-0115*/
							
							if(field_mnemonic.equals("NN_MOTHER_PAT_ID") || field_mnemonic.equals("NN_MOTHER_PAT_NAME") && field_values.equals("")) {   // For NN_MOTHER_PAT_ID  field mnemonic
								// do a query and get the patient_id and patient_name
 								motherPatientDetails=  beanQueryObj.getNMMotherPatientDetails(properties, patient_id);
 								for(int l=0; l<motherPatientDetails.size(); l++)
								{
										mother_patient_records = (String[])motherPatientDetails.get(l);
										mother_patient_id      = bean.checkForNull((String)mother_patient_records[0],"");
										mother_patient_name    = bean.checkForNull((String)mother_patient_records[1],"");
										mother_patient_records = null; //Nullifying the objects
 								} // End of for
								if(motherPatientDetails!=null) {
									motherPatientDetails.clear();
									motherPatientDetails = null;  //Nullifying the objects
								}
								if(field_mnemonic.equals("NN_MOTHER_PAT_ID") && !mother_patient_id.equals("")) {
									dflt_value			= mother_patient_id;
 								} else if(field_mnemonic.equals("NN_MOTHER_PAT_ID") && mother_patient_id.equals("")) {
										dynamic_pat_button = "<input type=\"button\" class=\"button\" name =\"PATIENT_NM_LOOKUP"+name_key+"\" "+disabled_prop+" value=\"?\" onClick=\"return showPatientLookUp('"+(name_key)+"' ,this, 'NN_MOTHER_PAT_ID');\">";
								}
						    }
							//String dflt_value_patient_id =""; //IN047938 Reopen//checkstyle
							//if(field_mnemonic.equals("NN_MOTHER_PAT_ID") || (field_mnemonic.equals("NN_MOTHER_PAT_NAME"))) //&& //!mother_patient_id.equals("")) 
							//if(field_mnemonic.equals("NN_MOTHER_PAT_ID") || (field_mnemonic.equals("NN_MOTHER_PAT_NAME")) && (!mother_patient_id.equals("")))//IN047938
							if(field_mnemonic.equals("NN_MOTHER_PAT_ID") || (field_mnemonic.equals("NN_MOTHER_PAT_NAME")) && (!mother_patient_id.equals("")|| !dflt_value.equals(" ") ))//IN047938 Reopen
							{
								display_only_prop	= "readOnly";
							}
							if(field_mnemonic.equals("NN_MOTHER_PAT_NAME") && !mother_patient_name.equals("")) {
									dflt_value			= mother_patient_name;
							}//IN047938 Reopen Start
							if(field_mnemonic.equals("NN_MOTHER_PAT_ID") && !dflt_value.equals(" ")){
								mother_patient_id = dflt_value;
							}
							if(field_mnemonic.equals("NN_MOTHER_PAT_NAME") && !dflt_value.equals(" ") && mother_patient_id.equals("")) {
								display_only_prop	= "";
								mother_patient_id="";
							}//IN047938 Reopen End
 							if(accept_option.equals("R"))
							{
								mandatory_fields=mandatory_fields+name_key+"#";
								//mandatory_fields.append(name_key+"#");
								mandatory_names=mandatory_names+label_text+"#";
								//mandatory_names.append(label_text+"#");
								if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "M".equals(single_or_multi)) {
									mandatory_gif		=  "";
								}else{
									mandatory_gif		=  "&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>";
								}	
							}
							else
							{
								mandatory_gif		= "";
							}
 							//sbTemplate.append("Type"+field_type);
							// This variable is used to keep tab of the field_mnemonic and to copy the same value..

							
							

							field_mnemonic		= field_mnemonic.replace('\'',  '|'); //Replace '' with |
 							if( field_type.equalsIgnoreCase("D") )
							{  
								
								max_allowed_length	= 10;
								display_length		= 10;						//if((order_category.equals("LB"))&&(field_mnemonic.equals("BLOOD_TRANS_EXP_DATE"))&&(lab_install_yn.equalsIgnoreCase("Y")))
									//{
											//validationClause	= "onBlur = \"callCheckDate(this,'"+field_mnemonic+"','"+(field_mnemonic+order_type_code)+"',document.OrderFormatForm.sys_date); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); checkingbtspec(this,'"+field_mnemonic+"','"+start_date_time+"') \" ";
									//}
									//else
									//{
										validationClause	= "onBlur = \"callCheckDate(this,'"+field_mnemonic+"','"+(field_mnemonic+order_type_code)+"',document.OrderFormatForm.sys_date); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \" "; //included oth_dependency_yn IN049133

								//	}
								//dateText			= "<input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(name_key)+"');\">";
								dateText			= "<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(name_key)+"');\">";
								//validationClause	= "onBlur = \"return CheckDate(this)\" ";
							}
							else if( field_type.equalsIgnoreCase("T") )
							{
								max_allowed_length	= 5;
								display_length		= 5;
								validationClause	= "onBlur = \"callCheckTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \" ";//included oth_dependency_yn IN049133
								//validationClause	= "onBlur = \"return callCheckTime(this)\" ";
							}
							else if( field_type.equalsIgnoreCase("E") )
							{
								max_allowed_length	= 16;
								display_length		= 16;
								if((order_category.equals("LB"))&&(field_mnemonic.equals("BLOOD_TRANS_EXP_DATE"))&&(labmodule.equalsIgnoreCase("IBARL")))
								{
									validationClause	= "onBlur = \"callCheckDateTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');checkingbtspec(this,'"+field_mnemonic+"','"+start_date_time+"','"+localeName+"') \" ";//included oth_dependency_yn IN049133
								}
								else
								{
										validationClause	= "onBlur = \"callCheckDateTime(this); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \" ";//included oth_dependency_yn IN049133
								}
								dateText			= " <img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(name_key)+"',null,'hh:mm');\">"; 
								//dateText			= " <img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar('"+(field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num)+"',null,'hh:mm');\">"; //modified --[IN026010]--
								//validationClause	= "onBlur = \"return callCheckDateTime(this)\" ";
							}
							else if( field_type.equalsIgnoreCase("I") )
							{
								int maxDigit = 20;
								int  minDigit = -1;
								int noDec = -1;
								String minVal = "";
								String maxVal = "";
								

								Map<String, String>  discreetMesaure = bean.getDiscreetMeasure(field_mnemonic, patient_id,sex,dob);		
								
															
								if(discreetMesaure != null)
								{
									maxDigit = discreetMesaure.get("NUM_DIGITS_MAX")==null?20:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MAX"));
									minDigit = discreetMesaure.get("NUM_DIGITS_MIN")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MIN"));
									noDec = discreetMesaure.get("NUM_DIGITS_DEC")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_DEC"));
									minVal = (discreetMesaure.get("MIN_VALUE")== null?"-1":discreetMesaure.get("MIN_VALUE")) ;
									maxVal = discreetMesaure.get("MAX_VALUE")==null?"-1":discreetMesaure.get("MAX_VALUE");
									//dflt_value = discreetMesaure.get("DLFT_VALUE")==null?"":discreetMesaure.get("DLFT_VALUE");
								}
								
								int dlftLen = dflt_value.length();
								if(dlftLen > maxDigit)
								{
									dflt_value = "";
								}
								
								max_allowed_length	= maxDigit;
								
								display_length		= 6;
								validationClause	= "onBlur =  \"validateDiscreetMeasure(this,'"+maxVal+"','"+minVal+"','"+noDec+"','"+max_allowed_length+"','"+minDigit+"','"+label_text+"'); checkNumberRange(this,'"+min_num_value+"','"+max_num_value+"');copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \" onKeyPress=\"return allowNumbers(this,event,'"+max_allowed_length+"','"+noDec+"')\"";
								//validationClause	= "onBlur = \"return checkValidRange(this)\" onKeyPress=\"return allowValidNumber(this,event,"+max_allowed_length+",0)\" ";
							}
							else if( field_type.equalsIgnoreCase("N") )
							{
								int maxDigit = 20;
								int  minDigit = -1;
								int noDec = -1;
								String minVal = "";
								String maxVal = "";
								

								Map<String, String>  discreetMesaure = bean.getDiscreetMeasure(field_mnemonic, patient_id,sex,dob);					
								if(discreetMesaure != null)
								{
									maxDigit = discreetMesaure.get("NUM_DIGITS_MAX")==null?20:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MAX"));
									minDigit = discreetMesaure.get("NUM_DIGITS_MIN")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_MIN"));
									noDec = discreetMesaure.get("NUM_DIGITS_DEC")==null?-1:Integer.parseInt(discreetMesaure.get("NUM_DIGITS_DEC"));
									minVal = (discreetMesaure.get("MIN_VALUE")== null?"-1":discreetMesaure.get("MIN_VALUE")) ;
									maxVal = discreetMesaure.get("MAX_VALUE")==null?"-1":discreetMesaure.get("MAX_VALUE");
									//dflt_value = discreetMesaure.get("DLFT_VALUE")==null?"":discreetMesaure.get("DLFT_VALUE");
								}
								max_allowed_length	= maxDigit;
								int dlftLen = dflt_value.length();
								if(dlftLen > maxDigit)
								{
									dflt_value = "";
								}
								
								max_allowed_length	= maxDigit;
								
								//max_allowed_length	= 10;
								//display_length		= 10;
								//validationClause	= "onBlur = \"checkNumberRange(this,'"+min_num_value+"','"+max_num_value+"');copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" onKeyPress=\"return allowValidNumber(this,event,"+(max_allowed_length - num_digit_dec)+","+num_digit_dec+")\"";


								validationClause	= "onBlur = \"validateDiscreetMeasure(this,'"+maxVal+"','"+minVal+"','"+noDec+"','"+max_allowed_length+"','"+minDigit+"','"+label_text+"'); checkNumberRange(this, '"+min_num_value+"','"+max_num_value+"');copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');  \" onKeyPress=\"return allowNumbers(this,event,'"+max_allowed_length+"','"+noDec+"')\"";//included oth_dependency_yn IN049133
								//validationClause	= " onBlur = \"return checkValidRange(this)\" onKeyPress=\"return allowValidNumber(this,event,"+(max_allowed_length - num_digit_dec)+","+num_digit_dec+")\" ";
								//max_allowed_length++;
							}
							else if(field_type.equalsIgnoreCase("R")){ // For Radio Button
  								validationClause	= "onClick = \"setRadioValue(this, '"+name_key+"'); checkDependency(document.OrderFormatForm."+name_key+",'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');\"";//included oth_dependency_yn IN049133


 							}
							else
							{
								validationClause	= " onBlur = \"makeValidString( this ); copySameMnemonic(this,'"+field_mnemonic+"',"+new_seq_num+"); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"  ";//included oth_dependency_yn IN049133
								display_length		= 30;
								max_allowed_length	= 100;
							}
							// Paint the Label_text and corresponding fields if it is radio group or any other element except list with multi (To avoid the field for the Group Heading in the List)
			/* this is done by jerome*/
							if( single_or_multi.equals("M") && group_field_mnemonic.equals("") )
								group_field_mnemonic = field_mnemonic;
			/*************/

   							/* commented by Shaiju for 20073 */
							//if(field_type.equals("R") || (!single_or_multi.equals("M")) ||(field_type.equals("A"))|| (single_or_multi.equals("M") && field_mnemonic.equals(group_field_mnemonic)))
							
							if(!field_type.equals("L") || (field_type.equals("L") && single_or_multi.equals("S")))
							{   
							
								if (!(order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD") && applicability.equals("N")))
								{
									if(transplant_pat_yn_exists>0&&transplant_checked.equalsIgnoreCase("")&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL"))
									{
										if(field_mnemonic.equals("DONOR_BLOOD_GROUP")||field_mnemonic.equals("DONOR_RHESUS")||field_mnemonic.equals("TRANSPLANT_DATE")&&order_category.equalsIgnoreCase("LB")&&labmodule.equalsIgnoreCase("IBARL"))
										{
											display_transplant="display:none";
									
											sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_transplant+"\" class=\""+class_value+"\" nowrap width=\"250px\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>");
											sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_transplant+"\" class=\"fields\"   width=\"15%\" title=\""+help_text+"\" nowrap valign=\"top\">"); //IN000000
										}
										else
										{
											display_transplant="display:";
											sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_dependency+"\" class=\""+class_value+"\" nowrap width=\"250px\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>");
											sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_dependency+"\" class=\"fields\"   width=\"15%\" title=\""+help_text+"\" nowrap valign=\"top\">"); //IN000000
										}
										
									}
									else
									{
										display_transplant="display:";
										sbTemplate.append("<td id=\"New_"+name_key+"_0\" style=\""+display_dependency+"\" class=\""+class_value+"\" nowrap width=\"250px\" title=\""+help_text+"\" valign='top'>&nbsp;"+label_text+"&nbsp;</td>");
										sbTemplate.append("<td id=\"New_"+name_key+"_1\" style=\""+display_dependency+"\" class=\"fields\"   width=\"15%\" title=\""+help_text+"\" nowrap valign=\"top\">"); //IN000000
									}
								}
								if(field_mnemonic.equals("TRANSPLANT_PAT_YN"))
								{
									transplant_pat_yn_exists++;
								}
								if(transplant_pat_yn_exists>0)
								{
									if(field_mnemonic.equals("DONOR_BLOOD_GROUP")||field_mnemonic.equals("DONOR_RHESUS")||field_mnemonic.equals("TRANSPLANT_DATE"))
									{
										transplant_fields=transplant_fields+name_key+"#";
									}
								}								
							}
							if( !field_type.equals("C") && !field_type.equals("L") && !field_type.equals("V") && !field_type.equals("R") )
							{
								if(" ".equals(dflt_value))//IN045005
									dflt_value = "";//IN045005
								//IN035189, starts
								if(field_type.equals("D") && !dflt_value.equals(""))
								{
									if(!localeName.equals("en"))
										dflt_value=com.ehis.util.DateUtils.convertDate(dflt_value,"DMY","en",localeName);
								}
								if(field_type.equals("E") && !dflt_value.equals(""))
								{
									if(!localeName.equals("en"))
										dflt_value=com.ehis.util.DateUtils.convertDate(dflt_value,"DMYHM","en",localeName);
								}
								//IN035189, ends
								 sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" >");
								 sbTemplate.append(discr_msr_uom);
								 sbTemplate.append(dynamic_pat_button);
								 sbTemplate.append(dynamic_diag_button);
								 sbTemplate.append(dateText+mandatory_gif); // Adding the calendar component if it is date / date and time filed otherwise will be null
							
								 // Dynamic patient details button should appear
								 
							} else if( field_type.equals("V"))
							{
								 sbTemplate.append("<input type=\"hidden\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" ><div style='border:1px;width:50px;height:50px;word-wrap:break-word;'><b>"+dflt_value+"</b></div>"); //IN000000 included div tag
								 sbTemplate.append(dateText+mandatory_gif); // Adding the calendar component if it is date / date and time filed otherwise will be null
							}
							else if(field_type.equals("C"))
							{ 
									if(single_or_multi.equals("") || single_or_multi.equals("S")) { // Normal checkbox, where the value Y or N have to be set
									if(dflt_value.equals("Y"))
									{
										dflt_value  = "Y";
										checked		= "CHECKED";
										transplant_checked ="CHECKED";										
								    }
									else 
									{
										//dflt_value  = "N"; -- commented for ML-MMOH-SCF-0412
										dflt_value  = ""; // modified for ML-MMOH-SCF-0412 - IN060565
										checked	    = "";	
										transplant_checked ="";
									}
									//IN060565 Start 
									/*
									sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" value=\""+dflt_value+"\"  "+checked+" onClick=\"setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+performing_facility_id+"','"+catalog_code+"','"+order_category+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"    "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
									*/
									sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value=\""+dflt_value+"\"  "+checked+" onClick=\"setCheckBoxValue(this,'"+field_mnemonic+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+performing_facility_id+"','"+catalog_code+"','"+order_category+"','"+mandatory_fields+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"    "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
									//IN072511 added id property.
//IN060565 end 
								//IN070534 starts	
									if(!".".equals(name_key.substring(name_key.length()-2,name_key.length()-1))) {
										//IN072511 Start.
										//sbTemplateDummy.append("document.all."+name_key+".onclick();");
										sbTemplateDummy.append("document.getElementById(\""+name_key+"\").onclick();");										
										//IN072511 End.
									}
								//IN070534 ends		
								} else {  //List Box converted to checkbox, where the code has to be stored
									if (check_box_multi_val.equals(dflt_value) ) {
										checked		= "CHECKED";
  									} else {
	 									checked	    = "";	
										dflt_value  = "";
									}
	 										//sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" value=\""+check_box_multi_val+"\"  "+checked+" onClick=\"setMultiCheckBoxValue(this); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"    "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\"check_"+(name_key)+"\" value=\""+check_box_multi_val+"\"><input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+">"); // ML-MOH-CRF-0508.1 [IN062319]
											// ML-MMOH-CRF-0508.1 [IN062319] - Start
											if("Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option) && single_or_multi.equals("M") ){
												selMultiSelectedMap = bean.getMultiListCompMnemonicMapClone();
												String l_check_box_multi_val = "";
												if(("AMEND_ORDER".equalsIgnoreCase(p_function_from) || "COPY_ORDER".equalsIgnoreCase(p_function_from)) && !"".equals(amd_ord_dflt_value)){
													checked		= "CHECKED";
 													l_check_box_multi_val = check_box_multi_val;
												}
	 											if(selMultiSelectedMap != null && selMultiSelectedMap.containsKey(catalog_code+field_mnemonic)){
	 												//selecteCompList =  selMultiSelectedMap.containsKey(catalog_code+field_mnemonic);
	 												selecteCompList = (ArrayList)selMultiSelectedMap.get(catalog_code+field_mnemonic);
	 												if(selecteCompList.contains(parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num)){
	 													checked		= "CHECKED";
	 													l_check_box_multi_val = check_box_multi_val;
	 												} else {
	 													checked		= "";
	 													l_check_box_multi_val = "";
	 												}
	 											}
												sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value=\""+l_check_box_multi_val+"\"  "+checked+" onClick=\"setMultiCheckBoxValMandate(this,'"+catalog_code+"','"+field_mnemonic+"','"+bean_id+"','"+bean_name+"'); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"    "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\"check_"+(name_key)+"\" id=\"check_"+(name_key)+"\" value=\""+check_box_multi_val+"\"><input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">");
												if(!multiListCompList.contains(parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num)){
													multiListCompList.add(parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num);
													completeMultiCheckCompList.add(parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num);
												}

											}else {
												sbTemplate.append("<input type=\"CHECKBOX\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" value=\""+check_box_multi_val+"\"  "+checked+" onClick=\"setMultiCheckBoxValue(this); checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"','"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \"    "+ disabled_prop+">"+mandatory_gif+"<input type=\"hidden\" name=\"check_"+(name_key)+"\" id=\"check_"+(name_key)+"\" value=\""+check_box_multi_val+"\"><input type=\"hidden\" name=\""+(name_key)+"_chkBox\" "+disabled_prop+" id=\""+(name_key)+"_chkBox\" "+disabled_prop+">"); 
											}
											// ML-MMOH-CRF-0508.1 [IN062319] - End
										}
 							}
							else if(field_type.equals("R")) // Radio Group
							{
 								//sbTemplate.append("<input type=\"RADIO\" name=\""+(name_key)+"\" ");
								if (!(order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD") && applicability.equals("N")))
								{
									sbTemplate.append("<table border='0'><tr><td  class=\"fields\" valign=\"top\">");
									ArrayList OrderFormatRadio = beanQueryObj.getOrderFormatRadio(properties, order_category,field_mnemonic,catalog_code,lab_install_yn,contr_msr_panel_id,contr_msr_mod_id);
									int radio_count = OrderFormatRadio.size();
									int ind = 1;
									
									for(int l=0; l<radio_count; l++)
									{
										/*String text_color="";
										String change_color = "";
										if(ind%2==0)
									    {
										change_color="background-color:#808080;";
										text_color ="#808080 ";	
									    }
									    else if(ind%2==1)
									    {
										change_color="background-color:#CC6600;";
										text_color ="#CC6600";	
									    }*/
										//out.println("change_color="+change_color);
										//out.println("text_color="+text_color);
										records = (String[])OrderFormatRadio.get(l);
										if(dflt_value.equals(records[0])) // first Item
										{
											sbTemplate.append("<input type=\"RADIO\"  name=\"radio_"+(name_key)+"\" id=\"radio_"+(name_key)+"\" value=\""+records[0]+"\" checked "+validationClause+">"+records[1]+"</input><BR>");
										}
										else 
										{
											sbTemplate.append("<input type=\"RADIO\" name=\"radio_"+(name_key)+"\" id=\"radio_"+(name_key)+"\" value=\""+records[0]+"\"  "+validationClause+">"+records[1]+"</input><BR>");
										}
										
										ind++;
											records = null;
									} // End of for
									OrderFormatRadio	 = null; //modified append - [IN000767]
									//sbTemplate.append(mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" >&nbsp;<input type=\"button\" name=\"radio_clear\" class=\"BUTTON\"  value=\"Reset\" onClick=\"resetRadioButtons('"+name_key+"',"+radio_count+",'"+dependency_yn+"',"+new_seq_num+","+max_dependency_row+")\" ></td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr></table>");
									sbTemplate.append(mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"\" id=\""+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value+"\" >&nbsp;<input type=\"button\" name=\"radio_clear\" id=\"radio_clear\" class=\"BUTTON\"  value=\"Reset\" onClick=\"resetRadioButtons('"+name_key+"',"+radio_count+",'"+dependency_yn+"',"+new_seq_num+","+max_dependency_row+")\" ></td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr></table>");
								}
							}
							else if(field_type.equals("L"))
							{
								if(field_mnemonic.equalsIgnoreCase("REQUEST_COMMENT")&&order_category.equalsIgnoreCase("LB")&&(labmodule.equalsIgnoreCase("IBARL")))
								{
									String sql = eOR.Common.OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_LAB_INSTAL_REQUEST_COMMENT");
									display_length		= 30;
									String request_comment_desc="";
									if(!dflt_value.equals(""))
									{											request_comment_desc=beanQueryObj.getRequestCommentDesc(properties,dflt_value);
									}

									validationClause	= "onBlur = \"before_show_request_comment_window(this,'"+(name_key)+"','"+(order_type_code)+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" ";

									sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"_desc\"   "+disabled_prop+" "+validationClause+" id=\""+(name_key)+"_desc\"   "+disabled_prop+" "+validationClause+" value=\""+request_comment_desc+"\" size='"+display_length+"'><input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\"   "+disabled_prop+" id=\""+(name_key)+"\"   "+disabled_prop+"  value=\""+dflt_value+"\"><input type='button' name=\""+(name_key)+"_btn\" id=\""+(name_key)+"_btn\"  class=\"button\"   value=\"?\" onClick=\"show_request_comment_window('','"+(name_key)+"','"+order_type_code+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"')\"><input type='hidden' name='"+(name_key)+"_request_comment_sql' id='"+(name_key)+"_request_comment_sql' value=\""+sql+"\">"+mandatory_gif+""); 

								}
								else 														if(((field_mnemonic.equalsIgnoreCase("DONOR_BLOOD_GROUP"))||(field_mnemonic.equalsIgnoreCase("DONOR_RHESUS")))&&order_category.equalsIgnoreCase("LB")&&(labmodule.equalsIgnoreCase("IBARL")))
								{ 
									String sql="";
									if(field_mnemonic.equalsIgnoreCase("DONOR_BLOOD_GROUP"))
									{
										sql = eOR.Common.OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_BLOOD_GROUP");
									}
									else if(field_mnemonic.equalsIgnoreCase("DONOR_RHESUS"))
									{
										sql = eOR.Common.OrRepositoryExt.getOrKeyValue("SQL_OR_TRANSPLANT_DONOR_RHESUS");
									}
									display_length		= 30;
									String donor_blood_desc="";
									if(!dflt_value.equals(""))
									{			
										donor_blood_desc=beanQueryObj.getDonorBloodDesc(properties,dflt_value,field_mnemonic);										
									}

									validationClause	= "onBlur = \"before_show_donor_blood_group_window(this,'"+(name_key)+"','"+(order_type_code)+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'); \" ";

									sbTemplate.append("<input type=\"text\" name=\""+(name_key)+"_desc\"   "+disabled_prop+" "+validationClause+" id=\""+(name_key)+"_desc\"   "+disabled_prop+" "+validationClause+" value=\""+donor_blood_desc+"\" size='"+display_length+"'><input type=\"hidden\" id=\""+(name_key)+"\" name=\""+(name_key)+"\"   "+disabled_prop+" id=\""+(name_key)+"\"   "+disabled_prop+"  value=\""+dflt_value+"\"><input type='button' name=\""+(name_key)+"_btn\" id=\""+(name_key)+"_btn\"  class=\"button\"   value=\"?\"  onClick=\"show_donor_blood_group_window('','"+(name_key)+"','"+order_type_code+"','"+format_id+"','"+field_mnemonic+"','"+new_seq_num+"','"+seq_num+"','"+max_dependency_row+"','"+dependency_yn+"','"+order_category+"','"+contr_msr_panel_id+"','"+contr_msr_mod_id+"','"+discr_msr_id+"','"+performing_facility_id+"','','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"')\"><input type='hidden' name='"+(name_key)+"_donor_sql' id='"+(name_key)+"_donor_sql' value=\""+sql+"\">"+mandatory_gif+""); 

								}
								else
								{
 									if(!single_or_multi.equals("M")) 
									{

									//field_mnemonic_fields	+= field_mnemonic+"ORDERFORMAT"+catalog_code+"ï¿½"; // To check for the Duplicate and to put the same value for the multiple field mnemonics
									//list_item_fields  += field_mnemonic+order_type_code+seq_num+"ï¿½";
										
										//field_mnemonic_fields.append(field_mnemonic+"ORDERFORMAT"+catalog_code+"ï¿½");
										//lb_install_fields.append(lab_install_yn+"ï¿½");
										
										field_mnemonic_fields.append(field_mnemonic+"ORDERFORMAT"+catalog_code+"$");//IN070534
										lb_install_fields.append(lab_install_yn+"$");//IN070534
										//list_item_fields  		+= name_key+"ï¿½";
										//list_item_fields.append(name_key+"ï¿½");
										list_item_fields.append(name_key+"$");//IN070534
										//label_text_value		+= label_text+"ï¿½";
										//label_text_value.append(label_text+"ï¿½");
										label_text_value.append(label_text+"$");//IN070534
										if(order_category.equals("RD"))
										{

							   
										   if(field_mnemonic.equals("CONTRAST_REQD"))
											{
											   applicability            = bean.getapplicability(catalog_code);
											 
											   if(applicability.equals("R"))
												{
													disabled_prop		= "DISABLED";
												}
											}
										}
										//if(order_category.equals("OT") && ot_install_yn.equals("Y") && oper_side_appl_yn.equals("N") && old_field_mnemonic.equals("OPER_SIDE_APPL"))
										if(order_category.equals("OT") && ot_install_yn.equals("Y") && oper_side_appl_yn.equals("N") && field_mnemonic.equals("OPER_SIDE_APPL"))//IN044959
											disabled_prop		= "DISABLED";
										if (!(order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD") && applicability.equals("N")))
										{
											if(field_mnemonic.equalsIgnoreCase("ANATOMY_SITE"))
											{
												fixField = "";tissueField="";
												tissueCount = 0; fixativeCount = 0;
												anatomyCount++;
												anatomy_val =  true;
											
												sbTemplate.append("<select name=\""+(name_key)+"\" id=\""+(name_key)+"\" "+ disabled_prop+" onChange=\"checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');populateTissueDetails(this,'"+catalog_code+"','"+anatomyCount+"'); \">");//IN049133
												//IN072511 added id property.
											}
											else if (field_mnemonic.equalsIgnoreCase("TISSUE_DESC"))
											{
												tissueCount++;
												sbTemplate.append("<select name=\""+(name_key)+"\" id=\""+(name_key)+"\" "+ disabled_prop+" onChange=\"checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"');\">");//IN049133
												//IN072511 added id property.
												tissueField = name_key;
											}
											else
											{
												//IN045352 Starts
											/*if(order_category.equals("OT") && ot_install_yn.equals("Y") && field_mnemonic.equals("SURGERY_TYPE")) 
											{																							
												validationClause_new = "'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"'";
												sbTemplate.append("<input type=\"hidden\" name=\"validationClause_new"+i+"\" value=\""+validationClause_new+"\">");//IN045522 
				    							sbTemplate.append("<input type=\"hidden\" name=\"name_key_new"+i+"\" value=\""+name_key+"\">");//IN045522
											}*/
											//IN045352 Ends
												sbTemplate.append("<select name=\""+(name_key)+"\" id=\""+(name_key)+"\" "+ disabled_prop+"	  onChange=\"checkDependency(this,'"+format_id+"','"+field_mnemonic+"',"+new_seq_num+", "+seq_num+", "+max_dependency_row+", '"+dependency_yn+"' ,'"+order_category+"', '"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"' ,'"+oper_side_appl_yn+"','"+specimen_def_yn+"','"+login_facility_id+"','"+sex+"','"+catalog_code+"','"+oth_dependency_yn+"'); \">");
												//IN072511 added id property.
											}
											if(field_mnemonic.equalsIgnoreCase("FIXATIVE"))
											{
												fixativeCount++;
												fixField = name_key;
											}
										//IN070534 starts	
											if(!".".equals(name_key.substring(name_key.length()-2,name_key.length()-1))){
												//IN072511 Start.
												sbTemplateDummy.append("document.getElementById(\""+name_key+"\").onchange();");
												//sbTemplateDummy.append("document.all."+name_key+".onchange();");
												//IN072511 End.
											}
										//IN070534 ends	
										}
										if(field_mnemonic.equalsIgnoreCase("PRES_REMARKS")) // For PH Functions and field_mnemonic = "PRES_REMARKS"
										{
											//	if(!single_or_multi.equals("M")) {
											sbTemplate.append("<option value=\"\">-----  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----</option>");
											//	}	
											ArrayList OrderFormatList=beanQueryObj.getprescriptionremarks(p_catalog_code,p_form_code,p_route_code,properties);
										
											String[] phrecords=null;
											if(OrderFormatList.size()>0)
											{
											for(int l=0; l<OrderFormatList.size(); l++)
											{
												phrecords = (String[])OrderFormatList.get(l);

												/*stPhListVals 		= new StringTokenizer(ph_list_vals,"::");
												while(stPhListVals.hasMoreTokens())
												{
													ph_list_val	= stPhListVals.nextToken();
													ph_list_desc= stPhListVals.nextToken();
													if(dflt_value.equals(ph_list_val))
														sbTemplate.append("<option value=\""+ph_list_val+"\" selected>"+ph_list_desc+"</option>");
													else
														sbTemplate.append("<option value=\""+ph_list_val+"\" >"+ph_list_desc+"</option>");
												}*/
												if(!dflt_value.equals(""))
												{
													if(dflt_value.equals(phrecords[0]))
													{
														sbTemplate.append("<option value=\""+phrecords[0]+"\" selected>"+phrecords[1]+"</option>");
													}else
													{
														sbTemplate.append("<option value=\""+phrecords[0]+"\" >"+phrecords[1]+"</option>");
													}
											}else
											{
												if((bean.checkForNull(phrecords[2],"")).equalsIgnoreCase("Y"))
												{
													sbTemplate.append("<option value=\""+phrecords[0]+"\" selected>"+phrecords[1]+"</option>");
												}
												else
												{
													sbTemplate.append("<option value=\""+phrecords[0]+"\">"+phrecords[1]+"</option>");
												}
											}
										}
								
									}
								}
								else // other than PRES_REMARKS
								{
									//if(dflt_value!=null && !dflt_value.equals("") && single_or_multi.equals("M") && dflt_value.indexOf("||")!=-1) {
 									//	sbTemplate.append("<option value=\""+dflt_value+"\">"+dflt_value.substring(0,1)+"...More"+"</option>");
 								//	} else {
								//	if(!single_or_multi.equals("M")) {
										if (!(order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD") && applicability.equals("N"))){
										//}else{
										sbTemplate.append("<option value=\"\">----- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</option>");
										}
										if(field_mnemonic.equalsIgnoreCase("ANATOMY_SITE"))
										{
											anatomyCode = dflt_value;
										}
										ArrayList OrderFormatList = new ArrayList();
										if(!field_mnemonic.equalsIgnoreCase("TISSUE_DESC"))
										{	
											OrderFormatList = beanQueryObj.getOrderFormatList(properties, order_category,field_mnemonic,contr_msr_panel_id,contr_msr_mod_id,order_type_code,discr_msr_id,performing_facility_id,login_facility_id,sex, lab_install_yn, bt_install_yn, rd_install_yn, ot_install_yn,catalog_code);
										}
										else
										{
											OrderFormatList = beanFormatObj.populateTissueFields(properties, anatomyCode);
										}
								//	}
										for(int l=0; l<OrderFormatList.size(); l++)
										{
											records = (String[])OrderFormatList.get(l);
											appendCodeDesc = records[0]+"||"+records[1];//IN043095
											//if(dflt_value.equals(records[0]) || (order_category.equals("OT") && ot_install_yn.equals("Y") && oper_side_appl_yn.equals("N") &&  old_field_mnemonic.equals("OPER_SIDE_APPL") && records[0].equals("Not Applicable")) )
											if(dflt_value.equals(records[0]) || (order_category.equals("OT") && ot_install_yn.equals("Y") && oper_side_appl_yn.equals("N") &&  field_mnemonic.equals("OPER_SIDE_APPL") && records[0].equals("Not Applicable")) ) //IN044959	
									   			sbTemplate.append("<option value=\""+records[0]+"\" selected>"+records[1]+"</option>");
											else if(field_mnemonic.equals("CONTRAST_REQD"))   //else if(old_field_mnemonic.equals("CONTRAST_REQD")) //IN044959
											{
												if(applicability.equals("R"))
												{
													if(records[1].equals("Only Contrast")) 
													{					
														sbTemplate.append("<option value=\""+records[0]+"\" selected>"+records[1]+"</option>");
													}
												}
												else if(applicability.equals("O"))
												{
													sbTemplate.append("<option value=\""+records[0]+"\" >"+records[1]+"</option>");
												}
												
											}//IN043095 Starts
											else if(field_mnemonic.equalsIgnoreCase("SURGERY_TYPE"))
											{
												if( dflt_value.equals(records[0]) ) //IN045352
												{	
													sbTemplate.append("<option value=\""+appendCodeDesc+"\" selected >"+records[1]+"</option>");
												}
												else
												{
													sbTemplate.append("<option value=\""+appendCodeDesc+"\" >"+records[1]+"</option>");
												}
												
											}//IN043095 Ends
											else
											{
												if(!field_mnemonic.equalsIgnoreCase("TISSUE_DESC"))
												{
													if( records[2].equalsIgnoreCase("Y")) // If lab is installed and to default the value for specimen type
														sbTemplate.append("<option value=\""+records[0]+"\" selected>"+records[1]+"</option>");
													else
														sbTemplate.append("<option value=\""+records[0]+"\" >"+records[1]+"</option>");
												}
												else
												{
													sbTemplate.append("<option value=\""+records[0]+"\" >"+records[1]+"</option>");
												}
											}
										} // End of for
										if(OrderFormatList!=null) {
											OrderFormatList.clear();
											OrderFormatList	= null;
										}
								//	} //End of else
								} // End of OR
								//if(!single_or_multi.equals("M")) {
									sbTemplate.append("</select>"+mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"_desc\" id=\""+(name_key)+"_desc\" value=\"\" >");
								} 
								/*else {  //provide a button to see the values
									 display_length		= 30;
									 max_allowed_length = 30;
									 if(dflt_value.indexOf("||")!=-1)
										 dflt_value_display	= dflt_value.substring(0,1)+"...More";
									 else 
										 dflt_value_display = dflt_value;
									 sbTemplate.append("<input type=\"text\" name=\"name_"+(name_key)+"\" size=\""+display_length+"\" maxLength=\""+max_allowed_length+"\" value=\""+dflt_value_display+"\" "+validationClause+" "+display_only_prop+" "+ readOnlyClause+" >");
									sbTemplate.append(mandatory_gif+"<input type=\"hidden\" name=\""+(name_key)+"\" value=\""+dflt_value+"\" >");
									sbTemplate.append(dateText+mandatory_gif); 
									sbTemplate.append("<input type=\"button\" class=\"button\" name=\"button_"+(name_key)+"\" value=\"?\"  onClick=\"displayMultiSelectList('"+(name_key)+"',"+new_seq_num+", "+seq_num+", '"+order_category+"','"+field_mnemonic+"','"+contr_msr_panel_id+"', '"+contr_msr_mod_id+"' ,'"+order_type_code+"' ,'"+discr_msr_id+"' ,'"+performing_facility_id+"','"+login_facility_id+"','"+sex+"' ,'"+lab_install_yn+"','"+bt_install_yn+"','"+rd_install_yn+"','"+ot_install_yn+"')\" >");
									//parent_field_mnemonic+"ORDERFORMAT"+catalog_code+new_seq_num
								} // End of single_or_multi
								*/
								}
							}	 // end of field_type = 'L'
							if(fixativeCount > 1)
							{
								fixField = "";
							}
							
							if(tissueCount > 1)
							{
								tissueField = "";
							}

							if(!fixField.equals("")  && fixativeCount>0 && anatomy_val)
							{
								sbTemplate.append("<input type=\"hidden\" name=\"fixativeField"+(anatomyCount)+"\" id=\"fixativeField"+(anatomyCount)+"\" value=\""+fixField+"\">");
								fixField = "";
								//fixativeCount = 0;
							}
							if(!tissueField.equals("") && tissueCount>0 && anatomy_val)
							{
								sbTemplate.append("<input type=\"hidden\" name=\"tissueDescField"+(anatomyCount)+"\" id=\"tissueDescField"+(anatomyCount)+"\" value=\""+tissueField+"\">");
								tissueField = "";
								//tissueCount = 0;
							}
							sbTemplate.append("</td>");
   							if(single_or_multi.equals("M") && multi_last_record.equals("Y"))
							{
 								sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr>");  //BLANK_ROW
								group_field_mnemonic_count = 0; //Assingn to zero to identify the grouping is over
	 						}

							field_validation	= (name_key);
							sbTemplate.append("<input type=\"hidden\" name=\"field_validation"+row_count+"\" id=\"field_validation"+row_count+"\" value=\""+field_validation+"\">");
											
							//sbTemplate.append("<input type=\"hidden\" name=\"lab_install_yn"+row_count+"\" value=\""+lab_install_yn+"\">");

 							// If any dependency or any message for field_mnemonic is there

							sbTemplate.append("<input type=\"hidden\" name=\"field_mnemonic_action"+name_key+"\" id=\"field_mnemonic_action"+name_key+"\" value=\""+field_mnemonic_action+"\">");
							sbTemplate.append("<input type=\"hidden\" name=\"field_action_msg"+name_key+"\" id=\"field_action_msg"+name_key+"\" value=\""+field_action_msg+"\">");
							sbTemplate.append("<input type=\"hidden\" name=\"notify_yn"+name_key+"\" id=\"notify_yn"+name_key+"\" value=''>");
							sbTemplate.append("<input type=\"hidden\" name=\"field_value_type"+name_key+"\" id=\"field_value_type"+name_key+"\" value=\""+field_value_type+"\">");
							sbTemplate.append("<input type=\"hidden\" name=\"default_value"+name_key+"\" id=\"default_value"+name_key+"\" value=\""+default_value+"\">"); //IN045798
							
							// Only for dependency type, we will set in the hidden fields
							sbTemplate.append("<input type=\"hidden\" name=\"field_mnemonic"+name_key+"\" id=\"field_mnemonic"+name_key+"\" value=\""+field_mnemonic+"\">");
							sbTemplate.append("<input type=\"hidden\" name=\"label_text"+name_key+"\" id=\"label_text"+name_key+"\" value=\""+label_text+"\">");
							sbTemplate.append("<input type=\"hidden\" name=\"accept_option"+name_key+"\" id=\"accept_option"+name_key+"\" value=\""+accept_option+"\">");
 							sbTemplate.append("<input type=\"hidden\" name=\"field_type"+name_key+"\" id=\"field_type"+name_key+"\" value=\""+field_type+"\">");
 							sbTemplate.append("<input type=\"hidden\" name=\"dependency_yn"+name_key+"\" id=\"dependency_yn"+name_key+"\" value=\""+dependency_yn+"\">");
 							sbTemplate.append("<input type=\"hidden\" name=\"oth_dependency_yn"+name_key+"\" id=\"oth_dependency_yn"+name_key+"\" value=\""+oth_dependency_yn+"\">");// IN049133
							// Hidden fields to check the max &  min , if there
							sbTemplate.append("<input type=\"hidden\" name=\"min_max"+(name_key)+"\" id=\"min_max"+(name_key)+"\" value=\""+min_num_value+"#"+max_num_value+"\">");

							//if( field_type.equals("I") || field_type.equals("N") )
							//{
							//sbTemplate.append("<input type=\"hidden\" name=\"min_max"+(name_key)+"\" value=\""+min_num_value+"§"+max_num_value+"\">");
							//}
  				    		//	help_text = java.net.URLEncoder.encode(help_text);
 
			/*				sbTemplate.append("<input type=\"hidden\" name=\"dependency_field_mnemonic_value"+name_key+"\" value=''>");
							sbTemplate.append("<input type=\"hidden\" name=\"dependency_value_seq_num"+name_key+"\" value=''>");
							sbTemplate.append("<input type=\"hidden\" name=\"dependency_field_mnemonic_value1"+name_key+"\" value=''>");
							sbTemplate.append("<input type=\"hidden\" name=\"dependency_field_value_type"+name_key+"\" value=''>");
							
							sbTemplate.append("<input type=\"hidden\" name=\"dependency_oth_mnemonic_yn"+name_key+"\" value=''>");
			*/
							if((display_dependency.equalsIgnoreCase("display:"))) /*||(display_transplant.equalsIgnoreCase("display:inline")) )*/
							{
								format_size++;
							}
							//if(format_size!= 0 && format_size%2==0)
							
							if(tr!= 0 && tr%2==1)
			    			{		
								if (!(order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD") && applicability.equals("N")))
								{
			    	    			sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");
			    	    		//sbTemplate.append("<tr><td class=\"LABEL\"  align=\"left\" width=\"20%\" colspan=\"5\">&nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");
			    	    			sbTemplate.append("<tr>");
								}
			    			}
							row_count++;
							if (!(order_category.equals("RD") && field_mnemonic.equals("CONTRAST_REQD") && applicability.equals("N")))
							{
								tr++;
							}
							group_field_mnemonic	= field_mnemonic;
							if(multiListCompMap != null && !multiListCompMap.containsKey(catalog_code+field_mnemonic) && "Y".equals(ord_formt_multi_chk_nonmandate_yn) && "R".equals(accept_option) && single_or_multi.equals("M")) { // ML-MMOH-CRF-0508.1 [IN062319] - Start
								multiListCompMap.put(catalog_code+field_mnemonic, multiListCompList);
							}  // ML-MMOH-CRF-0508.1 [IN062319] - End
							if("AMEND_ORDER".equalsIgnoreCase(p_function_from) || "COPY_ORDER".equalsIgnoreCase(p_function_from)) {
	   			    				amd_ord_dflt_value = "";
	   			    			}
 			     		} // end of for
						template.put("accept_option",accept_option);//IN069657
						}//IN043099
			  		} // End of arrSeqNo.size()
					if("Y".equals(ord_formt_multi_chk_nonmandate_yn)) { // ML-MMOH-CRF-0508.1 [IN062319] - Start
 			     		bean.setMultiListCompMnemonicMap(multiListCompMap);	
						bean.setCompleteMultiCheckCompList(completeMultiCheckCompList);
					} // ML-MMOH-CRF-0508.1 [IN062319] - End				
					arrSeqNo				= (ArrayList) orderEntryRecordBean.getOrderFormats("Comments"+catalog_code, catalog_code);
			  		if(arrSeqNo!=null && arrSeqNo.size()>0)
			  		{
				  		comment 			 =  bean.checkForNull((String) arrSeqNo.get(0),""); // comment
			  			preps_instrn         =  bean.checkForNull((String) arrSeqNo.get(1),""); // preps
			  			preps_dept_instrn    =  bean.checkForNull((String) arrSeqNo.get(2),""); // Dept
			  			pat_preps_instrn     =  bean.checkForNull((String) arrSeqNo.get(3),""); // patient Instrn.
						if(comment.equals("")&&preps_instrn.equals("")&&preps_dept_instrn.equals("")&&pat_preps_instrn.equals(""))
						{
							//preps_instrn 		= bean.checkForNull(bean.getPreps(catalog_code,"PR"),"");  // For Preps Instructions
							instructionsMap 	= bean.getPreps(catalog_code);  // For Patient Preps. Insructions.
							preps_instrn		= bean.checkForNull((String)instructionsMap.get(prepsinstrn),"");
			  				//preps_dept_instrn	= bean.checkForNull(bean.getPreps(catalog_code,"DR"),"");  // For Dept. Instructions
							preps_dept_instrn	= bean.checkForNull((String)instructionsMap.get(prepsdeptinstrn),"");  // For Dept. Instructions
							if(bean.checkForNull(pat_sex_yn_arr[i],"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
							{
								ArrayList AgeSexPatInstrn = bean.getAgePreps();
								for(int j=0; j<AgeSexPatInstrn.size(); j++)
								{
									String[] record 	= (String[])AgeSexPatInstrn.get(j);
									age_in_days			= (Integer.parseInt(record[0]));
										sex_yn			 	= record[1];
								}
								pat_preps_instrn 		= bean.checkForNull(bean.getPrepsInstructions(catalog_code,age_in_days,sex_yn),""); // For Patient Preps. Insructions
								out.println(catalog_code+" "+age_in_days+" "+sex_yn);
							}
							else
							{
								//pat_preps_instrn 		= bean.checkForNull(bean.getPreps(catalog_code,"IS"),"");  // For Patient Preps. Insructions
								pat_preps_instrn 		= bean.checkForNull((String)instructionsMap.get(patprepsinstrn),"");  // For Patient Preps. Insructions
							}
						}
					}
			  		else
			  		{
						bean.setInstrnContentType(catalog_code,l_instrn_content_type);//IN64543
						
			  			instructionsMap 	= bean.getPreps(catalog_code);  // For Patient Preps. Insructions.
			  			if(amend_order_id.equals("") && amend_order_line_num.equals(""))
			  			{
			  				//preps_instrn 		= bean.checkForNull(bean.getPreps(catalog_code,"PR"),"");  // For Preps Instructions
							preps_instrn 		= bean.checkForNull((String)instructionsMap.get(prepsinstrn),"");  // For Preps Instructions
			  				//preps_dept_instrn	= bean.checkForNull(bean.getPreps(catalog_code,"DR"),"");  // For Dept. Instructions
							preps_dept_instrn	= bean.checkForNull((String)instructionsMap.get(prepsdeptinstrn),"");  // For Dept. Instructions
							if(bean.checkForNull(pat_sex_yn_arr[i],"N").equalsIgnoreCase("Y")) // For pat_instrn_age_sex_yn ="Y" to check for the Patient Instructions
							{
								ArrayList AgeSexPatInstrn = bean.getAgePreps();
								for(int j=0; j<AgeSexPatInstrn.size(); j++)
								{
									String[] record 	= (String[])AgeSexPatInstrn.get(j);
									age_in_days			= (Integer.parseInt(record[0]));
										sex_yn			= record[1];
								}
								pat_preps_instrn 		= bean.checkForNull(bean.getPrepsInstructions(catalog_code,age_in_days,sex_yn),""); // For Patient Preps. Insructions
							}
							else
							{
								//pat_preps_instrn 		= bean.checkForNull(bean.getPreps(catalog_code,"IS"),"");  // For Patient Preps. Insructions
								pat_preps_instrn 		= bean.checkForNull((String)instructionsMap.get(patprepsinstrn),"");  // For Patient Preps. Insructions
							}
				   	   }
				   }
					sbTemplate.append("<input type=\"hidden\" name=\"catalog_code"+i+"\" id=\"catalog_code"+i+"\" value=\""+catalog_code+"\">");

		  			//IN64543, starts
					//validationClause	= "onBlur = \"makeValidString( this );CheckMax('Comments',this,2000,top.message_frame)\" onkeyPress=\"return checkMaxLimit1(this,2000)\" " ;					
					
					l_showHidInstrn = "style='display:'";
					
					if("E".equals(l_instrn_content_type))
					{
						l_showHidInstrn = "style='display:none'";
					}
					else if("T".equals(l_instrn_content_type))
					{	
			  			validationClause	= "onBlur = \"makeValidString( this );CheckMax('Comments',this,2000,top.message_frame)\" onkeyPress=\"return checkMaxLimit1(this,2000)\" " ;
					}
					//IN64543, ends
			  		sbTemplate.append("<tr><td class=\"LABEL\"  width=\"15%\" "+l_showHidInstrn+">");
					//String comments="+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+";
					//String comments = "<fmt:message key=\"Common.Comments.label\" bundle=\"${common_labels}\"/>";
					//sbTemplate.append("Comments");
					sbTemplate.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels"));

					//IN64543, starts
					/*
					sbTemplate.append("</td><td  class=\"fields\"  width=\"15%\" ><TEXTAREA name=\"CMTS"+catalog_code+"\" ROWS=\"3\" COLS=\"30\" MAXLENGTH=\20\" "+validationClause+">"+comment+"</TEXTAREA></td>");
			  		sbTemplate.append("<td class=\"LABEL\" width=\"15%\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PreparatoryInstruction.label","or_labels")+"</td><td   class=\"fields\"  width=\"15%\"><TEXTAREA name=\"PREPS"+catalog_code+"\" ROWS=\"3\" COLS=\"30\" "+validationClause+">"+preps_instrn+"</TEXTAREA></td><td colspan='2'>&nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");
					if(order_category.equals("LB")&&lab_install_yn.equalsIgnoreCase("Y"))
					{
					sbTemplate.append("<tr><td class=\"LABEL\"  width=\"15%\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentInstruction.label","or_labels")+"</td><td   class=\"fields\"  width=\"15%\"><TEXTAREA name=\"DEPT"+catalog_code+"\" ROWS=\"3\" COLS=\"30\"  "+validationClause+"  readonly>"+preps_dept_instrn+"</TEXTAREA></td>");
					}else{
					sbTemplate.append("<tr><td class=\"LABEL\"  width=\"15%\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentInstruction.label","or_labels")+"</td><td   class=\"fields\"  width=\"15%\"><TEXTAREA name=\"DEPT"+catalog_code+"\" ROWS=\"3\" COLS=\"30\"  "+validationClause+">"+preps_dept_instrn+"</TEXTAREA></td>");}

 				    	sbTemplate.append("<td class=\"LABEL\"  width=\"15%\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientInstruction.label","common_labels")+"</td><td   class=\"fields\"  width=\"15%\"><TEXTAREA name=\"PATIENT"+catalog_code+"\" ROWS=\"3\" COLS=\"30\" "+validationClause+" >"+pat_preps_instrn+"</TEXTAREA></td>");
					*/
					sbTemplate.append("</td><td  class=\"fields\"  width=\"15%\" "+l_showHidInstrn+"><TEXTAREA id=\"CMTS"+catalog_code+"\" name=\"CMTS"+catalog_code+"\" ROWS=\"3\" COLS=\"30\" MAXLENGTH=\20\" "+validationClause+">"+comment+"</TEXTAREA></td>");
			  		sbTemplate.append("<td class=\"LABEL\" width=\"15%\" "+l_showHidInstrn+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PreparatoryInstruction.label","or_labels")+"</td><td   class=\"fields\"  width=\"15%\" "+l_showHidInstrn+"><TEXTAREA id=\"PREPS"+catalog_code+"\" name=\"PREPS"+catalog_code+"\" ROWS=\"3\" COLS=\"30\" "+validationClause+">"+preps_instrn+"</TEXTAREA></td><td colspan='2'>&nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");
					if(order_category.equals("LB")&&lab_install_yn.equalsIgnoreCase("Y"))
					{
					sbTemplate.append("<tr><td class=\"LABEL\"  width=\"15%\" "+l_showHidInstrn+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentInstruction.label","or_labels")+"</td><td   class=\"fields\"  width=\"15%\" "+l_showHidInstrn+"><TEXTAREA id=\"DEPT"+catalog_code+"\" name=\"DEPT"+catalog_code+"\" ROWS=\"3\" COLS=\"30\"  "+validationClause+"  readonly>"+preps_dept_instrn+"</TEXTAREA></td>");
					}else{
					sbTemplate.append("<tr><td class=\"LABEL\"  width=\"15%\" "+l_showHidInstrn+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentInstruction.label","or_labels")+"</td><td   class=\"fields\"  width=\"26%\" "+l_showHidInstrn+"><TEXTAREA id=\"DEPT"+catalog_code+"\" name=\"DEPT"+catalog_code+"\" ROWS=\"3\" COLS=\"30\"  "+validationClause+">"+preps_dept_instrn+"</TEXTAREA></td>");}

 				    	sbTemplate.append("<td class=\"LABEL\"  width=\"15%\" "+l_showHidInstrn+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientInstruction.label","common_labels")+"</td><td   class=\"fields\"  width=\"15%\" "+l_showHidInstrn+"><TEXTAREA id=\"PATIENT"+catalog_code+"\" name=\"PATIENT"+catalog_code+"\" ROWS=\"3\" COLS=\"30\" "+validationClause+" >"+pat_preps_instrn+"</TEXTAREA></td>");
					//IN64543, ends
 					//sbTemplate.append("<td colspan=\"2\">&nbsp;</td>");//IN64543
					//sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr>");//IN64543
					sbTemplate.append("</tr>");//IN64543
					
					//IN64543, starts
					if("E".equals(l_instrn_content_type))
					{
						
						ArrayList<String> arr = editorFormation(catalog_code,pageContext,order_category);
						sbTemplate.append(arr.get(0));
						waitForCompleteLoadIndivi.append(arr.get(1));
					}				
					//IN64543, ends
				//IN070534 starts	
					//sbTemplate.append("<input type=\"hidden\" name=\"instrn_content_type"+catalog_code+"\" value=\""+l_instrn_content_type+"\">");//IN64543
					String catalog_code_temp = catalog_code.replace(".","_");
				    sbTemplate.append("<input type=\"hidden\" name=\"instrn_content_type"+catalog_code_temp+"\" id=\"instrn_content_type"+catalog_code_temp+"\" value=\""+l_instrn_content_type+"\">");
					//IN072511 added id property.
				//IN070534 ends	
					old_order_category			= order_category;
	        	} // end of for  i

	        	// To check for the mandatory fields
			    if(mandatory_fields.length()>0)
			    {
				 	mandatory_fields	=	mandatory_fields.substring(0,mandatory_fields.length()-1);
					//mandatory_fields.append(mandatory_fields.toString().substring(0,mandatory_fields.length()-1));
				 	mandatory_names		=	mandatory_names.substring(0,mandatory_names.length()-1);
					//mandatory_names.append(mandatory_names.toString().substring(0,mandatory_names.length()-1));
 			    }
				if(transplant_fields.length()>0)
			    {
				 	transplant_fields	=	transplant_fields.substring(0,transplant_fields.length()-1);
 			    }
				if(field_mnemonic_fields.length()>0)
			    	//field_mnemonic_fields	=	field_mnemonic_fields.substring(0,field_mnemonic_fields.length()-1);
                // field_mnemonic_fields.append(field_mnemonic_fields.toString().substring(0,field_mnemonic_fields.length()-1));//IN070534

			    if(list_item_fields.length()>0)
			    {
					//list_item_fields	=	list_item_fields.substring(0,list_item_fields.length()-1);

						list_item_fields.append(list_item_fields.substring(0,list_item_fields.length()-1));
			    }

				if(lb_install_fields.length()>0)
			    {
					//list_item_fields	=	list_item_fields.substring(0,list_item_fields.length()-1);

						lb_install_fields.append(lb_install_fields.substring(0,lb_install_fields.length()-1));
			    }

			    if(label_text_value.length() >0)
					//label_text_value	=	label_text_value.substring(0,label_text_value.length()-1);
					label_text_value.append(label_text_value.toString().substring(0,label_text_value.length()-1));
			sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp; </td></tr><tr><td class=\"LABEL\"   width=\"20%\" colspan=\"6\"> &nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\"></td></tr></table>");//IN64543
			sbTemplate.append("<input type=\"hidden\" name=\"ord_formt_multi_chk_nonmand_yn\" id=\"ord_formt_multi_chk_nonmand_yn\" value=\""+ord_formt_multi_chk_nonmandate_yn+"\">"); // ML-MMOH-CRF-0508.1 [IN062319]
			 sbTemplate.append("<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\""+called_from+"\">");
             sbTemplate.append("<input type=\"hidden\" name=\"total_rows\" id=\"total_rows\" value=\""+total_rows+"\">");
			 sbTemplate.append("<input type=\"hidden\" name=\"row_count\" id=\"row_count\" value=\""+row_count+"\">");
		     sbTemplate.append("<input type=\"hidden\" name=\"lab_install_yn\" id=\"lab_install_yn\" value=\""+lb_install_fields.toString()+"\">");
			 sbTemplate.append("<input type=\"hidden\" name=\"bt_install_yn\" id=\"bt_install_yn\" value=\""+bt_install_yn+"\">");
			 sbTemplate.append("<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\""+rd_install_yn+"\">");
			 sbTemplate.append("<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\""+ot_install_yn+"\">");
		     sbTemplate.append("<input type=\"hidden\" name=\"mandatory_fields\" id=\"mandatory_fields\" value=\""+mandatory_fields.toString()+"\">");
			 sbTemplate.append("<input type=\"hidden\" name=\"transplant_fields\" id=\"transplant_fields\" value=\""+transplant_fields+"\">");
		     sbTemplate.append("<input type=\"hidden\" name=\"mandatory_names\" id=\"mandatory_names\" value=\""+mandatory_names.toString()+"\">");
		     sbTemplate.append("<input type=\"hidden\" name=\"list_item_fields\" id=\"list_item_fields\" value=\""+list_item_fields.toString()+"\">");
		     sbTemplate.append("<input type=\"hidden\" name=\"field_mnemonic_fields\" id=\"field_mnemonic_fields\" value=\""+field_mnemonic_fields.toString()+"\">");
		     sbTemplate.append("<input type=\"hidden\" name=\"label_text_value\" id=\"label_text_value\" value=\""+label_text_value.toString()+"\">");
 			 sbTemplate.append("<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\""+sys_date+"\">");
			 sbTemplate.append("<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\""+sys_date_time+"\">");
			  sbTemplate.append("<input type=\"hidden\" name=\"sql_or_order_entry_nm_mother_pat_details_select\"  id=\"sql_or_order_entry_nm_mother_pat_details_select\" value=\""+sql_or_order_entry_nm_mother_pat_details_select+"\">");
			  sbTemplate.append("<input type=\"hidden\" name=\"count\" id=\"count\" value=\""+total_rows+"\">");//IN045522
		     //sbTemplate.append("</tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"LABEL\"   width=\"20%\" colspan=\"6\">&nbsp;</td></tr><tr><td class=\"LABEL\"  width=\"15%\" colspan=\"6\">&nbsp;</td></tr></table>");/IN64543
		    	//	}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		sbTemplate.append("<script>document.onreadystatechange = function(){"+waitForCompleteLoadIndivi+"}</script>");//IN64543
        return sbTemplate;		
	}
%>
<%!
	private void checkReplaceAmend(eOR.OrderEntryBean bean,eOR.Common.OrderEntryRecordBean orderEntryRecordBean, String ind_catalog_code , String ind_row_value, String field_mnemonic, Hashtable template) throws Exception
	{
		Hashtable dummy_template		= null;
		int		old_stored_seq_num		= 0;

		// If already there, then no need to add it again so replace the value with the current value, so take the values from the bean and then try to set it again
		ArrayList arrSeqNo				= (ArrayList) orderEntryRecordBean.getOrderFormats(ind_catalog_code, ind_row_value); 
		for(int t=0;t<arrSeqNo.size();t++)	// Main Loop
		{
			 old_stored_seq_num			=  Integer.parseInt((String)arrSeqNo.get(t));  
			 dummy_template				=  (Hashtable) orderEntryRecordBean.getOrderFormats ( ind_catalog_code, (ind_catalog_code+old_stored_seq_num) );
				// To replace the default_value
			//if(bean.checkForNull((String)dummy_template.get("single_or_multi"),"").equals("M") &&  bean.checkForNull((String)dummy_template.get("field_type"),"").equals("C") && bean.checkForNull((String)dummy_template.get("field_mnemonic"),"").equals(field_mnemonic) && (bean.checkForNull((String)dummy_template.get("dflt_value"),"").indexOf(bean.checkForNull((String)template.get("field_values"),""))!=-1) ) //IN049124
			  if(bean.checkForNull((String)dummy_template.get("single_or_multi"),"").equals("M") &&  bean.checkForNull((String)dummy_template.get("field_type"),"").equals("C") && bean.checkForNull((String)dummy_template.get("field_mnemonic"),"").equals(field_mnemonic) && bean.checkForNull((String)dummy_template.get("label_text"),"").equals(bean.checkForNull((String)template.get("label_text"),"")) )//IN049124 
			  {	
				dummy_template.put("field_values",bean.checkForNull((String)template.get("field_values"),"")) ;
				
					orderEntryRecordBean.setOrderFormats(ind_catalog_code, (ind_catalog_code+old_stored_seq_num),dummy_template);
 			  }
 		} // End of for

		// Do not clear the Hashtable and ArrayList, since it will clear the actual value
 	}	// End of checkReplaceAmend
%>

<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);
%>
<!-- Newly added script by Name :selvin  Date :10 june 2011 INCIDENT NO: 27383 Changes:newly added javascript,Starts -->
<script language="javascript" type="text/javascript">
		//IN049133
		if(parent.flex_fields_button.document.OrderEntryFormatButtons)
		{	
			if(parent.flex_fields_button.document.OrderEntryFormatButtons.ok.disabled)
			parent.flex_fields_button.document.OrderEntryFormatButtons.ok.disabled = false;   
			if(parent.flex_fields_button.document.OrderEntryFormatButtons.CANCEL.disabled)
			parent.flex_fields_button.document.OrderEntryFormatButtons.CANCEL.disabled = false;   
		}

</script> 
<!--Ends-->


<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>
<%@ page import="eXH.*" %>

<SCRIPT LANGUAGE="javascript" SRC="../eCommon/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/DMSSimulator.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/ExternalApplication.js"></SCRIPT>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="documentList" name="documentList" id="documentList" METHOD="post">

<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="100%">
<TR>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="7"> 
		<A CLASS='label' onClick="funAction('P')" STYLE='cursor:pointer'>${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
<TR>
	<TD CLASS='COLUMNHEADER'>PatientID</TD>
	<TD CLASS='COLUMNHEADER'>Document ID</TD>
	<TD CLASS='COLUMNHEADER'>Encounter ID</TD>
	<TD CLASS='COLUMNHEADER'>Document Type</TD>
	<TD CLASS='COLUMNHEADER'>Filename</TD>
</TR>
<c:forEach var="document" items="${documents}">
<TR>
	<TD CLASS="${document[15]}">
		<A HREF='#' onClick='viewScan(this)' documentType='${document[3]}' documentID='${document[0]}' patientID='${document[1]}' encounterID='${document[2]}'>${document[1]}</a>
	</TD>
	<TD CLASS="${document[15]}">${document[0]}</TD>
	<TD CLASS="${document[15]}">${document[2]}</TD>
	<TD CLASS="${document[15]}">${document[3]}</TD>
	<TD CLASS="${document[15]}">${document[4]}</TD>
</TR>
</c:forEach>
</TABLE>

<INPUT TYPE='hidden' name='action_type' id='action_type' ID='action_type' VALUE="${action_type}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType'>
</FORM>
</BODY>
</HTML>


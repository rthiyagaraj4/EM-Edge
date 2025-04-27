<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
	
	String facility_id=(String) session.getValue("facility_id") ;
	
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" src="../js/NoteForExternalDrugProfile.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="" onKeyDown="lockKey()">
		<form name='NoteForExternalDrugheaderform' id='NoteForExternalDrugheaderform' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<table border="0" align="left" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr >
					<td  width="20%" class='label'>       
					<fmt:message key="Common.note.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/>
					</td>
					<td  width="50%"><input type='text' name='note_group_name' id='note_group_name' value='' size='50' maxlength='30' readonly>
					<input type="button" name="note_group_search" id="note_group_search" value="?" class="button" onfocus="searchNoteGroup(NoteForExternalDrugheaderform.note_group_name);" onClick="searchNoteGroup(NoteForExternalDrugheaderform.note_group_name);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
					<input type='hidden' value='' name='note_group_code' id='note_group_code'>
					</td>
					<td class="label" align=right ><center>&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' class='BUTTON' name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="popNoteTypeforGroup(document.NoteForExternalDrugheaderform.note_group_code);"  name="notefor_group_search">
				    </td>
					</tr>		
			</table>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	
		</form>
	</body>
</html>


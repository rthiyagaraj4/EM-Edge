<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>		
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	
		<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
		<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onKeyDown='lockKey()'>
		<form name='RecPreviousNotesToolbarForm' id='RecPreviousNotesToolbarForm'>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
				<tr>
					<td align='right'>
						<input type="button" class="BUTTON" name="ok" id="ok" disabled onclick='movePreviousNotes()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'>
						<input type="button" class="BUTTON" name="close" id="close" onclick='window.close()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'>
						<input type="hidden" name="accession_num" id="accession_num" value=""/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


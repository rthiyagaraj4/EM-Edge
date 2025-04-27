<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import=" java.sql.*,java.util.*,java.text.*,webbeans.eCommon.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
		<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
		<%
		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language="javascript" src="../../eFM/js/QueryLocnWise.js"></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/DTDocumentNumberLookup.js'></SCRIPT>
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</HEAD>
	<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
		<FORM>
			<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
				<TR><TD colspan='2'>&nbsp;</TD></TR> 
				<TR>
					<TD class='label' width='20%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
					<TD class='fields' width='80%' ><input type="text" maxlength="15" size="18" name="document_type" id="document_type"  onChange="docTypeLookup(this.value);"><input type='button' class='button' name='doc_fold_search' id='doc_fold_search' value='?' align=center onClick='docTypeLookup(document_type.value);'><img src='../../eCommon/images/mandatory.gif' align='center'></img></TD>
				</TR>
				<TR>
					<TD class='button' colspan='2' ><INPUT type='button' class='button' name='Search' id='Search' value='Search' onClick='fetchData()' disabled>&nbsp;<INPUT type='button' class='button' name='Clear' id='Clear' value='Clear' onClick='clearData()'></TD>
				</TR>
				<TR><TD colspan='2'>&nbsp;</TD></TR> 
			<TABLE>
			<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='center' id='tab1' style="visibility:hidden">
				<TR>
					<Td class='columnheader' width='20%'><fmt:message key="eFM.FolderName.label" bundle="${fm_labels}"/></Td>
					<Td class='columnheader' width='25%'><fmt:message key="eFM.PeriodSpecific.label" bundle="${fm_labels}"/></Td>
					<Td class='columnheader' width='20%'><fmt:message key="Common.PatientSpecific.label" bundle="${common_labels}"/></Td>
					<Td class='columnheader' width='25%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></Td>
					<Td class='columnheader' width='10%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></Td>
				</TR>
			</TABLE>
			<INPUT type='hidden' name='doc_type_code' id='doc_type_code' value=''>
		</FORM>
	</BODY>
</HTML>


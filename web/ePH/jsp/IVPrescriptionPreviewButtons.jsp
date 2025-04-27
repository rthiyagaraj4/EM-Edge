<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"   %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <HTML>
	<HEAD>
 <%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<FORM name="formIVPrescriptionPreviewButtons" id="formIVPrescriptionPreviewButtons">
			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TR>
					<TD CLASS="white" align="right">
					<input type="button"   class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_rx" onclick="toCloseTopShowModal('R');"></input> <!--added for ML-BRU-SCF-0533 [IN:036030] -->
					&nbsp;&nbsp;&nbsp;
					<INPUT TYPE="button" CLASS="button" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="toCloseTopShowModal();"></TD>
				</TR>
			</TABLE>
		</FORM>
	</BODY>
</HTML>


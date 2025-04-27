<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String showButtons	= request.getParameter("showButtons") == null ? "":request.getParameter("showButtons");
	

	String patient_id	= request.getParameter("patient_id") == null ? "":request.getParameter("patient_id");
	String encounter_id	= request.getParameter("encounter_id") == null ? "":request.getParameter("encounter_id");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	
	String or_mode	=	 bean.getOrMode();

%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<FORM name="formIVPrescriptionDrugDetailButtons" id="formIVPrescriptionDrugDetailButtons">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>

<%
	if (showButtons.equals("Y")) {
		String limit_ind	= request.getParameter("limit_ind");
		String allergy_yn	= request.getParameter("allergy_yn");
		String current_rx	= request.getParameter("current_rx");
		if (limit_ind.equals("N") || allergy_yn.equals("Y") || current_rx.equals("Y")) {
%>

		<TD WIDTH="20%"  NOWRAP><input type="button" class="button" name="OVERRIDE_LINK" id="OVERRIDE_LINK"  onClick="showOverRideRemarks()" value="Override Reason"></TD>
		<TD WIDTH="5%">&nbsp;</TD>

<%
		}
		else {
%>

		<TD WIDTH="25%">&nbsp;</TD>

<%
		}
%>
		<TD WIDTH="75%" ALIGN="right">
			<INPUT TYPE="button" CLASS="button" name="AMEND" id="AMEND" VALUE="Amend Drug" onClick="callAmendDrug()">
<%
		if(!or_mode.equals("amend")){
%>
			<INPUT TYPE="button" CLASS="button" name="CANCEL" id="CANCEL" VALUE="  Cancel  " onClick="callCancel()">
			<INPUT TYPE="button" CLASS="button" name="CLEAR" id="CLEAR" VALUE="  Clear  " onClick="callClear()">
<%
		}
%>
		</TD>
<%
	}
	else {
%>
		<TD HEIGHT="20">&nbsp;</TD>
<%
	}
%>

	</TR>
	</TABLE>
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>


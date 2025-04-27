<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");

	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/DrugClassForOrderType.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
	function closew(){
		const dialogTag = parent.document.getElementById("dialog_tag"); 
		dialogTag.close();
	}
	</script>

	<TITLE><fmt:message key="ePH.OrderTypeDetails.label" bundle="${ph_labels}"/></TITLE>
	
</HEAD>


<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" STYLE="overflow-y:hidden">

<%
	String ordertypecode	= request.getParameter( "code" ) ;
	String bean_id 			= "DrugClassForOrderTypeBean" ;
	String bean_name 		= "ePH.DrugClassForOrderTypeBean";

	/* Initialize Function specific start */
	DrugClassForOrderTypeBean bean = (DrugClassForOrderTypeBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	ArrayList orderTypeDetails = new ArrayList() ;
	orderTypeDetails = bean.getOrderTypeDetails(ordertypecode) ;
	/* Initialize Function specific end */
%>

	<FORM name="formUomForEqvl" id="formUomForEqvl" ><BR>
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="0">

		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD WIDTH="40%" CLASS="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TD>
			<TD  WIDTH="60%" CLASS="label">&nbsp;<B><%= orderTypeDetails.get(0) %></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  WIDTH="40%" CLASS="label"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></TD>
			<TD  WIDTH="60%" CLASS="label">&nbsp;<B><%= orderTypeDetails.get(1) %></B></TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD WIDTH="40%" CLASS="label"><fmt:message key="ePH.ApplicableFrequency.label" bundle="${ph_labels}"/></TD>
			<TD WIDTH="60%" CLASS="label">&nbsp;

<%
		if ((orderTypeDetails.get(2).toString()).equalsIgnoreCase("Y")) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"'></IMG>

<%
		}
		else if ((orderTypeDetails.get(2).toString()).equalsIgnoreCase("N")) {
%>

				<IMG SRC="../../eCommon/images/disabled.gif"'></IMG>

<%
		}
%>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  WIDTH="40%" CLASS="label"><fmt:message key="Common.SoftStop.label" bundle="${common_labels}"/></TD>
			<TD  WIDTH="60%" CLASS="label">&nbsp;

<%
		if ((orderTypeDetails.get(3).toString()).equalsIgnoreCase("Y")) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"'></IMG>

<%
		}
		else if ((orderTypeDetails.get(3).toString()).equalsIgnoreCase("N")) {
%>

				<IMG SRC="../../eCommon/images/disabled.gif"'></IMG>

<%
		}
%>

			</TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  WIDTH="40%" CLASS="label"><fmt:message key="ePH.ContinuousOrder.label" bundle="${ph_labels}"/></TD>
			<TD  WIDTH="60%" CLASS="label">&nbsp;

<%
		if ((orderTypeDetails.get(4).toString()).equalsIgnoreCase("Y")) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"'></IMG>

<%
		}
		else if ((orderTypeDetails.get(4).toString()).equalsIgnoreCase("N")) {
%>

				<IMG SRC="../../eCommon/images/disabled.gif"'></IMG>

<%
		}
%>

			</TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  WIDTH="40%" CLASS="label"><fmt:message key="ePH.PINApplicableonOrder.label" bundle="${ph_labels}"/></TD>
			<TD WIDTH="60%" CLASS="label">&nbsp;

<%
		if ((orderTypeDetails.get(5).toString()).equalsIgnoreCase("A")) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"'></IMG>

<%
		}
		else {
%>

				<IMG SRC="../../eCommon/images/disabled.gif"'></IMG>

<%
		}
%>

			</TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  WIDTH="40%" CLASS="label"><fmt:message key="ePH.PINApplicableonResult.label" bundle="${ph_labels}"/></TD>
			<TD WIDTH="60%" CLASS="label">&nbsp;

<%
		if ((orderTypeDetails.get(6).toString()).equalsIgnoreCase("A")) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"'></IMG>

<%
		}
		else {
%>

				<IMG SRC="../../eCommon/images/disabled.gif"'></IMG>

<%
		}
%>

			</TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		<TR>
			<TD  WIDTH="40%" CLASS="label"><fmt:message key="ePH.RegistrationRequired.label" bundle="${ph_labels}"/></TD>
			<TD  WIDTH="60%" CLASS="label">&nbsp;

<%
		if ((orderTypeDetails.get(7).toString()).equalsIgnoreCase("Y")) {
%>

				<IMG SRC="../../eCommon/images/enabled.gif"'></IMG>

<%
		}
		else if ((orderTypeDetails.get(7).toString()).equalsIgnoreCase("N")) {
%>

				<IMG SRC="../../eCommon/images/disabled.gif"'></IMG>

<%
		}
%>

			</TD>
		</TR>
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		
		<TR>
			<TD COLSPAN="2">&nbsp;</TD>
		</TR>
		</TABLE><BR>
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="0">
		<TR>
			<TD CLASS="WHITE" COLSPAN="2" align='right' ><INPUT TYPE="button" CLASS="button" name="closebtn" id="closebtn" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="toCloseTopShowModal()"></TD>
		</TR>
		</TABLE>
</FORM>
</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
%>


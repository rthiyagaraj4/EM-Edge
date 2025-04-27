<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>

	<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<!-- import the calendar script -->
	<SCRIPT language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
	
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<FORM name="formTDMAtrributesTitle" id="formTDMAtrributesTitle">
<TABLE border="1" cellpadding="0" cellspacing="0" width="98%" align="left">
		<TH  style="width:50%" align="left"><fmt:message key="ePH.SamplingTypes.label" bundle="${ph_labels}"/></TH>
		<TH style="width:25%"><fmt:message key="ePH.SamplingTime.label" bundle="${ph_labels}"/></TH>
		<TH style="width:25%"><fmt:message key="ePH.LaboratoryOrders.label" bundle="${ph_labels}"/></TH>	
</TABLE>

</FORM>
</BODY>
</HTML>


<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PendingOrderHdr" id="PendingOrderHdr" method="POST" >
<table  border='1' width='98%' cellpadding="3" cellspacing=0>
<%
String flag=request.getParameter("flag");
if(flag==null) flag="";
if(flag.equals("pending_orders"))
{%>
	<tr>
		<th  class="columnHeader" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
		<th  class="columnHeader" nowrap><fmt:message key="Common.speciality.label"  bundle="${common_labels}"/></th>
	</tr>
<%}else{%>
	<tr>
		<th  class="columnHeader" nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class="columnHeader" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.name.label"  bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key= "Common.Procedure.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="eOT.SurgeryDate.Label" bundle="${ot_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="eOT.AnaesthesiaOrderedDate.Label" bundle="${ot_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
		<th class="columnHeader"  nowrap><fmt:message key="Common.speciality.label"  bundle="${common_labels}"/></th>
	</tr>
<%}%>
</table>
</form>
</body>
</html>


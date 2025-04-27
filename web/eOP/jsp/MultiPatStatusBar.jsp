<!DOCTYPE html>
<!--
			Megenta 	- Routine
			Red	- Emergency
			Yellow	- No Show
			Blue	- Appt Confirmed
			White	- Appt UnConfirmed
			Green	- On Time
			Brown	- Late

-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown = 'lockKey();'>
	
<table border='1' width=100%>
<tr>
<td nowrap>
	<b><font size=1><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/>
</td>

<td  align='left'  width='2%'  class='black'><b><font size=1><fmt:message key="Common.in.label" bundle="${common_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="eOP.CheckedIn.label" bundle="${op_labels}"/>
</td>
<!-- <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/> -->
<td  align='left'  width='2%'  class='black'><b><font size=1><fmt:message key="eOP.NS.label" bundle="${op_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="eOP.arrived.label" bundle="${op_labels}"/>
</td>

<td  align='left' width='2%'  class='black'><b><font size=1><fmt:message key="eOP.VS.label" bundle="${op_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="eOP.VitalSignRecorded.label" bundle="${op_labels}"/>
</td>

<td  align='left' ' width='2%'  class='black'><b><font size=1><fmt:message key="eOP.PR.label" bundle="${op_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="eOP.ConsultationInProgress.label" bundle="${op_labels}"/>
</td>

<td  align='left'  width='2%'  class='black'><b><font size=1><fmt:message key="eOP.TR.label" bundle="${op_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="Common.Treat/Invest.label" bundle="${common_labels}"/>
</td>

<td  align='left'  width='2%'  class='black'><b><font size=1><fmt:message key="eOP.WT.label" bundle="${op_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="eOP.RetFrmInvest.label" bundle="${op_labels}"/>
</td>
<td  align='left'  width='2%'  class='black'><b><font size=1><fmt:message key="eOP.XT.label" bundle="${op_labels}"/></td>
<td  align='left' class='oalabel' nowrap><font size=1><fmt:message key="Common.CheckedOut.label" bundle="${common_labels}"/>
</td>

</tr>
</table>
</body>

</html>


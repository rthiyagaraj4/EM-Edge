<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page  contentType="text/html;charset=UTF-8" %>

<!--
			Megenta 	- Routine
			Red	- Emergency
			Yellow	- No Show
			Blue	- Appt Confirmed
			White	- Appt UnConfirmed
			Green	- On Time
			Brown	- Late
-->
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey();'>
<table border='1' width=100%>
<tr>
<td  align='left' class='PATQRED' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'><font size=1>
 &nbsp;<fmt:message key="Common.emergency.label" bundle="${common_labels}"/>&nbsp;&nbsp;
</td>

<td  align='left' width='2%'  class='black' nowrap><font size=1><b><fmt:message key="eOP.apptstatus.label" bundle="${op_labels}"/></td>

<td  align='left' class='blue' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'><font size=1>
&nbsp;<fmt:message key="eOP.ApptStatusYettoCome.label" bundle="${op_labels}"/>
</td>

<td  align='left' class='RED' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'>
&nbsp;<fmt:message key="eOP.ApptStatusEarly.label" bundle="${op_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td  align='left' class='green' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'><font size=1>
&nbsp;<fmt:message key="eOP.AppStatusOnTime.label" bundle="${op_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td  align='left' class='brown' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'><font size=1>
 &nbsp;<fmt:message key="eOP.ApptStatusLate.label" bundle="${op_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>

<td  align='left' class='yellow' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'><font size=1>
&nbsp;<fmt:message key="Common.noshow.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
</td>



<!--<td  align='left' class='white' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'>
&nbsp; Appt UnConfirmed
</td>

<td  align='left' class='brown' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel'>
 &nbsp;Late&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>-->
</tr>
</table>
</body>

</html>


<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border='1' width='100%'>
<tr>

<td  align='left' class='oalabel' ><font size=1>
<b> Normal Beds </b>
</td>

<td  align='left' class='GREEN' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
&nbsp;<fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;
</td>

<td  align='left' class='PATQRED' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
 &nbsp;<fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;
</td>

<td  align='left' class='oalabel' ><font size=1>
<b> <fmt:message key="eAE.PseudoBeds.label" bundle="${ae_labels}"/> </b>
</td>

<td  align='left' style='background-color:LIGHTGREEN;' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
&nbsp;<fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;
</td>

<td  align='left' style='background-color:LIGHTPINK;' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
 &nbsp;<fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;
</td>

<td  align='left' class='oalabel' ><font size=1>
<b><fmt:message key="Common.others.label" bundle="${common_labels}"/></b>
</td>

<td  align='left' class='BROWN' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
 &nbsp;<fmt:message key="Common.Reserved.label" bundle="${common_labels}"/>&nbsp;
</td>

</tr>
</table>
</html>


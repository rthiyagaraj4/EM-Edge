<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	      	request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border='1' width='100%'>
<tr>
<td  align='left' style='background-color:LIGHTGREEN;' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
&nbsp;<fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;
</td>

<td  align='left' style='background-color:LIGHTPINK;' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
 &nbsp;<fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;
</td>

<td  align='left' style='background-color:Brown;' width='2%'>&nbsp;</td>
<td  align='left' class='oalabel' ><font size=1>
 &nbsp;<fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;
</td>

</tr>
</table>
</html>


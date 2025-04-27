<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<!--
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<table border='1' width='100%'>
			<tr>
				<td class=LABEL><fmt:message key="eMR.Hypersensitivity.label" bundle="${mr_labels}"/> :</td>
				<td  class=MRALLERGY><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/></td>
				<td  class=MRHYPERII><fmt:message key="eMR.TypeII.label" bundle="${mr_labels}"/></td>
				<td class=MRHEADER><fmt:message key="eMR.TypeIII.label" bundle="${mr_labels}"/></td>
				<td  class=ORBROWN><fmt:message key="eMR.TypeIV.label" bundle="${mr_labels}"/></td>
				<td  class=LABEL><fmt:message key="eMR.Recurrence.label" bundle="${mr_labels}"/> :</td>
				<td  class=OALINK><img  src="../../eCommon/images/mandatory.gif" align='center'></img></td>
			</tr>
		</table>
	</body>

</html>-->


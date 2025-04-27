<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eOH/js/OHDiagLinkConditions.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form>
			<table align='center' cellpadding='3' cellspacing='0' border='1' width='100%'>
				<tr>
					<td class="CAGROUPHEADING" width="15%" nowrap><fmt:message key="eOH.ConditionType.Label" bundle="${oh_labels}"/></td>
					<td class="CAGROUPHEADING" width="15%" nowrap><fmt:message key="eOH.Condition.Label" bundle="${oh_labels}"/></td>
					<td class="CAGROUPHEADING" width="15%" nowrap><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
					<td class="CAGROUPHEADING" width="15%" nowrap><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
					<td class="CAGROUPHEADING" width="15%" nowrap><fmt:message key="eOH.Surface.Label" bundle="${oh_labels}"/></td>
					<td class="CAGROUPHEADING" width="15%" nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> 
					<!-- <br> -->
					<input type='checkbox' name='chkAll' id='chkAll' onClick='selectAll(this)'></td>
				</tr>
			</table>
		</form>
		
	</body>
</html>
	


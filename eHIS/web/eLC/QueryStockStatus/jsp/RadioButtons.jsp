<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<html>
	<head>
		<%			
			String locale = (String)session.getAttribute("LOCALE");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
		%>
	<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/QueryStockStatus/js/QueryStockStatus.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' /></head>
<body onload="getLinen(this);" >
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr>
			<td align="right" class="label">
				<ibaBean:message key="com.iba.ehis.lc.bySource" bundle="lcLabels" />
					<input type="Radio" name="Suballocator" id="Suballocator" value="Yes" onclick="getStock(this);" checked>
				</td>
			<td align="right" class="label">
				<ibaBean:message key="com.iba.ehis.lc.byLinenItem" bundle="lcLabels" />
					<input type="Radio" name="Suballocator" id="Suballocator" value="Yes" onclick="getLinen(this);" checked>
				</td>
			</tr>
		</table>
	</body>
</html>


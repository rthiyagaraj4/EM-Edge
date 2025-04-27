<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		<html>
		<head>
<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language='javascript' src='../../eST/js/GenerateRequest.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		</head>

<form name='formGenerateRequesthtml' id='formGenerateRequesthtml' method='post'>
		
		<table name ="tblItemStore" id="tblItemStore" border='1' cellpadding='1' cellspacing='1' width='98%' height = '9%'>
		
 			<tr>
				<td class='COLUMNHEADER' width="1%"  >
				<fmt:message key="eST.S.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADER' width="1%"  >
				<fmt:message key="Common.item.label" bundle="${common_labels}"/><BR><input type="checkbox" value="Y" name="checkAll" id="checkAll" disabled onClick="return toggleCheck(this);"></td>
				<td class='COLUMNHEADERCENTER'  width="19%"  >
				<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'  width="5%" >&nbsp;&nbsp;
				<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
				<td class='COLUMNHEADERCENTER'  width="8%" >
				<fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='COLUMNHEADERCENTER'   width="7%" >
				<fmt:message key="eST.MaxStockQuantity.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADER'  width="5%"  >&nbsp;&nbsp;
				<fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>

				<td class='COLUMNHEADERCENTER'  width = "8%"><fmt:message key="eST.ROQty.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="8%" ><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="7%" ><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="8%" ><fmt:message key="eST.RequestedUOM.label" bundle="${st_labels}"/></td>
				<td class='COLUMNHEADERCENTER'  width="8%" ><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
			</tr>
			

		<table>
</form>

</html>


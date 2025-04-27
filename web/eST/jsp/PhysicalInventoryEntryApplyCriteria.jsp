<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page import="eST.PhysicalInventoryEntryBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onLoad='FocusFirstElement();'>
	<%
		String bean_id = "PhysicalInventoryEntryBean";
		String bean_name = "eST.PhysicalInventoryEntryBean";
		
		String store_code =	request.getParameter("store_code");
		String item_code = request.getParameter("item_code");
		String phy_inv_id = request.getParameter("phy_inv_id").trim();

		String store_desc =	request.getParameter("store_desc");
		String item_desc = request.getParameter("item_desc");

		String disabled = "disabled";
		PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean)getBeanObject( bean_id, bean_name,request);  
		bean.setLanguageId(locale);
		bean.clear();
		bean.setPhy_inv_id(phy_inv_id);

		/*if(store_code!=null){
			bean.setStore_code(store_code);
			bean.setStore_code_list(current_store_code);
		}*/
	%>
		<form name="formPhysicalInventoryEntryApplyCriteria" id="formPhysicalInventoryEntryApplyCriteria" action="../../eST/jsp/PhyInvEntryTrayQueryResult.jsp" method="post" target="framePhysicalInventoryEntryApplyResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%'  align=center>
				<tr>
					<td  class="label"><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
					<td class="fields">&nbsp;<input name="phy_inv_id" id="phy_inv_id" maxLength='15' size='15' readOnly value="<%=phy_inv_id%>" <%=disabled%>></td>
					<td  class="label"><fmt:message key="Common.CountSheetDate.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;<input name="count_date" id="count_date" maxLength='10' size='10' readOnly value="<%=com.ehis.util.DateUtils.convertDate((String)bean.getCountsheetDate(),"DMY","en",locale)%>"  <%=disabled%>></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;<input name="store_desc" id="store_desc" maxLength='15' size='15' readOnly value="<%=store_desc%>" <%=disabled%>></td>
					<td  class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;<input name="item_desc" id="item_desc" maxLength='40' size='40' readOnly value="<%=item_desc%>"  <%=disabled%>></td>
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=" dtl.bin_location_code, dtl.group_code, tray_no">
			<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
			<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<input type="hidden" name="total_rec" id="total_rec" value="">
			<input type="hidden" name="checkBoxVals" id="checkBoxVals" value="">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="ST">
			<input type="hidden" name="mode" id="mode" value="<%=eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")%>">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


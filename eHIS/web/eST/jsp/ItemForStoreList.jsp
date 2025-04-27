<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603		Badmavathi B							GHL-CRF-0456
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172

---------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import=" eST.ItemForStoreBean,eST.ItemForStoreDetail,eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<!--<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>  -->
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script>-->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/ItemForStore.js"></script>
	<!--<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
	<%


		String bean_id						=			"itemForStoreBean";
		String bean_name					=			"eST.ItemForStoreBean";
		String checked						=			"checked";
		String disabled						=			"";
		String className					=			"";
		ArrayList alItemKeys				=			null;
		ArrayList duplicateValues			=			null;
		HashMap hmItemStore					=			null;
		String mode							=			request.getParameter("mode");
		String function_id					=			request.getParameter("function_id");
		String itemStoreKey					=			"";
		ItemForStoreBean itemForStoreBean	=			(ItemForStoreBean) getBeanObject( bean_id,bean_name, request  );  
		itemForStoreBean.setLanguageId(locale);
		alItemKeys							=			itemForStoreBean.getItemStoreKeys();
		hmItemStore							=			itemForStoreBean.getHmItemStore();
		duplicateValues						=			itemForStoreBean.getDuplicateValues();
		itemForStoreBean.setLanguageId(locale);
		//boolean searched					=			itemForStoreBean.isSearched();
		int i								=			0;
		 	
		%>    
	<body onMouseDown='CodeArrest();'>
		<form name='formItemForStoreList' id='formItemForStoreList'>
			<table name ="tblItemStore" id="tblItemStore" width="100%" border='1' cellpadding='0' cellspacing='0'  align=center>
 			<tr>
				<th width='5' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				<th width='120' ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				<th width='300' style="WORD-BREAK:BREAK-ALL;" ><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.ROQty.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.RFDays.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.Sales/PatientIssues.label" bundle="${st_labels}"/></th> <!-- Added for GHL-CRF-0456  -->
				<th nowrap><fmt:message key="eST.InternalConsumption.label" bundle="${st_labels}"/></th> <!-- Added for GHL-CRF-0456  -->
				 <!-- MO-CRF-20172  -->
				<th nowrap><fmt:message key="eST.NoOfDaysFromPrevReq.label" bundle="${st_labels}"/></th> 				
			</tr>
			<%
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize = alItemKeys.size();
					ItemForStoreDetail itemForStoreDetail;
					for (i=0;	i<totalSize;	i++){
						itemStoreKey		=		(String) alItemKeys.get(i);
						if (duplicateValues != null && duplicateValues.contains(itemStoreKey)) {
							disabled		=		"disabled";
						}
						else {
							disabled		=		"";
						}
						itemForStoreDetail = (ItemForStoreDetail) hmItemStore.get(itemStoreKey);
						if (itemForStoreDetail != null) {
						className			=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
				%>
				<tr>
					<td class="<%=className%>"  nowrap ><input type='checkbox' name="remove_<%=i%>" id="remove_<%=i%>" value="<%=itemStoreKey%>" <%=disabled%> <%=checked%>></td>
					<td class="<%=className%>"  nowrap  onClick="displayItemForStoreDtls(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=itemForStoreDetail.getStore_desc()%></font></td>
					<td class="<%=className%>"  style="WORD-BREAK:BREAK-ALL;" ><%=itemForStoreDetail.getItem_desc()%></td>
					<td class="<%=className%>"  nowrap ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getBin_location_desc(),"&nbsp;")%></td>
					<td class="<%=className%>"  nowrap ><%=itemForStoreBean.getImage(itemForStoreDetail.getStock_item_yn())%></td>
					<!--
					
						* @Name - Priya
						* @Date - 19/02/2010
						* @Inc# - IN019466
						* @Desc - To right align Min Stock, Max Stock, RO Level, RO Qty, RF Days .
										
					-->
					<td class="<%=className%>"  nowrap style="TEXT-ALIGN:right" ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getMin_stock_qty(),"&nbsp;")%>&nbsp;</td>
					<td class="<%=className%>"  nowrap style="TEXT-ALIGN:right" ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getMax_stock_qty(),"&nbsp;")%>&nbsp;</td>
					<td class="<%=className%>"  nowrap style="TEXT-ALIGN:right" ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getReorder_level(),"&nbsp;")%>&nbsp;</td>
					<td class="<%=className%>"  nowrap style="TEXT-ALIGN:right" ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getReorderqty(),"&nbsp;")%>&nbsp;</td>
					<td class="<%=className%>"  nowrap style="TEXT-ALIGN:right" ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getReorder_freq_days(),"&nbsp;")%>&nbsp;</td>
					 <!-- Added for GHL-CRF-0456  starts-->
					<% 
					if(itemForStoreDetail.getSales_allowed_yn()==null && itemForStoreDetail.getConsumption_allowed_yn()==null){
					if(itemForStoreBean.isSalesAllowed(itemForStoreDetail.getItem_code())) {
						itemForStoreDetail.setSales_allowed_yn("N");
					}	else
						itemForStoreDetail.setSales_allowed_yn("Y");
					itemForStoreDetail.setConsumption_allowed_yn("Y"); 
					}
						%>
					<td class="<%=className%>"  nowrap ><%=itemForStoreBean.getImage(itemForStoreDetail.getSales_allowed_yn())%></td>
					<td class="<%=className%>"  nowrap ><%=itemForStoreBean.getImage(itemForStoreDetail.getConsumption_allowed_yn())%></td>
					<!-- MO-CRF-20172 -->
					<td class="<%=className%>"  nowrap ><%=itemForStoreBean.checkForNull(itemForStoreDetail.getNo_of_days())%>&nbsp;</td>
					 <!-- Added for GHL-CRF-0456 ends -->
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>"			value="<%=itemForStoreDetail.getItem_code()%>">
					<input type="hidden" name="store_code_<%=i%>" id="store_code_<%=i%>"			value="<%=itemForStoreDetail.getStore_code()%>">
					<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>"	value="<%=itemForStoreBean.checkForNull(itemForStoreDetail.getBin_location_code(),"")%>">
				<%
					}
				}
			}
			else {
				 if (itemForStoreBean.isSearched()) {
			%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			</script>
			<%
					itemForStoreBean.setSearched (false);
				 }
			}
			%>
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
		</form>
<%
	putObjectInBean(bean_id,itemForStoreBean,request);
%>
	</body>
</html>


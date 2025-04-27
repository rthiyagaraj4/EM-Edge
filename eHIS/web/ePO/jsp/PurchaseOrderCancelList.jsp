<!DOCTYPE html>
 <%@ page import="ePO.PurchaseOrderCancelBean, ePO.PurchaseOrderCancelDetailBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
<%
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
 	    <script language="JavaScript" src="../../ePO/js/PurchaseOrderCancel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePO.POItemDetails.label" bundle="${po_labels}"/></title>
	</head>
	<%
		String bean_id				=			"PurchaseOrderCancelBean";
		String bean_name			=			"ePO.PurchaseOrderCancelBean";
		String mode					=			request.getParameter("mode");
		String function_id			=			request.getParameter("function_id");
		String className			=			"";
		PurchaseOrderCancelBean bean	=			(PurchaseOrderCancelBean) getBeanObject(bean_id,bean_name,request);  
		String po_order_mode		=			request.getParameter("po_order_mode");
		 po_order_mode              = po_order_mode.trim();
		String po_no				=			request.getParameter("po_no");

		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String facilityid=(String)session.getValue("facility_id");
		 
		
         //if(po_order_mode.equals("D")){
		//bean.loadData(po_order_mode, po_no,"*A");
		//}else{
		bean.loadData(po_order_mode, po_no,facilityid);
		//}
		bean.setLanguageId(locale);
		java.util.ArrayList alItems =		bean.getAlItems();
		int i=0;
	

	int no_of_decimals						=			bean.getNoOfDecimals();
	int no_of_decimals_temp					=			bean.getNoOfDecimals();
	%>
	<body >
		<form name='formSTPOCancelOrderList' id='formSTPOCancelOrderList'>
			<br>
		
		<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' align=center>
 			<tr style='position:relative'style='top:expression(this.offsetParent.scrollTop-2)'>
				<th width="25%" style="WORD-BREAK:BREAK-ALL;">Item</th>
				<th><fmt:message key="ePO.OrderQty.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.OrderUOM.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.DeliveredQty.label" bundle="${po_labels}"/></th>
				<!--<th><fmt:message key="ePO.PendDeliveredQty.label" bundle="${po_labels}"/></th>-->
				<th><fmt:message key="ePO.DeliveryUOM.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.ReceivedQty.label" bundle="${po_labels}"/></th>
				<th><fmt:message key="ePO.ReceivedUOM.label" bundle="${po_labels}"/></th>
				
			</tr>
			<%
				if (alItems != null && (alItems.size()>0)) {
					int totalSize = alItems.size();
					PurchaseOrderCancelDetailBean detailBean;
					for (i=0;	i<totalSize;	i++){
						detailBean = (PurchaseOrderCancelDetailBean) alItems.get(i);
						System.out.println("detailBean===list====>" +detailBean);
						if (detailBean != null) {
						className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
					if(bean.getAllowDecimalsYN((String)detailBean.getItem_code()).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals					=			no_of_decimals_temp;
					}
					HashMap hmRecord  =	new HashMap();
					String uom_code = bean.checkForNull(detailBean.getPo_Uom());
					String uom_desc = "";
					hmRecord = bean.getUomDesc(uom_code);
					if(hmRecord.size()>0){
						uom_desc = (String)hmRecord.get("SHORT_DESC");
					}
					String recd_uom_code = bean.checkForNull(detailBean.getReceived_uom());
					String recd_uom_desc = "";
					hmRecord = bean.getUomDesc(recd_uom_code);
					if(hmRecord.size()>0){
						recd_uom_desc = (String)hmRecord.get("SHORT_DESC");
					}
				%>
				<tr>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" ><%=detailBean.getItem_desc()%></td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.setNumber(bean.checkForNull(detailBean.getPo_qty(),"0"),no_of_decimals)%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=uom_desc%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.setNumber(bean.checkForNull(detailBean.getDo_qty(),"0"),no_of_decimals)%>&nbsp;</td>
					<!--<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.setNumber(bean.checkForNull(detailBean.getPending_qty(),"0"),no_of_decimals)%>&nbsp;</td>-->
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=uom_desc%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=bean.setNumber(bean.checkForNull(detailBean.getReceived_qty(),"0"),no_of_decimals)%>&nbsp;</td>
					<td class="<%=className%>" nowrap style="TEXT-ALIGN:right"> <%=recd_uom_desc%>&nbsp;</td>
		           
				</tr>
				<%
					}
				}
			}
			%>
			</table>
			<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


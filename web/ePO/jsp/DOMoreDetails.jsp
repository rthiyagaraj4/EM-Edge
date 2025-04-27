<!DOCTYPE html>
<%@ page import="ePO.DeliveryOrderBean, ePO.DeliveryOrderDetailBean,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<html>
	<head>
		<title><fmt:message key="eST.PurchaseOrderDetails.label" bundle="${st_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			=   (String)session.getAttribute("LOCALE");
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="javascript" src="../../ePO/js/DeliveryOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		DeliveryOrderDetailBean requestDetail;
		String bean_id							=				request.getParameter("bean_id");
		String bean_name						=				request.getParameter("bean_name");
		String mode								=				request.getParameter("mode");
		String po_no							=				request.getParameter("po_no");
		String item_code						=				request.getParameter("item_code");
		String delv_dt						=				request.getParameter("delv_date");
		String request_no						=				request.getParameter("request_no");
		java.util.ArrayList alItemKeys  =		new java.util.ArrayList();
		String req_code = "";
		String store_code = "";
		String store_name = "";
		String uom_desc = "";
		String item_desc = "";
		String delv_date = "";
		String order_qty = "";
		int totalSize=0;

		DeliveryOrderBean bean			=		(DeliveryOrderBean) getBeanObject(bean_id,bean_name, request  );  
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		String supp_code				=		bean.checkForNull(request.getParameter("supp_code"));
		String currency_code			=		bean.checkForNull(request.getParameter("currency_code"));
		
		for(int i=0;i<bean.getItemKeys().size();i++) {
			alItemKeys.add(bean.getItemKeys().get(i));	
		} 
		System.out.println("bean.getItemKeys() = "+bean.getItemKeys());
		for(int i=0;i<bean.getReqKeys().size();i++) {
			if(!alItemKeys.contains(bean.getReqKeys().get(i)))
			alItemKeys.add(bean.getReqKeys().get(i));	
		}
		System.out.println("bean.getReqKeys() = "+bean.getReqKeys());
		java.util.ArrayList newKeys = bean.getItemKeysAdded();

		if (newKeys != null && newKeys.size() >0) {
			alItemKeys.addAll(newKeys);
		}
		
							
	%>
<body>
	<form name='formDOMoreDetails' id='formDOMoreDetails'>

		
	<table border='0' cellpadding='2' cellspacing='0' width='90%' align=center scrolling=yes>
	
		<tr>
			<th align=left><fmt:message key="ePO.Item.label" bundle="${po_labels}"/></th>
			<th align=left><fmt:message key="ePO.PONo.label" bundle="${po_labels}"/></td></th>
			<th align=left><fmt:message key="ePO.ScheduledDate.label" bundle="${po_labels}"/></th>
			<th align=left><fmt:message key="ePO.Store.label" bundle="${po_labels}"/></th>
			<th align=left><fmt:message key="ePO.poQty.label" bundle="${po_labels}"/></td></th>
			<th align=left><fmt:message key="ePO.POUOM.label" bundle="${po_labels}"/></th>
			
		</tr>
		
<%	if (alItemKeys != null && (alItemKeys.size()>0)) {
						totalSize			=		alItemKeys.size();
						
					 ArrayList alList = new ArrayList();
					for (int i=0;	i<totalSize;	i++){
						requestDetail					=			bean.getItemDetail((String)alItemKeys.get(i));
						System.out.println("requestDetail in more dtl = "+requestDetail);
						
						if(po_no.equals(bean.checkForNull(requestDetail.getPo_no())) && item_code.equals(bean.checkForNull(requestDetail.getItem_code())) && delv_dt.equals(bean.checkForNull(requestDetail.getDelv_date())) && request_no.equals(bean.checkForNull(requestDetail.getRequest_no())) ){
								alList.add(bean.checkForNull(requestDetail.getPo_no()));
								alList.add(bean.checkForNull(requestDetail.getItem_desc()));
								alList.add(bean.checkForNull(requestDetail.getDelv_date()));
								alList.add(bean.checkForNull(requestDetail.getUomDesc()));
								alList.add(bean.checkForNull(requestDetail.getStore_code()));
								alList.add(bean.checkForNull(requestDetail.getOrder_qty()));
						}
					}					
					
					System.out.println("alList = "+alList);	
			
				for(int i=0;i<alList.size();i++){
					req_code = (String)alList.get(i);
					item_desc = (String)alList.get(++i);
					delv_date = (String)alList.get(++i);
					uom_desc = (String)alList.get(++i);
					store_code =	(String)alList.get(++i);
					order_qty = (String)alList.get(++i);
				
				
				if(store_code.equals("*A") || store_code.equals(""))
					store_name = "ALL";
				else{
				
					ArrayList alStoreList = new ArrayList();
					alStoreList.add(bean.getLanguageId());
					alStoreList.add(store_code);
					store_name = 	(String)bean.fetchRecord("SELECT STORE_CODE, SHORT_DESC FROM MM_STORE_LANG_VW  WHERE LANGUAGE_ID=?  AND STORE_CODE=?",alStoreList).get("SHORT_DESC");
				}
				
		
			
	%>
	
	

		<tr>
			<td align="right" class="label" ><%=item_desc%></td>
			<td align="right" class="label" ><%=req_code%></td>
			<td align="right" class="label" ><%=delv_date%></td>
			<td align="right" class="label" ><%=store_name%></td>
			<td align="right" class="label" ><%=order_qty%></td>
			<td align="right" class="label" ><%=uom_desc%></td>
		</tr>
		
		<%  } } %>		
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td align=right>
					<input type="button" class="button" name="Ok" id="Ok" value="Ok"  onClick="exitMoreDetails();"> 
				</td>
		</tr>
		
	</table>
 		
		
		<br>
		
			
			<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
			<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
			<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			<input type="hidden" 	name="total_Records" id="total_Records"		value="<%=totalSize %>">
			
			
			
						
		</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>




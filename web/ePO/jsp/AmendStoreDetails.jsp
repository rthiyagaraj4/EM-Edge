<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.StoreDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body >
<%
	AmendPurchaseOrderDetailBean requestDetail;
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String req_no							=				request.getParameter("req_no");
	String facility_code = "";
	String facility_name = "";
	String req_code = "";
	String store_code = "";
	String store_name = "";
	AmendPurchaseOrderBean bean					=				(AmendPurchaseOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date								=			bean.getSystemDate();
	int totalSize=0;
	java.util.ArrayList alItemKeys  =		new java.util.ArrayList();

	System.out.println("bean.getReqKeys() in Store Details = "+ bean.getReqKeys());
	
	
		for(int i=0;i<bean.getItemKeys().size();i++) {
			alItemKeys.add(bean.getItemKeys().get(i));	
		} 
	
		
		for(int i=0;i<bean.getReqKeys().size();i++) {
			alItemKeys.add(bean.getReqKeys().get(i));	
		}
		java.util.ArrayList newKeys = bean.getItemKeysAdded();

		if (newKeys != null && newKeys.size() >0) {
			alItemKeys.addAll(newKeys);
		}
				
%>
<form name="formStoreDetails" id="formStoreDetails">
	<table border='0' cellpadding='2' cellspacing='0' width='80%' align=center scrolling=yes>
	
<%	if (alItemKeys != null && (alItemKeys.size()>0)) {
						totalSize			=		alItemKeys.size();
						
					 ArrayList alList = new ArrayList();
					for (int i=0;	i<totalSize;	i++){
						requestDetail					=			bean.getItemDetail((String)alItemKeys.get(i));
						if(bean.checkForNull(requestDetail.getFacility_code()) == null || bean.checkForNull(requestDetail.getFacility_code()) == "" || bean.checkForNull(requestDetail.getFacility_code()).equals("*A") )  
						continue;
						if(req_no.equals(bean.checkForNull(requestDetail.getReq_no()))){
							alList.add(bean.checkForNull(requestDetail.getReq_no()));
							alList.add(bean.checkForNull(requestDetail.getFacility_code()));
							alList.add(bean.checkForNull(requestDetail.getStore_code()));
							}
					}					
					
					System.out.println("alList = "+alList);	
			
				for(int i=0;i<alList.size();i++){
					req_code = (String)alList.get(i);
					facility_code = (String)alList.get(++i);
					store_code =	(String)alList.get(++i);
				}
				ArrayList alFacList = new ArrayList();
				alFacList.add(bean.getLanguageId());
				alFacList.add(facility_code);
				facility_name = 	(String)bean.fetchRecord("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW  WHERE LANGUAGE_ID=?  AND FACILITY_ID=?",alFacList).get("FACILITY_NAME");
				
				ArrayList alStoreList = new ArrayList();
				alStoreList.add(bean.getLanguageId());
				alStoreList.add(store_code);
				store_name = 	(String)bean.fetchRecord("SELECT STORE_CODE, SHORT_DESC FROM MM_STORE_LANG_VW  WHERE LANGUAGE_ID=?  AND STORE_CODE=?",alStoreList).get("SHORT_DESC");
				
				
		}
			
	%>
	
		<tr>
			<th align=left><fmt:message key="ePO.RequestNo.label" bundle="${po_labels}"/></th>
		<!--	<th align=left><fmt:message key="ePO.StoreCode.label" bundle="${po_labels}"/></th>  -->
			<th align=left><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
		<!--	<th align=left><fmt:message key="ePO.FacilityCode.label" bundle="${po_labels}"/></th>  -->
			<th align=left><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
			
		</tr>
		<tr>
			<td align="right" class="label" ><%=req_code%></td>
			<% if(store_code != "" && store_code !=null ){ %>
				<td align="right" class="label" ><%=store_name%></td>
			<% } else {%>
				<td align="right" class="label" >All</td>
				
			<% } %>
			<% if(facility_code != "" && facility_code !=null ){ %>
				<td align="right" class="label" ><%=facility_name%></td>
			<% } else {%>
				<td align="right" class="label" >All</td>
			<% } %>
		</tr>
		
				
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td align=right>
					<input type="button" class="button" name="Ok" id="Ok" value="Ok"  onClick="exitStoreDetails();"> 
				</td>
		</tr>
	</table>
	<input type="hidden" 	name=sys_date				value="<%=sys_date%>">
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" 	name="total_Records" id="total_Records"		value="<%=totalSize %>">
	
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>


<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.DeliverToBillToDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/AmendPurchaseOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		//	function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body >
<%
	AmendPurchaseOrderDetailBean requestDetail;
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String bill_to							=				request.getParameter("bill_to");
	String deliver_to						=				request.getParameter("deliver_to");
	AmendPurchaseOrderBean bean					=				(AmendPurchaseOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date								=			bean.getSystemDate();
	int totalSize=0;
	java.util.ArrayList alItemKeys  =		new java.util.ArrayList();

	System.out.println("bean.getReqKeys() in bill to deliver to = "+ bean.getReqKeys());
	
	
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
		

		ArrayList alDelvRecords		= new ArrayList();
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
		alDelvRecords = bean.getBillToDeliverToData(bean.getDoc_no());
		System.out.println("alDelvRecords = "+alDelvRecords);
				
%>
<form name="formAmendBillToDeliverToDetails" id="formAmendBillToDeliverToDetails">
	<table border='0' cellpadding='2' cellspacing='0' width='80%' align=center scrolling=yes>
	
<%	if (alItemKeys != null && (alItemKeys.size()>0)) {
						totalSize			=		alItemKeys.size();
						String facility_code = "";
					HashMap hmList = new HashMap();
					for (int i=0;	i<totalSize;	i++){
						requestDetail					=			bean.getItemDetail((String)alItemKeys.get(i));
						if(bean.checkForNull(requestDetail.getFacility_code()) == null || bean.checkForNull(requestDetail.getFacility_code()) == "" || bean.checkForNull(requestDetail.getFacility_code()).equals("*A") )  
						continue;
						if(!hmList.containsValue(bean.checkForNull(requestDetail.getFacility_code())))
							hmList.put(bean.checkForNull(requestDetail.getReq_no()),bean.checkForNull(requestDetail.getFacility_code()));
					}	
					
					
						System.out.println("hmList = "+hmList);	
						int i=0;	
						Iterator it = hmList.entrySet().iterator();
						while (it.hasNext()) {
							i++;
							Map.Entry pairs = (Map.Entry)it.next();
							facility_code = (String)pairs.getValue();
						
						
						if(alDelvRecords != null && alDelvRecords.size() > 0  ){
							for(int j=0;j<alDelvRecords.size();j++){
							HashMap hm = (HashMap)alDelvRecords.get(j);
							if(facility_code.equals(bean.checkForNull((String)hm.get("FACILITY_CODE")))){
								facility_code = bean.checkForNull((String)hm.get("FACILITY_CODE"));
								bill_to = bean.checkForNull((String)hm.get("BILL_TO_ADDR"));
								deliver_to  = bean.checkForNull((String)hm.get("DELV_TO_ADDR"));
								System.out.println("facility = "+facility_code);
								System.out.println("bill_to = "+bill_to);
								System.out.println("deliver_to = "+deliver_to);
							}
							}
							}
							
						ArrayList alFacList = new ArrayList();
						alFacList.add(bean.getLanguageId());
						alFacList.add(facility_code);
						facility_code = 	(String)bean.fetchRecord("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW  WHERE LANGUAGE_ID=?  AND FACILITY_ID=?",alFacList).get("FACILITY_NAME");	
						
	%>
	
		<tr id="tr_<%=i%>">
			<th colspan=4 align=left><%=facility_code%></th>
			<input type="hidden" name="facility_code_<%=i%>" id="facility_code_<%=i%>" value="<%=facility_code%>">
			
			
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.DeliverTo.label" bundle="${po_labels}"/></td>
			<td>&nbsp;<textarea  name="deliver_to_<%=i%>"  rows='4' cols='40'onKeyPress="checkMaxLimit(this,100);" ><%=bean.checkForNull(deliver_to)%></textarea></td>
			
			<td align="right" class="label" ><fmt:message key="ePO.BillTo.label" bundle="${po_labels}"/></td>
			<td>&nbsp;<textarea  name="bill_to_<%=i%>"  rows='4' cols='40'onKeyPress="checkMaxLimit(this,100);" ><%=bean.checkForNull(bill_to)%></textarea></td>
		</tr>
	<%	
			
		}
		}
		%>				
				
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td align=right>
					<input type="button" class="button" name="Ok" id="Ok" value="Ok"  onClick="exitBillToDeliverDetails();">
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


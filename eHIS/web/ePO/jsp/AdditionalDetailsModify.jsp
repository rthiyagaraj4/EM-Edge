<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<title><fmt:message key="ePO.AdditionalDetails.label" bundle="${po_labels}"/></title>
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
			//function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body >
<%
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String supp_code						=				request.getParameter("supp_code");
	String po_mode							=				request.getParameter("po_mode");
	PurchaseOrderBean bean					=				(PurchaseOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date								=			bean.getSystemDate();

		if(mode.equals("1")){
			System.out.println("supp_code in List.jsp"+supp_code);
			supp_code= supp_code;
			po_mode = po_mode;
		} else if(mode.equals("2")){
		
				 supp_code= bean.getRequest_on_supp();
				 po_mode = bean.getPo_mode();
		}	
			
		String []stParameters =	{supp_code};	
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_SUPP_DTL_SELECT"), stParameters);
		System.out.println("hmRecord in jsp="+hmRecord);
		
		String acc_no=(String)hmRecord.get("ACC_NO");
		String supp_address1 = (String)hmRecord.get("ADD1_DESC");
		String supp_address2 = (String)hmRecord.get("ADD2_DESC");
		String supp_address3 = (String)hmRecord.get("ADD3_DESC");

		System.out.println("supp_address1="+supp_address1+" "+"supp_address2="+supp_address2+" "+"supp_address3="+supp_address3);
	

%>
<form name="formAdditionalDetails" id="formAdditionalDetails">
	<table border='0' cellpadding='2' cellspacing='0' width='80%' align=center scrolling=yes>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.QuotationNoTenderRef.label" bundle="${po_labels}"/></td>
			<td>&nbsp;<input type="text" value = "<%=bean.getQnt_ref()%>" name="qnt_ref" size='10' maxLength='10' ></td>
			<td align="right" class="label" ><fmt:message key="ePO.PaymentTerms.label" bundle="${po_labels}"/></td>
			<td >&nbsp;<select name="pmnt_term" id="pmnt_term" ><%=bean.getPayment_term()%></select></td>
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.SuppAccountNumber.label" bundle="${po_labels}"/></td>
			<td>&nbsp;<input type=text value = "<%=bean.checkForNull(acc_no,"")%>" name="acc_no" size=10 maxlength=10 class="UPPER" onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" > </td>
			<td align="right" class="label" ><fmt:message key="ePO.TermsAndConditions.label" bundle="${po_labels}"/></td>
			<td>&nbsp;<select name="terms_conditions" id="terms_conditions" ><%=bean.getTermsandcondition()%>
			</select></td>
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.SupplierAddressLine1.label" bundle="${po_labels}"/></td>
			<td >&nbsp;<input type="text" value = "<%=bean.checkForNull(supp_address1,"")%>" name="supp_address_1" size='30' maxLength='30' >	</td>
			<td align="right" class="label" ><fmt:message key="ePO.DeliveryMode.label" bundle="${po_labels}"/></td>
			<td>&nbsp;&nbsp;<select name="delivery_mode" id="delivery_mode" ><%=bean.loadDelivery_mode()%>
			</select></td>
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.AddressLine2.label" bundle="${po_labels}"/></td>
			<td >&nbsp;<input type="text" value = "<%=bean.checkForNull(supp_address2,"")%>" name="supp_address_2" size='30' maxLength='30' >	</td>
			<td align="right" class="label" ><fmt:message key="ePO.DeliverToAddress.label" bundle="${po_labels}"/></td>
			<td class="fields"   colspan='3' >&nbsp;<textarea   name="deliver_to_address" rows='4' cols='40' onKeyPress="checkMaxLimit(this,100);" ><%=bean.getDeliver_to_address()%></textarea></td>
		</tr>
		<tr>
			<td align="right" class="label" ><fmt:message key="ePO.AddressLine3.label" bundle="${po_labels}"/></td>
			<td >&nbsp;<input type="text" value = "<%=bean.checkForNull(supp_address3,"")%>" name="supp_address_3" size='30' maxLength='30' >	</td>
			<td align="right" class="label" ><fmt:message key="ePO.BillToAddress.label" bundle="${po_labels}"/></td>
			<td>&nbsp;<textarea  name="bill_to_address" rows='4' cols='40'onKeyPress="checkMaxLimit(this,100);" ><%=bean.getBill_to_address()%></textarea></td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td align=right class="label">
				<% if (po_mode.equals("R")){ %>
					<a href="javascript:BillToDeliverDetails('<%=bean_id%>','<%=bean_name%>','<%=mode%>')">Multi-Facility Deliver To & Bill To</a>
				<% } else { %>	
					
				<% } %>	
				</td>
		</tr>
		
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td align=right>
					<input type="button" class="button" name="Ok" id="Ok" value="Ok"  onClick="exitAdditionalDetails();">
				</td>
		</tr>
	</table>
	<input type="hidden" 	name=sys_date				value="<%=sys_date%>">
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>


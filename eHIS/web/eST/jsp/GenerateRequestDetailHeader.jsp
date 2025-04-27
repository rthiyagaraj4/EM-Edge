<!DOCTYPE html>
 <%@ page import="eST.GenerateRequestBean,eST.GenerateRequestDetail,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		String sStyle						 =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/GenerateRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type="text/css">
	.NOBORDER{
		border:1;
		border-width: 1;
		border-style: solid;
		text-align: right;
	}
	</style>
</head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale						=			 (String)session.getAttribute("LOCALE");
		

		String bean_id						=			"generateRequestBean";
		String bean_name					=			"eST.GenerateRequestBean";
	//	String val							=			"";
		String disabled						=			"";
		String className					=			"";
		String checked						=			"checked";

		java.util.ArrayList alItemKeys		=			null;
	//	java.util.ArrayList duplicateValues =			null;
		java.util.HashMap hmGenerateRequest =			null;
		String mode							=			request.getParameter("mode");
		String function_id					=			request.getParameter("function_id");
		String generateRequestKey			=			"";


		GenerateRequestBean generateRequestBean			=		(GenerateRequestBean) getBeanObject( bean_id, bean_name, request);  
		alItemKeys										=		generateRequestBean.getGenerateRequestKeys();
		hmGenerateRequest								=		generateRequestBean.getHmGenerateRequest();

		generateRequestBean.setLanguageId(locale);

		int i											=		0;
		String store_code_on							=		"";
		String qty_check								=		"";
	//	String less_stock_yn							=		"";
		store_code_on									=		request.getParameter("store_code");
	%>
	<body>
	<form name='formGenerateRequestDetail' id='formGenerateRequestDetail'>
		<%
			if (alItemKeys != null && (alItemKeys.size()>0)) {
		%>
			<table name ="tblItemStore" id="tblItemStore" border='1' cellpadding='0' cellspacing='0' width='100%'  align=center>
 			<tr>
				<th width="2%">			<fmt:message key="eST.S.label" bundle="${st_labels}"/></th>
				<th nowrap width="8%">	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<BR>
				<th width="35%">		<fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
				<th width="5%">			<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></th>
				<th nowrap width="10%"> <fmt:message key="eST.MaxStockQuantity.label" bundle="${st_labels}"/></th>
				<th width="10%"  nowrap><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></th>
				<th nowrap width="10%"><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
				<th nowrap width="10%"><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></th>
				<th nowrap width="10%"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
				<th nowrap width="10%"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
			</tr> 
			 <%
					int totalSize				=		alItemKeys.size();
					String firstItem			=		null;
					GenerateRequestDetail generateRequestDetail;
					for (i=0;	i<totalSize;	i++){
						generateRequestKey = (String) alItemKeys.get(i);
						if (i==0) {
							firstItem			=		""+i;
						}
						generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(generateRequestKey);
						if (generateRequestDetail != null) {
						className				=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";

					//	qty_check				=		generateRequestBean.getStock_Status(store_code_on,generateRequestDetail.getItem_code());
					qty_check					=		generateRequestDetail.getQoh_onstore();	
						
						
						//less_stock_yn			=		(Integer.parseInt(qty_check) < Integer.parseInt(generateRequestDetail.getReq_qty()))?"Y":"N";
				%>
				<tr id="tr_<%=i%>">
					<td class="<%=(Integer.parseInt(qty_check) < Integer.parseInt(generateRequestDetail.getReq_qty()))?"OARED":className%>" title="<%=(Integer.parseInt(qty_check) < Integer.parseInt(generateRequestDetail.getReq_qty()))? "Insufficient Stock" : "" %>">&nbsp;</td>

					<td class="<%=className%>"  nowrap ><input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=generateRequestKey%>" <%=disabled%> <%=checked%> onFocus="return changeRowColor(tr_<%=i%>);"></td>
					<td class="<%=className%>"  nowrap ><%=generateRequestDetail.getItem_desc()%></td>
					<td class="<%=className%>"  nowrap  > <%=generateRequestBean.getImage(generateRequestDetail.getStock_item_yn())%></td>
					<td class="<%=className%>"  nowrap > <%=generateRequestBean.checkForNull(generateRequestDetail.getMax_stock_qty(),"&nbsp;")%></td>
					<td  class="<%=className%>"  nowrap  > <%=generateRequestBean.checkForNull(generateRequestDetail.getReorder_level(),"&nbsp;")%></td>
					<td  class="<%=className%>"  nowrap  > <%=generateRequestBean.checkForNull(generateRequestDetail.getQty_on_hand(),"0")%></td>
					<td class="<%=className%>"  nowrap > <%=generateRequestBean.checkForNull(generateRequestDetail.getPending_req_qty(),"&nbsp;")%></td>
					<td  class="<%=className%>"  nowrap  width='10'><input type="text" class="NOBORDER" name ="req_qty_<%=i%>" value="<%=generateRequestBean.checkForNull(generateRequestDetail.getReq_qty())%>" size="12" maxlength="12"  onkeypress = "return isValidNumber(this,event,<%=generateRequestBean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" onBlur="checkQty(this,add_itm_<%=i%>);" onFocus="return changeRowColor(tr_<%=i%>);"></td>
        			<td class="NODISPLAY"  nowrap ><input type="hidden" name="uom_code_<%=i%>" id="uom_code_<%=i%>" value=<%=generateRequestBean.checkForNull(generateRequestDetail.getUom_code())%> ></td>
				
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=generateRequestDetail.getItem_code()%>">
				<%
					}
				}
%>
		<script>
		document.formGenerateRequestDetail.req_qty_<%=firstItem%>.focus();
		</script>
	
<%
			}
			else
	{
		%>
		<script>
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
		</script>
		<%
	}
	%>
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission" value="">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type="hidden" name="doc_type_code" id="doc_type_code" value="">
			<input type="hidden" name="doc_no" id="doc_no" value="">
			<input type="hidden" name="doc_date" id="doc_date" value="">
			<input type="hidden" name="doc_ref" id="doc_ref" value="">
			<input type="hidden" name="requisition_by_store" id="requisition_by_store" value="">
			<input type="hidden" name="requisition_on_store" id="requisition_on_store" value="">
			<input type="hidden" name="item_class_code" id="item_class_code" value="">
			<input type="hidden" name="finalize_yn" id="finalize_yn" value="">
			<input type="hidden" name="autono_yn" id="autono_yn" value="">
			<input type="hidden" name="effective_date" id="effective_date" value="">
			<input type="hidden" name="item_from_code" id="item_from_code" value="">
			<input type="hidden" name="item_to_code" id="item_to_code" value="">
			<input type="hidden" name="alpha_from_code" id="alpha_from_code" value="">
			<input type="hidden" name="alpha_to_code" id="alpha_to_code" value="">
		
		</form>
		<% putObjectInBean(bean_id,generateRequestBean,request);%>
	</body>
</html>


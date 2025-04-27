<!DOCTYPE html>
<%@ page import=" eST.RequestStatusBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			 =	(String)session.getAttribute("LOCALE");
		String sStyle			 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>	
		<script language='javaScript' src="../../eST/js/BackOrderList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		String bean_id				=		"RequestStatusBean";
		String bean_name			=		"eST.RequestStatusBean";
		String default_value		=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
		RequestStatusBean bean		=		(RequestStatusBean) getBeanObject(bean_id, bean_name,request);  
		bean.setLanguageId(locale);
		bean.clear();
		bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));
		ServletContext context		=		getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
			bean.setLocalEJB(false);
		String user_name				=		(String)session.getAttribute("login_user");
		//Added by Rabbani #Inc no :30075(Bru-HIMS-CRF-116) on 10-MAY-2013
		//String site_id = bean.checkForNull(bean.getCustomerID());
		//Added by Rabbani #Inc no :40572 (Ref:30075(Bru-HIMS-CRF-116)) on 05-JUN-2013
		String trn_type = "REQ";
		 boolean isGRN_No_Applicable	    =	bean.isGRN_No_Applicable(trn_type);
	%>
<body onload='FocusFirstElement();'>
	<form name= "formRequestStatusQueryCriteria" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" onReset='FocusFirstElement();'>
		<table border="0" cellspacing="0" width="100%" align="center">
			<tr>
				<td align="right" class="label">
					<fmt:message key="eST.Requestsof.label" bundle="${st_labels}"/> 
				</td>
				<td >&nbsp;&nbsp;
					<select name="request_type" id="request_type" onChange="populateReqByStores(this);populateItemClasses(request_by_store,request_on_store);">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
						<option value="N"><fmt:message key="eST.InternalStores.label" bundle="${st_labels}"/></option>
						<option value="Y"><fmt:message key="eST.ExternalStores.label" bundle="${st_labels}"/></option>
					</select>
				</td>
				<td align="right" class="label">
					<fmt:message key="Common.DocType.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;&nbsp;
					<select name="doc_type_code" id="doc_type_code"><%=bean.getDocTypeCodes()%>
					</select>
				</td>
				<td align="right" class="label">
					<!--<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> -->
					<fmt:message key="eST.ReqNo.label" bundle="${st_labels}"/>
				</td>
				<td >&nbsp;&nbsp;
					<input class="NUMBER" type="text" size="10" maxlength="8" onKeyPress="return isValidInteger();" name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" >
				</td>
			</tr>
			<tr>
				<td align="right" class="label">
					<fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/>
				</td>
				<td >&nbsp;&nbsp;
					<select name="request_by_store" id="request_by_store" onChange="populateToStoresInQuery(this); populateItemClasses(this,request_on_store);"> <%=bean.getRequestByStore()%>		</select>
				</td>
				<td align="right" class="label">
					<fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>
				</td>
				<td >&nbsp;&nbsp;
					<select name="request_on_store" id="request_on_store" onChange="populateItemClasses(request_by_store,this);"><%=default_value%>
					</select>
				</td>	 
				<td align="right" class="label">
					<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/><!-- Modified for IN:074037  -->
				</td>
				<td>&nbsp;&nbsp;
					<select name="item_class_code" id="item_class_code"><%=bean.getAllItemClasses()%></select>
				</td>
			</tr>
			<tr>
				<td class="label" align='right'>
					<fmt:message key="Common.item.label" bundle="${common_labels}"/>
				</td>
				<td colspan="1">&nbsp;&nbsp;
					<input type='text' size='20'  maxlength='20' name='item_code' id='item_code'  value="">
					<!--<input type='text' size='60'  maxlength='60' name='item_desc' id='item_desc'  value="">
					<input type='hidden' size='20'  maxlength='20' name='item_code' id='item_code'  value="">-->
					<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="return searchItemCode(item_code);" class="label">
				</td>
				<!--//Added by Rabbani #Inc no :40572 (Ref:30075(Bru-HIMS-CRF-116)) on 05-JUN-2013 -->
				<%if(isGRN_No_Applicable){%>
				<td align="right" class="label">
					<fmt:message key="eST.GRNNo.label" bundle="${st_labels}"/>
				</td>
				<td >&nbsp;&nbsp;
					<input class="NUMBER" type="text" size="10" maxlength="8" onKeyPress="return isValidInteger();" name="p_grn_doc_no" id="p_grn_doc_no" onBlur="return checkIntegerFormat(this);" >
				</td>
				<%}%>
				<!-- ends -->
				<td align="right" class="label">
					<fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;&nbsp;
					<select name="request_status" id="request_status">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<option value="E"><fmt:message key="eST.ReqEntered.label" bundle="${st_labels}"/></option>
					<option value="W"><fmt:message key="eST.AuthorizedatRequestbyStore.label" bundle="${st_labels}"/></option>
					<!--<option value="A"><fmt:message key="eST.AuthorizedatIssueStore.label" bundle="${st_labels}"/></option>-->
					<option value="P"><fmt:message key="Common.PartiallyIssued.label" bundle="${common_labels}"/></option>
					<!--<option value="C"><fmt:message key="Common.FullyIssued.label" bundle="${common_labels}"/></option>-->
					<option value="FA">Fully Authorized at Issue Store </option>
					<option value="PA">Partially Authorized at Issue Store </option>
					<option value="PAI">Partially Authorized/Issued at Issue Store</option>
					<option value="FAPI">Fully Authorized/Partially Issued at Issue Store</option>
					<option value="FAFI">Fully Authorized/Issued at Issue Store</option>
   					<option value="C">Issue Closed</option>
					<option value="L">Cancelled</option>
					<option value="I">Force Closed</option><!--Added by B. Badmavathi against GDOH-SCF-0192-->
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" class="label">
					<fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/>
				</td>
				<td colspan=3>&nbsp;&nbsp;
					<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');" ></img> &nbsp;&nbsp;
					<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
					<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');" ></img>
				</td>
				<td align="right" class="label">&nbsp;</td>
				<td align="right">&nbsp;</td>				
			</tr>	  
		</table>
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name %>">
		<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale %>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"			value="doc_type_code,doc_no">
		<input type="hidden" name="p_report_id" id="p_report_id"				value="STBREQSTAT">
		<input type="hidden" name="p_module_id" id="p_module_id" 			value="ST">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_name%>">
	</form>
	<%//STBREQSTAT
	putObjectInBean(bean_id,bean,request);
	%>
</body>
</html>


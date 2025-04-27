<!DOCTYPE html>
<%@ page import=" eST.RequestStatusBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			 =	(String)session.getAttribute("LOCALE");
	String sStyle			 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language='javaScript' src="../../eST/js/RequestStatus.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function_id			=		"<%= request.getParameter("function_id") %>"
	menu_id				=		"<%= request.getParameter("menu_id") %>"
	module_id			=		"<%= request.getParameter("module_id") %>"
</script>
</head>
<%
	String bean_id				=		"RequestStatusBean";
	String bean_name			=		"eST.RequestStatusBean";
	String mode					=		 request.getParameter("mode");
	String default_value		=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	try{
	mode						=		mode.trim();
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	}
	catch(Exception ee) { }

	RequestStatusBean bean		=		(RequestStatusBean) getBeanObject(bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear();
	bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));

	ServletContext context		=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	  HashMap alstartdate      = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	
%>
<body onload='FocusFirstElement();'>
	<form name= "formRequestStatusQueryCriteria" action="../../eST/jsp/RequestStatusQueryResult.jsp" method="post"  target="result" onReset='FocusFirstElement();'>
	
	<table border="0" cellspacing="0" width="100%" align="center">
		<tr>
			<td align="left" class="label"><fmt:message key="eST.Requestsof.label" bundle="${st_labels}"/> </td>
			<td >&nbsp;&nbsp;
				<select name="request_type" id="request_type"  onChange="populateReqByStores(this)">
					<option value="%"><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<option value="N"><fmt:message key="eST.InternalStores.label" bundle="${st_labels}"/></option>
					<option value="Y"><fmt:message key="eST.ExternalStores.label" bundle="${st_labels}"/></option>
				</select>
			</td>
			<td align="left" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
			<td >&nbsp;&nbsp;
			   
				<select name="doc_type_code" id="doc_type_code" ><%=bean.getDocTypeCodes()%></select>
				<!-- commented by Rabbani #Inc no:42721 on 28-AUG-2013  -->
				<!-- <%=bean.getImage("M")%> -->
				
			</td>
			<td align="left" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
			<td colspan="5">&nbsp;&nbsp;
				<input class="NUMBER" type="text" size="10" maxlength="8" onKeyPress="return isValidInteger();" name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" >
			</td>
		</tr>
		<tr>
			<td align="left" class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='request_by_store' id='request_by_store' size=10 maxlength=6 value=""><input type='button' name="store_search_from" id="store_search_from" class="button"   onClick="populateToStoresInQuery(request_by_store);populateItemClasses(request_by_store,request_on_store);"  value='?' ></td>
			<!--<td >&nbsp;&nbsp;
				<select name="request_by_store" id="request_by_store" onChange="populateToStoresInQuery(this);populateItemClasses(this,request_on_store);""><%=bean.getRequestByStore()%></select>
			</td>-->
			<td align="left" class="label" ><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></td>

			<td class='fields'><input type='text' name='request_on_store' id='request_on_store' size=10 maxlength=6 value=""><input type='button' name="store_search_to" id="store_search_to" class="button"   onClick="return populateStoresInQuery(request_on_store,request_by_store);populateItemClasses(request_by_store,request_on_store);"  value='?' ></td>
			<!--<td >&nbsp;&nbsp;
				<select name="request_on_store" id="request_on_store" onChange="populateItemClasses(request_by_store,this);"><%=default_value%></select>
			</td>	 -->
			<td align="left" class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
			<td colspan="5" >&nbsp;&nbsp;
				<select name="item_class_code" id="item_class_code"><%=bean.getAllItemClasses()%></select>
			</td>
		</tr>
		<tr>
			<td class="label" align='left'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=3>&nbsp;&nbsp;
			<input type='text' size='60'  maxlength='60' name='item_desc' id='item_desc'  value="">
				<input type='hidden' size='20'  maxlength='20' name='item_code' id='item_code'  value="">
				<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="return searchItemCode(item_code);" class="label">
			</td>
			<td align="left" class="label"><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></td>
			<td colspan="3">&nbsp;&nbsp;
				<select name="request_status" id="request_status" onchange ="populateackstatus(this);">
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<option value="E">Request Entered At Request Store</option>
					<option value="W"><fmt:message key="eST.AuthorizedatRequestbyStore.label" bundle="${st_labels}"/></option>
					<!--<option value="A"><fmt:message key="eST.AuthorizedatIssueStore.label" bundle="${st_labels}"/></option>-->
					<option value="P"><fmt:message key="Common.PartiallyIssued.label" bundle="${common_labels}"/></option>
					<!--<option value="C"><fmt:message key="Common.FullyIssued.label" bundle="${common_labels}"/></option>-->
					<option value="FA">Fully Authorized at Issue Store </option>
					<option value="PA">Partially Authorized at Issue Store </option>
					<option value="PAI">Partially Authorized/Issued at Issue Store</option>
					<option value="FAFI">Fully Authorized/Issued at Issue Store</option>
					<option value="FAPI">Fully Authorized/Partially Issued at Issue Store</option>
					<option value="C">Issue Closed</option>
					<option value="L">Cancelled</option>
					<option value="I">Force Closed</option> <!-- Added by rabbani #inc no :44127 (ML-BRU-SCF-1085) on 25-OCT-2013 -->
					<option value="R">Rejected At Issue Store</option><!-- MO-CRF-20174 -->
					

					</select>
			</td>
		</tr>
		<tr>
			<td align="left" class="label"><fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/> </td>
			<td colspan=3>&nbsp;&nbsp;
				<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDate(this);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"  ></img><%=bean.getImage("M")%>&nbsp;&nbsp;
				<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
				<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="CheckDate(this);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"  ></img>
			</td>
			<TD class=label align=left>Hold Y/N </TD>
			<TD>&nbsp;&nbsp; <SELECT onchange="" name=hold_yn> <OPTION selected value=%>Both &nbsp;&nbsp;</OPTION> <OPTION value=Y>Yes</OPTION> <OPTION value=N>No</OPTION></SELECT> </TD>
			<td align="right" class="label" colspan="3">Acknowledgement Status</td>
			<td >&nbsp;&nbsp;
				<select name="acknowledge_status" id="acknowledge_status" disabled>
					<option value="%" ><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<option value="FAK">Fully Acknowledged </option>
					<option value="PA">Partially Acknowledged </option>
					<option value="AKP">Acknowledgement Pending</option>
					<option value="PACP">Partially Acknowledged/Confirmation Pending</option>
					<option value="FACC">Fully Acknowledged/Confirmation Complete</option>
					<option value="PACC">Partially Acknowledged/Confirmation Complete</option>
					<option value="FACP">Fully Acknowledged/Confirmation Pending</option>

					</select>
			</td>
			
		  </tr>
		  <tr>
			
			<td align="right" class="label">&nbsp;</td>
			<td align="right" class="label">&nbsp;</td>
			<td align="right" class="label">&nbsp;</td>
			<td align="right" class="label">&nbsp;</td>
			<td align="right" class="label">&nbsp;</td>
			

			<td align="right" colspan="5">
				<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchRequestResults( );">
			</td>		
			 </tr> 
	</table>

		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"		value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name %>">
		<input type="hidden" name="language_id" id="language_id"				value="<%=locale %>">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id"				value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"			value="doc_type_code,doc_no">
		<input type="hidden" name="facility_id" id="facility_id"			   value="<%=bean.getLoginFacilityId()%>">
		<input type="hidden" name="user_id" id="user_id"			   value="<%=bean.getLoginById()%>">
		
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>

</body>
</html>


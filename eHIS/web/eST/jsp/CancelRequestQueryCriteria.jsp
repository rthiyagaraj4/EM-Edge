<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		String sStyle	 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/CancelRequest.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
    <script>
        function_id		=		"<%= request.getParameter("function_id") %>"
		menu_id			=		 "<%= request.getParameter("menu_id") %>"
		module_id		=		"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
	String default_value				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	String bean_id						=		"cancelRequestBean";
	String bean_name					=		"eST.CancelRequestBean";
	String mode							=		request.getParameter("mode");
	mode								=		mode.trim();

	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	CancelRequestBean bean				=		(CancelRequestBean) getBeanObject(bean_id,bean_name,request);  
    bean.initialize();
	bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));

	ServletContext context				=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	java.util.HashMap defaultParameter	=		bean.getDefaultStParameter();
	String default_doc_type_code		=		(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
	bean.setLanguageId(locale);
	
	//Added by Rabbani #Inc no:30909 on 12/03/12 Starts
	  
	  HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
	 //ends
%>
<body onload='FocusFirstElement();'>
	<form name= "formCancelRequestQueryCriteria" action="../../eST/jsp/CancelRequestQueryResult.jsp" method="post" target="CancelRequestQueryResultFrame" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="eST.Requestsof.label" bundle="${st_labels}"/> </td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_type" id="request_type" onChange="populateReqByStore(this)">
		<!-- <%=bean.getStaticListOptionTag("%,All;N,Internal Stores;Y,External Stores;")%> -->
		<option value="%"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="eST.InternalStores.label" bundle="${st_labels}"/></option>
			<option value="Y"><fmt:message key="eST.ExternalStores.label" bundle="${st_labels}"/></option>
				</select></td>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onFocus="populateStores(this);"><%=bean.getDocTypeCodes()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(request_by_store);" ></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_by_store" id="request_by_store" onBlur="populateStores(this);"><%=bean.getRequestByStore()%></select></td>
		<td  class="label"><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store" onBlur="populateItemClasses(request_by_store,this);"><%=default_value%></select></td>	 
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
	  </tr>
	  <tr>
	 	<td  class="label">
			<fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/> 
		</td>
		<td colspan='2' class='fields'>
			&nbsp;&nbsp;<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10"   value="<%=currentdateminus%>"  onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"> </img>
						<label class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</label>
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"> </img>
					</td>
				<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
		<td class='label' ><fmt:message key="eST.ReqStatus.label" bundle="${st_labels}"/></td>
		<td  class='fields'>&nbsp;&nbsp;<select name="request_status" id="request_status">
			<!-- <%=bean.getStaticListOptionTag(" ,All;W,Authorized at Req. by Store;P,Partially Issued")%> -->
				<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value="W"><fmt:message key="eST.AuthorizedatRequestbyStore.label" bundle="${st_labels}"/></option>
				<option value="P"><fmt:message key="Common.PartiallyIssued.label" bundle="${common_labels}"/></option>
	</select>
		</td>
		   <!--Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 16-JULY-2013 Starts -->
		    <td class='label'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class="fields">
			<input type="text" name="item_desc" id="item_desc" size="70" maxlength="60"  value="" >
			<input type="hidden" name="item_code" id="item_code" value="">
			<input type="button" value="?" class="button" onClick="return callItemSearch();" ></td>
			<!--ends -->
		<td class='fields' align='left' colspan='3'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="submitQueryCriteria();"></td>
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="hdr.doc_no,doc_type_code">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


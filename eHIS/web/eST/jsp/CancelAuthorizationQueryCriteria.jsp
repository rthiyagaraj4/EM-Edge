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
	<script language="JavaScript" src="../../eST/js/CancelAuthorization.js"></script>
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
	String bean_id						=		"CancelAuthorizationBean";
	String bean_name					=		"eST.CancelAuthorizationBean";
	String mode							=		request.getParameter("mode");
	       mode							=		mode.trim();

	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	CancelAuthorizationBean bean				=		(CancelAuthorizationBean) getBeanObject(bean_id,bean_name,request);  
    bean.initialize();
	bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));

	ServletContext context				=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	java.util.HashMap defaultParameter	=		bean.getDefaultStParameter();
	bean.setLanguageId(locale);
	  
	  HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
	
%>
<body onload='FocusFirstElement();'>
	<form name= "formCancelAuthQueryCriteria" action="../../eST/jsp/CancelAuthorizationQueryResult.jsp" method="post" target="CancelAuthQueryResultFrame" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td colspan='1.5' class="label" ><fmt:message key="eST.Requestsof.label" bundle="${st_labels}"/> </td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_type" id="request_type" onChange="populateReqOnStore(this)">
		
		<option value="%"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="eST.InternalStores.label" bundle="${st_labels}"/></option>
			<option value="Y"><fmt:message key="eST.ExternalStores.label" bundle="${st_labels}"/></option>
				</select></td>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onFocus="populateReqOnStore(this);"><%=bean.getDocTypeCodes()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='3'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
	  </tr>
	  <tr>
	    <td  colspan='1.5' class="label"><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store" onBlur="populateStores(this);" ><%=bean.getRequestOnStore()%></select></td>	
		<td  class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_by_store" id="request_by_store" onBlur="populateItemClasses(request_on_store,this);"><%=default_value%></select></td> 
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
		<td class='fields' colspan='3'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
	  </tr>
	  <tr>
	 	<td  class="label">
			<fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/> 
		</td>
		<td colspan='2' class='fields'>
			&nbsp;&nbsp;<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10"   value="<%=currentdateminus%>"  onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"> </img>
						<label class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</label>
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"> </img>
					</td>
			<td colspan='4' class='label'><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;
			<input type="text" name="item_desc" id="item_desc" size="70" maxlength="60"  value="" >
			<input type="hidden" name="item_code" id="item_code" value="">
			<input type="button" value="?" class="button" onClick="return callItemSearch();" ></td>
		<td>&nbsp;&nbsp;</td>

	  </tr>
	  <tr>
	       <td>&nbsp;&nbsp;</td>
		   <td>&nbsp;&nbsp;</td>
		    <td>&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;</td>
			<td>&nbsp;&nbsp;</td>
		<td  class='fields'  colspan='2'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="submitQueryCriteria();"></td>
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


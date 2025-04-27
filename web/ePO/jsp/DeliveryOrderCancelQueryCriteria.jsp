<!DOCTYPE html>
 <%@ page import="ePO.DeliveryOrderCancelBean" contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/DeliveryOrderCancel.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
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
	String bean_id						=		"DeliveryOrderCancelBean";
	String bean_name					=		"ePO.DeliveryOrderCancelBean";
	String mode							=		(String)request.getParameter("mode")==null?"MODE_MODIFY":(String)request.getParameter("mode");
	mode								=		mode.trim();
	System.out.println("mode===>" +mode);
	String function_id    = (String)request.getParameter("function_id")==null?"function_id":(String)request.getParameter("function_id");
	
	//if ((mode == null) || (mode.equals(""))) 
		//return;
	//if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		//return;

	DeliveryOrderCancelBean bean				=		(DeliveryOrderCancelBean) getBeanObject(bean_id,bean_name,request);  
    bean.initialize();
	bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));

	ServletContext context				=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(function_id));
	//java.util.HashMap defaultParameter	=		bean.getDefaultStParameter();
	//String default_doc_type_code		=		(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
	//System.out.println("default_doc_type_code====>" +default_doc_type_code);
	//System.out.println("getdoctype====>" +bean.getDocTypeCodes());
	//System.out.println("purchasetpes====>" +bean.getPurchase_type_List());
	//bean.setDefaultDocType(default_doc_type_code);
	  bean.setLanguageId(locale);
	  
        String to_date    =  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
   	    //String from_date =  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	    String from_date    =  com.ehis.util.DateUtils.minusDate(to_date,"DMY",locale,1,"M").toString();
	
	
%>
<body onload='FocusFirstElement();document.formDeliveryCancelOrderQueryCriteria.submit();'>
	<form name= "formDeliveryCancelOrderQueryCriteria" action="../../ePO/jsp/DeliveryOrderCancelQueryResult.jsp" method="post" target="DeliveryCancelOrderQueryResultFrame" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		
		<td  class="label"><fmt:message key="ePO.DOType.label" bundle="${po_labels}"/></td>
				<td class="fields">&nbsp;
					<select name="delivery_type" id="delivery_type"  >
					<%=bean.getDelivery_type_List()%>
					</select>
				</td>
		
		<td  class="label"><fmt:message key="ePO.DONo.label" bundle="${po_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="20" maxlength="20" class='NUMBER' name="do_no" id="do_no" onBlur="" ></td>
		<td  colspan=2>&nbsp; </td>
	  </tr>
	  <tr>
	  
		
         <td  class="label"> <fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/> </td>
    	 <td  class="fields">&nbsp;
	     <select name="to_supplier" id="to_supplier"  onChange="" >  <%=bean.getRequestToSupp()%>
		 </select>
         </td>		
	  </tr>
	  <tr>
	 	 <td  class="label"><fmt:message key="ePO.DODateFrom.label" bundle="${po_labels}"/></td>
		<td colspan='2' class='fields'>
			&nbsp;&nbsp;<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=from_date%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"> </img><%=bean.getImage("M")%>
				<label class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</label>
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=to_date%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"> </img><%=bean.getImage("M")%>
					</td>
				<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td class='fields'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="frmdate();"></td>
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<input type="hidden" name="mode" id="mode" value="2">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
		<!--<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="hdr.doc_no,doc_type_code">-->
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


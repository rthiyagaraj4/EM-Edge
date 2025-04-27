<!DOCTYPE html>
<%@ page import ="javax.servlet.ServletContext, java.util.HashMap, ePO.UserAccessForDOBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="Common.UserAccessforStoreListing.label" bundle="${common_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale					= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language='javascript' src='../../ePO/js/PoTransaction.js'></script>
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../ePO/js/UserAccessForDO.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body>
<center>
<form method=post name="UserAccessForStoreListForm" id="UserAccessForStoreListForm" action="" onMouseDown="CodeArrest()">
   <%
 
	String mode									 =		"";
	String bean_id								 =		"";
	String bean_name							 =		"";
	
	String user_id								 =		"";
		
	
	bean_id										 =		"userAccessForDOBean" ;
	bean_name									 =		"ePO.UserAccessForDOBean";
	user_id										 =		 request.getParameter("user_id");
	


	System.out.println("user_id"+user_id);
	
	UserAccessForDOBean bean					 =		(UserAccessForDOBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);	
	bean.clear();

	try{
	ServletContext context						=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ;

	bean.setUser_id(user_id);
	

	HashMap hmRecordForUserAccess				=	bean.getUserAccessForDOData();

	if ((hmRecordForUserAccess!=null)&&(hmRecordForUserAccess.size()>0)) {

		bean.initialize(hmRecordForUserAccess);
		 context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	
		bean.setMode( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ;
		bean.setUser_id(user_id);
	  		
		}
 
	    mode=bean.getMode();

		String delvDisabled = "";
		if(bean.getDo_order_create_allowed_yn().equals("Y")){
			delvDisabled = "";
		}else{
			delvDisabled = "disabled";
		}
		
		String quotDisabled = "";
		if(bean.getQuot_order_create_allowed_yn().equals("Y")){
			quotDisabled = "";
		}else{
			quotDisabled = "disabled";
		}
	  
		
%>
		
<table border="1" cellpadding="0" cellspacing="0" width=100% align="center">
     <tr>
       <th colspan=2><fmt:message key="ePO.TransactionApplicable.label" bundle="${po_labels}"/></th>
	  <!-- <th><fmt:message key="ePO.Create.label" bundle="${po_labels}"/></th>  -->
       <th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/>/<br><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></th>
	   <th><fmt:message key="ePO.Cancel.label" bundle="${po_labels}"/></th>
	   <th><fmt:message key="ePO.Delete.label" bundle="${po_labels}"/></th>
       </tr>
	  
	   <tr>
	   <td class = "QRYODD"><fmt:message key="ePO.DeliveryOrder.label" bundle="${po_labels}"/></td>
	   <td class="QRYODD"><input type=checkbox name="do_order_create_allowed_yn" id="do_order_create_allowed_yn" onClick="delvTranChange(this);" value="Y"  <%=bean.getChecked(bean.getDo_order_create_allowed_yn())%>></td>
	   <td class="QRYODD"><input type=checkbox name="do_order_finalize_allowed_yn" id="do_order_finalize_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getDo_order_finalize_allowed_yn())%><%=delvDisabled%>></td>
	    <td class="QRYODD"><input type=checkbox name="do_order_cancel_allowed_yn" id="do_order_cancel_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getDo_order_cancel_allowed_yn())%> <%=delvDisabled%>></td>
	    <td class="QRYODD"><input type=checkbox name="do_order_delete_allowed_yn" id="do_order_delete_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getDo_order_delete_allowed_yn())%> <%=delvDisabled%>></td>
	   </tr>
	     <tr>
	   <td class = "QRYODD"><fmt:message key="ePO.Quotation.label" bundle="${po_labels}"/></td>
	   <td class="QRYODD"><input type=checkbox name="quot_order_create_allowed_yn" id="quot_order_create_allowed_yn" onClick="quotTranChange(this);" value="Y"  <%=bean.getChecked(bean.getQuot_order_create_allowed_yn())%>></td>
	   <td class="QRYODD"><input type=checkbox name="quot_order_finalize_allowed_yn" id="quot_order_finalize_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getQuot_order_finalize_allowed_yn())%>  <%=quotDisabled%>></td>
	    <td class="QRYODD"><input type=checkbox name="quot_order_cancel_allowed_yn" id="quot_order_cancel_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getQuot_order_cancel_allowed_yn())%> <%=quotDisabled%>></td>
	    <td class="QRYODD"><input type=checkbox name="quot_order_delete_allowed_yn" id="quot_order_delete_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getQuot_order_delete_allowed_yn())%><%=quotDisabled%>></td>
	   </tr>
</table>

<%
		    }
			catch(Exception e){
				out.println("Exception@1: "+e.toString());
				e.printStackTrace();
			}
 
%>  
   
    <input type="hidden"	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden"	name="bean_name" id="bean_name"			value="<%= bean_name %>">
    <input type="hidden"	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden"	name="user_id" id="user_id"				value="<%=request.getParameter("user_id")%>">
	<input type="hidden"	name="po_unit_code" id="po_unit_code"			value="<%=request.getParameter("po_unit_code")%>">
	<input type="hidden" name="user_store_access_appl" id="user_store_access_appl" value="Y"   >
	
	<input type="hidden"	name="count" id="count">
	
	
</form>
</center>

<%putObjectInBean(bean_id,bean,request);%>
</body>
</html>


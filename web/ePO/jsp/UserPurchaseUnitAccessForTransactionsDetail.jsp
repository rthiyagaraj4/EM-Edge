<!DOCTYPE html>
<%@ page import ="javax.servlet.ServletContext, java.util.HashMap, ePO.UserPurchaseUnitAccessForTransactionsBean" contentType="text/html;charset=UTF-8"%>
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
		<script language="JavaScript" src="../../ePO/js/UserPurchaseUnitAccessForTransactions.js"></script>
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
	String po_unit_code							 =		"";
	String store_code							=		"";
	String user_store_access_appl							 =		"";
	String user_store_access_list							=		"";
	
	bean_id										 =		"userPurchaseUnitAccessForTransactionsBean" ;
	bean_name									 =		"ePO.UserPurchaseUnitAccessForTransactionsBean";
	user_id										 =		 request.getParameter("user_id");
	po_unit_code								=		 request.getParameter("po_unit_code");
	user_store_access_appl						= request.getParameter("user_store_access_appl");
	user_store_access_list						= request.getParameter("user_store_access_list");

	
	UserPurchaseUnitAccessForTransactionsBean bean					 =		(UserPurchaseUnitAccessForTransactionsBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);	
	bean.clear();

	try{
	ServletContext context						=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") ) ;

	bean.setUser_id(user_id);
	
	bean.setPo_unit_code(po_unit_code);
	//bean.setUser_store_access_appl(user_store_access_appl);
	//bean.setUser_store_access_list(user_store_access_list);

	
	HashMap hmRecordForUserAccess				=	bean.getUserAccessForPounitData();

	if ((hmRecordForUserAccess!=null)&&(hmRecordForUserAccess.size()>0)) {

		bean.initialize(hmRecordForUserAccess);
		 context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	
		bean.setMode( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ;
		bean.setUser_id(user_id);
	   
		bean.setPo_unit_code(po_unit_code);
		//bean.setUser_store_access_appl(user_store_access_appl);
		//bean.setUser_store_access_list(user_store_access_list);
		
		}
 
	    mode=bean.getMode();

		String prDisabled = "";
		if(bean.getPur_req_create_allowed_yn().equals("Y")){
			prDisabled = "";
		}else{
			prDisabled = "disabled";
		}
		
		String poDisabled = "";
		if(bean.getPur_order_create_allowed_yn().equals("Y")){
			poDisabled = "";
		}else{
			poDisabled = "disabled";
		}
		//Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 30-MAY-2013
		String tndrDisabled = "";
		if(bean.getTndr_create_allowed_yn().equals("Y")){
			tndrDisabled = "";
		}else{
			tndrDisabled = "disabled";
		}
		
	
	
      

%>
		
<table border="1" cellpadding="0" cellspacing="0" width=100% align="center">
     <tr>
       <th colspan=2><fmt:message key="ePO.TransactionApplicable.label" bundle="${po_labels}"/></th>
	    <th><fmt:message key="ePO.DefaultStore.label" bundle="${po_labels}"/></th>
	   
       <th><fmt:message key="Common.Finalize.label" bundle="${common_labels}"/>/<br><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></th>
	   <th><fmt:message key="Common.Amend.label" bundle="${common_labels}"/></th>
	   <th><fmt:message key="ePO.Cancel.label" bundle="${po_labels}"/></th>
	   <th><fmt:message key="ePO.Delete.label" bundle="${po_labels}"/></th>
       </tr>
	    <tr>
       <td class = "QRYODD" ><fmt:message key="ePO.PurchaseRequest.label" bundle="${po_labels}"/></td>
	   <td class="QRYODD"><input type=checkbox name="pur_req_create_allowed_yn" id="pur_req_create_allowed_yn" onClick="prTranChange(this);" value="Y"  <%=bean.getChecked(bean.getPur_req_create_allowed_yn())%>></td>
	  <td class="QRYODD"><select name="user_store_access_list" id="user_store_access_list" value="" <%=prDisabled%> ><%=bean.getUserAccessForStoreList(bean.getUser_store_access_list())%></select></td>
	   
	   <td class="QRYODD"><input type=checkbox name="pur_req_finalize_allowed_yn" id="pur_req_finalize_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getPur_req_finalize_allowed_yn())%> <%=prDisabled%> ></td>
	   <td class="QRYODD"></td>
	   <td class="QRYODD"><input type=checkbox name="pur_req_cancel_allowed_yn" id="pur_req_cancel_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getPur_req_cancel_allowed_yn())%> <%=prDisabled%>></td>
	   
	   <td class="QRYODD"><input type=checkbox name="pur_req_delete_allowed_yn" id="pur_req_delete_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getPur_req_delete_allowed_yn())%> <%=prDisabled%>></td>
	   </tr>
	   <tr>
	   <td class = "QRYODD"><fmt:message key="ePO.PurchaseOrder.label" bundle="${po_labels}"/></td>
	   <td class="QRYODD"><input type=checkbox name="pur_order_create_allowed_yn" id="pur_order_create_allowed_yn" onClick="poTranChange(this);" value="Y"  <%=bean.getChecked(bean.getPur_order_create_allowed_yn())%>></td>
	   <td class="QRYODD">N/A</td>
	   
	   <td class="QRYODD"><input type=checkbox name="pur_order_finalize_allowed_yn" id="pur_order_finalize_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getPur_order_finalize_allowed_yn())%>  <%=poDisabled%> ></td>
	   <td class="QRYODD"><input type=checkbox name="pur_order_amend_allowed_yn" id="pur_order_amend_allowed_yn"  value="Y" <%=bean.getChecked(bean.getPur_order_amend_allowed_yn())%> <%=poDisabled%>></td>
	   <td class="QRYODD"><input type=checkbox name="pur_order_cancel_allowed_yn" id="pur_order_cancel_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getPur_order_cancel_allowed_yn())%> <%=poDisabled%>></td>
	    <td class="QRYODD"><input type=checkbox name="pur_order_delete_allowed_yn" id="pur_order_delete_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getPur_order_delete_allowed_yn())%><%=poDisabled%> ></td>
	   </tr>
	    <!--Added by Rabbani #inc no:30078(Bru-HIMS-CRF-119) on 27-MAY-2013-->
	   <tr>
	   <td class = "QRYODD"><fmt:message key="ePO.Tender.label" bundle="${po_labels}"/></td>
	   <td class="QRYODD"><input type=checkbox name="tndr_create_allowed_yn" id="tndr_create_allowed_yn" onClick="poTndrChange(this);" value="Y"  <%=bean.getChecked(bean.getTndr_create_allowed_yn())%>></td>
	   <td class="QRYODD">N/A</td>
	   <td class="QRYODD"><input type=checkbox name="tndr_finalize_allowed_yn" id="tndr_finalize_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getTndr_finalize_allowed_yn())%>  <%=tndrDisabled%> ></td>
	    <td class="QRYODD"> &nbsp; </td>
	   <td class="QRYODD"><input type=checkbox name="tndr_cancel_allowed_yn" id="tndr_cancel_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getTndr_cancel_allowed_yn())%> <%=tndrDisabled%>></td>
	    <td class="QRYODD"><input type=checkbox name="tndr_delete_allowed_yn" id="tndr_delete_allowed_yn"  value="Y"  <%=bean.getChecked(bean.getTndr_delete_allowed_yn())%><%=tndrDisabled%> ></td>
	   </tr>
	   <!-- ends -->
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


<!DOCTYPE html>
<%@ page import="ePO.PurchaseRequestStatusBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<html>
<head>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../ePO/js/PurchaseRequestStatusQuery.js" language="javascript"></script>
	<script language='javascript' src='../js/PoMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String bean_id			=		"purchaseRequestStatusBean";
	String bean_name		=		"ePO.PurchaseRequestStatusBean";
	String locale			= (String)session.getAttribute("LOCALE");
	PurchaseRequestStatusBean bean		=		(PurchaseRequestStatusBean) getBeanObject(bean_id,bean_name, request);  
	bean.setLanguageId(locale);
	
	if(!bean.checkForNull((String)	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("PO_INTERFACE_YN"),"N").equals("Y")){ 	
	
%>

<SCRIPT>alert("Purchase Module Not Applicable");window.location.href = '../../eCommon/jsp/dmenu.jsp'</SCRIPT>   
 <%
	}
	putObjectInBean("purchaseRequestStatusBean",bean,request);
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../ePO/jsp/PurchaseRequestStatusQueryCriteria.jsp' frameborder=0  scrolling='auto' style='height:22%;width:100vw'></iframe><iframe name='ResultFrame' id='ResultFrame'	src='' frameborder=0 noresize scrolling='auto' style='height:64%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:6%;width:100vw'></iframe>
</html>


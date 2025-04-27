<!DOCTYPE html>
<jsp:useBean id="obj18" scope="page" class="ePO.PurchaseOrderBean"/>
<jsp:useBean id="obj19" scope="page" class="ePO.PurchaseOrderDetailBean"/>
<%@ page import=" ePO.*, ePO.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
    <script>
        function_id			=		"<%= request.getParameter("function_id")%>";
		menu_id				=		"<%= request.getParameter( "menu_id" ) %>"
		module_id			=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale				=		(String)session.getAttribute("LOCALE");
	String params				=		request.getQueryString();
	
	String bean_id				=		"purchaseOrderBean";
	String bean_name			=		"ePO.PurchaseOrderBean";

	PurchaseOrderBean bean		=		(PurchaseOrderBean) getBeanObject(bean_id,  bean_name,request);  
	bean.initialize();
	//bean.setEntity_param ((String) session.getAttribute("ACC_ENTITY_ID"));
	bean.setLanguageId(locale);

	String mode					=		request.getParameter("mode");
	String purchase_type_code	=		request.getParameter("purchase_type_code");
	String po_no				=		request.getParameter("po_no");
	String supp_code      		=  request.getParameter("supp_code");

	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.loadData(purchase_type_code, po_no);
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("purchase_type_code",purchase_type_code.trim());
		hmParameter.put("po_no",po_no.trim());
		hmParameter.put("trn_type","PO");
		
	}

	putObjectInBean(bean_id,bean,request);
%>



	<frameset rows="100,*">
		<frame name='POHeaderFrame' src="../../ePO/jsp/PurchaseOrderHeader.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		<frameset cols="25%,2%,*" id="PurchaseOrderFrmS" >
			<frame name='PODetailFrame' src="../../ePO/jsp/PurchaseOrderDetail.jsp?<%=params%>" frameborder=0 scrolling="auto"   noresize>
			<frame name='POBlankFrame' src="../../ePO/jsp/PurchaseOrderBlank.jsp" frameborder=0 scrolling="no"   noresize>
			<frame name='POListFrame' src="../../ePO/jsp/PurchaseOrderList.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		</frameset>
	</frameset>

</html> 


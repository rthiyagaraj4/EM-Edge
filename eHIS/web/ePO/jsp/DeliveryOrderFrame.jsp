<!DOCTYPE html>
<jsp:useBean id="obj18" scope="page" class="ePO.DeliveryOrderBean"/>
<jsp:useBean id="obj19" scope="page" class="ePO.DeliveryOrderDetailBean"/>
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
	<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
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
	
	String bean_id				=		"deliveryOrderBean";
	String bean_name			=		"ePO.DeliveryOrderBean";

	DeliveryOrderBean bean		=		(DeliveryOrderBean) getBeanObject(bean_id,  bean_name,request);  
	bean.initialize();
	//bean.setEntity_param ((String) session.getAttribute("ACC_ENTITY_ID"));
	bean.setLanguageId(locale);

	String mode					=		request.getParameter("mode");
	String delivery_type_code	=		request.getParameter("delivery_type_code");
	String do_no				=		request.getParameter("do_no");
	String supp_code      		=  request.getParameter("supp_code");

	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.loadData(delivery_type_code, do_no);
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("delivery_type_code",delivery_type_code.trim());
		hmParameter.put("do_no",do_no.trim());
		hmParameter.put("trn_type","PO");
		
	}

	putObjectInBean(bean_id,bean,request);
%>

<frameset rows="80,*">
		<frame name='DOHeaderFrame' src="../../ePO/jsp/DeliveryOrderHeader.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		<frameset cols="25%,2%,*" id="DeliveryOrderFrmS" >
			<frame name='DODetailFrame' src="../../ePO/jsp/DeliveryOrderDetails.jsp?<%=params%>" frameborder=0 scrolling="auto"   noresize>
			<frame name='DOBlankFrame' src="../../ePO/jsp/DeliveryOrderBlank.jsp" frameborder=0 scrolling="no"   noresize>
			<frame name='DOListFrame' src="../../ePO/jsp/DeliveryOrderList.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		</frameset>
	</frameset>

</html> 


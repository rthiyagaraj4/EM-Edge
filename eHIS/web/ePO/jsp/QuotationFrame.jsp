<!DOCTYPE html>
<jsp:useBean id="obj18" scope="page" class="ePO.QuotationBean"/>
<jsp:useBean id="obj19" scope="page" class="ePO.QuotationDetailBean"/>
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
	<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
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
	
	String bean_id				=		"quotationBean";
	String bean_name			=		"ePO.QuotationBean";

	QuotationBean bean		=		(QuotationBean) getBeanObject(bean_id,  bean_name,request);  
	bean.initialize();
	//bean.setEntity_param ((String) session.getAttribute("ACC_ENTITY_ID"));
	bean.setLanguageId(locale);

	String mode					=		request.getParameter("mode");
	String quotation_type_code		=		request.getParameter("quotation_type_code");
	String quot_no				=		request.getParameter("quotation_no");
	String supp_code      		=  request.getParameter("supp_code");
	
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.loadData(quotation_type_code, quot_no);
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("quotation_type_code",quotation_type_code.trim());
		hmParameter.put("quot_no",quot_no.trim());
		hmParameter.put("trn_type","PO");
		
	}

	putObjectInBean(bean_id,bean,request);
%>

<frameset rows="80,*">
		<frame name='QuotHeaderFrame' src="../../ePO/jsp/QuotationHeader.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		<frameset cols="25%,2%,*" id="QuotationFrmS" >
			<frame name='QuotDetailFrame' src="../../ePO/jsp/QuotationDetails.jsp?<%=params%>" frameborder=0 scrolling="auto"   noresize>
			<frame name='QuotBlankFrame' src="../../ePO/jsp/QuotationBlank.jsp" frameborder=0 scrolling="no"   noresize>
			<frame name='QuotListFrame' src="../../ePO/jsp/QuotationList.jsp?<%=params%>" frameborder=0 scrolling='no' noresize>
		</frameset>
	</frameset>

</html> 


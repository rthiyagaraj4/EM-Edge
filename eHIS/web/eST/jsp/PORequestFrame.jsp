<!DOCTYPE html>
<jsp:useBean id="obj18" scope="page" class="eST.PORequestBean"/>
<jsp:useBean id="obj19" scope="page" class="eST.PORequestDetailBean"/>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/PORequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id			=		"<%= request.getParameter("function_id")%>";
		menu_id				=		"<%= request.getParameter( "menu_id" ) %>"
		module_id			=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String params			=		request.getQueryString();

	String bean_id			=		"porequestBean";
	String bean_name		=		"eST.PORequestBean";

	PORequestBean bean		=		(PORequestBean) getBeanObject(bean_id,  bean_name,request);  
	bean.initialize();
	bean.setEntity_param ((String) session.getAttribute("ACC_ENTITY_ID"));
	bean.setLanguageId(locale);

	String mode				=		request.getParameter("mode");
	String doc_type_code	=		request.getParameter("doc_type_code");
	String doc_no			=		request.getParameter("doc_no");

	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.loadData(doc_type_code, doc_no);
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","PRQ");
		String phy_inv_id = "";
			if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				
				phy_inv_id		=	(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_SELECT2"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
<iframe name="PORequestHeaderFrame" id="PORequestHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/PORequestHeader.jsp?<%=params%>" style="height:9vh;width:100vw"></iframe><iframe name="PORequestListFrame" id="PORequestListFrame" frameborder="0" src="../../eST/jsp/PORequestList.jsp?<%=params%>" scrolling="auto"  style="height:78vh;width:100vw"></iframe><iframe name="PORequestDetailFrame" id="PORequestDetailFrame" src="../../eST/jsp/PORequestDetail.jsp?<%=params%>" frameborder="0" noresize scrolling="no" style="height:35vh;width:100vw"></iframe>
</html> 



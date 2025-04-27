<!DOCTYPE html>
 <jsp:useBean id="obj0" scope="page" class="eST.AuthorizeAtIssueStoreBean"/>
<jsp:useBean id="obj10" scope="page" class="eST.AuthorizeAtIssueStoreDetailBean"/>
<%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String params = request.getQueryString();
	String bean_id = "authorizeAtIssueStoreBean";
	String bean_name = "eST.AuthorizeAtIssueStoreBean";
	AuthorizeAtIssueStoreBean bean = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.initialize();
//	bean.setReFamily(request, response);
	String doc_type_code = request.getParameter("doc_type_code");
	String doc_no = request.getParameter("doc_no");
	String req_facility_id = request.getParameter("req_facility_id");
	try{
	bean.setReq_Facility_id(req_facility_id);
	bean.loadData(doc_type_code.trim(), doc_no.trim());
	}catch(Exception e){}
		java.util.HashMap hmParameter = new java.util.HashMap();
		hmParameter.put("facility_id",bean.getLoginFacilityId());
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","REQ");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_REQ"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
		hmParameter.clear();
		hmParameter.put("facility_id",req_facility_id);
		hmParameter.put("doc_type_code",doc_type_code.trim());
		hmParameter.put("doc_no",doc_no.trim());
		hmParameter.put("trn_type","REQ");
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_REQ"),new String[]{req_facility_id,doc_type_code.trim(),doc_no.trim(),req_facility_id,doc_type_code.trim(),doc_no.trim(),req_facility_id,doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
		
%>
<iframe name="AuthorizeAtIssueStoreHeaderFrame" id="AuthorizeAtIssueStoreHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/AuthorizeAtIssueStoreHeader.jsp?<%=params%>" style="height:12vh;width:100vw"></iframe>
<iframe name="AuthorizeAtIssueStoreListFrame" id="AuthorizeAtIssueStoreListFrame" src="../../eST/jsp/AuthorizeAtIssueStoreList.jsp?<%=params%>" frameborder="0" noresize scrolling="auto" style="height:62vh;width:100vw"></iframe>
<iframe name="AuthorizeAtIssueStoreDetailFrame" id="AuthorizeAtIssueStoreDetailFrame" frameborder="2"  scrolling="no" noresize src="../../eST/jsp/AuthorizeAtIssueStoreDetail.jsp?<%=params%>" style="height:25vh;width:100vw"></iframe>
	<%
putObjectInBean(bean_id,bean,request);
%>
</html> 


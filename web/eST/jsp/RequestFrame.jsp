<!DOCTYPE html>

<%@ page import=" eST.RequestBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/Request.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id			=		"<%= request.getParameter("function_id")%>";
		menu_id				=		"<%= request.getParameter( "menu_id" ) %>"
		module_id			=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			=		(String)session.getAttribute("LOCALE");
	String params			=		request.getQueryString();

	String bean_id			=		"requestBean";
	String bean_name		=		"eST.RequestBean";

	RequestBean bean		=		(RequestBean) getBeanObject(bean_id,  bean_name,request);  
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
		hmParameter.put("trn_type","REQ");
		String phy_inv_id = "";
		if(bean.isPhysicalInventoryProcessStartedForStore(hmParameter)) {
				phy_inv_id		=	(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_FRAME_REQ"),new String[]{bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim(),bean.getLoginFacilityId(),doc_type_code.trim(),doc_no.trim()}).get("PHY_INV_ID");
				out.println("<script>dispMess('"+phy_inv_id+"');history.go(-1);</script>");
		}	
	}
%>
<%
putObjectInBean(bean_id,bean,request);
%>
<iframe name="RequestHeaderFrame" id="RequestHeaderFrame" frameborder="0" scrolling="no" noresize src="../../eST/jsp/RequestHeader.jsp?<%=params%>" style="height:12vh;width:100vw"></iframe>
<iframe name="RequestListFrame" id="RequestListFrame" frameborder="0" src="../../eST/jsp/RequestList.jsp?<%=params%>" scrolling="auto"  style="height:64vh;width:100vw"></iframe>
<iframe name="RequestDetailFrame" id="RequestDetailFrame" src="../../eST/jsp/RequestDetail.jsp?<%=params%>" frameborder="0" noresize scrolling="no" style="height:20vh;width:100vw"></iframe>
		<!--
		* @Name - Priya
		* @Date - 21/12/2009
		* @Inc# - IN017084
		* @Desc - To avoid the duplication records display in Modify mode
		 -->
		<script>
		clearMessageFrame();
		</script>
</html> 



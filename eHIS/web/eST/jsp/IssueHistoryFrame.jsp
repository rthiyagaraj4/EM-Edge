<!DOCTYPE html>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
		<title>
		<%
		String request_by_store			=		request.getParameter("request_by_store")==null?"":request.getParameter( "request_by_store" ) ;
		String request_on_store			=		request.getParameter("request_on_store")==null?"":request.getParameter( "request_on_store" ) ; 
		String item_code				=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		String called_from              =       request.getParameter("called_from")==null?"":request.getParameter( "called_from" ) ;
		String locale			        = (String)session.getAttribute("LOCALE");
        String bean_id					=		"RequestStatusBean";
		String bean_name				=		"eST.RequestStatusBean";

		RequestStatusBean bean		    =		(RequestStatusBean) getBeanObject(bean_id,bean_name,request); 
		String store_desc               =       "";
				   
			if(called_from.equals("REQ")){
						store_desc                =bean.getStoreDesc(request_by_store);
			%>
					 Issue History. Requesting(Receiving)Store:- <%=store_desc%>
			<%}else{
						store_desc                =bean.getStoreDesc(request_by_store);
			%>
					Issue History. Request On(Issuing)Store:- <%=store_desc%>
			<%}
			%>		
		</title> 
		
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/Acknowledgment.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<%
		
		bean.setLanguageId(locale);

%>
<iframe name='frameIssHistoryResult' id='frameIssHistoryResult'	src="../../eST/jsp/IssueHistoryResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:80vh;width:100vw'></iframe>
		<iframe name='frameIssHistoryButtons' id='frameIssHistoryButtons'	src="../../eST/jsp/IssueHistoryButtons.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:10vh;width:100vw'></iframe>
	
</html>


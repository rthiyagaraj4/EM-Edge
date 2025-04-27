<!DOCTYPE html>
 <%@ page import=" eST.IssueReturnBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%		
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		IssueReturnBean bean = (IssueReturnBean)getBeanObject("issueReturnBean","eST.IssueReturnBean",request);
		bean.setLanguageId(locale);
		String index=request.getParameter("index");
%>
<html>
	<head>
	<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
		<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%=request.getParameter("function_id")%>";
			menu_id = "<%=request.getParameter("menu_id")%>"
			module_id = "<%=request.getParameter("module_id")%>"
		</script>
	</head>
	<%
putObjectInBean("issueReturnBean",bean,request);
%>

		<iframe name='frameIssueReturnListHeader' id='frameIssueReturnListHeader' src="../../eST/jsp/IssueReturnListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:52vh;width:100vw'  noresize></iframe> 
        <%if (index==null){	%>
          <iframe name='frameIssueReturnListDetail' id='frameIssueReturnListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:64vh;width:100vw'  noresize></iframe>
 	    <% 	} else { %>
		  <iframe name='frameIssueReturnListDetail' id='frameIssueReturnListDetail' src="../../eST/jsp/IssueReturnListDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:64vh;width:100vw'></iframe>
        <% } %>

</html>


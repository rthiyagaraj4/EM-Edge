<!DOCTYPE html>
 <%@ page  import=" eST.IssueBean" contentType="text/html;charset=UTF-8"%>
 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%		
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
			
		String index=request.getParameter("index");

		//Added for RUT-CRF-0079

		String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
		
		IssueBean bean						=		(IssueBean)getBeanObject( "issueBean","eST.IssueBean", request  );
		bean.setLanguageId(locale);

		boolean validatebarcode				=	bean.isBarCodeApplicableForValidation("VALIDATEBARCODE",bean.getTrn_type());
		//ended
%>
<html>
	<head>
			<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	</head>
		<iframe name='frameIssueListHeader' id='frameIssueListHeader'	src="../../eST/jsp/IssueListHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:54vh;width:100vw'  noresize></iframe>

		<%if (index==null){
			%>
		<iframe name='frameIssueListDetail' id='frameIssueListDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder=0 scrolling='no'  style='height:64vh;width:100vw'  noresize></iframe>
		<%
		}
		else{
		%>
		<iframe name='frameIssueListDetail' id='frameIssueListDetail' src="../../eST/jsp/IssueListDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:64vh;width:100vw'></iframe>
		<%
		}
		%>
		<% if(validatebarcode && mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){%>
		<iframe name='frameColorIndicator' id='frameColorIndicator' src="../../eST/jsp/BarcodeColorIndicator.jsp" frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
		<%
		}else{
		%>
		<iframe name='frameColorIndicator' id='frameColorIndicator' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>
		<%
		}
		%>

</html>
<% 
	putObjectInBean("issueBean",bean,request);
%>


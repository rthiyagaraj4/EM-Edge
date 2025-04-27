<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->	
		<%
		// request.setCharacterEncoding("UTF-8");
			
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/Item.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		String params = request.getQueryString() ;
		
	%>
<title>
		<fmt:message key="eST.ItemSearch.label" bundle="${st_labels}"/>
</title>

<iframe name='qryCriteria' id='qryCriteria' src="../../eST/jsp/ItemSearchQueryCriteria.jsp?<%=params%>" frameborder=0  scrolling='yes' style='height:30vh;width:100vw'>
</iframe><iframe name='qryResult' id='qryResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:66vh;width:100vw'></iframe>


</html>


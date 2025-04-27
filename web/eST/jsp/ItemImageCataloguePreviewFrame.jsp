<%@ page  contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<html>
<head>
		<%
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086		
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
		<fmt:message key="eST.ItemImageCatalogue.label" bundle="${st_labels}"/>
</title>

<iframe name='qryResult' id='qryResult' src='../../eCommon/html/blank.html' frameborder=0   noresize style='height:70vh;width:100vw'></iframe>
		<iframe name='qryCriteria' id='qryCriteria' src="../../eST/jsp/ItemImageCataloguePreviewList.jsp?<%=params%>" frameborder=0   style='height:30vh;width:100vw'></iframe>


</html>


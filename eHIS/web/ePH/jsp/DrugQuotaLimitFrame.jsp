<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="" %>
<html>
	<head> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/DrugQuotaLimit.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
		<iframe name='frameDrugQuotaLimitHeader' id='frameDrugQuotaLimitHeader'				src="../../ePH/jsp/DrugQuotaLimitAddModify.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:25vh;width:100vw'></iframe>
		<iframe name='frameDrugQuotaLimitDetail' id='frameDrugQuotaLimitDetail'			src="../../ePH/jsp/DrugQuotaLimitDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:75vh;width:100vw'></iframe>
		
</html>


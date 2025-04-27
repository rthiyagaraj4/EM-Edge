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
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntryByFile.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
		<iframe name='framePhysicalInventoryEntryByFileUpdateHeader' id='framePhysicalInventoryEntryByFileUpdateHeader'				src="../../eST/jsp/PhysicalInventoryEntryByFileUpdateHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:60%;width:100vw'></iframe>
		<iframe name='framePhysicalInventoryFileDetail' id='framePhysicalInventoryFileDetail'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:100vh;width:100vw'></iframe>
		
</html>


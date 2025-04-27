<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		
	</head>
	<iframe name='framePhysicalInventoryEntryApplyCriteria' id='framePhysicalInventoryEntryApplyCriteria' src="../../eST/jsp/PhysicalInventoryEntryApplyCriteria.jsp?<%=request.getQueryString()%>" frameborder=0  scrolling='no' style='height:75%;width:100vw'></iframe><iframe name='framePhysicalInventoryEntryApplyAdded' id='framePhysicalInventoryEntryApplyAdded' src='../../eSt/jsp/PhysicalInventoryEntryApplyValues.jsp?fromDB=yes&<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no'>
 -- style='height:100vh;width:100vw'></iframe><iframe name='framePhysicalInventoryEntryApplyAdd' id='framePhysicalInventoryEntryApplyAdd' src='../../eST/jsp/PhysicalInventoryEntryApplyAdd.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:130%;width:100vw'></iframe>
</html>


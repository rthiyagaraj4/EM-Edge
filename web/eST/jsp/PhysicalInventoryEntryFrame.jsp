<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="" %>
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	</head>	
<!-- 	<frameset rows='75,*'> -->
		<iframe name='PhysicalInventoryEntryHeaderFrame' id='PhysicalInventoryEntryHeaderFrame' src="../../eST/jsp/PhysicalInventoryEntryHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:20vh;width:100vw'>
		
		<iframe name='PhysicalInventoryEntryDetailFrame' id='PhysicalInventoryEntryDetailFrame' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no'   noresize style='height:85vh;width:100vw'>

 <!--<frameset rows='60,*'>  -->
 		<iframe name='framePhysicalInventoryEntryHeader' id='framePhysicalInventoryEntryHeader'	src="../../eST/jsp/PhysicalInventoryEntryHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:12vh;width:100vw'></iframe>
 	<!--	<frameset cols="30%,*" > -->
		<!--	</frameset>
		</frameset>  -->
		<iframe name='framePhysicalInventoryDetail' id='framePhysicalInventoryDetail' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder="0" scrolling='auto' noresize style='width: 24vw; height: 74vh;'></iframe>

		<iframe name='framePhysicalInventoryEntryList' id='framePhysicalInventoryEntryList' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" frameborder="0" scrolling='auto' noresize style='width: 74vw; height: 74vh;'></iframe>
		
</html>

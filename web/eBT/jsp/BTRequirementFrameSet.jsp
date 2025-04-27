<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBT.*, java.sql.*, java.text.*,java.util.*"  contentType="text/html; charset=UTF-8"%>

<HTML>
<%	request.setCharacterEncoding("UTF-8");	%>
<HEAD>  
<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requirement.label","common_labels")%></title>
</HEAD>
<!--<TITLE>Patient Requirements</TITLE>-->

<iframe src="../../eBT/jsp/BTRequirementDtls.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="blood_transfusion" id="blood_transfusion" NORESIZE style="height:95vh;width:100vw"></iframe>
	<iframe src="../../eBT/jsp/BTcloseButton.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no"  NORESIZE style="height:5vh;width:100vw"></iframe>

</HTML>


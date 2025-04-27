<!DOCTYPE html>
<%@page import="eBT.*, java.sql.*, java.text.*,java.util.*"  contentType="text/html; charset=UTF-8"%>


<HTML>
<%	request.setCharacterEncoding("UTF-8");	%>
<HEAD>   
<!--<TITLE>Patient Antibodies</TITLE>-->
<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBT.PatientAntibody.label","bt_labels")%></title>
</HEAD>
 <%	request.setCharacterEncoding("UTF-8");	%>
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<iframe src="../../eBT/jsp/BTAntiBodyDtls.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="blood_transfusion" id="blood_transfusion" NORESIZE style="height:95vh;width:100vw"></iframe>	
<iframe src="../../eBT/jsp/BTcloseButton.jsp" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="no"  NORESIZE style="height:5vh;width:100vw"></iframe>

</HTML>


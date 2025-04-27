<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params			= request.getQueryString() ;
%>
<iframe name="f_drugs" id="f_drugs" frameborder="0" scrolling="auto"  noresize src="../../ePH/jsp/IVAmendDrugs.jsp?<%=params%>"  style="height:81vh;width:100vw"></iframe><iframe name="f_legends" id="f_legends" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionLegends.jsp" style="height:19vh;width:100vw"></iframe>

</HTML>


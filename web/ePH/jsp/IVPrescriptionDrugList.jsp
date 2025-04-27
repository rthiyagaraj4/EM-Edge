<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>

<%

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params			= request.getQueryString() ;
%>
<iframe name="f_drugs" id="f_drugs" frameborder="0" scrolling="auto"  noresize src="../../ePH/jsp/IVPrescriptionDrugs.jsp?<%=params%>"  style="height:58vh;width:97vw"></iframe>
<iframe name="f_legends" id="f_legends" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionLegends.jsp" style="height:20vh;width:97vw"></iframe>

</HTML>


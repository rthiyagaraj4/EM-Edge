<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"  import=" ePH.*,ePH.Common.*,eCommon.XSSRequestWrapper"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<% request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
%>
<title>CIMS Lookup</title>
 
	<iframe name='frameCIMSDetail' id='frameCIMSDetail' src="../../ePH/jsp/CIMSLookupResult.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:100vh;width:100vw'></iframe>
	
</html>


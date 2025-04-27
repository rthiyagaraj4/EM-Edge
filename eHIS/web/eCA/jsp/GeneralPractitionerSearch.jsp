<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import =" java.sql.*, java.text.*, webbeans.eCommon.*, java.util.* , javax.servlet.http.* "  %>

<%
request.setCharacterEncoding("UTF-8");
String queryString=request.getQueryString();
%>

<title><fmt:message key="eCA.TaggedPractitioner.label" bundle="${ca_labels}"/></title>
<iframe name='criteria_frame' id='criteria_frame' src="../../eCA/jsp/GeneralPractitionerSearchCriteria.jsp?<%=queryString%>" noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=no frameborder='0' style='height:25%;width:100vw'></iframe><iframe name='result_frame' id='result_frame'    src="../../eCA/jsp/GeneralPractitionerSearchResult.jsp?<%=queryString%>"  noresize  scrolling=no frameborder=no marginheight=0 marginwidth=0 frameborder='0' style='height:100vh;width:100vw'></iframe><iframe name='close_frame' id='close_frame' src="../../eAM/jsp/GeneralPractitionerClose.jsp" noresize  frameborder=no marginheight=0 marginwidth=0 frameborder='0' style='height:7%;width:100vw'></iframe>
</html>


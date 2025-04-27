<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<title>Drug Abuse Detail</title>
</head>
<%
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params = request.getQueryString() ; 
	String source = "../../ePH/jsp/PrescriptionAbuseDetails.jsp?"+params;
%>
<iframe name='f_pres_allergy' id='f_pres_allergy'  frameborder="0" scrolling='auto' noresize src="<%= source %>" style='height:85vh;width:100vw'></iframe><iframe name="f_pres_close" id="f_pres_close" src="../../ePH/jsp/PrescriptionClose.jsp?called_from=abuse&<%=params%>" frameborder="0" noresize scrolling="no" style="height:15vh;width:100vw"></iframe> 
</html> 


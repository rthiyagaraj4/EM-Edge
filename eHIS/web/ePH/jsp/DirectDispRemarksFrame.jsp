<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></title>
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String params = request.getQueryString() ;
%>
<iframe name="remarks_detail" id="remarks_detail" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DirectDispRemarks.jsp?<%=params%>"" style="height:58vh;width:100vw"></iframe>
<iframe name="remarks_close" id="remarks_close" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DirectDispClose.jsp?called_from=remarks" style="height:10vh;width:100vw"></iframe>

</html>



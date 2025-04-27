<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<html>
<title id="lookup_title">Practitioner Lookup</title>
<iframe name="lookup_head" id="lookup_head" src="../../eCA/jsp/RecClinicalNotesForwardPractCriteria.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:17%;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?<%=request.getQueryString()%>"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style="height:100vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eCA/jsp/RecClinicalNotesForwardPractCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10%;width:100vw"></iframe>
</html>


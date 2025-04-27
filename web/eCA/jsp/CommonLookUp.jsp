<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title id="lookup_title"><%=request.getParameter( "title" )%></title>

<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String MAST_TYPE_REF = request.getParameter("MAST_TYPE_REF" );	
	if (MAST_TYPE_REF==null) MAST_TYPE_REF="";

%>
<iframe name="lookup_head" id="lookup_head" src="../../eCA/jsp/CommonLookUpSearchCriteria.jsp?<%=request.getQueryString()%>" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:17vh;width:98vw"></iframe>
<iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style="height:73vh;width:98vw"></iframe>
<iframe name="lookup_cancel" id="lookup_cancel" src="../../eCA/jsp/CommonLookUpCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:98vw"></iframe>

</html>


<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title id="lookup_title"><%=request.getParameter( "title" )%></title>
<!-- <iframe name="lookup_head" id="lookup_head" src="../../eCommon/jsp/CommonLookupSearchCriteria.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:17%;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0" style="height:100vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eCommon/jsp/CommonLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10%;width:100vw"></iframe> -->
<frameset rows="17%,*,10%" >
	<frame name="lookup_head" id="lookup_head" src="../../eCP/jsp/GCPGenerateCarePlan3.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0">
	<!--<frame name="lookup_detail" id="lookup_detail"    src="../../eCP/jsp/GCPGenerateCarePlan1.jsp"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0"> -->
	 <frame name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="no" frameborder="no" marginheight="0" marginwidth="0">  
	<frame name="lookup_cancel" id="lookup_cancel" src="../../eCommon/jsp/CommonLookupCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0">
	
</frameset> 


</html>


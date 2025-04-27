<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%  
	String facility_id  = (String) session.getValue("facility_id");

	String params = request.getQueryString()+"&facility_id="+facility_id;
	
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String source = url + params ;
%>
	<script language="JavaScript" src="../../eOT/js/WaitList.js"></script>
<!-- 	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
 -->
 <iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw" frameborder='0'></iframe>
 <iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eOT/jsp/RescheduleFrm.jsp?<%= params %>" style="height:83vh;width:100vw" frameborder='0'></iframe>
 <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='no' style='height:9vh;width:100vw' frameborder='0'></iframe>


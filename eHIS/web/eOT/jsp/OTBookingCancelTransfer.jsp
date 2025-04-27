<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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

<script language="JavaScript" src="../../eOT/js/CancelTransfer.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" frameborder='0' noresize src="<%= source %>" style="height:7vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize frameborder='0' src="../../eOT/jsp/CancelTransferFrm.jsp?<%= params %>" style="height:83vh;width:100vw"></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='no' style='height:9vh;width:100vw'></iframe>



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

<html>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOT/js/WaitList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>
<form name='hideForm1' id='hideForm1'>
<input type='hidden' name='qury' id='qury' value='<%=source%>'>
<input type='hidden' name='Slate_Booking_Verification' id='Slate_Booking_Verification' value='BOOKING_VER_TAB'>
</form>
<!--<frameset rows='42,*,50'>-->
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style='height:6vh;width:100vw'></iframe>
	<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/VerificationFrame.jsp?<%= params %>" style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
<!--</frameset>-->
</html>


<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%  
	String facility_id  = (String) session.getValue("facility_id");

	String params = request.getQueryString()+"&facility_id="+facility_id;
	
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String source = url + params ;
%>

<script type="text/javascript" src="../../eOT/js/CancelTransfer.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->

<iframe name="commontoolbarFrame1" id="commontoolbarFrame1"  scrolling="no" noresize src="../../eOT/jsp/InitSetup.jsp" style="height:0vh;width:100vw"></iframe>
<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" scrolling="no" noresize src="../../eOT/jsp/RescheduleFrm.jsp?<%= params %>" style="height:83vh;width:100vw"></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='no' style='height:9vh;width:100vw'></iframe>




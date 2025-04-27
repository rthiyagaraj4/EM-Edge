<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString()+"&facility_id="+facility_id;	
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String source = url + params ;
%>
<html>
<form name='hideForm1' id='hideForm1'>
<input type='hidden' name='qury' id='qury' value='<%=source%>'>
<script src="../../eOT/js/InteractiveOperRegQuery.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</form>

<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:10vh;width:100vw" frameborder='0'></iframe>
<iframe name="interacive_query_hdr" id="interacive_query_hdr"  scrolling="no" noresize src="../../eOT/jsp/InteractiveOperRegQuerySearch.jsp?<%=params%>" style="height:40vh;width:100vw" frameborder='0'></iframe>
<iframe name="interacive_query_dtl" id="interacive_query_dtl"  scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:40vh;width:100vw" frameborder='0'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='no' style='height:9vh;width:100vw' frameborder='0'></iframe>
<iframe name='dummy_frame' id='dummy_frame' src="../../eCommon/html/blank.html"  noresize scrolling='no' style='height:0vh;width:100vw' frameborder='0'></iframe>
</html>


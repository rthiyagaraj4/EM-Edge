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


<script language="JavaScript" src="../../eOT/js/BookingQuery.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<html>
<form name='hideForm1' id='hideForm1'>
<input type='hidden' name='qury' id='qury' value='<%=source%>'>
</form>

<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:7vh;width:100vw" frameborder='0'></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" scrolling="no" noresize src="../../eOT/jsp/BookingQueryFrame.jsp?<%=params%>" style="height:83vh;width:100vw" frameborder='0'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='no' style='height:9vh;width:100vw' frameborder='0'></iframe>
</html>


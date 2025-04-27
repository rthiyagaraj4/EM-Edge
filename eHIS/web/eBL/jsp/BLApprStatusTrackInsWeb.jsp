<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString();
%>

<html>
<title><%=request.getParameter("title")%></title>
<iframe name="lookup_head" id="lookup_head" src="../../eBL/jsp/BLApprStatusTrackInsWebSearch.jsp?<%=params%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:17vh;width:100vw"></iframe>
<iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:73vh;width:100vw"></iframe>
<iframe name="lookup_cancel" id="lookup_cancel" src="../../eCommon/html/blank.html" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>


</html>


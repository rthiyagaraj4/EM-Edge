<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<frameset rows='35%,60%'>
<frame name='commontoolbarFrame' id='commontoolbarFrame' 		src="../../eOT/jsp/PickListReviewFrame.jsp" frameborder=0  scrolling='no' nowrap>
<frame name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/PickListReviewItemFrame.jsp?<%=request.getQueryString()%>" frameborder=0>
</frameset>
</html>


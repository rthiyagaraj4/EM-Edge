<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' 		src="../../eOT/jsp/SurgicalAccessoriesPicklistTabs.jsp?<%=request.getQueryString()%>" noresize  scrolling='no' nowrap style='height:12vh;width:100vw'></iframe>
<iframe name='f_query_add_mode' id='f_query_add_mode' 		src="../../eOT/jsp/PickListReviewItemSelect.jsp?<%=request.getQueryString()%>" noresize   scrolling='no' nowrap style='height:50vh;width:100vw'></iframe>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" style='height:38vh;width:100vw'></iframe>

</html>


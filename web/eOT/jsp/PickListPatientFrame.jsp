<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<iframe name='message_search_frame' id='message_search_frame'	 src='../../eOT/jsp/PickGenPatientDtl.jsp'  style='height:30vh;width:100vw'></iframe>
<iframe name='detailframe' id='detailframe' 		src="../../eOT/jsp/WaitListProcedureFrame.jsp?<%=request.getQueryString()%>"  scrolling='no' nowrap style='height:70vh;width:100vw'></iframe>


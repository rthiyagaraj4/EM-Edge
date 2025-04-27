<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<TITLE><fmt:message key="eOT.WaitListDetails.Label" bundle="${ot_labels}"/></TITLE>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/WaitListDetail.jsp?<%=request.getQueryString()%>"   scrolling='no' style='height:30vh;width:100vw'></iframe>
<iframe name='detailframe' id='detailframe' 		src="../../eOT/jsp/WaitListProcedureFrame.jsp?<%=request.getQueryString()%>"  scrolling='yes' nowrap style='height:70vh;width:100vw'></iframe>


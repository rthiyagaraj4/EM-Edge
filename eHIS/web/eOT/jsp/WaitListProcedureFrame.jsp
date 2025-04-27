<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<iframe name='message_search_frame' id='message_search_frame'	 src='../../eOT/jsp/ProcedureHdrLegend.jsp'  scrolling='no'   style='height:4vh;width:100vw'></iframe>
<iframe name='detailframe' id='detailframe' 		src="../../eOT/jsp/WaitListProcedureDtl.jsp?<%=request.getQueryString()%>"  scrolling='yes' nowrap style='height:96vh;width:100vw'></iframe>


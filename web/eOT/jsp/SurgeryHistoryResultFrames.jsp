
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%  String params = request.getQueryString(); %>


	<!-- <FRAME name='ColumnHdrFrame' id='ColumnHdrFrame' SRC='../../eOT/jsp/PatientHistoryTitle.jsp'  scrolling='auto' noresize></FRAME>	 -->
	<iframe name='SearchResultsFrame' id='SearchResultsFrame' SRC='../../eOT/jsp/SurgeryHistoryQryResults.jsp?<%=params%>' scrolling='auto' noresize style="height:70vh;width:99vw;border:0"></iframe>
	<iframe name='ColorIndicatorFrame' id='ColorIndicatorFrame' SRC='../../eOT/jsp/StatusColorIndicator.jsp?<%=params%>' scrolling='no' noresize style="height:20vh;width:99vw;border:0"></iframe>



<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>

<%  String params = request.getQueryString(); %>
 <iframe name='ColumnHdrFrame' id='ColumnHdrFrame' SRC='../../eOT/jsp/AT_AnaesthesiaHistoryQryResultTitle.jsp'  scrolling='no' noresize style='height:0vh;width:97vw;border=0' frameborder='0'></iframe>	
	<iframe name='SearchResultsFrame' id='SearchResultsFrame' SRC='../../eOT/jsp/AT_AnaesthesiaHistoryQryResults.jsp?<%=params%>' scrolling='auto' noresize style='height:75vh;width:97vw;border=0'  frameborder='0'></iframe>
	<iframe name='ColorIndicatorFrame' id='ColorIndicatorFrame' SRC='../../eOT/jsp/AT_AnaesthesiaColorInd.jsp?' scrolling='no' noresize style='height:15vh;width:97vw;border=0'  frameborder='0'></iframe>



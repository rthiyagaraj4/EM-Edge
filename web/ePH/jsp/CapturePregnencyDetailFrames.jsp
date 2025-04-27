<!DOCTYPE html>
 <HTML>
<%
    String mode = request.getParameter("mode");
	String params = request.getQueryString() ;
	String url = "../../ePH/jsp/CapturePregnencyDetailCriteria.jsp?mode="+mode+"&params="+params;//added for CRF-PH- RUT-CRF-0063/01 Null [IN:040486]
	String source = url +"?"+ params ;
%>
	<!-- <frameset rows="10%,90%">-->
		<iframe name="f_query_criteria" id="f_query_criteria" frameborder="0" scrolling="no" noresize src="<%=source%>" style="height:10vh;width:100vw"></iframe>
		<iframe name="f_query_result" id="f_query_result" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:90vh;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/MstCodeError.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:0vh;width:100vw"></iframe>
	<!-- </frameset> -->
</HTML>


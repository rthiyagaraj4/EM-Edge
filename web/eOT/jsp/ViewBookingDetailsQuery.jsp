<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String params = request.getQueryString();
	String source="../../eCommon/jsp/commonToolbar.jsp?"+params;
	String title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
%>
<TITLE><%=title%></TITLE>
<!--
commented by bshankar on 13062005.
<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="no" noresize src="<%= source %>" style="height:5vh;width:100vw"></iframe>
<iframe name='header_frame' id='header_frame' 		src="../../eOT/jsp/BookingDetail.jsp?< %=request.getQueryString()% >"   scrolling="no"  nowrap style='height:29vh;width:100vw'></iframe>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/BookingProcedureFrame.jsp?< %=request.getQueryString()% >"   style='height:57vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize  style='height:9vh;width:100vw'></iframe> -->

<iframe name='header_frame' id='header_frame' 		src="../../eOT/jsp/BookingDetailFrame.jsp?<%=request.getQueryString()%>"   scrolling="no"  nowrap style='height:95vh;width:95vw'></iframe> 
</html>


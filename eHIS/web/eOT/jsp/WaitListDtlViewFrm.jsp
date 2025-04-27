<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%
String source="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT";
String menu_reqd_yn=request.getParameter("menu_required");
String title="WaitList Details";
%>

<TITLE><%=title%></TITLE>
<%
if(menu_reqd_yn.equals("N")){
%>
<iframe name='header_frame' id='header_frame' 		src="../../eOT/jsp/WaitListDtlView.jsp?<%=request.getQueryString()%>"   nowrap style='height:22vh;width:100vw'></iframe>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/WaitListProcedureDtl.jsp?<%=request.getQueryString()%>"    style='height:48vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize  style='height:10vh;width:100vw'></iframe>
<%}else{%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:6vh;width:100vw"></iframe>
<iframe name='header_frame' id='header_frame' 		src="../../eOT/jsp/WaitListDtlView.jsp?<%=request.getQueryString()%>"   nowrap style='height:22vh;width:100vw'></iframe>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/WaitListProcedureDtl.jsp?<%=request.getQueryString()%>"    style='height:48vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize  style='height:13vh;width:100vw'></iframe>
<%}%>
</html>


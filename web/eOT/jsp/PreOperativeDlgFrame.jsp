<!DOCTYPE html>
<%//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eOT.*,eOT.Common.OTRepository,eCommon.Common.CommonBean"%>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script type='text/javascript' src='../../eOT/js/PreOperative.js'></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script type='text/javascript' src='../../eOT/js/OTMessages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->


<%
String source="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=NYNNY&home_required_yn=N";


String title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LinkPreOperativeOrders.Label","ot_labels");
String param=request.getQueryString();

%>

<TITLE><%=title%></TITLE>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="no" noresize src="<%= source %>" style="height:4vh;width:100vw"></iframe>
<iframe name='header_frame' id='header_frame' 		src="../../eOT/jsp/PreOperativeSearch.jsp?<%=param%>"    nowrap style='height:20vh;width:100vw'></iframe>
<iframe name='message_search_frame' id='message_search_frame'	 src="../../eCommon/html/blank.html"   style='height:60vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='no' style='height:13vh;width:100vw'></iframe>


</html>


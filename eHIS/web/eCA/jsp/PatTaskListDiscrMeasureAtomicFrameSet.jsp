<!DOCTYPE html>
<%@ page  import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String resultType= request.getParameter("resultType")==null ? "" :request.getParameter("resultType");
out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PerformedDetails.label","ca_labels")+"</title>");
String scrolling = "";
String rows="";
if(resultType.equals("DP"))
{
		scrolling="auto";
		rows="26%,*,0%";
}
else
{
			scrolling="no";
			rows="33%,*,0%";
}
%>
<frameset rows='<%=rows%>'>
<frame src='../../eCA/jsp/PatTaskListDiscrMeasureAtomicTop.jsp?<%=request.getQueryString()%>' noresize scrolling ='no' name='patTaskListDiscreteTopFrame' frameborder='0'>
<frame src='../../eCommon/html/blank.html' noresize scrolling ='<%=scrolling%>' name='patTaskListDiscreteFrame' frameborder='0'>
<frame src='../../eCommon/jsp/MstCodeError.jsp' noresize scrolling ='no' name='messageFrame' id='messageFrame' >
</frameset>
</html>


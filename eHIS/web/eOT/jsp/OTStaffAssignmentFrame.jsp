<!DOCTYPE html>
<%-- JSP Page specific attributes start  --%>
<%@ page import ="eOT.OTStaffAssignBean,java.util.ArrayList,java.util.HashMap" %>  
<%@ page import=  "java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*" %>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>

<%

	int allCount = 0;
	int roomCount = 0;
	String param = request.getQueryString();
	String chkedValues = request.getParameter("chkedValues") == null ? "" : request.getParameter("chkedValues");
	String bean_id	 = "OTStaffAssignBean";
	String bean_name = "eOT.OTStaffAssignBean";
	OTStaffAssignBean bean	 = (OTStaffAssignBean)mh.getBeanObject( bean_id, request, bean_name );
	allCount = bean.getAssignedStaffDtlsAllCount("All", "");
	roomCount = bean.getAssignedStaffDtlsAllCount("Room", chkedValues);

	if(allCount > 0)
	{
		String param0 = param + "&frameName=All&staffAssignment=Y&dyc=n";
		String param1 = param + "&frameName=Room"+"&staffAssignment=N&dyc=n";
		if(roomCount > 0)
		{
%>
		<iframe name='staffAssignmentDateFilter0' id='staffAssignmentDateFilter0' src="../../eOT/jsp/OTStaffAssignment.jsp?<%=param0%>" frameborder=0 noresize style='height:52%;width:100vw'></iframe>
			<iframe name='staffAssignmentDateFilter1' id='staffAssignmentDateFilter1' src="../../eOT/jsp/OTStaffAssignment.jsp?<%=param1%>" frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
		
<%
	}
	else
	{
			param0 = param0 + "&roomCount="+roomCount;
%>
			<frameset>
				<frame name='staffAssignmentDateFilter0' id='staffAssignmentDateFilter0' src="../../eOT/jsp/OTStaffAssignment.jsp?<%=param0%>" frameborder=0 noresize>
			</frameset>
<%
		}
	}
	else
	{
		String param1 = param + "&frameName=Room"+"&staffAssignment=Y&dyc=y"+"&allCount="+allCount;
%>
		<frameset>
			<frame name='staffAssignmentDateFilter0' id='staffAssignmentDateFilter0' src="../../eOT/jsp/OTStaffAssignment.jsp?<%=param1%>" frameborder=0 noresize>
		</frameset>
<%
	}
%>
</html>


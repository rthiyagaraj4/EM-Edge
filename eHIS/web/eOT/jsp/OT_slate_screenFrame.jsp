<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<HEAD>

		<script> 
			function closeHelp()
			{  
				var key = event.keyCode; 
				if (key == 27)
				{
					if(parent.parent.opener != null)
						parent.parent.opener.closeDashboard();
					else
						window.close();	
				}
			} 	
		</script>
			
</HEAD>
<%
String frameCount = request.getParameter("frameCount") == null ? "0" : request.getParameter("frameCount");
%>

<title> Widget Selection </title>
<%
	String param = request.getQueryString();
	String param0 = "";
	String param1 = "";
	String param2 = "";

	String staffAssignmentId = request.getParameter("staffAssignmentId") == null ? "" : request.getParameter("staffAssignmentId");

	if(param.indexOf("~~") == -1)
	{
		if(param.indexOf("~") != -1)
		{
			param0 = param.substring(0, param.indexOf("~"));
			param1 = param.substring(param.indexOf("~")+1, param.length());
			
		}
	}
	else if(param.indexOf("~~") != -1)
	{
		param0 = param.substring(0, param.indexOf("~"));
		param1 = param.substring(param.indexOf("~")+1, param.indexOf("~~"));
		param2 = param.substring(param.indexOf("~~")+2, param.length());
		
	}
%>

<%
	if(Integer.parseInt(frameCount) == 1)
	{
%>
		<frameset  border='0px' rows='48px,*' onkeypress="closeHelp()">
			<frame name='header0' src="../../eOT/jsp/OT_slate_screenHeader.jsp?<%=param0%>" frameborder=0 noresize>
<%
				if(staffAssignmentId != null && !staffAssignmentId.equals("Y"))
				{
%>
					<frame  name='dateFilter0' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param%>&class=columnone_slotone" frameborder=0 noresize>
<%					
				}
				else
				{ 
%>				
					<frameset cols='50%,*' border='2px'>
						<frame name='dateFilter0' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param%>&class=columntwo_slotone" frameborder=0 noresize>
						<frame name='staffAssign0' src="../../eOT/jsp/OTStaffAssignmentFrame.jsp?<%=param%>" frameborder=0 noresize>
					</frameset>
<%
				}
%>
		</frameset>
<%
	}
	else if(Integer.parseInt(frameCount) == 2)
	{
%>
		<frameset border='0px'  rows='48px,*' onkeypress="closeHelp()">
			<frame name='header0' src="../../eOT/jsp/OT_slate_screenHeader.jsp?<%=param0%>" frameborder=0 noresize>
<%
				if(staffAssignmentId != null && !staffAssignmentId.equals("Y"))
				{
%>
					<frameset cols='50%,*'>
						<frame name='dateFilter0' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param0%>&class=columntwo_slotone" frameborder=0 noresize>
						<frame name='dateFilter1' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param1%>&class=columntwo_slotone" frameborder=0 noresize>
					</frameset>
<%
				}
				else
				{
%>
					<frameset cols='33%,*,*'>
						<frame name='dateFilter0' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param0%>&class=slotone" frameborder=0 noresize>
						<frame name='dateFilter1' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param1%>&class=slottwo" frameborder=0 noresize>
						<frame name='staffAssign0' src="../../eOT/jsp/OTStaffAssignmentFrame.jsp?<%=param%>" frameborder=0 noresize>
					</frameset>
<%
				}
%>
		</frameset>
<%
	}
	else if(Integer.parseInt(frameCount) == 3)
	{
%>
		<frameset border='0px'  rows='48px,*' onkeypress="closeHelp()">
			<frame name='header0' src="../../eOT/jsp/OT_slate_screenHeader.jsp?<%=param0%>" frameborder=0 noresize>
			<frameset cols='33%,*,*'>
				<frame name='dateFilter0' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param0%>&class=slotone" frameborder=0 noresize>
				<frame name='dateFilter1' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param1%>&class=slottwo" frameborder=0 noresize>
				<frame name='dateFilter2' src="../../eOT/jsp/OT_slate_screen.jsp?<%=param2%>&class=slotthree" frameborder=0 noresize>
			</frameset>
		</frameset>
<%
	}
	else if(Integer.parseInt(frameCount) > 3)
	{
		String roomParam0 = "";
		String roomParam1 = "";
		String roomParam2 = "";
		param0 = "";
		param1 = "";
		param2 = "";
		int roomCntProc = 0;
		int rc1, rc2, rc3 = 0;
		int roomDispCalc = 0;
		roomDispCalc = (staffAssignmentId != null && !staffAssignmentId.equals("Y")) ? 3 : 2;
		String chkedValues = request.getParameter("chkedValues") == null ? "" : request.getParameter("chkedValues");
		String[] chkedValuesArr = chkedValues.split(",");
		
		rc1 = chkedValuesArr.length / roomDispCalc;
		if(staffAssignmentId != null && staffAssignmentId.equals("Y"))
			rc2 = (chkedValuesArr.length / roomDispCalc) + (chkedValuesArr.length % roomDispCalc);
		else
		{
			rc2 = rc1;
			rc3 = chkedValuesArr.length - rc1 - rc2;
		}
		for(roomCntProc = 0; roomCntProc < rc1; roomCntProc++)
			param0 += chkedValuesArr[roomCntProc] + ",";
		if(staffAssignmentId != null && staffAssignmentId.equals("Y"))
		{
			for(int a=0; a<rc2; roomCntProc++,a++)
				param1 += chkedValuesArr[roomCntProc] + ",";
		}
		else
		{
			for(int a=0; a<rc2; roomCntProc++,a++)
				param1 += chkedValuesArr[roomCntProc] + ",";
			for(int a=0; a<rc3; roomCntProc++,a++)
				param2 += chkedValuesArr[roomCntProc] + ",";
		}
		if(param0 != null && param0.trim().length() > 0)
			param0 = param0.substring(0, param0.length()-1);
		if(param1 != null && param1.trim().length() > 0)
			param1 = param1.substring(0, param1.length()-1);
		if(param2 != null && param2.trim().length() > 0)
			param2 = param2.substring(0, param2.length()-1);
		roomParam0 = param + "&roomDispVals="+param0 + "&roomDispCalc="+roomDispCalc + "&frameName=room1";
		roomParam1 = param + "&roomDispVals="+param1 + "&roomDispCalc="+roomDispCalc + "&frameName=room2";
		roomParam2 = param + "&roomDispVals="+param2 + "&roomDispCalc="+roomDispCalc + "&frameName=room3";
%>
		<frameset border='0px'  rows='48px,*' onkeypress="closeHelp()">
			<frame name='header0' src="../../eOT/jsp/OT_slate_screenHeader.jsp?<%=param0%>" frameborder=0 noresize>
<%
				if(staffAssignmentId != null && !staffAssignmentId.equals("Y"))
				{
%>
					<frameset cols='33%,*,*'>
						<frame name='dateFilter0' src="../../eOT/jsp/OTSlateScreenMultiple.jsp?<%=roomParam0%>&class=slotone" frameborder=0 noresize>
						<frame name='dateFilter1' src="../../eOT/jsp/OTSlateScreenMultiple.jsp?<%=roomParam1%>&class=slottwo" frameborder=0 noresize>
						<frame name='dateFilter2' src="../../eOT/jsp/OTSlateScreenMultiple.jsp?<%=roomParam2%>&class=slotthree" frameborder=0 noresize>
					</frameset>
<%
				}
				else
				{
%>
					<frameset cols='33%,*,*'>
						<frame name='dateFilter0' src="../../eOT/jsp/OTSlateScreenMultiple.jsp?<%=roomParam0%>&class=slotone" frameborder=0 noresize>
						<frame name='dateFilter1' src="../../eOT/jsp/OTSlateScreenMultiple.jsp?<%=roomParam1%>&class=slottwo" frameborder=0 noresize>
						<frame name='staffAssign0' src="../../eOT/jsp/OTStaffAssignmentFrame.jsp?<%=param%>" frameborder=0 noresize>
					</frameset>
<%
				}
%>
		</frameset>
<%
	}
	else
	{
%>
		<frameset border='0px' rows='48px,*'>
			<frame name='header0' src="../../eOT/jsp/OT_slate_screenHeader.jsp?<%=param0%>" frameborder=0 noresize>
			<frame name='staffAssign0' src="../../eOT/jsp/OTStaffAssignmentFrame.jsp?<%=param%>" frameborder=0 noresize>
		</frameset>
		<%
	}
%>
</html>

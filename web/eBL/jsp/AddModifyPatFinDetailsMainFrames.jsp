<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	try
	{
		String frame_size="";

		String strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";

		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "";

		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

		String package_flag =request.getParameter("package_flag");		

		if((package_flag == null)||package_flag.equals("null"))package_flag="N";

		if(package_flag.equals("Y"))
			frame_size="15%,75%,0%,0%,0%,0%";
		else
			frame_size="35%,65%,0%,0,0%,0%";
%>			
<html>
	<frameset rows="<%=frame_size%>" framespacing=0>
			<FRAME SRC="AddModifyPatFinDetails.jsp?<%= strAllParam%>" name='MainFrame1' frameborder=0 scrolling='auto' noresize>
<%
				if((billing_mode.equals("Modify")) || (operation.equals("Update")))
				{
%>
			<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='MainFrame2' id='MainFrame2' scrolling='no' noresize>
<%
				}	
				else
				{
%>
			<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='MainFrame2' id='MainFrame2' scrolling='no' noresize>
		
<%
				}
%>
			<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' id='DummyFrame' scrolling='no' noresize>
			<FRAME SRC="BLValidation.jsp" frameborder=0 name='ValidFrame' id='ValidFrame' scrolling='yes' noresize>
	</frameset>
<%
	}
	catch(Exception eX)
	{
		System.out.println("Error in QryMain.jsp= "+eX);
	}
%>
</html>


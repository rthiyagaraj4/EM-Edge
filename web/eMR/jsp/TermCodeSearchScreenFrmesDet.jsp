<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String diag_code=request.getParameter("p_diag_code");
		
		String url="";
			if(diag_code.equals("1"))
				url="TermCodeSearchScreen1.jsp?"+request.getQueryString();
			else
				url="CAAssIcd2.jsp?"+request.getQueryString();
		%>
			<frameset cols='30%,30%' rows='45%,45%' frameborder=2 BORDERCOLOR='black'  >
				<frame src='<%=url%>' name='scrn1' noresize style="border-style: solid; border-color: black;border-width:3">
				<frame src='../../eCommon/html/blank.html' name='scrn2' id='scrn2' noresize style="border-style: solid; border-color: black;border-width:3">
				<frame src='../../eCommon/html/blank.html' name='scrn3' id='scrn3' noresize style="border-style: solid; border-color: black;border-width:3">
				<frame src='../../eCommon/html/blank.html' name='scrn4' id='scrn4' noresize style="border-style: solid; border-color: black;border-width:3">
		</frameset>		
	</head>	
</html>


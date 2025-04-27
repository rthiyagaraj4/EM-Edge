<!DOCTYPE html>

<!--
	Developed by 	:	R.Nanda Kumar 
	Created on 	:	26/02/2001
	Module		:	OA
	Function	:	
-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
	String p_disp		= request.getParameter("disp") ;
	String p_clinic_code	= request.getParameter("clinic_code") ;
	String p_pract_id	= request.getParameter("pract_id") ;
	String p_day_no		= request.getParameter("day_no") ;

	if (p_disp == null)
		p_disp = "" ;

	if (p_clinic_code == null)
		p_clinic_code = "" ;

	if (p_pract_id == null)
		p_pract_id = "" ;

	if (p_day_no == null)
		p_day_no = "" ;

%>



<html>
<iframe name='breaktime' id='breaktime' src='../../eOA/jsp/TimeTableBreak.jsp?disp=<%=p_disp%>&clinic_code=<%=p_clinic_code%>&pract_id=<%=p_pract_id%>&day_no=<%=p_day_no%>' frameborder=0 noresize scrolling=no style='height:50vh;width:50vw'></iframe>
</html>


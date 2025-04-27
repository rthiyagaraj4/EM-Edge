<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<% 
	request.setCharacterEncoding("UTF-8");
	String view= request.getParameter("view");
	if(view == null) view="";
	//Added for Maintain birth Register and verification on 27/8/2002 by kumar
	String function_id = request.getParameter("function_id");
	if (function_id==null) function_id = "";
	//End of addition
	String jsp_name = request.getParameter("jsp_name");
	if (jsp_name==null) jsp_name = "";
	String func_idpassed = request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");
	
%>

<html>
<title> <fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/> </title>

					
			<iframe name='commontoolbar' id='commontoolbar' src='../../eMP/jsp/BirthRegisterToolBar.jsp' frameborder=0 noresize=noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
			<iframe name='criteria' id='criteria' src='../../eMP/jsp/ViewBirthRegisterCriteria.jsp?view=<%=view%>&function_id=<%=function_id%>&jsp_name=<%=jsp_name%>&func_idpassed=<%=func_idpassed%>' noresize=noresize frameborder=0  scrolling='no' style='height:40vh;width:100vw'></iframe>
			<iframe name='search_toolbar' id='search_toolbar' src='../../eMP/jsp/ViewBirthSearchToolbar.jsp' noresize=noresize frameborder=0 scrolling='no' style='height:8vh;width:99vw'>  </iframe>
			<iframe name='results' id='results' src='../../eCommon/html/blank.html' frameborder=0 noresize=noresize scrolling='auto' style='height:38vh;width:99.5vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' noresize=noresize frameborder=0  scrolling='no' style='height:6vh;width:100vw'></iframe>
	
</html>


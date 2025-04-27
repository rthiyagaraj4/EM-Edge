<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<frameset rows="5%,*"> 
<frame name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/PickListMainTab.jsp?%=request.getQueryString()%>">


<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/PickGenByDate.jsp?<%=request.getQueryString()%>">


</frameset>


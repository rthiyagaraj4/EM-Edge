<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eOT.*,eOT.Common.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%   String params = request.getQueryString(); 
	 //String tab_id = request.getParameter("tab_id");
	 //String qry_mode_flag= CommonBean.checkForNull(request.getParameter("qry_mode_flag"));
%>
<iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/SurgeryHistoryAllNotes.jsp?<%=params%>'  scrolling='auto' noresize='no' frameborder="0"
style='height:95vh;width:97vw;border=0'></iframe> 

 


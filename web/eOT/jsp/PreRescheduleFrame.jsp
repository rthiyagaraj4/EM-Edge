<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>

<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels")%></title>
</head>
<iframe name="f_query_add_mod" id="f_query_add_mod"  noresize scrolling="yes" src="../../eOT/jsp/PreReScheduleSearch.jsp?<%=request.getQueryString()%>"  style="height:18vh;width:100vw"></iframe>
<iframe name='qa_query_result' id='qa_query_result' 		src="../../eCommo n/html/../../eOT/jsp/PreReScheduleDtlFrm.jsp?<%=request.getQueryString()%>" style='height:82vh;width:100vw'></iframe>
<html>


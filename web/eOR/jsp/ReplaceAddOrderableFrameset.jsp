<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
/*orderId = request.getParameter("orderId");
task_type = request.getParameter("colval1");
colval = request.getParameter("colval");
 sex =  request.getParameter("sex");
patient_id = request.getParameter("patient_id");
*/
//String order_line_num = request.getParameter("order_line_num");
//out.println("<script>alert('order_line_num="+order_line_num+"');</script>");
//System.out.println("qrystr="+request.getQueryString());
%>
<title><%//=task_type%><fmt:message key="Common.Replace.label" bundle="${common_labels}"/>/<fmt:message key="Common.Add.label" bundle="${common_labels}"/> <fmt:message key="eOR.Orderables.label" bundle="${or_labels}"/></title>

<iframe name='ReplaceAddOrderable' id='ReplaceAddOrderable' src='ReplaceAddOrderableTop.jsp?<%=request.getQueryString()%>&function_from=Complete' frameborder=0  noresize scrolling=auto style='height:35vh;width:100vw'></iframe>
<iframe name='ReplaceAddRemarks' id='ReplaceAddRemarks' src='ReplaceAddOrderableRemarks.jsp?<%=request.getQueryString()%>&function_from=Complete' frameborder=0 scrolling=no style='height:65vh;width:100vw'></iframe>


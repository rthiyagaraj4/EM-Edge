<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	
<%  request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");


String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

   <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>	
   <title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditLog.label" ,"common_labels")%></title>	
   <%
       String table_id			    =	request.getParameter("table_id");
	   String pkey_value			=	request.getParameter("pkey_value");
   %>
</head>
<iframe name="f_header" id="f_header" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/SetupAuditLogHeader.jsp?table_id=<%=table_id%>&pkey_value=<%=pkey_value%>" style="height:24vh;width:100vw"></iframe><iframe name="f_detail" id="f_detail" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:74vh;width:100vw"></iframe>
</html>


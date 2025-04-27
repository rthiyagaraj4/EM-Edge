<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>

<HTML>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></LINK>
<LINK rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></LINK>
<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onKeyDown='lockKey()'>
<TABLE WIDTH='100%'  VALIGN=TOP>
	<TH ALIGN='LEFT'><fmt:message key="eMR.ApplicableRecodingComponent.label" bundle="${mr_labels}"/></TH>
</TABLE>
</BODY>
</HTML>



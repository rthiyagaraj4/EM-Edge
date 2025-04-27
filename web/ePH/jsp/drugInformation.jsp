 <!--
Fine Tuning
-->
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>				
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>
<%

	String extprodid = request.getParameter("extprodid");
	String url1 = "../../ePH/jsp/druginformationheader.jsp?extprodid="+extprodid;
	String url2 = "../../ePH/jsp/drugimage.jsp?extprodid="+extprodid;
	String url3 = "../../ePH/jsp/drugmonograph.jsp?extprodid="+extprodid;
%>
<frameset rows="8%,*">
<frame name="header" frameborder="0" scrolling="no"  src="<%=url1%>">
	<frameset cols="40%,60%">
		<frame name="drugimage" frameborder="0" scrolling="auto" noresize src="<%=url2%>">
		<frame name="drugmonograph" frameborder="0" scrolling="auto" noresize src="<%=url3%>">
	</frameset>
</frameset>
</HTML>

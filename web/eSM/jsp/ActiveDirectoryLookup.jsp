<!DOCTYPE html>
<%@ page import="java.sql.*,java.io.*,java.net.*,webbeans.eCommon.*,java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	request.setCharacterEncoding("UTF-8"); 

	String searchtxtval = request.getParameter("searchtxtval");
%>
<html>
<title><fmt:message key="eSM.ActiveDirectoryID.label" bundle="${sm_labels}"/></title>
<iframe name="lookup_head" id="lookup_head" src="../../eSM/jsp/ActiveDirectorySearch.jsp?searchtxtval=<%=searchtxtval%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:17vh;width:100vw"></iframe><iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style="height:73vh;width:100vw"></iframe><iframe name="lookup_cancel" id="lookup_cancel" src="../../eSM/jsp/ActiveDirectoryCancel.jsp" noresize  frameborder="no" marginheight="0" marginwidth="0" style="height:10vh;width:100vw"></iframe>
</html>


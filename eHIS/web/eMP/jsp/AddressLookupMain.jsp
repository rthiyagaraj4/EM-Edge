<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
%> 
<html>
<Script language='javascript' src='../../eMP/js/AddressLookup.js'></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
String title=request.getParameter("title");
if(title==null)
title="";
String fieldname=request.getParameter("fieldname");
if(fieldname == null)
fieldname="";

String fieldvalue=request.getParameter("fieldvalue");

if(fieldvalue == null)
fieldvalue="";

fieldvalue = java.net.URLEncoder.encode(fieldvalue,"UTF-8");

%>
<title id="lookup_title"><%=title%></title>
<iframe name="lookup_head" id="lookup_head" src="../../eMP/jsp/AddressLookupCriteria.jsp?fieldname=<%=fieldname%>&fieldvalue=<%=fieldvalue%>" noresize  frameborder="no" marginheight="0" marginwidth="0" scrolling="no" style="height:20vh;width:95vw"></iframe>
<iframe name="lookup_detail" id="lookup_detail"    src="../../eCommon/html/blank.html"  noresize  scrolling="auto" frameborder="no" marginheight="0" marginwidth="0" style="height:80vh;width:100vw"></iframe>


</html>


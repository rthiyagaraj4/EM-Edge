<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
%> 
<html>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eMP/js/AddressLookup.js'></Script>
<script>
//	var argArray = window.dialogArguments ;

	//var fieldLegend     = argArray[9];
	//window.document.title=fieldLegend;
	
</script>
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
<iframe name="lookup_head" id="lookup_head"  src="../../eMP/jsp/AddressLookupCriteria.jsp?fieldname=<%=fieldname%>&fieldvalue=<%=fieldvalue%>" height="75px" width="100%" style="border:0;" ></iframe>
<iframe name="lookup_detail" id="lookup_detail"  src="../../eCommon/html/blank.html"  height="275px" width="100%"  style="border:0;"></iframe>
</html>


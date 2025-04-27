<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.* "%>
 <html>
<head>

 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String from_page_one=request.getParameter("from_page_one");
		if(from_page_one==null)from_page_one="";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>

<script src='../../eOA/js/SecondaryResource.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<form name="recur_day_results" id="recur_day_results" method="post">
<table cellpadding=0 cellspacing=0 width="100%">

<%if(!from_page_one.equals("bulk_prompt")) {%>
<tr><td class="OAQRYODD" align=middle><input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class=button onclick="parent.frames[0].validate1()">
<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
' class=button onclick="parent.frames[0].ret_none1()">
<%}else{%>
<tr><td class="OAQRYODD" align=middle><input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class=button onclick="parent.frames[0].validate2()">
<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class=button onclick="parent.frames[0].ret_none1()">
<%}%>


</td></tr>
</table>
</form>
</body>
</html>
	


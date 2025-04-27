<!DOCTYPE html>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

<title><%=request.getParameter("title")%></title>
<iframe name='AddModifyPatFinDetailsMultiBlngGrpHead' id='AddModifyPatFinDetailsMultiBlngGrpHead' src="../../eBL/jsp/AddModifyPatFinDetailsMultiBlngGrpHead.jsp?<%=request.getQueryString()%>" frameborder=0 noresize scrolling='no' style='height:13vh;width:100vw;border:0'></iframe> 

		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='MainFrame2' id='MainFrame2' scrolling='no' noresize style='height:87vh;width:100vw;border:0'></iframe>
		<iframe SRC="../../eCommon/jsp/GeneralCancel.jsp" frameborder=0 name='MainFrame2' id='MainFrame2' scrolling='no' noresize style='height:8vh;width:100vw;border:0'></iframe> 

</head>
</html>


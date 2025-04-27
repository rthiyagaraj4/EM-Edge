<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title>Special Chart Ref</title>

<%
    request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/SplChartRef.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

		<iframe name='frameSplChartRefHdr' id='frameSplChartRefHdr'  src='../../eCA/jsp/SplChartRefHdr.jsp' frameborder='0' style='height:30vh;width:100vw'></iframe>
		<iframe name='frameSplChartRefDtl' id='frameSplChartRefDtl'  src='../../eCommon/html/blank.html' frameborder='0' noresize style='height:100vh;width:100vw'></iframe>

</html>




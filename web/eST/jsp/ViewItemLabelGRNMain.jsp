<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/common/common.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src='../../eST/js/ItemForStore.js'></script>
		<script language='javascript' src='../../eST/js/ViewItemLabelGRNS.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script> function_id = "<%=request.getParameter("function_id") %>"
		</script>
		<title>GRN Search</title>
	</head>	
	<iframe name="ViewGRNSCriteriaFrame" id="ViewGRNSCriteriaFrame" src="../../eST/jsp/ViewItemLabelGRNSCriteria.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:10vh;width:97vw'></iframe>
	<iframe name="ViewGRNSResultFrame" id="ViewGRNSResultFrame" src="../../eCommon/html/blank.html"  frameborder=0 scrolling='no' noresize style='height:80vh;width:97vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:7vh;width:97vw'></iframe>
</html>



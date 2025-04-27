<!DOCTYPE html>
 <html>
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/PurchaseOrderCancel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id")%>";
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	String params = request.getQueryString();
%>
<iframe name="STPOCancelOrderQueryHeaderFrame" id="STPOCancelOrderQueryHeaderFrame" scrolling="no" noresize src="../../ePO/jsp/PurchaseOrderCancelQueryCriteria.jsp?<%=params%>" style="height:23vh;width:100vw"></iframe><iframe name="STPOCancelOrderQueryResultFrame" id="STPOCancelOrderQueryResultFrame" src="../../eCommon/html/blank.html" scrolling="auto"  style="height:77vh;width:100vw"></iframe>
</html>


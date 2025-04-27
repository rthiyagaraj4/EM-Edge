<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../ePO/js/UserPurchaseUnitAccessForTransactions.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/common/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"
			</script>
	</head>

	<%
		String bean_id = "userPurchaseUnitAccessForTransactionsBean";
		String bean_name = "ePO.UserPurchaseUnitAccessForTransactionsBean";
	
		String mode = request.getParameter("mode");
		System.out.println("mode"+ mode);
		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		ePO.UserPurchaseUnitAccessForTransactionsBean userPurchaseUnitAccessForTransactionsBean = (ePO.UserPurchaseUnitAccessForTransactionsBean)getBeanObject( bean_id, bean_name, request );
		userPurchaseUnitAccessForTransactionsBean.setLanguageId(locale);
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			userPurchaseUnitAccessForTransactionsBean.clear();
		}
	%>
	<%
putObjectInBean(bean_id,userPurchaseUnitAccessForTransactionsBean,request);
%>
	
	<iframe name="UserForPuUnitHeaderFrame" id="UserForPuUnitHeaderFrame" src="../../ePO/jsp/UserPurchaseUnitAccessForTransactionsHeader.jsp?<%=request.getQueryString()%>" scrolling='no' noresize style="height:30vh;width:100vw"></iframe>
	<%if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {%>
    <iframe name="UserForPuUnitListFrame" id="UserForPuUnitListFrame" src="../../ePO/jsp/UserPurchaseUnitAccessForTransactionsDetail.jsp?<%=request.getQueryString()%>" scrolling='auto' noresize style="height:70vh;width:100vw"></iframe>
    <% } else { %>

	<iframe name="UserForPuUnitListFrame" id="UserForPuUnitListFrame" src="../../eCommon/html/blank.html?<%=request.getQueryString()%>" scrolling='auto' noresize style="height:70vh;width:100vw"></iframe>
	<% } %>



</html>


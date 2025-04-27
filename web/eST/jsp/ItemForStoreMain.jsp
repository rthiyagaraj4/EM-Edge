<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
				
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- 	<script language="javascript" src="../../eCommon/common/messages.js"></script> -->
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!--		<script language="javascript" src="../../eST/js/StMessages.js"></script>-->
		<script language="javascript" src='../../eST/js/ItemForStore.js'></script>
	<!-- 	<script language="javascript" src="../../eMM/js/MmMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
		<script>
			function_id = "<%=request.getParameter("function_id") %>"
		</script>
	</head>
	<%

		String bean_id = "itemForStoreBean";
		String bean_name = "eST.ItemForStoreBean";
		String mode = request.getParameter("mode");
		if ((mode == null) || (mode.equals(""))) 
			return;
		if (!(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		eST.ItemForStoreBean itemForStoreBean = (eST.ItemForStoreBean) getBeanObject(bean_id,bean_name, request );

		itemForStoreBean.setLanguageId(locale);

		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			itemForStoreBean.clear();
		}
	%>
	<iframe name="ItemForStoreListFrame" id="ItemForStoreListFrame" src="../../eST/jsp/ItemForStoreList.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='yes'  style='height:35vh;width:100vw'></iframe>
	<iframe name="ItemForStoreTabFrame" id="ItemForStoreTabFrame" src="../../eST/jsp/ItemForStoreTab.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' style='height:60vh;width:100vw'></iframe>
	<%
putObjectInBean(bean_id,itemForStoreBean,request);
%>

</html>


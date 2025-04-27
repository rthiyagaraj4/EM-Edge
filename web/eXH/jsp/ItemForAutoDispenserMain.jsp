<!DOCTYPE html>
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
		<script language="javascript" src="../../eCommon/common/common.js"></script>
		<script language="javascript" src='../../eXH/js/DispenseItemMachineCodes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%=request.getParameter("function_id") %>"
		</script>
	</head>
	
	<iframe name="queue_frame" id="queue_frame" src="../../eXH/jsp/DispItemsForMachineCodesList.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='yes' noresize style='height:49vh;width:100vw'></iframe>
	<iframe name="action_frame" id="action_frame" src="../../eXH/jsp/DispItemsForMachineCodesTab.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='no' noresize style='height:51vh;width:100vw'></iframe>
	

</html>


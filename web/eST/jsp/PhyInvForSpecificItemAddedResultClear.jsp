<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 

<%-- Mandatory declarations end --%>
<html>
	<head> 
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/rowcolor.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="Javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script>
 -->		<script language="Javascript" src="../../eST/js/ItemMovement.js"> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%	
	java.util.HashMap defaultParameter = new HashMap();
	defaultParameter.put("item_codeF",request.getParameter("item_codeF"));
	defaultParameter.put("item_codeT",request.getParameter("item_codeT"));
	defaultParameter.put("store_code",request.getParameter("store_code"));
	
	String bean_id = "PhyInvForSpecificItemBean";
	String bean_name = "eST.PhyInvForSpecificItemBean";
	PhyInvForSpecificItemBean bean = (PhyInvForSpecificItemBean) getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear_data_added();
	%>

</head>
<body>
				<%
						putObjectInBean(bean_id,bean,request);
					%>
</body>
</html>


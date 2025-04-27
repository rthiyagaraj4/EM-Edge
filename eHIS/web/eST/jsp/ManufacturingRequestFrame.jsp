<!DOCTYPE html>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
 <link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String index=request.getParameter("index")==null?"-1":request.getParameter("index");
String mode=request.getParameter("mode")==null?"1":request.getParameter("mode");

String bean_id = "ManufacturingRequestBean";
String bean_name = "eST.ManufacturingRequestBean";
//pmd 29/01/05	
//String disable ="";
	ManufacturingRequestBean bean = (ManufacturingRequestBean) getBeanObject( bean_id,bean_name,request);  
//	bean.clear();
bean.setLanguageId(locale);
	bean.initialize();
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
putObjectInBean(bean_id,bean,request);
%>
<iframe name='selectcriteriaframe' id='selectcriteriaframe'	src="../../eST/jsp/ManufacturingRequestHeader.jsp?mode=<%=mode%>&index=<%=index%>"  frameborder=0 scrolling='no' noresize style='height:14vh;width:100vw'></iframe>
	<iframe name='detailframe' id='detailframe' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:56vh;width:100vw'></iframe>
	<iframe name='addModframe' id='addModframe'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>

</html>


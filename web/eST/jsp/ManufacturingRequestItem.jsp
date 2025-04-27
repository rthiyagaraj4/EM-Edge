<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 --><%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language='javascript' src="../../eST/js/AssemblyDetail.js"></script>
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");

String index=request.getParameter("index")==null?"-1":request.getParameter("index");
//pmd 29/01/05	
//String mode=request.getParameter("mode")==null?"1":request.getParameter("mode");
String remarks=request.getParameter("remarks")==null?"1":request.getParameter("remarks");
%>
<title><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></title>
<iframe name='detailframe' id='detailframe' src="../../eST/jsp/ManufacturingRequestItemDesc.jsp?index=<%=index%>&remarks=<%=remarks%>" frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>

</html>


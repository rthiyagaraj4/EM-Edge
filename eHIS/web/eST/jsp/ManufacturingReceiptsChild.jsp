<!--<!DOCTYPE html>-->
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
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
<script language='javascript' src="../../eST/js/AssemblyDetail.js"></script>
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eST/js/ManufacturingReceipts.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");


String index=request.getParameter("index")==null?"-1":request.getParameter("index");
String mode=request.getParameter("mode")==null?"1":request.getParameter("mode");
String store_code=request.getParameter("store_code")==null?"1":request.getParameter("store_code");
String seq_no=request.getParameter("seq_no")==null?"1":request.getParameter("seq_no");
String bean_id = "ManufacturingReceiptsBean";
String bean_name = "eST.ManufacturingReceiptsBean";
//String disable ="";
	ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setReq_store(store_code);

putObjectInBean(bean_id,bean,request);

%> 
<title><fmt:message key="eST.ManufacturingReceiptsDetails.label" bundle="${st_labels}"/></title>
<iframe name='detailframe' id='detailframe' src="../../eST/jsp/ManufacturingReceiptsChildResult.jsp?mode=<%=mode%>&index=<%=index%>&seq_no=<%=seq_no%>" frameborder=0 style='height:60%;width:100vw'></iframe><iframe name='addModframe' id='addModframe'	src="../../eST/jsp/ManufacturingReceiptsChildAddModify.jsp?mode=<%=mode%>&seq_no=<%=seq_no%>"  frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>

</html>


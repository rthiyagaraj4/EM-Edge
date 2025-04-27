<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

	String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params		= request.getQueryString() ;
	String source		= url + params ;	
	String bean_id		= "DirectDispensingBean" ;
	String bean_name	= "ePH.DirectDispensingBean";
	DirectDispensingBean bean = (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
	bean.clear();
	bean.setLanguageId(locale);
	String DirDispStatus=(String)bean.getDirDispencingStatus();
	String homepage = request.getParameter("homepage")==null?"":request.getParameter("homepage");//Added for Bru-HIMS-CRF-073.1 [IN:047222]
%>
<html>
	<head>
		<title></title>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
<%
	if(!DirDispStatus.equals("N")){ 
%>
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:7vh;width:100vw"></iframe>
		<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize border='2' src="../../ePH/jsp/DirectDispensingQueryCriteria.jsp?homepage=<%=homepage%>"  style='height:7vh;width:100vw'></iframe>
		<iframe name="f_detail" id="f_detail" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:80vh;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:5;width:100vw"></iframe>
<%
	}
	else {
%>
		<script>
			alert(getMessage('PH_DIRECT_DISPENCING_NOT_ALLOWED',"PH"));
			history.go(-1);
		</script>
<%
	}  
	putObjectInBean(bean_id,bean,request); 
%>
</html>


<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");
	
%>

<html>
<head>
	
<!-- <SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>
 -->	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/TPNConsLimits.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String bean_id = "TPNConsLimitsBean" ;
	String bean_name = "ePH.TPNConsLimitsBean";
	String orderuompres="";
	TPNConsLimitsBean bean = (TPNConsLimitsBean)getBeanObject( bean_id, bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear();
	orderuompres=bean.checkIfOrderUOMDefined();

	if (orderuompres.equals("N"))
	{
		out.println("<script>alert(getMessage('PH_TPN_CONSTITUENTS_LIMIT_UOM_TPN_SETUP','PH'));</script>");
		return;
	}

%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="ConsLimitsAddModifyQueryFrame" id="ConsLimitsAddModifyQueryFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/MstCodeError.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:9vh;width:100vw"></iframe>
<% putObjectInBean(bean_id,bean,request); %>
</html>


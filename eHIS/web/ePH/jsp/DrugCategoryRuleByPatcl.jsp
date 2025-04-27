<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/DrugCategoryRuleByPatcl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;

	String bean_id = "DrugCategoryRuleByPatclBean" ;
	String bean_name = "ePH.DrugCategoryRuleByPatclBean";

	DrugCategoryRuleByPatclBean bean = (DrugCategoryRuleByPatclBean)getBeanObject( bean_id, bean_name , request) ;
	ArrayList all=	bean.getAllList(locale);
	ArrayList phParamValues= (ArrayList)all.get(3);
	if (phParamValues.size()==0){
%>
		<script>alert(getMessage("PH_FACILITY_PARAM_NOT_SETUP","PH"));</script>
<%
	}
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>


<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
<html>
<head>
<script language="JavaScript" src="../js/DrugItemLink.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String bean_id		= "DrugItemLink" ;
String bean_name	= "ePH.DrugItemLinkBean";
DrugItemLinkBean bean = (DrugItemLinkBean)getBeanObject( bean_id, bean_name, request ) ;
bean.setLanguageId(locale);
bean.clear();
boolean chkPhParamAvail= bean.chkPhParamAvail();

	if(chkPhParamAvail){
		if(bean.ParamDrugItemChkValue()){
			%>
			<script>loadDrugItemLinkPage();</script>
			<%
		}else{
		%>
			<script>alert(getMessage("PH_PARAM_DRUG_ITEM","PH"));</script>
		<%
		
		}
	}else{
	%>
	<script>alert(getMessage("PH_PARAM_NOT_SETUP","PH"));</script>
<%
		}
%>
<title><fmt:message key="ePH.DrugItemLink.label" bundle="${ph_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
</body>

</html>

<%
putObjectInBean(bean_id,bean,request);
%>


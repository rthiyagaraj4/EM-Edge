<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<title><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></title>
<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/GenericNameForService.js"></script>
	<script language="JavaScript" src="../../ePH/js/DiscontinueDrug.js"></script>
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->	
	<script language="JavaScript" src="../../ePH/js/DrugDetailsDisplay.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
String drug_code=request.getParameter("drug_code");
String	bean_id			=	"DrugDetailsBean" ;
String	bean_name		=	"ePH.DrugDetailsBean";
DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id,bean_name, request ) ;
bean.clear() ;
bean.setLanguageId(locale);
bean.setDRUG_CODE(drug_code.trim());
bean.getDrugDetails();
int diagnosislistCount = ((ArrayList)bean.getDiagnosisList()).size();
int ageGroupCount = bean.getAgeGroupList().size();
%>
<iframe name="DrugDetails_Buttons" id="DrugDetails_Buttons" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DrugDetailsButtons.jsp?diagnosislistCount=<%=diagnosislistCount%>&ageGroupCount=<%=ageGroupCount%>" style="height:8vh;width:100vw"></iframe><iframe name="Button_Specific_Jsp" id="Button_Specific_Jsp" frameborder="0"  noresize src="../../eCommon/html/blank.html" scrolling="auto"  style="height:95vh;width:100vw"></iframe>

</html>
<%
putObjectInBean(bean_id,bean,request);
%>


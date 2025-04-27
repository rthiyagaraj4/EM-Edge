<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/ReconstituentFluid.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

	String mode = request.getParameter("mode");
	String Immodule_Yn		=	"";
	String bean_id	=	"ReconstituentFluidBean";
	String bean_name	=	"ePH.ReconstituentFluidBean";

	ReconstituentFluidBean bean = (ReconstituentFluidBean)getBeanObject( bean_id, bean_name,request) ;
	bean.setLanguageId(locale);
	Immodule_Yn=(String) bean.getImModule();

%>

<%
	String param	= request.getParameter("param");
	String params	=	request.getQueryString();
	//out.println("params=>"+params);
	if (param == null) param = "";
	if (Immodule_Yn.equals("1")){
%>
	<iframe name="reconstituentfluid_top" id="reconstituentfluid_top" frameborder="0" scrolling="no" noresize   src="../../ePH/jsp/ReconstituentFluidAddModify.jsp?mode=<%=mode%>&<%=params%>" style="height:25vh;width:100vw"></iframe><iframe name="reconstituentfluid_middle" id="reconstituentfluid_middle" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/InvItemReconstituentFluidDisplay.jsp?mode=<%=mode%>&<%=params%>" style="height:55vh;width:100vw"></iframe><iframe name="reconstituentfluid_bottom" id="reconstituentfluid_bottom" frameborder="0" scrolling="no" noresize   src="InvItemReconstituentFluidAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT") %>&<%=params%>" style="height:15vh;width:100vw"></iframe>
<%
	}else{
%>
<iframe name="reconstituentfluid_top" id="reconstituentfluid_top" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/ReconstituentFluidAddModify.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>" style="height:100vh;width:100vw"></iframe>
<%
	}
%>
<% putObjectInBean(bean_id,bean,request); %>
</html>


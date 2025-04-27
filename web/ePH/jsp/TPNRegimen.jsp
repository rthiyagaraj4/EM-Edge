<!DOCTYPE html>
 <%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

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
<HTML>
<%
	//String url				= "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String clearOrNot		= request.getParameter("clearOrNot") == null ? "N":request.getParameter("clearOrNot");
	

	String bean_id			= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.TPNRegimenBean";
	TPNRegimenBean bean	= (TPNRegimenBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	if (clearOrNot.equals("Y"))
		bean.clear();
%>

 <FRAMESET ROWS="39,*" FRAMESPACING="0">
	<FRAME name="f_tpnregimenselect" id="f_tpnregimenselect" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="TPNRegimenOptions.jsp?<%= params %>">
	<FRAME name="f_tpnregimen" id="f_tpnregimen" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="TPNRegimenAssesmentFrame.jsp?<%= params %>">
	<!--<FRAME name="f_ivfluid" id="f_ivfluid" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionFluidDetail.jsp?<%= params %>">
	<FRAME name="f_ivadmin" id="f_ivadmin" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionAdminDetail.jsp?<%= params %>">
	<FRAME name="f_ivbutton" id="f_ivbutton" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVPrescriptionButtons.jsp?<%= params %>">-->
</FRAMESET>
<% putObjectInBean(bean_id,bean,request); %>
</HTML>


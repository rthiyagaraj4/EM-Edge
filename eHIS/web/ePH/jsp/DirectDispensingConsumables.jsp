<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<head>
		<title><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></title>
	</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params			        = request.getQueryString() ;
	String disp_locn_code           = request.getParameter("disp_locn_code");

	String locale                   = (String) session.getAttribute("LOCALE");
	String bean_id					= "@ConsumableOrderBean";
	String bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean bean		= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
   
    bean.setLanguageId(locale);
	//String params			        = request.getQueryString() ;
//	String bean_id					= "@DirectDispensingBean";
	//String bean_name				= "ePH.DirectDispensingBean";
//	DirectDispensingBean bean		= (DirectDispensingBean)getBeanObject( bean_id, bean_name, request );
   	params = params +"&bean_id="+bean_id+"&bean_name="+bean_name;
	%>
	<iframe name="Disp_cons_items_criteria" id="Disp_cons_items_criteria" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/DirectDispensingConsumablesItemsCriteria.jsp?<%= params %>" style="height:10vh;width:100vw"></iframe><iframe name="Disp_cons_item_result" id="Disp_cons_item_result" FRAMEBORDER="0" SCROLLING="yes" NORESIZE SRC="../../ePH/jsp/DirectDispensingConsumablesItemsDetails.jsp?<%= params %>" style="height:85vh;width:100vw"></iframe><iframe name="Disp_cons_item_buttons" id="Disp_cons_item_buttons" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/DirectDispensingConsumablesButtons.jsp?<%= params %>" style="height:5vh;width:100vw"></iframe>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
	
%>


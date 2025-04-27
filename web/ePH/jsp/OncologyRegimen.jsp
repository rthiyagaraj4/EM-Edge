<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String clearOrNot		= request.getParameter("clearOrNot") == null ? "N":request.getParameter("clearOrNot");
	String bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	if (clearOrNot.equals("Y"))
		bean.clear();
	putObjectInBean(bean_id,bean,request);
	if(order_type_flag.equals("")){
%>
		 <iframe name="oncology_options" id="oncology_options" frameborder="0" scrolling="no" noresize src="OncologyRegimenOptions.jsp?<%= params %>" style="height:20vh;width:100vw"></iframe><iframe name="oncology_drugs" id="oncology_drugs" frameborder="0" scrolling="no" noresize src="OncologyRegimenDrugDetailFrames.jsp?<%= params %>" style="height:80vh;width:100vw"></iframe>
<%
	}
	else{
%>
		<iframe name="oncology_options" id="oncology_options" frameborder="0" scrolling="no" noresize src="OncologyRegimenOptions.jsp?<%= params %>" style="height:28vh;width:100vw"></iframe><iframe name="oncology_drugs" id="oncology_drugs" frameborder="0" scrolling="no" noresize src="OncologyRegimenDrugDetailFrames.jsp?<%= params %>" style="height:72vh;width:100vw"></iframe>
<%
	}
%>
</html>


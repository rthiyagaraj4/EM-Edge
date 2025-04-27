<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name , request) ;
	String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
	String search_bean_name		= "ePH.DrugSearchBean";
	DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id, search_bean_name, request);	
	searchbean.clear();	
%>
	 <iframe name="f_iv_fluid" id="f_iv_fluid" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendFluidDetail.jsp?<%= params %>" style="height:4vh;width:100vw"></iframe><iframe name="f_iv_drug_details" id="f_iv_drug_details" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendDrugDetailFrames.jsp?<%= params %>" style="height:11vh;width:100vw"></iframe><iframe name="f_iv_admin" id="f_iv_admin" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="IVAmendAdminDetail.jsp?<%= params %>" style="height:3vh;width:100vw"></iframe>

</HTML>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(search_bean_id,searchbean,request);
%>


<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
 
<HTML>
	<head>
		<title><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/></title>
	</head>
<%

request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String locale = (String) session.getAttribute("LOCALE");

	String bean_id					= "@ConsumableOrderBean"+patient_id+encounter_id;
	String bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
	//added for IN70923 - start
	
	// <!--//Added By Himanshu for GHL-SCF-1738--> starts
	String patient_class =	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String	drug_bean_id		=	"@DrugSearchBean"+patient_id+encounter_id;
	String	drug_bean_name		=	"ePH.DrugSearchBean";		
	DrugSearchBean drug_bean		=	(DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ; 
	drug_bean.setPatientClass(patient_class);
	ArrayList stock_params	=	drug_bean.validateForStock();
	String allow_pres_without_stock_yn="";
	String consider_stock="";
	if(stock_params.size() > 1) {
		consider_stock					= (String)stock_params.get(0);
		allow_pres_without_stock_yn		= (String)stock_params.get(1);
	}
	//<!--//Added By Himanshu for GHL-SCF-1738--> end
	
	
	String bean_id_1					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name_1					= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean_1			= (PrescriptionBean_1)getBeanObject(bean_id_1,bean_name_1,request);
	ArrayList presDetails_1					= (ArrayList) bean_1.getpresDetails();
	//added for IN70923 - end
	params = params +"&bean_id="+bean_id+"&bean_name="+bean_name+"&allow_pres_without_stock_yn="+allow_pres_without_stock_yn;
	String allow_alt_for_med_item = request.getParameter("allow_alt_for_med_item")==null?"":request.getParameter("allow_alt_for_med_item"); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
	bean.setAllowAltForMedItem(allow_alt_for_med_item); // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
	String called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");

	if(called_from.equals("TAB") && (presDetails_1==null || presDetails_1.size()==0)) //modified for IN70923
		bean.clear();
	bean.setLanguageId(locale);
	//-- Below added blank page instead of the specific jsp SRR20056-SCF-6434 [IN:025880]
%>
	<iframe name="fram_cnItemDetail" id="fram_cnItemDetail" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../ePH/jsp/ConsumableOrderItemDetail.jsp?<%= params %>" style="height:26vh;width:98vw"></iframe>
	<iframe name="fram_cnItemList" id="fram_cnItemList" FRAMEBORDER="0" SCROLLING="yes" NORESIZE SRC="../../eCommon/html/blank.html" style="height:61vh;width:96vw"></iframe>
	<iframe name="fram_cnButtons" id="fram_cnButtons" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:7vh;width:96vw"></iframe>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);//added for IN70923
%>


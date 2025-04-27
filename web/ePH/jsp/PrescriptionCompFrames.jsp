<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
06/01/2021		 TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
--------------------------------------------------------------------------------------------------------------
*/
%> 

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	//	
%>
</head>
<%
	String params			= request.getQueryString() ;

	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String iv_bean_id	= "IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;
	bean.clear();	
	bean.setLanguageId(locale);

	String search_bean_id		= "@DrugSearchBean"+patient_id+encounter_id;
	String search_bean_name		= "ePH.DrugSearchBean";
	DrugSearchBean searchbean	= (DrugSearchBean)getBeanObject(search_bean_id, search_bean_name, request);
	
	searchbean.clear();

	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
	//thai date is coming. so we are converting and setting the order date 13/07/2010.
	bean.setOrderDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",locale,"en"));
	//bean.setOrderDate(start_date); //Above line uncommented for IN23904 reopen --27/09/2010 -- priya
	bean.setPatientClass(patient_class);
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);
	bean.setPreAllocAppl(); //Added for MMS-DM-CRF-0177
	
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();
	
	bean.setLocationType(locn_type);
	bean.setLocationCode(locn_code);
	bean.setPractionerID(pract_id);

	String or_mode = request.getParameter("or_mode");
	if(or_mode==null)or_mode="";
	bean.setOrMode(or_mode);

%>

<iframe name="f_compound_title" id="f_compound_title" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="PrescriptionCompTitle.jsp?<%= params %>" style="height:7vh;width:98vw"></iframe>
<iframe name="f_compound_detail" id="f_compound_detail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="PrescriptionCompDetail.jsp?<%= params %>" style="height:69vh;width:98vw"></iframe>
<iframe name="f_compound_button" id="f_compound_button" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="PrescriptionCompButtons.jsp?<%= params %>" style="height:15vh;width:97vw"></iframe>
<% putObjectInBean(iv_bean_id,bean,request); 
   putObjectInBean(search_bean_id,searchbean,request);
   putObjectInBean(or_bean_id,ORbean,request);
%>
</HTML>



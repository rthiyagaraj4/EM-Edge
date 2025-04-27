<!DOCTYPE html>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%-- <%@page import="eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.bc.MOrderEntryBC"%> 
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest"%>--%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 
<%@ page language="java" contentType="text/html"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%
   response.setHeader( "Pragma", "no-cache" );
   response.setHeader( "Cache-Control", "no-cache" );
   response.setDateHeader( "Expires", 0 );
%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>
<%
/* PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){ */
	//String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
	//String or_bean_name = "eOR.OrderEntryBean";
	
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	//OrderedProperties props = sectionBean.propPatientSection;
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String jsonRes = gson.toJson(sectionBean);
	response.getWriter().write("<pre>"+jsonRes+"</pre>");


%> 

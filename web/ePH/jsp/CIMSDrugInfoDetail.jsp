<!DOCTYPE html>
<%@page contentType="application/xml;charset=UTF-8" import="org.w3c.dom.*,java.sql.*,webbeans.eCommon.*,ePH.CIMSExternalDataBaseBean,eCommon.XSSRequestWrapper"%>
<?xml version='1.0' encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../../ePH/html/CIMSMonograph.xsl"?>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
//added By Himanshu Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	StringBuffer contentXML=new StringBuffer();
	String bean_id			= "@CIMSExternalDataBaseBean";
	//String mode			= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String bean_name		= "ePH.CIMSExternalDataBaseBean";
	CIMSExternalDataBaseBean bean	= (CIMSExternalDataBaseBean)getBeanObject(bean_id,bean_name,request);
	contentXML = new StringBuffer();
	contentXML.append(bean.getMonographContent(request.getParameter("extprodid")));
%>
<%=contentXML.toString()%>

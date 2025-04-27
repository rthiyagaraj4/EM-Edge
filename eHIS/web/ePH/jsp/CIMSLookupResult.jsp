<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../../ePH/html/CIMSLookUp.xsl"?>
<%@page contentType="application/xml;charset=UTF-8" import="webbeans.eCommon.*,ePH.CIMSExternalDataBaseBean" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 
<%
	StringBuffer contentXML=new StringBuffer();
	String bean_id			= "@CIMSExternalDataBaseBean";
	String bean_name		= "ePH.CIMSExternalDataBaseBean";
	CIMSExternalDataBaseBean bean	= (CIMSExternalDataBaseBean)getBeanObject(bean_id,bean_name,request);

	contentXML = new StringBuffer();
	
	 contentXML.append(bean.getDisplayLookUp(request.getParameter("type"), request.getParameter("code")));
	  
%>
		<%=contentXML.toString()%>
<% 
		putObjectInBean(bean_id,bean,request);
%>




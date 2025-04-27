<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*,java.io.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
 		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<%
	String order_id		 = request.getParameter("order_id");
	String bean_id	= "MedicationAdministrationFTBean";
	String bean_name= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name,request);
	bean.setLanguageId(locale);
	String remarks = bean.getPrescriptionInstructions(order_id);
	if(remarks==null)remarks="";
	if(remarks!=null&& remarks.equals("null"))remarks="";
%>

<body onMouseDown="" onKeyDown="lockKey()">
<form name="formPrescriptionInstructions" id="formPrescriptionInstructions">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<th  ><fmt:message key="ePH.PrescriptionInstructions.label" bundle="${ph_labels}"/></th>
		<tr>
			<td>
				<textarea cols="35" rows="6" readOnly><%=remarks%></textarea>	
			</td>
		</tr>
	</table>
</form>
<% putObjectInBean(bean_id,bean,request);%>
</body>
</html>


<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>
<%
	String order_id		 = request.getParameter("order_id");
	String order_line_no = request.getParameter("order_line_no");
	String bean_id	= "MedicationAdministrationFTBean";
	String bean_name= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	String remarks = bean.getPharmacistInstructions(order_id,order_line_no);
	if(remarks==null)remarks="";
%>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="formPharmacistInstructions" id="formPharmacistInstructions">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<th align="left">Pharmacist's Instructions</th>
		<tr>
			<td>
				<textarea cols="60" rows="6" readOnly><%=remarks%></textarea>
			</td>
		</tr>
	</table>
</form>
<% putObjectInBean(bean_id,bean,request ) ; %>
</body>
</html>


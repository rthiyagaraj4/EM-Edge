<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String performing_facility = request.getParameter("performing_facility")==null?"":request.getParameter("performing_facility");
	String encounterId = request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
	//System.out.println("encounterId="+encounterId);
	String sex = request.getParameter("sex")==null?"":request.getParameter("sex");
	String colval = request.getParameter("colval")==null?"":request.getParameter("colval");
	String colval1 = request.getParameter("colval1")==null?"":request.getParameter("colval1");
	String order_set_id = request.getParameter("order_set_id")==null?"":request.getParameter("order_set_id");
	String order_category=orderId.substring(0,2);

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/CompleteOrder.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='complete_order_btn' id='complete_order_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<%
	String bean_id = "Or_CompleteOrder" ;
	String bean_name = "eOR.CompleteOrderBean";
	CompleteOrderBean bean = (CompleteOrderBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");
%>
<tr align='right'>
<%
		if(!order_category.equalsIgnoreCase("PH")&&bill_yn.equalsIgnoreCase("Y"))
		{
		%>
				<td class='button	' nowrap><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/><a class="gridLink"  href="javascript:callBilling('0','<%=orderId%>','<%=patient_id%>','<%=performing_facility%>','<%=encounterId%>','<%=patient_class%>','<%=sex%>','<%=colval%>','<%=colval1%>','<%=order_set_id%>')" title='Charge Details'> <!--<fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/>--><FONT SIZE="2" ><fmt:message key="eOR.View/Edit.label" bundle="${or_labels}"/></FONT></a></td>
		<%
		}
		%>
		
		<td  class='button'> 
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels")%>' class='button' onClick='completeOrder()'>
 		<INPUT TYPE="button" value='<%= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.close.label", "common_labels") %>' class='button' onClick="window.close();">

		</td>
	</tr>

</table>


</form>

</body>
</html>


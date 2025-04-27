<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="ePH.PreviewofSelectedOrders.label" bundle="${ph_labels}"/></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
 		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PrescriptionTest.js"></script>
		<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
<%
	String pat_class	=	request.getParameter("pat_class");
	String ord_status	=	request.getParameter("ord_status");
	String order_from	=	request.getParameter("order_from");
	String order_to		=	request.getParameter("order_to");
	String pract_id		=	request.getParameter("pract_id");
	String patient_id	=	request.getParameter("patient_id");
	String encounter_id	=	request.getParameter("encounter_id");
	String order_id		=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String rx_type		=	request.getParameter("rx_type")==null?"":request.getParameter("rx_type");
	String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name	= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id, bean_name,request);
	bean.setLanguageId(locale);
	if(!locale.equals("en")){
		order_from = DateUtils.convertDate(order_from, "DMY",locale,"en");
		order_to = DateUtils.convertDate(order_to, "DMY",locale,"en");
	}

	ArrayList preview	= bean.getPreviewOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,order_id,rx_type,"",""); //bean.getPreviewOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to);

	int recCount		=	0;
	String classValue	=	"";

	%>

	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frmPrescriptionPrevOrdersPreview" id="frmPrescriptionPrevOrdersPreview">
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable">
				<tr>  
					<th width="1%">&nbsp;</th>
					<th nowrap width="60%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
					<th nowrap width="39%"><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
				</tr>
<% 
				for(int i=0; i<preview.size(); i+=21) {
					if(recCount%2==0)
						classValue="QRYEVENSMALL";
					else
						classValue="QRYODDSMALL";
%>
					<tr>
<% 
					if( ((String)preview.get(i)).equals("CN")) { 
%>
						<td class='CANCELLED'>&nbsp;</td>
<%
						}
						else if( ((String)preview.get(i)).equals("DC")) { 
%>
							<td class='DISCONTINUED'>&nbsp;</td>
<%	
						} 
						else{	
%>
							<td>&nbsp;</td>
<%	
						}
%>
						<td class="<%=classValue%>"><%=preview.get(i+4)%></td>
						<td class="<%=classValue%>"><%=preview.get(i+5)+" "+preview.get(i+6)+"&nbsp;-&nbsp;"+preview.get(i+8)+"&nbsp;for&nbsp;"+preview.get(i+9)+" "+preview.get(i+11)%></td>
					</tr>
<%
					recCount++;
				}	
%>
			</table>
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>


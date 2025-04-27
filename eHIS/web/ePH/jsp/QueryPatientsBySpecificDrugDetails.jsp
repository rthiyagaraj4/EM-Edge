<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<title> <fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../ePH/js/QueryPatientDrugProfile.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
	String order_id = request.getParameter("order_id");
	String order_line_num = request.getParameter("order_line_num");
	String sr_no = request.getParameter("sr_no");
	String patient_id = request.getParameter("patient_id");

	String	bean_id			=	"QueryPatientsBySpecificDrugBean" ;
	String	bean_name		=	"ePH.QueryPatientsBySpecificDrugBean";

	QueryPatientsBySpecificDrugBean bean = (QueryPatientsBySpecificDrugBean)getBeanObject( bean_id, bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList result = bean.getDrugDetails(patient_id,order_id,order_line_num,sr_no);
	if(result.size()<13){
		return ;
	}
%>
<form name="queryPatientsBySpecificDrugDetails" id="queryPatientsBySpecificDrugDetails" >
<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
	<%
		if (result.size()>0){
	%>
		<tr>
			<td class="label"><b><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></b></td>
			<td class="label"><b><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></b></td>
			<td class="label"><b><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label"><%=result.get(0)%></td>
			<td class="label"><%=result.get(1)%></td>
			<td class="label"><%=result.get(2)%></td>			
		</tr>
		<tr>
			<td class="label"><b><fmt:message key="Common.Route.label" bundle="${common_labels}"/></b></td>
			<td class="label"><b><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></b></td>			
			<td class="label"><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></b></td>			
		</tr>
		<tr>
			<%
				String route = "";
				if(result.get(4)!=null){
					route = (String)result.get(4);
				}
			%>
			<td class="label"><%=route%></td>
			<td class="label"><%=result.get(5)%></td>			
			<td class="label"><%=result.get(6)%></td>			
		</tr>
		<tr>
			<td class="label"><b><fmt:message key="ePH.Drug/DosageDetail.label" bundle="${ph_labels}"/> </b></td>  
			<td class="label" colspan="2"><%=result.get(3)%></td>			
		</tr>
		<tr>
			<th colspan="3" ><fmt:message key="Common.AdditionalInformation.label" bundle="${common_labels}"/></th>
		</tr>
		<%
				if (result.get(7) != null){
		%>
		<tr>
			<td class="label" colspan="3" ><b><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label" colspan="3" ><%=result.get(7)%></td>
		</tr>
		<%
			}
			if (result.get(8) != null){
		%>
		<tr>
			<td class="label" colspan="3" ><b><fmt:message key="ePH.SplitDoseDetails.label" bundle="${ph_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label" colspan="3" ><%=result.get(8)%></td>
		</tr>
		<%
			} 
			if(result.get(9) != null){
		%>
		<tr>
			<td class="label" colspan="3" ><b><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label" colspan="3" ><%=result.get(9)%></td>
		</tr>
		<%
			}
			if(result.get(10) != null){
		%>
		<tr>
			<td class="label" colspan="3" ><b><fmt:message key="ePH.DosageOverrideReason.label" bundle="${ph_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label" colspan="3" ><%=result.get(10)%></td>
		</tr>
		<%
			}
			if (result.get(11) != null){
		%>
		<tr>
			<td class="label" colspan="3" ><b><fmt:message key="ePH.DiscontinuedBy/Date.label" bundle="${ph_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label" colspan="3" ><%=result.get(11)%>&nbsp;<%=result.get(12)%></td>
		</tr>
		<%
			}
			if(result.get(13) != null){
		%>
		<tr>
			<td class="label" colspan="3" ><b><fmt:message key="Common.DiscontinueReason.label" bundle="${common_labels}"/></b></td>
		</tr>
		<tr>
			<td class="label" colspan="3" ><%=result.get(13)%></td>
		</tr>
	<%
			}
		}
	%>
	<tr>
		<td colspan="3" >
			<input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' 
			onClick="parent.window.close()">
		</td>
	</tr>
</table>
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>


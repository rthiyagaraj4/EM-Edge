<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		//patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
	<center>
	<form name='IPConsultationListToolbarForm' id='IPConsultationListToolbarForm'  method=post>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
			<tr>
				<td class='QRY9' width='5%' id='colour_pat1'></td><td width='20%' id='colour_patLab1' nowrap ><fmt:message key="eCA.ExceedMaxConsSpeciality.label" bundle="${ca_labels}"/></td><td class='IVINGREDIENT1' width='5%' id='colour_pat2' bgcolor="#FFDFDF"></td><td width='20%' id='colour_patLab2' nowrap><fmt:message key="eCA.ExceedMaxConsPractitioner.label" bundle="${ca_labels}"/></td>
				<td width='40%' id='cancel_ChargeLab' style="display:none" ><fmt:message key="eCA.TocancelPostedCons.label" bundle="${ca_labels}"/></td>
				<td align='right'>
					<input type='BUTTON' class='BUTTON' name='GenerateList' id='GenerateList' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.GenerateList.label","ca_labels")%>' onClick="apply();" style="display:none" >
					<input type='BUTTON' class='BUTTON' name='ChargeCons' id='ChargeCons' id value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChargeConsultation.label","ca_labels")%>' onClick="chargeCons(this);" style="display:none" >
					<input type='BUTTON' class='BUTTON' name='CancelCharge' id='CancelCharge' id value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CancelCharge.label","ca_labels")%>' onClick="cancelCharge(this);" style="display:none" >
					<input type='BUTTON' class='BUTTON' name='Print' id='Print' id value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="PrintPage();" style="display:none" >
					<input type='BUTTON' class='BUTTON' name='Back' id='Back' value='<< <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Back.label","common_labels")%>' onClick="loadNextPage(this)" style="display:none" >
					<input type='BUTTON' class='BUTTON' name='Next' id='Next' id value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")%> >>' onClick="loadNextPage(this);" style="display:none" >
					
					
				</td>
			</tr>
		</table>
	</p>
		<input type='hidden' name='bean_key' id='bean_key' value="">
		<input type='hidden' name='create_type' id='create_type' value="">
		<input type='hidden' name='cons_date' id='cons_date' value="">
		<input type='hidden' name='cons_time' id='cons_time' value="">
		<input type='hidden' name='practitionerId' id='practitionerId' value="">
	</form>
	</center>
</body>
</html>


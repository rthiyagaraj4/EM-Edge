<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	   

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  onKeyDown="lockKey()"  onKeyDown = 'lockKey()' >
<form name="MedicationAdministrationButton" id="MedicationAdministrationButton" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="2">
	<tr>			
		<td class="white" align='center' style='background-color:red;' id="discontinued_legend_id" width="10%">
			<label class="label" style="font-size:9;color:white" nowrap><b>&nbsp;<fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></b></label>
		</td>
		<td class="white" align='center' style='background-color:yellow;' id="hold_legend_id" width="10%"><label class="label" style="font-size:9;" ><b>&nbsp;<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></b></label></td>
		<td class="white" align='center' style='background-color:green;' id="administered_legend_id" width="10%"><label class="label" style="font-size:9;color:white" ><b>&nbsp;<fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/></b></label></td>
		<td class="white" align='center' style='background-color:#000000' id="could_not_admin_legend_id" width="12%">
			<label class="label" style="font-size:9;color:white"><b><fmt:message key="ePH.CouldNotAdminister.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
		<td class="white" align='center' id="verbal_legend_id" width="10%">
			<label class="label" style="font-size:9;"><b>V - <fmt:message key="ePH.VerbalOrders.label" bundle="${ph_labels}"/></b></label>
		</td>
		<td class="white" align='center' style='background-color:#CCFFCC' id="controlled_legend_id" width="10%">
			<label class="label" style="font-size:9;"><b><fmt:message key="ePH.ControlledDrug.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
</tr>
<tr>		
		<td class="white" align='center' style='background-color:silver' id="prn_legend_id" width="6%">
			<label class="label" style="font-size:9;color:black"><b>&nbsp;<fmt:message key="ePH.FutureDose.label" bundle="${ph_labels}"/></b></label>
		</td>

		<td class="white" align='center' style='background-color:#FF8000' id="sta_legend_id" >
			<label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.AdminNotRecorded.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
		<td class="white" align='center' style='background-color:#66FFFF' id="narcotic_legend_id">
			<label class="label" style="font-size:9;"><b><fmt:message key="ePH.NarcoticDrug.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
		<td class="white" align='center' style='background-color:#FFBFBF' id="iv_fluid_legend_id">
			<label class="label" style="font-size:9;"><b><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
		<td class="white" align='center' style='background-color:#FFDFDF' id="iv_ingredient_legend_id" >
			<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
		<td class="white" align='center' style='background-color:#EFDFFF' id="compound_legend_id" >
			<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/>&nbsp;</b></label>
		</td>
		
	</tr>
</table>
</form>
</body>
</html>


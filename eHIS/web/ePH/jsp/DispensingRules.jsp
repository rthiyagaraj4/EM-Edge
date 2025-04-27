<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DiscontinueDrug.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugDetailsDisplay.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start onKeyDown="lockKey()" */


	String	bean_id			=	"DrugDetailsBean" ;
	String	bean_name		=	"ePH.DrugDetailsBean";

    DrugDetailsBean bean = (DrugDetailsBean)getBeanObject( bean_id,bean_name, request ) ;
    bean.setLanguageId(locale);
// bean.getDispensingRuleDetails();

	String licenceRights = PhLicenceRights.getKey();




%>
<form name="DiscontinueDrugDetailsDosageDispensing" id="DiscontinueDrugDetailsDosageDispensing" >

<table cellpadding="0" cellspacing="0"  width="90%" align="center" border="0">
<BR>
<tr>
<th colspan="6"><fmt:message key="ePH.PrescribingDetails.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="ePH.BaseUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" nowrap colspan=5>&nbsp;<B><%=bean.getPRES_BASE_UOM_DESC()%></B></TD>
</tr>
<tr>
<td  class="label"  nowrap><fmt:message key="Common.Strength.label" bundle="${common_labels}"/>&nbsp;</td>

<%
/*============================================================================================================*/
		String strength_value = bean.getSTRENGTH_VALUE();
     if(!strength_value.equals("")){
		if(Float.parseFloat(strength_value) < 1)
			strength_value = "0"+strength_value;
	 }
/*============================================================================================================*/
%>
<td  class="label" nowrap colspan=5><B><%=strength_value%></B>&nbsp;<B><%=bean.getSTRENGTH_UOM_DESC()%></B></TD>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="ePH.StrengthInBaseUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
<%
/*============================================================================================================*/
		String strength_per_pres_uom = bean.getSTRENGTH_PER_PRES_UOM();
		if(strength_per_pres_uom!=null && !strength_per_pres_uom.equals("") && Float.parseFloat(strength_per_pres_uom) < 1)
			strength_per_pres_uom =Float.parseFloat(strength_per_pres_uom)+"";
/*============================================================================================================*/
%>
<td  class="label" nowrap colspan=5><B><%=strength_per_pres_uom%></B>&nbsp;<B><%=bean.getSTRENGTH_UOM_DESC()%></B></TD>
</tr>
<tr>
<td  class="label"  nowrap><fmt:message key="ePH.perVol/Quantity.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" nowrap colspan=5>&nbsp;<B><%=bean.getSTRENGTH_PER_VALUE_PRES_UOM()%></B>&nbsp;<B><%=bean.getPRES_BASE_UOM_DESC()%></B></TD>
</tr>
<tr>
	<td  class="label" nowrap><fmt:message key="ePH.CalculateByFreqDurn.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td  class="label" colspan="5">
	<B><%=getImage(bean.getCALC_DOSG_BY_FREQ_DURN_YN())%></B></TD>
</tr>
<%
	if(!licenceRights.equals("PHBASIC")){
%>
<tr>
	<th colspan="6"><fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></th>
</tr>

<tr>
<td  class="label" nowrap ><fmt:message key="ePH.FractionalDoseRoundUp.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" colspan="5"><B><%=getImage(bean.getFRACT_DOSE_ROUND_UP_YN())%></B></TD>
</tr>

<tr>
	<td  class="label" nowrap><fmt:message key="ePH.StockUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td  class="label" ><B><%=bean.getSTOCK_UOM_DESC()%></B></TD>
	<td  class="label" nowrap colspan="3"><fmt:message key="ePH.PackSizeInBaseUnit.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td  class="label" ><B><%=bean.getCONTENT_IN_PRES_BASE_UOM()%></B></TD>
</tr>
<tr>
	<td  class="label"  nowrap><fmt:message key="ePH.DispenseByMultiStrength.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td  class="label"><B><%=getImage(bean.getDISP_MULTI_STRENGTH_YN())%></B></TD>
	<TD ALIGN="LEFT" CLASS="label" colspan=4></td>
	<!-- <td  class="label"nowrap colspan="3"><fmt:message key="ePH.IPFillProcess.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td  class="label"><B><%=getImage(bean.getIP_FILL_PROCESS())%></B></TD> -->
</tr>

<tr>
<td  class="label" nowrap><fmt:message key="ePH.PRNDosesForPrescribedPeriodFill.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label"><B><%=getImage(bean.getPRN_DOSES_PRES_PRD_FILL())%></B></TD>
<td  class="label"nowrap colspan="3"><fmt:message key="ePH.ForContinuousFill.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" nowrap>
<B><%=bean.getPRN_DOSES_CONT_DAILY_FILL()%><fmt:message key="ePH.Perday.label" bundle="${ph_labels}"/></B></TD>
</tr>
<!-- *****************   dispensing controls  ************************************ -->
<tr >
		<th colspan="6"><fmt:message key="ePH.DispensingControls.label" bundle="${ph_labels}"/></th>
</tr>

<tr>
<td  class="label" nowrap><fmt:message key="ePH.AuthorizeonDispensing.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label"><B><%=getImage(bean.getDISP_AUTH_REQD_YN())%></B></TD>
<td  class="label" nowrap colspan="3"><fmt:message key="ePH.DispenseViaPrescriptionOnly.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label"><B><%=getImage(bean.getDISP_VIA_PRES_ONLY_YN())%></B></TD>
</tr>
<tr>
<td  class="label" nowrap><fmt:message key="ePH.DispenseAgainstDamage.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" ><B><%=getImage(bean.getDISP_AGAINST_DAMAGE_YN())%></B></TD>
<td  class="label" colspan="4"></td>
<td  class="label" style='display:none'nowrap colspan="3"><fmt:message key="ePH.VerificationRequired.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label"  style='display:none'><B><%=getImage(bean.getVERIFICATION_REQD_YN())%></B></TD>
</tr>

<!-- *****************   labels   **************************** -->
<tr >
		<th colspan="6"><fmt:message key="ePH.Labels.label" bundle="${ph_labels}"/></th>
</tr>
<tr>
<td  class="label"><fmt:message key="ePH.Caution.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" colspan="5">
<B><%=bean.getCAUTION_LABEL_TEXT_ID1_DESC()%></B>&nbsp;
<B><%=bean.getCAUTION_LABEL_TEXT_ID2_DESC()%></B>
</TD>

</tr>

<tr>
<td  class="label" nowrap><fmt:message key="ePH.SpecialInstruction.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" nowrap colspan="5">
<B><%=bean.getSPL_INSTR_LABEL_TEXT_ID_DESC()%></B></TD>
</tr>

<tr>
<td  class="label" nowrap><fmt:message key="ePH.DirectionToPatient.label" bundle="${ph_labels}"/>&nbsp;</td>
<td  class="label" nowrap colspan="5"><B><%=bean.getHOW_TO_TAKE_TEXT()%></B>
</TD>
</tr>
<%
	}
%>
<tr>
	<th colspan="6"><fmt:message key="ePH.IVCharacteristics.label" bundle="${ph_labels}"/></th>
</tr>
<tr>
	<td  class="label" nowrap><fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td><B><%=getImage(bean.getIV_INGREDIENT_YN())%></B></TD>
	<td  class="label" nowrap><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td><B><%=getImage(bean.getIV_FLUID_YN())%></B></TD>
	<td  class="label" nowrap><fmt:message key="ePH.InfuseOver.label" bundle="${ph_labels}"/>&nbsp;</td>
	<td  class="label">
	<B><%=bean.getINFUSE_OVER_VALUE()%>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></B></td>
</tr>
<tr><td colspan="6">&nbsp;</td></tr>


</table>
</FORM>
<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("Y"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else
		return "<img src=\"../../eCommon/images/disabled.gif\">";
}
%>

</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>


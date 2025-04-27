<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
 		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="MedicationAdministrationButton" id="MedicationAdministrationButton" >
<%
		String bean_id	= "MedicationAdministrationFTBean";
		String bean_name= "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name , request);
		bean.setLanguageId(locale);
		String direct_admin = bean.validateForDirectAdmin();
		boolean enable_rx	= bean.enableVerbalRx();
		boolean issitespec_verbal_order_yn = bean.isSiteSpecific("PH","PLACED_VERBAL_ORDER_YN");//ADDED FOR GHL-CRF-0509
		boolean mar_unbill_med_blueColor_disable =  bean.isSiteSpecific("PH","ALLOW_MAR_DISP_UNBILL_MED");//added for NMC-JD-CRF-0186 US002&03 [45063]
		String alternate_drug=request.getParameter("alternate_drug");
		if(alternate_drug==null){
			alternate_drug = "";
		}
		String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String admin_to_date			=	 request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
		String nursing_unit	  = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String disp_locn_ward_yn=bean.locationSetUpVelibleYN(nursing_unit);//added for ghl-crf-0509
		
		String MAR_sch_level_yn	  = request.getParameter("MAR_sch_level_yn")==null?"":request.getParameter("MAR_sch_level_yn");
%>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
			<tr>			
				<td align='center' class="white"  style='background-color:red;' id="discontinued_legend_id" width="20%">
					<label class="label" style="font-size:9;color:white" nowrap><b>&nbsp;<fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></b></label>
				</td>
				<td align='center'  class="white"  style='background-color:yellow;' id="hold_legend_id" width="20%"><label class="label" style="font-size:9;" ><b>&nbsp;<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></b></label></td>
				<td align='center'  class="white"   style='background-color:green;' id="administered_legend_id" width="10%"><label class="label" style="font-size:9;color:white" ><b>&nbsp;<fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/></b></label></td>
				<td align='center'  class="white"  style='background-color:#000000' id="could_not_admin_legend_id" width="20%">
					<label class="label" style="font-size:9;color:white"><b><fmt:message key="ePH.CouldNotAdminister.label" bundle="${ph_labels}"/>&nbsp;</b></label>
				</td>
				<td align='center' class="white"   id="verbal_legend_id" width="15%">
					<label class="label" style="font-size:9;"><b>V - <fmt:message key="ePH.VerbalOrders.label" bundle="${ph_labels}"/></b></label>
				</td>
				<td align='center' class="white"  style='background-color:#CCFFCC' id="controlled_legend_id" width="15%">
					<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.ControlledDrug.label" bundle="${ph_labels}"/></b></label>
				</td>
			</tr>
			<tr>		
					<td align='center' class="white"  style='background-color:#804040' id="prn_legend_id">
						<label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.PRNDose.label" bundle="${ph_labels}"/></b></label>
					</td>

					<td align='center' class="white"   style='background-color:#CE00CE' id="sta_legend_id" >
						<label class="label" style="font-size:9;color:white"><b>&nbsp;<fmt:message key="ePH.STATDose.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td align='center' class="white" style='background-color:#66FFFF' id="narcotic_legend_id">
						<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.NarcoticDrug.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td align='center' class="white"  style='background-color:#FFBFBF' id="iv_fluid_legend_id">
						<label class="label" style="font-size:9;"><b><fmt:message key="ePH.IVFluid.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td align='center' class="white"  style='background-color:#FFDFDF' id="iv_ingredient_legend_id" >
						<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.IVIngredients.label" bundle="${ph_labels}"/></b></label>
					</td>
					<td align='center' class="white"  style='background-color:#E4CAFF' id="compound_legend_id" >
						<label class="label" style="font-size:9;"><b>&nbsp;<fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></b></label>
					</td>
				</tr>
				<%if(mar_unbill_med_blueColor_disable){%> <!-- added for NMC-JD-CRF-0186 US002&03 [45063] -->
				<tr> <!-- NMC-JD-CRF-0186[43323] --> 
					<td align='center'  class="white"  style='background-color:#0000FF' id="unbilled" width="10%">
						<label class="label" style="font-size:9;color:white"><b><fmt:message key="ePH.UnBilled.label" bundle="${ph_labels}"/>&nbsp;</b></label>
					</td>
				</tr>
				<%}%>
				<tr>
					<td colspan='6'>
<%
					//if(!MAR_sch_level_yn.equals("Y")){
%>
						<input type="button" name="btnViewAdminDetails" id="btnViewAdminDetails" value='<fmt:message key="ePH.ViewMedicationAdministrationChart.label" bundle="${ph_labels}"/>' class="button"  onClick="callMednDetails('<%=patient_id%>','<%=nursing_unit%>','<%=admin_to_date%>')">
<%
					//}
%>
					<input type='button' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' name='btnRecord' onClick="expandDrugDetails('Record')" class="button" style="display:none">
					<input type='button' value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' name='btnDelete' onClick="expandDrugDetails('Delete')" class="button" style="display:none">
					<input type='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' name='btnCancel' onClick="expandDrugDetails('Cancel')" class="button" style="display:none">
<%
					if(direct_admin.equals("Y") && enable_rx ){
						bean.setFunctionT("MAV");
%>
						<input type="button" class="button" name="btnAddEntry" id="btnAddEntry" value='<fmt:message key="ePH.VerbalOrders.label" bundle="${ph_labels}"/>' onclick="callPrescription('<%=issitespec_verbal_order_yn%>','<%=disp_locn_ward_yn%>')">
                      <%
					}
%>
					</td>		
				</tr>
			</table>
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


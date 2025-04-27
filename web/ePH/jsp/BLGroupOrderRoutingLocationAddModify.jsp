<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	try{
		String mode	= request.getParameter( "mode" ) ;
		String bean_id = "BLGroupOrderRoutingBean" ;
		String bean_name = "ePH.BLGroupOrderRoutingBean";
		if ( mode == null || mode.equals("") )
			return ;

		String facility_id=(String) session.getValue( "facility_id" );

		BLGroupOrderRoutingBean bean = (BLGroupOrderRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		//bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

		ArrayList all = bean.getDataForList();
		ArrayList performingFacility = (ArrayList)all.get(0);

		ArrayList billingGroup = bean.getBillingGroup();
		ArrayList customerGroup = bean.getCustomerGroup();
		String billing_type="";
		String cust_group_select     ="",cust_select="",polocy_select="";
		String claraltdisp="Y";
%>
		<form name="frmBLOrderRoutingLocation" id="frmBLOrderRoutingLocation" id=" BL Order Routing Location">
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" >
				<tr>
					<td class='COLUMNHEADER' colspan="6"><fmt:message key="ePH.RoutingLocations.label" bundle="${ph_labels}"/></td>
				</tr>
				<tr>
					<td class="label" width="10%" ><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/></td>
					<td width="35%" colspan='2' class="data"><select name="routing_level" id="routing_level" onChange="loadRoutingLevelRelatedElements(this)"  id="Routing Level">
							<option value="S"><fmt:message key="Common.source.label" bundle="${common_labels}"/></option>
							<option value="O"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
							<option value="D" selected><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
							<option value="G"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
							<option value="L"><fmt:message key="ePH.SpecialOrders.label" bundle="${ph_labels}"/></option>
							<OPTION value="M" ><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></OPTION>
							<OPTION value="H" ><fmt:message key="ePH.HomeLeave.label" bundle="${ph_labels}"/></OPTION><!-- added for Bru-HIMS-CRF-093[29960] -->
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgRoutingLevel"></img>
						<select name="routing_code" id="routing_code" onChange="loadRoutineStatDischargeBasedOnRoutingLevel(routing_level,this)" id="RoutingCode" style="display:inline"> 
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
							<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
							<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
							<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
						</select><input type="text" name="drug_desc" id="drug_desc" style="display:none;" size="45" maxlength="30" ><input type="button" value="?" name="btnDrug" id="btnDrug" style="display:none" class="button" onClick="searchForDrug(drug_desc)">
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgRoutingCode"></img>
						<input type="hidden" name="drug_code" id="drug_code" >
					</td>
					<td class="label" width="15%" ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/>	</td>
					<td width="35%" colspan='2' class="data"><select name="performing_facility_id" id="performing_facility_id" onChange="loadRoutineStatDischargeBasedOnFacility()" id="Performing Facility">
<%
						String selectFacility="";
						for (int i=0;i<performingFacility.size();i++){
							if (facility_id.equals(performingFacility.get(i))){
								selectFacility="selected";
							}
							else{
								selectFacility="";
							}
%>
							<option value="<%=performingFacility.get(i)%>" <%=selectFacility%> ><%=performingFacility.get(++i)%></option>
<%
						}
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgPerformingFacility"></img>
					</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
					<td class="data" colspan='2'><select name="billing_group" id="billing_group" id="Billing Group" onchange="disablefields();">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
						String selectGroup="";
						for (int i=0;i<billingGroup.size();i+=3){
							 billing_type=(String)billingGroup.get(i+2);
%>
							<OPTION  VALUE="<%= billingGroup.get(i) %>" type="<%=billingGroup.get(i+2)%>"><%= billingGroup.get(i+1) %></OPTION>
<% 
						}
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgBillingGroup"></img>
						</td>
						<td class='label' ><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="data"><select name="customer_group" id="customer_group" onChange="loadCustomer()" id="Customer Group">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
							for (int i=0;i<customerGroup.size();i+=2){
%>
								<OPTION  VALUE="<%= customerGroup.get(i) %>" ><%= customerGroup.get(i+1) %></OPTION>
<%					
							}
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgCustGroup"></img>
						</td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
						<td class="data" colspan='2'><select name="customer_id" id="customer_id"  onChange="loadPolocyType()" id="Customer">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgCust"></img>
						</td>
						<td class='label' ><fmt:message key="ePH.PolicyType.label" bundle="${ph_labels}"/></td>
						<td  class="data" colspan='2'><select name="polocy_type" id="polocy_type" id="Polocy Type">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgPolocyType"></img>
						</td>
					</tr>
					<tr>
						<td class='COLUMNHEADER' colspan="6" ><fmt:message key="ePH.DefaultDispenseLocation.label" bundle="${ph_labels}"/></ta>
					</tr>
					<tr>
						<td class="label" width='10%'><fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></td>
						<td width="25%" class="data"><select name="rtn_ord_disp_locn_code" id="rtn_ord_disp_locn_code" id="Routine" onChange='clearAltDispDtl("R");'>
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>					
							</select><img src="../../eCommon/images/mandatory.gif" align="center" id="imgRoutine"></img>
							<input type="button" name="rtn_alt" id="rtn_alt" value='<fmt:message key="ePH.Alternate.label" bundle="${ph_labels}"/>' class="button"  id="rtn_alt" onClick="AltDispLocn('R')">
						</td>
						<td class="label" width='10%' ><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></td>
						<td class="data" width='20%'><select name="stat_ord_disp_locn_code" id="stat_ord_disp_locn_code" id="Stat" onChange='clearAltDispDtl("S");'>
								<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							</select><img src="../../eCommon/images/mandatory.gif" align="center" id="imgStat"></img>
							<input type="button" name="stat_alt" id="stat_alt" value='<fmt:message key="ePH.Alternate.label" bundle="${ph_labels}"/>' class="button"  id="stat_alt" onClick="AltDispLocn('S')">
						</td>
						<td class="label" width='15%' nowrap><fmt:message key="ePH.Discharge/TakeHomeMedicationOrders.label" bundle="${ph_labels}"/></td>
						<td class="data" width='20%' ><select name="disch_ord_disp_locn_code" id="disch_ord_disp_locn_code" id="Discharge/Take Home Medication" onChange='clearAltDispDtl("D");'>
								<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							</select><img src="../../eCommon/images/mandatory.gif" align="center" id="imgDisch"></img>
							<input type="button" name="discharge_alt" id="discharge_alt" value='<fmt:message key="ePH.Alternate.label" bundle="${ph_labels}"/>' class="button"  id="discharge_alt" onClick="AltDispLocn('D')">
						</td>
					</tr>
				</table>
				<input type="hidden" name="locale" id="locale" value="<%=locale%>">
				<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
				<input type="hidden" name="facility_id" id="facility_id" value="<%= (String) session.getValue( "facility_id" ) %>">
				<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
				<INPUT TYPE="hidden" name="billing_type" id="billing_type" VALUE="<%=billing_type%>">
				<INPUT TYPE="hidden" name="claraltdisp" id="claraltdisp" VALUE="<%=claraltdisp%>">
				<INPUT TYPE="hidden" name="currRowNo" id="currRowNo" VALUE="">
		</form>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch ( Exception fe ) {
		fe.printStackTrace() ;
	}
%>
	</body>
</html>


<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%

	request.setCharacterEncoding("UTF-8");
			
			//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 ends
			
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/OrderRouting.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> -->
		<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "OrderRoutingBean" ;
	String bean_name = "ePH.OrderRoutingBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	String facility_id=(String) session.getValue( "facility_id" );

	/* Initialize Function specific start */
	OrderRoutingBean bean = (OrderRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	ArrayList all = bean.getDataForList();
	ArrayList performingFacility = (ArrayList)all.get(0);
	
	/* Initialize Function specific end */

%>
<form name="frmOrderRoutingLocation" id="frmOrderRoutingLocation" id="Order Routing Location">
	<table cellpadding=0 cellspacing=2 width="100%" align="center" border="0" >
		<tr>
			<th colspan="4"><fmt:message key="ePH.RoutingLocations.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr>
			<td class="label" width="35%"><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/></td>
			<td  colspan='3'>&nbsp;
				<select name="routing_level" id="routing_level" onChange="loadRoutingLevelRelatedElements(this)"  id="Routing Level">
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
			</td>		
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/>	</td>
			
			<td colspan="3">&nbsp;
				<select name="performing_facility_id" id="performing_facility_id" onChange="loadRoutineStatDischargeBasedOnFacility()" id="Performing Facility">
				<%
					String selectFacility="";
					for (int i=0;i<performingFacility.size();i++){
						if (facility_id.equals(performingFacility.get(i))){
							selectFacility="selected";
						}else{
							selectFacility="";
						}
				%>
					<option value="<%=performingFacility.get(i)%>" <%=selectFacility%> id="<%=performingFacility.get(i)%>"><%=performingFacility.get(++i)%></option>
				<%
					}
				%>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center" id="imgPerformingFacility"></img>
			</td>
		</tr>
		<tr>
			<th colspan="4" ><fmt:message key="ePH.DefaultDispenseLocation.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
			<td class="label"  width="35%"><fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></td>
			<td width="25%">&nbsp;
				<select name="rtn_ord_disp_locn_code" id="rtn_ord_disp_locn_code" id="Routine">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>					
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center" id="imgRoutine"></img>
			</td>


		<td class="label"><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></td>


			<td width="30%">&nbsp;
				<select name="stat_ord_disp_locn_code" id="stat_ord_disp_locn_code" id="Stat">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center" id="imgStat"></img>
			</td>
		</tr>
		<tr>
			<td class="label"  nowrap><fmt:message key="ePH.Discharge/TakeHomeMedicationOrders.label" bundle="${ph_labels}"/></td>
			<td colspan="3">&nbsp;
				<select name="disch_ord_disp_locn_code" id="disch_ord_disp_locn_code" id="Discharge/Take Home Medication">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center" id="imgDisch"></img>
			</td>
		</tr>
		<tr>  
			<td colspan="4" align='right'>
				<input type="button" name="" id="" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="AddRow()">
				<input type="button" name="" id="" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button"  onClick="ResetToDefaultValues()">
			</td>
		</tr>
	</table>
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%= (String) session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


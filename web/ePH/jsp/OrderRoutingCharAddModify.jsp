<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

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
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<!--<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
	<!--<script language="Javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../ePH/js/OrderRouting.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</script>
</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "OrderRoutingBean" ;
	String bean_name = "ePH.OrderRoutingBean";
	String facility_id=(String) session.getValue( "facility_id" );
//	out.println("facility_id======41====OrderRoutingCharAddmodify== ordering facility==>" +facility_id);

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	OrderRoutingBean bean = (OrderRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	/* Initialize Function specific end */
	ArrayList all = bean.getDataForList();
	//out.println("(String)all.get(1)======57===> " +(String)all.get(1));
%>
<form name="frmOrderRoutingCharacteristics" id="frmOrderRoutingCharacteristics" id="Order Routing Characteristics">

<%
	if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){
		String IPInstalled = (String)all.get(3);
		
%>
	<table cellpadding=0 cellspacing=2 width="100%" border="0">
		<tr>
			<th colspan="2" ><fmt:message key="ePH.OrderingCharacteristics.label" bundle="${ph_labels}"/></td>
		</tr>
		
		<tr>
		
		<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
			<td >&nbsp;
				<input type="text" name="ordering_facility_desc" id="ordering_facility_desc" value="<%=(String)all.get(1)%>" size="30" maxlength="30" disabled>
				<img src="../../eCommon/images/mandatory.gif" ></img>
				<input type="hidden" value="<%= facility_id %>" name="ordering_facility_id">
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td >&nbsp;
				<select name="ordering_source_type" id="ordering_source_type" onChange="loadRelatedLocation(this);loadRoutineStatDischargeBasedOnFacility()">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				    <option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
				<%
					if (IPInstalled.equals("Y")){
				%>
					<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
				<%
					}
				%>
				</select>
				<img src="../../eCommon/images/mandatory.gif" ></img>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td >&nbsp;
				<select name="ordering_source_code" id="ordering_source_code" onChange="validateForRoutingLevel(this)" >
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
	</table>
	<%
		}else if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){

			String ordering_facility_desc = request.getParameter("ordering_facility_desc");
			String ordering_facility_id = request.getParameter("ordering_facility_id");
			String ordering_source_type_desc = request.getParameter("ordering_source_type_desc");
			String ordering_source_type = "";
			if ((ordering_source_type_desc.trim()).equals("Nursing Unit")||(ordering_source_type_desc.trim()).equals("Day Care")){
				ordering_source_type = "N";
			}
			else{
				ordering_source_type = "C";
			}




			String ordering_source_code = request.getParameter("ordering_source_code");
			String ordering_source_code_desc = request.getParameter("ordering_source_code_desc");
			String routing_level = request.getParameter("routing_level").trim();
			String routing_code = "",routing_code_desc = "";
			String sourceSelect ="",orderTypeSelect="",drugClassSelect="",drugSelect="",splOrdersSelect="",medicalSelect="",HomeLeaveSelect="";//added HomeLeaveSelect for Bru-HIMS-CRF-093[29960] -->
			String disableRoutingLevel="";
			String disableRoutingCode = "disabled";
			String disableFacility = "";
			String disableDischargeRelated = "";
			

			if (!routing_level.equals("S")){
				routing_code = request.getParameter("routing_code");
				routing_code = routing_code.trim();
				routing_code_desc = request.getParameter("routing_code_desc");
				disableFacility = "";
				disableDischargeRelated ="";
			}
			if (routing_level.equals("S")){
				sourceSelect="selected";
				orderTypeSelect = "";
				drugClassSelect = "";
				drugSelect = "";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "disabled";
				disableDischargeRelated = "disabled";
				routing_code = "";
				routing_code_desc = "";
			}else if (routing_level.equals("O")){
				sourceSelect = "";
				orderTypeSelect = "selected";
				drugClassSelect = "";
				drugSelect = "";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}else if (routing_level.equals("D")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "selected";
				drugSelect = "";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}else if (routing_level.equals("G")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "";
				drugSelect = "selected";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}else if (routing_level.equals("M")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "";
				medicalSelect = "selected";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}else if (routing_level.equals("L")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "";
				drugSelect = "";
				splOrdersSelect ="selected";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}else if (routing_level.equals("H")){ // added else if condition for Bru-HIMS-CRF-093[29960] 
				sourceSelect="";
				orderTypeSelect = "";
				drugClassSelect = "";
				drugSelect = "";
				splOrdersSelect ="";
				HomeLeaveSelect ="selected";
				disableRoutingLevel = "disabled";
				disableFacility = "";
				disableDischargeRelated = "";
			}
			ArrayList performingFacility = (ArrayList)all.get(0);

			ArrayList defaultLoc = null;
			ArrayList defaultLocD = null;

			
			if(routing_code.equals("ALLA") || routing_code.equals("CMPA") || routing_code.equals("IVOA") || routing_code.equals("ONCA") || routing_code.equals("TPNA")){
				bean.setDispLocnForAdmixtures("Y");
			}else{
				bean.setDispLocnForAdmixtures("N");
			}
			ArrayList loadData = (ArrayList)bean.loadData(ordering_facility_id,ordering_source_type,ordering_source_code,routing_level.trim(),routing_code);
			
			String performing_facility_id	="";
			String rtn_ord_disp_locn_code	="";
			String stat_ord_disp_locn_code	="";
			String disch_ord_disp_locn_code ="";


			if (loadData.size()>0){
				performing_facility_id	= (String)loadData.get(0);
				rtn_ord_disp_locn_code	= (String)loadData.get(1);
				stat_ord_disp_locn_code = (String)loadData.get(2);
				disch_ord_disp_locn_code= (String)loadData.get(3);

			}
			if(disch_ord_disp_locn_code==null){
				disch_ord_disp_locn_code="";
			}
			
		    if (routing_level.equals("G")){

				//defaultLoc = (ArrayList)bean.getDefaultDispLocDataForDrug(facility_id,ordering_source_type,routing_code);
				//defaultLoc is for Routine and Stat order lists & defaultLocD is for Discharge Medication List
				//Lists separated based on disp_locn_category  --- 18-Jan 2010  -- Shyampriya - IN17548

				defaultLoc =(ArrayList)bean.getDefaultDispLocDataForDrug(performing_facility_id,ordering_source_type,routing_code);
				defaultLocD = (ArrayList)bean.getDefaultDispLocDataForDrugD(performing_facility_id,ordering_source_type,routing_code);
			}else if (!routing_level.equals("G")){
				
				//defaultLoc = (ArrayList)bean.getDataForDefaultDispenseLocation(facility_id,ordering_source_type,routing_code,routing_level);
				//defaultLoc is for Routine and Stat order lists & defaultLocD is for Discharge Medication List
				//Lists separated based on disp_locn_category  --- 18-Jan 2010  -- Shyampriya - IN17548

				defaultLoc = (ArrayList)bean.getDataForDefaultDispenseLocation(performing_facility_id,ordering_source_type,routing_code,routing_level);
				defaultLocD = (ArrayList)bean.getDataForDefaultDispenseLocationD(performing_facility_id,ordering_source_type,routing_code,routing_level);
			}
			
	%>
	<br><br><br><br><br><br>
	<table cellpadding=0 cellspacing=3 width="80%" align="center" border="0">
		<tr><td colspan="2">&nbsp;</td></tr>
		<tr>
			
		<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>

			<td >
				<input type="text" name="ordering_facility_desc" id="ordering_facility_desc" value="<%=ordering_facility_desc%>" disabled>
				<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<input type="text" name="ordering_source_type_desc" id="ordering_source_type_desc" value="<%=ordering_source_type_desc%>" disabled>
				<input type="hidden" name="ordering_source_type" id="ordering_source_type" value="<%=ordering_source_type%>">
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<input type="text" name="ordering_source_code_desc" id="ordering_source_code_desc" value="<%=ordering_source_code_desc%>" disabled>
				<input type="hidden" name="ordering_source_code" id="ordering_source_code" value="<%=ordering_source_code%>">
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<select name="routing_level" id="routing_level" <%=disableRoutingLevel%> >
					<option value="S" <%=sourceSelect%>><fmt:message key="Common.source.label" bundle="${common_labels}"/></option>
					<option value="O" <%=orderTypeSelect%>><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></option>
					<option value="D" <%=drugClassSelect%>><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
					<option value="G" <%=drugSelect%>><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					<option value="L" <%=splOrdersSelect%>><fmt:message key="ePH.SpecialOrders.label" bundle="${ph_labels}"/></option>
					<OPTION value="M" <%=medicalSelect%>><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></OPTION>
					<OPTION value="H" <%=HomeLeaveSelect%>><fmt:message key="ePH.HomeLeave.label" bundle="${ph_labels}"/></OPTION><!-- added for Bru-HIMS-CRF-093[29960] -->
				
				</select>
			</td>
		</tr>
				<tr>
			<td class="label" ><fmt:message key="ePH.RoutingCode.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<input type="hidden" name="routing_code" id="routing_code" value="<%=routing_code%>" >
				<input type="text" name="routing_code_desc" id="routing_code_desc" size=40 value="<%=routing_code_desc%>" <%=disableRoutingCode%>>
				<%
				%>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/>	</td>
		
			<td>
				<select name="performing_facility_id" id="performing_facility_id" <%=disableFacility%> onChange="onChangeOfPerformingFacility()">
				<%
					String selectFacility="";
					for (int i=0;i<performingFacility.size();i=i+2){
						if (routing_level.equals("S")){
							//if (facility_id.equals((String)performingFacility.get(i))) Commented by Sandhya regarding incident num:25180 on 24/Nov/2010

							if (performing_facility_id.equals((String)performingFacility.get(i))){
								selectFacility="selected";
							}else{
								selectFacility="";
							}
						}else{
							if (performing_facility_id.equals(performingFacility.get(i))){
								selectFacility="selected";
							}else{
								selectFacility="";
							}
						}
				%>
					<option value="<%=performingFacility.get(i)%>" <%=selectFacility%> id="<%=performingFacility.get(i)%>"><%=performingFacility.get(i+1)%></option>
				<%
					}
				%>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				
				</select>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.routine.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<select name="rtn_ord_disp_locn_code" id="rtn_ord_disp_locn_code" <%=disableDischargeRelated%>>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>

					<%
							String selectRoutine = "";
							for(int i=0;i<defaultLoc.size();i++){
							if (rtn_ord_disp_locn_code.equals(defaultLoc.get(i))){
								selectRoutine="selected";
							}else{
								selectRoutine="";
							}
					%>
							<option value="<%=defaultLoc.get(i)%>" <%=selectRoutine%>><%=defaultLoc.get(++i)%></option>
					<%
							}
					%>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					<%
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.Stat.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<select name="stat_ord_disp_locn_code" id="stat_ord_disp_locn_code" <%=disableDischargeRelated%>>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						String selectStat = "";
							for(int i=0;i<defaultLoc.size();i++){
								if (stat_ord_disp_locn_code.equals(defaultLoc.get(i))){
									selectStat="selected";
								}else{
									selectStat="";
								}
					%>
							<option value="<%=defaultLoc.get(i)%>" <%=selectStat%>><%=defaultLoc.get(++i)%></option>
					<%
					%>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					<%
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="ePH.Discharge/TakeHomeMedication.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
			<td>
				<select name="disch_ord_disp_locn_code" id="disch_ord_disp_locn_code" <%=disableDischargeRelated%>>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
							String selectDischarge = "";
							for(int i=0;i<defaultLocD.size();i++){
								if (disch_ord_disp_locn_code.equals(defaultLocD.get(i))){
									selectDischarge="selected";
								}else{
									selectDischarge="";
								}
					%>
							<option value="<%=defaultLocD.get(i)%>" <%=selectDischarge%>><%=defaultLocD.get(++i)%></option>
					<%
							}
					%>

				</select>
			</td>
		</tr>
		<tr><td colspan="2">&nbsp;</td></tr>
	</table>
	<%
		}
	%>
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


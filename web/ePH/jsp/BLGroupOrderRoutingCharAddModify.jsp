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
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	try{
		String mode	= request.getParameter( "mode" ) ;
		String bean_id = "BLGroupOrderRoutingBean" ;
		String bean_name = "ePH.BLGroupOrderRoutingBean";
		String facility_id=(String) session.getValue( "facility_id" );
		String claraltdisp="Y";

		if ( mode == null || mode.equals("") ){
			mode=CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
		}
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;
		BLGroupOrderRoutingBean bean = (BLGroupOrderRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		ArrayList all = bean.getDataForList();
		ArrayList billingGroup = bean.getBillingGroup();
		ArrayList customerGroup = bean.getCustomerGroup();
%>
		<form name="frmOrderRoutingCharacteristicsForBL" id="frmOrderRoutingCharacteristicsForBL" id="Order Routing Characteristics For BL Group">

<%
			if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ))){
				String IPInstalled = (String)all.get(3);
%>
				<table cellpadding=0 cellspacing=3 width="100%" border="0">
					<tr>
						<th colspan="6" ><fmt:message key="ePH.OrderingCharacteristics.label" bundle="${ph_labels}"/></td>
					</tr>
					<tr>
					<td class="label" width='12%'><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					<td class="label" width='23%'><input type="text" name="ordering_facility_desc" id="ordering_facility_desc" value="<%=(String)all.get(1)%>" size="40"  disabled>
						<img src="../../eCommon/images/mandatory.gif" ></img>
						<input type="hidden" value="<%=facility_id%>" name="ordering_facility_id" id="ordering_facility_id">
					</td>
					<td class="label" width='10%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td class="label" width='15%'><select name="ordering_source_type" id="ordering_source_type" onChange="loadRelatedLocation(this);loadRoutineStatDischargeBasedOnFacility()">
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
						</select><img src="../../eCommon/images/mandatory.gif" ></img>
					</td>
					<td class="label" width='10%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class="label" width='15%'><select name="ordering_source_code" id="ordering_source_code" onChange="validateForRoutingLevel(this)" >
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
			</table>
<%
		}
		else if (mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){

			String ordering_facility_desc = request.getParameter("ordering_facility_desc");
			String ordering_facility_id = request.getParameter("ordering_facility_id");
			String ordering_source_type_desc = request.getParameter("ordering_source_type_desc");
			String billing_group_code = request.getParameter("billing_group_code");
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
			String sourceSelect ="",orderTypeSelect="",drugClassSelect="",drugSelect="",splOrdersSelect="",medicalSelect="",HomeLeaveSelect="",billing_type="",disabel_bl="",disabel_bl_pol="";
			String disableRoutingLevel="";
			String disableRoutingCode = "disabled";
			String disableFacility = "";
			String disableDischargeRelated = "";
			String disable_alt="";
			if(ordering_source_code.equals("*A"))
				disable_alt="disabled";
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
			}
			else if (routing_level.equals("O")){
				sourceSelect = "";
				orderTypeSelect = "selected";
				drugClassSelect = "";
				drugSelect = "";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}
			else if (routing_level.equals("D")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "selected";
				drugSelect = "";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}
			else if (routing_level.equals("G")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "";
				drugSelect = "selected";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}
			else if (routing_level.equals("M")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "";
				medicalSelect = "selected";
				splOrdersSelect ="";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}
			else if (routing_level.equals("L")){
				sourceSelect = "";
				orderTypeSelect = "";
				drugClassSelect = "";
				drugSelect = "";
				splOrdersSelect ="selected";
				disableRoutingLevel = "disabled";
				disableFacility = "";
			}
			else if (routing_level.equals("H")){ 
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
			}
			else{
				bean.setDispLocnForAdmixtures("N");
			}
			
			
			String performing_facility_id	="";
			String rtn_ord_disp_locn_code	="";
			String stat_ord_disp_locn_code	="";
			String disch_ord_disp_locn_code ="";
			String bl_group_code            =request.getParameter("billing_group_code");
			String bl_cust_group_code       =request.getParameter("bl_cust_group_id");
			String bl_cust_code             =request.getParameter("bl_cust_id");
			String bl_polocy_type_code      =request.getParameter("bl_polocy_id");

			ArrayList loadData = (ArrayList)bean.loadData(ordering_facility_id,ordering_source_type,ordering_source_code,routing_level.trim(),routing_code,billing_group_code,bl_cust_group_code,bl_cust_code,bl_polocy_type_code);

			if (loadData.size()>0){
				performing_facility_id	= (String)loadData.get(0);
				rtn_ord_disp_locn_code	= (String)loadData.get(1);
				stat_ord_disp_locn_code = (String)loadData.get(2);
				disch_ord_disp_locn_code= (String)loadData.get(3);
				bl_group_code           = (String)loadData.get(4);
				bl_cust_group_code      = (String)loadData.get(5);
				bl_cust_code            = (String)loadData.get(6);
				bl_polocy_type_code     = (String)loadData.get(7);
			}
			
			ArrayList customer = bean.getCustomer(bl_cust_group_code);
			ArrayList polocyType = bean.getPolocyType(bl_cust_group_code,bl_cust_code,facility_id);
			if(disch_ord_disp_locn_code==null){
				disch_ord_disp_locn_code="";
			}
			
		    if (routing_level.equals("G")){
				defaultLoc =(ArrayList)bean.getDefaultDispLocDataForDrug(ordering_facility_id,ordering_source_type,routing_code);
				defaultLocD = (ArrayList)bean.getDefaultDispLocDataForDrugD(ordering_facility_id,ordering_source_type,routing_code);
				
			}
			else if (!routing_level.equals("G")){
				defaultLoc = (ArrayList)bean.getDataForDefaultDispenseLocation(ordering_facility_id,ordering_source_type,routing_code,routing_level);
				defaultLocD = (ArrayList)bean.getDataForDefaultDispenseLocationD(ordering_facility_id,ordering_source_type,routing_code,routing_level);
				
			}
			
%>
			<br><br><br><br><br><br>
			<table cellpadding=0 cellspacing=3 width="80%" align="center" border="0">
				<tr>
				<td class="label"><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td>
					<td >
						<input type="text" name="ordering_facility_desc" id="ordering_facility_desc" value="<%=ordering_facility_desc%>" disabled>
						<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
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
						
						</select><img src="../../eCommon/images/mandatory.gif" align="center"></img> <!--added for MMS_BETA_0043[046240] -->
					</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="ePH.RoutingCode.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td>
						<input type="hidden" name="routing_code" id="routing_code" value="<%=routing_code%>" >
						<input type="text" name="routing_code_desc" id="routing_code_desc" size=40 value="<%=routing_code_desc%>" <%=disableRoutingCode%>>
						 <% if(!routing_code_desc.equals("")){ //added for MMS_BETA_0043[046240] 
						 %><img src="../../eCommon/images/mandatory.gif" align="center"></img><%} %>
					</td>
					<td class="label" ><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/>	</td>
					<td>
						<select name="performing_facility_id" id="performing_facility_id" <%=disableFacility%> onChange="onChangeOfPerformingFacility()" disabled>
<%
						String selectFacility="";
						for (int i=0;i<performingFacility.size();i=i+2){
							if (routing_level.equals("S")){

								if (performing_facility_id.equals((String)performingFacility.get(i))){
									selectFacility="selected";
								}
								else{
									selectFacility="";
								}
							}
							else{
								if (performing_facility_id.equals(performingFacility.get(i))){
									selectFacility="selected";
								}
								else{
									selectFacility="";
								}
							}
%>
							<option value="<%=performingFacility.get(i)%>" <%=selectFacility%> id="<%=performingFacility.get(i)%>"><%=performingFacility.get(i+1)%></option>
<%
						}
%>
					</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
			</tr>
			<tr>
		     <td class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			 <td>
				<select name="billing_group" id="billing_group" id="Billing Group"  disabled>
				   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
					String selectGroup="";
					for (int i=0;i<billingGroup.size();i+=3){
						if (bl_group_code.equals(billingGroup.get(i))){
							selectGroup="selected";
							billing_type=(String)billingGroup.get(i+2);
							 if(billing_type.equals("C")){
								 disabel_bl="disabled";
								 disabel_bl_pol="disabled";
							 }
							 else if(billing_type.equals("R")){
								
								 disabel_bl="";
								 disabel_bl_pol="disabled";
							}
							else{
								 disabel_bl="";
								 disabel_bl_pol="";
							}
						}
						else{
							selectGroup="";
						}
%>
							<OPTION  VALUE="<%= billingGroup.get(i) %>" <%=selectGroup%>><%= billingGroup.get(i+1) %></OPTION>
<%    
						}
%>
				  </select><img src="../../eCommon/images/mandatory.gif" align="center"></img> <!--added for MMS_BETA_0043[046240] -->
			 </td>
			   <td class="label"><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
			   <td>
				 <select name="customer_group" id="customer_group" onChange="loadCustomer()" id="Customer Group" disabled <%=disabel_bl%>>
					 <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
	                    String selectCustGroup="";
						for (int i=0;i<customerGroup.size();i+=2){
							if(bl_cust_group_code!=null){
							if (bl_cust_group_code.equals(customerGroup.get(i))){
										selectCustGroup="selected";
									}else{
										selectCustGroup="";
									}
							}
%>
							<OPTION  VALUE="<%= customerGroup.get(i) %>" <%=selectCustGroup%>><%= customerGroup.get(i+1) %></OPTION>
<%
						}
%>
				  </select>
<%
				if(disabel_bl.equals("")){
%>
					<img src="../../eCommon/images/mandatory.gif" align="center" id="imgCustGroup"></img>
<%
				}
%>
			   </td>
            <tr>
				<td class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
				   <select name="customer_id" id="customer_id"  onChange="loadPolocyType()" id="Customer" disabled <%=disabel_bl%>>
					   <option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
  <%
					         String selectCustomer="";
					         for (int i=0;i<customer.size();i+=2){
								 if(bl_cust_code!=null){
						          if (bl_cust_code.equals(customer.get(i))){
									      selectCustomer="selected";
								  }else{
									       selectCustomer="";
								     }
								 }
%>
									<OPTION  VALUE="<%= customer.get(i) %>" <%=selectCustomer%>><%= customer.get(i+1) %></OPTION>
<%							}
%>
				   </select>
<%
				if(disabel_bl.equals("")){
%>
					<img src="../../eCommon/images/mandatory.gif" align="center" id="imgCust"></img>
<%
				}
%>
				</td>
				<td class="label"><fmt:message key="ePH.PolicyType.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
				 <td>
					<select name="polocy_type" id="polocy_type" id="Polocy Type" disabled <%=disabel_bl_pol%>>
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
<%
						String selectPolocy="";
						for (int i=0;i<polocyType.size();i+=2){
							if(bl_polocy_type_code!=null){
								if (bl_polocy_type_code.equals(polocyType.get(i))){
									selectPolocy="selected";
								}
								else{
									selectPolocy="";
								}
							}
%>
							<OPTION  VALUE="<%= polocyType.get(i) %>" <%=selectPolocy%>><%= polocyType.get(i+1) %></OPTION>
<%
						}
%>
				   </select>
<%
					if(disabel_bl_pol.equals("")){
%>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="imgPolocyType"></img>
<%
					}
%>
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
				<input type="button" name="" id="" value='<fmt:message key="ePH.Alternate.label" bundle="${ph_labels}"/>' class="button" onClick="AltDispLocnForAmend('R')" <%=disable_alt%>>
			</td>
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
				<input type="button" name="" id="" value='<fmt:message key="ePH.Alternate.label" bundle="${ph_labels}"/>' class="button" onClick="AltDispLocnForAmend('S')" <%=disable_alt%>>
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
				<input type="button" name="" id="" value='<fmt:message key="ePH.Alternate.label" bundle="${ph_labels}"/>' class="button" onClick="AltDispLocnForAmend('D')" <%=disable_alt%>>
			</td>
           </tr>
		</table>
		<INPUT TYPE="hidden" name="billing_type" id="billing_type" VALUE="<%=billing_type%>">
<%
		}
%>
	<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%= (String) session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<INPUT TYPE="hidden" name="claraltdisp" id="claraltdisp" VALUE="<%=claraltdisp%>">
</form>
</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
}
catch ( Exception e ) {
			e.printStackTrace() ;
			
		}
%>


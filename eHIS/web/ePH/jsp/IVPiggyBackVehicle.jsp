<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
		<script language="javascript" src="../js/DrugNameCommonLookup.js"></script>
		<script language="javascript" src="../js/IVPiggyBack.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%  
	String catalog_desc			 ="";
	String order_catalog_code	 ="";
	String qty_value			 ="";
	String readonly				 ="";
	String disabled              ="";
	String orderType			 ="";
	String equvalent_uom_code	 ="";
	String uom_desc	 ="";
	String volume_unit			 ="";
	String fluid_adr_style		 ="hidden";
	String remarks_visibility    ="visibility:hidden";
	String fluid_remarks_flag	 ="0";
    String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String patient_id	= request.getParameter("patient_id");
	String patient_class= request.getParameter("act_patient_class");
	String encounter_id = request.getParameter("encounter_id");
	String mode                  = request.getParameter("mode")==null?"":request.getParameter("mode");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String order_id				 = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_type_flag		= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String iv_prep_default		= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
	String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String answer					= request.getParameter("answer")==null?"":request.getParameter("answer");
	String visibile="style=display:inline";
	String base_volume			= "";	
	String bean_id			= "IVPiggyBackBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPiggyBackBean";
	IVPiggyBackBean bean	= (IVPiggyBackBean)getBeanObject( bean_id, bean_name, request ) ;
	String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name			= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;
	HashMap record;
	String param_volume_cal=iv_bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	
	if(order_type_flag.equals("Existing")||mode.equals("amend")){
		if(order_type_flag.equals("Existing")){
			readonly="readonly";
			disabled="disabled";
		}
		ArrayList exstngIVorder = (ArrayList)iv_bean.getExistingIVRecords(order_id,answer,"");	//passed answer for IN24251 --16/12/2010-- priya  // RUT-CRF-0062
		record=new HashMap();
		int siz=exstngIVorder.size();
		String lengt=siz+"";
		if(lengt.equals("1")){
			visibile="style=visibility:hidden";
		}
		else{
			visibile="style=display:inline";
		}
		record=(HashMap)exstngIVorder.get(0);
		catalog_desc			=(String)record.get("CATALOG_DESC");
		order_catalog_code		=(String)record.get("ORDER_CATALOG_CODE");
		qty_value			    =(String)record.get("QTY_VALUE");
//commented by naveen during PE
		//orderType				= iv_bean.getOrderType(order_catalog_code);
		
		iv_bean.setFluidDetails(order_catalog_code,"","","",""); // CRF-0062 NEWLY ADDED

		HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();
		 orderType = (String)fluid_det.get("ORDER_TYPE_CODE");



		ArrayList stockDetails=iv_bean.getStockDetails(order_catalog_code, "1");
		volume_unit= qty_value;
		base_volume = (String)stockDetails.get(0);
		equvalent_uom_code=(String)stockDetails.get(1);
		uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),equvalent_uom_code);

		if(iv_bean.getFluidRemarks() != null && !(iv_bean.getFluidRemarks().equals(""))){
			remarks_visibility    ="visibility:visible";
			fluid_remarks_flag	  ="1";
		}
		else{
			remarks_visibility    ="visibility:hidden";
		}
		if(Integer.parseInt(adr_count)>0){
			int fluid_adr_count = iv_bean.getADRCount(patient_id,order_catalog_code);   
			if(fluid_adr_count>0)
			 fluid_adr_style="visible";
		}

	}
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<form name="formIVPiggyBackVehicle" id="formIVPiggyBackVehicle">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td class="COLUMNHEADER" colspan="4"><font style="font-size:9"><fmt:message key="ePH.FluidDetails.label" bundle="${ph_labels}"/></font></td>
				</tr>
				<tr>
					<td class="white"></td>
				</tr>
				<tr>
					<td class="white"></td>
				</tr>
				<tr>
					<td class="white"></td>
				</tr>
				<tr id="vehicle_det" <%=visibile%>>
					<td NOWRAP width="12" class="label"  ><img style="visibility:<%=fluid_adr_style%>" id="fluid_ADR_img" src='../../ePH/images/ADR.gif' height =25 width =25 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></td>
					<td width='50%' class="label">
						&nbsp;<fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/> &nbsp;
						<select name = "vehicle" onchange="changeVehicle('this','<%=param_volume_cal%>');"> <!-- param_volume_cal added for AAKH-CRF-0094-->
<%
							if(!order_catalog_code.equals("") && !catalog_desc.equals("")){
%>
								<option value='<%=order_catalog_code%>' selected><%=catalog_desc%></option>
<%
							}
							else{
%>
								<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
							}
%>
						</select><img id="mandatory"src="../../eCommon/images/mandatory.gif" ></img>
						<input type='hidden' name='vehicle_code' id='vehicle_code' value=''>
<%if(!order_catalog_code.equals("") && !catalog_desc.equals("")){%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); " src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(vehicle.value);" id="eldImg">
<%}else{%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden " src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(vehicle.value);" id="eldImg">
<%}%>
					</td>
					<td class="label">
					<A HREF title="Default Fluid has been altered" onMouseOver="changeCursor(this);" onClick="fluidRemarks();" style="<%=remarks_visibility%>" id='remarks'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>&nbsp;<img style="<%=remarks_visibility%>" id="mandatory1" src="../../eCommon/images/mandatory.gif" ></img></td>
					<td class="label">
						<fmt:message key="Common.volume.label" bundle="${common_labels}"/>
					<!-- Added for CRF AAKH-CRF-0094 START -->
						<%if(param_volume_cal.equals("N")){ %>
						<input type="text" name="volume" id="volume" value="<%=volume_unit%>" size="5" maxlength="5" style="text-align:right"  disabled>
						<%}
						else{
							 %>
						<input type="text" name="volume" id="volume" value="<%=volume_unit%>" size="5" maxlength="5" style="text-align:right" onblur="setFluidVolume(this); calInfuseOver();setSchedule(parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY.value);" onKeyPress="return allowValidNumber(this,event,3,0);">
						<%}
						 %>
						 <!-- Added for CRF AAKH-CRF-0094 END -->
						<input type="hidden" name="volume_reference" id="volume_reference" value="<%=volume_unit%>" > <!-- Added for AAKH-CRF-0094 -->
						<input type="hidden" name="volume_unit" id="volume_unit" value="<%=equvalent_uom_code%>" > <!-- replaced uom_desc with equvalent_uom_code for IN25615 --22/12/2010-- priya -->
						<label id="volume_unit_desc" width="10%"></label>
					</td>
				</tr>
				<tr height="4"><td colspan="12" ></td></tr>
				<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
				<tr><td width="100%" id="t"></td></tr>
				</table>
				</div>
			</table>
			<input type="hidden" name="ORDER_TYPE_CODE" id="ORDER_TYPE_CODE"	value="<%=orderType%>"	>
<%
			if( mode.equals("amend")){
%>
				<input type="hidden" name="amendmode" id="amendmode"	value="<%=mode%>"	>
<%
			}
%>
			<input type="hidden" name="fluid_remarks" id="fluid_remarks"	value="<%=fluid_remarks_flag%>"	>
			<input type="hidden" name="default_fluid_name" id="default_fluid_name"	value=""	>
			<input type="hidden" name="BASE_VOLUME" id="BASE_VOLUME" value="<%=base_volume%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		

<%
			ArrayList orderSetCodes = new ArrayList();
			if(iv_prep_default.equals("3") || iv_prep_default.equals("4")){
				
				orderSetCodes = (ArrayList) iv_bean.getOrdersetCodes(order_set_code);
				String strFluidCode = (String) orderSetCodes.get(0);
				String strDrugCode  = (String) orderSetCodes.get(1);
				iv_bean.setDrugDetails(strDrugCode,"","","","","","");  //CRF-0062 
%>
				<script>
					searchOrdersetPiggyBackforVehicle('D','<%=order_set_code%>','<%=patient_class%>','<%=strFluidCode%>','<%=bean_id%>','<%=bean_name%>','<%=patient_id%>','<%=encounter_id%>','<%=strDrugCode%>');
				</script>
<%
			}
%>
			<script>
<%
				if(order_type_flag.equals("Existing")|| mode.equals("amend")){
					if(!prev_order.equals("") && prev_order.equals("previous")){
%>
//					parent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle.all.volume_unit_desc.innerHTML ="<%=equvalent_uom_code%>";
					parent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle.volume_unit_desc.innerHTML ="<%=uom_desc%>";
					parent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle.mandatory.style.visibility="hidden";
<% 
				}
				else{ 
%>
					parent.parent.f_detail.f_iv_pb.formIVPiggyBackVehicle.volume_unit_desc.innerHTML ="<%=uom_desc%>";
					parent.parent.f_detail.f_iv_pb.formIVPiggyBackVehicle.mandatory.style.visibility="hidden";
<%
				}	
			}
%>				
		</script>

		
		<input type="hidden" name="order_set_code" id="order_set_code" value="<%= order_set_code %>">
	</form>
</html>
<script>

			parent.f_iv_pb_admin_dtls.location.href	="IVPiggyBackAdminDtls.jsp?"+'<%=request.getQueryString()%>';
</script>
<%

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(iv_bean_id,iv_bean,request);
%>


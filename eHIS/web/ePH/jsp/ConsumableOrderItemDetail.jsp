<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.Connection,webbeans.eCommon.ConnectionManager"%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
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
		//String locale			= (String)session.getAttribute("LOCALE");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	
		String bean_id = request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
		String bean_name = request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
		String call_mode = request.getParameter("call_mode")==null?"":request.getParameter("call_mode");
		String params	 = request.getQueryString(); // added for SCF-SRR20056-SCF-6572

		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String act_patient_class = request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");
		String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
		String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String resp_id = request.getParameter("resp_id")==null?"":request.getParameter("resp_id");
		String weight = request.getParameter("weight")==null?"":request.getParameter("weight");
		String weight_unit = request.getParameter("weight_unit")==null?"":request.getParameter("weight_unit");
		String height = request.getParameter("height")==null?"":request.getParameter("height");
		String height_unit = request.getParameter("height_unit")==null?"":request.getParameter("height_unit");
		String bsa = request.getParameter("bsa")==null?"":request.getParameter("bsa");
		String bsa_unit = request.getParameter("bsa_unit")==null?"":request.getParameter("bsa_unit");
		String bmi = request.getParameter("bmi")==null?"":request.getParameter("bmi");
		String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String bed_num = request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
		String room_num = request.getParameter("room_num")==null?"":request.getParameter("room_num");
		String order_date_time = request.getParameter("order_date_time")==null?"":request.getParameter("order_date_time");

		String priority = request.getParameter("priority")==null?"":request.getParameter("priority");
		String take_home_medication = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
		String bl_disp_charge_dtl_in_drug_lkp_yn = request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn");
		String bl_disp_price_type_in_drug_lkp = request.getParameter("bl_disp_price_type_in_drug_lkp")==null?"":request.getParameter("bl_disp_price_type_in_drug_lkp");
		
		String allow_pres_without_stock_yn = request.getParameter("allow_pres_without_stock_yn")==null?"":request.getParameter("allow_pres_without_stock_yn"); //
		String mode = "1";
		if(call_mode.equals("new") || call_mode.equals("modify")){
			mode = "1";
		}
		String item_code = "";
		String available_stock="0"; 	//<!--//Added By Himanshu for GHL-SCF-1738-->
		String item_desc = "";
		String trade_code = "";
		String trade_name = "";
		String qty_value = "";
		String qty_unit_code = "";
		String qty_unit_desc = "";

		String trade_option = "";
		String disp_locn_desc = "";
		String disp_locn_desc_disp = "";
		String performingFacilityId = "";
		String str_defaultIndex = "";
		String display_auth_rule	="visibility:hidden";
		String color_auth_rule	= "RED";
		String		ord_auth_reqd_yn			= 	"";
		String		ord_spl_appr_reqd_yn		= 	"";
		String		ord_cosign_reqd_yn			= 	"";
		String		ord_authorized_yn			= 	"";
		String		ord_approved_yn				= 	"";
		String		ord_cosigned_yn				= 	"";
		ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
		String allow_alt_check = ""; // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
		String allow_alt_check_val = "";
		String allow_alt_for_med_item = bean.getAllowAltForMedItem(); 
		Connection connection = null; 
		boolean item_type_yn  = false;
		try {
			  connection = ConnectionManager.getConnection(request);
			  item_type_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ITEM_TYPE_APP");
		}
		catch(Exception e) {
			  out.print("Exception @ Result JSP :"+e.toString());
			  e.printStackTrace();
		}
		finally{		
			if(connection != null)
			  ConnectionManager.returnConnection(connection,request);
		} // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
		if(call_mode.equals("new")){
			 allow_alt_check = ""; // Added for GHL-CRF-0548 [IN:068345] - Devindra
			if(bean.getItemTypeForSelectedDrug(item_code+"H").equals("Y") || bean.getItemTypeForSelectedDrug(item_code+"L").equals("Y")){
			  allow_alt_check = "checked"; 
			}
			allow_alt_check_val = "Y";  // Added for GHL-CRF-0548 [IN:068345] - Devindra
			bean.setLocationCode(location_code);
			bean.setLocationType(location_type);
			bean.setPatientId(patient_id);
			bean.setEncounterId(encounter_id);
			bean.setPatientClass(patient_class);
			bean.setActPatientClass(act_patient_class);
			bean.setCalledFrom(called_from);
			trade_option="<option value=''>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
		}
		if(call_mode.equals("modify")){
			
			str_defaultIndex = request.getParameter("defaultIndex")==null?"0":request.getParameter("defaultIndex");
			int defaultIndex = Integer.parseInt(str_defaultIndex);
			ArrayList presItemList=(ArrayList)bean.getPresItemList();
			if(presItemList!=null && presItemList.size()>0){
				HashMap itemDetail = (HashMap)presItemList.get(defaultIndex);
				item_code = (String)itemDetail.get("ITEM_CODE")==null?"":(String)itemDetail.get("ITEM_CODE");   
				item_desc = (String)itemDetail.get("ITEM_DESC")==null?"":(String)itemDetail.get("ITEM_DESC");   
				trade_code = (String)itemDetail.get("TRADE_CODE")==null?"":(String)itemDetail.get("TRADE_CODE");  
				trade_name = (String)itemDetail.get("TRADE_NAME")==null?"":(String)itemDetail.get("TRADE_NAME");
				qty_unit_code = (String)itemDetail.get("UOM_CODE")==null?"":(String)itemDetail.get("UOM_CODE");   
				qty_unit_desc = (String)itemDetail.get("UOM_DESC")==null?"":(String)itemDetail.get("UOM_DESC");
				qty_value = (String)itemDetail.get("QTY_VALUE")==null?"":(String)itemDetail.get("QTY_VALUE");
				disp_locn_desc = (String)itemDetail.get("STORE_DESC")==null?"":(String)itemDetail.get("STORE_DESC");
				available_stock=(String)itemDetail.get("available_stock")==null?"0":(String)itemDetail.get("available_stock"); 	//<!--//Added By Himanshu for GHL-SCF-1738-->
				allow_alt_check_val = (String)itemDetail.get("ALLOW_ALTERNATE_YN")==null?"Y":(String)itemDetail.get("ALLOW_ALTERNATE_YN"); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra				
				if(item_type_yn && allow_alt_check_val.equals("Y")){ 
					if(bean.getItemTypeForSelectedDrug(item_code+"I").equals("Y"))
					allow_alt_check = ""; 
				else
					allow_alt_check = "checked"; // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
				}	 
			if(disp_locn_desc!= null && !(disp_locn_desc.equals("")))
				disp_locn_desc_disp = disp_locn_desc.substring(0,disp_locn_desc.indexOf("|"));
				if(disp_locn_desc.indexOf("|") <= disp_locn_desc.length())
					performingFacilityId = disp_locn_desc.substring(disp_locn_desc.indexOf("|")+1);
				else
					performingFacilityId = "";

				ord_auth_reqd_yn			= (String) itemDetail.get("ORD_AUTH_REQD_YN");
				ord_spl_appr_reqd_yn		= (String) itemDetail.get("ORD_SPL_APPR_REQD_YN");
				ord_cosign_reqd_yn			= (String) itemDetail.get("ORD_COSIGN_REQD_YN");
				ord_authorized_yn			= (String) itemDetail.get("ORD_AUTHORIZED_YN");
				ord_approved_yn				= (String) itemDetail.get("ORD_APPROVED_YN");
				ord_cosigned_yn				= (String) itemDetail.get("ORD_COSIGNED_YN");


				ArrayList trades				=	bean.getTrades(item_code); 

				if(trades != null && trades.size()>0){
					for(int i=0; i<trades.size(); i+=2) { 
						if( ((String)trades.get(i)).equals(trade_code)) {  
							trade_option	= trade_option +"<option value='"+(String)trades.get(i)+"' selected>"+(String)trades.get(i+1)+"</option>";
							itemDetail.put("TRADE_NAME",(String)trades.get(i+1));
						} 
						else {	
							trade_option	= trade_option+ "<option value='"+(String)trades.get(i)+"'>"+(String)trades.get(i+1)+"</option>";
						}	
					}
				}
				else
					trade_option="<option value=''>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
			}
		}
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/ConsumableOrder.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frm_consumableItemDetail" id="frm_consumableItemDetail">
			<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='hdn_location_code' id='hdn_location_code' value='<%=location_code%>'>
			<input type='hidden' name='hdn_location_type' id='hdn_location_type' value='<%=location_type%>'>
			<input type='hidden' name='hdn_patient_id' id='hdn_patient_id' value='<%=patient_id%>'>
			<input type='hidden' name='hdn_patient_class' id='hdn_patient_class' value='<%=patient_class%>'>
			<input type='hidden' name='hdn_act_patient_class' id='hdn_act_patient_class' value='<%=act_patient_class%>'>
			<input type='hidden' name='hdn_encounter_id' id='hdn_encounter_id' value='<%=encounter_id%>'>
			<input type='hidden' name='hdn_pract_id' id='hdn_pract_id' value='<%=pract_id%>'>
			<input type='hidden' name='hdn_resp_id' id='hdn_resp_id' value='<%=resp_id%>'>
			<input type='hidden' name='hdn_weight' id='hdn_weight' value='<%=weight%>'>
			<input type='hidden' name='hdn_weight_unit' id='hdn_weight_unit' value='<%=weight_unit%>'>
			<input type='hidden' name='hdn_height' id='hdn_height' value='<%=height%>'>
			<input type='hidden' name='hdn_height_unit' id='hdn_height_unit' value='<%=height_unit%>'>
			<input type='hidden' name='hdn_bsa' id='hdn_bsa' value='<%=bsa%>'>
			<input type='hidden' name='hdn_bsa_unit' id='hdn_bsa_unit' value='<%=bsa_unit%>'>
			<input type='hidden' name='hdn_bmi' id='hdn_bmi' value='<%=bmi%>'>
			<input type='hidden' name='hdn_facility_id' id='hdn_facility_id' value='<%=facility_id%>'>
			<input type='hidden' name='hdn_bed_num' id='hdn_bed_num' value='<%=bed_num%>'>
			<input type='hidden' name='hdn_room_num' id='hdn_room_num' value='<%=room_num%>'>
			<input type='hidden' name='hdn_order_date_time' id='hdn_order_date_time' value='<%=order_date_time%>'>

			<input type='hidden' name='hdn_priority' id='hdn_priority' value='<%=priority%>'>
			<input type='hidden' name='hdn_take_home_medication' id='hdn_take_home_medication' value='<%=take_home_medication%>'>
			<input type='hidden' name='hdn_bl_install_yn' id='hdn_bl_install_yn' value='<%=bl_install_yn%>'>
			<input type='hidden' name='hdn_bl_disp_charge_dtl_in_rx_yn' id='hdn_bl_disp_charge_dtl_in_rx_yn' value='<%=bl_disp_charge_dtl_in_rx_yn%>'>
			<input type='hidden' name='hdn_bl_disp_charge_dtl_in_drug_lkp_yn' id='hdn_bl_disp_charge_dtl_in_drug_lkp_yn' value='<%=bl_disp_charge_dtl_in_drug_lkp_yn%>'>
			<input type='hidden' name='hdn_bl_disp_price_type_in_drug_lkp' id='hdn_bl_disp_price_type_in_drug_lkp' value='<%=bl_disp_price_type_in_drug_lkp%>'>
			<input type='hidden' name='hdn_order_type_code' id='hdn_order_type_code' value='MS'>
			<input type='hidden' name='hdn_call_mode' id='hdn_call_mode' value='<%=call_mode%>'>
			<input type='hidden' name='hdn_defaultIndex' id='hdn_defaultIndex' value='<%=str_defaultIndex%>'>
			<input type='hidden' name='hdn_called_from' id='hdn_called_from' value='<%=called_from%>'>
			<input type='hidden' name='performingFacilityId' id='performingFacilityId' value='<%=performingFacilityId%>'>
			<input type='hidden' name='hdn_allow_pres_without_stock_yn' id='hdn_allow_pres_without_stock_yn'  value='<%=allow_pres_without_stock_yn%>'><!--//Added By Himanshu for GHL-SCF-1738-->
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr> <td colspan='3'>&nbsp;</td>
				</tr>
				<tr>
					<td  width="15%" class='label'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td class="label"  width="50%"><input type='text' name='txt_item_desc' id='txt_item_desc' size='48' maxlength='180' value='<%=item_desc%>' onChange="itemSearch();"> <!-- onChang eadded for KDAH-SCF-0326 [IN:056879] -->
					<input type="button" name="btn_item_search" id="btn_item_search" value="?" class="button"  onClick="itemSearch();" ><img  src="../../eCommon/images/mandatory.gif"> <!-- onFocus=itemSearch(); removed for KDAH-SCF-0326 [IN:056879] -->
					<input type='hidden' name='hdn_item_code' id='hdn_item_code' value='<%=item_code%>'>
					<!--//Added By Himanshu for GHL-SCF-1738 starts-->
					<%
						String[] splitArray = available_stock.split(",");
						for (String s : splitArray) 
				        {
				        	available_stock=s;
				        }
					%>
					<input type='hidden' name='hdn_available_qty' id='hdn_available_qty' value='<%=available_stock%>'>
					<!--//Added By Himanshu for GHL-SCF-1738 ends-->
					
				 <%if(item_type_yn && allow_alt_for_med_item.equals("Y") && call_mode.equals("modify")){%> <!-- Added for GHL-CRF-0548 [IN:068345]  - Start - Devindra -->
					 &nbsp;<fmt:message key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>
					<input type="checkbox" name="allow_alt_chk" id="allow_alt_chk" value="<%=allow_alt_check_val%>" onclick='checkAllowAlternate(this)' <%=allow_alt_check%>>
				  <%} else{%>
					 <input type="hidden" name="allow_alt_chk" id="allow_alt_chk" value="">
					<%} %> <!-- Added for GHL-CRF-0548 [IN:068345]  - End - Devindra -->
					</td>
					<td class="label"  width="35%">&nbsp;
<%
						display_auth_rule = "visibility:hidden";
						if(ord_auth_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:red";
							if(ord_authorized_yn.equals("Y"))
								color_auth_rule = "color:green";
						}
%>
						<label id='lbl_authorize' name='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></label></font>
<%
						display_auth_rule = "visibility:hidden";
						color_auth_rule = "color:red";
						if(ord_spl_appr_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_approved_yn.equals("Y"))
								color_auth_rule = "color:green";
						}
%>
						<label id='lbl_apprvl' name='lbl_apprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label>
<%
						display_auth_rule = "visibility:hidden";
						color_auth_rule = "color:red";
						if(ord_cosign_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_cosigned_yn.equals("Y"))
								color_auth_rule = "color:green";
						}
%>
						<label id='lbl_cosign'  name='lbl_cosign' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></label>
					</td> 
				</tr>
				<tr>
					<td  width="15%" class='label'><fmt:message key="Common.Trade.label" bundle="${common_labels}"/></td>
					<td class="label"  width="50%"><select name='slt_trade_desc' id='slt_trade_desc'>
						<%=trade_option%>
					</select>
					</td>
					<td class="label"  width="35%">&nbsp;</td> 
				</tr>
				<tr>
					<td  width="15%" class='label'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class="label"  width="50%"><input type='text' class="NUMBER" name='txt_qty_value' id='txt_qty_value' size='5' maxlength='5' onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);ChkForZero(this);" value='<%=qty_value%>'><b><label  name='lbl_qty_unit_desc'id='lbl_qty_unit_desc'><%=qty_unit_desc%></label>&nbsp<img src="../../eCommon/images/mandatory.gif"></b>
					</td>
					<td class="label"  width="35%">&nbsp;</td> 
				</tr>
				<tr>
					<td  width="15%" class='label'><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td class="label"  width="50%" name='td_disp_locn_desc' id='td_disp_locn_desc'><%=disp_locn_desc_disp%>&nbsp;</td>
					<td align='right' width="35%"><input type='button' name='btn_clear' id='btn_clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick='conClearItem()' class='button'>&nbsp;
<%
					if(called_from.equals("TAB")|| called_from.equals("ORDERSET")){
%>
						<input type='button' name='btn_confirm' id='btn_confirm' value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' onclick='confirmItem()' class='button'>&nbsp;
<%
					}
					else{
%>
						<input type='button' name='btn_confirm' id='btn_confirm' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onclick='confirmItem()' class='button'>&nbsp;
<%
					}
%>
					</td> 
				</tr>
				<tr> <td colspan='3'>&nbsp;</td>
				</tr>
			</table>
		</form>
		<script>document.forms[0].txt_item_desc.focus();
				if(document.forms[0].txt_item_desc.value == null ||  document.forms[0].txt_item_desc.value =="")
			{
				parent.fram_cnItemList.location.href = "../../ePH/jsp/ConsumableOrderItemList.jsp?<%= params %>";
				parent.fram_cnButtons.location.href = "../../ePH/jsp/ConsumableOrderButtons.jsp?<%= params %>";
			}	
		</script>  <!-- //added on mar19-2010 -->

	</body>
</html> 
<%
	putObjectInBean(bean_id,bean,request);
%>


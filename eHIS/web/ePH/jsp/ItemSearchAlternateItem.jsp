<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.beans.Visibility"%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<% 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
07/01/2019		IN068344		    Devindra				 		                    Required indication of different item types during dispense/order 
29/05/2020	IN:072092	        Manickavasagam J			     GHL-CRF-0618                                                                                        according to patient billing group.
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<html>
	<head>	
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../ePH/js/ConsumableOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	try{		
		String	bl_disp_charge_dtl_in_drug_lkp_yn	=	request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn");
		String	bl_disp_price_type_in_drug_lkp		=	request.getParameter("bl_disp_price_type_in_drug_lkp")==null?"":request.getParameter("bl_disp_price_type_in_drug_lkp");
		String	bl_install_yn			=	request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String	item_code				=	request.getParameter("item_code")==null?"":request.getParameter("item_code");		
		String	priority				=	request.getParameter("priority")==null?"":request.getParameter("priority");
		String	take_home_medication	=	request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String 	store_name				=	request.getParameter("store_name")==null?"":request.getParameter("store_name"); 
		String 	disp_locn_code			=	request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");		
		String item_tech_code           =  	request.getParameter("item_tech_name")==null?"":request.getParameter("item_tech_name");
		String encounter_id             =   request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String	patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String bean_id		    = "@ConsumableOrderBean"+patient_id+encounter_id;
		String bean_name		= "ePH.ConsumableOrderBean";				
		ConsumableOrderBean bean=	(ConsumableOrderBean)getBeanObject( bean_id, bean_name, request ) ;
		
			
		
		String	drug_bean_id		=	"@DrugSearchBean";
		String	drug_bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean drug_bean		=	(DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ;
		String from				=	request.getParameter("hdn_from")==null?"":request.getParameter("hdn_from");
		String to				=	request.getParameter("hdn_to")==null?"":request.getParameter("hdn_to");	
		String	act_patient_class	=	request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");		
		String	consider_stock	=	"";
		String	allow_pres_without_stock_yn	=	"";
		ArrayList stock_params	=	drug_bean.validateForStock();
		String allow_alt_for_med_item = bean.getAllowAltForMedItem();
		String  billing_group  =bean.getBillingType(act_patient_class,encounter_id);
		Connection connection = null; 
		bean.setActPatientClass(act_patient_class);
		bean.setPatientId(patient_id);
		bean.setEncounterId(encounter_id);
	    boolean item_type_yn  = false;
	    //GHL-CRF-0618 - start
		boolean formulary_billing_app = false;
		String onClick = "";
		String onClick1 = "";
		//GHL-CRF-0618 - end
		try {
			  connection = ConnectionManager.getConnection(request);
			  item_type_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ITEM_TYPE_APP");
	  		  formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
		}
		catch(Exception e) {
			  out.print("Exception @ Result JSP :"+e.toString());
			  e.printStackTrace();
		}
		finally{		
			if(connection != null)
			  ConnectionManager.returnConnection(connection,request);
		} 
		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			allow_pres_without_stock_yn		= (String)stock_params.get(1);
		} 
		ArrayList arrList		=	null;
        try{		
			arrList	= (ArrayList)bean.searchForAltItems(from,to, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication,priority,item_code,item_tech_code,formulary_billing_app);

		}
		catch (Exception e){
			e.printStackTrace();
		}
		
%>
        <title><fmt:message key="ePH.AlternateDrugsfor.label" bundle="${ph_labels}"/> <%=item_code%></title>
		<body OnMouseDown='' onKeyDown = 'lockKey()'>
			<form name="frmAltItemSearchAlternateItemResult" id="frmAltItemSearchAlternateItemResult">	
		<div class="outer-container">
		<div class="top-section">		
<%
				
					String classvalue		= "";
					String disp_str			= "";
					item_code		= "";
					String item_desc = "";
					String trade_code		= "";
					String trade_name		= "";
					String stock_yn			= "";
					String item_tech_name   = "";
					String avl_qty			= "";
					String uom_code			= "";
					String uom_desc			= "";
					String store_code		= "";
					String store_desc		= "";
					String bl_reimburse_yn	="";
					String bl_imported_yn	= "";
					String bl_unit_price	= "";
					String bl_sys_message_id = "";
					String bl_error_code	="";
					String bl_error_text	="";
					String strEnableDisable	="";
					String alert_for_preferred_item_YN	="";
					String bl_preference_check_YN		="";
					String bl_preference_basis_ind		="";
					String bl_preference_item_code		="";
					String promptAlert_onclick_of_item	="";
					String preferred_item_text			="";
					String bl_preference_priority		="";
					String  low_cost_item               ="";
					String  innovator_item              ="";
					String  high_margin_item            =""; 
					String low_cost_item_visibility    ="";
					String innovator_item_visibility    ="";
					String high_margin_item_visibility    ="";
%>
					
					<table cellpadding='0' cellspacing='0' width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%								
%>
							</td>
						</tr>
					</table>										   
					<table border="1" width="100%" cellspacing="0" cellpadding="0">
						<tr>
						 <td width="25%" class='COLUMNHEADER'><fmt:message key="ePH.ItemTechname.label" bundle="${ph_labels}"/></td>
						 <%if(item_type_yn && bl_install_yn.equals("Y")){  %>						    						   
							<td width="10%" class='COLUMNHEADER'><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td> 
						<%}   %>						
							<td width="25%" class='COLUMNHEADER'><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></td>
<%
								if(formulary_billing_app){	//GHL-CRF-0618 
%>
									<td class="COLUMNHEADER" width="2%">&nbsp;</td>
<%								}
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
%>
								<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
								</td>
<%
							}                            
%>
							<td class="COLUMNHEADER" width="10%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>						
							</tr>
<%							                       
							//GHL-CRF-0618 - start
							String preference = "";  
							String preference_img = ""; 
							String formulary_code  = "";
							String blg_grp_type = "";
							boolean non_preference_flag = false;
							HashMap hmBlgGrp = null;
							ArrayList itemGenericType = null;
							if(formulary_billing_app){
								String blng_grp_id = bean.getBillingGrpId();//added for GHL-SCF-1527
								billing_group = "";
								non_preference_flag = false;
								formulary_code = bean.getFormularyCode();
								blg_grp_type = bean.getFormularyBlngGrpType();
								if(!formulary_code.equals("")){
								 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"M"); //blng_grp_id added for GHL-SCF-1527
 								 itemGenericType = bean.getItemGenericType();

								}
							}
						//GHL-CRF-0618  - end
                          if(arrList!=null && arrList.size()>0){ 
                              for (int i=0;i<arrList.size();i++){ 
                            	HashMap hmItemDetails= new HashMap();              					
                            	                ArrayList existingList = null;
                            	                existingList = bean.getPresItemList();                            	                            	
            					ArrayList existingCodes = new ArrayList();            					
            					hmItemDetails = (HashMap)arrList.get(i);
            					if(existingList!=null && existingList.size()>0){
            						for(int j=0; j<existingList.size(); j++){
            							hmItemDetails = (HashMap)existingList.get(j);            							
            							existingCodes.add(hmItemDetails.get("ITEM_CODE"));
            						}
            						hmItemDetails = null;
            					}
								strEnableDisable = "";
								hmItemDetails = (HashMap)arrList.get(i);
								item_code			= (String)hmItemDetails.get("ITEM_CODE")==null?"":(String)hmItemDetails.get("ITEM_CODE"); 								
			                        if(existingCodes.contains(item_code)){
						       strEnableDisable = "disabled";
						}
								item_desc			= (String)hmItemDetails.get("ITEM_DESC")==null?"":(String)hmItemDetails.get("ITEM_DESC");        
								trade_code			= (String)hmItemDetails.get("TRADE_CODE")==null?"":(String)hmItemDetails.get("TRADE_CODE");       
								trade_name			= (String)hmItemDetails.get("TRADE_NAME")==null?"":(String)hmItemDetails.get("TRADE_NAME");       
								stock_yn			= (String)hmItemDetails.get("STOCK_YN")==null?"":(String)hmItemDetails.get("STOCK_YN");          
								avl_qty				= (String)hmItemDetails.get("AVAIL_QTY")==null?"0":(String)hmItemDetails.get("AVAIL_QTY"); 
								uom_code			= (String)hmItemDetails.get("UOM_CODE")==null?"":(String)hmItemDetails.get("UOM_CODE"); 
								uom_desc			= (String)hmItemDetails.get("UOM_DESC")==null?"":(String)hmItemDetails.get("UOM_DESC"); 
								item_tech_name      = (String)hmItemDetails.get("TECH_NAME")==null?"":(String)hmItemDetails.get("TECH_NAME");
								/*=============================================================================================*/								
								if(disp_locn_code!=null && !(disp_locn_code.equals("")))
									store_code = disp_locn_code;
								else 
									store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");
								if(store_name!=null && !(store_name.equals("")))
									store_desc = store_name;
								else
									store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC"); 
																
								/*=============================================================================================*/
								           
								bl_reimburse_yn		= (String)hmItemDetails.get("BL_REIMBURSE_YN")==null?"":(String)hmItemDetails.get("BL_REIMBURSE_YN");     
								bl_imported_yn		= (String)hmItemDetails.get("BL_IMPORTED_YN")==null?"":(String)hmItemDetails.get("BL_IMPORTED_YN");    
								bl_unit_price		= (String)hmItemDetails.get("BL_UNIT_PRICE")==null?"":(String)hmItemDetails.get("BL_UNIT_PRICE");    
								bl_sys_message_id	= (String)hmItemDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)hmItemDetails.get("BL_SYS_MESSAGE_ID"); 
								bl_error_code		= (String)hmItemDetails.get("BL_ERROR_CODE")==null?"":(String)hmItemDetails.get("BL_ERROR_CODE");       
								bl_error_text		= (String)hmItemDetails.get("BL_ERROR_TEXT")==null?"":(String)hmItemDetails.get("BL_ERROR_TEXT");    
								alert_for_preferred_item_YN		= (String)hmItemDetails.get("PROMPT_ALERT_PREFERRED_DRUG")==null?"":(String)hmItemDetails.get("PROMPT_ALERT_PREFERRED_DRUG");    
								bl_preference_check_YN		= (String)hmItemDetails.get("BL_PREFERENCE_CHECK_YN")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_CHECK_YN");    
								bl_preference_basis_ind		= (String)hmItemDetails.get("BL_PREFERENCE_BASIS_IND")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_BASIS_IND");    
								bl_preference_item_code		= (String)hmItemDetails.get("BL_PREFERENCE_ITEM_CODE")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_ITEM_CODE");  
								bl_preference_priority	= (String)hmItemDetails.get("BL_PREFERENCE_PRIORITY")==null?"":(String)hmItemDetails.get("BL_PREFERENCE_PRIORITY");  
								low_cost_item  = (String)hmItemDetails.get("LOW_COST_ITEM")==null?"":(String)hmItemDetails.get("LOW_COST_ITEM");								
								high_margin_item = (String)hmItemDetails.get("HIGH_MARGIN_ITEM")==null?"":(String)hmItemDetails.get("HIGH_MARGIN_ITEM");
								innovator_item = (String)hmItemDetails.get("INNOVATOR_ITEM")==null?"":(String)hmItemDetails.get("INNOVATOR_ITEM");
								if(high_margin_item.equals("Y")){
								   bean.setItemTypeForSelectedDrug(item_code+"H"); 
								}
								if(low_cost_item.equals("Y")){
									   bean.setItemTypeForSelectedDrug(item_code+"L"); 
								}
								if(innovator_item.equals("Y")){ // Added for AMS-CRF-0204 - Start
									   bean.setItemTypeForSelectedDrug(item_code+"I"); 
								} // Added for AMS-CRF-0204 -End
								if(item_type_yn && bl_install_yn.equals("Y")){
									high_margin_item_visibility = "";
									low_cost_item_visibility = "";
									innovator_item_visibility = "";
									
								   if(low_cost_item.equals("Y")){
									low_cost_item_visibility = "visible";
								   }
								   if(high_margin_item.equals("Y")){
									   high_margin_item_visibility = "visible";
								   }
								   if(innovator_item.equals("Y")){
									   innovator_item_visibility="visible";
								   }
								   								  
								}
																
								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										strEnableDisable = "disabled";
									}
								}								
								double avl_qty_1=Double.parseDouble(avl_qty);
								String allow_without_stock = "";

                                if( consider_stock.equals("Y") ) {
				                   if(avl_qty_1<=0)
					                  avl_qty_1	= 0.0;
				                   if( allow_pres_without_stock_yn.equals("N") && avl_qty_1<=0)
					                    allow_without_stock="disabled";
				              else
					                    allow_without_stock="enabled";
			                   }
			                  else {
				                 allow_without_stock="enabled";
			                  }
								

%>
								<td class="<%=classvalue%>" width='10%' align="right">
								<label class="label" style="font-size:xx-small;color:black;font-weight:normal"><%=item_tech_name%></label>
								<%
							if(item_type_yn && bl_install_yn.equals("Y")){
%>
								<td class='<%=classvalue%>' width='1%' align="right">
							    <% if(low_cost_item_visibility.equalsIgnoreCase("visible")){ 
							           if(billing_group.equals("L")){%>
								          <img src='../../ePH/images/LowCostGreen.jpg' height='15' width='15' style='visibility:<%=low_cost_item_visibility%>'  title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'>&nbsp;
								      <%} 
							           else if(billing_group.equals("H")){%>
								          <img src='../../ePH/images/LowCostRed.jpg'  height='15' width='15' style='visibility:<%=low_cost_item_visibility%>' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'>&nbsp;
								     <%} else{%>						
								          <img src='../../ePH/images/LowCost.jpg' title="Low Cost Item"  height='15' width='15' style='visibility:<%=low_cost_item_visibility%>'>&nbsp;
								       <%} %>														
								<%  }
							       else{ %>
								          <img src='../../ePH/images/LowCost.jpg' title="Low Cost Item"  height='15' width='15' style='visibility:hidden'>&nbsp;								   
								   
								   <%} 
							    if(high_margin_item_visibility.equalsIgnoreCase("visible")){ 
							             if(billing_group.equals("H")){%>
								           <img src='../../ePH/images/HighMarginGreen.jpg'  height='15' width='15' style='visibility:<%=high_margin_item_visibility%>' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'>&nbsp;
								        <%} 
							            else if(billing_group.equals("L")){%>
								           <img src='../../ePH/images/HighMarginRed.jpg'  height='15' width='15' style='visibility:<%=high_margin_item_visibility%>' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'>&nbsp;
								      <%} else{%>						
								          <img src='../../ePH/images/HighMargin.jpg' title="High Margin Item" height='15' width='15' style='visibility:<%=high_margin_item_visibility%>'>&nbsp;
								       <%} %>														
								<%  }
							       else{ %>
								          <img src='../../ePH/images/HighMargin.jpg'  height='15' width='15' style='visibility:hidden'>&nbsp;								   								   
								 <%} 
							    if(innovator_item_visibility.equalsIgnoreCase("visible")){ %> 
										  <img src='../../ePH/images/Innovator.jpg' title="Innovator Item"  height='15' width='15' style='visibility:<%=innovator_item_visibility%>'>&nbsp;
				                 <%}
							    else{ %>
				               			  <img src='../../ePH/images/Innovator.jpg' title="Innovator Item" height='15' width='15' style='visibility:hidden'>&nbsp;													
							     <%}%>
								</td>
<%
                            } 
%>							
<% 								if(formulary_billing_app){//GHL-CRF-0618 - start
									preference_img = "";
									preference = "";
									//System.err.println("drug_code=========>"+item_code+"==hmBlgGrp===>"+hmBlgGrp);
										if(hmBlgGrp!=null && hmBlgGrp.size()>0){
											if(itemGenericType!=null && itemGenericType.size()>0){
												if(itemGenericType.contains("M"))
													non_preference_flag = true;
										  }

										if(hmBlgGrp.containsKey(item_code)){
											non_preference_flag = true;
											preference = (String)hmBlgGrp.get(item_code)==null?"":(String)hmBlgGrp.get(item_code);
											
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item'/>";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item'/>";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item'/>";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item'/>";
											}
										}/*else{
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' 	width='15' title='Non Prefered Item'/>";
										} */

									}/*else{
										preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item'/>";
									} */
								} //GHL-CRF-0618 - end
			
								if (!(strEnableDisable.equals(""))){
										preferred_item_text="";
									}								
								if(strEnableDisable.equals("")){
										strEnableDisable	=	allow_without_stock;
									
								}
								if(item_type_yn){ //GHL-CRF-0618 - start
									onClick1 =  "selectAltItem('"+i+"','"+promptAlert_onclick_of_item+"')";
										if(formulary_billing_app){
											if(non_preference_flag){
											if(blg_grp_type.equals("C")){
												if(preference.equals("") || !preference.equals("P1")){
													//onClick1 = "if(formularyNonPreference('"+item_code+"')){"+onClick1+"}";
													onClick1 = "if(formularyNonPreference('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"')){"+onClick1+"}";
												}
											}else{
												if(preference.equals("") || !preference.equals("P1")){
												strEnableDisable = "disabled";
												onClick1		=	"";
												}
											}
											}
										}
								} //GHL-CRF-0618 - end

								if (strEnableDisable != null){
									if(!strEnableDisable.equals("disabled")){
										
									if(item_type_yn){
%>
									<td id="item<%=i%>" class="<%=classvalue%>" title="<%=store_desc%>" onclick="<%=onClick1%>"> <!-- modified for GHL-CRF-0618-->
										<font class='HYPERLINK' onmouseover="changeCursor(this);" ><%=item_desc%></font>
										<%}else{ %>
										<td id="item<%=i%>" class="<%=classvalue%>">
										<font class="<%=classvalue%>"><%=item_desc%></font>										
										
<%                                      }
								}
								else{
									if(item_type_yn){
%>
									<td id="item<%=i%>" class="<%=classvalue%>" title="<%=store_desc%>" onclick="disableClick(event);">
										<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);"><%= item_desc %>
										</label>
										<%} else{ %>
										<td id="item<%=i%>" class="<%=classvalue%>">
										<label class="label" style="font-size:xx-small;color:black;font-weight:normal"><%= item_desc %>
										</label>
										
<%   }
									}
								}
%>
									<input type="hidden" name="hdn_item_code<%=i%>" id="hdn_item_code<%=i%>" value="<%=item_code%>">
									<input type="hidden" name="hdn_line_no<%=i%>" id="hdn_line_no<%=i%>" value="<%=i%>">
									<input type="hidden" name="hdn_trade_code<%=i%>" id="hdn_trade_code<%=i%>" id="trade_code<%=i%>" value="<%=trade_code%>">
									<input type="hidden" name="hdn_trade_name<%=i%>" id="hdn_trade_name<%=i%>" id="hdn_trade_name<%=i%>" value="<%=trade_name%>">								
<%
									if(!trade_name.equals("")){
%>
										<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=trade_name%>)</label>
<%
									}
%>                                </td>     
<%								//GHL-CRF-0618 - start
									if(formulary_billing_app){
%>								
									<td class="<%=classvalue%>">	<%=preference_img%>&nbsp;</td>
<%								} //GHL-CRF-0618 - end
%>
<!-- ============================================================================================================= -->
<%			


								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									
									if(!bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = (String)hmItemDetails.get("BL_UNIT_PRICE") ;
									}
									else{
										disp_str = "&nbsp";

										if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
											disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
										}
									}
%>
									<td class="<%=classvalue%>" align="center" title='' id='BL_ERROR<%=i%>'> <%=disp_str%>
									</td>
<%
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										out.println("<script>dispTitle('"+bl_error_code+"','"+bl_error_text+"','"+bl_sys_message_id+"','"+i+"');</script>");
									}
								}                           
%>
								<td class="<%=classvalue%>" align="right"><label><%=avl_qty%>&nbsp;</label></font></td>
							</tr>
<%
						}
%>
					</table>
					
<%														
	}				
				bean.setDispPriceTypeinDrugLKPYN(bl_disp_price_type_in_drug_lkp);
				bean.setDispChargeDtlInDrugLKPYN(bl_disp_charge_dtl_in_drug_lkp_yn);
				bean.setBillInstallYN(bl_install_yn);			
				bean.setTakeHomeMedication(take_home_medication);
%>
				<input type="hidden" name="hdn_from" id="hdn_from" value="">
				<input type="hidden" name="hdn_to" id="hdn_to" value="">
				<input type="hidden" name="hdn_bean_id" id="hdn_bean_id" value="<%=bean_id%>">
				<input type="hidden" name="hdn_bean_name" id="hdn_bean_name" value="<%=bean_name%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="bl_disp_charge_dtl_in_drug_lkp_yn" id="bl_disp_charge_dtl_in_drug_lkp_yn" value="<%=bl_disp_charge_dtl_in_drug_lkp_yn%>">
				<input type="hidden" name="bl_disp_price_type_in_drug_lkp" id="bl_disp_price_type_in_drug_lkp" value="<%=bl_disp_price_type_in_drug_lkp%>">
				<input type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication%>">
				<input type="hidden" name="priority" id="priority" value="<%=priority%>">
				<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">			
				<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
				<input type="hidden" name="store_name" id="store_name" value="<%=store_name%>">
         </div>
          <%if(item_type_yn ){ %>
            <div class="top-section" style='width:810px;height:20px;'>
              <table border="1" width="100%" cellpadding="1" cellspacing="1" align="center">
				<%if(!formulary_billing_app){%>
				<td align="right" class="white"><img src='../../ePH/images/LowCost.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.LowCostItem.label" bundle="${ph_labels}"/></td>
				<td align="right" class="white"><img src='../../ePH/images/HighMargin.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.HighMarginItem.label" bundle="${ph_labels}"/> </td>
				<td align="right" class="white"><img src='../../ePH/images/Innovator.jpg'  height='15' width='15' ></td>
				<td class="white" align="left"><fmt:message key="ePH.Innovator.label" bundle="${ph_labels}"/> </td>
				<%
				}else{ %>
			<td class='white' ></td>	
			 <td class="white" align="left">
					<img src="../../ePH/images/Preference1.jpg"  height='15' width='15' >
				</td>
				<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem1.label" bundle="${ph_labels}"/>&nbsp;</td>
								
				<td class="white" align="left">
					<img src="../../ePH/images/Preference2.jpg"  height='15' width='15' >
				</td>
				<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem2.label" bundle="${ph_labels}"/>&nbsp;</td>
				
				<td class="white" align="left">
					<img src="../../ePH/images/Preference3.jpg"  height='15' width='15' >
				</td>
				<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.PreferedItem3.label" bundle="${ph_labels}"/>&nbsp;</td>
				
				<td class="white" align="left">
					<img src="../../ePH/images/Preference4.jpg"  height='15' width='15' >
				</td>
				<td class="white" align="left" nowrap>&nbsp;<fmt:message key="ePH.NonPreferedItem.label" bundle="${ph_labels}"/>&nbsp;</td>
	
				
				
				<%}
				%>
			 </table>         
         </div>
         <%} %>
         </div>
         
			</form>
		</body>
<%
	putObjectInBean(bean_id,bean,request); 
}
catch(Exception e){
	e.printStackTrace();
}
%>
</html>


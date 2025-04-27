<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.beans.Visibility"%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
05/10/2017	  	IN064474	     	Devindra 											GHL-CRF-0467 [IN064474] 
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
14/01/2019		IN068344		    Devindra				 		                    Required indication of different item types during dispense/order 
                                                                                        according to patient billing group.
28/05/2020      	IN072995            Haribabu                                            PMG2020-NMC-JD-CRF-0001                                                                                         
22/07/2020		IN:072092	    Manickavasagam J			     GHL-CRF-0618
10/08/2020		IN:73512	        Manickavasagam J			     GHL-CRF-0618
17/08/2020      IN073688         Prabha       17/08/2020        Manickavasagam J        Medical Item Screen
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
03/12/2020		TFS:8983	        Manickavasagam J			     GHL-SCF-1533
14/07/2021		TFS:21249	        Manickavasagam J			     NMC-JD-SCF-0217
03/10/2023	  	50818  			    Himanshu 						GHL-SCF-1738 					GHL-SCF-1738 

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
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
		String	bean_id				=	request.getParameter("bean_id");
		String	bean_name			=	request.getParameter("bean_name");
		String	bl_disp_charge_dtl_in_drug_lkp_yn	=	request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_drug_lkp_yn");
		String	bl_disp_price_type_in_drug_lkp		=	request.getParameter("bl_disp_price_type_in_drug_lkp")==null?"":request.getParameter("bl_disp_price_type_in_drug_lkp");
		String	bl_install_yn			=	request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String	item_desc				=	request.getParameter("item_desc")==null?"":request.getParameter("item_desc");
		String	order_type_code			=	request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		String	priority				=	request.getParameter("priority")==null?"":request.getParameter("priority");
		String	take_home_medication	=	request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
		String 	store_name				=	request.getParameter("store_name")==null?"":request.getParameter("store_name"); //added on 08/04/2010 for IN20551-- priya
		String 	disp_locn_code			=	request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code"); //added on 08/04/2010 for IN20551-- priya
		item_desc				= item_desc+"%";

		ConsumableOrderBean bean=	(ConsumableOrderBean)getBeanObject( bean_id, bean_name, request ) ;

		String patient_id 	=""; // Added for GHL-CRF-0467 - Start
		String encounter_id ="";
		patient_id		= bean.getPatientId(); ;
		encounter_id	= bean.getEncounterId() ;
		String	drug_bean_id		=	"@DrugSearchBean"+patient_id+encounter_id;
		String	drug_bean_name		=	"ePH.DrugSearchBean";
		DrugSearchBean drug_bean		=	(DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ; // Added for GHL-CRF-0467 - End
		//String facility_id		=   (String) session.getValue("facility_id");
		String from				=	request.getParameter("hdn_from")==null?"":request.getParameter("hdn_from");
		String to				=	request.getParameter("hdn_to")==null?"":request.getParameter("hdn_to");
		String radioval			=	request.getParameter( "radioval" )==null?"IC":request.getParameter( "radioval" );
		String	search_string	=	request.getParameter("search_string")==null?"":request.getParameter("search_string");
		String	search_criteria	=	request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria");
		String	consignment		=	request.getParameter("consignment")==null?"":request.getParameter("consignment");
		String	Manufacturer	=	request.getParameter("Manufacturer")==null?"":request.getParameter("Manufacturer");
		String	p_Item_class	=	request.getParameter("p_Item_class")==null?"":request.getParameter("p_Item_class");
		String	Item_analysis1	=	request.getParameter("Item_analysis1")==null?"":request.getParameter("Item_analysis1");
		String	Item_analysis2	=	request.getParameter("Item_analysis2")==null?"":request.getParameter("Item_analysis2");
		String	Item_analysis3	=	request.getParameter("Item_analysis3")==null?"":request.getParameter("Item_analysis3");
		String	CALL_FROM	=	request.getParameter("CALL_FROM")==null?"":request.getParameter("CALL_FROM");
		String	patient_class	=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//patient_class  Added for GHL-CRF-0467 - Start
		String	consider_stock	=	"";
		String	allow_pres_without_stock_yn	=	"";
		ArrayList stock_params	=	drug_bean.validateForStock();
		String allow_alt_for_med_item = bean.getAllowAltForMedItem(); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
		bean.setAltItemClicked("");
		String act_patient_class = bean.getActPatientClass(); 			
		String  billing_group_type  =bean.getBillingType(act_patient_class,encounter_id);	
		Connection connection = null; 
	    boolean item_type_yn  = false;
	    boolean  alt_need_to_open = false; // Added for GHL-SCF-0549 
		boolean formulary_billing_app = false; //GHL-CRF-0618


		try {
			  connection = ConnectionManager.getConnection(request);
			  if(!"DISP".equals(CALL_FROM))
			  item_type_yn =eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","ITEM_TYPE_APP");
			  boolean ext_disp_appl = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","EXT_DISP_APPL");//Added for IN072995
			  bean.setExtDispAppl(ext_disp_appl);//Added for IN072995
 		  	 formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","FORMULARY_BLG_GRP_APP");//GHL-CRF-0618
		}
		catch(Exception e) {
			  out.print("Exception @ Result JSP :"+e.toString());
			  e.printStackTrace();
		}
		finally{		
			if(connection != null)
			  ConnectionManager.returnConnection(connection,request);
		} // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
		if(stock_params.size() > 1) {
			consider_stock					= (String)stock_params.get(0);
			allow_pres_without_stock_yn		= (String)stock_params.get(1);
		} // Added for GHL-CRF-0467 - End
		ArrayList arrList		=	null;
        try{
		//arrList	= (ArrayList)bean.getItemDetailsList(item_desc,from,to, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication, priority);
			arrList	= (ArrayList)bean.getItemDetailsList(item_desc,from,to, bl_install_yn, bl_disp_charge_dtl_in_drug_lkp_yn, bl_disp_price_type_in_drug_lkp,take_home_medication,priority,search_string,search_criteria,consignment,Manufacturer,p_Item_class,Item_analysis1,Item_analysis2,Item_analysis3,radioval);

		}
		catch (Exception e){
			e.printStackTrace();
		}
		
%>
		<body OnMouseDown='' onKeyDown = 'lockKey()'>
			<form name="frmItemNameCommonLookupResult" id="frmItemNameCommonLookupResult">
<%
				if(arrList!=null && arrList.size()>1){
					HashMap hmItemDetails= new HashMap();
					ArrayList existingList = null;
					if("DISP".equals(CALL_FROM)){
						String	disp_bean_id			   =	"DispMedicationAllStages" ;
						String	disp_bean_name			   =	"ePH.DispMedicationAllStages";
						DispMedicationAllStages disp_bean  = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name, request);
						existingList  = (ArrayList)disp_bean.getConsumableDetails();
					}
					else
						existingList = bean.getPresItemList();
					ArrayList existingCodes = new ArrayList();
					if(existingList!=null && existingList.size()>0){
						for(int i=0; i<existingList.size(); i++){
							hmItemDetails = (HashMap)existingList.get(i);
							if("DISP".equals(CALL_FROM))
								existingCodes.add(hmItemDetails.get("ORDER_CATALOG_CODE"));
							else
								existingCodes.add(hmItemDetails.get("ITEM_CODE"));
						}
						hmItemDetails = null;
					}

					String classvalue		= "";
					String disp_str			= "";
					String item_code		= "";
					String trade_code		= "";
					String trade_name		= "";
					String stock_yn			= "";
					String avl_qty			= "";
					String ext_disp_appl_yn = "";//Added for IN072995
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
					String  low_cost_item               ="";                     // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
					String  innovator_item              ="";
					String  high_margin_item            =""; 
					String low_cost_item_visibility     ="";
					String innovator_item_visibility    ="";
					String high_margin_item_visibility  ="";
					String item_tech_code               = "";                   // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
					//GHL-CRF-0618 - start
					String onClick						= ""; //GHL-CRF-0618
					String onClick1						= ""; 

					boolean disp_non_preference_rem_window =false; 
					boolean non_preference_flag		= false;
					//GHL-CRF-0618 - end
%>
					<table cellpadding='0' cellspacing='0' width="100%" align="center">
						<tr>
							<td width="80%" class="white">&nbsp;</td>
							<td width="20%" class="white">&nbsp;
<%
								// For display the previous/next link
								out.println(arrList.get(0));
%>
							</td>
						</tr>
					</table>
					<table border="1" width="100%" cellspacing="0" cellpadding="0">
						<tr>
							<td width="1%" class='COLUMNHEADER'>&nbsp;</td>
						 <%if(item_type_yn && bl_install_yn.equals("Y")){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra %>
							<td width="6%" class='COLUMNHEADER'><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td> 
						<%
							if(formulary_billing_app){	
						%>
						<td  class="COLUMNHEADER" width="2%"  style="font-size:9" >&nbsp;</td><!-- added for GHL-CRF-0618 -->
						<%} 
						} // Added for GHL-CRF-0548 [IN:068345] - End - Devindra %>						
							<td width="50%" class='COLUMNHEADER'><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></td>
							 <td width="4%" class='COLUMNHEADER'>&nbsp;</td>
							 <td width="4%" class='COLUMNHEADER'>&nbsp;</td>
<%  
							if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
%>
								<td class="COLUMNHEADER" width="5%"><fmt:message key="ePH.Pay.label" bundle="${ph_labels}"/>
								</td>
								<td class="COLUMNHEADER" width="5%"><fmt:message key="Common.Reimburse.label" bundle="${common_labels}"/>
								</td>
								<td class="COLUMNHEADER" width="5%"><fmt:message key="ePH.National.label" bundle="${ph_labels}"/>
								</td>
								<td class="COLUMNHEADER" width="10%"><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
								</td>
<%
							}
                            if(allow_alt_for_med_item.equals("Y")){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
%>                                                   
                            <td class="COLUMNHEADER" width="5%">&nbsp;</td>
<%
                            } // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
%>
							<td class="COLUMNHEADER" width="10%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/></td>
							<td class="COLUMNHEADER" width="10%"><fmt:message key="ePH.Quantity/Uom.label" bundle="${ph_labels}"/></td>
							<td class="COLUMNHEADER" width="4%"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></td>
							</tr>
<%							
							//GHL-CRF-0618 - start
							String preference = "";  
							String preference_img = ""; 
							String formulary_value = "";
							String formulary_code  = "";
							String blg_grp_type = "";
							HashMap hmBlgGrp = null;
							boolean alternate_flag = false;
							boolean err_flag = false;
							ArrayList itemGenericType = null;
							if(formulary_billing_app){
								String blng_grp_id = bean.getBillingGrpId();

								//formulary_value = bean.getFormularyBillingGrpCode("CBSN");
								formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
								formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
								blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
								if(!formulary_code.equals(""))
								 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"M"); //blng_grp_id added for GHL-SCF-1527
								 itemGenericType = bean.getItemGenericType();
							}
						//GHL-CRF-0618  - end
								

                                 HashMap ht=(HashMap)bean.getSelectedItems();
System.out.println("ht"+ht);
                               
                                 for (int i=1;i<arrList.size();i++){
                                	 if (ht.size()>0){
                                	%>	 <script>enableDisableSelectButton('false')</script>
                         		<%	}
                         			else{
                         				 %>
                         				<script>enableDisableSelectButton('true')</script>
                         		<%}
								strEnableDisable = "";
								err_flag = false;
								hmItemDetails = (HashMap)arrList.get(i);
								item_code			= (String)hmItemDetails.get("ITEM_CODE")==null?"":(String)hmItemDetails.get("ITEM_CODE"); 
								//added for the duplication check
								if(existingCodes.contains(item_code)){
									strEnableDisable = "disabled";
								}
								//end of duplication
								item_desc			= (String)hmItemDetails.get("ITEM_DESC")==null?"":(String)hmItemDetails.get("ITEM_DESC");        
								trade_code			= (String)hmItemDetails.get("TRADE_CODE")==null?"":(String)hmItemDetails.get("TRADE_CODE");       
								trade_name			= (String)hmItemDetails.get("TRADE_NAME")==null?"":(String)hmItemDetails.get("TRADE_NAME");       
								stock_yn			= (String)hmItemDetails.get("STOCK_YN")==null?"":(String)hmItemDetails.get("STOCK_YN");          
								avl_qty				= (String)hmItemDetails.get("AVAIL_QTY")==null?"0":(String)hmItemDetails.get("AVAIL_QTY");
								ext_disp_appl_yn				= (String)hmItemDetails.get("EXT_DISP_APPL_YN")==null?"N":(String)hmItemDetails.get("EXT_DISP_APPL_YN"); //Added for IN072995
								uom_code			= (String)hmItemDetails.get("UOM_CODE")==null?"":(String)hmItemDetails.get("UOM_CODE"); 
								uom_desc			= (String)hmItemDetails.get("UOM_DESC")==null?"":(String)hmItemDetails.get("UOM_DESC"); 
								/*=============================================================================================*/
								//added on 08/04/2010 for IN20551-- priya
								// Here we are taking dispense location from dispense medication screen if it exists otherwise from PH_DISP_STOCK_LOCN function
								//store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");
								if(disp_locn_code!=null && !(disp_locn_code.equals("")))
									store_code = disp_locn_code;
								else 
									store_code			= (String)hmItemDetails.get("STORE_CODE")==null?"":(String)hmItemDetails.get("STORE_CODE");
								if(store_name!=null && !(store_name.equals("")))
									store_desc = store_name;
								else
									store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC"); 
								
								//store_desc			= (String)hmItemDetails.get("STORE_DESC")==null?"":(String)hmItemDetails.get("STORE_DESC");
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
								low_cost_item  = (String)hmItemDetails.get("LOW_COST_ITEM")==null?"":(String)hmItemDetails.get("LOW_COST_ITEM"); // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra								
								high_margin_item = (String)hmItemDetails.get("HIGH_MARGIN_ITEM")==null?"":(String)hmItemDetails.get("HIGH_MARGIN_ITEM");
								innovator_item = (String)hmItemDetails.get("INNOVATOR_ITEM")==null?"":(String)hmItemDetails.get("INNOVATOR_ITEM");
								item_tech_code = (String)hmItemDetails.get("ITEM_TECH_CODE")==null?"":(String)hmItemDetails.get("ITEM_TECH_CODE");
								alt_need_to_open = true; // Added for GHL-CRF-0549
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
								
								// Added for GHL-CRF-0548 [IN:068345] - End - Devindra
								if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
										strEnableDisable = "disabled";
										err_flag = true;
									}
								}
								//GHL-CRF-0467 starts
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
							 //added for NMC-JD-SCF-0217 
							  if(avl_qty_1>0)
								stock_yn = "Y";
							  else
							    stock_yn = "N";
								
								
								//GHL-CRF-0467 ends

								//if((consider_stock.equals("Y")) &&(hmItemDetails.get("STOCK_YN").equals("") || hmItemDetails.get("STOCK_YN").equals("N"))){ //consider_stock added for GHL-CRF-0467 and commented for NMC-JD-SCF-0217
									//out.println("88888888" +hmItemDetails.get("STORE_DESC"));
									if(consider_stock.equals("Y") && (stock_yn.equals("") || stock_yn.equals("N"))){  //added for NMC-JD-SCF-0217
%>
									<tr>
										<td class='INSUFFICIENTSTOCK' width='1%' title="<%=store_desc%>">&nbsp;</td>	
<%   
								}
								else { 
%>
									<tr>
										<td class='<%=classvalue%>' width='1%'></td>
<%
								}
							alternate_flag = bean.altItemsAvailableYn(item_code, item_tech_code);//moved from down to up for GHL-CRF-0618
							if(item_type_yn && bl_install_yn.equals("Y")){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra
								if(formulary_billing_app){//GHL-CRF-0618 - start
									billing_group_type = "";
									preference_img = "";
									disp_non_preference_rem_window = false;
									non_preference_flag = false;
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(itemGenericType!=null && itemGenericType.size()>0){
											if(itemGenericType.contains("M"))
												non_preference_flag = true;
									  }
										if(hmBlgGrp.containsKey(item_code)){
											non_preference_flag = true;
											preference = (String)hmBlgGrp.get(item_code)==null?"":(String)hmBlgGrp.get(item_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' height='15' width='15' title='Prefered-1 Item' />";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg' height='15' width='15' title='Prefered-2 Item' />";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' height='15' width='15' title='Prefered-3 Item' />";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item'/>";
											}
										}else{
										if(non_preference_flag)
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
										} 

									}/*else{
											preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
									} */
									if(blg_grp_type.equals("C")) {
									if(!preference.equals("")  && preference.equals("P1")){
											disp_non_preference_rem_window = false;
										}else{
										if((preference.equals("") && non_preference_flag ) || preference.equals("P2") || 	preference.equals("P3")){
											disp_non_preference_rem_window = true;
										}
									 }
									}else if(blg_grp_type.equals("R")){
										if(!preference.equals("P1") || (preference.equals("") && non_preference_flag)){
											disp_non_preference_rem_window = true;
											if(!alternate_flag)
											strEnableDisable = "disabled";
										}else{
											disp_non_preference_rem_window = false;
										}
									}

									if(blg_grp_type.equals("R") && !non_preference_flag){ //added for GHL-SCF-1533
										disp_non_preference_rem_window = false;
										if(!err_flag)
										strEnableDisable = "";
									} 

								//System.err.println("==blg_grp_type===>"+blg_grp_type+"==disp_non_preference_rem_window===>"+disp_non_preference_rem_window+"==preference==>"+preference);

								}//GHL-CRF-0618 - end
%>
								<td class='<%=classvalue%>' width='1%' align="right">
							    <% if(low_cost_item_visibility.equalsIgnoreCase("visible")){ 
							           if(billing_group_type.equals("L")){
							        	   alt_need_to_open = false;
							           %>
								          <img src='../../ePH/images/LowCostGreen.jpg' height='15' width='15' style='visibility:<%=low_cost_item_visibility%>' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'>&nbsp;
								      <%} 
							           else if(billing_group_type.equals("H")){							        	   
							           %>
								          <img src='../../ePH/images/LowCostRed.jpg'  height='15' width='15' style='visibility:<%=low_cost_item_visibility%>' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'>&nbsp;
								     <%} else{								    	 
								     %>						
								          <img src='../../ePH/images/LowCost.jpg'  title="Low Cost Item" height='15' width='15' style='visibility:<%=low_cost_item_visibility%>'>&nbsp;
								       <%} %>														
								<%  }
							       else{ %>
								          <img src='../../ePH/images/LowCost.jpg'  title="Low Cost Item" height='15' width='15' style='visibility:hidden'>&nbsp;								   
								   <%} if(high_margin_item_visibility.equalsIgnoreCase("visible")){ 
							             if(billing_group_type.equals("H")){
							             alt_need_to_open = false;
							             %>
								           <img src='../../ePH/images/HighMarginGreen.jpg'  height='15' width='15' style='visibility:<%=high_margin_item_visibility%>' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'>&nbsp;
								        <%} 
							            else if(billing_group_type.equals("L")){%>
								           <img src='../../ePH/images/HighMarginRed.jpg'  height='15' width='15' style='visibility:<%=high_margin_item_visibility%>'title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'>&nbsp;
								      <%} else{%>						
								          <img src='../../ePH/images/HighMargin.jpg' title="High Margin Item"  height='15' width='15' style='visibility:<%=high_margin_item_visibility%>'>&nbsp;
								       <%} %>														
								<%  }
							       else{ %>
								          <img src='../../ePH/images/HighMargin.jpg' title="High Margin Item"  height='15' width='15' style='visibility:hidden'>&nbsp;								   								   
								 <%} if(innovator_item_visibility.equalsIgnoreCase("visible")){ %> 
										  <img src='../../ePH/images/Innovator.jpg'  title="Innovator Item" height='15' width='15' style='visibility:<%=innovator_item_visibility%>'>&nbsp;
				                 <%}else{ %>
				               			  <img src='../../ePH/images/Innovator.jpg'  title="Innovator Item" height='15' width='15' style='visibility:hidden'>&nbsp;													
							     <%}%>
								</td>	
								<%if(formulary_billing_app){//GHL-CRF-0618 - start
%>								
									<td class="<%=classvalue%>">	<%=preference_img%>&nbsp;</td>
<%								} //GHL-CRF-0618 - end

                 if((!billing_group_type.equals("H") && !billing_group_type.equals("L")) || (!low_cost_item_visibility.equalsIgnoreCase("visible") && !high_margin_item_visibility.equals("visible")))
                	 alt_need_to_open = false;
                            } // Added for GHL-CRF-0549 [IN:068344] --End  - Devindra
%>							
<% 
/*code starts for the preferred Item */
	/*hardcoded Values 
								bl_preference_check_YN ="Y";
								alert_for_preferred_item_YN ="Y";
								bl_preference_item_code = item_code;
								bl_preference_basis_ind ="S";
								
	hard Coded Values */
	

									if (bl_preference_check_YN .equals("Y")){
										preferred_item_text="<img src='../../ePH/images/Insurance.gif' height='15' width='15' style='cursor:pointer' onClick = showPreferredItems('"+bl_preference_item_code+"','"+bl_preference_basis_ind+"','"+bean_id+"','"+bean_name+"','"+bl_disp_charge_dtl_in_drug_lkp_yn+"','"+bl_disp_price_type_in_drug_lkp+"','"+bl_install_yn+"','"+order_type_code+"','"+take_home_medication+"','"+bl_preference_priority+"'); />";
										if (alert_for_preferred_item_YN.equals("Y"))
											 promptAlert_onclick_of_item ="Y";
										else
											 promptAlert_onclick_of_item ="";
									}else{
											preferred_item_text	= "";
										 }

									if (!(strEnableDisable.equals(""))){
										preferred_item_text="";
									}
									//Added for IN072995 start
									if(ext_disp_appl_yn.equals("Y")){
										preferred_item_text=preferred_item_text+"&nbsp;<img src='../../ePH/images/ExternalDispensing.gif' height='18' width='20'/>";
										}
									//Added for IN072995 end
								//GHL-CRF-0467 starts
								if(strEnableDisable.equals("")){
										strEnableDisable	=	allow_without_stock;
									
								}
								//alternate_flag = bean.altItemsAvailableYn(item_code, item_tech_code);//moved from down to up for GHL-CRF-0618
								//GHL-CRF-0467 ends
/*code starts for the preferred Item */
								if (strEnableDisable != null){
									if(!strEnableDisable.equals("disabled")){
										//GHL-CRF-0618 - start
										if(formulary_billing_app){

											if(alternate_flag && non_preference_flag && !preference.equals("P1")){
												onClick	= "displayAlternateItem('"+item_code+"','"+item_tech_code+"','"+act_patient_class+"');";
												
											}else{
												onClick	=	"selectItem('"+i+"','"+promptAlert_onclick_of_item+"');";
											}
											if(disp_non_preference_rem_window && !alternate_flag){
													onClick1 = "if(formularyNonPreference('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"')){"+onClick+"}";
											}else{  
													onClick1 = onClick;
											}
										}else{
											onClick1	=	"selectItem('"+i+"','"+promptAlert_onclick_of_item+"');";
										}
										//GHL-CRF-0618 - end
%>
									<td id="item<%=i%>" class="<%=classvalue%>" title="<%=store_desc%>" onclick="<%=onClick1%>"><!-- GHL-CRF-0618-->
										<font class='HYPERLINK' onmouseover="changeCursor(this);" ><%=item_desc%> </font>
<%
								}
								else{
%>
									<td id="item<%=i%>" class="<%=classvalue%>" title="<%=store_desc%>" onclick="disableClick(event);">
										<label class="label" style="font-size:xx-small;font-weight:normal" onclick="disableClick(event);"><%= item_desc %>
										</label>
<%
									}
								}
%>
									<input type="hidden" name="hdn_item_code<%=i%>" id="hdn_item_code<%=i%>" value="<%=item_code%>">
									<input type="hidden" name="hdn_line_no<%=i%>" id="hdn_line_no<%=i%>" value="<%=i%>">
									<input type="hidden" name="hdn_trade_code<%=i%>" id="hdn_trade_code<%=i%>" value="<%=trade_code%>">
									<input type="hidden" name="hdn_trade_name<%=i%>" id="hdn_trade_name<%=i%>" value="<%=trade_name%>"> 
									<input type="hidden" name="item_tech_code<%=i%>" id="item_tech_code<%=i%>" value="<%=item_tech_code%>"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->
									<input type="hidden" name="alt_need_to_open<%=i%>" id="alt_need_to_open<%=i%>" value="<%=alt_need_to_open%>"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->
									<input type="hidden" name="hdn_available_qty<%=i%>" id="hdn_available_qty<%=i%>" id="hdn_available_qty<%=i%>" value="<%=avl_qty%>"> <!--//Added By Himanshu for GHL-SCF-1738-->
<%
									if(!trade_name.equals("")){
%>
										<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=trade_name%>)</label>
<%
									}
%></td>
                        <td>
<!-- ============================================================================================================= -->
<%
		String fileName = bean.checkImageExists(item_code);
		if(!(fileName == null || fileName == ""))
		{
%>									
									<img src='../../ePH/images/camera.gif' width='17' height='15' title="Image" onclick = "showImage('<%=item_code%>','<%=trade_code%>');" onmouseover="changeCursor(this);">
<%
		}else{

%>
                  &nbsp;
<%
        }
%>
									
<!-- ============================================================================================================= -->
								</td><td width ="4%">&nbsp;
<!-- code started for Preferred Drugs Item Icon -->
									 <%=preferred_item_text%>

<!-- code ends for the preferered drugs item Icon -->
</td>


<%
								if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
									if(bl_unit_price.equals("")&& !bl_unit_price.equals("0")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}
%>
									<td class="<%=classvalue%>" align="center"><%=disp_str%>												
									</td>
<%
									if(bl_reimburse_yn.equals("")&& bl_reimburse_yn.equals("Y")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}
%>
									<td class="<%=classvalue%>" align="center"> <%=disp_str%>
									</td>
<%
									if(bl_imported_yn.equals("") && bl_imported_yn.equals("Y")){
										disp_str = "<img src=\"../../eCommon/images/enabled.gif\"></img>";
									}
									else{
										disp_str = "&nbsp";
									}
%>
									<td class="<%=classvalue%>" align="center"><%=disp_str%>
									</td>
<%
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
                                if(allow_alt_for_med_item.equals("Y") && alternate_flag){ // Added for GHL-CRF-0548 [IN:068345] - Start - Devindra and modified for GHL-CRF-0618
%>
								<td class='<%=classvalue%>' width='5%' align="right"> <img src="../../ePH/images/altenate.jpg" name="alt_img_<%=i%>" style="cursor:pointer" onClick="displayAlternateItem('<%=item_code%>','<%=item_tech_code%>','<%=act_patient_class%>');" style="cursor:pointer;color:blue" height='15' width='15' > </td>
<%
                                }  else if(allow_alt_for_med_item.equals("Y")){
                                 %> <td class='<%=classvalue%>' width='5%' align="right"> <img src="../../ePH/images/altenate.jpg" name="alt_img_<%=i%>" style="cursor:pointer" onClick="" style="visibility:hidden" height='15' width='15' > </td>
                                <% } // Added for GHL-CRF-0548 [IN:068345] - End - Devindra
%>
								<td class="<%=classvalue%>" align="right" title="<%=store_desc%>"><font class='HYPERLINK' onmouseover="changeCursor(this);" ><label  onclick="displayStock('<%=item_code%>','<%=java.net.URLEncoder.encode(item_desc, "UTF-8")%>','<%=trade_code%>','<%=store_code%>','<%=java.net.URLEncoder.encode(store_desc, "UTF-8")%>','<%=uom_desc%>');"><%=avl_qty%>&nbsp;</label></font></td>
								<td class="<%=classvalue%>"><%=uom_desc%></td>
								
								<% // IN073688 
									if(formulary_billing_app){
										if((!preference.equals("") && !preference.equals("P1")) ||  ( !preference.equals("P1") && non_preference_flag) ){
											strEnableDisable  = "disabled";
										}
									} 
								%>
						<%		if(ht.containsKey(item_code+i))  {  %>
								<td class="<%=classvalue%>" align="center" >
									<input type="checkbox" name="chk_itemSelect<%=i%>" id="chk_itemSelect<%=i%>" value="" checked onClick="storeSelectedItem('<%=i%>')" <%=strEnableDisable%>>
								</td>
								<% } else{ %>
								
							     <td class="<%=classvalue%>" align="center" >
									<input type="checkbox" name="chk_itemSelect<%=i%>" id="chk_itemSelect<%=i%>" value="" onClick="storeSelectedItem('<%=i%>')" <%=strEnableDisable%>>
								</td>
								<%} %>
							</tr>
<%
						}
%>
					</table>
<%				
				
				}
			
				else if(arrList==null || arrList.size()<=1 || !arrList.get(0).equals("cancel")){
					
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%
				}
				bean.setDispPriceTypeinDrugLKPYN(bl_disp_price_type_in_drug_lkp);
				bean.setDispChargeDtlInDrugLKPYN(bl_disp_charge_dtl_in_drug_lkp_yn);
				bean.setBillInstallYN(bl_install_yn);
			//	bean.setPriority(priority); //commented for IN26242 --02/02/2011-- priya
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
				<input type="hidden" name="radioval" id="radioval" value="<%=radioval%>">
				<input type="hidden" name="search_string" id="search_string" value="<%=search_string%>">
				<input type="hidden" name="search_criteria" id="search_criteria" value="<%=search_criteria%>">
				<input type="hidden" name="consignment" id="consignment" value="<%=consignment%>">
				<input type="hidden" name="Manufacturer" id="Manufacturer" value="<%=Manufacturer%>">
				<input type="hidden" name="p_Item_class" id="p_Item_class" value="<%=p_Item_class%>">
				<input type="hidden" name="Item_analysis1" id="Item_analysis1" value="<%=Item_analysis1%>">
				<input type="hidden" name="Item_analysis2" id="Item_analysis2" value="<%=Item_analysis2%>">
				<input type="hidden" name="Item_analysis3" id="Item_analysis3" value="<%=Item_analysis3%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
				<input type="hidden" name="store_name" id="store_name" value="<%=store_name%>">
				<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->
				<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->
				<input type="hidden" name="item_type_yn" id="item_type_yn" value="<%=item_type_yn%>"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->
				<input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=act_patient_class%>"> <!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->							


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


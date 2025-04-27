<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.DecimalFormat, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
30/06/2020		IN072347			Shazana												GHL-CRF-0619
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
03/01/2022		TFS-26862			Prabha												GHL-ICN-0090
--------------------------------------------------------------------------------------------------------------
*/

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


		String locale = (String) session.getAttribute("LOCALE");
		String drug_name = request.getParameter("drug_name")==null?"":request.getParameter("drug_name");
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<title><fmt:message key="ePH.AlternateDrugsfor.label" bundle="${ph_labels}"/> <%=drug_name%></title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugDetailsDisplay.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	Connection con			= null;   
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
       	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
		
		boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); //GHL-CRF-0618
		String drug_code	= request.getParameter("drug_code");
		String store_code	= request.getParameter("store_code");	
		String generic_id	= request.getParameter("generic_id");	
		String route_code	= request.getParameter("route_code");	
		String STORE_CODE		=request.getParameter("STORE_CODE")==null?"":request.getParameter("STORE_CODE");
		//String identity		= request.getParameter("identity");
		String identity		=request.getParameter("identity")==null?"":request.getParameter("identity");
		String drug_class		=request.getParameter("drug_class")==null?"":request.getParameter("drug_class");
		String order_type_code		=request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
		String bean_id		=request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
		String click_drug_name_yn = request.getParameter("click_drug_name_yn")==null?"":request.getParameter("click_drug_name_yn");//GHL-CRF-0549
		String consider_stock	=	"N";
		//String bean_id		= "DrugSearchBean";
		String bean_name	= "ePH.DrugSearchBean";
		DrugSearchBean bean	= (DrugSearchBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id); 
		ArrayList stock_params				=	bean.validateForStock();
		String disp_charge_dtl_in_drug_lkp_yn="";
		String bl_install_yn= (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
		String disp_price_type_in_drug_lkp="";
		String allow_without_stock = "";//GHL-SCF-1415
		String in_formulary_yn	=	bean.getInFormulary();//added for GHL-CRF-0549
		if(stock_params.size() > 1) {
			consider_stock	=	(String)stock_params.get(0);
			disp_charge_dtl_in_drug_lkp_yn=(String)stock_params.get(2);
			disp_price_type_in_drug_lkp = (String)stock_params.get(3);
			allow_without_stock			=(String)stock_params.get(1);
		}	
		String strength_value=request.getParameter("strength_value")==null?"0":request.getParameter("strength_value");//added for ghl-crf-0548
		if(strength_value.equals(""))  //GHL-ICN-0074
			strength_value = "0";
	
		String drug_strength_uom=request.getParameter("drug_strength_uom")==null?"":request.getParameter("drug_strength_uom");//added for ghl-crf-0548
		//GHL-CRF-0549 - start
		String priviligeCheck_fromSearch = bean.getPriviligeDrugCheck();
		
		Hashtable htDisableDrugs = bean.getDrugsAsDisabled();
		
		bean.setSelectedDrug(drug_code);
		//GHL-CRF-0549 - end
		ArrayList arrList  = bean.searchForAltDrugs(generic_id,route_code,drug_code,bl_install_yn, disp_charge_dtl_in_drug_lkp_yn, disp_price_type_in_drug_lkp, STORE_CODE,strength_value.trim(),drug_strength_uom); //,STORE_CODE added for MMS-DM-CRF-0009 [IN:054440]
		String drugorfluid		= bean.getDrugOrFluid();
	//	System.err.println("DrugSearchAlternateDrugs.jsp=======arrList====61==>"+arrList);
		String decimalStringFormat = "#."; //Added for MMS-DM-CRF-0009 [IN:054440] - start
		int noOfDecimals	=bean.getNoOfDecimals();
		if(noOfDecimals == 0)
			decimalStringFormat = "#";
	
		for (int i=0;i<noOfDecimals;i++){
				decimalStringFormat += "#";
		}
		DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	//added for MMS-DM-CRF-0009 [IN:054440] -end
%>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
			<form name="frmDrugNameCommonLookupResult" id="frmDrugNameCommonLookupResult">
		<div class="outer-container"> <!--GHL-CRF-0549 -->
			<div class="top-section"> <!--GHL-CRF-0549 -->
				<table border="1" cellpadding="0" cellspacing="0" width="90%" align="center" name="resultTable" id="resultTable">
					<tr>
						<th width="2%">&nbsp;</th>
						<th width="1%">&nbsp;</th>
						<th width="10%"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></th>
<%						if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && item_type_site_app && 	!encounter_id.equals("")){ //GHL-CRF-0549
%>
						<th width="10%"><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
<%}%>
						<th width="40%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>  <fmt:message key="Common.name.label" bundle="${common_labels}"/></th>
<% 
						if(identity.equals("MedicationOrder")){
%>							<th width="5%">&nbsp;&nbsp;</th><!-- GHL-CRF-0618-->
							<th ><fmt:message key="ePH.Info.label" bundle="${ph_labels}"/></th>
<%
						}
						if( item_type_site_app && bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y") && 	!encounter_id.equals("")){ //added for GHL-CRF-0549 item_type_site_app added for alpha Issue
%>
							<th><fmt:message key="Common.UnitPrice.label" bundle="${common_labels}"/>
							</th><!--GHL-CRF-0549 -->
<%
						}
%>
						<th width="18%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
<% 
							if(consider_stock.equals("Y")) { 
%>
								<th><fmt:message key="ePH.AvailQty.label" bundle="${ph_labels}"/></th>
<%	
							}
%>
						</tr>
<%
						//ArrayList stock_dtls	=	null;
						//String stock_yn			=   "N";
						String avl_qty			=   "";
						String classvalue		=	"";
						String qty_uom			=	"";
						String[] strArray = null;
						StringTokenizer st =null;
						String qtyString1 = "";
						String uomDesc1 = "";
						String qtySymbol = "";
						String qtyString2 = "";
						String uomDesc2 = "";
						String disp_str = ""; //GHL-CRF-0549 
						int cnt = 0;
						//GHL-CRF-0549 - start
						String onClick1 = "";
						String bl_grp_app		   = "";
						String mm_item_low_cost_yn = "";	
						String mm_item_high_margin_yn = "";
						String mm_item_Innovator_yn = "";
						String low_cost_green_style ="visibility:none";
						String high_margin_green_style ="visibility:none";
						String high_margin_red_style   ="visibility:none";
						String low_cost_red_style	="visibility:none";
						String low_cost_grey_style ="visibility:none";
						String high_margin_grey_style ="visibility:none";
						String innovator_style		="visibility:none";
						String item_type = "";
						String strEnableDisable =	"";
						String strChecked		=	"";
						String error_code = "";
						String sys_message_id = "";
						String error_text = "";
						
						if(item_type_site_app)
						bl_grp_app = bean.getItemTypeApp();

						if(bl_grp_app.equals("")) //GHL-CRF-0549
							bl_grp_app = "N";
						//GHL-CRF-0618 - start
						String preference	  = ""; //GHL-CRF-0618
						String preference_img = ""; //GHL-CRF-0618
						String formulary_code = ""; //GHL-CRF-0618
						String formulary_type = "";
						HashMap hm = null;
						boolean non_preference_flag = false; //GHL-CRF-0618
						ArrayList itemGenericType = null;


						if(formulary_billing_app){
							formulary_code = bean.getFormularyCode();
							formulary_type = bean.getFormularyBlngGrpType();
							if(formulary_code==null)
								formulary_code = "";
							if(formulary_type==null)
								formulary_type = "";
			
							if(!formulary_code.equals("")){
							String blng_grp_id = bean.getBillingGrpId(); //added for GHL-SCF-1527
							 hm = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id,"D"); //blng_grp_id added for GHL-SCF-1527
 							 itemGenericType = bean.getItemGenericType();
							}
								
						}
					//GHL-CRF-0618 - end
						//bl_grp_app = "L";
						//GHL-CRF-0549 - end
					//	bl_grp_app = "H";
						//added drug_code in checkStock for tempory purpose...please go through if any error occurs
						for (int i=0;i<arrList.size();i++){
							strArray=(String[])arrList.get(i);
							//consider_stock added during PE corrections by Naveen
							/*ArrayList stock_dtls 		= (ArrayList)bean.checkStock(strArray[0],strArray[10],drug_class,order_type_code,consider_stock,(String)stock_params.get(1),patient_id,encounter_id); //commented for MMS-DM-CRF-0009 [IN:054440] -start

							if(stock_dtls!=null && stock_dtls.size() > 0) {
								//stock_yn			=	(String)stock_dtls.get(0);
								avl_qty				=	(String)stock_dtls.get(1);
								qty_uom				=	bean.getStockUOM(strArray[0]);
							}
							else{
								//stock_yn			=	"N";
								avl_qty				=	"0";
								qty_uom				=	"";
							}*/ //commented for MMS-DM-CRF-0009 [IN:054440] -end
							avl_qty		=	strArray[23];//added for MMS-DM-CRF-0009 [IN:054440] -start
							if(avl_qty.equals("") || avl_qty.equals("0")) {
								avl_qty	=	"0";
							}																
							if(avl_qty != null && !avl_qty.equals("")){
								avl_qty = dfToInteger.format(Double.parseDouble(avl_qty));
							}
							qty_uom		=	strArray[24]; //added for MMS-DM-CRF-0009 [IN:054440] -end
							if ( i % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
%>
							<tr>
								<td style="cursor:pointer;color:blue" class="<%=classvalue%>" onClick="callDrugDetailsDisplay('<%=strArray[0]%>')">+</td>
								<td class="<%=classvalue%>">&nbsp;</td>
								
								<td class="<%=classvalue%>"><%=strArray[5]%></td>
	<%						//GHL-CRF-0549 - start
								if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && item_type_site_app && 	!encounter_id.equals("") ){


									low_cost_green_style ="visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									high_margin_red_style   ="visibility:hidden";
									low_cost_red_style	="visibility:hidden";
									low_cost_grey_style ="visibility:hidden";
									high_margin_grey_style ="visibility:hidden";
									innovator_style		="visibility:hidden"; 
									high_margin_grey_style = "visibility:hidden"; 
									low_cost_grey_style="visibility:hidden";

									item_type= bean.getItemType(strArray[0]);
									mm_item_low_cost_yn = item_type.split("~")[0];
									mm_item_high_margin_yn = item_type.split("~")[1];
									mm_item_Innovator_yn = item_type.split("~")[2];
									
								//	mm_item_low_cost_yn = "Y";
								//	mm_item_high_margin_yn = "N";
								//	mm_item_Innovator_yn = "Y";

									if(!bl_grp_app.equals("N")){
									if(mm_item_low_cost_yn.equals("Y")) {
										if(bl_grp_app.equals("L")){
												low_cost_green_style ="visibility:visible";
												low_cost_red_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												
											if(mm_item_high_margin_yn.equals("Y")){
												high_margin_red_style = "visibility:visible";
												high_margin_green_style ="visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
											}else{
												high_margin_grey_style = "visibility:hidden";
											}
										}else{
											if(bl_grp_app.equals("H")){
												low_cost_green_style ="visibility:hidden";
												low_cost_red_style = "visibility:visible";
												low_cost_grey_style = "visibility:hidden";
											}
										} 
									}else{
											low_cost_green_style ="visibility:hidden";
											low_cost_red_style = "visibility:hidden";
											low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
											if(bl_grp_app.equals("H")){
												high_margin_green_style ="visibility:visible";
												high_margin_red_style = "visibility:hidden";
												high_margin_grey_style = "visibility:hidden";
												if(mm_item_low_cost_yn.equals("Y")) {
												low_cost_red_style ="visibility:visible";
												low_cost_green_style = "visibility:hidden";
												low_cost_grey_style = "visibility:hidden";
												}

											}else{
												if(bl_grp_app.equals("L")){
													high_margin_red_style = "visibility:visible";
												}
											}
									}else{
										
											high_margin_green_style ="visibility:hidden";
											high_margin_red_style = "visibility:hidden";
											high_margin_grey_style = "visibility:hidden";
									}

									if(mm_item_Innovator_yn.equals("Y")){
											innovator_style		="visibility:visible";		
										}else{
											innovator_style		="visibility:hidden";		
										}
									}
								else{
									low_cost_green_style = "visibility:hidden";
									high_margin_green_style = "visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									high_margin_red_style = "visibility:hidden";

									if(mm_item_low_cost_yn.equals("Y"))
										low_cost_grey_style = "visibility:visible";		
									else
										low_cost_grey_style = "visibility:hidden";					
	
									if(mm_item_high_margin_yn.equals("Y"))
										high_margin_grey_style = "visibility:visible";
									else
										high_margin_grey_style = "visibility:hidden";
									
									if(mm_item_Innovator_yn.equals("Y"))
										innovator_style		="visibility:visible";		
									else
										innovator_style		="visibility:hidden";		
								}
								onClick1 = "";
							
															//GHL-CRF-0618 - start
								if(formulary_billing_app){ //GHl-CRF-0618 - start
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
									
									if(mm_item_low_cost_yn.equals("Y")){
										low_cost_grey_style = "visibility:visible";
									}else{
										low_cost_grey_style = "visibility:hidden";
									}
									if(mm_item_high_margin_yn.equals("Y")){
										high_margin_grey_style = "visibility:visible";								
									}else{
										high_margin_grey_style = "visibility:hidden";
									}
									if(mm_item_Innovator_yn.equals("Y")){
										innovator_style		="visibility:visible";
									}else{
										innovator_style		="visibility:hidden";
									}

									if(hm!=null && hm.size()>0){
									  if(itemGenericType!=null && itemGenericType.size()>0){
										if(itemGenericType.contains("D"))
											non_preference_flag = true;
									  }

										preference = "";
										preference_img = "";
										if(hm.containsKey(strArray[0])){
											non_preference_flag = true;
											preference = (String)hm.get(strArray[0]);
											//System.err.println("preference=ds==ds==>"+preference);
											
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
												preference_img ="<img src='../../ePH/images/Preference4.jpg' height='15' width='15' title='Non Prefered Item' />";
										}

									}
								}
								//GHL-CRF-0618 - end
 	
								//System.err.println("DrugSearchAlternateDrugs.jsp==d==htDisableDrugs====298====>"+htDisableDrugs+"==click_drug_name_yn==>"+click_drug_name_yn+"==formulary_type====>"+formulary_type+"==preference====>"+preference+"==strEnableDisable===>"+strEnableDisable);
								if(htDisableDrugs !=null){
								if (htDisableDrugs.contains(strArray[0])){
									strEnableDisable = "disabled";
									strChecked	="checked";
									onClick1		=	"";
									
								}
								else{
									//if(click_drug_name_yn.equals("Y")){
									strEnableDisable = "";
									strChecked		 ="";
									onClick1	=	"return DrugSearchModify1(document.getElementById('drug_name'+i),'"+strArray[8]+"','"+strArray[9]+"','"+strArray[2]+"','"+strArray[3]+"','"+strArray[4]+"','"+strArray[6]+"','"+strArray[12]+"','"+strArray[0]+"','"+strArray[10]+"','"+java.net.URLEncoder.encode(strArray[11],"UTF-8")+"','"+i+"','Y');";
								//}
								}
							}
						String patientClass= bean.getPatientClass();//ADDED for GHL-CRF-0619
						
							if(formulary_billing_app){ //GHl-CRF-0618 
								if(!onClick1.equals("")){
									if(non_preference_flag){
									if(formulary_type.equals("C")){
										if(preference.equals("") || !preference.equals("P1")){
											//Added for GHL-CRF-0619 START
											//if(formulary_type.equals("C")){
												onClick1 = "if(checkBrand('"+strArray[0]+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"')){"+"if(formularyNonPreference('"+strArray[0]+"','"+patient_id+"','"+encounter_id+"')){"+onClick1+"}"+"}"; 	//modified for GHL-ICN-0090											   
										//	}else{//GHL-CRF-0619 END
										//		onClick1 = "if(formularyNonPreference('"+strArray[0]+"','"+patient_id+"','"+encounter_id+"')){"+onClick1+"}"; 
											//}//added for GHL-CRF-0619	 										
										}else{
										  if(preference.equals("P1")){
										 	 onClick1 = "if(checkBrand('"+strArray[0]+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"','"+java.net.URLEncoder.encode(strArray[1],"UTF-8")+"')){"+onClick1+"}"; 															
										  }
										} 
									}else{
										if(preference.equals("") || !preference.equals("P1")){
										strEnableDisable = "disabled";
										strChecked	="checked";
										onClick1		=	"";
										}
									}
									}
									
								}
								//System.err.println("preference===."+preference+"===onClick1===>"+onClick1+"==strEnableDisable===>"+strEnableDisable);
							} //GHl-CRF-0618 - end
						

							if(consider_stock.equals("Y")){ //GHL-SCF-1415 - start
							System.err.println("avl_qty=====>"+avl_qty);
								if(allow_without_stock!=null && allow_without_stock.equals("N") && (avl_qty.equals("") || avl_qty.equals("0"))  ){

								onClick1	=	"";

								}
							}	//GHL-SCF-1415 - end


								
								
									
%>								<td class='<%=classvalue%>'>&nbsp
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'>
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>' ><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>' ><%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" style="<%=low_cost_grey_style%>" title="Low Cost Item" height='15' width='15' ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" style="<%=high_margin_grey_style%>" height='15' title="High Margin Item" width='15' ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" style="<%=innovator_style%>" title="Innovator Item"   height='15' width='15' > <%}%>

								</td>
								<%if(!onClick1.equals("")){%>
								<td class="<%=classvalue%>" style="cursor:pointer;color:blue" onclick ="<%=onClick1%>"><%=strArray[1]%></td>
<%								}else{ %>
								<td class="<%=classvalue%>" style="font-size:xx-small;font-weight:normal" onclick ="<%=onClick1%>"><%=strArray[1]%></td>
<%								}
%>
<%								}else{ %>
								<td class="<%=classvalue%>"><%=strArray[1]%></td>
<%								}
								if(identity.equals("MedicationOrder")){
	//System.err.println("DrugSearchAlternateDrugs.jsp====strArray[20]=====170===>"+strArray[20]);
%>	
								<input type='hidden' name='diagnosis_found_yn<%=i%>' id='diagnosis_found_yn<%=i%>' value='Y'>
								<input type ="hidden" name = "previligeGroupDrug_ordering_YN<%=i%>" value ="Y" />
								<input type='hidden' name='appl_for_age_grp_yn<%=i%>' id='appl_for_age_grp_yn<%=i%>' value='<%=strArray[22]%>'>
<!-- GHL-CRF-0549 - end--><td class="<%=classvalue%>" align="center"><%=preference_img%>&nbsp</td><!-- GHL-CRF-0618 -->
									<td class="<%=classvalue%>" align="center">
<%
									if(drug_db_interface_yn.equals("Y")){
										if(bean.getExternalProductId(strArray[0])!=null){
%>
											<img src="../../ePH/images/info.gif"  height='15' width='15' style="cursor:pointer" onClick='showDrugInfo("<%=bean.getExternalProductId(strArray[0])%>","<%=java.net.URLEncoder.encode(strArray[1],"UTF-8")%>")'>
<%
										}
								   }
%>
									&nbsp;
								</td>
<%
							}
							//GHL-CRF-0549 - start
							if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && in_formulary_yn.equals("Y") && item_type_site_app && !encounter_id.equals("")){ //added for GHL-CRF-0549

								disp_str = "";
								error_code = strArray[17] ; 
								sys_message_id = strArray[18];
								error_text    = strArray[19] ;

//								if(strArray[29].equals("Y")){
									if(strArray[16]!=null && !strArray[16].equals("")&& !strArray[16].equals("0")){
										disp_str =strArray[16] ;
									}else{
										disp_str = "&nbsp";

										/*if(((error_code.equals("10") && (!error_text.equals(""))) ||!sys_message_id.equals(""))&&(!sys_message_id.equals("BL9743"))){
											disp_str = "<font style=color:red>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")+"</font>";
										}
										else{
											disp_str = "&nbsp";
										} */
									}
								//}
%>							<td class="<%=classvalue%>" align="center"> <%=disp_str%>	&nbsp;
							</td>
<%							} //GHL-CRF-0549 - end
							st =new StringTokenizer(strArray[2],"~");
							qtyString1 = "";
							uomDesc1 = "";
							qtySymbol = "";
							qtyString2 = "";
							uomDesc2 = "";
							cnt = 0;
							if (st.hasMoreTokens()){  //
								qtyString1 = st.nextToken();
								if(qtyString1!=null && !qtyString1.equals("") && Float.parseFloat(qtyString1) <1)
									qtyString1 = Float.parseFloat(qtyString1)+"";
								cnt = st.countTokens();
								if(cnt>3){
									uomDesc1   = st.nextToken();
									qtySymbol  = st.nextToken();
									qtyString2 = st.nextToken();
									if(qtyString2!=null && !qtyString2.equals("") && Float.parseFloat(qtyString2) <1)
										qtyString2 = Float.parseFloat(qtyString2)+"";
									uomDesc2   = st.nextToken();
								}
								else{
									uomDesc1   = "";
									qtySymbol  = "";
									qtyString2 = "";
									uomDesc2   = "";
								}
							}
%>
							<td class="<%=classvalue%>"><%= qtyString1%> <%=uomDesc1 %>  <%= qtySymbol %> <%= qtyString2%> <%=uomDesc2 %>&nbsp;</td> <!--<%= strArray[3] %> removed for IN23171 --09/08/2010-- priya -->
<% 
							if(consider_stock.equals("Y")) { 
%>
								<td class="<%=classvalue%>" align="center" style="cursor:pointer;color:blue" onClick='displayStock("<%=strArray[0]%>","<%=java.net.URLEncoder.encode(strArray[1],"UTF-8")%>","<%=strArray[10]%>","<%=java.net.URLEncoder.encode(store_code,"UTF-8")%>","<%=STORE_CODE%>")'><%=avl_qty%>&nbsp;<%=qty_uom%></td>
<%	
							}
%>
							</tr>
<%
							uomDesc1   = "";
							qtySymbol  = "";
							qtyString2 = "";
							uomDesc2   = "";
							qtyString1 = "";
						}
%>
						</table>
						</div>
						
						<input type="hidden" name="bean_id" id="bean_id"    value="<%=bean_id%>" >
						<input type="hidden" name="bean_name" id="bean_name"  value="<%=bean_name%>" >
<!--GHL-CRF-0549 - start -->					
						<input type ='hidden' name ='priviligeCheck_fromSearch' value ='<%=priviligeCheck_fromSearch%>'>
						<input type="hidden" name="identity" id="identity" value="<%=identity%>">
						<input type="hidden" name="drugorfluid" id="drugorfluid" value="<%=drugorfluid%>">
					
				<%

				if(bl_install_yn.equals("Y") && identity.equals("MedicationOrder") && item_type_site_app &&  !encounter_id.equals("") ){%>	<div>
					<table border=1 width="100%">
					<%
					if(!formulary_billing_app){
					%>
					<tr ><td>		
					<td class="white" align="left"><img src="../../ePH/images/LowCost.jpg" height='15' width='15' >
								<td><fmt:message key="ePH.LowCostItem.label" bundle="${ph_labels}"/>
								</td >
								<td class="white" align="left"><img src="../../ePH/images/HighMargin.jpg" height='15' width='15' ></td>
								<td class="white" align="left"><fmt:message key="ePH.HighMarginItem.label" bundle="${ph_labels}"/>
								</td>
								<td class="white" align="left"><img src="../../ePH/images/Innovator.jpg" height='15' width='15' ></td><td class="white" align="left">
								<fmt:message key="ePH.Innovator.label" bundle="${ph_labels}"/>
								</td>
								
					</td></tr>
					<%}%>
						<%if(formulary_billing_app)  //Start of GHL-CRF-0618
						{%>
					<tr>
							<td class='white' width='1%'></td>	
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
							</tr>
							<%
							}%>    <!-- End of GHL-CRF-0618 -->

</table>
					</div><%}%>
					</div> <!--GHL-CRF-0549 - end-->
					</form>
				</body>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}finally{ 
        	if(con != null)
          		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
	}
%>
</html>


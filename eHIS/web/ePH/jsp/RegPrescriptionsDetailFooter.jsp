<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.Connection,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %><!-- java.sql.Connection,webbeans.eCommon.ConnectionManager added for ML-BRU-0469 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
			request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
			response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
			response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
			//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
 -->	
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  topmargin="0">
<%
	try{
	//	String displayData		=	request.getParameter("displayData");//Commented for //Added for ML-BRU-SCF-1199 [IN:045703]-end
		String calledfrom		=	request.getParameter("calledfrom"); 
		String encounter_id		=	request.getParameter("encounter_id");
		String enableDisable1	=	request.getParameter("enableDisable");
		String  patient_id		=	"";
		calledfrom=CommonBean.checkForNull(calledfrom);
		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		String drug_db_interface_yn			=  param_bean.getDrugDBInterface_yn(facility_id); 
		param_bean.clear();
		param_bean.setLanguageId(locale);
		/*displayData = displayData.trim(); //Commented for //Added for ML-BRU-SCF-1199 [IN:045703]-end
		StringTokenizer st = new StringTokenizer(displayData,"~");
		st.nextToken();
		st.nextToken();*/
		String drugid="";
		String qtyunit="";
		String drugname = "",qtyvalue="",qtyunitdesc="",freqdesc="",durnvalue="",durndesc="",order_line_num="",order_id="",order_status="",ext_prod_id="",bms_qty="";

		String	disp_bean_id				=	"DispMedicationAllStages" ;
		String	disp_bean_name			    =	"ePH.DispMedicationAllStages";	
		
		DispMedicationAllStages disp_bean = (DispMedicationAllStages)getBeanObject( disp_bean_id, disp_bean_name,request);
		disp_bean.setLanguageId(locale);

		String	bean_id						=	"RegPrescriptionsBean" ;
		String	bean_name					=	"ePH.RegPrescriptionsBean";
		String enableDisable				= "";
		String checkedUnchecked				= "";
		RegPrescriptionsBean bean			= (RegPrescriptionsBean)getBeanObject( bean_id,bean_name,request) ;
		//bean.setLanguageId(locale);

		String Image_bean_id				= "@DrugTradeImageBean";
		String Image_bean_name				= "ePH.DrugTradeImageBean";
		DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );

		String  billing_interface_yn		=	request.getParameter("billing_interface_yn");//disp_bean.checkforbillinginterface();
		String  dischargeIND_yn             =   request.getParameter("dischargeIND_yn");
		String patient_class                =   "";
		String width						=	"100%";
		String disp_locn_code               =   bean.getDispLocnCode();    
		String sys_date						=	bean.getTodaysDate();
		float tot_gross_charge_amount		=   0;
		float tot_groos_pat_payable			=   0; 
		float tot_gross_amount             =   0; // added for ML-BRU-CRF-0469
		String tot_gross_charge_amount_str	=  "";
		String tot_groos_pat_payable_str	=  "";
		String tot_gross_amount_str         =	"";	// added for ML-BRU-CRF-0469
		String decimalFormatString			=  "";
		String gross_charge_amount_str		=  "";
		String groos_pat_payable_str		=  "";
		String gross_amount_str             =   ""; //added for ML-BRU-CRF-0469
		String image_path					=  "";
		String trade_code					=  "";
		String in_formulary_yn				=  "N";
		String drug_yn				        =  "";
		String route_desc  =  "", route_color="",backgrndColor="", fntColor="" ;// added for CRF RUT-CRF-0034.1[IN:037389]
		//String dischargeIND				=  "N";
		HashMap bl_override_det             =  new HashMap();
		HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
		ArrayList result = null; //Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end
		int count = 0;
		// Added for ML-BRU-CRF-0469 [IN:065426] - start
		Connection con=null;
		boolean displayGrossAmtYn           = false;
		try{
			con = ConnectionManager.getConnection(request);
			displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
		}
		catch(Exception e){
			e.printStackTrace();
			displayGrossAmtYn = false;
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}  // Added for ML-BRU-CRF-0469 [IN:065426] - End
		
%>
		<form name="regprescriptionsdetailfooter" id="regprescriptionsdetailfooter" >
			<table cellpadding="0" cellspacing="0" width='<%=width%>' align="center" border="1" id="regprescriptionsdetailfootertable" name="regprescriptionsdetailfootertable" >
				<tr>
				<td class= "COLUMNHEADER" style="font-size:xx-small"  colspan="7"><fmt:message key="ePH.PrescriptionDetails.label" bundle="${ph_labels}"/></td><!-- colspan="7" changed from colspan="6" for ML-BRU-CRF-0469 -->
				</tr>
				<tr>
					<td class= "COLUMNHEADER" style="font-size:xx-small" ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td> 
					<td class= "COLUMNHEADER" style="font-size:xx-small" ><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></td>	
<%
					if(billing_interface_yn.equals("Y")){
%>
                         <!-- Added for ML-BRU-CRF-0469 start -->
                         <% if(displayGrossAmtYn){ %>
                        <td class= "COLUMNHEADER" style="font-size:xx-small" ><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td> 
                        <% }%>
						<!-- Added for ML-BRU-CRF-0469 end -->
						<td class= "COLUMNHEADER" style="font-size:xx-small" ><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" style="font-size:xx-small" ><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADER" style="font-size:xx-small" >&nbsp;</td>
<% 
					}
%>
					<td class= "COLUMNHEADER" style="font-size:xx-small;" ><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/><!-- display:inline changed from display:none for Bru-HIMS-CRF-352 [IN:038516]  -->
					</td>
					
				</tr>
<%
				result = new ArrayList(bean.getRegisteredOrders());//added for //Added for ML-BRU-SCF-1199 [IN:045703]-end--start
				if(result.size()>0) //Commented for  [IN:047547] //changed for [IN:047768]
          			result.remove(result.size()-1); //Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end //commented for  [IN:047547]
				Hashtable prescriptionDetails = bean.getPrescriptionDetails();
				patient_id= bean.getPatientID();
				
				if (prescriptionDetails.size()<1){
					enableDisable = "";
					checkedUnchecked = "checked";
				}

				int row_no = 1;
				String classval="", tapered_yn="", taper_order_id="", order_id_selected="",stock_uom="",base_uom = ""; // stock_uom,base_uom Added for ML-BRU-SCF-1798
				Enumeration v = null;
				int i=0;
				int adr_count =0;
				float base_to_disp_uom_equl = 0f;//ML-BRU-SCF-1798
				for(int res=0;res<result.size();res=res+19){ //changed from 19 - 20 for  [IN:047547]
					if(row_no % 2 == 0 )
						classval	=	"QRYEVEN";
					else
						classval	=	"QRYODD";
						drugid		=  (String)result.get(res);
					
					drugid		=  drugid.trim();
					drugname	=  (String)result.get(res+1);
					qtyvalue	= (String) result.get(res+2);
					qtyunit		= (String) result.get(res+3);	
					qtyunitdesc = (String) result.get(res+4);		
					freqdesc	=  (String)result.get(res+5);	
					durnvalue	=  (String)result.get(res+6);	
					durndesc	=  (String)result.get(res+7);		
					order_line_num	= (String)result.get(res+8);
					order_id		= (String)result.get(res+9);
					order_status	=(String) result.get(res+10);
					ext_prod_id	= (String)result.get(res+11);
					bms_qty	= (String)result.get(res+12);
					in_formulary_yn	=(String) result.get(res+13);
					drug_yn	= (String)result.get(res+14);
					tapered_yn	= (String)result.get(res+15);
					taper_order_id	=(String) result.get(res+16);
					route_desc	= (String)result.get(res+17);
					route_color	= (String)result.get(res+18);//Modified for change in Register order data retrival--end

//added for ML-BRU-SCF-1798 - start
					 stock_uom = bean.getStockUom(order_id,order_line_num,(String)result.get(res));
					 base_uom = bean.getStoreDfltBaseUOM(disp_locn_code,(String)result.get(res));
				
					if(base_uom==null)
					 base_uom = "";
					if(!base_uom.equals("")&& !base_uom.equals(stock_uom)){
						base_to_disp_uom_equl    =	bean.getEqulValue( (String)result.get(res), base_uom, stock_uom);
						bms_qty = Math.round(Float.parseFloat(bms_qty)* base_to_disp_uom_equl)+"";
					}
//added for ML-BRU-SCF-1798 - end
					fntColor= "";
					backgrndColor= "";
					if(route_color!= null && !route_color.equals("")){
						if(route_color.length()==12){
							fntColor= route_color.substring(0, 6);
							backgrndColor= route_color.substring(6, 12);
						}
					}// added for CRF RUT-CRF-0034.1[IN:037389]-end
					trade_code				= (String)bean.gettrade_codes(order_id,order_line_num,drugid);     
					image_path				=  drug_trade_bean.getImagePath(drugid,trade_code);
					row_no ++;
					adr_count = disp_bean.getADRCount(patient_id,drugid);
					v=prescriptionDetails.keys();
					while (v.hasMoreElements() ) {
						order_id_selected = (String)v.nextElement();
						if ((order_id.trim()).equals(order_id_selected.trim())){
							ArrayList arrListOrderLine = (ArrayList)prescriptionDetails.get(order_id_selected.trim());
							if (arrListOrderLine.size()>0){

								if ((((String)arrListOrderLine.get(0)).trim()).equals("*ALL")){					
									enableDisable = "";
									checkedUnchecked = "checked";
									break;
								}
								else{
								
									for (int j=0;j<arrListOrderLine.size() ; j++){
										if (((String)arrListOrderLine.get(j)).equals(order_line_num)){
											checkedUnchecked = "checked";
											enableDisable = "";
											break;
										}else{
											checkedUnchecked = "";
										}
									}
								}
							}
							break;
						}
						else{
							checkedUnchecked = "checked";
							//enableDisable = "disabled";
						}
					}
%>
					<tr >
						<td style="font-size:xx-small" class='<%=classval%>' width="57%"><%=drugname%>
<%
						if(ext_prod_id!=null && !ext_prod_id.equals("N")&& drug_db_interface_yn.equals("Y")){
%>      
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drugname,"UTF-8")%>')"></img>
<%
						}
						if ((image_path!=null)&& !(image_path.equals(""))){
%>
							<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height=20  width=20 onClick="showImage('<%=drugid%>','<%=trade_code%>')">
<%
						}
	   
						if(adr_count>0){   
%>
							<img  id="ADR_img" src='../../ePH/images/ADR.gif'   title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>'></img>
<% 
						}
%>
						<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drugid%>');" >
<%
							//int count = disp_bean.chkfortapering(order_id,drugid, order_line_num);
							taperValues=disp_bean.chkfortapering(order_id,drugid, order_line_num, patient_id);	//Modified for RUT-CRF-0088 [IN036978] 		
							count =Integer.parseInt(taperValues.get("COUNT").toString());  // Modified for RUT-CRF-0088 [IN036978]
							if(count>1){
								String taper = disp_bean.getTapervalue();
								if(taper.equals("UP")){
%>	
									<img src="../../ePH/images/uparrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drugid%>');" valign="center" title='Taper Dose' style="cursor:pointer"height='20' width='20'></img>
<%
								}
								else if(taper.equals("DOWN")){
%>
									<img src="../../ePH/images/downarrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drugid%>');" valign="center" title='Taper Dose' style="cursor:pointer" height='20' width='20'></img>
<%	
								}
							}
%>
<%							if(route_desc!=null && route_desc.trim().length()>0)//Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end -start
                        	  {
%>                           <label id="route_desc" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>'>(<%=route_desc%>)</label> <!-- added  for CRF RUT-CRF-0034.1 [IN:037389] -->
							</td>
<%							  }//Added for //Added for ML-BRU-SCF-1199 [IN:045703]-end--end
							if(drug_yn.equals("Y")){
%>
								<td style="font-size:xx-small"   class='<%=classval%>' width="33%">&nbsp;&nbsp;<%=qtyvalue%> <%=qtyunitdesc%> , <%=freqdesc%> ,<%=durnvalue%> <%=durndesc%>
<%
							}
							else{
%>
								<td style="font-size:xx-small"   class='<%=classval%>' width="33%">&nbsp;&nbsp;<%=qtyvalue%> <%=qtyunitdesc%>
<%
							}
%>
							</td>
<%
							if(billing_interface_yn.equals("Y") ){
								if(in_formulary_yn.equals("Y")&&disp_bean.getBillableItemYN (drugid).equals("Y") &&( !tapered_yn.equals("Y") || taper_order_id.equals("N"))){ // && --> || for tappered condition for  ML-BRU-SCF-0368 [IN:034748]
									float gross_charge_amount =  0;
									float groos_pat_payable   =  0;
									 float gross_amount       = 0;//Added for ML-BRU-CRF-0469
									gross_charge_amount_str	  =  "";
									groos_pat_payable_str	  =  "";
									gross_amount_str          =  "";//added for ML-BRU-CRF-0469
									StringBuffer gross_charge_display_str  = new StringBuffer();
									StringBuffer pat_charge_display_str    = new StringBuffer(); 
									StringBuffer gross_disply_str          = new StringBuffer(); //added for ML-BRU-CRF-0469
									bl_override_det =new HashMap();
									bl_override_det = (HashMap)bean.getbl_override_det(order_id,order_line_num,drugid);

									if(!encounter_id.equals("")){
										patient_class                  =   bean.getEncounterPatientClass(encounter_id,(String)bl_override_det.get("ORDERING_FACILITY_ID"), patient_id); // patient_id   added for [IN:035667] 
									}
									else{
										patient_class                  =  "R";
									}

									HashMap chareg_det = bean.callItemChargeDtls(patient_id ,encounter_id,patient_class,drugid,Integer.parseInt(bms_qty),";",sys_date,disp_locn_code,(String)bl_override_det.get("BL_INCL_EXCL_OVERRIDE_VALUE"),(String)bl_override_det.get("BL_INCL_EXCL_OVERRIDE_REASON"),order_id,order_line_num,"R",(String)bl_override_det.get("ORDERING_FACILITY_ID"),dischargeIND_yn); //order_id and order_line_num added for MMS-DM-CRF-0126

									if(chareg_det.get("error_msg").equals("")){

										decimalFormatString         =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
										DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);

										/*if(!chareg_det.get("grosschargeamt").equals("null")){
											 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
										}*/ //commented for ML-BRU-SCF-0368 [IN:034748]
										if(!chareg_det.get("patnetamt").equals("null")){
											 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
										}
										if(!chareg_det.get("netchargeamt").equals("null")){
											//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
											gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); // added ML-BRU-SCF-0368 [IN:034748]
										}
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										if(!chareg_det.get("grosschargeamt").equals("null")){
											gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
										    }
										}
										//added for ML-BRU-CRF-0469 end
										gross_charge_amount_str = dfTest.format(gross_charge_amount);
										groos_pat_payable_str   = dfTest.format(groos_pat_payable);
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										gross_amount_str        = dfTest.format(gross_amount);		
										}
										//added for ML-BRU-CRF-0469 end
										gross_charge_display_str.append("<label style='font-size:9;color:black'>").append(groos_pat_payable_str).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9;color:black'>").append(gross_charge_amount_str).append("</label>");
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										      gross_disply_str.append("<label style='font-size:9;color:black'>").append(gross_amount_str).append("</label>");
										}
										//added for ML-BRU-CRF-0469 end
										tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
										tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
												//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){
										tot_gross_amount        = tot_gross_amount+gross_amount;
												}
												//added for ML-BRU-CRF-0469 end
									}
									else{
										gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
										pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");								
										//added for ML-BRU-CRF-0469 start
										if(displayGrossAmtYn){   
											gross_disply_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");//added for ML-BRU-SCF-0469
										}
										//added for ML-BRU-CRF-0469 end
										}
%>
                                 <!-- added for ML-BRU-CRF-0469 start-->
                                   <% if(displayGrossAmtYn){ %>
                                    <td style="font-size:xx-small"  id='gross_amount_str_<%=i%>' class='<%=classval%>' width="9%">&nbsp;<%=gross_disply_str.toString()%></td>
                                    <%} %>
                                    <!-- added for ML-BRU-CRF-0469 end-->
									<td style="font-size:xx-small"  id='groos_pat_payable_str_<%=i%>' class='<%=classval%>' width="9%">&nbsp;<%=pat_charge_display_str.toString()%></td>	
									<td style="font-size:xx-small"  id='gross_charge_amount_str_<%=i%>'  class='<%=classval%>'  >&nbsp;<%=gross_charge_display_str.toString()%></td>

<%
								if(chareg_det.get("error_msg").equals("")){
%>
									<input type="hidden" name="override_allowed_yn_<%=i%>" id="override_allowed_yn_<%=i%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
									<input type="hidden" name="excl_incl_ind_<%=i%>" id="excl_incl_ind_<%=i%>"        value="">
									<input type="hidden" name="excl_incl_ind_default_<%=i%>" id="excl_incl_ind_default_<%=i%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
									<input type="hidden" name="approval_reqd_yn_<%=i%>" id="approval_reqd_yn_<%=i%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
									<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=i%>" id="bl_incl_excl_override_reason_desc_<%=i%>" value="">
									<input type="hidden" name="bl_incl_excl_override_reason_code_<%=i%>" id="bl_incl_excl_override_reason_code_<%=i%>" value="">
									<input type="hidden" name="gross_charge_amount_<%=i%>" id="gross_charge_amount_<%=i%>" value="<%=gross_charge_amount+""%>">
									<input type="hidden" name="groos_pat_payable_<%=i%>" id="groos_pat_payable_<%=i%>"   value="<%=groos_pat_payable+""%>">
									<!-- added for ML-BUR-CRF-0469 start-->
									<% if(displayGrossAmtYn){ %>
									<input type="hidden" name="gross_amount_<%=i%>" id="gross_amount_<%=i%>"        value="<%=gross_amount+""%>">
									<%} %>
									<!-- added for ML-BUR-CRF-0469 end -->
									<td style="font-size:xx-small"  class='<%=classval%>' width="9%"><a href="javascript:callIncludeExclude('<%=i%>','<%=drugid%>','<%=bms_qty%>',';','<%=order_id%>','<%=order_line_num%>');" id="include_exclude"  style="font-size:9;"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>?</a></td>
<%
								}
								else{
%>
									<td style="font-size:xx-small"  class='<%=classval%>' width="9%">&nbsp;</td>
<%	
								}
							}
							else{
%>
								<td style="font-size:xx-small"  id='gross_charge_amount_str_<%=i%>'  class='<%=classval%>'  >&nbsp;</td>
								<td style="font-size:xx-small"  id='groos_pat_payable_str_<%=i%>' class='<%=classval%>' width="9%">&nbsp;</td>
								<td style="font-size:xx-small"  class='<%=classval%>' width="9%">&nbsp;</td>
<%
							} 
						}
						if(order_status.equals("RG")){
%>
							 <td class='<%=classval%>' width="0%" style="background:#33CC00"><!-- display:inline changed from display:none for Bru-HIMS-CRF-352 [IN:038516] -->
							<input type="checkbox" name="registeredPres<%=i%>" id="registeredPres<%=i%>" value="E" disabled title='<fmt:message key="ePH.RegisteredPrescription.label" bundle="${ph_labels}"/>' checked> 
							<input type="checkbox" name="prescriptionSelect<%=i%>" id="prescriptionSelect<%=i%>" value="E" style="display:none">
							</td>
<%
						}
						else{
%>							
							<td  class='<%=classval%>' width="0%" style="display"><!-- display:inline changed from display:none for Bru-HIMS-CRF-352 [IN:038516] Ends -->
							<input type="checkbox" name="prescriptionSelect<%=i%>" id="prescriptionSelect<%=i%>" value="E" <%=enableDisable%> <%=checkedUnchecked%> onClick="storePrescriptionDetails('ONCLICK')">
<%	
							//}
							checkedUnchecked="";
							enableDisable="";
%>
							</td>
<%
						}
%>	
						<input type="hidden" name="order_line_num<%=i%>" id="order_line_num<%=i%>" value="<%=order_line_num%>" >				
					</tr>
<% 
					if(i==0){
%>
						<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>" >
<%  
					}
%>
					<script>
							storePrescriptionDetails( 'ONLOAD','<%=order_id%>');
					</script>
<%  
					i++;
				}
%>
			</table>
<% 
			putObjectInBean(bean_id,bean,request); 
			putObjectInBean(param_bean_id,param_bean,request);
%>
			<input type="hidden" name="total_no_of_pres" id="total_no_of_pres" value="<%=i%>" >
			<input type="hidden" name="calledfrom" id="calledfrom" value="<%=calledfrom%>" >
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>" >
			<input type="hidden" name="displayGrossAmtYn" id="displayGrossAmtYn" value="<%=displayGrossAmtYn%>" ><!-- added for ML-BRU-CRF-0469 -->
<%
			if(billing_interface_yn.equals("Y")){
%>
				<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=encounter_id%>" >
				<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=patient_class%>" >
				<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sys_date%>">
				<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>" >
				<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
				<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
				<!--  added for ML-BRU-CRF-0469 start -->
				<%if(displayGrossAmtYn){%>
				<input type="hidden" name="tot_gross_amount" id="tot_gross_amount" value="<%=tot_gross_amount%>">
				<%}%>
				<!--  added for ML-BRU-CRF-0469 end -->
<%
			}
%>
		</form>
<%  
		if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")){
			// String total_payable	            = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalChargeAmount.label","ph_labels");
			// String patient_payable	            = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TotalPayableAmount.label","ph_labels");
			 DecimalFormat dfTest               = new DecimalFormat(decimalFormatString);
			 tot_gross_charge_amount_str        = dfTest.format(tot_gross_charge_amount);
			 tot_groos_pat_payable_str          = dfTest.format(tot_groos_pat_payable);
			 //added for ML-BRU-CRF-0469 start
			 if(displayGrossAmtYn){
			 tot_gross_amount_str               = dfTest.format(tot_gross_amount);
			 }
			//added for ML-BRU-CRF-0469 end
			 
%>
			<script>
				parent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href='../../ePH/jsp/RegPrescriptionsButtonsFooter.jsp?enableDisable='+'<%=enableDisable%>'+"&total_payable="+'<%=tot_gross_charge_amount_str%>'+"&patient_payable="+'<%=tot_groos_pat_payable_str%>'+"&total_gross_amount="+'<%=tot_gross_amount_str%>';<!--Removed displayData for//Added for ML-BRU-SCF-1199 [IN:045703]-end--><!-- added for ML-BRU-CRF-0469 +"&total_gross_amount="+'tot_gross_amount_str'-->
			</script>
<% 
		}
		else if(decimalFormatString.equals("")&&billing_interface_yn.equals("Y")){
%>
			<script>
				parent.parent.document.reg_prescriptions_footer_details.reg_prescriptions_footer_details2.location.href='../../ePH/jsp/RegPrescriptionsButtonsFooter.jsp?enableDisable='+'<%=enableDisable%>'+"&total_payable="+'<%=tot_gross_charge_amount_str%>'+"&total_gross_amount="+'<%=tot_gross_amount_str%>'+"&patient_payable="+''<!--Removed displayData for //Added for ML-BRU-SCF-1199 [IN:045703]-end--><!-- added for ML-BRU-CRF-0469 +"&total_gross_amount="+'tot_gross_amount_str'-->
			</script>
<% 
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
</html>


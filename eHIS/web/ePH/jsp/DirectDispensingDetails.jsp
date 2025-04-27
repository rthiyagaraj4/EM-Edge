<!DOCTYPE html>
 <%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  %>
 
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script> 
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String dir_bean_id				= "DirectDispensingBean" ;
	String dir_bean_name			= "ePH.DirectDispensingBean";
	String facility_id				= (String) session.getValue("facility_id");
	DirectDispensingBean dir_bean	= (DirectDispensingBean)getBeanObject( dir_bean_id,dir_bean_name,request) ;

	String  billing_interface_yn	=  dir_bean.checkforbillinginterface();
	String patient_class			=   dir_bean.getPatientClass();

    if(billing_interface_yn.equals("Y")){
	    dir_bean.getTokenSeries(patient_class); //// patient_class added for SRR20056-SCF-7639 ICN027720
	}

	String allocatedd_yn			= "N";
	String drug_desc				= "";
	String tot_alloc_qty			= "";
	String bms_qty					= "";
	String ord_qty					= "";
	String dosage_dtl				= "";
	String qty_value				= "";
	String qty_desc					= "";
	String classvalue				= "";
	String durn_value				= "";	
	String or_durn_desc				= "";
	String freq_desc				= "";
	String stock_uom				= "";
	String srl_no					= "";
	String drug_code				= "";
	String pat_reqd					= "";
	String pat_coun_reqd_yn			= "";
	//bl interface starts
    String item_code				=	"";
	String disp_delivery_chk_box_val=   "Y";
	String disp_del_chk_box_style   =   "";
	String disp_del_chk_box_checked =   "checked";     
    String patient_id				=	dir_bean.getPatientID();
	String encounter_id				=	dir_bean.getEncounterID();
	String sal_trn_type				=	"";
	String sysdate					=   dir_bean.getBLSysDates();
	String dispense_location_code   =   dir_bean.getDispLocnCode();
	String store_code			    =   dir_bean.getStoreCode(dispense_location_code);

	if(encounter_id==null||encounter_id.equals(""))
		patient_class= "XT";
	if(patient_class.equals("IP"))
		sal_trn_type="I";
	else if (patient_class.equals("DC"))
		sal_trn_type="D";	
	else if(patient_class.equals("OP"))
		sal_trn_type="O";
	else if( patient_class.equals("EM"))
		sal_trn_type="E";	
	else
		sal_trn_type="R";
	boolean displayGrossAmtYn = dir_bean.isSiteSpecific("PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
  //ends here
  boolean approval_no_flag = dir_bean.isSiteSpecific("PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117  
		  String approval_no_app_for_patient_class = "N";
			if(approval_no_flag){
			   approval_no_app_for_patient_class = dir_bean.getApprovalNoApplicableForPatientClass(patient_class);
			}
%>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="DirectDispDispensingDetails" id="DirectDispDispensingDetails" >
			<table cellpadding="0" cellspacing="0" width="100%"  border="1" >
				<tr>  
					 <td class= "COLUMNHEADER" width="35%" style="font-size:9"><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/> </td>
					 <td class= "COLUMNHEADER" width="8%" style="font-size:9"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>  </td>
					 <td class= "COLUMNHEADER" width="8%" style="font-size:9"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/> </td>
					 <td class= "COLUMNHEADER" width="8%" style="font-size:9"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/> </td>
<%
					if(billing_interface_yn.equals("Y")){
%>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>	
						<%if(displayGrossAmtYn){ %>	
						<td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>	
						<%} %>
						<td class= "COLUMNHEADER" width="7%" style="font-size:9">&nbsp;</td>

<%
					}
%>
					 <td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/></td>
					<%if(approval_no_flag){ //added for AAKH-CRF-0117 
					%>
					<td class= "COLUMNHEADER" width="15%" style="font-size:9"> <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;</td>
					<%} %>
					 <td class= "COLUMNHEADER" width="17%" style="font-size:9"><fmt:message key="ePH.CompleteOrder.label" bundle="${ph_labels}"/></td> 
				</tr>
 <%
				ArrayList presDetails		=  (ArrayList) dir_bean.getpresDetails();
				HashMap drugDetails			=  null;
				ArrayList batchDetails		=  null;
				HashMap sel_batches         =  null;
				ArrayList stock_detail      =  null;
				HashMap batcn_data			=  null;	
				String disp_qty			    =  "";
				String  batch_id		    =  "";
				String	expiry_date		    =  "";
				String	trade_id		    =  "";
				String	bin_locn_code	    =  "";
				StringBuffer batch_str      =  new StringBuffer();
				String excl_incl_ind		=  "";				
				String bl_incl_excl_override_reason_code =	"";	
				String bl_incl_excl_override_reason_desc =	"";	
				String decimalFormatString				 =  "";
				String gross_charge_amount_str			 =  "";
				String groos_pat_payable_str			 =  "";	
				String gross_charge_amount_payable_str="";//added for ML-BRU-CRF-0469
				String tot_gross_charge_amount_str		 =  "";
				String tot_groos_pat_payable_str		 =  "";
				String tot_gross_charge_amount_payable_str="";//added for ML-BRU-CRF-0469
				float tot_gross_charge_amount		     =  0;
				float tot_groos_pat_payable		         =  0;
				float tot_gross_charge_amount_payable		     =  0;//added for ML-BRU-CRF-0469
				//variable uom
				String IssueByUOM			             =  dir_bean.getIssueByUOMBy();
				StringBuffer issue_qty_dtl			     =  new StringBuffer();
				HashMap issue_uom_qty_hm		         =  new HashMap();
				HashMap  detail							 =  new HashMap();
				double base_to_disp_uom_equl              =  0;
				double Actual_Equl_Value                  =  0;
				String alloc_qty						 =  "";
				String issue_uom_desc					 =	"";
				String issue_uom						 =  "";
				String billable_item_yn					 =  "";
				if(IssueByUOM.equals("I")){
					 issue_uom_qty_hm					 =  dir_bean.getIssueUomQty();
				}//ends here
				float gross_charge_amount =0;
				float groos_pat_payable   =0;
				float gross_charge_amount_payable=0;//added for ML-BRU-CRF-0469
				StringBuffer gross_charge_display_str  = new StringBuffer();
				StringBuffer pat_charge_display_str    = new StringBuffer();
				StringBuffer gross_charge_payable_display_str    = new StringBuffer();//added forml-bru-crf-0469
						
				HashMap chareg_det=null;
				String start_date = "";//MMS-DM-CRF-0126.2
				String end_date = "";//MMS-DM-CRF-0126.2
				String approval_no = ""; //AAKH-CRF-0117
				int recCount					=	1; //AAKH-CRF-0117

				if(presDetails!=null && presDetails.size()>0 ){
					for(int i=0;i<presDetails.size();i++){
						drugDetails			= (HashMap)presDetails.get(i);
						drug_desc			= "";
						allocatedd_yn		= "";
						tot_alloc_qty		= "";
						bms_qty				= "";
						ord_qty				= "";
						qty_value			= "";
						qty_desc			= "";
						durn_value			= "";	
						or_durn_desc		= "";	
						freq_desc			= "";
						drug_code			= "";
						pat_coun_reqd_yn	= ""; 
						batch_str           = new StringBuffer();
						gross_charge_amount_str ="";
						groos_pat_payable_str   ="";
						gross_charge_amount_payable_str="";//added for ML-BRU-CRF-0469
						start_date = "";//MMS-DM-CRF-0126.2
						end_date   = "";//MMS-DM-CRF-0126.2
						approval_no = ""; //AAKH-CRF-0117
System.err.println("DirectDispensingDetails.jsp====166===drugDetails=======>"+drugDetails);
						allocatedd_yn		= (String)drugDetails.get("ALLOCATEDD_YN");
						if(allocatedd_yn!=null && allocatedd_yn.equals("Y")){
							item_code			= (String)drugDetails.get("ITEM_CODE");      
							drug_desc		= (String)drugDetails.get("DRUG_DESC");
							drug_code		= (String)drugDetails.get("DRUG_CODE");
							pat_coun_reqd_yn	= (String)drugDetails.get("PT_COUN_REQD_YN");
							ord_qty			= (String)drugDetails.get("ORD_QTY");
							bms_qty			= (String)drugDetails.get("ALLOC_BMS_QTY");
							bms_qty			= (new Float(Float.parseFloat(bms_qty)).intValue())+"";
							tot_alloc_qty	= (String)drugDetails.get("TOT_ALLOC_QTY");
							qty_value        = (String)drugDetails.get("QTY_VALUE") ;
							qty_desc         = (String)drugDetails.get("QTY_DESC") ;
							freq_desc	    = (String)drugDetails.get("FREQ_DESC") ;
							durn_value	    = (String)drugDetails.get("DURN_VALUE") ;
							or_durn_desc	    = (String)drugDetails.get("OR_DURN_DESC") ;
							stock_uom	    = (String)drugDetails.get("STOCK_UOM") ;
							srl_no			= (String)drugDetails.get("SRL_NO") ;	
							billable_item_yn	= (String)drugDetails.get("BILLABLE_ITEM_YN") ;	
							qty_desc=CommonBean.checkForNull(dir_bean.getUomDisplay(facility_id,qty_desc));
							dosage_dtl	    = qty_value+qty_desc+"   "+freq_desc+" "+durn_value+" "+or_durn_desc;
							//added for AAKH-CRF-0117 - start
							approval_no     = (String)drugDetails.get("approval_no");
							System.err.println("approval_no=====204==>"+approval_no);
							if(approval_no==null)
								approval_no = "";
							//added for AAKH-CRF-0117 - end
							if ( i% 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
						   
							detail            =   new HashMap();	
							
							if( issue_uom_qty_hm.containsKey(drug_code+srl_no)){						 
								 detail =  (HashMap)issue_uom_qty_hm.get(drug_code+srl_no);
							}
							Double base_to_def_uom_equl =0.0;
							if(detail.containsKey(drug_code+srl_no+"_conv_factor")){
								 base_to_def_uom_equl  = Double.parseDouble((String)detail.get(drug_code+srl_no+"_base_to_def_uom_equl")) ;
								 issue_uom_desc        = (String)detail.get(drug_code+srl_no+"_uom_desc") ;
								 issue_uom			   = (String)detail.get(drug_code+srl_no+"_uom") ;
								 base_to_disp_uom_equl = Double.parseDouble((String)detail.get(drug_code+srl_no+"_base_to_disp_uom_equl")) ; 
								 Actual_Equl_Value	   = Float.parseFloat((String)detail.get(drug_code+srl_no+"_base_to_disp_uom_equl_Actu")) ; 
							}
							else{
								issue_uom_desc       = "";
								issue_uom			 = "";
								Actual_Equl_Value	 = 1;
							}

							if(base_to_def_uom_equl!=base_to_disp_uom_equl)
								alloc_qty = ( new Float(Math.ceil((Double.parseDouble(tot_alloc_qty)*(base_to_disp_uom_equl))/Actual_Equl_Value)).intValue())+"";
							else
								alloc_qty = tot_alloc_qty+"";

							if(IssueByUOM.equals("I")){
								issue_qty_dtl	= new StringBuffer();
								issue_qty_dtl	= issue_qty_dtl.append("( ").append(alloc_qty).append("  ").append(issue_uom_desc).append(" )");
							}
  %>
							<tr>
								<td align="left"  class="<%=classvalue%>"nowrap style="font-size:9" title="<%=dosage_dtl%>">	<label style="cursor:pointer;"  id="drug_desc<%=i%>"><%=drug_desc%>&nbsp;</label>&nbsp;
<%
								if(pat_coun_reqd_yn.equals("Y")){
									pat_reqd="Checked";	
%>
									<img src="../../ePH/images/Patientcounsel.gif" valign="center"  ></img>
									<input type=checkbox name=pat_reqd_<%=i%> <%=pat_reqd%> value='C' onclick="CheckPatReqd(this)">
<%
								}
								else{
%>
									<input type="hidden" name="pat_reqd_<%=i%>" id="pat_reqd_<%=i%>"    value="N">
<%
								}
%>
								</td>               
								<!-- <td align="right"  class="<%=classvalue%>" nowrap style="font-size:9"title='<fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>'   >&nbsp;<%=ord_qty%>(<%=stock_uom%>)&nbsp;</td> commented on 8/10/09 -->
								<td align="right"  class="<%=classvalue%>" nowrap style="font-size:9"title='<fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>'   >&nbsp;<%=ord_qty%>(<%=CommonBean.checkForNull(dir_bean.getUomDisplay(facility_id,stock_uom))%>)&nbsp;</td> 
								<td align="right"  class="<%=classvalue%>"nowrap style="font-size:8" title='<fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/>' >&nbsp;<b><%=tot_alloc_qty%>&nbsp;<%=CommonBean.checkForNull(dir_bean.getUomDisplay(facility_id,stock_uom))%></b><br><label id="issue_uom_lbl<%=i%>" class="label" style="font-size:9" ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label></td>
								<td align="right"  class="<%=classvalue%>"nowrap style="font-size:9"  title='<fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/>'>&nbsp;<%=bms_qty%>&nbsp;</td>
<%								boolean approval_flag = false; //AAKH-CRF-0117
								String disabled = "disabled";//AAKH-CRF-0117
								if(billing_interface_yn.equals("Y")){
									if(billable_item_yn.equals("Y")){
										excl_incl_ind						   = "";
										bl_incl_excl_override_reason_code     = "";
										bl_incl_excl_override_reason_desc	   = "";
										start_date		= (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE"); //MMS-DM-CRF-0126.2
										end_date		= (String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");//MMS-DM-CRF-0126.2

										if(drugDetails.containsKey("EXCL_INCL_IND")){
											excl_incl_ind						   =     (String)drugDetails.get("EXCL_INCL_IND");
											bl_incl_excl_override_reason_code    =     (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE");
											bl_incl_excl_override_reason_desc    =     (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
										}
										batchDetails			= (ArrayList)drugDetails.get("BATCH_DETAILS");//BATCH_DETAILS
										sel_batches             = (HashMap)drugDetails.get("SEL_BATCHES");//batch wise qty
										for (int j=0;j<batchDetails.size() ; j++){
											if(batchDetails.get(j) != null){
												stock_detail	    =  null;  
												stock_detail	= (ArrayList) batchDetails.get(j);
											}					
											for(int m=0; m<stock_detail.size(); m++ ) {
												batcn_data		=    null;
												batcn_data		=	(HashMap)stock_detail.get(m);
												if(sel_batches.get((m+""))!=null){
													disp_qty		= (String)sel_batches.get((m+""));
													batch_id		= (String)batcn_data.get("BATCH_ID");
													expiry_date		= (String)batcn_data.get("EXPIRY_DATE");
													trade_id		= (String)batcn_data.get("TRADE_ID");
													bin_locn_code	= (String)batcn_data.get("BIN_LOCATION_CODE");
													//trade;batchid,exp_date,bin_loc,req_qty 
													batch_str.append(trade_id).append(";").append(batch_id).append(";").append(expiry_date).append(";").append(bin_locn_code).append(";").append(disp_qty).append(";");
												}
											}
										}
										gross_charge_amount =0;
										groos_pat_payable   =0;
										gross_charge_amount_payable=0; //added for ML-BRU-CRF-0469
										disp_delivery_chk_box_val="Y";
										disp_del_chk_box_style ="";	
										disp_del_chk_box_checked="checked";
										gross_charge_display_str  = new StringBuffer();
										pat_charge_display_str    = new StringBuffer();
										gross_charge_payable_display_str  = new StringBuffer();//added for ml-bru-crf-0469
										chareg_det=(HashMap)dir_bean.callItemChargeDtls(patient_id,encounter_id,sal_trn_type,item_code,Integer.parseInt(tot_alloc_qty), batch_str.toString(),sysdate,store_code,excl_incl_ind,bl_incl_excl_override_reason_code,"",start_date,end_date);////MMS-DM-CRF-0126.2
System.err.println("DirectDispensingDetails.jsp=====chareg_det==ds======286===>"+chareg_det+"==start_date=>"+start_date+"==end_date==>"+end_date);
										if(chareg_det.get("error_msg").equals("")){
											decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
											/*if(!chareg_det.get("grosschargeamt").equals("null")){
												gross_charge_amount     = Float.parseFloat((String)chareg_det.get("grosschargeamt"));
												DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
												gross_charge_amount_str = dfTest.format(gross_charge_amount);
											}*/ //Commented for ML-BRU-SCF-0368 [IN:034748]
											//added for ML-BRU-CR4F-0469 start
													if(!chareg_det.get("grosschargeamt").equals("null")){
												gross_charge_amount_payable     = Float.parseFloat((String)chareg_det.get("grosschargeamt"));
												DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
												gross_charge_amount_payable_str = dfTest.format(gross_charge_amount_payable);
											}
											//added for ML-BRU-CR4F-0469 end
											if(!chareg_det.get("netchargeamt").equals("null")){ //if block added for ML-BRU-SCF-0368 [IN:034748]
												gross_charge_amount     = Float.parseFloat((String)chareg_det.get("netchargeamt"));
												DecimalFormat dfTest    = new DecimalFormat(decimalFormatString);
												gross_charge_amount_str = dfTest.format(gross_charge_amount);
											}
											if(!chareg_det.get("patnetamt").equals("null")){
												 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
												 
											}
											/*if(groos_pat_payable==0){
											   if(!chareg_det.get("netchargeamt").equals("null")){
												 groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
											   }
										   }*/

											DecimalFormat dfTest     = new DecimalFormat(decimalFormatString);
											groos_pat_payable_str    = dfTest.format(groos_pat_payable);

											tot_gross_charge_amount  =  tot_gross_charge_amount+gross_charge_amount;
											tot_groos_pat_payable    =  tot_groos_pat_payable+groos_pat_payable;
											tot_gross_charge_amount_payable  =  tot_gross_charge_amount_payable+gross_charge_amount_payable;//added for ML-BRU-CRF-0469
											if(tot_gross_charge_amount !=tot_groos_pat_payable){ //AAKH-CRF-0117
												approval_flag =true;
											}
											drugDetails.put("GROSS_CHARGE_AMOUNT",gross_charge_amount_str);
											drugDetails.put("GROOS_PAT_PAYABLE",groos_pat_payable_str);
											drugDetails.put("GROSS_CHARGE_AMOUNT_PAYABLE",gross_charge_amount_payable_str);//added for ml-bru-crf-0469
											drugDetails.put("DECIMALFORMATSTRING",decimalFormatString);

											gross_charge_display_str.append("<label style='font-size:9;color:black'>").append(gross_charge_amount_str).append("</label>");
											pat_charge_display_str.append("<label style='font-size:9;color:black'>").append(groos_pat_payable_str).append("</label>");
											if(displayGrossAmtYn)gross_charge_payable_display_str.append("<label style='font-size:9;color:black'>").append(gross_charge_amount_payable_str).append("</label>");//added for ml-bru-crf-0469

											if(!drugDetails.containsKey("EXCL_INCL_IND"))
											excl_incl_ind = (String)chareg_det.get("excl_incl_ind");

										}
										else{
											gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
											if(displayGrossAmtYn)gross_charge_payable_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");//added for ml-bru-crf-0469
											disp_delivery_chk_box_val	= "N";
											disp_del_chk_box_style		= "disabled";
											disp_del_chk_box_checked	= "";
										}						 
%>
										<td class="<%=classvalue%>"align="center" id='gross_charge_amount_<%=srl_no%>'>&nbsp;<%=gross_charge_display_str.toString()%></td>
										<td class="<%=classvalue%>" align="center"id='pat_charge_amount_<%=srl_no%>'>&nbsp;<%=pat_charge_display_str.toString()%></td>
									<%if(displayGrossAmtYn){ %>	
										<td class="<%=classvalue%>"align="center" id='gross_charge_amount_payable_<%=srl_no%>'>&nbsp;<%=gross_charge_payable_display_str.toString()%></td><!-- added for ml-bru-crf-0469 -->
										<%} %>
										<input type="hidden" name="override_allowed_yn_<%=srl_no%>" id="override_allowed_yn_<%=srl_no%>"   value="<%=(String)chareg_det.get("override_allowed_yn")%>">
										<input type="hidden" name="excl_incl_ind_<%=srl_no%>" id="excl_incl_ind_<%=srl_no%>"         value="<%=excl_incl_ind%>">
										<input type="hidden" name="excl_incl_ind_default_<%=srl_no%>" id="excl_incl_ind_default_<%=srl_no%>" value="<%=(String)chareg_det.get("excl_incl_ind")%>">
										<input type="hidden" name="approval_reqd_yn_<%=srl_no%>" id="approval_reqd_yn_<%=srl_no%>"      value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
										<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=srl_no%>" id="bl_incl_excl_override_reason_desc_<%=srl_no%>" value="<%=bl_incl_excl_override_reason_desc%>">
										<input type="hidden" name="bl_incl_excl_override_reason_code_<%=srl_no%>" id="bl_incl_excl_override_reason_code_<%=srl_no%>" value="<%=bl_incl_excl_override_reason_code%>">
										<input type="hidden" name="tot_alloc_qty_<%=srl_no%>" id="tot_alloc_qty_<%=srl_no%>"         value="<%=tot_alloc_qty%>">
										<input type="hidden" name="batch_str_<%=srl_no%>" id="batch_str_<%=srl_no%>"             value="<%=batch_str.toString()%>"> 
<%
										if(chareg_det.get("error_msg").equals("")){
%>
											<td class="<%=classvalue%>" ><a href="javascript:callIncludeExclude('<%=srl_no%>','<%=drug_code%>');" id="include_exclude"  style="font-size:9;"><fmt:message key="Common.Include.label" bundle="${common_labels}"/>?</a></td>  
<%
										}
										else{
%>
											<td class="<%=classvalue%>" >&nbsp;</td>
<%
										}
									}
									else{
%>
										<td class="<%=classvalue%>"align="center" id='gross_charge_amount_<%=srl_no%>'>&nbsp;</td>
										<td class="<%=classvalue%>" align="center"id='pat_charge_amount_<%=srl_no%>'>&nbsp;</td>
									<%if(displayGrossAmtYn){ %>	
										<td class="<%=classvalue%>" align="center"id='gross_charge_amount_payable_<%=srl_no%>'>&nbsp;</td><!-- added for ml-bru-crf-0469 -->
										<%} %>
										<input type="hidden" name="override_allowed_yn_<%=srl_no%>" id="override_allowed_yn_<%=srl_no%>"   value="">
										<input type="hidden" name="excl_incl_ind_<%=srl_no%>" id="excl_incl_ind_<%=srl_no%>"         value="">
										<input type="hidden" name="excl_incl_ind_default_<%=srl_no%>" id="excl_incl_ind_default_<%=srl_no%>" value="">
										<input type="hidden" name="approval_reqd_yn_<%=srl_no%>" id="approval_reqd_yn_<%=srl_no%>"      value="">
										<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=srl_no%>" id="bl_incl_excl_override_reason_desc_<%=srl_no%>" value="">
										<input type="hidden" name="bl_incl_excl_override_reason_code_<%=srl_no%>" id="bl_incl_excl_override_reason_code_<%=srl_no%>" value="">
										<input type="hidden" name="tot_alloc_qty_<%=srl_no%>" id="tot_alloc_qty_<%=srl_no%>"         value="">
										<input type="hidden" name="batch_str_<%=srl_no%>" id="batch_str_<%=srl_no%>"             value="">        
										<td class="<%=classvalue%>" >&nbsp;</td>
<%    
									}
								}
 %>
								<td align="left"  class="<%=classvalue%>"nowrap style="font-size:9">
									<label style="cursor:pointer;color:blue;font-size:9;" id="edit_remarks<%=i%>" onClick="callEditDetails(this,'<%=drug_code%>','<%=i%>','D',<%=srl_no%>);"><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/> </label><br><label style="cursor:pointer;color:blue;font-size:9;" id="fill_remarks<%=i%>" onClick="callFillingRemarks(this,'<%=drug_code%>','<%=i%>','D',<%=srl_no%>);"> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/> </label>&nbsp;&nbsp;<input type='checkbox'  name='del_detail_<%=i%>' id='del_detail_<%=i%>' <%=disp_del_chk_box_checked%>  value='<%=disp_delivery_chk_box_val%>' onClick='updateValue(this)' <%=disp_del_chk_box_style%>>
								</td>		
<%					if(approval_flag){//AAKH-CRF-0117
						disabled = "";
 					}else{ //AAKH-CRF-0117
						approval_no = "";
					}
				    if(approval_no_flag) { //added for AAKH-CRF-0117
%>
                     <td class="<%=classvalue%>" nowrap>  <!-- -nowrap added for AAKH-CRF-0117-->  
					 <input type="text"  maxlength="20" onchange="getApprovalNumForDrug(this,'<%=drug_code%>','<%=srl_no%>')"   name="approval_no_<%=recCount%>" value="<%=approval_no%>" <%=disabled%> onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'D',<%=recCount%>)" /><!-- modified for AAKH-CRF-0117--> 
					 <% //added for AAKH-CRF-0117
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("") && !encounter_id.equals("")){ %>
						<img id="imgForWithin" src="../../eCommon/images/mandatory.gif" align="center" style="visibility:visible"></img>	
						<%}
						
					%>
					 </td>
<%
					}
%>
								<td align="center"  class="<%=classvalue%>"nowrap ><input type="checkbox"  name="Complete_Order_<%=i%>" id="Complete_Order_<%=i%>" value='N'  onClick='updateValue(this)' <%=disp_del_chk_box_style%>>
								</td> 
							</tr>
							<input type="hidden" name="disp_srl_no_<%=i%>" id="disp_srl_no_<%=i%>"  value="<%=srl_no%>"> 
							<input type="hidden" name="issue_uom_<%=i%>" id="issue_uom_<%=i%>"  value="<%=issue_uom%>"> 
							<input type="hidden" name="issue_qty_<%=i%>" id="issue_qty_<%=i%>"  value="<%=alloc_qty%>"> 
<%							 recCount++;//AAKH-CRF-0117
						}
					}
					if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")){
						DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
						tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
						tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
						tot_gross_charge_amount_payable_str = dfTest.format(tot_gross_charge_amount_payable);//added for ml-bru-crf-0469
					}
				}
				
%>				<input type="hidden" name="tot_rec" id="tot_rec"  value="<%=recCount%>"><!-- AAKH-CRF-0117-->
				<input type="hidden" name="bean_id" id="bean_id"                 value="<%=dir_bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name"               value="<%=dir_bean_name%>">
				<input type="hidden" name="approval_no_flag" id="approval_no_flag"               value="<%=approval_no_flag%>"><!-- AAKH-CRF-0117-->
				<input type="hidden" name="approval_no_app_for_patient_class" id="approval_no_app_for_patient_class" value="<%=approval_no_app_for_patient_class%>"><!-- AAKH-CRF-0117-->
<%
				if(billing_interface_yn.equals("Y")){
%>
					<input type="hidden" name="patient_id" id="patient_id"   value="<%=patient_id%>">
					<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
					<input type="hidden" name="sal_trn_type" id="sal_trn_type" value="<%=sal_trn_type%>">
					<input type="hidden" name="sysdate" id="sysdate"      value="<%=sysdate%>">
					<input type="hidden" name="store_code" id="store_code"   value="<%=store_code%>">
<%
				}
 %>
			</table>
		</form>
<%
		if(billing_interface_yn.equals("Y")){
%>
			<script>
			if(<%=displayGrossAmtYn%>){
				calldispbuttonsframes('<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','<%=tot_gross_charge_amount_payable_str%>');//tot_gross_charge_amount_payable_str added for ml-bru-crf-0469
			}
			else{ // esle Added for MMS-MD-SCF-0091 - Start
				calldispbuttonsframes('<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>');
			} // esle Added for MMS-MD-SCF-0091 - End
				</script>
<%
		}
%>

		<% putObjectInBean(dir_bean_id,dir_bean,request); %>
	</body>
</html>


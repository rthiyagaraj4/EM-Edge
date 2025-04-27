<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" ePH.*, ePH.Common.*,eST.*,eST.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="Directdispensingallocateform" id="Directdispensingallocateform">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">	
<%
			String mode                     = request.getParameter("mode") ; 
			String facility_id					= (String) session.getValue("facility_id"); //added for AAKH-SCF-0189 [IN:054663]
			try{
			if(mode.equals("modify")||mode.equals("taper")){
				String dir_bean_id				= "DirectDispensingBean" ;
				String dir_bean_name			= "ePH.DirectDispensingBean";
				DirectDispensingBean dir_bean	= (DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request);

				/** Stock Bean Integration -Starts ***/ 
				String	bean_id_2		=	"StUtilities" ;
				String	bean_name_2		=	"eST.Common.StUtilities";
				StUtilities bean_2		=	null; 
				try { 
					bean_2 = (StUtilities)getBeanObject(bean_id_2,bean_name_2,request);
					bean_2.setLanguageId(locale);
				}
				catch (Exception exception) {
					out.println(exception);
					exception.printStackTrace();
				}
				String	bean_id_3			=	"batchSearchBean" ;
				String	bean_name_3			=	"eST.BatchSearchBean";

				BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject(bean_id_3,bean_name_3,request);
				bean_3.setLanguageId(locale);
				/** Stock Bean Integration -End ***/ 
				String class_name			=	"";
				String batch_id				=	"";
				String expiry_date			=	"";
				String issue_qty			=	"";
				String item_drug_code		=	"";
				String trade_name			=	"";
				String manufacturer_name	=	"";
				String bin_location			=	"";
				String trade_id				=	"";
				String bin_locn_code		=	"";
				String qty_value		    =   "";
				int rec_no					=   0;
				double tot_qty_1			=   0;
				String uom_code				=  "", content_in_pres_base_uom="";
				String select_status		=  "";
				String order_qty			=  "";
				String sch_size				=  "1";
				String split_dose_yn        =  "";	
				String drug_code            =  ""; 
				String srl_No				=  "";
				String pres_base_uom		=  "";
				String conv_factor          =  "";
				String item_code			=  "";
				String diff_qty             =  "0";	
				String min_end_date			=  "";	
				String pack_size			=  "";
				String calc_qty				=  "";
				String alloc_qty			=  "";
				String tot_qty				=  "";
				String fract_dose			=  "";	
				String act_strength_value	=  "";
				String trade_code			=	"";
				HashMap drugDetails			=  null;
				HashMap drug_detail_1		=  null;		
				HashMap	stock				=  new HashMap();
				ArrayList	stock_detail	=  new ArrayList();
				ArrayList st_detail	        =  null;
				HashMap alloc_batch_qty_details =new HashMap();
				ArrayList alloc_batch_details =null;
				String extdrugCode			=  request.getParameter("drug_code") ;
				String srlNo				=  request.getParameter("srl_no") ;
				String dosage_type			=  request.getParameter("dosage_type") ;
				String qty_desc             =  request.getParameter("qty_desc");
				String durn_value			=  request.getParameter("durn_value") ;
				String end_date             =  request.getParameter("end_date")==null?"":request.getParameter("end_date") ;
				String called_from          =  request.getParameter("called_from") ;
				split_dose_yn       =  request.getParameter("split_dose_yn_val") ;
				String orig_qty_value       =  request.getParameter("qty_value") ;
				String called_when          =  request.getParameter("called_when"); 
				String flag					=  request.getParameter("flag"); 
				String repeat_val			=  request.getParameter("repeat_val"); 
				String freq_nature			=  request.getParameter("freq_nature"); 
				String interval_value		=  request.getParameter("interval_value"); 
				String dispense_location_code  = dir_bean.getDispLocnCode();
				String store_code			   = dir_bean.getStoreCode(dispense_location_code);
				String physical_inv_item_yn ="";
				String stock_uom					=	"";
				String base_to_disp_uom_equl_val	=	"1";
				String base_to_def_uom_equl_val		=	"1";
				String stk_unit_code				=	"";
				String stk_unit_desc				=	"";
				String stk_equval_value				=	"";
				String act_stk_equval_value			=	"";
				String issue_uom_desc				=	"";
				String repeat_durn_type				=	"D";

				boolean variable_flag               =  false;
				int  issue_qty_val					= 0;
				int  issue_qty_val_1				= 0;
				double  variable_conv_factor			= 0;
				double base_to_disp_uom_equl           = 0;
				double base_to_def_uom_equl            = 0;
				StringBuffer issue_qty_dtl			= new StringBuffer();
				String IssueByUOM			        =  dir_bean.getIssueByUOMBy();
				String base_to_orig_def_uom_equl_val ="1"; // initialized to "1" for ICN 30879
				double Actual_Equl_Value =1;
				String barcode_2d_applicable_yn =dir_bean.get2DBarcodeApplicable();//Addef for MMS-DM-CRF-0174.5

				int op_dispperiod			=  dir_bean.getopdispperiod(store_code);
				//Added for difect 13744  To show Tappered drug, Prescribed Quantity
				ArrayList schedule;
				/*if(mode.equals("taper")){
						String tsrlNO=Integer.parseInt(srlNo)+1+"";
						schedule			=  (ArrayList)dir_bean.getScheduleFrequencyStr(extdrugCode+tsrlNO,"0");
				//out.println("==tsrlNO=="+tsrlNO);
				}else{*/
				schedule			=  (ArrayList)dir_bean.getScheduleFrequencyStr(extdrugCode+srlNo,"0");
				//}
				boolean split_chk			=  dir_bean.checkSplit(schedule);
				String dflt_issue_uom		=  "";
				String orig_dflt_issue_uom   =  "";
				String base_uom              =  "";
				String display_list			=  "";	
				String uom_desc				= "";//AAKH-SCF-0338
				ArrayList  stk_units			=  null;
				HashMap issue_uom_qty_hm		=  null;
				HashMap IssueUOMAndBaseUOM	=  null;
				HashMap  detail        = null;
				HashMap issue_uom_qty = null;
				ArrayList presDetails		=  (ArrayList) dir_bean.getpresDetails();
				if(presDetails!=null && presDetails.size()>0 ){
					for(int i=0;i<presDetails.size();i++){
						drugDetails					= (HashMap)presDetails.get(i);
						drug_code					= (String)drugDetails.get("DRUG_CODE");
						srl_No						= (String)drugDetails.get("SRL_NO");
						String tap_srl_no			= "";
						if(mode.equals("taper")){
							srl_No	=Integer.parseInt(srl_No)+1+"";
						}
						pres_base_uom				= (String)drugDetails.get("PRES_BASE_UOM");

						if(dosage_type.equals("Q")){
							conv_factor = (String) dir_bean.getConvFactor(qty_desc,pres_base_uom);						
						}
						if((extdrugCode.equals(drug_code) && srlNo.equals(srl_No)) || (mode.equals("taper")&& extdrugCode.equals(drug_code) && srlNo.equals(srl_No))){
							physical_inv_item_yn =(String)drugDetails.get("PHY_INV_ITEM_YN");
							if( physical_inv_item_yn.equals("N")){
								item_code				= (String)drugDetails.get("ITEM_CODE");
								pack_size				= (String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");
								fract_dose				= (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
								act_strength_value	    = (String)drugDetails.get("ACT_STRENGTH_VALUE");
								trade_code				= (String)drugDetails.get("TRADE_CODE");
								stock_uom				= (String)drugDetails.get("STOCK_UOM") ;//drug master dispensing uom
								//freq_nature		    = ((String)drugDetails.get("FREQ_NATURE"))==null?"":(String)drugDetails.get("FREQ_NATURE");
								repeat_durn_type		= (String)drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String)drugDetails.get("REPEAT_DURN_TYPE") ;
								uom_code			=	(String)drugDetails.get("STOCK_UOM");//added for AAKH-SCF-0189 [IN:054663]
								content_in_pres_base_uom	= drugDetails.get("CONTENT_IN_PRES_BASE_UOM")==null?"1":(String)drugDetails.get("CONTENT_IN_PRES_BASE_UOM");//added for AAKH-SCF-0189 [IN:054663]
		/*=============================variable uom=======================================================================================*/
								dflt_issue_uom		=  "";
								orig_dflt_issue_uom   =  "";
								base_uom              =  "";
								display_list			=  "";	

								stk_units			=  dir_bean.loadStockUnit(drug_code);
								
								issue_uom_qty_hm		=  dir_bean.getIssueUomQty();
								IssueUOMAndBaseUOM	=  null;
								detail = null;
								if(issue_uom_qty_hm.size()>0){	
									if(issue_uom_qty_hm.containsKey(drug_code+srl_No)){
										detail  = (HashMap) issue_uom_qty_hm.get(drug_code+srl_No);
									}
									if(detail!= null && detail.containsKey(drug_code+srl_No+"_uom")){
										dflt_issue_uom = (String)detail.get(drug_code+srl_No+"_uom");
									}
								}

								IssueUOMAndBaseUOM			 =	(HashMap)dir_bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
								if(dflt_issue_uom.equals("")){
									dflt_issue_uom	  =  (String)((IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM") == null ) ? "" : IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM") );
									detail            =   new HashMap();
									detail.put(drug_code+srl_No+"_uom",dflt_issue_uom);
									dir_bean.setIssueUomQty( drug_code+srl_No,detail);
								}
								orig_dflt_issue_uom		 =	(String)((IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM") == null ) ? "" :IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM"));
								base_uom					 =	(String)((IssueUOMAndBaseUOM.get("BASE_UOM") == null) ? "": IssueUOMAndBaseUOM.get("BASE_UOM"));
								if(base_uom.equals(uom_code))//if block and else condition added for AAKH-SCF-0226 [IN:058002]
									base_to_disp_uom_equl = 1;
								else
									base_to_disp_uom_equl       =	dir_bean.getEqulValue ( drug_code, base_uom, uom_code);//stock_uom --uom_code for AAKH-SCF-0189 [IN:054663]
								if(base_uom.equals(dflt_issue_uom)) //if block and else condition added for AAKH-SCF-0226 [IN:058002]
									base_to_disp_uom_equl = 1;
								else
									base_to_def_uom_equl	     =  dir_bean.getEqulValue ( drug_code, base_uom, dflt_issue_uom);
								if(base_uom.equals(dflt_issue_uom) && base_to_def_uom_equl==0)
									base_to_def_uom_equl= 1;
								/*if(base_uom.equals(stock_uom))//Added for ICN 30879 -start //commented for AAKH-SCF-0189 [IN:054663]
									base_to_disp_uom_equl =1;
								if(base_uom.equals(dflt_issue_uom))
									base_to_def_uom_equl = 1;//Added for ICN 30879 -End*/
								Actual_Equl_Value           = dir_bean.getActualEqulValue(drug_code, base_uom, dflt_issue_uom);
								if(Actual_Equl_Value==0)
									Actual_Equl_Value =1;
								if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl!=0){
									variable_flag =true;
								}
								if(IssueByUOM.equals("D")){
									display_list= "display:none";
								}
/*=============================variable ends here====================================================================================*/

								//added for AAKH-SCF-0338 - start
									if(stk_units!=null && stk_units.size()>0){
										if(!stk_units.contains(orig_dflt_issue_uom)){
											uom_desc = dir_bean.getUOMDesc(orig_dflt_issue_uom);
											stk_units.add(orig_dflt_issue_uom);
											stk_units.add(uom_desc);
											stk_units.add("1");
											stk_units.add("1");
										}
									}
								//added for AAKH-SCF-0338 - end
								if(!mode.equals("taper")){
									if(drugDetails.containsKey("SEL_BATCHES")){
										if(!called_when.equals("ONCLICK")){
											alloc_batch_qty_details     =  (HashMap)drugDetails.get("SEL_BATCHES") ;
											alloc_batch_details         =  (ArrayList)drugDetails.get("BATCH_DETAILS") ;
										}
										else{
										   drugDetails.put("SEL_BATCHES",new HashMap());
										}
									}
								}
								float    tot_qty_value    =0; 
								if(dosage_type.equals("S")||dosage_type.equals("Q")){
									if(schedule.size() > 0 && (split_dose_yn.equals("N"))) {
										//HashMap detail	=	(HashMap)schedule.get(0);
										ArrayList dose_list		= (ArrayList)schedule.get(4);
										if(fract_dose.equals("N")){
											if(dose_list.size()>0){
												qty_value		=	(String)dose_list.get(0);
												if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1";
											}
											else{
												if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
												qty_value="1";
											}
										}
										else{
											if(dosage_type.equals("S")){
												 if(dose_list.size()>0){
													qty_value		=	(String)dose_list.get(0);
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														qty_value="1";
												 }
												 else{
													 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														 qty_value="1";
												 }
												qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
											}
											else if(dosage_type.equals("Q")){
												if(dose_list.size()>0){
													qty_value		=	(String)dose_list.get(0);
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1.0f";
												}
												else{
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
													qty_value="1.0f";
												}
												qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
											 }  
										 }
										sch_size	 =	""+dose_list.size();	
									}
									else {
										if(split_dose_yn.equals("Y")){
											if(fract_dose.equals("N")){
												if(schedule.size() > 0){
													ArrayList dose_list		= (ArrayList)schedule.get(4);
													String final_qty ="";
													//for(int n=0; n<schedule.size(); n++) {
													for(int n=0; n<dose_list.size(); n++) {
														sch_size		=	"1";
														//HashMap  detail	=  (HashMap)schedule.get(n);
														final_qty=(String)dose_list.get(n);
														if(!(final_qty.equals("")||final_qty.equals("0")||final_qty==null))
															tot_qty_value =  tot_qty_value+Float.parseFloat((String)dose_list.get(n));
														else
															tot_qty_value =  tot_qty_value+1.0f;													 
													}
												}
											}
											else{
												if(schedule.size() > 0){
													ArrayList dose_list		= (ArrayList)schedule.get(4);
													for(int n=0; n<dose_list.size(); n++) {
														sch_size		=	"1";
														//HashMap  detail	=  (HashMap)schedule.get(n);

														if(dosage_type.equals("S")){
															qty_value		=	(String)dose_list.get(n);
															if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
																qty_value="1";
															qty_value        =   (Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(act_strength_value)))+"";
													   }
													   else if(dosage_type.equals("Q")){
															qty_value		=	(String)dose_list.get(n);
															if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
																qty_value="1";
															qty_value		=   (Math.ceil(Float.parseFloat(qty_value)))+"";
													   }  
													   tot_qty_value    =  tot_qty_value+Float.parseFloat(qty_value);
													}
												}
											}
											qty_value       =tot_qty_value+"";
										}
										else{
											if(freq_nature.equals("O")){
												if(fract_dose.equals("Y")&&dosage_type.equals("S")){
												     qty_value        =   (Math.ceil(Float.parseFloat(orig_qty_value)/Float.parseFloat(act_strength_value)))+"";
												}
											}
										}
									}
								}
								//order_qty calculation
								 if(qty_value.equals("")){
									 qty_value=orig_qty_value;
								 }
								 if(flag.equals("Y")){
									sch_size=repeat_val;

								 }
								order_qty =	dir_bean.getOrderQty(drugDetails,qty_value,sch_size,durn_value,dosage_type,conv_factor,split_chk,interval_value,freq_nature,"Allocation");
								// order qty calculation ends here
								order_qty		= new Float(order_qty).intValue()+"";
								tot_qty			= order_qty;
								/*==code for validating OP_DISP_PERIOD in ph_disp_locn Table it will default qty for no of days defined in dispenselocation===========*/
								//out.println(op_dispperiod);
							   int tmp_durn_val=0;
							   if(repeat_durn_type.equals("H"))
								   tmp_durn_val=new Float(Math.ceil(Integer.parseInt(durn_value)/24)).intValue();
							   else if(repeat_durn_type.equals("M"))
								   tmp_durn_val=new Float(Math.ceil(Integer.parseInt(durn_value)/(24*60))).intValue();
							   else if(repeat_durn_type.equals("D"))
								   tmp_durn_val=Integer.parseInt(durn_value)*1;
							   else if(repeat_durn_type.equals("W"))
								   tmp_durn_val=Integer.parseInt(durn_value)*7;
							   else if(repeat_durn_type.equals("L"))
								   tmp_durn_val=Integer.parseInt(durn_value)*30;
							   else if(repeat_durn_type.equals("Y"))
								   tmp_durn_val=Integer.parseInt(durn_value)*365;						   						   
							   if(op_dispperiod!=0){
								   if(tmp_durn_val>op_dispperiod){						
									  order_qty  = (Float.parseFloat(order_qty)/ Float.parseFloat(tmp_durn_val+""))+"" ;
									  order_qty  = ( new Float(Math.ceil(Float.parseFloat(order_qty)* Float.parseFloat(op_dispperiod+""))).intValue())+"" ;	
								   }
							   } 
%>
								<tr>
									<td class="label" style='<%=display_list%>' colspan=8><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/>&nbsp
									   <select onChange="issueUOM(this,'<%=drug_code%>','<%=srl_No%>');" name="issue_uom_select">
<% 
										for(int k=0; k<stk_units.size(); k+=4) { 
											stk_unit_code			=	(String)stk_units.get(k);
											stk_unit_desc			=	(String)stk_units.get(k+1);
											stk_equval_value		=	(String)stk_units.get(k+2);
											act_stk_equval_value	=	(String)stk_units.get(k+3);

											if(stock_uom.equals(stk_unit_code)){
												base_to_disp_uom_equl_val = stk_equval_value;
											}
											if(orig_dflt_issue_uom.equals(stk_unit_code)){ 
												 base_to_orig_def_uom_equl_val =  stk_equval_value;
											}
											if(dflt_issue_uom.equals(stk_unit_code)){
												issue_uom_desc            =  stk_unit_desc;
												base_to_def_uom_equl_val  =  stk_equval_value;
%>
												<option value="<%=stk_unit_code%>_<%=stk_equval_value%>_<%=stk_unit_desc%>_<%=act_stk_equval_value%>" selected><%=stk_unit_desc%></option>
<%
											}
											else{
%>
												<option value="<%=stk_unit_code%>_<%=stk_equval_value%>_<%=stk_unit_desc%>_<%=act_stk_equval_value%>"><%=stk_unit_desc%></option>
<%
											}	
										}
%>
										</select>&nbsp;
									</td>
								</tr>
<%
								if(variable_flag){
									variable_conv_factor  = dir_bean.lcm( Double.parseDouble(base_to_orig_def_uom_equl_val), Double.parseDouble(base_to_def_uom_equl_val));
									variable_conv_factor  = dir_bean.lcm(variable_conv_factor,  base_to_disp_uom_equl);

									issue_uom_qty = dir_bean.getIssueUomQty();
									detail       = (HashMap)issue_uom_qty.get(drug_code+srl_No); 
									detail.put(drug_code+srl_No+"_conv_factor",variable_conv_factor+"");
									detail.put(drug_code+srl_No+"_uom_desc",issue_uom_desc);
									detail.put(drug_code+srl_No+"_base_to_orig_def_uom_equl",base_to_orig_def_uom_equl_val);
									detail.put(drug_code+srl_No+"_base_to_def_uom_equl",base_to_def_uom_equl_val);
									detail.put(drug_code+srl_No+"_base_to_disp_uom_equl",base_to_disp_uom_equl+"");
									detail.put(drug_code+srl_No+"_base_to_disp_uom_equl_Actu",Actual_Equl_Value+"");

									dir_bean.setIssueUomQty( drug_code+srl_No,detail);
									if(base_to_disp_uom_equl!=base_to_def_uom_equl){
										issue_qty_val_1		= new Float(Math.ceil(Integer.parseInt(order_qty)*base_to_disp_uom_equl)).intValue(); 
									}
									else{
										issue_qty_val_1 =Integer.parseInt(order_qty);
									}
									// issue_qty_val= new Float(Math.ceil(((Math.ceil(issue_qty_val_1/variable_conv_factor))*(variable_conv_factor))/base_to_def_uom_equl)).intValue();
									/*============================================================ variable UOM  ends here=============================================*/
									if(!locale.equals("en"))
										min_end_date		=	com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");
									//stock integration starts
									HashMap params		=	new HashMap();
									params.put("ITEM_CODE",item_code+"="+trade_code);
									params.put("STORE_CODE",store_code);

									params.put("TRN_QTY",issue_qty_val_1+"");
									params.put("INCLUDE_SUSPENDED","FALSE");
									params.put("INCLUDE_EXPIRED","FALSE");
									params.put("CUT_OFF_DATE",end_date);
									params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
									params.put("ALREADY_USED_QTY",diff_qty);
									params.put("MIN_EXP_DATE",min_end_date);	
									if(!dir_bean.getBarcode_id().equals("") && called_when.equals("ONLOAD"))  // MMS-DM-CRF-0112  - Start
										params.put("BARCODE_ID",dir_bean.getBarcode_id().trim());
									else
										dir_bean.setBarcode_id("");  // MMS-DM-CRF-0112  - End
									//System.err.println("params@@@directdispallocate.jsp==="+params);
									if(barcode_2d_applicable_yn.equals("Y") && !dir_bean.getBarcode_id().equals("")){//Added if condition  for MMS-DM-CRF-0174.5
										stock				=	bean_2.get2DBarcodeDetails(params);
									}else{
									    stock				=	bean_2.getBatches(params);
									}
									stock_detail		=	(ArrayList)stock.get("BATCH_DATA");
									st_detail	=	new ArrayList();
									if(called_from.equals("stock") && bean_3.getSelectedList()!=null) {
										st_detail.add(bean_3.getSelectedList());
									}
									else if(called_from.equals("allocate")&& alloc_batch_qty_details.size()==0){
										st_detail.add((ArrayList)stock.get("BATCH_DATA"));
									}
									else{
										st_detail          =  alloc_batch_details;
									} 
									calc_qty           = issue_qty_val_1+"";
									if(!mode.equals("taper")){
										drugDetails.put("BATCH_DETAILS",st_detail) ;
									}
									else{	
										dir_bean.setTaperBatchDetails(st_detail,drug_code+srl_No);
									}
								}
								else{
									st_detail	=	new ArrayList();
								}
							}
							else{
									st_detail	=	new ArrayList();
							}
						}
					}
				}
%>
				<tr>
					<td class= "COLUMNHEADER"  style="font-size:9" width="10%" ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/> </td>
					<td class= "COLUMNHEADER" style="font-size:9" width="13%"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td> 
					<td class= "COLUMNHEADER"  style="font-size:9" width="20%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  style="font-size:9" width="20%"><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER"  style="font-size:9" width="16%"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/> </td>
					<td class= "COLUMNHEADER"  style="font-size:9" width="12%"><fmt:message key="eST.AvailableQty.label" bundle="${st_labels}"/> </td>
					<td class= "COLUMNHEADER"  style="font-size:9" width="8%"nowrap><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/> </td>
					<td class= "COLUMNHEADER"  style="font-size:9" width="8%"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> </td>
				</tr>
<%
				for(int i=0; i<st_detail.size(); i++)	{
					batch_id			=	"";
					expiry_date			=	"";
					issue_qty			=	"";
					trade_id			=	"";
					bin_locn_code		=	"";	
					boolean from_drug_dtl_flag =false;
					if(st_detail.get(i) != null)
						stock_detail	=	(ArrayList) st_detail.get(i);
						for(int j=0; j<stock_detail.size(); j++ ) {	
							drug_detail_1		=	(HashMap)stock_detail.get(j);
							item_drug_code		=	(String)drug_detail_1.get("ITEM_CODE");	
							expiry_date			=	(String)drug_detail_1.get("EXPIRY_DATE");	
							batch_id			=	(String)drug_detail_1.get("BATCH_ID");	
							trade_id			=	(String)drug_detail_1.get("TRADE_ID");	
							trade_name			=	(String)drug_detail_1.get("TRADE_NAME");	
							manufacturer_name	=	(String)drug_detail_1.get("MANUFACTURER_NAME");	
							bin_locn_code		=	(String)drug_detail_1.get("BIN_LOCATION_CODE");
							bin_location		=	(String)drug_detail_1.get("BIN_DESC");	
							issue_qty			=	(String)drug_detail_1.get("AVAIL_QTY");	
							if((called_from.equals("allocate")&& alloc_batch_qty_details.size()==0)||(called_from.equals("stock"))){
								if(Double.parseDouble(issue_qty)<Double.parseDouble(calc_qty) ){									       
									alloc_qty   =issue_qty;
									calc_qty    =(Double.parseDouble(calc_qty)-Double.parseDouble(issue_qty))+"";	
								 }
								 else{									
									alloc_qty   =calc_qty;
									calc_qty    ="0";										   
								 }
							}
							else{  
								 if(alloc_batch_qty_details.containsKey(j+"")){
									 alloc_qty =(String) alloc_batch_qty_details.get(j+"");
									 from_drug_dtl_flag =true;
								 }
								 else{
									 continue;
								 }
							}
							select_status		=	"";
							tot_qty_1		   +=	Double.parseDouble(issue_qty);
							rec_no				=    j;	
							if(called_from.equals("stock") && expiry_date!=null){
								expiry_date=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale);
							}
							/*===========================================================variable uom============================================================*/
							int  disp_avail_qty  = 0;
							int  batch_alloc_qty = 0; 
							if(from_drug_dtl_flag){
								batch_alloc_qty = (int)Double.parseDouble(alloc_qty);
								//alloc_qty       = ( new Float(Math.ceil(((Float.parseFloat(alloc_qty)*base_to_disp_uom_equl)/base_to_def_uom_equl))).intValue())+"";
								if(base_to_disp_uom_equl!=base_to_def_uom_equl){
									alloc_qty       = ( new Float(Math.ceil(((Float.parseFloat(alloc_qty)*base_to_disp_uom_equl)/Actual_Equl_Value))).intValue())+"";
								}
							 }
							 else{
                                if(base_to_disp_uom_equl!=base_to_def_uom_equl){
									 batch_alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat(alloc_qty))/variable_conv_factor))*(variable_conv_factor))/base_to_disp_uom_equl)).intValue();
									//alloc_qty       = ( new Float(Math.ceil(((batch_alloc_qty*base_to_disp_uom_equl)/base_to_def_uom_equl))).intValue())+"";
									alloc_qty       = ( new Float(Math.ceil(((batch_alloc_qty*base_to_disp_uom_equl)/Actual_Equl_Value))).intValue())+"";
								}
								else{
									batch_alloc_qty =new Float(Float.parseFloat(alloc_qty)).intValue();
								}
							}
							disp_avail_qty = new Float(Math.ceil(Double.parseDouble(issue_qty)/base_to_disp_uom_equl)).intValue(); 
							issue_qty_dtl   =  new StringBuffer();
							if(IssueByUOM.equals("I")){ 
								issue_qty_dtl   =  issue_qty_dtl.append("(").append(alloc_qty).append(" ").append(issue_uom_desc).append(")");
							}
							int noOfDecimals=dir_bean.getNoOfDecimals();
							/*=====================================================variable uom ends here========================================================*/
%>
							<tr>
								<td  width="10%" class="<%=class_name%>"nowrap style="font-size:9">&nbsp;<%=expiry_date%></td>
								<td  width="13%" class="<%=class_name%>"nowrap style="font-size:9">&nbsp;<%=batch_id%></td> 
								<td width="20%" class="<%=class_name%>"nowrap style="font-size:9">&nbsp;<%=trade_name%></td>
								<td  width="20%" class="<%=class_name%>"nowrap style="font-size:9">&nbsp;<%=manufacturer_name%></td>
								<td  width="16%" class="<%=class_name%>"nowrap style="font-size:9">&nbsp;<%=bin_location%></td>
								<td  width="12%" class="<%=class_name%>"nowrap style="font-size:9">&nbsp;<%=dir_bean.retunFormatedInt(issue_qty,noOfDecimals)%></td>
								<td width="8%" class="<%=class_name%>"nowrap style="font-size:9">
									<input type="text" class="flat" size="4" value="<%=batch_alloc_qty%>" name="issue_qty_<%=rec_no%>" style="text-align:right" onKeyPress="return allowValidNumber(this,event,6,0);" onBlur="validateQty(this,'<%=rec_no%>');" maxlength="5"> 
									<label class="label" style='font-size:8'><b><%=dir_bean.getUomDisplay(facility_id,uom_code)%></b></label>
									<label id="issue_uom_lbl_<%=rec_no%>" name="issue_uom_lbl_<%=rec_no%>" class="label" style style='font-size:8' ><b><%=issue_qty_dtl.toString()%></b></label>
								</td>
								<td  width="8%" class="<%=class_name%>"nowrap style="font-size:9"><input type="checkbox"  name="select_<%=rec_no%>" id="select_<%=rec_no%>" <%=select_status%> onClick="validateCheck(this,'<%=rec_no%>')" checked></td> 
							</tr>
							<input type="hidden" name="item_code_<%=rec_no%>" id="item_code_<%=rec_no%>" value="<%=item_drug_code%>"> 
							<input type="hidden" name="expiry_date_<%=rec_no%>" id="expiry_date_<%=rec_no%>" value="<%=expiry_date%>">
							<input type="hidden" name="batch_id_<%=rec_no%>" id="batch_id_<%=rec_no%>" value="<%=batch_id%>">
							<input type="hidden" name="trade_id_<%=rec_no%>" id="trade_id_<%=rec_no%>" value="<%=trade_id%>">
							<input type="hidden" name="bin_locn_code_<%=rec_no%>" id="bin_locn_code_<%=rec_no%>" value="<%=bin_locn_code%>">
							<input type="hidden" name="alloc_qty_<%=rec_no%>" id="alloc_qty_<%=rec_no%>" value="<%=disp_avail_qty%>">
							<input type="hidden" name="issue_uom_<%=rec_no%>" id="issue_uom_<%=rec_no%>" value="<%=uom_code%>">
							<input type="hidden" name="issue_qty_old<%=rec_no%>" id="issue_qty_old<%=rec_no%>"  value="<%=batch_alloc_qty%>">
							<input type="hidden" name="issue_uom_qty<%=rec_no%>" id="issue_uom_qty<%=rec_no%>"  value="">
							<input type="hidden" name="issue_uom_uom<%=rec_no%>" id="issue_uom_uom<%=rec_no%>"  value="">
							<input type="hidden" name="issue_uom_desc<%=rec_no%>" id="issue_uom_desc<%=rec_no%>" value="">
							<input type="hidden" name="batch_avl_qty_<%=rec_no%>" id="batch_avl_qty_<%=rec_no%>" value="<%=issue_qty%>">
<%
						}
					}
%>
					<input type="hidden" name="tot_rec" id="tot_rec"  value="<%=rec_no%>">
					<input type="hidden" name="tot_qty" id="tot_qty"  value="<%=tot_qty%>">
					<input type="hidden" name="cal_tot_qty" id="cal_tot_qty"  value="<%=order_qty%>"><!-- qty after for period defined in dispense location -->
					<input type="hidden" name="base_to_disp_uom_equl_val" id="base_to_disp_uom_equl_val" value="<%=base_to_disp_uom_equl%>">
					<input type="hidden" name="base_to_def_uom_equl_val" id="base_to_def_uom_equl_val" value="<%=base_to_def_uom_equl%>">
					<input type="hidden" name="base_to_orig_def_uom_equl_val" id="base_to_orig_def_uom_equl_val" value="<%=base_to_orig_def_uom_equl_val%>">
					<input type="hidden" name="issuebyuom" id="issuebyuom" value="<%=IssueByUOM%>">
					<input type="hidden" name="BASE_UOM" id="BASE_UOM" value="<%=base_uom%>"><!-- added for AAKH-SCF-0189 [IN:054663]-->
<%
					if(tot_qty_1==0 ){
						if( physical_inv_item_yn.equals("N")){
							if(!variable_flag){
%>
								<script> 
									alert(getMessage("PH_ITEM_UOM_DEF_NOT_FOUND","PH"));
								</script>
<%
							}
							else{
%>
								<script>
									alert(getMessage("PH_DIRECT_DISPENCING_NO_STOCK","PH"));
								</script>
<%
							}    
						}
						else{
%>
							<script>
								 alert(getMessage("PH_DIRECT_DISPENCING_NO_STOCK","PH"));
							</script>	
<%
						}
%>
						<script>
							parent.parent.f_drug_detail.f_button_1.prescription_button.confirm.disabled=true;
						</script>
<%
					}
%>
					</table>	
				</form>
<%	
				putObjectInBean(dir_bean_id,dir_bean,request);
				putObjectInBean(bean_id_2,bean_2,request); 
				putObjectInBean(bean_id_3,bean_3,request);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	</body>
</html>


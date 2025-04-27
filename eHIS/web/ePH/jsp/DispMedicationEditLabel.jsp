<!DOCTYPE html>
<!-- /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
13/08/2019      IN070605		 Devindra           MMS-KH-CRF-0028  
10/08/2020     IN073523		    Shazana                                             PHIS-PH-Alpha - Exceed Dosage Limit Icon in Fill and Deliver Stage
14/08/2020	   IN73343         Shazana 												PHIS-PH-Alpha - Medical Supply, Special Characters issue in SIKARIN
17/05/2023	   IN43751		   Sushant Tambe		ML-BRU-SCF-2223
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>  
<html>
	<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Connection con			= null;  // Added for ML-MMOH-crf-1089 start
	    con				= ConnectionManager.getConnection(request);
	    // Added for ML-MMOH-CRF-1089 - End
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="DispMedicationEditLabel" id="DispMedicationEditLabel" action='DispMedicationValidation.jsp' method='post' target="dummyFrame">
<%
		try{
	
			String facility_id			=	(String) session.getValue("facility_id");
			String sShowButtons			=	request.getParameter("buttons")==null?"":" style='display:none' ";
			String drug_code			=	request.getParameter("drug_code");                                             
			String order_line_no		=	request.getParameter("order_line_no");                                         
			String order_id				=	request.getParameter("order_id");                                              
			String patientid			=	request.getParameter("patientid"); 
			String called_from          =   request.getParameter("called_from") == null?"":request.getParameter("called_from"); // called_from Added for BSP-SCF-0033
			if(patientid == null)
				patientid			    =	request.getParameter("patient_id");

			String order_date			=	request.getParameter("order_date");                                            
			String drug_name			=	request.getParameter("drug_name");	
			String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//Added here for ML-BRU-CRF-0473
			
			String from_editlabel_yn    ="N"; //Added from_editlabel_yn flag for the incident number 22383 on 29/june/2010 by Naveen S
			if(drug_name!=null)
				from_editlabel_yn="Y";

			String sShowLabels			=	request.getParameter("showLabels");                                          
			String alt_drug_flag1			=	request.getParameter("alt_drug_flag"); // added for ML-BRU-SCF-0179 [IN:032578]
			String pres_qty				=	request.getParameter("pres_qty");                                              
			String uom					=	request.getParameter("uom");                                                     
			String sCalledFrom			=	request.getParameter("CalledFrom") == null?"":request.getParameter("CalledFrom");
			String bean_id				=	"DispMedicationAllStages" ;
			String bean_name			=	"ePH.DispMedicationAllStages";

			String sDispBean			=	"DispMedicationBean" ;
			String sDispBeanName		=	"ePH.DispMedicationBean";

			boolean siteTpnStd = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
		  	boolean sitebmsApp=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BMS_REMAEKS_APP");// added for jd-crf-0221
			String sMode				=	request.getParameter("mode")== null?"":request.getParameter("mode");
			String func_mode			=	"editlabel";
			String dosage				= "";
			String caution_1			= "";
			String caution_2			= "";
			String special_1			= "";
			String special_2			= "";
			String patient_int			= "";
			String loc_caution_1		= "";
			String loc_caution_2		= "";
			String loc_special_1		= "";
			String loc_special_2		= "";
			String loc_patient_int		= "";
			String pres_rermark			= "";
			String sShowExpDate			= "";
			boolean bShowDrugCount		= false;
			String caution_id			= "";
			String special_id			= "";
			String no_of_prints         = "";//Code Added For RUT-CRF-0067 Start
			String allocQty             = "";
			String disableChk           = "N";//Code Added For RUT-CRF-0067 End
			String alt_drug_flag		= "N"; 
			String drug_desc			= "";
			String alt_drug_desc		= "";
			boolean allocQtyFlag = false; //-added forMO-GN-5434(BMS in print dailog when allocate qty is zero)
			String new_drug_indication="", drug_ind_display="";//Added for  ML-BRU-CRF-072[Inc:29938]
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			ArrayList alBMSReasons = bean.getBMSReasons(locale);//added for jd-crf-o221	
			String bmsReasonVisible = "hidden";//added for jd-crf-0221
			
			if(patientid!=null)
				bean.addPatient(patientid);//added for ML-BRU-SCF-1521.1 [IN:055331]
			DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( sDispBean, sDispBean, request);
			dispBean.setLanguageId(locale);

			//String patient_name			=   bean.getPatientName(patientid);Commented on 15/Nov/2010 for the incident num:24949===By Sandhya
			String patient_name			=   dispBean.getPatient_name(patientid,locale); //Calling from Dispmedication bean.
			String pres_by				=	request.getParameter("pres_by")==null?bean.getSPerformPractId():request.getParameter("pres_by"); 
			String pract_name			=	bean.getPractitionerName(pres_by);
			String customer_id = dispBean.getCustomerID();
			String hide_exp_date_pres_qty ="";
			String allow_edit_disp_label = dispBean.getAllowEditDispLabel(); //added for Bru-HIMS-CRF-414 [IN:045554] -start
			String callLangChange		=	request.getParameter("callLangChange")==null?"":request.getParameter("callLangChange"); 
			String editLabelDisp = "display:none", nonEditLabelDisp="display:inline", editLabelPreviewDisp="display:none";
			String strIncludeZeroQty    = dispBean.getStrIncludeZeroAllocQtyItems();//Added for ML-BRU-CRF-0473
			String strIncludeZeroQtyForIP    = dispBean.getStrIncludeZeroAllocQtyItemsForIP();//Added for ML-BRU-CRF-0473
			if(allow_edit_disp_label.equals("Y")){
				editLabelDisp = "display:inline";
				nonEditLabelDisp="display:none";
				hide_exp_date_pres_qty =" style='display:none' ";
			} //added for Bru-HIMS-CRF-414 [IN:045554]-end
			HashMap hmEditLabelValues	= new HashMap();
			ArrayList DispNoAndSrlNo    = new ArrayList(); // Added for TTMWM-SCF-0184 -Start
			String disp_srl_no          ="";
			String disp_no              = "";  // Added for TTMWM-SCF-0184 -End
			int iLabelPairs				= 0;
			String sDisableAll			= "";
			String sDispStage			= dispBean.getDispStage();

			if( sMode.equals("preview")){
				sDisableAll				= "Disabled";
				if(allow_edit_disp_label.equals("Y")){
					editLabelPreviewDisp = "display:inline";
					editLabelDisp = "display:none";
					nonEditLabelDisp="display:none";
				}
			}
			if(sCalledFrom.equals("PrintDialog") && !dispBean.getBEditDispLabelAfterDisp() && (sDispStage.equals("D") || sDispStage.equals("AS")))
				sDisableAll				= "Disabled";

			ArrayList alEditLabelPairs	= new ArrayList();
			if(customer_id.equals("SRR")){
				 hide_exp_date_pres_qty =" style='display:none' ";
			}String sEnableTab				=   "N";//Added for jd-crf-0221
			System.out.println("dispBean.getDispStage()"+dispBean.getDispStage());
			System.out.println("patient_class"+patient_class);

if((dispBean.getDispStage().equals("F") ||  dispBean.getDispStage().equals("A") || dispBean.getDispStage().equals("AS") || dispBean.getDispStage().equals("D") )  && patient_class.equals("O")){	//Added for jd-crf-0221
							sEnableTab			= "Y";
							
						}
			HashMap data = null;
			ArrayList disp_nos = bean.getDispNos();//Code added For RUT-CRF-0067 Alloc quantity -ICN [IN:029605]
			ArrayList exp = null;
			ArrayList	 values	 = null;
			String allow_label_zero_copy=dispBean.getAllow_Label_Zero_Copy()==null?"N":dispBean.getAllow_Label_Zero_Copy();//Added for ML-BRU-SCF-1122 [IN:044833]
			HashMap hmAllocBmsCheck	= dispBean.getHmAllocBmsChk() == null?new HashMap():dispBean.getHmAllocBmsChk();
			boolean bKeepWindow		= false;
			boolean zeroQtyFlag = true ; // add for KAUH-SCF-001
			ArrayList alDispQtyVal = new ArrayList();
			String dispNosOrder , tempDispNos, tmpOrdId, ordId, exp_date, sHeight="0";
			//Code added For RUT-CRF-0067 Alloc quantity Start -ICN [IN:029605] 
			ArrayList orderIdList = new ArrayList();
			if(order_id != null){
				if(alt_drug_flag1.equals("Y")){ // added if condition for ML-BRU-SCF-0179 [IN:032578]
					alEditLabelPairs = bean.getAlEditLabelPairValues();
				}
				else{
					hmEditLabelValues.put("order_id",order_id);
					hmEditLabelValues.put("pres_drug_code",drug_code);
					hmEditLabelValues.put("drug_code",drug_code);
					hmEditLabelValues.put("order_line_no",order_line_no);
					hmEditLabelValues.put("ord_date_time",order_date);
					hmEditLabelValues.put("drug_name_1",drug_name);
					hmEditLabelValues.put("pres_qty",pres_qty);
					hmEditLabelValues.put("uom",uom);
					alEditLabelPairs.add(hmEditLabelValues);
					alEditLabelPairs = bean.getAlEditLabelPairValues();
				}
			}
			else{
				alEditLabelPairs = bean.getAlEditLabelPairValues();
			}
			if(alEditLabelPairs!=null && alEditLabelPairs.size()>0)
				bShowDrugCount	 = true;
			if(bShowDrugCount){
				sHeight = "500px";
				if(!sShowButtons.equals("")){
					sHeight = "350px";
				}
			}
			for(int g=0;g<alEditLabelPairs.size();g++){
				hmEditLabelValues = (HashMap)alEditLabelPairs.get(g);
				order_id = (String) hmEditLabelValues.get("order_id");
				orderIdList.add(order_id);
			}		
			if(disp_nos!=null){
				for(int q=0;q<disp_nos.size();q++){
					ordId= bean.getOrderIdForDisp((String)disp_nos.get(q),sDispStage);
					for(int h=0;h<orderIdList.size();h++){
						if(((String)orderIdList.get(h)).equals(ordId)){
							tmpOrdId = ordId+"-"+disp_nos.get(q);
							orderIdList.set(h,tmpOrdId);
						}
					}
				}
			}
			if(!allow_edit_disp_label.equals("Y") ){
%>
				<div style='<%=nonEditLabelDisp%>' id='nonEditableLabel'>
					<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
<%	
					if(!sShowButtons.equals("")){
%>
						<tr>
							<td class= "COLUMNHEADER" width="100%" align="left"><font style='font-size:12;'><B><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></B></font></td>
						</tr>
<%
					}
%>
					</table>
					<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
						<tr>
							<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
						</tr>
						<tr>
							<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
								<tr>
									<td class="label" colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td class="label" width='15%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>   :</td>
									<td class="label" width='20%'><b><%=patientid%></b></td>
									<td class="label" width='15%'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> </td>
									<td class="label" width='50%'><b><%=patient_name%></b></td>
								</tr>
								<tr>
<%
								if(order_date!=null){
%>
									<td class="label" width='15%'><fmt:message key="ePH.PrescDate.label" bundle="${ph_labels}"/> :</td>
									<td class="label" width='20%'><b><%=com.ehis.util.DateUtils.convertDate(order_date,"DMYHM","en",locale)%></b></td>
<%
								}
								else{
%>
									<td class="label" width='15%' colspan = 2></td>
<%
								}
%>
								<td class="label" width='15%'><fmt:message key="ePH.PrescBy.label" bundle="${ph_labels}"/> </td>
								<td class="label" width='50%'><b><%=pract_name%></b></td>
							</tr>
							<tr>
								<td class="label" colspan="4">&nbsp;</td>
							</tr>
						</table>
					</tr>
				</table>	
				<div style="width:100%; overflow:auto;height:<%=sHeight%>;">
<%                String bms_remarks_code="";//added for jd-crf-0221
                 ArrayList alBMSdtl =null;//added for jd-crf-0221
				//Code added For RUT-CRF-0067 Alloc quantity End -ICN [IN:029605] 
				for(iLabelPairs=0;iLabelPairs<alEditLabelPairs.size();iLabelPairs++){
					zeroQtyFlag = false ; // add for KAUH-SCF-001
					hmEditLabelValues = (HashMap)alEditLabelPairs.get(iLabelPairs);
					drug_code			=	(String) hmEditLabelValues.get("drug_code");
					order_line_no		=	(String) hmEditLabelValues.get("order_line_no");
					order_id			=	(String) hmEditLabelValues.get("order_id");
					order_date			=	(String) hmEditLabelValues.get("ord_date_time");
					pres_by				=	(String) hmEditLabelValues.get("order_id");
					alt_drug_flag		= 	(String) hmEditLabelValues.get("alt_drug_flag")==null?"N":(String) hmEditLabelValues.get("alt_drug_flag");   // added for ML-BRU-SCF-0179 [IN:032578]
					drug_name			=	(String) hmEditLabelValues.get("drug_name_1");	
					//added for IN073523,IN073343
					
					
					if(order_id !=null && !order_id.equals(""))
						alBMSdtl= dispBean.getNextCollectionDate(order_id);
					
					if(alBMSdtl!=null && alBMSdtl.size()>0){
						
					if( dispBean.getDispStage().equals("D")){
						bms_remarks_code=dispBean.getBmsCode(order_id, order_line_no);
					}else{
						bms_remarks_code = (String)alBMSdtl.get(1)==null?"":(String)alBMSdtl.get(1);
					}
					}
							if(sDispStage.equalsIgnoreCase("F") || sDispStage.equalsIgnoreCase("A")){
						drug_name			=	(String) hmEditLabelValues.get("drug_desc");	
					}
					drug_desc = drug_name;		// added for ML-BRU-SCF-0179 [IN:032578]
				
					if(alt_drug_flag.equals("Y")){
						drug_name			=	(String) hmEditLabelValues.get("alt_drug_desc");
					//	drug_code			=   (String) hmEditLabelValues.get("alt_drug_code");

					}
					int ordLen = order_id.length();
					tempDispNos  = (String)orderIdList.get(iLabelPairs);
					if(tempDispNos.length()!= order_id.length()){
						tempDispNos =tempDispNos.substring(0,ordLen);
						if(tempDispNos.equals(order_id)){
							dispNosOrder = ((String)orderIdList.get(iLabelPairs)).substring(ordLen+1,((String)orderIdList.get(iLabelPairs)).length());
							allocQty = bean.getDispQuantity(dispNosOrder,order_id,order_line_no,sDispStage,alt_drug_flag,drug_code);//,alt_drug_flag,drug_code added for ML-BRU-SCF-1714
							//alt_drug_flag,drug_code added for ML-BRU-SCF-1714
						}
					}
					else{
						/* if(sCalledFrom.equals("PrintDialog")){ // commented for ML-BRU-SCF-1789 - Start
							allocQty="0";
						}
						else{
							allocQty="";
							disableChk="checked";
						} */ // commented for ML-BRU-SCF-1789 - End
						
					     ArrayList alt_drug_dt = new ArrayList(); // Added for ML-BRU-SCF-1789 - Start
					     int tot_alt_qty = 0;
					
					     if(!alt_drug_flag.equals("N")){ 
					   
						    alt_drug_dt = bean.getAlternateDrugDetail(patientid,order_id,order_line_no,drug_code);
					
						    for(int i=0; i<alt_drug_dt.size(); i+=10){
							  tot_alt_qty=tot_alt_qty+(int)Double.parseDouble((String)alt_drug_dt.get(i+3)); 
						    }	
						
						 allocQty = String.valueOf(tot_alt_qty);
					     }
					    else{
					    	if(!bean.getDrugQuantity(patientid,order_id,order_line_no).equals("")){
					    	  allocQty=String.valueOf((int)Double.parseDouble(bean.getDrugQuantity(patientid,order_id,order_line_no)));
					    	}
					    } 
					     if(!sCalledFrom.equals("PrintDialog")){
					    	 disableChk="checked";
					     } // Added for ML-BRU-SCF-1789 - End
					}
				if(allocQty == null || allocQty.equals("")) // added for BSP-SCF-0029 added on 09-sep-2015 for MMS-QF-SCF-0517 [IN:057438]
					allocQty = "0";//added for BSP-SCF-0029
				if(allocQty.equals("0")){	//if block added for ICN-31165
						allocQty = bean.getTPNDispQuantity(order_id,order_line_no,sDispStage);
						if(hmAllocBmsCheck.containsKey(order_id+order_line_no)){ // add this for EMR(MO-GN-5434 [IN:043669]) - START
							zeroQtyFlag = true; // add this for KAUH-SCF-001  
							continue;
						}	
						else
							bKeepWindow = true; // add this for EMR(MO-GN-5434 [IN:043669]) - END
					}
				if(Integer.parseInt(allocQty) > 0)//added for MO-GN-5434(BMS in print dailog when allocate qty is zero)
					allocQtyFlag = true;
					//if(!allocQty.equals("")){//commented if condition for Regression -> Alpha -> PH Edit Label window blank [IN:058748] 
						if(!sCalledFrom.equals("PrintDialog")){
							drug_ind_display = "display:none";
							if(from_editlabel_yn.equals("Y")){   //Added If condition  for the incident number 22383 on 29/june/2010 
	//if else condtion newly added for ML-BRU-SCF-0179 [IN:032578]
								if(alt_drug_flag.equals("Y")){
									drug_name	=	drug_name != null? java.net.URLDecoder.decode((String) hmEditLabelValues.get("alt_drug_desc"),"UTF-8"):""; 
								}
								else{
									System.out.println("before in else  "+(String) hmEditLabelValues.get("drug_name_1"));
//									System.out.println("after in else  "+java.net.URLDecoder.decode((String) hmEditLabelValues.get("drug_name_1"),"UTF-8"));
								
								// 	drug_name =	drug_name != null? java.net.URLDecoder.decode((String) hmEditLabelValues.get("drug_name_1"),"UTF-8"):""; /* this is commented because of %(space) special character not able to decode it BSP-SCF-0029*/ 
								drug_name =	drug_name != null?(String) hmEditLabelValues.get("drug_name_1"):""; //added for BSP-SCF-0029
								}
							}
							//drug_name			=	drug_name != null? (String) hmEditLabelValues.get("drug_name_1"):"";
						}
						else{
							drug_ind_display = "display:inline";
							if(alt_drug_flag.equals("Y")){
								drug_name	=	drug_name != null? (String) hmEditLabelValues.get("alt_drug_desc"):"";
							}
							else{
								drug_name	=	drug_name != null? (String) hmEditLabelValues.get("drug_name_1"):"";
							}
							drug_desc = drug_name; //Added for ML-BRU-SCF-2223
						}
						pres_qty	=	(String) hmEditLabelValues.get("pres_qty");
						uom			=   (String) hmEditLabelValues.get("uom");
						if(hmAllocBmsCheck.containsKey(order_id+order_line_no)){
							zeroQtyFlag = true; // add this for KAUH-SCF-001  
							sEnableTab			= "Y";//added for jd-crf-0221
							continue;
						}	
						else
							bKeepWindow = true;
						no_of_prints = bean.getPrintNoOfCopies(drug_code);//Code Added For RUT-CRF-0067 Start
						exp				=	bean.getDrugDetail(patientid,order_id,order_line_no);
						exp_date				=   "";
						if(!customer_id.equals("SRR")){
							if(exp.size() > 1){
								 exp_date				=	(String)exp.get(2);
								 if(exp_date!=null && !exp_date.equals(""))
									exp_date = com.ehis.util.DateUtils.convertDate(exp_date,"DMY","en",locale);
								 sShowExpDate			= "";
							}
							else
								 sShowExpDate			= "style=display:none";
						}
						else{
						   sShowExpDate			= "style=display:none";
						}

						values	=   bean.getEditLabelValues((order_id+"_"+drug_code+"_"+order_line_no).trim()); //drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
						if(values.size()==0){
							bean.getDispEditLabeldetails(order_id,order_line_no,drug_code);  //drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
							values			=  (ArrayList) bean.getEditLabelValues((order_id+"_"+drug_code+"_"+order_line_no).trim());//drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
						}
						HashMap labels				= (HashMap) bean.loadLabels();
						ArrayList	cautions		= (ArrayList) labels.get("caution");
						ArrayList	spl_instruction = (ArrayList) labels.get("spl_instruction");
						ArrayList	pres_remarks      = (ArrayList)  bean.getPrescriptionRemarks(drug_code);
						String pres_remark_code       =(String)bean.getPrescriptionRemark(order_id,order_line_no);
						if(alt_drug_flag.equals("Y")){
							new_drug_indication			= dispBean.getAlternateDrugIndication(drug_code)==null?"":dispBean.getAlternateDrugIndication(drug_code);
						}
						else{
							new_drug_indication			= dispBean.getDrugIndication(order_id,order_line_no);
						}
						//if(!new_drug_indication.equals(""))
							//new_drug_indication = java.net.URLDecoder.decode(new_drug_indication,"UTF-8"); 
						String loc_lang_from_tab      ="";
						caution_1			= "";
						loc_caution_1		= "";
						loc_lang_from_tab	= "";
						special_1			= "";
						loc_special_1		= "";
						patient_int			= "";
						loc_patient_int		= "";
						caution_id			= "";
						special_id			= "";

						if(values.size() > 0){
							//for(int i=0;i<values.size();i++){
								caution_1		= (String)values.get(0);
								//caution_2		= (String)values.get(1);
								special_1		= (String)values.get(2);
								//special_2		= (String)values.get(3);
								patient_int		= (String)values.get(4);
								loc_caution_1	= (String)values.get(5);
								//loc_caution_2	= (String)values.get(6);
								loc_special_1	= (String)values.get(7);
								//loc_special_2	= (String)values.get(8);
								loc_patient_int	= (String)values.get(9);
								pres_rermark    = (String)values.get(10);
								new_drug_indication =(String)values.get(11);//Added for  ML-BRU-CRF-072[Inc:29938] 
								loc_lang_from_tab = (String)labels.get("sec_lang_id");
							//}
						}
						else{
            // modified for ML-MMOH-CRF-1089 START
							ArrayList	instructions	=null;
						System.out.println("drug_code"+drug_code+"order_id"+order_id+"order_line_no"+order_line_no);
						
						if(dispBean.getWsType().equals("7")  && siteTpnStd){
							instructions =bean.getInstructionsSTD(drug_code,order_id,order_line_no);	
						}
						else {
							instructions=bean.getInstructions(drug_code,order_id,order_line_no);	
						}
            // modified for ML-MMOH-CRF-1089 END
							ArrayList caution = new ArrayList();
							ArrayList special = new ArrayList();
							ArrayList pat_int = new ArrayList();
							pres_rermark      =   pres_remark_code;
							if(instructions.size() > 0){
								caution	= (ArrayList)instructions.get(0);
								special	= (ArrayList)instructions.get(1);
								pat_int =   (ArrayList)instructions.get(2);
								if(caution.size()>0){	
									for(int i=0;i<caution.size();i+=3){
										caution_id		= bean.checkForNull((String)caution.get(i));	//added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										if(caution.get(i+2).equals("en")){
											 caution_1		= java.net.URLDecoder.decode((String)caution.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											 //caution_1		= bean.checkForNull((String)caution.get(i));	
										}
										else{
											 loc_caution_1	= java.net.URLDecoder.decode((String)caution.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											// loc_caution_1	= bean.checkForNull((String)caution.get(i+1));
											 loc_lang_from_tab =(String)caution.get(i+2);
										}
									}
								}

								if(special.size()>0){
									for(int i=0;i<special.size();i+=3){
										special_id		= bean.checkForNull((String)special.get(i)); //added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										if(special.get(i+2).equals("en")){
											special_1		= java.net.URLDecoder.decode((String)special.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//special_1		= bean.checkForNull((String)special.get(i+1));
										}
										else{
											loc_special_1	= java.net.URLDecoder.decode((String)special.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//loc_special_1	= bean.checkForNull((String)special.get(i+1));
											loc_lang_from_tab =(String)special.get(i+2);
									  }
								   }
								}
								if(pat_int.size()>0){
									for(int i=0;i<pat_int.size();i+=2){
										if(pat_int.get(i+1).equals("en")){
											patient_int		=java.net.URLDecoder.decode((String)pat_int.get(i),"UTF-8");  //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//patient_int		= bean.checkForNull((String)pat_int.get(i));
										}
										else{
											loc_patient_int	= java.net.URLDecoder.decode((String)pat_int.get(i),"UTF-8");  //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//loc_patient_int	= bean.checkForNull((String)pat_int.get(i));
											loc_lang_from_tab =(String)pat_int.get(i+1);
										}
									}
								}
							}
						}
						if(caution_id == null || caution_id.equals(""))
							caution_id = caution_1;
						if(special_id == null || special_id.equals(""))
							special_id = special_1;
%>

						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<%
							if(iLabelPairs > 0){
%>
								<tr>
									<td colspan="4">&nbsp;</td> 
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td> 
								</tr>
<%	
							}
							if(bShowDrugCount){
%>
								<tr>
									<td class= "COLUMNHEADER" colspan="4" align="center"><b><fmt:message key="Common.Drug.label" bundle="${common_labels}"/> # <%=  drug_desc%></b></td> 
								</tr>
<%
							}
%>
							<tr>
								<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
									<tr>
<% 
									if(customer_id.equals("SRR")){
%>
											<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></td>
<%
									}
									else{
%>
											<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="ePH.Drug/DosageDetail.label" bundle="${ph_labels}"/></td>
<%
									}
%>
									</tr>
									 <tr>
										<td class="label" colspan="3">&nbsp;</td>
									</tr>
									<tr> 
										<td class="label" width='20%'><b><%=drug_desc%></b></td><!-- changed drug_name to drug_desc for 73523 -->
										<td class="label" width='10%' <%=hide_exp_date_pres_qty%>><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>:&nbsp;</td>
<%                                      if(called_from.equals("DispMedication")) // if - else condition added for BSP-SCF-0033 -Start
                                        { 
%>
										<td class="label" width='10%'<%=hide_exp_date_pres_qty%>><b><%=allocQty%>&nbsp;&nbsp;<%=bean.getUomDisplay(facility_id,uom)%><b></td>
<%                                      }
										else{
%>
										<td class="label" width='10%'<%=hide_exp_date_pres_qty%>><b><%=pres_qty%>&nbsp;&nbsp;<%=bean.getUomDisplay(facility_id,uom)%><b></td>
<%
										} // if - else condition added for BSP-SCF-0033 -End
										if(Integer.parseInt(pres_qty) >Integer.parseInt(allocQty)){
											sEnableTab="Y";
											System.out.println("if sEnableTab"+sEnableTab);
										}
										else{
											
											
												sEnableTab="N";
											System.out.println("else sEnableTab"+sEnableTab);
										}
										
%>
	
<%                                    if(sitebmsApp && sEnableTab.equals("Y")){
										if(alBMSReasons!=null && alBMSReasons.size()>0)
											bmsReasonVisible = "visible";
										else
											bmsReasonVisible = "hidden";
%>
										<td class="label" >&nbsp;&nbsp;<fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></td>
										<td class="label">
											<select name="line_bms_remarks_code_<%=iLabelPairs%>" id="line_bms_remarks_code_<%=iLabelPairs%>" id="line_bms_remarks_code_id_<%=iLabelPairs%>" >
												<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
												if(alBMSReasons!=null && alBMSReasons.size()>0){
													for(int indx=0; indx<alBMSReasons.size(); indx+=2){
														System.out.println("bms_remarks_code"+bms_remarks_code);

																if(bms_remarks_code.equals((String)alBMSReasons.get(indx))){
%>
														<option value="<%=(String)alBMSReasons.get(indx)%>" selected><%=(String)alBMSReasons.get(indx+1)%></option>
<%
													}
													else{
%>
														<option value="<%=(String)alBMSReasons.get(indx)%>"><%=(String)alBMSReasons.get(indx+1)%></option>
<%
												}

														
													}
												}
%>
											</select>
										<td>
										<input type='hidden' name='curBMSReasonVisibility' id='curBMSReasonVisibility' value='<%=bmsReasonVisible%>'>
									
	
<%}
										//Code Added For RUT-CRF-0067 - Start
										if(sCalledFrom.equals("PrintDialog")){
											if(no_of_prints.equals("N")){
%>
												<td class="label" width='30%'  style='TEXT-ALIGN:right;' ><b><fmt:message key="ePH.NoOfPrints.label" bundle="${ph_labels}"/></b>&nbsp;
												&nbsp;								
												<input type="text" maxLength="3" size="3" name="noOfPrints<%=iLabelPairs%>" id="noOfPrints<%=iLabelPairs%>" value="1" > <!-- readonly removed for RUT req-->
												</td>
<%	
											}
											else { 
%>
												<td class="label" width='30%'  style='TEXT-ALIGN:right;'><b><fmt:message key="ePH.NoOfPrints.label" bundle="${ph_labels}"/></b>&nbsp;
												&nbsp;								
												<input type="text" id="noOfPrints<%=iLabelPairs%>" maxLength="3" size="2" name="noOfPrints<%=iLabelPairs%>" value="<%=allocQty%>" onKeyPress="return(ChkNumberInput(this,event,'0'))" onblur="validateNoOfPrints(this, '<%=allocQty%>','<%=allow_label_zero_copy%>');"  ><!--allow_label_zero_copy,Added for ML-BRU-SCF-1122 [IN:044833]-->
												</td>
<%
											}
										}
%> 
									<!-- Code Added For RUT-CRF-0067 - End-->
									</tr>
									<tr>
										<td class="label" colspan="2"><b><%=dosage%></b></td>
										<td class="label" width='20%' <%=sShowExpDate%> ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>:&nbsp;</td>
										<td class="label" width='20%'  <%=sShowExpDate%>><%=exp_date%></td>
									</tr>
									<tr>
										<td  class="label" colspan="4">&nbsp;</td>
									</tr>
								</table>
							</tr>
							<tr>
								<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
									<tr>
										<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="ePH.AuxillaryInstructions.label" bundle="${ph_labels}"/></td> 
									</tr>
									<tr>
										<td  class="label" colspan="4">&nbsp;</td>
									</tr>
									 <!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] Start-->
									<tr>
											<td class="label"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></td>
											<td colspan="3">&nbsp;<textarea name="remarks_new_<%=iLabelPairs%>"  size="150" maxlength="150"  rows='3' cols='50' readonly><%= bean.getDrugInstructions(order_id,order_line_no)%></textarea><!-- code 'getPrescriptionRemarks' is replaced by 'getDrugInstructions' for ML-BRU-SCF-0981  -->  
									</td>
									</tr>
									<tr>
										<td  class="label"><fmt:message key="ePH.CautionaryInstructions.label" bundle="${ph_labels}"/></td> 
										<td >&nbsp;<select name="caution_1_<%=iLabelPairs%>" id="caution_1_<%=iLabelPairs%>" <%=sDisableAll%> onchange="changeLocalInstr(this,'<%=loc_lang_from_tab%>','<%=iLabelPairs%>','C');" width="500" style="width: 500px"><!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
										<option value="">-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
										for(int i=0;i<cautions.size();i++){
											data = (HashMap)cautions.get(i);
											if(data!=null){
												//Changed the following variable label_text_1 to label_text_id for Incident No.28951
												if( (((String)data.get("label_text_id")).trim()).equals(caution_id) || (((String)data.get("label_text_1")).trim()).equals(caution_1))	{
												//if( (((String)data.get("label_text_id")).trim()).equals(caution_1) )	{//commented and the above line added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
%>
													<option value="<%=data.get("label_text_id")%>" selected><%=data.get("label_text_1")%></option>
<%
												}	
												else{ 
%>
													<option value="<%=data.get("label_text_id")%>"><%=data.get("label_text_1")%></option>
<%	
												}
											}
										}
%>
										</select></td>
										<td colspan="2" >
										&nbsp;&nbsp;
										</td>
									</tr>
									<tr>
									<td  class="label"><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/></td>
									<td>&nbsp;<select name="special_1_<%=iLabelPairs%>" id="special_1_<%=iLabelPairs%>" <%=sDisableAll%> onchange="changeLocalInstr(this,'<%=loc_lang_from_tab%>','<%=iLabelPairs%>','S');" width="500" style="width: 500px"> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
									<option value="">-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
									for(int i=0;i<spl_instruction.size();i++){
										data = (HashMap)spl_instruction.get(i);
										if(data!=null){
										//Changed the following variable label_text_1 to label_text_id for Incident No.28951
											//if( (((String)data.get("label_text_id")).trim()).equals(special_1) )	{ //commented and the bellow line added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											if( (((String)data.get("label_text_id")).trim()).equals(special_id) || (((String)data.get("label_text_1")).trim()).equals(special_1)){
%>
												<option value="<%=data.get("label_text_id")%>" selected><%=data.get("label_text_1")%></option>
<%
											} 
											else	{
%>
												<option value="<%=data.get("label_text_id")%>"><%=data.get("label_text_1")%></option>
<%
											}
										}
									}
%>
									</select>
									</td>
									<td  >&nbsp;
									</td>
									<td>&nbsp;&nbsp;</td>
								</tr>
								<tr>
									<td  class="label"><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>
									<td colspan="3">&nbsp;<textarea rows="3" cols="50" maxLength="150" <%=sDisableAll%> size="150"   name="patient_int_<%=iLabelPairs%>" onKeyPress="return checkMaxLimit(this,150);" onblur="validmaxlength(this);"><%=patient_int%></textarea><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
									<input type="button" name="Copy" id="Copy" value="Copy" onClick="CopyDrugRemarksValue(DispMedicationEditLabel,'<%=iLabelPairs%>');">	<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->				
									</td>
								</tr>
								<tr>
								<td class="label"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/></td>
								<td colspan="3">&nbsp;<select name="pres_remarks_<%=iLabelPairs%>" id="pres_remarks_<%=iLabelPairs%>" <%=sDisableAll%>>
								<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
								String remark_selected ="";
								for(int i=0;i<pres_remarks.size();i=i+3){   
									if(pres_rermark.equals("")&& values.size()==0){
										if(pres_remarks.get(i+2).equals("Y")){
											remark_selected="selected";
										}
										else{
											remark_selected="";
										}
									}
									else {
										if( (((String)pres_remarks.get(i)).trim()).equals(pres_rermark) ){
											remark_selected="selected";
										}
										else{
											remark_selected="";
										}
									}					
%>
									<option value="<%=pres_remarks.get(i)%>"  <%=remark_selected%> ><%=pres_remarks.get(i+1)%></option>
<%					
								}
%>
								</select>
								</td>
								<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
								<tr style='<%=drug_ind_display%>'>
								<td class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
								<td colspan="2" align="left">&nbsp;<textarea name="drug_ind_<%=iLabelPairs%>"value=""  maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"><%=new_drug_indication%></textarea>
								</td>
								</tr>
								<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->
							</tr>
							<tr>
								<td  class="label" colspan="4">&nbsp;</td>
							</tr>
							 <tr> 
								 <td class= "COLUMNHEADER" colspan="4" ><fmt:message key="ePH.AuxillaryInstructions.label" bundle="${ph_labels}"/></td>
							</tr>
							<tr>
								<td  class="label" colspan="4">&nbsp;</td>
							</tr>
							
							<tr>
								<td  class="label"><fmt:message key="ePH.CautionaryInstructions.label" bundle="${ph_labels}"/></td>
								<td  class="label" colspan="3">
<%
								if(! loc_lang_from_tab.equals("ar")){
%>
									<input type="text" maxLength="60" size="60" name="loc_caution_1_<%=iLabelPairs%>" id="loc_caution_1_<%=iLabelPairs%>" value="<%=loc_caution_1%>" <%=sDisableAll%>  >
<%
								}
								else{ 
%>	
									<textarea rows="3" cols="100" maxLength="200" name="loc_caution_1_<%=iLabelPairs%>" <%=sDisableAll%> style='text-align:right' class='OTHLANGTEXT'><%=loc_caution_1%></textarea><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->
<%
								}
%>
								 </td> 
							</tr>
							<tr>
								<td  class="label"><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/></td>
								<td  class="label" colspan="3">
<%
								if(! loc_lang_from_tab.equals("ar")){
%>
									<input type="text" maxLength="60" size="60" name="loc_special_1_<%=iLabelPairs%>" id="loc_special_1_<%=iLabelPairs%>" <%=sDisableAll%> value='<%=loc_special_1%>' >
<%
								}
								else{
%>
									<textarea rows="3" cols="100" maxLength="200" name="loc_special_1_<%=iLabelPairs%>" <%=sDisableAll%> style='text-align:right' class='OTHLANGTEXT'><%=loc_special_1%></textarea><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->
<%
								}
%>
									</td>
								</tr>
								<tr>
									<td  class="label"><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>
									<td  class="label"colspan="3">
<%
									if(! loc_lang_from_tab.equals("ar")){
%>
										<textarea rows="3" cols="50" maxLength="150" <%=sDisableAll%> size="150"   name="loc_patient_int_<%=iLabelPairs%>" onKeyPress="return checkMaxLimit(this,150);"onblur="validmaxlength(this);" ><%=loc_patient_int%></textarea>
										<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
										<input type="button" name="Copy" id="Copy" value="Copy" onClick="CopyDrugRemarksValue(DispMedicationEditLabel,'<%=iLabelPairs%>');">
										<tr style='<%=drug_ind_display%>'>
											<td class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
											<td colspan="2" align="left">&nbsp;<textarea name="loc_drug_ind_<%=iLabelPairs%>" readOnly maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"><%=new_drug_indication%></textarea>
										</td>
								</tr>
								<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->
<%
									}
									else{
%>
										<textarea rows="3" cols="50" maxLength="150" <%=sDisableAll%> size="150"   name="loc_patient_int_<%=iLabelPairs%>" onKeyPress="return checkMaxLimit(this,150);"  onblur="validmaxlength(this);" style='text-align:right' class='OTHLANGTEXT'><%=loc_patient_int%></textarea>
										<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
										<input type="button" name="Copy" id="Copy" value="Copy" onClick="CopyDrugRemarksValue(DispMedicationEditLabel,'<%=iLabelPairs%>');">
										<tr style='<%=drug_ind_display%>'>
											<td class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
											<td colspan="2" align="left">&nbsp;<textarea name="drug_ind_<%=iLabelPairs%>"  readOnly maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"><%=new_drug_indication%></textarea></td>
										</tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] End-->
<%
									}
                          DispNoAndSrlNo= bean.getDispNoAndSrlNo(drug_code, order_id, order_line_no, sDispStage); // Added for TTMWM-SCF-0184 - Start
                          if(DispNoAndSrlNo.size()>=2){
                        	  disp_no  = (String)DispNoAndSrlNo.get(0); 
                              disp_srl_no = (String)DispNoAndSrlNo.get(1); 
                          } // Added for TTMWM-SCF-0184 - End
%>
										</td>
									</tr>
								</table>
								</tr>
							</table>
<%
						//}//commented if condition for Regression -> Alpha -> PH Edit Label window blank [IN:058748] 
%>
						<input type="hidden" name="drug_code_<%=iLabelPairs%>" id="drug_code_<%=iLabelPairs%>" value="<%=drug_code%>">
						<input type="hidden" name="order_line_no_<%=iLabelPairs%>" id="order_line_no_<%=iLabelPairs%>" value="<%=order_line_no%>">
						<input type="hidden" name="order_id_<%=iLabelPairs%>" id="order_id_<%=iLabelPairs%>"  value="<%=order_id%>">
						<input type="hidden" name="disp_no_<%=iLabelPairs%>" id="disp_no_<%=iLabelPairs%>"  value="<%=disp_no%>"> <!-- Added for TTMWM-SCF-0184 -->
						<input type="hidden" name="disp_srl_no_<%=iLabelPairs%>" id="disp_srl_no_<%=iLabelPairs%>"  value="<%=disp_srl_no%>"> <!-- Added for TTMWM-SCF-0184 -->
						<input type="hidden" name="allocQty<%=iLabelPairs%>" id="allocQty<%=iLabelPairs%>"  value="<%=allocQty%>"><!--Code Added FOR RUT-CRF-0067-->
						<input type="hidden" name="allow_label_zero<%=iLabelPairs%>" id="allow_label_zero<%=iLabelPairs%>"  value="<%=allow_label_zero_copy%>"><!--Added for ML-BRU-SCF-1122 [IN:044833]-->
<%
					}
%>
					</div> <!-- drugs labels--> 
				</div><!--nonEditable Label -->
<%
			}
			else if(allow_edit_disp_label.equals("Y") ){ //added for Bru-HIMS-CRF-414 [IN:045554] -start
				//String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//Commented heare and added above for ML-BRU-CRF-0473
				String params = request.getQueryString() ;
				String dispDate = bean.getCurrDate();
				String labelLangId = dispBean.getEditableLabelLangId();
				String sDfltLangForDispLabel	= dispBean.getDefaultLanguageForDispenseLabel(patientid);
				String sDefaultEnglish			="selected",sDefaultLocLang="";
				ArrayList langIdName = null;
				String localLang="", drug_yn="";
				StringBuffer sbDispNos = new StringBuffer(); //added for ML-BRU-SCF-1521.1 [IN:055331] -start
				if(disp_nos!=null && disp_nos.size()>0){
					for(int i=0; i<disp_nos.size();i++){
						if(i==0)
							sbDispNos.append(disp_nos.get(i));
						else
							sbDispNos.append(", "+disp_nos.get(i));
					}
				}//added for ML-BRU-SCF-1521.1 [IN:055331] -end
				if(sDfltLangForDispLabel.equals("L")){
					if((!callLangChange.equals("Y") && !sMode.equals("preview")) || labelLangId == null || labelLangId.equals("") )
						labelLangId=bean.getSMLOcalLanguageID();
					langIdName = bean.getLangNameAndId(labelLangId);
				}
				else if((!callLangChange.equals("Y") && !sMode.equals("preview") ) || labelLangId == null || labelLangId.equals(""))
					labelLangId="en";
				langIdName = bean.getDefLangForLabel(patient_class);
				if(langIdName==null || langIdName.size()==0 ){
					if(!locale.equals("en") ){
						langIdName = bean.getLangNameAndId(locale);
					}
					else{
						langIdName = bean.getLangNameAndId(bean.getSMLOcalLanguageID());
					}
				}
				else {
					if(((String)langIdName.get(0)).equals("en")){
						langIdName = bean.getLangNameAndId(bean.getSMLOcalLanguageID());
					}
				}
				if(labelLangId==null || labelLangId.equals(""))
					labelLangId = locale;
				if(labelLangId.equals("en")){
					sDefaultEnglish		=	"selected";
					sDefaultLocLang		=	"";
				}
				else{
					sDefaultEnglish		=	"";
					sDefaultLocLang		=	"selected";
				}
				dispBean.SetEditableLabelLangId(labelLangId);
				String dispQty="", dosageDtl="", instruction="", printDiagDisp="visibility:hidden", printDiagHide="display:inline", pres_drug_code="", no_of_copies=""; 
				int ordLen=0;
				if( !sMode.equals("preview")){
					if(sCalledFrom.equals("PrintDialog")){
						printDiagDisp="visibility:visible"; 
						printDiagHide="display:none"; 
					}
%>
					<div  id='editableLabel'  style='<%=editLabelDisp%>'>
						<table cellpadding="10" cellspacing="0" width="100%" border="0" id='EditableLabelPatDtl'>
							<tr>
								<td class= "COLUMNHEADER" colspan='2' align="left"><font style='font-size:12;'><B>
								<fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></B></font></td>
								<td width='30%' class= "COLUMNHEADER" ><label style='<%=printDiagHide%>'><fmt:message key="Common.Language.label" bundle="${common_labels}"/>&nbsp;&nbsp;</label>
									<select name="labelLanguageId" id="labelLanguageId" onchange='setlabelLangId(this, "EDIT");' style='<%=printDiagHide%>'>
									<option value="en" <%=sDefaultEnglish%>> <fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
<%
									if(langIdName!=null && langIdName.size()>0 && !((String)langIdName.get(0)).equals("en")){
										localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);
%>
										<option value="<%=langIdName.get(0)%>" <%=sDefaultLocLang%>> <%=localLang%></option>
<%
									}
%>
									</select>
								</td>
							</tr>
							<tr>
								<td width='20%'><b><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></b></td>
								<td width='60%'><%=patient_name%><br>
									<%=patientid%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=com.ehis.util.DateUtils.convertDate(dispDate,"DMY","en",labelLangId)%>
								</td>
								<td width='20%'>&nbsp;</td>
							</tr>
						</table>
						<div style="width:100%; overflow:auto;height:<%=sHeight%>;">
							<table cellpadding="10" cellspacing="0" width="100%" border="1" id='EditableLabel'>
<%
								for(iLabelPairs=0;iLabelPairs<alEditLabelPairs.size();iLabelPairs++){
									zeroQtyFlag = false ; 
									dispQty="";
									dosageDtl="";
									instruction="";
									no_of_copies="";
									allocQty = ""; // Added for ML-BRU-CRF-0473   
									hmEditLabelValues = (HashMap)alEditLabelPairs.get(iLabelPairs);
									drug_code			=	(String) hmEditLabelValues.get("drug_code");
									pres_drug_code			=	(String) hmEditLabelValues.get("pres_drug_code");
									order_line_no		=	(String) hmEditLabelValues.get("order_line_no");
									order_id			=	(String) hmEditLabelValues.get("order_id");
									alt_drug_flag		= 	(String) hmEditLabelValues.get("alt_drug_flag")==null?"N":(String) hmEditLabelValues.get("alt_drug_flag");
									drug_name			=	(String) hmEditLabelValues.get("drug_desc");	
									uom			=   (String) hmEditLabelValues.get("uom");

									values	=   bean.getEditLabelValues((order_id+"_"+drug_code+"_"+order_line_no).trim());
									if(values.size()==0){
										bean.getDispEditLabeldetails(order_id,order_line_no,drug_code);
									}

									values	=   bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId );
									if(values==null || values.size()==0){
										bean.getDispEditableLabeldetails(order_id, order_line_no, pres_drug_code, drug_code, labelLangId, sDispStage, sbDispNos.toString());// sDispStage Added for ML-BRU-SCF-1521[IN:053157] //sbDispNos added for ML-BRU-SCF-1521.1 [IN:055331]
										values			=  (ArrayList) bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId);
									}
									if(values!=null && values.size()>0){
										if(pres_drug_code==null || pres_drug_code.equals(""))
											pres_drug_code			=	(String) values.get(0);	
										if(drug_code == null || drug_code.equals(""))
											drug_code			=	(String) values.get(1);	
										dispQty			=	(String) values.get(2);	
										if( values.get(3)!=null && !((String) values.get(3)).equals(""))
											uom			=	(String) values.get(3);	
										dosageDtl		=	(String) values.get(4);	
										no_of_copies	=	(String) values.get(5);	
										instruction		=	(String) values.get(6);	
										drug_yn		=	(String) values.get(7);	//added for ML-BRU-SCF-1524 [IN:053164]
									}
									drug_desc = drug_name;
									if(alt_drug_flag.equals("Y")){
										drug_name			=	(String) hmEditLabelValues.get("alt_drug_desc");
									}

									if(hmAllocBmsCheck.containsKey(order_id+order_line_no)){
										if((patient_class.equals("I") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQtyForIP.equals("Y")) || (patient_class.equals("O") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQty.equals("Y"))){//Adding start for ML-BRU-CRF-0473
										System.err.println("in new condition@@@");
										
									
												bKeepWindow = true;
									
										}else{
										       zeroQtyFlag = true; 
											   System.err.println("in else condition======");
										       continue;
										}
									}	
									else{
										bKeepWindow = true;
									}
									if(sCalledFrom.equals("PrintDialog") ){
										no_of_prints = bean.getPrintNoOfCopies(drug_code);
									}
									ordLen = order_id.length();
									tempDispNos  = (String)orderIdList.get(iLabelPairs);
									if(tempDispNos.length()!= order_id.length()){
										tempDispNos =tempDispNos.substring(0,ordLen);
										if(tempDispNos.equals(order_id)){
											dispNosOrder = ((String)orderIdList.get(iLabelPairs)).substring(ordLen+1,((String)orderIdList.get(iLabelPairs)).length());
											allocQty = bean.getDispQuantity(dispNosOrder,order_id,order_line_no,sDispStage,alt_drug_flag,drug_code);//alt_drug_flag,drug_code added for ML-BRU-SCF-1714
										}
									}
									else{
										/*if(sCalledFrom.equals("PrintDialog")){ // commented for ML-BRU-SCF-1789 - Start
											allocQty="0";
										}
										else{
											allocQty="";
										}*/ // commented for ML-BRU-SCF-1789 - End
										ArrayList alt_drug_dt = new ArrayList(); // Added for ML-BRU-SCF-1789 - Start
										int tot_alt_qty = 0;
										
										if(!alt_drug_flag.equals("N")){ 
										   
											alt_drug_dt = bean.getAlternateDrugDetail(patientid,order_id,order_line_no,drug_code);
										
											for(int i=0; i<alt_drug_dt.size(); i+=10){
												tot_alt_qty=tot_alt_qty+(int)Double.parseDouble((String)alt_drug_dt.get(i+3)); 
											}	
											
											allocQty = String.valueOf(tot_alt_qty);
										}
										else{
										  if(!bean.getDrugQuantity(patientid,order_id,order_line_no).equals("")){
											allocQty=String.valueOf((int)Double.parseDouble(bean.getDrugQuantity(patientid,order_id,order_line_no)));
										  }
										}  // Added for ML-BRU-SCF-1789 - End
									}
									if(allocQty.equals("0")){
										allocQty = bean.getTPNDispQuantity(order_id,order_line_no,sDispStage);
									}
									if(dispQty.equals(""))
										dispQty = allocQty;
									if(allocQty == null || allocQty.equals("")) // added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
										allocQty = "0";
									if(no_of_copies.equals("") && !no_of_prints.equals("N") && !no_of_prints.equals("")) // && !no_of_prints.equals("") Added for ML-BRU-SCF-1789
										no_of_copies = allocQty;
									else if(no_of_copies.equals("") && no_of_prints.equals("N")) // && no_of_prints.equals("N") Added for ML-BRU-SCF-1789
										no_of_copies = "1";

									if(Integer.parseInt(allocQty) > 0)//added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
										allocQtyFlag = true;
								if(patient_class.equals("O") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQty.equals("Y"))//Added for ML-BRU-CRF-0473
								       	  no_of_copies="0";//Added for ML-BRU-CRF-0473
								if(patient_class.equals("I") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQtyForIP.equals("Y")){
									      no_of_copies="0";//Added for ML-BRU-CRF-0473
										  allocQtyFlag = true;
										  zeroQtyFlag = true;
								}


									if((!allocQty.equals("0") || (patient_class.equals("O") && strIncludeZeroQty.equals("Y"))) || (!allocQty.equals("0") || (patient_class.equals("I") && strIncludeZeroQtyForIP.equals("Y")) ) || !sCalledFrom.equals("PrintDialog")){// || strIncludeZeroQty.equals("Y")Added for ML-BRU-CRF-0473
%>
										<tr>
											<td class='label' width='20%'><b><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>
												<label id='lblDispQty<%=iLabelPairs%>' style='<%=printDiagDisp%>'>&nbsp;/<br>
												<fmt:message key="ePH.DispensedQty.label" bundle="${ph_labels}"/></label></b></td>
												<td class='label'  width='60%'><%=drug_name%>
												<label id='fldDispQty<%=iLabelPairs%>' style='<%=printDiagDisp%>'>&nbsp;&nbsp;
												<input type='text' name='dispQty<%=iLabelPairs%>' id='dispQty<%=iLabelPairs%>' style='<%=printDiagDisp%>' value='<%=allocQty%>' size='4' maxlength='3' onpaste='return false' onKeyPress="return allowValidNumber(this,event,3,0);">&nbsp;<%=bean.getUomDisplay(facility_id,uom)%>&nbsp;<%--changed dispQty to <%=allocQty%> for ML-BRU-SCF-1521.1 [IN:055331]  --%>
												<img  src="../../eCommon/images/mandatory.gif" style='<%=printDiagDisp%>'></label>
											</td>
											<td class='label'  width='20%'><label  id='lblnoOfPrints<%=iLabelPairs%>' style='<%=printDiagDisp%>'>
											<b><fmt:message key="ePH.NoOfPrints.label" bundle="${ph_labels}"/></b>&nbsp;
											<input type="text" id="noOfPrints<%=iLabelPairs%>" maxLength="3" size="2" name="noOfPrints<%=iLabelPairs%>" value="<%=no_of_copies%>" onKeyPress="return allowValidNumber(this,event,3,0);" onblur="validateNoOfPrints(this, '<%=allocQty%>','<%=allow_label_zero_copy%>');"  style='<%=printDiagDisp%>'>
											</td>
										</tr>
										<tr>
											<td class='label'><b><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></b></td>
											<td class='label'><input type='text' name='dosageDtl_<%=iLabelPairs%>' id='dosageDtl_<%=iLabelPairs%>'  value='' size='80' maxlength='170' onKeyPress="return checkMaxLimit(this,170);" onblur ="return checkDrugIndMaxLimit(this,170);"></b>
<%
											if(drug_yn.equals("Y")){
%>

												<img  src="../../eCommon/images/mandatory.gif"></td>
<%
											}
											if(!dosageDtl.equals("")){
												dosageDtl=dosageDtl.replaceAll(" ","%20");
												dosageDtl = java.net.URLEncoder.encode(dosageDtl,"UTF-8");
												dosageDtl=dosageDtl.replaceAll("%2520"," ");
%>
												<script>
													var jsdosageDtl = decodeURIComponent('<%=dosageDtl%>');
													eval('document.DispMedicationEditLabel.dosageDtl_'+'<%=iLabelPairs%>').value=jsdosageDtl;
												</script>
<%
											}
											 DispNoAndSrlNo= bean.getDispNoAndSrlNo(drug_code, order_id, order_line_no, sDispStage); // Added for TTMWM-SCF-0184 - Start
					                          if(DispNoAndSrlNo.size()>=2){
					                        	  disp_no  = (String)DispNoAndSrlNo.get(0); 
					                              disp_srl_no = (String)DispNoAndSrlNo.get(1); 
					                          } // Added for TTMWM-SCF-0184 - End
%>
											<td class='label'>&nbsp;</td>
										</tr>
										<tr>
											<td class='label'><b><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></b></td>
											<td class='label'><textarea name='instruction_<%=iLabelPairs%>' maxlength="270"  rows='4' cols='70' onKeyPress="return checkMaxLimit(this,270);" onblur ="return checkDrugIndMaxLimit(this,270);"><%=instruction%></textarea>
											</td>
											<td class='label'>&nbsp;</td>
										</tr>
										<tr style='height:2;'><td colspan='3'>&nbsp</td>
										<input type="hidden" name="order_id_<%=iLabelPairs%>" id="order_id_<%=iLabelPairs%>"  value="<%=order_id%>">
										<input type="hidden" name="order_line_no_<%=iLabelPairs%>" id="order_line_no_<%=iLabelPairs%>"  value="<%=order_line_no%>">
										<input type="hidden" name="drug_code_<%=iLabelPairs%>" id="drug_code_<%=iLabelPairs%>"  value="<%=drug_code%>">
										<input type="hidden" name="pres_drug_code_<%=iLabelPairs%>" id="pres_drug_code_<%=iLabelPairs%>"  value="<%=pres_drug_code%>">
										<input type="hidden" name="dispUOM<%=iLabelPairs%>" id="dispUOM<%=iLabelPairs%>"  value="<%=uom%>">
										<input type="hidden" name="encodedDosageDtl_<%=iLabelPairs%>" id="encodedDosageDtl_<%=iLabelPairs%>"  value="<%=dosageDtl%>">
										<input type="hidden" name="disp_no_<%=iLabelPairs%>" id="disp_no_<%=iLabelPairs%>"  value="<%=disp_no%>"> <!-- Added for TTMWM-SCF-0184 -->
						                               <input type="hidden" name="disp_srl_no_<%=iLabelPairs%>" id="disp_srl_no_<%=iLabelPairs%>"  value="<%=disp_srl_no%>"> <!-- Added for TTMWM-SCF-0184 -->
										<input type="hidden" name="allocQty<%=iLabelPairs%>" id="allocQty<%=iLabelPairs%>"  value="<%=allocQty%>"><!--Code Added FOR RUT-CRF-0067-->
										<input type="hidden" name="allow_label_zero<%=iLabelPairs%>" id="allow_label_zero<%=iLabelPairs%>"  value="<%=allow_label_zero_copy%>"><!--Added for ML-BRU-SCF-1122 [IN:044833]-->
										<input type="hidden" name="drug_yn<%=iLabelPairs%>" id="drug_yn<%=iLabelPairs%>"  value="<%=drug_yn%>"><!--added for ML-BRU-SCF-1524 [IN:053164]-->
<%
									}
								}
%>
							</table>
							<input type="hidden" name="labelLangId" id="labelLangId"  value="<%=labelLangId%>">
						</div>
					</div>
<%
				}
				else if( sMode.equals("preview")){
%>
						<br>
						<div style="width:100%;overflow:auto;height:<%=sHeight%>;text-align:center;" id='editableLabelPreview'  style='<%=editLabelPreviewDisp%>'>
							<table cellpadding="10" cellspacing="0" style="width:500"  border="1" id='EditableLabel'>
<%
							for(iLabelPairs=0;iLabelPairs<alEditLabelPairs.size();iLabelPairs++){
								bKeepWindow = true;
								dispQty="";
								dosageDtl="";
								instruction="";
								hmEditLabelValues = (HashMap)alEditLabelPairs.get(iLabelPairs);
								drug_code			=	(String) hmEditLabelValues.get("drug_code");
								pres_drug_code			=	(String) hmEditLabelValues.get("pres_drug_code");
								order_line_no		=	(String) hmEditLabelValues.get("order_line_no");
								order_id			=	(String) hmEditLabelValues.get("order_id");
								alt_drug_flag		= 	(String) hmEditLabelValues.get("alt_drug_flag")==null?"N":(String) hmEditLabelValues.get("alt_drug_flag");
								drug_name			=	(String) hmEditLabelValues.get("drug_desc");	
								uom			=   (String) hmEditLabelValues.get("uom");
								values	=   bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId );
								if(values==null || values.size()==0){
									bean.getDispEditableLabeldetails(order_id, order_line_no, pres_drug_code, drug_code, labelLangId, sDispStage, sbDispNos.toString());// sDispStage Added for ML-BRU-SCF-1521[IN:053157] //sbDispNos added for ML-BRU-SCF-1521.1 [IN:055331]
									values			=  (ArrayList) bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId);
								}
								if(values!=null && values.size()>0){
									dispQty			=	(String) values.get(2);	
									uom			=	(String) values.get(3);	
									dosageDtl		=	(String) values.get(4);	
									instruction		=	(String) values.get(6);	
									if(!dispQty.equals(""))
										dispQty = "("+dispQty+bean.getUomDisplay(facility_id,uom)+")";
								}
								drug_desc = drug_name;
								if(alt_drug_flag.equals("Y")){
									drug_name			=	(String) hmEditLabelValues.get("alt_drug_desc");
								}
%>
									<tr>
										<td colspan='2' style='font: bold 20px Calibri,western;'><%=patient_name%></td>
									</tr>
									<tr>
										<td width='50%' style='font: bold 20px Calibri,western;border-right-width:0'><%=patientid%></td>
										<td width='50%' style='font: bold 20px Calibri,western; text-align:right;border-left-width:0'><%=com.ehis.util.DateUtils.convertDate(dispDate,"DMY","en",labelLangId)%>
										</td>
									</tr>
									<tr>
										<td colspan='2' style='font: bold 16px Calibri,western;text-align:center;'><%=drug_name%><%=dispQty%></td>
									</tr>
									<tr>
										<td colspan='2' style='font: bold 16px Calibri,western;font-weight:bold;text-align:center;'><label id='dosageDtl_<%=iLabelPairs%>'></label></td>
									</tr>
									<tr>
										<td colspan='2'style='font: italic 12px Calibri,western;text-align:left;'><label id='instruction_<%=iLabelPairs%>'></label></td>
									</tr>
								<tr ><td colspan='2' style='height:2;border-right:0;border-left:0;border-top:0;border-bottom:0;'>&nbsp;</td></tr>
<%
								if(!dosageDtl.equals("")){
									dosageDtl=dosageDtl.replaceAll(" ","%20");
									dosageDtl = java.net.URLEncoder.encode(dosageDtl,"UTF-8");
									dosageDtl=dosageDtl.replaceAll("%2520"," ");
%>
									<script>
										eval(document.getElementById("dosageDtl_"+'<%=iLabelPairs%>')).innerText=decodeURIComponent('<%=dosageDtl%>');
									</script>
<%
								}
								if(!instruction.equals("")){
									instruction=instruction.replaceAll(" ","%20");
									instruction = java.net.URLEncoder.encode(instruction,"UTF-8");
									instruction=instruction.replaceAll("%2520"," ");
%>
									<script>
										eval(document.getElementById("instruction_"+'<%=iLabelPairs%>')).innerText= decodeURIComponent('<%=instruction%>');
									</script>
<%
								}
							}
%>
						</table>
					</div>
<%
				}
%>
				<INPUT TYPE="hidden" name="params" id="params" Value="<%=params %>">
				
<%
			}//Added for Bru-HIMS-CRF-414 [IN:045554] -end
			if(!bKeepWindow){
%>
				<script>
					alert(getMessage("NO_EDIT_LABELS","PH"));
					var  zeroQtyFlag1 = <%=zeroQtyFlag%> ; // added for KAUH-SCF-001		
					if(parent.buttonFrame!=undefined)
						if(zeroQtyFlag1 != true )  // added for KAUH-SCF-001
						parent.buttonFrame.document.frmPrintDialogButtons.btnCancel.onclick();
					else
						if(zeroQtyFlag1 != true )  // added for KAUH-SCF-001
							window.close();
				</script>
<%
			}
%>
			</div>
			<table cellpadding="0" cellspacing="0" width="100%" border="0">
				<tr>
					<td  align="right" width="100%" <%=sShowButtons%>>
					<input  type="button" <%=sDisableAll%> value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'class="button" onClick="validateEditDetailsReset(DispMedicationEditLabel);">
					<input  type="button" <%=sDisableAll%> value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="validateEditDetails(DispMedicationEditLabel);">
					<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="validateEditDetailsCancel(DispMedicationEditLabel);">
					</td>
				</tr>
			</table>

			<input type="hidden" name="bean_id" id="bean_id"   value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="calledFrom" id="calledFrom" value="">
			<input type="hidden" name="ComputeSetOrder" id="ComputeSetOrder" value="">
			<input type="hidden" name="PrintDialogFrame" id="PrintDialogFrame" value="parent.printSelectFrame.document.DispMedicationPrintDialog">
			<input type="hidden" name="sDispStage" id="sDispStage" value="<%=sDispStage%>" >
			<input type="hidden" name="func_mode" id="func_mode" value="<%=func_mode%>">
			<input type="hidden" name="totalRecordds" id="totalRecordds"  value="<%=iLabelPairs%>">
			<input type="hidden" name="editLabelFlag" id="editLabelFlag"  value="fill_allocate"><!-- Code Added For RUT-CRF-0067 -->
			<input type="hidden" name="allow_edit_disp_label" id="allow_edit_disp_label"  value="<%=allow_edit_disp_label%>"> <!-- Added for Bru-HIMS-CRF-414 [IN:045554]-->
			<input type="hidden" name="sCalledFrom" id="sCalledFrom"  value="<%=sCalledFrom%>"> <!-- Added for Bru-HIMS-CRF-414 [IN:045554]-->
			<input type="hidden" name="allocQtyFlag" id="allocQtyFlag" id="allocQtyFlag" value="<%=allocQtyFlag%>" ><!-- added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)  -->
			<input type="hidden" name="IncludeZeroQtyForIP" id="IncludeZeroQtyForIP" value="<%=strIncludeZeroQtyForIP%>"><!-- Added for ML-BRU-CRF-0473 -->
            <input type="hidden" name="IncludeZeroQtyForOP" id="IncludeZeroQtyForOP" value="<%=strIncludeZeroQty%>"><!-- Added for ML-BRU-CRF-0473 -->
            <input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>"><!-- Added for ML-BRU-CRF-0473 -->
			

		</form>
		<script>
<% 
			if(alEditLabelPairs.size()==0 && sCalledFrom.equals("")){
%>
				alert(getMessage("NO_EDIT_LABELS","PH"));
				window.close();
<%
			}
%>
		</script>
<%
	}
	catch(Exception exception){
		exception.printStackTrace();
	}
finally{ // Added for ML-MMOH--1089 start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-crf-1089 end
%>
	</body>
</html>


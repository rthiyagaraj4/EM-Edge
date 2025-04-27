<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
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
		String login_user	=	(String)session.getValue("login_user");
	    
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT> 
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<%
		String bean_id						= "DispMedicationBean" ;
		String bean_name					= "ePH.DispMedicationBean";
		DispMedicationBean bean				= (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);

		String	bean_id1				    =	"DispMedicationAllStages" ;
		String	bean_name1			        =	"ePH.DispMedicationAllStages";
		
		DispMedicationAllStages bean1        = (DispMedicationAllStages)getBeanObject( bean_id1, bean_name1,request);
		bean.setObject(bean1);
		
		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );

		String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
		param_bean.clear();
		String nursing_unit                 =(String)bean.getNursingUnit();
		//String nursing_unit                 ="";
		ArrayList	patient_dtl				= new ArrayList();
		if(!nursing_unit.equals("")){
			patient_dtl				= (ArrayList)bean.getDeliveryPatientFillListDtls();
		}

		ArrayList	alternate_drugs			= new ArrayList();	
		String disp_stage					= bean.getDispStage();
		bean.setMode(CommonRepository.getCommonKeyValue( "MODE_MODIFY" ));
		String patient_id					= "";
		String checked						= "checked";
		String val							= "Y";
		String disabled						= "";
		String tot_disp_qty					= "";
		String drug_color					= "";
		String classvalue_2					= "";
		String external_prod_id				= "";
		String alternate_external_prod_id	= "";
		String discharge_label				= "";
		String allow_disp_record_lock_yn	= "";
		String lock_status              	= "";
		String Unlock_all_records_yn        = "";
		String user_id                      = "";
		String locked_date_time             = "";
		String disp_locn_code				= bean.getDispLocnCode();
		String sDisableChildCheckBoxes		= "";
		String sEnableDisableFunction		= "";
		HashMap AccessRightMap				= new HashMap();
		String sDispDrugAuthYN				= "N";
		//code added for medical item
		StringBuffer orderIDS_trxRefIDS		= new StringBuffer();
		String  store_desc					=  bean.getStoreDesc(disp_locn_code);	
		String  sysdate						=  bean.getTodaysDate();
		String billing_interface_yn			=  bean1.getBLInterfaceYN();//checkforbillinginterface();
		ArrayList  trn_rx_id				=	new ArrayList();
		HashMap  trn_rx_ids_patientwise	    =	new HashMap();
		String alt_drug_remarks_ind = bean.getAltDrugRemarksInd();//added for  Bru-HIMS-CRF-082 [IN:029948]
        String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
		String allocated_qty = "";  // added for IN 28256
		ArrayList	colors	=	new ArrayList();
		ArrayList patient_order_line_dtls = null;
		HashMap patient_orderline_dtls = null;
		colors.add("#FF0000");
		colors.add("#669900");
		colors.add("#FF9966");
		colors.add("#6699CC");
		colors.add("#FF0000");
		colors.add("#669900");
		colors.add("#FF9966");
		colors.add("#6699CC");
		colors.add("#FF0000");
		colors.add("#669900");
		colors.add("#FF9966");
		colors.add("#6699CC");
%>
		<form name="frmDispMedicationDeliveryFillList" id="frmDispMedicationDeliveryFillList" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" >
				<tr >
					<td class= "COLUMNHEADER"  width="20%"><fmt:message key="ePH.PatientID/OrderId.label" bundle="${ph_labels}"/></th>
					<td class= "COLUMNHEADER"  width="40%"><fmt:message key="ePH.PatientDetail/Drug.label" bundle="${ph_labels}"/></th>
					<td class= "COLUMNHEADER"  width="8%"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/> </th>
					<td class= "COLUMNHEADER"  width="8%"><fmt:message key="ePH.DispensedQty.label" bundle="${ph_labels}"/></th>
					<td class= "COLUMNHEADER"  width="8%"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></th>
					<td class= "COLUMNHEADER"  width="8%"><fmt:message key="Common.Stock.label" bundle="${common_labels}"/>&nbsp;</th>
					<!-- <td class= "COLUMNHEADER"  width="8%"><fmt:message key="ePH.DispensedQty.label" bundle="${ph_labels}"/></th> -->
					<td class= "COLUMNHEADER"  width="8%"><fmt:message key="ePH.DeliverStatus.label" bundle="${ph_labels}"/></th>
				</tr>
<%
				int recCount = 0;
				String sex, patient_name ,encounter_id, bl_patient_class, classvalue="";
				if(patient_dtl.size() > 0){
					for(int i=0;i<patient_dtl.size();i++){
						orderIDS_trxRefIDS   =  new StringBuffer();//code added for medical item
						trn_rx_id			 =	new ArrayList();
						HashMap patient_dtls = (HashMap)patient_dtl.get(i);
						if(recCount%2==0){
							classvalue = "QRYODD";
						}
						else{
							classvalue = "QRYEVEN";
						}
						sex              =(String) patient_dtls.get("SEX");
						patient_id              =(String) patient_dtls.get("PATIENT_ID");
						patient_name     =(String) patient_dtls.get("PATIENT_NAME");
						encounter_id     =(String) patient_dtls.get("ENCOUNTER_ID");
						bl_patient_class =(String) patient_dtls.get("ENC_PATIENT_CLASS");
						//String  patient_id=(String)result.get(i);
						// String patient_name=(String)result.get(i+1);	   

						if(sex.equalsIgnoreCase("female"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else if(sex.equalsIgnoreCase("male"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(sex.equalsIgnoreCase("unknown"))
							sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

						if(patient_dtls.get("ADT_STATUS").equals("08"))
							discharge_label =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
						else
							discharge_label ="";

						ArrayList patient_order_dtl =(ArrayList) bean.getDeliveryPatientOrderDtls((String)patient_dtls.get("PATIENT_ID"));
						//code added for medical items	
						if(patient_order_dtl.size() > 0){
							for(int j=0;j<patient_order_dtl.size();j++){
								HashMap patient_order_dtls = (HashMap)patient_order_dtl.get(j);
								if(!((String) patient_order_dtls.get("DISP_TRN_SEQ_NO")).equals("") ) {
									orderIDS_trxRefIDS.append((String) patient_order_dtls.get("ORDER_ID")).append("::").append((String) patient_order_dtls.get("DISP_TRN_SEQ_NO")).append("::");
									trn_rx_id.add(patient_order_dtls.get("DISP_TRN_SEQ_NO"));
								}
							}
						}
						//ends here
%>
						<tr id="tr_<%=recCount%>" style="display:inline">
			
							<td class="<%=classvalue%>" style="font-size:11;font:bold;" >&nbsp;&nbsp;<label style="cursor:pointer;color:blue;font-size:13" onClick='callProcess("<%=patient_id%>","P")' id="patsym_<%=(String)patient_dtls.get("PATIENT_ID")%>">+</label>&nbsp;<%=(String)patient_dtls.get("PATIENT_ID")%>(<%=(String)patient_dtls.get("ORDERS")%>)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
							<td class ="<%=classvalue%>" style="font-size:11;font:bold;" ><label> <%=(String)patient_dtls.get("PATIENT_NAME")%>&nbsp;,<%=(String)patient_dtls.get("AGE")%>,&nbsp;<%=sex%>,&nbsp;<fmt:message key="Common.bedno.label" bundle="${common_labels}"/> : <%=(String)patient_dtls.get("BED_NO")%> &nbsp;Location  :<%=(String)patient_dtls.get("NURSING_UNIT")%></label>
<% 
							if(!discharge_label.equals("")){
%>
								<font style="font-size:9;" id='discharge_label' >&nbsp;&nbsp;&nbsp;&nbsp;<%=discharge_label%></font>
									<script>
										XX1=new blinkText("XX1",'discharge_label',500,500,'darkred','#ff0000');
									</script>
<%
							}
							if(orderIDS_trxRefIDS.length()>0){			  
%>
								&nbsp;<b><a  style ='font-size:9' href="javascript:callMedicalItemdetails('<%=patient_id%>','<%=encounter_id%>','<%=disp_stage%>','<%=billing_interface_yn%>','<%=disp_locn_code%>','<%=bl_patient_class%>','<%=orderIDS_trxRefIDS.toString()%>','<%=sysdate%>','<%=java.net.URLEncoder.encode(store_desc)%>')"><fmt:message key="ePH.MedicalItems.label" bundle="${ph_labels}"/> </a></b>
<%
							}
%>
							</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td class="<%=classvalue%>" ><input type="checkbox" name='PAT<%=(String)patient_dtls.get("PATIENT_ID")%>' id='PAT<%=(String)patient_dtls.get("PATIENT_ID")%>' checked value="" onClick="chkPatientRecords('<%=(String)patient_dtls.get("PATIENT_ID")%>');setValue(this)">
							</td>
						</tr>
<%
						recCount++;
						//ArrayList patient_order_dtl =(ArrayList) bean.getDeliveryPatientOrderDtls((String)patient_dtls.get("PATIENT_ID"));
						if(patient_order_dtl.size() > 0){          

							for(int j=0;j<patient_order_dtl.size();j++){
								HashMap patient_order_dtls = (HashMap)patient_order_dtl.get(j);
								classvalue_2	  =	"";
							 
								if(j%2==0)
									classvalue_2 = "QRYODD";
								else
									classvalue_2 = "QRYEVEN";

								patient_order_line_dtls = (ArrayList)bean.getDeliveryPatOrderLineDtls((String)patient_dtls.get("PATIENT_ID"),(String)patient_order_dtls.get("ORDER_ID"));

								if(patient_order_line_dtls.size() > 0){
									ArrayList patient_order_line_dtl = (ArrayList)patient_order_line_dtls.get(0);
				
								for(int k=0;k<patient_order_line_dtl.size();k++){
									patient_orderline_dtls = (HashMap)patient_order_line_dtl.get(k);
									external_prod_id =(String)patient_orderline_dtls.get("EXTERNAL_PRODUCT_ID");
									int iOrderLineNo = Integer.parseInt(patient_orderline_dtls.get("ORDER_LINE_NUM").toString());
									alternate_drugs=null;
									alt_drug_remarks_disp="";
									if(patient_order_line_dtls.get(1) != null)
										alternate_drugs=(ArrayList)patient_order_line_dtls.get(1);
									if(alternate_drugs!=null && alternate_drugs.size() > 0){// if condition added for  Bru-HIMS-CRF-082 [IN:029948]
										if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){
											alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+(String)patient_order_dtls.get("ORDER_ID")+"','"+(String)patient_orderline_dtls.get("ORDER_LINE_NUM") +"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
											if(alt_drug_remarks_ind.equals("M"))
												alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
										}
									}
%>
									<tr style="display:none" id="PAT_<%=(String)patient_dtls.get("PATIENT_ID")%>_<%=j%>_<%=iOrderLineNo%>">
										<td class="<%=classvalue_2%>" style="font-size:9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(String)patient_order_dtls.get("ORDER_ID")%></td>
										<td class="<%=classvalue_2%>" style="font-size:9" >&nbsp;&nbsp;&nbsp;<b><%=patient_orderline_dtls.get("DRUG_DESC")%>&nbsp;&nbsp;&nbsp;<%=alt_drug_remarks_disp%></b>
<%
										if(external_prod_id!=null && !(external_prod_id.equals("")) && drug_db_interface_yn.equals("Y")){
%>
											<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=external_prod_id%>','<%=patient_orderline_dtls.get("DRUG_DESC")%>')"></img>
<%
										}

										if(alternate_drugs!=null && alternate_drugs.size()>0){
											int m=0;
											for(int l=0;l<alternate_drugs.size();l=l+8){
												drug_color					=(String)colors.get(m);
												alternate_external_prod_id  =(String)alternate_drugs.get(l+7);
%>
												<br><label style="color:<%=drug_color%>">&nbsp;&nbsp;&nbsp;<%=alternate_drugs.get(l+1)%> </label>
<%
												if(!alternate_external_prod_id.equals("")&& alternate_external_prod_id!=null && drug_db_interface_yn.equals("Y")){
%>
													<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alternate_external_prod_id%>','<%=java.net.URLEncoder.encode(((String)alternate_drugs.get(l+1)),"UTF-8")%>')"></img>
<%
												}
												m++;
											}
										}
%>
										</td>
										<td class="<%=classvalue_2%>" style="font-size:9" ><%=patient_orderline_dtls.get("ORDER_QTY")%></td>
<%
										tot_disp_qty =bean.getTotalDispQty((String)patient_order_dtls.get("ORDER_ID"));
										if(tot_disp_qty.equals("")){
%>
											<td class="<%=classvalue_2%>" style="font-size:9" >&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classvalue_2%>" style="font-size:9" ><%=tot_disp_qty%></td>
<%
										}
										if(alternate_drugs.size()>0){
%>
											<td class="<%=classvalue_2%>" style="font-size:9" >
<%  
											if(patient_orderline_dtls.containsKey("AlterDrugDtls")){
												if(alternate_drugs.size()>0&&alternate_drugs!=null){
													int m=0;

													for(int l=0;l<alternate_drugs.size();l=l+8){
														drug_color =(String)colors.get(m);
%>
														<br> <label style="color:<%=drug_color%>">&nbsp;&nbsp;&nbsp;<%=alternate_drugs.get(l+5)%><%=bean.getUomDisplay(facility_id,(String)alternate_drugs.get(l+6))%></label>
<%	
														m++;
													}							   
												}
											}
%>
											</td>
<%
										}
										else{
											/* added for IN 28256 -start*/
											allocated_qty=(String)patient_orderline_dtls.get("ALLOC_QTY");
											if(allocated_qty == null || allocated_qty.equals(""))
												allocated_qty = "&nbsp;";
											/* added for IN 28256 -end*/
%>
											<td class="<%=classvalue_2%>" style="font-size:9" ><%=allocated_qty%></td> <!--  patient_orderline_dtls.get("ALLOC_QTY") changed to allocated_qty-->
<%
										}
										if(patient_orderline_dtls.get("STKAVAILABLE").equals("N") && alternate_drugs.size()==0 && patient_orderline_dtls.get("FILLED_BATCH_COUNT").equals("0")){
											checked ="";
											val     ="N";
											disabled="disabled";
%>
											<td class="<%=classvalue_2%>" style="font-size:9" title='<fmt:message key="ePH.NoStock.label" bundle="${ph_labels}"/>'><img src='../../eCommon/images/disabled.gif' ></td>
<%
										}
										else if(patient_orderline_dtls.get("FILLED_BATCH_COUNT").equals("0")){
											checked ="";
											val     ="N";
											disabled="disabled";
%>
											<td class="<%=classvalue_2%>" style="font-size:9" title='<fmt:message key="ePH.NotAllocated.label" bundle="${ph_labels}"/>' ><img src='../../eCommon/images/disabled.gif' ></td>   
<%
										}
										else{
											checked ="checked";
											val     ="Y";
											disabled="";
%>
											<td class="<%=classvalue_2%>" style="font-size:9" >&nbsp;</td>
<%
										}
										if(iOrderLineNo > 1){
											sDisableChildCheckBoxes = "disabled";
											sEnableDisableFunction	= "";
										}
										else{
											sDisableChildCheckBoxes = "";
											sEnableDisableFunction	= "checkUncheckChildChkBoxs('"+(String)patient_dtls.get("PATIENT_ID")+"','"+(String)patient_order_dtls.get("ORDER_ID")+"','"+j+"','"+disabled+"',this)";
										}
%>  
					   
										<td class="<%=classvalue_2%>" style="font-size:9" ><input type="checkbox" name='PAT<%=(String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")%>_<%=j%>_<%=iOrderLineNo%>' id='PAT<%=(String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")%>_<%=j%>_<%=iOrderLineNo%>' <%=checked%> <%=disabled%> <%=sDisableChildCheckBoxes%> value="<%=val%>" onclick = "setValue(this);<%=sEnableDisableFunction%>">
										<input type ="hidden" name='drugCode_PAT<%=(String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")%>_<%=j%>_<%=iOrderLineNo%>' id='drugCode_PAT<%=(String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")%>_<%=j%>_<%=iOrderLineNo%>' value ="<%=(String)patient_orderline_dtls.get("DRUG_CODE")%>">

										<input type = "hidden" name='stock_<%=(String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")%>_<%=j%>_<%=iOrderLineNo%>' id='stock_<%=(String)patient_dtls.get("PATIENT_ID")+"_"+(String)patient_order_dtls.get("ORDER_ID")%>_<%=j%>_<%=iOrderLineNo%>' value= "<%=disabled%>">
										</td>
									</tr>
<%
									recCount++;
								}	//end of line detail for loop
							}  // end of line detail if loop
						} // end of order detail for loop
					}
					if(trn_rx_id.size()>0){
						trn_rx_ids_patientwise.put(patient_id,trn_rx_id);
					}
				} //end of patient detail for loop
			}// end of if loop
			else{ 
				if(!nursing_unit.equals("")){
%>
					<script language="javascript">
						alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
						//parent.parent.parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+ getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"); //added for [IN:037465]
					</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
				}
			}
			bean.setTrn_rx_ids_patientwise(trn_rx_ids_patientwise);
%>
			</table>
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>"> 
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="mode" id="mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value = "<%=disp_stage%>">
		</form>
	</body>
	<script>
		checkStockUnavailable();
		callDeliverLegendsFrame('<%=patient_id%>','D','','','<%=sDispDrugAuthYN%>');
	</script>
</html>
<%
putObjectInBean(param_bean_id,param_bean,request);
putObjectInBean(bean_id,bean,request);
%>


<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
4/1/2021		10576			Shazana					MMS-DM-CRF-0174.4
07/09/2021      TFS-12410       Prabha			Alpha -PH- Return Medication invalid barcode
--------------------------------------------------------------------------------------------------------------
--> 
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../ePH/js/ReturnMedication.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT> -->
	</head>
<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >-->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form id="FormReturnMedicationAction" name="FormReturnMedicationAction" id="FormReturnMedicationAction">
<%
			String mode	= CommonRepository.getCommonKeyValue("MODE_MODIFY"); 
			java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
			String bean_id		= "ReturnMedicationBean"+login_at_ws_no ;
			String bean_name	= "ePH.ReturnMedicationBean";
			ReturnMedicationBean bean = (ReturnMedicationBean)getBeanObject( bean_id,bean_name,request) ;
			//bean.clear() ;
		try{

			bean.setLanguageId(locale);
			bean.setMode( mode ) ;
			String facility_id					= (String) session.getValue("facility_id");
			//Search Criteria's from Query Criteria page
			String patientid		= request.getParameter( "patientid" );
			String drugcodes		= request.getParameter( "drugcodes" );
			String drugcode			= request.getParameter( "drugcode" );
			String dispno     		= request.getParameter( "dispno" ) ;
			String cutoff     		= request.getParameter( "cutoff" ) ;
			String orderid     		= request.getParameter( "orderid" ) ;
			String displocn     	= request.getParameter( "dispLocn" ) ;
			String remarks     		= request.getParameter( "remarks" ) ;
			String patcat     		= request.getParameter( "patcat" ) ;
			String barcode	=  CommonBean.checkForNull(request.getParameter( "barcode"));//Added for GHL-CRF-043.8
			boolean valid_barcode=false;//Added for GHL-CRF-0413.8
			String Ward_Date_From   = CommonBean.checkForNull(request.getParameter( "Ward_Date_From" ) );
			String ward_Date_To     = CommonBean.checkForNull(request.getParameter( "ward_Date_To" )) ;
			String eff_status     	= CommonBean.checkForNull(request.getParameter( "eff_status" )) ;
			String From_Location    = CommonBean.checkForNull(request.getParameter( "From_Location" )) ;
			String encounter_id		=  CommonBean.checkForNull(request.getParameter( "encounter_id" ));
			String rej_qty			= CommonBean.checkForNull(request.getParameter( "rej_qty" )) ;	// Added for GHL-SCF-790  [IN:046481]
			String blDocType	=  CommonBean.checkForNull(request.getParameter( "blDocType" )); //Added for MMS-DM-CRF-0039 [IN:055958]
			String blDocNo	=  CommonBean.checkForNull(request.getParameter( "blDocNo" )); //Added for MMS-DM-CRF-0039 [IN:055958]

			StringBuffer issue_qty_dtl   = new StringBuffer(); 
			HashMap IssueUOMAndBaseUOM	 = new HashMap();
			HashMap binLocationDetails	 = new HashMap();
			ArrayList binLocation=new ArrayList();
			ArrayList result=new ArrayList();//Added for GHL-CRF-0413.8 
			ArrayList batchDetails=new ArrayList();//Added for GHL-CRF-0413.8
			int count=1;//Added for GHL-CRF-0413.8 
			String dflt_issue_uom		 = "";
			String base_uom			     = "";
			int base_to_disp_uom_equl    = 0;
			int base_to_def_uom_equl     = 0;
			int base_to_issue_uom_equl   = 0;
			int base_to_to_store_def_uom_equl =0;
			int final_conv_factor        = 0;
			String issue_uom_by			 = bean.getISSUE_UOM_BY ();

			String order_line_staus      = "";
			String Details          = "";
			String dis_cont_reason       = "";
			String DISC_DATE_TIME		 = "";
			String pract_name			 = "";
			String nationalid			 = "" ;
			String healthcard     		 = "" ;
			String drug_code     		 = "" ;
			
			String FormStore			 = CommonBean.checkForNull(request.getParameter( "FormStore" )) ; 

			String StoreCount			 = "" ;
			String to_store_def_issue_uom ="";
			String classvalue="", sal_disp_locn=""; //sal_disp_locn added for KDAH-SCF-0252 [IN:050489]
			int disabledCount			 = 0;
			boolean flag				 = false; //false; // SKR-SCF-0225 IN029331 -have to handle
			String barcodeFlag           = "";// Added for GHL-CRF-0413.8[IN063028]
			
			/* Initialize Function specific start */
			if(patientid.equals("")){
				patientid=(String)bean.getPatient_ID(dispno);

			}
			String bl_interface_yn      = "Y";
			//if(patcat !=null && patcat.equals("I"))
				//bl_interface_yn      = bean.checkforbillinginterface("IP");
			//else
				//bl_interface_yn      = bean.checkforbillinginterface("OP");
			//String disp_cash_coll_stage = bean.getDispCashCollStage();Commented for EMR-12.X-Alpha-PHIS-PH-Inc#2558
			//FormStore= CommonBean.checkForNull(bean.getFromStore());
			bean.setFromStore(FormStore);
			//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
			String FacilityFlag=bean.getFacility_Flag();
			barcodeFlag = bean.getBarCodeflag((String)session.getValue("facility_id"), displocn); // Added for GHL-CRF-0413.8[IN063028]
			if(FacilityFlag.equals("")){
				FacilityFlag="N";	
			}	//Bru-HIMS-CRF-091 & SPIR-IN029957 -- Added Facility_Flag for MutiFacility
			if(eff_status.equals("E")){
				Ward_Date_From=com.ehis.util.DateUtils.convertDate(Ward_Date_From,"DMY",locale,"en");
				ward_Date_To=com.ehis.util.DateUtils.convertDate(ward_Date_To,"DMY",locale,"en");
				//parameter "patcat" added in the bellow method(bean.getWardBatchDetails) call for SRR20056-SCF-7414, Incident No. 27456
				ArrayList WardbatchDetails=bean.getWardBatchDetails(patientid,dispno,cutoff,orderid,FormStore,displocn,Ward_Date_From,ward_Date_To,From_Location,drugcode,encounter_id,patcat,rej_qty);// Added rej_qty for GHL-SCF-790 [IN:046481]
				int totalRows1=WardbatchDetails.size()/41; //changed from 37 to 39 for SKR-SCF-0393 [IN:030939] // changed from 39 to 40 for GHL-CRF-0413.8[IN063028] and 40 to 41 for ML-BRU-SCF-1842
				int disabledCount1 =0;
				bean.setStockDocType(patcat);

				if (WardbatchDetails.size()==0){
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.parent.reset();</script>
<%
				}
				else{
					ArrayList patientDetails=new ArrayList();
					patientDetails=bean.getPatientDetails(patientid);
					String patientUrl="../../ePH/jsp/ReturnMedicationPatientDetails.jsp?patient_id="+patientid+"&patient_name="+patientDetails.get(0)+"&sex="+patientDetails.get(1)+"&age="+patientDetails.get(2)+"&dispno="+dispno+"&totalRows1="+totalRows1+"&eff_status="+eff_status;
%>
					<script> 
						parent.retmedicationplineframe.location.href="<%=patientUrl%>";
					</script>
	   
					<TABLE   cellspacing="0" cellpadding="0" border="1" width = "120%">     
						<tr>
						   <%if(barcodeFlag.equals("Y")){ // Added for GHL-CRF-0413.8[IN063028] -Start %>
						    <td class='COLUMNHEADER' width=6%><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
						    <input type="checkbox" name="Selcet_chk" id="Selcet_chk" value='' onClick="SelectAll(this,'<%=totalRows1%>')"></td>
						    <%} // Added for GHL-CRF-0413.8[IN063028] -End %>
							<td class='COLUMNHEADER' width=15%><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td >
							<td class='COLUMNHEADER'  width=26%><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER'  width=10%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturningWard.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=10%><fmt:message key="Common.Return.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td >
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReasonforReturn.label" bundle="${ph_labels}"/></td> 
							<td class='COLUMNHEADER' width=6%><fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturnedQty.label" bundle="${ph_labels}"/></td > 
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td >	
							<td class='COLUMNHEADER' width=8%><fmt:message key="ePH.Acknowledge.label" bundle="${ph_labels}"/></td >
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.AcceptedQty.label" bundle="${ph_labels}"/></td > 
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.RejectedQty.label" bundle="${ph_labels}"/></td > 
							<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.BalanceQty.label" bundle="${ph_labels}"/></td > 
							<td class='COLUMNHEADER' width=16%><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
							<td class='COLUMNHEADER' width=5%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
										  
						</tr>
<%
						int rowCount=0;
						int count1=1;
						for (int i=0;i<WardbatchDetails.size();i+=41){ // Incremented 36 to 37 for AMS-SCF-0190 IN038440 // 38 to 39 for SKR-SCF-0393 [IN:030939] Changed 40 chaged for GHL-CRF-0413.8 and 40 to 41 for ML-BRU-SCF-1842
							if ( rowCount++ % 2 == 0 ){
								classvalue = "QRYEVEN" ;
							}
							else{
								classvalue = "QRYODD" ;
							}
%>
							<TR > 
							<% if(barcodeFlag.equals("Y")){ // Added for GHL-CRF-0413.8[IN063028] - Start %> 
							    <td class="<%=classvalue%>"><input type="checkbox" name="check_name<%=count1%>" id="check_name<%=count1%>" onClick="selectCheck(<%=count1%>)"></td>
							 <%} // Added for GHL-CRF-0413.8[IN063028] - End %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								<%=com.ehis.util.DateUtils.convertDate((String)WardbatchDetails.get(i+8),"DMY","en",locale)%>
								</TD>
								  <TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
									<%=WardbatchDetails.get(i)%>
<%									
									if(bean.getTradeName_Flag().equals("Y") && WardbatchDetails.get(i+36)!=null && !WardbatchDetails.get(i+36).equals("")){ // if block Added for AMS-SCF-0190 IN038440
%>
										<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=WardbatchDetails.get(i+36) %>)</label>
<%
									}
%>
									</TD>
								  
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								<%=WardbatchDetails.get(i+7)%>
								</TD>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								  <%=CommonBean.checkForNull((String)WardbatchDetails.get(i+30))%>
								</TD>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								  <%=CommonBean.checkForNull((String)WardbatchDetails.get(i+31))%>
								</TD>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
								 <%=CommonBean.checkForNull((String)WardbatchDetails.get(i+32))%>
								</TD>
<% 
								if(CommonBean.checkForNull(((String)WardbatchDetails.get(i+25))).equals("DC")){
									dis_cont_reason=CommonBean.checkForNull((String)WardbatchDetails.get(i+26));
									DISC_DATE_TIME=(String)WardbatchDetails.get(i+27);
									pract_name=CommonBean.checkForNull((String)WardbatchDetails.get(i+28));
%>
									<td>
									<!--Passed UTF-8 for prac_name,dis_cont_reason regarding incident num:26239 ==By Sandhya===03/FEB/2011  -->
									
									<label	onmouseover="changeCursor(this);" onclick="callDiscontinue('<%=java.net.URLEncoder.encode(dis_cont_reason,"UTF-8")%>','<%=DISC_DATE_TIME%>','<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>');">
									<img src='../../eCommon/images/enabled.gif'></img></label>
<%
								}
								else{
%>
									<td>&nbsp;&nbsp;</td> 
<%
								}
								// if disp-no is re-issued paint with a legend
								if(bean.checkReissued((String)WardbatchDetails.get(i+10))) {
%>
									<TD align="" style="background-color:#CC9999"><%=WardbatchDetails.get(i+17)%></TD>
<%
								}
								else {	
%>
									<TD class="<%=classvalue%>" align=""><%=WardbatchDetails.get(i+17)%></TD>
<%	
								}
%>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" nowrap>
								&nbsp;<%=bean.getUomDisplay(facility_id,WardbatchDetails.get(i+40).toString())%></td><!-- changed 16 to 40 for ML-BRU-SCF-1880 -->
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:10pt;" >
								<SELECT name="acknow_ledg<%=count1%>" id="acknow_ledg<%=count1%>" onChange = "setFieldValue(<%=WardbatchDetails.get(i+17)%>,this,<%=count1%>);">
								 <OPTION value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
								 <OPTION value="A" selected><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></OPTION>
								 <OPTION value="R"><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></OPTION>
								 <OPTION value="P"><fmt:message key="ePH.PartialAcceptReject.label" bundle="${ph_labels}"/></OPTION>									 
								</SELECT> 
								</TD>
								<% if(barcodeFlag.equals("Y")){ // if,else condition added for GHL-CRF-0413.8[IN063028] - Start %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:10pt;" >
								<input type="text" name="AcceptedQty<%=count1%>" id="AcceptedQty<%=count1%>" size="4"  maxlength="4" value = "" onKeyPress="return allowValidNumber(this,event,4,0);" onBlur = "getBalance(<%=WardbatchDetails.get(i+17)%>,this,RejectedQty<%=count1%>,BalanceQty<%=count1%>,<%=count1%>,'A')"></td>
								<%} 
								else{ %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:10pt;" >
								<input type="text" name="AcceptedQty<%=count1%>" id="AcceptedQty<%=count1%>" size="4"  maxlength="4" value = "<%=WardbatchDetails.get(i+17)%>" onKeyPress="return allowValidNumber(this,event,4,0);" onBlur = "getBalance(<%=WardbatchDetails.get(i+17)%>,this,RejectedQty<%=count1%>,BalanceQty<%=count1%>,<%=count1%>,'A')" disabled></td>
								<%}  // if,else condition added for GHL-CRF-0413.8[IN063028] - End %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:10pt;" >
								<input type="text" name="RejectedQty<%=count1%>" id="RejectedQty<%=count1%>" size="4"  maxlength="4" value = "0" onKeyPress="return allowValidNumber(this,event,4,0);" onBlur = "getBalance(<%=WardbatchDetails.get(i+17)%>,AcceptedQty<%=count1%>,this,BalanceQty<%=count1%>,<%=count1%>,'R')"disabled></td>
								<% if(barcodeFlag.equals("Y")){ // if,else condition added for GHL-CRF-0413.8[IN063028] - Start %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:10pt;" >
								<input type="text" name="BalanceQty<%=count1%>" id="BalanceQty<%=count1%>" size="4"  maxlength="4" value = "<%=WardbatchDetails.get(i+17)%>" readonly></td>
								<%} else{ %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:10pt;" >
								<input type="text" name="BalanceQty<%=count1%>" id="BalanceQty<%=count1%>" size="4"  maxlength="4" value = "0" readonly></td>
								<%} //if,else condition added for GHL-CRF-0413.8[IN063028] - End %>
								<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" >
<%
									drug_code=(String)WardbatchDetails.get(i+5);
									sal_disp_locn=(String)WardbatchDetails.get(i+4);//added for KDAH-SCF-0252 [IN:050489]
									binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);
%>
								<select name="bin_location_code<%=count1%>" id="bin_location_code<%=count1%>"  >
									<OPTION value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
<%
									 for(int j=0;j<binLocation.size();j++){
										binLocationDetails=(HashMap)binLocation.get(j);
										if(!sal_disp_locn.equals(displocn)){//FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
											if(binLocationDetails.get("Default_YN").equals("Y")){
%>
												<option value="<%=(String)binLocationDetails.get("bin_location_code")%>" selected><%=(String)binLocationDetails.get("short_desc")%></option>
<%
											}
											else{	
%>
					
												<option value="<%=(String)binLocationDetails.get("bin_location_code")%>"><%=(String)binLocationDetails.get("short_desc")%></option>
<%	     
											}
										}
										else{
											if(((String)binLocationDetails.get("bin_location_code")).equals(((String)WardbatchDetails.get(i+6)))){
%>
												<option value="<%=(String)binLocationDetails.get("bin_location_code")%>" selected><%=(String)binLocationDetails.get("short_desc")%></option>
<%
											}
											else{	
%>
												<option value="<%=(String)binLocationDetails.get("bin_location_code")%>"><%=(String)binLocationDetails.get("short_desc")%></option>
<%
											}
										}
									}//end for loop
%>
								</select>
								<img name="bin_mandatory<%=count1%>" src="../../eCommon/images/mandatory.gif" align="center"></img>
								</TD>
								<TD class="<%=classvalue%>"><font style="font-size:9;cursor:pointer" class="HYPERLINK" class="HYPERLINK" >
								<label	onmouseover="changeCursor(this);" name="checkremark" onclick="Remarks('<%=count1%>');">
								<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label></font>
								<img name="mandatory<%=count1%>" Style="visibility:hidden" src="../../eCommon/images/mandatory.gif" align="center"></img>
								</TD>
								<input type="hidden" name="remarks_desc<%=count1%>" id="remarks_desc<%=count1%>" value="" >
							</TR>
							<input type="hidden" name="returnable<%=count1%>" id="returnable<%=count1%>"  value=<%=WardbatchDetails.get(i+17)%>>
							<input type="hidden" name="doc_type<%=count1%>" id="doc_type<%=count1%>"   value="<%=WardbatchDetails.get(i+2)%>">
							<input type="hidden" name="doc_no<%=count1%>" id="doc_no<%=count1%>"     value="<%=WardbatchDetails.get(i+3)%>">
							<input type="hidden" name="store_code<%=count1%>" id="store_code<%=count1%>" value="<%=displocn%>">
							<input type="hidden" name="item_code<%=count1%>" id="item_code<%=count1%>"  value="<%=WardbatchDetails.get(i+5)%>">
							<input type="hidden" name="disp_qty<%=count1%>" id="disp_qty<%=count1%>"  value="<%=WardbatchDetails.get(i+17)%>">
							<input type="hidden" name="uom_code<%=count1%>" id="uom_code<%=count1%>"   value="<%=WardbatchDetails.get(i+40)%>"><!-- changed from 16 to 40 -->
							<input type="hidden" name="batch_id<%=count1%>" id="batch_id<%=count1%>"   value="<%=WardbatchDetails.get(i+7)%>">
							<input type="hidden" name="trade_id<%=count1%>" id="trade_id<%=count1%>"   value="<%=WardbatchDetails.get(i+9)%>">
							<input type="hidden" name="expiry_date<%=count1%>" id="expiry_date<%=count1%>"value="<%=WardbatchDetails.get(i+8)%>">
							<input type="hidden" name="returned_by<%=count1%>" id="returned_by<%=count1%>"value="<%=WardbatchDetails.get(i+31)%>">
							<input type="hidden" name="return_reason<%=count1%>" id="return_reason<%=count1%>"value="<%=WardbatchDetails.get(i+32)%>">
							<input type="hidden" name="ret_doc_no<%=count1%>" id="ret_doc_no<%=count1%>"value="<%=WardbatchDetails.get(i+33)%>">
							<input type="hidden" name="ret_doc_line_no<%=count1%>" id="ret_doc_line_no<%=count1%>"value="<%=WardbatchDetails.get(i+34)%>">
							<input type="hidden" name="dispno<%=count1%>" id="dispno<%=count1%>"value="<%=WardbatchDetails.get(i+10)%>">
							<input type="hidden" name="srlno<%=count1%>" id="srlno<%=count1%>"value="<%=WardbatchDetails.get(i+11)%>">
							<input type="hidden" name="srlnobatch<%=count1%>" id="srlnobatch<%=count1%>"value="<%=WardbatchDetails.get(i+13)%>">
							<input type="hidden" name="actualReturn<%=count1%>" id="actualReturn<%=count1%>"value="<%=WardbatchDetails.get(i+17)%>">
							<input type="hidden" name="sal_doc_srlno<%=count1%>" id="sal_doc_srlno<%=count1%>" value=<%=WardbatchDetails.get(i+12)%>>
							<input type="hidden" name="sal_bin_location_code<%=count1%>" id="sal_bin_location_code<%=count1%>" value="<%=WardbatchDetails.get(i+6)%>"> 
							<input type="hidden" name="return_reason_code<%=count1%>" id="return_reason_code<%=count1%>" value="<%=WardbatchDetails.get(i+35)%>"> 
							<input type="hidden" name="encounter_id<%=count1%>" id="encounter_id<%=count1%>" value="<%=WardbatchDetails.get(i+18)%>"> <!-- added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 -->
							<input type="hidden" name="dis_charge_ind<%=count1%>" id="dis_charge_ind<%=count1%>" value="<%=WardbatchDetails.get(i+37)%>"><!-- added for skr-scf-0591 -->
							<input type="hidden" name="modified_date<%=count1%>" id="modified_date<%=count1%>" value="<%=WardbatchDetails.get(i+38)%>"><!-- added for SKR-SCF-0393 [IN:030939] -->
							<input type="hidden" name="order_id<%=count1%>" id="order_id<%=count1%>" value="<%=WardbatchDetails.get(i+19)%>"><!-- Added for GHL-SCF-1084 -->
							<input type="hidden" name="order_line_no<%=count1%>" id="order_line_no<%=count1%>" value="<%=WardbatchDetails.get(i+20)%>"><!-- Added for GHL-SCF-1084 -->
							<input type="hidden" name="barcode_id<%=count1%>" id="barcode_id<%=count1%>" value="<%=WardbatchDetails.get(i+39)%>"><!--  Added for GHL-CRF-0413.8[IN063028] -->
<%
							count1++;
						}
%>
						<INPUT TYPE="hidden" name="totalRows1" id="totalRows1" VALUE="<%=totalRows1%>">
					</table>
<%
				}//end else
%>
				<script>
					parent.retmedicationbuttonframe.location.href="../../ePH/jsp/ReturnMedicationButton.jsp?countRows="+<%=totalRows1-disabledCount1%>;
				</script>
<%
			}
			//If Condtion Added for GHL-CRF-0413.8 START
			if(eff_status.equals("D")){	
				System.out.println("barcode"+barcode+"drugcodes"+drugcodes);
			//if is added for ghl-crf-0413.8
			if(barcodeFlag.equals("Y")){
					
					if(drugcodes.equals("") && barcode.equals("")){
							%>
							<script>alert(getMessage("PH_ATLEAST_ONE_SELECTED","PH"));</script> 
		                <%	
						}
					 else if(drugcodes.equals("") && !barcode.equals("")){
						ArrayList barcode_details=bean.getNewBarcodeArry();
						//System.err.println("@@@======"+barcode_details.get(0));
						if(barcode_details.contains(barcode)){
							batchDetails=barcode_details;
						bean.setFlag_empty(true);//added for ICN 63764
						}else{
					      
						   batchDetails= bean.getbatchdetailWithCodeFunction(patientid,"' ',",nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,barcode);
						   
						 
						}
						// batchDetails.add(barcode_details.get(0));
						  
						 //System.out.println("result"+batchDetails); 
						 int size=batchDetails.size();
						 
						 if(bean.isFlag_empty()){
							 valid_barcode=true;
							 System.out.println("drug code"+batchDetails.get(15));
							 %>
							
							 <script type="text/javascript">
							   var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
								var formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
								checkcount=formObjdrug.total_count.value;
								var drug=""+'<%=batchDetails.get(15)%>';
								//var drug="N02BA011";
								for (var i=1;i<=checkcount;i++ ){
									
									
									if(eval("formObjdrug.drug_id"+i).value == drug)  //Added for IN032747 - end
									{ 
										   eval("formObjdrug.barcode_id"+i).value=formObj.barCodeId.value;
									       if( eval("formObjdrug.check_id"+i).checked == false){
									    	   eval("formObjdrug.check_id"+i).checked=true;
									    	  
									       }
									       formObjdrug.SelectAll.disabled=true; 
									       formObj.proceed.disabled=true;//Addded for ICN 63722
									}
																		
								
								}
								formObj.barCodeId.value="";
								
								formObj.barCodeId.focus();
							   
							   
							 
							 </script>
							 <%
						 }
						 else{
							 %>
							  
								<script>alert(getMessage("NOT_A_VALID_BARCODE","PH")); 
								
							
								var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
								var formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
								checkcount=formObjdrug.total_count.value;
								
								for (var i=1;i<=checkcount;i++ ){
									
									eval("formObjdrug.check_id"+i).disabled=false;
										 formObjdrug.SelectAll.checked=false;
										 formObjdrug.SelectAll.disabled=false;
										  formObj.proceed.disabled=false;//Added for ICN
								}
								formObj.barCodeId.value="";
								
								formObj.barCodeId.focus();
								
								</script>	
				      <%
						 }

					}
					else if(!drugcodes.equals("") && !barcode.equals("")){
					
					//	batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,"",barcodeFlag);//commented for MMS-DM-CRF-0174.4
						
						batchDetails= bean.getbatchdetailWithCodeFunction(patientid,"' ',",nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,barcode);
						
						
						int size=batchDetails.size();
						 
						 if(bean.isFlag_empty()){
							 valid_barcode=true;
							 System.out.println("drug code"+batchDetails.get(15));
							 %>
							 
							 <script type="text/javascript">
							   var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
								var formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
								checkcount=formObjdrug.total_count.value;
								var drug='<%=batchDetails.get(15)%>';
								//var drug="N02BA011";
								for (var i=1;i<=checkcount;i++ ){
									
									
									if(eval("formObjdrug.drug_id"+i).value == drug)  //Added for IN032747 - end
									{ 
										   eval("formObjdrug.barcode_id"+i).value=formObj.barCodeId.value;
									       if( eval("formObjdrug.check_id"+i).checked == false){
									    	   eval("formObjdrug.check_id"+i).checked=true;
									    	  
									       }
									       formObjdrug.SelectAll.disabled=true;    
									       formObj.proceed.disabled=true;//Added for ICN 63722
									}
																		
								
								}
								formObj.barCodeId.value="";
								
								formObj.barCodeId.focus();
							   
							
							 
							 </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



							 <%
							  
						 
						 }
						 else{
							 %>
							  
								<script>alert(getMessage("NOT_A_VALID_BARCODE","PH")); 
								
							
								var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
								var formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
								checkcount=formObjdrug.total_count.value;
								
								for (var i=1;i<=checkcount;i++ ){
									
								
										
										// eval("formObjdrug.check_id"+i).checked=false;
										 eval("formObjdrug.check_id"+i).disabled=false;
										 formObjdrug.SelectAll.checked=false;
										 formObjdrug.SelectAll.disabled=false;
										  formObj.proceed.disabled=false;//Added for ICN 63722
								
								}
								formObj.barCodeId.value="";
								
								formObj.barCodeId.focus();
								</script>	
				      <%
						 }

					
					}
					else{
						
						 batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,"",barcodeFlag); // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958]
					
					%>
					<script>
							var formObjdrug=parent.retmedicationdrugframe.FormReturnMedicationDrug;
							var formObj=parent.retmedicationremarksframe.FormReturnMedicationRemarks;
							formObj.barCodeId.value="";
							
							formObj.barCodeId.focus();
							</script>	
					<%
					 }
					System.out.println(batchDetails.size()+"prathyusha");
					if(batchDetails.size()!=0   ){//  ArrayList batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo); // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958]
					bean.setStockDocType(patcat);
					int totalRows=batchDetails.size()/41; //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented 31 to 32. //35 to 36 for SKR-SCF-0591//Changed 36 38 for GHL-SCF-1084 and 40 to 41 for ML-BRU-SCF-1842
					int administred_count =0;
							
			%>
						<TABLE width="100%" align="left" cellspacing="0" cellpadding="0" border="1">
							<TR>
								<Th colspan=14 style="background-color:#FFD7D7;color:black;border-color:#FFD7D7" align="left"><fmt:message key="ePH.DispensedDrugDetails.label" bundle="${ph_labels}"/></Th>
							</TR>
							
							<TR>
							   <Td width="10%" class='COLUMNHEADER'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
							   <input type=checkbox name="SelectAll" id="SelectAll" id="SelectAll"  onClick="selectAllWithOutWardReturn(this)"></td >
							   <td class='COLUMNHEADER'  width=26%><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td >
								<td class='COLUMNHEADER' width=8%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td >
								<td class='COLUMNHEADER' width=10%><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td >  
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td >
<%
								if((FacilityFlag.equals("Y"))){
%>
									<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseFacility.label" bundle="${ph_labels}"/></td >
<%
								}
%>
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td > 
								<td class='COLUMNHEADER' width=6%><fmt:message key="Common.IssuedQuantity.label" bundle="${common_labels}"/></td >
								<td class='COLUMNHEADER' width=8%><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=12%><fmt:message key="ePH.MaxReturnQty.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturnedQuantity.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=14%><fmt:message key="ePH.ReturnedtoBinLocation.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=8%><fmt:message key="ePH.ReturnQuantity.label" bundle="${ph_labels}"/></td > 
								<td class='COLUMNHEADER' width=3%><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td >       
							</tr>
<%
							int rowCount=0;
						
							
							for (int i=0;i<batchDetails.size();i+=41){ // srice from 30 to 31 changed for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented i+=32 to i+=33.  //Incremented i+=32 to i+=33.//IN-38440 & AMS-SCF-0190.Incremented i+=33 to i+=34 //38 is changed to 40 for bar code crf ghl-crf-0413.8 and 40 to 41 for ML-BRU-SCF-1842
							//changed 36 to 38  for GHL-SCF-1084
								if ( rowCount++ % 2 == 0 ){
									classvalue = "QRYEVEN" ;
								}
								else{
									classvalue = "QRYODD" ;
								}
								if(!batchDetails.get(i+19).equals("0")){ // above if condition Commented and this one added SKR Live issue
									flag   =	true;   
									/*====================variable uom====================*/                   
									issue_qty_dtl			 =  new StringBuffer(); 
									IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM((String)batchDetails.get(i+15),displocn);

									dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
									base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
									to_store_def_issue_uom   = 	(String)batchDetails.get(i+28);
									StoreCount="0";
									if(!to_store_def_issue_uom.equals("")){	
										StoreCount="1";
									}

									drug_code=(String)batchDetails.get(i+15);
									Details=(String)batchDetails.get(i+6);
									binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);	
									sal_disp_locn = (String)batchDetails.get(i+14); //Added for  KDAH-SCF-0252 [IN:050489]

									base_to_disp_uom_equl    =	bean.getEqulValue ( (String)batchDetails.get(i+15), base_uom, (String)batchDetails.get(i+6));	
									base_to_def_uom_equl     =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, dflt_issue_uom);	
									base_to_to_store_def_uom_equl =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, to_store_def_issue_uom);
									base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); //added and commented for AAKH-SCF-0195 [IN:054909] 
									//final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl); // commented for AAKH-SCF-0195 [IN:054909] 
									final_conv_factor        =	bean.lcm( base_to_def_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0195 [IN:054909] 
									if(base_to_disp_uom_equl !=0 &&  base_to_def_uom_equl!=0 && !((String)batchDetails.get(i+21)).equals("")) //added for AAKH-SCF-0129 [IN:050557]
										issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )");
									if(base_to_disp_uom_equl != base_to_def_uom_equl){ //condition changed from != 0 to this condition
									//if(base_to_disp_uom_equl!=0 &&base_to_def_uom_equl!=0){
										if(!((String)batchDetails.get(i+21)).equals("")){						  
											if(issue_uom_by.equals("I")){
												base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); 
												if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
													final_conv_factor   =	bean.lcm( final_conv_factor,base_to_to_store_def_uom_equl);
												} 
												else{
													//final_conv_factor     =	bean.lcm( final_conv_factor,base_to_issue_uom_equl); //commented for AAKH-SCF-0129 [IN:050557]
													final_conv_factor     =	bean.lcm( base_to_disp_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0129 [IN:050557]
												}
											}	
											//issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )"); //moved above
										}
											
										 if(final_conv_factor>1){ // Added for ML-BRU-SCF-1880 - Start
											 final_conv_factor =final_conv_factor/base_to_disp_uom_equl;
										   } // Added for ML-BRU-SCF-1880 - End
									}
	/*====================variable uom====================*/
	%>
									<TR >
										<TD  class=<%=classvalue%> style="font-family:verdana;font-size:8pt;" align="right">
										<INPUT TYPE="Checkbox"  name="check_return_name<%=count%>"  id="check_return_id<%=count%>" value="N"  onClick="AssignValueWithOutWardReturn(this,'<%=count%>')">
										
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i)%>
<%
										if(bean.getTradeName_Flag().equals("Y") && batchDetails.get(i+33)!=null && !batchDetails.get(i+33).equals("")){ // if block Added for AMS-SCF-0190 IN038440
%>
											<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=batchDetails.get(i+33) %>)</label>
<%
										}
%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+1)%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;">
											<%=com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+2),"DMY","en",locale)%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+3)%>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+23)%>
										<input type="hidden" name="dispno<%=count%>"  id="dispno<%=count%>" value=<%=batchDetails.get(i+3)%>>
										</TD>
<%
										if((FacilityFlag.equals("Y"))){
%>
											<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
											<%=batchDetails.get(i+31)%>
											<input type="hidden" name="dispfacility<%=count%>" id="dispfacility<%=count%>" value=<%=batchDetails.get(i+31)%>><!--  CR-091- Added DispFacility for  Grid -->
											</TD>
<%
										}
%>										<TD  class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+4),"DMY","en",locale)%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;"  align="right" nowrap>
										<%=batchDetails.get(i+5)%>
<%
										if(issue_uom_by.equals("I")){
%>
											<br><b><%=issue_qty_dtl.toString()%><b>
<%
										}
%>
										</TD>
										<TD class="<%=classvalue%>" nowrap>
										
										<%=bean.getUomDisplay(facility_id,batchDetails.get(i+40).toString())%><!-- changed from 16 to 40 -->
										</TD>
										<TD align="right" ><%=batchDetails.get(i+19)%></TD>
<%
										// if disp-no is re-issued paint with a legend
										if(bean.checkReissued((String)batchDetails.get(i+3))) {
%>
											<TD align="right" style="background-color:#CC9999"><%=batchDetails.get(i+7)%></TD>
<%
										}
										else {	
%>
											<TD  align="right"><%=batchDetails.get(i+7)%></TD>
<%
										}
%>
										<TD>
										<select name="bin_location_code<%=count%>" id="bin_location_code<%=count%>">
<%
										for(int j=0;j<binLocation.size();j++){
											binLocationDetails=(HashMap)binLocation.get(j);
											if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
												if(binLocationDetails.get("Default_YN").equals("Y")){
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>" selected><%=(String)binLocationDetails.get("short_desc")%></option>
<%
												}
												else{	
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>"><%=(String)binLocationDetails.get("short_desc")%></option>
<%	
												}
											}
											else{
												if(((String)binLocationDetails.get("bin_location_code")).equals(((String)batchDetails.get(i+16)))){
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>" selected><%=(String)binLocationDetails.get("short_desc")%></option>
<%
												}
												else{	
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>"><%=(String)binLocationDetails.get("short_desc")%></option>
<%
												}
											}
										}//end for loop
%>
										</select>
										<img name="bin_mandatory<%=count%>"   src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
										<TD>
<% 
										if (batchDetails.get(i+11).equals("N")){
											disabledCount++;

											if(valid_barcode){
												%>
											<input type=text  maxlength='4' size='4' style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>"  disabled value="1" >}
											<% }else{%>
												<input type=text  maxlength='4' size='4' style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>"  disabled  value="" >
	<%										}

										}
										else{

											if(valid_barcode){
											%>
											<input type=text  maxlength='4' size='4' style="text-align:right" name="actualReturn<%=count%>"   id="actualReturn<%=count%>" value="<%=batchDetails.get(i+38)%>" onKeyPress="return allowValidNumber(this,event,3,0);"onblur="CheckPositiveNumber(this);checkQty(this,<%=final_conv_factor%>,<%=base_to_disp_uom_equl%>,<%=base_to_def_uom_equl%>,'<%=dflt_issue_uom%>','<%=Details%>','<%=count-1%>');StoreCheck(<%=StoreCount%>);">
											<%}else{%>
											<input type=text  maxlength='4' size='4' style="text-align:right" name="actualReturn<%=count%>"  id="actualReturn<%=count%>"  value="<%=batchDetails.get(i+38)%>" onKeyPress="return allowValidNumber(this,event,3,0);"onblur="CheckPositiveNumber(this);checkQty(this,<%=final_conv_factor%>,<%=base_to_disp_uom_equl%>,<%=base_to_def_uom_equl%>,'<%=dflt_issue_uom%>','<%=Details%>','<%=count-1%>');StoreCheck(<%=StoreCount%>);"> <!-- Value added for TFS-12410 -->
<%											}

										}
%>
										<input type=text style="width:0px" name="temp<%=i%>" id="temp<%=i%>">
										<input type="hidden" name="returnable<%=count%>" id="returnable<%=count%>" id="returnable<%=count%>" value=<%=batchDetails.get(i+19)%>>
										<input type="hidden" name="srlno<%=count%>" id="srlno<%=count%>" id="srlno<%=count%>" value=<%=batchDetails.get(i+9)%>>
										<input type="hidden" name="sal_doc_srlno<%=count%>" id="sal_doc_srlno<%=count%>" id="sal_doc_srlno<%=count%>" value=<%=batchDetails.get(i+17)%>>
										<input type="hidden" name="doc_type<%=count%>" id="doc_type<%=count%>"   value="<%=batchDetails.get(i+12)%>">
										<input type="hidden" name="doc_no<%=count%>" id="doc_no<%=count%>"     value="<%=batchDetails.get(i+13)%>">
										<input type="hidden" name="store_code<%=count%>" id="store_code<%=count%>" value="<%=displocn%>">
										<input type="hidden" name="item_code<%=count%>" id="item_code<%=count%>"  value="<%=batchDetails.get(i+15)%>">
										<input type="hidden" name="uom_code<%=count%>" id="uom_code<%=count%>"   value="<%=batchDetails.get(i+40)%>"><!-- changed from 6 to 40 -->
										<input type="hidden" name="batch_id<%=count%>" id="batch_id<%=count%>"   value="<%=batchDetails.get(i+1)%>">
										<input type="hidden" name="disp_qty<%=count%>" id="disp_qty<%=count%>"   value="<%=batchDetails.get(i+5)%>">
										<input type="hidden" name="trade_id<%=count%>" id="trade_id<%=count%>"   value="<%=batchDetails.get(i+29)%>"><!--  CR-091- Added MultiFacility flag changes.-->

										<input type="hidden" name="expiry_date<%=count%>" id="expiry_date<%=count%>"value="<%=batchDetails.get(i+2)%>">
										<input type="hidden" name="sal_bin_location_code<%=count%>" id="sal_bin_location_code<%=count%>" value="<%=batchDetails.get(i+16)%>"> 
										<input type="hidden" name="srlnobatch<%=count%>" id="srlnobatch<%=count%>" id="srlnobatch<%=count%>" value="<%=batchDetails.get(i+10)%>">
										<input type="hidden" name="final_conv_factor<%=count%>" id="final_conv_factor<%=count%>"  value="<%=final_conv_factor%>">
										<input type="hidden" name="base_to_disp_uom_equl<%=count%>" id="base_to_disp_uom_equl<%=count%>" value="<%=base_to_disp_uom_equl%>"><!--added for AAKH-SCF-0195 [IN:054909]   --> 
										<!--  CR-091- Added MultiFacility flag changes -->
										<input type="hidden" name="encounter_id<%=count%>" id="encounter_id<%=count%>" value="<%=batchDetails.get(i+30)%>"> <!-- added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 -->
										<input type="hidden" name="Sal_Facility_id<%=count%>" id="Sal_Facility_id<%=count%>" value="<%=batchDetails.get(i+32)%>"> <!--batchDetails.get(i+32) IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added-->
										<input type="hidden" name="Ord_Facility_id<%=count%>" id="Ord_Facility_id<%=count%>" value="<%=batchDetails.get(i+34)%>"> <!--batchDetails.get(i+32) IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added-->
										<input type="hidden" name="dis_charge_ind<%=count%>" id="dis_charge_ind<%=count%>" value="<%=batchDetails.get(i+35)%>"><!-- added for skr-scf-0591 -->
										<input type="hidden" name="order_id<%=count%>" id="order_id<%=count%>" value="<%=batchDetails.get(i+36)%>"><!-- Added for GHL-SCF-1084 -->
										<input type="hidden" name="order_line_no<%=count%>" id="order_line_no<%=count%>" value="<%=batchDetails.get(i+37)%>"><!-- Added for GHL-SCF-1084 -->
										<input type="hidden" name="barcode<%=count%>" id="barcode<%=count%>" value="<%=batchDetails.get(i+39)%>"><!-- Added for GHL-SCF-1084 -->
                                         <input type="hidden" name="ret_qty<%=count%>" id="ret_qty<%=count%>" value="<%=batchDetails.get(i+38)%>"><!-- Added for GHL-SCF-1084 -->
										</TD>
	<%
										order_line_staus=(String)batchDetails.get(i+27);
										dis_cont_reason=(String)batchDetails.get(i+26);
										DISC_DATE_TIME=(String)batchDetails.get(i+27);
										DISC_DATE_TIME=com.ehis.util.DateUtils.convertDate(DISC_DATE_TIME,"DMYHM","en",locale);
										pract_name=(String)batchDetails.get(i+28);

										if(((String)batchDetails.get(i+25)).equals("DC")){
	%>
											<td>
											<!--Passed UTF-8 for prac_name,dis_cont_reason regarding incident num:26239 ==By Sandhya===03/FEB/2011  -->
											<label	onmouseover="changeCursor(this);" onclick="callDiscontinue('<%=java.net.URLEncoder.encode(dis_cont_reason,"UTF-8")%>','<%=DISC_DATE_TIME%>','<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>');">
											<img src='../../eCommon/images/enabled.gif'></img></label>
	<%
										}
										else{
	%>
											<td>&nbsp;&nbsp;</td>
	<%
										}
	%>
									</TR>
	<%
								   count++;
									//document.FormReturnMedicationAction.actualReturn1.focus();
								} 
								else{
								   //count++;
								   administred_count++;
								}
								}//end for loop
	%>
							<script>
								parent.retmedicationbuttonframe.location.href="../../ePH/jsp/ReturnMedicationButton.jsp?countRows="+<%=totalRows-disabledCount%>;
							</script>
							<INPUT TYPE="hidden" name="totalrows" id="totalrows" VALUE="<%= totalRows-administred_count %>">
							<INPUT TYPE="hidden" name="remarks" id="remarks" VALUE="<%= remarks %>">
						</table>
	<%
						if(!flag){
	%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
						}
					
				%>
				
				<%
				}}
				
				else	{
                     batchDetails=bean.getBatchDetails(patientid,drugcodes,nationalid,healthcard,dispno,cutoff,orderid,FormStore,patcat,displocn, encounter_id,FacilityFlag, blDocType, blDocNo,"",barcodeFlag); // blDocType, blDocNo added for MMS-DM-CRF-0039 [IN:055958]
					bean.setStockDocType(patcat);
					int totalRows=batchDetails.size()/39; //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented 31 to 32. //35 to 36 for SKR-SCF-0591//Changed 36 38 for GHL-SCF-1084 and 38 to 39 for ML-BRU-SCF-1842
					int administred_count =0;
					if (batchDetails.size()==0){
	%>
						<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.parent.reset();</script>
	<%
					}
					else{
	%>
						<TABLE width="100%" align="left" cellspacing="0" cellpadding="0" border="1">
							<TR>
								<Th colspan=14 style="background-color:#FFD7D7;color:black;border-color:#FFD7D7" align="left"><fmt:message key="ePH.DispensedDrugDetails.label" bundle="${ph_labels}"/></Th>
							</TR>
							
							<TR>
							   <td class='COLUMNHEADER'  width=26%><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td >
								<td class='COLUMNHEADER' width=8%><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td >
								<td class='COLUMNHEADER' width=10%><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td >  
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseNo.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td >
<%
								if((FacilityFlag.equals("Y"))){
%>
									<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispenseFacility.label" bundle="${ph_labels}"/></td >
<%
								}
%>
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.DispensedDate.label" bundle="${ph_labels}"/></td > 
								<td class='COLUMNHEADER' width=6%><fmt:message key="Common.IssuedQuantity.label" bundle="${common_labels}"/></td >
								<td class='COLUMNHEADER' width=8%><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=12%><fmt:message key="ePH.MaxReturnQty.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=10%><fmt:message key="ePH.ReturnedQuantity.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=14%><fmt:message key="ePH.ReturnedtoBinLocation.label" bundle="${ph_labels}"/></td >
								<td class='COLUMNHEADER' width=8%><fmt:message key="ePH.ReturnQuantity.label" bundle="${ph_labels}"/></td > 
								<td class='COLUMNHEADER' width=3%><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td >       
							</tr>
<%
							
							int rowCount=0;
						//	int chk_c=1;
							/* if(result.size()!=0)
							{System.out.println("in new for");
							for(int i=0;i<result.size();i++){
								
							}
							} */
							for (int i=0;i<batchDetails.size();i+=39){ // srice from 30 to 31 changed for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 //IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Incremented i+=32 to i+=33.  //Incremented i+=32 to i+=33.//IN-38440 & AMS-SCF-0190.Incremented i+=33 to i+=34 and 38 to 39 for ML-BRU-SCF-1842
							//changed 36 to 38  for GHL-SCF-1084
								if ( rowCount++ % 2 == 0 ){
									classvalue = "QRYEVEN" ;
								}
								else{
									classvalue = "QRYODD" ;
								}
								flag   =	true;
								if(!batchDetails.get(i+19).equals("0")){ // above if condition Commented and this one added SKR Live issue
									flag   =	true;   
									/*====================variable uom====================*/                   
									issue_qty_dtl			 =  new StringBuffer(); 
									IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM((String)batchDetails.get(i+15),displocn);

									dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
									base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
									to_store_def_issue_uom   = 	(String)batchDetails.get(i+28);
									StoreCount="0";
									if(!to_store_def_issue_uom.equals("")){	
										StoreCount="1";
									}

									drug_code=(String)batchDetails.get(i+15);
									Details=(String)batchDetails.get(i+6);
									binLocation		 =	bean.getBinDetails(drug_code,displocn,locale);	
									sal_disp_locn = (String)batchDetails.get(i+14); //Added for  KDAH-SCF-0252 [IN:050489]

									base_to_disp_uom_equl    =	bean.getEqulValue ( (String)batchDetails.get(i+15), base_uom, (String)batchDetails.get(i+6));	
									base_to_def_uom_equl     =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, dflt_issue_uom);	
									base_to_to_store_def_uom_equl =	bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom, to_store_def_issue_uom);
									base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); //added and commented for AAKH-SCF-0195 [IN:054909] 
									//final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl); // commented for AAKH-SCF-0195 [IN:054909] 
									if(issue_uom_by.equals("I")){ //if condition added for ML-BRU-SCF-1842
										final_conv_factor        =	bean.lcm( base_to_def_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0195 [IN:054909]
									}else{
										final_conv_factor        =	bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									}
									if(base_to_disp_uom_equl !=0 &&  base_to_def_uom_equl!=0 && !((String)batchDetails.get(i+21)).equals("")) //added for AAKH-SCF-0129 [IN:050557]
										issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )");
									if(base_to_disp_uom_equl != base_to_def_uom_equl){ //condition changed from != 0 to this condition
									//if(base_to_disp_uom_equl!=0 &&base_to_def_uom_equl!=0){
										if(!((String)batchDetails.get(i+21)).equals("")){						  
											if(issue_uom_by.equals("I")){
												base_to_issue_uom_equl   = bean.getEqulValue ( (String)batchDetails.get(i+15),base_uom,(String)batchDetails.get(i+21)); 
												if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
													final_conv_factor   =	bean.lcm( final_conv_factor,base_to_to_store_def_uom_equl);
												} 
												else{
													//final_conv_factor     =	bean.lcm( final_conv_factor,base_to_issue_uom_equl); //commented for AAKH-SCF-0129 [IN:050557]
													final_conv_factor     =	bean.lcm( base_to_disp_uom_equl,base_to_issue_uom_equl);//added for AAKH-SCF-0129 [IN:050557]
												}
											}	
											//issue_qty_dtl.append("( ").append((String)batchDetails.get(i+20)).append((String)batchDetails.get(i+22)).append(" )"); //moved above
										}
								   if(final_conv_factor>1){ // Added for ML-BRU-SCF-1880 - Start
										final_conv_factor =final_conv_factor/base_to_disp_uom_equl;
								   } // Added for ML-BRU-SCF-1880 - End
											
									}
	/*====================variable uom====================*/
	%>
									<TR >
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i)%>
<%
										if(bean.getTradeName_Flag().equals("Y") && batchDetails.get(i+33)!=null && !batchDetails.get(i+33).equals("")){ // if block Added for AMS-SCF-0190 IN038440
%>
											<label class="label" style="font-size:xx-small;font-weight:normal" >(<%=batchDetails.get(i+33) %>)</label>
<%
										}
%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+1)%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;">
											<%=com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+2),"DMY","en",locale)%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+3)%>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=batchDetails.get(i+23)%>
										<input type="hidden" name="dispno<%=count%>" id="dispno<%=count%>" id="dispno<%=count%>" value=<%=batchDetails.get(i+3)%>>
										</TD>
<%
										if((FacilityFlag.equals("Y"))){
%>
											<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
											<%=batchDetails.get(i+31)%>
											<input type="hidden" name="dispfacility<%=count%>" id="dispfacility<%=count%>" id="dispfacility<%=count%>" value=<%=batchDetails.get(i+31)%>><!--  CR-091- Added DispFacility for  Grid -->
											</TD>
<%
										}
%>										<TD  class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left">
										<%=com.ehis.util.DateUtils.convertDate((String)batchDetails.get(i+4),"DMY","en",locale)%>
										</TD>
										<TD class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;"  align="right" nowrap>
										<%=batchDetails.get(i+5)%>
<%
										if(issue_uom_by.equals("I")){
%>
											<br><b><%=issue_qty_dtl.toString()%><b>
<%
										}
%>
										</TD>
										<TD class="<%=classvalue%>" nowrap>
										<%=bean.getUomDisplay(facility_id,batchDetails.get(i+38).toString())%><!--changed 6 to 38 for ML-BRU-SCF-1842 -->
										</TD>
										<TD align="right" ><%=batchDetails.get(i+19)%></TD>
<%
										// if disp-no is re-issued paint with a legend
										if(bean.checkReissued((String)batchDetails.get(i+3))) {
%>
											<TD align="right" style="background-color:#CC9999"><%=batchDetails.get(i+7)%></TD>
<%
										}
										else {	
%>
											<TD  align="right"><%=batchDetails.get(i+7)%></TD>
<%
										}
%>
										<TD>
										<select name="bin_location_code<%=count%>" id="bin_location_code<%=count%>">
<%
										for(int j=0;j<binLocation.size();j++){
											binLocationDetails=(HashMap)binLocation.get(j);
											if(!sal_disp_locn.equals(displocn)){ //FormStore changed to sal_disp_locn for  KDAH-SCF-0252 [IN:050489]
												if(binLocationDetails.get("Default_YN").equals("Y")){
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>" selected><%=(String)binLocationDetails.get("short_desc")%></option>
<%
												}
												else{	
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>"><%=(String)binLocationDetails.get("short_desc")%></option>
<%	
												}
											}
											else{
												if(((String)binLocationDetails.get("bin_location_code")).equals(((String)batchDetails.get(i+16)))){
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>" selected><%=(String)binLocationDetails.get("short_desc")%></option>
<%
												}
												else{	
%>
													<option value="<%=(String)binLocationDetails.get("bin_location_code")%>"><%=(String)binLocationDetails.get("short_desc")%></option>
<%
												}
											}
										}//end for loop
%>
										</select>
										<img name="bin_mandatory<%=count%>"   src="../../eCommon/images/mandatory.gif" align="center"></img></TD>
										<TD>
<% 
										if (batchDetails.get(i+11).equals("N")){
											disabledCount++;
%>
											<input type=text  maxlength='4' size='4' style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>"  disabled id="actualReturn<%=count%>" value="0" >
<%
										}
										else{
%>
											<input type=text  maxlength='4' size='4' style="text-align:right" name="actualReturn<%=count%>" id="actualReturn<%=count%>"   id="actualReturn<%=count%>" onKeyPress="return allowValidNumber(this,event,3,0);"onblur="CheckPositiveNumber(this);checkQty(this,<%=final_conv_factor%>,<%=base_to_disp_uom_equl%>,<%=base_to_def_uom_equl%>,'<%=dflt_issue_uom%>','<%=Details%>');StoreCheck(<%=StoreCount%>);">
<%
										}
%>
										<input type=text style="width:0px" name="temp<%=i%>" id="temp<%=i%>">
										<input type="hidden" name="returnable<%=count%>" id="returnable<%=count%>" id="returnable<%=count%>" value=<%=batchDetails.get(i+19)%>>
										<input type="hidden" name="srlno<%=count%>" id="srlno<%=count%>" id="srlno<%=count%>" value=<%=batchDetails.get(i+9)%>>
										<input type="hidden" name="sal_doc_srlno<%=count%>" id="sal_doc_srlno<%=count%>" id="sal_doc_srlno<%=count%>" value=<%=batchDetails.get(i+17)%>>
										<input type="hidden" name="doc_type<%=count%>" id="doc_type<%=count%>"   value="<%=batchDetails.get(i+12)%>">
										<input type="hidden" name="doc_no<%=count%>" id="doc_no<%=count%>"     value="<%=batchDetails.get(i+13)%>">
										<input type="hidden" name="store_code<%=count%>" id="store_code<%=count%>" value="<%=displocn%>">
										<input type="hidden" name="item_code<%=count%>" id="item_code<%=count%>"  value="<%=batchDetails.get(i+15)%>">
										<input type="hidden" name="uom_code<%=count%>" id="uom_code<%=count%>"   value="<%=batchDetails.get(i+38)%>"><!-- changed from 6 to 38 for ML-BRU-SCF-1880 -->
										<input type="hidden" name="batch_id<%=count%>" id="batch_id<%=count%>"   value="<%=batchDetails.get(i+1)%>">
										<input type="hidden" name="disp_qty<%=count%>" id="disp_qty<%=count%>"   value="<%=batchDetails.get(i+5)%>">
										<input type="hidden" name="trade_id<%=count%>" id="trade_id<%=count%>"   value="<%=batchDetails.get(i+29)%>"><!--  CR-091- Added MultiFacility flag changes.-->

										<input type="hidden" name="expiry_date<%=count%>" id="expiry_date<%=count%>"value="<%=batchDetails.get(i+2)%>">
										<input type="hidden" name="sal_bin_location_code<%=count%>" id="sal_bin_location_code<%=count%>" value="<%=batchDetails.get(i+16)%>"> 
										<input type="hidden" name="srlnobatch<%=count%>" id="srlnobatch<%=count%>" id="srlnobatch<%=count%>" value="<%=batchDetails.get(i+10)%>">
										<input type="hidden" name="final_conv_factor<%=count%>" id="final_conv_factor<%=count%>"  value="<%=final_conv_factor%>">
										<input type="hidden" name="base_to_disp_uom_equl<%=count%>" id="base_to_disp_uom_equl<%=count%>" value="<%=base_to_disp_uom_equl%>"><!--added for AAKH-SCF-0195 [IN:054909]   --> 
										<!--  CR-091- Added MultiFacility flag changes -->
										<input type="hidden" name="encounter_id<%=count%>" id="encounter_id<%=count%>" value="<%=batchDetails.get(i+30)%>"> <!-- added for SRR20056-SCF-7454 IN027501 & SRR20056-SCF-7717 IN027979 -->
										<input type="hidden" name="Sal_Facility_id<%=count%>" id="Sal_Facility_id<%=count%>" value="<%=batchDetails.get(i+32)%>"> <!--batchDetails.get(i+32) IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added-->
										<input type="hidden" name="Ord_Facility_id<%=count%>" id="Ord_Facility_id<%=count%>" value="<%=batchDetails.get(i+34)%>"> <!--batchDetails.get(i+32) IN33996-SCF:PH-Bru-HIMS-CRF-091-Issue-02, Added-->
										<input type="hidden" name="dis_charge_ind<%=count%>" id="dis_charge_ind<%=count%>" value="<%=batchDetails.get(i+35)%>"><!-- added for skr-scf-0591 -->
										<input type="hidden" name="order_id<%=count%>" id="order_id<%=count%>" value="<%=batchDetails.get(i+36)%>"><!-- Added for GHL-SCF-1084 -->
										<input type="hidden" name="order_line_no<%=count%>" id="order_line_no<%=count%>" value="<%=batchDetails.get(i+37)%>"><!-- Added for GHL-SCF-1084 -->
									
										</TD>
	<%
										order_line_staus=(String)batchDetails.get(i+27);
										dis_cont_reason=(String)batchDetails.get(i+26);
										DISC_DATE_TIME=(String)batchDetails.get(i+27);
										DISC_DATE_TIME=com.ehis.util.DateUtils.convertDate(DISC_DATE_TIME,"DMYHM","en",locale);
										pract_name=(String)batchDetails.get(i+28);

										if(((String)batchDetails.get(i+25)).equals("DC")){
	%>
											<td>
											<!--Passed UTF-8 for prac_name,dis_cont_reason regarding incident num:26239 ==By Sandhya===03/FEB/2011  -->
											<label	onmouseover="changeCursor(this);" onclick="callDiscontinue('<%=java.net.URLEncoder.encode(dis_cont_reason,"UTF-8")%>','<%=DISC_DATE_TIME%>','<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>');">
											<img src='../../eCommon/images/enabled.gif'></img></label>
	<%
										}
										else{
	%>
											<td>&nbsp;&nbsp;</td>
	<%
										}
	%>
									</TR>
	<%
								   count++;
									//document.FormReturnMedicationAction.actualReturn1.focus();
								} 
								else{
								   //count++;
								   administred_count++;
								}
							}//end for loop
	%>
							<script>
								parent.retmedicationbuttonframe.location.href="../../ePH/jsp/ReturnMedicationButton.jsp?countRows="+<%=totalRows-disabledCount%>;
							</script>
							<INPUT TYPE="hidden" name="totalrows" id="totalrows" VALUE="<%= totalRows-administred_count %>">
							<INPUT TYPE="hidden" name="remarks" id="remarks" VALUE="<%= remarks %>">
						</table>
	<%
						if(!flag){
	%>
							<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));parent.parent.reset();</script>
	<%
						} 
					}
					//}//END ELSE
				}
		}//If Condtion Added for GHL-CRF-0413.8 END// FD-Bru-HIMS-CRF-091 Changes -- Added Flag Based Functionality for MutiFacility - End //added for icn 63722
				String disp_cash_coll_stage = bean.getDispCashCollStage();//Added for EMR-12.X-Alpha-PHIS-PH-Inc#2558
%>
			<INPUT TYPE="hidden" name="eff_status" id="eff_status" VALUE="<%=eff_status%>">
			<INPUT TYPE="hidden" name="rej_qty" id="rej_qty" VALUE="<%=rej_qty%>">	<!-- // Added for GHL-SCF-790 [IN:046481] -->
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="patientid" id="patientid" VALUE="<%= patientid %>">
			<INPUT TYPE="hidden" name="drugcodes" id="drugcodes" VALUE="<%= drugcodes %>">
			<INPUT TYPE="hidden" name="disabledCoun" id="disabledCoun" VALUE="<%= disabledCount%>">
			<INPUT TYPE="hidden" name="bl_interface_yn" id="bl_interface_yn" VALUE="<%=bl_interface_yn%>">
			<INPUT TYPE="hidden" name="disp_cash_coll_stage" id="disp_cash_coll_stage" VALUE="<%=disp_cash_coll_stage%>">
			<INPUT TYPE="hidden" name="patient_class" id="patient_class" VALUE="<%=patcat%>">
			<INPUT TYPE="hidden" name="disp_locn_code" id="disp_locn_code" VALUE="<%=displocn%>">
			<INPUT TYPE="hidden" name="barcodeFlag" id="barcodeFlag" VALUE="<%=barcodeFlag%>"> <!-- Added for GHL-CRF-0413.8[IN063028] -->
			<INPUT TYPE="hidden" name="total_count" id="total_count" VALUE="<%=count-1%>"><!-- Added for GHL-CRF-0413.8[IN063028] -->
		</form>
	<!-- Added for GHL-CRF-0413.8[IN063028]  start-->
	<%if(eff_status.equals("D")){
		if(barcodeFlag.equals("Y") && !barcode.equals("") && valid_barcode){ %>
                           <script>
				              IncreseQTY('<%=barcode%>');
			                 </script>
		    <%}} %> <!-- Added for GHL-CRF-0413.8 end [IN063028] -->
<%	
			
		//} Removed for 63722
			}
		catch(Exception e){
			e.printStackTrace();
		}
		putObjectInBean(bean_id,bean,request); 
%>
	</body>
</html>


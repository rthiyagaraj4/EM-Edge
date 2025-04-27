<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, eST.*,ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
19/06/2020	  	IN073154	     	Manickavasagam 		  								MMS-JU-SCF-0148
31/8/2020		IN073827			Shazana									MMS-DM-CRF-0174.4/03- Enter Valid or Invalid Barcode no response from system															

05/07/2021		TFS:20163			Manickavasagam					ML-MMOH-SCF-1834
--------------------------------------------------------------------------------------------------------------
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
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/dchk.js"></script> -->
		<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		String title = java.net.URLDecoder.decode(request.getParameter("title"),"UTF-8");
%>
		<title><%=title%></title>
	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="MedicationAdministrationFTRemarks" id="MedicationAdministrationFTRemarks" >
<%
		String row_no		= request.getParameter("row_no");
		String mandCheck	= request.getParameter("mandCheck")==null?"":request.getParameter("mandCheck");
		String drug_code	= request.getParameter("drug_code");
		String drug_name    = request.getParameter("drug_name");
		String auth_req_yn	= request.getParameter("auth_req_yn");
		String drugtype		= request.getParameter("drugtype");
		String freq_code	= request.getParameter("freq_code");
		String no_of_doses	= request.getParameter("no_of_doses");	
		String dosage_seq	= request.getParameter("dosage_seq");
		String order_id     = request.getParameter("order_id");
		String order_line_num     = request.getParameter("order_line_num");
		String encounter_id = request.getParameter("encounter_id");

		String sch_date_time= request.getParameter("sch_date_time");		//added for SCF-7528
		String admin_date_time=request.getParameter("admin_date_time");		//added for SCF-7528
		String admin_date_time_lim="";										//added for SCF-7528

		String iv_prep_yn	= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String MfrYN	= request.getParameter("MfrYN")==null?"N":request.getParameter("MfrYN");
		String admn_dose_chng_reason_yn = request.getParameter("admn_dose_chng_reason_yn")==null?"N":request.getParameter("admn_dose_chng_reason_yn");
		String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
		String assign_bed_num = request.getParameter("assign_bed_num")==null?"":request.getParameter("assign_bed_num");
		String nursing_unit = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
		String scheKey = request.getParameter("scheKey")==null?"":request.getParameter("scheKey");
		String couldNotAdmin = request.getParameter("couldNotAdmin")==null?"":request.getParameter("couldNotAdmin");
		String admin_recorded_yn = request.getParameter("admin_recorded_yn")==null?"":request.getParameter("admin_recorded_yn");//CRF 24
		String administered = request.getParameter("administered")==null?"":request.getParameter("administered");//CRF 24
		String admin_discontinue = request.getParameter("admin_discontinue")==null?"":request.getParameter("admin_discontinue");//SKR-CRF-0037
		String batchid_disable = request.getParameter("batch_disable")==null?"":request.getParameter("batch_disable");// Added for AAKH-CRF-0084 [IN060429] 
		String fromAdmin= request.getParameter("fromAdmin")==null?"N":request.getParameter("fromAdmin");//added for MMS-KH-CRF-0010
		if(admin_discontinue.equals("Y"))
			mandCheck = "Y";
		if(no_of_doses==null)
			no_of_doses	=	"";
		if(dosage_seq==null)
			dosage_seq	=	"";	

		int dose_comp	=	0;

		if(!no_of_doses.equals("") && !dosage_seq.equals("") && MfrYN.equals("N") ) {
			dose_comp	=	Integer.parseInt(no_of_doses)	-	Integer.parseInt(dosage_seq);	
		}

		String bean_id		= "MedicationAdministrationFTBean";
		String bean_name	= "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean bean	= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );	
		bean.setLanguageId(locale);
		String bean_id_1	= "MedicationAdministrationBean";
		String bean_name_1	= "ePH.MedicationAdministrationBean";
		MedicationAdministrationBean bean_1	= (MedicationAdministrationBean)getBeanObject( bean_id_1, bean_name_1, request );	
		bean_1.setLanguageId(locale);

		bean_1.setReasonCodes();
		bean_1.setAdimnReasonCodes();//ADDED FOR MMS-KH-CRF-0010
		boolean site_spec_yn	= bean.isSiteSpecific("PH", "VERIFY_ADM_DRUG");//PMG2017-MMS-CRF-0002
		String user_id= (String) session.getValue("login_user");
		String user_id_name= (String) session.getValue("appl_user_name");

		HashMap reason_code;//MODIFIED FOR MMS-KH-CRF-0010
boolean viewAdminRemarks = bean.isSiteSpecific("PH","VIEW_ADMIN_REMARKS");//ADDED FOR MMS-KH-CRF-0010
		boolean mandCheckFlag = false;//MMS-JU-SCF-0148
		if(fromAdmin.equals("Y") && viewAdminRemarks ){
		//	mandCheck = "Y"; //commented for MMS-JU-SCF-0148
			mandCheckFlag = true; ////MMS-JU-SCF-0148
			reason_code= bean_1.getAdimnReasonCodes();	
		}
		else{
			reason_code= bean_1.getReasonCodes();
		}
		HashMap drug_remarks	  = bean.getRemarksForDrug(); 

		String freq_nature		  =	bean.getFrequencyNature(freq_code);	
		String next_schd_date	  ="";
		//Adding start for MMS-DM-CRF-157.1
		Boolean bar_code_scan_site = bean.isSiteSpecific("AM", "BARCODE_SCANNING_APPLICABLE");
				String bar_code_scan_site_YN = "";
				
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
//Ading end for MMS-DM-CRF-157.1
//Adding start for MMS-DM-CRF-0170
			ArrayList patient_data = new ArrayList();
			String facility_id   = (String)session.getValue( "facility_id" );
			String patient_id ="";
			String act_patient_class ="";
			String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for MMS-DM-CRF-0170.1
			if(bar_code_scan_site_YN.equals("Y")){
			
				patient_data =bean.getEncounterPatientClass(facility_id,encounter_id);
				if(patient_data.size()>0){
					patient_id =(String)patient_data.get(0);
					act_patient_class =(String)patient_data.get(1);
				}

				ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(act_patient_class,"MEDICATION_ADMINISTRATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
			}
//Adding end for MMS-DM-CRF-170
		if(!dosage_seq.equals("")){
		   //next_schd_date	  =	bean.getNextSchdate(order_id,"1",Integer.parseInt(dosage_seq));
		   next_schd_date	  =	bean.getNextSchdate(order_id,"1",Integer.parseInt(dosage_seq),sch_date_time); //added for SCF-7528
			if(!(locale.equals("en"))){//added for IN27410 - SCF 7372 -  --19/05/2011-- priya
				 next_schd_date = com.ehis.util.DateUtils.convertDate(next_schd_date, "DMYHM","en", locale);
			} 
		}
		String key                = "";
		StringTokenizer stKey     = null;
		String existing_drug_code = "";
		String existing_row_no    = "";
		ArrayList arr_list_remarks= new ArrayList();	
		String str_reason_code	  = "";
		String remarks	          = "";
		String administered_by    = "";
		String authorized_by      = "";
		String authorized_by_id   = "";
		String orig_user_pin      = "";
		String next_admin_time	  = "";
		String admn_dose_chng_reason	= "";
		String admn_dose_chng_reason_code	= "";
		if(drug_remarks.size()>0){
			Set keyset = drug_remarks.keySet() ;
			Iterator keyiterator= keyset.iterator() ;		
			while(keyiterator.hasNext()){
				key   = (String)keyiterator.next();
				stKey = new StringTokenizer(key,"$");
				while(stKey.hasMoreTokens()){
					existing_drug_code = (String)stKey.nextToken();
					existing_row_no    = (String)stKey.nextToken();
					if(existing_drug_code.equals(drug_code) && existing_row_no.equals(row_no)){
						arr_list_remarks = (ArrayList)drug_remarks.get(key);
						if(arr_list_remarks!=null && arr_list_remarks.size()>0){
							str_reason_code	 = (String)arr_list_remarks.get(0);
							remarks			 = (String)arr_list_remarks.get(1);
							admn_dose_chng_reason_code = (String)arr_list_remarks.get(5);
							admn_dose_chng_reason	=	(String)arr_list_remarks.get(6);
							administered_by  = (String)arr_list_remarks.get(2);
							if(administered_by!=null && !administered_by.equals("")){
								user_id = administered_by;
								user_id_name =bean.getSMUserName(administered_by);
							}
							authorized_by_id = (String)arr_list_remarks.get(3);
							if(authorized_by_id!=null && !authorized_by_id.equals("")){
								authorized_by =bean.getSMUserName(authorized_by_id);
								orig_user_pin=bean.getPinNumber(authorized_by_id);
							}
							next_admin_time	 = (String)arr_list_remarks.get(4);
							//user_id			 = administered_by;
						}
					}
				}
			}
		}

		if(!next_admin_time.equals("")) {		
			if(!(locale.equals("en"))){//added for IN27410 - SCF 7372 -  --19/05/2011-- priya
				 next_admin_time = com.ehis.util.DateUtils.convertDate(next_admin_time, "DMYHM","en", locale);
			} 
			next_schd_date	=	next_admin_time;
		}
		ArrayList remarks1=null;
		remarks1=bean.getRemarksForDrug(drug_code,row_no); 
		if(remarks1 != null)
			remarks=(String)((bean.getRemarksForDrug(drug_code,row_no)).get(1))==null?"":(String)((bean.getRemarksForDrug(drug_code,row_no)).get(1)); 

		//added for AAKH-CRF-0024 [IN:038260] Starts	
		ArrayList nonAdminRemarks = null;
		String non_adm_remarks = "";
		String non_adm_code = "";
		String non_adm_code_desc = "";
		if(admin_recorded_yn.equals("Y") && administered.equals("N")){
			nonAdminRemarks = bean.getNonAdminRemarks(drug_code,dosage_seq,encounter_id,order_id,sch_date_time);
			if(nonAdminRemarks!=null && nonAdminRemarks.size()>0){
				non_adm_remarks = (String) nonAdminRemarks.get(0);
				non_adm_code = (String) nonAdminRemarks.get(1);
				non_adm_code_desc =(String) nonAdminRemarks.get(2);
			} 
		}
		//added for AAKH-CRF-0024 [IN:038260] Ends
%>
		<table cellpadding="0" cellspacing="0" width="99%" align="center" border="0">
<%
			String disable_reason_codes = "";
			String reason_code_yn       = "Y"; //ML-MMOH-SCF-1834
			if( !mandCheck.equals("Y")  && !mandCheckFlag ){//mandCheckFlag added for MMS-JU-SCF-0148
				disable_reason_codes ="style='display:none'";
				reason_code_yn = "N"; //ML-MMOH-SCF-1834
			}
%>
			<tr>
<%
				if(!(iv_prep_yn.equals("0")||iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6"))){
%>
					<td  class="label"  ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
<%
				}
				else{
%>	
					<td  class="label"  ><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></td>
<%
				}
%>
				<td  class="label"><b><%=drug_name%></b></td>
			</tr>
<%
			if(null!=non_adm_remarks && null!=non_adm_code_desc && !"".equals(non_adm_remarks) && !"".equals(non_adm_code_desc) ){ //added for AAKH-CRF-0024 [IN:038260] Starts
%>
				<tr>
					<td class="label"  ><label><fmt:message key="ePH.CouldNotAdminister.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/></label>
					<td class="label"  > <%=non_adm_code_desc %></td>
					</td>
				</tr>
				<tr>
					<td class="label"  ><label><fmt:message key="ePH.CouldNotAdminister.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label>
					<td class="label"  > <%=non_adm_remarks %></td>
					</td>
				</tr>
<%
			} //added  for AAKH-CRF-0024 [IN:038260] Ends
%>	
			<tr>
				<td class="label"  ><label <%=disable_reason_codes%>>
<%
					if(admin_discontinue.equals("Y")){
%>
						<fmt:message key="ePH.Administered.label" bundle="${ph_labels}"/>&nbsp;
<%
					}
%>
				<fmt:message key="Common.reason.label" bundle="${common_labels}"/></label></td>
				<td class="label"><select name="reason_code" id="reason_code" <%=disable_reason_codes%> onchange="getAdminRemarks(MedicationAdministrationFTRemarks,'<%=fromAdmin%>')"><!--fromAdmin ADDED FOR MMS-KH-CRF-0010-->
<%
				if(mandCheck!=null && mandCheck.equals("N") && !mandCheckFlag){//mandCheckFlag added for MMS-JU-SCF-0148
%>
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
				}
				else{
					Set keyset = reason_code.keySet() ;
					Iterator keyiterator= keyset.iterator() ;
					String desc     = "";
					String selected = "";
					while(keyiterator.hasNext()){
						key = (String)keyiterator.next();
						desc= (String)reason_code.get(key);
						if(key !=null && key.equals(str_reason_code)){
							selected = "selected";
						}
						else{
							selected = "";
						}

						if(remarks.equals("")) {
							remarks	=	bean.getAdrRemarks(key,"M")==null?"":bean.getAdrRemarks(key,"M");
						}
						if(fromAdmin.equals("Y") && remarks.equals("") ){//added for MMS-KH-CRF-0010
							remarks	=	bean.getAdrRemarks(key,"MR")==null?"":bean.getAdrRemarks(key,"MR");
						}
%>
						<option value="<%=key%>" <%=selected%>><%=desc%></option>
<%
					}
				}
%>
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" <%=disable_reason_codes%>></img>
				</td>
			</tr>
			<% if(batchid_disable.equals("enabled") || batchid_disable.equals("disabled")){ // added for AAKH-CRF-0084 - Start and !iv_prep_yn.equals("9") && !iv_prep_yn.equals("7")  removed and modified for MMS-KH-CRF-0017.1
			//(!iv_prep_yn.equals("7") || !iv_prep_yn.equals("8")) added for MMS-KH-CRF-0017 and !iv_prep_yn.equals("0") && !iv_prep_yn.equals("9") removed for MMS-KH-CRF-0017.1 and MMS-KH-CRF-0017.1 reverted 5/23/2019
			%>
			<tr>  
			<td  class="label"><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
			<td class="label"><input type="text" name="non_iv_admin_batch_id" id="non_iv_admin_batch_id" size="20" maxlength="40" value="" onkeydown ='barcodeScanApp_YN(event,this)' onblur="validateBatchId(this,'<%=order_id%>','<%=order_line_num%>','<%=site_spec_yn%>','<%=drug_code%>','<%=iv_prep_yn%>');" <%=batchid_disable%>><img src="../../eCommon/images/mandatory.gif" align="center" ></img> <!-- PMG2017-MMS-CRF-0002 site_spec_tn and drug_code added for PMG2017-MMS-CRF-0002 iv_prep_yn Added for MMS-KH-CRF-0017 --><!-- onkeydown ='barcodeScan(event,this)' added for MMS-DM-CRF-0157.1, changed method name barcodeScanApp_YN for IN073827 -->
			<input type='checkbox' id="consumption_recorded_checkbox" onclick="if(document.getElementById("non_iv_admin_batch_id").disabled=this.checked) getElementById("non_iv_admin_batch_id").value='';" <%=batchid_disable%> ><fmt:message key="ePH.ConsumptionRecord.label" bundle="${ph_labels}"/></td>
			</tr>
			<%} // added for AAKH-CRF-0084 - End  %>
			<tr>
				<td class="label"  ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class="label"  ><textarea rows="4" cols="41" name="remarks" onKeyPress="return(checkMaxLimit(this,200));" onBlur="callCheckMaxLen(this,200,' Remarks ')"><%=remarks%></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" ></img><!-- Changed from 255 to 200 for ML-BRU-SCF-1310 [IN:048724] -->
				</td>
			</tr>
<%
			if(admn_dose_chng_reason_yn.equals("Y") || admn_dose_chng_reason_yn.equals("E")){
%>
				<tr>
					<td class="label"  nowrap><fmt:message key="ePH.ChangedAdminDosageReason.label" bundle="${ph_labels}"/></td>
					<td class="label" ><input type="text" name="chngd_admn_dose_reason" id="chngd_admn_dose_reason" onBlur="searchReason(this,chngd_admn_dose_reason_code)"  maxlength="30" size="30" value="<%=admn_dose_chng_reason%>"><input type="button" class="button" name="btnCADR" id="btnCADR" value="?" onClick="searchReason(chngd_admn_dose_reason, chngd_admn_dose_reason_code)" >
					<img src="../../eCommon/images/mandatory.gif" align="center" ></img>		
					<input type="hidden" name="chngd_admn_dose_reason_code" id="chngd_admn_dose_reason_code" value="";
					</td>
				</tr>
<%
			}
%>
			<tr>
				<td class="label"  ><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
				<td class="label"><input type="text" name="administered_by" id="administered_by" maxlength="30" size="30" value="<%=user_id_name%>"><input type="hidden" name="administered_by_id" id="administered_by_id" maxlength="30" size="30" value="<%=user_id%>"><input type="button" class="button" name="btnAdminBy" id="btnAdminBy" value="?" onClick="searchCode(administered_by,'A')"><!--hidden field is newly added for RUT-SCF-0093 -->
					<img src="../../eCommon/images/mandatory.gif" align="center" ></img>			
				</td>
			</tr>
<%
			if(auth_req_yn!=null && auth_req_yn.equals("Y") && !mandCheck.equals("Y")){//added mandCheck for AAKH-CRF-0024 [IN:038260]
%>
				<tr>
					<td class="label" ><fmt:message key="ePH.Witnessedby.label" bundle="${ph_labels}"/></td>
					<td class="label"><input type="text" name="authorized_by" id="authorized_by" maxlength="30" size="30" value="<%=authorized_by%>"><input type="button" class="button" name="btnAuthBy" id="btnAuthBy" value="?" onClick="searchCode(authorized_by,'W')">
						<img src="../../eCommon/images/mandatory.gif" align="center" ></img>			
					</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
					<td class="label"><input type="password" name="user_pin" id="user_pin" size="30" maxlength="60" value=""><img src="../../eCommon/images/mandatory.gif" align="center"></img>			
					</td>
				</tr>
<%
				} 
				if(freq_nature.equals("C") && drugtype.equals("IV") && dose_comp>0) { 
%>	
					<tr>
						<td class="label" ><fmt:message key="ePH.NextAdministrationDate/Time.label" bundle="${ph_labels}"/></td>
						<td class="label"><input type="text" name="next_admin" id="next_admin" maxlength="16" size="13" value="<%=next_schd_date%>" onBlur="validateTime(this,'<%=locale%>')"></td>
					</tr>
<%		
				}	
%>
				<tr>
					<td colspan="2" align='right'>
						<input type="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="saveRemarksForDrug('<%=mandCheck%>','<%=row_no%>','<%=drug_code%>','<%=auth_req_yn%>','<%=order_id%>','<%=order_line_num%>','<%=encounter_id%>','<%=admn_dose_chng_reason_yn%>','<%=batchid_disable%>','<%=patient_id%>','<%=act_patient_class%>','<%=scan_count_required_yn%>','<%=alert_required_yn%>','<%=remarks_required_yn%>')"> &nbsp;&nbsp;&nbsp;</td><!--patient_id,act_patient_class,scan_count_required_yn,alert_required_yn,remarks_required_yn added for MMS-DM-CRF-0170  -->
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="orig_user_pin" id="orig_user_pin" value="<%=orig_user_pin%>">
			<input type="hidden" name="authorized_by_id" id="authorized_by_id" value="<%=authorized_by_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="sch_date_time" id="sch_date_time" value="<%=sch_date_time%>"> <!--added for SCF-7528-->
			<input type="hidden" name="admin_date_time_lim" id="admin_date_time_lim" value="<%=next_schd_date%>"> <!--added for SCF-7528-->
			<input type="hidden" name="callFrom" id="callFrom" value="<%=callFrom%>"> 
			<input type="hidden" name="assign_bed_num" id="assign_bed_num" value="<%=assign_bed_num%>"> 
			<input type="hidden" name="nursing_unit" id="nursing_unit" value="<%=nursing_unit%>"> 
			<input type="hidden" name="dosage_seq" id="dosage_seq" value="<%=dosage_seq%>"> 
			<input type="hidden" name="scheKey" id="scheKey" value="<%=scheKey%>"> 
			<input type="hidden" name="couldNotAdmin" id="couldNotAdmin" value="<%=couldNotAdmin%>"> 
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="non_iv_admin_batch_id" id="non_iv_admin_batch_id" value="">
			<input type="hidden" name="admin_discontinue" id="admin_discontinue" value="<%=admin_discontinue%>">
			<input type="hidden" name="SQL_PH_MED_ADMIN_APPL_USERS" id="SQL_PH_MED_ADMIN_APPL_USERS" value="<%=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_APPL_USERS")%>">
			<input type="hidden" name="ADMIN_DOSAGE_CHNG_REASON_CODES" id="ADMIN_DOSAGE_CHNG_REASON_CODES" value="Select reason_code code, reason_desc description from PH_MEDN_TRN_REASON_LANG_VW  where appl_trn_type ='DM' and eff_status ='E'  and upper(reason_code) like upper(?) and upper(reason_desc) like upper(?) and language_id =">
			 <input type='hidden' name='bar_code_scan_site_YN' id='bar_code_scan_site_YN' value='<%=bar_code_scan_site_YN%>'><!--Added for MMS-DM-CRF-157.1-->
            <input type='hidden' name='bar_code_scaned_YN' id='bar_code_scaned_YN' value=''><!--Added for MMS-DM-CRF-157.1-->
			
			<input type='hidden' name='reason_code_yn' id='reason_code_yn' value="<%=reason_code_yn%>"> <!-- added for ML-MMOH-SCF-1834-->
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>


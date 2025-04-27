<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, eST.*,ePH.*, ePH.Common.*, eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>

<%
 	request.setCharacterEncoding("UTF-8");

		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends

	String locale = (String) session.getAttribute("LOCALE");
	String login_user		=	(String)session.getValue("login_user");
	String bean_id							= "MedicationAdministrationFTBean";
	String bean_name						= "ePH.MedicationAdministrationFTBean";
	MedicationAdministrationFTBean bean		= (MedicationAdministrationFTBean)getBeanObject( bean_id, bean_name, request );
	bean.setLanguageId(locale);
	String login_user_desc	=	bean.getSMUserName(login_user);
	//out.println(login_user);
		
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String linkValue=request.getParameter("linkValue");
	String drugdesc=request.getParameter("drugdesc")==null?"":request.getParameter("drugdesc");
	String current_dt_time=request.getParameter("current_date_time")==null?"":request.getParameter("current_date_time");
	String validateTime1=request.getParameter("validateTime1")==null?"":request.getParameter("validateTime1");
	String validateTime2=request.getParameter("validateTime2")==null?"":request.getParameter("validateTime2");
	String sch_date_time=request.getParameter("sch_date_time");		//added SCF-7528
	String linkValueString="";
	String calendar_displaystyle="visibility:visible;display:inline";
	String date_disabled="";
	String mandatory_remarks="style=display:none";
	String displayFlowRate ="style=display:none";
	String MFR_flow_rate =request.getParameter("MFR_flow_rate")==null?"":request.getParameter("MFR_flow_rate");
	String flowRateDurationUnitDesc =request.getParameter("flowRateDurationUnitDesc")==null?"":request.getParameter("flowRateDurationUnitDesc");
	String infusion_vol_str_unit_desc =request.getParameter("sch_infusion_vol_str_unit_desc")==null?"":request.getParameter("sch_infusion_vol_str_unit_desc"); // sch_infusion_vol_str_unit chanegd to sch_infusion_vol_str_unit_desc for SKR-SCF-0215 [IN:029303]
	String h_iv_admin_qty =request.getParameter("h_iv_admin_qty")==null?"":request.getParameter("h_iv_admin_qty");
	String callfrom =request.getParameter("callfrom")==null?"":request.getParameter("callfrom");
	String batch_id =request.getParameter("batch_id")==null?"":request.getParameter("batch_id");
	String expiry_date ="";//request.getParameter("expiry_date")==null?"":request.getParameter("expiry_date");
	String trade_id =request.getParameter("trade_id")==null?"":request.getParameter("trade_id");
	String trade_name =request.getParameter("trade_name")==null?"":request.getParameter("trade_name");
	String iv_Auto_Admin =request.getParameter("iv_Auto_Admin")==null?"":request.getParameter("iv_Auto_Admin");
	String patient_id =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String drug_code =request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String admin_from_date =request.getParameter("admin_from_date")==null?"":request.getParameter("admin_from_date");
	String admin_to_date =request.getParameter("admin_to_date")==null?"":request.getParameter("admin_to_date");
	String order_id =request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_num =request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String Store_locn_code =request.getParameter("Store_locn_code")==null?"":request.getParameter("Store_locn_code");
	String dosage_type =request.getParameter("dosage_type")==null?"":request.getParameter("dosage_type");
	String iv_admin_qty =request.getParameter("iv_admin_qty")==null?"":request.getParameter("iv_admin_qty");
	String iv_qty_uom =request.getParameter("iv_qty_uom")==null?"":request.getParameter("iv_qty_uom");
	String iv_bin_code =request.getParameter("iv_bin_code")==null?"":request.getParameter("iv_bin_code");
	String mar_iv_compl_dt_ind =request.getParameter("mar_iv_compl_dt_ind")==null?"":request.getParameter("mar_iv_compl_dt_ind");
	String iv_infusion_period =request.getParameter("iv_infusion_period")==null?"":request.getParameter("iv_infusion_period");
	String iv_prep_yn =request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String displayBatch ="display:none", auto_Admin_dis="", displayFlowCahnge="display:none";
	ArrayList iv_batch_ids = new ArrayList();
	if(linkValue.equals("ST"))
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Start.label","common_labels");
	else if(linkValue.equals("HO")){
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hold.label","common_labels");
		mandatory_remarks="";
	}
	else if(linkValue.equals("RE")){			
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Resume.label","ph_labels");
		displayFlowRate="";
	}
	else if(linkValue.equals("CO")){
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.complete.label","common_labels");
		if(!callfrom.equals("SCH") ){
			date_disabled ="disabled";
			calendar_displaystyle="visibility:hidden;display:none";
		}
		else{
			if(mar_iv_compl_dt_ind.equals("I")){
				date_disabled ="disabled";
				calendar_displaystyle="visibility:hidden;display:none";
			}
			if(iv_prep_yn.equals("5"))
				displayBatch="display:inline";
			iv_batch_ids =bean.getAllBatchIDS(order_id,order_line_num,"N");
			if(iv_batch_ids==null || iv_batch_ids.size()==0){
				if(iv_Auto_Admin.equals("N"))
					auto_Admin_dis="disabled";
				else 
					auto_Admin_dis="";
			}
			else if(iv_batch_ids.size()==9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
				batch_id = (String)iv_batch_ids.get(0);
				expiry_date = (String)iv_batch_ids.get(1);
				trade_id	= (String)iv_batch_ids.get(2);
				trade_name  = (String)iv_batch_ids.get(3);
				auto_Admin_dis="disabled";
				float returned_qty=0, tot_administered_qty=0, ret_qty=0;
				ArrayList totQty =(ArrayList)bean.getTotQty(patient_id,drug_code,admin_from_date,admin_to_date,order_id,order_line_num);
				for(int j=0;j<totQty.size();j=j+4){
					returned_qty = (Float)totQty.get(j+2);
					tot_administered_qty=  (Float)totQty.get(j+3);
					ret_qty=returned_qty-tot_administered_qty;							 
				}
				if(ret_qty<=0){
					batch_id = (String)iv_batch_ids.get(0);
					expiry_date = (String)iv_batch_ids.get(1);
					trade_id	= (String)iv_batch_ids.get(2);
					trade_name  = (String)iv_batch_ids.get(3);
				}
				else{
					batch_id = "";
					expiry_date = "";
				}
			}
		}
	}
	else if(linkValue.equals("CH")){
		linkValueString=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.change.label","common_labels");
		//calendar_displaystyle="visibility:hidden;display:none";
		//date_disabled ="disabled";
		mandatory_remarks="";
		displayFlowCahnge="display:inline";
	}

	String title = linkValueString+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MFR.label","ph_labels");
	
	if(!locale.equals("en")){ //Added below if condition for SKR-SCF-0913[Inc : 46556]
		 current_dt_time=com.ehis.util.DateUtils.convertDate(current_dt_time,"DMYHM","en",locale);
		 sch_date_time=com.ehis.util.DateUtils.convertDate(sch_date_time,"DMYHM","en",locale);
	 }
%>
	<title><%=title%></title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
		function returnStatus(btn){
			if(btn=="ok"){
				var frmobjRem=document.MedicationAdministrationFTMFRRemarks;
				var linkValue=frmobjRem.linkValue.value;
				var callfrom=frmobjRem.callfrom.value;
				var validateTime1=frmobjRem.validateTime1.value;
				var validateTime2=frmobjRem.validateTime2.value;
				var obj=frmobjRem.admin_date_time;
				
				var actiontime=obj.value;
				var locale=frmobjRem.locale.value;
				//if(actiontime!="")                                                 // Commented for LEAP-INT-PH-SCF-14813 [IN057865]
					//actiontime=convertDate(actiontime,"DMYHM",locale,"en"); 
				if(locale!="en")   // if block Added for LEAP-INT-PH-SCF-14813 [IN057865]
					actiontime=convertDate(actiontime,"DMYHM",locale,"en");    
			
				var timeMsg=getMessage("PH_ACTION_DATE_TIME_BETWEEN_CURR_DATE_TIME",'PH');
				var timeMsg1=getMessage("PH_ACTION_DATE_TIME_SHOULD_BE_GREATER",'PH');
				var timeMsg2=getMessage("PH_ACTION_DATE_TIME_SHOULD_BE_LESS",'PH');
				var timeMsg3=getMessage("ACTION_BY_CANNOT_BLANK",'PH');
				var timeMsg4=getMessage("CURRENT_TIME_SHOULD_BE_GREATER",'PH');
				if(actiontime!=""){
					if(validateTime1!="" && validateTime2!=""){	
						if(!isBetween(validateTime1, validateTime2, actiontime, 'DMYHM', "en")){     // locale changed to "en" for LEAP-INT-PH-SCF-14813 [IN057865]
							timeMsg=timeMsg.replace('$',convertDate(validateTime1,"DMYHM","en",locale));
							timeMsg=timeMsg.replace('#',convertDate(validateTime2,"DMYHM","en",locale));
							alert(timeMsg);
							if(linkValue!="CO"){
								obj.value = convertDate(validateTime1,"DMYHM","en",locale);
								obj.focus();
							}	
							return false;
						}																
					}
					else if(validateTime1!=""){
						if(!isBefore(validateTime1,actiontime,'DMYHM',locale)){
							timeMsg1=timeMsg1.replace('$',convertDate(validateTime1,"DMYHM","en",locale));
							alert(timeMsg1);
							if(linkValue!="CO"){
								obj.value = convertDate(validateTime1,"DMYHM","en",locale);
								obj.focus();
							}
							return false;
						}

					}
					else if(validateTime2!=""){ 
						//Added !(not)IsBefore  Regarding incident num:24297 on 15/Oct/2010 ==By Sandhya
						if(!isBefore(actiontime,validateTime2,'DMYHM', 'en')){	//locale	
							timeMsg2=timeMsg2.replace('$',convertDate(validateTime2,"DMYHM","en",locale));
							if(linkValue!="CO"){
								obj.value = convertDate(validateTime2,"DMYHM","en",locale);
								obj.focus();
								alert(timeMsg2);
								window.close();
								return false;
							}
							else {//
								//if (callfrom!="SCH"){
									timeMsg4=timeMsg4.replace('$',convertDate(actiontime,"DMYHM","en",locale));
									alert(timeMsg4);
									window.close();
									return false;
								//}
							}
						}
					}
				}
				if(frmobjRem.admin_by.value=="" || frmobjRem.admin_by.value==" "){ //replaced administered_by_id with admin_by for IN24890 --15/11/2010-- priya
					timeMsg3=timeMsg3.replace('$',frmobjRem.linkValueString.value);
					alert(timeMsg3);
					return false;
				}
				var rem=frmobjRem.remarks.value;
				if(linkValue=="HO")	{
					if(rem=="")	{
						alert(getMessage("PH_MANDATORY",'PH'));
						return false;
					}
				}
				var retVal=new Array();
				retVal[0]=frmobjRem.linkValue.value;
				retVal[1]=frmobjRem.administered_by_id.value;
				retVal[2]=actiontime;
				if(rem!="")
					rem=encodeURIComponent(rem,"UTF-8");
				retVal[3]=rem;
				if(linkValue=="RE"){
					if(frmobjRem.Remarks_MFR_flow_rate.value==""){
						alert(getMessage("PH_ENTER_FLOW_RATE","PH"));
						return false;
					}
					else if(parseFloat(frmobjRem.Remarks_MFR_flow_rate.value)==0){
						alert(getMessage("PH_ENTER_VALID_FLOW_RATE","PH"));						
						return false;
					}
					/*else{
						if(parseFloat(frmobjRem.Remarks_MFR_flow_rate.value)>parseFloat(frmobjRem.h_iv_admin_qty.value)){
							//alert(getMessage("PH_ENTER_VALID_FLOW_RATE","PH"));						
							alert("Flow Rate cannot be greater than the total Volume");
							return false;
						}
					}*/
				}
				if(linkValue=="CH"){
					var ch_flow_rate_from = frmobjRem.ch_flow_rate_from.value;
					var ch_flow_rate_to = frmobjRem.ch_flow_rate_to.value;
					var remarks			= frmobjRem.remarks.value;//Added for SKR-SCF-0913[Inc:46556]
					if(ch_flow_rate_to==""){
						alert(getMessage("PH_ENTER_FLOW_RATE","PH"));
						return false;
					}
					else if(parseFloat(ch_flow_rate_to)==0 || parseFloat(ch_flow_rate_from)==parseFloat(ch_flow_rate_to)){
						alert(getMessage("PH_ENTER_VALID_FLOW_RATE","PH"));						
						return false;
					}
					if(remarks==""){//Added if condition for SKR-SCF-0913[Inc:46556]
					   	alert(getMessage("REMARKS_CAN_NOT_BE_BLANK","PH"));
						return false;
					}
					retVal[4]=ch_flow_rate_to;
				}
				else
					retVal[4]=frmobjRem.Remarks_MFR_flow_rate.value;

				if(callfrom=="SCH" && linkValue=="CO"){
					retVal[5]=frmobjRem.iv_batch_id.value;
					retVal[6]=frmobjRem.iv_expiry_date.value;
					retVal[7]=frmobjRem.iv_trade_id.value;
					retVal[8]=frmobjRem.iv_trade_name.value;
					retVal[9]=frmobjRem.iv_qty_in_disp_mode.value;
				}
				window.returnValue = retVal;
			}
			window.close();
		}
		</script>
	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="MedicationAdministrationFTMFRRemarks" id="MedicationAdministrationFTMFRRemarks" >
				<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
					<tr>
						<td class="label" width='25%'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
						<td class="label" colspan='3' width='75%'>&nbsp;<b><%=drugdesc%></b></td>
					</tr>
					<tr style='<%=displayBatch%>'>
						<td class="label" width='20%'><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
						<td  class="label" width='30%'>
<%
						if(iv_batch_ids == null || iv_batch_ids.size() <= 9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
%>
							<input type="text" id="iv_batch_id"  name="iv_batch_id" id="iv_batch_id" size="9" maxlength="10" value="<%=batch_id%>" style="font-size:11;" disabled >
							<input type="button" class="button" value="?" <%=auto_Admin_dis%>  onClick="calcQuantityInDispensingUOM('IVSCH', '1');callMednBatchSearch('iv_batch_id','iv_expiry_date','iv_trade_name','iv_trade_id','iv_bin_code','<%=drug_code%>','','iv_infusion_period','<%=Store_locn_code%>','IVSCH','')" id="iv_batch_id_but" name="iv_batch_id_but" >
<%
						}
						else{
%>
							<select id="iv_batch_id" name="iv_batch_id" id="iv_batch_id" style="font-size:11;" onChange="assignBatchDetails('SCH','IV',this)">
							<option value="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%
							for (int kk=0;kk<iv_batch_ids.size();kk=kk+9){//changed 4 to 6 for CRF-413.8 and 7 to 9 for GHL-CRF-0482
%>
								<option value="<%=(String)iv_batch_ids.get(kk)%>"><%=(String)iv_batch_ids.get(kk)%></option>
<%
							} 
%>
							</select>
<%
						}
%>
						</td>
						<td class="label" width='20%'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
						<td  class="label" width='30%'><input type="text" name="iv_expiry_date" id="iv_expiry_date" size="9" maxlength="10" disabled value="<%=expiry_date%>"></td>
						<input type="hidden" name="iv_bin_code" id="iv_bin_code" value="<%=iv_bin_code%>">
						<input type="hidden" name="iv_trade_id" id="iv_trade_id" value="<%=trade_id%>">
						<input type="hidden" name="iv_trade_name" id="iv_trade_name" value="<%=trade_name%>" >
						<input type="hidden" name="iv_dosage_type" id="iv_dosage_type" value="<%=dosage_type%>">
						<input type="hidden" name="order_line_num" id="order_line_num" value="<%=order_line_num%>">
						<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
						<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
						<input type="hidden" name="iv_admin_qty" id="iv_admin_qty" value="<%=iv_admin_qty%>">
						<input type="hidden" name="iv_qty_uom" id="iv_qty_uom" value="<%=iv_qty_uom%>">
						<input type="hidden" name="iv_qty_in_disp_mode" id="iv_qty_in_disp_mode" value="">
						<input type="hidden" name="iv_infusion_period" id="iv_infusion_period" value="<%=iv_infusion_period%>">
				 </tr>
				 <tr <%=displayFlowRate%>>
					 <td class="label"><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/></td>
					 <td class="label" colspan='3'><input type="text" value="<%=MFR_flow_rate%>" name="Remarks_MFR_flow_rate" size=2 maxlength=9 class="number" style="font-size:11;color:blue" onKeyPress="return allowValidNumber(this,event,6,2);"><b><label style="font-size:10;"><%=java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")%>/<%=flowRateDurationUnitDesc%></label></b></td>
				 </tr>
				 <tr style='<%=displayFlowCahnge%>'>
					 <td class="label" width='20%'><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					 <td class="label" width='30%'><input type="text" value="<%=MFR_flow_rate%>" name="ch_flow_rate_from"class="number" style="font-size:11;color:blue" disabled size='5'><b><!--Increased Size from 3 to 5 for SKR-SCF-0913[Inc 46556] --><label style="font-size:10;">&nbsp; <%=java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")%>/<%=flowRateDurationUnitDesc%></label></b></td>
					 <td class="label" width='20%'><fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					 <td class="label" width='30%'><input type="text" value="" name="ch_flow_rate_to" id="ch_flow_rate_to" size='3' maxlength='9' class="number" style="font-size:11;color:blue" onKeyPress="return allowValidNumber(this,event,6,2);"><img src="../../eCommon/images/mandatory.gif" align="center" ></img><b>&nbsp;<label style="font-size:10;"><%=java.net.URLDecoder.decode(infusion_vol_str_unit_desc,"UTF-8")%>/<%=flowRateDurationUnitDesc%></label></b></td>
				 </tr>
				 <tr>
					 <td class="label"  ><%=linkValueString%> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					 <td class="label" colspan='3' ><textarea rows="4" cols="43" name="remarks" onKeyPress="return(checkMaxLimit(this,255));" onBlur="callCheckMaxLen(this,255,' Remarks ')"></textarea><img src="../../eCommon/images/mandatory.gif" align="center" <%=mandatory_remarks%>></img></td>
				 </tr>
				 <tr>
					 <td class="label"><%=linkValueString%> <fmt:message key="ePH.By.label" bundle="${ph_labels}"/></td>
					 <td class="label" colspan='3'><input type="text" name="admin_by" id="admin_by" maxlength="30" size="30" value="<%=login_user_desc%>" onBlur="if(this.value!='' ) searchUser(this,'<%=linkValue%>');"><input type="button" class="button" name="btnAdminBy" id="btnAdminBy" value="?" onClick="searchUser(document.MedicationAdministrationFTMFRRemarks.admin_by,'<%=linkValue%>')">
					<img src="../../eCommon/images/mandatory.gif" align="center" ></img></td>
				</tr>
				 
				 <tr>
					 <td class="label"><%=linkValueString%> <fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
					 <td class="label" colspan='3'><input type="text" name="admin_date_time" id="admin_date_time" maxlength="16" size="15" value="<%=current_dt_time%>" onChange="validateTime(this,'<%=locale%>');" <%=date_disabled%>> &nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='adm_dt_cal' onClick=" showCalendar('admin_date_time',null,'hh:mm');" style="<%=calendar_displaystyle%>" ></td><!--commented com.ehis.util.DateUtils.convertDate(current_dt_time,"DMYHM","en",locale) SKR-SCF-0913[Inc : 46556]-->
				 </tr>
				 <tr>
					<td class="button" colspan="4" align='center'>
						<input type="button" name="btnOK1" id="btnOK1" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="returnStatus('ok');">&nbsp;
						<input type="button" name="btnCANCEL1" id="btnCANCEL1" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="returnStatus('cancel');">
					</td>
				</tr>
			 </table>
			<input type="hidden" name="linkValue" id="linkValue" value="<%=linkValue%>">
			<input type="hidden" name="linkValueString" id="linkValueString" value="<%=linkValueString%>">
			<input type="hidden" name="locale" id="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="administered_by_id" id="administered_by_id" id="administered_by_id" value="<%=login_user%>">
			<input type="hidden" name="validateTime1" id="validateTime1" id="validateTime1" value="<%=validateTime1%>">
			<input type="hidden" name="validateTime2" id="validateTime2" id="validateTime2" value="<%=validateTime2%>">
			<input type="hidden" name="SQL_PH_MED_ADMIN_APPL_USERS" id="SQL_PH_MED_ADMIN_APPL_USERS" value="<%=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_APPL_USERS")%>">
			<input type="hidden" name="h_iv_admin_qty" id="h_iv_admin_qty" value="<%=h_iv_admin_qty%>">
			<input type="hidden" name="sch_date_time" id="sch_date_time" value="<%=sch_date_time%>">	<!-- added for SCF-7528-->
			<input type="hidden" name="callfrom" id="callfrom" value="<%=callfrom%>">

		</form>
	</body>
</html>


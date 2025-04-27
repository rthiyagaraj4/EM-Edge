<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 endss
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>	
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="javascript"	 src="../../eCommon/js/DateUtils.js"></script> 
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body>
<%
		try{
			String	bean_id		=	"DispMedicationBean" ;
			String	bean_name	=	"ePH.DispMedicationBean";	
			DispMedicationBean bean	= (DispMedicationBean)getBeanObject(bean_id,bean_name,request);
			bean.setLanguageId(locale);
			String	bean_id_2	=	"DispMedicationAllStages" ;
			String	bean_name_2	=	"ePH.DispMedicationAllStages";	
			DispMedicationAllStages bean_2	= (DispMedicationAllStages)getBeanObject(bean_id_2,bean_name_2, request);
			bean_2.setLanguageId(locale);
			String bean_id_3	= "DirectDispensingBean" ;
			String bean_name_3	= "ePH.DirectDispensingBean";
			DirectDispensingBean bean_3 = (DirectDispensingBean)getBeanObject(bean_id_3,bean_name_3,request);
			bean_3.setLanguageId(locale);
			
			String flag						= request.getParameter("flag");
		   // String label_format				= request.getParameter("label_format");
			String bal_sheet				= request.getParameter("bal_sheet");
			String disp_sheet				= request.getParameter("disp_sheet");
			String login_user				= request.getParameter("login_user");
			String facility_id				= request.getParameter("facility_id");	
			String Disp_label_yn			= request.getParameter("Disp_label_yn");	
			String med_plan				= request.getParameter("med_plan");//Added med_plan  for  ML-BRU-CRF-072[Inc:29938]
			 String sShowButtons			= request.getParameter("buttons")==null?"":" style='display:none' ";  //newly added for CRF-0067
			String encounter_id				= request.getParameter("encounterId");// Added encounterId for HSA-CRF-0113 [IN:048166]
			String patient_class			=  bean_3.getPatientClass();	
			ArrayList disp_locns            = new ArrayList();
			String dis_loc_code				= bean_3.getDispLocnCode();// bean_3.getOrdLocn() Changed for HSA-CRF-0113 [IN:048166] 
			String nextBmsDispLocn			= 	bean_2.getDefaultBmsCollDispLoc(dis_loc_code);// Added for HSA-CRF-0113 [IN:048166] 
			
			if(dis_loc_code==null){
			  dis_loc_code="";
			}

			String patient_id               = bean_3.getPatientID();
			String visible1					= "";
			
			ArrayList facilitys				= null;
			ArrayList reffacilitys			= null;
			HashMap facility				= null;
			HashMap reffacility				= null;

			String SQL_PH_DISP_PRACT_REFERRAL_SELECT=PhRepository.getPhKeyValue("SQL_PH_DISP_PRACT_REFERRAL_SELECT");
			
			String bal_sheet_status			=	"";
			String disp_sheet_status		=	"";
			String disp_label_status		=	"";
			String select_loc_lang_status	=	"";
			String order_id					=	"";
			String order_line_no			=	"";
			String pres_date				=	"";
			String visible					=	"";
			String srl_no					=	"";
			String enable_tab				=   "N";		
			String sDfltLangForDispLblBmsLbl = "E";
			//String dflt_lang_for_disp_label = bean.getDefaultLanguageForDispenseLabel(patient_class);
			String dflt_lang_for_disp_label = bean.getDefaultLanguageForDispenseLabel(patient_id);
			String newlang                   = "";               //Code For Bru-HIMS-CR-075 Start
			String localLang                 = "";
			ArrayList langIdName             = new ArrayList();   //Code For Bru-HIMS-CR-075 End

			String default_english ="selected",default_loc_lang="",default_both_lang="";
				
			if(dflt_lang_for_disp_label.equals("L")){
				default_english ="";
				default_loc_lang="selected";
				sDfltLangForDispLblBmsLbl = "L";
			}
			/*if(bal_sheet.equals("N"))
				bal_sheet_status		="disabled";
			else*/
			bal_sheet_status		="checked";

			if(disp_sheet.equals("N")){
				disp_sheet_status		="disabled";
				//default_english ="";
				//default_loc_lang="";
				//default_both_lang="";
			}
			else
				disp_sheet_status		="checked";

			if(Disp_label_yn.equals("N")){
				disp_label_status		="disabled";	
				select_loc_lang_status  ="disabled";
			}
			else{
				disp_label_status		="checked";
			}
			enable_tab				 = flag;
			visible					 = "true";		 
			disp_locns				 = bean_2.getDispenseLocns();
			ArrayList alBMSReasons = bean_2.getBMSReasons(locale);
			String bmsReasonVisible = "hidden";
			
			if(!locale.equals("en")){// Code Override For FD-Bru-HIMS-CRF-075  Start
				langIdName = bean_2.getLangNameAndId(locale);
			}
			else{
				newlang = bean_2.getSMLOcalLanguageID();
				langIdName = bean_2.getLangNameAndId(newlang);
			}
			if(langIdName!=null && langIdName.size()>0)
				localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);	// Code Override For FD-Bru-HIMS-CRF-075 End 	
%>
			<form name="DispMedicationPrintDialog" id="DispMedicationPrintDialog">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="tab">
					<tr>
						
						<td   width="100%"class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS');calltable('print_report');checkBMSTab('print_report');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" name="print_report"><fmt:message key="ePH.PrintReports.label" bundle="${ph_labels}"/> </a></td>
<%
						if(enable_tab.equals("Y") && !(encounter_id==null || encounter_id.equals("") || encounter_id.equals("11111")) ){
%>
						
							<td   width="100%" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS');calltable('bal_med_dtl');checkBMSTab('bal_med_dtl');" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" ><fmt:message key="ePH.BalanceMedicationDetail.label" bundle="${ph_labels}"/> </a></td>
<%
						}
						else{
%>
							<td  width="10%">&nbsp;</td>
<%
						}
%>
					</tr>
				</table>

				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id ="print_report_table"style="<%=visible1%>">
					<TR>
						<td colspan="5" height="20">&nbsp;&nbsp;<td>
					</TR>
					<tr>
						<td class="label" ><fmt:message key="ePH.DispensingSheet.label" bundle="${ph_labels}"/>  </td>
						<td ><input type="checkbox" name="disp_sheet" id="disp_sheet" <%=disp_sheet_status%>></td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.DispenseLabel.label" bundle="${ph_labels}"/>  </td>
						<td ><input type="checkbox" name="disp_label" id="disp_label" <%=disp_label_status%> ></td>
						<td class="label" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.LabelLanguage.label" bundle="${ph_labels}"/>  &nbsp;&nbsp;
						<select name="printDialogLang" id="printDialogLang" <%=select_loc_lang_status%> ><!-- changeLanguage() is newly added for CRF-0075 by manickam-->
<% 
						if(select_loc_lang_status.equals("disabled")){
%>
							<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>   
<%
						}
						else{
							if(localLang!=null && !localLang.equals("")){
%>
		  
							<option value="L" <%=default_loc_lang%>><%=localLang%> </option><!--Code Added For FD-Bru-HIMS-CRF-075 Start -->
<%
						}
%>
						<option value="E" <%=default_english%>><fmt:message key="Common.English.label" bundle="${common_labels}"/> </option>
<%
						}
%>
						<!--Code Added For FD-Bru-HIMS-CRF-075 End -->
						<!-- <option value="B" ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>  </option>-->
						</select>
						</td><!--newly added for RUT-CRF-0067 -->
					</tr>
					<!--ML-BRU-CRF-072[Inc:29938]--Start-->
<%
					String dispMedPlan="none";
					/*if(med_plan.equals("Y")){
						dispMedPlan = "inline";
					}*/ //commented for Bru-HIMS-CRF-072.1 [IN:049144]
%>
					<tr id='medPlanRep' style='display:<%=dispMedPlan%>;'>
						<td class="label" ><fmt:message key="ePH.MedicationPlanSheet.label" bundle="${ph_labels}"/> </td>
						<td><input type="checkbox" checked name="med_plan" id="med_plan"></td>
						<td >&nbsp;</td>
					</tr><!--ML-BRU-CRF-072[Inc:29938]--End -->
					<tr>
						<td  class="label" ><fmt:message key="ePH.PrintPrescription.label" bundle="${ph_labels}"/></td>
						<td  colspan='2'><input type="checkbox" name="print_pres" id="print_pres" ></td>
					</tr>
					<TR>
						<td colspan="5" height="20">&nbsp;&nbsp;<td>
					</TR>
					<tr><!--newly added sShowButtons for RUT-CRF-0067 -->
						<td colspan="3" class="white" align="right" <%=sShowButtons%>><input type="button" class="button" name="printOK" id="printOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/> ' onClick="printOnlineDispense(document.DispMedicationPrintDialog,'OK');parent.window.returnValue='OK'"><input type="button" class="button" <%=sShowButtons%>  value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="printOnlineDispense(document.DispMedicationPrintDialog,'CANCEL');parent.window.returnValue='OK';"></td>
					</tr>
					<tr><td class="white" colspan="4"></td></tr>
					<tr><td class="white" colspan="4"></td></tr>
					<tr><td class="white" colspan="4"></td></tr>
					<tr><td class="white" colspan="4"></td></tr>
					<tr><td class="white" colspan="4"></td></tr>
				</table>
				<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="Bal_Med_table" style="visibility:hidden">
					<tr>
						<td class="label"  > <fmt:message key="ePH.BalanceMedicationSheet.label" bundle="${ph_labels}"/> </td>
						<td >&nbsp;&nbsp;<input type="checkbox" name="bal_sheet" id="bal_sheet" <%=bal_sheet_status%>></td>
						<td>&nbsp;</td>
						<!--Code Added For FD-Bru-HIMS-CRF-075 Start -->
						<td class="label" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.LabelLanguage.label" bundle="${ph_labels}"/>  &nbsp;&nbsp;
						<select name="bmsTabLang" id="bmsTabLang" >
							<option value="E" <%=default_english%>> <fmt:message key="Common.English.label" bundle="${common_labels}"/></option>
<%
							if(localLang!=null && !localLang.equals("")){
%>
								<option value="L" <%=default_loc_lang%>> <%=localLang%></option>
<%
							}
%>
						   <!-- <option value="B" > Both</option> -->
						</select><!--Code Added For FD-Bru-HIMS-CRF-075 End -->
						</td>   
					</tr>
					<tr>
						<td class="label" > <fmt:message key="ePH.NextCollectionDetail.label" bundle="${ph_labels}"/>  </td>
						<td  class="label"><input type="radio" name="curr_facility" id="curr_facility" value="C" onclick="callfacillity(this)" checked><fmt:message key="ePH.CurrentFacility.label" bundle="${ph_labels}"/></td>
						<td  class="label"><input type="radio" name="curr_facility" id="curr_facility" value="E" onclick="callfacillity(this)"><fmt:message key="Common.externalfacility.label" bundle="${common_labels}"/></td>
						<td ></td> 
					</tr>
				</table>
				<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="curr_facility_table" style="visibility:hidden">
					<th  colspan="4" ><fmt:message key="ePH.CurrentFacilityDetail.label" bundle="${ph_labels}"/></th>
					<TR>
						<td colspan="4" height="20">&nbsp;&nbsp;<td>
					</TR>
					<tr>
						<td class="label" colspan=""><label  ><fmt:message key="ePH.NextCollectionDate.label" bundle="${ph_labels}"/> </label></td>
						<td>		<input type="text" name="next_collection_date1" id="next_collection_date1"  size="8" maxlength="10"    onBlur="CheckDate(this);checkSysDate(sysdate,next_collection_date1,pres_date);" ><INPUT  TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"  id="Calendar" onclick="return showCalendar('next_collection_date1');" > <img src="../../eCommon/images/mandatory.gif" align=center></img>
					   </td> 
						<td class="label"  colspan='' ><fmt:message key="ePH.NextCollectionFrom.label" bundle="${ph_labels}"/></td>
						<td><select name="disp_locations" id="disp_locations">
							<option>---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<% 
							for(int i=0; i<disp_locns.size(); i+=2){
								if( nextBmsDispLocn==null || nextBmsDispLocn.equals("")){//If condition & Else Added for HSA-CRF-0113 [IN:048166] 
									if( dis_loc_code.equals((String)disp_locns.get(i))){
%>
										<option value="<%=(String)disp_locns.get(i)%>" selected><%=(String)disp_locns.get(i+1)%></option>
<%
									}
									else {	
%>
										<option value="<%=(String)disp_locns.get(i)%>"><%=(String)disp_locns.get(i+1)%></option>
<%
									}
								}
								else{
									if( nextBmsDispLocn.equals((String)disp_locns.get(i))) {
%>
										<option value="<%=(String)disp_locns.get(i)%>" selected><%=(String)disp_locns.get(i+1)%></option>
<%
									}
									else{	
%>
										<option value="<%=(String)disp_locns.get(i)%>"><%=(String)disp_locns.get(i+1)%></option>
<%
									}
								}
							}
%>
							</select>
						   <img src="../../eCommon/images/mandatory.gif" align=center></img>
							</td>
						</tr>
						<TR id='trCurBMSReason' style="visibility:hidden;">
<%
							if(alBMSReasons!=null && alBMSReasons.size()>0)
								bmsReasonVisible = "visible";
							else
								bmsReasonVisible = "hidden";
%>
							<td class="label" ><fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></td>
							<td>
								<select name="CurbmsReason" id="CurbmsReason" >
									<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									if(alBMSReasons!=null && alBMSReasons.size()>0){
										for(int indx=0; indx<alBMSReasons.size(); indx+=2){
%>
											<option value="<%=(String)alBMSReasons.get(indx)%>"><%=(String)alBMSReasons.get(indx+1)%></option>
<%
										}
									}
%>
									</select>
								<td>
									<input type='hidden' name='curBMSReasonVisibility' id='curBMSReasonVisibility' value='<%=bmsReasonVisible%>'>
								<td colspan="2" >&nbsp;&nbsp;<td>
							</TR>
						</table>
						<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="extr_facility_table" style="visibility:hidden">
							<th colspan="5"><fmt:message key="ePH.ExternalFacilityDetail.label" bundle="${ph_labels}"/></th>
							<TR>
								<td colspan="5" height="20">&nbsp;&nbsp;<td>
							</TR>
							<tr><td class="label" > <fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
<% 
							facilitys=bean.getRefFacility(); 
							if(facilitys!=null && facilitys.size() > 1 ){
%>
								<TD COLSPAN="2" >
								&nbsp;<SELECT name="referral_facility" id="referral_facility" onChange="disable_facility(this,referral_location)">
								<OPTION VALUE="">---- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ----</OPTION>	
<%
								for(int t=0;t<facilitys.size();t++){
									facility=(HashMap)facilitys.get(t);
%>
									<OPTION  VALUE='<%=facility.get("FACILITY_ID")%> '><%=facility.get("FACILITY_NAME") %></OPTION>
<%
								}
%>
								</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
<%
							}
							else {
								if(facilitys!=null && facilitys.size() > 0 )						
									facility=(HashMap)facilitys.get(0);
%>
								<td><input type="text" size="15" name="referral_facility" id="referral_facility" disabled value='<%=facility.get("FACILITY_NAME")%>'>
									<input type="hidden"  value='<%=facility.get("FACILITY_ID")%>'>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
								</td>
<%
							}
%>
						</TD>
<% 
						reffacilitys=bean.getAmRefFacility();
						if(reffacilitys!=null && reffacilitys.size() > 0 ){
%>
							<TD COLSPAN="2" class='label'><fmt:message key="Common.OtherFacility.label" bundle="${common_labels}"/>&nbsp;
							<SELECT name="referral_location" id="referral_location" onChange="disable_facility1(this,referral_facility)">
							<OPTION VALUE="">---- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ----</OPTION>	
<%
							for(int t=0;t<reffacilitys.size();t++){
							   reffacility=(HashMap)reffacilitys.get(t);
%>
								<OPTION  VALUE='<%=reffacility.get("REFERRAL_CODE")%>'><%=reffacility.get("SHORT_DESC") %></OPTION>
<%
							}
%>
							</SELECT>&nbsp;</TD>
<%
						}
						else {
%>
							<td class="label"  nowrap><fmt:message key="Common.OtherFacility.label" bundle="${common_labels}"/></td>
							<td>&nbsp;&nbsp;<input type="text" size="15"   maxlength="10" name="referral_location" id="referral_location"onblur="disable_facility1(this,referral_facility)">&nbsp;</td>
<%
						}
%>
					</tr>
					<tr>	
						<td class="label" ><label  ><fmt:message key="ePH.NextCollectionDate.label" bundle="${ph_labels}"/></label> </td>
						<td>&nbsp;<input type="text" name="next_collectiondate" id="next_collectiondate"  size="8" maxlength="10"    onBlur="CheckDate(this);checkSysDate(sysdate,next_collectiondate,pres_date);" ><INPUT  TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif"  id="Calendar" onclick="return showCalendar('next_collectiondate');" > <img src="../../eCommon/images/mandatory.gif" align=center   ></img>
						</td>
						<td class="label"colspan="3">&nbsp;</td>
					</tr> 
					<TR id='trExtBMSReason' style="visibility:hidden;">
<%
						if(alBMSReasons!=null && alBMSReasons.size()>0)
							bmsReasonVisible = "visible";
						else
							bmsReasonVisible = "hidden";
%>
						<td class="label"><fmt:message key="ePH.BalanceMedicationRemarks.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<select name="ExtbmsReason" id="ExtbmsReason" >
							<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
							if(alBMSReasons!=null && alBMSReasons.size()>0){
								for(int indx=0; indx<alBMSReasons.size(); indx+=2){
%>
									<option value="<%=(String)alBMSReasons.get(indx)%>"><%=(String)alBMSReasons.get(indx+1)%></option>
<%
								}
							}
%>
							</select>
						</td>
						<td class="label"colspan="3">&nbsp;</td>
						<input type='hidden' name='extBMSReasonVisibility' id='extBMSReasonVisibility' value='<%=bmsReasonVisible%>'>
					</TR>
					 <tr>
						<td class="label"  name="referral_remarks"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						<td colspan="4" >&nbsp;<textarea size="555" name="referral_remarks" cols="60" rows="8"></textarea>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG></td>
					</tr> 
					 <tr >
							<td  class="label" align="right"><fmt:message key="ePH.ReferedBy.label" bundle="${ph_labels}"/></td>
							<td  colspan="1">&nbsp;<input type="text" name="practioner_name" id="practioner_name" maxlength="40" size="20" value="" readonly><input type="button" class="button" value="?" name="practioner_search" id="practioner_search" onclick="parent.searchPractioner(this);">
							<input type="hidden" name="practioner_id" id="practioner_id" value=""><img src="../../eCommon/images/mandatory.gif" ID="mand1" > </td>
							 <td  class="label" COLSPAN='3'><fmt:message key="ePH.PrintExternalPrescription.label" bundle="${ph_labels}"/> 
							<input type="checkbox" name="print_extr_pres" id="print_extr_pres"></td>
							<td  class="label" COLSPAN='2'></TD>

					</tr>	
					<TR>
						<td colspan="5" height="20">&nbsp;&nbsp;<td>
					</TR>	
				</table>
				<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="extr_facility_btn_table" style="visibility:hidden">
					 <tr><!-- name added for RUT-CRF-0067-->
						<td  colspan="5" class="white"  align="right"><input type="button" name="recordButton" id="recordButton" class="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onClick="setOrOrder(document.DispMedicationPrintDialog)"><input type="button" class="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="reset_table(document.DispMedicationPrintDialog)"></td>
					</tr>
				</table>
				<input type="hidden" name="login_user" id="login_user"			value="<%=login_user%>">
				<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id%>">
				<input type="hidden" name="order_id" id="order_id"			value="<%=order_id%>">
				<input type="hidden" name="order_line_no" id="order_line_no"		value="<%=order_line_no%>">
				<input type="hidden" name="patient_id" id="patient_id"			value="<%=patient_id%>">
				<input type="hidden" name="patient_class" id="patient_class"		value="<%=patient_class%>">
				<input type="hidden" name="disp_locn" id="disp_locn"			value="<%=dis_loc_code%>">
				<input type="hidden" name="sysdate" id="sysdate"				value="<%=bean_2.getCurrDate()%>">
				<input type="hidden" name="bean_id_2" id="bean_id_2"			value="<%=bean_id_2%>">
				<input type="hidden" name="bean_name_2" id="bean_name_2"			value="<%=bean_name_2%>">
				<input type="hidden" name="pres_date" id="pres_date"			value="<%=pres_date%>">
				<input type="hidden" name="visible" id="visible"				value="<%=visible%>">
				<input type="hidden" name="srl_no" id="srl_no"				value="<%=srl_no%>">	
				<input type="hidden" name="enable_tab" id="enable_tab"			value="<%=enable_tab%>">		
				<input type="hidden" name="SQL_PH_DISP_PRACT_REFERRAL_SELECT" id="SQL_PH_DISP_PRACT_REFERRAL_SELECT" value="<%=SQL_PH_DISP_PRACT_REFERRAL_SELECT%>">
				<input type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
<%
				if(locale.equals("en")){
%>
					<INPUT TYPE="hidden" name="defaultLanguage" id="defaultLanguage" Value="E">
<%	
				}
				else { 
%>
					<INPUT TYPE="hidden" name="defaultLanguage" id="defaultLanguage" Value="L">
<% 
				}
%>
			</form>
<%
			putObjectInBean(bean_id,bean,request);
			putObjectInBean(bean_id_2,bean_2,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
	</body>
</html>


<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
	    request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
    	String locale			= (String)session.getAttribute("LOCALE");
        String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" SRC="../../ePH/js/EditDispLabel.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
		String facility_id		= (String) session.getValue( "facility_id" );
		String dispense_no = (String) request.getParameter("dispense_no")==null?"":request.getParameter("dispense_no");
		//String dispense_date_time = (String) request.getParameter("dispense_date_time")==null?"":request.getParameter("dispense_date_time");
		String bean_id = "EditDispLabelBean" ;
		String bean_name = "ePH.EditDispLabelBean";
		EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		String remark_selected ="";
		int no_of_records = 0, record_count=0;
		String allow_edit_disp_label = bean.getAllowEditDispLabel();  //Added for Bru-HIMS-CRF-414 [IN045554] -start
		String labelLangId = bean.getEditableLabelLangId();
		String editLabelDisp = "display:none", nonEditLanelDisp="display:inline";
		if(allow_edit_disp_label.equals("Y")){
			editLabelDisp = "display:inline";
			nonEditLanelDisp="display:none";
		} //added for Bru-HIMS-CRF-414 [IN:045554]-end
		HashMap labels				= (HashMap) bean.loadLabels();

		ArrayList	cautions		= (ArrayList) labels.get("caution");
		ArrayList	spl_instruction = (ArrayList) labels.get("spl_instruction");
		//Following Variables are declared for SRR20056-SCF-6260[Incident No.25586]
		String beanobj_id				=	"DispMedicationAllStages" ;
		String beanobj_name			=	"ePH.DispMedicationAllStages";
		DispMedicationAllStages beanobj = (DispMedicationAllStages)getBeanObject( beanobj_id, beanobj_name, request);
		beanobj.setLanguageId(locale);		
		String loc_lang_from_tab      ="";
		loc_lang_from_tab = beanobj.getSMLOcalLanguageID();
		int iLabelPairs = 0;
		HashMap data = null;
		ArrayList	pres_remarks = null;
		String pres_remark_code = "";
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
			<form name="frmEditLabel" id="frmEditLabel">
				<div style="width:100%; overflow:auto; height:400px">
<%
					if(!allow_edit_disp_label.equals("Y")){
						ArrayList disp_details = (ArrayList) bean.getEditDetails( dispense_no);
						no_of_records = (disp_details.size())/19;
						record_count=0;
%>
						<div style='<%=nonEditLanelDisp%>' id='nonEditableLabel'>
							<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
<%
								for(int i=0; i< disp_details.size(); i=i+19){    //chenged for 16 to 18 for ML-BRU-SCF-0179 [IN:032578]
									record_count++;
									pres_remarks      = (ArrayList)  bean.getPrescriptionRemarks((String)disp_details.get(i+14));
									pres_remark_code    = (String) disp_details.get(i+15);
%>
									<tr>
										<td>
<% 
											if (record_count > 1 ) {
%>
												<td  class="label" colspan="4">&nbsp;</td>
<% 
											}
%>
									<tr>
										<td class= "COLUMNHEADER" colspan="4" align="center"><b><fmt:message key="Common.Drug.label" bundle="${common_labels}"/> # <%=(record_count)%></b></td> 
									</tr>
									<tr>
										<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="ePH.Drug/DosageDetail.label" bundle="${ph_labels}"/></td>
									</tr>
									<tr>
										 <td class="label" colspan="4">&nbsp;</td>
									</tr>
									<input type='hidden' name='dispSrlNo<%=record_count%>' id='dispSrlNo<%=record_count%>' value='<%=disp_details.get(i+1)%>'>
									<tr>
										<td class="label" colspan="2" width='60%'><b><%=disp_details.get(i+13)%></b></td>
										<td class="label" width='20%'><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>:&nbsp;</td>
										<td class="label" width='20%'><b><%=disp_details.get(i+16)%>&nbsp;&nbsp;<%=bean.getUomDisplay(facility_id,(String)disp_details.get(i+17))%></b></td>
									</tr>
									<tr>
										<td class="label" colspan="2">&nbsp;</td>
										<td class="label" ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>:&nbsp;</td>
										<td class="label" ><b><%=com.ehis.util.DateUtils.convertDate((String)disp_details.get(i+12),"DMY","en",locale)%></b></td>
									</tr>
									<tr>
										<td  class="label" colspan="4">&nbsp;</td>
									</tr>
									<tr>
										<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="ePH.AuxillaryInstructions.label" bundle="${ph_labels}"/></td> 
									</tr>
									<tr>
										<td  class="label" colspan="4">&nbsp;</td>
									</tr>
									<tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
<%
									if(pres_remarks.size()!=0){
%>
										<td width='30%' class="label"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></td>
										<td width='70%' colspan="3">&nbsp;<textarea name="remarks_new_<%=disp_details.get(i+1)%>" value="" size="150" maxlength="150"  rows='3' cols='50' readonly><%=beanobj.getDrugInstructions((String)disp_details.get(i+2),(String)disp_details.get(i+3))%></textarea><!-- code 'getPrescriptionRemarks' is replaced by 'getDrugInstructions' for ML-BRU-SCF-0981  -->
										</td>
<%
									}
									else{
%>
										<td width='30%' class="label"><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></td>
										 <td width='70%' colspan="3">&nbsp;<textarea name="remarks_new_<%=disp_details.get(i+1)%>" value="" size="150" maxlength="150"  rows='3' cols='50' readonly></textarea>
										</td>
<%
									}
%>
									</tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->
									<tr>
										<td class="label"><fmt:message key="ePH.CautionaryInstructions.label" bundle="${ph_labels}"/></td> 
										<td colspan="3" class="label"><select name="caution_1_<%=disp_details.get(i+1)%>" id="caution_1_<%=disp_details.get(i+1)%>" onchange="changeLocalInstr(this,'<%=loc_lang_from_tab%>','<%=iLabelPairs%>','C');" width="500" style="width: 500px"> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]--> <!--disp_details.get(i+1) variable is replaced by iLabelPairs for SRR20056-SCF-6260[Incident No.25586] -->
											<option value="">-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
										for(int j=0;j<cautions.size();j++){
											data = (HashMap)cautions.get(j);
											if(data !=null){
											//Changed the following variable label_text_1 to label_text_id for Incident No.28951	
												if( (((String)data.get("label_text_id")).trim()).equals(disp_details.get(i+4)) ){
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
								</tr>
								<tr>
									<td  class="label"><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/></td>
									<td colspan="3" class="label"><select name="special_1_<%=disp_details.get(i+1)%>" id="special_1_<%=disp_details.get(i+1)%>" onchange="changeLocalInstr(this,'<%=loc_lang_from_tab%>','<%=iLabelPairs%>','S');" width="500" style="width: 500px"> <!--disp_details.get(i+1) variable is replaced by iLabelPairs for SRR20056-SCF-6260[Incident No.25586] --> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
										<option value="">-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
									for(int k=0;k<spl_instruction.size();k++){
										data = (HashMap)spl_instruction.get(k);
										if(data !=null){
											//Changed the following variable label_text_1 to label_text_id for Incident No.28951
											if( (((String)data.get("label_text_id")).trim()).equals(disp_details.get(i+5)) ){
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
									</select>
									</td>
								</tr>
								<tr>
									<td class="label"><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>
									<td colspan="3" class="label"><textarea rows="3" cols="50" maxLength="150"  size="150"   name="patient_int_<%=disp_details.get(i+1)%>" onKeyPress="return checkMaxLimit(this,150);" onblur="checkMaxLength(this);"><%=disp_details.get(i+6)%></textarea>			
									<input type="button" name="Copy" id="Copy" value="Copy" onClick="CopyDrugRemarksValue(frmEditLabel,'<%=disp_details.get(i+1)%>');">
									</td>
								</tr>
								<tr>
									<td class="label"><fmt:message key="ePH.PrescriptionRemarks.label" bundle="${ph_labels}"/></td>
									<td colspan="3" class="label"><select name="pres_remarks_<%=disp_details.get(i+1)%>" id="pres_remarks_<%=disp_details.get(i+1)%>">
										<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
										for(int m=0;m<pres_remarks.size();m=m+3){   
											if(pres_remark_code.equals("")){
												if(pres_remarks.get(m+2).equals("Y"))
													remark_selected="selected";
												else
													remark_selected="";
											}
											else{
												if( (((String)pres_remarks.get(m)).trim()).equals(pres_remark_code) )
													remark_selected="selected";
												else
													remark_selected="";
											}			
%>
											<option value="<%=pres_remarks.get(m)%>"  <%=remark_selected%> ><%=pres_remarks.get(m+1)%></option>
<%					
										}
%>
										</select>
										</td>
									</tr>
									<tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
										<td  class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
										<td colspan="3" class="label"><textarea name="drug_ind_<%=disp_details.get(i+1)%>" value=""  maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"><%=disp_details.get(i+18)%>
										</textarea>
										</td>
									</tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] End-->
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
										if(! locale.equals("ar")){
%>
											<input type="text" maxLength="60" size="60" name="loc_caution_1_<%=iLabelPairs%>" id="loc_caution_1_<%=iLabelPairs%>" value='<%=disp_details.get(i+7)%>'> <!-- variable is replaced by iLabelPairs for SRR20056-SCF-6260[Incident No.25586] -->
<%
										}
										else{
%>	
											<textarea rows="3" cols="100" maxLength="200" name="loc_caution_1_<%=iLabelPairs%>" style='text-align:right;' class='OTHLANGTEXT' ><%=disp_details.get(i+7)%></textarea> <!--disp_details.get(i+1) variable is replaced by iLabelPairs for SRR20056-SCF-6260[Incident No.25586] --><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->
<%
										}
%>
										</td> 
									</tr>
									<tr>
										<td  class="label"><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/></td>
										<td  class="label" colspan="3">
<%
										if(! locale.equals("ar")){
%>
											<input type="text" maxLength="60" size="60" name="loc_special_1_<%=iLabelPairs%>" id="loc_special_1_<%=iLabelPairs%>" value='<%=disp_details.get(i+8)%>'  >	<!--disp_details.get(i+1) variable is replaced by iLabelPairs for SRR20056-SCF-6260[Incident No.25586] -->
<%
										}
										else{
%>	
											<textarea rows="3" cols="100" maxLength="200" name="loc_special_1_<%=iLabelPairs%>" style='text-align:right;' class='OTHLANGTEXT' ><%=disp_details.get(i+8)%></textarea><!--disp_details.get(i+1) variable is replaced by iLabelPairs for SRR20056-SCF-6260[Incident No.25586] --><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->
<%
										}
%>
										</td>
									</tr>
									<tr>
										<td  class="label"><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>
<%
										if(! locale.equals("ar")){
%>
											<td colspan="3" class="label"><textarea rows="3" cols="50" maxLength="150"  size="150"   name="patient_int_local_<%=disp_details.get(i+1)%>" onKeyPress="return checkMaxLimit(this,150);" onblur="checkMaxLength(this);"  ><%=disp_details.get(i+9)%></textarea>			
<%
										}
										else{
%>	
											<td colspan="3" class="label"><textarea rows="3" cols="50" maxLength="150"  size="150"   name="patient_int_local_<%=disp_details.get(i+1)%>" onKeyPress="return checkMaxLimit(this,150);" onblur="checkMaxLength(this);" class='OTHLANGTEXTAREA	'><%=disp_details.get(i+9)%></textarea>			
<%
										}
%>
										<input type="button" name="Copy" id="Copy" value="Copy" onClick="CopyDrugRemarksValue(frmEditLabel,'<%=iLabelPairs%>');">
										</td>
									</tr>
									<tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
										<td  class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
										<td colspan="3" class="label"><textarea name="drug_ind_<%=disp_details.get(i+1)%> "  value=""  maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"><%=disp_details.get(i+18)%>
										</textarea>
										</td>
									</tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->
<%
								}
%>
							</table>
						</div >
<%
					}
					else{ //added for Bru-HIMS-CRF-414 [IN:045554] -start
						ArrayList disp_details = (ArrayList) bean.getEditableDetails( dispense_no, labelLangId, facility_id);
						boolean labelExists = bean.getLabelExists();
						record_count=0;
						String disp_no="", disp_srl_no="";
						String dispQty="", dosageDtl="", instruction="", pres_drug_code="", no_of_prints="", drug_name="", disp_uom_code="", drug_code="" ; 
						no_of_records = (disp_details.size())/12;
						record_count =0;
%>
						<div  id='editableLabel'  style='<%=editLabelDisp%>'>
							<table cellpadding="10" cellspacing="0" width="100%" border="1" id='EditableLabel'>
<%
								for(int i=0; i<disp_details.size(); i=i+12){
									record_count++;
									disp_srl_no = (String)disp_details.get(i+1);
									dispQty = (String)disp_details.get(i+4); 
									disp_uom_code = (String)disp_details.get(i+5); 
									pres_drug_code = (String)disp_details.get(i+6); 
									drug_code = (String)disp_details.get(i+7); 
									drug_name = (String)disp_details.get(i+8); 
									dosageDtl = (String)disp_details.get(i+9); 
									no_of_prints = (String)disp_details.get(i+10); 
									instruction = (String)disp_details.get(i+11); 
%>
									<tr>
										<td class='label' width='20%'><b><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>&nbsp;/&nbsp;<fmt:message key="ePH.DispensedQty.label" bundle="${ph_labels}"/></label></b></td>
										<td class='label'  width='60%'><%=drug_name%>&nbsp;&nbsp;<input type='text' name='dispQty<%=record_count%>' id='dispQty<%=record_count%>' value='<%=dispQty%>' size='4' maxlength='3' onKeyPress="return allowValidNumber(this,event,3,0);" onpaste='return false'>&nbsp;<%=bean.getUomDisplay(facility_id,disp_uom_code)%>&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></label></td>
										<td class='label'  width='20%'><b><fmt:message key="ePH.NoOfPrints.label" bundle="${ph_labels}"/></b>&nbsp;
										<input type="text" maxLength="3" size="3" name="noOfPrints<%=record_count%>" id="noOfPrints<%=record_count%>" value="<%=no_of_prints%>" onKeyPress="return allowValidNumber(this,event,3,0);" onpaste='return false'> 
										</td>
									</tr>
									<tr>
										<td class='label'><b><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></b></td>
										<td class='label'><input type='text' name='dosageDtl_<%=record_count%>' id='dosageDtl_<%=record_count%>'  value='' size='80' maxlength='170'><img  src="../../eCommon/images/mandatory.gif" ></b></td>
<%
										if(!dosageDtl.equals("")){
											dosageDtl=dosageDtl.replaceAll(" ","%20");
											dosageDtl = java.net.URLEncoder.encode(dosageDtl,"UTF-8");
											dosageDtl=dosageDtl.replaceAll("%2520"," ");
%>
											<script>
												var jsdosageDtl = decodeURIComponent('<%=dosageDtl%>');
												eval('document.frmEditLabel.dosageDtl_'+'<%=record_count%>').value=jsdosageDtl;
											</script>
<%
										}
%>
										<td class='label'>&nbsp;</td>
									</tr>
									<tr>
										<td class='label'><b><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></b></td>
										<td class='label'><textarea name='instruction_<%=record_count%>' maxlength="270"  rows='4' cols='70' onKeyPress="return checkMaxLimit(this,270);" onblur ="return checkDrugIndMaxLimit(this,270);"><%=instruction%></textarea>
										</td>
										<td class='label'>&nbsp;</td>
									</tr>
									<tr style='height:3;'><td colspan='3'>&nbsp</td>
									<input type="hidden" name="dispSrlNo<%=record_count%>" id="dispSrlNo<%=record_count%>"  value="<%=disp_srl_no%>">
									<input type="hidden" name="disp_uom_code<%=record_count%>" id="disp_uom_code<%=record_count%>"  value="<%=disp_uom_code%>">
									<input type="hidden" name="pres_drug_code<%=record_count%>" id="pres_drug_code<%=record_count%>"  value="<%=pres_drug_code%>">
									<input type="hidden" name="drug_code_<%=record_count%>" id="drug_code_<%=record_count%>"  value="<%=drug_code%>">
<%
								}
%>
							</table>
							<input type="hidden" name="labelExists" id="labelExists"  value="<%=labelExists%>">
						</div>
<%
					}//Added for Bru-HIMS-CRF-414 [IN:045554] -end
%>
				</div>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<tr>
					<td  colspan='4' align='right'>
						<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button"  onClick="updateTable(frmEditLabel);">
						<input  type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button" onClick="cancelDialog();">
						<input  type="button" value='<fmt:message key="ePH.ViewAuditTrail.label" bundle="${ph_labels}"/>'class="button" onClick="viewAuditTrail('<%=dispense_no%>');">
					</td>
				</tr>
				<tr>
					<td  class="label" colspan="4">&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="no_of_records" id="no_of_records" value="<%=no_of_records%>">
			<input type="hidden" name="dispense_no" id="dispense_no" value="<%=dispense_no%>">
			<input type="hidden" name="allow_edit_disp_label" id="allow_edit_disp_label" value="<%=allow_edit_disp_label%>">
			<input type="hidden" name="labelLangId" id="labelLangId"  value="<%=labelLangId%>">
			<input type="hidden" name="facility_id" id="facility_id"  value="<%=facility_id%>">
		</form>
	</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


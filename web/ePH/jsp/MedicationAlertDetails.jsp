<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*,webbeans.eCommon.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="java.util.*,java.lang.*, ePH.Common.*, ePH.*,eCommon.Common.* " %>

<?xml version='1.0' encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../html/Style.xsl"?>
<html>
	<head>
<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
%>
		 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		 <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		 <script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
<%
		String  patient_id="",external_product_id="",drug_db_interact_check_flag="",drug_db_duptherapy_flag="",DosageAlert="",AllergyAlert="",drug_db_contraind_check_flag="",dup_drug_det="",drug_db_allergy_flag="";
		patient_id						=   request.getParameter("patient_id");
		external_product_id				=	request.getParameter("external_product_id");
		drug_db_interact_check_flag		=	request.getParameter("drug_db_interact_check_flag");
		drug_db_duptherapy_flag			=	request.getParameter("drug_db_duptherapy_flag");
		drug_db_contraind_check_flag	=	request.getParameter("drug_db_contraind_check_flag");
		drug_db_allergy_flag             =	request.getParameter("drug_db_allergy_flag");
		String drug_db_dosecheck_flag	        =   request.getParameter("drug_db_dosecheck_flag");
		String MIMS_OverrideReson = "";
		// Added in June 2012 - for CIMS - dosage
		String dosage_interface			=	request.getParameter("dosage_interface")==null?"": request.getParameter("dosage_interface");

		String conotra_reason			        =	request.getParameter("conotra_reason")==null?"": request.getParameter("conotra_reason");
		if(!conotra_reason.equals(""))
			conotra_reason = java.net.URLDecoder.decode(conotra_reason,"UTF-8");
		String interaction_reason		        =	request.getParameter("interaction_reason")==null?"": request.getParameter("interaction_reason");
		if(!interaction_reason.equals(""))
			interaction_reason = java.net.URLDecoder.decode(interaction_reason,"UTF-8");
		String alergy_reason			        =	request.getParameter("alergy_reason")==null?"": request.getParameter("alergy_reason");
		if(!alergy_reason.equals(""))
			alergy_reason = java.net.URLDecoder.decode(alergy_reason,"UTF-8");
		String duplicate_reason			        =	request.getParameter("duplicate_reason")==null?"": request.getParameter("duplicate_reason");
		if(!duplicate_reason.equals(""))
			duplicate_reason = java.net.URLDecoder.decode(duplicate_reason,"UTF-8");

		String dosage_reason			        =	request.getParameter("dosage_reason")==null?"": request.getParameter("dosage_reason");
		if(!dosage_reason.equals(""))
			dosage_reason = java.net.URLDecoder.decode(dosage_reason,"UTF-8");

		String pract_name						=	request.getParameter("pract_name");	
		pract_name = java.net.URLDecoder.decode(pract_name,"UTF-8");
		//pract_name=pract_name.replaceAll("%20"," ");
		String srl_no							=   request.getParameter("srl_no");
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		//String dosage_flag  = "N";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
		HashMap externalDBCheckResult	=   beanex.getExternalDBCheckResult(external_product_id, srl_no);
		HashMap tempExtDetails = (HashMap)externalDBCheckResult.get("DOSECHECK");
		String extProdid = beanex.getProdID();
		if(extProdid == null)
			extProdid ="";
		if(extProdid.equals("CIMS")){
			if(MIMS_OverrideReson.equals(""))
				MIMS_OverrideReson = dosage_reason;
			if(MIMS_OverrideReson.equals(""))
				MIMS_OverrideReson = duplicate_reason;
			if(MIMS_OverrideReson.equals(""))
				MIMS_OverrideReson = alergy_reason;
			if(MIMS_OverrideReson.equals(""))
				MIMS_OverrideReson = interaction_reason;
			if(MIMS_OverrideReson.equals(""))
				MIMS_OverrideReson = conotra_reason;
		}
		
%>
		<!-- <BODY> -->
		<body onMouseDown="" onKeyDown="lockKey()">
			<form name="medication_alert_detail" id="medication_alert_detail">
				<TABLE  width="100%"  align="center" border="0">
					<input type="hidden" name="drug_db_dosecheck_flag" id="drug_db_dosecheck_flag" value="<%=drug_db_dosecheck_flag%>">
					<input type="hidden" name="drug_db_duptherapy_flag" id="drug_db_duptherapy_flag" value="<%=drug_db_duptherapy_flag%>">
					<input type="hidden" name="drug_db_interact_check_flag" id="drug_db_interact_check_flag" value="<%=drug_db_interact_check_flag%>">
					<input type="hidden" name="drug_db_contraind_check_flag" id="drug_db_contraind_check_flag" value="<%=drug_db_contraind_check_flag%>">
					<input type="hidden" name="drug_db_allergy_flag" id="drug_db_allergy_flag" value="<%=drug_db_allergy_flag%>">
					<input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>">
					<input type="hidden" name="dosage_interface" id="dosage_interface" value="<%=dosage_interface%>">	  <!-- Added in JUNE 2012 -  CIMS - DOSAGE -->
					<input type="hidden" name="external_db_interface" id="external_db_interface" value="<%=extProdid%>">	  <!-- Added in JUNE 2012 -  CIMS - DOSAGE -->
					<tr style="BACKGROUND-COLOR:#FFFFCC"><td style="BACKGROUND-COLOR:#FFFFCC">
<% 
					if(beanex!=null && extProdid.equals("CIMS")){ 
%>
					   <hr></hr>
							 <table  width="100%" border="0">
							<TR>
							   <td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
							   <TD align="left"  width="70%"style="BACKGROUND-COLOR:#FFFFCC"><B> <fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></B>  <img name='mandatory'  src="../../eCommon/images/mandatory.gif"><a href="javascript:DefaultReason(document.medication_alert_detail.Duplicate_Override_Reason,document.medication_alert_detail.pract_name);" title="Deafult OverrideReason"><fmt:message key="ePH.DefaultOverrideReason.label" bundle="${ph_labels}"/></a><br><TEXTAREA  COLS=100 ROWS=7 ID="Duplicate_Override_Reason" name ="Duplicate_Override_Reason" ><%=MIMS_OverrideReson%></TEXTAREA></TD>
							</TR>
					   </table>
<%		
					}
					else { 
						if(tempExtDetails != null && tempExtDetails.size()>0){
%>					
						 <table  width="100%" border="0">
							<tr>
							   <td width="30%"  style="color:red;BACKGROUND-COLOR:#FFFFCC;"><B><fmt:message key="ePH.DosageAlert.label" bundle="${ph_labels}"/></B></td>
							   <td width="70%"  style="BACKGROUND-COLOR:#FFFFCC"></td>
							</tr>
	<%
							if(tempExtDetails.containsKey("SINGLEDOSAGE")){
								DosageAlert = (String)tempExtDetails.get("SINGLEDOSAGE");
								if(DosageAlert != null && !DosageAlert.equals("")){
	%>
									<tr>
									   <td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
									   <TD align="left"  id="single_dosage" width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.ExceedsSingleDosage.label" bundle="${ph_labels}"/></B><br>
										<%=DosageAlert%></td>
									</tr>
	<%
								}
							}
							if(tempExtDetails.containsKey("MAXDAILYDOSAGE")){
								DosageAlert = (String)tempExtDetails.get("MAXDAILYDOSAGE");
								if(DosageAlert != null && !DosageAlert.equals("")){
	%>
									<tr>
									   <td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
									   <TD align="left"  id="max_daily_dosage" width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.ExceedsMaxDailyDosage.label" bundle="${ph_labels}"/></B><br>
										<%=DosageAlert%></td>
									</tr>
	<%
								}
							}
							if(tempExtDetails.containsKey("RANGEDOSAGE")){
								DosageAlert = (String)tempExtDetails.get("RANGEDOSAGE");
								if(DosageAlert != null && !DosageAlert.equals("")){
	%>
									<tr>
									   <td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
									   <TD align="left" id="ranged_dosage" width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.ExceedsRecommondedRangedDosage.label" bundle="${ph_labels}"/></B><br><%=DosageAlert%></td>
									</tr>
	<%
								}
							}
							if(tempExtDetails.containsKey("DAILYDOSAGE")){
								DosageAlert = (String)tempExtDetails.get("DAILYDOSAGE");
								if(DosageAlert != null && !DosageAlert.equals("")){
	%>
									<tr>
									   <td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
									   <TD align="left" id="ranged_dosage" width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.ExceedsDailyDosage.label" bundle="${ph_labels}"/></B><br><%=DosageAlert%></td>
									</tr>
	<%
								}
							}
							if(tempExtDetails.containsKey("FREQUENCYDOSAGE")){
								DosageAlert = (String)tempExtDetails.get("FREQUENCYDOSAGE");
								if(DosageAlert != null && !DosageAlert.equals("")){
	%>
									<tr>
									   <td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
									   <TD align="left" id="ranged_dosage" width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.ExceedsFrequencyDosage.label" bundle="${ph_labels}"/></B><br><%=DosageAlert%></td>
									</tr>
	<%
								}
							}
							if(tempExtDetails.containsKey("DURATIONDOSAGE")){
								DosageAlert = (String)tempExtDetails.get("DURATIONDOSAGE");
								if(DosageAlert != null && !DosageAlert.equals("")){
	%>
									<tr>
									   <td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
									   <TD align="left" id="ranged_dosage" width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.ExceedsDurationDosage.label" bundle="${ph_labels}"/></B><br><%=DosageAlert%></td>
									</tr>
	<%
								}
							}
	%>
							<TR>
								<td width="30%" style="BACKGROUND-COLOR:#FFFFCC"></td>
								<TD align="left"   width="70%" style="BACKGROUND-COLOR:#FFFFCC"><B> <fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></B>&nbsp;&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"><a href="javascript:DefaultReason(document.medication_alert_detail.Dosage_Override_Reason,document.medication_alert_detail.pract_name);" title="Deafult OverrideReason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DefaultOverrideReason.label" bundle="${ph_labels}"/></a><br><TEXTAREA  COLS=100 ROWS=7 ID="Dosage_Override_Reason" name ="Dosage_Override_Reason" ><%=dosage_reason%></TEXTAREA></TD>
							</TR>
						</table>
<%
					}
					if(drug_db_duptherapy_flag.equals("Y")){
						dup_drug_det = (String)externalDBCheckResult.get("DUPCHECK");
						//dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result
%>
				         <hr></hr>
						 <table  width="100%" border="0">
							<tr>
								<TD align="left" id="Duplicate Therapy Alert" width="30%"  style="color:red;BACKGROUND-COLOR:#FFFFCC;"><B><fmt:message key="ePH.DuplicateTherapyAlert.label" bundle="${ph_labels}"/></B></td>
								<td width="70%" style="BACKGROUND-COLOR:#FFFFCC"></td>
							</tr>
							<tr>	
								<td width="30%"  style="BACKGROUND-COLOR:#FFFFCC"></td>
								<td width="70%"  style="BACKGROUND-COLOR:#FFFFCC"><%=dup_drug_det%></td>
							</tr>
							<TR>
							   <td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
							   <TD align="left"  width="70%"style="BACKGROUND-COLOR:#FFFFCC"><B> <fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></B>&nbsp;&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"><a href="javascript:DefaultReason(document.medication_alert_detail.Duplicate_Override_Reason,document.medication_alert_detail.pract_name);" title="Deafult OverrideReason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DefaultOverrideReason.label" bundle="${ph_labels}"/></a><br><TEXTAREA  COLS=100 ROWS=7 ID="Duplicate_Override_Reason" name ="Duplicate_Override_Reason" ><%=duplicate_reason%></TEXTAREA></TD>
							</TR>
					   </table>
<%
					}
					if(drug_db_interact_check_flag.equals("Y")){
						//HashMap drug_Interactions		= null;
						//beanex.getDDInteractions(external_product_id);//Store interactions
						//drug_Interactions		= beanex.getInteractions();//get Interactions
						StringBuffer interaction_det    = new StringBuffer();
						tempExtDetails =(HashMap) externalDBCheckResult.get("INTRACHECK");
						if(tempExtDetails!=null && tempExtDetails.size()>0){
							Set keyset=tempExtDetails.keySet();
							Iterator itr=keyset.iterator();
							while (itr.hasNext()){
								Object header = itr.next();
								String str    = header.toString();
								interaction_det.append("<b>").append(str).append("</b><br>");
								ArrayList details = (ArrayList)tempExtDetails.get(header);
								for (int i=0;i<details.size();i++){
									interaction_det.append(details.get(i).toString()).append("<br>");
								}
							}
							interaction_det.append("<br>");
						}
%>
					 <hr></hr>
					 <table  width="100%" border="0">
						<tr>
							<TD align="left"  id="Insertion Alert" width="30%"style="color:red;BACKGROUND-COLOR:#FFFFCC;"><B>  <fmt:message key="ePH.InteractionAlert.label" bundle="${ph_labels}"/></B></td>
							<td width="70%"style="BACKGROUND-COLOR:#FFFFCC"></td>
						</tr> 
						<tr>  <td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
							  <td width="70%" style="BACKGROUND-COLOR:#FFFFCC"><%=interaction_det.toString()%></td>
						</tr>

						<TR>
							<td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
							<TD align="left"  width="70%"style="BACKGROUND-COLOR:#FFFFCC"><B> <fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></B>&nbsp;&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"><a href="javascript:DefaultReason(document.medication_alert_detail.Interaction_Override_Reason,document.medication_alert_detail.pract_name);" title="Deafult OverrideReason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DefaultOverrideReason.label" bundle="${ph_labels}"/></a><br><TEXTAREA  COLS=100 ROWS=7 ID="Interaction_Override_Reason" name ="Interaction_Override_Reason" ><%=interaction_reason%></TEXTAREA></TD>
					   </TR>
					</table>				
<%
				}
				if(drug_db_contraind_check_flag.equals("Y")){
					String drug_contra_det="";
					tempExtDetails =(HashMap) externalDBCheckResult.get("CONTRACHECK");

					ArrayList ex_prod_ids =new ArrayList();
					ex_prod_ids.add(external_product_id);
					//boolean flag =  beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
					//HashMap contra_indications = (HashMap)beanex.getContraIndications();

					if(tempExtDetails!=null && tempExtDetails.containsKey(external_product_id)){
						drug_contra_det   =(String)tempExtDetails.get(external_product_id);
					}
%>
					<hr></hr>
                     <table  width="100%" border="0">
						 <tr>
						   <TD align="left"  id="Contra-Indication Alert" width="30%"style="color:red;BACKGROUND-COLOR:#FFFFCC;"><B><fmt:message key="ePH.ContraindicationAlert.label" bundle="${ph_labels}"/></B></td>
						   <td width="70%"style="BACKGROUND-COLOR:#FFFFCC"></td>
						 </tr>
						 <tr>
						   <td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
						   <td  width="70%"style="BACKGROUND-COLOR:#FFFFCC"><%=drug_contra_det%></td>
						 </tr>
						 <TR>
						   <td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
						   <TD align="left"  width="70%"style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></B>&nbsp;&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"><a href="javascript:DefaultReason(document.medication_alert_detail.Contra_Override_Reason,document.medication_alert_detail.pract_name);" title="Deafult OverrideReason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DefaultOverrideReason.label" bundle="${ph_labels}"/></a><br><TEXTAREA  COLS=100 ROWS=7 ID="Contra_Override_Reason" name ="Contra_Override_Reason" ><%=conotra_reason%></TEXTAREA></TD>
					    </TR>
					</table>
<%
				}
				if(drug_db_allergy_flag.equals("Y")){

					String drug_alergya_det="";
					//HashMap drug_alergies = (HashMap)beanex.getDrugAlergies();
					//tempExtDetails =(HashMap) externalDBCheckResult.get("ALLERGYCHECK");
				   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
					   drug_alergya_det			= (String)externalDBCheckResult.get("ALLERGYCHECK");
				   } 
				   else {  
						tempExtDetails =(HashMap)externalDBCheckResult.get("ALLERGYCHECK");
						if(tempExtDetails!=null && tempExtDetails.containsKey(external_product_id)){
							drug_alergya_det   =(String)tempExtDetails.get(external_product_id);
						}
					} 

%>
					<hr></hr>
                    <table  width="100%" border="0">
						<tr>
							<TD align="left"  id="Allergy Alert" width="30%"style="color:red;BACKGROUND-COLOR:#FFFFCC;"><B><fmt:message key="ePH.AllergyAlert.label" bundle="${ph_labels}"/></B></td>
							<td width="70%"style="BACKGROUND-COLOR:#FFFFCC"></td>
						</tr>
						<tr>
							<td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
							<td width="70%"style="BACKGROUND-COLOR:#FFFFCC"><%=drug_alergya_det%></td>
						</tr>
						<TR>
							<td width="30%"style="BACKGROUND-COLOR:#FFFFCC"></td>
						    <TD align="left"  width="70%"style="BACKGROUND-COLOR:#FFFFCC"><B><fmt:message key="Common.AllergyOverrideReason.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"><a href="javascript:DefaultReason(document.medication_alert_detail.Alergy_Override_Reason,document.medication_alert_detail.pract_name);" title="Deafult OverrideReason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DefaultOverrideReason.label" bundle="${ph_labels}"/></a><br><TEXTAREA  COLS=100 ROWS=7 ID="Alergy_Override_Reason" name ="Alergy_Override_Reason" ><%=alergy_reason%></TEXTAREA></TD>
						</TR>
					</table>
<%
				}
			}
%>				
				</td>
				</tr>      
			</table>
		</form>
<% 
		putObjectInBean(ex_bean_id,beanex,request); 
%>
	</BODY>
</HTML>


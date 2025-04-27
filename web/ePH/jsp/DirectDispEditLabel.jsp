<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.text.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script> 
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<Script src="../../eCommon/js/locale.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="DireciDispensingEditLabel" id="DireciDispensingEditLabel" action='DirectDispValidate.jsp' method='post' target="dummyFrame">
<%	
		try{
			String facility_id			=	(String) session.getValue("facility_id");
			String sShowButtons			=	request.getParameter("buttons")==null?"":" style='display:none' ";    //newly added for RUT-CRF-0067
			String sCalledFrom			=	request.getParameter("CalledFrom") == null?"":request.getParameter("CalledFrom"); //newly added for RUT-CRF-0067
			int recno				=	Integer.parseInt(request.getParameter("recno")==null?"0":request.getParameter("recno"));
			String drug_code			=	request.getParameter("drug_code");
			String chk					=	request.getParameter("chk");
			String srl_no				=	request.getParameter("srl_no");
			String	bean_id				=   "DirectDispensingBean" ;
			String	bean_name			=   "ePH.DirectDispensingBean";
			DirectDispensingBean bean	=   (DirectDispensingBean)getBeanObject(bean_id,bean_name,request);
			String  func_mode			=	"editlabel";	
			String caution_1			=	"";
			String special_1			=   "";
			String patient_int			=   "";
			String loc_caution_1		=   "";
			String loc_special_1		=   "";
			String loc_patient_int		=   "";	
			String ext_drug_code		=   "";
			String ext_srl_no			=   "";
			HashMap drugDetails			=  null;
			ArrayList values	        =  new ArrayList();
			String loc_lang_from_tab      ="";
			String caution_id			= "";
			String special_id			= "";
			String new_drug_indication="";//Added for  ML-BRU-CRF-072[Inc:29938]
			boolean bShowDrugCount		= false;//newly added for RUT-CRF-0067 -start	
			String patientid			=	bean.getPatientID(); 
			if(patientid == null)
				patientid			    =	request.getParameter("patient_id");
			String sMode				=	request.getParameter("mode");
			String order_date			=	request.getParameter("order_date");                                            
			String drug_name			=	"";	
			String pres_qty = "";
			String uom ="";
			String patient_name = bean.getPatient_name(patientid);
			String pract_name = bean.getPractionerName() ;//newly added for RUT-CRF-0067 -end
			HashMap labels					= (HashMap) bean.loadLabels();
			ArrayList	cautions			= (ArrayList) labels.get("caution");
			ArrayList	spl_instruction		= (ArrayList) labels.get("spl_instruction");
			ArrayList caution				= new ArrayList();
			ArrayList special				= new ArrayList();
			ArrayList pat_int				= new ArrayList();
			ArrayList presDetails		=  (ArrayList) bean.getpresDetails();
			Hashtable editLabelDetail = new Hashtable();//newly added for RUT-CRF-0067 --start
			String customer_id = bean.getCustomerID();
			String hide_exp_date_pres_qty="";
			String sDisableAll	= "";
			if(customer_id.equals("SRR")){
				 hide_exp_date_pres_qty =" style='display:none' ";
			}
			if(sMode != null && sMode.equals("preview"))
				sDisableAll				= "Disabled";

			if(sCalledFrom.equals("PrintDialog") )
				sDisableAll				= "Disabled";
			if(presDetails!=null && presDetails.size()>1)
				bShowDrugCount	 = true;
			String sHeight = "590px";
			if(bShowDrugCount){
				if(!sShowButtons.equals("")){
					sHeight = "375px";
				}
			}//newly added for RUT-CRF-0067 --end
%>
			<div style="width:100%; overflow:auto;height:<%=sHeight%>;">
			<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
				<tr>
					<td class= "COLUMNHEADER" align="left" colspan="4"><font style='font-size:12;'><B><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></B></font></td>
				</tr>
				<tr>
					<td class= "COLUMNHEADER" colspan="4" align="left"><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label" width='25%'>&nbsp;</td>
					<td class="label" width='25%'>&nbsp;</td>
					<td class="label" width='25%'>&nbsp;</td>
					<td class="label" width='25%'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label" colspan='2'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<b>&nbsp;<%=patientid%></b></td>
					<td class="label" colspan='2'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;:&nbsp;<b><%=patient_name%></b></td>
				</tr>
				<tr>
<%
					if(order_date!=null){
%>
						<td class="label" ><fmt:message key="ePH.PrescDate.label" bundle="${ph_labels}"/>&nbsp;:&nbsp;</td>
						<td class="label" ><b><%=com.ehis.util.DateUtils.convertDate(order_date,"DMYHM","en",locale)%></b></td>
<%
					}
					else{
%>
						<td class="label" colspan = '2'></td>
<%
					}
%>
					<td class="label" ><fmt:message key="ePH.PrescBy.label" bundle="${ph_labels}"/>&nbsp;:&nbsp;</td>
					<td class="label" ><b><%=pract_name%></b></td>
				</tr>
				<tr>
					<td class="label" colspan="4">&nbsp;</td>
				</tr>
<%
				//if(presDetails!=null && presDetails.size()>0 ){ // commented for RUT-CRF-0067
				//for(int i=0;i<presDetails.size();i++){  // commented for RUT-CRF-0067
				if(presDetails!=null && presDetails.size()>0){//newly added for RUT-CRF-0067 --start
					int drug_cunt=0;
					if(!sCalledFrom.equals("PrintDialog") )
						drug_cunt=1;
					else
						drug_cunt=presDetails.size();
					String Drug_indicationDisplay = "";
					for(int m=0;m<drug_cunt;m++){
						pat_int=new ArrayList();//Added for BSP-SCF-0026 
					    values=new ArrayList();//Added for BSP-SCF-0026
						if(!sCalledFrom.equals("PrintDialog") ){
							drugDetails					= (HashMap)presDetails.get(recno);
							Drug_indicationDisplay = "Display:none";
						}
						else{
							drugDetails					= (HashMap)presDetails.get(m);
							Drug_indicationDisplay = "Display";
						}
						drug_name					=(String)drugDetails.get("SHORT_DESC");
						pres_qty					=(String)drugDetails.get("TOT_ALLOC_QTY");
						uom							=(String)drugDetails.get("STOCK_UOM");//DISPENSED_UOM
						ext_drug_code				= (String)drugDetails.get("DRUG_CODE");
						ext_srl_no					= (String)drugDetails.get("SRL_NO");
						new_drug_indication	= (String)drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]
						ArrayList	instructions		=  bean.getInstructions(ext_drug_code);	
						//if(ext_drug_code.equals(drug_code) ){   // removed && ext_srl_no.equals(srl_no) for CRF-0067
						 if(drugDetails.containsKey("EDITLABEL")){
							values	= (ArrayList)drugDetails.get("EDITLABEL");
						 //}
						}
						//}
						//}
						caution_id			= "";
						special_id			= "";//newly added for RUT-CRF-0067 --end
						caution_1		= "";//Added for BSP-SCF-0026 
						special_1		= "";//Added for BSP-SCF-0026 
						patient_int		= "";//Added for BSP-SCF-0026 
						loc_caution_1	= "";//Added for BSP-SCF-0026 
						loc_special_1	="";//Added for BSP-SCF-0026
						loc_patient_int	= "";//Added for BSP-SCF-0026 
						if(values.size() > 0){
							for(int i=0;i<values.size();i++){
								caution_1		= (String)values.get(0);
								special_1		= (String)values.get(2);
								patient_int		= (String)values.get(4);
								loc_caution_1	= (String)values.get(5);
								loc_special_1	= (String)values.get(7);
								loc_patient_int	= (String)values.get(9);
								//new_drug_indication	= (String)values.get(10);//Added for  ML-BRU-CRF-072[Inc:29938]
							}
						}
						else{	
							if(instructions.size() > 0){
								caution	= (ArrayList)instructions.get(0);
								special			= (ArrayList)instructions.get(1);
								pat_int =   (ArrayList)instructions.get(2);
								if(caution.size()>0){	
									for(int i=0;i<caution.size();i+=3){
										caution_id		= bean.checkForNull((String)caution.get(i));	//added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										if(caution.get(i+2).equals("en")){
											 caution_1		= java.net.URLDecoder.decode((String)caution.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										}
										else{
											 loc_caution_1	= java.net.URLDecoder.decode((String)caution.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											 loc_lang_from_tab =(String)caution.get(i+2);
										}
									}
								}
								if(special.size()>0){
									for(int i=0;i<special.size();i+=3){
										special_id		= bean.checkForNull((String)special.get(i)); //added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										if(special.get(i+2).equals("en")){
											special_1		= java.net.URLDecoder.decode((String)special.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										}
										else{
											loc_special_1	= java.net.URLDecoder.decode((String)special.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											loc_lang_from_tab =(String)special.get(i+2);
										}
									}
								}
								if(pat_int.size()>0){
									for(int i=0;i<pat_int.size();i+=2){
										if(pat_int.get(i+1).equals("en")){
											patient_int		=java.net.URLDecoder.decode((String)pat_int.get(i),"UTF-8");  //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										}
										else{
											loc_patient_int	= java.net.URLDecoder.decode((String)pat_int.get(i),"UTF-8");  //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
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
						String no_of_prints="";//newly added for RUT-CRF-0067 --start
						no_of_prints = bean.getPrintNoOfCopies(ext_drug_code);
						if(presDetails.size() > 0){
%>
<%	
						}
						if(bShowDrugCount){
%>
							<tr>
								<td class= "COLUMNHEADER" colspan="4" align="center"><b><fmt:message key="Common.Drug.label" bundle="${common_labels}"/> # <%=m+1%></b></td> 
							</tr>
<%
						}
%>
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
								<td class="label" colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" colspan='2'><b><%=drug_name%></b></td>
								<td class="label" <%=hide_exp_date_pres_qty%>><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>:&nbsp;<b><%=pres_qty%>&nbsp;&nbsp;<%=bean.getUomDisplay(facility_id,uom)%><b></td>
<%
								if(sCalledFrom.equals("PrintDialog")){//Code Added For RUT-CRF-0067 - Start
									
									if(no_of_prints.equals("N")){
%>
										<td class="label" style='TEXT-ALIGN:right;' ><b><fmt:message key="ePH.NoOfPrints.label" bundle="${ph_labels}"/></b>&nbsp;
											<input type="text" maxLength="3" size="3" name="noOfPrints<%=m+1%>" id="noOfPrints<%=m+1%>" value="1" readonly> 
										</td>
<%	
									}
									else { 
%>
										<td class="label" style='TEXT-ALIGN:right;' ><b><fmt:message key="ePH.NoOfPrints.label" bundle="${ph_labels}"/></b>&nbsp;
											<input type="text" id="noOfPrints" maxLength="3" size="2" name="noOfPrints<%=m+1%>" id="noOfPrints<%=m+1%>" value="<%=pres_qty%>" onKeyPress="return(ChkNumberInput(this,event,'0'))" onblur="validateNoOfPrints(this, '<%=pres_qty%>');">
										</td>
<%
									}
								}
%> 
							</tr>
							<tr>
								<td class="label" colspan="4">&nbsp;</td>
							</tr>
							<tr>
							<th colspan="4" ><fmt:message key="ePH.AuxillaryInstructions.label" bundle="${ph_labels}"/></th>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.CautionaryInstructions.label" bundle="${ph_labels}"/></td>
								<td class="label" colspan='3'><select name="caution_1_<%=m+1%>" id="caution_1_<%=m+1%>" onchange="getlocalinstruction(this,'<%=m+1%>','C')"  width="500" style="width: 500px"> <!-- onchange="loadCmb(this);"  --><!--added m+1 for RUT-CRF-0067 --><!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
									<option value="">-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
									for(int i=0;i<cautions.size();i++){
										HashMap data = new HashMap();
										data = (HashMap)cautions.get(i);
										if( (((String)data.get("label_text_id")).trim()).equals(caution_id) || (((String)data.get("label_text_1")).trim()).equals(caution_1))	{
										//if( (((String)data.get("label_text_1")).trim()).equals(caution_1) )	{
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
%>
									</select>
								</td>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/> </td>
								<td class="label" colspan='3'><select name="special_1_<%=m+1%>" id="special_1_<%=m+1%>" onchange="getlocalinstruction(this,'<%=m+1%>','S')" width="500" style="width: 500px"><!-- onChange="loadCmbSplInstr(this)" --><!--added m+1 for RUT-CRF-0067 --> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->
									<option value="">-------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------------------------</option>
<%
									for(int i=0;i<spl_instruction.size();i++){
										HashMap data = new HashMap();
										data = (HashMap)spl_instruction.get(i);

										if( (((String)data.get("label_text_id")).trim()).equals(special_id) || (((String)data.get("label_text_1")).trim()).equals(special_1))	{
										//if( (((String)data.get("label_text_1")).trim()).equals(special_1) )	{
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
%>	
									</select>
								</td>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>
								<td class="label" colspan="3" ><textarea name="patient_int_<%=m+1%>"  size="100" maxlength="75"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,150);" onblur="validmaxlength(this);"><%=patient_int%></textarea></td><!--added m+1 for RUT-CRF-0067 -->
								<!-- <td  colspan="3">&nbsp;<input type="text" maxLength="40" size="40" name="patient_int" id="patient_int" value='<%=patient_int%>' ></td> -->
							</tr>
							<tr style='<%=Drug_indicationDisplay%>'><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->
								<td class="label" nowrap><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
								<td class="label" colspan="3"><textarea name="drug_ind_<%=m+1%>"   maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);"  onFocus=''><%=new_drug_indication%>
								</textarea>
								</td>
							</tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->
							<tr>
								<td class="label" colspan="4">&nbsp;</td>
							</tr>
							<tr>
								<th colspan="4" ><fmt:message key="ePH.AuxillaryInstructions.label" bundle="${ph_labels}"/> </th>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.CautionaryInstructions.label" bundle="${ph_labels}"/></td>
								<td class="label" colspan='3'>
<%
								if(! loc_lang_from_tab.equals("ar")){
%>
									<input type="text" maxLength="40" size="60" name="loc_caution_1_<%=m+1%>" id="loc_caution_1_<%=m+1%>" value='<%=loc_caution_1%>'  onFocus='' class='OTHLANGTEXT' ><!--added m+1 for RUT-CRF-0067 -->
<%
								}
								else{
%>	
									<textarea rows="3" cols="75" maxLength="200" name="loc_caution_1_<%=m+1%>" style='text-align:right' onFocus=''  class='OTHLANGTEXT'><%=loc_caution_1%></textarea><!--added m+1 for RUT-CRF-0067 --><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->
<%
								}
%>
							</td><!-- loadArabic() -->
						</tr>
						<tr>
							<td class="label" nowrap><fmt:message key="ePH.SpecialInstructions.label" bundle="${ph_labels}"/> </td>
							<td class="label" colspan='3'>
<%
							if(! loc_lang_from_tab.equals("ar")){
%>
								<input type="text" maxLength="40" size="40" name="loc_special_1_<%=m+1%>" id="loc_special_1_<%=m+1%>" value='<%=loc_special_1%>'  onFocus=''  class='OTHLANGTEXT'><!--added m+1 for RUT-CRF-0067 -->
<%
							}
							else{
%>	
								<textarea rows="3" cols="75" maxLength="200" name="loc_special_1_<%=m+1%>" style='text-align:right' onFocus=''  class='OTHLANGTEXT'><%=loc_special_1%></textarea><!--added m+1 for RUT-CRF-0067 --><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->
<%
							}
%>
							</td><!-- loadArabic() -->
						</tr>
						<tr>
							<td class="label" nowrap><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>
							<td class="label" colspan="3" >
<%
							if(! loc_lang_from_tab.equals("ar")){//Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start
%>
								<textarea name="loc_patient_int_<%=m+1%>"  size="75" maxlength="150"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,150);" onblur="validmaxlength(this);" onFocus=''  class='OTHLANGTEXT'><%=loc_patient_int%></textarea><!--added m+1 for RUT-CRF-0067 -->
								</td></tr>
								<tr style='<%=Drug_indicationDisplay%>'>
									<td class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
									<td colspan="3" class="label"><textarea name="Loc_drug_ind_<%=m+1%>"   readOnly maxlength="500"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);" onFocus=''><%=new_drug_indication%>
									</textarea>
								</td>
<%
							}
							else{
%>	
								<textarea name="loc_patient_int_<%=m+1%>"  size="75" maxlength="150"  rows='3' cols='50' onKeyPress="return checkMaxLimit(this,150);" onblur="validmaxlength(this);" style='text-align:right' onFocus=''  class='OTHLANGTEXT'><%=loc_patient_int%></textarea><!--added m+1 for RUT-CRF-0067 -->
								<tr style='<%=Drug_indicationDisplay%>'>
								 <td class="label"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></td>
								 <td colspan="3" class="label"><textarea name="Loc_drug_ind_<%=m+1%>"  maxlength="500"  rows='3' cols='50' readOnly onKeyPress="return checkMaxLimit(this,500);" onblur ="return checkDrugIndMaxLimit(this,500);" onFocus=''><%=new_drug_indication%>
							</textarea>
							</td>
<%
							}//Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] End
%>
						</tr>
						<input type="hidden" name="drug_code_<%=m+1%>" id="drug_code_<%=m+1%>" value="<%=ext_drug_code%>"> <!--changed drug_code to  drug_code_m+1 for RUT-CRF-0067-->
						<input type="hidden" name="srl_no_<%=m+1%>" id="srl_no_<%=m+1%>" value="<%=m%>">					<!--changed srl_no to  srl_no_m+1 for RUT-CRF-0067-->
						<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
						<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
						<input type="hidden" name="chk_<%=m+1%>" id="chk_<%=m+1%>"      value="<%=chk%>" >	<!--changed chk to  chk_m+1 for RUT-CRF-0067-->
						<input type="hidden" name="totalRecordds" id="totalRecordds"  value="<%=drug_cunt%>">  <!--newly added for RUT-CRF-0067 -->
						<input type="hidden" name="allocQty<%=m+1%>" id="allocQty<%=m+1%>"  value="<%=pres_qty%>"> <!--newly added for RUT-CRF-0067 -->
<% 
					}
				}
%>
				</table>
			</div>
<%
			if(!sCalledFrom.equals("PrintDialog")){   //newly added for RUT-CRF-0067
%>
				<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
					<tr>
						<td  align="right" >
						<input  type="button" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/> ' class="button" onClick="validateEditDetailsReset(DireciDispensingEditLabel);">
						<input  type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>  ' class="button"  onClick="validateEditDetails(DireciDispensingEditLabel);">
						<input  type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>   ' class="button" onClick="parent.window.close()">
						</td>
					</tr> 
					</tr>
					<tr>
						<td  class="label">&nbsp;</td>
					</tr>
				</table>
<%
			}
%>
			<input type="hidden" name="recno" id="recno" value="<%=recno%>">
			<input type="hidden" name="calledFrom" id="calledFrom" value="">			<!--newly added for RUT-CRF-0067 -->
			<input type="hidden" name="func_mode" id="func_mode"    value="<%=func_mode%>"  ><!--newly added for RUT-CRF-0067 -->
			<input type="hidden" name="ComputeSetOrder" id="ComputeSetOrder" value=""><!--newly added for RUT-CRF-0067 -->
			<input type="hidden" name="PrintDialogFrame" id="PrintDialogFrame" value="parent.printSelectFrame.document.DispMedicationPrintDialog"><!--newly added for RUT-CRF-0067 -->
		
		</form>
<% 
		putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
</html>


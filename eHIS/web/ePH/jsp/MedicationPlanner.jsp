<!DOCTYPE html>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<style type="text/css">
		TEXTAREA{
			  COLOR:black;
			  background-color:#FFFFFF;
			  FONT-SIZE: 8pt;
			  Font-Family : verdana;
			  TEXT-ALIGN: LEFT;
			}
		</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form action="" name="formMedicationPlanner" id="formMedicationPlanner" method="post">
<%
        Connection con = null; // Added for ML-BRU-CRF-0469 [IN:065426]
	try {
		String qty_issue = "";//added for ML-BRU-SCF-1521.1 [IN:055331]
		String qty_issuelocal = "";//added for ML-BRU-SCF-1521.1 [IN:055331]
		String qty_issue_prop="";//added for ML-BRU-SCF-1795
		String qty_issue_proplocal="";//added fot ML-BRU-SCF-1795
		Boolean mp_flag = false;//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String[] uom;//added for ML-BRU-SCF-1521.1 [IN:055331]
		String[] uom1;//ML-BRU-SCF-1781
		String[] uom_local;//added for ML-BRU-SCF-1521.1 [IN:055331]
		String tmpOrdId = "";//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String dispNosOrder = "";//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String tempDispNos = "";//added for ML-BRU-SCF-1521.1 [IN:055331] 
		String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
		String encounter_id = CommonBean.checkForNull(request.getParameter("encounter_id"));
		String facility_id = (String) session.getValue("facility_id");
		String med_plan_check = CommonBean.checkForNull(request.getParameter("med_plan_check"));
		String mediplan_seq_no = CommonBean.checkForNull(request.getParameter("mediplan_seq_no"));
		String sel_lang = request.getParameter("sel_lang");
		String locale_eng = "display:none",locale_loc="display:none",langid="",called_from="";
		String sDefaultEnglish="selected",sDefaultLocLang="",localLang="",displayStyle="display:none",displayStyleLocal="display:none";
		ArrayList orderIdList = new ArrayList();//added for ML-BRU-SCF-1521.1 [IN:055331] 
		DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);
		DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
		String medplan_bean_id="MedicationPlannerBean";
		String medplan_bean_name="ePH.MedicationPlannerBean";
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request); 
		medplan_bean.setObject(dispBean);
		medplan_bean.setObject(all_bean);
		medplan_bean.setLanguageId(locale);
		con = ConnectionManager.getConnection(request); // Added for ML-BRU-CRF-0469 [IN:065426] - Start
		boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); // Added for ML-BRU-CRF-0469 [IN:065426] - End
		
		if(med_plan_check.equals("Y")){
			 called_from = "printDialog";
			 if(((ArrayList)medplan_bean.getMediPlanSeqNo()).size()>0)
			 	mediplan_seq_no = (String)((ArrayList)medplan_bean.getMediPlanSeqNo()).get(0);
		}
		String  strarrKey[] = new String[4];
		String disp_stage = dispBean.getDispStage();
		ArrayList disp_nos = all_bean.getDispNos();//added for ML-BRU-SCF-1521.1 [IN:055331]
		String sysdate = dispBean.getTodaysDate();
		if(sysdate.equals(""))
			sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
		String patient_class = dispBean.getPatientclass();
		ArrayList langIdName = all_bean.getDefLangForLabel(patient_class);
		if(sel_lang!=null){
			langid = sel_lang;
			if(sel_lang.equals("en")){
				langIdName = all_bean.getLangNameAndId(medplan_bean.getStrLocalLangID());
				locale_eng 			= "display:inline";
				sDefaultEnglish		=	"selected";
				sDefaultLocLang		=	"";
			}
			else{
				langIdName = all_bean.getLangNameAndId(sel_lang);
				locale_loc 			= "display:inline";
				sDefaultEnglish		=	"";
				sDefaultLocLang		=	"selected";
			}
		}
		else{
			if(langIdName==null || langIdName.size()==0 ){ 
				if(!locale.equals("en") ){
					langIdName = all_bean.getLangNameAndId(locale);
					locale_loc 	= "display:inline";
					langid		= (String)langIdName.get(0);
					sDefaultEnglish		=	"";
					sDefaultLocLang		=	"selected";
				}
				else{
					langIdName = all_bean.getLangNameAndId(medplan_bean.getStrLocalLangID());
					locale_eng = "display:inline";
					langid		= (String)langIdName.get(0);
					sDefaultEnglish		=	"selected";
					sDefaultLocLang		=	"";
				}
			}
			else { 
				if(((String)langIdName.get(0)).equals("en")){
					locale_eng = "display:inline";
					langid		= (String)langIdName.get(0);
					langIdName = all_bean.getLangNameAndId(medplan_bean.getStrLocalLangID());
					sDefaultEnglish		=	"selected";
					sDefaultLocLang		=	"";
				}
				else{
					locale_loc 	= "display:inline";
					langid		= (String)langIdName.get(0);
					sDefaultEnglish		=	"";
					sDefaultLocLang		=	"selected";
				}
			}
		}
		int count[] = {0,0,0,0,0};
		ArrayList<String> mediplan_report_query=medplan_bean.getMediplan_report_query();
		if(medplan_bean.getStrCalledFrom().equals("Report") && !mediplan_report_query.get(6).equals("D")){
				count[0]=0;
				count[1]=0;
				count[2]=Integer.parseInt(mediplan_report_query.get(1));
				count[3]=0;
				count[4]=Integer.parseInt(mediplan_report_query.get(1));
		}	
		else
			count = medplan_bean.getCountActiveDrugs(patient_id,medplan_bean.getStrCalledFrom());
		if(called_from.equals("printDialog"))//if else Added for [IN:051482]
			medplan_bean.setMediplanDetails(medplan_bean.getMedOrderIds(),patient_id);
		else if(!medplan_bean.isMedValuesChanged())
				medplan_bean.setMediplanDetails(medplan_bean.getMedOrderIds(),patient_id);
		if(medplan_bean.getStrCalledFrom().equals("Report"))
			medplan_bean.getTotalPrice_Report(mediplan_report_query.get(1),mediplan_report_query.get(0),mediplan_report_query.get(4),mediplan_report_query.get(5));
		LinkedHashMap hshDrugMap = medplan_bean.getMedPlan_DrugDetails();
		Set <String> hshKeys = new HashSet<String>();
		hshKeys = hshDrugMap.keySet();
		LinkedHashMap hshtemp = new LinkedHashMap();
		int i=0,totalrecords=0; 
		for(String key:hshKeys){//added for ML-BRU-SCF-1521.1 [IN:055331] Start
			strarrKey = key.split("_");
			orderIdList.add(strarrKey[0]);
		}
		if(disp_nos!=null){
			for(int q=0;q<disp_nos.size();q++){
				String ordId= all_bean.getOrderIdForDisp((String)disp_nos.get(q),disp_stage);
				for(int h=0;h<orderIdList.size();h++){
					if(((String)orderIdList.get(h)).equals(ordId)){
						tmpOrdId = ordId+"-"+disp_nos.get(q);
						orderIdList.set(h,tmpOrdId);
					}
				}
			}
		} //added for ML-BRU-SCF-1521.1 [IN:055331] End
%>
		<table cellpadding="0" cellspacing="1" width="99%" align="center" border="0">
		<tr>
		<td>
		<table cellpadding="0" cellspacing="1" width="25%" align="center" border="0">
			<tr>
				<td class="label" id="Hospname"></td>
			</tr>
			<tr>
				<td class="label" id="facility_displocn"></td>
			</tr>
			<tr>
				<td class="label" id="mediplan"></td>
			</tr>
		</table>
		<label  class="label"><fmt:message key="Common.SelectLanguage.label" bundle="${common_labels}" /></label>&nbsp;
			<select name="sel_Language" id="sel_Language" onChange='enablelocale(this.value)'>
				<option value="" selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
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
		
		<div id="table_locale_eng" style="<%=locale_eng%>">
		<br>
		<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
			<tr>
				<td class="label" width="30%">Patient ID : <%=patient_id%></td>
				<td class="label" width="50%">Patient Name : <%=dispBean.getPatient_name(patient_id,medplan_bean.getStrPrimaryLangID())%></td>
				<td class="label" width="20%">Dispensing Date : <%=sysdate%></td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
			<thead>
				<th class="COLUMNHEADER" >Select</th>
				<th class="COLUMNHEADER" >No.</th>
				<th class="COLUMNHEADER" >Drug Name</th>
				<th class="COLUMNHEADER" >Qty Issue&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></th>
				<th class="COLUMNHEADER" >How To Take</th>
				<th class="COLUMNHEADER" >Morning</th>
				<th class="COLUMNHEADER" >Afternoon</th>
				<th class="COLUMNHEADER" >Evening</th>
				<th class="COLUMNHEADER" >Night</th>
				<th class="COLUMNHEADER" >Important Notes</th>
			</thead>
<%			if(hshKeys!=null && hshKeys.size()>0){
				for(String key:hshKeys){
					hshtemp = (LinkedHashMap)hshDrugMap.get(key);
					uom = new String[2];//ML-BRU-SCF-1781
					strarrKey = key.split("_");
//					uom1 = ((String)hshtemp.get("qty_issue")).split(" ");//added for ML-BRU-SCF-1521.1 [IN:055331] and changed uom to uom1 for ML-BRU-SCF-1781
					if(((String)hshtemp.get("qty_issue")).indexOf(" ")!=-1){//if condition added for ML-BRU-SCF-1781
						uom1 = ((String)hshtemp.get("qty_issue")).split(" ");
					
						if(uom1.length>1)
							uom[1] = uom1[1];
						else
							uom[1] = "";
					}
					else
						uom[1] ="";
					/*if(uom.length>1)//commented for ML-BRU-SCF-1781
						uom[1] = uom[1];
					else
						uom[1] = "";*/
					i++;totalrecords++;
					if(hshtemp.get("medicationplanner_flag")!=null)//added for ML-BRU-SCF-1521.1 [IN:055331] Start
						mp_flag = Boolean.parseBoolean((String)hshtemp.get("medicationplanner_flag"));
					if(mp_flag){
						qty_issue = (String)hshtemp.get("qty_issue");
						qty_issue_prop=qty_issue;//ADDED FOR ML-BRU-SCF-1795
					}
					else{
						   qty_issue = all_bean.getDrugQuantity(patient_id, strarrKey[0], strarrKey[1]);
						
						if(qty_issue==""||qty_issue==null || qty_issue.equals("0")){ // || qty_issue.equals("0") added for ML-BRU-SCF-1851
							int ordLen = strarrKey[0].length();
							for(int j=0;j<orderIdList.size();j++){
								tempDispNos  = (String)orderIdList.get(j);
								if(tempDispNos.length()!= strarrKey[0].length()){
									tempDispNos =tempDispNos.substring(0,ordLen);
									if(tempDispNos.equals(strarrKey[0])){
										dispNosOrder = ((String)orderIdList.get(j)).substring(ordLen+1,((String)orderIdList.get(j)).length());
										qty_issue = all_bean.getDispQuantity(dispNosOrder,strarrKey[0], strarrKey[1],disp_stage,"N","");//"N","" added for ML-BRU-SCF-1714
									}
								}
							}
						}
						if(qty_issue.equals("")){//added for ML-BRU-SCF-1795
							qty_issue="0.0";
						}
						qty_issue_prop=qty_issue;//ADDED FOR ML-BRU-SCF-1795
						qty_issue = qty_issue+" "+uom[1];
					}//added for ML-BRU-SCF-1521.1 [IN:055331] End
%>
			<tr>
				<td align="center" width="3%"><input type="checkbox" name="chkdrug" id="chkdrug" <%=(String)hshtemp.get("checked") %> value="<%=(String)hshtemp.get("chkdrug")%>" onClick="selectDrug('<%=strarrKey[0]%>','<%=strarrKey[1]%>','<%=strarrKey[2]%>',this,'<%=totalrecords-1%>')"/></td>
				<td  align="center" width="2%"><%=i%></td>
				<td align="left" width="13%" class="label"><%=(String)hshtemp.get("drug_name")%>&nbsp;</td>
				<td align="center" width="8%" ><input type="text" size="15" name="txt_qty" id="txt_qty" maxlength="40" value="<%=qty_issue%>" onBlur="makeValidString(this)"/>&nbsp;</td><!-- Changed hshtemp.get("qty_issue") to qty_issue for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone) -->
				<td align="center" width="19%" class="label"><textarea rows="3" cols="40" name="txt_howtotake" maxlength="1500" onKeyPress="return checkMaxLimit(this,1500);" onChange="checkMaxLimit_textarea(this,1500,'How To Take');makeValidString(this)" title="<%=(String)hshtemp.get("howtotake")%>"><%=(String)hshtemp.get("howtotake")%></textarea></td>
				<%
				if(!qty_issue_prop.equals("0.0") && !qty_issue_prop.equals("") && !qty_issue_prop.equals("0")  ){ //added for ml-bru-scf-1795%>
				<td align="center" width="8%"><input type="text" size="15" name="txt_morning" id="txt_morning" maxlength="150" value="<%=(String)hshtemp.get("morning")%>" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_afternoon" id="txt_afternoon" maxlength="150" value="<%=(String)hshtemp.get("afternoon")%>" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_evening" id="txt_evening" maxlength="150" value="<%=(String)hshtemp.get("evening")%>" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_night" id="txt_night" maxlength="150" value="<%=(String)hshtemp.get("night")%>" onBlur="makeValidString(this)"/></td>
				
			<%} else { %>
				<td align="center" width="8%"><input type="text" size="15" name="txt_morning" id="txt_morning" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_afternoon" id="txt_afternoon" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_evening" id="txt_evening" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_night" id="txt_night" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				
			<%} %>
			<td align="center" width="23%"><textarea rows="3" cols="40" name="txt_imp_note" maxlength="1500" onKeyPress="return checkMaxLimit(this,1500);" onChange="checkMaxLimit_textarea(this,1500,'Imp Notes');makeValidString(this)" title="<%=(String)hshtemp.get("impnote")%>"><%=(String)hshtemp.get("impnote")%></textarea></td>
			</tr>
			<input type="hidden" name="medplanid" id="medplanid" value="<%=CommonBean.checkForNull((String)hshtemp.get("med_plan_id"))%>"/>
			<input type="hidden" name="order_id" id="order_id" value="<%=strarrKey[0]%>"/>
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=strarrKey[1]%>"/>
			<input type="hidden" name="pres_drug_code" id="pres_drug_code" value="<%=(String)hshtemp.get("pres_drug_code")%>"/>
			<input type="hidden" name="disp_drug_code" id="disp_drug_code" value="<%=strarrKey[2]%>"/>
			<input type="hidden" name="curr_disp_yn" id="curr_disp_yn" value="<%=(String)hshtemp.get("curr_disp_yn")%>"/>
			<input type="hidden" name="merged_yn" id="merged_yn" value="<%=(String)hshtemp.get("merge_yn")%>"/>
			<input type="hidden" name="merged_med_plan_id" id="merged_med_plan_id" value="<%=CommonBean.checkForNull((String)hshtemp.get("merged_med_plan_id"))%>"/>
			<input type="hidden" name="disp_no" id="disp_no" value="<%=CommonBean.checkForNull((String)hshtemp.get("disp_no"))%>"/>
			<input type="hidden" name="disp_srl_no" id="disp_srl_no" value="<%=CommonBean.checkForNull((String)hshtemp.get("disp_srl_no"))%>"/>
			<input type="hidden" name="locale" id="locale" value="<%=strarrKey[3]%>"/>
			<input type="hidden" name="drug_name" id="drug_name" value="<%=(String)hshtemp.get("drug_name")%>"/>
<%				}
			}
%>			
		</table>
		<br>
		<table  cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			<table  cellpadding="0" cellspacing="0" width="60%" align="right" border="1">
			<%if(displayGrossAmtYn){ // if else condition Added for ML-BRU-CRF-0469 [IN:065426], below 3 total labels Added for same ML-BRU-CRF-0469  - Start %>
			
			<tr>
				<td class='label' width='10%' style='TEXT-ALIGN:right;'><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></th>
				<td class='label'width='10%' style='TEXT-ALIGN:right;'><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></th>
				<td class='label' width='10%' style='TEXT-ALIGN:right;'><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			   <td class='label'  style='TEXT-ALIGN:right;' ><%=medplan_bean.getStrTotal_gross_amount()%></td>
			   <td  class='label'  style='TEXT-ALIGN:right;'><%=medplan_bean.getstrTotal_charge_amount()%></td>
			   <td  class='label'  style='TEXT-ALIGN:right;'><%=medplan_bean.getStrTotal_gross_charge_amount()%></td>
			</tr>
			<tr>
			</tr>
			<%} else{  %>
			<tr>
				<td align="right"><fmt:message key="Common.total.label" bundle="${common_labels}" /> <fmt:message	key="Common.Price.label" bundle="${common_labels}" /> : <%=medplan_bean.getStrTotal_gross_charge_amount()%></td>
			</tr>
			<%}  // if else condition Added ML-BRU-CRF-0469 [IN:065426] - End%>
			</table>
		</table>
		</div>
		<div id="table_locale_loc" style="<%=locale_loc%>">
		<br>
		<table cellpadding="0" cellspacing="1" width="100%" align="center" border="0">
			<tr>
				<td class="label" width="30%">No.Pendaftaran : <%=patient_id%></td>
				<td class="label" width="50%">Nama Pesakit : <%=dispBean.getPatient_name(patient_id,medplan_bean.getStrLocalLangID())%></td>
				<td class="label" width="20%">Tarikh Pemberian : <%=sysdate%></td>
			</tr>
		</table>
		<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
			<thead>
				<th class="COLUMNHEADER" >Memilih</th>
				<th class="COLUMNHEADER" >No.</th>
				<th class="COLUMNHEADER" >Nama Ubat Awda</th>
				<th class="COLUMNHEADER" >Kuantiti Dibekalkan&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></th>
				<th class="COLUMNHEADER" >Cara Penggunaan</th>
				<th class="COLUMNHEADER" >Pagi</th>
				<th class="COLUMNHEADER" >Tengah Hari</th>
				<th class="COLUMNHEADER" >Petang</th>
				<th class="COLUMNHEADER" >Malam</th>
				<th class="COLUMNHEADER" >Nota Penting</th>
			</thead>
<%				hshDrugMap = medplan_bean.getMedPlan_Local_DrugDetails();
				hshKeys = hshDrugMap.keySet();
				if(hshKeys!=null && hshKeys.size()>0){
				i=0;
				for(String key:hshKeys){
					hshtemp = (LinkedHashMap)hshDrugMap.get(key);
					uom_local = new String[2];
					strarrKey = key.split("_");
					//uom_local = ((String)hshtemp.get("qty_issue")).split(" ");
					if(((String)hshtemp.get("qty_issuelocal")).indexOf(" ")!=-1){//if condition added for ML-BRU-SCF-1781 modifed for ml-BRU-scf-1885
				
						uom1 = ((String)hshtemp.get("qty_issuelocal")).split(" ");//modifed for ml-BRU-scf-1885
						
						if(uom1.length>1){
							uom_local[1] = uom1[1];
						}
						else{
							uom_local[1] = "";
						}
					}else{
							uom_local[1] = "";
					}

					/*if(uom_local.length>1)//added for ML-BRU-SCF-1521.1 [IN:055331]
						uom_local[1] = uom_local[1];
					else
						uom_local[1] = ""; */
					i++;totalrecords++;
					if(hshtemp.get("medicationplanner_flag")!=null) //added for ML-BRU-SCF-1521.1 [IN:055331] Start
						mp_flag = Boolean.parseBoolean((String)hshtemp.get("medicationplanner_flag"));
					if(mp_flag){
						qty_issuelocal = (String)hshtemp.get("qty_issuelocal");
						qty_issue_proplocal=qty_issuelocal;//ADDED FOR ML-BRU-SCF-1795
					}
					else{
						    qty_issuelocal = all_bean.getDrugQuantity(patient_id, strarrKey[0], strarrKey[1]);
						   
						if(qty_issuelocal==""||qty_issuelocal==null || qty_issuelocal.equals("0")){ // || qty_issuelocal.equals("0") Added for ML-BRU-SCF-1851
							int ordLen = strarrKey[0].length();
							for(int j=0;j<orderIdList.size();j++){
								tempDispNos  = (String)orderIdList.get(j);
								if(tempDispNos.length()!= strarrKey[0].length()){
									tempDispNos =tempDispNos.substring(0,ordLen);
									if(tempDispNos.equals(strarrKey[0])){
										dispNosOrder = ((String)orderIdList.get(j)).substring(ordLen+1,((String)orderIdList.get(j)).length());
										qty_issuelocal = all_bean.getDispQuantity(dispNosOrder,strarrKey[0], strarrKey[1],disp_stage,"N","");//"N","" added for ML-BRU-SCF-1714
									}
								}
							}
						}
						if(qty_issuelocal.equals("")){//added for ML-BRU-SCF-1795
							qty_issuelocal="0.0";
						}
						qty_issue_proplocal=qty_issuelocal;//ADDED FOR ML-BRU-SCF-1795
							qty_issuelocal = qty_issuelocal+" "+uom_local[1];
					} //added for ML-BRU-SCF-1521.1 [IN:055331] End
%>
			<tr>
				<td align="center" width="3%"><input type="checkbox" name="chkdrug" id="chkdrug" <%=(String)hshtemp.get("checked") %> value="<%=(String)hshtemp.get("chkdrug")%>" onClick="selectDrug('<%=strarrKey[0]%>','<%=strarrKey[1]%>','<%=strarrKey[2]%>',this,'<%=totalrecords-1%>')"/></td>
				<td  align="center" width="2%"><%=i%></td>
				<td align="left" width="13%" class="label"><%=(String)hshtemp.get("drug_name_local")%>&nbsp;</td>
				<td align="center" width="8%" ><input type="text" size="15" name="txt_qty" id="txt_qty" maxlength="40" value="<%=qty_issuelocal%>" onBlur="makeValidString(this)"/></td><!-- Changed hshtemp.get("qty_issuelocal") to qty_issuelocal for ML-BRU-SCF-1521.1 [IN:055331](medication planner point alone) -->
				<td align="center" width="19%" class="label"><textarea rows="3" cols="40" name="txt_howtotake" maxlength="1500" onKeyPress="return checkMaxLimit(this,1500);" onChange="checkMaxLimit_textarea(this,1500,'How To Take');makeValidString(this)" title="<%=(String)hshtemp.get("howtotakelocal")%>"><%=(String)hshtemp.get("howtotakelocal")%></textarea></td>
			<%if(!qty_issue_proplocal.equals("0.0") && !qty_issue_proplocal.equals("") &&  !qty_issue_proplocal.equals("0") ){ %>
				<td align="center" width="8%"><input type="text" size="15" name="txt_morning" id="txt_morning" maxlength="150" value="<%=(String)hshtemp.get("morninglocal")%>" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_afternoon" id="txt_afternoon" maxlength="150" value="<%=(String)hshtemp.get("afternoonlocal")%>" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_evening" id="txt_evening" maxlength="150" value="<%=(String)hshtemp.get("eveninglocal")%>" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_night" id="txt_night" maxlength="150" value="<%=(String)hshtemp.get("nightlocal")%>" onBlur="makeValidString(this)"/></td>
				
			<%}else{ %>
			<td align="center" width="8%"><input type="text" size="15" name="txt_morning" id="txt_morning" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_afternoon" id="txt_afternoon" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_evening" id="txt_evening" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
				<td align="center" width="8%"><input type="text" size="15" name="txt_night" id="txt_night" maxlength="150" value="" onBlur="makeValidString(this)"/></td>
			<%} %>
				<td align="center" width="23%"><textarea rows="3" cols="40" name="txt_imp_note" maxlength="1500" onKeyPress="return checkMaxLimit(this,1500);" onChange="checkMaxLimit_textarea(this,1500,'Imp Notes');makeValidString(this)" title="<%=(String)hshtemp.get("impnotelocal")%>"><%=(String)hshtemp.get("impnotelocal")%></textarea></td>
			</tr>
			<input type="hidden" name="medplanid" id="medplanid" value="<%=CommonBean.checkForNull((String)hshtemp.get("med_plan_id"))%>"/>
			<input type="hidden" name="order_id" id="order_id" value="<%=strarrKey[0]%>"/>
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=strarrKey[1]%>"/>
			<input type="hidden" name="pres_drug_code" id="pres_drug_code" value="<%=(String)hshtemp.get("pres_drug_code")%>"/>
			<input type="hidden" name="disp_drug_code" id="disp_drug_code" value="<%=strarrKey[2]%>"/>
			<input type="hidden" name="curr_disp_yn" id="curr_disp_yn" value="<%=(String)hshtemp.get("curr_disp_yn")%>"/>
			<input type="hidden" name="merged_yn" id="merged_yn" value="<%=(String)hshtemp.get("merge_yn")%>"/>
			<input type="hidden" name="merged_med_plan_id" id="merged_med_plan_id" value="<%=CommonBean.checkForNull((String)hshtemp.get("merged_med_plan_id"))%>"/>
			<input type="hidden" name="disp_no" id="disp_no" value="<%=CommonBean.checkForNull((String)hshtemp.get("disp_no"))%>"/>
			<input type="hidden" name="disp_srl_no" id="disp_srl_no" value="<%=CommonBean.checkForNull((String)hshtemp.get("disp_srl_no"))%>"/>
			<input type="hidden" name="locale" id="locale" value="<%=strarrKey[3]%>"/>
			<input type="hidden" name="drug_name" id="drug_name" value="<%=(String)hshtemp.get("drug_name_local")%>"/>
<%				}
			}
%>			
		</table>
		<br>
		<table  cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
			<tr>
				<td align="right">Jumlah Harga Ubat : <%=medplan_bean.getStrTotal_gross_charge_amount()%></td>
			</tr>
		</table>
		</div>
		<br>
		<table  cellpadding="0" cellspacing="0" width="15%" align="right" border="0">
			<tr>
				<% if(count[0]>0 && totalrecords>0){ %>
				<td><input type="button" id="btnActive" value='<fmt:message key="Common.Add.label" bundle="${common_labels}" /> <fmt:message key="Common.active.label" bundle="${common_labels}" /> <fmt:message key="Common.Drug.label" bundle="${common_labels}" />' class="button" onClick="callActiveOrders_Plan('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>','<%=med_plan_check%>');"/></td>
				<% } 
				if(count[1]>0 && totalrecords>0 && langid.equals(medplan_bean.getStrPrimaryLangID()))
					displayStyle = "display:inline";
				else if(count[3]>0 && totalrecords>0 && langid.equals(medplan_bean.getStrLocalLangID()))
					displayStyleLocal = "display:inline";
				%>
				<td style="<%=displayStyle%>" id="tdMerge"><input type="button" id="btnMerge" value='<fmt:message key="ePH.MergeMedicationPlan.label" bundle="${ph_labels}" />' class="button" onClick="callMergeMedPlan('<%=patient_id%>','<%=encounter_id%>','<%=count[2]%>','<%=med_plan_check%>');"/></td>
				<td style="<%=displayStyleLocal%>" id="tdMergeLocal"><input type="button" id="btnMergeLocal" value='<fmt:message key="ePH.MergeMedicationPlan.label" bundle="${ph_labels}" />' class="button" onClick="callMergeMedPlan('<%=patient_id%>','<%=encounter_id%>','<%=count[4]%>','<%=med_plan_check%>');"/></td><!-- // Added for [IN:051822] -->
				<% if(med_plan_check.equals("Y")){ %>
				<td><input type="button" id="btnPrint" value='<fmt:message key="Common.print.label" bundle="${common_labels}" />' class="button" onClick="<%if(totalrecords>0){%>recordMediPlan('Print','<%=mediplan_seq_no%>');<%}else{%>window.close()<%}%>"/></td>
				<% } %>
				<td><input type="button" id="btnOk" value='<fmt:message key="Common.ok.label" bundle="${common_labels}" />' class="button" onClick="<%if(totalrecords>0){%>recordMediPlan('<%=called_from%>','<%=mediplan_seq_no%>');<%}else{%>window.close()<%}%>"/></td>
				<td><input type="button" id="btnCancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' class="button" onClick="doCancel()"/></td>
			</tr>
		</table>
		</td>
		</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id" value=""/>
		<input type="hidden" name="bean_name" id="bean_name" value=""/>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"/>
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"/>
		<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>"/>
		<input type="hidden" name="disp_loc_code" id="disp_loc_code" value="<%=dispBean.getDispLocnCode()%>"/>
		<input type="hidden" name="link" id="link" value="<%=langid%>"/>
		<input type="hidden" name="mergecount_primary" id="mergecount_primary" value="<%=count[1]%>"/>
		<input type="hidden" name="mergecount_local" id="mergecount_local" value="<%=count[3]%>"/>
		<input type="hidden" name="strname" id="strname" value="<%=medplan_bean.getStrSiteName()%>"/>
		<input type="hidden" name="strnamelocal" id="strnamelocal" value="<%=medplan_bean.getStrSiteNameLocal()%>"/>
		<input type="hidden" name="facility_disp" id="facility_disp" value="<%=medplan_bean.getStrFacility_DispLoc()%>"/>
		<input type="hidden" name="facility_displocal" id="facility_displocal" value="<%=medplan_bean.getStrFacility_DispLocLocal()%>"/>
	</form>
	</body>
	<script type="text/javascript">
	loadHeader('<%=langid%>');
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
		<%  putObjectInBean(medplan_bean_id,medplan_bean,request);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
           finally{ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
        	   if(con != null){
        	    ConnectionManager.returnConnection(con,request);
        	   }
           }  // Added for ML-BRU-CRF-0469 [IN:065426] - End
		%>
</html>


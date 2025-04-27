<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, java.io.*,ePH.*,ePH.Common.*,eCommon.Common.*,java.text.*,java.net.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html> 
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" SRC="../../eCommon/js/dchk.js"></script>
		<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../js/ADRReporting.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
try{
		String mode=(String)CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		ArrayList other_medications=new ArrayList();
		ArrayList drug_details=new ArrayList();
		ArrayList trade_details=new ArrayList();
		ArrayList administeredDate=new ArrayList();
		ArrayList dosageDetailsList=new ArrayList();
		ArrayList	adrList=new ArrayList();
		HashMap adrDetails=new HashMap();
		ArrayList	drugCodes=new ArrayList();
		HashMap	adrValues	= new HashMap();
		ArrayList certainityCodes=new ArrayList();
		HashMap certValues=new HashMap();

		String diagnosis="";
		String sysdate="";
		//Declaration of variables needed for Other_Medication tab.
		String drug="";
		String route="";
		String dosagedetails="";
		String startdate="";
		String enddate="";
		String dispqty="";
		String adminqty="";
		String practitioner="";
		String location="";
		String orderid="";
		String ordlnenum="";
		String drugCode="";
		String genericId="";
		//Declaration of variables needed for Drug_detail tab.
		String drug_name="";
		String generic_name="";
		String strength="";
		String strength_uom="";
		String route_desc="";
		String form="";
		String generic_id="";

		//Declaration of variables needed for Prescription_detail
		String qty_value="";
		String qty_unit="";
		String freq_desc="";
		String durn_value="";
		String durn_desc="";
		String start_date="";
		String end_date="";

		//Declaration of variables needed for the tradedetails.
		String trade_name="";
		String trade_code="";
		String trd_code="";

		//Declaration of variables needed for other medications.
		String checked = "";
		String chkBoxValue = "N";

		//Declaration of variables needed for Reaction Details.
		String adminDateTime = "";
		String dosage = "";
		String adminBy = "";
		String batchId = "";
		String expiryDate = "";
		String manufacturer = "";
		String supplier = "";
		String onsetDateTime = "";
		String timeToOnsetReaction = "";
		String timeToORType = "";
		String adrType = "";
		String extntOfRctn = "";
		String drugRctnRltn = "";
		String rctnStpdMedcn = "";
		String rctnReintroMedcn = "";
		String allergy_type_code="";
		String allergy_type_desc="";
		String sys_id_rlsp_code="";
		String sys_id_rlsp_desc="";
		String status_act="";
		String sourceOfInfo="";
		String certanity="";
		String hypersensitivity="";
		String admin_date = "";

		ArrayList questionnaire=new ArrayList();
		//  HashMap qusetionnairemap=new HashMap();

		String Minutes = "";
		String Hours = "";
		String Days = "";
		String Mild="",Moderate="",Severe="";
		//String Probble="",certain="",possible="",
		// String Unclassifiable="";
		String stY="",stN="",reY="",reN="";
		String outcome="";
		String notrecovered="",fatal="",unknown="";
		String hy01="",hy02="",hy03="",hy04="";
		String cerP="",cerD="";
		String staA="",staR="",staE="";
		String souP="",souA="",souS="";
		if(hypersensitivity.equals("")) {
			hypersensitivity="01";
			hy01="checked";
		}
		if(certanity.equals("")){
			certanity="D";
			cerD="checked";
		}
		if(status_act.equals("")){
			status_act="A";
			staA="checked";
	   }
	   if(sourceOfInfo.equals("")){
			sourceOfInfo="P";
			souP="checked";
	   }
		//Declaration of variables needed for Remarks.
		String adtnlMedcn = "";
		String adr_description = "";
		String adr_treatment = "";
		String rlvntInvstgtn = "";
		String rlvntHistory = "";
		String vrfdBy = "";
		String disable = "";
		// added for CRF RUT-CRF-0034.1[IN:037389]-start
		String route_color			        =  "";
		String backgrndColor                =  "";
	    String fntColor                     =  "";
		// added for CRF RUT-CRF-0034.1[IN:037389]-end

		int flag=0;
		if ( mode == null || mode.equals("") )
			return ;

		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;

		String login_user		=	(String)session.getValue("login_user");
		vrfdBy = login_user;
		String	bean_id			=	"ADRReport" ;
		String	bean_name		=	"ePH.ADRReportBean";

		//	ADRReportBean bean = (ADRReportBean)mh.getBeanObject( bean_id, request, bean_name ) ;

		ADRReportBean bean = (ADRReportBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		sysdate=bean.getSysdate();

		int no_decimals =bean.getNoOfDecimals() ;
		String decimalStringFormat = "#.";
		// if Condition added for IN18681 to avoid displaying decimal point after the number  --01/02/2010--   shyampriya
		if(no_decimals == 0)
			decimalStringFormat = "#";
		for (int i=0;i<no_decimals;i++){
			decimalStringFormat += "#";
		}
		DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	

		String patient_name=request.getParameter("patient_name")==null?"":request.getParameter("patient_name");
		String drug_name1=request.getParameter("drug_name1")==null?"":request.getParameter("drug_name1");

		String patient_id=request.getParameter("patient_id");
		String order_id=request.getParameter("ord_id");
		int order_line=0;
		if(patient_id!=null && patient_id.length()!=0){
			order_line=Integer.parseInt(request.getParameter("ord_line"));
		}
		String drug_code=request.getParameter("drg_code")==null?"":request.getParameter("drg_code");
		String mode1 = request.getParameter("mode")==null?"":request.getParameter("mode");	
		String adr_no = request.getParameter("adr_no")==null?"":request.getParameter("adr_no");	
		// below lines are commented  for ML-BRU-SCF-0094[31887]
		/*String ethnic_grp = request.getParameter("ethnic_grp");	
		if(ethnic_grp == null) ethnic_grp = ""; */   
		String sgndBy = request.getParameter("sgndBy")==null?"":request.getParameter("sgndBy");	
		if(sgndBy.equals(""))
			sgndBy = "";
		else
			disable = "disabled";
		String called_frm = request.getParameter("called_frm")==null?"":request.getParameter("called_frm");	
		if(called_frm.equals("Prescription")){
			disable = "disabled"; 
		}
		String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id"); //Code added for added for 33963	
		questionnaire=bean.LoadQuestionnaire(mode1,adr_no,sgndBy);
		bean.setQuestionnaire(questionnaire);
		administeredDate=bean.loadAdministeredDate(order_id,order_line);
		if(patient_id!=null && patient_id.length()!=0){
			dosageDetailsList=bean.loadDosageName(order_id,order_line);	
			if(dosageDetailsList!=null && dosageDetailsList.size()>0)
				dosage = (dosageDetailsList.get(0)==null?"":(String)dosageDetailsList.get(0)).trim(); // added trim() for 30917 	
		}
		certainityCodes=bean.certCodes();
		adrList					=bean.loadADRTypes();
		String extDrug_yn="";
		
%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >    
			<form name="AdrReportingTab_form" id="AdrReportingTab_form">
				<table cellpadding=0 cellspacing=0 width="102%" align="center" border="0" id="Tabs_Table">	
					<tr>
						<td class="CASECONDSELECTHORZ"  onClick="changeButtonColor(this,'PH_BUTTONS');Display('DrugDetail')" nowrap> 
						<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer"><fmt:message 
						 key="ePH.DrugDetail.label" bundle="${ph_labels}"/></a>
						</td>
						<td class="CAFIRSTSELECTHORZ"  onClick="changeButtonColor(this,'PH_BUTTONS');Display('ADRReport')" nowrap>
						<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer"><fmt:message 
						 key="ePH.ReactionDetail.label" bundle="${ph_labels}"/></a>
						</td>
						<td class="CAFIRSTSELECTHORZ"  onClick="changeButtonColor(this,'PH_BUTTONS');Display('OtherMedication')" nowrap>
						<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer"><fmt:message  key="ePH.OtherMedications.label" bundle="${ph_labels}"/></a>
						</td>
						<td class="CAFIRSTSELECTHORZ"  onClick="changeButtonColor(this,'PH_BUTTONS');Display('Remarks')" nowrap>
						<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer"><fmt:message key="Common.remarks.label"  bundle="${common_labels}"/></a>
						</td>
					</tr>
				</table>
				<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" id="DrugDetail_table">
					<tr>
						<th colspan="8"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></th></tr>
<%
						String commavalue=",";
						String endDate1="";
						String endDate="";
						if(!mode1.equals("mode_modify")){//create
							try{
								if(order_id.indexOf("-")>=0)
									drug_details=(ArrayList)bean.getExtDrugDetails(patient_id,order_line+"");
								else
									drug_details=(ArrayList)bean.getDrugDetails(order_id,order_line);
								if(drug_details.size() > 0){
									if(order_id.indexOf("-")>=0){
										drug_code=(String)drug_details.get(14);
										drug_name1=(String)drug_details.get(0);
										extDrug_yn ="("+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ExternalDrug.label", "ph_labels" )+")";
									}
									drug_name=(String)drug_details.get(0);
									generic_name=(String)drug_details.get(1);

									strength=(String)drug_details.get(2);
									if(strength!=null && !(strength.equals("")))
										strength = dfToInteger.format(Double.parseDouble(strength));

									strength_uom=(String)drug_details.get(3);
									route_desc=(String)drug_details.get(4);
									form=(String)drug_details.get(5);

									qty_value=(String)drug_details.get(6);
									if(qty_value!=null && !(qty_value.equals("")))
										qty_value = dfToInteger.format(Double.parseDouble(qty_value));

									qty_unit=(String)drug_details.get(7);
									freq_desc=(String)drug_details.get(8);
									durn_value=(String)drug_details.get(9);
									durn_desc=(String)drug_details.get(10);

									//			start_date=(String)drug_details.get(11);
									start_date= 	 DateUtils.convertDate((String)drug_details.get(11),"DMYHM","en",locale);
									//			end_date=(String)drug_details.get(12);
									end_date=DateUtils.convertDate((String)drug_details.get(12),"DMYHM","en",locale);
									generic_id=(String)drug_details.get(13);

									endDate1=end_date.substring(0,10);
									endDate=endDate1.concat(" 11:59");
									route_color=(String)drug_details.get(15);	// added for CRF RUT-CRF-0034.1[IN:037389]-start
									fntColor= "";
									backgrndColor= "";	// added for CRF RUT-CRF-0034.1[IN:037389]-End
									if(route_color!= null && !route_color.equals("")){
										if(route_color.length()==12){
											fntColor= route_color.substring(0, 6);
											backgrndColor= route_color.substring(6, 12);
										}
									}// added for CRF RUT-CRF-0034.1[IN:037389]-End
								}
							}
							catch(Exception exp){
								exp.printStackTrace();
							}
						}
						else{//modify
							diagnosis=(String)bean.getDiagnosis(adr_no);
							if(order_id.indexOf("-")>=0){
								drug_details=(ArrayList)bean.getExtDrugAdrDetails(patient_id,order_id, order_line+"", adr_no); //adr_no added for ML-BRU-SCF-1397 [IN:050181]
								extDrug_yn ="("+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ExternalDrug.label", "ph_labels" )+")";
							}
							else
								drug_details=(ArrayList)bean.getAdrDrugDetails(order_id,order_line);
							if(drug_details.size() > 0){

								drug_code		=(String)drug_details.get(0);
								drug_name		=(String)drug_details.get(1);
								generic_id		=(String)drug_details.get(2);
								generic_name	=(String)drug_details.get(3);

								strength=(String)drug_details.get(4);
								if(strength!=null && !(strength.equals("")))
									strength = dfToInteger.format(Double.parseDouble(strength));

								strength_uom	=(String)drug_details.get(5);
								route_desc		=(String)drug_details.get(6);
								form			=(String)drug_details.get(7);

								qty_value		=(String)drug_details.get(8);
								if(qty_value!=null && !(qty_value.equals("")))
									qty_value = dfToInteger.format(Double.parseDouble(qty_value));

								qty_unit		=(String)drug_details.get(9);
								freq_desc		=(String)drug_details.get(11);
								durn_value		=(String)drug_details.get(12);
								durn_desc		=(String)drug_details.get(13);

								//			start_date		=(String)drug_details.get(14);
								start_date		=DateUtils.convertDate((String)drug_details.get(14),"DMYHM","en",locale);
								//			end_date		=(String)drug_details.get(15);
								if(end_date!=null && !end_date.equals("")){
									end_date		=DateUtils.convertDate((String)drug_details.get(15),"DMYHM","en",locale);
									trd_code		=(String)drug_details.get(16);
									endDate1=end_date.substring(0,10);
									endDate=endDate1.concat(" 11:59");
								}
								else 
									end_date = "-";
								route_color=(String)drug_details.get(17);	// added for CRF RUT-CRF-0034.1[IN:037389]-start
								fntColor="";
								backgrndColor= "";
								if(route_color!= null && !route_color.equals("")){
									if(route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
								}	// added for CRF RUT-CRF-0034.1[IN:037389]-End
							}
						}
%>
						<tr>
							<td class="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class="label"  colspan="8"><b><%=drug_name%></b>&nbsp;<font color='red' ><%=extDrug_yn%></font></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr>
							<td class="label"><fmt:message key="Common.generic.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class="label" colspan="8"><b><%=generic_name%></b></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr>
							<td class="label"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
							<td colspan="8">
							<select name="trade_desc" id="trade_desc" <%=disable%> onChange="changeTradeSelectionValue()">
								<option value=''>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%
								trade_details=bean.getTradeDetails(drug_code);
								int trade_size=trade_details.size();
								for(int j=0;j<trade_size;j=j+2){
									trade_name=(String)trade_details.get(j);
									trade_code=(String)trade_details.get(j+1);

									if(trade_code.equals(trd_code)){
%>
										<option value="<%=trade_code%>" selected><%=trade_name%></option>
<%
									}
									else{
%>
										<option value="<%=trade_code%>"><%=trade_name%></option>
<%
									}
								}
								if(qty_unit!=null && !qty_unit.equals(""))
									qty_unit = qty_unit+",";
								if(freq_desc!=null && !freq_desc.equals(""))
									freq_desc = freq_desc+",";
%>
							</select>
							</td>
						</tr>  
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>			  
						<tr><td colspan="8"></td></tr>
						<tr>
							<td class="label" width="10%"><fmt:message key="Common.Strength.label"  bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class="data" colspan="1"><%=strength%>&nbsp;<%=strength_uom%></td>
							<td class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class="data" colspan="1" ><font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=route_desc%></font></td>
							<td class="label" width="25%">Form&nbsp;&nbsp;</td>
							<td class="data" colspan="3"><%=form%></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
					</table>
					<table cellpadding=0 cellspacing=0 border=0 width="102%" id="Prescription_table">
						<th colspan="8"><fmt:message key="ePH.PrescriptionDetail.label" bundle="${ph_labels}"/></th>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr>
							<td class="data" width="2%">&nbsp;&nbsp;<%=qty_value%></td>
							<td class="data" width="4%">&nbsp;<%=qty_unit%></td>
							<td class="data" width="16%">&nbsp;<%=freq_desc%></td>
							<td class="data" width="2%">&nbsp;<%=durn_value%></td>
							<td class="data" width="35%"><%=durn_desc%></td> 
							<!-- start_date-->
							<td class="data" width="18%"><%=start_date%></td>
							<td class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
							<!--end_date --> 
							<td class="data" width="18%"><%=end_date%></td>
						</tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
						<tr><td colspan="8"></td></tr>
					</table>
					<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0" id="Diagnosis_table">
						<tr><th colspan="5"><fmt:message key="ePH.DiagnosisDetail.label" bundle="${ph_labels}"/></th></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr>
							<td class="label" width="10%"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<%
							if(!mode1.equals("mode_modify")){
								diagnosis=(String)bean.getDiagnosisDescription(order_id,order_line);
							}
%>
							<td >
							<textarea name="Diagnosis" cols="90" rows="3" onKeyPress="return checkMaxLimit(this,255);" onBlur="callCheckMaxLen(this,255,'Diagnosis');" <%=disable%> ><%=diagnosis%></textarea>&nbsp; <input valign='top' type='button' name='diagnosis_search' id='diagnosis_search' value='?' class='button'  <%=disable%> onClick="callActive('<%=patient_id%>')" ></input></td>
						</tr>
<%
						if(patient_id==null || patient_id.length()==0){
%>
							<script>
								document.AdrReportingTab_form.diagnosis_search.disabled=true;
							</script>
<%
						}
%>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
						<tr><td colspan="5"></td></tr>
					</table>
					<table cellpadding=0 cellspacing=0 width="102%" align="center"  border="0" id="ADRReport_table" style="display:none">
						<tr><th colspan="6"><fmt:message key="ePH.AdministrationDetails.label" bundle="${ph_labels}"/></th> </TR>
						<tr><td colspan="6">&nbsp;</td></tr>  
<%
						if(mode1.equals("mode_modify")){//modify
							adrValues = bean.getAdrValues(adr_no,facility_id); //Code added for added for 33963	
							if(adrValues.size() > 0){
								adminDateTime = (String)adrValues.get("admin_date_time");	
								dosage = ((String)adrValues.get("dosage")==null?"":(String)adrValues.get("dosage")).trim(); // added trim() for 30917 		
								adminBy = (String)adrValues.get("admin_by");
								batchId = (String)adrValues.get("batch_id");
								expiryDate = (String)adrValues.get("expiry_date");
								manufacturer = (String)adrValues.get("manufacturer");
								supplier = (String)adrValues.get("supplier");
								onsetDateTime = (String)adrValues.get("onset_date_time");
								timeToOnsetReaction = (String)adrValues.get("durn_to_onset_reaction");
								timeToORType = (String)adrValues.get("durn_to_onset_reaction_type");
								if(!timeToORType.equals("")){
									if(timeToORType.equals("M"))
										Minutes = "Selected";
									else if(timeToORType.equals("H"))
										Hours = "Selected";
									else if(timeToORType.equals("D"))
										Days = "Selected";
								}
								//Added by Jyothi.G on 01/10/2010 to fix IN024115
								adminDateTime = com.ehis.util.DateUtils.convertDate(adminDateTime,"DMYHM","en",locale);
								expiryDate = com.ehis.util.DateUtils.convertDate(expiryDate,"DMY","en",locale);
								onsetDateTime = com.ehis.util.DateUtils.convertDate(onsetDateTime,"DMYHM","en",locale);
								//End

								adrType = (String)adrValues.get("adr_type");
								extntOfRctn = (String)adrValues.get("extent_of_reaction");
								if(!extntOfRctn.equals("")){
									if(extntOfRctn.equals("M")){
										Mild = "Selected";
									}
									else if(extntOfRctn.equals("O")){
										Moderate = "Selected";
									}
									else if(extntOfRctn.equals("S")){
										Severe = "Selected";
									}
								}
								drugRctnRltn = (String)adrValues.get("drug_reaction_relationship");
								sys_id_rlsp_desc  = (String)adrValues.get("sys_id_rlsp_desc");
								sys_id_rlsp_code  = (String)adrValues.get("sys_id_rlsp_code");
								allergy_type_desc	 = (String)adrValues.get("ALLERGY_TYPE_DESC");
								allergy_type_code	 = (String)adrValues.get("ALLERGY_TYPE_CODE");
								/*if(!drugRctnRltn.equals("")){
										if(drugRctnRltn.equals("P")){Probble = "Selected";}
										if(drugRctnRltn.equals("C")){certain = "Selected";}
										if(drugRctnRltn.equals("S")){possible = "Selected";}
										if(drugRctnRltn.equals("X")){Unclassifiable = "Selected";}
								}*/
								status_act=(String)adrValues.get("status_act");
								sourceOfInfo=(String)adrValues.get("sourceOfInfo");
								certanity=(String)adrValues.get("certanity");
								hypersensitivity=(String)adrValues.get("hypersensitivity");
								if(!hypersensitivity.equals("")){
									if(hypersensitivity.equals("01")) 
										hy01="checked";
									if(hypersensitivity.equals("02")) 
										hy02="checked";	 
									if(hypersensitivity.equals("03")) 
										hy03="checked";	 
									if(hypersensitivity.equals("04")) 
										hy04="checked";	 
								}
								if(!sourceOfInfo.equals("")){
									if(sourceOfInfo.equals("P")) 
										souP="checked";
									if(sourceOfInfo.equals("A")) 
										souA="checked";	 
									if(sourceOfInfo.equals("S")) 
										souS="checked";	 
								}

								if(!certanity.equals("")){
									if(certanity.equals("P"))
										cerP="checked";
									if(certanity.equals("D"))
										cerD="checked";	 
								}
								if(!status_act.equals("")){
									if(status_act.equals("A"))
										staA="checked";
									if(status_act.equals("R"))
										staR="checked";	 
									if(status_act.equals("E"))
										staE="checked";					
								}
								outcome  = (String)adrValues.get("outcome");
								if(!outcome.equals("")){
									if(outcome.equals("N"))
										notrecovered  = "Selected";
									if(outcome.equals("F"))
										fatal  = "Selected";
									if(outcome.equals("U"))
										unknown  = "Selected";
								}
								
								rctnStpdMedcn = (String)adrValues.get("reaction_on_stop_of_medn");
								if(!rctnStpdMedcn.equals("")){
									if(rctnStpdMedcn.equals("Y")){
										stY = "Selected";
									}
									else{
										if(rctnStpdMedcn.equals("N")){
											stN = "Selected";
										}
									}
								}
								
								rctnReintroMedcn = (String)adrValues.get("reaction_on_repetition");
								if(!rctnReintroMedcn.equals("")){
									if(rctnReintroMedcn.equals("Y")){
										reY = "Selected";
									}
									else{
										if(rctnReintroMedcn.equals("N")){
											reN = "Selected";
										}
									}
								}
						   
								adtnlMedcn = (String)adrValues.get("additional_medn");
								adr_description = (String)adrValues.get("ADR_DESCRIPTION");
								adr_treatment = (String)adrValues.get("adr_treatment");
								rlvntInvstgtn = (String)adrValues.get("relevant_investigation");
								rlvntHistory = (String)adrValues.get("relevant_history");
								vrfdBy = (String)adrValues.get("prepared_by");
								login_user = vrfdBy;
							}
						}
						if(administeredDate.size()>0){
							flag=1;
%>
							<tr>
								<td class="label" width="25%"><fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" colspan="6">
								<select name="adminsterDate" id="adminsterDate" onchange="loadDetails(this,'<%=patient_id%>','<%=order_id%>','<%=order_line%>')" <%=disable%> >
								<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
								for (int i=0;i<administeredDate.size();i++){
									admin_date = (String)administeredDate.get(i) == null ? "" : (String)administeredDate.get(i);
									admin_date = com.ehis.util.DateUtils.convertDate(admin_date,"DMYHM","en",locale);

									if(adminDateTime.equals("")){
										if(i==(administeredDate.size()-1)){
%>
											<option selected value="<%=admin_date%>"><%=admin_date%></option>
<%
										}
										else{
%>
											<option value="<%=admin_date%>"><%=admin_date%></option>
<%
										}
									}
									else{
										if(adminDateTime.equals(admin_date)){
%>
											<option selected value="<%=admin_date%>"><%=admin_date%></option>
<%
										}
										else{
%>
											<option value="<%=admin_date%>"><%=admin_date%></option>
<%
										}
									}
								}
%>
								</select>
								</td>
							</tr>
								<tr><td colspan="6">&nbsp;</td></tr>  
							 <tr>
								<td class="label" width="15%"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>

								<td class="label" width="25%"><B><%=dosage%> &nbsp;<%=(String)dosageDetailsList.get(1)%></B></td>
								<td class="label" width="15%"><fmt:message key="Common.AdministeredBy.label"  bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="label" colspan="2"><label id="lbladminBy"></label></td>
							</tr>
								<tr><td colspan="6">&nbsp;</td></tr>  
							 <tr>
								<td class="label" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" ><label id="lblbatchId"></label></td>
								<td class="label" width="15%"><fmt:message key="Common.expiryDate.label"  bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="label" colspan="2"><label id="lblexpiryDate"></label></td>
							</tr>
							<tr>
								<td colspan="6">&nbsp;</td>
							</tr>  
							<tr>
								<td class="label"><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="label"><label id="lblmanufacturer"></label></td>
								<td class="label" width="15%"><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td colspan="2" class="label"><label id="lblsupplier"></label></td>
							</tr>
<%
						}
						else{
%>
							<tr>
								<td class="label" width="25%"><fmt:message key="ePH.AdminDate/Time.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" colspan="6"><input type="text" name="adminsterDate" id="adminsterDate"  size="13"  value="<%=adminDateTime%>" maxlength="16" onblur="validateAdmintime(this); chkexpiryDate()" <%=disable%> >&nbsp;<IMG SRC="../../eCommon/images/CommonCalendar.gif"  id="administerCal" onclick="return showCalendar('adminsterDate',null,'hh:mm');" <%=disable%> ><img src="../../eCommon/images/mandatory.gif" align="center"></img>
								</td>
							</tr>

							<tr>
								<td class="label" width="15%"><fmt:message key="ePH.Drug/dose.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
<%
								String dosage1="";
								if(patient_id!=null && patient_id.length()!=0 && dosageDetailsList!=null && dosageDetailsList.size()>0){
									dosage1=(String)dosageDetailsList.get(1);
								}
%>
								<td class="field"><input type="text" value="<%=dosage%>" id="dosage" name="dosage" maxlength ="6" size="8" <%=disable%> onkeypress='return allowValidNumber(this,event,6,2);' onBlur="CheckValue(this);">&nbsp;<%=dosage1%> 
<%
								if(patient_id!=null && patient_id.length()!=0){
%>
									<img src="../../eCommon/images/mandatory.gif" align="center"></img>
<%
								}
%>
								</td>
								<td class="label" width="15%"><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" colspan="2"><INPUT type="text" name="administeredBy" id="administeredBy" value="<%=adminBy%>" size="32" maxlength="30" <%=disable%> ></td>
							</tr>
							<tr>
								<td class="label" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" ><INPUT type="text" name="batchID" id="batchID" value="<%=batchId%>"  maxlength="10"size="12" <%=disable%> ></td>
								<td class="label" width="15%"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" colspan="2"><input type="text" name="expiryDate" id="expiryDate"  size="8"  value="<%=expiryDate%>" maxlength="10" onblur="chkexpiryDate();" <%=disable%> >&nbsp;<IMG  SRC="../../eCommon/images/CommonCalendar.gif"  id="expiryCal" onclick="return showCalendar('expiryDate');" <%=disable%> ></td>
							</tr>
							<tr>
								<td class="label"><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="field"><INPUT type="text" name="manufacturerName" id="manufacturerName" value="<%=manufacturer%>"  maxlength="20"size="22" <%=disable%> ></td>
								<td class="label" width="15%"><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td class="field" colspan="2"><INPUT type="text" name="supplierName" id="supplierName" value="<%=supplier%>"  maxlength="30" size="32" <%=disable%> ></td>
							</tr>
<%
						}
%>
						<tr>
							<td colspan="6">&nbsp;&nbsp;</td>
						</tr>
					</table>
					<table cellpadding=0 cellspacing=0 border='0' width="102%" align="center"  border="0" id="AdverseReaction_table" style="display:none">
						<tr><th colspan="6"><fmt:message key="ePH.AdverseReactionDescription.label" bundle="${ph_labels}"/></th></tr>
						<tr>
							<td  colspan="4">&nbsp;</td>
							<td  ></td>
						</tr>
						<tr>
							<td class='label'  nowrap><fmt:message key="eMR.Hypersensitivity.label" bundle="${mr_labels}"/></td>
							<td class='fields'  nowrap><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/><input type=radio name="adv_event_ind" id="adv_event_ind"  value='01' onclick='change_val_allergy(this)' <%=hy01%> <%=disable%>>&nbsp;&nbsp;<fmt:message key="eMR.TypeII.label" bundle="${mr_labels}"/><input type=radio name="adv_event_ind" id="adv_event_ind" Value='02' onclick='change_val_allergy(this)' <%=hy02%> <%=disable%>> &nbsp;&nbsp;<fmt:message key="eMR.TypeIII.label" bundle="${mr_labels}"/><input type=radio name="adv_event_ind" id="adv_event_ind" Value='03' onclick='change_val_allergy(this)'<%=hy03%> <%=disable%> /> &nbsp;&nbsp;<fmt:message key="eMR.TypeIV.label" bundle="${mr_labels}"/><input type=radio name="adv_event_ind" id="adv_event_ind" Value='04' onclick='change_val_allergy(this)' <%=hy04%> <%=disable%>></td>
							<td  ></td>
							<td  ></td>
							<td  ></td>
							<tr>
							<td class="label"><fmt:message key="ePH.OnsetDateandTime.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
							<td>
							<input type=text name="OnsetDate" id="OnsetDate" value='<%=onsetDateTime%>' size="13" maxlength="16" onblur="validateDate()" <%=disable%> ></input>
							<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('OnsetDate',null,'hh:mm');" <%=disable%> ></input><img src="../../eCommon/images/mandatory.gif" align="center"></img>
							</td>
							<td></td><td  ></td><td  ></td>
						</tr> 
						<tr>
							<td class="label"><fmt:message key="ePH.TimetoOnsetofReaction.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
							<td><input type="text" name="timeOnset" id="timeOnset" value='<%=timeToOnsetReaction%>' class="number" maxlength="2" size="1" onblur="CheckNum(this);setOnsetDate();" <%=disable%> >
							<select name="OnsetTime" id="OnsetTime" onchange="setOnsetDate();" <%=disable%> >
							<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<option value='M' <%=Minutes%> ><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>
							<option value='H' <%=Hours%> ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
							<option value='D' <%=Days%> ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
							</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
							</td>
							<td></td><td  ></td><td></td>
						</TR>
						<TR>
							<TD class="label"><fmt:message key="ePH.ADR.label" bundle="${ph_labels}"/> &nbsp;&nbsp;</TD>
							<TD>
								<select name="adrType" id="adrType" <%=disable%> >
									<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
									for(int i=0;i<adrList.size();i++){
										adrDetails=(HashMap)adrList.get(i);
										if(adrDetails.get("code").equals(adrType)){
%>
											<option value="<%=(String)adrDetails.get("code")%>" selected><%=(String)adrDetails.get("desc")%></option>
<%
										}
										else{	
%>
											<option value="<%=(String)adrDetails.get("code")%>"><%=(String)adrDetails.get("desc")%></option>
<%
										}
									}
%>
								</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
							</TD>
							<td></td><td  ></td><td></td>
						</tr>
						<tr>
							<td class="label"><fmt:message key="Common.Severity.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td class='field'>
							<select name="ExtentReaction" id="ExtentReaction" <%=disable%> >
							<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
							<option value='M' <%=Mild%> ><fmt:message key="Common.Mild.label" bundle="${common_labels}"/></option>
							<option value='O' <%=Moderate%> ><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
							<option value='S' <%=Severe%> ><fmt:message key="Common.Severe.label" bundle="${common_labels}"/></option>
							</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
							</td>
							<td></td><td></td><td></td>
						</tr>
						<tr>
							<td  class="label" ><fmt:message key="eMR.Certanity.label" bundle="${mr_labels}"/></td>
								<td  class="oaBorder"><input type=radio name='definit' id='definit'  value='D' onclick='change_val(this)' <%=cerD%> <%=disable%> /><fmt:message key="Common.Definitive.label" bundle="${common_labels}"/>
								<input type=radio name='definit' id='definit' Value='P' onclick='change_val(this)'<%=cerP%> <%=disable%> /><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></td>
								<td></td><td></td><td></td>
						</tr>
						 <tr>
							<td class='label' ><fmt:message key="eMR.SourceOfInfo.label" bundle="${mr_labels}"/></td>
							<td  class="fields" colspan='3'>
							<input type=radio name='pat_obser' id='pat_obser'  value='P' onclick='change_val_two(this)'<%=souP%> <%=disable%> ><fmt:message key="Common.patient.label" bundle="${common_labels}"/>
							<input type=radio name='pat_obser' id='pat_obser' value='A' onclick='change_val_two(this)' <%=souA%> <%=disable%>><fmt:message key="ePH.Investigation.label" bundle="${ph_labels}"/>
							<input type=radio name='pat_obser' id='pat_obser' value='S' onclick='change_val_two(this)' <%=souS%> <%=disable%>><fmt:message key="Common.Staff.label" bundle="${common_labels}"/></td>
							<td></td>	
						</tr>
						<tr>
							<td  class="label"><fmt:message key="ePH.DrugReactionRelationship.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
							<td>
							<select name="DrugRelation" id="DrugRelation" <%=disable%> >
<%
					for(int i=0;i<certainityCodes.size();i++){
						certValues=(HashMap)certainityCodes.get(i);
						if(certValues.get("code").equals(drugRctnRltn)){
%>
							<option value="<%=(String)certValues.get("code")%>" selected><%=(String)certValues.get("description")%></option>
<%
						}
						else{	
%>
							<option value="<%=(String)certValues.get("code")%>"><%=(String)certValues.get("description")%></option>
<%
						}
					}
%>
					</select><img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
					<td width="25%" ><a href="javascript:getQuestionnaireSearch();"><fmt:message key="ePH.Questionnaire.label" bundle="${ph_labels}"/>&nbsp;&nbsp; </a></td>
					<td></td><td></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="ePH.SystemIdentifiedRelationship.label" bundle="${ph_labels}"/></td>
					<td width="25%" id="sysidrl" name="Sys_iden_rlsp" ><%=sys_id_rlsp_desc%></td>
					<input type="hidden" name="sysiddrugrlsp" id="sysiddrugrlsp" value="<%=sys_id_rlsp_code%>">
					<td></td><td></td><td></td>
				</tr>
				<tr>
					<!-- <tr>
					<td class="label"><fmt:message key="Common.AllergyType.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td><input type="field" width="25%" size=30 maxlength=30 name="allergytype" id="allergytype"  value="<%=allergy_type_desc%>" <%=disable%>><input type=button class=button name=allergy_button id=allergy_button value='?' onclick="searchallergytype()" <%=disable%>></td>
					<input type="hidden" name="allergytypecode" id="allergytypecode" value="<%=allergy_type_code%>">
					<td></td><td></td><td></td>
					</tr>
					<tr> -->
					<td   class="label"><fmt:message key="ePH.ReactionStoppedafterstopping/reducingmedication.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td >
					<select name="reactionStopped" id="reactionStopped" <%=disable%> >
						<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
						<option value="Y" <%=stY%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value="N" <%=stN%> ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td></td><td></td><td></td>
				</tr>
				<tr>
					<td  class="label" width="40%"><fmt:message key="ePH.Reactionreappearedafterre-introducingmedication.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td>
					<select name="reactionReappeared" id="reactionReappeared" <%=disable%> >
						<option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
						<option value="Y" <%=reY%> ><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
						<option value="N" <%=reN%> ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
					<td></td><td></td><td></td>
				</tr>
				<tr>
					<td  class="label" width="40%"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='field'>
					<select name="outcome" id="outcome" <%=disable%>>
						<option value="R" ><fmt:message key="ePH.Recovered.label" bundle="${ph_labels}"/></option>
						<option value="N" <%=notrecovered%> ><fmt:message key="ePH.NotYetRecovered.label" bundle="${ph_labels}"/></option>
						<option value="F" <%=fatal%> ><fmt:message key="ePH.Fatal.label" bundle="${ph_labels}"/></option>
						<option value="U" <%=unknown%> ><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
					<img align='center' src ='../../eCommon/images/mandatory.gif'></img>
					<td></td><td></td><td></td>
				</tr>
				<tr>
					<td class='label'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class='fields'  >
					<input type=radio name='active' id='active'  value='A' onclick='change_val_status(this)' <%=staA%> <%=disable%> /><fmt:message key="Common.active.label" bundle="${common_labels}"/>
					 <input type=radio name='active' id='active'   value='R' onclick='change_val_status(this)' <%=staR%> <%=disable%> /><fmt:message key="Common.Resolved.label" bundle="${common_labels}"/>
					<!-- <input type=radio name='active' id='active'  value='E' onclick='change_val_status(this)' <%=staE%> <%=disable%>><fmt:message key="Common.InError.label" bundle="${common_labels}"/></input>  -->
					</td>

					<td></td><td  ></td><td></td>
				</tr>
			</table>
			<table cellpadding=0 cellspacing=0 width="120%" align="center"  border="1" id="OtherMedications_table" style="display:none">
<%
			if(patient_id!=null && patient_id.length()!=0){
%>
				<tr>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th> 
					<th><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Route.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="ePH.AdminQuantity.label" bundle="${ph_labels}"/></th>
					<th><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				</tr>
<%
				other_medications=bean.DrugsOtherMedication(patient_id);
				drugCodes	= 	bean.getAdrDrugs(adr_no);
				int rowcount=2;
				ArrayList tmpDrgCode = null;
				try{
					int n=other_medications.size();
					String Qryclass="";
					int count=0;
					for(int i=0;i<n;i=i+14){ //changed i+13 to i+14 for CRF RUT-CRF-0034.1[IN:037389]-start
						if(rowcount%2==0){
							Qryclass="QRYEVENSMALL";
						}
						else{
							Qryclass="QRYODDSMALL";
						}

						drug=(String)other_medications.get(i);
						route=(String)other_medications.get(i+1);
						route_color=(String)other_medications.get(i+13);	// added for CRF RUT-CRF-0034.1[IN:037389]-start
						fntColor= "";
						backgrndColor= "";
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}	// added for CRF RUT-CRF-0034.1[IN:037389]-End
						dosagedetails=(String)other_medications.get(i+2);
						startdate=(String)other_medications.get(i+3);
						enddate=(String)other_medications.get(i+4);

						dispqty=(String)other_medications.get(i+5);
						adminqty=(String)other_medications.get(i+6);

						if(dispqty!=null && !dispqty.equals("") )
							dispqty = dfToInteger.format(Double.parseDouble(dispqty));

						if(adminqty!=null && !adminqty.equals("") )
							adminqty = dfToInteger.format(Double.parseDouble(adminqty));

						practitioner=(String)other_medications.get(i+7);
						location=(String)other_medications.get(i+8);
						orderid=(String)other_medications.get(i+9);
						ordlnenum=(String)other_medications.get(i+10);
						drugCode=(String)other_medications.get(i+11);
						genericId=(String)other_medications.get(i+12);
						if(drug_code.equals(drugCode) && order_id.equals(orderid) && ordlnenum.equals(ordlnenum)) {
							continue;
						}
						rowcount++;
						count++;

						if(drugCodes.size()>0){
							checked = ""; chkBoxValue="N";
							for(int dc=0;dc<drugCodes.size();dc++){
								tmpDrgCode = (ArrayList)drugCodes.get(dc);
								if(tmpDrgCode!=null && tmpDrgCode.size()>0 && tmpDrgCode.get(0).equals(drugCode)){
									if(tmpDrgCode.get(1).equals(orderid)){
										if(tmpDrgCode.get(2).equals(ordlnenum)){
											checked = "CHECKED"; chkBoxValue="Y";
											break;
										}else{
											checked = "";
										}
									}	
								}
							}
						}
						//newly added code for placing the bean object back.
						putObjectInBean(bean_id,bean,request);
%>
						<tr>
							<td class="<%=Qryclass%>"><input type="checkbox" name="ord_<%=count%>" id="ord_<%=count%>" value="<%=chkBoxValue%>" onClick="assignValue(this)" <%=checked%> <%=disable%> >
								<input type="hidden" name="oth_drugCode_<%=count%>" id="oth_drugCode_<%=count%>" value="<%=drugCode%>" >
								<input type="hidden" name="oth_genericId_<%=count%>" id="oth_genericId_<%=count%>" value="<%=genericId%>" >
								<input type="hidden" name="oth_orderId_<%=count%>" id="oth_orderId_<%=count%>" value="<%=orderid%>" >
								<input type="hidden" name="oth_ordlneNum_<%=count%>" id="oth_ordlneNum_<%=count%>" value="<%=ordlnenum%>" >
							</td>
							<td class="<%=Qryclass%>"><%=drug%></td>
							<td class="<%=Qryclass%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=route%></td>
							<td class="<%=Qryclass%>"><%=dosagedetails%></td>
							 
							<!--<td class="<%=Qryclass%>"><%=startdate%></td> -->
							<td class="<%=Qryclass%>"><%=com.ehis.util.DateUtils.convertDate(startdate,"DMYHM","en",locale)%></td> 
							<!--<td class="<%=Qryclass%>"><%=enddate%></td>-->
							<td class="<%=Qryclass%>"><%=com.ehis.util.DateUtils.convertDate(enddate,"DMYHM","en",locale)%></td>
<% 
							if(dispqty==null || dispqty=="") {
%>
								<td class="<%=Qryclass%>">&nbsp;</td>
<% 
							}
							else { 
%>
								<td class="<%=Qryclass%>"><%=dispqty%></td>
<%
							}
							if(adminqty==null || adminqty=="") {
%>
								<td class="<%=Qryclass%>">&nbsp;</td>
<% 
							}
							else { 
%>
								<td class="<%=Qryclass%>"><%=adminqty%></td>
<% 
							}
%>
							<td class="<%=Qryclass%>"><%=practitioner%></td>
							<td class="<%=Qryclass%>"><%=location%></td>
						</tr>
<%
					}
					rowcount = rowcount - 2;
				}
				catch(Exception exp){
					exp.printStackTrace();
				}
%>
				<input type="hidden" name="no_of_drugs" id="no_of_drugs" value="<%=rowcount%>" >
<%
			}
%>
			</table>
			<table cellpadding=0 cellspacing=0 width="102%" align="center"  border="0" id="Remarks_table" style="display:none">
				<tr><th colspan="6"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th></tr>
				<tr>
					<td class="label"><fmt:message key="ePH.AdditionalMedication.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td ><textarea name="AdditionalMedication" cols="90" rows="3"  onKeyPress="return checkMaxLimit(this,255);" onBlur="callCheckMaxLen(this,255,'Additional Medication')" <%=disable%> style='resize:none' ><%=adtnlMedcn%></textarea></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="ePH.AdverseReactionDescription.label" bundle="${ph_labels}"/>
					&nbsp;&nbsp;</td>
					<td ><textarea name="adr_descp" cols="90" rows="3" onKeyPress="return checkMaxLimit(this,255);" onBlur="callCheckMaxLen(this,255,'adr_descp');" <%=disable%> style='resize:none' ><%=adr_description%></textarea></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="ePH.Treatmentofadversereaction.label" bundle="${ph_labels}"/>
					&nbsp;&nbsp;</td>
					<td ><textarea name="adr_treatment" cols="90" rows="3" onKeyPress="return checkMaxLimit(this,255);" onBlur="callCheckMaxLen(this,255,'adr_treatment');" <%=disable%> style='resize:none' ><%=adr_treatment%></textarea></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="ePH.RelevantInvestigations.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td ><textarea name="Investigations" cols="90" rows="3" 
					onKeyPress="return checkMaxLimit(this,255);"
					onBlur="callCheckMaxLen(this,255,'Relevant Investigations');" <%=disable%> style='resize:none' ><%=rlvntInvstgtn%></textarea></td>
				</tr> 
				<tr>
					<td class="label" ><fmt:message key="ePH.RelevantHistory.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
					<td ><textarea name="History" cols="90" rows="3" onKeyPress="return checkMaxLimit(this,255);" onBlur="callCheckMaxLen(this,255,'Relevant History');" <%=disable%> style='resize:none' ><%=rlvntHistory%></textarea></td>
				</tr>
			</table>
			<table cellpadding=0 cellspacing=0 width="102%" align="center"  border="0" id="Report_table" style="display:none">
				<tr>
					<td class="label" width="18%"><fmt:message key="Common.ReportedBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td ><input type=text name="ReportedBy" id="ReportedBy" value="<%=login_user%>" size=15 <%=disable%> readonly></input><img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
					<td class="label" width="18%">&nbsp;&nbsp;</td>
					<td ><input type=hidden name="VerifiedBy" id="VerifiedBy" value="<%=vrfdBy%>" onBlur="checkUser(this.value)" size=15 <%=disable%> ><input valign="top" type=hidden name="user_search" id="user_search" class="button" value="?" onClick="searchUserNames(VerifiedBy)" <%=disable%> ></input><INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>"><img src="../../eCommon/images/mandatory.gif" align="center" style="visibility:hidden"></img></td>
					<td class="label" width="15%"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td><input type=text name="DateTime" id="DateTime" value="<%=com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",locale)%>" size=14 align="left" readonly <%=disable%> >
					</td> 
				</tr>
			</table>
			<input type=hidden name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type=hidden name="order_id" id="order_id" value="<%=order_id%>">
			<input type=hidden name="order_line" id="order_line" value="<%=order_line%>">
			<INPUT type="hidden" name="weight" id="weight" value="">
			<input type=hidden name="adr_no" id="adr_no" value="<%=adr_no%>">
			<input type=hidden name="ethnic_grp" id="ethnic_grp" value=""> <!-- value is removed for  for ML-BRU-SCF-0094[31887] -->

			<input type=hidden name="drug_code" id="drug_code" value="<%=drug_code%>">
			<input type=hidden name="trade_code" id="trade_code" value="<%=trd_code%>">
			<input type=hidden name="generic_code" id="generic_code" value="<%=generic_id%>">
			<input type=hidden name="locale" id="locale" value="<%=locale%>">

			<input type=hidden name="drug_name1" id="drug_name1" value="<%=drug_name1%>">
			<input type=hidden name="patient_name" id="patient_name" value="<%=patient_name%>">
			<input type=hidden name="hypersensitivity" id="hypersensitivity" value="<%=hypersensitivity%>">
			<input type=hidden name="sourceOfInfo" id="sourceOfInfo" value="<%=sourceOfInfo%>">
			<input type=hidden name="certanity" id="certanity" value="<%=certanity%>">
			<input type=hidden name="status_act" id="status_act" value="<%=status_act%>">
			<input type="hidden" name="SQL_PH_ALLERGY_SEARCH" id="SQL_PH_ALLERGY_SEARCH" value="<%=PhRepository.getPhKeyValue("SQL_PH_ALLERGY_SEARCH_CODE")%>">
<%
			if(flag==1){ 
%>
				<input type="hidden" name="dosage" id="dosage" value="">
				<input type="hidden" name="administeredBy" id="administeredBy" value="">
				<input type="hidden" name="batchID" id="batchID" value="">
				<input type="hidden" name="expiryDate" id="expiryDate" value="">
				<input type="hidden" name="manufacturerName" id="manufacturerName" value="">
				<input type="hidden" name="supplierName" id="supplierName" value=""> 
<%
			}
%>
			<input type="hidden" name="flag" id="flag" value="<%=flag%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>"> 
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="mode1" id="mode1" value="<%=mode1%>">
			<input type="hidden" name="curDate" id="curDate" value="">
			<input type="hidden" name="startDate" id="startDate" value="<%=start_date%>">
			<input type="hidden" name="endDate" id="endDate" value="<%=endDate%>">
			<input type="hidden" name="sgndBy" id="sgndBy" value="<%=sgndBy%>">
			<input type="hidden" name="addedFacility_id" id="addedFacility_id" value="<%=facility_id%>"><!-- Code added for added for 33963 -->
			<input type="hidden" name="end" id="end" value="<%=endDate1%>">			
			<input type="hidden" name="adrStatus" id="adrStatus" value=""><!-- code added for HSA-CRF-0005[40601] -- Start --> 
			<input type="hidden" name="canErrorID" id="canErrorID" value="">
			<input type="hidden" name="canErrorDate" id="canErrorDate" value="">
			<input type="hidden" name="canRemarks" id="canRemarks" value="">
			<input type="hidden" name="canReason" id="canReason" value="">
			<input type="hidden" name="SignedBy" id="SignedBy" value=""><!-- code added for HSA-CRF-0005[40601] -- End -->  
			 
<%
			if(administeredDate.size()>0){
%>
				<script>
					if(AdrReportingTab_form.adminsterDate.value!=""){
						loadDetails(AdrReportingTab_form.adminsterDate,'<%=patient_id%>','<%=order_id%>','<%=order_line%>');
					}
				</script>
<%
			}
		}
		catch(Exception e){
			e.printStackTrace();
		} 
%>
		</form>
	</body>
</html>


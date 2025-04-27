<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
08/11/2019  IN070606                Manickavasagam J                       MMS-KH-CRF-0029[IN070606]
15/07/2020  IN073414                Manickavasagam J                       MMS-KH-SCF-0079
30/08/2020  IN073795                Manickavasagam J                       MMS-KH-CRF-0034.2[IN073795]
02/09/2020  IN073795                Manickavasagam J                       MMS-KH-CRF-0034.4[73844]
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.* " %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%> 
 
<html>
	<head>
		<title><fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link> <!-- added for MMS-KH-CRF-0029[IN070606] -->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/Prescription_1.js"></SCRIPT> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body >
		<form name="FormDrugInteractionsDetail" id="FormDrugInteractionsDetail">
<%
			try{
				java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
				String patient_id				=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
				String drug_code		        = request.getParameter( "drug_code" )==null?"":request.getParameter("drug_code");
				String srl_no		        = request.getParameter( "srl_no" )==null?"":request.getParameter("srl_no");
				String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
				String bean_name		= "ePH.PrescriptionBean_1";
				String calledFor		        = request.getParameter( "calledFor" )==null?"":request.getParameter("calledFor");
				String intr_restric_trn		        = request.getParameter( "intr_restric_trn" )==null?"":request.getParameter("intr_restric_trn");
				String CalledFrom		        = request.getParameter( "CalledFrom" )==null?"":request.getParameter("CalledFrom");
				String fontStyle="font-size:12;";
				String order_id		        = request.getParameter( "order_id" )==null?"":request.getParameter("order_id");
				String order_line_no		        = request.getParameter( "order_line_no" )==null?"":request.getParameter("order_line_no");
				//String fontStyle="font-size:12;";
				if(order_id==null || order_id.equals("undefined"))
					order_id="";
				ArrayList prescriptionDetails = null;
				PrescriptionBean_1 bean_1 = null; //MMS-KH-CRF-0034.4
				
				

				if(CalledFrom.equals("DD")){
					bean_id					= "DirectDispensingBean";
					bean_name		= "ePH.DirectDispensingBean";
					DirectDispensingBean bean	= (DirectDispensingBean)getBeanObject(bean_id,bean_name,request) ;
					bean.setLanguageId(locale);
					prescriptionDetails	=	bean.getpresDetails();
				}
				else{
					PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
					bean.setLanguageId(locale);
					prescriptionDetails	=	bean.getpresDetails();
				}
				// MMS-KH-CRF-0034.4
				if(CalledFrom.equals("") && !order_id.equals("")){
					bean_1 = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
				}

				if(prescriptionDetails!=null && prescriptionDetails.size()>0){
					int     recordcount    =   0;
					String intr_option,intr_name, severity_level, significant_level, probability, interaction_desc, restrict_transaction, ext_drug_code, ext_srl_no, drug_desc="", form_desc="",interaction_type="";//MMS-KH-CRF-0029[IN070606]
					StringBuffer intr_names = new StringBuffer();
					StringBuffer intr_msg_content = new StringBuffer();
				//added for MMS-KH-CRF-0029[IN070606] - start
					StringBuffer intr_msg_content_drug_drug = new StringBuffer();
					StringBuffer intr_msg_content_drug_food = new StringBuffer();
					StringBuffer intr_msg_content_drug_lab = new StringBuffer();
					StringBuffer intr_msg_content_drug_disease = new StringBuffer();//Added for MMS-DM-CRF-0229
				//added for MMS-KH-CRF-0029[IN070606] - end
					StringBuffer test_result_content = null; //MMS-KH-CRF-0034.2
					String return_flag_yn = ""; // MMS-KH-CRF-0034.4
					String test_result_value = ""; // MMS-KH-CRF-0034.4

					boolean msgRestrictTrans = false;
					ArrayList intrType = new ArrayList();//MMS-KH-CRF-0029[IN070606]
					
					ArrayList hmDrugIntList=null;
					HashMap ext_drugData=null;
					HashMap DrugInteractionDtl=null;
					for(int j=0;j<prescriptionDetails.size();j++){
						ext_drugData=(HashMap) prescriptionDetails.get(j);

						ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
						ext_srl_no=(String) ext_drugData.get("SRL_NO");

						if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
							drug_desc=(String) ext_drugData.get("DRUG_DESC");
							form_desc=(String) ext_drugData.get("FORM_DESC");
							hmDrugIntList=(ArrayList) ext_drugData.get("INTERACTION_DTL");
							break;
						}
					}
					if(calledFor.equals("Alert")){
						//added for MMS-KH-CRF-0029[IN070606] - start
						ArrayList drugDrugInteractionList = new ArrayList();
						ArrayList drugFoodInteractionList = new ArrayList();
						ArrayList drugLabInteractionList = new ArrayList();
						ArrayList drugDiseaseInteractionList = new ArrayList();
						
						//added for MMS-KH-CRF-0029[IN070606] - end						
						if(hmDrugIntList!=null && hmDrugIntList.size()> 0){
							for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
								intr_msg_content = new StringBuffer(); //MMS-KH-CRF-0029[IN070606]
								DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
								intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
								intr_name = (String)DrugInteractionDtl.get("intr_name");
								severity_level = (String)DrugInteractionDtl.get("severity_level");
								significant_level = (String)DrugInteractionDtl.get("significant_level");
								probability = (String)DrugInteractionDtl.get("probability");
								restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
								interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
								interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2"); //MMS-KH-CRF-0029[IN070606]
								// MMS-KH-CRF-0034.2 - start
								return_flag_yn = (String)DrugInteractionDtl.get("return_flag_yn");
								test_result_value = (String)DrugInteractionDtl.get("test_result_value");
								if(test_result_value==null)
									test_result_value = "";
								if(return_flag_yn==null)
									return_flag_yn = "";

								// MMS-KH-CRF-0034.2 - end

								intrType.add(interaction_type);//MMS-KH-CRF-0029[IN070606]
								//if(severity_level.equals("H") || restrict_transaction.equals("Y")){
									if(intr_names.length()>0)
										intr_names.append("");
									intr_names.append(intr_name);
									//MMS-KH-CRF-0029[IN070606] - start
									if(intr_msg_content.length()>0)
										intr_msg_content.append(","); 

									/*if(drugDrugInteractionList.size()>0)
										intr_msg_content.append("<hr>" + drug_desc +" Interact with  " );
									if(drugFoodInteractionList.size()>0)
										intr_msg_content.append("<hr>" + drug_desc +" Interact with   ");
									if(drugLabInteractionList.size()>0)
										intr_msg_content.append("<hr>"+ drug_desc +" Interact with ") ; */
									//MMS-KH-CRF-0029[IN070606] - end

									intr_msg_content.append(intr_name+" <br> "+interaction_desc+" <br> ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SeverityLevel.label", "ph_labels")+" - ");  // Modified '[' as '(' for FD-RUT-CRF-0066.1 [IN036975] added encode for interaction_desc for MMS-KH-CRF-0029 and removed for MMS-KH-SCF-0079
									if(severity_level.equals("L"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Minor.label", "ph_labels"));
									if(severity_level.equals("M"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Moderate.label", "common_labels"));
									if(severity_level.equals("H"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Major.label", "ph_labels"));
									//intr_msg_content.append(" and "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SiginificantLevel.label", "ph_labels")+" "+significant_level);  // Commented and Added below for FD-RUT-CRF-0066.1 [IN036975]
									intr_msg_content.append(") , ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SignificantLevel.label", "ph_labels")+" - "+significant_level);
									intr_msg_content.append(") "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.and.label", "common_labels"));
									//intr_msg_content.append(" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.documentation.label", "ph_labels")+" - ");
									intr_msg_content.append(" ( Documentation - ");
									if(probability.equals("E")) // added for FD-RUT-CRF-0066.1 [IN036975] --begin
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.established.label", "ph_labels"));
									else if(probability.equals("P"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Probable.label", "common_labels"));
									else if(probability.equals("S"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.suspected.label", "ph_labels"));
									else if(probability.equals("O"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Possible.label", "ph_labels"));
									else if(probability.equals("U"))
										intr_msg_content.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Unlikely.label", "ph_labels"));
									intr_msg_content.append(")"); // added for FD-RUT-CRF-0066.1 [IN036975] --end
									if(restrict_transaction.equals("Y")){
									//	intr_msg_content.append(", "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.RestrictTransaction.label", "ph_labels")); // Commented for FD-RUT-CRF-0066.1 [IN036975]
										msgRestrictTrans = true;
									}
									if(severity_level.equals("H"))
										fontStyle ="color:red;font-size:12;";
									else										// added for FD-RUT-CRF-0066.1 [IN036975] 
										fontStyle ="color:blue;font-size:12;";  
									//intr_msg_content.append("]"); // Commented for FD-RUT-CRF-0066.1 [IN036975]
								//}
								//MMS-KH-CRF-0029[IN070606] - start
								if(interaction_type.equals("D") || interaction_type.equals("G")){	
									//intr_msg_content_drug_drug.append(drug_desc + " Interact with " +intr_msg_content);
									drugDrugInteractionList.add(drug_desc + " Interact with " +intr_msg_content.toString());
								}
								if(interaction_type.equals("F")){	
									//intr_msg_content_drug_food.append(drug_desc + " Interact with  " +intr_msg_content);
									drugFoodInteractionList.add(drug_desc + " Interact with  " +intr_msg_content.toString());
								}
								if(interaction_type.equals("L")){	
									test_result_content = new StringBuffer();

									if(return_flag_yn.equals("YY") || return_flag_yn.equals("YN")){

								//added for MMS-KH-CRF-0034.2 - start 
									  if(!test_result_value.equals("") ){ 
										String lab_test_result_grp = "";
										StringTokenizer strToken = null;
										String token_value = "";
										String prev_token = "";
										String test_result[] = test_result_value.split("##");
							test_result_content.append("----------------------------------------------------------");
							test_result_content.append("-------------------------------------------");
							//test_result_content.append("<br><br>");
										if(test_result.length>1){
										 for(int j=0;j<test_result.length;j++){
										    lab_test_result_grp= test_result[j];
											strToken = new StringTokenizer(lab_test_result_grp,"$$");
											token_value = "";
											prev_token  = "";
											while(strToken.hasMoreTokens())
											{
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											//	test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");
											}
											test_result_content.append("<br><br>");
										 }
										}else{

											lab_test_result_grp= test_result[0];
										
										strToken = new StringTokenizer(lab_test_result_grp,"$$");
										token_value = "";
										prev_token  = "";
										while(strToken.hasMoreTokens())
										{
											/*token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:11'>");
											}
											if(!token_value.equals("Low"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");
											*/
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
										}
											test_result_content.append("<br><br>");
										}
							test_result_content.append("----------------------------------------------------------");
							test_result_content.append("-------------------------------------------");
							//test_result_content.append("<br><br>");

									  }
									}
									//added for MMS-KH-CRF-0034.2 - start
									//intr_msg_content_drug_lab.append(drug_desc + " Interact with " +intr_msg_content);
							drugLabInteractionList.add(drug_desc + " Interact with " +intr_msg_content.toString()+"<table><tr><td style='BACKGROUND-COLOR:#FFFFCC' ><label  style='color:black;font-size:11'><br><br>"+test_result_content.toString()+"</label></td></tr></table>");
								}
								if(interaction_type.equals("I")){	//Added for MMS-DM-CRF-0229
									drugDiseaseInteractionList.add(drug_desc + " Interact with  " +intr_msg_content.toString());
								}
								//MMS-KH-CRF-0029[IN070606] - start								
							}
						}
						//MMS-KH-CRF-0029[IN070606] - start
						String drug_drug_display = "none";
						String drug_food_display = "none";
						String drug_lab_display = "none";
						String drug_disease_display = "none";//Added for MMS-DM-CRF-0229
						if(intrType!=null && intrType.size()>0){
						if(intrType.contains("D") || intrType.contains("G")){
							drug_drug_display = "inline";
						}
						if(intrType.contains("F")){
							drug_food_display = "inline";
						}
						if(intrType.contains("L")){
							drug_lab_display = "inline"; 
						}
						if(intrType.contains("I")){
							drug_disease_display = "inline"; 
						}

						}

					//MMS-KH-CRF-0029[IN070606] - start	
						if(drugDrugInteractionList!=null && drugDrugInteractionList.size()>0){
							 intr_msg_content_drug_drug = new 	StringBuffer();
							for(int i=0;i<drugDrugInteractionList.size();i++){
								if(i>0)
									intr_msg_content_drug_drug.append("<hr size=1>");
								intr_msg_content_drug_drug.append(drugDrugInteractionList.get(i));
								
							}
							intr_msg_content_drug_drug = new 	StringBuffer(intr_msg_content_drug_drug.toString()); //Removed the encode for MMS-KH-CRF-0029[IN71814]
						}
						if(drugFoodInteractionList!=null && drugFoodInteractionList.size()>0){
						
							intr_msg_content_drug_food = new 	StringBuffer();
							for(int i=0;i<drugFoodInteractionList.size();i++){
								if(i>0)
									intr_msg_content_drug_food.append("<hr size=1>");

								intr_msg_content_drug_food.append((String)drugFoodInteractionList.get(i));
														}
							intr_msg_content_drug_food = new 	StringBuffer(intr_msg_content_drug_food.toString());//Removed the encode for MMS-KH-CRF-0029
						}
						if(drugLabInteractionList!=null && drugLabInteractionList.size()>0){
						intr_msg_content_drug_lab = new 	StringBuffer();
							for(int i=0;i<drugLabInteractionList.size();i++){
							if(i>0)
								intr_msg_content_drug_lab.append("<hr size=1>");

								intr_msg_content_drug_lab.append((String)drugLabInteractionList.get(i));
								
							}
							intr_msg_content_drug_lab = new 	StringBuffer(intr_msg_content_drug_lab.toString());  //Removed the encode for MMS-KH-CRF-0029[IN71814]
						}
					//	System.err.println("drugDiseaseInteractionList@@==="+drugDiseaseInteractionList);
						if(drugDiseaseInteractionList!=null && drugDiseaseInteractionList.size()>0){//Adding start for MMS-DM-CRF-0229
						intr_msg_content_drug_disease = new 	StringBuffer();
							for(int i=0;i<drugDiseaseInteractionList.size();i++){
							    if(i>0)
								intr_msg_content_drug_disease.append("<hr size=1>");

								intr_msg_content_drug_disease.append((String)drugDiseaseInteractionList.get(i));
								
							}
							intr_msg_content_drug_disease = new 	StringBuffer(intr_msg_content_drug_disease.toString());  
						}//Adding end for MMS-DM-CRF-0229
%>
						<TABLE name="DrugInteractionAlert" id="DrugInteractionAlert" cellpadding=0 cellspacing=0 width="110%" align="center" border="0">   
							
							<tr> <!-- MMS-KH-CRF-0029[IN070606] start-->
								<td width= "180%" class="white">
								 <ul id="tablist" class="tablist" >   

								 <li class="tablistitem" title='Drug-Drug' style="display:<%=drug_drug_display%>">
								 <a onclick="tab_click1('Drug_tab')" class="tabClicked" id="Drug_tab" >
									<span class="tabSpanclicked" id="Drug_tabspan">
									<fmt:message key="ePH.Drug-Drug.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
								<li class="tablistitem" title='Drug-Lab' style="display:<%=drug_lab_display%>">
								 <a onclick="tab_click3('DrugLab_tab')" class="tabA" id="DrugLab_tab" >
									<span class="tabAspan" id="DrugLab_tabspan">
									<fmt:message key="ePH.Drug-Lab.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
								 <li class="tablistitem" title='Drug Food' style="display:<%=drug_food_display%>">
								 <a onclick="tab_click2('DrugFood_tab')" class="tabA" id="DrugFood_tab" >
									<span class="tabAspan" id="DrugFood_tabspan">
									<fmt:message key="ePH.Drug-Food.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
								<li class="tablistitem" title='Drug Disease' style="display:<%=drug_disease_display%>">
								 <a onclick="tab_click4('DrugDisease_tab')" class="tabA" id="DrugDisease_tab" >
									<span class="tabAspan" id="DrugDisease_tabspan">
									Drug to Disease</span>
									</a>
								</li>
								
								</ul>
								</td>
								</tr>
								</table>
							<TABLE  cellspacing="0" cellpadding="0" border="0" width = "100%" align="center" id="drug_interations" style="display"> 
							<tr >
								<!--<td class="label" width='2px' style='vertical-align:top;'><img value="" src="../../ePH/images/redAlert.png" height='40 ' width='40'></img>  -->
								
								<td  class="label" align='left' style="<%=fontStyle%>"><label id='drugIntrAlertMsg1'></label><br><label id='drugIntrAlertMsg2'><%=intr_msg_content_drug_drug.toString()%></label><br><label id='drugIntrAlertMsg3'></label></td > <!-- modified for MMS-KH-CRF-0029[IN070606] and removed decode for MMS-KH-SCF-0079-->
								<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>"><!-- added for RUT-SCF-0318.1 [IN:046811] -->
								<script>
									var msg = getMessage("PH_INTERACTION_ALERT","PH");
									var	msg1 = getMessage("PH_INTERACTION_RESTRICT","PH");
									msg = msg.replace("$$$",document.FormDrugInteractionsDetail.drug_desc.value);//added for RUT-SCF-0318.1 [IN:046811]
									//msg = msg.replace("###",'<%=intr_names.toString()%>'); // Commented for FD-RUT-CRF-0066.1 [IN036975]
									//document.getElementById("drugIntrAlertMsg1").innerText=msg; //commented for MMS-KH-CRF-0029[IN070606]
									//document.getElementById("drugIntrAlertMsg2").innerText='<%=intr_msg_content.toString()%>.';
<%
									if(msgRestrictTrans){
%>
										document.getElementById("drugIntrAlertMsg3").innerText=msg1;
<%
									}
%>
								</script>
							</tr>
						</TABLE>
					
						<TABLE cellspacing="0" cellpadding="0" border="0" width = "100%" align="center" name="lab_interations" id="lab_interations" style="display"> 
							<tr >
							<!--	<td class="label" width='2px' style='vertical-align:top;'><img value="" src="../../ePH/images/redAlert.png" height='40 ' width='40'></img>-->
								<td  class="label" align='left' style="<%=fontStyle%>"><label id='labIntrAlertMsg1'></label><br><label id='labIntrAlertMsg2'><%=intr_msg_content_drug_lab.toString()%>.</label><br><label id='labIntrAlertMsg3'></label></td ><!-- modified for MMS-KH-CRF-0029[IN070606]  and removed decode for MMS-KH-SCF-0079-->
								<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>"><!-- added for RUT-SCF-0318.1 [IN:046811] -->
								<script>
									var msg = getMessage("PH_INTERACTION_ALERT","PH");
									var	msg1 = getMessage("PH_INTERACTION_RESTRICT","PH");
									msg = msg.replace("$$$",document.FormDrugInteractionsDetail.drug_desc.value);
								//	document.getElementById("drugIntrAlertMsg1").innerText=msg; commented for MMS-KH-CRF-0029[IN070606]
									
<%
									if(msgRestrictTrans){
%>										
										document.getElementById("labIntrAlertMsg3").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]
<%
									}
%>
								</script>
							</tr> 
						</TABLE>
							<TABLE  cellspacing="0" cellpadding="0" border="0" width = "100%" align="center" id="food_interations" style="display">  <!-- MMS-KH-CRF-0029[IN070606] start-->
							<tr > 
								<!--<td class="label" width='2px' style='vertical-align:top;'><img value="" src="../../ePH/images/redAlert.png" height='40 ' width='40'></img> -->
								<td  class="label" align='left' style="<%=fontStyle%>"><label id='foodIntrAlertMsg1'></label><br><label id='foodIntrAlertMsg2'><%=intr_msg_content_drug_food.toString()%>.</label><br><label id='foodIntrAlertMsg3'></label></td ><!-- modified for MMS-KH-CRF-0029[IN070606] -->
								<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>"><!-- added for RUT-SCF-0318.1 [IN:046811] -->
								<script>
									var msg = getMessage("PH_INTERACTION_ALERT","PH");
									var	msg1 = getMessage("PH_INTERACTION_RESTRICT","PH");
									msg = msg.replace("$$$",document.FormDrugInteractionsDetail.drug_desc.value);//added for RUT-SCF-0318.1 [IN:046811]
									
									//msg = msg.replace("###",'<%=intr_names.toString()%>'); // Commented for FD-RUT-CRF-0066.1 [IN036975]
									//document.getElementById("drugIntrAlertMsg1").innerText=msg;//commented for MMS-KH-CRF-0029[IN070606]
									//document.getElementById("drugIntrAlertMsg2").innerText='<%=intr_msg_content.toString()%>.';
<%
									if(msgRestrictTrans){
%>										
										document.getElementById("foodIntrAlertMsg3").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]
<%
									}
System.err.println("intr_msg_content_drug_lab=====300=>"+intr_msg_content_drug_lab);
%>
								</script>
							</tr> 
						</TABLE>
						<TABLE cellspacing="0" cellpadding="0" border="0" width = "100%" align="center" id="disease_interations" style="display"> 
							<tr >
								<td  class="label" align='left' style="<%=fontStyle%>"><label id='diseaseIntrAlertMsg1'></label><br><label id='diseaseIntrAlertMsg2'><%=intr_msg_content_drug_disease.toString()%>.</label><br><label id='diseaseIntrAlertMsg3'></label></td >
								<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>">
								<script>
									var msg = getMessage("PH_INTERACTION_ALERT","PH");
									var	msg1 = getMessage("PH_INTERACTION_RESTRICT","PH");
									msg = msg.replace("$$$",document.FormDrugInteractionsDetail.drug_desc.value);
									
<%
									if(msgRestrictTrans){
%>										
										document.getElementById("diseaseIntrAlertMsg3").innerText=msg1; //modified for MMS-KH-CRF-0029[IN070606]
<%
									}
%>
								</script>
							</tr> 
						</TABLE>
						<script>
						async function toHoldDrugLab(){
						<%  //MMS-KH-CRF-0029[IN070606] - start
							if(intrType!=null && intrType.size()>0){
								
								if(drug_drug_display.equals("inline")){
%>
									await callDrugInteractionForDrug();
									await Drug_tab.click();
<%	
								}else{
									if(drug_lab_display.equals("inline")){ %>
										await callDrugInteractionForLab();
										await DrugLab_tab.click();//modified for MMS-KH-CRF-0029[IN070606]
									
<%									}else if(drug_disease_display.equals("inline")){ %>
										await callDrugInteractionForDisease();
										await DrugDisease_tab.click();//modified for MMS-DM-CRF-0229
									
<%									}else{ %>
										await callDrugInteractionForFood(); //modified for MMS-KH-CRF-0029[IN070606]
										await DrugFood_tab.click();			//modified for MMS-KH-CRF-0029[IN070606]						
<%									}
								}

							} //MMS-KH-CRF-0029[IN070606] - end
						%>
						}toHoldDrugLab();
						</script>
				        
<%
					}
					else{
						if(hmDrugIntList!=null && hmDrugIntList.size()> 2){
%>
							<TABLE name="DrugInteractionList" id="DrugInteractionList" cellspacing="0" cellpadding="3" border="1" width = "100%" style="BACKGROUND-COLOR:#FFFFCC">   
								<tr>
									<td class='COLUMNHEADER' colspan='2' align='center'>&nbsp;<%=drug_desc%>&nbsp;-&nbsp;<%=form_desc%></td >
								</tr>
<%								String intr_desc = "";  //MMS-KH-CRF-0029
								String drug_dosage_display = "inline"; //MMS-KH-CRF-0029
								String intr_code = ""; // MMS-KH-CRF-0034.4
								
								for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
									DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
									intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
									intr_name = (String)DrugInteractionDtl.get("intr_name");
									severity_level = (String)DrugInteractionDtl.get("severity_level");
									significant_level = (String)DrugInteractionDtl.get("significant_level");
									probability = (String)DrugInteractionDtl.get("probability");
									restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
									interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
									form_desc = (String)DrugInteractionDtl.get("form_desc")==null?"":(String)DrugInteractionDtl.get("form_desc");
									test_result_value = (String)DrugInteractionDtl.get("test_result_value"); // MMS-KH-CRF-0034.4
									intr_code = (String)DrugInteractionDtl.get("intr_code")==null?"":(String)DrugInteractionDtl.get("intr_code"); // MMS-KH-CRF-0034.4
									interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");  //MMS-KH-CRF-0029 - start
									if(interaction_type.equals("F")){
										intr_desc = "Drug-Food";
										drug_dosage_display	="none";
									}
									else if(interaction_type.equals("L")){
										intr_desc = "Drug-Lab";
										drug_dosage_display	="none";
									}else if(interaction_type.equals("I")){
										intr_desc = "Drug-Disease";
										drug_dosage_display	="none";
									}
									else{
										intr_desc = "Drug-Drug";
										drug_dosage_display	="inline";
									}
									if(interaction_type.equals("L")){
										test_result_content = new StringBuffer();
									 if(CalledFrom.equals("") && !order_id.equals("")){
									 test_result_value= bean_1.getLabTestResult(order_id,order_line_no,drug_code,intr_code);
								//	  System.err.println("test_result_value=495==>"+test_result_value);
									 }
								//	 System.err.println("test_result_value=498==>"+test_result_value);
									if(!test_result_value.equals("") ){ 
										String lab_test_result_grp = "";
										StringTokenizer strToken = null;
										String prev_token = "";
										String token_value = "";
										String test_result[] = test_result_value.split("##");
//										test_result_content.append("<label style='color:black;font-size:9'>");
										if(test_result.length>1){
										 for(int j=0;j<test_result.length;j++){
										    lab_test_result_grp= test_result[j];
											strToken = new StringTokenizer(lab_test_result_grp,"$$");
											token_value = "";
											prev_token  = "";
											while(strToken.hasMoreTokens())
											{
												//test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");
											token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											//	test_result_content.append(strToken.nextToken()+"&nbsp;&nbsp;");

											}
											test_result_content.append("<br><br>");
										 }
										}else{

											lab_test_result_grp= test_result[0];
										
										strToken = new StringTokenizer(lab_test_result_grp,"$$");
										token_value = "";
										prev_token  = "";
										while(strToken.hasMoreTokens())
											{
											 /*token_value = strToken.nextToken();
											 test_result_content.append(token_value+"&nbsp;&nbsp;");*/
											 token_value = strToken.nextToken();
											if(token_value.equals("Low")){
											test_result_content.append("<label style='color:blue;font-size:12'>");
											}else if(token_value.equals("High")){
											test_result_content.append("<label style='color:red;font-size:12'>");
											}else if(prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("<label style='color:#9900ff;font-size:12'>");
											}

											if(!token_value.equals("A") && !token_value.equals("N"))
												test_result_content.append(token_value+"&nbsp;&nbsp;");

											if(token_value.equals("Low") || token_value.equals("High") || prev_token.equals("A") || prev_token.equals("N")){
											test_result_content.append("</label>");
											}
											prev_token =token_value;
											}
											test_result_content.append("<br><br>");
										}
										//test_result_content.append("</label>");
									  }
									   System.err.println("test_result_content===>"+test_result_content);
									}

%>									<tr><td style="BACKGROUND-COLOR:#FFFFCC">    
									<fmt:message key="ePH.InteractionType.label" bundle="${ph_labels}"/></td>
									<td style="BACKGROUND-COLOR:#FFFFCC"><%=intr_desc%>&nbsp;</td >
</tr>
									<tr>
										<td width='15%' style="color:red;BACKGROUND-COLOR:#FFFFCC">
<%		
										if(interaction_type.equals("F")){  %><!--  //MMS-KH-CRF-0029 - start-->
											<fmt:message key="ePH.FoodIngredient.label" bundle="${ph_labels}"/>
<%										}
										else if(interaction_type.equals("L")){  %>
											 <fmt:message key="ePH.LabOrderCatalog.label" bundle="${ph_labels}"/>
											 
<%										}
										else if(interaction_type.equals("I")){  %><!--  //MMS-KH-CRF-0029 - start-->
											<fmt:message key="Common.TermCodeDescription.label" bundle="${common_labels}"/>
<%										}
										else if(intr_option.equals("D")){
%>
											Drug Name
											<!-- <fmt:message key="Common.DrugName.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
<%
										}
										else{
%>
											<!--<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
											Generic Name
<%
										}
%>
										</td >
										<td width='*' style="color:red;BACKGROUND-COLOR:#FFFFCC"><b><%=intr_name%></b></td >
									</tr>
									<tr><!-- display added for MMS-KH-CRF-0029-->
										<td style="BACKGROUND-COLOR:#FFFFCC;display:<%=drug_dosage_display%>" >Dosage Form 
										<!-- <fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
										</td >
										<td style="BACKGROUND-COLOR:#FFFFCC;display:<%=drug_dosage_display%>"><%=form_desc%>&nbsp;</td >
									</tr>
									<tr>
										<td style="BACKGROUND-COLOR:#FFFFCC">Severity&nbsp;Level
										<!--<fmt:message key="Common.Severity.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
										</td >
										<td style="BACKGROUND-COLOR:#FFFFCC">
<%
										if(severity_level.equals("H")){
%>		
											<!-- <fmt:message key="ePH.Major.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Major
<%
										}
										else if(severity_level.equals("M")){
%>
											<!--<fmt:message key="Common.Moderate.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Moderate
<%
										}
										else if(severity_level.equals("L")){
%>
											<!-- <fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
											Minor
<%
										}
%>
										</td >
									</tr>
									<tr>
										<td style="BACKGROUND-COLOR:#FFFFCC">Significant&nbsp;Level
										<!-- <fmt:message key="Common.significant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
										</td >
										<td style="BACKGROUND-COLOR:#FFFFCC"><%=significant_level%></td >
									</tr>
									<tr>
										<td style="BACKGROUND-COLOR:#FFFFCC">Documentation
											<!--<fmt:message key="ePH.documentation.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814] -->
										</td >  <!-- Modified for FD-RUT-CRF-0066.1 [IN036975] -->
										<td style="BACKGROUND-COLOR:#FFFFCC">
<%
							                      //if(probability.equals("D")){   Commented and added for FD-RUT-CRF-0066.1 [IN036975] --begin
%>		
								                   <!--<fmt:message key="Common.Definitive.label" bundle="${common_labels}"/>-->
<%
						                              //}
						                              //else if(probability.equals("P")){
%>
						   				<!--	<fmt:message key="Common.Probable.label" bundle="${common_labels}"/>-->
<%
									//	}

										if(probability.equals("E")){
%>		
											<!-- <fmt:message key="ePH.established.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Established
<%
										}
										else if(probability.equals("P")){
%>		
											<!-- <fmt:message key="Common.Probable.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Probable
<%
										}
										else if(probability.equals("S")){
%>		
											<!-- <fmt:message key="ePH.suspected.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Suspected
<%
										}
										else if(probability.equals("O")){
%>		
											<!-- <fmt:message key="ePH.Possible.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Possible
<%
										}
										else if(probability.equals("U")){
%>		
											<!-- <fmt:message key="ePH.Unlikely.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
											Unlikely
<%
										} //FD-RUT-CRF-0066.1 [IN036975] --end
%>
									</td >
								</tr>
								<tr>
									<td style="BACKGROUND-COLOR:#FFFFCC">RestrictTransaction
										<!--<fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
									</td >
									<td style="BACKGROUND-COLOR:#FFFFCC">
<%
									if(restrict_transaction.equals("Y")){
%>		
										<img src='../../eCommon/images/enabled.gif'>
<%
									}
									else if(restrict_transaction.equals("N")){
%>
										<img src='../../eCommon/images/disabled.gif'>
<%
									}
%>
									</td >
								</tr>
								<tr>
									<td style="BACKGROUND-COLOR:#FFFFCC">Interaction&nbsp;Description
										<!-- <fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
									</td > 
									<td style="BACKGROUND-COLOR:#FFFFCC"><textarea readonly="false"  style="BACKGROUND-COLOR:#FFFFCC;border: none;overflow: auto;" cols="80" ><%=interaction_desc%></textarea></td> <!-- added for FD-RUT-CRF-0066.1 [IN036975] -->
								</tr>
								<%
									if(interaction_type.equals("L")){
								%>
								<tr> <td style="BACKGROUND-COLOR:#FFFFCC">Lab Result(s)&nbsp;</td> <!--MMS-KH-CRF-0034.4-->
								<td style="BACKGROUND-COLOR:white"><%=test_result_content.toString()%></td>	
								</tr>
								<%}%>
								<tr> <td colspan='2' style="BACKGROUND-COLOR:#FFFFCC">&nbsp;</td>
								</tr>
<%
							}
%>
							</TABLE>
<%
						}
						else{
%>
							<TABLE name="DrugInteractionList" id="DrugInteractionList" cellspacing="0" cellpadding="3" border="1" width = "100%" style="BACKGROUND-COLOR:#FFFFCC">   
								<tr>
									<td class='COLUMNHEADER' colspan='2' align='center'><fmt:message key="ePH.NoDrugInteractionFound.label" bundle="${ph_labels}"/></td >
								</tr>
							</table>
<%
						}
					}
				}
				else{
%>
					<TABLE name="DrugInteractionList" id="DrugInteractionList" cellspacing="0" cellpadding="3" border="1" width = "100%" style="BACKGROUND-COLOR:#FFFFCC">   
						<tr>
							<td class='COLUMNHEADER' colspan='2' align='center'><fmt:message key="ePH.NoDrugInteractionFound.label" bundle="${ph_labels}"/></td >
						</tr>
					</table>
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


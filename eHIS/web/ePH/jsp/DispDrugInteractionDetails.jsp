<!DOCTYPE html>
<!-- /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
05/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 
30/11/2019      [IN070606]     Manickavasagam J             MMS-KH-CRF-0029 [IN070606] 
---------------------------------------------------------------------------------------------------------------
*/ -->
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title><fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/></title>
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
	</head>
<body>
 
<%                              
                                 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
                                 String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
             				     String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
                                 String bean_name		= "ePH.PrescriptionBean_1"; 
                                 PrescriptionBean_1 bean =  (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
                                 bean.setLanguageId(locale);
                                 String drug_code		        = request.getParameter( "drug_code" )==null?"":request.getParameter("drug_code");
                                 String form_code = request.getParameter("form_code")==null?"":request.getParameter("form_code");
                                 String generic_id = request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
                                 String start_date = request.getParameter("start_date")==null?"":request.getParameter("start_date");
                                 String end_date = request.getParameter("end_date")==null?"":request.getParameter("end_date");                                                             
                                 ArrayList hmDrugIntList = bean.getDrugInteractionDtls(drug_code, form_code, generic_id, start_date, end_date, patient_id);                                                                 
                                 HashMap DrugInteractionDtl=null;  
                                 String drug_desc = request.getParameter("drug_name")==null?"":request.getParameter("drug_name");                                                                 
									
                                 String intr_option,intr_name, severity_level, significant_level, probability, interaction_desc, restrict_transaction,form_desc="";
                                                         																																	
                    form_desc = request.getParameter("form_desc")==null?"":request.getParameter("form_desc");
					String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id"); //MMS-KH-CRF-0034.4
					String order_line_no = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");//MMS-KH-CRF-0034.4
                                 String interaction_type=""; //MMS-KH-CRF-0029
%>
							<TABLE   name="DrugInteractionList" cellspacing="0" cellpadding="3" border="1" width = "100%" style="BACKGROUND-COLOR:#FFFFCC">   
								<tr>
									<td class='COLUMNHEADER' colspan='2' align='center'>&nbsp;<%=drug_desc%>&nbsp;-&nbsp;<%=form_desc%></td >
								</tr>
<%                                  
								if(hmDrugIntList!=null){
									String intr_desc = "";  //MMS-KH-CRF-0029
								String drug_dosage_display = "inline"; //MMS-KH-CRF-0029
							//MMS-KH-CRF-0034.4 - start
								String intr_code = "";
								String test_result_value = "";
								StringBuffer test_result_content = null; 
								//MMS-KH-CRF-0034.4 - end
                                 for(int count=0 ; count<(hmDrugIntList.size()-2) ; count++){
									DrugInteractionDtl =(HashMap) hmDrugIntList.get(count);
									test_result_value = "";//MMS-KH-CRF-0034.4
									intr_option = (String)DrugInteractionDtl.get("INTR_TYPE1");
									intr_name = (String)DrugInteractionDtl.get("intr_name");
									severity_level = (String)DrugInteractionDtl.get("severity_level");
									significant_level = (String)DrugInteractionDtl.get("significant_level");
									probability = (String)DrugInteractionDtl.get("probability");
									restrict_transaction = (String)DrugInteractionDtl.get("restrict_transaction");
									interaction_desc = (String)DrugInteractionDtl.get("interaction_desc");
									form_desc = (String)DrugInteractionDtl.get("form_desc")==null?"":(String)DrugInteractionDtl.get("form_desc");
									intr_code = (String)DrugInteractionDtl.get("intr_code")==null?"":(String)DrugInteractionDtl.get("intr_code"); //MMS-KH-CRF-0034.4
									interaction_type = (String)DrugInteractionDtl.get("INTR_TYPE2");  
									//MMS-KH-CRF-0029[IN070606] - start//MMS-KH-CRF-0034.4
									if(interaction_type.equals("F")){
										intr_desc = "Drug-Food";
										drug_dosage_display	="none";
									}
									else if(interaction_type.equals("L")){
										intr_desc = "Drug-Lab";
										drug_dosage_display	="none";
									}else if(interaction_type.equals("I")){//Added for MMS-DM-CRF-0229
										intr_desc = "Drug-Disease";
										drug_dosage_display	="none";
									}
									else{
										intr_desc = "Drug-Drug";
										drug_dosage_display	="inline";
									}
						//MMS-KH-CRF-0034.4 - start
									if(interaction_type.equals("L")){
										test_result_content = new StringBuffer();
									 test_result_value= bean.getLabTestResult(order_id,order_line_no,drug_code,intr_code);

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
				//MMS-KH-CRF-0034.4 - end
									}
%>
									<tr><td style="BACKGROUND-COLOR:#FFFFCC">    
									<fmt:message key="ePH.InteractionType.label" bundle="${ph_labels}"/></td>
									<td style="BACKGROUND-COLOR:#FFFFCC"><%=intr_desc%>&nbsp;</td >
									</tr> <!-- MMS-KH-CRF-0029[IN070606] end-->
									<tr>
										<td width='15%' style="color:red;BACKGROUND-COLOR:#FFFFCC">
<%											if(interaction_type.equals("F")){  %><!--  //MMS-KH-CRF-0029[IN070606] - start-->
											<fmt:message key="ePH.FoodIngredient.label" bundle="${ph_labels}"/>
<%										}
										else if(interaction_type.equals("L")){  %>
											 <fmt:message key="ePH.LabOrderCatalog.label" bundle="${ph_labels}"/>
											 
<%										}else if(intr_option.equals("D")){
%>
											Drug Name
											
<%
										}
										else{
%>											
											Generic Name
<%
										}
%>
										</td >
										<td width='*' style="color:red;BACKGROUND-COLOR:#FFFFCC"><b><%=intr_name%></b></td >
									</tr>
									<tr> <!-- added for MMS-KH-CRF-0029 [IN070606]-->
										<td style="BACKGROUND-COLOR:#FFFFCC;display:<%=drug_dosage_display%>" >Dosage Form										
										</td >
										<td style="BACKGROUND-COLOR:#FFFFCC"><%=form_desc%>&nbsp;</td >
									</tr>
									<tr>
										<td style="BACKGROUND-COLOR:#FFFFCC">Severity&nbsp;Level										
										</td >
										<td style="BACKGROUND-COLOR:#FFFFCC">
<%
										if(severity_level.equals("H")){
%>													
											Major
<%
										}
										else if(severity_level.equals("M")){
%>											
											Moderate
<%
										}
										else if(severity_level.equals("L")){
%>											
											Minor
<%
										}
%>
										</td >
									</tr>
									<tr>
										<td style="BACKGROUND-COLOR:#FFFFCC">Significant&nbsp;Level										
										</td >
										<td style="BACKGROUND-COLOR:#FFFFCC"><%=significant_level%></td >
									</tr>
									<tr>
										<td style="BACKGROUND-COLOR:#FFFFCC">Documentation											
										</td >  
										<td style="BACKGROUND-COLOR:#FFFFCC">
<%							                      
									

										if(probability.equals("E")){
%>													
											Established
<%
										}
										else if(probability.equals("P")){
%>													
											Probable
<%
										}
										else if(probability.equals("S")){
%>													
											Suspected
<%
										}
										else if(probability.equals("O")){
%>													
											Possible
<%
										}
										else if(probability.equals("U")){
%>													
											Unlikely
<%
										}
%>
									</td >
								</tr>
								<tr>
									<td style="BACKGROUND-COLOR:#FFFFCC">RestrictTransaction										
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
									</td > 
									<td style="BACKGROUND-COLOR:#FFFFCC"><textarea readonly="false"  style="BACKGROUND-COLOR:#FFFFCC;border: none;overflow: auto;" cols="80" ><%=interaction_desc%></textarea></td> <!-- added for FD-RUT-CRF-0066.1 [IN036975] -->
								</tr>
								<%
									if(interaction_type.equals("L")){
								%>
								<tr> <td style="BACKGROUND-COLOR:#FFFFCC">Lab Result(s)&nbsp;</td><!-- MMS-KH-CRF-0034.4-->
								<td style="BACKGROUND-COLOR:#ffcc00"><%=test_result_content.toString()%></td>	
								</tr>
								<%}%>
								<tr> <td colspan='2' style="BACKGROUND-COLOR:#FFFFCC">&nbsp;</td>
								</tr>
<%
							}
						}
%>
							</TABLE>


</body>
</html>

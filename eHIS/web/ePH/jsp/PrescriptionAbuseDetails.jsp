<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale = (String) session.getAttribute("LOCALE");

	String generic_name	=	request.getParameter("generic_name")==null?"":request.getParameter("generic_name"); 
	String drug_name	=	request.getParameter("drug_name")==null?"":request.getParameter("drug_name"); 
	String generic_id	=	request.getParameter("generic_id");
	String patient_id	=	request.getParameter("patient_id");
	String encounter_id 	=	request.getParameter("encounter_id");
	String fontStyle="color:red;font-size:12;";//ADDED FOR AAKH-CRF-0140
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	HashMap details				= null;

			
%> 
	<html>
		<head>
			<title>Drug Abuse</title>
			<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link> <!-- added for MMS-KH-CRF-0029[IN070606] -->
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/Prescription_1.js"></SCRIPT> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
			<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="FormDrugInteractionsDetail" id="FormDrugInteractionsDetail">
<%
			try{
				String drug_code= request.getParameter( "drug_code" )==null?"":request.getParameter("drug_code");
					String CalledFrom		        = request.getParameter( "CalledFrom" )==null?"":request.getParameter("CalledFrom");
					String CalledFro		        = request.getParameter( "CalledFro" )==null?"":request.getParameter("CalledFro");
				String drug_class		        = "";//request.getParameter( "drug_class" )==null?"":request.getParameter("drug_class");
				String drug_desc		        ="";// request.getParameter( "drug_desc" )==null?"":request.getParameter("drug_desc");
				String abuse_restric_trn="N";
				String abuse_exists="N";
				String abuse_remarks="";
				String abuse_action="U";
				String abuse_type="DC";
				String abuse_value="";
				String abuse_type_value="";
				String drug_abuse_value="";

					bean.setLanguageId(locale);
					
					System.out.println("patient_id"+patient_id);
					System.out.println("drug_code"+drug_code);
					System.out.println("drug_class"+drug_class);
					drug_class=bean.getDrugClassByOrderId(drug_code);
					System.out.println("drug_class"+drug_class);
					HashMap abuseData=bean.getabusedetails(patient_id, drug_code, drug_class);
					System.out.println("abuseData"+abuseData);
					abuse_restric_trn=(String)abuseData.get("restrict_tran");
					if(abuseData.size()>0){
						abuse_exists="Y";
					}
					else{
						abuse_exists="N";
					}
					
					 abuse_remarks=(String)abuseData.get("remarks");
					 abuse_action=(String)abuseData.get("action_type_flag");
					 abuse_type=(String)abuseData.get("restriction_type");
					 drug_desc=bean.getDrugDescByOrderId(drug_code);
					 abuse_value=(String)abuseData.get("DRUG_CLASS_OR_DRUG_CODE");
					 System.out.println("abuseData95"+abuseData);	
					 System.out.println("abuseData95"+drug_desc+""+abuse_value+"abuse_type"+abuse_type);
					 System.out.println("abuseData95"+abuse_remarks+""+abuse_action+"abuse_restric_trn"+abuse_restric_trn);
					 if(abuse_value.equals("G")){
							abuse_value="General";
						}
						else if(abuse_value.equals("N")){
							abuse_value="Norcotics";
						}
						else{
							abuse_value="Controlled";
						}
						if(abuse_type.equals("DC")){
							abuse_type_value="Drug Class";
						}
						else{
							abuse_type_value="Drug Name";
						}
						if(abuse_type.equals("DN")){
							drug_abuse_value=drug_desc;	
						}
						else{
							drug_abuse_value=abuse_value;
						}
				
					 
			
				StringBuffer intr_msg_content = new StringBuffer();
				StringBuffer intr_msg_content_drug_lab = new StringBuffer();
				System.out.println("calledFor"+CalledFro);
				    if(CalledFro.equals("Alert")){
				    	System.out.println("else 137");

						
						ArrayList drugLabInteractionList = new ArrayList();
						
						
										intr_msg_content.append("has been marked for Substance Abuse for the patient.<br>");
										intr_msg_content.append("The patient is under risk of overdose.Remarks entered in 'Substance Abuse' with restriction<br>");
										
										drugLabInteractionList.add(drug_desc + " " +intr_msg_content.toString());
						
						System.out.println("drugLabInteractionList115"+drugLabInteractionList);

						if(drugLabInteractionList!=null && drugLabInteractionList.size()>0){
						intr_msg_content_drug_lab = new 	StringBuffer();
							
								intr_msg_content_drug_lab.append("<hr size=1>");

								intr_msg_content_drug_lab.append((String)drugLabInteractionList.get(0));
								
							
							intr_msg_content_drug_lab = new 	StringBuffer(intr_msg_content_drug_lab.toString());  //Removed the encode for MMS-KH-CRF-0029[IN71814]
						}
						System.out.println("drugLabInteractionList115"+intr_msg_content_drug_lab);
%>
						<TABLE name="DrugInteractionAlert" id="DrugInteractionAlert" cellpadding=0 cellspacing=0 width="110%" align="center" border="0">   
							
							<tr> <!-- MMS-KH-CRF-0029[IN070606] start-->
								<td width= "180%" class="white">
								 <ul id="tablist" class="tablist" >   

								<li class="tablistitem" title='Drug Abuse' style="display:inline">
								 <a onclick="tab_click3('DrugLab_tab')" class="tabA" id="DrugLab_tab" >
									<span class="tabAspan" id="DrugLab_tabspan">
									Drug Abuse</span>
									</a>
								</li>
								
								
								</ul>
								</td>
								</tr>
								</table>
						
					
						<TABLE cellspacing="0" cellpadding="0" border="0" width = "100%" align="center" id="lab_interations" style="display:inline"> 
							<tr >
							<!--	<td class="label" width='2px' style='vertical-align:top;'><img value="" src="../../ePH/images/redAlert.png" height='40 ' width='40'></img>-->
								<td  class="label" align='left' style="<%=fontStyle%>"><label id='labIntrAlertMsg1'></label><br><label id='labIntrAlertMsg2' style="color:red;font-size:12;"><%=intr_msg_content_drug_lab.toString()%>.</label><br>
								<%if(abuse_restric_trn.equals("Y")){ %>
								<label style="<%=fontStyle%>" >Hence, the drug can not be prescribed.</label></td >
								<%} %>
								<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>"><!-- added for RUT-SCF-0318.1 [IN:046811] -->
								
							</tr> 
						</TABLE>
						
										        
<%
					}
					else{
						System.out.println("else 205");
						if(abuse_exists.equals("Y")){
							System.out.println("abuse_exists 205"+abuse_exists);
%>
							<TABLE name="DrugInteractionList" id="DrugInteractionList" cellspacing="0" cellpadding="3" border="1" width = "100%" style="BACKGROUND-COLOR:#FFFFCC">   
								<tr>
									<td class='COLUMNHEADER' colspan='2' align='center'>&nbsp;<%=drug_desc%>&nbsp;&nbsp;</td >
								</tr>
								<tr><td style="BACKGROUND-COLOR:#FFFFCC">    
									Restriction Type</td>
									<td style="BACKGROUND-COLOR:#FFFFCC"><%=abuse_type_value%>&nbsp;</td >
</tr>
									<tr>
										<td width='15%' style="color:red;BACKGROUND-COLOR:#FFFFCC">

											 <%=abuse_type_value%>
											 
										</td >
										<td width='*' style="color:red;BACKGROUND-COLOR:#FFFFCC"><b><%=drug_abuse_value%></b></td >
									</tr>
									
								<tr>
									<td style="BACKGROUND-COLOR:#FFFFCC">RestrictTransaction
										<!--<fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
									</td >
									<td style="BACKGROUND-COLOR:#FFFFCC">
<%
									if(abuse_restric_trn.equals("Y")){
%>		
										<img src='../../eCommon/images/enabled.gif'>
<%
									}
									else if(abuse_restric_trn.equals("N")){
%>
										<img src='../../eCommon/images/disabled.gif'>
<%
									}
%>
									</td >
								</tr>
								<tr>
									<td style="BACKGROUND-COLOR:#FFFFCC">Remarks
										<!-- <fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/> commented RUT-SCF-0319 [IN:044814]-->
									</td > 
									<td style="BACKGROUND-COLOR:#FFFFCC"><%=abuse_remarks%></td>
								</tr>
							
								
								<tr> <td colspan='2' style="BACKGROUND-COLOR:#FFFFCC">&nbsp;</td>
								</tr>
<%
							
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
			catch(Exception e){
				e.printStackTrace();
			}
%>
		</form>
		</body>
	<% putObjectInBean(bean_id,bean,request); %>
</html>


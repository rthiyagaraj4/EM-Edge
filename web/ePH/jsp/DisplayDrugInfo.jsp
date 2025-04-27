<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title></title>
<%
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/FDBDrugInfo.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body> 
<%
		String bean_id					= "ExternalProductLinkBean" ;
		String bean_name				= "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean bean	= (ExternalProductLinkBean)getBeanObject( bean_id, bean_name, request ) ;

		String prodid					= request.getParameter("extprodid");	
		String tabname					= request.getParameter("infoparam");
		HashMap drugInfos = null;
		//HashMap FDBdrugInfos = getExternalDBDrugInfo(prodid);
		
		try
		{
			ArrayList ade	=	new ArrayList();
			HashMap eqdrugs	=	new HashMap();    
			drugInfos = (HashMap)bean.getExternalDBDrugInfo(prodid);
%>
			<table id="TblEquiv" name="TblEquiv" id="TblEquiv" width="100%"  height="100%">
				<TBODY     vALIGN ="TOP" >
					<tr><td style="BACKGROUND-COLOR:#FFFFCC">
<%
					if(drugInfos !=null && drugInfos.size()>0){
						if(tabname.equalsIgnoreCase("TblEquiv")){
							ArrayList data =null;
							//HashMap drug_info_classification	= (HashMap)bean.getDrugClassificationInfo(prodid);
							HashMap drug_info_classification	= (HashMap)drugInfos.get("DRUG_CLASSFI");
							if(drug_info_classification !=null){
								ArrayList AHFS_class_info			= (ArrayList)drug_info_classification.get("AHFS");
								ArrayList FDB_class_info			= (ArrayList)drug_info_classification.get("FDB");

								if(AHFS_class_info!=null && AHFS_class_info.size()>0){
%>
									<table width="100%" >
										<TR><Th  align="left" colspan=2 > AHFS Classification</Th></TR>
<%	    
											for(int i=0;i<AHFS_class_info.size();i++){
											   data=(ArrayList)AHFS_class_info.get(i);
											   int kk=0;
											   int ll=0;
											   if(data !=null && data.size()>0){
													for(int j=data.size()-1;j>=0;j--){
														// int kk=j*5;
														// int ll=100-kk;
														kk=kk+5;
														ll=100-10;
%> 
														<table width="100%">
														<TR ><TD  width="<%=kk%>%" style="BACKGROUND-COLOR:#FFFFCC"></td><TD  width="<%=ll%>%" style="BACKGROUND-COLOR:#FFFFCC"><%=data.get(j)%></td></tr>
														</table>

<%												
													}
												}
											}
%>
									<table>
<%	
								}  

								if(FDB_class_info!=null && FDB_class_info.size()>0){
%>
									<table width="100%">
										<TR><Th  align="left" colspan=2 > FDB Classification</Th></TR>
<%	    
										for(int i=0;i<FDB_class_info.size();i++){
										   data=(ArrayList)FDB_class_info.get(i);
											if(data !=null && data.size()>0){
												int kk=0;
												int ll=0;
												for(int j=data.size()-1;j>=0;j--){
													kk=kk+5;
													ll=100-10;
%>
													<table width="100%">
														<TR ><TD  width="<%=kk%>%" style="BACKGROUND-COLOR:#FFFFCC"></td><TD  width="<%=ll%>%" style="BACKGROUND-COLOR:#FFFFCC"><%=data.get(j)%></td></tr>
													</table>
<% 
												}
											}
										}
%>
									</table>
<%
								}
							}
%>
						</td></tr>
					</TBODY>
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblIndications")){
%>
				<table id="TblIndications" name="TblIndications" id="TblIndications" width="100%" height="100%">
				<TBODY     vALIGN ="TOP" >
					<tr><td style="BACKGROUND-COLOR:#FFFFCC">
						<table>
<%
							//HashMap interaction=(HashMap)bean.getDrugInteractionDetail(prodid);
							HashMap interaction=(HashMap)drugInfos.get("INTE");;
							if (interaction!=null && interaction.size()>0)
							{
%>
								<!--  <TR><Th  align="left" id="header" colspan=2> Drug Interaction</Th></TR> -->
								<TR ><Th colspan=2 ><%=interaction.get("INT_DESC")%></Th></TR>
								<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><b>Severity   </b></td>
<%
									if(interaction.containsKey("SEV_DESC")){
%>
										<td  style="BACKGROUND-COLOR:#FFFFCC"><%=interaction.get("SEV_DESC")%></TD></TR>
<%  
									}
									else{
%>
										<td style="BACKGROUND-COLOR:#FFFFCC">&nbsp;&nbsp;</TD></TR>
<%
									}
%>
									<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><b>Clinical Effect    </b></td>
<%
									if(interaction.containsKey("CLIN_EFFECT"))
									{
%>
										<td  style="BACKGROUND-COLOR:#FFFFCC"><%=interaction.get("CLIN_EFFECT")%></TD></TR>
<%  
									}
									else{
%>
										<td  style="BACKGROUND-COLOR:#FFFFCC">&nbsp;&nbsp;</TD></TR>
<%
									} 
%>
									<TR ><TD colspan=2  style="BACKGROUND-COLOR:#FFFFCC"><b>Support Documentation   </b> </td> </tr>
<%
									if(interaction.containsKey("SUPP_DOC")){
										ArrayList supp_doc=(ArrayList)interaction.get("SUPP_DOC");
									   for(int i=0;i<supp_doc.size();i++ ){
%>               
											<tr><td  style="BACKGROUND-COLOR:#FFFFCC">&nbsp;</td> <td  style="BACKGROUND-COLOR:#FFFFCC"><Li><%=supp_doc.get(i)%></Li></TD></tr>
<%    
										}
									}
									if(interaction.containsKey("DRUGS")){
										ArrayList drugs=(ArrayList)interaction.get("DRUGS");
%>
										<TR ><TD colspan=2 style="BACKGROUND-COLOR:#FFFFCC"><b><%=drugs.get(0)%></b></td><tr>
<%  
										for(int i=1;i<(drugs.size());i++ ){
%>               
											<tr><td  style="BACKGROUND-COLOR:#FFFFCC">&nbsp;</td><td style="BACKGROUND-COLOR:#FFFFCC"><Li><%=drugs.get(i)%></Li></TD></TR>

<% 
										}
									}	
								}
								else{
%>
									<TR><TD style="color:red" style="BACKGROUND-COLOR:#FFFFCC"> No Relevant Information found</TD></TR>
<%
								}
%>
							</table>
						</td></tr>
					</TBODY  >
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblPrecautions")){
%>
				<table id="TblPrecautions" name="TblPrecautions" id="TblPrecautions" width="100%" height="100%">
					<TBODY     vALIGN ="TOP" >
						<tr><td style="BACKGROUND-COLOR:#FFFFCC">
							<table>
<%
								//HashMap precautions =(HashMap)bean.getDrugPreccautions(prodid);
								HashMap precautions =(HashMap)drugInfos.get("PREC");
								if (precautions!=null && precautions.size()>0){
%>
<!-- <TR ><Th  align="left" id="header" colspan=2>Precautions</Th></TR> -->
<%	
									HashMap geriscrnresult = (HashMap)precautions.get("GERI");
									HashMap lactscrnresult = (HashMap)precautions.get("LACT");
									HashMap pediscrnresult = (HashMap)precautions.get("PEDI");
									HashMap pregscrnresult = (HashMap)precautions.get("PREG");
									 
									if(geriscrnresult!=null && geriscrnresult.size()>0){%>
										<TR><Th  align="left" id="header" colspan=2>Geriatric Precautions</Th></TR>
<%  
										for (int i=0;i<geriscrnresult.size()-1;i=+2)
										{
%>
											 <TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b>Severity  </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=geriscrnresult.get("Severity_Level_Desc_"+i)%></TD></TR>
											 <TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b>Comment   </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=geriscrnresult.get("comment_"+i)%></TD></TR> 
<%
										}
								   }
								   if(lactscrnresult!=null && lactscrnresult.size()>0){
%>
									  <TR><Th  align="left" id="header"  colspan=2>Lactation Precautions</Th></TR>
<%  
										for (int i=0;i<lactscrnresult.size()-1;i=+4)
										{
%>
											<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><b>Severity          </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=lactscrnresult.get("Severity_Level_Desc_"+i)%></TD></TR>
											<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><b>Exerection Effect </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=lactscrnresult.get("Excretion_Effect_Desc_"+i)%></TD></TR>
											<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><b>Lactation  effect </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=lactscrnresult.get("Effect_desc_"+i)%></TD></TR>
											<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><b>Comment           </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=lactscrnresult.get("comment_"+i)%></TD></TR>  
<% 
										}
									}
									if(pediscrnresult!=null && pediscrnresult.size()>0){
%>
										<TR><Th  align="left" id="header" colspan=2>Pediatric Precautions</Th></TR>
<%  
										for (int i=0;i<pediscrnresult.size()-1;i=+2)
										{
%>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b>Severity   </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=pediscrnresult.get("Severity_Level_Desc_"+i)%></TD></TR>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b>Comment    </b> </td><td style="BACKGROUND-COLOR:#FFFFCC"><%=pediscrnresult.get("comment_"+i)%></TD></TR> 
<%
										}
									}
									if(pregscrnresult!=null && pregscrnresult.size()>0){
%>
										<TR><Th  align="left" id="header" colspan=2>Pregnency Precautions</Th></TR>
<%  
										for (int i=0;i<pregscrnresult.size()-1;i=+2)
										{
%>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b>Significance </b></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=pregscrnresult.get("Significent_Level_Desc_"+i)%></TD></TR>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b>Comment      </b></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=pregscrnresult.get("comment_"+i)%></TD></TR>
<%
										}
									}	
								}
								else{
%>
									<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%
								}
%>
							</table>
						</TD></TR>
					</TBODY >
				</TABLE>
<%
			}
			else if(tabname.equalsIgnoreCase("TblInteractions")){
%>
				<table id="TblADE" name="TblADE" id="TblADE" width="100%" border=1  height="100%">
					<TBODY     vALIGN ="TOP" >
						<tr><td style="BACKGROUND-COLOR:#FFFFCC">
							<table width="100%" border=1>

<!-- <TR><Th align="left" id="header" colspan=3>Common Orders</Th></TR> -->
<%
								//ArrayList common_orders	=	(ArrayList)bean.getCommonOrders(prodid);
								ArrayList common_orders	=	(ArrayList)drugInfos.get("COMMON_ORD");
								ArrayList child			=	null;
								ArrayList adult			=	null;
								ArrayList elder			=	null;
								HashMap data			=	null;
								if(common_orders!=null && common_orders.size()>0){
									ArrayList data1 = null;
									for(int i=0;i<common_orders.size();i++){
										data = (HashMap) common_orders.get(i);
										if(data!=null && data.size()>0){
											adult=(ArrayList)data.get("ADULT");
											child=(ArrayList)data.get("CHILD");
											elder=(ArrayList)data.get("ELDER"); 
											if(child!=null && child.size()>0){
%>
												<tr><th>child (Age Range :0-13 Years)</th></tr>
<%
												for(int j=0;j<child.size();j+=2){
%>
													<tr><td colspan=3 align ='left'  style="BACKGROUND-COLOR:#FFFFCC;color:red"><b> Indication  : <%=child.get(j)%></b></td></tr> 
													<tr><th ><b> Dose Type</b></th><th><b> Route</b></th><th ><b> Order String</b></th></tr> 
<%
													data1=(ArrayList)child.get(j+1);
													if(data1!=null && data1.size()>0){
														for(int k=0;k<data1.size();k+=4){
%>
															<tr><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k)%></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k+1)%></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k+2)%><br><%=data1.get(k+3)%></td></tr>       
<%
														}
													}
												}
											}
											if(adult!=null && adult.size()>0){ 
%>	  
												<tr><td style="BACKGROUND-COLOR:#FFFFCC"  colspan=3><font size="3"><b>Adults </b></font>(Age Range :13-65 Years)</td></tr>
<%
												for(int j=0;j<adult.size();j+=2){
%>
													<tr><td colspan=3 align ='left' style="BACKGROUND-COLOR:#FFFFCC;color:red"><b> Indication  : <%=adult.get(j)%></b></td></tr> 
													<tr><th ><b> Dose Type</b></th><th><b> Route</b></th><th ><b> Order String</b></th></tr> 
<% 
													data1=(ArrayList)adult.get(j+1);
													if(data1!=null && data1.size()>0){
														for(int k=0;k<data1.size();k+=4){
%>
															<tr><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k)%></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k+1)%></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k+2)%><br><%=data1.get(k+3)%></td></tr>   
<% 
														}
													}
												}
											}
											if(elder!=null && elder.size()>0){ 
%>	  
												<tr><th>Elders (Age Range : >65 Years)</th></tr>
<%
												for(int j=0;j<elder.size();j+=2){
%>
													<tr><td colspan=3 align ='left' style="BACKGROUND-COLOR:#FFFFCC;color:red"><b> Indication  : <%=elder.get(j)%></b></td></tr> 
													<tr><th ><b> Dose Type</b></th><th><b> Route</b></th><th ><b> Order String</b></th></tr> 
<%	
													data1=(ArrayList)elder.get(j+1);
													if(data1!=null && data1.size()>0){
														for(int k=0;k<data1.size();k+=4){
%>
															<tr><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k)%></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k+1)%></td><td style="BACKGROUND-COLOR:#FFFFCC"><%=data1.get(k+2)%><br><%=data1.get(k+3)%></td></tr>       
<% 
														}
													}
												}
											}
										}
									}
								}
								else{
%>
									<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%
								}
%>
							</table>
						</td></tr>
					</TBODY >
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblFood")){
%>
				<table id="TblFood" name="TblFood" id="TblFood" width="100%" HEIGHT="100%" >
					<TBODY     vALIGN ="TOP" >
						<tr><td style="BACKGROUND-COLOR:#FFFFCC">
							<table>
<%
								//ArrayList fooddetails=(ArrayList)bean.getDrugFoodInteractionInfo(prodid);
								HashMap tempFoodDetails=(HashMap)drugInfos.get("DRUG_FOOD");
								ArrayList fooddetails =null;
								if(tempFoodDetails!=null && tempFoodDetails.size()>0)
									fooddetails=(ArrayList)tempFoodDetails.values();
								
								if (fooddetails!=null && fooddetails.size()>0){
%>	
<!-- <TR><Th  align="left" id="header">Food Interactions</Th></TR>	 -->
<%
									for (int i=0;i<fooddetails.size();i++){ 	
%>
										<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"><%=fooddetails.get(i)%></TD></TR>
<% 
									}
								}
								else{
%>
									<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%
								}
%>
							</TABLE>
						</TD></TR>
					</TBODY >
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblContra")){
%>
				<table id="TblContra" name="TblContra" id="TblContra" width="100%"  height="100%">
					<TBODY     vALIGN ="TOP" >
						<tr><td style="BACKGROUND-COLOR:#FFFFCC">
							<table  width="100%">
<%
							 //HashMap contra_indications=(HashMap)bean.getDrugContraIndication(prodid);
								HashMap contra_indications=(HashMap)drugInfos.get("CONT");
								if (contra_indications.size()>0) {
									ArrayList abosulete_contra = (ArrayList)contra_indications.get("ABS");
									ArrayList extreme_caution  = (ArrayList)contra_indications.get("EXT");
									ArrayList contra_warning   = (ArrayList)contra_indications.get("WAR");
%>	
<!-- <TR><Th align="left" id="header" colspan=2>Contra Indications</Th></TR> -->
<%  
									if(abosulete_contra.size()>0){
%>
										<TR><Th align="left" id="header" colspan=2 WIDTH="100%">Absolute Contraindications</Th></TR>
<%	    
										for(int i=0;i<abosulete_contra.size()-1;i+=2){
%>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><%= abosulete_contra.get(i) %>   </td><td style="BACKGROUND-COLOR:#FFFFCC"><%= abosulete_contra.get(i+1) %></TD></TR>
<%
										}
									} 
									if(extreme_caution.size()>0){
%>
										<TR><Th align="left" id="header" colspan=2 WIDTH="100%">Extreme Caution</Th></TR>
<%	    
										for(int i=0;i<extreme_caution.size()-1;i+=2){
%>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><%= extreme_caution.get(i) %>   </td><td style="BACKGROUND-COLOR:#FFFFCC"> <%= extreme_caution.get(i+1) %></TD></TR>
<%      
										}
									} 
									if(contra_warning.size()>0){
%>
										<TR><Th align="left" id="header" colspan=2 WIDTH="100%">Warning</Th></TR>
<%	    
										for(int i=0;i<contra_warning.size()-1;i+=2){
%>
											<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><%= contra_warning.get(i) %>   </td><td style="BACKGROUND-COLOR:#FFFFCC"><%= contra_warning.get(i+1) %></TD></TR>
<%      
										}
									} 
								}
								else{
%>
									<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%
								}
%>
							</TABLE>
						</TD></TR>	
					<TBODY >
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblInfo")){
%>
				<table id="TblInfo" name="TblInfo" id="TblInfo" width="100%"  height="100%">
					<TBODY     vALIGN ="TOP" >
						<tr><td style="BACKGROUND-COLOR:#FFFFCC">
							<table width="100%">
<!-- <TR><Th align="left" id="header"colspan=2>Side Effects</Th></TR> -->
<%
							//HashMap side_effects	=(HashMap)bean.getDrugSideEffects(prodid);
							HashMap side_effects	=(HashMap)drugInfos.get("SIDE");
							if (side_effects!=null && side_effects.size()>0) 	
							{
								ArrayList severe       = (ArrayList)side_effects.get("SEVE");
								ArrayList less_severe  = (ArrayList)side_effects.get("LESS_SEVE");
								if(severe.size()>0){
%>
									<TR><Th align="left" id="header" colspan=2>SEVERE</Th></TR>
<%            
									for(int i=0;i<severe.size();i+=7){
%>                
										<TR ><Td colspan=2 style="BACKGROUND-COLOR:#FFFFCC;color:red"><b><%= severe.get(i) %></b> </td></Tr>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Severity         :</b> <%= severe.get(i+1) %>  </td><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Frequency              : </b><%= severe.get(i+2) %>   </td></TR>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Lab Test         : </b><%= severe.get(i+3) %>  </td><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Visibility             : </b><%= severe.get(i+4) %>   </td></TR>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Hypersensitivity :</b> <%= severe.get(i+5) %>  </td><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Physician Intervention : </b><%= severe.get(i+6) %>   </td></TR>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC" colspan=2><hr></hr>  </td></TR>
<%  
									}
								}
								if(less_severe!= null && less_severe.size()>0){
%>
									<TR><Th align="left" id="header" colspan=2>LESS SEVERE</Th></TR>
<%            
									for(int i=0;i<less_severe.size();i+=7){
%>
										<TR ><Td style="BACKGROUND-COLOR:#FFFFCC;color:red" colspan=2><b><%= less_severe.get(i) %></b> </td></Tr>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Severity         : </b><%= less_severe.get(i+1) %>  </td><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Frequency              :</b> <%= less_severe.get(i+2) %>   </td></TR>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Lab Test         : </b><%= less_severe.get(i+3) %>  </td><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Visibility             : </b><%= less_severe.get(i+4) %>   </td></TR>
										<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Hypersensitivity : </b><%= less_severe.get(i+5) %>  </td><TD style="BACKGROUND-COLOR:#FFFFCC"><b> Physician Intervention : </b><%= less_severe.get(i+6) %>   </td></TR>
										<TR ><TD  style="BACKGROUND-COLOR:#FFFFCC"colspan=2><hr></hr>  </td></TR>
<%            
										}
									}
								}
								else{
%>
									<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%  
								}
%>
							</TABLE>
						</TD></TR>	
					</TBODY >
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblOverDose")){
%>
				<table id="TblCounsel" name="TblOverDose" id="TblOverDose" width="100%"  height="100%">
					<TBODY     vALIGN ="TOP" >

<!-- <TR><Th align="left" id="header">Over Dose</Th></TR> -->
<% 
					//String  over_dose_war=(String)bean.getDrugOverDoseMsg(prodid);
					String  over_dose_war=(String)drugInfos.get("OVER");
					if(over_dose_war!=null && !over_dose_war.equals("")){
%>
						<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><%= over_dose_war %> </td></tr>
<%
					}
					else{
%>
						<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%
					}
%>
					</TBODY>			
				</table>
<%
			}
			else if(tabname.equalsIgnoreCase("TblCounsel")){
%>
				<table id="TblCounsel" name="TblCounsel" id="TblCounsel" width="100%"  >
					<TBODY   vALIGN ="TOP" >
				<!-- <TR><Th align="left" id="header">Patient Education</Th></TR> -->
<% 
						//String  pat_edu_info=(String)bean.getPatientEducationInfo(prodid);
						String  pat_edu_info=(String)drugInfos.get("PAT_EDU");
						if(pat_edu_info!=null && !pat_edu_info.equals("")){
%>
							<TR ><TD style="BACKGROUND-COLOR:#FFFFCC"><%= pat_edu_info %> </td></tr>
<%
						}
						else{
%>
							<TR><TD style="color:red"> No Relevant Information found</TD></TR>
<%
						}
%>
						</TBODY>			
					</table>
<%
				}
%>
				<script>showAllFirstTime()</script>
<%
				putObjectInBean(bean_id,bean,request);
			}
			else{
				out.println("The External Database cannot be accessed!!!");
			}

		}
		catch (Exception e)	{
			out.println("The External Database cannot be accessed!!!");
			e.printStackTrace();
		}
%>
	</body>
</html>


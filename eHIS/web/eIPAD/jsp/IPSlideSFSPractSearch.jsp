<!DOCTYPE html>
<%@page import="eIPAD.HealthObjects.InPatientContext"%> 
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.HealthObjects.*,eIPAD.sfs.*," contentType="text/html;charset=UTF-8" %>
<%@page
	import="java.util.*,java.sql.*,java.io.*,eIPAD.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
	request.setCharacterEncoding("UTF-8");
	InPatientContext objInPatientContext = new InPatientContext();
	objInPatientContext.setRequest(request);
	
	String locale = "en";
	String facilityId = "";
	String fSpecialityId = "";
	String fSpecialityName = "";
	String fNursingUnitId = "";
	String fNursingUnitName = "";
	String fPractitionerId = "";
	String fPractitionerName = ""; 
	String fSfsContext = "";
	String practSearchText = "";
	String noResultsStyle = "display:none;";
%>





<script type="text/javascript">

</script>

								<%
									SFSContext oSFSContext = new SFSContext();
									String sfacility_id = "";
									String sclinicianId = "";
									String sPractionerId = "";
									String selectedPractID = "";
									String specCode= "";
									String practCode = "";
									String nursingCode= "";
									String clinicianId = "";
									oSFSContext.setRequest(request);
									if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
									{
										sfacility_id = (String)session.getValue("facility_id");
										oSFSContext.setSfacility_id(sfacility_id);
									}
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setSclinicianId(sclinicianId);
									}
									/* if(request.getParameter("hdnPractitionerId") != null && request.getParameter("hdnPractitionerId") != "")
									{
										sPractionerId = (String)request.getParameter("hdnPractitionerId");
										oSFSContext.setsPractionerId(sPractionerId);
									} */
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")	
									{
										sclinicianId = (String)session.getValue("ca_practitioner_id");
										oSFSContext.setsPractionerId(sclinicianId); //for Nursing Unit search alone always the practitioner ID is the login practitioner
									}
									if(request.getParameter("selectedPractID") != null){
										
										selectedPractID = (String)request.getParameter("selectedPractID");
										oSFSContext.setsPractionerId(selectedPractID);
									}
									
									if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
									{
										clinicianId = (String)session.getValue("ca_practitioner_id");
										objInPatientContext.setClinicianId(clinicianId);
									}
									
									if(request.getParameter("practSearchText") != null){
										
										practSearchText = (String)request.getParameter("practSearchText");
										oSFSContext.setsSearchText(practSearchText);
									}
									
									
										
												
									   int nRowCount = 1;		       			    
									   int nLoopCount = 0;
									   
									   int nListSizePR = 0;
									 
									   SFSDetails bean = new SFSDetails();
									   List<SFSUnit> objSfsDetailsPR = new ArrayList<SFSUnit>();
									   
									   int sfsContextTypePR = 4;
									%>
										
										<!-- PR Content starts here-->
											
											<%
											
												oSFSContext.setType(sfsContextTypePR);  
												objSfsDetailsPR = bean.getSFSUnit(oSFSContext); 
							   					nListSizePR =  objSfsDetailsPR.size();
							   					SFSUnit sfsUnitPR = null;
							   					
							   						
											 %>
											
										<%
						   						
						   						if(nListSizePR >0 ){
										%>
											
																
																		   <div class="table" id="listPR" style="width:100%; height:100%;">
																 	 		<%
																 	  		for(nLoopCount = 0 ; nLoopCount < nListSizePR; nLoopCount++)
																 	  			{
																 		 		sfsUnitPR = objSfsDetailsPR.get(nLoopCount);
																 		  		if(sfsUnitPR != null )
																		  			{
																 					 practCode = sfsUnitPR.getsCode();
															 		 		%>
																					<div class="row listItemPR listItemPR<%=practCode%>"  data-pract="<%=practCode%>" id="listItemPR<%=practCode%>" style="width:100%; height:45px;" onclick="selectedPract('<%=practCode%>','<%=sfsUnitPR.getsDescription()%>','SlectedPract')" data-practcode="<%=practCode%>" data-practdesc="<%=sfsUnitPR.getsDescription()%>">
																						<!-- border-bottom: 1px solid #f6f6f6; -->
																						<div class= "cell slSfsViewItemTextPract slSfsViewItemTextPractTheme" id="textPR<%=practCode%>"><%=sfsUnitPR.getsDescription()%><br>
																						<span class="slSfsViewItemTextSmall slSfsViewItemTextSmallTheme"><%=sfsUnitPR.getsCode()%></span>
																						</div>
																						<div class="cell SLSfsListTickPractTheme"><div class="slSfsTickVisiblePR SLSfsCircleVisibleTheme" id="slSfsTickPR<%=practCode%>" style="display:none;"></div></div>
																					</div>
																					
																	 		<%
																  					}
																  					nRowCount = nRowCount + 1;
																				} 
																 	 		%>
																			</div>
																	
											  			
								
											
											<%
											
											}else{
											
												noResultsStyle = "display:block;";
											
											} %>
											
											<div class="table" id="listPR_NoResults" style=" height:100%;padding-left:10px;<%=noResultsStyle%>">
												<div class="row">
													<span class="slSfsViewItemTextSmall slSfsViewItemTextSmallTheme">No matches</span>
												</div> 
											</div>
										<!-- PR Content ends here-->
										
								
		
	


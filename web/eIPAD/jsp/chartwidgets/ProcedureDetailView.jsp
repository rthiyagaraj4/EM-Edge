<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="eIPAD.chartsummary.proceduredetails.response.*" %>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ page import="eIPAD.chartsummary.proceduredetails.healthobject.*"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

int nListSize = 0; 
ProcedureDetailsResponse oProcRes = null;
List<ProcedureDetailsHO> lstProcedureDetails = null;
if(request.getAttribute("ProcedureDetailsResponse") != null)
{
	oProcRes = (ProcedureDetailsResponse)request.getAttribute("ProcedureDetailsResponse");
	lstProcedureDetails = oProcRes.getLstProcedureDetails();
	if(lstProcedureDetails != null)
	{
		nListSize = lstProcedureDetails.size();
	}
}
%>
<style>

</style>
	<div class="procWidgetParent widgetParentTheme" data-role = "none">
		<div class="widgetTable" data-role = "none">
			<div class="widgetHeaderRow widgetHeaderRowTheme" data-role = "none">
				<div class="widgetHeaderMarginCell" data-role = "none">
					<div class="widgetHeaderMarginExtn widgetHeaderMarginExtnTheme" data-role = "none"></div>
					<div class="widgetHeaderIcontriangle" data-role = "none"></div>
				</div>
				<div class="widgetHeaderCell widgetHeaderCellTheme" data-role = "none">
					<div class="widgetHeaderSubTable" data-role = "none">
						<div class="widgetHeaderSubRow" data-role = "none">
							<div class="widgetHeaderIconCol1" data-role = "none">
								<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme"  data-role = "none"><img src= "${path}/eIPAD/images/CS_Procedures_Details.PNG" class="widgetHeaderButtonImage" ></div>
							</div>
<!-- 							<div class="widgetHeaderIconCol2"  data-role = "none">
								<div class="widgetHeaderArrowRightTheme" data-role = "none"></div>
							</div> -->
							<div class="widgetHeaderHeadingTextCol" data-role = "none"><span class="widgetHeaderHeadingTextTheme" data-role = "none">Procedure Details</span> <input type="button" class="widgetHeaderCountButtonTheme" id="procedureDetailsViewCount" value="<%=nListSize%>"></div>
							<div class="widgetHeaderPlusButtonCell" data-role = "none">
								<div class="WidgetButtonTheme" data-role = "none" ><img src="${path}/eIPAD/images/CS_add16x16.png"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="widgetTable" data-role = "none">	
			<!-- content starts here -->
			<div class="procWidgetContentRow" data-role = "none">
			  	<div class="widgetHeaderMarginCell" data-role = "none">
				</div>
				<div class="widgetContentCell widgetContentCellTheme" data-role = "none">
					
					 <%
					    int nLoopCount = 0;
					    
					    ProcedureDetailsHO oProcHO = null;
					  	if(oProcRes != null && oProcRes.isSuccessResponse() && !oProcRes.isEmptyDataResponse())
					  	{
					  		
					  		 if(nListSize > 0)
					  		 {
					  			 for(nLoopCount = 0; nLoopCount < nListSize;nLoopCount ++)
					  			 {
					  				oProcHO = lstProcedureDetails.get(nLoopCount);
					  				if(oProcHO != null)
					  				{
					  					%>
					  				<div class="AllergyContentTable WidgetContentStripTheme"  data-role = "none"> <!--  content table starts -->
					  					<div class="ProcContentRow" data-role = "none"> <!-- content row starts -->
											<div class = "procContentCell" data-role = "none"><!-- contentCell starts here -->
												<div class = "procItemTable" data-role = "none">
													<div class = "procItemRow1" data-role = "none">
														<div class = "procItemCell1" data-role = "none">
															<div class = "procDesc" data-role = "none">
															<%=oProcHO.getProcedureDescription() %>	<div class="SfsHeaderButtonTheme procMButton" data-role = "none">Modify</div>
															</div>
														</div>
													</div>
													<div class = "procItemRow2" data-role = "none">
														<div class = "procItemCell2" data-role = "none">
															<div class = "procDateTable" data-role = "none">
																<div class = "procDateRow" data-role = "none">
																	<div class = "procDateCell1" data-role = "none">
																		   <div class = "dvProcCode" data-role = "none">
											                                	<span class = "spanProcCode" data-role = "none"><%=oProcHO.getProcedureCode()%></span> <span class = "spanName" data-role = "none">by <%=oProcHO.getPractitionerName() %></span>
											                              </div>
																	</div>
																		<div class = "procDateCell2" data-role = "none">
																			<div class="procWidgetDateTextTheme"  data-role = "none">
																			<%
																				if(oProcHO.getStatus() != null && oProcHO.getStatus().equalsIgnoreCase("Modified")) 
																				{
																			 %>
																				 <div class = "editProc" data-role = "none"></div>	
																			<%
																				}
																			 %> 
																				 <div data-role = "none" class = "spanProcDate" ><span ><%=oProcHO.getProcedureDateTime() %></span></div>
																			</div>					
																	   </div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div><!-- contentCell ends here -->	
										</div><!-- content row ends -->
									</div><!--  content table ends -->
					  					<% 
					  				}
					  			 }
					  		 }
					  		 
					  	}
					  	else
					  	{
					  		%>
					  		
					 <div class="WidgetVwErrContainer">
						<div class="WidgetErrorResponse WidgetErrorResponseTheme"><%=oProcRes.getErrorsList().get(0).getErrorMessage() %></div>
					</div>

					  		<% 
					  	}
					  		
					  	%>
							
				
					
				</div>
			</div>
			<!-- content ends here -->
		</div><!-- widget table ends  -->
	</div>


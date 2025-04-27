<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.vitals.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.healthobject.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
Locale appLocale;
if (session.getAttribute("LOCALE") != null
		&& !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle(
		"eIPAD.chartsummary.common.resourcebundle.cslabels",
		appLocale);
VitalsConfigResponse oVitalsConfigResponse = null;
CurrentAndHistoryResponse oCurrentAndHistoryResponse = null;
if(request.getAttribute("VitalsConfigResponse") != null)
{
	oVitalsConfigResponse = (VitalsConfigResponse)request.getAttribute("VitalsConfigResponse");
	
}
if(request.getAttribute("CurrentAndHistoryResponse") != null)
{
	oCurrentAndHistoryResponse = (CurrentAndHistoryResponse)request.getAttribute("CurrentAndHistoryResponse");
}
int nVitalsConfigList = 0;
List<VitalsConfig> listVitalConfig = null;
int nVitalsConfigLoopCount = 0;
DateContainer oDateContainer = null;
if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse())
{
	   if(oVitalsConfigResponse.getListVitalConfig() != null)
	   {
		   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
		   if(oVitalsConfigResponse.getListVitalConfig() != null)
		   		nVitalsConfigList = listVitalConfig.size();
	   }
}
if(nVitalsConfigList > 0)
{
%>
<div data-role = "none" class = "dvResultsTable">
				   		<div data-role = "none" class = "dvReslutsRow1">
				   			<div data-role = "none" class = "dvResultsCol1">
				   				<div data-role = "none" class = "dvVitalsResultHeader dvVitalsResultHeaderTheme dvResultsHeaderBorder">
				   					<div data-role = "none" style = "position:relative;width:100%;height:100%">
				   						<div data-role = "none" class = "dvHeaderFont">Vitals</div>
				   					</div>
				   				</div>
				   				<!-- discree measure starts for loop usin the configuration-->
				   				  <!--  
				   					<div data-role = "none" class = "dvVitals dvVitalsTheme">
				   						<div data-role = "none" class = "dvMeasureContainer">
				   							<div data-role = "none" class = "dvMeasureFont">Systolic BP</div>
				   						</div>
				   						<div data-role = "none" class = "dvMeasureUnits">
				   							<div data-role = "none" class = "dvUnitsFont"> Deg C</div>
				   						</div>
				   					</div>
				   					-->
				   					<%
				   					   
				   					   for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
				   					   {
				   						String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
				   						String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
				   						String UOM = listVitalConfig.get(nVitalsConfigLoopCount).getUnits();
				   							%>
				   								<div data-role = "none" class = "dvVitals dvVitalsTheme">
							   						<div data-role = "none" class = "dvMeasureContainer">
							   							<div data-role = "none" class = "dvMeasureFont"><%=DiscreteMeasureDescription %></div>
							   						</div>
							   						<div data-role = "none" class = "dvMeasureUnits">
							   							<div data-role = "none" class = "dvUnitsFont"> <%=UOM%></div>
							   						</div>
							   					</div>
				   							<% 
				   							
				   					   }
				   					nVitalsConfigLoopCount = 0;
				   					%>
				   					
				   					
				   					<!-- 7 row end -->
				   				<!--  For loop ends discree measure ends -->
				   				
				   			</div><!-- col1 ends -->
				   			<div data-role = "none" class = "dvResultsCol2" id = "dvResultsCol2">
				   				<div data-role = "none" class = "vitalsSwipeWrapper" id = "vitalsSwipeWrapper">
				   					<div data-role = "none" class = "vitalsScroller" id = "vitalsScroller">
				   					<!-- check if dates are present -->
				   					
				   						<div data-role = "none" class = "dvResultsHeaderTable dvVitalsResultHeaderTheme dvResultsValueBorder">
				   							<div data-role = "none" class = "dvResultsHeaderRow">
				   								<div data-role = "none" class = "dvResultsHeaderCol">
				   								
				   								    <!-- for loop for dates -->
				   								 
				   									<%
				   										if(oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
				   										{
				   											String dateFormat = "dd/MM/yyyy HH:mm";
				   											oDateContainer = oCurrentAndHistoryResponse.getDateContainer();
				   											if(oDateContainer != null && oDateContainer.getDateList() != null && oDateContainer.getDateList().size() > 0)
				   											{
				   												List<Date> dateList = oDateContainer.getDateList();
				   												for(Date oDate : dateList)
				   												{
				   													String strDate = oCurrentAndHistoryResponse.formatDate(oDate, dateFormat);
				   													%>
				   														<div data-role = "none" class = "dvHeaderDate">
									   										<div data-role = "none" class = "dvDateFont"><%= strDate%></div>
									   									</div>
				   													<% 
				   												}
				   											}
				   										}//if
				   									%>
				   									
				   									<!-- end  loop for dates -->
				   								</div>
				   								
				   							</div>
				   						</div>
				   						
				   						
				   						
				   						<%
				   						for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
				   						{
				   							String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
					   						String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
					   						CurrentAndHistoryDM oCurrentAndHistoryDM = null;
					   						CurrentAndHistoryDM objcurrentHistoryDM = null;
					   						if(oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
					   						{
					   							oCurrentAndHistoryDM = oCurrentAndHistoryResponse.getDiscreteMeasure(eventCode);
					   						}
					   						%>
					   						<div data-role = "none" class = "dvResultsValueTable dvVitalsTheme1 dvVitalsBorderTheme">
					   							<div data-role = "none" class = "dvResultsValueRow">
					   								<div data-role = "none" class = "dvResultsValueCol">
					   										
					   								<%
					   										if(oCurrentAndHistoryDM != null)
					   										{
					   											objcurrentHistoryDM = oCurrentAndHistoryResponse.getDiscreteValueForAllDates(oCurrentAndHistoryDM ,oDateContainer);
					   											if(objcurrentHistoryDM != null && objcurrentHistoryDM.getDiscreteValuesList() != null && objcurrentHistoryDM.getDiscreteValuesList().size() > 0)
					   											{
					   												int nListSize = objcurrentHistoryDM.getDiscreteValuesList().size();
					   												int loopCount = 0;
					   												for(loopCount = 0;loopCount < nListSize;loopCount++)
					   												{
					   													DiscreteValue oCurrentDiscreteValue = objcurrentHistoryDM.getDiscreteValuesList().get(loopCount);
					   													%>
					   													  <div data-role = "none" class = "dvValueContainer">
									   										<%
									   											if(oCurrentDiscreteValue != null)
									   											{
									   												NormalcyIndicator oNormalcyIndicator = objcurrentHistoryDM.getNormalcyIndicator(oCurrentDiscreteValue, "S");
																					String iConName = oNormalcyIndicator.getSymbolIndicator();
																					if(iConName != null && !iConName.equals(""))
																					{
																						iConName = "S" + iConName;
																					}
																					String resultNum = "";
																					if(oCurrentDiscreteValue.getResultNum() != null && oCurrentDiscreteValue.getResultString() != null)
																		    		{
																		    			resultNum  = oCurrentDiscreteValue.getResultNum().trim() + oCurrentDiscreteValue.getResultString().trim();
																		    			
																		    		}
																					
																					if(resultNum != null && resultNum.length() > 19)
																			    	{
																			    		resultNum = resultNum.substring(0, 17) ;
																			    	}
																					
																					%>
																					<div data-role = "none" class = "dvVitalsIconContainer" style = "overflow:hidden">
											   											<img src = "${path}/eIPAD/images/<%=iConName%>" style = "position:relative;margin-top :18px"></img>
											   										</div>
											   										<div data-role = "none" class = "dvVitalsValue" style = "overflow:hidden"><%=resultNum %></div>
																					<% 
																					
									   											}
									   										%>
									   									  </div>
					   													<% 
					   												}
					   											}
					   										}//else no rec found
					   										
					   								%>    
					   								
					   								</div>
					   							</div>
					   						</div>	
					   						<% 
					   						
				   						}
				   						%>
				   										   						
				   				                <!-- discree value ends -->
				   					</div><!-- scroller -->
				   				</div><!-- wrapper -->
				   			</div><!-- col2 ends -->
				   		</div>
				   	</div>
				   	<%
}
				   	%>

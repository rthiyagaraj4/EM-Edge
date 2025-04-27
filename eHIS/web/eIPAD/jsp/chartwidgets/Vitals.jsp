<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.response.*"%>
<%@page import="eIPAD.chartsummary.vitals.healthobject.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value= "${pageContext.request.contextPath}" />
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

%>
<style>
#PageLoadingAnimation{
	z-index: 10000;
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	background-color: #808080;
	opacity: 0.6;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
	display: none; 
}

</style>
<script>
var vitalsScroll;
var currentVitalsScrollingId = "";
function assignVitalsScroll()
{
	/*
	setTimeout(function () {
		vitalsScroll = new iScroll(vitalsScroller, {
			hScrollbar : false
	});
	},100);
	*/
  
	$('.vitalsSwipeWrapper').bind('touchstart click', function(event) {
		 /*
			vitalsScroll = new iScroll('vitalsSwipeWrapper',  {
				hScrollbar : false
		});
		 */
		var vitalsId = "vitalsSwipeWrapper";
		if(currentVitalsScrollingId != null )
		{
			if(vitalsId != currentVitalsScrollingId)	
			{
				vitalsScroll = new iScroll(vitalsId, {
					hScrollbar : false
				});	
				currentVitalsScrollingId = vitalsId;
			}
		}
		else
		{
			vitalsScroll = new iScroll(vitalsId, {
				hScrollbar : false
			});	
		}
	});
}
$(document).ready(function() {
	assignVitalsWrapperWidth();
	assignVitalsScrollerWidth();
	assignVitalsScroll();
	
});
function showChartsView()
{
	$("#PageLoadingAnimation").show();
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/LatestVitals?isRankRequired=N&fromScreen=CLV';
}
function showChartsTabularView()
{
	$("#PageLoadingAnimation").show();
	//window.parent.document.getElementById('ChartSummaryIframe').src =  '${path}/eIPAD/jsp/chartwidgets/VitalsTabularView.jsp';
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/LatestVitals?isRankRequired=N&fromScreen=TV';
}
function showRecordVitals()
{
	$("#PageLoadingAnimation").show();
	window.parent.document.getElementById('ChartSummaryIframe').src = '${path}/mobile/RecordVitalsView';
}
</script>
<div id="PageLoadingAnimation" > </div>
<div class="procWidgetParent widgetParentTheme" data-role="none">
	<div class="widgetTable" data-role="none">
		<div class="widgetHeaderRow widgetHeaderRowTheme" data-role="none"><!-- header row -->
			<div class="widgetHeaderMarginCell" data-role="none">
				<div class="widgetHeaderMarginExtn widgetHeaderMarginExtnTheme" data-role="none"></div>
				<div class="widgetHeaderIcontriangle" data-role="none"></div>
			</div>
			<div class="widgetHeaderCell widgetHeaderCellTheme" data-role="none">
				<div class="widgetHeaderSubTable" data-role="none">
					<div class="widgetHeaderSubRow" data-role="none">
						<div class="widgetHeaderIconCol1" data-role="none">
							<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme" data-role="none">
								<img src="${path}/eIPAD/images/CS_Latest_Vitals_32x32.PNG" class="widgetHeaderButtonImage"></img>
							</div>
						</div>

						<div class="widgetHeaderHeadingTextCol" data-role="none">
							<span class="widgetHeaderHeadingTextTheme" data-role="none">Latest Vitals</span> 
						</div>
						<div class="notesFilterCol" data-role="none" style = "right:0px">
						  <!--  
							<table style="height: 100%; width: 100%" cellpadding="0" cellspacing="0" border="0">
								<tr style="height: 100%; width: 100%">
									<td style="width: 50%" align="right" valign="center" onclick = "showChartsTabularView()">
										<div data-role="none" class="notesFilterContainer">
										 
										</div>
									</td>
									<td style="width: 50%" align="right" valign="center" onclick = "showChartsView()">
										<div data-role="none" class="notesFilterContainer">
										 
										</div>
									</td>
								</tr>
							</table>
						-->
							<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  				<tr style = "height:100%;width:100%">
							    <td style = "width:10%">
							        
							    </td>
							    <td></td>
							    <td style = "width:50%" align = "right" valign = "center">
							    	<table class= "ipContentHolderIconContainer WidgetFilterContTheme" cellpadding = "0" cellspacing = "0" border = "0">
									    <tr>
											<td class = "WidgetFilterButtonTheme"  id="orderByNone" onclick = "showChartsTabularView()" ><img src = "${path}/eIPAD/images/thumbb.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme"  id="orderByBedNum" onclick = "showChartsView()" ><img src = "${path}/eIPAD/images/Chart11.png" style="vertical-align: middle;"/></td>
								        	<td class = "WidgetFilterButtonTheme"   onclick = "showRecordVitals()" ><img src = "${path}/eIPAD/images/CS_add16x16.png" style="vertical-align: middle;"/></td>
								        </tr>
						        	</table>	
						    	</td>
			 				</tr>
		    			</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="widgetContentRow" data-role="none"><!-- content row starts -->
			<div class="widgetHeaderMarginCell" data-role="none"></div>
			<div class="widgetContentCell widgetContentCellTheme" data-role="none">
			<%
			  // if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse() && oCurrentAndHistoryResponse != null && oCurrentAndHistoryResponse.isSuccessResponse() && !oCurrentAndHistoryResponse.isEmptyDataResponse())
			   if(oVitalsConfigResponse != null && oVitalsConfigResponse.isSuccessResponse() && !oVitalsConfigResponse.isEmptyDataResponse() && oCurrentAndHistoryResponse != null )  
			   {
				   int nVitalsConfigList = 0;
				   List<VitalsConfig> listVitalConfig = null;
				   if(oVitalsConfigResponse.getListVitalConfig() != null)
				   {
					   listVitalConfig = oVitalsConfigResponse.getListVitalConfig();
					   if(oVitalsConfigResponse.getListVitalConfig() != null)
					   		nVitalsConfigList = listVitalConfig.size();
				   }
				   
			%>
				<div class="AllergyContentTable WidgetContentStripTheme" data-role="none" id = "vitalsTable"><!-- content strip starts -->
					<div class="AllergyContentRow AllergyContentRowTheme" data-role="none" >
						<div data-role = "none" class = "swipeContentCell" id = "swipeContentCell">
							<div data-role = "none" class = "vitalsSwipeWrapper" id = "vitalsSwipeWrapper" >
								<div data-role = "none" class = "vitalsScroller" id = "vitalsScroller">
								<%
									if(nVitalsConfigList > 0)
									{
										int nVitalsConfigLoopCount = 0;
										for(nVitalsConfigLoopCount = 0; nVitalsConfigLoopCount < nVitalsConfigList; nVitalsConfigLoopCount++)
										{
											String eventCode = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureId();
											String DiscreteMeasureDescription = listVitalConfig.get(nVitalsConfigLoopCount).getDiscreteMeasureDesc();
											CurrentAndHistoryDM oCurrentAndHistoryDM = oCurrentAndHistoryResponse.getDiscreteMeasure(eventCode);
											if( DiscreteMeasureDescription != null &&  DiscreteMeasureDescription.length() > 11)
											{
												 DiscreteMeasureDescription =  DiscreteMeasureDescription.substring(0, 8) + "...";
											}
											if(oCurrentAndHistoryDM != null && oCurrentAndHistoryDM.getCurrentDiscreteValue() != null)
											{
												DiscreteValue oCurrentDiscreteValue = oCurrentAndHistoryDM.getCurrentDiscreteValue();
												String eventDescription = oCurrentAndHistoryDM.getEventDescription();
												if(eventDescription != null && eventDescription.length() > 11)
												{
													eventDescription = eventDescription.substring(0, 8) + "...";
												}
												NormalcyIndicator oNormalcyIndicator = oCurrentAndHistoryDM.getNormalcyIndicator(oCurrentDiscreteValue, "S");
												String iConName = oNormalcyIndicator.getSymbolIndicator();
												if(iConName != null && !iConName.equals(""))
												{
													iConName = "B" + iConName;
												}
												else
												{
													//iConName = "BNodata.PNG";
												}
												//List<DiscreteValue> lstHistoryValues = oCurrentAndHistoryDM.getLstHistoryValues();
												List<DiscreteValue> lstHistoryValues = oCurrentAndHistoryResponse.getHistoryValues(oCurrentAndHistoryDM);
												int nHistorycount = 0;
												if(lstHistoryValues != null)
												{
													 nHistorycount = lstHistoryValues.size();
													
												}
												String resultValue = "";//oCurrentDiscreteValue.getResultNum();
												if(oCurrentDiscreteValue.getResultNum() != null && oCurrentDiscreteValue.getResultString() != null)
												{
													resultValue = oCurrentDiscreteValue.getResultNum().trim() + oCurrentDiscreteValue.getResultString().trim();
													
												}
												if(resultValue == null || resultValue.equals(""))
												{
													resultValue = "-----";
												}
												
								%>
											<div data-role = "none" class = "vitalWidgetContainer vitalWidgetContainerTheme" onclick = "showRecordVitals()"><!-- vitals Container starts -->
												<div data-role = "none" class = "vitalsHeader vitalsHeaderTheme"><%=eventDescription %></div>
												<div data-role = "none" class = "vitalsResultsContainer" onclick = "showRecordVitals()">
													<div data-role = "none" class = "vitalsIcon">
													    <%
													    if(iConName != null && !iConName.equals(""))
													    {
													    %>
															<img src = "${path}/eIPAD/images/<%=iConName %>" style = "position:relative;margin-top:1px"></img>
														<%
													    }
														%>
													</div>
													<div data-role = "none" class = "vitalsValue vitalsValueTheme" style = "overflow:hidden"><%=resultValue%></div>
													<div data-role = "none" class = "vitalsUnit vitalsUnitTheme"><%=oCurrentAndHistoryDM.getUOM() %></div>
													<div data-role = "none" class = "vitalsDate vitalsDateTheme"><%=oCurrentDiscreteValue.getEventDateTime()%></div>
													
												</div>
												<div data-role = "none" class = "vitalsBottom vitalsBottomTheme">
													<div data-role = "none" class = "vitalsBottomCol">
													  <%
													    if( nHistorycount > 0)
													    {
													    	DiscreteValue oHistoryDiscreteValue = lstHistoryValues.get(0);
													    	String resultNum = "";
													    	if(oHistoryDiscreteValue != null)
													    	{
													    		//resultNum = oHistoryDiscreteValue.getResultNum();
													    		if(oHistoryDiscreteValue.getResultNum() != null && oHistoryDiscreteValue.getResultString() != null)
													    		{
													    			resultNum  = oHistoryDiscreteValue.getResultNum().trim() + oHistoryDiscreteValue.getResultString().trim();
													    		}
													    	}
													    	if(resultNum != null && resultNum.length() > 5)
													    	{
													    		resultNum = resultNum.substring(0, 3) + "..";
													    	}
													    	NormalcyIndicator oHistoryNormalcyIndicator1 = oCurrentAndHistoryDM.getNormalcyIndicator(oHistoryDiscreteValue, "S");
													    	String  iConName1 = oHistoryNormalcyIndicator1.getSymbolIndicator();
															if(iConName1 != null && !iConName1.equals(""))
															{
																iConName1 = "S" + iConName1;
															}
															else
															{
																//iConName1 = "NoData24x24.png";
															}
													  %>
														<div data-role = "none" class = "vitalsHistoryIcon">
														   <%
														   if(iConName1 != null && !iConName1.equals(""))
														   {
														   %>
															<img src = "${path}/eIPAD/images/<%=iConName1%>" style = "position:relative;margin-top :8px"></img>
															<%
														   }
															%>
														</div>
														<div data-role = "none" class = "vitalsHistoryValue vitalsHistoryValueTheme">
															<%=resultNum %>
														</div>
														<%
													    }
													    else
													    {
													    	String dummyValue = "-----";
													    	%>
													    <div data-role = "none" class = "vitalsHistoryIcon">
															<img src = "${path}/eIPAD/images/SNoData.PNG" style = "position:relative;margin-top :8px;margin-left:-2px"></img>
														</div>
														<div data-role = "none" class = "vitalsHistoryValue vitalsHistoryValueTheme">
															<%=dummyValue %>
														</div>
													    	<% 
													    }
														%>
														
													</div>
													
													<div data-role = "none" class = "vitalsArrowContainer">
														<div data-role = "none" class = "Vitals-Arrow"></div>
													</div>
													
													<div data-role = "none" class = "vitalsBottomCol">
														 <%
													    if( nHistorycount > 1)
													    {
													    	DiscreteValue oHistoryDiscreteValue = lstHistoryValues.get(1);
													    	String resultNum = "";
													    	if(oHistoryDiscreteValue != null)
													    	{
													    		//resultNum = oHistoryDiscreteValue.getResultNum();
													    		if(oHistoryDiscreteValue.getResultNum() != null && oHistoryDiscreteValue.getResultString() != null)
													    		{
													    			resultNum  = oHistoryDiscreteValue.getResultNum().trim() + oHistoryDiscreteValue.getResultString().trim();
													    		}
													    	}
													    	if(resultNum != null && resultNum.length() > 5)
													    	{
													    		resultNum = resultNum.substring(0, 3) + "..";
													    	}
													    	NormalcyIndicator oHistoryNormalcyIndicator1 = oCurrentAndHistoryDM.getNormalcyIndicator(oHistoryDiscreteValue, "S");
													    	String iConName1 = oHistoryNormalcyIndicator1.getSymbolIndicator();
															if(iConName1 != null && !iConName1.equals(""))
															{
																iConName1 = "S" + iConName1;
															}
															else
															{
																//iConName1 = "NoData24x24.png";
															}
													  %>
														<div data-role = "none" class = "vitalsHistoryIcon">
														   <%
														   if(iConName1 != null && !iConName1.equals(""))
														   {
														   %>
															<img src = "${path}/eIPAD/images/<%=iConName1%>" style = "position:relative;margin-top :8px"></img>
															<%
														   }
															%>
														</div>
														<div data-role = "none" class = "vitalsHistoryValue vitalsHistoryValueTheme">
															<%=resultNum %>
														</div>
														<%
													    }
													    else
													    {
													    	String dummyValue = "-----";
													    	%>
													    <div data-role = "none" class = "vitalsHistoryIcon">
															<img src = "${path}/eIPAD/images/SNoData.PNG" style = "position:relative;margin-top :8px;margin-left:-2px"></img>
														</div>
														<div data-role = "none" class = "vitalsHistoryValue vitalsHistoryValueTheme">
															<%=dummyValue %>
														</div>
													    	<% 
													    }
														%>
													</div>
													
													<div data-role = "none" class = "vitalsArrowContainer">
														<div data-role = "none" class = "Vitals-Arrow"></div>
													</div>
													
													<div data-role = "none" class = "vitalsBottomCol">
														 <%
													    if( nHistorycount > 2)
													    {
													    	DiscreteValue oHistoryDiscreteValue = lstHistoryValues.get(2);
													    	String resultNum = "";
													    	if(oHistoryDiscreteValue != null)
													    	{
													    		//resultNum = oHistoryDiscreteValue.getResultNum();
													    		if(oHistoryDiscreteValue.getResultNum() != null && oHistoryDiscreteValue.getResultString() != null)
													    		{
													    			resultNum  = oHistoryDiscreteValue.getResultNum().trim() + oHistoryDiscreteValue.getResultString().trim();
													    		}
													    	}
													    	if(resultNum != null && resultNum.length() > 5)
													    	{
													    		resultNum = resultNum.substring(0, 3) + "..";
													    	}
													    	NormalcyIndicator oHistoryNormalcyIndicator1 = oCurrentAndHistoryDM.getNormalcyIndicator(oHistoryDiscreteValue, "S");
													    	String  iConName1 = oHistoryNormalcyIndicator1.getSymbolIndicator();
															if(iConName1 != null && !iConName1.equals(""))
															{
																iConName1 = "S" + iConName1;
															}
															else
															{
																//iConName1 = "NoData24x24.png";
															}
													  %>
														<div data-role = "none" class = "vitalsHistoryIcon">
														   <%
														   if(iConName1 != null && !iConName1.equals(""))
														   {
														   %>
															<img src = "${path}/eIPAD/images/<%=iConName1%>" style = "position:relative;margin-top :8px"></img>
															<%
														   }
															%>
														</div>
														<div data-role = "none" class = "vitalsHistoryValue vitalsHistoryValueTheme">
															<%=resultNum %>
														</div>
														<%
													    }
													    else
													    {
													    	String dummyValue = "-----";
													    	%>
													    <div data-role = "none" class = "vitalsHistoryIcon">
															<img src = "${path}/eIPAD/images/SNoData.PNG" style = "position:relative;margin-top :8px;margin-left:-2px"></img>
														</div>
														<div data-role = "none" class = "vitalsHistoryValue vitalsHistoryValueTheme">
															<%=dummyValue %>
														</div>
													    	<% 
													    }
														%>
													</div>
													
												</div>
											</div> <!-- vitals Container ends -->
									<%
											}//if
											else
											{
											  %>
											  <div data-role = "none" class = "vitalWidgetContainer vitalWidgetContainerTheme" onclick = "showRecordVitals()">
												  <div data-role = "none" class = "vitalsHeader vitalsHeaderTheme"><%=DiscreteMeasureDescription %></div>
												  <div data-role = "none" class = "vitalsResultsContainer">
												  	<div data-role = "none" class = "addVitalsIcon">
												  		<img src = "${path}/eIPAD/images/Add.PNG" style = "position:relative;margin-left:30.5px;margin-top:22.5px"></img>
												  	</div>
												  </div>
												  <div data-role = "none" class = "vitalsBottom vitalsBottomTheme"></div>
											  </div>
											  <% 	
											}
										}//for
									}
									%>
									
																
									
																
								</div><!-- scroller -->
							</div>
						</div>
					</div>
				</div><!-- content strip ends -->
				<%
			   }//if
			   else
			   {
				   String message = "";
				   StringBuffer strMessage = new StringBuffer("");
				   if(oVitalsConfigResponse != null )
				   {
					   if(oVitalsConfigResponse.getErrorsList() != null)
					   {
						   int size = oVitalsConfigResponse.getErrorsList().size();
						   if(size > 0)
						   {
							   int nErrorCount = 0;
							   for(nErrorCount = 0;nErrorCount < size; nErrorCount++)
							   {
								  // strMessage.append(oVitalsConfigResponse.getErrorsList().get(index))
								  if(oVitalsConfigResponse.getErrorsList().get(nErrorCount) != null)
								  {
									  strMessage.append(oVitalsConfigResponse.getErrorsList().get(nErrorCount).getErrorMessage());
									 // message = message + oVitalsConfigResponse.getErrorsList().get(nErrorCount).getErrorMessage();
								  }
							   }
						   }
					   }
				   }
				   if(oCurrentAndHistoryResponse != null )
				   {
					   if(oCurrentAndHistoryResponse.getErrorsList() != null)
					   {
						   int size = oCurrentAndHistoryResponse.getErrorsList().size();
						   if(size > 0)
						   {
							   strMessage.append("   ");
							   int nErrorCount = 0;
							   for(nErrorCount = 0;nErrorCount < size; nErrorCount++)
							   {
								  // strMessage.append(oVitalsConfigResponse.getErrorsList().get(index))
								  if(oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount) != null)
								  {
									 if( oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorType() != Errors.NO_CHART_CONFIGURED)
									   strMessage.append(oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorMessage());
									// message = message + oCurrentAndHistoryResponse.getErrorsList().get(nErrorCount).getErrorMessage();
								  }
							   }
						   }
					   }
				   }
				   %>
				   	<div data-role = "none" class="WidgetVwErrContainer">
				   		<div data-role = "none" class="WidgetErrorResponse WidgetErrorResponseTheme">
				   			<%=strMessage.toString() %>
				   		</div>
				   		
				   	</div>
				   <% 
			   }
				%>
				
			</div>
		</div><!-- content row ends -->
	</div>
</div>

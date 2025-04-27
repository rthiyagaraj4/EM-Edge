<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="eIPAD.chartsummary.pendingorders.healthobject.PendingOrderCountHO"%>
<%@page import="eIPAD.chartsummary.pendingorders.response.PendingOrderCountResponse"%>
<%@page import="eIPAD.chartsummary.results.request.ResultsCatConstants"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*,javax.servlet.http.HttpSession"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Locale"%>
<%@ page import="eIPAD.chartsummary.results.request.ResultsCatConstants"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);  

PendingOrderCountResponse countResponse = (PendingOrderCountResponse)request.getAttribute("CountResponse");
String firstOrderCat = "";
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(countResponse!=null){
	errorList = countResponse.getErrorsList();
}

%>
<script>
var path;
$(document).ready(function(){
	
	path = $('#hdnPath').val();
	var firstOrderCat = $('#firstOrderCat').val();
	$("#OrdersDataFrame").load( path + "/mobile/chartsummary/PendingOrdersDataView?OrderCategory="+firstOrderCat,function(){
		scrollerRefresh(CSMainScroll);
	});
});
 function openPendingOrderExpandedView(){
	$("#PageLoadingAnimation").show();
	
	window.location.replace( path + '/mobile/chartsummary/PendingOrdersAllDataView');
} 

function showResultOf(cat, widObj){
	$("#OrdersDataFrame").empty();
	$("#OrdersDataFrame").load( path + "/mobile/chartsummary/PendingOrdersAllDataView",function(){
		scrollerRefresh(CSMainScroll);
	});
	$(".widgetTab").each(function(i){
		$(this).removeClass("widgetTabActiveTheme").addClass("widgetTabNonActiveTheme").addClass("widgetTabNonActive");
		$(widObj).removeClass("widgetTabNonActiveTheme").removeClass("widgetTabNonActive").addClass("widgetTabActiveTheme");
	})
}

function openPOType(obj){
	var poType=$(obj).data("code");
	$("#OrdersDataFrame").empty();
	$("#OrdersDataFrame").load( path + "/mobile/chartsummary/PendingOrdersDataView?OrderCategory="+poType,function(){
		scrollerRefresh(CSMainScroll);
	});
	$(".widgetPOTab").each(function(i){
		$(this).removeClass("widgetTabActiveTheme").addClass("widgetTabNonActiveTheme").addClass("widgetTabNonActive");
		$(obj).removeClass("widgetTabNonActiveTheme").removeClass("widgetTabNonActive").addClass("widgetTabActiveTheme");
	})
	
}
</script>
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

<div id="PageLoadingAnimation" > </div>
	<div class="widgetParent widgetParentTheme" data-role = "none">
	<form id="POWidgetForm" class="POWidgetForm" action="" method="post" name="POWidgetForm" id="POWidgetForm"> 
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
								<div class="widgetHeaderIconButton widgetHeaderIconButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/CS_Allergies.PNG" class="widgetHeaderButtonImage"></div>
								
							</div>

							<div class="widgetHeaderHeadingTextCol" data-role = "none"><span class="widgetHeaderHeadingTextTheme" data-role = "none"><%=csResBundle.getString("pendingOrder.pendingOrders") %></span> 
							<% if(countResponse!=null && countResponse.isSuccessResponse() && !countResponse.isEmptyDataResponse()){%>
							<input type="button" class="widgetHeaderCountButtonTheme" id="pendingOrderViewCount" value="<%=countResponse.getPendingOrdersTotalCount()%>">
							<%} %>
							</div>
							<div class="widgetHeaderPlusButtonCell" data-role = "none">
								<div class="WidgetButtonTheme" data-role = "none" onclick="openPendingOrderExpandedView()"><img src="${path}/eIPAD/images/thumbb.png"></div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<div class="widgetContentRow" data-role = "none">
				<div class="widgetHeaderMarginCell" data-role = "none">
				</div>
				<div class="widgetContentCell widgetContentCellTheme" data-role = "none">
				<% if(countResponse!=null && countResponse.isSuccessResponse() && !countResponse.isEmptyDataResponse()){
					ArrayList<PendingOrderCountHO> countList = countResponse.getPendingOrderCountList();
					firstOrderCat = countList.get(0).getOrderCategoryCode();
				%>
					<div style="display:table;width:100%">
						<div style="display:table-row" class="">
							<div style="display:table-cell" class="widgetTabBckgrndTheme"><!-- Tab container -->
								<div style="text-align:center;margin-top:10px;font-size:0px">
								<%
								String tabStyle;
								for(int i=0;i<countList.size();i++) {
									if(i==0){
										tabStyle = "widgetTabActiveTheme";
									}else{
										tabStyle = "widgetTabNonActiveTheme widgetTabNonActive";
									}
										
									PendingOrderCountHO curHO = countList.get(i);
									if(curHO!=null){
								%>
									<div style="display:inline-block" class="<%=tabStyle %> widgetTab widgetPOTab" onclick="openPOType(this)" data-code="<%=curHO.getOrderCategoryCode()%>"><!-- Individual tabs -->
										<div style="display:table;height:100%;width:100%">
											<div style="display:table-row">
												<div style="display:table-cell;vertical-align:middle;text-align:center">
													<div style="margin-left:5px;margin-right:5px"><%=curHO.getOrderCategoryDesc() %>(<%=curHO.getOrderCount() %>)</div>
												</div>
											</div>
										</div>
									</div>
								<%	} 
								}%>	
								</div>
								
							</div>
						</div>
						<div style="display:table-row;width:100%;">
							<div style="display:table-cell;width:100%;"><!-- Order data frame container -->
								<div src="${path}/eIPAD/jsp/chartwidgets/PendingOrderDetails.jsp" style="border:0;height:auto;width:100%;min-height:50px;background:#ffffff" id="OrdersDataFrame"></div>
							</div>
							
						</div>
						
					</div> 
					<%} 
					else{
					%>
					<div class="WidgetVwErrContainer">
						<%
						for(int k=0;k<errorList.size();k++){
						%>
						<div class="WidgetErrorResponse WidgetErrorResponseTheme"><%= errorList.get(k).getErrorMessage()%></div>
						<%} %> 
					</div>
					<%} %>	
					</div>
				</div>
			</div>
			<input type="hidden" name="firstOrderCat" id="firstOrderCat" id="firstOrderCat" value="<%= firstOrderCat %>"
 		</form> 
	</div>
	
	


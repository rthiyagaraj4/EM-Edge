<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@page import="java.util.List"%>
<%@page import="eIPAD.chartsummary.pendingorders.healthobject.PendingOrderItems"%>
<%@page import="eIPAD.chartsummary.pendingorders.healthobject.PendingOrders"%>
<%@page import="eIPAD.chartsummary.pendingorders.response.PendingOrderResponse"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.ResourceBundle"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<%

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);
%>
<%
PendingOrderResponse ordersResp = (PendingOrderResponse)request.getAttribute("POResponse");
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(ordersResp!=null){
	errorList = ordersResp.getErrorsList();
}

%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
document.addEventListener('DOMContentLoaded', assignMainScroll, false);
var poMainScroll;
var screenOrienttation = "landscape";
var path;

function changeOrientation(orient, EMHFheight)
{
	var CSHFheight = $('#allergyHeader').height();
   	HFheight = EMHFheight;
   	screenOrienttation = orient;
   	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
   	document.getElementById("divcnt").style.height = content_height+"px";
   //	$('#header1').focus();
   	scrollRefresh();
}
function scrollRefresh()
{
 	if(poMainScroll != null)
 		poMainScroll.refresh();
}

function assignMainScroll() {
	setTimeout(function () {
		poMainScroll = new iScroll('divcnt', {
		useTransform: true,
		zoom: false,
		
		onBeforeScrollStart: function (e) {
		var target = e.target;
		while (target.nodeType != 1) target = target.parentNode;

		if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' && target.tagName != 'DIV')
		e.preventDefault();
		} 
		});
	}, 1000); 
}
function gotoCS(){
	var cspath = path + "/mobile/chartsummary/ChartWidgetsView";
	window.parent.document.getElementById('ChartSummaryIframe').src = cspath;
}

$(document).ready(function () {
	parent.setOnLoadContentPaneHeight();
	path = document.getElementById("hdnPath").value;
});
function showPOFormatPopup(obj,popupId){
	
	var popupObj = $("#"+popupId);

    
    var popupTitle = $(obj).data("title");
    //alert(encodeURI($(obj).data("linkurl")));
    var url = $(obj).data("linkurl");
    var orderid = $(obj).data("orderid");
    var linenum = $(obj).data("linenum");
    url = url + "?OrderId="+orderid+"&LineNum="+linenum;
    //alert(url);
    //var linkurl = encodeURI(url);
    //alert(linkurl);
    var scrollerId = popupId+"-scroller";
    var wrapperId = popupId+"-wrapper";
    var contentsId = popupId+"-contents";
    
    //var LinkedResPopupScroll;

    //clearing the contents
    $("#"+contentsId).empty();

    $("#"+popupId+"-title").html(popupTitle);
    $("#dvMez").show();
    $("#dvMez").data("popid",popupId);
	$(popupObj).show();
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
/* 	if(LinkedResPopupScroll!=null){
		LinkedResPopupScroll.refresh();
	} */
    $("#"+contentsId).load(url, function(){
    	
    	LinkedResPopupScroll = new iScroll(wrapperId, {
    		useTransform : true,
    		zoom : false,
    		onBeforeScrollStart : function(e) {
    			var target = e.target;
    			while (target.nodeType != 1) target = target.parentNode;

    			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' ){
    				e.preventDefault();
    			}

    			e.stopPropagation();
    		}
    	});
    	if(LinkedResPopupScroll!=null){
    		LinkedResPopupScroll.refresh();
    	}
    });

}
function closePopup(popupId){
	var popupObj = $("#"+popupId);
	$(popupObj).hide();
	$("#dvMez").hide();
	$("#dvMez").data("popid","");
	$("#dvMez").off();
}
function closeMez(){
	$("#dvMez").hide();
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").data("popid","");
	$("#dvMez").off();
}
</script>

<style>
.poContentRow {
    height: 65px;
}
.poItemRow1 {
    height: 41px;
}
.poModifyButton{
	display: none;
    position: absolute;
    right: 10px;
    z-index: 1;
}


</style>

</head>
<body>
	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name="frmPODetails" id="frmPODetails" id="frmPODetails" method="post" style="width: 100%; height: 100%" action="">
			<div id="allergyHeader" class="AllergyHeader" style="padding: 0px" data-role="none">
				<table cellpadding="0" cellspacing="0" class="tbAllergyHeader" data-role="none">
					<tr class="normalTr">
						<td class="normalTd">
							<div class="RecordAllergyHeader RecordAllergyHeaderTheme">
								<div class="RecordAllergyTable">
									<div class="normalRow">
										<div class="AllergyCell" style="width: 99%; text-align: left">
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme"><%=csResBundle.getString("pendingOrder.pendingOrders") %></div>
										</div>
										<div class="AllergyCell" style="width: 1%">
										
											<div class="RecordAllergyTable">
												<div class="normalRow">
													<div class="AllergyCell" style="width: auto; text-align: right">
														<div class="buttonContainer">
															<div class="WidgetButtonTheme" onclick="gotoCS()">
																<img src="${path}/eIPAD/images/CS_Close16x16.png"/>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div id="divcnt" class="divAllergyContent divAllergyContentTheme" style="padding: 0px; overflow: hidden" data-role="none">
				<div style="width: 100%; height: auto; overflow: auto" data-role="none">
					<div style="width: 100%; height: auto; overflow: auto" data-role="none">	<!-- container start -->
						<%
		if(ordersResp.isSuccessResponse()&&!ordersResp.isEmptyDataResponse()){
			List<PendingOrders> pendingOrderList = ordersResp.getPendingOrderList();
			if(pendingOrderList!=null){
				for(int i=0;i<pendingOrderList.size();i++){
					PendingOrders curOrderType = pendingOrderList.get(i);
					%>
					<div style="display:table;width:100%" class="widgetHeaderCellTheme">
						<div style="display:table-row">
							<div style="display:table-cell;width:100%;height:8vhpx;vertical-align:middle;">
								<span class="widgetHeaderHeadingTextTheme" data-role="none"><%=curOrderType.getOrderCategoryDescription() %></span>
								<input class="widgetHeaderCountButtonTheme" type="button" value="<%=curOrderType.getListCount() %>">
							
							</div>
							
						</div>
					</div>
					<%
					List<PendingOrderItems> pendingOrderItemList =  curOrderType.getPendingOrderItemList();
					if(pendingOrderItemList!=null){
						for(int j=0;j<pendingOrderItemList.size();j++){
							PendingOrderItems orderItem = pendingOrderItemList.get(j);%>
							
						<div class="WidgetContentStripTheme"  style="display:table;width:100%" data-role = "none"> <!--  content table starts -->
							<div class="poContentRow" style="display:table-row;width:100%;" data-role = "none"> <!-- content row starts -->
								<div style="display:table-cell;width:100%;" data-role = "none"><!-- contentCell starts here -->
									<div style="display:table;width:100%;height:100%" data-role = "none">
										<div class = "poItemRow1" style="display:table-row;width:100%" data-role = "none">
											<div style="display:table-cell;vertical-align:middle" data-role = "none">
												<div class = "WidgetParaHeadTextTheme" style="padding-left:12px;padding-top:10px;" data-role = "none">
												 <%=orderItem.getCatalogDescription() %>
												  <span class="WidgetNormalTextItalicTheme" > (<%=orderItem.getOrderStatusDesc() %>)</span> 
													<div class="SfsHeaderButtonTheme poModifyButton" data-role = "none">Modify</div>
												</div>
											</div>
											
											<div style="display:table-cell;vertical-align:middle;text-align:right"data-role = "none">
												<%if(orderItem.getFormatExistYN().equals("Y")){ %>
													<div class = "poOrderlineImg" style="display:inline-block;padding-right:20px " data-role = "none" data-orderid="<%=orderItem.getOrderId() %>" 
													data-linenum="<%=orderItem.getOrderLineNum() %>"  data-title="Order Line Format"  onclick="showPOFormatPopup(this,'CSCommonPopUpContainer')" data-linkurl="${path}/mobile/chartsummary/PendingOrdersFormatView">
													</div>
												<%} %>	
											</div>
										</div>
									</div>
									<div style="display:table;width:100%;height:100%" data-role = "none">
										<div style="display:table-row;width:100%" data-role = "none">
											<div style="display:table-cell" data-role = "none">
												<div style="display:table;width:100%;height:100%" data-role = "none">
													<div style="display:table-row" data-role = "none">
														<div style="display:table-cell;vertical-align:middle;height:100%" data-role = "none">
														   <div class = "WidgetNormalTextTheme" style="padding-left:12px;padding-bottom:10px;"data-role = "none">
							                                	by <%=orderItem.getPractitionerName() %>
							                              </div>
														</div>
														<div style="display:table-cell;vertical-align:middle;text-align:right"data-role = "none">
														<%-- <%if(orderItem.getFormatExistYN().equals("Y")){ %>
															<div class = "poOrderlineImg" style="display:inline-block" data-role = "none" data-orderid="<%=orderItem.getOrderId() %>" 
															data-linenum="<%=orderItem.getOrderLineNum() %>"  data-title="Order Line Format"  onclick="showPOFormatPopup(this,'CSCommonPopUpContainer')" data-linkurl="${path}/mobile/chartsummary/PendingOrdersFormatView">
															</div>
														<%} %>	 --%>
															<div data-role = "none" class = "WidgetDateTextTheme" style="display:inline-block;padding-right:20px"><%=orderItem.getOrderDateTime() %></div>
													   </div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div><!-- contentCell ends here -->	
							</div><!-- content row ends -->
						</div><!--  content table ends -->
	<%					}
					}
				}
			}
	%>
	
	<%} else{
	%>
						<div class="WidgetVwErrContainer">
							<%
							for(int k=0;k<errorList.size();k++){
							%>
							<div class="WidgetErrorResponse WidgetErrorResponseTheme"><%= errorList.get(k).getErrorMessage()%></div>
							<%} %> 
						</div>
	<%} %>	
						
						
					</div> <!-- container Ends -->
				</div>
				<div data-role = "none" id = "dvMez" class = "blurPopup" onclick="closeMez()" data-popid=""></div>
			</div>
			
								
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup - STARTS -->
								<div id="CSCommonPopUpContainer" class="CSCommonPopUpContainer">
									<!-- <div id="CSCommonPopUpContainer-arrowUp" class="CSCommonPopup-arrowUpTheme"></div> -->
									<div  class="CSCommonPopup CSCommonPopupTheme">
										<div style="display:table;width:100%;height:100%">
											<div style="display:table-row">
												<div style="display:table-cell;height:40px">
													<div style="display:table" class="CSCommonPopupHeader CSCommonPopupHeaderTheme">
														<div style="display:table-row">
															<div style="display:table-cell;width:100px;vertical-align:middle;text-align:left">
																<div class="CSCommonPopupCloseBtnTheme" id="CSCommonPopupCloseBtn" onclick="closePopup('CSCommonPopUpContainer')">Close</div>
															</div>
															<div style="display:table-cell;width:80%;vertical-align:middle;text-align:center;padding-right:150px;" class="CSCommonPopupHeaderTextTheme" id="CSCommonPopUpContainer-title"></div>
														</div>
													</div>
												</div>
											</div>
											<div style="display:table-row">
												<div class="SFSBackgroundTheme" style="display:table-cell;width:100%;">
													<div id="CSCommonPopUpContainer-wrapper" class="CSCommonPopupWrapper" style="margin:10px;background:#fff;height:332px;" >
														<div id="CSCommonPopUpContainer-scroller" class="CSCommonPopupScroller">
															<div id="CSCommonPopUpContainer-contents" class="CSCommonPopupContents">
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!-- <div id="CSCommonPopUpContainer-arrowDown" class="CSCommonPopup-arrowDownTheme"></div> -->
								</div>
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup - ENDS-->
								
		<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 				
						
		</form>
	</div>
</body>
</html>


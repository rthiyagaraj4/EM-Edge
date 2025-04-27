<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="eIPAD.chartsummary.pendingorders.healthobject.PendingOrderItems"%>
<%@page import="eIPAD.chartsummary.pendingorders.healthobject.PendingOrders"%>
<%@page import="eIPAD.chartsummary.pendingorders.response.PendingOrderResponse"%>
<%@page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
PendingOrderResponse ordersResp = (PendingOrderResponse)request.getAttribute("POResponse");
ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();

if(ordersResp!=null){
	errorList = ordersResp.getErrorsList();
}

%>
<script type="text/javascript">

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
    
	$(popupObj).show();
	$("#dvMez").show();
	$("#dvMez").data("popid",popupId);
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

<div style="width:100%;" data-role = "none">
<form id="PODataForm" action="" method="post" name="PODataForm" id="PODataForm"> 
	<%
		if(ordersResp.isSuccessResponse()&&!ordersResp.isEmptyDataResponse()){
			List<PendingOrders> pendingOrderList = ordersResp.getPendingOrderList();
			if(pendingOrderList!=null){
				for(int i=0;i<pendingOrderList.size();i++){
					List<PendingOrderItems> pendingOrderItemList =  pendingOrderList.get(i).getPendingOrderItemList();
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
						
						<%-- <div style="display:table-cell;vertical-align:middle" data-role = "none">
							<div class = "WidgetParaHeadTextTheme" style="padding-top:10px;" data-role = "none">
							 <%=orderItem.getorderStatusDesc() %>
								<!-- <div class="SfsHeaderButtonTheme poModifyButton" data-role = "none">Modify</div> -->
							</div> 
						</div> --%>
						
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
	
</form>
</div>


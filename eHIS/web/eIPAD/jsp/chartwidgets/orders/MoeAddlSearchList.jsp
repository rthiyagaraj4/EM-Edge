<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@page import="eIPAD.chartsummary.orderentry.bc.MOrderEntryBC"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%
String orderCategory = request.getParameter("hdnOrderCategory") == null?"":request.getParameter("hdnOrderCategory");
String orderCategoryCode = request.getParameter("hdnOrderCategoryCode") == null?"":request.getParameter("hdnOrderCategoryCode");
String orderType = request.getParameter("hdnOrderType") == null?"":request.getParameter("hdnOrderType");
String orderTypeCode = request.getParameter("hdnOrderTypeCode") == null?"":request.getParameter("hdnOrderTypeCode");
String sfsContext = request.getParameter("hdnSfsContext") == null?"":request.getParameter("hdnSfsContext");

MOrderEntryBC bc = new MOrderEntryBC();
MOrderEntryFieldResponse sfsResp = null;
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
	String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
	String or_bean_name = "eOR.OrderEntryBean";
	OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
	if(sfsContext.equals("OC")){
		sfsResp = bc.getAllOrderCategories(bean, true);
	}
	else if(sfsContext.equals("OT")){
		sfsResp = bc.getOrderTypesUnderCategory(bean, orderCategoryCode, true);
	}
	
}

%>
<!DOCTYPE html>
<html>
<head>
<title>Order Entry Additional Search</title>
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no" />
<!-- <link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0a4.1.min.css" /> -->


<link rel="stylesheet" href="${path}/eIPAD/css/iPadNew_IP.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" /> 
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>  -->
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<%-- <script src="${path}/eIPAD/js/PlaceOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 --%>

<script>



document.addEventListener('DOMContentLoaded', assignAddnlSearchListScroller, false);

function onloadAddnlSearchCriteria(){
	var ordCatDesc = $("#hdnOrderCategory").val();
	var ordCatCode = $("#hdnOrderCategoryCode").val();
	if(ordCatDesc && ordCatCode){
		//enable ordertype selection and text box  and the search button
		$("#OrderTypeSelection").css("opacity","1");
		$("#OrderTypeSelection").attr("onclick", "openSearchResults('OT')");
		$( "#OrderTypeSelection" ).click(function() {
			openSearchResults('OT');
		});
		
		$("#SearchTextContainer").css("opacity","1");
		$("#OrdSearchText").removeAttr("disabled");
		
		$("#AddlSearchButton").removeClass("ipSearchHeaderButtonDisabledTheme").addClass("ipSearchHeaderButtonTheme");
		$( "#AddlSearchButton" ).click(function() {
			performSearch();
		});
	}
}

function openSearchResults(sfsContext){
	$("#hdnSfsContext").val(sfsContext);
	$("#OrderSfsForm").submit();
}
function cancelSearch(){
	parent.toggleAddlSearch();
}
function performSearch(){
	var orderCat = $("#hdnOrderCategoryCode").val();
	var orderType = $("#hdnOrderTypeCode").val();
	var searchText = $("#OrdSearchText").val();
	parent.loadAddlSearchOrders(orderCat,orderType,searchText);
	parent.toggleAddlSearch();
}

var addnlSearchScroll;
function assignAddnlSearchListScroller() {
	addnlSearchScroll = new IScroll('#contentWrapper', { 
		scrollX: false, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		disableMouse: false,
    disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}
function selectSFSItem(code,description){
	var sfsContext = $("#hdnSfsContext").val();
	
	if(sfsContext == 'OC'){		
		$("#hdnOrderCategory").val(description);
		$("#hdnOrderCategoryCode").val(code);
	}
	else if(sfsContext == 'OT'){
		$("#hdnOrderType").val(description);
		$("#hdnOrderTypeCode").val(code);
	}
	
	$("#OrderSfsForm").submit();
}
function backToSearchCrit(){
	var searchForm = document.getElementById("OrderSfsForm");
	searchForm.submit();
}




</script>
<style>
.vscroller5{
	width: 100%;
	height: auto;
	position: absolute;
	z-index: 1;
}
.ipSearchResWrapper2{
	position:relative;
	height:210px;
	overflow:hidden;
	z-index:1000;
	margin:2px;
}

</style>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
</head>
<body style="width: 100%; height: 100%;">
	<form name='OrderSfsForm' id='OrderSfsForm' method='post' id="OrderSfsForm" style= "width:100%; height:100%;" action="${path}/eIPAD/jsp/chartwidgets/orders/MoeAddlSearchCrit.jsp">
		<div class="ipSearchHeader ipSearchHeaderTheme">
			<table>
				<tr>
					<td style="width:100px;"><div class="ipSearchHeaderButtonTheme" onclick="backToSearchCrit()">Back</div></td>
					<td style="width:200px;"><div class="ipSearchHeaderText ipSearchHeaderTextTheme"></div></td>
					<td style="width:100px;"><div class="ipSearchHeaderButtonDisabledTheme">Search</div></td>
				</tr>
			</table>
		</div>
		<div class="ipSearchContainer ipSearchContainerTheme"> <!-- style="width: 392px; height: 254px;" -->
			<div>
				<table  cellpadding = "0" cellspacing = "0" border = "0" style="width:100%;height:100%;">
					<tr>
						<td style="width:50%;"><div class="ipSearchTabSelected ipSearchTabSelectedTheme"><div class="ipSearchTabText">Search</div></div></td>
						<td style="width:50%;"><div class="ipSearchTabNotSelected ipSearchTabNotSelectedTheme"><div class="ipSearchTabText">Recent Search</div></div></td>
					</tr>
				</table>
			</div>
			<div  data-role = "none" id = "contentWrapper" class="ipSearchResWrapperTheme ipSearchResWrapper2" >
				<div data-role = "none" class="vscroller5">
					<div>
					<%
					if(sfsResp!=null && sfsResp.getResponseStatus()==0 && sfsResp.getFieldItems()!=null && !sfsResp.getFieldItems().isEmpty()){
						
					
					%>
						<table cellpadding="0" cellspacing = "0" style="width: 100%; height: 100%;overflow:hidden" class="ipSearchResultsTableTheme">
							<tr class="ipSearchResultsHeading ipSearchResultsHeadingTheme">
								<th style="width:20%"><span class="ipSearchResultsHeadingText">Code</span></th>
								<th style="width:80%"><span class="ipSearchResultsHeadingText">Description</span></th>
							</tr>
							
							<% 
							ArrayList<MOrderEntryFieldItem> sfsItems = sfsResp.getFieldItems();
							for(int i=0;i<sfsItems.size();i++) {
								MOrderEntryFieldItem sfsItem = sfsItems.get(i);
							%>
			 				<tr class="ipSearchResultsBody ipSearchResultsBodyTheme" onclick="selectSFSItem('<%=sfsItem.getCode() %>', '<%=sfsItem.getDesc() %>')">
								<td><span class="ipSearchResultsBodyText"><%=sfsItem.getCode() %></span></td>
								<td><span class="ipSearchResultsBodyText"><%=sfsItem.getDesc() %></span></td>
							</tr> 
							<%}%>
						</table>
					<%}else{ %>
			     		<div class="sfsSearchResultsEmptyTheme">No Records Found</div><!-- TODO Translate -->
			     	<%}%>
					</div>
				</div>
			</div>
 		
			<input type = "hidden" name ="hdnOrderCategory" id ="hdnOrderCategory" value ="<%=orderCategory%>"/>
			<input type = "hidden" name ="hdnOrderCategoryCode" id ="hdnOrderCategoryCode" value ="<%=orderCategoryCode%>"/>
			<input type = "hidden" name ="hdnOrderType" id ="hdnOrderType" value ="<%=orderType%>"/>
			<input type = "hidden" name ="hdnOrderTypeCode" id ="hdnOrderTypeCode" value ="<%=orderTypeCode%>"/>
			<input type = "hidden" name ="hdnSfsContext" id ="hdnSfsContext" value ="<%=sfsContext%>"/>
		</div>
		<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
	</form>
 
</body>
</html>


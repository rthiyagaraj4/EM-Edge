<%@ page language="java" contentType="text/html;charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
String orderCategory = request.getParameter("hdnOrderCategory") == null?"":request.getParameter("hdnOrderCategory");
String orderCategoryCode = request.getParameter("hdnOrderCategoryCode") == null?"":request.getParameter("hdnOrderCategoryCode");
String orderType = request.getParameter("hdnOrderType") == null?"":request.getParameter("hdnOrderType");
String orderTypeCode = request.getParameter("hdnOrderTypeCode") == null?"":request.getParameter("hdnOrderTypeCode");
String sfsContext = request.getParameter("hdnSfsContext") == null?"":request.getParameter("hdnSfsContext");
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
<%-- <script src="${path}/eIPAD/js/PlaceOrders.js"></script> --%>

<!-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  -->
<script>


$(document).ready(function(){
	onloadAddnlSearchCriteria();
});

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
			performAddlSearch();
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
function performAddlSearch(){
	var orderCat = $("#hdnOrderCategoryCode").val();
	var orderCatDesc = $("#hdnOrderCategory").val();
	var orderType = $("#hdnOrderTypeCode").val();
	var orderTypeDesc = $("#hdnOrderType").val();
	parent.loadAddlSearchOrders(orderCat,orderCatDesc, orderType,orderTypeDesc);
	parent.toggleAddlSearch();
}
</script>
<style>
 .sfs_header {
	width: 100%;
	height: 47px;
	
}
.sfs_headerTheme{
	background: #16a4c6; /* Old browsers */
	background: -moz-linear-gradient(top, #16a4c6 0%, #1087af 50%, #085f8c 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#16a4c6), color-stop(50%,#1087af), color-stop(100%,#085f8c)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* IE10+ */
	background: linear-gradient(to bottom, #16a4c6 0%,#1087af 50%,#085f8c 100%); /* W3C */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#16a4c6', endColorstr='#085f8c',GradientType=0 ); /* IE6-9 */
}
.sfsHeaderRibTheme{
	width: 100%;
	height: 45px;
	background-repeat: repeat-x;
	background-image: url(Header_Bg_Rib.PNG);
	background-position: bottom;
}
.sfsBtnTheme {
	-moz-box-shadow:inset 0px 1px 0px 0px #0ba1ce;
	-webkit-box-shadow:inset 0px 1px 0px 0px #0ba1ce;
	box-shadow:inset 0px 1px 0px 0px #0ba1ce;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0e89ae), color-stop(1, #0a678c) );
	background:-moz-linear-gradient( center top, #0e89ae 5%, #0a678c 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0e89ae', endColorstr='#0a678c');
	background-color:#0e89ae;
-webkit-border-radius: 2px;
-moz-border-radius: 2px;
border-radius: 2px;
	text-indent:2px;
	border:1px solid #214656;
	display:inline-block;
	color:#ffffff;
	font-family:Arial;
	font-size:13px;
	font-weight:bold;
	font-style:normal;
	height:33px;
	line-height:33px;
	width:71px;
	text-decoration:none;
	text-align:center;
	text-shadow:1px 1px 0px #07455c;
	margin:3px;
	float: left;
}
.sfsBtnTheme:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #0a678c), color-stop(1, #0e89ae) );
	background:-moz-linear-gradient( center top, #0a678c 5%, #0e89ae 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0a678c', endColorstr='#0e89ae');
	background-color:#0a678c;
}.sfsBtnTheme:active {
	position:relative;
	top:1px;
}
.sfsHeaderTitle
{
	height:45px;
    width:180px;
    text-align:center;
    display: table-cell; 
    vertical-align:middle;
	float:left;
}
.sfsHeaderTitleTxt
{
	height: 45px;
	width: 180px;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
	
}
.sfsHeaderTitleTxtTheme{
	font-family:Arial, Helvetica, sans-serif;
	font-size:16px;
	font-weight:bold;
	color:#ffffff;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 1);
} 

</style>
</head>
<body style="width: 100%; height: 100%;">
	<form name='OrderSfsForm' id='OrderSfsForm' method='post' id="OrderSfsForm" action="RegisterOrderAddlSearchList.jsp">
		<!-- <div class="sfs_header sfs_headerTheme">
			<div class="sfsHeaderRibTheme">
				<div class="sfsBtnTheme" onclick="cancelSearch()"> Cancel </div>
				<div class="sfsHeaderTitle">
					<div class="sfsHeaderTitleTxtTheme sfsHeaderTitleTxt">Additional Search</div>
				</div>
				<div class="sfsBtnTheme" onclick="" id="AddlSearchButton">Search</div>
			</div>
		</div> -->
		<div class="ipSearchHeader ipSearchHeaderTheme" style="height:36px">
			<table>
				<tr>
					<td style="width:100px"><div class="ipSearchHeaderButtonTheme" onclick="cancelSearch()">Cancel</div></td>
					<td style="width:200px"><div class="ipSearchHeaderTextTheme">Order Category/Type</div></td>
					<td style="width:100px"><div class="ipSearchHeaderButtonDisabledTheme" onclick="" id="AddlSearchButton">Search</div></td>
				</tr>
			</table>
		</div> 
		<div class="ipSearchContainer ipSearchContainerTheme" style="height:80%">

			<div class="ipSearchItem ipSearchItemTheme" id="OrderCategorySelection" onclick="openSearchResults('OC')">
				<div class="ipSearchItemHeading ipSearchItemHeadingTheme">Order Category</div>
				<div style="padding-left:7px">
					<input type="text" class="ipSearchItemTextbox ipSearchItemTextboxTheme" name="OrdCategory" id="OrdCategory" id="OrdCategory" placeholder="Select Order Category" value ="<%=orderCategory%>" readonly />
				</div>		
			</div>
			<div class="ipSearchItem ipSearchItemTheme" id="OrderTypeSelection" onclick="" style="opacity:0.5">
				<div class="ipSearchItemHeading ipSearchItemHeadingTheme">Order Type</div>
				<div style="padding-left:7px">
					<input type="text" class="ipSearchItemTextbox ipSearchItemTextboxTheme" name="OrdType" id="OrdType" id="OrdType" placeholder="Select Order Type" value ="<%=orderType%>" readonly />
				</div>		
			</div>
		</div>
		
		<input type = "hidden" name ="hdnOrderCategory" id ="hdnOrderCategory" value ="<%=orderCategory%>"/>
		<input type = "hidden" name ="hdnOrderCategoryCode" id ="hdnOrderCategoryCode" value ="<%=orderCategoryCode%>"/>
		<input type = "hidden" name ="hdnOrderType" id ="hdnOrderType" value ="<%=orderType%>"/>
		<input type = "hidden" name ="hdnOrderTypeCode" id ="hdnOrderTypeCode" value ="<%=orderTypeCode%>"/>
		<input type = "hidden" name ="hdnSfsContext" id ="hdnSfsContext" value ="<%=sfsContext%>"/>
		<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
	</form>
</body>
</html>


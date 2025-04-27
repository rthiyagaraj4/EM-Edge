<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.bc.MOrderEntryBC"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse"%>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>

<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>

<!DOCTYPE html> 
<html> 
<head> 
<title></title>  

<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<%-- <script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0a4.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0a4.1.min.css" />   --%>
<script src="${path}/eIPAD/js/ColumnLayout.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<%-- <script src="${path}/eIPAD/kendo.web.min.js"></script> --%>
<!-- 2013 q3-->
<script src="${path}/eIPAD/js/lib/kendo/kendo2013q3/kendo.web.min.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo2013q3/kendo.mobile.min.js"></script>
<script src="${path}/eIPAD/js/lib/kendo/kendo2013q3/kendo.mobile.scroller.min.js"></script>
<script src="${path}/eIPAD/console.js"></script>
<script src="${path}/eIPAD/jquery.mobile-1.0.1.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />

<link rel="stylesheet" href="${path}/eIPAD/css/PlaceOrders.css" />
<script src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>
<script type="application/javascript" src="${path}/eIPAD/js/GenericSlider.js"></script>

<%-- <script src="${path}/eIPAD/js/PlaceOrders.js"></script> --%>

<script type="text/javascript">
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
$(document).ready(function() {
	//initTicksheetCombo();
});
//This small jQuery plugin is used to assign the event handler function for the OK button of the confirm dialog
(function ( $ ) {
    $.fn.configureConfirmDialog = function(options) {
    	var defaultVal =  {
    	        callBackForTrue: function () { },
    	    };
    	var obj = $.extend(defaultVal, options);
    	$(this).find("[data-value='true']").off();
        $(this).find("[data-value='true']").on("click",obj.callBackForTrue);
        return this;
    };
 
}( jQuery ));
var path;
var ordItemsHScroll_A;
var ordItemsHScroll_P;
var ordItemsHScroll_S;
function assignOrdItemsHScroll_A() {
	ordItemsHScroll_A = new IScroll('#OrdListHWrapper_A', { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true,
		disableMouse: false,
    disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}
function assignOrdItemsHScroll_P() {
	ordItemsHScroll_P = new IScroll('#OrdListHWrapper_P', { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true,
		disableMouse: false,
    disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}
function assignOrdItemsHScroll_S() {
	ordItemsHScroll_S = new IScroll('#OrdListHWrapper_S', { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true,
		disableMouse: false,
    disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}
$(document).ready(function(){
	parent.setOnLoadContentPaneHeight();
	path = $('#hdnPath').val();
	$('#OrderCartIframe').load(path+"/eIPAD/jsp/chartwidgets/orders/MoeOrderCart.jsp");
	
	
});
function addDragDropFeature(){
	//Adding drag events for each draggable item if not already added
	$(".ordDraggable").each(function(){
		var dragcode = $(this).data("ordercatalogcode");
		//if the order is not already selected
		if(selectedOrders.indexOf(dragcode)<0){
			if($(this).data("role")!="draggable"){
				$(this).kendoDraggable({
				    //group: "orders",
				    
				    hint: function(element) {
				      return element.clone();
				      
				    },
					dragstart: draggableOnDragStart,
					dragend: draggableOnDragEnd,
					//ignore: ".ordItemBtnIcon",
				});
			}
		}else{
			$(this).addClass("dullElement");
		}
		
	});

	$("#OrderCartIframe").kendoDropTarget({
		//group: "orders", 
		//dragenter: droptargetOnDragEnter,
        //dragleave: droptargetOnDragLeave,
        drop: droptargetOnDrop
	});
	$(".ordItemBoxHdrTxt").kendoDraggable({
		hint: function(element) {
		      return element.clone();
		      
		    },
	});
}
function draggableOnDragStart(e) {
	var draggedElement = e.currentTarget;
	draggedElement.addClass("dullElement");
	$("#SelectOrder").addClass("orderCartHL");
	
}
function draggableOnDragEnd(e) {
	var draggedElement = e.currentTarget;
	draggedElement.removeClass("dullElement");
	$("#SelectOrder").removeClass("orderCartHL");
	//$("#cartScroller").text("draggableOnDragEnd");
}
function droptargetOnDragEnter(e) {
	//$("#cartScroller").text("droptargetOnDragEnter");
	/* var draggedElement = e.currentTarget;
	draggedElement.addClass("dullElement"); */
}

function droptargetOnDragLeave(e) {
	//$("#cartScroller").text("droptargetOnDragLeave");
	/* var draggedElement = e.currentTarget;
	draggedElement.removeClass("dullElement"); */
}

function droptargetOnDrop(e) {
	//e.draggable.destroy();
    //e.draggable.element.remove();
	//$("#cartScroller").text("droptargetOnDrop");
	var orderCatalogCode = e.draggable.element.data("ordercatalogcode");
	var orderTypeCode = e.draggable.element.data("ordertypecode");
	var orderCategoryCode = e.draggable.element.data("ordercategorycode");
	validateAndAddToCart(orderCatalogCode,orderTypeCode,orderCategoryCode,e);
}
function validateAndAddToCart(orderCatalogCode,orderTypeCode,orderCategoryCode,draggableElement){
	selectedOrders.push(orderCatalogCode);
	var ckArray = [];
	for(var i=0;i<selectedOrders.length;i++){
		var ckVal = "ck"+selectedOrders[i];
		ckArray.push(ckVal);
	}
	var check_box_value= ckArray.valueOf();
	
	//Check if there are any validation errors in placing this order
	$.getJSON(path+"/mobile/charts/orders/MOrderEntryValidateAddToCart?OrderCatalogCode="+orderCatalogCode+"&OrderTypeCode="+orderTypeCode+"&OrderCatCode="+orderCategoryCode+"&check_box_value="+check_box_value, function(valiResponse){
		if(valiResponse.validationResult == 0){
			//$('#SelectOrder').empty();
			addLoadingElemToCart();
			//Successfully added to cart, now we have to refresh the cart
			$('#OrderCartIframe').load(path+"/eIPAD/jsp/chartwidgets/orders/MoeOrderCart.jsp",function(){
				if(ordEntryCartScroll){
					
					ordEntryCartScroll.scrollToElement("#OrderCatalogItem"+orderCatalogCode);
					$("#OrderCatalogItem"+orderCatalogCode).addClass("MoeSOA MoeSofl");
					//remove highlight after 1 sec
					//setTimeout(function(){ $("#OrderCatalogItem"+orderCatalogCode).removeClass("cartItemhighlight"); }, 1000);
				}
			});
			//user should not be able to drag drop this anymore
			draggableElement.draggable.element.addClass("dullElement");
			draggableElement.draggable.element.data("incart","true");
			draggableElement.draggable.destroy();
		}
		else{
			//There is a validation error
			var errorList = valiResponse.errorItems;
			var errorMsg = "";
			for(var i=0;i<errorList.length;i++){
				errorMsg = errorMsg + (errorList[i].errorMessage).replace('{1}',orderCatalogCode)+"<br>";
			}
			showErrorDialog(errorMsg);
			draggableElement.draggable.element.removeClass("dullElement");
			selectedOrders.pop(orderCatalogCode);
		}
		
		
	});
}
function addLoadingElemToCart(){
	$("#cartScroller").append("<div class='loadingCartItem'></div>");
	if(ordEntryCartScroll!=null){ 
		ordEntryCartScroll.refresh();
		ordEntryCartScroll.scrollToElement(".loadingCartItem");
	}
	
}
function showErrorDialog(errorMsg){
	$("#OrderErrorDialogMsg").html(errorMsg);
	$("#OrderErrorDialog").show();
	showMez('OrderErrorDialog');
}
function closeErrorDialog(){
	$("#OrderErrorDialog").hide();
	closeMez();
}
function changeOrientation(orient, EMHFheight)
{
	bOrientationChanged = true; //cn
	var CSHFheight = $('#CSHeader').height() + $('#CSFooter').height();
	var content_height = parent.getTotalPageDivHeight()  - EMHFheight - CSHFheight - 10;//margin 5px
	document.getElementById("ChartSummaryMainWrapper").style.height = content_height+"px";
	/* if(document.getElementById("OrderSelectionIframe").contentWindow.ordSelChangeOrientation){
		document.getElementById("OrderSelectionIframe").contentWindow.ordSelChangeOrientation();
	} */
	if($("#Individual_Frame").is(":visible")){
		ordListDismantleColumns("A");
		ordListColFormat("OrdListColWrap_A");
		//addDragDropFeature();
	}
	if($("#Panel_Frame").is(":visible")){
		ordListDismantleColumns("P");
		ordListColFormat("OrdListColWrap_P");
		//addDragDropFeature();
	}
	if($("#OrderSet_Frame").is(":visible")){
		ordListDismantleColumns("S");
		ordListColFormat("OrdListColWrap_S");
		//addDragDropFeature();
	}
}
function initTicksheetCombo(){
	$("#cmbTickSheetSelect").kendoComboBox({
		change: function(e) {
			loadTicksheetOrders();
			var value = this.value();
			if(this.select()==-1){
				this.value('');
			}
			else{
				loadTickSectCombo(this.value());
			}
		},
		dataBound: function(e) {
			this.select(1);
			initTicksheetSectCombo();
			loadTickSectCombo(this.value());
		}
	});
}
function loadTickSectCombo(ticksheetId){
	$("#No_Orders").hide();
	$("#Individual_Orders").hide();
	$("#Individual_Frame").empty();
	$("#Panel_Orders").hide();
	//$("#Panel_Frame").attr('src','');
	$("#Panel_Frame").empty();
	$("#OrderSet_Orders").hide();
	$("#OrderSet_Frame").empty();
	var tickSectCombo = $("#cmbTicksheetSection").data("kendoComboBox");
	tickSectCombo.dataSource.data({}); // clears dataSource
	tickSectCombo.text(""); // clears visible text
	tickSectCombo.value(""); // clears invisible value
	$.getJSON( path+"/mobile/charts/orders/MOrderEntryJSONFieldValues?field=TicksheetSections&TickSheetId="+ticksheetId, function(data){
		tickSectCombo.setDataSource(data.fieldItems);
		loadTicksheetOrders();
	});
}
function initTicksheetSectCombo(){
	$("#cmbTicksheetSection").kendoComboBox({
		dataTextField: "desc",
		dataValueField: "code",
		change: function(e) {
			loadTicksheetOrders();
			var value = this.value();
			if(this.select()==-1){
				this.value('');
			}
			else{
				
			}
        },
		dataBound: function() {
		    this.select(0);
		}
	});
}
function loadTicksheetOrders(){
	$("#No_Orders").hide();
	$("#Individual_Orders").hide();
	$("#Individual_Frame").empty();
	$("#Panel_Orders").hide();
	$("#Panel_Frame").empty();
	$("#OrderSet_Orders").hide();
	$("#OrderSet_Frame").empty();
    $("#TickSectCombocontainer").show();
	var tickSectCombo = $("#cmbTicksheetSection").data("kendoComboBox");
	var tickSheetCombo = $("#cmbTickSheetSelect").data("kendoComboBox");
	var ticksheetId = tickSheetCombo.value();
	var ticksheetSec = tickSectCombo.value();
	var orderListUrl = path + "/eIPAD/jsp/chartwidgets/orders/MoeItemsList.jsp?SearchMode=T&TickSheetId="+ticksheetId+"&SectionCode="+ticksheetSec;
	$.getJSON( path+"/mobile/charts/orders/MOrderEntryJSONFieldValues?field=TicksheetOrdersCount&TickSheetId="+ticksheetId+"&TickSheetSec="+ticksheetSec, function(countResponse){
		var groupCount = 0;
		if(countResponse.individualCount > 0){
			$("#Individual_Frame").load(orderListUrl+'&OrderNature=A',function() {
				$("#Individual_Orders").show();
				ordListColFormat("OrdListColWrap_A")
				assignOrdItemsHScroll_A();
				addDragDropFeature();
			});
			$("#Individual_Count").html("("+countResponse.individualCount+")");
			
			groupCount++;
		}
		if(countResponse.panelCount > 0){
			$("#Panel_Frame").load(orderListUrl+'&OrderNature=P',function() {
				$("#Panel_Orders").show();
				ordListColFormat("OrdListColWrap_P")
				assignOrdItemsHScroll_P();
				addDragDropFeature();
			});
			$("#Panel_Count").html("("+countResponse.panelCount+")");
			
			groupCount++;
		}
		if(countResponse.orderSetCount > 0){
			$("#OrderSet_Frame").load(orderListUrl+'&OrderNature=S',function() {
				$("#OrderSet_Orders").show();
				ordListColFormat("OrdListColWrap_S")
				assignOrdItemsHScroll_S();
				addDragDropFeature();
			});
			$("#OrderSet_Count").html("("+countResponse.orderSetCount+")");
			
			groupCount++;
		}
		//adding/removing css classes  based on the number of order nature types having orders
		if(groupCount == 3){
			if(countResponse.individualCount > 0){
				$("#Individual_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox2").addClass("ordItemsBox3");
			}
			if(countResponse.panelCount > 0){
				$("#Panel_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox2").addClass("ordItemsBox3");
			}
			if(countResponse.orderSetCount > 0){
				$("#OrderSet_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox2").addClass("ordItemsBox3");
			}
		}else if(groupCount == 2){
			if(countResponse.individualCount > 0){
				$("#Individual_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox3").addClass("ordItemsBox2");
			}
			if(countResponse.panelCount > 0){
				$("#Panel_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox3").addClass("ordItemsBox2");
			}
			if(countResponse.orderSetCount > 0){
				$("#OrderSet_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox3").addClass("ordItemsBox2");
			}
		}else if(groupCount == 1){
			if(countResponse.individualCount > 0){
				$("#Individual_Orders").removeClass("ordItemsBox2").removeClass("ordItemsBox3").addClass("ordItemsBox1");
			}
			if(countResponse.panelCount > 0){
				$("#Panel_Orders").removeClass("ordItemsBox2").removeClass("ordItemsBox3").addClass("ordItemsBox1");
			}
			if(countResponse.orderSetCount > 0){
				$("#OrderSet_Orders").removeClass("ordItemsBox2").removeClass("ordItemsBox3").addClass("ordItemsBox1");
			}
		}
		else if(groupCount == 0){
			$("#No_Orders").show();
		}
	});
}
function loadAddlSearchOrders(orderCat,orderType,searchText){
	$("#No_Orders").hide();
	$("#Individual_Orders").hide();
	$("#Individual_Frame").empty();
	$("#Panel_Orders").hide();
	$("#Panel_Frame").empty();
	$("#OrderSet_Orders").hide();
	$("#OrderSet_Frame").empty();
	//empty the combo box
	var tickSectCombo = $("#cmbTicksheetSection").data("kendoComboBox");
	tickSectCombo.dataSource.data({}); // clears dataSource
	tickSectCombo.text(""); // clears visible text
	tickSectCombo.value(""); // clears invisible value
	var tickSheetCombo = $("#cmbTickSheetSelect").data("kendoComboBox");
	//tickSheetCombo.text(""); // clears visible text
	//tickSheetCombo.value(""); // clears invisible value 
	tickSheetCombo.select(0);
	$("#TickSectCombocontainer").hide();
	var orderListUrl = path + "/eIPAD/jsp/chartwidgets/orders/MoeItemsList.jsp?SearchMode=A&OrderCategory="+orderCat+"&OrderType="+orderType+"&SearchText="+searchText;
	$.getJSON( path+"/mobile/charts/orders/MOrderEntryJSONFieldValues?field=SearchOrdersCount&OrderCategory="+orderCat+"&OrderType="+orderType+"&SearchText="+searchText, function(countResponse){
		var groupCount = 0;
		if(countResponse.individualCount > 0){
			$("#Individual_Frame").load(orderListUrl+'&OrderNature=A',function() {
				$("#Individual_Orders").show();
				ordListColFormat("OrdListColWrap_A")
				assignOrdItemsHScroll_A();
				addDragDropFeature();
			});
			$("#Individual_Count").html("("+countResponse.individualCount+")");
			
			groupCount++;
		}
		if(countResponse.panelCount > 0){
			$("#Panel_Frame").load(orderListUrl+'&OrderNature=P',function() {
				$("#Panel_Orders").show();
				ordListColFormat("OrdListColWrap_P")
				assignOrdItemsHScroll_P();
				addDragDropFeature();
			});
			$("#Panel_Count").html("("+countResponse.panelCount+")");
			
			groupCount++;
		}
		if(countResponse.orderSetCount > 0){
			$("#OrderSet_Frame").load(orderListUrl+'&OrderNature=S',function() {
				$("#OrderSet_Orders").show();
				ordListColFormat("OrdListColWrap_S")
				assignOrdItemsHScroll_S();
				addDragDropFeature();
			});
			$("#OrderSet_Count").html("("+countResponse.orderSetCount+")");
			
			groupCount++;
		}
		//adding/removing css classes  based on the number of order nature types having orders
		if(groupCount == 3){
			if(countResponse.individualCount > 0){
				$("#Individual_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox2").addClass("ordItemsBox3");
			}
			if(countResponse.panelCount > 0){
				$("#Panel_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox2").addClass("ordItemsBox3");
			}
			if(countResponse.orderSetCount > 0){
				$("#OrderSet_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox2").addClass("ordItemsBox3");
			}
		}else if(groupCount == 2){
			if(countResponse.individualCount > 0){
				$("#Individual_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox3").addClass("ordItemsBox2");
			}
			if(countResponse.panelCount > 0){
				$("#Panel_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox3").addClass("ordItemsBox2");
			}
			if(countResponse.orderSetCount > 0){
				$("#OrderSet_Orders").removeClass("ordItemsBox1").removeClass("ordItemsBox3").addClass("ordItemsBox2");
			}
		}else if(groupCount == 1){
			if(countResponse.individualCount > 0){
				$("#Individual_Orders").removeClass("ordItemsBox2").removeClass("ordItemsBox3").addClass("ordItemsBox1");
			}
			if(countResponse.panelCount > 0){
				$("#Panel_Orders").removeClass("ordItemsBox2").removeClass("ordItemsBox3").addClass("ordItemsBox1");
			}
			if(countResponse.orderSetCount > 0){
				$("#OrderSet_Orders").removeClass("ordItemsBox2").removeClass("ordItemsBox3").addClass("ordItemsBox1");
			}
		}else if(groupCount == 0){
			$("#No_Orders").show();
		}
	});
}
function toggleAddlSearch(){
	$("#OrdSearchSFS").toggle();
	
	if($("#OrdSearchSFS").is(":visible")){
		//reload sfs iframe if it is visible
		$("#sfsFrame").attr("src", $("#sfsFrame").attr("src"));
		showMez("OrdSearchSFS");
	}else{
		closeMez();
	}
	

}

//Function that gives a columnar view to the orders list
function ordListColFormat(id){
	var ordListColWrap = $('#'+id);
	var ordListColParent = ordListColWrap.parent();
	var ordListColItems = ordListColWrap.children();

	//set row count based on parent height
	var rows = getOrdListRowCount(id);

	//or set it manually here
	//var rows = 3;

	sets = [];
	while (ordListColItems.length > 0) {
	  sets.push(ordListColItems.splice(0, rows));
	}

	sets.forEach(function(set, i) {
	  $set = $(set);
	  $set.addClass('ordListColItem');
	  $setLi = $('<li class="ordListcol"></li>');
	  $setList = $('<ul></ul>');
	  $setList.append($set);
	  $setLi.append($setList);
	  ordListColWrap.append($setLi);
	});
}
function getOrdListRowCount(id) {
	var ordListColWrap = $('#'+id);
	var ordListColParent = ordListColWrap.parent();
	var ordListColItems = ordListColWrap.children();
  var rows = Math.floor(ordListColParent.height() / ordListColItems.height());
  return (rows) ? rows : 1;
}
function openClinicalNotes(){
	$("#PageLoadingAnimation").show();
	window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet");
}
function openOrdersFrame(){
	$("#PageLoadingAnimation").show();
	window.location.replace(path+"/mobile/charts/orders/MNewOrderServlet");
}
function openChartSummaryFrame(){
	$("#PageLoadingAnimation").show();
	window.location.replace(path+"/mobile/chartsummary/ChartWidgetsView");
}
function openClinicalEvents(){
	$("#PageLoadingAnimation").show();
	window.parent.$('#hdnopeningPage').val('clinicalEvents');
	window.parent.$("#ChartsBaseForm").submit();
}
function openPharmacyOrders(){
	$("#PageLoadingAnimation").show();
	parent.openPharmacyOrders();
}

//to maintain the list of selected individual orders
var selectedOrders = [];

function addToCart(){
	$('#OrderFieldsIframe')[0].contentWindow.submitOrderFields();
	//alert(selectedOrders);
}
function refreshOrderCart(){
	$('#SelectOrder').empty()
	$('#OrderCartIframe').load(path+'/eIPAD/jsp/chartwidgets/orders/MoeOrderCart.jsp');
}
function closeConfirmDialog(){
	$("#OrderConfirmDialog").hide();
	closeMez();
}
function removeOrder(mode,code){
	var callDeleteOrder = function(){
		closeConfirmDialog();
		removeOrderFromCart(mode,code);
	};
	$("#OrderConfirmDialog").configureConfirmDialog({
		callBackForTrue: callDeleteOrder
	});
	var errorMsg = "Do you want to remove this order from cart?";
	showConfirmDialog(errorMsg);
}

function removeOrderFromCart(mode,code){
	var selOrders = selectedOrders.slice(); // have a copy of the object and remove the tobedeleted items from this array and if the del ajax call is successful, it is set to parent window
	//alert(selOrders);
	var ordsForRemoval = [];
	var catCode = "";
	if(mode == "IND"){
		//coz push pop is not working in sliced array
		var index = selOrders.indexOf(code);
		 // alert("Index"+index);
		  if(index!=-1){
			  selOrders.splice(index, 1);
		  }
		//selOrders.pop(code);
		ordsForRemoval.push(code);
	}else if(mode == "CAT"){
		  $("[data-catcode='"+code+"']").each(function(index, value) { 
			  var indcode = $(this).data("itemcode");
			  //alert(indcode);
			  var index = selOrders.indexOf(indcode);
			 // alert("Index"+index);
			  if(index!=-1){
				  selOrders.splice(index, 1);
			  }
			  //selOrders.remove(indcode);
			  //alert(selOrders);
			  ordsForRemoval.push(indcode);
		  });
		  catCode = code;
	}
	
	//alert(ordsForRemoval);
	var ckArray = [];
	for(var i=0;i<selOrders.length;i++){
		var ckVal = "ck"+selOrders[i];
		ckArray.push(ckVal);
	}
	
	var check_box_value= ckArray.valueOf();
	var codes_csv = ordsForRemoval.valueOf();
	//alert(ckArray.valueOf());
	var jqxhr = $.ajax( path+'/eIPAD/jsp/chartwidgets/orders/MoeRemoveFromCart.jsp?check_box_value='+check_box_value+'&code='+codes_csv+'&cat='+catCode )
		.done(function(data) {
		 //alert("done");
		 //$('#OrderCartIframe').attr('src','');
		 //$('#OrderCartIframe').attr('src',path+'/eIPAD/jsp/chartwidgets/orders/MoeOrderCart.jsp');
		 refreshOrderCart();
		 //to clear the selectedOrders JS array
		 //$('#OrderCartIframe')[0].contentWindow.removeOrdersFromArray_cartpage(mode,code);
		  //alert( "success"+data.responseText );
		  //removing the removed data from the parent window array
		  for(var i=0; i<ordsForRemoval.length ;i++){
			  var index = selectedOrders.indexOf(ordsForRemoval[i]);
				 // alert("Index"+index);
				  if(index!=-1){
					  selectedOrders.splice(index, 1);
				  }
		  	//selectedOrders.pop(ordsForRemoval[i]);
		  	$("[data-ordercatalogcode='"+ordsForRemoval[i]+"']").removeClass("dullElement");
		  	$("[data-ordercatalogcode='"+ordsForRemoval[i]+"']").kendoDraggable({
			    //group: "orders",
			    
			    hint: function(element) {
			      return element.clone();
			      
			    },
				dragstart: draggableOnDragStart,
				dragend: draggableOnDragEnd,
				//ignore: ".ordItemBtnIcon",
			});
		  }
		  
		})
		.fail(function() {
		  alert( "error in removing orders from the cart... try again" );
		});
}
function ordListDismantleColumns(type){
	/* var ordListColWrap = $('#OrdListColWrap');
	var ordListColParent = ordListColWrap.parent();
	var ordListColItems = ordListColWrap.children(); */
	var newList = '<ul id="OrdListColWrap_'+type+'" class="ordListColWrap">';

	$(".ordDraggable_"+type).each(function(k,v) { 
		newList = newList.concat('<li><div class="ordDraggable ordItemBoxTheme ordDraggable_'+type+'">'+$(this).html()+'</div></li>');
	});
	newList = newList.concat('</ul>');
	$("#OrdItemscroller_"+type).empty();
	$("#OrdItemscroller_"+type).html(newList);
}
//function to open a popup showing the Panel/Orderset contents
function openPanelOrderSetContents(measure_id,order_catalog_nature,contr_msr_panel_id,category,catalog_code,CatalogSynonym){
	$("#ListPopupHeading").html(CatalogSynonym);
	$("#ListPopupFrame").attr('src','');
	$("#OrderListPopup").show();
	showMez('OrderListPopup');
	$("#ListPopupFrame").attr('src',path+'/eIPAD/jsp/chartwidgets/orders/MoePanelOrderSetContents.jsp?measure_id='+measure_id+'&order_catalog_nature='+order_catalog_nature+'&contr_msr_panel_id='+contr_msr_panel_id+'&category='+category+'&catalog_code='+catalog_code);
}
function closePanelOrderSetContents(){
	$("#OrderListPopup").hide();
	closeMez();
}
function closeMez(){
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").hide();
	$("#dvMez").off();
}
function showMez(popid){
	$('#dvMez').show();
	$("#dvMez").data("popid",popid);
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
}



function showConfirmDialog(errorMsg){
	$("#OrderConfirmDialogMsg").html(errorMsg);
	$("#OrderConfirmDialog").show();
	showMez('OrderConfirmDialog');
}
function completePlaceOrders_confirm(){
	var transactionResp;
	$("#PageLoadingAnimation").show();
	$.getJSON(path+"/mobile/charts/orders/MOrderEntryTransaction", function(data){
		transactionResp = data.categoryTransactionItems;
		$("#PageLoadingAnimation").hide();
		$('#OrderCartIframe').load(path+"/eIPAD/jsp/chartwidgets/orders/MoeOrderCart.jsp",function(){
			completePlaceOrders_transaction(transactionResp);
		});
		
	});  
	
	
}

function completePlaceOrders_transaction(transactionResp){
	var successCats = ""; //variable that holds category desc
	for(var i=0;i<transactionResp.length;i++){
		var categoryErrorItem = transactionResp[i];
		var transactionResult = categoryErrorItem.transactionResult;
		var successMsg = "orders were placed successfully";
		
		if(!transactionResult){
			var catalogTransactionItems = categoryErrorItem.catalogTransactionItems;
			if(catalogTransactionItems.length>0){
				for(var j=0;j<catalogTransactionItems.length;j++){
					var catalogTransactionItem = catalogTransactionItems[j];
					var ordCatalogCode = catalogTransactionItem.catalogCode;
					var errorMsg = catalogTransactionItem.errorMessage;
					errorHighlightCatalog(ordCatalogCode,errorMsg);
				}
			}else{
				//Category Specific Error
				errorHighlightCategory(categoryErrorItem.categoryCode,categoryErrorItem.transactionRespDesc);
			}
		}
		else{
			if(successCats){ //multiple success, hence comma has to be inserted
				successCats = successCats + ", " + categoryErrorItem.categoryDesc;
			}
			else{
				successCats = successCats + categoryErrorItem.categoryDesc;
			}
			
		}
		
		//if there was atleast one success in the transaction then show the success message
		if(successCats){
			successMsg = successCats + " :: " + successMsg;
			setTransactionMessage(true,successMsg);
		} 
		//alert(categoryErrorItem.categoryCode);
	}
	
}

function errorHighlightCatalog(ordCatalogCode,errorMsg){
	$("#OrderCatalogItem"+ordCatalogCode).addClass("OrdCartItemErHighlgt");
	$("#OrdTransactionErIcon"+ordCatalogCode).show();
	$("#OrdTransactionErIcon"+ordCatalogCode).data("tscterrormsg",errorMsg);
}
function errorHighlightCategory(categoryCode,errorMsg){
	$("#OrdTransactionErCatIcon"+categoryCode).show();
	$("#OrdTransactionErCatIcon"+categoryCode).data("tscterrormsg",errorMsg);
}

function showTransactError(obj){
	var errorMsg = $(obj).data("tscterrormsg");
	showErrorDialog(errorMsg);
}

function setTransactionMessage(result,errMsg){
	if(result){
		$("#transactionMsg").addClass("formValSuccessTheme");
		$("#transactionMessageContent").html(errMsg);
	}
	 showTransactionMessage();
}

function showTransactionMessage(){
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}
function openOrderFields(OrderCatalogCode,OrderTypeCode,OrderCatCode){
	$("#PageLoadingAnimation").show();
	$("#OrderPlaceDiv").hide();
	$("#OrderFieldsDiv").show();
	$("#OrderFieldsIframe").empty();
	$("#OrderFieldsIframe").load(path+'/eIPAD/jsp/chartwidgets/orders/MoeItemFields.jsp?OrderCatalogCode='+OrderCatalogCode+'&OrderTypeCode='+OrderTypeCode+'&OrderCatCode='+OrderCatCode,function(){
		$("#PageLoadingAnimation").hide();
	});
	
}
function closeOrderFields(){
	$("#OrderPlaceDiv").show();
	$("#OrderFieldsDiv").hide();
	$("#OrderFieldsIframe").attr('src','');
}
function submitOrderFields(){
	var bean_id = $("#or_bean_id").val();
	var bean_name = $("#or_bean_name").val();
	var orderCatalogCode = $("#OrderFieldsIframe #OrderCatalogCode").val();
	var orderTypeCode = $("#OrderFieldsIframe #OrderTypeCode").val();
	var orderCategoryCode = $("#OrderFieldsIframe #OrderCatCode").val();
	/* if($.inArray(orderCatalogCode, parent.selectedOrders) == -1){
		parent.selectedOrders.push(orderCatalogCode);
	}
	var check_box_value = getSelOrdersCsvCkPrefix(); //Catalog Codes of All the selected Orders */
	
	$.ajax({
        //url: path + "/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value="+check_box_value+"&OrderCatalogCode="+orderCatalogCode+"&OrderTypeCode="+orderTypeCode+"&OrderCatCode="+orderCategoryCode,
        type: "POST",
        url: path + "/eIPAD/jsp/chartwidgets/orders/MoeUpdateOrderFields.jsp",
        data: $("#frmOrderFields").serialize(),
        success: function(response) {
            //alert("Success " + response);
			var trimResponse = $.trim(response);
            
            	closeOrderFields();
            	refreshOrderCart();
          
		},
		error: function (xhr, ajaxOptions, thrownError) {
			alert("Error in updating the order details");
			closeOrderFields();
			//parent.selectedOrders.pop(orderCatalogCode);
		}
		//end ajax options
	});//end ajax 

	//alert(parent.selectedOrders.valueOf());
	//alert(check_box_value);
}
function maximizeOrderSelectionFrame(){
	$("#OrderCartFrame").toggle();
	if($("#OrderCartFrame").is(":visible")){
		$("#OrderSelectMaximizeImg").attr("src",path+"/eIPAD/images/max12x13.png")
	}else{
		$("#OrderSelectMaximizeImg").attr("src",path+"/eIPAD/images/MaximizedWindow16x6.png")
	}
}
function closeChartSummary(){
	parent.closeChartSummary();
}
function authorizeOrder(catalogCode,categoryCode){
	var callAuthorizeOrder = function(){
		closeConfirmDialog();
		$('#OrderFieldsIframe').contents().find('#AuthorizeIcon'+catalogCode).addClass("actionTickIcon");
		$('#OrderFieldsIframe').contents().find('#authorized'+categoryCode).val("true");
	};
	$("#OrderConfirmDialog").configureConfirmDialog({
		callBackForTrue: callAuthorizeOrder
	});
	var errorMsg = "Do you want to authorize this Order?";
	showConfirmDialog(errorMsg);
}
function showAuthorizedMsg(){
	var msg = "Already Authorized";
	showErrorDialog(msg);
}
function cosignOrder(catalogCode,categoryCode){
	var callCosignOrder = function(){
		closeConfirmDialog();
		$('#OrderFieldsIframe').contents().find('#CosignIcon'+catalogCode).addClass("actionTickIcon");
		$('#OrderFieldsIframe').contents().find('#cosigned'+categoryCode).val("true");
	};
	$("#OrderConfirmDialog").configureConfirmDialog({
		callBackForTrue: callCosignOrder
	});
	var errorMsg = "Do you want to cosign this Order?";
	showConfirmDialog(errorMsg);
}
function showCosignedMsg(){
	var msg = "Already Cosigned";
	showErrorDialog(msg);
}
function specialApproveOrder(catalogCode,categoryCode){
	var callSpecialApproveOrder = function(){
		closeConfirmDialog();
		$('#OrderFieldsIframe').contents().find('#SpecialApproveIcon'+catalogCode).addClass("actionTickIcon");
		$('#OrderFieldsIframe').contents().find('#special_approved'+categoryCode).val("true");
	};
	$("#OrderConfirmDialog").configureConfirmDialog({
		callBackForTrue: callSpecialApproveOrder
	});
	var errorMsg = "Do you want to special approve this Order?";
	showConfirmDialog(errorMsg);
}
function showSpecialApprovedMsg(){
	var msg = "Already Special Approved";
	showErrorDialog(msg);
}
function showConsentMessage(){
	var msg = "This Order requires consent";
	showErrorDialog(msg);
}
function showConsentedMessage(){
	var msg = "Order already consented";
	showErrorDialog(msg);
}
function openPharmacyOrders(){
	$("#PageLoadingAnimation").show();
	parent.openPharmacyOrders();
}		
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
.Error_Window {
	width: 325;
	height: 200px;
	border: 2px solid #ffffff;
	background: #074860;
	margin: 10px;
	min-height: 200px;
	max-width: 325px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	margin: 10px;
	border-radius: 10px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	overflow: hidden
}
.top_shadow {
	width: 100%;
	height: 90px;
	background: #3b6f81; /* Old browsers */
	background: -moz-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* FF3.6+ */
	background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #3b6f81), color-stop(64%, #074860)); /* Chrome,Safari4+ */
	background: -webkit-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Chrome10+,Safari5.1+ */
	background: -o-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Opera 12+ */
	background: -ms-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* IE10+ */
	background: radial-gradient(ellipse at center, #3b6f81 0%, #074860 64%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3b6f81', endColorstr='#074860', GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
	margin-top: -40px;
	margin-top: -240px;
	z-index: -999;
}
.Error_msg_box {
	width: 100%;
	height: 150px;
	max-height: 150px;
	max-width: 100%;
	border-bottom: 1px solid #000000;
}
.Error_msg_btn {
	width: 100%;
	height: 49px;
	background: #2ea3c0; /* Old browsers */
	background: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */
	background: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2ea3c0', endColorstr='#0c7d9a', GradientType=0 ); /* IE6-9 */
display:table;
}
.Error_msg {
	height: 150px;
	width: 100%;
	overflow: auto;
	z-index: 999999;
	position: relative;
	display: table;
}
.Error_msg_Frame {
	display: table-cell;
	vertical-align: middle
}
.Error_icon
{
	width:60px;
	height:100%;
	float:left;
	text-align:right;
	
}
.Error_cont
{
	/* width: 260px; */
	height:100%;
	/* float:left; */
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	/* font-weight:bold; */
	color:#ffffff;
	text-align:center;
	padding-top: 10px;
	padding-left:10px;
}
.Error_btn_div
{
	width:0px;
	height:100%;
	border-left:1px solid #0bb5dd;
	border-right:1px solid #023542;
	float: left;
}
.Error_btn_div_con
{
	width:159px;
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;	
	display: table-cell;
	vertical-align: middle;
	cursor:pointer;
	
}
.Error_btn_div_con_single
{
	width:100%;
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;	
	display: table-cell;
	vertical-align: middle;
	cursor:pointer;
}

.ORI_Window {
	width: 350px;
	height: 365px;
	border: 2px solid #c4c4c4;
	background-color: rgba(214, 214, 214, 0.20);
	margin: 10px;
	border-radius: 5px;
	-webkit-box-shadow: inset 0px 0px 10px 0px rgba(0,0,0,0.20);
	-moz-box-shadow: inset 0px 0px 10px 0px rgba(0,0,0,0.20);
	box-shadow: inset 0px 0px 10px 0px rgba(0,0,0,0.20);
	padding: 10px;

}
.ORI_Window1 {
	width: 100%;
	height: 100%;
	border: 1px solid #9e9e9e;
	background-color: #099;
	background-image: url(${path}/eIPAD/images/OrdListBG.jpg);
	border-radius: 5px;
	

}
.ORI_Header {
	width: 100%;
	height: 50px;
	background-image: url(${path}/eIPAD/images/sfshead_Bg.png);
	background-repeat: repeat-x;

	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
}
.ORI_Header_txt {
padding-top:20px;
padding-left:5px;
}
.ORI_BTN
{
	width: 100%;
	height: 50px;
	background: #2ea3c0; /* Old browsers */
	background: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */
	background: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2ea3c0', endColorstr='#0c7d9a', GradientType=0 ); /* IE6-9 */
display:table;
}
.ORI_MSG {
	width: 100%;
	height: 265px;
	overflow:auto;
}


#OrderConfirmDialog {
  display: none;
  width: 340px;
  height: 280px;
  z-index: 500;
}
.dullElement{
	opacity: 0.5;
}

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

<%
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
String or_bean_name = "eOR.OrderEntryBean";
OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
%> 

</head>
<body style="display: block; margin: 0px; height: 100%; width: 100%;">
	<div data-role = "none" id = "dvMez" class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div><!-- TODO -->
	<div id="PageLoadingAnimation" class="absoluteCenter">
		<!-- <div class="absoluteCenter"> -->
			<!-- <div class="table absoluteCenter">
				<div class="row">
					<div id="PageLoadingAnimation_icon" class="cell"></div>
					<div id="PageLoadingAnimation_msg" class="cell">Processing orders</div>
				</div>
			</div> -->
		<!-- </div> -->
		
	</div>
	<div id="OrderListPopup" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="ORI_Window">
  			<div class="ORI_Window1">
    			<div class="ORI_Header">
    				<div class="ORI_Header_txt" id="ListPopupHeading"></div>
    			</div>
    			<div class="ORI_MSG">
    				<iframe id="ListPopupFrame" frameborder="0" style="" scrolling ="no" height="260px" width="350px" src=""></iframe>
    			</div>
    			<div class="ORI_BTN" onclick="closePanelOrderSetContents()">
    				<div class="Error_btn_div_con_single">OK</div>
    			</div>
			</div>
		</div>

	</div>
	<div id="OrderErrorDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
			<div class="Error_msg_box">
			    <div class="Error_msg">
					<div class="Error_msg_Frame">
						<div>
							<div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopWarning.png" width="30" height="30" /></div>
							<div class="Error_cont" id="OrderErrorDialogMsg"></div>
						</div>
					</div>
			    </div>
			</div>
			<div class="Error_msg_btn" onclick="closeErrorDialog()">
			    <div class="Error_btn_div_con_single">OK</div>
			</div>
			<div class="top_shadow"> </div>
		</div>
	</div>

	<div id="OrderConfirmDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
		  <div class="Error_msg_box">
		    <div class="Error_msg">
		      <div class="Error_msg_Frame">
		        <div>
		          <div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30" /> </div>
		          <div class="Error_cont" id="OrderConfirmDialogMsg">Authorization comfirmation window</div>
		        </div>
		      </div>
		    </div>
		  </div>
		  <div class="Error_msg_btn">
		    <div class="Error_btn_div_con" onclick="closeConfirmDialog()">Cancel </div>
		    <div class="Error_btn_div"> </div>
		    <div class="Error_btn_div_con" data-value="true">OK </div><!-- Onclick event for OK button will be binded dynamically -->
		  </div>
		  <div class="top_shadow"> </div>
		</div>
	</div>
	
	
	<div class = "ChartSummaryParent ChartSummaryParentTheme" data-role="page" id="OrderPlaceDiv">
		<div class="ChartSummaryBlock" id="ChartSummaryBlock" data-role = "none">
			<form id="ChartSummaryForm" name = "ChartSummaryForm" method = "post" action = "" class="ChartSummaryFormElem">
				<div class="ChartSummaryMainTable" data-role = "none">
					<div data-role = "none" class ="ChartSummaryPageHeader" id="CSHeader">
						<div class="ChartSummaryHeaderCell" data-role = "none">
							<div class="ChartSummaryHeaderCont" data-role = "none">
								<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
									<div class="ChartSummaryHeaderRow" data-role = "none">
										<div class="ChartSummaryHeaderIconCol" data-role = "none">
											<div class="WidgetButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
										</div>
										<div class="ChartSummaryHeaderTextCol" data-role = "none">
											<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">Place Orders</div><!-- TODO replace with message bundle text -->
										</div> 
										<div class="ChartSummaryHeaderEncRightCol" data-role="none">
											<div class="WidgetButtonTheme" data-role = "none" onclick="completePlaceOrders_confirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
										</div>
										<div class="ChartSummaryHeaderEncRightCol" data-role="none">
											<div class="WidgetButtonTheme" data-role = "none" onclick="closeChartSummary()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="ChartSummaryPageContent">
						<div data-role = "none" class = "ChartSummaryPageContentCell">
							
							<div data-role = "none" class = "ChartSummaryMainWrapper" id="ChartSummaryMainWrapper" style=" overflow:hidden;position:relative">
								<div class="ChartSummaryMainScroller" style="width:100%;overflow:hidden;height:100%" data-role = "none"><!-- scrolling content starts -->
									<div style="width:100%;height:100%;display:table;" data-role="none"  class="orderSelFrame">
										<div style="width:100%;display:table-row" data-role="none">
											<div style="width:99%;height:100%;display:table-cell;position:relative" data-role="none">
												<div style="display: table; margin: 0px; height: 100%; width: 100%;">
												<div style="display:table-row">
												<div style="display:table-cell;width:100%;height:100%">
												<%
												MOrderEntryBC bc = new MOrderEntryBC();
												MOrderEntryFieldResponse tickSheetListResponse = bc.getTickSheetList(bean, null, true);
												ArrayList<MOrderEntryFieldItem> tickSheetList = tickSheetListResponse.getFieldItems();
												%> 
													<div class="ordSelParent"> 
													
														<div id="OrdSearchSFS" class="orderSearchSfs" style="display:none;z-index:10005"><!-- TODO -->
															<div id="sfsarrow" data-role="none" class="sfs-bubble-arrow sfs-bubble-arrowIPTheme"></div>
															<div data-role="none" class="ordSfsSmall sfsIPTheme"  style="display:block">
																<iframe id="sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height="300px" width="340px" src="${path}/eIPAD/jsp/chartwidgets/orders/MoeAddlSearchCrit.jsp"></iframe>  
															</div> 
														</div>
														<!--  Header START-->
														<div class="ordSelHeaderMenu">
															<div class="ordSelHeaderMenuCont">
																<div class="row">
																	<div class="ordSelMenuCont">
																		<div class="ordSelMenuIconbg">
																			<div class="ordSelMenuIcon"> </div>
																		</div>
																	</div>
																	<div class="ordSelMenuCont ordSelMenuTitle"> Order </div>
																	<div class="ordSelMenuright ordSelHeaderBtnTheme" id="OrderSelectMaximizeBtn" onclick="maximizeOrderSelectionFrame()">
																  		<div class="ordSelHdrBtnIcon"><img src="${path}/eIPAD/images/max12x13.png" width="16" height="16" id="OrderSelectMaximizeImg" /></div>
																  	</div>
																	<div class="ordSelMenuright ordSelHeaderBtnTheme" onClick="toggleAddlSearch()">
																  		<div class="ordSelHdrBtnIcon"><img src="${path}/eIPAD/images/SearchSFS14x14.png" width="16" height="16" /></div>
																  	</div>
																	<div class="ordSelMenuright">
																	  	<div class="ordTickDropdownContTheme" data-role="none">
																	  		<select name="cmbTickSheetSelect" id="cmbTickSheetSelect" id="cmbTickSheetSelect" data-role="none">
																	    <%if(tickSheetListResponse.getResponseStatus()!=tickSheetListResponse.FIELD_DATAFETCH_FAILURE && tickSheetList!=null && !tickSheetList.isEmpty()){ %>
																			
																				<option>Select TickSheet</option>
																	  	<%
																			MOrderEntryFieldItem tickSheetItem;
																			for(int i=0;i<tickSheetList.size();i++) {
																			 	tickSheetItem = tickSheetList.get(i);
																		%>
																				<option value="<%=tickSheetItem.getCode() %>"><%=tickSheetItem.getDesc() %></option>
																		<%  } %>
																			
																		<%} %>
																		</select>
																			<script>
																			$(document).ready(function() {
																				initTicksheetCombo();
																			});
																			</script>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!--  Header END--> 
													  
													  	<!-- Ticksheet Combo START-->
													  
														<div class="tickSectComboCont" id="TickSectCombocontainer">
													    	<div  class="tickSectCombo" style="height:40px;position: relative;">
													    		<input id="cmbTicksheetSection" name="cmbTicksheetSection" id="cmbTicksheetSection" data-type="ComboBox" data-role="none" />
															    <script>
																	/* $(document).ready(function() {
																		initTicksheetSectCombo();
																	}); */
																</script>
															</div>
													  	</div>
													  
													  <!-- Ticksheet Combo END-->
													        <style>
													
													      
													      
													      </style>
													  <!-- Order Results START -->
														<div class="ordSelItemsCont">
													    	<div class="ordItemsCont">
													    	<!-- Panel Order Results START -->
																<div class="table ordItemsBox3" id="Panel_Orders" style="display:none">
																	<div class="ordItemBoxIn">
																  		<div class="ordItemBoxTable">
																    		<div class="row ordItemBoxRowHd">
																      			<div class="ordItemBoxCellHd">
																        			<div class="table" style="width:100%;">
													              						<div  class="row">
													              							<div class="cell">
																			        			<div class="ordItemBoxHdr">
																			          				<div class="ordItemBoxHdrTxt" onclick="heyhi()">Panel<span id="Panel_Count"></span></div>
																			        			</div>
																	        				</div>
																	        			</div>
																        			</div>
																      			</div>
																    		</div>
																    		<div class="row ordItemBoxRowCon">
																      			<div class="ordItemBoxRowConCell" style="position:relative;">
																	      			<div class="table">
													              						<div  class="row">
													              							<div class="cell">
																				      			<div> 
																				      			<!-- <iframe name="Panel_Frame" id="Panel_Frame"  src="" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" 
																	                         			style="width:100%;height:100%;position:absolute;"></iframe> -->
																	                         			<div id="Panel_Frame" style="width:100%;height:100%;position:absolute;"></div>
																				      			</div>
																			      			</div>
																		      			</div>
																	      			</div>
																      			</div>
																    		</div>
																  		</div>
																	</div>
														     	</div>
													      <!-- Panel Order Results END -->
													
													      <!-- OrderSet Order Results START -->
													      		<div class="table ordItemsBox3" id="OrderSet_Orders" style="display:none">
													        		<div class="ordItemBoxIn">
																		<div class="ordItemBoxTable">
													            			<div class="row ordItemBoxRowHd">
													              				<div class="ordItemBoxCellHd">
													                				<div class="table" style="width:100%;">
													              						<div  class="row">
													              							<div class="cell">
																                				<div class="ordItemBoxHdr">
																                  					<div class="ordItemBoxHdrTxt">Order Set<span id="OrderSet_Count"></span></div>
																                				</div>
															                				</div>
															                			</div>
													                				</div>
													              				</div>
													            			</div>
													            			<div class="row ordItemBoxRowCon">
													              				<div class="ordItemBoxRowConCell" style="position:relative;">
													              					<div class="table">
													              						<div  class="row">
													              							<div class="cell">
																              					<div>
																              					<!-- <iframe name="OrderSet_Frame" id="OrderSet_Frame"  src="" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" 
																	                         			style="width:100%;height:100%;position:absolute;"></iframe> --> 
																	                         		<div id="OrderSet_Frame" style="width:100%;height:100%;position:absolute;"></div>
																				      			</div>
																			      			</div>
																			      		</div>
																	      			</div>
																				</div>
													            			</div>
													          			</div>
													        		</div>
													      		</div>
													      <!-- OrderSet Order Results END -->
													    
													    	<!-- Individual Order Results START -->
													      		<div class="table ordItemsBox3" id="Individual_Orders" style="display:none">
													        		<div class="ordItemBoxIn">
													          			<div class="ordItemBoxTable">
																			<div class="row ordItemBoxRowHd">
													              				<div class="ordItemBoxCellHd">
													              					<div class="table" style="width:100%;">
													              						<div  class="row">
													              							<div class="cell">
													             								<div class="ordItemBoxHdr">
													                 								<div class="ordItemBoxHdrTxt">Individual<span id="Individual_Count"></span></div>
													               								</div>
													              							</div>
													              						</div>
													              					</div>
													              				</div>
													            			</div>
													            			<div class="row ordItemBoxRowCon">
													              				<div class="ordItemBoxRowConCell" style="position:relative;">
													              					<div class="table">
													              						<div  class="row">
													              							<div class="cell">
															              						<div>
																			      				 <!-- <iframe name="Individual_Frame" id="Individual_Frame"  src="" scrolling="yes" marginwidth="0" marginheight="0" frameborder="0" vspace="0" hspace="0" 
																                         			style="width:100%;height:100%;position:absolute;"></iframe> -->
																                         			<div id="Individual_Frame" style="width:100%;height:100%;position:absolute;"></div>
																			      				</div>
																	      					</div>
																	      				</div>
																	      			</div>
													              				</div>
																            </div>
																		</div>
																   	</div>
																</div>
													      <!-- Individual Order Results END -->
													      
													      <!-- No Results START -->
													      <div id="No_Orders" style="display:none">No orders were found</div>
													      
													      <!-- No Results END -->
															</div>
														</div>
													  <!-- Order Results END -->
													</div>
												<%-- <iframe id="OrderSelectionIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/eIPAD/jsp/chartwidgets/orders/MoeItemSelection.jsp" data-role="none"> </iframe> --%>
												</div>
												</div>
												</div>
											</div>
											<div style="width:1%;height:100%;display:table-cell;border-left:2px solid;position:relative" data-role="none" id="OrderCartFrame" >
												<%-- <iframe id="OrderCartIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="${path}/eIPAD/jsp/chartwidgets/orders/MoeOrderCart.jsp" data-role="none" style="width:314px" > </iframe> --%>
												<div id="OrderCartIframe" style="width:314px;height:100%"></div>
											</div>
										</div>
									</div>
								</div><!-- scrolling content ends -->
								<div data-role = "none" id = "dvMez" class = "blurPopup"></div>
								
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup, but not currently used in Orders - STARTS CONSIDER FOR REMOVAL TODO-->
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
											<div style="display:table-row; ">
												<div class="SFSBackgroundTheme" style="display:table-cell;/* width:100% */;">
													<div id="CSCommonPopUpContainer-wrapper" class="CSCommonPopupWrapper" style="margin:10px;background:#fff;height:332px;">
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
								<!-- Common pop up for widgets. Currently used for Results widget notes/graph popup but not currently used in Orders - ENDS-->
								
								<!-- Transaction message, -->
								<div class="CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none;z-index:10005">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent"></div>
								</div>
								<!-- End of Transaction message -->
								
							</div>

						</div>
					</div>
					<div data-role = "none" class = "ChartSummaryPageFooter"  id="CSFooter">
						<div data-role = "none" class = "ChartSummaryPageFooterCell">
						<div data-role = "none" class = "ChartSummaryPageFooterCont">
							<div data-role = "none" class = "ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme">
								<div data-role = "none" class = "ChartSummaryPageFooterRow">
									<div data-role = "none" class = "ChartSummaryPageFooterFirstCol"></div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openChartSummaryFrame()">
										<div data-role = "none" class = "ChartSummaryPageFooterText"><%=csResBundle.getString("common.chartSummary") %></div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openClinicalNotes()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Clinical<br/>Notes</div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme" onclick="openOrdersFrame()">
										<div data-role = "none" class = "ChartSummaryPageFooterText"><%=csResBundle.getString("common.order") %></div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openClinicalEvents()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Clinical Events</div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openPharmacyOrders()">
										<div data-role = "none" class = "ChartSummaryPageFooterText">Pharmacy Order</div>
									</div>
									<div data-role = "none" class = "ChartSummaryPageFooterLastCol"></div>
								</div>
							</div>
						</div>
						</div>
					</div>
				</div>
				<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />

			</form>
		</div>
	</div>
	<div class = "ChartSummaryParent ChartSummaryParentTheme" data-role="page" id="OrderFieldsDiv" style="display:none;z-index:10002">
		<div style="display: block;margin: 5px;margin-left: 2px; height: -moz-calc(100% - 10px);height: -webkit-calc(100% - 10px);height: -o-calc(100% - 10px);height: calc(100% - 10px);" data-role="none">
			<div class="ChartSummaryMainTable" data-role = "none">
				<div data-role = "none" class ="ChartSummaryPageHeader" id="CSHeader">
					<div class="ChartSummaryHeaderCell" data-role = "none">
						<div class="ChartSummaryHeaderCont" data-role = "none">
							<div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
								<div class="ChartSummaryHeaderRow" data-role = "none">
									<div class="ChartSummaryHeaderIconCol" data-role = "none">
										<div class="WidgetButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
									</div>
									<div class="ChartSummaryHeaderTextCol" data-role = "none">
										<div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">Place Orders</div><!-- TODO replace with message bundle text -->
									</div> 
									<div class="ChartSummaryHeaderEncRightCol" data-role="none" onclick="submitOrderFields()">
										<div class="WidgetButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
									</div>
									<div class="ChartSummaryHeaderEncRightCol" data-role="none" onclick="closeOrderFields()">
										<div class="WidgetButtonTheme" data-role = "none"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="ChartSummaryPageContent">
					<div data-role = "none" class = "ChartSummaryPageContentCell">
						<div style="width:100%;height:100%;display:table;" data-role="none">
							<div style="width:100%;display:table-row" data-role="none">
								<div style="width:100%;height:100%;display:table-cell" data-role="none" class="orderSelFrame">
									<div style="height:100%;overflow:hidden;position:relative" id="OrderFieldsIframe">
										<!-- <iframe id="OrderFieldsIframe" class="ChartSummaryIframe" scrolling="no" frameborder="0" src="" data-role="none"></iframe> -->
										<!-- <div  style=""></div> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		
	</div> 

	

</body>
</html>



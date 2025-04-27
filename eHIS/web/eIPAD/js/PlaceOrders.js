document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

var path;
$(document).ready(function(){
	path = $('#hdnPath').val();
});

/*-----------START Orders Base Page functions ----------------------*/
function scrollerRefresh(scroller){
	if(scroller != null){
		scroller.refresh();
	}
}

function changeOrientation(orient, EMHFheight)
{
	bOrientationChanged = true; //cn
	var CSHFheight = $('#CSHeader').height() + $('#CSFooter').height();
	var content_height = parent.getTotalPageDivHeight()  - EMHFheight - CSHFheight - 10;//margin 5px
	document.getElementById("ChartSummaryMainWrapper").style.height = content_height+"px";
	if(document.getElementById("OrderSelectionIframe").contentWindow.ordSelChangeOrientation){
		document.getElementById("OrderSelectionIframe").contentWindow.ordSelChangeOrientation();
	}
}

function closeChartSummary(){
	parent.closeChartSummary();
	
}

function closePopup(popupId){
	var popupObj = $("#"+popupId);
	$("#dvMez").hide();
	$(popupObj).hide();
}

function openOrdersFrame(){
	window.location.replace(path+"/mobile/charts/orders/MNewOrderServlet");
}
function openChartSummaryFrame(){
	window.location.replace(path+"/mobile/chartsummary/ChartWidgetsView");
}
//function to open a popup showing the Panel/Orderset contents
function openPanelOrderSetContents_basepage(measure_id,order_catalog_nature,contr_msr_panel_id,category,catalog_code,CatalogSynonym){
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
function showErrorDialog_basepage(errorMsg){
	$("#OrderErrorDialogMsg").html(errorMsg);
	$("#OrderErrorDialog").show();
	showMez('OrderErrorDialog');
}
function closeErrorDialog(){
	$("#OrderErrorDialog").hide();
	closeMez();
}
function openOrderFields_basepage(OrderCatalogCode,OrderTypeCode,OrderCatCode){
	$("#OrderPlaceDiv").hide();
	$("#OrderFieldsDiv").show();
	$("#OrderFieldsIframe").attr('src',path+'/eIPAD/jsp/chartwidgets/orders/MoeItemFields.jsp?OrderCatalogCode='+OrderCatalogCode+'&OrderTypeCode='+OrderTypeCode+'&OrderCatCode='+OrderCatCode);
}
function closeOrderFields_basepage(){
	$("#OrderPlaceDiv").show();
	$("#OrderFieldsDiv").hide();
	$("#OrderFieldsIframe").attr('src','');
}

function ordSelChangeOrientation(){
	if($("#Individual_Frame").is(":visible")){
		document.getElementById("Individual_Frame").contentWindow.ordListDismantleColumns();
		document.getElementById("Individual_Frame").contentWindow.ordListChangeOrientation();
	}
	if($("#Panel_Frame").is(":visible")){
		document.getElementById("Panel_Frame").contentWindow.ordListDismantleColumns();
		document.getElementById("Panel_Frame").contentWindow.ordListChangeOrientation();
	}
	if($("#OrderSet_Frame").is(":visible")){
		document.getElementById("OrderSet_Frame").contentWindow.ordListDismantleColumns();
		document.getElementById("OrderSet_Frame").contentWindow.ordListChangeOrientation();
	}
}
function loadTickSectCombo(ticksheetId){
	$("#No_Orders").hide();
	$("#Individual_Orders").hide();
	$("#Individual_Frame").attr('src','');
	$("#Panel_Orders").hide();
	$("#Panel_Frame").attr('src','');
	$("#OrderSet_Orders").hide();
	$("#OrderSet_Frame").attr('src','');
	var tickSectCombo = $("#cmbTicksheetSection").data("kendoComboBox");
	tickSectCombo.dataSource.data({}); // clears dataSource
	tickSectCombo.text(""); // clears visible text
	tickSectCombo.value(""); // clears invisible value
	$.getJSON( path+"/mobile/charts/orders/MOrderEntryJSONFieldValues?field=TicksheetSections&TickSheetId="+ticksheetId, function(data){
		tickSectCombo.setDataSource(data.fieldItems);
		loadTicksheetOrders();
	});
}
function loadTicksheetOrders(){
	$("#No_Orders").hide();
	$("#Individual_Orders").hide();
	$("#Individual_Frame").attr('src','');
	$("#Panel_Orders").hide();
	$("#Panel_Frame").attr('src','');
	$("#OrderSet_Orders").hide();
	$("#OrderSet_Frame").attr('src','');
    $("#TickSectCombocontainer").show();
	var tickSectCombo = $("#cmbTicksheetSection").data("kendoComboBox");
	var tickSheetCombo = $("#cmbTickSheetSelect").data("kendoComboBox");
	var ticksheetId = tickSheetCombo.value();
	var ticksheetSec = tickSectCombo.value();
	var orderListUrl = path + "/eIPAD/jsp/chartwidgets/orders/MoeItemsList.jsp?SearchMode=T&TickSheetId="+ticksheetId+"&SectionCode="+ticksheetSec;
	$.getJSON( path+"/mobile/charts/orders/MOrderEntryJSONFieldValues?field=TicksheetOrdersCount&TickSheetId="+ticksheetId+"&TickSheetSec="+ticksheetSec, function(countResponse){
		var groupCount = 0;
		if(countResponse.individualCount > 0){
			$("#Individual_Frame").attr('src',orderListUrl+'&OrderNature=A');
			$("#Individual_Count").html("("+countResponse.individualCount+")");
			$("#Individual_Orders").show();
			groupCount++;
		}
		if(countResponse.panelCount > 0){
			$("#Panel_Frame").attr('src',orderListUrl+'&OrderNature=P');
			$("#Panel_Count").html("("+countResponse.panelCount+")");
			$("#Panel_Orders").show();
			groupCount++;
		}
		if(countResponse.orderSetCount > 0){
			$("#OrderSet_Frame").attr('src',orderListUrl+'&OrderNature=S');
			$("#OrderSet_Count").html("("+countResponse.orderSetCount+")");
			$("#OrderSet_Orders").show();
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
	$("#Individual_Frame").attr('src','');
	$("#Panel_Orders").hide();
	$("#Panel_Frame").attr('src','');
	$("#OrderSet_Orders").hide();
	$("#OrderSet_Frame").attr('src','');
	//empty the combo box
	var tickSectCombo = $("#cmbTicksheetSection").data("kendoComboBox");
	tickSectCombo.dataSource.data({}); // clears dataSource
	tickSectCombo.text(""); // clears visible text
	tickSectCombo.value(""); // clears invisible value
	var tickSheetCombo = $("#cmbTickSheetSelect").data("kendoComboBox");
	tickSheetCombo.text(""); // clears visible text
	tickSheetCombo.value(""); // clears invisible value
	$("#TickSectCombocontainer").hide();
	var orderListUrl = path + "/eIPAD/jsp/chartwidgets/orders/MoeItemsList.jsp?SearchMode=A&OrderCategory="+orderCat+"&OrderType="+orderType+"&SearchText="+searchText;
	$.getJSON( path+"/mobile/charts/orders/MOrderEntryJSONFieldValues?field=SearchOrdersCount&OrderCategory="+orderCat+"&OrderType="+orderType+"&SearchText="+searchText, function(countResponse){
		var groupCount = 0;
		if(countResponse.individualCount > 0){
			$("#Individual_Frame").attr('src',orderListUrl+'&OrderNature=A');
			$("#Individual_Count").html("("+countResponse.individualCount+")");
			$("#Individual_Orders").show();
			groupCount++;
		}
		if(countResponse.panelCount > 0){
			$("#Panel_Frame").attr('src',orderListUrl+'&OrderNature=P');
			$("#Panel_Count").html("("+countResponse.panelCount+")");
			$("#Panel_Orders").show();
			groupCount++;
		}
		if(countResponse.orderSetCount > 0){
			$("#OrderSet_Frame").attr('src',orderListUrl+'&OrderNature=S');
			$("#OrderSet_Count").html("("+countResponse.orderSetCount+")");
			$("#OrderSet_Orders").show();
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
function openPanelOrderSetContents_selpage(measure_id,order_catalog_nature,contr_msr_panel_id,category,catalog_code,CatalogSynonym){
	parent.openPanelOrderSetContents_basepage(measure_id,order_catalog_nature,contr_msr_panel_id,category,catalog_code,CatalogSynonym);
}
function showErrorDialog_selpage(errorMsg){
	parent.showErrorDialog_basepage(errorMsg);
}

function openOrderFields_selpage(OrderCatalogCode,OrderTypeCode,OrderCatCode){
	parent.openOrderFields_basepage(OrderCatalogCode,OrderTypeCode,OrderCatCode);
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
function maximizeOrderSel_selpage(){
	parent.maxminOrderSel_basepage();
	var currentImage =  $("#OrderSelectMaximizeImg").attr("src");
	if(currentImage.indexOf("max")>=0){
		$("#OrderSelectMaximizeImg").attr("src",path+"/eIPAD/images/Search.png")
	}else{
		$("#OrderSelectMaximizeImg").attr("src",path+"/eIPAD/images/max.PNG")
	}
}
function maxminOrderSel_basepage(){
	$("#OrderCartFrame").toggle();
}

/*-----------END Orders Base Page functions ----------------------*/


/*-----------START of functions used in Additional Search-----------*/
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

/*-----------END of functions used in Additional Search-----------*/

var ordItemsHScroll;
function assignOrdItemsHScroll() {
	ordItemsHScroll = new IScroll('#OrdListHWrapper', { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		disableMouse: false,
    disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}

function openPanelOrderSetContents_itemspage(measure_id,order_catalog_nature,contr_msr_panel_id,category,catalog_code,CatalogSynonym){
	parent.openPanelOrderSetContents_selpage(measure_id,order_catalog_nature,contr_msr_panel_id,category,catalog_code,CatalogSynonym);
}

function selectOrder(OrderCatalogCode,OrderTypeCode,OrderCatCode){
	//Check if there are any validation errors in placing this order
	$.getJSON(path+"/mobile/charts/orders/MOrderEntryPrePlaceValidation?OrderCatalogCode="+OrderCatalogCode+"&OrderTypeCode="+OrderTypeCode+"&OrderCatCode="+OrderCatCode, function(valiResponse){
		if(valiResponse.validationResult == 0){
			//check if the field requires mandatory line and header level fields, if it does then open orderformat
			parent.openOrderFields_selpage(OrderCatalogCode,OrderTypeCode,OrderCatCode);
		}
		else{
			//There is a validation error
			var errorList = valiResponse.errorItems;
			var errorMsg = "";
			for(var i=0;i<errorList.length;i++){
				errorMsg = errorMsg + (errorList[i].errorMessage).replace('{1}',OrderCatalogCode)+"<br>";
			}
			parent.showErrorDialog_selpage(errorMsg);
			
		}
		
		
	});
}
var ordListColWrap;
var ordListColParent;
var ordListColItems;
function ordListChangeOrientation(){
	ordListColWrap = $('#OrdListColWrap');
	ordListColParent = ordListColWrap.parent();
	ordListColItems = ordListColWrap.children();

	//set row count based on parent height
	var rows = getOrdListRowCount(ordListColItems, ordListColParent);

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


function getOrdListRowCount() {
  var rows = Math.floor(ordListColParent.height() / ordListColItems.height());
  return (rows) ? rows : 1;
}
function ordListDismantleColumns(){
	var newList = '<ul id="OrdListColWrap" class="ordListColWrap">';

	$(".ordItemBoxTheme").each(function(k,v) { 
		newList = newList.concat('<li><div class="ordItemBoxTheme">'+$(this).html()+'</div></li>');
	});
	newList = newList.concat('</ul>');
	$("#OrdItemscroller").empty();
	$("#OrdItemscroller").html(newList);
}
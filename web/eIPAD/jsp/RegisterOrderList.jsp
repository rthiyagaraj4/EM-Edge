<%@page import="java.util.Date"%> 
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eOR.*,eOR.Common.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="eIPAD.chartsummary.encounterlist.bc.EncounterListBC"%>
<%@page import="eIPAD.chartsummary.encounterlist.request.EncounterListRequest"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%!
private String checkForNull(String strParam)
{
        String str ="";
        if(strParam!=null && strParam.length() > 0)
        	str = strParam;
        return str;
}


%>
<%

	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String mode	   = "1";
	String view_by = "H";
	String ord_cat =  request.getParameter("hdnOrderCat") == null?"":request.getParameter("hdnOrderCat");
	String ord_cat_desc =  request.getParameter("hdnOrderCatDesc") == null?"":request.getParameter("hdnOrderCatDesc");
	String single_multi = "M";
	String ord_type =  request.getParameter("hdnOrderType") == null?"":request.getParameter("hdnOrderType");
	String ord_type_desc =  request.getParameter("hdnOrderTypeDesc") == null?"":request.getParameter("hdnOrderTypeDesc");
	String priority =  request.getParameter("hdnPriority") == null?"":request.getParameter("hdnPriority");
	String transactionOccurred = request.getParameter("hdnTransactionOccurred") == null?"false":request.getParameter("hdnTransactionOccurred"); 
	String transactionMsg = request.getParameter("hdnTransactionMsg") == null?"":request.getParameter("hdnTransactionMsg"); 
	String transactionResult = request.getParameter("hdnTransactionResult") == null?"":request.getParameter("hdnTransactionResult"); 
	String formValErrClass = "";
	if(transactionOccurred.equals("true")){
		if(transactionResult.equals("SUCCESS")){
			formValErrClass = "formValSuccessTheme";
		}else if(transactionResult.equals("FAILURE")){
			formValErrClass = "formValErrorTheme";
		}
	}
	String location_type = "";
	String locn = "";
	String patientId = "";
	String encntr_id = "";
	String order_no = "";
	
	/* String practitioner_id = "PH_ALPHA";
	String resp_id = "CA"; */
	String performing_location_code = "";
	String int_or_ext = "";
	String specimen_no = "";
	String activity_type = "";
	int start = 1;
	int end = 200;
	String login_value = "pract";
	String localeName = "en";
	
	
	String selectedPeriod = request.getParameter("hdnSelectedPeriod") == null?"LOW":request.getParameter("hdnSelectedPeriod");
	SimpleDateFormat sdf_plainDate = new SimpleDateFormat("dd/MM/yyyy");
	String date_to = sdf_plainDate.format(new Date());
	String date_from = "";
	
	//String date_from = DateUtils.minusDate(date_to, "DMY", "en", 10, "d");
	
	String selectedPeriodText="";
	if(selectedPeriod.equals("LOD")){
		selectedPeriodText="Last One Day";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 1, "d");
	}
	else if(selectedPeriod.equals("LTD")){
		selectedPeriodText="Last Three Days";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 3, "d");
	}
	else if(selectedPeriod.equals("LOM")){
		selectedPeriodText="Last One Month";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 1, "M");
	}
	else{
		selectedPeriodText="Last One Week";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 7, "d");
	}

	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String pract_type = (String)session.getValue("practitioner_type");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	ArrayList allValues = new ArrayList();


	RegisterOrder bean = (RegisterOrder)PersistenceHelper.getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId("");
	bean.setMode( mode ) ;
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");

	bean.clear() ;
	allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code,int_or_ext,specimen_no,activity_type,start,end,login_value);
	
	
%>
<!DOCTYPE html> 
<html> 
<head> 
<title>RegisterOrder View</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />   
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />



<link rel="stylesheet" href="../css/iPadNew_IP.css" />  
<link rel="stylesheet" href="../css/iPADThemeA.css" /> 
<link rel="stylesheet" href="../css/iPADNew.css" />  
<script src="../jquery-1.9.1.min.js"></script>  

<script type="application/javascript" src="../js/iscroll.js"></script>


<script type="text/javascript">

function loaderInd() {
	/* setTimeout(function () {
		 parent.legendsScroll = new iScroll('legendWrapper');
	}, 100); */
	
} 


document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', loaderInd, false);



var header_borderheight= 90;
var content_height;

var scrollContent1 ;
var scrollNav;
var ArrayOfPats=[];
var ArrayOfEncounter=[];

function loaded1() {
	setTimeout(function () {
		//parent.scrollContent1 = new iScroll('divcnt');
		// fix to make the check boxes work inside iscroll
		parent.scrollContent1 = new iScroll('divcnt', {
			useTransform: true,
			zoom: false,
			onBeforeScrollStart: function (e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;

			if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' )
			e.preventDefault();
			}
			});
	}, 100);
	}

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

document.addEventListener('DOMContentLoaded', loaded1, false);

var indicatorTypeScroll;

 $(document).ready(function () {
	 parent.setIframeHeight();
    $('#txtPatientId').bind('keypress', function(e) {
        if (e.which == 32){
          
        	RegisterOrderFormSubmit();
        }
        if (e.which == 13){            
        	RegisterOrderFormSubmit();
        }
        
	});
   
    $("#btnsfs").bind('touchstart', function(event) { 
       
        var e = event.originalEvent; 
      
        var scrollStartPos =  e.touches[0].pageY;
     
        scrollStartPos = scrollStartPos ;
      
        var tleft = e.touches[0].pageX - "15"
    
         $("#sfs").css('z-index', "1000");
         $("#sfsarrow").css('z-index',"1000");
     
    }); 
    
    //Applying selected style to the current normalcy
	var currentPrioritySelected = document.getElementById("hdnPriority").value;
	//alert(currentNormalcySelected);
	
	if(currentPrioritySelected == "R")
		$('#PriorityRoutine').removeClass('prContentHolderIconTheme').addClass('prContentHolderSelectedIconTheme');
	else if(currentPrioritySelected == "U")
		$('#PriorityUrgent').removeClass( 'prContentHolderIconTheme').addClass( 'prContentHolderSelectedIconTheme');
	else if (currentPrioritySelected == "S")
		$('#PriorityStat') .removeClass('prContentHolderIconTheme').addClass( 'prContentHolderSelectedIconTheme');
	else 
		$('#PriorityAll').removeClass('prContentHolderIconTheme').addClass('prContentHolderSelectedIconTheme');
	
	var orderCat = $("#hdnOrderCat").val();
	if(!orderCat){
		$("#LOMDiv").hide();
	}
	
	var transactionOccurred = $("#hdnTransactionOccurred").val();
	if(transactionOccurred == 'true'){
		showTransactionMessage();
	}
	
 });
 

 
 
 function changeOrientation(orient, HFheight)
 {
 	content_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight;
	document.getElementById("divcnt").style.height = content_height+"px";
	
	if(parent.scrollContent1 != null)
	parent.scrollContent1.refresh();
 }


 function toggleLegend(){
	
	 $('#legendContainer').toggle(); 
	 var totalWidth = 0;
	 $('#legendScroller .legendTabs').each(function(index) {
     totalWidth += parseInt($(this).outerWidth());
   	});
	$('#legendScroller').css("width",(totalWidth+90)+'px');
	
	setTimeout(function () {
		parent.legendsScroll.refresh();
    }, 0);	
	
 }


 
 function refresh(){
	 $("#PageLoadingAnimation").show();
	 document.getElementById("hdnOrderCat").value = "";
	 document.getElementById("hdnOrderType").value = "";
	 document.getElementById("hdnOrderCatDesc").value = "";
	 document.getElementById("hdnOrderTypeDesc").value = "";
	 document.getElementById("hdnPriority").value = "";
	 document.getElementById("hdnSelectedPeriod").value = "LOW";
	 document.getElementById("hdnTransactionOccurred").value = "false";
	 document.getElementById("hdnTransactionMsg").value = "";
	 document.getElementById("hdnTransactionResult").value = "";
	 document.getElementById("RegisterOrderForm").submit();
 }
 function refreshAfterTransaction(){
	 $("#PageLoadingAnimation").show();
	 document.getElementById("hdnOrderCat").value = "";
	 document.getElementById("hdnOrderType").value = "";
	 document.getElementById("hdnOrderCatDesc").value = "";
	 document.getElementById("hdnOrderTypeDesc").value = "";
	 document.getElementById("hdnPriority").value = "";
	 document.getElementById("hdnSelectedPeriod").value = "LOW";
	 document.getElementById("hdnTransactionOccurred").value = "true";
	 document.getElementById("RegisterOrderForm").submit();
 }
 function addSpinner(){
	var a = $("#spinnerDiv")

	if(a.length ==0)
		$("#divContent").append("<div class='loadingCartItem' id='spinnerDiv'></div>");
}
function removeSpinner(){

	var a = $("#spinnerDiv")

	if(a.length > 0)
	$("#spinnerDiv").remove();
}

function selectAllRecords() {

	parentchkbox = document.getElementById("selectAll");
	$("#divcnt input:checkbox").each(function() {
		this.checked = parentchkbox.checked;
	});
}

function showPeriodSelect() {
	hideAddlSearch();
	$("#periodSelect").css('z-index', "1000");
	$("#periodArrow").css('z-index', "2000");
	$('#periodSelect').toggle();
	$('#periodArrow').toggle();
}
function hidePeriodSelect() {
	$('#periodSelect').hide();
	$('#periodArrow').hide();
}

function selectPeriod(sPeriod) {
	showPeriodSelect();
	document.getElementById("hdnSelectedPeriod").value = sPeriod;
	searchRegisterOrders();
}
function toggleAddlSearch(){
	hidePeriodSelect();
		var orderCat = $("#hdnOrderCat").val();
	var orderCatDesc = $("#hdnOrderCatDesc").val();
	var orderType = $("#hdnOrderType").val();
	var orderTypeDesc = $("#hdnOrderTypeDesc").val();
	document.getElementById("sfsFrame").src = "RegisterOrderAddlSearchCrit.jsp?hdnOrderCategory="+orderCatDesc+"&hdnOrderCategoryCode="+orderCat+"&hdnOrderType="+orderTypeDesc+"&hdnOrderTypeCode="+orderType;
	$("#OrdSearchSFS").toggle();
}
function hideAddlSearch(){
	$("#OrdSearchSFS").hide();
}

function searchRegisterOrders(){
	$("#PageLoadingAnimation").show();
	document.getElementById("RegisterOrderForm").submit();
}
function selectPriority(sPriority){
	document.getElementById("hdnPriority").value = sPriority;
	searchRegisterOrders();
}
function toggleLegend() {
	$('#legendContainer').toggle();
}
function loadAddlSearchOrders(orderCat,orderCatDesc, orderType,orderTypeDesc){
	$("#hdnOrderCat").val(orderCat);
	$("#hdnOrderCatDesc").val(orderCatDesc);
	$("#hdnOrderType").val(orderType);
	$("#hdnOrderTypeDesc").val(orderTypeDesc);
	searchRegisterOrders();
}
function orderSelected(orderId){
	if ($("#check_"+orderId).is(':checked')){
		$("#OrderItem_"+orderId).addClass("regOrderSelectedOrder");
	}else{
		$("#OrderItem_"+orderId).removeClass("regOrderSelectedOrder");
	}
	
	var checked = $("#RegisterOrderForm input:checked").length > 0;
	if(checked){
		$("#RegisterOrderActionBtn").removeClass("imgGrayscale");
	}else{
		$("#RegisterOrderActionBtn").addClass("imgGrayscale");
	}
}
function registerOrderAction(){
	var path = $("#hdnPath").val();
	var checked = $("#RegisterOrderForm input:checked").length > 0;
	if(checked){
		$("#PageLoadingAnimation").show();
		var checkedCounter = 0;
		var actionPath = path + '/mobile/orders/RegisterOrderJSONServlet?requestMode=RegisterOrder';
		var orderTransactionMsg = "";
		$("#RegisterOrderForm input:checked").each(function () {
			var orderCat = $(this).data("ordercat");//orderid
			var orderId = $(this).data("orderid");
			var orderDesc = $(this).data("orderdesc");
			actionPath = actionPath + "&ord_id"+checkedCounter+"="+orderId+ "&order_category"+checkedCounter+"="+orderCat;
			if(orderDesc.length > 15){
				orderTransactionMsg = orderTransactionMsg + orderDesc.substring(0, 15)+"..., ";
			}else{
				orderTransactionMsg = orderTransactionMsg + orderDesc+", ";
			}
			checkedCounter++;
			
		});
		if(orderTransactionMsg){
			orderTransactionMsg = orderTransactionMsg.substring(0, orderTransactionMsg.length - 2);
		}
		console.log(actionPath);
		actionPath = actionPath + "&total_recs="+checkedCounter;
		$.getJSON(actionPath).
			done(function(json) {
				$("#hdnTransactionOccurred").val("true");
				$("#hdnTransactionResult").val("SUCCESS");
				$("#hdnTransactionMsg").val("Order(s) Registered Successfully: "+orderTransactionMsg);
	           refreshAfterTransaction();
	        })
	        .fail(function(jqxhr, textStatus, error) {
	        	$("#hdnTransactionOccurred").val("true");
	        	$("#hdnTransactionResult").val("FAILURE");
	        	$("#hdnTransactionMsg").val("Orders could not be registered. Please contact administrator");
	        	
	            var err = textStatus + ", " + error;
	            console.log(err);
	            refreshAfterTransaction();
	        });
	}
	
	
}

function showTransactionMessage(){
	$("#transactionMsg").show();
	$("#hdnTransactionResult").val("");
	$("#hdnTransactionOccurred").val("false");
	$("#hdnTransactionMsg").val("");
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}


 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

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
.loadingCartItem {
	width: 100%;
	height: 80px;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
}
.orderSearchSfs{
	z-index: 1000;
	position: absolute;
	padding: 0px;
	top: 75px;
	height: 230px;
	right: 200px;
	width: 345px;
	display: block;
	overflow: hidden;
}
.regOrderPrimaryText{
	font-size: 12px;
    font-family: Arial;
    font-weight: bold;
    color: #333b46;
}
.regOrderSecText{
	font-size: 12px;
    font-family: Arial;
    font-weight: bold;
    color: #a3a3a3;
}
.regOrderSec2Text{
	font-size: 12px;
    font-family: Arial;
    font-weight: bold;
    color: #407d95;
}
.regOrderSelectedOrder{
	background: linear-gradient(to bottom, #d2f0fb 0%,#b9dbea 100%);
}
.imgGrayscale {
    -webkit-filter: grayscale(1);
    opacity: 0.7;
}
 </style>
 </head>
<body style= "width:100%; height:100%;"  >
<div id="PageLoadingAnimation" class="absoluteCenter"></div>
   	<div id="OrdSearchSFS" class="orderSearchSfs" style="display:none;z-index:10005;top:85px;right:40px"><!-- TODO -->
		<div id="sfsarrow" data-role="none" class="sfs-bubble-arrow sfs-bubble-arrowIPTheme" style="top:75px;right:200px"></div>
		<div data-role="none" class="ordSfsSmall sfsIPTheme"  style="display:block;height:230px;top:85px;right:45px">
			<iframe id="sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height="230px" width="340px" src=""></iframe>  
		</div> 
	</div>
   	
   	<div id = "periodArrow" data-role = "none" class = "periodSelectArrow periodSelectArrowTheme" style="right:300px"></div>
   	<div data-role = "none" class = "periodSelectContainer periodSelectContainerTheme"  id = "periodSelect" style="right:230px">
			<table cellpadding = "0" cellspacing = "0" border = "0">
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LOD')">Last One Day</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LTD')">Last Three Days</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" onclick="selectPeriod('LOW')">Last One Week</div></td></tr>
				<tr><td><div class="periodSelectRowNormal periodSelectRowNormalTheme" id="LOMDiv" onclick="selectPeriod('LOM')">Last One Month</div></td></tr>
			</table>
   	</div> 
		
	<div data-role = "page" class="ipListParent" style = "padding:0px;width:100%;height:100%;">
		<form name='RegisterOrderForm' id='RegisterOrderForm' method='post' id="RegisterOrderForm" style = "width:100%;height:100%;" action="RegisterOrderList.jsp">
			<div class ="ipHeader">
				<div class="ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme">
					<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
						<tr style = "height:100%;width:100%">
							<td style = "width:50px; padding-left:5px;">
			        			<div class = "WidgetButtonTheme" onclick="parent.toggleMenu()"><img src = "../images/MenuIcon.png"/></div>
			   				</td>
			    			<td style = "width:auto">
			         			<div class = "ipHeaderPageTitle ipHeaderPageTitleTheme"> Register Orders List</div>
			   				</td>
					   	</tr>
		    		</table>
				</div>
				<div class = "ipHeaderMenuContainer2">
	  				<div  data-role ="none" class ="ipContentHolderHeader ipContentHolderHeaderTheme">
						<table style = "height:100%;width:100%" cellpadding = "0" cellspacing = "0" border = "0">
			  				<tr style = "height:100%;width:100%">
							    <td style = "min-width:60px">
							         <span class = "ipContentHolderRefreshIcon"><img src = "../images/Refresh_black.png" onclick="refresh()"/></span>
							    </td>
							    <td style = "min-width:60px">
							         <div class = "WidgetButtonTheme imgGrayscale"  id="RegisterOrderActionBtn" onclick="registerOrderAction()"><img src = "../images/ReviewComplete.PNG"/></div>
							    </td>
							    <td style = "width:50%">
							    </td>
							    <td style = "min-width:150px"><div class = "prHeaderMenu2ButtonsTheme" onclick="showPeriodSelect()"><%=selectedPeriodText %></div></td>
							    <td style = "min-width:60px">
							         <div class = "WidgetButtonTheme" onclick="toggleAddlSearch()"><img src = "../images/filter20x20.png"/></div>
							    </td>
							    <td style = "min-width:170px" align = "right" valign = "center">
							    	<table class= "prContentHolderIconContainer" cellpadding = "0" cellspacing = "0" border = "0">
									    <tr>
											<td class = "prContentHolderIconTheme" onclick="selectPriority('')" id="PriorityAll"><img src = "../images/view01.png" style="vertical-align: middle;"/></td>
											<td class = "prContentHolderIconTheme" onclick="selectPriority('R')" id="PriorityRoutine"><div class="prNormalcyNormalTheme"></div></td>
								        	<td class = "prContentHolderIconTheme" onclick="selectPriority('S')" id="PriorityStat"><div class="prNormalcyAbnormalTheme"></div></td>
								        	<td class = "prContentHolderIconTheme" onclick="selectPriority('U')" id="PriorityUrgent"><div class="prNormalcyCriticalTheme"></div></td>
								        </tr>
						        	</table>	
						    	</td>
			 				</tr>
		    			</table>	  
	  				</div>
	  			</div>
	  		</div>
    		<div id = "divcnt"  class = "divIPcontent divIPcontentTheme" style="overflow:hidden">
				<div style = "width:100%;height:auto;overflow:auto" >		
<%
	String slClassValue = "";
	String tmp_ord_cat = "";
	String cont_order_ind = "";
	String order_line_num = "";
    String	encounter_dtls="";

	if (view_by.equals("H")) order_line_num = "1";
	int i = 0;
	if(!allValues.isEmpty()){

%>
	 <table cellpadding = "0" cellspacing = "0" border = "0" style="border-collapse: collapse;">	
					 
<%
		for(int k=0; k<allValues.size(); k++){
		String[] register_details = (String[])allValues.get(k);
		String orderID = register_details[2] ;
		String OrderType =  register_details[9] ;
		String orderTypeCode = register_details[0] ;
		String patientName= register_details[7];
		String OrderCatalog = register_details[6];
		OrderCatalog = OrderCatalog.replace("!~!",",");
		OrderCatalog = OrderCatalog.replace("(","");
		OrderCatalog = OrderCatalog.replace(")","");
		String encounterId = register_details[17];
		String facilityId = register_details[14];
		String bedNum;
		String roomNum;
		String practName;
		EncounterListResponse encResponse;
		EncounterListBC encBC = new EncounterListBC();
		ArrayList<EncounterHO> encounterList; 
		encResponse = encBC.getEncounterDetailsById(encounterId, facilityId);
		if(encResponse!= null && encResponse.getEncounterList()!=null && !encResponse.getEncounterList().isEmpty()){
			encounterList = encResponse.getEncounterList();
			EncounterHO encounterDets = encounterList.get(0);
			bedNum = encounterDets.getBedNum();
			roomNum = encounterDets.getRoomNum();
			practName = encounterDets.getPractShortName();
			
		
%>
				
				<!--<tr class="trIpRows1" style="background-color:white;float:left;"> -->
				<tr class="prResultsHeader" id="OrderItem_<%=orderID %>" style="border:1px solid #eaedf2;background-color:white">
						<td style='width: 2%' align="center" valign="middle"> 
							<div class="prCheckboxContainer">
								<input type="checkbox" data-orderid="<%=orderID %>" data-ordercat="<%=orderTypeCode %>" data-orderdesc="<%=OrderCatalog%>" id="check_<%=orderID %>" name="check" onClick="orderSelected('<%=orderID %>')" style="width:23px;height:23px" class="prCheckbox prCheckboxTheme">
							</div>
						</td>
				
											
<%
		if(register_details[4].compareTo("R")==0)
		{
			register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
								
		}
			else if(register_details[4].compareTo("U")==0)
		{
			
			register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
							
	
		}
			else if(register_details[4].compareTo("S")==0)
		{
		
			register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				
	
		}	
	
%>		

						<td style="width:30%;" >	
							<table style = "width:100%" border = "0" cellpadding = "0" cellspacing = "0">
								
									<%
										
									%>
								
								<tr class="trIpChildRows" style="height:20px;">
									 <td style="width:100%; word-break:break-all" colspan = "2" >
									  <!-- <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px; "></span> -->
									  <span class="regOrderPrimaryText"><%=OrderCatalog %></span>
									 </td>	 
								</tr>
								
												
							</table>
						</td>
							
						<td style="width: 36%;">	
							<table style = "width:100%" border = "0" cellpadding = "0" cellspacing = "0" padding-left="10px";>
																
								<tr class="trIpChildRows" style="height:20px;">
									
									 <td style="width:100%;" colspan = "2">
									  <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px;"></span><span class="lz-list-data1 lz-list-data1Theme regOrderSecText">Order ID: </span><span class='regOrderPrimaryText'><%=orderID %></span>
									 </td>	 
								</tr>
								
								<tr class="trIpChildRows" style="height:20px;">
									<td style="width:100%;" colspan = "2">
									 <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px;" ></span><span class="lz-list-data1 lz-list-data1Theme regOrderSecText">Order Type: </span><span class='regOrderPrimaryText'><%=OrderType %></span>
								   </td>
								</tr>
								
								</tr>
								<tr class="trIpChildRows" style="height:20px;">
									 <td style="width:100%;" colspan = "2">
									  <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px;"></span><span class="lz-list-data1 lz-list-data1Theme regOrderSecText">Start Date: </span><span class='regOrderPrimaryText'><%=register_details[3] %></span>
									 </td>
					 
								</tr>
								<tr class="trIpChildRows" style="height:20px;">
									<td style="width:100%; colspan = "2"l" >
									 <span class="lz-list-label lz-list-labelTheme" style="padding-left:0px;" ></span><span class="lz-list-data1 lz-list-data1Theme regOrderSecText">Priority: </span><span class='regOrderPrimaryText'><%=register_details[4] %></span>
								   </td>
								</tr>
							</table>
						</td>
						
						
						<td style="width: 36%;">
							 <table style = "width:100%" border = "0" cellpadding = "0" cellspacing = "0">
						   
								<tr class="trIpChildRows" style="height:20px";>
									<td style="width:100%;" colspan = "2" >																				 
										  <div class = "txtRows txtRowsTheme regOrderPrimaryText" style="padding-left:0px;"><%=patientName %> , <span class = "txtRows ptIdGender "style="color:#a3a3a3;font-weight: normal;padding-left:5px;"><%=register_details[11]%> , <%=register_details[12]%></span></div>
									</td>
								</tr>
								
								<tr class="trIpChildRows" style="height:20px;">
									<td style="width:100%;" colspan = "2">
									 <span class="lz-list-label regOrderSec2Text" style="padding-left:0px;" >Practitioner: </span><span class="lz-list-data1 regOrderSecText"><%= practName %></span>  
								   </td>
								</tr>
								
								<tr class="trIpChildRows" style="height:20px;">
									<td style="width:100%;" colspan = "2">
									 <span class="lz-list-label regOrderSec2Text" style="padding-left:0px;" >Room,Bed No: </span><span class="lz-list-data1 regOrderSecText"><%= bedNum %>, <%= roomNum %>
									 </span>  
								   </td>
								</tr>
								
								<tr class="trIpChildRows" style="height:20px;">
									<td style="width:100%;" colspan = "2">
									 <span class="lz-list-label regOrderSec2Text" style="padding-left:0px;" >Encounter: </span><span class="lz-list-data1 regOrderSecText"><%=register_details[17] %>
									 </span>  
								   </td>
								</tr>
								</table>
							</td>
			
<%
	i++;
	}
%>
			 </tr>
			 <%} %>
		</table>	
		<%}else{ %>
		<script>
		  $(document).ready(function () {
			var parentDiv = $('#divcnt').height();
			$('#NoRecordsMiddleAlign').height(parentDiv);
		  });
		  window.addEventListener("orientationchange", function() {

				var parentDiv = $('#divcnt').height();
				$('#NoRecordsMiddleAlign').height(parentDiv);
			}, true);
      	</script>
	   <div id="NoRecordsMiddleAlign" class="ipSearchResultsEmptyTheme">
			<table style = 'height:100%;width:100%'>
				<tr style = 'height:100%;width:100%'>
					<td style = 'height:100%;width:100%' align = 'center' valign = 'middle'>
						<span style = 'font-family:Arial;font-weight:normal;font-size:13px;color:#bdbdbd;'>No Records Found</span>
					</td>
				</tr> 
			</table>
	   </div>
		<%} %>
   </div>
   	<div class="legendToggler legendTogglerTheme" onclick="toggleLegend()">
		<img src="../images/LegendIcon.png" style="padding:10px 10px 10px 22px;" />
	</div>
	<div class="legendContainer" id="legendContainer">
		<table class="tblegends tblegendsTheme" border="0" cellpadding="" cellspacing="">
			<tr style="width: 100%; height: 100%;">
				<td style="width: 20px; height: 100%; padding-left: 5px;">
					<div class="prNormalcyNormalTheme"></div>
				</td>
				<td style="width: auto; height: 100%;" class="legendTextFooterTheme">Routine</td>
				<td style="width: 20px; height: 100%; padding-left: 5px;">
					<div class="prNormalcyAbnormalTheme"></div>
				</td>
				<td style="width: auto; height: 100%;" class="legendTextFooterTheme">Stat</td>
				<td style="width: 20px; height: 100%; padding-left: 5px;">
					<div class="prNormalcyCriticalTheme"></div>
				</td>
				<td style="width: auto; height: 100%">Urgent</td>
				<td style="width: 40%; height: 100%"></td>
			</tr>
		</table>
	</div>
	<div class="<%=formValErrClass %> CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none">
		<div class="formValErrorMsgTheme" id = "transactionMessageContent"><%=transactionMsg %></div>
	</div>
</div>
</div>
<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
<input type="hidden" name="hdnOrderCat" id="hdnOrderCat" id="hdnOrderCat" value="<%=ord_cat%>">
<input type="hidden" name="hdnOrderType" id="hdnOrderType" id="hdnOrderType" value="<%=ord_type%>">
<input type="hidden" name="hdnOrderCatDesc" id="hdnOrderCatDesc" id="hdnOrderCatDesc" value="<%=ord_cat_desc%>">
<input type="hidden" name="hdnOrderTypeDesc" id="hdnOrderTypeDesc" id="hdnOrderTypeDesc" value="<%=ord_type_desc%>">
<input type="hidden" name="hdnPriority" id="hdnPriority" id="hdnPriority" value="<%=priority%>">
<input type="hidden" name="hdnSelectedPeriod" id="hdnSelectedPeriod" id="hdnSelectedPeriod" value="<%=selectedPeriod%>">
<input type="hidden" name="hdnTransactionOccurred" id="hdnTransactionOccurred" id="hdnTransactionOccurred" value="<%=transactionOccurred%>">
<input type="hidden" name="hdnTransactionMsg" id="hdnTransactionMsg" id="hdnTransactionMsg" value="<%=transactionMsg%>">
<input type="hidden" name="hdnTransactionResult" id="hdnTransactionResult" id="hdnTransactionResult" value="<%=transactionResult%>">



</form> 
  
</body>
</html>
<%
PersistenceHelper.putObjectInBean(bean_id,bean,request);
%>


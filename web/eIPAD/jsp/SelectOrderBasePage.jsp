<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*,eIPAD.selectorder.*,eIPAD.selectorder.healthobject.*,eIPAD.selectorder.request.*,eIPAD.selectorder.response.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
request.setCharacterEncoding("UTF-8");
 String patientClass = "";
/* ---Saraswathi added - Start */
 String saveTriggered = "";
 String saveResult = "NotYetSaved";
 /* ---Saraswathi added - end */
 if(request.getParameter("patientclass") != null)
 {
	 patientClass = request.getParameter("patientclass");
 }
 String orientation = "landscape";
 if(request.getParameter("orientation") != null)
 {
	 orientation = request.getParameter("orientation").trim();
 }
 
 /* ---Saraswathi added - Start */
 if(request.getParameter("hdnSaveTriggered") != null)
 {
	 saveTriggered = request.getParameter("hdnSaveTriggered");
 }
 
 if(saveTriggered != null && saveTriggered.equals("true"))
 {
	 int orderCount = Integer.parseInt(request.getParameter("hdnCountSelected"));
	 java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
	 ArrayList<InsertOrderHO> insertOrderHOArrayList = new ArrayList<InsertOrderHO>();
	 InsertOrderRequest insertOrderRequest = new InsertOrderRequest();
	 InsertOrderResponse insertOrderResponse = new InsertOrderResponse();
	 SelectOrderDetails selectOrderDetails = new SelectOrderDetails();
	 for(int i=0;i<orderCount;i++)
	 {
		 InsertOrderHO insertOrderHO = new InsertOrderHO();
		 String catalogCode = request.getParameter("hdnCatalogCode" + i);
		 String patientID = (String)session.getValue("PatientID");
		 String encounterId = request.getParameter("hdnEncounterCode" + i);
		 String addedById = (String)session.getValue("login_user");
		 String addedDate = dateFormat.format(new java.util.Date());
				 //com.ehis.util.DateUtils.getCurrentDate("DMY", "en");
		 String addedAtWsNo = "IPAD";
		 String addedFacilityId = (String)session.getValue("facility_id")==null?"ISoft":(String)session.getValue("facility_id");
		 String modifiedById = addedById;
		 String modifiedDate = addedDate;
		 String modifiedAtWsNo = addedAtWsNo;
		 String modifiedFacilityId = addedFacilityId;
		 String facilityId = addedFacilityId;
		 String ordPractId = (String)session.getValue("ca_practitioner_id")==null ? "Default pract ID" :(String)session.getValue("ca_practitioner_id");
		 String ordDateTime = addedDate;
		 String recentStatusInd = "";//nullable
		 
		 insertOrderHO.setPatientID(patientID);
		 insertOrderHO.setOrderCatalogCode(catalogCode);
		 insertOrderHO.setEncounterId(encounterId);
		 insertOrderHO.setAddedById(addedById);
		 insertOrderHO.setAddedDate(addedDate);
		 insertOrderHO.setAddedAtWsNo(addedAtWsNo);
		 insertOrderHO.setAddedFacilityId(addedFacilityId);
		 insertOrderHO.setModifiedById(modifiedById);
		 insertOrderHO.setModifiedDate(modifiedDate);
		 insertOrderHO.setModifiedAtWsNo(modifiedAtWsNo);
		 insertOrderHO.setModifiedFacilityId(modifiedFacilityId);
		 insertOrderHO.setFacilityId(facilityId);
		 insertOrderHO.setOrdPractId(ordPractId);
		 insertOrderHO.setOrdDateTime(ordDateTime);
		 insertOrderHO.setRecentStatusInd(recentStatusInd);
		 
		 insertOrderHOArrayList.add(insertOrderHO);
	 }
	 insertOrderRequest.setHttpRequest(request);
	 insertOrderRequest.setInsertOrderHOArrayList(insertOrderHOArrayList);
	 insertOrderResponse = selectOrderDetails.insertOrder(insertOrderRequest);
	 saveResult = insertOrderResponse.getStatus();
	 System.out.println(insertOrderResponse.getStatus());
 }
 /* ---Saraswathi added - end */
%>
<!DOCTYPE html> 
<html> 
<head> 
<title></title> 
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script type="text/javascript" src="../jquery-1.5.2.min.js"></script>  
<script type="text/javascript" src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 
<link rel="stylesheet" href="../css/iPadOrder.css" />
</head>
<script>
var  catalogCode = [];
var arOrderId = [];
var selectedRowCount = 0;
var bExpand = false;
function changeOrientation(orient)
{
	if(orient == "landscape")
	  {
	//	document.getElementById("dvNotesMenu").style.min-height = "492px";
	     $("#dvOrderContent").css('min-height','508px');
	     $("#dvOrderSave").css('min-height','508px');
	     $("#dvSlide").css('min-height','508px');
	     $("#orderFrame").css('height', '464px');
	     
	     $("#dvSelectContents").css('min-height','420px');
	     document.getElementById("orderFrame").contentWindow.changeOrientation(orient);
	    // setAlignment1(orient);
	  }
  else
	  {
 	     $("#dvOrderContent").css('min-height','765px');
 	     $("#dvOrderSave").css('min-height','765px');
 	    $("#dvSlide").css('min-height','765px');
 	     $("#orderFrame").css('height', '721px');
 	    $("#dvSelectContents").css('min-height','677px');
 	    document.getElementById("orderFrame").contentWindow.changeOrientation(orient);
 	    // setAlignment1(orient);
	  }
}
function setAlignment1(orientation)
{
	
	//alert(window.orientation);
	//alert(orientation);
	var dvContentHeight =  $("#dvOrderContent").height();
	//alert(dvContentHeight);
	if(!isNaN(dvContentHeight))
	{
		var dvheight = parseInt(dvContentHeight);
		if(orientation == "landscape")
		{
			if(dvheight > 508)
			{
				 $("#dvOrderSave").css('min-height', dvheight);
			}
		}
		else if(orientation == "portrait")
		{
			if(dvheight > 765)
			{
				 $("#dvOrderSave").css('min-height', dvheight);
			}
		}
	}
	
}
function setAlignment()
{
	
	var orientation = document.getElementById("hdnOrientation").value;

	var dvContentHeight =  $("#dvOrderContent").height();
	if(!isNaN(dvContentHeight))
	{
		var dvheight = parseInt(dvContentHeight);
		
		if(orientation == "0")
		{
			
			if(dvheight > 765)
			{
				 $("#dvOrderSave").css('min-height', dvheight);
			}
		}
		else 
		{
			if(dvheight > 508)
			{
				 $("#dvOrderSave").css('min-height', dvheight);
			}
		}
		
	}
	
}
function slide()
{
	//alert("hi");
	bExpand = false;
	$('#dvOrderSave').css("width", "5%");
	$('#dvOrderContent').css("width", "95%");
	document.getElementById("dvOrderSave").style.display = "none";
	document.getElementById("dvSlide").style.display = "block";
}
function expand()
{
	bExpand = true;
	$('#dvOrderSave').css("width", "30%");
	$('#dvOrderContent').css("width", "70%");
	document.getElementById("dvOrderSave").style.display = "block";
	document.getElementById("dvSlide").style.display = "none";
}
function Loading()
{
	///* ---Saraswathi added - Start */
	if(document.getElementById("hdnSaveResult").value == "FAILURE")
	{
		alert('Save Failed');
	}
	else if(document.getElementById("hdnSaveResult").value == "SUCCESS")
	{
		alert('Save was Successful!');
	}
	///* ---Saraswathi added - End */
	changeSrchOrderState();
}
function searchTabActive()
{
	var patclass = document.getElementById("hdnPatClass").value
	document.getElementById("orderFrame").src = "SearchOrder.jsp?patientclass=" + patclass;
	changeSrchOrderState();
}
function changeSrchOrderState()
{
	var element1 = document.getElementById("tdTickSheet");
	var element2 = document.getElementById("tdExstOrder");
	var element3 = document.getElementById("tdSearchOrder");
	
	var spElement1 = document.getElementById("spSrchOrder");
	var spElement2 = document.getElementById("spExtOrd");
	var spElement3 = document.getElementById("spTickSheet");
	
	element1.setAttribute("class","tdTab");
	element2.setAttribute("class","tdTab");
	element3.setAttribute("class","tdTabActive");
	
	spElement1.setAttribute("class","spTabActive");
	spElement2.setAttribute("class","spTab");
	spElement3.setAttribute("class","spTab");
}
function changeTickSheetState()
{
	var patclass = document.getElementById("hdnPatClass").value
	document.getElementById("orderFrame").src = "TickSheetBasePage.jsp?patientclass=" + patclass;
	var element1 = document.getElementById("tdTickSheet");
	var element2 = document.getElementById("tdExstOrder");
	var element3 = document.getElementById("tdSearchOrder");
	
	var spElement1 = document.getElementById("spSrchOrder");
	var spElement2 = document.getElementById("spExtOrd");
	var spElement3 = document.getElementById("spTickSheet");
	
	element1.setAttribute("class","tdTabActive");
	element2.setAttribute("class","tdTab");
	element3.setAttribute("class","tdTab");
	
	spElement1.setAttribute("class","spTab");
	spElement2.setAttribute("class","spTab");
	spElement3.setAttribute("class","spTabActive");
}

function changeExtState()
{
	///* ---Saraswathi added - Start */
	document.getElementById("orderFrame").src = "ExistingOrders.jsp";
	///* ---Saraswathi added - End */
	var element1 = document.getElementById("tdTickSheet");
	var element2 = document.getElementById("tdExstOrder");
	var element3 = document.getElementById("tdSearchOrder");
	
	var spElement1 = document.getElementById("spSrchOrder");
	var spElement2 = document.getElementById("spExtOrd");
	var spElement3 = document.getElementById("spTickSheet");
	
	element1.setAttribute("class","tdTab");
	element2.setAttribute("class","tdTabActive");
	element3.setAttribute("class","tdTab");
	
	spElement1.setAttribute("class","spTab");
	spElement2.setAttribute("class","spTabActive");
	spElement3.setAttribute("class","spTab");
}
function removeA(arr) {
    var what, a = arguments, L = a.length, ax;
    while (L > 1 && arr.length) {
        what = a[--L];
        while ((ax= arr.indexOf(what)) !== -1) {
            arr.splice(ax, 1);
        }
    }
    return arr;
}

function removeSelectedContent(obj)
{
	//alert(obj);
	//alert($(obj));
	/*
	alert($("#tb1").attr('data-orderCatalogCode'));
	$("#tb1").remove();
	*/
	//alert($(obj).attr('data-orderCatalogCode'));
	
	var orderCatalogCode = $(obj).attr('data-orderCatalogCode');
	var orderid = $(obj).attr('data-orderId');
	//if(catalogCode != null)
   //  catalogCode.splice($.inArray(orderCatalogCode, catalogCode),1);
	//alert("remove");
	
	//alert(orderid);
	if(orderid != null && orderid != "")
	{
		if(arOrderId != null)
		{
			arOrderId.splice($.inArray(orderid, arOrderId),1);
			//alert(arOrderId);
		}
	}
	else
	{
		if(catalogCode != null)
		     catalogCode.splice($.inArray(orderCatalogCode, catalogCode),1);
		//alert(catalogCode);
	}
	
	$(obj).remove();
	selectedRowCount--;
	document.getElementById("orderFrame").contentWindow.deselectCheckBox(orderCatalogCode,orderid);
	document.getElementById("spSelected").innerHTML = "Selected (" + selectedRowCount+ ")";
	//catalogCode.push(orderCatalogCode);
	
}
function addToSaveArea(orderCatalogCode,encounterId,catalogSynonym,objChkBox,orderId)
{
	if(!bExpand)
		{
		  expand();
		}
	var strCatalogCode = "";
	if(objChkBox.checked)
	{
		
		var oCode = $(objChkBox).attr('data-orderCatalogCode');
		var bDuplicateCatCode = false;
		var bDuplicateORderSet = false;
		var orderset = $(objChkBox).attr('data-catalogNature');
		var currentOrderSet = $(objChkBox).attr('data-currentCatlogNatue');
		var tblOrderSet = "";
		if(orderset == null)
		{
			orderset = "";
		}
		
		
		//alert(oCode)
		//var tblObj = null;
		//tblObj = $("[data-orderCatalogCode = '" + oCode + "']");
		//alert(tblObj);
		
		 $(".tbSelectedResults").each(function(index, value) {      
				strCatalogCode =  $(this).attr('data-orderCatalogCode');
				tblOrderSet = $(this).attr('data-orderSet');
				if(strCatalogCode == orderCatalogCode)
				{
					bDuplicateCatCode = true;
				}
				if(tblOrderSet != null && tblOrderSet != "" && currentOrderSet != null && currentOrderSet != "")
				{
					//if(tblOrderSet == currentOrderSet && currentOrderSet == "S")
					if(tblOrderSet == "S" && currentOrderSet == "S")	
					{
						bDuplicateORderSet = true;
					}
				}
				
			
	     });
			if(!bDuplicateCatCode && !bDuplicateORderSet)
			{
				$('#dvSelectContents').append("<table class = 'tbSelectedResults' onclick = 'removeSelectedContent(this)' data-orderSet = '" +orderset + "' data-orderId ='" +orderId + "' data-orderCatalogCode ='" +orderCatalogCode + "' data-orderEncounterId = '" +encounterId + "' cellpadding = '0' cellspacing = '0'><tr style = 'width:100%;height:100%'><td style = 'height : 100%;width:2%'>&nbsp;</td><td align = 'left' valign = 'center' style = 'height : 100%;width:89%;word-break:break-all' ><span class = 'spanSaveContent'>"+catalogSynonym +"</span></td><td align = 'left' valign = 'center' style = 'height : 100%;width:9%' ><img src = '../images/Remove.png'></img></td><tr></table>");
				//$('#dvSelectContents').append("<table class = 'tbSelectedResults' onclick = 'removeSelectedContent(this)' data-orderId ='" +orderId + "' data-orderCatalogCode ='" +orderCatalogCode + "' data-orderEncounterId = '" +encounterId + "' cellpadding = '0' cellspacing = '0'><tr style = 'width:100%;height:100%'><td style = 'height : 100%;width:2%'>&nbsp;</td><td align = 'left' valign = 'center' style = 'height : 100%;width:89%' ><span class = 'spanSaveContent'>"+catalogSynonym +"</span></td><td align = 'left' valign = 'center' style = 'height : 100%;width:9%' ><img src = '../images/Remove.png'></img></td><tr></table>");
				//$('#dvSelectContents').append("<table class = 'tbSelectedResults' onclick = 'removeSelectedContent(this," + obj +")' data-orderCatalogCode ='" +orderCatalogCode + "' data-orderEncounterId = '" +encounterId + "' cellpadding = '0' cellspacing = '0'><tr style = 'width:100%;height:100%'><td style = 'height : 100%;width:1%'></td><td align = 'left' valign = 'center' style = 'height : 100%;width:89%' ><span class = 'spanSaveContent'>"+catalogSynonym +"</span></td><td align = 'left' valign = 'center' style = 'height : 100%;width:10%' ><img src = '../images/Remove.png'></img></td><tr></table>");
				//alert(orderId);
				if(orderId == null || orderId == "")
				{
					catalogCode.push(orderCatalogCode);
					//alert(catalogCode);
				}
				else
				{
					arOrderId.push(orderId);
				}
				selectedRowCount++;
				document.getElementById("spSelected").innerHTML = "Selected (" + selectedRowCount+ ")";
			}
			else
			{
				
			   var msg = "";
			   if(bDuplicateCatCode)
				{
				   msg = "Duplicate Orders not allowed";
				}
			   else if(bDuplicateORderSet)
				{
				   msg = "Order Set already Selected";
				}
			   alert(msg);
			   objChkBox.checked = false;
			}
		
		
	}
	else
	{
		var oCode = $(objChkBox).attr('data-orderCatalogCode');//data-orderCatalogCode
		var ordId = $(objChkBox).attr('data-orderId');
		var tblObj = null;
		if(orderId != null && orderId != "")
		{
			tblObj = $("[data-orderId = '" + ordId + "']");
		}
		else
		{
			tblObj = $("[data-orderCatalogCode = '" + oCode + "']");
		}
		
		if(tblObj != null)
		removeSelectedContent(tblObj);
	}
	
}
function returnCatalogCode()
{
	return catalogCode;
}
function returnOrderId()
{
	return arOrderId;
}
function placeOrders(objBtn)
{
	///* ---Saraswathi added - Start */
	objBtn.style.border = "3px solid #48d1d8";
	var saveButtonClicked = 'false';
	//document.getElementById("hdnSaveTriggered").value = saveButtonClicked;
	var countSelected=0;
	///* ---Saraswathi added - End */
	var catalogCode = "";
	var catalogSynonym = "";
	var encounterId = "";
	 $(".tbSelectedResults").each(function(index, value) {      
		catalogCode =  $(this).attr('data-orderCatalogCode');
		//catalogSynonym = $(this).attr('data-catalogSynonym');
		encounterId = $(this).attr('data-orderEncounterId');
		var strCatalogCode = "<input type = 'hidden' name = 'hdnCatalogCode" + index + "' value = '" + catalogCode + "' />";
		var strEncounterCode = "<input type = 'hidden' name = 'hdnEncounterCode" + index + "' value = '" +encounterId + "' />";
		$('#frmSelectORder').append(strCatalogCode);
		$('#frmSelectORder').append(strEncounterCode);
	//	$('#frmSelectORder').append("<input type = 'hidden' name = hdnEnCount" + index + " value = " + encounterId "/>");
		///* ---Saraswathi added - Start */
		saveButtonClicked = "true";
		countSelected++; 
		///* ---Saraswathi added - End */
	 });
	// /* ---Saraswathi added - Start */
	 document.getElementById("hdnCountSelected").value=countSelected;
	 document.getElementById("hdnSaveTriggered").value = saveButtonClicked;
	 //alert(countSelected);
	// /* ---Saraswathi added - End */
	 
	 document.getElementById("frmSelectORder").submit();
}
function loadWidgets()
{
	window.parent.showLoadingMsg();
}
</script>

<body  style = "background-color : #ffffff" onload = "Loading()">
	<section data-role = "page" style = "padding:0px;background-color : #ffffff">
		 <form id = "frmSelectORder" method = "post" >
			 <div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px" >
			   <div data-role = "none" class = "dvViewNotes">
			     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
			       <tr style="width:100%;height:100%">
			         <td style = "width : 95%" align = "left" valign = "center">
			            <span class = "spanViewNotes">Select Orders</span>
			            
			         </td> 
			         <td style="width:5%"  align = "center" valign = "middle" onclick = "loadWidgets()">
			            <img src = "../images/Close.png"></img>
			         </td>
			       </tr>
			     </table>
			   </div>
			   
			   <div id = "dvOrderContent" class = "dvOrdersContent" data-role = "none">
			   
			     <table id = "tabOrder" class = "tabOrder" border = "0" cellspacing = "0" cellpadding = "0">
			       <tr >
			         <td class = "tdTab" valign = "center" align = "center" id = "tdSearchOrder" onclick = "searchTabActive()"><span id = "spSrchOrder" class = "spTab">Search Orders</span></td>
			         <td class = "tdTab" valign = "center" align = "center" id = "tdTickSheet" onclick = "changeTickSheetState()"><span id = "spTickSheet"class = "spTab">Tick Sheets</span></td>
			         <td class = "tdTab" valign = "center" align = "center" id = "tdExstOrder" onclick = "changeExtState()"><span id = "spExtOrd" class = "spTab">Existing Orders</span></td>
			       </tr>
			     </table>
			      <div style = "height:auto;overflow:auto;padding:0px" data-role = "none">
                      <iframe frameborder="0" id="orderFrame" src="SearchOrder.jsp?patientclass=<%=patientClass %>" scrolling ="yes" style="padding:0px;display:block" width = "100%" ></iframe>
                  </div>   
			        
			   </div> 
			   <!--  save div -->
			   <div id = "dvOrderSave" class = "dvOrderSave" data-role = "none" style = "display:none">
			      <div data-role = "none" class = "dvViewNotes" onclick = "slide()">
				            <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
						       <tr style="width:100%;height:100%">
						         <td style = "width : 90%" align = "left" valign = "center">
						           <span class = "spTab" id = "spSelected">Selected (0) </span>
						            
						         </td> 
						         <td style="width:10%"  align = "center" valign = "bottom">
						            <img src = "../images/SelectedPanelRight.png"></img>
						         </td>
						       </tr>
				     </table>
			      </div>
			      <div id = "dvSelectContents" class = "dvSelectContents" >
			        
			      </div>
			       <div id = "dvSaveArea" class = "dvSaveArea" >
			          <table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0" class = "tbSave">
						     <tr style = "width:100%;height:100%" >
						       <td>    
						       </td>
						       <td style = "width : 80%" align = "right" valign = "center">
						        	<input type ="button" name='save_btn' id='save_btn' value='Save' class="btnType1"  data-role = "none" onclick = "placeOrders(this)" />
						       </td>
						     </tr>
					     </table>
			      </div>
			   </div>
			   
			   <div id = "dvSlide" class = "dvOrderSLide" data-role = "none" style = "display:block" >
			       <div data-role = "none" class = "dvViewNotes" onclick = "expand()">
				     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					       <tr style="width:100%;height:100%">
					         <td style = "width : 10%" align = "center" valign = "bottom">
					          <img src = "../images/SelectedPanelLeft.png"></img>
					            
					         </td> 
					         <td style="width:90%"  align = "center" valign = "middle">
					            
					         </td>
					       </tr>
				     </table>
			      </div>
			      <div style = "height:auto;width:auto">
			        <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
					       <tr style="width:100%;height:100%">
					         <td style = "width : 10%" align = "center" valign = "bottom">
					          
					            
					         </td> 
					         <td style="width:90%"  align = "center" valign = "center">
					           <b>S</b><br><b>E</b><br><b>L</b><br><b>E</b><br><b>C</b><br><b>T</b><br><b>E</b><br><b>D</b>
					         </td>
					       </tr>
				     </table>
			        
			      </div>
			      
			   </div>
			</div><!--   div main -->
			<input type = "hidden" name = "hdnPatClass" id = "hdnPatClass" value = "<%=patientClass %>" />
			<input type = "hidden" name = "hdnOrientation" id = "hdnOrientation" value = "<%=orientation %>" />
			<!--   Saraswathi added - Start -->
			<input type = "hidden" id = "hdnSaveTriggered" name = "hdnSaveTriggered" value = "false" />
			<input type = "hidden" id = "hdnCountSelected" name = "hdnCountSelected" value = "0" />
			<input type = "hidden" id = "hdnSaveResult" name = "hdnSaveResult" value = "<%=saveResult %>" />
			<!--   Saraswathi added - Start -->
		 </form> 
	</section>  
</body>

</html>


<!DOCTYPE html>
<%@page import="eOR.OrderEntryQueryBean"%>
<%@page import="eOR.Common.OrderEntryRecordBean"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ page import="eOR.OrderEntryBean"%>
<%@ page import="eOR.OrderEntryBillingQueryBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>


<%

Locale appLocale;
if (session.getAttribute("LOCALE") != null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels",appLocale);



%>

<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

var ordEntryFormFieldScroll;

function initOrderFldsScroller() {
	ordEntryFormFieldScroll = new IScroll('#wrapper', { 
		scrollX: false, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true,
		preventDefault: false,
		disableMouse: false,
    disablePointer: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
}

function StringToDate(string){
	var d = new Date();
	//var str='01/07/2013 11:18:13';
	var datenum,month,year;
	var hr=0, min=0, sec=0;
	var datetimearr = string.split(" ");
	if(datetimearr[0]){
		var datearr = datetimearr[0].split("/");
		if(datearr[0])
			datenum = parseInt(datearr[0]);
		if(datearr[1])
			month = parseInt(datearr[1]);
		if(datearr[2])
			year = parseInt(datearr[2]);
	}
	if(datetimearr[1]){
		var timearr = datetimearr[1].split(":");
		if(timearr[0])
			hr = parseInt(timearr[0]);
		if(timearr[1])
			min = parseInt(timearr[1]);
		if(timearr[2])
			sec = parseInt(timearr[2]);
	}
	
	d.setDate(datenum);
	d.setMonth(month-1);
	d.setFullYear(year);
	//if(hr!=0)
	d.setHours(hr);
	//if(min!=0)
	d.setMinutes(min);
	//if(sec!=0)
	d.setSeconds(sec);
	return d;
}

function twoDigits(num){
	if(num<10)
		num = "0" + num;
	return num;
}

function DMYHMSToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013 10:45:06
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear()) + " " + twoDigits(d.getHours()) + ":" + twoDigits(d.getMinutes()) + ":" + twoDigits(d.getSeconds());
	return stringDate;
}

function DMYHMToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013 10:45
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear()) + " " + twoDigits(d.getHours()) + ":" + twoDigits(d.getMinutes());
	return stringDate;
}

function DMYToString(dateobj){
	var d = new Date();
	if(dateobj){
		d = dateobj;
	}
	//--15/07/2013
	var stringDate = twoDigits(d.getDate()) + "/" + twoDigits((d.getMonth()+1)) + "/" + twoDigits(d.getFullYear());
	return stringDate;
}

/* function submitOrderFields(){
	var bean_id = $("#or_bean_id").val();
	var bean_name = $("#or_bean_name").val();
	var orderCatalogCode = $("#OrderCatalogCode").val();
	var orderTypeCode = $("#OrderTypeCode").val();
	var orderCategoryCode = $("#OrderCatCode").val();
	if($.inArray(orderCatalogCode, parent.selectedOrders) == -1){
		parent.selectedOrders.push(orderCatalogCode);
	}
	var check_box_value = getSelOrdersCsvCkPrefix(); //Catalog Codes of All the selected Orders
	
	$.ajax({
        //url: path + "/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value="+check_box_value+"&OrderCatalogCode="+orderCatalogCode+"&OrderTypeCode="+orderTypeCode+"&OrderCatCode="+orderCategoryCode,
        type: "POST",
        url: path + "/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value="+check_box_value,
        data: $("#frmOrderFields").serialize(),
        success: function(response) {
            //alert("Success " + response);
			var trimResponse = $.trim(response);
            
            	parent.closeOrderFields_basepage();
            	parent.refreshOrderCart();
          
		},
		error: function (xhr, ajaxOptions, thrownError) {
			alert("Error in adding the order");
			parent.selectedOrders.pop(orderCatalogCode);
		}
		//end ajax options
	});//end ajax 

	//alert(parent.selectedOrders.valueOf());
	//alert(check_box_value);
} */
//Because OrderEntryStoreValues.jsp expects selected values with CK prefix
function getSelOrdersCsvCkPrefix(){
	var ckArray = [];
	for(var i=0;i<parent.selectedOrders.length;i++){
		var ckVal = "ck"+parent.selectedOrders[i];
		ckArray.push(ckVal);
	}
	return ckArray.valueOf();
}
function showOrderSetTab(ordCode){
	var curTab = $("#CurrentOpenTab").val();
	$("#OrderSetFieldWrap"+curTab).hide();
	$("#OrderSetFieldWrap"+ordCode).show();
	$("#CurrentOpenTab").val(ordCode);
	$("#OrderSetTab"+ordCode).removeClass("widgetTabNonActiveTheme").addClass("widgetTabActiveTheme");
	$("#OrderSetTab"+curTab).removeClass("widgetTabActiveTheme").addClass("widgetTabNonActiveTheme");
}
function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}
/* function isDecimalNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode != 46 &&(charCode < 48 || charCode > 57)))
        return false;
    return true;
} */
$(document).ready(function(){
	initOrderFldsScroller()
});

</script>
<style>
.cstNumericTxtBox{
	text-align: right;
	width: calc(100% - 12px);
	height: calc(100% - 5px);
	border: none;
}

</style>

<div id="wrapper" style="position: absolute;width: 100%;height:100%;overflow: hidden;">
	<div class="container ordFldsScroller divAllergyContentTheme" id="scroller">
	
	
<!-- Fields and its values are taken from OrderEntryPlaceOrderResult.jsp and OrderEntryPlaceOrderCareSetResults.jsp -->




	<!-- <div class="divParent" data-role="page" style="padding: 0px"> -->
		<form name = "frmOrderFields" id = "frmOrderFields" style="width: 100%; height: 100%" action="">
			<div data-role = "none" id = "dvMez" class = "blurPopup"></div>
			<!-- popup container -->
			<div data-role="none" class="diagSfs sfsIPTheme" id="sfs">
				<iframe id="sfsFrame" frameborder="0" style="display: block;"
					scrolling="no" height="400px" width="740px" src=""></iframe>
			</div>
			<!-- popup container ends -->
			
				<!-- <div id="divcnt" class="divAllergyContent divAllergyContentTheme" style="padding: 0px; overflow: hidden" data-role="none">
					<div style="width: 100%; height: auto; overflow: auto" data-role="none">
						<div style="width: 100%; height: auto; overflow: auto" data-role="none">	container start	
 -->
			<!-- <div class="cstFormHeader" data-role="none">
				<span class="cstheaderTextTheme" data-role="none">Complaint Details</span>
			</div>
	 		<div class="cstRowDivider"></div>
 -->

<% 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
try{
	if(patientContext!=null){
		String patientId = patientContext.getPatientId();
		String encounterId = patientContext.getEncounterId();
		String locale = patientContext.getLocale();
		String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
		String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
		String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
		//This variable is used for accumulating  the selected order catalog codes in the current form(CSV), useful in the case of ordersets
		String orderCatalogCodes = "";
		
		String order_catalog_code = orderCatalogCode;
		String localeName = locale;
		String order_category = orderCategoryCode;
		String patient_id = patientId;
		String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
		String or_bean_name = "eOR.OrderEntryBean";
		OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		OrderEntryQueryBean beanQueryObj = new OrderEntryQueryBean();
		beanQueryObj.setLanguageId(locale);
		String dateString = bean.getSysDate();
		OrderEntryRecordBean orderEntryRecordBean = (OrderEntryRecordBean) bean.getOrderEntryRecordBean();
		eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
		OrderEntryBillingQueryBean bean_qryobj = (OrderEntryBillingQueryBean)PersistenceHelper.getBeanObject("Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request) ;
		String[] billing_details = null;
		ArrayList PlaceOrderItems = null;
		String[] records = null;
		ArrayList BillChargeInfo;
		String PrivilegeApplicabilityAuth = (String)OrderEntryBean.checkForNull(bean.getAuthorisationOrOrderingYn("AUT"),"");
		ArrayList Default = null;
		String[] recordDefault = null;
		String qty_value = "";
		String qty_uom	= "";
		String qty_uom_shortdesc = "";
		String duration_value = "";
		String max_durn_value = "";
		String chk_for_max_durn_action = "";
		String frequency_val = "";
		String prompt_msg = "";
		String comments = "";
		String format_id;
		StringTokenizer stFormatID;
		String format_id_mandatory_yn = "";
		Properties properties = bean.getProperties();
		String auth_reqd				= "";
		//auth_reqd						= (String)bean.getAccessReqd(order_category,"auth_yn");	// Column Name. auth_yn is passed
		String specialty_code = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");
		ArrayList speciality=new ArrayList();
		String practitioner_type = bean.getPractitionerType();
		String forceStatus				= bean.getForceStatus(practitioner_type,orderCategoryCode);
		String fStatus[]=forceStatus.split(":");
		String speciality_code[]=new String[3];
		ArrayList PlaceOrderType		= null;
		String[] orderTypeRecords		= null;
		String patientDischargedYn = bean.getPatientDischarged();
		ArrayList PlaceOrderFrequency	= null;
		String[] frequencyRecords	   = null;
		String[] secondaryOrders		= null;
		ArrayList performingLocationCode= null;
		String[] performingLocation		   = null;
		String login_facility_id = bean.checkForNull(bean.getLoginFacilityId());
		String rd_instal_yn				= "N";
	  	if(orderCategoryCode.equals("RD")||orderCategoryCode.equals("CS"))
			rd_instal_yn					= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N");
	  	String fac_selected = "";
	  	ArrayList DeptLocationCode 		= null;
	  	String[] deptLocation		   = null;
	  	String show_bill_info_yn = bean.getBillingInterfaceShowYn();
	  	HashMap setBills_dtls				= null;
	  	String[] care_set_count 		= null; 
	  	String order_types_comb			= ""; 
	  	StringTokenizer stFormat		= null;
	  	String facility_name = "";
	  	
	  	ArrayList OrderFormat 	= null;
	  	
		if(!orderCategoryCode.equals("CS")){
			String order_type_catalog;
			if(!orderCatalogCode.equals("") && !orderTypeCode.equals("")){
				order_type_catalog = "'"+orderCatalogCode+"'||'"+orderTypeCode+"','1'";
			}else{
				order_type_catalog = "'1||1','1'";
			}
			order_catalog_code = "'"+orderCatalogCode+"'";
			
			String billing_interface_yn = bean.getBillingInterfaceYn();
			
			PlaceOrderItems = bean.getPlaceOrdersResult(OrderEntryBean.checkForNull(order_type_catalog,"'1||1','1'"),OrderEntryBean.checkForNull(orderCategoryCode,""),OrderEntryBean.checkForNull(order_catalog_code,"''"),"");
			
			if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
				records =(String[])PlaceOrderItems.get(0); 
				orderCatalogCodes = orderCatalogCodes + records[0] + ",";
				
		%>
			<!-- Order Item Header Starts -->	
			<div class="ordFldHeader">
  				<div class="ordFldHdrRow">
				    <div class="cell">
				    	<div class="ordFldHdrTbl">
							<div class="row">
				          		<div class="ordFldHdrTxtCell">
						        	<div class="ordFldHdrTitleTheme"><%=records[1]%></div>
						            <div class="ordFldHdrPractTbl">
										<div class="ordFldHdrPractCell">
										 	<div class="ordFldHdrPractLblTheme">Attend. Practitioner </div>
										  	<div class="ordFldHdrPractTxtTheme"><%=bean.getPractitionerName()%></div>
										</div>
										<div class="ordFldHdrPractCell">
										  	<div class="ordFldHdrPractLblTheme">Ordering Practitioner </div>
										  	<div class="ordFldHdrPractTxtTheme"><%=bean.getPractitionerName()%></div>
										</div>
						            </div>
				          		</div>
				          		
				          		
					          	<div class="ordFldHdrIconCell">
					          		<div class="ordFldHdrIconHolder">
					          		<!-- Authorization Required Starts -->
						            
						            <%
						          	//Authorization
									speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
									if(speciality.size()>0)
									{
										for(int sc=0;sc<speciality.size();sc++)
										{
												speciality_code=(String[])speciality.get(sc);
										}
									}
						            //out.println("<br>Authorizaion is required"); 
									%>
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
							                  	<%
							                  	if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("authorized"+orderCategoryCode),"false").equals("true")){
												%>
								                	<div class="ordFldHdrIconPos actionTickIcon" id="AuthorizeIcon<%=records[0]%>"> <img src="${path}/eIPAD/images/Authorize24x24.png" width="20" height="20" onclick="showAuthorizedMsg()"/> </div>
								                <% 
							                  		}
							                  		else{
						                  		%>
								                	<div class="ordFldHdrIconPos" id="AuthorizeIcon<%=records[0]%>"> <img src="${path}/eIPAD/images/Authorize24x24.png" width="20" height="20" onclick="authorizeOrder('<%=records[0]%>','<%=orderCategoryCode%>')"/> </div>
								                <% 
							                  			
							                  		}
												}
												else{
												%>
													<div class="ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/Authorize24x24.png" width="20" height="20"/></div>
												<%	
												}
									            %>
								                </div>
							                </div>
						              	</div>
						            

						            
						            <!-- Authorization Required Ends -->
						            
						            <!-- Cosign Required Starts -->
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
								                <%
								              	//out.println("<br>cosign is required"); 
								                if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y"))  // For Cosign Required
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("cosigned"+orderCategoryCode),"false").equals("true")){
												%>
								                	<div class="ordFldHdrIconPos actionTickIcon" id="CosignIcon<%=records[0]%>"> <img src="${path}/eIPAD/images/Cosign24x24.png" width="20" height="20" onclick="showCosignedMsg()"/> </div>
								                <% 
							                  		}
							                  		else{
						                  		%>
								                	<div class="ordFldHdrIconPos" id="CosignIcon<%=records[0]%>"> <img src="${path}/eIPAD/images/Cosign24x24.png" width="20" height="20" onclick="cosignOrder('<%=records[0]%>','<%=orderCategoryCode%>')" /> </div>
								                <% 
							                  			
							                  		}
												}
												else{
												%>
													<div class="ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/Cosign24x24.png" width="20" height="20" /></div>
												<%	
												}
									            %>
								                </div>
							                </div>
						              	</div>
						            <!-- Cosign Required Ends -->
						            
						            <!-- Special Approval Required Starts -->
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
							                  	<%
							                  	//out.println("<br>spl approval is required"); 
									            if(records[50].equalsIgnoreCase("Y")) // For Special Approval
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("special_approved"+orderCategoryCode),"false").equals("true")){
												%>
								                	<div class="ordFldHdrIconPos actionTickIcon" id="SpecialApproveIcon<%=records[0]%>"> <img src="${path}/eIPAD/images/SpecialApproval24x24.png" width="20" height="20" onclick="showSpecialApprovedMsg()"/> </div>
								                <% 
							                  		}
							                  		else{
						                  		%>
								                	<div class="ordFldHdrIconPos" id="SpecialApproveIcon<%=records[0]%>"> <img src="${path}/eIPAD/images/SpecialApproval24x24.png" width="20" height="20" onclick="specialApproveOrder('<%=records[0]%>','<%=orderCategoryCode%>')"/> </div>
								                <% 
							                  			
							                  		}
												}
												else{
												%>
													<div class="ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/SpecialApproval24x24.png" width="20" height="20" /></div>
												<%	
												}
									            %>
								                </div>
							                </div>
						              	</div>
						            
						            <!-- Special Approval Required Ends -->
						            <!-- Consent Required Starts -->
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
								                <%
								              	//out.println("Consent required");
									            if(records[51].equalsIgnoreCase("Y")) // For Consent
												{ 
							                  		if(bean.checkForNull(bean.getTempvalue("consented"+orderCategoryCode),"false").equals("true")){
												%>
								                	<div class="ordFldHdrIconPos actionTickIcon"> <img src="${path}/eIPAD/images/Consent24x24.png" width="20" height="20" onclick="showConsentedMessage()"/> </div>
								                <% 
							                  		}
							                  		else{
						                  		%>
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/Consent24x24.png" width="20" height="20" onclick="showConsentMessage()"/> </div>
								                <% 
							                  			
							                  		}
												}
												else{
												%>
													<div class="ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/Consent24x24.png" width="20" height="20" /></div>
												<%	
												}
									            %>
								                </div>
							                </div>
						              	</div>
						            <!-- Consent Required Ends -->
						            
						            <!-- Explanatory Text Starts -->
						            
										<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
							                  	<%
									            if(!bean.checkForNull(records[62],"").equals("")) 
												{
												%>
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/About24x24.png" width="20" height="20"  /> </div>
								                <%
													//out.println("<br>Explanatory Text:  "+records[62]);  //Explanatory Text is there for this catalog 
												}
									            else{
									            %>
									            	<div class="ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/About24x24.png" width="20" height="20" /></div>
									            <%	
									            }
									            %>
								                </div>
							                </div>
						              	</div>
									
									
						            <!-- Explanatory Text Ends -->
						            
						            
										<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
							                  	<%
										            //Secondary orders
											 		secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass());
											 		if(bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
											 			//out.println("<br> Secondary orders are present");
											 			//out.println("<br> Secondary order catalog" +secondaryOrders[1]);
											 			//out.println("<br> Seondary orders startdatetime" +bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""));
							 					%>
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/SecondaryOrders24x24.png" width="20" height="20" /> </div>
											    <%
										 		}
										 		else{
										 			//out.println("<br> No secondary orders");
										 		%>
							 						<div class="ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/SecondaryOrders24x24.png" width="20" height="20" /> </div>
										 		<%
										 		}
										 		%>
								                </div>
							                </div>
						              	</div>
									
									
							 		
						            <% 
									Default = bean.getPlaceOrderDefault(records[0]);
									for(int j=0;j<Default.size();j++)
									{
										recordDefault	 = ((String[])Default.get(j));
										if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
						 				if(recordDefault!=null){
											qty_value		 = 	bean.checkForNull(recordDefault[8],"1");
											if(qty_value.equals("0")) qty_value = "1";
												qty_uom			 =  bean.checkForNull(recordDefault[9],"");
												qty_uom_shortdesc=  bean.checkForNull(recordDefault[10],"");
										}else{
											qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
										}
									} 
									//out.println("<BR>StartDate  ");
									//out.println((bean.getTempvalue("start_date_time"+records[0]))==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale):bean.getTempvalue("start_date_time"+records[0]));
									%>
						            
						            <%//billing values
							 		if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT") && show_bill_info_yn.equals("Y"))
									{
							 			//out.println("</br> Billing applicable");
							 			BillChargeInfo		= bean_qryobj.getBillChargeDetails(qty_value,records[0],dateString,locale, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ; // Calling the bean method, internally will call a procedure to get the Billing Informations
							 			if(BillChargeInfo!=null)
										{
							 				for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
											{
							 					billing_details 	= (String[])BillChargeInfo.get(k);
							 					setBills_dtls		= new HashMap();
							
							 					setBills_dtls.put("charged_yn"       , billing_details[1]);
							 					setBills_dtls.put("total_payable"    , billing_details[2]);
							 					setBills_dtls.put("patient_payable"  , billing_details[3]);
							 					setBills_dtls.put("quantity"         , qty_value);
							 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
							 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
							 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
												setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
												setBills_dtls.put("serv_panel_code"  , billing_details[11]);
												setBills_dtls.put("p_episode_type"	 , billing_details[13]);
												setBills_dtls.put("p_episode_id"	 , billing_details[14]);
												setBills_dtls.put("p_visit_id"		 , billing_details[15]);
												setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
												setBills_dtls.put("error_text"		 , billing_details[9]);
												setBills_dtls.put("rate"		 ,"");
												setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
												setBills_dtls.put("mod_physician_id"		 , billing_details[20]);
												orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 
											}
										}
							 			
							 			//out.println("<br> Total Cost:  "+bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0"));
							 			//out.println("<br> Patient Cost:"+bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0"));
							 		%>
							 		<div class="row">
										<div class="ordFldHdrPrice"> <span class="ordFldHdrPriceLblTheme">Order Price:</span> <span class="ordFldHdrPriceTxtTheme"><%=bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0") %></span> <span class="ordFldHdrPriceLblTheme">Patient Price:</span> <span class="ordFldHdrPriceTxtTheme"><%=bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0") %></span> </div>
						            </div>
							 			
							 		<%	
									}
						            %>
						            <%-- <%
							 		else{%>
							 		<div class="row">
										<div class="ordFldHdrPrice"> <span class="ordFldHdrPriceLblTheme">Billing Details not available</span></div>
						            </div>
							 		<%}%> --%>
						              	
						            </div>
					          	</div>
					        </div>
				      	</div>
				    </div>
  				</div>
  				<div  class="row">
    				<div class="ordFldHdrBorder"> </div>
  				</div>
			</div>
			<!-- Order Item Header Ends -->		
				
				
			
			
			<!-- Clinical Comments field Starts -->	
			<%
			String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N"); // For clinical cmts to be mandatory or not.
			String clinComments =  bean.checkForNull((String)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0"),"");	
			%>
		 	<div class="cstFieldRowContainer2" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel">Clinical Comments
		 					<%if(clin_cmts_reqd_yn.equals("Y")){%>
		 						<font style="color: red">*</font>
		 					<%} %>	
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer2 cstFieldContainerTheme">
		 						<textarea class="csttxtArea" maxlength="2000"  data-role="none" id="ClinComments" name="ClinComments" style="display: block" rows="50" cols="10"><%=clinComments.toString() %></textarea>
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>		
			<!-- Clinical Comments field Ends -->	
				
			<!-- Start date field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="StartDate-<%=records[0]%>_Label">Start Date<font style="color: red">*</font></div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
		 						<!-- Error Message Container for start date -->
								<div class="formValWarningTheme formValError" id="StartDate-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="StartDate-<%=records[0]%>_WarningMsg"></div>
								</div> 
								<input id="StartDate-<%=records[0]%>" name="StartDate-<%=records[0]%>" style="text-align:right" data-role="none" onchange=""
									data-errmsg1="Some Validation error Message" data-mandatory="true" /> 
									<script>
							            $(document).ready(function() {
							                // create DateTimePicker from input HTML element
							               // var today1 = new Date();
							                $("#StartDate-<%=records[0]%>").kendoDateTimePicker({
							        			format: "dd/MM/yyyy HH:mm",
							        			value: StringToDate('<%=bean.getTempvalue("start_date_time"+records[0])==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale):bean.getTempvalue("start_date_time"+records[0])%>')
							                });
							            });
							        </script>
							        <input type="hidden" id="hdnStartDateTime-<%=records[0]%>" name="hdnStartDateTime-<%=records[0]%>" value="">
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>
   	    					
   	    	<!-- Start Date field Ends -->
			
			<!-- End date field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabelDisable" id="EndDate-<%=records[0]%>_Label">End Date</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1 cstFieldContainerTheme cstFieldDull" >
		 						<!-- Error Message Container for onset date -->
								<div class="formValWarningTheme formValError" id="EndDate-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="EndDate-<%=records[0]%>_WarningMsg"></div>
								</div> 
								<input id="EndDate-<%=records[0]%>" name="EndDate-<%=records[0]%>" style="text-align:right" data-role="none" onchange=""
									data-errmsg1="Some validation error" data-mandatory="true" /> 
									<script>
							            $(document).ready(function() {
							                // create DateTimePicker from input HTML element
							               // var today1 = new Date();
							                $("#EndDate-<%=records[0]%>").kendoDateTimePicker({
							        			format: "dd/MM/yyyy HH:mm",
							                });
							                $("#EndDate-<%=records[0]%>").data("kendoDateTimePicker").readonly();
							            });
							        </script>
							        <input type="hidden" id="hdnEndDateTime-<%=records[0]%>" name="hdnEndDateTime-<%=records[0]%>" value="">
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>
   	    	<!-- End Date field Ends -->
				   	    	
				   	    	
		 	<!-- Order Type field Starts -->
		 	<%
		 	//Order type drop down - a disabled drop down
			PlaceOrderType = bean.getPlaceOrderType(records[0]);
		 	%>
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabelDisable" id="OrderType-<%=records[0]%>_Label">Order Type</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					
		 					<div class="cstFieldContainer1 cstFieldContainerTheme cstFieldDull">
		 						<!-- Error Message Container for complaint code -->
		 						<div class="formValWarningTheme formValError" id="OrderType-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="OrderType-<%=records[0]%>_WarningMsg"></div>
								</div> 
		 						<select id="OrderType-<%=records[0]%>" name="OrderType-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
								data-errmsg1="Some Error Message">
								
								<%
								for(int j=0; j<PlaceOrderType.size(); j++)
								{
									orderTypeRecords = (String[]) PlaceOrderType.get(j);
									if(orderTypeCode.equals(orderTypeRecords[0])){
								%>
									<option value="<%=orderTypeRecords[0]%>" selected><%=orderTypeRecords[1] %></option>
								<%
									}
									else{
								%>
									<option value="<%=orderTypeRecords[0]%>"><%=orderTypeRecords[1] %></option>
								<%
									}
									orderTypeRecords = null;
								}
								PlaceOrderType = null; 
								%>
									 
								</select>
				 				<script>
									$(document).ready(function() {
										$("#OrderType-<%=records[0]%>").kendoComboBox({
								  			dataTextField: "desc",
					                        dataValueField: "code",
					                        change: function(e) {
					                            var value = this.value();
					                            if(this.select()==-1){
					                            	this.value('');
					                            	$("#OrderType-<%=records[0]%>").val("");
					                            }
					                            else{
					                            	$("#OrderType-<%=records[0]%>").val(this.value());
					                            }
					                          },
										});
										 $("#OrderType-<%=records[0]%>").data("kendoComboBox").readonly();
					 				 });
								</script>

		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>			
			<!-- Order Type field Ends -->	
			
			<!-- Priority Field Starts -->	
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel">Priority</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;" >
		 					<div class="cstFieldContainer1" >
								<div  class="parent" data-role="none">
									<div id="PrioritySlider-<%=records[0]%>" class="scale scaleTheme2" data-role="none">
										<div data-role="none" class="Round roundTheme" id="PrioritySlidePointer-<%=records[0]%>" data-count="I" 
										data-parent = "PrioritySlider-<%=records[0]%>" data-numpoints="3" data-drag="Y" data-dragdiv="PriorityScaleHover-<%=records[0]%>" 
										data-valuefield="Priority-<%=records[0]%>" data-value1="R" data-value2="U" data-value3="S" data-defaultvalue="<%=bean.checkForNull(bean.getTempvalue("priority"+records[0]), "R") %>" 
										data-selstylelabel="slSelectedLabel"></div>
										<input type="hidden" id="Priority-<%=records[0]%>" name="Priority-<%=records[0]%>" value="">
										<div data-role="none" class="scaleHover scaleHoverTheme" id="PriorityScaleHover-<%=records[0]%>"></div>

										<div data-role="none" class="threescaleSeparator1 scaleSeparatorTheme"></div>
										<div data-role="none" class="threescaleSeparator2 scaleSeparatorTheme"></div>
										<div data-role="none" class="threescaleSeparator3 scaleSeparatorTheme"></div>

									</div>
									<!-- <div style="position: relative; width: 100%; height: 20px">
										<div style="position: absolute; left: 0.5%;" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-1">Normal</div>
										<div style="position: absolute; left: 45%" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-2">High</div>
										<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-3">Critical</div>
									</div> -->
									<div style="display:table;height:20px;width:100%;height:100%">
										<div style="display:table-row">
											<div style="display:table-cell;vertical-align:middle;text-align:left;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-<%=records[0]%>-1" data-labelval="1" >Routine</div>
											<div style="display:table-cell;vertical-align:middle;text-align:center;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-<%=records[0]%>-2" data-labelval="2" >Urgent</div>
											<div style="display:table-cell;vertical-align:middle;text-align:right;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-<%=records[0]%>-3" data-labelval="3" >Stat</div>
										</div>
									</div>
								</div>
		 					</div>
		 					<script>
		 						$(document).ready(function() {
		 							$('#PrioritySlidePointer-<%=records[0]%>').sliderGenericControl();
		 						});
		 					</script>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>			
   	    	<div class="cstRowDivider"></div>
   	    	<!-- Priority field Ends -->
			
			<!-- Quantity field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="Quantity-<%=records[0]%>_Label">Quantity<font style="color: red">*</font></div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
		 						<!-- Error Message Container for start date -->
								<div class="formValWarningTheme formValError" id="Quantity-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="Quantity-<%=records[0]%>_WarningMsg"></div>
								</div>
								<input type="hidden" id="QuantityReadOnlyYN-<%=records[0]%>" value="<%=records[10]%>" />
								<input id="Quantity-<%=records[0]%>" style="text-align:right" data-role="none" onchange=""
									data-errmsg1="Some Validation error Message" data-mandatory="true" type="number" class="cstNumericTxtBox" value="<%=bean.getTempvalue("quantity"+records[0])==null?qty_value:bean.getTempvalue("quantity"+records[0]) %>"/> 
									
		 					</div>
		 				</div>
		 				<!-- Unit of Measure -->
		 				<div style="display:table-cell;width:10%" class="cstUomTxtTheme">
		 				<%
			 				if (qty_uom.equals("")) 
							{	
								out.println(records[68]);
							}					
						    else
							{
						    	out.println(qty_uom_shortdesc);
							}
						%>
		 				</div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>
   	    					
   	    	<!-- Quantity field Ends -->
   	    	
   	    	<!-- Frequency field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="Frequency-<%=records[0]%>_Label">Frequency</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					
		 					<div class="cstFieldContainer1 cstFieldContainerTheme">
		 						<!-- Error Message Container for complaint code -->
		 						<div class="formValWarningTheme formValError" id="Frequency-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="Frequency-<%=records[0]%>_WarningMsg"></div>
								</div> 
							<%
							if(patientDischargedYn.equalsIgnoreCase("N"))
							{
							%>
								<select id="Frequency-<%=records[0]%>" name="Frequency-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
								data-errmsg1="Some Error Message">
								<%
								PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
								for(int j=0; j<PlaceOrderFrequency.size(); j++)
								{
									frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
									
									if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
									{
										//out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
								%>	
									<option value="<%=frequencyRecords[0]%>" selected><%=frequencyRecords[1] %></option>	
								<%	}
									else
									{%>
									<option value="<%=frequencyRecords[0]%>"><%=frequencyRecords[1] %></option>	
										
								<%	
								//out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
									}
								}
								%>
								</select>
								<%
							}
							else{
								//out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
							%>
								<select id="Frequency-<%=records[0]%>" name="Frequency-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
								data-errmsg1="Some Error Message" disabled>
								</select>
							<%
							}
								
							%>
				 				<script>
									$(document).ready(function() {
										$("#Frequency-<%=records[0]%>").kendoComboBox({
								  			dataTextField: "desc",
					                        dataValueField: "code",
					                        change: function(e) {
					                            var value = this.value();
					                            if(this.select()==-1){
					                            	this.value('');
					                            	$("#Frequency-<%=records[0]%>").val("");
					                            }
					                            else{
					                            	//$("#Frequency").val(this.value());
					                            }
					                          },
										});
										 //$("#Frequency").data("kendoComboBox").readonly();
					 				 });
								</script>

		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>	
			<!-- Frequency field Ends -->	
			
			<!-- Duration field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="Duration-<%=records[0]%>_Label">Duration</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1" >
		 						<div style="display:table;width:100%;height:100%">
		 							<div style="display:table-row;">
		 								<div style="display:table-cell;width:60%">
		 									<div class="cstFieldContainerTheme cstFieldContainer3">
 												<!-- Error Message Container for complaint code -->
						 						<div class="formValWarningTheme formValError" id="Duration-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="Duration-<%=records[0]%>_WarningMsg"></div>
												</div> 
											
												<select id="Duration-<%=records[0]%>" name="Duration-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
												data-errmsg1="Some Error Message">
												
													
												
												</select>
												
								 				<script>
													$(document).ready(function() {
														$("#Duration-<%=records[0]%>").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            	$("#Duration-<%=records[0]%>").val("");
									                            }
									                            else{
									                            	//$("#Frequency").val(this.value());
									                            }
									                          },
														});
														 $("#Duration-<%=records[0]%>").data("kendoComboBox").readonly();
									 				 });
												</script>
		 									</div>
		 								</div>
		 								<div style="display:table-cell;vertical-align:middle;">
		 									<div class="cstFieldContainerTheme cstFieldContainer1 ">
		 										<input id="DurationNum-<%=records[0]%>" style="text-align:right" data-role="none" onchange=""
													data-errmsg1="Some Validation error Message" data-mandatory="true" type="number" class="cstNumericTxtBox"/> 
		 									</div>
		 								</div>
		 								
		 							</div>
		 						</div>
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>

   	    	<div class="cstRowDivider"></div>
   	    	<!-- Duration field Ends -->
   	    	
   	    	<!-- Performing Location field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="PerformingLocation-<%=records[0]%>_Label">Performing Location</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1" >
		 						<div style="display:table;width:100%;height:100%">
		 							<div style="display:table-row;">
		 								<div style="display:table-cell;width:50%">
		 									<div class="cstFieldContainerTheme cstFieldContainer3">
 												<!-- Error Message Container for complaint code -->
						 						<div class="formValWarningTheme formValError" id="PerformingLocation-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="PerformingLocation-<%=records[0]%>_WarningMsg"></div>
												</div> 
												
												<select id="PerformingLocation-<%=records[0]%>" name="PerformingLocation-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
												data-errmsg1="Some Error Message">
												
												<%
												//Performing location
												if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ){ 	
										 			performingLocationCode = bean.getPerformingLocation(orderCategoryCode,orderTypeCode,records[0]);
										 			for(int j=0; j<performingLocationCode.size(); j++)
													{
										 				performingLocation	= (String[]) performingLocationCode.get(j);
										 			%>
										 			<option value="<%=performingLocation[0] %>" ><%=performingLocation[1] %></option>	
										 			
										 			<% 	} %>
										 		</select>
										 		<input type="hidden" name="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" value="N">
										 			<% 
												}
										 		else{
										 			%>
										 			<option value="<%=records[5]%>" ><%=bean.getPerformingFacilityName(records[5]) %></option>
										 			</select>
										 			<input type="hidden" name="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" value="Y">
										 		<% 
										 		}
												
												fac_selected = bean.getTempvalue("performing_facility_id"+records[0])==null?login_facility_id:bean.getTempvalue("performing_facility_id"+records[0]);
												%>
												
												<script>
													$(document).ready(function() {
														$("#PerformingLocation-<%=records[0]%>").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            }
									                          },
									                          value:"<%=fac_selected%>",
														});
														if($("#hdnPerformingLocReadOnly-<%=records[0]%>").val()=="Y"){
															$("#PerformingLocation-<%=records[0]%>").data("kendoComboBox").readonly(true);
														}
									 				 });
													
												</script>
		 									</div>
		 								</div>
		 								<div style="display:table-cell;vertical-align:middle;">
		 									<div class="cstFieldContainerTheme cstFieldContainer1 ">
		 										<select id="PerformingDept-<%=records[0]%>" name="PerformingDept-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
												data-errmsg1="Some Error Message">
		 									<%//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
									 		if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ||(orderCategoryCode.equals("MI"))||(orderCategoryCode.equals("PC")) || (orderCategoryCode.equals("OT"))) 
											{ 	
									 			//out.println("<br> performing department drop dowm");
									 			
									 			DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],orderCategoryCode,orderTypeCode,rd_instal_yn);
									 			for(int j=0; j<DeptLocationCode.size(); j++)
												{	
									 				deptLocation	= (String[]) DeptLocationCode.get(j); %>
									 			
									 				<option value="<%=deptLocation[0] %>" ><%=deptLocation[1] %></option>	
											<%	} %>
												</select>
												<input type="hidden" id="hdnPerformingDeptReadOnly-<%=records[0]%>" name="hdnPerformingDeptReadOnly-<%=records[0]%>" value="N">
											<% }
									 		else{
									 			//out.println("<br> performing department input field is not shown/empty in this case");
									 		%>
									 		</select>
									 			<input type="hidden" id="hdnPerformingDeptReadOnly-<%=records[0]%>" name="hdnPerformingDeptReadOnly-<%=records[0]%>" value="Y">
									 		<%}%>
												
												</select>
								 				<script>
													$(document).ready(function() {
														$("#PerformingDept-<%=records[0]%>").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            	//$("#PerformingLocation").val("");
									                            }
									                            else{
									                            	//$("#Frequency").val(this.value());
									                            }
									                          },
														});
														if($("#hdnPerformingDeptReadOnly-<%=records[0]%>").val()=="Y"){
															$("#PerformingDept-<%=records[0]%>").data("kendoComboBox").readonly(true);
														}
														 //$("#Frequency").data("kendoComboBox").readonly();
									 				 });
												</script> 
		 									</div>
		 								</div>
		 								
		 							</div>
		 						</div>
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>

   	    	<div class="cstRowDivider"></div>
   	    	<!-- Performing Location field Ends -->
			
			
			
			
				
				<%
				/* out.println("<BR>OrderCategory  " + records[3]);
				out.println("<BR>OrderType  " + records[4]);
				out.println("<BR>OrderCatalogDesc " + records[1]); */
				
				
				
				
				//Priority drop down -- Selected bean.getTempvalue("priority"+records[0])
				/* out.println("<br> Priority drop down items ");
				if ( !((records[52]).equals("3"))) {
					out.println("<br> Item : Routine");
				}
				if (((records[52]).equals("")) || ((records[52]).equals("2"))) {
					out.println("<br> Item : Urgent");
				}
				if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
					out.println("<br> Item : Stat");
				} */
				//Quantity -- Stored value bean.getTempvalue("quantity"+records[0]) or qty_value
				/* out.println("<br>  Quantlity Value: " +bean.getTempvalue("quantity"+records[0])==null?qty_value:bean.getTempvalue("quantity"+records[0]));
				if(records[10].equalsIgnoreCase("N")) {
					out.println("Quantity value is READONLY");
				}
				if (qty_uom.equals("")) 
				{	
					out.println("<br> Unit of Measure: "+records[68]);
				}					
			    else
				{
			    	out.println("<br> Unit of Measure: "+qty_uom_shortdesc);
				} */
				// Frequency drop down -- selected bean.getTempvalue("frequency_code"+records[0])
				/* if(patientDischargedYn.equalsIgnoreCase("N"))
				{
					PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
					for(int j=0; j<PlaceOrderFrequency.size(); j++)
					{
						frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
						
						if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
						{
							out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
							
						}
						else
						{
							out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
						}
					}
				}
				else{
					out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
				} */
				//NOTE: OrderEntryValidate.jsp func_mode=DURATIONVALUES populates the duration dropdown which is a disabled one
				// Inside the JS fuction setFrequency(obj,i,catalog_code,facility_id,val) they set the value of duration_code dropdown
				//QID~~D~~1~~4~~D~~Y~~O value[1] - DurationCode  value[5]=="Y" schedule mandatory
				//-----------
				
				//Duration value Text box -small text box with max length 3
				//if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
				//if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
				//if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
				//if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
				//if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
				//if(recordDefault!=null && recordDefault[0].equals("")) out.println("<br> Duration text box is readOnly");
				//out.println("<br> Duration text box value" + bean.getTempvalue("duration_value"+records[0])==null?duration_value:bean.getTempvalue("duration_value"+records[0]));
				//out.println("<br> Duration text box max_durn_value" +max_durn_value);
				//out.println("<br> Duration text box chk_for_max_durn_action" +chk_for_max_durn_action);
				//out.println("<br> Duration text box prompt_msg" +prompt_msg);
				//out.println("<br> Duration text box comments" +comments);
				//validations to be performed: js function checkMaxValue(obj,max_durn_value,chk_for_max_durn_action,prompt_msg,soft_stop_yn,row_value,catcode)
				//Only after this duration value is entered, end time is automatically computed using JS
				//0 value is not allowed
				//calculate end time JS function calculateEndDateTime(start_date_time,duration_code,duration_value,row_value,'');
				//if duration value > max value then prompt is displayed
				
				//duration dropdown populated using script
				
				/* format_id = bean.checkForNull(records[47],"");
				if(!records[47].trim().equals(""))
				{
		     		stFormatID 	= new StringTokenizer(records[47],"~");
		     		while(stFormatID.hasMoreTokens())
		     		{
		     			format_id_mandatory_yn  = stFormatID.nextToken();
		     			format_id 				= stFormatID.nextToken();
		     			//out.println("<br> formate id ??????????"+format_id);
		     		}
					stFormatID = null;// Nullifying the objects
		 		} */
		 		//out.println("<br> Format contains Mandatory Items" + format_id_mandatory_yn);
		 		
		 		//consent related code line 1478 to 1568
		 		//TODO
		 		
		 		
		 		
		 		//end date - read only textbox
		 		
		 		
		 		//Performing location
				/* if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ){ 	
		 			//out.println("<br> performing location dropdown:");
		 			performingLocationCode = bean.getPerformingLocation(orderCategoryCode,orderTypeCode,records[0]);
		 			for(int j=0; j<performingLocationCode.size(); j++)
					{
		 				performingLocation	= (String[]) performingLocationCode.get(j);
		 				out.println("</br>dropdown items"+performingLocation[0]+"::"+performingLocation[1]);
		 				
					}
		 			if(bean.getTempvalue("performing_facility_id"+records[0])==null)//Facility was not selected
					{
		 				out.println("</br>selected facility is login facilty id " + login_facility_id);
		 				fac_selected = login_facility_id;
		 				
					}
		 			else{
		 				out.println("</br>selected facility is from bean" + bean.getTempvalue("performing_facility_id"+records[0]));
		 				fac_selected = bean.getTempvalue("performing_facility_id"+records[0]);
		 			}
		 			
				}
		 		else{
		 			
		 			out.println("<br> performing location static text:");
		 			out.println("</br> "+bean.getPerformingFacilityName(records[5])+"::"+records[5]);
		 		}
		 		
		 		//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
		 		if((orderCategoryCode.equals("LB") )|| (orderCategoryCode.equals("RD")) || (orderCategoryCode.equals("RX"))||(orderCategoryCode.equals("TR")) ||(orderCategoryCode.equals("MI"))||(orderCategoryCode.equals("PC")) || (orderCategoryCode.equals("OT"))) 
				{ 	
		 			out.println("<br> performing department drop dowm");
		 			
		 			DeptLocationCode = bean.getPerformingDeptLocation(fac_selected,records[0],orderCategoryCode,orderTypeCode,rd_instal_yn);
		 			for(int j=0; j<DeptLocationCode.size(); j++)
					{	
		 				deptLocation	= (String[]) DeptLocationCode.get(j);
		 				out.println("<br> dropdown item: "+deptLocation[0]+"::"+deptLocation[1]+"::"+deptLocation[2]);
					}
		 			//if()
				}
		 		else{
		 			out.println("<br> performing department input field is not shown");
		 		} */
		 		
		 		%>
		 		
		 		
		 		
		 		
		 		<%-- <jsp:include page="/eIPAD/jsp/chartwidgets/orders/MoeItemAdditionalFields.jsp">
				    <jsp:param name="OrderCatalogCode" value="<%=records[0] %>"/>
				    <jsp:param name="OrderTypeCode" value="<%=records[4] %>"/>
				    <jsp:param name="OrderCatCode" value="<%=records[3] %>"/>
				    <jsp:param name="FormatId" value="<%=format_id %>"/>
				</jsp:include> --%>
				
		 		
		<%	}
			else{
				//TODO no place order items
			}
		}else if(orderCategoryCode.equals("CS")){
			
			ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
			ArrayList PlaceOrderSetItems 	= null;
			String[] care_set_group			= null;
			String order_set_order_catalog	= "";
			String order_type_catalog 		= "";
			String[] reqd_or_opt_ind		= null; // To store the value required/optional/deselected
			String[] rel_start_date_time	= null; // To store the start_date_time TODO- check if required
			String[] start_time				= null; // To store the hours(So that it can be used when the header is changed ) TODO- check if required
			
			String billing_interface_yn		= bean.getBillingInterfaceYn();
			String billing_order_set_details[] = bean.getOrderSetBillDetails(orderCatalogCode);
			String order_set_bill_yn = OrderEntryBean.checkForNull(billing_order_set_details[1],"N");
			String care_set_catalog_desc = OrderEntryBean.checkForNull(billing_order_set_details[0],"");
			String charge_yn = OrderEntryBean.checkForNull(billing_order_set_details[2],"");
			String PerformingFacilityName = (String)bean.getPerformingFacilityName(login_facility_id);
			
			String displayNone = "display:none";
			
			if(charge_yn.equalsIgnoreCase("N"))
			{
				order_set_bill_yn = "N";
			}
			%>
			<!-- Order Item Header Starts -->	
			<div class="ordFldHeader">
  				<div class="ordFldHdrRow">
				    <div class="cell">
				    	<div class="ordFldHdrTbl">
							<div class="row">
				          		<div class="ordFldHdrTxtCell">
						        	<div class="ordFldHdrTitleTheme"><%=care_set_catalog_desc%></div>
						            <div class="ordFldHdrPractTbl">
										<div class="ordFldHdrPractCell">
										 	<div class="ordFldHdrPractLblTheme">Attend. Practitioner </div>
										  	<div class="ordFldHdrPractTxtTheme"><%=bean.getPractitionerName()%></div>
										</div>
										<div class="ordFldHdrPractCell">
										  	<div class="ordFldHdrPractLblTheme">Ordering Practitioner </div>
										  	<div class="ordFldHdrPractTxtTheme"><%=bean.getPractitionerName()%></div>
										</div>
						            </div>
				          		</div>
				          		
				          		
					          	<div class="ordFldHdrIconCell">
					          		<div class="ordFldHdrIconHolder">
					          		<!-- Authorization Required Starts -->
						            
						            <%-- <%
						          	//Authorization
									speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
									if(speciality.size()>0)
									{
										for(int sc=0;sc<speciality.size();sc++)
										{
												speciality_code=(String[])speciality.get(sc);
										}
									}
						            //out.println("<br>Authorizaion is required"); 
									if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
									{ 
									%>
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/Apr.png" width="20" height="20" /> </div>
								                </div>
							                </div>
						              	</div>
						            <% 
									}
						            %>
						            <!-- Authorization Required Ends -->
						            
						            <!-- Cosign Required Starts -->
						            <%
						            //out.println("<br>cosign is required"); 
						            if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y")) // For Cosign Required
									{ 
									%>
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/Apr.png" width="20" height="20" /> </div>
								                </div>
							                </div>
						              	</div>
						            <% 
									}
						            %>
						            <!-- Cosign Required Ends -->
						            
						            <!-- Special Approval Required Starts -->
						            <%
						            //out.println("<br>spl approval is required"); 
						            if(records[50].equalsIgnoreCase("Y")) // For Special Approval
									{ 
									%>
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/Apr.png" width="20" height="20" /> </div>
								                </div>
							                </div>
						              	</div>
						            <% 
									}
						            %>
						            <!-- Special Approval Required Ends -->
						            <!-- Consent Required Starts -->
						            <%
						            //out.println("Consent required");
						            if(records[51].equalsIgnoreCase("Y")) // For Consent
									{ 
									%>
						              	<div class="row" style="float: right;">
							                <div class="cell">
							                  	<div class="ordFldHdrIconCircTheme">
								                	<div class="ordFldHdrIconPos"> <img src="${path}/eIPAD/images/Apr.png" width="20" height="20" /> </div>
								                </div>
							                </div>
						              	</div>
						            <% 
									}
						            %>
						            <!-- Consent Required Ends --> --%>
						            
						            <%//billing values
						            if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !orderCategoryCode.equals("BT") && show_bill_info_yn.equals("Y"))
									{
							 			//out.println("</br> Billing applicable");
							 			BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ;
							 			if(BillChargeInfo!=null)
										{
											for( int m=0 ; m< BillChargeInfo.size() ; m++ )
											{
							 					billing_details 	= (String[])BillChargeInfo.get(m);
							 					setBills_dtls		= new HashMap();
							
							 					setBills_dtls.put("charged_yn"       , billing_details[1]);
							 					setBills_dtls.put("total_payable"    , billing_details[2]);
							 					setBills_dtls.put("patient_payable"  , billing_details[3]);
							 					setBills_dtls.put("quantity"         , qty_value);
							 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
							 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
							 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
							 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
							 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
							 					setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
							 					setBills_dtls.put("serv_panel_code"  , billing_details[11]);
							 					setBills_dtls.put("p_episode_type"	 , billing_details[13]);
							 					setBills_dtls.put("p_episode_id"	 , billing_details[14]);
							 					setBills_dtls.put("p_visit_id"		 , billing_details[15]);
							 					setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
							 					setBills_dtls.put("rate"		 ,"");
							 					setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
							 					setBills_dtls.put("mod_physician_id"		 , billing_details[20]);

												orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code, setBills_dtls); 
												
											}
										}
							 			
							 			//out.println("<br> Total Cost:  "+bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0"));
							 			//out.println("<br> Patient Cost:"+bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0"));
							 		%>
							 		<div class="row">
										<div class="ordFldHdrPrice"> <span class="ordFldHdrPriceLblTheme">Order Price:</span> <span class="ordFldHdrPriceTxtTheme"><%=bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0") %></span> <span class="ordFldHdrPriceLblTheme">Patient Price:</span> <span class="ordFldHdrPriceTxtTheme"><%=bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0") %></span> </div>
						            </div>
							 			
							 		<%	
									}
							 		else{%>
							 		<!-- <div class="row">
										<div class="ordFldHdrPrice"> <span class="ordFldHdrPriceLblTheme">Billing Details not available</span></div>
						            </div> -->
							 		<%}%>
						              	
						            </div>
					          	</div>
					        </div>
				      	</div>
				    </div>
  				</div>
  				<div  class="row">
    				<div class="ordFldHdrBorder"> </div>
  				</div>
			</div>
			<!-- Order Item Header Ends -->	
			
			<!-- Clinical Comments field Starts -->	
			<%
			//to determine whether clinical comments is mandatory
			String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N"); // For clinical cmts to be mandatory or not.
			if(PlaceOrdercareSetCount!=null && !clin_cmts_reqd_yn.equals("Y"))			
			{
				for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					String care_set_ordcat = care_set_count[1];
					String care_set_clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, care_set_ordcat),"N");
					if(care_set_clin_cmts_reqd_yn.equals("Y")){
						clin_cmts_reqd_yn = "Y";
						break;
					}
				}
			}
			
			
			%>
		 	<div class="cstFieldRowContainer2" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel">Clinical Comments
		 					<%if(clin_cmts_reqd_yn.equals("Y")){%>
		 						<font style="color: red">*</font>
		 					<%} %>	
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer2 cstFieldContainerTheme">
		 						<textarea class="csttxtArea" maxlength="2000"  data-role="none" id="txtRemarks" name="txtRemarks" style="display: block" rows="50" cols="10"></textarea>
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>		
			<!-- Clinical Comments field Ends -->		
			
			<%
			/* if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !orderCategoryCode.equals("BT") && show_bill_info_yn.equals("Y"))
			{
				out.println("<br> Billing applicable");
				BillChargeInfo		= bean_qryobj.getBillChargeDetails("1",order_catalog_code,dateString,localeName, "", "",bean.getPatientId(),bean.getEncounterId(),bean.getPatientClass(),bean.getPractitionerId()) ;
				if(BillChargeInfo!=null)
				{
					for( int m=0 ; m< BillChargeInfo.size() ; m++ )
					{
	 					billing_details 	= (String[])BillChargeInfo.get(m);
	 					setBills_dtls		= new HashMap();
	
	 					setBills_dtls.put("charged_yn"       , billing_details[1]);
	 					setBills_dtls.put("total_payable"    , billing_details[2]);
	 					setBills_dtls.put("patient_payable"  , billing_details[3]);
	 					setBills_dtls.put("quantity"         , qty_value);
	 					setBills_dtls.put("incl_excl_action" , billing_details[4]);
	 					setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
	 					setBills_dtls.put("preapp_yn"        , billing_details[5]);
	 					setBills_dtls.put("patient_paid_amt" , billing_details[6]);
	 					setBills_dtls.put("bl_panel_str"     , billing_details[0]);
						setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
						setBills_dtls.put("serv_panel_code"  , billing_details[11]);
						setBills_dtls.put("p_episode_type"	 , billing_details[13]);
						setBills_dtls.put("p_episode_id"	 , billing_details[14]);
						setBills_dtls.put("p_visit_id"		 , billing_details[15]);
						setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
						setBills_dtls.put("rate"		 ,"");
						setBills_dtls.put("excl_incl_ind_for_screen"		 ,billing_details[4]);
						setBills_dtls.put("mod_physician_id"		 , billing_details[20]);

						//orderEntryBillBean.setOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0], setBills_dtls); 
						
					}
				}
	 			
	 			out.println("<br> Total Cost:  "+bean.checkForNull((String)setBills_dtls.get("total_payable"),"0.0"));
	 			out.println("<br> Patient Cost:"+bean.checkForNull((String)setBills_dtls.get("patient_payable"),"0.0"));
			}else{
				out.println("<br> Billing not applicable");
			}
			 */
			 
			 
			 
			 
			if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
			{
				int tabCount;
				%>
				<div style="display:table;width:100%;" class="widgetTabNonActiveTheme">
					<div class="widgetleftview">
				<%
				tabCount = 0;
				for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");
					format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
					 
					if(!format_id.trim().equals("") )
					{
						stFormat = new StringTokenizer(format_id,"~");
						while(stFormat.hasMoreTokens())
	 					{
	 						format_id_mandatory_yn	 	= stFormat.nextToken();
	 						format_id 	 	 			= stFormat.nextToken();
	 					}
						stFormat = null;
	 				}
	 				/* if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
	 					out.println("<br> Order Format has mandatory header items  " +care_set_count[2]);
	 				else
	 					out.println("<br> Order Format does not has mandatory header items  "+care_set_count[2]); */
	 				String time_frame = "";
	 				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
	 				
	 				reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
					rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
					start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time
							
	 				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
					{
	 					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
						order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
					    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					    reqd_or_opt_ind[k]		= care_set_group[5];
					    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
					    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation
					}
	 				if(order_set_order_catalog.length() > 0)
						order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
					if(order_type_catalog.length() > 0)
						order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
					
					PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"");
					if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
					{
						for(int i=0; i<PlaceOrderItems.size(); i++)
						{	
							records		= (String[])PlaceOrderItems.get(i);
							if(tabCount==0){
						%>
								<div style="display:table-cell;" class="widgetTab widgetTabActiveTheme" id="OrderSetTab<%=records[0] %>" onclick="showOrderSetTab('<%=records[0]%>')"><div class="widgetItemTxt"><%=records[1] %></div></div>
								<input type="hidden" id="CurrentOpenTab" value="<%=records[0] %>"/>
						<%
							}
							else{
						%>		
								<div style="display:table-cell;" class="widgetTab widgetTabNonActiveTheme" id="OrderSetTab<%=records[0] %>" onclick="showOrderSetTab('<%=records[0]%>')"><div class="widgetItemTxt"><%=records[1] %></div></div>
						<%		
							}
							tabCount++;
						}
						%>
								
						<%
					}
					order_set_order_catalog = ""; // Remove the values
					order_type_catalog			 = ""; // Remove the values
				}
				tabCount = 0;
				%>
				<div style="display:table-cell;width:98%"></div>
							</div>
						</div>
				<%
				for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
				{
					care_set_count = (String[])PlaceOrdercareSetCount.get(t);
					order_types_comb	= bean.checkForNull(bean.getCareSetOrderTypes(order_catalog_code),"");
					format_id = bean.checkForNull(bean.getFormatIdHdr(care_set_count[1],order_types_comb, bean.getSex(), bean.getDob()),""); //order_category
					 
					if(!format_id.trim().equals("") )
					{
						stFormat = new StringTokenizer(format_id,"~");
						while(stFormat.hasMoreTokens())
	 					{
	 						format_id_mandatory_yn	 	= stFormat.nextToken();
	 						format_id 	 	 			= stFormat.nextToken();
	 					}
						stFormat = null;
	 				}
	 				/* if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equals("Y"))
	 					out.println("<br> Order Format has mandatory header items  " +care_set_count[2]);
	 				else
	 					out.println("<br> Order Format does not has mandatory header items  "+care_set_count[2]); */
	 				String time_frame = "";
	 				PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
	 				
	 				reqd_or_opt_ind 	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the reqd_or_opt_ind
					rel_start_date_time	= new String[PlaceOrderSetItems.size()]; //Assigning the size for the rel_start_date_time
					start_time			= new String[PlaceOrderSetItems.size()]; //Assigning the size for the start_time
							
	 				for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
					{
	 					care_set_group 			= (String[])PlaceOrderSetItems.get(k);
						order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
					    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
					    reqd_or_opt_ind[k]		= care_set_group[5];
					    rel_start_date_time[k]	= care_set_group[10]; // Here the start_date_time is calculated with the sysdate + rel_start_date_time
					    start_time[k]			= care_set_group[11]; // Here the start_time is taken to be stored in the hidden field so that when the header date/time is changed, can be used for calculation
					}
	 				if(order_set_order_catalog.length() > 0)
						order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
					if(order_type_catalog.length() > 0)
						order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
					
					PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),"");
					if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
					{
						
						
						for(int i=0; i<PlaceOrderItems.size(); i++)
						{	
							records		= (String[])PlaceOrderItems.get(i);
							orderCatalogCodes = orderCatalogCodes + records[0] + ",";
							/* out.println("<BR>OrderCategory  " + records[3]);
							out.println("<BR>OrderType  " + records[4]);
							out.println("<BR>OrderCatalogDesc " + records[1]+"--"+records[0]);
							if(records[51].equalsIgnoreCase("Y")){
								out.println("<br> Consent required");
							}
							 */
							Default = bean.getPlaceOrderSetDefault(records[0],order_catalog_code);
							for(int j=0;j<Default.size();j++)
							{
								recordDefault	 = ((String[])Default.get(j));					
								if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
								if(recordDefault!=null){
									qty_value	 = 	bean.checkForNull(recordDefault[8],"1");
									if(qty_value.equals("0")) qty_value = "1";
									qty_uom		 =  bean.checkForNull(recordDefault[9],"");
									qty_uom_shortdesc =  bean.checkForNull(recordDefault[10],"");
								}else{
									qty_value	 = "1"; qty_uom= ""; qty_uom_shortdesc="";
								}
							}
							/* out.println("<br> State of check box -- "+records[1]);
							if(reqd_or_opt_ind[i].equalsIgnoreCase("R"))
							{
								out.println("<br> Y CHECKED DISABLED");
							}
							else if(reqd_or_opt_ind[i].equalsIgnoreCase("O"))
							{
								out.println("<br> Y CHECKED NOTDISABLED");
							}
							else if(reqd_or_opt_ind[i].equalsIgnoreCase("D"))
							{
								out.println("<br> N NOTCHECKED NOTDISABLED");
							} */
							
							
							//out.println("<BR>StartDate  "+com.ehis.util.DateUtils.convertDate(rel_start_date_time[i],"DMYHM","en",localeName));%>
			<%if(tabCount==0) {%>
			<div id="OrderSetFieldWrap<%=records[0]%>">
			<%}else{%>
			<div id="OrderSetFieldWrap<%=records[0]%>" style="<%=displayNone%>">	
			<%}%>
			<%-- <%=records[0]%> --%>
			<!-- Start date field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="StartDate-<%=records[0]%>_Label">Start Date<font style="color: red">*</font></div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
		 						<!-- Error Message Container for start date -->
								<div class="formValWarningTheme formValError" id="StartDate-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="StartDate-<%=records[0]%>_WarningMsg"></div>
								</div> 
								<input id="StartDate-<%=records[0]%>" name="StartDate-<%=records[0]%>"  style="text-align:right" data-role="none" onchange=""
									data-errmsg1="Some Validation error Message" data-mandatory="true" /> 
									<script>
							            $(document).ready(function() {
							                // create DateTimePicker from input HTML element
							               // var today1 = new Date();
							                $("#StartDate-<%=records[0]%>").kendoDateTimePicker({
							        			format: "dd/MM/yyyy HH:mm",
							        			value: StringToDate('<%=bean.getTempvalue("start_date_time"+records[0])==null?com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",locale):bean.getTempvalue("start_date_time"+records[0])%>')
							                });
							            });
							        </script>
							        <input type="hidden" id="hdnStartDateTime-<%=records[0]%>" name="hdnStartDateTime-<%=records[0]%>" value="">
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>
   	    					
   	    	<!-- Start Date field Ends -->
   	    	
   	    	<!-- End date field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabelDisable" id="EndDate-<%=records[0]%>_Label">End Date</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1 cstFieldContainerTheme cstFieldDull" >
		 						<!-- Error Message Container for onset date -->
								<div class="formValWarningTheme formValError" id="EndDate-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="EndDate-<%=records[0]%>_WarningMsg"></div>
								</div> 
								<input id="EndDate-<%=records[0]%>" name="EndDate-<%=records[0]%>" style="text-align:right" data-role="none" onchange="validate(this)"
									data-errmsg1="Some validation error" data-mandatory="true" /> 
									<script>
							            $(document).ready(function() {
							                // create DateTimePicker from input HTML element
							               // var today1 = new Date();
							                $("#EndDate-<%=records[0]%>").kendoDateTimePicker({
							        			format: "dd/MM/yyyy HH:mm",
							                });
							                $("#EndDate-<%=records[0]%>").data("kendoDateTimePicker").readonly();
							            });
							        </script>
							        <input type="hidden" id="hdnEndDateTime-<%=records[0]%>" name="hdnEndDateTime-<%=records[0]%>" value="">
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>
   	    	<!-- End Date field Ends -->
   	    	
   	    	<!-- Order Type field Starts -->
		 	<%
		 	//Order type drop down - a disabled drop down
			PlaceOrderType = bean.getPlaceOrderType(records[0]);
		 	%>
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabelDisable" id="OrderType-<%=records[0]%>_Label">Order Type</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					
		 					<div class="cstFieldContainer1 cstFieldContainerTheme cstFieldDull">
		 						<!-- Error Message Container for complaint code -->
		 						<div class="formValWarningTheme formValError" id="OrderType-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="OrderType-<%=records[0]%>_WarningMsg"></div>
								</div> 
		 						<select id="OrderType-<%=records[0]%>" name="OrderType-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
								data-errmsg1="Some Error Message">
								
								<%
								for(int j=0; j<PlaceOrderType.size(); j++)
								{
									orderTypeRecords = (String[]) PlaceOrderType.get(j);
									if(orderTypeCode.equals(orderTypeRecords[0])){
								%>
									<option value="<%=orderTypeRecords[0]%>" selected><%=orderTypeRecords[1] %></option>
								<%
									}
									else{
								%>
									<option value="<%=orderTypeRecords[0]%>"><%=orderTypeRecords[1] %></option>
								<%
									}
								}
								PlaceOrderType = null; 
								%>
									 
								</select>
				 				<script>
									$(document).ready(function() {
										$("#OrderType-<%=records[0]%>").kendoComboBox({
								  			dataTextField: "desc",
					                        dataValueField: "code",
					                        change: function(e) {
					                            var value = this.value();
					                            if(this.select()==-1){
					                            	this.value('');
					                            	$("#OrderType-<%=records[0]%>").val("");
					                            }
					                            else{
					                            	$("#OrderType-<%=records[0]%>").val(this.value());
					                            }
					                          },
										});
										 $("#OrderType-<%=records[0]%>").data("kendoComboBox").readonly();
					 				 });
								</script>

		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>			
			<!-- Order Type field Ends -->	
			
			<!-- Priority Field Starts -->	
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel">Priority</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;" >
		 					<div class="cstFieldContainer1" >
								<div  class="parent" data-role="none">
									<div id="PrioritySlider-<%=records[0]%>" class="scale scaleTheme2" data-role="none">
										<div data-role="none" class="Round roundTheme" id="PrioritySlidePointer-<%=records[0]%>" data-count="I" 
										data-parent = "PrioritySlider-<%=records[0]%>" data-numpoints="3" data-drag="Y" data-dragdiv="PriorityScaleHover-<%=records[0]%>" 
										data-valuefield="Priority-<%=records[0]%>" data-value1="R" data-value2="U" data-value3="S" data-defaultvalue="<%=bean.checkForNull(bean.getTempvalue("priority"+records[0]), "R") %>" 
										data-selstylelabel="slSelectedLabel"></div>
										<input type="hidden" id="Priority-<%=records[0]%>" name="Priority-<%=records[0]%>" value="">
										<div data-role="none" class="scaleHover scaleHoverTheme" id="PriorityScaleHover-<%=records[0]%>"></div>

										<div data-role="none" class="threescaleSeparator1 scaleSeparatorTheme"></div>
										<div data-role="none" class="threescaleSeparator2 scaleSeparatorTheme"></div>
										<div data-role="none" class="threescaleSeparator3 scaleSeparatorTheme"></div>

									</div>
									<!-- <div style="position: relative; width: 100%; height: 20px">
										<div style="position: absolute; left: 0.5%;" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-1">Normal</div>
										<div style="position: absolute; left: 45%" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-2">High</div>
										<div style="position: absolute; right: 1%" class = "dvSliderLabel" data-labelfor="PrioritySlidePointer-3">Critical</div>
									</div> -->
									<div style="display:table;height:20px;width:100%;height:100%">
										<div style="display:table-row">
											<div style="display:table-cell;vertical-align:middle;text-align:left;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-<%=records[0]%>-1" data-labelval="1" >Routine</div>
											<div style="display:table-cell;vertical-align:middle;text-align:center;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-<%=records[0]%>-2" data-labelval="2" >Urgent</div>
											<div style="display:table-cell;vertical-align:middle;text-align:right;width:33%" class="dvSliderLabel" data-labelfor="PrioritySlidePointer-<%=records[0]%>-3" data-labelval="3" >Stat</div>
										</div>
									</div>
								</div>
		 					</div>
		 					<script>
		 						$(document).ready(function() {
		 							$('#PrioritySlidePointer-<%=records[0]%>').sliderGenericControl();
		 						});
		 					</script>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>			
   	    	<div class="cstRowDivider"></div>
   	    	<!-- Priority field Ends -->
   	    
			<!-- Quantity field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="StartDate-<%=records[0]%>_Label">Quantity<font style="color: red">*</font></div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1 cstFieldContainerTheme" >
		 						<!-- Error Message Container for start date -->
								<div class="formValWarningTheme formValError" id="Quantity-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="Quantity-<%=records[0]%>_WarningMsg"></div>
								</div>
								<input type="hidden" id="QuantityReadOnlyYN-<%=records[0]%>" value="<%=records[10]%>" />
								<input id="Quantity-<%=records[0]%>" style="text-align:right" data-role="none" onchange=""
									data-errmsg1="Some Validation error Message" data-mandatory="true" type="number" class="cstNumericTxtBox" value="<%=qty_value %>" 
									pattern="[0-9]" <%if(records[10].equals("N")){%> readOnly='readonly' <%}%> onkeypress="return isNumberKey(event)"/> 
									
		 					</div>
		 				</div>
		 				<!-- Unit of Measure -->
		 				<div style="display:table-cell;width:10%" class="cstUomTxtTheme">
		 				<%
			 				if (qty_uom.equals("")) 
							{	
								out.println(records[68]);
							}					
						    else
							{
						    	out.println(qty_uom_shortdesc);
							}
						%>
		 				</div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>
   	    					
   	    	<!-- Quantity field Ends -->	
   	    	
   	    	<!-- Frequency field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="Frequency-<%=records[0]%>_Label">Frequency</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					
		 					<div class="cstFieldContainer1 cstFieldContainerTheme">
		 						<!-- Error Message Container for complaint code -->
		 						<div class="formValWarningTheme formValError" id="Frequency-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
									<div class="formValErrorMsgTheme" id="Frequency-<%=records[0]%>_WarningMsg"></div>
								</div> 
							<%
							if(patientDischargedYn.equalsIgnoreCase("N"))
							{
							%>
								<select id="Frequency-<%=records[0]%>" name="Frequency-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
								data-errmsg1="Some Error Message">
								<%
								PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","","","","");
								for(int j=0; j<PlaceOrderFrequency.size(); j++)
								{
									frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
									
									if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
									{
										//out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
								%>	
									<option value="<%=frequencyRecords[0]%>" selected><%=frequencyRecords[1] %></option>	
								<%	}
									else
									{%>
									<option value="<%=frequencyRecords[0]%>"><%=frequencyRecords[1] %></option>	
										
								<%	
								//out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
									}
								}
								%>
								</select>
								<%
							}
							else{
								//out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
							%>
								<select id="Frequency-<%=records[0]%>" name="Frequency-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
								data-errmsg1="Some Error Message" disabled>
								</select>
							<%
							}
								
							%>
				 				<script>
									$(document).ready(function() {
										$("#Frequency-<%=records[0]%>").kendoComboBox({
								  			dataTextField: "desc",
					                        dataValueField: "code",
					                        change: function(e) {
					                            var value = this.value();
					                            if(this.select()==-1){
					                            	this.value('');
					                            	$("#Frequency-<%=records[0]%>").val("");
					                            }
					                            else{
					                            	//$("#Frequency").val(this.value());
					                            }
					                          },
										});
										 //$("#Frequency").data("kendoComboBox").readonly();
					 				 });
								</script>

		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>
   	    	<div class="cstRowDivider"></div>	
			<!-- Frequency field Ends -->	
			
			<!-- Duration field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="Duration-<%=records[0]%>_Label">Duration</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1" >
		 						<div style="display:table;width:100%;height:100%">
		 							<div style="display:table-row;">
		 								<div style="display:table-cell;width:60%">
		 									<div class="cstFieldContainerTheme cstFieldContainer3">
 												<!-- Error Message Container for complaint code -->
						 						<div class="formValWarningTheme formValError" id="Duration-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="Duration-<%=records[0]%>_WarningMsg"></div>
												</div> 
											
												<select id="Duration-<%=records[0]%>" name="Duration-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
												data-errmsg1="Some Error Message">
												
													
												
												</select>
												
								 				<script>
													$(document).ready(function() {
														$("#Duration-<%=records[0]%>").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            	$("#Duration-<%=records[0]%>").val("");
									                            }
									                            else{
									                            	//$("#Frequency").val(this.value());
									                            }
									                          },
														});
														 $("#Duration-<%=records[0]%>").data("kendoComboBox").readonly();
									 				 });
												</script>
		 									</div>
		 								</div>
		 								<div style="display:table-cell;vertical-align:middle;">
		 									<div class="cstFieldContainerTheme cstFieldContainer1 ">
		 										<input id="DurationNum-<%=records[0]%>" style="text-align:right" data-role="none" onchange=""
													data-errmsg1="Some Validation error Message" data-mandatory="true" type="number" class="cstNumericTxtBox"/> 
		 									</div>
		 								</div>
		 								
		 							</div>
		 						</div>
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>

   	    	<div class="cstRowDivider"></div>
   	    	<!-- Duration field Ends -->
   	    	
   	    	
   	    	<!-- Performing Location field Starts -->
   	    	<div class="cstFieldRowContainer" data-role="none">
				<div style="display:table;width:100%">
					<div style="display:table-row">
		 				<div style="display:table-cell;width:30%;text-align:right;vertical-align:middle">
		 					<div class="cstFieldLabel" id="PerformingLocation-<%=records[0]%>_Label">Performing Location</div>
		 				</div>
		 				<div style="display:table-cell;width:60%;">
		 					<div class="cstFieldContainer1" >
		 						<div style="display:table;width:100%;height:100%">
		 							<div style="display:table-row;">
		 								<div style="display:table-cell;width:50%">
		 									<div class="cstFieldContainerTheme cstFieldContainer3">
 												<!-- Error Message Container for complaint code -->
						 						<div class="formValWarningTheme formValError" id="PerformingLocation-<%=records[0]%>_Warning" style="top: 45px; left: 0px; display: none">
													<div class="formValErrorMsgTheme" id="PerformingLocation-<%=records[0]%>_WarningMsg"></div>
												</div> 
												
												<select id="PerformingLocation-<%=records[0]%>" name="PerformingLocation-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
												data-errmsg1="Some Error Message">
												
												<%
												//Performing location
												if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) { 	
													performingLocationCode = bean.getPerformingLocation(care_set_count[1],orderTypeRecords[0],records[0]);
										 			for(int j=0; j<performingLocationCode.size(); j++)
													{
										 				performingLocation	= (String[]) performingLocationCode.get(j);
										 			%>
										 			<option value="<%=performingLocation[0] %>" ><%=performingLocation[1] %></option>	
										 			
										 			<% 	} %>
										 		</select>
										 		<input type="hidden" name="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" value="N">
										 			<% 
												}
										 		else{
										 			%>
										 			<option value="<%=records[5]%>" ><%=bean.getPerformingFacilityName(records[5]) %></option>
										 			</select>
										 			<input type="hidden" name="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" id="hdnPerformingLocReadOnly-<%=records[0]%>" value="Y">
										 		<% 
										 		}
												
												fac_selected = bean.getTempvalue("performing_facility_id"+records[0])==null?records[5]:bean.getTempvalue("performing_facility_id"+records[0]);
												%>
												
												<script>
													$(document).ready(function() {
														$("#PerformingLocation-<%=records[0]%>").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            }
									                          },
									                          value:"<%=fac_selected%>",
														});
														if($("#hdnPerformingLocReadOnly-<%=records[0]%>").val()=="Y"){
															$("#PerformingLocation-<%=records[0]%>").data("kendoComboBox").readonly(true);
														}
									 				 });
													
												</script>
		 									</div>
		 								</div>
		 								<div style="display:table-cell;vertical-align:middle;">
		 									<div class="cstFieldContainerTheme cstFieldContainer1 ">
		 										<select id="PerformingDept-<%=records[0]%>" name="PerformingDept-<%=records[0]%>" data-type="ComboBox" data-role="none" data-mandatory="false" onchange=""
												data-errmsg1="Some Error Message">
		 									<%//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
		 									if((care_set_count[1].equals("LB") )|| (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX"))||(care_set_count[1].equals("TR")) ||(care_set_count[1].equals("MI"))||(care_set_count[1].equals("PC"))) 
											{ 	
									 			//out.println("<br> performing department drop dowm");
									 			
									 			DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],orderTypeRecords[0],rd_instal_yn);
									 			for(int j=0; j<DeptLocationCode.size(); j++)
												{	
									 				deptLocation	= (String[]) DeptLocationCode.get(j);%>
									 				
									 				<option value="<%=deptLocation[0] %>" ><%=deptLocation[1] %></option>	
											<%	} %>
												</select>
												<input type="hidden" id="hdnPerformingDeptReadOnly-<%=records[0]%>" name="hdnPerformingDeptReadOnly-<%=records[0]%>" value="N">
											<% }
									 		else{
									 			//out.println("<br> performing department input field is not shown/empty in this case");
									 		%>
									 		</select>
									 			<input type="hidden" id="hdnPerformingDeptReadOnly-<%=records[0]%>" name="hdnPerformingDeptReadOnly-<%=records[0]%>" value="Y">
									 		<%}%>
												
												</select>
								 				<script>
													$(document).ready(function() {
														$("#PerformingDept-<%=records[0]%>").kendoComboBox({
												  			dataTextField: "desc",
									                        dataValueField: "code",
									                        change: function(e) {
									                            var value = this.value();
									                            if(this.select()==-1){
									                            	this.value('');
									                            	//$("#PerformingLocation").val("");
									                            }
									                            else{
									                            	//$("#Frequency").val(this.value());
									                            }
									                          },
														});
														if($("#hdnPerformingDeptReadOnly-<%=records[0]%>").val()=="Y"){
															$("#PerformingDept-<%=records[0]%>").data("kendoComboBox").readonly(true);
														}
														 //$("#Frequency").data("kendoComboBox").readonly();
									 				 });
												</script> 
		 									</div>
		 								</div>
		 								
		 							</div>
		 						</div>
		 					</div>
		 				</div>
		 				<div style="display:table-cell;width:10%"></div>
		 			</div>
   	    		</div>
   	    	</div>

   	    	<div class="cstRowDivider"></div>
   	    	<!-- Performing Location field Ends -->
		</div>
						
							<%-- <%
							//Authorization related code
							speciality=(ArrayList)bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd);
							if(speciality.size()>0)
							{
								for(int sc=0;sc<speciality.size();sc++)
								{
										speciality_code=(String[])speciality.get(sc);
								}
							}
							if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
							{
								out.println("<br>Authorizaion is required"); 
							}
							//Order type drop down - a disabled drop down
							PlaceOrderType = bean.getPlaceOrderType(records[0]);
							for(int j=0; j<PlaceOrderType.size(); j++)
							{
								orderTypeRecords = (String[]) PlaceOrderType.get(j);
								if(records[4].equals(orderTypeRecords[0]))
									out.println("<br> Ordertype drop down item: Default"+orderTypeRecords[0]+" - "+orderTypeRecords[1]);
								else
									out.println("<br> Ordertype drop down item: "+orderTypeRecords[0]+" - "+orderTypeRecords[1]);
							}
							//Priority drop down -- Selected bean.getTempvalue("priority"+records[0])
							out.println("<br> Priority drop down items ");
							if ( !((records[52]).equals("3"))) {
								out.println("<br> Item : Routine");
							}
							if (((records[52]).equals("")) || ((records[52]).equals("2"))) {
								out.println("<br> Item : Urgent");
							}
							if (((records[52]).equals("")) || ((records[52]).equals("3"))) {
								out.println("<br> Item : Stat");
							}
							
							
							
							// Frequency drop down -- selected bean.getTempvalue("frequency_code"+records[0])
							if(patientDischargedYn.equalsIgnoreCase("N"))
							{
								PlaceOrderFrequency = bean.getPlaceOrderFrequency(records[0],"","",care_set_count[1],records[4],recordDefault[0]);
								for(int j=0; j<PlaceOrderFrequency.size(); j++)
								{
									frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
									if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
									{
										frequency_val = frequencyRecords[2];
										out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
									}
									else
									{
										if(recordDefault != null && recordDefault[0].equalsIgnoreCase(frequencyRecords[2]))
										{
											frequency_val = recordDefault[0];
											out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
										}
										else
										{
											frequency_val = "";
											out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
										}
									}	
									if(recordDefault!=null && (recordDefault[0].equalsIgnoreCase(frequencyRecords[2]) ||  (bean.getTempvalue("frequency_code"+records[0])!=null&& bean.getTempvalue("frequency_code"+records[0]).equals(frequencyRecords[0]))))
									{
										out.println("<br> Frequency Item: Selected -- "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
										
									}
									else
									{
										out.println("<br> Frequency Item: "+frequencyRecords[0]+" - "+frequencyRecords[1]+" ");
									}
								}
							}
							else{
								out.println("<br> Patient discharged, hence frequency dropdown disabled and empty");
							}
							
							//NOTE: OrderEntryValidate.jsp func_mode=DURATIONVALUES populates the duration dropdown which is a disabled one
							// Inside the JS fuction setFrequency(obj,i,catalog_code,facility_id,val) they set the value of duration_code dropdown
							//QID~~D~~1~~4~~D~~Y~~O value[1] - DurationCode  value[5]=="Y" schedule mandatory
							//-----------
							
							//Duration value Text box -small text box with max length 3
							if(care_set_count[1].equals("PH") && records[4].equals("MS") && recordDefault[0].equals(""))
							{
								duration_value = "90";
							}
							else
							{
								if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
								if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
								if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
								if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
							}
							out.println("<br> Duration text box value" + bean.getTempvalue("duration_value"+records[0])==null?duration_value:bean.getTempvalue("duration_value"+records[0]));
							out.println("<br> Duration text box max_durn_value" +max_durn_value);
							out.println("<br> Duration text box chk_for_max_durn_action" +chk_for_max_durn_action);
							out.println("<br> Duration text box prompt_msg" +prompt_msg);
							out.println("<br> Duration text box comments" +comments);
							//validations to be performed: js function checkMaxValue(obj,max_durn_value,chk_for_max_durn_action,prompt_msg,soft_stop_yn,row_value,catcode)
							//Only after this duration value is entered, end time is automatically computed using JS
							//0 value is not allowed
							//calculate end time JS function calculateEndDateTime(start_date_time,duration_code,duration_value,row_value,'');
							//if duration value > max value then prompt is displayed
							
							//duration dropdown populated using script
							
							format_id = bean.checkForNull(records[47],"");
							format_id_mandatory_yn = "N";
							if(!records[47].trim().equals(""))
							{
					     		stFormatID 	= new StringTokenizer(records[47],"~");
					     		while(stFormatID.hasMoreTokens())
					     		{
					     			format_id_mandatory_yn  = stFormatID.nextToken();
					     			format_id 				= stFormatID.nextToken();
					     		}
								stFormatID	= null;
					 		}
							
							out.println("<br> Format contains Mandatory Items" + format_id_mandatory_yn);

							//consent multiconsent related code line 826 to 916
					 		//TODO
					 		
					 		
							//Secondary orders
					 		secondaryOrders = beanQueryObj.getSecondaryOrdersYN(properties, records[0], bean.getPatientClass());
					 		if(bean.checkForNull((String)secondaryOrders[0]).equals("Y")){
					 			out.println("<br> Secondary orders are present");
					 			out.println("<br> Secondary order catalog" +secondaryOrders[1]);
					 			out.println("<br> Seondary orders startdatetime" +bean.checkForNull(beanQueryObj.getSecondaryOrdersStartDateTime(properties, records[0],"R",bean.getPatientClass()),""));
					 		}
					 		else{
					 			out.println("<br> No secondary orders");
					 		}
							
					 		//end date - read only textbox
							out.println("<br> End Date time read only textbox calculated using js function calculateEndDateTime('"+rel_start_date_time[i]+"','D','90',"+i+",'')");
							
					 		
					 		
							//Performing location
							if( (care_set_count[1].equals("LB")) || (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX")) || (care_set_count[1].equals("TR")) ) { 	
					 			out.println("<br> performing location dropdown:");
					 			performingLocationCode = bean.getPerformingLocation(care_set_count[1],orderTypeRecords[0],records[0]);
					 			for(int j=0; j<performingLocationCode.size(); j++)
								{
					 				performingLocation	= (String[]) performingLocationCode.get(j);
					 				out.println("</br>dropdown items"+performingLocation[0]+"::"+performingLocation[1]);
					 				
								}
					 			if(bean.getTempvalue("performing_facility_id"+records[0])==null)//Facility was not selected
								{
					 				out.println("</br>Facility was not selected, hence selected facility is  " + records[5]);
					 				
								}
					 			else{
					 				out.println("</br>selected facility is from bean" + bean.getTempvalue("performing_facility_id"+records[0]));
					 			}
					 			
							}
					 		else{
					 			
					 			if(login_facility_id.equalsIgnoreCase(records[5]))
									facility_name = PerformingFacilityName;
								else
									facility_name = bean.getPerformingFacilityName(records[5]);
					 			out.println("<br> performing location static text:");
					 			out.println("</br> "+facility_name+"::"+records[5]);
					 		}
							
							//Performing department -- selected bean.getTempvalue("performing_dept_loc_code"+records[0]) or deptLocation[2].equals("Y") then it is the default departement value
					 		if((care_set_count[1].equals("LB") )|| (care_set_count[1].equals("RD")) || (care_set_count[1].equals("RX"))||(care_set_count[1].equals("TR")) ||(care_set_count[1].equals("MI"))||(care_set_count[1].equals("PC"))) 
							{ 	
					 			out.println("<br> performing department drop dowm");
					 			
					 			DeptLocationCode = bean.getPerformingDeptLocation(records[5], records[0],care_set_count[1],orderTypeRecords[0],rd_instal_yn);
					 			for(int j=0; j<DeptLocationCode.size(); j++)
								{	
					 				deptLocation	= (String[]) DeptLocationCode.get(j);
					 				out.println("<br> dropdown item: "+deptLocation[0]+"::"+deptLocation[1]+":Default:"+deptLocation[2]);
								}
					 			//if()
							}
					 		else{
					 			out.println("<br> performing department input field is not shown");
					 		}%> --%>
							
							
							
					 		<%-- <jsp:include page="/eIPAD/jsp/chartwidgets/orders/MoeItemAdditionalFields.jsp">
							    <jsp:param name="OrderCatalogCode" value="OrderCatalogCode22"/>
							    <jsp:param name="OrderTypeCode" value="OrderTypeCode22"/>
							    <jsp:param name="OrderCatCode" value="OrderCatCode22"/>
							</jsp:include> --%>
							
						<%
						tabCount++;
						}
					}
					order_set_order_catalog = ""; // Remove the values
					order_type_catalog			 = ""; // Remove the values
				}
			
				
					}
				}

		
		//orderCatalogCodes = orderCatalogCodes.substring(0, orderCatalogCodes.length()-1);
	/* 	if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
			for(int i=0; i<PlaceOrderItems.size(); i++)
			{	
				records		= (String[])PlaceOrderItems.get(i);
				format_id = bean.checkForNull(records[47],"");
				OrderFormat				= bean.getOrderFormat(format_id,records[3],"","","","R",bean.getSex(), bean.getDob(),login_facility_id,records[0],records[4],patient_id);
			}
		}
		 */
		

%>



						 	
				   	    	
				   	    	
						 	
						
					<!-- Mandatory fields error -->
					<div class="formValErrorTheme formValError" id="MandatoryFields_Error" style="bottom: 10px; left: 2%; display: none">
						<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All mandatory fields must be entered</div>
					</div>
				<!-- </div> -->
				<input type="hidden" name="authorized<%=orderCategoryCode %>" id="authorized<%=orderCategoryCode %>" id="authorized<%=orderCategoryCode %>" value="<%=bean.checkForNull(bean.getTempvalue("authorized"+orderCategoryCode),"false")%>" />
				<input type="hidden" name="consented<%=orderCategoryCode %>" id="consented<%=orderCategoryCode %>" id="consented<%=orderCategoryCode %>" value="<%=bean.checkForNull(bean.getTempvalue("consented"+orderCategoryCode),"false")%>" />
				<input type="hidden" name="cosigned<%=orderCategoryCode %>" id="cosigned<%=orderCategoryCode %>" id="cosigned<%=orderCategoryCode %>" value="<%=bean.checkForNull(bean.getTempvalue("cosigned"+orderCategoryCode),"false")%>" />
				<input type="hidden" name="special_approved<%=orderCategoryCode %>" id="special_approved<%=orderCategoryCode %>" id="special_approved<%=orderCategoryCode %>" value="<%=bean.checkForNull(bean.getTempvalue("special_approved"+orderCategoryCode),"false")%>" />
				
				<input type="hidden" name="OrderCatalogCode" id="OrderCatalogCode" id="OrderCatalogCode" value="<%=orderCatalogCode %>" />
				<input type="hidden" name="OrderTypeCode" id="OrderTypeCode" id="OrderTypeCode" value="<%=orderTypeCode %>" />
				<input type="hidden" name="OrderCatCode" id="OrderCatCode" id="OrderCatCode" value="<%=orderCategoryCode %>" />
				<input type="hidden" name="or_bean_id" id="or_bean_id" id="or_bean_id" value="<%=or_bean_id %>" />
				<input type="hidden" name="or_bean_name" id="or_bean_name" id="or_bean_name" value="<%=or_bean_name %>" />
				
				<!-- Selected Order Catalog Codes are accumulated as CSV  -->
				<input type="hidden" name="OrderCatalogCodes" id="OrderCatalogCodes" id="OrderCatalogCodes" value="<%=orderCatalogCodes %>" />
				<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
		</form>
	<!-- </div> -->
	</div>
	</div>
<%
	}else{
		/* validationResponse.setValidationStatus(MOrderEntryValidationResponse.VALIDATION_ERROR); */
	}
}
catch(Exception e){
	/* validationResponse.setValidationStatus(MOrderEntryValidationResponse.VALIDATION_STATUS_FETCH_FAILURE); */
	out.println(e.getMessage());
}


%>	


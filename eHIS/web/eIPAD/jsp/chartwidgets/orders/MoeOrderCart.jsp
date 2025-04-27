<!DOCTYPE html>
<%@page import="java.util.Map.Entry"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse"%>
<%@page import="eIPAD.chartsummary.orderentry.bc.MOrderEntryBC"%>
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
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
%>





<%
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
String or_bean_name = "eOR.OrderEntryBean";
OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
String key							= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For New Orders) to keep the Value in the Bean
HashMap previousValues 				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
HashMap catHashMap = bean.getOrderCategories(previousValues); //Get all the categories that are present in the selected orders

Properties properties				= (Properties) session.getValue( "jdbc" );
ArrayList OrderCategoryArr			= beanQueryObj.getOrderCategory(properties); // Get the Order category
MOrderEntryBC mObc = new MOrderEntryBC();
MOrderEntryFieldResponse orderCatsResp = mObc.getAllOrderCategories(bean, true);
HashMap hmOrderCategory				= new HashMap();
String billing_interface_yn		= bean.getBillingInterfaceYn();
String[] records;
HashMap bill_dtls				= null;
ArrayList speciality=new ArrayList();
ArrayList specialityOS=new ArrayList();
String speciality_code[]=new String[3];
String specialty_code = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");
String auth_reqd				= "";
eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
if(orderCatsResp!=null && orderCatsResp.getResponseStatus()!= orderCatsResp.FIELD_DATAFETCH_FAILURE){
	ArrayList<MOrderEntryFieldItem> orderCats = orderCatsResp.getFieldItems();
	for(int i=0;i<orderCats.size(); i++) 
	{
		MOrderEntryFieldItem catItem = orderCats.get(i);
		hmOrderCategory.put(catItem.getCode(), catItem.getDesc());
	} // end of for
} // end of if 

%> 

<script>

var ordEntryCartScroll;
function initOrderCartScroller() {
	ordEntryCartScroll = new IScroll('#cartWrapper', { 
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

function removeOrdersFromArray_cartpage(mode,code){
	
}
$(document).ready(function() {
	fillPriceValues();
	initOrderCartScroller();
	initSpecialActions();
});


function initSpecialActions(){//status check for authorization Special approve and cosign
	$("[data-authorized-cat]").each(function(index, value){//Each Category Header
		var catCode = $(this).data("authorized-cat");
		var status="NA";
		$("[data-authorized-"+catCode+"]").each(function(index, value){//Each item under category
			var thisStatus =  $(this).data("authorized-"+catCode);
			if(thisStatus!="NA"){
				if(thisStatus=="Y"){
					status = "Y";
				}else if(thisStatus=="N"){
					status = "N";
				}
			}
		});
		if(status=="NA"){
			$(this).addClass("imgGrayscale");
			$(this).data("authorized-status-"+catCode,"NA");
			
		}else if(status=="Y"){
			$(this).addClass("actionTickIcon");
			$(this).data("authorized-status-"+catCode,"Y");
		}
	});
	
	$("[data-special_approved-cat]").each(function(index, value){//Each Category Header
		var catCode = $(this).data("special_approved-cat");
		var status="NA";
		$("[data-special_approved-"+catCode+"]").each(function(index, value){//Each item under category
			var thisStatus =  $(this).data("special_approved-"+catCode);
			if(thisStatus!="NA"){
				if(thisStatus=="Y"){
					status = "Y";
				}else if(thisStatus=="N"){
					status = "N";
				}
			}
		});
		if(status=="NA"){
			$(this).addClass("imgGrayscale");
			$(this).data("special_approved-status-"+catCode,"NA");
			
		}else if(status=="Y"){
			$(this).addClass("actionTickIcon");
			$(this).data("special_approved-status-"+catCode,"Y");
		}
	});
	
	$("[data-cosigned-cat]").each(function(index, value){//Each Category Header
		var catCode = $(this).data("cosigned-cat");
		var status="NA";
		$("[data-cosigned-"+catCode+"]").each(function(index, value){//Each item under category
			var thisStatus =  $(this).data("cosigned-"+catCode);
			if(thisStatus!="NA"){
				if(thisStatus=="Y"){
					status = "Y";
				}else if(thisStatus=="N"){
					status = "N";
				}
			}
		});
		if(status=="NA"){
			$(this).addClass("imgGrayscale");
			$(this).data("cosigned-status-"+catCode,"NA");
			
		}else if(status=="Y"){
			$(this).addClass("actionTickIcon");
			$(this).data("cosigned-status-"+catCode,"Y");
		}
	});
	
}


function catSpecificSpecialActions(actionType,catCode,value){//specialActions Ajax call
	
	var obj = $("[data-"+actionType+"-status-"+catCode+"]");
	var status = obj.data(actionType+"-status-"+catCode);
	if(actionType && (status == "N")){
		var specialAction = function(){
			closeConfirmDialog(); //ajax call
			var actionUrl = path + "/eIPAD/jsp/chartwidgets/orders/MoeSetTempValues.jsp?key="+actionType+catCode.toUpperCase()+"&value="+value;
			$.ajax({
		        url: actionUrl,
		        success: function(response) {
						//response action starts
						obj.addClass("actionTickIcon");
						obj.data(actionType+"-status-"+catCode,"Y");
						$("[data-"+actionType+"-cat]").each(function(index, value){//Each Category Header
			        		var catCode = $(this).data("special_approved-cat");
			        		$("[data-"+actionType+"-"+catCode+"]").each(function(index, value){//Each item under category
			        			var thisStatus =  $(this).data(actionType+"-"+catCode);
			        				 if(thisStatus=="N"){
			        					 $(this).addClass("actionTickIcon");
			        					 $(this).data(actionType+"-status-"+catCode,"Y");
			        				}
			        			});
			        		});
						//response action ends
				},
				error: function (xhr, ajaxOptions, thrownError) {
				alert("Error in performing special actions");
				}
			});//end ajax  
		};
		$("#OrderConfirmDialog").configureConfirmDialog({
			callBackForTrue: specialAction
		});
    	
    	if(actionType == "authorized"){
			var errorMsg = "Do you want to Authorize all Orders under this category?";
			showConfirmDialog(errorMsg);
		}
		if(actionType == "special_approved"){
			
			var errorMsg = "Do you want to Special Approve all Orders under this category?";
			showConfirmDialog(errorMsg);
		
		}
		if(actionType == "cosigned"){
			var errorMsg = "Do you want to Cosign all Orders under this category?";
			showConfirmDialog(errorMsg);
		}
	}		 
	}

function controlMore(cat){//specialActions Strip control
	$("#strip"+cat).toggle();
	 if($("#strip"+cat).is(":visible")){
		 $("#test"+cat).addClass("MoeBlur");
		 $("#StripControlcontainer"+cat).hide();
		 $("#OCCatBgDiv"+cat).show();
	 }
	 else{
		 $("#test"+cat).removeClass("MoeBlur");
		 $("#StripControlcontainer"+cat).show();
	 }
}
function closeMoreDots(cat){//specialActions Strip Close
	 if($("#strip"+cat).is(":visible")){
		 $("#strip"+cat).hide();
		 $("#test"+cat).removeClass("MoeBlur");
		 $("#StripControlcontainer"+cat).show();
		 $("#OCCatBgDiv"+cat).hide();
	 }
}
function controlMoreOS(cat){ //Order Set Special Actions Strip Control
	$("#stripOS"+cat).toggle();
	 if($("#stripOS"+cat).is(":visible")){
		
		 $("#testOS"+cat).addClass("MoeBlur");
		 $("#StripControlcontainerOS"+cat).hide();
		 $("#fakeDivOS"+cat).show();
	 }
	 else{
		 $("#testOS"+cat).removeClass("MoeBlur");
		 $("#StripControlcontainerOS"+cat).show();
	 }
}
function closeMoreDotsOS(cat){//Order Set Special Actions Strip Close
	 if($("#stripOS"+cat).is(":visible")){
		 $("#stripOS"+cat).hide();
		 $("#testOS"+cat).removeClass("MoeBlur");
		 $("#StripControlcontainerOS"+cat).show();
		 $("#fakeDivOS"+cat).hide();
	 }
}

function fillPriceValues(){
	$("[data-tp-cat]").each(function(index, value){//Each Category Header
		var catCode = $(this).data("tp-cat");
		if(catCode!="cs"){
			var totalPrice = 0.0;
			$("[data-itemtp-"+catCode+"]").each(function(index, value){ //Each Individual Item under that category
				totalPrice = totalPrice + parseFloat($(this).data("itemtp-"+catCode));
			});
			if(totalPrice>0){
				$(this).html(totalPrice.toFixed(1));
				//$("#OrdCatPriceBlock_"+catCode).show();
			}
			$(this).data("tp-"+catCode,totalPrice.toFixed(1));
		}
		
	});
	
	$("[data-pp-cat]").each(function(index, value){//Each Category Header
		var catCode = $(this).data("pp-cat");
		if(catCode!="cs"){
		var totalPrice = 0.0;
		$("[data-itempp-"+catCode+"]").each(function(index, value){ //Each Individual Item under that category
			totalPrice = totalPrice + parseFloat($(this).data("itempp-"+catCode));
		});
		if(totalPrice>0){
			$(this).html(totalPrice.toFixed(1));
			//$("#OrdCatPriceBlock_"+catCode).show();
		}
		$(this).data("pp-"+catCode,totalPrice.toFixed(1));
		}
	});
	
	//Total Price
	var totalPrice = 0.0;
	$("[data-tp-cat]").each(function(index, value){
		var catCode = $(this).data("tp-cat");
		totalPrice = totalPrice + parseFloat($(this).data("tp-"+catCode));
	});
	$("#OrdTotalTP").html(totalPrice.toFixed(1));
	totalPrice = 0.0;
	$("[data-pp-cat]").each(function(index, value){
		var catCode = $(this).data("pp-cat");
		totalPrice = totalPrice + parseFloat($(this).data("pp-"+catCode));
	});
	$("#OrdTotalPP").html(totalPrice.toFixed(1));
	
}

function showExpOrderItems(cat){
	
	if($("#OrdItemsExp"+cat).is(':visible')){
		$("#OrdItemsToggleArrow"+cat).removeClass("MoeIHEC_Downarrow").addClass("MoeIHEC_Uparrow");
		$("#OrdItemsExp"+cat).hide();
	}
	else{
		$("#OrdItemsToggleArrow"+cat).removeClass("MoeIHEC_Uparrow").addClass("MoeIHEC_Downarrow");
		$("#OrdItemsExp"+cat).show();
	}
	ordEntryCartScroll.refresh();
}

</script>

<body style="display: block; margin: 0px; height: 100%; width: 100%;" >
<form id="ChartSummaryForm" name = "ChartSummaryForm" method = "post" action = "" class="ChartSummaryFormElem">
<div data-role = "none" id = "dvMez" class = "blurPopup" onclick="" data-popid=""></div>
<div id="OrdSearchSFS" class="orderSearchSfs" style="display:none" >
	<div id="sfsarrow" data-role="none" class="sfs-bubble-arrow sfs-bubble-arrowIPTheme"></div>
	<div data-role="none" class="ordSfsSmall sfsIPTheme"  style="display:block">
		<iframe id="sfsFrame" frameborder="0" style = "display:block;" scrolling ="no" height="300px" width="340px" src="${path}/eIPAD/jsp/chartwidgets/orders/MoeAddlSearchCrit.jsp"></iframe>  
	</div> 
</div>

<div class="ordSelParent"> 
	<!--  Header START-->
	<div class="ordSelHeaderMenu">
		<div class="ordSelHeaderMenuCont">
			<div class="row">
				<div class="ordSelMenuCont">
					<div class="ordSelMenuIconbg">
						<div class="ordSelMenuIcon"> </div>
					</div>
				</div>
				<div class="ordCartMenuCont ordSelMenuTitle">Selected Orders</div>
			</div>
		</div>
	</div>
	<!--  Header END--> 
	<div class="ordSelItemsCont">
    	<div class="ordItemsCont">
    		<div class="MoeSelectOrder" >
    		<!-- Scrolling item START -->
				<div class="MoeSelectOrderItem MoeSelectOrderItemTheme">
				    <div class="MoeContainer">
	 					<div class="MoeMain">
				        	<div class="MoeSOI_List">
								<div class="MoeSOI_List_c clearfix">
									<div id="cartWrapper" style="">
										<div id="cartScroller">
											<%
											if(catHashMap!=null && !catHashMap.isEmpty()){ 
												for(Object code:catHashMap.keySet()){
												    String order_category = (String)code;
												    String order_category_desc = (String)hmOrderCategory.get(order_category);
											%>
														           
											<%
										    if(!order_category.equals("CS")){
										    	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
										    	String practitioner_type = bean.getPractitionerType();
										    	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
										    	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),""); // Last parameter to identify normalOE or from preview
									    	
										    	
										    	if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
											%>

												<div class="MoeHeader MoeHeaderTheme" style="position:relative">
              										<div class="MoeHTitle">
                										<div class="cell"  style="position:absolute; width:100%;">
                											<div class="table"  id="test<%=order_category %>"  style="position:absolute;">
               													<div class="row" >
                													<div class="MoeIHclose" id="IHclose" onclick="removeOrder('CAT','<%=order_category%>')"></div>
													                <div class="MoeHTitlecell" id="OHTitlecell">
																		<div class="MoeOHTTable">
													                    	<div class="MoeOHTRowtop">
													                      		<div class="MoeOHTCell1">
													                        		<div class="MoeIHTitle MoeIHTitleTheme"><%=order_category_desc %></div>
													                        		<div class="MoeIHCountCont">
													                          			<div class="MoeIHcount MoeIHcountTheme"><%=PlaceOrderItems.size() %></div>
													                        		</div>
													                      		</div>
													                    	</div>
																		<div class="MoeOHTRowbottom">
													                    	<div class="MoeOHTCELL2">
													                      		<div class="MoeOHTAMT MoeOHTAMTNUMTheme">
													                        		<span data-tp-<%=order_category.toLowerCase()%>="0.0" data-tp-cat="<%=order_category.toLowerCase()%>">--</span> / 
														                    		<span data-pp-<%=order_category.toLowerCase()%>="0.0" data-pp-cat="<%=order_category.toLowerCase()%>">--</span> 
													                        	</div>
													                        <div class="MoeOHTAMT MoeOHTAMTLBETheme"><span>Total </span>/<span> Patient</span> </div>
													                      </div>
													                    </div>
													                  </div>
													                </div>
														        </div>
															</div>
               
															<div class="table" style="float:right">
												            	<div class="row">
												                	<div class="MoeOHEXPCOL">
												                  		<div class="StripControlcontainer" id="StripControlcontainer<%=order_category %>">
												                    		<div class="row">
												                      			<div class="MoeStripControlExp" onclick="showExpOrderItems('<%=order_category%>')" >
												                        			<div class="MoeIHECicon">
												                          				<div class="MoeIHEC_Uparrow" id="OrdItemsToggleArrow<%=order_category %>"> </div>
												                        			</div>
												                      			</div>
														                      	<div class="MoeStripControlMore" id="StripControlMoreId" onclick="controlMore('<%=order_category%>')">
														                        	<div class="MoeMoreDot MoeMoreDotTheme"></div>
														                        	<div class="MoeMoreDot MoeMoreDotTheme"></div>
														                        	<div class="MoeMoreDot MoeMoreDotTheme"></div>
														                      	</div>
												                    		</div>
												                  		</div>
												                	</div>
												                </div>
												            </div>
               										</div>
               
               										<div id="OCCatBgDiv<%=order_category %>" style="position:absolute; width:100%; height:100%;opacity:0.3; display:none;z-index:500" onclick="closeMoreDots('<%=order_category%>')"></div> <!-- empty div for blur function -->
											            <!-- control strip starts  -->
								                    	<div class ="cell" id = "strip<%=order_category %>" style="float:right; height:50px; right:0px; z-index:5000; display:none;position:absolute">
											    			<div class = "table" style="height:50px; width: 100%" >
																<div class="row" style = "width:100%;height:100%; float: left">
																<div class="ordFldHdrIconCircTheme" id="cosignAll<%=order_category%>" >
																	<div class="ordFldHdrIconPos" onclick="catSpecificSpecialActions('cosigned','<%=order_category.toLowerCase()%>','true')" data-cosigned-cat="<%=order_category.toLowerCase()%>" data-cosigned-status-<%=order_category.toLowerCase()%>="N"> 
																		<img src="${path}/eIPAD/images/Cosign24x24.png" width="20" height="20" />
																	</div>
																</div>
																<div class="ordFldHdrIconCircTheme" id="splApproveAll<%=order_category%>">
																	<div class="ordFldHdrIconPos" onclick="catSpecificSpecialActions('special_approved','<%=order_category.toLowerCase()%>','true')" data-special_approved-cat="<%=order_category.toLowerCase()%>" data-special_approved-status-<%=order_category.toLowerCase()%>="N">
																		<img src="${path}/eIPAD/images/SpecialApproval24x24.png" width="20" height="20" />
																	</div>
																</div>
																<div class="ordFldHdrIconCircTheme" id="authorizeAll<%=order_category%>">
																	<div class="ordFldHdrIconPos" onclick="catSpecificSpecialActions('authorized','<%=order_category.toLowerCase()%>','true')" data-authorized-cat="<%=order_category.toLowerCase()%>" data-authorized-status-<%=order_category.toLowerCase()%>="N"> 
																		<img src="${path}/eIPAD/images/Authorize24x24.png" width="20" height="20"/>
																	</div>
																</div>
																</div>
															</div>
										 			 	</div>
											            <!-- control strip ends -->
              									    </div>
              										<div class="MoeHBorder"> </div>
									                <!-- Transaction Error Icon div STARTS-->
												    <div class="MoeTransactionErIcon" id="OrdTransactionErCatIcon<%=order_category%>" data-tscterrormsg="" style="display:none" onclick="showTransactError(this)"></div>
												    <!-- Transaction Error Icon div ENDS-->
									            </div>
 			
							    		  		<div class="MoeSubSelectOrder" style="" id="OrdItemsExp<%=order_category%>">
								              		<div id="MoeSubSelectOrderItem">
								                		<div id="Subcontainer">
									                  		<!-- <div id="submain"> -->


																<%		    		
																	    		
														    		for(int i=0; i<PlaceOrderItems.size(); i++){
														    			records =(String[])PlaceOrderItems.get(i); // String array
														    			
																	    			
																%>		                    
													        	<div class="MoeSOA MoeSofl">
 																	<div class="MoeSubItemList" id="OrderCatalogItem<%=records[0]%>" data-catcode='<%=order_category%>' data-itemcode="<%=records[0]%>">
                      													<div class="MoeClose" onclick="removeOrder('IND','<%=records[0]%>')"> </div>
                      													<div  onclick="openOrderFields('<%=records[0]%>','<%=bean.getTempvalue("order_type_code"+records[0]) %>','<%=order_category%>')">
                      														<div class="MoeSubItemHeaderFont">
                      															<div class=" MoeSILTitle"><%=records[1]%></div>
                      														</div>
                      														<div class="MoeSubItemListDetails">
														                        <div class="MoeSILcon SILDate">
														                        	<div class="table">
														                            	<div class="row">
														                                	<div class="cell"><%=bean.getTempvalue("start_date_time"+records[0])%></div>
                                    
															                                    <!-- Authorize icon Starts -->
															                                  	<%
															                                  	String forceStatus				= bean.getForceStatus(practitioner_type,order_category);
															                                  	String fStatus[]=forceStatus.split(":"); 
															                                  	
															                                  	speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
																								if(speciality.size()>0)
																								{
																									for(int sc=0;sc<speciality.size();sc++)
																									{
																											speciality_code=(String[])speciality.get(sc);
																									}
																								}
															                                  	
																			                  	if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
																								{ 
																			                  		if(bean.checkForNull(bean.getTempvalue("authorized"+order_category),"false").equals("true")){
																								%>
																				                	<div class="cell MoeSubicon actionTickIcon" id="AuthorizeIcon<%=records[0]%>"  data-authorized-<%=order_category.toLowerCase()%>="Y"> <img src="${path}/eIPAD/images/authorize16x16.png"/> </div>
																				                <% 
																			                  		}
																			                  		else{
																		                  		%>
																				                	<div class="cell MoeSubicon" id="AuthorizeIcon<%=records[0]%>"  data-authorized-<%=order_category.toLowerCase()%>="N"> <img src="${path}/eIPAD/images/authorize16x16.png"/> </div>
																				                <% 
																			                  			
																			                  		}
																								}
																								else{
																								%>
																									<div class="cell MoeSubicon imgGrayscale" id="AuthorizeIcon<%=records[0]%>"  data-authorized-<%=order_category.toLowerCase()%>="NA"> <img src="${path}/eIPAD/images/authorize16x16.png"/> </div>
																								<%	
																								}
																					            %>
																					            <!-- Authorize icon Ends -->
						            
																					            <!-- Special Approval icon Starts -->
																					            <%
																					            if(records[50].equalsIgnoreCase("Y")) // For Special Approval
																								{ 
																			                  		if(bean.checkForNull(bean.getTempvalue("special_approved"+order_category),"false").equals("true")){
																								%>
																				                	<div class="cell MoeSubicon actionTickIcon" id="SpecialApproveIcon<%=records[0]%>" data-special_approved-<%=order_category.toLowerCase()%>="Y"> <img src="${path}/eIPAD/images/SpecialApproval16x16.png"/> </div>
																				                <% 
																			                  		}
																			                  		else{
																		                  		%>
																				                	<div class="cell MoeSubicon" id="SpecialApproveIcon<%=records[0]%>" data-special_approved-<%=order_category.toLowerCase()%>="N"> <img src="${path}/eIPAD/images/SpecialApproval16x16.png"/> </div>
																				                <% 
																			                  			
																			                  		}
																								}
																								else{
																								%>
																									<div class="cell MoeSubicon imgGrayscale" id="SpecialApproveIcon<%=records[0]%>" data-special_approved-<%=order_category.toLowerCase()%>="NA"> <img src="${path}/eIPAD/images/SpecialApproval16x16.png"/> </div>
																								<%	
																								}
																					            %>
																					            <!-- Special Approval icon Ends -->
																					            <!--  Cosign Starts -->
																					            <%
																				              	//out.println("<br>cosign is required"); 
																				                if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y"))  // For Cosign Required
																								{ 
																			                  		if(bean.checkForNull(bean.getTempvalue("cosigned"+order_category),"false").equals("true")){
																								%>
																				                	<div class="cell MoeSubicon actionTickIcon" id="CosignIcon<%=records[0]%>" data-cosigned-<%=order_category.toLowerCase()%>="Y"> <img src="${path}/eIPAD/images/cosign16x16.png"/> </div>
																				                <% 
																			                  		}
																			                  		else{
																		                  		%>
																				                	<div class="cell MoeSubicon" id="CosignIcon<%=records[0]%>" data-cosigned-<%=order_category.toLowerCase()%>="N"> <img src="${path}/eIPAD/images/cosign16x16.png"/> </div>
																				                <% 
																			                  			
																			                  		}
																								}
																								else{
																								%>
																									<div class="cell MoeSubicon imgGrayscale" id="CosignIcon<%=records[0]%>" data-cosigned-<%=order_category.toLowerCase()%>="NA"> <img src="${path}/eIPAD/images/cosign16x16.png"/> </div>
																								<%	
																								}
																					            %>
															                                    <!-- Cosign Ends -->
                                														</div>
                            														</div>
                        														</div>
														                        <div class="MoeSILcon SILDate">
														                        	<div class="MoeSelectOrderTxt"><%=bean.getTempvalue("performing_facility_desc"+records[0])%>, <%=bean.getTempvalue("performing_dept_loc_desc"+records[0])%></div>
														                        </div>
																				
																				<%	    			
																					if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))
																					{
																						bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
																				%> 
														                        <div class="MoeSILcon SILtotalamt">
														                         	<span data-itemtp-<%=order_category.toLowerCase()%>="<%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%>"><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span> / 
																					<span data-itempp-<%=order_category.toLowerCase()%>="<%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%>"><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span>
														                        </div>
																				<%
																					}
																					else{
																							
																				%>
													                            
													                            <div class="MoeSILcon SILtotalamt"> 
													                            	<span> -- </span>/<span> -- </span>	 
													                            </div>
																				<%
																						}
																				%>
                      														</div>
                      													</div>
													                    <!-- Transaction Error Icon div STARTS-->
													                    <div class="MoeTransactionErIcon" id="OrdTransactionErIcon<%=records[0]%>" data-tscterrormsg="" style="display:none" onclick="showTransactError(this)"></div>
													                    <!-- Transaction Error Icon div ENDS-->
                    												</div>
                    											</div>

																<%
																	}
																%>
														</div>
													</div>
												</div>
											<%
										        }
									
										    	}
											    else if(order_category.equals("CS")){
											    	String practitioner_type = bean.getPractitionerType();
											    	String order_catalog_code 		= bean.checkForNull(bean.getOrderCatalogCode(previousValues,order_category,practitioner_type),"");
											    	ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
											    	
											    	String billing_order_set_details[] = bean.getOrderSetBillDetails(order_catalog_code);
													String order_set_bill_yn = bean.checkForNull(billing_order_set_details[1],"N");
													String care_set_catalog_desc = bean.checkForNull(billing_order_set_details[0],"");
													String charge_yn = bean.checkForNull(billing_order_set_details[2],"");
													ArrayList PlaceOrderItems 		= null;
													String[] care_set_group			= null;
													ArrayList PlaceOrderSetItems 	= null;
													String order_set_order_catalog	= "";
													String order_type_catalog 		= "";
													if(charge_yn.equalsIgnoreCase("N"))
													{
														order_set_bill_yn = "N";
													}
													//Compute Total Count of Orders in the OrderSet
													int careSetOrdCount = 0;
													if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
													{
														
														for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
														{
															String[] care_set_count 		= null;
															care_set_count = (String[])PlaceOrdercareSetCount.get(t);	
															careSetOrdCount = careSetOrdCount + Integer.parseInt(care_set_count[0]);
														}
													}
													  
													
												%>		
													<!-- new code for order set -->
													<div class="MoeHeader MoeHeaderTheme" data-catcode='<%=order_category%>' data-itemcode="<%=order_catalog_code%>" id="OrderCatalogItem<%=order_catalog_code%>" >
											            <div class="MoeHTitle">
											            	<!-- new starts -->
											            	<div class ="cell" id = "stripOS<%=order_category%>" style="float:right; height:50px; width:100%; z-index:500; padding-right:15px; display:none ">
													    		<div class = "table" style="height:50px; width: 100%" >
																	<div class="row" style = "width:100%;height:100%; float: left">
																	<div class="ordFldHdrIconCircTheme"><div class="cell ordFldHdrIconPos imgGrayscale"> <img src="${path}/eIPAD/images/Authorize24x24.png" width="20" height="20"/></div></div>
																	</div>
																</div>
													 		</div>
											                <!-- new ends -->
               												<div class="cell"  style="position:absolute; width:100%;">
												               <div class="table" onclick="closeMoreDotsOS('<%=order_category%>')" id="testOS<%=order_category%>"  style="position:absolute;">
																	<div id="fakeDivOS<%=order_category%>" style="position:absolute; width:100%; height:100%;opacity:0.3;display:none"></div>
												               			<div class="row">
              																<div class="MoeIHclose" onclick="removeOrder('CAT','<%=order_category%>')"> </div>
																	        	<div class="MoeHTitlecellOS">
																	            	<div class="MoeOHTTable">
																	                	<div class="MoeOHTRowtop">
																	                    	<div class="MoeOHTCell1">
																								<div class="MoeIHTitle MoeIHTitleTheme"><%=order_category_desc %></div>
																	                      		<div class="MoeIHCountCont">
																	                        		<div class="MoeIHcount MoeIHcountTheme"><%=careSetOrdCount %></div>
																	                      		</div>
																	                    	</div>
																	                  	</div>
																	                  	<div class="MoeOHTRowbottom">
																	                    	<div class="MoeOHTCELL2">
																	                      		<div class="MoeOHTAMT MoeOHTAMTNUMTheme">
																								<%
																									if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !order_category.equals("BT"))
																									{
																										bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code);
																								%>			             
										                
																					         			<span data-tp-<%=order_category.toLowerCase()%>="<%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%>" data-tp-cat="<%=order_category.toLowerCase()%>"><%=bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")%></span> / 
																					        			<span data-pp-<%=order_category.toLowerCase()%>="<%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%>" data-pp-cat="<%=order_category.toLowerCase()%>"><%=bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")%></span> 
										                      		
																								<%
																									}
																									else{
																								%>				
																										<span data-tp-<%=order_category.toLowerCase()%>="0.0" data-tp-cat="<%=order_category.toLowerCase()%>">--</span> / 
																										<span data-pp-<%=order_category.toLowerCase()%>="0.0" data-pp-cat="<%=order_category.toLowerCase()%>">--</span>
	
																								<%				
																										}
																								%>		
                      																	  		</div>
                      																	  		<div class="MoeOHTAMT MoeOHTAMTLBETheme"><span>Total </span>&nbsp;/&nbsp;<span> Patient</span> </div>
                    																		</div>
                  																      	</div>
                																	</div>
              																	</div>
              															</div>
              												   </div>
             
              												   <div class="table" style="float:right">
                                                               		<div class="row">
              															<div class="MoeOHEXPCOLord">
                															<div class="StripControlcontainer" ID="StripControlcontainerOS<%=order_category%>">
                  																<div class="row">
                  
                     
                    <%-- <div class="MoeStripControlExp1"> 
                     <div class="IHECicon">
                     
                     
                     
                       <!-- Authorize icon Starts -->
                                  	<%
                                  	String forceStatusOS				= bean.getForceStatus(practitioner_type,order_category);
                                  	String fStatusOS[]=forceStatusOS.split(":"); 
                                  	
                                  	specialityOS=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
                                  
									if(specialityOS.size()>0)
									{
										for(int sc=0;sc<specialityOS.size();sc++)
										{
												speciality_code=(String[])specialityOS.get(sc);
										}
									}
                                  	
				                  	if(records[48].equalsIgnoreCase("Y") || fStatusOS[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
									{ 
				                  		if(bean.checkForNull(bean.getTempvalue("authorized"+order_category),"false").equals("true")){
									%>
					                	<div class="cell subiconOrders actionTickIcon" id="AuthorizeIconOS<%=records[0]%>"  data-authorizedos-<%=order_category.toLowerCase()%>="Y"> <img src="${path}/eIPAD/images/authorize16x16.png"/> </div>
					                <% 
				                  		}
				                  		else{
			                  		%>
					                	<div class="cell subiconOrders" id="AuthorizeIconOS<%=records[0]%>"  data-authorizedos-<%=order_category.toLowerCase()%>="N"> <img src="${path}/eIPAD/images/authorize16x16.png"/> </div>
					                <% 
				                  			
				                  		}
									}
									else{
									%>
										<div class="cell subiconOrders imgGrayscale" id="AuthorizeIconOS<%=records[0]%>"  data-authorizedos-<%=order_category.toLowerCase()%>="NA"> <img src="${path}/eIPAD/images/authorize16x16.png"/> </div>
									<%	
									}
						            %>
						            <!-- Authorize icon Ends --> 
                     	<div class="cell subiconOrders imgGrayscale"> <img src="${path}/eIPAD/images/authorize16x16.png"/></div>
                     
                     
                     </div>
                  	 </div>--%>
					                 
															                    	<div class="MoeStripControlExp"  onclick="showExpOrderItems('<%=order_category%>')" >
															                      		<div class="MoeIHECicon">
															                        		<div class="MoeIHEC_Uparrow"id="OrdItemsToggleArrow<%=order_category %>"> </div>
															                      		</div>
															                    	</div>
																                    <div class="MoeStripControlMore" id="StripControlMoreIdOS<%=order_category%>" onclick="controlMoreOS('<%=order_category%>')" >
																                    	<div class="MoeMoreDot MoeMoreDotTheme"></div>
																                      	<div class="MoeMoreDot MoeMoreDotTheme"></div>
																                      	<div class="MoeMoreDot MoeMoreDotTheme"></div>
																                    </div>
                  																</div>
                															</div>
              															</div>
              														</div>
              													</div>
              												</div>
            											</div>
            										<div class="MoeHBorder"> </div>
          											</div>
		
							
							            	
													<%
													if(PlaceOrdercareSetCount!=null) // Main Query, where the count and grouping will be get
													{
													%>
													<div class="MoeSubSelectOrder" id="OrdItemsExp<%=order_category%>">
										              	<div id="MoeSubSelectOrderItem">
										                	<div id="SubcontainerOrders">
										                  		<div id="submain"> 
																<%
																	for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
																	{
																		String[] care_set_count 		= null;
																		care_set_count = (String[])PlaceOrdercareSetCount.get(t);	
																		
																		String time_frame = "";
																		PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
																		for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
																		{
																			care_set_group 			= (String[])PlaceOrderSetItems.get(k);
																			order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
																		    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
																		}
																		if(order_set_order_catalog.length() > 0)
																			order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
																		if(order_type_catalog.length() > 0)
																			order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
																		PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),""); // Last parameter to identify normalOE or from preview
																		if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
																		{
																	%>
																			<div class="MoeSubItemheader">
															                	<div class="row">
															                        <div class="MoeSILTitle1">
															                          	<div class="MoeSILTitle1"><%=(String)hmOrderCategory.get(bean.checkForNull(care_set_count[1],"")) %></div>
															                        </div>
															                    </div>
															                </div>
																	<%
																			for(int i=0; i<PlaceOrderItems.size(); i++)
																			{
																				records		= (String[])PlaceOrderItems.get(i);
																	%>			            
			                
								
																            <div class="MoeSubItemListOrders" id="OrderCatalogItem<%=records[0]%>">
																				 <div class="MoeSubcloseOrders imgGrayscale MoeIconDisablePO" onclick=""> </div>
																					<div  onclick="openOrderFields('<%=order_catalog_code%>','<%=bean.getTempvalue("order_type_code"+order_catalog_code) %>','<%=order_category%>')">
																                      	<div class="MoeSubItemHeaderFont">
														      								<div class=" MoeSILTitle"><%=records[1]%></div>
														              					</div>
															                      	<div class="MoeSubItemListDetailsOrders">
																						<div class="MoeSILcon SILDate">
																						    <div class="cell" style="vertical-align:middle; height:21px;">
																								<%=bean.getTempvalue("start_date_time"+records[0])%>
																							</div>
																						</div>
																	                    <div class="MoeSILcon SILDate">
																              				<div class="MoeSelectOrderTxt"><%=bean.getTempvalue("performing_facility_desc"+records[0])%>, <%=bean.getTempvalue("performing_dept_loc_desc"+records[0])%></div>
																              			</div>
																					</div>
																					</div>
														                    	<!-- Transaction Error Icon div STARTS-->
																				<div class="MoeTransactionErIcon" id="OrdTransactionErIcon<%=records[0]%>" data-tscterrormsg="" style="display:none" onclick="showTransactError(this)"></div>
																				<!-- Transaction Error Icon div ENDS-->
														                    </div>
																	<%
																			}
																			order_set_order_catalog = ""; // Remove the values
																			order_type_catalog			 = ""; // Remove the values
																		}
																	}
																	%>
                  												</div>
                											</div>
              											</div>
           											</div>
									<%
																	
														}
													}
												}
											}
									else{
									%>
											    	<!-- No Results START -->
													<div class="table" style="height:100%; width:100%; position:absolute">	
														<div class="row">
															<div class="cell" style="vertical-align: middle; text-align: center;">
																<div class="MoeNoData" id="No_Orders" >No orders were selected</div>
															</div>
														</div>
													</div>
													
											    	<!-- No Results END -->
									<% } %>
					          			</div>
					        		</div>
				      			</div>
					      	</div>
				  		</div>
				    </div>
			  	</div>
				<!-- footer content starts here -->
				<div class="MoeFooterContainer">
				    <div class="MoeTotalcontainer">
						<div class="MoeTotalmain">
				        	<div class="MoeTotalC">
				          		<div class="MoeTotalCC MoeTotalCCTheme">
				            		<div class="MoeFooterCon">
				              			<!-- <div class="row footericon">
				                			<div class="footeredit"> </div>
				              			</div> -->
				              			<div class="MoeFooterlable">
				                			<div class="MoeFooterlabletxt">Total </div>
				              			</div>
				              			<!-- price area starts here-->
				              			<div class="MoeFooterprice">
				              				<div class="cell">
				              	 				<div class="table" style="height:100%; width:100%;">
				              	 					<div class="row">
				                						<div class="MoeFooterpricetxt">
				                							<div class="MoeFooterpricetxt"><span id="OrdTotalTP">0.0</span> / <span id="OrdTotalPP">0.0</span></div>
				                						</div>
			                							<div class="MoeFooterpricetxt1 MoeFooterpricetxt1Theme">
			                								<div class="MoeFooterpricetxt1 MoeFooterpricetxt1Theme"><span>Total </span>/<span> Patient</span> </div>
			                							</div>
			                						</div>
			                					</div>
			                				</div>
				              			</div>
				              			<!-- price area ends here-->
				            		</div>
				          		</div>
				        	</div>
				      	</div>
				    </div>
				 </div>
				 <!-- footer content ends here -->
		    </div>
		</div>
	</div>
<input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}" />
	<!-- <div id="testred" style="position:absolute;background:red;height:50px;width:200px;bottom:5px;right:0px"></div> -->
</div>

</form>
<!-- </body>
</html> -->


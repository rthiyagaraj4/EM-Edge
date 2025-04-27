<!DOCTYPE html>
<%@page import="eOR.OrderEntryBean"%>
<%@page import="eIPAD.chartsummary.encounterlist.healthobject.EncounterHO"%>
<%@page import="eIPAD.chartsummary.encounterlist.request.EncounterListRequest"%>
<%@page import="eIPAD.chartsummary.encounterlist.bc.EncounterListBC"%>
<%@page import="eIPAD.chartsummary.encounterlist.response.EncounterListResponse"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import ="com.ehis.persist.PersistenceHelper" %> 
<%@page import="ePH.IVPrescriptionBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals("")){
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
}
else{ 
  	appLocale = new Locale("en");
} 
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
if(patientContext!=null){
try{
String patient_id = patientContext.getPatientId();
String encounter_id	= patientContext.getEncounterId();
String patient_class = patientContext.getPatientClass();
String facility_id = patientContext.getFacilityId();
String locale = patientContext.getLocale();
String or_bean_name				= "eOR.OrderEntryBean";
String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
OrderEntryBean orbean			= (OrderEntryBean)PersistenceHelper.getBeanObject( or_bean_id,or_bean_name,request ) ;
String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
String bean_name			= "ePH.PrescriptionBean_1";
PrescriptionBean_1 bean		= (PrescriptionBean_1)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
String presBean_name		= "ePH.PrescriptionBean";
PrescriptionBean presBean		= (PrescriptionBean)PersistenceHelper.getBeanObject(presBean_id, presBean_name, request );
String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
String param_bean_name				= "ePH.DrugInterfaceControlBean";
DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)PersistenceHelper.getBeanObject( param_bean_id, param_bean_name, request );
String pregn_bean_id = "PregnancyCategory" ;
String pregn_bean_name = "ePH.PregnancyCategoryBean";
PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)PersistenceHelper.getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;
String ph_bean_id 				= "@DrugSearchBean"+patient_id+encounter_id;
String ph_bean_name 			= "ePH.DrugSearchBean";
DrugSearchBean ph_drug_bean		= (DrugSearchBean)PersistenceHelper.getBeanObject( ph_bean_id, ph_bean_name, request ) ;

String episode_type= patientContext.getPatientClass();
if(episode_type !=null && (!episode_type.equals("")))
	episode_type = episode_type.substring(0,1);
if(episode_type !=null && episode_type.equals("X"))
	episode_type = "R";
 String bed_num="";
 String room_num="";
/* Get Applicable tabs code STARTS */   	
String facilityparam_bean_id	= "FacilityParameter" ;
String facilityparam_bean_name = "ePH.ParameterFacilityBean";
ParameterFacilityBean facilityparam_bean = (ParameterFacilityBean)PersistenceHelper.getBeanObject( facilityparam_bean_id, facilityparam_bean_name, request ) ;
String iv_rx_chk ="";
String comp_rx_chk = "";
ArrayList arrList = (ArrayList)facilityparam_bean.checkForPHFacilityParamExistence(facility_id);
if(arrList.get(66) != null){
	comp_rx_chk = (String)arrList.get(66);
}
if(arrList.get(67) != null){
   	iv_rx_chk = (String)arrList.get(67);
}
String bean_id_IVD			= "@IVPrescriptionBean_IVD"+ patientContext.getPatientId() + patientContext.getEncounterId();
String bean_name_IVD	= "ePH.IVPrescriptionBean";
IVPrescriptionBean bean_IVD	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patientContext.getPatientId() + patientContext.getEncounterId();
String bean_name_IVWA	= "ePH.IVPrescriptionBean";
IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
String bean_id_IVPB			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
String bean_name_IVPB	= "ePH.IVPrescriptionBean";
IVPrescriptionBean bean_IVPB	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVPB, bean_name_IVPB, request);
String iv_with_additives = "";
String iv_without_additives = "";
String iv_intermittent = "";
ArrayList ivLegends = bean_IVD.getIvLegends();
if (ivLegends != null && ivLegends.size() > 1) {
	iv_with_additives = (String) ivLegends.get(0);
	iv_without_additives = (String) ivLegends.get(1);
	iv_intermittent = (String) ivLegends.get(2);
}	
/* IVRx description ends */ 
/* Ticksheet starts */ 
orbean.setOrderCategoryYn("PH");
String[] record	 = null;
String order_category = "PH";
String ticksheetValue			= "";
ArrayList TickSheets = orbean.getTickSheet(order_category);
String tickSheetDpList="";
String defaultSelTickSheet="";
if(TickSheets !=null && TickSheets.size()>0)
{	
	record = (String[])TickSheets.get(0);
	defaultSelTickSheet=record[0];
	record = null;
	for(int i=0; i<TickSheets.size(); i++){		
		record = (String[])TickSheets.get(i);
		tickSheetDpList= tickSheetDpList+"<option value='"+((String) record[0])+"'>"+((String) record[1])+"</option>";
		record = null;	
	}
}
String tick_sheet_id = "002";
String order_type = "";
ArrayList SectionDisplay = orbean.getSectionPopulate(order_category,tick_sheet_id,order_type);
		for(int j=0; j<SectionDisplay.size(); j++)
		{
			record = (String[])SectionDisplay.get(j);
			System.out.println(record[0]+ " -- " +record[1]+"");
			record = null;
		} 
/* Ticksheet ends */ 
%>
                                                            <div data-role="none" id="dvMez" class="blurPopup" onclick="" data-popid="" style="z-index:10000"></div>
                                                            <!-- TODO -->
                       <!-- Ht n Wt PopUp starts-->
						<div id="pharmacyValidationPopUp" class="absoluteCenter" style="box-shadow: 0px 0px 10px 5px #7e8081;z-index: 10005; display: none;">
						   <div class="pharPopHeader segoeuiBold">Enter height and weight</div>
						   <div class="HeightPopcontent">
	                            <div class="rxDurationSectionWrapper">
                                    <div class="rxLeftContainerDuration">
                                       <div class="rxLabel segoeuiBold" style="padding-top: 10px;">Height <font style="display:none;" id="ht_mandatory" class="rxMandatorIndi">*</font></div>
                                        <div class="pharmIvRxDetailCntlContentWa" style="padding-top: 1px;">                                      
										  <input style="width:100% ! important;height:43px;" id="enter_height" class="dropDown k-textbox" type="text"  maxlength="5" />
                                          <div class="pharmIvRxDetailInnerContent">cms</div>
                                       </div>										   
                                       <div class="rxLabel segoeuiBold" style="clear: both;">BSA</div>
									   <div style="width:100% ! important;" class="pharContentBMIBSAValue" id="RxBsaValue"></div>
                                    </div>
                                    <div class="rxRightContainer" style="padding-top:0px" >
										<div class="rxLabel segoeuiBold" style="padding-top:10px">Weight <font style="display:none;" id="wt_mandatory" class="rxMandatorIndi">*</font></div>
                                        <div class="pharmIvRxDetailCntlContentWa">                                      
										  <input style="width:100% ! important;height:43px;" id="enter_weight" class="dropDown k-textbox" type="text"  maxlength="6" />
                                          <div class="pharmIvRxDetailInnerContent">kgs</div>
                                       </div>									   
                                       <div class="rxLabel segoeuiBold" style="clear: both;">BMI</div>									    
									   <div style="width:100% ! important;" class="pharContentBMIBSAValue" id="RxBmiValue"></div>
                                      </div>
                                </div>	  
						   </div>
						   <div class="pharPopFooter">
						      <div id="heightCheckOk" disable="true" class="pharPopOk segoeuiBold" onClick="closeHWPopupOK()">OK</div>
						      <div class="pharPopCancel segoeuiBold" onClick="closeHWPopupCAN()">CANCEL</div>
						   </div>
						</div>
						<!-- Ht n Wt PopUp ends -->   
                                                            <div class="ChartSummaryParent ChartSummaryParentTheme" data-role="page" id="RxOrderPlaceDiv">
                                                                <div class="ChartSummaryBlockVar" id="ChartSummaryBlock" data-role="none">
                                                                    <form id="PharmBaseForm" name="PharmBaseForm" id="PharmBaseForm" method="post" action="" class="ChartSummaryFormElem">
                                                                        <div class="ChartSummaryMainTable" data-role="none">
                                                                            <div data-role="none" class="ChartSummaryPageHeader" id="CSHeader">
                                                                                <div class="ChartSummaryHeaderCell" data-role="none">
                                                                                    <div class="ChartSummaryHeaderCont" data-role="none">
                                                                                        <div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role="none">
                                                                                            <div class="ChartSummaryHeaderRow" data-role="none">
                                                                                                <div class="ChartSummaryHeaderIconCol" data-role="none">
                                                                                                    <div class="WidgetButtonTheme" data-role="none"><img src="${path}/eIPAD/images/MenuIcon.png"></div>
                                                                                                </div>
                                                                                                <div class="ChartSummaryHeaderTextCol" data-role="none">
                                                                                                    <div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role="none">Pharmacy Order</div>
                                                                                                </div>
                                                                                                <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                                                                                                    <div class="WidgetButtonTheme completePlaceOrdersDisable" 
																									id="completePlaceOrdersConfirm"data-role="none" onclick="completePlaceOrders_confirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
                                                                                                </div>
                                                                                                <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                                                                                                    <div class="WidgetButtonTheme" data-role="none" onclick="closeChartSummary()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div data-role="none" class="ChartSummaryPageContent ChartSummaryPageContentTheme" id="">
                                                                                <div data-role="none" class="ChartSummaryPageContentCell">
                                                                                    <div data-role="none" class="ChartSummaryMainWrapper pharmDataMainWrapper" id="">
                                                                                        <div class="ChartSummaryMainScroller pharmDataContentScroller" data-role="none">
                                                                                            <div class="table pharmDataItemHeight" style="table-layout:fixed;" data-role="none">
                           <div  class="row selectPharmOrder pharmOrderItemHeaderRow" data-role = "none" id="PharmAvailableTabs">
                              <div id="pharmPrevOrder" class="cell pharmOrderTab"  onclick="selectPharmOrderTab(this,'prevOdr')" data-role = "none"> Previous Orders
                              </div>
                              <div id="pharmTickSheet" class="cell pharmOrderTab"  onclick="selectPharmOrderTab(this,'tickSheet')" data-role = "none"> Ticksheet </div>
                              <div id="pharmRx" class="cell pharmOrderTab"  onclick="selectPharmOrderTab(this,'rxTab')" data-role = "none"> Rx </div>
                              <%
                              if(comp_rx_chk.equals("Y")){
                              %>
                              <div class="cell pharmOrderTab"  onclick="selectPharmOrderTab(this,'crxTab')" data-role = "none"> Compounding Rx </div>
                              <%
                              }
                              if(iv_rx_chk.equals("Y")){
                              %>
                              <div class="cell pharmOrderTab"  onclick="selectPharmOrderTab(this,'ivrxTab')" data-role = "none"> IV </div>
                              <%
                              }
%>
                           </div>						   				
						   <div  id="ivrxSubTypes" class="row ivrxSubTabs" style="display:none;">
                              <div class="ivrxTabsContainer">								
                                <div style="width:33%;height:50px;font-size: 14px;font-family:Segoe UI Semibold;color: #9298ae;" onclick="selectIvrxMode('D','ivWithAdd')">
								   <div class="table" style="width:100%;height:50px;">
								      <div class="row">
									     <div class="cell" style="vertical-align: bottom;text-align: center;">
										    <div id="ivWithAddOption" class="ivrxTabs ivrxTabsOnActive"></div>
										 </div>
									  </div>
                                      <div class="row">
									     <div id="ivWithAddDesc" class="cell ivrxDescription ivrxTabsDescOnActive">
										     <%=iv_with_additives%>
										 </div>
									  </div>									  
								   </div>
								</div>								
								<div style="width:33%;height:50px;font-size: 14px;font-family:Segoe UI Semibold;color: #9298ae;" onclick="selectIvrxMode('IVF','ivWithoutAdd')">
								   <div class="table" style="width:100%;height:50px;">
								      <div class="row">
									     <div class="cell" style="vertical-align: bottom;text-align: center;">
										    <div id="ivWithoutAddOption" class="ivrxTabs"></div>
										 </div>
									  </div>
                                      <div class="row">
									     <div id="ivWithoutAddDesc" class="cell ivrxDescription">
										    <%=iv_without_additives%>
										 </div>
									  </div>									  
								   </div>
								</div>																
                                <div style="width:33%;height:50px;font-size: 14px;font-family:Segoe UI Semibold;color: #9298ae;" onclick="selectIvrxMode('D','ivInter')">
								   <div class="table" style="width:100%;height:50px;">
								      <div class="row">
									     <div class="cell" style="vertical-align: bottom;text-align: center;">
										    <div id="ivIntermittentOption" class="ivrxTabs"></div>
										 </div>
									  </div>
                                      <div class="row">
									     <div id="ivIntermittentDesc" class="cell ivrxDescription">
										    <%=iv_intermittent%>
										 </div>
									  </div>									  
								   </div>
								</div>								
							  </div>
                           </div>                       					   
                           <div class="row" id="searchResultsList" style="width:auto;height:90%;background:#edf1f3;" data-role = "none">  
			                 <div class="cell" style="width:auto;height:99%;">
						       <div class="table"  style="width:100%;height:100%;table-layout:fixed;">
						          <div class="row" style="width:100%;height:1%;background:#edf1f3;" data-role = "none">
						             <div class="cell" style="width:100%;height:auto;">                                        
										<div id="drugSearchBox" class="divEventTheme" style="width: calc(100% - 12px);margin-left: 5px;margin-top: 10px;margin-bottom: 3px;">
			                            <table cellpadding="0" cellspacing="0" style="width: 100%; height: 100%">
				                           <tr style="width: 100%; height: 100%">
					                          <td style="width: 99%; height: 100%" valign="middle">
                                                 <input type="text" class="txtContent" style="height:31px;width:98%;padding-left: 5px;" onkeyup="filterNoteTypes(event)" id="NoteTypeFilterTxt" name="NoteTypeFilterTxt" id="NoteTypeFilterTxt" />
					                          </td>
					                          <td style="width: 1%; height: 100%">
						                        <div id="cellblur" class="cellDivider">
							                      <div id="addSearchClass" class="dvSerarchIcon" style="display: block;" onclick="clearTemplateFilterTxt(event)">
							                         <img src="${path}/eIPAD/images/SearchGray16x16.png" id="NoteFilterTxtClearButton">
							                      </div>												
							                      <div id="removeSearchClass" class="dvSerarchIcon" style="padding-left: 5px;display: block;" onclick="clearSearchFilterTxt()">
							                         <img src="${path}/eIPAD/images/Close-small.png" id="NoteFilterTxtClearButton">
							                      </div>		
						                        </div>
					                           </td>
				                           </tr>
			                            </table>
		                                </div>
										<%if(TickSheets !=null && TickSheets.size()>0){%>
										<div id="drugDropDownTicksheet" class="ticksheetHolder" style="display:none">
			                               <div style="width:calc(100% - 10px);height:48px;margin-top: 7px;margin-left: 5px;">
										     <select style="width: 100%;" id="drugDropDownTicksheet1" name="drugDropDownTicksheet1" id="drugDropDownTicksheet1">
											 <%=tickSheetDpList%>
											 </select>
										   </div>
										   <div id="loadticksheetSecParent" style=" display:none; width:100%;height:8vhpx;">
										       <div id="loadticksheetSections" style="width:100%;height:40px;">											   
											   </div>
										   </div>
										</div>
										<%}else{%>										
											<div id="noticksheetMsg" class="noRecordsMainDiv" >			
												<p class="noRecordsText">No ticksheet found </p> 
											</div>
										<%}%>										     
						              </div>
						            </div>
<div class="row" style="width:auto;height:99%;" data-role="none">
<div class="cell" style="width:auto;height:100%;">
<div class="container" id="rxSearchResults">
</div>
<div id="cartWrapper" class="cartWrapper">
   <div id="cart" class="cart">
      <div id="innerCart" class="innerCart">
         <div class="shoppingCart">
            <img class="cartImage" src="${path}/eIPAD/images/Cart.png">
         </div>
         <div class="shoppingCart">
            <div class="cartCount">
               <span id="cartCount" style="position: relative;top: 2px;left: 0px;font-family:Segoe UI;-webkit-font-smoothing: antialiased;letter-spacing: -0.8px;font-weight: 600;">0  
               </span>
            </div>
         </div>
      </div>
   </div>
</div>
<div id="cartExpandWrapper" style="display:none">
   <div id="cartOnExpand">
      <div id="cartSymbol">
         <div id="innerCartOnExpand" class="innerCart">
            <div class="shoppingCart">
               <img class="cartImage" src="${path}/eIPAD/images/Cart.png">
            </div>
            <div class="shoppingCart">
               <div class="cartCount">
                  <span id="cartCountOnExpand" style="position: relative;top: 2px;left: 0px;font-family:Segoe UI;-webkit-font-smoothing: antialiased;letter-spacing: -0.8px;font-weight: 600;">0  
                  </span>
               </div>
            </div>
         </div>
      </div>
      <div id="dropBasket">
         <div id="shoppingCartText" class="shoppingCartText">
         </div>
      </div>
   </div>
</div>
<div class="cardShadowWrapper">
   <img class="cartShadowTop" src="${path}/eIPAD/images/CartShadow.PNG">
   <img class="cartShadowBottom" src="${path}/eIPAD/images/CartShadow.PNG">
</div>
<!-- drug interaction check Pop starts -->
<div id="PharmacyCartValidationDrugInteraction"  class="absoluteCenter drugInteractionPopMainWrapper" >
	<div class="drugInteractionPopWrapper" >
        <div id="popupContainer" class="drugInterPopupContainer">
		    <div class="pharPopHeader" style="width:auto;padding:0px;">
				<div class="table" style="width:100%;height:100%">
				<div class="row" style="width:100%;height:100%">
					<div class="cell drugInterImgWrapper" style=""><img src="${path}/eIPAD/images/Warning_icon25x23.png" ></div>
					<div class="cell "style="width:auto;height:100%;"> Interaction details</div>
				</div>
				</div>
		   </div>
		   <div id="popContent" class="drugInterContentWrap" >
		      <div id="contentHeader" class="drugInterContentHeaderWrap">
			    <div class="drugInteractionLabelWrapper" >
				   <span class="drugInteractionLabel">Severity level</span>
				  <span id="severity_level" class="segoeuiBold drugInteractionLabelContent"></span>
				</div>
				<div class="drugInteractionLabelWrapper" >
				<span class="drugInteractionLabel">Documentation</span>
				 <span id="probability"  class="segoeuiBold drugInteractionLabelContent"></span>
				</div>
				<div class="drugInteractionLabelWrapper" >
				<span class="drugInteractionLabel">Sigficant level</span>
				 <span id="significant_level"  class="segoeuiBold drugInteractionLabelContent"></span>
				</div>
				<div style="clear: both;"></div>
			  </div>
			  <div class="drugInteractionLabel drugInterDescLabel">Interaction description</div>
			  <div id="drugInterScrollableWrap" class="drugInterScrollCss" >
			     <div id="DrugInteractionDesc" class="segoeuiBold drugInterDescContent">
				 </div> 
			  </div>
		   </div>
		   <div class="pharPopFooter" style="">
		   <div id="" disable="true" class="pharPopOk segoeuiBold" onClick="okPopup()">OK</div>			
		   </div>
		</div>         		
	</div>
</div>
<!-- drug interaction check Pop ends -->


<div id="PharmacyCartValidationDrugMessage" class="absoluteCenter" style="z-index: 10005;">
   <div class="Error_Window">
      <div class="Error_msg_box">
         <div class="Error_msg">
            <div style="width:20% !important;" class="Error_msg_Frame">
               <div>
                  <div class="Error_iconCenter"><img src="${path}/eIPAD/images/OrderPopWarning.png" width="30" height="30"> </div>    
			   </div>
            </div>
			 <div style="width:80% !important;" class="Error_msg_Frame">
               <div>                  
                  <div class="Error_contCenter" id="PharmaMsg"></div>
               </div>
            </div>
         </div>
      </div>
      <div class="Error_msg_Okbtn">
         <div class="Error_btn_div_con" id="drugClick" data-value="true">OK </div>
      </div>
      <div class="top_shadow"> </div>
   </div>
</div>

<!-- Discharge medication Pop starts -->
<div id="PharmacyCartValidationDialogDis" class="absoluteCenter" style="z-index: 10005;">
   <div class="Error_Window">
      <div class="Error_msg_box">
         <div class="Error_msg">
            <div class="Error_msg_Frame">
               <div>
                  <div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30"> </div>
                  <div class="Error_cont" id="ClinicalNotesConfirmDialogMsg">Do you want to treat this as patient's discharge medication?</div>
               </div>
            </div>
         </div>
      </div>
      <div class="Error_msg_btn">
         <div class="Error_btn_div_con" id="cancelClick" onclick="cancelClickDialog()">Cancel </div>
         <div class="Error_btn_div"> </div>
         <div class="Error_btn_div_con" id="trueClick" onclick="trueClickDialog()" data-value="true">Confirm </div>
      </div>
      <div class="top_shadow"> </div>
   </div>
</div>
<!-- Discharge medication Pop starts -->
                                                                                                                    
<!-- Cart close Pop starts -->																												  
<div id="cartCloseconfirmMsg" class="absoluteCenter" style="z-index: 999999;">
			<div class="Error_Window">
				<div class="Error_msg_box">
				<div class="Error_msg">
					<div class="Error_msg_Frame">
						<div>
							<div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30"> </div>
							<div class="Error_cont" id="ClinicalNotesConfirmDialogMsg">Are you sure you wish to cancel the current operation?</div>
						</div>
					</div>
				</div>
				</div>
			<div class="Error_msg_btn">
				<div class="Error_btn_div_con" id="okClick" onclick="okCartClickDialog()">OK </div>
				<div class="Error_btn_div"> </div>
				<div class="Error_btn_div_con" id="cancelClick" onclick="cancelCartClickDialog()" data-value="true">Cancel </div>
			</div>
			<div class="top_shadow"> </div>
			</div>
</div>
<!-- Cart close Pop ends -->

<!-- Delete Pop starts -->																												  
<div id="deleteConfirmMsg" class="absoluteCenter" style="z-index: 999999;">
	<div class="Error_Window">
		<div class="Error_msg_box">				
		 <div class="Error_msg">
            <div style="width:20% !important;" class="Error_msg_Frame">
               <div>
                  <div class="Error_iconCenter"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30"> </div>    
			   </div>
            </div>
			 <div style="width:80% !important;" class="Error_msg_Frame">
               <div>                  
                  <div class="Error_contCenter" id="ClinicalNotesConfirmDialogMsg">Do you want to remove this order from cart?</div>
               </div>
            </div>
         </div>							
		</div>
			<div class="Error_msg_btn">
				<div class="Error_btn_div_con" id="okClick" onclick="okDeleteCartItemDialog('ok')">OK </div>
				<div class="Error_btn_div"> </div>
				<div class="Error_btn_div_con" id="cancelClick" onclick="cancelDeleteCartClickDialog()" data-value="true">Cancel </div>
			</div>
			<div class="top_shadow"> </div>
	</div>
		   <input type="hidden" id="drugDelCode" name="drugDelCode" id="drugDelCode" value=""/>
                   <input type="hidden" id="drugDivID" name="drugDivID" id="drugDivID" value=""/>
		   <input type="hidden" id="removeType" name="removeType" id="removeType" value=""/>
		   <input type="hidden" id="drugSrl" name="drugSrl" id="drugSrl" value=""/>
</div>
<!-- Delete Pop ends -->
<!-- Cart View -->
<div id="cartView" style="display: none" class="viewCartWrapper">
   <div id="cartViewHeader" class="cartViewHeaderStyle">
      <div class="cartViewHeaderContent">
         <img class="padding15Px" src="${path}/eIPAD/images/Cart.png">
         <span class="padding15Px viewCartText">
         Cart Items 
         </span>
         <div class="cartItemCountWrapper">
            <div style="position: relative;background-color:#23789e;text-align: center;border-radius: 50%;height: 29px;width: 29px;">
               <span id="countDisplay" class="countDisplayStyle">0</span>
            </div>
         </div>
      </div>
      <div class="closeCartPanel">
         <img id="closeCartView" src="${path}/eIPAD/images/Close_panel.png">
      </div>
   </div>
   <div id="cartViewDetails" class="cartViewDetailsCss">
      <div id="orderDetailsView" class="innerCartDetailsCss">       
      </div>
   </div>
</div>
<!-- Cart View ends-->
</div>
</div>
</div>
</div>
</div>							  
<!-- Pharmacy legend starts -->
<div id="pharBaseLegend"></div> 	
<!-- Pharmacy legend ends -->
</div>
</div>
<div id="blurSearchResultsList1" style="display:none;width: 100%;height:100%;background-color : #808080;opacity : 0.6;position:absolute;z-index : 9000;"></div>
<div id="blurSearchResultsList" style="display:none;width: calc(100% - 310px);height:100%;background-color : #808080;opacity : 0.6;position:absolute;z-index : 9000;">
</div>
</div>
<div class="CSTransactionMessage rxBaseToastContentError" id="transactionMsg" style="bottom:107px;z-index: 900002;">
   <img id="imgTransactionMsg" style="padding-left:15px;vertical-align:middle;" src="${path}/eIPAD/images/PopError.png" onclick="closeToast()">
   <span class="rxToastmsg" id="rxToastmsg">Some error occured</span>
   <div class="formValErrorMsgTheme" id="transactionMessageContent"></div>
</div>
</div>
</div>
<div data-role="none" class="ChartSummaryPageFooter" id="CSFooter">
   <div data-role="none" class="ChartSummaryPageFooterCell">
      <div data-role="none" class="ChartSummaryPageFooterCont">
         <div data-role="none" class="ChartSummaryPageFooterTable ChartSummaryPageFooterTableTheme">
            <div data-role="none" class="ChartSummaryPageFooterRow">
               <div data-role="none" class="ChartSummaryPageFooterFirstCol"></div>
               <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openOtherChartFunctions('chartSummary')">
                  <div data-role="none" class="ChartSummaryPageFooterText">
                     <%=csResBundle.getString("common.chartSummary") %>
                  </div>
               </div>
               <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openOtherChartFunctions('clinicalNotes')">
                  <div data-role="none" class="ChartSummaryPageFooterText">Clinical<br/>Notes</div>
               </div>
               <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openOtherChartFunctions('placeOrder')">
                  <div data-role="none" class="ChartSummaryPageFooterText">
                     <%=csResBundle.getString("common.order") %>
                  </div>
               </div>
               <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnTheme" onclick="openOtherChartFunctions('clinicalEvents')">
                  <div data-role="none" class="ChartSummaryPageFooterText">Clinical Events</div>
               </div>
               <div data-role="none" class="ChartSummaryPageFooterButton ChartSummaryPageFooterBtnSelTheme" onclick="openPharmacyFunction()">
                  <div data-role="none" class="ChartSummaryPageFooterText">Pharmacy Order</div>
               </div>
               <div data-role="none" class="ChartSummaryPageFooterLastCol"></div>
            </div>
         </div>
      </div>
   </div>
</div>
</div>
<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" />
<%
	/* code extracted from \eHIS\web\ePH\jsp\PrescriptionHeader_1.jsp STARTS */
	String licence=(String)(PhLicenceRights.getKey());
	String version_no=(String) PhVersionNo.getVersion();
	String function_id="PH";	
	String iv_prep_default = ""; //TODO
	String function_from = "";	
	String act_patient_class = patientContext.getPatientClass(); //actual patientclass
	if(patient_class.trim().equals("DC")) 
		patient_class="IP";
	if(patient_class.trim().equals("EM")) 
		patient_class="OP";
	String location_type = "";
	String location_code = "";
	String visit_adm_date = "";	
	EncounterListRequest encReq = new EncounterListRequest();
	encReq.setPatientContext(patientContext);
	EncounterListBC encBC = new EncounterListBC();
	//get the current encounter details
	encReq.setFilterEncounterId(patientContext.getEncounterId());
	EncounterListResponse currentEncResp;
	currentEncResp = encBC.getEncounterList(encReq);
	if(currentEncResp.isSuccessResponse() && !currentEncResp.isEmptyDataResponse()){
		EncounterHO currentEnc = currentEncResp.getEncounterList().get(0);
		if(currentEnc!=null){
			location_type = currentEnc.getAssignCareLocnType();
			if(location_type.equals("W"))
				location_type = "N";
			if(location_type.equals("E"))
				location_type ="C";
			location_code = currentEnc.getAssignCareLocnCode();
			visit_adm_date = currentEnc.getVisitDate();
		}		
	}
	ph_drug_bean.setsource_code(location_code);
	ph_drug_bean.setsource_type(location_type);
	String leg_value_1				= "";
	String leg_uom_1				= "";
	String leg_value_2				= "";
	String leg_uom_2				= "";
	float bsa						= 0f;
	String bsa_str					= "";
	String rec_date					=  "";
	String bmi_str					=  "";
	String visit_date				= "";
	String sys_date					= "";
	String calculated_date			= "";
	String order_type_code_yn		= "";
	String take_medication_yn_chk	= "";
	String take_medication_yn_dis	= "";
	String take_medication_yn_val	= "";
	String home_leave_yn_val	= "";
	String home_leave_disp	= "";
	int homeleave_rec				= 0;
	int homeleave_chk				= 0;
	int medication_rec				= 0;
	String login_user_prac_id		= (String)orbean.getLoginPractId();
	String pract_id					= (String) orbean.getPractitionerId();
	String resp_id					= (String) orbean.getResponsibilityId();
	String pract_reln_id			= (String) orbean.getRelationshipId();
	String pract_name				= (String) orbean.getPractitionerName();
	String attend_pract_id			= (String) orbean.getAttendPractitionerId();
	String order_remarks			= "";
	String man_rem_on_prn_freq_yn	= "";
	boolean MItemsOnly				= false;
	String narcotic_aprvl_form_req_yn	    = "";
	String print_narcotic_form_by_default	= "";
	String rx_qty_by_pres_base_uom_yn	    = "";
	String back_date				= "";
	String future_date				= "";
	String servide_code				= (String) orbean.getServiceCode();
	String service_search_yn		= (String) orbean.getRestrictYn();
	String allow_without_wt			=	"";
	String allow_without_diag		=	"";
	String patient_age				=	"";
	String date_of_birth			=	"";
	String gender				    =	"";
	String atc_allergy_alert_level   =	"N";
	String drug_interaction_check_yn   =	"N";
	String dispPrescripionDuration   =	""; 
	String pract_type   =	(String) orbean.getPractitionerType();
	String generic_id="";
	String alternateOrder="N";
	String currentStage="";
	String height_min_value			= "";
	String height_max_value			= "";
	String weight_min_value			= "";
	String weight_max_value			= "";
	String height_min_digits		= "";
	String height_max_digits		= "";
	String height_dec_digits		= "";
	String weight_dec_digits		= "";
	String weight_min_digits		= "";
	String weight_max_digits		= "";
	String comp_rx_appl_yn			= "N";
	String iv_rx_appl_yn			= "N";
	String oncology_rx_appl_yn		= "N";
	String tpn_rx_appl_yn			= "N";
	String tdm_appl_yn				= "N";	
	String order_set_code = "";
	String	bl_install_yn			=	orbean.getBillingInterfaceYn()	== null ? "" : orbean.getBillingInterfaceYn();
	int adr_count =(int)bean.getADRCount(patient_id,"%");
	String MAR = "";
	String called_from_verbal_order =bean.getCalled_from_verbal_order(); 
	String mode = CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	boolean allergy_conf_reqd_yn = bean.getAllergyConfDtls(patient_id, encounter_id);
	String NBPRequestApplYN = presBean.getNBPRequestAppl(resp_id, pract_reln_id, encounter_id, patient_id);
	String excludeADRAllergyAlert_yn = bean.getExcludeADRAllergyAlert();
	String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
	String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);    
	String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
	String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
	String overlap_period_for_op        =   param_bean.getOverlapPeriodForOP(facility_id);
	String overlap_period_for_ip        =   param_bean.getOverlapPeriodForIP(facility_id);
	bean.setOverlapPeriodForOP(overlap_period_for_op);
	bean.setOverlapPeriodForIP(overlap_period_for_ip);
	
	bean_IVD.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_IVD.setExternalDosageYN(drug_db_dosecheck_yn);
	
	bean_IVWA.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_IVWA.setExternalDosageYN(drug_db_dosecheck_yn);
	
	bean_IVPB.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);
	bean_IVPB.setExternalDosageYN(drug_db_dosecheck_yn);
	
	String allergic_yn				=  "N";
	int num = bean.loadallergydetail(patient_id);
	if(num>0){
		allergic_yn = "Y";
	}
	int index = 0;
	HashMap discr_values	=	presBean.getHgtWgtDtls(patient_id);
	if(discr_values.containsKey("HEIGHT_MIN_VALUE")) {	
		height_min_value	=	(String)discr_values.get("HEIGHT_MIN_VALUE");
		height_max_value	=	(String)discr_values.get("HEIGHT_MAX_VALUE");
		height_min_digits	=	(String)discr_values.get("HEIGHT_MIN_DIGITS");
		height_max_digits	=	(String)discr_values.get("HEIGHT_MAX_DIGITS");
		height_dec_digits	=	(String)discr_values.get("HEIGHT_DEC_DIGITS");
	}
	if(discr_values.containsKey("WEIGHT_MIN_VALUE")) {	
		weight_min_value	=	(String)discr_values.get("WEIGHT_MIN_VALUE");
		weight_max_value	=	(String)discr_values.get("WEIGHT_MAX_VALUE");
		weight_min_digits	=	(String)discr_values.get("WEIGHT_MIN_DIGITS");
		weight_max_digits	=	(String)discr_values.get("WEIGHT_MAX_DIGITS");
		weight_dec_digits	=	(String)discr_values.get("WEIGHT_DEC_DIGITS");
	}

	HashMap appl_orders	=	bean.getApplicableOrders(facility_id);
	if(appl_orders != null){
		comp_rx_appl_yn		=	(String)appl_orders.get("COMP_RX_APPL_YN")==null?"N":(String)appl_orders.get("COMP_RX_APPL_YN");
		iv_rx_appl_yn		=	(String)appl_orders.get("IV_RX_APPL_YN")==null?"N":(String)appl_orders.get("IV_RX_APPL_YN");
		oncology_rx_appl_yn	=	(String)appl_orders.get("ONCOLOGY_RX_APPL_YN")==null?"N":(String)appl_orders.get("ONCOLOGY_RX_APPL_YN");
		tpn_rx_appl_yn		=	(String)appl_orders.get("TPN_RX_APPL_YN")==null?"N":(String)appl_orders.get("TPN_RX_APPL_YN");
		tdm_appl_yn			=	(String)appl_orders.get("TDM_APPL_YN")==null?"N":(String)appl_orders.get("TDM_APPL_YN");
		man_rem_on_prn_freq_yn =(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN"); 
	}
	HashMap HeaderHtWtValues = (HashMap) presBean.loadHeaderHtWtValues(facility_id,patient_id,encounter_id,act_patient_class);
	if( HeaderHtWtValues.size()>1 ){
		 if(HeaderHtWtValues.containsKey("HEIGHT")){
			leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
			leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		if(HeaderHtWtValues.containsKey("WEIGHT")){
			leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
			leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		if(leg_uom_1==null) 
			leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Cms.label", "ph_labels");
		if(leg_uom_2==null) 
			leg_uom_2=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Kgs.label", "common_labels");
		bsa_str			= (String.valueOf(bsa));
		
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)>0 && !leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)>0  ) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0")) 
			bmi_str= "";
	}
	String bl_disp_charge_dtl_in_rx_yn		= "";
	String disp_charge_dtl_in_drug_lkp_yn	= "";
	String disp_price_type_in_drug_lkp	= "";
	String dc_mar_appl_yn				= "";
	String em_mar_appl_yn				= "";
	String ip_mar_appl_yn				= "";
	String op_mar_appl_yn				= "";
	String disch_med_mar_appl_yn		= "";
	String split_based_priority_yn		= "";
	String split_based_drug_class_yn	= "";
	String print_mar_label_yn="";
	String default_prev_drug_sel ="";
	String allow_priv_to_order_yn="";
	String preview_rx_yn ="";
	String disp_prev_vital_signs_yn ="N";
	String max_length_prn_reason		= "";
	String max_durn_for_ip_pres			= "";
	String chk_for_ip_max_durn_action	= "";
	String max_durn_for_op_pres			= "";
	String chk_for_op_max_durn_action	= "";
	String max_durn_for_dm_pres			= "";
	String chk_for_dm_max_durn_action	= "";
	String trade_display_yn				= "";
	String diag_for_medn_order_by="P"; 
	String leave_fm                     ="";
	String leave_to                     ="";
    String tempstartString = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempendString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempsysString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String problem_ind = "";	
	ArrayList param_vals	=	bean.getParameterValues();
	if(param_vals!=null && param_vals.size()!=0) {
		int iCount=0;
		allow_without_diag				=	(String)param_vals.get(iCount++); //0
		allow_without_wt				=	(String)param_vals.get(iCount++);
		bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(iCount++);
		disp_charge_dtl_in_drug_lkp_yn	=	(String)param_vals.get(iCount++);
		disp_price_type_in_drug_lkp		=	(String)param_vals.get(iCount++);
		dc_mar_appl_yn					=	(String)param_vals.get(iCount++);
		em_mar_appl_yn					=	(String)param_vals.get(iCount++);
		ip_mar_appl_yn					=	(String)param_vals.get(iCount++);
		op_mar_appl_yn					=	(String)param_vals.get(iCount++);
		disch_med_mar_appl_yn			=	(String)param_vals.get(iCount++);
		split_based_priority_yn			=	(String)param_vals.get(iCount++);//10
		split_based_drug_class_yn		=	(String)param_vals.get(iCount++);
		narcotic_aprvl_form_req_yn		=	(String)param_vals.get(iCount++);
		print_narcotic_form_by_default	=	(String)param_vals.get(iCount++);
		rx_qty_by_pres_base_uom_yn		=	(String)param_vals.get(iCount++);
		atc_allergy_alert_level			=   (String)param_vals.get(iCount++);//15
		iCount++; //added for added for CRF MMS-QH-CRF-0068 [IN:037980] (allow_without_diag_dd)//16
		print_mar_label_yn			=   (String)param_vals.get(iCount++); //Added for MMS-QH-CRF-0080 [IN:038064] //17
		iCount++; // added for  MMS-QH-CRF-0080 [IN:038064] //18
		dispPrescripionDuration	=	(String)param_vals.get(iCount++);//19
		diag_for_medn_order_by=(String)param_vals.get(iCount++);//20 //MMS-SCF-0325 [IN:048069]
		default_prev_drug_sel			=   (String)param_vals.get(iCount++); //21 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		preview_rx_yn					=	(String)param_vals.get(iCount++);//22//added for ML-MMOH-CRF-0341 [IN:057179]
		disp_prev_vital_signs_yn	=	(String)param_vals.get(iCount++);//23 //Added for ML-MMOH-CRF-0346 [IN:057185]
		max_length_prn_reason			=   (String)param_vals.get(iCount++); //24
		max_durn_for_ip_pres		=	(String)param_vals.get(iCount++); //25
		chk_for_ip_max_durn_action	=	(String)param_vals.get(iCount++);//26
		max_durn_for_op_pres		=	(String)param_vals.get(iCount++);//27
		chk_for_op_max_durn_action	=	(String)param_vals.get(iCount++); //28
		max_durn_for_dm_pres		=	(String)param_vals.get(iCount++);
		chk_for_dm_max_durn_action	=	(String)param_vals.get(iCount++);
		trade_display_yn			=	(String)param_vals.get(iCount++);
		drug_interaction_check_yn	=	(String)param_vals.get(iCount++);//32
		iCount++;//added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		allow_priv_to_order_yn	=	(String)param_vals.get(iCount++);//34 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
	} 
	String witness_for_verbal_order_yn	= ""; 
	witness_for_verbal_order_yn = bean.getWitnessForVerbalOrder();
	order_remarks	= (String)bean.getPresRemarks();
	LinkedHashMap hmPrev_vital_signs = null;//Added for ML-MMOH-CRF-0346 [IN:057185]
	if("Y".equals(disp_prev_vital_signs_yn) && !("XT".equals(act_patient_class)))//added for ML-MMOH-CRF-0346 [IN:057185]
		hmPrev_vital_signs	=(LinkedHashMap) presBean.loadPrevHtWtValues(facility_id, patient_id,encounter_id, act_patient_class);
	else 
		disp_prev_vital_signs_yn="N";
	HashMap patient_details	=	bean.getPatientDetails_1(patient_id);
	if(patient_details!=null && patient_details.size()!=0) {
		patient_age	=	(String)patient_details.get("age");
		date_of_birth	=	(String)patient_details.get("date_of_birth");
		gender	=	(String)patient_details.get("sex");
		gender	=	gender.substring(0,1).toUpperCase();
	}
	//check for recorded diagnosis
	ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);
	int diag_size	=	(diagnosis).size();
	//getting system date
	//sys_date=(String) DateUtils.getCurrentDate("DMYHM",locale); //Commented for IN031192 - Leap year_CA_Pharmacy order_Thai login
	sys_date=(String) presBean.getSysdate();  //Added for IN031192 - Leap year_CA_Pharmacy order_Thai login
	String pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for CRF RUT-CRF-0063[29601]--start
	String lmp_date                 =presBean.getLMPDate(patient_id);
	double preg_week                =Math.ceil(presBean.getCalPregStage(sys_date,lmp_date));
	String trimester                =presBean.getTrimster(preg_week);
	bean.setPregnencyYN(pregnency_yn);
	bean.setPregTrimester(trimester);//added for CRF RUT-CRF-0063[29601] --end
	bean.setCalledFrom("");
	//getting back date of order date/time
	HashMap BackDates=(HashMap) presBean.getBackDate(sys_date);
	if(BackDates.size()>0){
		back_date			= (String) BackDates.get("BACK_DATE");
		future_date			= (String) BackDates.get("FUTURE_DATE");
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -Start
	if(!locale.equals("en")){
		sys_date =	com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM","en",locale);
		back_date			= com.ehis.util.DateUtils.convertDate(back_date,"DMYHM","en",locale);
		future_date			= com.ehis.util.DateUtils.convertDate(future_date,"DMYHM","en",locale);
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -End
	bean.setOrderDate(sys_date); //Moved from above for IN031192 - Leap year_CA_Pharmacy order_Thai login
	//adding start for Bru-HIMS-CRF-093 [IN:029960]
	HashMap homeleave_vals	=	presBean.getHomeLeaveDates(encounter_id,facility_id);
	ArrayList takeHomeDates = new ArrayList();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	if(homeleave_vals!=null && homeleave_vals.size()>0){
		leave_fm = (String)homeleave_vals.get("LEAVE_FR_DATE");
		leave_to = (String)homeleave_vals.get("LEAVE_TO_DATE");
		tempstartString  = leave_fm.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempendString  = leave_to.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempsysString = (String) presBean.getSysdate().substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_fm);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_to);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		bean.setTakeHomeDates(takeHomeDates);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	homeleave_chk = presBean.getHomeLeaveCHK(tempsysString,tempstartString,tempendString);//adding end for Bru-HIMS-CRF-093 [IN:029960]//Modified for Bru-HIMS-CRF-093-DD1[IN047223]
	//validation for Home Medication
	if(patient_class!=null && patient_class.equals("OP")){
		take_medication_yn_chk	= "";
		take_medication_yn_dis	= "disabled";
		take_medication_yn_val	= "N";
	}
	else{
		if(!patient_class.equals("XT")){			
			medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		}
		if(medication_rec>0){
			take_medication_yn_chk	= "checked";
			take_medication_yn_dis	= "";
			take_medication_yn_val	= "N";
			patient_class="OP";
		}
		else{
			take_medication_yn_chk	= "";
			take_medication_yn_dis	= "disabled";//not to show discharge medication pop
			take_medication_yn_val	= "N";
		}
	}
	if(patient_class.equals("IP")){			//adding start for Bru-HIMS-CRF-093 [IN:029960]
		homeleave_rec=(int)presBean.getHomeLeaveYn(encounter_id,facility_id);
	}
	if(homeleave_rec>0 && homeleave_chk>0 ){
		home_leave_yn_val	= "Y";
	}
	else
		home_leave_yn_val	= "N"; //adding end for Bru-HIMS-CRF-093 [IN:029960]
	if(patient_class.equals("IP") && home_leave_yn_val.equals("Y")) //adding start for Bru-HIMS-CRF-093 [IN:029960] 
		home_leave_disp = "";
	else
		home_leave_disp = "display:none;";
		
	String or_order_type_code_yn="";
	String or_order_type_value="";
	HashMap OrderType=(HashMap) presBean.populateOrderType(patient_class);
	if(OrderType.size()>0){
		or_order_type_code_yn=(String) OrderType.get("ORDER_TYPE_CODE_YN");
		if(or_order_type_code_yn==null) 
			or_order_type_code_yn="N";
	}
	if(or_order_type_code_yn.equals("Y")){
		or_order_type_value=(String) orbean.getOrderTypeValue();
	}
	else{
		or_order_type_value="";
	}		
	ArrayList	ht_wt_uom	=	presBean.getHTWTUOM(patient_id);
	if(ht_wt_uom!=null && ht_wt_uom.size() > 1) {
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		if(leg_value_1==null || leg_value_1.equals("")) {
			leg_uom_1	=	(String)ht_wt_uom.get(0);	
			if( ht_wt_uom.size() > 2) {
				leg_value_1 =	(String)ht_wt_uom.get(2);	
			}
		}
		if(leg_value_2==null || leg_value_2.equals("")) {
			leg_uom_2	=	(String)ht_wt_uom.get(1);	
			if( ht_wt_uom.size() > 4) {
				leg_value_2 =	(String)ht_wt_uom.get(3);
				rec_date	=	(String)ht_wt_uom.get(4);
			}
		}
		if((leg_value_2==null || leg_value_2.equals("")) &&( leg_uom_1==null || leg_uom_1.equals("")))
			rec_date = "";
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		bsa_str			= (String.valueOf(bsa));
		if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0"))
			bmi_str= "";
	}	
	/* code extracted from \eHIS\web\ePH\jsp\PrescriptionHeader_1.jsp ENDS */
%>
<input type="hidden" name="height" id="height" id="height" value="<%=leg_value_1%>" />
<input type="hidden" name="weight" id="weight" id="weight" value="<%=leg_value_2%>" />
<input type="hidden" name="bsa" id="bsa" id="bsa" size="5" maxlength="5" value="<%=bsa_str%>"></td>
<input type="hidden" name="bmi" id="bmi" id="bmi" size="5" maxlength="5" value="<%=bmi_str%>"></td>
<input type="hidden" value="" name="ht_wt_check" id="ht_wt_check" />
<%if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){ %>
<input type="hidden" name="external_prescription" id="external_prescription" value="false" />
<%} else{%>
<input type="hidden" name="external_prescription" id="external_prescription" value="true" />
<%}%>
<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>" />
<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>" />
<input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>" />
<input type="hidden" name="presel_order_category_yn" id="presel_order_category_yn" value="N" />
<!-- TODO check if value is correct-->
<input type="hidden" id="take_home_medication" name="take_home_medication" id="take_home_medication" value="<%=take_medication_yn_val%>" />
<input type="hidden" name="home_leave_yn_chk" id="home_leave_yn_chk" value="<%=home_leave_yn_val%>" />
<input type="hidden" name="allergic_yn" id="allergic_yn" value="<%=allergic_yn%>" />
<!-- <input type="hidden" value="NO" name="order_type" id="order_type"> -->
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>">
<input type="hidden" name="room_num" id="room_num" value="<%=room_num%>">
<!-- TODO check if required -->
<input type="hidden" name="height_unit" id="height_unit" value="<%=leg_uom_1%>">
<input type="hidden" name="weight_unit" id="weight_unit" value="<%=leg_uom_2%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="calculated_date" id="calculated_date" value="<%=calculated_date%>">
<input type="hidden" name="visit_date" id="visit_date" value="<%=visit_date%>">
<input type="hidden" name="ref_sys_date" id="ref_sys_date" value="<%=sys_date%>">
<input type="hidden" name="order_type_code_yn" id="order_type_code_yn" value="<%=order_type_code_yn%>">
<input type="hidden" id="location_type" name="location_type" id="location_type" value="<%=location_type%>">
<input type="hidden" id="location_code" name="location_code" id="location_code" value="<%=location_code%>">
<input type="hidden" name="drug_class" id="drug_class" value="">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<%
String new_patient_class="";
if( take_medication_yn_val == "Y"){
	new_patient_class="IP";
%>
<input type="hidden" name="act_patient_class" id="act_patient_class" id="act_patient_class" value="<%=new_patient_class%>">
<%
}else{
%>
<input type="hidden" name="act_patient_class" id="act_patient_class" id="act_patient_class" value="<%=patient_class%>">
<%
}
%>
<input type="hidden" name="order_remarks" id="order_remarks" value="<%=order_remarks%>">
<input type="hidden" name="actual_patient_class" id="actual_patient_class" value="<%=act_patient_class%>">
<input type="hidden" name="source_type" id="source_type" value="<%=location_type%>">
<input type="hidden" name="source_code" id="source_code" value="<%=location_code%>">
<input type="hidden" name="attend_pract_id" id="attend_pract_id" value="<%=attend_pract_id%>">
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="resp_id" id="resp_id" value="<%=resp_id%>">
<input type="hidden" name="back_date" id="back_date" value="<%=back_date%>">
<input type="hidden" name="future_date" id="future_date" value="<%=future_date%>">
<input type="hidden" name="licence" id="licence" value="<%=licence%>">
<input type="hidden" name="servide_code" id="servide_code" value="<%=servide_code%>"> 
<input type="hidden" name="service_search_yn" id="service_search_yn" value="<%=service_search_yn%>">
<input type="hidden" name="problem_ind" id="problem_ind" value="<%=problem_ind%>">
<input type="hidden" name="version_no" id="version_no" value="<%=version_no%>">
<input type="hidden" name="QueryString" id="QueryString" value="<%=request.getQueryString()%>">
<!-- TODO check if required -->
<input type="hidden" name="take_medication_yn_chk" id="take_medication_yn_chk" value="<%=take_medication_yn_chk%>">
<input type="hidden" name="take_medication_yn_dis" id="take_medication_yn_dis" value="<%=take_medication_yn_dis%>">
<input type="hidden" name="allow_without_wt" id="allow_without_wt" value="<%=allow_without_wt%>">
<input type="hidden" name="allow_without_diag" id="allow_without_diag" value="<%=allow_without_diag%>">
<input type="hidden" name="diag_for_medn_order_by" id="diag_for_medn_order_by" value="<%=diag_for_medn_order_by%>">
<input type="hidden" name="patient_age" id="patient_age" value="<%=patient_age%>">
<input type="hidden" name="date_of_birth" id="date_of_birth" value="<%=date_of_birth%>">
<input type="hidden" name="gender" id="gender" value="<%=gender%>">
<input type="hidden" name="episode_type" id="episode_type" id="episode_type" value="<%=episode_type%>">
<input type="hidden" name="diag_size" id="diag_size" value="<%=diag_size%>">
<input type="hidden" name="diag_text_size" id="diag_text_size" value="<%=bean.getDiagText()==null?" 0 ":(bean.getDiagText()).size()%>">
<input type="hidden" name="sliding_scale" id="sliding_scale" value="">
<input type="hidden" name="num" id="num" value="<%=num%>">
<input type="hidden" name="height_min_value" id="height_min_value" value="<%=height_min_value%>">
<input type="hidden" name="height_max_value" id="height_max_value" value="<%=height_max_value%>">
<input type="hidden" name="weight_min_value" id="weight_min_value" value="<%=weight_min_value%>">
<input type="hidden" name="weight_max_value" id="weight_max_value" value="<%=weight_max_value%>">
<input type="hidden" name="height_min_digits" id="height_min_digits" value="<%=height_min_digits%>">
<input type="hidden" name="height_max_digits" id="height_max_digits" value="<%=height_max_digits%>">
<input type="hidden" name="weight_min_digits" id="weight_min_digits" value="<%=weight_min_digits%>">
<input type="hidden" name="weight_max_digits" id="weight_max_digits" value="<%=weight_max_digits%>">
<input type="hidden" name="iv_prep_default" id="iv_prep_default" value="<%=iv_prep_default%>">
<input type="hidden" name="order_set_code" id="order_set_code" value="<%=order_set_code%>">
<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="">
<input type="hidden" name="bl_disp_charge_dtl_in_rx_yn" id="bl_disp_charge_dtl_in_rx_yn" id="bl_disp_charge_dtl_in_rx_yn" value="<%=bl_disp_charge_dtl_in_rx_yn%>">
<input type="hidden" name="disp_price_type_in_drug_lkp" id="disp_price_type_in_drug_lkp" value="<%=disp_price_type_in_drug_lkp%>">
<input type="hidden" name="disp_charge_dtl_in_drug_lkp_yn" id="disp_charge_dtl_in_drug_lkp_yn" value="<%=disp_charge_dtl_in_drug_lkp_yn%>">
<input type="hidden" name="bl_install_yn" id="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">
<input type="hidden" name="dc_mar_appl_yn" id="dc_mar_appl_yn" value="<%=dc_mar_appl_yn%>">
<input type="hidden" name="em_mar_appl_yn" id="em_mar_appl_yn" value="<%=em_mar_appl_yn%>">
<input type="hidden" name="ip_mar_appl_yn" id="ip_mar_appl_yn" value="<%=ip_mar_appl_yn%>">
<input type="hidden" name="op_mar_appl_yn" id="op_mar_appl_yn" value="<%=op_mar_appl_yn%>">
<input type="hidden" name="disch_med_mar_appl_yn" id="disch_med_mar_appl_yn" value="<%=disch_med_mar_appl_yn%>">
<input type="hidden" name="split_based_priority_yn" id="split_based_priority_yn" value="<%=split_based_priority_yn%>">
<input type="hidden" name="split_based_drug_class_yn" id="split_based_drug_class_yn" value="<%=split_based_drug_class_yn%>">
<input type="hidden" name="max_durn_for_ip_pres" id="max_durn_for_ip_pres" value="<%=max_durn_for_ip_pres%>">
<input type="hidden" name="chk_for_ip_max_durn_action" id="chk_for_ip_max_durn_action" value="<%=chk_for_ip_max_durn_action%>">
<input type="hidden" name="max_durn_for_op_pres" id="max_durn_for_op_pres" value="<%=max_durn_for_op_pres%>">
<input type="hidden" name="chk_for_op_max_durn_action" id="chk_for_op_max_durn_action" value="<%=chk_for_op_max_durn_action%>">
<input type="hidden" name="max_durn_for_dm_pres" id="max_durn_for_dm_pres" value="<%=max_durn_for_dm_pres%>">
<input type="hidden" name="chk_for_dm_max_durn_action" id="chk_for_dm_max_durn_action" value="<%=chk_for_dm_max_durn_action%>">
<input type="hidden" name="trade_display_yn" id="trade_display_yn" value="<%=trade_display_yn%>">
<input type="hidden" name="narcotic_aprvl_form_req_yn" id="narcotic_aprvl_form_req_yn" value="<%=narcotic_aprvl_form_req_yn%>">
<input type="hidden" name="print_narcotic_form_by_default" id="print_narcotic_form_by_default" value="<%=print_narcotic_form_by_default%>">
<!--External Drug Interface Controls -->
<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn" value="<%=drug_db_interface_yn%>">
<input type="hidden" name="drug_db_product_id" id="drug_db_product_id" value="<%=drug_db_product_id%>">
<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="<%=drug_db_dosecheck_yn%>">
<input type="hidden" name="drug_db_duptherapy_yn" id="drug_db_duptherapy_yn" value="<%=drug_db_duptherapy_yn%>">
<input type="hidden" name="drug_db_interact_check_yn" id="drug_db_interact_check_yn" value="<%=drug_db_interact_check_yn%>">
<input type="hidden" name="drug_db_contraind_check_yn" id="drug_db_contraind_check_yn" value="<%=drug_db_contraind_check_yn%>">
<input type="hidden" name="drug_db_allergy_check_yn" id="drug_db_allergy_check_yn" value="<%=drug_db_allergy_check_yn%>">
<input type="hidden" name="adr_count" id="adr_count" value="<%=adr_count%>">
<input type="hidden" name="MAR" id="MAR" value="<%=MAR%>">
<input type="hidden" name="MItemsOnly" id="MItemsOnly" value="<%=MItemsOnly%>">
<input type="hidden" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn" value="<%=man_rem_on_prn_freq_yn%>">
<input type="hidden" name="max_length_prn_reason" id="max_length_prn_reason" value="<%=max_length_prn_reason%>">
<input type="hidden" name="rx_qty_by_pres_base_uom_yn" id="rx_qty_by_pres_base_uom_yn" value="<%=rx_qty_by_pres_base_uom_yn%>">
<input type="hidden" name="weight_rec_appl_age_group_check_flag" id="weight_rec_appl_age_group_check_flag" value="">
<input type="hidden" name="wt_mand_yn" id="wt_mand_yn" value="">
<!-- added for Bru-HIMS-CRF-079 IN[029945]  -->
<input type="hidden" name="ht_mand_yn" id="ht_mand_yn" value="">
<!--  added for Bru-HIMS-CRF-079 IN[029945]  -->
<input type="hidden" name="atc_allergy_alert_level" id="atc_allergy_alert_level" value="<%=atc_allergy_alert_level%>">
<input type="hidden" name="NBPRequestApplYN" id="NBPRequestApplYN" value="<%=NBPRequestApplYN%>">
<input type="hidden" name="drug_interaction_check_yn" id="drug_interaction_check_yn" value="<%=drug_interaction_check_yn%>">
 <input type="hidden" id="priority" name="priority" id="priority" value="R"> 
<input type="hidden" name="home_leave_yn_val" id="home_leave_yn_val" value="<%=home_leave_yn_val%>">
<!-- added for Bru-HIMS-CRF-093[29960] -->
<input type="hidden" name="home_leave_fm" id="home_leave_fm" value="<%=leave_fm%>">
<input type="hidden" name="home_leave_to" id="home_leave_to" value="<%=leave_to%>">
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
<!-- adding end for Bru-HIMS-CRF-093[29960] -->
<input type="hidden" name="print_mar_label_yn" id="print_mar_label_yn" value="<%=print_mar_label_yn%>">
<!-- added for MMS-QH-CRF-0080 [IN:038064] -->
<input type="hidden" name="buildMAR_yn" id="buildMAR_yn" value="N">
<!-- added for MMS-QH-CRF-0080 [IN:038064] -->
<input type="hidden" name="trimester" id="trimester" value="<%=bean.getPregTrimester()%>">
<!--added for CRF RUT-CRF-0063[29601] -->
<input type="hidden" name="lmp_date" id="lmp_date" value="<%=lmp_date%>">
<!--added for CRF RUT-CRF-0063[29601] -->
<input type="hidden" name="pregnency_yn" id="pregnency_yn" value="<%=pregnency_yn%>">
<!--added for CRF RUT-CRF-0063[29601] -->
<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>">
<!--added for ML-BRU-SCF-0958 [IN:042045] -->
<input type="hidden" name="allergy_conf_reqd_yn" id="allergy_conf_reqd_yn" value="<%=allergy_conf_reqd_yn%>">
<!--added for ML-BRU-SCF-0958 [IN:042045] -->
<input type="hidden" name="excludeADRAllergyAlert_yn" id="excludeADRAllergyAlert_yn" value="<%=excludeADRAllergyAlert_yn%>">
<!--Added for HSA-SCF-0011 [IN:042444] -->
<input type="hidden" name="witness_for_verbal_order_yn" id="witness_for_verbal_order_yn" value="<%=witness_for_verbal_order_yn%>">
<!-- Added for AAKH-CRF-0023[IN:038259] -->
<input type="hidden" name="login_user_prac_id" id="login_user_prac_id" value="<%=login_user_prac_id%>">
<!-- Added for AAKH-CRF-0023[IN:038259] -->
<input type="hidden" name="dispPrescripionDuration" id="dispPrescripionDuration" value="<%=dispPrescripionDuration%>">
<!-- Added for BRU-HIMS-CRF-403 [IN:044541] -->
<input type="hidden" name="episode_id" id="episode_id" value="<%=encounter_id%>">
<!-- TODO insert episode id instead of encounter ID-->
<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
<!-- Added for HSA-CRF-0152 [IN:048469] -->
<input type="hidden" name="called_from_verbal_order" id="called_from_verbal_order" value="<%=called_from_verbal_order%>">
<!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete start -->
<input type="hidden" name="default_prev_drug_sel" id="default_prev_drug_sel" value="<%=default_prev_drug_sel%>">
<input type="hidden" name="preview_rx_yn" id="preview_rx_yn" value="<%=preview_rx_yn%>">
<!-- //added for ML-MMOH-CRF-0341 [IN:057179] -->
<input type="hidden" name="allow_priv_to_order_yn" id="allow_priv_to_order_yn" value="<%=allow_priv_to_order_yn%>">
<input type="hidden" name="drug_seach_autocomplete_yn" id="drug_seach_autocomplete_yn" value="<%=bean.getDrugSeachAutocomplete_yn()%>">
<!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end -->
<input type="hidden" name="disp_prev_vital_signs_yn" id="disp_prev_vital_signs_yn" value="<%=disp_prev_vital_signs_yn%>">
<!--added for ML-MMOH-CRF-0346 [IN:057185]-->
<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>">
<!--added for JD-CRF-198-->
<input type="hidden" name="alternateOrder" id="alternateOrder" value="<%=alternateOrder%>">
<!--added for JD-CRF-198-->
<input type="hidden" name="currentStage" id="currentStage" value="<%=currentStage%>">
<!-- Added for IVRxType -->
	<input type="hidden" name="ivrxMode" id="ivrxMode" id="ordersModeType" value="">	
	<input type="hidden" name="ivrxOperation" id="ivrxOperation" id="ivrxOperation" value="New">
<!-- ticksheet on change dropdown-->	
	<input type="hidden" name="ticksheetValue" id="ticksheetValue" id="ticksheetValue" value="<%=defaultSelTickSheet%>">	
	<input type="hidden" name="ticksheetCodeValue" id="ticksheetCodeValue" id="ticksheetCodeValue" value="">
	<input type="hidden" name="ticksheetDescValue" id="ticksheetDescValue" id="ticksheetDescValue" value="">
 <input type="hidden" name="PharmPrescriptionMode" id="PharmPrescriptionMode" id="PharmPrescriptionMode" value="RX">
 <input type="hidden" name="ivrxCheck" id="ivrxCheck" id="ivrxCheck" value="<%=iv_rx_chk%>">
 <input type="hidden" name="cartOpened" id="cartOpened" id="cartOpened" value="N">
<!-- Added for height weight check-->
<input type="hidden" id="weight_mandatory" name="weight_mandatory" id="weight_mandatory" value="N">
<input type="hidden" id="height_mandatory"  name="height_mandatory" id="height_mandatory" value="N">
<input type="hidden" id="height_weight_mandatory" name="height_weight_mandatory" id="height_weight_mandatory" value="N">
 
<%
bean_IVD.setATCAllergyLevel(atc_allergy_alert_level);
bean_IVWA.setATCAllergyLevel(atc_allergy_alert_level);
bean_IVPB.setATCAllergyLevel(atc_allergy_alert_level);
PersistenceHelper.putObjectInBean(bean_id,bean,request);
PersistenceHelper.putObjectInBean(or_bean_id,orbean,request);
PersistenceHelper.putObjectInBean(presBean_id,presBean,request);
PersistenceHelper.putObjectInBean(ph_bean_id,ph_drug_bean,request);
PersistenceHelper.putObjectInBean(pregn_bean_id,pregn_bean,request);
PersistenceHelper.putObjectInBean(param_bean_id,param_bean,request);   
PersistenceHelper.putObjectInBean(bean_id_IVD,bean_IVD,request);
PersistenceHelper.putObjectInBean(bean_id_IVWA,bean_IVWA,request);
PersistenceHelper.putObjectInBean(bean_id_IVPB,bean_IVPB,request);
}
catch(Exception e){
	e.printStackTrace();
}
}
%>
</form>
</div>
</div>
<div class="CSTransactionMessage rxBaseToastContentError" id="transactionMsg2" style="z-index: 900002;">
   <img id="imgTransactionMsg" style="padding-left:15px;vertical-align:middle;" src="${path}/eIPAD/images/PopError.png" onclick="closeToast()">
   <span class="rxToastmsg" id="rxToastmsg2"></span>
   <div class="formValErrorMsgTheme" id="transactionMessageContent"></div>
</div>                                           
<div class="ChartSummaryParent ChartSummaryParentTheme" data-role="page" id="RxOrderFieldsDiv" style="display:none;z-index:10002"></div>
<script src="${path}/eIPAD/js/Pharmacy.js"></script>


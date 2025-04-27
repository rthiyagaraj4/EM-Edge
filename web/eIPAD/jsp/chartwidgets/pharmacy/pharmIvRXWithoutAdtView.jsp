<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<script src="${path}/eIPAD/js/PharmIvRxWithoutAdt.js"></script> 
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
   request.setCharacterEncoding("UTF-8");
   String locale			= (String)session.getAttribute("LOCALE");
   Locale appLocale;
   if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
   appLocale = new Locale((String)session.getAttribute("LOCALE"));
   else 
   appLocale = new Locale("en");
   ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale);   
   PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
   if(patientContext!=null){
   String patient_id = patientContext.getPatientId();
   String encounter_id = patientContext.getEncounterId();
   String patient_class = patientContext.getPatientClass();
   String facility_id = patientContext.getFacilityId();   
   String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
   String or_bean_name		= "eOR.OrderEntryBean";
   OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
   String locn_type			= (String)ORbean.getLocationType();
   String locn_code			= (String)ORbean.getLocationCode();
   String pract_id			= (String)ORbean.getPractitionerId();
   String pract_name		= (String)ORbean.getPractitionerName();  
   String bean_id_IVWA			= "@IVPrescriptionBean_IVWA"+ patient_id + encounter_id;
   String bean_name_IVWA	= "ePH.IVPrescriptionBean";
   IVPrescriptionBean bean_IVWA	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVWA, bean_name_IVWA, request);
   String iv_calc_infuse_by=bean_IVWA.getIVCalcInfuseBy();   
   ArrayList AllFluids = bean_IVWA.getAllFluids();
   String take_home_medication = bean_IVWA.getTakeHomeMedication();
   String drugItemNo = request.getParameter("drugItemNo");
   int value=Integer.valueOf(drugItemNo);
   HashMap fluidDetail = (HashMap)AllFluids.get(value);		
   String drug_desc = (String)fluidDetail.get("DRUG_DESC");
   String order_set_code = (String)fluidDetail.get("ORDER_CATALOG_CODE");
   String qty_desc = (String)fluidDetail.get("QTY_DESC");//ml
   String qty_value = (String)fluidDetail.get("QTY_VALUE"); // 1 ml
   String qty_uom = (String)fluidDetail.get("QTY_UOM");
   String pres_base_uom_desc = (String)fluidDetail.get("PRES_BASE_UOM_DESC");//Bottle
   String pres_qty_value = (String)fluidDetail.get("PRES_QTY_VALUE");//1 bottle
   
   
   /* Dispense Location */

   IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id_IVWA,bean_name_IVWA,request);
   bean.setLanguageId(locale);
   String perf_locn_desc="";
   
   
   String location_type_eph		= request.getParameter("location_type")==null?"":request.getParameter("location_type");
   String location_code_eph		= request.getParameter("location_code")==null?"":request.getParameter("location_code");
   String take_home_medication_eph     = request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
   String priority				    = request.getParameter("priority")==null?"":request.getParameter("priority");
   String iv_prep_yn		        = "5";	
	
   //bean.setTakeHomeMedication(take_home_medication);
   ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(location_type_eph,location_code_eph,take_home_medication_eph,priority,iv_prep_yn,"",patient_id,encounter_id);
	
   if(ord_disp_location != null & ord_disp_location.size()>0){ 
			perf_locn_desc	= (String)ord_disp_location.get(2)==null?"":(String)ord_disp_location.get(2);			
   }
   
   /* Dispense Location ends */
   
   
   String start_date = (String)fluidDetail.get("START_DATE");					
   String durn_value = (String)fluidDetail.get("DURN_VALUE");
   String infusion_over = (String)fluidDetail.get("INFUSE_OVER");
   String infuse_rate = (String)fluidDetail.get("INFUSION_RATE");
   String future_date = (String)fluidDetail.get("FUTURE_DATE");
   String back_date = (String)fluidDetail.get("BACK_DATE");
   String disp_locn_code = (String)fluidDetail.get("DISP_LOCN_CODE");
   String disp_locn_type = (String)fluidDetail.get("DISP_LOCN_TYPE");
   String infuse_over_unit_sch = (String)fluidDetail.get("INFUSE_OVER_UNIT_SCH");
   String mfr_remarks			=(String)fluidDetail.get("MFR_REMARKS");
   if(mfr_remarks ==null){
	   mfr_remarks ="";
   }
   String end_date		= bean_IVWA.populateEndDate(start_date, durn_value, "H");
   String infuse_over_hr		="";
   String infuse_over_mi		="";
   String mfr_yn				= "N";// Need to check
   //String mfr_remarks			= "N";// Need to check
   String mode				= CommonRepository.getCommonKeyValue( "MODE_MODIFY" ); 
   bean_IVWA.setMode( mode ) ;
   if(infusion_over.indexOf(".") != -1){
   			infuse_over_hr = infusion_over.substring(0,infusion_over.indexOf("."));
   			Double temp = new Double(infusion_over);
   			temp = temp*60;
   			temp = (temp%60);
   			infuse_over_mi = String.valueOf(Math.round(temp))+"";   			
   		}
   		else{
   			infuse_over_hr = infusion_over;
   			infuse_over_mi = "";
   		}
   		infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
   		infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;   
   //Build MAR
   String buildMAR_yn		= ""; 
   String buildMAR_checked  = "";
   String buildMAR_enable   = "";
   String buildMAR_rule	    = "";
   infuse_over_hr=(String)fluidDetail.get("INFUSION_PERIOD_VALUE");
   infuse_over_mi=(String)fluidDetail.get("INFUSION_PERIOD_VALUE_MIN"); 
   buildMAR_rule = (String) fluidDetail.get("BUILD_MAR_RULE");
   buildMAR_yn = (String) fluidDetail.get("BUILD_MAR_YN");   
   if(buildMAR_yn.equals("Y"))
		buildMAR_checked ="Checked";
	else
		buildMAR_checked="";
   
   if(buildMAR_rule.equals("CE")){
	   buildMAR_enable   = "";
   }
   else if(buildMAR_rule.equals("UE")){
	   buildMAR_enable   = "";
   }
   else if(buildMAR_rule.equals("CD")){
	   buildMAR_enable   = "disabled";
   }
   else if(buildMAR_rule.equals("UD")){
	   buildMAR_enable   = "disabled";
   }  
   //  'CE' - Checked Enabled  'UE' - Un-Checked Enabled  'CD' - Checked Disabled  'UD' - Un-Checked Disabled   			
   //End
   %>
<div data-role = "none"  class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div>
<div class="ChartSummaryBlockVar" id="rxDetailsSummaryBlock" data-role = "none">
   <form id="rxDetailsIvRxWaViewForm" name = "rxDetailsIvRxWaViewForm" method = "post" action = "" class="ChartSummaryFormElem">
      <div class="ChartSummaryMainTable" data-role = "none">
         <div data-role = "none" class ="ChartSummaryPageHeader">
            <div class="ChartSummaryHeaderCell" data-role = "none">
               <div class="ChartSummaryHeaderCont" data-role = "none">
                  <div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
                     <div class="ChartSummaryHeaderRow" data-role = "none">
                        <div class="ChartSummaryHeaderTextCol" data-role = "none">
                           <div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">IV</div>
                        </div>
                        <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                           <div class="WidgetButtonTheme" data-role = "none" onclick="completeIvRxDetailsConfirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
                        </div>
                        <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                           <div class="WidgetButtonTheme" data-role = "none" onclick="closeIvRxDetailsView()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="">
            <div data-role = "none" class = "ChartSummaryPageContentCell">
               <div data-role = "none" class = "ChartSummaryMainWrapper pharmDataMainWrapper" id="" >
                  <div class="ChartSummaryMainScroller pharmDataContentScroller"  data-role = "none">
                     <div class="table pharmDataItemHeight"  data-role = "none">
                        <div  class="row pharmOrderItemBannerRow"  data-role = "none">
                           <div class="cell pharmOrderItemHeader"  data-role = "none">
                              <div class="table pharmDataItemHeight"  data-role = "none">
                                 <div  class="row pharmItemDescNameCell"  data-role = "none">
                                    <div class="cell pharmRxOrderItemName segoeuiBold"  data-role = "none">
                                       <span class="pharmRxOrderItemName10padding">IV without Additives
                                       </span>
                                    </div>
                                 </div>
                                 <div  class="row pharmItemDescNameCell"  data-role = "none">
                                    <div class="cell pharmRxOrderStrength"  data-role = "none">
                                       <div class="pharmRxOrderItemDesc">
                                          <label class="pharmRxOrderItemLabel">Dispense Location</label>
                                          <span class="pharmRxOrderItemInfo segoeuiBold"><%= perf_locn_desc %></span>
                                       </div>
                                    </div>
                                    <div class="cell pharmRxOrderItemRate"  data-role = "none">
                                       <span class="pharmRxOrderItemRateDesc">-- / --</span>
                                    </div>
                                    <div class="cell pharmRxOrderItemRate"  data-role = "none">
                                       <span class="pharmRxOrderItemRateLabel">Total / Patient</span>
                                    </div>
                                 </div>
                                 <div  class="row pharmCartBottomContainer"  data-role = "none">
                                    <div class="cell pharmCartBottomImg" data-role = "none">										 
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div  class="row pharmIvRxOrderItemBannerRow"  data-role = "none">
                           <div class="cell"  style="padding-left: 5px;" data-role = "none">
                              <div class="table pharmDataItemHeight"  data-role = "none">
                                 <div  class="row pharmItemDescNameCell"  data-role = "none">
                                    <div class="cell pharmRxOrderItemName segoeuiBold"  data-role = "none">
                                       <span style="padding-left: 5px;">Fluid
                                       </span>
                                    </div>
                                 </div>
                                 <div  class="row pharmIvRxItemDescNameCell"  data-role = "none">
                                    <div class="cell pharmRxOrderStrength"  data-role = "none">
                                       <div class="pharmRxOrderItemDesc" style="padding-left:5px !important
                                          ">                                           
                                          <span class="pharmRxOrderItemMainHeader"><%=drug_desc%></span>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div id="pharmIvRxWAScroller" class="row selectPharmOrder pharmOrderIvRxItemContainer" data-role = "none">
                           <div style="position:relative;width:100%;height:auto;">
                              <div class="pharmIvRxDetailRow">
                                 <div  class="pharmIvRxDetailIndRow">
                                    <div class="pharmIvRxLeftDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Start date and time
                                             <font style="color: red">*</font>
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContent">
                                          <input style="width:99.5% ! important;" class="dropDown" id="ivRxStartDate" onchange="strtEndDateTime();"onBlur="strtEndDateTime();" />
                                       </div>
                                    </div>
                                 </div>                               
                                 <div  class="pharmIvRxDetailIndRow">
                                    <div class="pharmIvRxRightDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             End date and time
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContent withAddEnddateCss">
                                          <input style="width:99.3% ! important;padding-left: 2px;" class="dropDown" id="ivRxEndDate" />
                                       </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="pharmIvRxDetailRow">
                                 <div  class="pharmIvRxDetailIndRow">
                                    <div class="pharmIvRxLeftDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Duration for repeat
                                             <font style="color: red">*</font>
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContent">
                                          <input style="width:100% ! important;height:43px;" class="dropDown k-textbox" type="text" id="ivRxDurationForRepeat" maxlength="3" value="<%= durn_value %>"/>
                                          <div class="pharmIvRxDetailInnerContent">Hours</div>
                                       </div>
                                    </div>
                                 </div>                               
                                 <div  class="pharmIvRxDetail2IndRow">
                                    <div class="pharmIvRxRightDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Infusion rate
                                             <font style="color: red">*</font>
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContentWa">
                                          <input style="width:100% ! important;height:43px;" class="dropDown k-textbox" type="text" id="ivRxInfusionRate" maxlength="7"  onKeyPress="return allowValidNumber(this,event,6,2);" value="<%= infuse_rate %>"/>
                                          <div style="width: 98%;" class="pharmIvRxDetailInnerContent"><%= pres_base_uom_desc %></div>
										  <div  class="pharmIvRxDetailInnerContent" style="height:auto;margin-right: -5px;">/ </div>
                                       </div>								   
                                    </div>
                                 </div>
                                 <div  class="pharmIvRxDetail2IndRow">
                                    <div class="pharmIvRxLeftDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">								 
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContent">
                                          <input style="width: calc(100% - 5px)! important;"  name="ivRxInfusionDpList" id="ivRxInfusionDpList" class="dropDown" type="text" id="ivRxInfusionDpList" />															 
                                       </div>
                                    </div>
                                 </div>
                              </div>
                              <div class="pharmIvRxDetailRow">
                                 <div  class="pharmIvRxDetailIndRow">
                                    <div class="pharmIvRxLeftDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Volume
                                             <font style="color: red">*</font>
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContent">
                                          <input style="width:100% ! important;height:43px;" class="dropDown k-textbox" type="text" id="ivRxVolumeUnit" maxlength="5" value="<%= qty_value %>"/>
                                          <div class="pharmIvRxDetailInnerContent"><%= pres_base_uom_desc %></div>
                                       </div>
                                    </div>
                                 </div>                               
                                 <div  class="pharmIvRxDetail2IndRow">
                                    <div class="pharmIvRxRightDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Infuse over
                                             <font style="color: red">*</font>								 
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContentWa">
                                          <input style="width:100% ! important;height:43px;"  class="dropDown k-textbox" type="text" id="ivRxInfusionOverHrs" name="ivRxInfusionOverHrs" id="ivRxInfusionOverHrs" maxlength="2" value="<%=infuse_over_hr%>"/>
                                          <div style="width: 97%;" class="pharmIvRxDetailInnerContent">Hrs</div>
                                       </div>
                                    </div>
                                 </div>
                                 <div  class="pharmIvRxDetail2IndRow">
                                    <div class="pharmIvRxLeftDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">								 
                                          </div>
                                       </div>
                                       <div class="pharmIvRxDetailCntlContent">
                                          <input style="width: calc(100% - 5px)! important;height:43px;" class="dropDown k-textbox" type="text" id="ivRxInfusionOverMins" name="ivRxInfusionOverMins" id="ivRxInfusionOverMins" maxlength="2" value="<%=infuse_over_mi%>"/>
                                          <div style="width:calc(100% - 10px);right:6px;" class="pharmIvRxDetailInnerContent">Mins</div>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                              <div style="width: 100%;height: 120px;">
                                 <div  style="float: left;width: 49%;height: 100px;">
                                    <div class="pharmIvRxLeftDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Drug remarks							 
                                          </div>
                                       </div>
                                       <div style="width: 99%;height: 57px;">
                                          <textarea type="text" style="width:100% ! important;height:50px;"maxlength="255" id="ivRxDrugRemarks" class="dropDown k-textbox" value="<%=URLDecoder.decode(mfr_remarks, "UTF-8")%>"><%=URLDecoder.decode(mfr_remarks, "UTF-8")%></textarea>								 
                                       </div>
                                    </div>
                                 </div>                             
                                 <div  style="float: left;width: 49%;height: 100px;">
                                    <div class="pharmIvRxRightDetailRowContent" >
                                       <div class="pharmIvRxDetailLabel" >
                                          <div class="pharmIvRxDetailLabelContent segoeuiBold">
                                             Build MAR							 
                                          </div>
                                       </div>
                                       <div style="width: 99%;height: 57px;">
									     <input id="buildMarChk" style="height: 20px;width: 20px;" type="checkbox" name='buildMarChk' id='buildMarChk' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> />
										 </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>						
							<!-- Pharmacy legend starts -->
							<div id="ivRxWithoutAddLegend"></div>
							<!-- Pharmacy legend ends --> 
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}"/>
      <input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
      <input type="hidden" name="start_date" id="start_date" value="<%=start_date%>">
      <input type="hidden" name="end_date" id="end_date" value="<%=end_date%>">
      <input type="hidden" name="back_date" id="back_date" value="<%=back_date%>">
      <input type="hidden" name="future_date" id="future_date" value="<%=future_date%>">	
      <input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id_IVWA %>">
      <input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name_IVWA %>">
      <input type="hidden" name="iv_calc_infuse_by" id="iv_calc_infuse_by" value="<%= iv_calc_infuse_by %>">
	  <INPUT TYPE="hidden" name="infusion_over_insert_value" id="infusion_over_insert_value" VALUE='<%=infusion_over%>' >
	  <INPUT TYPE="hidden" name="FLUID_CODE" id="FLUID_CODE" VALUE="<%=order_set_code %>">
	  <INPUT TYPE="hidden" name="mfr_yn" id="mfr_yn" VALUE="<%=mfr_yn %>">	  
	  <input type="hidden" name="stock_value" id="stock_value" value="<%=qty_value%>">
	  <input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
	  <input type="hidden" name="disp_locn_type" id="disp_locn_type" value="<%=disp_locn_type%>">
	  <input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	  <input type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication%>">
	  <input type="hidden" name="mode" id="mode" value="<%=mode%>">
	  <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	  <input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	  <input type="hidden" name="locn_code" id="locn_code" value="<%=locn_code%>">
	  <input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>">
	  <input type="hidden" name="infuse_over_unit_sch" id="infuse_over_unit_sch" value="<%=infuse_over_unit_sch%>">	  	  
      <div class="CSTransactionMessage" id="transactionMsg1" style="background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002">
         <img style="padding-left:15px;vertical-align:middle;" src="${path}/eIPAD/images/PopError.png" onclick="closeToast()"/>
         <span class="rxToastmsg" id="contentRxToastMsg1">No records found</span>
         <div class="formValErrorMsgTheme" id="transactionMessageContent1"></div>
      </div>
      <div id="confirmMsg" class="absoluteCenter" style="z-index: 10005;">
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
               <div class="Error_btn_div_con" id="okClick" onclick="okClickDialog()">OK </div>
               <div class="Error_btn_div"> </div>
               <div class="Error_btn_div_con" id="cancelClick" onclick="cancelClickDialog()" data-value="true">Cancel </div>
            </div>
            <div class="top_shadow"> </div>
         </div>
      </div>
   </form>
</div>
<%
   }    
     %>


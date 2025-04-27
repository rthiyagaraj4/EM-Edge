<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.recordconsent.healthobject.RecordConsentFieldItem"%>
<%@page import="eIPAD.chartsummary.recordconsent.response.RecordConsentFieldResponse"%>
<%@page import="eIPAD.chartsummary.recordconsent.bc.RecordConsentBC"%>
<%@page import="eOR.ConsentOrders"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import="eIPAD.chartsummary.common.response.ErrorInfo" %>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<%
Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

String bean_id = "Or_ConsentOrders" ;
String bean_name = "eOR.ConsentOrders";
ConsentOrders bean = (ConsentOrders)PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
String SingleVariable=request.getParameter("SingleVariable")==null?"false":request.getParameter("SingleVariable");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
%>

<script>

$( document ).ready(function() {      
        initConsentListScroller();	 
     var singleItem= $("#singleItem").val();
		
		if(singleItem=="true"){
			
			  $("#ConsentFormSelPopup").show();
			showMez('ConsentFormSelPopup');	 
		}
	 
	
        $("#RecordConsentCanceBtn").off();
        $("#RecordConsentCanceBtn").click(function() {
        	returnToIPList();
    	});
        disableButtonId('RecordConsentTickBtn');
});


var consentListScroll;
function initConsentListScroller() {
	consentListScroll = new IScroll('#ConsentMainWrapper', { 
		scrollX: false, 
		scrollY: true, 
		scrollbars: true,
		interactiveScrollbars: true,
		click: true
	});
}


</script>
	<div class="consentListContainer">
		<div class="consentList">
			<div id="ConsentMainWrapper" class="ConsentMainWrapper" data-role="none">
				<div class="ConsentMainscroller" class="ConsentMainscroller" data-role="none">	
<%
if(patientContext!=null){
	String locale = patientContext.getLocale();
	String facility_id = (String)session.getValue("facility_id");
	String source_type = "";
	String source_code = "";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String priority = "";
	String ord_cat = "";
	String order_by = "P";
	String patientId = patientContext.getPatientId();
	ArrayList StatusDetail = new ArrayList();
	String period_from = "";
	String period_to = "";
	int start = 1;
	int end = 500; //TODO remove this arbitrary number
	String practitioner_type = (String)session.getValue("practitioner_type");
	String speciality_code = "";
	String consentRec_order_id = "";
	
	String order_catalog_code;
	String order_catalog_desc;
	String order_id;
	String order_line_num;
	
	int consent_req_bef_order;
	int consent_req_bef_regn;
	String consent_stage = "";
	int total_consents;
	
	StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
	ArrayList multiConsentList = new ArrayList();
	ArrayList multiNonAssConsentList = new ArrayList();
	String[] multiConsentDtls = null;
	String[] multiConsentLine = null;
	
	if(StatusDetail.size()>0){
		for(int k=0;k<StatusDetail.size();k++){
			int consent_seq = 1;
			String[] record = (String[])StatusDetail.get(k);
			if(record[2].compareTo("R")==0)
			{
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
			else if(record[2].compareTo("U")==0)
			{		 
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");	
			}
			else if(record[2].compareTo("S")==0)
			{
				record[2]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			}	
			
			order_catalog_code	=(String)record[24];
			order_id = (String)record[5];
			order_line_num = (String)record[25];
			multiConsentLine = new String[4];
			multiConsentLine = bean.MultiListConsentsLine((String)record[5],(String)record[25]);
			consent_req_bef_order = Integer.parseInt(multiConsentLine[2]);
			consent_req_bef_regn = Integer.parseInt(multiConsentLine[3]);
			total_consents = consent_req_bef_order + consent_req_bef_regn;
			order_catalog_desc = (String) multiConsentLine[1];
			
			multiConsentDtls = bean.MultiListDtls(order_catalog_code, practitioner_id);
			multiConsentList = null;
			if(multiConsentDtls[0].equals("F"))
			{
				multiConsentList = bean.multiConsentDraftValues(order_catalog_code,order_id,order_line_num);
			}
			if(multiConsentList==null || multiConsentList.size()==0)
			{
				multiConsentList = bean.MultiListConsentsForNew(order_catalog_code,order_id,order_line_num, practitioner_id);
			}
			boolean singleCol = false;
			int noOfRows = 0;
			/* multiConsentList	 = bean.MultiListConsentsdtl(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			if(multiConsentList.size()==0)
			{
				multiConsentList	 = bean.MultiListConsents(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);
			} */
			//multiNonAssConsentList = bean.MultiListConsentsNotAssociated(order_catalog_code,(String)record[5],(String)record[25], practitioner_id);	
			
			
%>				
				
					
					<!-- Each Consent item STARTS -->
   					<div class="consentListItemContainer" cellpadding = "0" cellspacing = "0"  border = "0">
        				
<%
			if(total_consents==1){
				consent_seq++;
				if(consent_req_bef_order == 1){
					consent_stage ="A";
				}else if(consent_req_bef_regn == 1){
					consent_stage ="R";
				}
%>					                
<%
				if(multiConsentDtls[0].equals("F") && !multiConsentDtls[5].equals("") && !multiConsentDtls[3].equals("")){
				
%>
						<div class="trIpRows1 consentListItem" style="margin-bottom:5px;" onclick="editConsentForm('<%=k%>','<%=multiConsentDtls[3] %>','<%=multiConsentDtls[5] %>','<%=consent_stage%>')">
           					<!-- <td class="tdLegendCol" align="center" valign = "center" style = "width:30px;"> -->
           					<div  class="consentListItemCol1">
              					<div class = "" ><img src="${path}/eIPAD/images/consentIcon30x30.png"/></div>
           					</div>
           					<div class="consentListItemCol2">
					             <div class = "consentDetails" border = "0" cellpadding = "0" cellspacing = "0">
					            
									<div class="rows trIpChildRows">
					                	<div class="rowdata" colspan = "2" >
					                          <div class = "txtRows txtRowsTheme" style="color:#333b46; padding-left:0px;"><%=order_catalog_desc %>
					                          	<span class = "txtRows ptIdGender "style="color:#a3a3a3;"><%=record[2] %></span>
					                          </div>
					                    </div>
					                </div>
									<div class="rows trIpChildRows">
				                         <div class="rowdata" colspan = "2">				                        
				                          	<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f"><%=multiConsentDtls[5] %>,</span>
<%
				if(consent_req_bef_order == 1){
%>
											<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">
				                          		Before Order Release
				                          	</span>
<%
				}else if(consent_req_bef_regn == 1){
%>
                  							<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">
				                          		Before Order Registration
				                          	</span>
<%
				}
%>
										</div>
									</div>
									<div class="rows trIpChildRows">
					                    <div class="rowdata" >
					                     	<span class="lz-list-data2 lz-list-data2Theme"><%=record[8] %></span>
					                   </div>
					                </div>
					             </div>
           					</div>
        				</div>				                          	
<%
			}else{
				if(multiConsentList.size()>0){
					String[] singleVariableConsent = (String[])multiConsentList.get(0);
					
%>
						<div class="trIpRows1 consentListItem" style="margin-bottom:5px;" onclick="editConsentForm('<%=k%>','<%=singleVariableConsent[1] %>','<%=singleVariableConsent[2] %>','<%=consent_stage%>')">
           					<!-- <td class="tdLegendCol" align="center" valign = "center" style = "width:30px;"> -->
           					<div  class="consentListItemCol1">
              					<div class = "" ><img src="${path}/eIPAD/images/consentIcon30x30.png"/></div>
           					</div>
           					<div class="consentListItemCol2">
					             <div class = "consentDetails" border = "0" cellpadding = "0" cellspacing = "0">
					            
									<div class="rows trIpChildRows">
					                	<div class="rowdata" colspan = "2" >
					                          <div class = "txtRows txtRowsTheme" style="color:#333b46; padding-left:0px;"><%=order_catalog_desc %>
					                          	<span class = "txtRows ptIdGender "style="color:#a3a3a3;"><%=record[2] %></span>
					                          </div>
					                    </div>
					                </div>
									<div class="rows trIpChildRows">
										<div class="rowdata" colspan = "2">
											<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f"><%=singleVariableConsent[2] %>,</span>
<%
				if(consent_req_bef_order == 1){
%>
											<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">
				                          		Before Order Release
				                          	</span>
<%
				}else if(consent_req_bef_regn == 1){
%>
                  							<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">
				                          		Before Order Registration
				                          	</span>
<%
				}
%>
										</div>
									</div>
									<div class="rows trIpChildRows">
					                    <div class="rowdata" >
					                     	<span class="lz-list-data2 lz-list-data2Theme"><%=record[8] %></span>
					                   </div>
					                </div>
					             </div>
           					</div>
        				</div>											
<%			
				}
				else{
%>
						<div class="trIpRows1 consentListItem" style="margin-bottom:5px;" onclick="showConsentSelPop(this)" data-order_index='<%=k%>' data-comp='5'  data-consent_seq='1' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>' data-stage-catalog="<%=consent_stage%>">
           					<!-- <td class="tdLegendCol" align="center" valign = "center" style = "width:30px;"> -->
           					<div  class="consentListItemCol1">
              					<div class = "" ><img src="${path}/eIPAD/images/consentIcon30x30.png"/></div>
           					</div>
           					<div class="consentListItemCol2">
					             <div class = "consentDetails" border = "0" cellpadding = "0" cellspacing = "0">
					            
									<div class="rows trIpChildRows">
					                	<div class="rowdata" colspan = "2" >
					                          <div class = "txtRows txtRowsTheme" style="color:#333b46; padding-left:0px;"><%=order_catalog_desc %>
					                          	<span class = "txtRows ptIdGender "style="color:#a3a3a3;"><%=record[2] %></span>
					                          </div>
					                    </div>
					                </div>
									<div class="rows trIpChildRows">
										<div class="rowdata" colspan = "2"  
										<%
				if(consent_req_bef_order == 1){
					
%>
data-stage-catalog='A'
		
<%
				}else if(consent_req_bef_regn == 1){
%>
data-stage-catalog='R'
<%
				}
%>
										>											
											<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">Choose consent form <img src="${path}/eIPAD/images/AddConsent16x16.PNG" style="vertical-align:middle" title="Add button"></img>,</span>
<% if(SingleVariable.equals("true")) { %>
											<script type="text/javascript">
											
											
											var index=0;
											
											var consent_seq="1";
											var order_catalog='<%=order_catalog_code%>';
											var order_id='<%=order_id%>';
											var order_line_num='<%=order_line_num%>';
    $("#currentCode").val(order_catalog);
	$("#currentOrderId").val(order_id);
	$("#currentLineNum").val(order_line_num);
	$("#currentSeq").val(consent_seq);
	$("#currentindex").val(index);
	
																					
											</script>
	<%
				}
%>										

<%
				if(consent_req_bef_order == 1){
%>
<script>
$("#currentstage").val("A");
</script>
											<span data-stage-catalog='A' class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">
				                          		Before Order Release
				                          	</span>
<%
				}else if(consent_req_bef_regn == 1){
%>
      
<script>
$("#currentstage").val("R");
</script>
	  <span  data-stage-catalog='R' class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">
				                          		Before Order Registration
				                          	</span>
<%
				}
%>
										</div>
									</div>
									<div class="rows trIpChildRows">
					                    <div class="rowdata" >
					                     	<span class="lz-list-data2 lz-list-data2Theme"><%=record[8] %></span>
					                   </div>
					                </div>
					             </div>
           					</div>
        				</div>
<%					
				}
			}
%>


<%
			}
%>
					                
<%
			if(total_consents>1){
				
%>        				<div class="trIpRows1 consentListItem" style="margin-bottom:5px;">
           					<!-- <td class="tdLegendCol" align="center" valign = "center" style = "width:30px;"> -->
           					<div  class="consentListItemCol1">
              					<div class = "" ><img src="${path}/eIPAD/images/consentIcon30x30.png"/></div>
           					</div>
           					<div class="consentListItemCol2">
					             <div class = "consentDetails" border = "0" cellpadding = "0" cellspacing = "0">
					            
									<div class="rows trIpChildRows">
					                	<div class="rowdata" colspan = "2" >
					                          <div class = "txtRows txtRowsTheme" style="color:#333b46; padding-left:0px;"><%=order_catalog_desc %>
					                          	<span class = "txtRows ptIdGender "style="color:#a3a3a3;"><%=record[2] %></span>
					                          </div>
					                    </div>
					                </div>
					                <div class="rows trIpChildRows">
					                    <div class="rowdata" >
					                     	<span class="lz-list-data2 lz-list-data2Theme"><%=record[8] %></span>
					                   </div>
					                </div>
					             </div>
           					</div>
        				</div>
        				<!-- MultiConsent Table STARTS -->
						<div class="trIpRows1 consentListItem" style="margin-bottom:5px">
           					<!-- <td class="tdLegendCol" align="center" valign = "center" style = "width:30px;"> -->
           					<div  class="consentListItemCol1">
              					<div class = ""  style="width:100px;"></div>
           					</div>
           					<div class="consentListItemCol2" style="width:100%">
								<div class="contentInsideTable">
									<div style="display:table-row;width: 100%;">
        								<div style="display: table-cell;">
        									<div class="consentListTab">
        										<div class="consentListRow">
<%
				if(consent_req_bef_order>=1 && consent_req_bef_regn>=1){
					noOfRows = consent_req_bef_order>consent_req_bef_regn?consent_req_bef_order:consent_req_bef_regn;
%>        										
        											<div class="consentListCol">Before Order Release</div>
        											<div class="consentListCol consentListColBoder">Before Order Registration</div>
<%
				}else if(consent_req_bef_order>1){
					singleCol = true;
					noOfRows = consent_req_bef_order;
%>
													<div class="consentListCol">Before Order Release</div>

<%
				}else if(consent_req_bef_regn>1){
					singleCol = true;
					noOfRows = consent_req_bef_regn;
%>
													<div class="consentListCol">Before Order Registration</div>

<%
				}
%>        			
    										
        										</div>
        									</div>
        				
        								</div>
        							</div>
<%
				ArrayList befRelConsentList = new ArrayList();
				ArrayList befRegConsentList = new ArrayList();
				for(int i=0;i<multiConsentList.size();i++){
					//befRelConsentList = new ArrayList();
					//befRegConsentList = new ArrayList();
					String[] multiConsentValues = (String[])multiConsentList.get(i);
					if(multiConsentValues[3].equals("A"))
						befRelConsentList.add(multiConsentValues);
					if(multiConsentValues[3].equals("R"))
						befRegConsentList.add(multiConsentValues);
				}
				
				for(int i=0;i<noOfRows;i++){
					
%>
        							<div style="display:table-row;width: 100%;">
        								<div style="display: table-cell;">
        									<div class="consentListTab">
        										<div class="consentListRow">
<%
					if(!singleCol){
						if(i < consent_req_bef_order){
							//consent_seq++;
							String[] multiConsentValues;
							if(befRelConsentList.size()>i){
								multiConsentValues = (String[])befRelConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;
%>													<div class="consentListColContent" data-order_index="<%=k%>" data-consent_form_id="<%=multiConsentValues[1]%>" data-consent_seq="<%=consent_seq %>" onclick="editConsentForm('<%=k%>','<%=multiConsentValues[1] %>','<%=multiConsentValues[2] %>','<%=multiConsentValues[3]%>')">
        												<div onclick="" data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/EditForm_18x18.png" style="vertical-align:middle;padding-left:10px;"></img>
														</div>
        											</div>
<%
								}else{
									consent_seq++;
%>													<div class="consentListColContent" data-consent_seq="<%=consent_seq %>">
        												<div onclick=""  data-consent-id='<%=multiConsentValues[1]%>' data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/ConsentComplete_18x18.png" style="vertical-align:middle;padding-left:10px;" title="dbltickButton"></img>
														</div>
        											</div>
<%								
								}
							}else{
%>								
													<div class="consentListColContent">
        												<div onclick="showConsentSelPop(this)"  data-order_index='<%=k%>'  data-comp='3' data-stage-catalog='A'  data-consent_seq='<%=consent_seq %>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>' data-consent_seq=<%=consent_seq %>>Choose consent form
																<img src="${path}/eIPAD/images/AddConsent16x16.PNG" style="vertical-align:middle;padding-left:10px;" title="Add button"></img>
														</div>
													</div>
<%								
							}
						}else{
%>
													<div class="consentListColContent">
        												
        											</div>
<%							
						}
						
						if(i < consent_req_bef_regn){
							//consent_seq++;
							String[] multiConsentValues;
							if(befRegConsentList.size()>i){
								multiConsentValues = (String[])befRegConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;
%>													<div class="consentListColContent consentListColBoder" data-order_index="<%=k%>" data-consent_form_id="<%=multiConsentValues[1]%>" data-consent_seq="<%=consent_seq %>" onclick="editConsentForm('<%=k%>','<%=multiConsentValues[1] %>','<%=multiConsentValues[2] %>','<%=multiConsentValues[3]%>')">
        												<div onclick="" data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>' ><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/EditForm_18x18.png" style="vertical-align:middle;padding-left:10px;"></img>
														</div>
        											</div>
<%
								}else{
									consent_seq++;
%>													<div class="consentListColContent consentListColBoder" data-consent_seq='<%=consent_seq %>'>
        												<div onclick="" data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>' ><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/ConsentComplete_18x18.png" style="vertical-align:middle;padding-left:10px;" title="dbltickButton"></img>
														</div>
        											</div>
<%								
								}
							}else{
%>								
													<div class="consentListColContent consentListColBoder" data-consent_seq='<%=consent_seq %>'>
        												<div onclick="showConsentSelPop(this)" data-order_index='<%=k%>'  data-comp='2' data-stage-catalog='R' data-consent_seq='<%=consent_seq %>'data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'>Choose consent form
																<img src="${path}/eIPAD/images/AddConsent16x16.PNG" style="vertical-align:middle;padding-left:10px;" title="Add button"></img>
														</div>
													</div>
<%								
							}
						}else{
%>
													<div class="consentListColContent consentListColBoder">
        												
        											</div>
<%							
						}
					}else{
						//consent_seq++;
						if(i < consent_req_bef_order){
							String[] multiConsentValues;
							if(befRelConsentList.size()>i){
								multiConsentValues = (String[])befRelConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;
%>													<div class="consentListColContent" data-order_index="<%=k%>" data-consent_form_id="<%=multiConsentValues[1]%>" data-consent_seq="<%=consent_seq %>" onclick="editConsentForm('<%=k%>','<%=multiConsentValues[1] %>','<%=multiConsentValues[2] %>','<%=multiConsentValues[3]%>')">
														<div onclick="" data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/EditForm_18x18.png" style="vertical-align:middle;padding-left:10px;"></img>
														</div>
													</div>
<%
								}else{
									consent_seq++;
%>													<div class="consentListColContent" data-consent_seq='<%=consent_seq %>'>
														<div onclick=""  data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/ConsentComplete_18x18.png" title="dbltickButton" style="vertical-align:middle;padding-left:10px;"></img>
														</div>
													</div>
<%								
								}
								
							}
							else{
%>								
													<div class="consentListColContent" data-consent_seq='<%=consent_seq %>'>
        												<div onclick="showConsentSelPop(this)" data-order_index='<%=k%>'  data-comp='1' data-stage-catalog='A' data-consent_seq='<%=consent_seq %>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'>Choose consent form
																<img src="${path}/eIPAD/images/AddConsent16x16.PNG" style="vertical-align:middle;padding-left:10px;" title="Add button"></img>
														</div>
													</div>
<%								
							}
						}else if(i < consent_req_bef_regn){
							//consent_seq++;
							String[] multiConsentValues;
							if(befRegConsentList.size()>i){
								multiConsentValues = (String[])befRegConsentList.get(i);
							}else{
								multiConsentValues = null;
							}
							if(multiConsentValues!=null){
								if(multiConsentValues[10].equals("N")){
									consent_seq++;
%>												<div class="consentListColContent" data-order_index="<%=k%>" data-consent_form_id="<%=multiConsentValues[1]%>" data-consent_seq="<%=consent_seq %>" onclick="editConsentForm('<%=k%>','<%=multiConsentValues[1] %>','<%=multiConsentValues[2] %>','<%=multiConsentValues[3]%>')">
														<div onclick="" data-consent-id='<%=multiConsentValues[1]%>'  data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/EditForm_18x18.png" style="vertical-align:middle;padding-left:10px;"></img>
														</div>
													</div>
<%
								}else{
									consent_seq++;
%>										
													<div class="consentListColContent" data-consent_seq='<%=consent_seq %>'>
														<div onclick=""  data-consent-id='<%=multiConsentValues[1]%>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'><%=multiConsentValues[2] %>
																<img src="${path}/eIPAD/images/ConsentComplete_18x18.png" style="vertical-align:middle;padding-left:10px;" title="dbltickButton"></img>
														</div>
													</div>
<%								
								}					
							}
							else{
%>								
													<div class="consentListColContent" data-consent_seq='<%=consent_seq %>'>
        												<div onclick="showConsentSelPop(this)" data-order_index='<%=k%>' data-comp='4' data-stage-catalog='R' data-consent_seq='<%=consent_seq %>' data-order-catalog='<%=order_catalog_code%>' data-order_id='<%=order_id%>' data-order_line_num='<%=order_line_num%>'>Choose consent form
																<img src="${path}/eIPAD/images/AddConsent16x16.PNG" style="vertical-align:middle;padding-left:10px;" title="Add button"></img>
														</div>
													</div>
<%								
							}
						}	
					}
%>        											
        										</div>
        									</div>
        								</div>
        							</div>
<%
				}
%>        							
								</div>
           					</div>
        				</div>
        				<!-- MultiConsent Table ENDS -->
<%
			}
%>        				
					</div>
					
					<input type="hidden" id="consentOrderItem<%=k%>" name="consentOrderItem<%=k%>" 
						data-order_catalog_code="<%=order_catalog_code%>"
						data-order_id="<%=order_id%>"
						data-order_line_num="<%=order_line_num%>"
						data-consent_form_list="<%=multiConsentDtls[0]%>"
						data-recd_consent_id=""
						data-chk="Y"
						data-consent_form_id="<%=multiConsentDtls[3]%>"
						data-consent_stage="<%=multiConsentDtls[4]%>"
						data-noteligible_consent_id=""
						data-patient_name="<%=record[20]%>"
						data-ord_typ_code="<%=record[12]%>"
						data-ord_status="<%=record[13]%>"
						data-ord_consent_yn="<%=record[17]%>"
						data-ord_id="<%=record[5]%>"
						data-ord_line_num="<%=record[25]%>"
						data-appt_reqd_yn="<%=record[26]%>"
						data-order_pract_name="<%=record[21]%>"
						data-ord_appr_by_user_id="<%=record[16]%>"
						data-ord_appr_reqd_yn="<%=record[15]%>"
						data-ord_consent_by_id="<%=record[18]%>"
						data-ord_consent_reqd_yn="<%=record[17]%>"
						data-order_catalog_code="<%=record[24]%>"
						data-patientdetails="<%=record[20]+","+patientContext.getGender()+"/"+record[27]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[6]%>"
						data-order_category="<%=record[0]%>"
						data-ord_catalog_desc="<%=record[9]%>"
						data-pat_class="<%=record[4]%>"
						data-pat_id="<%=record[6]%>"
						data-priority="<%=record[2]%>"
						data-location_type="<%=record[10]%>"
						data-location_code="<%=record[11]%>"
						data-encount_id="<%=record[7]%>"
						data-ord_auth_reqd_yn="<%=record[22]%>"
						data-ord_auth_by_pract_id="<%=record[23]%>"
						data-link_ref_no=""
						data-link_ref=""
						data-link_ref_det=""
						data-con_bo_cnt="<%=consent_req_bef_order%>"
						data-con_br_cnt="<%=consent_req_bef_regn%>"
						data-con_rbo_cnt="<%=consent_req_bef_order%>"
						data-con_rbr_cnt="<%=consent_req_bef_regn%>"
						data-con_id=""
						data-con_stage=""
						data-order_set_id="<%=record[28]%>"
						data-consent_seq="<%=consent_seq%>"
						/>
					
<%
		}
%>
			<%-- 			<input type="hidden" name="from" id="from" value="<%=from%>">
			<input type="hidden" name="to" id="to" value="<%=to%>"> --%>
			<input type=hidden name='total_recs' id='total_recs' value='<%=StatusDetail.size()%>'>
			<input type=hidden name='singleItem' id='singleItem' id='singleItem' value='<%=SingleVariable%>'>
			<input type="hidden" name="mode" id="mode" value="1">
			<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id%>">
			<%-- <input type="hidden" name="practitioner_name" id="practitioner_name" value="<%= practitioner_name%>"> --%>
			<input type="hidden" name="security_level" id="security_level" value="">
			<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale)%>">
			<!--<input type="hidden" name="pract_id" id="pract_id" value="">--><!--returned frm modal window-->
			<input type="hidden" name="source_type" id="source_type" value="">
			<input type="hidden" name="source_code" id="source_code" value="">
			<%-- <input type="hidden" name="priority" id="priority" value="<%=priority%>"> --%>
			<%-- <input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
			<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>"> --%>
			<%-- <input type="hidden" name="ord_cat_desc" id="ord_cat_desc" value="<%=ord_cat_desc%>">
			<input type="hidden" name="priority_desc" id="priority_desc" value="<%=priority_desc%>"> --%>
			<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
			<%-- <input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
			<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>"> --%>
			<input type="hidden" name="function_id" id="function_id" value="">	

<%
	}else{
%>
		<div class="consentListItemContainer"> No Pending Consents for this patient</div>
<%	
	}
}else{
	out.println("No Patient Selected");
}

%>					

	
   				</div>	
   			</div>				
	<!--  legend scroll portion ends-->	
		</div>
	</div>
<%
PersistenceHelper.putObjectInBean(bean_id,bean,request);


%>


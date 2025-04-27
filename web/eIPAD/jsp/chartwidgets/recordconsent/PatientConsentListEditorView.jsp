<!DOCTYPE html>
<%@page import="eOR.ConsentOrders"%>
<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import="eIPAD.chartsummary.common.response.TransactionResponse"%>
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

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
%>


<script>

$(document).ready(function () {
	
	enableRecordConsentTickBtn();
	$("#RecordConsentCanceBtn").off();
    $("#RecordConsentCanceBtn").click(function() {
    	returnToIPListWithWarning();
	});
});



</script>


<div class="consentListContainer">

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
		String period_from = "";
		String period_to = "";
		int start = 1;
		int end = 500; //TODO remove this arbitrary number
		String practitioner_type = (String)session.getValue("practitioner_type");
		String speciality_code = "";
		String consentRec_order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id");
		
		String encounter_id = patientContext.getEncounterId();
		
		String consent_form_id = request.getParameter("consent_form_id")==null?"":request.getParameter("consent_form_id");
		String consent_form_desc = request.getParameter("consent_form_desc")==null?"":request.getParameter("consent_form_desc");
		String consent_stage = request.getParameter("consent_stage")==null?"":request.getParameter("consent_stage");
		
		ArrayList StatusDetail = new ArrayList();
		StatusDetail = bean.getStatusByDetail(facility_id,source_type,source_code,practitioner_id,priority,ord_cat,order_by,patientId, period_from,  period_to,start,end,practitioner_type, speciality_code, consentRec_order_id) ;
		String[] record = (String[])StatusDetail.get(0);
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
		String[] multiConsentLine = new String[4];
		multiConsentLine = bean.MultiListConsentsLine((String)record[5],(String)record[25]);
		
%>
   <div class="consentList">
   
      <div class="mdivTable">
         <div class="mheaderRowConsent">
            <div class="mheaderCellConsent">
               <div class="consentListItemContainer" cellpadding = "0" cellspacing = "0"  border = "0">
                  <div class="trIpRows1 consentListItem" >
                     <td class="tdLegendCol" align="center" valign = "center" style = "width:30px;">
                        <div  class="consentListItemColCKD" onclick="backToOrderList()">
                           <div class="CNButtonItemTheme" id="CNActionBtnPreviewNote"><img src="${path}/eIPAD/images/ConsentBackward16x16.png"/></div>
                        </div>
                        <div class="consentListItemCol2">
                           <div class = "consentDetails" border = "0" cellpadding = "0" cellspacing = "0">
                              <div class="rows trIpChildRows">
                                 <div class="rowdata" colspan = "2" >
                                    <div class = "txtRows txtRowsTheme" style="color:#333b46; padding-left:0px;"><%=multiConsentLine[1] %>
                                       <span class = "txtRows ptIdGender "style="color:#a3a3a3;"><%=record[2] %></span>
                                    </div>
                                 </div>
                              </div>
                              <div class="rows trIpChildRows">
                                 <div class="rowdata" colspan = "2">
                                    <span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f"><%=consent_form_desc %>, </span>
<%if(consent_stage.equals("A")){ %>                                    
                                    <span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">Before Order Release</span>
<%}else if(consent_stage.equals("R")) {%>     
									<span class="lz-list-data1 lz-list-data1Theme"  style="color:#504f4f">Before Order Registration</span>
<%} %>                               
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
               </div>
            </div>
         </div>
<%
	ArrayList ConsentFormId = null;
	ConsentFormId = bean.getFormId(consentRec_order_id,record[25],consent_form_id);
	String[] records = (String[]) ConsentFormId.get(0);
	String consentFormData = bean.getConsentDetail(records[0].trim(),"0",   records[3],   patientId, facility_id, encounter_id, consentRec_order_id) ;//set form content in the bean
	String i = "0";
	String patientdetails=record[20]+","+patientContext.getGender()+"/"+record[27]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[6];
	int consent_req_bef_order = Integer.parseInt(multiConsentLine[2]);
	int consent_req_bef_regn = Integer.parseInt(multiConsentLine[3]);
	String mode = "1";
	String practitioner_name = (String)session.getValue("practitioner_name");
	String security_level = (String)session.getValue("security_level");
	if(security_level == null)
		security_level  = "1";
	String curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);

%>
         <div class="mheaderRowInnerContent">	  
	         <div class="mheaderCellInnerContent">
		         <div style="width: 100%;height:100%;background-color: white;display: table;border: 1px solid #d8d8d8;box-shadow: 0px 1px 3px rgba(121,123,125,0.5);">  
		         	<div style="min-height: 300px;" id="RecConsentRTE" name="RecConsentRTE"><%=consentFormData %></div> 
		         </div>
	         </div>
         </div>   
      </div>
      
   </div>
   <input type="hidden" id="consent_form_text<%=i%>" name="consent_form_text<%=i%>" value=""/>
   <input type="hidden" id="chk<%=i%>" name="chk<%=i%>" value="y"/>
   <input type="hidden" id="consent_stage<%=i%>" name="consent_stage<%=i%>" value="<%=consent_stage%>"/>
   <input type="hidden" id="consent_form_id<%=i%>" name="consent_form_id<%=i%>" value="<%=consent_form_id%>"/>
   <input type=hidden name='patient_name<%=i%>' id='patient_name<%=i%>' value="<%=record[20]%>"/>
	<input type=hidden name='ord_typ_code<%=i%>' id='ord_typ_code<%=i%>' value="<%=record[12]%>"/>
	<input type=hidden name='ord_status<%=i%>' id='ord_status<%=i%>' value="<%=record[13]%>"/>
	<input type=hidden name='ord_consent_yn<%=i%>' id='ord_consent_yn<%=i%>' value="<%=record[17]%>"/>
	<input type=hidden name='ord_id<%=i%>' id='ord_id<%=i%>' value="<%=record[5]%>"/>
	<input type=hidden name='ord_line_num<%=i%>' id='ord_line_num<%=i%>' value="<%=record[25]%>"/>
	<input type=hidden name='appt_reqd_yn<%=i%>' id='appt_reqd_yn<%=i%>' value="<%=record[26]%>"/>
	<input type=hidden name='order_pract_name<%=i%>' id='order_pract_name<%=i%>' value="<%=record[21]%>"/>
	<input type=hidden name='cont_order_ind<%=i%>' id='cont_order_ind<%=i%>' value="<%=record[14]%>"/>
	<input type="hidden" name="ord_appr_by_user_id<%=i%>" id="ord_appr_by_user_id<%=i%>" value="<%=record[16]%>"/>
	<input type="hidden" name="ord_appr_reqd_yn<%=i%>" id="ord_appr_reqd_yn<%=i%>" value="<%=record[15]%>"/>
	<input type="hidden" name="ord_consent_by_id<%=i%>" id="ord_consent_by_id<%=i%>" value="<%=record[18]%>"/>
	<input type="hidden" name="ord_consent_reqd_yn<%=i%>" id="ord_consent_reqd_yn<%=i%>" value="<%=record[17]%>"/>
	<input type="hidden" name="order_catalog_code<%=i%>" id="order_catalog_code<%=i%>" value="<%=record[24]%>"/>				
	<input type=hidden name='patientdetails<%=i%>' id='patientdetails<%=i%>' value="<%=patientdetails%>"/>
	<input type=hidden name='order_category<%=i%>' id='order_category<%=i%>' value='<%=record[0]%>'/>
	<input type=hidden name='ord_catalog_desc<%=i%>' id='ord_catalog_desc<%=i%>' value='<%=record[9]%>'/>
	<input type=hidden name='pat_class<%=i%>' id='pat_class<%=i%>' value='<%=record[4]%>'/>
	<input type=hidden name='pat_id<%=i%>' id='pat_id<%=i%>' value='<%=record[6]%>'/>
	<input type=hidden name='priority<%=i%>' id='priority<%=i%>' value='<%=record[2]%>'/>
	<input type=hidden name='location_type<%=i%>' id='location_type<%=i%>' value='<%=record[10]%>'/>
	<input type=hidden name='location_code<%=i%>' id='location_code<%=i%>' value='<%=record[11]%>'/>
	<input type=hidden name='encount_id<%=i%>' id='encount_id<%=i%>' value='<%=record[7]%>'/>
	<input type=hidden name='ord_auth_reqd_yn<%=i%>' id='ord_auth_reqd_yn<%=i%>' value='<%=record[22]%>'/>
	<input type=hidden name='ord_auth_by_pract_id<%=i%>' id='ord_auth_by_pract_id<%=i%>' value='<%=record[23]%>'/>
	<input type="hidden" name="link_ref_no<%=i%>" id="link_ref_no<%=i%>" value=""/>
	<input type="hidden" name="link_ref<%=i%>" id="link_ref<%=i%>" value=""/>
	<input type="hidden" name="link_ref_det<%=i%>" id="link_ref_det<%=i%>" value=""/>
	<input type=hidden name='con_bo_cnt<%=i%>' id='con_bo_cnt<%=i%>' value="<%=consent_req_bef_order%>"/>
	<input type=hidden name='con_br_cnt<%=i%>' id='con_br_cnt<%=i%>' value="<%=consent_req_bef_regn%>"/>
	<input type=hidden name='con_rbo_cnt<%=i%>' id='con_rbo_cnt<%=i%>' value="<%=consent_req_bef_order%>"/>
	<input type=hidden name='con_rbr_cnt<%=i%>' id='con_rbr_cnt<%=i%>' value="<%=consent_req_bef_regn%>"/>
	
	<input type='hidden' name="con_stage<%=i%>" id="con_stage<%=i%>" value="<%=consent_stage%>"/>
	<input type='hidden' name="order_set_id<%=i%>" id="order_set_id<%=i%>" value="<%=bean.checkForNull(record[28],"")%>"/>
	
	<input type=hidden name='total_recs' id='total_recs' value='1'/>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>"/>
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id%>"/>
	<input type="hidden" name="practitioner_name" id="practitioner_name" value="<%= practitioner_name%>"/>
	<input type="hidden" name="security_level" id="security_level" value="<%=security_level%>"/>
	<input type="hidden" name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>"/>
	<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
	<input type="hidden" name="function_id" id="function_id" value=""/>
	<!--<input type="hidden" name="pract_id" id="pract_id" value="">--><!--returned frm modal window-->
	<%-- <input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
	<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>"> --%>
	<%-- <input type="hidden" name="ord_cat" id="ord_cat" value="<%=ord_cat%>">
	<input type="hidden" name="order_by" id="order_by" value="<%=order_by%>"> --%>
	<%-- <input type="hidden" name="ord_cat_desc" id="ord_cat_desc" value="<%=ord_cat_desc%>">
	<input type="hidden" name="priority_desc" id="priority_desc" value="<%=priority_desc%>"> --%>
	
	<%-- <input type="hidden" name="period_from" id="period_from" value="<%=period_from%>">
	<input type="hidden" name="period_to" id="period_to" value="<%=period_to%>"> --%>
	<%-- <input type='hidden' name="con_id<%=i%>" id="con_id<%=i%>" value="<%=con_id.toString()%>"> --%>
	
   

   
   
<%
	}
%>

</div>


<script>

	window.addEventListener("orientationchange", function() {
		window.parent.$("body").scrollTop(250);
		var me = document.activeElement;
		$(me).contents().find("body")[0].blur(); 
		setCkeContentHeight();
	}, true);

 
 
  function initRTE(){
	CKEDITOR.config.toolbar = [
		{ name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
		{ name: 'editing', items: [ 'SelectAll' ] },
		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline' ] },
		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-',  'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock' ] },
		{ name: 'styles', items: [ 'Format', 'FontSize' ] },
	];
	CKEDITOR.config.resize_enabled = false;
	CKEDITOR.config.allowedContent = true;
	editor = CKEDITOR.replace('RecConsentRTE', {
		removePlugins: 'floatingspace,resize,elementspath',
		resize_enabled: false
	});
	editor.on( 'loaded', function( evt ) 
	{ 	 
			$(".cke").css({"box-sizing":"border-box","height":"100%"});
			$(".cke_inner").css({"box-sizing":"border-box","width":"100%","height":"100%","display":"flex","align-items":"stretch","flex-direction":"column"});
   
			$(".cke_top").css({"box-sizing":"border-box","width":"100%","z-index":"1"});
			$(".cke_contents").css({"box-sizing":"border-box","width":"100%","overflow-y":"hidden !important"});
			$(".cke_wysiwyg_frame").css({"position":"relative","width":"100%","height":"100%"});
			setCkeContentHeight();
			
	});  
	editor.on('focus', function(){
		window.parent.$("body").scrollTop(250);
	});  
}

initRTE();
function setCkeContentHeight(){
						//getting window height
						var windowHeight = parent.document.body.clientHeight;
						
						//getting cke_top top position
						//getting cke_top height
						var EMContentTopValue =  $("#EMHeader", parent.document).height();
						
						var ckeTopValue = $(".cke_top").offset().top;
						
						var cke_contentTop_value = EMContentTopValue + ckeTopValue + $(".cke_top").height();//33
						
						//getting em footer top position
						var EMFooterLink = $("#EMFooter", parent.document);
						
						var EMFooterHeight = EMFooterLink.height();
						
						//getting height of cke_content
						var cke_content_height = windowHeight - cke_contentTop_value - EMFooterHeight ;
						
						$(".cke_contents").css('height',cke_content_height);
						
						$('.cke_wysiwyg_frame').contents().find('html').css({"overflow":"hidden","height":cke_content_height+"px"});
						$('.cke_wysiwyg_frame').contents().find('body').css({"overflow":"auto","height":cke_content_height+"px"}); 
						

}
</script>


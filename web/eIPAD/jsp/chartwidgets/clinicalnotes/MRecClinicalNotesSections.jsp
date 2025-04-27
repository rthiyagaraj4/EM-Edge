<!DOCTYPE html>
<%-- 
This jsp initializes the sections of the selected NoteType and puts the empty sections into the bean and displays the sections
The code in this file is a replica of RecClinicalNotesSection.jsp
The business logic is written in the JSP to maintain consistency with the parent page and synch changes easily
--%>



<%@page import="eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionItem"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesSectionListResponse"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="eCA.HeaderDomParser"%>
<%@page import="java.io.Reader"%> 
<%@page import="java.io.BufferedReader"%>
<%@page import="java.sql.Clob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSetHO"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@ page import="com.google.gson.*"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@page import="eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse"%>
<%@ page import="eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesSectionFields"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ page import="javax.imageio.ImageIO,sun.misc.BASE64Decoder"%>
<%@ page import="java.awt.image.BufferedImage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="webbeans.eCommon.*"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %> 


<c:set var="path" value="${pageContext.request.contextPath}" />
<style>
.addendumSectionClass{
	bottom: 6px !important;
    position: fixed !important;
    width: 98.3% !important;  
}
</style>

<script>

document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

var path;

var subSectionListScroll;
function assignSubSectionListScroll(sectCode) {
	if(subSectionListScroll){
		subSectionListScroll.destroy();
	}
	subSectionListScroll = new IScroll('#clinicalNotesSubsectionWrap_'+sectCode, { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: false,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
	subSectionListScroll.refresh();
}


var clinicalNotesSectListScroll;
function assignclinicalNotesSectListScroll() {
	clinicalNotesSectListScroll = new IScroll('#ClinicalNotesSectListWrap', { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: false,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true
		/* interactiveScrollbars: true,
		shrinkScrollbars: 'scale',*/
		/* fadeScrollbars: true  */
	});
	clinicalNotesSectListScroll.refresh();
}





$(document).ready(function () {
	document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
	
	path = document.getElementById("hdnPath").value;
	assignclinicalNotesSectListScroll();
	//assignSubSectionListScroll();
	if(clinicalNotesSectListScroll)
		clinicalNotesSectListScroll.refresh();
	
	openFirstSectionByDefault();
	$("#CNActionBtnPreviewNote").on('click',function(){		
		 $("#addendumHeader").hide();
	});
});

function openFirstSectionByDefault(){
	var firstNoteSection = $("[data-first_note_section='true']");
	var firstNoteSectionId = firstNoteSection.attr("id");
	var jsObjOfFirstSection = document.getElementById(firstNoteSectionId);	
	var event_status_code = $("#event_status_code").val();
	var operationMode= document.getElementById("hdnOpMode").value;
	if(operationMode == "ModifyAddendum" && event_status_code != "1"){
		 $("#addendumHeader").show();
		openNoteSectionAddendum(jsObjOfFirstSection);
	}
	else{
	openNoteSection(jsObjOfFirstSection);
	 $("#addendumHeader").hide();
	}
}




 
 var bExpanded = true;
 function toggleMenu() {

		if (bExpanded) {
			$('#divMenu').animate({
				width : "0%"
			}, 'slow');
			$('#divContent').animate({
				width : "100%"
			}, 'slow');
			document.getElementById("mb").style.display = "none";
			document.getElementById("mh").style.display = "none";
			document.getElementById("mc").style.display = "none";
			bExpanded = false;
		} else {
			$('#divMenu').animate({
				width : "2%"
			}, 'slow');
			$('#divContent').animate({
				width : "98%"
			}, 'slow');
			document.getElementById("mb").style.display = "block";
			document.getElementById("mh").style.display = "block";
			document.getElementById("mc").style.display = "block";
			bExpanded = true;

		}
	}
 
 var mandatoryCheck = false; 
 var CheckValArray=[];

 function openNoteSectionAddendum(obj){
	
	saveCurrentSectionToBean();
	   var content_type = $("#hdnCurChildSectionType").val();
		
		var section_code = "*AmmendNotes*";
		var section_desc = $("#hdnCurSectionDesc").val();
		var child_section_code = "*AmmendNotes*";
		var child_section_desc = $("#hdnCurChildSectionDesc").val();			
		var note_type = $("#note_type").val();
		var patient_id = $("#patient_id").val();
		var encounter_id = $("#encounter_id").val();
		var accession_num = $("#accession_num").val();
		var operation_mode = $("#operation_mode").val();
		var amendment_type = $("#amendment_type").val();
		var addendum_sec_code = $("#hdnCurSectionCode").val();		
		$("#clinicalNotesSubsectionWrap_" + addendum_sec_code).hide();
		
		$("#hdnCurSectionCode").val(section_code);
	$("#hdnCurSectionDesc").val(section_code);
	
	if(content_type==null ||content_type==""||content_type==" "){
		content_type="A";
	}
	
	$("#hdnCurChildSectionType").val(content_type); //TODO change to hdnCurChildSectionType
	$("#hdnCurChildSectionCode").val(child_section_code);
	$("#hdnCurChildSectionDesc").val(child_section_desc);
		
	 
	    $("#addendumHeader").show();
		$(".cnMainSectCell").removeClass("cnSectHighlight");
		$("#AddendumNoteSectionMenuItem").addClass("cnSectHighlight");		
	      $("#NoteSectionData").append("<div class='loadingCartItem'></div>");
	     
			//$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTEditor.jsp?section_code="+section_code+"&child_section_code="+child_section_code+"&addum=addumMode",function(){
				var timestamp = new Date().getTime();
			$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesAddendumEditorsFrame.jsp?section_code="+section_code+"&child_section_code="+child_section_code+"&addum=addumMode&timestamp="+timestamp,function(){
				setTimeout(function(){ 									
					//sectionListScroll.refresh(); 
					//sectionListScroll.scrollToElement("#NoteSectionHeading_"+child_section_code,0);
				}, 500);					
			});		
	 }
function openNoteSection(obj){
	
	try
	{
	$("#cke_53").hide();
	window.parent.$("#ChartSummaryIframe").contents().find("#NoteSectionView").css({"height":"100%"});	
	}
	catch(e){	}
	
$("#addendumHeader").hide();
	mandatoryCheck = false;
	
	saveCurrentSectionToBean();
	var parent_section_code = $(obj).data("parent_section_code");
	var parent_section_desc = $(obj).data("parent_section_desc");
	var parent_content_type = $(obj).data("parent_content_type");
	var content_type = $(obj).data("content_type");
	var section_desc = $(obj).data("section_desc");
	var section_code = $(obj).data("section_code");
	var note_type = $("#note_type").val();
	var patient_id = $("#patient_id").val();
	var encounter_id = $("#encounter_id").val();
	var accession_num = $("#accession_num").val();
	var operation_mode = $("#operation_mode").val();
	var event_status_code = $("#event_status_code").val();
	
	if(parent_section_code === section_code){
       
		var sectionId="Mad_NoteSectionMenuItem_"+section_code;
		
		$(".cnMainSectCell").removeClass("cnSectHighlight");
		$("#NoteSectionMenuItem_"+section_code).addClass("cnSectHighlight");
	}
	else{
		
		var sectionId="Subsect_NoteSectionMenuItem_"+section_code;
		
		$(".cnSubSectFont").removeClass("cnSubSectHighlight");
		$("#NoteSubSectionMenuItem_"+section_code).addClass("cnSubSectHighlight");
	}
	
	
	$("#hdnCurSectionCode").val(parent_section_code);
	$("#hdnCurSectionDesc").val(parent_section_desc);
	
	
	$("#hdnCurChildSectionType").val(content_type); //TODO change to hdnCurChildSectionType
	$("#hdnCurChildSectionCode").val(section_code);
	$("#hdnCurChildSectionDesc").val(section_desc);
	
	$("#NoteSectionData").empty();
	if(parent_content_type!="S"){
		if(section_desc!=null){
			$("[data-parent_sect_code]").css("display","none");
		}
	}
		
	
	if(content_type=="A"){		
		var timestamp = new Date().getTime();
		$("#NoteSectionData").append("<div class='loadingCartItem'></div>");
		$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumView.jsp?sec_content_type=T"+"&sec_hdg_code="+parent_section_code+"&child_sec_hdg_code="+section_code+"&note_type="+note_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&timestamp="+timestamp,
		function(){		
		});				
	}
	
	else if(content_type=="T"){	

		if(operation_mode =="ModifyAddendum" && event_status_code !=1){
			var timestamp = new Date().getTime();
		$("#NoteSectionData").append("<div class='loadingCartItem'></div>");
		$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumView.jsp?sec_content_type=T"+"&sec_hdg_code="+parent_section_code+"&child_sec_hdg_code="+section_code+"&note_type="+note_type+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&timestamp="+timestamp,
		function(){		
		});
		}
	else{
		$("#NoteSectionData").append("<div class='loadingCartItem'></div>");
		var timestamp = new Date().getTime();
		$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesTemplate.jsp?section_code="+parent_section_code+"&child_section_code="+section_code+"&child_section_type="+content_type+"&timestamp="+timestamp,
			function(){		
			if(mandatoryCheck == true){
				  $("#"+sectionId).show();
			  }
			  else{
				  $("#"+sectionId).hide();
			  }
		});
	}
	}
	else if(content_type=="S"){
		$("[data-parent_sect_code]").css("display","none");
		$("[data-parent_sect_code='"+section_code+"']").css("display","table-row");
		assignSubSectionListScroll(section_code);
		if(subSectionListScroll){
			subSectionListScroll.refresh();
		}
		//Selecting the first subsection by default
		var firstNoteSubSection = $("[data-parent_section_code='"+section_code+"'][data-first_note_subsection='true']");
		var firstNoteSubSectionId = firstNoteSubSection.attr("id");
		var jsObjOfFirstSubSection = document.getElementById(firstNoteSubSectionId);
		openNoteSection(jsObjOfFirstSubSection); 
	}else if(content_type=="F" || content_type=="R"){
		//$("#SectionDescription").html(section_desc);
		
		$("#NoteSectionData").append("<div class='loadingCartItem'></div>");
		var timestamp = new Date().getTime();
		//$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTEditor.jsp?section_code="+parent_section_code+"&child_section_code="+section_code,function(){
		$("#NoteSectionData").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesRTE.jsp?section_code="+parent_section_code+"&child_section_code="+section_code+"&timestamp="+timestamp,function(){
			setTimeout(function(){ 
				//sectionListScroll.refresh(); 
				//sectionListScroll.scrollToElement("#NoteSectionHeading_"+child_section_code,0);
			}, 500);
			
			
		});
		
		
	}
}

function saveCurrentSectionToBean(callback){			
	var content_type = $("#hdnCurChildSectionType").val();
	var section_code = $("#hdnCurSectionCode").val();
	var section_desc = $("#hdnCurSectionDesc").val();
	var child_section_code = $("#hdnCurChildSectionCode").val();
	var child_section_desc = $("#hdnCurChildSectionDesc").val();			
	var note_type = $("#note_type").val();
	var patient_id = $("#patient_id").val();
	var encounter_id = $("#encounter_id").val();
	var accession_num = $("#accession_num").val();
	var operation_mode = $("#operation_mode").val();
	var amendment_type = $("#amendment_type").val();
	var event_status_code = $("#event_status_code").val();
	
	if(operation_mode =="ModifyAddendum" && event_status_code!='1'){		
		//var section_content=$('#RTEditor0').contents().find('body').html(); 
		if(content_type && section_code && child_section_code && child_section_code!=""){
			var section_content = eval("CKEDITOR.instances.RecNotesRTE_CK.getData()");

			$.ajax({
					  method: "POST",
					  url: path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumControl.jsp",
					  data: { curr_sec_hdg_code: section_code, curr_child_sec_hdg_code: child_section_code, editor_title: "", operation_mode: "ModifyAddendum",note_type:note_type, patient_id:patient_id,prev_sec_hdg_code:"",prev_child_sec_hdg_code:"",ammend_mode:"",record_mode:"RecordAddendum",encounter_id:encounter_id,episode_type:"I",patient_class:"IP",section_content: section_content,accession_num:accession_num}
					})
					  .done(function( msg ) {		    
					    if(callback)
						  callback();
					  });	
		}
	}
	else{
	if(content_type && section_code && child_section_code && child_section_code!=""){
		if(content_type == "F" || content_type == "R"){		
			//var e = document.getElementById("RTEditor0");
			//var  section_content=e.contentWindow.document.body.innerHTML;				
			//var section_content = eval("CKEDITOR.instances.RecNotesRTE_CK.getData()");
			var section_content = eval("CKEDITOR.instances.RecNotesRTE_" + child_section_code +".getData()");

			section_content=section_content.replace("<address1>","<address>");
			section_content=section_content.replace("</address1>","</address>");

			$.ajax({
				  method: "POST",
				  url: path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp",
				  data: { content_type: content_type, child_section_code: child_section_code, section_code: section_code, section_content: section_content }
				})
				  .done(function( msg ) {			    
				    if(callback)
					  callback();
				  });
		}
		else if(content_type == "T"){
			$.ajax({
		        //url: path + "/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value="+check_box_value+"&OrderCatalogCode="+orderCatalogCode+"&OrderTypeCode="+orderTypeCode+"&OrderCatCode="+orderCategoryCode,
		        type: "POST",
		        url: path + "/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp",
		        data: $("#CNSectionTemplateForm").serialize(),
		        success: function(response) {
		        	if(callback)
						  callback();
		          
				},
				error: function (xhr, ajaxOptions, thrownError) {
					if(callback)
						callback();
					
				}
				//end ajax options
			});//end ajax 
		} 
	}
	else{
		if(callback)
			callback();
				}
	}
	
}

</script>

<style>


.clinicalNote {
	width: 100%;
	height: 97%;
	background: rgba(233, 238, 241, 0.45);
}

.cnMainSectCell {
	padding-left: 15px;
	padding-right: 15px;
	font-size: 14px;
	color: #dce5e9;
	font-weight: bold;
	display: inline-block;
	list-style-type: none;
}

.cnSectHighlight {
	font-size: 14px;
	color: #fff;
	font-weight: bold;
	border-bottom: 3px solid #fff;
	padding-bottom: 11.5px;
}



/*******************/
.cnSubSection {
	margin: 6px;
	height: 98%;
}

.cnMainSectionClass {
    overflow: hidden; 
    position: relative;
    width: 100%; 
	height: 45px;
	max-height: 45px;
	background: #2a7fa1;
	font-size: 14px;
	color: #dce5e9;
	font-weight: bold;
}

.addendumToCommonNote {
    overflow: hidden; 
    position: relative;
    width: 100%; 
	height: 45px;
	background: #e0e0eb;
	max-height: 45px;
	font-size: 14px;
    color: #1f2227;;
	vertical-align: middle;
    line-height: 45px;
    padding-left: 15px;
	font-weight: bold;
}
.cnSubSectionClass {
	height: 45px;
	width: 100%;
	overflow: hidden;
	position: relative;
}

.cnSubsectBackground {
	background: #e3e9ed;
}

.cnSubsectionChild { /* display: none; */
	position: absolute;
	width: auto;
}

.cnBodySectionClass{
    background: rgba(233, 238, 241, 0.45)
    overflow: hidden; 
    position: relative;
    height: 100%;
    width: 100%; 
}

.cnSubSectUlCell {
	white-space: nowrap;
	padding-left: 0px;
}

.cnSubSectLiCell {
	padding-left: 15px;
	padding-right: 15px;
	font-size: 12px;
	color: #484848;
	font-weight: bold;
	display: inline-block;
	list-style-type: none;
}

.cnSubSectFont {
	font-size: 12px;
	color: #64a2b5;
	font-weight: bold;
}

.cnSubSectHighlight {
	font-size: 12px;
	color: #006a88; 
	font-weight: bold;
	border-bottom: 3px solid #006a88;
	padding-bottom: 13px;
}

/*********************/
.recNotesSectListCont {
	width: 100%;
	height: 100%;
	background: #ccc;
	overflow: hidden;
	/* position:relative; */
}

.recNotesSectWrapper {
	width: 100%;
	height: 100%;
	overflow: hidden;
	position: relative;
}

.recNotesSectScroller {
	width: 100%;
	height: auto;
	position: relative;
}

.recNotesSectItem {
	height: 40px;
}
</style>

<div style="width: 100%; height: 100%;    position: relative;" class="table">
	<%
String path = request.getContextPath();
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
String note_type = request.getParameter("note_type") == null? "":request.getParameter("note_type"); //noteTypeId
//String noteTypedesc = request.getParameter("cmbNoteType_input") == null? "":request.getParameter("cmbNoteType_input");
String service_code = request.getParameter("service_code") == null? "":request.getParameter("service_code");
String event_status_code = request.getParameter("event_status_code")==null?"":request.getParameter("event_status_code");



if(patContext!=null){
	
	String patient_id = patContext.getPatientId();
	String patient_class = patContext.getPatientClass();
	String facility_id = patContext.getFacilityId();
	String location_code = patContext.getLocationCode();
	String encounter_id = patContext.getEncounterId();
	String clinician_id = patContext.getClinicianId();
	String login_user_id = (String)session.getValue("login_user");
%>

<%

	String attending_practitioner = "";//TODO
	String speciality_name = "";//TODO
	String visit_adm_date = "";//TODO
	String discharge_date = "";//TODO
	String event_date_time = "";//TODO
	String patient_name = "";
	String age = "";
	String Sex = "";
	String location_desc = "";
	String print_date_time = "";
	String regn_date = "";
	String date_of_birth = "";
	String mar_status = "";
	String nationality = "";
	String res_area_code = "";
	String res_town_desc = "";
	String relgn = "";
	String name_prefix = "" ;
	String region_code = "";
	String facility_name = "";
	String res_addr = "";
	String blood_grp = "";
	String rh_factor = "";
	String national_id = "";
	String practitioner_name = "";
	String degree;
	String credential_id;
	String credential_id1;
	String credential_id2;
	String credential_id3;
	String email_id;
	String pref_contact_mode;
	String off_tel_num;
	String off_tel_ext;
	String res_tel_num;
	String fax_num;
	String mobile_num;
	String pager_num;
	String bed_num = "";
	String room_num = "";
	StringBuffer prac_credentials = new StringBuffer();
	String event_date_caption = "";
	String event_perf_by_caption = "";
	String event_status_caption = "";
	String event_title_caption = "";
	String event_type_caption = "";
	String note_header_code = "";
	String footer_code = "";
	String report_header_code = "";
	String note_type_desc = "";
	String accession_num = request.getParameter("accession_num") == null? "":request.getParameter("accession_num");
	String authorized_by = "";
	String last_amended_by = "";
	String doc_ref_id = "";
	String performing_phy_name = "";
	String med_service = "";
	String encounter_id1 = "";
	String output_form_exists_yn = "N";
	String note_status = "";
	String note_title = "";
	String contr_mod_accession_num = "";//IN038439
	String strKey = "";
	String doc_exists;
	String sec_hdg_code;
	String sec_hdg_desc;
	String sec_content_type;
	String sec_result_linked_rec_type;
	String child_sec_hdg_code;
	String child_sec_hdg_desc;
	String child_sec_content_type;
	String child_sec_result_link_rec_type;
	String chief_complaint_sec_yn;
	String image_linked_yn;
	String strContentEditableYn;
	String content_type;
	String result_link_type;
	String result_link_yn = "N";
	String selection_type = "S";
	String operation_mode = request.getParameter("operation_mode") == null? "":request.getParameter("operation_mode");
	String query_notes_detail;
	String image_content = "";
	String image_recorded_yn = "N";
	String section_content_out = "";
	String child_sec_hdg_code_out;
	String sec_hdg_code_out;
	String doc_linked_yn = "";
	String image_edited_yn = "N";
	String edited_yn = "N";
	String prev_sec_hdg_code = "";
	String tblrow_id;
	String cnt_ofMainSections = "";
	String ids_of_mainSections = "";
	String section_image_height = "400"; //IN057343
	String event_status = "1"; // for Record
	String status;
	
	int sub_section_counter = 0;
	int cnt = 0;
	int cntSec = 0;
	
	
	
	HashSet recSet	= new HashSet();
	Hashtable htParameter=new Hashtable();
	Hashtable htPatDet=new Hashtable();
	Hashtable htPrompt=new Hashtable();
	
	Clob clob_notes_content = null;
	Clob clob_section_image_content	= null;
	Reader content_reader = null;
	BufferedReader	bf_content_reader = null;
	String section_content = "";
	
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	StringBuffer query_section_details = new StringBuffer();
	StringBuffer sbResult			   = new StringBuffer();
	
	HeaderDomParser parser = new HeaderDomParser();
	eCA.TemplatePromtRepParser prompt_parser = new eCA.TemplatePromtRepParser();
	
	
	//String practName = request.getParameter("practName") == null? "":request.getParameter("practName");
	
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
	strKey = patContext.getPatientId() + "~" + patContext.getEncounterId();
	strKey = strKey.trim();
	sectionBean.removePatientSection(strKey);	
	sectionBean.startPatientSection(strKey);
	eCA.PatientBannerGroupLine manageEmailBean = null;
	
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	Connection			con				=	null;
	PreparedStatement	pstmt			=	null;
	PreparedStatement	pstmt1			=	null;
	PreparedStatement	pstmt2			=	null;
	ResultSet			rs				=	null;
	ResultSet			rs1				=	null;
	ResultSet			rs2				=	null;
	
	con				=	ConnectionManager.getConnection(request);
	
	if(!(patient_id.equals("")))
	{
	
		try{
			//String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN CURR_PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC from mp_patient where patient_id = ? ";
			//String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
			String strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,?,?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,?,?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR,a.NATIONAL_ID_NO from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID and a.patient_id = ?";//IN043083
				
			pstmt2	= con.prepareStatement(strPatInfoQuery);
			pstmt2.setString(1,patient_class);
			pstmt2.setString(2,facility_id);
			pstmt2.setString(3,location_code);
			pstmt2.setString(4,locale);
			pstmt2.setString(5,facility_id);
			pstmt2.setString(6,location_code);
			pstmt2.setString(7,locale);//
			pstmt2.setString(8,locale);//
			pstmt2.setString(9,locale);//
			pstmt2.setString(10,locale);//
			pstmt2.setString(11,locale);//
			pstmt2.setString(12,locale);//
			pstmt2.setString(13,facility_id);//
			pstmt2.setString(14,locale);//
			pstmt2.setString(15,patient_id);
			rs2 = pstmt2.executeQuery();
			
			while(rs2.next())
			{
				patient_name = rs2.getString("patient_name")==null?"":rs2.getString("patient_name");
				age = rs2.getString("patient_age")==null?"":rs2.getString("patient_age");
				Sex = rs2.getString("Gender")==null?"":rs2.getString("Gender");
				location_desc = rs2.getString("LOCN_DESC")==null?"":rs2.getString("LOCN_DESC");
				print_date_time = rs2.getString("print_date_time")==null?"":rs2.getString("print_date_time");
				regn_date = rs2.getString("regn_date")==null?"":rs2.getString("regn_date");
				date_of_birth = rs2.getString("date_of_birth")==null?"":rs2.getString("date_of_birth");
				mar_status = rs2.getString("mar_status")==null?"":rs2.getString("mar_status");
				nationality = rs2.getString("nationality")==null?"":rs2.getString("nationality");
				res_area_code = rs2.getString("res_area_code")==null?"":rs2.getString("res_area_code");
				res_town_desc = rs2.getString("res_town_desc")==null?"":rs2.getString("res_town_desc");
				relgn = rs2.getString("relgn")==null?"":rs2.getString("relgn");
				name_prefix = rs2.getString("name_prefix")==null?"":rs2.getString("name_prefix");
				region_code = rs2.getString("region_code")==null?"":rs2.getString("region_code");		
				facility_name = rs2.getString("FACILITY_NAME")==null?"":rs2.getString("FACILITY_NAME");		
				res_addr = rs2.getString("res_addr")==null?"":rs2.getString("res_addr");		
				blood_grp = rs2.getString("BLOOD_GRP")==null?"":rs2.getString("BLOOD_GRP");		
				rh_factor = rs2.getString("RH_FACTOR")==null?"":rs2.getString("RH_FACTOR");		
				national_id = rs2.getString("NATIONAL_ID_NO")==null?"":rs2.getString("NATIONAL_ID_NO");	//IN043083
		
		
				if(Sex.equals("M") )
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(Sex.equals("F") )
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		
				if(patient_class.equals("OP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(patient_class.equals("IP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(patient_class.equals("EM"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(patient_class.equals("DC"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		
			}
			//setPatOutDetails
		
		
		}
		catch(Exception ee)
		{
			out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		try{				
			String strPracCredentialsQuery = "select PRACTITIONER_NAME,DEGREE,CREDENTIAL_ID,CREDENTIAL_ID1,CREDENTIAL_ID2,CREDENTIAL_ID3,EMAIL_ID,PREF_CONTACT_MODE,OFF_TEL_NUM,OFF_TEL_EXT,RES_TEL_NUM,FAX_NUM,MOBILE_NUM,PAGER_NUM ,ASSIGN_BED_NUM,ASSIGN_ROOM_NUM FROM AM_PRACTITIONER A, PR_ENCOUNTER B WHERE A.PRACTITIONER_ID=B.ATTEND_PRACTITIONER_ID AND FACILITY_ID=? AND ENCOUNTER_ID=?";						
			pstmt2	= con.prepareStatement(strPracCredentialsQuery);
			pstmt2.setString(1,facility_id);
			pstmt2.setString(2,encounter_id);
			rs2 = pstmt2.executeQuery();

			if(rs2.next())
			{
				practitioner_name = rs2.getString("PRACTITIONER_NAME")==null?"":rs2.getString("PRACTITIONER_NAME");
				degree = rs2.getString("DEGREE")==null?"":rs2.getString("DEGREE");
				credential_id = rs2.getString("CREDENTIAL_ID")==null?"":rs2.getString("CREDENTIAL_ID");
				credential_id1 = rs2.getString("CREDENTIAL_ID1")==null?"":rs2.getString("CREDENTIAL_ID1");
				credential_id2 = rs2.getString("CREDENTIAL_ID2")==null?"":rs2.getString("CREDENTIAL_ID2");
				credential_id3 = rs2.getString("CREDENTIAL_ID3")==null?"":rs2.getString("CREDENTIAL_ID3");
				email_id = rs2.getString("EMAIL_ID")==null?"":rs2.getString("EMAIL_ID");
				pref_contact_mode = rs2.getString("PREF_CONTACT_MODE")==null?"":rs2.getString("PREF_CONTACT_MODE");
				off_tel_num = rs2.getString("OFF_TEL_NUM")==null?"":rs2.getString("OFF_TEL_NUM");
				off_tel_ext = rs2.getString("OFF_TEL_EXT")==null?"":rs2.getString("OFF_TEL_EXT");
				res_tel_num = rs2.getString("RES_TEL_NUM")==null?"":rs2.getString("RES_TEL_NUM");
				fax_num = rs2.getString("FAX_NUM")==null?"":rs2.getString("FAX_NUM");
				mobile_num = rs2.getString("MOBILE_NUM")==null?"":rs2.getString("MOBILE_NUM");
				pager_num = rs2.getString("PAGER_NUM")==null?"":rs2.getString("PAGER_NUM");
				bed_num = rs2.getString("ASSIGN_BED_NUM")==null?"":rs2.getString("ASSIGN_BED_NUM");
				room_num = rs2.getString("ASSIGN_ROOM_NUM")==null?"":rs2.getString("ASSIGN_ROOM_NUM");
			
				prac_credentials.append(practitioner_name+" "+degree+"<br/>");
				
				if(!credential_id.equals(""))
					prac_credentials.append(credential_id);

				if(!credential_id.equals("") && (!credential_id1.equals("")))
					prac_credentials.append(",");
				
				prac_credentials.append(credential_id1);

				if(!credential_id1.equals("") && (!credential_id2.equals("")))
					prac_credentials.append(",");

				prac_credentials.append(credential_id2);

				if(!credential_id2.equals("") && (!credential_id3.equals("")))
					prac_credentials.append(",");
				
				prac_credentials.append(credential_id3);
				
				if(!credential_id1.equals("") || !credential_id2.equals("") || (!credential_id3.equals("")))
					prac_credentials.append("<br/>");
		
				
				if(pref_contact_mode.equals("M")){
					prac_credentials.append("Mobile : "+mobile_num);
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
				else if(pref_contact_mode.equals("R")){
					prac_credentials.append("Residence Tel : "+res_tel_num);
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
				else if(pref_contact_mode.equals("O")){									
					prac_credentials.append("Office Tel : "+off_tel_num);
					if(!off_tel_ext.equals(""))
						prac_credentials.append("  ext : "+off_tel_ext);
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
				else{
					if(!email_id.equals(""))
						prac_credentials.append("  Email : "+email_id);
				}
			}
		}
		catch(Exception ee){
			out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
			ee.printStackTrace();
		}
		finally{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		try{
			String strEventTitles = "select  a.EVENT_DATE_CAPTION,a.EVENT_PERF_BY_CAPTION ,a.EVENT_STATUS_CAPTION,a.EVENT_TITLE_CAPTION,a.EVENT_TYPE_CAPTION from CA_NOTE_TYPE_lang_vw a where a.NOTE_TYPE =? and a.LANGUAGE_ID =? ";
			
			pstmt2	= con.prepareStatement(strEventTitles);
			pstmt2.setString(1,note_type);
			pstmt2.setString(2,locale);
			
			rs2 = pstmt2.executeQuery();

			while(rs2.next()){
				event_date_caption = rs2.getString("EVENT_DATE_CAPTION")==null?"":rs2.getString("EVENT_DATE_CAPTION");
				event_perf_by_caption = rs2.getString("EVENT_PERF_BY_CAPTION")==null?"":rs2.getString("EVENT_PERF_BY_CAPTION");
				event_status_caption = rs2.getString("EVENT_STATUS_CAPTION")==null?"":rs2.getString("EVENT_STATUS_CAPTION");
				event_title_caption = rs2.getString("EVENT_TITLE_CAPTION")==null?"":rs2.getString("EVENT_TITLE_CAPTION");
				event_type_caption = rs2.getString("EVENT_TYPE_CAPTION")==null?"":rs2.getString("EVENT_TYPE_CAPTION");
			}
				htPrompt.put("V$PR_DATE", event_date_caption);
				htPrompt.put("V$NT_STATUS", event_status_caption);
				htPrompt.put("V$NT_TITLE", event_title_caption);
				htPrompt.put("V$NT_TYPE", event_type_caption);
				htPrompt.put("V$PR_BY_PRACT", event_perf_by_caption);
					
				
		}
		catch(Exception ee)
		{
			out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
		}
		
		if(!(note_type.equals("")))
		{
			
			// new addition for report header and Notes header STARTS
			try{
				String head_foot_qry ="select a.NOTE_TYPE_DESC,a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";

				pstmt2	= con.prepareStatement(head_foot_qry);
				pstmt2.setString(1,note_type);
				rs2 = pstmt2.executeQuery();

				while(rs2.next())
				{
					note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
					footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
					report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
					note_type_desc = rs2.getString("NOTE_TYPE_DESC")==null?"":rs2.getString("NOTE_TYPE_DESC");
				}

			}
			catch(Exception ee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			// new addition for report header and Notes header ENDS
			
			// Report Header STARTS
			try
			{
				String rpt_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(rpt_sect_query);
				pstmt2.setString(1,report_header_code);
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
							bf_content_reader	= new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
							section_content = new String(arr_notes_content);
							bf_content_reader.close();
										
							if(section_content == null)
								section_content = "";
						
						}
						catch(Exception e)
						{
							out.println("Exception@1-readCLOB : "+e);
							e.printStackTrace();
						}
	
	
					}
				}
			}

			catch(Exception eee)
			{
				out.println("Exception in MRecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}

			if(!accession_num.equals(""))
			{
				try
				{
					String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,1) AUTHORIZED_BY_ID,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name,a.SERVICE_CODE service_code, a.event_status status from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

					pstmt2	= con.prepareStatement(athorise_by_qry);
					pstmt2.setString(1,locale);
					pstmt2.setString(2,locale);
					pstmt2.setString(3,locale);
					pstmt2.setString(4,accession_num);
					pstmt2.setString(5,patient_id);
					rs2 = pstmt2.executeQuery();
					
					while(rs2.next())
					{
						authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
						last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
						doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
						performing_phy_name		=	checkForNull( rs2.getString("performed_by_name") );
						med_service		=	checkForNull( rs2.getString("service_name") );
						service_code = checkForNull( rs2.getString("service_code") ); // Setting the service code in case of modify
						status = checkForNull( rs2.getString("status") );
						
						if(status.equals("1"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if(status.equals("2"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
						else if(status.equals("3"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
						else if(status.equals("4"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
						else if(status.equals("5"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
						else if(status.equals("9"))
							event_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");
					}
					
				}
				catch (Exception roro )
				{
					out.println("Exception in MRecClinicalNotesSection.jsp getting section content : "+roro.toString());
					roro.printStackTrace();

				}
				finally 
				{
				  if(rs2 != null) rs2.close();
				  if(pstmt2 != null) pstmt2.close();
				}
            }
			encounter_id1=encounter_id;
			if(encounter_id.equals("0"))
				encounter_id1="";
			htParameter.put("V$ATT_PRACT", attending_practitioner);
			htParameter.put("V$PT_SPLTY", speciality_name);
			htParameter.put("V$PT_NAME", patient_name);
			htParameter.put("V$PT_ID", patient_id);
			htParameter.put("V$SEX", Sex);
			htParameter.put("V$AGE", age);
			htParameter.put("V$ENC_ID", encounter_id1);
			htParameter.put("V$ADM_DT", visit_adm_date); 
			htParameter.put("V$DIS_DT", discharge_date); 
			htParameter.put("V$MED_SERV", med_service);
			htParameter.put("V$DOC_REF_H", doc_ref_id);
			htParameter.put("V$PT_LOCN", location_desc); 
			htParameter.put("V$PT_CLASS", patient_class);
				
				
			//sectionContentUpdatedXML = new StringBuffer();
			StringBuffer section_content_new = new StringBuffer(section_content);
	
			if(!section_content_new.toString().equals("") && !section_content_new.toString().equals("&nbsp;") && section_content_new != null)
			{
				//***************************** [CRF-118] Start *****************************					
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
				paramHash.put("#p_patient_id#",patient_id);
				paramHash.put("#p_encounter_id#",encounter_id1);
				paramHash.put("#p_accNum#",accession_num);
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_eventDate#",event_date_time); //IN039562
				paramHash.put("#p_facility_id#",facility_id);//IN038439
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				if(tempParameter.size()>0){					
				htParameter.putAll(tempParameter);
				}
				//*****************************[CRF-118] Ends *****************************
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}

				
			if(!report_header_code.equals("") && report_header_code != null)
			{
				sectionBean.setSectionValues(report_header_code,report_header_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
			}
				
			section_content ="";
			//Report Header ENDS
			
			// notes header STARTS
			try
			{
				String hdr_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(hdr_sect_query);
				pstmt2.setString(1,note_header_code);
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
					if(clob_notes_content!=null)
					{
						try
						{
							content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
							bf_content_reader	= new java.io.BufferedReader(content_reader);
							char[] arr_notes_content = new char[(int)clob_notes_content.length()];
							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
							section_content = new String(arr_notes_content);
							bf_content_reader.close();
										
							if(section_content == null)
								section_content = "";
						}
						catch(Exception e)
						{
							out.println("Exception@1-readCLOB : "+e);
							e.printStackTrace();
						}
					}
				}
			}
			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			htParameter=new Hashtable();
			htParameter.put("V$PR_DATE", event_date_time);
			htParameter.put("V$NT_STATUS", note_status);
			htParameter.put("V$NT_TITLE", note_title);
			htParameter.put("V$NT_TYPE", note_type_desc);
			htParameter.put("V$PR_BY_PRACT", performing_phy_name);
			htParameter.put("V$DOC_REF_NH", doc_ref_id); 
			htParameter.put("V$NT_MEDSRV", med_service);
			
			sectionContentUpdatedXML.delete(0,sectionContentUpdatedXML.length())  ;
			section_content_new = new StringBuffer(section_content);
			
			
			//changing the prompt values
			if(!section_content_new.toString().equals(""))
			{
				//IN041827 Start
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
				paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
				paramHash.put("#p_accNum#",accession_num);
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_pract_id#",clinician_id);
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				
				if(tempParameter.size()>0)
				{					
					htParameter.putAll(tempParameter);
				}
				//IN041827 Ends
				sectionContentUpdatedXML = prompt_parser.changePromptValuesForComps(section_content_new,htPrompt,locale);
			}
			

			if(!sectionContentUpdatedXML.toString().equals("") && sectionContentUpdatedXML != null)
			{
				sectionContentUpdatedXML = parser.updateXMLContentValues(sectionContentUpdatedXML,htParameter,locale);
			}

			//new ends
			if(!note_header_code.equals("") && note_header_code != null)
			{
				sectionBean.setSectionValues(note_header_code,note_header_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				
			}
					
			section_content ="";
			//Notes header ENDS....
			
			query_section_details.append("select sec_hdg_code,1 DOC_EXISTS,");
			query_section_details.append("case when ? = 'en' then replace(sec_hdg_desc,'''','') else ");
			query_section_details.append("replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc");
			query_section_details.append(",sec_content_type,sec_result_linked_rec_type,");
			query_section_details.append("NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
			query_section_details.append("CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN ''");
			query_section_details.append("ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') ");
			query_section_details.append("else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') ");
			query_section_details.append("end end child_sec_hdg_desc ");
			query_section_details.append(",child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN");
			query_section_details.append(",IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN");
			query_section_details.append(",nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type");
			query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE ");  
			query_section_details.append("from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num");
			
			pstmt		=	con.prepareStatement(query_section_details.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,note_type);
		
			strKey = patient_id + "~"+ encounter_id;
			strKey = strKey.trim();
			sectionBean.getPatientSection(strKey);
			
			rs			=	pstmt.executeQuery();
			String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
			
			PreparedStatement addendumTextPstmt = null;
			ResultSet addendumTextRs = null;
			//IN033677,ends
			
			
		
%>
	<%-- <div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<form name = "frmRecordNotes" id = "frmRecordNotes" style="width: 100%; height: 100%" action="${path}/mobile/charts/notes/RecordClinicalNoteServlet"> --%>
	<!-- popup container ends -->

	<!-- <div id="divcnt" class="divAllergyContent divAllergyContentTheme" style="padding: 0px; overflow: hidden" data-role="none">
					<div style="width: 100%; height: 100%; overflow: auto" data-role="none"> -->
	<!-- <div style="width: 100%; height: auto; overflow: auto" data-role="none"> -->
	<!-- container start -->

	<!-- Header row STARTS -->
	<div style="height: 75px;position:relative;width:100%;" class="row">
		<div style="width: 100%;"
			class="WidgetContentStripTheme cell cnRecNotesHeader">
			<div style="width: 100%; height: 100%" class="table">
				<div class="row">
					<div
						style="width: 60px; height: 100%; vertical-align: middle; text-align: center;padding-left:10px"
						class="cell">
                        <div  class="CNButtonItemTheme" id="CNActionBtnPreviewNote">
							<img src="${path}/eIPAD/images/Preview24x24.png" />
						</div>
						<div class="CNButtonItemTheme" style="display:none" id="NotePreviewCloseBtn" onclick="enableNoteEditMode()">
							<img src="${path}/eIPAD/images/BacktoEdit24x24.png">
						</div>
					</div>
					
					<div style="vertical-align: middle;" class="cell">
						<div style="width: 100%; height: 100%" class="table">
							<div class="row">
								<div class="cnRecNotesHeaderTxt cell"><%=note_type_desc %></div>
							</div>
							<div class="row">
								<div class="cnPracName cell"><%=practitioner_name %></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header row ENDS -->


	<%
			while(rs.next())
			{
			
				addendumTextPstmt = con.prepareStatement(addendumTextSql);//IN033677
				doc_exists									=	checkForNull(rs.getString("DOC_EXISTS"));
				sec_hdg_code								=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc								=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type							=	checkForNull( rs.getString("sec_content_type") );
				sec_result_linked_rec_type					=	checkForNull( rs.getString("sec_result_linked_rec_type") );
				child_sec_hdg_code							=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_hdg_desc							=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_content_type						=	checkForNull( rs.getString("child_sec_content_type") );
				child_sec_result_link_rec_type				=	checkForNull( rs.getString("child_sec_result_link_rec_type") );
				chief_complaint_sec_yn						=   checkForNull( rs.getString("chief_complaint_sec_yn") );
				image_linked_yn								=   checkForNull( rs.getString("image_linked_yn") );
				strContentEditableYn						=	checkForNull( rs.getString("CONTENT_EDITABLE_YN") );
				content_type								=	checkForNull( rs.getString("content_type") );
				result_link_type							=	checkForNull( rs.getString("result_link_type") );
				output_form_exists_yn							=	rs.getString("OUTPUT_FORM_EXISTS_YN") ;
				result_link_yn								=	"N";
				selection_type							= rs.getString("SELECTION_TYPE")==null?"S":rs.getString("SELECTION_TYPE"); 	
				
				//IN033677,starts				
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,sec_hdg_code);
				addendumTextPstmt.setString(3,child_sec_hdg_code);
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";
			
				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}
				//IN033677,ends
			
				if(strContentEditableYn == null || strContentEditableYn.equals("") )
					strContentEditableYn = "Y";	
			
				if(content_type.equals("R"))
				{
					content_type = "F";
					result_link_yn = "Y";
				}		
			
				if( operation_mode.equals("Update") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") || operation_mode.equals("UpdateRecord") || !accession_num.equals("") )
				{
					query_notes_detail = "SELECT A.NOTES_SECTION_CONTENT,A.CHIEF_COMPLAINT_SEC_YN, DECODE(B.ACCESSION_NUM,NULL,'N','Y') IMAGE_RECORDED_YN, B.IMG_CONTENT FROM CA_ENCNTR_NOTE_SECTION A , CA_ENCNTR_NOTE_SECTION_OBJ B WHERE /*A.FACILITY_ID = ? AND */A.ACCESSION_NUM = ? AND A.SEC_HDG_CODE = ?  AND  A.SUBSEC_HDG_CODE = ?  AND B.OPERATING_FACILITY_ID(+)=A.FACILITY_ID AND B.ACCESSION_NUM(+)=A.ACCESSION_NUM AND b.SEC_HDG_CODE(+) = a.SEC_HDG_CODE AND  b.SUBSEC_HDG_CODE(+) =a.SUBSEC_HDG_CODE  ";
					pstmt1			=	con.prepareStatement(query_notes_detail);
					//pstmt1.setString(1, facility_id);
					pstmt1.setString(1, accession_num);
					pstmt1.setString(2, sec_hdg_code);
					pstmt1.setString(3, child_sec_hdg_code);
			
					rs1				=	pstmt1.executeQuery();
					
					section_content		=	"";
					image_content		=	"";
			
					if(rs1.next())
					{
						chief_complaint_sec_yn		=	checkForNull( rs1.getString("chief_complaint_sec_yn") );
						clob_notes_content			=	(java.sql.Clob) rs1.getObject("notes_section_content");
						clob_section_image_content	=	(java.sql.Clob) rs1.getObject("img_content");
						image_recorded_yn			=	rs1.getString("image_recorded_yn");
			
						if(clob_notes_content!=null)
						{
							try
							{
								content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
								bf_content_reader	= new java.io.BufferedReader(content_reader);
								char[] arr_notes_content = new char[(int)clob_notes_content.length()];
								bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
								section_content = new String(arr_notes_content);
								bf_content_reader.close();
								
								if(section_content == null)
									section_content = "";
									
								if(image_recorded_yn.equals("Y"))
								{
									if(clob_section_image_content != null)
									{
										content_reader	= ((java.sql.Clob) clob_section_image_content).getCharacterStream();
										bf_content_reader = new java.io.BufferedReader(content_reader);
										arr_notes_content = new char[(int)clob_section_image_content.length()];		bf_content_reader.read(arr_notes_content,0,(int)clob_section_image_content.length());
										image_content = new String(arr_notes_content);
										//image_content = java.net.URLEncoder.encode(image_content);
										bf_content_reader.close();
										
										//IN057343 Start.											
										section_image_height  = checkForNull((String) sectionBean.getSectionImageHeight(sec_hdg_code,child_sec_hdg_code),"");  
										if("0".equals(section_image_height) && !"".equals(image_content)){ 
											BASE64Decoder decoder = new BASE64Decoder();
											byte[]  imageByte = decoder.decodeBuffer(image_content);
											ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
											BufferedImage bimg = ImageIO.read(bis);
											section_image_height         = String.valueOf(bimg.getHeight());
											
											sectionBean.setSectionImageHeight(sec_hdg_code,child_sec_hdg_code,section_image_height);
										}
										//IN057343 End.
									}
								}
							}
							catch(Exception e)
							{
								out.println("Exception@1-readCLOB : "+e);
								e.printStackTrace();
							}
						}
					}
					
					if(pstmt1!=null){	pstmt1.close();	}
					if(rs1!=null)	{	rs1.close();	}
			
					if(content_type.equals("T")  && !section_content.equals(""))
					{							
						sbResult.delete(0,sbResult.length());
						sbResult.append(section_content);
						if (!locale.equals("en")) {
							HashMap<String,String> paramMap = new HashMap<String,String>();
							paramMap.put("CURR_SEC_HDG_CODE",child_sec_hdg_code);
							paramMap.put("LOCALE",locale);						
							paramMap.put("RANGE_PASER_YN","N");
							eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,sbResult);
							sbResult = tempLangParse.getLangReplacedXML();
							tempLangParse = null;
						}
						section_content = sbResult.toString();
					}
					
					if(output_form_exists_yn.equals("Y"))
					{
						String query_out_det ="select NOTES_SECTION_RESULT from CA_ENCNTR_NOTE_SEC_OUTPUT where SEC_HDG_CODE =? and SUBSEC_HDG_CODE =? and ACCESSION_NUM =? and FACILITY_ID =? and rownum =1 " ;
						pstmt1		=	con.prepareStatement(query_out_det);
						pstmt1.setString(1, sec_hdg_code); 
						pstmt1.setString(2, child_sec_hdg_code); 
						pstmt1.setString(3, accession_num); 
						pstmt1.setString(4, facility_id); 
						rs1				=	pstmt1.executeQuery();
			
						if(rs1.next())
						{
							clob_notes_content			=	(java.sql.Clob) rs1.getObject("NOTES_SECTION_RESULT");
							
			
							if(clob_notes_content!=null)
							{
								try
								{
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content_out = new String(arr_notes_content);
									bf_content_reader.close();
									
									if(section_content_out == null)
										section_content_out = "";
																
								}
								catch(Exception e)
								{
									out.println("Exception@1-readCLOB : "+e);
									e.printStackTrace();
								}
							}
						}
					
						if(pstmt1!=null){	pstmt1.close();	}
						if(rs1!=null)	{	rs1.close();	}
						
						sec_hdg_code_out =sec_hdg_code+"_out";
						child_sec_hdg_code_out =child_sec_hdg_code+"_out";
						sectionBean.setSectionValues(sec_hdg_code_out,child_sec_hdg_code_out,"T","N","N","N","N","","N","N", section_content_out,"",output_form_exists_yn);
			
						section_content_out ="";
						
					} //end if out
					
					if(!"".equals(addendumText)){
						sectionBean.setAddendumText(sec_hdg_code,child_sec_hdg_code,addendumText);//IN033677
					}
				}
			
			
				sectionBean.setSectionValues(sec_hdg_code,child_sec_hdg_code,content_type,doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,result_link_type, image_edited_yn,edited_yn, section_content, image_content,output_form_exists_yn);
			
				if(chief_complaint_sec_yn.equals("Y"))		// Only One section as Chief Complaint
				{	
					String queryChiefComplaint = "select COMPLAINT_ID from CA_ENCNTR_NOTE_SEC_COMPLAINT where facility_id = ? and accession_num = ? and SEC_HDG_CODE = ?";					
					
					try
					{
						pstmt1 = con.prepareStatement(queryChiefComplaint);
						pstmt1.setString(1, facility_id);
						pstmt1.setString(2, accession_num);
						pstmt1.setString(3, sec_hdg_code);
			
						rs1 = pstmt1.executeQuery();
					
						String complaint= "";
			
						while(rs1.next())
						{
							complaint = rs1.getString(1);
							recSet.add(complaint);
						}
					}
					catch (Exception ee2)
					{
						out.println("Exception@2-readChiefcomplaint : "+ee2);
						ee2.printStackTrace();
			
					}
					finally
					{
						if(pstmt1!=null){	pstmt1.close();	}
						if(rs1!=null)	{	rs1.close();	}
					}
			
					if(!recSet.isEmpty())
						sectionBean.setSectionChiefComplaint(sec_hdg_code,child_sec_hdg_code,recSet);	
				}
			
					if(!(sec_hdg_code.equals(prev_sec_hdg_code)))
					{
						sub_section_counter = 0;
						
						tblrow_id = "tblrow_id"+(cnt);
						cnt++;					
						if(!sec_content_type.equals("S")){//Individual item
%>				
<%							
						}
						else{//Item with Subsections
%>
<%
						}
						
						
					
						prev_sec_hdg_code	=	sec_hdg_code;
					}
			
					if(sec_content_type.equals("S"))
					{
						tblrow_id = "tblrow_id"+(cnt);
						/*if((cnt%2)==0)	classValue	=	"QRYEVEN";
						else			classValue	=	"QRYODD";*/
						
						if(child_sec_hdg_desc.equals(""))
						{						
						}
						else
						{				
							if(image_linked_yn.equals("Y"))
								sub_section_counter++;
							
								if(sub_section_counter == 1 )
								{
									//out.println("document.getElementById("no_of_sub_sections_")"+sec_hdg_code+"_anchor.style.visibility = '';");
									cnt_ofMainSections =cnt_ofMainSections+(cnt_ofMainSections.equals("")?((cnt) + ""):("|" + (cnt)));
									ids_of_mainSections =ids_of_mainSections+ (ids_of_mainSections.equals("")?((sec_hdg_code) + ""):("|" + (sec_hdg_code)));
								}								
%>
																								
<%								
						}
						
						cnt++;
					}
					cntSec++;
			}// end of while(rs.next())	


%>																			
																				
																			
							
							
							<%
			//IN033677,starts
			if(addendumTextPstmt!=null)
				addendumTextPstmt.close();
			if(addendumTextRs!=null)
				addendumTextRs.close();
			
			if(!accession_num.equals("&nbsp;") && !accession_num.equals(""))
			{
				addendumTextPstmt = con.prepareStatement(addendumTextSql);
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,"*AmmendNotes*");
				addendumTextPstmt.setString(3,"*AmmendNotes*");
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";
			
				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}
			
				sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
			}
			//IN033677,ends
			
			// putting notes footer in bean

			 if (!footer_code.equals("") && footer_code != null) 
			{
				try
				{			  
					String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
					pstmt2	= con.prepareStatement(footer_sect_query);
					pstmt2.setString(1,footer_code);
					rs2 = pstmt2.executeQuery();


					if(rs2.next())
					{
					
						clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
						
					if(clob_notes_content!=null)
					{
					try
						{
					
						content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
						bf_content_reader	= new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						section_content = new String(arr_notes_content);
						bf_content_reader.close();
										
						if(section_content == null)
							section_content = "";
						}
						catch(Exception e)
						{
							out.println("Exception@1-readCLOB : "+e);
							e.printStackTrace();
						}


					 }
					}
				}

				catch(Exception eee)
				{
					out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
					eee.printStackTrace();

				}
				finally
				{
					if(rs2 != null) rs2.close();
					if(pstmt2 != null) pstmt2.close();
				}
			
				
			
				htParameter=new Hashtable();
				htParameter.put("V$CUR_USR", login_user_id);
				htParameter.put("V$AT_PRACT", authorized_by);
				htParameter.put("V$LT_MODI_USR", last_amended_by);
				htParameter.put("V$PRN_DTTIME", print_date_time);
				htParameter.put("V$DOC_REF_F", doc_ref_id);
								
				section_content_new = new StringBuffer(section_content);
				//IN038439 Start
						if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
						{													
							eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
							HashMap paramHash=new HashMap();
							Hashtable tempParameter=new Hashtable();
						
							paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
							paramHash.put("#p_accNum#",accession_num);
							paramHash.put("#p_locale#",locale);
							paramHash.put("#p_pract_id#",clinician_id);
							tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);	
							if(tempParameter.size()>0)
							{					
								htParameter.putAll(tempParameter);
							}
						}
				 //IN038439 Ends
				sectionContentUpdatedXML = new StringBuffer();
			
				if(!section_content_new.toString().equals("") && section_content_new != null)
				{
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}



				
				if(!footer_code.equals("") && footer_code != null)
				{
					sectionBean.setSectionValues(footer_code,footer_code,"T","N","N","N","N","","N","N", sectionContentUpdatedXML.toString(),"",output_form_exists_yn);
				}
			}
			section_content ="";
	
			tblrow_id = "tblrow_id"+(cnt);
%>	

<%		}
		
		// setting pat details in bean
		htPatDet.put("PATIENT_ID",patient_id); htPatDet.put("PATIENT_NAME",patient_name);
		htPatDet.put("REGN_DATE",regn_date);  htPatDet.put("GENDER",Sex);
		htPatDet.put("RESIDENTAIL_ADDRESS",res_addr);
		htPatDet.put("AGE",age);   	htPatDet.put("FACILITY_NAME",facility_name);
		htPatDet.put("DATE_OF_BIRTH",date_of_birth); htPatDet.put("MAR_STATUS_CODE",mar_status);
		htPatDet.put("NATIONALITY_CODE",nationality);
		htPatDet.put("RH_FACTOR",rh_factor); 	htPatDet.put("BLOOD_GRP",blood_grp);
		htPatDet.put("RES_AREA_CODE",res_area_code);	htPatDet.put("RES_TOWN_CODE",res_town_desc);
		htPatDet.put("RELGN_CODE",relgn); 	htPatDet.put("NAME_PREFIX",name_prefix);
		htPatDet.put("REGION_CODE",region_code); 
		htPatDet.put("ENCOUNTER_ID",encounter_id1);
		htPatDet.put("CURRENT_LOCATION",location_desc);
		htPatDet.put("ATTENDING_PRACTITIONER",attending_practitioner);
		htPatDet.put("ADMISSION_DATE",visit_adm_date);
		htPatDet.put("SPECIALITY",speciality_name);
		htPatDet.put("PATIENT_CLASS",patient_class);
		htPatDet.put("ROOM_NUM",room_num);
		htPatDet.put("BED_NUM",bed_num);
		htPatDet.put("SERVICE_CODE",med_service);
		htPatDet.put("ATT_PRACT_WITH_CREDENTIAL",prac_credentials.toString());
		htPatDet.put("PATIENT_NRIC",national_id);//IN043083
	
		sectionBean.setPatOutDetails(htPatDet,patient_id);
		
		putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
		putObjectInBean("sectionBean",sectionBean,session);
	
%>																
		 					<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
							<input type="hidden" name="note_type_desc" id="note_type_desc" id="note_type_desc" value="<%=note_type_desc%>"/>
							<input type="hidden" name="note_type" id="note_type" id="note_type" value="<%=note_type%>"/>
							<input type="hidden" name="service_code" id="service_code" id="service_code" value="<%=service_code%>"/>
							<input type="hidden" name="event_status" id="event_status" id="event_status" value="<%=event_status%>"/>
							<input type="hidden" name="selection_type" id="selection_type" id="selection_type" value="<%=selection_type%>"/>
							<input type="hidden" name="patient_id" id="patient_id" id="patient_id" value="<%=patient_id%>"/>
							<input type="hidden" name="encounter_id" id="encounter_id" id="encounter_id" value="<%=encounter_id%>"/>
							<input type="hidden" name="accession_num" id="accession_num" id="accession_num" value="<%=accession_num%>"/>
							<input type="hidden" name="operation_mode" id="operation_mode" id="operation_mode" value="<%=operation_mode%>"/>
							 
								<input type="hidden" name="event_status_code" id="event_status_code" id="event_status_code" value="<%=event_status_code%>"/>
							<%
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							%>
							<input type="hidden" name="event_date_time" id="event_date_time" id="event_date_time" value="<%=sdf.format(new Date())%>"/>
							
							<input type="hidden" name="hdnCurSectionCode" id="hdnCurSectionCode" id="hdnCurSectionCode" value=""/>
							<input type="hidden" name="hdnCurChildSectionType" id="hdnCurChildSectionType" id="hdnCurChildSectionType" value=""/>
							<input type="hidden" name="hdnCurSectionDesc" id="hdnCurSectionDesc" id="hdnCurSectionDesc" value=""/>
							<input type="hidden" name="hdnCurChildSectionCode" id="hdnCurChildSectionCode" id="hdnCurChildSectionCode" value=""/>
							<input type="hidden" name="hdnCurChildSectionDesc" id="hdnCurChildSectionDesc" id="hdnCurChildSectionDesc" value=""/>


						 	
						<!-- </div>  --><!-- container ends-->
					<!-- </div>
				</div> -->
				
		<!-- </form>
	</div> -->
	
<%
	ClinicalNotesBC bc = new ClinicalNotesBC();
	ClinicalNotesSectionListResponse sectResp =  bc.getSectionListForNoteType(note_type, locale);
	if(sectResp!=null){
		boolean isSuccessResponse = sectResp.isSuccessResponse();
		boolean isEmptyResponse = sectResp.isEmptyDataResponse();
		ArrayList<ErrorInfo> errorList = new ArrayList<ErrorInfo>();
		List<ClinicalNotesSectionItem> sectList = sectResp.getSectionList();
		errorList = sectResp.getErrorsList();
		if(sectList!=null  && !sectList.isEmpty())
			isEmptyResponse = false;
		if(isSuccessResponse && !isEmptyResponse){
%>

<!-- Body(section list) row STARTS -->

	<div  class="row clinicalNote">
	  <div class="cell" style="width:100%;height:100%; position:relative;">
	    <div class="table" style="width:100%;height:100%">
		<!-- Main Section Table STARTS -->
		<div id="ClinicalNotesSectListWrap" class="cnMainSectionClass row">
			<div style="width: auto; position: absolute; height: 100%;">
				<ul style="white-space: nowrap;padding-left:0px;">
				<input type="hidden" name="hdnOpMode" id="hdnOpMode" id="hdnOpMode" value='<%=operation_mode%>'/>
				<%				
				if(operation_mode.equals("ModifyAddendum") && !event_status_code.equals("1")){
				%>
				<li id="AddendumNoteSectionMenuItem" id="NoteSectionMenuItem_AmmendNotes"
						data-parent_section_code="*AmmendNotes*"
						data-parent_section_desc="*AmmendNotes*"
						data-parent_content_type="*AmmendNotes*"
						data-content_type="*AmmendNotes*"
						data-section_code="*AmmendNotes*"
						data-section_desc="*AmmendNotes*" data-first_note_section=<%="true"%> class="cnMainSectCell" onclick="openNoteSectionAddendum(this)">Addendum to Note</li>			
				<%
				}
				%>
					<%
String prevSectCode = "";
HashMap<String, ArrayList<ClinicalNotesSectionItem>> subSectionsMap = new HashMap<String, ArrayList<ClinicalNotesSectionItem>>();
for(int i=0;i<sectList.size();i++){
	ClinicalNotesSectionItem currentSect = sectList.get(i);
	String sectionCode = currentSect.getSectionCode();
	String sectionDesc = currentSect.getSectionDesc();
	String sectionContentType = currentSect.getSectionContentType();
	if(!sectionContentType.equals("S")){
String opertion_type;
		
if(operation_mode.equals("ModifyAddendum") && !event_status_code.equals("1"))	{	
	opertion_type="A";
	
}else{
	opertion_type=sectionContentType;
	
}
%>
					<li class="cnMainSectCell"
						id="NoteSectionMenuItem_<%=sectionCode%>"
						data-parent_section_code="<%=sectionCode%>"
						data-parent_section_desc="<%=sectionDesc%>"
						data-parent_content_type="<%=sectionContentType%>"
						data-content_type="<%=opertion_type%>"
						data-section_code="<%=sectionCode%>"
						data-section_desc="<%=sectionDesc%>"
						data-first_note_section=<%if(!operation_mode.equals("ModifyAddendum") ||(operation_mode.equals("ModifyAddendum") && event_status_code.equals("1"))){%><%if(i==0)%><%="true"%><%else%><%="false"%><%}%><%else%><%="false"%>
						onclick="openNoteSection(this)">
						<%=sectionDesc %><span id="Mad_NoteSectionMenuItem_<%=sectionCode%>" style="display: none;"><font style="color: red">*</font></span></li>
					<!-- <li class="cnMainSectCell">test1</li>
					<li class="cnMainSectCell">test2</li>
					<li class="cnMainSectCell">test3</li>
					<li class="cnMainSectCell">test4</li>
					<li class="cnMainSectCell">test5</li> -->
					<%	
	}
	else if(sectionContentType.equals("S")){
		if(subSectionsMap.containsKey(sectionCode)){
			subSectionsMap.get(sectionCode).add(currentSect);
		}else{
			ArrayList<ClinicalNotesSectionItem> subSectionItemsList = new ArrayList<ClinicalNotesSectionItem>();
			if(!currentSect.getChildSectionDesc().equals(""))
				subSectionItemsList.add(currentSect);
			subSectionsMap.put(sectionCode, subSectionItemsList);
		}
		
		if(!prevSectCode.equals(sectionCode)){
%>
					<li class="cnMainSectCell"
						id="NoteSectionMenuItem_<%=sectionCode%>"
						data-parent_section_code="<%=sectionCode%>"
						data-parent_section_desc="<%=sectionDesc%>"
						data-parent_content_type="<%=sectionContentType%>"
						data-content_type="<%=sectionContentType%>"
						data-section_code="<%=sectionCode%>"
						data-section_desc="<%=sectionDesc%>"
						data-first_note_section=<%if(i==0)%><%="true"%><%else%><%="false"%>
						onclick="openNoteSection(this)"><%=sectionDesc %></li>
					<%		
		}
	}
	prevSectCode = currentSect.getSectionCode();
}
%>				
                </ul>
                </div> 
                </div>
                           
			<!-- Main Section Table ENDS -->
			
<%
		if(!subSectionsMap.isEmpty()){ //sub sections exists

%>
		<div class="cnSubSection row">
		<div class="cell" style="padding-top:9px;padding-left:9px;padding-right:9px;">
		<div class="table" style="width:100%;height:calc(100% - 9px)">
			<%
			for(Map.Entry<String, ArrayList<ClinicalNotesSectionItem>> entry : subSectionsMap.entrySet()){
				 ArrayList<ClinicalNotesSectionItem> subItems = entry.getValue();
%>
         
            <div class="cnSubSectionClass cnSubsectBackground" style="display: none;" id="clinicalNotesSubsectionWrap_<%=entry.getKey() %>" data-parent_sect_code="<%=entry.getKey() %>">
			<div class="cnSubsectionChild" style="width: auto; position: absolute; height: 100%;">
						<ul class="cnSubSectUlCell">
							<%
						if(!subItems.isEmpty()){
							for(int x=0;x<subItems.size();x++){
								ClinicalNotesSectionItem currentSubItem = subItems.get(x);
								String childSectionContentType = currentSubItem.getChildSectionContentType();
								String childSectionDesc = currentSubItem.getChildSectionDesc();
								String childSectionCode = currentSubItem.getChildSectionCode();
								String parentSectionCode = currentSubItem.getSectionCode();
								String parentSectionDesc = currentSubItem.getSectionDesc();
								String parentSectionContentType = currentSubItem.getSectionContentType();
%>
							<li class="cnSubSectLiCell cnSubSectFont" id="NoteSubSectionMenuItem_<%=childSectionCode%>"
								data-parent_section_code="<%=parentSectionCode%>"
								data-parent_section_desc="<%=parentSectionDesc%>"
								data-parent_content_type="<%=parentSectionContentType%>"
								data-content_type="<%=childSectionContentType%>"
								data-section_code="<%=childSectionCode%>"
								data-section_desc="<%=childSectionDesc%>"
								data-first_note_subsection=<%if(x==0)%><%="true"%><%else%><%="false"%>
								onclick="openNoteSection(this)"><%=subItems.get(x).getChildSectionDesc() %>
							   <span id="Subsect_NoteSectionMenuItem_<%=childSectionCode%>" style="display: none;"><font style="color: red">*</font></span>
							</li>
							<%
							}
						}
						else{
%>
							<li class="cnSubSectLiCell"><div style="opacity:0.5;">No subsections were present</div></li>
							<%
						}
%>

						</ul>
			</div>
			</div>
			<%
			}
%>
		<!-- Sub Section Table ENDS -->
		<%
		}
%>
        <div class="row">
		<div class="cnBodySectionClass" id="bodySectionWrapper" style="display:table-cell;-webkit-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75); -moz-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75); box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);padding: 5px;position: relative;">
		         <div id="addendumHeader" style="background: #e0e0eb;font-size: 14px;vertical-align: middle;line-height: 45px;padding-left: 15px;font-weight: bold;">Add Your Addendum Below</div>
			<!-- <div style="width: 100%; position: absolute; height: auto;"> -->
				<div style="background: #fafafa;width:100%; height: 100%;border:1px solid #dddddd;    position: relative;" class="table" id="NoteSectionData">
						
				</div>
			<!-- </div>	 -->
		</div>
		<div class="cnBodySectionClass" id="NoteSectionPreviewWrap" style="visbility:hidden;">
			<!-- <div style="width: 100%; position: absolute; height: auto;"> -->
				<div style="background: #fafafa;width:100%; height: auto;" id="NoteSectionPreview"> 
						
				</div>
			<!-- </div>	 -->
		</div>
		</div>
		
	 </div>
	 </div>	
     </div>	
     </div>
     </div>
	</div>
	<!-- Body(section list) row ENDS -->
<!-- 	
	<div class="row" style="height:90%">
		The template/text editor loads in this div
		<div class="cell" style="width: 100%;height:100%">
			<div style="position: relative;width:100%;height:100%">
				<div style="position: absolute; background: lightblue;width:100%;height:100%" id="NoteSectionData">
						
				</div>
			</div>	
		</div>
	</div> -->	

			
<%
		}
		else{
%>
	<div> No sections configured for the selected Note Type</div>
			
<%			
		}
	}
	
			
%>
			


	
	
<%
		}
	if(rs!=null) rs.close();
	if(rs1!=null) rs1.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(con!=null)	ConnectionManager.returnConnection(con,request);
	}
%>
</div>



<%!
public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
public String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
}
%> 


<%@ page language="java" contentType="text/html;charset=UTF-8"%> 
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.Locale"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />
<%

Locale appLocale;
if (session.getAttribute("LOCALE") != null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels",appLocale);

PatContext patContext= (PatContext)session.getAttribute("PatientContext");
String operation_mode = request.getParameter("operation_mode")==null?"Record":request.getParameter("operation_mode");
String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
String amendment_type = request.getParameter("amendment_type")==null?"":request.getParameter("amendment_type");
String action_comment = request.getParameter("action_comment")==null?"":request.getParameter("action_comment");
String event_status_code = request.getParameter("event_status_code")==null?"":request.getParameter("event_status_code");
String transactionMessage="";
String transactionResult="";
String formValErrClass="";
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Notes</title>

<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.0.1.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.common.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/kendo.default.min.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/lib/jquery.mCustomScrollbar.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/kendo.web.min.js"></script>
<script src="${path}/eIPAD/console.js"></script>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<script type="text/javascript" src="${path}/eIPAD/js/GenericSlider.js"></script>
<script type="text/javascript" src="${path}/eIPAD/js/ClinicalNotes.js"></script>

<script type="text/javascript" src="${path}/eIPAD/js/iscroll5/iscroll.js"></script>


<script src="${path}/eIPAD/js/lib/ckeditor/ckeditor.js"></script>


    <script src="${path}/eIPAD/js/CNcommon.js"></script>
	<script src="${path}/eIPAD/js/CNValidateControl.js"></script>
	<script src="${path}/eIPAD/js/CNSectionTemplate.js"></script>
	<script src="${path}/eIPAD/js/RecClinicalNotesTempCompDfltValLookup.js"></script>
	<script src="${path}/eIPAD/js/RecClinicalNotesPart1.js"></script>
	<script src="${path}/eIPAD/js/RecClinicalNotesPart2.js"></script>
	<script src="${path}/eIPAD/js/CNSpeciltyEvents.js"></script>
	<script src="${path}/eIPAD/js/CNdchk.js"></script>
	<script type="text/javascript" src="${path}/eIPAD/js/ValidateControlTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
     

<% String practName = (String)session.getAttribute("practitioner_name"); %>
<style>
.canChecked{
	
	display: block;
	border-bottom: 2px solid #1496cc;
    border-right: 2px solid #1496cc;
	   
    -ms-transform: rotate(45deg);
    -webkit-transform: rotate(45deg);
    transform: rotate(45deg);
	
}
.canUnchecked{

}
.canSelectDisable
{
	pointer-events: none;
	opacity:0.3;
	
}
.canSelectEnable
{
	
}
</style>
<script>
document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
//document.addEventListener('DOMContentLoaded', assignMainScroll, false);
var diagTransactMainScroll;
var screenOrienttation = "landscape";
var path;
var noteGroupId;
function changeOrientation(orient, EMHFheight)
{
	var CSHFheight = $('#createNoteHeader').height();
   	HFheight = EMHFheight;
   	screenOrienttation = orient;
   	var content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;
   	document.getElementById("divcnt").style.height = content_height+"px";
   //	$('#header1').focus();
   	scrollRefresh();
}
var cannedArray = new Array();
var text={
	type:"text"
};
var canText = {
			 textId:"",
			textData:""
		};
		  var update = function() {

		carretPos= getCaretPosition($("#RTEditor0").contents().find("body").find("#editableDiv"));
   
  };
 

		
function changeCantext(id, val) {

    if ($(val).hasClass("canChecked")) {
        $(val).removeClass("canChecked");
        $(val).addClass("canUnchecked");
        for (var i = 0; i <= cannedArray.length - 1; i++) {
            if (cannedArray[i].textId == id) {
                cannedArray.splice(i, 1);
                break;
            } else
                continue;
        }
    } else {

        if ($(val).hasClass("canUnchecked"))
            $(val).removeClass("canUnchecked");
        $(val).addClass("canChecked");

        var textData = $(val).parent().find(".data").html();
        canText.textId = id;
        canText.textData = textData;
        cannedArray.push(canText);
        canText = {};
    }
		var onSelect = $("#CantextSelect");
		if (cannedArray.length>0){
			if(onSelect.hasClass("canSelectDisable")){
				onSelect.removeClass("canSelectDisable");
				onSelect.addClass("canSelectEnable");
			}
		}
		else{
			if(onSelect.hasClass("canSelectEnable")){
				onSelect.removeClass("canSelectEnable");
				onSelect.addClass("canSelectDisable");
			}
		}
			
}

function selectCanText(val){
	var rowId = $(val).children()[1].id;
	changeCantext(rowId, $(val).children()[1]);	
}

function getCaretPosition(editableDiv) {
  var caretPos = 0,
    sel, range;
	
	var canWindow = $("#RTEditor0")[0].contentWindow;
	
  if (canWindow.getSelection) {	
    
	sel = canWindow.getSelection();
	
    if (sel.rangeCount) {
      range = sel.getRangeAt(0);
      if (range.commonAncestorContainer.parentNode == editableDiv[0]) {
		  
        caretPos = range.endOffset;
	
      }
    }
  } else if (document.selection && document.selection.createRange) {
    range = document.selection.createRange();
    if (range.parentElement() == editableDiv) {
      var tempEl = document.createElement("span");
      editableDiv.insertBefore(tempEl, editableDiv.firstElementChild);
      var tempRange = range.duplicate();
      tempRange.moveToElementText(tempEl);
      tempRange.setEndPoint("EndToEnd", range);
      caretPos = tempRange.text.length;
    }
  }
  return caretPos;
}


function selectcannedTextPop() 
{
	var currentSection = $("#hdnCurChildSectionCode").val();	
	$('.cke_wysiwyg_frame').contents().find('body').attr('contenteditable',true);
	var myeditor =eval("CKEDITOR.instances.RecNotesRTE_" + currentSection);

	 if (cannedArray.length > 0) 
	 {
        var tempArray = [];
        for (var j = 0; j <= cannedArray.length - 1; j++) {
            tempArray.push(cannedArray[j].textData);
        }
	 }
	tempArray = tempArray.join("<br>");

	if(text.type=="text")
		tempArray = "<p>"+tempArray+"</p>";		
	else if(text.type=="html")
		tempArray = "<address1>"+tempArray+"</address1>";
	
	var newElement = CKEDITOR.dom.element.createFromHtml(tempArray,myeditor.document );

	myeditor.focus();
	var selection = myeditor.getSelection();
	var range = selection.getRanges()[0];
	var pCon = erange.startContainer;
	var newRange = new CKEDITOR.dom.range(range.document);
	newRange.setStart(pCon,erange.startOffset);
	newRange.select();
	myeditor.insertElement(newElement);
	  closecannedTextPop();
}
function scrollRefresh()
{
 	if(diagTransactMainScroll != null)
 		diagTransactMainScroll.refresh();
}

function assignMainScroll() {
	 setTimeout(function () {
		 diagTransactMainScroll = new iScroll('divcnt', {
		useTransform: true,
		zoom: false,
		
		onBeforeScrollStart: function (e) {
		var target = e.target;
		while (target.nodeType != 1) target = target.parentNode;

		if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA' && target.tagName != 'DIV')
		e.preventDefault();
		} 
		});
}, 1000); 
}
//This small jQuery plugin is used to assign the event handler function for the OK button of the confirm dialog
(function ( $ ) {
    $.fn.configureConfirmDialog = function(options) {
    	var defaultVal =  {
    	        callBackForTrue: function () { },
    	    };
    	var obj = $.extend(defaultVal, options);
    	$(this).find("[data-value='true']").off();
        $(this).find("[data-value='true']").on("click",obj.callBackForTrue);
        return this;
    };
 
}( jQuery ));
$(document).ready(function () {
	
	var transactionMessage="";
	var transactionResult="";
	var formValErrClass="";
	
	parent.setOnLoadContentPaneHeight();
	path = document.getElementById("hdnPath").value;
	var operation_mode = $("#operation_mode").val();
	
	
	if(operation_mode=='Record'){ 
		loadAllNoteTypes();
		selectDefaultNoteType();
		enableBtnNoteSelection(); //Note selection is possible only when we record a new note
	}else{
		var note_type = $("#edit_note_type").val();
		var accession_num = $("#edit_accession_num").val();
		loadNoteSections_edit(note_type,accession_num);
	}
	
	
});
<!-- Forward notes start -->
function populatePractitionerMultiselectCombo(){
	var note_type=$('#note_type').val();
    $.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=FORWARD_PRAC&note_type="+note_type, function(data){
		PractitionerMultiselectCombo = $("#practionerMulSelect").data("kendoMultiSelect");
		PractitionerDataSrc = data;
		PractitionerMultiselectCombo.setDataSource(PractitionerDataSrc.fieldList);
	 });
	 $.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=FORWARD_SPEC", function(data){
		specialityCombo = $("#specialityCmbDiagSet").data("kendoComboBox");
		specialityDataSrc = data;
		specialityCombo.setDataSource(specialityDataSrc.fieldList);
	 }); 
}

function displayForwardNotesPop() {
	<!-- forward notes start -->
	$('#forwardNoteSlidePointer').sliderGenericControl();
	$('#hdnforwardNote').change(function(){ 
		if($('#hdnforwardNote').val()=="O"){
			$("#specialitySideFieldWrap").show();
			$("#practitionerSideFieldWrap").hide();
			$('#SendsHeaderButton').addClass("SaveErrorEnable");
			$('#txtSubject2').val('');	
		  
		   $("#specialityCmbDiagSet").data("kendoComboBox").value('');
			$("#specialitySubjectFieldWrap").show();
			$("#practitionerSubjectFieldWrap").hide();
		}
		else{
			$("#specialitySideFieldWrap").hide();
			$("#practitionerSideFieldWrap").show();
			$('#SendsHeaderButton').addClass("SaveErrorEnable");
			$('#txtSubject1').val('');
			   
				$("#practionerMulSelect").data("kendoMultiSelect").value([]);
			
			$("#specialitySubjectFieldWrap").hide();
			$("#practitionerSubjectFieldWrap").show();
		}
	});

	//diagComplaintMulSel = $("#practionerMulSelect").data("kendoMultiSelect");
	$("#specialityCmbDiagSet").kendoComboBox({
		filter:"startswith",
		dataTextField: "desc",
		dataValueField: "code",
		//dataSource: diagSetValuesJson.diagnosisSetList,
		//value:diagSetValuesJson.defaultValue,
		change: function(e) {
			var selectedVal =  $("#specialityCmbDiagSet").data("kendoComboBox").value();
			  if($('#txtSubject2').val() != '' &&  selectedVal != '')
			{		
            $('#SendsHeaderButton').removeClass("SaveErrorEnable");
           }else{
            $('#SendsHeaderButton').addClass("SaveErrorEnable");
    }
			//showHideAllOtherFields();
		}
	});
	//diagSetCombo = $("#specialityCmbDiagSet").data("kendoComboBox");
	
	
	<!-- forward notes end -->
	$('#SendsHeaderButton').addClass("SaveErrorEnable");
	showMez("ForwardNotesPop");
	$("#ForwardNotesPop").show();

}
	
function closeForwardNotesPop() {
	$("#ForwardNotesPop").hide();
	closeMez();
	$("#practionerMulSelect").data("kendoMultiSelect").value([]);
	$("#specialityCmbDiagSet").data("kendoComboBox").value('');
	$('#txtSubject1').val('');
	$('#txtSubject2').val('');
}

function recordAndForwardNote(){
	var note_type_desc = $("#note_type_desc").val();
  	var note_type = $("#note_type").val();
  	var service_code = $("#service_code").val();
  	var event_date_time = $("#event_date_time").val();
  	var event_status_code = $("#event_status_code").val();
  	
  	var selection_type = $("#selection_type").val();
  	var event_status = $("#event_status").val();
  	var action_comment = $("#action_comment").val();
	var amendment_type = "";
	var addendumOperationType ="";
	var accession_num = $("#accession_num").val();
	var operation_mode = "Sign";
	if(accession_num){
		operation_mode = "SignOnModify";
	}
	var selectedType = document.getElementById('hdnforwardNote').value;
	
	if(selectedType=="C"){
		var message = $('textarea#txtSubject1').val();
		var selectedPractitioner = document.getElementById('hdnDiagCompl').value;
		var practitionerCode =  selectedPractitioner;
        var change = ','
        practitionerCode = practitionerCode.split('$').join(change);
     $.ajax({
		  method: "GET",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
		  //data: {operation_mode:"Forward",forward_mode:"P",forwarded_clinician_ids:practitionerCode,action_comment:message,accession_num:accessionNumber}
		  data: { operation_mode: operation_mode, note_type_desc: note_type_desc, note_type: note_type, event_date_time: event_date_time, service_code: service_code, accession_num: accession_num, event_status: event_status, amendment_type: amendment_type, selection_type: selection_type,record_mode:addendumOperationType,forwarded_clinician_ids:practitionerCode, forward_mode: 'P' ,action_comment:message }
	})
	.done(function(response) {
		closeForwardNotesPop()
		completeTransaction(response);
	});
		
	}else{
		var selectedSpe= $("#specialityCmbDiagSet").data("kendoComboBox").value();
		var message = $('textarea#txtSubject2').val();
		
		$.ajax({
		  method: "GET",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
		  //data: {operation_mode:"Forward",forward_mode:"S",forwarded_clinician_id:selectedSpe,action_comment:message,accession_num:accessionNumber}
		  data: { operation_mode: operation_mode , note_type_desc: note_type_desc, note_type: note_type, event_date_time: event_date_time, service_code: service_code, accession_num: accession_num, event_status: event_status, amendment_type: amendment_type, selection_type: selection_type,record_mode:addendumOperationType,forwarded_clinician_id:selectedSpe, forward_mode: 'S' ,action_comment:message }
		})
		.done(function(response) {
			closeForwardNotesPop()
			completeTransaction(response);
		});
	} 
	
}


function validationForForwardNotes(selectedType,selectedPractitioner,selectedSpe,message){
	if(selectedPractitioner=="O"){
		if( selectedSpe=="" ){
			return false;
		}
	}else{
		if(selectedPractitioner==""){
				return false;
		}	
	}
	if(message=="" ){
		return false;
	}
	return true;
}

<!-- Forward notes end -->
function loadFrequentNoteTypes(){
	$("#TabFreq").removeClass("mRCSearchTabTheme").addClass("mRCSearchTabSelTheme");
	$("#TabAll").removeClass("mRCSearchTabSelTheme").addClass("mRCSearchTabTheme");
	$("#NotesListContainer").empty();
	$("#NotesListContainer").append("<div class='loadingCartItemNoteType'></div>");
	$("#NotesListContainer").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesNoteTypeList.jsp?mode=FREQ")
}
function loadAllNoteTypes(){
	$("#TabAll").removeClass("mRCSearchTabTheme").addClass("mRCSearchTabSelTheme");
	$("#TabFreq").removeClass("mRCSearchTabSelTheme").addClass("mRCSearchTabTheme");
	$("#NotesListContainer").empty();
	$("#NotesListContainer").append("<div class='loadingCartItemNoteType'></div>");
	$("#NotesListContainer").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesNoteTypeList.jsp?mode=ALL")
}

function loadTabTextTypes(textType)
{	
	text.type=textType;
	cannedArray.length=0;
	if($("#TabText").hasClass("mRCSearchTabTheme"))
		$("#TabText").removeClass("mRCSearchTabTheme").addClass("mRCSearchTabSelTheme");
	if($("#TabText").hasClass("mRCSearchTabSelTheme"))
		$("#TabEditorText").removeClass("mRCSearchTabSelTheme").addClass("mRCSearchTabTheme");
	$("#CannedTextListContainer").empty();	
	var service_code = $("#DefaultServiceCode").val();	
	var note_type = $("#edit_note_type").val();	
	var sec_hdg_code = $("#hdnCurSectionCode").val();
	var text_type="T";
	
	$("#CannedTextListContainer").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesCannedTextList.jsp?service_code=" +service_code+"&note_type="+note_type+"&text_type="+text_type+"&sec_hdg_code="+sec_hdg_code,function(){a= $("#Temp0");
	 });
	 showMez('cannedTextPop');
	 
	 var onSelect = $("#CantextSelect");
	if(onSelect.hasClass("canSelectEnable")){
				onSelect.removeClass("canSelectEnable");
				onSelect.addClass("canSelectDisable");
			}
}

function loadEditorTextTypes(textType){	
	text.type=textType;
	cannedArray.length=0;
	$("#TabEditorText").removeClass("mRCSearchTabTheme").addClass("mRCSearchTabSelTheme");
	$("#TabText").removeClass("mRCSearchTabSelTheme").addClass("mRCSearchTabTheme");
	$("#CannedTextListContainer").empty();	
	var service_code = $("#DefaultServiceCode").val();		
	var note_type = $("#edit_note_type").val();
	var sec_hdg_code = $("#hdnCurSectionCode").val();	
	var text_type="E";
	$("#CannedTextListContainer").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesCannedTextList.jsp?service_code=" +service_code+"&note_type="+note_type+"&text_type="+text_type+"&sec_hdg_code="+sec_hdg_code)
	var onSelect = $("#CantextSelect");
	if(onSelect.hasClass("canSelectEnable")){
				onSelect.removeClass("canSelectEnable");
				onSelect.addClass("canSelectDisable");
			}
}


function initNoteTypeCombo(){
	$("#cmbNoteType").kendoComboBox({
		dataTextField: "desc",
        dataValueField: "code",
        filter: "contains",
        change: function(e) {
            //var value = this.value();
            if(this.select()==-1){
            	this.value('');
            	this.text('');
            }
            if(this.value()!="" || this.value!=null){
            	//selectNGMSForNoteType();
            	closeNoteSelectorPop();
				 loadNoteSections();
            }
            
         }
	});
}
function initSpecialityCombo(){
	$("#cmbSpeciality").kendoComboBox({
		dataTextField: "desc",
        dataValueField: "code",
        filter: "contains",
        change: function(e) {
            var value = this.value();
            if(this.select()==-1){
            	this.value('');
            	this.text('');
            }
            //clearAllOtherFields();
            populateNoteType();
           // populateNoteGroup();
        }
	});
}
function populateNoteType(){
	 var specialityList = $("#cmbSpeciality").data("kendoComboBox");
	 //var noteGroupList = $("#cmbNoteGroup").data("kendoComboBox");
	 //document.getElementById("hdnSpecialityCode").value =specialityList.value();
	 $.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=NT&Appl_Task_ID=CLINICAL_NOTES&filterBy="+$("#hdnFilterByVal").val()+"&specialityCode="+specialityList.value(), function(data){
		 var noteTypeData = data;
		 var noteTypeCombo = $("#cmbNoteType").data("kendoComboBox");
		 noteTypeCombo.setDataSource(noteTypeData.fieldList);
		 selectDefaultNoteType();
	 });
}
function populateSpeciality(){
	 $.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=SP", function(data){
		 var specialityData = data;
		 var specialityCombo = $("#cmbSpeciality").data("kendoComboBox");
		 specialityCombo.setDataSource(specialityData.fieldList);
	 });
}

function changeFilterBy(){
	var filterBySliderValue = $('#hdnFilterByVal').val();
	populateNoteType();
	if(filterBySliderValue == "S"){
		$('#specialityList').show();
		populateSpeciality();
	}
	else{
		$('#specialityList').hide();
	}
		
}

function selectDefaultNoteType(){
	 $.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=DEFAULTS", function(data){
		 
		 var defaultNoteType = data.map.NOTE_TYPE;
		 var defaultServiceCode = data.map.SERVICE_CODE;
		 //var noteTypeCombo = $("#cmbNoteType").data("kendoComboBox");
		 if(defaultServiceCode){
			 $("#DefaultServiceCode").val(defaultServiceCode);
		 }
		 if(defaultNoteType){
			 /* noteTypeCombo.value(defaultNoteType);
			 if(noteTypeCombo.select()==-1){
				 noteTypeCombo.value("");
			 }else{ */
				 //closeNoteSelectorPop();
				 
			 //}
				$.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=PRESEL_VALIDATION&note_type="+defaultNoteType, function(prevali_data){
					if(prevali_data.transactionResult == 0){
						loadNoteSections(defaultNoteType);
					}else{
						//alert(prevali_data.transactionMessage);
						setTransactionMessage(false,prevali_data.transactionMessage);
						showNoteSelectorPop();
					}
				});
			 
			 
		 }else{
			 showNoteSelectorPop();
		 }
		 
		 
	 });
}

function loadNoteSections(note_type){
	$('#NoteTypeFilterTxt').blur();
	$.getJSON( path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=PRESEL_VALIDATION&note_type="+note_type, function(prevali_data){
		if(prevali_data.transactionResult == 0){
			closeNoteSelectorPopClick();
			$("#edit_note_type").val(note_type);
			var service_code = $("#DefaultServiceCode").val();
			var operation_mode = $("#operation_mode").val();
			var event_status_code = $("#event_status_code").val();
			$("#NoteSectionView").empty();
			$("#NoteSectionView").append("<div class='loadingCartItem'></div>");
			$("#NoteSectionView").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSections.jsp", { note_type: note_type, service_code: service_code , operation_mode: operation_mode, event_status_code: event_status_code},function() {
				disableButtonId("CNActionBtnSignNote");
				disableButtonId("CNActionBtnRecordUpdateNote");
				enableBtnPreviewNote();
			});
		}else{
			//alert(prevali_data.transactionMessage);
			setTransactionMessage(false,prevali_data.transactionMessage);
		}
	});
	
	//$("#NoteSectionView").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSections_accordian.jsp", { note_type: note_type, service_code: service_code , operation_mode: operation_mode});
}

function loadSectionsPreview()
{	
	if(!CheckValidation(CheckValArray))
	{
	var callAuthorizeOrder = function()
	{
		closeConfirmDialog();
		loadPreview();
		
	};
	$("#ClinicalNotesConfirmDialog").configureConfirmDialog({
		callBackForTrue: callAuthorizeOrder
	});
	var errorMsg = "Mandatory fields cannot be left blank!";
	showConfirmDialog(errorMsg);
	}
	else
		loadPreview();
		
}
function loadPreview()
{
	var note_type = $("#note_type").val();
  	var selection_type = $("#selection_type").val();
  	
	if(note_type){

		var callbackIfNotEmpty = function(){
			loadSectionsPreviewServiceCall();
			enableNotePreviewMode();
		};
		var callbackToCheckEmpty = function(){
			checkEmptySectionPreview(callbackIfNotEmpty);
		};
		
		saveCurrentSectionToBean(callbackToCheckEmpty);
		
		
	}else{
		showErrorDialog("No data available to preview");
	}
	
}
function loadSectionsPreviewServiceCall(){
	$("#addendumHeader").hide();
	var note_type = $("#note_type").val();
  	var selection_type = $("#selection_type").val();
  	var accession_num = $("#accession_num").val();
	$("#NoteSectionPreview").empty();
	$("#NoteSectionPreview").append("<div class='loadingCartItem'></div>");
	$("#NoteSectionPreview").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionView.jsp", { note_type: note_type, selection_type: selection_type, accession_num: accession_num},function() {
		disableButtonId("CNActionBtnPreviewNote");
		
		var operation_mode = $("#operation_mode").val();
		
		console.log("operation_mode"+operation_mode);
		
		if(operation_mode!="ModifySection"){
		enableBtnSignNote();	
		}
		
		enableBtnRecordUpdateNote();
	}); 
}
function checkEmptySectionPreview(callbackIfNotEmpty){
	var note_type = $("#note_type").val();
  	var operation_mode = $("#operation_mode").val();
  	var timestamp = new Date().getTime();
  	$.getJSON(path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=ISNOTEEMPTY&operation_mode="+operation_mode+"&note_type="+note_type+"&timestamp="+timestamp, function(data){
  		//alert(data);
		 if(data=="false"){
			 if(callbackIfNotEmpty)
				 callbackIfNotEmpty();
		 }else{
			 showErrorDialog("No data available to preview");
		 }
  	});
}
function enableNoteEditMode(){
	$("#ClinicalNotesSectListWrap").show();
	 $("#UnsavedExists").val("false");
	//$(".cnSubSectionClass").show();
	$("#bodySectionWrapper").show();
	$("#NoteSectionPreviewWrap").hide();
	$("#NotePreviewCloseBtn").hide();
	$("#CNActionBtnPreviewNote").show();
	$("#NoteEditModeBtn").show();
	
	var parent_section_code = $("#hdnCurSectionCode").val();
	var section_code = $("#hdnCurChildSectionCode").val();

	//subsection list should be opened incase it contains sub sections
	if(parent_section_code != section_code){
		$("#clinicalNotesSubsectionWrap_" + parent_section_code).show();
	}
	
	disableButtonId("CNActionBtnSignNote");
	disableButtonId("CNActionBtnRecordUpdateNote");
	enableBtnPreviewNote();
	if(operation_mode=='Record'){
		enableBtnNoteSelection(); //Note selection is possible only when we record a new note
	}
}
function enableNotePreviewMode(){
	$("#ClinicalNotesSectListWrap").hide();
	$(".cnSubSectionClass").hide();
	$("#bodySectionWrapper").hide();
	$("#NoteSectionPreviewWrap").show();
	$("#NotePreviewCloseBtn").show();
	$("#CNActionBtnPreviewNote").hide();
	$("#NoteEditModeBtn").hide();
	disableButtonId("CNActionBtnChooseNoteType");
}

function loadNoteSections_edit(note_type,accession_num){ 
	$("#NoteSectionView").empty();
	var operation_mode = $("#operation_mode").val();
	var event_status_code = $("#event_status_code").val();
	$("#NoteSectionView").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSections.jsp", { note_type: note_type, accession_num: accession_num, operation_mode: operation_mode, event_status_code: event_status_code},function() {
		disableButtonId("CNActionBtnSignNote");
		disableButtonId("CNActionBtnRecordUpdateNote");
		enableBtnPreviewNote();
	});
}
function showErrorDialog(errorMsg){
	$("#ClinicalNotesErrorDialogMsg").html(errorMsg);
	$("#ClinicalNotesErrorDialog").show();
	showMez('ClinicalNotesErrorDialog');
}
function closeErrorDialog(){
	$("#ClinicalNotesErrorDialog").hide();
	closeMez();
}
function clearAllOtherFields(){
	
	var noteTypeCombo = $("#cmbNoteType").data("kendoComboBox");
	noteTypeCombo.setDataSource();
	noteTypeCombo.value("");
	noteTypeCombo.text("");
	var specialityCombo = $("#cmbSpeciality").data("kendoComboBox");
	specialityCombo.value("");
	specialityCombo.text("");
	
}
function selectFrequentNote(obj){
	var fcode = $(obj).data("code");
	var fdesc = $(obj).data("desc");
	var noteTypeCombo = $("#cmbNoteType").data("kendoComboBox");
	noteTypeCombo.value(fcode);
	noteTypeCombo.text(fdesc);
	//add this item to the drop down if it's not present already due to the filter options
	if(noteTypeCombo.select()==-1){
		noteTypeCombo.dataSource.add({ code: fcode, desc: fdesc });
	}
	closeNoteSelectorPop();
	 loadNoteSections();
}

function showNoteSelectorPop(){
	$("#NoteSelectorPop").show();	
	showMez('NoteSelectorPop');
}
function CheckValidation(CheckValArray)
{
	var count = 0;
	var showAlert = false;		
	if(CheckValArray.length>0)
	{
	for(var i=0; i<=CheckValArray.length;i++)
	{
		var objID=CheckValArray[i].id;
		var objType=CheckValArray[i].component;	
		var message = $('#'+objID).val();		

		if(objType=="dropdown"){
	       var listBox = document.getElementById('list_box_component_of_'+objID);
	       
	      

	       if(listBox.value == ''){
	    	   return false;
	       }
	       else{
           	return true;
           }
        }
		else{
        	 if(message == '' )
	         {
		        count = count+1;
		        if(count >= 1)
		        {
			     showAlert = true;
			     if(count <= 1 && showAlert == true)											
				 return false;
               }	
             }
             else if(i==CheckValArray.length-1)
             {
	            return true;
             }
        }
	}
	}
return true;	
	
	   	
}

function openClinicalNotes(){
	window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet");
}


function closeNoteSelectorPopClick(){
	
	$("#NoteSelectorPop").hide();
	closeMez();
	//window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet"); 
}


function closeNoteSelectorPop(){
	
	var note_type=$("#note_type").val(); 
	
	if (note_type === undefined || note_type === null) {
     // do something 

       openClinicalNotes();
}
$("#NoteSelectorPop").hide();
	closeMez();
	//window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet"); 
}
function closecannedTextPop(){
	cannedArray.length=0;
	$("#CannedTextListContainer").empty();
	$("#cannedTextPop").hide(); 	
	$('.cke_wysiwyg_frame').contents().find('body').attr('contenteditable',true);
	closeMez();
}
function closeMez(){
	if($("#NoteSelectorPop").css('display') != 'none'){
		closeNoteSelectorPop();
	}
	var popid = $("#dvMez").data("popid");
	$('.cke_wysiwyg_frame').contents().find('body').attr('contenteditable',true);
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

function enableBtnNoteSelection(){
	$("#CNActionBtnChooseNoteType").removeClass("cstFieldDull");
	$("#CNActionBtnChooseNoteType").click(function() {
			showNoteSelectorPop();
		});
}
function enableBtnPreviewNote(){
	$("#CNActionBtnPreviewNote").removeClass("cstFieldDull");
	$("#CNActionBtnPreviewNote").click(function() {
			loadSectionsPreview();
		});
}
function enableBtnSignNote()
{
	$("#CNActionBtnSignNote").removeClass("cstFieldDull");
	$("#CNActionBtnSignNote").click(function() 
	{
	if(!CheckValidation(CheckValArray))
	{
	var callAuthorizeOrder = function()
	{
		closeConfirmDialog();		
		
	};
	$("#ClinicalNotesConfirmDialog").configureConfirmDialog({
		callBackForTrue: callAuthorizeOrder
	});
	var errorMsg = "Mandatory fields cannot be left blank!";
	showConfirmDialog(errorMsg);
	}
	else
	{
		
	signNoteConfirmMsg();
	}
		

			
	});
}
function enableBtnRecordUpdateNote()
{
	$("#CNActionBtnRecordUpdateNote").removeClass("cstFieldDull");
	$("#CNActionBtnRecordUpdateNote").click(function()
	{
		if(!CheckValidation(CheckValArray))
		{
			var callAuthorizeOrder = function()
			{
				closeConfirmDialog();		
		
			};
			$("#ClinicalNotesConfirmDialog").configureConfirmDialog({
				callBackForTrue: callAuthorizeOrder
			});
			var errorMsg = "Mandatory fields cannot be left blank!";
			showConfirmDialog(errorMsg);
		}
		else
		{		
			recordUpdateNote();
		}
	});
}
function disableButtonId(btnId){
	$("#"+btnId).off();
	$("#"+btnId).addClass("cstFieldDull");
}

function signNote(){
	var operation_mode = $("#operation_mode").val();
	
	/* if(operation_mode == 'Record'){
		operation_mode = "Sign";
	}else{
		operation_mode = "SignOnModify";
	}  */
	operation_mode = "Sign";
	saveCurrentSectionAndTransact(operation_mode);
}

function recordUpdateNote(){
	var operation_mode = $("#operation_mode").val();
	saveCurrentSectionAndTransact(operation_mode);
}
function saveCurrentSectionAndTransact(operation_mode){
	/* if ( CKEDITOR.instances.editor1.getData() == '' )
	    alert( 'There is no data available.' ); */
	//var s=CKEDITOR.instances;
	//alert(CKEDITOR.instances.RecNotesRTE.getData());
/* 	var content_type = $("#hdnCurChildSectionType").val();
	var section_code = $("#hdnCurSectionCode").val();
	var section_desc = $("#hdnCurSectionDesc").val();
	var child_section_code = $("#hdnCurChildSectionCode").val();
	var child_section_desc = $("#hdnCurChildSectionDesc").val();
	if(content_type && section_code && child_section_code){
		if(content_type == "F" || content_type == "R"){
			var e = document.getElementById("RTEditor0");
			var  section_content = e.contentWindow.document.body.innerHTML;
			$.ajax({
				  method: "POST",
				  url: path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp",
				  data: { content_type: content_type, child_section_code: child_section_code, section_code: section_code, section_content: section_content }
			})
			.done(function( msg ) {
			  //alert( "Data Saved: " + msg );
			  //call for Record/sign
				recordNotes(operation_mode);
			  
			});
		}
		else if(content_type == "T"){
			$.ajax({
		        //url: path + "/eIPAD/jsp/chartwidgets/orders/MoeAddToCart.jsp?check_box_value="+check_box_value+"&OrderCatalogCode="+orderCatalogCode+"&OrderTypeCode="+orderTypeCode+"&OrderCatCode="+orderCategoryCode,
		        type: "POST",
		        url: path + "/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp",
		        data: $("#CNSectionTemplateForm").serialize(),
		        success: function(response) {
		        	recordNotes(operation_mode);
		          
				},
				error: function (xhr, ajaxOptions, thrownError) {
					//alert("Error in updating the order details");
					//closeOrderFields();
					//parent.selectedOrders.pop(orderCatalogCode);
				}
				//end ajax options
			});//end ajax 
		}
	} */
	
	recordNotes(operation_mode);
	
	
}
function recordNotes(operation_mode){
	var note_type_desc = $("#note_type_desc").val();
  	var note_type = $("#note_type").val();
  	var service_code = $("#service_code").val();
  	var event_date_time = $("#event_date_time").val();
  	var event_status_code = $("#event_status_code").val();
  	
  	var selection_type = $("#selection_type").val();
  	var event_status = $("#event_status").val();
  	var action_comment = $("#action_comment").val();
  	$.ajax({
		  method: "POST",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesValidation",
		  data: { operation_mode: operation_mode, note_type: note_type }
	})
	.done(function( data ) {
		var valiResp = data;
		
		//validation passed
		var accession_num = "";
		var amendment_type = "";
		var addendumOperationType ="";
		if(operation_mode == 'Record')
		{			
			accession_num = "";
			
		}
		else if(operation_mode == 'UpdateRecord'){
			event_status = '1';
			accession_num = $("#edit_accession_num").val();
		}
		else if(operation_mode == 'ModifyAddendum' && event_status_code !="1")
		{						
			 operation_mode = "ModifyAddendum";	
			 addendumOperationType="RecordAddendum";
			 accession_num = $("#edit_accession_num").val();
			 amendment_type = $("#amendment_type").val();
		}
		else if(operation_mode == 'Sign')
		{	
			accession_num = $("#edit_accession_num").val();
			amendment_type = $("#amendment_type").val();
			if(amendment_type =="A"  && event_status_code =="1" ){	//In Progress note              			
				operation_mode = "Sign";
				//addendumOperationType ="SignAddendum";
			}
			else if(amendment_type =="A"){  //signed/modified note
				operation_mode = "ModifyAddendum";
				addendumOperationType = "SignAddendum";
			}
			
		}
		else
		{	
			accession_num = $("#edit_accession_num").val();
			amendment_type = $("#amendment_type").val();
		}
		if(valiResp.validationResult == 0){
			$.ajax({
				  method: "POST",
				  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
				  data: { operation_mode: operation_mode, note_type_desc: note_type_desc, note_type: note_type, event_date_time: event_date_time, service_code: service_code, accession_num: accession_num, event_status: event_status, amendment_type: amendment_type, selection_type: selection_type,record_mode:addendumOperationType  }
			})
			.done(function( data ) {
				if(operation_mode == 'Record' || operation_mode == 'UpdateRecord'){
					completeRecordShowPreview(data);
				}else{
					completeTransaction(data);
				}
				
			});
		}
		else{
			var errorList = valiResp.errorList;
			if(errorList.length>0){
				for(var i=0;i<errorList.length;i++){
					var errorMessageId = valiResp.errorList[i].errorMessageId;
					if(errorMessageId == 'PRIVILEGE_ERROR'){
						populatePractitionerMultiselectCombo();	
						displayForwardNotesPop();
					}
				}
			}
		}
		
		
	});
	
}
function setTransactionMessage(result,errMsg){
	if(result){
		$("#transactionMsg").addClass("formValSuccessTheme");
		$("#transactionMessageContent").html(errMsg);
	}else{
		$("#transactionMsg").addClass("formValErrorTheme");
		$("#transactionMessageContent").html(errMsg);
		
	}
	 showTransactionMessage();
}

function showTransactionMessage(){
	$("#transactionMsg").show();
	setTimeout(function(){
		$("#transactionMsg").hide();
	},5000);
	$("#transactionMsg").bind('click',function(){
		$(this).hide();
	});
}


function completeRecordShowPreview(data){

	
	var transactionMessage =data.transactionMessage;
	var transactionResult = data.transactionResult;
	
	
	if(transactionResult=="0"){ 
		formValErrClass= "formValSuccessTheme";
		setTransactionMessage(true,transactionMessage);
		disableButtonId("CNActionBtnRecordUpdateNote");
		var accession_num = data.accession_num;
		$("#edit_accession_num").val(accession_num);
			$("#UnsavedExists").val("true");
		$("#accession_num").val(accession_num);
		$("#operation_mode").val("UpdateRecord");
		$("#event_status_code").val("1");
	}
	else{
		formValErrClass= "formValErrorTheme";
		setTransactionMessage(false,transactionMessage);
	}
}
function completeTransaction(data){
	var transactionParams = "transactionOccurred=true&transactionMessage="+data.transactionMessage+"&transactionResult="+data.transactionResult;
	var cspath = path + "/mobile/charts/notes/OpenClinicalNoteServlet?" + transactionParams;
	//window.parent.document.getElementById('ChartSummaryIframe').src = cspath;
	/* window.parent.document.getElementById('ChartSummaryIframe').onload = function() { 
		alert('myframe is loaded'); 
		window.parent.document.getElementById('ChartSummaryIframe').remove
	}; */
	/* window.parent.$('#ChartSummaryIframe').on('load', function(){
        //$(this).show();
        alert('load the iframe');
        window.parent.$('#ChartSummaryIframe').off('load');
    }); */
	window.parent.$('#ChartSummaryIframe').attr('src',cspath); 
	
	
}
function closeConfirmDialog(){
					

	$("#ClinicalNotesConfirmDialog").hide();
	closeMez();
}

function showConfirmDialog(errorMsg){
				

	$("#ClinicalNotesConfirmDialogMsg").html(errorMsg);
	$("#ClinicalNotesConfirmDialog").show();
	showMez('ClinicalNotesConfirmDialog');
}

function signNoteConfirmMsg(){
		

	var callAuthorizeOrder = function(){
		closeConfirmDialog();
		signNote();
		//$('#OrderFieldsIframe').contents().find('#AuthorizeIcon'+catalogCode).addClass("actionTickIcon");
		//$('#OrderFieldsIframe').contents().find('#authorized'+categoryCode).val("true");
	};
	$("#ClinicalNotesConfirmDialog").configureConfirmDialog({
		callBackForTrue: callAuthorizeOrder
	});
	var errorMsg = "Confirm Sign?";
	showConfirmDialog(errorMsg);
}
function confirmCancelTransaction(){

var completedStatus=$('#UnsavedExists').val();



if(completedStatus=="true"){
	
	cancelTransaction();
}else{
	
	var cancelCareActivity = function(){
		closeConfirmDialog();
		cancelTransaction();
		//$('#OrderFieldsIframe').contents().find('#AuthorizeIcon'+catalogCode).addClass("actionTickIcon");
		//$('#OrderFieldsIframe').contents().find('#authorized'+categoryCode).val("true");
	};
	$("#ClinicalNotesConfirmDialog").configureConfirmDialog({
		callBackForTrue: cancelCareActivity
	});
	var errorMsg = "Are you sure you wish to cancel the current operation?";
	showConfirmDialog(errorMsg);
}
	
}
/* function hideSlideSFS(){
	$("#CNFilters").hide();
	$("#CNFilters").empty();
}
function showSlideSFS(){
	$("#CNFilters").load(path+"/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesFilters.jsp")
	$("#CNFilters").show();
} */

/*  function showMezzaineWindow()
 {
 	$('#dvMez').css("display","block");
 	setTimeout(function() {
 		$("#dvMez").on("click",closeMezzaineWindow);
 	}, 500);
 }
 function closeMezzaineWindow() 
 {
 	$('#dvMez').css("display","none");
 	var popid = $("#dvMez").data("popid");
 	$("#"+popid).hide();
 	$("#dvMez").data("popid","");
 	$("#dvMez").off();
 }; */
 
</script>
<style>
#CNFilters{
	position:absolute;
	width:230px;
	height:calc(100% - 10px);
	z-index:20;
	margin-top:5px;
	margin-bottom:5px;
	margin-left:5px;
}
/* 
	width:450px;
	height:400px;
	
	border:1px solid lightgrey;
} */
#NoteSelectorPop{
	height:400px;
	width:740px;
	z-index:10001;
}
#cannedTextPop{
	opacity:99;
	height:400px;
	width:740px;
	z-index:10001;
}
.loadingCartItem {
	width: 100%;
	height: 80px;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
}
.loadingCartItemNoteType{
	    top: 0px;
    position: absolute;
    z-index: 99;
	width: 100%;
	height: 100%;
	background-image: url(${path}/eIPAD/images/Loading24x24.gif);
	background-repeat: no-repeat;
	background-position: 50% 50%;
}

.mRCSearchheadTheme{
	
	background: #fff;
}
.mRCSearchhead{
	height:40px;
}
.mRCSearchTabSelTheme{
	color:#0d7ba0;
	font-family:arial;
	font-size:12px;
	font-weight:bold;
	text-transform: uppercase;
	padding-left:20px;
	border-bottom: 3px solid #0d7ba0;
	
}
.mRCSearchTabTheme{
	color:#37393a;
	font-family:arial;
	font-size:12px;
	font-weight:normal;
	text-transform: uppercase;
	padding-left:20px;
	/* border-bottom: 3px solid white; */
}
	#ClinicalNotesConfirmDialog {
  display: none;
  width: 340px;
  height: 280px;
  z-index: 500;
}
.Error_Window {
	width: 325;
	height: 200px;
	border: 2px solid #ffffff;
	background: #074860;
	margin: 10px;
	min-height: 200px;
	max-width: 325px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);
	margin: 10px;
	border-radius: 10px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	overflow: hidden
}
	.Error_msg_box {
	width: 100%;
	height: 150px;
	max-height: 150px;
	max-width: 100%;
	border-bottom: 1px solid #000000;
}
	
	.Error_msg {
	height: 150px;
	width: 100%;
	overflow: auto;
	z-index: 999999;
	position: relative;
	display: table;
}
	.Error_msg_Frame {
	display: table-cell;
	vertical-align: middle
}
	.Error_icon
{
	width:60px;
	height:100%;
	float:left;
	text-align:right;
	
}
.Error_cont
{
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	color:#ffffff;
	text-align:center;
	padding-top: 10px;
	padding-left:10px;
}
.Error_msg_btn {
	width: 100%;
	height: 49px;
	background: #2ea3c0; /* Old browsers */
	background: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */
	background: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2ea3c0', endColorstr='#0c7d9a', GradientType=0 ); /* IE6-9 */
display:table;
}
#ClinicalNotesErrorDialog {
  display: none;
  width: 340px;
  height: 280px;
  z-index: 500;
}
.Error_btn_div_con_single
{
	width:100%;
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;	
	display: table-cell;
	vertical-align: middle;
	cursor:pointer;
}
.Error_btn_div_con
{
	width:159px;
	height:100%;
	font-family:Arial, Helvetica, sans-serif;
	font-size:12px;
	font-weight:bold;
	color:#ffffff;
	text-align:center;	
	display: table-cell;
	vertical-align: middle;
	cursor:pointer;
	
}
.Error_btn_div
{
	width:0px;
	height:100%;
	border-left:1px solid #0bb5dd;
	border-right:1px solid #023542;
	float: left;
}
	.top_shadow {
	width: 100%;
	height: 90px;
	background: #3b6f81; /* Old browsers */
	background: -moz-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* FF3.6+ */
	background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #3b6f81), color-stop(64%, #074860)); /* Chrome,Safari4+ */
	background: -webkit-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Chrome10+,Safari5.1+ */
	background: -o-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Opera 12+ */
	background: -ms-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* IE10+ */
	background: radial-gradient(ellipse at center, #3b6f81 0%, #074860 64%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3b6f81', endColorstr='#074860', GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
	margin-top: -40px;
	margin-top: -240px;
	z-index: -999;
}
#ForwardNotesPop{
	height:304px;
	width:740px;
	z-index:10005;
	display: none;
}

.SaveErrorEnable{
  opacity: 0.4;
  pointer-events:none;
} 
</style>
</head>
<body>
	<div id="ClinicalNotesConfirmDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
		  <div class="Error_msg_box">
		    <div class="Error_msg">
		      <div class="Error_msg_Frame">
		        <div>
		          <div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30" /> </div>
		          <div class="Error_cont" id="ClinicalNotesConfirmDialogMsg">Authorization comfirmation window</div>
		        </div>
		      </div>
		    </div>
		  </div>
		  <div class="Error_msg_btn">
		    <div class="Error_btn_div_con" onclick="closeConfirmDialog()">Cancel </div>
		    <div class="Error_btn_div"> </div>
		    <div class="Error_btn_div_con" data-value="true">OK </div><!-- Onclick event for OK button will be binded dynamically -->
		  </div>
		  <div class="top_shadow"> </div>
		</div>
	</div>
	
	<div id="ClinicalNotesErrorDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
			<div class="Error_msg_box">
			    <div class="Error_msg">
					<div class="Error_msg_Frame">
						<div>
							<div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopWarning.png" width="30" height="30" /></div>
							<div class="Error_cont" id="ClinicalNotesErrorDialogMsg"></div>
						</div>
					</div>
			    </div>
			</div>
			<div class="Error_msg_btn" onclick="closeErrorDialog()">
			    <div class="Error_btn_div_con_single">OK</div>
			</div>
			<div class="top_shadow"> </div>
		</div>
	</div>
<!-- popup container cannedText starts -->
			<div class="sfsIPTheme absoluteCenter" id="cannedTextPop" style="display:none">
				<div class="SfsParent SfsParentTheme" data-role="none">
					<div class="SfsParentTable" style="table-layout: fixed; data-role="none">
						<div class="SfsParentHeaderRow" data-role="none">
							<div class="SfsParentHeaderCell" data-role="none">
								<div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
									<div class="SfsHeaderRow" data-role="none">
										<div class="SfsHeaderButtonCol" data-role="none">
											<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "closecannedTextPop()">
												<%=csResBundle.getString("common.cancel") %>
											</div>
										</div>
										<div class="SfsHeaderTextCol" data-role="none">
											<div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
												Canned Text
											</div>
										</div>
										<div class="SfsHeaderButtonCol" data-role="none">
											<div  id="CantextSelect" class="SfsHeaderButton SfsHeaderButtonTheme canSelectDisable"  data-role="none"  onclick = "selectcannedTextPop()">												
												<%=csResBundle.getString("common.select") %>
											</div>					
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="SfsParentBodyRow" data-role="none">
							<div class="SfsParentBodyCell" data-role="none" style="width:100%;height:100%;padding:5px">
								<div style="display:table;width:100%;height:100%;table-layout: fixed;">
									<div style="display:table-row">
										<div style="display:table-cell" class="mRCSearchhead">
											<div style="display:table;width:100%;height:100%;table-layout: fixed;" class="mRCSearchheadTheme">
												<div style="display:table-row">
													<div style="display:table-cell;vertical-align:middle;height:100%;white-space: nowrap;padding-right: 20px" class="mRCSearchTabSelTheme" id="TabText" onclick="loadTabTextTypes('text')">
															Text
													</div>
													<div style="display:table-cell;width:90%;vertical-align:middle;height:100%" class="mRCSearchTabTheme" id="TabEditorText" onclick="loadEditorTextTypes('html')">
															 Editor Text
													</div>
												</div>
											</div>
										</div>
									</div>
									<div style="display:table-row;">
										<div style="display:table-cell;width:100%;height:100%;background:#fcfcfc" id="CannedTextListContainer">
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
<!-- popup container cannedText ends -->

	<div id="divParent" class="divParent" data-role="page" style="padding: 0px">
		<%-- <form name = "frmRecordNotes" id = "frmRecordNotes" style="width: 100%; height: 100%" action="${path}/mobile/charts/notes/MRecClinicalNotesSections" method="post"> --%>
			<div data-role = "none" id = "dvMez" class = "blurPopup" data-popid="" style="z-index:10000"></div>
			
			<!-- popup container -->
			<!-- <div data-role="none" class="diagSfs sfsIPTheme" id="sfs">
				<iframe id="sfsFrame" frameborder="0" style="display: block;"
					scrolling="no" class="popupIFrame" src=""></iframe>
			</div> -->
			<!-- forward starts -->
			<div class="sfsIPTheme absoluteCenter" id="ForwardNotesPop" style="">
        		 <div class="SfsParent SfsParentTheme" data-role="none">
					<div class="SfsParentTable" data-role="none">
               			<div class="SfsParentHeaderRow" data-role="none">
			                  <div class="SfsParentHeaderCell" data-role="none">
			                     <div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
			                        <div class="SfsHeaderRow" data-role="none">
			                           <div class="SfsHeaderButtonCol" data-role="none">
			                              <div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick="closeForwardNotesPop()">
			                                 Cancel
			                              </div>
			                           </div>
			                           <div class="SfsHeaderTextCol" data-role="none">
			                              <div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
			                                 Forward notes
			                              </div>
			                           </div>
			                           <div class="SfsHeaderButtonCol" data-role="none">
			                            
										  <div id="SendsHeaderButton" class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick="recordAndForwardNote()">
			                                 Send
			                              </div>
			                           </div>
			                        </div>
                     			</div>
							</div>
						</div>
             
						<div class="SfsParentBodyRow" style="background-color: #196986;">
							<div class="divAllergyContent divAllergyContentTheme" style="padding: 0px; border-radius: 3px;">
								<div style="width: 100%; height: auto;">
									<div style="width: 100%; height: 100%;" data-role="none">
										<div data-role="none" style="width: 100%; height: auto">
											<!-- first row -->
											<div class="rowContainer" data-role="none">
												<table cellpadding="0" cellspacing="0" class="tbRowContainer" border="0">
													<tbody><tr class="normalTr">
														<td class="td30" valign="middle" align="right">
															<div class="allergyRowFonts">Forward to</div>
														</td>
														<td class="td70" valign="middle" align="left">
															<div style="display:table;width:100%;height:100%;margin-left: 10px;">
	                                           					<div style="display:table-row">
	                                              					<div style="display:table-cell;vertical-align:middle;text-align:right;padding-right:5px;width: 70px;">
	                                                 					<div class="dvSliderLabel" data-labelfor="forwardNoteSlidePointer-1" data-labelval="1" >Practitioner</div>
	                                              					</div>
	                                              					<div style="display:table-cell;vertical-align:middle;text-align:center;width:50px">
																		<div class = "sliderSmallParent" data-role = "none">
						                                                    <div  class = "sliderSmallScale sfsScaleTheme" id="forwardNoteSlider"  data-role = "none" >
						                                                    	<div class="sliderSfsIns sliderSfsInsTheme">
						                                                          	<div data-role = "none" class = "sliderSmallPointer sfsCritRoundTheme" id = "forwardNoteSlidePointer"
						                                                             data-parent = "forwardNoteSlider" data-numpoints="2" data-drag="N" 
						                                                             data-valuefield="hdnforwardNote" data-value1="C" data-value2="O" data-defaultvalue="C" 
						                                                             data-selstylelabel="slSelectedLabel">
						                                                          	</div>
						                                                          	<input type="hidden" id="hdnforwardNote" name="hdnForwardNote" id="hdnForwardNote" value="">
																				</div>
						                                                    </div>
						                                            	</div>
	                                              					</div>
																	<div style="display:table-cell;vertical-align:middle;text-align:left;padding-left:5px;width: 70px;">
						                                            	<div data-labelfor="forwardNoteSlidePointer-2" class="dvSliderLabel" data-labelval="2" >Speciality</div>
						                                            </div>
												  					<div style="display:table-cell;vertical-align:middle;text-align:left;padding-left:5px;">
	                                              					</div>
	                                           					</div>
	                                        				</div>
														</td>
													</tr>
												</tbody></table>
											</div>
											<!-- first row ends -->
											<div class="rowDivider"></div>
											<!-- Second Row Starts -->
											<div class="rowContainer" data-role="none" id="practitionerSideFieldWrap" style="display:block;">
												<table cellpadding="0" cellspacing="0" class="tbRowContainer" border="0">
													<tbody><tr class="normalTr">
														<td class="td30" valign="middle" align="right">
															<div class="allergyRowFonts" id="cmbEventType_Label">Practitioner <sup style="color: red">*</sup>
															</div>
														</td>
														<td class="td70" valign="middle" align="left">
															<div class="divEventThemepractitioner" style="position: relative;width: 85%;margin-left: 10px;">
																<table cellpadding="0" cellspacing="0" style="width: 100%; height: 100%">
																	<tbody><tr style="width: 100%; height: 100%">
																		<td class = "cstFieldContainer1" style="width: 100%; height: 100%" valign="middle" align="right">
																			<select id="practionerMulSelect" multiple="multiple" data-type = "ComboBox"></select>
                                                            				<script>
																				$(document).ready(function() {
                                                                					$("#practionerMulSelect").kendoMultiSelect({
	                                                               						dataTextField: "desc",
	                                                                               		dataValueField: "code",
	                                                                               		change: function(e) {
		                                                                                   	var value = this.value();
		                                                                                   	var complStr = "";
		                                                                                   	for(var i=0; i<value.length;i++){
		                                                                                   		complStr = complStr+value[i]+"$";
		                                                                                   	}
		                                                                                   	$("#hdnDiagCompl").val(complStr);
		                                                                                   // Use the value of the widget
																							if($('#txtSubject1').val() != '' &&  $('.cstFieldContainer1 .k-multiselect-wrap ul').find('li').length >0 ) {		
																								$('#SendsHeaderButton').removeClass("SaveErrorEnable");
																							}else{
																								$('#SendsHeaderButton').addClass("SaveErrorEnable");
																							}
	                                                                               		}
                                                               						});
																					$('#RemarksTextArea').on('keyup',function(){
																					    if($(this).val() != '') {
																					        $('#SaveError').removeClass("SaveErrorEnable");
																					    }else{
																					        $('#SaveError').addClass("SaveErrorEnable");
																					    }
																					});

																					$('#txtSubject2').on('keyup',function() {
																						var str = $(this).val();
																						var n = str.length;	
																						var selectedVal =  $("#specialityCmbDiagSet").data("kendoComboBox").value();
											   											if($('#txtSubject2').val() != '' &&   selectedVal != ''){		
																							$('#SendsHeaderButton').removeClass("SaveErrorEnable");
																					   	}else{
																							$('#SendsHeaderButton').addClass("SaveErrorEnable");
																						}
																					});												

																					$('#txtSubject1').on('keyup',function() {	
																						var str = $(this).val();
																						var n = str.length;
																						if($(this).val() != '' &&  $('.cstFieldContainer1 .k-multiselect-wrap ul').find('li').length >0 ) {		
																							$('#SendsHeaderButton').removeClass("SaveErrorEnable");
																						}else{
																							$('#SendsHeaderButton').addClass("SaveErrorEnable");
																						}
																					});
								                                                 });
                                                            				</script>
				                                                            <input type="hidden" name="hdnDiagCompl" id="hdnDiagCompl" id="hdnDiagCompl" value='' /> 
																		</td>
																	</tr></tbody>
																</table>
															</div>
														</td>
													</tr>
												</tbody></table>
											</div>
												
											<div class="rowContainer" data-role="none" id="specialitySideFieldWrap" style="display:none;">
												<table cellpadding="0" cellspacing="0" class="tbRowContainer" border="0">
													<tbody><tr class="normalTr">
														<td class="td30" valign="middle" align="right">
															<div class="allergyRowFonts" id="cmbEventType_Label">Speciality <sup style="color: red">*</sup>
															</div>
														</td>
														<td class="td70" valign="middle" align="left">
															<div class="divEvent divEventThemeSpeciality">
																<table cellpadding="0" cellspacing="0" style="width: 100%; height: 100%">
																	<tbody><tr style="width: 100%; height: 100%">
																		<td style="width: 100%; height: 100%" valign="middle" align="right">
					
																			 <input id="specialityCmbDiagSet" name="specialityCmbDiagSet" id="specialityCmbDiagSet" data-type="ComboBox" data-role="none" data-mandatory="true" />
					                                                            <input type="hidden" name="hdnDiagSet" id="hdnDiagSet" id="hdnDiagSet" value='' />
																		</td>
																	</tr>
																</tbody></table>
															</div>
														</td>
													</tr>
												</tbody></table>
											</div>
											<!-- second Row ends -->
											<div class="rowDivider"></div>
											<!-- Fourth Row Starts -->
											<div class="rowContainer1" data-role="none" id="practitionerSubjectFieldWrap" style="display:block;">
												<table cellpadding="0" cellspacing="0" class="tbRowContainer1" border="0">
													<tbody><tr class="normalTr">
														<td class="td30" valign="middle" align="right">
															<div class="allergyRowFonts" id="txtCA_Label">Subject <sup style="color: red">* </sup></div>
														</td>
														<td class="td70" valign="middle" align="left">
															<div style="position: relative; width: 100%; height: auto" data-role="none">
																<textarea rows="6" id="txtSubject1" name="txtSubject" style="margin-left: 10px;width: 428px;border: 1px solid #d6d6d6;-webkit-appearance: none;" cols="30" maxlength="200"></textarea>
															</div>
														</td>
													</tr>
												</tbody></table>
											</div>
											<div class="rowContainer1" data-role="none" id="specialitySubjectFieldWrap" style="display:none;">
												<table cellpadding="0" cellspacing="0" class="tbRowContainer1" border="0">
													<tbody><tr class="normalTr">
														<td class="td30" valign="middle" align="right">
															<div class="allergyRowFonts" id="txtCA_Label">Subject <sup style="color: red">*</sup></div>
														</td>
														<td class="td70" valign="middle" align="left">
															<div style="position: relative; width: 100%; height: auto" data-role="none">
																<textarea rows="6" id="txtSubject2" name="txtSubject2" style="margin-left: 10px;width: 428px;border: 1px solid #d6d6d6;-webkit-appearance: none;" cols="30"></textarea>
															</div>
														</td>
													</tr>
												</tbody></table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
           </div>
			<!--  forward popup ends -->
			<div class="sfsIPTheme absoluteCenter" id="NoteSelectorPop" style="display:none">
				<div class="SfsParent SfsParentTheme" data-role="none">
					<div class="SfsParentTable" data-role="none">
						<div class="SfsParentHeaderRow" data-role="none">
							<div class="SfsParentHeaderCell" data-role="none">
								<div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
									<div class="SfsHeaderRow" data-role="none">
										<div class="SfsHeaderButtonCol" data-role="none">
											<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "closeNoteSelectorPop()">
												<%=csResBundle.getString("common.cancel") %>
											</div>
										</div>
										<div class="SfsHeaderTextCol" data-role="none">
											<div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
												Select Note
											</div>
										</div>
										<div class="SfsHeaderButtonCol" data-role="none">
											<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" style = "display:none">
												<%=csResBundle.getString("common.select") %>
											</div>					
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="SfsParentBodyRow" data-role="none">
							<div class="SfsParentBodyCell" data-role="none" style="width:100%;height:100%;padding:5px">
								<div style="display:table;width:100%;height:100%">
									<div style="display:table-row">
										<div style="display:table-cell" class="mRCSearchhead">
											<div style="height:100%" class="mRCSearchheadTheme">
												<div style="height:100%">
													<div style="float:left;height:60%;width:11%;white-space: nowrap;padding-top:13px;padding-right: 20px" class="mRCSearchTabSelTheme" id="TabAll" onclick="loadAllNoteTypes()">
															All
													</div>
													<div style="float:left;height:60%;width:16%;white-space: nowrap;padding-top:13px;padding-right: 20px" class="mRCSearchTabTheme" id="TabFreq" onclick="loadFrequentNoteTypes()">
															Frequently Used
													</div>
													
													<div style="clear: both" ></div>
												</div>
											</div>
										</div>
									</div>
									<div style="display:table-row;">
										<div style="display:table-cell;width:100%;height:100%;background:#f7f7f7" id="NotesListContainer">
											
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			</div>
			<!-- popup container ends -->
			
					
			
			
			
			
			<!-- create note header starts -->
			<div id="createNoteHeader" class="createNoteHeader" style="padding: 0px"
					data-role="none">
					<table cellpadding="0" cellspacing="0" class="tbAllergyHeader"
						data-role="none">
						<tr class="normalTr">
							<td class="normalTd">
								<div class="RecordAllergyHeader RecordAllergyHeaderTheme">
									<div class="RecordAllergyTable">
										<div class="normalRow">
											<div class="AllergyCell" style="width: 99%; text-align: left">
											<!-- TODO Replace it wth msg bundle -->
											<%if(operation_mode.equals("Record")){ %>
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Create Note </div> 
											<%}else{ %>
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Modify Note </div> 
											<%} %>
										</div>
											<div class="AllergyCell" style="width: 1%">
												<div class="RecordAllergyTable">
													<div class="normalRow">
													    <div class="AllergyCell cstFieldDull" style="width: auto; text-align: right" id="CNActionBtnChooseNoteType" onclick=""><!--  onclick="signNote()" -->
															<div class="CNButtonContainer">
														
																<div  class="CNButtonItemTheme" >
																	<img src="${path}/eIPAD/images/AddNote24x24.png" />
																</div>
																
															</div>
														</div>
														<%-- <div class="AllergyCell cstFieldDull"  style="width: auto; text-align: right" id="CNActionBtnPreviewNote" onclick=""><!--  onclick="signNote()" -->
															<div class="CNButtonContainer">
														
																<div  class="CNButtonItemTheme" >
																	<img src="${path}/eIPAD/images/Preview24x24.png" />
																</div>
																
															</div>
														</div> --%>
														<div class="AllergyCell cstFieldDull" style="width: auto; text-align: right" id="CNActionBtnSignNote" onclick=""><!--  onclick="signNote()" -->
															<div class="CNButtonContainer ">
														
																<div  class="CNButtonItemTheme">
																	<img src="${path}/eIPAD/images/sign25x25.png" />
																</div>
																
															</div>
														</div>
														<div class="AllergyCell cstFieldDull" style="width: auto; text-align: right"  id="CNActionBtnRecordUpdateNote" onclick=""><!--  onclick="recordUpdateNote()" -->
															<div class="CNButtonContainer">
															
																<div class="CNButtonItemTheme">
																	<img src="${path}/eIPAD/images/Tick25x25.png" >
																</div>
																
															</div>
														</div>
													<%-- 	<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="CNButtonContainer" onclick="showNoteSelectorPop()">
															
																<div class="CNButtonDisableTheme"  >
																	<img src="${path}/eIPAD/images/Left_ArrowCn.png"  />
																</div>
																
															</div>
														</div>
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="CNButtonContainer ">
															
																<div class="CNButtonItemTheme" id="RecordDiagSubmitButton" onclick="validateAndRecordNotes()">
																	<img src="${path}/eIPAD/images/Right.png " />
																</div>
															
															</div>
														</div> --%>
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="CNButtonContainer "  onclick="confirmCancelTransaction()">
															
																<div class="CNButtonItemTheme">
																	<img src="${path}/eIPAD/images/CS_Close16x16.png"  />
																</div>
																
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<!-- create note header ends -->
				
				
				<!-- Create Note Header - Pavithra -->
				<%-- <div id="createNoteHeader" class="container-fluid" style="padding: 0px"
					data-role="none">
					<table cellpadding="0" cellspacing="0" class="tbAllergyHeader"
						data-role="none">
						<tr class="normalTr">
							<td class="normalTd">
								<div class="RecordAllergyHeader RecordAllergyHeaderTheme">
									<div class="RecordAllergyTable">
										<div class="normalRow">
											<div class="AllergyCell" style="width: 99%; text-align: left">
											<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Create Note </div> <!-- TODO Replace it wth msg bundle -->
										</div>
											<div class="AllergyCell" style="width: 1%">
												<div class="RecordAllergyTable">
													<div class="normalRow">
														<div class="AllergyCell" style="width: auto; text-align: right" onclick="signNote()">
															<div class="CNButtonContainer ">
														
																<div  class="CNButtonDisableTheme" >
																	<img src="${path}/eIPAD/images/sign.png" />
																</div>
																
															</div>
														</div>
														<div class="AllergyCell" style="width: auto; text-align: right" onclick="recordUpdateNote()">
															<div class="CNButtonContainer ">
															
																<div class="CNButtonDisableTheme"  >
																	<img src="${path}/eIPAD/images/Tick.png" >
																</div>
																
															</div>
														</div>
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="CNButtonContainer" onclick="showNoteSelectorPop()">
															
																<div class="CNButtonDisableTheme"  >
																	<img src="${path}/eIPAD/images/Left_ArrowCn.png"  />
																</div>
																
															</div>
														</div>
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="CNButtonContainer ">
															
																<div class="CNButtonItemTheme" id="RecordDiagSubmitButton" onclick="validateAndRecordNotes()">
																	<img src="${path}/eIPAD/images/Right.png " />
																</div>
															
															</div>
														</div>
														<div class="AllergyCell"
															style="width: auto; text-align: right">
															<div class="CNButtonContainer "  onclick="confirmCancelTransaction()">
															
																<div class="CNButtonItemTheme">
																	<img src="${path}/eIPAD/images/CS_Close16x16.png"  />
																</div>
																
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</table>
				</div> --%>
				<!-- Create Note Header - Pavithra -->
				
				
				<div id="divcnt" class="divAllergyContent divAllergyContentTheme" style="padding: 0px; overflow: hidden;" data-role="none">
					
					<div id="NoteSectionView" style="width:100%;height:100%;position:relative">
					
					</div>
					
					<!-- Mandatory fields error -->
					<div class="formValErrorTheme formValError" id="MandatoryFields_Error" style="bottom: 10px; left: 2%; display: none">
						<div class="formValErrorMsgTheme" id="MandatoryFields_ErrorMsg">All mandatory fields must be entered</div>
					</div>
				</div>
				</div>
				<input type="hidden" name="hdnPath" id="hdnPath" id="hdnPath" value="${path}" /> 
				
				<input type="hidden" name ="practName" id="practName" value="<%=practName %>"/>
				<input type="hidden" id="DefaultServiceCode" name="DefaultServiceCode" id="DefaultServiceCode" value=''/><!-- Service Code of the current encounter -->
				<input type="hidden" name="operation_mode" id="operation_mode" id="operation_mode" value='<%=operation_mode%>'/>
				<%
				if(!operation_mode.equals("Record")){
				%>	
					<input type="hidden" name="edit_note_type" id="edit_note_type" id="edit_note_type" value='<%=note_type%>'/>
					<input type="hidden" name="amendment_type" id="amendment_type" id="amendment_type" value='<%=amendment_type %>'/>
				<%	
				}else{
				%>
					<input type="hidden" name="edit_note_type" id="edit_note_type" id="edit_note_type" value=''/>
				<%
				}
				%>
				<input type="hidden" name="edit_accession_num" id="edit_accession_num" id="edit_accession_num" value='<%=accession_num%>'/><!-- Empty incase of Record -->
				<input type="hidden" name="action_comment" id="action_comment" id="action_comment" value='<%=action_comment%>'/>
				<input type="hidden" name="event_status_code" id="event_status_code" id="event_status_code" value='<%=event_status_code%>'/>
				<input type="hidden" name="UnsavedExists" id="UnsavedExists" id="UnsavedExists" value='false'/>
				
				
		<!-- </form> -->
	</div>
	<div class="<%=formValErrClass %> CSTransactionMessage" id="transactionMsg" style="bottom: 10px; left: 10px; display: none;z-index:10001">
									<div class="formValErrorMsgTheme" id = "transactionMessageContent"><%=transactionMessage %></div>
								</div>
</body>
</html>


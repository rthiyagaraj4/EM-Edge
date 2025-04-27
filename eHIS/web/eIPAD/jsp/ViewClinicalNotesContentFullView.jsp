<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>



<%@page import="eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse"%>
<%@page import="eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num=request.getParameter("accession_num");
String notesHeader = "header";//request.getParameter("notesHeader");
String	notes_content		=	"";


java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;
String note_type = "";
String note_type_desc = "";
String pract_name = "";
String event_status_code = "";
String event_status = "";
//String practId = (String)session.getAttribute("practitioner_id");
//String respId = (String)session.getAttribute("responsibility_id");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");

String errorStatus = "In Error";

String facilityId=patientContext.getFacilityId();


//sqlStr.append("SELECT B.TERM_SET_DESC AS ProblemSet,A.TERM_CODE as DiagProb,A.TERM_CODE_SHORT_DESC as Description FROM PR_DIAGNOSIS A JOIN MR_TERM_SET B ON A.TERM_SET_ID = B.TERM_SET_ID WHERE A.PATIENT_ID = 'MC00000149'");

sqlStr.append("SELECT a.note_content,a.note_type, a.event_status, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,'" + locale + "' ,'1') note_type_desc, am_get_desc.am_practitioner (a.performed_by_id, '" + locale+"', 2 ) pract_name FROM ca_encntr_note a where  a.accession_num= '" + accession_num + "'");

Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection conn=null;
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
String strRowCount = "";
try {
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
stmt1	 = conn.createStatement();
if (rs!=null) rs.close();   
rs = stmt.executeQuery(sqlStr.toString());

if(rs != null && rs.next())
{
	clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");
	pract_name = rs.getString("pract_name") == null? "":rs.getString("pract_name"); // performed by
	note_type_desc = rs.getString("note_type_desc") == null? "":rs.getString("note_type_desc"); // note type
	note_type = rs.getString("note_type") == null? "":rs.getString("note_type"); // note type
	event_status_code = rs.getString("event_status") == null? "":rs.getString("event_status");
	if(event_status_code.equals("1")){
		event_status = "In Progress";
	}
	else if(event_status_code.equals("2")){
		event_status = "Transcribed";
	}
	else if(event_status_code.equals("3")){
		event_status = "Unauthorized";
	}
	else if(event_status_code.equals("4")){
		event_status = "Authorized";
	}
	else if(event_status_code.equals("5")){
		event_status = "Modified";
	}
	else if(event_status_code.equals("9")){
		event_status = "In Error";
	}

	
	if(clob_notes_content != null)
	{
		try
		{
			content_reader	= clob_notes_content.getCharacterStream();
			bf_content_reader = new java.io.BufferedReader(content_reader);
			char[] arr_notes_content = new char[(int)clob_notes_content.length()];
			bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
			notes_content = new String(arr_notes_content);
			bf_content_reader.close();
		}
		catch(Exception e)
		{
			out.println("Exception@2-readCLOB : "+e);
		}

		if(!notes_content.equals(""))
		{
			int nIndex	= notes_content.indexOf("<BODY>");
			int nIndex1 = notes_content.lastIndexOf("</BODY>");

			if(nIndex != -1 && nIndex1 != -1)
				notes_content = notes_content.substring(nIndex+6,nIndex1);
		
			notes_content=notes_content.replace("<address>","<address1>");
			notes_content=notes_content.replace("</address>","</address1>");
		}
	}//c
}

}catch ( Exception e ){
	out.println("Exception " + e);
	//out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(conn,request);
}

ClinicalNotesBC bc = new ClinicalNotesBC();
ClinicalNotesMapResponse operationsAllowedResp = bc.getApplicableNoteOperations(patientContext, accession_num);
HashMap operationsHash = operationsAllowedResp.getMap();
String operations_allowed = (String)operationsHash.get("operations_allowed");
String amendment_type = (String)operationsHash.get("ammendment_type");
StringTokenizer stoken = new java.util.StringTokenizer(operations_allowed,"|");	
HashMap arrFunctions = new HashMap();
while(stoken.hasMoreTokens()){
	String button_name	=	(String) stoken.nextToken();
	//if(!arrFunctions.contains(button_name) )
	arrFunctions.put(button_name,button_name);
}	



%>

<%-- <!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />

<link rel="stylesheet" href="${path}/eIPAD/jquery.mobile-1.3.1.min.css" />
<script src="${path}/eIPAD/jquery-1.9.1.js"></script> 
<script src="${path}/eIPAD/jquery.mobile-1.3.1.min.js"></script>
<script src="${path}/eIPAD/js/libjs/kendo/kendo.web.min.js"></script>
<link rel="stylesheet" href="${path}/eIPAD/css/iPADThemeA.css" />
<link rel="stylesheet" href="${path}/eIPAD/css/iPADNew.css" />
<script type="application/javascript" src="${path}/eIPAD/js/iscroll.js"></script> --%>

<script type="application/javascript" src="${path}/eIPAD/js/GenericSlider.js"></script>
<script type="text/javascript">
var clickStatus="";
function openClinicalNotes(){
	window.location.replace(path+"/mobile/charts/notes/OpenClinicalNoteServlet");
}

function completeTransaction(data){
	var transactionParams = "transactionOccurred=true&transactionMessage="+data.transactionMessage+"&transactionResult="+data.transactionResult;
	var cspath = path + "/mobile/charts/notes/OpenClinicalNoteServlet?" + transactionParams;
	window.location.replace(cspath);
}	
	
function saveRemark(ademnType,accesNum,remark){
	if(clickStatus=="error"){
		var action_comment= $("#RemarksTextArea").val();
		$.ajax({
			  method: "POST",
	 		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
			  data: {action_comment:action_comment,accession_num:accesNum,amendment_type:ademnType,operation_mode:remark}
		})
		.done(function(response) {
			$("#DisplayErrorReasonPop").hide();
			$("#EnterRemarksPop").hide();
			closeMez();
			completeTransaction(response);
		});
	}else if(clickStatus=="modify"){
		//var accession_num = $('#accession_num').val();
		//var note_type = $('#note_type').val();
		modifyClinicalNotes();
	}
/* 	else if(clickStatus == "SignOnModify"){
		var accession_num = $('#accession_num').val();
		var note_type = $('#note_type').val();
		signOnModifyClinicalNotes(accession_num,note_type);
	} */
	
}


var noteContentScroll;
function assignNoteContentScroll() {
	 setTimeout(function () {
		 noteContentScroll = new iScroll('NoteContentWrapper', {
		useTransform: true,
		zoom: false,
	
		});
}, 1000); 
}

function ErrorDetails()
{
	var accession_num = $('#accession_num').val();
	var errorData;

	$.getJSON(path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=INERROR&accessionNumber="+accession_num+"&operation_mode=ViewNoteStatus", function(data){
		if(data!=null){		
		errorData = data.code;
		var res = errorData.split("/");
		var dateConvert=res[1]+"/"+res[0]+"/"+res[2];
        var errDate = res[0];
        var	errMonth= res[1];    
        var yearDate = res[2];
        var monthNames = ["January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"];

        var monthName = new Date(dateConvert);
		var monthFullName = (monthNames[monthName.getMonth()]);
		var finalErrDate = errDate+" "+monthFullName+" "+yearDate;	
			
		var markedErrDate = finalErrDate;
		var clinicianName = data.detail;	
      $('#markedErrDate').html(markedErrDate);
	  $('#clinicianName').html(clinicianName);
		}
		 });  
}

function showErrorReasonPop(acces_no,facilityId){
	$.getJSON(path+"/mobile/charts/notes/ClinicalNotesJSONServlet?field=REMARK&facilityId="+facilityId+"&accessionNumber="+acces_no, function(data){
		
		var getMessage=data[0].map;
		var remarkMess=getMessage.message;
		$('#errorRemark').html(remarkMess);
			
			ErrorDetails();
		 });
	 
	 
	
	$("#DisplayErrorReasonPop").show();
	showMez('DisplayErrorReasonPop');
	$('#RemarksTextArea').val('');
}

function showMarkErrorPop(){
	$('#SaveError').addClass("SaveErrorEnable");
	$("#EnterRemarksPop").show();
	showMez('EnterRemarksPop');
	$('#RemarksTextArea').val('');
	$("#ErrorLable").show();
	$("#modifyLable").hide();
	
	clickStatus="error";
}

function modifyClinicalNotes(){
	var event_status_code = $("#event_status_code").val();
	var accession_num = $('#accession_num').val();
	var note_type = $('#note_type').val();
	var action_comment= $("#RemarksTextArea").val();
	$("#DisplayErrorReasonPop").hide();
	$("#EnterRemarksPop").hide();
	closeMez();
	var amendment_type = $("#amendment_type").val();
	var operation_mode;
	if(event_status_code == '1')
		operation_mode = 'UpdateRecord'
	else if(amendment_type =="A" && event_status_code != '1')
		operation_mode	=	"ModifyAddendum";
	else
		operation_mode	=	"ModifySection";
	window.parent.document.getElementById('ChartSummaryIframe').src ='${path}/mobile/charts/notes/MRecClinicalNotesInit?accession_num='+accession_num+'&note_type='+note_type+'&operation_mode='+operation_mode+'&amendment_type='+amendment_type+'&action_comment='+action_comment+'&event_status_code='+event_status_code;
	window.parent.closeNotesContent();
}
/* function signOnModifyClinicalNotes(accession_num,note_type){
	var action_comment= $("#RemarksTextArea").val();
	$("#DisplayErrorReasonPop").hide();
	$("#EnterRemarksPop").hide();
	closeMez();
	var amendment_type = $("#amendment_type").val();
	var operation_mode	=	"SignOnModify";
	
	$.ajax({
		  method: "GET",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
		  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,action_comment: action_comment}
	})
	.done(function(response) {
		closeNotesContentFullView();
		openClinicalNotes();
	});

	//window.parent.closeNotesContent();
} */

function showSignOnModifyConfirmDialog(){ 
	
	$("#ClinicalNoteCnfmDialog").show();
	showMez("ClinicalNoteCnfmDialog");
	var signOnModify = function(){
		closeConfirmDialog();
		closeMez();
		signOnModifyClinicalNotes();
	};
	$("#ClinicalNoteCnfmDialog").configureConfirmDialog({
		callBackForTrue: signOnModify
	});
	var errorMsg = "Do you want to Sign this note?";
	showConfirmDialog(errorMsg);
	
}

function signOnModifyClinicalNotes(){
	var accession_num = $("#accession_num").val();
	var amendment_type = $("#amendment_type").val();
	var note_type = $("#note_type").val();
	var operation_mode	=	"SignOnModify";
	var action_comment= $("#RemarksTextArea").val();
	$.ajax({
	  method: "POST",
	  url: path+"/mobile/charts/notes/MRecClinicalNotesValidation",
	  data: { operation_mode: "Sign", note_type: note_type }
	})
	.done(function( data ) {
		var valiResp = data;
		if(valiResp.validationResult == 0){
				$.ajax({
					  method: "GET",
					  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
					  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,action_comment: action_comment,note_type: note_type}
				})
				.done(function(response) {
					closeNotesContentFullView();
					completeTransaction(response);
				});
		}
		else{
			var errorList = valiResp.errorList;
			if(errorList.length>0){
				for(var i=0;i<errorList.length;i++){
					var errorMessageId = valiResp.errorList[i].errorMessageId;
					if(errorMessageId == 'PRIVILEGE_ERROR'){
						closeConfirmDialog();
						showForwardNotesOnSignPop();
						
						
					}
				}
			}
		}
		
		
	});

}
function forwardOnSign(){
	var accession_num = $("#accession_num").val();
	var amendment_type = $("#amendment_type").val();
	var note_type = $("#note_type").val();
	var operation_mode	=	"SignOnModify";
	var action_comment= $("#RemarksTextArea").val();
	var selectedType = document.getElementById('hdnforwardNote').value;
	if(selectedType=="C"){
		var message = $('textarea#txtSubject1').val();
		var selectedPractitioner = document.getElementById("hdnDiagCompl").value;
		var practitionerCode =  selectedPractitioner;
        var change = ','
        practitionerCode = practitionerCode.split('$').join(change);
		$.ajax({
			  method: "GET",
			  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
			  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,forward_mode:"P",forwarded_clinician_ids:practitionerCode,action_comment: message,note_type: note_type}
		})
		.done(function(response) {
			closeNotesContentFullView();
			completeTransaction(response);
		});
	}else{
		var selectedSpe= $("#specialityCmbDiagSet").data("kendoComboBox").value();
		var message = $('textarea#txtSubject2').val();
		$.ajax({
			  method: "GET",
			  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
			  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,forward_mode:"S",forwarded_clinician_id:selectedSpe,action_comment: message,note_type: note_type}
		})
		.done(function(response) {
			closeNotesContentFullView();
			completeTransaction(response);
		});
	}
	
}

function modifyNotes(acces_no,note_type){ //TODO Aravintha change this function name to modifyNotesCaptureRemarks
	$('#RemarksTextArea').val('');
	$('#SaveError').addClass("SaveErrorEnable");
	var event_status_code = $("#event_status_code").val();
	if(event_status_code != '4' && event_status_code != '5'){ //show confirm popup in case of non-authorized note, there is no need to capture remarks
		$("#ClinicalNoteCnfmDialog").show();
		showMez("ClinicalNoteCnfmDialog");
		var modifyNote = function(){
			closeConfirmDialog();
			closeMez();
			modifyClinicalNotes();
		};
		$("#ClinicalNoteCnfmDialog").configureConfirmDialog({
			callBackForTrue: modifyNote
		});
		var errorMsg = "Do you want to Modify this note?";
		showConfirmDialog(errorMsg);
	}else{ //if it is an authorized note capture remarks
		$("#EnterRemarksPop").show();
		$("#modifyLable").show();
		$("#ErrorLable").hide();
		showMez('EnterRemarksPop');
		
		clickStatus="modify";
	}
	
}

function closeNoteSelectorPop(){
	$("#DisplayErrorReasonPop").hide();
	$("#EnterRemarksPop").hide();
	closeMez();
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
	var TotalPageCount = AccNumber.length > 0 ? AccNumber.length : accArray.length;
	//parent.setOnLoadContentPaneHeight();
	//parent.setNotesFrameContentHeight();
	 $(document).on('swipeleft swiperight','#ContentPageID',function(event, data){
        event.stopImmediatePropagation();
		if(event.type == 'swipeleft')
			showNotesSwipeNew('LT',AccNumber);
		else
			showNotesSwipeNew('RT',AccNumber);
    });

	assignNoteContentScroll();
	var ContentHeading = '<div class="allergyHeaderPageTitle ipHeaderPageTitleTheme">Notes Content &nbsp &nbsp ('+CurPageNum+' of '+TotalPageCount+') </div>'
	$("#contentHeadingID").append(ContentHeading);	
	$('#forwardNoteSlidePointer').sliderGenericControl();
	diagComplaintMulSel = $("#practionerMulSelect").data("kendoMultiSelect");
	$("#specialityCmbDiagSet").kendoComboBox({
		filter:"startswith",
		dataTextField: "desc",
		dataValueField: "code",
		open:function(e){
			if( /Android/i.test(navigator.userAgent) ) {
			 $('.k-dropdown-wrap').find('input').focus();
			}			
		}, 
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
	diagSetCombo = $("#specialityCmbDiagSet").data("kendoComboBox");
	
	populatePractitionerMultiselectCombo();	
});


function oncallDelete(){

		deleteNotes();
		
	}
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
function fadeMyDiv() {
	//$("#NoteContentWrapper").hide();
	//$("#NoteContentWrapper").show('slow');
	//$("#NoteContentWrapper").slideDown("slow");
	
	$("#NoteContentWrapper").animate({opacity: '0.8'}, 100);
	$("#NoteContentWrapper").animate({opacity: '1.0'}, 100);
	
	//$("#NoteContentWrapper").removeClass('hidden');
	//$("#NoteContentWrapper").show('slide', {direction: 'right'}, 1000);
	}

function showForwardNotesPop() {
	$('#SendsHeaderButton').addClass("SaveErrorEnable");
	$("#forwardNotesPopWrapper").show();
	$("#SendsHeaderButton").off();
	$("#SendsHeaderButton").on("click",function(){
		confirmForward();
	});
	//$("#forwardNotesPop").show();

}
function showForwardNotesOnSignPop() {
	$('#SendsHeaderButton').addClass("SaveErrorEnable");
	$("#forwardNotesPopWrapper").show();
	$("#SendsHeaderButton").off();
	$("#SendsHeaderButton").on("click",function(){
		forwardOnSign();
	});
	//$("#forwardNotesPop").show();

}
	
function closeNotesPop() {
	$("#forwardNotesPopWrapper").hide();

	$("#practionerMulSelect").data("kendoMultiSelect").value([]);

	$("#specialityCmbDiagSet").data("kendoComboBox").value('');
	$('#txtSubject1').val('');
	$('#txtSubject2').val('');

}






function callForwardNote(){
	
	var selectedType = document.getElementById('hdnforwardNote').value;
	var accession_num = $("#accession_num").val();
	if(selectedType=="C"){
		var message = $('textarea#txtSubject1').val();
		var selectedPractitioner = document.getElementById("hdnDiagCompl").value;
		//"this$is$a$test";
		var practitionerCode =  selectedPractitioner;
        var change = ','
        practitionerCode = practitionerCode.split('$').join(change);
     $.ajax({
		  method: "GET",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
		  data: {operation_mode:"Forward",forward_mode:"P",forwarded_clinician_ids:practitionerCode,action_comment:message,accession_num: accession_num}
	})
	.done(function(response) {
       //openClinicalNotes();
		completeTransaction(response);
	});
		
	}else{
		var selectedSpe= $("#specialityCmbDiagSet").data("kendoComboBox").value();
		var message = $('textarea#txtSubject2').val();
		
		$.ajax({
		  method: "GET",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
		  data: {operation_mode:"Forward",forward_mode:"S",forwarded_clinician_id:selectedSpe,action_comment:message,accession_num: accession_num}
	})
	.done(function(response) {
	
       //openClinicalNotes();
		completeTransaction(response);

	});
		
	}
	
	
	
	//var vals= validationForForwardNotes(selectedType.value,selectedType.value,selectedSpe,message);
	
	
	
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

function deleteNotes() {
	$("#ClinicalNoteCnfmDialog").show();
	//$("#forwardNotesPop").show();
	
	var deleteNoteCareActivity = function(){
		closeConfirmDialog();
		deleteClinicalNote("Delete",'<%=accession_num %>','<%=amendment_type%>','');
		//$('#OrderFieldsIframe').contents().find('#AuthorizeIcon'+catalogCode).addClass("actionTickIcon");
		//$('#OrderFieldsIframe').contents().find('#authorized'+categoryCode).val("true");
	};
	$("#ClinicalNoteCnfmDialog").configureConfirmDialog({
		callBackForTrue: deleteNoteCareActivity
	});
	var errorMsg = "The selected note will be deleted. Kindly confirm";
	showConfirmDialog(errorMsg);

}
function closeConfirmDialog(){
	$("#ClinicalNoteCnfmDialog").hide();
	closeMez();
}
function deleteClinicalNote(Delete,accesNum,type,comms){
	/* to delete the clinical note code goes here */ 
	
	
	
	$.ajax({
		  method: "GET",
		  url: path+"/mobile/charts/notes/MRecClinicalNotesServlet",
		  data: {operation_mode:Delete,accession_num:accesNum,amendment_type:type,action_comment:comms}
	})
	.done(function(response) {
	
       //openClinicalNotes();
		completeTransaction(response);

	});
}

function closeMez(){
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").hide();
	$("#dvMez").off();
}


function showConfirmDialog(errorMsg){
	$("#ClinicalNoteCnfmDialogMsg").html(errorMsg);
	$("#ClinicalNoteCnfmDialog").show();
	showMez('ClinicalNoteCnfmDialog');
}

function showMez(popid){
	$('#dvMez').show();
	$("#dvMez").data("popid",popid);
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
}
/* function closeConfirmForwardDialog(){
	$("#ForwardConfirmDialog").hide();
	closeMez();	
	$('#forwardNotesPopWrapper').show();
}
	function closeConfirmForwardDialog(){
		$("#ForwardConfirmDialog").hide();
		closeMez();	
	} */

function closeMez(){
	var popid = $("#dvMez").data("popid");
	$("#"+popid).hide();
	$("#dvMez").hide();
	$("#dvMez").off();
}


function showForwardDialog(errorMsg){
	$("#ForwardConfirmDialogMsg").html(errorMsg);
	$("#ForwardConfirmDialog").show();
	showMez('ForwardConfirmDialog');
}

function showMez(popid){
	$('#dvMez').show();
	$("#dvMez").data("popid",popid);
	setTimeout(function() {
		$("#dvMez").on("click",closeMez);
	}, 500);
}
function confirmForward(){	
	
	//var errorMsg = "Confirm Forward?";
	//showForwardDialog(errorMsg);
	$("#forwardNotesPopWrapper").hide();
	$("#ClinicalNoteCnfmDialog").show();
	showMez("ClinicalNoteCnfmDialog");
	var forwardNote = function(){
		closeConfirmDialog();
		closeMez();
		callForwardNote();
	};
	$("#ClinicalNoteCnfmDialog").configureConfirmDialog({
		callBackForTrue: forwardNote
	});
	var errorMsg = "Confirm Forward?";
	showConfirmDialog(errorMsg);
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<style>
  .ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
  .white
  {
    
  }
.dvViewNotes
{
    height:44px;
    /*width : 100%;*/
 
    background :  -webkit-gradient(linear, left top, left bottom, from( #48cbcb ), to( #27707e )); /* Saf4+, Chrome */
    background : -webkit-linear-gradient( #48cbcb , #27707e ); /* Chrome 10+, Saf5.1+ */
    background :   -moz-linear-gradient( #48cbcb , #27707e ); /* FF3.6 */
    /*border : 1px solid #48d1d8;*/
     /*border : 1px solid #48d1d8; */ 
  
}
.viewNotesHeader {
	position:relative;
	height:8vhpx;

}
#forwardNotesPop{
	height:304px;
	width:740px;
	z-index:10001;
}
	#ClinicalNoteCnfmDialog {
  display: none;
  width: 340px;
  height: 280px;
  z-index: 500;
}
#ForwardConfirmDialog {
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
		.slide.in {
		 	-webkit-transform: translateX(0);
			-moz-transform: translateX(0);
			-webkit-animation-name: slideinfromright;
			-moz-animation-name: slideinfromright;
		}
			
		.slide.out {
			-webkit-transform: translateX(-100%);
			-moz-transform: translateX(-100%);
			-webkit-animation-name: slideouttoleft;
			-moz-animation-name: slideouttoleft;
		}

		@-webkit-keyframes slideinfromright {
			from { -webkit-transform: translateX(100%); }
			to { -webkit-transform: translateX(0); }
		}
		
		@-webkit-keyframes slideouttoleft {
			from { -webkit-transform: translateX(0); }
			to { -webkit-transform: translateX(-100%); }
		}
	
		@-moz-keyframes slideinfromright {
			from { -moz-transform: translateX(100%); }
			to { -moz-transform: translateX(0); }
		}
		
		@-moz-keyframes slideouttoleft {
			from { -moz-transform: translateX(0); }
			to { -moz-transform: translateX(-100%); }
		}
		
#DisplayErrorReasonPop{
	height:250px;
	width:700px;
	z-index:10001;
}
#EnterRemarksPop{
height:245px;
width:700px;
z-index:10001;
}

.Remarks{
   vertical-align: middle;
   display: inline-block;
   height: 200px;
   padding-right: 10px;
   font-family:Arial;
   font-size: 13px;
   font-weight: bold;
   color: #2c2c2c;
}

.InError{
display: inline-block;
 width: 4px;
 height:4px;
 background-color:#5b6365;
 border-radius:50%;
 margin-bottom: 2px;
 float:right;
}
		
.SaveErrorEnable{
  opacity: 0.4;
  pointer-events:none;
} 
.heightAlignment{
 height:30px
}
.notesSectionContainer{
	width: 100%;
	height: 99%; 
	background-color:white;
	display:table-row;
}
.notesSectionList{
	display:table-cell;
}
</style>
</head>

<body  style = "background-color : #ffffff">
<!-- delete note ui starts -->
	<div id="ClinicalNoteCnfmDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
		  <div class="Error_msg_box">
		    <div class="Error_msg">
		      <div class="Error_msg_Frame">
		        <div>
		          <div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30" /> </div>
		          <div class="Error_cont" id="ClinicalNoteCnfmDialogMsg">Authorization comfirmation window</div>
		        </div>
		      </div>
		    </div>
		  </div>
		  <div class="Error_msg_btn">
		    <div class="Error_btn_div_con" onclick="closeConfirmDialog()">Cancel </div>
		    <div class="Error_btn_div"> </div>
		    <div class="Error_btn_div_con" data-value="true">Ok</div><!-- Onclick event for OK button will be binded dynamically -->
		  </div>
		  <div class="top_shadow"> </div>
		</div> 
	</div>
<!-- delete note ui ends -->

<!-- forward note  Starts   TODO Roobini to clean up the below popup-->
   <div class="divParent" id="forwardNotesPopWrapper" data-role="none" style="position:absolute;padding: 0px; display:none;">
      <div data-role = "none" class = "blurPopup" data-popid="" style="z-index:10000; display:block;"></div>
      <div class="sfsIPTheme absoluteCenter" id="forwardNotesPop">
         <div class="SfsParent SfsParentTheme" data-role="none">
            <div class="SfsParentTable" data-role="none">
               <div class="SfsParentHeaderRow" data-role="none">
                  <div class="SfsParentHeaderCell" data-role="none">
                     <div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
                        <div class="SfsHeaderRow" data-role="none">
                           <div class="SfsHeaderButtonCol" data-role="none">
                              <div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick="closeNotesPop()">
                                 Cancel
                              </div>
                           </div>
                           <div class="SfsHeaderTextCol" data-role="none">
                              <div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
                                 Forward notes
                              </div>
                           </div>
                           <div class="SfsHeaderButtonCol" data-role="none">
                            
							  <div id="SendsHeaderButton" class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick="confirmForward()">
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

														<select id="practionerMulSelect" multiple="multiple" data-type = "ComboBox"> 
                                                            </select>
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
															 //  $('#SaveError').addClass("SaveErrorEnable");
$('#RemarksTextArea').on('keyup',function() {
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
											 
											   if($('#txtSubject2').val() != '' &&   selectedVal != '')
											   {		
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
												</tr>
											</tbody></table>
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
         </div>

  

	</div>
	</div>
	</div>
	</div>
	</div>
           </div>
         </div>

<div id="ContentPageID" style="display:table;height: 100%;width: 100%;-moz-box-sizing: border-box;-webkit-box-sizing: border-box;-ms-box-sizing: border-box;box-sizing: border-box;position: absolute;overflow: hidden;top: -1px;">
	<div id="allergyHeader" class="AllergyHeader" style="padding: 0px;height: 1%;display:table-row;" data-role="none">
		<div style="display:table-cell;">
	<table cellpadding="0" cellspacing="0" class="tbAllergyHeader" data-role="none">
		<tr class="normalTr">
			<td class="normalTd">
					<div class="viewNotesHeader  RecordAllergyHeaderTheme" style="border-bottom: 1px solid transparent;">
					<div class="RecordAllergyTable">
						<div class="normalRow">
							<div class="AllergyCell" id="contentHeadingID" style="width: 95%; text-align: left">
							
							</div>
							
							<div class="AllergyCell" style="width: 5%">
								<div class="RecordAllergyTable">
									<div class="normalRow">
										<div class="AllergyCell" style="width: auto; text-align: right">
											<div class="buttonContainer">
											<%
												if(arrFunctions.containsKey("FORWARD") && (eCA._ca_license_rights.getKey()).equals("CACLDC")) 
												{
											%>	
												<div class="NotesWidgetButtonTheme heightAlignment" style = "margin-right:10px" onclick="showForwardNotesPop()">
													<img src="${path}/eIPAD/images/Fwd_24x24.png"/>
												</div>
											<%
												}
												else{
											%>
												<div class="NotesWidgetButtonTheme cstFieldDull heightAlignment" style="margin-right:10px">
													<img src="${path}/eIPAD/images/Fwd_24x24.png"/>
												</div>
											<%
												}
											%>
											</div>
										</div>
									
									<div class="AllergyCell" style="width: auto; text-align: right">
											<div class="buttonContainer">
											<%
												if(arrFunctions.containsKey("ERROR"))
												{
											%>	
												<div class="NotesWidgetButtonTheme heightAlignment" style = "margin-right:10px" onclick="showMarkErrorPop()">
													<img src="${path}/eIPAD/images/Error_24x24.png"/>
												</div>
											<%
												}
												else{
											%>
												<div class="NotesWidgetButtonTheme cstFieldDull heightAlignment" style="margin-right:10px">
													<img src="${path}/eIPAD/images/Error_24x24.png"/>
												</div>
											<%
												}
											%>
										</div>
									</div>
									<div class="AllergyCell" style="width: auto; text-align: right">
											<div class="buttonContainer">
											<%
												if(arrFunctions.containsKey("SIGN"))
												{
											%>	
												<div class="NotesWidgetButtonTheme heightAlignment" style = "margin-right:10px" onclick="showSignOnModifyConfirmDialog()">
													<img src="${path}/eIPAD/images/sign25x25.png"/>
												</div>
											<%
												}
												else{ 
											%>
												<div class="NotesWidgetButtonTheme cstFieldDull heightAlignment" style="margin-right:10px">
													<img src="${path}/eIPAD/images/sign25x25.png"/>
												</div>
											<%
												}
											%>
											</div>
									</div>
										<div class="AllergyCell" style="width: auto; text-align: right">
											<div class="buttonContainer">
											<%
												if(arrFunctions.containsKey("DELETE"))
												{
											%>	
												<div class="NotesWidgetButtonTheme heightAlignment"  onclick="oncallDelete();" style ="margin-right:10px">
													<img src="${path}/eIPAD/images/Delete24x24.png"/>
												</div>
											<%
												}
												else{
											%>
												<div class="NotesWidgetButtonTheme cstFieldDull heightAlignment" style="margin-right:10px">
													<img src="${path}/eIPAD/images/Delete24x24.png"/>
												</div>
											<%
												}
											%>
											</div>
										</div>
										<div class="AllergyCell"
											style="width: auto; text-align: right">
											<div class="buttonContainer">
												<div class="WidgetButtonTheme heightAlignment" style = "margin-right:10px;" onclick="closeNotesContentFullView()">
													<img src="${path}/eIPAD/images/CS_Close16x16.png"/>
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
	</div>
	<div id="noteSectionContainer" class="notesSectionContainer">
		<div class="notesSectionList">
			<div style="display:table; width:100%;height:100%;">
				<div style="display:table-row;">
					<div style="display:table-cell;"class="cell cnRecNotesHeader">

			<div style="width: 100%; height: 100%" class="table">
				<div class="row">
					<div style="width: 60px; height: 100%; vertical-align: middle; text-align: center;padding-left:10px" class="cell">
					<%
						if(arrFunctions.containsKey("UPDATE") || arrFunctions.containsKey("MODIFY"))
						{
					%>
						<div class="CNButtonItemTheme"  id="NotePreviewCloseBtn" onclick="modifyNotes('<%=accession_num%>','<%=note_type%>')">
							<img src="${path}/eIPAD/images/BacktoEdit24x24.png">
						</div>
						  
						  
						
					<%
						}else{
					%>
						<div class="CNButtonItemTheme cstFieldDull"  id="NotePreviewCloseBtn" onclick="">
							<img src="${path}/eIPAD/images/BacktoEdit24x24.png">
						</div>	
					<%		
						}
					%>
					</div>
					
					<div style="vertical-align: middle;" class="cell">
						<div style="width: 100%; height: 100%" class="table">
							<div class="row">
								<div class="cnRecNotesHeaderTxt cell"><%=note_type_desc%></div>
							</div>
							<div class="row">
								<div class="cnPracName cell"><%=pract_name%></div>
								<%-- <div class="cnPracName cell" style="text-align:right;padding-right:10px"><%=event_status%></div>
							 --%>
							
							<%						
						     if(errorStatus != event_status)
						     {
					        %>	
								<div class="cnPracName cell" style="text-align:right;padding-right:10px"><%=event_status%></div>							  
				        	<%						
						    }else{
				        	%>						
							
                            			
													<div class="cnPracName cell" style="text-align:right;padding-right:10px;color:red;">
																											
														<div style="width: 20px;height:10px;background-color:#e4e4e4;float: right;margin-left: 5px;margin-top: 2px;" onclick="showErrorReasonPop('<%=accession_num%>','<%=facilityId%>');">
														
														<div class="InError" style="margin-left: 1px;margin-right: 2px;margin-top: 3px;"></div>
														<div class="InError" style="margin-left: 1px;margin-right: 1px;margin-top: 3px;"></div>
														<div class="InError" style="margin-left: 1px;margin-right: 1px;margin-top: 3px;"></div>
														
														</div>	
														<div style="font-weight:bold;padding-right: 5px;"><%=event_status%></div>	
							</div>		
								
														  
				        	<%						
						    }
				        	%>							
					 
							
							</div>
						</div>
					</div>
				</div>
			</div>
		
	</div>
</div>
				<div style="display:table-row;height:99%;">
					<div style="display:table-cell;background-color: #eeeeee;padding: 5px;position:relative;">
						<div style="display:table;width:100%;height:100%;background: #fff;">
							<div style="display:table-row;">
								<div style="display:table-cell;position:relative;-webkit-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);-moz-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);">
		<div id="NoteContentWrapper"  class = "ChartSummaryMainWrapper" style="position:absolute;padding: 0px; overflow: hidden;width:100%;height:100%" data-role="none">
			<div class="ChartSummaryMainScroller" style="position:relative;width: 100%; height: auto; overflow: auto;word-break: break-all;" data-role="none">	
				<%=notes_content%>	
			</div>
		</div>
	</div>

	<input type="hidden" id="amendment_type" name="amendment_type" id="amendment_type" value="<%=amendment_type %>"/>
	<input type="hidden" id="accession_num" name="accession_num" id="accession_num" value='<%=accession_num%>'>
	<input type="hidden" id="note_type" name="note_type" id="note_type" value='<%=note_type%>'>
	<input type="hidden" id="event_status_code" name="event_status_code" id="event_status_code" value='<%=event_status_code%>'>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

  

<!-- display reason container -->

  <div class="sfsIPTheme absoluteCenter" id="DisplayErrorReasonPop" style="display:none;">				
	<div class="SfsParent SfsParentTheme" data-role="none" style="background-color:white";>
					<div class="SfsParentTable" data-role="none">
						<div class="SfsParentHeaderRow" data-role="none">
							<div class="SfsParentHeaderCell" data-role="none">
								<div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
									<div class="SfsHeaderRow" data-role="none">
										<div class="SfsHeaderButtonCol" data-role="none">
											<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "closeNoteSelectorPop()">
											<%-- 	<%=csResBundle.getString("common.cancel") %> --%>Cancel
											</div>
										</div>
										<div class="SfsHeaderTextCol" data-role="none" style="padding-right:50px;">
											<div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
												Mark as error
											</div>
										</div>								
														
									</div>						
									
								</div>
							</div>
						</div>						
                            <div style="height:50px;background-color:#f3f3f3;font-size:14px;">
							 <div style="padding:5px 5px 5px 10px;color:black;font-weight: bold;">By <span id="clinicianName"></span></div>							
								<div  style="padding:5px 5px 3px 10px;">on <span id="markedErrDate"> </span></div>
					          
							</div>
							<div id="errorRemark" style="padding:10px;width:680px;height:120px;font-size:14px;"></div>                        
												
							
					</div>				
					
				</div>
			</div>
			
			
		<div data-role = "none" id = "dvMez" class = "blurPopup" data-popid="" style="z-index:10000"></div>	
			
		<!-- display reason container ends-->	
		
		
		<!-- enter remarks container -->
			
			
			<div class="sfsIPTheme absoluteCenter" id="EnterRemarksPop" style="display:none;background-color:white;">
				<div class="SfsParent SfsParentTheme" data-role="none" style="background-color:white";>
					<div class="SfsParentTable" data-role="none">
						<div class="SfsParentHeaderRow" data-role="none">
							<div class="SfsParentHeaderCell" data-role="none">
								<div class="SfsHeaderTable SfsHeaderTheme" data-role="none">
									<div class="SfsHeaderRow" data-role="none">
										<div class="SfsHeaderButtonCol" data-role="none">
											<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "closeNoteSelectorPop()">
											<%-- 	<%=csResBundle.getString("common.cancel") %> --%> Cancel
											</div>
										</div>
							
								<div class="SfsHeaderTextCol" data-role="none" id="ErrorLable">
											<div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
												Mark as error
											</div>
										</div>							  
				        	
										
										
									<div class="SfsHeaderTextCol" data-role="none" id="modifyLable">
											<div class="SfsHeaderTextTheme"  id="DiagSfsHeaderTxt" data-role="none">
												Modify Note
											</div>
										</div>	
										
										<div class="SfsHeaderButtonCol" data-role="none" id="SaveError">
											<div class="SfsHeaderButton SfsHeaderButtonTheme" data-role="none" onclick = "saveRemark('<%=amendment_type %>','<%=accession_num %>','MakeAsError')">
												<%-- <%=csResBundle.getString("common.cancel") %> --%> Save
											</div>
										</div>										
									</div>						
									
								</div>
							</div>
						</div>						
                           <!--  <div style="height:50px;background-color:#f3f3f3;"></div>  -->                                
                           <div style="float:right;">  
                           <span class="Remarks"> Remarks<sup style="color:red">*</sup></span>
                           <span> 
                           <textarea rows="8" cols="70" maxlength="200" id="RemarksTextArea" style="margin: 35px 5px 35px 0px;"></textarea> <!--  TODO Aravintha rename this field -->
                           </span>                               
                           </div>						
					</div>				
					
				</div>
			</div>
			
			
			<!-- enter remarks container ends -->
			
	<%-- <div id="ForwardConfirmDialog" class="absoluteCenter" style="z-index:10005"><!-- TODO -->
		<div class="Error_Window">
		  <div class="Error_msg_box">
		    <div class="Error_msg">
		      <div class="Error_msg_Frame">
		        <div>
		          <div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30" /> </div>
		          <div class="Error_cont" id="ForwardConfirmDialogMsg"></div>
		        </div>
		      </div>
		    </div>
		  </div>
		  <div class="Error_msg_btn">
		    <div class="Error_btn_div_con" onclick="closeConfirmForwardDialog()">Cancel </div>
		    <div class="Error_btn_div"> </div>
		    <div class="Error_btn_div_con" data-value="true" onclick="callForwardNote()">Confirm </div><!-- Onclick event for OK button will be binded dynamically -->
		  </div>
		  <div class="top_shadow"> </div>
		</div>
	</div> --%>
			

</body>

</html>


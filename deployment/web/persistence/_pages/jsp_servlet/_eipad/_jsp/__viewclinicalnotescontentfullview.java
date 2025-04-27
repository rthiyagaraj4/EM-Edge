package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __viewclinicalnotescontentfullview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/ViewClinicalNotesContentFullView.jsp", 1709293413081L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/GenericSlider.js\"></script>\n<script type=\"text/javascript\">\nvar clickStatus=\"\";\nfunction openClinicalNotes(){\n\twindow.location.replace(path+\"/mobile/charts/notes/OpenClinicalNoteServlet\");\n}\n\nfunction completeTransaction(data){\n\tvar transactionParams = \"transactionOccurred=true&transactionMessage=\"+data.transactionMessage+\"&transactionResult=\"+data.transactionResult;\n\tvar cspath = path + \"/mobile/charts/notes/OpenClinicalNoteServlet?\" + transactionParams;\n\twindow.location.replace(cspath);\n}\t\n\t\nfunction saveRemark(ademnType,accesNum,remark){\n\tif(clickStatus==\"error\"){\n\t\tvar action_comment= $(\"#RemarksTextArea\").val();\n\t\t$.ajax({\n\t\t\t  method: \"POST\",\n\t \t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t\t  data: {action_comment:action_comment,accession_num:accesNum,amendment_type:ademnType,operation_mode:remark}\n\t\t})\n\t\t.done(function(response) {\n\t\t\t$(\"#DisplayErrorReasonPop\").hide();\n\t\t\t$(\"#EnterRemarksPop\").hide();\n\t\t\tcloseMez();\n\t\t\tcompleteTransaction(response);\n\t\t});\n\t}else if(clickStatus==\"modify\"){\n\t\t//var accession_num = $(\'#accession_num\').val();\n\t\t//var note_type = $(\'#note_type\').val();\n\t\tmodifyClinicalNotes();\n\t}\n/* \telse if(clickStatus == \"SignOnModify\"){\n\t\tvar accession_num = $(\'#accession_num\').val();\n\t\tvar note_type = $(\'#note_type\').val();\n\t\tsignOnModifyClinicalNotes(accession_num,note_type);\n\t} */\n\t\n}\n\n\nvar noteContentScroll;\nfunction assignNoteContentScroll() {\n\t setTimeout(function () {\n\t\t noteContentScroll = new iScroll(\'NoteContentWrapper\', {\n\t\tuseTransform: true,\n\t\tzoom: false,\n\t\n\t\t});\n}, 1000); \n}\n\nfunction ErrorDetails()\n{\n\tvar accession_num = $(\'#accession_num\').val();\n\tvar errorData;\n\n\t$.getJSON(path+\"/mobile/charts/notes/ClinicalNotesJSONServlet?field=INERROR&accessionNumber=\"+accession_num+\"&operation_mode=ViewNoteStatus\", function(data){\n\t\tif(data!=null){\t\t\n\t\terrorData = data.code;\n\t\tvar res = errorData.split(\"/\");\n\t\tvar dateConvert=res[1]+\"/\"+res[0]+\"/\"+res[2];\n        var errDate = res[0];\n        var\terrMonth= res[1];    \n        var yearDate = res[2];\n        var monthNames = [\"January\", \"February\", \"March\", \"April\", \"May\", \"June\",\n                          \"July\", \"August\", \"September\", \"October\", \"November\", \"December\"];\n\n        var monthName = new Date(dateConvert);\n\t\tvar monthFullName = (monthNames[monthName.getMonth()]);\n\t\tvar finalErrDate = errDate+\" \"+monthFullName+\" \"+yearDate;\t\n\t\t\t\n\t\tvar markedErrDate = finalErrDate;\n\t\tvar clinicianName = data.detail;\t\n      $(\'#markedErrDate\').html(markedErrDate);\n\t  $(\'#clinicianName\').html(clinicianName);\n\t\t}\n\t\t });  \n}\n\nfunction showErrorReasonPop(acces_no,facilityId){\n\t$.getJSON(path+\"/mobile/charts/notes/ClinicalNotesJSONServlet?field=REMARK&facilityId=\"+facilityId+\"&accessionNumber=\"+acces_no, function(data){\n\t\t\n\t\tvar getMessage=data[0].map;\n\t\tvar remarkMess=getMessage.message;\n\t\t$(\'#errorRemark\').html(remarkMess);\n\t\t\t\n\t\t\tErrorDetails();\n\t\t });\n\t \n\t \n\t\n\t$(\"#DisplayErrorReasonPop\").show();\n\tshowMez(\'DisplayErrorReasonPop\');\n\t$(\'#RemarksTextArea\').val(\'\');\n}\n\nfunction showMarkErrorPop(){\n\t$(\'#SaveError\').addClass(\"SaveErrorEnable\");\n\t$(\"#EnterRemarksPop\").show();\n\tshowMez(\'EnterRemarksPop\');\n\t$(\'#RemarksTextArea\').val(\'\');\n\t$(\"#ErrorLable\").show();\n\t$(\"#modifyLable\").hide();\n\t\n\tclickStatus=\"error\";\n}\n\nfunction modifyClinicalNotes(){\n\tvar event_status_code = $(\"#event_status_code\").val();\n\tvar accession_num = $(\'#accession_num\').val();\n\tvar note_type = $(\'#note_type\').val();\n\tvar action_comment= $(\"#RemarksTextArea\").val();\n\t$(\"#DisplayErrorReasonPop\").hide();\n\t$(\"#EnterRemarksPop\").hide();\n\tcloseMez();\n\tvar amendment_type = $(\"#amendment_type\").val();\n\tvar operation_mode;\n\tif(event_status_code == \'1\')\n\t\toperation_mode = \'UpdateRecord\'\n\telse if(amendment_type ==\"A\" && event_status_code != \'1\')\n\t\toperation_mode\t=\t\"ModifyAddendum\";\n\telse\n\t\toperation_mode\t=\t\"ModifySection\";\n\twindow.parent.document.getElementById(\'ChartSummaryIframe\').src =\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/mobile/charts/notes/MRecClinicalNotesInit?accession_num=\'+accession_num+\'&note_type=\'+note_type+\'&operation_mode=\'+operation_mode+\'&amendment_type=\'+amendment_type+\'&action_comment=\'+action_comment+\'&event_status_code=\'+event_status_code;\n\twindow.parent.closeNotesContent();\n}\n/* function signOnModifyClinicalNotes(accession_num,note_type){\n\tvar action_comment= $(\"#RemarksTextArea\").val();\n\t$(\"#DisplayErrorReasonPop\").hide();\n\t$(\"#EnterRemarksPop\").hide();\n\tcloseMez();\n\tvar amendment_type = $(\"#amendment_type\").val();\n\tvar operation_mode\t=\t\"SignOnModify\";\n\t\n\t$.ajax({\n\t\t  method: \"GET\",\n\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,action_comment: action_comment}\n\t})\n\t.done(function(response) {\n\t\tcloseNotesContentFullView();\n\t\topenClinicalNotes();\n\t});\n\n\t//window.parent.closeNotesContent();\n} */\n\nfunction showSignOnModifyConfirmDialog(){ \n\t\n\t$(\"#ClinicalNoteCnfmDialog\").show();\n\tshowMez(\"ClinicalNoteCnfmDialog\");\n\tvar signOnModify = function(){\n\t\tcloseConfirmDialog();\n\t\tcloseMez();\n\t\tsignOnModifyClinicalNotes();\n\t};\n\t$(\"#ClinicalNoteCnfmDialog\").configureConfirmDialog({\n\t\tcallBackForTrue: signOnModify\n\t});\n\tvar errorMsg = \"Do you want to Sign this note?\";\n\tshowConfirmDialog(errorMsg);\n\t\n}\n\nfunction signOnModifyClinicalNotes(){\n\tvar accession_num = $(\"#accession_num\").val();\n\tvar amendment_type = $(\"#amendment_type\").val();\n\tvar note_type = $(\"#note_type\").val();\n\tvar operation_mode\t=\t\"SignOnModify\";\n\tvar action_comment= $(\"#RemarksTextArea\").val();\n\t$.ajax({\n\t  method: \"POST\",\n\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesValidation\",\n\t  data: { operation_mode: \"Sign\", note_type: note_type }\n\t})\n\t.done(function( data ) {\n\t\tvar valiResp = data;\n\t\tif(valiResp.validationResult == 0){\n\t\t\t\t$.ajax({\n\t\t\t\t\t  method: \"GET\",\n\t\t\t\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t\t\t\t  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,action_comment: action_comment,note_type: note_type}\n\t\t\t\t})\n\t\t\t\t.done(function(response) {\n\t\t\t\t\tcloseNotesContentFullView();\n\t\t\t\t\tcompleteTransaction(response);\n\t\t\t\t});\n\t\t}\n\t\telse{\n\t\t\tvar errorList = valiResp.errorList;\n\t\t\tif(errorList.length>0){\n\t\t\t\tfor(var i=0;i<errorList.length;i++){\n\t\t\t\t\tvar errorMessageId = valiResp.errorList[i].errorMessageId;\n\t\t\t\t\tif(errorMessageId == \'PRIVILEGE_ERROR\'){\n\t\t\t\t\t\tcloseConfirmDialog();\n\t\t\t\t\t\tshowForwardNotesOnSignPop();\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\n\t\t\n\t});\n\n}\nfunction forwardOnSign(){\n\tvar accession_num = $(\"#accession_num\").val();\n\tvar amendment_type = $(\"#amendment_type\").val();\n\tvar note_type = $(\"#note_type\").val();\n\tvar operation_mode\t=\t\"SignOnModify\";\n\tvar action_comment= $(\"#RemarksTextArea\").val();\n\tvar selectedType = document.getElementById(\'hdnforwardNote\').value;\n\tif(selectedType==\"C\"){\n\t\tvar message = $(\'textarea#txtSubject1\').val();\n\t\tvar selectedPractitioner = document.getElementById(\"hdnDiagCompl\").value;\n\t\tvar practitionerCode =  selectedPractitioner;\n        var change = \',\'\n        practitionerCode = practitionerCode.split(\'$\').join(change);\n\t\t$.ajax({\n\t\t\t  method: \"GET\",\n\t\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t\t  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,forward_mode:\"P\",forwarded_clinician_ids:practitionerCode,action_comment: message,note_type: note_type}\n\t\t})\n\t\t.done(function(response) {\n\t\t\tcloseNotesContentFullView();\n\t\t\tcompleteTransaction(response);\n\t\t});\n\t}else{\n\t\tvar selectedSpe= $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\").value();\n\t\tvar message = $(\'textarea#txtSubject2\').val();\n\t\t$.ajax({\n\t\t\t  method: \"GET\",\n\t\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t\t  data: {operation_mode: operation_mode,accession_num: accession_num,amendment_type: amendment_type,forward_mode:\"S\",forwarded_clinician_id:selectedSpe,action_comment: message,note_type: note_type}\n\t\t})\n\t\t.done(function(response) {\n\t\t\tcloseNotesContentFullView();\n\t\t\tcompleteTransaction(response);\n\t\t});\n\t}\n\t\n}\n\nfunction modifyNotes(acces_no,note_type){ //TODO Aravintha change this function name to modifyNotesCaptureRemarks\n\t$(\'#RemarksTextArea\').val(\'\');\n\t$(\'#SaveError\').addClass(\"SaveErrorEnable\");\n\tvar event_status_code = $(\"#event_status_code\").val();\n\tif(event_status_code != \'4\' && event_status_code != \'5\'){ //show confirm popup in case of non-authorized note, there is no need to capture remarks\n\t\t$(\"#ClinicalNoteCnfmDialog\").show();\n\t\tshowMez(\"ClinicalNoteCnfmDialog\");\n\t\tvar modifyNote = function(){\n\t\t\tcloseConfirmDialog();\n\t\t\tcloseMez();\n\t\t\tmodifyClinicalNotes();\n\t\t};\n\t\t$(\"#ClinicalNoteCnfmDialog\").configureConfirmDialog({\n\t\t\tcallBackForTrue: modifyNote\n\t\t});\n\t\tvar errorMsg = \"Do you want to Modify this note?\";\n\t\tshowConfirmDialog(errorMsg);\n\t}else{ //if it is an authorized note capture remarks\n\t\t$(\"#EnterRemarksPop\").show();\n\t\t$(\"#modifyLable\").show();\n\t\t$(\"#ErrorLable\").hide();\n\t\tshowMez(\'EnterRemarksPop\');\n\t\t\n\t\tclickStatus=\"modify\";\n\t}\n\t\n}\n\nfunction closeNoteSelectorPop(){\n\t$(\"#DisplayErrorReasonPop\").hide();\n\t$(\"#EnterRemarksPop\").hide();\n\tcloseMez();\n}\n\n\n//This small jQuery plugin is used to assign the event handler function for the OK button of the confirm dialog\n(function ( $ ) {\n    $.fn.configureConfirmDialog = function(options) {\n    \tvar defaultVal =  {\n    \t        callBackForTrue: function () { },\n    \t    };\n    \tvar obj = $.extend(defaultVal, options);\n    \t$(this).find(\"[data-value=\'true\']\").off();\n        $(this).find(\"[data-value=\'true\']\").on(\"click\",obj.callBackForTrue);\n        return this;\n    };\n \n}( jQuery ));\n\n\n$(document).ready(function () {\n\tvar TotalPageCount = AccNumber.length > 0 ? AccNumber.length : accArray.length;\n\t//parent.setOnLoadContentPaneHeight();\n\t//parent.setNotesFrameContentHeight();\n\t $(document).on(\'swipeleft swiperight\',\'#ContentPageID\',function(event, data){\n        event.stopImmediatePropagation();\n\t\tif(event.type == \'swipeleft\')\n\t\t\tshowNotesSwipeNew(\'LT\',AccNumber);\n\t\telse\n\t\t\tshowNotesSwipeNew(\'RT\',AccNumber);\n    });\n\n\tassignNoteContentScroll();\n\tvar ContentHeading = \'<div class=\"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Notes Content &nbsp &nbsp (\'+CurPageNum+\' of \'+TotalPageCount+\') </div>\'\n\t$(\"#contentHeadingID\").append(ContentHeading);\t\n\t$(\'#forwardNoteSlidePointer\').sliderGenericControl();\n\tdiagComplaintMulSel = $(\"#practionerMulSelect\").data(\"kendoMultiSelect\");\n\t$(\"#specialityCmbDiagSet\").kendoComboBox({\n\t\tfilter:\"startswith\",\n\t\tdataTextField: \"desc\",\n\t\tdataValueField: \"code\",\n\t\topen:function(e){\n\t\t\tif( /Android/i.test(navigator.userAgent) ) {\n\t\t\t $(\'.k-dropdown-wrap\').find(\'input\').focus();\n\t\t\t}\t\t\t\n\t\t}, \n\t\t//dataSource: diagSetValuesJson.diagnosisSetList,\n\t\t//value:diagSetValuesJson.defaultValue,\n\t\tchange: function(e) {\n\t\t\tvar selectedVal =  $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\").value();\n\t\t\t  if($(\'#txtSubject2\').val() != \'\' &&  selectedVal != \'\')\n\t\t\t{\t\t\n            $(\'#SendsHeaderButton\').removeClass(\"SaveErrorEnable\");\n           }else{\n            $(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n    }\n\t\t\t//showHideAllOtherFields();\n\t\t}\n\t});\n\tdiagSetCombo = $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\");\n\t\n\tpopulatePractitionerMultiselectCombo();\t\n});\n\n\nfunction oncallDelete(){\n\n\t\tdeleteNotes();\n\t\t\n\t}\nfunction populatePractitionerMultiselectCombo(){\n\t\n\tvar note_type=$(\'#note_type\').val();\n\t\n\t\n\n    $.getJSON( path+\"/mobile/charts/notes/ClinicalNotesJSONServlet?field=FORWARD_PRAC&note_type=\"+note_type, function(data){\n\t\tPractitionerMultiselectCombo = $(\"#practionerMulSelect\").data(\"kendoMultiSelect\");\n\t\tPractitionerDataSrc = data;\n\t\tPractitionerMultiselectCombo.setDataSource(PractitionerDataSrc.fieldList);\n\t });\n\t $.getJSON( path+\"/mobile/charts/notes/ClinicalNotesJSONServlet?field=FORWARD_SPEC\", function(data){\n\t\tspecialityCombo = $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\");\n\t\tspecialityDataSrc = data;\n\t\tspecialityCombo.setDataSource(specialityDataSrc.fieldList);\n\t }); \n}\nfunction fadeMyDiv() {\n\t//$(\"#NoteContentWrapper\").hide();\n\t//$(\"#NoteContentWrapper\").show(\'slow\');\n\t//$(\"#NoteContentWrapper\").slideDown(\"slow\");\n\t\n\t$(\"#NoteContentWrapper\").animate({opacity: \'0.8\'}, 100);\n\t$(\"#NoteContentWrapper\").animate({opacity: \'1.0\'}, 100);\n\t\n\t//$(\"#NoteContentWrapper\").removeClass(\'hidden\');\n\t//$(\"#NoteContentWrapper\").show(\'slide\', {direction: \'right\'}, 1000);\n\t}\n\nfunction showForwardNotesPop() {\n\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t$(\"#forwardNotesPopWrapper\").show();\n\t$(\"#SendsHeaderButton\").off();\n\t$(\"#SendsHeaderButton\").on(\"click\",function(){\n\t\tconfirmForward();\n\t});\n\t//$(\"#forwardNotesPop\").show();\n\n}\nfunction showForwardNotesOnSignPop() {\n\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t$(\"#forwardNotesPopWrapper\").show();\n\t$(\"#SendsHeaderButton\").off();\n\t$(\"#SendsHeaderButton\").on(\"click\",function(){\n\t\tforwardOnSign();\n\t});\n\t//$(\"#forwardNotesPop\").show();\n\n}\n\t\nfunction closeNotesPop() {\n\t$(\"#forwardNotesPopWrapper\").hide();\n\n\t$(\"#practionerMulSelect\").data(\"kendoMultiSelect\").value([]);\n\n\t$(\"#specialityCmbDiagSet\").data(\"kendoComboBox\").value(\'\');\n\t$(\'#txtSubject1\').val(\'\');\n\t$(\'#txtSubject2\').val(\'\');\n\n}\n\n\n\n\n\n\nfunction callForwardNote(){\n\t\n\tvar selectedType = document.getElementById(\'hdnforwardNote\').value;\n\tvar accession_num = $(\"#accession_num\").val();\n\tif(selectedType==\"C\"){\n\t\tvar message = $(\'textarea#txtSubject1\').val();\n\t\tvar selectedPractitioner = document.getElementById(\"hdnDiagCompl\").value;\n\t\t//\"this$is$a$test\";\n\t\tvar practitionerCode =  selectedPractitioner;\n        var change = \',\'\n        practitionerCode = practitionerCode.split(\'$\').join(change);\n     $.ajax({\n\t\t  method: \"GET\",\n\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t  data: {operation_mode:\"Forward\",forward_mode:\"P\",forwarded_clinician_ids:practitionerCode,action_comment:message,accession_num: accession_num}\n\t})\n\t.done(function(response) {\n       //openClinicalNotes();\n\t\tcompleteTransaction(response);\n\t});\n\t\t\n\t}else{\n\t\tvar selectedSpe= $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\").value();\n\t\tvar message = $(\'textarea#txtSubject2\').val();\n\t\t\n\t\t$.ajax({\n\t\t  method: \"GET\",\n\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t  data: {operation_mode:\"Forward\",forward_mode:\"S\",forwarded_clinician_id:selectedSpe,action_comment:message,accession_num: accession_num}\n\t})\n\t.done(function(response) {\n\t\n       //openClinicalNotes();\n\t\tcompleteTransaction(response);\n\n\t});\n\t\t\n\t}\n\t\n\t\n\t\n\t//var vals= validationForForwardNotes(selectedType.value,selectedType.value,selectedSpe,message);\n\t\n\t\n\t\n}\n\n\nfunction validationForForwardNotes(selectedType,selectedPractitioner,selectedSpe,message){\n\t\n\t\n\tif(selectedPractitioner==\"O\"){\n\t\t\n\t\tif( selectedSpe==\"\" ){\n\t\t\t\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\t\n\t}else{\n\t\t\n\t\tif(selectedPractitioner==\"\"){\n\t\t\t\n\t\t\t\treturn false;\n\t\t}\n\t\t\n\t}\n\t\n\tif(message==\"\" ){\n\t\t\n\t\treturn false;\n\t}\n\t\n\treturn true;\n}\n$(\'#hdnforwardNote\').change(function(){ \n\t\t\n\tif($(\'#hdnforwardNote\').val()==\"O\"){\n\t\t$(\"#specialitySideFieldWrap\").show();\n\t\t$(\"#practitionerSideFieldWrap\").hide();\n\t\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t\t$(\'#txtSubject2\').val(\'\');\t\n      \n\t   $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\").value(\'\');\n\t\t$(\"#specialitySubjectFieldWrap\").show();\n\t\t$(\"#practitionerSubjectFieldWrap\").hide();\n\t}\n\telse{\n\t\t$(\"#specialitySideFieldWrap\").hide();\n\t\t$(\"#practitionerSideFieldWrap\").show();\n\t\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t\t$(\'#txtSubject1\').val(\'\');\n\t       \n\t\t\t$(\"#practionerMulSelect\").data(\"kendoMultiSelect\").value([]);\n\t\t\n\t\t$(\"#specialitySubjectFieldWrap\").hide();\n\t\t$(\"#practitionerSubjectFieldWrap\").show();\n\t}\n});\n\nfunction deleteNotes() {\n\t$(\"#ClinicalNoteCnfmDialog\").show();\n\t//$(\"#forwardNotesPop\").show();\n\t\n\tvar deleteNoteCareActivity = function(){\n\t\tcloseConfirmDialog();\n\t\tdeleteClinicalNote(\"Delete\",\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\',\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'\');\n\t\t//$(\'#OrderFieldsIframe\').contents().find(\'#AuthorizeIcon\'+catalogCode).addClass(\"actionTickIcon\");\n\t\t//$(\'#OrderFieldsIframe\').contents().find(\'#authorized\'+categoryCode).val(\"true\");\n\t};\n\t$(\"#ClinicalNoteCnfmDialog\").configureConfirmDialog({\n\t\tcallBackForTrue: deleteNoteCareActivity\n\t});\n\tvar errorMsg = \"The selected note will be deleted. Kindly confirm\";\n\tshowConfirmDialog(errorMsg);\n\n}\nfunction closeConfirmDialog(){\n\t$(\"#ClinicalNoteCnfmDialog\").hide();\n\tcloseMez();\n}\nfunction deleteClinicalNote(Delete,accesNum,type,comms){\n\t/* to delete the clinical note code goes here */ \n\t\n\t\n\t\n\t$.ajax({\n\t\t  method: \"GET\",\n\t\t  url: path+\"/mobile/charts/notes/MRecClinicalNotesServlet\",\n\t\t  data: {operation_mode:Delete,accession_num:accesNum,amendment_type:type,action_comment:comms}\n\t})\n\t.done(function(response) {\n\t\n       //openClinicalNotes();\n\t\tcompleteTransaction(response);\n\n\t});\n}\n\nfunction closeMez(){\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").off();\n}\n\n\nfunction showConfirmDialog(errorMsg){\n\t$(\"#ClinicalNoteCnfmDialogMsg\").html(errorMsg);\n\t$(\"#ClinicalNoteCnfmDialog\").show();\n\tshowMez(\'ClinicalNoteCnfmDialog\');\n}\n\nfunction showMez(popid){\n\t$(\'#dvMez\').show();\n\t$(\"#dvMez\").data(\"popid\",popid);\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n}\n/* function closeConfirmForwardDialog(){\n\t$(\"#ForwardConfirmDialog\").hide();\n\tcloseMez();\t\n\t$(\'#forwardNotesPopWrapper\').show();\n}\n\tfunction closeConfirmForwardDialog(){\n\t\t$(\"#ForwardConfirmDialog\").hide();\n\t\tcloseMez();\t\n\t} */\n\nfunction closeMez(){\n\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t$(\"#\"+popid).hide();\n\t$(\"#dvMez\").hide();\n\t$(\"#dvMez\").off();\n}\n\n\nfunction showForwardDialog(errorMsg){\n\t$(\"#ForwardConfirmDialogMsg\").html(errorMsg);\n\t$(\"#ForwardConfirmDialog\").show();\n\tshowMez(\'ForwardConfirmDialog\');\n}\n\nfunction showMez(popid){\n\t$(\'#dvMez\').show();\n\t$(\"#dvMez\").data(\"popid\",popid);\n\tsetTimeout(function() {\n\t\t$(\"#dvMez\").on(\"click\",closeMez);\n\t}, 500);\n}\nfunction confirmForward(){\t\n\t\n\t//var errorMsg = \"Confirm Forward?\";\n\t//showForwardDialog(errorMsg);\n\t$(\"#forwardNotesPopWrapper\").hide();\n\t$(\"#ClinicalNoteCnfmDialog\").show();\n\tshowMez(\"ClinicalNoteCnfmDialog\");\n\tvar forwardNote = function(){\n\t\tcloseConfirmDialog();\n\t\tcloseMez();\n\t\tcallForwardNote();\n\t};\n\t$(\"#ClinicalNoteCnfmDialog\").configureConfirmDialog({\n\t\tcallBackForTrue: forwardNote\n\t});\n\tvar errorMsg = \"Confirm Forward?\";\n\tshowConfirmDialog(errorMsg);\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n<style>\n  .ADDRESS\t{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n  .white\n  {\n    \n  }\n.dvViewNotes\n{\n    height:44px;\n    /*width : 100%;*/\n \n    background :  -webkit-gradient(linear, left top, left bottom, from( #48cbcb ), to( #27707e )); /* Saf4+, Chrome */\n    background : -webkit-linear-gradient( #48cbcb , #27707e ); /* Chrome 10+, Saf5.1+ */\n    background :   -moz-linear-gradient( #48cbcb , #27707e ); /* FF3.6 */\n    /*border : 1px solid #48d1d8;*/\n     /*border : 1px solid #48d1d8; */ \n  \n}\n.viewNotesHeader {\n\tposition:relative;\n\theight:8vhpx;\n\n}\n#forwardNotesPop{\n\theight:304px;\n\twidth:740px;\n\tz-index:10001;\n}\n\t#ClinicalNoteCnfmDialog {\n  display: none;\n  width: 340px;\n  height: 280px;\n  z-index: 500;\n}\n#ForwardConfirmDialog {\n  display: none;\n  width: 340px;\n  height: 280px;\n  z-index: 500;\n}\n\n.Error_Window {\n\twidth: 325;\n\theight: 200px;\n\tborder: 2px solid #ffffff;\n\tbackground: #074860;\n\tmargin: 10px;\n\tmin-height: 200px;\n\tmax-width: 325px;\n\tbox-sizing: border-box;\n\t-moz-box-sizing: border-box;\n\t-webkit-box-sizing: border-box;\n\t-webkit-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\t-moz-box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\tbox-shadow: 0px 0px 15px 2px rgba(0,0,0,0.75);\n\tmargin: 10px;\n\tborder-radius: 10px;\n\tbox-sizing: border-box;\n\t-moz-box-sizing: border-box;\n\t-webkit-box-sizing: border-box;\n\toverflow: hidden\n}\n\t.Error_msg_box {\n\twidth: 100%;\n\theight: 150px;\n\tmax-height: 150px;\n\tmax-width: 100%;\n\tborder-bottom: 1px solid #000000;\n}\n\t\n\t.Error_msg {\n\theight: 150px;\n\twidth: 100%;\n\toverflow: auto;\n\tz-index: 999999;\n\tposition: relative;\n\tdisplay: table;\n}\n\t.Error_msg_Frame {\n\tdisplay: table-cell;\n\tvertical-align: middle\n}\n\t.Error_icon\n{\n\twidth:60px;\n\theight:100%;\n\tfloat:left;\n\ttext-align:right;\n\t\n}\n.Error_cont\n{\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tcolor:#ffffff;\n\ttext-align:center;\n\tpadding-top: 10px;\n\tpadding-left:10px;\n}\n.Error_msg_btn {\n\twidth: 100%;\n\theight: 49px;\n\tbackground: #2ea3c0; /* Old browsers */\n\tbackground: -moz-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* FF3.6+ */\n\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #2ea3c0), color-stop(50%, #2195b0), color-stop(51%, #0c7f9a), color-stop(100%, #0c7d9a)); /* Chrome,Safari4+ */\n\tbackground: -webkit-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* Opera 11.10+ */\n\tbackground: -ms-linear-gradient(top, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* IE10+ */\n\tbackground: linear-gradient(to bottom, #2ea3c0 0%, #2195b0 50%, #0c7f9a 51%, #0c7d9a 100%); /* W3C */\nfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#2ea3c0\', endColorstr=\'#0c7d9a\', GradientType=0 ); /* IE6-9 */\ndisplay:table;\n}\n.Error_btn_div_con\n{\n\twidth:159px;\n\theight:100%;\n\tfont-family:Arial, Helvetica, sans-serif;\n\tfont-size:12px;\n\tfont-weight:bold;\n\tcolor:#ffffff;\n\ttext-align:center;\t\n\tdisplay: table-cell;\n\tvertical-align: middle;\n\tcursor:pointer;\n\t\n}\n.Error_btn_div\n{\n\twidth:0px;\n\theight:100%;\n\tborder-left:1px solid #0bb5dd;\n\tborder-right:1px solid #023542;\n\tfloat: left;\n}\n\t.top_shadow {\n\twidth: 100%;\n\theight: 90px;\n\tbackground: #3b6f81; /* Old browsers */\n\tbackground: -moz-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* FF3.6+ */\n\tbackground: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #3b6f81), color-stop(64%, #074860)); /* Chrome,Safari4+ */\n\tbackground: -webkit-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Chrome10+,Safari5.1+ */\n\tbackground: -o-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* Opera 12+ */\n\tbackground: -ms-radial-gradient(center, ellipse cover, #3b6f81 0%, #074860 64%); /* IE10+ */\n\tbackground: radial-gradient(ellipse at center, #3b6f81 0%, #074860 64%); /* W3C */\nfilter: progid:DXImageTransform.Microsoft.gradient( startColorstr=\'#3b6f81\', endColorstr=\'#074860\', GradientType=1 ); /* IE6-9 fallback on horizontal gradient */\n\tmargin-top: -40px;\n\tmargin-top: -240px;\n\tz-index: -999;\n}\n\t\t.slide.in {\n\t\t \t-webkit-transform: translateX(0);\n\t\t\t-moz-transform: translateX(0);\n\t\t\t-webkit-animation-name: slideinfromright;\n\t\t\t-moz-animation-name: slideinfromright;\n\t\t}\n\t\t\t\n\t\t.slide.out {\n\t\t\t-webkit-transform: translateX(-100%);\n\t\t\t-moz-transform: translateX(-100%);\n\t\t\t-webkit-animation-name: slideouttoleft;\n\t\t\t-moz-animation-name: slideouttoleft;\n\t\t}\n\n\t\t@-webkit-keyframes slideinfromright {\n\t\t\tfrom { -webkit-transform: translateX(100%); }\n\t\t\tto { -webkit-transform: translateX(0); }\n\t\t}\n\t\t\n\t\t@-webkit-keyframes slideouttoleft {\n\t\t\tfrom { -webkit-transform: translateX(0); }\n\t\t\tto { -webkit-transform: translateX(-100%); }\n\t\t}\n\t\n\t\t@-moz-keyframes slideinfromright {\n\t\t\tfrom { -moz-transform: translateX(100%); }\n\t\t\tto { -moz-transform: translateX(0); }\n\t\t}\n\t\t\n\t\t@-moz-keyframes slideouttoleft {\n\t\t\tfrom { -moz-transform: translateX(0); }\n\t\t\tto { -moz-transform: translateX(-100%); }\n\t\t}\n\t\t\n#DisplayErrorReasonPop{\n\theight:250px;\n\twidth:700px;\n\tz-index:10001;\n}\n#EnterRemarksPop{\nheight:245px;\nwidth:700px;\nz-index:10001;\n}\n\n.Remarks{\n   vertical-align: middle;\n   display: inline-block;\n   height: 200px;\n   padding-right: 10px;\n   font-family:Arial;\n   font-size: 13px;\n   font-weight: bold;\n   color: #2c2c2c;\n}\n\n.InError{\ndisplay: inline-block;\n width: 4px;\n height:4px;\n background-color:#5b6365;\n border-radius:50%;\n margin-bottom: 2px;\n float:right;\n}\n\t\t\n.SaveErrorEnable{\n  opacity: 0.4;\n  pointer-events:none;\n} \n.heightAlignment{\n height:30px\n}\n.notesSectionContainer{\n\twidth: 100%;\n\theight: 99%; \n\tbackground-color:white;\n\tdisplay:table-row;\n}\n.notesSectionList{\n\tdisplay:table-cell;\n}\n</style>\n</head>\n\n<body  style = \"background-color : #ffffff\">\n<!-- delete note ui starts -->\n\t<div id=\"ClinicalNoteCnfmDialog\" class=\"absoluteCenter\" style=\"z-index:10005\"><!-- TODO -->\n\t\t<div class=\"Error_Window\">\n\t\t  <div class=\"Error_msg_box\">\n\t\t    <div class=\"Error_msg\">\n\t\t      <div class=\"Error_msg_Frame\">\n\t\t        <div>\n\t\t          <div class=\"Error_icon\"><img src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/OrderPopConfirm.png\" width=\"30\" height=\"30\" /> </div>\n\t\t          <div class=\"Error_cont\" id=\"ClinicalNoteCnfmDialogMsg\">Authorization comfirmation window</div>\n\t\t        </div>\n\t\t      </div>\n\t\t    </div>\n\t\t  </div>\n\t\t  <div class=\"Error_msg_btn\">\n\t\t    <div class=\"Error_btn_div_con\" onclick=\"closeConfirmDialog()\">Cancel </div>\n\t\t    <div class=\"Error_btn_div\"> </div>\n\t\t    <div class=\"Error_btn_div_con\" data-value=\"true\">Ok</div><!-- Onclick event for OK button will be binded dynamically -->\n\t\t  </div>\n\t\t  <div class=\"top_shadow\"> </div>\n\t\t</div> \n\t</div>\n<!-- delete note ui ends -->\n\n<!-- forward note  Starts   TODO Roobini to clean up the below popup-->\n   <div class=\"divParent\" id=\"forwardNotesPopWrapper\" data-role=\"none\" style=\"position:absolute;padding: 0px; display:none;\">\n      <div data-role = \"none\" class = \"blurPopup\" data-popid=\"\" style=\"z-index:10000; display:block;\"></div>\n      <div class=\"sfsIPTheme absoluteCenter\" id=\"forwardNotesPop\">\n         <div class=\"SfsParent SfsParentTheme\" data-role=\"none\">\n            <div class=\"SfsParentTable\" data-role=\"none\">\n               <div class=\"SfsParentHeaderRow\" data-role=\"none\">\n                  <div class=\"SfsParentHeaderCell\" data-role=\"none\">\n                     <div class=\"SfsHeaderTable SfsHeaderTheme\" data-role=\"none\">\n                        <div class=\"SfsHeaderRow\" data-role=\"none\">\n                           <div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n                              <div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick=\"closeNotesPop()\">\n                                 Cancel\n                              </div>\n                           </div>\n                           <div class=\"SfsHeaderTextCol\" data-role=\"none\">\n                              <div class=\"SfsHeaderTextTheme\"  id=\"DiagSfsHeaderTxt\" data-role=\"none\">\n                                 Forward notes\n                              </div>\n                           </div>\n                           <div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n                            \n\t\t\t\t\t\t\t  <div id=\"SendsHeaderButton\" class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick=\"confirmForward()\">\n                                 Send\n                              </div>\n                           </div>\n                        </div>\n                     </div>\n                  </div>\n               </div>\n             \n     <div class=\"SfsParentBodyRow\" style=\"background-color: #196986;\">\n\t\t\t<div class=\"divAllergyContent divAllergyContentTheme\" style=\"padding: 0px; border-radius: 3px;\">\n\t\t\t\t<div style=\"width: 100%; height: auto;\">\n\t\t\t\t\t\t\t<div style=\"width: 100%; height: 100%;\" data-role=\"none\">\n\t\t\t\t\t<div data-role=\"none\" style=\"width: 100%; height: auto\">\n\t\t\t\t\t\t<!-- first row -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\" border=\"0\">\n\t\t\t\t\t\t\t\t<tbody><tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\">Forward to</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%;margin-left: 10px;\">\n                                           <div style=\"display:table-row\">\n                                              <div style=\"display:table-cell;vertical-align:middle;text-align:right;padding-right:5px;width: 70px;\">\n                                                 <div class=\"dvSliderLabel\" data-labelfor=\"forwardNoteSlidePointer-1\" data-labelval=\"1\" >Practitioner</div>\n                                              </div>\n                                              <div style=\"display:table-cell;vertical-align:middle;text-align:center;width:50px\">\n                                                 <div class = \"sliderSmallParent\" data-role = \"none\">\n                                                    <div  class = \"sliderSmallScale sfsScaleTheme\" id=\"forwardNoteSlider\"  data-role = \"none\" >\n                                                       <div class=\"sliderSfsIns sliderSfsInsTheme\">\n                                                          <div data-role = \"none\" class = \"sliderSmallPointer sfsCritRoundTheme\" id = \"forwardNoteSlidePointer\"\n                                                             data-parent = \"forwardNoteSlider\" data-numpoints=\"2\" data-drag=\"N\" \n                                                             data-valuefield=\"hdnforwardNote\" data-value1=\"C\" data-value2=\"O\" data-defaultvalue=\"C\" \n                                                             data-selstylelabel=\"slSelectedLabel\">\n                                                          </div>\n                                                          <input type=\"hidden\" id=\"hdnforwardNote\" name=\"hdnForwardNote\" id=\"hdnForwardNote\" value=\"\">\n                                                       </div>\n                                                    </div>\n                                                 </div>\n                                              </div>\n                                              <div style=\"display:table-cell;vertical-align:middle;text-align:left;padding-left:5px;width: 70px;\">\n                                                 <div data-labelfor=\"forwardNoteSlidePointer-2\" class=\"dvSliderLabel\" data-labelval=\"2\" >Speciality</div>\n                                              </div>\n\t\t\t\t\t\t\t\t\t\t\t  <div style=\"display:table-cell;vertical-align:middle;text-align:left;padding-left:5px;\">\n                                                 \n                                              </div>\n                                           </div>\n                                        </div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody></table>\n\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- first row ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\t\t\t\t\t\t<!-- Second Row Starts -->\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\" id=\"practitionerSideFieldWrap\" style=\"display:block;\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\" border=\"0\">\n\t\t\t\t\t\t\t\t<tbody><tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"cmbEventType_Label\">Practitioner <sup style=\"color: red\">*</sup>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEventThemepractitioner\" style=\"position: relative;width: 85%;margin-left: 10px;\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tbody><tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class = \"cstFieldContainer1\" style=\"width: 100%; height: 100%\" valign=\"middle\" align=\"right\">\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<select id=\"practionerMulSelect\" multiple=\"multiple\" data-type = \"ComboBox\"> \n                                                            </select>\n                                                            <script>\n                                                               $(document).ready(function() {\n                                                                $(\"#practionerMulSelect\").kendoMultiSelect({\n                                                               \tdataTextField: \"desc\",\n                                                                               dataValueField: \"code\",\n                                                                               change: function(e) {\n                                                                                   var value = this.value();\n                                                                                   var complStr = \"\";\n                                                                                   for(var i=0; i<value.length;i++){\n                                                                                   \tcomplStr = complStr+value[i]+\"$\";\n                                                                                   }\n                                                                                   $(\"#hdnDiagCompl\").val(complStr);\n                                                                                   // Use the value of the widget\n\t\t\t\t\t\t\t\t\t\t\t\tif($(\'#txtSubject1\').val() != \'\' &&  $(\'.cstFieldContainer1 .k-multiselect-wrap ul\').find(\'li\').length >0 ) {\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\'#SendsHeaderButton\').removeClass(\"SaveErrorEnable\");\n\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t\t\t\t\t\t\t\t\t\t\t\t}\n                                                                               }\n                                                               });\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t //  $(\'#SaveError\').addClass(\"SaveErrorEnable\");\n$(\'#RemarksTextArea\').on(\'keyup\',function() {\n    if($(this).val() != \'\') {\n\t\t\n\t\t\n        $(\'#SaveError\').removeClass(\"SaveErrorEnable\");\n    }else{\n        $(\'#SaveError\').addClass(\"SaveErrorEnable\");\n    }\n});\n\n\t\t\t\t\t\t\t\t\t\t\t$(\'#txtSubject2\').on(\'keyup\',function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\tvar str = $(this).val();\n\t\t\t\t\t\t\t\t\t\t\t\tvar n = str.length;\t\n\t\t\t\t\t\t\t\t\t\t\t\tvar selectedVal =  $(\"#specialityCmbDiagSet\").data(\"kendoComboBox\").value();\n\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\t   if($(\'#txtSubject2\').val() != \'\' &&   selectedVal != \'\')\n\t\t\t\t\t\t\t\t\t\t\t   {\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\'#SendsHeaderButton\').removeClass(\"SaveErrorEnable\");\n\t\t\t\t\t\t\t\t\t\t\t\t   }else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t\t\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t\t});\t\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t\t$(\'#txtSubject1\').on(\'keyup\',function() {\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar str = $(this).val();\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar n = str.length;\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\tif($(this).val() != \'\' &&  $(\'.cstFieldContainer1 .k-multiselect-wrap ul\').find(\'li\').length >0 ) {\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\'#SendsHeaderButton\').removeClass(\"SaveErrorEnable\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\'#SendsHeaderButton\').addClass(\"SaveErrorEnable\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t}\n                                                               });\n                                                               });\n                                                            </script>\n                                                            <input type=\"hidden\" name=\"hdnDiagCompl\" id=\"hdnDiagCompl\" id=\"hdnDiagCompl\" value=\'\' /> \n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</tbody></table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody></table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"rowContainer\" data-role=\"none\" id=\"specialitySideFieldWrap\" style=\"display:none;\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer\" border=\"0\">\n\t\t\t\t\t\t\t\t<tbody><tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"cmbEventType_Label\">Speciality <sup style=\"color: red\">*</sup>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"divEvent divEventThemeSpeciality\">\n\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<tbody><tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"width: 100%; height: 100%\" valign=\"middle\" align=\"right\">\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <input id=\"specialityCmbDiagSet\" name=\"specialityCmbDiagSet\" id=\"specialityCmbDiagSet\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"true\" />\n                                                            <input type=\"hidden\" name=\"hdnDiagSet\" id=\"hdnDiagSet\" id=\"hdnDiagSet\" value=\'\' />\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</tbody></table>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody></table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<!-- second Row ends -->\n\t\t\t\t\t\t<div class=\"rowDivider\"></div>\n\n\t\t\t\t\t\t<!-- Fourth Row Starts -->\n\t\t\t\t\t\t<div class=\"rowContainer1\" data-role=\"none\" id=\"practitionerSubjectFieldWrap\" style=\"display:block;\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer1\" border=\"0\">\n\t\t\t\t\t\t\t\t<tbody><tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"txtCA_Label\">Subject <sup style=\"color: red\">* </sup></div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"position: relative; width: 100%; height: auto\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<textarea rows=\"6\" id=\"txtSubject1\" name=\"txtSubject\" style=\"margin-left: 10px;width: 428px;border: 1px solid #d6d6d6;-webkit-appearance: none;\" cols=\"30\" maxlength=\"200\"></textarea>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody></table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"rowContainer1\" data-role=\"none\" id=\"specialitySubjectFieldWrap\" style=\"display:none;\">\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbRowContainer1\" border=\"0\">\n\t\t\t\t\t\t\t\t<tbody><tr class=\"normalTr\">\n\t\t\t\t\t\t\t\t\t<td class=\"td30\" valign=\"middle\" align=\"right\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"allergyRowFonts\" id=\"txtCA_Label\">Subject <sup style=\"color: red\">*</sup></div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"td70\" valign=\"middle\" align=\"left\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"position: relative; width: 100%; height: auto\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<textarea rows=\"6\" id=\"txtSubject2\" name=\"txtSubject2\" style=\"margin-left: 10px;width: 428px;border: 1px solid #d6d6d6;-webkit-appearance: none;\" cols=\"30\"></textarea>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody></table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t</div>\n\t</div>\n\t</div>\n\t</div>\n\t</div>\n\t</div>\n           </div>\n         </div>\n\n  \n\n\t</div>\n\t</div>\n\t</div>\n\t</div>\n\t</div>\n           </div>\n         </div>\n\n<div id=\"ContentPageID\" style=\"display:table;height: 100%;width: 100%;-moz-box-sizing: border-box;-webkit-box-sizing: border-box;-ms-box-sizing: border-box;box-sizing: border-box;position: absolute;overflow: hidden;top: -1px;\">\n\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px;height: 1%;display:table-row;\" data-role=\"none\">\n\t\t<div style=\"display:table-cell;\">\n\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\" data-role=\"none\">\n\t\t<tr class=\"normalTr\">\n\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t<div class=\"viewNotesHeader  RecordAllergyHeaderTheme\" style=\"border-bottom: 1px solid transparent;\">\n\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t<div class=\"AllergyCell\" id=\"contentHeadingID\" style=\"width: 95%; text-align: left\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 5%\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"NotesWidgetButtonTheme heightAlignment\" style = \"margin-right:10px\" onclick=\"showForwardNotesPop()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/images/Fwd_24x24.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"NotesWidgetButtonTheme cstFieldDull heightAlignment\" style=\"margin-right:10px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"NotesWidgetButtonTheme heightAlignment\" style = \"margin-right:10px\" onclick=\"showMarkErrorPop()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/Error_24x24.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"NotesWidgetButtonTheme heightAlignment\" style = \"margin-right:10px\" onclick=\"showSignOnModifyConfirmDialog()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/sign25x25.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"NotesWidgetButtonTheme heightAlignment\"  onclick=\"oncallDelete();\" style =\"margin-right:10px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/eIPAD/images/Delete24x24.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme heightAlignment\" style = \"margin-right:10px;\" onclick=\"closeNotesContentFullView()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</div>\n\t</div>\n\t<div id=\"noteSectionContainer\" class=\"notesSectionContainer\">\n\t\t<div class=\"notesSectionList\">\n\t\t\t<div style=\"display:table; width:100%;height:100%;\">\n\t\t\t\t<div style=\"display:table-row;\">\n\t\t\t\t\t<div style=\"display:table-cell;\"class=\"cell cnRecNotesHeader\">\n\n\t\t\t<div style=\"width: 100%; height: 100%\" class=\"table\">\n\t\t\t\t<div class=\"row\">\n\t\t\t\t\t<div style=\"width: 60px; height: 100%; vertical-align: middle; text-align: center;padding-left:10px\" class=\"cell\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<div class=\"CNButtonItemTheme\"  id=\"NotePreviewCloseBtn\" onclick=\"modifyNotes(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\">\n\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eIPAD/images/BacktoEdit24x24.png\">\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t  \n\t\t\t\t\t\t  \n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<div class=\"CNButtonItemTheme cstFieldDull\"  id=\"NotePreviewCloseBtn\" onclick=\"\">\n\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/BacktoEdit24x24.png\">\n\t\t\t\t\t\t</div>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t<div style=\"vertical-align: middle;\" class=\"cell\">\n\t\t\t\t\t\t<div style=\"width: 100%; height: 100%\" class=\"table\">\n\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t<div class=\"cnRecNotesHeaderTxt cell\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t<div class=\"cnPracName cell\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t\t\t\t\t\t\t\t<div class=\"cnPracName cell\" style=\"text-align:right;padding-right:10px\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div>\t\t\t\t\t\t\t  \n\t\t\t\t        \t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n                            \t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cnPracName cell\" style=\"text-align:right;padding-right:10px;color:red;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width: 20px;height:10px;background-color:#e4e4e4;float: right;margin-left: 5px;margin-top: 2px;\" onclick=\"showErrorReasonPop(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\');\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"InError\" style=\"margin-left: 1px;margin-right: 2px;margin-top: 3px;\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"InError\" style=\"margin-left: 1px;margin-right: 1px;margin-top: 3px;\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"InError\" style=\"margin-left: 1px;margin-right: 1px;margin-top: 3px;\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"font-weight:bold;padding-right: 5px;\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</div>\t\n\t\t\t\t\t\t\t</div>\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t        \t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\t\t\t\t\t\n\t\t\t\t\t \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\n\t</div>\n</div>\n\t\t\t\t<div style=\"display:table-row;height:99%;\">\n\t\t\t\t\t<div style=\"display:table-cell;background-color: #eeeeee;padding: 5px;position:relative;\">\n\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%;background: #fff;\">\n\t\t\t\t\t\t\t<div style=\"display:table-row;\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-cell;position:relative;-webkit-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);-moz-box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);box-shadow: 0px 0px 3px 0px rgba(0,0,0,0.75);\">\n\t\t<div id=\"NoteContentWrapper\"  class = \"ChartSummaryMainWrapper\" style=\"position:absolute;padding: 0px; overflow: hidden;width:100%;height:100%\" data-role=\"none\">\n\t\t\t<div class=\"ChartSummaryMainScroller\" style=\"position:relative;width: 100%; height: auto; overflow: auto;word-break: break-all;\" data-role=\"none\">\t\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\n\t<input type=\"hidden\" id=\"amendment_type\" name=\"amendment_type\" id=\"amendment_type\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n\t<input type=\"hidden\" id=\"accession_num\" name=\"accession_num\" id=\"accession_num\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t<input type=\"hidden\" id=\"note_type\" name=\"note_type\" id=\"note_type\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t<input type=\"hidden\" id=\"event_status_code\" name=\"event_status_code\" id=\"event_status_code\" value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n</div>\n\n  \n\n<!-- display reason container -->\n\n  <div class=\"sfsIPTheme absoluteCenter\" id=\"DisplayErrorReasonPop\" style=\"display:none;\">\t\t\t\t\n\t<div class=\"SfsParent SfsParentTheme\" data-role=\"none\" style=\"background-color:white\";>\n\t\t\t\t\t<div class=\"SfsParentTable\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsParentHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsParentHeaderCell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTable SfsHeaderTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick = \"closeNoteSelectorPop()\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="Cancel\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextCol\" data-role=\"none\" style=\"padding-right:50px;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextTheme\"  id=\"DiagSfsHeaderTxt\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\tMark as error\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\t\t\t\t\t\t\n                            <div style=\"height:50px;background-color:#f3f3f3;font-size:14px;\">\n\t\t\t\t\t\t\t <div style=\"padding:5px 5px 5px 10px;color:black;font-weight: bold;\">By <span id=\"clinicianName\"></span></div>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div  style=\"padding:5px 5px 3px 10px;\">on <span id=\"markedErrDate\"> </span></div>\n\t\t\t\t\t          \n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div id=\"errorRemark\" style=\"padding:10px;width:680px;height:120px;font-size:14px;\"></div>                        \n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t</div>\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" data-popid=\"\" style=\"z-index:10000\"></div>\t\n\t\t\t\n\t\t<!-- display reason container ends-->\t\n\t\t\n\t\t\n\t\t<!-- enter remarks container -->\n\t\t\t\n\t\t\t\n\t\t\t<div class=\"sfsIPTheme absoluteCenter\" id=\"EnterRemarksPop\" style=\"display:none;background-color:white;\">\n\t\t\t\t<div class=\"SfsParent SfsParentTheme\" data-role=\"none\" style=\"background-color:white\";>\n\t\t\t\t\t<div class=\"SfsParentTable\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsParentHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsParentHeaderCell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTable SfsHeaderTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick = \"closeNoteSelectorPop()\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" Cancel\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextCol\" data-role=\"none\" id=\"ErrorLable\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextTheme\"  id=\"DiagSfsHeaderTxt\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\tMark as error\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t  \n\t\t\t\t        \t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextCol\" data-role=\"none\" id=\"modifyLable\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextTheme\"  id=\"DiagSfsHeaderTxt\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\tModify Note\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\" id=\"SaveError\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick = \"saveRemark(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'MakeAsError\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" Save\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\t\t\t\t\t\t\n                           <!--  <div style=\"height:50px;background-color:#f3f3f3;\"></div>  -->                                \n                           <div style=\"float:right;\">  \n                           <span class=\"Remarks\"> Remarks<sup style=\"color:red\">*</sup></span>\n                           <span> \n                           <textarea rows=\"8\" cols=\"70\" maxlength=\"200\" id=\"RemarksTextArea\" style=\"margin: 35px 5px 35px 0px;\"></textarea> <!--  TODO Aravintha rename this field -->\n                           </span>                               \n                           </div>\t\t\t\t\t\t\n\t\t\t\t\t</div>\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t\n\t\t\t\n\t\t\t<!-- enter remarks container ends -->\n\t\t\t\n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\n\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

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




            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(accession_num ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(amendment_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);

												if(arrFunctions.containsKey("FORWARD") && (eCA._ca_license_rights.getKey()).equals("CACLDC")) 
												{
											
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

												}
												else{
											
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

												}
											
            _bw.write(_wl_block12Bytes, _wl_block12);

												if(arrFunctions.containsKey("ERROR"))
												{
											
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);

												}
												else{
											
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);

												}
											
            _bw.write(_wl_block15Bytes, _wl_block15);

												if(arrFunctions.containsKey("SIGN"))
												{
											
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);

												}
												else{ 
											
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);

												}
											
            _bw.write(_wl_block18Bytes, _wl_block18);

												if(arrFunctions.containsKey("DELETE"))
												{
											
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);

												}
												else{
											
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);

												}
											
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);

						if(arrFunctions.containsKey("UPDATE") || arrFunctions.containsKey("MODIFY"))
						{
					
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);

						}else{
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
		
						}
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
						
						     if(errorStatus != event_status)
						     {
					        
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block33Bytes, _wl_block33);
						
						    }else{
				        	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(event_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
						
						    }
				        	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(amendment_type ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(event_status_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block43Bytes, _wl_block43);
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(amendment_type ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(accession_num ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            _bw.write(_wl_block46Bytes, _wl_block46);
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}

package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisDetailsHO;
import eIPAD.chartsummary.activeproblems.response.DiagnosisDetailsResponse;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSetHO;
import java.util.ResourceBundle;
import java.util.*;
import com.google.gson.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __modifydiagnosis extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ModifyDiagnosis.jsp", 1738426219612L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Record Vitals</title>\n\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/kendo.default.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/kendo.web.min.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/console.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/iPADNew.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADThemeA.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/js/iscroll.js\"></script>\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/js/GenericSlider.js\"></script>\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/ActiveProblemsTransaction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\ndocument.addEventListener(\'DOMContentLoaded\', assignMainScroll, false);\nvar diagTransactMainScroll;\nvar screenOrienttation = \"landscape\";\nvar path;\n\nfunction changeOrientation(orient, EMHFheight)\n{\n\tvar CSHFheight = $(\'#allergyHeader\').height();\n   \tHFheight = EMHFheight;\n   \tscreenOrienttation = orient;\n   \tvar content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;\n   \tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n   //\t$(\'#header1\').focus();\n   \tscrollRefresh();\n}\nfunction scrollRefresh()\n{\n \tif(diagTransactMainScroll != null)\n \t\tdiagTransactMainScroll.refresh();\n}\n\nfunction assignMainScroll() {\n\t setTimeout(function () {\n\t\t diagTransactMainScroll = new iScroll(\'divcnt\', {\n\t\tuseTransform: true,\n\t\tzoom: false,\n\t\tonBeforeScrollStart: function (e) {\n\t\tvar target = e.target;\n\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\te.preventDefault();\n\t\t}\n\t\t});\n}, 1000); \n}\n\n$(document).ready(function () {\n\tparent.setOnLoadContentPaneHeight();\n\tpath = document.getElementById(\"hdnPath\").value;\n\tmode = document.getElementById(\"hdnMode\").value;\n\t\n\t$(\"#cmbDiagSet\").kendoComboBox({\n\t\tdataTextField: \"desc\",\n\t\tdataValueField: \"code\"\n\t});\n\t//Initializing all the combo and multiselect objects\n\tdiagSetCombo = $(\"#cmbDiagSet\").data(\"kendoComboBox\");\n\tdiagClassCombo = $(\"#cmbDiagClass\").data(\"kendoComboBox\");\n\tdiagComplaintMulSel = $(\"#mulComplaints\").data(\"kendoMultiSelect\");\n\tdiagAccuracyCombo = $(\"#cmbAccuracy\").data(\"kendoComboBox\");\n\tdiagAnatomicalCombo = $(\"#cmbAnatSite\").data(\"kendoComboBox\");\n\tdiagApplSideCombo = $(\"#cmbApplSide\").data(\"kendoComboBox\");\n\t\n\t\n\tpopulateDiagSetCombo();\n\t//populating accuracy combo on load since accuracy values are not dependant on Diagnosis set value\n\tpopulateDiagAccuracyCombo();\n\tpopulateAnatomicalCombo();\n\t$(\'#hdnAnatomicalSite\').change(function(){ \n\t\tpopulateAnatomicalCombo();\t\n\t\tdiagAnatomicalCombo = $(\"#cmbAnatSite\").data(\"kendoComboBox\");\n\t\tdiagAnatomicalCombo.value(\'\');\n\t\tif($(\'#hdnAnatomicalSite\').val()==\"O\"){\n\t\t\t$(\"#ApplicableSideFieldWrap\").show();\n\t\t\tdiagApplSideCombo = $(\"#cmbApplSide\").data(\"kendoComboBox\");\n\t\t\tdiagApplSideCombo.value(\'\');\n\t\t\t$(\"#hdnDiagApplSide\").val(\"\");\n\t\t}\n\t\telse{\n\t\t\t$(\"#ApplicableSideFieldWrap\").hide();\n\t\t\t$(\"#hdnDiagApplSide\").val(\"\");\n\t\t}\n\t\tscrollRefresh();\n\t});\n\t\n\n\t//Setting patient DOB and current server date\n\tvar patDOB_str = $(\"#patientDOB\").val();\n\tpatDOB = StringToDate(patDOB_str);\n\tvar today_str = $(\"#today\").val();\n\ttoday = StringToDate(today_str);\n\t\n\t//Initializing DateTimePicker Objects\n\tonsetDTPicker = $(\"#OnsetDate\").data(\"kendoDateTimePicker\");\n\tasOnDPicker = $(\"#AsOnDate\").data(\"kendoDatePicker\");\n\t\n\t//to enable scrolling inside textarea\n\t$(\'textarea\').each(function(index){\n\t\t$(this).bind(\'touchmove\', function(event){\n\t    \tevent.stopPropagation();\n\t\t});\n\t});\n});\n\n\n</script>\n\n</head>\n<body>\n\t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<form name = \"frmModifyDiag\" id = \"frmModifyDiag\" style=\"width: 100%; height: 100%\" action=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/mobile/chartsummary/DiagnosisTransaction\">\n\t\t\t<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" data-popid=\"\"></div>\n\t\t\t<!-- popup container -->\n\t\t\t<div data-role=\"none\" class=\"diagSfs sfsIPTheme\" id=\"sfs\">\n\t\t\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style=\"display: block;\"\n\t\t\t\t\tscrolling=\"no\" class=\"popupIFrame\" src=\"\"></iframe>\n\t\t\t</div>\n\t\t\t<!-- popup container ends -->\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Modify Diagnosis</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" id=\"RecordDiagSubmitButton\" onclick=\"validateAndModifyDiagnosis()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/CS_Ok16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"cancelTransaction()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divAllergyContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\t<!-- container start -->\t\n\n\t\t \t\t\t\t\t<div class=\"cstFormHeader\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<span class=\"cstheaderTextTheme\" data-role=\"none\">Diagnosis Details</span>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t\t\t \t\n\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t \t<!-- Diagnosis Set field Starts -->\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"cmbDiagSet_Label\">Diagnosis Set<font style=\"color: red\">*</font> </div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<input id=\"cmbDiagSet\" name=\"cmbDiagSet\" id=\"cmbDiagSet\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"true\" />\n\t\t\t\t\t\t \t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDiagSet\" id=\"hdnDiagSet\" id=\"hdnDiagSet\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' />\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Diagnosis Set field Ends -->\t\t\t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<div id=\"RDAllOtherFields\"  style=\"display:none;\"> <!--  A div to enclose all fields other than Diagnosis Set, since all other fields won\'t be displayed if Diagnosis Set field is not selected -->\n\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Diagnosis Code field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"hdnDiagCode_Label\">Diagnosis Code<font style=\"color: red\">*</font> </div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<!-- Error Message Container for diagnosis code -->\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\">\n\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"hdnDiagCode_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"hdnDiagCode_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t \t\t\t\t\t\t<div style=\"display:table\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:99%;vertical-align:middle;padding-left:5px;\" id=\"DiagCodeField\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDiagCode\" id=\"hdnDiagCode\" id=\"hdnDiagCode\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' data-mandatory=\"true\" data-errmsg1=\"An active record already exists for this Diagnosis\"/>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:1%\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstSearchIconCell\"><div data-role = \"none\" class = \"cstSfsFieldSearchIcon\"></div></div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\t\n\t\t\t\t\t\t\t<!-- Diagnosis Code field Ends -->\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Diagnosis Desc field Starts -->\n\t\t\t\t\t\t\t<div class=\"cstFieldRowContainer2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"txtDiagDesc_Label\">Description<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme cstFieldDull\">\n\t\t\t\t\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"500\" data-role=\"none\" id=\"txtDiagDesc\" name=\"txtDiagDesc\" style=\"display: block\" data-mandatory=\"true\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" readonly>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</textarea>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t\t\t\t<!-- Diagnosis Desc field Ends -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div id=\"EncounterStageFieldWrap\">\n\t\t\t\t\t\t\t<!-- Encounter Stages Starts -->\n\t\t\t\t\t\t\t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Encounter Stages<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\" >\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"EncStageSlider\" class=\"scale scaleTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"EncStageSlidePointer\" data-count=\"I\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-parent = \"EncStageSlider\" data-numpoints=\"3\" data-drag=\"N\" data-dragdiv=\"EncStageScaleHover\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnEncStage\" data-value1=\"A\" data-value2=\"D\" data-value3=\"I\" data-defaultvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnEncStage\" name=\"hdnEncStage\" id=\"hdnEncStage\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\" id=\"EncStageScaleHover\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator1 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator2 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator3 scaleSeparatorTheme\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 0.5%;\" class = \"dvSliderLabel\" data-labelfor=\"EncStageSlidePointer-1\">Admission</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 45%\" class = \"dvSliderLabel\" data-labelfor=\"EncStageSlidePointer-2\">Discharge</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" data-labelfor=\"EncStageSlidePointer-3\">Intermediate</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;height:20px;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"EncStageSlidePointer-1\" data-labelval=\"1\" >Admission</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"EncStageSlidePointer-2\" data-labelval=\"2\" >Discharge</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"EncStageSlidePointer-3\" data-labelval=\"3\" >Intermediate</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Encounter Stages field Ends -->\t\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Diagnosis Classification field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"cmbDiagClass_Label\">Diagnosis Classification</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<!-- Error Message Container for Diag classification -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"cmbDiagClass_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"cmbDiagClass_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"cmbDiagClass\" name=\"cmbDiagClass\" id=\"cmbDiagClass\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"false\" onchange=\"validateDuplicatePrimaryDiag(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Primary Diagnosis already exists\"/>\n\t\t\t\t\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#cmbDiagClass\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t\t                        value: \"\",\n\t\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagClass\").val(\"\");\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                            else{\n\t\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagClass\").val(this.value());\n\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t                          }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t \t\t\t\t });\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDiagClass\" id=\"hdnDiagClass\" id=\"hdnDiagClass\" value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' />\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Diagnosis Classification field Ends -->\t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Chief Complaints field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Chief Complaint</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<select id=\"mulComplaints\" multiple=\"multiple\" style = \"height:40px\" data-type = \"ComboBox\"> \n\t\t\t\t\t\t\t\t\t\t      \t</select>\n\t\t\t\t\t\t\t   \t\t\t\t\t <script>\n\t\t\t\t\t\t\t   \t\t\t\t\t $(document).ready(function() {\n\t\t\t\t\t\t\t   \t\t\t\t\t\t $(\"#mulComplaints\").kendoMultiSelect({\n\t\t\t\t\t\t\t   \t\t\t\t\t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t                            var value = this.value();\n\t\t\t\t\t\t\t\t                            var complStr = \"\";\n\t\t\t\t\t\t\t\t                            for(var i=0; i<value.length;i++){\n\t\t\t\t\t\t\t\t                            \tcomplStr = complStr+value[i]+\"$\";\n\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t                            $(\"#hdnDiagCompl\").val(complStr);\n\t\t\t\t\t\t\t\t                            // Use the value of the widget\n\t\t\t\t\t\t\t\t                        }\n\t\t\t\t\t\t\t   \t\t\t\t\t\t});\n\t\t\t\t\t\t\t   \t\t\t\t\t });\n\t\t\t\t\t\t\t   \t\t\t\t\t </script>\n\t\t\t\t\t\t\t   \t\t\t\t\t <input type=\"hidden\" name=\"hdnDiagCompl\" id=\"hdnDiagCompl\" id=\"hdnDiagCompl\" value=\'\' />\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Chief Complaints field Ends -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<div id=\"NatureFieldWrap\">\n\t\t\t\t   \t    \t<!-- Nature Field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Nature<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\" >\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"NatureSlider\" class=\"scale scaleTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"NatureSlidePointer\" data-count=\"I\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-parent = \"NatureSlider\" data-numpoints=\"3\" data-drag=\"N\" data-dragdiv=\"NatureScaleHover\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnNature\" data-value1=\"A\" data-value2=\"W\" data-value3=\"P\" data-defaultvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnNature\" name=\"hdnNature\" id=\"hdnNature\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\" id=\"NatureScaleHover\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator1 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator2 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator3 scaleSeparatorTheme\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 0.5%;\" class = \"dvSliderLabel\" data-labelfor=\"NatureSlidePointer-1\">Actual</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 45%\" class = \"dvSliderLabel\" data-labelfor=\"NatureSlidePointer-2\">Wellness</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" data-labelfor=\"NatureSlidePointer-3\">Potential</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;height:20px;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"NatureSlidePointer-1\" data-labelval=\"1\" >Actual</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"NatureSlidePointer-2\" data-labelval=\"2\" >Wellness</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"NatureSlidePointer-3\" data-labelval=\"3\" >Potential</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Nature field Ends -->\t\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Accuracy field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"cmbAccuracy_Label\">Accuracy<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<input id=\"cmbAccuracy\" name=\"cmbAccuracy\" id=\"cmbAccuracy\" data-type=\"ComboBox\" data-role=\"none\" data-mandatory=\"true\" />\n\t\t\t\t\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#cmbAccuracy\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t                        value: \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\",\n\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagAcc\").val(\"\");\n\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagAccInd\").val(\"\");\n\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t                            else{\n\t\t\t\t\t\t\t\t                            \tvar selected = this.select();\n\t\t\t\t\t\t\t\t                            \tvar accInd = diagAccuracyDataSrc.diagAccuracyList[selected].accInd;\n\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagAcc\").val(this.value());\n\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagAccInd\").val(accInd);\n\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t                         }\n\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDiagAcc\" id=\"hdnDiagAcc\" id=\"hdnDiagAcc\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDiagAccInd\" id=\"hdnDiagAccInd\" id=\"hdnDiagAccInd\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' />\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\t\t\n\t\t\t\t   \t    \t<!-- Accuracy field Ends -->\t\n\t\n\t\t\t\t\t\t\t<div id=\"SeverityFieldWrap\">\n\t\t\t\t\t\t\t<!-- Severity Field Starts -->\n\t\t\t\t\t\t\t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Severity</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\" >\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"SeveritySlider\" class=\"scale scaleTheme2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"SeveritySlidePointer\" data-count=\"I\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-parent = \"SeveritySlider\" data-numpoints=\"4\" data-drag=\"Y\" data-dragdiv=\"SeverityScaleHover\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnSeverity\" data-value1=\"D\" data-value2=\"L\" data-value3=\"S\" data-value4=\"E\" data-defaultvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSeverity\" name=\"hdnSeverity\" id=\"hdnSeverity\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\" id=\"SeverityScaleHover\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleSeparator1 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleSeparator2 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleSeparator3 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleSeparator4 scaleSeparatorTheme1\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 0.5%\" class = \"dvSliderLabel\" data-labelfor=\"SeveritySlidePointer-1\" data-labelval=\"1\" >Moderate</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 31%\" class = \"dvSliderLabel\" data-labelfor=\"SeveritySlidePointer-2\" data-labelval=\"2\" >Severe</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 64%\" class = \"dvSliderLabel\" data-labelfor=\"SeveritySlidePointer-3\" data-labelval=\"3\" >Mild</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" data-labelfor=\"SeveritySlidePointer-4\" data-labelval=\"4\" >Extreme</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Severity field Ends -->\n\t\t\t\t   \t    \t</div>\t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<div id=\"PriorityFieldWrap\">\n\t\t\t\t   \t    \t<!-- Priority Field Starts -->\t\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Priority</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\" >\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"PrioritySlider\" class=\"scale scaleTheme2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"PrioritySlidePointer\" data-count=\"I\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-parent = \"PrioritySlider\" data-numpoints=\"3\" data-drag=\"Y\" data-dragdiv=\"PriorityScaleHover\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnPriority\" data-value1=\"N\" data-value2=\"H\" data-value3=\"C\" data-defaultvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnPriority\" name=\"hdnPriority\" id=\"hdnPriority\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\" id=\"PriorityScaleHover\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator1 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator2 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator3 scaleSeparatorTheme\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 0.5%;\" class = \"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-1\">Normal</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 45%\" class = \"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-2\">High</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-3\">Critical</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;height:20px;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-1\" data-labelval=\"1\" >Normal</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-2\" data-labelval=\"2\" >High</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"PrioritySlidePointer-3\" data-labelval=\"3\" >Critical</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\t\t\t\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Priority field Ends -->\t\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<div id=\"OnsetTypeFieldWrap\">\n\t\t\t\t   \t    \t<!-- Onset Type Field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Onset Type</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\" >\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"OnsetTypeSlider\" class=\"scale scaleTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"Round roundTheme\" id=\"OnsetTypeSlidePointer\" data-count=\"I\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-parent = \"OnsetTypeSlider\" data-numpoints=\"3\" data-drag=\"N\" data-dragdiv=\"OnsetTypeScaleHover\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnOnsetType\" data-value1=\"N\" data-value2=\"A\" data-value3=\"C\" data-defaultvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnOnsetType\" name=\"hdnOnsetType\" id=\"hdnOnsetType\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"scaleHover scaleHoverTheme\" id=\"OnsetTypeScaleHover\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator1 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator2 scaleSeparatorTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"threescaleSeparator3 scaleSeparatorTheme\"></div>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <div style=\"position: relative; width: 100%; height: 20px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 0.5%;\" class = \"dvSliderLabel\" data-labelfor=\"OnsetTypeSlidePointer-1\">Not Applicable</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; left: 45%\" class = \"dvSliderLabel\" data-labelfor=\"OnsetTypeSlidePointer-2\">Acute</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"position: absolute; right: 1%\" class = \"dvSliderLabel\" data-labelfor=\"OnsetTypeSlidePointer-3\">Chronic</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;height:20px;width:100%;height:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"OnsetTypeSlidePointer-1\" data-labelval=\"1\" >Not Applicable</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"OnsetTypeSlidePointer-2\" data-labelval=\"2\" >Acute</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;width:33%\" class=\"dvSliderLabel\" data-labelfor=\"OnsetTypeSlidePointer-3\" data-labelval=\"3\" >Chronic</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\t\t\t\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Onset Type field Ends -->\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Onset date field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"OnsetDate_Label\">Onset Date</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<!-- Error Message Container for onset date -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"OnsetDate_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"OnsetDate_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"OnsetDate\" data-type=\"Date\" data-count=\"I\" style=\"text-align:right\" data-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Onset date should be between Date of Birth and current date\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t\t\t\t\t                $(\"#OnsetDate\").kendoDateTimePicker({\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tvalue: StringToDate(\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"),\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tformat: \"dd/MM/yyyy hh:mm tt\",\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tmax:today,\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tmin:patDOB,\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tchange: function() {\n\t\t\t\t\t\t\t\t\t\t        \t\t\t        var value = this.value();\n\t\t\t\t\t\t\t\t\t\t        \t\t\t        $(\"#hdnOnsetDateTime\").val(DMYHMToString(value));\n\t\t\t\t\t\t\t\t\t\t        \t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t                onsetDTPicker = $(\"#OnsetDate\").data(\"kendoDateTimePicker\");\n\t\t\t\t\t\t\t\t\t\t\t\t            onsetDTPicker.readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t\t\t\t\t        <input type=\"hidden\" id=\"hdnOnsetDateTime\" name=\"hdnOnsetDateTime\" id=\"hdnOnsetDateTime\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t\t\t\t\t\n\t\t\t\t   \t    \t<!-- Onset Date field Ends -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- As on date field Starts -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"AsOnDate_Label\">As On<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<!-- Error Message Container for as on date -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"AsOnDate_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"AsOnDate_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"AsOnDate\" data-type=\"Date\" style=\"text-align:right\" data-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Status Date should be between Onset Date and Current Date\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t\t\t\t\t               // onsetDTPicker = $(\"#OnsetDate\").data(\"kendoDateTimePicker\");\n\t\t\t\t\t\t\t\t\t\t\t                $(\"#AsOnDate\").kendoDatePicker({\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tvalue: StringToDate(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"),\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tformat: \"dd/MM/yyyy\",\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tmax: today,\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tmin:patDOB,\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tchange: function() {\n\t\t\t\t\t\t\t\t\t\t        \t\t\t        var value = this.value();\n\t\t\t\t\t\t\t\t\t\t        \t\t\t        $(\"#hdnAsOnDate\").val(DMYToString(value));\n\t\t\t\t\t\t\t\t\t\t        \t\t\t\t}\n\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t\t\t\t\t        <input type=\"hidden\" id=\"hdnAsOnDate\" name=\"hdnAsOnDate\" id=\"hdnAsOnDate\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- As on Date field Ends -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Anatomical site field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\">Anatomical Site</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t<div style=\"display:table-row;\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstFieldContainerTheme cstFieldContainer3 cstFieldDull\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;padding-right:5px\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"dvSliderLabel\" data-labelfor=\"AnatomicalSlidePointer-1\" data-labelval=\"1\" >Oral Cavity</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;width:50px\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"sliderSmallParent\" data-role = \"none\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div  class = \"sliderSmallScale sfsScaleTheme\" id=\"AnatomicalSlider\"  data-role = \"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div class=\"sliderSfsIns sliderSfsInsTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    <div data-role = \"none\" class = \"sliderSmallPointer sfsCritRoundTheme\" id = \"AnatomicalSlidePointer\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    data-parent = \"AnatomicalSlider\" data-numpoints=\"2\" data-drag=\"N\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnAnatomicalSite\" data-value1=\"C\" data-value2=\"O\" data-defaultvalue=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"slSelectedLabel\" data-readonly=\"Y\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    <input type=\"hidden\" id=\"hdnAnatomicalSite\" name=\"hdnAnatomicalSite\" id=\"hdnAnatomicalSite\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\n\t\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;padding-left:5px\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t<div data-labelfor=\"AnatomicalSlidePointer-2\" class=\"dvSliderLabel\" data-labelval=\"2\" >Others</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:60%\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstFieldContainerTheme cstFieldContainer1 cstFieldDull\">\n\t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t<input id=\"cmbAnatSite\" name=\"cmbAnatSite\" id=\"cmbAnatSite\" data-type=\"ComboBox\" data-role=\"none\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#cmbAnatSite\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdataTextField: \"desc\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        dataValueField: \"code\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        value: \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            \t$(\"#hdnAnatomicalSiteVal\").val(\"\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            else{\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            \t$(\"#hdnAnatomicalSiteVal\").val(this.value());\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t\t\t\t\t\t                         }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdiagAnatomicalCombo = $(\"#cmbAnatSite\").data(\"kendoComboBox\");\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdiagAnatomicalCombo.readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnAnatomicalSiteVal\" name=\"hdnAnatomicalSiteVal\" id=\"hdnAnatomicalSiteVal\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t<!-- Anatomical site field Ends -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<div id=\"ApplicableSideFieldWrap\">\n\t\t\t\t   \t    \t<!-- Applicable Side field Starts -->\t\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\">Applicable Side</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<input id=\"cmbApplSide\" name=\"cmbApplSide\" id=\"cmbApplSide\" data-type=\"ComboBox\" data-role=\"none\"/>\n\t\t\t\t\t\t\t\t \t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#cmbApplSide\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdataSource: [\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  { id: \"L\", name: \"Left\" },\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  { id: \"R\", name: \"Right\" },\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  { id: \"B\", name: \"Both\" },\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  { id: \"N\", name: \"Not Applicable\" }\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t],\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdataTextField: \"name\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdataValueField: \"id\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue: \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\",\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tchange: function(e) {\n\t\t\t\t\t\t\t\t                            if(this.select()==-1){\n\t\t\t\t\t\t\t\t                            \tthis.value(\'\');\n\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagApplSide\").val(\"\");\n\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t                            else{\n\t\t\t\t\t\t\t\t                            \t$(\"#hdnDiagApplSide\").val(this.value());\n\t\t\t\t\t\t\t\t                            }\n\t\t\t\t\t\t\t\t                         }\n\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t\tdiagApplSideCombo = $(\"#cmbApplSide\").data(\"kendoComboBox\");\n\t\t\t\t\t\t\t\t\t\t\t\t\tdiagApplSideCombo.readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnDiagApplSide\" id=\"hdnDiagApplSide\" id=\"hdnDiagApplSide\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" />\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\t\n\n\t\t\t\t   \t    \t<!-- Applicable side field Ends -->\t\n\t\t\t\t   \t    \t</div>\n\t\t\t\t\t\t \t\n\t\t\t\t\t\t \t<!-- Remarks field Starts -->\t\n\t\t\t\t\t\t \t<div class=\"cstFieldRowContainer2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Remarks</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme\">\n\t\t\t\t\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"2000\" data-role=\"none\" id=\"txtRemarks\" name=\"txtRemarks\" style=\"display: block\" rows=\"50\" cols=\"10\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</textarea>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\n\t\t\t\t\t\t\t<!-- Remarks field Ends -->\n\t\t\t\t\t\t </div> <!-- Closing RDAllOtherFields div -->\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t</div><!-- container -->\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- Mandatory fields error -->\n\t\t\t\t\t<div class=\"formValErrorTheme formValError\" id=\"MandatoryFields_Error\" style=\"bottom: 10px; left: 2%; display: none\">\n\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All mandatory fields must be entered</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" /> \n\t\t\t\t<input type=\"hidden\" name=\"hdnMode\" id=\"hdnMode\" id=\"hdnMode\" value=\"MODIFY\"/>\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<!-- <input type=\"hidden\" name=\"hdnDiagDesc\" id=\"hdnDiagDesc\" id=\"hdnDiagDesc\" value=\'\' /> -->\n\t\t\t\t<input type=\"hidden\" name=\"SensitiveDataPwd\" id=\"SensitiveDataPwd\" id=\"SensitiveDataPwd\" value=\"\">\n\t\t\t\t<input type = \"hidden\" name = \"today\" id = \"today\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"patientDOB\" id = \"patientDOB\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnOccurSrlNo\" id = \"hdnOccurSrlNo\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnAccessionNum\" id = \"hdnAccessionNum\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnRelnId\" id = \"hdnRelnId\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnLocnCode\" id = \"hdnLocnCode\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnLocnType\" id = \"hdnLocnType\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnDiagEncounterId\" id = \"hdnDiagEncounterId\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnDiagFacilityId\" id = \"hdnDiagFacilityId\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnCodeIndicator\" id = \"hdnCodeIndicator\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnDiffGrpId\" id = \"hdnDiffGrpId\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnHighRiskCode\" id = \"hdnHighRiskCode\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnOldOnsetType\" id = \"hdnOldOnsetType\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnNotifiableCode\" id = \"hdnNotifiableCode\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnStatus\" id = \"hdnStatus\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/>\n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);


Locale appLocale;
if (session.getAttribute("LOCALE") != null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels",appLocale);

/* Gson gson = new Gson();
DiagnosisSetResponse diagSetResp;
ArrayList<DiagnosisSetHO> diagSetList = new ArrayList<DiagnosisSetHO>();
String diagSetJson = "";
if(request.getAttribute("DiagnosisSetResponse") != null){
	diagSetResp = (DiagnosisSetResponse)request.getAttribute("DiagnosisSetResponse");
	if(diagSetResp != null && diagSetResp.isSuccessResponse() && !diagSetResp.isEmptyDataResponse()){
		diagSetList = diagSetResp.getDiagnosisSetList();
		diagSetJson = gson.toJson(diagSetResp); 
	}
} */

String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}
//setting current date in dd/mm/yyyy hh:mm
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());
DiagnosisDetailsHO diagDetails = null;
DiagnosisDetailsResponse diagDetailsResp = (DiagnosisDetailsResponse)request.getAttribute("DiagnosisDetailsResponse");
if(diagDetailsResp!=null){
	diagDetails = diagDetailsResp.getDiagnosisDetails();
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(diagDetails!=null) {
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(diagDetails.getDiagSetId() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(diagDetails.getDiagCode()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(diagDetails.getDiagCode()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(diagDetails.getDiagDesc()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(diagDetails.getDiagDesc()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(diagDetails.getEncounterStage()));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(diagDetails.getEncounterStage()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(diagDetails.getDiagClassCode()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(diagDetails.getNature()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(diagDetails.getNature()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(diagDetails.getAccuracyCode()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(diagDetails.getAccuracyCode()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(diagDetails.getAccuracyInd()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(diagDetails.getSeverity()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(diagDetails.getSeverity()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(diagDetails.getPriority()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(diagDetails.getPriority()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(diagDetails.getOnsetType()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(diagDetails.getOnsetType()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(diagDetails.getOnsetDate()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(diagDetails.getOnsetDate()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(diagDetails.getStatusDate()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(diagDetails.getStatusDate()));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(diagDetails.getAnatomicalSite()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(diagDetails.getAnatomicalSite()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(diagDetails.getAnatomicalSiteCode()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(diagDetails.getAnatomicalSiteCode()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(diagDetails.getApplicableSide()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(diagDetails.getApplicableSide()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(diagDetails.getRemarks()));
            _bw.write(_wl_block46Bytes, _wl_block46);
 }
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(today));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patientDOB));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(diagDetails.getOccurSrlNo()));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(diagDetails.getAccessionNum()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(diagDetails.getRelationshipId()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(diagDetails.getLocnCode()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(diagDetails.getLocnType()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(diagDetails.getEncounterId()));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(diagDetails.getFacilityId()));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(diagDetails.getCodeIndicator()));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(diagDetails.getDiffGrpId()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(diagDetails.getHighRiskCode()));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(diagDetails.getOnsetType()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(diagDetails.getNotifiableCode()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(diagDetails.getStatus()));
            _bw.write(_wl_block64Bytes, _wl_block64);
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

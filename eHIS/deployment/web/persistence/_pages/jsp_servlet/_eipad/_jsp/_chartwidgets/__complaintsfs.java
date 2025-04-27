package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.activeproblems.healthobject.ComplaintSfsHO;
import eIPAD.chartsummary.activeproblems.response.ComplaintSfsResponse;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __complaintsfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ComplaintSFS.jsp", 1709118016990L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>Complaint Search</title>   \n<style>\n</style>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<script src=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/jquery.mobile-1.0.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/iPADThemeA.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/iPADNew.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/kendo.web.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/css/kendo.common.min.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/css/kendo.default.min.css\" />\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/ActiveProblems.js\"></script>\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/js/GenericSlider.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n\n\n\n\n</style>\n<script>\nvar sfsScroll;\nvar sfsFieldScroll;\nvar specialtyListCombo;\nvar path;\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nfunction loadSfsScroller() {\n\tsfsScroll = new iScroll(\'SfsScrollWrapper\');\n\t//sfsFieldScroll = new iScroll(\'SfsFieldsWrapper\') ; \n\tsfsFieldScroll = new iScroll(\'SfsFieldsWrapper\', {\n\t\tuseTransform: true,\n\t\tzoom: false,\n\t\tonBeforeScrollStart: function (e) {\n\t\tvar target = e.target;\n\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\te.preventDefault();\n\t\t}\n\t});\n}\ndocument.addEventListener(\'DOMContentLoaded\', loadSfsScroller, false);\nfunction displayResults()\n{\n\taddSpinner();\n\t//Check if Speciality is selected, else change search type to \'A\' ALL\n\tspecialtyListCombo = $(\"#cmbSpecialtyList\").data(\"kendoComboBox\");\n\tif(!specialtyListCombo.value() && $(\"#hdnFilterBy\").val()==\'S\'){\n\t\t$(\"#hdnFilterBy\").val(\'A\').trigger(\"change\");\n\t}\n\t\n\tdocument.getElementById(\"hdnPostback\").value = \"true\";\n\tdocument.getElementById(\"CSsfsForm\").submit();\n}\n\n\n\nfunction cancelSfs()\n{\n\twindow.parent.sfsCancel();\n}\n$(document).ready(function () {\n\n\tpath = document.getElementById(\"hdnPath\").value;\n\t\n\t\n\tspecialtyListCombo = $(\"#cmbSpecialtyList\").data(\"kendoComboBox\");\n\t$.getJSON(path + \"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=COMPL_SPECIALTYLIST\",function(data){\n\t\tvar specialtyListDataSrc = data;\n\t\tspecialtyListCombo.setDataSource(specialtyListDataSrc.specialtyList);\n\t});\n\t\n\t\n\t$(\'#hdnFilterBy\').change( function() { \n\t\tif($(\'#hdnFilterBy\').val()==\'S\'){\n\t\t\tspecialtyListCombo.enable(true);\n\t\t}else{\n\t\t\tspecialtyListCombo.enable(false);\n\t\t\t$(\"#hdnSpecialtyCode\").val(\'\');\n\t\t\tspecialtyListCombo.value(\"\");\n\t\t}\n\t});\n\t\n\t $(\'#FilterBySlidePointer\').sliderGenericControl();\n\t $(\'#SearchBySlidePointer\').sliderGenericControl();\n\t //$(\'#SearchTypeSlidePointer\').sliderGenericControl();\n\t \n\t\n\t \n});\n\nfunction selectComplaint(diagObj){\n\tvar code=$(diagObj).data(\"code\");\n\tvar desc=$(diagObj).data(\"complainttext\");\n\t$(\"#hdnSelectedComplCode\").val(code);\n\t$(\"#hdnSelectedComplText\").val(desc);\n\t\n\t$.getJSON( path+\"/mobile/chartsummary/ProblemsDiagnosisFieldValues?field=COMPL_EXISTS&ComplaintCode=\"+code, function(data){\n\t\tresult = data.validationResult;\n\t\tif(result==0){\n\t\t\t$(\"#DuplicateSelection_Error\").show();\n\t\t\tsetTimeout(function(){\n\t\t\t\t$(\"#DuplicateSelection_Error\").hide();\n\t\t\t},5000);\n\t\t\t$(\"#DuplicateSelection_Error\").bind(\'click\',function(){\n\t\t\t\t$(this).hide();\n\t\t\t});\n\t\t}else{\n\t\t\tparent.selectComplaint();\n\t\t}\n\t});\n\t\n\t\n}\nfunction toggleSearchFields(togImg){\n\t$(\"#SfsSearchFields\").toggle();\n\t$(togImg).toggleClass(\"SfsTogHide\");\n\t$(togImg).toggleClass(\"SfsTogExpand\");\n}\nfunction clearComplSfsData()\n{\t\n\t$(\"#hdnSearchBy\").val(\'DESC\').trigger(\"change\");\n\t$(\"#hdnFilterBy\").val(\'A\').trigger(\"change\");\n\tspecialtyListCombo = $(\"#cmbSpecialtyList\").data(\"kendoComboBox\");\n\tspecialtyListCombo.value(\"\");\n\t$(\"#hdnSpecialtyCode\").val(\'\');\n\t$(\"#SearchText\").val(\'\');\n\t\n}\n\nfunction addSpinner(){\n\tvar a = $(\"#spinnerDiv\")\t\n\tif(a.length ==0)\n\t$(\"#SfsScrollWrapper\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\nfunction removeSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\tif(a.length > 0)\n\t$(\"#spinnerDiv\").remove();\n}\n\n\n</script>\n</head>\n<body>\n\t<div class=\"SfsParent SfsParentTheme\" data-role=\"none\">\n\t<form id=\"CSsfsForm\" class=\"SfsForm\" action=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/mobile/chartsummary/ProblemsDiagnosisSFS?SfsType=COMPLAINT\" method=\"post\" name=\"CSsfsForm\" id=\"CSsfsForm\">\n\t\t<div class=\"SfsParentTable\" data-role=\"none\">\n\t\t\t<div class=\"SfsParentHeaderRow\" data-role=\"none\">\n\t\t\t\t<div class=\"SfsParentHeaderCell\" data-role=\"none\">\n\t\t\t\t\t<div class=\"SfsHeaderTable SfsHeaderTheme\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick = \"cancelSfs()\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsHeaderTextCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextTheme\"  id=\"DiagSfsHeaderTxt\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\tComplaint\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" style = \"display:none\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"SfsParentBodyRow\" data-role=\"none\">\n\t\t\t\t<div class=\"SfsParentBodyCell\" data-role=\"none\">\n\t\t\t\t\t<div class=\"SfsBodyTable\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsBodyRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsBodySearchFieldsCol\"  id=\"SfsSearchFields\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsContainer2 SfsSearchFieldsContainerTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div id=\"SfsFieldsScroller\" class=\"sfsFieldsScroller\">\n\t\t\t\t\t\t\t\t\t<div id=\"SfsFieldsWrapper\" class=\"sfsFieldsWrapper\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<!-- Filter By Fields Starts -->\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">Filter by</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div  class=\"SfsSearchFieldsPaddedRow2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"parent\" data-role=\"none\"style=\"width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div  class=\"scale sfsScaleTheme\" data-role=\"none\"  id=\"FilterBySlider\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"sliderSfsIns sliderSfsInsTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div data-role=\"none\" class=\"sliderSmallPointer sfsCritRoundTheme\" id=\"FilterBySlidePointer\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-parent = \"FilterBySlider\" data-numpoints=\"3\" data-drag=\"N\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnFilterBy\" data-value1=\"S\" data-value2=\"N\" data-value3=\"A\" data-defaultvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"SfsSearchFieldTxtSelTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnFilterBy\" name=\"hdnFilterBy\" id=\"hdnFilterBy\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:left;padding-left:5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"\" class = \"SfsSearchFieldTxtDullTheme\" data-labelfor=\"FilterBySlidePointer-1\" data-labelval=\"1\">Specialty</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center;padding-left:5px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"\" class = \"SfsSearchFieldTxtDullTheme\" data-labelfor=\"FilterBySlidePointer-2\" data-labelval=\"2\" >Non Specialty</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:right;padding-right:10px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"\" class = \"SfsSearchFieldTxtDullTheme\" data-labelfor=\"FilterBySlidePointer-3\" data-labelval=\"3\" >All</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!--  Filter By Fields Ends -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- Specialty List Fields Starts -->\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">Specialty</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsTextBoxContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"\" class=\"SfsTextBoxTheme SfsSearchText\" id=\"cmbSpecialtyList\" name=\"cmbSpecialtyList\" id=\"cmbSpecialtyList\" value = \"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#cmbSpecialtyList\").kendoComboBox({\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tenable: false,\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tdataTextField: \"specialtyDesc\",\n\t\t\t\t\t\t\t\t                        dataValueField: \"specialtyCode\",\n\t\t\t\t\t\t\t\t                        change: function(e) {\n\t\t\t\t\t\t\t\t                            $(\"#hdnSpecialtyCode\").val(this.value());\n\t\t\t\t\t\t\t\t                        },\n\t\t\t\t\t\t\t\t                        dataBound: function(e) {\n\t\t\t\t\t\t\t\t                        \tthis.value($(\"#hdnSpecialtyCode\").val());\n\t\t\t\t\t\t\t\t                        }\n\t\t\t\t\t\t\t\t\t\t\t\t\t});\n\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"hdnSpecialtyCode\" name=\"hdnSpecialtyCode\" id=\"hdnSpecialtyCode\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- Custom List Fields Ends -->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- Search By Fields Starts -->\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div  class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchByCodeText SfsSearchFieldTxtDullTheme\" style=\"display:table-cell\" data-role=\"none\" data-labelfor=\"SearchBySlidePointer-1\" data-labelval=\"1\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchBySlider\" style=\"display:table-cell;vertical-align:middle;text-align:left\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t<div  style = \"position:relative;width:70%;left:0px\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div  class = \"sliderSmallScale sfsScaleTheme\" data-role = \"none\" id = \"SearchBySlider\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div class=\"sliderSfsIns sliderSfsInsTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    <div data-role = \"none\" class = \"sliderSmallPointer sfsCritRoundTheme\" id = \"SearchBySlidePointer\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    data-parent = \"SearchBySlider\" data-numpoints=\"2\" data-drag=\"N\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-valuefield=\"hdnSearchBy\" data-value1=\"CODE\" data-value2=\"DESC\" data-defaultvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tdata-selstylelabel=\"SfsSearchFieldTxtSelTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    <input type=\"hidden\" id=\"hdnSearchBy\" name=\"hdnSearchBy\" id=\"hdnSearchBy\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchByDescText\" style=\"display:table-cell;text-align:right;\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"SfsSearchFieldTxtDullTheme\" style = \"position:relative;margin-right:10px\" data-labelfor=\"SearchBySlidePointer-2\" data-labelval=\"2\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- Search By Fields Ends -->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- Search Text Fields Starts -->\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsTextBoxContainer\" data-role=\"none\"><input type=\"text\" class=\"SfsTextBoxTheme SfsSearchText\" id=\"SearchText\" name=\"SearchText\" id=\"SearchText\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- Search Text Fields Ends -->\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsBodyButtonTheme SfsBodyButtonLeft\" data-role=\"none\" onclick = \"clearComplSfsData()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsBodyButtonTheme SfsBodyButtonRight\" data-role=\"none\" onclick = \"displayResults()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsBodyFieldsDockCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div  class=\"SfsTogHide\" onclick=\"toggleSearchFields(this)\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsBodySearchResCol\" style=\"display:table-cell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsSearchResContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderRow\" data-role=\"none\"> \n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderCodeCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderDescCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"SfsScrollWrapper\" id=\"SfsScrollWrapper\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsScroller\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"SfsSearchResRow\" data-role=\"none\" onclick=\"selectComplaint(this)\" data-code = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" data-desc = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t data-complainttext=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResCodeCol SfsSearchResBodyTheme SfsSearchResTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResDescCol SfsSearchResBodyTheme SfsSearchResTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t<div class=\"SfsSearchResRow\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResBodyTheme SfsSearchResTextTheme\" style = \"display:table-cell;width:100%\"data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t\t  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"SfsSearchResRow\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResBodyTheme SfsSearchResTextTheme\" style = \"display:table-cell;width:100%\"data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- Error message for duplicate selection -->\n\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"DuplicateSelection_Error\" style=\"bottom: 0px; left: 0px;display:none\">\n\t\t\t\t\t\t\t\t\t  \t \t<div class=\"formValErrorMsgTheme\" id=\"DuplicateSelection_ErrorMsg\">Complaint already exists</div>\n\t\t\t\t\t\t\t\t\t  \t </div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\n\t<input type=\"hidden\" id=\"hdnPostback\" name=\"hdnPostback\" id=\"hdnPostback\" value=\"true\" />\n\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" /> \n\t<input type=\"hidden\" name=\"hdnSelectedComplCode\" id=\"hdnSelectedComplCode\" id=\"hdnSelectedComplCode\" value=\"\"/>\n\t<input type=\"hidden\" name=\"hdnSelectedComplText\" id=\"hdnSelectedComplText\" id=\"hdnSelectedComplText\" value=\"\" />\n\t</form>\n\t</div>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

 Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 



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
            out.print( String.valueOf(csResBundle.getString("common.cancel") ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(csResBundle.getString("common.select") ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${empty param[\'hdnFilterBy\']?\'NA\':param[\'hdnFilterBy\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${empty param[\'hdnFilterBy\']?\'NA\':param[\'hdnFilterBy\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${param[\'hdnSpecialtyCode\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(csResBundle.getString("common.searchBy") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(csResBundle.getString("common.code") ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${empty param[\'hdnSearchBy\']?\'DESC\':param[\'hdnSearchBy\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(csResBundle.getString("common.description") ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(csResBundle.getString("common.searchText") ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${empty param[\'SearchText\']?\'\':param[\'SearchText\']}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(csResBundle.getString("common.clear") ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(csResBundle.getString("common.search") ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(csResBundle.getString("common.code") ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(csResBundle.getString("common.description") ));
            _bw.write(_wl_block29Bytes, _wl_block29);

												String pb = request.getParameter("hdnPostback")==null?"":request.getParameter("hdnPostback");
													if(request.getParameter("hdnPostback") != null && request.getParameter("hdnPostback").equals("true"))
													{ 
														ComplaintSfsResponse oSfsRes = null;
														 List<ComplaintSfsHO> lstSfsHO = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (ComplaintSfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse())
															{
																 lstSfsHO = oSfsRes.getComplaintSfsList();
																 if(lstSfsHO != null)
																 {
																	 int nLstCount = lstSfsHO.size();
																	 int nLoopcount = 0;
																	 ComplaintSfsHO oSfsHO = null;
																	 if(nLstCount > 0)
																	 {
																		 for(nLoopcount = 0;nLoopcount < nLstCount;nLoopcount++)
																		 {
																			 oSfsHO  = lstSfsHO.get(nLoopcount);
																			 if(oSfsHO != null)
																			 {
																			 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oSfsHO.getCode()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oSfsHO.getDescription()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oSfsHO.getComplaintText()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(oSfsHO.getCode()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(oSfsHO.getDescription()));
            _bw.write(_wl_block35Bytes, _wl_block35);
 
																			 }
																		 }
																	 }
																	 else
																	 {
																		 if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																			{
																			  
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(oSfsRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 
																			}
																	 }
																 }
															}
															else
															{
																if(oSfsRes != null)
																{
																	if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																	{
																	  
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oSfsRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block39Bytes, _wl_block39);
 
																	}
																}
															}
														}
														
													}
												
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
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

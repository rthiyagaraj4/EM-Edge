package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.activeproblems.healthobject.ComplaintDetailsHO;
import eIPAD.chartsummary.activeproblems.response.ComplaintDetailsResponse;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __modifycomplaint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ModifyComplaint.jsp", 1738426213826L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/ActiveProblemsTransaction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\ndocument.addEventListener(\'DOMContentLoaded\', assignMainScroll, false);\nvar diagTransactMainScroll;\nvar screenOrienttation = \"landscape\";\nvar path;\n\nfunction changeOrientation(orient, EMHFheight)\n{\n\tvar CSHFheight = $(\'#allergyHeader\').height();\n   \tHFheight = EMHFheight;\n   \tscreenOrienttation = orient;\n   \tvar content_height = parent.getTotalPageDivHeight() - EMHFheight - CSHFheight-6 ;\n   \tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n   //\t$(\'#header1\').focus();\n   \tscrollRefresh();\n}\nfunction scrollRefresh()\n{\n \tif(diagTransactMainScroll != null)\n \t\tdiagTransactMainScroll.refresh();\n}\n\n\nfunction assignMainScroll() {\n\t\t setTimeout(function () {\n\t\t\t diagTransactMainScroll = new iScroll(\'divcnt\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\t\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' && target.tagName != \'DIV\')\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 1000); \n}\n\n$(document).ready(function () {\n\t   parent.setOnLoadContentPaneHeight();\n\t   path = document.getElementById(\"hdnPath\").value;\n\t   mode = document.getElementById(\"hdnMode\").value;\n\t //Setting patient DOB and current server date\n\t\tvar patDOB_str = $(\"#patientDOB\").val();\n\t\tpatDOB = StringToDate(patDOB_str);\n\t\tvar today_str = $(\"#today\").val();\n\t\ttoday = StringToDate(today_str);\n\t\t\n\t\t//Initializing DateTimePicker Objects\n\t\tonsetDTPicker = $(\"#OnsetDate\").data(\"kendoDateTimePicker\");\n\t\t\n\t\t//to enable scrolling inside textarea\n\t\t$(\'textarea\').each(function(index){\n\t\t\t$(this).bind(\'touchmove\', function(event){\n\t\t    \tevent.stopPropagation();\n\t\t\t});\n\t\t});\n\t\t\t\n\n\t\t   \n});\n\n</script>\n\n</head>\n<body>\n\t<div id=\"divParent\" class=\"divParent\" data-role=\"page\" style=\"padding: 0px\">\n\t\t<form name = \"frmModifyCompl\" id = \"frmModifyCompl\" style=\"width: 100%; height: 100%\" action=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="//mobile/chartsummary/ComplaintTransaction\">\n\t\t\t<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" data-popid=\"\"></div>\n\t\t\t<!-- popup container -->\n\t\t\t<div data-role=\"none\" class=\"diagSfs sfsIPTheme\" id=\"sfs\">\n\t\t\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style=\"display: block;\"\n\t\t\t\t\tscrolling=\"no\" class=\"popupIFrame\" src=\"\"></iframe>\n\t\t\t</div>\n\t\t\t<!-- popup container ends -->\n\t\t\t<div id=\"allergyHeader\" class=\"AllergyHeader\" style=\"padding: 0px\"\n\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"tbAllergyHeader\"\n\t\t\t\t\t\tdata-role=\"none\">\n\t\t\t\t\t\t<tr class=\"normalTr\">\n\t\t\t\t\t\t\t<td class=\"normalTd\">\n\t\t\t\t\t\t\t\t<div class=\"RecordAllergyHeader RecordAllergyHeaderTheme\">\n\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 99%; text-align: left\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class = \"allergyHeaderPageTitle ipHeaderPageTitleTheme\">Modify Complaint</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\" style=\"width: 1%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"RecordAllergyTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"normalRow\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" id=\"ModifyComplSubmitButton\" onclick=\"validateAndModifyComplaint()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/images/CS_Ok16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"AllergyCell\"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: auto; text-align: right\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"buttonContainer\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"WidgetButtonTheme\" onclick=\"cancelTransaction()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/CS_Close16x16.png\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div id=\"divcnt\" class=\"divAllergyContent divAllergyContentTheme\" style=\"padding: 0px; overflow: hidden\" data-role=\"none\">\n\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\n\t\t\t\t\t\t<div style=\"width: 100%; height: auto; overflow: auto\" data-role=\"none\">\t<!-- container start -->\t\n\n\t\t \t\t\t\t\t<div class=\"cstFormHeader\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<span class=\"cstheaderTextTheme\" data-role=\"none\">Complaint Details</span>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t\t\t \t\n\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t \t<!-- Complaint Code field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"hdnComplCode_Label\">Complaint Code<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\">\n\t\t\t\t\t\t \t\t\t\t\t\t<!-- Error Message Container for complaint code -->\n\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"hdnComplCode_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"hdnComplCode_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t \t\t\t\t\t\t<div style=\"display:table\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:99%;vertical-align:middle;padding-left:5px;\" id=\"ComplCodeField\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"hdnComplCode\" id=\"hdnComplCode\" id=\"hdnComplCode\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' data-mandatory=\"true\" data-errmsg1=\"Record already exists\"/>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t<div style=\"display:table-cell;width:1%\">\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t\t<div class=\"cstSearchIconCell\"><div data-role = \"none\" class = \"cstSfsFieldSearchIcon\"></div></div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\t\n\t\t\t\t\t\t\t<!-- Complaint Code field Ends -->\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Complaint Desc field Starts -->\n\t\t\t\t\t\t\t<div class=\"cstFieldRowContainer2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"txtComplDesc_Label\">Complaint Details<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme\">\n\t\t\t\t\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"500\"  data-role=\"none\" id=\"txtComplDesc\" name=\"txtComplDesc\" style=\"display: block\" data-mandatory=\"true\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</textarea>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t\t\t\t<!-- Complaint Desc field Ends -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Onset date field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabelDisable\" id=\"OnsetDate_Label\">Onset Date<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1 cstFieldContainerTheme cstFieldDull\" >\n\t\t\t\t\t\t \t\t\t\t\t\t<!-- Error Message Container for onset date -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"OnsetDate_Warning\" style=\"top: 45px; left: 0px; display: none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"OnsetDate_WarningMsg\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"OnsetDate\" data-type=\"Date\" data-count=\"I\" style=\"text-align:right\" data-role=\"none\" onchange=\"validate(this)\"\n\t\t\t\t\t\t\t\t\t\t\t\t\tdata-errmsg1=\"Onset date should be between Date of Birth and current date\" data-mandatory=\"true\" /> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t            $(document).ready(function() {\n\t\t\t\t\t\t\t\t\t\t\t                // create DateTimePicker from input HTML element\n\t\t\t\t\t\t\t\t\t\t\t               // var today1 = new Date();\n\t\t\t\t\t\t\t\t\t\t\t                $(\"#OnsetDate\").kendoDateTimePicker({\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tvalue: StringToDate(\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"),\n\t\t\t\t\t\t\t\t\t\t\t        \t\t\tformat: \"dd/MM/yyyy hh:mm tt\",\n\t\t\t\t\t\t\t\t\t\t\t                });\n\t\t\t\t\t\t\t\t\t\t\t                onsetDTPicker = $(\"#OnsetDate\").data(\"kendoDateTimePicker\");\n\t\t\t\t\t\t\t\t\t\t\t\t            onsetDTPicker.readonly(true);\n\t\t\t\t\t\t\t\t\t\t\t            });\n\t\t\t\t\t\t\t\t\t\t\t        </script>\n\t\t\t\t\t\t\t\t\t\t\t        <input type=\"hidden\" id=\"hdnOnsetDateTime\" name=\"hdnOnsetDateTime\" id=\"hdnOnsetDateTime\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t   \t    \t\t\t\t\t\n\t\t\t\t   \t    \t<!-- Onset Date field Ends -->\n\t\t\t\t   \t    \t\n\t\t\t\t   \t    \t<!-- Remarks field Starts -->\t\n\t\t\t\t\t\t \t<div class=\"cstFieldRowContainer2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\">Remarks</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme\">\n\t\t\t\t\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"2000\"  data-role=\"none\" id=\"txtRemarks\" name=\"txtRemarks\" style=\"display: block\" rows=\"50\" cols=\"10\" onfocus=\"disableScroll()\" onblur=\"enableScroll()\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</textarea>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\n\t\t\t\t\t\t\t<!-- Remarks field Ends -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Mark as Error field Starts -->\n\t\t\t\t   \t    \t<div class=\"cstFieldRowContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"hdnComplCode_Label\">Mark as Error</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer1\">\n\t\t\t\t\t\t \t\t\t\t\t\t<div class=\"csChkBoxTheme3\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"MarkAsError\" onclick = \"markAsError(this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"MarkAsError\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\t\t\t\n\t\t\t\t\t\t\t<!-- Mark as Error field Ends -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div id=\"ErrorRemarksFieldWrap\" style=\"display:none\">\n\t\t\t\t\t\t\t<!-- Error Remarks field Starts -->\n\t\t\t\t\t\t\t<div class=\"cstFieldRowContainer2\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:30%;text-align:right;vertical-align:middle\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldLabel\" id=\"txtErrRemarks_Label\">Error Remarks<font style=\"color: red\">*</font></div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:60%;\">\n\t\t\t\t\t\t \t\t\t\t\t<div class=\"cstFieldContainer2 cstFieldContainerTheme\">\n\t\t\t\t\t\t \t\t\t\t\t\t<textarea class=\"csttxtArea\" maxlength=\"500\" data-role=\"none\" id=\"txtErrRemarks\" name=\"txtErrRemarks\" style=\"display: block\" data-mandatory=\"false\" onfocus=\"disableScroll()\" onblur=\"enableScroll()\"></textarea>\n\t\t\t\t\t\t \t\t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t</div>\n\t\t\t\t\t\t \t\t\t\t<div style=\"display:table-cell;width:10%\"></div>\n\t\t\t\t\t\t \t\t\t</div>\n\t\t\t\t   \t    \t\t</div>\n\t\t\t\t   \t    \t</div>\n\t\t\t\t   \t    \t<div class=\"cstRowDivider\"></div>\n\t\t\t\t\t\t\t<!-- Error Remarks field Ends -->\n\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t \t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t</div><!-- container -->\n\t\t\t\t\t</div>\n\t\t\t\t\t<!-- Mandatory fields error -->\n\t\t\t\t\t<div class=\"formValErrorTheme formValError\" id=\"MandatoryFields_Error\" style=\"bottom: 10px; left: 2%; display: none\">\n\t\t\t\t\t\t<div class=\"formValErrorMsgTheme\" id=\"MandatoryFields_ErrorMsg\">All mandatory fields must be entered</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" /> \n\t\t\t\t<input type=\"hidden\" name=\"hdnMode\" id=\"hdnMode\" id=\"hdnMode\" value=\"MODIFY\"/>\n\t\t\t\t<input type = \"hidden\" name = \"today\" id = \"today\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"patientDOB\" id = \"patientDOB\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnComplFacility\" id = \"hdnComplFacility\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnComplEncounterId\" id = \"hdnComplEncounterId\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t\t\t<input type = \"hidden\" name = \"hdnErrorYN\" id = \"hdnErrorYN\" value=\"N\"/>\n\t\t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block0Bytes, _wl_block0);


Locale appLocale;
if (session.getAttribute("LOCALE") != null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String) session.getAttribute("LOCALE"));
else
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels",appLocale);

String patientDOB="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");
if(patContext!=null){
	patientDOB = patContext.getDob();
}
//setting current date in dd/mm/yyyy hh:mm 
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
String today = dateFormat.format(new java.util.Date());

ComplaintDetailsHO complDetails = null;
ComplaintDetailsResponse complDetailsResp = (ComplaintDetailsResponse)request.getAttribute("ComplaintDetailsResponse");

if(complDetailsResp!=null){
	complDetails = complDetailsResp.getComplaintDetails();
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
if(complDetails!=null) {
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(complDetails.getComplaintCode() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(complDetails.getComplaintCode() ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(complDetails.getComplaintDesc() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(complDetails.getOnsetDate()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(complDetails.getOnsetDate()));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complDetails.getRemarks() ));
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(today));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patientDOB));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(complDetails.getFacilityId()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(complDetails.getEncounterId()));
            _bw.write(_wl_block28Bytes, _wl_block28);
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

package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Locale;
import java.util.ResourceBundle;

public final class __patientemrbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PatientEMRBasePage.jsp", 1709118029209L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>Patient Charts</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/iPADNew.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/mCommon.css\" /> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/kendo/kendo.common.min.css\"/> \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/kendo/kendo.silver.min.css\" />\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/js/iscroll5/iscroll.js\"></script>  \n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/css/iPadPharmaCommon.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/css/iPadPharmaPages.css\" /> \n<script src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eIPAD/js/lib/jquery/jquery-2.2.4.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/js/lib/kendo/kendo.all.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<style>\nbody {\n    position: fixed;\n}\n</style>\n<script>\n//document.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nvar path;\nfunction logout()\n{\n\tvar xmlhttp;\n\tif (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t\txmlhttp = new XMLHttpRequest();\n\t} else {// code for IE6, IE5\n\t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t}\n\txmlhttp.onreadystatechange = function() {\n\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n\t\t\twindow.location = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/ipadlogin\";\n\t\t}\n\t}\n\txmlhttp.open(\"POST\", \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/jsp/Logoff.jsp\", true);\n\txmlhttp.send();\n}\n\n$(document).ready(function(){\n\tpath = $(\"#hdnPath\").val();\n\t$(\"#ChartFunctionPage\").load(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/mobile/charts/pharmacy/PharmInitServlet\");\n\t\n\tif (window.DeviceOrientationEvent) {\n\t\twindow.addEventListener(\'orientationchange\',\n\t\t\t\tmyOrientResizeFunction, false);\n\t}\n\tvar frameHeight = getTotalPageDivHeight() - $(\'#EMHeader\').height() - $(\'#EMFooter\').height();\n\t$(\'#ChartFunctionPage\').css(\"height\" ,frameHeight );\n    //$(\'#ChartSummaryNotesIframe\').css(\"height\" ,frameHeight );\n\t\n\tfunction myOrientResizeFunction() {\n\t\tsetTimeout(function() {\n\t\tvar orient = Math.abs(window.orientation) === 90 ? \'landscape\' : \'portrait\';\n\t\tvar ht = getTotalPageDivHeight() - $(\'#EMHeader\').height() - $(\'#EMFooter\').height()\n\t\tif (orient == \"landscape\") {\n\t\t\t$(\'#ChartFunctionPage\').css(\"height\" ,ht );\n\t\t\tdocument.getElementById(\"ChartFunctionPage\").contentWindow.changeOrientation(orient, $(\'#EMHeader\').height() + $(\'#EMFooter\').height());\n\t\t\t\n\t\t\n\t\t} else {\n\t\t\t$(\'#ChartFunctionPage\').css(\"height\" ,ht );\n\t\t\tdocument.getElementById(\"ChartFunctionPage\").contentWindow.changeOrientation(orient, $(\'#EMHeader\').height() + $(\'#EMFooter\').height());\n\t\t\t\n\t\t}\n\t}, 500);\n\t}\n\t\n});\nfunction getTotalPageDivHeight(){\n\tvar i = $(\'#divParent\').height();\n\treturn i;\n}\n\nfunction openOtherChartFunctions(functionName){\n\twindow.location.replace(path+\"/setpatientcontext?activePage=\"+functionName+\"&setNewPatientContext=N\"); \n}\nfunction openPharmacyFunction(){\n\t$(\"#ChartFunctionPage\").load(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/mobile/charts/pharmacy/PharmInitServlet\");\n}\nfunction closeChartSummary(){\n\t$(\"#ChartSummaryBlock\").append(\"<div class=\'loadingCartItem\'></div>\");\n\t window.location.replace(path+\"/eIPAD/jsp/IPad.jsp?ActivePage=IP\"); \n}\n\n\n\n</script>\n<style>\n\n\n</style>\n</head>\n<body>\n\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<div id=\"divParent\" class = \"mdivParent\" data-role=\"page\">\n\t\t<div data-role = \"none\" id = \"dvMez\" class=\"blurPopup\"></div>\n\t\t<form id=\"ChartsBaseForm\" name = \"ChartsBaseForm\" method = \"post\" action = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/setpatientcontext\">\n\t\t\t<div id=\"divTable\" class = \"mdivTable\" data-role = \"none\">\n\t\t\t\n\t\t\t\t<!-- header starts -->\n\t\t\t\t<div data-role = \"none\" class = \"mheaderRow\" id=\"EMHeader\">\n\t\t\t\t\t<table class=\"mheader grd1-theme\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t        <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t<td style = \"width:90%;height:100%\" align = \"left\" ><span class=\"mheaderText headerText1-theme\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" - ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span></td>\n\t\t\t\t\t\t\t<td style = \"width:10%;height:100%\" valign = \"center\" align = \"right\" onclick = \"logout()\">\n\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="/eIPAD/images/Logout1.png\" class=\"mHeaderImgLogout\" ></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t        </tr>\n\t\t       \t\t</table>\n\t\t\t       \n\t\t\t\t\t<div class = \"PatienBannerContainer PatientBannerContainerTheme\" data-role = \"none\" >\n\t\t\t\t\t    <div class = \"PatientBannerRow\" data-role = \"none\">\n\t\t\t\t\t    \t<div class = \"PatientBannerPhotoCol\" data-role = \"none\">\n\t\t\t\t\t    \t\t<img class=\"PatientBannerImage\" width=\"55\" height=\"55\" src=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/mobile/PatientImageServlet?PatientId=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t\t    \t</div>\n\t\t\t\t\t    \t<div class = \"PatientBannerDataCol\" data-role = \"none\">\n\t\t\t\t\t\t    \t<div data-role = \"none\" class = \"PatientBannerDataLine1\">\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerDataRow1\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerPatientIDCol PatientBannerPatientIDColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</div>\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerPatientNameCol PatientBannerPatientNameColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div>\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</div>\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t    \t</div>\n\t\t\t\t\t\t    \t<div data-role = \"none\" class = \"PatientBannerDataLine2\">\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerDataRow2\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t    \t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;-\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t    \t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =",&nbsp;\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t    \t\t\t\t \t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =",&nbsp; \n\t\t\t\t\t\t    \t\t\t\t\t\n\t\t\t\t\t\t    \t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp; \n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t    \t\t\t</div>\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerLabelCol PatientBannerLabelColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</div><!-- TODO replace with message bundle text --> \n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</div>\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerLabelCol PatientBannerLabelColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div><!-- TODO replace with message bundle text -->\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerTextCol PatientBannerTextColTheme\" data-role = \"none\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</div>\n\t\t\t\t\t\t    \t\t\n\t\t\t\t\t\t    \t\t\t\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t    \t</div> \n\t\t\t\t\t    \t</div>\n\t\t\t\t\t    \t<div class = \"PatientBannerIconCol\" data-role = \"none\">\n\t\t\t\t\t    \t\t<div class = \"PatientBannerIconTable\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerIconRow\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerIcons\" data-role = \"none\"><img class=\"PatientBannerIconImg\" src=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="/eIPAD/images/VIP.png\"></div>\n\t\t\t\t\t\t    \t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t\t    \t\t<div class = \"PatientBannerIconRow\" data-role = \"none\">\n\t\t\t\t\t\t    \t\t\t<div class = \"PatientBannerIcons\" data-role = \"none\"><img class=\"PatientBannerIconImg\" src=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="/eIPAD/images/Down Arrow.png\" style=\"display:none\"></div>\n\t\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t    \t\t</div>\n\t\t\t\t\t    \t</div>\n\t\t\t\t\t    </div>\n\t\t\t\t\t\t\t\t\t     \n\t\t\t       \t</div>\n\t\t   \t\t</div><!-- div first row header ends  -->\n\t\t   \t\t\n\t\t   \t\t<!-- Page content starts -->\n\t\t   \t\t<div data-role = \"none\" class = \"secondRow secondRowTheme\">\n\t\t   \t\t\t<div class=\"ChartsContent\">\n\t\t   \t\t\t\t<div id=\"ChartFunctionPage\" style=\"width:100%;height:100%\">\n\t\t   \t\t\t\t\n\t\t   \t\t\t\t</div>\n\t\t   \t\t\t</div>\n\t\t   \t\t</div>\n\t\t   \t\t<!-- Page content ends here -->\n\t\t   \t\t\n\t\t   \t\t<!-- Footer starts -->\n\t\t\t\t<div data-role = \"none\" class = \"footer\" id=\"EMFooter\" >\n\t\t\t\t\t<div class = \"footerContent footerContentTheme\" data-role = \"none\">\n\t\t\t     \t\t<table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t        \t<tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t\t<td style = \"width:65%;height:100%\" valign = \"top\">\n\t\t\t\t\t            \t<table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t            \t<tr style = \"width:100%;height:50%\">\n\t\t\t\t\t\t            \t\t<td style = \"width:100%;height:100%\" valign = \"top\" align = \"left\">\n\t\t\t\t\t\t            \t    \t<span class=\"spUserInfo\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</span>\n\t\t\t\t\t\t            \t  \t</td>\n\t\t\t\t\t\t            \t</tr>\n\t\t\t\t\t\t            \t<tr style = \"width:100%;height:50%\">\n\t\t\t\t\t\t            \t\t<td style = \"width:100%;height:100%\" valign = \"top\" align = \"left\">\n\t\t\t\t\t\t            \t  \t\t<span class=\"spUserInfo\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</span>\n\t\t\t\t\t\t            \t  \t</td>\n\t\t\t\t\t\t            \t</tr>\n\t\t\t\t\t            \t</table>\n\t\t\t\t\t          \t</td>\n\t\t\t\t\t          \t<td style = \"width:30%;height:100%\" align = \"right\" valign = \"top\">\n\t\t\t\t\t          \t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" <!-- TODO replace with message bundle text --> \n\t\t\t\t\t         \t\t<img src=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="/eIPAD/images/CSC_Logo.png\" class=\"imgCopyRights\"></img>\n\t\t\t\t\t          \t</td>\n\t\t\t\t        \t</tr>\n\t\t\t       \t\t</table>\n\t\t\t   \t\t</div>    \n\t\t   \t\t</div>\n\t\t   \t\t<!-- Footer Ends -->\n\t\t   \t\t\n\t\t\t</div><!-- divTable ends here -->\n\t\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnSelectedEncounter\" id = \"hdnSelectedEncounter\" value=\"\" />\n\t\t\t<input type = \"hidden\" name = \"hdnopeningPage\" id = \"hdnopeningPage\" value=\"\" />\n\t\t\t<input type = \"hidden\" name = \"hdnEpisodeId\" id = \"hdnEpisodeId\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnPatientId\" id = \"hdnPatientId\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" />\n\t\t\t<input type = \"hidden\" name = \"hdnLocnType\" id =  \"hdnLocnType\" value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" />\n\t\t    <input type = \"hidden\" name = \"hdnLocnCode\" id =  \"hdnLocnCode\" value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" />\n\t\t    <input type=\"hidden\" name=\"hdnPatClass\" id=\"hdnPatClass\" id=\"hdnPatClass\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/>\n\t\t    <input type=\"hidden\" name=\"hdnOpeningPage\" id=\"hdnOpeningPage\" id=\"hdnOpeningPage\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"/>\n\t\t</form>\n\t</div> <!-- divParent ends here -->\n\t <!-- modal box content Starts -- Active Problems & diagnosis sensitive data authorization -->\n\t<div id=\"authorizeWindow\" style=\"display:none\" class=\"authorizeWindow authorizeWindowTheme\">\n\t\t<div class=\"authorizeWindowTitle WidgetWhiteBoldText2Theme\">\n\t\t\t<div style=\"display:table-cell;vertical-align:middle\">Authorize</div>\n\t\t</div>\n\t\t<div class=\"authorizeTextBoxContainer authorizeTextBoxContainerTheme\">\n\t\t\t<div style=\"display:table-row\">\n\t\t\t\t<div style=\"display: table-cell; width: 220px;\">\n\t\t\t\t\t<input type=\"password\" class=\"authorizeTextBox authorizeTextBoxTheme\" onkeyup=\"pwdTextChange(this)\" onclick=\"clearPlaceholderText(this)\" placeholder=\"\" id=\"authorizeTextBox\" name=\"authorizeTextBox\" id=\"authorizeTextBox\">\n\t\t\t\t</div>\n\t\t\t\t<div style=\"display: table-cell; text-align: center; vertical-align:middle\">\n\t\t\t\t\t<div class=\"authorizeClrTxtCircle authorizeClrTxtCircleTheme authorizeControlsDim\" onclick=\"clearPwdText()\" id=\"clearPwdTextImg\"></div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<div style=\"display:table;height:10px\"></div>\n\t\t<div class=\"authorizeButtonContainer\">\n\t\t\t<div style=\"display:table-row;width:100%\">\n\t\t\t\t<div style=\"\" class=\"authorizeButtonTheme\" id=\"authorizeCancelButton\" onclick=\"closeAuthorizePrompt()\">\n\t\t\t\t\tCancel\n\t\t\t\t</div>\n\t\t\t\t<div style=\"display:table-cell;width:10px;\" class=\"\"></div>\n\t\t\t\t<div style=\"\" class=\"authorizeButtonTheme authorizeControlsDim\" id=\"authorizeOKButton\" onclick=\"validatePwd()\">\n\t\t\t\t\tOK\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\t<!-- modal box content Ends -->\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
 
String openingPage = request.getParameter("activePage")==null?"":request.getParameter("activePage"); 


            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"product_description\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"version_no\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientName}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerPatientNameLocal}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block39Bytes, _wl_block39);
             org.apache.taglibs.standard.tag.rt.core.IfTag __tag5 = null ;
            int __result__tag5 = 0 ;

            if (__tag5 == null ){
                __tag5 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
            }
            __tag5.setPageContext(pageContext);
            __tag5.setParent(null);
            __tag5.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerEncounterId}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
            _activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block40Bytes, _wl_block40);
                    out.print( String.valueOf(csResBundle.getString("common.encounterId") ));
                    _bw.write(_wl_block41Bytes, _wl_block41);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerEncounterId}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block42Bytes, _wl_block42);
                } while (__tag5.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag5);
                return;
            }
            _activeTag=__tag5.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
            __tag5.release();
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(csResBundle.getString("common.practitioner") ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerAttendPractName}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"login_user\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"facility_name\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope[\"userSite\"]}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.encounterId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.patientId}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.locationType}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.locationCode}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${sessionScope.PatientContext.patientClass}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(openingPage));
            _bw.write(_wl_block60Bytes, _wl_block60);
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerDob}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block29Bytes, _wl_block29);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerDob}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block30Bytes, _wl_block30);
            } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerAge}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block32Bytes, _wl_block32);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerAge}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block33Bytes, _wl_block33);
            } while (__tag2.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerGender}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block34Bytes, _wl_block34);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerGender}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block35Bytes, _wl_block35);
            } while (__tag3.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${not empty requestScope.bannerNationality}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block36Bytes, _wl_block36);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerNationality}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block37Bytes, _wl_block37);
            } while (__tag4.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.IfTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.core.IfTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.bannerVip == \'true\' }",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.IfTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block46Bytes, _wl_block46);
                out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
                _bw.write(_wl_block47Bytes, _wl_block47);
            } while (__tag6.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}

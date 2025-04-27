package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __iplistslidesfsfilter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IPListSlideSfsFilter.jsp", 1738426049040L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2_0 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>IP View</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> -->\n\n\n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />  \n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n<!--   -->\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n\n\n<script type=\"text/javascript\">\n//variables for setting the content frame height according to the device\n//below values are header footer heights\nvar header_borderheight= 90;\nvar content_height;\n\nvar scrollContent1 ;\nvar scrollNav;\n\nfunction loaded1() {\n\t//scrollContent1 = new iScroll(\'divcnt\');\n\t//scrollNav = new iScroll(\'contentWrapper2\');\n\tsetTimeout(function () {\n\t\tscrollContent1 = new iScroll(\'divcnt\');\n\t}, 100);\n\t}\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\ndocument.addEventListener(\'DOMContentLoaded\', loaded1, false);\n\n\n $(document).ready(function () {\n\t parent.setIframeHeight();\n\tvar currentOrderBy = document.getElementById(\"hdnOrderBy\").value;\n    if(currentOrderBy == \"\" || currentOrderBy == \"OR\")\n    \t$(\'#orderByNone\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    else if(currentOrderBy == \"patient_name\")\n    \t$(\'#orderByPatientName\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    else if(currentOrderBy == \"physician_name\")\n    \t$(\'#orderByPhysicianName\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    else if(currentOrderBy == \"bed_num\")\n    \t$(\'#orderByBedNum\').removeClass(\'WidgetFilterButtonTheme\').addClass(\'WidgetFilterButtonSelTheme\');\n    \n    //submitting form when space or enter key is pressed in the patient id text box\n    $(\'#txtPatientId\').bind(\'keypress\', function(e) {\n        if (e.which == 32){//space bar\n            //alert(\'space\');\n        \tipFormSubmit();\n        }\n        if (e.which == 13){//enter key\n            //alert(\'enter\');\n        \tipFormSubmit();\n        }\n        \n\t});\n    //-----scroll--------------\n    /*\n    var scrollContent1;\n    window.addEventListener(\'DOMContentLoaded\', loaded1, false);\n    document.addEventListener(\'DOMContentLoaded\', loaded1, false);\n    scrollContent1 = new iScroll(\'divcnt\');\n    function loaded1() {\n    \t//scrollContent1 = new iScroll(\'divcnt\');\n    \t//scrollNav = new iScroll(\'contentWrapper2\');\n    \tsetTimeout(function () {\n    \t\tscrollContent1 = new iScroll(\'divcnt\');\n    \t}, 100);\n    \t}\n    */\n    //------scroll----------\n    //sfsrelated code below\n    $(\"#btnsfs\").bind(\'touchstart\', function(event) { \n        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get \'touches\' \n        var e = event.originalEvent; \n      //  alert(e.touches[0].pageY)\n       // alert($(this).scrollTop() );\n        var scrollStartPos =  e.touches[0].pageY;\n      //  alert(e.touches[0].pageX);\n       //// alert(scrollStartPos);\n        scrollStartPos = scrollStartPos ;\n       //// $(\"#sfsarrow\").css(\'top\',scrollStartPos);\n       // scrollStartPos = scrollStartPos + \"30\";\n      //  alert(scrollStartPos)\n      //  $(\"#sfs\").css(\'top\',scrollStartPos)\n        var tleft = e.touches[0].pageX - \"15\"\n       // alert(tleft);\n      //   $(\"#sfsarrow\").css(\'left\', tleft);\n      //  $(\"#sfs\").css(\'top\', scrollStartPos);\n      //  alert(scrollStartPos);\n       // scrollLast = event.touches[0].pageY;\n         $(\"#sfs\").css(\'z-index\', \"1000\");\n         $(\"#sfsarrow\").css(\'z-index\',\"1000\");\n     //   $(\'#divscr\').html (\"scroostartpos111=\" + scrollStartPos );\n       // e.preventDefault(); \n    }); \n });\n \n\n \n \n function changeOrientation(orient, HFheight)\n {\n \tcontent_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight;\n\tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n\t\n\tif(scrollContent1 != null)\n\tscrollContent1.refresh();\n }\n\n function clearPatientIdText()\n {\n\t document.getElementById(\"txtPatientId\").value=\"\";\n\t document.getElementById(\"hdnPatientId\").value =\"\";\n }\n function toggleLegend(){\n\t $(\'#legendContainer\').toggle();\n }\n function openPatient(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)\n {\n\t\n\t //window.parent.slidee(\"true\");\n\t\n\t//alert(patientid);\n\t//alert(\"hi\");\n\t//alert(episodeId);\n\twindow.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode);\n\t//document.getElementById(\"IpForm\").submit();\n\t//window.open(\"Appointment.html\");\n }\n function show(objBtn)\n {\n\t  //alert(\"hiii\");\n\t    var myBars = \'directories=no,location=no,menubar=no,status=no\' ;\n\t\tvar myOptions = \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=no, fullscreen=yes\' ;\n\t\t//var myFeatures = myBars + \', \' + myOptions ;\n\t\tvar myFeatures =  myOptions ;\n\t\t//var ecisWindow = open( \'iPadWidget.html\', \'iPadWidget.html\', myFeatures,false ) ;\n\t\t\n\t\t//var retval = window.showModalDialog(\"AppView.jsp\", \"\", myFeatures);\n\t\t//$.mobile.changePage(\'#Dialog\',{role:\'dialog\'})\n\t\t//$.mobile.changePage(\'#Dialog\',{role:\'dialog\',transition: \"pop\"})\n\t//\tdocument.getElementById(\"srchFrame\").src = \"appview.html\";\n    //   $.mobile.changePage(\"#Dialog\", \"slide\" , false,false);\n\t\t//alert(\"finished\");\n\t\tobjBtn.style.border = \"3px solid #48d1d8\";\n\t\tdocument.getElementById(\"hdnPatientId\").value = document.getElementById(\"txtPatientId\").value;\n\t\t document.getElementById(\"hdnNursingUnit\").value = \"\";\n\t\t document.getElementById(\"hdnClinicianId\").value = \"\";\n\t\t document.getElementById(\"hdnSpeciality\").value = \"\";\n\t\t//document.getElementById(\"hdnClinicianId\").value = document.getElementById(\"txtPracId\").value;\n\t\t//document.getElementById(\"hdnNursingUnit\").value = document.getElementById(\"txtNursingUnit\").value;\n\t\t//document.getElementById(\"hdnSpeciality\").value = document.getElementById(\"txtSpeciality\").value;\n\t\tdocument.getElementById(\"IpForm\").submit();\n\n\n }\n\n function ipFormSubmit()\n {\n\t //$.trim($(\"#hdnPatientId\").val($.trim($(\"#txtPatientId\").val())));\n\t //alert(document.getElementById(\"txtPatientId\").value.length);\n\t //var trimmedPatId= document.getElementById(\"txtPatientId\").value.trim();\n\t //alert(trimmedPatId.length);\n\t document.getElementById(\"hdnPatientId\").value = document.getElementById(\"txtPatientId\").value;\n\t document.getElementById(\"IpForm\").submit();\n }\n\n\n function fnOrderBy(orderByVal)\n {\n\t//alert(orderByVal);\n\t document.getElementById(\"hdnOrderBy\").value = orderByVal;\n\t document.getElementById(\"IpForm\").submit();\n }\n\n function showsfs()\n {\n \t//document.getElementById(\"sfs\").style.display = \"none\";\n \t//var e = event.originalEvent; \n \t//alert( $(obj).scrollTop());\n \t//alert(e.touches[0].pageY);\n \tdocument.getElementById(\"sfsFrame\").src = \"IPSearch-newUI.jsp\";\n \t$(\"#sfs\").css(\'z-index\', \"1000\");\n \t$(\"#sfsarrow\").css(\'z-index\',\"1000\");\n \t$(\'#sfs\').toggle();\n \t$(\'#sfsarrow\').toggle();\n \t//document.getElementById(\"frame1\").src = \"popup1.html\";\n \t//window.parent.show();\n }\n\n\n \n function refresh(){\n\t document.getElementById(\"hdnOrderBy\").value = \"\";\n\t document.getElementById(\"hdnPatientId\").value = \"\";\n\t document.getElementById(\"hdnNursingUnit\").value = \"\";\n\t document.getElementById(\"hdnClinicianId\").value = \"\";\n\t document.getElementById(\"hdnSpeciality\").value = \"\";\n\t document.getElementById(\"IpForm\").submit();\n }\n\n function slidesfsSearch(patientID){\n\n\t /* alert(patientID); */\n\t document.getElementById(\"hdnPatientId\").value = patientID;\n\t document.getElementById(\"hdnNursingUnit\").value = \"\";\n\t document.getElementById(\"hdnClinicianId\").value = \"\";\n\t document.getElementById(\"hdnSpeciality\").value = \"\";\n\t document.getElementById(\"IpForm\").submit();\n }\n \n function hideRows(arrSP,arrPR,arrNU){\n\t\n\t var totalCount = arrSP.length + arrPR.length + arrNU.length ;\n\t var trackcount=0;\n\t var multipleCrit = false; \n\t if(arrSP.length>0)\n\t\t trackcount++;\n\t if(arrPR.length>0)\n\t\t trackcount++;\n\t if(arrNU.length>0)\n\t\t trackcount++;\n\t if(trackcount>1)\n\t\t multipleCrit = true;\n\t \n\t if(!multipleCrit){\n\t\t \n\t }\n\t rows = $(\"#divcnt\").find(\".tbIpRow\").hide();\n\t //Selecting for the first criteria\n\t if(arrSP.length>0){\n\t\t for( var j =0;j<arrSP.length;j++){\n\t\t\tvar code = arrSP[j];\n\t\t\t$(\"[data-spec = \'\"+code+\"\']\").each(function (i,v ){\n\t\t\t\t$(this).show();\n\t\t\t\tscrollContent1.refresh();\n\t\t\t});\n\t\t}\n\t }\n\t else if(arrPR.length>0){\n\t\t for( var j =0;j<arrPR.length;j++){\n\t\t\t\tvar code = arrPR[j];\n\t\t\t\t$(\"[data-pract = \'\"+code+\"\']\").each(function (i,v ){\n\t\t\t\t\t$(this).show();\n\t\t\t\t\tscrollContent1.refresh();\n\t\t\t\t});\n\t\t  }\n\t }\n\t else if(arrNU.length>0){\n\t\t for( var j =0;j<arrNU.length;j++){\n\t\t\t\tvar code = arrNU[j];\n\t\t\t\t$(\"[data-nursingunit = \'\"+code+\"\']\").each(function (i,v ){\n\t\t\t\t\t$(this).show();\n\t\t\t\t\tscrollContent1.refresh();\n\t\t\t\t});\n\t\t  }\n\t }\n\t \n\t //selecting other criterion\n\t if(multipleCrit){\n\t\t if(arrPR.length>0){\n\t\t\t $(\".tbIpRow:visible\").each(function (i,v){\n\t\t\t\t var thispr = $(this).data(\"pract\");\n\t\t\t\t if(arrPR.indexOf(thispr)==-1){\n\t\t\t\t\t $(this).hide();\n\t\t\t\t\t scrollContent1.refresh();\n\t\t\t\t }\n\t\t\t });\n\t\t }\n\t\t if(arrNU.length>0){\n\t\t\t $(\".tbIpRow:visible\").each(function (i,v){\n\t\t\t\t var thisnu = $(this).data(\"nursingunit\");\n\t\t\t\t if(arrNU.indexOf(thisnu)==-1){\n\t\t\t\t\t $(this).hide();\n\t\t\t\t\t scrollContent1.refresh();\n\t\t\t\t }\n\t\t\t });\n\t\t }\n\t }\n\t //deselecting first criteria\n\t if(totalCount==0){\n\t\trows = $(\"#divcnt\").find(\".tbIpRow\").show();\n\t\t }\n\t \n\t \n }\n \n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n </head>\n<body style= \"width:100%; height:100%;\"  >\n\n\t<div id = \"sfsarrow\" data-role = \"none\" class = \"sfs-bubble-arrow sfs-bubble-arrowIPTheme\" ></div>\n   \t<div data-role = \"none\" class = \"sfs sfsIPTheme\"  id = \"sfs\" >\n  \t \t<iframe id = \"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" height = \"300px\" width = \"340px\" src = \"IPSearch-newUI.jsp\"></iframe>  \n   \t</div> \n\t<div data-role = \"page\" class=\"ipListParent\" style = \"padding:0px;width:100%;height:100%;\">\n\t\t<form name=\'IpForm\' id=\'IpForm\' method=\'post\' id=\"IpForm\" style = \"width:100%;height:100%;\">\n\t\t\t<div class =\"ipHeader\">\n\t\t\t\t<div class=\"ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme\">\n\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t<td style = \"width:50px; padding-left:5px;\">\n\t\t\t        \t\t\t<div class = \"WidgetButtonTheme\" onclick=\"parent.toggleMenu()\"><img src = \"../images/MenuIcon.png\"/></div>\n\t\t";
    private final static byte[]  _wl_block2_0Bytes = _getBytes( _wl_block2_0 );

    private final static java.lang.String  _wl_block2_1 ="\t   \t\t\t\t</td>\n\t\t\t    \t\t\t<td style = \"width:auto\">\n\t\t\t         \t\t\t<div class = \"ipHeaderPageTitle ipHeaderPageTitleTheme\"> In Patient</div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t\t\t   \t\t";
    private final static byte[]  _wl_block2_1Bytes = _getBytes( _wl_block2_1 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\t</tr>\n\t\t    \t\t</table>\n\t\t\t\t</div>\n\n\t  \t\t\t<div class = \"ipHeaderMenuContainer2\">\n\t  \t\t\t\t<div  data-role =\"none\" class =\"ipContentHolderHeader ipContentHolderHeaderTheme\">\n\t\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  \t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t    <td style = \"width:10%\">\n\t\t\t\t\t\t\t         <span class = \"ipContentHolderRefreshIcon\"><img src = \"../images/Refresh_black.png\" onclick=\"refresh()\"/></span>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td></td>\n\t\t\t\t\t\t\t    <td style = \"width:50%;padding-right:10px;\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t\t    \t<table class= \"ipContentHolderIconContainer WidgetFilterContTheme\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t\t\t\t    <tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'OR\')\" id=\"orderByNone\"><img src = \"../images/view01.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'bed_num\')\" id=\"orderByBedNum\"><img src = \"../images/ByBed.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'patient_name\')\" id=\"orderByPatientName\"><img src = \"../images/ByPatient.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"WidgetFilterButtonTheme\" onclick=\"fnOrderBy(\'physician_name\')\" id=\"orderByPhysicianName\"><img src = \"../images/View03.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t\t\t        \t</table>\t\n\t\t\t\t\t\t    \t</td>\n\t\t\t \t\t\t\t</tr>\n\t\t    \t\t\t</table>\t  \n\t  \t\t\t\t</div>\n\t  \t\t\t</div>\n\t  \t\t</div>\n    \t\t<div id = \"divcnt\"  class = \"divIPcontent divIPcontentTheme\" style=\"overflow:hidden\">\n\t\t\t\t<div style = \"width:100%;height:auto;overflow:auto\" >\n\t\t\t\t  ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \n   \t\t\t\t\t<table class = \"IPContentTable IPContentTableTheme tbIpRow\" data-spec=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" data-pract=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" data-nursingunit=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\" onclick = \"openPatient(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' , \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\">\n        \t\t\t\t<tr class=\"trIpRows\" id=\"patientDetailRow\"  >\n           \t\t\t\t\t<td class=\"tdLegendCol\" align=\"center\" valign = \"center\" style = \"width:5%\">\n              \t\t\t\t\t<div class = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" ></div>\n           \t\t\t\t\t</td>\n           \t\t\t\t\t<td style = \"width:5%\" align=\"center\" valign = \"center\" >\n           \t\t\t\t\t<div class = \"imgPhoto imgPhotoTheme\">\n             \t\t\t\t\t<img width=\"55\" height=\"55\" src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/mobile/PatientImageServlet?PatientId=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" class=\"PatImgTagTheme\"></img>\n             \t\t\t\t\t</div>\n           \t\t\t\t\t</td>\n           \t\t\t\t\t<td style=\"width:85%\">\n\t\t\t\t\t             <table style = \"width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\">\n\t\t\t\t\t                \t<td style=\"width:100%;word-break:break-all\" colspan = \"2\" >\n\t\t\t\t\t                        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t                          <div class = \"txtRows txtRowsTheme\" > ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div>\n\t\t\t\t\t                    </td>\n\t\t\t\t\t                </tr>\n               \t\t\t\t\t\t<tr class=\"trIpChildRows\">\n\t\t\t\t                         <td style=\"width:100%;word-break:break-all\" colspan = \"2\">\n\t\t\t\t                          <span class=\"lz-list-label lz-list-labelTheme\">Practitioner :</span><span class=\"lz-list-data1 lz-list-data1Theme\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t                         </td>\n                         \n                \t\t\t\t\t</tr>\n\t\t\t\t\t                <tr class=\"trIpChildRows\">\n\t\t\t\t\t                    <td style=\"width:100%;word-break:break-all\" >\n\t\t\t\t\t                     <span class=\"lz-list-label lz-list-labelTheme\">Room,Bed No :</span><span class=\"lz-list-data1 lz-list-data1Theme\">\n\t\t\t\t\t                     ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =", ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<span class=\"lz-list-data2 lz-list-data2Theme\"> On ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span></span>  \n\t\t\t\t\t                   </td>\n\t\t\t\t\t                </tr>\n\t\t\t\t\t             </table>\n           \t\t\t\t\t</td>\n\t\t\t\t           \t<td style = \"width:5%\" align = \"center\" valign = \"center\">\n\t\t\t\t             \t<img src=\"../images/Right_Arrow.png\"  class=\"ipListArrowImage\"/>\n\t\t\t\t           \t</td>\n\t\t\t\t           \t\n        \t\t\t\t</tr>\n   \t\t\t\t\t</table>   \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t   <span class=\"ipSearchResultsEmptyTheme\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n   \t\t\t\t</div>\n       \t\t\t<div class=\"legendToggler legendTogglerTheme\" onclick=\"toggleLegend()\"><img src = \"../images/LegendIcon.png\" style=\"padding:10px 10px 10px 22px;\"/></div>\n   \t\t\t\t<div class =\"legendContainer\" id = \"legendContainer\">\n\t\t    \t\t<table class = \"tblegends tblegendsTheme\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\" >\n\t\t\t\t\t\t<tr style = \"width:100%;height:100%;\">\n\t\t\t\t\t\t  \t<td style = \"width:20px;height:100%;padding-left: 5px;\"> \n\t\t\t\t\t\t  \t\t<div class = \"dvLegendDischargedTheme\"></div>\n\t\t\t\t\t\t \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:auto;height:100%;\" class=\"legendTextFooterTheme\"> \n\t\t\t\t\t\t  \t\tDischarged\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:20px;height:100%;padding-left: 5px;\"> \n\t\t\t\t\t\t  \t\t<div class = \"dvLegendDeceasedTheme\"></div>\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:auto;height:100%;\" class=\"legendTextFooterTheme\"> \n\t\t\t\t\t\t  \t\tDeceased\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:20px;height:100%;padding-left: 5px;\"> \n\t\t\t\t\t\t  \t\t<div class = \"dvLegendNewBornTheme\"></div>\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:auto;height:100%\" class=\"legendTextFooterTheme\"> \n\t\t\t\t\t\t  \t\tNewborn Exist\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:20px;height:100%;padding-left: 5px;\"> \n\t\t\t\t\t\t  \t\t<div class = \"dvLegendNoRelationTheme\"></div>\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:auto;height:100%\" class=\"\"> \n\t\t\t\t\t\t  \t\tNo PP Relationship\n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t  \t<td style = \"width:40px;height:100%\"> \n\t\t\t\t\t\t  \t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t \t\t</div>\n   \n   \t\t\t\t\n   \t\t\t</div>\n\n    \t\t\t\t\n\t\t\t<input type = \"hidden\" name =\"hdnPatientId\" id =\"hdnPatientId\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnNursingUnit\" id =\"hdnNursingUnit\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnClinicianId\" id =\"hdnClinicianId\" value = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnSpeciality\" id =\"hdnSpeciality\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t<input type = \"hidden\" name =\"hdnOrderBy\" id =\"hdnOrderBy\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t</form> \n\n\n  \n\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</div>\n</body>\n</html>\n\n";
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	InPatientContext oInPatientContext = new InPatientContext();
	oInPatientContext.setRequest(request);
	String facility_id= ""; //(String)session.getValue("facility_id");
	String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
	String sPatientId = "" ;
	String sNursingUnitCode = "";
	String sNursingUnit = "";
	String sClinicianDesc = "";
	String sSpecialityCode = "";
	String sSpeciality = "";
	String sOrderBy = "";
	String sFacilityId = "";
	String sPractionerId = "";
	String sPractionerDesc = "";
	if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
	{
		facility_id = (String)session.getValue("facility_id");
		oInPatientContext.setFacilityId(facility_id);
	}
	
	if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
	{
		clinicianId = (String)session.getValue("ca_practitioner_id");
		oInPatientContext.setClinicianId(clinicianId);
	}
	
	String className = "dvLegendNotRequired";
	StringTokenizer st = null;
	String deceasedYn = "";
	int noofchildren = 0;
	String relationYn = "";
	String tempDischargeDate = "";
	String strPatientDetails = "";
	
	
	if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "" && request.getParameter("hdnPatientId") != " ")
	{
	 
		sPatientId = ((String)request.getParameter("hdnPatientId")).trim();
		oInPatientContext.setPatientId(sPatientId);
	 
	}
	
	if(request.getParameter("hdnNursingUnit") != null && request.getParameter("hdnNursingUnit") != "" && request.getParameter("hdnNursingUnit") != " ")
	{
	  
	 sNursingUnitCode = (String)request.getParameter("hdnNursingUnit");
	 oInPatientContext.setNursingUnitCode(sNursingUnitCode);
	}
	if(request.getParameter("hdnClinicianId") != null && request.getParameter("hdnClinicianId") != "" && request.getParameter("hdnClinicianId") != " ")
	{
	
	 sPractionerId = (String)request.getParameter("hdnClinicianId");
	 oInPatientContext.setPractionerId(sPractionerId);
	 
	}
	if(request.getParameter("hdnSpeciality") != null && request.getParameter("hdnSpeciality") != "" && request.getParameter("hdnSpeciality") != " ")
	{
	
	 sSpecialityCode = (String)request.getParameter("hdnSpeciality");
	 oInPatientContext.setSpecialityCode(sSpecialityCode);
	}
	
	if(request.getParameter("hdnOrderBy") != null &&  request.getParameter("hdnOrderBy") != "")
	{
		
		sOrderBy = (String)request.getParameter("hdnOrderBy");
		oInPatientContext.setOrderBy(sOrderBy);
	}
	
	
	if(request.getParameter("txtPracId") != null &&  request.getParameter("txtPracId") != "")
	{
		
		sPractionerDesc = (String)request.getParameter("txtPracId");
		oInPatientContext.setPractionerDesc(sPractionerDesc);
	}
	
	if(request.getParameter("txtNursingUnit") != null &&  request.getParameter("txtNursingUnit") != "")
	{
		
		sNursingUnit = (String)request.getParameter("txtNursingUnit");
		oInPatientContext.setNursingUnit(sNursingUnit);
		
	}
	if(request.getParameter("txtSpeciality") != null &&  request.getParameter("txtSpeciality") != "")
	{
		
		sSpeciality = (String)request.getParameter("txtSpeciality");
		oInPatientContext.setSpeciality(sSpeciality);
		
	}
	


            _bw.write(_wl_block2_0Bytes, _wl_block2_0);
            _bw.write(_wl_block2_1Bytes, _wl_block2_1);
            _bw.write(_wl_block3Bytes, _wl_block3);

				  int nClassCount = 1;
				  int cnt = 0;
				  String Status = "";
				  String emergencyYn = "";
				  String n = null;
				  
				  InPatientList bean = new InPatientList();
				  List<InPatients> objInPatientList = new ArrayList<InPatients>(); 
				  int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
				  int nCssCount = 1;  // To display alternate Row Color.
				 
				  int nListSize = 0;
			
				  int nLoopCount = 0;
				  InPatients oInPatients = null;
				  try {
					  objInPatientList = bean.getInPatientLis(oInPatientContext);
					  if(objInPatientList != null)
					  {
					       nListSize =  objInPatientList .size();
					       
					  }
					 if(nListSize > 0)
					 {
					   for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
						{
					 
						   oInPatients = objInPatientList.get(nLoopCount); 
						   if(oInPatients != null)
						   {
					        Status = oInPatients.sStatus;
					        st = new StringTokenizer(Status,"|");
							  while (st.hasMoreTokens())
								{
									emergencyYn = st.nextToken();
									deceasedYn = st.nextToken();
									n = st.nextToken();
									if(!(n == null || n.equals("")))
										noofchildren = Integer.parseInt(n);
									relationYn = st.nextToken();
								}
					  
							  if(oInPatients.sDischargeDateTime != null)
							  {
									if( !oInPatients.sDischargeDateTime.equals(""))
										className = "dvLegendDischargedTheme";
							  }
							  
								
								if(deceasedYn.equals("D"))
								{
									className = "dvLegendDeceasedTheme";
									
								}
								if(noofchildren > 0) 
									className = "dvLegendNewBornTheme";
								
								if(relationYn.equals("N"))
								{
									className = "dvLegendNoRelationTheme";
								}
								
								 deceasedYn = "";
								 noofchildren = 0;
								 relationYn = "";
								 tempDischargeDate = "";
				  
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oInPatients.sSpecialityCode ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(oInPatients.sPhysicianName ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oInPatients.locationCode ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oInPatients.sDischargeDateTime));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oInPatients.locationType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oInPatients.serviceCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(className ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
  
					                        // strPatientDetails = out.println(rs.getString("patient_name") )+ " " + out.println(rs.getString("sex"),rs.getString("age")) + " " + out.println(rs.getString("patient_id"));
					                        strPatientDetails = oInPatients.sPatientName + ", " + oInPatients.sPatientId + ", " + oInPatients.sGender + " ";
					                         
					                         
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strPatientDetails ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(oInPatients.sPhysicianName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oInPatients.sRoomNo));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(oInPatients.sBedNo));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block19Bytes, _wl_block19);

							   }
					   className = "dvLegendNotRequired";
					     nRowCount = nRowCount + 1;
						  if(nCssCount==1)
						  {
							   nCssCount = nCssCount +1;
						  }
						  else
						  {
							  nCssCount = nCssCount -1;
						  }	 
					   }//for
					 
						 }//if listsize 
						 else
						 {
							 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
						 }
					  
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oInPatientContext.getPatientId()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oInPatientContext.getNursingUnitCode() ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oInPatientContext.getPractionerId() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oInPatientContext.getSpecialityCode() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oInPatientContext.getOrderBy() ));
            _bw.write(_wl_block27Bytes, _wl_block27);

	}catch ( Exception e ){
		out.println("Exception " + e);
		e.printStackTrace();
	}
	finally{
	
	}
	
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

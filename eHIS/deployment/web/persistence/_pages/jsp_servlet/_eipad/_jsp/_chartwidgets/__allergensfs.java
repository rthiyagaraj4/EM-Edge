package jsp_servlet._eipad._jsp._chartwidgets;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;
import java.util.*;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __allergensfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/AllergenSFS.jsp", 1709118013678L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>Allergy Search</title>   \n<style>\n</style>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<script src=\"";
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

    private final static java.lang.String  _wl_block8 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n\n</style>\n<script>\nvar sfsScroll;\nvar sfsDataArr = [];\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nfunction loadSfsScroller() {\n\tsfsScroll = new iScroll(\'SfsScrollWrapper\');\n}\ndocument.addEventListener(\'DOMContentLoaded\', loadSfsScroller, false);\nfunction displayResults()\n{  \n\taddSpinner();\n\tdocument.getElementById(\"SC\").value = document.getElementById(\"AllergySfsText\").value;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"CSsfsForm\").submit();\n}\nfunction trim1(myString)\n{\n return myString.replace(/^\\s+|\\s+$/g, \'\'); \n}\nfunction getSfsData(currentObj)\n{\n\t  \n\t  var sfsObject = new Object();\n      var code = \"\";\n      var desc = \"\";\n      code = $(currentObj).attr(\"data-code\");\n      desc = $(currentObj).attr(\"data-desc\");\n      var duplicateAllergenCode = \"false\";//validateAllergenCode(allergenCode);\n      if($(\'#hdnSfsType\').val() == \"1\")\n      {\n    \t  //duplicateAllergenCode = validateAllergenCode(code); \n    \t  var xmlhttp;\n\t\tvar EI = $(\'#EI\').val();\n\t\tvar EC = $(\'#EC\').val();\n\t\tvar path = $(\'#hdnPath\').val()  + \"/eIPAD/jsp/chartwidgets/AllergenValidate.jsp\";\n\t\tvar sendString = \"EC=\" + EC+\"&EI=\" + EI + \"&AC=\" + code;\n\t\tif (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t\t\txmlhttp = new XMLHttpRequest();\n\t\t} \n\t\telse {// code for IE6, IE5\n\t\t\t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t}\n\t\t\txmlhttp.open(\"POST\", path, true);\n\t\t\txmlhttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\txmlhttp.send(sendString);\n\t\t\txmlhttp.onreadystatechange = function() {\n\t\t\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n\t\t\t\t\tvar respText = xmlhttp.responseText;\n\t\t\t\t\trespText =  trim1(respText);\n\t\t\t\t\tif(respText != \"true\")\n\t\t\t\t\t{\n\t\t\t\t\t      sfsObject.code = code;\n\t\t\t\t\t      sfsObject.desc = desc;\n\t\t\t\t\t      sfsObject.sfsType = $(\'#hdnSfsType\').val();\n\t\t\t\t\t      sfsDataArr.push(sfsObject); \n\t\t\t\t\t      window.parent.getSfsDetails(sfsDataArr);\n\t\t\t\t\t    //  window.parent.getSfsDetails();\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\t$(\"#DuplicateSelection_Error\").show();\n\t\t\t\t\t\tsetTimeout(function(){\n\t\t\t\t\t\t\t$(\"#DuplicateSelection_Error\").hide();\n\t\t\t\t\t\t},5000);\n\t\t\t\t\t\t$(\"#DuplicateSelection_Error\").bind(\'click\',function(){\n\t\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t\t});\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n      }\n     \n      else\n      {\n\t      sfsObject.code = code;\n\t      sfsObject.desc = desc;\n\t      sfsObject.sfsType = $(\'#hdnSfsType\').val();\n\t      sfsDataArr.push(sfsObject); \n\t      window.parent.getSfsDetails(sfsDataArr);\n\t     // window.parent.getSfsDetails();\n      }\n}\nfunction validateAllergenCode(allergenCode)\n{\n\tvar xmlhttp;\n\tvar EI = $(\'#EI\').val();\n\tvar EC = $(\'#EC\').val();\n\tvar path = $(\'#hdnPath\').val()  + \"/eIPAD/jsp/chartwidgets/AllergenValidate.jsp\";\n\tvar sendString = \"EC=\" + EC+\"&EI=\" + EI + \"&AC=\" + allergenCode;\n\tif (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari\n\t\txmlhttp = new XMLHttpRequest();\n\t} \n\telse {// code for IE6, IE5\n\t\t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t}\n\t\txmlhttp.open(\"POST\", path, true);\n\t\txmlhttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\txmlhttp.send(sendString);\n\t\txmlhttp.onreadystatechange = function() {\n\t\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n\t\t\t\tvar respText = xmlhttp.responseText;\n\t\t\t\treturn respText;\n\t\t\t\n\t\t\t}\n\t\t}\n}\nfunction getSfsDataArray()\n{\n\treturn sfsDataArr;\n}\nfunction clearData()\n{\n\t$(\'#SB\').val(\"desc\");\n\t$(\'#RoundI\').css(\"left\" , \"70%\");\n\t$(\'#AllergySfsText\').val(\"\");\n}\nfunction cancelSfs()\n{\n\twindow.parent.sfsCancel();\n}\n$(document).ready(function () {\n\tif($(\'#SB\').val() == \"CODE\")\n\t{\n\t\t$(\'#RoundI\').css(\"left\" , \"0%\");\n\t}\n\telse\n\t{\n\t\t$(\'#RoundI\').css(\"left\" , \"70%\");\n\t}\n\t//---------slider functionality starts---------------\n\tjQuery.fn.sliderControl = function() { \n\t    var scrollStartPos = 0; \n\t    var scrollLast = 0;\n\t    var dvleft = 100;\n\t    var n33 = 0;\n\t    var n66 = 0;\n\t    var n99 = 0;\n\t    var touchleft = 0;\n\t    var iDcount = \"1\";\n\t    var offset = null;    \n\t    $(this).bind(\'touchstart\', function(event) { \n\t        var e = event.originalEvent; \n\t        var orig = event.originalEvent;\n\t\t    var pos = $(this).position();\n\t\t    offset = {\n\t\t      x: orig.changedTouches[0].pageX - pos.left,\n\t\t      y: orig.changedTouches[0].pageY - pos.top\n\t\t     \n\t\t    };\n\t        iDcount = $(this).attr(\"data-count\");\n\t        if(iDcount == null || iDcount == \"\")\n\t        \t{\n\t        \t  iDcount = \"1\";\n\t        \t}\n\t       n33 =  $(\'#nDvParent\' + iDcount).width() * 0.50;\n\t       \n\t       n99 =  $(\'#nDvParent\' + iDcount).width() * 0.70;\n\t    }); \n\t    $(this).bind(\'touchmove\', function(event) { \n\t    \tevent.preventDefault();\n\t    \tevent.stopPropagation();\n\t    \tvar e = event.originalEvent; \n\t    \ttouchleft = e.touches[0].pageX - offset.x;\n\t    \tif(touchleft < n99 && touchleft > 0)\n\t    \t{\n\t\t    \t $(this).css(\"left\" , touchleft);\n\t\t    \t\n\t    \t}\n\t    \n\t    }); \n\t    $(this).bind(\'touchend\', function(event) { \n\t        if(touchleft < 0)\n\t        {\n\t        \t $(this).css(\"left\" , \"0%\");\n\t        \t document.getElementById(\"SB\").value = \"CODE\";\n\t  \t\t \t\n\t        }\n\t    \tif(touchleft > 0 && touchleft < n33)\n\t        {\n\t        \t \n\t         // alert(n33);\n\t        \t\t  $(this).css(\"left\" , \"0%\");\n\t        \t\t  document.getElementById(\"SB\").value = \"CODE\"; \n\t        }\n\t    \t\n\t    \tif(touchleft > n33 )\n\t    \t{\n\t    \t\t\n\t   // alert(n33);\n\t   \n\t  // alert( $(\'#scaleDvI\').width() * 0.50);\n\t    \n\t        \t  \n\t        \t\t  $(this).css(\"left\" , \"70%\");\n\t        \t\t // alert(\"70\");\n\t        \t\t  document.getElementById(\"SB\").value = \"Desc\";\n\t        \t\t  \n\t        \t  \n\t    \t}\n\t    \tif(touchleft > n99)\n\t    \t{\n\t    \t\t $(this).css(\"left\" , \"70%\");\n\t    \t\t document.getElementById(\"SB\").value = \"Desc\";\n\t   \t\t     \n\t    \t}\n\t    \t\n\t    });\n\t    return this; \n\t};\n\t//---------slider functionality ends---------------\n\t$(\'#RoundI\').sliderControl();\n});\nfunction toggleSearchFields(togImg){\n\t$(\"#SfsSearchFields\").toggle();\n\t$(togImg).toggleClass(\"SfsTogHide\");\n\t$(togImg).toggleClass(\"SfsTogExpand\");\n}\nfunction addSpinner(){\n\tvar a = $(\"#spinnerDiv\")\t\n\tif(a.length ==0)\n\t$(\"#SfsScrollWrapper\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\nfunction removeSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\tif(a.length > 0)\n\t$(\"#spinnerDiv\").remove();\n}\n</script>\n</head>\n<body >\n\t<div class=\"SfsParent SfsParentTheme\" data-role=\"none\">\n\t<form id=\"CSsfsForm\" class=\"SfsForm\" action=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/chartsummary/AllergySfs\" method=\"post\" name=\"CSsfsForm\" id=\"CSsfsForm\">\n\t\t<div class=\"SfsParentTable\" data-role=\"none\">\n\t\t\t<div class=\"SfsParentHeaderRow\" data-role=\"none\">\n\t\t\t\t<div class=\"SfsParentHeaderCell\" data-role=\"none\">\n\t\t\t\t\t<div class=\"SfsHeaderTable SfsHeaderTheme\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick = \"cancelSfs()\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsHeaderTextCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" style = \"display:none\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"SfsParentBodyRow\" data-role=\"none\">\n\t\t\t\t<div class=\"SfsParentBodyCell\" data-role=\"none\">\n\t\t\t\t\t<div class=\"SfsBodyTable\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsBodyRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsBodySearchFieldsCol\"  id=\"SfsSearchFields\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsContainer SfsSearchFieldsContainerTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div  class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchByCodeText SfsSearchFieldTextTheme\" style=\"display:table-cell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchBySlider\" style=\"display:table-cell;vertical-align:middle;text-align:left\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  style = \"position:relative;width:70%;left:0px\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id = \"nDvParentI\" class = \"parentSfs\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div id = \"scaleDvI\" class = \"scaleSfs sfsScaleTheme\" data-role = \"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    <div data-role = \"none\" class = \"RoundSfs sfsCritRoundTheme\" id = \"RoundI\" data-count = \"I\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t<div data-role = \"none\" class = \"scaleSeparatorSfs1\"  >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t<div data-role = \"none\" class = \"scaleSeparatorSfs2\"   >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\n\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchByDescText\" style=\"display:table-cell;text-align:right;\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"SfsSearchFieldTextTheme\" style = \"position:relative;margin-right:10px\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsTextBoxContainer\" data-role=\"none\"><input type=\"text\" class=\"SfsTextBoxTheme SfsSearchText\" id=\"AllergySfsText\" name=\"AllergySfsText\" id=\"AllergySfsText\" value = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsBodyButtonTheme SfsBodyButtonLeft\" data-role=\"none\" onclick = \"clearData()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsBodyButtonTheme SfsBodyButtonRight\" data-role=\"none\" onclick = \"displayResults()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsBodyFieldsDockCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div  class=\"SfsTogHide\" onclick=\"toggleSearchFields(this)\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsBodySearchResCol\" style=\"display:table-cell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsSearchResContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderRow\" data-role=\"none\"> \n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderCodeCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderDescCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"SfsScrollWrapper\" id=\"SfsScrollWrapper\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsScroller\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"SfsSearchResRow\" data-role=\"none\" onclick = \"getSfsData(this)\" data-code = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" data-desc = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResCodeCol SfsSearchResBodyTheme SfsSearchResTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResDescCol SfsSearchResBodyTheme SfsSearchResTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"SfsSearchResRow\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResBodyTheme SfsSearchResTextTheme\" style = \"display:table-cell;width:100%\"data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"SfsSearchResRow\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResBodyTheme SfsSearchResTextTheme\" style = \"display:table-cell;width:100%\"data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<!-- Error message for duplicate selection -->\n\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"DuplicateSelection_Error\" style=\"bottom: 0px; left: 0px;display:none\">\n\t\t\t\t\t\t\t\t\t  \t \t<div class=\"formValErrorMsgTheme\" id=\"DuplicateSelection_ErrorMsg\">Record already exists for the Allergen</div>\n\t\t\t\t\t\t\t\t\t  \t </div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<input type = \"hidden\" name = \"EC\" id = \"EC\" value = \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/>\n\t\t<input type = \"hidden\" name = \"EI\" id = \"EI\" value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/>\n\t\t<input type = \"hidden\" name = \"hdnSfsType\" id = \"hdnSfsType\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/>\n\t\t<input type = \"hidden\" name = \"SC\" id = \"SC\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n\t\t<input type = \"hidden\" name = \"SB\" id = \"SB\" value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/>\n\t\t<input type = \"hidden\" name = \"AT\" id = \"AT\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/>\n\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" />\n\t\t<input type = \"hidden\" name = \"hdnPostBack\" id = \"hdnPostBack\" value = \"false\" />\n\t\t<input type = \"hidden\" name = \"title\" id = \"title\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" />\n\t\t\n\t</form>\n\t</div>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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

String eventTypeCode = "";
String eventTypeIndicator = "01";
String searchCriteria = "";
String title = "";
String searchBy = "desc";
String allergenType  = "";
String sfsType = "1";
if(request.getParameter("EC") != null)
{
	eventTypeCode = request.getParameter("EC");
}
if(request.getParameter("EI") != null)
{
	eventTypeIndicator = (String)request.getParameter("EI");
}
if(request.getParameter("SC") != null )
{
	searchCriteria = request.getParameter("SC");
}
if(request.getParameter("title") != null)
{
	title = request.getParameter("title");
}
if(request.getParameter("SB") != null)
{
	searchBy = request.getParameter("SB");
}
if(request.getParameter("AT") != null)
{
	allergenType = request.getParameter("AT");
}
if(request.getParameter("hdnSfsType") != null && !request.getParameter("hdnSfsType").equals(""))
{
	sfsType = request.getParameter("hdnSfsType");
}


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
            out.print( String.valueOf(csResBundle.getString("common.cancel") ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(csResBundle.getString("common.select") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(csResBundle.getString("common.searchBy") ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(csResBundle.getString("common.code") ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(csResBundle.getString("common.description") ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(csResBundle.getString("common.searchText") ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(csResBundle.getString("common.clear") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(csResBundle.getString("common.search") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(csResBundle.getString("common.code") ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(csResBundle.getString("common.description") ));
            _bw.write(_wl_block21Bytes, _wl_block21);

													if(request.getParameter("hdnPostBack") != null && request.getParameter("hdnPostBack").equals("true"))
													{
														SfsResponse oSfsRes = null;
														 List<SfsHo> lstSfsHO = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (SfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse())
															{
																 lstSfsHO = oSfsRes.getLstSfsHO();
																 if(lstSfsHO != null)
																 {
																	 int nLstCount = lstSfsHO.size();
																	 int nLoopcount = 0;
																	 SfsHo oSfsHO = null;
																	 if(nLstCount > 0)
																	 {
																		 for(nLoopcount = 0;nLoopcount < nLstCount;nLoopcount++)
																		 {
																			 oSfsHO  = lstSfsHO.get(nLoopcount);
																			 if(oSfsHO != null)
																			 {
																			 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(oSfsHO.getCode() ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oSfsHO.getDescription() ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(oSfsHO.getCode() ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oSfsHO.getDescription() ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
																			 }
																		 }
																	 }
																	 else
																	 {
																		 if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																			{
																			  
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oSfsRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
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
																	  
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(oSfsRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block30Bytes, _wl_block30);
 
																	}
																}
															}
														}
														
													}
												
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eventTypeCode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eventTypeIndicator));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(sfsType));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(searchBy ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(allergenType));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block39Bytes, _wl_block39);
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

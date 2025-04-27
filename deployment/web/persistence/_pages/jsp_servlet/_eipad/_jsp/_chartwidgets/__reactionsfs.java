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
import java.util.Map.Entry;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.response.ErrorInfo;

public final class __reactionsfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/ReactionSFS.jsp", 1709118022865L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>Allergy Search</title>   \n<style>\n</style>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n<script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/jquery-1.9.1.js\"></script> \n<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/jquery.mobile-1.0.1.min.js\"></script>\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/css/iPADThemeA.css\" />\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/iPADNew.css\" />\n\n<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\n\n\n</style>\n\n<script>\nvar sfsScroll;\nvar sfsArray = null;\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\nfunction loadSfsScroller() {\n\t/*\n\tsfsScroll = new iScroll(\'SfsScrollWrapper\',\n\t\t\t);\n\t*/\n\t setTimeout(function () {\n\t\t sfsScroll = new iScroll(\'SfsScrollWrapper\', {\n\t\t\t\tuseTransform: true,\n\t\t\t\tzoom: false,\n\t\t\t\tonBeforeScrollStart: function (e) {\n\t\t\t\tvar target = e.target;\n\t\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\t\t\te.preventDefault();\n\t\t\t\t}\n\t\t\t\t});\n\t\t}, 100); \n}\ndocument.addEventListener(\'DOMContentLoaded\', loadSfsScroller, false);\n$(document).ready(function () {\n\t\n\tif($(\'#SB\').val() == \"CODE\")\n\t{\n\t\t$(\'#RoundI\').css(\"left\" , \"0%\");\n\t}\n\telse\n\t{\n\t\t$(\'#RoundI\').css(\"left\" , \"70%\");\n\t}\n\t//---------Slider functionality starts---------------\n\tjQuery.fn.sliderControl = function() { \n\t    var scrollStartPos = 0; \n\t    var scrollLast = 0;\n\t    var dvleft = 100;\n\t    var n33 = 0;\n\t    var n66 = 0;\n\t    var n99 = 0;\n\t    var touchleft = 0;\n\t    var iDcount = \"1\";\n\t    var offset = null;    \n\t    $(this).bind(\'touchstart\', function(event) { \n\t        var e = event.originalEvent; \n\t        var orig = event.originalEvent;\n\t\t    var pos = $(this).position();\n\t\t    offset = {\n\t\t      x: orig.changedTouches[0].pageX - pos.left,\n\t\t      y: orig.changedTouches[0].pageY - pos.top\n\t\t     \n\t\t    };\n\t        iDcount = $(this).attr(\"data-count\");\n\t        if(iDcount == null || iDcount == \"\")\n\t        \t{\n\t        \t  iDcount = \"1\";\n\t        \t}\n\t       n33 =  $(\'#nDvParent\' + iDcount).width() * 0.50;\n\t       \n\t       n99 =  $(\'#nDvParent\' + iDcount).width() * 0.70;\n\t    }); \n\t    $(this).bind(\'touchmove\', function(event) { \n\t    \tevent.preventDefault();\n\t    \tevent.stopPropagation();\n\t    \tvar e = event.originalEvent; \n\t    \ttouchleft = e.touches[0].pageX - offset.x;\n\t    \tif(touchleft < n99 && touchleft > 0)\n\t    \t{\n\t\t    \t $(this).css(\"left\" , touchleft);\n\t\t    \t\n\t    \t}\n\t    \n\t    }); \n\t    $(this).bind(\'touchend\', function(event) { \n\t        if(touchleft < 0)\n\t        {\n\t        \t $(this).css(\"left\" , \"0%\");\n\t        \t document.getElementById(\"SB\").value = \"CODE\";\n\t  \t\t \t\n\t        }\n\t    \tif(touchleft > 0 && touchleft < n33)\n\t        {\n\t        \t \n\t         // alert(n33);\n\t        \t\t  $(this).css(\"left\" , \"0%\");\n\t        \t\t  document.getElementById(\"SB\").value = \"CODE\"; \n\t        }\n\t    \t\n\t    \tif(touchleft > n33 )\n\t    \t{\n\t    \t\t\n\t   // alert(n33);\n\t   \n\t  // alert( $(\'#scaleDvI\').width() * 0.50);\n\t    \n\t        \t  \n\t        \t\t  $(this).css(\"left\" , \"70%\");\n\t        \t\t // alert(\"70\");\n\t        \t\t  document.getElementById(\"SB\").value = \"Desc\";\n\t        \t\t  \n\t        \t  \n\t    \t}\n\t    \tif(touchleft > n99)\n\t    \t{\n\t    \t\t $(this).css(\"left\" , \"70%\");\n\t    \t\t document.getElementById(\"SB\").value = \"Desc\";\n\t   \t\t     \n\t    \t}\n\t    \t\n\t    });\n\t    return this; \n\t};\n\t//---------slider functionality ends---------------\n\t$(\'#RoundI\').sliderControl();\n});\nfunction displayResults()\n{\n\tvar SC = document.getElementById(\"AllergySfsText\").value;\n\tif(SC != null && SC != \"\")\n\t{\n\t\tSC = SC.replace(\"\'\", \"\\\'\");\n\t}\n\tdocument.getElementById(\"SC\").value = SC;\n\tdocument.getElementById(\"hdnPostBack\").value = \"true\";\n\tdocument.getElementById(\"CSsfsForm\").submit();\n}\nfunction clearData()\n{\n\t$(\'#SB\').val(\"desc\");\n\t$(\'#RoundI\').css(\"left\" , \"70%\");\n\t$(\'#AllergySfsText\').val(\"\");\n}\nfunction getSelectedDetails()\n{\n\t//unchecking other check box if no text was entered in it\n\tif(($(\"#chkOther\").is(\':checked\')) && ($(\'#SfsOthersText\').val().trim() == \"\")){\n\t\t$(\"#chkOther\").attr(\"checked\" , false);\n\t\t$(\"#chkOther\").attr(\"data-isOtherChecked\" , \"F\");\n\t}\n\tvar sfsDataArr = [];\n\t$(\"[data-isChecked = \'T\']\").each(function(index, value) {\n\t\t//alert($(this).checked);\n\t\t//var bCheck = $(this).attr(\"checked\");\n\t\t//alert(bCheck)\n\t\t\n\t\t\tvar code = $(this).attr(\"data-code\");\n\t\t\tvar desc = $(\"[data-rel = \'\"+code +\"\']\").html();\n\t\t\t\n\t\t\tvar sfsObject = new Object();\n\t\t\tsfsObject.code = code;\n\t\t    sfsObject.desc = desc; \n\t\t    sfsObject.sfsType = $(\'#hdnSfsType\').val();//document.getElementById(\"hdnSfsType\").value;\n\t\t    sfsDataArr.push(sfsObject);\n\t\t  \t//alert(code);\n\t\t    //alert(desc);\n\t\t\n\t});\n\n\tif(document.getElementById(\"chkOther\").checked)\n\t{\n\t\tvar sfsObject = new Object();\n\t\tsfsObject.code = \"Oth\";\n\t\tsfsObject.desc = $(\'#SfsOthersText\').val();\n\t\t\n\t\tsfsObject.sfsType = $(\'#hdnSfsType\').val();//document.getElementById(\"hdnSfsType\").value;\n\t    sfsDataArr.push(sfsObject);\n\t}\n\twindow.parent.getReactionSfsDetails(sfsDataArr);\n\t//sfsArray = sfsDataArr;\n}\nfunction getSfsDataArray()\n{\n\treturn sfsArray;\n}\nfunction selectReaction(obj)\n{\n\t//alert(obj.checked)\n\tif(obj.checked)\n\t{\n\t\tvar arrReactioncode = window.parent.returnReactionCode();\n\t\tvar bAddReaction =  true;\n\t\tif(arrReactioncode != null && arrReactioncode.length > 0)\n\t\t{\n\t\t   var i = 0;\n\t\t   var arrLength = arrReactioncode.length;\n\t\t   var code = $(obj).attr(\"data-code\");\n\t\t   for(i =0 ; i < arrLength; i ++)\n\t\t   {\n\t\t\t   if(arrReactioncode[i] == code)\n\t\t\t   {\n\t\t\t\t   bAddReaction = false;\n\t\t\t\t   $(obj).attr(\"checked\" , false);\n\t\t\t\t\t$(\"#DuplicateSelection_Error\").show();\n\t\t\t\t\tsetTimeout(function(){\n\t\t\t\t\t\t$(\"#DuplicateSelection_Error\").hide();\n\t\t\t\t\t},5000);\n\t\t\t\t\t$(\"#DuplicateSelection_Error\").bind(\'click\',function(){\n\t\t\t\t\t\t$(this).hide();\n\t\t\t\t\t});\n\t\t\t\t   break;\n\t\t\t   }\n\t\t   }\n\t\t}\n\t\tif( bAddReaction )\n\t\t  $(obj).attr(\"data-isChecked\" , \"T\");\n\t}\n\telse\n\t{\n\t\t$(obj).attr(\"data-isChecked\" , \"F\");\n\t}\n\tif($(\"[data-isChecked = \'T\']\").length > 0){\n\t\tenableSfsSelectButton();\n\t}\n\telse if($(\"[data-isChecked = \'T\']\").length <= 0 && $(\"[data-isOtherChecked = \'T\']\").length <= 0) {\n\t\tdisableSfsSelectButton()\n\t}\n}\nfunction cancelSfs()\n{\n\twindow.parent.sfsCancel();\n}\nfunction activateOtherReactions(chkObj){\n\tif($(chkObj).is(\":checked\") == true){\n\t\t$(chkObj).attr(\"data-isOtherChecked\" , \"T\");\n\t\t$(\"#SfsOthersText\").removeClass(\"SfsDullElement\");\n\t\t$(\"#SfsOthersText\").removeAttr(\"disabled\");\n\t\t//if the others text box contains any value\n\t\tenableSfsSelectButton();\n\t}\n\telse{\n\t\t$(\"#SfsOthersText\").addClass(\"SfsDullElement\");\n\t\t$(\"#SfsOthersText\").attr(\"disabled\",\"disabled\");\n\t\t$(chkObj).attr(\"data-isOtherChecked\" , \"F\");\n\t\tif($(\"[data-isChecked = \'T\']\").length <= 0){\n\t\t\tdisableSfsSelectButton();\n\t\t}\n\t}\n}\n\nfunction enableSfsSelectButton(){\n\t$(\"#SfsSelectReactsButton\").removeClass(\"SfsHeaderButtonDisableTheme\").addClass(\"SfsHeaderButtonTheme\");\n\t$(\"#SfsSelectReactsButton\").attr(\"onclick\", \"getSelectedDetails()\");\n}\n\nfunction disableSfsSelectButton(){\n\t$(\"#SfsSelectReactsButton\").removeClass(\"SfsHeaderButtonTheme\").addClass(\"SfsHeaderButtonDisableTheme\");\n\t$(\"#SfsSelectReactsButton\").attr(\"onclick\", \"\");\n}\nfunction toggleSearchFields(togImg){\n\t$(\"#SfsSearchFields\").toggle();\n\t$(togImg).toggleClass(\"SfsTogHide\");\n\t$(togImg).toggleClass(\"SfsTogExpand\");\n}\n\n</script>\n\n</head>\n<body >\n\t<div class=\"SfsParent SfsParentTheme\" data-role=\"none\">\n\t<form id=\"CSsfsForm\" class=\"SfsForm\" action=\"\" method=\"post\" name=\"CSsfsForm\" id=\"CSsfsForm\">\n\t\t<div class=\"SfsParentTable\" data-role=\"none\">\n\t\t\t<div class=\"SfsParentHeaderRow\" data-role=\"none\">\n\t\t\t\t<div class=\"SfsParentHeaderCell\" data-role=\"none\">\n\t\t\t\t\t<div class=\"SfsHeaderTable SfsHeaderTheme\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsHeaderRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonTheme\" data-role=\"none\" onclick = \"cancelSfs()\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsHeaderTextCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsHeaderButtonCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsHeaderButton SfsHeaderButtonDisableTheme\" id=\"SfsSelectReactsButton\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t\t<div class=\"SfsParentBodyRow\" data-role=\"none\">\n\t\t\t\t<div class=\"SfsParentBodyCell\" data-role=\"none\">\n\t\t\t\t\t<div class=\"SfsBodyTable\" data-role=\"none\">\n\t\t\t\t\t\t<div class=\"SfsBodyRow\" data-role=\"none\">\n\t\t\t\t\t\t\t<div class=\"SfsBodySearchFieldsCol\" id=\"SfsSearchFields\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsContainer SfsSearchFieldsContainerTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%;height:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div  class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchByCodeText SfsSearchFieldTextTheme\" style=\"display:table-cell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchBySlider\" style=\"display:table-cell;vertical-align:middle;text-align:left\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div  style = \"position:relative;width:70%;left:0px\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id = \"nDvParentI\" class = \"parentSfs\" data-role = \"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div id = \"scaleDvI\" class = \"scaleSfs sfsScaleTheme\" data-role = \"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div class=\"sliderSfsInsTheme sliderSfsIns\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    <div data-role = \"none\" class = \"RoundSfs sfsCritRoundTheme\" id = \"RoundI\" data-count = \"I\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t   \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t<div data-role = \"none\" class = \"scaleSeparatorSfs1\"  >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t<div data-role = \"none\" class = \"scaleSeparatorSfs2\"   >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\n\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchByDescText\" style=\"display:table-cell;text-align:right;\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class = \"SfsSearchFieldTextTheme\" style = \"position:relative;margin-right:10px\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldTextTheme\" data-role=\"none\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchFieldsPaddedRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsTextBoxContainer\" data-role=\"none\"><input type=\"text\" class=\"SfsTextBoxTheme SfsSearchText\" id=\"AllergySfsText\" name=\"AllergySfsText\" id=\"AllergySfsText\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsHLineTheme\" data-role=\"none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:bottom;\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table;width:100%\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsBodyButtonTheme SfsBodyButtonLeft\" data-role=\"none\" onclick = \"clearData()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsBodyButtonTheme SfsBodyButtonRight\" data-role=\"none\" onclick = \"displayResults()\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsBodyFieldsDockCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div  class=\"SfsTogHide\" onclick=\"toggleSearchFields(this)\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"SfsBodySearchResCol\" style=\"display:table-cell\" data-role=\"none\">\n\t\t\t\t\t\t\t\t<div class=\"SfsSearchResContainer\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResOthersContainer SfsSearchResOthersContainerTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderRow\" data-role=\"none\"> \n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderCodeCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResHeaderDescCol SfsSearchResHeaderTheme SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsScrollWrapperWithOthers\" id=\"SfsScrollWrapper\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsScroller\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResCodeCol SfsSearchResBodyTheme SfsSearchResTextTheme\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsChkBoxTheme1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" data-code = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" data-check = \"T\" data-isChecked = \"F\" onclick = \"selectReaction(this)\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsReacChkBoxLabel\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResDescCol SfsSearchResBodyTheme SfsSearchResTextTheme\" data-role=\"none\" data-rel = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"SfsSearchResRow\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResBodyTheme SfsSearchResTextTheme\" style = \"display:table-cell;width:100%\"data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  <div class=\"SfsSearchResRow\" data-role=\"none\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResBodyTheme SfsSearchResTextTheme\" style = \"display:table-cell;width:100%\"data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div><!-- table end -->\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<!-- Error message for duplicate selection -->\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"formValWarningTheme formValError\" id=\"DuplicateSelection_Error\" style=\"bottom: 0px; left: 0px;display:none\">\n\t\t\t\t\t\t\t\t\t\t  \t \t<div class=\"formValErrorMsgTheme\" id=\"DuplicateSelection_ErrorMsg\">Record already exists for the Reaction</div>\n\t\t\t\t\t\t\t\t\t\t  \t </div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResTable\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResRow\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResOthersfillCol\">\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResOthersChkCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsChkBoxTheme2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" id = \"chkOther\" onchange=\"activateOtherReactions(this)\" data-isOtherChecked = \"F\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label for=\"chkOther\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResOthersLabelCol SfsSearchFieldTextTheme\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SfsSearchResOthersTxtBoxCol\" data-role=\"none\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"SfsOthersText\" class=\"SfsTextBoxTheme SfsOthersTextBox SfsDullElement\" data-role = \"none\" type=\"text\" name=\"SfsOthersText\" id=\"SfsOthersText\" disabled=\"disabled\" />\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t</div>\n\t\t<input type = \"hidden\" name = \"EC\" id = \"EC\" value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/>\n\t\t<input type = \"hidden\" name = \"EI\" id = \"EI\" value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\n\t\t<input type = \"hidden\" name = \"hdnSfsType\" id = \"hdnSfsType\" value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/>\n\t\t<input type = \"hidden\" name = \"SC\" id = \"SC\" value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/>\n\t\t<input type = \"hidden\" name = \"SB\" id = \"SB\" value = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"/>\n\t\t<input type = \"hidden\" name = \"AT\" id = \"AT\" value = \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n\t\t<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value = \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" />\n\t\t<input type = \"hidden\" name = \"hdnPostBack\" id = \"hdnPostBack\" value = \"false\" />\n\t\t<input type = \"hidden\" name = \"title\" id = \"title\" value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" />\n\t</form>\n\t</div>\n\n</body>\n</html>\n\n";
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
String sfsType = "3";
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
            out.print( String.valueOf(csResBundle.getString("common.cancel") ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(csResBundle.getString("common.select") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(csResBundle.getString("common.searchBy") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(csResBundle.getString("common.code") ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(csResBundle.getString("common.description") ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(csResBundle.getString("common.searchText") ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(csResBundle.getString("common.clear") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(csResBundle.getString("common.search") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(csResBundle.getString("common.code") ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(csResBundle.getString("common.description") ));
            _bw.write(_wl_block20Bytes, _wl_block20);

													if(request.getParameter("hdnPostBack") != null && request.getParameter("hdnPostBack").equals("true"))
													{
														SfsResponse oSfsRes = null;
														// List<SfsHo> lstSfsHO = null;
														 Iterator<Entry<String, String>> iter = null;
														if(request.getAttribute("SfsResponse") != null)
														{
															oSfsRes = (SfsResponse)request.getAttribute("SfsResponse");
															if(oSfsRes != null && oSfsRes.isSuccessResponse() && !oSfsRes.isEmptyDataResponse())
															{
																 //lstSfsHO = oSfsRes.getLstSfsHO();
																 if(oSfsRes.getoSfsMap() != null)
																 {
																	 iter = oSfsRes.getoSfsMap().entrySet().iterator();
																 }
																 if(iter != null)
																 {
																
																	 while (iter.hasNext()) {
																		 Map.Entry<String, String> mEntry = (Map.Entry<String, String>) iter.next();
																		 String code = (String)mEntry.getKey();
																		 String value = (String)mEntry.getValue();
																			 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(value ));
            _bw.write(_wl_block27Bytes, _wl_block27);
 
																	 }	
																		 
																	 
																	 
																 }
																 else
																 {
																	 if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																		{
																		  
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oSfsRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
																		}
																 }
															}
															else
															{
																if(oSfsRes != null)
																{
																	if(oSfsRes.getErrorsList() != null && oSfsRes.getErrorsList().size() > 0)
																	{
																	  
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(oSfsRes.getErrorsList().get(0).getErrorMessage() ));
            _bw.write(_wl_block31Bytes, _wl_block31);
 
																	}
																}
															}
														}
														
													}
												
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(csResBundle.getString("common.other") ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(eventTypeCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(eventTypeIndicator));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(sfsType));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(searchCriteria));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(searchBy ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(allergenType));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(title ));
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

package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eIPAD.IPADConstants;
import java.util.Date;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eIPAD.pendingresults.*;

public final class __ipadbasepage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IpadBasePage.jsp", 1738426036563L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1_0 ="\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>EM Application</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\n\n \n <!--  \n<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css\" />  \n\n\n<link rel=\"stylesheet\" href=\"../css/iPadBasePage.css\" />  \n<link rel=\"stylesheet\" href=\"../css/ipad.css\" />\n\n\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n<script src=\"http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js\"></script> \n\n-->\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n\n\n<link rel=\"stylesheet\" href=\"../css/iPadBasePage.css\" />  \n<link rel=\"stylesheet\" href=\"../css/ipad.css\" />\n\n\n   \n\n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script> \n\n\n <!--  <script type=\"text/javascript\" src=\"iscroll-lite.js\"></script> \n <Script Language=\"JavaScript\" src=\"../eCommon/js/common.js\"></Script>\n <script type=\'text/javascript\' src=\"../eCommon/js/DateUtils.js\"></script>\n mootools-core-1.4.5-full-compat.js\n  -->\n<!--  <script src=\"mootools-core-1.4.5-full-compat.js\"></script>  -->\n\n\n\n<script type=\"text/javascript\">\n\n\n</script>\n\n<script type=\"text/javascript\">\nfunction scrolTop()\n{\n\t  //alert(\"helloj\");\n\t  $.mobile.silentScroll(-2000);\n}\n/*\nwindow.addEventListener(\"load\",function() {\n\t// Set a timeout...\n\t//alert(\"hi\");\n\tsetTimeout(function(){\n\t\t// Hide the address bar!\n\t\twindow.scrollTo(0, 1);\n\t}, 0);\n});\n\n*/\n//$.pageLoading();\n/*\n$(\"#page1\").bind(\"pagecreate\", function() {\n\t// Asynchronously include a footer template\n//$.mobile.loadingMessage = \'Loading...\';\t\nshowLoadingMsg();\n//alert(\"hit\");\n\t})\n*/\n//---------end---------\n/*\n $(document).bind(\"swipe\", function(event, data){\n\t //alert(\"hi\")\n\tevent.preventDefault();\t\n });\n*/\n $(document).bind(\"mobileinit\", function () {\n     // As of Beta 2, jQuery Mobile\'s Ajax navigation does not work in all cases (e.g.,\n     // when navigating from a mobile to a non-mobile page, or when clicking \"back\"\n     // after a form post), hence disabling it.\n    // $.mobile.ajaxEnabled = false;\n      $.mobile.loadingMessage = \'Loading...\';\n     // alert(\"hi\");\n\n });\n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \n <script>\n /*\n$(document).bind(\"mobileinit\", function(){\n  $.mobile.touchOverflowEnabled = true;\n});\n */\n /*\n var theScroll;\n var ifrScroll;\n\n function scroll() {\n    // theScroll = new iScroll(\'wrapper\');\n      theScroll = new iScroll(\'ulUsers\', {\n    \t\t//snap: true,\n    \t\t//momentum: false,\n    \t\thScrollbar: false});\n    \t\t//vScrollbar: false });\n\n    // ifrScroll = new iScroll(\'divcnt\');\n     \n }\n*/\n //document.addEventListener(\'DOMContentLoaded\', scroll, false);\n\n</script>\n<script>\n\nvar bclick = false;\nvar bShPatients = true;\nvar bShUsers = true;\n//frameloaded();\n    $(document).ready(function () {\n    \t//$.mobile.touchOverflowEnabled = true;\n    \t  $(document).bind(\"swipe\", function(event, data){\n    \t\t// alert(\"hiii\")\n    \t\tevent.preventDefault();\t\n    \t });\n    \t /*\n    \t  if (window.DeviceOrientationEvent) {  window.addEventListener(\'orientationchange\', myOrientResizeFunction, false);}\n    \t  \n    \t  function myOrientResizeFunction(orientation){     \n    \t\t // alert(Math.abs(window.orientation));\n    \t\t \n    \t\t   var orient = Math.abs(window.orientation) === 90 ? \'landscape\' : \'portrait\';\n    \t\t    \n    \t\t  }\n    \t */ \n    \t\n    \t/*\n    \t  $.mobile.orientationChangeEnabled = true;\n    \t \n    \t  $(\"#page1\").bind(\"orentationchange\", function(orientation) {\n    \t\t\talert(\"hellooo\");\n    \t\t});\n    \t \n    \t  */\n    \t\n    \t// $(\'#divView\').load(\'AppView.jsp\', function() {\n   \t\t // alert(\'Load was performed.\');\n   \t\t//});\n    \t// scroll();\n    \t// theScroll = null;\n  /*\n    \t $(document).scroll(function(){\n\t\t// alert(\"hig\");\n         if ($(window).scrollTop() + $(window).height() -20 == $(document).height() -20 )\n         {\n             \n           document.getElementById(\"selectionFromFrame\").contentWindow.test();\n            // $(\'#divView\').append(document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML);\n             //document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML =  document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML +  document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML;\n         }\n     });\n   \t*/\n    \t//theScroll.destroy();\n//alert(window.screen.availWidth);\n    \t //-----------------------\n    \t \n    \tjQuery.fn.oneFingerScroll = function() { \n    \t    var scrollStartPos = 0; \n    \t    var scrollLast = 0;\n    \t    $(this).bind(\'touchstart\', function(event) { \n    \t        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get \'touches\' \n    \t        var e = event.originalEvent; \n    \t       // alert($(this).scrollTop() );\n    \t        scrollStartPos = $(this).scrollTop() + e.touches[0].pageY;\n    \t       // scrollLast = event.touches[0].pageY;\n\n    \t     //   $(\'#divscr\').html (\"scroostartpos111=\" + scrollStartPos );\n    \t       // e.preventDefault(); \n    \t    }); \n    \t    $(this).bind(\'touchmove\', function(event) { \n    \t        var e = event.originalEvent; \n    \t       // alert(scrollStartPos - e.touches[0].pageY);\n    \t      //  $(this).scrollTop(scrollStartPos - e.touches[0].pageY);\n    \t       //$(this).scrollSpeed (event.touches[0].pageY-scrollLast);\n    \t       var nscroll = (scrollStartPos - e.touches[0].pageY) ;\n    \t       if(nscroll == $(document).height()){\n    \t    \t   nscroll = e.touches[0].pageY;\n    \t       }\n    \t     /*\n    \t            if(nscroll > 0)\n    \t    \t   {\n    \t            \tnscroll = nscroll * 3;\n    \t    \t   }\n    \t            else\n    \t            \t{\n    \t            \tnscroll = nscroll / 3;\n    \t            \t}\n    \t      \n    \t         */   \n    \t      $(this).scrollTop(nscroll); \n    \t     // $(\'#divscr\').append (\"<br>\" +  \"scroostartpos=\" + scrollStartPos + \"pagey=\" + e.touches[0].pageY + \"scrolltop=\" + $(this).scrollTop() + \"</br>\");\n    \t     // $(\'#divscr\').append (\"<br>\" +  \"windowtop=\" + $(window).scrollTop() + \"windowheight=\" + $(window).height() + \"documentheight=\" + $(document).height() + \"</br>\");\n    \t     // alert( e.touches[0].pageY);\n    \t      //alert(scrollStartPos);\n    \t    //  scrollStartPos = e.touches[0].pageY;\n    \t        e.preventDefault(); \n    \t    }); \n    \t    return this; \n    \t}; \n\n    \t \n    //\t$(\'#wrapper\').oneFingerScroll(); \n    //\t$(\'#ul1\').oneFingerScroll(); \n    \t \n    \t //---------------------------\n    \t jQuery.fn.scrollStop = function() { \n    \t    var scrollStartPos = 0; \n    \t    var scrollLast = 0;\n    \t    $(this).bind(\'touchstart\', function(event) { \n    \t        // jQuery clones events, but only with a limited number of properties for perf reasons. Need the original event to get \'touches\' \n    \t        var e = event.originalEvent; \n    \t       \n    \t       // e.preventDefault(); \n    \t    }); \n    \t    $(this).bind(\'touchmove\', function(event) { \n    \t        var e = event.originalEvent; \n    \t       \n    \t        e.preventDefault(); \n    \t    }); \n    \t    return this; \n    \t}; \n    \t //-----------------------\n    \t/* \n $(\'#selectionFromFrame\').one(\'readyState\', function(){\n        \n    \t  alert(\'loaded\');  \n    \t})\n     \n*/\n\n\t\t$(\'#tdToggle\').tap(function(){\n\t\t\thideFooter();\n\t\t\tslidee(\"false\");\n\t\t\tshowIcon();\n\t\t});\n\n\n\t/*\n\t\t$(\'#tdToggle\').touchstart(function(){\n\t\t\t//alert(\"ghg\");\n\t\t\tif(bclick)\n\t\t\t\t{\n\t\t\t\tdocument.getElementById(\"imgIcon\").src =\"../images/Arrow-Close-Touch.png\" \n\t\t\t\t}\n\t\t\telse\n\t\t\t\t{\n\t\t\t\t  document.getElementById(\"imgIcon\").src =\"../images/Arrow-Open-Touch.png\" \n\t\t\t\t}\n\t\t\t\n\t\t\t\n\t\t});\n\t\t\n\t\t\n\t\t$(\'#tdToggle\').touchend(function(){\n\t\t\t//alert(\"end\");\n\t\t\tslidee(\"false\");\n\t\t\t//document.getElementById(\"imgIcon\").src =\"Arrow-Open-Normal.png\"\n\t\t\tshowIcon();\n\t\t\t\t\n\t\t\t\n\t\t});\n\t\t \n\t\t*/\n\t\t//$(\'#tabSlide\').tap(function () {\n\t\t\t//$(\'#tdimg\').css(\"background-color\", \"white\");\n\t\t\t//alert(\'hi\');\n\t\t\t\n\t\t//\t$(\'#wrapper\').load(function() {    \n\t\t\t//document.getElementById(\"wrapper\").style.height = \"354px\"; //(document.body.offsetHeight -30) + \'px\';\n\t\t\t//alert($(window).height());\n\t\t\t//alert($(document).height());\n\t\t\t//alert(document.body.offsetHeight);\n\t\t\t\n\t\t\t\n\t\t\t//}\n\t\t\t//); \n\t\t    //document.addEventListener(\'DOMContentLoaded\', scroll, false);\n\t\t   \n\t\t\t//slidee(\"false\");\n\t\t   /*\n\t\t\tif(!bclick)\n\t\t\t\t{\n\t\t\t      $(\'#divcontent\').animate({width:\"32%\"},\'fast\');\n\t\t          $(\'#dvmain\').animate({left:\"32%\"},\'fast\');\n\t\t         // $(\'#divframe\').scrollStop();\n\t\t\n\t\t          bclick = true;\n\t\t\t\t}\n\t\t\telse\n\t\t\t\t{\n\t\t          $(\'#divcontent\').animate({width:\"0%\"},\'fast\');\n\t\t          $(\'#dvmain\').animate({left:\"0%\"},\'fast\');\n\t\t        //  $(\'#divframe\').unbind(\"touchmove\");\n\t\t          bclick = false;\n\t\t\t\t}\n\t\t   // $(\'#dvmain\').animate({width:\"20%\"});\n\t\t  //  $(\'#dvmain\').animate({float:right});\n\t\t  */\n\t\t\n\t\t       // }); \n\t\t        \n\t\t       \n\t\t\n\t\t \n\t\t/*\n\t\t$(\'#menu3\').click(function () {\n\t\t\ttabmain\n\t\t\ttdslide\n\t\t    $(\'#div3\').slideToggle(\'fast\');\n\t\t        })\n\t\t*/\n\t\t        //----\n\t\t        /*\n\t\t        $(\'#div1\').live(\"swipe\", function() {\n\t\t        \t// Get the current page number from the id and increment it by 1.\n\t\t        \t//alert(\'hi\');\n\t\t        \t});\n\t\t        */\n  }); //end of document ready\n    function slidee111(strChild)\n    {\n    //\t$(\'#tdimg\').animate({backgroundcolor:\"white\"},500);\n    \tif(strChild == \"true\")\n    \t\t{\n    \t\tbclick = true;\n    \t\t}\n    \tif(!bclick)\n\t\t{\n    \t\t//scroll();\n        \t// theScroll = null;\n        \t//document.getElementById(\"divView\").style.position = \"fixed\";\n        \t//document.getElementById(\"wrapper\").style.position = \"fixed\";\n        \t//document.getElementById(\"page1\").style.position = \"fixed\";\n        //\tstyle = \"position:fixed\"\n           //   $(\'#divheader\').animate({width:\"100%\"},\'fast\');\n\t      $(\'#divcontent\').animate({width:\"35%\"},\'fast\');\n\t    \t\n          $(\'#dvmain\').animate({left:\"35%\"},\'fast\');\n          $(\'#dvmain\').animate({width:\"65%\"},\'fast\');\n        //  $(\'#tdimg\').css(\"background-color\", \"#2088cf\");\n      //  $(\'#tdimg\').animate({backgroundcolor:\"#2088cf\"},20);\n         // $(\'#dvmain\').animate({width:\"80%\"},\'fast\');\n         \n        //  $(\'#divframe\').scrollStop();\n\n          bclick = true;\n\t\t}\n\telse\n\t\t{\n\t\t//document.getElementById(\"wrapper\").style.position = \"\";\n\t\t//document.getElementById(\"divView\").style.position = \"\";\n\t\t//document.getElementById(\"page1\").style.position = \"\";\n          $(\'#divcontent\').animate({width:\"0%\"},\'fast\');\n       \n          $(\'#dvmain\').animate({left:\"0%\"},\'fast\');\n          $(\'#dvmain\').animate({width:\"100%\"},\'fast\');\n        //  $(\'#divhe";
    private final static byte[]  _wl_block1_0Bytes = _getBytes( _wl_block1_0 );

    private final static java.lang.String  _wl_block1_1 ="ader\').animate({width:\"100%\"},\'fast\');\n        //  $(\'#tdimg\').css(\"background-color\", \"#2088cf\");\n           // $(\'#tdimg\').animate({backgroundcolor:\"#2088cf\"},20);\n          //$(\'#divframe\').unbind(\"touchmove\");\n          if( theScroll != null)\n        \t  {\n                //theScroll.destroy();\n        \t  }\n          bclick = false;\n\t\t}\n  }\n\n  function slidee(strChild) {\n     \n\t // hideFooter();\n      if (strChild == \"true\") {\n          bclick = true;\n      }\n      if (!bclick) {\n          /*\n          $(\'#divcontent\').animate({ width: \"35%\" }, \'fast\');\n          */\n         // $(\'#dvmain\').animate({ left: \"35%\" }, \'fast\');\n         // $(\'#dvmain\').animate({float: \"right\" }, \'fast\');\n         \n        $(\'#dvmain\').animate({ left: \"30%\" }, \'fast\');\n          $(\'#dvmain\').animate({ width: \"70%\" }, \'fast\');\n         $(\'#divcontent\').animate({ width: \"30%\" }, \'fast\');\n        // $(\'#divcontent\').animate({ left: \"0%\" }, \'fast\');\n         \n          //alert(\"hii\");\n       //  document.getElementById(\"divcontent\").style.display = \"block\";\n          bclick = true;\n         // document.getElementById(\"divView\").style.position = \"fixed\";\n          \n        //  $(\'#divcontent\').slideToggle(\'fast\');\n      }\n      else {\n          /*\n          $(\'#divcontent\').animate({ width: \"0%\" }, \'fast\');\n\n          $(\'#dvmain\').animate({ left: \"0%\" }, \'fast\');\n          $(\'#dvmain\').animate({ width: \"100%\" }, \'fast\');\n        \n         \n          bclick = false;\n          */\n         \t bclick = false;\n       //   $(\'#divcontent\').slideToggle(\'fast\');\n        \n\t        $(\'#divcontent\').animate({ width: \"0%\" }, \'fast\');\n\t       // $(\'#divcontent\').animate({ left: \"-31%\" }, \'fast\');\n\t          $(\'#dvmain\').animate({ width: \"100%\" }, \'fast\');\n\t         // document.getElementById(\"divView\").style.position = \"\";\n\t            //$(\'#divcontent\').slideToggle(\'fast\');\n         // $(\'#dvmain\').css(\"float\",\"right\");\n         // $(\'#dvmain\').animate({float: \"right\" }, \'fast\');\n      }\n     showFooter();\n  }\n    function showUsersList() {\n        //  $(\"#td1\").hide(\"medium\");\n        $(\"#dvUsersList\").toggle(\"fast\");\n    }\n    function showDivPatList() {\n        //  $(\"#td1\").hide(\"medium\");\n      //  alert();\n        $(\"#dvPatList\").toggle(\"fast\");\n      //  touchScroll(\"wrapper\");\n    }\n    function showLoadingMsg()\n    {\n    \t //$.mobile.loadingMessage = \'Loading...\';\n    \t//hideFooter();\n    \t$.mobile.pageLoading();\n    }\n    function HideLoadingMsg()\n    {\n    \t// showFooter();\n    \t $.mobile.pageLoading(true);\n    }\n    function showOP()\n    {\n    \t/*\n    \t$(\'#divframe\').load(\'AppView.jsp\', function() {\n    \t\t  alert(\'Load was performed.\');\n    \t\t});\n    \t*/\n    \t\n    \t//$(\'#divframe\').html(\"hello\")\n    \t//$(\'#divframe\').html($(\'#selectionFromFrame\').html());\n    \t//alert(document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML)\n    \t\n    \t//$(\'#divframe\').html(document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML);\n    \t//theiFrameObject.contentDocument.body.innerHTML\n    \t//document.getElementById(\"divframe\").innerHTML = \"LOADING........\"\n    \t// document.getElementById(\"selectionFromFrame\").src=\"AppView.jsp\";\n    \t \n    \t //document.getElementById(\"divframe\").innerHTML = document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML;\n    \t// alert(document.getElementById(\"divframe\").innerHTML);\n    \t//alert(document.body.height);\n      //eve   document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML = \"\";//\"LOADING OutPatients.......\"\n          \n        // $.mobile.showPageLoadingMsg();\n         \n         showLoadingMsg();\n\n\n    \t//eve document.getElementById(\"selectionFromFrame\").src=\"OP.jsp\";\n    \t \n    \t \n    \t /*\n    \t $(\'#divframe\').load(\'AppView.jsp\',\n    \t \n    \t\t\t function() {\n    \t\t  \n    \t\t});\n    \t */\n    \t// alert(document.getElementById(\"selectionFromFrame\").readyState);\n    \t/*\n    \t if (document.getElementById(\"selectionFromFrame\").readyState == \"complete\"){       \n    \t\t alert(\"Iframe is now loaded.\");  \n    \t\t document.getElementById(\"divframe\").innerHTML = document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML;\n    \t\t \n    \t } \n    \t*/\n    \t \n    \t \n    \tslidee(\"false\");\n    \t\n    \tshowIcon();\n    \t\n    \t//frameloaded();\n    \t//alert($(this));\n    \t// $(this).removeClass(\"ui-btn-active\").addClass(\"ui-btn-hover-a\");\n    \t //.addClass(\'ui-state-disabled\'); \n    \t\n    }\n    function showIcon()\n    {\n    \tif(bclick)\n    \t{\n    \tdocument.getElementById(\"imgIcon\").src =\"../images/Arrow-Close-Normal.png\" ;\n    \t}\n    else\n    \t{\n    \t  document.getElementById(\"imgIcon\").src =\"../images/Arrow-Open-Normal.png\" ;\n    \t}\n    }\n    function showIP()\n    {\n    \t//alert(\"hello\")\n    \t//$(this).highlight(\'#ddf\');\n    \tvar x = 100;\n    //\tvar folioChange = new Fx.Tween(\'aIP\', {duration:1200});\n    \t//folioChange.start(\'left\',x);\n    \t//folioChange.highlight(\'#ddf\', \'#ccc\');\n         document.getElementById(\"hdnPatClass\").value = \"IP\";\n         document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML = \"<div style=\'height:1000px\'>&nbsp;</div>\";\n         //$.mobile.loadingMessage = \'loading\';\n          showLoadingMsg();\n    \t document.getElementById(\"selectionFromFrame\").src=\"IP.jsp\";\n    \t/*\n    \t $(\'#divView\').load(\'IP.jsp\', function() {\n  alert(\'Load was performed.\');\n    });\n    \t*/ \n    \tslidee(\"false\");\n    \tshowIcon();\n    \t//document.getelementById(\"divView\").style.height = \"auto\";\n    \t//frameloaded();\n    \n    \t\n    }\n    \n    function showAppList()\n    {\n    \t//document.getElementById(\"divframe\").innerHTML = \"LOADING........\"\n    \t //$(this).css(\"background-color\", \"#eeeeee\");\n    \t//document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML = \"\";\n    \tshowLoadingMsg();\n    \t//document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML = \"<table border = \'1\' style=\'width:100%;height;1000px\'><tr style=\'width:100%;height;1000px\'><td style=\'width:100%;height;100%\' align = \'center\' valign = \'Bottom\'>LOADING AppointmentList.......</td></tr></table>\"\n    //\tdocument.getElementById(\"selectionFromFrame\").src=\"AppView.jsp\";\n    \t\tslidee(\"false\");\n    \t\tshowIcon();\n    \t\t//$(this).highlight(\'#ddf\');\n\n    \t/*\n    \t\t$(\'#divframe\').load(\'AppView.jsp\', function() {\n      \t\t  alert(\'Load was performed.\');\n      \t\t});\n    \t*/\n    \t\t//$(\'#divframe\').append(document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML);\n    \t/*\n    \t$(\'#divframe\').append(\"<div id = \'divcnt\' data-role = \'content\' class = \'divcontent\' > <ul data-role=\'listview\' >  <li class =\'ui-btn-text-data\' ><a href=\'#\' ><img src=\'hanuman-blessing.jpg\'></img> <summary><span class=\'lz-list-label-Patient\'>Rtntest50a Rtntest50b  Rtntest50c</span>&nbsp;&nbsp;&nbsp;<span class = \'eh-pat-id\'>G200001058</span></summary><ul style=\'list-style-type: none\'> <li class=\'leftUl\'> <p> <span class=\'lz-list-label\'></span><span class=\'lz-list-data\'> &nbsp;</span></p> </li> </ul><ul style=\'list-style-type: none\' ><li class=\'leftUl\'><p><span class=\'lz-list-label\'>Appt No: &nbsp;</span><span class=\'lz-list-data\'>15559</span></p><p><span class=\'lz-list-label\'>Practitioner:&nbsp;</span><span class=\'lz-list-data\'>Afida Bt Khalib, Dr ,Afida Bt</span></p></li> </ul> </a></li></ul></div>\");\n    \t\tdocument.getElementById(\"divframe\").style.display = \"block\";\n    \t\tdocument.getElementById(\"selectionFromFrame\").style.display = \"none\";\n    \t\t*/\n    \t\n    \t//frameloaded();\n    \t\t\n    }\n   \n   function frameloaded()\n   {\n\t  // $(\'#selectionFromFrame\').ready(function(){\n\t\t  // alert(\"hi\");\n\t\t//  $.mobile.pageLoading(true);\n\t\t  // document.getElementById(\"divframe\").innerHTML = document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML;\n\t\t   //alert(document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML);\n\t\t\t//alert(\'loaded\');\n\t\t\t//alert(document.getElementById(\"selectionFromFrame\").contentDocument.body.offsetHeight);\n\t\t\t//documnet.getElementByID(\"divView\").style.height = document.getElementById(\"selectionFromFrame\").contentDocument.body.offsetHeight;\n\t\t\t//$(\'#divframe\').append(document.getElementById(\"selectionFromFrame\").contentDocument.body.innerHTML);\n\t\t\t//alert(document.getElementById(\"divframe\").innerHTML);\n\t  //  });\n   }\n   function logOff()\n   {\n\t   var \txmlHttpObj;\n\t   if (navigator.appName.indexOf(\"Internet\") == -1) {\n\t\t\txmlHttpObj = new XMLHttpRequest();\n\t\t\t//var oParser = new DOMParser();\n\t\t\t//xmlDoc = oParser.parseFromString(xmlStr, \"text/xml\");\n\t\t} else {\n\t\t\txmlHttpObj = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t\t//xmlDoc = new ActiveXObject(\"Microsoft.XMLDom\");\n\t\t\t//xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t}  \n\t\t\n\t   xmlHttpObj.open(\"POST\", \"../jsp/Logoff.jsp\", true);\n\t   xmlHttpObj.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t   var sendString = \"logoff=true\";\n\t   xmlHttpObj.send(sendString);\n   }\n   \n   function logout()\n   {\n\t   logOff();\n\t   window.location =\"../html/loginIpad.html\";\n   }\n   function showPatients()\n   {\n\t //  $(\'#ulwrapper\').toggle(\'fast\');\n\t   \n\t   $(\"#ulwrapper\").toggle(\"fast\");\n\t   \n\t   if(!bShPatients)\n\t   {\n\t\t\t   bShPatients = true;\n\t\t\t   document.getElementById(\"imgPat\").src = \"../images/Heading-Panel-Up-Arrow.png\" ;\n\t   }\n\t   else\n\t   {\n\t\t\t   bShPatients = false;\n\t\t\t   document.getElementById(\"imgPat\").src = \"../images/Heading-Panel-down-Arrow.png\";\n\t   }\n\t   \n   }\n   function showUsers()\n   {\n\t //  $(\'#ulwrapper\').toggle(\'fast\');\n\t   \n\t   $(\"#ulUsers\").toggle(\"fast\");\n\t   \n\t   if(!bShUsers)\n\t\t   {\n\t\t   bShUsers = true;\n\t\t   document.getElementById(\"imgUsers\").src = \"../images/Heading-Panel-Up-Arrow.png\" ;\n\t\t   }\n\t   else\n\t\t   {\n\t\t   bShUsers = false;\n\t\t   document.getElementById(\"imgUsers\").src = \"../images/Heading-Panel-down-Arrow.png\";\n\t\t   }\n\t   \n   }\n   function showFirstPage()\n   {\n\t showLoadingMsg();\n\t \n\t // code added to check if the request parameters passed and \n\t // stored as hidden variable is not empty\n\t var hdnParamComp = document.getElementById(\"hdnParams\");\n\t var params = \"\";\n\t if(hdnParamComp){\n\t\t params = hdnParamComp.value;\n\t }\n\t \n\t if(params.length > 0){\n\t\t document.getElementById(\"selectionFromFrame\").src = \"PendingResults.jsp?\"+params;\n\t\t HideLoadingMsg();\n\t }else{\n\t\t document.getElementById(\"selectionFromFrame\").src = \"IP.jsp\";\t \n\t\t slidee(\"false\");\n\t\t showIcon();\n\t }\n\t \t \n\t \n\t\t //document.body.style.scrollbarBaseColor=\'#E2E3F0\';\n   }\n   function loadwidgets(patientID,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)\n   {\n\t  // alert(episodeId);\n\t   document.getElementById(\"hdnPatientId\").value = patientID;\n\t   document.getElementById(\"hdnEpisodeId\").value = episodeId;\n\t   document.getElementById(\"hdnAdmitDat";
    private final static byte[]  _wl_block1_1Bytes = _getBytes( _wl_block1_1 );

    private final static java.lang.String  _wl_block1_2 ="e\").value = admitDate;\n\t   document.getElementById(\"hdnDischargeDateTime\").value = dischargeDateTime;\n\t   document.getElementById(\"hdnLocnType\").value = locnType;\n\t   document.getElementById(\"hdnLocnCode\").value = locnCode;\n\t   document.getElementById(\"hdnServiceCode\").value = servicecode;\n\t  // alert(document.getElementById(\"hdnPatientId\").value);\n\t   document.getElementById(\"frmIcontent\").submit();\n   }\n   function showFooter()\n   {\n\t   document.getElementById(\"divFooter\").style.display = \"block\";\n   }\n   function hideFooter()\n   {\n\t   document.getElementById(\"divFooter\").style.display = \"none\";\n   }\n   \n   function showPendingResults(){\n\t   var fromPeriodComp = document.getElementById(\"hdnFromPeriod\");\n\t   var fromPeriodVal=\"\";\n\t   if(fromPeriodComp){\n\t\t   fromPeriodVal=fromPeriodComp.value;\n\t   }\n\t   \n\t   var toPeriodComp = document.getElementById(\"hdnToPeriod\");\n\t   var toPeriodVal=\"\";\n\t   if(toPeriodComp){\n\t\t   toPeriodVal=toPeriodComp.value;\n\t   }\n\t   \n\t   var selectedPeriodComp = document.getElementById(\"hdnSelectedPeriod\");\n\t   var selectedPeriod;\n\t   if(selectedPeriodComp){\n\t\t   selectedPeriod = selectedPeriodComp.value;\n\t   }\n\t   \n\t   var taskApplicabilityComp = document.getElementById(\"hdnTaskApplicability\");\n\t   var taskApplicability;\n\t   if(taskApplicabilityComp){\n\t\t   taskApplicability = taskApplicabilityComp.value;\n\t   }\n\t   \n\t   var groupbyComp = document.getElementById(\"hdnGroupby\");\n\t   var groupby;\n\t   if(groupbyComp){\n\t\t   groupby = groupbyComp.value;\n\t   }\n\t   var caNormalcyIndComp = document.getElementById(\"hdnCANormalcyInd\");\n\t   var caNormalcyInd;\n\t   if(caNormalcyIndComp){\n\t\t   caNormalcyInd = caNormalcyIndComp.value;\n\t   }\n\t   \n\t   var pagesrc = \"PendingResultsCriteria.jsp?fromPeriod=\"+fromPeriodVal+\"&toPeriod=\"+toPeriodVal;\n\t   pagesrc = \"PendingResults.jsp?hdnFromPeriod=\"+fromPeriodVal+\"&hdnToPeriod=\"+toPeriodVal+\"&hdnGetTaskApplicability=\"+taskApplicability+\"&hdnGroupby=\"+groupby+\"&hdnNormalcyVal=\"+caNormalcyInd+\"&hdnSelectedPeriod=\"+selectedPeriod;\n\t   document.getElementById(\"selectionFromFrame\").src=pagesrc;\n\t   slidee(\"false\");\n   \t\tshowIcon();\n   }\n   \n   function showPreviousResults(url,parameters){\n\t   var hdnMainPageUrlComp = document.getElementById(\"hdnMainPageURL\");\n\t   if(hdnMainPageUrlComp){\n\t\t   hdnMainPageUrlComp.value = url;\n\t   }\n\t   var mainPageUrl = \"iPadWidget.jsp\";\n\t   mainPageUrl += \"?\";\n\t   //var actionurl = url + \"?\" + parameters;\n\t   //alert(actionurl);\n\t  // mainPageUrl += \"hdnMainPageURL=\"+actionurl;\n\t   mainPageUrl += \"hdnMainPageURL=\"+url;\n\t   \n\t   var paramComp = document.getElementById(\"hdnParams\");\n\t   if(paramComp){\n\t\t   paramComp.value = parameters;\n\t   }\n\t   \n\t   // code added to set the patient id and episode id\n\t   // to the ipadwidget.jsp\n\t   var patientIdIndex = parameters.indexOf(\"hdnPatientid\");\n\t   var equalToIndex = parameters.indexOf(\"=\",patientIdIndex);\n\t   var amperIndex = parameters.indexOf(\"&\",equalToIndex);\n\t   var patientIdValue = parameters.substring(equalToIndex+1,amperIndex);\n\t   \n\t   var patientIdComp = document.getElementById(\"hdnPatientId\");\n\t   if(patientIdComp){\n\t\t   patientIdComp.value = patientIdValue;\n\t   }\n\t   \n\t   var episodeIdIndex = parameters.indexOf(\"hdnEpisodeId\");\n\t   equalToIndex = parameters.indexOf(\"=\",episodeIdIndex);\n\t   amperIndex = parameters.indexOf(\"&\",equalToIndex);\n\t   var episodeIdValue = parameters.substring(equalToIndex+1,amperIndex);\n\t   \n\t   var episodeIdComp = document.getElementById(\"hdnEpisodeId\");\n\t   if(episodeIdComp){\n\t\t   episodeIdComp.value = episodeIdValue;\n\t   }\n\t   \n\t   var hideIconComp = document.getElementById(\"hdnHideIcon\");\n\t   if(hideIconComp){\n\t\t   hideIconComp.value = \"Y\";\n\t   }\n\t   \n\t   //alert(\'complete page url=\'+mainPageUrl);\n\t   //document.getElementById(\"frmIcontent\").action = mainPageUrl;\n\t   document.getElementById(\"frmIcontent\").submit();\n   }\n   \n    </script>\n\n</head> \n<body onload = \"showFirstPage()\"> \n\t<section id=\"page1\" data-role=\"page\"  style = \"padding:0px;width:100%;background:#ffffff;top:0px\"> \n\t\t <form id=\"frmIcontent\" method = \"post\" action = \"iPadWidget.jsp\">\n\t\t <header data-role=\"header\"  style=\"height:65px;padding:0px;border:0px\">\n\t\t\t<div id = \"divheader\" class=\"dvheader\"  data-role=\"none\"  >\n\t\t\t\n\t\t\t\t<table border = \"0\" style = \"width:100%;height:auto\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\n\t\t\t\t\t<tr  class=\"trTitle\"align = \"center\">\n\t\t\t\t\t \n\t\t\t\t\t\t<td align = \"left\" style =\"width:33%\" nowrap = \"false\"><span class=\"spTitle\">Enterprise Management-12.0.2</span></td>\n\t\t\t\t\t\t<td align = \"center\" style =\"width:34%\"><span class=\"spFooter2\">";
    private final static byte[]  _wl_block1_2Bytes = _getBytes( _wl_block1_2 );

    private final static java.lang.String  _wl_block2 ="</span></td>\n\t\t\t\t\t\t<td align = \"right\" style =\"width:33%\"><span class=\"spFooter3\" id = \"spaDate\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</span>\n\t\t\t\t\t\t \n\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</table>\n\t\t\t\t\t<table border = \"0\" style = \"width:100%;height:auto;border-top:1px solid #474747\" cellpadding = \"0\" cellspacing = \"0\">\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr class=\"trIcon\">\n\t\t\t\t\t\t<td align = \"left\" style =\"width:33%\" id =\"tdToggle\"><img src = \"../images/Arrow-Open-Normal.png\" class=\"imgIcon\" id=\"imgIcon\"></img></td>\n\t\t\t\t\t\t<td align = \"center\" style =\"width:34%\"></td>\n\t\t\t\t\t\t<td align = \"right\" style =\"width:33%\" >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<img src = \"../images/Logout.png\" class=\"imgLogout\" onclick = \"logout()\"></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t </header>\n\t\t\n\t\t<div    class=\'content\' id=\'divcontent\' scrolling = \"auto\" style=\"padding:0px\">\n\t\t\t<div   id = \"wrapper\" style =\"display:block;padding:0px\" data-role = \"none\">\n\t\t\t   \t<div  class=\"dvPatients\" data-role = \"none\" onclick= \"showPatients()\">\n\t\t\t   \n\t\t\t   \t\n\t\t\t   \t\t <table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t    <td style = \"width:85%\">\n\t\t\t\t\t\t         <span class = \"spanPatients\">Patients</span>\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t    <td style = \"width:13%\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t        \t<img src = \"../images/Heading-Panel-Up-Arrow.png\"  id=\"imgPat\" ></img>\t\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t    <td style = \"width:2%\">\n\t\t\t\t\t\t      &nbsp;\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t    \n\t\t\t\t\t\t  </tr>\n\t\t    \t\t</table>\n\t\t\t   \t\n\t\t\t   \t</div>\n\t\t\t    <div class = \"dvStroke\"></div>\n\t\t\t\t<div style=\"height:auto\" id = \"ulwrapper\">\n                    <table border = \"0\" cellpadding = \"0\" cellspacing = \"0\" class = \"menuTable\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\" onclick = \"showIP()\">\n                           <span class=\"spMenu\">In-Patients</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                        <div  data-role=\"none\" class=\"countIcon\">\n                         ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n                          </div>\n                          <!--  <div style=\"height:20px;width:30px;border-radius:10px;background:black\">10</div>  --> \n                        </td>\n                       </tr>\n                     </table>\n                     \n                     <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\">\n                           <span class=\"spMenu\">Out-Patients</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                          <!--   <div style=\"height:20px;width:30px;border-radius:10px;background:black\">10</div>  -->\n                        </td>\n                      </tr>\n                    </table>\n                    \n                    <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\">\n                           <span class=\"spMenu\">Day Care</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                       \n                        </td>\n                      </tr>\n                    </table>\n                    \n                    <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\">\n                           <span class=\"spMenu\">Emergency</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                        \n                        </td>\n                      </tr>\n                    </table>\n                    \n                    <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\">\n                           <span class=\"spMenu\">Recently Accessed</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                         \n                        </td>\n                      </tr>\n                    </table>\n                    \n                     <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\">\n                           <span class=\"spMenu\">Consultations</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                         \n                        </td>\n                      </tr>\n                    </table>\n                    \n                     <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\">&nbsp;</td>\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:55%\" valign = \"middle\">\n                           <span class=\"spMenu\">Self</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                         \n                        </td>\n                      </tr>\n                    </table>\n                    \n                     <table class = \"menuTable\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\">&nbsp;</td>\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:55%\" valign = \"middle\">\n                           <span class=\"spMenu\">Speciality</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                         \n                        </td>\n                      </tr>\n                    </table>\n                    \n                </div>\n\t\t\t\t<div   class=\"dvPatients\" data-role = \"none\" >\n\t\t\t\t<!--  <span class=\"spanPatients\">Users</span>\n\t\t\t\t<img src = \"Heading-Panel-down-Arrow.png\" class = \"imgPat\" id=\"imgUsers\"></img>\n\t\t\t\t-->\n\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t    <td style = \"width:85%\">\n\t\t\t\t\t\t         <span class = \"spanPatients\">Users</span>\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t    <td style = \"width:13%\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t        \t<img src = \"../images/Heading-Panel-Up-Arrow.png\"  id=\"imgPat\" ></img>\t\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t    <td style = \"width:2%\">\n\t\t\t\t\t\t      &nbsp;\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t    \n\t\t\t\t\t\t  </tr>\n\t\t    \t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<!-- \n\t\t\t\t<div style = \"height:580px\">\n\t\t\t\t  &nbsp;\n\t\t\t\t</div>\n\t\t\t\t -->\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\t \n\t\t\t\t \n\t\t\t\t<div style=\"height:auto\" id = \"userulwrapper\">\n\t\t\t\t  <table border = \"0\" cellpadding = \"0\" cellspacing = \"0\" class = \"menuTable\">\n                      <tr class = \"trMenu\">\n                        <td style=\"width:14%\" valign = \"middle\" align = \"center\">\n                          <img src=\"../images/Navigation Icons.png\" class=\"imgIcon\"></img> \n                        </td>\n                         <td style=\"width:69%\" valign = \"middle\" onclick = \"showPendingResults()\">\n                           <span class=\"spMenu\">Pending Results Review</span>\n                        </td>\n                        <td style=\"width:17%\" valign = \"middle\" align = \"center\">\n                          <div class=\"countIcon\" data-role=\"none\">\n                          <span>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n                          </div>\n                          <!--  <div style=\"height:20px;width:30px;border-radius:10px;background:black\">10</div>  --> \n                        </td>\n                       </tr>\n                     </table>\n\t\t\t\t</div> \n\t\t     </div>  \n\t\t</div>\n\t\t<div class =\'divmain\' id = \'dvmain\'   style=\"padding:0px;background-color : #ffffff\">\n\t\t     <div id = \"divView\"   style = \"width:100%;height:auto;overflow:auto;padding:0px\" data-role =\"none\"> \n\t\t   \n\t\t        \n\t\t\t  <iframe frameborder=\"0\" id=\"selectionFromFrame\" src=\"\" \n\t\t\t            width=\"100%\"   height = \"1050px\" scrolling =\"yes\" style = \"display:block\"></iframe>\n\t\t      \n\t\t\n\t\t      </div>         \n\t\t</div>\n\t\t  <footer data-role = \"footer\"   style=\"padding:0px;height:20px\">  \n\t\t    <div id = \"divFooter\" class=\"dvFooter\"    data-role = \"none\"> \n\t\t\t\t<table border = \"0\" style = \"width:100%;height:100%\" cellpadding = \"0\" cellspacing = \"0\" class=\"tbFooter\">\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t<td align = \"left\" style =\"width:30%\" valign=\"top\"><span class=\"spFooter1\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="-";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span></td>\n\t\t\t\t\t\t<td align = \"right\" style =\"width:64%\" valign=\"top\"><span class=\"spFooter2\">Copyright 2012 Computer Sciences Corporation - All rights reserved</span></td>\n\t\t\t\t\t\t<td align = \"right\" style =\"width:6%\" valign=\"top\"><img src=\"../images/CSC_Logo.png\" class=\"imgTitle\"></img></td>\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t   </div> \n\t\t  </footer> \n\t\t<input type = \"hidden\" name = \"hdnPatientId\" id = \"hdnPatientId\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnEpisodeId\" id = \"hdnEpisodeId\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnAdmitDate\" id = \"hdnAdmitDate\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnDischargeDateTime\" id =  \"hdnDischargeDateTime\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnLocnType\" id =  \"hdnLocnType\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnLocnCode\" id =  \"hdnLocnCode\" value = \"\" />\n\t\t<input type = \"hidden\" name = \"hdnServiceCode\" id =  \"hdnServiceCode\" value = \"\" />\n\t<!-- This is added for sending the from and to period in pending review results page -->\n\t\t<input type = \"hidden\" name= \"hdnFromPeriod\" id=\"hdnFromPeriod\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>\n\t\t<input type = \"hidden\" name= \"hdnToPeriod\" id=\"hdnToPeriod\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>\n                <input type=\"hidden\" name=\"hdnTaskApplicability\" id=\"hdnTaskApplicability\" id=\"hdnTaskApplicability\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnGroupby\" id=\"hdnGroupby\" id=\"hdnGroupby\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n<input type=\"hidden\" name=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnMainPageURL\" id=\"hdnMainPageURL\" id=\"hdnMainPageURL\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"hdnParams\" id=\"hdnParams\" id=\"hdnParams\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnPatClass\" id=\"hdnPatClass\" id=\"hdnPatClass\" value=\"IP\"/>\n\t\t<input type=\"hidden\" name=\"hdnHideIcon\" id=\"hdnHideIcon\" id=\"hdnHideIcon\" value=\"\"/>\n\t\t</form>\n\t</section>\n\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt=null,pstmt1=null; 
ResultSet rset =null,rsip=null,rset1=null;
Statement stmt = null,stmt1 = null;
String strIPCount = "";
// this code is added specifically for pending results for review
String fromPeriod="";
String toPeriod="";
String selectedPeriod=IPADConstants.LAST_ONE_WEEK;
StringBuffer sqlipcount = new StringBuffer("");

// code modified to get the request parameters in the flow
// of pending results review
String params = request.getQueryString();
params = CommonBean.checkForNull(params);

try{
	String facility_id= (String)session.getValue("facility_id");
    String login_user= (String)session.getValue("login_user");
    String facility_name = "";
    String jdbc_user =  "";
	String jdbc_user_id="";
	String site = "" ;
	if(login_user == null)
	{
		login_user = "";
	}
	String strFromdate = DateUtils.getCurrentDate("DMY", "en");
	String sql= "select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) reln_req_yn from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P' ";
    String func_role_id="",practitioner_name="",pract_type="";
    con =  ConnectionManager.getConnection(request);
    if(con != null)
    pstmt=con.prepareStatement(sql);
    
    String locale = "en";
    if(pstmt != null)
    {
		pstmt.setString(1,locale);
		pstmt.setString(2,login_user);
		
		rset=pstmt.executeQuery();
    }
	
	if(rset !=null && rset.next())
    {
		func_role_id=rset.getString("func_role_id");
		if(func_role_id == null) func_role_id="";
        
		practitioner_name=rset.getString("practitioner_name");
		if(practitioner_name == null) practitioner_name="";
		
		pract_type = rset.getString("pract_type");
		if(pract_type == null) pract_type="";

    }
	if(rset !=null) rset.close();
	if (pstmt!=null) pstmt.close();
	
	 session.putValue("ca_practitioner_id",func_role_id);
	 session.putValue("practitioner_name",practitioner_name);
	 session.putValue("practitioner_type",pract_type);
	 
	 if(con != null)
	 stmt = con.createStatement();
	 
	 rset = null;
	// site = "hi";
	 if(stmt != null)
	 {
	   rset = stmt.executeQuery("SELECT SITE_NAME,DISPLAY_USER_NAME_YN FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' and 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = '"+facility_id+"')") ;//Changed  for PE By Sudhakar
	   //site = "hello";
	 }
	 
	 
	 
	 String display_user_name_yn = "";		 
		if(rset !=null)	{
			if(rset.next()) {
				site = rset.getString("SITE_NAME");
				display_user_name_yn= rset.getString("DISPLAY_USER_NAME_YN");//Changed  for PE By Sudhakar
				
			}
		}
		session.putValue("userSite",site);	
		if(rset !=null) rset.close();
		if (stmt!=null) stmt.close();
		
	    if(con != null)
		pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
	    
	    
		if(pstmt != null)
		{
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,login_user);
			rset = pstmt.executeQuery();
		}
		

		if(rset !=null)	{
			if(rset.next()) {
				jdbc_user = rset.getString("APPL_USER_NAME");
				jdbc_user_id = rset.getString("APPL_USER_ID");
				facility_name = rset.getString("FACILITY_NAME");
			}
		}
		session.putValue("facility_name",facility_name);
		session.putValue("jdbc_user",jdbc_user);
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
		
sqlipcount.append("SELECT COUNT (*) Total FROM ip_open_encounter a WHERE a.facility_id = '"+facility_id+"' AND attend_practitioner_id = '"+func_role_id+"' AND patient_class = 'IP'  AND adt_status IN ('00', '01')  AND EXISTS ( SELECT patient_class FROM ca_pract_by_locn_detail o  WHERE facility_id = '"+facility_id +"' AND practitioner_id = '"+ func_role_id +"' ");
sqlipcount.append(" AND locn_type = 'W' AND patient_class = 'IP' AND EXISTS ( SELECT 1   FROM pr_encounter a, mp_patient mp_p WHERE NVL (mp_p.suspend_yn, '*') != 'Y'  AND mp_p.patient_id = a.patient_id  AND a.assign_care_locn_code = o.locn_code AND a.facility_id = o.facility_id AND a.patient_class = o.patient_class AND a.attend_practitioner_id = '"+ func_role_id +"' AND (a.adt_status IN ('01', '02')))) ");
			
if(con != null)
{
	 stmt1 = con.createStatement();
}
		
		if(stmt1 != null)
		{
			rsip = stmt1.executeQuery(sqlipcount.toString());
		}
		if(rsip != null)
		{
			
			if(rsip.next())
			{
				
				strIPCount = rsip.getString("Total");
			
			}
			rsip.close();
			if ( stmt1 != null ) stmt1.close() ;
			session.putValue("practitioner_id",func_role_id);
			
		}		
	 					
    

            _bw.write(_wl_block1_0Bytes, _wl_block1_0);
            _bw.write(_wl_block1_1Bytes, _wl_block1_1);
            _bw.write(_wl_block1_2Bytes, _wl_block1_2);
            out.print( String.valueOf(jdbc_user));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(strFromdate  ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(strIPCount ));
            _bw.write(_wl_block4Bytes, _wl_block4);

// the below code is for pending review results
PendingResults pendingResults = new PendingResults();
// initialize the request and set it with data
PendingResultsCountRequest countRequest = new PendingResultsCountRequest();
countRequest.setRequest(request);
countRequest.setSession(session);
countRequest.setPractitionerId(func_role_id);
Calendar cal = Calendar.getInstance();
Date toDate = cal.getTime();
cal.add(Calendar.DATE, -7);
Date fromDate = cal.getTime();
countRequest.setFromDate(fromDate);
countRequest.setToDate(toDate);

// get the response
PendingResultsCountResponse countResponse = pendingResults.getPendingResultsCount(countRequest);
// process the response
Map<PendingResultCategory, Integer> pendingResultCountMap = countResponse.getPendingResultCountMap();
int totalPendingResults = 0;

if(pendingResultCountMap != null){
	PendingResultCategory pendingResultCategory = new PendingResultCategory(
			PendingResultCategory.TOTAL_CATEGORY);
	Object totalCount = pendingResultCountMap.get(pendingResultCategory);
	Set<PendingResultCategory> keySet = pendingResultCountMap.keySet();
	if(keySet != null){
		Iterator<PendingResultCategory> itr = keySet.iterator();
		if(itr != null){
			while(itr.hasNext()){
				pendingResultCategory = itr.next();
				if(PendingResultCategory.TOTAL_CATEGORY.equals(pendingResultCategory.getCategoryName())){
					totalCount = pendingResultCountMap.get(pendingResultCategory);
					break;
				}
			}
		}
	}
	if(totalCount instanceof Integer){
		totalPendingResults = ((Integer)totalCount).intValue();
	}
}

// code added to get the task applicability value
// which is passed to the pending results screen
String taskApplicability = "";
TaskApplicablityRequest taskRequest = new TaskApplicablityRequest();
taskRequest.setMenu("VIEW_CONF_RESULT");
taskRequest.setRequest(request);
taskRequest.setSession(session);
String resp_id = (String)session.getValue("responsibility_id");
if(resp_id== null){
	resp_id = "";
}
taskRequest.setResponsibilityId(resp_id);
String practRelationId = "";// this is the value passed in desktop app also
taskRequest.setPract_relationId(practRelationId);

TaskApplicabilityResponse taskResponse = pendingResults.getTaskApplicability(taskRequest);
taskApplicability = taskResponse.getMenuValue();

// this variable is of use for showing pending results
// in desktop application also, the group by value is being passed as "P"
// to pending results screen
String groupBy = "P";
// this refers to the normalcy index which is passed to the pending results
// screen
String ca_normalcy_ind = "Z";		


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(totalPendingResults ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(facility_name ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(site));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fromPeriod));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(toPeriod));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(taskApplicability));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(groupBy));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ca_normalcy_ind));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selectedPeriod));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(params));
            _bw.write(_wl_block15Bytes, _wl_block15);


}
    catch(Exception e){
		e.printStackTrace();
		out.println("Exception in IpadBasePage.jsp"+e.toString());
    }
    finally{
        if (rset !=null) rset.close();
		if (pstmt!=null) pstmt.close();
		if (stmt!=null) stmt.close();
		if (rsip!=null) rsip.close();
		if (stmt1!=null) stmt1.close();
        if (con !=null) ConnectionManager.returnConnection(con,request);
		

    }

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}

package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Date;
import com.google.gson.Gson;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import eOR.*;
import eOR.Common.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

public final class __registerorderlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/RegisterOrderList.jsp", 1709118031724L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>RegisterOrder View</title> \n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\n\n\n<link rel=\"stylesheet\" href=\"../css/iPadNew_IP.css\" />  \n<link rel=\"stylesheet\" href=\"../css/iPADThemeA.css\" /> \n<link rel=\"stylesheet\" href=\"../css/iPADNew.css\" />  \n<script src=\"../jquery-1.9.1.min.js\"></script>  \n\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n\n\n<script type=\"text/javascript\">\n\nfunction loaderInd() {\n\t/* setTimeout(function () {\n\t\t parent.legendsScroll = new iScroll(\'legendWrapper\');\n\t}, 100); */\n\t\n} \n\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\ndocument.addEventListener(\'DOMContentLoaded\', loaderInd, false);\n\n\n\nvar header_borderheight= 90;\nvar content_height;\n\nvar scrollContent1 ;\nvar scrollNav;\nvar ArrayOfPats=[];\nvar ArrayOfEncounter=[];\n\nfunction loaded1() {\n\tsetTimeout(function () {\n\t\t//parent.scrollContent1 = new iScroll(\'divcnt\');\n\t\t// fix to make the check boxes work inside iscroll\n\t\tparent.scrollContent1 = new iScroll(\'divcnt\', {\n\t\t\tuseTransform: true,\n\t\t\tzoom: false,\n\t\t\tonBeforeScrollStart: function (e) {\n\t\t\tvar target = e.target;\n\t\t\twhile (target.nodeType != 1) target = target.parentNode;\n\n\t\t\tif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\' )\n\t\t\te.preventDefault();\n\t\t\t}\n\t\t\t});\n\t}, 100);\n\t}\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\ndocument.addEventListener(\'DOMContentLoaded\', loaded1, false);\n\nvar indicatorTypeScroll;\n\n $(document).ready(function () {\n\t parent.setIframeHeight();\n    $(\'#txtPatientId\').bind(\'keypress\', function(e) {\n        if (e.which == 32){\n          \n        \tRegisterOrderFormSubmit();\n        }\n        if (e.which == 13){            \n        \tRegisterOrderFormSubmit();\n        }\n        \n\t});\n   \n    $(\"#btnsfs\").bind(\'touchstart\', function(event) { \n       \n        var e = event.originalEvent; \n      \n        var scrollStartPos =  e.touches[0].pageY;\n     \n        scrollStartPos = scrollStartPos ;\n      \n        var tleft = e.touches[0].pageX - \"15\"\n    \n         $(\"#sfs\").css(\'z-index\', \"1000\");\n         $(\"#sfsarrow\").css(\'z-index\',\"1000\");\n     \n    }); \n    \n    //Applying selected style to the current normalcy\n\tvar currentPrioritySelected = document.getElementById(\"hdnPriority\").value;\n\t//alert(currentNormalcySelected);\n\t\n\tif(currentPrioritySelected == \"R\")\n\t\t$(\'#PriorityRoutine\').removeClass(\'prContentHolderIconTheme\').addClass(\'prContentHolderSelectedIconTheme\');\n\telse if(currentPrioritySelected == \"U\")\n\t\t$(\'#PriorityUrgent\').removeClass( \'prContentHolderIconTheme\').addClass( \'prContentHolderSelectedIconTheme\');\n\telse if (currentPrioritySelected == \"S\")\n\t\t$(\'#PriorityStat\') .removeClass(\'prContentHolderIconTheme\').addClass( \'prContentHolderSelectedIconTheme\');\n\telse \n\t\t$(\'#PriorityAll\').removeClass(\'prContentHolderIconTheme\').addClass(\'prContentHolderSelectedIconTheme\');\n\t\n\tvar orderCat = $(\"#hdnOrderCat\").val();\n\tif(!orderCat){\n\t\t$(\"#LOMDiv\").hide();\n\t}\n\t\n\tvar transactionOccurred = $(\"#hdnTransactionOccurred\").val();\n\tif(transactionOccurred == \'true\'){\n\t\tshowTransactionMessage();\n\t}\n\t\n });\n \n\n \n \n function changeOrientation(orient, HFheight)\n {\n \tcontent_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight;\n\tdocument.getElementById(\"divcnt\").style.height = content_height+\"px\";\n\t\n\tif(parent.scrollContent1 != null)\n\tparent.scrollContent1.refresh();\n }\n\n\n function toggleLegend(){\n\t\n\t $(\'#legendContainer\').toggle(); \n\t var totalWidth = 0;\n\t $(\'#legendScroller .legendTabs\').each(function(index) {\n     totalWidth += parseInt($(this).outerWidth());\n   \t});\n\t$(\'#legendScroller\').css(\"width\",(totalWidth+90)+\'px\');\n\t\n\tsetTimeout(function () {\n\t\tparent.legendsScroll.refresh();\n    }, 0);\t\n\t\n }\n\n\n \n function refresh(){\n\t $(\"#PageLoadingAnimation\").show();\n\t document.getElementById(\"hdnOrderCat\").value = \"\";\n\t document.getElementById(\"hdnOrderType\").value = \"\";\n\t document.getElementById(\"hdnOrderCatDesc\").value = \"\";\n\t document.getElementById(\"hdnOrderTypeDesc\").value = \"\";\n\t document.getElementById(\"hdnPriority\").value = \"\";\n\t document.getElementById(\"hdnSelectedPeriod\").value = \"LOW\";\n\t document.getElementById(\"hdnTransactionOccurred\").value = \"false\";\n\t document.getElementById(\"hdnTransactionMsg\").value = \"\";\n\t document.getElementById(\"hdnTransactionResult\").value = \"\";\n\t document.getElementById(\"RegisterOrderForm\").submit();\n }\n function refreshAfterTransaction(){\n\t $(\"#PageLoadingAnimation\").show();\n\t document.getElementById(\"hdnOrderCat\").value = \"\";\n\t document.getElementById(\"hdnOrderType\").value = \"\";\n\t document.getElementById(\"hdnOrderCatDesc\").value = \"\";\n\t document.getElementById(\"hdnOrderTypeDesc\").value = \"\";\n\t document.getElementById(\"hdnPriority\").value = \"\";\n\t document.getElementById(\"hdnSelectedPeriod\").value = \"LOW\";\n\t document.getElementById(\"hdnTransactionOccurred\").value = \"true\";\n\t document.getElementById(\"RegisterOrderForm\").submit();\n }\n function addSpinner(){\n\tvar a = $(\"#spinnerDiv\")\n\n\tif(a.length ==0)\n\t\t$(\"#divContent\").append(\"<div class=\'loadingCartItem\' id=\'spinnerDiv\'></div>\");\n}\nfunction removeSpinner(){\n\n\tvar a = $(\"#spinnerDiv\")\n\n\tif(a.length > 0)\n\t$(\"#spinnerDiv\").remove();\n}\n\nfunction selectAllRecords() {\n\n\tparentchkbox = document.getElementById(\"selectAll\");\n\t$(\"#divcnt input:checkbox\").each(function() {\n\t\tthis.checked = parentchkbox.checked;\n\t});\n}\n\nfunction showPeriodSelect() {\n\thideAddlSearch();\n\t$(\"#periodSelect\").css(\'z-index\', \"1000\");\n\t$(\"#periodArrow\").css(\'z-index\', \"2000\");\n\t$(\'#periodSelect\').toggle();\n\t$(\'#periodArrow\').toggle();\n}\nfunction hidePeriodSelect() {\n\t$(\'#periodSelect\').hide();\n\t$(\'#periodArrow\').hide();\n}\n\nfunction selectPeriod(sPeriod) {\n\tshowPeriodSelect();\n\tdocument.getElementById(\"hdnSelectedPeriod\").value = sPeriod;\n\tsearchRegisterOrders();\n}\nfunction toggleAddlSearch(){\n\thidePeriodSelect();\n\t\tvar orderCat = $(\"#hdnOrderCat\").val();\n\tvar orderCatDesc = $(\"#hdnOrderCatDesc\").val();\n\tvar orderType = $(\"#hdnOrderType\").val();\n\tvar orderTypeDesc = $(\"#hdnOrderTypeDesc\").val();\n\tdocument.getElementById(\"sfsFrame\").src = \"RegisterOrderAddlSearchCrit.jsp?hdnOrderCategory=\"+orderCatDesc+\"&hdnOrderCategoryCode=\"+orderCat+\"&hdnOrderType=\"+orderTypeDesc+\"&hdnOrderTypeCode=\"+orderType;\n\t$(\"#OrdSearchSFS\").toggle();\n}\nfunction hideAddlSearch(){\n\t$(\"#OrdSearchSFS\").hide();\n}\n\nfunction searchRegisterOrders(){\n\t$(\"#PageLoadingAnimation\").show();\n\tdocument.getElementById(\"RegisterOrderForm\").submit();\n}\nfunction selectPriority(sPriority){\n\tdocument.getElementById(\"hdnPriority\").value = sPriority;\n\tsearchRegisterOrders();\n}\nfunction toggleLegend() {\n\t$(\'#legendContainer\').toggle();\n}\nfunction loadAddlSearchOrders(orderCat,orderCatDesc, orderType,orderTypeDesc){\n\t$(\"#hdnOrderCat\").val(orderCat);\n\t$(\"#hdnOrderCatDesc\").val(orderCatDesc);\n\t$(\"#hdnOrderType\").val(orderType);\n\t$(\"#hdnOrderTypeDesc\").val(orderTypeDesc);\n\tsearchRegisterOrders();\n}\nfunction orderSelected(orderId){\n\tif ($(\"#check_\"+orderId).is(\':checked\')){\n\t\t$(\"#OrderItem_\"+orderId).addClass(\"regOrderSelectedOrder\");\n\t}else{\n\t\t$(\"#OrderItem_\"+orderId).removeClass(\"regOrderSelectedOrder\");\n\t}\n\t\n\tvar checked = $(\"#RegisterOrderForm input:checked\").length > 0;\n\tif(checked){\n\t\t$(\"#RegisterOrderActionBtn\").removeClass(\"imgGrayscale\");\n\t}else{\n\t\t$(\"#RegisterOrderActionBtn\").addClass(\"imgGrayscale\");\n\t}\n}\nfunction registerOrderAction(){\n\tvar path = $(\"#hdnPath\").val();\n\tvar checked = $(\"#RegisterOrderForm input:checked\").length > 0;\n\tif(checked){\n\t\t$(\"#PageLoadingAnimation\").show();\n\t\tvar checkedCounter = 0;\n\t\tvar actionPath = path + \'/mobile/orders/RegisterOrderJSONServlet?requestMode=RegisterOrder\';\n\t\tvar orderTransactionMsg = \"\";\n\t\t$(\"#RegisterOrderForm input:checked\").each(function () {\n\t\t\tvar orderCat = $(this).data(\"ordercat\");//orderid\n\t\t\tvar orderId = $(this).data(\"orderid\");\n\t\t\tvar orderDesc = $(this).data(\"orderdesc\");\n\t\t\tactionPath = actionPath + \"&ord_id\"+checkedCounter+\"=\"+orderId+ \"&order_category\"+checkedCounter+\"=\"+orderCat;\n\t\t\tif(orderDesc.length > 15){\n\t\t\t\torderTransactionMsg = orderTransactionMsg + orderDesc.substring(0, 15)+\"..., \";\n\t\t\t}else{\n\t\t\t\torderTransactionMsg = orderTransactionMsg + orderDesc+\", \";\n\t\t\t}\n\t\t\tcheckedCounter++;\n\t\t\t\n\t\t});\n\t\tif(orderTransactionMsg){\n\t\t\torderTransactionMsg = orderTransactionMsg.substring(0, orderTransactionMsg.length - 2);\n\t\t}\n\t\tconsole.log(actionPath);\n\t\tactionPath = actionPath + \"&total_recs=\"+checkedCounter;\n\t\t$.getJSON(actionPath).\n\t\t\tdone(function(json) {\n\t\t\t\t$(\"#hdnTransactionOccurred\").val(\"true\");\n\t\t\t\t$(\"#hdnTransactionResult\").val(\"SUCCESS\");\n\t\t\t\t$(\"#hdnTransactionMsg\").val(\"Order(s) Registered Successfully: \"+orderTransactionMsg);\n\t           refreshAfterTransaction();\n\t        })\n\t        .fail(function(jqxhr, textStatus, error) {\n\t        \t$(\"#hdnTransactionOccurred\").val(\"true\");\n\t        \t$(\"#hdnTransactionResult\").val(\"FAILURE\");\n\t        \t$(\"#hdnTransactionMsg\").val(\"Orders could not be registered. Please contact administrator\");\n\t        \t\n\t            var err = textStatus + \", \" + error;\n\t            console.log(err);\n\t            refreshAfterTransaction();\n\t        });\n\t}\n\t\n\t\n}\n\nfunction showTransactionMessage(){\n\t$(\"#transactionMsg\").show();\n\t$(\"#hdnTransactionResult\").val(\"\");\n\t$(\"#hdnTransactionOccurred\").val(\"false\");\n\t$(\"#hdnTransactionMsg\").val(\"\");\n\tsetTimeout(function(){\n\t\t$(\"#transactionMsg\").hide();\n\t},5000);\n\t$(\"#transactionMsg\").bind(\'click\',function(){\n\t\t$(this).hide();\n\t});\n}\n\n\n </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <style>\n #PageLoadingAnimation{\n\tz-index: 10000;\n\tposition: absolute;\n\tleft: 0px;\n\ttop: 0px;\n\twidth: 100%;\n\theight: 100%;\n\tbackground-color: #808080;\n\topacity: 0.6;\n\tbackground-image: url(";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n\tdisplay: none; \n}\n.loadingCartItem {\n\twidth: 100%;\n\theight: 80px;\n\tbackground-image: url(";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/images/Loading24x24.gif);\n\tbackground-repeat: no-repeat;\n\tbackground-position: 50% 50%;\n}\n.orderSearchSfs{\n\tz-index: 1000;\n\tposition: absolute;\n\tpadding: 0px;\n\ttop: 75px;\n\theight: 230px;\n\tright: 200px;\n\twidth: 345px;\n\tdisplay: block;\n\toverflow: hidden;\n}\n.regOrderPrimaryText{\n\tfont-size: 12px;\n    font-family: Arial;\n    font-weight: bold;\n    color: #333b46;\n}\n.regOrderSecText{\n\tfont-size: 12px;\n    font-family: Arial;\n    font-weight: bold;\n    color: #a3a3a3;\n}\n.regOrderSec2Text{\n\tfont-size: 12px;\n    font-family: Arial;\n    font-weight: bold;\n    color: #407d95;\n}\n.regOrderSelectedOrder{\n\tbackground: linear-gradient(to bottom, #d2f0fb 0%,#b9dbea 100%);\n}\n.imgGrayscale {\n    -webkit-filter: grayscale(1);\n    opacity: 0.7;\n}\n </style>\n </head>\n<body style= \"width:100%; height:100%;\"  >\n<div id=\"PageLoadingAnimation\" class=\"absoluteCenter\"></div>\n   \t<div id=\"OrdSearchSFS\" class=\"orderSearchSfs\" style=\"display:none;z-index:10005;top:85px;right:40px\"><!-- TODO -->\n\t\t<div id=\"sfsarrow\" data-role=\"none\" class=\"sfs-bubble-arrow sfs-bubble-arrowIPTheme\" style=\"top:75px;right:200px\"></div>\n\t\t<div data-role=\"none\" class=\"ordSfsSmall sfsIPTheme\"  style=\"display:block;height:230px;top:85px;right:45px\">\n\t\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" height=\"230px\" width=\"340px\" src=\"\"></iframe>  \n\t\t</div> \n\t</div>\n   \t\n   \t<div id = \"periodArrow\" data-role = \"none\" class = \"periodSelectArrow periodSelectArrowTheme\" style=\"right:300px\"></div>\n   \t<div data-role = \"none\" class = \"periodSelectContainer periodSelectContainerTheme\"  id = \"periodSelect\" style=\"right:230px\">\n\t\t\t<table cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LOD\')\">Last One Day</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LTD\')\">Last Three Days</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" onclick=\"selectPeriod(\'LOW\')\">Last One Week</div></td></tr>\n\t\t\t\t<tr><td><div class=\"periodSelectRowNormal periodSelectRowNormalTheme\" id=\"LOMDiv\" onclick=\"selectPeriod(\'LOM\')\">Last One Month</div></td></tr>\n\t\t\t</table>\n   \t</div> \n\t\t\n\t<div data-role = \"page\" class=\"ipListParent\" style = \"padding:0px;width:100%;height:100%;\">\n\t\t<form name=\'RegisterOrderForm\' id=\'RegisterOrderForm\' method=\'post\' id=\"RegisterOrderForm\" style = \"width:100%;height:100%;\" action=\"RegisterOrderList.jsp\">\n\t\t\t<div class =\"ipHeader\">\n\t\t\t\t<div class=\"ipHeaderMenuContainer1 ipHeaderMenuContainer1Theme\">\n\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t<td style = \"width:50px; padding-left:5px;\">\n\t\t\t        \t\t\t<div class = \"WidgetButtonTheme\" onclick=\"parent.toggleMenu()\"><img src = \"../images/MenuIcon.png\"/></div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t    \t\t\t<td style = \"width:auto\">\n\t\t\t         \t\t\t<div class = \"ipHeaderPageTitle ipHeaderPageTitleTheme\"> Register Orders List</div>\n\t\t\t   \t\t\t\t</td>\n\t\t\t\t\t   \t</tr>\n\t\t    \t\t</table>\n\t\t\t\t</div>\n\t\t\t\t<div class = \"ipHeaderMenuContainer2\">\n\t  \t\t\t\t<div  data-role =\"none\" class =\"ipContentHolderHeader ipContentHolderHeaderTheme\">\n\t\t\t\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  \t\t\t\t<tr style = \"height:100%;width:100%\">\n\t\t\t\t\t\t\t    <td style = \"min-width:60px\">\n\t\t\t\t\t\t\t         <span class = \"ipContentHolderRefreshIcon\"><img src = \"../images/Refresh_black.png\" onclick=\"refresh()\"/></span>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"min-width:60px\">\n\t\t\t\t\t\t\t         <div class = \"WidgetButtonTheme imgGrayscale\"  id=\"RegisterOrderActionBtn\" onclick=\"registerOrderAction()\"><img src = \"../images/ReviewComplete.PNG\"/></div>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"width:50%\">\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"min-width:150px\"><div class = \"prHeaderMenu2ButtonsTheme\" onclick=\"showPeriodSelect()\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</div></td>\n\t\t\t\t\t\t\t    <td style = \"min-width:60px\">\n\t\t\t\t\t\t\t         <div class = \"WidgetButtonTheme\" onclick=\"toggleAddlSearch()\"><img src = \"../images/filter20x20.png\"/></div>\n\t\t\t\t\t\t\t    </td>\n\t\t\t\t\t\t\t    <td style = \"min-width:170px\" align = \"right\" valign = \"center\">\n\t\t\t\t\t\t\t    \t<table class= \"prContentHolderIconContainer\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t\t\t\t\t    <tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"prContentHolderIconTheme\" onclick=\"selectPriority(\'\')\" id=\"PriorityAll\"><img src = \"../images/view01.png\" style=\"vertical-align: middle;\"/></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class = \"prContentHolderIconTheme\" onclick=\"selectPriority(\'R\')\" id=\"PriorityRoutine\"><div class=\"prNormalcyNormalTheme\"></div></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"prContentHolderIconTheme\" onclick=\"selectPriority(\'S\')\" id=\"PriorityStat\"><div class=\"prNormalcyAbnormalTheme\"></div></td>\n\t\t\t\t\t\t\t\t        \t<td class = \"prContentHolderIconTheme\" onclick=\"selectPriority(\'U\')\" id=\"PriorityUrgent\"><div class=\"prNormalcyCriticalTheme\"></div></td>\n\t\t\t\t\t\t\t\t        </tr>\n\t\t\t\t\t\t        \t</table>\t\n\t\t\t\t\t\t    \t</td>\n\t\t\t \t\t\t\t</tr>\n\t\t    \t\t\t</table>\t  \n\t  \t\t\t\t</div>\n\t  \t\t\t</div>\n\t  \t\t</div>\n    \t\t<div id = \"divcnt\"  class = \"divIPcontent divIPcontentTheme\" style=\"overflow:hidden\">\n\t\t\t\t<div style = \"width:100%;height:auto;overflow:auto\" >\t\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t <table cellpadding = \"0\" cellspacing = \"0\" border = \"0\" style=\"border-collapse: collapse;\">\t\n\t\t\t\t\t \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\n\t\t\t\t<!--<tr class=\"trIpRows1\" style=\"background-color:white;float:left;\"> -->\n\t\t\t\t<tr class=\"prResultsHeader\" id=\"OrderItem_";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" style=\"border:1px solid #eaedf2;background-color:white\">\n\t\t\t\t\t\t<td style=\'width: 2%\' align=\"center\" valign=\"middle\"> \n\t\t\t\t\t\t\t<div class=\"prCheckboxContainer\">\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" data-orderid=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" data-ordercat=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" data-orderdesc=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"check_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" name=\"check\" onClick=\"orderSelected(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" style=\"width:23px;height:23px\" class=\"prCheckbox prCheckboxTheme\">\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\t\n\n\t\t\t\t\t\t<td style=\"width:30%;\" >\t\n\t\t\t\t\t\t\t<table style = \"width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t <td style=\"width:100%; word-break:break-all\" colspan = \"2\" >\n\t\t\t\t\t\t\t\t\t  <!-- <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px; \"></span> -->\n\t\t\t\t\t\t\t\t\t  <span class=\"regOrderPrimaryText\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t\t\t\t\t\t </td>\t \n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td style=\"width: 36%;\">\t\n\t\t\t\t\t\t\t<table style = \"width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\" padding-left=\"10px\";>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t <td style=\"width:100%;\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t  <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px;\"></span><span class=\"lz-list-data1 lz-list-data1Theme regOrderSecText\">Order ID: </span><span class=\'regOrderPrimaryText\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</span>\n\t\t\t\t\t\t\t\t\t </td>\t \n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t<td style=\"width:100%;\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px;\" ></span><span class=\"lz-list-data1 lz-list-data1Theme regOrderSecText\">Order Type: </span><span class=\'regOrderPrimaryText\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\n\t\t\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t <td style=\"width:100%;\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t  <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px;\"></span><span class=\"lz-list-data1 lz-list-data1Theme regOrderSecText\">Start Date: </span><span class=\'regOrderPrimaryText\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span>\n\t\t\t\t\t\t\t\t\t </td>\n\t\t\t\t\t \n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t<td style=\"width:100%; colspan = \"2\"l\" >\n\t\t\t\t\t\t\t\t\t <span class=\"lz-list-label lz-list-labelTheme\" style=\"padding-left:0px;\" ></span><span class=\"lz-list-data1 lz-list-data1Theme regOrderSecText\">Priority: </span><span class=\'regOrderPrimaryText\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\n\t\t\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td style=\"width: 36%;\">\n\t\t\t\t\t\t\t <table style = \"width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t\t   \n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px\";>\n\t\t\t\t\t\t\t\t\t<td style=\"width:100%;\" colspan = \"2\" >\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t  <div class = \"txtRows txtRowsTheme regOrderPrimaryText\" style=\"padding-left:0px;\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" , <span class = \"txtRows ptIdGender \"style=\"color:#a3a3a3;font-weight: normal;padding-left:5px;\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" , ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span></div>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t<td style=\"width:100%;\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t <span class=\"lz-list-label regOrderSec2Text\" style=\"padding-left:0px;\" >Practitioner: </span><span class=\"lz-list-data1 regOrderSecText\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</span>  \n\t\t\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t<td style=\"width:100%;\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t <span class=\"lz-list-label regOrderSec2Text\" style=\"padding-left:0px;\" >Room,Bed No: </span><span class=\"lz-list-data1 regOrderSecText\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =", ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t\t </span>  \n\t\t\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr class=\"trIpChildRows\" style=\"height:20px;\">\n\t\t\t\t\t\t\t\t\t<td style=\"width:100%;\" colspan = \"2\">\n\t\t\t\t\t\t\t\t\t <span class=\"lz-list-label regOrderSec2Text\" style=\"padding-left:0px;\" >Encounter: </span><span class=\"lz-list-data1 regOrderSecText\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t\t </span>  \n\t\t\t\t\t\t\t\t   </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t </tr>\n\t\t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</table>\t\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>\n\t\t  $(document).ready(function () {\n\t\t\tvar parentDiv = $(\'#divcnt\').height();\n\t\t\t$(\'#NoRecordsMiddleAlign\').height(parentDiv);\n\t\t  });\n\t\t  window.addEventListener(\"orientationchange\", function() {\n\n\t\t\t\tvar parentDiv = $(\'#divcnt\').height();\n\t\t\t\t$(\'#NoRecordsMiddleAlign\').height(parentDiv);\n\t\t\t}, true);\n      \t</script>\n\t   <div id=\"NoRecordsMiddleAlign\" class=\"ipSearchResultsEmptyTheme\">\n\t\t\t<table style = \'height:100%;width:100%\'>\n\t\t\t\t<tr style = \'height:100%;width:100%\'>\n\t\t\t\t\t<td style = \'height:100%;width:100%\' align = \'center\' valign = \'middle\'>\n\t\t\t\t\t\t<span style = \'font-family:Arial;font-weight:normal;font-size:13px;color:#bdbdbd;\'>No Records Found</span>\n\t\t\t\t\t</td>\n\t\t\t\t</tr> \n\t\t\t</table>\n\t   </div>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n   </div>\n   \t<div class=\"legendToggler legendTogglerTheme\" onclick=\"toggleLegend()\">\n\t\t<img src=\"../images/LegendIcon.png\" style=\"padding:10px 10px 10px 22px;\" />\n\t</div>\n\t<div class=\"legendContainer\" id=\"legendContainer\">\n\t\t<table class=\"tblegends tblegendsTheme\" border=\"0\" cellpadding=\"\" cellspacing=\"\">\n\t\t\t<tr style=\"width: 100%; height: 100%;\">\n\t\t\t\t<td style=\"width: 20px; height: 100%; padding-left: 5px;\">\n\t\t\t\t\t<div class=\"prNormalcyNormalTheme\"></div>\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: auto; height: 100%;\" class=\"legendTextFooterTheme\">Routine</td>\n\t\t\t\t<td style=\"width: 20px; height: 100%; padding-left: 5px;\">\n\t\t\t\t\t<div class=\"prNormalcyAbnormalTheme\"></div>\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: auto; height: 100%;\" class=\"legendTextFooterTheme\">Stat</td>\n\t\t\t\t<td style=\"width: 20px; height: 100%; padding-left: 5px;\">\n\t\t\t\t\t<div class=\"prNormalcyCriticalTheme\"></div>\n\t\t\t\t</td>\n\t\t\t\t<td style=\"width: auto; height: 100%\">Urgent</td>\n\t\t\t\t<td style=\"width: 40%; height: 100%\"></td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\t<div class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" CSTransactionMessage\" id=\"transactionMsg\" style=\"bottom: 10px; left: 10px; display: none\">\n\t\t<div class=\"formValErrorMsgTheme\" id = \"transactionMessageContent\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</div>\n\t</div>\n</div>\n</div>\n<input type=\"hidden\" name=\"hdnPath\" id=\"hdnPath\" id=\"hdnPath\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" /> \n<input type=\"hidden\" name=\"hdnOrderCat\" id=\"hdnOrderCat\" id=\"hdnOrderCat\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"hdnOrderType\" id=\"hdnOrderType\" id=\"hdnOrderType\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"hdnOrderCatDesc\" id=\"hdnOrderCatDesc\" id=\"hdnOrderCatDesc\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"hdnOrderTypeDesc\" id=\"hdnOrderTypeDesc\" id=\"hdnOrderTypeDesc\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"hdnPriority\" id=\"hdnPriority\" id=\"hdnPriority\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"hdnTransactionOccurred\" id=\"hdnTransactionOccurred\" id=\"hdnTransactionOccurred\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"hdnTransactionMsg\" id=\"hdnTransactionMsg\" id=\"hdnTransactionMsg\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"hdnTransactionResult\" id=\"hdnTransactionResult\" id=\"hdnTransactionResult\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\n\n\n</form> \n  \n</body>\n</html>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

private String checkForNull(String strParam)
{
        String str ="";
        if(strParam!=null && strParam.length() > 0)
        	str = strParam;
        return str;
}




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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);


	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String mode	   = "1";
	String view_by = "H";
	String ord_cat =  request.getParameter("hdnOrderCat") == null?"":request.getParameter("hdnOrderCat");
	String ord_cat_desc =  request.getParameter("hdnOrderCatDesc") == null?"":request.getParameter("hdnOrderCatDesc");
	String single_multi = "M";
	String ord_type =  request.getParameter("hdnOrderType") == null?"":request.getParameter("hdnOrderType");
	String ord_type_desc =  request.getParameter("hdnOrderTypeDesc") == null?"":request.getParameter("hdnOrderTypeDesc");
	String priority =  request.getParameter("hdnPriority") == null?"":request.getParameter("hdnPriority");
	String transactionOccurred = request.getParameter("hdnTransactionOccurred") == null?"false":request.getParameter("hdnTransactionOccurred"); 
	String transactionMsg = request.getParameter("hdnTransactionMsg") == null?"":request.getParameter("hdnTransactionMsg"); 
	String transactionResult = request.getParameter("hdnTransactionResult") == null?"":request.getParameter("hdnTransactionResult"); 
	String formValErrClass = "";
	if(transactionOccurred.equals("true")){
		if(transactionResult.equals("SUCCESS")){
			formValErrClass = "formValSuccessTheme";
		}else if(transactionResult.equals("FAILURE")){
			formValErrClass = "formValErrorTheme";
		}
	}
	String location_type = "";
	String locn = "";
	String patientId = "";
	String encntr_id = "";
	String order_no = "";
	
	/* String practitioner_id = "PH_ALPHA";
	String resp_id = "CA"; */
	String performing_location_code = "";
	String int_or_ext = "";
	String specimen_no = "";
	String activity_type = "";
	int start = 1;
	int end = 200;
	String login_value = "pract";
	String localeName = "en";
	
	
	String selectedPeriod = request.getParameter("hdnSelectedPeriod") == null?"LOW":request.getParameter("hdnSelectedPeriod");
	SimpleDateFormat sdf_plainDate = new SimpleDateFormat("dd/MM/yyyy");
	String date_to = sdf_plainDate.format(new Date());
	String date_from = "";
	
	//String date_from = DateUtils.minusDate(date_to, "DMY", "en", 10, "d");
	
	String selectedPeriodText="";
	if(selectedPeriod.equals("LOD")){
		selectedPeriodText="Last One Day";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 1, "d");
	}
	else if(selectedPeriod.equals("LTD")){
		selectedPeriodText="Last Three Days";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 3, "d");
	}
	else if(selectedPeriod.equals("LOM")){
		selectedPeriodText="Last One Month";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 1, "M");
	}
	else{
		selectedPeriodText="Last One Week";
		date_from = DateUtils.minusDate(date_to, "DMY", "en", 7, "d");
	}

	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String pract_type = (String)session.getValue("practitioner_type");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

	ArrayList allValues = new ArrayList();


	RegisterOrder bean = (RegisterOrder)PersistenceHelper.getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId("");
	bean.setMode( mode ) ;
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");

	bean.clear() ;
	allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code,int_or_ext,specimen_no,activity_type,start,end,login_value);
	
	

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(selectedPeriodText ));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String slClassValue = "";
	String tmp_ord_cat = "";
	String cont_order_ind = "";
	String order_line_num = "";
    String	encounter_dtls="";

	if (view_by.equals("H")) order_line_num = "1";
	int i = 0;
	if(!allValues.isEmpty()){


            _bw.write(_wl_block6Bytes, _wl_block6);

		for(int k=0; k<allValues.size(); k++){
		String[] register_details = (String[])allValues.get(k);
		String orderID = register_details[2] ;
		String OrderType =  register_details[9] ;
		String orderTypeCode = register_details[0] ;
		String patientName= register_details[7];
		String OrderCatalog = register_details[6];
		OrderCatalog = OrderCatalog.replace("!~!",",");
		OrderCatalog = OrderCatalog.replace("(","");
		OrderCatalog = OrderCatalog.replace(")","");
		String encounterId = register_details[17];
		String facilityId = register_details[14];
		String bedNum;
		String roomNum;
		String practName;
		EncounterListResponse encResponse;
		EncounterListBC encBC = new EncounterListBC();
		ArrayList<EncounterHO> encounterList; 
		encResponse = encBC.getEncounterDetailsById(encounterId, facilityId);
		if(encResponse!= null && encResponse.getEncounterList()!=null && !encResponse.getEncounterList().isEmpty()){
			encounterList = encResponse.getEncounterList();
			EncounterHO encounterDets = encounterList.get(0);
			bedNum = encounterDets.getBedNum();
			roomNum = encounterDets.getRoomNum();
			practName = encounterDets.getPractShortName();
			
		

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(orderID ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(orderID ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(orderTypeCode ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(OrderCatalog));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(orderID ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderID ));
            _bw.write(_wl_block13Bytes, _wl_block13);

		if(register_details[4].compareTo("R")==0)
		{
			register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
								
		}
			else if(register_details[4].compareTo("U")==0)
		{
			
			register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
							
	
		}
			else if(register_details[4].compareTo("S")==0)
		{
		
			register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
				
	
		}	
	

            _bw.write(_wl_block14Bytes, _wl_block14);

										
									
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(OrderCatalog ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderID ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(OrderType ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(register_details[3] ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(register_details[4] ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patientName ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(register_details[11]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(register_details[12]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( practName ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( bedNum ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( roomNum ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(register_details[17] ));
            _bw.write(_wl_block27Bytes, _wl_block27);

	i++;
	}

            _bw.write(_wl_block28Bytes, _wl_block28);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
}else{ 
            _bw.write(_wl_block30Bytes, _wl_block30);
} 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(formValErrClass ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(transactionMsg ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ord_type_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(selectedPeriod));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(transactionOccurred));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(transactionMsg));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(transactionResult));
            _bw.write(_wl_block43Bytes, _wl_block43);

PersistenceHelper.putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block44Bytes, _wl_block44);
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

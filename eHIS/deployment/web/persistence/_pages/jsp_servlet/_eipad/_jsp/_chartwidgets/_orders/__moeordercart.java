package jsp_servlet._eipad._jsp._chartwidgets._orders;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Map.Entry;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldItem;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eIPAD.chartsummary.orderentry.bc.MOrderEntryBC;
import eOR.OrderEntryBean;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __moeordercart extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/orders/MoeOrderCart.jsp", 1709118019365L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<script>\n\nvar ordEntryCartScroll;\nfunction initOrderCartScroller() {\n\tordEntryCartScroll = new IScroll(\'#cartWrapper\', { \n\t\tscrollX: false, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: true,\n\t\tdisableMouse: false,\n    disablePointer: true\n\t\t/* interactiveScrollbars: true,\n\t\tshrinkScrollbars: \'scale\',*/\n\t\t/* fadeScrollbars: true  */\n\t});\n}\n\nfunction removeOrdersFromArray_cartpage(mode,code){\n\t\n}\n$(document).ready(function() {\n\tfillPriceValues();\n\tinitOrderCartScroller();\n\tinitSpecialActions();\n});\n\n\nfunction initSpecialActions(){//status check for authorization Special approve and cosign\n\t$(\"[data-authorized-cat]\").each(function(index, value){//Each Category Header\n\t\tvar catCode = $(this).data(\"authorized-cat\");\n\t\tvar status=\"NA\";\n\t\t$(\"[data-authorized-\"+catCode+\"]\").each(function(index, value){//Each item under category\n\t\t\tvar thisStatus =  $(this).data(\"authorized-\"+catCode);\n\t\t\tif(thisStatus!=\"NA\"){\n\t\t\t\tif(thisStatus==\"Y\"){\n\t\t\t\t\tstatus = \"Y\";\n\t\t\t\t}else if(thisStatus==\"N\"){\n\t\t\t\t\tstatus = \"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\tif(status==\"NA\"){\n\t\t\t$(this).addClass(\"imgGrayscale\");\n\t\t\t$(this).data(\"authorized-status-\"+catCode,\"NA\");\n\t\t\t\n\t\t}else if(status==\"Y\"){\n\t\t\t$(this).addClass(\"actionTickIcon\");\n\t\t\t$(this).data(\"authorized-status-\"+catCode,\"Y\");\n\t\t}\n\t});\n\t\n\t$(\"[data-special_approved-cat]\").each(function(index, value){//Each Category Header\n\t\tvar catCode = $(this).data(\"special_approved-cat\");\n\t\tvar status=\"NA\";\n\t\t$(\"[data-special_approved-\"+catCode+\"]\").each(function(index, value){//Each item under category\n\t\t\tvar thisStatus =  $(this).data(\"special_approved-\"+catCode);\n\t\t\tif(thisStatus!=\"NA\"){\n\t\t\t\tif(thisStatus==\"Y\"){\n\t\t\t\t\tstatus = \"Y\";\n\t\t\t\t}else if(thisStatus==\"N\"){\n\t\t\t\t\tstatus = \"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\tif(status==\"NA\"){\n\t\t\t$(this).addClass(\"imgGrayscale\");\n\t\t\t$(this).data(\"special_approved-status-\"+catCode,\"NA\");\n\t\t\t\n\t\t}else if(status==\"Y\"){\n\t\t\t$(this).addClass(\"actionTickIcon\");\n\t\t\t$(this).data(\"special_approved-status-\"+catCode,\"Y\");\n\t\t}\n\t});\n\t\n\t$(\"[data-cosigned-cat]\").each(function(index, value){//Each Category Header\n\t\tvar catCode = $(this).data(\"cosigned-cat\");\n\t\tvar status=\"NA\";\n\t\t$(\"[data-cosigned-\"+catCode+\"]\").each(function(index, value){//Each item under category\n\t\t\tvar thisStatus =  $(this).data(\"cosigned-\"+catCode);\n\t\t\tif(thisStatus!=\"NA\"){\n\t\t\t\tif(thisStatus==\"Y\"){\n\t\t\t\t\tstatus = \"Y\";\n\t\t\t\t}else if(thisStatus==\"N\"){\n\t\t\t\t\tstatus = \"N\";\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\tif(status==\"NA\"){\n\t\t\t$(this).addClass(\"imgGrayscale\");\n\t\t\t$(this).data(\"cosigned-status-\"+catCode,\"NA\");\n\t\t\t\n\t\t}else if(status==\"Y\"){\n\t\t\t$(this).addClass(\"actionTickIcon\");\n\t\t\t$(this).data(\"cosigned-status-\"+catCode,\"Y\");\n\t\t}\n\t});\n\t\n}\n\n\nfunction catSpecificSpecialActions(actionType,catCode,value){//specialActions Ajax call\n\t\n\tvar obj = $(\"[data-\"+actionType+\"-status-\"+catCode+\"]\");\n\tvar status = obj.data(actionType+\"-status-\"+catCode);\n\tif(actionType && (status == \"N\")){\n\t\tvar specialAction = function(){\n\t\t\tcloseConfirmDialog(); //ajax call\n\t\t\tvar actionUrl = path + \"/eIPAD/jsp/chartwidgets/orders/MoeSetTempValues.jsp?key=\"+actionType+catCode.toUpperCase()+\"&value=\"+value;\n\t\t\t$.ajax({\n\t\t        url: actionUrl,\n\t\t        success: function(response) {\n\t\t\t\t\t\t//response action starts\n\t\t\t\t\t\tobj.addClass(\"actionTickIcon\");\n\t\t\t\t\t\tobj.data(actionType+\"-status-\"+catCode,\"Y\");\n\t\t\t\t\t\t$(\"[data-\"+actionType+\"-cat]\").each(function(index, value){//Each Category Header\n\t\t\t        \t\tvar catCode = $(this).data(\"special_approved-cat\");\n\t\t\t        \t\t$(\"[data-\"+actionType+\"-\"+catCode+\"]\").each(function(index, value){//Each item under category\n\t\t\t        \t\t\tvar thisStatus =  $(this).data(actionType+\"-\"+catCode);\n\t\t\t        \t\t\t\t if(thisStatus==\"N\"){\n\t\t\t        \t\t\t\t\t $(this).addClass(\"actionTickIcon\");\n\t\t\t        \t\t\t\t\t $(this).data(actionType+\"-status-\"+catCode,\"Y\");\n\t\t\t        \t\t\t\t}\n\t\t\t        \t\t\t});\n\t\t\t        \t\t});\n\t\t\t\t\t\t//response action ends\n\t\t\t\t},\n\t\t\t\terror: function (xhr, ajaxOptions, thrownError) {\n\t\t\t\talert(\"Error in performing special actions\");\n\t\t\t\t}\n\t\t\t});//end ajax  \n\t\t};\n\t\t$(\"#OrderConfirmDialog\").configureConfirmDialog({\n\t\t\tcallBackForTrue: specialAction\n\t\t});\n    \t\n    \tif(actionType == \"authorized\"){\n\t\t\tvar errorMsg = \"Do you want to Authorize all Orders under this category?\";\n\t\t\tshowConfirmDialog(errorMsg);\n\t\t}\n\t\tif(actionType == \"special_approved\"){\n\t\t\t\n\t\t\tvar errorMsg = \"Do you want to Special Approve all Orders under this category?\";\n\t\t\tshowConfirmDialog(errorMsg);\n\t\t\n\t\t}\n\t\tif(actionType == \"cosigned\"){\n\t\t\tvar errorMsg = \"Do you want to Cosign all Orders under this category?\";\n\t\t\tshowConfirmDialog(errorMsg);\n\t\t}\n\t}\t\t \n\t}\n\nfunction controlMore(cat){//specialActions Strip control\n\t$(\"#strip\"+cat).toggle();\n\t if($(\"#strip\"+cat).is(\":visible\")){\n\t\t $(\"#test\"+cat).addClass(\"MoeBlur\");\n\t\t $(\"#StripControlcontainer\"+cat).hide();\n\t\t $(\"#OCCatBgDiv\"+cat).show();\n\t }\n\t else{\n\t\t $(\"#test\"+cat).removeClass(\"MoeBlur\");\n\t\t $(\"#StripControlcontainer\"+cat).show();\n\t }\n}\nfunction closeMoreDots(cat){//specialActions Strip Close\n\t if($(\"#strip\"+cat).is(\":visible\")){\n\t\t $(\"#strip\"+cat).hide();\n\t\t $(\"#test\"+cat).removeClass(\"MoeBlur\");\n\t\t $(\"#StripControlcontainer\"+cat).show();\n\t\t $(\"#OCCatBgDiv\"+cat).hide();\n\t }\n}\nfunction controlMoreOS(cat){ //Order Set Special Actions Strip Control\n\t$(\"#stripOS\"+cat).toggle();\n\t if($(\"#stripOS\"+cat).is(\":visible\")){\n\t\t\n\t\t $(\"#testOS\"+cat).addClass(\"MoeBlur\");\n\t\t $(\"#StripControlcontainerOS\"+cat).hide();\n\t\t $(\"#fakeDivOS\"+cat).show();\n\t }\n\t else{\n\t\t $(\"#testOS\"+cat).removeClass(\"MoeBlur\");\n\t\t $(\"#StripControlcontainerOS\"+cat).show();\n\t }\n}\nfunction closeMoreDotsOS(cat){//Order Set Special Actions Strip Close\n\t if($(\"#stripOS\"+cat).is(\":visible\")){\n\t\t $(\"#stripOS\"+cat).hide();\n\t\t $(\"#testOS\"+cat).removeClass(\"MoeBlur\");\n\t\t $(\"#StripControlcontainerOS\"+cat).show();\n\t\t $(\"#fakeDivOS\"+cat).hide();\n\t }\n}\n\nfunction fillPriceValues(){\n\t$(\"[data-tp-cat]\").each(function(index, value){//Each Category Header\n\t\tvar catCode = $(this).data(\"tp-cat\");\n\t\tif(catCode!=\"cs\"){\n\t\t\tvar totalPrice = 0.0;\n\t\t\t$(\"[data-itemtp-\"+catCode+\"]\").each(function(index, value){ //Each Individual Item under that category\n\t\t\t\ttotalPrice = totalPrice + parseFloat($(this).data(\"itemtp-\"+catCode));\n\t\t\t});\n\t\t\tif(totalPrice>0){\n\t\t\t\t$(this).html(totalPrice.toFixed(1));\n\t\t\t\t//$(\"#OrdCatPriceBlock_\"+catCode).show();\n\t\t\t}\n\t\t\t$(this).data(\"tp-\"+catCode,totalPrice.toFixed(1));\n\t\t}\n\t\t\n\t});\n\t\n\t$(\"[data-pp-cat]\").each(function(index, value){//Each Category Header\n\t\tvar catCode = $(this).data(\"pp-cat\");\n\t\tif(catCode!=\"cs\"){\n\t\tvar totalPrice = 0.0;\n\t\t$(\"[data-itempp-\"+catCode+\"]\").each(function(index, value){ //Each Individual Item under that category\n\t\t\ttotalPrice = totalPrice + parseFloat($(this).data(\"itempp-\"+catCode));\n\t\t});\n\t\tif(totalPrice>0){\n\t\t\t$(this).html(totalPrice.toFixed(1));\n\t\t\t//$(\"#OrdCatPriceBlock_\"+catCode).show();\n\t\t}\n\t\t$(this).data(\"pp-\"+catCode,totalPrice.toFixed(1));\n\t\t}\n\t});\n\t\n\t//Total Price\n\tvar totalPrice = 0.0;\n\t$(\"[data-tp-cat]\").each(function(index, value){\n\t\tvar catCode = $(this).data(\"tp-cat\");\n\t\ttotalPrice = totalPrice + parseFloat($(this).data(\"tp-\"+catCode));\n\t});\n\t$(\"#OrdTotalTP\").html(totalPrice.toFixed(1));\n\ttotalPrice = 0.0;\n\t$(\"[data-pp-cat]\").each(function(index, value){\n\t\tvar catCode = $(this).data(\"pp-cat\");\n\t\ttotalPrice = totalPrice + parseFloat($(this).data(\"pp-\"+catCode));\n\t});\n\t$(\"#OrdTotalPP\").html(totalPrice.toFixed(1));\n\t\n}\n\nfunction showExpOrderItems(cat){\n\t\n\tif($(\"#OrdItemsExp\"+cat).is(\':visible\')){\n\t\t$(\"#OrdItemsToggleArrow\"+cat).removeClass(\"MoeIHEC_Downarrow\").addClass(\"MoeIHEC_Uparrow\");\n\t\t$(\"#OrdItemsExp\"+cat).hide();\n\t}\n\telse{\n\t\t$(\"#OrdItemsToggleArrow\"+cat).removeClass(\"MoeIHEC_Uparrow\").addClass(\"MoeIHEC_Downarrow\");\n\t\t$(\"#OrdItemsExp\"+cat).show();\n\t}\n\tordEntryCartScroll.refresh();\n}\n\n</script>\n\n<body style=\"display: block; margin: 0px; height: 100%; width: 100%;\" >\n<form id=\"ChartSummaryForm\" name = \"ChartSummaryForm\" method = \"post\" action = \"\" class=\"ChartSummaryFormElem\">\n<div data-role = \"none\" id = \"dvMez\" class = \"blurPopup\" onclick=\"\" data-popid=\"\"></div>\n<div id=\"OrdSearchSFS\" class=\"orderSearchSfs\" style=\"display:none\" >\n\t<div id=\"sfsarrow\" data-role=\"none\" class=\"sfs-bubble-arrow sfs-bubble-arrowIPTheme\"></div>\n\t<div data-role=\"none\" class=\"ordSfsSmall sfsIPTheme\"  style=\"display:block\">\n\t\t<iframe id=\"sfsFrame\" frameborder=\"0\" style = \"display:block;\" scrolling =\"no\" height=\"300px\" width=\"340px\" src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/jsp/chartwidgets/orders/MoeAddlSearchCrit.jsp\"></iframe>  \n\t</div> \n</div>\n\n<div class=\"ordSelParent\"> \n\t<!--  Header START-->\n\t<div class=\"ordSelHeaderMenu\">\n\t\t<div class=\"ordSelHeaderMenuCont\">\n\t\t\t<div class=\"row\">\n\t\t\t\t<div class=\"ordSelMenuCont\">\n\t\t\t\t\t<div class=\"ordSelMenuIconbg\">\n\t\t\t\t\t\t<div class=\"ordSelMenuIcon\"> </div>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"ordCartMenuCont ordSelMenuTitle\">Selected Orders</div>\n\t\t\t</div>\n\t\t</div>\n\t</div>\n\t<!--  Header END--> \n\t<div class=\"ordSelItemsCont\">\n    \t<div class=\"ordItemsCont\">\n    \t\t<div class=\"MoeSelectOrder\" >\n    \t\t<!-- Scrolling item START -->\n\t\t\t\t<div class=\"MoeSelectOrderItem MoeSelectOrderItemTheme\">\n\t\t\t\t    <div class=\"MoeContainer\">\n\t \t\t\t\t\t<div class=\"MoeMain\">\n\t\t\t\t        \t<div class=\"MoeSOI_List\">\n\t\t\t\t\t\t\t\t<div class=\"MoeSOI_List_c clearfix\">\n\t\t\t\t\t\t\t\t\t<div id=\"cartWrapper\" style=\"\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"cartScroller\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t           \n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeHeader MoeHeaderTheme\" style=\"position:relative\">\n              \t\t\t\t\t\t\t\t\t\t<div class=\"MoeHTitle\">\n                \t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"position:absolute; width:100%;\">\n                \t\t\t\t\t\t\t\t\t\t\t<div class=\"table\"  id=\"test";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  style=\"position:absolute;\">\n               \t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" >\n                \t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeIHclose\" id=\"IHclose\" onclick=\"removeOrder(\'CAT\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                <div class=\"MoeHTitlecell\" id=\"OHTitlecell\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeOHTTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<div class=\"MoeOHTRowtop\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t<div class=\"MoeOHTCell1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t<div class=\"MoeIHTitle MoeIHTitleTheme\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t<div class=\"MoeIHCountCont\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                          \t\t\t<div class=\"MoeIHcount MoeIHcountTheme\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeOHTRowbottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<div class=\"MoeOHTCELL2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t<div class=\"MoeOHTAMT MoeOHTAMTNUMTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t<span data-tp-";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="=\"0.0\" data-tp-cat=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">--</span> / \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t\t<span data-pp-";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="=\"0.0\" data-pp-cat=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">--</span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"MoeOHTAMT MoeOHTAMTLBETheme\"><span>Total </span>/<span> Patient</span> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                      </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                  </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t        </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n               \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"float:right\">\n\t\t\t\t\t\t\t\t\t\t\t\t            \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"MoeOHEXPCOL\">\n\t\t\t\t\t\t\t\t\t\t\t\t                  \t\t<div class=\"StripControlcontainer\" id=\"StripControlcontainer";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t                    \t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t\t<div class=\"MoeStripControlExp\" onclick=\"showExpOrderItems(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" >\n\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t\t<div class=\"MoeIHECicon\">\n\t\t\t\t\t\t\t\t\t\t\t\t                          \t\t\t\t<div class=\"MoeIHEC_Uparrow\" id=\"OrdItemsToggleArrow";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t<div class=\"MoeStripControlMore\" id=\"StripControlMoreId\" onclick=\"controlMore(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t<div class=\"MoeMoreDot MoeMoreDotTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t<div class=\"MoeMoreDot MoeMoreDotTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t<div class=\"MoeMoreDot MoeMoreDotTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t                    \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t                  \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t                \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t\t\t\t\t\t            </div>\n               \t\t\t\t\t\t\t\t\t\t</div>\n               \n               \t\t\t\t\t\t\t\t\t\t<div id=\"OCCatBgDiv";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" style=\"position:absolute; width:100%; height:100%;opacity:0.3; display:none;z-index:500\" onclick=\"closeMoreDots(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"></div> <!-- empty div for blur function -->\n\t\t\t\t\t\t\t\t\t\t\t            <!-- control strip starts  -->\n\t\t\t\t\t\t\t\t                    \t<div class =\"cell\" id = \"strip";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\"float:right; height:50px; right:0px; z-index:5000; display:none;position:absolute\">\n\t\t\t\t\t\t\t\t\t\t\t    \t\t\t<div class = \"table\" style=\"height:50px; width: 100%\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style = \"width:100%;height:100%; float: left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconCircTheme\" id=\"cosignAll";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconPos\" onclick=\"catSpecificSpecialActions(\'cosigned\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'true\')\" data-cosigned-cat=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" data-cosigned-status-";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="=\"N\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eIPAD/images/Cosign24x24.png\" width=\"20\" height=\"20\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconCircTheme\" id=\"splApproveAll";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconPos\" onclick=\"catSpecificSpecialActions(\'special_approved\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'true\')\" data-special_approved-cat=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" data-special_approved-status-";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="=\"N\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="/eIPAD/images/SpecialApproval24x24.png\" width=\"20\" height=\"20\" />\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconCircTheme\" id=\"authorizeAll";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconPos\" onclick=\"catSpecificSpecialActions(\'authorized\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'true\')\" data-authorized-cat=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" data-authorized-status-";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="/eIPAD/images/Authorize24x24.png\" width=\"20\" height=\"20\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t \t\t\t \t</div>\n\t\t\t\t\t\t\t\t\t\t\t            <!-- control strip ends -->\n              \t\t\t\t\t\t\t\t\t    </div>\n              \t\t\t\t\t\t\t\t\t\t<div class=\"MoeHBorder\"> </div>\n\t\t\t\t\t\t\t\t\t                <!-- Transaction Error Icon div STARTS-->\n\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"MoeTransactionErIcon\" id=\"OrdTransactionErCatIcon";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" data-tscterrormsg=\"\" style=\"display:none\" onclick=\"showTransactError(this)\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t    <!-- Transaction Error Icon div ENDS-->\n\t\t\t\t\t\t\t\t\t            </div>\n \t\t\t\n\t\t\t\t\t\t\t    \t\t  \t\t<div class=\"MoeSubSelectOrder\" style=\"\" id=\"OrdItemsExp";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t\t\t\t\t              \t\t<div id=\"MoeSubSelectOrderItem\">\n\t\t\t\t\t\t\t\t                \t\t<div id=\"Subcontainer\">\n\t\t\t\t\t\t\t\t\t                  \t\t<!-- <div id=\"submain\"> -->\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t                    \n\t\t\t\t\t\t\t\t\t\t\t\t\t        \t<div class=\"MoeSOA MoeSofl\">\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeSubItemList\" id=\"OrderCatalogItem";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" data-catcode=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' data-itemcode=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeClose\" onclick=\"removeOrder(\'IND\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\')\"> </div>\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t<div  onclick=\"openOrderFields(\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\">\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeSubItemHeaderFont\">\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\" MoeSILTitle\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</div>\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeSubItemListDetails\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"MoeSILcon SILDate\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t<div class=\"table\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                            \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                \t<div class=\"cell\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</div>\n                                    \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                    <!-- Authorize icon Starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                  \t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"cell MoeSubicon actionTickIcon\" id=\"AuthorizeIcon";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"  data-authorized-";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="=\"Y\"> <img src=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="/eIPAD/images/authorize16x16.png\"/> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"cell MoeSubicon\" id=\"AuthorizeIcon";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="=\"N\"> <img src=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell MoeSubicon imgGrayscale\" id=\"AuthorizeIcon";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="=\"NA\"> <img src=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="/eIPAD/images/authorize16x16.png\"/> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <!-- Authorize icon Ends -->\n\t\t\t\t\t\t            \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <!-- Special Approval icon Starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"cell MoeSubicon actionTickIcon\" id=\"SpecialApproveIcon";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" data-special_approved-";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="/eIPAD/images/SpecialApproval16x16.png\"/> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"cell MoeSubicon\" id=\"SpecialApproveIcon";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell MoeSubicon imgGrayscale\" id=\"SpecialApproveIcon";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="/eIPAD/images/SpecialApproval16x16.png\"/> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <!-- Special Approval icon Ends -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <!--  Cosign Starts -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"cell MoeSubicon actionTickIcon\" id=\"CosignIcon";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" data-cosigned-";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="/eIPAD/images/cosign16x16.png\"/> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"cell MoeSubicon\" id=\"CosignIcon";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell MoeSubicon imgGrayscale\" id=\"CosignIcon";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="/eIPAD/images/cosign16x16.png\"/> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                                    <!-- Cosign Ends -->\n                                \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                        \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"MoeSILcon SILDate\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t<div class=\"MoeSelectOrderTxt\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =", ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"MoeSILcon SILtotalamt\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                         \t<span data-itemtp-";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</span> / \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span data-itempp-";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t                            \n\t\t\t\t\t\t\t\t\t\t\t\t\t                            <div class=\"MoeSILcon SILtotalamt\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t                            \t<span> -- </span>/<span> -- </span>\t \n\t\t\t\t\t\t\t\t\t\t\t\t\t                            </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    <!-- Transaction Error Icon div STARTS-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    <div class=\"MoeTransactionErIcon\" id=\"OrdTransactionErIcon";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" data-tscterrormsg=\"\" style=\"display:none\" onclick=\"showTransactError(this)\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t                    <!-- Transaction Error Icon div ENDS-->\n                    \t\t\t\t\t\t\t\t\t\t\t\t</div>\n                    \t\t\t\t\t\t\t\t\t\t\t</div>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- new code for order set -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeHeader MoeHeaderTheme\" data-catcode=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"OrderCatalogItem";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t            <div class=\"MoeHTitle\">\n\t\t\t\t\t\t\t\t\t\t\t            \t<!-- new starts -->\n\t\t\t\t\t\t\t\t\t\t\t            \t<div class =\"cell\" id = \"stripOS";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" style=\"float:right; height:50px; width:100%; z-index:500; padding-right:15px; display:none \">\n\t\t\t\t\t\t\t\t\t\t\t\t\t    \t\t<div class = \"table\" style=\"height:50px; width: 100%\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\" style = \"width:100%;height:100%; float: left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ordFldHdrIconCircTheme\"><div class=\"cell ordFldHdrIconPos imgGrayscale\"> <img src=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="/eIPAD/images/Authorize24x24.png\" width=\"20\" height=\"20\"/></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t                <!-- new ends -->\n               \t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\"  style=\"position:absolute; width:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t               <div class=\"table\" onclick=\"closeMoreDotsOS(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\')\" id=\"testOS";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"  style=\"position:absolute;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"fakeDivOS";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" style=\"position:absolute; width:100%; height:100%;opacity:0.3;display:none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t               \t\t\t<div class=\"row\">\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeIHclose\" onclick=\"removeOrder(\'CAT\',\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\')\"> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        \t<div class=\"MoeHTitlecellOS\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            \t<div class=\"MoeOHTTable\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"MoeOHTRowtop\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<div class=\"MoeOHTCell1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeIHTitle MoeIHTitleTheme\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t<div class=\"MoeIHCountCont\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t<div class=\"MoeIHcount MoeIHcountTheme\">";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                  \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                  \t<div class=\"MoeOHTRowbottom\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<div class=\"MoeOHTCELL2\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t<div class=\"MoeOHTAMT MoeOHTAMTNUMTheme\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\t\t\t             \n\t\t\t\t\t\t\t\t\t\t                \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t         \t\t\t<span data-tp-";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" data-tp-cat=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</span> / \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t        \t\t\t<span data-pp-";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" data-pp-cat=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</span> \n\t\t\t\t\t\t\t\t\t\t                      \t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span data-tp-";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">--</span> / \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span data-pp-";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">--</span>\n\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\t\t\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t</div>\n                      \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \t\t<div class=\"MoeOHTAMT MoeOHTAMTLBETheme\"><span>Total </span>&nbsp;/&nbsp;<span> Patient</span> </div>\n                    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      \t</div>\n                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t   </div>\n             \n              \t\t\t\t\t\t\t\t\t\t\t\t   <div class=\"table\" style=\"float:right\">\n                                                               \t\t<div class=\"row\">\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeOHEXPCOLord\">\n                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"StripControlcontainer\" ID=\"StripControlcontainerOS";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n                  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n                  \n                     \n                    ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t                 \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<div class=\"MoeStripControlExp\"  onclick=\"showExpOrderItems(\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\')\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t<div class=\"MoeIHECicon\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        \t\t<div class=\"MoeIHEC_Uparrow\"id=\"OrdItemsToggleArrow";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    <div class=\"MoeStripControlMore\" id=\"StripControlMoreIdOS";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" onclick=\"controlMoreOS(\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\')\" >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<div class=\"MoeMoreDot MoeMoreDotTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t<div class=\"MoeMoreDot MoeMoreDotTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t<div class=\"MoeMoreDot MoeMoreDotTheme\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    </div>\n                  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t\t</div>\n            \t\t\t\t\t\t\t\t\t\t\t</div>\n            \t\t\t\t\t\t\t\t\t\t<div class=\"MoeHBorder\"> </div>\n          \t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t            \t\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeSubSelectOrder\" id=\"OrdItemsExp";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t\t\t\t\t\t              \t<div id=\"MoeSubSelectOrderItem\">\n\t\t\t\t\t\t\t\t\t\t                \t<div id=\"SubcontainerOrders\">\n\t\t\t\t\t\t\t\t\t\t                  \t\t<div id=\"submain\"> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeSubItemheader\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                \t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        <div class=\"MoeSILTitle1\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                          \t<div class=\"MoeSILTitle1\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                        </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\t\t\t            \n\t\t\t                \n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <div class=\"MoeSubItemListOrders\" id=\"OrderCatalogItem";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"MoeSubcloseOrders imgGrayscale MoeIconDisablePO\" onclick=\"\"> </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div  onclick=\"openOrderFields(\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t<div class=\"MoeSubItemHeaderFont\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t      \t\t\t\t\t\t\t\t<div class=\" MoeSILTitle\">";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t              \t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                      \t<div class=\"MoeSubItemListDetailsOrders\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeSILcon SILDate\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    <div class=\"cell\" style=\"vertical-align:middle; height:21px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    <div class=\"MoeSILcon SILDate\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t              \t\t\t\t<div class=\"MoeSelectOrderTxt\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t              \t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    \t<!-- Transaction Error Icon div STARTS-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeTransactionErIcon\" id=\"OrdTransactionErIcon";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" data-tscterrormsg=\"\" style=\"display:none\" onclick=\"showTransactError(this)\"></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- Transaction Error Icon div ENDS-->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t                    </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n                  \t\t\t\t\t\t\t\t\t\t\t\t</div>\n                \t\t\t\t\t\t\t\t\t\t\t</div>\n              \t\t\t\t\t\t\t\t\t\t\t</div>\n           \t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t\t\t\t    \t<!-- No Results START -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"height:100%; width:100%; position:absolute\">\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align: middle; text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"MoeNoData\" id=\"No_Orders\" >No orders were selected</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t    \t<!-- No Results END -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t          \t\t\t</div>\n\t\t\t\t\t        \t\t</div>\n\t\t\t\t      \t\t\t</div>\n\t\t\t\t\t      \t</div>\n\t\t\t\t  \t\t</div>\n\t\t\t\t    </div>\n\t\t\t  \t</div>\n\t\t\t\t<!-- footer content starts here -->\n\t\t\t\t<div class=\"MoeFooterContainer\">\n\t\t\t\t    <div class=\"MoeTotalcontainer\">\n\t\t\t\t\t\t<div class=\"MoeTotalmain\">\n\t\t\t\t        \t<div class=\"MoeTotalC\">\n\t\t\t\t          \t\t<div class=\"MoeTotalCC MoeTotalCCTheme\">\n\t\t\t\t            \t\t<div class=\"MoeFooterCon\">\n\t\t\t\t              \t\t\t<!-- <div class=\"row footericon\">\n\t\t\t\t                \t\t\t<div class=\"footeredit\"> </div>\n\t\t\t\t              \t\t\t</div> -->\n\t\t\t\t              \t\t\t<div class=\"MoeFooterlable\">\n\t\t\t\t                \t\t\t<div class=\"MoeFooterlabletxt\">Total </div>\n\t\t\t\t              \t\t\t</div>\n\t\t\t\t              \t\t\t<!-- price area starts here-->\n\t\t\t\t              \t\t\t<div class=\"MoeFooterprice\">\n\t\t\t\t              \t\t\t\t<div class=\"cell\">\n\t\t\t\t              \t \t\t\t\t<div class=\"table\" style=\"height:100%; width:100%;\">\n\t\t\t\t              \t \t\t\t\t\t<div class=\"row\">\n\t\t\t\t                \t\t\t\t\t\t<div class=\"MoeFooterpricetxt\">\n\t\t\t\t                \t\t\t\t\t\t\t<div class=\"MoeFooterpricetxt\"><span id=\"OrdTotalTP\">0.0</span> / <span id=\"OrdTotalPP\">0.0</span></div>\n\t\t\t\t                \t\t\t\t\t\t</div>\n\t\t\t                \t\t\t\t\t\t\t<div class=\"MoeFooterpricetxt1 MoeFooterpricetxt1Theme\">\n\t\t\t                \t\t\t\t\t\t\t\t<div class=\"MoeFooterpricetxt1 MoeFooterpricetxt1Theme\"><span>Total </span>/<span> Patient</span> </div>\n\t\t\t                \t\t\t\t\t\t\t</div>\n\t\t\t                \t\t\t\t\t\t</div>\n\t\t\t                \t\t\t\t\t</div>\n\t\t\t                \t\t\t\t</div>\n\t\t\t\t              \t\t\t</div>\n\t\t\t\t              \t\t\t<!-- price area ends here-->\n\t\t\t\t            \t\t</div>\n\t\t\t\t          \t\t</div>\n\t\t\t\t        \t</div>\n\t\t\t\t      \t</div>\n\t\t\t\t    </div>\n\t\t\t\t </div>\n\t\t\t\t <!-- footer content ends here -->\n\t\t    </div>\n\t\t</div>\n\t</div>\n<input type = \"hidden\" name = \"hdnPath\" id = \"hdnPath\" value =\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" />\n\t<!-- <div id=\"testred\" style=\"position:absolute;background:red;height:50px;width:200px;bottom:5px;right:0px\"></div> -->\n</div>\n\n</form>\n<!-- </body>\n</html> -->\n\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

Locale appLocale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	appLocale = new Locale((String)session.getAttribute("LOCALE"));
else 
	appLocale = new Locale("en");
ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 

            _bw.write(_wl_block4Bytes, _wl_block4);

PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
String or_bean_id = "@orderentrybeanm"+patientContext.getPatientId()+patientContext.getEncounterId();
String or_bean_name = "eOR.OrderEntryBean";
OrderEntryBean bean = (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);
eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
String key							= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For New Orders) to keep the Value in the Bean
HashMap previousValues 				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
HashMap catHashMap = bean.getOrderCategories(previousValues); //Get all the categories that are present in the selected orders

Properties properties				= (Properties) session.getValue( "jdbc" );
ArrayList OrderCategoryArr			= beanQueryObj.getOrderCategory(properties); // Get the Order category
MOrderEntryBC mObc = new MOrderEntryBC();
MOrderEntryFieldResponse orderCatsResp = mObc.getAllOrderCategories(bean, true);
HashMap hmOrderCategory				= new HashMap();
String billing_interface_yn		= bean.getBillingInterfaceYn();
String[] records;
HashMap bill_dtls				= null;
ArrayList speciality=new ArrayList();
ArrayList specialityOS=new ArrayList();
String speciality_code[]=new String[3];
String specialty_code = bean.checkForNull(beanQueryObj.getSpecialtyCode(properties, bean.getLoginFacilityId(),bean.getEncounterId()),"");
String auth_reqd				= "";
eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean();
if(orderCatsResp!=null && orderCatsResp.getResponseStatus()!= orderCatsResp.FIELD_DATAFETCH_FAILURE){
	ArrayList<MOrderEntryFieldItem> orderCats = orderCatsResp.getFieldItems();
	for(int i=0;i<orderCats.size(); i++) 
	{
		MOrderEntryFieldItem catItem = orderCats.get(i);
		hmOrderCategory.put(catItem.getCode(), catItem.getDesc());
	} // end of for
} // end of if 


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);

											if(catHashMap!=null && !catHashMap.isEmpty()){ 
												for(Object code:catHashMap.keySet()){
												    String order_category = (String)code;
												    String order_category_desc = (String)hmOrderCategory.get(order_category);
											
            _bw.write(_wl_block7Bytes, _wl_block7);

										    if(!order_category.equals("CS")){
										    	String order_type_catalog 		= bean.getOrderTypeCatalog(previousValues);
										    	String practitioner_type = bean.getPractitionerType();
										    	String order_catalog_code 		= bean.getOrderCatalogCode(previousValues,order_category,practitioner_type);//IN042045
										    	ArrayList PlaceOrderItems 		= bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"'1||1','1'"),bean.checkForNull(order_category,""),bean.checkForNull(order_catalog_code,"''"),""); // Last parameter to identify normalOE or from preview
									    	
										    	
										    	if(PlaceOrderItems!=null && !PlaceOrderItems.isEmpty()){
											
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(order_category ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_category_desc ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(PlaceOrderItems.size() ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_category ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order_category ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_category ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_category ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block39Bytes, _wl_block39);
		    		
																	    		
														    		for(int i=0; i<PlaceOrderItems.size(); i++){
														    			records =(String[])PlaceOrderItems.get(i); // String array
														    			
																	    			
																
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.getTempvalue("order_type_code"+records[0]) ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.getTempvalue("start_date_time"+records[0])));
            _bw.write(_wl_block48Bytes, _wl_block48);

															                                  	String forceStatus				= bean.getForceStatus(practitioner_type,order_category);
															                                  	String fStatus[]=forceStatus.split(":"); 
															                                  	
															                                  	speciality=(ArrayList)(bean.getCheckForceAuthSplty(bean.getPractitionerId(),records[0],bean.getEncounterId(),bean.getLoginFacilityId(),records[3],specialty_code,auth_reqd));
																								if(speciality.size()>0)
																								{
																									for(int sc=0;sc<speciality.size();sc++)
																									{
																											speciality_code=(String[])speciality.get(sc);
																									}
																								}
															                                  	
																			                  	if(records[48].equalsIgnoreCase("Y") || fStatus[0].equalsIgnoreCase("Y") || speciality_code[0].equalsIgnoreCase("Y")) // For Authorization Required
																								{ 
																			                  		if(bean.checkForNull(bean.getTempvalue("authorized"+order_category),"false").equals("true")){
																								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block52Bytes, _wl_block52);
 
																			                  		}
																			                  		else{
																		                  		
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block52Bytes, _wl_block52);
 
																			                  			
																			                  		}
																								}
																								else{
																								
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block57Bytes, _wl_block57);
	
																								}
																					            
            _bw.write(_wl_block58Bytes, _wl_block58);

																					            if(records[50].equalsIgnoreCase("Y")) // For Special Approval
																								{ 
																			                  		if(bean.checkForNull(bean.getTempvalue("special_approved"+order_category),"false").equals("true")){
																								
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 
																			                  		}
																			                  		else{
																		                  		
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block61Bytes, _wl_block61);
 
																			                  			
																			                  		}
																								}
																								else{
																								
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block64Bytes, _wl_block64);
	
																								}
																					            
            _bw.write(_wl_block65Bytes, _wl_block65);

																				              	//out.println("<br>cosign is required"); 
																				                if(records[49].equalsIgnoreCase("Y") || fStatus[1].equalsIgnoreCase("Y"))  // For Cosign Required
																								{ 
																			                  		if(bean.checkForNull(bean.getTempvalue("cosigned"+order_category),"false").equals("true")){
																								
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block68Bytes, _wl_block68);
 
																			                  		}
																			                  		else{
																		                  		
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block68Bytes, _wl_block68);
 
																			                  			
																			                  		}
																								}
																								else{
																								
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block71Bytes, _wl_block71);
	
																								}
																					            
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean.getTempvalue("performing_facility_desc"+records[0])));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bean.getTempvalue("performing_dept_loc_desc"+records[0])));
            _bw.write(_wl_block74Bytes, _wl_block74);
	    			
																					if(billing_interface_yn.equals("Y") && records[38].equals("Y") && !records[43].equals("BT"))
																					{
																						bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+records[0]);
																				
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block79Bytes, _wl_block79);

																					}
																					else{
																							
																				
            _bw.write(_wl_block80Bytes, _wl_block80);

																						}
																				
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block82Bytes, _wl_block82);

																	}
																
            _bw.write(_wl_block83Bytes, _wl_block83);

										        }
									
										    	}
											    else if(order_category.equals("CS")){
											    	String practitioner_type = bean.getPractitionerType();
											    	String order_catalog_code 		= bean.checkForNull(bean.getOrderCatalogCode(previousValues,order_category,practitioner_type),"");
											    	ArrayList PlaceOrdercareSetCount= bean.getPlaceOrderCareSetsCount(bean.checkForNull(order_catalog_code,""),bean.getLoginFacilityId(),bean.getEncounterId(),bean.getPatientClass(),bean.getVisitAdmDate(),bean.getDischargeDateTime(),order_category);
											    	
											    	String billing_order_set_details[] = bean.getOrderSetBillDetails(order_catalog_code);
													String order_set_bill_yn = bean.checkForNull(billing_order_set_details[1],"N");
													String care_set_catalog_desc = bean.checkForNull(billing_order_set_details[0],"");
													String charge_yn = bean.checkForNull(billing_order_set_details[2],"");
													ArrayList PlaceOrderItems 		= null;
													String[] care_set_group			= null;
													ArrayList PlaceOrderSetItems 	= null;
													String order_set_order_catalog	= "";
													String order_type_catalog 		= "";
													if(charge_yn.equalsIgnoreCase("N"))
													{
														order_set_bill_yn = "N";
													}
													//Compute Total Count of Orders in the OrderSet
													int careSetOrdCount = 0;
													if(PlaceOrdercareSetCount!=null)				 // Main Query, where the count and grouping will be get
													{
														
														for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
														{
															String[] care_set_count 		= null;
															care_set_count = (String[])PlaceOrdercareSetCount.get(t);	
															careSetOrdCount = careSetOrdCount + Integer.parseInt(care_set_count[0]);
														}
													}
													  
													
												
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(order_category_desc ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(careSetOrdCount ));
            _bw.write(_wl_block94Bytes, _wl_block94);

																									if(billing_interface_yn.equals("Y") && order_set_bill_yn.equalsIgnoreCase("Y") && !order_category.equals("BT"))
																									{
																										bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(bean.getPatientId()+bean.getEncounterId()+order_catalog_code);
																								
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("total_payable"),"0.0")));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean.checkForNull((String)bill_dtls.get("patient_payable"),"0.0")));
            _bw.write(_wl_block99Bytes, _wl_block99);

																									}
																									else{
																								
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_category.toLowerCase()));
            _bw.write(_wl_block102Bytes, _wl_block102);
				
																										}
																								
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block104Bytes, _wl_block104);
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(order_category ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block109Bytes, _wl_block109);

													if(PlaceOrdercareSetCount!=null) // Main Query, where the count and grouping will be get
													{
													
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block111Bytes, _wl_block111);

																	for(int t=0; t<PlaceOrdercareSetCount.size(); t++)
																	{
																		String[] care_set_count 		= null;
																		care_set_count = (String[])PlaceOrdercareSetCount.get(t);	
																		
																		String time_frame = "";
																		PlaceOrderSetItems	= bean.getPlaceOrderCareSets(bean.checkForNull(order_catalog_code,""),care_set_count[1],time_frame);
																		for(int k=0;k<PlaceOrderSetItems.size();k++)			// or for the count
																		{
																			care_set_group 			= (String[])PlaceOrderSetItems.get(k);
																			order_set_order_catalog =order_set_order_catalog+ "'"+care_set_group[2]+"',";  //Order_catalog_code
																		    order_type_catalog 		= order_type_catalog+"'"+care_set_group[2]+ "'||'"+care_set_group[4]+"','"+ (k+1) + "',";
																		}
																		if(order_set_order_catalog.length() > 0)
																			order_set_order_catalog = order_set_order_catalog.substring(0, order_set_order_catalog.length()-1);
																		if(order_type_catalog.length() > 0)
																			order_type_catalog = order_type_catalog.substring(0, order_type_catalog.length()-1);
																		PlaceOrderItems = bean.getPlaceOrdersResult(bean.checkForNull(order_type_catalog,"''"),bean.checkForNull(care_set_count[1],""),bean.checkForNull(order_set_order_catalog,"''"),""); // Last parameter to identify normalOE or from preview
																		if(PlaceOrderItems!=null&&PlaceOrderItems.size()>0)
																		{
																	
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf((String)hmOrderCategory.get(bean.checkForNull(care_set_count[1],"")) ));
            _bw.write(_wl_block113Bytes, _wl_block113);

																			for(int i=0; i<PlaceOrderItems.size(); i++)
																			{
																				records		= (String[])PlaceOrderItems.get(i);
																	
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.getTempvalue("order_type_code"+order_catalog_code) ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(records[1]));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(bean.getTempvalue("start_date_time"+records[0])));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(bean.getTempvalue("performing_facility_desc"+records[0])));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bean.getTempvalue("performing_dept_loc_desc"+records[0])));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(records[0]));
            _bw.write(_wl_block120Bytes, _wl_block120);

																			}
																			order_set_order_catalog = ""; // Remove the values
																			order_type_catalog			 = ""; // Remove the values
																		}
																	}
																	
            _bw.write(_wl_block121Bytes, _wl_block121);

																	
														}
													}
												}
											}
									else{
									
            _bw.write(_wl_block122Bytes, _wl_block122);
 } 
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block124Bytes, _wl_block124);
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
